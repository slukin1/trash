package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PublicKeySpec implements KeySpec {

    /* renamed from: a  reason: collision with root package name */
    private BigInteger f59383a;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f59384p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f59385q;

    /* renamed from: y  reason: collision with root package name */
    private BigInteger f59386y;

    public GOST3410PublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f59386y = bigInteger;
        this.f59384p = bigInteger2;
        this.f59385q = bigInteger3;
        this.f59383a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f59383a;
    }

    public BigInteger getP() {
        return this.f59384p;
    }

    public BigInteger getQ() {
        return this.f59385q;
    }

    public BigInteger getY() {
        return this.f59386y;
    }
}
