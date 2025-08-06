package com.tencent.ugc;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::ugc")
public class UGCAVSyncer {
    public long mNativeUGCAVSyncer;

    public enum SkipMode {
        NOOP(0),
        SKIP_CURRENT_FRAME(1);
        
        private final int mNativeValue;

        private SkipMode(int i11) {
            this.mNativeValue = i11;
        }

        public final int getNativeValue() {
            return this.mNativeValue;
        }

        public static SkipMode valueOf(int i11) {
            if (i11 == 1) {
                return SKIP_CURRENT_FRAME;
            }
            return NOOP;
        }
    }

    public enum SyncMode {
        OFF(0),
        CLOCK_MASTER(1),
        AUDIO_MASTER(2),
        VIDEO_MASTER(3),
        INTERLEAVE_OUTPUT_WITHOUT_SKIP(4);
        
        private final int mNativeValue;

        private SyncMode(int i11) {
            this.mNativeValue = i11;
        }

        public final int getNativeValue() {
            return this.mNativeValue;
        }
    }

    public UGCAVSyncer() {
        this.mNativeUGCAVSyncer = 0;
        this.mNativeUGCAVSyncer = nativeCreate();
    }

    private static native long nativeCreate();

    private static native void nativeDestroy(long j11);

    private static native void nativeResetClock(long j11);

    private static native void nativeSetAudioEos(long j11);

    private static native void nativeSetAudioExist(long j11, boolean z11);

    private static native void nativeSetSyncMode(long j11, int i11);

    private static native void nativeSetVideoEos(long j11);

    private static native void nativeSetVideoExist(long j11, boolean z11);

    private static native void nativeStart(long j11);

    private static native void nativeStop(long j11);

    private static native int nativeSyncAudio(long j11, long j12);

    private static native int nativeSyncVideo(long j11, long j12);

    public void finalize() throws Throwable {
        long j11 = this.mNativeUGCAVSyncer;
        if (j11 != 0) {
            nativeDestroy(j11);
            this.mNativeUGCAVSyncer = 0;
        }
    }

    public void resetClock() {
        long j11 = this.mNativeUGCAVSyncer;
        if (j11 != 0) {
            nativeResetClock(j11);
        }
    }

    public void setAudioEos() {
        long j11 = this.mNativeUGCAVSyncer;
        if (j11 != 0) {
            nativeSetAudioEos(j11);
        }
    }

    public void setAudioExist(boolean z11) {
        long j11 = this.mNativeUGCAVSyncer;
        if (j11 != 0) {
            nativeSetAudioExist(j11, z11);
        }
    }

    public void setSyncMode(SyncMode syncMode) {
        long j11 = this.mNativeUGCAVSyncer;
        if (j11 != 0) {
            nativeSetSyncMode(j11, syncMode.getNativeValue());
        }
    }

    public void setVideoEos() {
        long j11 = this.mNativeUGCAVSyncer;
        if (j11 != 0) {
            nativeSetVideoEos(j11);
        }
    }

    public void setVideoExist(boolean z11) {
        long j11 = this.mNativeUGCAVSyncer;
        if (j11 != 0) {
            nativeSetVideoExist(j11, z11);
        }
    }

    public void start() {
        long j11 = this.mNativeUGCAVSyncer;
        if (j11 != 0) {
            nativeStart(j11);
        }
    }

    public void stop() {
        long j11 = this.mNativeUGCAVSyncer;
        if (j11 != 0) {
            nativeStop(j11);
        }
    }

    public SkipMode syncAudio(long j11) {
        long j12 = this.mNativeUGCAVSyncer;
        if (j12 == 0) {
            return SkipMode.NOOP;
        }
        return SkipMode.valueOf(nativeSyncAudio(j12, j11));
    }

    public SkipMode syncVideo(long j11) {
        long j12 = this.mNativeUGCAVSyncer;
        if (j12 == 0) {
            return SkipMode.NOOP;
        }
        return SkipMode.valueOf(nativeSyncVideo(j12, j11));
    }
}
