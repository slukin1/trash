package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GetOpenIdTokenForDeveloperIdentityRequest extends AmazonWebServiceRequest implements Serializable {
    private String identityId;
    private String identityPoolId;
    private Map<String, String> logins;
    private Map<String, String> principalTags;
    private Long tokenDuration;

    public GetOpenIdTokenForDeveloperIdentityRequest addLoginsEntry(String str, String str2) {
        if (this.logins == null) {
            this.logins = new HashMap();
        }
        if (!this.logins.containsKey(str)) {
            this.logins.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GetOpenIdTokenForDeveloperIdentityRequest addPrincipalTagsEntry(String str, String str2) {
        if (this.principalTags == null) {
            this.principalTags = new HashMap();
        }
        if (!this.principalTags.containsKey(str)) {
            this.principalTags.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GetOpenIdTokenForDeveloperIdentityRequest clearLoginsEntries() {
        this.logins = null;
        return this;
    }

    public GetOpenIdTokenForDeveloperIdentityRequest clearPrincipalTagsEntries() {
        this.principalTags = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetOpenIdTokenForDeveloperIdentityRequest)) {
            return false;
        }
        GetOpenIdTokenForDeveloperIdentityRequest getOpenIdTokenForDeveloperIdentityRequest = (GetOpenIdTokenForDeveloperIdentityRequest) obj;
        if ((getOpenIdTokenForDeveloperIdentityRequest.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        if (getOpenIdTokenForDeveloperIdentityRequest.getIdentityPoolId() != null && !getOpenIdTokenForDeveloperIdentityRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if ((getOpenIdTokenForDeveloperIdentityRequest.getIdentityId() == null) ^ (getIdentityId() == null)) {
            return false;
        }
        if (getOpenIdTokenForDeveloperIdentityRequest.getIdentityId() != null && !getOpenIdTokenForDeveloperIdentityRequest.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if ((getOpenIdTokenForDeveloperIdentityRequest.getLogins() == null) ^ (getLogins() == null)) {
            return false;
        }
        if (getOpenIdTokenForDeveloperIdentityRequest.getLogins() != null && !getOpenIdTokenForDeveloperIdentityRequest.getLogins().equals(getLogins())) {
            return false;
        }
        if ((getOpenIdTokenForDeveloperIdentityRequest.getPrincipalTags() == null) ^ (getPrincipalTags() == null)) {
            return false;
        }
        if (getOpenIdTokenForDeveloperIdentityRequest.getPrincipalTags() != null && !getOpenIdTokenForDeveloperIdentityRequest.getPrincipalTags().equals(getPrincipalTags())) {
            return false;
        }
        if ((getOpenIdTokenForDeveloperIdentityRequest.getTokenDuration() == null) ^ (getTokenDuration() == null)) {
            return false;
        }
        return getOpenIdTokenForDeveloperIdentityRequest.getTokenDuration() == null || getOpenIdTokenForDeveloperIdentityRequest.getTokenDuration().equals(getTokenDuration());
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public Map<String, String> getLogins() {
        return this.logins;
    }

    public Map<String, String> getPrincipalTags() {
        return this.principalTags;
    }

    public Long getTokenDuration() {
        return this.tokenDuration;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((getIdentityPoolId() == null ? 0 : getIdentityPoolId().hashCode()) + 31) * 31) + (getIdentityId() == null ? 0 : getIdentityId().hashCode())) * 31) + (getLogins() == null ? 0 : getLogins().hashCode())) * 31) + (getPrincipalTags() == null ? 0 : getPrincipalTags().hashCode())) * 31;
        if (getTokenDuration() != null) {
            i11 = getTokenDuration().hashCode();
        }
        return hashCode + i11;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setLogins(Map<String, String> map) {
        this.logins = map;
    }

    public void setPrincipalTags(Map<String, String> map) {
        this.principalTags = map;
    }

    public void setTokenDuration(Long l11) {
        this.tokenDuration = l11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getIdentityPoolId() != null) {
            sb2.append("IdentityPoolId: " + getIdentityPoolId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getIdentityId() != null) {
            sb2.append("IdentityId: " + getIdentityId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getLogins() != null) {
            sb2.append("Logins: " + getLogins() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPrincipalTags() != null) {
            sb2.append("PrincipalTags: " + getPrincipalTags() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTokenDuration() != null) {
            sb2.append("TokenDuration: " + getTokenDuration());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetOpenIdTokenForDeveloperIdentityRequest withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public GetOpenIdTokenForDeveloperIdentityRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public GetOpenIdTokenForDeveloperIdentityRequest withLogins(Map<String, String> map) {
        this.logins = map;
        return this;
    }

    public GetOpenIdTokenForDeveloperIdentityRequest withPrincipalTags(Map<String, String> map) {
        this.principalTags = map;
        return this;
    }

    public GetOpenIdTokenForDeveloperIdentityRequest withTokenDuration(Long l11) {
        this.tokenDuration = l11;
        return this;
    }
}
