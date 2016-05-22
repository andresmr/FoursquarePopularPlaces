package com.andresmr.foursquarepopularplaces.presenter;

import android.util.Log;

import com.andresmr.foursquarepopularplaces.Interactor.SearchVenueInteractor;
import com.andresmr.foursquarepopularplaces.Interactor.SearchVenueInteractorImpl;
import com.andresmr.foursquarepopularplaces.R;
import com.andresmr.foursquarepopularplaces.VenuesRequestListener;
import com.andresmr.foursquarepopularplaces.pojo.FourSquareResponse;
import com.andresmr.foursquarepopularplaces.view.SearchVenueView;

import java.util.List;

/**
 * Created by Andy on 22/05/2016.
 * FoursquarePopularPlaces
 */
public class SearchVenuesPresenterImpl implements SearchVenuesPresenter, VenuesRequestListener {

    SearchVenueView mView;
    SearchVenueInteractor mInteractor;

    public SearchVenuesPresenterImpl(SearchVenueView searchVenueView){

        this.mView = searchVenueView;
        mInteractor = new SearchVenueInteractorImpl();
    }

    @Override
    public void onSearchButtonClick() {

        if(mView.getQuery().isEmpty()){

            mView.setQueryError(R.string.empty_field);
        }
        else{

            mInteractor.requestVenuesByLocation(mView.getQuery(), this);
        }
    }

    @Override
    public void onGetVenuesSuccessful(List<FourSquareResponse> fourSquareResponseList) {

        for (FourSquareResponse fourSquareResponse : fourSquareResponseList){

            Log.d("RESULT", fourSquareResponse.getVenue().getName());
        }

        /* String[] venuesName = new String[fourSquareResponseArray.length];

                for (int i=0; i<fourSquareResponseArray.length; i++) {

                    venuesName[i] = fourSquareResponseArray[i].getVenue().getName();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, android.R.id.text1, venuesName);

                lstResults.setAdapter(adapter);*/

        //List<FourSquareResponse> lList = Arrays.asList(fourSquareResponseArray);
    }

    @Override
    public void onGetVenuesError() {

    }
}
