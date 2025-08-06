package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AssumeRoleWithSAMLRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer durationSeconds;
    private String policy;
    private List<PolicyDescriptorType> policyArns;
    private String principalArn;
    private String roleArn;
    private String sAMLAssertion;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssumeRoleWithSAMLRequest)) {
            return false;
        }
        AssumeRoleWithSAMLRequest assumeRoleWithSAMLRequest = (AssumeRoleWithSAMLRequest) obj;
        if ((assumeRoleWithSAMLRequest.getRoleArn() == null) ^ (getRoleArn() == null)) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getRoleArn() != null && !assumeRoleWithSAMLRequest.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if ((assumeRoleWithSAMLRequest.getPrincipalArn() == null) ^ (getPrincipalArn() == null)) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPrincipalArn() != null && !assumeRoleWithSAMLRequest.getPrincipalArn().equals(getPrincipalArn())) {
            return false;
        }
        if ((assumeRoleWithSAMLRequest.getSAMLAssertion() == null) ^ (getSAMLAssertion() == null)) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getSAMLAssertion() != null && !assumeRoleWithSAMLRequest.getSAMLAssertion().equals(getSAMLAssertion())) {
            return false;
        }
        if ((assumeRoleWithSAMLRequest.getPolicyArns() == null) ^ (getPolicyArns() == null)) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPolicyArns() != null && !assumeRoleWithSAMLRequest.getPolicyArns().equals(getPolicyArns())) {
            return false;
        }
        if ((assumeRoleWithSAMLRequest.getPolicy() == null) ^ (getPolicy() == null)) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPolicy() != null && !assumeRoleWithSAMLRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if ((assumeRoleWithSAMLRequest.getDurationSeconds() == null) ^ (getDurationSeconds() == null)) {
            return false;
        }
        return assumeRoleWithSAMLRequest.getDurationSeconds() == null || assumeRoleWithSAMLRequest.getDurationSeconds().equals(getDurationSeconds());
    }

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public String getPolicy() {
        return this.policy;
    }

    public List<PolicyDescriptorType> getPolicyArns() {
        return this.policyArns;
    }

    public String getPrincipalArn() {
        return this.principalArn;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public String getSAMLAssertion() {
        return this.sAMLAssertion;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((getRoleArn() == null ? 0 : getRoleArn().hashCode()) + 31) * 31) + (getPrincipalArn() == null ? 0 : getPrincipalArn().hashCode())) * 31) + (getSAMLAssertion() == null ? 0 : getSAMLAssertion().hashCode())) * 31) + (getPolicyArns() == null ? 0 : getPolicyArns().hashCode())) * 31) + (getPolicy() == null ? 0 : getPolicy().hashCode())) * 31;
        if (getDurationSeconds() != null) {
            i11 = getDurationSeconds().hashCode();
        }
        return hashCode + i11;
    }

    public void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
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

    public void setPrincipalArn(String str) {
        this.principalArn = str;
    }

    public void setRoleArn(String str) {
        this.roleArn = str;
    }

    public void setSAMLAssertion(String str) {
        this.sAMLAssertion = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getRoleArn() != null) {
            sb2.append("RoleArn: " + getRoleArn() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPrincipalArn() != null) {
            sb2.append("PrincipalArn: " + getPrincipalArn() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSAMLAssertion() != null) {
            sb2.append("SAMLAssertion: " + getSAMLAssertion() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPolicyArns() != null) {
            sb2.append("PolicyArns: " + getPolicyArns() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPolicy() != null) {
            sb2.append("Policy: " + getPolicy() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDurationSeconds() != null) {
            sb2.append("DurationSeconds: " + getDurationSeconds());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public AssumeRoleWithSAMLRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public AssumeRoleWithSAMLRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public AssumeRoleWithSAMLRequest withPolicyArns(PolicyDescriptorType... policyDescriptorTypeArr) {
        if (getPolicyArns() == null) {
            this.policyArns = new ArrayList(policyDescriptorTypeArr.length);
        }
        for (PolicyDescriptorType add : policyDescriptorTypeArr) {
            this.policyArns.add(add);
        }
        return this;
    }

    public AssumeRoleWithSAMLRequest withPrincipalArn(String str) {
        this.principalArn = str;
        return this;
    }

    public AssumeRoleWithSAMLRequest withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public AssumeRoleWithSAMLRequest withSAMLAssertion(String str) {
        this.sAMLAssertion = str;
        return this;
    }

    public AssumeRoleWithSAMLRequest withPolicyArns(Collection<PolicyDescriptorType> collection) {
        setPolicyArns(collection);
        return this;
    }
}
