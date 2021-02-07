package com.github.thevelislavkolesnichenko.movieproject.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;

public class Movie implements Parcelable {
    private int year;
    private String title;
    private String director;
    private String genre;
    private ArrayList<Float> ratings;

    public Movie(int year, String title, String director, String genre) {
        this.year = year;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.ratings = new ArrayList<>(1);
    }

    protected Movie(Parcel in) {
        year = in.readInt();
        title = in.readString();
        director = in.readString();
        genre = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public float getRating() {
        float avg = 0;
        for (float f : ratings) {
            avg += f;
        }
        return avg / ratings.size();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(float rating) {
        this.ratings.add(rating);
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(year);
        dest.writeString(title);
        dest.writeString(director);
        dest.writeString(genre);
    }
}
