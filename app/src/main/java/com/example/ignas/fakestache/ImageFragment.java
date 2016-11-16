package com.example.ignas.fakestache;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;

public class ImageFragment extends Fragment {

    private static final String PATH = "path";

    private String path;

    public ImageFragment() {
        // Required empty public constructor
    }

    public static ImageFragment newInstance(String imagePath) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(PATH, imagePath);

        fragment.setArguments(args);
        Log.d("Fragment", "ImageFragment");
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            path = getArguments().getString(PATH);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_image, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        //Bitmap image = BitmapHelper.decodeBitmapFromFile(path, 600, 600);
        File file = new File(path);
        Log.d("File", file.getAbsolutePath());
        Log.d("File", file.getName());
        Uri uri = Uri.fromFile(file);
        imageView.setImageURI(uri);

        return view;
    }
}
