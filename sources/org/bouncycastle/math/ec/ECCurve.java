package org.bouncycastle.math.ec;

import com.tencent.ugc.datereport.UGCDataReportDef;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.math.Primes;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.endo.ECEndomorphism;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.FiniteFields;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Properties;

public abstract class ECCurve {
    public static final int COORD_AFFINE = 0;
    public static final int COORD_HOMOGENEOUS = 1;
    public static final int COORD_JACOBIAN = 2;
    public static final int COORD_JACOBIAN_CHUDNOVSKY = 3;
    public static final int COORD_JACOBIAN_MODIFIED = 4;
    public static final int COORD_LAMBDA_AFFINE = 5;
    public static final int COORD_LAMBDA_PROJECTIVE = 6;
    public static final int COORD_SKEWED = 7;

    /* renamed from: a  reason: collision with root package name */
    public ECFieldElement f59387a;

    /* renamed from: b  reason: collision with root package name */
    public ECFieldElement f59388b;
    public BigInteger cofactor;
    public int coord = 0;
    public ECEndomorphism endomorphism = null;
    public FiniteField field;
    public ECMultiplier multiplier = null;
    public BigInteger order;

    public static abstract class AbstractF2m extends ECCurve {

        /* renamed from: si  reason: collision with root package name */
        private BigInteger[] f59389si = null;

        public AbstractF2m(int i11, int i12, int i13, int i14) {
            super(buildField(i11, i12, i13, i14));
        }

        private static FiniteField buildField(int i11, int i12, int i13, int i14) {
            if (i12 == 0) {
                throw new IllegalArgumentException("k1 must be > 0");
            } else if (i13 == 0) {
                if (i14 == 0) {
                    return FiniteFields.getBinaryExtensionField(new int[]{0, i12, i11});
                }
                throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
            } else if (i13 <= i12) {
                throw new IllegalArgumentException("k2 must be > k1");
            } else if (i14 > i13) {
                return FiniteFields.getBinaryExtensionField(new int[]{0, i12, i13, i14, i11});
            } else {
                throw new IllegalArgumentException("k3 must be > k2");
            }
        }

        private static BigInteger implRandomFieldElementMult(SecureRandom secureRandom, int i11) {
            BigInteger createRandomBigInteger;
            do {
                createRandomBigInteger = BigIntegers.createRandomBigInteger(i11, secureRandom);
            } while (createRandomBigInteger.signum() <= 0);
            return createRandomBigInteger;
        }

        public static BigInteger inverse(int i11, int[] iArr, BigInteger bigInteger) {
            return new LongArray(bigInteger).modInverse(i11, iArr).toBigInteger();
        }

        public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2) {
            ECFieldElement fromBigInteger = fromBigInteger(bigInteger);
            ECFieldElement fromBigInteger2 = fromBigInteger(bigInteger2);
            int coordinateSystem = getCoordinateSystem();
            if (coordinateSystem == 5 || coordinateSystem == 6) {
                if (!fromBigInteger.isZero()) {
                    fromBigInteger2 = fromBigInteger2.divide(fromBigInteger).add(fromBigInteger);
                } else if (!fromBigInteger2.square().equals(getB())) {
                    throw new IllegalArgumentException();
                }
            }
            return createRawPoint(fromBigInteger, fromBigInteger2);
        }

        public ECPoint decompressPoint(int i11, BigInteger bigInteger) {
            ECFieldElement eCFieldElement;
            ECFieldElement fromBigInteger = fromBigInteger(bigInteger);
            if (fromBigInteger.isZero()) {
                eCFieldElement = getB().sqrt();
            } else {
                ECFieldElement solveQuadraticEquation = solveQuadraticEquation(fromBigInteger.square().invert().multiply(getB()).add(getA()).add(fromBigInteger));
                if (solveQuadraticEquation != null) {
                    boolean testBitZero = solveQuadraticEquation.testBitZero();
                    boolean z11 = true;
                    if (i11 != 1) {
                        z11 = false;
                    }
                    if (testBitZero != z11) {
                        solveQuadraticEquation = solveQuadraticEquation.addOne();
                    }
                    int coordinateSystem = getCoordinateSystem();
                    eCFieldElement = (coordinateSystem == 5 || coordinateSystem == 6) ? solveQuadraticEquation.add(fromBigInteger) : solveQuadraticEquation.multiply(fromBigInteger);
                } else {
                    eCFieldElement = null;
                }
            }
            if (eCFieldElement != null) {
                return createRawPoint(fromBigInteger, eCFieldElement);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }

        public synchronized BigInteger[] getSi() {
            if (this.f59389si == null) {
                this.f59389si = Tnaf.getSi(this);
            }
            return this.f59389si;
        }

        public boolean isKoblitz() {
            return this.order != null && this.cofactor != null && this.f59388b.isOne() && (this.f59387a.isZero() || this.f59387a.isOne());
        }

        public boolean isValidFieldElement(BigInteger bigInteger) {
            return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= getFieldSize();
        }

        public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
            return fromBigInteger(BigIntegers.createRandomBigInteger(getFieldSize(), secureRandom));
        }

        public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
            int fieldSize = getFieldSize();
            return fromBigInteger(implRandomFieldElementMult(secureRandom, fieldSize)).multiply(fromBigInteger(implRandomFieldElementMult(secureRandom, fieldSize)));
        }

        public ECFieldElement solveQuadraticEquation(ECFieldElement eCFieldElement) {
            ECFieldElement eCFieldElement2;
            ECFieldElement.AbstractF2m abstractF2m = (ECFieldElement.AbstractF2m) eCFieldElement;
            boolean hasFastTrace = abstractF2m.hasFastTrace();
            if (hasFastTrace && abstractF2m.trace() != 0) {
                return null;
            }
            int fieldSize = getFieldSize();
            if ((fieldSize & 1) != 0) {
                ECFieldElement halfTrace = abstractF2m.halfTrace();
                if (hasFastTrace || halfTrace.square().add(halfTrace).add(eCFieldElement).isZero()) {
                    return halfTrace;
                }
                return null;
            } else if (eCFieldElement.isZero()) {
                return eCFieldElement;
            } else {
                ECFieldElement fromBigInteger = fromBigInteger(ECConstants.ZERO);
                Random random = new Random();
                do {
                    ECFieldElement fromBigInteger2 = fromBigInteger(new BigInteger(fieldSize, random));
                    ECFieldElement eCFieldElement3 = eCFieldElement;
                    eCFieldElement2 = fromBigInteger;
                    for (int i11 = 1; i11 < fieldSize; i11++) {
                        ECFieldElement square = eCFieldElement3.square();
                        eCFieldElement2 = eCFieldElement2.square().add(square.multiply(fromBigInteger2));
                        eCFieldElement3 = square.add(eCFieldElement);
                    }
                    if (!eCFieldElement3.isZero()) {
                        return null;
                    }
                } while (eCFieldElement2.square().add(eCFieldElement2).isZero());
                return eCFieldElement2;
            }
        }
    }

    public static abstract class AbstractFp extends ECCurve {
        public AbstractFp(BigInteger bigInteger) {
            super(FiniteFields.getPrimeField(bigInteger));
        }

        private static BigInteger implRandomFieldElement(SecureRandom secureRandom, BigInteger bigInteger) {
            BigInteger createRandomBigInteger;
            do {
                createRandomBigInteger = BigIntegers.createRandomBigInteger(bigInteger.bitLength(), secureRandom);
            } while (createRandomBigInteger.compareTo(bigInteger) >= 0);
            return createRandomBigInteger;
        }

        private static BigInteger implRandomFieldElementMult(SecureRandom secureRandom, BigInteger bigInteger) {
            while (true) {
                BigInteger createRandomBigInteger = BigIntegers.createRandomBigInteger(bigInteger.bitLength(), secureRandom);
                if (createRandomBigInteger.signum() > 0 && createRandomBigInteger.compareTo(bigInteger) < 0) {
                    return createRandomBigInteger;
                }
            }
        }

        public ECPoint decompressPoint(int i11, BigInteger bigInteger) {
            ECFieldElement fromBigInteger = fromBigInteger(bigInteger);
            ECFieldElement sqrt = fromBigInteger.square().add(this.f59387a).multiply(fromBigInteger).add(this.f59388b).sqrt();
            if (sqrt != null) {
                boolean testBitZero = sqrt.testBitZero();
                boolean z11 = true;
                if (i11 != 1) {
                    z11 = false;
                }
                if (testBitZero != z11) {
                    sqrt = sqrt.negate();
                }
                return createRawPoint(fromBigInteger, sqrt);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }

        public boolean isValidFieldElement(BigInteger bigInteger) {
            return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(getField().getCharacteristic()) < 0;
        }

        public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
            BigInteger characteristic = getField().getCharacteristic();
            return fromBigInteger(implRandomFieldElement(secureRandom, characteristic)).multiply(fromBigInteger(implRandomFieldElement(secureRandom, characteristic)));
        }

        public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
            BigInteger characteristic = getField().getCharacteristic();
            return fromBigInteger(implRandomFieldElementMult(secureRandom, characteristic)).multiply(fromBigInteger(implRandomFieldElementMult(secureRandom, characteristic)));
        }
    }

    public class Config {
        public int coord;
        public ECEndomorphism endomorphism;
        public ECMultiplier multiplier;

        public Config(int i11, ECEndomorphism eCEndomorphism, ECMultiplier eCMultiplier) {
            this.coord = i11;
            this.endomorphism = eCEndomorphism;
            this.multiplier = eCMultiplier;
        }

        public ECCurve create() {
            if (ECCurve.this.supportsCoordinateSystem(this.coord)) {
                ECCurve cloneCurve = ECCurve.this.cloneCurve();
                if (cloneCurve != ECCurve.this) {
                    synchronized (cloneCurve) {
                        cloneCurve.coord = this.coord;
                        cloneCurve.endomorphism = this.endomorphism;
                        cloneCurve.multiplier = this.multiplier;
                    }
                    return cloneCurve;
                }
                throw new IllegalStateException("implementation returned current curve");
            }
            throw new IllegalStateException("unsupported coordinate system");
        }

        public Config setCoordinateSystem(int i11) {
            this.coord = i11;
            return this;
        }

        public Config setEndomorphism(ECEndomorphism eCEndomorphism) {
            this.endomorphism = eCEndomorphism;
            return this;
        }

        public Config setMultiplier(ECMultiplier eCMultiplier) {
            this.multiplier = eCMultiplier;
            return this;
        }
    }

    public static class F2m extends AbstractF2m {
        private static final int F2M_DEFAULT_COORDS = 6;
        private ECPoint.F2m infinity;

        /* renamed from: k1  reason: collision with root package name */
        private int f59390k1;

        /* renamed from: k2  reason: collision with root package name */
        private int f59391k2;

        /* renamed from: k3  reason: collision with root package name */
        private int f59392k3;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public int f59393m;

        public F2m(int i11, int i12, int i13, int i14, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i11, i12, i13, i14, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public F2m(int i11, int i12, int i13, int i14, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(i11, i12, i13, i14);
            this.f59393m = i11;
            this.f59390k1 = i12;
            this.f59391k2 = i13;
            this.f59392k3 = i14;
            this.order = bigInteger3;
            this.cofactor = bigInteger4;
            this.infinity = new ECPoint.F2m(this, (ECFieldElement) null, (ECFieldElement) null);
            this.f59387a = fromBigInteger(bigInteger);
            this.f59388b = fromBigInteger(bigInteger2);
            this.coord = 6;
        }

        public F2m(int i11, int i12, int i13, int i14, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, BigInteger bigInteger, BigInteger bigInteger2) {
            super(i11, i12, i13, i14);
            this.f59393m = i11;
            this.f59390k1 = i12;
            this.f59391k2 = i13;
            this.f59392k3 = i14;
            this.order = bigInteger;
            this.cofactor = bigInteger2;
            this.infinity = new ECPoint.F2m(this, (ECFieldElement) null, (ECFieldElement) null);
            this.f59387a = eCFieldElement;
            this.f59388b = eCFieldElement2;
            this.coord = 6;
        }

        public F2m(int i11, int i12, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i11, i12, 0, 0, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public F2m(int i11, int i12, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i11, i12, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        public ECCurve cloneCurve() {
            return new F2m(this.f59393m, this.f59390k1, this.f59391k2, this.f59392k3, this.f59387a, this.f59388b, this.order, this.cofactor);
        }

        public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i11, int i12) {
            final int i13 = (this.f59393m + 63) >>> 6;
            final int[] iArr = isTrinomial() ? new int[]{this.f59390k1} : new int[]{this.f59390k1, this.f59391k2, this.f59392k3};
            final long[] jArr = new long[(i12 * i13 * 2)];
            int i14 = 0;
            for (int i15 = 0; i15 < i12; i15++) {
                ECPoint eCPoint = eCPointArr[i11 + i15];
                ((ECFieldElement.F2m) eCPoint.getRawXCoord()).f59398x.copyTo(jArr, i14);
                int i16 = i14 + i13;
                ((ECFieldElement.F2m) eCPoint.getRawYCoord()).f59398x.copyTo(jArr, i16);
                i14 = i16 + i13;
            }
            final int i17 = i12;
            return new AbstractECLookupTable() {
                private ECPoint createPoint(long[] jArr, long[] jArr2) {
                    return F2m.this.createRawPoint(new ECFieldElement.F2m(F2m.this.f59393m, iArr, new LongArray(jArr)), new ECFieldElement.F2m(F2m.this.f59393m, iArr, new LongArray(jArr2)));
                }

                public int getSize() {
                    return i17;
                }

                public ECPoint lookup(int i11) {
                    int i12;
                    long[] create64 = Nat.create64(i13);
                    long[] create642 = Nat.create64(i13);
                    int i13 = 0;
                    for (int i14 = 0; i14 < i17; i14++) {
                        long j11 = (long) (((i14 ^ i11) - 1) >> 31);
                        int i15 = 0;
                        while (true) {
                            i12 = i13;
                            if (i15 >= i12) {
                                break;
                            }
                            long j12 = create64[i15];
                            long[] jArr = jArr;
                            create64[i15] = j12 ^ (jArr[i13 + i15] & j11);
                            create642[i15] = create642[i15] ^ (jArr[(i12 + i13) + i15] & j11);
                            i15++;
                        }
                        i13 += i12 * 2;
                    }
                    return createPoint(create64, create642);
                }

                public ECPoint lookupVar(int i11) {
                    long[] create64 = Nat.create64(i13);
                    long[] create642 = Nat.create64(i13);
                    int i12 = i11 * i13 * 2;
                    int i13 = 0;
                    while (true) {
                        int i14 = i13;
                        if (i13 >= i14) {
                            return createPoint(create64, create642);
                        }
                        long[] jArr = jArr;
                        create64[i13] = jArr[i12 + i13];
                        create642[i13] = jArr[i14 + i12 + i13];
                        i13++;
                    }
                }
            };
        }

        public ECMultiplier createDefaultMultiplier() {
            return isKoblitz() ? new WTauNafMultiplier() : ECCurve.super.createDefaultMultiplier();
        }

        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            return new ECPoint.F2m(this, eCFieldElement, eCFieldElement2);
        }

        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            return new ECPoint.F2m(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.F2m(this.f59393m, this.f59390k1, this.f59391k2, this.f59392k3, bigInteger);
        }

        public int getFieldSize() {
            return this.f59393m;
        }

        public ECPoint getInfinity() {
            return this.infinity;
        }

        public int getK1() {
            return this.f59390k1;
        }

        public int getK2() {
            return this.f59391k2;
        }

        public int getK3() {
            return this.f59392k3;
        }

        public int getM() {
            return this.f59393m;
        }

        public boolean isTrinomial() {
            return this.f59391k2 == 0 && this.f59392k3 == 0;
        }

        public boolean supportsCoordinateSystem(int i11) {
            return i11 == 0 || i11 == 1 || i11 == 6;
        }
    }

    public static class Fp extends AbstractFp {
        private static final int FP_DEFAULT_COORDS = 4;
        private static final Set<BigInteger> knownQs = Collections.synchronizedSet(new HashSet());
        private static final BigIntegers.Cache validatedQs = new BigIntegers.Cache();
        public ECPoint.Fp infinity;

        /* renamed from: q  reason: collision with root package name */
        public BigInteger f59394q;

        /* renamed from: r  reason: collision with root package name */
        public BigInteger f59395r;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this(bigInteger, bigInteger2, bigInteger3, (BigInteger) null, (BigInteger) null);
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
            this(bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, false);
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, boolean z11) {
            super(bigInteger);
            if (z11) {
                this.f59394q = bigInteger;
                knownQs.add(bigInteger);
            } else {
                if (!knownQs.contains(bigInteger)) {
                    BigIntegers.Cache cache = validatedQs;
                    if (!cache.contains(bigInteger)) {
                        int asInteger = Properties.asInteger("org.bouncycastle.ec.fp_max_size", UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RATIO_3_4);
                        int asInteger2 = Properties.asInteger("org.bouncycastle.ec.fp_certainty", 100);
                        int bitLength = bigInteger.bitLength();
                        if (asInteger < bitLength) {
                            throw new IllegalArgumentException("Fp q value out of range");
                        } else if (Primes.hasAnySmallFactors(bigInteger) || !Primes.isMRProbablePrime(bigInteger, CryptoServicesRegistrar.getSecureRandom(), ECCurve.getNumberOfIterations(bitLength, asInteger2))) {
                            throw new IllegalArgumentException("Fp q value not prime");
                        } else {
                            cache.add(bigInteger);
                        }
                    }
                }
                this.f59394q = bigInteger;
            }
            this.f59395r = ECFieldElement.Fp.calculateResidue(bigInteger);
            this.infinity = new ECPoint.Fp(this, (ECFieldElement) null, (ECFieldElement) null);
            this.f59387a = fromBigInteger(bigInteger2);
            this.f59388b = fromBigInteger(bigInteger3);
            this.order = bigInteger4;
            this.cofactor = bigInteger5;
            this.coord = 4;
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(bigInteger);
            this.f59394q = bigInteger;
            this.f59395r = bigInteger2;
            this.infinity = new ECPoint.Fp(this, (ECFieldElement) null, (ECFieldElement) null);
            this.f59387a = eCFieldElement;
            this.f59388b = eCFieldElement2;
            this.order = bigInteger3;
            this.cofactor = bigInteger4;
            this.coord = 4;
        }

        public ECCurve cloneCurve() {
            return new Fp(this.f59394q, this.f59395r, this.f59387a, this.f59388b, this.order, this.cofactor);
        }

        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            return new ECPoint.Fp(this, eCFieldElement, eCFieldElement2);
        }

        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            return new ECPoint.Fp(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.Fp(this.f59394q, this.f59395r, bigInteger);
        }

        public int getFieldSize() {
            return this.f59394q.bitLength();
        }

        public ECPoint getInfinity() {
            return this.infinity;
        }

        public BigInteger getQ() {
            return this.f59394q;
        }

        public ECPoint importPoint(ECPoint eCPoint) {
            int coordinateSystem;
            if (this == eCPoint.getCurve() || getCoordinateSystem() != 2 || eCPoint.isInfinity() || ((coordinateSystem = eCPoint.getCurve().getCoordinateSystem()) != 2 && coordinateSystem != 3 && coordinateSystem != 4)) {
                return ECCurve.super.importPoint(eCPoint);
            }
            return new ECPoint.Fp(this, fromBigInteger(eCPoint.f59402x.toBigInteger()), fromBigInteger(eCPoint.f59403y.toBigInteger()), new ECFieldElement[]{fromBigInteger(eCPoint.f59404zs[0].toBigInteger())});
        }

        public boolean supportsCoordinateSystem(int i11) {
            return i11 == 0 || i11 == 1 || i11 == 2 || i11 == 4;
        }
    }

    public ECCurve(FiniteField finiteField) {
        this.field = finiteField;
    }

    public static int[] getAllCoordinateSystems() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    /* access modifiers changed from: private */
    public static int getNumberOfIterations(int i11, int i12) {
        if (i11 >= 1536) {
            if (i12 <= 100) {
                return 3;
            }
            if (i12 <= 128) {
                return 4;
            }
            return 4 + (((i12 - 128) + 1) / 2);
        } else if (i11 >= 1024) {
            if (i12 <= 100) {
                return 4;
            }
            if (i12 <= 112) {
                return 5;
            }
            return (((i12 - 112) + 1) / 2) + 5;
        } else if (i11 >= 512) {
            if (i12 <= 80) {
                return 5;
            }
            if (i12 <= 100) {
                return 7;
            }
            return (((i12 - 100) + 1) / 2) + 7;
        } else if (i12 <= 80) {
            return 40;
        } else {
            return 40 + (((i12 - 80) + 1) / 2);
        }
    }

    public void checkPoint(ECPoint eCPoint) {
        if (eCPoint == null || this != eCPoint.getCurve()) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
    }

    public void checkPoints(ECPoint[] eCPointArr) {
        checkPoints(eCPointArr, 0, eCPointArr.length);
    }

    public void checkPoints(ECPoint[] eCPointArr, int i11, int i12) {
        if (eCPointArr == null) {
            throw new IllegalArgumentException("'points' cannot be null");
        } else if (i11 < 0 || i12 < 0 || i11 > eCPointArr.length - i12) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        } else {
            int i13 = 0;
            while (i13 < i12) {
                ECPoint eCPoint = eCPointArr[i11 + i13];
                if (eCPoint == null || this == eCPoint.getCurve()) {
                    i13++;
                } else {
                    throw new IllegalArgumentException("'points' entries must be null or on this curve");
                }
            }
        }
    }

    public abstract ECCurve cloneCurve();

    public synchronized Config configure() {
        return new Config(this.coord, this.endomorphism, this.multiplier);
    }

    public ECLookupTable createCacheSafeLookupTable(ECPoint[] eCPointArr, int i11, final int i12) {
        final int fieldSize = (getFieldSize() + 7) >>> 3;
        final byte[] bArr = new byte[(i12 * fieldSize * 2)];
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            ECPoint eCPoint = eCPointArr[i11 + i14];
            byte[] byteArray = eCPoint.getRawXCoord().toBigInteger().toByteArray();
            byte[] byteArray2 = eCPoint.getRawYCoord().toBigInteger().toByteArray();
            int i15 = 1;
            int i16 = byteArray.length > fieldSize ? 1 : 0;
            int length = byteArray.length - i16;
            if (byteArray2.length <= fieldSize) {
                i15 = 0;
            }
            int length2 = byteArray2.length - i15;
            int i17 = i13 + fieldSize;
            System.arraycopy(byteArray, i16, bArr, i17 - length, length);
            i13 = i17 + fieldSize;
            System.arraycopy(byteArray2, i15, bArr, i13 - length2, length2);
        }
        return new AbstractECLookupTable() {
            private ECPoint createPoint(byte[] bArr, byte[] bArr2) {
                ECCurve eCCurve = ECCurve.this;
                return eCCurve.createRawPoint(eCCurve.fromBigInteger(new BigInteger(1, bArr)), ECCurve.this.fromBigInteger(new BigInteger(1, bArr2)));
            }

            public int getSize() {
                return i12;
            }

            public ECPoint lookup(int i11) {
                int i12;
                int i13 = fieldSize;
                byte[] bArr = new byte[i13];
                byte[] bArr2 = new byte[i13];
                int i14 = 0;
                for (int i15 = 0; i15 < i12; i15++) {
                    int i16 = ((i15 ^ i11) - 1) >> 31;
                    int i17 = 0;
                    while (true) {
                        i12 = fieldSize;
                        if (i17 >= i12) {
                            break;
                        }
                        byte b11 = bArr[i17];
                        byte[] bArr3 = bArr;
                        bArr[i17] = (byte) (b11 ^ (bArr3[i14 + i17] & i16));
                        bArr2[i17] = (byte) ((bArr3[(i12 + i14) + i17] & i16) ^ bArr2[i17]);
                        i17++;
                    }
                    i14 += i12 * 2;
                }
                return createPoint(bArr, bArr2);
            }

            public ECPoint lookupVar(int i11) {
                int i12 = fieldSize;
                byte[] bArr = new byte[i12];
                byte[] bArr2 = new byte[i12];
                int i13 = i11 * i12 * 2;
                int i14 = 0;
                while (true) {
                    int i15 = fieldSize;
                    if (i14 >= i15) {
                        return createPoint(bArr, bArr2);
                    }
                    byte[] bArr3 = bArr;
                    bArr[i14] = bArr3[i13 + i14];
                    bArr2[i14] = bArr3[i15 + i13 + i14];
                    i14++;
                }
            }
        };
    }

    public ECMultiplier createDefaultMultiplier() {
        ECEndomorphism eCEndomorphism = this.endomorphism;
        return eCEndomorphism instanceof GLVEndomorphism ? new GLVMultiplier(this, (GLVEndomorphism) eCEndomorphism) : new WNafL2RMultiplier();
    }

    public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2) {
        return createRawPoint(fromBigInteger(bigInteger), fromBigInteger(bigInteger2));
    }

    public abstract ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2);

    public abstract ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr);

    public ECPoint decodePoint(byte[] bArr) {
        ECPoint eCPoint;
        int fieldSize = (getFieldSize() + 7) / 8;
        boolean z11 = false;
        byte b11 = bArr[0];
        if (b11 != 0) {
            if (b11 == 2 || b11 == 3) {
                if (bArr.length == fieldSize + 1) {
                    eCPoint = decompressPoint(b11 & 1, BigIntegers.fromUnsignedByteArray(bArr, 1, fieldSize));
                    if (!eCPoint.implIsValid(true, true)) {
                        throw new IllegalArgumentException("Invalid point");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
            } else if (b11 != 4) {
                if (b11 != 6 && b11 != 7) {
                    throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(b11, 16));
                } else if (bArr.length == (fieldSize * 2) + 1) {
                    BigInteger fromUnsignedByteArray = BigIntegers.fromUnsignedByteArray(bArr, 1, fieldSize);
                    BigInteger fromUnsignedByteArray2 = BigIntegers.fromUnsignedByteArray(bArr, fieldSize + 1, fieldSize);
                    boolean testBit = fromUnsignedByteArray2.testBit(0);
                    if (b11 == 7) {
                        z11 = true;
                    }
                    if (testBit == z11) {
                        eCPoint = validatePoint(fromUnsignedByteArray, fromUnsignedByteArray2);
                    } else {
                        throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                    }
                } else {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
            } else if (bArr.length == (fieldSize * 2) + 1) {
                eCPoint = validatePoint(BigIntegers.fromUnsignedByteArray(bArr, 1, fieldSize), BigIntegers.fromUnsignedByteArray(bArr, fieldSize + 1, fieldSize));
            } else {
                throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
            }
        } else if (bArr.length == 1) {
            eCPoint = getInfinity();
        } else {
            throw new IllegalArgumentException("Incorrect length for infinity encoding");
        }
        if (b11 == 0 || !eCPoint.isInfinity()) {
            return eCPoint;
        }
        throw new IllegalArgumentException("Invalid infinity encoding");
    }

    public abstract ECPoint decompressPoint(int i11, BigInteger bigInteger);

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ECCurve) && equals((ECCurve) obj));
    }

    public boolean equals(ECCurve eCCurve) {
        return this == eCCurve || (eCCurve != null && getField().equals(eCCurve.getField()) && getA().toBigInteger().equals(eCCurve.getA().toBigInteger()) && getB().toBigInteger().equals(eCCurve.getB().toBigInteger()));
    }

    public abstract ECFieldElement fromBigInteger(BigInteger bigInteger);

    public ECFieldElement getA() {
        return this.f59387a;
    }

    public ECFieldElement getB() {
        return this.f59388b;
    }

    public BigInteger getCofactor() {
        return this.cofactor;
    }

    public int getCoordinateSystem() {
        return this.coord;
    }

    public ECEndomorphism getEndomorphism() {
        return this.endomorphism;
    }

    public FiniteField getField() {
        return this.field;
    }

    public abstract int getFieldSize();

    public abstract ECPoint getInfinity();

    public ECMultiplier getMultiplier() {
        if (this.multiplier == null) {
            this.multiplier = createDefaultMultiplier();
        }
        return this.multiplier;
    }

    public BigInteger getOrder() {
        return this.order;
    }

    public PreCompInfo getPreCompInfo(ECPoint eCPoint, String str) {
        Hashtable hashtable;
        PreCompInfo preCompInfo;
        checkPoint(eCPoint);
        synchronized (eCPoint) {
            hashtable = eCPoint.preCompTable;
        }
        if (hashtable == null) {
            return null;
        }
        synchronized (hashtable) {
            preCompInfo = (PreCompInfo) hashtable.get(str);
        }
        return preCompInfo;
    }

    public int hashCode() {
        return (getField().hashCode() ^ Integers.rotateLeft(getA().toBigInteger().hashCode(), 8)) ^ Integers.rotateLeft(getB().toBigInteger().hashCode(), 16);
    }

    public ECPoint importPoint(ECPoint eCPoint) {
        if (this == eCPoint.getCurve()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return getInfinity();
        }
        ECPoint normalize = eCPoint.normalize();
        return createPoint(normalize.getXCoord().toBigInteger(), normalize.getYCoord().toBigInteger());
    }

    public abstract boolean isValidFieldElement(BigInteger bigInteger);

    public void normalizeAll(ECPoint[] eCPointArr) {
        normalizeAll(eCPointArr, 0, eCPointArr.length, (ECFieldElement) null);
    }

    public void normalizeAll(ECPoint[] eCPointArr, int i11, int i12, ECFieldElement eCFieldElement) {
        checkPoints(eCPointArr, i11, i12);
        int coordinateSystem = getCoordinateSystem();
        if (coordinateSystem != 0 && coordinateSystem != 5) {
            ECFieldElement[] eCFieldElementArr = new ECFieldElement[i12];
            int[] iArr = new int[i12];
            int i13 = 0;
            for (int i14 = 0; i14 < i12; i14++) {
                int i15 = i11 + i14;
                ECPoint eCPoint = eCPointArr[i15];
                if (eCPoint != null && (eCFieldElement != null || !eCPoint.isNormalized())) {
                    eCFieldElementArr[i13] = eCPoint.getZCoord(0);
                    iArr[i13] = i15;
                    i13++;
                }
            }
            if (i13 != 0) {
                ECAlgorithms.montgomeryTrick(eCFieldElementArr, 0, i13, eCFieldElement);
                for (int i16 = 0; i16 < i13; i16++) {
                    int i17 = iArr[i16];
                    eCPointArr[i17] = eCPointArr[i17].normalize(eCFieldElementArr[i16]);
                }
            }
        } else if (eCFieldElement != null) {
            throw new IllegalArgumentException("'iso' not valid for affine coordinates");
        }
    }

    public PreCompInfo precompute(ECPoint eCPoint, String str, PreCompCallback preCompCallback) {
        Hashtable hashtable;
        PreCompInfo precompute;
        checkPoint(eCPoint);
        synchronized (eCPoint) {
            hashtable = eCPoint.preCompTable;
            if (hashtable == null) {
                hashtable = new Hashtable(4);
                eCPoint.preCompTable = hashtable;
            }
        }
        synchronized (hashtable) {
            PreCompInfo preCompInfo = (PreCompInfo) hashtable.get(str);
            precompute = preCompCallback.precompute(preCompInfo);
            if (precompute != preCompInfo) {
                hashtable.put(str, precompute);
            }
        }
        return precompute;
    }

    public abstract ECFieldElement randomFieldElement(SecureRandom secureRandom);

    public abstract ECFieldElement randomFieldElementMult(SecureRandom secureRandom);

    public boolean supportsCoordinateSystem(int i11) {
        return i11 == 0;
    }

    public ECPoint validatePoint(BigInteger bigInteger, BigInteger bigInteger2) {
        ECPoint createPoint = createPoint(bigInteger, bigInteger2);
        if (createPoint.isValid()) {
            return createPoint;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }
}
