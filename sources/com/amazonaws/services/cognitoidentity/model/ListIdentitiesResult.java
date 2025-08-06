package com.amazonaws.services.cognitoidentity.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListIdentitiesResult implements Serializable {
    private List<IdentityDescription> identities;
    private String identityPoolId;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListIdentitiesResult)) {
            return false;
        }
        ListIdentitiesResult listIdentitiesResult = (ListIdentitiesResult) obj;
        if ((listIdentitiesResult.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        if (listIdentitiesResult.getIdentityPoolId() != null && !listIdentitiesResult.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if ((listIdentitiesResult.getIdentities() == null) ^ (getIdentities() == null)) {
            return false;
        }
        if (listIdentitiesResult.getIdentities() != null && !listIdentitiesResult.getIdentities().equals(getIdentities())) {
            return false;
        }
        if ((listIdentitiesResult.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return listIdentitiesResult.getNextToken() == null || listIdentitiesResult.getNextToken().equals(getNextToken());
    }

    public List<IdentityDescription> getIdentities() {
        return this.identities;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getIdentityPoolId() == null ? 0 : getIdentityPoolId().hashCode()) + 31) * 31) + (getIdentities() == null ? 0 : getIdentities().hashCode())) * 31;
        if (getNextToken() != null) {
            i11 = getNextToken().hashCode();
        }
        return hashCode + i11;
    }

    public void setIdentities(Collection<IdentityDescription> collection) {
        if (collection == null) {
            this.identities = null;
        } else {
            this.identities = new ArrayList(collection);
        }
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getIdentityPoolId() != null) {
            sb2.append("IdentityPoolId: " + getIdentityPoolId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getIdentities() != null) {
            sb2.append("Identities: " + getIdentities() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getNextToken() != null) {
            sb2.append("NextToken: " + getNextToken());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ListIdentitiesResult withIdentities(IdentityDescription... identityDescriptionArr) {
        if (getIdentities() == null) {
            this.identities = new ArrayList(identityDescriptionArr.length);
        }
        for (IdentityDescription add : identityDescriptionArr) {
            this.identities.add(add);
        }
        return this;
    }

    public ListIdentitiesResult withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public ListIdentitiesResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListIdentitiesResult withIdentities(Collection<IdentityDescription> collection) {
        setIdentities(collection);
        return this;
    }
}
