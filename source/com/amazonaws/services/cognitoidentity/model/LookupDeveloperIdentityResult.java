package com.amazonaws.services.cognitoidentity.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LookupDeveloperIdentityResult implements Serializable {
    private List<String> developerUserIdentifierList;
    private String identityId;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LookupDeveloperIdentityResult)) {
            return false;
        }
        LookupDeveloperIdentityResult lookupDeveloperIdentityResult = (LookupDeveloperIdentityResult) obj;
        if ((lookupDeveloperIdentityResult.getIdentityId() == null) ^ (getIdentityId() == null)) {
            return false;
        }
        if (lookupDeveloperIdentityResult.getIdentityId() != null && !lookupDeveloperIdentityResult.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if ((lookupDeveloperIdentityResult.getDeveloperUserIdentifierList() == null) ^ (getDeveloperUserIdentifierList() == null)) {
            return false;
        }
        if (lookupDeveloperIdentityResult.getDeveloperUserIdentifierList() != null && !lookupDeveloperIdentityResult.getDeveloperUserIdentifierList().equals(getDeveloperUserIdentifierList())) {
            return false;
        }
        if ((lookupDeveloperIdentityResult.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return lookupDeveloperIdentityResult.getNextToken() == null || lookupDeveloperIdentityResult.getNextToken().equals(getNextToken());
    }

    public List<String> getDeveloperUserIdentifierList() {
        return this.developerUserIdentifierList;
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i11;
        int i12 = 0;
        int hashCode = ((getIdentityId() == null ? 0 : getIdentityId().hashCode()) + 31) * 31;
        if (getDeveloperUserIdentifierList() == null) {
            i11 = 0;
        } else {
            i11 = getDeveloperUserIdentifierList().hashCode();
        }
        int i13 = (hashCode + i11) * 31;
        if (getNextToken() != null) {
            i12 = getNextToken().hashCode();
        }
        return i13 + i12;
    }

    public void setDeveloperUserIdentifierList(Collection<String> collection) {
        if (collection == null) {
            this.developerUserIdentifierList = null;
        } else {
            this.developerUserIdentifierList = new ArrayList(collection);
        }
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getIdentityId() != null) {
            sb2.append("IdentityId: " + getIdentityId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDeveloperUserIdentifierList() != null) {
            sb2.append("DeveloperUserIdentifierList: " + getDeveloperUserIdentifierList() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getNextToken() != null) {
            sb2.append("NextToken: " + getNextToken());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public LookupDeveloperIdentityResult withDeveloperUserIdentifierList(String... strArr) {
        if (getDeveloperUserIdentifierList() == null) {
            this.developerUserIdentifierList = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.developerUserIdentifierList.add(add);
        }
        return this;
    }

    public LookupDeveloperIdentityResult withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public LookupDeveloperIdentityResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public LookupDeveloperIdentityResult withDeveloperUserIdentifierList(Collection<String> collection) {
        setDeveloperUserIdentifierList(collection);
        return this;
    }
}
