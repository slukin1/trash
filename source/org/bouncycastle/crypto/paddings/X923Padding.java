package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class X923Padding implements BlockCipherPadding {
    public SecureRandom random = null;

    public int addPadding(byte[] bArr, int i11) {
        byte length = (byte) (bArr.length - i11);
        while (i11 < bArr.length - 1) {
            SecureRandom secureRandom = this.random;
            if (secureRandom == null) {
                bArr[i11] = 0;
            } else {
                bArr[i11] = (byte) secureRandom.nextInt();
            }
            i11++;
        }
        bArr[i11] = length;
        return length;
    }

    public String getPaddingName() {
        return "X9.23";
    }

    public void init(SecureRandom secureRandom) throws IllegalArgumentException {
        this.random = secureRandom;
    }

    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        byte b11 = bArr[bArr.length - 1] & 255;
        if (b11 <= bArr.length) {
            return b11;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
