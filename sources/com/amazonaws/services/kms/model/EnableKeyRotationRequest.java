package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class EnableKeyRotationRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private Integer rotationPeriodInDays;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EnableKeyRotationRequest)) {
            return false;
        }
        EnableKeyRotationRequest enableKeyRotationRequest = (EnableKeyRotationRequest) obj;
        if ((enableKeyRotationRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (enableKeyRotationRequest.getKeyId() != null && !enableKeyRotationRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((enableKeyRotationRequest.getRotationPeriodInDays() == null) ^ (getRotationPeriodInDays() == null)) {
            return false;
        }
        return enableKeyRotationRequest.getRotationPeriodInDays() == null || enableKeyRotationRequest.getRotationPeriodInDays().equals(getRotationPeriodInDays());
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Integer getRotationPeriodInDays() {
        return this.rotationPeriodInDays;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31;
        if (getRotationPeriodInDays() != null) {
            i11 = getRotationPeriodInDays().hashCode();
        }
        return hashCode + i11;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setRotationPeriodInDays(Integer num) {
        this.rotationPeriodInDays = num;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRotationPeriodInDays() != null) {
            sb2.append("RotationPeriodInDays: " + getRotationPeriodInDays());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public EnableKeyRotationRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public EnableKeyRotationRequest withRotationPeriodInDays(Integer num) {
        this.rotationPeriodInDays = num;
        return this;
    }
}
