package com.tencent.ugc.videoprocessor.videoeffect.filter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;
import java.io.IOException;
import java.nio.FloatBuffer;

public class TXCGPULightingFilter extends TXCGPUEffectFilterBase {
    private static final int DURATION_LIGHTNING_LV1 = 50;
    private static final int DURATION_LIGHTNING_LV2 = 150;
    private static final int DURATION_LIGHTNING_LV3 = 250;
    private static final int DURATION_LIGHTNING_LV4 = 300;
    private static final int DURATION_LIGHTNING_LV5 = 400;
    private static final int DURATION_LIGHTNING_LV6 = 580;
    private static final String TAG = "TXCGPULightingFilter";
    private final Context mContext;
    private GLTexturePool mGLTexturePool;
    private LightningParam mLightningParam = null;
    private TXCGPULookUpFilter mLookUpFilter = null;
    private TXCGPULookUpInvertFilter mLookUpInvertFilter = null;

    public static class LightningParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public float lightningLevel = 0.0f;
    }

    public TXCGPULightingFilter(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void updateParams() {
        LightningParam lightningParam = this.mLightningParam;
        if (lightningParam != null) {
            TXCGPULookUpInvertFilter tXCGPULookUpInvertFilter = this.mLookUpInvertFilter;
            if (tXCGPULookUpInvertFilter != null) {
                tXCGPULookUpInvertFilter.setIntensity(lightningParam.lightningLevel / 5.0f);
                this.mLookUpInvertFilter.setInvertLevel(this.mLightningParam.lightningLevel * 1.5f);
            }
            TXCGPULookUpFilter tXCGPULookUpFilter = this.mLookUpFilter;
            if (tXCGPULookUpFilter != null) {
                tXCGPULookUpFilter.setIntensity(this.mLightningParam.lightningLevel / 5.0f);
            }
        }
    }

    public void onDraw(int i11, GLTexture gLTexture, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (isInitialized()) {
            runPendingOnDrawTasks();
            LightningParam lightningParam = this.mLightningParam;
            if (lightningParam != null && lightningParam.lightningLevel > 0.0f) {
                GLTexture gLTexture2 = null;
                if (this.mLookUpInvertFilter != null) {
                    GLTexturePool gLTexturePool = this.mGLTexturePool;
                    Size size = this.mOutputSize;
                    gLTexture2 = gLTexturePool.obtain(size.width, size.height);
                    this.mLookUpInvertFilter.onDraw(i11, gLTexture2, floatBuffer, floatBuffer2);
                    i11 = gLTexture2.getId();
                }
                TXCGPULookUpFilter tXCGPULookUpFilter = this.mLookUpFilter;
                if (tXCGPULookUpFilter != null) {
                    tXCGPULookUpFilter.onDraw(i11, gLTexture, floatBuffer, floatBuffer2);
                }
                if (gLTexture2 != null) {
                    gLTexture2.release();
                }
            }
        }
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mGLTexturePool = gLTexturePool;
        AssetManager assets = this.mContext.getResources().getAssets();
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(assets.open("fennen.png"));
            if (this.mLookUpInvertFilter == null) {
                TXCGPULookUpInvertFilter tXCGPULookUpInvertFilter = new TXCGPULookUpInvertFilter(decodeStream);
                this.mLookUpInvertFilter = tXCGPULookUpInvertFilter;
                tXCGPULookUpInvertFilter.initialize(gLTexturePool);
            }
            try {
                decodeStream = BitmapFactory.decodeStream(assets.open("qingliang.png"));
            } catch (IOException e11) {
                LiteavLog.e(TAG, "decode stream failed.", (Throwable) e11);
            }
            if (this.mLookUpFilter == null) {
                TXCGPULookUpFilter tXCGPULookUpFilter = new TXCGPULookUpFilter(decodeStream);
                this.mLookUpFilter = tXCGPULookUpFilter;
                tXCGPULookUpFilter.initialize(gLTexturePool);
            }
        } catch (IOException e12) {
            LiteavLog.e(TAG, "decode stream failed.", (Throwable) e12);
        }
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        TXCGPULookUpInvertFilter tXCGPULookUpInvertFilter = this.mLookUpInvertFilter;
        if (tXCGPULookUpInvertFilter != null) {
            tXCGPULookUpInvertFilter.onOutputSizeChanged(i11, i12);
        }
        TXCGPULookUpFilter tXCGPULookUpFilter = this.mLookUpFilter;
        if (tXCGPULookUpFilter != null) {
            tXCGPULookUpFilter.onOutputSizeChanged(i11, i12);
        }
    }

    public void onUninit() {
        super.onUninit();
        TXCGPULookUpInvertFilter tXCGPULookUpInvertFilter = this.mLookUpInvertFilter;
        if (tXCGPULookUpInvertFilter != null) {
            tXCGPULookUpInvertFilter.uninitialize();
            this.mLookUpInvertFilter = null;
        }
        TXCGPULookUpFilter tXCGPULookUpFilter = this.mLookUpFilter;
        if (tXCGPULookUpFilter != null) {
            tXCGPULookUpFilter.uninitialize();
            this.mLookUpFilter = null;
        }
    }

    public void setNextFrameTimestamp(long j11) {
        super.setNextFrameTimestamp(j11);
        if (this.mLightningParam == null) {
            LightningParam lightningParam = new LightningParam();
            this.mLightningParam = lightningParam;
            lightningParam.lightningLevel = 0.0f;
        }
        long abs = Math.abs(j11 - this.mEffectStartTime);
        if (abs < 50) {
            this.mLightningParam.lightningLevel = 0.7f;
        } else if (abs < 150) {
            this.mLightningParam.lightningLevel = 0.5f;
        } else if (abs < 250) {
            this.mLightningParam.lightningLevel = 0.4f;
        } else if (abs < 300) {
            this.mLightningParam.lightningLevel = 1.0f;
        } else if (abs < 400) {
            this.mLightningParam.lightningLevel = 0.3f;
        } else if (abs < 580) {
            this.mLightningParam.lightningLevel = 0.0f;
        } else {
            this.mEffectStartTime = -1;
        }
        updateParams();
    }
}
