package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class UnlinkDeveloperIdentityRequest extends AmazonWebServiceRequest implements Serializable {
    private String developerProviderName;
    private String developerUserIdentifier;
    private String identityId;
    private String identityPoolId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnlinkDeveloperIdentityRequest)) {
            return false;
        }
        UnlinkDeveloperIdentityRequest unlinkDeveloperIdentityRequest = (UnlinkDeveloperIdentityRequest) obj;
        if ((unlinkDeveloperIdentityRequest.getIdentityId() == null) ^ (getIdentityId() == null)) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getIdentityId() != null && !unlinkDeveloperIdentityRequest.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if ((unlinkDeveloperIdentityRequest.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getIdentityPoolId() != null && !unlinkDeveloperIdentityRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if ((unlinkDeveloperIdentityRequest.getDeveloperProviderName() == null) ^ (getDeveloperProviderName() == null)) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getDeveloperProviderName() != null && !unlinkDeveloperIdentityRequest.getDeveloperProviderName().equals(getDeveloperProviderName())) {
            return false;
        }
        if ((unlinkDeveloperIdentityRequest.getDeveloperUserIdentifier() == null) ^ (getDeveloperUserIdentifier() == null)) {
            return false;
        }
        return unlinkDeveloperIdentityRequest.getDeveloperUserIdentifier() == null || unlinkDeveloperIdentityRequest.getDeveloperUserIdentifier().equals(getDeveloperUserIdentifier());
    }

    public String getDeveloperProviderName() {
        return this.developerProviderName;
    }

    public String getDeveloperUserIdentifier() {
        return this.developerUserIdentifier;
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((getIdentityId() == null ? 0 : getIdentityId().hashCode()) + 31) * 31) + (getIdentityPoolId() == null ? 0 : getIdentityPoolId().hashCode())) * 31) + (getDeveloperProviderName() == null ? 0 : getDeveloperProviderName().hashCode())) * 31;
        if (getDeveloperUserIdentifier() != null) {
            i11 = getDeveloperUserIdentifier().hashCode();
        }
        return hashCode + i11;
    }

    public void setDeveloperProviderName(String str) {
        this.developerProviderName = str;
    }

    public void setDeveloperUserIdentifier(String str) {
        this.developerUserIdentifier = str;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getIdentityId() != null) {
            sb2.append("IdentityId: " + getIdentityId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getIdentityPoolId() != null) {
            sb2.append("IdentityPoolId: " + getIdentityPoolId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDeveloperProviderName() != null) {
            sb2.append("DeveloperProviderName: " + getDeveloperProviderName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDeveloperUserIdentifier() != null) {
            sb2.append("DeveloperUserIdentifier: " + getDeveloperUserIdentifier());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public UnlinkDeveloperIdentityRequest withDeveloperProviderName(String str) {
        this.developerProviderName = str;
        return this;
    }

    public UnlinkDeveloperIdentityRequest withDeveloperUserIdentifier(String str) {
        this.developerUserIdentifier = str;
        return this;
    }

    public UnlinkDeveloperIdentityRequest withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public UnlinkDeveloperIdentityRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }
}
