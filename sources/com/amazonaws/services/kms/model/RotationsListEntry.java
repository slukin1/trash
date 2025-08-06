package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.Date;

public class RotationsListEntry implements Serializable {
    private String keyId;
    private Date rotationDate;
    private String rotationType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RotationsListEntry)) {
            return false;
        }
        RotationsListEntry rotationsListEntry = (RotationsListEntry) obj;
        if ((rotationsListEntry.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (rotationsListEntry.getKeyId() != null && !rotationsListEntry.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((rotationsListEntry.getRotationDate() == null) ^ (getRotationDate() == null)) {
            return false;
        }
        if (rotationsListEntry.getRotationDate() != null && !rotationsListEntry.getRotationDate().equals(getRotationDate())) {
            return false;
        }
        if ((rotationsListEntry.getRotationType() == null) ^ (getRotationType() == null)) {
            return false;
        }
        return rotationsListEntry.getRotationType() == null || rotationsListEntry.getRotationType().equals(getRotationType());
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Date getRotationDate() {
        return this.rotationDate;
    }

    public String getRotationType() {
        return this.rotationType;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getRotationDate() == null ? 0 : getRotationDate().hashCode())) * 31;
        if (getRotationType() != null) {
            i11 = getRotationType().hashCode();
        }
        return hashCode + i11;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setRotationDate(Date date) {
        this.rotationDate = date;
    }

    public void setRotationType(String str) {
        this.rotationType = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRotationDate() != null) {
            sb2.append("RotationDate: " + getRotationDate() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRotationType() != null) {
            sb2.append("RotationType: " + getRotationType());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public RotationsListEntry withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public RotationsListEntry withRotationDate(Date date) {
        this.rotationDate = date;
        return this;
    }

    public RotationsListEntry withRotationType(String str) {
        this.rotationType = str;
        return this;
    }

    public void setRotationType(RotationType rotationType2) {
        this.rotationType = rotationType2.toString();
    }

    public RotationsListEntry withRotationType(RotationType rotationType2) {
        this.rotationType = rotationType2.toString();
        return this;
    }
}
