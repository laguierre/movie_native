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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String MOVIE_TITLE = "movie title";
    public static final String MOVIE_ORIGINAL_TITLE = "original movie title";
    public static final String URL_IMAGE = "0";
    public static final String BRIEF_MOVIE = "brief movie";
    public static final String AVERAGE_VOTE = "average vote";
    public static final String CAST_MOVIE = "cast movie";
    public static final String CAST_MOVIE_PHOTO = "cast movie photo";


    private ListView lvMovies;
    List<MovieClass> movieList = new ArrayList<>();

    //final String[] moviesTitle = {"Avatar: El camino del agua", "Black Adam", "Thor: \nAmor y True", "Black Panther: Wakanda Para siempre", "Smile"};
    //final String[] moviesOriginalTitle = {"Avatar: The way of water", "Black Adam", "Thor: Love and Thunder", "Black Panther: Wakanda Forever", "Smile"};
    //final String[] averageVote = {"8.9", "7.5", "7.9", "7.3", "6.8"};
    /*final String brief = "Lorem ipsum dolor sit amet consectetur adipiscing elit sodales cum senectus eget duis cras dictumst luctus, elementum nullam pharetra fusce lacinia condimentum odio rhoncus augue per eu habitasse sagittis sapien. Torquent diam condimentum nullam fermentum mauris non litora, vulputate ligula egestas tempus mi turpis, pulvinar ridiculus semper ultricies iaculis nostra. Nascetur placerat tellus tempor et gravida dis, conubia aliquet eleifend vel id habitasse, imperdiet mattis inceptos natoque ad. Facilisi mi tortor tristique ullamcorper ligula imperdiet class commodo dis tellus, aliquam vitae nec sociosqu scelerisque duis eleifend ridiculus orci posuere, metus cursus laoreet erat purus nascetur molestie dignissim vivamus.\n" +
            "\n" +
            "Natoque rhoncus mus facilisi hac risus gravida non quam, vestibulum tortor eget quisque dui vitae fermentum suspendisse, odio neque blandit faucibus nisl class montes. Massa blandit cubilia lacus platea habitasse iaculis pulvinar mattis tempus vitae erat, convallis nam odio facilisis volutpat tellus aliquet etiam dignissim purus. Quis dictum tortor cum parturient egestas class, conubia lacus quam habitasse potenti senectus lacinia, commodo in molestie condimentum volutpat. Aenean condimentum pretium volutpat lobortis et mus semper scelerisque, arcu duis egestas ut consequat quisque.\n";
    final String[] briefMovie = {brief, brief, brief, brief, brief};
    final int[] imageMovies = {R.drawable.avatar2, R.drawable.blackadam, R.drawable.thor, R.drawable.wakanda, R.drawable.smile};*/

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
            {R.drawable.th2_chris_hemsworth, R.drawable.th2_christian_bale, R.drawable.th2_jaimie_alexander, R.drawable.th2_natalie_portman, R.drawable.th2_taika_waititi, R.drawable.th2_tessa_thompson},
            {R.drawable.wk_danai_gurira, R.drawable.wk_dominique_thorne, R.drawable.wk_letitia_wright, R.drawable.wk_lupita_nyong, R.drawable.wk_winston_duke},
            {R.drawable.sm_caitlin_stasey, R.drawable.sm_jessie_t_usher, R.drawable.sm_kal_penn, R.drawable.sm_kyle_gallner, R.drawable.sm_sosie_bacon}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Eliminate APPBAR//
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        loadMovieData();

        lvMovies = (ListView) findViewById(R.id.listViewMovies);
        //CustomBaseAdapterMovie customBaseAdapterMovie = new CustomBaseAdapterMovie(getApplicationContext(), moviesTitle, averageVote, moviesOriginalTitle, imageMovies);

        String[] moviesTitle = new String[movieList.size()];
        String[] averageVote = new String[movieList.size()];
        String[] moviesOriginalTitle = new String[movieList.size()];
        String[] briefMovie = new String[movieList.size()];
        //final int[] imageMovies = {R.drawable.avatar2, R.drawable.blackadam, R.drawable.thor, R.drawable.wakanda, R.drawable.smile};

        int[] imageMovies = new int[movieList.size()];
        for (int i = 0; i < movieList.size(); i++) {
            MovieClass movie = movieList.get(i);
            moviesTitle[i] = new String (movie.getOriginalTitle());
            averageVote[i] = new String(movie.getMovieRating());
            moviesOriginalTitle[i] = new String(movie.getOriginalTitle());
            briefMovie[i] = new String(movie.getMovieBrief());
            imageMovies[i] = movie.getImageUrl();
        }
        
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

    private void loadMovieData() {
        //Add Avatar Movie//
        CastMovieClass castMovie = new CastMovieClass(new String[]{"Cliff Curtis", "Kate Winslet", "Sam Worhtington", "Sigourney Weaver", "Stephen Lang", "Zoe Saldana"}, new int[]{R.drawable.av2_cliff_curtis, R.drawable.av2_kate_winslet, R.drawable.av2_sam_worthington, R.drawable.av2_sigourney_weaver, R.drawable.av2_stephen_lang, R.drawable.av2_zoe_saldana});
        MovieClass movie = new MovieClass("Avatar: El camino del agua", "Avatar: The way of water","8.9", R.drawable.avatar2, castMovie, "Jake Sully y Ney'tiri han formado una familia y hacen todo lo posible por permanecer juntos. Sin embargo, deben abandonar su hogar y explorar las regiones de Pandora cuando una antigua amenaza reaparece.");
        movieList.add(movie);
        //Add Black Adam Movie//
        castMovie = new CastMovieClass(new String[]{"Aldis Hodge", "Dwayne Johnson", "Marwan Kenzari", "Noah Centineo", "Quintessa Swindell", "Sarah Shahi"}, new int[]{R.drawable.ba_aldis_hodge, R.drawable.ba_dwayne_johnson, R.drawable.ba_marwan_kenzari, R.drawable.ba_noah_centineo, R.drawable.ba_quintessa_swindell, R.drawable.ba_sarah_shahi});
        movie = new MovieClass("Black Adam", "Black Adam","7.5", R.drawable.blackadam, castMovie, "Casi 5.000 años después de haber sido dotado de los poderes omnipotentes de los antiguos dioses -y encarcelado con la misma rapidez-, Black Adam es liberado de su tumba terrenal, listo para desatar su forma única de justicia en el mundo moderno.");
        movieList.add(movie);
        //Add Thor II Movie//
        castMovie = new CastMovieClass(new String[]{"Chris Hemsworth", "Christian Bale", "Jaimie Alexander", "Natalie Portman", "Taika Waititi", "Tessa Thompson"}, new int[]{R.drawable.th2_chris_hemsworth, R.drawable.th2_christian_bale, R.drawable.th2_jaimie_alexander, R.drawable.th2_natalie_portman, R.drawable.th2_taika_waititi, R.drawable.th2_tessa_thompson});
        movie = new MovieClass("Thor: \nAmor y True", "Thor: Love and Thunder", "7.9", R.drawable.thor, castMovie, "Thor está buscando la paz interior, pero la irrupción de Gorr, el asesino de dioses, le obliga a volver al combate. Thor recluta a la Reina Valkiria, Korg y su exnovia, Jane Foster, para que lo ayuden a evitar la extinción de los dioses.");
        movieList.add(movie);
        //Add Black Panther Movie//
        castMovie = new CastMovieClass(new String[]{"Danai Gurira", "Dominique Thorne", "Letitia Wright", "Lupita N'yong", "Winston Duke"}, new int[]{R.drawable.wk_danai_gurira, R.drawable.wk_dominique_thorne, R.drawable.wk_letitia_wright, R.drawable.wk_lupita_nyong, R.drawable.wk_winston_duke});
        movie = new MovieClass("Black Panther: Wakanda Para siempre", "Black Panther: Wakanda Forever", "7.3", R.drawable.wakanda, castMovie, "Una secuela que seguirá explorando el incomparable mundo de Wakanda y todos los ricos y variados personajes presentados en la película de 2018");
        movieList.add(movie);
        //Add Smile Movie//
        castMovie = new CastMovieClass(new String[]{"Caitlin Stasey", "Jessie T. Usher", "Kal Penn", "Kyle Gallner", "Sosie Bacon"}, new int[]{R.drawable.sm_caitlin_stasey, R.drawable.sm_jessie_t_usher, R.drawable.sm_kal_penn, R.drawable.sm_kyle_gallner, R.drawable.sm_sosie_bacon});
        movie = new MovieClass("Smile", "Smile", "6.8", R.drawable.smile, castMovie, "Smile sigue la historia de Rose Cotter (Sosie Bacon), una terapeuta que trabaja en la sala de traumatología de un hospital psiquiátrico local como un claro intento de aliviar parte del trauma que sufrió durante su infancia al haber encontrado el cuerpo de su madre después de que se suicidó.");
        movieList.add(movie);
    }
}