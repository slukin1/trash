package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.DESedeParameters;

public class DESedeKeyGenerator extends DESKeyGenerator {
    private static final int MAX_IT = 20;

    public byte[] generateKey() {
        int i11 = this.strength;
        byte[] bArr = new byte[i11];
        int i12 = 0;
        while (true) {
            this.random.nextBytes(bArr);
            DESParameters.setOddParity(bArr);
            i12++;
            if (i12 >= 20 || (!DESedeParameters.isWeakKey(bArr, 0, i11) && DESedeParameters.isRealEDEKey(bArr, 0))) {
            }
        }
        if (!DESedeParameters.isWeakKey(bArr, 0, i11) && DESedeParameters.isRealEDEKey(bArr, 0)) {
            return bArr;
        }
        throw new IllegalStateException("Unable to generate DES-EDE key");
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.random = keyGenerationParameters.getRandom();
        int strength = (keyGenerationParameters.getStrength() + 7) / 8;
        this.strength = strength;
        if (strength == 0 || strength == 21) {
            this.strength = 24;
        } else if (strength == 14) {
            this.strength = 16;
        } else if (strength != 24 && strength != 16) {
            throw new IllegalArgumentException("DESede key must be 192 or 128 bits long.");
        }
    }
}
