package com.example.movienative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public static final String MOVIE_TITLE = "movie title";
    public static final String MOVIE_ORIGINAL_TITLE = "original movie title";
    public static final String URL_IMAGE = "0";
    public static final String BRIEF_MOVIE = "brief movie";
    public static final String AVERAGE_VOTE = "average vote";
    public static final String CAST_MOVIE = "cast movie";
    public static final String CAST_MOVIE_PHOTO = "cast movie photo";


    private ListView lvMovies;
    final String[] moviesTitle = {"Avatar: El camino del agua", "Black Adam", "Thor: \nAmor y True", "Black Panther: Wakanda Para siempre", "Smile"};
    final String[] moviesOriginalTitle = {"Avatar: The way of water", "Black Adam", "Thor: Love and Thunder", "Black Panther: Wakanda Forever", "Smile"};
    final String[] averageVote = {"8.9", "7.5", "7.9", "7.3", "6.8"};
    final String brief = "Lorem ipsum dolor sit amet consectetur adipiscing elit sodales cum senectus eget duis cras dictumst luctus, elementum nullam pharetra fusce lacinia condimentum odio rhoncus augue per eu habitasse sagittis sapien. Torquent diam condimentum nullam fermentum mauris non litora, vulputate ligula egestas tempus mi turpis, pulvinar ridiculus semper ultricies iaculis nostra. Nascetur placerat tellus tempor et gravida dis, conubia aliquet eleifend vel id habitasse, imperdiet mattis inceptos natoque ad. Facilisi mi tortor tristique ullamcorper ligula imperdiet class commodo dis tellus, aliquam vitae nec sociosqu scelerisque duis eleifend ridiculus orci posuere, metus cursus laoreet erat purus nascetur molestie dignissim vivamus.\n" +
            "\n" +
            "Natoque rhoncus mus facilisi hac risus gravida non quam, vestibulum tortor eget quisque dui vitae fermentum suspendisse, odio neque blandit faucibus nisl class montes. Massa blandit cubilia lacus platea habitasse iaculis pulvinar mattis tempus vitae erat, convallis nam odio facilisis volutpat tellus aliquet etiam dignissim purus. Quis dictum tortor cum parturient egestas class, conubia lacus quam habitasse potenti senectus lacinia, commodo in molestie condimentum volutpat. Aenean condimentum pretium volutpat lobortis et mus semper scelerisque, arcu duis egestas ut consequat quisque.\n";
    final String[] briefMovie = {brief, brief, brief, brief, brief};
    final int[] imageMovies = {R.drawable.avatar2, R.drawable.blackadam, R.drawable.thor, R.drawable.wakanda, R.drawable.smile};

    final String[][] cast = {
            {"Cliff Curtis", "Kate Winslet", "Sam Worhtington", "Sigourney Weaver", "Stephen Lang", "Zoe Saldana"},
            {"Aldis Hodge", "Dwayne Johnson", "Marwan Kenzari", "Noah Centineo", "Quintessa Swindell", "Sarah Shahi"},
            {"Chris Hemsworth", "Christian Bale", "Jaimie Alexander", "Natalie Portman", "Taika Waititi", "Tessa Thompson"},
            {"Danai Gurira", "Dominique Thorne", "Letitia Wright", "Lupita N'yong", "Winston Duke"},
            {"Caitlin Stasey", "Jessie T. Usher", "Kal Penn", "Kyle Gallner", "Sosie Bacon"}
    };

    final int[][] castMovieUrl = {
            {R.drawable.av2_cliff_curtis, R.drawable.av2_kate_winslet, R.drawable.av2_sam_worthington, R.drawable.av2_sigourney_weaver, R.drawable.av2_stephen_lang, R.drawable.av2_zoe_saldana},
            {R.drawable.ba_aldis_hodge, R.drawable.ba_dwayne_johnson, R.drawable.ba_marwan_kenzari, R.drawable.ba_noah_centineo, R.drawable.ba_quintessa_swindell, R.drawable.ba_sarah_shahi},
            {R.drawable.th2_chris_hemsworth, R.drawable.th2_christian_bale, R.drawable.th2_jaimie_alexander, R.drawable.th2_natalie_portman,  R.drawable.th2_taika_waititi, R.drawable.th2_tessa_thompson},
            {R.drawable.wk_danai_gurira, R.drawable.wk_dominique_thorne, R.drawable.wk_letitia_wright, R.drawable.wk_lupita_nyong, R.drawable.wk_winston_duke},
            {R.drawable.sm_caitlin_stasey, R.drawable.sm_jessie_t_usher, R.drawable.sm_kal_penn, R.drawable.sm_kyle_gallner, R.drawable.sm_sosie_bacon}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        lvMovies = (ListView) findViewById(R.id.listViewMovies);
        CustomBaseAdapterMovie customBaseAdapterMovie = new CustomBaseAdapterMovie(getApplicationContext(), moviesTitle, averageVote, moviesOriginalTitle, imageMovies);
        lvMovies.setAdapter(customBaseAdapterMovie);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), DetailsMovie.class);
                intent.putExtra(MOVIE_TITLE, moviesTitle[i]);
                intent.putExtra(MOVIE_ORIGINAL_TITLE, moviesOriginalTitle[i]);
                intent.putExtra(URL_IMAGE, imageMovies[i]);
                intent.putExtra(AVERAGE_VOTE, averageVote[i]);
                intent.putExtra(BRIEF_MOVIE, briefMovie[i]);
                String[] castMovie = cast[i];
                int[] castPhotos = castMovieUrl[i];
                intent.putExtra(CAST_MOVIE, castMovie);
                intent.putExtra(CAST_MOVIE_PHOTO, castPhotos);
                startActivity(intent);
            }
        });
    }
}