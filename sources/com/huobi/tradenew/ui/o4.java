package com.huobi.tradenew.ui;

import android.view.View;

public final /* synthetic */ class o4 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotFragment f83497b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f83498c;

    public /* synthetic */ o4(TradeVerticalSpotFragment tradeVerticalSpotFragment, String str) {
        this.f83497b = tradeVerticalSpotFragment;
        this.f83498c = str;
    }

    public final void onClick(View view) {
        this.f83497b.Dm(this.f83498c, view);
    }
}
