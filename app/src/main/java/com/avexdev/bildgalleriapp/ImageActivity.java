package com.avexdev.bildgalleriapp;

import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ImageActivity extends AppCompatActivity{
    TextView TextView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);
        imageView = findViewById(R.id.imageView);
        TextView = findViewById(R.id.textView);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String imageBitmapString = (String) extras.get("Picture");
        //Konvertera string till bitmap
        Bitmap imageBitmap = BitMap.getBitmapFromString(imageBitmapString);
        String description = (String) extras.get("Description");
        imageView.setImageBitmap(imageBitmap);
        TextView.setText(description);
    }
}
