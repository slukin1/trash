package com.amazonaws.services.cognitoidentity.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SetPrincipalTagAttributeMapResult implements Serializable {
    private String identityPoolId;
    private String identityProviderName;
    private Map<String, String> principalTags;
    private Boolean useDefaults;

    public SetPrincipalTagAttributeMapResult addPrincipalTagsEntry(String str, String str2) {
        if (this.principalTags == null) {
            this.principalTags = new HashMap();
        }
        if (!this.principalTags.containsKey(str)) {
            this.principalTags.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public SetPrincipalTagAttributeMapResult clearPrincipalTagsEntries() {
        this.principalTags = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetPrincipalTagAttributeMapResult)) {
            return false;
        }
        SetPrincipalTagAttributeMapResult setPrincipalTagAttributeMapResult = (SetPrincipalTagAttributeMapResult) obj;
        if ((setPrincipalTagAttributeMapResult.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        if (setPrincipalTagAttributeMapResult.getIdentityPoolId() != null && !setPrincipalTagAttributeMapResult.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if ((setPrincipalTagAttributeMapResult.getIdentityProviderName() == null) ^ (getIdentityProviderName() == null)) {
            return false;
        }
        if (setPrincipalTagAttributeMapResult.getIdentityProviderName() != null && !setPrincipalTagAttributeMapResult.getIdentityProviderName().equals(getIdentityProviderName())) {
            return false;
        }
        if ((setPrincipalTagAttributeMapResult.getUseDefaults() == null) ^ (getUseDefaults() == null)) {
            return false;
        }
        if (setPrincipalTagAttributeMapResult.getUseDefaults() != null && !setPrincipalTagAttributeMapResult.getUseDefaults().equals(getUseDefaults())) {
            return false;
        }
        if ((setPrincipalTagAttributeMapResult.getPrincipalTags() == null) ^ (getPrincipalTags() == null)) {
            return false;
        }
        return setPrincipalTagAttributeMapResult.getPrincipalTags() == null || setPrincipalTagAttributeMapResult.getPrincipalTags().equals(getPrincipalTags());
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public String getIdentityProviderName() {
        return this.identityProviderName;
    }

    public Map<String, String> getPrincipalTags() {
        return this.principalTags;
    }

    public Boolean getUseDefaults() {
        return this.useDefaults;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((getIdentityPoolId() == null ? 0 : getIdentityPoolId().hashCode()) + 31) * 31) + (getIdentityProviderName() == null ? 0 : getIdentityProviderName().hashCode())) * 31) + (getUseDefaults() == null ? 0 : getUseDefaults().hashCode())) * 31;
        if (getPrincipalTags() != null) {
            i11 = getPrincipalTags().hashCode();
        }
        return hashCode + i11;
    }

    public Boolean isUseDefaults() {
        return this.useDefaults;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setIdentityProviderName(String str) {
        this.identityProviderName = str;
    }

    public void setPrincipalTags(Map<String, String> map) {
        this.principalTags = map;
    }

    public void setUseDefaults(Boolean bool) {
        this.useDefaults = bool;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getIdentityPoolId() != null) {
            sb2.append("IdentityPoolId: " + getIdentityPoolId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getIdentityProviderName() != null) {
            sb2.append("IdentityProviderName: " + getIdentityProviderName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getUseDefaults() != null) {
            sb2.append("UseDefaults: " + getUseDefaults() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPrincipalTags() != null) {
            sb2.append("PrincipalTags: " + getPrincipalTags());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public SetPrincipalTagAttributeMapResult withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public SetPrincipalTagAttributeMapResult withIdentityProviderName(String str) {
        this.identityProviderName = str;
        return this;
    }

    public SetPrincipalTagAttributeMapResult withPrincipalTags(Map<String, String> map) {
        this.principalTags = map;
        return this;
    }

    public SetPrincipalTagAttributeMapResult withUseDefaults(Boolean bool) {
        this.useDefaults = bool;
        return this;
    }
}
