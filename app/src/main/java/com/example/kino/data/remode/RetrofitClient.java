package com.example.kino.data.remode;

import java.util.GregorianCalendar;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private Retrofit retrofit = new Retrofit.Builder().baseUrl("https://ghibliapi.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public FilmApi provideFilmApi(){
        return retrofit.create(FilmApi.class);
    }
}
