package com.huobi.finance.presenter;

import com.hbg.lib.widgets.dialog.HBDialogFragment;
import rx.functions.Action1;

public final /* synthetic */ class ob implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UsdtExchangePresenter f46047b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f46048c;

    public /* synthetic */ ob(UsdtExchangePresenter usdtExchangePresenter, HBDialogFragment hBDialogFragment) {
        this.f46047b = usdtExchangePresenter;
        this.f46048c = hBDialogFragment;
    }

    public final void call(Object obj) {
        this.f46047b.C0(this.f46048c, (Long) obj);
    }
}
