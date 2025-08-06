package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.Date;

public class GetKeyRotationStatusResult implements Serializable {
    private String keyId;
    private Boolean keyRotationEnabled;
    private Date nextRotationDate;
    private Date onDemandRotationStartDate;
    private Integer rotationPeriodInDays;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetKeyRotationStatusResult)) {
            return false;
        }
        GetKeyRotationStatusResult getKeyRotationStatusResult = (GetKeyRotationStatusResult) obj;
        if ((getKeyRotationStatusResult.getKeyRotationEnabled() == null) ^ (getKeyRotationEnabled() == null)) {
            return false;
        }
        if (getKeyRotationStatusResult.getKeyRotationEnabled() != null && !getKeyRotationStatusResult.getKeyRotationEnabled().equals(getKeyRotationEnabled())) {
            return false;
        }
        if ((getKeyRotationStatusResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (getKeyRotationStatusResult.getKeyId() != null && !getKeyRotationStatusResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((getKeyRotationStatusResult.getRotationPeriodInDays() == null) ^ (getRotationPeriodInDays() == null)) {
            return false;
        }
        if (getKeyRotationStatusResult.getRotationPeriodInDays() != null && !getKeyRotationStatusResult.getRotationPeriodInDays().equals(getRotationPeriodInDays())) {
            return false;
        }
        if ((getKeyRotationStatusResult.getNextRotationDate() == null) ^ (getNextRotationDate() == null)) {
            return false;
        }
        if (getKeyRotationStatusResult.getNextRotationDate() != null && !getKeyRotationStatusResult.getNextRotationDate().equals(getNextRotationDate())) {
            return false;
        }
        if ((getKeyRotationStatusResult.getOnDemandRotationStartDate() == null) ^ (getOnDemandRotationStartDate() == null)) {
            return false;
        }
        return getKeyRotationStatusResult.getOnDemandRotationStartDate() == null || getKeyRotationStatusResult.getOnDemandRotationStartDate().equals(getOnDemandRotationStartDate());
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Boolean getKeyRotationEnabled() {
        return this.keyRotationEnabled;
    }

    public Date getNextRotationDate() {
        return this.nextRotationDate;
    }

    public Date getOnDemandRotationStartDate() {
        return this.onDemandRotationStartDate;
    }

    public Integer getRotationPeriodInDays() {
        return this.rotationPeriodInDays;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((getKeyRotationEnabled() == null ? 0 : getKeyRotationEnabled().hashCode()) + 31) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31) + (getRotationPeriodInDays() == null ? 0 : getRotationPeriodInDays().hashCode())) * 31) + (getNextRotationDate() == null ? 0 : getNextRotationDate().hashCode())) * 31;
        if (getOnDemandRotationStartDate() != null) {
            i11 = getOnDemandRotationStartDate().hashCode();
        }
        return hashCode + i11;
    }

    public Boolean isKeyRotationEnabled() {
        return this.keyRotationEnabled;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setKeyRotationEnabled(Boolean bool) {
        this.keyRotationEnabled = bool;
    }

    public void setNextRotationDate(Date date) {
        this.nextRotationDate = date;
    }

    public void setOnDemandRotationStartDate(Date date) {
        this.onDemandRotationStartDate = date;
    }

    public void setRotationPeriodInDays(Integer num) {
        this.rotationPeriodInDays = num;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyRotationEnabled() != null) {
            sb2.append("KeyRotationEnabled: " + getKeyRotationEnabled() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRotationPeriodInDays() != null) {
            sb2.append("RotationPeriodInDays: " + getRotationPeriodInDays() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getNextRotationDate() != null) {
            sb2.append("NextRotationDate: " + getNextRotationDate() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getOnDemandRotationStartDate() != null) {
            sb2.append("OnDemandRotationStartDate: " + getOnDemandRotationStartDate());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetKeyRotationStatusResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GetKeyRotationStatusResult withKeyRotationEnabled(Boolean bool) {
        this.keyRotationEnabled = bool;
        return this;
    }

    public GetKeyRotationStatusResult withNextRotationDate(Date date) {
        this.nextRotationDate = date;
        return this;
    }

    public GetKeyRotationStatusResult withOnDemandRotationStartDate(Date date) {
        this.onDemandRotationStartDate = date;
        return this;
    }

    public GetKeyRotationStatusResult withRotationPeriodInDays(Integer num) {
        this.rotationPeriodInDays = num;
        return this;
    }
}
