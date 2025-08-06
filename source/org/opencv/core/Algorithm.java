package org.opencv.core;

public class Algorithm {
    public final long nativeObj;

    public Algorithm(long j11) {
        this.nativeObj = j11;
    }

    public static Algorithm __fromPtr__(long j11) {
        return new Algorithm(j11);
    }

    private static native void clear_0(long j11);

    private static native void delete(long j11);

    private static native boolean empty_0(long j11);

    private static native String getDefaultName_0(long j11);

    private static native void save_0(long j11, String str);

    public void clear() {
        clear_0(this.nativeObj);
    }

    public boolean empty() {
        return empty_0(this.nativeObj);
    }

    public void finalize() throws Throwable {
        delete(this.nativeObj);
    }

    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public void save(String str) {
        save_0(this.nativeObj, str);
    }
}
