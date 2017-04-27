package com.example.myfirstproject.uil;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by next on 25/5/16.
 */
public class SharedPreferencess extends AppCompatActivity {


    EditText ed1, ed2, ed3;
    Button b1,Get;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sharedPreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_preferences);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        Get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);

                sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                if (sharedPreferences.contains(Name)) {
                    ed1.setText(sharedPreferences.getString(Name, ""));
                }
                if (sharedPreferences.contains(Email)) {
                    ed2.setText(sharedPreferences.getString(Email, ""));

                }

            }
        });
        b1 = (Button) findViewById(R.id.button);
        Get = (Button) findViewById(R.id.button_get);




            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String n = ed1.getText().toString();
                    String ph = ed2.getText().toString();
                    String e = ed3.getText().toString();


                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Name, n);
                    editor.putString(Phone, ph);
                    editor.putString(Email, e);
                    editor.commit();
                    Toast.makeText(SharedPreferencess.this, "Thanks", Toast.LENGTH_LONG).show();


                }
            });


        Get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}

