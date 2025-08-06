package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeCustomKeyStoresResult implements Serializable {
    private List<CustomKeyStoresListEntry> customKeyStores = new ArrayList();
    private String nextMarker;
    private Boolean truncated;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeCustomKeyStoresResult)) {
            return false;
        }
        DescribeCustomKeyStoresResult describeCustomKeyStoresResult = (DescribeCustomKeyStoresResult) obj;
        if ((describeCustomKeyStoresResult.getCustomKeyStores() == null) ^ (getCustomKeyStores() == null)) {
            return false;
        }
        if (describeCustomKeyStoresResult.getCustomKeyStores() != null && !describeCustomKeyStoresResult.getCustomKeyStores().equals(getCustomKeyStores())) {
            return false;
        }
        if ((describeCustomKeyStoresResult.getNextMarker() == null) ^ (getNextMarker() == null)) {
            return false;
        }
        if (describeCustomKeyStoresResult.getNextMarker() != null && !describeCustomKeyStoresResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if ((describeCustomKeyStoresResult.getTruncated() == null) ^ (getTruncated() == null)) {
            return false;
        }
        return describeCustomKeyStoresResult.getTruncated() == null || describeCustomKeyStoresResult.getTruncated().equals(getTruncated());
    }

    public List<CustomKeyStoresListEntry> getCustomKeyStores() {
        return this.customKeyStores;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getCustomKeyStores() == null ? 0 : getCustomKeyStores().hashCode()) + 31) * 31) + (getNextMarker() == null ? 0 : getNextMarker().hashCode())) * 31;
        if (getTruncated() != null) {
            i11 = getTruncated().hashCode();
        }
        return hashCode + i11;
    }

    public Boolean isTruncated() {
        return this.truncated;
    }

    public void setCustomKeyStores(Collection<CustomKeyStoresListEntry> collection) {
        if (collection == null) {
            this.customKeyStores = null;
        } else {
            this.customKeyStores = new ArrayList(collection);
        }
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getCustomKeyStores() != null) {
            sb2.append("CustomKeyStores: " + getCustomKeyStores() + Constants.ACCEPT_TIME_SEPARATOR_SP);
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

    public DescribeCustomKeyStoresResult withCustomKeyStores(CustomKeyStoresListEntry... customKeyStoresListEntryArr) {
        if (getCustomKeyStores() == null) {
            this.customKeyStores = new ArrayList(customKeyStoresListEntryArr.length);
        }
        for (CustomKeyStoresListEntry add : customKeyStoresListEntryArr) {
            this.customKeyStores.add(add);
        }
        return this;
    }

    public DescribeCustomKeyStoresResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public DescribeCustomKeyStoresResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public DescribeCustomKeyStoresResult withCustomKeyStores(Collection<CustomKeyStoresListEntry> collection) {
        setCustomKeyStores(collection);
        return this;
    }
}
