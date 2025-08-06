package com.huobi.trade.bean;

import java.io.Serializable;

public class OrderConfirmBean implements Serializable {
    public static final int CALL_ACTION_PHASE_ONE = 1;
    public static final int CALL_ACTION_PHASE_TWO = 2;
    public static final String DEFAULT_STR = "--";
    private static final long serialVersionUID = 3357701693115991507L;
    private String accountId;
    private String amount;
    private int callActionPhase;
    private String diaplayLoan;
    private String diaplayTriggerValue;
    private String displayAmount;
    private String displayOrderType;
    private String displayPrice;
    private String displaySymbol;
    private String displayTotal;
    private String displayVolume;
    private boolean isBuy;
    private boolean isLoan;
    private String marginAmount;
    private String orderType;
    private String price;
    private String symbol;
    private int tradeViewType;

    public boolean canEqual(Object obj) {
        return obj instanceof OrderConfirmBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderConfirmBean)) {
            return false;
        }
        OrderConfirmBean orderConfirmBean = (OrderConfirmBean) obj;
        if (!orderConfirmBean.canEqual(this)) {
            return false;
        }
        String displaySymbol2 = getDisplaySymbol();
        String displaySymbol3 = orderConfirmBean.getDisplaySymbol();
        if (displaySymbol2 != null ? !displaySymbol2.equals(displaySymbol3) : displaySymbol3 != null) {
            return false;
        }
        String displayOrderType2 = getDisplayOrderType();
        String displayOrderType3 = orderConfirmBean.getDisplayOrderType();
        if (displayOrderType2 != null ? !displayOrderType2.equals(displayOrderType3) : displayOrderType3 != null) {
            return false;
        }
        String displayPrice2 = getDisplayPrice();
        String displayPrice3 = orderConfirmBean.getDisplayPrice();
        if (displayPrice2 != null ? !displayPrice2.equals(displayPrice3) : displayPrice3 != null) {
            return false;
        }
        String displayAmount2 = getDisplayAmount();
        String displayAmount3 = orderConfirmBean.getDisplayAmount();
        if (displayAmount2 != null ? !displayAmount2.equals(displayAmount3) : displayAmount3 != null) {
            return false;
        }
        String displayTotal2 = getDisplayTotal();
        String displayTotal3 = orderConfirmBean.getDisplayTotal();
        if (displayTotal2 != null ? !displayTotal2.equals(displayTotal3) : displayTotal3 != null) {
            return false;
        }
        String displayVolume2 = getDisplayVolume();
        String displayVolume3 = orderConfirmBean.getDisplayVolume();
        if (displayVolume2 != null ? !displayVolume2.equals(displayVolume3) : displayVolume3 != null) {
            return false;
        }
        String diaplayLoan2 = getDiaplayLoan();
        String diaplayLoan3 = orderConfirmBean.getDiaplayLoan();
        if (diaplayLoan2 != null ? !diaplayLoan2.equals(diaplayLoan3) : diaplayLoan3 != null) {
            return false;
        }
        String diaplayTriggerValue2 = getDiaplayTriggerValue();
        String diaplayTriggerValue3 = orderConfirmBean.getDiaplayTriggerValue();
        if (diaplayTriggerValue2 != null ? !diaplayTriggerValue2.equals(diaplayTriggerValue3) : diaplayTriggerValue3 != null) {
            return false;
        }
        if (isBuy() != orderConfirmBean.isBuy()) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = orderConfirmBean.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        if (isLoan() != orderConfirmBean.isLoan()) {
            return false;
        }
        String orderType2 = getOrderType();
        String orderType3 = orderConfirmBean.getOrderType();
        if (orderType2 != null ? !orderType2.equals(orderType3) : orderType3 != null) {
            return false;
        }
        String marginAmount2 = getMarginAmount();
        String marginAmount3 = orderConfirmBean.getMarginAmount();
        if (marginAmount2 != null ? !marginAmount2.equals(marginAmount3) : marginAmount3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = orderConfirmBean.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = orderConfirmBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String accountId2 = getAccountId();
        String accountId3 = orderConfirmBean.getAccountId();
        if (accountId2 != null ? accountId2.equals(accountId3) : accountId3 == null) {
            return getTradeViewType() == orderConfirmBean.getTradeViewType() && getCallActionPhase() == orderConfirmBean.getCallActionPhase();
        }
        return false;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getAmount() {
        return this.amount;
    }

    public int getCallActionPhase() {
        return this.callActionPhase;
    }

    public String getDiaplayLoan() {
        return this.diaplayLoan;
    }

    public String getDiaplayTriggerValue() {
        return this.diaplayTriggerValue;
    }

    public String getDisplayAmount() {
        return this.displayAmount;
    }

    public String getDisplayOrderType() {
        return this.displayOrderType;
    }

    public String getDisplayPrice() {
        return this.displayPrice;
    }

    public String getDisplaySymbol() {
        return this.displaySymbol;
    }

    public String getDisplayTotal() {
        return this.displayTotal;
    }

    public String getDisplayVolume() {
        return this.displayVolume;
    }

    public String getMarginAmount() {
        return this.marginAmount;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public String getPrice() {
        return this.price;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getTradeViewType() {
        return this.tradeViewType;
    }

    public int hashCode() {
        String displaySymbol2 = getDisplaySymbol();
        int i11 = 43;
        int hashCode = displaySymbol2 == null ? 43 : displaySymbol2.hashCode();
        String displayOrderType2 = getDisplayOrderType();
        int hashCode2 = ((hashCode + 59) * 59) + (displayOrderType2 == null ? 43 : displayOrderType2.hashCode());
        String displayPrice2 = getDisplayPrice();
        int hashCode3 = (hashCode2 * 59) + (displayPrice2 == null ? 43 : displayPrice2.hashCode());
        String displayAmount2 = getDisplayAmount();
        int hashCode4 = (hashCode3 * 59) + (displayAmount2 == null ? 43 : displayAmount2.hashCode());
        String displayTotal2 = getDisplayTotal();
        int hashCode5 = (hashCode4 * 59) + (displayTotal2 == null ? 43 : displayTotal2.hashCode());
        String displayVolume2 = getDisplayVolume();
        int hashCode6 = (hashCode5 * 59) + (displayVolume2 == null ? 43 : displayVolume2.hashCode());
        String diaplayLoan2 = getDiaplayLoan();
        int hashCode7 = (hashCode6 * 59) + (diaplayLoan2 == null ? 43 : diaplayLoan2.hashCode());
        String diaplayTriggerValue2 = getDiaplayTriggerValue();
        int i12 = 79;
        int hashCode8 = (((hashCode7 * 59) + (diaplayTriggerValue2 == null ? 43 : diaplayTriggerValue2.hashCode())) * 59) + (isBuy() ? 79 : 97);
        String symbol2 = getSymbol();
        int hashCode9 = ((hashCode8 * 59) + (symbol2 == null ? 43 : symbol2.hashCode())) * 59;
        if (!isLoan()) {
            i12 = 97;
        }
        String orderType2 = getOrderType();
        int hashCode10 = ((hashCode9 + i12) * 59) + (orderType2 == null ? 43 : orderType2.hashCode());
        String marginAmount2 = getMarginAmount();
        int hashCode11 = (hashCode10 * 59) + (marginAmount2 == null ? 43 : marginAmount2.hashCode());
        String price2 = getPrice();
        int hashCode12 = (hashCode11 * 59) + (price2 == null ? 43 : price2.hashCode());
        String amount2 = getAmount();
        int hashCode13 = (hashCode12 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String accountId2 = getAccountId();
        int i13 = hashCode13 * 59;
        if (accountId2 != null) {
            i11 = accountId2.hashCode();
        }
        return ((((i13 + i11) * 59) + getTradeViewType()) * 59) + getCallActionPhase();
    }

    public boolean isBuy() {
        return this.isBuy;
    }

    public boolean isLoan() {
        return this.isLoan;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setBuy(boolean z11) {
        this.isBuy = z11;
    }

    public void setCallActionPhase(int i11) {
        this.callActionPhase = i11;
    }

    public void setDiaplayLoan(String str) {
        this.diaplayLoan = str;
    }

    public void setDiaplayTriggerValue(String str) {
        this.diaplayTriggerValue = str;
    }

    public void setDisplayAmount(String str) {
        this.displayAmount = str;
    }

    public void setDisplayOrderType(String str) {
        this.displayOrderType = str;
    }

    public void setDisplayPrice(String str) {
        this.displayPrice = str;
    }

    public void setDisplaySymbol(String str) {
        this.displaySymbol = str;
    }

    public void setDisplayTotal(String str) {
        this.displayTotal = str;
    }

    public void setDisplayVolume(String str) {
        this.displayVolume = str;
    }

    public void setLoan(boolean z11) {
        this.isLoan = z11;
    }

    public void setMarginAmount(String str) {
        this.marginAmount = str;
    }

    public void setOrderType(String str) {
        this.orderType = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradeViewType(int i11) {
        this.tradeViewType = i11;
    }

    public String toString() {
        return "OrderConfirmBean(displaySymbol=" + getDisplaySymbol() + ", displayOrderType=" + getDisplayOrderType() + ", displayPrice=" + getDisplayPrice() + ", displayAmount=" + getDisplayAmount() + ", displayTotal=" + getDisplayTotal() + ", displayVolume=" + getDisplayVolume() + ", diaplayLoan=" + getDiaplayLoan() + ", diaplayTriggerValue=" + getDiaplayTriggerValue() + ", isBuy=" + isBuy() + ", symbol=" + getSymbol() + ", isLoan=" + isLoan() + ", orderType=" + getOrderType() + ", marginAmount=" + getMarginAmount() + ", price=" + getPrice() + ", amount=" + getAmount() + ", accountId=" + getAccountId() + ", tradeViewType=" + getTradeViewType() + ", callActionPhase=" + getCallActionPhase() + ")";
    }
}
