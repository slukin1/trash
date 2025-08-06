package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WTauNafMultiplier;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.encoders.Hex;

public class SecT163K1Curve extends ECCurve.AbstractF2m {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECT163K1_AFFINE_ZS = {new SecT163FieldElement(ECConstants.ONE)};
    private static final int SECT163K1_DEFAULT_COORDS = 6;
    public SecT163K1Point infinity = new SecT163K1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecT163K1Curve() {
        super(163, 3, 6, 7);
        ECFieldElement fromBigInteger = fromBigInteger(BigInteger.valueOf(1));
        this.f59387a = fromBigInteger;
        this.f59388b = fromBigInteger;
        this.order = new BigInteger(1, Hex.decodeStrict("04000000000000000000020108A2E0CC0D99F8A5EF"));
        this.cofactor = BigInteger.valueOf(2);
        this.coord = 6;
    }

    public ECCurve cloneCurve() {
        return new SecT163K1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i11, final int i12) {
        final long[] jArr = new long[(i12 * 3 * 2)];
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            ECPoint eCPoint = eCPointArr[i11 + i14];
            Nat192.copy64(((SecT163FieldElement) eCPoint.getRawXCoord()).f59436x, 0, jArr, i13);
            int i15 = i13 + 3;
            Nat192.copy64(((SecT163FieldElement) eCPoint.getRawYCoord()).f59436x, 0, jArr, i15);
            i13 = i15 + 3;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(long[] jArr, long[] jArr2) {
                return SecT163K1Curve.this.createRawPoint(new SecT163FieldElement(jArr), new SecT163FieldElement(jArr2), SecT163K1Curve.SECT163K1_AFFINE_ZS);
            }

            public int getSize() {
                return i12;
            }

            public ECPoint lookup(int i11) {
                long[] create64 = Nat192.create64();
                long[] create642 = Nat192.create64();
                int i12 = 0;
                for (int i13 = 0; i13 < i12; i13++) {
                    long j11 = (long) (((i13 ^ i11) - 1) >> 31);
                    for (int i14 = 0; i14 < 3; i14++) {
                        long j12 = create64[i14];
                        long[] jArr = jArr;
                        create64[i14] = j12 ^ (jArr[i12 + i14] & j11);
                        create642[i14] = create642[i14] ^ (jArr[(i12 + 3) + i14] & j11);
                    }
                    i12 += 6;
                }
                return createPoint(create64, create642);
            }

            public ECPoint lookupVar(int i11) {
                long[] create64 = Nat192.create64();
                long[] create642 = Nat192.create64();
                int i12 = i11 * 3 * 2;
                for (int i13 = 0; i13 < 3; i13++) {
                    long[] jArr = jArr;
                    create64[i13] = jArr[i12 + i13];
                    create642[i13] = jArr[i12 + 3 + i13];
                }
                return createPoint(create64, create642);
            }
        };
    }

    public ECMultiplier createDefaultMultiplier() {
        return new WTauNafMultiplier();
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT163K1Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecT163K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT163FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return 163;
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public int getK1() {
        return 3;
    }

    public int getK2() {
        return 6;
    }

    public int getK3() {
        return 7;
    }

    public int getM() {
        return 163;
    }

    public boolean isKoblitz() {
        return true;
    }

    public boolean isTrinomial() {
        return false;
    }

    public boolean supportsCoordinateSystem(int i11) {
        return i11 == 6;
    }
}
