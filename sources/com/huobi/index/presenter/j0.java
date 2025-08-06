package com.huobi.index.presenter;

import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import java.util.Map;
import rx.functions.Func1;

public final /* synthetic */ class j0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f73451b;

    public /* synthetic */ j0(Map map) {
        this.f73451b = map;
    }

    public final Object call(Object obj) {
        return l0.l(this.f73451b, (SwapCurrencyInfo) obj);
    }
}
