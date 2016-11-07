package com.example.ignas.fakestache;

import ly.img.android.ImgLySdk;



public class Fakestache extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();

        ImgLySdk.init(this);
    }
}
