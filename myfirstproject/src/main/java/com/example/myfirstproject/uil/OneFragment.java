package com.example.myfirstproject.uil;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class OneFragment extends Fragment{
    Context context;
    public static final String[] values =new String[]{
            "LINE 1", //Items
            "LINE 2",
            "LINE 3",
            "LINE 4",
            "LINE 5",
            "LINE 6",
            "LINE 7",
            "LINE 8",
            "LINE 9",
            "LINE 10",
            "LINE 11",
            "LINE 12",
            "LINE 13",
            "LINE 14",
            "LINE 15",
            "LINE 16",
            "LINE 17",


    };

    public OneFragment() {
        // Required empty public constructor


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_one, container, false);
    }

}
