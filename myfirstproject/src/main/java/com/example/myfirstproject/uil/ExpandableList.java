package com.example.myfirstproject.uil;



        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import android.app.Activity;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.ExpandableListView;
        import android.widget.ExpandableListView.OnChildClickListener;
        import android.widget.ExpandableListView.OnGroupClickListener;
        import android.widget.ExpandableListView.OnGroupCollapseListener;
        import android.widget.ExpandableListView.OnGroupExpandListener;
        import android.widget.Toast;

public class ExpandableList extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Operating Systems");
        listDataHeader.add("Language");
        listDataHeader.add("Database");

        // Adding child data
        List<String> os = new ArrayList<String>();
        os.add("Android");
        os.add("Windows");
        os.add("Linux");


        List<String> language = new ArrayList<String>();
        language.add("C");
        language.add("C++");
        language.add("Java");


        List<String> db = new ArrayList<String>();
        db.add("SQL");
        db.add("MySQL");
        db.add("SQLite");


        listDataChild.put(listDataHeader.get(0), os); // Header, Child data
        listDataChild.put(listDataHeader.get(1), language);
        listDataChild.put(listDataHeader.get(2), db);
    }
}