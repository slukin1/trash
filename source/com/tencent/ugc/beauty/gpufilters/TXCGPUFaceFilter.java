package com.tencent.ugc.beauty.gpufilters;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.beauty.NativeLoad;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.filter.TXCGPUThreeInputFilter;
import com.tencent.ugc.videobase.filter.TXCGPUTwoInputFilter;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.nio.FloatBuffer;

public class TXCGPUFaceFilter extends TXCGPUImageFilter {
    private static final String bShaderFragmentShader = "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvoid main()\n{\n    gl_FragColor = texture2D(inputImageTexture2, textureCoordinate2) - texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture2, textureCoordinate2);\n}\n";
    private static final String retShaderFragmentShader = "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\nvoid main()\n{\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture3, textureCoordinate3) + texture2D(inputImageTexture2, textureCoordinate2);\n}\n";
    private final a mBShader = new a(bShaderFragmentShader);
    private final TXCGPUBoxBlurFilter mBoxFilter = new TXCGPUBoxBlurFilter();
    private boolean mCustomizeSamplingRatio;
    private final FloatBuffer mNormalCubeVerticesBuffer = OpenGlUtils.createNormalCubeVerticesBuffer();
    private final TXCGPUImageFilter mNormalFilter = new TXCGPUImageFilter();
    private final FloatBuffer mNormalTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
    private final b mRetShader = new b(retShaderFragmentShader);
    private int mSamplingHeight;
    private float mSamplingRatio = 4.0f;
    private int mSamplingWidth;
    private final c mVarShader = new c();

    public static class a extends TXCGPUTwoInputFilter {
        public a(String str) {
            super(str);
        }
    }

    public static class b extends TXCGPUThreeInputFilter {
        public b(String str) {
            super(str);
        }
    }

    public static class c extends TXCGPUTwoInputFilter {

        /* renamed from: a  reason: collision with root package name */
        private int f50190a;

        /* renamed from: b  reason: collision with root package name */
        private int f50191b;

        public c() {
            super((String) null, (String) null);
        }

        public final int buildProgram() {
            return NativeLoad.nativeLoadGLProgram(2);
        }

        public final void onInit(GLTexturePool gLTexturePool) {
            super.onInit(gLTexturePool);
            this.f50190a = GLES20.glGetUniformLocation(getProgramId(), "texelWidthOffset");
            this.f50191b = GLES20.glGetUniformLocation(getProgramId(), "texelHeightOffset");
        }

        public final void onOutputSizeChanged(int i11, int i12) {
            super.onOutputSizeChanged(i11, i12);
            setFloatOnDraw(this.f50190a, 1.5f / ((float) this.mOutputSize.width));
            setFloatOnDraw(this.f50191b, 1.5f / ((float) this.mOutputSize.height));
        }
    }

    public void onDraw(int i11, GLTexture gLTexture, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int i12;
        if (isInitialized()) {
            runPendingOnDrawTasks();
            GLTexture gLTexture2 = null;
            int i13 = this.mSamplingWidth;
            Size size = this.mOutputSize;
            if (i13 == size.width && this.mSamplingHeight == size.height) {
                i12 = i11;
            } else {
                gLTexture2 = this.mTexturePool.obtain(i13, this.mSamplingHeight);
                GLES20.glViewport(0, 0, this.mSamplingWidth, this.mSamplingHeight);
                this.mNormalFilter.onDraw(i11, gLTexture2, floatBuffer, floatBuffer2);
                i12 = gLTexture2.getId();
            }
            GLTexture obtain = this.mTexturePool.obtain(this.mSamplingWidth, this.mSamplingHeight);
            GLTexture obtain2 = this.mTexturePool.obtain(this.mSamplingWidth, this.mSamplingHeight);
            this.mBoxFilter.onDraw(i12, obtain, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
            this.mVarShader.setSecondInputTexture(obtain.getId());
            this.mVarShader.onDraw(i12, obtain2, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
            if (gLTexture2 != null) {
                gLTexture2.release();
            }
            GLTexture obtain3 = this.mTexturePool.obtain(this.mSamplingWidth, this.mSamplingHeight);
            this.mBShader.setSecondInputTexture(obtain.getId());
            this.mBShader.onDraw(obtain2.getId(), obtain3, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
            obtain.release();
            GLTexture obtain4 = this.mTexturePool.obtain(this.mSamplingWidth, this.mSamplingHeight);
            this.mBoxFilter.onDraw(obtain2.getId(), obtain4, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
            obtain2.release();
            GLTexture obtain5 = this.mTexturePool.obtain(this.mSamplingWidth, this.mSamplingHeight);
            this.mBoxFilter.onDraw(obtain3.getId(), obtain5, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
            obtain3.release();
            if (this.mSamplingRatio != 1.0f) {
                GLTexturePool gLTexturePool = this.mTexturePool;
                Size size2 = this.mOutputSize;
                GLTexture obtain6 = gLTexturePool.obtain(size2.width, size2.height);
                GLTexturePool gLTexturePool2 = this.mTexturePool;
                Size size3 = this.mOutputSize;
                GLTexture obtain7 = gLTexturePool2.obtain(size3.width, size3.height);
                Size size4 = this.mOutputSize;
                GLES20.glViewport(0, 0, size4.width, size4.height);
                this.mNormalFilter.onDraw(obtain4.getId(), obtain6, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
                this.mNormalFilter.onDraw(obtain5.getId(), obtain7, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
                this.mRetShader.setSecondInputTexture(obtain7.getId());
                this.mRetShader.setThirdInputTexture(i11);
                this.mRetShader.onDraw(obtain6.getId(), gLTexture, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
                obtain6.release();
                obtain7.release();
            } else {
                this.mRetShader.setSecondInputTexture(obtain5.getId());
                this.mRetShader.setThirdInputTexture(i11);
                this.mRetShader.onDraw(obtain4.getId(), gLTexture, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
            }
            obtain5.release();
            obtain4.release();
        }
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mBoxFilter.initialize(gLTexturePool);
        this.mVarShader.initialize(gLTexturePool);
        this.mBShader.initialize(gLTexturePool);
        this.mRetShader.initialize(gLTexturePool);
        this.mNormalFilter.initialize(gLTexturePool);
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        if (!this.mCustomizeSamplingRatio) {
            if (i11 < i12) {
                if (i11 < 540) {
                    this.mSamplingRatio = 1.0f;
                } else {
                    this.mSamplingRatio = 4.0f;
                }
            } else if (i12 < 540) {
                this.mSamplingRatio = 1.0f;
            } else {
                this.mSamplingRatio = 4.0f;
            }
        }
        if (Float.compare(this.mSamplingRatio, 1.0f) == 0) {
            this.mSamplingWidth = i11;
            this.mSamplingHeight = i12;
        } else {
            float f11 = this.mSamplingRatio;
            this.mSamplingWidth = (int) (((float) i11) / f11);
            this.mSamplingHeight = (int) (((float) i12) / f11);
        }
        this.mNormalFilter.onOutputSizeChanged(this.mSamplingWidth, this.mSamplingHeight);
        this.mVarShader.onOutputSizeChanged(this.mSamplingWidth, this.mSamplingHeight);
        this.mBShader.onOutputSizeChanged(this.mSamplingWidth, this.mSamplingHeight);
        this.mRetShader.onOutputSizeChanged(i11, i12);
        this.mBoxFilter.onOutputSizeChanged(this.mSamplingWidth, this.mSamplingHeight);
    }

    public void onUninit() {
        super.onUninit();
        this.mBoxFilter.uninitialize();
        this.mVarShader.uninitialize();
        this.mBShader.uninitialize();
        this.mRetShader.uninitialize();
        this.mNormalFilter.uninitialize();
    }

    public void setSamplingRatio(float f11) {
        this.mSamplingRatio = f11;
        this.mCustomizeSamplingRatio = true;
    }
}
