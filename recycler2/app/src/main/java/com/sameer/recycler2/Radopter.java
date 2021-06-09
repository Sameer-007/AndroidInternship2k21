package com.sameer.recycler2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class Radopter extends RecyclerView.Adapter<Radopter.MyviewHolder> {

    Myinterface myinterface;
    Context ct;
    int[] myimages;
    String[] mynames,myprices;

    public Radopter(MainActivity mainActivity, int[] images, String[] names, String[] prices, Myinterface myinterface) {
        ct = mainActivity;
        myimages = images;
        this.myinterface = myinterface;
        myprices = prices;
        mynames = names;
    }
    public  interface Myinterface{
        void selecteditems(String itemname,String itemprice,int position,int totalprice);

    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.row,parent,false);
        MyviewHolder myviewHolder  = new MyviewHolder(v);
        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull Radopter.MyviewHolder holder, int position) {
    holder.iv.setImageResource(myimages[position]);
    holder.tv1.setText(mynames[position]);
    holder.tv2.setText(myprices[position]);
   /* holder.elegantNumberButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
        @Override
        public void onClick(View view) {
            String num =  holder.elegantNumberButton.getNumber();
            Toast.makeText(ct, " "+num, Toast.LENGTH_SHORT).show();
        }
    });*/
        holder.elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                Log.i("yes",String.valueOf(oldValue));
                Log.i("yes",String.valueOf(newValue));
                //Toast.makeText(ct, "Updated from"+String.valueOf(oldValue)+" to "+String.valueOf(newValue), Toast.LENGTH_SHORT).show();
                String name= holder.tv1.getText().toString();
                int price = Integer.parseInt((String) holder.tv2.getText());
                int totalprice = price*newValue;
                myinterface.selecteditems(name,String.valueOf(price),position,totalprice);
            }
        });

    }

    @Override
    public int getItemCount() {

        return myimages.length;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1,tv2;
        ElegantNumberButton elegantNumberButton;

        public MyviewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.image);
            tv1 = itemView.findViewById(R.id.name);
            tv2 = itemView.findViewById(R.id.price);
            elegantNumberButton = itemView.findViewById(R.id.number_button);
        }
    }
}
