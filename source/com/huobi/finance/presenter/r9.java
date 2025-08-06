package com.huobi.finance.presenter;

import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class r9 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observable f46093b;

    public /* synthetic */ r9(Observable observable) {
        this.f46093b = observable;
    }

    public final Object call(Object obj) {
        return UnifyTransferPresenter.Y2(this.f46093b, (Throwable) obj);
    }
}
