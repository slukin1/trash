package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.encoders.Hex;

public class SecT163R1Curve extends ECCurve.AbstractF2m {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECT163R1_AFFINE_ZS = {new SecT163FieldElement(ECConstants.ONE)};
    private static final int SECT163R1_DEFAULT_COORDS = 6;
    public SecT163R1Point infinity = new SecT163R1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecT163R1Curve() {
        super(163, 3, 6, 7);
        this.f59387a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("07B6882CAAEFA84F9554FF8428BD88E246D2782AE2")));
        this.f59388b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("0713612DCDDCB40AAB946BDA29CA91F73AF958AFD9")));
        this.order = new BigInteger(1, Hex.decodeStrict("03FFFFFFFFFFFFFFFFFFFF48AAB689C29CA710279B"));
        this.cofactor = BigInteger.valueOf(2);
        this.coord = 6;
    }

    public ECCurve cloneCurve() {
        return new SecT163R1Curve();
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
                return SecT163R1Curve.this.createRawPoint(new SecT163FieldElement(jArr), new SecT163FieldElement(jArr2), SecT163R1Curve.SECT163R1_AFFINE_ZS);
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

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT163R1Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecT163R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
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
        return false;
    }

    public boolean isTrinomial() {
        return false;
    }

    public boolean supportsCoordinateSystem(int i11) {
        return i11 == 6;
    }
}
