package com.example.myfirstproject.uil;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/* How it works:

        ListView asks adapter “give me a view” (getView) for each item of the list
        A new View is returned and displayed
*/


public class List extends AppCompatActivity {

    ListView l1;








    //Data Source
    public static final String[] values =new String[]{
            "LINE 1", //Items
            "LINE 2",
            "LINE 3",
            "LINE 4",
            "LINE 5",
            "LINE 6",
            "LINE 7",
            "LINE 8",
            "LINE 9",
            "LINE 10",
            "LINE 11",
            "LINE 12",
            "LINE 13",
            "LINE 14",
            "LINE 15",
            "LINE 16",
            "LINE 17",


    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);


        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
//        ListCustom adpter = new ListCustom(List.this, web, imageId) ;
//        l1.setAdapter(adpter);





        getViewCastings();



        //Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);

        //Adapter View
        l1.setAdapter(adapter);






    }

    public void getViewCastings()

    {

l1= (ListView) findViewById(R.id.list1);
    }

}


// simple_list_item_1
// that is a reference to an built-in XML layout document that is part of the Android OS, rather than one of your own XML layouts.