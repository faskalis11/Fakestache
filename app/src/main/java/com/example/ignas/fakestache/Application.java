package com.example.ignas.fakestache;

import ly.img.android.ImgLySdk;



public class Application extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();

        ImgLySdk.init(this);
    }
}
