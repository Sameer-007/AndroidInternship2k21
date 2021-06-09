package com.sameer.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
Button search;
TextView ac,cc,rc,tc;
EditText country;
ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search = findViewById(R.id.search);
        ac = findViewById(R.id.ac);
        rc = findViewById(R.id.rc);
        cc = findViewById(R.id.cc);
        tc = findViewById(R.id.tc);
        country = findViewById(R.id.country);
        pd.setMessage("Please Wait....");
        pd.setProgress(ProgressDialog.STYLE_SPINNER);
        String url = "https://api.covid19api.com/";

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = country.getText().toString().trim();
                pd.show();
                Retrofit retrofit = new Retrofit.Builder()
                                                .baseUrl(url)
                                                .addConverterFactory(ScalarsConverterFactory.create())
                                                .build();
                Call<String> response = retrofit.create(Myinterface.class).getValue(c);










            }
        });
    }
}