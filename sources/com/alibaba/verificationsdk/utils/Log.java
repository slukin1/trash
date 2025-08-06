package com.alibaba.verificationsdk.utils;

import com.alibaba.verificationsdk.BuildConfig;

public class Log {
    public static int e(String str, String str2) {
        if (BuildConfig.DEBUG) {
            return android.util.Log.e(str, str2);
        }
        return 0;
    }

    public static int i(String str, String str2) {
        if (BuildConfig.DEBUG) {
            return android.util.Log.i(str, str2);
        }
        return 0;
    }
}
