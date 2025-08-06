package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class XksProxyAuthenticationCredentialType implements Serializable {
    private String accessKeyId;
    private String rawSecretAccessKey;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof XksProxyAuthenticationCredentialType)) {
            return false;
        }
        XksProxyAuthenticationCredentialType xksProxyAuthenticationCredentialType = (XksProxyAuthenticationCredentialType) obj;
        if ((xksProxyAuthenticationCredentialType.getAccessKeyId() == null) ^ (getAccessKeyId() == null)) {
            return false;
        }
        if (xksProxyAuthenticationCredentialType.getAccessKeyId() != null && !xksProxyAuthenticationCredentialType.getAccessKeyId().equals(getAccessKeyId())) {
            return false;
        }
        if ((xksProxyAuthenticationCredentialType.getRawSecretAccessKey() == null) ^ (getRawSecretAccessKey() == null)) {
            return false;
        }
        return xksProxyAuthenticationCredentialType.getRawSecretAccessKey() == null || xksProxyAuthenticationCredentialType.getRawSecretAccessKey().equals(getRawSecretAccessKey());
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getRawSecretAccessKey() {
        return this.rawSecretAccessKey;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getAccessKeyId() == null ? 0 : getAccessKeyId().hashCode()) + 31) * 31;
        if (getRawSecretAccessKey() != null) {
            i11 = getRawSecretAccessKey().hashCode();
        }
        return hashCode + i11;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setRawSecretAccessKey(String str) {
        this.rawSecretAccessKey = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getAccessKeyId() != null) {
            sb2.append("AccessKeyId: " + getAccessKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRawSecretAccessKey() != null) {
            sb2.append("RawSecretAccessKey: " + getRawSecretAccessKey());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public XksProxyAuthenticationCredentialType withAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }

    public XksProxyAuthenticationCredentialType withRawSecretAccessKey(String str) {
        this.rawSecretAccessKey = str;
        return this;
    }
}
