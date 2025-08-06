package com.huobi.account.ui;

import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import rx.functions.Func1;

public final /* synthetic */ class q3 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ q3 f41794b = new q3();

    public final Object call(Object obj) {
        return UserCenterRemoteDataSource.A().getKvStore("2", KvStore.QUICK_WITHDRAW);
    }
}
