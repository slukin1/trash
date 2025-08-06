package org.jmrtd.protocol;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class PACEIMMappingResult extends PACEMappingResult {
    private static final long serialVersionUID = -6415752866407346050L;
    private byte[] pcdNonce;

    public PACEIMMappingResult(AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr, byte[] bArr2, AlgorithmParameterSpec algorithmParameterSpec2) {
        super(algorithmParameterSpec, bArr, algorithmParameterSpec2);
        byte[] bArr3;
        if (bArr2 == null) {
            bArr3 = null;
        } else {
            bArr3 = Arrays.copyOf(bArr2, bArr2.length);
        }
        this.pcdNonce = bArr3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && getClass() == obj.getClass()) {
            return Arrays.equals(this.pcdNonce, ((PACEIMMappingResult) obj).pcdNonce);
        }
        return false;
    }

    public byte[] getPCDNonce() {
        byte[] bArr = this.pcdNonce;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(this.pcdNonce);
    }
}
