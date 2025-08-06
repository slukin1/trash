package com.hbg.lib.core.network.rx;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public class SilentSubscriber<T> extends EasySubscriber<T> {

    /* renamed from: b  reason: collision with root package name */
    public Action1<APIStatusErrorException> f68438b;

    /* renamed from: c  reason: collision with root package name */
    public Action1<Throwable> f68439c;

    public SilentSubscriber() {
    }

    public static <B> SilentSubscriber<B> a(Action1<B> action1) {
        return new SilentSubscriber<>(action1);
    }

    public static <B> SilentSubscriber<B> b(Action1<B> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13) {
        return new SilentSubscriber<>(action1, action12, action13);
    }

    public void onError2(Throwable th2) {
        Action1<Throwable> action1 = this.f68439c;
        if (action1 != null) {
            action1.call(th2);
        }
    }

    public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        Action1<APIStatusErrorException> action1 = this.f68438b;
        if (action1 != null) {
            action1.call(aPIStatusErrorException);
        }
    }

    public SilentSubscriber(Action1<T> action1) {
        super(action1);
    }

    public SilentSubscriber(Action1<T> action1, Action1<APIStatusErrorException> action12, Action1<Throwable> action13) {
        super(action1, action12, action13);
        this.f68438b = action12;
        this.f68439c = action13;
    }
}
