package com.example.myfirstproject.uil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by next on 9/5/16.
 */
public class XmlParsing extends AppCompatActivity{

    TextView txtViewXml;
    ListView listView;

    private  String XMLData= "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <employees> <employee> <id>1</id>  <name>Sachin</name> <salary>50000</salary> </employee> <employee> <id>2</id> <name>Nikhil</name> <salary>60000</salary></employee> <employee> <id>3</id> <name>Malar</name> <salary>50000</salary></employee><employee> <id>4</id> <name>Priya</name> <salary>60000</salary></employee> </employees>";

    private Employee employee;
    private List<Employee> listemployees= new ArrayList<Employee>();

    String text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlparsing);
        getViewCastings();

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        XmlPullParserFactory factory = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(XMLData));

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("employee")) {

                            employee = new Employee();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("employee")) {
                            listemployees.add(employee);
                        }else if (tagname.equalsIgnoreCase("id")) {
                            employee.setId(Integer.parseInt(text));
                        }  else if (tagname.equalsIgnoreCase("name")) {
                            employee.setName(text);
                        } else if (tagname.equalsIgnoreCase("salary")) {
                            employee.setSalary(Float.parseFloat(text));
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }


        ArrayAdapter<Employee> adapter=new ArrayAdapter<Employee>(this,android.R.layout.simple_list_item_1,listemployees);
        listView.setAdapter(adapter);
    }








    public void getViewCastings(){
        txtViewXml = (TextView) findViewById(R.id.txtView_xml);
        listView = (ListView) findViewById(R.id.listView1);

    }

    }
