package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class DecryptResult implements Serializable {
    private ByteBuffer ciphertextForRecipient;
    private String encryptionAlgorithm;
    private String keyId;
    private ByteBuffer plaintext;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DecryptResult)) {
            return false;
        }
        DecryptResult decryptResult = (DecryptResult) obj;
        if ((decryptResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (decryptResult.getKeyId() != null && !decryptResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((decryptResult.getPlaintext() == null) ^ (getPlaintext() == null)) {
            return false;
        }
        if (decryptResult.getPlaintext() != null && !decryptResult.getPlaintext().equals(getPlaintext())) {
            return false;
        }
        if ((decryptResult.getEncryptionAlgorithm() == null) ^ (getEncryptionAlgorithm() == null)) {
            return false;
        }
        if (decryptResult.getEncryptionAlgorithm() != null && !decryptResult.getEncryptionAlgorithm().equals(getEncryptionAlgorithm())) {
            return false;
        }
        if ((decryptResult.getCiphertextForRecipient() == null) ^ (getCiphertextForRecipient() == null)) {
            return false;
        }
        return decryptResult.getCiphertextForRecipient() == null || decryptResult.getCiphertextForRecipient().equals(getCiphertextForRecipient());
    }

    public ByteBuffer getCiphertextForRecipient() {
        return this.ciphertextForRecipient;
    }

    public String getEncryptionAlgorithm() {
        return this.encryptionAlgorithm;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public ByteBuffer getPlaintext() {
        return this.plaintext;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getPlaintext() == null ? 0 : getPlaintext().hashCode())) * 31) + (getEncryptionAlgorithm() == null ? 0 : getEncryptionAlgorithm().hashCode())) * 31;
        if (getCiphertextForRecipient() != null) {
            i11 = getCiphertextForRecipient().hashCode();
        }
        return hashCode + i11;
    }

    public void setCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
    }

    public void setEncryptionAlgorithm(String str) {
        this.encryptionAlgorithm = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPlaintext() != null) {
            sb2.append("Plaintext: " + getPlaintext() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getEncryptionAlgorithm() != null) {
            sb2.append("EncryptionAlgorithm: " + getEncryptionAlgorithm() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCiphertextForRecipient() != null) {
            sb2.append("CiphertextForRecipient: " + getCiphertextForRecipient());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public DecryptResult withCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
        return this;
    }

    public DecryptResult withEncryptionAlgorithm(String str) {
        this.encryptionAlgorithm = str;
        return this;
    }

    public DecryptResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public DecryptResult withPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
        return this;
    }

    public void setEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.encryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public DecryptResult withEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.encryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }
}
