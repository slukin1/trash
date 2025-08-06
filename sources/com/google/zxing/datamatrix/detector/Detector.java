package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public final class Detector {
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

    public static final class ResultPointsAndTransitions {
        private final ResultPoint from;

        /* renamed from: to  reason: collision with root package name */
        private final ResultPoint f67178to;
        private final int transitions;

        public ResultPoint getFrom() {
            return this.from;
        }

        public ResultPoint getTo() {
            return this.f67178to;
        }

        public int getTransitions() {
            return this.transitions;
        }

        public String toString() {
            return this.from + "/" + this.f67178to + '/' + this.transitions;
        }

        private ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i11) {
            this.from = resultPoint;
            this.f67178to = resultPoint2;
            this.transitions = i11;
        }
    }

    public static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
        private ResultPointsAndTransitionsComparator() {
        }

        public int compare(ResultPointsAndTransitions resultPointsAndTransitions, ResultPointsAndTransitions resultPointsAndTransitions2) {
            return resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions();
        }
    }

    public Detector(BitMatrix bitMatrix) throws NotFoundException {
        this.image = bitMatrix;
        this.rectangleDetector = new WhiteRectangleDetector(bitMatrix);
    }

    private ResultPoint correctTopRight(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i11) {
        float f11 = (float) i11;
        float distance = ((float) distance(resultPoint, resultPoint2)) / f11;
        float distance2 = (float) distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
        float distance3 = ((float) distance(resultPoint, resultPoint3)) / f11;
        float distance4 = (float) distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)));
        if (isValid(resultPoint5)) {
            return (isValid(resultPoint6) && Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) > Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) ? resultPoint6 : resultPoint5;
        }
        if (isValid(resultPoint6)) {
            return resultPoint6;
        }
        return null;
    }

    private ResultPoint correctTopRightRectangular(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i11, int i12) {
        float distance = ((float) distance(resultPoint, resultPoint2)) / ((float) i11);
        float distance2 = (float) distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
        float distance3 = ((float) distance(resultPoint, resultPoint3)) / ((float) i12);
        float distance4 = (float) distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)));
        if (isValid(resultPoint5)) {
            return (isValid(resultPoint6) && Math.abs(i11 - transitionsBetween(resultPoint3, resultPoint5).getTransitions()) + Math.abs(i12 - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) > Math.abs(i11 - transitionsBetween(resultPoint3, resultPoint6).getTransitions()) + Math.abs(i12 - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) ? resultPoint6 : resultPoint5;
        }
        if (isValid(resultPoint6)) {
            return resultPoint6;
        }
        return null;
    }

    private static int distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2));
    }

    private static void increment(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Integer num = map.get(resultPoint);
        int i11 = 1;
        if (num != null) {
            i11 = 1 + num.intValue();
        }
        map.put(resultPoint, Integer.valueOf(i11));
    }

    private boolean isValid(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i11, int i12) throws NotFoundException {
        float f11 = ((float) i11) - 0.5f;
        float f12 = ((float) i12) - 0.5f;
        return GridSampler.getInstance().sampleGrid(bitMatrix, i11, i12, 0.5f, 0.5f, f11, 0.5f, f11, f12, 0.5f, f12, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint resultPoint, ResultPoint resultPoint2) {
        int x11 = (int) resultPoint.getX();
        int y11 = (int) resultPoint.getY();
        int x12 = (int) resultPoint2.getX();
        int y12 = (int) resultPoint2.getY();
        int i11 = 0;
        int i12 = 1;
        boolean z11 = Math.abs(y12 - y11) > Math.abs(x12 - x11);
        if (z11) {
            int i13 = y11;
            y11 = x11;
            x11 = i13;
            int i14 = y12;
            y12 = x12;
            x12 = i14;
        }
        int abs = Math.abs(x12 - x11);
        int abs2 = Math.abs(y12 - y11);
        int i15 = (-abs) / 2;
        int i16 = y11 < y12 ? 1 : -1;
        if (x11 >= x12) {
            i12 = -1;
        }
        boolean z12 = this.image.get(z11 ? y11 : x11, z11 ? x11 : y11);
        while (x11 != x12) {
            boolean z13 = this.image.get(z11 ? y11 : x11, z11 ? x11 : y11);
            if (z13 != z12) {
                i11++;
                z12 = z13;
            }
            i15 += abs2;
            if (i15 > 0) {
                if (y11 == y12) {
                    break;
                }
                y11 += i16;
                i15 -= abs;
            }
            x11 += i12;
        }
        return new ResultPointsAndTransitions(resultPoint, resultPoint2, i11);
    }

    public DetectorResult detect() throws NotFoundException {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        BitMatrix bitMatrix;
        ResultPoint[] detect = this.rectangleDetector.detect();
        ResultPoint resultPoint3 = detect[0];
        ResultPoint resultPoint4 = detect[1];
        ResultPoint resultPoint5 = detect[2];
        ResultPoint resultPoint6 = detect[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(transitionsBetween(resultPoint3, resultPoint4));
        arrayList.add(transitionsBetween(resultPoint3, resultPoint5));
        arrayList.add(transitionsBetween(resultPoint4, resultPoint6));
        arrayList.add(transitionsBetween(resultPoint5, resultPoint6));
        ResultPoint resultPoint7 = null;
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
        ResultPointsAndTransitions resultPointsAndTransitions = (ResultPointsAndTransitions) arrayList.get(0);
        ResultPointsAndTransitions resultPointsAndTransitions2 = (ResultPointsAndTransitions) arrayList.get(1);
        HashMap hashMap = new HashMap();
        increment(hashMap, resultPointsAndTransitions.getFrom());
        increment(hashMap, resultPointsAndTransitions.getTo());
        increment(hashMap, resultPointsAndTransitions2.getFrom());
        increment(hashMap, resultPointsAndTransitions2.getTo());
        ResultPoint resultPoint8 = null;
        ResultPoint resultPoint9 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            ResultPoint resultPoint10 = (ResultPoint) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                resultPoint8 = resultPoint10;
            } else if (resultPoint7 == null) {
                resultPoint7 = resultPoint10;
            } else {
                resultPoint9 = resultPoint10;
            }
        }
        if (resultPoint7 == null || resultPoint8 == null || resultPoint9 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint[] resultPointArr = {resultPoint7, resultPoint8, resultPoint9};
        ResultPoint.orderBestPatterns(resultPointArr);
        ResultPoint resultPoint11 = resultPointArr[0];
        ResultPoint resultPoint12 = resultPointArr[1];
        ResultPoint resultPoint13 = resultPointArr[2];
        if (!hashMap.containsKey(resultPoint3)) {
            resultPoint = resultPoint3;
        } else if (!hashMap.containsKey(resultPoint4)) {
            resultPoint = resultPoint4;
        } else {
            resultPoint = !hashMap.containsKey(resultPoint5) ? resultPoint5 : resultPoint6;
        }
        int transitions = transitionsBetween(resultPoint13, resultPoint).getTransitions();
        int transitions2 = transitionsBetween(resultPoint11, resultPoint).getTransitions();
        if ((transitions & 1) == 1) {
            transitions++;
        }
        int i11 = transitions + 2;
        if ((transitions2 & 1) == 1) {
            transitions2++;
        }
        int i12 = transitions2 + 2;
        if (i11 * 4 >= i12 * 7 || i12 * 4 >= i11 * 7) {
            resultPoint2 = resultPoint13;
            ResultPoint correctTopRightRectangular = correctTopRightRectangular(resultPoint12, resultPoint11, resultPoint13, resultPoint, i11, i12);
            if (correctTopRightRectangular != null) {
                resultPoint = correctTopRightRectangular;
            }
            int transitions3 = transitionsBetween(resultPoint2, resultPoint).getTransitions();
            int transitions4 = transitionsBetween(resultPoint11, resultPoint).getTransitions();
            if ((transitions3 & 1) == 1) {
                transitions3++;
            }
            int i13 = transitions3;
            if ((transitions4 & 1) == 1) {
                transitions4++;
            }
            bitMatrix = sampleGrid(this.image, resultPoint2, resultPoint12, resultPoint11, resultPoint, i13, transitions4);
        } else {
            ResultPoint correctTopRight = correctTopRight(resultPoint12, resultPoint11, resultPoint13, resultPoint, Math.min(i12, i11));
            if (correctTopRight != null) {
                resultPoint = correctTopRight;
            }
            int max = Math.max(transitionsBetween(resultPoint13, resultPoint).getTransitions(), transitionsBetween(resultPoint11, resultPoint).getTransitions()) + 1;
            if ((max & 1) == 1) {
                max++;
            }
            int i14 = max;
            bitMatrix = sampleGrid(this.image, resultPoint13, resultPoint12, resultPoint11, resultPoint, i14, i14);
            resultPoint2 = resultPoint13;
        }
        return new DetectorResult(bitMatrix, new ResultPoint[]{resultPoint2, resultPoint12, resultPoint11, resultPoint});
    }
}
