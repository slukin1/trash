package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListKeysResult implements Serializable {
    private List<KeyListEntry> keys = new ArrayList();
    private String nextMarker;
    private Boolean truncated;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListKeysResult)) {
            return false;
        }
        ListKeysResult listKeysResult = (ListKeysResult) obj;
        if ((listKeysResult.getKeys() == null) ^ (getKeys() == null)) {
            return false;
        }
        if (listKeysResult.getKeys() != null && !listKeysResult.getKeys().equals(getKeys())) {
            return false;
        }
        if ((listKeysResult.getNextMarker() == null) ^ (getNextMarker() == null)) {
            return false;
        }
        if (listKeysResult.getNextMarker() != null && !listKeysResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if ((listKeysResult.getTruncated() == null) ^ (getTruncated() == null)) {
            return false;
        }
        return listKeysResult.getTruncated() == null || listKeysResult.getTruncated().equals(getTruncated());
    }

    public List<KeyListEntry> getKeys() {
        return this.keys;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getKeys() == null ? 0 : getKeys().hashCode()) + 31) * 31) + (getNextMarker() == null ? 0 : getNextMarker().hashCode())) * 31;
        if (getTruncated() != null) {
            i11 = getTruncated().hashCode();
        }
        return hashCode + i11;
    }

    public Boolean isTruncated() {
        return this.truncated;
    }

    public void setKeys(Collection<KeyListEntry> collection) {
        if (collection == null) {
            this.keys = null;
        } else {
            this.keys = new ArrayList(collection);
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
        if (getKeys() != null) {
            sb2.append("Keys: " + getKeys() + Constants.ACCEPT_TIME_SEPARATOR_SP);
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

    public ListKeysResult withKeys(KeyListEntry... keyListEntryArr) {
        if (getKeys() == null) {
            this.keys = new ArrayList(keyListEntryArr.length);
        }
        for (KeyListEntry add : keyListEntryArr) {
            this.keys.add(add);
        }
        return this;
    }

    public ListKeysResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListKeysResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public ListKeysResult withKeys(Collection<KeyListEntry> collection) {
        setKeys(collection);
        return this;
    }
}
