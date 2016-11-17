package com.example.ignas.fakestache;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageFragment extends Fragment {

    private static final String PATH = "path";

    private String path;
    private Bitmap image;

    public ImageFragment() {
        // Required empty public constructor
    }

    public static ImageFragment newInstance(String imagePath) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(PATH, imagePath);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            path = getArguments().getString(PATH);
            image = null;

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_image, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        //File file = new File(path);
        //Log.d("File", file.getAbsolutePath());
        //Log.d("File", file.getName());
        //Uri uri = Uri.fromFile(file);
        //imageView.setImageURI(uri);

        if(image == null){
            DisplayMetrics metrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int width = metrics.widthPixels;
            int height = metrics.heightPixels;
            image = BitmapHelper.decodeBitmapFromFile(path, width, height);
            Log.d("ImageFragment", "Decoding bitmap");
        }

        imageView.setImageBitmap(image);

        return view;
    }
}
