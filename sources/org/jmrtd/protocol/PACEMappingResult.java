package org.jmrtd.protocol;

import java.io.Serializable;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public abstract class PACEMappingResult implements Serializable {
    private static final long serialVersionUID = 2773111318950631118L;
    private transient AlgorithmParameterSpec ephemeralParameters;
    private byte[] piccNonce = null;
    private transient AlgorithmParameterSpec staticParameters;

    public PACEMappingResult(AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec2) {
        this.staticParameters = algorithmParameterSpec;
        this.ephemeralParameters = algorithmParameterSpec2;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.piccNonce = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PACEMappingResult pACEMappingResult = (PACEMappingResult) obj;
        AlgorithmParameterSpec algorithmParameterSpec = this.ephemeralParameters;
        if (algorithmParameterSpec == null) {
            if (pACEMappingResult.ephemeralParameters != null) {
                return false;
            }
        } else if (!algorithmParameterSpec.equals(pACEMappingResult.ephemeralParameters)) {
            return false;
        }
        if (!Arrays.equals(this.piccNonce, pACEMappingResult.piccNonce)) {
            return false;
        }
        AlgorithmParameterSpec algorithmParameterSpec2 = this.staticParameters;
        if (algorithmParameterSpec2 == null) {
            if (pACEMappingResult.staticParameters != null) {
                return false;
            }
        } else if (!algorithmParameterSpec2.equals(pACEMappingResult.staticParameters)) {
            return false;
        }
        return true;
    }

    public AlgorithmParameterSpec getEphemeralParameters() {
        return this.ephemeralParameters;
    }

    public byte[] getPICCNonce() {
        return this.piccNonce;
    }

    public AlgorithmParameterSpec getStaticParameters() {
        return this.staticParameters;
    }

    public int hashCode() {
        AlgorithmParameterSpec algorithmParameterSpec = this.ephemeralParameters;
        int i11 = 0;
        int hashCode = ((((algorithmParameterSpec == null ? 0 : algorithmParameterSpec.hashCode()) + 31) * 31) + Arrays.hashCode(this.piccNonce)) * 31;
        AlgorithmParameterSpec algorithmParameterSpec2 = this.staticParameters;
        if (algorithmParameterSpec2 != null) {
            i11 = algorithmParameterSpec2.hashCode();
        }
        return hashCode + i11;
    }
}
