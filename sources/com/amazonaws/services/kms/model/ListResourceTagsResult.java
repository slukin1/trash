package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListResourceTagsResult implements Serializable {
    private String nextMarker;
    private List<Tag> tags = new ArrayList();
    private Boolean truncated;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListResourceTagsResult)) {
            return false;
        }
        ListResourceTagsResult listResourceTagsResult = (ListResourceTagsResult) obj;
        if ((listResourceTagsResult.getTags() == null) ^ (getTags() == null)) {
            return false;
        }
        if (listResourceTagsResult.getTags() != null && !listResourceTagsResult.getTags().equals(getTags())) {
            return false;
        }
        if ((listResourceTagsResult.getNextMarker() == null) ^ (getNextMarker() == null)) {
            return false;
        }
        if (listResourceTagsResult.getNextMarker() != null && !listResourceTagsResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if ((listResourceTagsResult.getTruncated() == null) ^ (getTruncated() == null)) {
            return false;
        }
        return listResourceTagsResult.getTruncated() == null || listResourceTagsResult.getTruncated().equals(getTruncated());
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getTags() == null ? 0 : getTags().hashCode()) + 31) * 31) + (getNextMarker() == null ? 0 : getNextMarker().hashCode())) * 31;
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

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            this.tags = new ArrayList(collection);
        }
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getTags() != null) {
            sb2.append("Tags: " + getTags() + Constants.ACCEPT_TIME_SEPARATOR_SP);
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

    public ListResourceTagsResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListResourceTagsResult withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag add : tagArr) {
            this.tags.add(add);
        }
        return this;
    }

    public ListResourceTagsResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public ListResourceTagsResult withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }
}
