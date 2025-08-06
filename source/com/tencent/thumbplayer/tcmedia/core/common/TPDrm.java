package com.tencent.thumbplayer.tcmedia.core.common;

import android.content.Context;

public final class TPDrm {
    private static final String TAG = "TPDrm";
    private static boolean mIsLibLoaded;

    static {
        try {
            TPNativeLibraryLoader.loadLibIfNeeded((Context) null);
            mIsLibLoaded = true;
        } catch (UnsupportedOperationException e11) {
            TPNativeLog.printLog(4, e11.getMessage());
            mIsLibLoaded = false;
        }
    }

    public static int[] getDRMCapabilities() {
        if (isLibLoaded()) {
            try {
                int[] native_getDRMCapabilities = native_getDRMCapabilities();
                return native_getDRMCapabilities == null ? new int[0] : native_getDRMCapabilities;
            } catch (Throwable th2) {
                TPNativeLog.printLog(4, th2.toString());
                throw new TPNativeLibraryException("Failed to call native func.");
            }
        } else {
            throw new TPNativeLibraryException("Failed to load native library.");
        }
    }

    private static boolean isLibLoaded() {
        return mIsLibLoaded;
    }

    public static native int[] native_getDRMCapabilities();
}
