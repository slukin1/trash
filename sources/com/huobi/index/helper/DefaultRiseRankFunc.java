package com.huobi.index.helper;

import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import com.huobi.index.bean.RealTimePrice;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import rx.functions.Func1;

public class DefaultRiseRankFunc implements Func1<List<RealTimePrice>, List<RealTimePrice>> {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f73266b = {"usd", "btc", "eth", "ht", "husd"};

    /* renamed from: a */
    public List<RealTimePrice> call(List<RealTimePrice> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] strArr = f73266b;
        ArrayList j11 = Lists.j(strArr);
        int length = strArr.length * 10;
        int size = list.size();
        for (int i11 = 0; i11 < Math.min(length, size); i11++) {
            RealTimePrice realTimePrice = list.get(i11);
            if (realTimePrice != null) {
                String a11 = realTimePrice.a();
                if (linkedHashMap.containsKey(a11)) {
                    RealTimePrice realTimePrice2 = (RealTimePrice) linkedHashMap.get(a11);
                    if (realTimePrice2 == null) {
                        linkedHashMap.remove(a11);
                        linkedHashMap.put(a11, realTimePrice);
                    } else if (j11.indexOf(realTimePrice2.k()) > j11.indexOf(realTimePrice.k())) {
                        linkedHashMap.remove(a11);
                        linkedHashMap.put(a11, realTimePrice);
                    }
                } else {
                    linkedHashMap.put(a11, realTimePrice);
                }
            }
        }
        ArrayList h11 = Lists.h(linkedHashMap.values());
        return h11.size() > 10 ? h11.subList(0, 10) : h11;
    }
}
