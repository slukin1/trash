package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListKeyRotationsResult implements Serializable {
    private String nextMarker;
    private List<RotationsListEntry> rotations = new ArrayList();
    private Boolean truncated;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListKeyRotationsResult)) {
            return false;
        }
        ListKeyRotationsResult listKeyRotationsResult = (ListKeyRotationsResult) obj;
        if ((listKeyRotationsResult.getRotations() == null) ^ (getRotations() == null)) {
            return false;
        }
        if (listKeyRotationsResult.getRotations() != null && !listKeyRotationsResult.getRotations().equals(getRotations())) {
            return false;
        }
        if ((listKeyRotationsResult.getNextMarker() == null) ^ (getNextMarker() == null)) {
            return false;
        }
        if (listKeyRotationsResult.getNextMarker() != null && !listKeyRotationsResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if ((listKeyRotationsResult.getTruncated() == null) ^ (getTruncated() == null)) {
            return false;
        }
        return listKeyRotationsResult.getTruncated() == null || listKeyRotationsResult.getTruncated().equals(getTruncated());
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public List<RotationsListEntry> getRotations() {
        return this.rotations;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getRotations() == null ? 0 : getRotations().hashCode()) + 31) * 31) + (getNextMarker() == null ? 0 : getNextMarker().hashCode())) * 31;
        if (getTruncated() != null) {
            i11 = getTruncated().hashCode();
        }
        return hashCode + i11;
    }

    public Boolean isTruncated() {
        return this.truncated;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setRotations(Collection<RotationsListEntry> collection) {
        if (collection == null) {
            this.rotations = null;
        } else {
            this.rotations = new ArrayList(collection);
        }
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getRotations() != null) {
            sb2.append("Rotations: " + getRotations() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getNextMarker() != null) {
            sb2.append("NextMarker: " + getNextMarker() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTruncated() != null) {
            sb2.append("Truncated: " + getTruncated());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ListKeyRotationsResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListKeyRotationsResult withRotations(RotationsListEntry... rotationsListEntryArr) {
        if (getRotations() == null) {
            this.rotations = new ArrayList(rotationsListEntryArr.length);
        }
        for (RotationsListEntry add : rotationsListEntryArr) {
            this.rotations.add(add);
        }
        return this;
    }

    public ListKeyRotationsResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public ListKeyRotationsResult withRotations(Collection<RotationsListEntry> collection) {
        setRotations(collection);
        return this;
    }
}
