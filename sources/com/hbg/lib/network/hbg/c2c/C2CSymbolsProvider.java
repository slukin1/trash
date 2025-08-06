package com.hbg.lib.network.hbg.c2c;

import com.hbg.lib.network.hbg.core.bean.C2CSymbolBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.schedulers.Schedulers;
import v7.b;
import w7.e;

public class C2CSymbolsProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final List<C2CSymbolBean> f70212a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, C2CSymbolBean> f70213b = new HashMap();

    public static List<C2CSymbolBean> b() {
        ArrayList arrayList;
        List<C2CSymbolBean> list = f70212a;
        synchronized (list) {
            arrayList = new ArrayList(list);
        }
        return arrayList;
    }

    public static Observable<List<C2CSymbolBean>> c(boolean z11) {
        if (!z11 || e()) {
            return b.a().requestC2CSymbols().b().flatMap(e.f61227b).subscribeOn(Schedulers.io());
        }
        return Observable.just(b());
    }

    public static void d(List<C2CSymbolBean> list) {
        Map<String, C2CSymbolBean> map = f70213b;
        synchronized (map) {
            map.clear();
            if (list != null) {
                for (C2CSymbolBean next : list) {
                    f70213b.put(next.getSymbol(), next);
                }
            }
        }
        List<C2CSymbolBean> list2 = f70212a;
        synchronized (list2) {
            list2.clear();
            if (list != null) {
                list2.addAll(list);
            }
        }
    }

    public static boolean e() {
        return f70212a.isEmpty();
    }

    public static C2CSymbolBean g(String str) {
        return f70213b.get(str);
    }
}
