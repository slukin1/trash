package com.hbg.lite.wallet.bean;

import i6.m;
import java.io.Serializable;
import java.math.BigDecimal;

public class BaseAssetInfo implements Serializable {
    private static final long serialVersionUID = 8022057565578412135L;
    private String available;
    private String currency;
    private String estimateAmountToBtc;
    private String estimateAmountToLegal;
    private String estimateAmountToUsdt;
    private boolean isShow;
    private String lock;
    private String onOrders;

    public boolean canEqual(Object obj) {
        return obj instanceof BaseAssetInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseAssetInfo)) {
            return false;
        }
        BaseAssetInfo baseAssetInfo = (BaseAssetInfo) obj;
        if (!baseAssetInfo.canEqual(this)) {
            return false;
        }
        String available2 = getAvailable();
        String available3 = baseAssetInfo.getAvailable();
        if (available2 != null ? !available2.equals(available3) : available3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = baseAssetInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String onOrders2 = getOnOrders();
        String onOrders3 = baseAssetInfo.getOnOrders();
        if (onOrders2 != null ? !onOrders2.equals(onOrders3) : onOrders3 != null) {
            return false;
        }
        String lock2 = getLock();
        String lock3 = baseAssetInfo.getLock();
        if (lock2 != null ? !lock2.equals(lock3) : lock3 != null) {
            return false;
        }
        if (isShow() != baseAssetInfo.isShow()) {
            return false;
        }
        String estimateAmountToUsdt2 = getEstimateAmountToUsdt();
        String estimateAmountToUsdt3 = baseAssetInfo.getEstimateAmountToUsdt();
        if (estimateAmountToUsdt2 != null ? !estimateAmountToUsdt2.equals(estimateAmountToUsdt3) : estimateAmountToUsdt3 != null) {
            return false;
        }
        String estimateAmountToBtc2 = getEstimateAmountToBtc();
        String estimateAmountToBtc3 = baseAssetInfo.getEstimateAmountToBtc();
        if (estimateAmountToBtc2 != null ? !estimateAmountToBtc2.equals(estimateAmountToBtc3) : estimateAmountToBtc3 != null) {
            return false;
        }
        String estimateAmountToLegal2 = getEstimateAmountToLegal();
        String estimateAmountToLegal3 = baseAssetInfo.getEstimateAmountToLegal();
        return estimateAmountToLegal2 != null ? estimateAmountToLegal2.equals(estimateAmountToLegal3) : estimateAmountToLegal3 == null;
    }

    public String getAvailable() {
        return this.available;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getEstimateAmountToBtc() {
        return this.estimateAmountToBtc;
    }

    public String getEstimateAmountToLegal() {
        return this.estimateAmountToLegal;
    }

    public String getEstimateAmountToUsdt() {
        return this.estimateAmountToUsdt;
    }

    public String getLock() {
        return this.lock;
    }

    public String getOnOrders() {
        return this.onOrders;
    }

    public int hashCode() {
        String available2 = getAvailable();
        int i11 = 43;
        int hashCode = available2 == null ? 43 : available2.hashCode();
        String currency2 = getCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String onOrders2 = getOnOrders();
        int hashCode3 = (hashCode2 * 59) + (onOrders2 == null ? 43 : onOrders2.hashCode());
        String lock2 = getLock();
        int hashCode4 = (((hashCode3 * 59) + (lock2 == null ? 43 : lock2.hashCode())) * 59) + (isShow() ? 79 : 97);
        String estimateAmountToUsdt2 = getEstimateAmountToUsdt();
        int hashCode5 = (hashCode4 * 59) + (estimateAmountToUsdt2 == null ? 43 : estimateAmountToUsdt2.hashCode());
        String estimateAmountToBtc2 = getEstimateAmountToBtc();
        int hashCode6 = (hashCode5 * 59) + (estimateAmountToBtc2 == null ? 43 : estimateAmountToBtc2.hashCode());
        String estimateAmountToLegal2 = getEstimateAmountToLegal();
        int i12 = hashCode6 * 59;
        if (estimateAmountToLegal2 != null) {
            i11 = estimateAmountToLegal2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public boolean isZeroAmount() {
        return BigDecimal.ZERO.compareTo(m.a(this.available).add(m.a(this.onOrders)).add(m.a(this.lock))) == 0;
    }

    public void setAvailable(String str) {
        this.available = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setEstimateAmountToBtc(String str) {
        this.estimateAmountToBtc = str;
    }

    public void setEstimateAmountToLegal(String str) {
        this.estimateAmountToLegal = str;
    }

    public void setEstimateAmountToUsdt(String str) {
        this.estimateAmountToUsdt = str;
    }

    public void setLock(String str) {
        this.lock = str;
    }

    public void setOnOrders(String str) {
        this.onOrders = str;
    }

    public void setShow(boolean z11) {
        this.isShow = z11;
    }

    public String toString() {
        return "BaseAssetInfo(available=" + getAvailable() + ", currency=" + getCurrency() + ", onOrders=" + getOnOrders() + ", lock=" + getLock() + ", isShow=" + isShow() + ", estimateAmountToUsdt=" + getEstimateAmountToUsdt() + ", estimateAmountToBtc=" + getEstimateAmountToBtc() + ", estimateAmountToLegal=" + getEstimateAmountToLegal() + ")";
    }
}
