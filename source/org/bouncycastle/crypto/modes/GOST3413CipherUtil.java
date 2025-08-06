package org.bouncycastle.crypto.modes;

import org.bouncycastle.util.Arrays;

class GOST3413CipherUtil {
    public static byte[] LSB(byte[] bArr, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, bArr.length - i11, bArr2, 0, i11);
        return bArr2;
    }

    public static byte[] MSB(byte[] bArr, int i11) {
        return Arrays.copyOf(bArr, i11);
    }

    public static byte[] copyFromInput(byte[] bArr, int i11, int i12) {
        if (bArr.length < i11 + i12) {
            i11 = bArr.length - i12;
        }
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i12, bArr2, 0, i11);
        return bArr2;
    }

    public static byte[] sum(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr3[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
        }
        return bArr3;
    }
}
