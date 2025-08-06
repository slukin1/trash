package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.c;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videobase.videobase.f;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

@JNINamespace("liteav::video")
class NativeVideoCaptureListener implements c, CaptureSourceInterface.CaptureSourceListener {
    private static final String TAG = "NativeVideoCaptureListener";
    private long mNativeHandler;

    public NativeVideoCaptureListener(long j11) {
        this.mNativeHandler = j11;
    }

    private static native void nativeOnAutoFocusEnabled(long j11, boolean z11);

    private static native void nativeOnCaptureError(long j11, int i11, String str);

    private static native void nativeOnCaptureFirstFrame(long j11);

    private static native void nativeOnCapturePaused(long j11);

    private static native void nativeOnCaptureResumed(long j11);

    private static native void nativeOnCaptureStopped(long j11);

    private static native void nativeOnFrameAvailable(long j11, PixelFrame pixelFrame);

    private static native void nativeOnScreenDisplayOrientationChanged(long j11, int i11);

    private static native void nativeOnStartFinish(long j11, boolean z11);

    private static native void nativeOnZoomEnabled(long j11, boolean z11);

    public synchronized void notifyError(e.a aVar, String str) {
        if (this.mNativeHandler != 0) {
            int a11 = e.a(aVar);
            if (a11 != 0) {
                nativeOnCaptureError(this.mNativeHandler, a11, str);
                return;
            }
            LiteavLog.i(TAG, "notifyError error code:" + aVar + ", do not need transfer to LiteAvCode:" + a11);
        }
    }

    public void notifyEvent(e.b bVar, int i11, String str) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void notifyEvent(com.tencent.liteav.videobase.videobase.e.b r3, java.lang.Object r4, java.lang.String r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            long r4 = r2.mNativeHandler     // Catch:{ all -> 0x002f }
            r0 = 0
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x000b
            monitor-exit(r2)
            return
        L_0x000b:
            com.tencent.liteav.videobase.videobase.e$b r0 = com.tencent.liteav.videobase.videobase.e.b.EVT_VIDEO_CAPTURE_FIRST_FRAME     // Catch:{ all -> 0x002f }
            if (r3 != r0) goto L_0x0014
            nativeOnCaptureFirstFrame(r4)     // Catch:{ all -> 0x002f }
            monitor-exit(r2)
            return
        L_0x0014:
            com.tencent.liteav.videobase.videobase.e$b r0 = com.tencent.liteav.videobase.videobase.e.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_INTERRUPTED     // Catch:{ all -> 0x002f }
            if (r3 != r0) goto L_0x001d
            nativeOnCapturePaused(r4)     // Catch:{ all -> 0x002f }
            monitor-exit(r2)
            return
        L_0x001d:
            com.tencent.liteav.videobase.videobase.e$b r0 = com.tencent.liteav.videobase.videobase.e.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_RESUME     // Catch:{ all -> 0x002f }
            if (r3 != r0) goto L_0x0026
            nativeOnCaptureResumed(r4)     // Catch:{ all -> 0x002f }
            monitor-exit(r2)
            return
        L_0x0026:
            com.tencent.liteav.videobase.videobase.e$b r0 = com.tencent.liteav.videobase.videobase.e.b.EVT_VIDEO_CAPTURE_SCREEN_CAPTURE_STOP_SUCCESS     // Catch:{ all -> 0x002f }
            if (r3 != r0) goto L_0x002d
            nativeOnCaptureStopped(r4)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r2)
            return
        L_0x002f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.NativeVideoCaptureListener.notifyEvent(com.tencent.liteav.videobase.videobase.e$b, java.lang.Object, java.lang.String):void");
    }

    public synchronized void notifyWarning(e.c cVar, String str) {
    }

    public synchronized void onCameraTouchEnable(boolean z11) {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeOnAutoFocusEnabled(j11, !z11);
        }
    }

    public synchronized void onCameraZoomEnable(boolean z11) {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeOnZoomEnabled(j11, z11);
        }
    }

    public synchronized void onCaptureError() {
    }

    public synchronized void onCaptureFirstFrame() {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeOnCaptureFirstFrame(j11);
        }
    }

    public synchronized void onFrameAvailable(CaptureSourceInterface captureSourceInterface, PixelFrame pixelFrame) {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeOnFrameAvailable(j11, pixelFrame);
        }
    }

    public synchronized void onScreenDisplayOrientationChanged(k kVar) {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeOnScreenDisplayOrientationChanged(j11, k.a(kVar));
        }
    }

    public synchronized void onStartFinish(boolean z11) {
        long j11 = this.mNativeHandler;
        if (j11 != 0) {
            nativeOnStartFinish(j11, z11);
        }
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandler = 0;
    }

    public synchronized void updateStatus(f fVar, Object obj) {
    }

    public synchronized void updateStatus(f fVar, int i11, Object obj) {
    }
}
