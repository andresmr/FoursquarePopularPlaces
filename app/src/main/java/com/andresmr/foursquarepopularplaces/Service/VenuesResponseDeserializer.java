package com.andresmr.foursquarepopularplaces.service;

import com.andresmr.foursquarepopularplaces.pojo.FourSquareResponse;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Andy on 22/05/2016.
 * FoursquarePopularPlaces
 */
public class VenuesResponseDeserializer implements JsonDeserializer<FourSquareResponse[]> {

    @Override
    public FourSquareResponse[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonElement jsonElement = json.getAsJsonObject().get("response").
                getAsJsonObject().get("groups").getAsJsonArray().get(0).getAsJsonObject().get("items");

        return new Gson().fromJson(jsonElement, FourSquareResponse[].class);
    }
}
