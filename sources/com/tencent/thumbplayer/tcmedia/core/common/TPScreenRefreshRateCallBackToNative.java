package com.tencent.thumbplayer.tcmedia.core.common;

import com.tencent.thumbplayer.tcmedia.core.common.TPScreenRefreshRateDetector;

public class TPScreenRefreshRateCallBackToNative implements TPScreenRefreshRateDetector.ScreenRefreshRateChangedListener {
    private static final String TAG = "TPScreenRefreshRateCallBack";
    private long mNativeContext;

    private TPScreenRefreshRateCallBackToNative(long j11) {
        this.mNativeContext = j11;
    }

    private native void _onScreenRefreshRateChanged(float f11);

    private long getNativeContext() {
        return this.mNativeContext;
    }

    private void registerCallback() {
        TPScreenRefreshRateDetector.addListener(this);
    }

    private void unregisterCallback() {
        TPScreenRefreshRateDetector.removeListener(this);
    }

    public void onScreenRefreshRateChanged(float f11) {
        TPNativeLog.printLog(2, TAG, "onScreenRefreshRateChanged refreshRate:".concat(String.valueOf(f11)));
        _onScreenRefreshRateChanged(f11);
    }
}
