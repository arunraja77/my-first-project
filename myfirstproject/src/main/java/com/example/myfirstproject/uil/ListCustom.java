package com.example.myfirstproject.uil;




import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListCustom extends ArrayAdapter<String>{



    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    public ListCustom(Activity context,
                      String[] web, Integer[] imageId) {
        super(context, R.layout.listview_with_image, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
        System.out.println("Coming to listCustom");

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        System.out.println("Inflate Start");
        View rowView= inflater.inflate(R.layout.listview_with_image, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.list_textView);
        System.out.println("Set Image and Text");
        ImageView imageView = (ImageView) rowView.findViewById(R.id.list_imageView);
        txtTitle.setText(web[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}



////
//import android.app.Activity;
//import android.content.Context;
//import android.support.v7.app.AppCompatActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//
///**
// * Created by next on 23/5/16.
// */
//public class ListCustom extends ArrayAdapter<String> {
//    private final Activity context;
//    private final String[] web;
//    private final Integer[] imageId;
//
//    public ListCustom(Activity context, String[] web, Integer[] imageId) {
//        super(context, R.layout.listviewimage_zx,web);
//        System.out.println("step check");
//
//        this.context = context;
//        this.web = web;
//        this.imageId = imageId;
//    }
// public View getView(int position, View view, ViewGroup parent){
//     System.out.println("inflate start");
//     LayoutInflater layoutInflater=context.getLayoutInflater();
//     System.out.println("inflate start2");
//     View rowView =layoutInflater.inflate(R.layout.listviewimage_zx,null, true);
//
//     TextView txtTitle = (TextView) rowView.findViewById(R.id.list_text);
//     ImageView imageView = (ImageView) rowView.findViewById(R.id.list_image);
//
//     txtTitle.setText(web[position]);
//     imageView.setImageResource(imageId[position]);
//
//
//     return rowView;
// }
//
//}


