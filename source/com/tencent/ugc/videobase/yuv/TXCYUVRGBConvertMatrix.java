package com.tencent.ugc.videobase.yuv;

public class TXCYUVRGBConvertMatrix {
    public static final float BT601_KB = 0.114f;
    public static final float BT601_KR = 0.299f;
    public static final float BT709_KB = 0.0722f;
    public static final float BT709_KR = 0.2126f;
    public static final float FULL_RANGE_UV_MULTI = 0.5f;
    public static final float FULL_RANGE_UV_OFFSET = 0.5019608f;
    public static final float FULL_RANGE_Y_MULTI = 1.0f;
    public static final float FULL_RANGE_Y_OFFSET = 0.0f;
    public static final float[] TX_RGB_2_YUV_601_FULL_RANGE_MATRIX;
    public static final float[] TX_RGB_2_YUV_601_VIDEO_RANGE_MATRIX;
    public static final float[] TX_RGB_2_YUV_709_FULL_RANGE_MATRIX;
    public static final float[] TX_RGB_2_YUV_709_VIDEO_RANGE_MATRIX;
    public static final float[] TX_RGB_2_YUV_FULL_RANGE_OFFSET = {0.0f, 0.5019608f, 0.5019608f};
    public static final float[] TX_RGB_2_YUV_VIDEO_RANGE_OFFSET = {0.0627451f, 0.5019608f, 0.5019608f};
    public static final float[] TX_YUV_2_RGB_601_FULL_RANGE_MATRIX = makeYUV2RGBMatrix(0.299f, 0.114f, 1.0f, 2.0f);
    public static final float[] TX_YUV_2_RGB_601_VIDEO_RANGE_MATRIX = makeYUV2RGBMatrix(0.299f, 0.114f, 1.1643835f, 2.2767856f);
    public static final float[] TX_YUV_2_RGB_709_FULL_RANGE_MATRIX = makeYUV2RGBMatrix(0.2126f, 0.0722f, 1.0f, 2.0f);
    public static final float[] TX_YUV_2_RGB_709_VIDEO_RANGE_MATRIX = makeYUV2RGBMatrix(0.2126f, 0.0722f, 1.1643835f, 2.2767856f);
    public static final float[] TX_YUV_2_RGB_FULL_RANGE_OFFSET = {0.0f, -0.5019608f, -0.5019608f};
    public static final float[] TX_YUV_2_RGB_VIDEO_RANGE_OFFSET = {-0.0627451f, -0.5019608f, -0.5019608f};
    public static final float[] T_TX_RGB_2_YUV_601_FULL_RANGE_MATRIX;
    public static final float[] T_TX_RGB_2_YUV_601_VIDEO_RANGE_MATRIX;
    public static final float[] T_TX_RGB_2_YUV_709_Full_RANGE_MATRIX;
    public static final float[] T_TX_RGB_2_YUV_709_VIDEO_RANGE_MATRIX;
    public static final float VIDEO_RANGE_UV_MULTI = 0.4392157f;
    public static final float VIDEO_RANGE_UV_OFFSET = 0.5019608f;
    public static final float VIDEO_RANGE_Y_MULTI = 0.85882354f;
    public static final float VIDEO_RANGE_Y_OFFSET = 0.0627451f;

    static {
        float[] makeRGB2YUVMatrix = makeRGB2YUVMatrix(0.299f, 0.114f, 1.0f, 0.5f);
        TX_RGB_2_YUV_601_FULL_RANGE_MATRIX = makeRGB2YUVMatrix;
        float[] makeRGB2YUVMatrix2 = makeRGB2YUVMatrix(0.299f, 0.114f, 0.85882354f, 0.4392157f);
        TX_RGB_2_YUV_601_VIDEO_RANGE_MATRIX = makeRGB2YUVMatrix2;
        float[] makeRGB2YUVMatrix3 = makeRGB2YUVMatrix(0.2126f, 0.0722f, 1.0f, 0.5f);
        TX_RGB_2_YUV_709_FULL_RANGE_MATRIX = makeRGB2YUVMatrix3;
        float[] makeRGB2YUVMatrix4 = makeRGB2YUVMatrix(0.2126f, 0.0722f, 0.85882354f, 0.4392157f);
        TX_RGB_2_YUV_709_VIDEO_RANGE_MATRIX = makeRGB2YUVMatrix4;
        T_TX_RGB_2_YUV_601_VIDEO_RANGE_MATRIX = matrixTranspose(makeRGB2YUVMatrix2);
        T_TX_RGB_2_YUV_601_FULL_RANGE_MATRIX = matrixTranspose(makeRGB2YUVMatrix);
        T_TX_RGB_2_YUV_709_Full_RANGE_MATRIX = matrixTranspose(makeRGB2YUVMatrix3);
        T_TX_RGB_2_YUV_709_VIDEO_RANGE_MATRIX = matrixTranspose(makeRGB2YUVMatrix4);
    }

    public static float[] makeRGB2YUVMatrix(float f11, float f12, float f13, float f14) {
        return makeRGB2YUVMatrixInternal(f11, 1.0f - (f11 + f12), f12, f13, f14);
    }

    public static float[] makeRGB2YUVMatrixInternal(float f11, float f12, float f13, float f14, float f15) {
        float f16 = -f15;
        float f17 = 1.0f - f13;
        float f18 = f12 * f16;
        float f19 = 1.0f - f11;
        return new float[]{f14 * f11, (f16 * f11) / f17, f15, f14 * f12, f18 / f17, f18 / f19, f14 * f13, f15, (f16 * f13) / f19};
    }

    public static float[] makeYUV2RGBMatrix(float f11, float f12, float f13, float f14) {
        return makeYUV2RGBMatrixInternal(f11, 1.0f - (f11 + f12), f12, f13, f14);
    }

    public static float[] makeYUV2RGBMatrixInternal(float f11, float f12, float f13, float f14, float f15) {
        float f16 = -f15;
        float f17 = 1.0f - f13;
        float f18 = 1.0f - f11;
        return new float[]{f14, f14, f14, 0.0f, ((f16 * f17) * f13) / f12, f17 * f15, f15 * f18, ((f16 * f18) * f11) / f12, 0.0f};
    }

    public static float[] matrixTranspose(float[] fArr) {
        float[] fArr2 = new float[fArr.length];
        for (int i11 = 0; i11 < 3; i11++) {
            for (int i12 = 0; i12 < 3; i12++) {
                fArr2[(i11 * 3) + i12] = fArr[(i12 * 3) + i11];
            }
        }
        return fArr2;
    }
}
