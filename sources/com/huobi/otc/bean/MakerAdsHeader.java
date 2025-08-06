package com.huobi.otc.bean;

import java.io.Serializable;

public class MakerAdsHeader implements Serializable {
    private boolean app_advert;
    private boolean email;
    private boolean isEmpty;
    private boolean offline_email;
    private boolean offline_sms;
    private boolean push;
    private int seaViewEntrance;
    private boolean sms;

    public boolean canEqual(Object obj) {
        return obj instanceof MakerAdsHeader;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MakerAdsHeader)) {
            return false;
        }
        MakerAdsHeader makerAdsHeader = (MakerAdsHeader) obj;
        return makerAdsHeader.canEqual(this) && isOffline_sms() == makerAdsHeader.isOffline_sms() && isApp_advert() == makerAdsHeader.isApp_advert() && isSms() == makerAdsHeader.isSms() && isOffline_email() == makerAdsHeader.isOffline_email() && isEmail() == makerAdsHeader.isEmail() && isPush() == makerAdsHeader.isPush() && getSeaViewEntrance() == makerAdsHeader.getSeaViewEntrance() && isEmpty() == makerAdsHeader.isEmpty();
    }

    public int getSeaViewEntrance() {
        return this.seaViewEntrance;
    }

    public int hashCode() {
        int i11 = 79;
        int seaViewEntrance2 = ((((((((((((((isOffline_sms() ? 79 : 97) + 59) * 59) + (isApp_advert() ? 79 : 97)) * 59) + (isSms() ? 79 : 97)) * 59) + (isOffline_email() ? 79 : 97)) * 59) + (isEmail() ? 79 : 97)) * 59) + (isPush() ? 79 : 97)) * 59) + getSeaViewEntrance()) * 59;
        if (!isEmpty()) {
            i11 = 97;
        }
        return seaViewEntrance2 + i11;
    }

    public boolean isApp_advert() {
        return this.app_advert;
    }

    public boolean isEmail() {
        return this.email;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public boolean isOffline_email() {
        return this.offline_email;
    }

    public boolean isOffline_sms() {
        return this.offline_sms;
    }

    public boolean isPush() {
        return this.push;
    }

    public boolean isSms() {
        return this.sms;
    }

    public void setApp_advert(boolean z11) {
        this.app_advert = z11;
    }

    public void setEmail(boolean z11) {
        this.email = z11;
    }

    public void setEmpty(boolean z11) {
        this.isEmpty = z11;
    }

    public void setOffline_email(boolean z11) {
        this.offline_email = z11;
    }

    public void setOffline_sms(boolean z11) {
        this.offline_sms = z11;
    }

    public void setPush(boolean z11) {
        this.push = z11;
    }

    public void setSeaViewEntrance(int i11) {
        this.seaViewEntrance = i11;
    }

    public void setSms(boolean z11) {
        this.sms = z11;
    }

    public String toString() {
        return "MakerAdsHeader(offline_sms=" + isOffline_sms() + ", app_advert=" + isApp_advert() + ", sms=" + isSms() + ", offline_email=" + isOffline_email() + ", email=" + isEmail() + ", push=" + isPush() + ", seaViewEntrance=" + getSeaViewEntrance() + ", isEmpty=" + isEmpty() + ")";
    }
}
