package com.tencent.liteav.videoconsumer.consumer;

import android.graphics.Bitmap;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.base.a;

@JNINamespace("liteav::video")
public class NativeSnapshotListener implements a {
    private long mNativeVideoSnapListener = 0;

    private NativeSnapshotListener(long j11) {
        this.mNativeVideoSnapListener = j11;
    }

    private native void nativeDestroy(long j11);

    private native void nativeOnComplete(long j11, Bitmap bitmap);

    public void finalize() throws Throwable {
        long j11 = this.mNativeVideoSnapListener;
        if (j11 != 0) {
            nativeDestroy(j11);
            this.mNativeVideoSnapListener = 0;
        }
        super.finalize();
    }

    public void onComplete(Bitmap bitmap) {
        long j11 = this.mNativeVideoSnapListener;
        if (j11 != 0) {
            nativeOnComplete(j11, bitmap);
            this.mNativeVideoSnapListener = 0;
        }
    }
}
