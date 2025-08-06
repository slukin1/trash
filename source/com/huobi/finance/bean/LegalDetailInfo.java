package com.huobi.finance.bean;

import com.huobi.finance.viewhandler.LegalItemViewAdapter;

public class LegalDetailInfo extends BalanceDetailInfo {
    public static final int FLAG_STATUS_CANNOT_DEPOSIT = 4;
    public static final int FLAG_STATUS_CANNOT_TRADE = 1;
    public static final int FLAG_STATUS_CANNOT_TRANFER = 2;
    private String borrow;
    private int coinId;
    private boolean quoted;
    private int status;

    public boolean canEqual(Object obj) {
        return obj instanceof LegalDetailInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LegalDetailInfo)) {
            return false;
        }
        LegalDetailInfo legalDetailInfo = (LegalDetailInfo) obj;
        if (!legalDetailInfo.canEqual(this) || !super.equals(obj) || getCoinId() != legalDetailInfo.getCoinId()) {
            return false;
        }
        String borrow2 = getBorrow();
        String borrow3 = legalDetailInfo.getBorrow();
        if (borrow2 != null ? borrow2.equals(borrow3) : borrow3 == null) {
            return getStatus() == legalDetailInfo.getStatus() && isQuoted() == legalDetailInfo.isQuoted();
        }
        return false;
    }

    public String getBorrow() {
        return this.borrow;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitle() {
        return getCurrency();
    }

    public String getViewHandlerName() {
        return LegalItemViewAdapter.class.getName();
    }

    public int hashCode() {
        int hashCode = (super.hashCode() * 59) + getCoinId();
        String borrow2 = getBorrow();
        return (((((hashCode * 59) + (borrow2 == null ? 43 : borrow2.hashCode())) * 59) + getStatus()) * 59) + (isQuoted() ? 79 : 97);
    }

    public boolean isQuoted() {
        return this.quoted;
    }

    public void setBorrow(String str) {
        this.borrow = str;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setQuoted(boolean z11) {
        this.quoted = z11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public String toString() {
        return "LegalDetailInfo(coinId=" + getCoinId() + ", borrow=" + getBorrow() + ", status=" + getStatus() + ", quoted=" + isQuoted() + ")";
    }
}
