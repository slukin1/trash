package com.tencent.ugc.videoprocessor.videoeffect.filter;

import android.opengl.GLES20;
import com.facebook.appevents.UserDataStore;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;

public class TXCGPURockFilter extends TXCGPUEffectFilterBase {
    private static final int DURATION_LIVEWAVE = 70;
    private static final int DURATION_LIVEWAVE_LVMIN = 120;
    private static final String FRAGMENT_SHADER = "precision highp float; \nvarying vec2 textureCoordinate; \nuniform sampler2D inputImageTexture; \nuniform float t; \nuniform float st; \nconst float stride = 7.0; \nconst float interval = 1.0; \nuniform float zMin; \nuniform float zMax; \nuniform vec2 center; \nuniform vec2 offsetR; \nuniform vec2 offsetG; \nuniform vec2 offsetB;\n\nfloat GetFactor(float elapse, float astride, float ainterval, float amp) \n{ \n   float ff = mod(elapse, astride + ainterval) / astride; \n   if (ff > 1.0) \n   { \n       ff = 0.0; \n   } \n   return pow(ff, 3.0) * 1.125 * amp; \n} \nvec2 _uv(vec2 uv, vec2 center, float zz, float min) \n{ \n   return uv + (zz + min) * (center - uv); \n} \nvoid main() \n{ \n   vec4 fout; \n   float zz = GetFactor(t - st, stride, interval, zMax - zMin); \n   float coeff = pow(zz, 0.75); \n   fout.r = texture2D(inputImageTexture, _uv(textureCoordinate, center, zz, zMin) + offsetR * coeff).r;\n   fout.g = texture2D(inputImageTexture, _uv(textureCoordinate, center, zz, zMin) + offsetG * coeff).g;\n   fout.b = texture2D(inputImageTexture, _uv(textureCoordinate, center, zz, zMin) + offsetB * coeff).b;\n   gl_FragColor = vec4(fout.rgb, 1.0); \n}\n";
    private static final int INTERVAL = 400;
    private int mCenterLocation = -1;
    private int mCurrentLocation = -1;
    private DongGanLightParam mDongGanParam = null;
    private int mDurationLocation = -1;
    private int mOffsetBLocation = -1;
    private int mOffsetGLocation = -1;
    private int mOffsetRLocation = -1;
    private int mZMaxLocation = -1;
    private int mZMinLocation = -1;

    public static class DongGanLightParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public float[] center = {0.5f, 0.5f};
        public float current = 0.0f;
        public float duration = 10.0f;
        public float[] offetRed = {0.0f, 0.0f};
        public float[] offsetBlue = {0.0f, 0.0f};
        public float[] offsetGreen = {0.0f, 0.0f};
        public float zoomMax = 0.4f;
        public float zoomMin = 0.0f;
    }

    public TXCGPURockFilter() {
        super(TXCGPUImageFilter.NO_FILTER_VERTEX_SHADER, FRAGMENT_SHADER);
    }

    private void setCurrent(float f11) {
        setFloatOnDraw(this.mCurrentLocation, f11);
    }

    private void setDuration(float f11) {
        setFloatOnDraw(this.mDurationLocation, f11);
    }

    private void setOffset(float[] fArr, float[] fArr2, float[] fArr3) {
        setFloatVec2OnDraw(this.mOffsetRLocation, fArr);
        setFloatVec2OnDraw(this.mOffsetGLocation, fArr2);
        setFloatVec2OnDraw(this.mOffsetBLocation, fArr3);
    }

    private void setZoom(float f11, float f12) {
        setFloatOnDraw(this.mZMinLocation, f11);
        setFloatOnDraw(this.mZMaxLocation, f12);
    }

    private void updateParamsToOpenGL() {
        DongGanLightParam dongGanLightParam = this.mDongGanParam;
        setOffset(dongGanLightParam.offetRed, dongGanLightParam.offsetGreen, dongGanLightParam.offsetBlue);
        setFloatVec2OnDraw(this.mCenterLocation, this.mDongGanParam.center);
        DongGanLightParam dongGanLightParam2 = this.mDongGanParam;
        setZoom(dongGanLightParam2.zoomMin, dongGanLightParam2.zoomMax);
        setDuration(this.mDongGanParam.duration);
        setCurrent(this.mDongGanParam.current);
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mZMinLocation = GLES20.glGetUniformLocation(getProgramId(), "zMin");
        this.mZMaxLocation = GLES20.glGetUniformLocation(getProgramId(), "zMax");
        this.mDurationLocation = GLES20.glGetUniformLocation(getProgramId(), "t");
        this.mCurrentLocation = GLES20.glGetUniformLocation(getProgramId(), UserDataStore.STATE);
        this.mCenterLocation = GLES20.glGetUniformLocation(getProgramId(), TtmlNode.CENTER);
        this.mOffsetRLocation = GLES20.glGetUniformLocation(getProgramId(), "offsetR");
        this.mOffsetGLocation = GLES20.glGetUniformLocation(getProgramId(), "offsetG");
        this.mOffsetBLocation = GLES20.glGetUniformLocation(getProgramId(), "offsetB");
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
    }

    public void setNextFrameTimestamp(long j11) {
        super.setNextFrameTimestamp(j11);
        if (this.mDongGanParam == null) {
            DongGanLightParam dongGanLightParam = new DongGanLightParam();
            this.mDongGanParam = dongGanLightParam;
            dongGanLightParam.duration = 8.0f;
            dongGanLightParam.center = new float[]{0.5f, 0.5f};
            dongGanLightParam.zoomMin = 0.0f;
            dongGanLightParam.zoomMax = 0.2f;
        }
        long abs = Math.abs(j11 - this.mEffectStartTime);
        if (abs < 120) {
            DongGanLightParam dongGanLightParam2 = this.mDongGanParam;
            dongGanLightParam2.current = 0.0f;
            dongGanLightParam2.duration = 8.0f;
            dongGanLightParam2.center = new float[]{0.0f, 0.0f};
            dongGanLightParam2.zoomMin = 0.0f;
            dongGanLightParam2.zoomMax = 0.0f;
            dongGanLightParam2.offetRed = new float[]{0.0f, 0.0f};
            dongGanLightParam2.offsetGreen = new float[]{0.0f, 0.0f};
        } else {
            int i11 = 1;
            while (true) {
                if (i11 > 8) {
                    break;
                } else if (abs < ((long) ((i11 * 70) + 120))) {
                    DongGanLightParam dongGanLightParam3 = this.mDongGanParam;
                    dongGanLightParam3.current = (float) i11;
                    dongGanLightParam3.duration = 8.0f;
                    dongGanLightParam3.center = new float[]{0.5f, 0.5f};
                    dongGanLightParam3.zoomMin = 0.0f;
                    dongGanLightParam3.zoomMax = 0.3f;
                    if (i11 >= 3) {
                        dongGanLightParam3.offetRed = new float[]{-0.1f, 0.0f};
                        dongGanLightParam3.offsetGreen = new float[]{0.0f, 0.1f};
                    } else {
                        dongGanLightParam3.offetRed = new float[]{0.0f, 0.0f};
                        dongGanLightParam3.offsetGreen = new float[]{0.0f, 0.0f};
                    }
                } else {
                    i11++;
                }
            }
            if (abs > 680) {
                if (abs <= 1080) {
                    DongGanLightParam dongGanLightParam4 = this.mDongGanParam;
                    dongGanLightParam4.current = 0.0f;
                    dongGanLightParam4.duration = 8.0f;
                    dongGanLightParam4.center = new float[]{0.0f, 0.0f};
                    dongGanLightParam4.zoomMin = 0.0f;
                    dongGanLightParam4.zoomMax = 0.0f;
                    dongGanLightParam4.offetRed = new float[]{0.0f, 0.0f};
                    dongGanLightParam4.offsetGreen = new float[]{0.0f, 0.0f};
                } else {
                    this.mEffectStartTime = -1;
                }
            }
        }
        updateParamsToOpenGL();
    }
}
