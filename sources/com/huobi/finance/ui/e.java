package com.huobi.finance.ui;

import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f47095b;

    public /* synthetic */ e(String str) {
        this.f47095b = str;
    }

    public final Object call(Object obj) {
        return ((BalanceQueryData) obj).getAvailable(this.f47095b, "trade", "0");
    }
}
