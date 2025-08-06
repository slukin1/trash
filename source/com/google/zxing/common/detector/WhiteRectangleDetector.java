package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x11 = resultPoint.getX();
        float y11 = resultPoint.getY();
        float x12 = resultPoint2.getX();
        float y12 = resultPoint2.getY();
        float x13 = resultPoint3.getX();
        float y13 = resultPoint3.getY();
        float x14 = resultPoint4.getX();
        float y14 = resultPoint4.getY();
        if (x11 < ((float) this.width) / 2.0f) {
            return new ResultPoint[]{new ResultPoint(x14 - 1.0f, y14 + 1.0f), new ResultPoint(x12 + 1.0f, y12 + 1.0f), new ResultPoint(x13 - 1.0f, y13 - 1.0f), new ResultPoint(x11 + 1.0f, y11 - 1.0f)};
        }
        return new ResultPoint[]{new ResultPoint(x14 + 1.0f, y14 + 1.0f), new ResultPoint(x12 + 1.0f, y12 - 1.0f), new ResultPoint(x13 - 1.0f, y13 + 1.0f), new ResultPoint(x11 - 1.0f, y11 - 1.0f)};
    }

    private boolean containsBlackPoint(int i11, int i12, int i13, boolean z11) {
        if (z11) {
            while (i11 <= i12) {
                if (this.image.get(i11, i13)) {
                    return true;
                }
                i11++;
            }
            return false;
        }
        while (i11 <= i12) {
            if (this.image.get(i13, i11)) {
                return true;
            }
            i11++;
        }
        return false;
    }

    private ResultPoint getBlackPointOnSegment(float f11, float f12, float f13, float f14) {
        int round = MathUtils.round(MathUtils.distance(f11, f12, f13, f14));
        float f15 = (float) round;
        float f16 = (f13 - f11) / f15;
        float f17 = (f14 - f12) / f15;
        for (int i11 = 0; i11 < round; i11++) {
            float f18 = (float) i11;
            int round2 = MathUtils.round((f18 * f16) + f11);
            int round3 = MathUtils.round((f18 * f17) + f12);
            if (this.image.get(round2, round3)) {
                return new ResultPoint((float) round2, (float) round3);
            }
        }
        return null;
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i11 = this.leftInit;
        int i12 = this.rightInit;
        int i13 = this.upInit;
        int i14 = this.downInit;
        boolean z11 = false;
        int i15 = 1;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        boolean z17 = true;
        while (true) {
            if (!z17) {
                break;
            }
            boolean z18 = false;
            boolean z19 = true;
            while (true) {
                if ((z19 || !z12) && i12 < this.width) {
                    z19 = containsBlackPoint(i13, i14, i12, false);
                    if (z19) {
                        i12++;
                        z12 = true;
                        z18 = true;
                    } else if (!z12) {
                        i12++;
                    }
                }
            }
            if (i12 >= this.width) {
                break;
            }
            boolean z21 = true;
            while (true) {
                if ((z21 || !z13) && i14 < this.height) {
                    z21 = containsBlackPoint(i11, i12, i14, true);
                    if (z21) {
                        i14++;
                        z13 = true;
                        z18 = true;
                    } else if (!z13) {
                        i14++;
                    }
                }
            }
            if (i14 >= this.height) {
                break;
            }
            boolean z22 = true;
            while (true) {
                if ((z22 || !z14) && i11 >= 0) {
                    z22 = containsBlackPoint(i13, i14, i11, false);
                    if (z22) {
                        i11--;
                        z14 = true;
                        z18 = true;
                    } else if (!z14) {
                        i11--;
                    }
                }
            }
            if (i11 < 0) {
                break;
            }
            z17 = z18;
            boolean z23 = true;
            while (true) {
                if ((z23 || !z16) && i13 >= 0) {
                    z23 = containsBlackPoint(i11, i12, i13, true);
                    if (z23) {
                        i13--;
                        z17 = true;
                        z16 = true;
                    } else if (!z16) {
                        i13--;
                    }
                }
            }
            if (i13 < 0) {
                break;
            } else if (z17) {
                z15 = true;
            }
        }
        z11 = true;
        if (z11 || !z15) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i16 = i12 - i11;
        ResultPoint resultPoint = null;
        int i17 = 1;
        ResultPoint resultPoint2 = null;
        while (resultPoint2 == null && i17 < i16) {
            resultPoint2 = getBlackPointOnSegment((float) i11, (float) (i14 - i17), (float) (i11 + i17), (float) i14);
            i17++;
        }
        if (resultPoint2 != null) {
            int i18 = 1;
            ResultPoint resultPoint3 = null;
            while (resultPoint3 == null && i18 < i16) {
                resultPoint3 = getBlackPointOnSegment((float) i11, (float) (i13 + i18), (float) (i11 + i18), (float) i13);
                i18++;
            }
            if (resultPoint3 != null) {
                int i19 = 1;
                ResultPoint resultPoint4 = null;
                while (resultPoint4 == null && i19 < i16) {
                    resultPoint4 = getBlackPointOnSegment((float) i12, (float) (i13 + i19), (float) (i12 - i19), (float) i13);
                    i19++;
                }
                if (resultPoint4 != null) {
                    while (resultPoint == null && i15 < i16) {
                        resultPoint = getBlackPointOnSegment((float) i12, (float) (i14 - i15), (float) (i12 - i15), (float) i14);
                        i15++;
                    }
                    if (resultPoint != null) {
                        return centerEdges(resultPoint, resultPoint2, resultPoint4, resultPoint3);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i11, int i12, int i13) throws NotFoundException {
        this.image = bitMatrix;
        int height2 = bitMatrix.getHeight();
        this.height = height2;
        int width2 = bitMatrix.getWidth();
        this.width = width2;
        int i14 = i11 / 2;
        int i15 = i12 - i14;
        this.leftInit = i15;
        int i16 = i12 + i14;
        this.rightInit = i16;
        int i17 = i13 - i14;
        this.upInit = i17;
        int i18 = i13 + i14;
        this.downInit = i18;
        if (i17 < 0 || i15 < 0 || i18 >= height2 || i16 >= width2) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
