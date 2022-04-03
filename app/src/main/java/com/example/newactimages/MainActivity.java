package com.example.newactimages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int[] image = new int[] {R.drawable.bear, R.drawable.imagechina, R.drawable.uwu, R.drawable.shrek, R.drawable.space};
    String[] names = new String[] {"Bear", "Chinese Person", "UwU Girl", "Shrek The Green", "Space Man"};

    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recyclerView);

        LinearLayoutManager layout = new LinearLayoutManager(MainActivity.this);
        recycler.setLayoutManager(layout);
        recycler.setAdapter(new ImageAdap(MainActivity.this, image, names));
    }
}