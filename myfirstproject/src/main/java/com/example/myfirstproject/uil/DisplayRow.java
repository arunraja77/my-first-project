package com.example.myfirstproject.uil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.myfirstproject.uil.RowAndColumn;


/**
 * Created by next on 3/5/16.
 */
public class DisplayRow extends AppCompatActivity {

    LinearLayout l1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);

        getViewCastings();
//        init();

    }
//
//    public void init(){
//
//
//        String rows=editText_row.getText().toString();
//        int y = Integer.parseInt(rows);
//
//
//        for (int i = 0; i < y; i++) {
//
//            Button b1=new Button(this);
////            b1.setImageResource(R.drawable.sn);
//            b1.setText("MyButton");
//
//            l1.addView(b1);
//
//        }
//    }

   public void getViewCastings(){
       l1 = (LinearLayout) findViewById(R.id.layout_rowcolumn);

   }
}
