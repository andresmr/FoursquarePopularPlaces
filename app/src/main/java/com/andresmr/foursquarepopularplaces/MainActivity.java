package com.andresmr.foursquarepopularplaces;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.andresmr.foursquarepopularplaces.adapter.VenueListAdapter;
import com.andresmr.foursquarepopularplaces.pojo.FourSquareResponse;
import com.andresmr.foursquarepopularplaces.presenter.SearchVenuesPresenter;
import com.andresmr.foursquarepopularplaces.presenter.SearchVenuesPresenterImpl;
import com.andresmr.foursquarepopularplaces.view.SearchVenueView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements SearchVenueView {

    @BindView(R.id.etSearch)
    EditText etSearch;

    @OnClick(R.id.btnSearch)
    void onBtnSearchClick(){

        mPresenter.onSearchButtonClick();
    }

    @BindView(R.id.lstResults)
    ListView lstResults;

    SearchVenuesPresenter mPresenter;
    VenueListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mPresenter = new SearchVenuesPresenterImpl(this);
    }

    @Override
    public String getQuery() {

        return etSearch.getText().toString();
    }

    @Override
    public void setQueryError(int error) {

        etSearch.requestFocus();
        etSearch.setError(getString(error));
    }

    @Override
    public void hideKeyboard() {

        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void showResults(List<FourSquareResponse> fourSquareResponseList) {

        adapter = new VenueListAdapter(getApplicationContext(), fourSquareResponseList);

        lstResults.setAdapter(adapter);
    }

    @Override
    public void showNoResults() {

        lstResults.setAdapter(null);

        Toast.makeText(getApplicationContext(), getString(R.string.no_results), Toast.LENGTH_LONG).show();
    }
}
