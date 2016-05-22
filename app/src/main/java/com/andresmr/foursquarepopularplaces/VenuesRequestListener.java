package com.andresmr.foursquarepopularplaces;

import com.andresmr.foursquarepopularplaces.pojo.FourSquareResponse;

/**
 * Created by Andy on 22/05/2016.
 * FoursquarePopularPlaces
 */
public interface VenuesRequestListener {

    void onGetVenuesSuccessful(FourSquareResponse[] fourSquareResponseArray);
    void onGetVenuesError(Throwable throwable);
}
