package org.bouncycastle.math.raw;

public abstract class Bits {
    public static int bitPermuteStep(int i11, int i12, int i13) {
        int i14 = i12 & ((i11 >>> i13) ^ i11);
        return i11 ^ (i14 ^ (i14 << i13));
    }

    public static long bitPermuteStep(long j11, long j12, int i11) {
        long j13 = j12 & ((j11 >>> i11) ^ j11);
        return j11 ^ (j13 ^ (j13 << i11));
    }

    public static int bitPermuteStepSimple(int i11, int i12, int i13) {
        return ((i11 >>> i13) & i12) | ((i11 & i12) << i13);
    }

    public static long bitPermuteStepSimple(long j11, long j12, int i11) {
        return ((j11 >>> i11) & j12) | ((j11 & j12) << i11);
    }
}
