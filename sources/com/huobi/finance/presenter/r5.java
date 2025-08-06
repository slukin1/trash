package com.huobi.finance.presenter;

import com.huobi.finance.bean.OtcFinanceResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class r5 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ r5 f46088b = new r5();

    public final Object call(Object obj) {
        return Observable.create(new n5((OtcFinanceResponse) obj));
    }
}
