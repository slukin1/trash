package com.amazonaws.services.s3.model;

public class Grant {

    /* renamed from: a  reason: collision with root package name */
    public Grantee f15225a = null;

    /* renamed from: b  reason: collision with root package name */
    public Permission f15226b = null;

    public Grant(Grantee grantee, Permission permission) {
        this.f15225a = grantee;
        this.f15226b = permission;
    }

    public Grantee a() {
        return this.f15225a;
    }

    public Permission b() {
        return this.f15226b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Grant grant = (Grant) obj;
        Grantee grantee = this.f15225a;
        if (grantee == null) {
            if (grant.f15225a != null) {
                return false;
            }
        } else if (!grantee.equals(grant.f15225a)) {
            return false;
        }
        return this.f15226b == grant.f15226b;
    }

    public int hashCode() {
        Grantee grantee = this.f15225a;
        int i11 = 0;
        int hashCode = ((grantee == null ? 0 : grantee.hashCode()) + 31) * 31;
        Permission permission = this.f15226b;
        if (permission != null) {
            i11 = permission.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "Grant [grantee=" + this.f15225a + ", permission=" + this.f15226b + "]";
    }
}
