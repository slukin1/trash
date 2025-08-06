package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.rtmp.ui.OnZoomListener;

@JNINamespace("liteav::video")
public class NativeOnZoomListener implements OnZoomListener {
    private long mNativeHandler;

    public NativeOnZoomListener(long j11) {
        this.mNativeHandler = j11;
    }

    private static native void nativeOnZoom(long j11, float f11);

    public void onZoom(float f11) {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeOnZoom(j11, f11);
        }
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0;
    }
}
