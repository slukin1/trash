package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class ListKeysRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer limit;
    private String marker;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListKeysRequest)) {
            return false;
        }
        ListKeysRequest listKeysRequest = (ListKeysRequest) obj;
        if ((listKeysRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listKeysRequest.getLimit() != null && !listKeysRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listKeysRequest.getMarker() == null) ^ (getMarker() == null)) {
            return false;
        }
        return listKeysRequest.getMarker() == null || listKeysRequest.getMarker().equals(getMarker());
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getMarker() {
        return this.marker;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getLimit() == null ? 0 : getLimit().hashCode()) + 31) * 31;
        if (getMarker() != null) {
            i11 = getMarker().hashCode();
        }
        return hashCode + i11;
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
        if (getLimit() != null) {
            sb2.append("Limit: " + getLimit() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getMarker() != null) {
            sb2.append("Marker: " + getMarker());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ListKeysRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListKeysRequest withMarker(String str) {
        this.marker = str;
        return this;
    }
}
