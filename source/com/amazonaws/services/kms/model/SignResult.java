package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class SignResult implements Serializable {
    private String keyId;
    private ByteBuffer signature;
    private String signingAlgorithm;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SignResult)) {
            return false;
        }
        SignResult signResult = (SignResult) obj;
        if ((signResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (signResult.getKeyId() != null && !signResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((signResult.getSignature() == null) ^ (getSignature() == null)) {
            return false;
        }
        if (signResult.getSignature() != null && !signResult.getSignature().equals(getSignature())) {
            return false;
        }
        if ((signResult.getSigningAlgorithm() == null) ^ (getSigningAlgorithm() == null)) {
            return false;
        }
        return signResult.getSigningAlgorithm() == null || signResult.getSigningAlgorithm().equals(getSigningAlgorithm());
    }

    public String getKeyId() {
        return this.keyId;
    }

    public ByteBuffer getSignature() {
        return this.signature;
    }

    public String getSigningAlgorithm() {
        return this.signingAlgorithm;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getSignature() == null ? 0 : getSignature().hashCode())) * 31;
        if (getSigningAlgorithm() != null) {
            i11 = getSigningAlgorithm().hashCode();
        }
        return hashCode + i11;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setSignature(ByteBuffer byteBuffer) {
        this.signature = byteBuffer;
    }

    public void setSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSignature() != null) {
            sb2.append("Signature: " + getSignature() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSigningAlgorithm() != null) {
            sb2.append("SigningAlgorithm: " + getSigningAlgorithm());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public SignResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public SignResult withSignature(ByteBuffer byteBuffer) {
        this.signature = byteBuffer;
        return this;
    }

    public SignResult withSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
        return this;
    }

    public void setSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
    }

    public SignResult withSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
        return this;
    }
}
