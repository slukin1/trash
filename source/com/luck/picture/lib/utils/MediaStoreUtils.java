package com.luck.picture.lib.utils;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import java.io.File;

public class MediaStoreUtils {
    public static ContentValues buildImageContentValues(String str, String str2) {
        String valueOf = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str)) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        } else if (str.lastIndexOf(InstructionFileId.DOT) == -1) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(InstructionFileId.DOT)), ""));
        }
        if (TextUtils.isEmpty(str2) || str2.startsWith("video")) {
            str2 = "image/jpeg";
        }
        contentValues.put("mime_type", str2);
        if (SdkVersionUtils.isQ()) {
            contentValues.put("datetaken", valueOf);
            contentValues.put("relative_path", PictureMimeType.DCIM);
        }
        return contentValues;
    }

    public static ContentValues buildVideoContentValues(String str, String str2) {
        String valueOf = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str)) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("VID_"));
        } else if (str.lastIndexOf(InstructionFileId.DOT) == -1) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("VID_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(InstructionFileId.DOT)), ""));
        }
        if (TextUtils.isEmpty(str2) || str2.startsWith("image")) {
            str2 = "video/mp4";
        }
        contentValues.put("mime_type", str2);
        if (SdkVersionUtils.isQ()) {
            contentValues.put("datetaken", valueOf);
            contentValues.put("relative_path", Environment.DIRECTORY_MOVIES);
        }
        return contentValues;
    }

    public static Uri createCameraOutImageUri(Context context, SelectorConfig selectorConfig) {
        String str;
        String str2 = "";
        if (TextUtils.isEmpty(selectorConfig.outPutCameraImageFileName)) {
            str = str2;
        } else if (selectorConfig.isOnlyCamera) {
            str = selectorConfig.outPutCameraImageFileName;
        } else {
            str = System.currentTimeMillis() + "_" + selectorConfig.outPutCameraImageFileName;
        }
        if (!SdkVersionUtils.isQ() || !TextUtils.isEmpty(selectorConfig.outPutCameraDir)) {
            File createCameraFile = PictureFileUtils.createCameraFile(context, 1, str, selectorConfig.cameraImageFormat, selectorConfig.outPutCameraDir);
            selectorConfig.cameraPath = createCameraFile.getAbsolutePath();
            return PictureFileUtils.parUri(context, createCameraFile);
        }
        Uri createImageUri = createImageUri(context, str, selectorConfig.cameraImageFormatForQ);
        if (createImageUri != null) {
            str2 = createImageUri.toString();
        }
        selectorConfig.cameraPath = str2;
        return createImageUri;
    }

    public static Uri createCameraOutVideoUri(Context context, SelectorConfig selectorConfig) {
        String str;
        String str2 = "";
        if (TextUtils.isEmpty(selectorConfig.outPutCameraVideoFileName)) {
            str = str2;
        } else if (selectorConfig.isOnlyCamera) {
            str = selectorConfig.outPutCameraVideoFileName;
        } else {
            str = System.currentTimeMillis() + "_" + selectorConfig.outPutCameraVideoFileName;
        }
        if (!SdkVersionUtils.isQ() || !TextUtils.isEmpty(selectorConfig.outPutCameraDir)) {
            File createCameraFile = PictureFileUtils.createCameraFile(context, 2, str, selectorConfig.cameraVideoFormat, selectorConfig.outPutCameraDir);
            selectorConfig.cameraPath = createCameraFile.getAbsolutePath();
            return PictureFileUtils.parUri(context, createCameraFile);
        }
        Uri createVideoUri = createVideoUri(context, str, selectorConfig.cameraVideoFormatForQ);
        if (createVideoUri != null) {
            str2 = createVideoUri.toString();
        }
        selectorConfig.cameraPath = str2;
        return createVideoUri;
    }

    public static Uri createImageUri(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        ContentValues buildImageContentValues = buildImageContentValues(str, str2);
        if (externalStorageState.equals("mounted")) {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, buildImageContentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, buildImageContentValues);
        }
        return uriArr[0];
    }

    public static Uri createVideoUri(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        ContentValues buildVideoContentValues = buildVideoContentValues(str, str2);
        if (externalStorageState.equals("mounted")) {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, buildVideoContentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Video.Media.INTERNAL_CONTENT_URI, buildVideoContentValues);
        }
        return uriArr[0];
    }
}
