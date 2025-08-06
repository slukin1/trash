package com.huobi.finance.presenter;

import com.huobi.finance.bean.CurrencyFromCCFinanceRecordItem;
import rx.functions.Func1;

public final /* synthetic */ class p3 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ p3 f46053b = new p3();

    public final Object call(Object obj) {
        return Long.valueOf(((CurrencyFromCCFinanceRecordItem) obj).getInfo().getId());
    }
}
