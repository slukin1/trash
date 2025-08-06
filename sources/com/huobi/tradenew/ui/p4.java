package com.huobi.tradenew.ui;

import android.view.View;

public final /* synthetic */ class p4 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotFragment f83504b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f83505c;

    public /* synthetic */ p4(TradeVerticalSpotFragment tradeVerticalSpotFragment, String str) {
        this.f83504b = tradeVerticalSpotFragment;
        this.f83505c = str;
    }

    public final void onClick(View view) {
        this.f83504b.Cm(this.f83505c, view);
    }
}
