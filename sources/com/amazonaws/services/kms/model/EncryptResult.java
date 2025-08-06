package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class EncryptResult implements Serializable {
    private ByteBuffer ciphertextBlob;
    private String encryptionAlgorithm;
    private String keyId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EncryptResult)) {
            return false;
        }
        EncryptResult encryptResult = (EncryptResult) obj;
        if ((encryptResult.getCiphertextBlob() == null) ^ (getCiphertextBlob() == null)) {
            return false;
        }
        if (encryptResult.getCiphertextBlob() != null && !encryptResult.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if ((encryptResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (encryptResult.getKeyId() != null && !encryptResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((encryptResult.getEncryptionAlgorithm() == null) ^ (getEncryptionAlgorithm() == null)) {
            return false;
        }
        return encryptResult.getEncryptionAlgorithm() == null || encryptResult.getEncryptionAlgorithm().equals(getEncryptionAlgorithm());
    }

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public String getEncryptionAlgorithm() {
        return this.encryptionAlgorithm;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getCiphertextBlob() == null ? 0 : getCiphertextBlob().hashCode()) + 31) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31;
        if (getEncryptionAlgorithm() != null) {
            i11 = getEncryptionAlgorithm().hashCode();
        }
        return hashCode + i11;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
    }

    public void setEncryptionAlgorithm(String str) {
        this.encryptionAlgorithm = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getCiphertextBlob() != null) {
            sb2.append("CiphertextBlob: " + getCiphertextBlob() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getEncryptionAlgorithm() != null) {
            sb2.append("EncryptionAlgorithm: " + getEncryptionAlgorithm());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public EncryptResult withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public EncryptResult withEncryptionAlgorithm(String str) {
        this.encryptionAlgorithm = str;
        return this;
    }

    public EncryptResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public void setEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.encryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public EncryptResult withEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.encryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }
}
