package com.github.thevelislavkolesnichenko.movieproject.listenner;

import com.github.thevelislavkolesnichenko.movieproject.models.Movie;

public interface OnAddMovieListener {
    void onAddMovie(Movie movie);
    void onLoadEditDialog(Movie movie, int position);
    void onEditMovie(Movie movie, int position);
}
