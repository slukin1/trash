package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GetFederationTokenRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer durationSeconds;
    private String name;
    private String policy;
    private List<PolicyDescriptorType> policyArns;
    private List<Tag> tags;

    public GetFederationTokenRequest() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetFederationTokenRequest)) {
            return false;
        }
        GetFederationTokenRequest getFederationTokenRequest = (GetFederationTokenRequest) obj;
        if ((getFederationTokenRequest.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (getFederationTokenRequest.getName() != null && !getFederationTokenRequest.getName().equals(getName())) {
            return false;
        }
        if ((getFederationTokenRequest.getPolicy() == null) ^ (getPolicy() == null)) {
            return false;
        }
        if (getFederationTokenRequest.getPolicy() != null && !getFederationTokenRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if ((getFederationTokenRequest.getPolicyArns() == null) ^ (getPolicyArns() == null)) {
            return false;
        }
        if (getFederationTokenRequest.getPolicyArns() != null && !getFederationTokenRequest.getPolicyArns().equals(getPolicyArns())) {
            return false;
        }
        if ((getFederationTokenRequest.getDurationSeconds() == null) ^ (getDurationSeconds() == null)) {
            return false;
        }
        if (getFederationTokenRequest.getDurationSeconds() != null && !getFederationTokenRequest.getDurationSeconds().equals(getDurationSeconds())) {
            return false;
        }
        if ((getFederationTokenRequest.getTags() == null) ^ (getTags() == null)) {
            return false;
        }
        return getFederationTokenRequest.getTags() == null || getFederationTokenRequest.getTags().equals(getTags());
    }

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public String getName() {
        return this.name;
    }

    public String getPolicy() {
        return this.policy;
    }

    public List<PolicyDescriptorType> getPolicyArns() {
        return this.policyArns;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((getName() == null ? 0 : getName().hashCode()) + 31) * 31) + (getPolicy() == null ? 0 : getPolicy().hashCode())) * 31) + (getPolicyArns() == null ? 0 : getPolicyArns().hashCode())) * 31) + (getDurationSeconds() == null ? 0 : getDurationSeconds().hashCode())) * 31;
        if (getTags() != null) {
            i11 = getTags().hashCode();
        }
        return hashCode + i11;
    }

    public void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public void setPolicyArns(Collection<PolicyDescriptorType> collection) {
        if (collection == null) {
            this.policyArns = null;
        } else {
            this.policyArns = new ArrayList(collection);
        }
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
        if (getName() != null) {
            sb2.append("Name: " + getName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPolicy() != null) {
            sb2.append("Policy: " + getPolicy() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPolicyArns() != null) {
            sb2.append("PolicyArns: " + getPolicyArns() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDurationSeconds() != null) {
            sb2.append("DurationSeconds: " + getDurationSeconds() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTags() != null) {
            sb2.append("Tags: " + getTags());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetFederationTokenRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public GetFederationTokenRequest withName(String str) {
        this.name = str;
        return this;
    }

    public GetFederationTokenRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public GetFederationTokenRequest withPolicyArns(PolicyDescriptorType... policyDescriptorTypeArr) {
        if (getPolicyArns() == null) {
            this.policyArns = new ArrayList(policyDescriptorTypeArr.length);
        }
        for (PolicyDescriptorType add : policyDescriptorTypeArr) {
            this.policyArns.add(add);
        }
        return this;
    }

    public GetFederationTokenRequest withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag add : tagArr) {
            this.tags.add(add);
        }
        return this;
    }

    public GetFederationTokenRequest(String str) {
        setName(str);
    }

    public GetFederationTokenRequest withPolicyArns(Collection<PolicyDescriptorType> collection) {
        setPolicyArns(collection);
        return this;
    }

    public GetFederationTokenRequest withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }
}
