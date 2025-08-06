package org.bouncycastle.math.ec;

import java.math.BigInteger;

public class FixedPointUtil {
    public static final String PRECOMP_NAME = "bc_fixed_point";

    public static int getCombSize(ECCurve eCCurve) {
        BigInteger order = eCCurve.getOrder();
        return order == null ? eCCurve.getFieldSize() + 1 : order.bitLength();
    }

    public static FixedPointPreCompInfo getFixedPointPreCompInfo(PreCompInfo preCompInfo) {
        if (preCompInfo instanceof FixedPointPreCompInfo) {
            return (FixedPointPreCompInfo) preCompInfo;
        }
        return null;
    }

    public static FixedPointPreCompInfo precompute(final ECPoint eCPoint) {
        final ECCurve curve = eCPoint.getCurve();
        return (FixedPointPreCompInfo) curve.precompute(eCPoint, PRECOMP_NAME, new PreCompCallback() {
            private boolean checkExisting(FixedPointPreCompInfo fixedPointPreCompInfo, int i11) {
                return fixedPointPreCompInfo != null && checkTable(fixedPointPreCompInfo.getLookupTable(), i11);
            }

            private boolean checkTable(ECLookupTable eCLookupTable, int i11) {
                return eCLookupTable != null && eCLookupTable.getSize() >= i11;
            }

            public PreCompInfo precompute(PreCompInfo preCompInfo) {
                FixedPointPreCompInfo fixedPointPreCompInfo = preCompInfo instanceof FixedPointPreCompInfo ? (FixedPointPreCompInfo) preCompInfo : null;
                int combSize = FixedPointUtil.getCombSize(curve);
                int i11 = combSize > 250 ? 6 : 5;
                int i12 = 1 << i11;
                if (checkExisting(fixedPointPreCompInfo, i12)) {
                    return fixedPointPreCompInfo;
                }
                int i13 = ((combSize + i11) - 1) / i11;
                ECPoint[] eCPointArr = new ECPoint[(i11 + 1)];
                eCPointArr[0] = eCPoint;
                for (int i14 = 1; i14 < i11; i14++) {
                    eCPointArr[i14] = eCPointArr[i14 - 1].timesPow2(i13);
                }
                eCPointArr[i11] = eCPointArr[0].subtract(eCPointArr[1]);
                curve.normalizeAll(eCPointArr);
                ECPoint[] eCPointArr2 = new ECPoint[i12];
                eCPointArr2[0] = eCPointArr[0];
                for (int i15 = i11 - 1; i15 >= 0; i15--) {
                    ECPoint eCPoint = eCPointArr[i15];
                    int i16 = 1 << i15;
                    for (int i17 = i16; i17 < i12; i17 += i16 << 1) {
                        eCPointArr2[i17] = eCPointArr2[i17 - i16].add(eCPoint);
                    }
                }
                curve.normalizeAll(eCPointArr2);
                FixedPointPreCompInfo fixedPointPreCompInfo2 = new FixedPointPreCompInfo();
                fixedPointPreCompInfo2.setLookupTable(curve.createCacheSafeLookupTable(eCPointArr2, 0, i12));
                fixedPointPreCompInfo2.setOffset(eCPointArr[i11]);
                fixedPointPreCompInfo2.setWidth(i11);
                return fixedPointPreCompInfo2;
            }
        });
    }
}
