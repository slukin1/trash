package com.tencent.liteav.txcplayer.common;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;

@JNINamespace("liteav::licence")
public class VodPlayerControl {
    public static final int STRATEGY_FAIL = 1;
    public static final int STRATEGY_PASS = 0;

    public static int getPlayerLicenceControlStrategy() {
        int nativeGetPlayerLicenceControlStrategy = nativeGetPlayerLicenceControlStrategy();
        LiteavLog.i("VodPlayerControl", "getPlayerLicenceControlStrategy = ".concat(String.valueOf(nativeGetPlayerLicenceControlStrategy)));
        return nativeGetPlayerLicenceControlStrategy;
    }

    private static native int nativeGetPlayerLicenceControlStrategy();

    public static native void nativeIncrementCheckCount();

    public static native boolean nativeIsCheckCountLEThreshold();

    public static native void nativeSetLicenseFlexibleValid(boolean z11);
}
