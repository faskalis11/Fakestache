package com.example.ignas.fakestache;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ImageActivity extends AppCompatActivity {
    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Bundle bundle = getIntent().getExtras();
        //String imagePath = bundle.getString(GalleryFragment.IMAGEPATH);
        pager = (ViewPager) findViewById(R.id.imagePager);

        pagerAdapter = new GridAdapter(getApplicationContext(), )






        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_mode_edit_black_24dp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public void viewImage() {
        //Bitmap bitmap;
        //Drawable drawable =new BitmapDrawable(bitmap); // iš list
        //imageSwitcher.setImageDrawable(drawable);
    }

}
