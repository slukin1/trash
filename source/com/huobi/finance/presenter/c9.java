package com.huobi.finance.presenter;

import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import rx.functions.Func1;

public final /* synthetic */ class c9 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferPresenter f45839b;

    public /* synthetic */ c9(UnifyTransferPresenter unifyTransferPresenter) {
        this.f45839b = unifyTransferPresenter;
    }

    public final Object call(Object obj) {
        return this.f45839b.E2((AccountBalanceInfoV5) obj);
    }
}
