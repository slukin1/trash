package com.huobi.account.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AccountQueryData implements Serializable {
    private static final long serialVersionUID = 6004553697632499282L;

    /* renamed from: id  reason: collision with root package name */
    private long f40977id;
    private String state;
    private String subtype;
    private String symbol;
    private String type;
    @SerializedName("user-id")
    private int userId;

    public long getId() {
        return this.f40977id;
    }

    public String getState() {
        return this.state;
    }

    public String getSubtype() {
        return this.subtype;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getType() {
        return this.type;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setId(long j11) {
        this.f40977id = j11;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setSubtype(String str) {
        this.subtype = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUserId(int i11) {
        this.userId = i11;
    }
}
