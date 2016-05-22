package com.andresmr.foursquarepopularplaces.service;

import com.andresmr.foursquarepopularplaces.pojo.FourSquareResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Andy on 22/05/2016.
 * FoursquarePopularPlaces
 */
public interface Service {

    @GET("/{version}/venues/explore")
    Call<FourSquareResponse[]> exploreVenues(
            @Path("version") String version,
            @Query("client_id") String id,
            @Query("client_secret") String secret,
            @Query("v") String v,
            @Query("near") String near);
}
