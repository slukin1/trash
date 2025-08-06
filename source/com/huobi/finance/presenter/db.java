package com.huobi.finance.presenter;

import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import rx.functions.Action1;

public final /* synthetic */ class db implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawPresenter f45856b;

    public /* synthetic */ db(UnifyWithdrawPresenter unifyWithdrawPresenter) {
        this.f45856b = unifyWithdrawPresenter;
    }

    public final void call(Object obj) {
        this.f45856b.w1((SecurityStrategySet) obj);
    }
}
