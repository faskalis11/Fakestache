package com.example.ignas.fakestache;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class ImageActivity extends AppCompatActivity {
    public static final int EDIT_RESULT = 3;

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
                startActivityForResult(intent, EDIT_RESULT);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        pagerAdapter.update();
        pagerAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == EDIT_RESULT && resultCode == -1){
            //nuotrauka redaguota
            Log.d("ImageActivity", String.valueOf(resultCode));
            Log.d("ImageActivity", "Edit success");

            pagerAdapter.update();
            pagerAdapter.update();
            pagerAdapter.notifyDataSetChanged();
            pager.setCurrentItem(0);
        }else{
            //redagavimas atsauktas
            Log.d("ImageActivity", String.valueOf(resultCode));
            Log.d("ImageActivity", "Edit canceled");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        pagerAdapter.update();
        pagerAdapter.notifyDataSetChanged();
    }
}
