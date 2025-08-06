package com.tencent.thumbplayer.tcmedia.core.drm;

import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog;

public final class TPDrmInterruptCallbackProxy implements ITPDrmInterruptCallback {
    private long mNativeContext;

    private TPDrmInterruptCallbackProxy() {
    }

    private native boolean native_isInterrupted();

    public final boolean isInterrupted() {
        try {
            return native_isInterrupted();
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, th2.getMessage());
            return false;
        }
    }
}
