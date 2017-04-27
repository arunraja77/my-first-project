package com.example.myfirstproject.uil;

        import android.content.Context;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.DefaultItemAnimator;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.support.v7.widget.Toolbar;
        import android.view.GestureDetector;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

public class Recycler_Main extends AppCompatActivity {
    private List<Recycler_Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Recycler_MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new Recycler_MovieAdapter(movieList);
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        Recycler_Movie movie = new Recycler_Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Recycler_Movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Recycler_Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Recycler_Movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Recycler_Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Recycler_Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Recycler_Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Recycler_Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Recycler_Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Recycler_Movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Recycler_Movie("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Recycler_Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Recycler_Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Recycler_Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Recycler_Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Recycler_Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}