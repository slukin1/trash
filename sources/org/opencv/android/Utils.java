package org.opencv.android;

import android.graphics.Bitmap;
import org.opencv.core.Mat;

public class Utils {
    public static void matToBitmap(Mat mat, Bitmap bitmap, boolean z11) {
        if (mat == null) {
            throw new IllegalArgumentException("mat == null");
        } else if (bitmap != null) {
            nMatToBitmap2(mat.nativeObj, bitmap, z11);
        } else {
            throw new IllegalArgumentException("bmp == null");
        }
    }

    private static native void nMatToBitmap2(long j11, Bitmap bitmap, boolean z11);

    public static void matToBitmap(Mat mat, Bitmap bitmap) {
        matToBitmap(mat, bitmap, false);
    }
}
