package com.hbg.module.kline.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class EtfInfo implements Serializable {
    @SerializedName("etf_amount")
    private double etfAmount;
    @SerializedName("etf_name")
    private String etfName;
    @SerializedName("etf_status")
    private int etfStatus;
    @SerializedName("initial_net_value")
    private double initialNetValue;
    @SerializedName("op_end")
    private long opEnd;
    @SerializedName("op_start")
    private long opStart;
    @SerializedName("purchase_redemption_start")
    private long purchaseRedemptionStart;
    @SerializedName("real_time_etf_amount")
    private double realTimeEtfAmount;
    @SerializedName("setup_day")
    private long setupDay;
    @SerializedName("subscribe_end")
    private long subscribeEnd;
    @SerializedName("subscribe_start")
    private long subscribeStart;

    public boolean canEqual(Object obj) {
        return obj instanceof EtfInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EtfInfo)) {
            return false;
        }
        EtfInfo etfInfo = (EtfInfo) obj;
        if (!etfInfo.canEqual(this) || Double.compare(getEtfAmount(), etfInfo.getEtfAmount()) != 0) {
            return false;
        }
        String etfName2 = getEtfName();
        String etfName3 = etfInfo.getEtfName();
        if (etfName2 != null ? etfName2.equals(etfName3) : etfName3 == null) {
            return getEtfStatus() == etfInfo.getEtfStatus() && Double.compare(getInitialNetValue(), etfInfo.getInitialNetValue()) == 0 && getOpEnd() == etfInfo.getOpEnd() && getOpStart() == etfInfo.getOpStart() && getPurchaseRedemptionStart() == etfInfo.getPurchaseRedemptionStart() && Double.compare(getRealTimeEtfAmount(), etfInfo.getRealTimeEtfAmount()) == 0 && getSetupDay() == etfInfo.getSetupDay() && getSubscribeEnd() == etfInfo.getSubscribeEnd() && getSubscribeStart() == etfInfo.getSubscribeStart();
        }
        return false;
    }

    public double getEtfAmount() {
        return this.etfAmount;
    }

    public String getEtfName() {
        return this.etfName;
    }

    public int getEtfStatus() {
        return this.etfStatus;
    }

    public double getInitialNetValue() {
        return this.initialNetValue;
    }

    public long getOpEnd() {
        return this.opEnd;
    }

    public long getOpStart() {
        return this.opStart;
    }

    public long getPurchaseRedemptionStart() {
        return this.purchaseRedemptionStart;
    }

    public double getRealTimeEtfAmount() {
        return this.realTimeEtfAmount;
    }

    public long getSetupDay() {
        return this.setupDay;
    }

    public long getSubscribeEnd() {
        return this.subscribeEnd;
    }

    public long getSubscribeStart() {
        return this.subscribeStart;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(getEtfAmount());
        String etfName2 = getEtfName();
        int hashCode = ((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 59) * 59) + (etfName2 == null ? 43 : etfName2.hashCode())) * 59) + getEtfStatus();
        long doubleToLongBits2 = Double.doubleToLongBits(getInitialNetValue());
        int i11 = (hashCode * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long opEnd2 = getOpEnd();
        int i12 = (i11 * 59) + ((int) (opEnd2 ^ (opEnd2 >>> 32)));
        long opStart2 = getOpStart();
        int i13 = (i12 * 59) + ((int) (opStart2 ^ (opStart2 >>> 32)));
        long purchaseRedemptionStart2 = getPurchaseRedemptionStart();
        int i14 = (i13 * 59) + ((int) (purchaseRedemptionStart2 ^ (purchaseRedemptionStart2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(getRealTimeEtfAmount());
        int i15 = (i14 * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long setupDay2 = getSetupDay();
        int i16 = (i15 * 59) + ((int) (setupDay2 ^ (setupDay2 >>> 32)));
        long subscribeEnd2 = getSubscribeEnd();
        int i17 = (i16 * 59) + ((int) (subscribeEnd2 ^ (subscribeEnd2 >>> 32)));
        long subscribeStart2 = getSubscribeStart();
        return (i17 * 59) + ((int) ((subscribeStart2 >>> 32) ^ subscribeStart2));
    }

    public void setEtfAmount(double d11) {
        this.etfAmount = d11;
    }

    public void setEtfName(String str) {
        this.etfName = str;
    }

    public void setEtfStatus(int i11) {
        this.etfStatus = i11;
    }

    public void setInitialNetValue(double d11) {
        this.initialNetValue = d11;
    }

    public void setOpEnd(long j11) {
        this.opEnd = j11;
    }

    public void setOpStart(long j11) {
        this.opStart = j11;
    }

    public void setPurchaseRedemptionStart(long j11) {
        this.purchaseRedemptionStart = j11;
    }

    public void setRealTimeEtfAmount(double d11) {
        this.realTimeEtfAmount = d11;
    }

    public void setSetupDay(long j11) {
        this.setupDay = j11;
    }

    public void setSubscribeEnd(long j11) {
        this.subscribeEnd = j11;
    }

    public void setSubscribeStart(long j11) {
        this.subscribeStart = j11;
    }

    public String toString() {
        return "EtfInfo(etfAmount=" + getEtfAmount() + ", etfName=" + getEtfName() + ", etfStatus=" + getEtfStatus() + ", initialNetValue=" + getInitialNetValue() + ", opEnd=" + getOpEnd() + ", opStart=" + getOpStart() + ", purchaseRedemptionStart=" + getPurchaseRedemptionStart() + ", realTimeEtfAmount=" + getRealTimeEtfAmount() + ", setupDay=" + getSetupDay() + ", subscribeEnd=" + getSubscribeEnd() + ", subscribeStart=" + getSubscribeStart() + ")";
    }
}
