package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;

public final class ErrorCorrection {
    private final ModulusGF field = ModulusGF.PDF417_GF;

    private int[] findErrorLocations(ModulusPoly modulusPoly) throws ChecksumException {
        int degree = modulusPoly.getDegree();
        int[] iArr = new int[degree];
        int i11 = 0;
        for (int i12 = 1; i12 < this.field.getSize() && i11 < degree; i12++) {
            if (modulusPoly.evaluateAt(i12) == 0) {
                iArr[i11] = this.field.inverse(i12);
                i11++;
            }
        }
        if (i11 == degree) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] findErrorMagnitudes(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int[] iArr) {
        int degree = modulusPoly2.getDegree();
        int[] iArr2 = new int[degree];
        for (int i11 = 1; i11 <= degree; i11++) {
            iArr2[degree - i11] = this.field.multiply(i11, modulusPoly2.getCoefficient(i11));
        }
        ModulusPoly modulusPoly3 = new ModulusPoly(this.field, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i12 = 0; i12 < length; i12++) {
            int inverse = this.field.inverse(iArr[i12]);
            iArr3[i12] = this.field.multiply(this.field.subtract(0, modulusPoly.evaluateAt(inverse)), this.field.inverse(modulusPoly3.evaluateAt(inverse)));
        }
        return iArr3;
    }

    private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int i11) throws ChecksumException {
        if (modulusPoly.getDegree() < modulusPoly2.getDegree()) {
            ModulusPoly modulusPoly3 = modulusPoly2;
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly3;
        }
        ModulusPoly zero = this.field.getZero();
        ModulusPoly one = this.field.getOne();
        while (true) {
            ModulusPoly modulusPoly4 = r11;
            r11 = modulusPoly;
            modulusPoly = modulusPoly4;
            ModulusPoly modulusPoly5 = one;
            ModulusPoly modulusPoly6 = zero;
            zero = modulusPoly5;
            if (modulusPoly.getDegree() < i11 / 2) {
                int coefficient = zero.getCoefficient(0);
                if (coefficient != 0) {
                    int inverse = this.field.inverse(coefficient);
                    return new ModulusPoly[]{zero.multiply(inverse), modulusPoly.multiply(inverse)};
                }
                throw ChecksumException.getChecksumInstance();
            } else if (!modulusPoly.isZero()) {
                ModulusPoly zero2 = this.field.getZero();
                int inverse2 = this.field.inverse(modulusPoly.getCoefficient(modulusPoly.getDegree()));
                while (r11.getDegree() >= modulusPoly.getDegree() && !r11.isZero()) {
                    int degree = r11.getDegree() - modulusPoly.getDegree();
                    int multiply = this.field.multiply(r11.getCoefficient(r11.getDegree()), inverse2);
                    zero2 = zero2.add(this.field.buildMonomial(degree, multiply));
                    r11 = r11.subtract(modulusPoly.multiplyByMonomial(degree, multiply));
                }
                one = zero2.multiply(zero).subtract(modulusPoly6).negative();
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public int decode(int[] iArr, int i11, int[] iArr2) throws ChecksumException {
        ModulusPoly modulusPoly = new ModulusPoly(this.field, iArr);
        int[] iArr3 = new int[i11];
        int i12 = 0;
        boolean z11 = false;
        for (int i13 = i11; i13 > 0; i13--) {
            int evaluateAt = modulusPoly.evaluateAt(this.field.exp(i13));
            iArr3[i11 - i13] = evaluateAt;
            if (evaluateAt != 0) {
                z11 = true;
            }
        }
        if (!z11) {
            return 0;
        }
        ModulusPoly one = this.field.getOne();
        if (iArr2 != null) {
            for (int length : iArr2) {
                int exp = this.field.exp((iArr.length - 1) - length);
                ModulusGF modulusGF = this.field;
                one = one.multiply(new ModulusPoly(modulusGF, new int[]{modulusGF.subtract(0, exp), 1}));
            }
        }
        ModulusPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i11, 1), new ModulusPoly(this.field, iArr3), i11);
        ModulusPoly modulusPoly2 = runEuclideanAlgorithm[0];
        ModulusPoly modulusPoly3 = runEuclideanAlgorithm[1];
        int[] findErrorLocations = findErrorLocations(modulusPoly2);
        int[] findErrorMagnitudes = findErrorMagnitudes(modulusPoly3, modulusPoly2, findErrorLocations);
        while (i12 < findErrorLocations.length) {
            int length2 = (iArr.length - 1) - this.field.log(findErrorLocations[i12]);
            if (length2 >= 0) {
                iArr[length2] = this.field.subtract(iArr[length2], findErrorMagnitudes[i12]);
                i12++;
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
        return findErrorLocations.length;
    }
}
