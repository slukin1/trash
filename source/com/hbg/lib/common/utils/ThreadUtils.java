package com.hbg.lib.common.utils;

import android.os.Looper;

public class ThreadUtils {
    public static boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
