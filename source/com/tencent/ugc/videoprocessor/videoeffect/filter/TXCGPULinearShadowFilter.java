package com.tencent.ugc.videoprocessor.videoeffect.filter;

import android.opengl.GLES20;
import com.sumsub.sns.internal.ml.autocapture.a;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;

public class TXCGPULinearShadowFilter extends TXCGPUEffectFilterBase {
    private static final int DURATION_WIN_SHADDOW_LV1 = 300;
    private static final int DURATION_WIN_SHADDOW_LV10 = 1000;
    private static final int DURATION_WIN_SHADDOW_LV11 = 1050;
    private static final int DURATION_WIN_SHADDOW_LV12 = 1100;
    private static final int DURATION_WIN_SHADDOW_LV13 = 1200;
    private static final int DURATION_WIN_SHADDOW_LV14 = 1500;
    private static final int DURATION_WIN_SHADDOW_LV15 = 2500;
    private static final int DURATION_WIN_SHADDOW_LV2 = 350;
    private static final int DURATION_WIN_SHADDOW_LV3 = 400;
    private static final int DURATION_WIN_SHADDOW_LV4 = 500;
    private static final int DURATION_WIN_SHADDOW_LV5 = 600;
    private static final int DURATION_WIN_SHADDOW_LV6 = 650;
    private static final int DURATION_WIN_SHADDOW_LV7 = 700;
    private static final int DURATION_WIN_SHADDOW_LV8 = 800;
    private static final int DURATION_WIN_SHADDOW_LV9 = 900;
    private static final String FRAGMENT_SHADER = "precision mediump float; \nvarying highp vec2 textureCoordinate; \nuniform sampler2D inputImageTexture; \n \nuniform float a; \nuniform float b; \nuniform float c; \nuniform float d; \nuniform float mode; \nuniform float width; \nuniform float stride; \nuniform float alpha; \n \nvoid main() \n{ \n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate); \n   if(b == 0.0){ \n\t\tfloat mx = mod(textureCoordinate.x + c, stride); \n\t\tif((mode < 0.5 && mx <= width) || (mode > 0.5 && (mx > width))){ \n\t\t\tgl_FragColor.rgb = gl_FragColor.rgb*alpha; \n\t\t} \n\t} \n} \n";
    private int mAlphaPos = -1;
    private int mCPos = -1;
    private LinearShadowParam mLinearShadowParm;
    private int mModePos = -1;
    private int mStridePos = -1;
    private int mWithPos = -1;

    public static class LinearShadowParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public float alpha = 0.0f;
        public float mode = 0.0f;
        public float offset = 0.0f;
        public float stride = 0.05f;
        public float width = 0.0f;
    }

    public TXCGPULinearShadowFilter() {
        super(TXCGPUImageFilter.NO_FILTER_VERTEX_SHADER, FRAGMENT_SHADER);
    }

    private void setParamsInternal(float f11, float f12, float f13, float f14, float f15) {
        setFloatOnDraw(this.mModePos, f11);
        setFloatOnDraw(this.mAlphaPos, f12);
        setFloatOnDraw(this.mCPos, f13 * -1.0f);
        setFloatOnDraw(this.mWithPos, f14);
        setFloatOnDraw(this.mStridePos, f15);
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mCPos = GLES20.glGetUniformLocation(getProgramId(), "c");
        this.mModePos = GLES20.glGetUniformLocation(getProgramId(), "mode");
        this.mWithPos = GLES20.glGetUniformLocation(getProgramId(), "width");
        this.mStridePos = GLES20.glGetUniformLocation(getProgramId(), "stride");
        this.mAlphaPos = GLES20.glGetUniformLocation(getProgramId(), "alpha");
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
    }

    public void setNextFrameTimestamp(long j11) {
        super.setNextFrameTimestamp(j11);
        if (this.mLinearShadowParm == null) {
            this.mLinearShadowParm = new LinearShadowParam();
        }
        long abs = Math.abs(j11 - this.mEffectStartTime);
        if (abs < 300) {
            LinearShadowParam linearShadowParam = this.mLinearShadowParm;
            linearShadowParam.alpha = 0.0f;
            linearShadowParam.stride = 0.03f;
            linearShadowParam.width = 0.003f;
        } else if (abs < 350) {
            LinearShadowParam linearShadowParam2 = this.mLinearShadowParm;
            linearShadowParam2.alpha = 0.0f;
            linearShadowParam2.stride = 0.03f;
            linearShadowParam2.width = 0.015f;
        } else if (abs < 400) {
            LinearShadowParam linearShadowParam3 = this.mLinearShadowParm;
            linearShadowParam3.alpha = 0.0f;
            linearShadowParam3.stride = 0.03f;
            linearShadowParam3.width = 0.024f;
        } else if (abs < 500) {
            LinearShadowParam linearShadowParam4 = this.mLinearShadowParm;
            linearShadowParam4.alpha = 0.0f;
            linearShadowParam4.stride = 0.03f;
            linearShadowParam4.width = 0.015f;
        } else if (abs < 600) {
            LinearShadowParam linearShadowParam5 = this.mLinearShadowParm;
            linearShadowParam5.alpha = 0.0f;
            linearShadowParam5.stride = 0.03f;
            linearShadowParam5.width = 0.003f;
        } else if (abs < 650) {
            LinearShadowParam linearShadowParam6 = this.mLinearShadowParm;
            linearShadowParam6.alpha = 0.0f;
            linearShadowParam6.stride = 0.03f;
            linearShadowParam6.width = 0.03f;
        } else if (abs < 700) {
            LinearShadowParam linearShadowParam7 = this.mLinearShadowParm;
            linearShadowParam7.alpha = 0.0f;
            linearShadowParam7.stride = 0.03f;
            linearShadowParam7.width = 0.015f;
        } else if (abs < 800) {
            LinearShadowParam linearShadowParam8 = this.mLinearShadowParm;
            linearShadowParam8.alpha = 0.0f;
            linearShadowParam8.stride = 0.03f;
            linearShadowParam8.width = 0.024f;
        } else if (abs < 900) {
            this.mLinearShadowParm.alpha = 1.0f;
        } else if (abs < 1000) {
            LinearShadowParam linearShadowParam9 = this.mLinearShadowParm;
            linearShadowParam9.alpha = 0.0f;
            linearShadowParam9.stride = 0.03f;
            linearShadowParam9.width = 0.015f;
        } else if (abs < 1050) {
            LinearShadowParam linearShadowParam10 = this.mLinearShadowParm;
            linearShadowParam10.alpha = 0.0f;
            linearShadowParam10.stride = 0.03f;
            linearShadowParam10.width = 0.024f;
        } else if (abs < 1100) {
            LinearShadowParam linearShadowParam11 = this.mLinearShadowParm;
            linearShadowParam11.alpha = 0.0f;
            linearShadowParam11.stride = 0.03f;
            linearShadowParam11.width = 0.015f;
        } else if (abs < 1200) {
            LinearShadowParam linearShadowParam12 = this.mLinearShadowParm;
            linearShadowParam12.alpha = 0.0f;
            linearShadowParam12.stride = 0.03f;
            linearShadowParam12.width = 0.009f;
        } else if (abs < a.f34923p) {
            LinearShadowParam linearShadowParam13 = this.mLinearShadowParm;
            linearShadowParam13.alpha = 0.0f;
            linearShadowParam13.stride = 0.03f;
            linearShadowParam13.width = 0.003f;
        } else if (abs < 2500) {
            this.mLinearShadowParm.alpha = 1.0f;
        } else {
            this.mEffectStartTime = -1;
        }
        LinearShadowParam linearShadowParam14 = this.mLinearShadowParm;
        setParamsInternal(linearShadowParam14.mode, linearShadowParam14.alpha, linearShadowParam14.offset, linearShadowParam14.width, linearShadowParam14.stride);
    }
}
