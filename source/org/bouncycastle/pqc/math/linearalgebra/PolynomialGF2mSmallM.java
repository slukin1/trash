package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

public class PolynomialGF2mSmallM {
    public static final char RANDOM_IRREDUCIBLE_POLYNOMIAL = 'I';
    private int[] coefficients;
    private int degree;
    private GF2mField field;

    public PolynomialGF2mSmallM(GF2mField gF2mField) {
        this.field = gF2mField;
        this.degree = -1;
        this.coefficients = new int[1];
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int i11) {
        this.field = gF2mField;
        this.degree = i11;
        int[] iArr = new int[(i11 + 1)];
        this.coefficients = iArr;
        iArr[i11] = 1;
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int i11, char c11, SecureRandom secureRandom) {
        this.field = gF2mField;
        if (c11 == 'I') {
            this.coefficients = createRandomIrreduciblePolynomial(i11, secureRandom);
            computeDegree();
            return;
        }
        throw new IllegalArgumentException(" Error: type " + c11 + " is not defined for GF2smallmPolynomial");
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, byte[] bArr) {
        this.field = gF2mField;
        int i11 = 8;
        int i12 = 1;
        while (gF2mField.getDegree() > i11) {
            i12++;
            i11 += 8;
        }
        if (bArr.length % i12 == 0) {
            this.coefficients = new int[(bArr.length / i12)];
            int i13 = 0;
            int i14 = 0;
            while (true) {
                int[] iArr = this.coefficients;
                if (i13 < iArr.length) {
                    int i15 = 0;
                    while (i15 < i11) {
                        int[] iArr2 = this.coefficients;
                        iArr2[i13] = ((bArr[i14] & 255) << i15) ^ iArr2[i13];
                        i15 += 8;
                        i14++;
                    }
                    if (this.field.isElementOfThisField(this.coefficients[i13])) {
                        i13++;
                    } else {
                        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                    }
                } else if (iArr.length == 1 || iArr[iArr.length - 1] != 0) {
                    computeDegree();
                    return;
                } else {
                    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                }
            }
        } else {
            throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
        }
    }

    public PolynomialGF2mSmallM(GF2mField gF2mField, int[] iArr) {
        this.field = gF2mField;
        this.coefficients = normalForm(iArr);
        computeDegree();
    }

    public PolynomialGF2mSmallM(GF2mVector gF2mVector) {
        this(gF2mVector.getField(), gF2mVector.getIntArrayForm());
    }

    public PolynomialGF2mSmallM(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.field = polynomialGF2mSmallM.field;
        this.degree = polynomialGF2mSmallM.degree;
        this.coefficients = IntUtils.clone(polynomialGF2mSmallM.coefficients);
    }

    private int[] add(int[] iArr, int[] iArr2) {
        int[] iArr3;
        if (iArr.length < iArr2.length) {
            iArr3 = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        } else {
            iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr = iArr2;
        }
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr3[length] = this.field.add(iArr3[length], iArr[length]);
        }
        return iArr3;
    }

    private static int computeDegree(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        return length;
    }

    private void computeDegree() {
        int length = this.coefficients.length;
        do {
            this.degree = length - 1;
            length = this.degree;
            if (length < 0 || this.coefficients[length] != 0) {
            }
            this.degree = length - 1;
            length = this.degree;
            return;
        } while (this.coefficients[length] != 0);
    }

    private int[] createRandomIrreduciblePolynomial(int i11, SecureRandom secureRandom) {
        int[] iArr = new int[(i11 + 1)];
        iArr[i11] = 1;
        iArr[0] = this.field.getRandomNonZeroElement(secureRandom);
        for (int i12 = 1; i12 < i11; i12++) {
            iArr[i12] = this.field.getRandomElement(secureRandom);
        }
        while (!isIrreducible(iArr)) {
            int nextInt = RandUtils.nextInt(secureRandom, i11);
            if (nextInt == 0) {
                iArr[0] = this.field.getRandomNonZeroElement(secureRandom);
            } else {
                iArr[nextInt] = this.field.getRandomElement(secureRandom);
            }
        }
        return iArr;
    }

    private int[][] div(int[] iArr, int[] iArr2) {
        int computeDegree = computeDegree(iArr2);
        int computeDegree2 = computeDegree(iArr) + 1;
        if (computeDegree != -1) {
            int[][] iArr3 = {new int[1], new int[computeDegree2]};
            int inverse = this.field.inverse(headCoefficient(iArr2));
            iArr3[0][0] = 0;
            System.arraycopy(iArr, 0, iArr3[1], 0, iArr3[1].length);
            while (computeDegree <= computeDegree(iArr3[1])) {
                int[] iArr4 = {this.field.mult(headCoefficient(iArr3[1]), inverse)};
                int[] multWithElement = multWithElement(iArr2, iArr4[0]);
                int computeDegree3 = computeDegree(iArr3[1]) - computeDegree;
                int[] multWithMonomial = multWithMonomial(multWithElement, computeDegree3);
                iArr3[0] = add(multWithMonomial(iArr4, computeDegree3), iArr3[0]);
                iArr3[1] = add(multWithMonomial, iArr3[1]);
            }
            return iArr3;
        }
        throw new ArithmeticException("Division by zero.");
    }

    private int[] gcd(int[] iArr, int[] iArr2) {
        if (computeDegree(iArr) == -1) {
            return iArr2;
        }
        while (computeDegree(iArr2) != -1) {
            int[] mod = mod(iArr, iArr2);
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            int length2 = mod.length;
            int[] iArr4 = new int[length2];
            System.arraycopy(mod, 0, iArr4, 0, length2);
            iArr2 = iArr4;
            iArr = iArr3;
        }
        return multWithElement(iArr, this.field.inverse(headCoefficient(iArr)));
    }

    private static int headCoefficient(int[] iArr) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree == -1) {
            return 0;
        }
        return iArr[computeDegree];
    }

    private static boolean isEqual(int[] iArr, int[] iArr2) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree != computeDegree(iArr2)) {
            return false;
        }
        for (int i11 = 0; i11 <= computeDegree; i11++) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    private boolean isIrreducible(int[] iArr) {
        if (iArr[0] == 0) {
            return false;
        }
        int computeDegree = computeDegree(iArr) >> 1;
        int[] iArr2 = {0, 1};
        int[] iArr3 = {0, 1};
        int degree2 = this.field.getDegree();
        for (int i11 = 0; i11 < computeDegree; i11++) {
            for (int i12 = degree2 - 1; i12 >= 0; i12--) {
                iArr2 = modMultiply(iArr2, iArr2, iArr);
            }
            iArr2 = normalForm(iArr2);
            if (computeDegree(gcd(add(iArr2, iArr3), iArr)) != 0) {
                return false;
            }
        }
        return true;
    }

    private int[] mod(int[] iArr, int[] iArr2) {
        int computeDegree = computeDegree(iArr2);
        if (computeDegree != -1) {
            int length = iArr.length;
            int[] iArr3 = new int[length];
            int inverse = this.field.inverse(headCoefficient(iArr2));
            System.arraycopy(iArr, 0, iArr3, 0, length);
            while (computeDegree <= computeDegree(iArr3)) {
                iArr3 = add(multWithElement(multWithMonomial(iArr2, computeDegree(iArr3) - computeDegree), this.field.mult(headCoefficient(iArr3), inverse)), iArr3);
            }
            return iArr3;
        }
        throw new ArithmeticException("Division by zero");
    }

    private int[] modDiv(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] normalForm = normalForm(iArr3);
        int[] mod = mod(iArr2, iArr3);
        int[] iArr4 = {0};
        int[] mod2 = mod(iArr, iArr3);
        while (computeDegree(mod) != -1) {
            int[][] div = div(normalForm, mod);
            int[] normalForm2 = normalForm(mod);
            int[] normalForm3 = normalForm(div[1]);
            int[] add = add(iArr4, modMultiply(div[0], mod2, iArr3));
            iArr4 = normalForm(mod2);
            mod2 = normalForm(add);
            normalForm = normalForm2;
            mod = normalForm3;
        }
        return multWithElement(iArr4, this.field.inverse(headCoefficient(normalForm)));
    }

    private int[] modMultiply(int[] iArr, int[] iArr2, int[] iArr3) {
        return mod(multiply(iArr, iArr2), iArr3);
    }

    private int[] multWithElement(int[] iArr, int i11) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree == -1 || i11 == 0) {
            return new int[1];
        }
        if (i11 == 1) {
            return IntUtils.clone(iArr);
        }
        int[] iArr2 = new int[(computeDegree + 1)];
        while (computeDegree >= 0) {
            iArr2[computeDegree] = this.field.mult(iArr[computeDegree], i11);
            computeDegree--;
        }
        return iArr2;
    }

    private static int[] multWithMonomial(int[] iArr, int i11) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree == -1) {
            return new int[1];
        }
        int[] iArr2 = new int[(computeDegree + i11 + 1)];
        System.arraycopy(iArr, 0, iArr2, i11, computeDegree + 1);
        return iArr2;
    }

    private int[] multiply(int[] iArr, int[] iArr2) {
        if (computeDegree(iArr) < computeDegree(iArr2)) {
            int[] iArr3 = iArr2;
            iArr2 = iArr;
            iArr = iArr3;
        }
        int[] normalForm = normalForm(iArr);
        int[] normalForm2 = normalForm(iArr2);
        if (normalForm2.length == 1) {
            return multWithElement(normalForm, normalForm2[0]);
        }
        int length = normalForm.length;
        int length2 = normalForm2.length;
        int[] iArr4 = new int[((length + length2) - 1)];
        if (length2 != length) {
            int[] iArr5 = new int[length2];
            int i11 = length - length2;
            int[] iArr6 = new int[i11];
            System.arraycopy(normalForm, 0, iArr5, 0, length2);
            System.arraycopy(normalForm, length2, iArr6, 0, i11);
            return add(multiply(iArr5, normalForm2), multWithMonomial(multiply(iArr6, normalForm2), length2));
        }
        int i12 = (length + 1) >>> 1;
        int i13 = length - i12;
        int[] iArr7 = new int[i12];
        int[] iArr8 = new int[i12];
        int[] iArr9 = new int[i13];
        int[] iArr10 = new int[i13];
        System.arraycopy(normalForm, 0, iArr7, 0, i12);
        System.arraycopy(normalForm, i12, iArr9, 0, i13);
        System.arraycopy(normalForm2, 0, iArr8, 0, i12);
        System.arraycopy(normalForm2, i12, iArr10, 0, i13);
        int[] add = add(iArr7, iArr9);
        int[] add2 = add(iArr8, iArr10);
        int[] multiply = multiply(iArr7, iArr8);
        int[] multiply2 = multiply(add, add2);
        int[] multiply3 = multiply(iArr9, iArr10);
        return add(multWithMonomial(add(add(add(multiply2, multiply), multiply3), multWithMonomial(multiply3, i12)), i12), multiply);
    }

    private static int[] normalForm(int[] iArr) {
        int computeDegree = computeDegree(iArr);
        if (computeDegree == -1) {
            return new int[1];
        }
        int i11 = computeDegree + 1;
        if (iArr.length == i11) {
            return IntUtils.clone(iArr);
        }
        int[] iArr2 = new int[i11];
        System.arraycopy(iArr, 0, iArr2, 0, i11);
        return iArr2;
    }

    public PolynomialGF2mSmallM add(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, add(this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public PolynomialGF2mSmallM addMonomial(int i11) {
        int[] iArr = new int[(i11 + 1)];
        iArr[i11] = 1;
        return new PolynomialGF2mSmallM(this.field, add(this.coefficients, iArr));
    }

    public void addToThis(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        this.coefficients = add(this.coefficients, polynomialGF2mSmallM.coefficients);
        computeDegree();
    }

    public PolynomialGF2mSmallM[] div(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int[][] div = div(this.coefficients, polynomialGF2mSmallM.coefficients);
        return new PolynomialGF2mSmallM[]{new PolynomialGF2mSmallM(this.field, div[0]), new PolynomialGF2mSmallM(this.field, div[1])};
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PolynomialGF2mSmallM)) {
            PolynomialGF2mSmallM polynomialGF2mSmallM = (PolynomialGF2mSmallM) obj;
            return this.field.equals(polynomialGF2mSmallM.field) && this.degree == polynomialGF2mSmallM.degree && isEqual(this.coefficients, polynomialGF2mSmallM.coefficients);
        }
    }

    public int evaluateAt(int i11) {
        int[] iArr = this.coefficients;
        int i12 = this.degree;
        int i13 = iArr[i12];
        for (int i14 = i12 - 1; i14 >= 0; i14--) {
            i13 = this.field.mult(i13, i11) ^ this.coefficients[i14];
        }
        return i13;
    }

    public PolynomialGF2mSmallM gcd(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, gcd(this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public int getCoefficient(int i11) {
        if (i11 < 0 || i11 > this.degree) {
            return 0;
        }
        return this.coefficients[i11];
    }

    public int getDegree() {
        int[] iArr = this.coefficients;
        int length = iArr.length - 1;
        if (iArr[length] == 0) {
            return -1;
        }
        return length;
    }

    public byte[] getEncoded() {
        int i11 = 8;
        int i12 = 1;
        while (this.field.getDegree() > i11) {
            i12++;
            i11 += 8;
        }
        byte[] bArr = new byte[(this.coefficients.length * i12)];
        int i13 = 0;
        for (int i14 = 0; i14 < this.coefficients.length; i14++) {
            int i15 = 0;
            while (i15 < i11) {
                bArr[i13] = (byte) (this.coefficients[i14] >>> i15);
                i15 += 8;
                i13++;
            }
        }
        return bArr;
    }

    public int getHeadCoefficient() {
        int i11 = this.degree;
        if (i11 == -1) {
            return 0;
        }
        return this.coefficients[i11];
    }

    public int hashCode() {
        int hashCode = this.field.hashCode();
        int i11 = 0;
        while (true) {
            int[] iArr = this.coefficients;
            if (i11 >= iArr.length) {
                return hashCode;
            }
            hashCode = (hashCode * 31) + iArr[i11];
            i11++;
        }
    }

    public PolynomialGF2mSmallM mod(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, mod(this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public PolynomialGF2mSmallM modDiv(PolynomialGF2mSmallM polynomialGF2mSmallM, PolynomialGF2mSmallM polynomialGF2mSmallM2) {
        return new PolynomialGF2mSmallM(this.field, modDiv(this.coefficients, polynomialGF2mSmallM.coefficients, polynomialGF2mSmallM2.coefficients));
    }

    public PolynomialGF2mSmallM modInverse(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, modDiv(new int[]{1}, this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public PolynomialGF2mSmallM modMultiply(PolynomialGF2mSmallM polynomialGF2mSmallM, PolynomialGF2mSmallM polynomialGF2mSmallM2) {
        return new PolynomialGF2mSmallM(this.field, modMultiply(this.coefficients, polynomialGF2mSmallM.coefficients, polynomialGF2mSmallM2.coefficients));
    }

    public PolynomialGF2mSmallM[] modPolynomialToFracton(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int i11 = polynomialGF2mSmallM.degree >> 1;
        int[] normalForm = normalForm(polynomialGF2mSmallM.coefficients);
        int[] mod = mod(this.coefficients, polynomialGF2mSmallM.coefficients);
        int[] iArr = normalForm;
        int[] iArr2 = mod;
        int[] iArr3 = {1};
        int[] iArr4 = {0};
        int[] iArr5 = iArr3;
        while (computeDegree(iArr2) > i11) {
            int[][] div = div(iArr, iArr2);
            int[] iArr6 = div[1];
            int[] add = add(iArr4, modMultiply(div[0], iArr5, polynomialGF2mSmallM.coefficients));
            iArr4 = iArr5;
            iArr5 = add;
            iArr = iArr2;
            iArr2 = iArr6;
        }
        return new PolynomialGF2mSmallM[]{new PolynomialGF2mSmallM(this.field, iArr2), new PolynomialGF2mSmallM(this.field, iArr5)};
    }

    public PolynomialGF2mSmallM modSquareMatrix(PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        int length = polynomialGF2mSmallMArr.length;
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        int i11 = 0;
        while (true) {
            int[] iArr3 = this.coefficients;
            if (i11 >= iArr3.length) {
                break;
            }
            iArr2[i11] = this.field.mult(iArr3[i11], iArr3[i11]);
            i11++;
        }
        for (int i12 = 0; i12 < length; i12++) {
            for (int i13 = 0; i13 < length; i13++) {
                if (i12 < polynomialGF2mSmallMArr[i13].coefficients.length) {
                    iArr[i12] = this.field.add(iArr[i12], this.field.mult(polynomialGF2mSmallMArr[i13].coefficients[i12], iArr2[i13]));
                }
            }
        }
        return new PolynomialGF2mSmallM(this.field, iArr);
    }

    public PolynomialGF2mSmallM modSquareRoot(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        int[] clone = IntUtils.clone(this.coefficients);
        int[] modMultiply = modMultiply(clone, clone, polynomialGF2mSmallM.coefficients);
        while (!isEqual(modMultiply, this.coefficients)) {
            clone = normalForm(modMultiply);
            modMultiply = modMultiply(clone, clone, polynomialGF2mSmallM.coefficients);
        }
        return new PolynomialGF2mSmallM(this.field, clone);
    }

    public PolynomialGF2mSmallM modSquareRootMatrix(PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        int length = polynomialGF2mSmallMArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            for (int i12 = 0; i12 < length; i12++) {
                if (i11 < polynomialGF2mSmallMArr[i12].coefficients.length) {
                    int[] iArr2 = this.coefficients;
                    if (i12 < iArr2.length) {
                        iArr[i11] = this.field.add(iArr[i11], this.field.mult(polynomialGF2mSmallMArr[i12].coefficients[i11], iArr2[i12]));
                    }
                }
            }
        }
        for (int i13 = 0; i13 < length; i13++) {
            iArr[i13] = this.field.sqRoot(iArr[i13]);
        }
        return new PolynomialGF2mSmallM(this.field, iArr);
    }

    public void multThisWithElement(int i11) {
        if (this.field.isElementOfThisField(i11)) {
            this.coefficients = multWithElement(this.coefficients, i11);
            computeDegree();
            return;
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public PolynomialGF2mSmallM multWithElement(int i11) {
        if (this.field.isElementOfThisField(i11)) {
            return new PolynomialGF2mSmallM(this.field, multWithElement(this.coefficients, i11));
        }
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public PolynomialGF2mSmallM multWithMonomial(int i11) {
        return new PolynomialGF2mSmallM(this.field, multWithMonomial(this.coefficients, i11));
    }

    public PolynomialGF2mSmallM multiply(PolynomialGF2mSmallM polynomialGF2mSmallM) {
        return new PolynomialGF2mSmallM(this.field, multiply(this.coefficients, polynomialGF2mSmallM.coefficients));
    }

    public String toString() {
        String str = " Polynomial over " + this.field.toString() + ": \n";
        for (int i11 = 0; i11 < this.coefficients.length; i11++) {
            str = str + this.field.elementToStr(this.coefficients[i11]) + "Y^" + i11 + "+";
        }
        return str + ";";
    }
}
