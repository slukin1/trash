package com.huobi.order.ui;

import android.view.View;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeOrderHistoryDetailActivity f78244b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f78245c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f78246d;

    public /* synthetic */ t(TradeOrderHistoryDetailActivity tradeOrderHistoryDetailActivity, String str, boolean z11) {
        this.f78244b = tradeOrderHistoryDetailActivity;
        this.f78245c = str;
        this.f78246d = z11;
    }

    public final void onClick(View view) {
        this.f78244b.Og(this.f78245c, this.f78246d, view);
    }
}
