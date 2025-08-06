package com.tencent.ugc.beauty.gpufilters.smooth;

import android.opengl.GLES20;
import com.adjust.sdk.Constants;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.ugc.beauty.NativeLoad;
import com.tencent.ugc.videobase.filter.TXCGPUTwoInputFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public class TXCTILSmoothVerticalFilter extends TXCGPUTwoInputFilter {
    private static final String TAG = "SmoothVertical";
    private float mBeautyLevel = 0.0f;
    private int mSmoothDegreeUniform = -1;
    private int mTexelHeightOffsetLocation = -1;
    private int mTexelWidthOffsetLocation = -1;

    public TXCTILSmoothVerticalFilter() {
        super((String) null, (String) null);
    }

    public int buildProgram() {
        if (!LiteavSystemInfo.getBrand().equals(Constants.REFERRER_API_SAMSUNG) || !LiteavSystemInfo.getModel().equals("GT-I9500") || !LiteavSystemInfo.getSystemOSVersion().equals("4.3")) {
            return NativeLoad.nativeLoadGLProgram(5);
        }
        LiteavLog.d(TAG, "SAMSUNG_S4 GT-I9500 + Android 4.3; use diffrent shader!");
        return NativeLoad.nativeLoadGLProgram(15);
    }

    public boolean canBeSkipped() {
        return isLessOrEqualZero(this.mBeautyLevel);
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mTexelWidthOffsetLocation = GLES20.glGetUniformLocation(getProgramId(), "texelWidthOffset");
        this.mTexelHeightOffsetLocation = GLES20.glGetUniformLocation(getProgramId(), "texelHeightOffset");
        this.mSmoothDegreeUniform = GLES20.glGetUniformLocation(getProgramId(), "smoothDegree");
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        float f11 = 2.0f;
        if (i11 <= i12 ? i11 >= 540 : i12 >= 540) {
            f11 = 4.0f;
        }
        LiteavLog.i(TAG, "mTextureRation ".concat(String.valueOf(f11)));
        setFloatOnDraw(this.mTexelWidthOffsetLocation, f11 / ((float) i11));
        setFloatOnDraw(this.mTexelHeightOffsetLocation, f11 / ((float) i12));
    }

    public void setBeautyLevel(float f11) {
        LiteavLog.i(TAG, "setBeautyLevel ".concat(String.valueOf(f11)));
        this.mBeautyLevel = f11;
        setFloatOnDraw(this.mSmoothDegreeUniform, f11);
    }
}
