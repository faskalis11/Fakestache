package com.example.ignas.fakestache;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ImageActivity extends AppCompatActivity {
    private ViewPager pager;
    private ImagePagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        String imagePath = bundle.getString(GalleryFragment.IMAGEPATH);
        int position = bundle.getInt(GalleryFragment.POSITION);

        pager = (ViewPager) findViewById(R.id.imagePager);
        pagerAdapter = new ImagePagerAdapter(getSupportFragmentManager(), imagePath);
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(position);






        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_mode_edit_black_24dp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ImageActivity.this, EditActivity.class);
                Bundle bundle = new Bundle();
                int position = pager.getCurrentItem();
                ImageItem item = pagerAdapter.getImageItem(position);
                bundle.putString(EditActivity.IMAGE_PATH, item.getPath());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

}
