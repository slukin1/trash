package com.huobi.tradingbot.manager;

import com.hbg.lib.network.hbg.grid.bean.GridLeverageRange;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rx.Observable;
import v7.b;
import zt.a;

public final class GridLeverageRangeController {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, List<String>> f83581a = new ConcurrentHashMap();

    public static Observable<List<String>> b(boolean z11, String str) {
        List list;
        if (!z11 || (list = f83581a.get(str)) == null || list.isEmpty()) {
            return b.a().requestContractGridLeverageRange(str).b().map(new a(str));
        }
        return Observable.just(list);
    }

    public static List<String> c(String str) {
        Map<String, List<String>> map = f83581a;
        if (map.get(str) != null) {
            return map.get(str);
        }
        return new ArrayList();
    }

    public static /* synthetic */ List d(String str, GridLeverageRange gridLeverageRange) {
        ArrayList arrayList = new ArrayList();
        for (int minLever = gridLeverageRange.getMinLever(); minLever <= gridLeverageRange.getMaxLever(); minLever++) {
            arrayList.add(String.valueOf(minLever));
        }
        f83581a.put(str, arrayList);
        return arrayList;
    }
}
