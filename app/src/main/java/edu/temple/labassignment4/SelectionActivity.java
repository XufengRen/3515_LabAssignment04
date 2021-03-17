package edu.temple.labassignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    ListView listView;
    ImageView imageView;
    ImageView spinnerImageView;
    GridView gridView;
    Spinner spinner;
    int[] dogs;
    int[] imageNameList;
    TextView mainText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        getSupportActionBar().setTitle(R.string.selectpage_label);

        //imageView = findViewById(R.id.imageView);
//        spinner = findViewById(R.id.spinner);
//        spinnerImageView = findViewById(R.id.spinnerImage);
        gridView = findViewById(R.id.gridView);
        ArrayList dogList = new ArrayList<String>();
        //dogList.add("select fomr one of below");
//        dogList.add(R.string.selectpage_doglist_1);
//         dogList.add(R.string.selectpage_doglist_2);
//         dogList.add(R.string.selectpage_doglist_3);
//         dogList.add(R.string.selectpage_doglist_4);
//         dogList.add(R.string.selectpage_doglist_5);
        //dogList.add("dog1");dogList.add("dog1");dogList.add("dog1");dogList.add("dog1");dogList.add("dog1");

        // Store string values id in strings.xml to an array, pass the id which is an int to adapter or used for setText
        imageNameList = new int[] {R.string.selectpage_doglist_1,R.string.selectpage_doglist_2,R.string.selectpage_doglist_3,R.string.selectpage_doglist_4,R.string.selectpage_doglist_5};
        dogs = new int[]{R.drawable.dog1,R.drawable.dog2,R.drawable.dog3,R.drawable.dog4,R.drawable.dog5};


//        myAdapter adapter = new myAdapter(this,dogList,dogs);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                if (position>0){
//
//
//                    Intent act2 = new Intent(SelectionActivity.this, DisplayActivity.class);
//                    act2.putExtra("imageTitle",dogList.get(position).toString());
//                    act2.putExtra("imageID",dogs[position-1]);
//                    //startActivity(act2);
//                    startActivityForResult(act2,0);
//                }else{
//                }
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent){
//            }
//        });

        gridViewAdapter gridViewAdapter = new gridViewAdapter(this, imageNameList,dogs);
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent act2 = new Intent(SelectionActivity.this,DisplayActivity.class);
                act2.putExtra("imageTitle", imageNameList[position]);
                act2.putExtra("imageID", dogs[position]);
                startActivityForResult(act2,0);
            }
        });
//        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Intent act2 = new Intent(SelectionActivity.this,DisplayActivity.class);
//                act2.putExtra("imageTitle", imageNameList[position]);
//                act2.putExtra("imageID", dogs[position]);
//                startActivityForResult(act2,0);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//
//        });
        //create new intent
//        Intent launchIntent = new Intent(SelectionActivity.this, DisplayActivity.class);
//        startActivity(LaunchIntent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==0){
            if(resultCode == RESULT_OK){
//               spinner.setSelection(0);
            }
        }

    }

}