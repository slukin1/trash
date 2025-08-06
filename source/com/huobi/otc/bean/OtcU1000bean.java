package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcU1000bean implements Serializable {
    private boolean isBannerShow;
    private boolean isTagShow;
    private boolean isUserShow;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcU1000bean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcU1000bean)) {
            return false;
        }
        OtcU1000bean otcU1000bean = (OtcU1000bean) obj;
        return otcU1000bean.canEqual(this) && isUserShow() == otcU1000bean.isUserShow() && isTagShow() == otcU1000bean.isTagShow() && isBannerShow() == otcU1000bean.isBannerShow();
    }

    public int hashCode() {
        int i11 = 79;
        int i12 = ((((isUserShow() ? 79 : 97) + 59) * 59) + (isTagShow() ? 79 : 97)) * 59;
        if (!isBannerShow()) {
            i11 = 97;
        }
        return i12 + i11;
    }

    public boolean isBannerShow() {
        return this.isBannerShow;
    }

    public boolean isTagShow() {
        return this.isTagShow;
    }

    public boolean isUserShow() {
        return this.isUserShow;
    }

    public void setBannerShow(boolean z11) {
        this.isBannerShow = z11;
    }

    public void setTagShow(boolean z11) {
        this.isTagShow = z11;
    }

    public void setUserShow(boolean z11) {
        this.isUserShow = z11;
    }

    public String toString() {
        return "OtcU1000bean(isUserShow=" + isUserShow() + ", isTagShow=" + isTagShow() + ", isBannerShow=" + isBannerShow() + ")";
    }
}
