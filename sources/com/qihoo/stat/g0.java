package com.qihoo.stat;

import android.util.Log;

public class g0 {
    public static void a(String str, Error error) {
        if (d.f28710b) {
            error.printStackTrace();
            Log.e(str, "err: " + error.toString());
        }
    }

    public static void b(String str, Exception exc) {
        if (d.f28710b) {
            exc.printStackTrace();
            Log.w(str, "ex: " + exc.toString());
        }
    }

    public static void c(String str, String str2) {
        if (d.f28710b) {
            Log.d(str, str2);
        }
    }
}
