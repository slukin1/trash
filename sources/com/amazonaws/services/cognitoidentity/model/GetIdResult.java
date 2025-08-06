package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

public class GetIdResult implements Serializable {
    private String identityId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdResult)) {
            return false;
        }
        GetIdResult getIdResult = (GetIdResult) obj;
        if ((getIdResult.getIdentityId() == null) ^ (getIdentityId() == null)) {
            return false;
        }
        return getIdResult.getIdentityId() == null || getIdResult.getIdentityId().equals(getIdentityId());
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public int hashCode() {
        return 31 + (getIdentityId() == null ? 0 : getIdentityId().hashCode());
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getIdentityId() != null) {
            sb2.append("IdentityId: " + getIdentityId());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetIdResult withIdentityId(String str) {
        this.identityId = str;
        return this;
    }
}
