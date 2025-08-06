package com.huobi.trade.prime.bean;

import java.io.Serializable;

public class AliToken implements Serializable {
    private String sliderId;
    private String sliderToken;

    public boolean canEqual(Object obj) {
        return obj instanceof AliToken;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AliToken)) {
            return false;
        }
        AliToken aliToken = (AliToken) obj;
        if (!aliToken.canEqual(this)) {
            return false;
        }
        String sliderId2 = getSliderId();
        String sliderId3 = aliToken.getSliderId();
        if (sliderId2 != null ? !sliderId2.equals(sliderId3) : sliderId3 != null) {
            return false;
        }
        String sliderToken2 = getSliderToken();
        String sliderToken3 = aliToken.getSliderToken();
        return sliderToken2 != null ? sliderToken2.equals(sliderToken3) : sliderToken3 == null;
    }

    public String getSliderId() {
        return this.sliderId;
    }

    public String getSliderToken() {
        return this.sliderToken;
    }

    public int hashCode() {
        String sliderId2 = getSliderId();
        int i11 = 43;
        int hashCode = sliderId2 == null ? 43 : sliderId2.hashCode();
        String sliderToken2 = getSliderToken();
        int i12 = (hashCode + 59) * 59;
        if (sliderToken2 != null) {
            i11 = sliderToken2.hashCode();
        }
        return i12 + i11;
    }

    public void setSliderId(String str) {
        this.sliderId = str;
    }

    public void setSliderToken(String str) {
        this.sliderToken = str;
    }

    public String toString() {
        return "AliToken(sliderId=" + getSliderId() + ", sliderToken=" + getSliderToken() + ")";
    }
}
