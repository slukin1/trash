package com.huawei.secure.android.common.util;

import android.util.Log;

public class SafeString {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38668a = "SafeString";

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (!(str == null || charSequence == null || charSequence2 == null)) {
            try {
                return str.replace(charSequence, charSequence2);
            } catch (Exception e11) {
                String str2 = f38668a;
                Log.e(str2, "replace: " + e11.getMessage());
            }
        }
        return str;
    }

    public static String substring(String str, int i11) {
        if (str != null && str.length() >= i11 && i11 >= 0) {
            try {
                return str.substring(i11);
            } catch (Exception e11) {
                String str2 = f38668a;
                Log.e(str2, "substring exception: " + e11.getMessage());
            }
        }
        return "";
    }

    public static String substring(String str, int i11, int i12) {
        if (str != null && i11 >= 0 && i12 <= str.length() && i12 >= i11) {
            try {
                return str.substring(i11, i12);
            } catch (Exception e11) {
                String str2 = f38668a;
                Log.e(str2, "substring: " + e11.getMessage());
            }
        }
        return "";
    }
}
