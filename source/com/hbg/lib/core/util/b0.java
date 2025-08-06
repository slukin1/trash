package com.hbg.lib.core.util;

import rx.Observable;
import rx.schedulers.Schedulers;

public final /* synthetic */ class b0 implements Observable.Transformer {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ b0 f68693b = new b0();

    public final Object call(Object obj) {
        return ((Observable) obj).subscribeOn(Schedulers.io()).observeOn(Schedulers.computation());
    }
}
