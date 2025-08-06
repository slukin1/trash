package com.huobi.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCompressor {
    public static int a(File file, int i11, int i12) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i13 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int i14 = options.outHeight;
        int i15 = options.outWidth;
        if (i14 > i12 || i15 > i11) {
            int i16 = i14 / 2;
            int i17 = i15 / 2;
            while (i16 / i13 >= i12 && i17 / i13 >= i11) {
                i13 *= 2;
            }
        }
        return i13;
    }

    public static File b(Context context, File file, int i11) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = a(file, 1080, 1920);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i12 = 100;
        decodeFile.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > i11 && i12 > 0) {
            byteArrayOutputStream.reset();
            i12 -= 5;
            decodeFile.compress(Bitmap.CompressFormat.JPEG, i12, byteArrayOutputStream);
        }
        File c11 = c(context);
        FileOutputStream fileOutputStream = new FileOutputStream(c11);
        byteArrayOutputStream.writeTo(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        decodeFile.recycle();
        return c11;
    }

    public static File c(Context context) throws IOException {
        File file;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            file = context.getExternalCacheDir();
        } else {
            file = context.getCacheDir();
        }
        return File.createTempFile("compressed_", PictureMimeType.JPG, file);
    }
}
