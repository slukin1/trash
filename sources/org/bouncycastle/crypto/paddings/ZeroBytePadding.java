package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class ZeroBytePadding implements BlockCipherPadding {
    public int addPadding(byte[] bArr, int i11) {
        int length = bArr.length - i11;
        while (i11 < bArr.length) {
            bArr[i11] = 0;
            i11++;
        }
        return length;
    }

    public String getPaddingName() {
        return "ZeroByte";
    }

    public void init(SecureRandom secureRandom) throws IllegalArgumentException {
    }

    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        int length = bArr.length;
        while (length > 0 && bArr[length - 1] == 0) {
            length--;
        }
        return bArr.length - length;
    }
}
