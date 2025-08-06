package com.huobi.index.repository;

import d10.l;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f73486b;

    public /* synthetic */ b(l lVar) {
        this.f73486b = lVar;
    }

    public final void call(Object obj) {
        FeedRepository.v(this.f73486b, obj);
    }
}
