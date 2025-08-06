package com.amazonaws.services.securitytoken.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class AssumedRoleUser implements Serializable {
    private String arn;
    private String assumedRoleId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssumedRoleUser)) {
            return false;
        }
        AssumedRoleUser assumedRoleUser = (AssumedRoleUser) obj;
        if ((assumedRoleUser.getAssumedRoleId() == null) ^ (getAssumedRoleId() == null)) {
            return false;
        }
        if (assumedRoleUser.getAssumedRoleId() != null && !assumedRoleUser.getAssumedRoleId().equals(getAssumedRoleId())) {
            return false;
        }
        if ((assumedRoleUser.getArn() == null) ^ (getArn() == null)) {
            return false;
        }
        return assumedRoleUser.getArn() == null || assumedRoleUser.getArn().equals(getArn());
    }

    public String getArn() {
        return this.arn;
    }

    public String getAssumedRoleId() {
        return this.assumedRoleId;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getAssumedRoleId() == null ? 0 : getAssumedRoleId().hashCode()) + 31) * 31;
        if (getArn() != null) {
            i11 = getArn().hashCode();
        }
        return hashCode + i11;
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public void setAssumedRoleId(String str) {
        this.assumedRoleId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getAssumedRoleId() != null) {
            sb2.append("AssumedRoleId: " + getAssumedRoleId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getArn() != null) {
            sb2.append("Arn: " + getArn());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public AssumedRoleUser withArn(String str) {
        this.arn = str;
        return this;
    }

    public AssumedRoleUser withAssumedRoleId(String str) {
        this.assumedRoleId = str;
        return this;
    }
}
