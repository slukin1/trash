package com.hbg.lib.common.utils;

import android.content.res.ColorStateList;
import android.graphics.Color;

public class ColorUtils {
    public static ColorStateList a(int i11, int i12) {
        return b(i11, i12, i12, i11);
    }

    public static ColorStateList b(int i11, int i12, int i13, int i14) {
        int[] iArr = {i12, i13, i11, i13, i14, i11};
        return new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[]{16842910, 16842908}, new int[]{16842910}, new int[]{16842908}, new int[]{16842909}, new int[0]}, iArr);
    }

    public static String c(int i11) {
        return d(i11, false);
    }

    public static String d(int i11, boolean z11) {
        String hexString = Integer.toHexString(Color.alpha(i11));
        String hexString2 = Integer.toHexString(Color.red(i11));
        String hexString3 = Integer.toHexString(Color.green(i11));
        String hexString4 = Integer.toHexString(Color.blue(i11));
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = "0" + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = "0" + hexString3;
        }
        if (hexString4.length() == 1) {
            hexString4 = "0" + hexString4;
        }
        if (z11) {
            return hexString + hexString2 + hexString3 + hexString4;
        }
        return hexString2 + hexString3 + hexString4;
    }
}
