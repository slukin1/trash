package com.tencent.ugc;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.TXVideoEditer;
import com.tencent.ugc.UGCAVSyncer;
import com.tencent.ugc.datereport.UGCDataReport;
import com.tencent.ugc.encoder.UGCVideoEncodeController;
import com.tencent.ugc.encoder.VideoEncodeParams;
import com.tencent.ugc.encoder.VideoEncoderDef;
import com.tencent.ugc.preprocessor.VideoPreprocessorListener;
import com.tencent.ugc.renderer.VideoRenderListener;
import com.tencent.ugc.renderer.VideoRenderer;
import com.tencent.ugc.videobase.base.DetectResult;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.videobase.egl.EGLCore;
import com.tencent.ugc.videobase.egl.EGLException;
import com.tencent.ugc.videobase.frame.FrameMetaData;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.frame.PixelFrameRenderer;
import com.tencent.ugc.videoprocessor.SpeedProcessor;
import com.tencent.ugc.videoprocessor.VideoEffectProcessor;
import com.tencent.ugc.videoprocessor.VideoProcessManager;
import com.tencent.ugc.videoprocessor.VideoTransitionProcessor;
import com.tencent.ugc.videoprocessor.WatermarkProcessor;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class UGCVideoProcessor {
    private static final int MSG_FORCE_PROCESS = 105;
    private static final int MSG_PAUSE = 102;
    private static final int MSG_PROCESS_FROM_SOURCE = 101;
    private static final int MSG_REFRESH = 104;
    private static final int MSG_START = 100;
    private static final int MSG_STOP = 103;
    private final int MAX_SKIP_FRAME_COUNT = 3;
    private final long MIN_SEEK_DIR = 100;
    private Object mCurEGLContext = null;
    private int mCurEGLHeight = -1;
    private int mCurEGLWidth = -1;
    private DisplayTarget mDisplayTarget;
    private EGLCore mEGLCore;
    /* access modifiers changed from: private */
    public long mFinalPts = -1;
    private GLTexturePool mGLTexturePool;
    private boolean mHasFirstFrameProcessed = false;
    private boolean mInvalidate;
    private boolean mIsInit = false;
    private boolean mIsRecord = false;
    private long mLastProcessFramePts = -1;
    private PixelFrame mLastRenderFrame;
    private int mOutputHeight = -1;
    private int mOutputWidth = -1;
    private PixelFrameRenderer mPreScaleRenderer;
    private List<TXVideoEditConstants.TXAbsoluteRect> mRectList;
    private HandlerThread mRenderThread;
    private VideoRenderer mRenderer;
    private boolean mReverse = false;
    /* access modifiers changed from: private */
    public k mRotation = k.NORMAL;
    private GLConstants.GLScaleType mScaleType = GLConstants.GLScaleType.FIT_CENTER;
    private int mSkipFrameCount = 0;
    private SpeedProcessor mSpeedProcessor;
    private a mStatus;
    /* access modifiers changed from: private */
    public TXVideoEditer.TXVideoCustomProcessListener mTXVideoCustomProcessListener;
    /* access modifiers changed from: private */
    public final String mTag = ("UGCVideoProcessor_" + hashCode());
    private AtomicReference<Long> mTargetSeekPts = new AtomicReference<>();
    private final com.tencent.liteav.base.b.b mThrottlers = new com.tencent.liteav.base.b.b();
    /* access modifiers changed from: private */
    public int mTransitionType = -1;
    private final UGCAVSyncer mUGCAVSyncer;
    private UGCCombineProcessor mUGCCombineProcessor;
    private UGCMediaListSource mUGCMediaListSource;
    private UGCTransitionProcessor mUGCTransitionProcessor;
    /* access modifiers changed from: private */
    public VideoEncoderDef.EncoderType mUsingEncoderType = VideoEncoderDef.EncoderType.HARDWARE;
    private UGCVideoEncodeController mVideoEncodeController;
    /* access modifiers changed from: private */
    public VideoEncodeParams mVideoEncodeParams;
    /* access modifiers changed from: private */
    public VideoEncodedFrameListener mVideoEncodedFrameListener;
    /* access modifiers changed from: private */
    public VideoEncoderDef.VideoEncoderDataListener mVideoEncoderDataListener;
    private VideoPreprocessorListener mVideoPreprocessorListener = new VideoPreprocessorListener() {
        public static /* synthetic */ void a(AnonymousClass2 r02, PixelFrame pixelFrame) {
            UGCVideoProcessor.this.mVideoProcessManager.processByVideoEffect(pixelFrame);
            pixelFrame.release();
        }

        public final void didDetectFacePoints(int i11, DetectResult detectResult) {
        }

        public final void didProcessFrame(int i11, PixelFrame pixelFrame) {
            if (!UGCVideoProcessor.this.filtInvalidatedFrame(pixelFrame.getTimestamp())) {
                pixelFrame.retain();
                if (pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D || pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
                    GLES20.glFinish();
                }
                if (!UGCVideoProcessor.this.runOnVideoProcessHandler(hh.a(this, pixelFrame))) {
                    pixelFrame.release();
                }
            }
        }
    };
    private CustomHandler mVideoProcessHandler;
    /* access modifiers changed from: private */
    public VideoProcessListener mVideoProcessListener;
    /* access modifiers changed from: private */
    public final VideoProcessManager mVideoProcessManager;
    /* access modifiers changed from: private */
    public c mVideoProcessManagerListener;
    private final VideoRenderListener mVideoRenderListener = new VideoRenderListener() {
        public final void onRenderTargetSizeChanged(int i11, int i12) {
            String access$000 = UGCVideoProcessor.this.mTag;
            LiteavLog.i(access$000, "onRenderSizeChange " + i11 + Constants.ACCEPT_TIME_SEPARATOR_SP + i12);
            boolean unused = UGCVideoProcessor.this.runOnVideoProcessHandler(hg.a(this, i11, i12));
        }
    };
    private Runnable onCompleteBroadcastRunnable = gn.a(this);

    public interface VideoEncodedFrameListener {
        void onEncodedFail(VideoEncoderDef.EncoderType encoderType);

        void onVideoEncodeStarted();

        void onVideoEncodingCompleted();

        void onVideoFrameEncoded(EncodedVideoFrame encodedVideoFrame);
    }

    public interface VideoProcessListener {
        void onComplete(TXVideoEditConstants.TXGenerateResult tXGenerateResult);

        void onProgress(long j11);
    }

    public enum a {
        STOPPED,
        STARTED,
        PAUSED
    }

    public class b extends VideoEncoderDef.VideoEncoderDataListener {
        private b() {
        }

        public static /* synthetic */ void a(b bVar, EncodedVideoFrame encodedVideoFrame, boolean z11) {
            if (bVar == UGCVideoProcessor.this.mVideoEncoderDataListener && UGCVideoProcessor.this.mVideoEncodedFrameListener != null) {
                if (encodedVideoFrame != null) {
                    UGCVideoProcessor.this.mVideoEncodedFrameListener.onVideoFrameEncoded(encodedVideoFrame);
                    if ((encodedVideoFrame.pts >= UGCVideoProcessor.this.mFinalPts && UGCVideoProcessor.this.mFinalPts != -1) || z11) {
                        UGCVideoProcessor.this.mVideoEncodedFrameListener.onVideoEncodingCompleted();
                        UGCVideoProcessor.this.stopEncoder();
                        return;
                    }
                    return;
                }
                UGCVideoProcessor.this.mVideoEncodedFrameListener.onVideoEncodingCompleted();
                UGCVideoProcessor.this.stopEncoder();
            }
        }

        public final void onEncodedFail() {
            LiteavLog.e(UGCVideoProcessor.this.mTag, "encoded fail.");
            boolean unused = UGCVideoProcessor.this.runOnVideoProcessHandler(hj.a(this));
        }

        public final void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z11) {
            boolean unused = UGCVideoProcessor.this.runOnVideoProcessHandler(hi.a(this, encodedVideoFrame, z11));
        }

        public final void onOutputFormatChanged(MediaFormat mediaFormat) {
            LiteavLog.i(UGCVideoProcessor.this.mTag, "onOutputFormatChanged: ".concat(String.valueOf(mediaFormat)));
        }

        public /* synthetic */ b(UGCVideoProcessor uGCVideoProcessor, byte b11) {
            this();
        }

        public static /* synthetic */ void a(b bVar) {
            if (bVar == UGCVideoProcessor.this.mVideoEncoderDataListener && UGCVideoProcessor.this.mVideoEncodedFrameListener != null) {
                UGCVideoProcessor.this.mVideoEncodedFrameListener.onEncodedFail(UGCVideoProcessor.this.mUsingEncoderType);
            }
        }
    }

    public class c implements VideoProcessManager.IVideoProcessManagerListener {
        private c() {
        }

        public static /* synthetic */ void a(c cVar, PixelFrame pixelFrame) {
            UGCVideoProcessor.this.handleProcessFrame(pixelFrame);
            pixelFrame.release();
        }

        public final int customProcessFrame(PixelFrame pixelFrame) {
            if (this != UGCVideoProcessor.this.mVideoProcessManagerListener || UGCVideoProcessor.this.mTXVideoCustomProcessListener == null || pixelFrame == null) {
                return -1;
            }
            if (pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D || pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
                GLES20.glFinish();
            }
            return UGCVideoProcessor.this.mTXVideoCustomProcessListener.onTextureCustomProcess(pixelFrame.getTextureId(), pixelFrame.getWidth(), pixelFrame.getHeight(), pixelFrame.getTimestamp());
        }

        public final void didProcessFrame(PixelFrame pixelFrame) {
            if (this == UGCVideoProcessor.this.mVideoProcessManagerListener && !UGCVideoProcessor.this.filtInvalidatedFrame(pixelFrame.getTimestamp())) {
                pixelFrame.retain();
                if (pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D || pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
                    GLES20.glFinish();
                }
                if (!UGCVideoProcessor.this.runOnVideoProcessHandler(hk.a(this, pixelFrame))) {
                    pixelFrame.release();
                }
            }
        }

        public /* synthetic */ c(UGCVideoProcessor uGCVideoProcessor, byte b11) {
            this();
        }
    }

    public UGCVideoProcessor(Context context, UGCMediaListSource uGCMediaListSource, UGCAVSyncer uGCAVSyncer, boolean z11) {
        this.mUGCMediaListSource = uGCMediaListSource;
        this.mUGCAVSyncer = uGCAVSyncer;
        this.mVideoProcessManager = new VideoProcessManager(context, z11);
    }

    /* access modifiers changed from: private */
    public boolean filtInvalidatedFrame(long j11) {
        if (this.mReverse) {
            j11 = Math.abs(this.mUGCMediaListSource.getDuration() - j11);
        }
        long min = Math.min(this.mUGCMediaListSource.getDuration(), j11);
        if (this.mTargetSeekPts.get() == null || Math.abs(min - this.mTargetSeekPts.get().longValue()) <= 100) {
            return false;
        }
        String str = this.mTag;
        LiteavLog.i(str, "filtInvalidatedFrame: framePts:" + min + "  mTargetSeekPts:" + this.mTargetSeekPts + "  d :" + Math.abs(min - this.mTargetSeekPts.get().longValue()));
        return true;
    }

    /* access modifiers changed from: private */
    public boolean handleMessage(Message message) {
        PixelFrame pixelFrame;
        switch (message.what) {
            case 100:
                this.mStatus = a.STARTED;
                if (!this.mIsRecord) {
                    initRenderer();
                    break;
                } else {
                    initEncoder();
                    break;
                }
            case 101:
                break;
            case 102:
                this.mStatus = a.PAUSED;
                break;
            case 103:
                this.mStatus = a.STOPPED;
                break;
            case 104:
                if (!(this.mStatus == a.STARTED || (pixelFrame = this.mLastRenderFrame) == null)) {
                    this.mVideoProcessManager.processFrame(pixelFrame);
                    break;
                }
            case 105:
                LiteavLog.i(this.mTag, "handleMessage: MSG_FORCE_PROCESS");
                removeMsgFromVideoProcessHandler(105);
                this.mInvalidate = true;
                break;
        }
        if (this.mStatus == a.STARTED || this.mInvalidate) {
            processFrame();
            this.mInvalidate = false;
            return true;
        }
        String str = this.mTag;
        LiteavLog.e(str, "MSG_PROCESS_FROM_SOURCE FAILD AS mStatus == " + this.mStatus);
        return true;
    }

    /* access modifiers changed from: private */
    public void handleProcessFrame(PixelFrame pixelFrame) {
        UGCVideoEncodeController uGCVideoEncodeController;
        VideoRenderer videoRenderer;
        if (!filtInvalidatedFrame(pixelFrame.getTimestamp())) {
            this.mTargetSeekPts.set((Object) null);
            VideoProcessListener videoProcessListener = this.mVideoProcessListener;
            if (videoProcessListener != null) {
                videoProcessListener.onProgress(pixelFrame.getTimestamp());
            }
            this.mLastProcessFramePts = pixelFrame.getTimestamp();
            FrameMetaData frameMetaData = new FrameMetaData();
            frameMetaData.setEncodeRotation(this.mRotation);
            frameMetaData.setRenderRotation(this.mRotation);
            pixelFrame.setMetaData(frameMetaData);
            if (!this.mIsRecord && (videoRenderer = this.mRenderer) != null) {
                videoRenderer.renderFrame(pixelFrame);
            }
            if (!this.mIsRecord || (uGCVideoEncodeController = this.mVideoEncodeController) == null) {
                long j11 = this.mFinalPts;
                if (j11 > 0 && this.mLastProcessFramePts >= j11) {
                    notifyPreviewComplete();
                }
            } else {
                uGCVideoEncodeController.encodeFrame(pixelFrame);
                long j12 = this.mFinalPts;
                if (j12 > 0 && this.mLastProcessFramePts >= j12) {
                    LiteavLog.i(this.mTag, "processFrameFromSource: signalEndOfStream");
                    this.mVideoEncodeController.signalEndOfStream();
                    return;
                }
            }
            if (this.mStatus == a.STARTED) {
                sendMsgToVideoProcessHandler(101);
            }
        }
    }

    private void initEncoder() {
        LiteavLog.i(this.mTag, "init encoder");
        if (this.mVideoEncodeParams == null) {
            LiteavLog.e(this.mTag, "video encode params is null");
            return;
        }
        UGCVideoEncodeController uGCVideoEncodeController = this.mVideoEncodeController;
        if (uGCVideoEncodeController != null) {
            uGCVideoEncodeController.stop();
        }
        this.mVideoEncodeController = new UGCVideoEncodeController(this.mUsingEncoderType);
        b bVar = new b(this, (byte) 0);
        this.mVideoEncoderDataListener = bVar;
        this.mVideoEncodeController.start(this.mVideoEncodeParams, bVar);
        VideoEncodedFrameListener videoEncodedFrameListener = this.mVideoEncodedFrameListener;
        if (videoEncodedFrameListener != null) {
            videoEncodedFrameListener.onVideoEncodeStarted();
        }
        this.mFinalPts = -1;
    }

    private void initProcessChain(int i11, int i12) {
        String str = this.mTag;
        LiteavLog.i(str, "init process chain:  width:" + i11 + " height:" + i12);
        if (this.mEGLCore != null) {
            this.mVideoProcessManager.initFilter(this.mGLTexturePool, i11, i12, this.mVideoPreprocessorListener);
            this.mUGCTransitionProcessor = new UGCTransitionProcessor(i11, i12, this.mGLTexturePool);
            this.mUGCCombineProcessor = new UGCCombineProcessor(i11, i12, this.mGLTexturePool);
        }
    }

    private void initRenderer() {
        if (this.mRenderer == null) {
            if (this.mRenderThread == null) {
                HandlerThread handlerThread = new HandlerThread("VideoProcessRender" + hashCode());
                this.mRenderThread = handlerThread;
                handlerThread.start();
            }
            VideoRenderer videoRenderer = new VideoRenderer(this.mRenderThread.getLooper());
            this.mRenderer = videoRenderer;
            DisplayTarget displayTarget = this.mDisplayTarget;
            if (displayTarget != null) {
                videoRenderer.setDisplayView(displayTarget, true);
                this.mRenderer.setScaleType(this.mScaleType);
            }
            this.mRenderer.start(this.mVideoRenderListener);
        }
    }

    private void initializeEGL(Object obj, int i11, int i12) {
        try {
            EGLCore eGLCore = new EGLCore();
            this.mEGLCore = eGLCore;
            eGLCore.initialize(obj, (Surface) null, i11, i12);
            this.mEGLCore.makeCurrent();
            this.mCurEGLContext = obj;
            this.mCurEGLWidth = i11;
            this.mCurEGLHeight = i12;
            this.mGLTexturePool = new GLTexturePool();
        } catch (EGLException e11) {
            this.mEGLCore = null;
            LiteavLog.e(this.mThrottlers.a("initGL"), this.mTag, e11.getMessage(), new Object[0]);
        }
    }

    private boolean isNeedReCreateEGL(Object obj, int i11, int i12) {
        Object obj2 = this.mCurEGLContext;
        if (obj2 == null || i11 < 0 || i12 < 0) {
            return false;
        }
        if (obj.equals(obj2) && this.mCurEGLWidth == i11 && this.mCurEGLHeight == i12) {
            return false;
        }
        LiteavLog.i(this.mThrottlers.a("recreateGL"), this.mTag, "isNeedReCreateEGL: true", new Object[0]);
        return true;
    }

    public static /* synthetic */ void lambda$setDisplayView$4(UGCVideoProcessor uGCVideoProcessor, DisplayTarget displayTarget, GLConstants.GLScaleType gLScaleType) {
        uGCVideoProcessor.mDisplayTarget = displayTarget;
        if (gLScaleType != null) {
            uGCVideoProcessor.mScaleType = gLScaleType;
        }
        VideoRenderer videoRenderer = uGCVideoProcessor.mRenderer;
        if (videoRenderer != null) {
            videoRenderer.setDisplayView(displayTarget, true);
            uGCVideoProcessor.mRenderer.setScaleType(uGCVideoProcessor.mScaleType);
        }
        uGCVideoProcessor.mVideoProcessManager.setScaleType(uGCVideoProcessor.mScaleType);
    }

    public static /* synthetic */ void lambda$setOutputSize$3(UGCVideoProcessor uGCVideoProcessor, int i11, int i12, GLConstants.GLScaleType gLScaleType) {
        uGCVideoProcessor.mOutputWidth = i11;
        uGCVideoProcessor.mOutputHeight = i12;
        if (i11 > 0) {
            uGCVideoProcessor.mScaleType = gLScaleType;
        }
    }

    public static /* synthetic */ void lambda$setSpeedList$9(UGCVideoProcessor uGCVideoProcessor, List list) {
        if (uGCVideoProcessor.mSpeedProcessor == null) {
            uGCVideoProcessor.mSpeedProcessor = new SpeedProcessor();
        }
        LiteavLog.i(uGCVideoProcessor.mTag, "==== setSpeedList ==== ");
        if (list != null) {
            UGCDataReport.reportDAU(1019);
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < list.size(); i11++) {
                TXVideoEditConstants.TXSpeed tXSpeed = (TXVideoEditConstants.TXSpeed) list.get(i11);
                TXVideoEditConstants.TXSpeed tXSpeed2 = new TXVideoEditConstants.TXSpeed();
                tXSpeed2.speedLevel = tXSpeed.speedLevel;
                tXSpeed2.startTime = tXSpeed.startTime;
                tXSpeed2.endTime = tXSpeed.endTime;
                arrayList.add(tXSpeed2);
            }
            uGCVideoProcessor.mSpeedProcessor.setSpeedList(arrayList);
            return;
        }
        uGCVideoProcessor.mSpeedProcessor.setSpeedList((List<TXVideoEditConstants.TXSpeed>) null);
    }

    public static /* synthetic */ void lambda$setSplitScreenList$2(UGCVideoProcessor uGCVideoProcessor, List list, int i11, int i12) {
        uGCVideoProcessor.mRectList = list;
        uGCVideoProcessor.setOutputSize(i11, i12, GLConstants.GLScaleType.FIT_CENTER);
    }

    public static /* synthetic */ void lambda$start$1(UGCVideoProcessor uGCVideoProcessor, boolean z11, VideoEncoderDef.EncoderType encoderType) {
        uGCVideoProcessor.mIsRecord = z11;
        uGCVideoProcessor.mUsingEncoderType = encoderType;
        uGCVideoProcessor.mTargetSeekPts.set((Object) null);
        uGCVideoProcessor.mFinalPts = -1;
        uGCVideoProcessor.mSkipFrameCount = 0;
        uGCVideoProcessor.mHasFirstFrameProcessed = false;
        c cVar = new c(uGCVideoProcessor, (byte) 0);
        uGCVideoProcessor.mVideoProcessManagerListener = cVar;
        uGCVideoProcessor.mVideoProcessManager.setListener(cVar);
    }

    public static /* synthetic */ void lambda$unInitialize$0(UGCVideoProcessor uGCVideoProcessor) {
        uGCVideoProcessor.mFinalPts = -1;
        PixelFrame pixelFrame = uGCVideoProcessor.mLastRenderFrame;
        if (pixelFrame != null) {
            pixelFrame.release();
            uGCVideoProcessor.mLastRenderFrame = null;
        }
        VideoRenderer videoRenderer = uGCVideoProcessor.mRenderer;
        if (videoRenderer != null) {
            videoRenderer.stop(false);
            uGCVideoProcessor.mRenderer = null;
        }
        uGCVideoProcessor.stopEncoder();
        PixelFrameRenderer pixelFrameRenderer = uGCVideoProcessor.mPreScaleRenderer;
        if (pixelFrameRenderer != null) {
            pixelFrameRenderer.uninitialize();
            uGCVideoProcessor.mPreScaleRenderer = null;
        }
        uGCVideoProcessor.unInitVideoProcessor();
        uGCVideoProcessor.mVideoProcessManager.unInitialize();
        if (uGCVideoProcessor.mRenderThread != null) {
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
                uGCVideoProcessor.mRenderThread.quitSafely();
            } else {
                uGCVideoProcessor.mRenderThread.quit();
            }
            uGCVideoProcessor.mRenderThread = null;
        }
        uGCVideoProcessor.uninitializedEGL();
        synchronized (uGCVideoProcessor) {
            CustomHandler customHandler = uGCVideoProcessor.mVideoProcessHandler;
            if (customHandler != null) {
                customHandler.quitLooper();
                uGCVideoProcessor.mVideoProcessHandler = null;
            }
        }
    }

    private void notifyPreviewComplete() {
        CustomHandler customHandler = this.mVideoProcessHandler;
        if (customHandler != null) {
            customHandler.removeCallbacks(this.onCompleteBroadcastRunnable);
            customHandler.post(this.onCompleteBroadcastRunnable);
        }
    }

    /* access modifiers changed from: private */
    public void onCompleteBroadcast() {
        if (this.mVideoProcessListener != null) {
            TXVideoEditConstants.TXGenerateResult tXGenerateResult = new TXVideoEditConstants.TXGenerateResult();
            tXGenerateResult.retCode = 0;
            tXGenerateResult.descMsg = "";
            this.mVideoProcessListener.onComplete(tXGenerateResult);
        }
    }

    private PixelFrame preScale(PixelFrame pixelFrame) {
        int i11 = this.mOutputWidth;
        int i12 = this.mOutputHeight;
        k kVar = this.mRotation;
        if (kVar == k.ROTATION_90 || kVar == k.ROTATION_270) {
            int i13 = i12;
            i12 = i11;
            i11 = i13;
        }
        if (this.mEGLCore == null || i11 <= 0 || i12 <= 0 || (pixelFrame.getWidth() == i11 && pixelFrame.getHeight() == i12)) {
            pixelFrame.retain();
            return pixelFrame;
        }
        if (this.mPreScaleRenderer == null) {
            this.mPreScaleRenderer = new PixelFrameRenderer(i11, i12);
        }
        this.mPreScaleRenderer.setOutputSize(i11, i12);
        GLTexture obtain = this.mGLTexturePool.obtain(this.mOutputWidth, this.mOutputHeight);
        obtain.setColorFormat(pixelFrame.getColorRange(), pixelFrame.getColorSpace());
        this.mPreScaleRenderer.renderFrame(pixelFrame, this.mScaleType, obtain);
        PixelFrame wrap = obtain.wrap(pixelFrame.getGLContext());
        wrap.setTimestamp(pixelFrame.getTimestamp());
        obtain.release();
        return wrap;
    }

    private void processFrame() {
        UGCVideoEncodeController uGCVideoEncodeController;
        int i11;
        if (this.mIsInit) {
            List<PixelFrame> readNextVideoFrame = this.mUGCMediaListSource.readNextVideoFrame();
            if (readNextVideoFrame == null || readNextVideoFrame.size() <= 0) {
                PixelFrame pixelFrame = this.mLastRenderFrame;
                if (pixelFrame != null) {
                    this.mFinalPts = pixelFrame.getTimestamp();
                }
                String str = this.mTag;
                LiteavLog.i(str, "final frame pts = " + this.mFinalPts + "  last progressed frame pts = " + this.mLastProcessFramePts);
                if (this.mLastProcessFramePts >= this.mFinalPts) {
                    if (this.mIsRecord && (uGCVideoEncodeController = this.mVideoEncodeController) != null) {
                        uGCVideoEncodeController.signalEndOfStream();
                    }
                    if (!this.mIsRecord) {
                        notifyPreviewComplete();
                        return;
                    }
                    return;
                }
                return;
            }
            PixelFrame pixelFrame2 = readNextVideoFrame.get(0);
            int width = pixelFrame2.getWidth();
            int height = pixelFrame2.getHeight();
            int i12 = this.mOutputWidth;
            if (i12 > 0 && (i11 = this.mOutputHeight) > 0) {
                width = i12;
                height = i11;
            }
            if (isNeedReCreateEGL(pixelFrame2.getGLContext(), width, height)) {
                unInitVideoProcessor();
                uninitializedEGL();
            }
            if (this.mEGLCore == null) {
                initializeEGL(pixelFrame2.getGLContext(), width, height);
                initProcessChain(width, height);
            }
            if (this.mUGCCombineProcessor != null && this.mUGCTransitionProcessor != null) {
                long timestamp = pixelFrame2.getTimestamp();
                UGCAVSyncer.SkipMode skipMode = UGCAVSyncer.SkipMode.NOOP;
                if (this.mHasFirstFrameProcessed || this.mIsRecord) {
                    skipMode = this.mUGCAVSyncer.syncVideo(timestamp);
                }
                this.mHasFirstFrameProcessed = true;
                if (skipMode == UGCAVSyncer.SkipMode.SKIP_CURRENT_FRAME) {
                    int i13 = this.mSkipFrameCount + 1;
                    this.mSkipFrameCount = i13;
                    if (i13 < 3) {
                        for (PixelFrame release : readNextVideoFrame) {
                            release.release();
                        }
                        if (this.mStatus == a.STARTED) {
                            sendMsgToVideoProcessHandler(101);
                            return;
                        }
                        return;
                    }
                }
                this.mSkipFrameCount = 0;
                if (readNextVideoFrame.size() > 1) {
                    List<TXVideoEditConstants.TXAbsoluteRect> list = this.mRectList;
                    if (list != null) {
                        pixelFrame2 = this.mUGCCombineProcessor.processFrame(readNextVideoFrame, list);
                    } else {
                        pixelFrame2 = this.mUGCTransitionProcessor.processFrame(readNextVideoFrame, this.mTransitionType);
                    }
                }
                if (pixelFrame2 == null) {
                    PixelFrame.releasePixelFrames(readNextVideoFrame);
                    return;
                }
                PixelFrame pixelFrame3 = this.mLastRenderFrame;
                if (pixelFrame3 != null) {
                    pixelFrame3.release();
                }
                PixelFrame preScale = preScale(pixelFrame2);
                this.mLastRenderFrame = preScale;
                this.mVideoProcessManager.processFrame(preScale);
                if (readNextVideoFrame.size() > 1) {
                    pixelFrame2.release();
                }
                for (PixelFrame release2 : readNextVideoFrame) {
                    release2.release();
                }
            }
        }
    }

    private void removeMsgFromVideoProcessHandler(int i11) {
        synchronized (this) {
            CustomHandler customHandler = this.mVideoProcessHandler;
            if (customHandler != null) {
                customHandler.removeMessages(i11);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r0 == null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        if (android.os.Looper.myLooper() != r0.getLooper()) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        r4.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        r4 = r0.post(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r4 != false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        com.tencent.liteav.base.util.LiteavLog.e(r3.mTag, "handler post fail ret = ".concat(java.lang.String.valueOf(r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean runOnVideoProcessHandler(java.lang.Runnable r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.tencent.liteav.base.util.CustomHandler r0 = r3.mVideoProcessHandler     // Catch:{ all -> 0x005d }
            r1 = 0
            if (r0 == 0) goto L_0x0054
            android.os.Looper r0 = r0.getLooper()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0054
            com.tencent.liteav.base.util.CustomHandler r0 = r3.mVideoProcessHandler     // Catch:{ all -> 0x005d }
            android.os.Looper r0 = r0.getLooper()     // Catch:{ all -> 0x005d }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0054
            com.tencent.liteav.base.util.CustomHandler r0 = r3.mVideoProcessHandler     // Catch:{ all -> 0x005d }
            android.os.Looper r0 = r0.getLooper()     // Catch:{ all -> 0x005d }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x005d }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x005d }
            if (r0 != 0) goto L_0x0029
            goto L_0x0054
        L_0x0029:
            com.tencent.liteav.base.util.CustomHandler r0 = r3.mVideoProcessHandler     // Catch:{ all -> 0x005d }
            monitor-exit(r3)     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0053
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.os.Looper r2 = r0.getLooper()
            if (r1 != r2) goto L_0x003d
            r4.run()
            r4 = 1
            return r4
        L_0x003d:
            boolean r4 = r0.post(r4)
            if (r4 != 0) goto L_0x0052
            java.lang.String r0 = r3.mTag
            java.lang.String r1 = "handler post fail ret = "
            java.lang.String r2 = java.lang.String.valueOf(r4)
            java.lang.String r1 = r1.concat(r2)
            com.tencent.liteav.base.util.LiteavLog.e(r0, r1)
        L_0x0052:
            return r4
        L_0x0053:
            return r1
        L_0x0054:
            java.lang.String r4 = r3.mTag     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "handler post fail thread is not alive "
            com.tencent.liteav.base.util.LiteavLog.e(r4, r0)     // Catch:{ all -> 0x005d }
            monitor-exit(r3)     // Catch:{ all -> 0x005d }
            return r1
        L_0x005d:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x005d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.UGCVideoProcessor.runOnVideoProcessHandler(java.lang.Runnable):boolean");
    }

    private void sendMsgToVideoProcessHandler(int i11) {
        synchronized (this) {
            CustomHandler customHandler = this.mVideoProcessHandler;
            if (customHandler != null) {
                customHandler.sendEmptyMessage(i11);
            }
        }
    }

    /* access modifiers changed from: private */
    public void stopEncoder() {
        UGCVideoEncodeController uGCVideoEncodeController = this.mVideoEncodeController;
        if (uGCVideoEncodeController != null) {
            this.mFinalPts = -1;
            uGCVideoEncodeController.signalEndOfStream();
            this.mVideoEncodeController.stop();
            this.mVideoEncodeController = null;
        }
    }

    private void unInitVideoProcessor() {
        LiteavLog.i(this.mTag, "uninitVideoProcessor: ");
        this.mVideoProcessManager.unInitFilter(this.mVideoPreprocessorListener);
        UGCTransitionProcessor uGCTransitionProcessor = this.mUGCTransitionProcessor;
        if (uGCTransitionProcessor != null) {
            uGCTransitionProcessor.release();
            this.mUGCTransitionProcessor = null;
        }
        UGCCombineProcessor uGCCombineProcessor = this.mUGCCombineProcessor;
        if (uGCCombineProcessor != null) {
            uGCCombineProcessor.release();
            this.mUGCCombineProcessor = null;
        }
        PixelFrameRenderer pixelFrameRenderer = this.mPreScaleRenderer;
        if (pixelFrameRenderer != null) {
            pixelFrameRenderer.uninitialize();
            this.mPreScaleRenderer = null;
        }
    }

    private void uninitializedEGL() {
        LiteavLog.i(this.mThrottlers.a("uninitGL"), this.mTag, "uninitializedEGL", new Object[0]);
        GLTexturePool gLTexturePool = this.mGLTexturePool;
        if (gLTexturePool != null) {
            gLTexturePool.destroy();
        }
        TXVideoEditer.TXVideoCustomProcessListener tXVideoCustomProcessListener = this.mTXVideoCustomProcessListener;
        if (tXVideoCustomProcessListener != null) {
            tXVideoCustomProcessListener.onTextureDestroyed();
        }
        EGLCore.destroy(this.mEGLCore);
        this.mEGLCore = null;
    }

    public VideoEffectProcessor getEffectProcessor() {
        return this.mVideoProcessManager.getEffectProcessor();
    }

    public VideoTransitionProcessor getTransitionProcessor() {
        return this.mVideoProcessManager.getTransitionProcessor();
    }

    public WatermarkProcessor getWatermarkProcessor() {
        return this.mVideoProcessManager.getWatermarkProcessor();
    }

    public void initialize() {
        if (!this.mIsInit) {
            this.mIsInit = true;
            LiteavLog.i(this.mTag, "initialize: ");
            HandlerThread handlerThread = new HandlerThread("VideoProcess_" + hashCode());
            handlerThread.start();
            synchronized (this) {
                this.mVideoProcessHandler = new CustomHandler(handlerThread.getLooper(), gy.a(this));
            }
            VideoProcessManager videoProcessManager = this.mVideoProcessManager;
            videoProcessManager.getClass();
            runOnVideoProcessHandler(gz.a(videoProcessManager));
        }
    }

    public void refreshOneFrame() {
        sendMsgToVideoProcessHandler(104);
    }

    public void seekTo(long j11) {
        this.mTargetSeekPts.set(Long.valueOf(j11));
        removeMsgFromVideoProcessHandler(105);
        sendMsgToVideoProcessHandler(105);
    }

    public void setBeautyFilter(int i11, int i12) {
        runOnVideoProcessHandler(gt.a(this, i11, i12));
    }

    public void setCustomVideoProcessListener(TXVideoEditer.TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        runOnVideoProcessHandler(gw.a(this, tXVideoCustomProcessListener));
    }

    public void setDisplayView(DisplayTarget displayTarget, GLConstants.GLScaleType gLScaleType) {
        String str = this.mTag;
        LiteavLog.i(str, "setDisplayView: displayTarget:" + displayTarget + "scaleType:" + gLScaleType);
        runOnVideoProcessHandler(hf.a(this, displayTarget, gLScaleType));
    }

    public void setEncodeParams(VideoEncodeParams videoEncodeParams) {
        LiteavLog.i(this.mTag, "setEncodeParams: ".concat(String.valueOf(videoEncodeParams)));
        runOnVideoProcessHandler(gp.a(this, videoEncodeParams));
    }

    public void setFilter(Bitmap bitmap, float f11, Bitmap bitmap2, float f12, float f13) {
        runOnVideoProcessHandler(gv.a(this, bitmap, f11, bitmap2, f12, f13));
        sendMsgToVideoProcessHandler(104);
    }

    public void setOutputSize(int i11, int i12, GLConstants.GLScaleType gLScaleType) {
        runOnVideoProcessHandler(he.a(this, i11, i12, gLScaleType));
    }

    public void setPictureTransition(int i11) {
        runOnVideoProcessHandler(gr.a(this, i11));
    }

    public void setProgressListener(VideoProcessListener videoProcessListener) {
        runOnVideoProcessHandler(gx.a(this, videoProcessListener));
    }

    public void setRenderRotation(k kVar) {
        LiteavLog.i(this.mTag, "setRenderRotation: ".concat(String.valueOf(kVar)));
        if (kVar != null) {
            runOnVideoProcessHandler(go.a(this, kVar));
            sendMsgToVideoProcessHandler(104);
        }
    }

    public void setReverse(boolean z11) {
        this.mReverse = z11;
    }

    public void setSpecialRatio(float f11) {
        runOnVideoProcessHandler(gu.a(this, f11));
        sendMsgToVideoProcessHandler(104);
    }

    public void setSpeedList(List<TXVideoEditConstants.TXSpeed> list) {
        runOnVideoProcessHandler(gs.a(this, list));
    }

    public void setSplitScreenList(List<TXVideoEditConstants.TXAbsoluteRect> list, int i11, int i12) {
        runOnVideoProcessHandler(hd.a(this, list, i11, i12));
    }

    public void setVideoEncodedFrameListener(VideoEncodedFrameListener videoEncodedFrameListener) {
        runOnVideoProcessHandler(gq.a(this, videoEncodedFrameListener));
    }

    public void start(boolean z11, VideoEncoderDef.EncoderType encoderType) {
        LiteavLog.i(this.mTag, "start: ".concat(String.valueOf(z11)));
        runOnVideoProcessHandler(hb.a(this, z11, encoderType));
        sendMsgToVideoProcessHandler(100);
        sendMsgToVideoProcessHandler(101);
    }

    public void stop() {
        LiteavLog.i(this.mTag, "stop: ");
        removeMsgFromVideoProcessHandler(101);
        sendMsgToVideoProcessHandler(103);
        runOnVideoProcessHandler(hc.a(this));
    }

    public void unInitialize() {
        if (this.mIsInit) {
            this.mIsInit = false;
            LiteavLog.i(this.mTag, "uninitialize");
            runOnVideoProcessHandler(ha.a(this));
        }
    }
}
