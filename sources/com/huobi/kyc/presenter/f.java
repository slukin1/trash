package com.huobi.kyc.presenter;

import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycProBaseInformationPresenter f74842b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UserKycInfoNew f74843c;

    public /* synthetic */ f(KycProBaseInformationPresenter kycProBaseInformationPresenter, UserKycInfoNew userKycInfoNew) {
        this.f74842b = kycProBaseInformationPresenter;
        this.f74843c = userKycInfoNew;
    }

    public final Object call(Object obj) {
        return this.f74842b.W(this.f74843c, (UserInfoData) obj);
    }
}
