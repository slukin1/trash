package com.tencent.ugc.beauty.gpufilters.pitu;

import com.tencent.ugc.beauty.gpufilters.BeautyInterFace;
import com.tencent.ugc.videobase.chain.TXCGPUImageMultipleInputFilter;
import com.tencent.ugc.videobase.chain.TXCGPUImageTopoSortFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public class BeautyPITUFilter extends TXCGPUImageTopoSortFilter implements BeautyInterFace {
    private static final String TAG = "BeautyPITUFilter";
    private float mBeautyLevel = 0.2f;
    private final a mBorderBlurFilterHorizontal;
    private final a mBorderBlurFilterVertical;
    private final TXCYTBeautyBorderFilter mBorderFilter;
    private float mRuddyLevel = 0.2f;
    private float mSharpenLevel = 0.0f;
    private final a mSkinBlurFilterHorizontal;
    private final a mSkinBlurFilterVertical;
    private final TXCYTBeautySmoothFilter mSmoothFilter;
    private float mWhiteLevel = 0.2f;

    public BeautyPITUFilter() {
        a aVar = new a(true);
        this.mSkinBlurFilterVertical = aVar;
        a aVar2 = new a(false);
        this.mSkinBlurFilterHorizontal = aVar2;
        TXCYTBeautyBorderFilter tXCYTBeautyBorderFilter = new TXCYTBeautyBorderFilter();
        this.mBorderFilter = tXCYTBeautyBorderFilter;
        TXCYTBeautySmoothFilter tXCYTBeautySmoothFilter = new TXCYTBeautySmoothFilter();
        this.mSmoothFilter = tXCYTBeautySmoothFilter;
        a aVar3 = new a(true);
        this.mBorderBlurFilterVertical = aVar3;
        a aVar4 = new a(false);
        this.mBorderBlurFilterHorizontal = aVar4;
        TXCGPUImageTopoSortFilter.Node initNode = getInitNode();
        TXCGPUImageTopoSortFilter.Node createNodeFromFilter = createNodeFromFilter(aVar);
        createNodeFromFilter.setInputForOnDraw(initNode);
        TXCGPUImageTopoSortFilter.Node createNodeFromFilter2 = createNodeFromFilter(aVar2);
        createNodeFromFilter2.setInputForOnDraw(createNodeFromFilter);
        TXCGPUImageTopoSortFilter.Node createNodeFromFilter3 = createNodeFromFilter(tXCYTBeautyBorderFilter);
        createNodeFromFilter3.setInputForOnDraw(initNode);
        createNodeFromFilter3.addExtraInput(TXCGPUImageMultipleInputFilter.SECOND_INPUT_SAMPLE2D_NAME, createNodeFromFilter2);
        TXCGPUImageTopoSortFilter.Node createNodeFromFilter4 = createNodeFromFilter(aVar3);
        createNodeFromFilter4.setInputForOnDraw(createNodeFromFilter3);
        TXCGPUImageTopoSortFilter.Node createNodeFromFilter5 = createNodeFromFilter(aVar4);
        createNodeFromFilter5.setInputForOnDraw(createNodeFromFilter4);
        TXCGPUImageTopoSortFilter.Node createNodeFromFilter6 = createNodeFromFilter(tXCYTBeautySmoothFilter);
        createNodeFromFilter6.setInputForOnDraw(initNode);
        createNodeFromFilter6.addExtraInput(TXCGPUImageMultipleInputFilter.SECOND_INPUT_SAMPLE2D_NAME, createNodeFromFilter2);
        createNodeFromFilter6.addExtraInput(TXCGPUImageMultipleInputFilter.THIRD_INPUT_SAMPLE2D_NAME, createNodeFromFilter5);
    }

    public boolean canBeSkipped() {
        return this.mSmoothFilter.canBeSkipped();
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mSmoothFilter.setBlurStrength(this.mBeautyLevel);
        this.mSmoothFilter.setWhitenStrength(this.mWhiteLevel);
        this.mSmoothFilter.setRuddyStrength(this.mRuddyLevel);
        this.mSmoothFilter.setSharpenStrength(this.mSharpenLevel);
    }

    public void setBeautyLevel(float f11) {
        this.mBeautyLevel = f11;
        this.mSmoothFilter.setBlurStrength(f11);
    }

    public void setRuddyLevel(float f11) {
        this.mRuddyLevel = f11;
        this.mSmoothFilter.setRuddyStrength(f11);
    }

    public void setSharpenLevel(float f11) {
        this.mSharpenLevel = f11;
        this.mSmoothFilter.setSharpenStrength(f11);
    }

    public void setWhitenessLevel(float f11) {
        this.mWhiteLevel = f11;
        this.mSmoothFilter.setWhitenStrength(f11);
    }
}
