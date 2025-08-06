package org.bouncycastle.crypto.prng.drbg;

import org.bouncycastle.math.ec.ECPoint;

public class DualECPoints {
    private final int cofactor;

    /* renamed from: p  reason: collision with root package name */
    private final ECPoint f59309p;

    /* renamed from: q  reason: collision with root package name */
    private final ECPoint f59310q;
    private final int securityStrength;

    public DualECPoints(int i11, ECPoint eCPoint, ECPoint eCPoint2, int i12) {
        if (eCPoint.getCurve().equals(eCPoint2.getCurve())) {
            this.securityStrength = i11;
            this.f59309p = eCPoint;
            this.f59310q = eCPoint2;
            this.cofactor = i12;
            return;
        }
        throw new IllegalArgumentException("points need to be on the same curve");
    }

    private static int log2(int i11) {
        int i12 = 0;
        while (true) {
            i11 >>= 1;
            if (i11 == 0) {
                return i12;
            }
            i12++;
        }
    }

    public int getCofactor() {
        return this.cofactor;
    }

    public int getMaxOutlen() {
        return ((this.f59309p.getCurve().getFieldSize() - (log2(this.cofactor) + 13)) / 8) * 8;
    }

    public ECPoint getP() {
        return this.f59309p;
    }

    public ECPoint getQ() {
        return this.f59310q;
    }

    public int getSecurityStrength() {
        return this.securityStrength;
    }

    public int getSeedLen() {
        return this.f59309p.getCurve().getFieldSize();
    }
}
