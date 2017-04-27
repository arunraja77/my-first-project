package com.example.myfirstproject.uil;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Selection;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



import org.w3c.dom.Text;

public class Grid extends AppCompatActivity{

    GridView g1;
    TextView t1;
    private ImageView Selection;






    public static final String[] numbers=new String[]{
            "1","2",
            "3","4",
            "5","6",
            "7","8",
            "9","10",
            "11","12"

    };
    /* public Integer[] mThumbIds = {
            R.drawable.i1, R.drawable.i2,
            R.drawable.i1, R.drawable.i2,
            R.drawable.i1, R.drawable.i2,
            R.drawable.i1, R.drawable.i2,
            R.drawable.i1, R.drawable.i2,

    }; */
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        getViewCastings();


        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        DynamicGrid dg = new DynamicGrid(getApplicationContext());
        g1.setAdapter(dg);

       /* ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,mThumbIds);

        g1.setAdapter(adapter);



        g1.setOnItemClickListener(new OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
               Toast.makeText(getApplicationContext(),"clicked item at :"+position,Toast.LENGTH_SHORT).show();
           }
       });*/

    }
    public void getViewCastings()

    {
        g1 =(GridView) findViewById(R.id.grid1);

    }
}
