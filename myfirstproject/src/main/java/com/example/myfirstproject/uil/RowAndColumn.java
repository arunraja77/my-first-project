package com.example.myfirstproject.uil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by next on 3/5/16.
 */
public class RowAndColumn extends AppCompatActivity {

    TextView txtView_row, txtView_column;
    EditText editText_row, editText_column;
    Button btn_submit, addBtn, minusBtn;
    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    HorizontalScrollView horizontalScrollView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rowandcolumns);

        getViewCastings();
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String x = editText_row.getText().toString();
                int rows = Integer.parseInt(x);
                String y = editText_column.getText().toString();
                int column = Integer.parseInt(y);


                if(x.equals("") && y.equals("")){
                   Toast.makeText(getApplicationContext()," Please Enter Row and Column",Toast.LENGTH_SHORT).show();
                }
                else {



                for (int i = 0; i < rows; i++) {


                    LinearLayout l_parent = new LinearLayout(getApplicationContext());
                    l_parent.setOrientation(LinearLayout.HORIZONTAL);
                    LinearLayout.LayoutParams LLParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    l_parent.setLayoutParams(LLParams);

                    HorizontalScrollView hsv = new HorizontalScrollView(getApplicationContext());
                    HorizontalScrollView.LayoutParams paramss = new HorizontalScrollView.LayoutParams(HorizontalScrollView.LayoutParams.WRAP_CONTENT, HorizontalScrollView.LayoutParams.WRAP_CONTENT);
                    hsv.setLayoutParams(paramss);

                    for (int j = 0; j < column; j++) {

                        Button b1 = new Button(getApplicationContext());
                        b1.setText("MyButton");
                        l_parent.addView(b1);
                    }
                    hsv.addView(l_parent);
                    linearLayout1.addView(hsv);

                }

                     }
            }


        });


    }




    public void getViewCastings() {

        txtView_row = (TextView) findViewById(R.id.txtView_row);
        txtView_column = (TextView) findViewById(R.id.txtView_column);
        editText_row = (EditText) findViewById(R.id.editText_row);
        editText_column = (EditText) findViewById(R.id.editText_column);
        btn_submit = (Button) findViewById(R.id.button_submit);


        linearLayout1 = (LinearLayout) findViewById(R.id.layout_rowcolumn);
//        linearLayout2 = (LinearLayout)findViewById(R.id.layout_rowcolumn2);
//        addBtn = (Button) findViewById(R.id.btn);


    }
}
















