package org.bouncycastle.pqc.crypto.cmce;

import org.bouncycastle.util.Pack;

class Utils {
    public static short bitrev(short s11, int i11) {
        short s12 = (short) (((s11 & 65280) >> 8) | ((s11 & 255) << 8));
        short s13 = (short) (((s12 & 61680) >> 4) | ((s12 & 3855) << 4));
        short s14 = (short) (((s13 & 52428) >> 2) | ((s13 & 13107) << 2));
        short s15 = (short) (((s14 & 43690) >> 1) | ((s14 & 21845) << 1));
        return (short) (i11 == 12 ? s15 >> 4 : s15 >> 3);
    }

    public static int load4(byte[] bArr, int i11) {
        return Pack.littleEndianToInt(bArr, i11);
    }

    public static long load8(byte[] bArr, int i11) {
        return Pack.littleEndianToLong(bArr, i11);
    }

    public static short load_gf(byte[] bArr, int i11, int i12) {
        return (short) (Pack.littleEndianToShort(bArr, i11) & i12);
    }

    public static void store8(byte[] bArr, int i11, long j11) {
        bArr[i11 + 0] = (byte) ((int) ((j11 >> 0) & 255));
        bArr[i11 + 1] = (byte) ((int) ((j11 >> 8) & 255));
        bArr[i11 + 2] = (byte) ((int) ((j11 >> 16) & 255));
        bArr[i11 + 3] = (byte) ((int) ((j11 >> 24) & 255));
        bArr[i11 + 4] = (byte) ((int) ((j11 >> 32) & 255));
        bArr[i11 + 5] = (byte) ((int) ((j11 >> 40) & 255));
        bArr[i11 + 6] = (byte) ((int) ((j11 >> 48) & 255));
        bArr[i11 + 7] = (byte) ((int) ((j11 >> 56) & 255));
    }

    public static void store_gf(byte[] bArr, int i11, short s11) {
        bArr[i11 + 0] = (byte) (s11 & 255);
        bArr[i11 + 1] = (byte) (s11 >> 8);
    }
}
