package com.example.movienative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;

public class DetailsMovie extends AppCompatActivity {
    private TextView tvMovieTitle;
    private ImageView ivImage;
    private TextView tvOriginalTitle;
    private TextView tvBriefMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);

        tvMovieTitle = (TextView) findViewById(R.id.tvTitleMovie);
        tvOriginalTitle = (TextView) findViewById(R.id.tvOriginalMovie);
        tvBriefMovie = (TextView) findViewById(R.id.tvBrief);
        ivImage = (ImageView) findViewById(R.id.ivPosterMovie);

        Intent intent = getIntent();
        String titleMovie = intent.getStringExtra(MainActivity.MOVIE_TITLE);
        String brief = intent.getStringExtra(MainActivity.BRIEF_MOVIE);
        String originalTitle = intent.getStringExtra(MainActivity.MOVIE_ORIGINAL_TITLE);
        int urlPoster = Integer.parseInt(intent.getStringExtra(MainActivity.URL_IMAGE));
        tvMovieTitle.setText(titleMovie);
        tvOriginalTitle.setText(originalTitle);
        tvBriefMovie.setText(intent.getStringExtra(MainActivity.URL_IMAGE));
        ivImage.setImageResource(urlPoster);
    }
}