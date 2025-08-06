package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class NaccacheSternKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f59299g;
    public int lowerSigmaBound;

    /* renamed from: n  reason: collision with root package name */
    private BigInteger f59300n;

    public NaccacheSternKeyParameters(boolean z11, BigInteger bigInteger, BigInteger bigInteger2, int i11) {
        super(z11);
        this.f59299g = bigInteger;
        this.f59300n = bigInteger2;
        this.lowerSigmaBound = i11;
    }

    public BigInteger getG() {
        return this.f59299g;
    }

    public int getLowerSigmaBound() {
        return this.lowerSigmaBound;
    }

    public BigInteger getModulus() {
        return this.f59300n;
    }
}
