package com.andresmr.foursquarepopularplaces.view;

import com.andresmr.foursquarepopularplaces.pojo.FourSquareResponse;

import java.util.List;

/**
 * Created by Andy on 22/05/2016.
 * FoursquarePopularPlaces
 */
public interface SearchVenueView {

    String getQuery();
    void setQueryError(int error);

    void hideKeyboard();

    void showResults(List<FourSquareResponse> fourSquareResponseList);
    void showNoResults();
}
