package com.sameer.recycler2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements Radopter.Myinterface {
    int tprice=0;
    RecyclerView recyclerView;
    Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleviewer);
        int [] images = { R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e, R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j};
        String [] names = { "chk biryani","chk fry","chk curry","mutton curry","mutton biryani", "fish fry","fish curry","prawns curry","prawns biryani","chk lolipop"};
        String [] prices = {"150","100","100","450","350","200","180","350","400","250"};
        pay= findViewById(R.id.pay);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Radopter radopter = new Radopter(this,images,names,prices,this);
        recyclerView.setAdapter(radopter);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               pay.setText("The total amount to pay is "+tprice);
               
            }
        });

        }

    @Override
    public void selecteditems(String itemname, String itemprice, int position, int totalprice) {
        tprice = tprice+Integer.parseInt(String.valueOf(totalprice));

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
