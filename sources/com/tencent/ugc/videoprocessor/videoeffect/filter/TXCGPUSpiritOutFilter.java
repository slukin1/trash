package com.tencent.ugc.videoprocessor.videoeffect.filter;

import com.tencent.ugc.UGCWatermarkAlphaTextureFilter;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;
import java.nio.FloatBuffer;

public class TXCGPUSpiritOutFilter extends TXCGPUEffectFilterBase {
    private static final int DURATION_SPIRITOUT_LV1 = 230;
    private static final int DURATION_SPIRITOUT_LV10 = 560;
    private static final int DURATION_SPIRITOUT_LV2 = 274;
    private static final int DURATION_SPIRITOUT_LV3 = 318;
    private static final int DURATION_SPIRITOUT_LV4 = 362;
    private static final int DURATION_SPIRITOUT_LV5 = 406;
    private static final int DURATION_SPIRITOUT_LV6 = 450;
    private static final int DURATION_SPIRITOUT_LV7 = 494;
    private static final int DURATION_SPIRITOUT_LV8 = 538;
    private static final int DURATION_SPIRITOUT_LV9 = 582;
    private static final int DURATION_SPIRITOUT_LVMAX = 1120;
    private static final int DURATION_SPIRITOUT_LVMIN = 120;
    private static final String TAG = "TXCGPUSpiritOutFilter";
    private SpiritOutEffectParam mSpritParams = null;
    private int mTextureHeight = -1;
    private GLTexturePool mTexturePool;
    private UGCWatermarkAlphaTextureFilter mTextureWaterMarkFilter = null;
    private int mTextureWidth = -1;
    public TXCZoomInOutFilter mZoomInOutFilter = null;

    public static class SpiritOutEffectParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public float alpahLevel = 0.5f;
        public int fringeNumber = 1;
        public float zoomCenterX = 0.5f;
        public float zoomCenterY = 0.5f;
        public int zoomOutLevel = 1;
    }

    public void onDraw(int i11, GLTexture gLTexture, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        TXCZoomInOutFilter tXCZoomInOutFilter;
        if (isInitialized()) {
            runPendingOnDrawTasks();
            SpiritOutEffectParam spiritOutEffectParam = this.mSpritParams;
            if (spiritOutEffectParam != null && (tXCZoomInOutFilter = this.mZoomInOutFilter) != null && this.mTextureWaterMarkFilter != null) {
                tXCZoomInOutFilter.setZoomLevel(0.96f, spiritOutEffectParam.zoomOutLevel);
                this.mZoomInOutFilter.setAlphaLevel(this.mSpritParams.alpahLevel);
                GLTexture obtain = this.mTexturePool.obtain(this.mTextureWidth, this.mTextureHeight);
                this.mZoomInOutFilter.onDraw(i11, obtain, floatBuffer, floatBuffer2);
                this.mTextureWaterMarkFilter.setTextureWatermark(obtain.getId(), this.mTextureWidth, this.mTextureHeight, 0.0f, 0.0f, 1.0f);
                this.mTextureWaterMarkFilter.setAlpha(this.mSpritParams.alpahLevel);
                this.mTextureWaterMarkFilter.onDraw(i11, gLTexture, floatBuffer, floatBuffer2);
                obtain.release();
            }
        }
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mTexturePool = gLTexturePool;
        if (this.mZoomInOutFilter == null) {
            TXCZoomInOutFilter tXCZoomInOutFilter = new TXCZoomInOutFilter();
            this.mZoomInOutFilter = tXCZoomInOutFilter;
            tXCZoomInOutFilter.initialize(gLTexturePool);
        }
        if (this.mTextureWaterMarkFilter == null) {
            UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter = new UGCWatermarkAlphaTextureFilter();
            this.mTextureWaterMarkFilter = uGCWatermarkAlphaTextureFilter;
            uGCWatermarkAlphaTextureFilter.initialize(gLTexturePool);
            this.mTextureWaterMarkFilter.setAlpha(0.5f);
            this.mTextureWaterMarkFilter.enableWatermark(true);
        }
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        this.mTextureWidth = i11;
        this.mTextureHeight = i12;
        TXCZoomInOutFilter tXCZoomInOutFilter = this.mZoomInOutFilter;
        if (tXCZoomInOutFilter != null) {
            tXCZoomInOutFilter.onOutputSizeChanged(i11, i12);
        }
        UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter = this.mTextureWaterMarkFilter;
        if (uGCWatermarkAlphaTextureFilter != null) {
            uGCWatermarkAlphaTextureFilter.onOutputSizeChanged(i11, i12);
        }
    }

    public void onUninit() {
        super.onUninit();
        TXCZoomInOutFilter tXCZoomInOutFilter = this.mZoomInOutFilter;
        if (tXCZoomInOutFilter != null) {
            tXCZoomInOutFilter.uninitialize();
            this.mZoomInOutFilter = null;
        }
        UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter = this.mTextureWaterMarkFilter;
        if (uGCWatermarkAlphaTextureFilter != null) {
            uGCWatermarkAlphaTextureFilter.uninitialize();
            this.mTextureWaterMarkFilter = null;
        }
    }

    public void setNextFrameTimestamp(long j11) {
        super.setNextFrameTimestamp(j11);
        if (this.mSpritParams == null) {
            SpiritOutEffectParam spiritOutEffectParam = new SpiritOutEffectParam();
            this.mSpritParams = spiritOutEffectParam;
            spiritOutEffectParam.fringeNumber = 1;
            spiritOutEffectParam.alpahLevel = 0.3f;
        }
        long abs = Math.abs(j11 - this.mEffectStartTime);
        if (abs < 120) {
            this.mSpritParams.zoomOutLevel = 0;
        } else if (abs < 230) {
            this.mSpritParams.zoomOutLevel = 1;
        } else if (abs < 274) {
            this.mSpritParams.zoomOutLevel = 2;
        } else if (abs < 318) {
            this.mSpritParams.zoomOutLevel = 3;
        } else if (abs < 362) {
            this.mSpritParams.zoomOutLevel = 4;
        } else if (abs < 406) {
            this.mSpritParams.zoomOutLevel = 5;
        } else if (abs < 450) {
            this.mSpritParams.zoomOutLevel = 6;
        } else if (abs < 494) {
            this.mSpritParams.zoomOutLevel = 7;
        } else if (abs < 538) {
            this.mSpritParams.zoomOutLevel = 8;
        } else if (abs < 582) {
            this.mSpritParams.zoomOutLevel = 9;
        } else if (abs < 1120) {
            this.mSpritParams.zoomOutLevel = 0;
        } else {
            this.mEffectStartTime = -1;
        }
    }
}
