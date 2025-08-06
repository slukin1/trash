package com.tencent.ugc.preprocessor;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.beauty.gpufilters.WatermarkItem;
import com.tencent.ugc.preprocessor.BeautyProcessor;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.chain.GPUInterceptor;
import com.tencent.ugc.videobase.frame.FrameMetaData;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.videobase.ConvertParams;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

@JNINamespace("liteav::ugc")
public class VideoPreprocessor implements BeautyProcessor.BeautyProcessorStatusListener {
    private static final String TAG = "VideoPreprocessor";
    private final SparseArray<ConvertParams> mConvertParamsList = new SparseArray<>();
    private long mLastProcessTimestamp = 0;
    private final CyclicBarrier mLoadFrameCyclicBarrier = new CyclicBarrier(2);
    private float mLookupMixLevel = 0.5f;
    private final GPUPreprocessor mPreprocessor;
    /* access modifiers changed from: private */
    public SourceType mSourceType = SourceType.NONE;
    private long mTotalFrameCount = 0;
    private CustomHandler mWorkHandler;

    public enum SourceType {
        NONE(0),
        CAMERA(1),
        SCREEN(2),
        VIRTUAL_CAMERA(3),
        CUSTOM(4);
        
        private final int mValue;

        private SourceType(int i11) {
            this.mValue = i11;
        }

        public static SourceType fromInteger(int i11) {
            for (SourceType sourceType : values()) {
                if (sourceType.mValue == i11) {
                    return sourceType;
                }
            }
            return NONE;
        }

        public final int asInt() {
            return this.mValue;
        }
    }

    public VideoPreprocessor(Context context, BeautyProcessor beautyProcessor) {
        this.mPreprocessor = new GPUPreprocessor(context, beautyProcessor);
        beautyProcessor.setBeautyManagerStatusListener(this);
    }

    private void applyMetaData(PixelFrame pixelFrame) {
        FrameMetaData metaData = pixelFrame.getMetaData();
        if (metaData != null) {
            pixelFrame.setRotation(k.NORMAL);
            pixelFrame.postRotate(metaData.getPreprocessorRotation());
            pixelFrame.setMirrorHorizontal(metaData.isPreprocessorMirrorHorizontal());
            pixelFrame.setMirrorVertical(metaData.isPreprocessorMirrorVertical());
            Size renderSize = metaData.getRenderSize();
            if (renderSize.isValid()) {
                this.mPreprocessor.setProcessSize(renderSize.width, renderSize.height);
            }
        }
    }

    private GLConstants.GLScaleType getScaleTypeFromMetaData(PixelFrame pixelFrame) {
        FrameMetaData metaData = pixelFrame.getMetaData();
        if (metaData == null) {
            return this.mSourceType == SourceType.SCREEN ? GLConstants.GLScaleType.FIT_CENTER : GLConstants.GLScaleType.CENTER_CROP;
        }
        return metaData.getPreprocessorScaleType();
    }

    public static /* synthetic */ void lambda$processFrame$1(VideoPreprocessor videoPreprocessor, PixelFrame pixelFrame, long j11) {
        PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
        videoPreprocessor.applyMetaData(pixelFrame2);
        videoPreprocessor.mPreprocessor.processFrame(pixelFrame2, videoPreprocessor.getScaleTypeFromMetaData(pixelFrame2));
        SystemClock.elapsedRealtime();
        videoPreprocessor.reportProcessFrameRate();
        pixelFrame.release();
    }

    public static /* synthetic */ void lambda$registerVideoProcessedListener$2(VideoPreprocessor videoPreprocessor, int i11, ConvertParams convertParams, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, boolean z11, VideoPreprocessorListener videoPreprocessorListener) {
        videoPreprocessor.mPreprocessor.registerVideoProcessedListener(i11, convertParams, pixelBufferType, pixelFormatType, z11, videoPreprocessorListener);
        videoPreprocessor.mConvertParamsList.put(i11, convertParams);
        videoPreprocessor.recalculateProcessSizeInternal();
    }

    public static /* synthetic */ void lambda$unregisterVideoProcessedListener$3(VideoPreprocessor videoPreprocessor, int i11, VideoPreprocessorListener videoPreprocessorListener) {
        videoPreprocessor.mPreprocessor.unregisterVideoProcessedListener(i11, videoPreprocessorListener);
        videoPreprocessor.mConvertParamsList.remove(i11);
        videoPreprocessor.recalculateProcessSizeInternal();
    }

    private void recalculateProcessSizeInternal() {
        if (this.mConvertParamsList.size() != 0) {
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < this.mConvertParamsList.size(); i13++) {
                ConvertParams valueAt = this.mConvertParamsList.valueAt(i13);
                k kVar = valueAt.rotation;
                boolean z11 = kVar == k.ROTATION_90 || kVar == k.ROTATION_270;
                int i14 = z11 ? valueAt.height : valueAt.width;
                int i15 = z11 ? valueAt.width : valueAt.height;
                if (i11 * i15 != i12 * i14) {
                    LiteavLog.w(TAG, "video preprocessor has different w/h ratio: %dx%d vs %dx%d", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i14), Integer.valueOf(i15));
                }
                if (i14 * i15 > i11 * i12) {
                    i12 = i15;
                    i11 = i14;
                }
            }
            this.mPreprocessor.setProcessSize(i11, i12);
        }
    }

    private void reportProcessFrameRate() {
        this.mTotalFrameCount++;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime > this.mLastProcessTimestamp + 2000) {
            this.mTotalFrameCount = 0;
            this.mLastProcessTimestamp = elapsedRealtime;
        }
    }

    public BeautyProcessor getBeautyProcessor() {
        return this.mPreprocessor.getBeautyProcessor();
    }

    public void initialize() {
        LiteavLog.i(TAG, "initialize");
        HandlerThread handlerThread = new HandlerThread("video-preprocessor");
        handlerThread.start();
        this.mWorkHandler = new CustomHandler(handlerThread.getLooper());
    }

    public void onBeautyStatsChanged(String str) {
    }

    public void postTaskToGlThread(Runnable runnable) {
        this.mWorkHandler.post(runnable);
    }

    public synchronized boolean processFrame(PixelFrame pixelFrame) {
        boolean post;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        pixelFrame.retain();
        post = this.mWorkHandler.post(u.a(this, pixelFrame, elapsedRealtime));
        if (!post) {
            pixelFrame.release();
        }
        return post;
    }

    public void registerVideoProcessedListener(int i11, ConvertParams convertParams, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, boolean z11, VideoPreprocessorListener videoPreprocessorListener) {
        GLConstants.PixelBufferType pixelBufferType2 = GLConstants.PixelBufferType.TEXTURE_OES;
        if (pixelBufferType == GLConstants.PixelBufferType.TEXTURE_2D) {
            GLConstants.PixelFormatType pixelFormatType2 = GLConstants.PixelFormatType.RGBA;
        }
        this.mWorkHandler.post(v.a(this, i11, convertParams, pixelBufferType, pixelFormatType, z11, videoPreprocessorListener));
    }

    public void runTaskInGlThreadAndWaitDone(Runnable runnable) {
        this.mWorkHandler.runAndWaitDone(runnable);
    }

    public void setFilterGroupImages(float f11, Bitmap bitmap, float f12, Bitmap bitmap2, float f13) {
        postTaskToGlThread(ab.a(this, f11, bitmap, f12, bitmap2, f13));
    }

    public void setFilterMixLevel(float f11) {
        LiteavLog.i(TAG, "setFilterMixLevel: ".concat(String.valueOf(f11)));
        this.mLookupMixLevel = f11;
        this.mWorkHandler.post(z.a(this, f11));
    }

    public void setGaussianBlurLevel(float f11) {
        this.mWorkHandler.post(p.a(this, f11));
    }

    public boolean setGreenScreenFile(String str, boolean z11) {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 18) {
            return false;
        }
        LiteavLog.i(TAG, "setGreenScreenFile: path=" + str + ", isLoop=" + z11);
        this.mWorkHandler.post(x.a(this, str, z11));
        return true;
    }

    public void setGreenScreenParam(GLConstants.GLScaleType gLScaleType, boolean z11) {
        this.mWorkHandler.post(y.a(this, gLScaleType, z11));
    }

    public void setInterceptorBeforeWatermark(GPUInterceptor gPUInterceptor) {
        this.mWorkHandler.post(t.a(this, gPUInterceptor));
    }

    public void setLookupImage(Bitmap bitmap) {
        LiteavLog.i(TAG, "setLookupImage: ".concat(String.valueOf(bitmap)));
        this.mWorkHandler.post(aa.a(this, bitmap));
    }

    public void setSourceType(SourceType sourceType) {
        this.mWorkHandler.post(m.a(this, sourceType));
    }

    public void setWatermark(Bitmap bitmap, float f11, float f12, float f13) {
        this.mWorkHandler.post(n.a(this, bitmap, f11, f12, f13));
    }

    public void setWatermarkList(List<WatermarkItem> list) {
        this.mWorkHandler.post(o.a(this, list));
    }

    public void uninitialize() {
        LiteavLog.i(TAG, "uninitialize");
        CustomHandler customHandler = this.mWorkHandler;
        if (customHandler != null) {
            GPUPreprocessor gPUPreprocessor = this.mPreprocessor;
            gPUPreprocessor.getClass();
            customHandler.post(r.a(gPUPreprocessor));
            customHandler.quitLooper();
        }
    }

    public void uninitializeGLComponents() {
        CustomHandler customHandler = this.mWorkHandler;
        GPUPreprocessor gPUPreprocessor = this.mPreprocessor;
        gPUPreprocessor.getClass();
        customHandler.post(s.a(gPUPreprocessor));
    }

    public void unregisterVideoProcessedListener(int i11, VideoPreprocessorListener videoPreprocessorListener) {
        this.mWorkHandler.post(w.a(this, i11, videoPreprocessorListener));
    }

    public void updateHomeOrientation(int i11) {
        this.mWorkHandler.post(q.a(this, i11));
    }
}
