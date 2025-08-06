package com.huobi.finance.presenter;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class p7 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyRiskPresenter f46057b;

    public /* synthetic */ p7(UnifyRiskPresenter unifyRiskPresenter) {
        this.f46057b = unifyRiskPresenter;
    }

    public final void call(Object obj) {
        this.f46057b.j0((APIStatusErrorException) obj);
    }
}
