package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class C2CSymbolBean implements Serializable {
    private static final long serialVersionUID = -1501552649552056241L;
    private String baseCurrency;
    private String baseCurrencyBorrowMaxAmount;
    private String baseCurrencyBorrowMinAmount;
    private boolean enable;
    private String loanMultiple;
    private String quoteCurrency;
    private String quoteCurrencyBorrowMaxAmount;
    private String quoteCurrencyBorrowMinAmount;
    private String symbol;

    public C2CSymbolBean(String str, String str2, String str3, boolean z11, String str4, String str5, String str6, String str7, String str8) {
        this.symbol = str;
        this.baseCurrency = str2;
        this.quoteCurrency = str3;
        this.enable = z11;
        this.loanMultiple = str4;
        this.quoteCurrencyBorrowMinAmount = str5;
        this.quoteCurrencyBorrowMaxAmount = str6;
        this.baseCurrencyBorrowMinAmount = str7;
        this.baseCurrencyBorrowMaxAmount = str8;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getBaseCurrencyBorrowMaxAmount() {
        return this.baseCurrencyBorrowMaxAmount;
    }

    public String getBaseCurrencyBorrowMinAmount() {
        return this.baseCurrencyBorrowMinAmount;
    }

    public boolean getEnable() {
        return this.enable;
    }

    public String getLoanMultiple() {
        return this.loanMultiple;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getQuoteCurrencyBorrowMaxAmount() {
        return this.quoteCurrencyBorrowMaxAmount;
    }

    public String getQuoteCurrencyBorrowMinAmount() {
        return this.quoteCurrencyBorrowMinAmount;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setBaseCurrencyBorrowMaxAmount(String str) {
        this.baseCurrencyBorrowMaxAmount = str;
    }

    public void setBaseCurrencyBorrowMinAmount(String str) {
        this.baseCurrencyBorrowMinAmount = str;
    }

    public void setEnable(boolean z11) {
        this.enable = z11;
    }

    public void setLoanMultiple(String str) {
        this.loanMultiple = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setQuoteCurrencyBorrowMaxAmount(String str) {
        this.quoteCurrencyBorrowMaxAmount = str;
    }

    public void setQuoteCurrencyBorrowMinAmount(String str) {
        this.quoteCurrencyBorrowMinAmount = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public C2CSymbolBean() {
    }
}
