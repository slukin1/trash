package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;

public abstract class AbstractRSSReader extends OneDReader {
    private static final float MAX_AVG_VARIANCE = 0.2f;
    private static final float MAX_FINDER_PATTERN_RATIO = 0.89285713f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.45f;
    private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667f;
    private final int[] dataCharacterCounters;
    private final int[] decodeFinderCounters = new int[4];
    private final int[] evenCounts;
    private final float[] evenRoundingErrors;
    private final int[] oddCounts;
    private final float[] oddRoundingErrors;

    public AbstractRSSReader() {
        int[] iArr = new int[8];
        this.dataCharacterCounters = iArr;
        this.oddRoundingErrors = new float[4];
        this.evenRoundingErrors = new float[4];
        this.oddCounts = new int[(iArr.length / 2)];
        this.evenCounts = new int[(iArr.length / 2)];
    }

    @Deprecated
    public static int count(int[] iArr) {
        return MathUtils.sum(iArr);
    }

    public static void decrement(int[] iArr, float[] fArr) {
        int i11 = 0;
        float f11 = fArr[0];
        for (int i12 = 1; i12 < iArr.length; i12++) {
            if (fArr[i12] < f11) {
                f11 = fArr[i12];
                i11 = i12;
            }
        }
        iArr[i11] = iArr[i11] - 1;
    }

    public static void increment(int[] iArr, float[] fArr) {
        int i11 = 0;
        float f11 = fArr[0];
        for (int i12 = 1; i12 < iArr.length; i12++) {
            if (fArr[i12] > f11) {
                f11 = fArr[i12];
                i11 = i12;
            }
        }
        iArr[i11] = iArr[i11] + 1;
    }

    public static boolean isFinderPattern(int[] iArr) {
        int i11 = iArr[0] + iArr[1];
        float f11 = ((float) i11) / ((float) ((iArr[2] + i11) + iArr[3]));
        if (f11 >= MIN_FINDER_PATTERN_RATIO && f11 <= MAX_FINDER_PATTERN_RATIO) {
            int i12 = Integer.MAX_VALUE;
            int i13 = Integer.MIN_VALUE;
            for (int i14 : iArr) {
                if (i14 > i13) {
                    i13 = i14;
                }
                if (i14 < i12) {
                    i12 = i14;
                }
            }
            if (i13 < i12 * 10) {
                return true;
            }
        }
        return false;
    }

    public static int parseFinderValue(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i11 = 0; i11 < iArr2.length; i11++) {
            if (OneDReader.patternMatchVariance(iArr, iArr2[i11], MAX_INDIVIDUAL_VARIANCE) < 0.2f) {
                return i11;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final int[] getDataCharacterCounters() {
        return this.dataCharacterCounters;
    }

    public final int[] getDecodeFinderCounters() {
        return this.decodeFinderCounters;
    }

    public final int[] getEvenCounts() {
        return this.evenCounts;
    }

    public final float[] getEvenRoundingErrors() {
        return this.evenRoundingErrors;
    }

    public final int[] getOddCounts() {
        return this.oddCounts;
    }

    public final float[] getOddRoundingErrors() {
        return this.oddRoundingErrors;
    }
}
