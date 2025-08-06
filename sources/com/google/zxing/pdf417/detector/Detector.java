package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class Detector {
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private Detector() {
    }

    private static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i11 = 0; i11 < iArr.length; i11++) {
            resultPointArr[iArr[i11]] = resultPointArr2[i11];
        }
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z11) throws NotFoundException {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List<ResultPoint[]> detect = detect(z11, blackMatrix);
        if (detect.isEmpty()) {
            blackMatrix = blackMatrix.clone();
            blackMatrix.rotate180();
            detect = detect(z11, blackMatrix);
        }
        return new PDF417DetectorResult(blackMatrix, detect);
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i11, int i12, int i13, boolean z11, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i14 = 0;
        while (bitMatrix.get(i11, i12) && i11 > 0) {
            int i15 = i14 + 1;
            if (i14 >= 3) {
                break;
            }
            i11--;
            i14 = i15;
        }
        int length = iArr.length;
        boolean z12 = z11;
        int i16 = 0;
        int i17 = i11;
        while (i11 < i13) {
            if (bitMatrix.get(i11, i12) != z12) {
                iArr2[i16] = iArr2[i16] + 1;
            } else {
                if (i16 != length - 1) {
                    i16++;
                } else if (patternMatchVariance(iArr2, iArr, 0.8f) < MAX_AVG_VARIANCE) {
                    return new int[]{i17, i11};
                } else {
                    i17 += iArr2[0] + iArr2[1];
                    int i18 = i16 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i18);
                    iArr2[i18] = 0;
                    iArr2[i16] = 0;
                    i16--;
                }
                iArr2[i16] = 1;
                z12 = !z12;
            }
            i11++;
        }
        if (i16 != length - 1 || patternMatchVariance(iArr2, iArr, 0.8f) >= MAX_AVG_VARIANCE) {
            return null;
        }
        return new int[]{i17, i11 - 1};
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i11, int i12, int i13, int i14, int[] iArr) {
        boolean z11;
        int i15;
        int i16;
        int i17;
        int i18 = i11;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        int i19 = i13;
        while (true) {
            if (i19 >= i18) {
                z11 = false;
                break;
            }
            int[] findGuardPattern = findGuardPattern(bitMatrix, i14, i19, i12, false, iArr, iArr2);
            if (findGuardPattern != null) {
                int i21 = i19;
                int[] iArr3 = findGuardPattern;
                int i22 = i21;
                while (true) {
                    if (i22 <= 0) {
                        i17 = i22;
                        break;
                    }
                    int i23 = i22 - 1;
                    int[] findGuardPattern2 = findGuardPattern(bitMatrix, i14, i23, i12, false, iArr, iArr2);
                    if (findGuardPattern2 == null) {
                        i17 = i23 + 1;
                        break;
                    }
                    iArr3 = findGuardPattern2;
                    i22 = i23;
                }
                float f11 = (float) i17;
                resultPointArr[0] = new ResultPoint((float) iArr3[0], f11);
                resultPointArr[1] = new ResultPoint((float) iArr3[1], f11);
                z11 = true;
                i19 = i17;
            } else {
                i19 += 5;
            }
        }
        int i24 = i19 + 1;
        if (z11) {
            int[] iArr4 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i25 = i24;
            int i26 = 0;
            while (true) {
                if (i25 >= i18) {
                    i15 = i26;
                    i16 = i25;
                    break;
                }
                i15 = i26;
                i16 = i25;
                int[] findGuardPattern3 = findGuardPattern(bitMatrix, iArr4[0], i25, i12, false, iArr, iArr2);
                if (findGuardPattern3 == null || Math.abs(iArr4[0] - findGuardPattern3[0]) >= 5 || Math.abs(iArr4[1] - findGuardPattern3[1]) >= 5) {
                    if (i15 > 25) {
                        break;
                    }
                    i26 = i15 + 1;
                } else {
                    iArr4 = findGuardPattern3;
                    i26 = 0;
                }
                i25 = i16 + 1;
            }
            i24 = i16 - (i15 + 1);
            float f12 = (float) i24;
            resultPointArr[2] = new ResultPoint((float) iArr4[0], f12);
            resultPointArr[3] = new ResultPoint((float) iArr4[1], f12);
        }
        if (i24 - i19 < 10) {
            Arrays.fill(resultPointArr, (Object) null);
        }
        return resultPointArr;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix, int i11, int i12) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i11, i12, START_PATTERN), INDEXES_START_PATTERN);
        if (resultPointArr[4] != null) {
            i12 = (int) resultPointArr[4].getX();
            i11 = (int) resultPointArr[4].getY();
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i11, i12, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2, float f11) {
        int length = iArr.length;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            i11 += iArr[i13];
            i12 += iArr2[i13];
        }
        if (i11 < i12) {
            return Float.POSITIVE_INFINITY;
        }
        float f12 = (float) i11;
        float f13 = f12 / ((float) i12);
        float f14 = f11 * f13;
        float f15 = 0.0f;
        for (int i14 = 0; i14 < length; i14++) {
            int i15 = iArr[i14];
            float f16 = ((float) iArr2[i14]) * f13;
            float f17 = (float) i15;
            float f18 = f17 > f16 ? f17 - f16 : f16 - f17;
            if (f18 > f14) {
                return Float.POSITIVE_INFINITY;
            }
            f15 += f18;
        }
        return f15 / f12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r4.hasNext() == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r5 = (com.google.zxing.ResultPoint[]) r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r5[1] == null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r3 = (int) java.lang.Math.max((float) r3, r5[1].getY());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        if (r5[3] == null) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        r3 = java.lang.Math.max(r3, (int) r5[3].getY());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r5 == 0) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r4 = r0.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.google.zxing.ResultPoint[]> detect(boolean r8, com.google.zxing.common.BitMatrix r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = r2
            r4 = r3
        L_0x0009:
            r5 = r4
        L_0x000a:
            int r6 = r9.getHeight()
            if (r3 >= r6) goto L_0x007d
            com.google.zxing.ResultPoint[] r4 = findVertices(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L_0x0053
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L_0x0053
            if (r5 == 0) goto L_0x007d
            java.util.Iterator r4 = r0.iterator()
        L_0x0023:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x004f
            java.lang.Object r5 = r4.next()
            com.google.zxing.ResultPoint[] r5 = (com.google.zxing.ResultPoint[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L_0x003f
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.getY()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L_0x003f:
            r7 = r5[r6]
            if (r7 == 0) goto L_0x0023
            r5 = r5[r6]
            float r5 = r5.getY()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L_0x0023
        L_0x004f:
            int r3 = r3 + 5
            r4 = r2
            goto L_0x0009
        L_0x0053:
            r0.add(r4)
            if (r8 == 0) goto L_0x007d
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L_0x006b
            r5 = r4[r3]
            float r5 = r5.getX()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.getY()
            goto L_0x0079
        L_0x006b:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.getX()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.getY()
        L_0x0079:
            int r3 = (int) r3
            r4 = r5
            r5 = r1
            goto L_0x000a
        L_0x007d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.detector.Detector.detect(boolean, com.google.zxing.common.BitMatrix):java.util.List");
    }
}
