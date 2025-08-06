package com.huobi.index.presenter;

import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import rx.functions.Func1;

public final /* synthetic */ class u implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexPresenter f73472b;

    public /* synthetic */ u(IndexPresenter indexPresenter) {
        this.f73472b = indexPresenter;
    }

    public final Object call(Object obj) {
        return this.f73472b.b2((UserKycInfoNew) obj);
    }
}
