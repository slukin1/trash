package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    public static final int MAX_MODULES = 97;
    public static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    public static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private CenterComparator(float f11) {
            this.average = f11;
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            int compare = Integer.compare(finderPattern2.getCount(), finderPattern.getCount());
            return compare == 0 ? Float.compare(Math.abs(finderPattern.getEstimatedModuleSize() - this.average), Math.abs(finderPattern2.getEstimatedModuleSize() - this.average)) : compare;
        }
    }

    public static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private FurthestFromAverageComparator(float f11) {
            this.average = f11;
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            return Float.compare(Math.abs(finderPattern2.getEstimatedModuleSize() - this.average), Math.abs(finderPattern.getEstimatedModuleSize() - this.average));
        }
    }

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, (ResultPointCallback) null);
    }

    private static float centerFromEnd(int[] iArr, int i11) {
        return ((float) ((i11 - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    private boolean crossCheckDiagonal(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int[] crossCheckStateCount2 = getCrossCheckStateCount();
        int i16 = 0;
        while (i11 >= i16 && i12 >= i16 && this.image.get(i12 - i16, i11 - i16)) {
            crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
            i16++;
        }
        if (crossCheckStateCount2[2] == 0) {
            return false;
        }
        while (i11 >= i16 && i12 >= i16 && !this.image.get(i12 - i16, i11 - i16)) {
            crossCheckStateCount2[1] = crossCheckStateCount2[1] + 1;
            i16++;
        }
        if (crossCheckStateCount2[1] == 0) {
            return false;
        }
        while (i11 >= i16 && i12 >= i16 && this.image.get(i12 - i16, i11 - i16)) {
            crossCheckStateCount2[0] = crossCheckStateCount2[0] + 1;
            i16++;
        }
        if (crossCheckStateCount2[0] == 0) {
            return false;
        }
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i17 = 1;
        while (true) {
            int i18 = i11 + i17;
            if (i18 < height && (i15 = i12 + i17) < width && this.image.get(i15, i18)) {
                crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
                i17++;
            }
        }
        while (true) {
            int i19 = i11 + i17;
            if (i19 < height && (i14 = i12 + i17) < width && !this.image.get(i14, i19)) {
                crossCheckStateCount2[3] = crossCheckStateCount2[3] + 1;
                i17++;
            }
        }
        if (crossCheckStateCount2[3] == 0) {
            return false;
        }
        while (true) {
            int i21 = i11 + i17;
            if (i21 < height && (i13 = i12 + i17) < width && this.image.get(i13, i21)) {
                crossCheckStateCount2[4] = crossCheckStateCount2[4] + 1;
                i17++;
            }
        }
        if (crossCheckStateCount2[4] == 0) {
            return false;
        }
        return foundPatternDiagonal(crossCheckStateCount2);
    }

    private float crossCheckHorizontal(int i11, int i12, int i13, int i14) {
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount2 = getCrossCheckStateCount();
        int i15 = i11;
        while (i15 >= 0 && bitMatrix.get(i15, i12)) {
            crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
            i15--;
        }
        if (i15 < 0) {
            return Float.NaN;
        }
        while (i15 >= 0 && !bitMatrix.get(i15, i12) && crossCheckStateCount2[1] <= i13) {
            crossCheckStateCount2[1] = crossCheckStateCount2[1] + 1;
            i15--;
        }
        if (i15 >= 0 && crossCheckStateCount2[1] <= i13) {
            while (i15 >= 0 && bitMatrix.get(i15, i12) && crossCheckStateCount2[0] <= i13) {
                crossCheckStateCount2[0] = crossCheckStateCount2[0] + 1;
                i15--;
            }
            if (crossCheckStateCount2[0] > i13) {
                return Float.NaN;
            }
            int i16 = i11 + 1;
            while (i16 < width && bitMatrix.get(i16, i12)) {
                crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
                i16++;
            }
            if (i16 == width) {
                return Float.NaN;
            }
            while (i16 < width && !bitMatrix.get(i16, i12) && crossCheckStateCount2[3] < i13) {
                crossCheckStateCount2[3] = crossCheckStateCount2[3] + 1;
                i16++;
            }
            if (i16 != width && crossCheckStateCount2[3] < i13) {
                while (i16 < width && bitMatrix.get(i16, i12) && crossCheckStateCount2[4] < i13) {
                    crossCheckStateCount2[4] = crossCheckStateCount2[4] + 1;
                    i16++;
                }
                if (crossCheckStateCount2[4] < i13 && Math.abs(((((crossCheckStateCount2[0] + crossCheckStateCount2[1]) + crossCheckStateCount2[2]) + crossCheckStateCount2[3]) + crossCheckStateCount2[4]) - i14) * 5 < i14 && foundPatternCross(crossCheckStateCount2)) {
                    return centerFromEnd(crossCheckStateCount2, i16);
                }
            }
        }
        return Float.NaN;
    }

    private float crossCheckVertical(int i11, int i12, int i13, int i14) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount2 = getCrossCheckStateCount();
        int i15 = i11;
        while (i15 >= 0 && bitMatrix.get(i12, i15)) {
            crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
            i15--;
        }
        if (i15 < 0) {
            return Float.NaN;
        }
        while (i15 >= 0 && !bitMatrix.get(i12, i15) && crossCheckStateCount2[1] <= i13) {
            crossCheckStateCount2[1] = crossCheckStateCount2[1] + 1;
            i15--;
        }
        if (i15 >= 0 && crossCheckStateCount2[1] <= i13) {
            while (i15 >= 0 && bitMatrix.get(i12, i15) && crossCheckStateCount2[0] <= i13) {
                crossCheckStateCount2[0] = crossCheckStateCount2[0] + 1;
                i15--;
            }
            if (crossCheckStateCount2[0] > i13) {
                return Float.NaN;
            }
            int i16 = i11 + 1;
            while (i16 < height && bitMatrix.get(i12, i16)) {
                crossCheckStateCount2[2] = crossCheckStateCount2[2] + 1;
                i16++;
            }
            if (i16 == height) {
                return Float.NaN;
            }
            while (i16 < height && !bitMatrix.get(i12, i16) && crossCheckStateCount2[3] < i13) {
                crossCheckStateCount2[3] = crossCheckStateCount2[3] + 1;
                i16++;
            }
            if (i16 != height && crossCheckStateCount2[3] < i13) {
                while (i16 < height && bitMatrix.get(i12, i16) && crossCheckStateCount2[4] < i13) {
                    crossCheckStateCount2[4] = crossCheckStateCount2[4] + 1;
                    i16++;
                }
                if (crossCheckStateCount2[4] < i13 && Math.abs(((((crossCheckStateCount2[0] + crossCheckStateCount2[1]) + crossCheckStateCount2[2]) + crossCheckStateCount2[3]) + crossCheckStateCount2[4]) - i14) * 5 < i14 * 2 && foundPatternCross(crossCheckStateCount2)) {
                    return centerFromEnd(crossCheckStateCount2, i16);
                }
            }
        }
        return Float.NaN;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern next : this.possibleCenters) {
            if (next.getCount() >= 2) {
                if (finderPattern == null) {
                    finderPattern = next;
                } else {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - next.getX()) - Math.abs(finderPattern.getY() - next.getY()))) / 2;
                }
            }
        }
        return 0;
    }

    public static boolean foundPatternCross(int[] iArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < 5; i12++) {
            int i13 = iArr[i12];
            if (i13 == 0) {
                return false;
            }
            i11 += i13;
        }
        if (i11 < 7) {
            return false;
        }
        float f11 = ((float) i11) / 7.0f;
        float f12 = f11 / 2.0f;
        if (Math.abs(f11 - ((float) iArr[0])) >= f12 || Math.abs(f11 - ((float) iArr[1])) >= f12 || Math.abs((f11 * 3.0f) - ((float) iArr[2])) >= 3.0f * f12 || Math.abs(f11 - ((float) iArr[3])) >= f12 || Math.abs(f11 - ((float) iArr[4])) >= f12) {
            return false;
        }
        return true;
    }

    public static boolean foundPatternDiagonal(int[] iArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < 5; i12++) {
            int i13 = iArr[i12];
            if (i13 == 0) {
                return false;
            }
            i11 += i13;
        }
        if (i11 < 7) {
            return false;
        }
        float f11 = ((float) i11) / 7.0f;
        float f12 = f11 / 1.333f;
        if (Math.abs(f11 - ((float) iArr[0])) >= f12 || Math.abs(f11 - ((float) iArr[1])) >= f12 || Math.abs((f11 * 3.0f) - ((float) iArr[2])) >= 3.0f * f12 || Math.abs(f11 - ((float) iArr[3])) >= f12 || Math.abs(f11 - ((float) iArr[4])) >= f12) {
            return false;
        }
        return true;
    }

    private int[] getCrossCheckStateCount() {
        clearCounts(this.crossCheckStateCount);
        return this.crossCheckStateCount;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i11 = 0;
        for (FinderPattern next : this.possibleCenters) {
            if (next.getCount() >= 2) {
                i11++;
                f12 += next.getEstimatedModuleSize();
            }
        }
        if (i11 < 3) {
            return false;
        }
        float f13 = f12 / ((float) size);
        for (FinderPattern estimatedModuleSize : this.possibleCenters) {
            f11 += Math.abs(estimatedModuleSize.getEstimatedModuleSize() - f13);
        }
        if (f11 <= f12 * 0.05f) {
            return true;
        }
        return false;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        int size = this.possibleCenters.size();
        if (size >= 3) {
            float f11 = 0.0f;
            if (size > 3) {
                float f12 = 0.0f;
                float f13 = 0.0f;
                for (FinderPattern estimatedModuleSize : this.possibleCenters) {
                    float estimatedModuleSize2 = estimatedModuleSize.getEstimatedModuleSize();
                    f12 += estimatedModuleSize2;
                    f13 += estimatedModuleSize2 * estimatedModuleSize2;
                }
                float f14 = (float) size;
                float f15 = f12 / f14;
                float sqrt = (float) Math.sqrt((double) ((f13 / f14) - (f15 * f15)));
                Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f15));
                float max = Math.max(0.2f * f15, sqrt);
                int i11 = 0;
                while (i11 < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                    if (Math.abs(this.possibleCenters.get(i11).getEstimatedModuleSize() - f15) > max) {
                        this.possibleCenters.remove(i11);
                        i11--;
                    }
                    i11++;
                }
            }
            if (this.possibleCenters.size() > 3) {
                for (FinderPattern estimatedModuleSize3 : this.possibleCenters) {
                    f11 += estimatedModuleSize3.getEstimatedModuleSize();
                }
                Collections.sort(this.possibleCenters, new CenterComparator(f11 / ((float) this.possibleCenters.size())));
                List<FinderPattern> list = this.possibleCenters;
                list.subList(3, list.size()).clear();
            }
            return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void clearCounts(int[] iArr) {
        for (int i11 = 0; i11 < iArr.length; i11++) {
            iArr[i11] = 0;
        }
    }

    public final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z11 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i11 = (height * 3) / 388;
        if (i11 < 3 || z11) {
            i11 = 3;
        }
        int[] iArr = new int[5];
        int i12 = i11 - 1;
        boolean z12 = false;
        while (i12 < height && !z12) {
            clearCounts(iArr);
            int i13 = 0;
            int i14 = 0;
            while (i13 < width) {
                if (this.image.get(i13, i12)) {
                    if ((i14 & 1) == 1) {
                        i14++;
                    }
                    iArr[i14] = iArr[i14] + 1;
                } else if ((i14 & 1) != 0) {
                    iArr[i14] = iArr[i14] + 1;
                } else if (i14 == 4) {
                    if (!foundPatternCross(iArr)) {
                        shiftCounts2(iArr);
                    } else if (handlePossibleCenter(iArr, i12, i13)) {
                        if (this.hasSkipped) {
                            z12 = haveMultiplyConfirmedCenters();
                        } else {
                            int findRowSkip = findRowSkip();
                            if (findRowSkip > iArr[2]) {
                                i12 += (findRowSkip - iArr[2]) - 2;
                                i13 = width - 1;
                            }
                        }
                        clearCounts(iArr);
                        i14 = 0;
                        i11 = 2;
                    } else {
                        shiftCounts2(iArr);
                    }
                    i14 = 3;
                } else {
                    i14++;
                    iArr[i14] = iArr[i14] + 1;
                }
                i13++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i12, width)) {
                i11 = iArr[0];
                if (this.hasSkipped) {
                    z12 = haveMultiplyConfirmedCenters();
                }
            }
            i12 += i11;
        }
        FinderPattern[] selectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }

    public final BitMatrix getImage() {
        return this.image;
    }

    public final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    @Deprecated
    public final boolean handlePossibleCenter(int[] iArr, int i11, int i12, boolean z11) {
        return handlePossibleCenter(iArr, i11, i12);
    }

    public final void shiftCounts2(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback2) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback2;
    }

    public final boolean handlePossibleCenter(int[] iArr, int i11, int i12) {
        boolean z11 = false;
        int i13 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int centerFromEnd = (int) centerFromEnd(iArr, i12);
        float crossCheckVertical = crossCheckVertical(i11, centerFromEnd, iArr[2], i13);
        if (!Float.isNaN(crossCheckVertical)) {
            int i14 = (int) crossCheckVertical;
            float crossCheckHorizontal = crossCheckHorizontal(centerFromEnd, i14, iArr[2], i13);
            if (!Float.isNaN(crossCheckHorizontal) && crossCheckDiagonal(i14, (int) crossCheckHorizontal)) {
                float f11 = ((float) i13) / 7.0f;
                int i15 = 0;
                while (true) {
                    if (i15 >= this.possibleCenters.size()) {
                        break;
                    }
                    FinderPattern finderPattern = this.possibleCenters.get(i15);
                    if (finderPattern.aboutEquals(f11, crossCheckVertical, crossCheckHorizontal)) {
                        this.possibleCenters.set(i15, finderPattern.combineEstimate(crossCheckVertical, crossCheckHorizontal, f11));
                        z11 = true;
                        break;
                    }
                    i15++;
                }
                if (!z11) {
                    FinderPattern finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, f11);
                    this.possibleCenters.add(finderPattern2);
                    ResultPointCallback resultPointCallback2 = this.resultPointCallback;
                    if (resultPointCallback2 != null) {
                        resultPointCallback2.foundPossibleResultPoint(finderPattern2);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
