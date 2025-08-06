package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.rtmp.ui.OnTapListener;

@JNINamespace("liteav::video")
public class NativeOnTapListener implements OnTapListener {
    private long mNativeHandler;

    public NativeOnTapListener(long j11) {
        this.mNativeHandler = j11;
    }

    private static native void nativeOnTap(long j11, int i11, int i12, int i13, int i14);

    public synchronized void onTap(int i11, int i12, int i13, int i14) {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeOnTap(j11, i11, i12, i13, i14);
        }
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0;
    }
}
