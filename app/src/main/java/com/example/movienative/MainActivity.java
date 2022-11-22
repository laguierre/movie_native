package com.example.movienative;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ListView lvMovies;
    private String[] moviesTitle = {"Avatar: El camino del agua", "Black Adam", "Thor: \nAmor y True", "Black Panther: Wakanda Para siempre", "Smile"};
    private String[] moviesOriginalTitle = {"Avatar: The way of water", "Black Adam", "Thor: Love and Thunder", "Black Panther: Wakanda Forever", "Smile"};
    private String[] averageVote = {"8.9", "7.5", "7.9", "7.3", "6.8"};

    private int[] imageMovies = {0, 0, 0, 0, 0, 0};

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
        int x = getResources().getIdentifier("avatar2", "avatar2/avatar2", getPackageName());
        Log.i("image", "Image: " + String.valueOf(x));

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String mensaje = lvMovies.getItemAtPosition(i) + "voto: " + averageVote[i];
                Log.i("Click", mensaje);
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
}