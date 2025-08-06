package com.huobi.finance.ui;

import android.content.Context;
import android.view.View;

public final /* synthetic */ class j1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAndProfitView f47179b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f47180c;

    public /* synthetic */ j1(BalanceAndProfitView balanceAndProfitView, Context context) {
        this.f47179b = balanceAndProfitView;
        this.f47180c = context;
    }

    public final void onClick(View view) {
        this.f47179b.t(this.f47180c, view);
    }
}
