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
        ArrayList dogList = new ArrayList<String>();
        dogList.add("select fomr one of below");
        dogList.add("dog1");
        dogList.add("dog2");dogList.add("dog3");dogList.add("dog4");dogList.add("dog5");

        dogs = new int[]{R.drawable.dog1,R.drawable.dog2,R.drawable.dog3,R.drawable.dog4,R.drawable.dog5};


        myAdapter adapter = new myAdapter(this,dogList,dogs);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position>0){


                    Intent act2 = new Intent(SelectionActivity.this, DisplayActivity.class);
                    act2.putExtra("imageTitle",dogList.get(position).toString());
                    act2.putExtra("imageID",dogs[position-1]);
                    //startActivity(act2);
                    startActivityForResult(act2,0);
                }else{
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });
        //create new intent
//        Intent launchIntent = new Intent(SelectionActivity.this, DisplayActivity.class);
//        startActivity(LaunchIntent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==0){
            if(resultCode == RESULT_OK){
               spinner.setSelection(0);
            }
        }

    }

}