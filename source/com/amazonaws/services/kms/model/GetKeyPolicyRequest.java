package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class GetKeyPolicyRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private String policyName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetKeyPolicyRequest)) {
            return false;
        }
        GetKeyPolicyRequest getKeyPolicyRequest = (GetKeyPolicyRequest) obj;
        if ((getKeyPolicyRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (getKeyPolicyRequest.getKeyId() != null && !getKeyPolicyRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((getKeyPolicyRequest.getPolicyName() == null) ^ (getPolicyName() == null)) {
            return false;
        }
        return getKeyPolicyRequest.getPolicyName() == null || getKeyPolicyRequest.getPolicyName().equals(getPolicyName());
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31;
        if (getPolicyName() != null) {
            i11 = getPolicyName().hashCode();
        }
        return hashCode + i11;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setPolicyName(String str) {
        this.policyName = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPolicyName() != null) {
            sb2.append("PolicyName: " + getPolicyName());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetKeyPolicyRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GetKeyPolicyRequest withPolicyName(String str) {
        this.policyName = str;
        return this;
    }
}
