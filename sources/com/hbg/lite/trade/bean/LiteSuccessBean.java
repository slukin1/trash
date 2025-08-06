package com.hbg.lite.trade.bean;

import java.io.Serializable;

public class LiteSuccessBean implements Serializable {
    private String amount;
    private int areaType;
    private String baseCoinName;
    private String baseCoinQuantity;
    private int cardOrderStatus;
    private int coinId;
    private String coinName;
    private String coinQuantity;
    private String currencyName;
    private String fiatCoinCode;
    private String hbgContentUrl;
    private boolean isBalanceTrade;
    private boolean isBindCardTrade;
    private boolean isBuy;
    private boolean isFromOrderDetail;
    private boolean isP2pOrder;
    private boolean isThirdTrade;
    private String orderId;
    private int orderStatus;
    private String payMethodCode;
    private String quote;
    private String quoteAssetName;
    private String roleName;
    private int runMode;

    public boolean canEqual(Object obj) {
        return obj instanceof LiteSuccessBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteSuccessBean)) {
            return false;
        }
        LiteSuccessBean liteSuccessBean = (LiteSuccessBean) obj;
        if (!liteSuccessBean.canEqual(this)) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = liteSuccessBean.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        if (isBuy() != liteSuccessBean.isBuy()) {
            return false;
        }
        String coinQuantity2 = getCoinQuantity();
        String coinQuantity3 = liteSuccessBean.getCoinQuantity();
        if (coinQuantity2 != null ? !coinQuantity2.equals(coinQuantity3) : coinQuantity3 != null) {
            return false;
        }
        String coinName2 = getCoinName();
        String coinName3 = liteSuccessBean.getCoinName();
        if (coinName2 != null ? !coinName2.equals(coinName3) : coinName3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = liteSuccessBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String currencyName2 = getCurrencyName();
        String currencyName3 = liteSuccessBean.getCurrencyName();
        if (currencyName2 != null ? !currencyName2.equals(currencyName3) : currencyName3 != null) {
            return false;
        }
        String baseCoinQuantity2 = getBaseCoinQuantity();
        String baseCoinQuantity3 = liteSuccessBean.getBaseCoinQuantity();
        if (baseCoinQuantity2 != null ? !baseCoinQuantity2.equals(baseCoinQuantity3) : baseCoinQuantity3 != null) {
            return false;
        }
        String baseCoinName2 = getBaseCoinName();
        String baseCoinName3 = liteSuccessBean.getBaseCoinName();
        if (baseCoinName2 != null ? !baseCoinName2.equals(baseCoinName3) : baseCoinName3 != null) {
            return false;
        }
        if (getCoinId() != liteSuccessBean.getCoinId()) {
            return false;
        }
        String fiatCoinCode2 = getFiatCoinCode();
        String fiatCoinCode3 = liteSuccessBean.getFiatCoinCode();
        if (fiatCoinCode2 != null ? !fiatCoinCode2.equals(fiatCoinCode3) : fiatCoinCode3 != null) {
            return false;
        }
        if (getAreaType() != liteSuccessBean.getAreaType() || isBalanceTrade() != liteSuccessBean.isBalanceTrade() || isBindCardTrade() != liteSuccessBean.isBindCardTrade() || getCardOrderStatus() != liteSuccessBean.getCardOrderStatus() || isFromOrderDetail() != liteSuccessBean.isFromOrderDetail() || isThirdTrade() != liteSuccessBean.isThirdTrade() || getRunMode() != liteSuccessBean.getRunMode()) {
            return false;
        }
        String payMethodCode2 = getPayMethodCode();
        String payMethodCode3 = liteSuccessBean.getPayMethodCode();
        if (payMethodCode2 != null ? !payMethodCode2.equals(payMethodCode3) : payMethodCode3 != null) {
            return false;
        }
        if (isP2pOrder() != liteSuccessBean.isP2pOrder() || getOrderStatus() != liteSuccessBean.getOrderStatus()) {
            return false;
        }
        String quoteAssetName2 = getQuoteAssetName();
        String quoteAssetName3 = liteSuccessBean.getQuoteAssetName();
        if (quoteAssetName2 != null ? !quoteAssetName2.equals(quoteAssetName3) : quoteAssetName3 != null) {
            return false;
        }
        String hbgContentUrl2 = getHbgContentUrl();
        String hbgContentUrl3 = liteSuccessBean.getHbgContentUrl();
        if (hbgContentUrl2 != null ? !hbgContentUrl2.equals(hbgContentUrl3) : hbgContentUrl3 != null) {
            return false;
        }
        String roleName2 = getRoleName();
        String roleName3 = liteSuccessBean.getRoleName();
        if (roleName2 != null ? !roleName2.equals(roleName3) : roleName3 != null) {
            return false;
        }
        String quote2 = getQuote();
        String quote3 = liteSuccessBean.getQuote();
        return quote2 != null ? quote2.equals(quote3) : quote3 == null;
    }

    public String getAmount() {
        return this.amount;
    }

    public int getAreaType() {
        return this.areaType;
    }

    public String getBaseCoinName() {
        return this.baseCoinName;
    }

    public String getBaseCoinQuantity() {
        return this.baseCoinQuantity;
    }

    public int getCardOrderStatus() {
        return this.cardOrderStatus;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public String getCoinName() {
        return this.coinName;
    }

    public String getCoinQuantity() {
        return this.coinQuantity;
    }

    public String getCurrencyName() {
        return this.currencyName;
    }

    public String getFiatCoinCode() {
        return this.fiatCoinCode;
    }

    public String getHbgContentUrl() {
        return this.hbgContentUrl;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public String getPayMethodCode() {
        return this.payMethodCode;
    }

    public String getQuote() {
        return this.quote;
    }

    public String getQuoteAssetName() {
        return this.quoteAssetName;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public int getRunMode() {
        return this.runMode;
    }

    public int hashCode() {
        String orderId2 = getOrderId();
        int i11 = 43;
        int i12 = 79;
        int hashCode = (((orderId2 == null ? 43 : orderId2.hashCode()) + 59) * 59) + (isBuy() ? 79 : 97);
        String coinQuantity2 = getCoinQuantity();
        int hashCode2 = (hashCode * 59) + (coinQuantity2 == null ? 43 : coinQuantity2.hashCode());
        String coinName2 = getCoinName();
        int hashCode3 = (hashCode2 * 59) + (coinName2 == null ? 43 : coinName2.hashCode());
        String amount2 = getAmount();
        int hashCode4 = (hashCode3 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String currencyName2 = getCurrencyName();
        int hashCode5 = (hashCode4 * 59) + (currencyName2 == null ? 43 : currencyName2.hashCode());
        String baseCoinQuantity2 = getBaseCoinQuantity();
        int hashCode6 = (hashCode5 * 59) + (baseCoinQuantity2 == null ? 43 : baseCoinQuantity2.hashCode());
        String baseCoinName2 = getBaseCoinName();
        int hashCode7 = (((hashCode6 * 59) + (baseCoinName2 == null ? 43 : baseCoinName2.hashCode())) * 59) + getCoinId();
        String fiatCoinCode2 = getFiatCoinCode();
        int hashCode8 = (((((((((((((((hashCode7 * 59) + (fiatCoinCode2 == null ? 43 : fiatCoinCode2.hashCode())) * 59) + getAreaType()) * 59) + (isBalanceTrade() ? 79 : 97)) * 59) + (isBindCardTrade() ? 79 : 97)) * 59) + getCardOrderStatus()) * 59) + (isFromOrderDetail() ? 79 : 97)) * 59) + (isThirdTrade() ? 79 : 97)) * 59) + getRunMode();
        String payMethodCode2 = getPayMethodCode();
        int hashCode9 = ((hashCode8 * 59) + (payMethodCode2 == null ? 43 : payMethodCode2.hashCode())) * 59;
        if (!isP2pOrder()) {
            i12 = 97;
        }
        int orderStatus2 = ((hashCode9 + i12) * 59) + getOrderStatus();
        String quoteAssetName2 = getQuoteAssetName();
        int hashCode10 = (orderStatus2 * 59) + (quoteAssetName2 == null ? 43 : quoteAssetName2.hashCode());
        String hbgContentUrl2 = getHbgContentUrl();
        int hashCode11 = (hashCode10 * 59) + (hbgContentUrl2 == null ? 43 : hbgContentUrl2.hashCode());
        String roleName2 = getRoleName();
        int hashCode12 = (hashCode11 * 59) + (roleName2 == null ? 43 : roleName2.hashCode());
        String quote2 = getQuote();
        int i13 = hashCode12 * 59;
        if (quote2 != null) {
            i11 = quote2.hashCode();
        }
        return i13 + i11;
    }

    public boolean isBalanceTrade() {
        return this.isBalanceTrade;
    }

    public boolean isBindCardTrade() {
        return this.isBindCardTrade;
    }

    public boolean isBuy() {
        return this.isBuy;
    }

    public boolean isFromOrderDetail() {
        return this.isFromOrderDetail;
    }

    public boolean isP2pOrder() {
        return this.isP2pOrder;
    }

    public boolean isThirdTrade() {
        return this.isThirdTrade;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setAreaType(int i11) {
        this.areaType = i11;
    }

    public void setBalanceTrade(boolean z11) {
        this.isBalanceTrade = z11;
    }

    public void setBaseCoinName(String str) {
        this.baseCoinName = str;
    }

    public void setBaseCoinQuantity(String str) {
        this.baseCoinQuantity = str;
    }

    public void setBindCardTrade(boolean z11) {
        this.isBindCardTrade = z11;
    }

    public void setBuy(boolean z11) {
        this.isBuy = z11;
    }

    public void setCardOrderStatus(int i11) {
        this.cardOrderStatus = i11;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setCoinName(String str) {
        this.coinName = str;
    }

    public void setCoinQuantity(String str) {
        this.coinQuantity = str;
    }

    public void setCurrencyName(String str) {
        this.currencyName = str;
    }

    public void setFiatCoinCode(String str) {
        this.fiatCoinCode = str;
    }

    public void setFromOrderDetail(boolean z11) {
        this.isFromOrderDetail = z11;
    }

    public void setHbgContentUrl(String str) {
        this.hbgContentUrl = str;
    }

    public void setIsP2pOrder(boolean z11) {
        this.isP2pOrder = z11;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrderStatus(int i11) {
        this.orderStatus = i11;
    }

    public void setP2pOrderStatus(int i11) {
        this.orderStatus = i11;
    }

    public void setPayMethodCode(String str) {
        this.payMethodCode = str;
    }

    public void setQuote(String str) {
        this.quote = str;
    }

    public void setQuoteAssetName(String str) {
        this.quoteAssetName = str;
    }

    public void setRoleName(String str) {
        this.roleName = str;
    }

    public void setRunMode(int i11) {
        this.runMode = i11;
    }

    public void setThirdTrade(boolean z11) {
        this.isThirdTrade = z11;
    }

    public String toString() {
        return "LiteSuccessBean(orderId=" + getOrderId() + ", isBuy=" + isBuy() + ", coinQuantity=" + getCoinQuantity() + ", coinName=" + getCoinName() + ", amount=" + getAmount() + ", currencyName=" + getCurrencyName() + ", baseCoinQuantity=" + getBaseCoinQuantity() + ", baseCoinName=" + getBaseCoinName() + ", coinId=" + getCoinId() + ", fiatCoinCode=" + getFiatCoinCode() + ", areaType=" + getAreaType() + ", isBalanceTrade=" + isBalanceTrade() + ", isBindCardTrade=" + isBindCardTrade() + ", cardOrderStatus=" + getCardOrderStatus() + ", isFromOrderDetail=" + isFromOrderDetail() + ", isThirdTrade=" + isThirdTrade() + ", runMode=" + getRunMode() + ", payMethodCode=" + getPayMethodCode() + ", isP2pOrder=" + isP2pOrder() + ", orderStatus=" + getOrderStatus() + ", quoteAssetName=" + getQuoteAssetName() + ", hbgContentUrl=" + getHbgContentUrl() + ", roleName=" + getRoleName() + ", quote=" + getQuote() + ")";
    }
}
