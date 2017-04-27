package com.example.myfirstproject.uil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by next on 20/4/16.
 */
public class Signupactivity extends AppCompatActivity {
    Button b1,b;
    LinearLayout l1, l2, l3, l4, l5, l6, l7, l8;
    TextView tv1,tv2,tv3,tv5,tv6,tv7,tv8,tv9,tv10;
    RadioButton rb1,rb2;
    Spinner s1;
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    CheckBox cb1,cb2,cb3,cb4;
    RadioGroup r;
    Toolbar toolbar;

    // Validating password
    final Pattern hasUppercase = Pattern.compile("[A-Z]");
    final Pattern hasLowercase = Pattern.compile("[a-z]");
    final Pattern hasNumber = Pattern.compile("\\d");
    final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        getViewCastings();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        List<String> l1=new ArrayList<String>();
        l1.add("SELECT");
        l1.add("ECE");
        l1.add("CSE");
        l1.add("MECH");
        l1.add("IT");
        l1.add("CIVIL");

        ArrayAdapter<String>  adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,l1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);




        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int count=1;
                if(cb2.isChecked())
                {
                    count++;
                }
                if(cb3.isChecked())
                {
                    count++;
                }
                if(cb4.isChecked())
                {
                    count++;
                }
                System.out.println("count "+count);
                if(count>2)
                {
                    cb1.setChecked(false);
                    Toast.makeText(Signupactivity.this, " Click only  2 Checkboxes",Toast.LENGTH_SHORT).show();
                }

                /*if(cb2.isChecked() && cb3.isChecked() && cb4.isChecked()) {
                    Toast.makeText((Signupactivity.this, " Click only  2 Checkboxes",Toast.LENGTH_SHORT.)))
                }*/

            }
        });

        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int count=1;
                if(cb2.isChecked())
                {
                    count++;
                }
                if(cb3.isChecked())
                {
                    count++;
                }
                if(cb1.isChecked())
                {
                    count++;
                }
                System.out.println("count "+count);
                if(count>2)
                {
                    cb4.setChecked(false);
                    Toast.makeText(Signupactivity.this, " Click only  2 Checkboxes",Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int count=1;
                if(cb1.isChecked())
                {
                    count++;
                }
                if(cb3.isChecked())
                {
                    count++;
                }
                if(cb4.isChecked())
                {
                    count++;
                }
                System.out.println("count "+count);
                if(count>2)
                {
                    cb2.setChecked(false);
                    Toast.makeText(Signupactivity.this, " Click only  2 Checkboxes",Toast.LENGTH_SHORT).show();
                }

                /*if(cb2.isChecked() && cb3.isChecked() && cb4.isChecked()) {
                    Toast.makeText((Signupactivity.this, " Click only  2 Checkboxes",Toast.LENGTH_SHORT.)))
                }*/

            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int count=1;
                if(cb2.isChecked())
                {
                    count++;
                }
                if(cb1.isChecked())
                {
                    count++;
                }
                if(cb4.isChecked())
                {
                    count++;
                }
                System.out.println("count "+count);
                if(count>2)
                {
                    cb3.setChecked(false);
                    Toast.makeText(Signupactivity.this, " Click only  2 Checkboxes",Toast.LENGTH_SHORT).show();
                }

                /*if(cb2.isChecked() && cb3.isChecked() && cb4.isChecked()) {
                    Toast.makeText((Signupactivity.this, " Click only  2 Checkboxes",Toast.LENGTH_SHORT.)))
                }*/

            }
        });



       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



               if(ed1.getText().toString().length()<5 || ed1.getText().toString().length()> 10)
               {

                   Toast.makeText(Signupactivity.this,"Please enter character between 5 to 10",Toast.LENGTH_SHORT).show();
               }
               else if(!ed2.getText().toString().matches(emailPattern))
               {
                   ed2.setError("Email Address not Valid");
                   Toast.makeText(Signupactivity.this,"Email Not valid",Toast.LENGTH_SHORT).show();
               }

               else if(ed5.getText().toString().length() < 5 || ed5.getText().toString().length() > 10){
                   Toast.makeText(Signupactivity.this,"Password length should be minimum 5 and maximum 10",Toast.LENGTH_SHORT).show();
               }
               else if(!hasUppercase.matcher(ed5.getText().toString()).find()){
                   Toast.makeText(Signupactivity.this,"Password Must contain upper case letter",Toast.LENGTH_SHORT).show();
               }
               else if(!hasLowercase.matcher(ed5.getText().toString()).find()){
                   Toast.makeText(Signupactivity.this,"Password Must contain lower case letter",Toast.LENGTH_SHORT).show();
               }
               else if(!hasSpecialChar.matcher(ed5.getText().toString()).find()){
                   Toast.makeText(Signupactivity.this,"Password Must contain one special character",Toast.LENGTH_SHORT).show();
               }
               else if(!hasNumber.matcher(ed5.getText().toString()).find()){
                   Toast.makeText(Signupactivity.this,"Password Must contain number",Toast.LENGTH_SHORT).show();
               }

               else if(!ed5.getText().toString().equals(ed6.getText().toString())) {

                   Toast.makeText(Signupactivity.this,"Confirm password should be same as password" ,Toast.LENGTH_SHORT).show();
               }


               else if(ed3.getText().toString().trim().length()==0)
               {
                   ed3.setError("Address cannot be blank");
                   Toast.makeText(Signupactivity.this,"Address cannot be Empty",Toast.LENGTH_SHORT).show();
               }
               else if( ed4.getText().toString().length() < 13 )
               {
                   ed4.setError("Please enter 10 digit nuber ");
                   Toast.makeText(Signupactivity.this,"Please Enter 10 digit Number",Toast.LENGTH_SHORT).show();
               }

               else if (r.getCheckedRadioButtonId() == -1)
               {
                   Toast.makeText(Signupactivity.this,"Please select Gender",Toast.LENGTH_SHORT).show();

               }

               else if(s1.getSelectedItem().equals("SELECT")) {
                   Toast.makeText(Signupactivity.this,"Please select DEPT" ,Toast.LENGTH_SHORT).show();
               }
               else if(cb1.isChecked() ==false &&  cb2.isChecked() ==false &&  cb3.isChecked() ==false && cb4.isChecked() ==false) {
                   Toast.makeText(Signupactivity.this,"Please select CheckBox" ,Toast.LENGTH_SHORT).show();
               }








               else {

                   Intent i5 = new Intent(Signupactivity.this, Success.class);
                   startActivity(i5);
               }
           }
       });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7=new Intent(Signupactivity.this,MainActivity.class);
                startActivity(i7);
                finish();
            }
        });




    }

    private void getViewCastings() {

        b = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button10);
        l1 = (LinearLayout) findViewById(R.id.layout1);
        l2 = (LinearLayout) findViewById(R.id.layout2);
        l3 = (LinearLayout) findViewById(R.id.layout3);
        l4 = (LinearLayout) findViewById(R.id.layout4);
        l5 = (LinearLayout) findViewById(R.id.layout5);
        l6 = (LinearLayout) findViewById(R.id.layout6);
        l7 = (LinearLayout) findViewById(R.id.layout7);
        l8 = (LinearLayout) findViewById(R.id.layout8);
        tv1 = (TextView) findViewById(R.id.textview1);
        tv2 = (TextView) findViewById(R.id.textview2);
        tv3 = (TextView) findViewById(R.id.textview3);
        tv5 = (TextView) findViewById(R.id.textview5);
        tv6 = (TextView) findViewById(R.id.textview6);
        tv7 = (TextView) findViewById(R.id.textview7);
        tv8 = (TextView) findViewById(R.id.textview8);
        tv9 = (TextView) findViewById(R.id.textview9);
        tv10 = (TextView) findViewById(R.id.textview10);
        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        s1 = (Spinner) findViewById(R.id.spinner1);
        ed1 = (EditText) findViewById(R.id.editText1);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);
        ed4 = (EditText) findViewById(R.id.editText4);
        ed5 = (EditText) findViewById(R.id.editText5);
        ed6 = (EditText) findViewById(R.id.editText6);
        cb1 = (CheckBox) findViewById(R.id.checkbox1);
        cb2 = (CheckBox) findViewById(R.id.checkbox2);
        cb3 = (CheckBox) findViewById(R.id.checkbox3);
        cb4 = (CheckBox) findViewById(R.id.checkbox4);
        r = (RadioGroup) findViewById(R.id.radioGroup);
        toolbar = (Toolbar) findViewById(R.id.toolbar);




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

