package edu.temple.labassignment4;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class myAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;
    int[] imageID;
    public myAdapter(Context context, ArrayList items, int[] imageID){
        this.context = context;
        this.items = items;
        this.imageID = imageID;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);
        textView.setText(items.get(position));
        textView.setGravity(Gravity.CENTER);
        return textView;

    }

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent){
        if(position>0){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.spinner_layout,parent,false);
            TextView textView = (TextView)row.findViewById(R.id.spinnerText);
            textView.setText(items.get(position));
            textView.setGravity(Gravity.CENTER);
            ImageView imageView = (ImageView)row.findViewById(R.id.spinnerImage);
            imageView.setImageResource(imageID[position - 1]);
            return row;
        }else{
            TextView textView = new TextView(context);
            textView.setText(items.get(position));
            textView.setGravity(Gravity.CENTER);
            return textView;
        }


    }
}
