package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;

public final class GoppaCode {

    public static class MaMaPe {

        /* renamed from: h  reason: collision with root package name */
        private GF2Matrix f59632h;

        /* renamed from: p  reason: collision with root package name */
        private Permutation f59633p;

        /* renamed from: s  reason: collision with root package name */
        private GF2Matrix f59634s;

        public MaMaPe(GF2Matrix gF2Matrix, GF2Matrix gF2Matrix2, Permutation permutation) {
            this.f59634s = gF2Matrix;
            this.f59632h = gF2Matrix2;
            this.f59633p = permutation;
        }

        public GF2Matrix getFirstMatrix() {
            return this.f59634s;
        }

        public Permutation getPermutation() {
            return this.f59633p;
        }

        public GF2Matrix getSecondMatrix() {
            return this.f59632h;
        }
    }

    public static class MatrixSet {

        /* renamed from: g  reason: collision with root package name */
        private GF2Matrix f59635g;
        private int[] setJ;

        public MatrixSet(GF2Matrix gF2Matrix, int[] iArr) {
            this.f59635g = gF2Matrix;
            this.setJ = iArr;
        }

        public GF2Matrix getG() {
            return this.f59635g;
        }

        public int[] getSetJ() {
            return this.setJ;
        }
    }

    private GoppaCode() {
    }

    public static MaMaPe computeSystematicForm(GF2Matrix gF2Matrix, SecureRandom secureRandom) {
        Permutation permutation;
        GF2Matrix gF2Matrix2;
        GF2Matrix leftSubMatrix;
        boolean z11;
        int numColumns = gF2Matrix.getNumColumns();
        GF2Matrix gF2Matrix3 = null;
        do {
            permutation = new Permutation(numColumns, secureRandom);
            gF2Matrix2 = (GF2Matrix) gF2Matrix.rightMultiply(permutation);
            leftSubMatrix = gF2Matrix2.getLeftSubMatrix();
            z11 = true;
            try {
                gF2Matrix3 = (GF2Matrix) leftSubMatrix.computeInverse();
                continue;
            } catch (ArithmeticException unused) {
                z11 = false;
                continue;
            }
        } while (!z11);
        return new MaMaPe(leftSubMatrix, ((GF2Matrix) gF2Matrix3.rightMultiply((Matrix) gF2Matrix2)).getRightSubMatrix(), permutation);
    }

    public static GF2Matrix createCanonicalCheckMatrix(GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM) {
        GF2mField gF2mField2 = gF2mField;
        PolynomialGF2mSmallM polynomialGF2mSmallM2 = polynomialGF2mSmallM;
        Class<int> cls = int.class;
        int degree = gF2mField.getDegree();
        int i11 = 1 << degree;
        int degree2 = polynomialGF2mSmallM.getDegree();
        int[] iArr = new int[2];
        iArr[1] = i11;
        int i12 = 0;
        iArr[0] = degree2;
        int[][] iArr2 = (int[][]) Array.newInstance(cls, iArr);
        int[] iArr3 = new int[2];
        iArr3[1] = i11;
        iArr3[0] = degree2;
        int[][] iArr4 = (int[][]) Array.newInstance(cls, iArr3);
        for (int i13 = 0; i13 < i11; i13++) {
            iArr4[0][i13] = gF2mField2.inverse(polynomialGF2mSmallM2.evaluateAt(i13));
        }
        for (int i14 = 1; i14 < degree2; i14++) {
            for (int i15 = 0; i15 < i11; i15++) {
                iArr4[i14][i15] = gF2mField2.mult(iArr4[i14 - 1][i15], i15);
            }
        }
        int i16 = 0;
        while (i16 < degree2) {
            int i17 = i12;
            while (i17 < i11) {
                for (int i18 = i12; i18 <= i16; i18++) {
                    iArr2[i16][i17] = gF2mField2.add(iArr2[i16][i17], gF2mField2.mult(iArr4[i18][i17], polynomialGF2mSmallM2.getCoefficient((degree2 + i18) - i16)));
                }
                i17++;
                i12 = 0;
            }
            i16++;
            i12 = 0;
        }
        int[] iArr5 = new int[2];
        iArr5[1] = (i11 + 31) >>> 5;
        iArr5[0] = degree2 * degree;
        int[][] iArr6 = (int[][]) Array.newInstance(cls, iArr5);
        for (int i19 = 0; i19 < i11; i19++) {
            int i21 = i19 >>> 5;
            int i22 = 1 << (i19 & 31);
            for (int i23 = 0; i23 < degree2; i23++) {
                int i24 = iArr2[i23][i19];
                for (int i25 = 0; i25 < degree; i25++) {
                    if (((i24 >>> i25) & 1) != 0) {
                        int[] iArr7 = iArr6[(((i23 + 1) * degree) - i25) - 1];
                        iArr7[i21] = iArr7[i21] ^ i22;
                    }
                }
            }
        }
        return new GF2Matrix(i11, iArr6);
    }

    public static GF2Vector syndromeDecode(GF2Vector gF2Vector, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        int degree = 1 << gF2mField.getDegree();
        GF2Vector gF2Vector2 = new GF2Vector(degree);
        if (!gF2Vector.isZero()) {
            PolynomialGF2mSmallM[] modPolynomialToFracton = new PolynomialGF2mSmallM(gF2Vector.toExtensionFieldVector(gF2mField)).modInverse(polynomialGF2mSmallM).addMonomial(1).modSquareRootMatrix(polynomialGF2mSmallMArr).modPolynomialToFracton(polynomialGF2mSmallM);
            PolynomialGF2mSmallM add = modPolynomialToFracton[0].multiply(modPolynomialToFracton[0]).add(modPolynomialToFracton[1].multiply(modPolynomialToFracton[1]).multWithMonomial(1));
            PolynomialGF2mSmallM multWithElement = add.multWithElement(gF2mField.inverse(add.getHeadCoefficient()));
            for (int i11 = 0; i11 < degree; i11++) {
                if (multWithElement.evaluateAt(i11) == 0) {
                    gF2Vector2.setBit(i11);
                }
            }
        }
        return gF2Vector2;
    }
}
