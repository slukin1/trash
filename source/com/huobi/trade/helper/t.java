package com.huobi.trade.helper;

import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import rx.functions.Func1;

public final /* synthetic */ class t implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f82078b;

    public /* synthetic */ t(String str) {
        this.f82078b = str;
    }

    public final Object call(Object obj) {
        return UserCenterRemoteDataSource.A().requestLicenseState(this.f82078b, false);
    }
}
