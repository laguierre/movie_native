package com.example.movienative;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomBaseAdapterMovie extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    private List<MovieClass> movieList;

    public CustomBaseAdapterMovie(Context context, List<MovieClass> movieList){
        this.context = context;
        this.movieList = movieList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_custom_movie_list_view, null);
        TextView title = (TextView) view.findViewById(R.id.tvMovieName);
        TextView originalTitle = (TextView) view.findViewById(R.id.tvSubName);
        TextView rating = (TextView) view.findViewById(R.id.tvRating);
        ImageView moviePoster = (ImageView) view.findViewById(R.id.imageMoviePoster);

        MovieClass movie = movieList.get(i);
        title.setText(movie.getMovieTitle());
        originalTitle.setText(movie.getOriginalTitle());
        rating.setText(movie.getMovieRating());
        moviePoster.setImageResource(movie.getImageUrl());
        return view;
    }
}
