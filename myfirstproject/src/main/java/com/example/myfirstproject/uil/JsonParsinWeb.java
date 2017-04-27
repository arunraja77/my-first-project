package com.example.myfirstproject.uil;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.HttpResponseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

/**
 * Created by next on 10/5/16.
 */
public class JsonParsinWeb extends AppCompatActivity {
    TextView txtViewJsonWeb;

    String data;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsonparsingweb);
        getViewCastings();

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        // Execute background task to read json string from url

        BackTaskGetJSON backTaskGetJSON= new BackTaskGetJSON();
        backTaskGetJSON.execute();

    }

    private void showResult(String jsonString){


        //Parse Json and show output
        try {
            JSONArray jArray = new JSONArray(jsonString);
            for(int i=0; i < jArray.length(); i++) {

                JSONObject jObject = jArray.getJSONObject(i);

                String outlet_id = jObject.getString("outlet_id");
                String cityid = jObject.getString("cityid");
                String outlet_name = jObject.getString("outlet_name");

                data += "outlet_id = "+outlet_id+    // Concatenation
                        " \n cityid = " +cityid+
                        "\n outlet_name = "+outlet_name+"" +
                        "\n  \n";




            } // End Loop

            txtViewJsonWeb.setText(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //background process to get outlet info at remote server
    private class BackTaskGetJSON extends AsyncTask<String,Void,Void> {

        private ProgressDialog progressDialog = new ProgressDialog(JsonParsinWeb.this);
        String jsonString = "";
        InputStream inputStream = null;

        protected void onPreExecute() {
            progressDialog.setMessage("Downloading your data...");
            progressDialog.show();
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface arg0) {
                    BackTaskGetJSON.this.cancel(true);
                }
            });
        }



        protected Void doInBackground(String... params) {

            String url = "http://www.gtwebsolutions.net/hd/getoutlet.php";

                try {
                    // Set up HTTP post

                    // HttpClient is more then less deprecated. Need to change to URLConnection


                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(url);
                    HttpResponse httpResponse = httpClient.execute(httpPost);
                    HttpEntity httpEntity = httpResponse.getEntity();

                    // Read content & Log
                    inputStream = httpEntity.getContent();
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                } catch (ClientProtocolException e2) {
                    Log.e("ClientProtocolException", e2.toString());
                    e2.printStackTrace();
                } catch (IllegalStateException e3) {
                    Log.e("IllegalStateException", e3.toString());
                    e3.printStackTrace();
                } catch (IOException e4) {
                    Log.e("IOException", e4.toString());
                    e4.printStackTrace();
                }
                // Convert response to string using String Builder
                try {
                    BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
                    StringBuilder sBuilder = new StringBuilder();

                    /*
     * To convert the InputStream to String we use the BufferedReader.readLine()
     * method. We iterate until the BufferedReader return null which means
     * there's no more data to read. Each line will appended to a StringBuilder
     * and returned as String.
     */

                    String line = null;
                    while ((line = bReader.readLine()) != null) {
                        sBuilder.append(line + "\n");
                    }

                    inputStream.close();
                    jsonString = sBuilder.toString();

                } catch (Exception e) {
                    Log.e("StringReader", "Erroresult " + e.toString());
                }

                return null;

        }

        protected void onPostExecute(Void result){
            try{
                System.out.println("jsonString"+jsonString);
                if(!jsonString.equals("")) {
                    showResult(jsonString);
                }

            }catch(Exception e){e.printStackTrace();}
        }


    }

    protected void getViewCastings(){

        txtViewJsonWeb = (TextView) findViewById(R.id.txtView_JsonWeb);

    }
}
