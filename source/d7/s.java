package d7;

import com.hbg.lib.network.pro.core.bean.DepthsInfo;
import com.hbg.lib.network.pro.core.bean.DepthsInfoSymbol;
import com.hbg.lib.network.pro.db.DepthsInfoSymbolDbHelper;
import com.hbg.lib.network.pro.db.ProDbHelper;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import x8.a;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f68997a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final List<DepthsInfoSymbol> f68998b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, DepthsInfo> f68999c = new HashMap();

    public static Map<String, DepthsInfo> f() {
        HashMap hashMap;
        synchronized (f68997a) {
            hashMap = new HashMap(f68999c);
        }
        return hashMap;
    }

    public static Observable<Map<String, DepthsInfo>> g(boolean z11) {
        String h11 = h();
        if (z11 && i()) {
            return Observable.just(f());
        }
        Map hashMap = new HashMap();
        if (!i()) {
            j(h11);
            if (i()) {
                hashMap = f();
            }
        }
        Observable<Map<String, DepthsInfo>> doOnNext = a.a().getSymbolDepthInfo().b().onErrorReturn(r.f53528b).doOnNext(new p(h11));
        if (hashMap.isEmpty()) {
            return doOnNext;
        }
        Observable<Map<String, DepthsInfo>> just = Observable.just(hashMap);
        a.a().getSymbolDepthInfo().b().doOnNext(new q(h11)).compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new BaseSubscriber());
        return just;
    }

    public static String h() {
        return b1.a().b().b();
    }

    public static boolean i() {
        return !f68998b.isEmpty();
    }

    public static void j(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        List<DepthsInfoSymbol> g11 = DepthsInfoSymbolDbHelper.g(str);
        RetrofitLogger.a("DepthsInfoSymbolConfigUtil-->loadAll--> key: " + str + " 本地有: " + g11.size() + " 个 耗时:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        if (!g11.isEmpty()) {
            r(g11, str);
        }
    }

    public static void k(String str) {
        new Thread(new n(str, System.currentTimeMillis())).start();
    }

    public static /* synthetic */ void o(String str, List list, long j11) {
        RetrofitLogger.a("DepthsInfoSymbolConfigUtil-->loadAll--> key: " + str + " 本地有: " + list.size() + " 个 耗时:" + (System.currentTimeMillis() - j11) + "ms");
        if (!list.isEmpty()) {
            r(list, str);
        }
    }

    public static void q() {
        String h11 = h();
        if (!i()) {
            k(h11);
        }
    }

    public static void r(List<DepthsInfoSymbol> list, String str) {
        if (list != null) {
            HashMap hashMap = new HashMap();
            for (DepthsInfoSymbol next : list) {
                next.setKey(str);
                hashMap.put(next.getSymbol(), next.getDepthsInfo());
            }
            synchronized (f68997a) {
                List<DepthsInfoSymbol> list2 = f68998b;
                list2.clear();
                list2.addAll(list);
                Map<String, DepthsInfo> map = f68999c;
                map.clear();
                map.putAll(hashMap);
            }
        }
    }

    public static void s(Map<String, DepthsInfo> map, String str) {
        if (map != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : map.entrySet()) {
                DepthsInfoSymbol depthsInfoSymbol = new DepthsInfoSymbol();
                depthsInfoSymbol.setKey(str);
                depthsInfoSymbol.setSymbol((String) next.getKey());
                depthsInfoSymbol.setDepthsInfo((DepthsInfo) next.getValue());
                arrayList.add(depthsInfoSymbol);
            }
            synchronized (f68997a) {
                Map<String, DepthsInfo> map2 = f68999c;
                map2.clear();
                map2.putAll(map);
                List<DepthsInfoSymbol> list = f68998b;
                list.clear();
                list.addAll(arrayList);
            }
            long currentTimeMillis = System.currentTimeMillis();
            ProDbHelper.d(arrayList);
            RetrofitLogger.a("DepthsInfoSymbolConfigUtil-->setSymbolMap--> key: " + str + " 插入: " + arrayList.size() + " 个 耗时:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }
}
