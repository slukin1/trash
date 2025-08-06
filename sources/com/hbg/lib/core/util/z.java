package com.hbg.lib.core.util;

import rx.Observable;
import rx.Scheduler;
import u6.g;

public final /* synthetic */ class z implements Observable.Transformer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Scheduler f68774b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Scheduler f68775c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f68776d;

    public /* synthetic */ z(Scheduler scheduler, Scheduler scheduler2, g gVar) {
        this.f68774b = scheduler;
        this.f68775c = scheduler2;
        this.f68776d = gVar;
    }

    public final Object call(Object obj) {
        return ((Observable) obj).subscribeOn(this.f68774b).observeOn(this.f68775c).takeUntil(this.f68776d.getUIChangeSubject().filter(f0.f68703b).take(1)).filter(new d0(this.f68776d));
    }
}
