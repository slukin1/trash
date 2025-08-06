package com.tencent.ugc;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.liteav.base.b.b;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.TXVideoEditer;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.egl.EGLCore;
import com.tencent.ugc.videobase.egl.EGLException;
import com.tencent.ugc.videobase.frame.GLFrameBuffer;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.frame.PixelFrameRenderer;
import com.tencent.ugc.videobase.utils.CollectionUtils;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UGCThumbnailGenerator {
    private EGLCore mEGLCore = null;
    private final GLFrameBuffer mGLFrameBuffer = new GLFrameBuffer();
    private GLTexturePool mGLTexturePool;
    private int mGenerateIndex = 0;
    private CustomHandler mHandler;
    private boolean mIsInitialized;
    private final UGCMediaListSource mMediaListSource;
    private PixelFrameRenderer mPixelFrameRender;
    private Object mSharedContext = null;
    private String mSourcePath;
    private String mTag = "ThumbnailGenerator_";
    private final b mThrottlers = new b();
    private UGCThumbnailGenerateParams mThumbnailGenerateInfo;
    private TXVideoEditer.TXThumbnailListener mThumbnailListener;

    public static class UGCThumbnailGenerateParams {
        public boolean fast;
        public int height;
        public int thumbnailCount;
        public List<Long> thumbnailPtsList;
        public int width;
    }

    public UGCThumbnailGenerator() {
        UGCMediaListSource uGCMediaListSource = new UGCMediaListSource();
        this.mMediaListSource = uGCMediaListSource;
        uGCMediaListSource.setNeedAudioSource(false);
        uGCMediaListSource.setMaxFrameSize(1);
        this.mTag += hashCode();
    }

    public static List<Long> calculateThumbnailList(int i11, long j11, long j12, long j13) {
        if (j13 < 0 || i11 == 0) {
            LiteavLog.w("calculateThumbnailList", "param error: duration= " + j13 + ",count= " + i11);
            return null;
        }
        LiteavLog.i("calculateThumbnailList", "calculateThumbnailList startTimeMs : " + j11 + ", endTimeMs : " + j12 + "  duration:" + j13);
        long min = Math.min(j12, j13);
        ArrayList arrayList = new ArrayList();
        long j14 = min - j11;
        if (j14 > 0) {
            j13 = j14;
        }
        long j15 = j13 / ((long) i11);
        for (int i12 = 0; i12 < i11; i12++) {
            long j16 = (((long) i12) * j15) + j11;
            if (min > 0) {
                j16 = Math.min(j16, min);
            }
            arrayList.add(Long.valueOf(j16));
        }
        return arrayList;
    }

    private Bitmap getBitmapFromTexture(GLTexture gLTexture) {
        this.mGLFrameBuffer.attachTexture(gLTexture.getId());
        this.mGLFrameBuffer.bindToContext();
        UGCThumbnailGenerateParams uGCThumbnailGenerateParams = this.mThumbnailGenerateInfo;
        ByteBuffer order = ByteBuffer.allocateDirect(uGCThumbnailGenerateParams.width * uGCThumbnailGenerateParams.height * 4).order(ByteOrder.nativeOrder());
        order.position(0);
        UGCThumbnailGenerateParams uGCThumbnailGenerateParams2 = this.mThumbnailGenerateInfo;
        OpenGlUtils.readPixels(0, 0, uGCThumbnailGenerateParams2.width, uGCThumbnailGenerateParams2.height, order);
        order.position(0);
        UGCThumbnailGenerateParams uGCThumbnailGenerateParams3 = this.mThumbnailGenerateInfo;
        Bitmap createBitmap = Bitmap.createBitmap(uGCThumbnailGenerateParams3.width, uGCThumbnailGenerateParams3.height, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(order);
        this.mGLFrameBuffer.unbindFromContext();
        this.mGLFrameBuffer.detachTexture();
        return createBitmap;
    }

    /* access modifiers changed from: private */
    public void getNextThumbnail() {
        List<Long> list;
        int i11;
        GLTexturePool gLTexturePool;
        UGCThumbnailGenerateParams uGCThumbnailGenerateParams = this.mThumbnailGenerateInfo;
        if (uGCThumbnailGenerateParams == null || (list = uGCThumbnailGenerateParams.thumbnailPtsList) == null || list.size() <= (i11 = this.mGenerateIndex)) {
            String str = this.mTag;
            LiteavLog.i(str, "generate runnable: mThumbnailGenerateInfo= " + this.mThumbnailGenerateInfo + " mGenerateIndex = " + this.mGenerateIndex);
            return;
        }
        List<Long> list2 = this.mThumbnailGenerateInfo.thumbnailPtsList;
        this.mGenerateIndex = i11 + 1;
        long longValue = list2.get(i11).longValue();
        System.currentTimeMillis();
        if (this.mThumbnailGenerateInfo.fast) {
            this.mMediaListSource.impreciseSeekTo(longValue);
        } else {
            this.mMediaListSource.seekTo(longValue);
        }
        List<PixelFrame> readNextVideoFrame = this.mMediaListSource.readNextVideoFrame();
        if (CollectionUtils.isEmpty((Collection<?>) readNextVideoFrame) || readNextVideoFrame.get(0) == null) {
            LiteavLog.i(this.mTag, "readNextVideoFrame return null.");
            return;
        }
        PixelFrame pixelFrame = readNextVideoFrame.get(0);
        if (this.mEGLCore == null || !CommonUtil.equals(this.mSharedContext, pixelFrame.getGLContext())) {
            uninitOpenGLComponents();
            Object gLContext = pixelFrame.getGLContext();
            UGCThumbnailGenerateParams uGCThumbnailGenerateParams2 = this.mThumbnailGenerateInfo;
            initOpenGLComponents(gLContext, uGCThumbnailGenerateParams2.width, uGCThumbnailGenerateParams2.height);
        }
        if (this.mEGLCore == null || (gLTexturePool = this.mGLTexturePool) == null) {
            LiteavLog.e(this.mThrottlers.a("NoEGLCore"), this.mTag, "EGLCore or GLTexturePool is null", new Object[0]);
            pixelFrame.release();
            return;
        }
        UGCThumbnailGenerateParams uGCThumbnailGenerateParams3 = this.mThumbnailGenerateInfo;
        GLTexture obtain = gLTexturePool.obtain(uGCThumbnailGenerateParams3.width, uGCThumbnailGenerateParams3.height);
        obtain.setColorFormat(pixelFrame.getColorRange(), pixelFrame.getColorSpace());
        this.mPixelFrameRender.renderFrame(pixelFrame, GLConstants.GLScaleType.CENTER_CROP, obtain);
        Bitmap bitmapFromTexture = getBitmapFromTexture(obtain);
        TXVideoEditer.TXThumbnailListener tXThumbnailListener = this.mThumbnailListener;
        if (tXThumbnailListener != null) {
            tXThumbnailListener.onThumbnail(this.mGenerateIndex, longValue, bitmapFromTexture);
        }
        obtain.release();
        pixelFrame.release();
        if (list2.size() > this.mGenerateIndex) {
            this.mHandler.post(gl.a(this));
        }
    }

    private void initOpenGLComponents(Object obj, int i11, int i12) {
        LiteavLog.i(this.mThrottlers.a("initGL"), this.mTag, "initOpenGLComponents ".concat(String.valueOf(obj)), new Object[0]);
        if (this.mEGLCore == null) {
            EGLCore eGLCore = new EGLCore();
            this.mEGLCore = eGLCore;
            try {
                eGLCore.initialize(obj, (Surface) null, 128, 128);
                this.mGLTexturePool = new GLTexturePool();
                this.mPixelFrameRender = new PixelFrameRenderer(i11, i12);
                this.mGLFrameBuffer.initialize();
                this.mSharedContext = obj;
            } catch (EGLException e11) {
                this.mEGLCore = null;
                LiteavLog.e(this.mThrottlers.a("initGLError"), this.mTag, "EGLCore create failed.", (Throwable) e11);
            }
        }
    }

    public static /* synthetic */ void lambda$setVideoSourceList$1(UGCThumbnailGenerator uGCThumbnailGenerator, List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            LiteavLog.i(uGCThumbnailGenerator.mTag, "setVideoSourceList ".concat(String.valueOf((String) it2.next())));
        }
        uGCThumbnailGenerator.mMediaListSource.setVideoSources(list);
        uGCThumbnailGenerator.mSourcePath = (String) list.get(0);
    }

    public static /* synthetic */ void lambda$start$3(UGCThumbnailGenerator uGCThumbnailGenerator, UGCThumbnailGenerateParams uGCThumbnailGenerateParams, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        if (uGCThumbnailGenerateParams == null || CollectionUtils.isEmpty((Collection<?>) uGCThumbnailGenerateParams.thumbnailPtsList)) {
            LiteavLog.w(uGCThumbnailGenerator.mTag, "start param error!");
            return;
        }
        String str = uGCThumbnailGenerator.mTag;
        LiteavLog.i(str, "start width = " + uGCThumbnailGenerateParams.width + " height = " + uGCThumbnailGenerateParams.height);
        uGCThumbnailGenerator.mGenerateIndex = 0;
        uGCThumbnailGenerator.mThumbnailGenerateInfo = uGCThumbnailGenerateParams;
        uGCThumbnailGenerator.mThumbnailListener = tXThumbnailListener;
        uGCThumbnailGenerator.getNextThumbnail();
    }

    public static /* synthetic */ void lambda$stop$4(UGCThumbnailGenerator uGCThumbnailGenerator) {
        LiteavLog.i(uGCThumbnailGenerator.mTag, "stop");
        uGCThumbnailGenerator.mThumbnailGenerateInfo = null;
        uGCThumbnailGenerator.mThumbnailListener = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        r2.mMediaListSource.uninitialize();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        r0.quitLooper();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void lambda$uninitialize$0(com.tencent.ugc.UGCThumbnailGenerator r2) {
        /*
            java.lang.String r0 = r2.mTag
            java.lang.String r1 = "unInitialize"
            com.tencent.liteav.base.util.LiteavLog.i(r0, r1)
            r2.uninitOpenGLComponents()
            monitor-enter(r2)
            boolean r0 = r2.mIsInitialized     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = r2.mTag     // Catch:{ all -> 0x002c }
            java.lang.String r1 = "already uninitialize."
            com.tencent.liteav.base.util.LiteavLog.w(r0, r1)     // Catch:{ all -> 0x002c }
            monitor-exit(r2)     // Catch:{ all -> 0x002c }
            return
        L_0x0018:
            com.tencent.liteav.base.util.CustomHandler r0 = r2.mHandler     // Catch:{ all -> 0x002c }
            r1 = 0
            r2.mHandler = r1     // Catch:{ all -> 0x002c }
            r1 = 0
            r2.mIsInitialized = r1     // Catch:{ all -> 0x002c }
            monitor-exit(r2)     // Catch:{ all -> 0x002c }
            com.tencent.ugc.UGCMediaListSource r2 = r2.mMediaListSource
            r2.uninitialize()
            if (r0 == 0) goto L_0x002b
            r0.quitLooper()
        L_0x002b:
            return
        L_0x002c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x002c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.UGCThumbnailGenerator.lambda$uninitialize$0(com.tencent.ugc.UGCThumbnailGenerator):void");
    }

    private boolean runOnThumbnailThread(Runnable runnable) {
        CustomHandler customHandler = this.mHandler;
        if (!this.mIsInitialized || customHandler == null) {
            return false;
        }
        return customHandler.runOrPost(runnable);
    }

    private void uninitOpenGLComponents() {
        if (this.mEGLCore != null) {
            LiteavLog.i(this.mThrottlers.a("uninitGL"), this.mTag, "uninitOpenGLComponents", new Object[0]);
            this.mEGLCore.unmakeCurrent();
            GLTexturePool gLTexturePool = this.mGLTexturePool;
            if (gLTexturePool != null) {
                gLTexturePool.destroy();
                this.mGLTexturePool = null;
            }
            PixelFrameRenderer pixelFrameRenderer = this.mPixelFrameRender;
            if (pixelFrameRenderer != null) {
                pixelFrameRenderer.uninitialize();
                this.mPixelFrameRender = null;
            }
            this.mGLFrameBuffer.uninitialize();
            EGLCore.destroy(this.mEGLCore);
            this.mEGLCore = null;
        }
    }

    public void initialize() {
        LiteavLog.i(this.mTag, "initialize");
        synchronized (this) {
            if (this.mIsInitialized) {
                LiteavLog.w(this.mTag, "already initialized.");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("thumbnailG_" + hashCode());
            handlerThread.start();
            this.mHandler = new CustomHandler(handlerThread.getLooper());
            this.mIsInitialized = true;
            UGCMediaListSource uGCMediaListSource = this.mMediaListSource;
            uGCMediaListSource.getClass();
            runOnThumbnailThread(gg.a(uGCMediaListSource));
        }
    }

    public void setVideoSourceList(List<String> list) {
        runOnThumbnailThread(gi.a(this, list));
    }

    public void setVideoSourceRange(long j11, long j12) {
        runOnThumbnailThread(gj.a(this, j11, j12));
    }

    public void start(UGCThumbnailGenerateParams uGCThumbnailGenerateParams, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        runOnThumbnailThread(gk.a(this, uGCThumbnailGenerateParams, tXThumbnailListener));
    }

    public void stop() {
        runOnThumbnailThread(gm.a(this));
    }

    public void uninitialize() {
        runOnThumbnailThread(gh.a(this));
    }
}
