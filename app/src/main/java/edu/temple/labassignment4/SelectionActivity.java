package edu.temple.labassignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    ListView listView;
    ImageView imageView;
    ImageView spinnerImageView;
    Spinner spinner;
    int[] dogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        getSupportActionBar().setTitle("Item Selection");

        //imageView = findViewById(R.id.imageView);
        spinner = findViewById(R.id.spinner);
        spinnerImageView = findViewById(R.id.spinnerImage);
        //String[] dogArray = new String[]{"dog1","dog2","dog3","dog4","dog5"};
        ArrayList dogList = new ArrayList<String>();
        dogList.add("activity 1");
        dogList.add("dog1");
        dogList.add("dog2");dogList.add("dog3");dogList.add("dog4");dogList.add("dog5");

        dogs = new int[]{R.drawable.dog1,R.drawable.dog2,R.drawable.dog3,R.drawable.dog4,R.drawable.dog5};

        //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,dogArray);
        myAdapter adapter = new myAdapter(this,dogList,dogs);
        //listView.setAdapter(adapter);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position>0){
                    //imageView.setVisibility(View.VISIBLE);
                    //spinnerImageView.setVisibility(View.INVISIBLE);
                    //showPicture(position-1);

                    Intent act2 = new Intent(SelectionActivity.this, DisplayActivity.class);
                    act2.putExtra("imageTitle",dogList.get(position).toString());
                    act2.putExtra("imageID",dogs[position]);
                    startActivity(act2);
                }else{
                    //imageView.setVisibility(View.INVISIBLE);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                //imageView.setVisibility(View.GONE);
            }
        });
        //create new intent
//        Intent launchIntent = new Intent(SelectionActivity.this, DisplayActivity.class);
//        startActivity(LaunchIntent);
    }

    public void showPicture (int position){
        imageView.setImageResource(dogs[position]);
    }
}