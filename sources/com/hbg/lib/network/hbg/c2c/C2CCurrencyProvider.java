package com.hbg.lib.network.hbg.c2c;

import ad.i;
import com.hbg.lib.network.hbg.core.bean.C2CCurrencyBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import v7.b;
import w7.c;
import w7.d;

public class C2CCurrencyProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final List<C2CCurrencyBean> f70210a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, C2CCurrencyBean> f70211b = new HashMap();

    public interface a {
        int a(String str);
    }

    public static List<C2CCurrencyBean> d() {
        ArrayList arrayList;
        List<C2CCurrencyBean> list = f70210a;
        synchronized (list) {
            arrayList = new ArrayList(list);
        }
        return arrayList;
    }

    public static Observable<List<C2CCurrencyBean>> e(boolean z11) {
        if (!z11 || i()) {
            return b.a().requestC2CCurrencys().b().flatMap(d.f61226b);
        }
        return Observable.just(d());
    }

    public static Observable<List<C2CCurrencyBean>> f(boolean z11, boolean z12) {
        Observable<List<C2CCurrencyBean>> e11 = e(z11);
        return z12 ? e11.flatMap(i.f3526b).filter(c.f61225b).toList() : e11;
    }

    public static Observable<List<C2CCurrencyBean>> g(boolean z11) {
        Observable<List<C2CCurrencyBean>> just = Observable.just(d());
        return z11 ? just.flatMap(i.f3526b).filter(c.f61225b).toList() : just;
    }

    public static void h(List<C2CCurrencyBean> list) {
        Map<String, C2CCurrencyBean> map = f70211b;
        synchronized (map) {
            map.clear();
            if (list != null) {
                for (C2CCurrencyBean next : list) {
                    f70211b.put(next.getCurrency(), next);
                }
            }
        }
        List<C2CCurrencyBean> list2 = f70210a;
        synchronized (list2) {
            list2.clear();
            if (list != null) {
                list2.addAll(list);
            }
        }
    }

    public static boolean i() {
        return f70210a.isEmpty();
    }

    public static /* synthetic */ int l(a aVar, C2CCurrencyBean c2CCurrencyBean, C2CCurrencyBean c2CCurrencyBean2) {
        return aVar.a(c2CCurrencyBean2.getCurrency()) - aVar.a(c2CCurrencyBean.getCurrency());
    }

    public static C2CCurrencyBean m(String str) {
        return f70211b.get(str);
    }

    public static List<C2CCurrencyBean> n(List<C2CCurrencyBean> list, a aVar) {
        if (aVar != null) {
            Collections.sort(list, new w7.a(aVar));
        }
        return list;
    }

    public static Observable<List<C2CCurrencyBean>> o(Observable<List<C2CCurrencyBean>> observable, a aVar) {
        return observable.map(new w7.b(aVar));
    }
}
