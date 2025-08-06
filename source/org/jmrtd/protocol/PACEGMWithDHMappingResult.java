package org.jmrtd.protocol;

import java.security.KeyPair;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class PACEGMWithDHMappingResult extends PACEGMMappingResult {
    private static final long serialVersionUID = -2829641255641406199L;
    private byte[] sharedSecret;

    public PACEGMWithDHMappingResult(AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr, PublicKey publicKey, KeyPair keyPair, byte[] bArr2, AlgorithmParameterSpec algorithmParameterSpec2) {
        super(algorithmParameterSpec, bArr, publicKey, keyPair, algorithmParameterSpec2);
        byte[] bArr3;
        if (bArr2 == null) {
            bArr3 = null;
        } else {
            bArr3 = Arrays.copyOf(bArr2, bArr2.length);
        }
        this.sharedSecret = bArr3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && getClass() == obj.getClass()) {
            return Arrays.equals(this.sharedSecret, ((PACEGMWithDHMappingResult) obj).sharedSecret);
        }
        return false;
    }

    public byte[] getSharedSecret() {
        byte[] bArr = this.sharedSecret;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(this.sharedSecret);
    }
}
