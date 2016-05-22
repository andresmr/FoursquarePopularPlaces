package com.andresmr.foursquarepopularplaces.interactor;

import com.andresmr.foursquarepopularplaces.Service.RestService;
import com.andresmr.foursquarepopularplaces.VenuesRequestListener;

/**
 * Created by Andy on 22/05/2016.
 * FoursquarePopularPlaces
 */
public class SearchVenueInteractorImpl implements SearchVenueInteractor{

    RestService restService;

    public SearchVenueInteractorImpl(){

        restService = new RestService();
    }

    @Override
    public void requestVenuesByLocation(String near, VenuesRequestListener listener) {

        restService.exploreVenues(near, listener);
    }
}
