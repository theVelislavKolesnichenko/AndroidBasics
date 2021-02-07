package com.github.thevelislavkolesnichenko.movieproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.movieproject.AddDialogFragment;
import com.github.thevelislavkolesnichenko.movieproject.R;
import com.github.thevelislavkolesnichenko.movieproject.listenner.OnAddMovieListener;
import com.github.thevelislavkolesnichenko.movieproject.models.Movie;
import com.github.thevelislavkolesnichenko.movieproject.viewholder.MovieViewHolder;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private ArrayList<Movie> movies;
    Context context;
    OnAddMovieListener listener;
    public MovieAdapter(ArrayList<Movie> movies, OnAddMovieListener listener) {
        this.movies = movies;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.movie_item, parent, false);

        MovieViewHolder viewHolder = new MovieViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {
        final Movie movie = movies.get(position);

        holder.setDirector(movie.getDirector());
        holder.setGenre(movie.getGenre());
        holder.setTitle(movie.getTitle());
        holder.setYear(Integer.toString(movie.getYear()));
        //holder.setRatingBar(movie.getRating());

        holder.setDeleteListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movies.remove(position);
                notifyItemRemoved(position);
            }
        });
        holder.setEditListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onLoadEditDialog(movies.get(position), position);
            }
        });
        holder.setRatingBarListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Movie movie = movies.get(position);
                movie.setRating(rating);

                //notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void add(Movie movie) {
        movies.add(0, movie);
        notifyItemInserted(0);
    }

    public void change(Movie movie, int position) {
        movies.set(position, movie);
        notifyItemChanged(position);
    }
}
