package com.example.myfirstproject.uil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by next on 20/5/16.
 */
public class RecyclerView extends AppCompatActivity {
    Button recycler_vertical,recycler_grid;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_card_view);
        getviewCastings();

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        recycler_vertical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerView.this,R_Main.class);
                startActivity(intent);
            }
        });

        recycler_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecyclerView.this,R_MainGrid.class);
                startActivity(intent);
            }
        });

    }

    public void getviewCastings(){
        recycler_vertical= (Button) findViewById(R.id.recycler_vertical);
        recycler_grid= (Button) findViewById(R.id.recycler_grid);

    }
}
