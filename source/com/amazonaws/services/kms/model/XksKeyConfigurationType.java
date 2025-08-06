package com.amazonaws.services.kms.model;

import java.io.Serializable;

public class XksKeyConfigurationType implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private String f15096id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof XksKeyConfigurationType)) {
            return false;
        }
        XksKeyConfigurationType xksKeyConfigurationType = (XksKeyConfigurationType) obj;
        if ((xksKeyConfigurationType.getId() == null) ^ (getId() == null)) {
            return false;
        }
        return xksKeyConfigurationType.getId() == null || xksKeyConfigurationType.getId().equals(getId());
    }

    public String getId() {
        return this.f15096id;
    }

    public int hashCode() {
        return 31 + (getId() == null ? 0 : getId().hashCode());
    }

    public void setId(String str) {
        this.f15096id = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getId() != null) {
            sb2.append("Id: " + getId());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public XksKeyConfigurationType withId(String str) {
        this.f15096id = str;
        return this;
    }
}
