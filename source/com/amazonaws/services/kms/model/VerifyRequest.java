package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VerifyRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean dryRun;
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private ByteBuffer message;
    private String messageType;
    private ByteBuffer signature;
    private String signingAlgorithm;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifyRequest)) {
            return false;
        }
        VerifyRequest verifyRequest = (VerifyRequest) obj;
        if ((verifyRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (verifyRequest.getKeyId() != null && !verifyRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((verifyRequest.getMessage() == null) ^ (getMessage() == null)) {
            return false;
        }
        if (verifyRequest.getMessage() != null && !verifyRequest.getMessage().equals(getMessage())) {
            return false;
        }
        if ((verifyRequest.getMessageType() == null) ^ (getMessageType() == null)) {
            return false;
        }
        if (verifyRequest.getMessageType() != null && !verifyRequest.getMessageType().equals(getMessageType())) {
            return false;
        }
        if ((verifyRequest.getSignature() == null) ^ (getSignature() == null)) {
            return false;
        }
        if (verifyRequest.getSignature() != null && !verifyRequest.getSignature().equals(getSignature())) {
            return false;
        }
        if ((verifyRequest.getSigningAlgorithm() == null) ^ (getSigningAlgorithm() == null)) {
            return false;
        }
        if (verifyRequest.getSigningAlgorithm() != null && !verifyRequest.getSigningAlgorithm().equals(getSigningAlgorithm())) {
            return false;
        }
        if ((verifyRequest.getGrantTokens() == null) ^ (getGrantTokens() == null)) {
            return false;
        }
        if (verifyRequest.getGrantTokens() != null && !verifyRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if ((verifyRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        return verifyRequest.getDryRun() == null || verifyRequest.getDryRun().equals(getDryRun());
    }

    public Boolean getDryRun() {
        return this.dryRun;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public ByteBuffer getMessage() {
        return this.message;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public ByteBuffer getSignature() {
        return this.signature;
    }

    public String getSigningAlgorithm() {
        return this.signingAlgorithm;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getMessage() == null ? 0 : getMessage().hashCode())) * 31) + (getMessageType() == null ? 0 : getMessageType().hashCode())) * 31) + (getSignature() == null ? 0 : getSignature().hashCode())) * 31) + (getSigningAlgorithm() == null ? 0 : getSigningAlgorithm().hashCode())) * 31) + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode())) * 31;
        if (getDryRun() != null) {
            i11 = getDryRun().hashCode();
        }
        return hashCode + i11;
    }

    public Boolean isDryRun() {
        return this.dryRun;
    }

    public void setDryRun(Boolean bool) {
        this.dryRun = bool;
    }

    public void setGrantTokens(Collection<String> collection) {
        if (collection == null) {
            this.grantTokens = null;
        } else {
            this.grantTokens = new ArrayList(collection);
        }
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setMessage(ByteBuffer byteBuffer) {
        this.message = byteBuffer;
    }

    public void setMessageType(String str) {
        this.messageType = str;
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
        if (getMessage() != null) {
            sb2.append("Message: " + getMessage() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getMessageType() != null) {
            sb2.append("MessageType: " + getMessageType() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSignature() != null) {
            sb2.append("Signature: " + getSignature() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSigningAlgorithm() != null) {
            sb2.append("SigningAlgorithm: " + getSigningAlgorithm() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getGrantTokens() != null) {
            sb2.append("GrantTokens: " + getGrantTokens() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDryRun() != null) {
            sb2.append("DryRun: " + getDryRun());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public VerifyRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public VerifyRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.grantTokens.add(add);
        }
        return this;
    }

    public VerifyRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public VerifyRequest withMessage(ByteBuffer byteBuffer) {
        this.message = byteBuffer;
        return this;
    }

    public VerifyRequest withMessageType(String str) {
        this.messageType = str;
        return this;
    }

    public VerifyRequest withSignature(ByteBuffer byteBuffer) {
        this.signature = byteBuffer;
        return this;
    }

    public VerifyRequest withSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
        return this;
    }

    public void setMessageType(MessageType messageType2) {
        this.messageType = messageType2.toString();
    }

    public void setSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
    }

    public VerifyRequest withMessageType(MessageType messageType2) {
        this.messageType = messageType2.toString();
        return this;
    }

    public VerifyRequest withSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
        return this;
    }

    public VerifyRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
