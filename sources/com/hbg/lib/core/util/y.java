package com.hbg.lib.core.util;

import rx.Observable;
import rx.Scheduler;

public final /* synthetic */ class y implements Observable.Transformer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Scheduler f68772b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Scheduler f68773c;

    public /* synthetic */ y(Scheduler scheduler, Scheduler scheduler2) {
        this.f68772b = scheduler;
        this.f68773c = scheduler2;
    }

    public final Object call(Object obj) {
        return ((Observable) obj).subscribeOn(this.f68772b).observeOn(this.f68773c);
    }
}
