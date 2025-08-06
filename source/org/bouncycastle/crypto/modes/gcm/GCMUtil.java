package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.util.Longs;
import org.bouncycastle.util.Pack;

public abstract class GCMUtil {
    private static final int E1 = -520093696;
    private static final long E1L = -2233785415175766016L;
    public static final int SIZE_BYTES = 16;
    public static final int SIZE_INTS = 4;
    public static final int SIZE_LONGS = 2;

    public static byte areEqual(byte[] bArr, byte[] bArr2) {
        byte b11 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            b11 |= bArr[i11] ^ bArr2[i11];
        }
        return (byte) ((((b11 >>> 1) | (b11 & 1)) - 1) >> 31);
    }

    public static int areEqual(int[] iArr, int[] iArr2) {
        int i11 = iArr[2];
        int i12 = (iArr[3] ^ iArr2[3]) | 0 | (iArr[0] ^ iArr2[0]) | (iArr[1] ^ iArr2[1]) | (iArr2[2] ^ i11);
        return (((i12 & 1) | (i12 >>> 1)) - 1) >> 31;
    }

    public static long areEqual(long[] jArr, long[] jArr2) {
        long j11 = (jArr2[1] ^ jArr[1]) | (jArr[0] ^ jArr2[0]) | 0;
        return (((j11 & 1) | (j11 >>> 1)) - 1) >> 63;
    }

    public static void asBytes(int[] iArr, byte[] bArr) {
        Pack.intToBigEndian(iArr, 0, 4, bArr, 0);
    }

    public static void asBytes(long[] jArr, byte[] bArr) {
        Pack.longToBigEndian(jArr, 0, 2, bArr, 0);
    }

    public static byte[] asBytes(int[] iArr) {
        byte[] bArr = new byte[16];
        Pack.intToBigEndian(iArr, 0, 4, bArr, 0);
        return bArr;
    }

    public static byte[] asBytes(long[] jArr) {
        byte[] bArr = new byte[16];
        Pack.longToBigEndian(jArr, 0, 2, bArr, 0);
        return bArr;
    }

    public static void asInts(byte[] bArr, int[] iArr) {
        Pack.bigEndianToInt(bArr, 0, iArr, 0, 4);
    }

    public static int[] asInts(byte[] bArr) {
        int[] iArr = new int[4];
        Pack.bigEndianToInt(bArr, 0, iArr, 0, 4);
        return iArr;
    }

    public static void asLongs(byte[] bArr, long[] jArr) {
        Pack.bigEndianToLong(bArr, 0, jArr, 0, 2);
    }

    public static long[] asLongs(byte[] bArr) {
        long[] jArr = new long[2];
        Pack.bigEndianToLong(bArr, 0, jArr, 0, 2);
        return jArr;
    }

    public static void copy(byte[] bArr, byte[] bArr2) {
        for (int i11 = 0; i11 < 16; i11++) {
            bArr2[i11] = bArr[i11];
        }
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
    }

    public static void copy(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
    }

    public static void divideP(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = j11 >> 63;
        jArr2[0] = ((j11 ^ (E1L & j13)) << 1) | (j12 >>> 63);
        jArr2[1] = (j12 << 1) | (-j13);
    }

    private static long implMul64(long j11, long j12) {
        long j13 = j11 & 1229782938247303441L;
        long j14 = j11 & 2459565876494606882L;
        long j15 = j11 & 4919131752989213764L;
        long j16 = j11 & -8608480567731124088L;
        long j17 = j12 & 1229782938247303441L;
        long j18 = j12 & 2459565876494606882L;
        long j19 = j12 & 4919131752989213764L;
        long j21 = j12 & -8608480567731124088L;
        return (((((j13 * j17) ^ (j14 * j21)) ^ (j15 * j19)) ^ (j16 * j18)) & 1229782938247303441L) | (((((j13 * j18) ^ (j14 * j17)) ^ (j15 * j21)) ^ (j16 * j19)) & 2459565876494606882L) | (((((j13 * j19) ^ (j14 * j18)) ^ (j15 * j17)) ^ (j16 * j21)) & 4919131752989213764L) | (((((j13 * j21) ^ (j14 * j19)) ^ (j15 * j18)) ^ (j16 * j17)) & -8608480567731124088L);
    }

    public static void multiply(byte[] bArr, byte[] bArr2) {
        long[] asLongs = asLongs(bArr);
        multiply(asLongs, asLongs(bArr2));
        asBytes(asLongs, bArr);
    }

    public static void multiply(byte[] bArr, long[] jArr) {
        byte[] bArr2 = bArr;
        long bigEndianToLong = Pack.bigEndianToLong(bArr2, 0);
        long bigEndianToLong2 = Pack.bigEndianToLong(bArr2, 8);
        long j11 = jArr[0];
        long j12 = jArr[1];
        long reverse = Longs.reverse(bigEndianToLong);
        long reverse2 = Longs.reverse(bigEndianToLong2);
        long reverse3 = Longs.reverse(j11);
        long reverse4 = Longs.reverse(j12);
        long reverse5 = Longs.reverse(implMul64(reverse, reverse3));
        long j13 = bigEndianToLong;
        long implMul64 = implMul64(j13, j11) << 1;
        long reverse6 = Longs.reverse(implMul64(reverse2, reverse4));
        long j14 = bigEndianToLong2;
        long implMul642 = implMul64(j14, j12) << 1;
        long implMul643 = ((implMul64(j13 ^ j14, j11 ^ j12) << 1) ^ ((reverse6 ^ implMul64) ^ implMul642)) ^ ((implMul642 << 62) ^ (implMul642 << 57));
        long j15 = implMul643 >>> 7;
        Pack.longToBigEndian(reverse5 ^ (j15 ^ (((implMul643 >>> 1) ^ implMul643) ^ (implMul643 >>> 2))), bArr2, 0);
        Pack.longToBigEndian(((Longs.reverse(implMul64(reverse ^ reverse2, reverse3 ^ reverse4)) ^ ((implMul64 ^ reverse5) ^ reverse6)) ^ (((implMul642 ^ (implMul642 >>> 1)) ^ (implMul642 >>> 2)) ^ (implMul642 >>> 7))) ^ ((implMul643 << 57) ^ ((implMul643 << 63) ^ (implMul643 << 62))), bArr2, 8);
    }

    public static void multiply(int[] iArr, int[] iArr2) {
        int i11 = iArr2[0];
        int i12 = iArr2[1];
        int i13 = iArr2[2];
        int i14 = iArr2[3];
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < 4; i19++) {
            int i21 = iArr[i19];
            for (int i22 = 0; i22 < 32; i22++) {
                int i23 = i21 >> 31;
                i21 <<= 1;
                i15 ^= i11 & i23;
                i16 ^= i12 & i23;
                i17 ^= i13 & i23;
                i18 ^= i23 & i14;
                i14 = (i14 >>> 1) | (i13 << 31);
                i13 = (i13 >>> 1) | (i12 << 31);
                i12 = (i12 >>> 1) | (i11 << 31);
                i11 = (i11 >>> 1) ^ (((i14 << 31) >> 8) & E1);
            }
        }
        iArr[0] = i15;
        iArr[1] = i16;
        iArr[2] = i17;
        iArr[3] = i18;
    }

    public static void multiply(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = jArr2[0];
        long j14 = jArr2[1];
        long reverse = Longs.reverse(j11);
        long reverse2 = Longs.reverse(j12);
        long reverse3 = Longs.reverse(j13);
        long reverse4 = Longs.reverse(j14);
        long reverse5 = Longs.reverse(implMul64(reverse, reverse3));
        long implMul64 = implMul64(j11, j13) << 1;
        long reverse6 = Longs.reverse(implMul64(reverse2, reverse4));
        long j15 = j12;
        long implMul642 = implMul64(j15, j14) << 1;
        long implMul643 = ((implMul64(j11 ^ j15, j13 ^ j14) << 1) ^ ((reverse6 ^ implMul64) ^ implMul642)) ^ ((implMul642 << 62) ^ (implMul642 << 57));
        long j16 = implMul643 >>> 7;
        long j17 = (implMul643 << 57) ^ ((implMul643 << 63) ^ (implMul643 << 62));
        jArr[0] = reverse5 ^ (j16 ^ ((implMul643 ^ (implMul643 >>> 1)) ^ (implMul643 >>> 2)));
        jArr[1] = j17 ^ ((Longs.reverse(implMul64(reverse ^ reverse2, reverse3 ^ reverse4)) ^ ((implMul64 ^ reverse5) ^ reverse6)) ^ (((implMul642 ^ (implMul642 >>> 1)) ^ (implMul642 >>> 2)) ^ (implMul642 >>> 7)));
    }

    public static void multiplyP(int[] iArr) {
        int i11 = iArr[0];
        int i12 = iArr[1];
        int i13 = iArr[2];
        int i14 = iArr[3];
        iArr[0] = (((i14 << 31) >> 31) & E1) ^ (i11 >>> 1);
        iArr[1] = (i12 >>> 1) | (i11 << 31);
        iArr[2] = (i13 >>> 1) | (i12 << 31);
        iArr[3] = (i14 >>> 1) | (i13 << 31);
    }

    public static void multiplyP(int[] iArr, int[] iArr2) {
        int i11 = iArr[0];
        int i12 = iArr[1];
        int i13 = iArr[2];
        int i14 = iArr[3];
        iArr2[0] = (((i14 << 31) >> 31) & E1) ^ (i11 >>> 1);
        iArr2[1] = (i12 >>> 1) | (i11 << 31);
        iArr2[2] = (i13 >>> 1) | (i12 << 31);
        iArr2[3] = (i14 >>> 1) | (i13 << 31);
    }

    public static void multiplyP(long[] jArr) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        jArr[0] = (((j12 << 63) >> 63) & E1L) ^ (j11 >>> 1);
        jArr[1] = (j11 << 63) | (j12 >>> 1);
    }

    public static void multiplyP(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        jArr2[0] = (((j12 << 63) >> 63) & E1L) ^ (j11 >>> 1);
        jArr2[1] = (j11 << 63) | (j12 >>> 1);
    }

    public static void multiplyP16(long[] jArr) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = j12 << 48;
        jArr[0] = (j13 >>> 7) ^ ((((j11 >>> 16) ^ j13) ^ (j13 >>> 1)) ^ (j13 >>> 2));
        jArr[1] = (j11 << 48) | (j12 >>> 16);
    }

    public static void multiplyP3(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = j12 << 61;
        jArr2[0] = (j13 >>> 7) ^ ((((j11 >>> 3) ^ j13) ^ (j13 >>> 1)) ^ (j13 >>> 2));
        jArr2[1] = (j11 << 61) | (j12 >>> 3);
    }

    public static void multiplyP4(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = j12 << 60;
        jArr2[0] = (j13 >>> 7) ^ ((((j11 >>> 4) ^ j13) ^ (j13 >>> 1)) ^ (j13 >>> 2));
        jArr2[1] = (j11 << 60) | (j12 >>> 4);
    }

    public static void multiplyP7(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = j12 << 57;
        jArr2[0] = (j13 >>> 7) ^ ((((j11 >>> 7) ^ j13) ^ (j13 >>> 1)) ^ (j13 >>> 2));
        jArr2[1] = (j11 << 57) | (j12 >>> 7);
    }

    public static void multiplyP8(int[] iArr) {
        int i11 = iArr[0];
        int i12 = iArr[1];
        int i13 = iArr[2];
        int i14 = iArr[3];
        int i15 = i14 << 24;
        iArr[0] = (i15 >>> 7) ^ ((((i11 >>> 8) ^ i15) ^ (i15 >>> 1)) ^ (i15 >>> 2));
        iArr[1] = (i12 >>> 8) | (i11 << 24);
        iArr[2] = (i13 >>> 8) | (i12 << 24);
        iArr[3] = (i14 >>> 8) | (i13 << 24);
    }

    public static void multiplyP8(int[] iArr, int[] iArr2) {
        int i11 = iArr[0];
        int i12 = iArr[1];
        int i13 = iArr[2];
        int i14 = iArr[3];
        int i15 = i14 << 24;
        iArr2[0] = (i15 >>> 7) ^ ((((i11 >>> 8) ^ i15) ^ (i15 >>> 1)) ^ (i15 >>> 2));
        iArr2[1] = (i12 >>> 8) | (i11 << 24);
        iArr2[2] = (i13 >>> 8) | (i12 << 24);
        iArr2[3] = (i14 >>> 8) | (i13 << 24);
    }

    public static void multiplyP8(long[] jArr) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = j12 << 56;
        jArr[0] = (j13 >>> 7) ^ ((((j11 >>> 8) ^ j13) ^ (j13 >>> 1)) ^ (j13 >>> 2));
        jArr[1] = (j11 << 56) | (j12 >>> 8);
    }

    public static void multiplyP8(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = j12 << 56;
        jArr2[0] = (j13 >>> 7) ^ ((((j11 >>> 8) ^ j13) ^ (j13 >>> 1)) ^ (j13 >>> 2));
        jArr2[1] = (j11 << 56) | (j12 >>> 8);
    }

    public static byte[] oneAsBytes() {
        byte[] bArr = new byte[16];
        bArr[0] = Byte.MIN_VALUE;
        return bArr;
    }

    public static int[] oneAsInts() {
        int[] iArr = new int[4];
        iArr[0] = Integer.MIN_VALUE;
        return iArr;
    }

    public static long[] oneAsLongs() {
        long[] jArr = new long[2];
        jArr[0] = Long.MIN_VALUE;
        return jArr;
    }

    public static long[] pAsLongs() {
        long[] jArr = new long[2];
        jArr[0] = 4611686018427387904L;
        return jArr;
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[4];
        Interleave.expand64To128Rev(jArr[0], jArr3, 0);
        Interleave.expand64To128Rev(jArr[1], jArr3, 2);
        long j11 = jArr3[0];
        long j12 = jArr3[1];
        long j13 = jArr3[2];
        long j14 = jArr3[3];
        long j15 = j13 ^ ((j14 << 57) ^ ((j14 << 63) ^ (j14 << 62)));
        long j16 = j11 ^ ((((j15 >>> 1) ^ j15) ^ (j15 >>> 2)) ^ (j15 >>> 7));
        jArr2[0] = j16;
        jArr2[1] = (j12 ^ ((((j14 >>> 1) ^ j14) ^ (j14 >>> 2)) ^ (j14 >>> 7))) ^ ((j15 << 57) ^ ((j15 << 63) ^ (j15 << 62)));
    }

    public static void xor(byte[] bArr, int i11, byte[] bArr2, int i12, int i13) {
        while (true) {
            i13--;
            if (i13 >= 0) {
                int i14 = i11 + i13;
                bArr[i14] = (byte) (bArr[i14] ^ bArr2[i12 + i13]);
            } else {
                return;
            }
        }
    }

    public static void xor(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, int i13) {
        int i14 = 0;
        do {
            bArr3[i13 + i14] = (byte) (bArr[i11 + i14] ^ bArr2[i12 + i14]);
            int i15 = i14 + 1;
            bArr3[i13 + i15] = (byte) (bArr[i11 + i15] ^ bArr2[i12 + i15]);
            int i16 = i15 + 1;
            bArr3[i13 + i16] = (byte) (bArr[i11 + i16] ^ bArr2[i12 + i16]);
            int i17 = i16 + 1;
            bArr3[i13 + i17] = (byte) (bArr[i11 + i17] ^ bArr2[i12 + i17]);
            i14 = i17 + 1;
        } while (i14 < 16);
    }

    public static void xor(byte[] bArr, byte[] bArr2) {
        int i11 = 0;
        do {
            bArr[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
            int i12 = i11 + 1;
            bArr[i12] = (byte) (bArr[i12] ^ bArr2[i12]);
            int i13 = i12 + 1;
            bArr[i13] = (byte) (bArr[i13] ^ bArr2[i13]);
            int i14 = i13 + 1;
            bArr[i14] = (byte) (bArr[i14] ^ bArr2[i14]);
            i11 = i14 + 1;
        } while (i11 < 16);
    }

    public static void xor(byte[] bArr, byte[] bArr2, int i11) {
        int i12 = 0;
        do {
            bArr[i12] = (byte) (bArr[i12] ^ bArr2[i11 + i12]);
            int i13 = i12 + 1;
            bArr[i13] = (byte) (bArr[i13] ^ bArr2[i11 + i13]);
            int i14 = i13 + 1;
            bArr[i14] = (byte) (bArr[i14] ^ bArr2[i11 + i14]);
            int i15 = i14 + 1;
            bArr[i15] = (byte) (bArr[i15] ^ bArr2[i11 + i15]);
            i12 = i15 + 1;
        } while (i12 < 16);
    }

    public static void xor(byte[] bArr, byte[] bArr2, int i11, int i12) {
        while (true) {
            i12--;
            if (i12 >= 0) {
                bArr[i12] = (byte) (bArr[i12] ^ bArr2[i11 + i12]);
            } else {
                return;
            }
        }
    }

    public static void xor(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i11 = 0;
        do {
            bArr3[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
            int i12 = i11 + 1;
            bArr3[i12] = (byte) (bArr[i12] ^ bArr2[i12]);
            int i13 = i12 + 1;
            bArr3[i13] = (byte) (bArr[i13] ^ bArr2[i13]);
            int i14 = i13 + 1;
            bArr3[i14] = (byte) (bArr[i14] ^ bArr2[i14]);
            i11 = i14 + 1;
        } while (i11 < 16);
    }

    public static void xor(int[] iArr, int[] iArr2) {
        iArr[0] = iArr[0] ^ iArr2[0];
        iArr[1] = iArr[1] ^ iArr2[1];
        iArr[2] = iArr[2] ^ iArr2[2];
        iArr[3] = iArr2[3] ^ iArr[3];
    }

    public static void xor(int[] iArr, int[] iArr2, int[] iArr3) {
        iArr3[0] = iArr[0] ^ iArr2[0];
        iArr3[1] = iArr[1] ^ iArr2[1];
        iArr3[2] = iArr[2] ^ iArr2[2];
        iArr3[3] = iArr[3] ^ iArr2[3];
    }

    public static void xor(long[] jArr, long[] jArr2) {
        jArr[0] = jArr[0] ^ jArr2[0];
        jArr[1] = jArr[1] ^ jArr2[1];
    }

    public static void xor(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr2[1] ^ jArr[1];
    }
}
