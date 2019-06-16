package com.example.homework_3;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter <MyViewHolder> {

    ArrayList<Task> data;
    private onTaskClickListener clickListener;


    public MyAdapter(onTaskClickListener listener) {
        clickListener = listener;

        data = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v = layoutInflater.inflate(R.layout.view_holder_my, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(v, clickListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.onBind(data.get(i));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


}

