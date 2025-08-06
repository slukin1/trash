package com.hbg.lib.network.hbg.core.bean;

public class CurrencyAsset {
    private String baseBalance;
    private String baseCurrency;
    private String baseMaxBalance;
    private String quoteBalance;
    private String quoteCurrency;
    private String quoteMaxBalance;

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencyAsset;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyAsset)) {
            return false;
        }
        CurrencyAsset currencyAsset = (CurrencyAsset) obj;
        if (!currencyAsset.canEqual(this)) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = currencyAsset.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = currencyAsset.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String baseBalance2 = getBaseBalance();
        String baseBalance3 = currencyAsset.getBaseBalance();
        if (baseBalance2 != null ? !baseBalance2.equals(baseBalance3) : baseBalance3 != null) {
            return false;
        }
        String baseMaxBalance2 = getBaseMaxBalance();
        String baseMaxBalance3 = currencyAsset.getBaseMaxBalance();
        if (baseMaxBalance2 != null ? !baseMaxBalance2.equals(baseMaxBalance3) : baseMaxBalance3 != null) {
            return false;
        }
        String quoteBalance2 = getQuoteBalance();
        String quoteBalance3 = currencyAsset.getQuoteBalance();
        if (quoteBalance2 != null ? !quoteBalance2.equals(quoteBalance3) : quoteBalance3 != null) {
            return false;
        }
        String quoteMaxBalance2 = getQuoteMaxBalance();
        String quoteMaxBalance3 = currencyAsset.getQuoteMaxBalance();
        return quoteMaxBalance2 != null ? quoteMaxBalance2.equals(quoteMaxBalance3) : quoteMaxBalance3 == null;
    }

    public String getBaseBalance() {
        return this.baseBalance;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getBaseMaxBalance() {
        return this.baseMaxBalance;
    }

    public String getQuoteBalance() {
        return this.quoteBalance;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getQuoteMaxBalance() {
        return this.quoteMaxBalance;
    }

    public int hashCode() {
        String baseCurrency2 = getBaseCurrency();
        int i11 = 43;
        int hashCode = baseCurrency2 == null ? 43 : baseCurrency2.hashCode();
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String baseBalance2 = getBaseBalance();
        int hashCode3 = (hashCode2 * 59) + (baseBalance2 == null ? 43 : baseBalance2.hashCode());
        String baseMaxBalance2 = getBaseMaxBalance();
        int hashCode4 = (hashCode3 * 59) + (baseMaxBalance2 == null ? 43 : baseMaxBalance2.hashCode());
        String quoteBalance2 = getQuoteBalance();
        int hashCode5 = (hashCode4 * 59) + (quoteBalance2 == null ? 43 : quoteBalance2.hashCode());
        String quoteMaxBalance2 = getQuoteMaxBalance();
        int i12 = hashCode5 * 59;
        if (quoteMaxBalance2 != null) {
            i11 = quoteMaxBalance2.hashCode();
        }
        return i12 + i11;
    }

    public void setBaseBalance(String str) {
        this.baseBalance = str;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setBaseMaxBalance(String str) {
        this.baseMaxBalance = str;
    }

    public void setQuoteBalance(String str) {
        this.quoteBalance = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setQuoteMaxBalance(String str) {
        this.quoteMaxBalance = str;
    }

    public String toString() {
        return "CurrencyAsset(baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", baseBalance=" + getBaseBalance() + ", baseMaxBalance=" + getBaseMaxBalance() + ", quoteBalance=" + getQuoteBalance() + ", quoteMaxBalance=" + getQuoteMaxBalance() + ")";
    }
}
