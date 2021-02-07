package com.github.thevelislavkolesnichenko.movieproject;


import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.thevelislavkolesnichenko.movieproject.listenner.OnAddMovieListener;
import com.github.thevelislavkolesnichenko.movieproject.models.Movie;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddDialogFragment extends DialogFragment implements View.OnClickListener {

    private EditText year, title, director, genre;
    private Button button;
    private boolean flag;
    private int position;

    private OnAddMovieListener listener;

    public AddDialogFragment() {
        // Required empty public constructor
    }

    public static AddDialogFragment getInstance(Movie movie, int position, boolean flag) {
        AddDialogFragment fragment = new AddDialogFragment();

        Bundle args = new Bundle();
        args.putParcelable("movie", movie);
        args.putBoolean("add", flag);
        args.putInt("position", position);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        year = view.findViewById(R.id.editText4);
        title = view.findViewById(R.id.editText);
        director = view.findViewById(R.id.editText3);
        genre = view.findViewById(R.id.editText2);

        button = view.findViewById(R.id.button3);
        button.setOnClickListener(this);

        Movie movie = getArguments().getParcelable("movie");
        if(movie != null) {
            year.setText(Integer.toString(movie.getYear()));
            title.setText(movie.getTitle());
            director.setText(movie.getDirector());
            genre.setText(movie.getGenre());
        }

        flag = getArguments().getBoolean("add");
        button.setText(flag ? "Add" : "Edit");

        position = getArguments().getInt("position");

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnAddMovieListener) context;
    }

    @Override
    public void onClick(View v) {

        int year = Integer.parseInt(this.year.getText().toString());
        String title = this.title.getText().toString();
        String director = this.director.getText().toString();
        String genre = this.genre.getText().toString();

        Movie movie = new Movie(year, title, director, genre);

        if(flag) {
            listener.onAddMovie(movie);
        } else {
            listener.onEditMovie(movie, position);
        }


        dismiss();
    }
}
