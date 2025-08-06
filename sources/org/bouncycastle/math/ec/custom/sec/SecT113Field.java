package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat128;

public class SecT113Field {
    private static final long M49 = 562949953421311L;
    private static final long M57 = 144115188075855871L;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr2[1] ^ jArr[1];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
    }

    private static void addTo(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return Nat.fromBigInteger64(113, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat128.createExt64();
        Nat128.copy64(jArr, jArr2);
        for (int i11 = 1; i11 < 113; i11 += 2) {
            implSquare(jArr2, createExt64);
            reduce(createExt64, jArr2);
            implSquare(jArr2, createExt64);
            reduce(createExt64, jArr2);
            addTo(jArr, jArr2);
        }
    }

    public static void implMultiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long j11 = jArr[0];
        long j12 = ((jArr[1] << 7) ^ (j11 >>> 57)) & M57;
        long j13 = j11 & M57;
        long j14 = jArr2[0];
        long j15 = ((jArr2[1] << 7) ^ (j14 >>> 57)) & M57;
        long j16 = j14 & M57;
        long[] jArr4 = new long[6];
        long[] jArr5 = jArr3;
        long[] jArr6 = jArr4;
        implMulw(jArr5, j13, j16, jArr4, 0);
        long[] jArr7 = jArr6;
        implMulw(jArr5, j12, j15, jArr7, 2);
        implMulw(jArr5, j13 ^ j12, j16 ^ j15, jArr7, 4);
        long j17 = jArr6[1] ^ jArr6[2];
        long j18 = jArr6[0];
        long j19 = jArr6[3];
        long j21 = (jArr6[4] ^ j18) ^ j17;
        long j22 = j17 ^ (jArr6[5] ^ j19);
        jArr3[0] = j18 ^ (j21 << 57);
        jArr3[1] = (j21 >>> 7) ^ (j22 << 50);
        jArr3[2] = (j22 >>> 14) ^ (j19 << 43);
        jArr3[3] = j19 >>> 21;
    }

    public static void implMulw(long[] jArr, long j11, long j12, long[] jArr2, int i11) {
        long j13 = j11;
        jArr[1] = j12;
        jArr[2] = jArr[1] << 1;
        jArr[3] = jArr[2] ^ j12;
        jArr[4] = jArr[2] << 1;
        jArr[5] = jArr[4] ^ j12;
        jArr[6] = jArr[3] << 1;
        jArr[7] = jArr[6] ^ j12;
        long j14 = jArr[((int) j13) & 7];
        long j15 = 0;
        int i12 = 48;
        do {
            int i13 = (int) (j13 >>> i12);
            long j16 = (jArr[i13 & 7] ^ (jArr[(i13 >>> 3) & 7] << 3)) ^ (jArr[(i13 >>> 6) & 7] << 6);
            j14 ^= j16 << i12;
            j15 ^= j16 >>> (-i12);
            i12 -= 9;
        } while (i12 > 0);
        jArr2[i11] = M57 & j14;
        jArr2[i11 + 1] = (((((j13 & 72198606942111744L) & ((j12 << 7) >> 63)) >>> 8) ^ j15) << 7) ^ (j14 >>> 57);
    }

    public static void implSquare(long[] jArr, long[] jArr2) {
        Interleave.expand64To128(jArr, 0, 2, jArr2, 0);
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (!Nat128.isZero64(jArr)) {
            long[] create64 = Nat128.create64();
            long[] create642 = Nat128.create64();
            square(jArr, create64);
            multiply(create64, jArr, create64);
            square(create64, create64);
            multiply(create64, jArr, create64);
            squareN(create64, 3, create642);
            multiply(create642, create64, create642);
            square(create642, create642);
            multiply(create642, jArr, create642);
            squareN(create642, 7, create64);
            multiply(create64, create642, create64);
            squareN(create64, 14, create642);
            multiply(create642, create64, create642);
            squareN(create642, 28, create64);
            multiply(create64, create642, create64);
            squareN(create64, 56, create642);
            multiply(create642, create64, create642);
            square(create642, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        implMultiply(jArr, jArr2, jArr4);
        reduce(jArr4, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        implMultiply(jArr, jArr2, jArr4);
        addExt(jArr3, jArr4, jArr3);
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = jArr[2];
        long j14 = jArr[3];
        long j15 = j13 ^ ((j14 >>> 40) ^ (j14 >>> 49));
        long j16 = j11 ^ ((j15 << 15) ^ (j15 << 24));
        long j17 = (j12 ^ ((j14 << 15) ^ (j14 << 24))) ^ ((j15 >>> 40) ^ (j15 >>> 49));
        long j18 = j17 >>> 49;
        jArr2[0] = (j16 ^ j18) ^ (j18 << 9);
        jArr2[1] = M49 & j17;
    }

    public static void reduce15(long[] jArr, int i11) {
        int i12 = i11 + 1;
        long j11 = jArr[i12];
        long j12 = j11 >>> 49;
        jArr[i11] = (j12 ^ (j12 << 9)) ^ jArr[i11];
        jArr[i12] = j11 & M49;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long unshuffle = Interleave.unshuffle(jArr[0]);
        long unshuffle2 = Interleave.unshuffle(jArr[1]);
        long j11 = (unshuffle >>> 32) | (unshuffle2 & -4294967296L);
        jArr2[0] = ((j11 << 57) ^ ((4294967295L & unshuffle) | (unshuffle2 << 32))) ^ (j11 << 5);
        jArr2[1] = (j11 >>> 59) ^ (j11 >>> 7);
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat128.createExt64();
        implSquare(jArr, createExt64);
        reduce(createExt64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat128.createExt64();
        implSquare(jArr, createExt64);
        addExt(jArr2, createExt64, jArr2);
    }

    public static void squareN(long[] jArr, int i11, long[] jArr2) {
        long[] createExt64 = Nat128.createExt64();
        implSquare(jArr, createExt64);
        while (true) {
            reduce(createExt64, jArr2);
            i11--;
            if (i11 > 0) {
                implSquare(jArr2, createExt64);
            } else {
                return;
            }
        }
    }

    public static int trace(long[] jArr) {
        return ((int) jArr[0]) & 1;
    }
}
