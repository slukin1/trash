package org.bouncycastle.jce.spec;

import org.bouncycastle.math.ec.ECPoint;

public class ECPublicKeySpec extends ECKeySpec {

    /* renamed from: q  reason: collision with root package name */
    private ECPoint f59371q;

    public ECPublicKeySpec(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.f59371q = eCPoint.getCurve() != null ? eCPoint.normalize() : eCPoint;
    }

    public ECPoint getQ() {
        return this.f59371q;
    }
}
