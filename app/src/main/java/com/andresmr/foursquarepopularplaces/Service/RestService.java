package com.andresmr.foursquarepopularplaces.service;

import com.andresmr.foursquarepopularplaces.listener.VenuesRequestListener;
import com.andresmr.foursquarepopularplaces.pojo.FourSquareResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andy on 22/05/2016.
 * FoursquarePopularPlaces
 */
public class RestService {

    private static final String CLIENT_ID = "GLZHBOBR0XIQOWEXIWBLC0ZDD1CFTPPGJBW310YG5BBLCRJX";
    private static final String CLIENT_SECRET = "NXGWTTRJPTCMOZ2IPEIWJYSZVU3SZKSNJCUALHLDFIEHNVDH";
    private static final String BASE_URL = "https://api.foursquare.com";
    private static final String API_VERSION = "v2";
    private static final String BUNDLE_VERSION = "20130815";

    Service service;

    /**
     * Service creation with custom Gson Serializer to get only needed info from the API
     */
    public RestService(){

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(FourSquareResponse[].class, new VenuesResponseDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service =  retrofit.create(Service.class);
    }

    /**
     * Performs a GET request to Foursquare API
     * @param near place or location introduced by the user
     * @param listener request callback successful or error
     */
    public void exploreVenues(String near, final VenuesRequestListener listener){

        Call<FourSquareResponse[]> call = service.exploreVenues(
                API_VERSION,
                CLIENT_ID,
                CLIENT_SECRET,
                BUNDLE_VERSION,
                near);

        call.enqueue(new Callback<FourSquareResponse[]>() {
            @Override
            public void onResponse(Call<FourSquareResponse[]> call, Response<FourSquareResponse[]> response) {

                //If whe don´t get any response, returns an error, if not parse response as a List
                if(response.body()!= null){

                    List<FourSquareResponse> fourSquareResponseList = Arrays.asList(response.body());

                    listener.onGetVenuesSuccessful(fourSquareResponseList);
                }
                else{

                    listener.onGetVenuesError();
                }
            }

            @Override
            public void onFailure(Call<FourSquareResponse[]> call, Throwable t) {

                listener.onGetVenuesError();
            }
        });
    }
}