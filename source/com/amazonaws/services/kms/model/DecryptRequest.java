package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecryptRequest extends AmazonWebServiceRequest implements Serializable {
    private ByteBuffer ciphertextBlob;
    private Boolean dryRun;
    private String encryptionAlgorithm;
    private Map<String, String> encryptionContext = new HashMap();
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private RecipientInfo recipient;

    public DecryptRequest addEncryptionContextEntry(String str, String str2) {
        if (this.encryptionContext == null) {
            this.encryptionContext = new HashMap();
        }
        if (!this.encryptionContext.containsKey(str)) {
            this.encryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public DecryptRequest clearEncryptionContextEntries() {
        this.encryptionContext = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DecryptRequest)) {
            return false;
        }
        DecryptRequest decryptRequest = (DecryptRequest) obj;
        if ((decryptRequest.getCiphertextBlob() == null) ^ (getCiphertextBlob() == null)) {
            return false;
        }
        if (decryptRequest.getCiphertextBlob() != null && !decryptRequest.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if ((decryptRequest.getEncryptionContext() == null) ^ (getEncryptionContext() == null)) {
            return false;
        }
        if (decryptRequest.getEncryptionContext() != null && !decryptRequest.getEncryptionContext().equals(getEncryptionContext())) {
            return false;
        }
        if ((decryptRequest.getGrantTokens() == null) ^ (getGrantTokens() == null)) {
            return false;
        }
        if (decryptRequest.getGrantTokens() != null && !decryptRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if ((decryptRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (decryptRequest.getKeyId() != null && !decryptRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((decryptRequest.getEncryptionAlgorithm() == null) ^ (getEncryptionAlgorithm() == null)) {
            return false;
        }
        if (decryptRequest.getEncryptionAlgorithm() != null && !decryptRequest.getEncryptionAlgorithm().equals(getEncryptionAlgorithm())) {
            return false;
        }
        if ((decryptRequest.getRecipient() == null) ^ (getRecipient() == null)) {
            return false;
        }
        if (decryptRequest.getRecipient() != null && !decryptRequest.getRecipient().equals(getRecipient())) {
            return false;
        }
        if ((decryptRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        return decryptRequest.getDryRun() == null || decryptRequest.getDryRun().equals(getDryRun());
    }

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public Boolean getDryRun() {
        return this.dryRun;
    }

    public String getEncryptionAlgorithm() {
        return this.encryptionAlgorithm;
    }

    public Map<String, String> getEncryptionContext() {
        return this.encryptionContext;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public RecipientInfo getRecipient() {
        return this.recipient;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((((getCiphertextBlob() == null ? 0 : getCiphertextBlob().hashCode()) + 31) * 31) + (getEncryptionContext() == null ? 0 : getEncryptionContext().hashCode())) * 31) + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode())) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31) + (getEncryptionAlgorithm() == null ? 0 : getEncryptionAlgorithm().hashCode())) * 31) + (getRecipient() == null ? 0 : getRecipient().hashCode())) * 31;
        if (getDryRun() != null) {
            i11 = getDryRun().hashCode();
        }
        return hashCode + i11;
    }

    public Boolean isDryRun() {
        return this.dryRun;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
    }

    public void setDryRun(Boolean bool) {
        this.dryRun = bool;
    }

    public void setEncryptionAlgorithm(String str) {
        this.encryptionAlgorithm = str;
    }

    public void setEncryptionContext(Map<String, String> map) {
        this.encryptionContext = map;
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

    public void setRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getCiphertextBlob() != null) {
            sb2.append("CiphertextBlob: " + getCiphertextBlob() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getEncryptionContext() != null) {
            sb2.append("EncryptionContext: " + getEncryptionContext() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getGrantTokens() != null) {
            sb2.append("GrantTokens: " + getGrantTokens() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getEncryptionAlgorithm() != null) {
            sb2.append("EncryptionAlgorithm: " + getEncryptionAlgorithm() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRecipient() != null) {
            sb2.append("Recipient: " + getRecipient() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDryRun() != null) {
            sb2.append("DryRun: " + getDryRun());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public DecryptRequest withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public DecryptRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public DecryptRequest withEncryptionAlgorithm(String str) {
        this.encryptionAlgorithm = str;
        return this;
    }

    public DecryptRequest withEncryptionContext(Map<String, String> map) {
        this.encryptionContext = map;
        return this;
    }

    public DecryptRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.grantTokens.add(add);
        }
        return this;
    }

    public DecryptRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public DecryptRequest withRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
        return this;
    }

    public void setEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.encryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public DecryptRequest withEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.encryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }

    public DecryptRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
