package com.tencent.liteav.base.dispatcher;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
class PlatformDispatcherTask implements Runnable {
    private long mNativePlatformDispatcherTask = 0;

    public PlatformDispatcherTask(long j11) {
        this.mNativePlatformDispatcherTask = j11;
    }

    private void destroyTask() {
        long j11 = this.mNativePlatformDispatcherTask;
        if (j11 != 0) {
            nativeDestroyTask(j11);
            this.mNativePlatformDispatcherTask = 0;
        }
    }

    public static Handler getMainHandler() {
        return new Handler(Looper.getMainLooper());
    }

    private static native void nativeDestroyTask(long j11);

    private static native void nativeRunTask(long j11);

    public void finalize() throws Throwable {
        destroyTask();
        super.finalize();
    }

    public void run() {
        long j11 = this.mNativePlatformDispatcherTask;
        if (j11 != 0) {
            nativeRunTask(j11);
            destroyTask();
        }
    }
}
