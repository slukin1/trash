package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GetIdRequest extends AmazonWebServiceRequest implements Serializable {
    private String accountId;
    private String identityPoolId;
    private Map<String, String> logins;

    public GetIdRequest addLoginsEntry(String str, String str2) {
        if (this.logins == null) {
            this.logins = new HashMap();
        }
        if (!this.logins.containsKey(str)) {
            this.logins.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GetIdRequest clearLoginsEntries() {
        this.logins = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdRequest)) {
            return false;
        }
        GetIdRequest getIdRequest = (GetIdRequest) obj;
        if ((getIdRequest.getAccountId() == null) ^ (getAccountId() == null)) {
            return false;
        }
        if (getIdRequest.getAccountId() != null && !getIdRequest.getAccountId().equals(getAccountId())) {
            return false;
        }
        if ((getIdRequest.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        if (getIdRequest.getIdentityPoolId() != null && !getIdRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if ((getIdRequest.getLogins() == null) ^ (getLogins() == null)) {
            return false;
        }
        return getIdRequest.getLogins() == null || getIdRequest.getLogins().equals(getLogins());
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public Map<String, String> getLogins() {
        return this.logins;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getAccountId() == null ? 0 : getAccountId().hashCode()) + 31) * 31) + (getIdentityPoolId() == null ? 0 : getIdentityPoolId().hashCode())) * 31;
        if (getLogins() != null) {
            i11 = getLogins().hashCode();
        }
        return hashCode + i11;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setLogins(Map<String, String> map) {
        this.logins = map;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getAccountId() != null) {
            sb2.append("AccountId: " + getAccountId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getIdentityPoolId() != null) {
            sb2.append("IdentityPoolId: " + getIdentityPoolId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getLogins() != null) {
            sb2.append("Logins: " + getLogins());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetIdRequest withAccountId(String str) {
        this.accountId = str;
        return this;
    }

    public GetIdRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public GetIdRequest withLogins(Map<String, String> map) {
        this.logins = map;
        return this;
    }
}
