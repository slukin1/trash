package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class DSAPrivateKeyParameters extends DSAKeyParameters {

    /* renamed from: x  reason: collision with root package name */
    private BigInteger f59273x;

    public DSAPrivateKeyParameters(BigInteger bigInteger, DSAParameters dSAParameters) {
        super(true, dSAParameters);
        this.f59273x = bigInteger;
    }

    public BigInteger getX() {
        return this.f59273x;
    }
}
