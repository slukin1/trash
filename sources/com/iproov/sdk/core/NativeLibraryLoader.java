package com.iproov.sdk.core;

import com.iproov.sdk.logging.IPLog;

class NativeLibraryLoader {

    /* renamed from: do  reason: not valid java name */
    public static boolean f228do = true;

    static {
        try {
            System.loadLibrary("native-lib");
        } catch (UnsatisfiedLinkError unused) {
            IPLog.w("NativeLib", "Not loaded");
        }
    }

    public native int performance();

    public native int suNativeCheck(String[] strArr);
}
