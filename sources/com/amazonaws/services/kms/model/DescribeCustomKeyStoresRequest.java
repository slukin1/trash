package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class DescribeCustomKeyStoresRequest extends AmazonWebServiceRequest implements Serializable {
    private String customKeyStoreId;
    private String customKeyStoreName;
    private Integer limit;
    private String marker;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeCustomKeyStoresRequest)) {
            return false;
        }
        DescribeCustomKeyStoresRequest describeCustomKeyStoresRequest = (DescribeCustomKeyStoresRequest) obj;
        if ((describeCustomKeyStoresRequest.getCustomKeyStoreId() == null) ^ (getCustomKeyStoreId() == null)) {
            return false;
        }
        if (describeCustomKeyStoresRequest.getCustomKeyStoreId() != null && !describeCustomKeyStoresRequest.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if ((describeCustomKeyStoresRequest.getCustomKeyStoreName() == null) ^ (getCustomKeyStoreName() == null)) {
            return false;
        }
        if (describeCustomKeyStoresRequest.getCustomKeyStoreName() != null && !describeCustomKeyStoresRequest.getCustomKeyStoreName().equals(getCustomKeyStoreName())) {
            return false;
        }
        if ((describeCustomKeyStoresRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (describeCustomKeyStoresRequest.getLimit() != null && !describeCustomKeyStoresRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((describeCustomKeyStoresRequest.getMarker() == null) ^ (getMarker() == null)) {
            return false;
        }
        return describeCustomKeyStoresRequest.getMarker() == null || describeCustomKeyStoresRequest.getMarker().equals(getMarker());
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public String getCustomKeyStoreName() {
        return this.customKeyStoreName;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getMarker() {
        return this.marker;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode()) + 31) * 31) + (getCustomKeyStoreName() == null ? 0 : getCustomKeyStoreName().hashCode())) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31;
        if (getMarker() != null) {
            i11 = getMarker().hashCode();
        }
        return hashCode + i11;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public void setCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
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
        if (getCustomKeyStoreId() != null) {
            sb2.append("CustomKeyStoreId: " + getCustomKeyStoreId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCustomKeyStoreName() != null) {
            sb2.append("CustomKeyStoreName: " + getCustomKeyStoreName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
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

    public DescribeCustomKeyStoresRequest withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public DescribeCustomKeyStoresRequest withCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
        return this;
    }

    public DescribeCustomKeyStoresRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public DescribeCustomKeyStoresRequest withMarker(String str) {
        this.marker = str;
        return this;
    }
}
