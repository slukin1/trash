package com.tencent.ugc.videobase.yuv;

import android.opengl.GLES20;
import com.tencent.android.tpush.common.Constants;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.chain.TXCGPUImageFilter;
import com.tencent.ugc.videobase.frame.GLTexturePool;

public class TXCGPUImageNV12InputFilter extends TXCGPUImageYUVInputFilter {
    private static final String NV21_RENDER_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D uvTexture;\nuniform mat3 convertMatrix;\nuniform vec3 offset;\n\nvoid main()\n{\n    highp vec3 yuv;\n    highp vec3 rgb;\n\n    yuv.x = texture2D(inputImageTexture, textureCoordinate).r;\n    yuv.y = texture2D(uvTexture, textureCoordinate).r;\n    yuv.z = texture2D(uvTexture, textureCoordinate).a;\n    yuv += offset;\n    rgb = convertMatrix * yuv;\n\n    gl_FragColor = vec4(rgb, 1.0);\n}";
    private int mUniformConvertMatrix;
    private int mUniformConvertOffset;

    /* renamed from: com.tencent.ugc.videobase.yuv.TXCGPUImageNV12InputFilter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50889a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.tencent.ugc.videobase.base.GLConstants$ColorRange[] r0 = com.tencent.ugc.videobase.base.GLConstants.ColorRange.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50889a = r0
                com.tencent.ugc.videobase.base.GLConstants$ColorRange r1 = com.tencent.ugc.videobase.base.GLConstants.ColorRange.FULL_RANGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50889a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.ugc.videobase.base.GLConstants$ColorRange r1 = com.tencent.ugc.videobase.base.GLConstants.ColorRange.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f50889a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.ugc.videobase.base.GLConstants$ColorRange r1 = com.tencent.ugc.videobase.base.GLConstants.ColorRange.VIDEO_RANGE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.videobase.yuv.TXCGPUImageNV12InputFilter.AnonymousClass1.<clinit>():void");
        }
    }

    public TXCGPUImageNV12InputFilter() {
        super(TXCGPUImageFilter.NO_FILTER_VERTEX_SHADER, NV21_RENDER_SHADER);
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
                return TXCYUVRGBConvertMatrix.TX_YUV_2_RGB_601_VIDEO_RANGE_MATRIX;
            }
            if (colorRange == GLConstants.ColorRange.FULL_RANGE) {
                return TXCYUVRGBConvertMatrix.TX_YUV_2_RGB_601_FULL_RANGE_MATRIX;
            }
        } else if (colorSpace == GLConstants.ColorSpace.BT709) {
            if (colorRange == GLConstants.ColorRange.VIDEO_RANGE) {
                return TXCYUVRGBConvertMatrix.TX_YUV_2_RGB_709_VIDEO_RANGE_MATRIX;
            }
            if (colorRange == GLConstants.ColorRange.FULL_RANGE) {
                return TXCYUVRGBConvertMatrix.TX_YUV_2_RGB_709_FULL_RANGE_MATRIX;
            }
        }
        return TXCYUVRGBConvertMatrix.TX_YUV_2_RGB_601_VIDEO_RANGE_MATRIX;
    }

    private float[] getConvertOffset() {
        if (AnonymousClass1.f50889a[this.mColorRange.ordinal()] != 1) {
            return TXCYUVRGBConvertMatrix.TX_YUV_2_RGB_VIDEO_RANGE_OFFSET;
        }
        return TXCYUVRGBConvertMatrix.TX_YUV_2_RGB_FULL_RANGE_OFFSET;
    }

    public static /* synthetic */ void lambda$onInit$0(TXCGPUImageNV12InputFilter tXCGPUImageNV12InputFilter) {
        GLES20.glUseProgram(tXCGPUImageNV12InputFilter.getProgramId());
        GLES20.glUniform3fv(tXCGPUImageNV12InputFilter.mUniformConvertOffset, 1, tXCGPUImageNV12InputFilter.getConvertOffset(), 0);
        GLES20.glUniformMatrix3fv(tXCGPUImageNV12InputFilter.mUniformConvertMatrix, 1, false, tXCGPUImageNV12InputFilter.getConvertMatrix(), 0);
    }

    public static /* synthetic */ void lambda$setColorFormat$1(TXCGPUImageNV12InputFilter tXCGPUImageNV12InputFilter) {
        GLES20.glUniformMatrix3fv(tXCGPUImageNV12InputFilter.mUniformConvertMatrix, 1, false, tXCGPUImageNV12InputFilter.getConvertMatrix(), 0);
        GLES20.glUniform3fv(tXCGPUImageNV12InputFilter.mUniformConvertOffset, 1, tXCGPUImageNV12InputFilter.getConvertOffset(), 0);
    }

    public int getUvFormat() {
        return 6410;
    }

    public void onInit(GLTexturePool gLTexturePool) {
        super.onInit(gLTexturePool);
        this.mUniformConvertMatrix = GLES20.glGetUniformLocation(getProgramId(), "convertMatrix");
        this.mUniformConvertOffset = GLES20.glGetUniformLocation(getProgramId(), Constants.FLAG_TAG_OFFSET);
        runOnDraw(c.a(this));
    }

    public void setColorFormat(GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        if (colorRange != this.mColorRange || colorSpace != this.mColorSpace) {
            super.setColorFormat(colorRange, colorSpace);
            runOnDraw(d.a(this));
        }
    }
}
