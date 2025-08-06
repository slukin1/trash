package org.bouncycastle.pqc.jcajce.spec;

import java.security.InvalidParameterException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class McElieceKeyGenParameterSpec implements AlgorithmParameterSpec {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    private int fieldPoly;

    /* renamed from: m  reason: collision with root package name */
    private int f59622m;

    /* renamed from: n  reason: collision with root package name */
    private int f59623n;

    /* renamed from: t  reason: collision with root package name */
    private int f59624t;

    public McElieceKeyGenParameterSpec() {
        this(11, 50);
    }

    public McElieceKeyGenParameterSpec(int i11) {
        if (i11 >= 1) {
            this.f59622m = 0;
            this.f59623n = 1;
            while (true) {
                int i12 = this.f59623n;
                if (i12 < i11) {
                    this.f59623n = i12 << 1;
                    this.f59622m++;
                } else {
                    int i13 = i12 >>> 1;
                    this.f59624t = i13;
                    int i14 = this.f59622m;
                    this.f59624t = i13 / i14;
                    this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i14);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("key size must be positive");
        }
    }

    public McElieceKeyGenParameterSpec(int i11, int i12) throws InvalidParameterException {
        if (i11 < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i11 <= 32) {
            this.f59622m = i11;
            int i13 = 1 << i11;
            this.f59623n = i13;
            if (i12 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i12 <= i13) {
                this.f59624t = i12;
                this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i11);
            } else {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            }
        } else {
            throw new IllegalArgumentException("m is too large");
        }
    }

    public McElieceKeyGenParameterSpec(int i11, int i12, int i13) {
        this.f59622m = i11;
        if (i11 < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i11 <= 32) {
            int i14 = 1 << i11;
            this.f59623n = i14;
            this.f59624t = i12;
            if (i12 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i12 > i14) {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            } else if (PolynomialRingGF2.degree(i13) != i11 || !PolynomialRingGF2.isIrreducible(i13)) {
                throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
            } else {
                this.fieldPoly = i13;
            }
        } else {
            throw new IllegalArgumentException(" m is too large");
        }
    }

    public int getFieldPoly() {
        return this.fieldPoly;
    }

    public int getM() {
        return this.f59622m;
    }

    public int getN() {
        return this.f59623n;
    }

    public int getT() {
        return this.f59624t;
    }
}
