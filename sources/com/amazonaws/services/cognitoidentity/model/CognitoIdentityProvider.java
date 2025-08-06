package com.amazonaws.services.cognitoidentity.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class CognitoIdentityProvider implements Serializable {
    private String clientId;
    private String providerName;
    private Boolean serverSideTokenCheck;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CognitoIdentityProvider)) {
            return false;
        }
        CognitoIdentityProvider cognitoIdentityProvider = (CognitoIdentityProvider) obj;
        if ((cognitoIdentityProvider.getProviderName() == null) ^ (getProviderName() == null)) {
            return false;
        }
        if (cognitoIdentityProvider.getProviderName() != null && !cognitoIdentityProvider.getProviderName().equals(getProviderName())) {
            return false;
        }
        if ((cognitoIdentityProvider.getClientId() == null) ^ (getClientId() == null)) {
            return false;
        }
        if (cognitoIdentityProvider.getClientId() != null && !cognitoIdentityProvider.getClientId().equals(getClientId())) {
            return false;
        }
        if ((cognitoIdentityProvider.getServerSideTokenCheck() == null) ^ (getServerSideTokenCheck() == null)) {
            return false;
        }
        return cognitoIdentityProvider.getServerSideTokenCheck() == null || cognitoIdentityProvider.getServerSideTokenCheck().equals(getServerSideTokenCheck());
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public Boolean getServerSideTokenCheck() {
        return this.serverSideTokenCheck;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getProviderName() == null ? 0 : getProviderName().hashCode()) + 31) * 31) + (getClientId() == null ? 0 : getClientId().hashCode())) * 31;
        if (getServerSideTokenCheck() != null) {
            i11 = getServerSideTokenCheck().hashCode();
        }
        return hashCode + i11;
    }

    public Boolean isServerSideTokenCheck() {
        return this.serverSideTokenCheck;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public void setServerSideTokenCheck(Boolean bool) {
        this.serverSideTokenCheck = bool;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getProviderName() != null) {
            sb2.append("ProviderName: " + getProviderName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getClientId() != null) {
            sb2.append("ClientId: " + getClientId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getServerSideTokenCheck() != null) {
            sb2.append("ServerSideTokenCheck: " + getServerSideTokenCheck());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public CognitoIdentityProvider withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public CognitoIdentityProvider withProviderName(String str) {
        this.providerName = str;
        return this;
    }

    public CognitoIdentityProvider withServerSideTokenCheck(Boolean bool) {
        this.serverSideTokenCheck = bool;
        return this;
    }
}
