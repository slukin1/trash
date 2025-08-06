package com.huobi.finance.ui;

import com.huobi.finance.bean.FinanceRecordItem;

public final /* synthetic */ class k4 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrencyDetailOrderActivity f47199b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FinanceRecordItem f47200c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f47201d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f47202e;

    public /* synthetic */ k4(CurrencyDetailOrderActivity currencyDetailOrderActivity, FinanceRecordItem financeRecordItem, String str, String str2) {
        this.f47199b = currencyDetailOrderActivity;
        this.f47200c = financeRecordItem;
        this.f47201d = str;
        this.f47202e = str2;
    }

    public final void run() {
        this.f47199b.th(this.f47200c, this.f47201d, this.f47202e);
    }
}
