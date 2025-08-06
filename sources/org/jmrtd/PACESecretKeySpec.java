package org.jmrtd;

import javax.crypto.spec.SecretKeySpec;

public class PACESecretKeySpec extends SecretKeySpec implements AccessKeySpec {
    private static final long serialVersionUID = -5181060361947453857L;
    private byte keyReference;

    public PACESecretKeySpec(byte[] bArr, int i11, int i12, String str, byte b11) {
        super(bArr, i11, i12, str);
        this.keyReference = b11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        if (this.keyReference == ((PACESecretKeySpec) obj).keyReference) {
            return true;
        }
        return false;
    }

    public byte[] getKey() {
        return super.getEncoded();
    }

    public byte getKeyReference() {
        return this.keyReference;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.keyReference;
    }

    public PACESecretKeySpec(byte[] bArr, String str, byte b11) {
        super(bArr, str);
        this.keyReference = b11;
    }
}
