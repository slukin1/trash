package com.huobi.utils;

import android.util.Pair;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class s implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f83774b;

    public /* synthetic */ s(String str) {
        this.f83774b = str;
    }

    public final Object call(Object obj) {
        return Observable.just(Pair.create("", this.f83774b));
    }
}
