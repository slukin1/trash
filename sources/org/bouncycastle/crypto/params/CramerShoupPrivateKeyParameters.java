package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPrivateKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: pk  reason: collision with root package name */
    private CramerShoupPublicKeyParameters f59251pk;

    /* renamed from: x1  reason: collision with root package name */
    private BigInteger f59252x1;

    /* renamed from: x2  reason: collision with root package name */
    private BigInteger f59253x2;

    /* renamed from: y1  reason: collision with root package name */
    private BigInteger f59254y1;

    /* renamed from: y2  reason: collision with root package name */
    private BigInteger f59255y2;

    /* renamed from: z  reason: collision with root package name */
    private BigInteger f59256z;

    public CramerShoupPrivateKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        super(true, cramerShoupParameters);
        this.f59252x1 = bigInteger;
        this.f59253x2 = bigInteger2;
        this.f59254y1 = bigInteger3;
        this.f59255y2 = bigInteger4;
        this.f59256z = bigInteger5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPrivateKeyParameters)) {
            return false;
        }
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters = (CramerShoupPrivateKeyParameters) obj;
        return cramerShoupPrivateKeyParameters.getX1().equals(this.f59252x1) && cramerShoupPrivateKeyParameters.getX2().equals(this.f59253x2) && cramerShoupPrivateKeyParameters.getY1().equals(this.f59254y1) && cramerShoupPrivateKeyParameters.getY2().equals(this.f59255y2) && cramerShoupPrivateKeyParameters.getZ().equals(this.f59256z) && super.equals(obj);
    }

    public CramerShoupPublicKeyParameters getPk() {
        return this.f59251pk;
    }

    public BigInteger getX1() {
        return this.f59252x1;
    }

    public BigInteger getX2() {
        return this.f59253x2;
    }

    public BigInteger getY1() {
        return this.f59254y1;
    }

    public BigInteger getY2() {
        return this.f59255y2;
    }

    public BigInteger getZ() {
        return this.f59256z;
    }

    public int hashCode() {
        return ((((this.f59252x1.hashCode() ^ this.f59253x2.hashCode()) ^ this.f59254y1.hashCode()) ^ this.f59255y2.hashCode()) ^ this.f59256z.hashCode()) ^ super.hashCode();
    }

    public void setPk(CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters) {
        this.f59251pk = cramerShoupPublicKeyParameters;
    }
}
