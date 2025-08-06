package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class HbgSymbolPrice implements Serializable {
    private String baseCurrency;
    private String baseCurrencyPrice;
    private String currency;
    private int flag;
    private String flagURL;
    private List<String> klineList;
    private String label;
    private String open;
    private String price;
    private String quoteCurrency;
    private String quotePrice;
    private String symbol;
    private int symbolType;
    private String upDown;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof HbgSymbolPrice;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HbgSymbolPrice)) {
            return false;
        }
        HbgSymbolPrice hbgSymbolPrice = (HbgSymbolPrice) obj;
        if (!hbgSymbolPrice.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = hbgSymbolPrice.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = hbgSymbolPrice.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = hbgSymbolPrice.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String upDown2 = getUpDown();
        String upDown3 = hbgSymbolPrice.getUpDown();
        if (upDown2 != null ? !upDown2.equals(upDown3) : upDown3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = hbgSymbolPrice.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String quotePrice2 = getQuotePrice();
        String quotePrice3 = hbgSymbolPrice.getQuotePrice();
        if (quotePrice2 != null ? !quotePrice2.equals(quotePrice3) : quotePrice3 != null) {
            return false;
        }
        String open2 = getOpen();
        String open3 = hbgSymbolPrice.getOpen();
        if (open2 != null ? !open2.equals(open3) : open3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = hbgSymbolPrice.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = hbgSymbolPrice.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        String baseCurrencyPrice2 = getBaseCurrencyPrice();
        String baseCurrencyPrice3 = hbgSymbolPrice.getBaseCurrencyPrice();
        if (baseCurrencyPrice2 != null ? !baseCurrencyPrice2.equals(baseCurrencyPrice3) : baseCurrencyPrice3 != null) {
            return false;
        }
        List<String> klineList2 = getKlineList();
        List<String> klineList3 = hbgSymbolPrice.getKlineList();
        if (klineList2 != null ? !klineList2.equals(klineList3) : klineList3 != null) {
            return false;
        }
        if (getFlag() != hbgSymbolPrice.getFlag()) {
            return false;
        }
        String flagURL2 = getFlagURL();
        String flagURL3 = hbgSymbolPrice.getFlagURL();
        if (flagURL2 != null ? !flagURL2.equals(flagURL3) : flagURL3 != null) {
            return false;
        }
        String label2 = getLabel();
        String label3 = hbgSymbolPrice.getLabel();
        if (label2 != null ? label2.equals(label3) : label3 == null) {
            return getSymbolType() == hbgSymbolPrice.getSymbolType();
        }
        return false;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getBaseCurrencyPrice() {
        return this.baseCurrencyPrice;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getFlagURL() {
        return this.flagURL;
    }

    public List<String> getKlineList() {
        return this.klineList;
    }

    public String getLabel() {
        return this.label;
    }

    public String getOpen() {
        return this.open;
    }

    public String getPrice() {
        return this.price;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getQuotePrice() {
        return this.quotePrice;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getSymbolType() {
        return this.symbolType;
    }

    public String getUpDown() {
        return this.upDown;
    }

    public String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String baseCurrency2 = getBaseCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode3 = (hashCode2 * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String upDown2 = getUpDown();
        int hashCode4 = (hashCode3 * 59) + (upDown2 == null ? 43 : upDown2.hashCode());
        String price2 = getPrice();
        int hashCode5 = (hashCode4 * 59) + (price2 == null ? 43 : price2.hashCode());
        String quotePrice2 = getQuotePrice();
        int hashCode6 = (hashCode5 * 59) + (quotePrice2 == null ? 43 : quotePrice2.hashCode());
        String open2 = getOpen();
        int hashCode7 = (hashCode6 * 59) + (open2 == null ? 43 : open2.hashCode());
        String currency2 = getCurrency();
        int hashCode8 = (hashCode7 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String volume2 = getVolume();
        int hashCode9 = (hashCode8 * 59) + (volume2 == null ? 43 : volume2.hashCode());
        String baseCurrencyPrice2 = getBaseCurrencyPrice();
        int hashCode10 = (hashCode9 * 59) + (baseCurrencyPrice2 == null ? 43 : baseCurrencyPrice2.hashCode());
        List<String> klineList2 = getKlineList();
        int hashCode11 = (((hashCode10 * 59) + (klineList2 == null ? 43 : klineList2.hashCode())) * 59) + getFlag();
        String flagURL2 = getFlagURL();
        int hashCode12 = (hashCode11 * 59) + (flagURL2 == null ? 43 : flagURL2.hashCode());
        String label2 = getLabel();
        int i12 = hashCode12 * 59;
        if (label2 != null) {
            i11 = label2.hashCode();
        }
        return ((i12 + i11) * 59) + getSymbolType();
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setBaseCurrencyPrice(String str) {
        this.baseCurrencyPrice = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setFlag(int i11) {
        this.flag = i11;
    }

    public void setFlagURL(String str) {
        this.flagURL = str;
    }

    public void setKlineList(List<String> list) {
        this.klineList = list;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setOpen(String str) {
        this.open = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setQuotePrice(String str) {
        this.quotePrice = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setSymbolType(int i11) {
        this.symbolType = i11;
    }

    public void setUpDown(String str) {
        this.upDown = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "HbgSymbolPrice(symbol=" + getSymbol() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", upDown=" + getUpDown() + ", price=" + getPrice() + ", quotePrice=" + getQuotePrice() + ", open=" + getOpen() + ", currency=" + getCurrency() + ", volume=" + getVolume() + ", baseCurrencyPrice=" + getBaseCurrencyPrice() + ", klineList=" + getKlineList() + ", flag=" + getFlag() + ", flagURL=" + getFlagURL() + ", label=" + getLabel() + ", symbolType=" + getSymbolType() + ")";
    }
}
