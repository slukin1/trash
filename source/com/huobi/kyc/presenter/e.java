package com.huobi.kyc.presenter;

import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycProBaseInformationPresenter f74841b;

    public /* synthetic */ e(KycProBaseInformationPresenter kycProBaseInformationPresenter) {
        this.f74841b = kycProBaseInformationPresenter;
    }

    public final Object call(Object obj) {
        return this.f74841b.X((UserKycInfoNew) obj);
    }
}
