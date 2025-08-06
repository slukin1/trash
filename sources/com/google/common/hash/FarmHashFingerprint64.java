package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    public static final HashFunction FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();
    private static final long K0 = -4348849565147123417L;
    private static final long K1 = -5435081209227447693L;
    private static final long K2 = -7286425919675154353L;

    @VisibleForTesting
    public static long fingerprint(byte[] bArr, int i11, int i12) {
        if (i12 <= 32) {
            if (i12 <= 16) {
                return hashLength0to16(bArr, i11, i12);
            }
            return hashLength17to32(bArr, i11, i12);
        } else if (i12 <= 64) {
            return hashLength33To64(bArr, i11, i12);
        } else {
            return hashLength65Plus(bArr, i11, i12);
        }
    }

    private static long hashLength0to16(byte[] bArr, int i11, int i12) {
        if (i12 >= 8) {
            long j11 = ((long) (i12 * 2)) + K2;
            long load64 = LittleEndianByteArray.load64(bArr, i11) + K2;
            long load642 = LittleEndianByteArray.load64(bArr, (i11 + i12) - 8);
            return hashLength16((Long.rotateRight(load642, 37) * j11) + load64, (Long.rotateRight(load64, 25) + load642) * j11, j11);
        } else if (i12 >= 4) {
            return hashLength16(((long) i12) + ((((long) LittleEndianByteArray.load32(bArr, i11)) & 4294967295L) << 3), ((long) LittleEndianByteArray.load32(bArr, (i11 + i12) - 4)) & 4294967295L, ((long) (i12 * 2)) + K2);
        } else if (i12 <= 0) {
            return K2;
        } else {
            return shiftMix((((long) ((bArr[i11] & 255) + ((bArr[(i12 >> 1) + i11] & 255) << 8))) * K2) ^ (((long) (i12 + ((bArr[i11 + (i12 - 1)] & 255) << 2))) * K0)) * K2;
        }
    }

    private static long hashLength16(long j11, long j12, long j13) {
        long j14 = (j11 ^ j12) * j13;
        long j15 = ((j14 ^ (j14 >>> 47)) ^ j12) * j13;
        return (j15 ^ (j15 >>> 47)) * j13;
    }

    private static long hashLength17to32(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = bArr;
        long j11 = ((long) (i12 * 2)) + K2;
        long load64 = LittleEndianByteArray.load64(bArr, i11) * K1;
        long load642 = LittleEndianByteArray.load64(bArr2, i11 + 8);
        int i13 = i11 + i12;
        long load643 = LittleEndianByteArray.load64(bArr2, i13 - 8) * j11;
        return hashLength16((LittleEndianByteArray.load64(bArr2, i13 - 16) * K2) + Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30), load64 + Long.rotateRight(load642 + K2, 18) + load643, j11);
    }

    private static long hashLength33To64(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = bArr;
        long j11 = ((long) (i12 * 2)) + K2;
        long load64 = LittleEndianByteArray.load64(bArr, i11) * K2;
        long load642 = LittleEndianByteArray.load64(bArr2, i11 + 8);
        int i13 = i11 + i12;
        long load643 = LittleEndianByteArray.load64(bArr2, i13 - 8) * j11;
        long rotateRight = Long.rotateRight(load64 + load642, 43) + Long.rotateRight(load643, 30) + (LittleEndianByteArray.load64(bArr2, i13 - 16) * K2);
        long hashLength16 = hashLength16(rotateRight, load643 + Long.rotateRight(load642 + K2, 18) + load64, j11);
        long load644 = LittleEndianByteArray.load64(bArr2, i11 + 16) * j11;
        long load645 = LittleEndianByteArray.load64(bArr2, i11 + 24);
        long load646 = (rotateRight + LittleEndianByteArray.load64(bArr2, i13 - 32)) * j11;
        return hashLength16(((hashLength16 + LittleEndianByteArray.load64(bArr2, i13 - 24)) * j11) + Long.rotateRight(load644 + load645, 43) + Long.rotateRight(load646, 30), load644 + Long.rotateRight(load645 + load64, 18) + load646, j11);
    }

    private static long hashLength65Plus(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = bArr;
        long shiftMix = shiftMix(-7956866745689871395L) * K2;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long load64 = 95310865018149119L + LittleEndianByteArray.load64(bArr, i11);
        int i13 = i12 - 1;
        int i14 = i11 + ((i13 / 64) * 64);
        int i15 = i13 & 63;
        int i16 = (i14 + i15) - 63;
        long j11 = 2480279821605975764L;
        int i17 = i11;
        while (true) {
            long rotateRight = Long.rotateRight(load64 + j11 + jArr[0] + LittleEndianByteArray.load64(bArr2, i17 + 8), 37) * K1;
            long rotateRight2 = Long.rotateRight(j11 + jArr[1] + LittleEndianByteArray.load64(bArr2, i17 + 48), 42) * K1;
            long j12 = rotateRight ^ jArr2[1];
            long load642 = rotateRight2 + jArr[0] + LittleEndianByteArray.load64(bArr2, i17 + 40);
            long rotateRight3 = Long.rotateRight(shiftMix + jArr2[0], 33) * K1;
            weakHashLength32WithSeeds(bArr, i17, jArr[1] * K1, j12 + jArr2[0], jArr);
            weakHashLength32WithSeeds(bArr, i17 + 32, rotateRight3 + jArr2[1], load642 + LittleEndianByteArray.load64(bArr2, i17 + 16), jArr2);
            i17 += 64;
            if (i17 == i14) {
                long j13 = ((j12 & 255) << 1) + K1;
                jArr2[0] = jArr2[0] + ((long) i15);
                jArr[0] = jArr[0] + jArr2[0];
                jArr2[0] = jArr2[0] + jArr[0];
                long rotateRight4 = (Long.rotateRight(((rotateRight3 + load642) + jArr[0]) + LittleEndianByteArray.load64(bArr2, i16 + 8), 37) * j13) ^ (jArr2[1] * 9);
                long rotateRight5 = (Long.rotateRight(load642 + jArr[1] + LittleEndianByteArray.load64(bArr2, i16 + 48), 42) * j13) + (jArr[0] * 9) + LittleEndianByteArray.load64(bArr2, i16 + 40);
                long rotateRight6 = Long.rotateRight(j12 + jArr2[0], 33) * j13;
                byte[] bArr3 = bArr;
                weakHashLength32WithSeeds(bArr3, i16, jArr[1] * j13, rotateRight4 + jArr2[0], jArr);
                weakHashLength32WithSeeds(bArr3, i16 + 32, rotateRight6 + jArr2[1], LittleEndianByteArray.load64(bArr2, i16 + 16) + rotateRight5, jArr2);
                long j14 = j13;
                return hashLength16(hashLength16(jArr[0], jArr2[0], j14) + (shiftMix(rotateRight5) * K0) + rotateRight4, hashLength16(jArr[1], jArr2[1], j14) + rotateRight6, j14);
            }
            shiftMix = j12;
            j11 = load642;
            load64 = rotateRight3;
        }
    }

    private static long shiftMix(long j11) {
        return j11 ^ (j11 >>> 47);
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i11, long j11, long j12, long[] jArr) {
        long load64 = LittleEndianByteArray.load64(bArr, i11);
        long load642 = LittleEndianByteArray.load64(bArr, i11 + 8);
        long load643 = LittleEndianByteArray.load64(bArr, i11 + 16);
        long load644 = LittleEndianByteArray.load64(bArr, i11 + 24);
        long j13 = j11 + load64;
        long j14 = load642 + j13 + load643;
        jArr[0] = j14 + load644;
        jArr[1] = Long.rotateRight(j12 + j13 + load644, 21) + Long.rotateRight(j14, 44) + j13;
    }

    public int bits() {
        return 64;
    }

    public HashCode hashBytes(byte[] bArr, int i11, int i12) {
        Preconditions.checkPositionIndexes(i11, i11 + i12, bArr.length);
        return HashCode.fromLong(fingerprint(bArr, i11, i12));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
