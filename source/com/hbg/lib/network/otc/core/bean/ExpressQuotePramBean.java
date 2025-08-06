package com.hbg.lib.network.otc.core.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.math.BigDecimal;

public class ExpressQuotePramBean implements Serializable {
    private static final String TRADE_AMOUNT = "amount";
    private static final String TRADE_QUANTITY = "quantity";
    private String acceptOrder;
    private BigDecimal amount;
    private String areaType;
    private String couponsId;
    private String cryptoAsset;
    private int currentArea;
    private String quoteAsset;
    private String side;
    private String type;

    public boolean canEqual(Object obj) {
        return obj instanceof ExpressQuotePramBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExpressQuotePramBean)) {
            return false;
        }
        ExpressQuotePramBean expressQuotePramBean = (ExpressQuotePramBean) obj;
        if (!expressQuotePramBean.canEqual(this)) {
            return false;
        }
        String cryptoAsset2 = getCryptoAsset();
        String cryptoAsset3 = expressQuotePramBean.getCryptoAsset();
        if (cryptoAsset2 != null ? !cryptoAsset2.equals(cryptoAsset3) : cryptoAsset3 != null) {
            return false;
        }
        String quoteAsset2 = getQuoteAsset();
        String quoteAsset3 = expressQuotePramBean.getQuoteAsset();
        if (quoteAsset2 != null ? !quoteAsset2.equals(quoteAsset3) : quoteAsset3 != null) {
            return false;
        }
        BigDecimal amount2 = getAmount();
        BigDecimal amount3 = expressQuotePramBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String type2 = getType();
        String type3 = expressQuotePramBean.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String side2 = getSide();
        String side3 = expressQuotePramBean.getSide();
        if (side2 != null ? !side2.equals(side3) : side3 != null) {
            return false;
        }
        String couponsId2 = getCouponsId();
        String couponsId3 = expressQuotePramBean.getCouponsId();
        if (couponsId2 != null ? !couponsId2.equals(couponsId3) : couponsId3 != null) {
            return false;
        }
        String areaType2 = getAreaType();
        String areaType3 = expressQuotePramBean.getAreaType();
        if (areaType2 != null ? !areaType2.equals(areaType3) : areaType3 != null) {
            return false;
        }
        String acceptOrder2 = getAcceptOrder();
        String acceptOrder3 = expressQuotePramBean.getAcceptOrder();
        if (acceptOrder2 != null ? acceptOrder2.equals(acceptOrder3) : acceptOrder3 == null) {
            return getCurrentArea() == expressQuotePramBean.getCurrentArea();
        }
        return false;
    }

    public String getAcceptOrder() {
        return this.acceptOrder;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getAreaType() {
        return this.areaType;
    }

    public String getCouponsId() {
        return this.couponsId;
    }

    public String getCryptoAsset() {
        return this.cryptoAsset;
    }

    public int getCurrentArea() {
        return this.currentArea;
    }

    public String getQuoteAsset() {
        return this.quoteAsset;
    }

    public String getSide() {
        return this.side;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        String cryptoAsset2 = getCryptoAsset();
        int i11 = 43;
        int hashCode = cryptoAsset2 == null ? 43 : cryptoAsset2.hashCode();
        String quoteAsset2 = getQuoteAsset();
        int hashCode2 = ((hashCode + 59) * 59) + (quoteAsset2 == null ? 43 : quoteAsset2.hashCode());
        BigDecimal amount2 = getAmount();
        int hashCode3 = (hashCode2 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String type2 = getType();
        int hashCode4 = (hashCode3 * 59) + (type2 == null ? 43 : type2.hashCode());
        String side2 = getSide();
        int hashCode5 = (hashCode4 * 59) + (side2 == null ? 43 : side2.hashCode());
        String couponsId2 = getCouponsId();
        int hashCode6 = (hashCode5 * 59) + (couponsId2 == null ? 43 : couponsId2.hashCode());
        String areaType2 = getAreaType();
        int hashCode7 = (hashCode6 * 59) + (areaType2 == null ? 43 : areaType2.hashCode());
        String acceptOrder2 = getAcceptOrder();
        int i12 = hashCode7 * 59;
        if (acceptOrder2 != null) {
            i11 = acceptOrder2.hashCode();
        }
        return ((i12 + i11) * 59) + getCurrentArea();
    }

    public boolean isAmount() {
        return TextUtils.equals(this.type, TRADE_AMOUNT);
    }

    public boolean isBuy() {
        return TextUtils.equals(this.side, "buy");
    }

    public void setAcceptOrder(String str) {
        this.acceptOrder = str;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setAreaType(String str) {
        this.areaType = str;
    }

    public void setCouponsId(String str) {
        this.couponsId = str;
    }

    public void setCryptoAsset(String str) {
        this.cryptoAsset = str;
    }

    public void setCurrentArea(int i11) {
        this.currentArea = i11;
    }

    public void setQuoteAsset(String str) {
        this.quoteAsset = str;
    }

    public void setSide(String str) {
        this.side = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "ExpressQuotePramBean(cryptoAsset=" + getCryptoAsset() + ", quoteAsset=" + getQuoteAsset() + ", amount=" + getAmount() + ", type=" + getType() + ", side=" + getSide() + ", couponsId=" + getCouponsId() + ", areaType=" + getAreaType() + ", acceptOrder=" + getAcceptOrder() + ", currentArea=" + getCurrentArea() + ")";
    }
}
