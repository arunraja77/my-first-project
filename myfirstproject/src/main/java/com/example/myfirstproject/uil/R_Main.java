package com.example.myfirstproject.uil;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class R_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // this is data from recycler view
        ItemData itemsData[] = {
                new ItemData("Music",R.drawable.sn),
                new ItemData("Favorites",R.drawable.i2),
                new ItemData("Songs",R.drawable.i1),
                new ItemData("Sounds",R.drawable.i3),
                new ItemData("Effect",R.drawable.i4),
                new ItemData("Rating",R.drawable.i2),
                new ItemData("Music",R.drawable.sn),
                new ItemData("Favourites",R.drawable.i3),
                new ItemData("Songs",R.drawable.i1),
                new ItemData("Favorite",R.drawable.i2),
                new ItemData("Sounds",R.drawable.i3),
                new ItemData("Rating",R.drawable.i4)};



        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        MyAdapter mAdapter = new MyAdapter(itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}

// setLayoutManager : Set the  LayoutManager that this RecyclerView will use.
// LinearLayoutManager : Creates a vertical LinearLayoutManager