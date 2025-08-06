package com.huobi.finance.presenter;

import java.util.Map;
import rx.functions.Func1;

public final /* synthetic */ class p9 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f46061b;

    public /* synthetic */ p9(Map map) {
        this.f46061b = map;
    }

    public final Object call(Object obj) {
        return UnifyTransferPresenter.e3(this.f46061b, (Throwable) obj);
    }
}
