package com.tencent.ugc.beauty.gpufilters.vague;

import com.tencent.ugc.beauty.gpufilters.BeautyInterFace;
import com.tencent.ugc.beauty.gpufilters.TXCGPUSharpenFilter;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilterChain;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public class BeautyVagueFilter extends TXCGPUImageFilterChain implements BeautyInterFace {
    private float mBeautyLevel = 0.0f;
    private final TXCGChannelBeautyFilter mGreenBeautyFilter;
    private float mRuddyLevel = 0.0f;
    private final TXCGPUSharpenFilter mSharpnessFilter;
    private float mSharpnessLevel = 0.0f;
    private float mWhiteLevel = 0.0f;

    public BeautyVagueFilter() {
        TXCGChannelBeautyFilter tXCGChannelBeautyFilter = new TXCGChannelBeautyFilter();
        this.mGreenBeautyFilter = tXCGChannelBeautyFilter;
        TXCGPUSharpenFilter tXCGPUSharpenFilter = new TXCGPUSharpenFilter();
        this.mSharpnessFilter = tXCGPUSharpenFilter;
        addFilter(tXCGChannelBeautyFilter);
        addFilter(tXCGPUSharpenFilter);
    }

    public boolean canBeSkipped() {
        return this.mGreenBeautyFilter.canBeSkipped() && this.mSharpnessFilter.canBeSkipped();
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mGreenBeautyFilter.setBeautyLevel(this.mBeautyLevel);
        this.mGreenBeautyFilter.setWhitenessLevel(this.mWhiteLevel);
        this.mGreenBeautyFilter.setRuddyLevel(this.mRuddyLevel);
        this.mSharpnessFilter.setSharpness(this.mSharpnessLevel / 2.0f);
    }

    public void setBeautyLevel(float f11) {
        this.mBeautyLevel = f11;
        this.mGreenBeautyFilter.setBeautyLevel(f11);
    }

    public void setRuddyLevel(float f11) {
        this.mRuddyLevel = f11;
        this.mGreenBeautyFilter.setRuddyLevel(f11);
    }

    public void setSharpenLevel(float f11) {
        this.mSharpnessLevel = f11;
        this.mSharpnessFilter.setSharpness(f11 / 2.0f);
    }

    public void setWhitenessLevel(float f11) {
        this.mWhiteLevel = f11;
        this.mGreenBeautyFilter.setWhitenessLevel(f11);
    }
}
