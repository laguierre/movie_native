package com.example.movienative;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapterMovie extends BaseAdapter {

    Context context;
    String[] titleMovie;
    String[] originalTitleMovie;
    int[] imageUrl;
    String[] voteAverage;
    LayoutInflater inflater;

    public CustomBaseAdapterMovie(Context context, String[] titleMovie, String[] voteAverage, String[] originalTitle, int[] imageUrl){
        this.context = context;
        this.voteAverage = voteAverage;
        this.originalTitleMovie = originalTitle;
        this.titleMovie = titleMovie;
        this.imageUrl = imageUrl;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return titleMovie.length;
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

        title.setText(titleMovie[i]);
        originalTitle.setText(originalTitleMovie[i]);
        rating.setText(voteAverage[i]);
        moviePoster.setImageResource(imageUrl[i]);
        return view;
    }
}
