package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Memoable;

public class CramerShoupParameters implements CipherParameters {
    private Digest H;

    /* renamed from: g1  reason: collision with root package name */
    private BigInteger f59248g1;

    /* renamed from: g2  reason: collision with root package name */
    private BigInteger f59249g2;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f59250p;

    public CramerShoupParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, Digest digest) {
        this.f59250p = bigInteger;
        this.f59248g1 = bigInteger2;
        this.f59249g2 = bigInteger3;
        Digest digest2 = (Digest) ((Memoable) digest).copy();
        this.H = digest2;
        digest2.reset();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupParameters)) {
            return false;
        }
        CramerShoupParameters cramerShoupParameters = (CramerShoupParameters) obj;
        return cramerShoupParameters.getP().equals(this.f59250p) && cramerShoupParameters.getG1().equals(this.f59248g1) && cramerShoupParameters.getG2().equals(this.f59249g2);
    }

    public BigInteger getG1() {
        return this.f59248g1;
    }

    public BigInteger getG2() {
        return this.f59249g2;
    }

    public Digest getH() {
        return (Digest) ((Memoable) this.H).copy();
    }

    public BigInteger getP() {
        return this.f59250p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG1().hashCode()) ^ getG2().hashCode();
    }
}
