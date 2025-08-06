package com.huobi.tradenew.ui;

import android.widget.CompoundButton;

public final /* synthetic */ class z1 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeOrderConfirmFragment f83564b;

    public /* synthetic */ z1(TradeOrderConfirmFragment tradeOrderConfirmFragment) {
        this.f83564b = tradeOrderConfirmFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f83564b.vh(compoundButton, z11);
    }
}
