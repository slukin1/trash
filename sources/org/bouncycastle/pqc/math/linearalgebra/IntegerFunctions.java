package org.bouncycastle.pqc.math.linearalgebra;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.BigIntegers;

public final class IntegerFunctions {
    private static final BigInteger FOUR = BigInteger.valueOf(4);
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final int[] SMALL_PRIMES = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};
    private static final long SMALL_PRIME_PRODUCT = 152125131763605L;
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private static final int[] jacobiTable = {0, 1, 0, -1, 0, -1, 0, 1};

    /* renamed from: sr  reason: collision with root package name */
    private static SecureRandom f59636sr = null;

    private IntegerFunctions() {
    }

    public static BigInteger binomial(int i11, int i12) {
        BigInteger bigInteger = ONE;
        if (i11 == 0) {
            return i12 == 0 ? bigInteger : ZERO;
        }
        if (i12 > (i11 >>> 1)) {
            i12 = i11 - i12;
        }
        for (int i13 = 1; i13 <= i12; i13++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf((long) (i11 - (i13 - 1)))).divide(BigInteger.valueOf((long) i13));
        }
        return bigInteger;
    }

    public static int bitCount(int i11) {
        int i12 = 0;
        while (i11 != 0) {
            i12 += i11 & 1;
            i11 >>>= 1;
        }
        return i12;
    }

    public static int ceilLog(int i11) {
        int i12 = 1;
        int i13 = 0;
        while (i12 < i11) {
            i12 <<= 1;
            i13++;
        }
        return i13;
    }

    public static int ceilLog(BigInteger bigInteger) {
        int i11 = 0;
        for (BigInteger bigInteger2 = ONE; bigInteger2.compareTo(bigInteger) < 0; bigInteger2 = bigInteger2.shiftLeft(1)) {
            i11++;
        }
        return i11;
    }

    public static int ceilLog256(int i11) {
        if (i11 == 0) {
            return 1;
        }
        if (i11 < 0) {
            i11 = -i11;
        }
        int i12 = 0;
        while (i11 > 0) {
            i12++;
            i11 >>>= 8;
        }
        return i12;
    }

    public static int ceilLog256(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 == 0) {
            return 1;
        }
        if (i11 < 0) {
            j11 = -j11;
        }
        int i12 = 0;
        while (j11 > 0) {
            i12++;
            j11 >>>= 8;
        }
        return i12;
    }

    public static BigInteger divideAndRound(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.signum() < 0 ? divideAndRound(bigInteger.negate(), bigInteger2).negate() : bigInteger2.signum() < 0 ? divideAndRound(bigInteger, bigInteger2.negate()).negate() : bigInteger.shiftLeft(1).add(bigInteger2).divide(bigInteger2.shiftLeft(1));
    }

    public static BigInteger[] divideAndRound(BigInteger[] bigIntegerArr, BigInteger bigInteger) {
        BigInteger[] bigIntegerArr2 = new BigInteger[bigIntegerArr.length];
        for (int i11 = 0; i11 < bigIntegerArr.length; i11++) {
            bigIntegerArr2[i11] = divideAndRound(bigIntegerArr[i11], bigInteger);
        }
        return bigIntegerArr2;
    }

    public static int[] extGCD(int i11, int i12) {
        BigInteger[] extgcd = extgcd(BigInteger.valueOf((long) i11), BigInteger.valueOf((long) i12));
        return new int[]{extgcd[0].intValue(), extgcd[1].intValue(), extgcd[2].intValue()};
    }

    public static BigInteger[] extgcd(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = ONE;
        BigInteger bigInteger4 = ZERO;
        if (bigInteger2.signum() != 0) {
            BigInteger bigInteger5 = bigInteger;
            BigInteger bigInteger6 = bigInteger2;
            while (bigInteger6.signum() != 0) {
                BigInteger[] divideAndRemainder = bigInteger5.divideAndRemainder(bigInteger6);
                BigInteger bigInteger7 = divideAndRemainder[0];
                BigInteger bigInteger8 = divideAndRemainder[1];
                BigInteger bigInteger9 = bigInteger4;
                bigInteger4 = bigInteger3.subtract(bigInteger7.multiply(bigInteger4));
                bigInteger3 = bigInteger9;
                BigInteger bigInteger10 = bigInteger8;
                bigInteger5 = bigInteger6;
                bigInteger6 = bigInteger10;
            }
            bigInteger4 = bigInteger5.subtract(bigInteger.multiply(bigInteger3)).divide(bigInteger2);
            bigInteger = bigInteger5;
        }
        return new BigInteger[]{bigInteger, bigInteger3, bigInteger4};
    }

    public static float floatPow(float f11, int i11) {
        float f12 = 1.0f;
        while (i11 > 0) {
            f12 *= f11;
            i11--;
        }
        return f12;
    }

    public static int floorLog(int i11) {
        if (i11 <= 0) {
            return -1;
        }
        int i12 = 0;
        for (int i13 = i11 >>> 1; i13 > 0; i13 >>>= 1) {
            i12++;
        }
        return i12;
    }

    public static int floorLog(BigInteger bigInteger) {
        int i11 = -1;
        for (BigInteger bigInteger2 = ONE; bigInteger2.compareTo(bigInteger) <= 0; bigInteger2 = bigInteger2.shiftLeft(1)) {
            i11++;
        }
        return i11;
    }

    public static int gcd(int i11, int i12) {
        return BigInteger.valueOf((long) i11).gcd(BigInteger.valueOf((long) i12)).intValue();
    }

    public static float intRoot(int i11, int i12) {
        float floatPow;
        float f11 = (float) (i11 / i12);
        float f12 = 0.0f;
        while (((double) Math.abs(f12 - f11)) > 1.0E-4d) {
            while (true) {
                floatPow = floatPow(f11, i12);
                if (!Float.isInfinite(floatPow)) {
                    break;
                }
                f11 = (f11 + f12) / 2.0f;
            }
            f12 = f11;
            f11 -= (floatPow - ((float) i11)) / (((float) i12) * floatPow(f11, i12 - 1));
        }
        return f11;
    }

    public static byte[] integerToOctets(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.abs().toByteArray();
        if ((bigInteger.bitLength() & 7) != 0) {
            return byteArray;
        }
        int bitLength = bigInteger.bitLength() >> 3;
        byte[] bArr = new byte[bitLength];
        System.arraycopy(byteArray, 1, bArr, 0, bitLength);
        return bArr;
    }

    public static boolean isIncreasing(int[] iArr) {
        for (int i11 = 1; i11 < iArr.length; i11++) {
            if (iArr[i11 - 1] >= iArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public static int isPower(int i11, int i12) {
        if (i11 <= 0) {
            return -1;
        }
        int i13 = 0;
        while (i11 > 1) {
            if (i11 % i12 != 0) {
                return -1;
            }
            i11 /= i12;
            i13++;
        }
        return i13;
    }

    public static boolean isPrime(int i11) {
        if (i11 < 2) {
            return false;
        }
        if (i11 == 2) {
            return true;
        }
        if ((i11 & 1) == 0) {
            return false;
        }
        if (i11 < 42) {
            int i12 = 0;
            while (true) {
                int[] iArr = SMALL_PRIMES;
                if (i12 >= iArr.length) {
                    break;
                } else if (i11 == iArr[i12]) {
                    return true;
                } else {
                    i12++;
                }
            }
        }
        if (i11 % 3 == 0 || i11 % 5 == 0 || i11 % 7 == 0 || i11 % 11 == 0 || i11 % 13 == 0 || i11 % 17 == 0 || i11 % 19 == 0 || i11 % 23 == 0 || i11 % 29 == 0 || i11 % 31 == 0 || i11 % 37 == 0 || i11 % 41 == 0) {
            return false;
        }
        return BigInteger.valueOf((long) i11).isProbablePrime(20);
    }

    public static int jacobi(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = ZERO;
        if (bigInteger2.equals(bigInteger3)) {
            return bigInteger.abs().equals(ONE) ? 1 : 0;
        }
        if (!bigInteger.testBit(0) && !bigInteger2.testBit(0)) {
            return 0;
        }
        long j11 = 1;
        if (bigInteger2.signum() == -1) {
            bigInteger2 = bigInteger2.negate();
            if (bigInteger.signum() == -1) {
                j11 = -1;
            }
        }
        while (!bigInteger2.testBit(0)) {
            bigInteger3 = bigInteger3.add(ONE);
            bigInteger2 = bigInteger2.divide(TWO);
        }
        if (bigInteger3.testBit(0)) {
            j11 *= (long) jacobiTable[bigInteger.intValue() & 7];
        }
        if (bigInteger.signum() < 0) {
            if (bigInteger2.testBit(1)) {
                j11 = -j11;
            }
            bigInteger = bigInteger.negate();
        }
        while (bigInteger.signum() != 0) {
            BigInteger bigInteger4 = ZERO;
            while (!bigInteger.testBit(0)) {
                bigInteger4 = bigInteger4.add(ONE);
                bigInteger = bigInteger.divide(TWO);
            }
            if (bigInteger4.testBit(0)) {
                j11 *= (long) jacobiTable[bigInteger2.intValue() & 7];
            }
            if (bigInteger.compareTo(bigInteger2) >= 0) {
                BigInteger bigInteger5 = bigInteger2;
                bigInteger2 = bigInteger;
                bigInteger = bigInteger5;
            } else if (bigInteger2.testBit(1) && bigInteger.testBit(1)) {
                j11 = -j11;
            }
            BigInteger subtract = bigInteger2.subtract(bigInteger);
            bigInteger2 = bigInteger;
            bigInteger = subtract;
        }
        if (bigInteger2.equals(ONE)) {
            return (int) j11;
        }
        return 0;
    }

    public static BigInteger leastCommonMultiple(BigInteger[] bigIntegerArr) {
        int length = bigIntegerArr.length;
        BigInteger bigInteger = bigIntegerArr[0];
        for (int i11 = 1; i11 < length; i11++) {
            bigInteger = bigInteger.multiply(bigIntegerArr[i11]).divide(bigInteger.gcd(bigIntegerArr[i11]));
        }
        return bigInteger;
    }

    public static int leastDiv(int i11) {
        if (i11 < 0) {
            i11 = -i11;
        }
        if (i11 == 0) {
            return 1;
        }
        if ((i11 & 1) == 0) {
            return 2;
        }
        for (int i12 = 3; i12 <= i11 / i12; i12 += 2) {
            if (i11 % i12 == 0) {
                return i12;
            }
        }
        return i11;
    }

    public static double log(double d11) {
        double d12 = 1.0d;
        if (d11 > 0.0d && d11 < 1.0d) {
            return -log(1.0d / d11);
        }
        int i11 = 0;
        double d13 = d11;
        while (d13 > 2.0d) {
            d13 /= 2.0d;
            i11++;
            d12 *= 2.0d;
        }
        return ((double) i11) + logBKM(d11 / d12);
    }

    public static double log(long j11) {
        int floorLog = floorLog(BigInteger.valueOf(j11));
        return ((double) floorLog) + logBKM(((double) j11) / ((double) ((long) (1 << floorLog))));
    }

    private static double logBKM(double d11) {
        double[] dArr = {1.0d, 0.5849625007211562d, 0.32192809488736235d, 0.16992500144231237d, 0.0874628412503394d, 0.044394119358453436d, 0.02236781302845451d, 0.01122725542325412d, 0.005624549193878107d, 0.0028150156070540383d, 0.0014081943928083889d, 7.042690112466433E-4d, 3.5217748030102726E-4d, 1.7609948644250602E-4d, 8.80524301221769E-5d, 4.4026886827316716E-5d, 2.2013611360340496E-5d, 1.1006847667481442E-5d, 5.503434330648604E-6d, 2.751719789561283E-6d, 1.375860550841138E-6d, 6.879304394358497E-7d, 3.4396526072176454E-7d, 1.7198264061184464E-7d, 8.599132286866321E-8d, 4.299566207501687E-8d, 2.1497831197679756E-8d, 1.0748915638882709E-8d, 5.374457829452062E-9d, 2.687228917228708E-9d, 1.3436144592400231E-9d, 6.718072297764289E-10d, 3.3590361492731876E-10d, 1.6795180747343547E-10d, 8.397590373916176E-11d, 4.1987951870191886E-11d, 2.0993975935248694E-11d, 1.0496987967662534E-11d, 5.2484939838408146E-12d, 2.624246991922794E-12d, 1.3121234959619935E-12d, 6.56061747981146E-13d, 3.2803087399061026E-13d, 1.6401543699531447E-13d, 8.200771849765956E-14d, 4.1003859248830365E-14d, 2.0501929624415328E-14d, 1.02509648122077E-14d, 5.1254824061038595E-15d, 2.5627412030519317E-15d, 1.2813706015259665E-15d, 6.406853007629834E-16d, 3.203426503814917E-16d, 1.6017132519074588E-16d, 8.008566259537294E-17d, 4.004283129768647E-17d, 2.0021415648843235E-17d, 1.0010707824421618E-17d, 5.005353912210809E-18d, 2.5026769561054044E-18d, 1.2513384780527022E-18d, 6.256692390263511E-19d, 3.1283461951317555E-19d, 1.5641730975658778E-19d, 7.820865487829389E-20d, 3.9104327439146944E-20d, 1.9552163719573472E-20d, 9.776081859786736E-21d, 4.888040929893368E-21d, 2.444020464946684E-21d, 1.222010232473342E-21d, 6.11005116236671E-22d, 3.055025581183355E-22d, 1.5275127905916775E-22d, 7.637563952958387E-23d, 3.818781976479194E-23d, 1.909390988239597E-23d, 9.546954941197984E-24d, 4.773477470598992E-24d, 2.386738735299496E-24d, 1.193369367649748E-24d, 5.96684683824874E-25d, 2.98342341912437E-25d, 1.491711709562185E-25d, 7.458558547810925E-26d, 3.7292792739054626E-26d, 1.8646396369527313E-26d, 9.323198184763657E-27d, 4.661599092381828E-27d, 2.330799546190914E-27d, 1.165399773095457E-27d, 5.826998865477285E-28d, 2.9134994327386427E-28d, 1.4567497163693213E-28d, 7.283748581846607E-29d, 3.6418742909233034E-29d, 1.8209371454616517E-29d, 9.104685727308258E-30d, 4.552342863654129E-30d, 2.2761714318270646E-30d};
        double d12 = 1.0d;
        double d13 = 0.0d;
        double d14 = 1.0d;
        for (int i11 = 0; i11 < 53; i11++) {
            double d15 = (d12 * d14) + d12;
            if (d15 <= d11) {
                d13 += dArr[i11];
                d12 = d15;
            }
            d14 *= 0.5d;
        }
        return d13;
    }

    public static int maxPower(int i11) {
        int i12 = 0;
        if (i11 != 0) {
            for (int i13 = 1; (i11 & i13) == 0; i13 <<= 1) {
                i12++;
            }
        }
        return i12;
    }

    public static long mod(long j11, long j12) {
        long j13 = j11 % j12;
        return j13 < 0 ? j13 + j12 : j13;
    }

    public static int modInverse(int i11, int i12) {
        return BigInteger.valueOf((long) i11).modInverse(BigInteger.valueOf((long) i12)).intValue();
    }

    public static long modInverse(long j11, long j12) {
        return BigInteger.valueOf(j11).modInverse(BigInteger.valueOf(j12)).longValue();
    }

    public static int modPow(int i11, int i12, int i13) {
        if (i13 <= 0 || i13 * i13 > Integer.MAX_VALUE || i12 < 0) {
            return 0;
        }
        int i14 = ((i11 % i13) + i13) % i13;
        int i15 = 1;
        while (i12 > 0) {
            if ((i12 & 1) == 1) {
                i15 = (i15 * i14) % i13;
            }
            i14 = (i14 * i14) % i13;
            i12 >>>= 1;
        }
        return i15;
    }

    public static BigInteger nextPrime(long j11) {
        if (j11 <= 1) {
            return BigInteger.valueOf(2);
        }
        if (j11 == 2) {
            return BigInteger.valueOf(3);
        }
        boolean z11 = false;
        long j12 = 0;
        for (long j13 = j11 + 1 + (j11 & 1); j13 <= (j11 << 1) && !z11; j13 += 2) {
            for (long j14 = 3; j14 <= (j13 >> 1) && !z11; j14 += 2) {
                if (j13 % j14 == 0) {
                    z11 = true;
                }
            }
            if (!z11) {
                j12 = j13;
            }
            z11 = !z11;
        }
        return BigInteger.valueOf(j12);
    }

    public static BigInteger nextProbablePrime(BigInteger bigInteger) {
        return nextProbablePrime(bigInteger, 20);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (r6.bitLength() <= 6) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        r0 = r6.remainder(java.math.BigInteger.valueOf(SMALL_PRIME_PRODUCT)).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        if ((r0 % 3) == 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        if ((r0 % 5) == 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        if ((r0 % 7) == 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005d, code lost:
        if ((r0 % 11) == 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        if ((r0 % 13) == 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006d, code lost:
        if ((r0 % 17) == 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0075, code lost:
        if ((r0 % 19) == 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        if ((r0 % 23) == 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
        if ((r0 % 29) == 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008d, code lost:
        if ((r0 % 31) == 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0095, code lost:
        if ((r0 % 37) == 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009c, code lost:
        if ((r0 % 41) != 0) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009e, code lost:
        r0 = TWO;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a6, code lost:
        if (r6.bitLength() >= 4) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a8, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ad, code lost:
        if (r6.isProbablePrime(r7) == false) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00af, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r6.testBit(0) == false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        r6 = r6.add(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.math.BigInteger nextProbablePrime(java.math.BigInteger r6, int r7) {
        /*
            int r0 = r6.signum()
            if (r0 < 0) goto L_0x00b0
            int r0 = r6.signum()
            if (r0 == 0) goto L_0x00b0
            java.math.BigInteger r0 = ONE
            boolean r1 = r6.equals(r0)
            if (r1 == 0) goto L_0x0016
            goto L_0x00b0
        L_0x0016:
            java.math.BigInteger r6 = r6.add(r0)
            r1 = 0
            boolean r1 = r6.testBit(r1)
            if (r1 != 0) goto L_0x0025
        L_0x0021:
            java.math.BigInteger r6 = r6.add(r0)
        L_0x0025:
            int r0 = r6.bitLength()
            r1 = 6
            if (r0 <= r1) goto L_0x00a1
            r0 = 152125131763605(0x8a5b6470af95, double:7.515980147347E-310)
            java.math.BigInteger r0 = java.math.BigInteger.valueOf(r0)
            java.math.BigInteger r0 = r6.remainder(r0)
            long r0 = r0.longValue()
            r2 = 3
            long r2 = r0 % r2
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x009e
            r2 = 5
            long r2 = r0 % r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x009e
            r2 = 7
            long r2 = r0 % r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x009e
            r2 = 11
            long r2 = r0 % r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x009e
            r2 = 13
            long r2 = r0 % r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x009e
            r2 = 17
            long r2 = r0 % r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x009e
            r2 = 19
            long r2 = r0 % r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x009e
            r2 = 23
            long r2 = r0 % r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x009e
            r2 = 29
            long r2 = r0 % r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x009e
            r2 = 31
            long r2 = r0 % r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x009e
            r2 = 37
            long r2 = r0 % r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x009e
            r2 = 41
            long r0 = r0 % r2
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x00a1
        L_0x009e:
            java.math.BigInteger r0 = TWO
            goto L_0x0021
        L_0x00a1:
            int r0 = r6.bitLength()
            r1 = 4
            if (r0 >= r1) goto L_0x00a9
            return r6
        L_0x00a9:
            boolean r0 = r6.isProbablePrime(r7)
            if (r0 == 0) goto L_0x009e
            return r6
        L_0x00b0:
            java.math.BigInteger r6 = TWO
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.math.linearalgebra.IntegerFunctions.nextProbablePrime(java.math.BigInteger, int):java.math.BigInteger");
    }

    public static int nextSmallerPrime(int i11) {
        if (i11 <= 2) {
            return 1;
        }
        if (i11 == 3) {
            return 2;
        }
        if ((i11 & 1) == 0) {
            i11--;
            if (i11 <= 3 || isPrime(i11)) {
                return i11;
            }
        }
        i11 -= 2;
        return i11;
    }

    public static BigInteger octetsToInteger(byte[] bArr) {
        return octetsToInteger(bArr, 0, bArr.length);
    }

    public static BigInteger octetsToInteger(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[(i12 + 1)];
        bArr2[0] = 0;
        System.arraycopy(bArr, i11, bArr2, 1, i12);
        return new BigInteger(bArr2);
    }

    public static int order(int i11, int i12) {
        int i13 = i11 % i12;
        if (i13 != 0) {
            int i14 = 1;
            while (i13 != 1) {
                i13 = (i13 * i11) % i12;
                if (i13 < 0) {
                    i13 += i12;
                }
                i14++;
            }
            return i14;
        }
        throw new IllegalArgumentException(i11 + " is not an element of Z/(" + i12 + "Z)^*; it is not meaningful to compute its order.");
    }

    public static boolean passesSmallPrimeTest(BigInteger bigInteger) {
        int[] iArr = new int[TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE];
        // fill-array-data instruction
        iArr[0] = 2;
        iArr[1] = 3;
        iArr[2] = 5;
        iArr[3] = 7;
        iArr[4] = 11;
        iArr[5] = 13;
        iArr[6] = 17;
        iArr[7] = 19;
        iArr[8] = 23;
        iArr[9] = 29;
        iArr[10] = 31;
        iArr[11] = 37;
        iArr[12] = 41;
        iArr[13] = 43;
        iArr[14] = 47;
        iArr[15] = 53;
        iArr[16] = 59;
        iArr[17] = 61;
        iArr[18] = 67;
        iArr[19] = 71;
        iArr[20] = 73;
        iArr[21] = 79;
        iArr[22] = 83;
        iArr[23] = 89;
        iArr[24] = 97;
        iArr[25] = 101;
        iArr[26] = 103;
        iArr[27] = 107;
        iArr[28] = 109;
        iArr[29] = 113;
        iArr[30] = 127;
        iArr[31] = 131;
        iArr[32] = 137;
        iArr[33] = 139;
        iArr[34] = 149;
        iArr[35] = 151;
        iArr[36] = 157;
        iArr[37] = 163;
        iArr[38] = 167;
        iArr[39] = 173;
        iArr[40] = 179;
        iArr[41] = 181;
        iArr[42] = 191;
        iArr[43] = 193;
        iArr[44] = 197;
        iArr[45] = 199;
        iArr[46] = 211;
        iArr[47] = 223;
        iArr[48] = 227;
        iArr[49] = 229;
        iArr[50] = 233;
        iArr[51] = 239;
        iArr[52] = 241;
        iArr[53] = 251;
        iArr[54] = 257;
        iArr[55] = 263;
        iArr[56] = 269;
        iArr[57] = 271;
        iArr[58] = 277;
        iArr[59] = 281;
        iArr[60] = 283;
        iArr[61] = 293;
        iArr[62] = 307;
        iArr[63] = 311;
        iArr[64] = 313;
        iArr[65] = 317;
        iArr[66] = 331;
        iArr[67] = 337;
        iArr[68] = 347;
        iArr[69] = 349;
        iArr[70] = 353;
        iArr[71] = 359;
        iArr[72] = 367;
        iArr[73] = 373;
        iArr[74] = 379;
        iArr[75] = 383;
        iArr[76] = 389;
        iArr[77] = 397;
        iArr[78] = 401;
        iArr[79] = 409;
        iArr[80] = 419;
        iArr[81] = 421;
        iArr[82] = 431;
        iArr[83] = 433;
        iArr[84] = 439;
        iArr[85] = 443;
        iArr[86] = 449;
        iArr[87] = 457;
        iArr[88] = 461;
        iArr[89] = 463;
        iArr[90] = 467;
        iArr[91] = 479;
        iArr[92] = 487;
        iArr[93] = 491;
        iArr[94] = 499;
        iArr[95] = 503;
        iArr[96] = 509;
        iArr[97] = 521;
        iArr[98] = 523;
        iArr[99] = 541;
        iArr[100] = 547;
        iArr[101] = 557;
        iArr[102] = 563;
        iArr[103] = 569;
        iArr[104] = 571;
        iArr[105] = 577;
        iArr[106] = 587;
        iArr[107] = 593;
        iArr[108] = 599;
        iArr[109] = 601;
        iArr[110] = 607;
        iArr[111] = 613;
        iArr[112] = 617;
        iArr[113] = 619;
        iArr[114] = 631;
        iArr[115] = 641;
        iArr[116] = 643;
        iArr[117] = 647;
        iArr[118] = 653;
        iArr[119] = 659;
        iArr[120] = 661;
        iArr[121] = 673;
        iArr[122] = 677;
        iArr[123] = 683;
        iArr[124] = 691;
        iArr[125] = 701;
        iArr[126] = 709;
        iArr[127] = 719;
        iArr[128] = 727;
        iArr[129] = 733;
        iArr[130] = 739;
        iArr[131] = 743;
        iArr[132] = 751;
        iArr[133] = 757;
        iArr[134] = 761;
        iArr[135] = 769;
        iArr[136] = 773;
        iArr[137] = 787;
        iArr[138] = 797;
        iArr[139] = 809;
        iArr[140] = 811;
        iArr[141] = 821;
        iArr[142] = 823;
        iArr[143] = 827;
        iArr[144] = 829;
        iArr[145] = 839;
        iArr[146] = 853;
        iArr[147] = 857;
        iArr[148] = 859;
        iArr[149] = 863;
        iArr[150] = 877;
        iArr[151] = 881;
        iArr[152] = 883;
        iArr[153] = 887;
        iArr[154] = 907;
        iArr[155] = 911;
        iArr[156] = 919;
        iArr[157] = 929;
        iArr[158] = 937;
        iArr[159] = 941;
        iArr[160] = 947;
        iArr[161] = 953;
        iArr[162] = 967;
        iArr[163] = 971;
        iArr[164] = 977;
        iArr[165] = 983;
        iArr[166] = 991;
        iArr[167] = 997;
        iArr[168] = 1009;
        iArr[169] = 1013;
        iArr[170] = 1019;
        iArr[171] = 1021;
        iArr[172] = 1031;
        iArr[173] = 1033;
        iArr[174] = 1039;
        iArr[175] = 1049;
        iArr[176] = 1051;
        iArr[177] = 1061;
        iArr[178] = 1063;
        iArr[179] = 1069;
        iArr[180] = 1087;
        iArr[181] = 1091;
        iArr[182] = 1093;
        iArr[183] = 1097;
        iArr[184] = 1103;
        iArr[185] = 1109;
        iArr[186] = 1117;
        iArr[187] = 1123;
        iArr[188] = 1129;
        iArr[189] = 1151;
        iArr[190] = 1153;
        iArr[191] = 1163;
        iArr[192] = 1171;
        iArr[193] = 1181;
        iArr[194] = 1187;
        iArr[195] = 1193;
        iArr[196] = 1201;
        iArr[197] = 1213;
        iArr[198] = 1217;
        iArr[199] = 1223;
        iArr[200] = 1229;
        iArr[201] = 1231;
        iArr[202] = 1237;
        iArr[203] = 1249;
        iArr[204] = 1259;
        iArr[205] = 1277;
        iArr[206] = 1279;
        iArr[207] = 1283;
        iArr[208] = 1289;
        iArr[209] = 1291;
        iArr[210] = 1297;
        iArr[211] = 1301;
        iArr[212] = 1303;
        iArr[213] = 1307;
        iArr[214] = 1319;
        iArr[215] = 1321;
        iArr[216] = 1327;
        iArr[217] = 1361;
        iArr[218] = 1367;
        iArr[219] = 1373;
        iArr[220] = 1381;
        iArr[221] = 1399;
        iArr[222] = 1409;
        iArr[223] = 1423;
        iArr[224] = 1427;
        iArr[225] = 1429;
        iArr[226] = 1433;
        iArr[227] = 1439;
        iArr[228] = 1447;
        iArr[229] = 1451;
        iArr[230] = 1453;
        iArr[231] = 1459;
        iArr[232] = 1471;
        iArr[233] = 1481;
        iArr[234] = 1483;
        iArr[235] = 1487;
        iArr[236] = 1489;
        iArr[237] = 1493;
        iArr[238] = 1499;
        for (int i11 = 0; i11 < 239; i11++) {
            if (bigInteger.mod(BigInteger.valueOf((long) iArr[i11])).equals(ZERO)) {
                return false;
            }
        }
        return true;
    }

    public static int pow(int i11, int i12) {
        int i13 = 1;
        while (i12 > 0) {
            if ((i12 & 1) == 1) {
                i13 *= i11;
            }
            i11 *= i11;
            i12 >>>= 1;
        }
        return i13;
    }

    public static long pow(long j11, int i11) {
        long j12 = 1;
        while (i11 > 0) {
            if ((i11 & 1) == 1) {
                j12 *= j11;
            }
            j11 *= j11;
            i11 >>>= 1;
        }
        return j12;
    }

    public static BigInteger randomize(BigInteger bigInteger) {
        if (f59636sr == null) {
            f59636sr = CryptoServicesRegistrar.getSecureRandom();
        }
        return randomize(bigInteger, f59636sr);
    }

    public static BigInteger randomize(BigInteger bigInteger, SecureRandom secureRandom) {
        int bitLength = bigInteger.bitLength();
        BigInteger valueOf = BigInteger.valueOf(0);
        if (secureRandom == null && (secureRandom = f59636sr) == null) {
            secureRandom = CryptoServicesRegistrar.getSecureRandom();
        }
        for (int i11 = 0; i11 < 20; i11++) {
            valueOf = BigIntegers.createRandomBigInteger(bitLength, secureRandom);
            if (valueOf.compareTo(bigInteger) < 0) {
                return valueOf;
            }
        }
        return valueOf.mod(bigInteger);
    }

    public static BigInteger reduceInto(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger.subtract(bigInteger2).mod(bigInteger3.subtract(bigInteger2)).add(bigInteger2);
    }

    public static BigInteger squareRoot(BigInteger bigInteger) {
        int i11;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = ZERO;
        if (bigInteger.compareTo(bigInteger4) >= 0) {
            int bitLength = bigInteger.bitLength();
            if ((bitLength & 1) != 0) {
                int i12 = bitLength - 1;
                bigInteger2 = bigInteger4;
                bigInteger4 = bigInteger4.add(ONE);
                i11 = i12;
            } else {
                i11 = bitLength;
                bigInteger2 = bigInteger4;
            }
            while (i11 > 0) {
                BigInteger bigInteger5 = FOUR;
                BigInteger multiply = bigInteger2.multiply(bigInteger5);
                int i13 = i11 - 1;
                int i14 = bigInteger.testBit(i13) ? 2 : 0;
                i11 = i13 - 1;
                BigInteger add = multiply.add(BigInteger.valueOf((long) (i14 + (bigInteger.testBit(i11) ? 1 : 0))));
                BigInteger multiply2 = bigInteger3.multiply(bigInteger5);
                BigInteger bigInteger6 = ONE;
                BigInteger add2 = multiply2.add(bigInteger6);
                bigInteger3 = bigInteger3.multiply(TWO);
                if (add.compareTo(add2) != -1) {
                    bigInteger3 = bigInteger3.add(bigInteger6);
                    add = add.subtract(add2);
                }
            }
            return bigInteger3;
        }
        throw new ArithmeticException("cannot extract root of negative number" + bigInteger + InstructionFileId.DOT);
    }
}
