package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class DHPrivateKeyParameters extends DHKeyParameters {

    /* renamed from: x  reason: collision with root package name */
    private BigInteger f59266x;

    public DHPrivateKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(true, dHParameters);
        this.f59266x = bigInteger;
    }

    public boolean equals(Object obj) {
        return (obj instanceof DHPrivateKeyParameters) && ((DHPrivateKeyParameters) obj).getX().equals(this.f59266x) && super.equals(obj);
    }

    public BigInteger getX() {
        return this.f59266x;
    }

    public int hashCode() {
        return this.f59266x.hashCode() ^ super.hashCode();
    }
}
