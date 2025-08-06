package org.bouncycastle.math.ec.endo;

import java.math.BigInteger;

public class ScalarSplitParameters {
    public final int bits;

    /* renamed from: g1  reason: collision with root package name */
    public final BigInteger f59444g1;

    /* renamed from: g2  reason: collision with root package name */
    public final BigInteger f59445g2;
    public final BigInteger v1A;
    public final BigInteger v1B;
    public final BigInteger v2A;
    public final BigInteger v2B;

    public ScalarSplitParameters(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger, BigInteger bigInteger2, int i11) {
        checkVector(bigIntegerArr, "v1");
        checkVector(bigIntegerArr2, "v2");
        this.v1A = bigIntegerArr[0];
        this.v1B = bigIntegerArr[1];
        this.v2A = bigIntegerArr2[0];
        this.v2B = bigIntegerArr2[1];
        this.f59444g1 = bigInteger;
        this.f59445g2 = bigInteger2;
        this.bits = i11;
    }

    private static void checkVector(BigInteger[] bigIntegerArr, String str) {
        if (bigIntegerArr == null || bigIntegerArr.length != 2 || bigIntegerArr[0] == null || bigIntegerArr[1] == null) {
            throw new IllegalArgumentException("'" + str + "' must consist of exactly 2 (non-null) values");
        }
    }

    public int getBits() {
        return this.bits;
    }

    public BigInteger getG1() {
        return this.f59444g1;
    }

    public BigInteger getG2() {
        return this.f59445g2;
    }

    public BigInteger getV1A() {
        return this.v1A;
    }

    public BigInteger getV1B() {
        return this.v1B;
    }

    public BigInteger getV2A() {
        return this.v2A;
    }

    public BigInteger getV2B() {
        return this.v2B;
    }
}
