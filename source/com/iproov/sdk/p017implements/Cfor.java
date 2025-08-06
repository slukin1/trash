package com.iproov.sdk.p017implements;

import android.graphics.Bitmap;

/* renamed from: com.iproov.sdk.implements.for  reason: invalid class name and invalid package */
public class Cfor {

    /* renamed from: do  reason: not valid java name */
    private int[] f935do = new int[0];

    /* renamed from: if  reason: not valid java name */
    private int m1005if(Bitmap bitmap, int i11, int i12) {
        return ((m1004do(bitmap, i11, i12 - 1) + m1004do(bitmap, i11 - 1, i12)) - (m1004do(bitmap, i11, i12) * 4)) + m1004do(bitmap, i11 + 1, i12) + m1004do(bitmap, i11, i12 + 1);
    }

    /* renamed from: do  reason: not valid java name */
    public double m1006do(Bitmap bitmap) {
        int height = (bitmap.getHeight() - 2) * (bitmap.getWidth() - 2);
        if (height != this.f935do.length) {
            this.f935do = new int[height];
        }
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 1; i13 < bitmap.getHeight() - 1; i13++) {
            int i14 = 1;
            while (i14 < bitmap.getWidth() - 1) {
                int i15 = m1005if(bitmap, i14, i13);
                i11 += i15;
                this.f935do[i12] = i15;
                i14++;
                i12++;
            }
        }
        double d11 = (double) i11;
        double d12 = (double) height;
        double d13 = d11 / d12;
        double d14 = 0.0d;
        for (int i16 = 0; i16 < height; i16++) {
            double d15 = ((double) this.f935do[i16]) - d13;
            d14 += d15 * d15;
        }
        return d14 / d12;
    }

    /* renamed from: do  reason: not valid java name */
    private int m1004do(Bitmap bitmap, int i11, int i12) {
        return bitmap.getPixel(i11, i12) & 255;
    }
}
