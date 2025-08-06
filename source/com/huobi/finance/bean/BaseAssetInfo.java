package com.huobi.finance.bean;

import com.huobi.finance.viewhandler.BalanceViewAdapter;
import i6.m;
import java.io.Serializable;
import java.math.BigDecimal;
import s9.a;

public class BaseAssetInfo implements Serializable, a, Comparable<BaseAssetInfo> {
    private static final long serialVersionUID = 8022057565578412135L;
    private String avaialAble;
    private String credit;
    private String currency;
    private String displayName;
    private String estimateAmount;
    private String estimateAmountToBtc;
    private String holdingsNum;
    private boolean isShow = true;
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
        String avaialAble2 = getAvaialAble();
        String avaialAble3 = baseAssetInfo.getAvaialAble();
        if (avaialAble2 != null ? !avaialAble2.equals(avaialAble3) : avaialAble3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = baseAssetInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String displayName2 = getDisplayName();
        String displayName3 = baseAssetInfo.getDisplayName();
        if (displayName2 != null ? !displayName2.equals(displayName3) : displayName3 != null) {
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
        String credit2 = getCredit();
        String credit3 = baseAssetInfo.getCredit();
        if (credit2 != null ? !credit2.equals(credit3) : credit3 != null) {
            return false;
        }
        if (isShow() != baseAssetInfo.isShow()) {
            return false;
        }
        String estimateAmount2 = getEstimateAmount();
        String estimateAmount3 = baseAssetInfo.getEstimateAmount();
        if (estimateAmount2 != null ? !estimateAmount2.equals(estimateAmount3) : estimateAmount3 != null) {
            return false;
        }
        String estimateAmountToBtc2 = getEstimateAmountToBtc();
        String estimateAmountToBtc3 = baseAssetInfo.getEstimateAmountToBtc();
        if (estimateAmountToBtc2 != null ? !estimateAmountToBtc2.equals(estimateAmountToBtc3) : estimateAmountToBtc3 != null) {
            return false;
        }
        String holdingsNum2 = getHoldingsNum();
        String holdingsNum3 = baseAssetInfo.getHoldingsNum();
        return holdingsNum2 != null ? holdingsNum2.equals(holdingsNum3) : holdingsNum3 == null;
    }

    public String getAvaialAble() {
        return this.avaialAble;
    }

    public String getCredit() {
        return this.credit;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDelegateKey() {
        return this.currency;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEstimateAmount() {
        return this.estimateAmount;
    }

    public String getEstimateAmountToBtc() {
        return this.estimateAmountToBtc;
    }

    public String getHoldingsNum() {
        return this.holdingsNum;
    }

    public String getLock() {
        return this.lock;
    }

    public String getNetBalance() {
        return m.a(this.avaialAble).add(m.a(this.onOrders)).add(m.a(this.lock)).subtract(m.a(this.credit)).toPlainString();
    }

    public String getOnOrders() {
        return this.onOrders;
    }

    public String getTitle() {
        return this.currency;
    }

    public String getViewHandlerName() {
        return BalanceViewAdapter.class.getName();
    }

    public int hashCode() {
        String avaialAble2 = getAvaialAble();
        int i11 = 43;
        int hashCode = avaialAble2 == null ? 43 : avaialAble2.hashCode();
        String currency2 = getCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String displayName2 = getDisplayName();
        int hashCode3 = (hashCode2 * 59) + (displayName2 == null ? 43 : displayName2.hashCode());
        String onOrders2 = getOnOrders();
        int hashCode4 = (hashCode3 * 59) + (onOrders2 == null ? 43 : onOrders2.hashCode());
        String lock2 = getLock();
        int hashCode5 = (hashCode4 * 59) + (lock2 == null ? 43 : lock2.hashCode());
        String credit2 = getCredit();
        int hashCode6 = (((hashCode5 * 59) + (credit2 == null ? 43 : credit2.hashCode())) * 59) + (isShow() ? 79 : 97);
        String estimateAmount2 = getEstimateAmount();
        int hashCode7 = (hashCode6 * 59) + (estimateAmount2 == null ? 43 : estimateAmount2.hashCode());
        String estimateAmountToBtc2 = getEstimateAmountToBtc();
        int hashCode8 = (hashCode7 * 59) + (estimateAmountToBtc2 == null ? 43 : estimateAmountToBtc2.hashCode());
        String holdingsNum2 = getHoldingsNum();
        int i12 = hashCode8 * 59;
        if (holdingsNum2 != null) {
            i11 = holdingsNum2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isMinAmountAsset() {
        return isMinAmountAsset(this.estimateAmountToBtc);
    }

    public boolean isShow() {
        return this.isShow;
    }

    public boolean isZeroAmount() {
        return BigDecimal.ZERO.compareTo(m.a(this.avaialAble).add(m.a(this.onOrders)).add(m.a(this.lock))) == 0;
    }

    public void setAvaialAble(String str) {
        this.avaialAble = str;
    }

    public void setCredit(String str) {
        this.credit = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setEstimateAmount(String str) {
        this.estimateAmount = str;
    }

    public void setEstimateAmountToBtc(String str) {
        this.estimateAmountToBtc = str;
    }

    public void setHoldingsNum(String str) {
        this.holdingsNum = str;
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
        return "BaseAssetInfo(avaialAble=" + getAvaialAble() + ", currency=" + getCurrency() + ", displayName=" + getDisplayName() + ", onOrders=" + getOnOrders() + ", lock=" + getLock() + ", credit=" + getCredit() + ", isShow=" + isShow() + ", estimateAmount=" + getEstimateAmount() + ", estimateAmountToBtc=" + getEstimateAmountToBtc() + ", holdingsNum=" + getHoldingsNum() + ")";
    }

    public static final boolean isMinAmountAsset(String str) {
        try {
            BigDecimal bigDecimal = new BigDecimal(str);
            if (bigDecimal.compareTo(wi.a.f48036a) >= 0 || bigDecimal.compareTo(BigDecimal.ZERO) < 0) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public int compareTo(BaseAssetInfo baseAssetInfo) {
        if (baseAssetInfo == null) {
            return -1;
        }
        return m.a(baseAssetInfo.getEstimateAmount()).compareTo(m.a(getEstimateAmount()));
    }
}
