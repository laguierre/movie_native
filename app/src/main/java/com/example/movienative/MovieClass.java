package com.example.movienative;

public class MovieClass {
    String movieTitle;
    double movieRating;
    String imageUrl;
    CastMovieClass cast[];
    String brief;

    public MovieClass(String movieTitle, double movieRating, String imageUrl, CastMovieClass[] cast, String brief) {
        this.movieRating = movieRating;
        this.movieTitle = movieTitle;
        this.imageUrl = imageUrl;
        this.brief = brief;
        this.cast = cast;
    }
    public String getMovieTitle(){
        return this.movieTitle;
    }
    public double getMovieRating(){
        return this.movieRating;
    }
    public String getImageUrl(){
        return this.imageUrl;
    }
    public String getMovieBrief(){
        return this.brief;
    }
    public CastMovieClass[] getMovieCast(){
        return this.cast;
    }
}


