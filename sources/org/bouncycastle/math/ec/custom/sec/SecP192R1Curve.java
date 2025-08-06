package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.encoders.Hex;

public class SecP192R1Curve extends ECCurve.AbstractFp {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECP192R1_AFFINE_ZS = {new SecP192R1FieldElement(ECConstants.ONE)};
    private static final int SECP192R1_DEFAULT_COORDS = 2;

    /* renamed from: q  reason: collision with root package name */
    public static final BigInteger f59420q = SecP192R1FieldElement.Q;
    public SecP192R1Point infinity = new SecP192R1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecP192R1Curve() {
        super(f59420q);
        this.f59387a = fromBigInteger(new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC")));
        this.f59388b = fromBigInteger(new BigInteger(1, Hex.decodeStrict("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1")));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    public ECCurve cloneCurve() {
        return new SecP192R1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i11, final int i12) {
        final int[] iArr = new int[(i12 * 6 * 2)];
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            ECPoint eCPoint = eCPointArr[i11 + i14];
            Nat192.copy(((SecP192R1FieldElement) eCPoint.getRawXCoord()).f59421x, 0, iArr, i13);
            int i15 = i13 + 6;
            Nat192.copy(((SecP192R1FieldElement) eCPoint.getRawYCoord()).f59421x, 0, iArr, i15);
            i13 = i15 + 6;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(int[] iArr, int[] iArr2) {
                return SecP192R1Curve.this.createRawPoint(new SecP192R1FieldElement(iArr), new SecP192R1FieldElement(iArr2), SecP192R1Curve.SECP192R1_AFFINE_ZS);
            }

            public int getSize() {
                return i12;
            }

            public ECPoint lookup(int i11) {
                int[] create = Nat192.create();
                int[] create2 = Nat192.create();
                int i12 = 0;
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = ((i13 ^ i11) - 1) >> 31;
                    for (int i15 = 0; i15 < 6; i15++) {
                        int i16 = create[i15];
                        int[] iArr = iArr;
                        create[i15] = i16 ^ (iArr[i12 + i15] & i14);
                        create2[i15] = create2[i15] ^ (iArr[(i12 + 6) + i15] & i14);
                    }
                    i12 += 12;
                }
                return createPoint(create, create2);
            }

            public ECPoint lookupVar(int i11) {
                int[] create = Nat192.create();
                int[] create2 = Nat192.create();
                int i12 = i11 * 6 * 2;
                for (int i13 = 0; i13 < 6; i13++) {
                    int[] iArr = iArr;
                    create[i13] = iArr[i12 + i13];
                    create2[i13] = iArr[i12 + 6 + i13];
                }
                return createPoint(create, create2);
            }
        };
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP192R1Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP192R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP192R1FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return f59420q.bitLength();
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f59420q;
    }

    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] create = Nat192.create();
        SecP192R1Field.random(secureRandom, create);
        return new SecP192R1FieldElement(create);
    }

    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] create = Nat192.create();
        SecP192R1Field.randomMult(secureRandom, create);
        return new SecP192R1FieldElement(create);
    }

    public boolean supportsCoordinateSystem(int i11) {
        return i11 == 2;
    }
}
