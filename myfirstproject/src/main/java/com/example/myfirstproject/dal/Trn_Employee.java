package com.example.myfirstproject.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

import com.example.myfirstproject.bal.BusinessAccessLayer;
import com.example.myfirstproject.uil.EditData;

/**
 * Created by next-03 on 12/4/16.
 */
public class Trn_Employee extends DataAccessLayer {


    public Trn_Employee(Context ctx) {
        super(ctx);
    }

    /**
     * @Type
     * @Created_By
     * @Created_On
     * @Updated_By
     * @Updated_On
     * @Description
     */

    public long insert_UserRegistration(String emp_first_name, String emp_last_name, String emp_user_name, String emp_new_password) {
        ContentValues args = new ContentValues();

        args.put(BusinessAccessLayer.TRN_EMP_FIRSTNAME, emp_first_name);
        args.put(BusinessAccessLayer.TRN_EMP_LASTNAME, emp_last_name);
        args.put(BusinessAccessLayer.TRN_EMP_USERNAME, emp_user_name);
        args.put(BusinessAccessLayer.TRN_EMP_NEWPASSWORD, emp_new_password);


        return mDb.insert(BusinessAccessLayer.DATABASE_TABLE_TRN_EMPLOYEE, null, args);

    }

    /**
     * @Type
     * @Created_By
     * @Created_On
     * @Updated_By
     * @Updated_On
     * @Description
     */

    public Cursor fetch() throws SQLException {
        Cursor mCursorFetch = mDb.rawQuery("SELECT * FROM "
                + BusinessAccessLayer.DATABASE_TABLE_TRN_EMPLOYEE, null);
        if (mCursorFetch != null) {
            mCursorFetch.moveToFirst();
        }
        return mCursorFetch;

    }

    public boolean deleteEmployee(String name) {
        return mDb.delete(BusinessAccessLayer.DATABASE_TABLE_TRN_EMPLOYEE, BusinessAccessLayer.EMP_ID+ " = " +name, null) > 0;
    }


    public long updateEmployee(String user_id,String first_name, String last_name, String user_name, String pass_word ) {
        ContentValues args = new ContentValues();
        args.put(BusinessAccessLayer.EMP_ID, user_id);
        args.put(BusinessAccessLayer.TRN_EMP_FIRSTNAME, first_name);
        args.put(BusinessAccessLayer.TRN_EMP_LASTNAME, last_name);
        args.put(BusinessAccessLayer.TRN_EMP_USERNAME, user_name);
        args.put(BusinessAccessLayer.TRN_EMP_NEWPASSWORD, pass_word);



        return mDb.update(BusinessAccessLayer.DATABASE_TABLE_TRN_EMPLOYEE, args, BusinessAccessLayer.EMP_ID + "=" + user_id,null);

    }
//

    public Cursor fetchEdit(String user_id) throws SQLException {
        Cursor mCursorFetch = mDb.rawQuery("SELECT * FROM "
                + BusinessAccessLayer.DATABASE_TABLE_TRN_EMPLOYEE + " " + " WHERE " + " " + BusinessAccessLayer.EMP_ID + "=" + user_id, null);
        if (mCursorFetch != null) {
            mCursorFetch.moveToFirst();
        }
        return mCursorFetch;


    }
}
