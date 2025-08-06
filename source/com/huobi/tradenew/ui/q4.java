package com.huobi.tradenew.ui;

import android.view.View;

public final /* synthetic */ class q4 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotFragment f83512b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f83513c;

    public /* synthetic */ q4(TradeVerticalSpotFragment tradeVerticalSpotFragment, boolean z11) {
        this.f83512b = tradeVerticalSpotFragment;
        this.f83513c = z11;
    }

    public final void onClick(View view) {
        this.f83512b.tm(this.f83513c, view);
    }
}
