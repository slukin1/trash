package com.huobi.otc.bean;

import com.huobi.coupon.bean.Coupon;
import java.io.Serializable;
import java.util.List;

public class FastQuoteExpandBean implements Serializable {
    private String autoQuoteAmount;
    private String balance;
    private boolean isAmountExceedsLimitAutoQuote;
    private boolean isCheckTransfer;
    private boolean isCheckUserAsset;
    private boolean isCreateOrderBalanceRefreshQuote;
    private boolean isCreateOrderBindCardRefreshQuote;
    private boolean isCreateThirdPayRefreshQuote;
    private boolean isFromSelectQuote;
    private boolean isFromTransfer;
    private boolean isInputAutoQuote;
    private boolean isLimitAmountReFreshQuote;
    private boolean isReSelectQuote;
    private boolean isRefreshUserAsset;
    private boolean isSelectCouponRefreshQuote;
    private String maxAmount;
    private Coupon selectCoupon;
    private int selectQuoteId;
    private String useLimitRefreshTradeModeName;
    private List<Coupon> userCouponList;

    public boolean canEqual(Object obj) {
        return obj instanceof FastQuoteExpandBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FastQuoteExpandBean)) {
            return false;
        }
        FastQuoteExpandBean fastQuoteExpandBean = (FastQuoteExpandBean) obj;
        if (!fastQuoteExpandBean.canEqual(this) || isFromTransfer() != fastQuoteExpandBean.isFromTransfer() || isCreateOrderBalanceRefreshQuote() != fastQuoteExpandBean.isCreateOrderBalanceRefreshQuote() || isCreateOrderBindCardRefreshQuote() != fastQuoteExpandBean.isCreateOrderBindCardRefreshQuote() || isCreateThirdPayRefreshQuote() != fastQuoteExpandBean.isCreateThirdPayRefreshQuote() || isReSelectQuote() != fastQuoteExpandBean.isReSelectQuote() || isAmountExceedsLimitAutoQuote() != fastQuoteExpandBean.isAmountExceedsLimitAutoQuote()) {
            return false;
        }
        String maxAmount2 = getMaxAmount();
        String maxAmount3 = fastQuoteExpandBean.getMaxAmount();
        if (maxAmount2 != null ? !maxAmount2.equals(maxAmount3) : maxAmount3 != null) {
            return false;
        }
        if (isInputAutoQuote() != fastQuoteExpandBean.isInputAutoQuote() || isCheckTransfer() != fastQuoteExpandBean.isCheckTransfer() || isCheckUserAsset() != fastQuoteExpandBean.isCheckUserAsset() || isFromSelectQuote() != fastQuoteExpandBean.isFromSelectQuote()) {
            return false;
        }
        String balance2 = getBalance();
        String balance3 = fastQuoteExpandBean.getBalance();
        if (balance2 != null ? !balance2.equals(balance3) : balance3 != null) {
            return false;
        }
        if (getSelectQuoteId() != fastQuoteExpandBean.getSelectQuoteId() || isLimitAmountReFreshQuote() != fastQuoteExpandBean.isLimitAmountReFreshQuote()) {
            return false;
        }
        String useLimitRefreshTradeModeName2 = getUseLimitRefreshTradeModeName();
        String useLimitRefreshTradeModeName3 = fastQuoteExpandBean.getUseLimitRefreshTradeModeName();
        if (useLimitRefreshTradeModeName2 != null ? !useLimitRefreshTradeModeName2.equals(useLimitRefreshTradeModeName3) : useLimitRefreshTradeModeName3 != null) {
            return false;
        }
        String autoQuoteAmount2 = getAutoQuoteAmount();
        String autoQuoteAmount3 = fastQuoteExpandBean.getAutoQuoteAmount();
        if (autoQuoteAmount2 != null ? !autoQuoteAmount2.equals(autoQuoteAmount3) : autoQuoteAmount3 != null) {
            return false;
        }
        if (isRefreshUserAsset() != fastQuoteExpandBean.isRefreshUserAsset() || isSelectCouponRefreshQuote() != fastQuoteExpandBean.isSelectCouponRefreshQuote()) {
            return false;
        }
        Coupon selectCoupon2 = getSelectCoupon();
        Coupon selectCoupon3 = fastQuoteExpandBean.getSelectCoupon();
        if (selectCoupon2 != null ? !selectCoupon2.equals(selectCoupon3) : selectCoupon3 != null) {
            return false;
        }
        List<Coupon> userCouponList2 = getUserCouponList();
        List<Coupon> userCouponList3 = fastQuoteExpandBean.getUserCouponList();
        return userCouponList2 != null ? userCouponList2.equals(userCouponList3) : userCouponList3 == null;
    }

    public String getAutoQuoteAmount() {
        return this.autoQuoteAmount;
    }

    public String getBalance() {
        return this.balance;
    }

    public String getMaxAmount() {
        return this.maxAmount;
    }

    public Coupon getSelectCoupon() {
        return this.selectCoupon;
    }

    public int getSelectQuoteId() {
        return this.selectQuoteId;
    }

    public String getUseLimitRefreshTradeModeName() {
        return this.useLimitRefreshTradeModeName;
    }

    public List<Coupon> getUserCouponList() {
        return this.userCouponList;
    }

    public int hashCode() {
        int i11 = 79;
        int i12 = (((((((((((isFromTransfer() ? 79 : 97) + 59) * 59) + (isCreateOrderBalanceRefreshQuote() ? 79 : 97)) * 59) + (isCreateOrderBindCardRefreshQuote() ? 79 : 97)) * 59) + (isCreateThirdPayRefreshQuote() ? 79 : 97)) * 59) + (isReSelectQuote() ? 79 : 97)) * 59) + (isAmountExceedsLimitAutoQuote() ? 79 : 97);
        String maxAmount2 = getMaxAmount();
        int i13 = 43;
        int hashCode = (((((((((i12 * 59) + (maxAmount2 == null ? 43 : maxAmount2.hashCode())) * 59) + (isInputAutoQuote() ? 79 : 97)) * 59) + (isCheckTransfer() ? 79 : 97)) * 59) + (isCheckUserAsset() ? 79 : 97)) * 59) + (isFromSelectQuote() ? 79 : 97);
        String balance2 = getBalance();
        int hashCode2 = (((((hashCode * 59) + (balance2 == null ? 43 : balance2.hashCode())) * 59) + getSelectQuoteId()) * 59) + (isLimitAmountReFreshQuote() ? 79 : 97);
        String useLimitRefreshTradeModeName2 = getUseLimitRefreshTradeModeName();
        int hashCode3 = (hashCode2 * 59) + (useLimitRefreshTradeModeName2 == null ? 43 : useLimitRefreshTradeModeName2.hashCode());
        String autoQuoteAmount2 = getAutoQuoteAmount();
        int hashCode4 = ((((hashCode3 * 59) + (autoQuoteAmount2 == null ? 43 : autoQuoteAmount2.hashCode())) * 59) + (isRefreshUserAsset() ? 79 : 97)) * 59;
        if (!isSelectCouponRefreshQuote()) {
            i11 = 97;
        }
        int i14 = hashCode4 + i11;
        Coupon selectCoupon2 = getSelectCoupon();
        int hashCode5 = (i14 * 59) + (selectCoupon2 == null ? 43 : selectCoupon2.hashCode());
        List<Coupon> userCouponList2 = getUserCouponList();
        int i15 = hashCode5 * 59;
        if (userCouponList2 != null) {
            i13 = userCouponList2.hashCode();
        }
        return i15 + i13;
    }

    public boolean isAmountExceedsLimitAutoQuote() {
        return this.isAmountExceedsLimitAutoQuote;
    }

    public boolean isCheckTransfer() {
        return this.isCheckTransfer;
    }

    public boolean isCheckUserAsset() {
        return this.isCheckUserAsset;
    }

    public boolean isCreateOrderBalanceRefreshQuote() {
        return this.isCreateOrderBalanceRefreshQuote;
    }

    public boolean isCreateOrderBindCardRefreshQuote() {
        return this.isCreateOrderBindCardRefreshQuote;
    }

    public boolean isCreateThirdPayRefreshQuote() {
        return this.isCreateThirdPayRefreshQuote;
    }

    public boolean isFromSelectQuote() {
        return this.isFromSelectQuote;
    }

    public boolean isFromTransfer() {
        return this.isFromTransfer;
    }

    public boolean isInputAutoQuote() {
        return this.isInputAutoQuote;
    }

    public boolean isLimitAmountReFreshQuote() {
        return this.isLimitAmountReFreshQuote;
    }

    public boolean isReSelectQuote() {
        return this.isReSelectQuote;
    }

    public boolean isRefreshUserAsset() {
        return this.isRefreshUserAsset;
    }

    public boolean isSelectCouponRefreshQuote() {
        return this.isSelectCouponRefreshQuote;
    }

    public void setAmountExceedsLimitAutoQuote(boolean z11) {
        this.isAmountExceedsLimitAutoQuote = z11;
    }

    public void setAutoQuoteAmount(String str) {
        this.autoQuoteAmount = str;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public void setCheckTransfer(boolean z11) {
        this.isCheckTransfer = z11;
    }

    public void setCheckUserAsset(boolean z11) {
        this.isCheckUserAsset = z11;
    }

    public void setCreateOrderBalanceRefreshQuote(boolean z11) {
        this.isCreateOrderBalanceRefreshQuote = z11;
    }

    public void setCreateOrderBindCardRefreshQuote(boolean z11) {
        this.isCreateOrderBindCardRefreshQuote = z11;
    }

    public void setCreateThirdPayRefreshQuote(boolean z11) {
        this.isCreateThirdPayRefreshQuote = z11;
    }

    public void setFromSelectQuote(boolean z11) {
        this.isFromSelectQuote = z11;
    }

    public void setFromTransfer(boolean z11) {
        this.isFromTransfer = z11;
    }

    public void setInputAutoQuote(boolean z11) {
        this.isInputAutoQuote = z11;
    }

    public void setLimitAmountReFreshQuote(boolean z11) {
        this.isLimitAmountReFreshQuote = z11;
    }

    public void setMaxAmount(String str) {
        this.maxAmount = str;
    }

    public void setReSelectQuote(boolean z11) {
        this.isReSelectQuote = z11;
    }

    public void setRefreshUserAsset(boolean z11) {
        this.isRefreshUserAsset = z11;
    }

    public void setSelectCoupon(Coupon coupon) {
        this.selectCoupon = coupon;
    }

    public void setSelectCouponRefreshQuote(boolean z11) {
        this.isSelectCouponRefreshQuote = z11;
    }

    public void setSelectQuoteId(int i11) {
        this.selectQuoteId = i11;
    }

    public void setUseLimitRefreshTradeModeName(String str) {
        this.useLimitRefreshTradeModeName = str;
    }

    public void setUserCouponList(List<Coupon> list) {
        this.userCouponList = list;
    }

    public String toString() {
        return "FastQuoteExpandBean(isFromTransfer=" + isFromTransfer() + ", isCreateOrderBalanceRefreshQuote=" + isCreateOrderBalanceRefreshQuote() + ", isCreateOrderBindCardRefreshQuote=" + isCreateOrderBindCardRefreshQuote() + ", isCreateThirdPayRefreshQuote=" + isCreateThirdPayRefreshQuote() + ", isReSelectQuote=" + isReSelectQuote() + ", isAmountExceedsLimitAutoQuote=" + isAmountExceedsLimitAutoQuote() + ", maxAmount=" + getMaxAmount() + ", isInputAutoQuote=" + isInputAutoQuote() + ", isCheckTransfer=" + isCheckTransfer() + ", isCheckUserAsset=" + isCheckUserAsset() + ", isFromSelectQuote=" + isFromSelectQuote() + ", balance=" + getBalance() + ", selectQuoteId=" + getSelectQuoteId() + ", isLimitAmountReFreshQuote=" + isLimitAmountReFreshQuote() + ", useLimitRefreshTradeModeName=" + getUseLimitRefreshTradeModeName() + ", autoQuoteAmount=" + getAutoQuoteAmount() + ", isRefreshUserAsset=" + isRefreshUserAsset() + ", isSelectCouponRefreshQuote=" + isSelectCouponRefreshQuote() + ", selectCoupon=" + getSelectCoupon() + ", userCouponList=" + getUserCouponList() + ")";
    }
}
