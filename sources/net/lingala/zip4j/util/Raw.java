package net.lingala.zip4j.util;

import java.io.DataInput;
import java.io.IOException;
import java.util.Objects;
import net.lingala.zip4j.exception.ZipException;

public class Raw {
    public static byte[] a(char[] cArr) {
        Objects.requireNonNull(cArr);
        byte[] bArr = new byte[cArr.length];
        for (int i11 = 0; i11 < cArr.length; i11++) {
            bArr[i11] = (byte) cArr[i11];
        }
        return bArr;
    }

    public static void b(byte[] bArr, int i11, int i12) {
        bArr[0] = (byte) i11;
        bArr[1] = (byte) (i11 >> 8);
        bArr[2] = (byte) (i11 >> 16);
        bArr[3] = (byte) (i11 >> 24);
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        bArr[7] = 0;
        bArr[8] = 0;
        bArr[9] = 0;
        bArr[10] = 0;
        bArr[11] = 0;
        bArr[12] = 0;
        bArr[13] = 0;
        bArr[14] = 0;
        bArr[15] = 0;
    }

    public static int c(byte[] bArr, int i11) {
        return ((((bArr[i11 + 3] & 255) << 8) | (bArr[i11 + 2] & 255)) << 16) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8);
    }

    public static int d(DataInput dataInput, byte[] bArr) throws ZipException {
        try {
            dataInput.readFully(bArr, 0, 4);
            return (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16);
        } catch (IOException e11) {
            throw new ZipException((Throwable) e11);
        }
    }

    public static long e(byte[] bArr, int i11) {
        return ((long) (bArr[i11] & 255)) | ((((((((((((((((long) (bArr[i11 + 7] & 255)) | 0) << 8) | ((long) (bArr[i11 + 6] & 255))) << 8) | ((long) (bArr[i11 + 5] & 255))) << 8) | ((long) (bArr[i11 + 4] & 255))) << 8) | ((long) (bArr[i11 + 3] & 255))) << 8) | ((long) (bArr[i11 + 2] & 255))) << 8) | ((long) (bArr[i11 + 1] & 255))) << 8);
    }

    public static final short f(byte[] bArr, int i11) {
        return (short) ((bArr[i11 + 1] & 255) | ((short) (((short) ((bArr[i11] & 255) | 0)) << 8)));
    }

    public static int g(byte[] bArr, int i11) {
        return ((bArr[i11 + 1] & 255) << 8) | (bArr[i11] & 255);
    }
}
