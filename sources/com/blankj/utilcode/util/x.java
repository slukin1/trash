package com.blankj.utilcode.util;

import android.content.res.Resources;
import java.util.IllegalFormatException;

public final class x {
    public static String a(String str, Object... objArr) {
        if (str == null || objArr == null || objArr.length <= 0) {
            return str;
        }
        try {
            return String.format(str, objArr);
        } catch (IllegalFormatException e11) {
            e11.printStackTrace();
            return str;
        }
    }

    public static String b(int i11) {
        return c(i11, (Object[]) null);
    }

    public static String c(int i11, Object... objArr) {
        try {
            return a(Utils.a().getString(i11), objArr);
        } catch (Resources.NotFoundException e11) {
            e11.printStackTrace();
            return String.valueOf(i11);
        }
    }

    public static boolean d(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean e(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isWhitespace(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }
}
