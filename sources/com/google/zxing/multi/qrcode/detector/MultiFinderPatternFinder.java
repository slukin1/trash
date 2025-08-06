package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

final class MultiFinderPatternFinder extends FinderPatternFinder {
    private static final float DIFF_MODSIZE_CUTOFF = 0.5f;
    private static final float DIFF_MODSIZE_CUTOFF_PERCENT = 0.05f;
    private static final FinderPatternInfo[] EMPTY_RESULT_ARRAY = new FinderPatternInfo[0];
    private static final float MAX_MODULE_COUNT_PER_EDGE = 180.0f;
    private static final float MIN_MODULE_COUNT_PER_EDGE = 9.0f;

    public static final class ModuleSizeComparator implements Serializable, Comparator<FinderPattern> {
        private ModuleSizeComparator() {
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            double estimatedModuleSize = (double) (finderPattern2.getEstimatedModuleSize() - finderPattern.getEstimatedModuleSize());
            if (estimatedModuleSize < 0.0d) {
                return -1;
            }
            return estimatedModuleSize > 0.0d ? 1 : 0;
        }
    }

    public MultiFinderPatternFinder(BitMatrix bitMatrix) {
        super(bitMatrix);
    }

    private FinderPattern[][] selectMutipleBestPatterns() throws NotFoundException {
        char c11;
        char c12;
        List<FinderPattern> possibleCenters = getPossibleCenters();
        int size = possibleCenters.size();
        int i11 = 3;
        if (size >= 3) {
            char c13 = 2;
            char c14 = 0;
            if (size == 3) {
                return new FinderPattern[][]{new FinderPattern[]{possibleCenters.get(0), possibleCenters.get(1), possibleCenters.get(2)}};
            }
            Collections.sort(possibleCenters, new ModuleSizeComparator());
            ArrayList arrayList = new ArrayList();
            int i12 = 0;
            while (i12 < size - 2) {
                FinderPattern finderPattern = possibleCenters.get(i12);
                if (finderPattern != null) {
                    int i13 = i12 + 1;
                    while (i13 < size - 1) {
                        FinderPattern finderPattern2 = possibleCenters.get(i13);
                        if (finderPattern2 != null) {
                            float estimatedModuleSize = (finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) / Math.min(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
                            float f11 = 0.5f;
                            int i14 = (Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) > 0.5f ? 1 : (Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) == 0.5f ? 0 : -1));
                            float f12 = DIFF_MODSIZE_CUTOFF_PERCENT;
                            if (i14 > 0 && estimatedModuleSize >= DIFF_MODSIZE_CUTOFF_PERCENT) {
                                break;
                            }
                            int i15 = i13 + 1;
                            while (true) {
                                if (i15 >= size) {
                                    break;
                                }
                                FinderPattern finderPattern3 = possibleCenters.get(i15);
                                if (finderPattern3 != null) {
                                    float estimatedModuleSize2 = (finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) / Math.min(finderPattern2.getEstimatedModuleSize(), finderPattern3.getEstimatedModuleSize());
                                    if (Math.abs(finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) > f11 && estimatedModuleSize2 >= f12) {
                                        c11 = 2;
                                        break;
                                    }
                                    FinderPattern[] finderPatternArr = new FinderPattern[i11];
                                    finderPatternArr[c14] = finderPattern;
                                    finderPatternArr[1] = finderPattern2;
                                    c12 = 2;
                                    finderPatternArr[2] = finderPattern3;
                                    ResultPoint.orderBestPatterns(finderPatternArr);
                                    FinderPatternInfo finderPatternInfo = new FinderPatternInfo(finderPatternArr);
                                    float distance = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getBottomLeft());
                                    float distance2 = ResultPoint.distance(finderPatternInfo.getTopRight(), finderPatternInfo.getBottomLeft());
                                    float distance3 = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getTopRight());
                                    float estimatedModuleSize3 = (distance + distance3) / (finderPattern.getEstimatedModuleSize() * 2.0f);
                                    if (estimatedModuleSize3 <= 180.0f && estimatedModuleSize3 >= MIN_MODULE_COUNT_PER_EDGE && Math.abs((distance - distance3) / Math.min(distance, distance3)) < 0.1f) {
                                        float sqrt = (float) Math.sqrt((double) ((distance * distance) + (distance3 * distance3)));
                                        if (Math.abs((distance2 - sqrt) / Math.min(distance2, sqrt)) < 0.1f) {
                                            arrayList.add(finderPatternArr);
                                        }
                                    }
                                } else {
                                    c12 = c13;
                                }
                                i15++;
                                c13 = c12;
                                i11 = 3;
                                c14 = 0;
                                f11 = 0.5f;
                                f12 = DIFF_MODSIZE_CUTOFF_PERCENT;
                            }
                            i13++;
                            c13 = c11;
                            i11 = 3;
                            c14 = 0;
                        }
                        c11 = c13;
                        i13++;
                        c13 = c11;
                        i11 = 3;
                        c14 = 0;
                    }
                }
                i12++;
                c13 = c13;
                i11 = 3;
                c14 = 0;
            }
            if (!arrayList.isEmpty()) {
                return (FinderPattern[][]) arrayList.toArray(new FinderPattern[arrayList.size()][]);
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public FinderPatternInfo[] findMulti(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z11 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        BitMatrix image = getImage();
        int height = image.getHeight();
        int width = image.getWidth();
        int i11 = (height * 3) / 388;
        if (i11 < 3 || z11) {
            i11 = 3;
        }
        int[] iArr = new int[5];
        for (int i12 = i11 - 1; i12 < height; i12 += i11) {
            clearCounts(iArr);
            int i13 = 0;
            for (int i14 = 0; i14 < width; i14++) {
                if (image.get(i14, i12)) {
                    if ((i13 & 1) == 1) {
                        i13++;
                    }
                    iArr[i13] = iArr[i13] + 1;
                } else if ((i13 & 1) != 0) {
                    iArr[i13] = iArr[i13] + 1;
                } else if (i13 != 4) {
                    i13++;
                    iArr[i13] = iArr[i13] + 1;
                } else if (!FinderPatternFinder.foundPatternCross(iArr) || !handlePossibleCenter(iArr, i12, i14)) {
                    shiftCounts2(iArr);
                    i13 = 3;
                } else {
                    clearCounts(iArr);
                    i13 = 0;
                }
            }
            if (FinderPatternFinder.foundPatternCross(iArr)) {
                handlePossibleCenter(iArr, i12, width);
            }
        }
        FinderPattern[][] selectMutipleBestPatterns = selectMutipleBestPatterns();
        ArrayList arrayList = new ArrayList();
        for (FinderPattern[] finderPatternArr : selectMutipleBestPatterns) {
            ResultPoint.orderBestPatterns(finderPatternArr);
            arrayList.add(new FinderPatternInfo(finderPatternArr));
        }
        if (arrayList.isEmpty()) {
            return EMPTY_RESULT_ARRAY;
        }
        return (FinderPatternInfo[]) arrayList.toArray(new FinderPatternInfo[arrayList.size()]);
    }

    public MultiFinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        super(bitMatrix, resultPointCallback);
    }
}
