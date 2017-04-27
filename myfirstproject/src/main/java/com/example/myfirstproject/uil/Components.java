package com.example.myfirstproject.uil;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Components extends AppCompatActivity {

    Button btnStartProgress,btndisplayDate,btndisplayTime;
    RatingBar btnRatingBar;
    Switch switchButton;
    EditText txtDate,txtTime;
    DatePicker datePicker;
    TimePicker timePicker;

    TextView text1;
    private int mYear, mMonth, mDay, mHour, mMinute;
    ListView listView;  String contacts[]={"Ajay","Sachin","Sumit","Tarun","Yogesh"};

    String[] language ={"C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP"};


    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();

    private long fileSize = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.components);
        getViewCastings();



        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        WebView mywebview = (WebView) findViewById(R.id.webView);
        mywebview.loadUrl("https://www.google.co.in");

        addListenerOnButton();

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,android.R.layout.select_dialog_item,language);

        AutoCompleteTextView actv= (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.RED);







        btndisplayDate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDate.setText(getCurrentDate());
            }
        });

//        txtTime.setText(getCurrentTime());
//        timePicker.setIs24HourView(true);

        btndisplayTime.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTime.setText(getCurrentTime());
            }
        });





        switchButton.setChecked(true);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(),"Switch is ON",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Switch is OFF",Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {



                    String rating1=String.valueOf(btnRatingBar.getRating());
                    Toast.makeText(getApplicationContext(), rating1, Toast.LENGTH_LONG).show();




            }
        });

    }

    public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();
        builder.append((datePicker.getMonth() + 1)+"/");//month is 0 based
        builder.append(datePicker.getDayOfMonth()+"/");
        builder.append(datePicker.getYear());
        return builder.toString();
    }

    public String getCurrentTime(){
        String currentTime="Current Time: "+timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
        return currentTime;
    }


    public void addListenerOnButton() {

        btnStartProgress.setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        // prepare for a progress bar dialog
                        progressBar = new ProgressDialog(v.getContext());
                        progressBar.setCancelable(true);
                        progressBar.setMessage("File downloading ...");
                        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        progressBar.setProgress(0);
                        progressBar.setMax(100);
                        progressBar.show();

                        //reset progress bar status
                        progressBarStatus = 0;

                        //reset filesize
                        fileSize = 0;

                        new Thread(new Runnable() {
                            public void run() {
                                while (progressBarStatus < 100) {

                                    // process some tasks
                                    progressBarStatus = doSomeTasks();

                                    // your computer is too fast, sleep 1 second
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    // Update the progress bar
                                    progressBarHandler.post(new Runnable() {
                                        public void run() {
                                            progressBar.setProgress(progressBarStatus);
                                        }
                                    });
                                }

                                // ok, file is downloaded,
                                if (progressBarStatus >= 100) {

                                    // sleep 2 seconds, so that you can see the 100%
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    // close the progress bar dialog
                                    progressBar.dismiss();
                                }
                            }
                        }).start();

                    }

                });

    }

//     file download simulator... a really simple
    public int doSomeTasks() {

        while (fileSize <= 1000000) {

            fileSize++;

            if (fileSize == 100000) {
                return 10;
            } else if (fileSize == 200000) {
                return 20;
            } else if (fileSize == 300000) {
                return 30;
            }
            // ...add your own

        }

        return 100;

    }








    public void getViewCastings(){
        btnStartProgress = (Button) findViewById(R.id.progress_Download);
        btnRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        switchButton = (Switch) findViewById(R.id.switch1);
        txtDate = (EditText) findViewById(R.id.dateEtext);
        txtTime = (EditText) findViewById(R.id.timeEtext);
        datePicker=(DatePicker)findViewById(R.id.date_picker);
        timePicker=(TimePicker)findViewById(R.id.time_picker);
        btndisplayDate = (Button) findViewById(R.id.button_display_date);
        btndisplayTime = (Button) findViewById(R.id.button_display_time);



    }

}