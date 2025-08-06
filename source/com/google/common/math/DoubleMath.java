package com.google.common.math;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@GwtCompatible(emulated = true)
public final class DoubleMath {
    private static final double LN_2 = Math.log(2.0d);
    @VisibleForTesting
    public static final int MAX_FACTORIAL = 170;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9d;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18d;
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9d;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18d;
    @VisibleForTesting
    public static final double[] everySixteenthFactorial = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* renamed from: com.google.common.math.DoubleMath$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                java.math.RoundingMode[] r0 = java.math.RoundingMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$math$RoundingMode = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$java$math$RoundingMode     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.DoubleMath.AnonymousClass1.<clinit>():void");
        }
    }

    private DoubleMath() {
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    private static double checkFinite(double d11) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d11));
        return d11;
    }

    public static double factorial(int i11) {
        MathPreconditions.checkNonNegative(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, i11);
        if (i11 > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d11 = 1.0d;
        int i12 = i11 & -16;
        while (true) {
            i12++;
            if (i12 > i11) {
                return d11 * everySixteenthFactorial[i11 >> 4];
            }
            d11 *= (double) i12;
        }
    }

    public static int fuzzyCompare(double d11, double d12, double d13) {
        if (fuzzyEquals(d11, d12, d13)) {
            return 0;
        }
        if (d11 < d12) {
            return -1;
        }
        if (d11 > d12) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(d11), Double.isNaN(d12));
    }

    public static boolean fuzzyEquals(double d11, double d12, double d13) {
        MathPreconditions.checkNonNegative("tolerance", d13);
        return Math.copySign(d11 - d12, 1.0d) <= d13 || d11 == d12 || (Double.isNaN(d11) && Double.isNaN(d12));
    }

    @GwtIncompatible
    public static boolean isMathematicalInteger(double d11) {
        return DoubleUtils.isFinite(d11) && (d11 == 0.0d || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(d11)) <= Math.getExponent(d11));
    }

    @GwtIncompatible
    public static boolean isPowerOfTwo(double d11) {
        if (d11 <= 0.0d || !DoubleUtils.isFinite(d11)) {
            return false;
        }
        long significand = DoubleUtils.getSignificand(d11);
        if ((significand & (significand - 1)) == 0) {
            return true;
        }
        return false;
    }

    public static double log2(double d11) {
        return Math.log(d11) / LN_2;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0, "Cannot take mean of 0 values");
        double checkFinite = checkFinite(dArr[0]);
        long j11 = 1;
        for (int i11 = 1; i11 < dArr.length; i11++) {
            checkFinite(dArr[i11]);
            j11++;
            checkFinite += (dArr[i11] - checkFinite) / ((double) j11);
        }
        return checkFinite;
    }

    @GwtIncompatible
    public static double roundIntermediate(double d11, RoundingMode roundingMode) {
        if (DoubleUtils.isFinite(d11)) {
            switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
                case 1:
                    MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(d11));
                    return d11;
                case 2:
                    return (d11 >= 0.0d || isMathematicalInteger(d11)) ? d11 : (double) (((long) d11) - 1);
                case 3:
                    return (d11 <= 0.0d || isMathematicalInteger(d11)) ? d11 : (double) (((long) d11) + 1);
                case 4:
                    return d11;
                case 5:
                    if (isMathematicalInteger(d11)) {
                        return d11;
                    }
                    return (double) (((long) d11) + ((long) (d11 > 0.0d ? 1 : -1)));
                case 6:
                    return Math.rint(d11);
                case 7:
                    double rint = Math.rint(d11);
                    return Math.abs(d11 - rint) == 0.5d ? d11 + Math.copySign(0.5d, d11) : rint;
                case 8:
                    double rint2 = Math.rint(d11);
                    return Math.abs(d11 - rint2) == 0.5d ? d11 : rint2;
                default:
                    throw new AssertionError();
            }
        } else {
            throw new ArithmeticException("input is infinite or NaN");
        }
    }

    @GwtIncompatible
    public static BigInteger roundToBigInteger(double d11, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d11, roundingMode);
        boolean z11 = true;
        boolean z12 = MIN_LONG_AS_DOUBLE - roundIntermediate < 1.0d;
        if (roundIntermediate >= MAX_LONG_AS_DOUBLE_PLUS_ONE) {
            z11 = false;
        }
        if (z12 && z11) {
            return BigInteger.valueOf((long) roundIntermediate);
        }
        BigInteger shiftLeft = BigInteger.valueOf(DoubleUtils.getSignificand(roundIntermediate)).shiftLeft(Math.getExponent(roundIntermediate) - 52);
        return roundIntermediate < 0.0d ? shiftLeft.negate() : shiftLeft;
    }

    @GwtIncompatible
    public static int roundToInt(double d11, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d11, roundingMode);
        boolean z11 = true;
        boolean z12 = roundIntermediate > -2.147483649E9d;
        if (roundIntermediate >= 2.147483648E9d) {
            z11 = false;
        }
        MathPreconditions.checkInRangeForRoundingInputs(z12 & z11, d11, roundingMode);
        return (int) roundIntermediate;
    }

    @GwtIncompatible
    public static long roundToLong(double d11, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d11, roundingMode);
        boolean z11 = true;
        boolean z12 = MIN_LONG_AS_DOUBLE - roundIntermediate < 1.0d;
        if (roundIntermediate >= MAX_LONG_AS_DOUBLE_PLUS_ONE) {
            z11 = false;
        }
        MathPreconditions.checkInRangeForRoundingInputs(z12 & z11, d11, roundingMode);
        return (long) roundIntermediate;
    }

    @GwtIncompatible
    public static int log2(double d11, RoundingMode roundingMode) {
        boolean z11;
        boolean z12 = false;
        Preconditions.checkArgument(d11 > 0.0d && DoubleUtils.isFinite(d11), "x must be positive and finite");
        int exponent = Math.getExponent(d11);
        if (!DoubleUtils.isNormal(d11)) {
            return log2(d11 * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(d11));
                break;
            case 2:
                break;
            case 3:
                z12 = !isPowerOfTwo(d11);
                break;
            case 4:
                if (exponent < 0) {
                    z12 = true;
                }
                z11 = isPowerOfTwo(d11);
                break;
            case 5:
                if (exponent >= 0) {
                    z12 = true;
                }
                z11 = isPowerOfTwo(d11);
                break;
            case 6:
            case 7:
            case 8:
                double scaleNormalize = DoubleUtils.scaleNormalize(d11);
                if (scaleNormalize * scaleNormalize > 2.0d) {
                    z12 = true;
                    break;
                }
                break;
            default:
                throw new AssertionError();
        }
        z12 &= !z11;
        return z12 ? exponent + 1 : exponent;
    }

    @Deprecated
    public static double mean(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0, "Cannot take mean of 0 values");
        long j11 = 0;
        for (int i11 : iArr) {
            j11 += (long) i11;
        }
        return ((double) j11) / ((double) iArr.length);
    }

    @Deprecated
    public static double mean(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0, "Cannot take mean of 0 values");
        double d11 = (double) jArr[0];
        long j11 = 1;
        for (int i11 = 1; i11 < jArr.length; i11++) {
            j11++;
            d11 += (((double) jArr[i11]) - d11) / ((double) j11);
        }
        return d11;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterable<? extends Number> iterable) {
        return mean(iterable.iterator());
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterator<? extends Number> it2) {
        Preconditions.checkArgument(it2.hasNext(), "Cannot take mean of 0 values");
        double checkFinite = checkFinite(((Number) it2.next()).doubleValue());
        long j11 = 1;
        while (it2.hasNext()) {
            j11++;
            checkFinite += (checkFinite(((Number) it2.next()).doubleValue()) - checkFinite) / ((double) j11);
        }
        return checkFinite;
    }
}
