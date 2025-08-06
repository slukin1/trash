package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class DeriveSharedSecretResult implements Serializable {
    private ByteBuffer ciphertextForRecipient;
    private String keyAgreementAlgorithm;
    private String keyId;
    private String keyOrigin;
    private ByteBuffer sharedSecret;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeriveSharedSecretResult)) {
            return false;
        }
        DeriveSharedSecretResult deriveSharedSecretResult = (DeriveSharedSecretResult) obj;
        if ((deriveSharedSecretResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (deriveSharedSecretResult.getKeyId() != null && !deriveSharedSecretResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((deriveSharedSecretResult.getSharedSecret() == null) ^ (getSharedSecret() == null)) {
            return false;
        }
        if (deriveSharedSecretResult.getSharedSecret() != null && !deriveSharedSecretResult.getSharedSecret().equals(getSharedSecret())) {
            return false;
        }
        if ((deriveSharedSecretResult.getCiphertextForRecipient() == null) ^ (getCiphertextForRecipient() == null)) {
            return false;
        }
        if (deriveSharedSecretResult.getCiphertextForRecipient() != null && !deriveSharedSecretResult.getCiphertextForRecipient().equals(getCiphertextForRecipient())) {
            return false;
        }
        if ((deriveSharedSecretResult.getKeyAgreementAlgorithm() == null) ^ (getKeyAgreementAlgorithm() == null)) {
            return false;
        }
        if (deriveSharedSecretResult.getKeyAgreementAlgorithm() != null && !deriveSharedSecretResult.getKeyAgreementAlgorithm().equals(getKeyAgreementAlgorithm())) {
            return false;
        }
        if ((deriveSharedSecretResult.getKeyOrigin() == null) ^ (getKeyOrigin() == null)) {
            return false;
        }
        return deriveSharedSecretResult.getKeyOrigin() == null || deriveSharedSecretResult.getKeyOrigin().equals(getKeyOrigin());
    }

    public ByteBuffer getCiphertextForRecipient() {
        return this.ciphertextForRecipient;
    }

    public String getKeyAgreementAlgorithm() {
        return this.keyAgreementAlgorithm;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getKeyOrigin() {
        return this.keyOrigin;
    }

    public ByteBuffer getSharedSecret() {
        return this.sharedSecret;
    }

    public int hashCode() {
        int i11;
        int i12 = 0;
        int hashCode = ((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getSharedSecret() == null ? 0 : getSharedSecret().hashCode())) * 31;
        if (getCiphertextForRecipient() == null) {
            i11 = 0;
        } else {
            i11 = getCiphertextForRecipient().hashCode();
        }
        int hashCode2 = (((hashCode + i11) * 31) + (getKeyAgreementAlgorithm() == null ? 0 : getKeyAgreementAlgorithm().hashCode())) * 31;
        if (getKeyOrigin() != null) {
            i12 = getKeyOrigin().hashCode();
        }
        return hashCode2 + i12;
    }

    public void setCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
    }

    public void setKeyAgreementAlgorithm(String str) {
        this.keyAgreementAlgorithm = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setKeyOrigin(String str) {
        this.keyOrigin = str;
    }

    public void setSharedSecret(ByteBuffer byteBuffer) {
        this.sharedSecret = byteBuffer;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSharedSecret() != null) {
            sb2.append("SharedSecret: " + getSharedSecret() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCiphertextForRecipient() != null) {
            sb2.append("CiphertextForRecipient: " + getCiphertextForRecipient() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyAgreementAlgorithm() != null) {
            sb2.append("KeyAgreementAlgorithm: " + getKeyAgreementAlgorithm() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyOrigin() != null) {
            sb2.append("KeyOrigin: " + getKeyOrigin());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public DeriveSharedSecretResult withCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
        return this;
    }

    public DeriveSharedSecretResult withKeyAgreementAlgorithm(String str) {
        this.keyAgreementAlgorithm = str;
        return this;
    }

    public DeriveSharedSecretResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public DeriveSharedSecretResult withKeyOrigin(String str) {
        this.keyOrigin = str;
        return this;
    }

    public DeriveSharedSecretResult withSharedSecret(ByteBuffer byteBuffer) {
        this.sharedSecret = byteBuffer;
        return this;
    }

    public void setKeyAgreementAlgorithm(KeyAgreementAlgorithmSpec keyAgreementAlgorithmSpec) {
        this.keyAgreementAlgorithm = keyAgreementAlgorithmSpec.toString();
    }

    public void setKeyOrigin(OriginType originType) {
        this.keyOrigin = originType.toString();
    }

    public DeriveSharedSecretResult withKeyAgreementAlgorithm(KeyAgreementAlgorithmSpec keyAgreementAlgorithmSpec) {
        this.keyAgreementAlgorithm = keyAgreementAlgorithmSpec.toString();
        return this;
    }

    public DeriveSharedSecretResult withKeyOrigin(OriginType originType) {
        this.keyOrigin = originType.toString();
        return this;
    }
}
