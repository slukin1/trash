package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class ITFReader extends OneDReader {
    private static final int[] DEFAULT_ALLOWED_LENGTHS = {6, 8, 10, 12, 14};
    private static final int[][] END_PATTERN_REVERSED = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    private static final float MAX_AVG_VARIANCE = 0.38f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.5f;
    private static final int N = 1;
    private static final int[][] PATTERNS = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int W = 3;

    /* renamed from: w  reason: collision with root package name */
    private static final int f67179w = 2;
    private int narrowLineWidth = -1;

    private static int decodeDigit(int[] iArr) throws NotFoundException {
        int length = PATTERNS.length;
        float f11 = 0.38f;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, PATTERNS[i12], 0.5f);
            if (patternMatchVariance < f11) {
                i11 = i12;
                f11 = patternMatchVariance;
            } else if (patternMatchVariance == f11) {
                i11 = -1;
            }
        }
        if (i11 >= 0) {
            return i11 % 10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r0 = findGuardPattern(r7, r0, END_PATTERN_REVERSED[1]);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] decodeEnd(com.google.zxing.common.BitArray r7) throws com.google.zxing.NotFoundException {
        /*
            r6 = this;
            r7.reverse()
            int r0 = skipWhiteSpace(r7)     // Catch:{ all -> 0x0035 }
            r1 = 1
            r2 = 0
            int[][] r3 = END_PATTERN_REVERSED     // Catch:{ NotFoundException -> 0x0012 }
            r3 = r3[r2]     // Catch:{ NotFoundException -> 0x0012 }
            int[] r0 = findGuardPattern(r7, r0, r3)     // Catch:{ NotFoundException -> 0x0012 }
            goto L_0x001a
        L_0x0012:
            int[][] r3 = END_PATTERN_REVERSED     // Catch:{ all -> 0x0035 }
            r3 = r3[r1]     // Catch:{ all -> 0x0035 }
            int[] r0 = findGuardPattern(r7, r0, r3)     // Catch:{ all -> 0x0035 }
        L_0x001a:
            r3 = r0[r2]     // Catch:{ all -> 0x0035 }
            r6.validateQuietZone(r7, r3)     // Catch:{ all -> 0x0035 }
            r3 = r0[r2]     // Catch:{ all -> 0x0035 }
            int r4 = r7.getSize()     // Catch:{ all -> 0x0035 }
            r5 = r0[r1]     // Catch:{ all -> 0x0035 }
            int r4 = r4 - r5
            r0[r2] = r4     // Catch:{ all -> 0x0035 }
            int r2 = r7.getSize()     // Catch:{ all -> 0x0035 }
            int r2 = r2 - r3
            r0[r1] = r2     // Catch:{ all -> 0x0035 }
            r7.reverse()
            return r0
        L_0x0035:
            r0 = move-exception
            r7.reverse()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.ITFReader.decodeEnd(com.google.zxing.common.BitArray):int[]");
    }

    private static void decodeMiddle(BitArray bitArray, int i11, int i12, StringBuilder sb2) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i11 < i12) {
            OneDReader.recordPattern(bitArray, i11, iArr);
            for (int i13 = 0; i13 < 5; i13++) {
                int i14 = i13 * 2;
                iArr2[i13] = iArr[i14];
                iArr3[i13] = iArr[i14 + 1];
            }
            sb2.append((char) (decodeDigit(iArr2) + 48));
            sb2.append((char) (decodeDigit(iArr3) + 48));
            for (int i15 = 0; i15 < 10; i15++) {
                i11 += iArr[i15];
            }
        }
    }

    private int[] decodeStart(BitArray bitArray) throws NotFoundException {
        int[] findGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), START_PATTERN);
        this.narrowLineWidth = (findGuardPattern[1] - findGuardPattern[0]) / 4;
        validateQuietZone(bitArray, findGuardPattern[0]);
        return findGuardPattern;
    }

    private static int[] findGuardPattern(BitArray bitArray, int i11, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int size = bitArray.getSize();
        int i12 = i11;
        boolean z11 = false;
        int i13 = 0;
        while (i11 < size) {
            if (bitArray.get(i11) != z11) {
                iArr2[i13] = iArr2[i13] + 1;
            } else {
                if (i13 != length - 1) {
                    i13++;
                } else if (OneDReader.patternMatchVariance(iArr2, iArr, 0.5f) < 0.38f) {
                    return new int[]{i12, i11};
                } else {
                    i12 += iArr2[0] + iArr2[1];
                    int i14 = i13 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i13] = 0;
                    i13--;
                }
                iArr2[i13] = 1;
                z11 = !z11;
            }
            i11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int skipWhiteSpace(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        if (nextSet != size) {
            return nextSet;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void validateQuietZone(BitArray bitArray, int i11) throws NotFoundException {
        int i12 = this.narrowLineWidth * 10;
        if (i12 >= i11) {
            i12 = i11;
        }
        int i13 = i11 - 1;
        while (i12 > 0 && i13 >= 0 && !bitArray.get(i13)) {
            i12--;
            i13--;
        }
        if (i12 != 0) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public Result decodeRow(int i11, BitArray bitArray, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        boolean z11;
        int[] decodeStart = decodeStart(bitArray);
        int[] decodeEnd = decodeEnd(bitArray);
        StringBuilder sb2 = new StringBuilder(20);
        decodeMiddle(bitArray, decodeStart[1], decodeEnd[0], sb2);
        String sb3 = sb2.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = DEFAULT_ALLOWED_LENGTHS;
        }
        int length = sb3.length();
        int length2 = iArr.length;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i12 >= length2) {
                z11 = false;
                break;
            }
            int i14 = iArr[i12];
            if (length == i14) {
                z11 = true;
                break;
            }
            if (i14 > i13) {
                i13 = i14;
            }
            i12++;
        }
        if (!z11 && length > i13) {
            z11 = true;
        }
        if (z11) {
            float f11 = (float) i11;
            return new Result(sb3, (byte[]) null, new ResultPoint[]{new ResultPoint((float) decodeStart[1], f11), new ResultPoint((float) decodeEnd[0], f11)}, BarcodeFormat.ITF);
        }
        throw FormatException.getFormatInstance();
    }
}
