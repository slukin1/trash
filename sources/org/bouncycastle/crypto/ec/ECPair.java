package org.bouncycastle.crypto.ec;

import org.bouncycastle.math.ec.ECPoint;

public class ECPair {

    /* renamed from: x  reason: collision with root package name */
    private final ECPoint f59143x;

    /* renamed from: y  reason: collision with root package name */
    private final ECPoint f59144y;

    public ECPair(ECPoint eCPoint, ECPoint eCPoint2) {
        this.f59143x = eCPoint;
        this.f59144y = eCPoint2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ECPair) {
            return equals((ECPair) obj);
        }
        return false;
    }

    public boolean equals(ECPair eCPair) {
        return eCPair.getX().equals(getX()) && eCPair.getY().equals(getY());
    }

    public ECPoint getX() {
        return this.f59143x;
    }

    public ECPoint getY() {
        return this.f59144y;
    }

    public int hashCode() {
        return this.f59143x.hashCode() + (this.f59144y.hashCode() * 37);
    }
}
