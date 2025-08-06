package com.huobi.utils;

import android.graphics.Color;

public class ColorUtils {
    public static int a(int i11, int i12, float f11) {
        float f12 = 1.0f - f11;
        return Color.argb((int) ((((float) Color.alpha(i11)) * f12) + (((float) Color.alpha(i12)) * f11)), (int) ((((float) Color.red(i11)) * f12) + (((float) Color.red(i12)) * f11)), (int) ((((float) Color.green(i11)) * f12) + (((float) Color.green(i12)) * f11)), (int) ((((float) Color.blue(i11)) * f12) + (((float) Color.blue(i12)) * f11)));
    }
}
