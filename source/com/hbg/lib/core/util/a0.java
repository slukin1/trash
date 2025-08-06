package com.hbg.lib.core.util;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import u6.g;

public final /* synthetic */ class a0 implements Observable.Transformer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Scheduler f68690b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f68691c;

    public /* synthetic */ a0(Scheduler scheduler, g gVar) {
        this.f68690b = scheduler;
        this.f68691c = gVar;
    }

    public final Object call(Object obj) {
        return ((Observable) obj).subscribeOn(this.f68690b).observeOn(AndroidSchedulers.mainThread()).takeUntil(this.f68691c.getUIChangeSubject().filter(e0.f68701b).take(1)).filter(new c0(this.f68691c));
    }
}
