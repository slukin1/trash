package org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class ElGamalPrivateKeySpec extends ElGamalKeySpec {

    /* renamed from: x  reason: collision with root package name */
    private BigInteger f59374x;

    public ElGamalPrivateKeySpec(BigInteger bigInteger, ElGamalParameterSpec elGamalParameterSpec) {
        super(elGamalParameterSpec);
        this.f59374x = bigInteger;
    }

    public BigInteger getX() {
        return this.f59374x;
    }
}
