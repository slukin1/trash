package com.iproov.sdk.p033throws;

import android.graphics.Bitmap;
import android.graphics.Color;

/* renamed from: com.iproov.sdk.throws.if  reason: invalid class name and invalid package */
public class Cif {

    /* renamed from: do  reason: not valid java name */
    private final int[] f2070do = new int[256];

    /* renamed from: if  reason: not valid java name */
    private final int f2071if;

    public Cif(Bitmap bitmap) {
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        for (int i11 = 0; i11 < width; i11++) {
            int i12 = iArr[i11];
            int[] iArr2 = this.f2070do;
            int blue = Color.blue(i12);
            iArr2[blue] = iArr2[blue] + 1;
        }
        this.f2071if = width;
    }

    /* renamed from: do  reason: not valid java name */
    public int m1980do(double d11) {
        int i11 = (int) (((double) this.f2071if) * d11);
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int[] iArr = this.f2070do;
            if (i12 >= iArr.length) {
                return -1;
            }
            i13 += iArr[i12];
            if (i13 > i11) {
                return i12;
            }
            i12++;
        }
    }
}
