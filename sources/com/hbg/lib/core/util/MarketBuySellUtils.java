package com.hbg.lib.core.util;

import java.util.ArrayList;
import java.util.List;

public class MarketBuySellUtils {
    public static List<Double> a(List<Double[]> list, int i11) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int min = Math.min(i11, list.size());
        double d11 = 0.0d;
        for (int i12 = 0; i12 < min; i12++) {
            if (list.get(i12).length >= 2) {
                d11 += list.get(i12)[1].doubleValue();
                arrayList.add(Double.valueOf(d11));
            }
        }
        return arrayList;
    }

    public static void b(List<Double> list, List<Double> list2) {
        if (!list.isEmpty() && !list2.isEmpty()) {
            if (list.get(list.size() - 1).doubleValue() < list2.get(list2.size() - 1).doubleValue()) {
                list.set(list.size() - 1, list2.get(list2.size() - 1));
            } else {
                list2.set(list2.size() - 1, list.get(list.size() - 1));
            }
        }
    }
}
