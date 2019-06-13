package com.example.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class wpAdapter extends RecyclerView.Adapter<wpAdapter.viewHolder> {

    private Context mcontent;

    private List<WP> wpList;

    wpAdapter(Context context, List<WP> list){
        this.mcontent=context;
        this.wpList=list;
    }

    @NonNull
    @Override
    public wpAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,  int  i) {
        View view= LayoutInflater.from(mcontent).inflate(R.layout.wp_item,viewGroup,false);
        final wpAdapter.viewHolder viewHolder=new wpAdapter.viewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=viewHolder.getAdapterPosition();
                Intent intent = new Intent(mcontent, item_Detail.class);
                intent.putExtra(item_Detail.WP_NAME,wpList.get(p).getName());
                intent.putExtra(item_Detail.WP_IMAGE,wpList.get(p).getImageid());
                mcontent.startActivity(intent);
            }
        });
        return viewHolder;
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

        CardView cardView;

        private viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.wpimage);
            textView=itemView.findViewById(R.id.wptext);
            cardView=itemView.findViewById(R.id.card_view);
        }
    }
}
