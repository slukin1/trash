package org.bouncycastle.crypto.util;

import com.google.common.base.Ascii;

public abstract class Pack {
    public static int bigEndianToInt(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        return (bArr[i13 + 1] & 255) | (bArr[i11] << Ascii.CAN) | ((bArr[i12] & 255) << 16) | ((bArr[i13] & 255) << 8);
    }

    public static void bigEndianToInt(byte[] bArr, int i11, int[] iArr) {
        for (int i12 = 0; i12 < iArr.length; i12++) {
            iArr[i12] = bigEndianToInt(bArr, i11);
            i11 += 4;
        }
    }

    public static long bigEndianToLong(byte[] bArr, int i11) {
        int bigEndianToInt = bigEndianToInt(bArr, i11);
        return (((long) bigEndianToInt(bArr, i11 + 4)) & 4294967295L) | ((((long) bigEndianToInt) & 4294967295L) << 32);
    }

    public static void bigEndianToLong(byte[] bArr, int i11, long[] jArr) {
        for (int i12 = 0; i12 < jArr.length; i12++) {
            jArr[i12] = bigEndianToLong(bArr, i11);
            i11 += 8;
        }
    }

    public static void intToBigEndian(int i11, byte[] bArr, int i12) {
        bArr[i12] = (byte) (i11 >>> 24);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i11 >>> 16);
        int i14 = i13 + 1;
        bArr[i14] = (byte) (i11 >>> 8);
        bArr[i14 + 1] = (byte) i11;
    }

    public static void intToBigEndian(int[] iArr, byte[] bArr, int i11) {
        for (int intToBigEndian : iArr) {
            intToBigEndian(intToBigEndian, bArr, i11);
            i11 += 4;
        }
    }

    public static byte[] intToBigEndian(int i11) {
        byte[] bArr = new byte[4];
        intToBigEndian(i11, bArr, 0);
        return bArr;
    }

    public static byte[] intToBigEndian(int[] iArr) {
        byte[] bArr = new byte[(iArr.length * 4)];
        intToBigEndian(iArr, bArr, 0);
        return bArr;
    }

    public static void intToLittleEndian(int i11, byte[] bArr, int i12) {
        bArr[i12] = (byte) i11;
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i11 >>> 8);
        int i14 = i13 + 1;
        bArr[i14] = (byte) (i11 >>> 16);
        bArr[i14 + 1] = (byte) (i11 >>> 24);
    }

    public static void intToLittleEndian(int[] iArr, byte[] bArr, int i11) {
        for (int intToLittleEndian : iArr) {
            intToLittleEndian(intToLittleEndian, bArr, i11);
            i11 += 4;
        }
    }

    public static byte[] intToLittleEndian(int i11) {
        byte[] bArr = new byte[4];
        intToLittleEndian(i11, bArr, 0);
        return bArr;
    }

    public static byte[] intToLittleEndian(int[] iArr) {
        byte[] bArr = new byte[(iArr.length * 4)];
        intToLittleEndian(iArr, bArr, 0);
        return bArr;
    }

    public static int littleEndianToInt(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        return (bArr[i13 + 1] << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i12] & 255) << 8) | ((bArr[i13] & 255) << 16);
    }

    public static void littleEndianToInt(byte[] bArr, int i11, int[] iArr) {
        for (int i12 = 0; i12 < iArr.length; i12++) {
            iArr[i12] = littleEndianToInt(bArr, i11);
            i11 += 4;
        }
    }

    public static void littleEndianToInt(byte[] bArr, int i11, int[] iArr, int i12, int i13) {
        for (int i14 = 0; i14 < i13; i14++) {
            iArr[i12 + i14] = littleEndianToInt(bArr, i11);
            i11 += 4;
        }
    }

    public static long littleEndianToLong(byte[] bArr, int i11) {
        return ((((long) littleEndianToInt(bArr, i11 + 4)) & 4294967295L) << 32) | (((long) littleEndianToInt(bArr, i11)) & 4294967295L);
    }

    public static void littleEndianToLong(byte[] bArr, int i11, long[] jArr) {
        for (int i12 = 0; i12 < jArr.length; i12++) {
            jArr[i12] = littleEndianToLong(bArr, i11);
            i11 += 8;
        }
    }

    public static void longToBigEndian(long j11, byte[] bArr, int i11) {
        intToBigEndian((int) (j11 >>> 32), bArr, i11);
        intToBigEndian((int) (j11 & 4294967295L), bArr, i11 + 4);
    }

    public static void longToBigEndian(long[] jArr, byte[] bArr, int i11) {
        for (long longToBigEndian : jArr) {
            longToBigEndian(longToBigEndian, bArr, i11);
            i11 += 8;
        }
    }

    public static byte[] longToBigEndian(long j11) {
        byte[] bArr = new byte[8];
        longToBigEndian(j11, bArr, 0);
        return bArr;
    }

    public static byte[] longToBigEndian(long[] jArr) {
        byte[] bArr = new byte[(jArr.length * 8)];
        longToBigEndian(jArr, bArr, 0);
        return bArr;
    }

    public static void longToLittleEndian(long j11, byte[] bArr, int i11) {
        intToLittleEndian((int) (4294967295L & j11), bArr, i11);
        intToLittleEndian((int) (j11 >>> 32), bArr, i11 + 4);
    }

    public static void longToLittleEndian(long[] jArr, byte[] bArr, int i11) {
        for (long longToLittleEndian : jArr) {
            longToLittleEndian(longToLittleEndian, bArr, i11);
            i11 += 8;
        }
    }

    public static byte[] longToLittleEndian(long j11) {
        byte[] bArr = new byte[8];
        longToLittleEndian(j11, bArr, 0);
        return bArr;
    }

    public static byte[] longToLittleEndian(long[] jArr) {
        byte[] bArr = new byte[(jArr.length * 8)];
        longToLittleEndian(jArr, bArr, 0);
        return bArr;
    }
}
