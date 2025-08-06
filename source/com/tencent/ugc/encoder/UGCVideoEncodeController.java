package com.tencent.ugc.encoder;

import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.l;
import com.tencent.ugc.encoder.VideoEncoderDef;
import com.tencent.ugc.encoder.VideoEncoderInterface;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.utils.BlockingFrameQueue;
import com.tencent.ugc.videobase.utils.PixelFrameQueue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class UGCVideoEncodeController {
    private static final PixelFrame EOS_FRAME = new PixelFrame();
    private static final int FRAME_QUEUE_SIZE = 1;
    private static final int MAX_ENCODE_COST_TIME_PER_FRAME = 5000;
    private static final int MAX_ENCODING_FRAME_NUMBER = 30;
    private static final int MAX_WAIT_TIME_MS = 2000;
    private static final int SCHEDULE_ENCODE_TASK_DELAY_TIME_MS = 3;
    private static final int THREAD_KEEP_ALIVE_TIME_IN_SECOND = 15;
    private VideoEncodeParams mEncodeParams;
    private a mEncoderStats = a.STOPED;
    private final VideoEncoderDef.EncoderType mExceptEncodeType;
    /* access modifiers changed from: private */
    public final Map<Long, Long> mFrameDeliverToEncoderTimeMap = new HashMap();
    private boolean mHasEncodeFailureNotified = false;
    /* access modifiers changed from: private */
    public final AtomicBoolean mHasEncoderError = new AtomicBoolean(false);
    private final PixelFrameQueue mPendingEncodeFrameQueue;
    /* access modifiers changed from: private */
    public final l mSequenceTaskRunner;
    private final Bundle mSessionStates = new Bundle();
    /* access modifiers changed from: private */
    public final String mTag;
    /* access modifiers changed from: private */
    public final b mThrottlers;
    /* access modifiers changed from: private */
    public VideoEncoderDef.VideoEncoderDataListener mUGCEncoderControllerListener;
    private VideoEncoderInterface mVideoEncoder;
    private final VideoEncoderInterface.VideoEncoderListener mVideoEncoderListener = new VideoEncoderInterface.VideoEncoderListener() {
        public static /* synthetic */ void a(AnonymousClass1 r32, boolean z11, EncodedVideoFrame encodedVideoFrame) {
            if (z11) {
                LiteavLog.i(UGCVideoEncodeController.this.mTag, "got eos");
            }
            if (UGCVideoEncodeController.this.mUGCEncoderControllerListener != null) {
                UGCVideoEncodeController.this.mUGCEncoderControllerListener.onEncodedNAL(encodedVideoFrame, z11);
            }
            UGCVideoEncodeController.this.removeEarlierFrameFromFrameDeliverToEncoderTimeMap(encodedVideoFrame.pts);
            if (z11 && !UGCVideoEncodeController.this.mFrameDeliverToEncoderTimeMap.isEmpty()) {
                LiteavLog.e(UGCVideoEncodeController.this.mTag, "got eos frame with unencoded frames left, causing an error");
                UGCVideoEncodeController.this.mHasEncoderError.set(true);
            }
        }

        public final void onEncodedFail() {
            LiteavLog.e(UGCVideoEncodeController.this.mThrottlers.a("onEncodedFail"), UGCVideoEncodeController.this.mTag, "on encoded fail", new Object[0]);
            UGCVideoEncodeController.this.mHasEncoderError.set(true);
        }

        public final void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z11) {
            if (encodedVideoFrame == null) {
                LiteavLog.d(UGCVideoEncodeController.this.mThrottlers.a("onEncodedNAL"), UGCVideoEncodeController.this.mTag, "on encoded frame is null.", new Object[0]);
            } else {
                UGCVideoEncodeController.this.mSequenceTaskRunner.a(ag.a(this, z11, encodedVideoFrame));
            }
        }

        public final void onOutputFormatChanged(MediaFormat mediaFormat) {
            LiteavLog.i(UGCVideoEncodeController.this.mThrottlers.a("formatChanged"), UGCVideoEncodeController.this.mTag, "On output format changed. format is ".concat(String.valueOf(mediaFormat)), new Object[0]);
        }

        public final void onRequestRestart() {
            LiteavLog.i(UGCVideoEncodeController.this.mThrottlers.a("onRequestRestart"), UGCVideoEncodeController.this.mTag, "on request restart", new Object[0]);
            UGCVideoEncodeController.this.mHasEncoderError.set(true);
        }
    };

    public enum a {
        STOPED,
        ENCODING,
        EOS_SENDED
    }

    public UGCVideoEncodeController(VideoEncoderDef.EncoderType encoderType) {
        String str = "UGCVideoEncodeController_" + hashCode();
        this.mTag = str;
        LiteavLog.i(str, "UGCVideoEncodeController construct encoderType = ".concat(String.valueOf(encoderType)));
        this.mThrottlers = new b();
        this.mExceptEncodeType = encoderType;
        this.mSequenceTaskRunner = new l(15, str);
        this.mPendingEncodeFrameQueue = new BlockingFrameQueue(1);
    }

    private boolean createEncoder() {
        PixelFrame peek = this.mPendingEncodeFrameQueue.peek();
        boolean z11 = false;
        if (peek == null) {
            return false;
        }
        if (peek.getColorSpace() == GLConstants.ColorSpace.BT709) {
            z11 = true;
        }
        if (this.mExceptEncodeType != VideoEncoderDef.EncoderType.HARDWARE || z11) {
            this.mVideoEncoder = new SoftwareVideoEncoder();
        } else {
            this.mVideoEncoder = new HardwareVideoEncoder(this.mSessionStates);
        }
        this.mVideoEncoder.initialize();
        this.mEncodeParams.colorRange = peek.getColorRange();
        this.mEncodeParams.colorSpace = peek.getColorSpace();
        boolean start = this.mVideoEncoder.start(this.mEncodeParams, this.mVideoEncoderListener);
        this.mHasEncoderError.set(!start);
        return start;
    }

    private void destroyEncoder() {
        VideoEncoderInterface videoEncoderInterface = this.mVideoEncoder;
        if (videoEncoderInterface != null) {
            videoEncoderInterface.stopSync(2000);
            this.mVideoEncoder.uninitialize();
            this.mVideoEncoder = null;
        }
    }

    /* access modifiers changed from: private */
    public void encodeFrameInternal() {
        if (this.mEncoderStats == a.STOPED) {
            this.mPendingEncodeFrameQueue.evictAll();
        } else if ((this.mVideoEncoder != null || createEncoder()) && !hasEncoderError()) {
            a aVar = this.mEncoderStats;
            a aVar2 = a.EOS_SENDED;
            if (aVar == aVar2) {
                this.mPendingEncodeFrameQueue.evictAll();
                this.mSequenceTaskRunner.b(ad.a(this), 3);
            } else if (this.mVideoEncoder.isInputQueueFull()) {
                this.mSequenceTaskRunner.b(ae.a(this), 3);
            } else {
                PixelFrame poll = this.mPendingEncodeFrameQueue.poll();
                if (poll != null) {
                    this.mFrameDeliverToEncoderTimeMap.put(Long.valueOf(poll.getTimestamp()), Long.valueOf(SystemClock.elapsedRealtime()));
                    if (poll == EOS_FRAME) {
                        this.mVideoEncoder.signalEndOfStream();
                        this.mEncoderStats = aVar2;
                        this.mSequenceTaskRunner.b(af.a(this), 3);
                        return;
                    }
                    this.mVideoEncoder.encodeFrame(poll);
                    poll.release();
                }
            }
        } else {
            this.mPendingEncodeFrameQueue.evictAll();
            notifyEncodedFail();
        }
    }

    private long getEarliestTimeFromFrameDeliverToEncoderTimeMap() {
        long j11 = Long.MAX_VALUE;
        for (Long longValue : this.mFrameDeliverToEncoderTimeMap.values()) {
            long longValue2 = longValue.longValue();
            if (longValue2 < j11) {
                j11 = longValue2;
            }
        }
        return j11;
    }

    private boolean hasEncoderError() {
        if (this.mHasEncoderError.get()) {
            LiteavLog.e(this.mThrottlers.a("hasEncoderError"), this.mTag, "encoder error or encoder need restart", new Object[0]);
            return true;
        }
        long earliestTimeFromFrameDeliverToEncoderTimeMap = getEarliestTimeFromFrameDeliverToEncoderTimeMap();
        if (earliestTimeFromFrameDeliverToEncoderTimeMap != 0 && SystemClock.elapsedRealtime() - earliestTimeFromFrameDeliverToEncoderTimeMap > 5000) {
            LiteavLog.e(this.mThrottlers.a("hasEncoderError"), this.mTag, "encoder output frame is outTime", new Object[0]);
            return true;
        } else if (this.mFrameDeliverToEncoderTimeMap.size() <= 30) {
            return false;
        } else {
            LiteavLog.e(this.mThrottlers.a("isEncoderError"), this.mTag, "encoding frame is too many", new Object[0]);
            return true;
        }
    }

    public static /* synthetic */ void lambda$start$0(UGCVideoEncodeController uGCVideoEncodeController, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        if (uGCVideoEncodeController.mVideoEncoder != null) {
            LiteavLog.i(uGCVideoEncodeController.mThrottlers.a("start"), uGCVideoEncodeController.mTag, "VideoEncoder is started", new Object[0]);
            return;
        }
        uGCVideoEncodeController.mEncodeParams = new VideoEncodeParams(videoEncodeParams);
        uGCVideoEncodeController.mUGCEncoderControllerListener = videoEncoderDataListener;
        uGCVideoEncodeController.mEncoderStats = a.ENCODING;
    }

    public static /* synthetic */ void lambda$stop$1(UGCVideoEncodeController uGCVideoEncodeController) {
        uGCVideoEncodeController.mSessionStates.clear();
        uGCVideoEncodeController.mHasEncoderError.set(false);
        uGCVideoEncodeController.mFrameDeliverToEncoderTimeMap.clear();
        uGCVideoEncodeController.mUGCEncoderControllerListener = null;
        uGCVideoEncodeController.mEncodeParams = null;
        uGCVideoEncodeController.mHasEncodeFailureNotified = false;
        uGCVideoEncodeController.mEncoderStats = a.STOPED;
        uGCVideoEncodeController.mPendingEncodeFrameQueue.evictAll();
        uGCVideoEncodeController.destroyEncoder();
    }

    private void notifyEncodedFail() {
        if (!this.mHasEncodeFailureNotified) {
            VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener = this.mUGCEncoderControllerListener;
            if (videoEncoderDataListener != null) {
                videoEncoderDataListener.onEncodedFail();
            }
            this.mHasEncodeFailureNotified = true;
        }
    }

    /* access modifiers changed from: private */
    public void removeEarlierFrameFromFrameDeliverToEncoderTimeMap(long j11) {
        Iterator<Map.Entry<Long, Long>> it2 = this.mFrameDeliverToEncoderTimeMap.entrySet().iterator();
        while (it2.hasNext()) {
            if (((Long) it2.next().getKey()).longValue() <= j11) {
                it2.remove();
            }
        }
    }

    public void encodeFrame(PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            if (pixelFrame.getGLContext() != null) {
                GLES20.glFinish();
            }
            this.mPendingEncodeFrameQueue.push(pixelFrame);
            this.mSequenceTaskRunner.a(ab.a(this));
        }
    }

    public void signalEndOfStream() {
        LiteavLog.i(this.mThrottlers.a("signalEndOfStream"), this.mTag, "signalEndOfStream", new Object[0]);
        this.mPendingEncodeFrameQueue.push(EOS_FRAME);
        this.mSequenceTaskRunner.a(ac.a(this));
    }

    public void start(VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        LiteavLog.i(this.mThrottlers.a("start"), this.mTag, "start", new Object[0]);
        this.mSequenceTaskRunner.a(z.a(this, videoEncodeParams, videoEncoderDataListener));
    }

    public void stop() {
        LiteavLog.i(this.mThrottlers.a("stop"), this.mTag, "stop", new Object[0]);
        this.mSequenceTaskRunner.a(aa.a(this));
    }
}
