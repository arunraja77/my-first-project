package com.example.myfirstproject.uil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.*;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by next on 11/5/16.
 */
public class XmlParsingWeb  extends AppCompatActivity {

    ListView listViewXmlweb;

    List<EmployeeXml> listtt = new  ArrayList<EmployeeXml>();

    private EmployeeXml employee;

    String text;


    static final String KEY_ITEM = "item";
    static final String KEY_TITLE = "title";
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_LINK = "link";
    static final String KEY_DATE = "date";


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.xmlparseweb);
        getViewCastings();

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        BackTaskGetJSON backTaskGetJSON = new BackTaskGetJSON();
        backTaskGetJSON.execute();

    }

    private List<EmployeeXml> showResult(String xmlString){
        try {
            XmlPullParserFactory factory = null;
            factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(xmlString));

            int eventType = parser.getEventType();

            System.out.println("eventType "+eventType);
            while (eventType != XmlPullParser.END_DOCUMENT) {

                String tagname = parser.getName();
                System.out.println("tagname "+tagname);
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("item")) {
                            employee = new EmployeeXml();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:

                        if (tagname.equalsIgnoreCase("item")) {
                            listtt.add(employee);
                        } else if (tagname.equalsIgnoreCase("title")) {
                            employee.setTitle(text);

                        } else if (tagname.equalsIgnoreCase("description")) {
                            employee.setDescription(text);

                        } else if (tagname.equalsIgnoreCase("link")) {
                            employee.setLink(text);

                        } else if (tagname.equalsIgnoreCase("date")) {
                            employee.setDate(text);

                        }


                    default:
                        break;
                }

                System.out.println("employee "+employee);




                eventType = parser.next();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        System.out.println("listtt "+listtt);
        ArrayAdapter<EmployeeXml> adapter=new ArrayAdapter<EmployeeXml>(getApplicationContext(),android.R.layout.simple_list_item_1,listtt);
        listViewXmlweb.setAdapter(adapter);
        return listtt;

    }




    private class BackTaskGetJSON extends AsyncTask<String,Void,Void> {

        private ProgressDialog progressDialog = new ProgressDialog(XmlParsingWeb.this);

        String xmlString = "";
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

            String url = "http://www.androidbegin.com/tutorial/XMLParseTutorial.xml";

            try {

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
                xmlString = sBuilder.toString();
                System.out.println("xmlString" +xmlString);


            } catch (Exception e) {
                Log.e("StringReader", "Erroresult " + e.toString());
            }

            return null;

        }

        protected void onPostExecute(Void result){
            try{

                progressDialog.dismiss();
                if(!xmlString.equals("")) {
                    showResult(xmlString);
                    System.out.println("listtt "+listtt);

                }




            }catch(Exception e){e.printStackTrace();}
        }



    }


    public void getViewCastings(){

        listViewXmlweb = (ListView) findViewById(R.id.listView_Xmlweb);




    }
    }
