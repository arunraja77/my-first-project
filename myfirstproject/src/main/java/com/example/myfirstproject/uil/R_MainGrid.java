package com.example.myfirstproject.uil;


import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class R_MainGrid extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // this is data from recycler view
        ItemData itemsData[] = {
                new ItemData("Help",R.drawable.sn),
                new ItemData("Delete",R.drawable.si),
                new ItemData("Cloud",R.drawable.i1),
                new ItemData("Favorite",R.drawable.i2),
                new ItemData("Like",R.drawable.i3),
                new ItemData("Rating",R.drawable.i4),
                new ItemData("Help",R.drawable.sn),
                new ItemData("Delete",R.drawable.si),
                new ItemData("Cloud",R.drawable.i1),
                new ItemData("Favorite",R.drawable.i2),
                new ItemData("Like",R.drawable.i3),
                new ItemData("Rating",R.drawable.i4)};



        // 2. set layoutManger
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
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