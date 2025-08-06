package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AssumeRoleRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer durationSeconds;
    private String externalId;
    private String policy;
    private List<PolicyDescriptorType> policyArns;
    private List<ProvidedContext> providedContexts;
    private String roleArn;
    private String roleSessionName;
    private String serialNumber;
    private String sourceIdentity;
    private List<Tag> tags;
    private String tokenCode;
    private List<String> transitiveTagKeys;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssumeRoleRequest)) {
            return false;
        }
        AssumeRoleRequest assumeRoleRequest = (AssumeRoleRequest) obj;
        if ((assumeRoleRequest.getRoleArn() == null) ^ (getRoleArn() == null)) {
            return false;
        }
        if (assumeRoleRequest.getRoleArn() != null && !assumeRoleRequest.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if ((assumeRoleRequest.getRoleSessionName() == null) ^ (getRoleSessionName() == null)) {
            return false;
        }
        if (assumeRoleRequest.getRoleSessionName() != null && !assumeRoleRequest.getRoleSessionName().equals(getRoleSessionName())) {
            return false;
        }
        if ((assumeRoleRequest.getPolicyArns() == null) ^ (getPolicyArns() == null)) {
            return false;
        }
        if (assumeRoleRequest.getPolicyArns() != null && !assumeRoleRequest.getPolicyArns().equals(getPolicyArns())) {
            return false;
        }
        if ((assumeRoleRequest.getPolicy() == null) ^ (getPolicy() == null)) {
            return false;
        }
        if (assumeRoleRequest.getPolicy() != null && !assumeRoleRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if ((assumeRoleRequest.getDurationSeconds() == null) ^ (getDurationSeconds() == null)) {
            return false;
        }
        if (assumeRoleRequest.getDurationSeconds() != null && !assumeRoleRequest.getDurationSeconds().equals(getDurationSeconds())) {
            return false;
        }
        if ((assumeRoleRequest.getTags() == null) ^ (getTags() == null)) {
            return false;
        }
        if (assumeRoleRequest.getTags() != null && !assumeRoleRequest.getTags().equals(getTags())) {
            return false;
        }
        if ((assumeRoleRequest.getTransitiveTagKeys() == null) ^ (getTransitiveTagKeys() == null)) {
            return false;
        }
        if (assumeRoleRequest.getTransitiveTagKeys() != null && !assumeRoleRequest.getTransitiveTagKeys().equals(getTransitiveTagKeys())) {
            return false;
        }
        if ((assumeRoleRequest.getExternalId() == null) ^ (getExternalId() == null)) {
            return false;
        }
        if (assumeRoleRequest.getExternalId() != null && !assumeRoleRequest.getExternalId().equals(getExternalId())) {
            return false;
        }
        if ((assumeRoleRequest.getSerialNumber() == null) ^ (getSerialNumber() == null)) {
            return false;
        }
        if (assumeRoleRequest.getSerialNumber() != null && !assumeRoleRequest.getSerialNumber().equals(getSerialNumber())) {
            return false;
        }
        if ((assumeRoleRequest.getTokenCode() == null) ^ (getTokenCode() == null)) {
            return false;
        }
        if (assumeRoleRequest.getTokenCode() != null && !assumeRoleRequest.getTokenCode().equals(getTokenCode())) {
            return false;
        }
        if ((assumeRoleRequest.getSourceIdentity() == null) ^ (getSourceIdentity() == null)) {
            return false;
        }
        if (assumeRoleRequest.getSourceIdentity() != null && !assumeRoleRequest.getSourceIdentity().equals(getSourceIdentity())) {
            return false;
        }
        if ((assumeRoleRequest.getProvidedContexts() == null) ^ (getProvidedContexts() == null)) {
            return false;
        }
        return assumeRoleRequest.getProvidedContexts() == null || assumeRoleRequest.getProvidedContexts().equals(getProvidedContexts());
    }

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getPolicy() {
        return this.policy;
    }

    public List<PolicyDescriptorType> getPolicyArns() {
        return this.policyArns;
    }

    public List<ProvidedContext> getProvidedContexts() {
        return this.providedContexts;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public String getRoleSessionName() {
        return this.roleSessionName;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getSourceIdentity() {
        return this.sourceIdentity;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public String getTokenCode() {
        return this.tokenCode;
    }

    public List<String> getTransitiveTagKeys() {
        return this.transitiveTagKeys;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((((((((((((((getRoleArn() == null ? 0 : getRoleArn().hashCode()) + 31) * 31) + (getRoleSessionName() == null ? 0 : getRoleSessionName().hashCode())) * 31) + (getPolicyArns() == null ? 0 : getPolicyArns().hashCode())) * 31) + (getPolicy() == null ? 0 : getPolicy().hashCode())) * 31) + (getDurationSeconds() == null ? 0 : getDurationSeconds().hashCode())) * 31) + (getTags() == null ? 0 : getTags().hashCode())) * 31) + (getTransitiveTagKeys() == null ? 0 : getTransitiveTagKeys().hashCode())) * 31) + (getExternalId() == null ? 0 : getExternalId().hashCode())) * 31) + (getSerialNumber() == null ? 0 : getSerialNumber().hashCode())) * 31) + (getTokenCode() == null ? 0 : getTokenCode().hashCode())) * 31) + (getSourceIdentity() == null ? 0 : getSourceIdentity().hashCode())) * 31;
        if (getProvidedContexts() != null) {
            i11 = getProvidedContexts().hashCode();
        }
        return hashCode + i11;
    }

    public void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public void setExternalId(String str) {
        this.externalId = str;
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

    public void setProvidedContexts(Collection<ProvidedContext> collection) {
        if (collection == null) {
            this.providedContexts = null;
        } else {
            this.providedContexts = new ArrayList(collection);
        }
    }

    public void setRoleArn(String str) {
        this.roleArn = str;
    }

    public void setRoleSessionName(String str) {
        this.roleSessionName = str;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public void setSourceIdentity(String str) {
        this.sourceIdentity = str;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            this.tags = new ArrayList(collection);
        }
    }

    public void setTokenCode(String str) {
        this.tokenCode = str;
    }

    public void setTransitiveTagKeys(Collection<String> collection) {
        if (collection == null) {
            this.transitiveTagKeys = null;
        } else {
            this.transitiveTagKeys = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getRoleArn() != null) {
            sb2.append("RoleArn: " + getRoleArn() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRoleSessionName() != null) {
            sb2.append("RoleSessionName: " + getRoleSessionName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPolicyArns() != null) {
            sb2.append("PolicyArns: " + getPolicyArns() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPolicy() != null) {
            sb2.append("Policy: " + getPolicy() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDurationSeconds() != null) {
            sb2.append("DurationSeconds: " + getDurationSeconds() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTags() != null) {
            sb2.append("Tags: " + getTags() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTransitiveTagKeys() != null) {
            sb2.append("TransitiveTagKeys: " + getTransitiveTagKeys() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getExternalId() != null) {
            sb2.append("ExternalId: " + getExternalId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSerialNumber() != null) {
            sb2.append("SerialNumber: " + getSerialNumber() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTokenCode() != null) {
            sb2.append("TokenCode: " + getTokenCode() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSourceIdentity() != null) {
            sb2.append("SourceIdentity: " + getSourceIdentity() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getProvidedContexts() != null) {
            sb2.append("ProvidedContexts: " + getProvidedContexts());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public AssumeRoleRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public AssumeRoleRequest withExternalId(String str) {
        this.externalId = str;
        return this;
    }

    public AssumeRoleRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public AssumeRoleRequest withPolicyArns(PolicyDescriptorType... policyDescriptorTypeArr) {
        if (getPolicyArns() == null) {
            this.policyArns = new ArrayList(policyDescriptorTypeArr.length);
        }
        for (PolicyDescriptorType add : policyDescriptorTypeArr) {
            this.policyArns.add(add);
        }
        return this;
    }

    public AssumeRoleRequest withProvidedContexts(ProvidedContext... providedContextArr) {
        if (getProvidedContexts() == null) {
            this.providedContexts = new ArrayList(providedContextArr.length);
        }
        for (ProvidedContext add : providedContextArr) {
            this.providedContexts.add(add);
        }
        return this;
    }

    public AssumeRoleRequest withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public AssumeRoleRequest withRoleSessionName(String str) {
        this.roleSessionName = str;
        return this;
    }

    public AssumeRoleRequest withSerialNumber(String str) {
        this.serialNumber = str;
        return this;
    }

    public AssumeRoleRequest withSourceIdentity(String str) {
        this.sourceIdentity = str;
        return this;
    }

    public AssumeRoleRequest withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag add : tagArr) {
            this.tags.add(add);
        }
        return this;
    }

    public AssumeRoleRequest withTokenCode(String str) {
        this.tokenCode = str;
        return this;
    }

    public AssumeRoleRequest withTransitiveTagKeys(String... strArr) {
        if (getTransitiveTagKeys() == null) {
            this.transitiveTagKeys = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.transitiveTagKeys.add(add);
        }
        return this;
    }

    public AssumeRoleRequest withPolicyArns(Collection<PolicyDescriptorType> collection) {
        setPolicyArns(collection);
        return this;
    }

    public AssumeRoleRequest withProvidedContexts(Collection<ProvidedContext> collection) {
        setProvidedContexts(collection);
        return this;
    }

    public AssumeRoleRequest withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }

    public AssumeRoleRequest withTransitiveTagKeys(Collection<String> collection) {
        setTransitiveTagKeys(collection);
        return this;
    }
}
