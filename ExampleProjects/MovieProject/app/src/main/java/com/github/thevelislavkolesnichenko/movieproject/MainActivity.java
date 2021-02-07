package com.github.thevelislavkolesnichenko.movieproject;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.thevelislavkolesnichenko.movieproject.adapters.MovieAdapter;
import com.github.thevelislavkolesnichenko.movieproject.datastorage.MovieSource;
import com.github.thevelislavkolesnichenko.movieproject.listenner.OnAddMovieListener;
import com.github.thevelislavkolesnichenko.movieproject.models.Movie;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements OnAddMovieListener {

    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(MovieSource.getMovies(10), this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDialogFragment dialogFragment = AddDialogFragment.getInstance(null, 0,true);
                dialogFragment.show(getSupportFragmentManager(), "add_fragmen_dialog");
            }
        });
    }

    @Override
    public void onAddMovie(Movie movie) {
        adapter.add(movie);
    }

    @Override
    public void onLoadEditDialog(Movie movie, int position) {
        AddDialogFragment dialogFragment = AddDialogFragment.getInstance(movie, position,false);
        dialogFragment.show(getSupportFragmentManager(), "add_fragmen_dialog");
    }

    @Override
    public void onEditMovie(Movie movie, int position) {
        adapter.change(movie, position);
    }
}
