package com.tencent.ugc;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.UGCFrameQueue;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.egl.EGLCore;
import com.tencent.ugc.videobase.egl.EGLException;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class UGCImageProvider implements UGCFrameQueue.UGCFrameQueueListener, UGCPixelFrameProvider {
    private static final int MAX_FRAME_SIZE = 5;
    private static final String TAG = "UGCImageProvider";
    private final List<Bitmap> mBitmapList;
    private int mCurrentFrameCount = 0;
    private FutureTask<Long> mDurationFuture;
    private long mDurationMs;
    private EGLCore mEGLCore;
    private final int mFps;
    private final int mFrameIntervalMs;
    private final UGCFrameQueue<List<PixelFrame>> mFrameQueue;
    private final Map<Bitmap, GLTexture> mGLTextureMap;
    private GLTexturePool mGLTexturePool;
    private long mMotionDurationMs = 500;
    private long mStayDurationMs = 1000;
    private final b mThrottlers = new b();
    private int mTotalFrameCount;
    private int mTransitionType = 1;
    private CustomHandler mWorkHandler;

    public UGCImageProvider(List<Bitmap> list, int i11) {
        LiteavLog.i(TAG, TAG);
        i11 = i11 <= 0 ? 20 : i11;
        this.mFps = i11;
        this.mFrameIntervalMs = 1000 / i11;
        this.mFrameQueue = new UGCFrameQueue<>();
        this.mGLTextureMap = new HashMap();
        this.mBitmapList = list;
    }

    private int clamp(int i11, int i12, int i13) {
        return i11 < i12 ? i12 : i11 > i13 ? i13 : i11;
    }

    private void clearGLTextureCache() {
        for (GLTexture next : this.mGLTextureMap.values()) {
            if (next != null) {
                next.release();
            }
        }
        this.mGLTextureMap.clear();
    }

    private void clearPixelFrameQueue() {
        for (List<PixelFrame> next : this.mFrameQueue.dequeueAll()) {
            if (next != null) {
                for (PixelFrame release : next) {
                    release.release();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void decodeBitmapFrame() {
        if (this.mEGLCore != null && this.mFrameQueue.size() <= 5) {
            if (this.mCurrentFrameCount >= this.mTotalFrameCount) {
                this.mFrameQueue.queue(UGCPixelFrameProvider.END_OF_STREAM);
                return;
            }
            ArrayList arrayList = new ArrayList();
            int i11 = this.mCurrentFrameCount;
            long j11 = ((long) i11) * ((long) this.mFrameIntervalMs);
            this.mCurrentFrameCount = i11 + 1;
            int clamp = clamp((int) (j11 / (this.mStayDurationMs + this.mMotionDurationMs)), 0, this.mBitmapList.size() - 1);
            arrayList.add(loadBitmapToPixelFrame(this.mBitmapList.get(clamp), j11));
            arrayList.add(loadBitmapToPixelFrame(this.mBitmapList.get(clamp(clamp + 1, 0, this.mBitmapList.size() - 1)), j11));
            this.mFrameQueue.queue(arrayList);
            CustomHandler customHandler = this.mWorkHandler;
            if (customHandler != null) {
                customHandler.removeCallbacks(dk.a(this));
                customHandler.post(dl.a(this));
            }
        }
    }

    private void initializeGLComponents() {
        EGLCore eGLCore = new EGLCore();
        this.mEGLCore = eGLCore;
        try {
            eGLCore.initialize(GlobalContextManager.getInstance().getGLContext(), (Surface) null, 128, 128);
            this.mEGLCore.makeCurrent();
            this.mGLTexturePool = new GLTexturePool();
        } catch (EGLException e11) {
            LiteavLog.e(this.mThrottlers.a("initGL"), TAG, "create EGLCore failed.", (Throwable) e11);
            this.mEGLCore = null;
        }
    }

    public static /* synthetic */ void lambda$initialize$0(UGCImageProvider uGCImageProvider) {
        uGCImageProvider.mFrameQueue.setUGCFrameQueueListener(uGCImageProvider);
        uGCImageProvider.initializeGLComponents();
    }

    public static /* synthetic */ void lambda$seekTo$4(UGCImageProvider uGCImageProvider, long j11) {
        uGCImageProvider.mCurrentFrameCount = (((int) (j11 - 1)) / uGCImageProvider.mFrameIntervalMs) + 1;
        uGCImageProvider.clearPixelFrameQueue();
        uGCImageProvider.runOnWorkThread(dc.a(uGCImageProvider));
    }

    public static /* synthetic */ void lambda$start$2(UGCImageProvider uGCImageProvider) {
        uGCImageProvider.setPictureTransitionInternal(uGCImageProvider.mTransitionType);
        uGCImageProvider.decodeBitmapFrame();
    }

    public static /* synthetic */ void lambda$stop$3(UGCImageProvider uGCImageProvider) {
        CustomHandler customHandler = uGCImageProvider.mWorkHandler;
        if (customHandler != null) {
            customHandler.removeCallbacks(dd.a(uGCImageProvider));
        }
    }

    public static /* synthetic */ void lambda$uninitialize$1(UGCImageProvider uGCImageProvider) {
        uGCImageProvider.clearPixelFrameQueue();
        uGCImageProvider.clearGLTextureCache();
        uGCImageProvider.uninitGLComponents();
        uGCImageProvider.mFrameQueue.setUGCFrameQueueListener((UGCFrameQueue.UGCFrameQueueListener) null);
        CustomHandler customHandler = uGCImageProvider.mWorkHandler;
        if (customHandler != null) {
            customHandler.quitLooper();
            uGCImageProvider.mWorkHandler = null;
        }
    }

    private PixelFrame loadBitmapToPixelFrame(Bitmap bitmap, long j11) {
        GLTexture gLTexture;
        try {
            EGLCore eGLCore = this.mEGLCore;
            if (eGLCore != null) {
                eGLCore.makeCurrent();
            }
        } catch (Exception e11) {
            LiteavLog.e(this.mThrottlers.a("make_current_fail"), TAG, "loadBitmapToPixelFrame makeCurrent fail".concat(String.valueOf(e11)), new Object[0]);
        }
        if (!this.mGLTextureMap.containsKey(bitmap)) {
            gLTexture = this.mGLTexturePool.obtain(bitmap.getWidth(), bitmap.getHeight());
            gLTexture.setColorFormat(GLConstants.ColorRange.VIDEO_RANGE, GLConstants.ColorSpace.BT601);
            OpenGlUtils.loadTexture(bitmap, gLTexture.getId(), false);
            this.mGLTextureMap.put(bitmap, gLTexture);
        } else {
            gLTexture = this.mGLTextureMap.get(bitmap);
        }
        PixelFrame wrap = gLTexture.wrap(GlobalContextManager.getInstance().getGLContext());
        wrap.setTimestamp(j11);
        return wrap;
    }

    private boolean runOnWorkThread(Runnable runnable) {
        CustomHandler customHandler = this.mWorkHandler;
        if (customHandler != null) {
            return customHandler.runOrPost(runnable, 0);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void setPictureTransitionInternal(int i11) {
        this.mTransitionType = i11;
        this.mStayDurationMs = UGCTransitionRules.getStayDurationMs(i11);
        this.mMotionDurationMs = UGCTransitionRules.getMotionDurationMs(i11);
        List<Bitmap> list = this.mBitmapList;
        if (list != null) {
            if (i11 == 5 || i11 == 4) {
                this.mDurationMs = ((long) list.size()) * (this.mStayDurationMs + this.mMotionDurationMs);
            } else {
                long j11 = this.mStayDurationMs;
                long j12 = this.mMotionDurationMs;
                this.mDurationMs = (((long) list.size()) * (j11 + j12)) - j12;
            }
            this.mTotalFrameCount = (int) ((this.mDurationMs / 1000) * ((long) this.mFps));
        }
    }

    private void uninitGLComponents() {
        if (this.mEGLCore != null) {
            try {
                GLTexturePool gLTexturePool = this.mGLTexturePool;
                if (gLTexturePool != null) {
                    gLTexturePool.evictAll();
                    this.mGLTexturePool.destroy();
                    this.mGLTexturePool = null;
                }
                this.mEGLCore.makeCurrent();
            } catch (EGLException e11) {
                LiteavLog.e(this.mThrottlers.a("uninitGL"), TAG, "EGLCore destroy failed.", (Throwable) e11);
            }
            EGLCore.destroy(this.mEGLCore);
            this.mEGLCore = null;
        }
    }

    public long getDuration() {
        if (this.mDurationFuture == null) {
            return 0;
        }
        Long l11 = 0L;
        try {
            l11 = this.mDurationFuture.get(500, TimeUnit.MILLISECONDS);
        } catch (Exception e11) {
            LiteavLog.w(TAG, "getDuration future task exception: ".concat(String.valueOf(e11)));
        }
        return l11.longValue();
    }

    public UGCFrameQueue<List<PixelFrame>> getFrameQueue() {
        return this.mFrameQueue;
    }

    public void initialize() {
        LiteavLog.i(TAG, "initialize");
        synchronized (this) {
            if (this.mWorkHandler != null) {
                LiteavLog.w(TAG, "UGCPixelFrameProvider is initialized");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("ugc-image-frame-provider");
            handlerThread.start();
            this.mWorkHandler = new CustomHandler(handlerThread.getLooper());
            runOnWorkThread(db.a(this));
        }
    }

    public void onFrameDequeued() {
        runOnWorkThread(dj.a(this));
    }

    public void seekTo(long j11, boolean z11) {
        runOnWorkThread(dh.a(this, j11));
    }

    public void setMaxBufferFrameCount(int i11) {
    }

    public void setPictureTransition(int i11) {
        LiteavLog.i(TAG, "setPictureTransition type = ".concat(String.valueOf(i11)));
        FutureTask<Long> futureTask = new FutureTask<>(di.a(this, i11));
        this.mDurationFuture = futureTask;
        runOnWorkThread(futureTask);
    }

    public void setPlayEndPts(long j11) {
    }

    public void setReverse(boolean z11) {
    }

    public void start() {
        Log.i(TAG, "Start", new Object[0]);
        runOnWorkThread(df.a(this));
    }

    public void stop() {
        LiteavLog.i(TAG, "stop");
        runOnWorkThread(dg.a(this));
    }

    public void uninitialize() {
        LiteavLog.i(TAG, "unInitialize");
        runOnWorkThread(de.a(this));
    }
}
