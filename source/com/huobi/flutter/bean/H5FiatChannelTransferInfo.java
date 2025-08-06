package com.huobi.flutter.bean;

import java.io.Serializable;

public class H5FiatChannelTransferInfo implements Serializable {
    private static final long serialVersionUID = 4532003034531384532L;
    private String amount;
    private String channel;
    private String currency;
    private String deviceFingerprint;
    private String limitMax;
    private String limitMin;
    private String paymentMethodCode;

    public boolean canEqual(Object obj) {
        return obj instanceof H5FiatChannelTransferInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof H5FiatChannelTransferInfo)) {
            return false;
        }
        H5FiatChannelTransferInfo h5FiatChannelTransferInfo = (H5FiatChannelTransferInfo) obj;
        if (!h5FiatChannelTransferInfo.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = h5FiatChannelTransferInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String channel2 = getChannel();
        String channel3 = h5FiatChannelTransferInfo.getChannel();
        if (channel2 != null ? !channel2.equals(channel3) : channel3 != null) {
            return false;
        }
        String paymentMethodCode2 = getPaymentMethodCode();
        String paymentMethodCode3 = h5FiatChannelTransferInfo.getPaymentMethodCode();
        if (paymentMethodCode2 != null ? !paymentMethodCode2.equals(paymentMethodCode3) : paymentMethodCode3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = h5FiatChannelTransferInfo.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String deviceFingerprint2 = getDeviceFingerprint();
        String deviceFingerprint3 = h5FiatChannelTransferInfo.getDeviceFingerprint();
        if (deviceFingerprint2 != null ? !deviceFingerprint2.equals(deviceFingerprint3) : deviceFingerprint3 != null) {
            return false;
        }
        String limitMin2 = getLimitMin();
        String limitMin3 = h5FiatChannelTransferInfo.getLimitMin();
        if (limitMin2 != null ? !limitMin2.equals(limitMin3) : limitMin3 != null) {
            return false;
        }
        String limitMax2 = getLimitMax();
        String limitMax3 = h5FiatChannelTransferInfo.getLimitMax();
        return limitMax2 != null ? limitMax2.equals(limitMax3) : limitMax3 == null;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDeviceFingerprint() {
        return this.deviceFingerprint;
    }

    public String getLimitMax() {
        return this.limitMax;
    }

    public String getLimitMin() {
        return this.limitMin;
    }

    public String getPaymentMethodCode() {
        return this.paymentMethodCode;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String channel2 = getChannel();
        int hashCode2 = ((hashCode + 59) * 59) + (channel2 == null ? 43 : channel2.hashCode());
        String paymentMethodCode2 = getPaymentMethodCode();
        int hashCode3 = (hashCode2 * 59) + (paymentMethodCode2 == null ? 43 : paymentMethodCode2.hashCode());
        String amount2 = getAmount();
        int hashCode4 = (hashCode3 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String deviceFingerprint2 = getDeviceFingerprint();
        int hashCode5 = (hashCode4 * 59) + (deviceFingerprint2 == null ? 43 : deviceFingerprint2.hashCode());
        String limitMin2 = getLimitMin();
        int hashCode6 = (hashCode5 * 59) + (limitMin2 == null ? 43 : limitMin2.hashCode());
        String limitMax2 = getLimitMax();
        int i12 = hashCode6 * 59;
        if (limitMax2 != null) {
            i11 = limitMax2.hashCode();
        }
        return i12 + i11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDeviceFingerprint(String str) {
        this.deviceFingerprint = str;
    }

    public void setLimitMax(String str) {
        this.limitMax = str;
    }

    public void setLimitMin(String str) {
        this.limitMin = str;
    }

    public void setPaymentMethodCode(String str) {
        this.paymentMethodCode = str;
    }

    public String toString() {
        return "H5FiatChannelTransferInfo(currency=" + getCurrency() + ", channel=" + getChannel() + ", paymentMethodCode=" + getPaymentMethodCode() + ", amount=" + getAmount() + ", deviceFingerprint=" + getDeviceFingerprint() + ", limitMin=" + getLimitMin() + ", limitMax=" + getLimitMax() + ")";
    }
}
