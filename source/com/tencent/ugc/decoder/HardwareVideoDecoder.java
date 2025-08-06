package com.tencent.ugc.decoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.decoder.MediaCodecDecoder;
import com.tencent.ugc.decoder.VideoDecoderDef;
import com.tencent.ugc.decoder.VideoDecoderInterface;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.utils.HardwareDecoderMediaFormatBuilder;
import org.json.JSONArray;

public class HardwareVideoDecoder implements MediaCodecDecoder.MediaCodecDecoderListener, VideoDecoderInterface {
    private static final int INTERVAL_DRAIN_ONE_FRAME_MORE = 30;
    private boolean mAllowDrainDecodedFrames = true;
    private long mDecodedFrameCount = 0;
    private final HardwareDecoderMediaFormatBuilder mDecoderMediaFormatBuilder;
    private boolean mEnableLimitMaxDecFrameBufferingInH264Sps = false;
    private boolean mIsNeedNotifyAbandonCompleted = false;
    private VideoDecoderListener mListener = null;
    private MediaCodecDecoder mMediaCodecDecoder = null;
    private Surface mOutputSurface = null;
    private final HardwareVideoDecoderParams mParams;
    private EncodedVideoFrame mPendingDecodeFrame = null;
    private MediaCodec mPreloadMediaCodec;
    private VideoDecoderDef.ConsumerScene mScene = VideoDecoderDef.ConsumerScene.UNKNOWN;
    private String mTAG = "HardwareVideoDecoder";
    private final b mThrottlers = new b();
    private volatile CustomHandler mWorkHandler = null;

    public HardwareVideoDecoder(HardwareVideoDecoderParams hardwareVideoDecoderParams, MediaCodec mediaCodec) {
        HardwareVideoDecoderParams hardwareVideoDecoderParams2 = new HardwareVideoDecoderParams(hardwareVideoDecoderParams);
        this.mParams = hardwareVideoDecoderParams2;
        this.mPreloadMediaCodec = mediaCodec;
        String str = hardwareVideoDecoderParams2.useHevc ? "video/hevc" : "video/avc";
        MediaFormat mediaFormat = hardwareVideoDecoderParams.mediaFormat;
        if (mediaFormat != null) {
            hardwareVideoDecoderParams2.resolution = new Size(mediaFormat.getInteger("width"), hardwareVideoDecoderParams.mediaFormat.getInteger("height"));
            str = hardwareVideoDecoderParams.mediaFormat.getString("mime");
        }
        this.mDecoderMediaFormatBuilder = new HardwareDecoderMediaFormatBuilder().setMediaFormat(hardwareVideoDecoderParams2.mediaFormat).setMediaCodecDeviceRelatedParams(hardwareVideoDecoderParams2.mediaCodecDeviceRelatedParams).setMimeType(str).setWidth(hardwareVideoDecoderParams2.resolution.getWidth()).setHeight(hardwareVideoDecoderParams2.resolution.getHeight());
        this.mTAG += "_" + hashCode();
    }

    /* access modifiers changed from: private */
    public void abandonDecodingFramesInternal() {
        releasePendingDecodeFrame();
        MediaCodecDecoder mediaCodecDecoder = this.mMediaCodecDecoder;
        if (mediaCodecDecoder != null) {
            mediaCodecDecoder.flush();
        }
        if (this.mAllowDrainDecodedFrames) {
            notifyOnAbandonDecodingFramesCompleted();
        } else {
            this.mIsNeedNotifyAbandonCompleted = true;
        }
    }

    private boolean allowDrainOneFrameMore() {
        return this.mDecodedFrameCount % 30 == 0;
    }

    /* access modifiers changed from: private */
    public void drainAndFeedFrame() {
        EncodedVideoFrame encodedVideoFrame;
        if (this.mMediaCodecDecoder == null) {
            LiteavLog.w(this.mTAG, "MediaCodec is stopped.");
            releasePendingDecodeFrame();
            return;
        }
        try {
            if (this.mAllowDrainDecodedFrames) {
                drainDecodedFrame();
            }
            synchronized (this) {
                encodedVideoFrame = this.mPendingDecodeFrame;
            }
            if (encodedVideoFrame == null) {
                return;
            }
            if (this.mMediaCodecDecoder.feedEncodedFrame(encodedVideoFrame)) {
                synchronized (this) {
                    if (this.mPendingDecodeFrame == encodedVideoFrame) {
                        this.mPendingDecodeFrame = null;
                    }
                }
                releaseFrame(encodedVideoFrame);
            }
        } catch (Throwable th2) {
            LiteavLog.e(this.mTAG, "decode failed.", th2);
            handleDecoderError();
        }
    }

    private boolean drainDecodedFrame() {
        if (this.mMediaCodecDecoder.drainDecodedFrame()) {
            this.mAllowDrainDecodedFrames = false;
        }
        return this.mAllowDrainDecodedFrames;
    }

    private void handleDecoderError() {
        releasePendingDecodeFrame();
        VideoDecoderListener videoDecoderListener = this.mListener;
        if (videoDecoderListener != null) {
            videoDecoderListener.onDecodeFailed();
        }
    }

    public static /* synthetic */ void lambda$setOutputSurface$2(HardwareVideoDecoder hardwareVideoDecoder, Surface surface) {
        if (hardwareVideoDecoder.mOutputSurface != surface) {
            LiteavLog.i(hardwareVideoDecoder.mTAG, "setSurface ".concat(String.valueOf(surface)));
            hardwareVideoDecoder.mOutputSurface = surface;
            MediaCodecDecoder mediaCodecDecoder = hardwareVideoDecoder.mMediaCodecDecoder;
            if (mediaCodecDecoder != null && (mediaCodecDecoder instanceof MediaCodecHDRDecoder)) {
                ((MediaCodecHDRDecoder) mediaCodecDecoder).setOutputSurface(surface);
            }
        }
    }

    public static /* synthetic */ void lambda$setScene$1(HardwareVideoDecoder hardwareVideoDecoder, VideoDecoderDef.ConsumerScene consumerScene) {
        hardwareVideoDecoder.mScene = consumerScene;
        MediaCodecDecoder mediaCodecDecoder = hardwareVideoDecoder.mMediaCodecDecoder;
        if (mediaCodecDecoder != null) {
            mediaCodecDecoder.enableLimitMaxDecFrameBuffer(hardwareVideoDecoder.mEnableLimitMaxDecFrameBufferingInH264Sps && consumerScene == VideoDecoderDef.ConsumerScene.RTC);
        }
    }

    private void notifyEndOfStream() {
        VideoDecoderListener videoDecoderListener = this.mListener;
        if (videoDecoderListener != null) {
            videoDecoderListener.onDecodeCompleted();
        }
    }

    private void notifyOnAbandonDecodingFramesCompleted() {
        VideoDecoderListener videoDecoderListener = this.mListener;
        if (videoDecoderListener != null) {
            videoDecoderListener.onAbandonDecodingFramesCompleted();
        }
    }

    private void releaseFrame(EncodedVideoFrame encodedVideoFrame) {
        if (encodedVideoFrame != null) {
            encodedVideoFrame.release();
        }
    }

    private void releasePendingDecodeFrame() {
        EncodedVideoFrame encodedVideoFrame;
        synchronized (this) {
            encodedVideoFrame = this.mPendingDecodeFrame;
            this.mPendingDecodeFrame = null;
        }
        releaseFrame(encodedVideoFrame);
    }

    private void runOnWorkThread(Runnable runnable) {
        if (this.mWorkHandler != null) {
            this.mWorkHandler.runOrPost(runnable);
        }
    }

    /* access modifiers changed from: private */
    public void startInternal(Object obj, VideoDecoderListener videoDecoderListener) {
        boolean z11 = true;
        LiteavLog.i(this.mTAG, "Start decoder with eglContext:%s", obj);
        System.currentTimeMillis();
        if (this.mMediaCodecDecoder != null) {
            LiteavLog.w(this.mTAG, "Decoder already started.");
            return;
        }
        HardwareVideoDecoderParams hardwareVideoDecoderParams = this.mParams;
        String str = hardwareVideoDecoderParams.useHevc ? "video/hevc" : "video/avc";
        MediaFormat mediaFormat = hardwareVideoDecoderParams.mediaFormat;
        if (mediaFormat != null) {
            str = mediaFormat.getString("mime");
        }
        int supportColorFormat = DecodeAbilityProvider.getInstance().getSupportColorFormat(str);
        HardwareVideoDecoderParams hardwareVideoDecoderParams2 = this.mParams;
        if (hardwareVideoDecoderParams2.isHDR) {
            MediaCodecHDRDecoder mediaCodecHDRDecoder = new MediaCodecHDRDecoder(this.mDecoderMediaFormatBuilder, hardwareVideoDecoderParams2.resolution, hardwareVideoDecoderParams2.useSoftDecoder, this, this.mWorkHandler);
            this.mMediaCodecDecoder = mediaCodecHDRDecoder;
            mediaCodecHDRDecoder.setOutputSurface(this.mOutputSurface);
        } else if (!hardwareVideoDecoderParams2.useOutputBuffer || !MediaCodecOutputBufferDecoder.isSupportColorFormat(supportColorFormat)) {
            HardwareDecoderMediaFormatBuilder hardwareDecoderMediaFormatBuilder = this.mDecoderMediaFormatBuilder;
            HardwareVideoDecoderParams hardwareVideoDecoderParams3 = this.mParams;
            this.mMediaCodecDecoder = new MediaCodecOutputOESTextureDecoder(hardwareDecoderMediaFormatBuilder, hardwareVideoDecoderParams3.resolution, hardwareVideoDecoderParams3.useSoftDecoder, this, this.mWorkHandler);
        } else {
            HardwareDecoderMediaFormatBuilder hardwareDecoderMediaFormatBuilder2 = this.mDecoderMediaFormatBuilder;
            HardwareVideoDecoderParams hardwareVideoDecoderParams4 = this.mParams;
            this.mMediaCodecDecoder = new MediaCodecOutputBufferDecoder(hardwareDecoderMediaFormatBuilder2, hardwareVideoDecoderParams4.resolution, hardwareVideoDecoderParams4.useSoftDecoder, this, this.mWorkHandler);
        }
        this.mMediaCodecDecoder.enableLimitMaxDecFrameBuffer(this.mEnableLimitMaxDecFrameBufferingInH264Sps && this.mScene == VideoDecoderDef.ConsumerScene.RTC);
        this.mMediaCodecDecoder.start(obj);
        this.mListener = videoDecoderListener;
        MediaCodecDecoder.BuildResult buildMediaCodec = this.mMediaCodecDecoder.buildMediaCodec(this.mParams.isLowLatencyEnabled, this.mPreloadMediaCodec);
        if (!this.mParams.isLowLatencyEnabled || !buildMediaCodec.isSuccess) {
            z11 = false;
        }
        if (!buildMediaCodec.isSuccess) {
            buildMediaCodec = this.mMediaCodecDecoder.buildMediaCodec(false, (MediaCodec) null);
        }
        if (buildMediaCodec.isSuccess) {
            VideoDecoderListener videoDecoderListener2 = this.mListener;
            if (videoDecoderListener2 != null) {
                videoDecoderListener2.onDecodeLatencyChanged(z11);
            }
            System.currentTimeMillis();
            return;
        }
        stopInternal();
        handleDecoderError();
    }

    /* access modifiers changed from: private */
    public void stopInternal() {
        LiteavLog.i(this.mTAG, "Stop decoder");
        MediaCodecDecoder mediaCodecDecoder = this.mMediaCodecDecoder;
        if (mediaCodecDecoder != null) {
            mediaCodecDecoder.stop();
            this.mMediaCodecDecoder = null;
        }
        releasePendingDecodeFrame();
        this.mAllowDrainDecodedFrames = true;
        this.mDecodedFrameCount = 0;
    }

    public void abandonDecodingFrames() {
        LiteavLog.i(this.mTAG, "flush");
        runOnWorkThread(f.a(this));
    }

    public boolean decode(EncodedVideoFrame encodedVideoFrame) {
        synchronized (this) {
            if (this.mPendingDecodeFrame == null) {
                if (encodedVideoFrame != null) {
                    this.mPendingDecodeFrame = encodedVideoFrame;
                    runOnWorkThread(d.a(this));
                    return true;
                }
            }
            runOnWorkThread(c.a(this));
            return false;
        }
    }

    public VideoDecoderInterface.DecoderType getDecoderType() {
        HardwareVideoDecoderParams hardwareVideoDecoderParams = this.mParams;
        return (hardwareVideoDecoderParams == null || !hardwareVideoDecoderParams.useSoftDecoder) ? VideoDecoderInterface.DecoderType.HARDWARE : VideoDecoderInterface.DecoderType.SOFTWARE_DEVICE;
    }

    public void initialize() {
        HandlerThread handlerThread = new HandlerThread("HardwareVideoDecoder_" + hashCode());
        handlerThread.start();
        this.mWorkHandler = new CustomHandler(handlerThread.getLooper());
    }

    public void onDecodeFrame(PixelFrame pixelFrame, boolean z11) {
        if (z11) {
            notifyEndOfStream();
            this.mAllowDrainDecodedFrames = true;
        } else if (pixelFrame != null) {
            this.mDecodedFrameCount++;
            this.mAllowDrainDecodedFrames = true;
            VideoDecoderListener videoDecoderListener = this.mListener;
            if (videoDecoderListener != null) {
                videoDecoderListener.onDecodeFrame(pixelFrame, pixelFrame.getTimestamp());
            }
            try {
                if (allowDrainOneFrameMore() && drainDecodedFrame()) {
                    LiteavLog.d(this.mTAG, "drain more frame success");
                }
            } catch (Throwable th2) {
                LiteavLog.e(this.mThrottlers.a("drainDecodedFrame"), this.mTAG, "exception from drain decoded frame, message:" + th2.getMessage(), new Object[0]);
            }
            if (this.mIsNeedNotifyAbandonCompleted) {
                notifyOnAbandonDecodingFramesCompleted();
                this.mIsNeedNotifyAbandonCompleted = false;
            }
        }
    }

    public void onDecoderError() {
        handleDecoderError();
    }

    public void setOutputSurface(Surface surface) {
        runOnWorkThread(h.a(this, surface));
    }

    public void setScene(VideoDecoderDef.ConsumerScene consumerScene) {
        runOnWorkThread(g.a(this, consumerScene));
    }

    public void start(Object obj, VideoDecoderListener videoDecoderListener) {
        runOnWorkThread(b.a(this, obj, videoDecoderListener));
    }

    public void stop() {
        runOnWorkThread(e.a(this));
    }

    public void uninitialize() {
        if (this.mWorkHandler != null) {
            LiteavLog.i(this.mTAG, "uninitialize quitLooper");
            this.mWorkHandler.quitLooper();
        }
    }

    public static class HardwareVideoDecoderParams {
        public boolean isHDR = false;
        public boolean isLowLatencyEnabled = false;
        public JSONArray mediaCodecDeviceRelatedParams = null;
        public MediaFormat mediaFormat = null;
        public Size resolution = null;
        public boolean useHevc = false;
        public boolean useOutputBuffer = false;
        public boolean useSoftDecoder = false;

        public HardwareVideoDecoderParams(HardwareVideoDecoderParams hardwareVideoDecoderParams) {
            this.isHDR = hardwareVideoDecoderParams.isHDR;
            this.useHevc = hardwareVideoDecoderParams.useHevc;
            this.useOutputBuffer = hardwareVideoDecoderParams.useOutputBuffer;
            this.isLowLatencyEnabled = hardwareVideoDecoderParams.isLowLatencyEnabled;
            this.resolution = hardwareVideoDecoderParams.resolution;
            this.mediaFormat = hardwareVideoDecoderParams.mediaFormat;
            this.mediaCodecDeviceRelatedParams = hardwareVideoDecoderParams.mediaCodecDeviceRelatedParams;
            this.useSoftDecoder = hardwareVideoDecoderParams.useSoftDecoder;
        }

        public HardwareVideoDecoderParams() {
        }
    }
}
