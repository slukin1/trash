package com.google.zxing.pdf417.decoder;

import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Array;

final class PDF417CodewordDecoder {
    private static final float[][] RATIOS_TABLE;

    static {
        int i11;
        int length = PDF417Common.SYMBOL_TABLE.length;
        int[] iArr = new int[2];
        iArr[1] = 8;
        iArr[0] = length;
        RATIOS_TABLE = (float[][]) Array.newInstance(float.class, iArr);
        int i12 = 0;
        while (true) {
            int[] iArr2 = PDF417Common.SYMBOL_TABLE;
            if (i12 < iArr2.length) {
                int i13 = iArr2[i12];
                int i14 = i13 & 1;
                int i15 = 0;
                while (i15 < 8) {
                    float f11 = 0.0f;
                    while (true) {
                        i11 = i13 & 1;
                        if (i11 != i14) {
                            break;
                        }
                        f11 += 1.0f;
                        i13 >>= 1;
                    }
                    RATIOS_TABLE[i12][(8 - i15) - 1] = f11 / 17.0f;
                    i15++;
                    i14 = i11;
                }
                i12++;
            } else {
                return;
            }
        }
    }

    private PDF417CodewordDecoder() {
    }

    private static int getBitValue(int[] iArr) {
        long j11 = 0;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            for (int i12 = 0; i12 < iArr[i11]; i12++) {
                int i13 = 1;
                long j12 = j11 << 1;
                if (i11 % 2 != 0) {
                    i13 = 0;
                }
                j11 = j12 | ((long) i13);
            }
        }
        return (int) j11;
    }

    private static int getClosestDecodedValue(int[] iArr) {
        int sum = MathUtils.sum(iArr);
        float[] fArr = new float[8];
        if (sum > 1) {
            for (int i11 = 0; i11 < 8; i11++) {
                fArr[i11] = ((float) iArr[i11]) / ((float) sum);
            }
        }
        float f11 = Float.MAX_VALUE;
        int i12 = -1;
        int i13 = 0;
        while (true) {
            float[][] fArr2 = RATIOS_TABLE;
            if (i13 >= fArr2.length) {
                return i12;
            }
            float f12 = 0.0f;
            float[] fArr3 = fArr2[i13];
            for (int i14 = 0; i14 < 8; i14++) {
                float f13 = fArr3[i14] - fArr[i14];
                f12 += f13 * f13;
                if (f12 >= f11) {
                    break;
                }
            }
            if (f12 < f11) {
                i12 = PDF417Common.SYMBOL_TABLE[i13];
                f11 = f12;
            }
            i13++;
        }
    }

    private static int getDecodedCodewordValue(int[] iArr) {
        int bitValue = getBitValue(iArr);
        if (PDF417Common.getCodeword(bitValue) == -1) {
            return -1;
        }
        return bitValue;
    }

    public static int getDecodedValue(int[] iArr) {
        int decodedCodewordValue = getDecodedCodewordValue(sampleBitCounts(iArr));
        if (decodedCodewordValue != -1) {
            return decodedCodewordValue;
        }
        return getClosestDecodedValue(iArr);
    }

    private static int[] sampleBitCounts(int[] iArr) {
        float sum = (float) MathUtils.sum(iArr);
        int[] iArr2 = new int[8];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 17; i13++) {
            if (((float) (iArr[i12] + i11)) <= (sum / 34.0f) + ((((float) i13) * sum) / 17.0f)) {
                i11 += iArr[i12];
                i12++;
            }
            iArr2[i12] = iArr2[i12] + 1;
        }
        return iArr2;
    }
}
