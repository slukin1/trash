package com.huobi.index.repository;

import d10.l;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f73485b;

    public /* synthetic */ a(l lVar) {
        this.f73485b = lVar;
    }

    public final void call(Object obj) {
        FeedRepository.r(this.f73485b, obj);
    }
}
