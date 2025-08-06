package com.huawei.face.antispoofing.utils;

import android.util.Log;
import com.huawei.face.antispoofing.sdk.FaceAntispoofingSdk;

public class LogFace {
    public static boolean isDebug = FaceAntispoofingSdk.LOG;

    public static void d(String str) {
        if (isDebug) {
            Log.d("mIPSA", str);
        }
    }

    public static void e(String str) {
        if (isDebug) {
            Log.e("mIPSA", str);
        }
    }

    public static void i(String str) {
        if (isDebug) {
            Log.i("mIPSA", str);
        }
    }

    public static void v(String str) {
        if (isDebug) {
            Log.v("mIPSA", str);
        }
    }

    public static void w(String str) {
        if (isDebug) {
            Log.w("mIPSA", str);
        }
    }

    public static void d(String str, String str2) {
        if (isDebug) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (isDebug) {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (isDebug) {
            Log.i(str, str2);
        }
    }

    public static void v(String str, String str2) {
        if (isDebug) {
            Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (isDebug) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        if (isDebug) {
            Log.e(str, str2, th2);
        }
    }

    public static void w(String str, String str2, Throwable th2) {
        if (isDebug) {
            Log.w(str, str2, th2);
        }
    }
}
