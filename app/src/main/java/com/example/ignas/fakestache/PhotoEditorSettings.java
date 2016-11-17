package com.example.ignas.fakestache;

import ly.img.android.sdk.models.config.Divider;
import ly.img.android.sdk.models.config.ImageStickerConfig;
import ly.img.android.sdk.models.constant.Directory;
import ly.img.android.sdk.models.state.CameraSettings;
import ly.img.android.sdk.models.state.EditorSaveSettings;
import ly.img.android.sdk.models.state.manager.SettingsList;
import ly.img.android.sdk.tools.ColorAdjustmentTool;
import ly.img.android.sdk.tools.CropEditorTool;
import ly.img.android.sdk.tools.FilterEditorTool;
import ly.img.android.sdk.tools.StickerEditorTool;
import ly.img.android.sdk.tools.TextEditorTool;

/**
 * Created by Simonas on 2016-11-16.
 */

public class PhotoEditorSettings {

    private static final String FOLDER = "Fakestache";
    public static SettingsList getSettings(){
        SettingsList settingsList = new SettingsList();
        settingsList.getSettingsModel(EditorSaveSettings.class)
                .setExportDir(Directory.DCIM, FOLDER)
                .setExportPrefix("result_")
                .setSavePolicy(EditorSaveSettings.SavePolicy.KEEP_SOURCE_AND_CREATE_ALWAYS_OUTPUT)
                .getSettingsModel(CameraSettings.class)
                .setExportDir(Directory.DCIM, FOLDER)
                .setExportPrefix("camera_");
        settingsList.getConfig().setTools(
                new CropEditorTool(R.string.tool_name_crop, R.drawable.imgly_icon_tool_crop),
                new FilterEditorTool(R.string.tool_name_filter, R.drawable.imgly_icon_tool_filters),
                new ColorAdjustmentTool(R.string.tool_name_color_adjust, R.drawable.imgly_icon_tool_adjust),
                new Divider(),
                new TextEditorTool(R.string.tool_name_text, R.drawable.imgly_icon_tool_text),
                new StickerEditorTool(R.string.tool_name_sticker, R.drawable.imgly_icon_tool_sticker)

        ).setStickers(
                new ImageStickerConfig(R.string.moustache1, R.drawable.moustache1, R.drawable.moustache1)
        );
        return settingsList;
    }
}
