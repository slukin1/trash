package com.iproov.sdk.p020native;

import android.graphics.Color;
import android.util.Size;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.p012final.Cif;

/* renamed from: com.iproov.sdk.native.for  reason: invalid class name and invalid package */
public class Cfor {
    /* renamed from: do  reason: not valid java name */
    public static float[] m1145do(int i11) {
        return new float[]{((float) Color.red(i11)) / 255.0f, ((float) Color.green(i11)) / 255.0f, ((float) Color.blue(i11)) / 255.0f};
    }

    /* renamed from: if  reason: not valid java name */
    public static int m1146if(int i11) {
        return Color.rgb((Color.red(i11) + 153) % 255, (Color.green(i11) + 153) % 255, (Color.blue(i11) + 153) % 255);
    }

    /* renamed from: do  reason: not valid java name */
    public static Cif m1144do(Size size, int i11, int i12, Orientation orientation) {
        int i13;
        int i14;
        int i15;
        if (orientation.isPortrait()) {
            i13 = size.getWidth();
            i14 = size.getHeight();
        } else {
            i13 = size.getHeight();
            i14 = size.getWidth();
        }
        int abs = Math.abs(i11);
        int abs2 = Math.abs(i12);
        double d11 = ((double) i14) / ((double) i13);
        int i16 = (int) (((double) abs) * d11);
        if (abs2 > i16) {
            i15 = abs;
        } else {
            i15 = (int) (((double) abs2) / d11);
            i16 = abs2;
        }
        return new Cif(i15, i16, (abs - i15) / 2, (abs2 - i16) / 2);
    }
}
