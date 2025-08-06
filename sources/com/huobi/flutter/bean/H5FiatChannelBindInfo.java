package com.huobi.flutter.bean;

import java.io.Serializable;

public class H5FiatChannelBindInfo implements Serializable {
    private static final long serialVersionUID = 4532003034531384532L;
    private String channel;
    private String deviceFingerprint;
    private String paymentMethodCode;

    public boolean canEqual(Object obj) {
        return obj instanceof H5FiatChannelBindInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof H5FiatChannelBindInfo)) {
            return false;
        }
        H5FiatChannelBindInfo h5FiatChannelBindInfo = (H5FiatChannelBindInfo) obj;
        if (!h5FiatChannelBindInfo.canEqual(this)) {
            return false;
        }
        String channel2 = getChannel();
        String channel3 = h5FiatChannelBindInfo.getChannel();
        if (channel2 != null ? !channel2.equals(channel3) : channel3 != null) {
            return false;
        }
        String paymentMethodCode2 = getPaymentMethodCode();
        String paymentMethodCode3 = h5FiatChannelBindInfo.getPaymentMethodCode();
        if (paymentMethodCode2 != null ? !paymentMethodCode2.equals(paymentMethodCode3) : paymentMethodCode3 != null) {
            return false;
        }
        String deviceFingerprint2 = getDeviceFingerprint();
        String deviceFingerprint3 = h5FiatChannelBindInfo.getDeviceFingerprint();
        return deviceFingerprint2 != null ? deviceFingerprint2.equals(deviceFingerprint3) : deviceFingerprint3 == null;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getDeviceFingerprint() {
        return this.deviceFingerprint;
    }

    public String getPaymentMethodCode() {
        return this.paymentMethodCode;
    }

    public int hashCode() {
        String channel2 = getChannel();
        int i11 = 43;
        int hashCode = channel2 == null ? 43 : channel2.hashCode();
        String paymentMethodCode2 = getPaymentMethodCode();
        int hashCode2 = ((hashCode + 59) * 59) + (paymentMethodCode2 == null ? 43 : paymentMethodCode2.hashCode());
        String deviceFingerprint2 = getDeviceFingerprint();
        int i12 = hashCode2 * 59;
        if (deviceFingerprint2 != null) {
            i11 = deviceFingerprint2.hashCode();
        }
        return i12 + i11;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setDeviceFingerprint(String str) {
        this.deviceFingerprint = str;
    }

    public void setPaymentMethodCode(String str) {
        this.paymentMethodCode = str;
    }

    public String toString() {
        return "H5FiatChannelBindInfo(channel=" + getChannel() + ", paymentMethodCode=" + getPaymentMethodCode() + ", deviceFingerprint=" + getDeviceFingerprint() + ")";
    }
}
