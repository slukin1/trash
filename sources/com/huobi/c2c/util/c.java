package com.huobi.c2c.util;

import com.hbg.lib.network.hbg.c2c.C2CCurrencyProvider;
import com.hbg.lib.network.hbg.core.bean.C2CCurrencyBean;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import d7.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;

public final class c {
    public static Observable<List<C2CCurrencyBean>> b(boolean z11) {
        return f(C2CCurrencyProvider.g(z11), true);
    }

    public static List<C2CCurrencyBean> c() {
        List<C2CCurrencyBean> n11 = C2CCurrencyProvider.n(C2CCurrencyProvider.d(), a.f43019a);
        ArrayList arrayList = new ArrayList();
        Map<String, CurrencyBean> u11 = k.C().u();
        for (C2CCurrencyBean next : n11) {
            if (u11 != null && u11.containsKey(next.getCurrency())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static Observable<List<C2CCurrencyBean>> d(boolean z11, boolean z12) {
        return f(C2CCurrencyProvider.f(z11, z12), z11);
    }

    public static /* synthetic */ List e(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        Map<String, CurrencyBean> u11 = k.C().u();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            C2CCurrencyBean c2CCurrencyBean = (C2CCurrencyBean) it2.next();
            if (u11 != null && u11.containsKey(c2CCurrencyBean.getCurrency())) {
                arrayList.add(c2CCurrencyBean);
            }
        }
        return arrayList;
    }

    public static Observable<List<C2CCurrencyBean>> f(Observable<List<C2CCurrencyBean>> observable, boolean z11) {
        return Observable.zip(C2CCurrencyProvider.o(observable, a.f43019a), k.C().E(z11), b.f43020b);
    }
}
