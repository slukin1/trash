package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class RecipientInfo implements Serializable {
    private ByteBuffer attestationDocument;
    private String keyEncryptionAlgorithm;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RecipientInfo)) {
            return false;
        }
        RecipientInfo recipientInfo = (RecipientInfo) obj;
        if ((recipientInfo.getKeyEncryptionAlgorithm() == null) ^ (getKeyEncryptionAlgorithm() == null)) {
            return false;
        }
        if (recipientInfo.getKeyEncryptionAlgorithm() != null && !recipientInfo.getKeyEncryptionAlgorithm().equals(getKeyEncryptionAlgorithm())) {
            return false;
        }
        if ((recipientInfo.getAttestationDocument() == null) ^ (getAttestationDocument() == null)) {
            return false;
        }
        return recipientInfo.getAttestationDocument() == null || recipientInfo.getAttestationDocument().equals(getAttestationDocument());
    }

    public ByteBuffer getAttestationDocument() {
        return this.attestationDocument;
    }

    public String getKeyEncryptionAlgorithm() {
        return this.keyEncryptionAlgorithm;
    }

    public int hashCode() {
        int i11;
        int i12 = 0;
        if (getKeyEncryptionAlgorithm() == null) {
            i11 = 0;
        } else {
            i11 = getKeyEncryptionAlgorithm().hashCode();
        }
        int i13 = (i11 + 31) * 31;
        if (getAttestationDocument() != null) {
            i12 = getAttestationDocument().hashCode();
        }
        return i13 + i12;
    }

    public void setAttestationDocument(ByteBuffer byteBuffer) {
        this.attestationDocument = byteBuffer;
    }

    public void setKeyEncryptionAlgorithm(String str) {
        this.keyEncryptionAlgorithm = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyEncryptionAlgorithm() != null) {
            sb2.append("KeyEncryptionAlgorithm: " + getKeyEncryptionAlgorithm() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getAttestationDocument() != null) {
            sb2.append("AttestationDocument: " + getAttestationDocument());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public RecipientInfo withAttestationDocument(ByteBuffer byteBuffer) {
        this.attestationDocument = byteBuffer;
        return this;
    }

    public RecipientInfo withKeyEncryptionAlgorithm(String str) {
        this.keyEncryptionAlgorithm = str;
        return this;
    }

    public void setKeyEncryptionAlgorithm(KeyEncryptionMechanism keyEncryptionMechanism) {
        this.keyEncryptionAlgorithm = keyEncryptionMechanism.toString();
    }

    public RecipientInfo withKeyEncryptionAlgorithm(KeyEncryptionMechanism keyEncryptionMechanism) {
        this.keyEncryptionAlgorithm = keyEncryptionMechanism.toString();
        return this;
    }
}
