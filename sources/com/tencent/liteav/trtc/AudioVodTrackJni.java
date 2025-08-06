package com.tencent.liteav.trtc;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.trtc.TRTCCloudDef;

@JNINamespace("liteav::trtc")
public class AudioVodTrackJni {
    private long mNativeAudioVodTrackJni;

    public static class AudioFrame {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCAudioFrame f21674a;

        public AudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
            this.f21674a = tRTCAudioFrame;
        }

        public int getChannel() {
            return this.f21674a.channel;
        }

        public byte[] getData() {
            return this.f21674a.data;
        }

        public int getSampleRate() {
            return this.f21674a.sampleRate;
        }

        public long getTimestamp() {
            return this.f21674a.timestamp;
        }
    }

    public AudioVodTrackJni() {
        this.mNativeAudioVodTrackJni = 0;
        this.mNativeAudioVodTrackJni = nativeCreateAudioVodTrackJni(this);
    }

    private static native void nativeClean(long j11);

    private static native long nativeCreateAudioVodTrackJni(AudioVodTrackJni audioVodTrackJni);

    private static native void nativeEnablePlayout(long j11, boolean z11);

    private static native void nativePause(long j11);

    private static native void nativeResume(long j11);

    private static native void nativeSeek(long j11);

    private static native void nativeSetPlayoutVolume(long j11, int i11);

    private static native int nativeWriteData(long j11, AudioFrame audioFrame);

    public synchronized void clean() {
        long j11 = this.mNativeAudioVodTrackJni;
        if (j11 != 0) {
            nativeClean(j11);
        }
    }

    public synchronized void enablePlayout(boolean z11) {
        long j11 = this.mNativeAudioVodTrackJni;
        if (j11 != 0) {
            nativeEnablePlayout(j11, z11);
        }
    }

    public synchronized void pause() {
        long j11 = this.mNativeAudioVodTrackJni;
        if (j11 != 0) {
            nativePause(j11);
        }
    }

    public synchronized void resume() {
        long j11 = this.mNativeAudioVodTrackJni;
        if (j11 != 0) {
            nativeResume(j11);
        }
    }

    public synchronized void seek() {
        long j11 = this.mNativeAudioVodTrackJni;
        if (j11 != 0) {
            nativeSeek(j11);
        }
    }

    public synchronized void setPlayoutVolume(int i11) {
        long j11 = this.mNativeAudioVodTrackJni;
        if (j11 != 0) {
            nativeSetPlayoutVolume(j11, i11);
        }
    }

    public synchronized int writeData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        long j11 = this.mNativeAudioVodTrackJni;
        if (j11 == 0) {
            return -1;
        }
        return nativeWriteData(j11, new AudioFrame(tRTCAudioFrame));
    }
}
