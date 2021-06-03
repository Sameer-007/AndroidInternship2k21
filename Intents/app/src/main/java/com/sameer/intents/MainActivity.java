package com.sameer.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText name1,number,url,lat,lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name1 = findViewById(R.id.my);
        number = findViewById(R.id.number);
        url = findViewById(R.id.web);
        lat = findViewById(R.id.lat);
        lon = findViewById(R.id.lon);
    }

    public void next(View view) {
       String n = name1.getText().toString();
        Intent nam = new Intent(this,com.sameer.intents.name.class);
       nam.putExtra("name",n);
        startActivity(nam);
    }

    public void Call(View view) {
        String dail = number.getText().toString();
        Uri uri;
        uri =  Uri.parse("tel:"+dail);
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(i);
    }

    public void browse(View view) {
        String br = url.getText().toString();
        Uri uri;
        uri =  Uri.parse("https://"+br);
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);
    }

    public void map(View view) {
        String la = lat.getText().toString();
        String lo = lon.getText().toString();
        Uri longi,lati;
        longi = Uri.parse("longit")

    }
}