package com.andresmr.foursquarepopularplaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.andresmr.foursquarepopularplaces.Service.RestService;
import com.andresmr.foursquarepopularplaces.pojo.FourSquareResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etSearch)
    EditText etSearch;
    @OnClick(R.id.btnSearch)
    void onBtnSearchClick(){

        restService.exploreVenues(etSearch.getText().toString(), new VenuesRequestListener() {
            @Override
            public void onGetVenuesSuccessful(FourSquareResponse[] fourSquareResponseArray) {

                String[] venuesName = new String[fourSquareResponseArray.length];

                for (int i=0; i<fourSquareResponseArray.length; i++) {

                    venuesName[i] = fourSquareResponseArray[i].getVenue().getName();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, android.R.id.text1, venuesName);

                lstResults.setAdapter(adapter);

                //List<FourSquareResponse> lList = Arrays.asList(fourSquareResponseArray);
            }

            @Override
            public void onGetVenuesError(Throwable throwable) {

            }
        });
    }
    @BindView(R.id.lstResults)
    ListView lstResults;

    RestService restService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        restService = new RestService();
    }
}
