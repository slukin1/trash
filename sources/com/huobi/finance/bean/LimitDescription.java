package com.huobi.finance.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.finance.viewhandler.LimitDescriptionViewHandler;
import s9.a;

public class LimitDescription implements a {
    @SerializedName("daily-left")

    /* renamed from: b  reason: collision with root package name */
    public String f45364b;
    @SerializedName("daily-total")

    /* renamed from: c  reason: collision with root package name */
    public String f45365c;
    @SerializedName("single-total")

    /* renamed from: d  reason: collision with root package name */
    public String f45366d;

    public WithdrawQuotaDetails a() {
        WithdrawQuotaDetails withdrawQuotaDetails = new WithdrawQuotaDetails();
        withdrawQuotaDetails.singleAmount = this.f45366d;
        withdrawQuotaDetails.chain24hAmount = this.f45365c;
        withdrawQuotaDetails.chain24hLeft = this.f45364b;
        withdrawQuotaDetails.total24hAmount = "-1";
        return withdrawQuotaDetails;
    }

    public String getViewHandlerName() {
        return LimitDescriptionViewHandler.class.getName();
    }
}
