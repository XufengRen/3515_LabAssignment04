package edu.temple.labassignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent=getIntent();
        String imageTitle = intent.getStringExtra("imageTitle");
        int imageID = intent.getIntExtra("imageID",0);
        TextView textView = findViewById(R.id.display_textView);
        textView.setText(imageTitle);

        ImageView imageView=findViewById(R.id.display_imageView);
        imageView.setImageResource(imageID);

        Intent onClose = new Intent();
        onClose.putExtra("keyword", "0");
        setResult(RESULT_OK, onClose);
    }
}