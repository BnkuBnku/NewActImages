package com.example.newactimages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    ImageView image;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        name = findViewById(R.id.textView3);

        Intent i = getIntent();
        String N = i.getStringExtra("NAME");

        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("IMAGE");

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        image = (ImageView) findViewById(R.id.imageView2);
        image.setImageBitmap(bmp);
        name.setText(N);

    }
}