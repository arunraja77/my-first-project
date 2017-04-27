package com.example.myfirstproject.uil;

/**
 * Created by next on 13/5/16.
 */

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;



public class GoogleMapLocation extends FragmentActivity implements LocationListener {

    GoogleMap googleMap;
    TextView eTextmarker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //show error dialog if GoolglePlayServices not available
        if (!isGooglePlayServicesAvailable()) {
            finish();
        }
        setContentView(R.layout.location);
        final ImageView imgViewMarker= (ImageView) findViewById(R.id.imgView_marker) ;
        eTextmarker = (TextView) findViewById(R.id.eText_marker);

        SupportMapFragment supportMapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googleMap);
        googleMap = supportMapFragment.getMap();
        googleMap.getUiSettings().setZoomControlsEnabled(true);

        imgViewMarker.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

               // public final LatLng	target	The location that the camera is pointing at.
                LatLng latLng=googleMap.getCameraPosition().target;


                double latitude=latLng.latitude;
                double longitude=latLng.longitude;

                //Geocoding is the process of transforming a street address or other description of a location into a (latitude, longitude)
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                List<android.location.Address> addresses;
                try {
                    addresses=geocoder.getFromLocation(latitude,longitude,1);

//                    String cityName = addresses.get(0).getAddressLine(1);
//                    String countryName = addresses.get(0).getAddressLine(2);

                    String address = addresses.get(0).getAddressLine(1); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
                    String city = addresses.get(0).getLocality();
                    String state = addresses.get(0).getAdminArea();
                    String country = addresses.get(0).getCountryName();
                    String postalCode = addresses.get(0).getPostalCode();
                    String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL


                        String data = " Address : " + address + " \n City : " + city+ " \n State : " + state + " \n CountryName : " + country;
                    Toast.makeText(getApplicationContext(),""+data,Toast.LENGTH_SHORT).show();
//                        eTextmarker.setText(data);


                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(),"No Address",Toast.LENGTH_SHORT).show();

                    e.printStackTrace();
                }



                Toast.makeText(getApplicationContext()," Latitude : "+latitude +" \n Longitude : "+longitude,Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng).draggable(true);
                markerOptions.title(latLng.latitude + " : " + latLng.longitude);

                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                googleMap.addMarker(markerOptions);

            }

        });

        googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                googleMap.clear();
            }
        });






        googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {
                Toast.makeText(GoogleMapLocation.this, "Drag Started", Toast.LENGTH_SHORT).show();
                marker.setTitle(String.valueOf(marker.getPosition().latitude + " : " +String.valueOf(marker.getPosition().longitude)));
                marker.showInfoWindow();

            }

            @Override
            public void onMarkerDrag(Marker marker) {


                marker.setTitle(String.valueOf(marker.getPosition().latitude + " : " +String.valueOf(marker.getPosition().longitude)));
                marker.showInfoWindow();


            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                marker.setTitle(String.valueOf(marker.getPosition().latitude + " : " +String.valueOf(marker.getPosition().longitude)));
                marker.showInfoWindow();
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(marker.getPosition()));
                Toast.makeText(GoogleMapLocation.this,"Drag End" ,Toast.LENGTH_SHORT).show();

            }
        });










        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return ;
        }
        // Enable MyLocation Layer of Google Map
        googleMap.setMyLocationEnabled(true);

        // Get LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // Create a criteria object to retrieve provider
        Criteria criteria = new Criteria();


        String bestProvider = locationManager.getBestProvider(criteria, true);

        // Get Current Location
        final Location location = locationManager.getLastKnownLocation(bestProvider);
        if (location != null) {

            onLocationChanged(location);

        }

        locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);





    }




    @Override
    public void onLocationChanged(Location location) {

        TextView locationTv = (TextView) findViewById(R.id.latlongLocation);

        // Get latitude of the current location
        double latitude = location.getLatitude();

        // Get longitude of the current location
        double longitude = location.getLongitude();

        // Create a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        // Show the current location in Google Map
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));


        // Zoom in the Google Map
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(20));
        googleMap.addMarker(new MarkerOptions().position( new LatLng(latitude,longitude)).title("You are Here"));
//        Toast.makeText(getApplicationContext(),"Latitude "+latitude +"Longitude"+longitude,Toast.LENGTH_SHORT).show();

    }



    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
    }

    private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (ConnectionResult.SUCCESS == status) {
            return true;
        } else {
            GooglePlayServicesUtil.getErrorDialog(status, this, 0).show();
            return false;
        }
    }
}