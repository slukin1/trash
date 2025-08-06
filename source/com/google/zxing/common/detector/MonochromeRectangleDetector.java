package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

@Deprecated
public final class MonochromeRectangleDetector {
    private static final int MAX_MODULES = 32;
    private final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private int[] blackWhiteRange(int i11, int i12, int i13, int i14, boolean z11) {
        int i15 = (i13 + i14) / 2;
        int i16 = i15;
        while (i16 >= i13) {
            BitMatrix bitMatrix = this.image;
            if (!z11 ? !bitMatrix.get(i11, i16) : !bitMatrix.get(i16, i11)) {
                int i17 = i16;
                while (true) {
                    i17--;
                    if (i17 < i13) {
                        break;
                    }
                    BitMatrix bitMatrix2 = this.image;
                    if (z11) {
                        if (bitMatrix2.get(i17, i11)) {
                            break;
                        }
                    } else if (bitMatrix2.get(i11, i17)) {
                        break;
                    }
                }
                int i18 = i16 - i17;
                if (i17 < i13 || i18 > i12) {
                    break;
                }
                i16 = i17;
            } else {
                i16--;
            }
        }
        int i19 = i16 + 1;
        while (i15 < i14) {
            BitMatrix bitMatrix3 = this.image;
            if (!z11 ? !bitMatrix3.get(i11, i15) : !bitMatrix3.get(i15, i11)) {
                int i21 = i15;
                while (true) {
                    i21++;
                    if (i21 >= i14) {
                        break;
                    }
                    BitMatrix bitMatrix4 = this.image;
                    if (z11) {
                        if (bitMatrix4.get(i21, i11)) {
                            break;
                        }
                    } else if (bitMatrix4.get(i11, i21)) {
                        break;
                    }
                }
                int i22 = i21 - i15;
                if (i21 >= i14 || i22 > i12) {
                    break;
                }
                i15 = i21;
            } else {
                i15++;
            }
        }
        int i23 = i15 - 1;
        if (i23 <= i19) {
            return null;
        }
        return new int[]{i19, i23};
    }

    private ResultPoint findCornerFromCenter(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) throws NotFoundException {
        int[] iArr;
        int i21 = i11;
        int i22 = i15;
        int[] iArr2 = null;
        int i23 = i18;
        int i24 = i21;
        int i25 = i22;
        while (i25 < i23 && i25 >= i17 && i24 < i14 && i24 >= i13) {
            if (i12 == 0) {
                iArr = blackWhiteRange(i25, i19, i13, i14, true);
            } else {
                iArr = blackWhiteRange(i24, i19, i17, i18, false);
            }
            if (iArr != null) {
                i25 += i16;
                i24 += i12;
                iArr2 = iArr;
            } else if (iArr2 != null) {
                char c11 = 1;
                if (i12 == 0) {
                    int i26 = i25 - i16;
                    if (iArr2[0] >= i21) {
                        return new ResultPoint((float) iArr2[1], (float) i26);
                    }
                    if (iArr2[1] <= i21) {
                        return new ResultPoint((float) iArr2[0], (float) i26);
                    }
                    if (i16 > 0) {
                        c11 = 0;
                    }
                    return new ResultPoint((float) iArr2[c11], (float) i26);
                }
                int i27 = i24 - i12;
                if (iArr2[0] >= i22) {
                    return new ResultPoint((float) i27, (float) iArr2[1]);
                }
                if (iArr2[1] <= i22) {
                    return new ResultPoint((float) i27, (float) iArr2[0]);
                }
                float f11 = (float) i27;
                if (i12 < 0) {
                    c11 = 0;
                }
                return new ResultPoint(f11, (float) iArr2[c11]);
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public ResultPoint[] detect() throws NotFoundException {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i11 = height / 2;
        int i12 = width / 2;
        int max = Math.max(1, height / 256);
        int i13 = -max;
        int i14 = i12 / 2;
        int i15 = i12;
        int i16 = width;
        int i17 = i11;
        int i18 = i13;
        int i19 = height;
        int i21 = max;
        int max2 = Math.max(1, width / 256);
        int i22 = -max2;
        int y11 = ((int) findCornerFromCenter(i15, 0, 0, i16, i17, i13, 0, i19, i14).getY()) - 1;
        int i23 = max2;
        int i24 = i11 / 2;
        ResultPoint findCornerFromCenter = findCornerFromCenter(i15, i22, 0, i16, i17, 0, y11, i19, i24);
        int x11 = ((int) findCornerFromCenter.getX()) - 1;
        ResultPoint findCornerFromCenter2 = findCornerFromCenter(i15, i23, x11, i16, i17, 0, y11, i19, i24);
        int x12 = ((int) findCornerFromCenter2.getX()) + 1;
        ResultPoint findCornerFromCenter3 = findCornerFromCenter(i15, 0, x11, x12, i17, i21, y11, i19, i14);
        return new ResultPoint[]{findCornerFromCenter(i15, 0, x11, x12, i17, i18, y11, ((int) findCornerFromCenter3.getY()) + 1, i12 / 4), findCornerFromCenter, findCornerFromCenter2, findCornerFromCenter3};
    }
}
