package com.huobi.c2c.bean;

import java.io.Serializable;
import java.util.List;

public class FlutterC2CBorrowConfig implements Serializable {
    private String baseCurrency;
    private String baseCurrencyBorrowMinAmount;
    private String baseCurrencyDisplayName;
    private List<Integer> baseCurrencyTerms;
    private String c2cSocketUrl;
    private boolean loanEnabled;
    private String quoteCurrency;
    private String quoteCurrencyBorrowMinAmount;
    private String quoteCurrencyDisplayName;
    private List<Integer> quoteCurrencyTerms;

    public boolean canEqual(Object obj) {
        return obj instanceof FlutterC2CBorrowConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlutterC2CBorrowConfig)) {
            return false;
        }
        FlutterC2CBorrowConfig flutterC2CBorrowConfig = (FlutterC2CBorrowConfig) obj;
        if (!flutterC2CBorrowConfig.canEqual(this)) {
            return false;
        }
        String c2cSocketUrl2 = getC2cSocketUrl();
        String c2cSocketUrl3 = flutterC2CBorrowConfig.getC2cSocketUrl();
        if (c2cSocketUrl2 != null ? !c2cSocketUrl2.equals(c2cSocketUrl3) : c2cSocketUrl3 != null) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = flutterC2CBorrowConfig.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = flutterC2CBorrowConfig.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String baseCurrencyDisplayName2 = getBaseCurrencyDisplayName();
        String baseCurrencyDisplayName3 = flutterC2CBorrowConfig.getBaseCurrencyDisplayName();
        if (baseCurrencyDisplayName2 != null ? !baseCurrencyDisplayName2.equals(baseCurrencyDisplayName3) : baseCurrencyDisplayName3 != null) {
            return false;
        }
        String quoteCurrencyDisplayName2 = getQuoteCurrencyDisplayName();
        String quoteCurrencyDisplayName3 = flutterC2CBorrowConfig.getQuoteCurrencyDisplayName();
        if (quoteCurrencyDisplayName2 != null ? !quoteCurrencyDisplayName2.equals(quoteCurrencyDisplayName3) : quoteCurrencyDisplayName3 != null) {
            return false;
        }
        List<Integer> baseCurrencyTerms2 = getBaseCurrencyTerms();
        List<Integer> baseCurrencyTerms3 = flutterC2CBorrowConfig.getBaseCurrencyTerms();
        if (baseCurrencyTerms2 != null ? !baseCurrencyTerms2.equals(baseCurrencyTerms3) : baseCurrencyTerms3 != null) {
            return false;
        }
        List<Integer> quoteCurrencyTerms2 = getQuoteCurrencyTerms();
        List<Integer> quoteCurrencyTerms3 = flutterC2CBorrowConfig.getQuoteCurrencyTerms();
        if (quoteCurrencyTerms2 != null ? !quoteCurrencyTerms2.equals(quoteCurrencyTerms3) : quoteCurrencyTerms3 != null) {
            return false;
        }
        String baseCurrencyBorrowMinAmount2 = getBaseCurrencyBorrowMinAmount();
        String baseCurrencyBorrowMinAmount3 = flutterC2CBorrowConfig.getBaseCurrencyBorrowMinAmount();
        if (baseCurrencyBorrowMinAmount2 != null ? !baseCurrencyBorrowMinAmount2.equals(baseCurrencyBorrowMinAmount3) : baseCurrencyBorrowMinAmount3 != null) {
            return false;
        }
        String quoteCurrencyBorrowMinAmount2 = getQuoteCurrencyBorrowMinAmount();
        String quoteCurrencyBorrowMinAmount3 = flutterC2CBorrowConfig.getQuoteCurrencyBorrowMinAmount();
        if (quoteCurrencyBorrowMinAmount2 != null ? quoteCurrencyBorrowMinAmount2.equals(quoteCurrencyBorrowMinAmount3) : quoteCurrencyBorrowMinAmount3 == null) {
            return isLoanEnabled() == flutterC2CBorrowConfig.isLoanEnabled();
        }
        return false;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getBaseCurrencyBorrowMinAmount() {
        return this.baseCurrencyBorrowMinAmount;
    }

    public String getBaseCurrencyDisplayName() {
        return this.baseCurrencyDisplayName;
    }

    public List<Integer> getBaseCurrencyTerms() {
        return this.baseCurrencyTerms;
    }

    public String getC2cSocketUrl() {
        return this.c2cSocketUrl;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getQuoteCurrencyBorrowMinAmount() {
        return this.quoteCurrencyBorrowMinAmount;
    }

    public String getQuoteCurrencyDisplayName() {
        return this.quoteCurrencyDisplayName;
    }

    public List<Integer> getQuoteCurrencyTerms() {
        return this.quoteCurrencyTerms;
    }

    public int hashCode() {
        String c2cSocketUrl2 = getC2cSocketUrl();
        int i11 = 43;
        int hashCode = c2cSocketUrl2 == null ? 43 : c2cSocketUrl2.hashCode();
        String baseCurrency2 = getBaseCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode3 = (hashCode2 * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String baseCurrencyDisplayName2 = getBaseCurrencyDisplayName();
        int hashCode4 = (hashCode3 * 59) + (baseCurrencyDisplayName2 == null ? 43 : baseCurrencyDisplayName2.hashCode());
        String quoteCurrencyDisplayName2 = getQuoteCurrencyDisplayName();
        int hashCode5 = (hashCode4 * 59) + (quoteCurrencyDisplayName2 == null ? 43 : quoteCurrencyDisplayName2.hashCode());
        List<Integer> baseCurrencyTerms2 = getBaseCurrencyTerms();
        int hashCode6 = (hashCode5 * 59) + (baseCurrencyTerms2 == null ? 43 : baseCurrencyTerms2.hashCode());
        List<Integer> quoteCurrencyTerms2 = getQuoteCurrencyTerms();
        int hashCode7 = (hashCode6 * 59) + (quoteCurrencyTerms2 == null ? 43 : quoteCurrencyTerms2.hashCode());
        String baseCurrencyBorrowMinAmount2 = getBaseCurrencyBorrowMinAmount();
        int hashCode8 = (hashCode7 * 59) + (baseCurrencyBorrowMinAmount2 == null ? 43 : baseCurrencyBorrowMinAmount2.hashCode());
        String quoteCurrencyBorrowMinAmount2 = getQuoteCurrencyBorrowMinAmount();
        int i12 = hashCode8 * 59;
        if (quoteCurrencyBorrowMinAmount2 != null) {
            i11 = quoteCurrencyBorrowMinAmount2.hashCode();
        }
        return ((i12 + i11) * 59) + (isLoanEnabled() ? 79 : 97);
    }

    public boolean isLoanEnabled() {
        return this.loanEnabled;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setBaseCurrencyBorrowMinAmount(String str) {
        this.baseCurrencyBorrowMinAmount = str;
    }

    public void setBaseCurrencyDisplayName(String str) {
        this.baseCurrencyDisplayName = str;
    }

    public void setBaseCurrencyTerms(List<Integer> list) {
        this.baseCurrencyTerms = list;
    }

    public void setC2cSocketUrl(String str) {
        this.c2cSocketUrl = str;
    }

    public void setLoanEnabled(boolean z11) {
        this.loanEnabled = z11;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setQuoteCurrencyBorrowMinAmount(String str) {
        this.quoteCurrencyBorrowMinAmount = str;
    }

    public void setQuoteCurrencyDisplayName(String str) {
        this.quoteCurrencyDisplayName = str;
    }

    public void setQuoteCurrencyTerms(List<Integer> list) {
        this.quoteCurrencyTerms = list;
    }

    public String toString() {
        return "FlutterC2CBorrowConfig(c2cSocketUrl=" + getC2cSocketUrl() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", baseCurrencyDisplayName=" + getBaseCurrencyDisplayName() + ", quoteCurrencyDisplayName=" + getQuoteCurrencyDisplayName() + ", baseCurrencyTerms=" + getBaseCurrencyTerms() + ", quoteCurrencyTerms=" + getQuoteCurrencyTerms() + ", baseCurrencyBorrowMinAmount=" + getBaseCurrencyBorrowMinAmount() + ", quoteCurrencyBorrowMinAmount=" + getQuoteCurrencyBorrowMinAmount() + ", loanEnabled=" + isLoanEnabled() + ")";
    }
}
