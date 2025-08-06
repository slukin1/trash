package com.tencent.liteav.base.logger;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
public class OnlineLoggerAndroid {
    private static final int INVALID_INSTANCE = -1;
    private long mNativeOnlineLoggerAndroid = -1;

    public enum a {
        kApi(1),
        kInfo(2),
        kWarning(3),
        kError(4);
        
        public int level;

        private a(int i11) {
            this.level = i11;
        }
    }

    public enum b {
        kTRTC,
        kLive
    }

    public OnlineLoggerAndroid(b bVar, int i11, String str, String str2) {
        this.mNativeOnlineLoggerAndroid = nativeCreate(bVar.ordinal(), i11, str, str2);
    }

    private static native long nativeCreate(int i11, int i12, String str, String str2);

    private static native void nativeDestroy(long j11);

    private static native void nativeLog(long j11, int i11, String str);

    public synchronized void destroy() {
        long j11 = this.mNativeOnlineLoggerAndroid;
        if (j11 != -1) {
            nativeDestroy(j11);
            this.mNativeOnlineLoggerAndroid = -1;
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public synchronized void log(a aVar, String str) {
        long j11 = this.mNativeOnlineLoggerAndroid;
        if (j11 != -1) {
            nativeLog(j11, aVar.level, str);
        }
    }
}
