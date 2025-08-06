package com.twitter.sdk.android.tweetui;

import android.graphics.Color;

final class ColorUtils {
    private ColorUtils() {
    }

    public static int calculateOpacityTransform(double d11, int i11, int i12) {
        double d12 = 1.0d - d11;
        return Color.rgb((int) ((((double) Color.red(i12)) * d12) + (((double) Color.red(i11)) * d11)), (int) ((((double) Color.green(i12)) * d12) + (((double) Color.green(i11)) * d11)), (int) ((d12 * ((double) Color.blue(i12))) + (d11 * ((double) Color.blue(i11)))));
    }

    public static boolean isLightColor(int i11) {
        return ((((double) Color.red(i11)) * 0.21d) + (((double) Color.green(i11)) * 0.72d)) + (((double) Color.blue(i11)) * 0.07d) > 128.0d;
    }
}
