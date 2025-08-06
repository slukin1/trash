package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: c  reason: collision with root package name */
    private BigInteger f59257c;

    /* renamed from: d  reason: collision with root package name */
    private BigInteger f59258d;

    /* renamed from: h  reason: collision with root package name */
    private BigInteger f59259h;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, cramerShoupParameters);
        this.f59257c = bigInteger;
        this.f59258d = bigInteger2;
        this.f59259h = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPublicKeyParameters)) {
            return false;
        }
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) obj;
        return cramerShoupPublicKeyParameters.getC().equals(this.f59257c) && cramerShoupPublicKeyParameters.getD().equals(this.f59258d) && cramerShoupPublicKeyParameters.getH().equals(this.f59259h) && super.equals(obj);
    }

    public BigInteger getC() {
        return this.f59257c;
    }

    public BigInteger getD() {
        return this.f59258d;
    }

    public BigInteger getH() {
        return this.f59259h;
    }

    public int hashCode() {
        return ((this.f59257c.hashCode() ^ this.f59258d.hashCode()) ^ this.f59259h.hashCode()) ^ super.hashCode();
    }
}
