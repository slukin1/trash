package com.hbg.lib.network.pro.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SuperMarginSymbol implements Serializable {
    private static final long serialVersionUID = -7039075157169281059L;

    /* renamed from: id  reason: collision with root package name */
    private Long f70615id;
    private String key;
    @SerializedName("loan-multiple")
    private String loanMultiple;
    private String symbol;

    public SuperMarginSymbol(Long l11, String str, String str2, String str3) {
        this.f70615id = l11;
        this.symbol = str;
        this.key = str2;
        this.loanMultiple = str3;
    }

    public Long getId() {
        return this.f70615id;
    }

    public String getKey() {
        return this.key;
    }

    public String getLoanMultiple() {
        return this.loanMultiple;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setId(Long l11) {
        this.f70615id = l11;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLoanMultiple(String str) {
        this.loanMultiple = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public SuperMarginSymbol() {
    }
}
