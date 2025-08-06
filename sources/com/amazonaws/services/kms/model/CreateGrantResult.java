package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class CreateGrantResult implements Serializable {
    private String grantId;
    private String grantToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateGrantResult)) {
            return false;
        }
        CreateGrantResult createGrantResult = (CreateGrantResult) obj;
        if ((createGrantResult.getGrantToken() == null) ^ (getGrantToken() == null)) {
            return false;
        }
        if (createGrantResult.getGrantToken() != null && !createGrantResult.getGrantToken().equals(getGrantToken())) {
            return false;
        }
        if ((createGrantResult.getGrantId() == null) ^ (getGrantId() == null)) {
            return false;
        }
        return createGrantResult.getGrantId() == null || createGrantResult.getGrantId().equals(getGrantId());
    }

    public String getGrantId() {
        return this.grantId;
    }

    public String getGrantToken() {
        return this.grantToken;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getGrantToken() == null ? 0 : getGrantToken().hashCode()) + 31) * 31;
        if (getGrantId() != null) {
            i11 = getGrantId().hashCode();
        }
        return hashCode + i11;
    }

    public void setGrantId(String str) {
        this.grantId = str;
    }

    public void setGrantToken(String str) {
        this.grantToken = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getGrantToken() != null) {
            sb2.append("GrantToken: " + getGrantToken() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getGrantId() != null) {
            sb2.append("GrantId: " + getGrantId());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public CreateGrantResult withGrantId(String str) {
        this.grantId = str;
        return this;
    }

    public CreateGrantResult withGrantToken(String str) {
        this.grantToken = str;
        return this;
    }
}
