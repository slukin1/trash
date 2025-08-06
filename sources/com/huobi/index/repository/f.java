package com.huobi.index.repository;

import d10.l;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f73490b;

    public /* synthetic */ f(l lVar) {
        this.f73490b = lVar;
    }

    public final Object call(Object obj) {
        return FeedRepository.u(this.f73490b, obj);
    }
}
