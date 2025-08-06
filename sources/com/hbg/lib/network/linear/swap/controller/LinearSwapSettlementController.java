package com.hbg.lib.network.linear.swap.controller;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapSettlementPriceInfo;
import h8.a;
import i8.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;

public final class LinearSwapSettlementController {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, List<LinearSwapSettlementPriceInfo>> f70337a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, LinearSwapSettlementPriceInfo> f70338b = new HashMap();

    public static LinearSwapSettlementPriceInfo b(String str) {
        Map<String, LinearSwapSettlementPriceInfo> map = f70338b;
        if (map.get(str) != null) {
            return map.get(str);
        }
        return null;
    }

    public static Observable<List<LinearSwapSettlementPriceInfo>> c(boolean z11, String str, String str2, String str3) {
        List list;
        if (!z11 || (list = f70337a.get(str)) == null || list.isEmpty()) {
            return a.a().v0(str, str2, str3).b().map(new o(str));
        }
        return Observable.just(list);
    }

    public static /* synthetic */ List d(String str, List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            LinearSwapSettlementPriceInfo linearSwapSettlementPriceInfo = (LinearSwapSettlementPriceInfo) it2.next();
            if (linearSwapSettlementPriceInfo.getContractCode().equals(str)) {
                f70338b.put(linearSwapSettlementPriceInfo.getContractCode(), linearSwapSettlementPriceInfo);
            }
        }
        f70337a.put(str, list);
        return list;
    }
}
