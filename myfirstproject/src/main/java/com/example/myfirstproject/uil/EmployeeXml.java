package com.example.myfirstproject.uil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by next on 11/5/16.
 */
public class EmployeeXml extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private String titlee;
    private String description;
    private String link;
    private  String date;

    public String getTitlee(){
        return titlee;
    }

    public void setTitle(String title){
        this.titlee=title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public String getLink(){
        return link;
    }
    public void setLink(String link){
        this.link=link;
    }

    public  String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }

    public String toString() {
        return  "\n Title = " +titlee+
                "\n Description= "+description +
                "\n Link= " +link +
                "\n Date = " +date +
                "\n \n";
    }

}
