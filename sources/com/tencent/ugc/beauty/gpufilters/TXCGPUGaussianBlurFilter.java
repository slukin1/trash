package com.tencent.ugc.beauty.gpufilters;

import android.opengl.GLES20;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilterChain;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public class TXCGPUGaussianBlurFilter extends TXCGPUImageFilterChain {
    private final a mHeightFilter;
    private final a mWidthFilter;

    public TXCGPUGaussianBlurFilter() {
        this(1.0f);
    }

    public void setBlurSize(float f11) {
        this.mWidthFilter.a(f11, 0.0f);
        this.mHeightFilter.a(0.0f, f11);
    }

    public TXCGPUGaussianBlurFilter(float f11) {
        a aVar = new a();
        this.mWidthFilter = aVar;
        a aVar2 = new a();
        this.mHeightFilter = aVar2;
        aVar.a(f11, 0.0f);
        aVar2.a(0.0f, f11);
        addFilter(aVar);
        addFilter(aVar2);
    }

    public static class a extends TXCGPUImageFilter {

        /* renamed from: a  reason: collision with root package name */
        private int f50192a;

        /* renamed from: b  reason: collision with root package name */
        private int f50193b;

        /* renamed from: c  reason: collision with root package name */
        private float f50194c;

        /* renamed from: d  reason: collision with root package name */
        private float f50195d;

        public a() {
            super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nconst int GAUSSIAN_SAMPLES = 9;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvarying vec2 textureCoordinate;\nvarying vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n gl_Position = position;\n textureCoordinate = inputTextureCoordinate.xy;\n \n // Calculate the positions for the blur\n int multiplier = 0;\n vec2 blurStep;\n   vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset);\n    \n for (int i = 0; i < GAUSSIAN_SAMPLES; i++)\n   {\n  multiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));\n       // Blur in x (horizontal)\n       blurStep = float(multiplier) * singleStepOffset;\n  blurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n }\n}\n", "uniform sampler2D inputImageTexture;\n\nconst lowp int GAUSSIAN_SAMPLES = 9;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n lowp vec3 sum = vec3(0.0);\n   lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n \n    sum += texture2D(inputImageTexture, blurCoordinates[0]).rgb * 0.05;\n    sum += texture2D(inputImageTexture, blurCoordinates[1]).rgb * 0.09;\n    sum += texture2D(inputImageTexture, blurCoordinates[2]).rgb * 0.12;\n    sum += texture2D(inputImageTexture, blurCoordinates[3]).rgb * 0.15;\n    sum += texture2D(inputImageTexture, blurCoordinates[4]).rgb * 0.18;\n    sum += texture2D(inputImageTexture, blurCoordinates[5]).rgb * 0.15;\n    sum += texture2D(inputImageTexture, blurCoordinates[6]).rgb * 0.12;\n    sum += texture2D(inputImageTexture, blurCoordinates[7]).rgb * 0.09;\n    sum += texture2D(inputImageTexture, blurCoordinates[8]).rgb * 0.05;\n\n gl_FragColor = vec4(sum,fragColor.a);\n}");
        }

        public final void a(float f11, float f12) {
            this.f50194c = f11;
            this.f50195d = f12;
            a();
        }

        public final void onInit(GLTexturePool gLTexturePool) {
            super.onInit(gLTexturePool);
            this.f50192a = GLES20.glGetUniformLocation(getProgramId(), "texelWidthOffset");
            this.f50193b = GLES20.glGetUniformLocation(getProgramId(), "texelHeightOffset");
        }

        public final void onOutputSizeChanged(int i11, int i12) {
            super.onOutputSizeChanged(i11, i12);
            a();
        }

        private void a() {
            runOnDraw(a.a(this));
        }

        public static /* synthetic */ void a(a aVar) {
            GLES20.glUseProgram(aVar.getProgramId());
            GLES20.glUniform1f(aVar.f50192a, aVar.f50194c / ((float) aVar.mOutputSize.width));
            GLES20.glUniform1f(aVar.f50193b, aVar.f50195d / ((float) aVar.mOutputSize.height));
        }
    }
}
