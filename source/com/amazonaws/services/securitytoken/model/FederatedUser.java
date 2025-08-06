package com.amazonaws.services.securitytoken.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class FederatedUser implements Serializable {
    private String arn;
    private String federatedUserId;

    public FederatedUser() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FederatedUser)) {
            return false;
        }
        FederatedUser federatedUser = (FederatedUser) obj;
        if ((federatedUser.getFederatedUserId() == null) ^ (getFederatedUserId() == null)) {
            return false;
        }
        if (federatedUser.getFederatedUserId() != null && !federatedUser.getFederatedUserId().equals(getFederatedUserId())) {
            return false;
        }
        if ((federatedUser.getArn() == null) ^ (getArn() == null)) {
            return false;
        }
        return federatedUser.getArn() == null || federatedUser.getArn().equals(getArn());
    }

    public String getArn() {
        return this.arn;
    }

    public String getFederatedUserId() {
        return this.federatedUserId;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getFederatedUserId() == null ? 0 : getFederatedUserId().hashCode()) + 31) * 31;
        if (getArn() != null) {
            i11 = getArn().hashCode();
        }
        return hashCode + i11;
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public void setFederatedUserId(String str) {
        this.federatedUserId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getFederatedUserId() != null) {
            sb2.append("FederatedUserId: " + getFederatedUserId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getArn() != null) {
            sb2.append("Arn: " + getArn());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public FederatedUser withArn(String str) {
        this.arn = str;
        return this;
    }

    public FederatedUser withFederatedUserId(String str) {
        this.federatedUserId = str;
        return this;
    }

    public FederatedUser(String str, String str2) {
        setFederatedUserId(str);
        setArn(str2);
    }
}
