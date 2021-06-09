package com.sameer.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
Button search;
TextView ac,cc,rc,dc;
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
        dc = findViewById(R.id.tc);
        country = findViewById(R.id.country);
        pd = new ProgressDialog(this);
        pd.setMessage("Please Wait....");
        pd.setProgress(ProgressDialog.STYLE_SPINNER);
        String url = "https://api.covid19api.com/";

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c = country.getText().toString().trim();
               // pd.show();
                Retrofit retrofit = new Retrofit.Builder()
                                                .baseUrl(url)
                                                .addConverterFactory(ScalarsConverterFactory.create())
                                                .build();
                Call<String> response = retrofit.create(Myinterface.class).getValue(c);
                response.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        pd.dismiss();
                        String res = response.body();
                        try {
                            JSONArray root = new JSONArray(res);
                            JSONObject obj = root.getJSONObject(root.length()-1);
                            String conf = obj.getString("Confirmed");
                            String active = obj.getString("Active");
                            String rec = obj .getString("Recovered");
                            String dea = obj.getString("Deaths");
                            ac.setText("Active cases are "+active);
                            cc.setText("Confirmed cases are "+conf);
                            dc.setText("Deaths reported are "+dea);
                            rc.setText("Recovered cases are "+rec);


                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                       pd.dismiss();
                        Toast.makeText(MainActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                    }
                });










            }
        });
    }
}