package com.example.ignas.fakestache;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Ignas on 2016-11-13.
 */

public class GridAdapter extends BaseAdapter {

    LayoutInflater inflater;
    List<ImageItem> items;


    public GridAdapter(Context context, List<ImageItem> items) {
        this.items = items;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return items.size();
    }


    @Override
    public Object getItem(int position) {
        return items.get(items.size() - position - 1);
    }


    @Override
    public long getItemId(int position) {
        return items.size() - position - 1;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item, null);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        Bitmap image = items.get(items.size() - position - 1).getImage();

        if (image != null){
            imageView.setImageBitmap(image);
        }

        return convertView;
    }

}
