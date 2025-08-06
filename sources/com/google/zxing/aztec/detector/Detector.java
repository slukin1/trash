package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.tencent.rtmp.TXLiveConstants;

public final class Detector {
    private static final int[] EXPECTED_CORNER_BITS = {3808, 476, TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY, 1799};
    private boolean compact;
    private final BitMatrix image;
    private int nbCenterLayers;
    private int nbDataBlocks;
    private int nbLayers;
    private int shift;

    public static final class Point {

        /* renamed from: x  reason: collision with root package name */
        private final int f67170x;

        /* renamed from: y  reason: collision with root package name */
        private final int f67171y;

        public Point(int i11, int i12) {
            this.f67170x = i11;
            this.f67171y = i12;
        }

        public int getX() {
            return this.f67170x;
        }

        public int getY() {
            return this.f67171y;
        }

        public ResultPoint toResultPoint() {
            return new ResultPoint((float) getX(), (float) getY());
        }

        public String toString() {
            return "<" + this.f67170x + ' ' + this.f67171y + '>';
        }
    }

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private static float distance(Point point, Point point2) {
        return MathUtils.distance(point.getX(), point.getY(), point2.getX(), point2.getY());
    }

    private static ResultPoint[] expandSquare(ResultPoint[] resultPointArr, int i11, int i12) {
        float f11 = ((float) i12) / (((float) i11) * 2.0f);
        float x11 = resultPointArr[0].getX() - resultPointArr[2].getX();
        float y11 = resultPointArr[0].getY() - resultPointArr[2].getY();
        float x12 = (resultPointArr[0].getX() + resultPointArr[2].getX()) / 2.0f;
        float y12 = (resultPointArr[0].getY() + resultPointArr[2].getY()) / 2.0f;
        float f12 = x11 * f11;
        float f13 = y11 * f11;
        ResultPoint resultPoint = new ResultPoint(x12 + f12, y12 + f13);
        ResultPoint resultPoint2 = new ResultPoint(x12 - f12, y12 - f13);
        float x13 = resultPointArr[1].getX() - resultPointArr[3].getX();
        float y13 = resultPointArr[1].getY() - resultPointArr[3].getY();
        float x14 = (resultPointArr[1].getX() + resultPointArr[3].getX()) / 2.0f;
        float y14 = (resultPointArr[1].getY() + resultPointArr[3].getY()) / 2.0f;
        float f14 = x13 * f11;
        float f15 = f11 * y13;
        return new ResultPoint[]{resultPoint, new ResultPoint(x14 + f14, y14 + f15), resultPoint2, new ResultPoint(x14 - f14, y14 - f15)};
    }

    private void extractParameters(ResultPoint[] resultPointArr) throws NotFoundException {
        long j11;
        long j12;
        if (!isValid(resultPointArr[0]) || !isValid(resultPointArr[1]) || !isValid(resultPointArr[2]) || !isValid(resultPointArr[3])) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i11 = this.nbCenterLayers * 2;
        int[] iArr = {sampleLine(resultPointArr[0], resultPointArr[1], i11), sampleLine(resultPointArr[1], resultPointArr[2], i11), sampleLine(resultPointArr[2], resultPointArr[3], i11), sampleLine(resultPointArr[3], resultPointArr[0], i11)};
        this.shift = getRotation(iArr, i11);
        long j13 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            int i13 = iArr[(this.shift + i12) % 4];
            if (this.compact) {
                j12 = j13 << 7;
                j11 = (long) ((i13 >> 1) & 127);
            } else {
                j12 = j13 << 10;
                j11 = (long) (((i13 >> 2) & 992) + ((i13 >> 1) & 31));
            }
            j13 = j12 + j11;
        }
        int correctedParameterData = getCorrectedParameterData(j13, this.compact);
        if (this.compact) {
            this.nbLayers = (correctedParameterData >> 6) + 1;
            this.nbDataBlocks = (correctedParameterData & 63) + 1;
            return;
        }
        this.nbLayers = (correctedParameterData >> 11) + 1;
        this.nbDataBlocks = (correctedParameterData & 2047) + 1;
    }

    private ResultPoint[] getBullsEyeCorners(Point point) throws NotFoundException {
        this.nbCenterLayers = 1;
        Point point2 = point;
        Point point3 = point2;
        Point point4 = point3;
        boolean z11 = true;
        while (this.nbCenterLayers < 9) {
            Point firstDifferent = getFirstDifferent(point, z11, 1, -1);
            Point firstDifferent2 = getFirstDifferent(point2, z11, 1, 1);
            Point firstDifferent3 = getFirstDifferent(point3, z11, -1, 1);
            Point firstDifferent4 = getFirstDifferent(point4, z11, -1, -1);
            if (this.nbCenterLayers > 2) {
                double distance = (double) ((distance(firstDifferent4, firstDifferent) * ((float) this.nbCenterLayers)) / (distance(point4, point) * ((float) (this.nbCenterLayers + 2))));
                if (distance < 0.75d || distance > 1.25d || !isWhiteOrBlackRectangle(firstDifferent, firstDifferent2, firstDifferent3, firstDifferent4)) {
                    break;
                }
            }
            z11 = !z11;
            this.nbCenterLayers++;
            point4 = firstDifferent4;
            point = firstDifferent;
            point2 = firstDifferent2;
            point3 = firstDifferent3;
        }
        int i11 = this.nbCenterLayers;
        if (i11 == 5 || i11 == 7) {
            this.compact = i11 == 5;
            ResultPoint[] resultPointArr = {new ResultPoint(((float) point.getX()) + 0.5f, ((float) point.getY()) - 0.5f), new ResultPoint(((float) point2.getX()) + 0.5f, ((float) point2.getY()) + 0.5f), new ResultPoint(((float) point3.getX()) - 0.5f, ((float) point3.getY()) + 0.5f), new ResultPoint(((float) point4.getX()) - 0.5f, ((float) point4.getY()) - 0.5f)};
            int i12 = this.nbCenterLayers;
            return expandSquare(resultPointArr, (i12 * 2) - 3, i12 * 2);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int getColor(Point point, Point point2) {
        float distance = distance(point, point2);
        float x11 = ((float) (point2.getX() - point.getX())) / distance;
        float y11 = ((float) (point2.getY() - point.getY())) / distance;
        float x12 = (float) point.getX();
        float y12 = (float) point.getY();
        boolean z11 = this.image.get(point.getX(), point.getY());
        int ceil = (int) Math.ceil((double) distance);
        boolean z12 = false;
        int i11 = 0;
        for (int i12 = 0; i12 < ceil; i12++) {
            x12 += x11;
            y12 += y11;
            if (this.image.get(MathUtils.round(x12), MathUtils.round(y12)) != z11) {
                i11++;
            }
        }
        float f11 = ((float) i11) / distance;
        if (f11 > 0.1f && f11 < 0.9f) {
            return 0;
        }
        if (f11 <= 0.1f) {
            z12 = true;
        }
        return z12 == z11 ? 1 : -1;
    }

    private static int getCorrectedParameterData(long j11, boolean z11) throws NotFoundException {
        int i11;
        int i12;
        if (z11) {
            i11 = 7;
            i12 = 2;
        } else {
            i11 = 10;
            i12 = 4;
        }
        int i13 = i11 - i12;
        int[] iArr = new int[i11];
        for (int i14 = i11 - 1; i14 >= 0; i14--) {
            iArr[i14] = ((int) j11) & 15;
            j11 >>= 4;
        }
        try {
            new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(iArr, i13);
            int i15 = 0;
            for (int i16 = 0; i16 < i12; i16++) {
                i15 = (i15 << 4) + iArr[i16];
            }
            return i15;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private int getDimension() {
        if (this.compact) {
            return (this.nbLayers * 4) + 11;
        }
        int i11 = this.nbLayers;
        if (i11 <= 4) {
            return (i11 * 4) + 15;
        }
        return (i11 * 4) + ((((i11 - 4) / 8) + 1) * 2) + 15;
    }

    private Point getFirstDifferent(Point point, boolean z11, int i11, int i12) {
        int x11 = point.getX() + i11;
        int y11 = point.getY();
        while (true) {
            y11 += i12;
            if (!isValid(x11, y11) || this.image.get(x11, y11) != z11) {
                int i13 = x11 - i11;
                int i14 = y11 - i12;
            } else {
                x11 += i11;
            }
        }
        int i132 = x11 - i11;
        int i142 = y11 - i12;
        while (isValid(i132, i142) && this.image.get(i132, i142) == z11) {
            i132 += i11;
        }
        int i15 = i132 - i11;
        while (isValid(i15, i142) && this.image.get(i15, i142) == z11) {
            i142 += i12;
        }
        return new Point(i15, i142 - i12);
    }

    private Point getMatrixCenter() {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        ResultPoint resultPoint5;
        ResultPoint resultPoint6;
        ResultPoint resultPoint7;
        ResultPoint resultPoint8;
        try {
            ResultPoint[] detect = new WhiteRectangleDetector(this.image).detect();
            resultPoint3 = detect[0];
            resultPoint2 = detect[1];
            resultPoint = detect[2];
            resultPoint4 = detect[3];
        } catch (NotFoundException unused) {
            int width = this.image.getWidth() / 2;
            int height = this.image.getHeight() / 2;
            int i11 = width + 7;
            int i12 = height - 7;
            ResultPoint resultPoint9 = getFirstDifferent(new Point(i11, i12), false, 1, -1).toResultPoint();
            int i13 = height + 7;
            ResultPoint resultPoint10 = getFirstDifferent(new Point(i11, i13), false, 1, 1).toResultPoint();
            int i14 = width - 7;
            ResultPoint resultPoint11 = getFirstDifferent(new Point(i14, i13), false, -1, 1).toResultPoint();
            resultPoint4 = getFirstDifferent(new Point(i14, i12), false, -1, -1).toResultPoint();
            ResultPoint resultPoint12 = resultPoint10;
            resultPoint = resultPoint11;
            resultPoint3 = resultPoint9;
            resultPoint2 = resultPoint12;
        }
        int round = MathUtils.round((((resultPoint3.getX() + resultPoint4.getX()) + resultPoint2.getX()) + resultPoint.getX()) / 4.0f);
        int round2 = MathUtils.round((((resultPoint3.getY() + resultPoint4.getY()) + resultPoint2.getY()) + resultPoint.getY()) / 4.0f);
        try {
            ResultPoint[] detect2 = new WhiteRectangleDetector(this.image, 15, round, round2).detect();
            resultPoint6 = detect2[0];
            resultPoint5 = detect2[1];
            resultPoint7 = detect2[2];
            resultPoint8 = detect2[3];
        } catch (NotFoundException unused2) {
            int i15 = round + 7;
            int i16 = round2 - 7;
            resultPoint6 = getFirstDifferent(new Point(i15, i16), false, 1, -1).toResultPoint();
            int i17 = round2 + 7;
            resultPoint5 = getFirstDifferent(new Point(i15, i17), false, 1, 1).toResultPoint();
            int i18 = round - 7;
            resultPoint7 = getFirstDifferent(new Point(i18, i17), false, -1, 1).toResultPoint();
            resultPoint8 = getFirstDifferent(new Point(i18, i16), false, -1, -1).toResultPoint();
        }
        return new Point(MathUtils.round((((resultPoint6.getX() + resultPoint8.getX()) + resultPoint5.getX()) + resultPoint7.getX()) / 4.0f), MathUtils.round((((resultPoint6.getY() + resultPoint8.getY()) + resultPoint5.getY()) + resultPoint7.getY()) / 4.0f));
    }

    private ResultPoint[] getMatrixCornerPoints(ResultPoint[] resultPointArr) {
        return expandSquare(resultPointArr, this.nbCenterLayers * 2, getDimension());
    }

    private static int getRotation(int[] iArr, int i11) throws NotFoundException {
        int i12 = 0;
        for (int i13 : iArr) {
            i12 = (i12 << 3) + ((i13 >> (i11 - 2)) << 1) + (i13 & 1);
        }
        int i14 = ((i12 & 1) << 11) + (i12 >> 1);
        for (int i15 = 0; i15 < 4; i15++) {
            if (Integer.bitCount(EXPECTED_CORNER_BITS[i15] ^ i14) <= 2) {
                return i15;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private boolean isValid(int i11, int i12) {
        return i11 >= 0 && i11 < this.image.getWidth() && i12 > 0 && i12 < this.image.getHeight();
    }

    private boolean isWhiteOrBlackRectangle(Point point, Point point2, Point point3, Point point4) {
        Point point5 = new Point(point.getX() - 3, point.getY() + 3);
        Point point6 = new Point(point2.getX() - 3, point2.getY() - 3);
        Point point7 = new Point(point3.getX() + 3, point3.getY() - 3);
        Point point8 = new Point(point4.getX() + 3, point4.getY() + 3);
        int color = getColor(point8, point5);
        if (color != 0 && getColor(point5, point6) == color && getColor(point6, point7) == color && getColor(point7, point8) == color) {
            return true;
        }
        return false;
    }

    private BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        GridSampler instance = GridSampler.getInstance();
        int dimension = getDimension();
        int i11 = dimension;
        int i12 = dimension;
        float f11 = ((float) dimension) / 2.0f;
        int i13 = this.nbCenterLayers;
        float f12 = f11 - ((float) i13);
        float f13 = f11 + ((float) i13);
        return instance.sampleGrid(bitMatrix, i12, i11, f12, f12, f13, f12, f13, f13, f12, f13, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint4.getX(), resultPoint4.getY());
    }

    private int sampleLine(ResultPoint resultPoint, ResultPoint resultPoint2, int i11) {
        float distance = distance(resultPoint, resultPoint2);
        float f11 = distance / ((float) i11);
        float x11 = resultPoint.getX();
        float y11 = resultPoint.getY();
        float x12 = ((resultPoint2.getX() - resultPoint.getX()) * f11) / distance;
        float y12 = (f11 * (resultPoint2.getY() - resultPoint.getY())) / distance;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            float f12 = (float) i13;
            if (this.image.get(MathUtils.round((f12 * x12) + x11), MathUtils.round((f12 * y12) + y11))) {
                i12 |= 1 << ((i11 - i13) - 1);
            }
        }
        return i12;
    }

    public AztecDetectorResult detect() throws NotFoundException {
        return detect(false);
    }

    private static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private boolean isValid(ResultPoint resultPoint) {
        return isValid(MathUtils.round(resultPoint.getX()), MathUtils.round(resultPoint.getY()));
    }

    public AztecDetectorResult detect(boolean z11) throws NotFoundException {
        ResultPoint[] bullsEyeCorners = getBullsEyeCorners(getMatrixCenter());
        if (z11) {
            ResultPoint resultPoint = bullsEyeCorners[0];
            bullsEyeCorners[0] = bullsEyeCorners[2];
            bullsEyeCorners[2] = resultPoint;
        }
        extractParameters(bullsEyeCorners);
        BitMatrix bitMatrix = this.image;
        int i11 = this.shift;
        return new AztecDetectorResult(sampleGrid(bitMatrix, bullsEyeCorners[i11 % 4], bullsEyeCorners[(i11 + 1) % 4], bullsEyeCorners[(i11 + 2) % 4], bullsEyeCorners[(i11 + 3) % 4]), getMatrixCornerPoints(bullsEyeCorners), this.compact, this.nbDataBlocks, this.nbLayers);
    }
}
