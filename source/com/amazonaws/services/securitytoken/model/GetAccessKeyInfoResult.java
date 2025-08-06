package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

public class GetAccessKeyInfoResult implements Serializable {
    private String account;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetAccessKeyInfoResult)) {
            return false;
        }
        GetAccessKeyInfoResult getAccessKeyInfoResult = (GetAccessKeyInfoResult) obj;
        if ((getAccessKeyInfoResult.getAccount() == null) ^ (getAccount() == null)) {
            return false;
        }
        return getAccessKeyInfoResult.getAccount() == null || getAccessKeyInfoResult.getAccount().equals(getAccount());
    }

    public String getAccount() {
        return this.account;
    }

    public int hashCode() {
        return 31 + (getAccount() == null ? 0 : getAccount().hashCode());
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getAccount() != null) {
            sb2.append("Account: " + getAccount());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetAccessKeyInfoResult withAccount(String str) {
        this.account = str;
        return this;
    }
}
