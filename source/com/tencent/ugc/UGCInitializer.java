package com.tencent.ugc;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::ugc")
public class UGCInitializer {
    private static int sRefCount;

    public static synchronized void initialize() {
        synchronized (UGCInitializer.class) {
            if (sRefCount == 0) {
                nativeInitialize();
            }
            sRefCount++;
        }
    }

    private static native void nativeInitialize();

    private static native void nativeUninitialize();

    public static synchronized void uninitialize() {
        synchronized (UGCInitializer.class) {
            if (sRefCount == 1) {
                nativeUninitialize();
            }
            int i11 = sRefCount;
            if (i11 > 0) {
                sRefCount = i11 - 1;
            }
        }
    }
}
