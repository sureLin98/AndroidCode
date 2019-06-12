package com.example.materialtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class wpAdapter extends RecyclerView.Adapter<wpAdapter.viewHolder> {

    Context mcontent;

    List<WP> wpList;

    public wpAdapter(Context context,List<WP> list){
        this.mcontent=context;
        this.wpList=list;
    }

    @NonNull
    @Override
    public wpAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mcontent).inflate(R.layout.wp_item,viewGroup,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull wpAdapter.viewHolder viewHolder, int i) {
        viewHolder.textView.setText(wpList.get(i).getName());
        Glide.with(mcontent).load(wpList.get(i).getImageid()).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return wpList.size();
    }

    static class viewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.wpimage);
            textView=itemView.findViewById(R.id.wptext);
        }
    }
}
