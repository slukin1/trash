package com.huobi.finance.presenter;

import com.huobi.login.usercenter.data.source.bean.ProUserToken;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class q9 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observable f46077b;

    public /* synthetic */ q9(Observable observable) {
        this.f46077b = observable;
    }

    public final Object call(Object obj) {
        return UnifyTransferPresenter.X2(this.f46077b, (ProUserToken) obj);
    }
}
