package com.example.ignas.fakestache;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GalleryFragment extends Fragment {

    public static GalleryFragment newInstance(String text){
        GalleryFragment fragment = new GalleryFragment();

        Bundle args = new Bundle();
        args.putString("text", text);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(getArguments().getString("text"));

        return view;
    }
}