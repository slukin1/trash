package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

public class FPEParameterSpec implements AlgorithmParameterSpec {
    private final int radix;
    private final byte[] tweak;
    private final boolean useInverse;

    public FPEParameterSpec(int i11, byte[] bArr) {
        this(i11, bArr, false);
    }

    public FPEParameterSpec(int i11, byte[] bArr, boolean z11) {
        this.radix = i11;
        this.tweak = Arrays.clone(bArr);
        this.useInverse = z11;
    }

    public int getRadix() {
        return this.radix;
    }

    public byte[] getTweak() {
        return Arrays.clone(this.tweak);
    }

    public boolean isUsingInverseFunction() {
        return this.useInverse;
    }
}
