package com.andresmr.foursquarepopularplaces.pojo;

import java.util.List;

/**
 * Created by Andy on 22/05/2016.
 * FoursquarePopularPlaces
 */
public class FourSquareResponse {

    Venue venue;
    List<Tip> tips;

    public FourSquareResponse(){}

    public FourSquareResponse(Venue venue, List<Tip> tips){

        this.venue = venue;
        this.tips = tips;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Tip> getTips() {
        return tips;
    }

    public void setTips(List<Tip> tips) {
        this.tips = tips;
    }
}
