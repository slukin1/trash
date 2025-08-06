package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public final class DefaultGridSampler extends GridSampler {
    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i11, int i12, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, float f22, float f23, float f24, float f25, float f26, float f27) throws NotFoundException {
        BitMatrix bitMatrix2 = bitMatrix;
        int i13 = i11;
        int i14 = i12;
        return sampleGrid(bitMatrix, i11, i12, PerspectiveTransform.quadrilateralToQuadrilateral(f11, f12, f13, f14, f15, f16, f17, f18, f19, f21, f22, f23, f24, f25, f26, f27));
    }

    public BitMatrix sampleGrid(BitMatrix bitMatrix, int i11, int i12, PerspectiveTransform perspectiveTransform) throws NotFoundException {
        if (i11 <= 0 || i12 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        BitMatrix bitMatrix2 = new BitMatrix(i11, i12);
        int i13 = i11 * 2;
        float[] fArr = new float[i13];
        for (int i14 = 0; i14 < i12; i14++) {
            float f11 = ((float) i14) + 0.5f;
            for (int i15 = 0; i15 < i13; i15 += 2) {
                fArr[i15] = ((float) (i15 / 2)) + 0.5f;
                fArr[i15 + 1] = f11;
            }
            perspectiveTransform.transformPoints(fArr);
            GridSampler.checkAndNudgePoints(bitMatrix, fArr);
            int i16 = 0;
            while (i16 < i13) {
                try {
                    if (bitMatrix.get((int) fArr[i16], (int) fArr[i16 + 1])) {
                        bitMatrix2.set(i16 / 2, i14);
                    }
                    i16 += 2;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
        return bitMatrix2;
    }
}
