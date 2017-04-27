package com.example.myfirstproject.uil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by next on 9/5/16.
 */
public class Employee extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private int id;
    private String name;
    private float salary;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }

//
    public String toString() {
        return " Id= "+id + "\n Name= " +name + "\n Salary= " +salary;
    }


}
