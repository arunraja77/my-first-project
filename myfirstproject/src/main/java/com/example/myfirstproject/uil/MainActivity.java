package com.example.myfirstproject.uil;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.text.Html;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Context;



public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,btnUpload,btnXml,btnJsonParsingWeb;
      Button      btnXmlParsingWeb,buttonGoogleMap,buttonGoogleRoute,
            buttonSettings,buttonRecycler,button_fragments,button_tab,button_NavigationDrawer,button_sharedPreference;
    LinearLayout l1,l2,l3,l4,l5,l6,l7,l8;
    Toolbar toolbar;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViewCastings();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);




//        LinearLayout l_parent = new LinearLayout(this);
//        l_parent.setOrientation(LinearLayout.VERTICAL);
//        LinearLayout.LayoutParams LLParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//        l_parent.setLayoutParams(LLParams);
//        l1.addView(l_parent);

        /*floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Main Activity",Snackbar.LENGTH_LONG).setAction("Action" , null).show();
            }
        });*/


        button_sharedPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SharedPreferencess.class);
                startActivity(intent);
            }
        });


        button_NavigationDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),NavigationDrawerActivity.class);
                startActivity(intent);
            }
        });
        button_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),FragmentTabActivity.class);
                startActivity(intent);
            }
        });

        button_fragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainFragment.class);
                startActivity(intent);
            }
        });

        buttonRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RecyclerView.class);
                startActivity(intent);
            }
        });


        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Zx.class);
                startActivity(intent);
            }
        });

        buttonGoogleRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MapRouteActivity.class);
                startActivity(intent);
            }
        });

        buttonGoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GoogleMapLocation.class);
                startActivity(intent);
            }
        });

        btnXmlParsingWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,XmlParsingWeb.class);
                startActivity(intent);
            }
        });

        btnJsonParsingWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,JsonParsinWeb.class);
                startActivity(intent);
            }
        });

        btnXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,XmlParsing.class);
                startActivity(intent);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i23=new Intent(MainActivity.this,JsonParsing.class);
                startActivity(i23);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ImageUpload.class);
                startActivity(intent);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ExpandableList.class);
                startActivity(intent);
            }
        });



        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Components.class);
                startActivity(intent);
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7=new Intent(MainActivity.this,RowAndColumn.class);
                startActivity(i7);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,Signupactivity.class);
                startActivity(i1);

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(MainActivity.this,EgActivity.class);
                startActivity(i2);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(MainActivity.this,ListAndGrid.class);
                startActivity(i3);

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(MainActivity.this,GpsActivity.class);
                startActivity(i4);

            }
        });


        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(MainActivity.this,SignUp.class);
                startActivity(i4);

            }
        });






    }

    private void getViewCastings() {

        b1 = (Button) findViewById(R.id.cccc);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b6 = (Button) findViewById(R.id.button6);
        b5 = (Button) findViewById(R.id.button5);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        btnUpload = (Button) findViewById(R.id.button_upload);
        btnXml = (Button) findViewById(R.id.btn_xmlParsing);
        btnJsonParsingWeb = (Button) findViewById(R.id.btn_JsonParsingWeb);
        btnXmlParsingWeb = (Button) findViewById(R.id.btn_xmlParsingWeb);
        buttonGoogleMap = (Button) findViewById(R.id.button_GoogleMap);
        buttonGoogleRoute = (Button) findViewById(R.id.button_GoogleMapRoute);
        buttonSettings = (Button) findViewById(R.id.button_Settings);
        buttonRecycler = (Button) findViewById(R.id.button_Recycler);
        button_fragments = (Button) findViewById(R.id.button_fragments);
        button_tab = (Button) findViewById(R.id.button_tab) ;
        button_NavigationDrawer = (Button) findViewById(R.id.button_NavigationDrawer);
        button_sharedPreference = (Button) findViewById(R.id.button_sharedPreference);



        l1 = (LinearLayout) findViewById(R.id.layout1);
        l2 = (LinearLayout) findViewById(R.id.layout2);
        l3 = (LinearLayout) findViewById(R.id.layout3);
        l4 = (LinearLayout) findViewById(R.id.layout4);
        l5 = (LinearLayout) findViewById(R.id.layout5);
        l6 = (LinearLayout) findViewById(R.id.layout6);
        l7 = (LinearLayout) findViewById(R.id.layout7);
        l8 = (LinearLayout) findViewById(R.id.layout8);



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);


        SearchManager searchManager=(SearchManager) getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView=(SearchView) menu.findItem(R.id.action_search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }



        return super.onOptionsItemSelected(item);
    }
}
