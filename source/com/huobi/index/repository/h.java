package com.huobi.index.repository;

import d10.l;
import rx.functions.Func1;

public final /* synthetic */ class h implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f73492b;

    public /* synthetic */ h(l lVar) {
        this.f73492b = lVar;
    }

    public final Object call(Object obj) {
        return FeedRepository.s(this.f73492b, obj);
    }
}
