package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class McElieceParameters implements CipherParameters {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    private Digest digest;
    private int fieldPoly;

    /* renamed from: m  reason: collision with root package name */
    private int f59575m;

    /* renamed from: n  reason: collision with root package name */
    private int f59576n;

    /* renamed from: t  reason: collision with root package name */
    private int f59577t;

    public McElieceParameters() {
        this(11, 50);
    }

    public McElieceParameters(int i11) {
        this(i11, (Digest) null);
    }

    public McElieceParameters(int i11, int i12) {
        this(i11, i12, (Digest) null);
    }

    public McElieceParameters(int i11, int i12, int i13) {
        this(i11, i12, i13, (Digest) null);
    }

    public McElieceParameters(int i11, int i12, int i13, Digest digest2) {
        this.f59575m = i11;
        if (i11 < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i11 <= 32) {
            int i14 = 1 << i11;
            this.f59576n = i14;
            this.f59577t = i12;
            if (i12 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i12 > i14) {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            } else if (PolynomialRingGF2.degree(i13) != i11 || !PolynomialRingGF2.isIrreducible(i13)) {
                throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
            } else {
                this.fieldPoly = i13;
                this.digest = digest2;
            }
        } else {
            throw new IllegalArgumentException(" m is too large");
        }
    }

    public McElieceParameters(int i11, int i12, Digest digest2) {
        if (i11 < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i11 <= 32) {
            this.f59575m = i11;
            int i13 = 1 << i11;
            this.f59576n = i13;
            if (i12 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i12 <= i13) {
                this.f59577t = i12;
                this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i11);
                this.digest = digest2;
            } else {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            }
        } else {
            throw new IllegalArgumentException("m is too large");
        }
    }

    public McElieceParameters(int i11, Digest digest2) {
        if (i11 >= 1) {
            this.f59575m = 0;
            this.f59576n = 1;
            while (true) {
                int i12 = this.f59576n;
                if (i12 < i11) {
                    this.f59576n = i12 << 1;
                    this.f59575m++;
                } else {
                    int i13 = i12 >>> 1;
                    this.f59577t = i13;
                    int i14 = this.f59575m;
                    this.f59577t = i13 / i14;
                    this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i14);
                    this.digest = digest2;
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("key size must be positive");
        }
    }

    public McElieceParameters(Digest digest2) {
        this(11, 50, digest2);
    }

    public int getFieldPoly() {
        return this.fieldPoly;
    }

    public int getM() {
        return this.f59575m;
    }

    public int getN() {
        return this.f59576n;
    }

    public int getT() {
        return this.f59577t;
    }
}
