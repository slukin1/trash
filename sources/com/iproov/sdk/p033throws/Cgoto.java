package com.iproov.sdk.p033throws;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.DisplayMetrics;

/* renamed from: com.iproov.sdk.throws.goto  reason: invalid class name and invalid package */
public class Cgoto {
    /* renamed from: do  reason: not valid java name */
    public static Bitmap m1977do(Bitmap bitmap, int i11, int i12, int i13, int i14) {
        Bitmap createBitmap = Bitmap.createBitmap(Math.min(i13, bitmap.getWidth()), Math.min(i14, bitmap.getHeight()), Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{0.2126f, 0.7152f, 0.0722f, 0.0f, 0.0f, 0.2126f, 0.7152f, 0.0722f, 0.0f, 0.0f, 0.2126f, 0.7152f, 0.0722f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, (float) (-i11), (float) (-i12), paint);
        return createBitmap;
    }

    /* renamed from: do  reason: not valid java name */
    public static double m1976do() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return ((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi)) * 25.4d * ((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi)) * 25.4d;
    }
}
