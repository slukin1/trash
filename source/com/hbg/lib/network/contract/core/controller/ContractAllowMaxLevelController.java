package com.hbg.lib.network.contract.core.controller;

import com.hbg.lib.network.contract.core.bean.ContractAllowLevel;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q7.a;
import r7.b;
import rx.Observable;

public final class ContractAllowMaxLevelController {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, List<String>> f69228a = new HashMap();

    public static Observable<List<String>> b(boolean z11, String str) {
        List list;
        if (!z11 || (list = f69228a.get(str)) == null || list.isEmpty()) {
            return a.a().getAllowMaxLevel(str).b().map(new b(str));
        }
        return Observable.just(list);
    }

    public static List<String> c(String str) {
        Map<String, List<String>> map = f69228a;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return null;
    }

    public static /* synthetic */ List d(String str, List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ContractAllowLevel contractAllowLevel = (ContractAllowLevel) it2.next();
            if (contractAllowLevel != null) {
                String availableLevelRate = contractAllowLevel.getAvailableLevelRate();
                ArrayList arrayList = new ArrayList();
                if (availableLevelRate != null) {
                    if (availableLevelRate.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                        arrayList.addAll(Arrays.asList(availableLevelRate.split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
                    } else {
                        arrayList.add(availableLevelRate);
                    }
                }
                f69228a.put(contractAllowLevel.getSymbol(), arrayList);
            }
        }
        return c(str);
    }
}
