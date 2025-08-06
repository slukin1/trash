package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.util.Integers;

public class WNafL2RMultiplier extends AbstractECMultiplier {
    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint eCPoint2;
        WNafPreCompInfo precompute = WNafUtil.precompute(eCPoint, WNafUtil.getWindowSize(bigInteger.bitLength()), true);
        ECPoint[] preComp = precompute.getPreComp();
        ECPoint[] preCompNeg = precompute.getPreCompNeg();
        int width = precompute.getWidth();
        int[] generateCompactWindowNaf = WNafUtil.generateCompactWindowNaf(width, bigInteger);
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int length = generateCompactWindowNaf.length;
        if (length > 1) {
            length--;
            int i11 = generateCompactWindowNaf[length];
            int i12 = i11 >> 16;
            int i13 = i11 & 65535;
            int abs = Math.abs(i12);
            ECPoint[] eCPointArr = i12 < 0 ? preCompNeg : preComp;
            if ((abs << 2) < (1 << width)) {
                int numberOfLeadingZeros = 32 - Integers.numberOfLeadingZeros(abs);
                int i14 = width - numberOfLeadingZeros;
                eCPoint2 = eCPointArr[((1 << (width - 1)) - 1) >>> 1].add(eCPointArr[(((abs ^ (1 << (numberOfLeadingZeros - 1))) << i14) + 1) >>> 1]);
                i13 -= i14;
            } else {
                eCPoint2 = eCPointArr[abs >>> 1];
            }
            infinity = eCPoint2.timesPow2(i13);
        }
        while (length > 0) {
            length--;
            int i15 = generateCompactWindowNaf[length];
            int i16 = i15 >> 16;
            infinity = infinity.twicePlus((i16 < 0 ? preCompNeg : preComp)[Math.abs(i16) >>> 1]).timesPow2(i15 & 65535);
        }
        return infinity;
    }
}
