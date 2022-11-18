package com.example.movienative;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ListView lvMovies;
    private String[] movies = {"Avatar 2", "Black Adam", "Thor: Love and Thunder", "Black Panther: Wakanda Forever", "Smile"};
    private String[] averageVote = {"8.9", "7.5", "7.9", "7.3", "6.8"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable customBarColor
                = new ColorDrawable(Color.parseColor("#FCA311"));
        actionBar.setBackgroundDrawable(customBarColor);
        lvMovies = (ListView)  findViewById(R.id.listViewMovies);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview_item_movie, movies){
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setBackgroundColor((position));
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                return textView;
        }};
        lvMovies.setAdapter(adapter);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String mensaje = "El" + lvMovies.getItemAtPosition(i) + "precio $ " + averageVote[i];
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
}