package com.tencent.ugc.videoprocessor.videoeffect.filter;

import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;
import java.nio.FloatBuffer;

public class TXCGPUGhostShadowFilter extends TXCGPUEffectFilterBase {
    private static final String TAG = "TXCGPUGhostShadowFilter";
    private TXCGPUDissolveBlendFilter mDissolveBlendFilter = null;
    private GLTexturePool mGLTexturePool;
    private GhostShadowParam mGhostShadowParam = null;
    private TXCSavePreFrameFilter mSavePreFrameFilter = null;

    public static class GhostShadowParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public int delayNumber = 5;
        public float mixLevel = 0.5f;
        public int shadowLevel = 1;
    }

    private boolean initParams(GhostShadowParam ghostShadowParam) {
        if (ghostShadowParam == null) {
            return false;
        }
        TXCSavePreFrameFilter tXCSavePreFrameFilter = this.mSavePreFrameFilter;
        if (tXCSavePreFrameFilter == null) {
            return true;
        }
        tXCSavePreFrameFilter.setSavePreFrameNumber(ghostShadowParam.delayNumber);
        return true;
    }

    public void onDraw(int i11, GLTexture gLTexture, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (isInitialized()) {
            runPendingOnDrawTasks();
            if (initParams(this.mGhostShadowParam)) {
                GLTexturePool gLTexturePool = this.mGLTexturePool;
                Size size = this.mOutputSize;
                GLTexture obtain = gLTexturePool.obtain(size.width, size.height);
                boolean z11 = false;
                TXCSavePreFrameFilter tXCSavePreFrameFilter = this.mSavePreFrameFilter;
                if (tXCSavePreFrameFilter != null) {
                    z11 = tXCSavePreFrameFilter.onDrawToTexture(i11, obtain, floatBuffer, floatBuffer2);
                }
                TXCGPUDissolveBlendFilter tXCGPUDissolveBlendFilter = this.mDissolveBlendFilter;
                if (tXCGPUDissolveBlendFilter != null) {
                    if (z11) {
                        tXCGPUDissolveBlendFilter.setSecondInputTexture(obtain.getId());
                    }
                    this.mDissolveBlendFilter.onDraw(i11, gLTexture, floatBuffer, floatBuffer2);
                }
                obtain.release();
            }
        }
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mGLTexturePool = gLTexturePool;
        if (this.mDissolveBlendFilter == null) {
            TXCGPUDissolveBlendFilter tXCGPUDissolveBlendFilter = new TXCGPUDissolveBlendFilter();
            this.mDissolveBlendFilter = tXCGPUDissolveBlendFilter;
            tXCGPUDissolveBlendFilter.initialize(gLTexturePool);
        }
        if (this.mSavePreFrameFilter == null) {
            TXCSavePreFrameFilter tXCSavePreFrameFilter = new TXCSavePreFrameFilter();
            this.mSavePreFrameFilter = tXCSavePreFrameFilter;
            tXCSavePreFrameFilter.initFilter(gLTexturePool);
        }
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        TXCGPUDissolveBlendFilter tXCGPUDissolveBlendFilter = this.mDissolveBlendFilter;
        if (tXCGPUDissolveBlendFilter != null) {
            tXCGPUDissolveBlendFilter.onOutputSizeChanged(i11, i12);
        }
        TXCSavePreFrameFilter tXCSavePreFrameFilter = this.mSavePreFrameFilter;
        if (tXCSavePreFrameFilter != null) {
            tXCSavePreFrameFilter.onOutputSizeChanged(i11, i12);
        }
    }

    public void onUninit() {
        super.onUninit();
        TXCGPUDissolveBlendFilter tXCGPUDissolveBlendFilter = this.mDissolveBlendFilter;
        if (tXCGPUDissolveBlendFilter != null) {
            tXCGPUDissolveBlendFilter.uninitialize();
            this.mDissolveBlendFilter = null;
        }
        TXCSavePreFrameFilter tXCSavePreFrameFilter = this.mSavePreFrameFilter;
        if (tXCSavePreFrameFilter != null) {
            tXCSavePreFrameFilter.destroy();
            this.mSavePreFrameFilter = null;
        }
    }

    public void setNextFrameTimestamp(long j11) {
        super.setNextFrameTimestamp(j11);
        if (this.mGhostShadowParam == null) {
            this.mGhostShadowParam = new GhostShadowParam();
        }
        GhostShadowParam ghostShadowParam = this.mGhostShadowParam;
        ghostShadowParam.delayNumber = 5;
        ghostShadowParam.shadowLevel = 1;
        ghostShadowParam.mixLevel = 0.5f;
    }
}
