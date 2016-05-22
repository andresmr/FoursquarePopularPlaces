package com.andresmr.foursquarepopularplaces.Interactor;

import com.andresmr.foursquarepopularplaces.VenuesRequestListener;

/**
 * Created by Andy on 22/05/2016.
 * FoursquarePopularPlaces
 */
public interface SearchVenueInteractor {

    void requestVenuesByLocation(String near, VenuesRequestListener listener);
}
