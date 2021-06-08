package com.sameer.recycler2;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Radopter extends RecyclerView.Adapter<Radopter.MyviewHolder> {


    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull Radopter.MyviewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        public MyviewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

        }
    }
}
