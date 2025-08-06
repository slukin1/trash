package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class RetireGrantRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean dryRun;
    private String grantId;
    private String grantToken;
    private String keyId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RetireGrantRequest)) {
            return false;
        }
        RetireGrantRequest retireGrantRequest = (RetireGrantRequest) obj;
        if ((retireGrantRequest.getGrantToken() == null) ^ (getGrantToken() == null)) {
            return false;
        }
        if (retireGrantRequest.getGrantToken() != null && !retireGrantRequest.getGrantToken().equals(getGrantToken())) {
            return false;
        }
        if ((retireGrantRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (retireGrantRequest.getKeyId() != null && !retireGrantRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((retireGrantRequest.getGrantId() == null) ^ (getGrantId() == null)) {
            return false;
        }
        if (retireGrantRequest.getGrantId() != null && !retireGrantRequest.getGrantId().equals(getGrantId())) {
            return false;
        }
        if ((retireGrantRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        return retireGrantRequest.getDryRun() == null || retireGrantRequest.getDryRun().equals(getDryRun());
    }

    public Boolean getDryRun() {
        return this.dryRun;
    }

    public String getGrantId() {
        return this.grantId;
    }

    public String getGrantToken() {
        return this.grantToken;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((getGrantToken() == null ? 0 : getGrantToken().hashCode()) + 31) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31) + (getGrantId() == null ? 0 : getGrantId().hashCode())) * 31;
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

    public void setGrantToken(String str) {
        this.grantToken = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getGrantToken() != null) {
            sb2.append("GrantToken: " + getGrantToken() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
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

    public RetireGrantRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public RetireGrantRequest withGrantId(String str) {
        this.grantId = str;
        return this;
    }

    public RetireGrantRequest withGrantToken(String str) {
        this.grantToken = str;
        return this;
    }

    public RetireGrantRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }
}
