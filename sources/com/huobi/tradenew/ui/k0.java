package com.huobi.tradenew.ui;

import android.widget.EditText;

public final /* synthetic */ class k0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeBaseFragment f83432b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EditText f83433c;

    public /* synthetic */ k0(TradeBaseFragment tradeBaseFragment, EditText editText) {
        this.f83432b = tradeBaseFragment;
        this.f83433c = editText;
    }

    public final void run() {
        this.f83432b.Mi(this.f83433c);
    }
}
