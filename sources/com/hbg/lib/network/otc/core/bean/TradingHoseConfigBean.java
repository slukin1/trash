package com.hbg.lib.network.otc.core.bean;

public class TradingHoseConfigBean extends BaseTradingHoseBean {
    private String baseCoinMaxAmount;
    private String baseCoinMinAmount;
    private int baseCoinPrecision;
    private String baseCoinWalletAmount;
    private String quoteCoinMaxAmount;
    private String quoteCoinMinAmount;
    private int quoteCoinPrecision;
    private String quoteCoinWalletAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof TradingHoseConfigBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradingHoseConfigBean)) {
            return false;
        }
        TradingHoseConfigBean tradingHoseConfigBean = (TradingHoseConfigBean) obj;
        if (!tradingHoseConfigBean.canEqual(this)) {
            return false;
        }
        String quoteCoinMinAmount2 = getQuoteCoinMinAmount();
        String quoteCoinMinAmount3 = tradingHoseConfigBean.getQuoteCoinMinAmount();
        if (quoteCoinMinAmount2 != null ? !quoteCoinMinAmount2.equals(quoteCoinMinAmount3) : quoteCoinMinAmount3 != null) {
            return false;
        }
        String quoteCoinMaxAmount2 = getQuoteCoinMaxAmount();
        String quoteCoinMaxAmount3 = tradingHoseConfigBean.getQuoteCoinMaxAmount();
        if (quoteCoinMaxAmount2 != null ? !quoteCoinMaxAmount2.equals(quoteCoinMaxAmount3) : quoteCoinMaxAmount3 != null) {
            return false;
        }
        String baseCoinMinAmount2 = getBaseCoinMinAmount();
        String baseCoinMinAmount3 = tradingHoseConfigBean.getBaseCoinMinAmount();
        if (baseCoinMinAmount2 != null ? !baseCoinMinAmount2.equals(baseCoinMinAmount3) : baseCoinMinAmount3 != null) {
            return false;
        }
        String baseCoinMaxAmount2 = getBaseCoinMaxAmount();
        String baseCoinMaxAmount3 = tradingHoseConfigBean.getBaseCoinMaxAmount();
        if (baseCoinMaxAmount2 != null ? !baseCoinMaxAmount2.equals(baseCoinMaxAmount3) : baseCoinMaxAmount3 != null) {
            return false;
        }
        if (getBaseCoinPrecision() != tradingHoseConfigBean.getBaseCoinPrecision() || getQuoteCoinPrecision() != tradingHoseConfigBean.getQuoteCoinPrecision()) {
            return false;
        }
        String baseCoinWalletAmount2 = getBaseCoinWalletAmount();
        String baseCoinWalletAmount3 = tradingHoseConfigBean.getBaseCoinWalletAmount();
        if (baseCoinWalletAmount2 != null ? !baseCoinWalletAmount2.equals(baseCoinWalletAmount3) : baseCoinWalletAmount3 != null) {
            return false;
        }
        String quoteCoinWalletAmount2 = getQuoteCoinWalletAmount();
        String quoteCoinWalletAmount3 = tradingHoseConfigBean.getQuoteCoinWalletAmount();
        return quoteCoinWalletAmount2 != null ? quoteCoinWalletAmount2.equals(quoteCoinWalletAmount3) : quoteCoinWalletAmount3 == null;
    }

    public String getBaseCoinMaxAmount() {
        return this.baseCoinMaxAmount;
    }

    public String getBaseCoinMinAmount() {
        return this.baseCoinMinAmount;
    }

    public int getBaseCoinPrecision() {
        return this.baseCoinPrecision;
    }

    public String getBaseCoinWalletAmount() {
        return this.baseCoinWalletAmount;
    }

    public String getQuoteCoinMaxAmount() {
        return this.quoteCoinMaxAmount;
    }

    public String getQuoteCoinMinAmount() {
        return this.quoteCoinMinAmount;
    }

    public int getQuoteCoinPrecision() {
        return this.quoteCoinPrecision;
    }

    public String getQuoteCoinWalletAmount() {
        return this.quoteCoinWalletAmount;
    }

    public int hashCode() {
        String quoteCoinMinAmount2 = getQuoteCoinMinAmount();
        int i11 = 43;
        int hashCode = quoteCoinMinAmount2 == null ? 43 : quoteCoinMinAmount2.hashCode();
        String quoteCoinMaxAmount2 = getQuoteCoinMaxAmount();
        int hashCode2 = ((hashCode + 59) * 59) + (quoteCoinMaxAmount2 == null ? 43 : quoteCoinMaxAmount2.hashCode());
        String baseCoinMinAmount2 = getBaseCoinMinAmount();
        int hashCode3 = (hashCode2 * 59) + (baseCoinMinAmount2 == null ? 43 : baseCoinMinAmount2.hashCode());
        String baseCoinMaxAmount2 = getBaseCoinMaxAmount();
        int hashCode4 = (((((hashCode3 * 59) + (baseCoinMaxAmount2 == null ? 43 : baseCoinMaxAmount2.hashCode())) * 59) + getBaseCoinPrecision()) * 59) + getQuoteCoinPrecision();
        String baseCoinWalletAmount2 = getBaseCoinWalletAmount();
        int hashCode5 = (hashCode4 * 59) + (baseCoinWalletAmount2 == null ? 43 : baseCoinWalletAmount2.hashCode());
        String quoteCoinWalletAmount2 = getQuoteCoinWalletAmount();
        int i12 = hashCode5 * 59;
        if (quoteCoinWalletAmount2 != null) {
            i11 = quoteCoinWalletAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setBaseCoinMaxAmount(String str) {
        this.baseCoinMaxAmount = str;
    }

    public void setBaseCoinMinAmount(String str) {
        this.baseCoinMinAmount = str;
    }

    public void setBaseCoinPrecision(int i11) {
        this.baseCoinPrecision = i11;
    }

    public void setBaseCoinWalletAmount(String str) {
        this.baseCoinWalletAmount = str;
    }

    public void setQuoteCoinMaxAmount(String str) {
        this.quoteCoinMaxAmount = str;
    }

    public void setQuoteCoinMinAmount(String str) {
        this.quoteCoinMinAmount = str;
    }

    public void setQuoteCoinPrecision(int i11) {
        this.quoteCoinPrecision = i11;
    }

    public void setQuoteCoinWalletAmount(String str) {
        this.quoteCoinWalletAmount = str;
    }

    public String toString() {
        return "TradingHoseConfigBean(quoteCoinMinAmount=" + getQuoteCoinMinAmount() + ", quoteCoinMaxAmount=" + getQuoteCoinMaxAmount() + ", baseCoinMinAmount=" + getBaseCoinMinAmount() + ", baseCoinMaxAmount=" + getBaseCoinMaxAmount() + ", baseCoinPrecision=" + getBaseCoinPrecision() + ", quoteCoinPrecision=" + getQuoteCoinPrecision() + ", baseCoinWalletAmount=" + getBaseCoinWalletAmount() + ", quoteCoinWalletAmount=" + getQuoteCoinWalletAmount() + ")";
    }
}
