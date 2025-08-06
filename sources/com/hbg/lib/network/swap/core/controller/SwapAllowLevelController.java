package com.hbg.lib.network.swap.core.controller;

import com.hbg.lib.network.swap.core.bean.SwapAvailableLevelInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import l9.a;
import m9.f;
import rx.Observable;

public final class SwapAllowLevelController {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, List<String>> f70757a = new HashMap();

    public static Observable<List<String>> b(boolean z11, String str) {
        List list;
        if (!z11 || (list = f70757a.get(str)) == null || list.isEmpty()) {
            return a.a().getAllowLevel(str).b().map(new f(str));
        }
        return Observable.just(list);
    }

    public static List<String> c(String str) {
        Map<String, List<String>> map = f70757a;
        if (map.get(str) != null) {
            return map.get(str);
        }
        return new ArrayList();
    }

    public static /* synthetic */ List d(String str, List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            SwapAvailableLevelInfo swapAvailableLevelInfo = (SwapAvailableLevelInfo) it2.next();
            String[] leverList = swapAvailableLevelInfo.getLeverList();
            if (leverList != null) {
                f70757a.put(swapAvailableLevelInfo.getSymbol(), new ArrayList(Arrays.asList(leverList)));
            }
        }
        return c(str);
    }
}
