package com.tencent.ugc.beauty.gpufilters.smooth;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.beauty.NativeLoad;
import com.tencent.ugc.videobase.filter.TXCGPUTwoInputFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public class TXCBeautyBlend extends TXCGPUTwoInputFilter {
    private static final String TAG = "BeautyBlend";
    private float mContract = 0.0f;
    private int mContrastUniform = -1;
    private int mRuddyDegreeUniform = -1;
    private float mRuddyLevel = 0.0f;
    private int mWhiteDegreeUniform = -1;
    private float mWhiteLevel = 0.0f;

    public TXCBeautyBlend() {
        super((String) null);
    }

    public int buildProgram() {
        return NativeLoad.nativeLoadGLProgram(12);
    }

    public boolean canBeSkipped() {
        return isLessOrEqualZero(this.mWhiteLevel) && isLessOrEqualZero(this.mRuddyLevel) && isLessOrEqualZero(this.mContract);
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mWhiteDegreeUniform = GLES20.glGetUniformLocation(getProgramId(), "whiteDegree");
        this.mContrastUniform = GLES20.glGetUniformLocation(getProgramId(), "contrast");
        this.mRuddyDegreeUniform = GLES20.glGetUniformLocation(getProgramId(), "ruddyDegree");
    }

    public void setContract(float f11) {
        LiteavLog.i(TAG, "setContract ".concat(String.valueOf(f11)));
        this.mContract = f11;
        setFloatOnDraw(this.mContrastUniform, (f11 / 10.0f) + 1.0f);
    }

    public void setRuddyLevel(float f11) {
        LiteavLog.i(TAG, "setRuddyLevel ".concat(String.valueOf(f11)));
        this.mRuddyLevel = f11;
        setFloatOnDraw(this.mRuddyDegreeUniform, f11 / 2.0f);
    }

    public void setWhitenessLevel(float f11) {
        LiteavLog.i(TAG, "setWhitenessLevel ".concat(String.valueOf(f11)));
        this.mWhiteLevel = f11;
        setFloatOnDraw(this.mWhiteDegreeUniform, f11);
    }
}
