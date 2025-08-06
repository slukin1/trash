package com.huobi.domain;

import retrofit2.Response;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f43854b;

    public /* synthetic */ f(String str) {
        this.f43854b = str;
    }

    public final Object call(Object obj) {
        return DomainSwitcher.d0(this.f43854b, (Response) obj);
    }
}
