package com.huobi.finance.presenter;

import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class u9 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ u9 f46137b = new u9();

    public final Object call(Object obj) {
        return UserCenterRemoteDataSource.A().m0(((LoginInfoData) obj).getTicket()).compose(p.a0());
    }
}
