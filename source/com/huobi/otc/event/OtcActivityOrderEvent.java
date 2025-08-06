package com.huobi.otc.event;

import java.io.Serializable;

public class OtcActivityOrderEvent implements Serializable {
    private String hbgContentUrl;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcActivityOrderEvent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcActivityOrderEvent)) {
            return false;
        }
        OtcActivityOrderEvent otcActivityOrderEvent = (OtcActivityOrderEvent) obj;
        if (!otcActivityOrderEvent.canEqual(this)) {
            return false;
        }
        String hbgContentUrl2 = getHbgContentUrl();
        String hbgContentUrl3 = otcActivityOrderEvent.getHbgContentUrl();
        return hbgContentUrl2 != null ? hbgContentUrl2.equals(hbgContentUrl3) : hbgContentUrl3 == null;
    }

    public String getHbgContentUrl() {
        return this.hbgContentUrl;
    }

    public int hashCode() {
        String hbgContentUrl2 = getHbgContentUrl();
        return 59 + (hbgContentUrl2 == null ? 43 : hbgContentUrl2.hashCode());
    }

    public void setHbgContentUrl(String str) {
        this.hbgContentUrl = str;
    }

    public String toString() {
        return "OtcActivityOrderEvent(hbgContentUrl=" + getHbgContentUrl() + ")";
    }
}
