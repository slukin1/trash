package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class ElGamalPublicKeyParameters extends ElGamalKeyParameters {

    /* renamed from: y  reason: collision with root package name */
    private BigInteger f59283y;

    public ElGamalPublicKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(false, elGamalParameters);
        this.f59283y = bigInteger;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ElGamalPublicKeyParameters) && ((ElGamalPublicKeyParameters) obj).getY().equals(this.f59283y) && super.equals(obj);
    }

    public BigInteger getY() {
        return this.f59283y;
    }

    public int hashCode() {
        return this.f59283y.hashCode() ^ super.hashCode();
    }
}
