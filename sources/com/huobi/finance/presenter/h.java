package com.huobi.finance.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class h implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddVirtualAddressPresenter f45900b;

    public /* synthetic */ h(AddVirtualAddressPresenter addVirtualAddressPresenter) {
        this.f45900b = addVirtualAddressPresenter;
    }

    public final void call(Object obj) {
        this.f45900b.v0((APIStatusErrorException) obj);
    }
}
