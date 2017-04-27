package com.example.myfirstproject.uil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Created by next on 6/5/16.
 */
public class JsonParsing extends AppCompatActivity {

    TextView jsontxtView;
    LinearLayout jsonLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsonparse);
        getViewCastings();
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        String strJson = "[ {\"id\": \"0001\",\"type\": \"donut\",\"name\":\"Cake\",\"ppu\": 0.55,\"batters\": {\"batter\": [{\"id\": \"1001\",\"type\": \"Regular\"            },            {                \"id\": \"1002\",                    \"type\": \"Chocolate\"            },            {                \"id\": \"1003\",                    \"type\": \"Blueberry\"            },            {                \"id\": \"1004\",                    \"type\": \"Devil's Food\"            }            ]        },            \"topping\": [            {                \"id\": \"5001\",                    \"type\": \"None\"            },            {                \"id\": \"5002\",                    \"type\": \"Glazed\"            },            {                \"id\": \"5005\",                    \"type\": \"Sugar\"            },            {                \"id\": \"5007\",                    \"type\": \"Powdered Sugar\"            },            {                \"id\": \"5006\",                    \"type\": \"Chocolate with Sprinkles\"            },            {                \"id\": \"5003\",                    \"type\": \"Chocolate\"            },            {                \"id\": \"5004\",                    \"type\": \"Maple\"            }            ]        },        {            \"id\": \"0002\",                \"type\": \"donut\",                \"name\": \"Raised\",                \"ppu\": 0.55,                \"batters\": {            \"batter\": [            {                \"id\": \"1001\",                    \"type\": \"Regular\"            }            ]        },            \"topping\": [            {                \"id\": \"5001\",                    \"type\": \"None\"            },            {                \"id\": \"5002\",                    \"type\": \"Glazed\"            },            {                \"id\": \"5005\",                    \"type\": \"Sugar\"            },            {                \"id\": \"5003\",                    \"type\": \"Chocolate\"            },            {                \"id\": \"5004\",                    \"type\": \"Maple\"            }            ]        },        {            \"id\": \"0003\",                \"type\": \"donut\",                \"name\": \"Old Fashioned\",                \"ppu\": 0.55,                \"batters\": {            \"batter\": [            {                \"id\": \"1001\",                    \"type\": \"Regular\"            },            {                \"id\": \"1002\",                    \"type\": \"Chocolate\"            }            ]        },            \"topping\": [            {                \"id\": \"5001\",                    \"type\": \"None\"            },            {                \"id\": \"5002\",                    \"type\": \"Glazed\"            },            {                \"id\": \"5003\",                    \"type\": \"Chocolate\"            },            {                \"id\": \"5004\",                    \"type\": \"Maple\"            }            ]        }      ]";

        String data = " ";




        try {
            JSONArray jsonArray = new JSONArray(strJson);

            for(int i=0; i < jsonArray.length(); i++) {
                JSONObject jsonObject= jsonArray.getJSONObject(i);
                String id= jsonObject.getString("id");
                String type= jsonObject.getString("type");
                String name= jsonObject.getString("name");
                String ppu= jsonObject.getString("ppu");


                JSONObject jsonObject1=jsonObject.getJSONObject("batters");
                JSONArray jsonArray1=jsonObject1.getJSONArray("batter");

                data += "id = "+id+      // Concatenation
                        "\n type = "+type+
                        "\n name = "+name+"" +
                        "\n ppu = "+ppu+"" +
                        "\n---- Batters \n";
                 for(int j=0; j < jsonArray1.length(); j++){

                     JSONObject jsonObject2=jsonArray1.getJSONObject(j);
                     String id1=jsonObject2.getString("id");
                     String type1= jsonObject2.getString("type");
                     data += "id1 " +id1+ "\n type " +type1+"\n";
                 }
                data += "----Toppings \n";

                JSONArray jsonArray2=jsonObject.getJSONArray("topping");
                for (int k=0;k < jsonArray2.length() ; k++){
                    JSONObject jsonObject3=jsonArray2.getJSONObject(k);
                    String id2=jsonObject3.getString("id");
                    String type2= jsonObject3.getString("type");
                    data += " id2 " +id2+ "\n type " +type2+"\n";
                }
                data+="\n\n";
                data += "---------------------------------- \n";
            }

            jsontxtView.setText(data);


    } catch (JSONException e) {e.printStackTrace();}

    }

    public void getViewCastings(){
        jsonLayout = (LinearLayout) findViewById(R.id.json_layout);
        jsontxtView = (TextView) findViewById(R.id.json_txtView);


    }
}
