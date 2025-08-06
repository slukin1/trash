package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AccessControlList implements Serializable, S3RequesterChargedResult {
    private static final long serialVersionUID = 8095040648034788376L;
    private List<Grant> grantList;
    private Set<Grant> grantSet;
    private boolean isRequesterCharged;
    private Owner owner = null;

    private void checkState() {
        if (this.grantSet != null && this.grantList != null) {
            throw new IllegalStateException("Both grant set and grant list cannot be null");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AccessControlList accessControlList = (AccessControlList) obj;
        Owner owner2 = this.owner;
        if (owner2 == null) {
            if (accessControlList.owner != null) {
                return false;
            }
        } else if (!owner2.equals(accessControlList.owner)) {
            return false;
        }
        Set<Grant> set = this.grantSet;
        if (set == null) {
            if (accessControlList.grantSet != null) {
                return false;
            }
        } else if (!set.equals(accessControlList.grantSet)) {
            return false;
        }
        List<Grant> list = this.grantList;
        if (list == null) {
            if (accessControlList.grantList != null) {
                return false;
            }
        } else if (!list.equals(accessControlList.grantList)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public Set<Grant> getGrants() {
        checkState();
        if (this.grantSet == null) {
            if (this.grantList == null) {
                this.grantSet = new HashSet();
            } else {
                this.grantSet = new HashSet(this.grantList);
                this.grantList = null;
            }
        }
        return this.grantSet;
    }

    public List<Grant> getGrantsAsList() {
        checkState();
        if (this.grantList == null) {
            if (this.grantSet == null) {
                this.grantList = new LinkedList();
            } else {
                this.grantList = new LinkedList(this.grantSet);
                this.grantSet = null;
            }
        }
        return this.grantList;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void grantAllPermissions(Grant... grantArr) {
        for (Grant grant : grantArr) {
            grantPermission(grant.a(), grant.b());
        }
    }

    public void grantPermission(Grantee grantee, Permission permission) {
        getGrantsAsList().add(new Grant(grantee, permission));
    }

    public int hashCode() {
        Owner owner2 = this.owner;
        int i11 = 0;
        int hashCode = ((owner2 == null ? 0 : owner2.hashCode()) + 31) * 31;
        Set<Grant> set = this.grantSet;
        int hashCode2 = (hashCode + (set == null ? 0 : set.hashCode())) * 31;
        List<Grant> list = this.grantList;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode2 + i11;
    }

    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public void revokeAllPermissions(Grantee grantee) {
        ArrayList arrayList = new ArrayList();
        for (Grant next : getGrantsAsList()) {
            if (next.a().equals(grantee)) {
                arrayList.add(next);
            }
        }
        this.grantList.removeAll(arrayList);
    }

    public void setOwner(Owner owner2) {
        this.owner = owner2;
    }

    public void setRequesterCharged(boolean z11) {
        this.isRequesterCharged = z11;
    }

    public String toString() {
        return "AccessControlList [owner=" + this.owner + ", grants=" + getGrantsAsList() + "]";
    }
}
