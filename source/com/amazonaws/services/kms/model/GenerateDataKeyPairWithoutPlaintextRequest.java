package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateDataKeyPairWithoutPlaintextRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean dryRun;
    private Map<String, String> encryptionContext = new HashMap();
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private String keyPairSpec;

    public GenerateDataKeyPairWithoutPlaintextRequest addEncryptionContextEntry(String str, String str2) {
        if (this.encryptionContext == null) {
            this.encryptionContext = new HashMap();
        }
        if (!this.encryptionContext.containsKey(str)) {
            this.encryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GenerateDataKeyPairWithoutPlaintextRequest clearEncryptionContextEntries() {
        this.encryptionContext = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyPairWithoutPlaintextRequest)) {
            return false;
        }
        GenerateDataKeyPairWithoutPlaintextRequest generateDataKeyPairWithoutPlaintextRequest = (GenerateDataKeyPairWithoutPlaintextRequest) obj;
        if ((generateDataKeyPairWithoutPlaintextRequest.getEncryptionContext() == null) ^ (getEncryptionContext() == null)) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextRequest.getEncryptionContext() != null && !generateDataKeyPairWithoutPlaintextRequest.getEncryptionContext().equals(getEncryptionContext())) {
            return false;
        }
        if ((generateDataKeyPairWithoutPlaintextRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextRequest.getKeyId() != null && !generateDataKeyPairWithoutPlaintextRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((generateDataKeyPairWithoutPlaintextRequest.getKeyPairSpec() == null) ^ (getKeyPairSpec() == null)) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextRequest.getKeyPairSpec() != null && !generateDataKeyPairWithoutPlaintextRequest.getKeyPairSpec().equals(getKeyPairSpec())) {
            return false;
        }
        if ((generateDataKeyPairWithoutPlaintextRequest.getGrantTokens() == null) ^ (getGrantTokens() == null)) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextRequest.getGrantTokens() != null && !generateDataKeyPairWithoutPlaintextRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if ((generateDataKeyPairWithoutPlaintextRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        return generateDataKeyPairWithoutPlaintextRequest.getDryRun() == null || generateDataKeyPairWithoutPlaintextRequest.getDryRun().equals(getDryRun());
    }

    public Boolean getDryRun() {
        return this.dryRun;
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

    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((getEncryptionContext() == null ? 0 : getEncryptionContext().hashCode()) + 31) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31) + (getKeyPairSpec() == null ? 0 : getKeyPairSpec().hashCode())) * 31) + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode())) * 31;
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

    public void setKeyPairSpec(String str) {
        this.keyPairSpec = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getEncryptionContext() != null) {
            sb2.append("EncryptionContext: " + getEncryptionContext() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyPairSpec() != null) {
            sb2.append("KeyPairSpec: " + getKeyPairSpec() + Constants.ACCEPT_TIME_SEPARATOR_SP);
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

    public GenerateDataKeyPairWithoutPlaintextRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest withEncryptionContext(Map<String, String> map) {
        this.encryptionContext = map;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.grantTokens.add(add);
        }
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest withKeyPairSpec(String str) {
        this.keyPairSpec = str;
        return this;
    }

    public void setKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
    }

    public GenerateDataKeyPairWithoutPlaintextRequest withKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
