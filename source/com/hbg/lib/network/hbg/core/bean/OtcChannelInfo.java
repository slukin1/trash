package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class OtcChannelInfo implements Serializable {
    public String paymentIconUrl;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcChannelInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcChannelInfo)) {
            return false;
        }
        OtcChannelInfo otcChannelInfo = (OtcChannelInfo) obj;
        if (!otcChannelInfo.canEqual(this)) {
            return false;
        }
        String paymentIconUrl2 = getPaymentIconUrl();
        String paymentIconUrl3 = otcChannelInfo.getPaymentIconUrl();
        return paymentIconUrl2 != null ? paymentIconUrl2.equals(paymentIconUrl3) : paymentIconUrl3 == null;
    }

    public String getPaymentIconUrl() {
        return this.paymentIconUrl;
    }

    public int hashCode() {
        String paymentIconUrl2 = getPaymentIconUrl();
        return 59 + (paymentIconUrl2 == null ? 43 : paymentIconUrl2.hashCode());
    }

    public void setPaymentIconUrl(String str) {
        this.paymentIconUrl = str;
    }

    public String toString() {
        return "OtcChannelInfo(paymentIconUrl=" + getPaymentIconUrl() + ")";
    }
}
