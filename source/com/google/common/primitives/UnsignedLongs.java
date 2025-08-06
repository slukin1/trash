package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible
@Beta
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i11 = 0; i11 < min; i11++) {
                if (jArr[i11] != jArr2[i11]) {
                    return UnsignedLongs.compare(jArr[i11], jArr2[i11]);
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    public static final class ParseOverflowDetection {
        public static final int[] maxSafeDigits = new int[37];
        public static final long[] maxValueDivs = new long[37];
        public static final int[] maxValueMods = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i11 = 2; i11 <= 36; i11++) {
                long j11 = (long) i11;
                maxValueDivs[i11] = UnsignedLongs.divide(-1, j11);
                maxValueMods[i11] = (int) UnsignedLongs.remainder(-1, j11);
                maxSafeDigits[i11] = bigInteger.toString(i11).length() - 1;
            }
        }

        private ParseOverflowDetection() {
        }

        public static boolean overflowInParse(long j11, int i11, int i12) {
            if (j11 < 0) {
                return true;
            }
            long[] jArr = maxValueDivs;
            if (j11 < jArr[i12]) {
                return false;
            }
            if (j11 <= jArr[i12] && i11 <= maxValueMods[i12]) {
                return false;
            }
            return true;
        }
    }

    private UnsignedLongs() {
    }

    public static int compare(long j11, long j12) {
        return Longs.compare(flip(j11), flip(j12));
    }

    @CanIgnoreReturnValue
    public static long decode(String str) {
        ParseRequest fromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedLong(fromString.rawValue, fromString.radix);
        } catch (NumberFormatException e11) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e11);
            throw numberFormatException;
        }
    }

    public static long divide(long j11, long j12) {
        if (j12 < 0) {
            return compare(j11, j12) < 0 ? 0 : 1;
        }
        if (j11 >= 0) {
            return j11 / j12;
        }
        int i11 = 1;
        long j13 = ((j11 >>> 1) / j12) << 1;
        if (compare(j11 - (j13 * j12), j12) < 0) {
            i11 = 0;
        }
        return j13 + ((long) i11);
    }

    private static long flip(long j11) {
        return j11 ^ Long.MIN_VALUE;
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(jArr.length * 5);
        sb2.append(toString(jArr[0]));
        for (int i11 = 1; i11 < jArr.length; i11++) {
            sb2.append(str);
            sb2.append(toString(jArr[i11]));
        }
        return sb2.toString();
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long flip = flip(jArr[0]);
        for (int i11 = 1; i11 < jArr.length; i11++) {
            long flip2 = flip(jArr[i11]);
            if (flip2 > flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long flip = flip(jArr[0]);
        for (int i11 = 1; i11 < jArr.length; i11++) {
            long flip2 = flip(jArr[i11]);
            if (flip2 < flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str) {
        return parseUnsignedLong(str, 10);
    }

    public static long remainder(long j11, long j12) {
        if (j12 < 0) {
            return compare(j11, j12) < 0 ? j11 : j11 - j12;
        }
        if (j11 >= 0) {
            return j11 % j12;
        }
        long j13 = j11 - ((((j11 >>> 1) / j12) << 1) * j12);
        if (compare(j13, j12) < 0) {
            j12 = 0;
        }
        return j13 - j12;
    }

    public static void sort(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sort(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static String toString(long j11) {
        return toString(j11, 10);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str, int i11) {
        Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        } else if (i11 < 2 || i11 > 36) {
            throw new NumberFormatException("illegal radix: " + i11);
        } else {
            int i12 = ParseOverflowDetection.maxSafeDigits[i11] - 1;
            long j11 = 0;
            int i13 = 0;
            while (i13 < str.length()) {
                int digit = Character.digit(str.charAt(i13), i11);
                if (digit == -1) {
                    throw new NumberFormatException(str);
                } else if (i13 <= i12 || !ParseOverflowDetection.overflowInParse(j11, digit, i11)) {
                    j11 = (j11 * ((long) i11)) + ((long) digit);
                    i13++;
                } else {
                    throw new NumberFormatException("Too large for unsigned long: " + str);
                }
            }
            return j11;
        }
    }

    public static String toString(long j11, int i11) {
        long j12;
        Preconditions.checkArgument(i11 >= 2 && i11 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i11);
        int i12 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i12 == 0) {
            return "0";
        }
        if (i12 > 0) {
            return Long.toString(j11, i11);
        }
        int i13 = 64;
        char[] cArr = new char[64];
        int i14 = i11 - 1;
        if ((i11 & i14) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i11);
            do {
                i13--;
                cArr[i13] = Character.forDigit(((int) j11) & i14, i11);
                j11 >>>= numberOfTrailingZeros;
            } while (j11 != 0);
        } else {
            if ((i11 & 1) == 0) {
                j12 = (j11 >>> 1) / ((long) (i11 >>> 1));
            } else {
                j12 = divide(j11, (long) i11);
            }
            long j13 = (long) i11;
            cArr[63] = Character.forDigit((int) (j11 - (j12 * j13)), i11);
            i13 = 63;
            while (j12 > 0) {
                i13--;
                cArr[i13] = Character.forDigit((int) (j12 % j13), i11);
                j12 /= j13;
            }
        }
        return new String(cArr, i13, 64 - i13);
    }

    public static void sort(long[] jArr, int i11, int i12) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i11, i12, jArr.length);
        for (int i13 = i11; i13 < i12; i13++) {
            jArr[i13] = flip(jArr[i13]);
        }
        Arrays.sort(jArr, i11, i12);
        while (i11 < i12) {
            jArr[i11] = flip(jArr[i11]);
            i11++;
        }
    }

    public static void sortDescending(long[] jArr, int i11, int i12) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i11, i12, jArr.length);
        for (int i13 = i11; i13 < i12; i13++) {
            jArr[i13] = Long.MAX_VALUE ^ jArr[i13];
        }
        Arrays.sort(jArr, i11, i12);
        while (i11 < i12) {
            jArr[i11] = jArr[i11] ^ Long.MAX_VALUE;
            i11++;
        }
    }
}
