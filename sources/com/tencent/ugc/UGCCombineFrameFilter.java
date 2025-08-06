package com.tencent.ugc;

import android.opengl.GLES20;
import android.util.Log;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.UGCTransitionProcessor;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLFrameBuffer;
import com.tencent.ugc.videobase.frame.GLTexture;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.utils.OpenGlUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

public class UGCCombineFrameFilter {
    private static final String TAG = "UGCCombineFrameFilter";
    private UGCWatermarkAlphaTextureFilter mAlphaBlendFilter;
    private GLTexture mBackgroundTexture = null;
    private Size mCanvasSize;
    private TXCGPUImageFilter mCropFilter = null;
    private TXVideoEditConstants.TXAbsoluteRect mCropRect = null;
    private FloatBuffer mCropRectTextureCoordsBuffer;
    private GLFrameBuffer mFrameBufferForClear;
    private final FloatBuffer mNormalCubeVerticesBuffer;
    private final FloatBuffer mNormalTextureCoordsBuffer;
    private UGCRotateScaleFilter mRotateScaleFilter = null;
    private final GLTexturePool mTexturePool;

    public UGCCombineFrameFilter(GLTexturePool gLTexturePool) {
        this.mTexturePool = gLTexturePool;
        this.mNormalCubeVerticesBuffer = OpenGlUtils.createNormalCubeVerticesBuffer();
        this.mNormalTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(k.NORMAL, false, false);
    }

    private void clearTexture(GLTexture gLTexture) {
        if (this.mFrameBufferForClear == null) {
            GLFrameBuffer gLFrameBuffer = new GLFrameBuffer();
            this.mFrameBufferForClear = gLFrameBuffer;
            gLFrameBuffer.initialize();
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        if (gLTexture == null) {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glClear(16640);
            return;
        }
        this.mFrameBufferForClear.attachTexture(gLTexture.getId());
        this.mFrameBufferForClear.bindToContext();
        GLES20.glClear(16640);
        this.mFrameBufferForClear.unbindFromContext();
        this.mFrameBufferForClear.detachTexture();
    }

    private GLTexture combineFrameWithAlphaBlendFilter(List<UGCTransitionProcessor.TXCCombineFrame> list) {
        int backgroundTextureId = getBackgroundTextureId();
        GLTexture gLTexture = null;
        int i11 = 0;
        while (i11 < list.size()) {
            UGCTransitionProcessor.TXCCombineFrame tXCCombineFrame = list.get(i11);
            setAlphaBlendFilterParameter(tXCCombineFrame);
            Size size = this.mCanvasSize;
            GLES20.glViewport(0, 0, size.width, size.height);
            Size outputSize = this.mAlphaBlendFilter.getOutputSize();
            GLTexture obtain = this.mTexturePool.obtain(outputSize.width, outputSize.height);
            obtain.setColorFormat(tXCCombineFrame.drawInputFrame.getColorRange(), tXCCombineFrame.drawInputFrame.getColorSpace());
            this.mAlphaBlendFilter.onDraw(backgroundTextureId, obtain, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
            if (gLTexture != null) {
                gLTexture.release();
            }
            backgroundTextureId = obtain.getId();
            i11++;
            gLTexture = obtain;
        }
        return gLTexture;
    }

    private GLTexture cropTexture(GLTexture gLTexture) {
        TXCGPUImageFilter tXCGPUImageFilter;
        if (gLTexture == null || (tXCGPUImageFilter = this.mCropFilter) == null) {
            return gLTexture;
        }
        Size outputSize = tXCGPUImageFilter.getOutputSize();
        GLTexture obtain = this.mTexturePool.obtain(outputSize.width, outputSize.height);
        obtain.setColorFormat(gLTexture.getColorRange(), gLTexture.getColorSpace());
        GLES20.glViewport(0, 0, outputSize.width, outputSize.height);
        this.mCropFilter.onDraw(gLTexture.getId(), obtain, this.mNormalCubeVerticesBuffer, this.mCropRectTextureCoordsBuffer);
        gLTexture.release();
        return obtain;
    }

    private int getBackgroundTextureId() {
        if (this.mBackgroundTexture == null) {
            GLTexturePool gLTexturePool = this.mTexturePool;
            Size size = this.mCanvasSize;
            GLTexture obtain = gLTexturePool.obtain(size.width, size.height);
            this.mBackgroundTexture = obtain;
            obtain.setColorFormat(GLConstants.ColorRange.VIDEO_RANGE, GLConstants.ColorSpace.BT601);
            clearTexture(this.mBackgroundTexture);
        }
        return this.mBackgroundTexture.getId();
    }

    private static FloatBuffer getCropRectTextureCoords(int i11, int i12, TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect) {
        int length = GLConstants.TEXTURE_COORDS_NO_ROTATION.length;
        float[] fArr = new float[length];
        OpenGlUtils.initTextureCoordsBuffer(fArr, k.NORMAL, false, false);
        if (tXAbsoluteRect != null) {
            int i13 = tXAbsoluteRect.f50068x;
            float f11 = ((float) i11) * 1.0f;
            float f12 = ((float) i13) / f11;
            float f13 = ((float) ((i11 - i13) - tXAbsoluteRect.width)) / f11;
            int i14 = tXAbsoluteRect.f50069y;
            float f14 = ((float) i12) * 1.0f;
            float f15 = ((float) i14) / f14;
            float f16 = ((float) ((i12 - i14) - tXAbsoluteRect.height)) / f14;
            for (int i15 = 0; i15 < length / 2; i15++) {
                int i16 = i15 * 2;
                if (fArr[i16] < 0.5f) {
                    fArr[i16] = fArr[i16] + f12;
                } else {
                    fArr[i16] = fArr[i16] - f13;
                }
                int i17 = i16 + 1;
                if (fArr[i17] < 0.5f) {
                    fArr[i17] = fArr[i17] + f15;
                } else {
                    fArr[i17] = fArr[i17] - f16;
                }
            }
        }
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(GLConstants.TEXTURE_COORDS_NO_ROTATION.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr).position(0);
        return asFloatBuffer;
    }

    private void initFilter() {
        if (this.mRotateScaleFilter == null) {
            UGCRotateScaleFilter uGCRotateScaleFilter = new UGCRotateScaleFilter();
            this.mRotateScaleFilter = uGCRotateScaleFilter;
            uGCRotateScaleFilter.initialize(this.mTexturePool);
        }
        if (this.mAlphaBlendFilter == null) {
            UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter = new UGCWatermarkAlphaTextureFilter();
            this.mAlphaBlendFilter = uGCWatermarkAlphaTextureFilter;
            uGCWatermarkAlphaTextureFilter.initialize(this.mTexturePool);
        }
        this.mAlphaBlendFilter.enableWatermark(true);
        UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter2 = this.mAlphaBlendFilter;
        Size size = this.mCanvasSize;
        uGCWatermarkAlphaTextureFilter2.onOutputSizeChanged(size.width, size.height);
        if (this.mCropRect != null) {
            if (this.mCropFilter == null) {
                TXCGPUImageFilter tXCGPUImageFilter = new TXCGPUImageFilter();
                this.mCropFilter = tXCGPUImageFilter;
                tXCGPUImageFilter.initialize(this.mTexturePool);
            }
            TXCGPUImageFilter tXCGPUImageFilter2 = this.mCropFilter;
            TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect = this.mCropRect;
            tXCGPUImageFilter2.onOutputSizeChanged(tXAbsoluteRect.width, tXAbsoluteRect.height);
            return;
        }
        TXCGPUImageFilter tXCGPUImageFilter3 = this.mCropFilter;
        if (tXCGPUImageFilter3 != null) {
            tXCGPUImageFilter3.uninitialize();
            this.mCropFilter = null;
        }
    }

    private void processRotateScale(List<UGCTransitionProcessor.TXCCombineFrame> list) {
        UGCTransitionProcessor.TransformParams transformParams;
        int i11 = 0;
        while (i11 < list.size()) {
            UGCTransitionProcessor.TXCCombineFrame tXCCombineFrame = list.get(i11);
            UGCRotateScaleFilter uGCRotateScaleFilter = this.mRotateScaleFilter;
            if (uGCRotateScaleFilter != null && (transformParams = tXCCombineFrame.transformParams) != null) {
                uGCRotateScaleFilter.setRotateAndScale((float) transformParams.rotate, transformParams.scale);
                this.mRotateScaleFilter.setAlpha(tXCCombineFrame.transformParams.alpha);
                TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect = tXCCombineFrame.drawRect;
                GLES20.glViewport(0, 0, tXAbsoluteRect.width, tXAbsoluteRect.height);
                GLTexturePool gLTexturePool = this.mTexturePool;
                TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect2 = tXCCombineFrame.drawRect;
                GLTexture obtain = gLTexturePool.obtain(tXAbsoluteRect2.width, tXAbsoluteRect2.height);
                obtain.setColorFormat(tXCCombineFrame.drawInputFrame.getColorRange(), tXCCombineFrame.drawInputFrame.getColorSpace());
                clearTexture(obtain);
                this.mRotateScaleFilter.onDraw(tXCCombineFrame.drawInputFrame.getTextureId(), obtain, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
                PixelFrame pixelFrame = tXCCombineFrame.drawInputFrame;
                tXCCombineFrame.drawInputFrame = obtain.wrap(pixelFrame.getGLContext());
                pixelFrame.release();
                obtain.release();
                i11++;
            } else {
                return;
            }
        }
    }

    private void setAlphaBlendFilterParameter(UGCTransitionProcessor.TXCCombineFrame tXCCombineFrame) {
        UGCTransitionProcessor.TransformParams transformParams = tXCCombineFrame.transformParams;
        if (transformParams != null) {
            this.mAlphaBlendFilter.setAlpha(transformParams.alpha);
            this.mAlphaBlendFilter.setShowBackImageMoment(tXCCombineFrame.transformParams.isBackgroundTransparent);
        } else {
            this.mAlphaBlendFilter.setAlpha(1.0f);
            this.mAlphaBlendFilter.setShowBackImageMoment(false);
        }
        int textureId = tXCCombineFrame.drawInputFrame.getTextureId();
        TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect = tXCCombineFrame.drawRect;
        int i11 = tXAbsoluteRect.width;
        int i12 = tXAbsoluteRect.height;
        Size size = this.mCanvasSize;
        int i13 = size.width;
        float f11 = (((float) tXAbsoluteRect.f50068x) * 1.0f) / ((float) i13);
        this.mAlphaBlendFilter.setTextureWatermark(textureId, i11, i12, f11, (((float) tXAbsoluteRect.f50069y) * 1.0f) / ((float) size.height), (((float) i11) * 1.0f) / ((float) i13));
    }

    private void unInitFilter() {
        UGCRotateScaleFilter uGCRotateScaleFilter = this.mRotateScaleFilter;
        if (uGCRotateScaleFilter != null) {
            uGCRotateScaleFilter.uninitialize();
            this.mRotateScaleFilter = null;
        }
        UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter = this.mAlphaBlendFilter;
        if (uGCWatermarkAlphaTextureFilter != null) {
            uGCWatermarkAlphaTextureFilter.uninitialize();
            this.mAlphaBlendFilter = null;
        }
        TXCGPUImageFilter tXCGPUImageFilter = this.mCropFilter;
        if (tXCGPUImageFilter != null) {
            tXCGPUImageFilter.uninitialize();
            this.mCropFilter = null;
        }
        GLTexture gLTexture = this.mBackgroundTexture;
        if (gLTexture != null) {
            gLTexture.release();
            this.mBackgroundTexture = null;
        }
        GLFrameBuffer gLFrameBuffer = this.mFrameBufferForClear;
        if (gLFrameBuffer != null) {
            gLFrameBuffer.uninitialize();
            this.mFrameBufferForClear = null;
        }
    }

    public GLTexture combineFrame(List<UGCTransitionProcessor.TXCCombineFrame> list) {
        if (list == null || list.size() <= 0) {
            Log.e(TAG, "frames is null or no frames!");
            return null;
        }
        initFilter();
        processRotateScale(list);
        return cropTexture(combineFrameWithAlphaBlendFilter(list));
    }

    public void release() {
        unInitFilter();
    }

    public void setCanvasSize(int i11, int i12) {
        Size size = this.mCanvasSize;
        if (size == null || i11 != size.width || i12 != size.height) {
            Size size2 = new Size(i11, i12);
            this.mCanvasSize = size2;
            this.mCropRectTextureCoordsBuffer = getCropRectTextureCoords(size2.width, size2.height, this.mCropRect);
        }
    }

    public void setCropRect(TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect) {
        TXVideoEditConstants.TXAbsoluteRect tXAbsoluteRect2 = this.mCropRect;
        if (tXAbsoluteRect2 == null || tXAbsoluteRect == null || tXAbsoluteRect2.width != tXAbsoluteRect.width || tXAbsoluteRect2.height != tXAbsoluteRect.height || tXAbsoluteRect2.f50068x != tXAbsoluteRect.f50068x || tXAbsoluteRect2.f50069y != tXAbsoluteRect.f50069y) {
            this.mCropRect = tXAbsoluteRect;
            Size size = this.mCanvasSize;
            this.mCropRectTextureCoordsBuffer = getCropRectTextureCoords(size.width, size.height, tXAbsoluteRect);
        }
    }
}
