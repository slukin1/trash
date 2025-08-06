package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class GenerateDataKeyPairResult implements Serializable {
    private ByteBuffer ciphertextForRecipient;
    private String keyId;
    private String keyPairSpec;
    private ByteBuffer privateKeyCiphertextBlob;
    private ByteBuffer privateKeyPlaintext;
    private ByteBuffer publicKey;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyPairResult)) {
            return false;
        }
        GenerateDataKeyPairResult generateDataKeyPairResult = (GenerateDataKeyPairResult) obj;
        if ((generateDataKeyPairResult.getPrivateKeyCiphertextBlob() == null) ^ (getPrivateKeyCiphertextBlob() == null)) {
            return false;
        }
        if (generateDataKeyPairResult.getPrivateKeyCiphertextBlob() != null && !generateDataKeyPairResult.getPrivateKeyCiphertextBlob().equals(getPrivateKeyCiphertextBlob())) {
            return false;
        }
        if ((generateDataKeyPairResult.getPrivateKeyPlaintext() == null) ^ (getPrivateKeyPlaintext() == null)) {
            return false;
        }
        if (generateDataKeyPairResult.getPrivateKeyPlaintext() != null && !generateDataKeyPairResult.getPrivateKeyPlaintext().equals(getPrivateKeyPlaintext())) {
            return false;
        }
        if ((generateDataKeyPairResult.getPublicKey() == null) ^ (getPublicKey() == null)) {
            return false;
        }
        if (generateDataKeyPairResult.getPublicKey() != null && !generateDataKeyPairResult.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if ((generateDataKeyPairResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (generateDataKeyPairResult.getKeyId() != null && !generateDataKeyPairResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((generateDataKeyPairResult.getKeyPairSpec() == null) ^ (getKeyPairSpec() == null)) {
            return false;
        }
        if (generateDataKeyPairResult.getKeyPairSpec() != null && !generateDataKeyPairResult.getKeyPairSpec().equals(getKeyPairSpec())) {
            return false;
        }
        if ((generateDataKeyPairResult.getCiphertextForRecipient() == null) ^ (getCiphertextForRecipient() == null)) {
            return false;
        }
        return generateDataKeyPairResult.getCiphertextForRecipient() == null || generateDataKeyPairResult.getCiphertextForRecipient().equals(getCiphertextForRecipient());
    }

    public ByteBuffer getCiphertextForRecipient() {
        return this.ciphertextForRecipient;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public ByteBuffer getPrivateKeyCiphertextBlob() {
        return this.privateKeyCiphertextBlob;
    }

    public ByteBuffer getPrivateKeyPlaintext() {
        return this.privateKeyPlaintext;
    }

    public ByteBuffer getPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        int i11;
        int i12 = 0;
        if (getPrivateKeyCiphertextBlob() == null) {
            i11 = 0;
        } else {
            i11 = getPrivateKeyCiphertextBlob().hashCode();
        }
        int hashCode = (((((((((i11 + 31) * 31) + (getPrivateKeyPlaintext() == null ? 0 : getPrivateKeyPlaintext().hashCode())) * 31) + (getPublicKey() == null ? 0 : getPublicKey().hashCode())) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31) + (getKeyPairSpec() == null ? 0 : getKeyPairSpec().hashCode())) * 31;
        if (getCiphertextForRecipient() != null) {
            i12 = getCiphertextForRecipient().hashCode();
        }
        return hashCode + i12;
    }

    public void setCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setKeyPairSpec(String str) {
        this.keyPairSpec = str;
    }

    public void setPrivateKeyCiphertextBlob(ByteBuffer byteBuffer) {
        this.privateKeyCiphertextBlob = byteBuffer;
    }

    public void setPrivateKeyPlaintext(ByteBuffer byteBuffer) {
        this.privateKeyPlaintext = byteBuffer;
    }

    public void setPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getPrivateKeyCiphertextBlob() != null) {
            sb2.append("PrivateKeyCiphertextBlob: " + getPrivateKeyCiphertextBlob() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPrivateKeyPlaintext() != null) {
            sb2.append("PrivateKeyPlaintext: " + getPrivateKeyPlaintext() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPublicKey() != null) {
            sb2.append("PublicKey: " + getPublicKey() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyPairSpec() != null) {
            sb2.append("KeyPairSpec: " + getKeyPairSpec() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCiphertextForRecipient() != null) {
            sb2.append("CiphertextForRecipient: " + getCiphertextForRecipient());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GenerateDataKeyPairResult withCiphertextForRecipient(ByteBuffer byteBuffer) {
        this.ciphertextForRecipient = byteBuffer;
        return this;
    }

    public GenerateDataKeyPairResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GenerateDataKeyPairResult withKeyPairSpec(String str) {
        this.keyPairSpec = str;
        return this;
    }

    public GenerateDataKeyPairResult withPrivateKeyCiphertextBlob(ByteBuffer byteBuffer) {
        this.privateKeyCiphertextBlob = byteBuffer;
        return this;
    }

    public GenerateDataKeyPairResult withPrivateKeyPlaintext(ByteBuffer byteBuffer) {
        this.privateKeyPlaintext = byteBuffer;
        return this;
    }

    public GenerateDataKeyPairResult withPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
        return this;
    }

    public void setKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
    }

    public GenerateDataKeyPairResult withKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
        return this;
    }
}
