package com.huobi.finance.presenter;

import com.hbg.lib.widgets.dialog.HBDialogFragment;
import rx.functions.Action1;

public final /* synthetic */ class rb implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UsdtExchangePresenter f46095b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f46096c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f46097d;

    public /* synthetic */ rb(UsdtExchangePresenter usdtExchangePresenter, HBDialogFragment hBDialogFragment, boolean z11) {
        this.f46095b = usdtExchangePresenter;
        this.f46096c = hBDialogFragment;
        this.f46097d = z11;
    }

    public final void call(Object obj) {
        this.f46095b.B0(this.f46096c, this.f46097d, (Throwable) obj);
    }
}
