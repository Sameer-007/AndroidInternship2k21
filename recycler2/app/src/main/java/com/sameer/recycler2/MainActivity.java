package com.sameer.recycler2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleviewer);
        int [] images = { R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e, R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};
        String [] names = { "chk biryani","chk fry","chk curry","mutton curry","mutton biryani", "fish fry","fish curry","prawns curry","prawns biryani","chk lolipop"};
        String [] prices = {"150","100","100","450","350","200","180","350","400","250"};
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Radopter radopter = new Radopter();
        recyclerView.setAdapter(radopter);
        }
    }
