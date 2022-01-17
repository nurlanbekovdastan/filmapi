package com.example.kino;

import android.app.Application;

import com.example.kino.data.remode.FilmApi;
import com.example.kino.data.remode.RetrofitClient;

import retrofit2.Retrofit;

public class App extends Application {
    private RetrofitClient retrofitClient;
    public static FilmApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideFilmApi();
    }
}
