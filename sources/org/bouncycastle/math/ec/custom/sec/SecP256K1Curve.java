package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.AbstractECLookupTable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.encoders.Hex;

public class SecP256K1Curve extends ECCurve.AbstractFp {
    /* access modifiers changed from: private */
    public static final ECFieldElement[] SECP256K1_AFFINE_ZS = {new SecP256K1FieldElement(ECConstants.ONE)};
    private static final int SECP256K1_DEFAULT_COORDS = 2;

    /* renamed from: q  reason: collision with root package name */
    public static final BigInteger f59426q = SecP256K1FieldElement.Q;
    public SecP256K1Point infinity = new SecP256K1Point(this, (ECFieldElement) null, (ECFieldElement) null);

    public SecP256K1Curve() {
        super(f59426q);
        this.f59387a = fromBigInteger(ECConstants.ZERO);
        this.f59388b = fromBigInteger(BigInteger.valueOf(7));
        this.order = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
        this.cofactor = BigInteger.valueOf(1);
        this.coord = 2;
    }

    public ECCurve cloneCurve() {
        return new SecP256K1Curve();
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i11, final int i12) {
        final int[] iArr = new int[(i12 * 8 * 2)];
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            ECPoint eCPoint = eCPointArr[i11 + i14];
            Nat256.copy(((SecP256K1FieldElement) eCPoint.getRawXCoord()).f59427x, 0, iArr, i13);
            int i15 = i13 + 8;
            Nat256.copy(((SecP256K1FieldElement) eCPoint.getRawYCoord()).f59427x, 0, iArr, i15);
            i13 = i15 + 8;
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(int[] iArr, int[] iArr2) {
                return SecP256K1Curve.this.createRawPoint(new SecP256K1FieldElement(iArr), new SecP256K1FieldElement(iArr2), SecP256K1Curve.SECP256K1_AFFINE_ZS);
            }

            public int getSize() {
                return i12;
            }

            public ECPoint lookup(int i11) {
                int[] create = Nat256.create();
                int[] create2 = Nat256.create();
                int i12 = 0;
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = ((i13 ^ i11) - 1) >> 31;
                    for (int i15 = 0; i15 < 8; i15++) {
                        int i16 = create[i15];
                        int[] iArr = iArr;
                        create[i15] = i16 ^ (iArr[i12 + i15] & i14);
                        create2[i15] = create2[i15] ^ (iArr[(i12 + 8) + i15] & i14);
                    }
                    i12 += 16;
                }
                return createPoint(create, create2);
            }

            public ECPoint lookupVar(int i11) {
                int[] create = Nat256.create();
                int[] create2 = Nat256.create();
                int i12 = i11 * 8 * 2;
                for (int i13 = 0; i13 < 8; i13++) {
                    int[] iArr = iArr;
                    create[i13] = iArr[i12 + i13];
                    create2[i13] = iArr[i12 + 8 + i13];
                }
                return createPoint(create, create2);
            }
        };
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP256K1Point(this, eCFieldElement, eCFieldElement2);
    }

    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP256K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }

    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP256K1FieldElement(bigInteger);
    }

    public int getFieldSize() {
        return f59426q.bitLength();
    }

    public ECPoint getInfinity() {
        return this.infinity;
    }

    public BigInteger getQ() {
        return f59426q;
    }

    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] create = Nat256.create();
        SecP256K1Field.random(secureRandom, create);
        return new SecP256K1FieldElement(create);
    }

    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] create = Nat256.create();
        SecP256K1Field.randomMult(secureRandom, create);
        return new SecP256K1FieldElement(create);
    }

    public boolean supportsCoordinateSystem(int i11) {
        return i11 == 2;
    }
}
