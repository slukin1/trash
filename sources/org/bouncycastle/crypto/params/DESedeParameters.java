package org.bouncycastle.crypto.params;

public class DESedeParameters extends DESParameters {
    public static final int DES_EDE_KEY_LENGTH = 24;

    public DESedeParameters(byte[] bArr) {
        super(bArr);
        if (isWeakKey(bArr, 0, bArr.length)) {
            throw new IllegalArgumentException("attempt to create weak DESede key");
        }
    }

    public static boolean isReal2Key(byte[] bArr, int i11) {
        boolean z11 = false;
        for (int i12 = i11; i12 != i11 + 8; i12++) {
            if (bArr[i12] != bArr[i12 + 8]) {
                z11 = true;
            }
        }
        return z11;
    }

    public static boolean isReal3Key(byte[] bArr, int i11) {
        int i12 = i11;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        while (true) {
            boolean z14 = true;
            if (i12 == i11 + 8) {
                break;
            }
            int i13 = i12 + 8;
            z11 |= bArr[i12] != bArr[i13];
            int i14 = i12 + 16;
            z12 |= bArr[i12] != bArr[i14];
            if (bArr[i13] == bArr[i14]) {
                z14 = false;
            }
            z13 |= z14;
            i12++;
        }
        return z11 && z12 && z13;
    }

    public static boolean isRealEDEKey(byte[] bArr, int i11) {
        return bArr.length == 16 ? isReal2Key(bArr, i11) : isReal3Key(bArr, i11);
    }

    public static boolean isWeakKey(byte[] bArr, int i11) {
        return isWeakKey(bArr, i11, bArr.length - i11);
    }

    public static boolean isWeakKey(byte[] bArr, int i11, int i12) {
        while (i11 < i12) {
            if (DESParameters.isWeakKey(bArr, i11)) {
                return true;
            }
            i11 += 8;
        }
        return false;
    }
}
