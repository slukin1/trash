package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class ListGrantsRequest extends AmazonWebServiceRequest implements Serializable {
    private String grantId;
    private String granteePrincipal;
    private String keyId;
    private Integer limit;
    private String marker;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListGrantsRequest)) {
            return false;
        }
        ListGrantsRequest listGrantsRequest = (ListGrantsRequest) obj;
        if ((listGrantsRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listGrantsRequest.getLimit() != null && !listGrantsRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listGrantsRequest.getMarker() == null) ^ (getMarker() == null)) {
            return false;
        }
        if (listGrantsRequest.getMarker() != null && !listGrantsRequest.getMarker().equals(getMarker())) {
            return false;
        }
        if ((listGrantsRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (listGrantsRequest.getKeyId() != null && !listGrantsRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((listGrantsRequest.getGrantId() == null) ^ (getGrantId() == null)) {
            return false;
        }
        if (listGrantsRequest.getGrantId() != null && !listGrantsRequest.getGrantId().equals(getGrantId())) {
            return false;
        }
        if ((listGrantsRequest.getGranteePrincipal() == null) ^ (getGranteePrincipal() == null)) {
            return false;
        }
        return listGrantsRequest.getGranteePrincipal() == null || listGrantsRequest.getGranteePrincipal().equals(getGranteePrincipal());
    }

    public String getGrantId() {
        return this.grantId;
    }

    public String getGranteePrincipal() {
        return this.granteePrincipal;
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
        int hashCode = ((((((((getLimit() == null ? 0 : getLimit().hashCode()) + 31) * 31) + (getMarker() == null ? 0 : getMarker().hashCode())) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31) + (getGrantId() == null ? 0 : getGrantId().hashCode())) * 31;
        if (getGranteePrincipal() != null) {
            i11 = getGranteePrincipal().hashCode();
        }
        return hashCode + i11;
    }

    public void setGrantId(String str) {
        this.grantId = str;
    }

    public void setGranteePrincipal(String str) {
        this.granteePrincipal = str;
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
        if (getLimit() != null) {
            sb2.append("Limit: " + getLimit() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getMarker() != null) {
            sb2.append("Marker: " + getMarker() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getGrantId() != null) {
            sb2.append("GrantId: " + getGrantId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getGranteePrincipal() != null) {
            sb2.append("GranteePrincipal: " + getGranteePrincipal());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ListGrantsRequest withGrantId(String str) {
        this.grantId = str;
        return this;
    }

    public ListGrantsRequest withGranteePrincipal(String str) {
        this.granteePrincipal = str;
        return this;
    }

    public ListGrantsRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ListGrantsRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListGrantsRequest withMarker(String str) {
        this.marker = str;
        return this;
    }
}
