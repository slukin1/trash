package com.huobi.kyc.presenter;

import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class d implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserKycInfoNew f74840b;

    public /* synthetic */ d(UserKycInfoNew userKycInfoNew) {
        this.f74840b = userKycInfoNew;
    }

    public final Object call(Object obj) {
        return KycProBaseInformationPresenter.Y(this.f74840b, (List) obj);
    }
}
