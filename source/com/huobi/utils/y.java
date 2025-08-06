package com.huobi.utils;

import android.content.Context;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class y implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f83795b;

    public /* synthetic */ y(Context context) {
        this.f83795b = context;
    }

    public final void call(Object obj) {
        z.e(this.f83795b, (Subscriber) obj);
    }
}
