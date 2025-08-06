package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReplicateKeyRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean bypassPolicyLockoutSafetyCheck;
    private String description;
    private String keyId;
    private String policy;
    private String replicaRegion;
    private List<Tag> tags = new ArrayList();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReplicateKeyRequest)) {
            return false;
        }
        ReplicateKeyRequest replicateKeyRequest = (ReplicateKeyRequest) obj;
        if ((replicateKeyRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (replicateKeyRequest.getKeyId() != null && !replicateKeyRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((replicateKeyRequest.getReplicaRegion() == null) ^ (getReplicaRegion() == null)) {
            return false;
        }
        if (replicateKeyRequest.getReplicaRegion() != null && !replicateKeyRequest.getReplicaRegion().equals(getReplicaRegion())) {
            return false;
        }
        if ((replicateKeyRequest.getPolicy() == null) ^ (getPolicy() == null)) {
            return false;
        }
        if (replicateKeyRequest.getPolicy() != null && !replicateKeyRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if ((replicateKeyRequest.getBypassPolicyLockoutSafetyCheck() == null) ^ (getBypassPolicyLockoutSafetyCheck() == null)) {
            return false;
        }
        if (replicateKeyRequest.getBypassPolicyLockoutSafetyCheck() != null && !replicateKeyRequest.getBypassPolicyLockoutSafetyCheck().equals(getBypassPolicyLockoutSafetyCheck())) {
            return false;
        }
        if ((replicateKeyRequest.getDescription() == null) ^ (getDescription() == null)) {
            return false;
        }
        if (replicateKeyRequest.getDescription() != null && !replicateKeyRequest.getDescription().equals(getDescription())) {
            return false;
        }
        if ((replicateKeyRequest.getTags() == null) ^ (getTags() == null)) {
            return false;
        }
        return replicateKeyRequest.getTags() == null || replicateKeyRequest.getTags().equals(getTags());
    }

    public Boolean getBypassPolicyLockoutSafetyCheck() {
        return this.bypassPolicyLockoutSafetyCheck;
    }

    public String getDescription() {
        return this.description;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getPolicy() {
        return this.policy;
    }

    public String getReplicaRegion() {
        return this.replicaRegion;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int i11;
        int i12 = 0;
        int hashCode = ((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getReplicaRegion() == null ? 0 : getReplicaRegion().hashCode())) * 31) + (getPolicy() == null ? 0 : getPolicy().hashCode())) * 31;
        if (getBypassPolicyLockoutSafetyCheck() == null) {
            i11 = 0;
        } else {
            i11 = getBypassPolicyLockoutSafetyCheck().hashCode();
        }
        int hashCode2 = (((hashCode + i11) * 31) + (getDescription() == null ? 0 : getDescription().hashCode())) * 31;
        if (getTags() != null) {
            i12 = getTags().hashCode();
        }
        return hashCode2 + i12;
    }

    public Boolean isBypassPolicyLockoutSafetyCheck() {
        return this.bypassPolicyLockoutSafetyCheck;
    }

    public void setBypassPolicyLockoutSafetyCheck(Boolean bool) {
        this.bypassPolicyLockoutSafetyCheck = bool;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public void setReplicaRegion(String str) {
        this.replicaRegion = str;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            this.tags = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getReplicaRegion() != null) {
            sb2.append("ReplicaRegion: " + getReplicaRegion() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPolicy() != null) {
            sb2.append("Policy: " + getPolicy() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getBypassPolicyLockoutSafetyCheck() != null) {
            sb2.append("BypassPolicyLockoutSafetyCheck: " + getBypassPolicyLockoutSafetyCheck() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDescription() != null) {
            sb2.append("Description: " + getDescription() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTags() != null) {
            sb2.append("Tags: " + getTags());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ReplicateKeyRequest withBypassPolicyLockoutSafetyCheck(Boolean bool) {
        this.bypassPolicyLockoutSafetyCheck = bool;
        return this;
    }

    public ReplicateKeyRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public ReplicateKeyRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ReplicateKeyRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public ReplicateKeyRequest withReplicaRegion(String str) {
        this.replicaRegion = str;
        return this;
    }

    public ReplicateKeyRequest withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag add : tagArr) {
            this.tags.add(add);
        }
        return this;
    }

    public ReplicateKeyRequest withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }
}
