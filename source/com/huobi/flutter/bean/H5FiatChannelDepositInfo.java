package com.huobi.flutter.bean;

import java.io.Serializable;

public class H5FiatChannelDepositInfo implements Serializable {
    private static final long serialVersionUID = 4532003034531384532L;
    private String accountNumber;
    private String currency;
    private String orderCode;

    public boolean canEqual(Object obj) {
        return obj instanceof H5FiatChannelDepositInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof H5FiatChannelDepositInfo)) {
            return false;
        }
        H5FiatChannelDepositInfo h5FiatChannelDepositInfo = (H5FiatChannelDepositInfo) obj;
        if (!h5FiatChannelDepositInfo.canEqual(this)) {
            return false;
        }
        String orderCode2 = getOrderCode();
        String orderCode3 = h5FiatChannelDepositInfo.getOrderCode();
        if (orderCode2 != null ? !orderCode2.equals(orderCode3) : orderCode3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = h5FiatChannelDepositInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String accountNumber2 = getAccountNumber();
        String accountNumber3 = h5FiatChannelDepositInfo.getAccountNumber();
        return accountNumber2 != null ? accountNumber2.equals(accountNumber3) : accountNumber3 == null;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getOrderCode() {
        return this.orderCode;
    }

    public int hashCode() {
        String orderCode2 = getOrderCode();
        int i11 = 43;
        int hashCode = orderCode2 == null ? 43 : orderCode2.hashCode();
        String currency2 = getCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String accountNumber2 = getAccountNumber();
        int i12 = hashCode2 * 59;
        if (accountNumber2 != null) {
            i11 = accountNumber2.hashCode();
        }
        return i12 + i11;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setOrderCode(String str) {
        this.orderCode = str;
    }

    public String toString() {
        return "H5FiatChannelDepositInfo(orderCode=" + getOrderCode() + ", currency=" + getCurrency() + ", accountNumber=" + getAccountNumber() + ")";
    }
}
