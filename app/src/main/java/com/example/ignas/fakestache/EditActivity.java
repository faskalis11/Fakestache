package com.example.ignas.fakestache;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ly.img.android.sdk.models.state.EditorLoadSettings;
import ly.img.android.sdk.models.state.manager.SettingsList;
import ly.img.android.ui.activities.PhotoEditorBuilder;
import ly.img.android.ui.utilities.PermissionRequest;

public class EditActivity extends AppCompatActivity implements PermissionRequest.Response{

    public static final String IMAGE_PATH = "ImagePath";
    public static int EDIT_RESULT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();

        String imagePath = bundle.getString(IMAGE_PATH);

        SettingsList settingsList = PhotoEditorSettings.getSettings();

        settingsList.getSettingsModel(EditorLoadSettings.class)
                .setImageSourcePath(imagePath);


        new PhotoEditorBuilder(this)
                .setSettingsList(settingsList)
                .startActivityForResult(this, EDIT_RESULT);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("EditActivity", String.valueOf(resultCode));
        if (resultCode == RESULT_OK && requestCode == EDIT_RESULT) {
            /*String path = data.getStringExtra(PhotoEditorActivity.RES);

            Toast.makeText(this, "Image saved at: " + path, Toast.LENGTH_LONG).show();

            File mMediaFolder = new File(path);

            MediaScannerConnection.scanFile(this, new String[] {mMediaFolder.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() {
                        public void onScanCompleted(String path, Uri uri) {

                        }
                    }
            );*/
        }
        setResult(resultCode, data);
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionRequest.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void permissionGranted() {

    }

    @Override
    public void permissionDenied() {
        finish();
        Log.e("Permission", "No permission");
        System.exit(0);
    }
}
