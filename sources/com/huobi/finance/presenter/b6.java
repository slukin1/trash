package com.huobi.finance.presenter;

import com.huobi.finance.bean.OtcFinanceResponse;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class b6 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ b6 f45817b = new b6();

    public final Object call(Object obj) {
        return Observable.create(new y5((OtcFinanceResponse) obj));
    }
}
