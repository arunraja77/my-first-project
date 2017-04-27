package com.example.myfirstproject.uil;

/**
 * Created by next on 28/4/16.
 */

import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myfirstproject.bal.BusinessAccessLayer;
import com.example.myfirstproject.dal.DataAccessLayer;
import com.example.myfirstproject.dal.Trn_Employee;
import com.example.myfirstproject.uil.SignUp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class ManageData extends  AppCompatActivity {

    ArrayList<HashMap<String, String>> mArray = new ArrayList<HashMap<String, String>>();


    ListView listView;
    private final Context context = this;
    CustomAdapter adapter;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managedata);


        Trn_Employee trn_user_details = new Trn_Employee(getApplicationContext());
        trn_user_details.open();

        Cursor data = trn_user_details.fetch();

        if(data.moveToFirst())
        {
            System.out.println("data.getCount() "+data.getCount());

            for(int i=0;i<data.getCount();i++) {

                data.moveToPosition(i);
                HashMap<String,String> hashMap=new HashMap<String, String>();
                String user_id=data.getString(data.getColumnIndex(BusinessAccessLayer.EMP_ID));
                String first_name=data.getString(data.getColumnIndex(BusinessAccessLayer.TRN_EMP_FIRSTNAME));
                String last_name=data.getString(data.getColumnIndex(BusinessAccessLayer.TRN_EMP_LASTNAME));
                String user_name=data.getString(data.getColumnIndex(BusinessAccessLayer.TRN_EMP_USERNAME));
                String pass_word=data.getString(data.getColumnIndex(BusinessAccessLayer.TRN_EMP_NEWPASSWORD));


                hashMap.put("user_id",user_id);
                hashMap.put("first_name",first_name);
                hashMap.put("last_name",last_name);
                hashMap.put("user_name",user_name);
                hashMap.put("pass_word",pass_word);



                mArray.add(hashMap);

            }

            System.out.println("mArray "+mArray.size());

        }

        Trn_Employee.close();

        adapter = new CustomAdapter(getApplicationContext(),mArray);

        listView = (ListView) findViewById(R.id.listView_manageData);

        listView.setAdapter(adapter);




        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {


                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("CHOOSE ACTION");
//                builder.setMessage("Delete");
//                builder.setCancelable(false);

                builder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String value = mArray.get(position).get("user_id");
                        Intent intent = new Intent(getApplicationContext(), EditData.class);
                        intent.putExtra("user_id",value);
                        startActivity(intent);
                    }
                });


                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//
                        Trn_Employee trn_user_details = new Trn_Employee(getApplicationContext());
                        trn_user_details.open();


                        String value = mArray.get(position).get("user_id");

                        boolean result = trn_user_details.deleteEmployee(value);

                        if(result)
                        {
                            mArray.remove(position);
                            adapter.notifyDataSetChanged();
                            Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
                        }


                    }
                });
                builder.show();
                return true;


            }
        });


    }





}
