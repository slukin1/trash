package com.tencent.ugc.encoder;

import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.encoder.VideoEncoderInterface;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.videobase.egl.EGLContextChecker;
import com.tencent.ugc.videobase.egl.EGLCore;
import com.tencent.ugc.videobase.egl.EGLException;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.frame.PixelFrameRenderer;
import com.tencent.ugc.videobase.utils.PixelFrameQueue;
import com.tencent.ugc.videobase.utils.RingFrameQueue;

public class HardwareVideoEncoder implements VideoEncoderInterface {
    private static final int MAX_FRAME_QUEUE_SIZE = 1;
    private EGLContextChecker mEGLContextChecker;
    private EGLCore mEGLCore;
    private final PixelFrameQueue mEncodeFrameQueue;
    private Surface mInputSurface;
    /* access modifiers changed from: private */
    public volatile VideoEncoderInterface.VideoEncoderListener mListener;
    private PixelFrameRenderer mPixelFrameRenderer;
    private long mPreFrameTimeStamp = 0;
    private final SurfaceInputVideoEncoder mSurfaceInputVideoEncoder;
    private final Size mSurfaceSize = new Size(0, 0);
    private final String mTAG;
    private final b mThrottlers = new b();
    private final VideoEncoderInterface.VideoEncoderListener mVideoEncoderListener = new VideoEncoderInterface.VideoEncoderListener() {
        public static /* synthetic */ void a(AnonymousClass1 r02, EncodedVideoFrame encodedVideoFrame, boolean z11) {
            VideoEncoderInterface.VideoEncoderListener access$100 = HardwareVideoEncoder.this.mListener;
            if (access$100 != null) {
                access$100.onEncodedNAL(encodedVideoFrame, z11);
            }
        }

        public static /* synthetic */ void b(AnonymousClass1 r02) {
            VideoEncoderInterface.VideoEncoderListener access$100 = HardwareVideoEncoder.this.mListener;
            if (access$100 != null) {
                access$100.onEncodedFail();
            }
        }

        public final void onEncodedFail() {
            HardwareVideoEncoder.this.runInEncodeThread(g.a(this));
        }

        public final void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z11) {
            HardwareVideoEncoder.this.runInEncodeThread(f.a(this, encodedVideoFrame, z11));
        }

        public final void onOutputFormatChanged(MediaFormat mediaFormat) {
            HardwareVideoEncoder.this.runInEncodeThread(i.a(this, mediaFormat));
        }

        public final void onRequestRestart() {
            HardwareVideoEncoder.this.runInEncodeThread(h.a(this));
        }

        public static /* synthetic */ void a(AnonymousClass1 r02) {
            VideoEncoderInterface.VideoEncoderListener access$100 = HardwareVideoEncoder.this.mListener;
            if (access$100 != null) {
                access$100.onRequestRestart();
            }
        }

        public static /* synthetic */ void a(AnonymousClass1 r02, MediaFormat mediaFormat) {
            VideoEncoderInterface.VideoEncoderListener access$100 = HardwareVideoEncoder.this.mListener;
            if (access$100 != null) {
                access$100.onOutputFormatChanged(mediaFormat);
            }
        }
    };
    private volatile CustomHandler mWorkHandler;

    public HardwareVideoEncoder(Bundle bundle) {
        this.mSurfaceInputVideoEncoder = new SurfaceInputVideoEncoder(bundle);
        this.mTAG = "HardwareVideoEncoder_" + hashCode();
        this.mEncodeFrameQueue = new RingFrameQueue(1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e A[Catch:{ EGLException -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0067 A[Catch:{ EGLException -> 0x00a3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void drawFrameToInputSurface(com.tencent.ugc.videobase.frame.PixelFrame r6) {
        /*
            r5 = this;
            com.tencent.ugc.videobase.egl.EGLCore r0 = r5.mEGLCore     // Catch:{ EGLException -> 0x00a3 }
            r0.makeCurrent()     // Catch:{ EGLException -> 0x00a3 }
            com.tencent.ugc.videobase.frame.PixelFrame r0 = new com.tencent.ugc.videobase.frame.PixelFrame     // Catch:{ EGLException -> 0x00a3 }
            r0.<init>((com.tencent.ugc.videobase.frame.PixelFrame) r6)     // Catch:{ EGLException -> 0x00a3 }
            com.tencent.ugc.videobase.frame.FrameMetaData r6 = r6.getMetaData()     // Catch:{ EGLException -> 0x00a3 }
            if (r6 == 0) goto L_0x0017
            com.tencent.liteav.base.util.k r6 = r6.getEncodeRotation()     // Catch:{ EGLException -> 0x00a3 }
            r0.postRotate(r6)     // Catch:{ EGLException -> 0x00a3 }
        L_0x0017:
            com.tencent.liteav.base.util.k r6 = r0.getRotation()     // Catch:{ EGLException -> 0x00a3 }
            com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_90     // Catch:{ EGLException -> 0x00a3 }
            r2 = 1
            r3 = 0
            if (r6 == r1) goto L_0x0036
            com.tencent.liteav.base.util.k r6 = r0.getRotation()     // Catch:{ EGLException -> 0x00a3 }
            com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_270     // Catch:{ EGLException -> 0x00a3 }
            if (r6 != r1) goto L_0x002a
            goto L_0x0036
        L_0x002a:
            boolean r6 = r0.isMirrorVertical()     // Catch:{ EGLException -> 0x00a3 }
            if (r6 != 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r2 = r3
        L_0x0032:
            r0.setMirrorVertical(r2)     // Catch:{ EGLException -> 0x00a3 }
            goto L_0x0041
        L_0x0036:
            boolean r6 = r0.isMirrorHorizontal()     // Catch:{ EGLException -> 0x00a3 }
            if (r6 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r2 = r3
        L_0x003e:
            r0.setMirrorHorizontal(r2)     // Catch:{ EGLException -> 0x00a3 }
        L_0x0041:
            com.tencent.liteav.base.util.Size r6 = r5.mSurfaceSize     // Catch:{ EGLException -> 0x00a3 }
            int r1 = r6.width     // Catch:{ EGLException -> 0x00a3 }
            int r6 = r6.height     // Catch:{ EGLException -> 0x00a3 }
            com.tencent.ugc.videobase.utils.OpenGlUtils.glViewport(r3, r3, r1, r6)     // Catch:{ EGLException -> 0x00a3 }
            com.tencent.ugc.videobase.frame.PixelFrameRenderer r6 = r5.mPixelFrameRenderer     // Catch:{ EGLException -> 0x00a3 }
            if (r6 == 0) goto L_0x0054
            com.tencent.ugc.videobase.base.GLConstants$GLScaleType r1 = com.tencent.ugc.videobase.base.GLConstants.GLScaleType.CENTER_CROP     // Catch:{ EGLException -> 0x00a3 }
            r2 = 0
            r6.renderFrame(r0, r1, r2)     // Catch:{ EGLException -> 0x00a3 }
        L_0x0054:
            com.tencent.ugc.encoder.SurfaceInputVideoEncoder r6 = r5.mSurfaceInputVideoEncoder     // Catch:{ EGLException -> 0x00a3 }
            long r1 = r0.getTimestamp()     // Catch:{ EGLException -> 0x00a3 }
            r6.signalBeforeSwapBuffers(r1)     // Catch:{ EGLException -> 0x00a3 }
            long r1 = r0.getTimestamp()     // Catch:{ EGLException -> 0x00a3 }
            long r3 = r5.mPreFrameTimeStamp     // Catch:{ EGLException -> 0x00a3 }
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x0088
            java.lang.String r6 = r5.mTAG     // Catch:{ EGLException -> 0x00a3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ EGLException -> 0x00a3 }
            java.lang.String r2 = "timestamp is not increase. pre: "
            r1.<init>(r2)     // Catch:{ EGLException -> 0x00a3 }
            long r2 = r5.mPreFrameTimeStamp     // Catch:{ EGLException -> 0x00a3 }
            r1.append(r2)     // Catch:{ EGLException -> 0x00a3 }
            java.lang.String r2 = ", cur: "
            r1.append(r2)     // Catch:{ EGLException -> 0x00a3 }
            long r2 = r0.getTimestamp()     // Catch:{ EGLException -> 0x00a3 }
            r1.append(r2)     // Catch:{ EGLException -> 0x00a3 }
            java.lang.String r1 = r1.toString()     // Catch:{ EGLException -> 0x00a3 }
            com.tencent.liteav.base.util.LiteavLog.e(r6, r1)     // Catch:{ EGLException -> 0x00a3 }
        L_0x0088:
            long r1 = r0.getTimestamp()     // Catch:{ EGLException -> 0x00a3 }
            r5.mPreFrameTimeStamp = r1     // Catch:{ EGLException -> 0x00a3 }
            com.tencent.ugc.videobase.egl.EGLCore r6 = r5.mEGLCore     // Catch:{ EGLException -> 0x00a3 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ EGLException -> 0x00a3 }
            long r2 = r0.getTimestamp()     // Catch:{ EGLException -> 0x00a3 }
            long r0 = r1.toNanos(r2)     // Catch:{ EGLException -> 0x00a3 }
            r6.setPresentationTime(r0)     // Catch:{ EGLException -> 0x00a3 }
            com.tencent.ugc.videobase.egl.EGLCore r6 = r5.mEGLCore     // Catch:{ EGLException -> 0x00a3 }
            r6.swapBuffers()     // Catch:{ EGLException -> 0x00a3 }
            return
        L_0x00a3:
            r6 = move-exception
            com.tencent.ugc.encoder.VideoEncoderInterface$VideoEncoderListener r0 = r5.mVideoEncoderListener
            r0.onEncodedFail()
            com.tencent.liteav.base.b.b r0 = r5.mThrottlers
            java.lang.String r1 = "EGLError"
            com.tencent.liteav.base.b.a r0 = r0.a(r1)
            java.lang.String r1 = r5.mTAG
            java.lang.String r2 = "makeCurrent failed."
            com.tencent.liteav.base.util.LiteavLog.e((com.tencent.liteav.base.b.a) r0, (java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.encoder.HardwareVideoEncoder.drawFrameToInputSurface(com.tencent.ugc.videobase.frame.PixelFrame):void");
    }

    /* access modifiers changed from: private */
    public void encodeFrameInternal() {
        PixelFrame poll = this.mEncodeFrameQueue.poll();
        if (poll != null) {
            if (!this.mEGLContextChecker.isSameOrSharedContext(poll.getGLContext())) {
                uninitOpenGLComponents();
            }
            if (this.mEGLCore != null || initOpenGLComponents(poll.getGLContext(), this.mInputSurface)) {
                drawFrameToInputSurface(poll);
            }
            poll.release();
        }
    }

    private boolean initOpenGLComponents(Object obj, Surface surface) {
        if (surface == null) {
            LiteavLog.w(this.mThrottlers.a("SurfaceNull"), this.mTAG, "init opengl: surface is null.", new Object[0]);
            return false;
        }
        LiteavLog.d(this.mThrottlers.a("initGL"), this.mTAG, "initOpenGLComponents", new Object[0]);
        EGLCore eGLCore = new EGLCore();
        this.mEGLCore = eGLCore;
        try {
            Size size = this.mSurfaceSize;
            eGLCore.initialize(obj, surface, size.width, size.height);
            Size size2 = this.mSurfaceSize;
            this.mPixelFrameRenderer = new PixelFrameRenderer(size2.width, size2.height);
            return true;
        } catch (EGLException e11) {
            this.mVideoEncoderListener.onEncodedFail();
            LiteavLog.e(this.mThrottlers.a("initError"), this.mTAG, "create EGLCore failed.", (Throwable) e11);
            this.mEGLCore = null;
            return false;
        }
    }

    public static /* synthetic */ void lambda$start$0(HardwareVideoEncoder hardwareVideoEncoder, VideoEncodeParams videoEncodeParams, VideoEncoderInterface.VideoEncoderListener videoEncoderListener) {
        if (hardwareVideoEncoder.mInputSurface != null) {
            LiteavLog.e(hardwareVideoEncoder.mTAG, "Encoder has started");
            return;
        }
        LiteavLog.i(hardwareVideoEncoder.mTAG, "Start hw video encoder. %s", videoEncodeParams);
        hardwareVideoEncoder.mListener = videoEncoderListener;
        Pair<Surface, Size> start = hardwareVideoEncoder.mSurfaceInputVideoEncoder.start(videoEncodeParams, hardwareVideoEncoder.mVideoEncoderListener);
        hardwareVideoEncoder.mInputSurface = (Surface) start.first;
        hardwareVideoEncoder.mSurfaceSize.set((Size) start.second);
        LiteavLog.i(hardwareVideoEncoder.mTAG, "Start hw video encoder done");
    }

    public static /* synthetic */ void lambda$stopSync$1(HardwareVideoEncoder hardwareVideoEncoder, long j11) {
        hardwareVideoEncoder.uninitOpenGLComponents();
        Surface surface = hardwareVideoEncoder.mInputSurface;
        if (surface != null) {
            surface.release();
            hardwareVideoEncoder.mInputSurface = null;
        }
        hardwareVideoEncoder.mSurfaceInputVideoEncoder.stopSync(j11);
        hardwareVideoEncoder.mEncodeFrameQueue.evictAll();
        hardwareVideoEncoder.mListener = null;
    }

    public static /* synthetic */ void lambda$uninitialize$2(HardwareVideoEncoder hardwareVideoEncoder) {
        hardwareVideoEncoder.mSurfaceInputVideoEncoder.uninitialize();
        hardwareVideoEncoder.mEGLContextChecker.uninitialize();
        hardwareVideoEncoder.mWorkHandler.quitLooper();
        hardwareVideoEncoder.mWorkHandler = null;
    }

    private boolean runAndWaitDone(Runnable runnable, long j11) {
        CustomHandler customHandler = this.mWorkHandler;
        if (customHandler == null) {
            return false;
        }
        if (customHandler.getLooper() != Looper.myLooper()) {
            return customHandler.runAndWaitDone(runnable, j11);
        }
        runnable.run();
        return true;
    }

    /* access modifiers changed from: private */
    public void runInEncodeThread(Runnable runnable) {
        CustomHandler customHandler = this.mWorkHandler;
        if (customHandler == null) {
            return;
        }
        if (customHandler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            customHandler.post(runnable);
        }
    }

    private void uninitOpenGLComponents() {
        if (this.mEGLCore != null) {
            LiteavLog.d(this.mThrottlers.a("uninitGL"), this.mTAG, "uninitOpenGLComponents", new Object[0]);
            try {
                this.mEGLCore.makeCurrent();
                PixelFrameRenderer pixelFrameRenderer = this.mPixelFrameRenderer;
                if (pixelFrameRenderer != null) {
                    pixelFrameRenderer.uninitialize();
                    this.mPixelFrameRenderer = null;
                }
            } catch (EGLException e11) {
                LiteavLog.e(this.mThrottlers.a("uninitError"), this.mTAG, "makeCurrent failed.", (Throwable) e11);
            }
            EGLCore.destroy(this.mEGLCore);
            this.mEGLCore = null;
        }
    }

    public void encodeFrame(PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            this.mEncodeFrameQueue.push(pixelFrame);
            runInEncodeThread(b.a(this));
        }
    }

    public void initialize() {
        LiteavLog.d(this.mTAG, "initialize");
        HandlerThread handlerThread = new HandlerThread("hw-video-encoder");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        this.mWorkHandler = new CustomHandler(looper);
        this.mEGLContextChecker = new EGLContextChecker(looper);
        this.mSurfaceInputVideoEncoder.initialize();
    }

    public boolean isInputQueueFull() {
        return this.mEncodeFrameQueue.size() > 0;
    }

    public void signalEndOfStream() {
        SurfaceInputVideoEncoder surfaceInputVideoEncoder = this.mSurfaceInputVideoEncoder;
        surfaceInputVideoEncoder.getClass();
        runInEncodeThread(c.a(surfaceInputVideoEncoder));
    }

    public boolean start(VideoEncodeParams videoEncodeParams, VideoEncoderInterface.VideoEncoderListener videoEncoderListener) {
        return runAndWaitDone(a.a(this, videoEncodeParams, videoEncoderListener), 5000) && this.mInputSurface != null;
    }

    public void stopSync(long j11) {
        LiteavLog.i(this.mTAG, "stop sync. wait time is ".concat(String.valueOf(j11)));
        runAndWaitDone(d.a(this, j11), j11);
    }

    public void uninitialize() {
        LiteavLog.d(this.mTAG, "uninitialize");
        runInEncodeThread(e.a(this));
    }
}
