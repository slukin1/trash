package com.huobi.woodpecker.utils;

import android.text.TextUtils;
import com.iproov.sdk.bridge.OptionsBridge;

public class StringUtils {
    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && !"about:blank".equalsIgnoreCase(str) && !str.startsWith("file:");
    }

    public static boolean b(CharSequence charSequence) {
        return c(charSequence, false);
    }

    public static boolean c(CharSequence charSequence, boolean z11) {
        if (z11 && charSequence != null) {
            charSequence = String.valueOf(charSequence).trim();
        }
        return TextUtils.isEmpty(charSequence) || OptionsBridge.NULL_VALUE.equalsIgnoreCase(charSequence.toString());
    }
}
