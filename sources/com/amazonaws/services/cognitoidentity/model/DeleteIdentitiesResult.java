package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeleteIdentitiesResult implements Serializable {
    private List<UnprocessedIdentityId> unprocessedIdentityIds;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteIdentitiesResult)) {
            return false;
        }
        DeleteIdentitiesResult deleteIdentitiesResult = (DeleteIdentitiesResult) obj;
        if ((deleteIdentitiesResult.getUnprocessedIdentityIds() == null) ^ (getUnprocessedIdentityIds() == null)) {
            return false;
        }
        return deleteIdentitiesResult.getUnprocessedIdentityIds() == null || deleteIdentitiesResult.getUnprocessedIdentityIds().equals(getUnprocessedIdentityIds());
    }

    public List<UnprocessedIdentityId> getUnprocessedIdentityIds() {
        return this.unprocessedIdentityIds;
    }

    public int hashCode() {
        int i11;
        if (getUnprocessedIdentityIds() == null) {
            i11 = 0;
        } else {
            i11 = getUnprocessedIdentityIds().hashCode();
        }
        return 31 + i11;
    }

    public void setUnprocessedIdentityIds(Collection<UnprocessedIdentityId> collection) {
        if (collection == null) {
            this.unprocessedIdentityIds = null;
        } else {
            this.unprocessedIdentityIds = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getUnprocessedIdentityIds() != null) {
            sb2.append("UnprocessedIdentityIds: " + getUnprocessedIdentityIds());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public DeleteIdentitiesResult withUnprocessedIdentityIds(UnprocessedIdentityId... unprocessedIdentityIdArr) {
        if (getUnprocessedIdentityIds() == null) {
            this.unprocessedIdentityIds = new ArrayList(unprocessedIdentityIdArr.length);
        }
        for (UnprocessedIdentityId add : unprocessedIdentityIdArr) {
            this.unprocessedIdentityIds.add(add);
        }
        return this;
    }

    public DeleteIdentitiesResult withUnprocessedIdentityIds(Collection<UnprocessedIdentityId> collection) {
        setUnprocessedIdentityIds(collection);
        return this;
    }
}
