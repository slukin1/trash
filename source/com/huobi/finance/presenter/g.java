package com.huobi.finance.presenter;

import com.hbg.lib.network.pro.core.bean.WithdrawRiskInfo;
import rx.functions.Action1;

public final /* synthetic */ class g implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddVirtualAddressPresenter f45885b;

    public /* synthetic */ g(AddVirtualAddressPresenter addVirtualAddressPresenter) {
        this.f45885b = addVirtualAddressPresenter;
    }

    public final void call(Object obj) {
        this.f45885b.u0((WithdrawRiskInfo) obj);
    }
}
