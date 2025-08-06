package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListKeyPoliciesResult implements Serializable {
    private String nextMarker;
    private List<String> policyNames = new ArrayList();
    private Boolean truncated;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListKeyPoliciesResult)) {
            return false;
        }
        ListKeyPoliciesResult listKeyPoliciesResult = (ListKeyPoliciesResult) obj;
        if ((listKeyPoliciesResult.getPolicyNames() == null) ^ (getPolicyNames() == null)) {
            return false;
        }
        if (listKeyPoliciesResult.getPolicyNames() != null && !listKeyPoliciesResult.getPolicyNames().equals(getPolicyNames())) {
            return false;
        }
        if ((listKeyPoliciesResult.getNextMarker() == null) ^ (getNextMarker() == null)) {
            return false;
        }
        if (listKeyPoliciesResult.getNextMarker() != null && !listKeyPoliciesResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if ((listKeyPoliciesResult.getTruncated() == null) ^ (getTruncated() == null)) {
            return false;
        }
        return listKeyPoliciesResult.getTruncated() == null || listKeyPoliciesResult.getTruncated().equals(getTruncated());
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public List<String> getPolicyNames() {
        return this.policyNames;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getPolicyNames() == null ? 0 : getPolicyNames().hashCode()) + 31) * 31) + (getNextMarker() == null ? 0 : getNextMarker().hashCode())) * 31;
        if (getTruncated() != null) {
            i11 = getTruncated().hashCode();
        }
        return hashCode + i11;
    }

    public Boolean isTruncated() {
        return this.truncated;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setPolicyNames(Collection<String> collection) {
        if (collection == null) {
            this.policyNames = null;
        } else {
            this.policyNames = new ArrayList(collection);
        }
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getPolicyNames() != null) {
            sb2.append("PolicyNames: " + getPolicyNames() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getNextMarker() != null) {
            sb2.append("NextMarker: " + getNextMarker() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTruncated() != null) {
            sb2.append("Truncated: " + getTruncated());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ListKeyPoliciesResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListKeyPoliciesResult withPolicyNames(String... strArr) {
        if (getPolicyNames() == null) {
            this.policyNames = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.policyNames.add(add);
        }
        return this;
    }

    public ListKeyPoliciesResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public ListKeyPoliciesResult withPolicyNames(Collection<String> collection) {
        setPolicyNames(collection);
        return this;
    }
}
