package com.tencent.ugc;

import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.g;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.UGCFrameQueue;
import com.tencent.ugc.decoder.UGCVideoDecodeController;
import com.tencent.ugc.decoder.UGCVideoDecodeControllerListener;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.videobase.egl.EGLCore;
import com.tencent.ugc.videobase.egl.EGLException;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.frame.PixelFrameRenderer;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class UGCSingleFilePixelFrameProvider implements UGCPixelFrameProvider {
    private static final int DELAY_TIME_OF_TRY_DECODE = 10;
    private static final int REVERSE_STEP_TIME = 500;
    private final Clip mClip;
    private VideoDemuxer mDemuxer;
    private EGLCore mEGLCore;
    private int mFrameCacheCapacityForReverse = 0;
    private GLTexturePool mGLTexturePool;
    private boolean mHasReadEOF = false;
    /* access modifiers changed from: private */
    public boolean mIsAbandoningDecodingFrame = false;
    private boolean mIsDecodeCompleted = false;
    /* access modifiers changed from: private */
    public boolean mIsFrameSendingDecoder = false;
    private boolean mIsInPreciseSeeking = true;
    private boolean mIsReverse = false;
    private int mMaxFrameCount = 3;
    private final Deque<PixelFrame> mPixFrameCacheForReverse;
    /* access modifiers changed from: private */
    public final UGCFrameQueue<List<PixelFrame>> mPixFrameQueue;
    private PixelFrameRenderer mPixelFrameRenderer;
    private long mPlayEndPts = Long.MAX_VALUE;
    private long mReversePlayCurrentPts;
    private long mSeekingTimeMs = -1;
    /* access modifiers changed from: private */
    public final String mTag = ("UGCSingleFilePixelFrameProvider_" + hashCode());
    private final b mThrottlers = new b();
    private final UGCVideoDecodeControllerListener mUGCDecodeControllerListener = new UGCVideoDecodeControllerListener() {
        public static /* synthetic */ void b(AnonymousClass1 r22) {
            if (UGCSingleFilePixelFrameProvider.this.mVideoDecodeController != null) {
                boolean unused = UGCSingleFilePixelFrameProvider.this.mIsAbandoningDecodingFrame = false;
                UGCSingleFilePixelFrameProvider.this.decodeInternal();
            }
        }

        public final void onAbandonDecodingFramesCompleted() {
            LiteavLog.i(UGCSingleFilePixelFrameProvider.this.mTag, "onAbandonDecodingFramesCompleted");
            UGCSingleFilePixelFrameProvider.this.mWorkHandler.runOrPost(gc.a(this));
        }

        public final void onDecodeCompleted() {
            UGCSingleFilePixelFrameProvider.this.mWorkHandler.runOrPost(gb.a(this));
        }

        public final void onDecodeFailed() {
            LiteavLog.i(UGCSingleFilePixelFrameProvider.this.mTag, "on decode fail");
            UGCSingleFilePixelFrameProvider.this.mWorkHandler.runOrPost(ge.a(this));
        }

        public final void onFrameDecoded(PixelFrame pixelFrame) {
            if (pixelFrame != null) {
                pixelFrame.retain();
                UGCSingleFilePixelFrameProvider.this.mWorkHandler.runOrPost(fz.a(this, pixelFrame));
            }
        }

        public final void onFrameEnqueuedToDecoder() {
            UGCSingleFilePixelFrameProvider.this.mWorkHandler.runOrPost(ga.a(this));
        }

        public final void onRequestSeekToLastKeyFrame(long j11) {
            LiteavLog.i(UGCSingleFilePixelFrameProvider.this.mTag, "onRequestSeekToLastKeyFrame pts = ".concat(String.valueOf(j11)));
            UGCSingleFilePixelFrameProvider.this.mWorkHandler.runOrPost(gd.a(this, j11));
        }

        public static /* synthetic */ void a(AnonymousClass1 r12) {
            if (UGCSingleFilePixelFrameProvider.this.mVideoDecodeController != null) {
                UGCSingleFilePixelFrameProvider.this.mPixFrameQueue.queue(UGCPixelFrameProvider.END_OF_STREAM);
            }
        }
    };
    private final UGCFrameQueue.UGCFrameQueueListener mUGCFrameQueueListener = new UGCFrameQueue.UGCFrameQueueListener() {
        public static /* synthetic */ void a(AnonymousClass2 r12) {
            if (!UGCSingleFilePixelFrameProvider.this.mIsFrameSendingDecoder) {
                UGCSingleFilePixelFrameProvider.this.decodeInternal();
            }
        }

        public final void onFrameDequeued() {
            UGCSingleFilePixelFrameProvider.this.mWorkHandler.runOrPost(gf.a(this));
        }
    };
    /* access modifiers changed from: private */
    public UGCVideoDecodeController mVideoDecodeController;
    private int mVideoHeight = 0;
    private k mVideoRotation = k.NORMAL;
    private int mVideoWidth = 0;
    /* access modifiers changed from: private */
    public final CustomHandler mWorkHandler;

    public UGCSingleFilePixelFrameProvider(Clip clip, CustomHandler customHandler) {
        this.mClip = new Clip(clip);
        this.mPixFrameQueue = new UGCFrameQueue<>();
        this.mPixFrameCacheForReverse = new LinkedList();
        this.mWorkHandler = customHandler;
    }

    private void addFrameToQueue(PixelFrame pixelFrame) {
        if (pixelFrame == null) {
            this.mPixFrameQueue.queue(UGCPixelFrameProvider.END_OF_STREAM);
        } else if (pixelFrame.getTimestamp() < this.mClip.startInFileTime) {
            pixelFrame.release();
        } else if (pixelFrame.getTimestamp() > this.mClip.endInFileTime || pixelFrame.getTimestamp() > this.mPlayEndPts) {
            String str = this.mTag;
            LiteavLog.i(str, "addFrameToQueue Timestamp = " + pixelFrame.getTimestamp() + " endInnerFileTime = " + this.mClip.endInFileTime);
            this.mPixFrameQueue.queue(UGCPixelFrameProvider.END_OF_STREAM);
            pixelFrame.release();
        } else {
            pixelFrame.setTimestamp(fileTimeToTimeline(pixelFrame.getTimestamp()));
            LinkedList linkedList = new LinkedList();
            linkedList.add(pixelFrame);
            this.mPixFrameQueue.queue(linkedList);
        }
    }

    private void addFrameToQueueForReverse(PixelFrame pixelFrame) {
        if (pixelFrame == null || pixelFrame.getTimestamp() > this.mReversePlayCurrentPts) {
            if (pixelFrame != null) {
                pixelFrame.release();
            }
            if (this.mPixFrameCacheForReverse.isEmpty()) {
                LiteavLog.i(this.mTag, "mGopVideoFrameList isEmpty so put END_OF_STREAM");
                this.mPixFrameQueue.queue(UGCPixelFrameProvider.END_OF_STREAM);
                return;
            }
            this.mFrameCacheCapacityForReverse = this.mPixFrameCacheForReverse.size();
            while (!this.mPixFrameCacheForReverse.isEmpty()) {
                PixelFrame pollLast = this.mPixFrameCacheForReverse.pollLast();
                long timestamp = pollLast.getTimestamp();
                this.mReversePlayCurrentPts = timestamp;
                Clip clip = this.mClip;
                if (timestamp > clip.endInFileTime || timestamp < clip.startInFileTime) {
                    pollLast.release();
                } else {
                    pollLast.setTimestamp(fileTimeToTimelineForReverse(timestamp));
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(pollLast);
                    this.mPixFrameQueue.queue(linkedList);
                }
            }
            long j11 = this.mReversePlayCurrentPts;
            if (j11 <= this.mClip.startInFileTime) {
                LiteavLog.i(this.mTag, "mLastGopFinishPts is smaller start time so put END_OF_STREAM");
                this.mPixFrameQueue.queue(UGCPixelFrameProvider.END_OF_STREAM);
                return;
            }
            long j12 = j11 - 1;
            this.mReversePlayCurrentPts = j12;
            seekToInFileTime(j12 - 500, false);
            return;
        }
        this.mPixFrameCacheForReverse.addLast(pixelFrame);
    }

    private void clearPixelFrameQueue() {
        EGLCore eGLCore = this.mEGLCore;
        if (eGLCore != null) {
            try {
                eGLCore.makeCurrent();
            } catch (EGLException e11) {
                LiteavLog.e(this.mTag, "make current exception when clear pixel frame queue. exception msg is ", (Throwable) e11);
                return;
            }
        }
        for (List<PixelFrame> releasePixelFrames : this.mPixFrameQueue.dequeueAll()) {
            PixelFrame.releasePixelFrames(releasePixelFrames);
        }
    }

    private boolean createDemuxerAndOpenFile() {
        String str = this.mClip.videoMimeType;
        if (str == null || "video/hevc".equals(str) || "video/avc".equals(this.mClip.videoMimeType)) {
            this.mDemuxer = new VideoDemuxerFFmpeg();
        } else {
            this.mDemuxer = new VideoDemuxerSystem();
        }
        if (this.mDemuxer.open(this.mClip.path)) {
            return true;
        }
        this.mDemuxer.close();
        this.mDemuxer = null;
        return false;
    }

    /* access modifiers changed from: private */
    public void decodeInternal() {
        if (this.mVideoDecodeController == null || !isNeedDecode()) {
            this.mIsFrameSendingDecoder = false;
        } else if (this.mVideoDecodeController.isInputQueueFull()) {
            this.mWorkHandler.postDelayed(fv.a(this), 10);
        } else {
            EncodedVideoFrame nextEncodeVideoFrame = this.mDemuxer.getNextEncodeVideoFrame();
            if (nextEncodeVideoFrame != null) {
                if (nextEncodeVideoFrame == VideoDemuxer.END_OF_STREAM) {
                    LiteavLog.i(this.mTag, "demuxer read completed");
                    this.mHasReadEOF = true;
                    this.mVideoDecodeController.signalEndOfStream();
                    this.mWorkHandler.removeCallbacks(fw.a(this));
                    this.mWorkHandler.runOrPost(fx.a(this), 1000);
                } else {
                    this.mIsFrameSendingDecoder = true;
                    this.mIsDecodeCompleted = false;
                    this.mVideoRotation = k.a(nextEncodeVideoFrame.rotation);
                    this.mVideoDecodeController.decode(nextEncodeVideoFrame);
                }
                long j11 = this.mSeekingTimeMs;
                if (j11 < 0) {
                    this.mWorkHandler.post(fy.a(this));
                } else if (nextEncodeVideoFrame.pts > j11) {
                    this.mWorkHandler.postDelayed(fp.a(this), 10);
                } else {
                    this.mWorkHandler.post(fq.a(this));
                }
            }
        }
    }

    private long fileTimeToTimeline(long j11) {
        Clip clip = this.mClip;
        long j12 = clip.startInClipsTimeline;
        List<TXVideoEditConstants.TXSpeed> list = clip.speedList;
        if (list == null) {
            return j12 + (j11 - clip.startInFileTime);
        }
        for (TXVideoEditConstants.TXSpeed next : list) {
            float timeMultipleInSpeed = 1.0f / getTimeMultipleInSpeed(next.speedLevel);
            long j13 = next.endTime;
            if (j11 < j13) {
                return j12 + ((long) (((float) (j11 - next.startTime)) * timeMultipleInSpeed));
            }
            j12 += (long) (((float) (j13 - next.startTime)) * timeMultipleInSpeed);
        }
        return j12;
    }

    private long fileTimeToTimelineForReverse(long j11) {
        Clip clip = this.mClip;
        List<TXVideoEditConstants.TXSpeed> list = clip.speedList;
        if (list == null) {
            return clip.endInFileTime - j11;
        }
        long j12 = clip.startInClipsTimeline;
        for (int size = list.size() - 1; size >= 0; size--) {
            TXVideoEditConstants.TXSpeed tXSpeed = this.mClip.speedList.get(size);
            float timeMultipleInSpeed = 1.0f / getTimeMultipleInSpeed(tXSpeed.speedLevel);
            long j13 = tXSpeed.startTime;
            if (j11 > j13) {
                return j12 + ((long) (((float) (tXSpeed.endTime - j11)) * timeMultipleInSpeed));
            }
            j12 += (long) (((float) (tXSpeed.endTime - j13)) * timeMultipleInSpeed);
        }
        return j12;
    }

    private float getTimeMultipleInSpeed(int i11) {
        return UGCMediaListSource.getSpeed(i11);
    }

    private void initializeDecodeController() {
        if (this.mVideoDecodeController != null) {
            LiteavLog.w(this.mTag, "UGCVideoFileProvider is initialized");
            return;
        }
        LiteavLog.i(this.mTag, "initializeDecodeController");
        UGCVideoDecodeController uGCVideoDecodeController = new UGCVideoDecodeController();
        this.mVideoDecodeController = uGCVideoDecodeController;
        uGCVideoDecodeController.start(this.mUGCDecodeControllerListener);
    }

    private void initializeGLComponents() {
        if (this.mEGLCore == null) {
            LiteavLog.i(this.mThrottlers.a("initGL"), this.mTag, "initializeGLComponents", new Object[0]);
            EGLCore eGLCore = new EGLCore();
            this.mEGLCore = eGLCore;
            try {
                eGLCore.initialize(GlobalContextManager.getInstance().getGLContext(), (Surface) null, 128, 128);
                this.mEGLCore.makeCurrent();
                this.mGLTexturePool = new GLTexturePool();
            } catch (EGLException e11) {
                LiteavLog.e(this.mThrottlers.a("initGLError"), this.mTag, "initializeGLComponents failed.", (Throwable) e11);
                this.mEGLCore = null;
            }
        }
    }

    private boolean isNeedDecode() {
        return (this.mVideoDecodeController != null && this.mDemuxer != null && !this.mIsAbandoningDecodingFrame && !this.mHasReadEOF) && !(!this.mIsReverse ? this.mPixFrameQueue.size() >= this.mMaxFrameCount : !(this.mPixFrameQueue.size() < this.mMaxFrameCount || this.mPixFrameQueue.size() + this.mPixFrameCacheForReverse.size() < this.mFrameCacheCapacityForReverse + this.mMaxFrameCount));
    }

    public static /* synthetic */ void lambda$seekTo$0(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider, long j11, boolean z11) {
        if (uGCSingleFilePixelFrameProvider.mVideoDecodeController != null && uGCSingleFilePixelFrameProvider.mDemuxer != null) {
            uGCSingleFilePixelFrameProvider.clearPixelFrameQueue();
            long timelineToFileTime = uGCSingleFilePixelFrameProvider.timelineToFileTime(j11);
            uGCSingleFilePixelFrameProvider.mReversePlayCurrentPts = timelineToFileTime;
            uGCSingleFilePixelFrameProvider.seekToInFileTime(timelineToFileTime, z11);
        }
    }

    /* access modifiers changed from: private */
    public void onDecodeCompletedInternal() {
        LiteavLog.i(this.mTag, "onDecodeCompletedInteral");
        if (this.mVideoDecodeController != null && !this.mIsAbandoningDecodingFrame && !this.mIsDecodeCompleted && this.mHasReadEOF) {
            if (this.mIsReverse) {
                addFrameToQueueForReverse((PixelFrame) null);
            } else {
                addFrameToQueue((PixelFrame) null);
            }
            this.mIsDecodeCompleted = true;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        if (r5 != -1) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDecodeFrameInternal(com.tencent.ugc.videobase.frame.PixelFrame r8) {
        /*
            r7 = this;
            com.tencent.ugc.decoder.UGCVideoDecodeController r0 = r7.mVideoDecodeController
            if (r0 != 0) goto L_0x0008
            r8.release()
            return
        L_0x0008:
            long r0 = r8.getTimestamp()
            boolean r2 = r7.mIsAbandoningDecodingFrame
            if (r2 != 0) goto L_0x0037
            boolean r2 = r7.mIsReverse
            r3 = -1
            if (r2 != 0) goto L_0x0025
            boolean r2 = r7.mIsInPreciseSeeking
            if (r2 == 0) goto L_0x0025
            long r5 = r7.mSeekingTimeMs
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0025
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0025
            goto L_0x0037
        L_0x0025:
            r7.mSeekingTimeMs = r3
            com.tencent.ugc.videobase.frame.PixelFrame r8 = r7.processFrame(r8)
            boolean r0 = r7.mIsReverse
            if (r0 == 0) goto L_0x0033
            r7.addFrameToQueueForReverse(r8)
            return
        L_0x0033:
            r7.addFrameToQueue(r8)
            return
        L_0x0037:
            r8.release()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.UGCSingleFilePixelFrameProvider.onDecodeFrameInternal(com.tencent.ugc.videobase.frame.PixelFrame):void");
    }

    private PixelFrame processFrame(PixelFrame pixelFrame) {
        PixelFrameRenderer pixelFrameRenderer;
        EGLCore eGLCore = this.mEGLCore;
        if (eGLCore == null) {
            pixelFrame.release();
            return null;
        }
        try {
            eGLCore.makeCurrent();
            pixelFrame.setRotation(this.mVideoRotation);
            if (!(pixelFrame.getRotation() == k.NORMAL || pixelFrame.getRotation() == k.ROTATION_180)) {
                pixelFrame.swapWidthHeight();
            }
            int width = pixelFrame.getWidth();
            int height = pixelFrame.getHeight();
            if (!((width == this.mVideoWidth && height == this.mVideoHeight) || (pixelFrameRenderer = this.mPixelFrameRenderer) == null)) {
                pixelFrameRenderer.uninitialize();
                this.mPixelFrameRenderer = null;
            }
            if (this.mPixelFrameRenderer == null) {
                this.mPixelFrameRenderer = new PixelFrameRenderer(width, height);
                this.mVideoWidth = width;
                this.mVideoHeight = height;
            }
            OpenGlUtils.glViewport(0, 0, width, height);
            GLTexture obtain = this.mGLTexturePool.obtain(width, height);
            obtain.setColorFormat(pixelFrame.getColorRange(), pixelFrame.getColorSpace());
            this.mPixelFrameRenderer.renderFrame(pixelFrame, GLConstants.GLScaleType.CENTER_CROP, obtain);
            PixelFrame wrap = obtain.wrap(this.mEGLCore.getEglContext());
            wrap.setTimestamp(pixelFrame.getTimestamp());
            wrap.setGLContext(GlobalContextManager.getInstance().getGLContext());
            GLES20.glFinish();
            obtain.release();
            pixelFrame.release();
            return wrap;
        } catch (EGLException unused) {
            pixelFrame.release();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void seekToInFileTime(long j11, boolean z11) {
        if (this.mDemuxer != null) {
            Clip clip = this.mClip;
            long a11 = g.a(j11, clip.startInFileTime, clip.endInFileTime);
            LiteavLog.i(this.mTag, "seekToInFileTime file time = ".concat(String.valueOf(a11)));
            this.mSeekingTimeMs = a11;
            this.mIsInPreciseSeeking = z11;
            this.mDemuxer.seek(a11);
            if (!this.mIsAbandoningDecodingFrame) {
                this.mIsAbandoningDecodingFrame = true;
                this.mVideoDecodeController.abandonDecodingFrames();
            }
            this.mHasReadEOF = false;
            PixelFrame.releasePixelFrames(this.mPixFrameCacheForReverse);
        }
    }

    /* access modifiers changed from: private */
    public void setReverseInternal(boolean z11) {
        if (this.mIsReverse != z11) {
            this.mIsReverse = z11;
            if (z11) {
                long j11 = this.mClip.endInFileTime;
                this.mReversePlayCurrentPts = j11;
                seekToInFileTime(j11 - 500, false);
            } else {
                seekToInFileTime(this.mClip.startInFileTime, true);
            }
            clearPixelFrameQueue();
        }
    }

    /* access modifiers changed from: private */
    public void startInternal() {
        if (!createDemuxerAndOpenFile()) {
            String str = this.mTag;
            LiteavLog.e(str, this.mClip.path + " open fail or there is not video stream");
            this.mPixFrameQueue.queue(UGCPixelFrameProvider.END_OF_STREAM);
            return;
        }
        String str2 = this.mTag;
        LiteavLog.i(str2, this.mClip.path + " open success");
        this.mPixFrameQueue.setUGCFrameQueueListener(this.mUGCFrameQueueListener);
        this.mPixFrameQueue.clear();
        if (this.mIsReverse) {
            long j11 = this.mClip.endInFileTime;
            this.mReversePlayCurrentPts = j11;
            this.mDemuxer.seek(j11 - 500);
        } else {
            long j12 = this.mClip.startInFileTime;
            if (j12 != 0) {
                this.mDemuxer.seek(j12);
            }
        }
        initializeDecodeController();
        initializeGLComponents();
        decodeInternal();
    }

    /* access modifiers changed from: private */
    public void stopInternal() {
        this.mPixFrameQueue.setUGCFrameQueueListener((UGCFrameQueue.UGCFrameQueueListener) null);
        VideoDemuxer videoDemuxer = this.mDemuxer;
        if (videoDemuxer != null) {
            videoDemuxer.close();
            this.mDemuxer = null;
        }
        UGCVideoDecodeController uGCVideoDecodeController = this.mVideoDecodeController;
        if (uGCVideoDecodeController != null) {
            uGCVideoDecodeController.stop();
            this.mVideoDecodeController = null;
        }
        clearPixelFrameQueue();
        PixelFrame.releasePixelFrames(this.mPixFrameCacheForReverse);
        this.mPixFrameQueue.queue(UGCPixelFrameProvider.END_OF_STREAM);
        this.mIsAbandoningDecodingFrame = false;
        this.mIsInPreciseSeeking = true;
        this.mIsReverse = false;
        this.mIsFrameSendingDecoder = false;
        this.mSeekingTimeMs = -1;
        this.mReversePlayCurrentPts = this.mClip.startInFileTime;
    }

    private long timelineToFileTime(long j11) {
        Clip clip = this.mClip;
        List<TXVideoEditConstants.TXSpeed> list = clip.speedList;
        if (list == null) {
            return j11 + clip.startInFileTime;
        }
        long j12 = 0;
        for (TXVideoEditConstants.TXSpeed next : list) {
            float timeMultipleInSpeed = 1.0f / getTimeMultipleInSpeed(next.speedLevel);
            long j13 = next.endTime;
            long j14 = next.startTime;
            long j15 = (long) (((float) (j13 - j14)) * timeMultipleInSpeed);
            long j16 = ((long) (((float) j11) / timeMultipleInSpeed)) + j14;
            if (j11 < j15) {
                return j16;
            }
            j11 -= j15;
            j12 = j16;
        }
        return j12;
    }

    private void unInitializeGLComponents() {
        GLTexturePool gLTexturePool = this.mGLTexturePool;
        if (gLTexturePool != null) {
            gLTexturePool.evictAll();
            this.mGLTexturePool.destroy();
            this.mGLTexturePool = null;
        }
        PixelFrameRenderer pixelFrameRenderer = this.mPixelFrameRenderer;
        if (pixelFrameRenderer != null) {
            pixelFrameRenderer.uninitialize();
            this.mPixelFrameRenderer = null;
        }
        EGLCore.destroy(this.mEGLCore);
        this.mEGLCore = null;
    }

    /* access modifiers changed from: private */
    public void uninitializeInternal() {
        unInitializeGLComponents();
        UGCVideoDecodeController uGCVideoDecodeController = this.mVideoDecodeController;
        if (uGCVideoDecodeController != null) {
            uGCVideoDecodeController.stop();
            this.mVideoDecodeController = null;
        }
        clearPixelFrameQueue();
        PixelFrame.releasePixelFrames(this.mPixFrameCacheForReverse);
    }

    public UGCFrameQueue<List<PixelFrame>> getFrameQueue() {
        return this.mPixFrameQueue;
    }

    public void initialize() {
        LiteavLog.i(this.mTag, "initialize");
    }

    public void seekTo(long j11, boolean z11) {
        String str = this.mTag;
        LiteavLog.i(str, "seekTo lineTime = " + j11 + " isPreciseSeek = " + z11);
        this.mWorkHandler.runAndWaitDone(ft.a(this, j11, z11), 1000);
    }

    public void setMaxBufferFrameCount(int i11) {
        this.mMaxFrameCount = i11;
    }

    public void setPlayEndPts(long j11) {
        this.mPlayEndPts = j11;
    }

    public void setReverse(boolean z11) {
        LiteavLog.i(this.mTag, "isReverse = ".concat(String.valueOf(z11)));
        this.mWorkHandler.runOrPost(fu.a(this, z11));
    }

    public void start() {
        this.mWorkHandler.runOrPost(fr.a(this));
    }

    public void stop() {
        this.mWorkHandler.runOrPost(fs.a(this));
    }

    public void uninitialize() {
        LiteavLog.i(this.mTag, "unInitialize");
        this.mWorkHandler.runOrPost(fo.a(this));
    }
}
