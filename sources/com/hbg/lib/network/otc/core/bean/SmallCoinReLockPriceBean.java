package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class SmallCoinReLockPriceBean implements Serializable {
    private String amount;
    private int currencyId;
    private long expireTime;
    private String feeAsset;
    private String feeRatio;
    private boolean isNeedPassword;
    private boolean isPriceLow;
    private int leftTime;
    private String orderFee;
    private int payMethodId;
    private String payMethodName;
    private String price;
    private String quantity;
    private long serverTime;
    private int smallCoinId;
    private String token;
    private String totalFee;
    private String withdrawFee;

    public boolean canEqual(Object obj) {
        return obj instanceof SmallCoinReLockPriceBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SmallCoinReLockPriceBean)) {
            return false;
        }
        SmallCoinReLockPriceBean smallCoinReLockPriceBean = (SmallCoinReLockPriceBean) obj;
        if (!smallCoinReLockPriceBean.canEqual(this)) {
            return false;
        }
        String token2 = getToken();
        String token3 = smallCoinReLockPriceBean.getToken();
        if (token2 != null ? !token2.equals(token3) : token3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = smallCoinReLockPriceBean.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String quantity2 = getQuantity();
        String quantity3 = smallCoinReLockPriceBean.getQuantity();
        if (quantity2 != null ? !quantity2.equals(quantity3) : quantity3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = smallCoinReLockPriceBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String feeRatio2 = getFeeRatio();
        String feeRatio3 = smallCoinReLockPriceBean.getFeeRatio();
        if (feeRatio2 != null ? !feeRatio2.equals(feeRatio3) : feeRatio3 != null) {
            return false;
        }
        String totalFee2 = getTotalFee();
        String totalFee3 = smallCoinReLockPriceBean.getTotalFee();
        if (totalFee2 != null ? !totalFee2.equals(totalFee3) : totalFee3 != null) {
            return false;
        }
        String orderFee2 = getOrderFee();
        String orderFee3 = smallCoinReLockPriceBean.getOrderFee();
        if (orderFee2 != null ? !orderFee2.equals(orderFee3) : orderFee3 != null) {
            return false;
        }
        String withdrawFee2 = getWithdrawFee();
        String withdrawFee3 = smallCoinReLockPriceBean.getWithdrawFee();
        if (withdrawFee2 != null ? !withdrawFee2.equals(withdrawFee3) : withdrawFee3 != null) {
            return false;
        }
        String feeAsset2 = getFeeAsset();
        String feeAsset3 = smallCoinReLockPriceBean.getFeeAsset();
        if (feeAsset2 != null ? !feeAsset2.equals(feeAsset3) : feeAsset3 != null) {
            return false;
        }
        if (getPayMethodId() != smallCoinReLockPriceBean.getPayMethodId()) {
            return false;
        }
        String payMethodName2 = getPayMethodName();
        String payMethodName3 = smallCoinReLockPriceBean.getPayMethodName();
        if (payMethodName2 != null ? payMethodName2.equals(payMethodName3) : payMethodName3 == null) {
            return getLeftTime() == smallCoinReLockPriceBean.getLeftTime() && isNeedPassword() == smallCoinReLockPriceBean.isNeedPassword() && isPriceLow() == smallCoinReLockPriceBean.isPriceLow() && getServerTime() == smallCoinReLockPriceBean.getServerTime() && getExpireTime() == smallCoinReLockPriceBean.getExpireTime() && getSmallCoinId() == smallCoinReLockPriceBean.getSmallCoinId() && getCurrencyId() == smallCoinReLockPriceBean.getCurrencyId();
        }
        return false;
    }

    public String getAmount() {
        return this.amount;
    }

    public int getCurrencyId() {
        return this.currencyId;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getFeeAsset() {
        return this.feeAsset;
    }

    public String getFeeRatio() {
        return this.feeRatio;
    }

    public int getLeftTime() {
        return this.leftTime;
    }

    public String getOrderFee() {
        return this.orderFee;
    }

    public int getPayMethodId() {
        return this.payMethodId;
    }

    public String getPayMethodName() {
        return this.payMethodName;
    }

    public String getPrice() {
        return this.price;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public int getSmallCoinId() {
        return this.smallCoinId;
    }

    public String getToken() {
        return this.token;
    }

    public String getTotalFee() {
        return this.totalFee;
    }

    public String getWithdrawFee() {
        return this.withdrawFee;
    }

    public int hashCode() {
        String token2 = getToken();
        int i11 = 43;
        int hashCode = token2 == null ? 43 : token2.hashCode();
        String price2 = getPrice();
        int hashCode2 = ((hashCode + 59) * 59) + (price2 == null ? 43 : price2.hashCode());
        String quantity2 = getQuantity();
        int hashCode3 = (hashCode2 * 59) + (quantity2 == null ? 43 : quantity2.hashCode());
        String amount2 = getAmount();
        int hashCode4 = (hashCode3 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String feeRatio2 = getFeeRatio();
        int hashCode5 = (hashCode4 * 59) + (feeRatio2 == null ? 43 : feeRatio2.hashCode());
        String totalFee2 = getTotalFee();
        int hashCode6 = (hashCode5 * 59) + (totalFee2 == null ? 43 : totalFee2.hashCode());
        String orderFee2 = getOrderFee();
        int hashCode7 = (hashCode6 * 59) + (orderFee2 == null ? 43 : orderFee2.hashCode());
        String withdrawFee2 = getWithdrawFee();
        int hashCode8 = (hashCode7 * 59) + (withdrawFee2 == null ? 43 : withdrawFee2.hashCode());
        String feeAsset2 = getFeeAsset();
        int hashCode9 = (((hashCode8 * 59) + (feeAsset2 == null ? 43 : feeAsset2.hashCode())) * 59) + getPayMethodId();
        String payMethodName2 = getPayMethodName();
        int i12 = hashCode9 * 59;
        if (payMethodName2 != null) {
            i11 = payMethodName2.hashCode();
        }
        int i13 = 79;
        int leftTime2 = (((((i12 + i11) * 59) + getLeftTime()) * 59) + (isNeedPassword() ? 79 : 97)) * 59;
        if (!isPriceLow()) {
            i13 = 97;
        }
        int i14 = leftTime2 + i13;
        long serverTime2 = getServerTime();
        int i15 = (i14 * 59) + ((int) (serverTime2 ^ (serverTime2 >>> 32)));
        long expireTime2 = getExpireTime();
        return (((((i15 * 59) + ((int) (expireTime2 ^ (expireTime2 >>> 32)))) * 59) + getSmallCoinId()) * 59) + getCurrencyId();
    }

    public boolean isNeedPassword() {
        return this.isNeedPassword;
    }

    public boolean isPriceLow() {
        return this.isPriceLow;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCurrencyId(int i11) {
        this.currencyId = i11;
    }

    public void setExpireTime(long j11) {
        this.expireTime = j11;
    }

    public void setFeeAsset(String str) {
        this.feeAsset = str;
    }

    public void setFeeRatio(String str) {
        this.feeRatio = str;
    }

    public void setLeftTime(int i11) {
        this.leftTime = i11;
    }

    public void setNeedPassword(boolean z11) {
        this.isNeedPassword = z11;
    }

    public void setOrderFee(String str) {
        this.orderFee = str;
    }

    public void setPayMethodId(int i11) {
        this.payMethodId = i11;
    }

    public void setPayMethodName(String str) {
        this.payMethodName = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setPriceLow(boolean z11) {
        this.isPriceLow = z11;
    }

    public void setQuantity(String str) {
        this.quantity = str;
    }

    public void setServerTime(long j11) {
        this.serverTime = j11;
    }

    public void setSmallCoinId(int i11) {
        this.smallCoinId = i11;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTotalFee(String str) {
        this.totalFee = str;
    }

    public void setWithdrawFee(String str) {
        this.withdrawFee = str;
    }

    public String toString() {
        return "SmallCoinReLockPriceBean(token=" + getToken() + ", price=" + getPrice() + ", quantity=" + getQuantity() + ", amount=" + getAmount() + ", feeRatio=" + getFeeRatio() + ", totalFee=" + getTotalFee() + ", orderFee=" + getOrderFee() + ", withdrawFee=" + getWithdrawFee() + ", feeAsset=" + getFeeAsset() + ", payMethodId=" + getPayMethodId() + ", payMethodName=" + getPayMethodName() + ", leftTime=" + getLeftTime() + ", isNeedPassword=" + isNeedPassword() + ", isPriceLow=" + isPriceLow() + ", serverTime=" + getServerTime() + ", expireTime=" + getExpireTime() + ", smallCoinId=" + getSmallCoinId() + ", currencyId=" + getCurrencyId() + ")";
    }
}
