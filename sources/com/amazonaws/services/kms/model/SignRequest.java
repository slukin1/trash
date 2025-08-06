package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SignRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean dryRun;
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private ByteBuffer message;
    private String messageType;
    private String signingAlgorithm;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SignRequest)) {
            return false;
        }
        SignRequest signRequest = (SignRequest) obj;
        if ((signRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (signRequest.getKeyId() != null && !signRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((signRequest.getMessage() == null) ^ (getMessage() == null)) {
            return false;
        }
        if (signRequest.getMessage() != null && !signRequest.getMessage().equals(getMessage())) {
            return false;
        }
        if ((signRequest.getMessageType() == null) ^ (getMessageType() == null)) {
            return false;
        }
        if (signRequest.getMessageType() != null && !signRequest.getMessageType().equals(getMessageType())) {
            return false;
        }
        if ((signRequest.getGrantTokens() == null) ^ (getGrantTokens() == null)) {
            return false;
        }
        if (signRequest.getGrantTokens() != null && !signRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if ((signRequest.getSigningAlgorithm() == null) ^ (getSigningAlgorithm() == null)) {
            return false;
        }
        if (signRequest.getSigningAlgorithm() != null && !signRequest.getSigningAlgorithm().equals(getSigningAlgorithm())) {
            return false;
        }
        if ((signRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        return signRequest.getDryRun() == null || signRequest.getDryRun().equals(getDryRun());
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

    public String getSigningAlgorithm() {
        return this.signingAlgorithm;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getMessage() == null ? 0 : getMessage().hashCode())) * 31) + (getMessageType() == null ? 0 : getMessageType().hashCode())) * 31) + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode())) * 31) + (getSigningAlgorithm() == null ? 0 : getSigningAlgorithm().hashCode())) * 31;
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
        if (getGrantTokens() != null) {
            sb2.append("GrantTokens: " + getGrantTokens() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSigningAlgorithm() != null) {
            sb2.append("SigningAlgorithm: " + getSigningAlgorithm() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDryRun() != null) {
            sb2.append("DryRun: " + getDryRun());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public SignRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public SignRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.grantTokens.add(add);
        }
        return this;
    }

    public SignRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public SignRequest withMessage(ByteBuffer byteBuffer) {
        this.message = byteBuffer;
        return this;
    }

    public SignRequest withMessageType(String str) {
        this.messageType = str;
        return this;
    }

    public SignRequest withSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
        return this;
    }

    public void setMessageType(MessageType messageType2) {
        this.messageType = messageType2.toString();
    }

    public void setSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
    }

    public SignRequest withMessageType(MessageType messageType2) {
        this.messageType = messageType2.toString();
        return this;
    }

    public SignRequest withSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
        return this;
    }

    public SignRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
