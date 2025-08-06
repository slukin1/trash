package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class RevokeGrantRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean dryRun;
    private String grantId;
    private String keyId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RevokeGrantRequest)) {
            return false;
        }
        RevokeGrantRequest revokeGrantRequest = (RevokeGrantRequest) obj;
        if ((revokeGrantRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (revokeGrantRequest.getKeyId() != null && !revokeGrantRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((revokeGrantRequest.getGrantId() == null) ^ (getGrantId() == null)) {
            return false;
        }
        if (revokeGrantRequest.getGrantId() != null && !revokeGrantRequest.getGrantId().equals(getGrantId())) {
            return false;
        }
        if ((revokeGrantRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        return revokeGrantRequest.getDryRun() == null || revokeGrantRequest.getDryRun().equals(getDryRun());
    }

    public Boolean getDryRun() {
        return this.dryRun;
    }

    public String getGrantId() {
        return this.grantId;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getGrantId() == null ? 0 : getGrantId().hashCode())) * 31;
        if (getDryRun() != null) {
            i11 = getDryRun().hashCode();
        }
        return hashCode + i11;
    }

    public Boolean isDryRun() {
        return this.dryRun;
    }

    public void setDryRun(Boolean bool) {
        this.dryRun = bool;
    }

    public void setGrantId(String str) {
        this.grantId = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getGrantId() != null) {
            sb2.append("GrantId: " + getGrantId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDryRun() != null) {
            sb2.append("DryRun: " + getDryRun());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public RevokeGrantRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public RevokeGrantRequest withGrantId(String str) {
        this.grantId = str;
        return this;
    }

    public RevokeGrantRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }
}
