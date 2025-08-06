package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class RotateKeyOnDemandRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RotateKeyOnDemandRequest)) {
            return false;
        }
        RotateKeyOnDemandRequest rotateKeyOnDemandRequest = (RotateKeyOnDemandRequest) obj;
        if ((rotateKeyOnDemandRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        return rotateKeyOnDemandRequest.getKeyId() == null || rotateKeyOnDemandRequest.getKeyId().equals(getKeyId());
    }

    public String getKeyId() {
        return this.keyId;
    }

    public int hashCode() {
        return 31 + (getKeyId() == null ? 0 : getKeyId().hashCode());
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public RotateKeyOnDemandRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }
}
