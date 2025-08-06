package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat448;

public class SecT409Field {
    private static final long M25 = 33554431;
    private static final long M59 = 576460752303423487L;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr2[6] ^ jArr[6];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i11 = 0; i11 < 13; i11++) {
            jArr3[i11] = jArr[i11] ^ jArr2[i11];
        }
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
    }

    private static void addTo(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
        jArr2[3] = jArr2[3] ^ jArr[3];
        jArr2[4] = jArr2[4] ^ jArr[4];
        jArr2[5] = jArr2[5] ^ jArr[5];
        jArr2[6] = jArr2[6] ^ jArr[6];
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return Nat.fromBigInteger64(409, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] create64 = Nat.create64(13);
        Nat448.copy64(jArr, jArr2);
        for (int i11 = 1; i11 < 409; i11 += 2) {
            implSquare(jArr2, create64);
            reduce(create64, jArr2);
            implSquare(jArr2, create64);
            reduce(create64, jArr2);
            addTo(jArr, jArr2);
        }
    }

    public static void implCompactExt(long[] jArr) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = jArr[2];
        long j14 = jArr[3];
        long j15 = jArr[4];
        long j16 = jArr[5];
        long j17 = jArr[6];
        long j18 = jArr[7];
        long j19 = jArr[8];
        long j21 = jArr[9];
        long j22 = jArr[10];
        long j23 = jArr[11];
        long j24 = jArr[12];
        long j25 = jArr[13];
        jArr[0] = j11 ^ (j12 << 59);
        jArr[1] = (j12 >>> 5) ^ (j13 << 54);
        jArr[2] = (j13 >>> 10) ^ (j14 << 49);
        jArr[3] = (j14 >>> 15) ^ (j15 << 44);
        jArr[4] = (j15 >>> 20) ^ (j16 << 39);
        jArr[5] = (j16 >>> 25) ^ (j17 << 34);
        jArr[6] = (j17 >>> 30) ^ (j18 << 29);
        jArr[7] = (j18 >>> 35) ^ (j19 << 24);
        jArr[8] = (j19 >>> 40) ^ (j21 << 19);
        jArr[9] = (j21 >>> 45) ^ (j22 << 14);
        jArr[10] = (j22 >>> 50) ^ (j23 << 9);
        jArr[11] = ((j23 >>> 55) ^ (j24 << 4)) ^ (j25 << 63);
        jArr[12] = j25 >>> 1;
    }

    public static void implExpand(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = jArr[2];
        long j14 = jArr[3];
        long j15 = jArr[4];
        long j16 = jArr[5];
        long j17 = jArr[6];
        jArr2[0] = j11 & M59;
        jArr2[1] = ((j11 >>> 59) ^ (j12 << 5)) & M59;
        jArr2[2] = ((j12 >>> 54) ^ (j13 << 10)) & M59;
        jArr2[3] = ((j13 >>> 49) ^ (j14 << 15)) & M59;
        jArr2[4] = ((j14 >>> 44) ^ (j15 << 20)) & M59;
        jArr2[5] = ((j15 >>> 39) ^ (j16 << 25)) & M59;
        jArr2[6] = (j16 >>> 34) ^ (j17 << 30);
    }

    public static void implMultiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[7];
        long[] jArr5 = new long[7];
        implExpand(jArr, jArr4);
        implExpand(jArr2, jArr5);
        long[] jArr6 = new long[8];
        for (int i11 = 0; i11 < 7; i11++) {
            implMulwAcc(jArr6, jArr4[i11], jArr5[i11], jArr3, i11 << 1);
        }
        long j11 = jArr3[0];
        long j12 = jArr3[1];
        long j13 = j11 ^ jArr3[2];
        jArr3[1] = j13 ^ j12;
        long j14 = j12 ^ jArr3[3];
        long j15 = j13 ^ jArr3[4];
        jArr3[2] = j15 ^ j14;
        long j16 = j14 ^ jArr3[5];
        long j17 = j15 ^ jArr3[6];
        jArr3[3] = j17 ^ j16;
        long j18 = j16 ^ jArr3[7];
        long j19 = j17 ^ jArr3[8];
        jArr3[4] = j19 ^ j18;
        long j21 = j18 ^ jArr3[9];
        long j22 = j19 ^ jArr3[10];
        jArr3[5] = j22 ^ j21;
        long j23 = j21 ^ jArr3[11];
        long j24 = j22 ^ jArr3[12];
        jArr3[6] = j24 ^ j23;
        long j25 = j24 ^ (j23 ^ jArr3[13]);
        jArr3[7] = jArr3[0] ^ j25;
        jArr3[8] = jArr3[1] ^ j25;
        jArr3[9] = jArr3[2] ^ j25;
        jArr3[10] = jArr3[3] ^ j25;
        jArr3[11] = jArr3[4] ^ j25;
        jArr3[12] = jArr3[5] ^ j25;
        jArr3[13] = j25 ^ jArr3[6];
        implMulwAcc(jArr6, jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        implMulwAcc(jArr6, jArr4[0] ^ jArr4[2], jArr5[0] ^ jArr5[2], jArr3, 2);
        implMulwAcc(jArr6, jArr4[0] ^ jArr4[3], jArr5[0] ^ jArr5[3], jArr3, 3);
        implMulwAcc(jArr6, jArr4[1] ^ jArr4[2], jArr5[1] ^ jArr5[2], jArr3, 3);
        implMulwAcc(jArr6, jArr4[0] ^ jArr4[4], jArr5[0] ^ jArr5[4], jArr3, 4);
        implMulwAcc(jArr6, jArr4[1] ^ jArr4[3], jArr5[1] ^ jArr5[3], jArr3, 4);
        implMulwAcc(jArr6, jArr4[0] ^ jArr4[5], jArr5[0] ^ jArr5[5], jArr3, 5);
        implMulwAcc(jArr6, jArr4[1] ^ jArr4[4], jArr5[1] ^ jArr5[4], jArr3, 5);
        implMulwAcc(jArr6, jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 5);
        implMulwAcc(jArr6, jArr4[0] ^ jArr4[6], jArr5[0] ^ jArr5[6], jArr3, 6);
        implMulwAcc(jArr6, jArr4[1] ^ jArr4[5], jArr5[1] ^ jArr5[5], jArr3, 6);
        implMulwAcc(jArr6, jArr4[2] ^ jArr4[4], jArr5[2] ^ jArr5[4], jArr3, 6);
        implMulwAcc(jArr6, jArr4[1] ^ jArr4[6], jArr5[1] ^ jArr5[6], jArr3, 7);
        implMulwAcc(jArr6, jArr4[2] ^ jArr4[5], jArr5[2] ^ jArr5[5], jArr3, 7);
        implMulwAcc(jArr6, jArr4[3] ^ jArr4[4], jArr5[3] ^ jArr5[4], jArr3, 7);
        implMulwAcc(jArr6, jArr4[2] ^ jArr4[6], jArr5[2] ^ jArr5[6], jArr3, 8);
        implMulwAcc(jArr6, jArr4[3] ^ jArr4[5], jArr5[3] ^ jArr5[5], jArr3, 8);
        implMulwAcc(jArr6, jArr4[3] ^ jArr4[6], jArr5[3] ^ jArr5[6], jArr3, 9);
        implMulwAcc(jArr6, jArr4[4] ^ jArr4[5], jArr5[4] ^ jArr5[5], jArr3, 9);
        implMulwAcc(jArr6, jArr4[4] ^ jArr4[6], jArr5[4] ^ jArr5[6], jArr3, 10);
        implMulwAcc(jArr6, jArr4[5] ^ jArr4[6], jArr5[5] ^ jArr5[6], jArr3, 11);
        implCompactExt(jArr3);
    }

    public static void implMulwAcc(long[] jArr, long j11, long j12, long[] jArr2, int i11) {
        long j13 = j11;
        jArr[1] = j12;
        jArr[2] = jArr[1] << 1;
        jArr[3] = jArr[2] ^ j12;
        jArr[4] = jArr[2] << 1;
        jArr[5] = jArr[4] ^ j12;
        jArr[6] = jArr[3] << 1;
        jArr[7] = jArr[6] ^ j12;
        int i12 = (int) j13;
        long j14 = (jArr[(i12 >>> 3) & 7] << 3) ^ jArr[i12 & 7];
        long j15 = 0;
        int i13 = 54;
        do {
            int i14 = (int) (j13 >>> i13);
            long j16 = jArr[i14 & 7] ^ (jArr[(i14 >>> 3) & 7] << 3);
            j14 ^= j16 << i13;
            j15 ^= j16 >>> (-i13);
            i13 -= 6;
        } while (i13 > 0);
        jArr2[i11] = jArr2[i11] ^ (M59 & j14);
        int i15 = i11 + 1;
        jArr2[i15] = jArr2[i15] ^ ((j14 >>> 59) ^ (j15 << 5));
    }

    public static void implSquare(long[] jArr, long[] jArr2) {
        Interleave.expand64To128(jArr, 0, 6, jArr2, 0);
        jArr2[12] = Interleave.expand32to64((int) jArr[6]);
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (!Nat448.isZero64(jArr)) {
            long[] create64 = Nat448.create64();
            long[] create642 = Nat448.create64();
            long[] create643 = Nat448.create64();
            square(jArr, create64);
            squareN(create64, 1, create642);
            multiply(create64, create642, create64);
            squareN(create642, 1, create642);
            multiply(create64, create642, create64);
            squareN(create64, 3, create642);
            multiply(create64, create642, create64);
            squareN(create64, 6, create642);
            multiply(create64, create642, create64);
            squareN(create64, 12, create642);
            multiply(create64, create642, create643);
            squareN(create643, 24, create64);
            squareN(create64, 24, create642);
            multiply(create64, create642, create64);
            squareN(create64, 48, create642);
            multiply(create64, create642, create64);
            squareN(create64, 96, create642);
            multiply(create64, create642, create64);
            squareN(create64, 192, create642);
            multiply(create64, create642, create64);
            multiply(create64, create643, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat448.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        reduce(createExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat448.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        addExt(jArr3, createExt64, jArr3);
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = jArr[2];
        long j14 = jArr[3];
        long j15 = jArr[4];
        long j16 = jArr[5];
        long j17 = jArr[6];
        long j18 = jArr[7];
        long j19 = jArr[12];
        long j21 = j17 ^ ((j19 >>> 25) ^ (j19 << 62));
        long j22 = j18 ^ (j19 >>> 2);
        long j23 = jArr[11];
        long j24 = j15 ^ (j23 << 39);
        long j25 = (j16 ^ (j19 << 39)) ^ ((j23 >>> 25) ^ (j23 << 62));
        long j26 = j21 ^ (j23 >>> 2);
        long j27 = jArr[10];
        long j28 = j14 ^ (j27 << 39);
        long j29 = j24 ^ ((j27 >>> 25) ^ (j27 << 62));
        long j30 = j25 ^ (j27 >>> 2);
        long j31 = jArr[9];
        long j32 = j13 ^ (j31 << 39);
        long j33 = j28 ^ ((j31 >>> 25) ^ (j31 << 62));
        long j34 = j29 ^ (j31 >>> 2);
        long j35 = jArr[8];
        long j36 = j11 ^ (j22 << 39);
        long j37 = (j32 ^ ((j35 >>> 25) ^ (j35 << 62))) ^ (j22 >>> 2);
        long j38 = j26 >>> 25;
        jArr2[0] = j36 ^ j38;
        long j39 = j38 << 23;
        jArr2[1] = j39 ^ ((j12 ^ (j35 << 39)) ^ ((j22 >>> 25) ^ (j22 << 62)));
        jArr2[2] = j37;
        jArr2[3] = j33 ^ (j35 >>> 2);
        jArr2[4] = j34;
        jArr2[5] = j30;
        jArr2[6] = j26 & M25;
    }

    public static void reduce39(long[] jArr, int i11) {
        int i12 = i11 + 6;
        long j11 = jArr[i12];
        long j12 = j11 >>> 25;
        jArr[i11] = jArr[i11] ^ j12;
        int i13 = i11 + 1;
        jArr[i13] = (j12 << 23) ^ jArr[i13];
        jArr[i12] = j11 & M25;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long unshuffle = Interleave.unshuffle(jArr[0]);
        long unshuffle2 = Interleave.unshuffle(jArr[1]);
        long j11 = (unshuffle & 4294967295L) | (unshuffle2 << 32);
        long j12 = (unshuffle >>> 32) | (unshuffle2 & -4294967296L);
        long unshuffle3 = Interleave.unshuffle(jArr[2]);
        long unshuffle4 = Interleave.unshuffle(jArr[3]);
        long j13 = (unshuffle3 & 4294967295L) | (unshuffle4 << 32);
        long j14 = (unshuffle3 >>> 32) | (unshuffle4 & -4294967296L);
        long unshuffle5 = Interleave.unshuffle(jArr[4]);
        long unshuffle6 = Interleave.unshuffle(jArr[5]);
        long j15 = (unshuffle5 >>> 32) | (unshuffle6 & -4294967296L);
        long unshuffle7 = Interleave.unshuffle(jArr[6]);
        long j16 = unshuffle7 & 4294967295L;
        long j17 = unshuffle7 >>> 32;
        jArr2[0] = j11 ^ (j12 << 44);
        jArr2[1] = (j13 ^ (j14 << 44)) ^ (j12 >>> 20);
        jArr2[2] = (((unshuffle5 & 4294967295L) | (unshuffle6 << 32)) ^ (j15 << 44)) ^ (j14 >>> 20);
        jArr2[3] = (((j17 << 44) ^ j16) ^ (j15 >>> 20)) ^ (j12 << 13);
        jArr2[4] = (j12 >>> 51) ^ ((j17 >>> 20) ^ (j14 << 13));
        jArr2[5] = (j15 << 13) ^ (j14 >>> 51);
        jArr2[6] = (j17 << 13) ^ (j15 >>> 51);
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] create64 = Nat.create64(13);
        implSquare(jArr, create64);
        reduce(create64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] create64 = Nat.create64(13);
        implSquare(jArr, create64);
        addExt(jArr2, create64, jArr2);
    }

    public static void squareN(long[] jArr, int i11, long[] jArr2) {
        long[] create64 = Nat.create64(13);
        implSquare(jArr, create64);
        while (true) {
            reduce(create64, jArr2);
            i11--;
            if (i11 > 0) {
                implSquare(jArr2, create64);
            } else {
                return;
            }
        }
    }

    public static int trace(long[] jArr) {
        return ((int) jArr[0]) & 1;
    }
}
