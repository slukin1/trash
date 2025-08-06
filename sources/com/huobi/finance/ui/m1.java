package com.huobi.finance.ui;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import rx.functions.Action1;

public final /* synthetic */ class m1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAndProfitView f47230b;

    public /* synthetic */ m1(BalanceAndProfitView balanceAndProfitView) {
        this.f47230b = balanceAndProfitView;
    }

    public final void call(Object obj) {
        this.f47230b.l((BalanceProfitLossData) obj);
    }
}
