package com.sameer.recycler2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Radopter extends RecyclerView.Adapter<Radopter.MyviewHolder> {


    Context ct;
    int[] myimages;
    String[] mynames,myprices;

    public Radopter(MainActivity mainActivity, int[] images, String[] names, String[] prices) {
        ct = mainActivity;
        myimages = images;
        myprices = prices;
        mynames = names;
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
    holder.tv2.setText(mynames[position]);
    }

    @Override
    public int getItemCount() {

        return myimages.length;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1,tv2;

        public MyviewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.image);
            tv1 = itemView.findViewById(R.id.name);
            tv2 = itemView.findViewById(R.id.price);
        }
    }
}
