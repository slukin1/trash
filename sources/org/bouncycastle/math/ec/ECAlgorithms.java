package org.bouncycastle.math.ec;

import com.google.common.base.Ascii;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.endo.ECEndomorphism;
import org.bouncycastle.math.ec.endo.EndoUtil;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.math.raw.Nat;

public class ECAlgorithms {
    public static ECPoint cleanPoint(ECCurve eCCurve, ECPoint eCPoint) {
        if (eCCurve.equals(eCPoint.getCurve())) {
            return eCCurve.decodePoint(eCPoint.getEncoded(false));
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static ECPoint implCheckResult(ECPoint eCPoint) {
        if (eCPoint.isValidPartial()) {
            return eCPoint;
        }
        throw new IllegalStateException("Invalid result");
    }

    private static ECPoint implShamirsTrickFixedPoint(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECPoint add;
        ECPoint offset;
        BigInteger bigInteger3 = bigInteger;
        BigInteger bigInteger4 = bigInteger2;
        ECCurve curve = eCPoint.getCurve();
        int combSize = FixedPointUtil.getCombSize(curve);
        if (bigInteger.bitLength() > combSize || bigInteger2.bitLength() > combSize) {
            throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
        }
        FixedPointPreCompInfo precompute = FixedPointUtil.precompute(eCPoint);
        FixedPointPreCompInfo precompute2 = FixedPointUtil.precompute(eCPoint2);
        ECLookupTable lookupTable = precompute.getLookupTable();
        ECLookupTable lookupTable2 = precompute2.getLookupTable();
        int width = precompute.getWidth();
        if (width != precompute2.getWidth()) {
            FixedPointCombMultiplier fixedPointCombMultiplier = new FixedPointCombMultiplier();
            add = fixedPointCombMultiplier.multiply(eCPoint, bigInteger3);
            offset = fixedPointCombMultiplier.multiply(eCPoint2, bigInteger4);
        } else {
            int i11 = ((combSize + width) - 1) / width;
            ECPoint infinity = curve.getInfinity();
            int i12 = width * i11;
            int[] fromBigInteger = Nat.fromBigInteger(i12, bigInteger3);
            int[] fromBigInteger2 = Nat.fromBigInteger(i12, bigInteger4);
            int i13 = i12 - 1;
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = 0;
                int i16 = 0;
                for (int i17 = i13 - i14; i17 >= 0; i17 -= i11) {
                    int i18 = i17 >>> 5;
                    int i19 = i17 & 31;
                    int i21 = fromBigInteger[i18] >>> i19;
                    i15 = ((i15 ^ (i21 >>> 1)) << 1) ^ i21;
                    int i22 = fromBigInteger2[i18] >>> i19;
                    i16 = ((i16 ^ (i22 >>> 1)) << 1) ^ i22;
                }
                infinity = infinity.twicePlus(lookupTable.lookupVar(i15).add(lookupTable2.lookupVar(i16)));
            }
            add = infinity.add(precompute.getOffset());
            offset = precompute2.getOffset();
        }
        return add.add(offset);
    }

    public static ECPoint implShamirsTrickJsf(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECCurve curve = eCPoint.getCurve();
        ECPoint infinity = curve.getInfinity();
        ECPoint[] eCPointArr = {eCPoint2, eCPoint.subtract(eCPoint2), eCPoint, eCPoint.add(eCPoint2)};
        curve.normalizeAll(eCPointArr);
        ECPoint[] eCPointArr2 = {eCPointArr[3].negate(), eCPointArr[2].negate(), eCPointArr[1].negate(), eCPointArr[0].negate(), infinity, eCPointArr[0], eCPointArr[1], eCPointArr[2], eCPointArr[3]};
        byte[] generateJSF = WNafUtil.generateJSF(bigInteger, bigInteger2);
        int length = generateJSF.length;
        while (true) {
            length--;
            if (length < 0) {
                return infinity;
            }
            byte b11 = generateJSF[length];
            infinity = infinity.twicePlus(eCPointArr2[(((b11 << Ascii.CAN) >> 28) * 3) + 4 + ((b11 << 28) >> 28)]);
        }
    }

    public static ECPoint implShamirsTrickWNaf(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        boolean z11 = false;
        boolean z12 = bigInteger.signum() < 0;
        if (bigInteger2.signum() < 0) {
            z11 = true;
        }
        BigInteger abs = bigInteger.abs();
        BigInteger abs2 = bigInteger2.abs();
        int windowSize = WNafUtil.getWindowSize(abs.bitLength(), 8);
        int windowSize2 = WNafUtil.getWindowSize(abs2.bitLength(), 8);
        WNafPreCompInfo precompute = WNafUtil.precompute(eCPoint, windowSize, true);
        WNafPreCompInfo precompute2 = WNafUtil.precompute(eCPoint2, windowSize2, true);
        int combSize = FixedPointUtil.getCombSize(eCPoint.getCurve());
        if (!z12 && !z11 && bigInteger.bitLength() <= combSize && bigInteger2.bitLength() <= combSize && precompute.isPromoted() && precompute2.isPromoted()) {
            return implShamirsTrickFixedPoint(eCPoint, bigInteger, eCPoint2, bigInteger2);
        }
        return implShamirsTrickWNaf(z12 ? precompute.getPreCompNeg() : precompute.getPreComp(), z12 ? precompute.getPreComp() : precompute.getPreCompNeg(), WNafUtil.generateWindowNaf(Math.min(8, precompute.getWidth()), abs), z11 ? precompute2.getPreCompNeg() : precompute2.getPreComp(), z11 ? precompute2.getPreComp() : precompute2.getPreCompNeg(), WNafUtil.generateWindowNaf(Math.min(8, precompute2.getWidth()), abs2));
    }

    public static ECPoint implShamirsTrickWNaf(ECEndomorphism eCEndomorphism, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        boolean z11 = false;
        boolean z12 = bigInteger.signum() < 0;
        if (bigInteger2.signum() < 0) {
            z11 = true;
        }
        BigInteger abs = bigInteger.abs();
        BigInteger abs2 = bigInteger2.abs();
        WNafPreCompInfo precompute = WNafUtil.precompute(eCPoint, WNafUtil.getWindowSize(Math.max(abs.bitLength(), abs2.bitLength()), 8), true);
        WNafPreCompInfo precomputeWithPointMap = WNafUtil.precomputeWithPointMap(EndoUtil.mapPoint(eCEndomorphism, eCPoint), eCEndomorphism.getPointMap(), precompute, true);
        return implShamirsTrickWNaf(z12 ? precompute.getPreCompNeg() : precompute.getPreComp(), z12 ? precompute.getPreComp() : precompute.getPreCompNeg(), WNafUtil.generateWindowNaf(Math.min(8, precompute.getWidth()), abs), z11 ? precomputeWithPointMap.getPreCompNeg() : precomputeWithPointMap.getPreComp(), z11 ? precomputeWithPointMap.getPreComp() : precomputeWithPointMap.getPreCompNeg(), WNafUtil.generateWindowNaf(Math.min(8, precomputeWithPointMap.getWidth()), abs2));
    }

    private static ECPoint implShamirsTrickWNaf(ECPoint[] eCPointArr, ECPoint[] eCPointArr2, byte[] bArr, ECPoint[] eCPointArr3, ECPoint[] eCPointArr4, byte[] bArr2) {
        ECPoint eCPoint;
        int max = Math.max(bArr.length, bArr2.length);
        ECPoint infinity = eCPointArr[0].getCurve().getInfinity();
        int i11 = max - 1;
        int i12 = 0;
        ECPoint eCPoint2 = infinity;
        while (i11 >= 0) {
            byte b11 = i11 < bArr.length ? bArr[i11] : 0;
            byte b12 = i11 < bArr2.length ? bArr2[i11] : 0;
            if ((b11 | b12) == 0) {
                i12++;
            } else {
                if (b11 != 0) {
                    eCPoint = infinity.add((b11 < 0 ? eCPointArr2 : eCPointArr)[Math.abs(b11) >>> 1]);
                } else {
                    eCPoint = infinity;
                }
                if (b12 != 0) {
                    eCPoint = eCPoint.add((b12 < 0 ? eCPointArr4 : eCPointArr3)[Math.abs(b12) >>> 1]);
                }
                if (i12 > 0) {
                    eCPoint2 = eCPoint2.timesPow2(i12);
                    i12 = 0;
                }
                eCPoint2 = eCPoint2.twicePlus(eCPoint);
            }
            i11--;
        }
        return i12 > 0 ? eCPoint2.timesPow2(i12) : eCPoint2;
    }

    public static ECPoint implSumOfMultiplies(ECEndomorphism eCEndomorphism, ECPoint[] eCPointArr, BigInteger[] bigIntegerArr) {
        ECPoint[] eCPointArr2 = eCPointArr;
        int length = eCPointArr2.length;
        int i11 = length << 1;
        boolean[] zArr = new boolean[i11];
        WNafPreCompInfo[] wNafPreCompInfoArr = new WNafPreCompInfo[i11];
        byte[][] bArr = new byte[i11][];
        ECPointMap pointMap = eCEndomorphism.getPointMap();
        int i12 = 0;
        while (i12 < length) {
            int i13 = i12 << 1;
            int i14 = i13 + 1;
            BigInteger bigInteger = bigIntegerArr[i13];
            zArr[i13] = bigInteger.signum() < 0;
            BigInteger abs = bigInteger.abs();
            BigInteger bigInteger2 = bigIntegerArr[i14];
            zArr[i14] = bigInteger2.signum() < 0;
            BigInteger abs2 = bigInteger2.abs();
            int windowSize = WNafUtil.getWindowSize(Math.max(abs.bitLength(), abs2.bitLength()), 8);
            ECPoint eCPoint = eCPointArr2[i12];
            WNafPreCompInfo precompute = WNafUtil.precompute(eCPoint, windowSize, true);
            WNafPreCompInfo precomputeWithPointMap = WNafUtil.precomputeWithPointMap(EndoUtil.mapPoint(eCEndomorphism, eCPoint), pointMap, precompute, true);
            int min = Math.min(8, precompute.getWidth());
            int min2 = Math.min(8, precomputeWithPointMap.getWidth());
            wNafPreCompInfoArr[i13] = precompute;
            wNafPreCompInfoArr[i14] = precomputeWithPointMap;
            bArr[i13] = WNafUtil.generateWindowNaf(min, abs);
            bArr[i14] = WNafUtil.generateWindowNaf(min2, abs2);
            i12++;
            eCPointArr2 = eCPointArr;
        }
        return implSumOfMultiplies(zArr, wNafPreCompInfoArr, bArr);
    }

    public static ECPoint implSumOfMultiplies(ECPoint[] eCPointArr, BigInteger[] bigIntegerArr) {
        int length = eCPointArr.length;
        boolean[] zArr = new boolean[length];
        WNafPreCompInfo[] wNafPreCompInfoArr = new WNafPreCompInfo[length];
        byte[][] bArr = new byte[length][];
        for (int i11 = 0; i11 < length; i11++) {
            BigInteger bigInteger = bigIntegerArr[i11];
            zArr[i11] = bigInteger.signum() < 0;
            BigInteger abs = bigInteger.abs();
            WNafPreCompInfo precompute = WNafUtil.precompute(eCPointArr[i11], WNafUtil.getWindowSize(abs.bitLength(), 8), true);
            int min = Math.min(8, precompute.getWidth());
            wNafPreCompInfoArr[i11] = precompute;
            bArr[i11] = WNafUtil.generateWindowNaf(min, abs);
        }
        return implSumOfMultiplies(zArr, wNafPreCompInfoArr, bArr);
    }

    private static ECPoint implSumOfMultiplies(boolean[] zArr, WNafPreCompInfo[] wNafPreCompInfoArr, byte[][] bArr) {
        int i11 = 0;
        for (byte[] length : bArr) {
            i11 = Math.max(i11, length.length);
        }
        ECPoint infinity = wNafPreCompInfoArr[0].getPreComp()[0].getCurve().getInfinity();
        int i12 = i11 - 1;
        int i13 = 0;
        ECPoint eCPoint = infinity;
        while (i12 >= 0) {
            ECPoint eCPoint2 = infinity;
            for (int i14 = 0; i14 < r0; i14++) {
                byte[] bArr2 = bArr[i14];
                byte b11 = i12 < bArr2.length ? bArr2[i12] : 0;
                if (b11 != 0) {
                    int abs = Math.abs(b11);
                    WNafPreCompInfo wNafPreCompInfo = wNafPreCompInfoArr[i14];
                    eCPoint2 = eCPoint2.add(((b11 < 0) == zArr[i14] ? wNafPreCompInfo.getPreComp() : wNafPreCompInfo.getPreCompNeg())[abs >>> 1]);
                }
            }
            if (eCPoint2 == infinity) {
                i13++;
            } else {
                if (i13 > 0) {
                    eCPoint = eCPoint.timesPow2(i13);
                    i13 = 0;
                }
                eCPoint = eCPoint.twicePlus(eCPoint2);
            }
            i12--;
        }
        return i13 > 0 ? eCPoint.timesPow2(i13) : eCPoint;
    }

    public static ECPoint implSumOfMultipliesGLV(ECPoint[] eCPointArr, BigInteger[] bigIntegerArr, GLVEndomorphism gLVEndomorphism) {
        BigInteger order = eCPointArr[0].getCurve().getOrder();
        int i11 = r2 << 1;
        BigInteger[] bigIntegerArr2 = new BigInteger[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < r2; i13++) {
            BigInteger[] decomposeScalar = gLVEndomorphism.decomposeScalar(bigIntegerArr[i13].mod(order));
            int i14 = i12 + 1;
            bigIntegerArr2[i12] = decomposeScalar[0];
            i12 = i14 + 1;
            bigIntegerArr2[i14] = decomposeScalar[1];
        }
        if (gLVEndomorphism.hasEfficientPointMap()) {
            return implSumOfMultiplies((ECEndomorphism) gLVEndomorphism, eCPointArr, bigIntegerArr2);
        }
        ECPoint[] eCPointArr2 = new ECPoint[i11];
        int i15 = 0;
        for (ECPoint eCPoint : eCPointArr) {
            ECPoint mapPoint = EndoUtil.mapPoint(gLVEndomorphism, eCPoint);
            int i16 = i15 + 1;
            eCPointArr2[i15] = eCPoint;
            i15 = i16 + 1;
            eCPointArr2[i16] = mapPoint;
        }
        return implSumOfMultiplies(eCPointArr2, bigIntegerArr2);
    }

    public static ECPoint importPoint(ECCurve eCCurve, ECPoint eCPoint) {
        if (eCCurve.equals(eCPoint.getCurve())) {
            return eCCurve.importPoint(eCPoint);
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static boolean isF2mCurve(ECCurve eCCurve) {
        return isF2mField(eCCurve.getField());
    }

    public static boolean isF2mField(FiniteField finiteField) {
        return finiteField.getDimension() > 1 && finiteField.getCharacteristic().equals(ECConstants.TWO) && (finiteField instanceof PolynomialExtensionField);
    }

    public static boolean isFpCurve(ECCurve eCCurve) {
        return isFpField(eCCurve.getField());
    }

    public static boolean isFpField(FiniteField finiteField) {
        return finiteField.getDimension() == 1;
    }

    public static void montgomeryTrick(ECFieldElement[] eCFieldElementArr, int i11, int i12) {
        montgomeryTrick(eCFieldElementArr, i11, i12, (ECFieldElement) null);
    }

    public static void montgomeryTrick(ECFieldElement[] eCFieldElementArr, int i11, int i12, ECFieldElement eCFieldElement) {
        ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[i12];
        int i13 = 0;
        eCFieldElementArr2[0] = eCFieldElementArr[i11];
        while (true) {
            i13++;
            if (i13 >= i12) {
                break;
            }
            eCFieldElementArr2[i13] = eCFieldElementArr2[i13 - 1].multiply(eCFieldElementArr[i11 + i13]);
        }
        int i14 = i13 - 1;
        if (eCFieldElement != null) {
            eCFieldElementArr2[i14] = eCFieldElementArr2[i14].multiply(eCFieldElement);
        }
        ECFieldElement invert = eCFieldElementArr2[i14].invert();
        while (i14 > 0) {
            int i15 = i14 - 1;
            int i16 = i14 + i11;
            ECFieldElement eCFieldElement2 = eCFieldElementArr[i16];
            eCFieldElementArr[i16] = eCFieldElementArr2[i15].multiply(invert);
            invert = invert.multiply(eCFieldElement2);
            i14 = i15;
        }
        eCFieldElementArr[i11] = invert;
    }

    public static ECPoint referenceMultiply(ECPoint eCPoint, BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int bitLength = abs.bitLength();
        if (bitLength > 0) {
            if (abs.testBit(0)) {
                infinity = eCPoint;
            }
            for (int i11 = 1; i11 < bitLength; i11++) {
                eCPoint = eCPoint.twice();
                if (abs.testBit(i11)) {
                    infinity = infinity.add(eCPoint);
                }
            }
        }
        return bigInteger.signum() < 0 ? infinity.negate() : infinity;
    }

    public static ECPoint shamirsTrick(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        return implCheckResult(implShamirsTrickJsf(eCPoint, bigInteger, importPoint(eCPoint.getCurve(), eCPoint2), bigInteger2));
    }

    public static ECPoint sumOfMultiplies(ECPoint[] eCPointArr, BigInteger[] bigIntegerArr) {
        if (!(eCPointArr == null || bigIntegerArr == null || eCPointArr.length != bigIntegerArr.length)) {
            if (eCPointArr.length >= 1) {
                int length = eCPointArr.length;
                if (length == 1) {
                    return eCPointArr[0].multiply(bigIntegerArr[0]);
                }
                if (length == 2) {
                    return sumOfTwoMultiplies(eCPointArr[0], bigIntegerArr[0], eCPointArr[1], bigIntegerArr[1]);
                }
                ECPoint eCPoint = eCPointArr[0];
                ECCurve curve = eCPoint.getCurve();
                ECPoint[] eCPointArr2 = new ECPoint[length];
                eCPointArr2[0] = eCPoint;
                for (int i11 = 1; i11 < length; i11++) {
                    eCPointArr2[i11] = importPoint(curve, eCPointArr[i11]);
                }
                ECEndomorphism endomorphism = curve.getEndomorphism();
                return endomorphism instanceof GLVEndomorphism ? implCheckResult(implSumOfMultipliesGLV(eCPointArr2, bigIntegerArr, (GLVEndomorphism) endomorphism)) : implCheckResult(implSumOfMultiplies(eCPointArr2, bigIntegerArr));
            }
        }
        throw new IllegalArgumentException("point and scalar arrays should be non-null, and of equal, non-zero, length");
    }

    public static ECPoint sumOfTwoMultiplies(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECPoint implShamirsTrickWNaf;
        ECCurve curve = eCPoint.getCurve();
        ECPoint importPoint = importPoint(curve, eCPoint2);
        if (!(curve instanceof ECCurve.AbstractF2m) || !((ECCurve.AbstractF2m) curve).isKoblitz()) {
            ECEndomorphism endomorphism = curve.getEndomorphism();
            if (endomorphism instanceof GLVEndomorphism) {
                implShamirsTrickWNaf = implSumOfMultipliesGLV(new ECPoint[]{eCPoint, importPoint}, new BigInteger[]{bigInteger, bigInteger2}, (GLVEndomorphism) endomorphism);
            } else {
                implShamirsTrickWNaf = implShamirsTrickWNaf(eCPoint, bigInteger, importPoint, bigInteger2);
            }
        } else {
            implShamirsTrickWNaf = eCPoint.multiply(bigInteger).add(importPoint.multiply(bigInteger2));
        }
        return implCheckResult(implShamirsTrickWNaf);
    }

    public static ECPoint validatePoint(ECPoint eCPoint) {
        if (eCPoint.isValid()) {
            return eCPoint;
        }
        throw new IllegalStateException("Invalid point");
    }
}
