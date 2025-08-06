package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;

public class GF2nPolynomialField extends GF2nField {
    private boolean isPentanomial = false;
    private boolean isTrinomial = false;

    /* renamed from: pc  reason: collision with root package name */
    private int[] f59630pc = new int[3];
    public GF2Polynomial[] squaringMatrix;

    /* renamed from: tc  reason: collision with root package name */
    private int f59631tc;

    public GF2nPolynomialField(int i11, SecureRandom secureRandom) {
        super(secureRandom);
        if (i11 >= 3) {
            this.mDegree = i11;
            computeFieldPolynomial();
            computeSquaringMatrix();
            this.fields = new Vector();
            this.matrices = new Vector();
            return;
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    public GF2nPolynomialField(int i11, SecureRandom secureRandom, GF2Polynomial gF2Polynomial) throws RuntimeException {
        super(secureRandom);
        if (i11 < 3) {
            throw new IllegalArgumentException("degree must be at least 3");
        } else if (gF2Polynomial.getLength() != i11 + 1) {
            throw new RuntimeException();
        } else if (gF2Polynomial.isIrreducible()) {
            this.mDegree = i11;
            this.fieldPolynomial = gF2Polynomial;
            computeSquaringMatrix();
            int i12 = 2;
            for (int i13 = 1; i13 < this.fieldPolynomial.getLength() - 1; i13++) {
                if (this.fieldPolynomial.testBit(i13)) {
                    i12++;
                    if (i12 == 3) {
                        this.f59631tc = i13;
                    }
                    if (i12 <= 5) {
                        this.f59630pc[i12 - 3] = i13;
                    }
                }
            }
            if (i12 == 3) {
                this.isTrinomial = true;
            }
            if (i12 == 5) {
                this.isPentanomial = true;
            }
            this.fields = new Vector();
            this.matrices = new Vector();
        } else {
            throw new RuntimeException();
        }
    }

    public GF2nPolynomialField(int i11, SecureRandom secureRandom, boolean z11) {
        super(secureRandom);
        if (i11 >= 3) {
            this.mDegree = i11;
            if (z11) {
                computeFieldPolynomial();
            } else {
                computeFieldPolynomial2();
            }
            computeSquaringMatrix();
            this.fields = new Vector();
            this.matrices = new Vector();
            return;
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    private void computeSquaringMatrix() {
        int i11 = this.mDegree;
        GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[(i11 - 1)];
        this.squaringMatrix = new GF2Polynomial[i11];
        int i12 = 0;
        while (true) {
            GF2Polynomial[] gF2PolynomialArr2 = this.squaringMatrix;
            if (i12 >= gF2PolynomialArr2.length) {
                break;
            }
            gF2PolynomialArr2[i12] = new GF2Polynomial(this.mDegree, "ZERO");
            i12++;
        }
        for (int i13 = 0; i13 < this.mDegree - 1; i13++) {
            gF2PolynomialArr[i13] = new GF2Polynomial(1, "ONE").shiftLeft(this.mDegree + i13).remainder(this.fieldPolynomial);
        }
        for (int i14 = 1; i14 <= Math.abs(this.mDegree >> 1); i14++) {
            int i15 = 1;
            while (true) {
                int i16 = this.mDegree;
                if (i15 > i16) {
                    break;
                }
                if (gF2PolynomialArr[i16 - (i14 << 1)].testBit(i16 - i15)) {
                    this.squaringMatrix[i15 - 1].setBit(this.mDegree - i14);
                }
                i15++;
            }
        }
        int abs = Math.abs(this.mDegree >> 1) + 1;
        while (true) {
            int i17 = this.mDegree;
            if (abs <= i17) {
                this.squaringMatrix[((abs << 1) - i17) - 1].setBit(i17 - abs);
                abs++;
            } else {
                return;
            }
        }
    }

    private boolean testPentanomials() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree + 1);
        this.fieldPolynomial = gF2Polynomial;
        gF2Polynomial.setBit(0);
        this.fieldPolynomial.setBit(this.mDegree);
        boolean z11 = false;
        int i11 = 1;
        while (i11 <= this.mDegree - 3 && !z11) {
            this.fieldPolynomial.setBit(i11);
            int i12 = i11 + 1;
            int i13 = i12;
            while (i13 <= this.mDegree - 2 && !z11) {
                this.fieldPolynomial.setBit(i13);
                int i14 = i13 + 1;
                int i15 = i14;
                while (i15 <= this.mDegree - 1 && !z11) {
                    this.fieldPolynomial.setBit(i15);
                    if ((!(((this.mDegree & 1) != 0) | ((i11 & 1) != 0) | ((i13 & 1) != 0)) && !((i15 & 1) != 0)) || !(z11 = this.fieldPolynomial.isIrreducible())) {
                        this.fieldPolynomial.resetBit(i15);
                        i15++;
                    } else {
                        this.isPentanomial = true;
                        int[] iArr = this.f59630pc;
                        iArr[0] = i11;
                        iArr[1] = i13;
                        iArr[2] = i15;
                        return z11;
                    }
                }
                this.fieldPolynomial.resetBit(i13);
                i13 = i14;
            }
            this.fieldPolynomial.resetBit(i11);
            i11 = i12;
        }
        return z11;
    }

    private boolean testRandom() {
        this.fieldPolynomial = new GF2Polynomial(this.mDegree + 1);
        do {
            this.fieldPolynomial.randomize();
            this.fieldPolynomial.setBit(this.mDegree);
            this.fieldPolynomial.setBit(0);
        } while (!this.fieldPolynomial.isIrreducible());
        return true;
    }

    private boolean testTrinomials() {
        GF2Polynomial gF2Polynomial = new GF2Polynomial(this.mDegree + 1);
        this.fieldPolynomial = gF2Polynomial;
        boolean z11 = false;
        gF2Polynomial.setBit(0);
        this.fieldPolynomial.setBit(this.mDegree);
        for (int i11 = 1; i11 < this.mDegree && !z11; i11++) {
            this.fieldPolynomial.setBit(i11);
            boolean isIrreducible = this.fieldPolynomial.isIrreducible();
            if (isIrreducible) {
                this.isTrinomial = true;
                this.f59631tc = i11;
                return isIrreducible;
            }
            this.fieldPolynomial.resetBit(i11);
            z11 = this.fieldPolynomial.isIrreducible();
        }
        return z11;
    }

    public void computeCOBMatrix(GF2nField gF2nField) {
        GF2nElement randomRoot;
        GF2nElement[] gF2nElementArr;
        int i11 = this.mDegree;
        if (i11 == gF2nField.mDegree) {
            boolean z11 = gF2nField instanceof GF2nONBField;
            if (z11) {
                gF2nField.computeCOBMatrix(this);
                return;
            }
            GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[i11];
            for (int i12 = 0; i12 < this.mDegree; i12++) {
                gF2PolynomialArr[i12] = new GF2Polynomial(this.mDegree);
            }
            do {
                randomRoot = gF2nField.getRandomRoot(this.fieldPolynomial);
            } while (randomRoot.isZero());
            if (randomRoot instanceof GF2nONBElement) {
                int i13 = this.mDegree;
                gF2nElementArr = new GF2nONBElement[i13];
                gF2nElementArr[i13 - 1] = GF2nONBElement.ONE((GF2nONBField) gF2nField);
            } else {
                int i14 = this.mDegree;
                gF2nElementArr = new GF2nPolynomialElement[i14];
                gF2nElementArr[i14 - 1] = GF2nPolynomialElement.ONE((GF2nPolynomialField) gF2nField);
            }
            int i15 = this.mDegree;
            gF2nElementArr[i15 - 2] = randomRoot;
            for (int i16 = i15 - 3; i16 >= 0; i16--) {
                gF2nElementArr[i16] = (GF2nElement) gF2nElementArr[i16 + 1].multiply(randomRoot);
            }
            if (z11) {
                for (int i17 = 0; i17 < this.mDegree; i17++) {
                    int i18 = 0;
                    while (true) {
                        int i19 = this.mDegree;
                        if (i18 >= i19) {
                            break;
                        }
                        if (gF2nElementArr[i17].testBit((i19 - i18) - 1)) {
                            int i21 = this.mDegree;
                            gF2PolynomialArr[(i21 - i18) - 1].setBit((i21 - i17) - 1);
                        }
                        i18++;
                    }
                }
            } else {
                for (int i22 = 0; i22 < this.mDegree; i22++) {
                    for (int i23 = 0; i23 < this.mDegree; i23++) {
                        if (gF2nElementArr[i22].testBit(i23)) {
                            int i24 = this.mDegree;
                            gF2PolynomialArr[(i24 - i23) - 1].setBit((i24 - i22) - 1);
                        }
                    }
                }
            }
            this.fields.addElement(gF2nField);
            this.matrices.addElement(gF2PolynomialArr);
            gF2nField.fields.addElement(this);
            gF2nField.matrices.addElement(invertMatrix(gF2PolynomialArr));
            return;
        }
        throw new IllegalArgumentException("GF2nPolynomialField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
    }

    public void computeFieldPolynomial() {
        if (!testTrinomials() && !testPentanomials()) {
            testRandom();
        }
    }

    public void computeFieldPolynomial2() {
        if (!testTrinomials() && !testPentanomials()) {
            testRandom();
        }
    }

    public int[] getPc() throws RuntimeException {
        if (this.isPentanomial) {
            int[] iArr = new int[3];
            System.arraycopy(this.f59630pc, 0, iArr, 0, 3);
            return iArr;
        }
        throw new RuntimeException();
    }

    public GF2nElement getRandomRoot(GF2Polynomial gF2Polynomial) {
        GF2nPolynomial gcd;
        int degree;
        int degree2;
        GF2nPolynomial gF2nPolynomial = new GF2nPolynomial(gF2Polynomial, (GF2nField) this);
        while (gF2nPolynomial.getDegree() > 1) {
            while (true) {
                GF2nPolynomialElement gF2nPolynomialElement = new GF2nPolynomialElement(this, (Random) this.random);
                GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial(2, (GF2nElement) GF2nPolynomialElement.ZERO(this));
                gF2nPolynomial2.set(1, gF2nPolynomialElement);
                GF2nPolynomial gF2nPolynomial3 = new GF2nPolynomial(gF2nPolynomial2);
                for (int i11 = 1; i11 <= this.mDegree - 1; i11++) {
                    gF2nPolynomial3 = gF2nPolynomial3.multiplyAndReduce(gF2nPolynomial3, gF2nPolynomial).add(gF2nPolynomial2);
                }
                gcd = gF2nPolynomial3.gcd(gF2nPolynomial);
                degree = gcd.getDegree();
                degree2 = gF2nPolynomial.getDegree();
                if (degree != 0 && degree != degree2) {
                    break;
                }
            }
            gF2nPolynomial = (degree << 1) > degree2 ? gF2nPolynomial.quotient(gcd) : new GF2nPolynomial(gcd);
        }
        return gF2nPolynomial.at(0);
    }

    public GF2Polynomial getSquaringVector(int i11) {
        return new GF2Polynomial(this.squaringMatrix[i11]);
    }

    public int getTc() throws RuntimeException {
        if (this.isTrinomial) {
            return this.f59631tc;
        }
        throw new RuntimeException();
    }

    public boolean isPentanomial() {
        return this.isPentanomial;
    }

    public boolean isTrinomial() {
        return this.isTrinomial;
    }
}
