package com.tencent.ugc.decoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.decoder.VideoDecoderDef;
import com.tencent.ugc.decoder.VideoDecoderInterface;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.frame.PixelFramePool;
import java.nio.ByteBuffer;

@JNINamespace("liteav::ugc")
public class SoftwareVideoDecoder implements VideoDecoderInterface {
    private static final String TAG = "SoftwareVideoDecoder";
    private final boolean mIsUseHevc;
    private VideoDecoderListener mListener;
    private long mNativeVideoDecoderWrapper = 0;
    private PixelFramePool mPixelFramePool;

    public SoftwareVideoDecoder(boolean z11) {
        this.mIsUseHevc = z11;
    }

    private ByteBuffer getByteBufferFromPixelFrame(PixelFrame pixelFrame) {
        return pixelFrame.getBuffer();
    }

    private void handleDecoderError() {
        VideoDecoderListener videoDecoderListener = this.mListener;
        if (videoDecoderListener != null) {
            videoDecoderListener.onDecodeFailed();
        }
    }

    private static native void nativeAbandonDecodingFrames(long j11);

    private static native long nativeCreate(SoftwareVideoDecoder softwareVideoDecoder);

    private static native int nativeDecodeFrame(long j11, EncodedVideoFrame encodedVideoFrame, ByteBuffer byteBuffer, int i11, int i12, int i13, long j12, long j13);

    private static native void nativeDestroy(long j11);

    private static native int nativeStart(long j11, boolean z11);

    private static native int nativeStop(long j11);

    private PixelFrame obtainPixelFrame(int i11, int i12, int i13, int i14, long j11, int i15, int i16) {
        GLConstants.PixelFormatType fromInteger = GLConstants.PixelFormatType.fromInteger(i11);
        if (fromInteger == null) {
            handleDecoderError();
            LiteavLog.e(TAG, "obtainPixelFrame formatType: ".concat(String.valueOf(i11)));
            return null;
        }
        PixelFramePool pixelFramePool = this.mPixelFramePool;
        if (pixelFramePool == null) {
            LiteavLog.i(TAG, "obtainPixelFrame mPixelFramePool is null.");
            return null;
        }
        PixelFrame obtain = pixelFramePool.obtain(i12, i13, GLConstants.PixelBufferType.BYTE_BUFFER, fromInteger);
        obtain.setColorFormat(GLConstants.ColorRange.fromInteger(i16), GLConstants.ColorSpace.fromInteger(i15));
        obtain.setRotation(k.a(i14));
        obtain.setTimestamp(j11);
        return obtain;
    }

    private void onDecodedFrame(PixelFrame pixelFrame, long j11) {
        if (j11 != 0) {
            handleDecoderError();
            LiteavLog.e(TAG, "decode failed.".concat(String.valueOf(j11)));
            if (pixelFrame != null) {
                pixelFrame.release();
            }
        } else if (pixelFrame != null) {
            VideoDecoderListener videoDecoderListener = this.mListener;
            if (videoDecoderListener != null) {
                videoDecoderListener.onDecodeFrame(pixelFrame, pixelFrame.getTimestamp());
            }
            pixelFrame.release();
        }
    }

    public void abandonDecodingFrames() {
        long j11 = this.mNativeVideoDecoderWrapper;
        if (j11 == 0) {
            LiteavLog.w(TAG, "decoder has already stopped");
            return;
        }
        nativeAbandonDecodingFrames(j11);
        VideoDecoderListener videoDecoderListener = this.mListener;
        if (videoDecoderListener != null) {
            videoDecoderListener.onAbandonDecodingFramesCompleted();
        }
    }

    public boolean decode(EncodedVideoFrame encodedVideoFrame) {
        VideoDecoderListener videoDecoderListener;
        if (encodedVideoFrame == null) {
            return false;
        }
        if (!encodedVideoFrame.isEosFrame || (videoDecoderListener = this.mListener) == null) {
            ByteBuffer byteBuffer = encodedVideoFrame.data;
            if (byteBuffer == null || byteBuffer.remaining() == 0) {
                return false;
            }
            nativeDecodeFrame(this.mNativeVideoDecoderWrapper, encodedVideoFrame, encodedVideoFrame.data, encodedVideoFrame.nalType.getValue(), encodedVideoFrame.codecType.getValue(), encodedVideoFrame.rotation, encodedVideoFrame.pts, encodedVideoFrame.dts);
            encodedVideoFrame.release();
            return true;
        }
        videoDecoderListener.onDecodeCompleted();
        return true;
    }

    public VideoDecoderInterface.DecoderType getDecoderType() {
        return VideoDecoderInterface.DecoderType.SOFTWARE;
    }

    public void initialize() {
    }

    public void setScene(VideoDecoderDef.ConsumerScene consumerScene) {
    }

    public void start(Object obj, VideoDecoderListener videoDecoderListener) {
        if (this.mNativeVideoDecoderWrapper != 0) {
            LiteavLog.w(TAG, "decoder is already started!");
            return;
        }
        this.mPixelFramePool = new PixelFramePool();
        this.mListener = videoDecoderListener;
        long nativeCreate = nativeCreate(this);
        this.mNativeVideoDecoderWrapper = nativeCreate;
        if (nativeCreate == 0) {
            handleDecoderError();
            LiteavLog.e(TAG, "create native instance failed.");
        } else if (nativeStart(nativeCreate, this.mIsUseHevc) != 0) {
            handleDecoderError();
            LiteavLog.e(TAG, "Start software decoder failed.");
        } else {
            LiteavLog.i(TAG, "decoder Start success.");
        }
    }

    public void stop() {
        if (this.mNativeVideoDecoderWrapper == 0) {
            LiteavLog.w(TAG, "decoder has already stopped");
            return;
        }
        PixelFramePool pixelFramePool = this.mPixelFramePool;
        if (pixelFramePool != null) {
            pixelFramePool.destroy();
        }
        nativeStop(this.mNativeVideoDecoderWrapper);
        nativeDestroy(this.mNativeVideoDecoderWrapper);
        this.mNativeVideoDecoderWrapper = 0;
        LiteavLog.i(TAG, "decoder stop.");
    }

    public void uninitialize() {
    }
}
