package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeriveSharedSecretRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean dryRun;
    private List<String> grantTokens = new ArrayList();
    private String keyAgreementAlgorithm;
    private String keyId;
    private ByteBuffer publicKey;
    private RecipientInfo recipient;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeriveSharedSecretRequest)) {
            return false;
        }
        DeriveSharedSecretRequest deriveSharedSecretRequest = (DeriveSharedSecretRequest) obj;
        if ((deriveSharedSecretRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (deriveSharedSecretRequest.getKeyId() != null && !deriveSharedSecretRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((deriveSharedSecretRequest.getKeyAgreementAlgorithm() == null) ^ (getKeyAgreementAlgorithm() == null)) {
            return false;
        }
        if (deriveSharedSecretRequest.getKeyAgreementAlgorithm() != null && !deriveSharedSecretRequest.getKeyAgreementAlgorithm().equals(getKeyAgreementAlgorithm())) {
            return false;
        }
        if ((deriveSharedSecretRequest.getPublicKey() == null) ^ (getPublicKey() == null)) {
            return false;
        }
        if (deriveSharedSecretRequest.getPublicKey() != null && !deriveSharedSecretRequest.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if ((deriveSharedSecretRequest.getGrantTokens() == null) ^ (getGrantTokens() == null)) {
            return false;
        }
        if (deriveSharedSecretRequest.getGrantTokens() != null && !deriveSharedSecretRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if ((deriveSharedSecretRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        if (deriveSharedSecretRequest.getDryRun() != null && !deriveSharedSecretRequest.getDryRun().equals(getDryRun())) {
            return false;
        }
        if ((deriveSharedSecretRequest.getRecipient() == null) ^ (getRecipient() == null)) {
            return false;
        }
        return deriveSharedSecretRequest.getRecipient() == null || deriveSharedSecretRequest.getRecipient().equals(getRecipient());
    }

    public Boolean getDryRun() {
        return this.dryRun;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public String getKeyAgreementAlgorithm() {
        return this.keyAgreementAlgorithm;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public ByteBuffer getPublicKey() {
        return this.publicKey;
    }

    public RecipientInfo getRecipient() {
        return this.recipient;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getKeyAgreementAlgorithm() == null ? 0 : getKeyAgreementAlgorithm().hashCode())) * 31) + (getPublicKey() == null ? 0 : getPublicKey().hashCode())) * 31) + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode())) * 31) + (getDryRun() == null ? 0 : getDryRun().hashCode())) * 31;
        if (getRecipient() != null) {
            i11 = getRecipient().hashCode();
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

    public void setKeyAgreementAlgorithm(String str) {
        this.keyAgreementAlgorithm = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
    }

    public void setRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyAgreementAlgorithm() != null) {
            sb2.append("KeyAgreementAlgorithm: " + getKeyAgreementAlgorithm() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPublicKey() != null) {
            sb2.append("PublicKey: " + getPublicKey() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getGrantTokens() != null) {
            sb2.append("GrantTokens: " + getGrantTokens() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDryRun() != null) {
            sb2.append("DryRun: " + getDryRun() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRecipient() != null) {
            sb2.append("Recipient: " + getRecipient());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public DeriveSharedSecretRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public DeriveSharedSecretRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.grantTokens.add(add);
        }
        return this;
    }

    public DeriveSharedSecretRequest withKeyAgreementAlgorithm(String str) {
        this.keyAgreementAlgorithm = str;
        return this;
    }

    public DeriveSharedSecretRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public DeriveSharedSecretRequest withPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
        return this;
    }

    public DeriveSharedSecretRequest withRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
        return this;
    }

    public void setKeyAgreementAlgorithm(KeyAgreementAlgorithmSpec keyAgreementAlgorithmSpec) {
        this.keyAgreementAlgorithm = keyAgreementAlgorithmSpec.toString();
    }

    public DeriveSharedSecretRequest withKeyAgreementAlgorithm(KeyAgreementAlgorithmSpec keyAgreementAlgorithmSpec) {
        this.keyAgreementAlgorithm = keyAgreementAlgorithmSpec.toString();
        return this;
    }

    public DeriveSharedSecretRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
