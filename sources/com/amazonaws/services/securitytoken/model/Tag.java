package com.amazonaws.services.securitytoken.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class Tag implements Serializable {
    private String key;
    private String value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if ((tag.getKey() == null) ^ (getKey() == null)) {
            return false;
        }
        if (tag.getKey() != null && !tag.getKey().equals(getKey())) {
            return false;
        }
        if ((tag.getValue() == null) ^ (getValue() == null)) {
            return false;
        }
        return tag.getValue() == null || tag.getValue().equals(getValue());
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getKey() == null ? 0 : getKey().hashCode()) + 31) * 31;
        if (getValue() != null) {
            i11 = getValue().hashCode();
        }
        return hashCode + i11;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKey() != null) {
            sb2.append("Key: " + getKey() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getValue() != null) {
            sb2.append("Value: " + getValue());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public Tag withKey(String str) {
        this.key = str;
        return this;
    }

    public Tag withValue(String str) {
        this.value = str;
        return this;
    }
}
