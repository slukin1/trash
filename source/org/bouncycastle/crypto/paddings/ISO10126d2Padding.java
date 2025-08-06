package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class ISO10126d2Padding implements BlockCipherPadding {
    public SecureRandom random;

    public int addPadding(byte[] bArr, int i11) {
        byte length = (byte) (bArr.length - i11);
        while (i11 < bArr.length - 1) {
            bArr[i11] = (byte) this.random.nextInt();
            i11++;
        }
        bArr[i11] = length;
        return length;
    }

    public String getPaddingName() {
        return "ISO10126-2";
    }

    public void init(SecureRandom secureRandom) throws IllegalArgumentException {
        this.random = CryptoServicesRegistrar.getSecureRandom(secureRandom);
    }

    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        byte b11 = bArr[bArr.length - 1] & 255;
        if (b11 <= bArr.length) {
            return b11;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
