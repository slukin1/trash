package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigInteger;

@GwtIncompatible
final class DoubleUtils {
    public static final int EXPONENT_BIAS = 1023;
    public static final long EXPONENT_MASK = 9218868437227405312L;
    public static final long IMPLICIT_BIT = 4503599627370496L;
    @VisibleForTesting
    public static final long ONE_BITS = 4607182418800017408L;
    public static final int SIGNIFICAND_BITS = 52;
    public static final long SIGNIFICAND_MASK = 4503599627370495L;
    public static final long SIGN_MASK = Long.MIN_VALUE;

    private DoubleUtils() {
    }

    public static double bigToDouble(BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        boolean z11 = true;
        int bitLength = abs.bitLength() - 1;
        if (bitLength < 63) {
            return (double) bigInteger.longValue();
        }
        if (bitLength > 1023) {
            return ((double) bigInteger.signum()) * Double.POSITIVE_INFINITY;
        }
        int i11 = (bitLength - 52) - 1;
        long longValue = abs.shiftRight(i11).longValue();
        long j11 = (longValue >> 1) & SIGNIFICAND_MASK;
        if ((longValue & 1) == 0 || ((j11 & 1) == 0 && abs.getLowestSetBit() >= i11)) {
            z11 = false;
        }
        if (z11) {
            j11++;
        }
        return Double.longBitsToDouble(((((long) (bitLength + 1023)) << 52) + j11) | (((long) bigInteger.signum()) & Long.MIN_VALUE));
    }

    public static double ensureNonNegative(double d11) {
        Preconditions.checkArgument(!Double.isNaN(d11));
        if (d11 > 0.0d) {
            return d11;
        }
        return 0.0d;
    }

    public static long getSignificand(double d11) {
        Preconditions.checkArgument(isFinite(d11), "not a normal value");
        int exponent = Math.getExponent(d11);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d11) & SIGNIFICAND_MASK;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | IMPLICIT_BIT;
    }

    public static boolean isFinite(double d11) {
        return Math.getExponent(d11) <= 1023;
    }

    public static boolean isNormal(double d11) {
        return Math.getExponent(d11) >= -1022;
    }

    public static double nextDown(double d11) {
        return -Math.nextUp(-d11);
    }

    public static double scaleNormalize(double d11) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d11) & SIGNIFICAND_MASK) | ONE_BITS);
    }
}
