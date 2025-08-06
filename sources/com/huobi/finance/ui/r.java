package com.huobi.finance.ui;

import com.huobi.finance.bean.BalanceDetailInfo;
import rx.functions.Action1;

public final /* synthetic */ class r implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbsFiatFromCoinActivity f47300b;

    public /* synthetic */ r(AbsFiatFromCoinActivity absFiatFromCoinActivity) {
        this.f47300b = absFiatFromCoinActivity;
    }

    public final void call(Object obj) {
        this.f47300b.aj((BalanceDetailInfo) obj);
    }
}
