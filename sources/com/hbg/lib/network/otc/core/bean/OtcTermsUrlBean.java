package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcTermsUrlBean implements Serializable {
    private String otcTermsUrl = "";

    public boolean canEqual(Object obj) {
        return obj instanceof OtcTermsUrlBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcTermsUrlBean)) {
            return false;
        }
        OtcTermsUrlBean otcTermsUrlBean = (OtcTermsUrlBean) obj;
        if (!otcTermsUrlBean.canEqual(this)) {
            return false;
        }
        String otcTermsUrl2 = getOtcTermsUrl();
        String otcTermsUrl3 = otcTermsUrlBean.getOtcTermsUrl();
        return otcTermsUrl2 != null ? otcTermsUrl2.equals(otcTermsUrl3) : otcTermsUrl3 == null;
    }

    public String getOtcTermsUrl() {
        return this.otcTermsUrl;
    }

    public int hashCode() {
        String otcTermsUrl2 = getOtcTermsUrl();
        return 59 + (otcTermsUrl2 == null ? 43 : otcTermsUrl2.hashCode());
    }

    public void setOtcTermsUrl(String str) {
        this.otcTermsUrl = str;
    }

    public String toString() {
        return "OtcTermsUrlBean(otcTermsUrl=" + getOtcTermsUrl() + ")";
    }
}
