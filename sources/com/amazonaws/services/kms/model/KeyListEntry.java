package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class KeyListEntry implements Serializable {
    private String keyArn;
    private String keyId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof KeyListEntry)) {
            return false;
        }
        KeyListEntry keyListEntry = (KeyListEntry) obj;
        if ((keyListEntry.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (keyListEntry.getKeyId() != null && !keyListEntry.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((keyListEntry.getKeyArn() == null) ^ (getKeyArn() == null)) {
            return false;
        }
        return keyListEntry.getKeyArn() == null || keyListEntry.getKeyArn().equals(getKeyArn());
    }

    public String getKeyArn() {
        return this.keyArn;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31;
        if (getKeyArn() != null) {
            i11 = getKeyArn().hashCode();
        }
        return hashCode + i11;
    }

    public void setKeyArn(String str) {
        this.keyArn = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyArn() != null) {
            sb2.append("KeyArn: " + getKeyArn());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public KeyListEntry withKeyArn(String str) {
        this.keyArn = str;
        return this;
    }

    public KeyListEntry withKeyId(String str) {
        this.keyId = str;
        return this;
    }
}
