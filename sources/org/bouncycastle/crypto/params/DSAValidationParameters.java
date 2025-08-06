package org.bouncycastle.crypto.params;

import org.bouncycastle.util.Arrays;

public class DSAValidationParameters {
    private int counter;
    private byte[] seed;
    private int usageIndex;

    public DSAValidationParameters(byte[] bArr, int i11) {
        this(bArr, i11, -1);
    }

    public DSAValidationParameters(byte[] bArr, int i11, int i12) {
        this.seed = Arrays.clone(bArr);
        this.counter = i11;
        this.usageIndex = i12;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAValidationParameters)) {
            return false;
        }
        DSAValidationParameters dSAValidationParameters = (DSAValidationParameters) obj;
        if (dSAValidationParameters.counter != this.counter) {
            return false;
        }
        return Arrays.areEqual(this.seed, dSAValidationParameters.seed);
    }

    public int getCounter() {
        return this.counter;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public int getUsageIndex() {
        return this.usageIndex;
    }

    public int hashCode() {
        return this.counter ^ Arrays.hashCode(this.seed);
    }
}
