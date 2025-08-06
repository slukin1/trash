package com.tencent.ugc.videobase.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import java.nio.ByteBuffer;

@JNINamespace("liteav::ugc")
public class BitmapUtils {
    public static Bitmap createBitmap(Bitmap bitmap, Matrix matrix, boolean z11) {
        if (bitmap == null) {
            return null;
        }
        bitmap.getConfig();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (z11) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            new Canvas(createBitmap).drawBitmap(bitmap, matrix, paint);
            return createBitmap;
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap createBitmapFromBuffer(ByteBuffer byteBuffer, int i11, int i12) {
        try {
            byteBuffer.position(0);
            Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(byteBuffer);
            return createBitmap;
        } catch (Throwable th2) {
            LiteavLog.e("BitmapUtils", "build bitmap failed.", th2);
            return null;
        }
    }
}
