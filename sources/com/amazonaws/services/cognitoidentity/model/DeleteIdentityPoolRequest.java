package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteIdentityPoolRequest extends AmazonWebServiceRequest implements Serializable {
    private String identityPoolId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteIdentityPoolRequest)) {
            return false;
        }
        DeleteIdentityPoolRequest deleteIdentityPoolRequest = (DeleteIdentityPoolRequest) obj;
        if ((deleteIdentityPoolRequest.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        return deleteIdentityPoolRequest.getIdentityPoolId() == null || deleteIdentityPoolRequest.getIdentityPoolId().equals(getIdentityPoolId());
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public int hashCode() {
        return 31 + (getIdentityPoolId() == null ? 0 : getIdentityPoolId().hashCode());
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getIdentityPoolId() != null) {
            sb2.append("IdentityPoolId: " + getIdentityPoolId());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public DeleteIdentityPoolRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }
}
