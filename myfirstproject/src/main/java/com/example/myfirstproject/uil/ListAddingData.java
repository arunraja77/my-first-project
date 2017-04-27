package com.example.myfirstproject.uil;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


public class ListAddingData extends AppCompatActivity {

    ListView l1;
    ArrayList<String> arrayList;
    Button btn_addList;
    EditText editText;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_adding_data);

        getViewCastings();
        arrayList=new ArrayList<>();


        //Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        //Adapter View
        l1.setAdapter(adapter);



        btn_addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });



        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                int itemPosition = position;
                String itemValue = (String) l1.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Position :" +itemPosition+" ListItem :" +itemValue, Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void getViewCastings()

    {
        l1 = (ListView) findViewById(R.id.list1);
        btn_addList = (Button) findViewById(R.id.btn_addList);
        editText = (EditText) findViewById(R.id.editText);
    }

}


// simple_list_item_1
// that is a reference to an built-in XML layout document that is part of the Android OS, rather than one of your own XML layouts.