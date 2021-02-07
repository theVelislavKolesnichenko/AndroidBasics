package com.github.thevelislavkolesnichenko.movieproject.datastorage;

import com.github.thevelislavkolesnichenko.movieproject.models.Movie;

import java.util.ArrayList;
import java.util.Random;

public class MovieSource {
    public static ArrayList<Movie> getMovies(int count) {
        ArrayList<Movie> movies = new ArrayList<>();

        for(int i=0; i < count; i++) {
            movies.add(new Movie(new Random().nextInt(121) + 1900, "Title" + i, "Director" + i, "Genre" + i));
        }

        return movies;
    }
}
