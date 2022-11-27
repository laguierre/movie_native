package com.example.movienative;

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

        /**@brief Eliminate APPBAR*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
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
        String titleMovie = intent.getStringExtra(MainActivity.MOVIE_TITLE);
        String brief = intent.getStringExtra(MainActivity.BRIEF_MOVIE);
        String originalTitle = intent.getStringExtra(MainActivity.MOVIE_ORIGINAL_TITLE);
        String averageVote = intent.getStringExtra(MainActivity.AVERAGE_VOTE);
        int urlPoster = intent.getIntExtra(MainActivity.URL_IMAGE, -1);
        String[] cast = intent.getStringArrayExtra(MainActivity.CAST_MOVIE);
        int[] urlActorPoster = intent.getIntArrayExtra(MainActivity.CAST_MOVIE_PHOTO);

        tvMovieTitle.setText(titleMovie);
        tvOriginalTitle.setText(originalTitle);
        tvBriefMovie.setText(brief);
        tvRating.setText(averageVote);
        ivImage.setImageResource(urlPoster);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CustomBaseAdapterCast(cast, urlActorPoster));

        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DetailsMovie.this
                        , MainActivity.class);
                startActivity(intent);
            }
        });
    }
}