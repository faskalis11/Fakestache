package com.example.ignas.fakestache;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simonas on 2016-11-16.
 */

public class ImagePagerAdapter extends FragmentStatePagerAdapter {
    private String path;
    private List<ImageItem> items;



    public ImagePagerAdapter(FragmentManager fragmentManager, String path){
        super(fragmentManager);
        this.path = path;
        items = createItems(path);
    }

    @Override
    public Fragment getItem(int position) {
        position = items.size() - position - 1;
        Log.d("Path", items.get(position).getPath());
        return ImageFragment.newInstance(items.get(position).getPath());
    }

    @Override
    public int getCount() {
        return items.size();
    }


    /**
    *Go through the specified directory, and create items to display in our
    * GridView
    */
    private List<ImageItem> createItems(String directoryPath) {
        List<ImageItem> items = new ArrayList<ImageItem>();

        // List all the items within the folder.
        File[] files = new File(directoryPath).listFiles(new ImagePagerAdapter.ImageFileFilter());
        if(files != null) {
            for (File file : files) {

                // Add the directories containing images or sub-directories, trinti
                if (file.isDirectory() && file.listFiles(new ImagePagerAdapter.ImageFileFilter()).length > 0) {
                    if (!file.getName().equals(".thumbnails")) {
                        items.addAll(createItems(file.getAbsolutePath()));
                        Log.d("DCIM", "Name: " + file.getName() + " Path: " + file.getPath());
                    }
                }
                // Add the images
                else {
                    Bitmap image = BitmapHelper.decodeBitmapFromFile(file.getAbsolutePath(),
                            200,
                            200);
                    items.add(new ImageItem(file.getAbsolutePath(), false, image));
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
