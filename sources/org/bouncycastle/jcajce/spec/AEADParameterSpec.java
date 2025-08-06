package org.bouncycastle.jcajce.spec;

import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.util.Arrays;

public class AEADParameterSpec extends IvParameterSpec {
    private final byte[] associatedData;
    private final int macSizeInBits;

    public AEADParameterSpec(byte[] bArr, int i11) {
        this(bArr, i11, (byte[]) null);
    }

    public AEADParameterSpec(byte[] bArr, int i11, byte[] bArr2) {
        super(bArr);
        this.macSizeInBits = i11;
        this.associatedData = Arrays.clone(bArr2);
    }

    public byte[] getAssociatedData() {
        return Arrays.clone(this.associatedData);
    }

    public int getMacSizeInBits() {
        return this.macSizeInBits;
    }

    public byte[] getNonce() {
        return getIV();
    }
}
