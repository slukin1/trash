package com.huobi.finance.ui;

public final /* synthetic */ class c7 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcCurrencyDetailOrderActivity f47071b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f47072c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f47073d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f47074e;

    public /* synthetic */ c7(OtcCurrencyDetailOrderActivity otcCurrencyDetailOrderActivity, String str, String str2, String str3) {
        this.f47071b = otcCurrencyDetailOrderActivity;
        this.f47072c = str;
        this.f47073d = str2;
        this.f47074e = str3;
    }

    public final void run() {
        this.f47071b.gg(this.f47072c, this.f47073d, this.f47074e);
    }
}
