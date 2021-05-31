package com.gec.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnt,btnc;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("HELLO TOAST");
        btnc = findViewById(R.id.count);
        btnt = findViewById(R.id.toast);
        textView = findViewById(R.id.txtView);
        textView.setText("0");

        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "hello toast", Toast.LENGTH_SHORT).show();
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            int i=0;
            @Override
            public void onClick(View view) {

                i += 1;
                textView.setText(""+i);

            }
        });
    }
}