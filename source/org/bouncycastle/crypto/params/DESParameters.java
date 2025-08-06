package org.bouncycastle.crypto.params;

import com.google.common.base.Ascii;
import net.sf.scuba.smartcards.ISO7816;

public class DESParameters extends KeyParameter {
    public static final int DES_KEY_LENGTH = 8;
    private static byte[] DES_weak_keys = {1, 1, 1, 1, 1, 1, 1, 1, Ascii.US, Ascii.US, Ascii.US, Ascii.US, 14, 14, 14, 14, ISO7816.INS_CREATE_FILE, ISO7816.INS_CREATE_FILE, ISO7816.INS_CREATE_FILE, ISO7816.INS_CREATE_FILE, -15, -15, -15, -15, -2, -2, -2, -2, -2, -2, -2, -2, 1, -2, 1, -2, 1, -2, 1, -2, Ascii.US, ISO7816.INS_CREATE_FILE, Ascii.US, ISO7816.INS_CREATE_FILE, 14, -15, 14, -15, 1, ISO7816.INS_CREATE_FILE, 1, ISO7816.INS_CREATE_FILE, 1, -15, 1, -15, Ascii.US, -2, Ascii.US, -2, 14, -2, 14, -2, 1, Ascii.US, 1, Ascii.US, 1, 14, 1, 14, ISO7816.INS_CREATE_FILE, -2, ISO7816.INS_CREATE_FILE, -2, -15, -2, -15, -2, -2, 1, -2, 1, -2, 1, -2, 1, ISO7816.INS_CREATE_FILE, Ascii.US, ISO7816.INS_CREATE_FILE, Ascii.US, -15, 14, -15, 14, ISO7816.INS_CREATE_FILE, 1, ISO7816.INS_CREATE_FILE, 1, -15, 1, -15, 1, -2, Ascii.US, -2, Ascii.US, -2, 14, -2, 14, Ascii.US, 1, Ascii.US, 1, 14, 1, 14, 1, -2, ISO7816.INS_CREATE_FILE, -2, ISO7816.INS_CREATE_FILE, -2, -15, -2, -15};
    private static final int N_DES_WEAK_KEYS = 16;

    public DESParameters(byte[] bArr) {
        super(bArr);
        if (isWeakKey(bArr, 0)) {
            throw new IllegalArgumentException("attempt to create weak DES key");
        }
    }

    public static boolean isWeakKey(byte[] bArr, int i11) {
        if (bArr.length - i11 >= 8) {
            int i12 = 0;
            while (i12 < 16) {
                int i13 = 0;
                while (i13 < 8) {
                    if (bArr[i13 + i11] != DES_weak_keys[(i12 * 8) + i13]) {
                        i12++;
                    } else {
                        i13++;
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("key material too short.");
    }

    public static void setOddParity(byte[] bArr) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11];
            bArr[i11] = (byte) (((((b11 >> 7) ^ ((((((b11 >> 1) ^ (b11 >> 2)) ^ (b11 >> 3)) ^ (b11 >> 4)) ^ (b11 >> 5)) ^ (b11 >> 6))) ^ 1) & 1) | (b11 & 254));
        }
    }
}
