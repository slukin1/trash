package com.amazonaws.util;

import java.nio.charset.Charset;
import java.util.Locale;

public class StringUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f15560a = Charset.forName("UTF-8");

    public static boolean a(CharSequence charSequence) {
        int length;
        if (!(charSequence == null || (length = charSequence.length()) == 0)) {
            for (int i11 = 0; i11 < length; i11++) {
                if (!Character.isWhitespace(charSequence.charAt(i11))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return "";
        }
        return str.toLowerCase(Locale.ENGLISH);
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return "";
        }
        return str.toUpperCase(Locale.ENGLISH);
    }
}
