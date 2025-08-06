package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;

public abstract class ECFieldElement implements ECConstants {

    public static abstract class AbstractF2m extends ECFieldElement {
        public ECFieldElement halfTrace() {
            int fieldSize = getFieldSize();
            if ((fieldSize & 1) != 0) {
                int i11 = (fieldSize + 1) >>> 1;
                int numberOfLeadingZeros = 31 - Integers.numberOfLeadingZeros(i11);
                ECFieldElement eCFieldElement = this;
                int i12 = 1;
                while (numberOfLeadingZeros > 0) {
                    eCFieldElement = eCFieldElement.squarePow(i12 << 1).add(eCFieldElement);
                    numberOfLeadingZeros--;
                    i12 = i11 >>> numberOfLeadingZeros;
                    if ((i12 & 1) != 0) {
                        eCFieldElement = eCFieldElement.squarePow(2).add(this);
                    }
                }
                return eCFieldElement;
            }
            throw new IllegalStateException("Half-trace only defined for odd m");
        }

        public boolean hasFastTrace() {
            return false;
        }

        public int trace() {
            int fieldSize = getFieldSize();
            int numberOfLeadingZeros = 31 - Integers.numberOfLeadingZeros(fieldSize);
            ECFieldElement eCFieldElement = this;
            int i11 = 1;
            while (numberOfLeadingZeros > 0) {
                eCFieldElement = eCFieldElement.squarePow(i11).add(eCFieldElement);
                numberOfLeadingZeros--;
                i11 = fieldSize >>> numberOfLeadingZeros;
                if ((i11 & 1) != 0) {
                    eCFieldElement = eCFieldElement.square().add(this);
                }
            }
            if (eCFieldElement.isZero()) {
                return 0;
            }
            if (eCFieldElement.isOne()) {
                return 1;
            }
            throw new IllegalStateException("Internal error in trace calculation");
        }
    }

    public static abstract class AbstractFp extends ECFieldElement {
    }

    public static class F2m extends AbstractF2m {
        public static final int GNB = 1;
        public static final int PPB = 3;
        public static final int TPB = 2;

        /* renamed from: ks  reason: collision with root package name */
        private int[] f59396ks;

        /* renamed from: m  reason: collision with root package name */
        private int f59397m;
        private int representation;

        /* renamed from: x  reason: collision with root package name */
        public LongArray f59398x;

        public F2m(int i11, int i12, int i13, int i14, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i11) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i13 == 0 && i14 == 0) {
                this.representation = 2;
                this.f59396ks = new int[]{i12};
            } else if (i13 >= i14) {
                throw new IllegalArgumentException("k2 must be smaller than k3");
            } else if (i13 > 0) {
                this.representation = 3;
                this.f59396ks = new int[]{i12, i13, i14};
            } else {
                throw new IllegalArgumentException("k2 must be larger than 0");
            }
            this.f59397m = i11;
            this.f59398x = new LongArray(bigInteger);
        }

        public F2m(int i11, int[] iArr, LongArray longArray) {
            this.f59397m = i11;
            this.representation = iArr.length == 1 ? 2 : 3;
            this.f59396ks = iArr;
            this.f59398x = longArray;
        }

        public ECFieldElement add(ECFieldElement eCFieldElement) {
            LongArray longArray = (LongArray) this.f59398x.clone();
            longArray.addShiftedByWords(((F2m) eCFieldElement).f59398x, 0);
            return new F2m(this.f59397m, this.f59396ks, longArray);
        }

        public ECFieldElement addOne() {
            return new F2m(this.f59397m, this.f59396ks, this.f59398x.addOne());
        }

        public int bitLength() {
            return this.f59398x.degree();
        }

        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return multiply(eCFieldElement.invert());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            return this.f59397m == f2m.f59397m && this.representation == f2m.representation && Arrays.areEqual(this.f59396ks, f2m.f59396ks) && this.f59398x.equals(f2m.f59398x);
        }

        public String getFieldName() {
            return "F2m";
        }

        public int getFieldSize() {
            return this.f59397m;
        }

        public int getK1() {
            return this.f59396ks[0];
        }

        public int getK2() {
            int[] iArr = this.f59396ks;
            if (iArr.length >= 2) {
                return iArr[1];
            }
            return 0;
        }

        public int getK3() {
            int[] iArr = this.f59396ks;
            if (iArr.length >= 3) {
                return iArr[2];
            }
            return 0;
        }

        public int getM() {
            return this.f59397m;
        }

        public int getRepresentation() {
            return this.representation;
        }

        public int hashCode() {
            return (this.f59398x.hashCode() ^ this.f59397m) ^ Arrays.hashCode(this.f59396ks);
        }

        public ECFieldElement invert() {
            int i11 = this.f59397m;
            int[] iArr = this.f59396ks;
            return new F2m(i11, iArr, this.f59398x.modInverse(i11, iArr));
        }

        public boolean isOne() {
            return this.f59398x.isOne();
        }

        public boolean isZero() {
            return this.f59398x.isZero();
        }

        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            int i11 = this.f59397m;
            int[] iArr = this.f59396ks;
            return new F2m(i11, iArr, this.f59398x.modMultiply(((F2m) eCFieldElement).f59398x, i11, iArr));
        }

        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            return multiplyPlusProduct(eCFieldElement, eCFieldElement2, eCFieldElement3);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: org.bouncycastle.math.ec.LongArray} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.bouncycastle.math.ec.ECFieldElement multiplyPlusProduct(org.bouncycastle.math.ec.ECFieldElement r5, org.bouncycastle.math.ec.ECFieldElement r6, org.bouncycastle.math.ec.ECFieldElement r7) {
            /*
                r4 = this;
                org.bouncycastle.math.ec.LongArray r0 = r4.f59398x
                org.bouncycastle.math.ec.ECFieldElement$F2m r5 = (org.bouncycastle.math.ec.ECFieldElement.F2m) r5
                org.bouncycastle.math.ec.LongArray r5 = r5.f59398x
                org.bouncycastle.math.ec.ECFieldElement$F2m r6 = (org.bouncycastle.math.ec.ECFieldElement.F2m) r6
                org.bouncycastle.math.ec.LongArray r6 = r6.f59398x
                org.bouncycastle.math.ec.ECFieldElement$F2m r7 = (org.bouncycastle.math.ec.ECFieldElement.F2m) r7
                org.bouncycastle.math.ec.LongArray r7 = r7.f59398x
                int r1 = r4.f59397m
                int[] r2 = r4.f59396ks
                org.bouncycastle.math.ec.LongArray r1 = r0.multiply(r5, r1, r2)
                int r2 = r4.f59397m
                int[] r3 = r4.f59396ks
                org.bouncycastle.math.ec.LongArray r6 = r6.multiply(r7, r2, r3)
                if (r1 == r0) goto L_0x0022
                if (r1 != r5) goto L_0x0029
            L_0x0022:
                java.lang.Object r5 = r1.clone()
                r1 = r5
                org.bouncycastle.math.ec.LongArray r1 = (org.bouncycastle.math.ec.LongArray) r1
            L_0x0029:
                r5 = 0
                r1.addShiftedByWords(r6, r5)
                int r5 = r4.f59397m
                int[] r6 = r4.f59396ks
                r1.reduce(r5, r6)
                org.bouncycastle.math.ec.ECFieldElement$F2m r5 = new org.bouncycastle.math.ec.ECFieldElement$F2m
                int r6 = r4.f59397m
                int[] r7 = r4.f59396ks
                r5.<init>(r6, r7, r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.ECFieldElement.F2m.multiplyPlusProduct(org.bouncycastle.math.ec.ECFieldElement, org.bouncycastle.math.ec.ECFieldElement, org.bouncycastle.math.ec.ECFieldElement):org.bouncycastle.math.ec.ECFieldElement");
        }

        public ECFieldElement negate() {
            return this;
        }

        public ECFieldElement sqrt() {
            return (this.f59398x.isZero() || this.f59398x.isOne()) ? this : squarePow(this.f59397m - 1);
        }

        public ECFieldElement square() {
            int i11 = this.f59397m;
            int[] iArr = this.f59396ks;
            return new F2m(i11, iArr, this.f59398x.modSquare(i11, iArr));
        }

        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            return squarePlusProduct(eCFieldElement, eCFieldElement2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: org.bouncycastle.math.ec.LongArray} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.bouncycastle.math.ec.ECFieldElement squarePlusProduct(org.bouncycastle.math.ec.ECFieldElement r5, org.bouncycastle.math.ec.ECFieldElement r6) {
            /*
                r4 = this;
                org.bouncycastle.math.ec.LongArray r0 = r4.f59398x
                org.bouncycastle.math.ec.ECFieldElement$F2m r5 = (org.bouncycastle.math.ec.ECFieldElement.F2m) r5
                org.bouncycastle.math.ec.LongArray r5 = r5.f59398x
                org.bouncycastle.math.ec.ECFieldElement$F2m r6 = (org.bouncycastle.math.ec.ECFieldElement.F2m) r6
                org.bouncycastle.math.ec.LongArray r6 = r6.f59398x
                int r1 = r4.f59397m
                int[] r2 = r4.f59396ks
                org.bouncycastle.math.ec.LongArray r1 = r0.square(r1, r2)
                int r2 = r4.f59397m
                int[] r3 = r4.f59396ks
                org.bouncycastle.math.ec.LongArray r5 = r5.multiply(r6, r2, r3)
                if (r1 != r0) goto L_0x0023
                java.lang.Object r6 = r1.clone()
                r1 = r6
                org.bouncycastle.math.ec.LongArray r1 = (org.bouncycastle.math.ec.LongArray) r1
            L_0x0023:
                r6 = 0
                r1.addShiftedByWords(r5, r6)
                int r5 = r4.f59397m
                int[] r6 = r4.f59396ks
                r1.reduce(r5, r6)
                org.bouncycastle.math.ec.ECFieldElement$F2m r5 = new org.bouncycastle.math.ec.ECFieldElement$F2m
                int r6 = r4.f59397m
                int[] r0 = r4.f59396ks
                r5.<init>(r6, r0, r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.ECFieldElement.F2m.squarePlusProduct(org.bouncycastle.math.ec.ECFieldElement, org.bouncycastle.math.ec.ECFieldElement):org.bouncycastle.math.ec.ECFieldElement");
        }

        public ECFieldElement squarePow(int i11) {
            if (i11 < 1) {
                return this;
            }
            int i12 = this.f59397m;
            int[] iArr = this.f59396ks;
            return new F2m(i12, iArr, this.f59398x.modSquareN(i11, i12, iArr));
        }

        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return add(eCFieldElement);
        }

        public boolean testBitZero() {
            return this.f59398x.testBitZero();
        }

        public BigInteger toBigInteger() {
            return this.f59398x.toBigInteger();
        }
    }

    public static class Fp extends AbstractFp {

        /* renamed from: q  reason: collision with root package name */
        public BigInteger f59399q;

        /* renamed from: r  reason: collision with root package name */
        public BigInteger f59400r;

        /* renamed from: x  reason: collision with root package name */
        public BigInteger f59401x;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.f59399q = bigInteger;
            this.f59400r = bigInteger2;
            this.f59401x = bigInteger3;
        }

        public static BigInteger calculateResidue(BigInteger bigInteger) {
            int bitLength = bigInteger.bitLength();
            if (bitLength < 96 || bigInteger.shiftRight(bitLength - 64).longValue() != -1) {
                return null;
            }
            return ECConstants.ONE.shiftLeft(bitLength).subtract(bigInteger);
        }

        private ECFieldElement checkSqrt(ECFieldElement eCFieldElement) {
            if (eCFieldElement.square().equals(this)) {
                return eCFieldElement;
            }
            return null;
        }

        private BigInteger[] lucasSequence(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int bitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigInteger4 = ECConstants.ONE;
            BigInteger bigInteger5 = bigInteger;
            BigInteger bigInteger6 = bigInteger4;
            BigInteger bigInteger7 = ECConstants.TWO;
            BigInteger bigInteger8 = bigInteger6;
            for (int i11 = bitLength - 1; i11 >= lowestSetBit + 1; i11--) {
                bigInteger4 = modMult(bigInteger4, bigInteger8);
                if (bigInteger3.testBit(i11)) {
                    bigInteger8 = modMult(bigInteger4, bigInteger2);
                    bigInteger6 = modMult(bigInteger6, bigInteger5);
                    bigInteger7 = modReduce(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(bigInteger4)));
                    bigInteger5 = modReduce(bigInteger5.multiply(bigInteger5).subtract(bigInteger8.shiftLeft(1)));
                } else {
                    BigInteger modReduce = modReduce(bigInteger6.multiply(bigInteger7).subtract(bigInteger4));
                    BigInteger modReduce2 = modReduce(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(bigInteger4)));
                    bigInteger7 = modReduce(bigInteger7.multiply(bigInteger7).subtract(bigInteger4.shiftLeft(1)));
                    bigInteger5 = modReduce2;
                    bigInteger6 = modReduce;
                    bigInteger8 = bigInteger4;
                }
            }
            BigInteger modMult = modMult(bigInteger4, bigInteger8);
            BigInteger modMult2 = modMult(modMult, bigInteger2);
            BigInteger modReduce3 = modReduce(bigInteger6.multiply(bigInteger7).subtract(modMult));
            BigInteger modReduce4 = modReduce(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(modMult)));
            BigInteger modMult3 = modMult(modMult, modMult2);
            for (int i12 = 1; i12 <= lowestSetBit; i12++) {
                modReduce3 = modMult(modReduce3, modReduce4);
                modReduce4 = modReduce(modReduce4.multiply(modReduce4).subtract(modMult3.shiftLeft(1)));
                modMult3 = modMult(modMult3, modMult3);
            }
            return new BigInteger[]{modReduce3, modReduce4};
        }

        public ECFieldElement add(ECFieldElement eCFieldElement) {
            return new Fp(this.f59399q, this.f59400r, modAdd(this.f59401x, eCFieldElement.toBigInteger()));
        }

        public ECFieldElement addOne() {
            BigInteger add = this.f59401x.add(ECConstants.ONE);
            if (add.compareTo(this.f59399q) == 0) {
                add = ECConstants.ZERO;
            }
            return new Fp(this.f59399q, this.f59400r, add);
        }

        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return new Fp(this.f59399q, this.f59400r, modMult(this.f59401x, modInverse(eCFieldElement.toBigInteger())));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Fp)) {
                return false;
            }
            Fp fp2 = (Fp) obj;
            return this.f59399q.equals(fp2.f59399q) && this.f59401x.equals(fp2.f59401x);
        }

        public String getFieldName() {
            return "Fp";
        }

        public int getFieldSize() {
            return this.f59399q.bitLength();
        }

        public BigInteger getQ() {
            return this.f59399q;
        }

        public int hashCode() {
            return this.f59399q.hashCode() ^ this.f59401x.hashCode();
        }

        public ECFieldElement invert() {
            return new Fp(this.f59399q, this.f59400r, modInverse(this.f59401x));
        }

        public BigInteger modAdd(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger add = bigInteger.add(bigInteger2);
            return add.compareTo(this.f59399q) >= 0 ? add.subtract(this.f59399q) : add;
        }

        public BigInteger modDouble(BigInteger bigInteger) {
            BigInteger shiftLeft = bigInteger.shiftLeft(1);
            return shiftLeft.compareTo(this.f59399q) >= 0 ? shiftLeft.subtract(this.f59399q) : shiftLeft;
        }

        public BigInteger modHalf(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f59399q.add(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        public BigInteger modHalfAbs(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f59399q.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        public BigInteger modInverse(BigInteger bigInteger) {
            return BigIntegers.modOddInverse(this.f59399q, bigInteger);
        }

        public BigInteger modMult(BigInteger bigInteger, BigInteger bigInteger2) {
            return modReduce(bigInteger.multiply(bigInteger2));
        }

        public BigInteger modReduce(BigInteger bigInteger) {
            if (this.f59400r == null) {
                return bigInteger.mod(this.f59399q);
            }
            boolean z11 = bigInteger.signum() < 0;
            if (z11) {
                bigInteger = bigInteger.abs();
            }
            int bitLength = this.f59399q.bitLength();
            boolean equals = this.f59400r.equals(ECConstants.ONE);
            while (bigInteger.bitLength() > bitLength + 1) {
                BigInteger shiftRight = bigInteger.shiftRight(bitLength);
                BigInteger subtract = bigInteger.subtract(shiftRight.shiftLeft(bitLength));
                if (!equals) {
                    shiftRight = shiftRight.multiply(this.f59400r);
                }
                bigInteger = shiftRight.add(subtract);
            }
            while (bigInteger.compareTo(this.f59399q) >= 0) {
                bigInteger = bigInteger.subtract(this.f59399q);
            }
            return (!z11 || bigInteger.signum() == 0) ? bigInteger : this.f59399q.subtract(bigInteger);
        }

        public BigInteger modSubtract(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger subtract = bigInteger.subtract(bigInteger2);
            return subtract.signum() < 0 ? subtract.add(this.f59399q) : subtract;
        }

        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            return new Fp(this.f59399q, this.f59400r, modMult(this.f59401x, eCFieldElement.toBigInteger()));
        }

        public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.f59401x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new Fp(this.f59399q, this.f59400r, modReduce(bigInteger.multiply(bigInteger2).subtract(bigInteger3.multiply(bigInteger4))));
        }

        public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
            BigInteger bigInteger = this.f59401x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            BigInteger bigInteger4 = eCFieldElement3.toBigInteger();
            return new Fp(this.f59399q, this.f59400r, modReduce(bigInteger.multiply(bigInteger2).add(bigInteger3.multiply(bigInteger4))));
        }

        public ECFieldElement negate() {
            if (this.f59401x.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.f59399q;
            return new Fp(bigInteger, this.f59400r, bigInteger.subtract(this.f59401x));
        }

        public ECFieldElement sqrt() {
            if (isZero() || isOne()) {
                return this;
            }
            if (!this.f59399q.testBit(0)) {
                throw new RuntimeException("not done yet");
            } else if (this.f59399q.testBit(1)) {
                BigInteger add = this.f59399q.shiftRight(2).add(ECConstants.ONE);
                BigInteger bigInteger = this.f59399q;
                return checkSqrt(new Fp(bigInteger, this.f59400r, this.f59401x.modPow(add, bigInteger)));
            } else if (this.f59399q.testBit(2)) {
                BigInteger modPow = this.f59401x.modPow(this.f59399q.shiftRight(3), this.f59399q);
                BigInteger modMult = modMult(modPow, this.f59401x);
                if (modMult(modMult, modPow).equals(ECConstants.ONE)) {
                    return checkSqrt(new Fp(this.f59399q, this.f59400r, modMult));
                }
                return checkSqrt(new Fp(this.f59399q, this.f59400r, modMult(modMult, ECConstants.TWO.modPow(this.f59399q.shiftRight(2), this.f59399q))));
            } else {
                BigInteger shiftRight = this.f59399q.shiftRight(1);
                BigInteger modPow2 = this.f59401x.modPow(shiftRight, this.f59399q);
                BigInteger bigInteger2 = ECConstants.ONE;
                if (!modPow2.equals(bigInteger2)) {
                    return null;
                }
                BigInteger bigInteger3 = this.f59401x;
                BigInteger modDouble = modDouble(modDouble(bigInteger3));
                BigInteger add2 = shiftRight.add(bigInteger2);
                BigInteger subtract = this.f59399q.subtract(bigInteger2);
                Random random = new Random();
                while (true) {
                    BigInteger bigInteger4 = new BigInteger(this.f59399q.bitLength(), random);
                    if (bigInteger4.compareTo(this.f59399q) < 0 && modReduce(bigInteger4.multiply(bigInteger4).subtract(modDouble)).modPow(shiftRight, this.f59399q).equals(subtract)) {
                        BigInteger[] lucasSequence = lucasSequence(bigInteger4, bigInteger3, add2);
                        BigInteger bigInteger5 = lucasSequence[0];
                        BigInteger bigInteger6 = lucasSequence[1];
                        if (modMult(bigInteger6, bigInteger6).equals(modDouble)) {
                            return new Fp(this.f59399q, this.f59400r, modHalfAbs(bigInteger6));
                        }
                        if (!bigInteger5.equals(ECConstants.ONE) && !bigInteger5.equals(subtract)) {
                            return null;
                        }
                    }
                }
            }
        }

        public ECFieldElement square() {
            BigInteger bigInteger = this.f59399q;
            BigInteger bigInteger2 = this.f59400r;
            BigInteger bigInteger3 = this.f59401x;
            return new Fp(bigInteger, bigInteger2, modMult(bigInteger3, bigInteger3));
        }

        public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.f59401x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new Fp(this.f59399q, this.f59400r, modReduce(bigInteger.multiply(bigInteger).subtract(bigInteger2.multiply(bigInteger3))));
        }

        public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            BigInteger bigInteger = this.f59401x;
            BigInteger bigInteger2 = eCFieldElement.toBigInteger();
            BigInteger bigInteger3 = eCFieldElement2.toBigInteger();
            return new Fp(this.f59399q, this.f59400r, modReduce(bigInteger.multiply(bigInteger).add(bigInteger2.multiply(bigInteger3))));
        }

        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return new Fp(this.f59399q, this.f59400r, modSubtract(this.f59401x, eCFieldElement.toBigInteger()));
        }

        public BigInteger toBigInteger() {
            return this.f59401x;
        }
    }

    public abstract ECFieldElement add(ECFieldElement eCFieldElement);

    public abstract ECFieldElement addOne();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    public abstract ECFieldElement divide(ECFieldElement eCFieldElement);

    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
    }

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public boolean isOne() {
        return bitLength() == 1;
    }

    public boolean isZero() {
        return toBigInteger().signum() == 0;
    }

    public abstract ECFieldElement multiply(ECFieldElement eCFieldElement);

    public ECFieldElement multiplyMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).subtract(eCFieldElement2.multiply(eCFieldElement3));
    }

    public ECFieldElement multiplyPlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3) {
        return multiply(eCFieldElement).add(eCFieldElement2.multiply(eCFieldElement3));
    }

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public ECFieldElement squareMinusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return square().subtract(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePlusProduct(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return square().add(eCFieldElement.multiply(eCFieldElement2));
    }

    public ECFieldElement squarePow(int i11) {
        ECFieldElement eCFieldElement = this;
        for (int i12 = 0; i12 < i11; i12++) {
            eCFieldElement = eCFieldElement.square();
        }
        return eCFieldElement;
    }

    public abstract ECFieldElement subtract(ECFieldElement eCFieldElement);

    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(16);
    }
}
