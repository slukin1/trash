package com.hbg.lib.network.retrofit.rxjava;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import e9.a;
import e9.b;
import e9.c;
import e9.d;
import rx.functions.Action0;
import rx.functions.Action1;

public class BaseEasySubscriber<T> extends BaseSubscriber<T> {

    /* renamed from: b  reason: collision with root package name */
    public Action0 f70661b;

    /* renamed from: c  reason: collision with root package name */
    public Action1<T> f70662c;

    /* renamed from: d  reason: collision with root package name */
    public Action1<APIStatusErrorException> f70663d;

    /* renamed from: e  reason: collision with root package name */
    public Action1<Throwable> f70664e;

    /* renamed from: f  reason: collision with root package name */
    public Action0 f70665f;

    public BaseEasySubscriber() {
    }

    public static <B> BaseEasySubscriber<B> e(RequestCallback1<B> requestCallback1) {
        return f(new a(requestCallback1), new d(requestCallback1), new b(requestCallback1), new c(requestCallback1));
    }

    public static <B> BaseEasySubscriber<B> f(Action0 action0, Action1<B> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13) {
        return new BaseEasySubscriber<>(action0, action1, action12, action13);
    }

    public static /* synthetic */ void g(RequestCallback1 requestCallback1) {
        if (requestCallback1 != null) {
            requestCallback1.onRequestStart();
        }
    }

    public static /* synthetic */ void h(RequestCallback1 requestCallback1, Object obj) {
        if (requestCallback1 != null) {
            requestCallback1.onRequestSuccess(obj);
        }
    }

    public static /* synthetic */ void i(RequestCallback1 requestCallback1, APIStatusErrorException aPIStatusErrorException) {
        if (requestCallback1 != null) {
            requestCallback1.onRequestFailure(aPIStatusErrorException);
        }
    }

    public static /* synthetic */ void j(RequestCallback1 requestCallback1, Throwable th2) {
        if (requestCallback1 != null) {
            requestCallback1.onRequestFailure(th2);
        }
    }

    public void onAfter() {
        super.onAfter();
        Action0 action0 = this.f70665f;
        if (action0 != null) {
            action0.call();
        }
    }

    public final void onError(Throwable th2) {
        if (th2 instanceof APIStatusErrorException) {
            onFailed((APIStatusErrorException) th2);
        } else {
            onError2(th2);
        }
        super.onError(th2);
    }

    public void onError2(Throwable th2) {
        Action1<Throwable> action1 = this.f70664e;
        if (action1 != null) {
            action1.call(th2);
        }
    }

    public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        Action1<APIStatusErrorException> action1 = this.f70663d;
        if (action1 != null) {
            action1.call(aPIStatusErrorException);
        }
    }

    public void onNext(T t11) {
        super.onNext(t11);
        Action1<T> action1 = this.f70662c;
        if (action1 != null) {
            action1.call(t11);
        }
    }

    public void onStart() {
        super.onStart();
        Action0 action0 = this.f70661b;
        if (action0 != null) {
            action0.call();
        }
    }

    public BaseEasySubscriber(Action0 action0, Action1<T> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13) {
        this.f70661b = action0;
        this.f70662c = action1;
        this.f70663d = action12;
        this.f70664e = action13;
    }
}
