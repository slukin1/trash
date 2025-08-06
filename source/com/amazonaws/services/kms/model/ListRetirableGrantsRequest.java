package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class ListRetirableGrantsRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer limit;
    private String marker;
    private String retiringPrincipal;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListRetirableGrantsRequest)) {
            return false;
        }
        ListRetirableGrantsRequest listRetirableGrantsRequest = (ListRetirableGrantsRequest) obj;
        if ((listRetirableGrantsRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listRetirableGrantsRequest.getLimit() != null && !listRetirableGrantsRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listRetirableGrantsRequest.getMarker() == null) ^ (getMarker() == null)) {
            return false;
        }
        if (listRetirableGrantsRequest.getMarker() != null && !listRetirableGrantsRequest.getMarker().equals(getMarker())) {
            return false;
        }
        if ((listRetirableGrantsRequest.getRetiringPrincipal() == null) ^ (getRetiringPrincipal() == null)) {
            return false;
        }
        return listRetirableGrantsRequest.getRetiringPrincipal() == null || listRetirableGrantsRequest.getRetiringPrincipal().equals(getRetiringPrincipal());
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getMarker() {
        return this.marker;
    }

    public String getRetiringPrincipal() {
        return this.retiringPrincipal;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getLimit() == null ? 0 : getLimit().hashCode()) + 31) * 31) + (getMarker() == null ? 0 : getMarker().hashCode())) * 31;
        if (getRetiringPrincipal() != null) {
            i11 = getRetiringPrincipal().hashCode();
        }
        return hashCode + i11;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public void setRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getLimit() != null) {
            sb2.append("Limit: " + getLimit() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getMarker() != null) {
            sb2.append("Marker: " + getMarker() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRetiringPrincipal() != null) {
            sb2.append("RetiringPrincipal: " + getRetiringPrincipal());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ListRetirableGrantsRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListRetirableGrantsRequest withMarker(String str) {
        this.marker = str;
        return this;
    }

    public ListRetirableGrantsRequest withRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
        return this;
    }
}
