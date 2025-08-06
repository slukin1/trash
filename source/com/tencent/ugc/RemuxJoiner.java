package com.tencent.ugc;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.List;

@JNINamespace("liteav::ugc")
public class RemuxJoiner {
    private static final String TAG = "RemuxJoiner";
    private RemuxJoinerListener mListener;
    private long mNativeHandle;

    public interface RemuxJoinerListener {
        void onRemuxJoinerComplete(int i11, String str);

        void onRemuxJoinerProgress(float f11);
    }

    public static boolean isConcatableWithoutReencode(List<String> list) {
        if (list.size() < 2) {
            return true;
        }
        String str = list.get(0);
        for (int i11 = 1; i11 < list.size(); i11++) {
            if (!nativeIsConcatableWithoutReencode(str, list.get(i11))) {
                return false;
            }
        }
        return true;
    }

    private static native long nativeCreate(RemuxJoiner remuxJoiner);

    private static native void nativeDestroy(long j11);

    private static native boolean nativeIsConcatableWithoutReencode(String str, String str2);

    private static native boolean nativeSetSourcePaths(long j11, Object[] objArr);

    private static native boolean nativeSetTargetPath(long j11, String str);

    private static native boolean nativeStart(long j11);

    private static native void nativeStop(long j11);

    private void onComplete(int i11, String str) {
        RemuxJoinerListener remuxJoinerListener = this.mListener;
        if (remuxJoinerListener != null) {
            remuxJoinerListener.onRemuxJoinerComplete(i11, str);
        }
    }

    private void onProgress(float f11) {
        RemuxJoinerListener remuxJoinerListener = this.mListener;
        if (remuxJoinerListener != null) {
            remuxJoinerListener.onRemuxJoinerProgress(f11);
        }
    }

    public void initialize() {
        LiteavLog.i(TAG, "initialize");
        if (this.mNativeHandle != 0) {
            LiteavLog.w(TAG, "RemuxJoiner is already initialize!");
        }
        this.mNativeHandle = nativeCreate(this);
    }

    public boolean setSourcePaths(List<String> list) {
        long j11 = this.mNativeHandle;
        if (j11 != 0) {
            return nativeSetSourcePaths(j11, list.toArray());
        }
        LiteavLog.w(TAG, "RemuxJoiner is not initialize");
        return false;
    }

    public boolean setTargetPath(String str) {
        long j11 = this.mNativeHandle;
        if (j11 != 0) {
            return nativeSetTargetPath(j11, str);
        }
        LiteavLog.w(TAG, "RemuxJoiner is not initialize");
        return false;
    }

    public void setVideoJoinerListener(RemuxJoinerListener remuxJoinerListener) {
        this.mListener = remuxJoinerListener;
    }

    public boolean start() {
        long j11 = this.mNativeHandle;
        if (j11 == 0) {
            LiteavLog.w(TAG, "RemuxJoiner is not initialize");
            return false;
        } else if (nativeStart(j11)) {
            return true;
        } else {
            LiteavLog.e(TAG, "native RemuxJoiner start failed.");
            return false;
        }
    }

    public void stop() {
        long j11 = this.mNativeHandle;
        if (j11 == 0) {
            LiteavLog.w(TAG, "RemuxJoiner is not initialize");
        } else {
            nativeStop(j11);
        }
    }

    public void uninitialize() {
        LiteavLog.i(TAG, "unInitialize");
        long j11 = this.mNativeHandle;
        if (j11 != 0) {
            nativeDestroy(j11);
            this.mNativeHandle = 0;
        }
    }
}
