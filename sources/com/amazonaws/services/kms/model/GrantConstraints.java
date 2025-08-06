package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GrantConstraints implements Serializable {
    private Map<String, String> encryptionContextEquals = new HashMap();
    private Map<String, String> encryptionContextSubset = new HashMap();

    public GrantConstraints addEncryptionContextEqualsEntry(String str, String str2) {
        if (this.encryptionContextEquals == null) {
            this.encryptionContextEquals = new HashMap();
        }
        if (!this.encryptionContextEquals.containsKey(str)) {
            this.encryptionContextEquals.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GrantConstraints addEncryptionContextSubsetEntry(String str, String str2) {
        if (this.encryptionContextSubset == null) {
            this.encryptionContextSubset = new HashMap();
        }
        if (!this.encryptionContextSubset.containsKey(str)) {
            this.encryptionContextSubset.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GrantConstraints clearEncryptionContextEqualsEntries() {
        this.encryptionContextEquals = null;
        return this;
    }

    public GrantConstraints clearEncryptionContextSubsetEntries() {
        this.encryptionContextSubset = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GrantConstraints)) {
            return false;
        }
        GrantConstraints grantConstraints = (GrantConstraints) obj;
        if ((grantConstraints.getEncryptionContextSubset() == null) ^ (getEncryptionContextSubset() == null)) {
            return false;
        }
        if (grantConstraints.getEncryptionContextSubset() != null && !grantConstraints.getEncryptionContextSubset().equals(getEncryptionContextSubset())) {
            return false;
        }
        if ((grantConstraints.getEncryptionContextEquals() == null) ^ (getEncryptionContextEquals() == null)) {
            return false;
        }
        return grantConstraints.getEncryptionContextEquals() == null || grantConstraints.getEncryptionContextEquals().equals(getEncryptionContextEquals());
    }

    public Map<String, String> getEncryptionContextEquals() {
        return this.encryptionContextEquals;
    }

    public Map<String, String> getEncryptionContextSubset() {
        return this.encryptionContextSubset;
    }

    public int hashCode() {
        int i11;
        int i12 = 0;
        if (getEncryptionContextSubset() == null) {
            i11 = 0;
        } else {
            i11 = getEncryptionContextSubset().hashCode();
        }
        int i13 = (i11 + 31) * 31;
        if (getEncryptionContextEquals() != null) {
            i12 = getEncryptionContextEquals().hashCode();
        }
        return i13 + i12;
    }

    public void setEncryptionContextEquals(Map<String, String> map) {
        this.encryptionContextEquals = map;
    }

    public void setEncryptionContextSubset(Map<String, String> map) {
        this.encryptionContextSubset = map;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getEncryptionContextSubset() != null) {
            sb2.append("EncryptionContextSubset: " + getEncryptionContextSubset() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getEncryptionContextEquals() != null) {
            sb2.append("EncryptionContextEquals: " + getEncryptionContextEquals());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GrantConstraints withEncryptionContextEquals(Map<String, String> map) {
        this.encryptionContextEquals = map;
        return this;
    }

    public GrantConstraints withEncryptionContextSubset(Map<String, String> map) {
        this.encryptionContextSubset = map;
        return this;
    }
}
