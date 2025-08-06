package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class ElGamalParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f59372g;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f59373p;

    public ElGamalParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f59373p = bigInteger;
        this.f59372g = bigInteger2;
    }

    public BigInteger getG() {
        return this.f59372g;
    }

    public BigInteger getP() {
        return this.f59373p;
    }
}
