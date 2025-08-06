package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

public final class KDFFeedbackParameters implements DerivationParameters {
    private static final int UNUSED_R = -1;
    private final byte[] fixedInputData;

    /* renamed from: iv  reason: collision with root package name */
    private final byte[] f59295iv;

    /* renamed from: ki  reason: collision with root package name */
    private final byte[] f59296ki;

    /* renamed from: r  reason: collision with root package name */
    private final int f59297r;
    private final boolean useCounter;

    private KDFFeedbackParameters(byte[] bArr, byte[] bArr2, byte[] bArr3, int i11, boolean z11) {
        if (bArr != null) {
            this.f59296ki = Arrays.clone(bArr);
            if (bArr3 == null) {
                this.fixedInputData = new byte[0];
            } else {
                this.fixedInputData = Arrays.clone(bArr3);
            }
            this.f59297r = i11;
            if (bArr2 == null) {
                this.f59295iv = new byte[0];
            } else {
                this.f59295iv = Arrays.clone(bArr2);
            }
            this.useCounter = z11;
            return;
        }
        throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
    }

    public static KDFFeedbackParameters createWithCounter(byte[] bArr, byte[] bArr2, byte[] bArr3, int i11) {
        if (i11 == 8 || i11 == 16 || i11 == 24 || i11 == 32) {
            return new KDFFeedbackParameters(bArr, bArr2, bArr3, i11, true);
        }
        throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
    }

    public static KDFFeedbackParameters createWithoutCounter(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new KDFFeedbackParameters(bArr, bArr2, bArr3, -1, false);
    }

    public byte[] getFixedInputData() {
        return Arrays.clone(this.fixedInputData);
    }

    public byte[] getIV() {
        return this.f59295iv;
    }

    public byte[] getKI() {
        return this.f59296ki;
    }

    public int getR() {
        return this.f59297r;
    }

    public boolean useCounter() {
        return this.useCounter;
    }
}
