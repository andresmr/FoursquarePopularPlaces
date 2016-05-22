package com.andresmr.foursquarepopularplaces.listener;

import com.andresmr.foursquarepopularplaces.pojo.FourSquareResponse;

import java.util.List;

/**
 * Created by Andy on 22/05/2016.
 * FoursquarePopularPlaces
 */
public interface VenuesRequestListener {

    void onGetVenuesSuccessful(List<FourSquareResponse> fourSquareResponseList);
    void onGetVenuesError();
}
