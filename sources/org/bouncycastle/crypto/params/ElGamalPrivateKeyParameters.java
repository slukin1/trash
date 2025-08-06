package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class ElGamalPrivateKeyParameters extends ElGamalKeyParameters {

    /* renamed from: x  reason: collision with root package name */
    private BigInteger f59282x;

    public ElGamalPrivateKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(true, elGamalParameters);
        this.f59282x = bigInteger;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ElGamalPrivateKeyParameters) && ((ElGamalPrivateKeyParameters) obj).getX().equals(this.f59282x)) {
            return super.equals(obj);
        }
        return false;
    }

    public BigInteger getX() {
        return this.f59282x;
    }

    public int hashCode() {
        return getX().hashCode();
    }
}
