package com.sameer.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class name extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        String n = getIntent().getStringExtra("name");
        Toast.makeText(this, "welcome"+n, Toast.LENGTH_SHORT).show();
    }
}