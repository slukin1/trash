package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;

public class FixedPointCombMultiplier extends AbstractECMultiplier {
    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        ECCurve curve = eCPoint.getCurve();
        int combSize = FixedPointUtil.getCombSize(curve);
        if (bigInteger.bitLength() <= combSize) {
            FixedPointPreCompInfo precompute = FixedPointUtil.precompute(eCPoint);
            ECLookupTable lookupTable = precompute.getLookupTable();
            int width = precompute.getWidth();
            int i11 = ((combSize + width) - 1) / width;
            ECPoint infinity = curve.getInfinity();
            int i12 = width * i11;
            int[] fromBigInteger = Nat.fromBigInteger(i12, bigInteger);
            int i13 = i12 - 1;
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = 0;
                for (int i16 = i13 - i14; i16 >= 0; i16 -= i11) {
                    int i17 = fromBigInteger[i16 >>> 5] >>> (i16 & 31);
                    i15 = ((i15 ^ (i17 >>> 1)) << 1) ^ i17;
                }
                infinity = infinity.twicePlus(lookupTable.lookup(i15));
            }
            return infinity.add(precompute.getOffset());
        }
        throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
    }
}
