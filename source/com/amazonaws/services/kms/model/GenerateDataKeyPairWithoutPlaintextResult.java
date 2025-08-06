package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class GenerateDataKeyPairWithoutPlaintextResult implements Serializable {
    private String keyId;
    private String keyPairSpec;
    private ByteBuffer privateKeyCiphertextBlob;
    private ByteBuffer publicKey;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyPairWithoutPlaintextResult)) {
            return false;
        }
        GenerateDataKeyPairWithoutPlaintextResult generateDataKeyPairWithoutPlaintextResult = (GenerateDataKeyPairWithoutPlaintextResult) obj;
        if ((generateDataKeyPairWithoutPlaintextResult.getPrivateKeyCiphertextBlob() == null) ^ (getPrivateKeyCiphertextBlob() == null)) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getPrivateKeyCiphertextBlob() != null && !generateDataKeyPairWithoutPlaintextResult.getPrivateKeyCiphertextBlob().equals(getPrivateKeyCiphertextBlob())) {
            return false;
        }
        if ((generateDataKeyPairWithoutPlaintextResult.getPublicKey() == null) ^ (getPublicKey() == null)) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getPublicKey() != null && !generateDataKeyPairWithoutPlaintextResult.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if ((generateDataKeyPairWithoutPlaintextResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getKeyId() != null && !generateDataKeyPairWithoutPlaintextResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((generateDataKeyPairWithoutPlaintextResult.getKeyPairSpec() == null) ^ (getKeyPairSpec() == null)) {
            return false;
        }
        return generateDataKeyPairWithoutPlaintextResult.getKeyPairSpec() == null || generateDataKeyPairWithoutPlaintextResult.getKeyPairSpec().equals(getKeyPairSpec());
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
        int hashCode = (((((i11 + 31) * 31) + (getPublicKey() == null ? 0 : getPublicKey().hashCode())) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31;
        if (getKeyPairSpec() != null) {
            i12 = getKeyPairSpec().hashCode();
        }
        return hashCode + i12;
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

    public void setPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getPrivateKeyCiphertextBlob() != null) {
            sb2.append("PrivateKeyCiphertextBlob: " + getPrivateKeyCiphertextBlob() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPublicKey() != null) {
            sb2.append("PublicKey: " + getPublicKey() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyPairSpec() != null) {
            sb2.append("KeyPairSpec: " + getKeyPairSpec());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GenerateDataKeyPairWithoutPlaintextResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextResult withKeyPairSpec(String str) {
        this.keyPairSpec = str;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextResult withPrivateKeyCiphertextBlob(ByteBuffer byteBuffer) {
        this.privateKeyCiphertextBlob = byteBuffer;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextResult withPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
        return this;
    }

    public void setKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
    }

    public GenerateDataKeyPairWithoutPlaintextResult withKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
        return this;
    }
}
