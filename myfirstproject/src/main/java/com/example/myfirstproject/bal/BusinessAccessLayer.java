package com.example.myfirstproject.bal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;

/**
 * Created by next on 28/4/16.
 */
public class BusinessAccessLayer {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Employee.db";

    public static final String EMP_ID = "emp_id";
    public static final String DATABASE_TABLE_TRN_EMPLOYEE = "trn_employee";
    public static final String TRN_EMP_FIRSTNAME = "employee_first_name";
    public static final String TRN_EMP_LASTNAME = "employee_last_name";
    public static final String TRN_EMP_USERNAME = "employee_user_name";
    public static final String TRN_EMP_NEWPASSWORD = "employee_password";



    public static File myExternalFile;
}
