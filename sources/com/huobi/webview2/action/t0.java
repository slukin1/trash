package com.huobi.webview2.action;

import com.hbg.lib.core.util.RxJavaHelper;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import rx.functions.Func1;
import tq.p;

public final /* synthetic */ class t0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ t0 f20876b = new t0();

    public final Object call(Object obj) {
        return UserCenterRemoteDataSource.A().m0(((LoginInfoData) obj).getTicket()).compose(p.a0()).compose(RxJavaHelper.s());
    }
}
