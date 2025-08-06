package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class GenerateDataKeyWithoutPlaintextResult implements Serializable {
    private ByteBuffer ciphertextBlob;
    private String keyId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyWithoutPlaintextResult)) {
            return false;
        }
        GenerateDataKeyWithoutPlaintextResult generateDataKeyWithoutPlaintextResult = (GenerateDataKeyWithoutPlaintextResult) obj;
        if ((generateDataKeyWithoutPlaintextResult.getCiphertextBlob() == null) ^ (getCiphertextBlob() == null)) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextResult.getCiphertextBlob() != null && !generateDataKeyWithoutPlaintextResult.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if ((generateDataKeyWithoutPlaintextResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        return generateDataKeyWithoutPlaintextResult.getKeyId() == null || generateDataKeyWithoutPlaintextResult.getKeyId().equals(getKeyId());
    }

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getCiphertextBlob() == null ? 0 : getCiphertextBlob().hashCode()) + 31) * 31;
        if (getKeyId() != null) {
            i11 = getKeyId().hashCode();
        }
        return hashCode + i11;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
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
            sb2.append("KeyId: " + getKeyId());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GenerateDataKeyWithoutPlaintextResult withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public GenerateDataKeyWithoutPlaintextResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }
}
