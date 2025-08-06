package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class GetPrincipalTagAttributeMapRequest extends AmazonWebServiceRequest implements Serializable {
    private String identityPoolId;
    private String identityProviderName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetPrincipalTagAttributeMapRequest)) {
            return false;
        }
        GetPrincipalTagAttributeMapRequest getPrincipalTagAttributeMapRequest = (GetPrincipalTagAttributeMapRequest) obj;
        if ((getPrincipalTagAttributeMapRequest.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        if (getPrincipalTagAttributeMapRequest.getIdentityPoolId() != null && !getPrincipalTagAttributeMapRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if ((getPrincipalTagAttributeMapRequest.getIdentityProviderName() == null) ^ (getIdentityProviderName() == null)) {
            return false;
        }
        return getPrincipalTagAttributeMapRequest.getIdentityProviderName() == null || getPrincipalTagAttributeMapRequest.getIdentityProviderName().equals(getIdentityProviderName());
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public String getIdentityProviderName() {
        return this.identityProviderName;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getIdentityPoolId() == null ? 0 : getIdentityPoolId().hashCode()) + 31) * 31;
        if (getIdentityProviderName() != null) {
            i11 = getIdentityProviderName().hashCode();
        }
        return hashCode + i11;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setIdentityProviderName(String str) {
        this.identityProviderName = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getIdentityPoolId() != null) {
            sb2.append("IdentityPoolId: " + getIdentityPoolId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getIdentityProviderName() != null) {
            sb2.append("IdentityProviderName: " + getIdentityProviderName());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetPrincipalTagAttributeMapRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public GetPrincipalTagAttributeMapRequest withIdentityProviderName(String str) {
        this.identityProviderName = str;
        return this;
    }
}
