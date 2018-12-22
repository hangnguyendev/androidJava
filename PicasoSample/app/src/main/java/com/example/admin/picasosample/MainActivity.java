package com.example.admin.picasosample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;


    final String BASE_URL = "http://45.77.27.89:8088/";//10.0.2.2

    Retrofit retrofit ;

    OnInterface myRetrofitAPI ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.image_view);


        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView);

        final String BASE_URL = "http://45.77.27.89:8088/";

         retrofit = new Retrofit.Builder() .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) .build();

         myRetrofitAPI = retrofit.create(OnInterface.class);

    }

    public void post(View v){
        myRetrofitAPI.postSong(new Song("abcbabcbsfgf","abcbabcbsfgf","abcbabcbsfgf","abcbabcbsfgf"))
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(MainActivity.this,"error"+response.message(),Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"error"+t.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
    }

    public void view(View v){

        myRetrofitAPI.getListSongs().enqueue(new Callback<ListSong>() {
            @Override
            public void onResponse(Call<ListSong> call, Response<ListSong> response) {
                if(response.isSuccessful()){
                    ListSong listSong = response.body();
                    for(int i=0;i<listSong.data.size();i++){
                        Log.d("Data", listSong.data.get(i).song);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"error"+response.message(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListSong> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
