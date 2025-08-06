package com.huobi.finance.bean;

import com.google.gson.annotations.SerializedName;

public class PreWithdrawData {
    @SerializedName("limit-amount")

    /* renamed from: a  reason: collision with root package name */
    public String f45382a;
    @SerializedName("default-fee")

    /* renamed from: b  reason: collision with root package name */
    public String f45383b;
    @SerializedName("max-fee")

    /* renamed from: c  reason: collision with root package name */
    public String f45384c;
    @SerializedName("min-fee")

    /* renamed from: d  reason: collision with root package name */
    public String f45385d;
    @SerializedName("limit-details")

    /* renamed from: e  reason: collision with root package name */
    public LimitDescription f45386e;
    @SerializedName("fee-type")

    /* renamed from: f  reason: collision with root package name */
    public String f45387f;
    @SerializedName("dynamic-switch")

    /* renamed from: g  reason: collision with root package name */
    public Integer f45388g;
    @SerializedName("withdraw-quota-details")

    /* renamed from: h  reason: collision with root package name */
    public WithdrawQuotaDetails f45389h;

    public String a() {
        return this.f45383b;
    }

    public Integer b() {
        return this.f45388g;
    }

    public String c() {
        return this.f45387f;
    }

    public String d() {
        return this.f45382a;
    }

    public LimitDescription e() {
        return this.f45386e;
    }

    public String f() {
        return this.f45384c;
    }

    public String g() {
        return this.f45385d;
    }

    public WithdrawQuotaDetails h() {
        return this.f45389h;
    }
}
