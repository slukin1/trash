package com.hbg.lib.network.contract.core.controller;

import com.hbg.lib.network.contract.core.bean.ContractAvailableLevelInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q7.a;
import rx.Observable;

public final class ContractAllowLevelController {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, List<String>> f69227a = new HashMap();

    public static Observable<List<String>> b(boolean z11, String str) {
        List list;
        if (!z11 || (list = f69227a.get(str)) == null || list.isEmpty()) {
            return a.a().getAllowLevel(str).b().map(new r7.a(str));
        }
        return Observable.just(list);
    }

    public static List<String> c(String str) {
        Map<String, List<String>> map = f69227a;
        if (map.get(str) != null) {
            return map.get(str);
        }
        return new ArrayList();
    }

    public static /* synthetic */ List d(String str, List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ContractAvailableLevelInfo contractAvailableLevelInfo = (ContractAvailableLevelInfo) it2.next();
            String[] leverList = contractAvailableLevelInfo.getLeverList();
            if (leverList != null) {
                f69227a.put(contractAvailableLevelInfo.getSymbol(), new ArrayList(Arrays.asList(leverList)));
            }
        }
        return c(str);
    }
}
