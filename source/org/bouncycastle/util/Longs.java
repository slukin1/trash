package org.bouncycastle.util;

public class Longs {
    public static final int BYTES = 8;
    public static final int SIZE = 64;

    public static int numberOfLeadingZeros(long j11) {
        return Long.numberOfLeadingZeros(j11);
    }

    public static int numberOfTrailingZeros(long j11) {
        return Long.numberOfTrailingZeros(j11);
    }

    public static long reverse(long j11) {
        return Long.reverse(j11);
    }

    public static long reverseBytes(long j11) {
        return Long.reverseBytes(j11);
    }

    public static long rotateLeft(long j11, int i11) {
        return Long.rotateLeft(j11, i11);
    }

    public static long rotateRight(long j11, int i11) {
        return Long.rotateRight(j11, i11);
    }

    public static Long valueOf(long j11) {
        return Long.valueOf(j11);
    }
}
