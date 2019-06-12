package com.example.materialtest;

public class WP {

    private String name;

    private int imageid;

    public WP(String name,int imageid){
        this.imageid=imageid;
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public int getImageid(){
        return imageid;
    }
}
