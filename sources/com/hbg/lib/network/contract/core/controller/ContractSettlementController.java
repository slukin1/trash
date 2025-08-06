package com.hbg.lib.network.contract.core.controller;

import com.hbg.lib.network.contract.core.bean.ContractSettlementPrice;
import com.hbg.lib.network.contract.core.bean.ContractSettlementPriceInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q7.a;
import r7.e;
import rx.Observable;

public final class ContractSettlementController {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, List<ContractSettlementPrice>> f69233a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, ContractSettlementPriceInfo> f69234b = new HashMap();

    public static ContractSettlementPriceInfo b(String str) {
        Map<String, ContractSettlementPriceInfo> map = f69234b;
        if (map.get(str) != null) {
            return map.get(str);
        }
        return null;
    }

    public static Observable<List<ContractSettlementPrice>> c(boolean z11, String str) {
        List list;
        if (!z11 || (list = f69233a.get(str)) == null || list.isEmpty()) {
            return a.a().Q(str).b().map(new e(str));
        }
        return Observable.just(list);
    }

    public static /* synthetic */ List d(String str, List list) {
        List<ContractSettlementPriceInfo> list2;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ContractSettlementPrice contractSettlementPrice = (ContractSettlementPrice) it2.next();
            if (contractSettlementPrice.getSymbol().equals(str) && (list2 = contractSettlementPrice.getList()) != null) {
                for (ContractSettlementPriceInfo next : list2) {
                    f69234b.put(next.getContractType(), next);
                }
            }
        }
        f69233a.put(str, list);
        return list;
    }
}
