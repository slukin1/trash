package com.huobi.trade.ui;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class u4 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotFragment f82721a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f82722b;

    public /* synthetic */ u4(TradeVerticalSpotFragment tradeVerticalSpotFragment, String str) {
        this.f82721a = tradeVerticalSpotFragment;
        this.f82722b = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f82721a.wm(this.f82722b, hBDialogFragment);
    }
}
