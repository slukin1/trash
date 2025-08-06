package org.bouncycastle.pqc.math.linearalgebra;

public class GF2nPolynomial {
    private GF2nElement[] coeff;
    private int size;

    private GF2nPolynomial(int i11) {
        this.size = i11;
        this.coeff = new GF2nElement[i11];
    }

    public GF2nPolynomial(int i11, GF2nElement gF2nElement) {
        this.size = i11;
        this.coeff = new GF2nElement[i11];
        for (int i12 = 0; i12 < this.size; i12++) {
            this.coeff[i12] = (GF2nElement) gF2nElement.clone();
        }
    }

    public GF2nPolynomial(GF2Polynomial gF2Polynomial, GF2nField gF2nField) {
        int degree = gF2nField.getDegree() + 1;
        this.size = degree;
        this.coeff = new GF2nElement[degree];
        int i11 = 0;
        if (gF2nField instanceof GF2nONBField) {
            while (i11 < this.size) {
                if (gF2Polynomial.testBit(i11)) {
                    this.coeff[i11] = GF2nONBElement.ONE((GF2nONBField) gF2nField);
                } else {
                    this.coeff[i11] = GF2nONBElement.ZERO((GF2nONBField) gF2nField);
                }
                i11++;
            }
        } else if (gF2nField instanceof GF2nPolynomialField) {
            while (i11 < this.size) {
                if (gF2Polynomial.testBit(i11)) {
                    this.coeff[i11] = GF2nPolynomialElement.ONE((GF2nPolynomialField) gF2nField);
                } else {
                    this.coeff[i11] = GF2nPolynomialElement.ZERO((GF2nPolynomialField) gF2nField);
                }
                i11++;
            }
        } else {
            throw new IllegalArgumentException("PolynomialGF2n(Bitstring, GF2nField): B1 must be an instance of GF2nONBField or GF2nPolynomialField!");
        }
    }

    public GF2nPolynomial(GF2nPolynomial gF2nPolynomial) {
        int i11 = gF2nPolynomial.size;
        this.coeff = new GF2nElement[i11];
        this.size = i11;
        for (int i12 = 0; i12 < this.size; i12++) {
            this.coeff[i12] = (GF2nElement) gF2nPolynomial.coeff[i12].clone();
        }
    }

    public final GF2nPolynomial add(GF2nPolynomial gF2nPolynomial) {
        GF2nPolynomial gF2nPolynomial2;
        int i11 = 0;
        if (size() >= gF2nPolynomial.size()) {
            gF2nPolynomial2 = new GF2nPolynomial(size());
            while (i11 < gF2nPolynomial.size()) {
                gF2nPolynomial2.coeff[i11] = (GF2nElement) this.coeff[i11].add(gF2nPolynomial.coeff[i11]);
                i11++;
            }
            while (i11 < size()) {
                gF2nPolynomial2.coeff[i11] = this.coeff[i11];
                i11++;
            }
        } else {
            gF2nPolynomial2 = new GF2nPolynomial(gF2nPolynomial.size());
            while (i11 < size()) {
                gF2nPolynomial2.coeff[i11] = (GF2nElement) this.coeff[i11].add(gF2nPolynomial.coeff[i11]);
                i11++;
            }
            while (i11 < gF2nPolynomial.size()) {
                gF2nPolynomial2.coeff[i11] = gF2nPolynomial.coeff[i11];
                i11++;
            }
        }
        return gF2nPolynomial2;
    }

    public final void assignZeroToElements() {
        for (int i11 = 0; i11 < this.size; i11++) {
            this.coeff[i11].assignZero();
        }
    }

    public final GF2nElement at(int i11) {
        return this.coeff[i11];
    }

    public final GF2nPolynomial[] divide(GF2nPolynomial gF2nPolynomial) {
        GF2nPolynomial gF2nPolynomial2;
        GF2nPolynomial[] gF2nPolynomialArr = new GF2nPolynomial[2];
        GF2nPolynomial gF2nPolynomial3 = new GF2nPolynomial(this);
        gF2nPolynomial3.shrink();
        int degree = gF2nPolynomial.getDegree();
        GF2nElement gF2nElement = (GF2nElement) gF2nPolynomial.coeff[degree].invert();
        if (gF2nPolynomial3.getDegree() < degree) {
            gF2nPolynomialArr[0] = new GF2nPolynomial(this);
            gF2nPolynomialArr[0].assignZeroToElements();
            gF2nPolynomialArr[0].shrink();
            gF2nPolynomialArr[1] = new GF2nPolynomial(this);
            gF2nPolynomial2 = gF2nPolynomialArr[1];
        } else {
            gF2nPolynomialArr[0] = new GF2nPolynomial(this);
            gF2nPolynomialArr[0].assignZeroToElements();
            while (true) {
                int degree2 = gF2nPolynomial3.getDegree() - degree;
                if (degree2 < 0) {
                    break;
                }
                GF2nElement gF2nElement2 = (GF2nElement) gF2nPolynomial3.coeff[gF2nPolynomial3.getDegree()].multiply(gF2nElement);
                GF2nPolynomial scalarMultiply = gF2nPolynomial.scalarMultiply(gF2nElement2);
                scalarMultiply.shiftThisLeft(degree2);
                gF2nPolynomial3 = gF2nPolynomial3.add(scalarMultiply);
                gF2nPolynomial3.shrink();
                gF2nPolynomialArr[0].coeff[degree2] = (GF2nElement) gF2nElement2.clone();
            }
            gF2nPolynomialArr[1] = gF2nPolynomial3;
            gF2nPolynomial2 = gF2nPolynomialArr[0];
        }
        gF2nPolynomial2.shrink();
        return gF2nPolynomialArr;
    }

    public final void enlarge(int i11) {
        int i12 = this.size;
        if (i11 > i12) {
            GF2nElement[] gF2nElementArr = new GF2nElement[i11];
            System.arraycopy(this.coeff, 0, gF2nElementArr, 0, i12);
            GF2nField field = this.coeff[0].getField();
            GF2nElement[] gF2nElementArr2 = this.coeff;
            if (gF2nElementArr2[0] instanceof GF2nPolynomialElement) {
                for (int i13 = this.size; i13 < i11; i13++) {
                    gF2nElementArr[i13] = GF2nPolynomialElement.ZERO((GF2nPolynomialField) field);
                }
            } else if (gF2nElementArr2[0] instanceof GF2nONBElement) {
                for (int i14 = this.size; i14 < i11; i14++) {
                    gF2nElementArr[i14] = GF2nONBElement.ZERO((GF2nONBField) field);
                }
            }
            this.size = i11;
            this.coeff = gF2nElementArr;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2nPolynomial)) {
            return false;
        }
        GF2nPolynomial gF2nPolynomial = (GF2nPolynomial) obj;
        if (getDegree() != gF2nPolynomial.getDegree()) {
            return false;
        }
        for (int i11 = 0; i11 < this.size; i11++) {
            if (!this.coeff[i11].equals(gF2nPolynomial.coeff[i11])) {
                return false;
            }
        }
        return true;
    }

    public final GF2nPolynomial gcd(GF2nPolynomial gF2nPolynomial) {
        GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial(this);
        GF2nPolynomial gF2nPolynomial3 = new GF2nPolynomial(gF2nPolynomial);
        gF2nPolynomial2.shrink();
        gF2nPolynomial3.shrink();
        GF2nPolynomial gF2nPolynomial4 = gF2nPolynomial2;
        GF2nPolynomial gF2nPolynomial5 = gF2nPolynomial3;
        while (!gF2nPolynomial5.isZero()) {
            GF2nPolynomial gF2nPolynomial6 = gF2nPolynomial5;
            gF2nPolynomial5 = gF2nPolynomial4.remainder(gF2nPolynomial5);
            gF2nPolynomial4 = gF2nPolynomial6;
        }
        return gF2nPolynomial4.scalarMultiply((GF2nElement) gF2nPolynomial4.coeff[gF2nPolynomial4.getDegree()].invert());
    }

    public final int getDegree() {
        for (int i11 = this.size - 1; i11 >= 0; i11--) {
            if (!this.coeff[i11].isZero()) {
                return i11;
            }
        }
        return -1;
    }

    public int hashCode() {
        return getDegree() + this.coeff.hashCode();
    }

    public final boolean isZero() {
        for (int i11 = 0; i11 < this.size; i11++) {
            GF2nElement[] gF2nElementArr = this.coeff;
            if (gF2nElementArr[i11] != null && !gF2nElementArr[i11].isZero()) {
                return false;
            }
        }
        return true;
    }

    public final GF2nPolynomial multiply(GF2nPolynomial gF2nPolynomial) {
        int size2 = size();
        if (size2 == gF2nPolynomial.size()) {
            GF2nPolynomial gF2nPolynomial2 = new GF2nPolynomial((size2 << 1) - 1);
            for (int i11 = 0; i11 < size(); i11++) {
                for (int i12 = 0; i12 < gF2nPolynomial.size(); i12++) {
                    GF2nElement[] gF2nElementArr = gF2nPolynomial2.coeff;
                    int i13 = i11 + i12;
                    if (gF2nElementArr[i13] == null) {
                        gF2nElementArr[i13] = (GF2nElement) this.coeff[i11].multiply(gF2nPolynomial.coeff[i12]);
                    } else {
                        gF2nElementArr[i13] = (GF2nElement) gF2nElementArr[i13].add(this.coeff[i11].multiply(gF2nPolynomial.coeff[i12]));
                    }
                }
            }
            return gF2nPolynomial2;
        }
        throw new IllegalArgumentException("PolynomialGF2n.multiply: this and b must have the same size!");
    }

    public final GF2nPolynomial multiplyAndReduce(GF2nPolynomial gF2nPolynomial, GF2nPolynomial gF2nPolynomial2) {
        return multiply(gF2nPolynomial).reduce(gF2nPolynomial2);
    }

    public final GF2nPolynomial quotient(GF2nPolynomial gF2nPolynomial) throws RuntimeException, ArithmeticException {
        return divide(gF2nPolynomial)[0];
    }

    public final GF2nPolynomial reduce(GF2nPolynomial gF2nPolynomial) throws RuntimeException, ArithmeticException {
        return remainder(gF2nPolynomial);
    }

    public final GF2nPolynomial remainder(GF2nPolynomial gF2nPolynomial) throws RuntimeException, ArithmeticException {
        return divide(gF2nPolynomial)[1];
    }

    public final GF2nPolynomial scalarMultiply(GF2nElement gF2nElement) {
        GF2nPolynomial gF2nPolynomial = new GF2nPolynomial(size());
        for (int i11 = 0; i11 < size(); i11++) {
            gF2nPolynomial.coeff[i11] = (GF2nElement) this.coeff[i11].multiply(gF2nElement);
        }
        return gF2nPolynomial;
    }

    public final void set(int i11, GF2nElement gF2nElement) {
        if ((gF2nElement instanceof GF2nPolynomialElement) || (gF2nElement instanceof GF2nONBElement)) {
            this.coeff[i11] = (GF2nElement) gF2nElement.clone();
            return;
        }
        throw new IllegalArgumentException("PolynomialGF2n.set f must be an instance of either GF2nPolynomialElement or GF2nONBElement!");
    }

    public final GF2nPolynomial shiftLeft(int i11) {
        if (i11 <= 0) {
            return new GF2nPolynomial(this);
        }
        GF2nPolynomial gF2nPolynomial = new GF2nPolynomial(this.size + i11, this.coeff[0]);
        gF2nPolynomial.assignZeroToElements();
        for (int i12 = 0; i12 < this.size; i12++) {
            gF2nPolynomial.coeff[i12 + i11] = this.coeff[i12];
        }
        return gF2nPolynomial;
    }

    public final void shiftThisLeft(int i11) {
        if (i11 > 0) {
            int i12 = this.size;
            GF2nField field = this.coeff[0].getField();
            enlarge(this.size + i11);
            for (int i13 = i12 - 1; i13 >= 0; i13--) {
                GF2nElement[] gF2nElementArr = this.coeff;
                gF2nElementArr[i13 + i11] = gF2nElementArr[i13];
            }
            GF2nElement[] gF2nElementArr2 = this.coeff;
            if (gF2nElementArr2[0] instanceof GF2nPolynomialElement) {
                for (int i14 = i11 - 1; i14 >= 0; i14--) {
                    this.coeff[i14] = GF2nPolynomialElement.ZERO((GF2nPolynomialField) field);
                }
            } else if (gF2nElementArr2[0] instanceof GF2nONBElement) {
                for (int i15 = i11 - 1; i15 >= 0; i15--) {
                    this.coeff[i15] = GF2nONBElement.ZERO((GF2nONBField) field);
                }
            }
        }
    }

    public final void shrink() {
        int i11 = this.size;
        while (true) {
            i11--;
            if (!this.coeff[i11].isZero() || i11 <= 0) {
                int i12 = i11 + 1;
            }
        }
        int i122 = i11 + 1;
        if (i122 < this.size) {
            GF2nElement[] gF2nElementArr = new GF2nElement[i122];
            System.arraycopy(this.coeff, 0, gF2nElementArr, 0, i122);
            this.coeff = gF2nElementArr;
            this.size = i122;
        }
    }

    public final int size() {
        return this.size;
    }
}
