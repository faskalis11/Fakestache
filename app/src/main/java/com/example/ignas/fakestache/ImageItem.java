package com.example.ignas.fakestache;

import android.graphics.Bitmap;
import android.util.Log;

/**
 * Created by Ignas on 2016-11-13.
 */

public class ImageItem {

    private String path;
    private boolean isDirectory;
    private Bitmap image;


    public ImageItem(String path, boolean isDirectory, Bitmap image) {
        this.path = path;
        this.isDirectory = isDirectory;
        this.image = image;
    }


    public String getPath() {
        return path;
    }


    public boolean isDirectory() {
        return isDirectory;
    }


    public Bitmap getImage() {
        if (this.image == null){
            this.image = BitmapHelper.decodeBitmapFromFile(path, 256, 256);
            Log.d("Bitmap", "Decoding " + path);
        }
        return image;
    }
}