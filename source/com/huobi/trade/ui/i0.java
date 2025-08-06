package com.huobi.trade.ui;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class i0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TradeBaseFragment f82644a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f82645b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f82646c;

    public /* synthetic */ i0(TradeBaseFragment tradeBaseFragment, String str, int i11) {
        this.f82644a = tradeBaseFragment;
        this.f82645b = str;
        this.f82646c = i11;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f82644a.Vi(this.f82645b, this.f82646c, hBDialogFragment);
    }
}
