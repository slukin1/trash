package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class WTauNafMultiplier extends AbstractECMultiplier {
    public static final String PRECOMP_NAME = "bc_wtnaf";

    private static ECPoint.AbstractF2m multiplyFromWTnaf(final ECPoint.AbstractF2m abstractF2m, byte[] bArr) {
        ECCurve.AbstractF2m abstractF2m2 = (ECCurve.AbstractF2m) abstractF2m.getCurve();
        final byte byteValue = abstractF2m2.getA().toBigInteger().byteValue();
        ECPoint.AbstractF2m[] preComp = ((WTauNafPreCompInfo) abstractF2m2.precompute(abstractF2m, PRECOMP_NAME, new PreCompCallback() {
            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                if (preCompInfo instanceof WTauNafPreCompInfo) {
                    return preCompInfo;
                }
                WTauNafPreCompInfo wTauNafPreCompInfo = new WTauNafPreCompInfo();
                wTauNafPreCompInfo.setPreComp(Tnaf.getPreComp(abstractF2m, byteValue));
                return wTauNafPreCompInfo;
            }
        })).getPreComp();
        ECPoint.AbstractF2m[] abstractF2mArr = new ECPoint.AbstractF2m[preComp.length];
        for (int i11 = 0; i11 < preComp.length; i11++) {
            abstractF2mArr[i11] = (ECPoint.AbstractF2m) preComp[i11].negate();
        }
        ECPoint.AbstractF2m abstractF2m3 = (ECPoint.AbstractF2m) abstractF2m.getCurve().getInfinity();
        int i12 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            i12++;
            byte b11 = bArr[length];
            if (b11 != 0) {
                abstractF2m3 = (ECPoint.AbstractF2m) abstractF2m3.tauPow(i12).add(b11 > 0 ? preComp[b11 >>> 1] : abstractF2mArr[(-b11) >>> 1]);
                i12 = 0;
            }
        }
        return i12 > 0 ? abstractF2m3.tauPow(i12) : abstractF2m3;
    }

    private ECPoint.AbstractF2m multiplyWTnaf(ECPoint.AbstractF2m abstractF2m, ZTauElement zTauElement, byte b11, byte b12) {
        ZTauElement[] zTauElementArr = b11 == 0 ? Tnaf.alpha0 : Tnaf.alpha1;
        return multiplyFromWTnaf(abstractF2m, Tnaf.tauAdicWNaf(b12, zTauElement, (byte) 4, BigInteger.valueOf(16), Tnaf.getTw(b12, 4), zTauElementArr));
    }

    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        if (eCPoint instanceof ECPoint.AbstractF2m) {
            ECPoint.AbstractF2m abstractF2m = (ECPoint.AbstractF2m) eCPoint;
            ECCurve.AbstractF2m abstractF2m2 = (ECCurve.AbstractF2m) abstractF2m.getCurve();
            int fieldSize = abstractF2m2.getFieldSize();
            byte byteValue = abstractF2m2.getA().toBigInteger().byteValue();
            byte mu2 = Tnaf.getMu((int) byteValue);
            return multiplyWTnaf(abstractF2m, Tnaf.partModReduction(bigInteger, fieldSize, byteValue, abstractF2m2.getSi(), mu2, (byte) 10), byteValue, mu2);
        }
        throw new IllegalArgumentException("Only ECPoint.AbstractF2m can be used in WTauNafMultiplier");
    }
}
