package com.example.myfirstproject.uil;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
//
///**
// * Created by next on 17/5/16.
// */
//public class Zx extends AppCompatActivity {
//
//
//ListView listView;
//
//    String[] web = {
//            "Google Plus",
//            "Twitter",
//            "Windows",
//            "Bing",
//            "Itunes",
//            "Wordpress",
//            "Drupal"
//    } ;
//    Integer[] imageId = {
//            R.drawable.map,
//            R.drawable.map,
//            R.drawable.map,
//            R.drawable.map,
//            R.drawable.map,
//            R.drawable.map,
//            R.drawable.map};
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        setContentView(R.layout.listview_zx);
//
//
//        ListCustom adpter = new ListCustom(Zx.this, web, imageId) ;
//        listView.setAdapter(adpter);
//
//    }
//
//    public void getViewCastings()
//
//    {
//
//        listView= (ListView) findViewById(R.id.listView_show);
//    }
//
//
//}


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

public class Zx extends Activity {
    ListView list;
    String[] web = {
            "Map 1",
            "Map 2",
            "Map 3",
            "Map 4",
            "Map 5",
            "Map 6",
            "Map 7"
    } ;

    Integer[] imageId = {
            R.drawable.mao,
            R.drawable.mao,
            R.drawable.mao,
            R.drawable.mao,
            R.drawable.mao,
            R.drawable.mao,
            R.drawable.mao

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Start OnCreate");
        setContentView(R.layout.listview_zx);

        ListCustom adapter = new ListCustom(Zx.this, web, imageId);
        list=(ListView)findViewById(R.id.listView_show);
        System.out.println("Setting Adapter");
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(Zx.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                System.out.println("step last");

            }
        });

    }

}
/* How it works:

        ListView asks adapter “give me a view” (getView) for each item of the list
        A new View is returned and displayed
*/
