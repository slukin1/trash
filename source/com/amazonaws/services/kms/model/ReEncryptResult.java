package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class ReEncryptResult implements Serializable {
    private ByteBuffer ciphertextBlob;
    private String destinationEncryptionAlgorithm;
    private String keyId;
    private String sourceEncryptionAlgorithm;
    private String sourceKeyId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReEncryptResult)) {
            return false;
        }
        ReEncryptResult reEncryptResult = (ReEncryptResult) obj;
        if ((reEncryptResult.getCiphertextBlob() == null) ^ (getCiphertextBlob() == null)) {
            return false;
        }
        if (reEncryptResult.getCiphertextBlob() != null && !reEncryptResult.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if ((reEncryptResult.getSourceKeyId() == null) ^ (getSourceKeyId() == null)) {
            return false;
        }
        if (reEncryptResult.getSourceKeyId() != null && !reEncryptResult.getSourceKeyId().equals(getSourceKeyId())) {
            return false;
        }
        if ((reEncryptResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (reEncryptResult.getKeyId() != null && !reEncryptResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((reEncryptResult.getSourceEncryptionAlgorithm() == null) ^ (getSourceEncryptionAlgorithm() == null)) {
            return false;
        }
        if (reEncryptResult.getSourceEncryptionAlgorithm() != null && !reEncryptResult.getSourceEncryptionAlgorithm().equals(getSourceEncryptionAlgorithm())) {
            return false;
        }
        if ((reEncryptResult.getDestinationEncryptionAlgorithm() == null) ^ (getDestinationEncryptionAlgorithm() == null)) {
            return false;
        }
        return reEncryptResult.getDestinationEncryptionAlgorithm() == null || reEncryptResult.getDestinationEncryptionAlgorithm().equals(getDestinationEncryptionAlgorithm());
    }

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public String getDestinationEncryptionAlgorithm() {
        return this.destinationEncryptionAlgorithm;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getSourceEncryptionAlgorithm() {
        return this.sourceEncryptionAlgorithm;
    }

    public String getSourceKeyId() {
        return this.sourceKeyId;
    }

    public int hashCode() {
        int i11;
        int i12 = 0;
        int hashCode = ((((((getCiphertextBlob() == null ? 0 : getCiphertextBlob().hashCode()) + 31) * 31) + (getSourceKeyId() == null ? 0 : getSourceKeyId().hashCode())) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31;
        if (getSourceEncryptionAlgorithm() == null) {
            i11 = 0;
        } else {
            i11 = getSourceEncryptionAlgorithm().hashCode();
        }
        int i13 = (hashCode + i11) * 31;
        if (getDestinationEncryptionAlgorithm() != null) {
            i12 = getDestinationEncryptionAlgorithm().hashCode();
        }
        return i13 + i12;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
    }

    public void setDestinationEncryptionAlgorithm(String str) {
        this.destinationEncryptionAlgorithm = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setSourceEncryptionAlgorithm(String str) {
        this.sourceEncryptionAlgorithm = str;
    }

    public void setSourceKeyId(String str) {
        this.sourceKeyId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getCiphertextBlob() != null) {
            sb2.append("CiphertextBlob: " + getCiphertextBlob() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSourceKeyId() != null) {
            sb2.append("SourceKeyId: " + getSourceKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSourceEncryptionAlgorithm() != null) {
            sb2.append("SourceEncryptionAlgorithm: " + getSourceEncryptionAlgorithm() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDestinationEncryptionAlgorithm() != null) {
            sb2.append("DestinationEncryptionAlgorithm: " + getDestinationEncryptionAlgorithm());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ReEncryptResult withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public ReEncryptResult withDestinationEncryptionAlgorithm(String str) {
        this.destinationEncryptionAlgorithm = str;
        return this;
    }

    public ReEncryptResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ReEncryptResult withSourceEncryptionAlgorithm(String str) {
        this.sourceEncryptionAlgorithm = str;
        return this;
    }

    public ReEncryptResult withSourceKeyId(String str) {
        this.sourceKeyId = str;
        return this;
    }

    public void setDestinationEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.destinationEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public void setSourceEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.sourceEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public ReEncryptResult withDestinationEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.destinationEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }

    public ReEncryptResult withSourceEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.sourceEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }
}
