package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

public class MergeDeveloperIdentitiesResult implements Serializable {
    private String identityId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MergeDeveloperIdentitiesResult)) {
            return false;
        }
        MergeDeveloperIdentitiesResult mergeDeveloperIdentitiesResult = (MergeDeveloperIdentitiesResult) obj;
        if ((mergeDeveloperIdentitiesResult.getIdentityId() == null) ^ (getIdentityId() == null)) {
            return false;
        }
        return mergeDeveloperIdentitiesResult.getIdentityId() == null || mergeDeveloperIdentitiesResult.getIdentityId().equals(getIdentityId());
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

    public MergeDeveloperIdentitiesResult withIdentityId(String str) {
        this.identityId = str;
        return this;
    }
}
