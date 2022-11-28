package com.example.movienative;

import java.io.Serializable;

public class MovieClass implements Serializable {
    String movieTitle;
    String originalTitle;
    String movieRating;
    int imageUrl;
    CastMovieClass cast;
    String brief;

    public MovieClass(String movieTitle, String originalTitle, String movieRating, int imageUrl, CastMovieClass cast, String brief) {
        this.movieRating = movieRating;
        this.originalTitle = originalTitle;
        this.movieTitle = movieTitle;
        this.imageUrl = imageUrl;
        this.brief = brief;
        this.cast = cast;
    }

    public String getMovieTitle() {
        return this.movieTitle;
    }

    public String getMovieRating() {
        return this.movieRating;
    }

    public int getImageUrl() {
        return this.imageUrl;
    }

    public String getMovieBrief() {
        return this.brief;
    }

    public CastMovieClass getMovieCast() {
        return this.cast;
    }
    public String getOriginalTitle() {
        return this.originalTitle;
    }
    public String getAverageVote(){return this.movieRating;}
}


