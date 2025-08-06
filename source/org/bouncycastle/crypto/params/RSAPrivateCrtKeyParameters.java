package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {
    private BigInteger dP;
    private BigInteger dQ;

    /* renamed from: e  reason: collision with root package name */
    private BigInteger f59303e;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f59304p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f59305q;
    private BigInteger qInv;

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        this(bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, bigInteger6, bigInteger7, bigInteger8, false);
    }

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8, boolean z11) {
        super(true, bigInteger, bigInteger3, z11);
        this.f59303e = bigInteger2;
        this.f59304p = bigInteger4;
        this.f59305q = bigInteger5;
        this.dP = bigInteger6;
        this.dQ = bigInteger7;
        this.qInv = bigInteger8;
    }

    public BigInteger getDP() {
        return this.dP;
    }

    public BigInteger getDQ() {
        return this.dQ;
    }

    public BigInteger getP() {
        return this.f59304p;
    }

    public BigInteger getPublicExponent() {
        return this.f59303e;
    }

    public BigInteger getQ() {
        return this.f59305q;
    }

    public BigInteger getQInv() {
        return this.qInv;
    }
}
