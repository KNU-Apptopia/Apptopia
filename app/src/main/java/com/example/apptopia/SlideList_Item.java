package com.example.apptopia;

import android.graphics.drawable.Drawable;

public class SlideList_Item {
    private int id;
    private Drawable icon;
    private String name;
    private String contents;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
