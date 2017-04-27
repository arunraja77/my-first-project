package com.example.myfirstproject.uil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;



/**
 * Created by next on 20/4/16.
 */
public class ListAndGrid extends AppCompatActivity {
    Button b12, b13,b14;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listandgrid);
        getViewCastings();


        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i12= new Intent(ListAndGrid.this,List.class);
                startActivity(i12);
            }
        });

        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i13= new Intent(ListAndGrid.this,Grid.class);
                startActivity(i13);
            }
        });

        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i13= new Intent(ListAndGrid.this,ListAddingData.class);
                startActivity(i13);
            }
        });

    }


    private void getViewCastings() {

        b12 = (Button) findViewById(R.id.button12);
        b13 = (Button) findViewById(R.id.button13);
        b14 = (Button) findViewById(R.id.button14);
    }
}