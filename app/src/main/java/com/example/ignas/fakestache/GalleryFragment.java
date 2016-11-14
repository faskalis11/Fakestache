package com.example.ignas.fakestache;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment implements AdapterView.OnItemClickListener {

    String path;
    List<GridViewItem> gridItems;
    GridView gridView;

    public static GalleryFragment newInstance(String path){
        GalleryFragment fragment = new GalleryFragment();

        Bundle args = new Bundle();
        args.putString("path", path);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        path = getArguments().getString("path");


        gridView = (GridView) view.findViewById(R.id.gridView); //!!! anything else?

        Log.d("DCIM", path);
        setGridAdapter(path);



        return view;
    }

    /**
     * This will create our GridViewItems and set the adapter
     *
     * @param path
     *            The directory in which to search for images
     */
    private void setGridAdapter(String path) {
        // Create a new grid adapter

        gridItems = createGridItems(path);
        MyGridAdapter adapter = new MyGridAdapter(this.getContext(), gridItems);
        // Set the grid adapter on createView?
        //GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

        // Set the onClickListener
        gridView.setOnItemClickListener(this);
    }


    /**
     * Go through the specified directory, and create items to display in our
     * GridView
     */
    private List<GridViewItem> createGridItems(String directoryPath) {
        List<GridViewItem> items = new ArrayList<GridViewItem>();

        // List all the items within the folder.
        File[] files = new File(directoryPath).listFiles(new ImageFileFilter());
        if(files != null) {
            for (File file : files) {

                // Add the directories containing images or sub-directories, trinti
                if (file.isDirectory() && file.listFiles(new ImageFileFilter()).length > 0) {
                    if (!file.getName().equals(".thumbnails")) {
                        items.addAll(createGridItems(file.getAbsolutePath()));
                        Log.d("DCIM", "Name: " + file.getName() + " Path: " + file.getPath());
                    }
                }
                // Add the images
                else {
                    Bitmap image = BitmapHelper.decodeBitmapFromFile(file.getAbsolutePath(),
                            50,
                            50);
                    items.add(new GridViewItem(file.getAbsolutePath(), false, image));
                }
            }
        }
        return items;
    }


    /**
     * Checks the file to see if it has a compatible extension.
     */
    private boolean isImageFile(String filePath) {
        if (filePath.endsWith(".jpg") || filePath.endsWith(".png"))
        // Add other formats as desired
        {
            return true;
        }
        return false;
    }


    @Override
    public void
    onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (gridItems.get(position).isDirectory()) { //trinti šitą if, kai veiks
            setGridAdapter(gridItems.get(position).getPath());
        }
        else {
            // Display the image class sukurti
        }

    }

    /**
     * This can be used to filter files.
     */
    private class ImageFileFilter implements FileFilter {

        @Override
        public boolean accept(File file) {
            if (file.isDirectory()) { //trint
                return true;
            }
            else if (isImageFile(file.getAbsolutePath())) {
                return true;
            }
            return false;
        }
    }

}