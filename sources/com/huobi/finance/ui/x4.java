package com.huobi.finance.ui;

public final /* synthetic */ class x4 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencyFromCCDetailOrderActivity f47393b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f47394c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f47395d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f47396e;

    public /* synthetic */ x4(CurrencyFromCCDetailOrderActivity currencyFromCCDetailOrderActivity, String str, String str2, String str3) {
        this.f47393b = currencyFromCCDetailOrderActivity;
        this.f47394c = str;
        this.f47395d = str2;
        this.f47396e = str3;
    }

    public final void run() {
        this.f47393b.Pg(this.f47394c, this.f47395d, this.f47396e);
    }
}
