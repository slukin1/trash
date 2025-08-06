package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat128;
import org.bouncycastle.util.encoders.Hex;

public class SecP128R1Curve extends ECCurve.AbstractFp {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECP128R1_AFFINE_ZS = {new SecP128R1FieldElement(ECConstants.ONE)};
    private static final int SECP128R1_DEFAULT_COORDS = 2;

    /* renamed from: q  reason: collision with root package name */
    public static final BigInteger f59411q = SecP128R1FieldElement.Q;
    public SecP128R1Point infinity = new SecP128R1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecP128R1Curve() {
        super(f59411q);
        this.f59387a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f59388b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("E87579C11079F43DD824993C2CEE5ED3")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFE0000000075A30D1B9038A115"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    public ECCurve cloneCurve() {
        return new SecP128R1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i11, final int i12) {
        final int[] iArr = new int[(i12 * 4 * 2)];
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            ECPoint eCPoint = eCPointArr[i11 + i14];
            Nat128.copy(((SecP128R1FieldElement) eCPoint.getRawXCoord()).f59412x, 0, iArr, i13);
            int i15 = i13 + 4;
            Nat128.copy(((SecP128R1FieldElement) eCPoint.getRawYCoord()).f59412x, 0, iArr, i15);
            i13 = i15 + 4;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(int[] iArr, int[] iArr2) {
                return SecP128R1Curve.this.createRawPoint(new SecP128R1FieldElement(iArr), new SecP128R1FieldElement(iArr2), SecP128R1Curve.SECP128R1_AFFINE_ZS);
            }

            public int getSize() {
                return i12;
            }

            public ECPoint lookup(int i11) {
                int[] create = Nat128.create();
                int[] create2 = Nat128.create();
                int i12 = 0;
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = ((i13 ^ i11) - 1) >> 31;
                    for (int i15 = 0; i15 < 4; i15++) {
                        int i16 = create[i15];
                        int[] iArr = iArr;
                        create[i15] = i16 ^ (iArr[i12 + i15] & i14);
                        create2[i15] = create2[i15] ^ (iArr[(i12 + 4) + i15] & i14);
                    }
                    i12 += 8;
                }
                return createPoint(create, create2);
            }

            public ECPoint lookupVar(int i11) {
                int[] create = Nat128.create();
                int[] create2 = Nat128.create();
                int i12 = i11 * 4 * 2;
                for (int i13 = 0; i13 < 4; i13++) {
                    int[] iArr = iArr;
                    create[i13] = iArr[i12 + i13];
                    create2[i13] = iArr[i12 + 4 + i13];
                }
                return createPoint(create, create2);
            }
        };
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP128R1Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP128R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP128R1FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return f59411q.bitLength();
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f59411q;
    }

    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] create = Nat128.create();
        SecP128R1Field.random(secureRandom, create);
        return new SecP128R1FieldElement(create);
    }

    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] create = Nat128.create();
        SecP128R1Field.randomMult(secureRandom, create);
        return new SecP128R1FieldElement(create);
    }

    public boolean supportsCoordinateSystem(int i11) {
        return i11 == 2;
    }
}
