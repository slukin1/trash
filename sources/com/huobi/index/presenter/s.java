package com.huobi.index.presenter;

import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class s implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexPresenter f73470b;

    public /* synthetic */ s(IndexPresenter indexPresenter) {
        this.f73470b = indexPresenter;
    }

    public final void call(Object obj) {
        this.f73470b.e2((Subscriber) obj);
    }
}
