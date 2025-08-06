package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;

public class GF2nONBField extends GF2nField {
    private static final int MAXLONG = 64;
    private int mBit;
    private int mLength;
    public int[][] mMult;
    private int mType;

    public GF2nONBField(int i11, SecureRandom secureRandom) throws RuntimeException {
        super(secureRandom);
        if (i11 >= 3) {
            this.mDegree = i11;
            int i12 = i11 / 64;
            this.mLength = i12;
            int i13 = i11 & 63;
            this.mBit = i13;
            if (i13 == 0) {
                this.mBit = 64;
            } else {
                this.mLength = i12 + 1;
            }
            computeType();
            if (this.mType < 3) {
                int i14 = this.mDegree;
                int[] iArr = new int[2];
                iArr[1] = 2;
                iArr[0] = i14;
                this.mMult = (int[][]) Array.newInstance(int.class, iArr);
                for (int i15 = 0; i15 < this.mDegree; i15++) {
                    int[][] iArr2 = this.mMult;
                    iArr2[i15][0] = -1;
                    iArr2[i15][1] = -1;
                }
                computeMultMatrix();
                computeFieldPolynomial();
                this.fields = new Vector();
                this.matrices = new Vector();
                return;
            }
            throw new RuntimeException("\nThe type of this field is " + this.mType);
        }
        throw new IllegalArgumentException("k must be at least 3");
    }

    private void computeMultMatrix() {
        int i11;
        int i12 = this.mType;
        if ((i12 & 7) != 0) {
            int i13 = (this.mDegree * i12) + 1;
            int[] iArr = new int[i13];
            int elementOfOrder = i12 == 1 ? 1 : i12 == 2 ? i13 - 1 : elementOfOrder(i12, i13);
            int i14 = 1;
            int i15 = 0;
            while (true) {
                i11 = this.mType;
                if (i15 >= i11) {
                    break;
                }
                int i16 = i14;
                for (int i17 = 0; i17 < this.mDegree; i17++) {
                    iArr[i16] = i17;
                    i16 = (i16 << 1) % i13;
                    if (i16 < 0) {
                        i16 += i13;
                    }
                }
                i14 = (i14 * elementOfOrder) % i13;
                if (i14 < 0) {
                    i14 += i13;
                }
                i15++;
            }
            if (i11 == 1) {
                int i18 = 1;
                while (i18 < i13 - 1) {
                    int[][] iArr2 = this.mMult;
                    int i19 = i18 + 1;
                    if (iArr2[iArr[i19]][0] == -1) {
                        iArr2[iArr[i19]][0] = iArr[i13 - i18];
                    } else {
                        iArr2[iArr[i19]][1] = iArr[i13 - i18];
                    }
                    i18 = i19;
                }
                int i21 = this.mDegree >> 1;
                for (int i22 = 1; i22 <= i21; i22++) {
                    int[][] iArr3 = this.mMult;
                    int i23 = i22 - 1;
                    if (iArr3[i23][0] == -1) {
                        iArr3[i23][0] = (i21 + i22) - 1;
                    } else {
                        iArr3[i23][1] = (i21 + i22) - 1;
                    }
                    int i24 = (i21 + i22) - 1;
                    if (iArr3[i24][0] == -1) {
                        iArr3[i24][0] = i23;
                    } else {
                        iArr3[i24][1] = i23;
                    }
                }
            } else if (i11 == 2) {
                int i25 = 1;
                while (i25 < i13 - 1) {
                    int[][] iArr4 = this.mMult;
                    int i26 = i25 + 1;
                    if (iArr4[iArr[i26]][0] == -1) {
                        iArr4[iArr[i26]][0] = iArr[i13 - i25];
                    } else {
                        iArr4[iArr[i26]][1] = iArr[i13 - i25];
                    }
                    i25 = i26;
                }
            } else {
                throw new RuntimeException("only type 1 or type 2 implemented");
            }
        } else {
            throw new RuntimeException("bisher nur fuer Gausssche Normalbasen implementiert");
        }
    }

    private void computeType() throws RuntimeException {
        if ((this.mDegree & 7) != 0) {
            this.mType = 1;
            int i11 = 0;
            while (i11 != 1) {
                int i12 = (this.mType * this.mDegree) + 1;
                if (IntegerFunctions.isPrime(i12)) {
                    int order = IntegerFunctions.order(2, i12);
                    int i13 = this.mType;
                    int i14 = this.mDegree;
                    i11 = IntegerFunctions.gcd((i13 * i14) / order, i14);
                }
                this.mType++;
            }
            int i15 = this.mType - 1;
            this.mType = i15;
            if (i15 == 1) {
                int i16 = (this.mDegree << 1) + 1;
                if (IntegerFunctions.isPrime(i16)) {
                    int order2 = IntegerFunctions.order(2, i16);
                    int i17 = this.mDegree;
                    if (IntegerFunctions.gcd((i17 << 1) / order2, i17) == 1) {
                        this.mType++;
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new RuntimeException("The extension degree is divisible by 8!");
    }

    private int elementOfOrder(int i11, int i12) {
        int order;
        Random random = new Random();
        int i13 = 0;
        while (i13 == 0) {
            int i14 = i12 - 1;
            i13 = random.nextInt() % i14;
            if (i13 < 0) {
                i13 += i14;
            }
        }
        while (true) {
            order = IntegerFunctions.order(i13, i12);
            if (order % i11 == 0 && order != 0) {
                break;
            }
            while (i13 == 0) {
                int i15 = i12 - 1;
                int nextInt = random.nextInt() % i15;
                if (nextInt < 0) {
                    nextInt += i15;
                }
            }
        }
        int i16 = i13;
        for (int i17 = 2; i17 <= i11 / order; i17++) {
            i16 *= i13;
        }
        return i16;
    }

    public void computeCOBMatrix(GF2nField gF2nField) {
        GF2nElement randomRoot;
        int i11 = this.mDegree;
        if (i11 == gF2nField.mDegree) {
            GF2Polynomial[] gF2PolynomialArr = new GF2Polynomial[i11];
            for (int i12 = 0; i12 < this.mDegree; i12++) {
                gF2PolynomialArr[i12] = new GF2Polynomial(this.mDegree);
            }
            do {
                randomRoot = gF2nField.getRandomRoot(this.fieldPolynomial);
            } while (randomRoot.isZero());
            GF2nElement[] gF2nElementArr = new GF2nPolynomialElement[this.mDegree];
            gF2nElementArr[0] = (GF2nElement) randomRoot.clone();
            for (int i13 = 1; i13 < this.mDegree; i13++) {
                gF2nElementArr[i13] = gF2nElementArr[i13 - 1].square();
            }
            for (int i14 = 0; i14 < this.mDegree; i14++) {
                for (int i15 = 0; i15 < this.mDegree; i15++) {
                    if (gF2nElementArr[i14].testBit(i15)) {
                        int i16 = this.mDegree;
                        gF2PolynomialArr[(i16 - i15) - 1].setBit((i16 - i14) - 1);
                    }
                }
            }
            this.fields.addElement(gF2nField);
            this.matrices.addElement(gF2PolynomialArr);
            gF2nField.fields.addElement(this);
            gF2nField.matrices.addElement(invertMatrix(gF2PolynomialArr));
            return;
        }
        throw new IllegalArgumentException("GF2nField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
    }

    public void computeFieldPolynomial() {
        GF2Polynomial gF2Polynomial;
        int i11 = this.mType;
        if (i11 == 1) {
            gF2Polynomial = new GF2Polynomial(this.mDegree + 1, "ALL");
        } else if (i11 == 2) {
            GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this.mDegree + 1, "ONE");
            GF2Polynomial gF2Polynomial3 = new GF2Polynomial(this.mDegree + 1, "X");
            gF2Polynomial3.addToThis(gF2Polynomial2);
            GF2Polynomial gF2Polynomial4 = gF2Polynomial2;
            gF2Polynomial = gF2Polynomial3;
            int i12 = 1;
            while (i12 < this.mDegree) {
                GF2Polynomial shiftLeft = gF2Polynomial.shiftLeft();
                shiftLeft.addToThis(gF2Polynomial4);
                i12++;
                gF2Polynomial4 = gF2Polynomial;
                gF2Polynomial = shiftLeft;
            }
        } else {
            return;
        }
        this.fieldPolynomial = gF2Polynomial;
    }

    public int getONBBit() {
        return this.mBit;
    }

    public int getONBLength() {
        return this.mLength;
    }

    public GF2nElement getRandomRoot(GF2Polynomial gF2Polynomial) {
        GF2nPolynomial gcd;
        int degree;
        int degree2;
        GF2nPolynomial gF2nPolynomial = new GF2nPolynomial(gF2Polynomial, (GF2nField) this);
        while (gF2nPolynomial.getDegree() > 1) {
            while (true) {
                GF2nONBElement gF2nONBElement = new GF2nONBElement(this, this.random);
                GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial(2, (GF2nElement) GF2nONBElement.ZERO(this));
                gF2nPolynomial2.set(1, gF2nONBElement);
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

    public int[][] invMatrix(int[][] iArr) {
        Class<int> cls = int.class;
        int i11 = this.mDegree;
        int[] iArr2 = new int[2];
        iArr2[1] = i11;
        iArr2[0] = i11;
        int[][] iArr3 = (int[][]) Array.newInstance(cls, iArr2);
        int i12 = this.mDegree;
        int[] iArr4 = new int[2];
        iArr4[1] = i12;
        iArr4[0] = i12;
        int[][] iArr5 = (int[][]) Array.newInstance(cls, iArr4);
        for (int i13 = 0; i13 < this.mDegree; i13++) {
            iArr5[i13][i13] = 1;
        }
        for (int i14 = 0; i14 < this.mDegree; i14++) {
            int i15 = i14;
            while (true) {
                int i16 = this.mDegree;
                if (i15 >= i16) {
                    break;
                }
                iArr[(i16 - 1) - i14][i15] = iArr[i14][i14];
                i15++;
            }
        }
        return null;
    }
}
