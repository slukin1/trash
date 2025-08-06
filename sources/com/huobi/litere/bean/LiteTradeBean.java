package com.huobi.litere.bean;

import java.io.Serializable;

public class LiteTradeBean implements Serializable {
    private String cryptoCoinId;
    private String currencyId;
    private String screenHeight;
    private String screenWidth;
    private String side;

    public boolean canEqual(Object obj) {
        return obj instanceof LiteTradeBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteTradeBean)) {
            return false;
        }
        LiteTradeBean liteTradeBean = (LiteTradeBean) obj;
        if (!liteTradeBean.canEqual(this)) {
            return false;
        }
        String currencyId2 = getCurrencyId();
        String currencyId3 = liteTradeBean.getCurrencyId();
        if (currencyId2 != null ? !currencyId2.equals(currencyId3) : currencyId3 != null) {
            return false;
        }
        String cryptoCoinId2 = getCryptoCoinId();
        String cryptoCoinId3 = liteTradeBean.getCryptoCoinId();
        if (cryptoCoinId2 != null ? !cryptoCoinId2.equals(cryptoCoinId3) : cryptoCoinId3 != null) {
            return false;
        }
        String side2 = getSide();
        String side3 = liteTradeBean.getSide();
        if (side2 != null ? !side2.equals(side3) : side3 != null) {
            return false;
        }
        String screenWidth2 = getScreenWidth();
        String screenWidth3 = liteTradeBean.getScreenWidth();
        if (screenWidth2 != null ? !screenWidth2.equals(screenWidth3) : screenWidth3 != null) {
            return false;
        }
        String screenHeight2 = getScreenHeight();
        String screenHeight3 = liteTradeBean.getScreenHeight();
        return screenHeight2 != null ? screenHeight2.equals(screenHeight3) : screenHeight3 == null;
    }

    public String getCryptoCoinId() {
        return this.cryptoCoinId;
    }

    public String getCurrencyId() {
        return this.currencyId;
    }

    public String getScreenHeight() {
        return this.screenHeight;
    }

    public String getScreenWidth() {
        return this.screenWidth;
    }

    public String getSide() {
        return this.side;
    }

    public int hashCode() {
        String currencyId2 = getCurrencyId();
        int i11 = 43;
        int hashCode = currencyId2 == null ? 43 : currencyId2.hashCode();
        String cryptoCoinId2 = getCryptoCoinId();
        int hashCode2 = ((hashCode + 59) * 59) + (cryptoCoinId2 == null ? 43 : cryptoCoinId2.hashCode());
        String side2 = getSide();
        int hashCode3 = (hashCode2 * 59) + (side2 == null ? 43 : side2.hashCode());
        String screenWidth2 = getScreenWidth();
        int hashCode4 = (hashCode3 * 59) + (screenWidth2 == null ? 43 : screenWidth2.hashCode());
        String screenHeight2 = getScreenHeight();
        int i12 = hashCode4 * 59;
        if (screenHeight2 != null) {
            i11 = screenHeight2.hashCode();
        }
        return i12 + i11;
    }

    public void setCryptoCoinId(String str) {
        this.cryptoCoinId = str;
    }

    public void setCurrencyId(String str) {
        this.currencyId = str;
    }

    public void setScreenHeight(String str) {
        this.screenHeight = str;
    }

    public void setScreenWidth(String str) {
        this.screenWidth = str;
    }

    public void setSide(String str) {
        this.side = str;
    }

    public String toString() {
        return "LiteTradeBean(currencyId=" + getCurrencyId() + ", cryptoCoinId=" + getCryptoCoinId() + ", side=" + getSide() + ", screenWidth=" + getScreenWidth() + ", screenHeight=" + getScreenHeight() + ")";
    }
}
