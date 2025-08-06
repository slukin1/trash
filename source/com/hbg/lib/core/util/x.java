package com.hbg.lib.core.util;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

public final /* synthetic */ class x implements Observable.Transformer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Scheduler f68771b;

    public /* synthetic */ x(Scheduler scheduler) {
        this.f68771b = scheduler;
    }

    public final Object call(Object obj) {
        return ((Observable) obj).subscribeOn(this.f68771b).observeOn(AndroidSchedulers.mainThread());
    }
}
