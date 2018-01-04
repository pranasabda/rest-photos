package com.pranasabda.android.restphotoapi.api;


import com.pranasabda.android.restphotoapi.models.photoModels;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by prana on 03/01/18.
 */

public interface RequestInterface {

    @GET("/photos")
    Call<List<photoModels>> getJSON();

}
