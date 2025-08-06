package com.tencent.ugc.preprocessor;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.view.Surface;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.beauty.gpufilters.TXCGPUGaussianBlurFilter;
import com.tencent.ugc.beauty.gpufilters.TXCGPUGreenScreenFilter;
import com.tencent.ugc.beauty.gpufilters.TXCGPULookupFilterGroup;
import com.tencent.ugc.beauty.gpufilters.TXCGPUWatermarkFilter;
import com.tencent.ugc.beauty.gpufilters.WatermarkItem;
import com.tencent.ugc.videobase.base.AIDetectListener;
import com.tencent.ugc.videobase.base.DetectResult;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.chain.GPUInterceptor;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilterChain;
import com.tencent.ugc.videobase.egl.EGLCore;
import com.tencent.ugc.videobase.egl.EGLException;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.frame.PixelFrameRenderer;
import com.tencent.ugc.videobase.utils.DelayQueue;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import com.tencent.ugc.videobase.videobase.ConvertParams;
import com.tencent.ugc.videobase.videobase.FrameConverter;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class GPUPreprocessor implements AIDetectListener {
    private final FrameConverter mAfterWatermarkConverter = new FrameConverter();
    private final Context mAppContext;
    private final BeautyProcessor mBeautyProcessor;
    private FrameConverter mBeforeWatermarkConverter;
    private GPUInterceptor mBeforeWatermarkInterceptor;
    private Object mEGLContext;
    /* access modifiers changed from: private */
    public EGLCore mEGLCore;
    private GLTexturePool mGLTexturePool;
    private final TXCGPUImageFilterChain mGPUImageFilterChain = new TXCGPUImageFilterChain();
    private final TXCGPUImageFilter[] mGPUImageFilters = new TXCGPUImageFilter[b.values().length];
    private Boolean mHasFaceLastFrame = null;
    private final List<c> mNeedWatermarkListeners = new ArrayList();
    private final List<c> mNoNeedWatermarkListeners = new ArrayList();
    private final FloatBuffer mNormalCubeVerticesBuffer;
    private final FloatBuffer mNormalTextureCoordsBuffer;
    private PixelFrameRenderer mPixelFrameRenderer;
    private int mProcessHeight = 128;
    private int mProcessWidth = 128;
    private final DelayQueue mRunOnDrawQueue = new DelayQueue();
    private final String mTAG = ("GPUPreprocessor_" + hashCode());
    private final com.tencent.liteav.base.b.b mThrottlers = new com.tencent.liteav.base.b.b();

    /* renamed from: com.tencent.ugc.preprocessor.GPUPreprocessor$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50655a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tencent.ugc.preprocessor.GPUPreprocessor$b[] r0 = com.tencent.ugc.preprocessor.GPUPreprocessor.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50655a = r0
                com.tencent.ugc.preprocessor.GPUPreprocessor$b r1 = com.tencent.ugc.preprocessor.GPUPreprocessor.b.WATERMARK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50655a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.ugc.preprocessor.GPUPreprocessor$b r1 = com.tencent.ugc.preprocessor.GPUPreprocessor.b.GAUSSIAN_BLUR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f50655a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.ugc.preprocessor.GPUPreprocessor$b r1 = com.tencent.ugc.preprocessor.GPUPreprocessor.b.LOOK_UP_FILTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f50655a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.ugc.preprocessor.GPUPreprocessor$b r1 = com.tencent.ugc.preprocessor.GPUPreprocessor.b.GREEN_SCREEN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.preprocessor.GPUPreprocessor.AnonymousClass1.<clinit>():void");
        }
    }

    public static class a extends GPUInterceptor {

        /* renamed from: a  reason: collision with root package name */
        private final FrameConverter f50656a;

        public a(FrameConverter frameConverter) {
            this.f50656a = frameConverter;
        }

        public final GLTexture intercept(long j11, GLTexture gLTexture) {
            FrameConverter frameConverter = this.f50656a;
            if (frameConverter != null) {
                frameConverter.processFrame(j11, gLTexture);
            }
            return gLTexture;
        }
    }

    public enum b {
        MOTION_BASE,
        GAUSSIAN_BLUR,
        LOOK_UP_FILTER,
        GREEN_SCREEN,
        WATERMARK
    }

    public class c implements FrameConverter.FrameConvertListener {

        /* renamed from: a  reason: collision with root package name */
        public int f50663a;

        /* renamed from: b  reason: collision with root package name */
        public ConvertParams f50664b;

        /* renamed from: c  reason: collision with root package name */
        public GLConstants.PixelBufferType f50665c;

        /* renamed from: d  reason: collision with root package name */
        public GLConstants.PixelFormatType f50666d;

        /* renamed from: e  reason: collision with root package name */
        public VideoPreprocessorListener f50667e;

        public c(int i11, ConvertParams convertParams, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, VideoPreprocessorListener videoPreprocessorListener) {
            this.f50663a = i11;
            this.f50664b = convertParams;
            this.f50666d = pixelFormatType;
            this.f50665c = pixelBufferType;
            this.f50667e = videoPreprocessorListener;
        }

        public final void onFrameConverted(int i11, PixelFrame pixelFrame) {
            if (this.f50667e != null && GPUPreprocessor.this.mEGLCore != null) {
                this.f50667e.didProcessFrame(i11, pixelFrame);
                boolean unused = GPUPreprocessor.this.makeCurrent();
            }
        }
    }

    public GPUPreprocessor(Context context, BeautyProcessor beautyProcessor) {
        this.mAppContext = context.getApplicationContext();
        this.mBeautyProcessor = beautyProcessor;
        this.mNormalCubeVerticesBuffer = OpenGlUtils.createNormalCubeVerticesBuffer();
        this.mNormalTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
        beautyProcessor.setAIDetectListener(this);
    }

    private void addListenerToList(c cVar, List<c> list) {
        for (c next : list) {
            if (next.f50663a == cVar.f50663a && next.f50667e == cVar.f50667e) {
                return;
            }
        }
        list.add(cVar);
    }

    private TXCGPUImageFilter createFilter(b bVar) {
        int i11 = AnonymousClass1.f50655a[bVar.ordinal()];
        if (i11 == 1) {
            return new TXCGPUWatermarkFilter();
        }
        if (i11 == 2) {
            return new TXCGPUGaussianBlurFilter(0.8f);
        }
        if (i11 == 3) {
            return new TXCGPULookupFilterGroup();
        }
        if (i11 == 4) {
            return new TXCGPUGreenScreenFilter(this.mAppContext);
        }
        throw new RuntimeException("unknown filter type");
    }

    private void disableFilter(b bVar) {
        TXCGPUImageFilter tXCGPUImageFilter;
        if (this.mGPUImageFilters[bVar.ordinal()] != null && (tXCGPUImageFilter = this.mGPUImageFilters[bVar.ordinal()]) != null) {
            this.mGPUImageFilters[bVar.ordinal()] = null;
            tXCGPUImageFilter.uninitialize();
            updateFilterChain();
        }
    }

    private <T> T enableFilter(b bVar) {
        if (this.mGPUImageFilters[bVar.ordinal()] != null) {
            return this.mGPUImageFilters[bVar.ordinal()];
        }
        T createFilter = createFilter(bVar);
        createFilter.initialize(this.mGLTexturePool);
        createFilter.onOutputSizeChanged(this.mProcessWidth, this.mProcessHeight);
        this.mGPUImageFilters[bVar.ordinal()] = createFilter;
        updateFilterChain();
        return createFilter;
    }

    private <T> T getFilter(b bVar) {
        return this.mGPUImageFilters[bVar.ordinal()];
    }

    private void initializeGLComponents(Object obj) throws EGLException {
        LiteavLog.i(this.mThrottlers.a("initGL"), this.mTAG, "initialize internal, eglContextFromPixelFrame: %s", obj);
        EGLCore eGLCore = new EGLCore();
        this.mEGLCore = eGLCore;
        eGLCore.initialize(obj, (Surface) null, 128, 128);
        this.mEGLCore.makeCurrent();
        GLTexturePool gLTexturePool = new GLTexturePool();
        this.mGLTexturePool = gLTexturePool;
        this.mAfterWatermarkConverter.initialize(gLTexturePool);
        this.mBeautyProcessor.initialize(this.mGLTexturePool);
        updateFilterChain();
    }

    public static /* synthetic */ void lambda$setFilterGroupImages$5(GPUPreprocessor gPUPreprocessor, Bitmap bitmap, Bitmap bitmap2, float f11, float f12, float f13) {
        if (bitmap == null && bitmap2 == null) {
            gPUPreprocessor.disableFilter(b.LOOK_UP_FILTER);
        } else {
            ((TXCGPULookupFilterGroup) gPUPreprocessor.enableFilter(b.LOOK_UP_FILTER)).setBitmap(f11, bitmap, f12, bitmap2, f13);
        }
    }

    public static /* synthetic */ void lambda$setFilterMixLevel$4(GPUPreprocessor gPUPreprocessor, float f11) {
        TXCGPULookupFilterGroup tXCGPULookupFilterGroup = (TXCGPULookupFilterGroup) gPUPreprocessor.getFilter(b.LOOK_UP_FILTER);
        if (tXCGPULookupFilterGroup != null) {
            tXCGPULookupFilterGroup.setIntensity(f11);
        }
    }

    public static /* synthetic */ void lambda$setGaussianBlurLevel$3(GPUPreprocessor gPUPreprocessor, float f11) {
        if (f11 < 0.0f) {
            gPUPreprocessor.disableFilter(b.GAUSSIAN_BLUR);
            return;
        }
        TXCGPUGaussianBlurFilter tXCGPUGaussianBlurFilter = (TXCGPUGaussianBlurFilter) gPUPreprocessor.enableFilter(b.GAUSSIAN_BLUR);
        if (tXCGPUGaussianBlurFilter != null) {
            tXCGPUGaussianBlurFilter.setBlurSize(f11);
        }
    }

    public static /* synthetic */ void lambda$setGreenScreenFile$6(GPUPreprocessor gPUPreprocessor, String str, boolean z11) {
    }

    public static /* synthetic */ void lambda$setGreenScreenParam$7(GPUPreprocessor gPUPreprocessor, GLConstants.GLScaleType gLScaleType, boolean z11) {
        TXCGPUGreenScreenFilter tXCGPUGreenScreenFilter = (TXCGPUGreenScreenFilter) gPUPreprocessor.getFilter(b.GREEN_SCREEN);
        if (tXCGPUGreenScreenFilter != null) {
            tXCGPUGreenScreenFilter.setGreenScreenParam(gLScaleType, z11);
        }
    }

    public static /* synthetic */ void lambda$setInterceptorBeforeWatermark$0(GPUPreprocessor gPUPreprocessor, GPUInterceptor gPUInterceptor) {
        gPUPreprocessor.mBeforeWatermarkInterceptor = gPUInterceptor;
        gPUPreprocessor.updateFilterChain();
    }

    public static /* synthetic */ void lambda$setWatermark$1(GPUPreprocessor gPUPreprocessor, Bitmap bitmap, float f11, float f12, float f13) {
        if (bitmap == null) {
            gPUPreprocessor.disableFilter(b.WATERMARK);
            return;
        }
        TXCGPUWatermarkFilter tXCGPUWatermarkFilter = (TXCGPUWatermarkFilter) gPUPreprocessor.enableFilter(b.WATERMARK);
        tXCGPUWatermarkFilter.enableWatermark(true);
        tXCGPUWatermarkFilter.setWatermark(bitmap, f11, f12, f13);
    }

    public static /* synthetic */ void lambda$setWatermarkList$2(GPUPreprocessor gPUPreprocessor, List list) {
        if (list == null || list.isEmpty()) {
            gPUPreprocessor.disableFilter(b.WATERMARK);
            return;
        }
        TXCGPUWatermarkFilter tXCGPUWatermarkFilter = (TXCGPUWatermarkFilter) gPUPreprocessor.enableFilter(b.WATERMARK);
        tXCGPUWatermarkFilter.enableWatermark(true);
        tXCGPUWatermarkFilter.setWaterMarkList(list);
    }

    /* access modifiers changed from: private */
    public boolean makeCurrent() {
        try {
            EGLCore eGLCore = this.mEGLCore;
            if (eGLCore != null) {
                eGLCore.makeCurrent();
                return true;
            }
        } catch (EGLException e11) {
            LiteavLog.e(this.mThrottlers.a("makeCurrent"), this.mTAG, "makeCurrent failed. ".concat(String.valueOf(e11)), new Object[0]);
        }
        return false;
    }

    private void notifyAIDetectResult(DetectResult detectResult, List<c> list) {
        VideoPreprocessorListener videoPreprocessorListener;
        for (c next : list) {
            if (!(next == null || (videoPreprocessorListener = next.f50667e) == null)) {
                videoPreprocessorListener.didDetectFacePoints(next.f50663a, detectResult);
            }
        }
    }

    private void registerListenersToRightConverter() {
        if (makeCurrent()) {
            if (this.mGPUImageFilters[b.WATERMARK.ordinal()] != null) {
                if (this.mBeforeWatermarkConverter == null) {
                    FrameConverter frameConverter = new FrameConverter();
                    this.mBeforeWatermarkConverter = frameConverter;
                    frameConverter.initialize(this.mGLTexturePool);
                }
                for (c next : this.mNoNeedWatermarkListeners) {
                    this.mAfterWatermarkConverter.removeListener(next.f50663a, next);
                    this.mBeforeWatermarkConverter.addListener(next.f50664b, next.f50665c, next.f50666d, next.f50663a, next);
                }
            } else {
                for (c next2 : this.mNoNeedWatermarkListeners) {
                    FrameConverter frameConverter2 = this.mBeforeWatermarkConverter;
                    if (frameConverter2 != null) {
                        frameConverter2.removeListener(next2.f50663a, next2);
                    }
                    this.mAfterWatermarkConverter.addListener(next2.f50664b, next2.f50665c, next2.f50666d, next2.f50663a, next2);
                }
                FrameConverter frameConverter3 = this.mBeforeWatermarkConverter;
                if (frameConverter3 != null) {
                    frameConverter3.uninitialize();
                    this.mBeforeWatermarkConverter = null;
                }
            }
            for (c next3 : this.mNeedWatermarkListeners) {
                this.mAfterWatermarkConverter.addListener(next3.f50664b, next3.f50665c, next3.f50666d, next3.f50663a, next3);
            }
        }
    }

    private c removeListenerFromList(int i11, VideoPreprocessorListener videoPreprocessorListener, List<c> list) {
        for (int i12 = 0; i12 < list.size(); i12++) {
            c cVar = list.get(i12);
            if (cVar.f50663a == i11 && cVar.f50667e == videoPreprocessorListener) {
                list.remove(i12);
                return cVar;
            }
        }
        return null;
    }

    private void setGLContext(Object obj) {
        if (!CommonUtil.equals(this.mEGLContext, obj)) {
            this.mEGLContext = obj;
            uninitializeGLComponents();
            LiteavLog.i(this.mTAG, "set unique eglcore: %s", obj);
        }
    }

    private void updateFilterChain() {
        this.mGPUImageFilterChain.removeAllFilterAndInterceptor();
        this.mGPUImageFilterChain.uninitialize();
        registerListenersToRightConverter();
        for (b bVar : b.values()) {
            if (bVar == b.WATERMARK) {
                this.mGPUImageFilterChain.addInterceptor(this.mBeforeWatermarkInterceptor);
                this.mGPUImageFilterChain.addInterceptor(new a(this.mBeforeWatermarkConverter));
            }
            if (bVar == b.MOTION_BASE) {
                this.mGPUImageFilterChain.addFilter(this.mBeautyProcessor);
            } else {
                this.mGPUImageFilterChain.addFilter(this.mGPUImageFilters[bVar.ordinal()]);
            }
        }
        this.mGPUImageFilterChain.addInterceptor(new a(this.mAfterWatermarkConverter));
        this.mGPUImageFilterChain.initialize(this.mGLTexturePool);
        this.mGPUImageFilterChain.onOutputSizeChanged(this.mProcessWidth, this.mProcessHeight);
    }

    public BeautyProcessor getBeautyProcessor() {
        return this.mBeautyProcessor;
    }

    public void onDetectFinished(DetectResult detectResult) {
        this.mHasFaceLastFrame = Boolean.valueOf(detectResult.faceCount > 0);
        notifyAIDetectResult(detectResult, this.mNoNeedWatermarkListeners);
        notifyAIDetectResult(detectResult, this.mNeedWatermarkListeners);
    }

    public void processFrame(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType) {
        PixelFrame pixelFrame2;
        pixelFrame.getGLContext();
        setGLContext(pixelFrame.getGLContext());
        try {
            if (this.mEGLCore == null) {
                initializeGLComponents(pixelFrame.getGLContext());
            }
            this.mEGLCore.makeCurrent();
            this.mRunOnDrawQueue.rerun();
            if (this.mPixelFrameRenderer == null) {
                this.mPixelFrameRenderer = new PixelFrameRenderer(this.mProcessWidth, this.mProcessHeight);
            }
            OpenGlUtils.glViewport(0, 0, this.mProcessWidth, this.mProcessHeight);
            if (pixelFrame.getHeight() == this.mProcessHeight && pixelFrame.getWidth() == this.mProcessWidth && pixelFrame.getRotation() == k.NORMAL && !pixelFrame.isMirrorVertical() && !pixelFrame.isMirrorHorizontal() && pixelFrame.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D) {
                pixelFrame.retain();
                pixelFrame2 = pixelFrame;
            } else {
                GLTexture obtain = this.mGLTexturePool.obtain(this.mProcessWidth, this.mProcessHeight);
                obtain.setColorFormat(pixelFrame.getColorRange(), pixelFrame.getColorSpace());
                this.mPixelFrameRenderer.renderFrame(pixelFrame, gLScaleType, obtain);
                pixelFrame2 = obtain.wrap(this.mEGLCore.getEglContext());
                obtain.release();
            }
            this.mGPUImageFilterChain.setTimestamp(pixelFrame.getTimestamp());
            GLTexture obtain2 = this.mGLTexturePool.obtain(this.mProcessWidth, this.mProcessHeight);
            obtain2.setColorFormat(pixelFrame2.getColorRange(), pixelFrame2.getColorSpace());
            obtain2.setMetaData(pixelFrame.getMetaData());
            this.mGPUImageFilterChain.setColorFormat(obtain2.getColorRange(), obtain2.getColorSpace());
            this.mGPUImageFilterChain.onDraw(pixelFrame2.getTextureId(), obtain2, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
            pixelFrame2.release();
            obtain2.release();
            while (true) {
                int glGetError = GLES20.glGetError();
                if (glGetError != 0) {
                    com.tencent.liteav.base.b.a a11 = this.mThrottlers.a("processFrame");
                    String str = this.mTAG;
                    LiteavLog.e(a11, str, "GL error occurred when preprocess frame, error :" + GLUtils.getEGLErrorString(glGetError), new Object[0]);
                } else {
                    return;
                }
            }
        } catch (EGLException e11) {
            com.tencent.liteav.base.b.a a12 = this.mThrottlers.a("make");
            String str2 = this.mTAG;
            LiteavLog.e(a12, str2, "initializeEGL failed. " + e11.getMessage(), new Object[0]);
            uninitializeGLComponents();
        }
    }

    public void registerVideoProcessedListener(int i11, ConvertParams convertParams, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, boolean z11, VideoPreprocessorListener videoPreprocessorListener) {
        c cVar = new c(i11, convertParams, pixelBufferType, pixelFormatType, videoPreprocessorListener);
        if (!z11) {
            addListenerToList(cVar, this.mNoNeedWatermarkListeners);
        } else {
            addListenerToList(cVar, this.mNeedWatermarkListeners);
        }
        registerListenersToRightConverter();
        LiteavLog.i(this.mTAG, "register listener, identity:%d, bufferType:%s, formatType:%s, withWatermark:%b, listener:%s", Integer.valueOf(i11), pixelBufferType, pixelFormatType, Boolean.valueOf(z11), videoPreprocessorListener);
    }

    public void setFilterGroupImages(float f11, Bitmap bitmap, float f12, Bitmap bitmap2, float f13) {
        this.mRunOnDrawQueue.add(j.a(this, bitmap, bitmap2, f11, f12, f13));
    }

    public void setFilterMixLevel(float f11) {
        this.mRunOnDrawQueue.add(i.a(this, f11));
    }

    public void setGaussianBlurLevel(float f11) {
        this.mRunOnDrawQueue.add(h.a(this, f11));
    }

    public void setGreenScreenFile(String str, boolean z11) {
        this.mRunOnDrawQueue.add(k.a(this, str, z11));
    }

    public void setGreenScreenParam(GLConstants.GLScaleType gLScaleType, boolean z11) {
        this.mRunOnDrawQueue.add(l.a(this, gLScaleType, z11));
    }

    public void setInterceptorBeforeWatermark(GPUInterceptor gPUInterceptor) {
        this.mRunOnDrawQueue.add(e.a(this, gPUInterceptor));
    }

    public void setProcessSize(int i11, int i12) {
        if (this.mProcessWidth != i11 || this.mProcessHeight != i12) {
            this.mProcessWidth = i11;
            this.mProcessHeight = i12;
            LiteavLog.i(this.mTAG, "process size update to %dx%d", Integer.valueOf(i11), Integer.valueOf(i12));
            if (makeCurrent()) {
                PixelFrameRenderer pixelFrameRenderer = this.mPixelFrameRenderer;
                if (pixelFrameRenderer != null) {
                    pixelFrameRenderer.uninitialize();
                    this.mPixelFrameRenderer = null;
                }
                GLTexturePool gLTexturePool = this.mGLTexturePool;
                if (gLTexturePool != null) {
                    gLTexturePool.evictAll();
                }
                this.mGPUImageFilterChain.onOutputSizeChanged(i11, i12);
            }
        }
    }

    public void setWatermark(Bitmap bitmap, float f11, float f12, float f13) {
        LiteavLog.d(this.mTAG, "setWatermark xOffsetRatio: %.2f, yOffsetRatio: %.2f, widthRatio: %.2f", Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(f13));
        this.mRunOnDrawQueue.add(f.a(this, bitmap, f11, f12, f13));
    }

    public void setWatermarkList(List<WatermarkItem> list) {
        this.mRunOnDrawQueue.add(g.a(this, list));
    }

    public void uninitialize() {
        uninitializeGLComponents();
        LiteavLog.i(this.mTAG, "destroy gpu preprocessor");
    }

    public void uninitializeGLComponents() {
        if (makeCurrent()) {
            this.mAfterWatermarkConverter.uninitialize();
            FrameConverter frameConverter = this.mBeforeWatermarkConverter;
            if (frameConverter != null) {
                frameConverter.uninitialize();
                this.mBeforeWatermarkConverter = null;
            }
            this.mBeautyProcessor.uninitialize();
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
            this.mGPUImageFilterChain.uninitialize();
            EGLCore.destroy(this.mEGLCore);
            this.mEGLCore = null;
            LiteavLog.i(this.mThrottlers.a("uninitGL"), this.mTAG, "uninitialize opengl components", new Object[0]);
        }
    }

    public void unregisterVideoProcessedListener(int i11, VideoPreprocessorListener videoPreprocessorListener) {
        c removeListenerFromList = removeListenerFromList(i11, videoPreprocessorListener, this.mNoNeedWatermarkListeners);
        if (removeListenerFromList != null || (removeListenerFromList = removeListenerFromList(i11, videoPreprocessorListener, this.mNeedWatermarkListeners)) != null) {
            this.mAfterWatermarkConverter.removeListener(i11, removeListenerFromList);
            FrameConverter frameConverter = this.mBeforeWatermarkConverter;
            if (frameConverter != null) {
                frameConverter.removeListener(i11, removeListenerFromList);
            }
            LiteavLog.i(this.mTAG, "unregister listener: identity: %d, listener: %s", Integer.valueOf(i11), videoPreprocessorListener);
        }
    }

    public void updateHomeOrientation(int i11) {
        this.mBeautyProcessor.setHomeOrientation(i11);
    }
}
