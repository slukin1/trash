package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class McElieceCCA2KeyGenParameterSpec implements AlgorithmParameterSpec {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    public static final String SHA1 = "SHA-1";
    public static final String SHA224 = "SHA-224";
    public static final String SHA256 = "SHA-256";
    public static final String SHA384 = "SHA-384";
    public static final String SHA512 = "SHA-512";
    private final String digest;
    private int fieldPoly;

    /* renamed from: m  reason: collision with root package name */
    private final int f59619m;

    /* renamed from: n  reason: collision with root package name */
    private final int f59620n;

    /* renamed from: t  reason: collision with root package name */
    private final int f59621t;

    public McElieceCCA2KeyGenParameterSpec() {
        this(11, 50, "SHA-256");
    }

    public McElieceCCA2KeyGenParameterSpec(int i11) {
        this(i11, "SHA-256");
    }

    public McElieceCCA2KeyGenParameterSpec(int i11, int i12) {
        this(i11, i12, "SHA-256");
    }

    public McElieceCCA2KeyGenParameterSpec(int i11, int i12, int i13) {
        this(i11, i12, i13, "SHA-256");
    }

    public McElieceCCA2KeyGenParameterSpec(int i11, int i12, int i13, String str) {
        this.f59619m = i11;
        if (i11 < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i11 <= 32) {
            int i14 = 1 << i11;
            this.f59620n = i14;
            this.f59621t = i12;
            if (i12 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i12 > i14) {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            } else if (PolynomialRingGF2.degree(i13) != i11 || !PolynomialRingGF2.isIrreducible(i13)) {
                throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
            } else {
                this.fieldPoly = i13;
                this.digest = str;
            }
        } else {
            throw new IllegalArgumentException(" m is too large");
        }
    }

    public McElieceCCA2KeyGenParameterSpec(int i11, int i12, String str) {
        if (i11 < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i11 <= 32) {
            this.f59619m = i11;
            int i13 = 1 << i11;
            this.f59620n = i13;
            if (i12 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i12 <= i13) {
                this.f59621t = i12;
                this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i11);
                this.digest = str;
            } else {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            }
        } else {
            throw new IllegalArgumentException("m is too large");
        }
    }

    public McElieceCCA2KeyGenParameterSpec(int i11, String str) {
        int i12 = 1;
        if (i11 >= 1) {
            int i13 = 0;
            while (i12 < i11) {
                i12 <<= 1;
                i13++;
            }
            this.f59621t = (i12 >>> 1) / i13;
            this.f59619m = i13;
            this.f59620n = i12;
            this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i13);
            this.digest = str;
            return;
        }
        throw new IllegalArgumentException("key size must be positive");
    }

    public String getDigest() {
        return this.digest;
    }

    public int getFieldPoly() {
        return this.fieldPoly;
    }

    public int getM() {
        return this.f59619m;
    }

    public int getN() {
        return this.f59620n;
    }

    public int getT() {
        return this.f59621t;
    }
}
