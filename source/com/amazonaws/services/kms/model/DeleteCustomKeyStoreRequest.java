package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteCustomKeyStoreRequest extends AmazonWebServiceRequest implements Serializable {
    private String customKeyStoreId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteCustomKeyStoreRequest)) {
            return false;
        }
        DeleteCustomKeyStoreRequest deleteCustomKeyStoreRequest = (DeleteCustomKeyStoreRequest) obj;
        if ((deleteCustomKeyStoreRequest.getCustomKeyStoreId() == null) ^ (getCustomKeyStoreId() == null)) {
            return false;
        }
        return deleteCustomKeyStoreRequest.getCustomKeyStoreId() == null || deleteCustomKeyStoreRequest.getCustomKeyStoreId().equals(getCustomKeyStoreId());
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public int hashCode() {
        return 31 + (getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode());
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getCustomKeyStoreId() != null) {
            sb2.append("CustomKeyStoreId: " + getCustomKeyStoreId());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public DeleteCustomKeyStoreRequest withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }
}
