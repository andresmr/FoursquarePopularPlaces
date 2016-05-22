package com.andresmr.foursquarepopularplaces.presenter;

import com.andresmr.foursquarepopularplaces.interactor.SearchVenueInteractor;
import com.andresmr.foursquarepopularplaces.interactor.SearchVenueInteractorImpl;
import com.andresmr.foursquarepopularplaces.R;
import com.andresmr.foursquarepopularplaces.listener.VenuesRequestListener;
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

        mView.hideKeyboard();
        mView.showResults(fourSquareResponseList);
    }

    @Override
    public void onGetVenuesError() {

        mView.hideKeyboard();
        mView.showNoResults();
    }
}