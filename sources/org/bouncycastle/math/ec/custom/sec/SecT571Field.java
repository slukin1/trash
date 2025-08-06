package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat576;

public class SecT571Field {
    private static final long M59 = 576460752303423487L;
    private static final long[] ROOT_Z = {3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};

    private static void add(long[] jArr, int i11, long[] jArr2, int i12, long[] jArr3, int i13) {
        for (int i14 = 0; i14 < 9; i14++) {
            jArr3[i13 + i14] = jArr[i11 + i14] ^ jArr2[i12 + i14];
        }
    }

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i11 = 0; i11 < 9; i11++) {
            jArr3[i11] = jArr[i11] ^ jArr2[i11];
        }
    }

    private static void addBothTo(long[] jArr, int i11, long[] jArr2, int i12, long[] jArr3, int i13) {
        for (int i14 = 0; i14 < 9; i14++) {
            int i15 = i13 + i14;
            jArr3[i15] = jArr3[i15] ^ (jArr[i11 + i14] ^ jArr2[i12 + i14]);
        }
    }

    public static void addBothTo(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i11 = 0; i11 < 9; i11++) {
            jArr3[i11] = jArr3[i11] ^ (jArr[i11] ^ jArr2[i11]);
        }
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i11 = 0; i11 < 18; i11++) {
            jArr3[i11] = jArr[i11] ^ jArr2[i11];
        }
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        for (int i11 = 1; i11 < 9; i11++) {
            jArr2[i11] = jArr[i11];
        }
    }

    private static void addTo(long[] jArr, long[] jArr2) {
        for (int i11 = 0; i11 < 9; i11++) {
            jArr2[i11] = jArr2[i11] ^ jArr[i11];
        }
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return Nat.fromBigInteger64(571, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat576.createExt64();
        Nat576.copy64(jArr, jArr2);
        for (int i11 = 1; i11 < 571; i11 += 2) {
            implSquare(jArr2, createExt64);
            reduce(createExt64, jArr2);
            implSquare(jArr2, createExt64);
            reduce(createExt64, jArr2);
            addTo(jArr, jArr2);
        }
    }

    public static void implMultiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[16];
        for (int i11 = 0; i11 < 9; i11++) {
            implMulwAcc(jArr4, jArr[i11], jArr2[i11], jArr3, i11 << 1);
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
        long j25 = j23 ^ jArr3[13];
        long j26 = j24 ^ jArr3[14];
        jArr3[7] = j26 ^ j25;
        long j27 = j25 ^ jArr3[15];
        long j28 = j26 ^ jArr3[16];
        jArr3[8] = j28 ^ j27;
        long j29 = j28 ^ (j27 ^ jArr3[17]);
        jArr3[9] = jArr3[0] ^ j29;
        jArr3[10] = jArr3[1] ^ j29;
        jArr3[11] = jArr3[2] ^ j29;
        jArr3[12] = jArr3[3] ^ j29;
        jArr3[13] = jArr3[4] ^ j29;
        jArr3[14] = jArr3[5] ^ j29;
        jArr3[15] = jArr3[6] ^ j29;
        jArr3[16] = jArr3[7] ^ j29;
        jArr3[17] = jArr3[8] ^ j29;
        implMulwAcc(jArr4, jArr[0] ^ jArr[1], jArr2[0] ^ jArr2[1], jArr3, 1);
        implMulwAcc(jArr4, jArr[0] ^ jArr[2], jArr2[0] ^ jArr2[2], jArr3, 2);
        implMulwAcc(jArr4, jArr[0] ^ jArr[3], jArr2[0] ^ jArr2[3], jArr3, 3);
        implMulwAcc(jArr4, jArr[1] ^ jArr[2], jArr2[1] ^ jArr2[2], jArr3, 3);
        implMulwAcc(jArr4, jArr[0] ^ jArr[4], jArr2[0] ^ jArr2[4], jArr3, 4);
        implMulwAcc(jArr4, jArr[1] ^ jArr[3], jArr2[1] ^ jArr2[3], jArr3, 4);
        implMulwAcc(jArr4, jArr[0] ^ jArr[5], jArr2[0] ^ jArr2[5], jArr3, 5);
        implMulwAcc(jArr4, jArr[1] ^ jArr[4], jArr2[1] ^ jArr2[4], jArr3, 5);
        implMulwAcc(jArr4, jArr[2] ^ jArr[3], jArr2[2] ^ jArr2[3], jArr3, 5);
        implMulwAcc(jArr4, jArr[0] ^ jArr[6], jArr2[0] ^ jArr2[6], jArr3, 6);
        implMulwAcc(jArr4, jArr[1] ^ jArr[5], jArr2[1] ^ jArr2[5], jArr3, 6);
        implMulwAcc(jArr4, jArr[2] ^ jArr[4], jArr2[2] ^ jArr2[4], jArr3, 6);
        implMulwAcc(jArr4, jArr[0] ^ jArr[7], jArr2[0] ^ jArr2[7], jArr3, 7);
        implMulwAcc(jArr4, jArr[1] ^ jArr[6], jArr2[1] ^ jArr2[6], jArr3, 7);
        implMulwAcc(jArr4, jArr[2] ^ jArr[5], jArr2[2] ^ jArr2[5], jArr3, 7);
        implMulwAcc(jArr4, jArr[3] ^ jArr[4], jArr2[3] ^ jArr2[4], jArr3, 7);
        implMulwAcc(jArr4, jArr[0] ^ jArr[8], jArr2[0] ^ jArr2[8], jArr3, 8);
        implMulwAcc(jArr4, jArr[1] ^ jArr[7], jArr2[1] ^ jArr2[7], jArr3, 8);
        implMulwAcc(jArr4, jArr[2] ^ jArr[6], jArr2[2] ^ jArr2[6], jArr3, 8);
        implMulwAcc(jArr4, jArr[3] ^ jArr[5], jArr2[3] ^ jArr2[5], jArr3, 8);
        implMulwAcc(jArr4, jArr[1] ^ jArr[8], jArr2[1] ^ jArr2[8], jArr3, 9);
        implMulwAcc(jArr4, jArr[2] ^ jArr[7], jArr2[2] ^ jArr2[7], jArr3, 9);
        implMulwAcc(jArr4, jArr[3] ^ jArr[6], jArr2[3] ^ jArr2[6], jArr3, 9);
        implMulwAcc(jArr4, jArr[4] ^ jArr[5], jArr2[4] ^ jArr2[5], jArr3, 9);
        implMulwAcc(jArr4, jArr[2] ^ jArr[8], jArr2[2] ^ jArr2[8], jArr3, 10);
        implMulwAcc(jArr4, jArr[3] ^ jArr[7], jArr2[3] ^ jArr2[7], jArr3, 10);
        implMulwAcc(jArr4, jArr[4] ^ jArr[6], jArr2[4] ^ jArr2[6], jArr3, 10);
        implMulwAcc(jArr4, jArr[3] ^ jArr[8], jArr2[3] ^ jArr2[8], jArr3, 11);
        implMulwAcc(jArr4, jArr[4] ^ jArr[7], jArr2[4] ^ jArr2[7], jArr3, 11);
        implMulwAcc(jArr4, jArr[5] ^ jArr[6], jArr2[5] ^ jArr2[6], jArr3, 11);
        implMulwAcc(jArr4, jArr[4] ^ jArr[8], jArr2[4] ^ jArr2[8], jArr3, 12);
        implMulwAcc(jArr4, jArr[5] ^ jArr[7], jArr2[5] ^ jArr2[7], jArr3, 12);
        implMulwAcc(jArr4, jArr[5] ^ jArr[8], jArr2[5] ^ jArr2[8], jArr3, 13);
        implMulwAcc(jArr4, jArr[6] ^ jArr[7], jArr2[6] ^ jArr2[7], jArr3, 13);
        implMulwAcc(jArr4, jArr[6] ^ jArr[8], jArr2[6] ^ jArr2[8], jArr3, 14);
        implMulwAcc(jArr4, jArr[7] ^ jArr[8], jArr2[7] ^ jArr2[8], jArr3, 15);
    }

    public static void implMultiplyPrecomp(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i11 = 56; i11 >= 0; i11 -= 8) {
            for (int i12 = 1; i12 < 9; i12 += 2) {
                int i13 = (int) (jArr[i12] >>> i11);
                addBothTo(jArr2, (i13 & 15) * 9, jArr2, (((i13 >>> 4) & 15) + 16) * 9, jArr3, i12 - 1);
            }
            Nat.shiftUpBits64(16, jArr3, 0, 8, 0);
        }
        for (int i14 = 56; i14 >= 0; i14 -= 8) {
            for (int i15 = 0; i15 < 9; i15 += 2) {
                int i16 = (int) (jArr[i15] >>> i14);
                int i17 = (((i16 >>> 4) & 15) + 16) * 9;
                addBothTo(jArr2, (i16 & 15) * 9, jArr2, i17, jArr3, i15);
            }
            if (i14 > 0) {
                Nat.shiftUpBits64(18, jArr3, 0, 8, 0);
            }
        }
    }

    public static void implMulwAcc(long[] jArr, long j11, long j12, long[] jArr2, int i11) {
        long j13 = j11;
        jArr[1] = j12;
        for (int i12 = 2; i12 < 16; i12 += 2) {
            jArr[i12] = jArr[i12 >>> 1] << 1;
            jArr[i12 + 1] = jArr[i12] ^ j12;
        }
        int i13 = (int) j13;
        long j14 = 0;
        long j15 = jArr[i13 & 15] ^ (jArr[(i13 >>> 4) & 15] << 4);
        int i14 = 56;
        do {
            int i15 = (int) (j13 >>> i14);
            long j16 = jArr[i15 & 15] ^ (jArr[(i15 >>> 4) & 15] << 4);
            j15 ^= j16 << i14;
            j14 ^= j16 >>> (-i14);
            i14 -= 8;
        } while (i14 > 0);
        for (int i16 = 0; i16 < 7; i16++) {
            j13 = (j13 & -72340172838076674L) >>> 1;
            j14 ^= ((j12 << i16) >> 63) & j13;
        }
        jArr2[i11] = jArr2[i11] ^ j15;
        int i17 = i11 + 1;
        jArr2[i17] = jArr2[i17] ^ j14;
    }

    public static void implSquare(long[] jArr, long[] jArr2) {
        Interleave.expand64To128(jArr, 0, 9, jArr2, 0);
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (!Nat576.isZero64(jArr)) {
            long[] create64 = Nat576.create64();
            long[] create642 = Nat576.create64();
            long[] create643 = Nat576.create64();
            square(jArr, create643);
            square(create643, create64);
            square(create64, create642);
            multiply(create64, create642, create64);
            squareN(create64, 2, create642);
            multiply(create64, create642, create64);
            multiply(create64, create643, create64);
            squareN(create64, 5, create642);
            multiply(create64, create642, create64);
            squareN(create642, 5, create642);
            multiply(create64, create642, create64);
            squareN(create64, 15, create642);
            multiply(create64, create642, create643);
            squareN(create643, 30, create64);
            squareN(create64, 30, create642);
            multiply(create64, create642, create64);
            squareN(create64, 60, create642);
            multiply(create64, create642, create64);
            squareN(create642, 60, create642);
            multiply(create64, create642, create64);
            squareN(create64, 180, create642);
            multiply(create64, create642, create64);
            squareN(create642, 180, create642);
            multiply(create64, create642, create64);
            multiply(create64, create643, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat576.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        reduce(createExt64, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat576.createExt64();
        implMultiply(jArr, jArr2, createExt64);
        addExt(jArr3, createExt64, jArr3);
    }

    public static void multiplyPrecomp(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat576.createExt64();
        implMultiplyPrecomp(jArr, jArr2, createExt64);
        reduce(createExt64, jArr3);
    }

    public static void multiplyPrecompAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] createExt64 = Nat576.createExt64();
        implMultiplyPrecomp(jArr, jArr2, createExt64);
        addExt(jArr3, createExt64, jArr3);
    }

    public static long[] precompMultiplicand(long[] jArr) {
        long[] jArr2 = new long[288];
        int i11 = 0;
        System.arraycopy(jArr, 0, jArr2, 9, 9);
        int i12 = 7;
        while (i12 > 0) {
            int i13 = i11 + 18;
            Nat.shiftUpBit64(9, jArr2, i13 >>> 1, 0, jArr2, i13);
            reduce5(jArr2, i13);
            add(jArr2, 9, jArr2, i13, jArr2, i13 + 9);
            i12--;
            i11 = i13;
        }
        Nat.shiftUpBits64(144, jArr2, 0, 4, 0, jArr2, 144);
        return jArr2;
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        long j11 = jArr[9];
        long j12 = jArr[17];
        long j13 = (((j11 ^ (j12 >>> 59)) ^ (j12 >>> 57)) ^ (j12 >>> 54)) ^ (j12 >>> 49);
        long j14 = (j12 << 15) ^ (((jArr[8] ^ (j12 << 5)) ^ (j12 << 7)) ^ (j12 << 10));
        for (int i11 = 16; i11 >= 10; i11--) {
            long j15 = jArr[i11];
            jArr2[i11 - 8] = (((j14 ^ (j15 >>> 59)) ^ (j15 >>> 57)) ^ (j15 >>> 54)) ^ (j15 >>> 49);
            j14 = (((jArr[i11 - 9] ^ (j15 << 5)) ^ (j15 << 7)) ^ (j15 << 10)) ^ (j15 << 15);
        }
        jArr2[1] = (((j14 ^ (j13 >>> 59)) ^ (j13 >>> 57)) ^ (j13 >>> 54)) ^ (j13 >>> 49);
        long j16 = (j13 << 15) ^ (((jArr[0] ^ (j13 << 5)) ^ (j13 << 7)) ^ (j13 << 10));
        long j17 = jArr2[8];
        long j18 = j17 >>> 59;
        jArr2[0] = (((j16 ^ j18) ^ (j18 << 2)) ^ (j18 << 5)) ^ (j18 << 10);
        jArr2[8] = M59 & j17;
    }

    public static void reduce5(long[] jArr, int i11) {
        int i12 = i11 + 8;
        long j11 = jArr[i12];
        long j12 = j11 >>> 59;
        jArr[i11] = ((j12 << 10) ^ (((j12 << 2) ^ j12) ^ (j12 << 5))) ^ jArr[i11];
        jArr[i12] = j11 & M59;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long[] create64 = Nat576.create64();
        long[] create642 = Nat576.create64();
        int i11 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            int i13 = i11 + 1;
            long unshuffle = Interleave.unshuffle(jArr[i11]);
            i11 = i13 + 1;
            long unshuffle2 = Interleave.unshuffle(jArr[i13]);
            create64[i12] = (4294967295L & unshuffle) | (unshuffle2 << 32);
            create642[i12] = (unshuffle >>> 32) | (-4294967296L & unshuffle2);
        }
        long unshuffle3 = Interleave.unshuffle(jArr[i11]);
        create64[4] = 4294967295L & unshuffle3;
        create642[4] = unshuffle3 >>> 32;
        multiply(create642, ROOT_Z, jArr2);
        add(jArr2, create64, jArr2);
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat576.createExt64();
        implSquare(jArr, createExt64);
        reduce(createExt64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat576.createExt64();
        implSquare(jArr, createExt64);
        addExt(jArr2, createExt64, jArr2);
    }

    public static void squareN(long[] jArr, int i11, long[] jArr2) {
        long[] createExt64 = Nat576.createExt64();
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
        return ((int) ((jArr[0] ^ (jArr[8] >>> 49)) ^ (jArr[8] >>> 57))) & 1;
    }
}
