package com.tencent.ugc.videoprocessor.videoeffect;

import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public abstract class TXCGPUEffectFilterBase extends TXCGPUImageFilter {
    public long mEffectStartTime;

    public static class VideoEffectParams {
    }

    public TXCGPUEffectFilterBase() {
        this(TXCGPUImageFilter.NO_FILTER_VERTEX_SHADER, TXCGPUImageFilter.NO_FILTER_FRAGMENT_SHADER);
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mEffectStartTime = -1;
    }

    public void setNextFrameTimestamp(long j11) {
        if (this.mEffectStartTime == -1) {
            this.mEffectStartTime = j11;
        }
    }

    public TXCGPUEffectFilterBase(String str, String str2) {
        super(str, str2);
        this.mEffectStartTime = -1;
    }
}
