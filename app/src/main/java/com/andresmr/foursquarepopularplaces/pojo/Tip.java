package com.andresmr.foursquarepopularplaces.pojo;

/**
 * Created by Andy on 22/05/2016.
 * FoursquarePopularPlaces
 */
public class Tip {

    private String id;
    private String photourl;

    public Tip(String id, String photourl) {
        this.id = id;
        this.photourl = photourl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }
}
