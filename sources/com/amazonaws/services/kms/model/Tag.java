package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class Tag implements Serializable {
    private String tagKey;
    private String tagValue;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if ((tag.getTagKey() == null) ^ (getTagKey() == null)) {
            return false;
        }
        if (tag.getTagKey() != null && !tag.getTagKey().equals(getTagKey())) {
            return false;
        }
        if ((tag.getTagValue() == null) ^ (getTagValue() == null)) {
            return false;
        }
        return tag.getTagValue() == null || tag.getTagValue().equals(getTagValue());
    }

    public String getTagKey() {
        return this.tagKey;
    }

    public String getTagValue() {
        return this.tagValue;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getTagKey() == null ? 0 : getTagKey().hashCode()) + 31) * 31;
        if (getTagValue() != null) {
            i11 = getTagValue().hashCode();
        }
        return hashCode + i11;
    }

    public void setTagKey(String str) {
        this.tagKey = str;
    }

    public void setTagValue(String str) {
        this.tagValue = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getTagKey() != null) {
            sb2.append("TagKey: " + getTagKey() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTagValue() != null) {
            sb2.append("TagValue: " + getTagValue());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public Tag withTagKey(String str) {
        this.tagKey = str;
        return this;
    }

    public Tag withTagValue(String str) {
        this.tagValue = str;
        return this;
    }
}
