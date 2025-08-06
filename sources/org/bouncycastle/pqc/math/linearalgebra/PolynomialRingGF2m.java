package org.bouncycastle.pqc.math.linearalgebra;

public class PolynomialRingGF2m {
    private GF2mField field;

    /* renamed from: p  reason: collision with root package name */
    private PolynomialGF2mSmallM f59637p;
    public PolynomialGF2mSmallM[] sqMatrix;
    public PolynomialGF2mSmallM[] sqRootMatrix;

    public PolynomialRingGF2m(GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.field = gF2mField;
        this.f59637p = polynomialGF2mSmallM;
        computeSquaringMatrix();
        computeSquareRootMatrix();
    }

    private void computeSquareRootMatrix() {
        int coefficient;
        int degree = this.f59637p.getDegree();
        PolynomialGF2mSmallM[] polynomialGF2mSmallMArr = new PolynomialGF2mSmallM[degree];
        int i11 = degree - 1;
        for (int i12 = i11; i12 >= 0; i12--) {
            polynomialGF2mSmallMArr[i12] = new PolynomialGF2mSmallM(this.sqMatrix[i12]);
        }
        this.sqRootMatrix = new PolynomialGF2mSmallM[degree];
        while (i11 >= 0) {
            this.sqRootMatrix[i11] = new PolynomialGF2mSmallM(this.field, i11);
            i11--;
        }
        for (int i13 = 0; i13 < degree; i13++) {
            if (polynomialGF2mSmallMArr[i13].getCoefficient(i13) == 0) {
                int i14 = i13 + 1;
                boolean z11 = false;
                while (i14 < degree) {
                    if (polynomialGF2mSmallMArr[i14].getCoefficient(i13) != 0) {
                        swapColumns(polynomialGF2mSmallMArr, i13, i14);
                        swapColumns(this.sqRootMatrix, i13, i14);
                        i14 = degree;
                        z11 = true;
                    }
                    i14++;
                }
                if (!z11) {
                    throw new ArithmeticException("Squaring matrix is not invertible.");
                }
            }
            int inverse = this.field.inverse(polynomialGF2mSmallMArr[i13].getCoefficient(i13));
            polynomialGF2mSmallMArr[i13].multThisWithElement(inverse);
            this.sqRootMatrix[i13].multThisWithElement(inverse);
            for (int i15 = 0; i15 < degree; i15++) {
                if (!(i15 == i13 || (coefficient = polynomialGF2mSmallMArr[i15].getCoefficient(i13)) == 0)) {
                    PolynomialGF2mSmallM multWithElement = polynomialGF2mSmallMArr[i13].multWithElement(coefficient);
                    PolynomialGF2mSmallM multWithElement2 = this.sqRootMatrix[i13].multWithElement(coefficient);
                    polynomialGF2mSmallMArr[i15].addToThis(multWithElement);
                    this.sqRootMatrix[i15].addToThis(multWithElement2);
                }
            }
        }
    }

    private void computeSquaringMatrix() {
        int i11;
        int degree = this.f59637p.getDegree();
        this.sqMatrix = new PolynomialGF2mSmallM[degree];
        int i12 = 0;
        while (true) {
            i11 = degree >> 1;
            if (i12 >= i11) {
                break;
            }
            int i13 = i12 << 1;
            int[] iArr = new int[(i13 + 1)];
            iArr[i13] = 1;
            this.sqMatrix[i12] = new PolynomialGF2mSmallM(this.field, iArr);
            i12++;
        }
        while (i11 < degree) {
            int i14 = i11 << 1;
            int[] iArr2 = new int[(i14 + 1)];
            iArr2[i14] = 1;
            this.sqMatrix[i11] = new PolynomialGF2mSmallM(this.field, iArr2).mod(this.f59637p);
            i11++;
        }
    }

    private static void swapColumns(PolynomialGF2mSmallM[] polynomialGF2mSmallMArr, int i11, int i12) {
        PolynomialGF2mSmallM polynomialGF2mSmallM = polynomialGF2mSmallMArr[i11];
        polynomialGF2mSmallMArr[i11] = polynomialGF2mSmallMArr[i12];
        polynomialGF2mSmallMArr[i12] = polynomialGF2mSmallM;
    }

    public PolynomialGF2mSmallM[] getSquareRootMatrix() {
        return this.sqRootMatrix;
    }

    public PolynomialGF2mSmallM[] getSquaringMatrix() {
        return this.sqMatrix;
    }
}
