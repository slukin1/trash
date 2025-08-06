package com.tencent.ugc.beauty.gpufilters.smooth;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.beauty.gpufilters.BeautyInterFace;
import com.tencent.ugc.videobase.chain.TXCGPUImageMultipleInputFilter;
import com.tencent.ugc.videobase.chain.TXCGPUImageTopoSortFilter;

public class BeautySmoothFilter extends TXCGPUImageTopoSortFilter implements BeautyInterFace {
    private static final String TAG = "BeautySmoothFilter";
    private final TXCBeautyBlend mBeautyBlendFilter;
    private final TXCTILSmoothHorizontalFilter mHorizontalFilter;
    private int mResampleHeight = 0;
    private float mResampleRatio = 2.0f;
    private int mResampleWidth = 0;
    private final TXCGPUSharpenAlphaFilter mSharpenFilter;
    private float mSharpenLevel = 0.1f;
    private final TXCTILSmoothVerticalFilter mVerticalFilter;

    public BeautySmoothFilter() {
        TXCBeautyBlend tXCBeautyBlend = new TXCBeautyBlend();
        this.mBeautyBlendFilter = tXCBeautyBlend;
        TXCTILSmoothHorizontalFilter tXCTILSmoothHorizontalFilter = new TXCTILSmoothHorizontalFilter();
        this.mHorizontalFilter = tXCTILSmoothHorizontalFilter;
        TXCTILSmoothVerticalFilter tXCTILSmoothVerticalFilter = new TXCTILSmoothVerticalFilter();
        this.mVerticalFilter = tXCTILSmoothVerticalFilter;
        TXCGPUSharpenAlphaFilter tXCGPUSharpenAlphaFilter = new TXCGPUSharpenAlphaFilter();
        this.mSharpenFilter = tXCGPUSharpenAlphaFilter;
        TXCGPUImageTopoSortFilter.Node initNode = getInitNode();
        TXCGPUImageTopoSortFilter.Node createNodeFromFilter = createNodeFromFilter(tXCTILSmoothHorizontalFilter);
        createNodeFromFilter.setInputForOnDraw(initNode);
        TXCGPUImageTopoSortFilter.Node createNodeFromFilter2 = createNodeFromFilter(tXCTILSmoothVerticalFilter);
        createNodeFromFilter2.setInputForOnDraw(createNodeFromFilter);
        createNodeFromFilter2.addExtraInput(TXCGPUImageMultipleInputFilter.SECOND_INPUT_SAMPLE2D_NAME, initNode);
        TXCGPUImageTopoSortFilter.Node createNodeFromFilter3 = createNodeFromFilter(tXCGPUSharpenAlphaFilter);
        createNodeFromFilter3.setInputForOnDraw(createNodeFromFilter2);
        TXCGPUImageTopoSortFilter.Node createNodeFromFilter4 = createNodeFromFilter(tXCBeautyBlend);
        createNodeFromFilter4.setInputForOnDraw(createNodeFromFilter3);
        createNodeFromFilter4.addExtraInput(TXCGPUImageMultipleInputFilter.SECOND_INPUT_SAMPLE2D_NAME, initNode);
    }

    public boolean canBeSkipped() {
        return this.mVerticalFilter.canBeSkipped() && this.mBeautyBlendFilter.canBeSkipped() && this.mSharpenFilter.canBeSkipped();
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        this.mResampleWidth = i11;
        this.mResampleHeight = i12;
        if (((double) Math.abs(this.mResampleRatio - 1.0f)) > 1.0E-5d) {
            float f11 = this.mResampleRatio;
            this.mResampleWidth = (int) (((float) this.mResampleWidth) / f11);
            this.mResampleHeight = (int) (((float) this.mResampleHeight) / f11);
        }
        LiteavLog.i(TAG, "mResampleRatio: %f, mResampleWidth: %d, mResampleHeight: %d", Float.valueOf(this.mResampleRatio), Integer.valueOf(this.mResampleWidth), Integer.valueOf(this.mResampleHeight));
        this.mHorizontalFilter.onOutputSizeChanged(this.mResampleWidth, this.mResampleHeight);
        this.mVerticalFilter.onOutputSizeChanged(this.mResampleWidth, this.mResampleHeight);
    }

    public void setBeautyLevel(float f11) {
        this.mVerticalFilter.setBeautyLevel(f11);
    }

    public void setRuddyLevel(float f11) {
        this.mBeautyBlendFilter.setRuddyLevel(f11);
    }

    public void setSharpenLevel(float f11) {
        LiteavLog.i(TAG, "setSharpenLevel ".concat(String.valueOf(f11)));
        this.mSharpenLevel = f11;
        this.mSharpenFilter.setSharpness(f11 / 1.2f);
    }

    public void setWhitenessLevel(float f11) {
        this.mBeautyBlendFilter.setWhitenessLevel(f11);
    }
}
