package com.amazonaws.services.cognitoidentity.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GetPrincipalTagAttributeMapResult implements Serializable {
    private String identityPoolId;
    private String identityProviderName;
    private Map<String, String> principalTags;
    private Boolean useDefaults;

    public GetPrincipalTagAttributeMapResult addPrincipalTagsEntry(String str, String str2) {
        if (this.principalTags == null) {
            this.principalTags = new HashMap();
        }
        if (!this.principalTags.containsKey(str)) {
            this.principalTags.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GetPrincipalTagAttributeMapResult clearPrincipalTagsEntries() {
        this.principalTags = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetPrincipalTagAttributeMapResult)) {
            return false;
        }
        GetPrincipalTagAttributeMapResult getPrincipalTagAttributeMapResult = (GetPrincipalTagAttributeMapResult) obj;
        if ((getPrincipalTagAttributeMapResult.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        if (getPrincipalTagAttributeMapResult.getIdentityPoolId() != null && !getPrincipalTagAttributeMapResult.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if ((getPrincipalTagAttributeMapResult.getIdentityProviderName() == null) ^ (getIdentityProviderName() == null)) {
            return false;
        }
        if (getPrincipalTagAttributeMapResult.getIdentityProviderName() != null && !getPrincipalTagAttributeMapResult.getIdentityProviderName().equals(getIdentityProviderName())) {
            return false;
        }
        if ((getPrincipalTagAttributeMapResult.getUseDefaults() == null) ^ (getUseDefaults() == null)) {
            return false;
        }
        if (getPrincipalTagAttributeMapResult.getUseDefaults() != null && !getPrincipalTagAttributeMapResult.getUseDefaults().equals(getUseDefaults())) {
            return false;
        }
        if ((getPrincipalTagAttributeMapResult.getPrincipalTags() == null) ^ (getPrincipalTags() == null)) {
            return false;
        }
        return getPrincipalTagAttributeMapResult.getPrincipalTags() == null || getPrincipalTagAttributeMapResult.getPrincipalTags().equals(getPrincipalTags());
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

    public GetPrincipalTagAttributeMapResult withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public GetPrincipalTagAttributeMapResult withIdentityProviderName(String str) {
        this.identityProviderName = str;
        return this;
    }

    public GetPrincipalTagAttributeMapResult withPrincipalTags(Map<String, String> map) {
        this.principalTags = map;
        return this;
    }

    public GetPrincipalTagAttributeMapResult withUseDefaults(Boolean bool) {
        this.useDefaults = bool;
        return this;
    }
}
