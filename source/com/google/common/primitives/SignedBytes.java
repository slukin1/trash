package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible
public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    public enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }

        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i11 = 0; i11 < min; i11++) {
                int compare = SignedBytes.compare(bArr[i11], bArr2[i11]);
                if (compare != 0) {
                    return compare;
                }
            }
            return bArr.length - bArr2.length;
        }
    }

    private SignedBytes() {
    }

    public static byte checkedCast(long j11) {
        byte b11 = (byte) ((int) j11);
        Preconditions.checkArgument(((long) b11) == j11, "Out of range: %s", j11);
        return b11;
    }

    public static int compare(byte b11, byte b12) {
        return b11 - b12;
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * 5);
        sb2.append(bArr[0]);
        for (int i11 = 1; i11 < bArr.length; i11++) {
            sb2.append(str);
            sb2.append(bArr[i11]);
        }
        return sb2.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static byte max(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        byte b11 = bArr[0];
        for (int i11 = 1; i11 < bArr.length; i11++) {
            if (bArr[i11] > b11) {
                b11 = bArr[i11];
            }
        }
        return b11;
    }

    public static byte min(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        byte b11 = bArr[0];
        for (int i11 = 1; i11 < bArr.length; i11++) {
            if (bArr[i11] < b11) {
                b11 = bArr[i11];
            }
        }
        return b11;
    }

    public static byte saturatedCast(long j11) {
        if (j11 > 127) {
            return Ascii.DEL;
        }
        if (j11 < -128) {
            return Byte.MIN_VALUE;
        }
        return (byte) ((int) j11);
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr, int i11, int i12) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i11, i12, bArr.length);
        Arrays.sort(bArr, i11, i12);
        Bytes.reverse(bArr, i11, i12);
    }
}
