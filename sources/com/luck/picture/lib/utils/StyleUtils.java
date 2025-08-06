package com.luck.picture.lib.utils;

import android.content.Context;
import android.graphics.ColorFilter;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeCompat;
import java.util.regex.Pattern;
import t0.a;

public class StyleUtils {
    private static final int INVALID = 0;

    public static boolean checkArrayValidity(int[] iArr) {
        return iArr != null && iArr.length > 0;
    }

    public static boolean checkSizeValidity(int i11) {
        return i11 > 0;
    }

    public static boolean checkStyleValidity(int i11) {
        return i11 != 0;
    }

    public static boolean checkTextFormatValidity(String str) {
        return Pattern.compile("\\([^)]*\\)").matcher(str).find();
    }

    public static boolean checkTextTwoFormatValidity(String str) {
        int i11 = 0;
        while (Pattern.compile("%[^%]*\\d").matcher(str).find()) {
            i11++;
        }
        if (i11 >= 2) {
            return true;
        }
        return false;
    }

    public static boolean checkTextValidity(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static ColorFilter getColorFilter(Context context, int i11) {
        return a.a(ContextCompat.getColor(context, i11), BlendModeCompat.SRC_ATOP);
    }
}
