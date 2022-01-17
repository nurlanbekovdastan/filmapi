package com.example.kino.ui.films_detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.kino.App;
import com.example.kino.R;
import com.example.kino.data.models.Film;
import com.example.kino.databinding.FragmentFilmsDetailBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmsDetailFragment extends Fragment {
    private FragmentFilmsDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inquiry();

    }

    private void inquiry() {
        String id = getArguments().getString("id");
        App.api.getFilmById(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Film film = response.body();
                    binding.title.setText(film.getTitle());
                    binding.description.setText(film.getDescription());
                    binding.director.setText(film.getDirector());
                    binding.producer.setText(film.getProducer());
                    binding.releaseDate.setText(film.getReleaseDate());
                    Glide.with(binding.image).load(film.getMovieBanner()).into(binding.image);

                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });

    }
}