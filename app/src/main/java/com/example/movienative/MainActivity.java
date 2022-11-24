package com.example.movienative;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {
    public static final String MOVIE_TITLE = "movie title";
    public static final String MOVIE_ORIGINAL_TITLE = "original movie title";
    public static final String URL_IMAGE = "0";
    public static final String BRIEF_MOVIE = "brief movie";
    public static final String AVERAGE_VOTE = "average vote";




    private ListView lvMovies;
    private String[] moviesTitle = {"Avatar: El camino del agua", "Black Adam", "Thor: \nAmor y True", "Black Panther: Wakanda Para siempre", "Smile"};
    private String[] moviesOriginalTitle = {"Avatar: The way of water", "Black Adam", "Thor: Love and Thunder", "Black Panther: Wakanda Forever", "Smile"};
    private String[] averageVote = {"8.9", "7.5", "7.9", "7.3", "6.8"};
    private String[] briefMovie = {"8.9", "7.5", "7.9", "7.3", "6.8"};

    private int[] imageMovies = {R.drawable.avatar2, R.drawable.blackadam, R.drawable.thor, R.drawable.wakanda, R.drawable.smile};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable customBarColor
                = new ColorDrawable(Color.parseColor("#FCA311"));
        actionBar.setBackgroundDrawable(customBarColor);
        lvMovies = (ListView) findViewById(R.id.listViewMovies);

        CustomBaseAdapterMovie customBaseAdapterMovie = new CustomBaseAdapterMovie(getApplicationContext(), moviesTitle, averageVote, moviesOriginalTitle, imageMovies);
        lvMovies.setAdapter(customBaseAdapterMovie);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String mensaje = lvMovies.getItemAtPosition(i) + "voto: " + averageVote[i];
                Log.i("Click", mensaje);
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(view.getContext(), DetailsMovie.class);
                intent.putExtra(MOVIE_TITLE, moviesTitle[i]);
                intent.putExtra(MOVIE_ORIGINAL_TITLE, moviesOriginalTitle[i]);
                intent.putExtra(URL_IMAGE, imageMovies[i]);
                intent.putExtra(AVERAGE_VOTE, averageVote[i]);
                intent.putExtra(BRIEF_MOVIE, briefMovie[i]);
                startActivity(intent);
            }
        });
    }
}