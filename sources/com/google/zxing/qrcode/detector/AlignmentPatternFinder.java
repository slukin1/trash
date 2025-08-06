package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;

final class AlignmentPatternFinder {
    private final int[] crossCheckStateCount;
    private final int height;
    private final BitMatrix image;
    private final float moduleSize;
    private final List<AlignmentPattern> possibleCenters = new ArrayList(5);
    private final ResultPointCallback resultPointCallback;
    private final int startX;
    private final int startY;
    private final int width;

    public AlignmentPatternFinder(BitMatrix bitMatrix, int i11, int i12, int i13, int i14, float f11, ResultPointCallback resultPointCallback2) {
        this.image = bitMatrix;
        this.startX = i11;
        this.startY = i12;
        this.width = i13;
        this.height = i14;
        this.moduleSize = f11;
        this.crossCheckStateCount = new int[3];
        this.resultPointCallback = resultPointCallback2;
    }

    private static float centerFromEnd(int[] iArr, int i11) {
        return ((float) (i11 - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    private float crossCheckVertical(int i11, int i12, int i13, int i14) {
        BitMatrix bitMatrix = this.image;
        int height2 = bitMatrix.getHeight();
        int[] iArr = this.crossCheckStateCount;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i15 = i11;
        while (i15 >= 0 && bitMatrix.get(i12, i15) && iArr[1] <= i13) {
            iArr[1] = iArr[1] + 1;
            i15--;
        }
        if (i15 >= 0 && iArr[1] <= i13) {
            while (i15 >= 0 && !bitMatrix.get(i12, i15) && iArr[0] <= i13) {
                iArr[0] = iArr[0] + 1;
                i15--;
            }
            if (iArr[0] > i13) {
                return Float.NaN;
            }
            int i16 = i11 + 1;
            while (i16 < height2 && bitMatrix.get(i12, i16) && iArr[1] <= i13) {
                iArr[1] = iArr[1] + 1;
                i16++;
            }
            if (i16 != height2 && iArr[1] <= i13) {
                while (i16 < height2 && !bitMatrix.get(i12, i16) && iArr[2] <= i13) {
                    iArr[2] = iArr[2] + 1;
                    i16++;
                }
                if (iArr[2] <= i13 && Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i14) * 5 < i14 * 2 && foundPatternCross(iArr)) {
                    return centerFromEnd(iArr, i16);
                }
            }
        }
        return Float.NaN;
    }

    private boolean foundPatternCross(int[] iArr) {
        float f11 = this.moduleSize;
        float f12 = f11 / 2.0f;
        for (int i11 = 0; i11 < 3; i11++) {
            if (Math.abs(f11 - ((float) iArr[i11])) >= f12) {
                return false;
            }
        }
        return true;
    }

    private AlignmentPattern handlePossibleCenter(int[] iArr, int i11, int i12) {
        int i13 = iArr[0] + iArr[1] + iArr[2];
        float centerFromEnd = centerFromEnd(iArr, i12);
        float crossCheckVertical = crossCheckVertical(i11, (int) centerFromEnd, iArr[1] * 2, i13);
        if (Float.isNaN(crossCheckVertical)) {
            return null;
        }
        float f11 = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / 3.0f;
        for (AlignmentPattern next : this.possibleCenters) {
            if (next.aboutEquals(f11, crossCheckVertical, centerFromEnd)) {
                return next.combineEstimate(crossCheckVertical, centerFromEnd, f11);
            }
        }
        AlignmentPattern alignmentPattern = new AlignmentPattern(centerFromEnd, crossCheckVertical, f11);
        this.possibleCenters.add(alignmentPattern);
        ResultPointCallback resultPointCallback2 = this.resultPointCallback;
        if (resultPointCallback2 == null) {
            return null;
        }
        resultPointCallback2.foundPossibleResultPoint(alignmentPattern);
        return null;
    }

    public AlignmentPattern find() throws NotFoundException {
        AlignmentPattern handlePossibleCenter;
        AlignmentPattern handlePossibleCenter2;
        int i11 = this.startX;
        int i12 = this.height;
        int i13 = this.width + i11;
        int i14 = this.startY + (i12 / 2);
        int[] iArr = new int[3];
        for (int i15 = 0; i15 < i12; i15++) {
            int i16 = ((i15 & 1) == 0 ? (i15 + 1) / 2 : -((i15 + 1) / 2)) + i14;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i17 = i11;
            while (i17 < i13 && !this.image.get(i17, i16)) {
                i17++;
            }
            int i18 = 0;
            while (i17 < i13) {
                if (!this.image.get(i17, i16)) {
                    if (i18 == 1) {
                        i18++;
                    }
                    iArr[i18] = iArr[i18] + 1;
                } else if (i18 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i18 != 2) {
                    i18++;
                    iArr[i18] = iArr[i18] + 1;
                } else if (foundPatternCross(iArr) && (handlePossibleCenter2 = handlePossibleCenter(iArr, i16, i17)) != null) {
                    return handlePossibleCenter2;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i18 = 1;
                }
                i17++;
            }
            if (foundPatternCross(iArr) && (handlePossibleCenter = handlePossibleCenter(iArr, i16, i13)) != null) {
                return handlePossibleCenter;
            }
        }
        if (!this.possibleCenters.isEmpty()) {
            return this.possibleCenters.get(0);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
