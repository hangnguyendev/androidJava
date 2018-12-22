package com.example.admin.picasosample;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OnInterface {


    @GET("api/hodela/list_song")
    Call<ListSong> getListSongs();

    @POST("api/hodela/add_music")
    Call<Object> postSong(@Body Song m);

}
