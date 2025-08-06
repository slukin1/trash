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

public class ReEncryptRequest extends AmazonWebServiceRequest implements Serializable {
    private ByteBuffer ciphertextBlob;
    private String destinationEncryptionAlgorithm;
    private Map<String, String> destinationEncryptionContext = new HashMap();
    private String destinationKeyId;
    private Boolean dryRun;
    private List<String> grantTokens = new ArrayList();
    private String sourceEncryptionAlgorithm;
    private Map<String, String> sourceEncryptionContext = new HashMap();
    private String sourceKeyId;

    public ReEncryptRequest addDestinationEncryptionContextEntry(String str, String str2) {
        if (this.destinationEncryptionContext == null) {
            this.destinationEncryptionContext = new HashMap();
        }
        if (!this.destinationEncryptionContext.containsKey(str)) {
            this.destinationEncryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public ReEncryptRequest addSourceEncryptionContextEntry(String str, String str2) {
        if (this.sourceEncryptionContext == null) {
            this.sourceEncryptionContext = new HashMap();
        }
        if (!this.sourceEncryptionContext.containsKey(str)) {
            this.sourceEncryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public ReEncryptRequest clearDestinationEncryptionContextEntries() {
        this.destinationEncryptionContext = null;
        return this;
    }

    public ReEncryptRequest clearSourceEncryptionContextEntries() {
        this.sourceEncryptionContext = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReEncryptRequest)) {
            return false;
        }
        ReEncryptRequest reEncryptRequest = (ReEncryptRequest) obj;
        if ((reEncryptRequest.getCiphertextBlob() == null) ^ (getCiphertextBlob() == null)) {
            return false;
        }
        if (reEncryptRequest.getCiphertextBlob() != null && !reEncryptRequest.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if ((reEncryptRequest.getSourceEncryptionContext() == null) ^ (getSourceEncryptionContext() == null)) {
            return false;
        }
        if (reEncryptRequest.getSourceEncryptionContext() != null && !reEncryptRequest.getSourceEncryptionContext().equals(getSourceEncryptionContext())) {
            return false;
        }
        if ((reEncryptRequest.getSourceKeyId() == null) ^ (getSourceKeyId() == null)) {
            return false;
        }
        if (reEncryptRequest.getSourceKeyId() != null && !reEncryptRequest.getSourceKeyId().equals(getSourceKeyId())) {
            return false;
        }
        if ((reEncryptRequest.getDestinationKeyId() == null) ^ (getDestinationKeyId() == null)) {
            return false;
        }
        if (reEncryptRequest.getDestinationKeyId() != null && !reEncryptRequest.getDestinationKeyId().equals(getDestinationKeyId())) {
            return false;
        }
        if ((reEncryptRequest.getDestinationEncryptionContext() == null) ^ (getDestinationEncryptionContext() == null)) {
            return false;
        }
        if (reEncryptRequest.getDestinationEncryptionContext() != null && !reEncryptRequest.getDestinationEncryptionContext().equals(getDestinationEncryptionContext())) {
            return false;
        }
        if ((reEncryptRequest.getSourceEncryptionAlgorithm() == null) ^ (getSourceEncryptionAlgorithm() == null)) {
            return false;
        }
        if (reEncryptRequest.getSourceEncryptionAlgorithm() != null && !reEncryptRequest.getSourceEncryptionAlgorithm().equals(getSourceEncryptionAlgorithm())) {
            return false;
        }
        if ((reEncryptRequest.getDestinationEncryptionAlgorithm() == null) ^ (getDestinationEncryptionAlgorithm() == null)) {
            return false;
        }
        if (reEncryptRequest.getDestinationEncryptionAlgorithm() != null && !reEncryptRequest.getDestinationEncryptionAlgorithm().equals(getDestinationEncryptionAlgorithm())) {
            return false;
        }
        if ((reEncryptRequest.getGrantTokens() == null) ^ (getGrantTokens() == null)) {
            return false;
        }
        if (reEncryptRequest.getGrantTokens() != null && !reEncryptRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if ((reEncryptRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        return reEncryptRequest.getDryRun() == null || reEncryptRequest.getDryRun().equals(getDryRun());
    }

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public String getDestinationEncryptionAlgorithm() {
        return this.destinationEncryptionAlgorithm;
    }

    public Map<String, String> getDestinationEncryptionContext() {
        return this.destinationEncryptionContext;
    }

    public String getDestinationKeyId() {
        return this.destinationKeyId;
    }

    public Boolean getDryRun() {
        return this.dryRun;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public String getSourceEncryptionAlgorithm() {
        return this.sourceEncryptionAlgorithm;
    }

    public Map<String, String> getSourceEncryptionContext() {
        return this.sourceEncryptionContext;
    }

    public String getSourceKeyId() {
        return this.sourceKeyId;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = 0;
        int hashCode = ((getCiphertextBlob() == null ? 0 : getCiphertextBlob().hashCode()) + 31) * 31;
        if (getSourceEncryptionContext() == null) {
            i11 = 0;
        } else {
            i11 = getSourceEncryptionContext().hashCode();
        }
        int hashCode2 = (((((hashCode + i11) * 31) + (getSourceKeyId() == null ? 0 : getSourceKeyId().hashCode())) * 31) + (getDestinationKeyId() == null ? 0 : getDestinationKeyId().hashCode())) * 31;
        if (getDestinationEncryptionContext() == null) {
            i12 = 0;
        } else {
            i12 = getDestinationEncryptionContext().hashCode();
        }
        int i16 = (hashCode2 + i12) * 31;
        if (getSourceEncryptionAlgorithm() == null) {
            i13 = 0;
        } else {
            i13 = getSourceEncryptionAlgorithm().hashCode();
        }
        int i17 = (i16 + i13) * 31;
        if (getDestinationEncryptionAlgorithm() == null) {
            i14 = 0;
        } else {
            i14 = getDestinationEncryptionAlgorithm().hashCode();
        }
        int hashCode3 = (((i17 + i14) * 31) + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode())) * 31;
        if (getDryRun() != null) {
            i15 = getDryRun().hashCode();
        }
        return hashCode3 + i15;
    }

    public Boolean isDryRun() {
        return this.dryRun;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
    }

    public void setDestinationEncryptionAlgorithm(String str) {
        this.destinationEncryptionAlgorithm = str;
    }

    public void setDestinationEncryptionContext(Map<String, String> map) {
        this.destinationEncryptionContext = map;
    }

    public void setDestinationKeyId(String str) {
        this.destinationKeyId = str;
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

    public void setSourceEncryptionAlgorithm(String str) {
        this.sourceEncryptionAlgorithm = str;
    }

    public void setSourceEncryptionContext(Map<String, String> map) {
        this.sourceEncryptionContext = map;
    }

    public void setSourceKeyId(String str) {
        this.sourceKeyId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getCiphertextBlob() != null) {
            sb2.append("CiphertextBlob: " + getCiphertextBlob() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSourceEncryptionContext() != null) {
            sb2.append("SourceEncryptionContext: " + getSourceEncryptionContext() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSourceKeyId() != null) {
            sb2.append("SourceKeyId: " + getSourceKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDestinationKeyId() != null) {
            sb2.append("DestinationKeyId: " + getDestinationKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDestinationEncryptionContext() != null) {
            sb2.append("DestinationEncryptionContext: " + getDestinationEncryptionContext() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSourceEncryptionAlgorithm() != null) {
            sb2.append("SourceEncryptionAlgorithm: " + getSourceEncryptionAlgorithm() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDestinationEncryptionAlgorithm() != null) {
            sb2.append("DestinationEncryptionAlgorithm: " + getDestinationEncryptionAlgorithm() + Constants.ACCEPT_TIME_SEPARATOR_SP);
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

    public ReEncryptRequest withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public ReEncryptRequest withDestinationEncryptionAlgorithm(String str) {
        this.destinationEncryptionAlgorithm = str;
        return this;
    }

    public ReEncryptRequest withDestinationEncryptionContext(Map<String, String> map) {
        this.destinationEncryptionContext = map;
        return this;
    }

    public ReEncryptRequest withDestinationKeyId(String str) {
        this.destinationKeyId = str;
        return this;
    }

    public ReEncryptRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public ReEncryptRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.grantTokens.add(add);
        }
        return this;
    }

    public ReEncryptRequest withSourceEncryptionAlgorithm(String str) {
        this.sourceEncryptionAlgorithm = str;
        return this;
    }

    public ReEncryptRequest withSourceEncryptionContext(Map<String, String> map) {
        this.sourceEncryptionContext = map;
        return this;
    }

    public ReEncryptRequest withSourceKeyId(String str) {
        this.sourceKeyId = str;
        return this;
    }

    public void setDestinationEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.destinationEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public void setSourceEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.sourceEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public ReEncryptRequest withDestinationEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.destinationEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }

    public ReEncryptRequest withSourceEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.sourceEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }

    public ReEncryptRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}
