package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float sizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float sizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        if (Float.isNaN(sizeOfBlackWhiteBlackRunBothWays)) {
            return sizeOfBlackWhiteBlackRunBothWays2 / 7.0f;
        }
        return Float.isNaN(sizeOfBlackWhiteBlackRunBothWays2) ? sizeOfBlackWhiteBlackRunBothWays / 7.0f : (sizeOfBlackWhiteBlackRunBothWays + sizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    private static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f11) throws NotFoundException {
        int round = ((MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f11) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f11)) / 2) + 7;
        int i11 = round & 3;
        if (i11 == 0) {
            return round + 1;
        }
        if (i11 == 2) {
            return round - 1;
        }
        if (i11 != 3) {
            return round;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i11) {
        float f11;
        float f12;
        float f13;
        float f14 = ((float) i11) - 3.5f;
        if (resultPoint4 != null) {
            f12 = resultPoint4.getX();
            f11 = resultPoint4.getY();
            f13 = f14 - 3.0f;
        } else {
            f12 = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            f11 = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f13 = f14;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f14, 3.5f, f13, f13, 3.5f, f14, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), f12, f11, resultPoint3.getX(), resultPoint3.getY());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i11) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i11, i11, perspectiveTransform);
    }

    private float sizeOfBlackWhiteBlackRun(int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        boolean z11;
        Detector detector;
        boolean z12;
        boolean z13 = true;
        boolean z14 = Math.abs(i14 - i12) > Math.abs(i13 - i11);
        if (z14) {
            i17 = i11;
            i18 = i12;
            i15 = i13;
            i16 = i14;
        } else {
            i18 = i11;
            i17 = i12;
            i16 = i13;
            i15 = i14;
        }
        int abs = Math.abs(i16 - i18);
        int abs2 = Math.abs(i15 - i17);
        int i22 = 2;
        int i23 = (-abs) / 2;
        int i24 = -1;
        int i25 = i18 < i16 ? 1 : -1;
        if (i17 < i15) {
            i24 = 1;
        }
        int i26 = i16 + i25;
        int i27 = i18;
        int i28 = i17;
        int i29 = 0;
        while (true) {
            if (i27 == i26) {
                i19 = i26;
                i21 = i22;
                break;
            }
            int i30 = z14 ? i28 : i27;
            int i31 = z14 ? i27 : i28;
            if (i29 == z13) {
                z11 = z14;
                z12 = z13;
                i19 = i26;
                detector = this;
            } else {
                detector = this;
                z11 = z14;
                i19 = i26;
                z12 = false;
            }
            if (z12 == detector.image.get(i30, i31)) {
                if (i29 == 2) {
                    return MathUtils.distance(i27, i28, i18, i17);
                }
                i29++;
            }
            i23 += abs2;
            if (i23 > 0) {
                if (i28 == i15) {
                    i21 = 2;
                    break;
                }
                i28 += i24;
                i23 -= abs;
            }
            i27 += i25;
            i26 = i19;
            z14 = z11;
            z13 = true;
            i22 = 2;
        }
        if (i29 == i21) {
            return MathUtils.distance(i19, i15, i18, i17);
        }
        return Float.NaN;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i11, int i12, int i13, int i14) {
        float f11;
        float f12;
        float sizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i11, i12, i13, i14);
        int i15 = i11 - (i13 - i11);
        int i16 = 0;
        if (i15 < 0) {
            f11 = ((float) i11) / ((float) (i11 - i15));
            i15 = 0;
        } else if (i15 >= this.image.getWidth()) {
            f11 = ((float) ((this.image.getWidth() - 1) - i11)) / ((float) (i15 - i11));
            i15 = this.image.getWidth() - 1;
        } else {
            f11 = 1.0f;
        }
        float f13 = (float) i12;
        int i17 = (int) (f13 - (((float) (i14 - i12)) * f11));
        if (i17 < 0) {
            f12 = f13 / ((float) (i12 - i17));
        } else if (i17 >= this.image.getHeight()) {
            f12 = ((float) ((this.image.getHeight() - 1) - i12)) / ((float) (i17 - i12));
            i16 = this.image.getHeight() - 1;
        } else {
            i16 = i17;
            f12 = 1.0f;
        }
        return (sizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i11, i12, (int) (((float) i11) + (((float) (i15 - i11)) * f12)), i16)) - 1.0f;
    }

    public final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        return detect((Map<DecodeHintType, ?>) null);
    }

    public final AlignmentPattern findAlignmentInRegion(float f11, int i11, int i12, float f12) throws NotFoundException {
        int i13 = (int) (f12 * f11);
        int max = Math.max(0, i11 - i13);
        int min = Math.min(this.image.getWidth() - 1, i11 + i13) - max;
        float f13 = 3.0f * f11;
        if (((float) min) >= f13) {
            int max2 = Math.max(0, i12 - i13);
            int min2 = Math.min(this.image.getHeight() - 1, i12 + i13) - max2;
            if (((float) min2) >= f13) {
                return new AlignmentPatternFinder(this.image, max, max2, min, min2, f11, this.resultPointCallback).find();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final BitMatrix getImage() {
        return this.image;
    }

    public final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    public final DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
        ResultPoint[] resultPointArr;
        FinderPattern topLeft = finderPatternInfo.getTopLeft();
        FinderPattern topRight = finderPatternInfo.getTopRight();
        FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        float calculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (calculateModuleSize >= 1.0f) {
            int computeDimension = computeDimension(topLeft, topRight, bottomLeft, calculateModuleSize);
            Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(computeDimension);
            int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
            AlignmentPattern alignmentPattern = null;
            if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
                float x11 = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
                float y11 = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
                float f11 = 1.0f - (3.0f / ((float) dimensionForVersion));
                int x12 = (int) (topLeft.getX() + ((x11 - topLeft.getX()) * f11));
                int y12 = (int) (topLeft.getY() + (f11 * (y11 - topLeft.getY())));
                int i11 = 4;
                while (true) {
                    if (i11 > 16) {
                        break;
                    }
                    try {
                        alignmentPattern = findAlignmentInRegion(calculateModuleSize, x12, y12, (float) i11);
                        break;
                    } catch (NotFoundException unused) {
                        i11 <<= 1;
                    }
                }
            }
            BitMatrix sampleGrid = sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, alignmentPattern, computeDimension), computeDimension);
            if (alignmentPattern == null) {
                resultPointArr = new ResultPoint[]{bottomLeft, topLeft, topRight};
            } else {
                resultPointArr = new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPattern};
            }
            return new DetectorResult(sampleGrid, resultPointArr);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPointCallback resultPointCallback2;
        if (map == null) {
            resultPointCallback2 = null;
        } else {
            resultPointCallback2 = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        this.resultPointCallback = resultPointCallback2;
        return processFinderPatternInfo(new FinderPatternFinder(this.image, resultPointCallback2).find(map));
    }
}
