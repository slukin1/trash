package com.huobi.order.ui;

import android.view.View;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeOrderHistoryDetailActivity f78241b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f78242c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f78243d;

    public /* synthetic */ s(TradeOrderHistoryDetailActivity tradeOrderHistoryDetailActivity, String str, boolean z11) {
        this.f78241b = tradeOrderHistoryDetailActivity;
        this.f78242c = str;
        this.f78243d = z11;
    }

    public final void onClick(View view) {
        this.f78241b.Pg(this.f78242c, this.f78243d, view);
    }
}
