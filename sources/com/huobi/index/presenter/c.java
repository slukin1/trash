package com.huobi.index.presenter;

import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import java.util.Map;
import rx.functions.Func1;

public final /* synthetic */ class c implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f73428b;

    public /* synthetic */ c(Map map) {
        this.f73428b = map;
    }

    public final Object call(Object obj) {
        return e.l(this.f73428b, (ContractCurrencyInfo) obj);
    }
}
