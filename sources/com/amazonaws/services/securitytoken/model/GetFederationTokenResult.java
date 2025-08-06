package com.amazonaws.services.securitytoken.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class GetFederationTokenResult implements Serializable {
    private Credentials credentials;
    private FederatedUser federatedUser;
    private Integer packedPolicySize;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetFederationTokenResult)) {
            return false;
        }
        GetFederationTokenResult getFederationTokenResult = (GetFederationTokenResult) obj;
        if ((getFederationTokenResult.getCredentials() == null) ^ (getCredentials() == null)) {
            return false;
        }
        if (getFederationTokenResult.getCredentials() != null && !getFederationTokenResult.getCredentials().equals(getCredentials())) {
            return false;
        }
        if ((getFederationTokenResult.getFederatedUser() == null) ^ (getFederatedUser() == null)) {
            return false;
        }
        if (getFederationTokenResult.getFederatedUser() != null && !getFederationTokenResult.getFederatedUser().equals(getFederatedUser())) {
            return false;
        }
        if ((getFederationTokenResult.getPackedPolicySize() == null) ^ (getPackedPolicySize() == null)) {
            return false;
        }
        return getFederationTokenResult.getPackedPolicySize() == null || getFederationTokenResult.getPackedPolicySize().equals(getPackedPolicySize());
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public FederatedUser getFederatedUser() {
        return this.federatedUser;
    }

    public Integer getPackedPolicySize() {
        return this.packedPolicySize;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getCredentials() == null ? 0 : getCredentials().hashCode()) + 31) * 31) + (getFederatedUser() == null ? 0 : getFederatedUser().hashCode())) * 31;
        if (getPackedPolicySize() != null) {
            i11 = getPackedPolicySize().hashCode();
        }
        return hashCode + i11;
    }

    public void setCredentials(Credentials credentials2) {
        this.credentials = credentials2;
    }

    public void setFederatedUser(FederatedUser federatedUser2) {
        this.federatedUser = federatedUser2;
    }

    public void setPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getCredentials() != null) {
            sb2.append("Credentials: " + getCredentials() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getFederatedUser() != null) {
            sb2.append("FederatedUser: " + getFederatedUser() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPackedPolicySize() != null) {
            sb2.append("PackedPolicySize: " + getPackedPolicySize());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetFederationTokenResult withCredentials(Credentials credentials2) {
        this.credentials = credentials2;
        return this;
    }

    public GetFederationTokenResult withFederatedUser(FederatedUser federatedUser2) {
        this.federatedUser = federatedUser2;
        return this;
    }

    public GetFederationTokenResult withPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
        return this;
    }
}
