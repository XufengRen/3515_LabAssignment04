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

public class gridViewAdapter extends BaseAdapter {
    Context context;
    int[] items;
    int[] imageID;
    public gridViewAdapter(Context context, int[] items, int[] imageID){
        this.context = context;
        this.items = items;
        this.imageID = imageID;
    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.grid_layout,parent,false);
        TextView textView = (TextView)row.findViewById(R.id.gridText);
        textView.setText(items[position]);
        textView.setGravity(Gravity.CENTER);
        ImageView imageView = (ImageView)row.findViewById(R.id.gridImage);
        imageView.setImageResource(imageID[position]);
        return row;
    }
}
