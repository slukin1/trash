package com.tencent.ugc.decoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.w;
import com.tencent.ugc.GlobalContextManager;
import com.tencent.ugc.UGCFrameQueue;
import com.tencent.ugc.decoder.HardwareVideoDecoder;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.videobase.frame.PixelFrame;
import java.util.concurrent.atomic.AtomicBoolean;

public class UGCVideoDecodeController {
    private static final int INTERVAL_DRAIN_DECODED_FRAME = 15;
    private static final int MAX_CACHE_FRAME_COUNT = 1;
    private static final int MAX_DECODE_FRAME_FAIL_COUNT = 30;
    private static final int MAX_DECODING_FRAME_COUNT = 30;
    private static final int MAX_DECODING_FRAME_TIME = 2500;
    private GLConstants.ColorRange mColorRange = GLConstants.ColorRange.UNKNOWN;
    private GLConstants.ColorSpace mColorSpace = GLConstants.ColorSpace.UNKNOWN;
    private w mDecodeTimer;
    private VideoDecoderInterface mDecoder;
    /* access modifiers changed from: private */
    public a mDecoderListener;
    private int mDecodingFrameCount = 0;
    /* access modifiers changed from: private */
    public final AtomicBoolean mHasDecodeError;
    private long mInputFramePts = 0;
    private boolean mIsRedecodingFromBeginOfThisGop = false;
    private boolean mIsUsingHardwareDecoder = true;
    private Long mLastOutputFramePts = null;
    /* access modifiers changed from: private */
    public UGCVideoDecodeControllerListener mListener;
    private long mOutputFramePts = 0;
    private final UGCFrameQueue<EncodedVideoFrame> mPendingFrameQueue;
    private int mSendFrameFailCount = 0;
    /* access modifiers changed from: private */
    public final String mTAG;
    /* access modifiers changed from: private */
    public final b mThrottlers;
    private final UGCFrameQueue.UGCFrameQueueListener mUGCFrameQueueListener;
    private CustomHandler mWorkHandler;

    public class a extends VideoDecoderListener {
        private a() {
        }

        public static /* synthetic */ void a(a aVar, PixelFrame pixelFrame) {
            UGCVideoDecodeController.this.onDecodeFrameInternal(pixelFrame);
            pixelFrame.release();
        }

        public final void onAbandonDecodingFramesCompleted() {
            if (this == UGCVideoDecodeController.this.mDecoderListener) {
                UGCVideoDecodeController uGCVideoDecodeController = UGCVideoDecodeController.this;
                boolean unused = uGCVideoDecodeController.runOnWorkThread(s.a(uGCVideoDecodeController));
            }
        }

        public final void onDecodeCompleted() {
            if (this == UGCVideoDecodeController.this.mDecoderListener) {
                UGCVideoDecodeController uGCVideoDecodeController = UGCVideoDecodeController.this;
                boolean unused = uGCVideoDecodeController.runOnWorkThread(t.a(uGCVideoDecodeController));
            }
        }

        public final void onDecodeFailed() {
            if (this == UGCVideoDecodeController.this.mDecoderListener) {
                LiteavLog.i(UGCVideoDecodeController.this.mThrottlers.a("onDecodeFailed"), UGCVideoDecodeController.this.mTAG, "onDecodeFailed", new Object[0]);
                UGCVideoDecodeController.this.mHasDecodeError.set(true);
            }
        }

        public final void onDecodeFrame(PixelFrame pixelFrame, long j11) {
            if (this == UGCVideoDecodeController.this.mDecoderListener && pixelFrame != null) {
                pixelFrame.retain();
                boolean unused = UGCVideoDecodeController.this.runOnWorkThread(r.a(this, pixelFrame));
            }
        }

        public /* synthetic */ a(UGCVideoDecodeController uGCVideoDecodeController, byte b11) {
            this();
        }
    }

    public UGCVideoDecodeController() {
        AnonymousClass1 r12 = new UGCFrameQueue.UGCFrameQueueListener() {
            public static /* synthetic */ void a(AnonymousClass1 r12) {
                if (UGCVideoDecodeController.this.mListener != null) {
                    UGCVideoDecodeController.this.mListener.onFrameEnqueuedToDecoder();
                }
            }

            public final void onFrameDequeued() {
                boolean unused = UGCVideoDecodeController.this.runOnWorkThread(q.a(this));
            }
        };
        this.mUGCFrameQueueListener = r12;
        this.mTAG = "UGCVideoDecodeController_" + hashCode();
        this.mThrottlers = new b();
        this.mHasDecodeError = new AtomicBoolean(false);
        UGCFrameQueue<EncodedVideoFrame> uGCFrameQueue = new UGCFrameQueue<>();
        this.mPendingFrameQueue = uGCFrameQueue;
        uGCFrameQueue.setUGCFrameQueueListener(r12);
    }

    private void clearFrameQueue() {
        for (EncodedVideoFrame next : this.mPendingFrameQueue.dequeueAll()) {
            if (next != null) {
                next.release();
            }
        }
    }

    private boolean createDecoder(boolean z11) {
        EncodedVideoFrame iDRFrameFromQueue = getIDRFrameFromQueue();
        if (iDRFrameFromQueue == null) {
            return false;
        }
        if (z11) {
            this.mDecoder = createHardwareDecoder(iDRFrameFromQueue);
        } else {
            this.mDecoder = new SoftwareVideoDecoder(iDRFrameFromQueue.isH265());
        }
        this.mDecoder.initialize();
        this.mDecoderListener = new a(this, (byte) 0);
        this.mDecoder.start(GlobalContextManager.getInstance().getGLContext(), this.mDecoderListener);
        this.mDecoder.decode(iDRFrameFromQueue);
        return true;
    }

    private VideoDecoderInterface createHardwareDecoder(EncodedVideoFrame encodedVideoFrame) {
        HardwareVideoDecoder.HardwareVideoDecoderParams hardwareVideoDecoderParams = new HardwareVideoDecoder.HardwareVideoDecoderParams();
        hardwareVideoDecoderParams.useOutputBuffer = this.mColorSpace == GLConstants.ColorSpace.BT709;
        MediaFormat mediaFormat = encodedVideoFrame.videoFormat;
        if (mediaFormat != null) {
            hardwareVideoDecoderParams.mediaFormat = mediaFormat;
        } else {
            hardwareVideoDecoderParams.useHevc = encodedVideoFrame.isH265();
            hardwareVideoDecoderParams.resolution = new Size(encodedVideoFrame.width, encodedVideoFrame.height);
        }
        return new HardwareVideoDecoder(hardwareVideoDecoderParams, (MediaCodec) null);
    }

    /* access modifiers changed from: private */
    public void decodeInternal() {
        handleDecoderError();
        if (this.mDecoder != null || createDecoder(this.mIsUsingHardwareDecoder)) {
            EncodedVideoFrame peek = this.mPendingFrameQueue.peek();
            if (peek == null) {
                this.mDecoder.decode((EncodedVideoFrame) null);
            } else if (this.mDecoder.decode(peek)) {
                this.mDecodingFrameCount++;
                this.mInputFramePts = peek.pts;
                this.mSendFrameFailCount = 0;
                this.mPendingFrameQueue.dequeue();
            } else {
                this.mSendFrameFailCount++;
            }
        }
    }

    private void destroyDecoder() {
        VideoDecoderInterface videoDecoderInterface = this.mDecoder;
        if (videoDecoderInterface != null) {
            videoDecoderInterface.stop();
            this.mDecoder.uninitialize();
            this.mDecoder = null;
            this.mDecoderListener = null;
        }
    }

    private EncodedVideoFrame getIDRFrameFromQueue() {
        while (this.mPendingFrameQueue.size() != 0) {
            EncodedVideoFrame dequeue = this.mPendingFrameQueue.dequeue();
            if (dequeue != null) {
                if (dequeue.isIDRFrame()) {
                    return dequeue;
                }
                dequeue.release();
            }
        }
        return null;
    }

    private void handleDecoderError() {
        long j11;
        if (isDecoderError()) {
            if (this.mIsUsingHardwareDecoder) {
                LiteavLog.i(this.mThrottlers.a("handleDecoderError"), this.mTAG, "handle Hardware Decoder Error", new Object[0]);
                this.mIsUsingHardwareDecoder = false;
                this.mIsRedecodingFromBeginOfThisGop = true;
                destroyDecoder();
                clearFrameQueue();
                UGCVideoDecodeControllerListener uGCVideoDecodeControllerListener = this.mListener;
                if (uGCVideoDecodeControllerListener != null) {
                    Long l11 = this.mLastOutputFramePts;
                    if (l11 == null) {
                        j11 = 0;
                    } else {
                        j11 = l11.longValue();
                    }
                    uGCVideoDecodeControllerListener.onRequestSeekToLastKeyFrame(j11);
                }
            } else {
                LiteavLog.i(this.mThrottlers.a("handleDecoderError"), this.mTAG, "notify DecodeFailed", new Object[0]);
                UGCVideoDecodeControllerListener uGCVideoDecodeControllerListener2 = this.mListener;
                if (uGCVideoDecodeControllerListener2 != null) {
                    uGCVideoDecodeControllerListener2.onDecodeFailed();
                }
            }
            this.mHasDecodeError.set(false);
            this.mSendFrameFailCount = 0;
            this.mDecodingFrameCount = 0;
            this.mInputFramePts = 0;
            this.mOutputFramePts = 0;
        }
    }

    private boolean isDecoderError() {
        if (this.mHasDecodeError.get()) {
            LiteavLog.e(this.mThrottlers.a("isDecoderError"), this.mTAG, "mIsDecodeError is true", new Object[0]);
            return true;
        } else if (this.mSendFrameFailCount > 30) {
            com.tencent.liteav.base.b.a a11 = this.mThrottlers.a("isDecoderError");
            String str = this.mTAG;
            LiteavLog.e(a11, str, "mSendFrameFailCount = " + this.mSendFrameFailCount, new Object[0]);
            return true;
        } else if (this.mDecodingFrameCount <= 30 || this.mInputFramePts - this.mOutputFramePts <= 2500) {
            return false;
        } else {
            LiteavLog.e(this.mThrottlers.a("isDecoderError"), this.mTAG, "internal decoder cache too big", new Object[0]);
            return true;
        }
    }

    public static /* synthetic */ void lambda$abandonDecodingFrames$2(UGCVideoDecodeController uGCVideoDecodeController) {
        uGCVideoDecodeController.clearFrameQueue();
        uGCVideoDecodeController.mIsRedecodingFromBeginOfThisGop = false;
        uGCVideoDecodeController.mDecodingFrameCount = 0;
        uGCVideoDecodeController.mInputFramePts = 0;
        uGCVideoDecodeController.mOutputFramePts = 0;
        VideoDecoderInterface videoDecoderInterface = uGCVideoDecodeController.mDecoder;
        if (videoDecoderInterface != null) {
            videoDecoderInterface.abandonDecodingFrames();
        } else {
            uGCVideoDecodeController.notifyAbandonDecodingFramesCompleted();
        }
    }

    public static /* synthetic */ void lambda$decode$1(UGCVideoDecodeController uGCVideoDecodeController, EncodedVideoFrame encodedVideoFrame) {
        if (uGCVideoDecodeController.mLastOutputFramePts == null) {
            uGCVideoDecodeController.mLastOutputFramePts = Long.valueOf(encodedVideoFrame.pts - 1);
        }
        uGCVideoDecodeController.mSendFrameFailCount = 0;
        uGCVideoDecodeController.decodeInternal();
    }

    public static /* synthetic */ void lambda$signalEndOfStream$3(UGCVideoDecodeController uGCVideoDecodeController) {
        if (uGCVideoDecodeController.mDecoder != null) {
            EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
            encodedVideoFrame.isEosFrame = true;
            uGCVideoDecodeController.mPendingFrameQueue.queue(encodedVideoFrame);
            return;
        }
        uGCVideoDecodeController.notifyDecodeCompleted();
    }

    /* access modifiers changed from: private */
    public void notifyAbandonDecodingFramesCompleted() {
        LiteavLog.i(this.mThrottlers.a("onAbandonCompleted"), this.mTAG, "onAbandonDecodingFramesCompleted", new Object[0]);
        UGCVideoDecodeControllerListener uGCVideoDecodeControllerListener = this.mListener;
        if (uGCVideoDecodeControllerListener != null) {
            uGCVideoDecodeControllerListener.onAbandonDecodingFramesCompleted();
        }
    }

    /* access modifiers changed from: private */
    public void notifyDecodeCompleted() {
        LiteavLog.i(this.mThrottlers.a("onDecodeCompleted"), this.mTAG, "onDecodeCompleted", new Object[0]);
        UGCVideoDecodeControllerListener uGCVideoDecodeControllerListener = this.mListener;
        if (uGCVideoDecodeControllerListener != null) {
            uGCVideoDecodeControllerListener.onDecodeCompleted();
        }
    }

    /* access modifiers changed from: private */
    public void onDecodeFrameInternal(PixelFrame pixelFrame) {
        this.mDecodingFrameCount--;
        pixelFrame.setColorFormat(this.mColorRange, this.mColorSpace);
        this.mOutputFramePts = pixelFrame.getTimestamp();
        Long l11 = this.mLastOutputFramePts;
        long longValue = l11 == null ? 0 : l11.longValue();
        if (!this.mIsRedecodingFromBeginOfThisGop || pixelFrame.getTimestamp() > longValue) {
            UGCVideoDecodeControllerListener uGCVideoDecodeControllerListener = this.mListener;
            if (uGCVideoDecodeControllerListener != null) {
                uGCVideoDecodeControllerListener.onFrameDecoded(pixelFrame);
            }
            this.mLastOutputFramePts = Long.valueOf(pixelFrame.getTimestamp());
            this.mIsRedecodingFromBeginOfThisGop = false;
        }
        decodeInternal();
    }

    private void parserColorFormatInfo(EncodedVideoFrame encodedVideoFrame) {
        Integer num;
        SpsInfo nativeDecodeSps = SpsInfo.nativeDecodeSps(encodedVideoFrame.isH265(), encodedVideoFrame.data);
        if (nativeDecodeSps != null) {
            LiteavLog.i(this.mTAG, " sps info is ".concat(String.valueOf(nativeDecodeSps)));
            this.mColorRange = GLConstants.ColorRange.VIDEO_RANGE;
            Integer num2 = nativeDecodeSps.videoFullRangeFlag;
            if (num2 != null && num2.intValue() == 1) {
                this.mColorRange = GLConstants.ColorRange.FULL_RANGE;
            }
            this.mColorSpace = GLConstants.ColorSpace.BT709;
            Integer num3 = nativeDecodeSps.colourPrimaries;
            if (num3 != null && num3.intValue() != 1 && (num = nativeDecodeSps.transferCharacteristics) != null && num.intValue() != 1) {
                this.mColorSpace = GLConstants.ColorSpace.BT601;
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean runOnWorkThread(Runnable runnable) {
        CustomHandler customHandler = this.mWorkHandler;
        return customHandler != null && customHandler.runOrPost(runnable);
    }

    /* access modifiers changed from: private */
    public void stopInternal() {
        LiteavLog.i(this.mThrottlers.a("stopInternal"), this.mTAG, "stopInternal", new Object[0]);
        this.mIsUsingHardwareDecoder = true;
        this.mIsRedecodingFromBeginOfThisGop = false;
        this.mListener = null;
        this.mLastOutputFramePts = null;
        this.mHasDecodeError.set(false);
        this.mDecodingFrameCount = 0;
        this.mSendFrameFailCount = 0;
        this.mInputFramePts = 0;
        this.mOutputFramePts = 0;
        destroyDecoder();
        clearFrameQueue();
        w wVar = this.mDecodeTimer;
        if (wVar != null) {
            wVar.a();
            this.mDecodeTimer = null;
        }
    }

    public void abandonDecodingFrames() {
        LiteavLog.i(this.mThrottlers.a("abandonFrames"), this.mTAG, "abandonDecodingFrames", new Object[0]);
        runOnWorkThread(o.a(this));
    }

    public void decode(EncodedVideoFrame encodedVideoFrame) {
        if (encodedVideoFrame != null) {
            this.mPendingFrameQueue.queue(encodedVideoFrame);
            runOnWorkThread(n.a(this, encodedVideoFrame));
        }
    }

    public boolean isInputQueueFull() {
        return this.mPendingFrameQueue.size() > 0;
    }

    public void signalEndOfStream() {
        LiteavLog.i(this.mThrottlers.a("signalEndOfStream"), this.mTAG, "signalEndOfStream", new Object[0]);
        runOnWorkThread(p.a(this));
    }

    public void start(UGCVideoDecodeControllerListener uGCVideoDecodeControllerListener) {
        LiteavLog.i(this.mThrottlers.a("start"), this.mTAG, "start", new Object[0]);
        synchronized (this) {
            if (this.mWorkHandler != null) {
                LiteavLog.w(this.mThrottlers.a("startWorkHandler"), this.mTAG, "UGCDecodeController is start", new Object[0]);
                return;
            }
            HandlerThread handlerThread = new HandlerThread("ugc-decoder-controller");
            handlerThread.start();
            this.mWorkHandler = new CustomHandler(handlerThread.getLooper());
            w wVar = new w(this.mWorkHandler.getLooper(), new k(this));
            this.mDecodeTimer = wVar;
            wVar.a(15);
            runOnWorkThread(l.a(this, uGCVideoDecodeControllerListener));
        }
    }

    public void stop() {
        LiteavLog.i(this.mThrottlers.a("stop"), this.mTAG, "stop", new Object[0]);
        runOnWorkThread(m.a(this));
        synchronized (this) {
            CustomHandler customHandler = this.mWorkHandler;
            if (customHandler != null) {
                customHandler.quitLooperAndWaitDone();
                this.mWorkHandler = null;
            }
        }
    }
}
