package com.huobi.finance.presenter;

import com.hbg.lib.network.hbg.core.bean.BenefitListData;
import java.util.List;
import rx.functions.Func2;

public final /* synthetic */ class wa implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawPresenter f46166b;

    public /* synthetic */ wa(UnifyWithdrawPresenter unifyWithdrawPresenter) {
        this.f46166b = unifyWithdrawPresenter;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f46166b.q1((List) obj, (BenefitListData) obj2);
    }
}
