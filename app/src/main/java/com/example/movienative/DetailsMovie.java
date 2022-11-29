package com.example.movienative;

import static com.example.movienative.MainActivity.SELECTED_MOVIE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class DetailsMovie extends AppCompatActivity {
    private ImageView ivImage;
    private TextView tvMovieTitle, tvOriginalTitle, tvBriefMovie, tvRating;
    private ImageButton buttonBack;
    private ListView lvCastMovie;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);

        //Eliminate APPBAR//
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS , WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        tvMovieTitle = (TextView) findViewById(R.id.tvTitleMovie);
        tvOriginalTitle = (TextView) findViewById(R.id.tvOriginalMovie);
        tvBriefMovie = (TextView) findViewById(R.id.tvBrief);
        tvRating = (TextView) findViewById(R.id.tvRating);
        ivImage = (ImageView) findViewById(R.id.ivPosterMovie);
        buttonBack = (ImageButton) findViewById(R.id.buttonBack);
        recyclerView = (RecyclerView) findViewById(R.id.rvDetailsMovie);

        Intent intent = getIntent();
        MovieClass movie = (MovieClass) intent.getSerializableExtra(SELECTED_MOVIE);

        tvMovieTitle.setText(movie.getMovieTitle());
        tvOriginalTitle.setText(movie.getOriginalTitle());
        tvBriefMovie.setText(movie.getMovieBrief());
        tvRating.setText(movie.getMovieRating());
        ivImage.setImageResource(movie.getImageUrl());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CustomBaseAdapterCast(movie.cast.getActorName(), movie.cast.getActorImageUrl()));

        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DetailsMovie.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}