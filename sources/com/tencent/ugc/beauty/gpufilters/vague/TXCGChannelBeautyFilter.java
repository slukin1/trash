package com.tencent.ugc.beauty.gpufilters.vague;

import android.opengl.GLES20;
import com.tencent.ugc.beauty.NativeLoad;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public class TXCGChannelBeautyFilter extends TXCGPUImageFilter {
    private final float[] mBeautyParam = {0.5f, 0.0f, 0.0f, 0.0f};
    private int mBeautyParamsHandle = -1;
    private int mSingleStepOffsetLoc = -1;

    public TXCGChannelBeautyFilter() {
        super((String) null, (String) null);
    }

    private void setBeautyParam(float[] fArr) {
        setFloatVec4OnDraw(this.mBeautyParamsHandle, fArr);
    }

    public int buildProgram() {
        return NativeLoad.nativeLoadGLProgram(14);
    }

    public boolean canBeSkipped() {
        return isLessOrEqualZero(this.mBeautyParam[0]) && isLessOrEqualZero(this.mBeautyParam[1]) && isLessOrEqualZero(this.mBeautyParam[2]);
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mSingleStepOffsetLoc = GLES20.glGetUniformLocation(getProgramId(), "singleStepOffset");
        this.mBeautyParamsHandle = GLES20.glGetUniformLocation(getProgramId(), "beautyParams");
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        setTexSize(i11, i12);
    }

    public void setBeautyLevel(float f11) {
        float[] fArr = this.mBeautyParam;
        fArr[0] = f11;
        setBeautyParam(fArr);
    }

    public void setRuddyLevel(float f11) {
        float[] fArr = this.mBeautyParam;
        fArr[2] = f11;
        setBeautyParam(fArr);
    }

    public void setTexSize(int i11, int i12) {
        setFloatVec2OnDraw(this.mSingleStepOffsetLoc, new float[]{2.0f / ((float) i11), 2.0f / ((float) i12)});
    }

    public void setWhitenessLevel(float f11) {
        float[] fArr = this.mBeautyParam;
        fArr[1] = f11;
        setBeautyParam(fArr);
    }
}
