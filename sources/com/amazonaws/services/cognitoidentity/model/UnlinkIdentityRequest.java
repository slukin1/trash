package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnlinkIdentityRequest extends AmazonWebServiceRequest implements Serializable {
    private String identityId;
    private Map<String, String> logins;
    private List<String> loginsToRemove;

    public UnlinkIdentityRequest addLoginsEntry(String str, String str2) {
        if (this.logins == null) {
            this.logins = new HashMap();
        }
        if (!this.logins.containsKey(str)) {
            this.logins.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public UnlinkIdentityRequest clearLoginsEntries() {
        this.logins = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnlinkIdentityRequest)) {
            return false;
        }
        UnlinkIdentityRequest unlinkIdentityRequest = (UnlinkIdentityRequest) obj;
        if ((unlinkIdentityRequest.getIdentityId() == null) ^ (getIdentityId() == null)) {
            return false;
        }
        if (unlinkIdentityRequest.getIdentityId() != null && !unlinkIdentityRequest.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if ((unlinkIdentityRequest.getLogins() == null) ^ (getLogins() == null)) {
            return false;
        }
        if (unlinkIdentityRequest.getLogins() != null && !unlinkIdentityRequest.getLogins().equals(getLogins())) {
            return false;
        }
        if ((unlinkIdentityRequest.getLoginsToRemove() == null) ^ (getLoginsToRemove() == null)) {
            return false;
        }
        return unlinkIdentityRequest.getLoginsToRemove() == null || unlinkIdentityRequest.getLoginsToRemove().equals(getLoginsToRemove());
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public Map<String, String> getLogins() {
        return this.logins;
    }

    public List<String> getLoginsToRemove() {
        return this.loginsToRemove;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getIdentityId() == null ? 0 : getIdentityId().hashCode()) + 31) * 31) + (getLogins() == null ? 0 : getLogins().hashCode())) * 31;
        if (getLoginsToRemove() != null) {
            i11 = getLoginsToRemove().hashCode();
        }
        return hashCode + i11;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public void setLogins(Map<String, String> map) {
        this.logins = map;
    }

    public void setLoginsToRemove(Collection<String> collection) {
        if (collection == null) {
            this.loginsToRemove = null;
        } else {
            this.loginsToRemove = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getIdentityId() != null) {
            sb2.append("IdentityId: " + getIdentityId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getLogins() != null) {
            sb2.append("Logins: " + getLogins() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getLoginsToRemove() != null) {
            sb2.append("LoginsToRemove: " + getLoginsToRemove());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public UnlinkIdentityRequest withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public UnlinkIdentityRequest withLogins(Map<String, String> map) {
        this.logins = map;
        return this;
    }

    public UnlinkIdentityRequest withLoginsToRemove(String... strArr) {
        if (getLoginsToRemove() == null) {
            this.loginsToRemove = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.loginsToRemove.add(add);
        }
        return this;
    }

    public UnlinkIdentityRequest withLoginsToRemove(Collection<String> collection) {
        setLoginsToRemove(collection);
        return this;
    }
}
