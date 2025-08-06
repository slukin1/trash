package com.huobi.finance.presenter;

import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import rx.functions.Action1;

public final /* synthetic */ class fb implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawPresenter f45884b;

    public /* synthetic */ fb(UnifyWithdrawPresenter unifyWithdrawPresenter) {
        this.f45884b = unifyWithdrawPresenter;
    }

    public final void call(Object obj) {
        this.f45884b.z1((TradeRiskReminder) obj);
    }
}
