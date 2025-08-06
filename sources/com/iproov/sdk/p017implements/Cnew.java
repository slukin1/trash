package com.iproov.sdk.p017implements;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.iproov.sdk.cameray.Orientation;

/* renamed from: com.iproov.sdk.implements.new  reason: invalid class name and invalid package */
public class Cnew {
    /* renamed from: do  reason: not valid java name */
    public static Bitmap m1030do(Bitmap bitmap, Orientation orientation) {
        if (orientation.angleDegrees == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate((float) orientation.angleDegrees);
        matrix.postScale(-1.0f, 1.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: do  reason: not valid java name */
    public static Bitmap m1029do(Bitmap bitmap, int i11, int i12, int i13, int i14) {
        Bitmap createBitmap = Bitmap.createBitmap(Math.min(i13, bitmap.getWidth()), Math.min(i14, bitmap.getHeight()), Bitmap.Config.ARGB_8888);
        if (createBitmap == null) {
            return null;
        }
        new Canvas(createBitmap).drawBitmap(bitmap, (float) (-i11), (float) (-i12), new Paint());
        return createBitmap;
    }
}
