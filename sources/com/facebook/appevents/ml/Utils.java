package com.facebook.appevents.ml;

import android.text.TextUtils;
import java.nio.charset.Charset;

public class Utils {
    public static String normalizeString(String str) {
        return TextUtils.join(" ", str.trim().split("\\s+"));
    }

    public static int[] vectorize(String str, int i11) {
        int[] iArr = new int[i11];
        byte[] bytes = normalizeString(str).getBytes(Charset.forName("UTF-8"));
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 < bytes.length) {
                iArr[i12] = bytes[i12] & 255;
            } else {
                iArr[i12] = 0;
            }
        }
        return iArr;
    }
}
