package com.huobi.finance.presenter;

import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import rx.functions.Action1;

public final /* synthetic */ class eb implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawPresenter f45870b;

    public /* synthetic */ eb(UnifyWithdrawPresenter unifyWithdrawPresenter) {
        this.f45870b = unifyWithdrawPresenter;
    }

    public final void call(Object obj) {
        this.f45870b.o1((TradeRiskReminder) obj);
    }
}
