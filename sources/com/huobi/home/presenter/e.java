package com.huobi.home.presenter;

import com.huobi.app.H5CacheServiceHelper;
import java.util.HashSet;
import java.util.Map;

public final /* synthetic */ class e implements H5CacheServiceHelper.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomePresenter f72500a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashSet f72501b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f72502c;

    public /* synthetic */ e(HomePresenter homePresenter, HashSet hashSet, Map map) {
        this.f72500a = homePresenter;
        this.f72501b = hashSet;
        this.f72502c = map;
    }

    public final void call() {
        HomePresenter.F0(this.f72500a, this.f72501b, this.f72502c);
    }
}
