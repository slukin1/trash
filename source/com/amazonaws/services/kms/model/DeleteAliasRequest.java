package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteAliasRequest extends AmazonWebServiceRequest implements Serializable {
    private String aliasName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteAliasRequest)) {
            return false;
        }
        DeleteAliasRequest deleteAliasRequest = (DeleteAliasRequest) obj;
        if ((deleteAliasRequest.getAliasName() == null) ^ (getAliasName() == null)) {
            return false;
        }
        return deleteAliasRequest.getAliasName() == null || deleteAliasRequest.getAliasName().equals(getAliasName());
    }

    public String getAliasName() {
        return this.aliasName;
    }

    public int hashCode() {
        return 31 + (getAliasName() == null ? 0 : getAliasName().hashCode());
    }

    public void setAliasName(String str) {
        this.aliasName = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getAliasName() != null) {
            sb2.append("AliasName: " + getAliasName());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public DeleteAliasRequest withAliasName(String str) {
        this.aliasName = str;
        return this;
    }
}
