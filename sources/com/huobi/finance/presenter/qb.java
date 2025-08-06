package com.huobi.finance.presenter;

import com.hbg.lib.widgets.dialog.HBDialogFragment;
import rx.functions.Action1;

public final /* synthetic */ class qb implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UsdtExchangePresenter f46079b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f46080c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f46081d;

    public /* synthetic */ qb(UsdtExchangePresenter usdtExchangePresenter, HBDialogFragment hBDialogFragment, boolean z11) {
        this.f46079b = usdtExchangePresenter;
        this.f46080c = hBDialogFragment;
        this.f46081d = z11;
    }

    public final void call(Object obj) {
        this.f46079b.z0(this.f46080c, this.f46081d, (Boolean) obj);
    }
}
