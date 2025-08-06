package com.huobi.kyc.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycCountryAreaSelectPresenter f74837b;

    public /* synthetic */ a(KycCountryAreaSelectPresenter kycCountryAreaSelectPresenter) {
        this.f74837b = kycCountryAreaSelectPresenter;
    }

    public final void call(Object obj) {
        this.f74837b.U((APIStatusErrorException) obj);
    }
}
