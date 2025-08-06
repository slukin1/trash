package com.huobi.index.presenter;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import java.util.Map;
import rx.functions.Func1;

public final /* synthetic */ class b0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f73427b;

    public /* synthetic */ b0(Map map) {
        this.f73427b = map;
    }

    public final Object call(Object obj) {
        return f0.p(this.f73427b, (FutureContractInfo) obj);
    }
}
