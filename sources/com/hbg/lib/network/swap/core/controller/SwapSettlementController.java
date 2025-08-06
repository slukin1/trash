package com.hbg.lib.network.swap.core.controller;

import com.hbg.lib.network.swap.core.bean.SwapSettlementPriceInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l9.a;
import m9.u;
import rx.Observable;

public final class SwapSettlementController {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, List<SwapSettlementPriceInfo>> f70766a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, SwapSettlementPriceInfo> f70767b = new HashMap();

    public static SwapSettlementPriceInfo b(String str) {
        Map<String, SwapSettlementPriceInfo> map = f70767b;
        if (map.get(str) != null) {
            return map.get(str);
        }
        return null;
    }

    public static Observable<List<SwapSettlementPriceInfo>> c(boolean z11, String str) {
        List list;
        if (!z11 || (list = f70766a.get(str)) == null || list.isEmpty()) {
            return a.a().N(str).b().map(new u(str));
        }
        return Observable.just(list);
    }

    public static /* synthetic */ List d(String str, List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            SwapSettlementPriceInfo swapSettlementPriceInfo = (SwapSettlementPriceInfo) it2.next();
            if (swapSettlementPriceInfo.getContractCode().equals(str)) {
                f70767b.put(swapSettlementPriceInfo.getContractCode(), swapSettlementPriceInfo);
            }
        }
        f70766a.put(str, list);
        return list;
    }
}
