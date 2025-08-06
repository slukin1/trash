package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class PKCS7Padding implements BlockCipherPadding {
    public int addPadding(byte[] bArr, int i11) {
        byte length = (byte) (bArr.length - i11);
        while (i11 < bArr.length) {
            bArr[i11] = length;
            i11++;
        }
        return length;
    }

    public String getPaddingName() {
        return "PKCS7";
    }

    public void init(SecureRandom secureRandom) throws IllegalArgumentException {
    }

    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        byte b11 = bArr[bArr.length - 1] & 255;
        byte b12 = (byte) b11;
        boolean z11 = (b11 > bArr.length) | (b11 == 0);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            z11 |= (bArr.length - i11 <= b11) & (bArr[i11] != b12);
        }
        if (!z11) {
            return b11;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
