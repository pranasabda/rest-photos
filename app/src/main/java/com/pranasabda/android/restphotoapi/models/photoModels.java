package com.pranasabda.android.restphotoapi.models;

/**
 * Created by prana on 03/01/18.
 */

public class photoModels {

    private String albumId;
    private String id;
    private String title;
    private String url;
    private String thumbnailUrl;

    //generate getter dengan klik kanan pilih generate atau alt+insert
    public String getAlbumId() {
        return albumId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
