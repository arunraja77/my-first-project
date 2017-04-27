package com.example.myfirstproject.uil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.myfirstproject.bal.BusinessAccessLayer;
import com.example.myfirstproject.dal.Trn_Employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.nio.channels.FileChannel;
import java.util.regex.Pattern;




public class SignUp extends AppCompatActivity {
    Button b1, b2,b3;

    EditText ed1, ed2, ed3, ed5 , ed6,ed7;

    private String filepath = "Database";

    String  str_ed1,str_ed2,str_ed3,str_ed5,str_ed6;

    // Validating password
    final Pattern hasUppercase = Pattern.compile("[A-Z]");
    final Pattern hasLowercase = Pattern.compile("[a-z]");
    final Pattern hasNumber = Pattern.compile("\\d");
    final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        getViewCastings();


        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(SignUp.this,ManageData.class);
                startActivity(ii);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (ed1.getText().toString().length() < 4 || ed1.getText().toString().length() > 10) {

                    Toast.makeText(SignUp.this, "Please enter character between 4 to 10", Toast.LENGTH_SHORT).show();
                }
               else if (ed2.getText().toString().length() < 4 || ed1.getText().toString().length() > 10) {

                    Toast.makeText(SignUp.this, "Please enter character between 4 to 10", Toast.LENGTH_SHORT).show();

                } else if (ed5.getText().toString().length() < 5 || ed5.getText().toString().length() > 10) {
                    Toast.makeText(SignUp.this, "Password length should be minimum 5 and maximum 10", Toast.LENGTH_SHORT).show();
                } else if (!hasUppercase.matcher(ed5.getText().toString()).find()) {
                    Toast.makeText(SignUp.this, "Password Must contain upper case letter", Toast.LENGTH_SHORT).show();
                } else if (!hasLowercase.matcher(ed5.getText().toString()).find()) {
                    Toast.makeText(SignUp.this, "Password Must contain lower case letter", Toast.LENGTH_SHORT).show();
                } else if (!hasSpecialChar.matcher(ed5.getText().toString()).find()) {
                    Toast.makeText(SignUp.this, "Password Must contain one special character", Toast.LENGTH_SHORT).show();
                } else if (!hasNumber.matcher(ed5.getText().toString()).find()) {
                    Toast.makeText(SignUp.this, "Password Must contain number", Toast.LENGTH_SHORT).show();
                } else if(!ed5.getText().toString().equals(ed6.getText().toString()))
                {

                    Toast.makeText(SignUp.this, "Confirm password should be same as password", Toast.LENGTH_SHORT).show();
                }

                else {


                    str_ed1 = ed1.getText().toString().trim();
                    str_ed2 = ed2.getText().toString().trim();
                    str_ed3 = ed3.getText().toString().trim();
                    str_ed5 = ed5.getText().toString().trim();


                    Trn_Employee trn_employee_enroll = new Trn_Employee(SignUp.this);
                    trn_employee_enroll.open();
                    long mCr_trn_employee_enroll = trn_employee_enroll.insert_UserRegistration(str_ed1,str_ed2,str_ed3,str_ed5);

                    if(mCr_trn_employee_enroll>0)
                    {
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        exportDatabse(BusinessAccessLayer.DATABASE_NAME);

                    }
                    trn_employee_enroll.close();
                }
            }
            });


    }

    public void exportDatabse(String databaseName) {
        try {
            BusinessAccessLayer.myExternalFile = new File(SignUp.this.getExternalFilesDir(filepath), BusinessAccessLayer.DATABASE_NAME);
            System.out.println("directory myExternalFile   " + BusinessAccessLayer.myExternalFile);
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "//data//" + SignUp.this.getPackageName()
                        + "//databases//" + databaseName + "";


                String backupDBPath = BusinessAccessLayer.DATABASE_NAME;

                System.out.println("currentDBPath "+currentDBPath);
                System.out.println("backupDBPath "+backupDBPath);


                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB)
                            .getChannel();
                    FileChannel dst = new FileOutputStream(BusinessAccessLayer.myExternalFile)
                            .getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                }
            }
        } catch (Exception e) {

        }
    }

    private void  getViewCastings() {

        ed1 = (EditText) findViewById(R.id.edtext_firstname);
        ed2 = (EditText) findViewById(R.id.edtext_lastname);
        ed3 = (EditText) findViewById(R.id.edtext_username);

        ed5 = (EditText) findViewById(R.id.edtext_newpwd);
        ed6 = (EditText) findViewById(R.id.edtext_confirmpwd);



        b1 = (Button) findViewById(R.id.btn_reg);
        b2 = (Button) findViewById(R.id.btn_cancel);
        b3 = (Button) findViewById(R.id.btn_manageData);

    }
}