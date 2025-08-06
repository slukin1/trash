package com.huobi.finance.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import rx.functions.Action1;

public final /* synthetic */ class pb implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UsdtExchangePresenter f46063b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f46064c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f46065d;

    public /* synthetic */ pb(UsdtExchangePresenter usdtExchangePresenter, HBDialogFragment hBDialogFragment, boolean z11) {
        this.f46063b = usdtExchangePresenter;
        this.f46064c = hBDialogFragment;
        this.f46065d = z11;
    }

    public final void call(Object obj) {
        this.f46063b.A0(this.f46064c, this.f46065d, (APIStatusErrorException) obj);
    }
}
