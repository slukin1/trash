package com.amazonaws.services.cognitoidentity.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.Date;

public class Credentials implements Serializable {
    private String accessKeyId;
    private Date expiration;
    private String secretKey;
    private String sessionToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Credentials)) {
            return false;
        }
        Credentials credentials = (Credentials) obj;
        if ((credentials.getAccessKeyId() == null) ^ (getAccessKeyId() == null)) {
            return false;
        }
        if (credentials.getAccessKeyId() != null && !credentials.getAccessKeyId().equals(getAccessKeyId())) {
            return false;
        }
        if ((credentials.getSecretKey() == null) ^ (getSecretKey() == null)) {
            return false;
        }
        if (credentials.getSecretKey() != null && !credentials.getSecretKey().equals(getSecretKey())) {
            return false;
        }
        if ((credentials.getSessionToken() == null) ^ (getSessionToken() == null)) {
            return false;
        }
        if (credentials.getSessionToken() != null && !credentials.getSessionToken().equals(getSessionToken())) {
            return false;
        }
        if ((credentials.getExpiration() == null) ^ (getExpiration() == null)) {
            return false;
        }
        return credentials.getExpiration() == null || credentials.getExpiration().equals(getExpiration());
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public Date getExpiration() {
        return this.expiration;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public String getSessionToken() {
        return this.sessionToken;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((getAccessKeyId() == null ? 0 : getAccessKeyId().hashCode()) + 31) * 31) + (getSecretKey() == null ? 0 : getSecretKey().hashCode())) * 31) + (getSessionToken() == null ? 0 : getSessionToken().hashCode())) * 31;
        if (getExpiration() != null) {
            i11 = getExpiration().hashCode();
        }
        return hashCode + i11;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setExpiration(Date date) {
        this.expiration = date;
    }

    public void setSecretKey(String str) {
        this.secretKey = str;
    }

    public void setSessionToken(String str) {
        this.sessionToken = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getAccessKeyId() != null) {
            sb2.append("AccessKeyId: " + getAccessKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSecretKey() != null) {
            sb2.append("SecretKey: " + getSecretKey() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSessionToken() != null) {
            sb2.append("SessionToken: " + getSessionToken() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getExpiration() != null) {
            sb2.append("Expiration: " + getExpiration());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public Credentials withAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }

    public Credentials withExpiration(Date date) {
        this.expiration = date;
        return this;
    }

    public Credentials withSecretKey(String str) {
        this.secretKey = str;
        return this;
    }

    public Credentials withSessionToken(String str) {
        this.sessionToken = str;
        return this;
    }
}
