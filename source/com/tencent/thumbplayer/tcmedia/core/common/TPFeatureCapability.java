package com.tencent.thumbplayer.tcmedia.core.common;

import android.content.Context;

public class TPFeatureCapability {
    private static String TAG = "TPFeatureCapability";
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

    private static native boolean _isFeatureSupport(int i11);

    public static boolean isFeatureSupport(int i11) {
        if (isLibLoaded()) {
            try {
                return _isFeatureSupport(i11);
            } catch (Throwable th2) {
                TPNativeLog.printLog(4, th2.getMessage());
                throw new TPNativeLibraryException("Failed to call _isFeatureSupport.");
            }
        } else {
            throw new TPNativeLibraryException("isFeatureSupport: Failed to load native library.");
        }
    }

    private static boolean isLibLoaded() {
        return mIsLibLoaded;
    }
}
