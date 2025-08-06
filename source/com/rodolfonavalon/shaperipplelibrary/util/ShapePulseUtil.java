package com.rodolfonavalon.shaperipplelibrary.util;

import android.content.Context;
import android.graphics.Color;
import java.util.ArrayList;

public class ShapePulseUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f28866a = {Color.parseColor("#673AB7"), Color.parseColor("#3F51B5"), Color.parseColor("#2196F3"), Color.parseColor("#03A9F4"), Color.parseColor("#00BCD4"), Color.parseColor("#009688"), Color.parseColor("#8BC34A"), Color.parseColor("#4CAF50"), Color.parseColor("#FF5722"), Color.parseColor("#F44336")};

    public static int a(float f11, int i11, int i12) {
        int i13 = (i11 >> 24) & 255;
        int i14 = (i11 >> 16) & 255;
        int i15 = (i11 >> 8) & 255;
        int i16 = i11 & 255;
        return ((i13 + ((int) (((float) (((i12 >> 24) & 255) - i13)) * f11))) << 24) | ((i14 + ((int) (((float) (((i12 >> 16) & 255) - i14)) * f11))) << 16) | ((i15 + ((int) (((float) (((i12 >> 8) & 255) - i15)) * f11))) << 8) | (i16 + ((int) (f11 * ((float) ((i12 & 255) - i16)))));
    }

    public static ArrayList<Integer> b(Context context) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int valueOf : f28866a) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }
}
