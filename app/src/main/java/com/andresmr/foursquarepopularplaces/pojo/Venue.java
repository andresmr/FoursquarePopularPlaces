package com.andresmr.foursquarepopularplaces.pojo;

/**
 * Created by Andy on 22/05/2016.
 * FoursquarePopularPlaces
 */
public class Venue {

    String id;
    String name;
    Location location;

    public Venue(){};

    public Venue(String id, String name, Location location){

        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}