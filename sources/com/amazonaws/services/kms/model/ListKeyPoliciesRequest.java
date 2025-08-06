package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class ListKeyPoliciesRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private Integer limit;
    private String marker;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListKeyPoliciesRequest)) {
            return false;
        }
        ListKeyPoliciesRequest listKeyPoliciesRequest = (ListKeyPoliciesRequest) obj;
        if ((listKeyPoliciesRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (listKeyPoliciesRequest.getKeyId() != null && !listKeyPoliciesRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((listKeyPoliciesRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listKeyPoliciesRequest.getLimit() != null && !listKeyPoliciesRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listKeyPoliciesRequest.getMarker() == null) ^ (getMarker() == null)) {
            return false;
        }
        return listKeyPoliciesRequest.getMarker() == null || listKeyPoliciesRequest.getMarker().equals(getMarker());
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getMarker() {
        return this.marker;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31;
        if (getMarker() != null) {
            i11 = getMarker().hashCode();
        }
        return hashCode + i11;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getLimit() != null) {
            sb2.append("Limit: " + getLimit() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getMarker() != null) {
            sb2.append("Marker: " + getMarker());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ListKeyPoliciesRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ListKeyPoliciesRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListKeyPoliciesRequest withMarker(String str) {
        this.marker = str;
        return this;
    }
}
