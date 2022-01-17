package com.example.kino.data.remode;

import com.example.kino.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface FilmApi {
    @GET("/films")
    Call<List<Film>> getFilm();

    @GET("/films/{id}")
    Call<Film> getFilmById(
            @Path("id")
            String id
            );
}
