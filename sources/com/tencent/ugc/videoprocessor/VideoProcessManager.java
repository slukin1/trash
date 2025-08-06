package com.tencent.ugc.videoprocessor;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.preprocessor.BeautyProcessor;
import com.tencent.ugc.preprocessor.VideoPreprocessor;
import com.tencent.ugc.preprocessor.VideoPreprocessorListener;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import com.tencent.ugc.videobase.videobase.ConvertParams;
import java.nio.FloatBuffer;

public class VideoProcessManager {
    private static final int IDENTITY = 100;
    private static final String TAG = "VideoProcessManager";
    private BeautyProcessor mBeautyProcessor;
    private Context mContext;
    private GLTexturePool mGLTexturePool;
    private boolean mIsPreprocessorRegister = false;
    private IVideoProcessManagerListener mListener;
    private boolean mNeedProcess = false;
    private FloatBuffer mNormalCubeVerticesBuffer;
    private FloatBuffer mNormalTextureCoordsBuffer;
    private final VideoTransitionProcessor mTransitionProcessor;
    private final VideoEffectProcessor mVideoEffectProcessor;
    private final VideoPreprocessor mVideoPreprocessor;
    private final WatermarkProcessor mWatermarkProcessor;

    public interface IVideoProcessManagerListener {
        int customProcessFrame(PixelFrame pixelFrame);

        void didProcessFrame(PixelFrame pixelFrame);
    }

    public VideoProcessManager(Context context, boolean z11) {
        this.mContext = context;
        BeautyProcessor beautyProcessor = new BeautyProcessor(this.mContext, z11);
        this.mBeautyProcessor = beautyProcessor;
        this.mVideoPreprocessor = new VideoPreprocessor(this.mContext, beautyProcessor);
        this.mVideoEffectProcessor = new VideoEffectProcessor(this.mContext);
        this.mTransitionProcessor = new VideoTransitionProcessor(this.mContext);
        this.mWatermarkProcessor = new WatermarkProcessor();
        this.mBeautyProcessor.setPerformanceMode(z11);
        this.mNormalCubeVerticesBuffer = OpenGlUtils.createNormalCubeVerticesBuffer();
        this.mNormalTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
    }

    private PixelFrame applyMotionFilterChain(PixelFrame pixelFrame) {
        VideoEffectProcessor videoEffectProcessor = this.mVideoEffectProcessor;
        if (videoEffectProcessor != null) {
            return videoEffectProcessor.processFrame(pixelFrame, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer, this.mGLTexturePool);
        }
        return null;
    }

    private PixelFrame applyTransitionFilterChain(PixelFrame pixelFrame) {
        VideoTransitionProcessor videoTransitionProcessor = this.mTransitionProcessor;
        if (videoTransitionProcessor == null) {
            return null;
        }
        return videoTransitionProcessor.applyTransitionFilter(pixelFrame, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.ugc.videobase.frame.PixelFrame processByVideoEffectInner(com.tencent.ugc.videobase.frame.PixelFrame r4) {
        /*
            r3 = this;
            r4.retain()
            com.tencent.ugc.videoprocessor.VideoEffectProcessor r0 = r3.mVideoEffectProcessor
            if (r0 == 0) goto L_0x0026
            long r1 = r4.getTimestamp()
            int r0 = r0.getCurrentMotionType(r1)
            r1 = 1
            if (r0 != r1) goto L_0x0026
            com.tencent.ugc.videobase.frame.PixelFrame r0 = r3.applyTransitionFilterChain(r4)
            if (r0 == 0) goto L_0x001c
            r4.release()
            r4 = r0
        L_0x001c:
            com.tencent.ugc.videobase.frame.PixelFrame r0 = r3.applyMotionFilterChain(r4)
            if (r0 == 0) goto L_0x003a
            r4.release()
            goto L_0x0039
        L_0x0026:
            com.tencent.ugc.videobase.frame.PixelFrame r0 = r3.applyMotionFilterChain(r4)
            if (r0 == 0) goto L_0x0030
            r4.release()
            r4 = r0
        L_0x0030:
            com.tencent.ugc.videobase.frame.PixelFrame r0 = r3.applyTransitionFilterChain(r4)
            if (r0 == 0) goto L_0x003a
            r4.release()
        L_0x0039:
            r4 = r0
        L_0x003a:
            com.tencent.ugc.videoprocessor.WatermarkProcessor r0 = r3.mWatermarkProcessor
            java.nio.FloatBuffer r1 = r3.mNormalCubeVerticesBuffer
            java.nio.FloatBuffer r2 = r3.mNormalTextureCoordsBuffer
            com.tencent.ugc.videobase.frame.PixelFrame r0 = r0.process(r4, r1, r2)
            if (r0 == 0) goto L_0x004a
            r4.release()
            r4 = r0
        L_0x004a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videoprocessor.VideoProcessManager.processByVideoEffectInner(com.tencent.ugc.videobase.frame.PixelFrame):com.tencent.ugc.videobase.frame.PixelFrame");
    }

    public VideoEffectProcessor getEffectProcessor() {
        this.mNeedProcess = true;
        return this.mVideoEffectProcessor;
    }

    public VideoTransitionProcessor getTransitionProcessor() {
        this.mNeedProcess = true;
        return this.mTransitionProcessor;
    }

    public WatermarkProcessor getWatermarkProcessor() {
        this.mNeedProcess = true;
        return this.mWatermarkProcessor;
    }

    public void initFilter(GLTexturePool gLTexturePool, int i11, int i12, VideoPreprocessorListener videoPreprocessorListener) {
        this.mGLTexturePool = gLTexturePool;
        this.mVideoPreprocessor.setSourceType(VideoPreprocessor.SourceType.CUSTOM);
        this.mWatermarkProcessor.initialize(this.mGLTexturePool, i11, i12);
        this.mTransitionProcessor.init(this.mGLTexturePool);
        if (!this.mIsPreprocessorRegister) {
            this.mVideoPreprocessor.registerVideoProcessedListener(100, new ConvertParams(i11, i12), GLConstants.PixelBufferType.TEXTURE_2D, GLConstants.PixelFormatType.RGBA, false, videoPreprocessorListener);
            this.mIsPreprocessorRegister = true;
        }
    }

    public void initialize() {
        this.mVideoPreprocessor.initialize();
    }

    public void processByVideoEffect(PixelFrame pixelFrame) {
        IVideoProcessManagerListener iVideoProcessManagerListener;
        PixelFrame processByVideoEffectInner = processByVideoEffectInner(pixelFrame);
        if (processByVideoEffectInner != null && (iVideoProcessManagerListener = this.mListener) != null) {
            iVideoProcessManagerListener.didProcessFrame(processByVideoEffectInner);
            processByVideoEffectInner.release();
        }
    }

    public void processFrame(PixelFrame pixelFrame) {
        GLES20.glFinish();
        if (pixelFrame != null) {
            int i11 = -1;
            IVideoProcessManagerListener iVideoProcessManagerListener = this.mListener;
            if (iVideoProcessManagerListener != null) {
                i11 = iVideoProcessManagerListener.customProcessFrame(pixelFrame);
            }
            if (i11 > 0) {
                PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
                pixelFrame2.setTextureId(i11);
                pixelFrame = pixelFrame2;
            }
            VideoPreprocessor videoPreprocessor = this.mVideoPreprocessor;
            if (videoPreprocessor == null || !this.mNeedProcess) {
                IVideoProcessManagerListener iVideoProcessManagerListener2 = this.mListener;
                if (iVideoProcessManagerListener2 != null) {
                    iVideoProcessManagerListener2.didProcessFrame(pixelFrame);
                }
            } else {
                WatermarkProcessor watermarkProcessor = this.mWatermarkProcessor;
                if (watermarkProcessor != null) {
                    videoPreprocessor.setGaussianBlurLevel(watermarkProcessor.getBlurLevel() * 4.0f);
                } else {
                    videoPreprocessor.setGaussianBlurLevel(0.0f);
                }
                this.mVideoPreprocessor.processFrame(pixelFrame);
            }
            if (i11 > 0) {
                pixelFrame.release();
            }
        }
    }

    public void setBeautyFilter(int i11, int i12) {
        this.mNeedProcess = true;
        BeautyProcessor beautyProcessor = this.mVideoPreprocessor.getBeautyProcessor();
        if (beautyProcessor != null) {
            beautyProcessor.setBeautyLevel(((float) i11) / 9.0f);
            beautyProcessor.setWhitenessLevel(((float) i12) / 9.0f);
        }
    }

    public void setFilter(Bitmap bitmap, float f11, Bitmap bitmap2, float f12, float f13) {
        this.mNeedProcess = true;
        this.mVideoPreprocessor.setFilterGroupImages(f13, bitmap, f11, bitmap2, f12);
    }

    public void setListener(IVideoProcessManagerListener iVideoProcessManagerListener) {
        this.mListener = iVideoProcessManagerListener;
    }

    public void setOutputSize(int i11, int i12) {
        WatermarkProcessor watermarkProcessor = this.mWatermarkProcessor;
        if (watermarkProcessor != null) {
            watermarkProcessor.setRenderTargetSize(i11, i12);
        }
    }

    public void setScaleType(GLConstants.GLScaleType gLScaleType) {
        if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
            this.mWatermarkProcessor.setRenderMode(2);
        }
    }

    public void setSpecialRatio(float f11) {
        this.mNeedProcess = true;
        this.mVideoPreprocessor.setFilterMixLevel(f11);
    }

    public void unInitFilter(VideoPreprocessorListener videoPreprocessorListener) {
        VideoEffectProcessor videoEffectProcessor = this.mVideoEffectProcessor;
        if (videoEffectProcessor != null) {
            videoEffectProcessor.destroy();
        }
        VideoTransitionProcessor videoTransitionProcessor = this.mTransitionProcessor;
        if (videoTransitionProcessor != null) {
            videoTransitionProcessor.destroy();
        }
        if (this.mIsPreprocessorRegister) {
            this.mVideoPreprocessor.unregisterVideoProcessedListener(100, videoPreprocessorListener);
            this.mIsPreprocessorRegister = false;
        }
    }

    public void unInitialize() {
        VideoPreprocessor videoPreprocessor = this.mVideoPreprocessor;
        if (videoPreprocessor != null) {
            videoPreprocessor.uninitialize();
        }
    }
}
