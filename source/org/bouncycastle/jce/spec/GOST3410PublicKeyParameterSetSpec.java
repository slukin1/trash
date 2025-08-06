package org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class GOST3410PublicKeyParameterSetSpec {

    /* renamed from: a  reason: collision with root package name */
    private BigInteger f59380a;

    /* renamed from: p  reason: collision with root package name */
    private BigInteger f59381p;

    /* renamed from: q  reason: collision with root package name */
    private BigInteger f59382q;

    public GOST3410PublicKeyParameterSetSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f59381p = bigInteger;
        this.f59382q = bigInteger2;
        this.f59380a = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410PublicKeyParameterSetSpec)) {
            return false;
        }
        GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = (GOST3410PublicKeyParameterSetSpec) obj;
        return this.f59380a.equals(gOST3410PublicKeyParameterSetSpec.f59380a) && this.f59381p.equals(gOST3410PublicKeyParameterSetSpec.f59381p) && this.f59382q.equals(gOST3410PublicKeyParameterSetSpec.f59382q);
    }

    public BigInteger getA() {
        return this.f59380a;
    }

    public BigInteger getP() {
        return this.f59381p;
    }

    public BigInteger getQ() {
        return this.f59382q;
    }

    public int hashCode() {
        return (this.f59380a.hashCode() ^ this.f59381p.hashCode()) ^ this.f59382q.hashCode();
    }
}
