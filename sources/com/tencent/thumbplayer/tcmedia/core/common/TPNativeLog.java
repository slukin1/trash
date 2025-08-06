package com.tencent.thumbplayer.tcmedia.core.common;

import android.util.Log;

public class TPNativeLog {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARN = 3;
    private static final String TAG = "PlayerCore";
    private static ITPNativeLogCallback mLogCallback;

    private static void onPrintLog(int i11, byte[] bArr, int i12, byte[] bArr2, int i13) {
        try {
            int i14 = 0;
            String str = new String(bArr, 0, i12, "UTF-8");
            String str2 = new String(bArr2, 0, i13, "UTF-8");
            if (i11 == 0) {
                i14 = 4;
            } else if (i11 == 1) {
                i14 = 3;
            } else if (i11 == 2) {
                i14 = 2;
            } else if (i11 == 3) {
                i14 = 1;
            }
            printLog(i14, str, str2);
        } catch (Exception e11) {
            printLog(4, e11.getMessage());
        }
    }

    public static void printLog(int i11, String str) {
        printLog(i11, TAG, str);
    }

    public static void printLog(int i11, String str, String str2) {
        ITPNativeLogCallback iTPNativeLogCallback = mLogCallback;
        if (iTPNativeLogCallback != null) {
            iTPNativeLogCallback.onPrintLog(i11, str, str2);
        } else {
            printLogDefault(i11, str, str2);
        }
    }

    public static void printLogDefault(int i11, String str, String str2) {
        if (i11 == 0) {
            Log.v(str, str2);
        } else if (i11 == 1) {
            Log.d(str, str2);
        } else if (i11 == 2) {
            Log.i(str, str2);
        } else if (i11 == 3) {
            Log.w(str, str2);
        } else if (i11 != 4) {
            Log.v(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public static void setLogCallback(ITPNativeLogCallback iTPNativeLogCallback) {
        mLogCallback = iTPNativeLogCallback;
    }
}
