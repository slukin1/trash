package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
public class NativeEncoderDataListener extends VideoEncoderDef.b {
    public static final String TAG = "NativeEncoderDataListener";
    private long mNativeVideoEncodeDataListener = 0;
    private int mStreamType = 0;

    public NativeEncoderDataListener(long j11, int i11) {
        this.mNativeVideoEncodeDataListener = j11;
        this.mStreamType = i11;
    }

    private native void nativeOnEncodedFail(long j11, int i11, int i12);

    private native void nativeOnEncodedNAL(long j11, int i11, EncodedVideoFrame encodedVideoFrame, ByteBuffer byteBuffer, ProducerChainTimestamp producerChainTimestamp, int i12, int i13, int i14, int i15, long j12, long j13, long j14, long j15, long j16, long j17, int i16, int i17, boolean z11, int i18);

    public synchronized void onEncodedFail(e.a aVar) {
        long j11 = this.mNativeVideoEncodeDataListener;
        if (j11 != 0) {
            nativeOnEncodedFail(j11, this.mStreamType, e.a(aVar));
        } else {
            LiteavLog.i(TAG, "onEncodedFail nativeclient is zero.");
        }
    }

    public synchronized void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z11) {
        int i11;
        int i12;
        EncodedVideoFrame encodedVideoFrame2 = encodedVideoFrame;
        synchronized (this) {
            long j11 = this.mNativeVideoEncodeDataListener;
            if (j11 == 0 || z11) {
                LiteavLog.d(TAG, "onEncodedNAL mNativeVideoEncodeDataListener=%d,isEos=%b", Long.valueOf(j11), Boolean.valueOf(z11));
                return;
            }
            int i13 = this.mStreamType;
            ByteBuffer byteBuffer = encodedVideoFrame2.data;
            ProducerChainTimestamp producerChainTimestamp = encodedVideoFrame2.producerChainTimestamp;
            int i14 = encodedVideoFrame2.nalType.mValue;
            int i15 = encodedVideoFrame2.profileType.mValue;
            int i16 = encodedVideoFrame2.codecType.mValue;
            int i17 = encodedVideoFrame2.rotation;
            long j12 = encodedVideoFrame2.dts;
            long j13 = encodedVideoFrame2.pts;
            long j14 = encodedVideoFrame2.gopIndex;
            long j15 = encodedVideoFrame2.gopFrameIndex;
            long j16 = encodedVideoFrame2.frameIndex;
            long j17 = encodedVideoFrame2.refFrameIndex;
            int i18 = encodedVideoFrame2.width;
            long j18 = j17;
            int i19 = encodedVideoFrame2.height;
            Integer num = encodedVideoFrame2.svcInfo;
            boolean z12 = num != null;
            if (num == null) {
                i11 = i18;
                i12 = 0;
            } else {
                i11 = i18;
                i12 = num.intValue();
            }
            nativeOnEncodedNAL(j11, i13, encodedVideoFrame, byteBuffer, producerChainTimestamp, i14, i15, i16, i17, j12, j13, j14, j15, j16, j18, i11, i19, z12, i12);
        }
    }

    public synchronized void reset() {
        this.mNativeVideoEncodeDataListener = 0;
    }
}
