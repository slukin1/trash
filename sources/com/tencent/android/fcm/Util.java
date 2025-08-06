package com.tencent.android.fcm;

public class Util {
    public static boolean isNullOrEmptyString(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }
}
