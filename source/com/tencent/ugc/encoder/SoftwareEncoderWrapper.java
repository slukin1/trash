package com.tencent.ugc.encoder;

import android.os.HandlerThread;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.encoder.VideoEncoderInterface;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.common.CodecType;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.videobase.common.VideoFrameType;
import com.tencent.ugc.videobase.common.VideoProfileType;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.utils.RingFrameQueue;
import java.nio.ByteBuffer;

@JNINamespace("liteav::ugc")
public class SoftwareEncoderWrapper {
    private static final int MAX_CACHE_SIZE = 1;
    private final RingFrameQueue mFrameQueue = new RingFrameQueue(1);
    private VideoEncoderInterface.VideoEncoderListener mListener;
    private long mNativeEncodeWrapper = 0;
    private final String mTAG = ("SoftwareEncoderWrapper_" + hashCode());
    private VideoEncodeParams mVideoEncodeParams;
    private CustomHandler mWorkHandler;

    private static EncodedVideoFrame createEncodedVideoFrameCallFromNative(ByteBuffer byteBuffer, int i11, int i12, int i13, int i14, long j11, long j12, long j13, int i15, int i16, long j14, long j15, long j16, boolean z11, int i17) {
        EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
        encodedVideoFrame.nalType = VideoFrameType.fromInteger(i11);
        encodedVideoFrame.codecType = CodecType.fromInteger(i12);
        encodedVideoFrame.profileType = VideoProfileType.fromInteger(i13);
        encodedVideoFrame.data = byteBuffer;
        encodedVideoFrame.dts = j11;
        encodedVideoFrame.pts = j12;
        encodedVideoFrame.rotation = i14;
        encodedVideoFrame.frameIndex = j14;
        encodedVideoFrame.gopFrameIndex = 0;
        encodedVideoFrame.gopIndex = j15;
        encodedVideoFrame.refFrameIndex = j16;
        encodedVideoFrame.nativePtr = j13;
        encodedVideoFrame.width = i15;
        encodedVideoFrame.height = i16;
        if (z11) {
            encodedVideoFrame.svcInfo = Integer.valueOf(i17);
        } else {
            encodedVideoFrame.svcInfo = null;
        }
        return encodedVideoFrame;
    }

    public static /* synthetic */ void lambda$encodeFrame$2(SoftwareEncoderWrapper softwareEncoderWrapper) {
        PixelFrame poll = softwareEncoderWrapper.mFrameQueue.poll();
        if (poll != null) {
            long j11 = softwareEncoderWrapper.mNativeEncodeWrapper;
            if (j11 != 0) {
                nativeEncodeFrame(j11, poll.getBuffer(), poll.getWidth(), poll.getHeight(), poll.getTimestamp());
            }
            poll.release();
        }
    }

    public static /* synthetic */ void lambda$initialize$0(SoftwareEncoderWrapper softwareEncoderWrapper) {
        softwareEncoderWrapper.mNativeEncodeWrapper = nativeCreate(softwareEncoderWrapper);
        String str = softwareEncoderWrapper.mTAG;
        LiteavLog.i(str, "initialize " + softwareEncoderWrapper.mNativeEncodeWrapper);
    }

    public static /* synthetic */ void lambda$restartIDRFrame$3(SoftwareEncoderWrapper softwareEncoderWrapper) {
        long j11 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j11 != 0) {
            nativeRestartIDR(j11);
        }
    }

    public static /* synthetic */ void lambda$setBitrate$4(SoftwareEncoderWrapper softwareEncoderWrapper, int i11) {
        long j11 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j11 != 0) {
            nativeSetBitrate(j11, i11);
        }
    }

    public static /* synthetic */ void lambda$setFps$5(SoftwareEncoderWrapper softwareEncoderWrapper, int i11) {
        long j11 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j11 != 0) {
            nativeSetFps(j11, i11);
        }
    }

    public static /* synthetic */ void lambda$signalEndOfStream$6(SoftwareEncoderWrapper softwareEncoderWrapper) {
        VideoEncoderInterface.VideoEncoderListener videoEncoderListener = softwareEncoderWrapper.mListener;
        if (videoEncoderListener != null) {
            videoEncoderListener.onEncodedNAL(new EncodedVideoFrame(), true);
        }
    }

    public static /* synthetic */ void lambda$start$1(SoftwareEncoderWrapper softwareEncoderWrapper, VideoEncoderInterface.VideoEncoderListener videoEncoderListener, VideoEncodeParams videoEncodeParams) {
        softwareEncoderWrapper.mListener = videoEncoderListener;
        softwareEncoderWrapper.mVideoEncodeParams = videoEncodeParams;
        long j11 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j11 != 0) {
            nativeStart(j11, videoEncodeParams);
        }
        LiteavLog.i(softwareEncoderWrapper.mTAG, "start encoder");
    }

    public static /* synthetic */ void lambda$stopSync$7(SoftwareEncoderWrapper softwareEncoderWrapper) {
        long j11 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j11 != 0) {
            nativeStop(j11);
        }
        softwareEncoderWrapper.mListener = null;
        LiteavLog.i(softwareEncoderWrapper.mTAG, "stop encoder");
    }

    public static /* synthetic */ void lambda$uninitialize$8(SoftwareEncoderWrapper softwareEncoderWrapper) {
        long j11 = softwareEncoderWrapper.mNativeEncodeWrapper;
        if (j11 != 0) {
            nativeDestroy(j11);
            softwareEncoderWrapper.mNativeEncodeWrapper = 0;
        }
        LiteavLog.i(softwareEncoderWrapper.mTAG, "destroy encode wrapper");
    }

    private static native long nativeCreate(SoftwareEncoderWrapper softwareEncoderWrapper);

    private static native void nativeDestroy(long j11);

    private static native int nativeEncodeFrame(long j11, ByteBuffer byteBuffer, int i11, int i12, long j12);

    private static native void nativeRestartIDR(long j11);

    private static native void nativeSetBitrate(long j11, int i11);

    private static native void nativeSetFps(long j11, int i11);

    private static native int nativeStart(long j11, VideoEncodeParams videoEncodeParams);

    private static native int nativeStop(long j11);

    private void onEncodedFail() {
        VideoEncoderInterface.VideoEncoderListener videoEncoderListener = this.mListener;
        if (videoEncoderListener != null) {
            videoEncoderListener.onEncodedFail();
        }
    }

    private void onEncodedNAL(EncodedVideoFrame encodedVideoFrame) {
        VideoEncoderInterface.VideoEncoderListener videoEncoderListener = this.mListener;
        if (videoEncoderListener != null) {
            videoEncoderListener.onEncodedNAL(encodedVideoFrame, false);
        }
    }

    private void runOrPostToWorkThread(Runnable runnable) {
        CustomHandler customHandler = this.mWorkHandler;
        if (customHandler != null) {
            customHandler.runOrPost(runnable);
        }
    }

    public void encodeFrame(PixelFrame pixelFrame) {
        if (pixelFrame.getPixelFormatType() == GLConstants.PixelFormatType.I420 && pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.BYTE_BUFFER) {
            pixelFrame.getColorRange();
            pixelFrame.getColorSpace();
            this.mFrameQueue.push(pixelFrame);
            runOrPostToWorkThread(l.a(this));
            return;
        }
        LiteavLog.d(this.mTAG, "pixelFrame pixelFormat not I420 ");
    }

    public synchronized void initialize() {
        if (this.mWorkHandler == null) {
            HandlerThread handlerThread = new HandlerThread("software-encoder");
            handlerThread.start();
            CustomHandler customHandler = new CustomHandler(handlerThread.getLooper());
            this.mWorkHandler = customHandler;
            customHandler.runOrPost(j.a(this));
        }
    }

    public boolean isInputQueueFull() {
        return this.mFrameQueue.size() > 0;
    }

    public void restartIDRFrame() {
        runOrPostToWorkThread(m.a(this));
    }

    public void setBitrate(int i11) {
        runOrPostToWorkThread(n.a(this, i11));
    }

    public void setFps(int i11) {
        runOrPostToWorkThread(o.a(this, i11));
    }

    public void signalEndOfStream() {
        LiteavLog.i(this.mTAG, "signalEndOfStream");
        runOrPostToWorkThread(p.a(this));
    }

    public void start(VideoEncodeParams videoEncodeParams, VideoEncoderInterface.VideoEncoderListener videoEncoderListener) {
        runOrPostToWorkThread(k.a(this, videoEncoderListener, new VideoEncodeParams(videoEncodeParams)));
    }

    public void stopSync(long j11) {
        runOrPostToWorkThread(q.a(this));
    }

    public synchronized void uninitialize() {
        if (this.mWorkHandler != null) {
            runOrPostToWorkThread(r.a(this));
            this.mWorkHandler.quitLooper();
            this.mWorkHandler = null;
        }
    }
}
