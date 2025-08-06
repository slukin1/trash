package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class MergeDeveloperIdentitiesRequest extends AmazonWebServiceRequest implements Serializable {
    private String destinationUserIdentifier;
    private String developerProviderName;
    private String identityPoolId;
    private String sourceUserIdentifier;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MergeDeveloperIdentitiesRequest)) {
            return false;
        }
        MergeDeveloperIdentitiesRequest mergeDeveloperIdentitiesRequest = (MergeDeveloperIdentitiesRequest) obj;
        if ((mergeDeveloperIdentitiesRequest.getSourceUserIdentifier() == null) ^ (getSourceUserIdentifier() == null)) {
            return false;
        }
        if (mergeDeveloperIdentitiesRequest.getSourceUserIdentifier() != null && !mergeDeveloperIdentitiesRequest.getSourceUserIdentifier().equals(getSourceUserIdentifier())) {
            return false;
        }
        if ((mergeDeveloperIdentitiesRequest.getDestinationUserIdentifier() == null) ^ (getDestinationUserIdentifier() == null)) {
            return false;
        }
        if (mergeDeveloperIdentitiesRequest.getDestinationUserIdentifier() != null && !mergeDeveloperIdentitiesRequest.getDestinationUserIdentifier().equals(getDestinationUserIdentifier())) {
            return false;
        }
        if ((mergeDeveloperIdentitiesRequest.getDeveloperProviderName() == null) ^ (getDeveloperProviderName() == null)) {
            return false;
        }
        if (mergeDeveloperIdentitiesRequest.getDeveloperProviderName() != null && !mergeDeveloperIdentitiesRequest.getDeveloperProviderName().equals(getDeveloperProviderName())) {
            return false;
        }
        if ((mergeDeveloperIdentitiesRequest.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        return mergeDeveloperIdentitiesRequest.getIdentityPoolId() == null || mergeDeveloperIdentitiesRequest.getIdentityPoolId().equals(getIdentityPoolId());
    }

    public String getDestinationUserIdentifier() {
        return this.destinationUserIdentifier;
    }

    public String getDeveloperProviderName() {
        return this.developerProviderName;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public String getSourceUserIdentifier() {
        return this.sourceUserIdentifier;
    }

    public int hashCode() {
        int i11;
        int i12 = 0;
        int hashCode = ((getSourceUserIdentifier() == null ? 0 : getSourceUserIdentifier().hashCode()) + 31) * 31;
        if (getDestinationUserIdentifier() == null) {
            i11 = 0;
        } else {
            i11 = getDestinationUserIdentifier().hashCode();
        }
        int hashCode2 = (((hashCode + i11) * 31) + (getDeveloperProviderName() == null ? 0 : getDeveloperProviderName().hashCode())) * 31;
        if (getIdentityPoolId() != null) {
            i12 = getIdentityPoolId().hashCode();
        }
        return hashCode2 + i12;
    }

    public void setDestinationUserIdentifier(String str) {
        this.destinationUserIdentifier = str;
    }

    public void setDeveloperProviderName(String str) {
        this.developerProviderName = str;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setSourceUserIdentifier(String str) {
        this.sourceUserIdentifier = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getSourceUserIdentifier() != null) {
            sb2.append("SourceUserIdentifier: " + getSourceUserIdentifier() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDestinationUserIdentifier() != null) {
            sb2.append("DestinationUserIdentifier: " + getDestinationUserIdentifier() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDeveloperProviderName() != null) {
            sb2.append("DeveloperProviderName: " + getDeveloperProviderName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getIdentityPoolId() != null) {
            sb2.append("IdentityPoolId: " + getIdentityPoolId());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public MergeDeveloperIdentitiesRequest withDestinationUserIdentifier(String str) {
        this.destinationUserIdentifier = str;
        return this;
    }

    public MergeDeveloperIdentitiesRequest withDeveloperProviderName(String str) {
        this.developerProviderName = str;
        return this;
    }

    public MergeDeveloperIdentitiesRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public MergeDeveloperIdentitiesRequest withSourceUserIdentifier(String str) {
        this.sourceUserIdentifier = str;
        return this;
    }
}
