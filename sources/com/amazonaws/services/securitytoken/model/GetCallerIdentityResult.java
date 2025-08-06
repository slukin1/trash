package com.amazonaws.services.securitytoken.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class GetCallerIdentityResult implements Serializable {
    private String account;
    private String arn;
    private String userId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetCallerIdentityResult)) {
            return false;
        }
        GetCallerIdentityResult getCallerIdentityResult = (GetCallerIdentityResult) obj;
        if ((getCallerIdentityResult.getUserId() == null) ^ (getUserId() == null)) {
            return false;
        }
        if (getCallerIdentityResult.getUserId() != null && !getCallerIdentityResult.getUserId().equals(getUserId())) {
            return false;
        }
        if ((getCallerIdentityResult.getAccount() == null) ^ (getAccount() == null)) {
            return false;
        }
        if (getCallerIdentityResult.getAccount() != null && !getCallerIdentityResult.getAccount().equals(getAccount())) {
            return false;
        }
        if ((getCallerIdentityResult.getArn() == null) ^ (getArn() == null)) {
            return false;
        }
        return getCallerIdentityResult.getArn() == null || getCallerIdentityResult.getArn().equals(getArn());
    }

    public String getAccount() {
        return this.account;
    }

    public String getArn() {
        return this.arn;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getUserId() == null ? 0 : getUserId().hashCode()) + 31) * 31) + (getAccount() == null ? 0 : getAccount().hashCode())) * 31;
        if (getArn() != null) {
            i11 = getArn().hashCode();
        }
        return hashCode + i11;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getUserId() != null) {
            sb2.append("UserId: " + getUserId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getAccount() != null) {
            sb2.append("Account: " + getAccount() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getArn() != null) {
            sb2.append("Arn: " + getArn());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetCallerIdentityResult withAccount(String str) {
        this.account = str;
        return this;
    }

    public GetCallerIdentityResult withArn(String str) {
        this.arn = str;
        return this;
    }

    public GetCallerIdentityResult withUserId(String str) {
        this.userId = str;
        return this;
    }
}
