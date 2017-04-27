package com.example.myfirstproject.uil;

import android.content.Context;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;



public class CustomAdapter extends BaseAdapter {

     //TextView first_name,last_name,user_name,pass_word;
    Context context;
    ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();

    public CustomAdapter(Context ctx, ArrayList<HashMap<String, String>> data) {

        this.items = data;
        this.context = ctx;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.customadpater,null);
        System.out.println("items "+position);
        TextView textView1 = (TextView) rowView.findViewById(R.id.firstName);
        TextView textView2 = (TextView) rowView.findViewById(R.id.lastName);
        TextView textView3 = (TextView) rowView.findViewById(R.id.userName);
        TextView textView4 = (TextView) rowView.findViewById(R.id.password);
        TextView textView5 = (TextView) rowView.findViewById(R.id.user_id);



        textView1.setText(items.get(position).get("first_name"));
        textView2.setText(items.get(position).get("last_name"));
        textView3.setText(items.get(position).get("user_name"));
        textView4.setText(items.get(position).get("pass_word"));
        textView5.setText(items.get(position).get("user_id"));


        return rowView;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void notifyDataSetChanged() {

        super.notifyDataSetChanged();
    }

}



