package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videoconsumer.renderer.RenderViewHelperInterface;

@JNINamespace("liteav::video")
class NativeRenderViewListener implements RenderViewHelperInterface.RenderViewListener {
    private long mNativeHandler;

    public NativeRenderViewListener(long j11) {
        this.mNativeHandler = j11;
    }

    private static native void nativeOnRequestRedraw(long j11, Bitmap bitmap);

    private static native void nativeOnSurfaceChanged(long j11, Surface surface, boolean z11);

    private static native void nativeOnSurfaceDestroy(long j11);

    public synchronized void onRequestRedraw(Bitmap bitmap) {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeOnRequestRedraw(j11, bitmap);
        }
    }

    public synchronized void onSurfaceChanged(Surface surface, boolean z11) {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeOnSurfaceChanged(j11, surface, z11);
        }
    }

    public synchronized void onSurfaceDestroy() {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeOnSurfaceDestroy(j11);
        }
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0;
    }
}
