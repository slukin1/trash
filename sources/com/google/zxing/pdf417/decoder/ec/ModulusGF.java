package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.pdf417.PDF417Common;

public final class ModulusGF {
    public static final ModulusGF PDF417_GF = new ModulusGF(PDF417Common.NUMBER_OF_CODEWORDS, 3);
    private final int[] expTable;
    private final int[] logTable;
    private final int modulus;
    private final ModulusPoly one;
    private final ModulusPoly zero;

    private ModulusGF(int i11, int i12) {
        this.modulus = i11;
        this.expTable = new int[i11];
        this.logTable = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.expTable[i14] = i13;
            i13 = (i13 * i12) % i11;
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.logTable[this.expTable[i15]] = i15;
        }
        this.zero = new ModulusPoly(this, new int[]{0});
        this.one = new ModulusPoly(this, new int[]{1});
    }

    public int add(int i11, int i12) {
        return (i11 + i12) % this.modulus;
    }

    public ModulusPoly buildMonomial(int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException();
        } else if (i12 == 0) {
            return this.zero;
        } else {
            int[] iArr = new int[(i11 + 1)];
            iArr[0] = i12;
            return new ModulusPoly(this, iArr);
        }
    }

    public int exp(int i11) {
        return this.expTable[i11];
    }

    public ModulusPoly getOne() {
        return this.one;
    }

    public int getSize() {
        return this.modulus;
    }

    public ModulusPoly getZero() {
        return this.zero;
    }

    public int inverse(int i11) {
        if (i11 != 0) {
            return this.expTable[(this.modulus - this.logTable[i11]) - 1];
        }
        throw new ArithmeticException();
    }

    public int log(int i11) {
        if (i11 != 0) {
            return this.logTable[i11];
        }
        throw new IllegalArgumentException();
    }

    public int multiply(int i11, int i12) {
        if (i11 == 0 || i12 == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[i11] + iArr2[i12]) % (this.modulus - 1)];
    }

    public int subtract(int i11, int i12) {
        int i13 = this.modulus;
        return ((i11 + i13) - i12) % i13;
    }
}
