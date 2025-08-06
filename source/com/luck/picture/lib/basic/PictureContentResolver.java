package com.luck.picture.lib.basic;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import java.io.OutputStream;

public final class PictureContentResolver {
    public static InputStream openInputStream(Context context, Uri uri) {
        try {
            return context.getContentResolver().openInputStream(uri);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static OutputStream openOutputStream(Context context, Uri uri) {
        try {
            return context.getContentResolver().openOutputStream(uri);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
