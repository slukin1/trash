package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class ElGamalParameters implements CipherParameters {

    /* renamed from: g  reason: collision with root package name */
    private BigInteger f59279g;

    /* renamed from: l  reason: collision with root package name */
    private int f59280l;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f59281p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i11) {
        this.f59279g = bigInteger2;
        this.f59281p = bigInteger;
        this.f59280l = i11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        return elGamalParameters.getP().equals(this.f59281p) && elGamalParameters.getG().equals(this.f59279g) && elGamalParameters.getL() == this.f59280l;
    }

    public BigInteger getG() {
        return this.f59279g;
    }

    public int getL() {
        return this.f59280l;
    }

    public BigInteger getP() {
        return this.f59281p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.f59280l;
    }
}
