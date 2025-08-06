package com.huobi.defibox;

import com.google.gson.Gson;
import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.hbg.lib.network.retrofit.util.SPUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import x8.a;

public class DefiChainListProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f43770a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final List<DefiChainInfo> f43771b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, DefiChainInfo> f43772c = new HashMap();

    public static List<DefiChainInfo> b() {
        ArrayList arrayList;
        synchronized (f43770a) {
            arrayList = new ArrayList(f43771b);
        }
        return arrayList;
    }

    public static DefiChainInfo c(String str) {
        return f43772c.get(str);
    }

    public static Observable<List<DefiChainInfo>> d(boolean z11) {
        Observable<List<DefiChainInfo>> doOnNext = a.a().getDefiBoxChainList().b().doOnNext(mj.a.f58245b);
        if (z11) {
            List<DefiChainInfo> list = f43771b;
            if (list.size() != 0) {
                return Observable.just(new ArrayList(list));
            }
        }
        return doOnNext;
    }

    public static void e(List<DefiChainInfo> list) {
        if (list != null && !list.isEmpty()) {
            synchronized (f43770a) {
                List<DefiChainInfo> list2 = f43771b;
                list2.clear();
                list2.addAll(list);
                f43772c.clear();
                for (DefiChainInfo next : list2) {
                    f43772c.put(next.getChain(), next);
                }
                SPUtil.m("DefiChainListProvider", new Gson().toJson((Object) f43771b));
            }
        }
    }
}
