package com.hbg.lib.network.linear.swap.controller;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAvailableLevelInfo;
import h8.a;
import i8.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;

public final class LinearSwapAllowLevelController {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, List<String>> f70317a = new HashMap();

    public static Observable<List<String>> c(boolean z11, String str, int i11) {
        if (z11) {
            Map<String, List<String>> map = f70317a;
            List list = map.get(str + "_" + i11);
            if (list != null && !list.isEmpty()) {
                return Observable.just(list);
            }
        }
        if (i11 == 2) {
            return a.a().getAllowLevel(str, TtmlNode.COMBINE_ALL).b().map(new i8.a(i11, str));
        }
        return a.a().getCrossAllowLevel(str, TtmlNode.COMBINE_ALL).b().map(new b(i11, str));
    }

    public static List<String> d(String str, int i11) {
        Map<String, List<String>> map = f70317a;
        if (map.get(str + "_" + i11) == null) {
            return new ArrayList();
        }
        return map.get(str + "_" + i11);
    }

    public static /* synthetic */ List e(int i11, String str, List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            LinearSwapAvailableLevelInfo linearSwapAvailableLevelInfo = (LinearSwapAvailableLevelInfo) it2.next();
            String[] leverList = linearSwapAvailableLevelInfo.getLeverList();
            if (leverList != null) {
                ArrayList arrayList = new ArrayList(Arrays.asList(leverList));
                Map<String, List<String>> map = f70317a;
                map.put(linearSwapAvailableLevelInfo.getContractCode() + "_" + i11, arrayList);
            }
        }
        return d(str, i11);
    }

    public static /* synthetic */ List f(int i11, String str, List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            LinearSwapAvailableLevelInfo linearSwapAvailableLevelInfo = (LinearSwapAvailableLevelInfo) it2.next();
            String[] leverList = linearSwapAvailableLevelInfo.getLeverList();
            if (leverList != null) {
                ArrayList arrayList = new ArrayList(Arrays.asList(leverList));
                Map<String, List<String>> map = f70317a;
                map.put(linearSwapAvailableLevelInfo.getContractCode() + "_" + i11, arrayList);
            }
        }
        return d(str, i11);
    }
}
