package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

public final class KDFCounterParameters implements DerivationParameters {
    private byte[] fixedInputDataCounterPrefix;
    private byte[] fixedInputDataCounterSuffix;

    /* renamed from: ki  reason: collision with root package name */
    private byte[] f59291ki;

    /* renamed from: r  reason: collision with root package name */
    private int f59292r;

    public KDFCounterParameters(byte[] bArr, byte[] bArr2, int i11) {
        this(bArr, (byte[]) null, bArr2, i11);
    }

    public KDFCounterParameters(byte[] bArr, byte[] bArr2, byte[] bArr3, int i11) {
        if (bArr != null) {
            this.f59291ki = Arrays.clone(bArr);
            if (bArr2 == null) {
                this.fixedInputDataCounterPrefix = new byte[0];
            } else {
                this.fixedInputDataCounterPrefix = Arrays.clone(bArr2);
            }
            if (bArr3 == null) {
                this.fixedInputDataCounterSuffix = new byte[0];
            } else {
                this.fixedInputDataCounterSuffix = Arrays.clone(bArr3);
            }
            if (i11 == 8 || i11 == 16 || i11 == 24 || i11 == 32) {
                this.f59292r = i11;
                return;
            }
            throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
        }
        throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
    }

    public byte[] getFixedInputData() {
        return Arrays.clone(this.fixedInputDataCounterSuffix);
    }

    public byte[] getFixedInputDataCounterPrefix() {
        return Arrays.clone(this.fixedInputDataCounterPrefix);
    }

    public byte[] getFixedInputDataCounterSuffix() {
        return Arrays.clone(this.fixedInputDataCounterSuffix);
    }

    public byte[] getKI() {
        return this.f59291ki;
    }

    public int getR() {
        return this.f59292r;
    }
}
