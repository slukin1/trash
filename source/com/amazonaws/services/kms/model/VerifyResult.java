package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class VerifyResult implements Serializable {
    private String keyId;
    private Boolean signatureValid;
    private String signingAlgorithm;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifyResult)) {
            return false;
        }
        VerifyResult verifyResult = (VerifyResult) obj;
        if ((verifyResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (verifyResult.getKeyId() != null && !verifyResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((verifyResult.getSignatureValid() == null) ^ (getSignatureValid() == null)) {
            return false;
        }
        if (verifyResult.getSignatureValid() != null && !verifyResult.getSignatureValid().equals(getSignatureValid())) {
            return false;
        }
        if ((verifyResult.getSigningAlgorithm() == null) ^ (getSigningAlgorithm() == null)) {
            return false;
        }
        return verifyResult.getSigningAlgorithm() == null || verifyResult.getSigningAlgorithm().equals(getSigningAlgorithm());
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Boolean getSignatureValid() {
        return this.signatureValid;
    }

    public String getSigningAlgorithm() {
        return this.signingAlgorithm;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getSignatureValid() == null ? 0 : getSignatureValid().hashCode())) * 31;
        if (getSigningAlgorithm() != null) {
            i11 = getSigningAlgorithm().hashCode();
        }
        return hashCode + i11;
    }

    public Boolean isSignatureValid() {
        return this.signatureValid;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setSignatureValid(Boolean bool) {
        this.signatureValid = bool;
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
        if (getSignatureValid() != null) {
            sb2.append("SignatureValid: " + getSignatureValid() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSigningAlgorithm() != null) {
            sb2.append("SigningAlgorithm: " + getSigningAlgorithm());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public VerifyResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public VerifyResult withSignatureValid(Boolean bool) {
        this.signatureValid = bool;
        return this;
    }

    public VerifyResult withSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
        return this;
    }

    public void setSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
    }

    public VerifyResult withSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
        return this;
    }
}
