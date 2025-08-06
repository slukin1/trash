package com.sensorsdata.analytics.android.sdk;

import android.util.Log;

public class SALog {
    private static final int CHUNK_SIZE = 4000;
    private static boolean debug;
    private static boolean disableSDK;
    private static boolean enableLog;

    public static void d(String str, String str2) {
        if (debug && !disableSDK) {
            info(str, str2, (Throwable) null);
        }
    }

    public static void i(String str, String str2) {
        if (enableLog && !disableSDK) {
            info(str, str2, (Throwable) null);
        }
    }

    public static void info(String str, String str2, Throwable th2) {
        if (str2 != null) {
            try {
                byte[] bytes = str2.getBytes();
                int length = bytes.length;
                if (length <= 4000) {
                    Log.i(str, str2, th2);
                    return;
                }
                int i11 = 0;
                while (i11 < length - 4000) {
                    int lastIndexOfLF = lastIndexOfLF(bytes, i11);
                    int i12 = lastIndexOfLF - i11;
                    Log.i(str, new String(bytes, i11, i12), (Throwable) null);
                    if (i12 < 4000) {
                        lastIndexOfLF++;
                    }
                    i11 = lastIndexOfLF;
                }
                if (length > i11) {
                    Log.i(str, new String(bytes, i11, length - i11), th2);
                }
            } catch (Exception e11) {
                printStackTrace(e11);
            }
        } else {
            Log.i(str, (String) null, th2);
        }
    }

    public static boolean isLogEnabled() {
        return enableLog;
    }

    private static int lastIndexOfLF(byte[] bArr, int i11) {
        int min = Math.min(i11 + 4000, bArr.length - 1);
        for (int i12 = min; i12 > min - 4000; i12--) {
            if (bArr[i12] == 10) {
                return i12;
            }
        }
        return min;
    }

    public static void printStackTrace(Exception exc) {
        if (enableLog && !disableSDK && exc != null) {
            Log.e("SA.Exception", "", exc);
        }
    }

    public static void setDebug(boolean z11) {
        debug = z11;
    }

    public static void setDisableSDK(boolean z11) {
        disableSDK = z11;
    }

    public static void setEnableLog(boolean z11) {
        enableLog = z11;
    }

    public static void d(String str, String str2, Throwable th2) {
        if (debug && !disableSDK) {
            info(str, str2, th2);
        }
    }

    public static void i(String str, Throwable th2) {
        if (enableLog && !disableSDK) {
            info(str, "", th2);
        }
    }

    public static void i(String str, String str2, Throwable th2) {
        if (enableLog && !disableSDK) {
            info(str, str2, th2);
        }
    }
}
