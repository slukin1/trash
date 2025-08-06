package com.huobi.utils;

import android.util.Pair;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class r implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f83770b;

    public /* synthetic */ r(String str) {
        this.f83770b = str;
    }

    public final Object call(Object obj) {
        return Observable.just(Pair.create("", this.f83770b));
    }
}
