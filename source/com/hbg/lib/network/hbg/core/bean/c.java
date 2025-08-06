package com.hbg.lib.network.hbg.core.bean;

import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class c implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SavingsCurrencyProvider f70276b;

    public /* synthetic */ c(SavingsCurrencyProvider savingsCurrencyProvider) {
        this.f70276b = savingsCurrencyProvider;
    }

    public final Object call(Object obj) {
        return this.f70276b.lambda$getNetObservable$0((List) obj);
    }
}
