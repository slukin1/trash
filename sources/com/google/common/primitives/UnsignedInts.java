package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible
@Beta
public final class UnsignedInts {
    public static final long INT_MASK = 4294967295L;

    public enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }

        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i11 = 0; i11 < min; i11++) {
                if (iArr[i11] != iArr2[i11]) {
                    return UnsignedInts.compare(iArr[i11], iArr2[i11]);
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    private UnsignedInts() {
    }

    public static int checkedCast(long j11) {
        Preconditions.checkArgument((j11 >> 32) == 0, "out of range: %s", j11);
        return (int) j11;
    }

    public static int compare(int i11, int i12) {
        return Ints.compare(flip(i11), flip(i12));
    }

    @CanIgnoreReturnValue
    public static int decode(String str) {
        ParseRequest fromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedInt(fromString.rawValue, fromString.radix);
        } catch (NumberFormatException e11) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e11);
            throw numberFormatException;
        }
    }

    public static int divide(int i11, int i12) {
        return (int) (toLong(i11) / toLong(i12));
    }

    public static int flip(int i11) {
        return i11 ^ Integer.MIN_VALUE;
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(iArr.length * 5);
        sb2.append(toString(iArr[0]));
        for (int i11 = 1; i11 < iArr.length; i11++) {
            sb2.append(str);
            sb2.append(toString(iArr[i11]));
        }
        return sb2.toString();
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int max(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int flip = flip(iArr[0]);
        for (int i11 = 1; i11 < iArr.length; i11++) {
            int flip2 = flip(iArr[i11]);
            if (flip2 > flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    public static int min(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int flip = flip(iArr[0]);
        for (int i11 = 1; i11 < iArr.length; i11++) {
            int flip2 = flip(iArr[i11]);
            if (flip2 < flip) {
                flip = flip2;
            }
        }
        return flip(flip);
    }

    @CanIgnoreReturnValue
    public static int parseUnsignedInt(String str) {
        return parseUnsignedInt(str, 10);
    }

    public static int remainder(int i11, int i12) {
        return (int) (toLong(i11) % toLong(i12));
    }

    public static int saturatedCast(long j11) {
        if (j11 <= 0) {
            return 0;
        }
        if (j11 >= 4294967296L) {
            return -1;
        }
        return (int) j11;
    }

    public static void sort(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sort(iArr, 0, iArr.length);
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    public static long toLong(int i11) {
        return ((long) i11) & 4294967295L;
    }

    public static String toString(int i11) {
        return toString(i11, 10);
    }

    @CanIgnoreReturnValue
    public static int parseUnsignedInt(String str, int i11) {
        Preconditions.checkNotNull(str);
        long parseLong = Long.parseLong(str, i11);
        if ((4294967295L & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new NumberFormatException("Input " + str + " in base " + i11 + " is not in the range of an unsigned integer");
    }

    public static String toString(int i11, int i12) {
        return Long.toString(((long) i11) & 4294967295L, i12);
    }

    public static void sort(int[] iArr, int i11, int i12) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i11, i12, iArr.length);
        for (int i13 = i11; i13 < i12; i13++) {
            iArr[i13] = flip(iArr[i13]);
        }
        Arrays.sort(iArr, i11, i12);
        while (i11 < i12) {
            iArr[i11] = flip(iArr[i11]);
            i11++;
        }
    }

    public static void sortDescending(int[] iArr, int i11, int i12) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i11, i12, iArr.length);
        for (int i13 = i11; i13 < i12; i13++) {
            iArr[i13] = Integer.MAX_VALUE ^ iArr[i13];
        }
        Arrays.sort(iArr, i11, i12);
        while (i11 < i12) {
            iArr[i11] = iArr[i11] ^ Integer.MAX_VALUE;
            i11++;
        }
    }
}
