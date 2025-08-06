package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcAdTicket implements Serializable {
    private String acceptOrder;
    private int cryptoAssetId;
    private String cryptoAssetName;
    private double feeRatio;
    private long gmtSort;
    private boolean isNeedPassword;
    private double maxTradeLimit;
    private double minTradeLimit;
    private String price;
    private int quoteAssetId;
    private int realLevel;
    private String token;
    private String tradeCount;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcAdTicket;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcAdTicket)) {
            return false;
        }
        OtcAdTicket otcAdTicket = (OtcAdTicket) obj;
        if (!otcAdTicket.canEqual(this)) {
            return false;
        }
        String price2 = getPrice();
        String price3 = otcAdTicket.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String token2 = getToken();
        String token3 = otcAdTicket.getToken();
        if (token2 != null ? !token2.equals(token3) : token3 != null) {
            return false;
        }
        if (Double.compare(getMinTradeLimit(), otcAdTicket.getMinTradeLimit()) != 0 || Double.compare(getMaxTradeLimit(), otcAdTicket.getMaxTradeLimit()) != 0) {
            return false;
        }
        String tradeCount2 = getTradeCount();
        String tradeCount3 = otcAdTicket.getTradeCount();
        if (tradeCount2 != null ? !tradeCount2.equals(tradeCount3) : tradeCount3 != null) {
            return false;
        }
        if (getCryptoAssetId() != otcAdTicket.getCryptoAssetId() || getQuoteAssetId() != otcAdTicket.getQuoteAssetId()) {
            return false;
        }
        String cryptoAssetName2 = getCryptoAssetName();
        String cryptoAssetName3 = otcAdTicket.getCryptoAssetName();
        if (cryptoAssetName2 != null ? !cryptoAssetName2.equals(cryptoAssetName3) : cryptoAssetName3 != null) {
            return false;
        }
        if (isNeedPassword() != otcAdTicket.isNeedPassword() || getGmtSort() != otcAdTicket.getGmtSort() || Double.compare(getFeeRatio(), otcAdTicket.getFeeRatio()) != 0 || getRealLevel() != otcAdTicket.getRealLevel()) {
            return false;
        }
        String acceptOrder2 = getAcceptOrder();
        String acceptOrder3 = otcAdTicket.getAcceptOrder();
        return acceptOrder2 != null ? acceptOrder2.equals(acceptOrder3) : acceptOrder3 == null;
    }

    public String getAcceptOrder() {
        return this.acceptOrder;
    }

    public int getCryptoAssetId() {
        return this.cryptoAssetId;
    }

    public String getCryptoAssetName() {
        return this.cryptoAssetName;
    }

    public double getFeeRatio() {
        return this.feeRatio;
    }

    public long getGmtSort() {
        return this.gmtSort;
    }

    public double getMaxTradeLimit() {
        return this.maxTradeLimit;
    }

    public double getMinTradeLimit() {
        return this.minTradeLimit;
    }

    public String getPrice() {
        return this.price;
    }

    public int getQuoteAssetId() {
        return this.quoteAssetId;
    }

    public int getRealLevel() {
        return this.realLevel;
    }

    public String getToken() {
        return this.token;
    }

    public String getTradeCount() {
        return this.tradeCount;
    }

    public int hashCode() {
        String price2 = getPrice();
        int i11 = 43;
        int hashCode = price2 == null ? 43 : price2.hashCode();
        String token2 = getToken();
        int hashCode2 = ((hashCode + 59) * 59) + (token2 == null ? 43 : token2.hashCode());
        long doubleToLongBits = Double.doubleToLongBits(getMinTradeLimit());
        int i12 = (hashCode2 * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        long doubleToLongBits2 = Double.doubleToLongBits(getMaxTradeLimit());
        int i13 = (i12 * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        String tradeCount2 = getTradeCount();
        int hashCode3 = (((((i13 * 59) + (tradeCount2 == null ? 43 : tradeCount2.hashCode())) * 59) + getCryptoAssetId()) * 59) + getQuoteAssetId();
        String cryptoAssetName2 = getCryptoAssetName();
        int hashCode4 = (((hashCode3 * 59) + (cryptoAssetName2 == null ? 43 : cryptoAssetName2.hashCode())) * 59) + (isNeedPassword() ? 79 : 97);
        long gmtSort2 = getGmtSort();
        int i14 = (hashCode4 * 59) + ((int) (gmtSort2 ^ (gmtSort2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(getFeeRatio());
        int realLevel2 = (((i14 * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 59) + getRealLevel();
        String acceptOrder2 = getAcceptOrder();
        int i15 = realLevel2 * 59;
        if (acceptOrder2 != null) {
            i11 = acceptOrder2.hashCode();
        }
        return i15 + i11;
    }

    public boolean isNeedPassword() {
        return this.isNeedPassword;
    }

    public void setAcceptOrder(String str) {
        this.acceptOrder = str;
    }

    public void setCryptoAssetId(int i11) {
        this.cryptoAssetId = i11;
    }

    public void setCryptoAssetName(String str) {
        this.cryptoAssetName = str;
    }

    public void setFeeRatio(double d11) {
        this.feeRatio = d11;
    }

    public void setGmtSort(long j11) {
        this.gmtSort = j11;
    }

    public void setMaxTradeLimit(double d11) {
        this.maxTradeLimit = d11;
    }

    public void setMinTradeLimit(double d11) {
        this.minTradeLimit = d11;
    }

    public void setNeedPassword(boolean z11) {
        this.isNeedPassword = z11;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setQuoteAssetId(int i11) {
        this.quoteAssetId = i11;
    }

    public void setRealLevel(int i11) {
        this.realLevel = i11;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTradeCount(String str) {
        this.tradeCount = str;
    }

    public String toString() {
        return "OtcAdTicket(price=" + getPrice() + ", token=" + getToken() + ", minTradeLimit=" + getMinTradeLimit() + ", maxTradeLimit=" + getMaxTradeLimit() + ", tradeCount=" + getTradeCount() + ", cryptoAssetId=" + getCryptoAssetId() + ", quoteAssetId=" + getQuoteAssetId() + ", cryptoAssetName=" + getCryptoAssetName() + ", isNeedPassword=" + isNeedPassword() + ", gmtSort=" + getGmtSort() + ", feeRatio=" + getFeeRatio() + ", realLevel=" + getRealLevel() + ", acceptOrder=" + getAcceptOrder() + ")";
    }
}
