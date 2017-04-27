


package com.example.myfirstproject.uil;

        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;



public class EgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eglayout);

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        LinearLayout l = (LinearLayout) findViewById(R.id.dynamic1);
        LinearLayout l_parent = new LinearLayout(this);
        l_parent.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams LLParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LLParams.setMargins(10,5,5,5);
        l_parent.setLayoutParams(LLParams);
        l_parent.setGravity(5);
        l_parent.setPadding(10,10,10,10);

        ImageView l2 = new ImageView(this);
        l2.setImageResource(R.drawable.sn);
        l2.setPadding(10,5,5,5);

        ImageView l3 = new ImageView(this);
        l3.setImageResource(R.drawable.sound);
        l3.setPadding(10,5,5,5);

        l_parent.addView(l3);
        l_parent.addView(l2);
        l.addView(l_parent);



        LinearLayout ll = (LinearLayout) findViewById(R.id.dynamic2);
        LinearLayout l_parentt = new LinearLayout(this);
        l_parent.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams LLParamss = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LLParams.setMargins(10,100,5,5);
        l_parentt.setLayoutParams(LLParamss);
        l_parentt.setGravity(5);
        l_parentt.setPadding(10,10,10,10);

        ImageView l4 = new ImageView(this);
        l4.setImageResource(R.drawable.sound2);
        l4.setPadding(10,5,5,5);

        ImageView l5 = new ImageView(this);
        l5.setImageResource(R.drawable.sound3);
        l5.setPadding(10,5,5,5);

        l_parentt.addView(l4);
        l_parentt.addView(l5);


        TextView tv = new TextView(this);
        tv.setText("Arun");
        tv.setBackgroundColor(0x528881);
        tv.setTextColor(0xFFF);

        l_parent.addView(tv);

        l.addView(l_parentt);










    }

}
