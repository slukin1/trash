package com.amazonaws.services.s3.model;

import java.io.Serializable;

public class CanonicalGrantee implements Grantee, Serializable {
    private String displayName = null;

    /* renamed from: id  reason: collision with root package name */
    private String f15212id = null;

    public CanonicalGrantee(String str) {
        setIdentifier(str);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CanonicalGrantee) {
            return this.f15212id.equals(((CanonicalGrantee) obj).f15212id);
        }
        return false;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getIdentifier() {
        return this.f15212id;
    }

    public String getTypeIdentifier() {
        return "id";
    }

    public int hashCode() {
        return this.f15212id.hashCode();
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setIdentifier(String str) {
        this.f15212id = str;
    }
}
