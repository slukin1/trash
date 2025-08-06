package com.tencent.ugc.videobase.yuv;

import android.opengl.GLES20;
import com.tencent.android.tpush.common.Constants;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public class TXCGPUImageYUVOutputFilter extends TXCGPUImageFilter {
    private int mUniformConvertMatrix;
    private int mUniformConvertOffset;
    private int mUniformHeight;
    private int mUniformWidth;

    /* renamed from: com.tencent.ugc.videobase.yuv.TXCGPUImageYUVOutputFilter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50890a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.tencent.ugc.videobase.base.GLConstants$ColorRange[] r0 = com.tencent.ugc.videobase.base.GLConstants.ColorRange.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50890a = r0
                com.tencent.ugc.videobase.base.GLConstants$ColorRange r1 = com.tencent.ugc.videobase.base.GLConstants.ColorRange.FULL_RANGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50890a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.ugc.videobase.base.GLConstants$ColorRange r1 = com.tencent.ugc.videobase.base.GLConstants.ColorRange.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f50890a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.ugc.videobase.base.GLConstants$ColorRange r1 = com.tencent.ugc.videobase.base.GLConstants.ColorRange.VIDEO_RANGE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videobase.yuv.TXCGPUImageYUVOutputFilter.AnonymousClass1.<clinit>():void");
        }
    }

    public TXCGPUImageYUVOutputFilter(String str, String str2) {
        super(str, str2);
    }

    private float[] getConvertMatrix() {
        GLConstants.ColorSpace colorSpace = this.mColorSpace;
        if (colorSpace == null || colorSpace == GLConstants.ColorSpace.UNKNOWN) {
            colorSpace = GLConstants.ColorSpace.BT601;
        }
        GLConstants.ColorRange colorRange = this.mColorRange;
        if (colorRange == null || colorRange == GLConstants.ColorRange.UNKNOWN) {
            colorRange = GLConstants.ColorRange.VIDEO_RANGE;
        }
        if (colorSpace == GLConstants.ColorSpace.BT601) {
            if (colorRange == GLConstants.ColorRange.VIDEO_RANGE) {
                return TXCYUVRGBConvertMatrix.T_TX_RGB_2_YUV_601_VIDEO_RANGE_MATRIX;
            }
            if (colorRange == GLConstants.ColorRange.FULL_RANGE) {
                return TXCYUVRGBConvertMatrix.T_TX_RGB_2_YUV_601_FULL_RANGE_MATRIX;
            }
        } else if (colorSpace == GLConstants.ColorSpace.BT709) {
            if (colorRange == GLConstants.ColorRange.VIDEO_RANGE) {
                return TXCYUVRGBConvertMatrix.T_TX_RGB_2_YUV_709_VIDEO_RANGE_MATRIX;
            }
            if (colorRange == GLConstants.ColorRange.FULL_RANGE) {
                return TXCYUVRGBConvertMatrix.T_TX_RGB_2_YUV_709_Full_RANGE_MATRIX;
            }
        }
        return TXCYUVRGBConvertMatrix.T_TX_RGB_2_YUV_601_VIDEO_RANGE_MATRIX;
    }

    private float[] getConvertOffset() {
        if (AnonymousClass1.f50890a[this.mColorRange.ordinal()] != 1) {
            return TXCYUVRGBConvertMatrix.TX_RGB_2_YUV_VIDEO_RANGE_OFFSET;
        }
        return TXCYUVRGBConvertMatrix.TX_RGB_2_YUV_FULL_RANGE_OFFSET;
    }

    public static /* synthetic */ void lambda$onOutputSizeChanged$1(TXCGPUImageYUVOutputFilter tXCGPUImageYUVOutputFilter) {
        GLES20.glUseProgram(tXCGPUImageYUVOutputFilter.getProgramId());
        GLES20.glUniform1f(tXCGPUImageYUVOutputFilter.mUniformWidth, (float) tXCGPUImageYUVOutputFilter.mOutputSize.width);
        GLES20.glUniform1f(tXCGPUImageYUVOutputFilter.mUniformHeight, (float) tXCGPUImageYUVOutputFilter.mOutputSize.height);
        GLES20.glUniformMatrix3fv(tXCGPUImageYUVOutputFilter.mUniformConvertMatrix, 1, false, tXCGPUImageYUVOutputFilter.getConvertMatrix(), 0);
        GLES20.glUniform3fv(tXCGPUImageYUVOutputFilter.mUniformConvertOffset, 1, tXCGPUImageYUVOutputFilter.getConvertOffset(), 0);
    }

    public static /* synthetic */ void lambda$setColorFormat$0(TXCGPUImageYUVOutputFilter tXCGPUImageYUVOutputFilter) {
        GLES20.glUniformMatrix3fv(tXCGPUImageYUVOutputFilter.mUniformConvertMatrix, 1, false, tXCGPUImageYUVOutputFilter.getConvertMatrix(), 0);
        GLES20.glUniform3fv(tXCGPUImageYUVOutputFilter.mUniformConvertOffset, 1, tXCGPUImageYUVOutputFilter.getConvertOffset(), 0);
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mUniformWidth = GLES20.glGetUniformLocation(getProgramId(), "width");
        this.mUniformHeight = GLES20.glGetUniformLocation(getProgramId(), "height");
        this.mUniformConvertMatrix = GLES20.glGetUniformLocation(getProgramId(), "convertMatrix");
        this.mUniformConvertOffset = GLES20.glGetUniformLocation(getProgramId(), Constants.FLAG_TAG_OFFSET);
    }

    public void onOutputSizeChanged(int i11, int i12) {
        super.onOutputSizeChanged(i11, i12);
        runOnDraw(f.a(this));
    }

    public void setColorFormat(GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        if (colorRange != this.mColorRange || colorSpace != this.mColorSpace) {
            super.setColorFormat(colorRange, colorSpace);
            runOnDraw(e.a(this));
        }
    }
}
