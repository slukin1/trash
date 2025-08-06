package com.huobi.finance.ui;

import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Func1;

public final /* synthetic */ class u implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f47342b;

    public /* synthetic */ u(String str) {
        this.f47342b = str;
    }

    public final Object call(Object obj) {
        return ((BalanceQueryData) obj).getAvailableBalance(this.f47342b);
    }
}
