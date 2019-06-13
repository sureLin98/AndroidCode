package com.example.materialtest;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;


public class item_Detail extends AppCompatActivity {

    public static final String WP_NAME="wp_name";

    public static final String WP_IMAGE="wp_image";

    TextView wp_text;

    ImageView imageView;

    StringBuilder st;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);
        Intent intent=getIntent();
        String wp_name=intent.getStringExtra(WP_NAME);
        int wp_image=intent.getIntExtra(WP_IMAGE,0);

        CollapsingToolbarLayout collapsingToolbarLayout=findViewById(R.id.collapsing_toolbar);
        toolbar=findViewById(R.id.detail_toolbar);

        imageView=findViewById(R.id.detail_image_view);
        Glide.with(this).load(wp_image).into(imageView);

        Text(wp_name);
        wp_text=findViewById(R.id.detail_text_view);
        wp_text.setText(st);

        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(wp_name);
    }

    protected void Text(String str){
        st=new StringBuilder();
        for(int i=0;i<2000;i++){
            st.append(str).append("*$").append("\t");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
