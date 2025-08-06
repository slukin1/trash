package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PrivateKeySpec implements KeySpec {

    /* renamed from: a  reason: collision with root package name */
    private BigInteger f59376a;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f59377p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f59378q;

    /* renamed from: x  reason: collision with root package name */
    private BigInteger f59379x;

    public GOST3410PrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f59379x = bigInteger;
        this.f59377p = bigInteger2;
        this.f59378q = bigInteger3;
        this.f59376a = bigInteger4;
    }

    public BigInteger getA() {
        return this.f59376a;
    }

    public BigInteger getP() {
        return this.f59377p;
    }

    public BigInteger getQ() {
        return this.f59378q;
    }

    public BigInteger getX() {
        return this.f59379x;
    }
}
