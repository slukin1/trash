package com.tencent.ugc.beauty.gpufilters;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.beauty.NativeLoad;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.filter.TXCGPUThreeInputFilter;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.nio.FloatBuffer;

public class BeautyBrightFilter extends TXCGPUImageFilter implements BeautyInterFace {
    private final BeautyCoreFilter mBeautyCoreFilter = new BeautyCoreFilter();
    private float mBeautyLevel = 0.0f;
    private final TXCGPUFaceFilter mNewFaceFilter = new TXCGPUFaceFilter();
    private final FloatBuffer mNormalCubeVerticesBuffer = OpenGlUtils.createNormalCubeVerticesBuffer();
    private final FloatBuffer mNormalTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
    private float mRuddyLevel = 0.0f;
    private final TXCGPUSharpenFilter mSharpenessFilter = new TXCGPUSharpenFilter();
    private float mSharpnessLevel = 0.0f;
    private float mWhiteLevel = 0.0f;

    public static class BeautyCoreFilter extends TXCGPUThreeInputFilter {
        private int mBeautyDegreeLocation = -1;
        private int mBrightDegreeLocation = -1;
        private int mRuddyLocation = -1;

        public BeautyCoreFilter() {
            super(TXCGPUThreeInputFilter.VERTEX_THREE_INPUT_SHADER, TXCGPUImageFilter.NO_FILTER_FRAGMENT_SHADER);
        }

        public int buildProgram() {
            return NativeLoad.nativeLoadGLProgram(1);
        }

        public void onInit(GLTexturePool gLTexturePool) {
            super.onInit(gLTexturePool);
            this.mBeautyDegreeLocation = GLES20.glGetUniformLocation(getProgramId(), "smoothDegree");
            this.mBrightDegreeLocation = GLES20.glGetUniformLocation(getProgramId(), "brightDegree");
            this.mRuddyLocation = GLES20.glGetUniformLocation(getProgramId(), "ruddyDegree");
        }

        public void setBeautyLevel(float f11) {
            setFloatOnDraw(this.mBeautyDegreeLocation, BeautyBrightFilter.getNewBeautyLevel(f11));
        }

        public void setBrightLevel(float f11) {
            setFloatOnDraw(this.mBrightDegreeLocation, f11 / 3.0f);
        }

        public void setRuddyLevel(float f11) {
            setFloatOnDraw(this.mRuddyLocation, (f11 / 10.0f) / 2.0f);
        }
    }

    /* access modifiers changed from: private */
    public static float getNewBeautyLevel(float f11) {
        if (f11 <= 1.0f) {
            return 0.1f;
        }
        double d11 = (double) f11;
        if (d11 < 2.5d) {
            f11 = getValue((f11 - 1.0f) / 1.5f, 1.0f, 4.1f);
        } else if (f11 < 4.0f) {
            f11 = getValue((f11 - 2.5f) / 1.5f, 4.1f, 5.6f);
        } else if (d11 < 5.5d) {
            f11 = getValue((f11 - 4.0f) / 1.5f, 5.6f, 6.8f);
        } else if (d11 <= 7.0d) {
            f11 = getValue((f11 - 5.5f) / 1.5f, 6.8f, 7.0f);
        }
        return f11 / 10.0f;
    }

    private static float getValue(float f11, float f12, float f13) {
        return f12 + ((f13 - f12) * f11);
    }

    public boolean canBeSkipped() {
        return isLessOrEqualZero(this.mBeautyLevel) && isLessOrEqualZero(this.mWhiteLevel) && isLessOrEqualZero(this.mRuddyLevel) && isLessOrEqualZero(this.mSharpnessLevel);
    }

    public void onDraw(int i11, GLTexture gLTexture, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        FloatBuffer floatBuffer3;
        int i12;
        FloatBuffer floatBuffer4;
        FloatBuffer floatBuffer5;
        int i13;
        FloatBuffer floatBuffer6;
        if (isInitialized()) {
            runPendingOnDrawTasks();
            float f11 = this.mBeautyLevel;
            GLTexture gLTexture2 = null;
            if (f11 > 0.0f || this.mWhiteLevel > 0.0f || this.mRuddyLevel > 0.0f) {
                if (f11 != 0.0f) {
                    GLTexturePool gLTexturePool = this.mTexturePool;
                    Size size = this.mOutputSize;
                    gLTexture2 = gLTexturePool.obtain(size.width, size.height);
                    this.mNewFaceFilter.onDraw(i11, gLTexture2, floatBuffer, floatBuffer2);
                    i13 = gLTexture2.getId();
                    floatBuffer5 = this.mNormalCubeVerticesBuffer;
                    floatBuffer6 = this.mNormalTextureCoordsBuffer;
                } else {
                    floatBuffer6 = floatBuffer2;
                    floatBuffer5 = floatBuffer;
                    i13 = i11;
                }
                GLTexturePool gLTexturePool2 = this.mTexturePool;
                Size size2 = this.mOutputSize;
                GLTexture obtain = gLTexturePool2.obtain(size2.width, size2.height);
                this.mBeautyCoreFilter.setSecondInputTexture(i11);
                if (this.mSharpnessLevel > 0.0f) {
                    this.mBeautyCoreFilter.onDraw(i13, obtain, floatBuffer5, floatBuffer6);
                } else {
                    this.mBeautyCoreFilter.onDraw(i13, gLTexture, floatBuffer5, floatBuffer6);
                }
                i12 = obtain.getId();
                floatBuffer3 = this.mNormalCubeVerticesBuffer;
                floatBuffer4 = this.mNormalTextureCoordsBuffer;
                if (gLTexture2 != null) {
                    gLTexture2.release();
                }
                gLTexture2 = obtain;
            } else {
                floatBuffer4 = floatBuffer2;
                floatBuffer3 = floatBuffer;
                i12 = i11;
            }
            if (this.mSharpnessLevel > 0.0f || i12 == i11) {
                this.mSharpenessFilter.onDraw(i12, gLTexture, floatBuffer3, floatBuffer4);
            }
            if (gLTexture2 != null) {
                gLTexture2.release();
            }
        }
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mNewFaceFilter.initialize(gLTexturePool);
        this.mBeautyCoreFilter.initialize(gLTexturePool);
        this.mSharpenessFilter.initialize(gLTexturePool);
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        this.mBeautyCoreFilter.onOutputSizeChanged(i11, i12);
        this.mNewFaceFilter.onOutputSizeChanged(i11, i12);
        this.mSharpenessFilter.onOutputSizeChanged(i11, i12);
    }

    public void onUninit() {
        super.onUninit();
        this.mBeautyCoreFilter.uninitialize();
        this.mNewFaceFilter.uninitialize();
        this.mSharpenessFilter.uninitialize();
    }

    public void setBeautyLevel(float f11) {
        this.mBeautyLevel = f11;
        this.mBeautyCoreFilter.setBeautyLevel(f11);
    }

    public void setRuddyLevel(float f11) {
        this.mRuddyLevel = f11;
        this.mBeautyCoreFilter.setRuddyLevel(f11);
    }

    public void setSharpenLevel(float f11) {
        float f12 = f11 / 1.5f;
        this.mSharpnessLevel = f12;
        this.mSharpenessFilter.setSharpness(f12);
    }

    public void setWhitenessLevel(float f11) {
        this.mWhiteLevel = f11;
        this.mBeautyCoreFilter.setBrightLevel(f11);
    }
}
