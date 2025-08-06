package org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class ElGamalPublicKeySpec extends ElGamalKeySpec {

    /* renamed from: y  reason: collision with root package name */
    private BigInteger f59375y;

    public ElGamalPublicKeySpec(BigInteger bigInteger, ElGamalParameterSpec elGamalParameterSpec) {
        super(elGamalParameterSpec);
        this.f59375y = bigInteger;
    }

    public BigInteger getY() {
        return this.f59375y;
    }
}
