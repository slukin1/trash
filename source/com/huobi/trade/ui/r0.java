package com.huobi.trade.ui;

import android.widget.EditText;

public final /* synthetic */ class r0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeBaseFragment f82699b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EditText f82700c;

    public /* synthetic */ r0(TradeBaseFragment tradeBaseFragment, EditText editText) {
        this.f82699b = tradeBaseFragment;
        this.f82700c = editText;
    }

    public final void run() {
        this.f82699b.Fi(this.f82700c);
    }
}
