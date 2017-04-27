package com.example.myfirstproject.uil;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
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

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by next on 10/5/16.
 */
public class JsonParsingWeb extends AppCompatActivity {
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

            JSONArray jsonArray=new JSONArray(jsonString);

            for(int i=0 ; i< jsonArray.length() ; i++) {


                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String full_name = jsonObject.getString("full_name");


                data += "id = " + id +
                        "name = " + name +
                        "\n full_name = " + full_name + "" +
                        "\n---------Owner  \n";

            }


            txtViewJsonWeb.setText(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //background process to get outlet info at remote server
    private class BackTaskGetJSON extends AsyncTask<String,Void,Void> {

        private ProgressDialog progressDialog = new ProgressDialog(JsonParsingWeb.this);
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

            HttpURLConnection httpURLConnection = null;
            StringBuilder result = new StringBuilder();
//            String url = "https://api.github.com/users/mralexgray/repos";

            try {



                URL url = new URL("hhttps://api.github.com/users/mralexgray/repos");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(httpURLConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                line= reader.readLine();
                while ((line) != null) {
                    result.append(line);
                    System.out.println("Result" +result );
                }

            }catch( Exception e) {
                e.printStackTrace();
            }
            finally {
                httpURLConnection.disconnect();
            }


            return null;



        }
        protected void onPostExecute(Void result){
            try{


                System.out.println("jsonString"+jsonString);

                    showResult(jsonString);
                progressDialog.dismiss();



            }
            catch(Exception e){
                e.printStackTrace();
            }

        }


    }

    protected void getViewCastings(){

        txtViewJsonWeb = (TextView) findViewById(R.id.txtView_JsonWeb);

    }
}


// Set up HTTP post
// HttpClient is more then less deprecated. Need to change to URLConnection
//                HttpClient httpClient = new DefaultHttpClient();
//
//                HttpPost httpPost = new HttpPost(url);
//                HttpResponse httpResponse = httpClient.execute(httpPost);
//                HttpEntity httpEntity = httpResponse.getEntity();


// Read content & Log
//                inputStream = httpEntity.getContent();


//            } catch (UnsupportedEncodingException e1) {
//                e1.printStackTrace();
//            } catch (ClientProtocolException e2) {
//                Log.e("ClientProtocolException", e2.toString());
//                e2.printStackTrace();
//            } catch (IllegalStateException e3) {
//                Log.e("IllegalStateException", e3.toString());
//                e3.printStackTrace();
//            } catch (IOException e4) {
//                Log.e("IOException", e4.toString());
//                e4.printStackTrace();
//            }
//            // Convert response to string using String Builder
//            try {
//                BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
//                StringBuilder sBuilder = new StringBuilder();
//
//                String line = null;
//                while ((line = bReader.readLine()) != null) {
//                    sBuilder.append(line + "\n");
//                }
//
//                inputStream.close();
//                jsonString = sBuilder.toString();
//
//            } catch (Exception e) {
//                Log.e("StringReader", "Erroresult " + e.toString());
//            }
//            return null;