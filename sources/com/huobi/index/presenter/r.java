package com.huobi.index.presenter;

import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class r implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexPresenter f73469b;

    public /* synthetic */ r(IndexPresenter indexPresenter) {
        this.f73469b = indexPresenter;
    }

    public final void call(Object obj) {
        this.f73469b.c2((Subscriber) obj);
    }
}
