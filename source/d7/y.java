package d7;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.db.GridSymbolDbHelper;
import com.hbg.lib.network.hbg.db.HbgDbHelper;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolsBean;
import com.hbg.lib.network.hbg.grid.bean.GridSymbolsConfig;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f69000a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final List<GridSymbolsBean> f69001b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static final List<GridSymbolsBean> f69002c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, GridSymbolsBean> f69003d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, List<String>> f69004e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static GridSymbolsConfig f69005f = null;

    public class a extends BaseSubscriber<GridSymbolsConfig> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Subscriber f69006b;

        public a(Subscriber subscriber) {
            this.f69006b = subscriber;
        }

        /* renamed from: a */
        public void onNext(GridSymbolsConfig gridSymbolsConfig) {
            this.f69006b.onNext(gridSymbolsConfig);
            this.f69006b.onCompleted();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f69006b.onNext(y.i());
            this.f69006b.onCompleted();
        }
    }

    public static boolean e(String str) {
        boolean containsKey;
        synchronized (f69000a) {
            containsKey = f69003d.containsKey(str);
        }
        return containsKey;
    }

    public static List<String> f() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        Map<String, SymbolBean> V = a1.v().V(TradeType.PRO);
        List<GridSymbolsBean> list = f69001b;
        synchronized (list) {
            for (GridSymbolsBean symbolCode : list) {
                SymbolBean symbolBean = V.get(symbolCode.getSymbolCode());
                if (symbolBean != null) {
                    if (symbolBean.isCanTrade()) {
                        if (symbolBean.isFiatTag()) {
                            List list2 = (List) hashMap.get(SymbolBean.FIAT);
                            if (list2 == null) {
                                list2 = new ArrayList();
                            }
                            if (!arrayList.contains(SymbolBean.FIAT)) {
                                arrayList.add(SymbolBean.FIAT);
                            }
                            if (!list2.contains(symbolBean.getSymbol())) {
                                list2.add(symbolBean.getSymbol());
                                hashMap.put(SymbolBean.FIAT, list2);
                            }
                        } else if (symbolBean.isAltsTag()) {
                            List list3 = (List) hashMap.get(SymbolBean.ALTS);
                            if (list3 == null) {
                                list3 = new ArrayList();
                            }
                            if (!arrayList.contains(SymbolBean.ALTS)) {
                                arrayList.add(SymbolBean.ALTS);
                            }
                            if (!list3.contains(symbolBean.getSymbol())) {
                                list3.add(symbolBean.getSymbol());
                                hashMap.put(SymbolBean.ALTS, list3);
                            }
                        } else if (symbolBean.isCryptoTag()) {
                            List list4 = (List) hashMap.get(SymbolBean.CRYPTO);
                            if (list4 == null) {
                                list4 = new ArrayList();
                            }
                            if (!arrayList.contains(SymbolBean.CRYPTO)) {
                                arrayList.add(SymbolBean.CRYPTO);
                            }
                            if (!list4.contains(symbolBean.getSymbol())) {
                                list4.add(symbolBean.getSymbol());
                                hashMap.put(SymbolBean.CRYPTO, list4);
                            }
                        } else {
                            List list5 = (List) hashMap.get(symbolBean.getQuoteCurrency());
                            if (list5 == null) {
                                list5 = new ArrayList();
                            }
                            if (!arrayList.contains(symbolBean.getQuoteCurrency())) {
                                arrayList.add(symbolBean.getQuoteCurrency());
                            }
                            if (!list5.contains(symbolBean.getSymbol())) {
                                list5.add(symbolBean.getSymbol());
                                hashMap.put(symbolBean.getQuoteCurrency(), list5);
                            }
                        }
                    }
                }
            }
        }
        Map<String, List<String>> map = f69004e;
        synchronized (map) {
            map.clear();
            map.putAll(hashMap);
        }
        return arrayList;
    }

    public static List<String> g() {
        GridSymbolsConfig gridSymbolsConfig = f69005f;
        if (gridSymbolsConfig != null) {
            return gridSymbolsConfig.getBases();
        }
        return new ArrayList();
    }

    public static Observable<GridSymbolsConfig> h(boolean z11) {
        return Observable.create(new u(z11));
    }

    public static GridSymbolsConfig i() {
        GridSymbolsConfig gridSymbolsConfig;
        synchronized (f69000a) {
            gridSymbolsConfig = f69005f;
        }
        return gridSymbolsConfig;
    }

    public static List<String> j() {
        GridSymbolsConfig gridSymbolsConfig = f69005f;
        if (gridSymbolsConfig != null) {
            return gridSymbolsConfig.getQuotes();
        }
        return new ArrayList();
    }

    public static Map<String, List<String>> k(TradeType tradeType) {
        HashMap hashMap = new HashMap();
        Map<String, List<String>> map = f69004e;
        synchronized (map) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public static List<String> l(TradeType tradeType) {
        ArrayList arrayList = new ArrayList();
        Map<String, SymbolBean> V = a1.v().V(tradeType);
        List<GridSymbolsBean> list = f69001b;
        synchronized (list) {
            if (list.size() > 0) {
                for (GridSymbolsBean symbolCode : list) {
                    SymbolBean symbolBean = V.get(symbolCode.getSymbolCode());
                    if (symbolBean != null) {
                        if (symbolBean.isCanTrade()) {
                            arrayList.add(symbolBean.getSymbol());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static String m() {
        return b1.a().b().b();
    }

    public static List<GridSymbolsBean> n() {
        ArrayList arrayList;
        synchronized (f69000a) {
            arrayList = new ArrayList(f69002c);
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r2 = k(r3).get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> o(java.lang.String r2, com.hbg.lib.data.symbol.TradeType r3) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 == 0) goto L_0x000c
            return r0
        L_0x000c:
            java.util.Map r3 = k(r3)
            java.lang.Object r2 = r3.get(r2)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x0019
            r0 = r2
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.y.o(java.lang.String, com.hbg.lib.data.symbol.TradeType):java.util.List");
    }

    public static boolean p() {
        return f69005f != null;
    }

    public static void q(String str) {
        GridSymbolsConfig c11 = GridSymbolDbHelper.c(str);
        if (c11 != null) {
            v(c11, str);
        }
    }

    public static /* synthetic */ void s(String str, GridSymbolsConfig gridSymbolsConfig) {
        f69005f = gridSymbolsConfig;
        v(gridSymbolsConfig, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void u(boolean r2, rx.Subscriber r3) {
        /*
            java.lang.String r0 = m()
            if (r2 == 0) goto L_0x0017
            boolean r2 = p()
            if (r2 == 0) goto L_0x0017
            com.hbg.lib.network.hbg.grid.bean.GridSymbolsConfig r2 = i()
            r3.onNext(r2)
            r3.onCompleted()
            return
        L_0x0017:
            boolean r2 = p()
            r1 = 0
            if (r2 != 0) goto L_0x002c
            q(r0)
            boolean r2 = p()
            if (r2 == 0) goto L_0x002c
            com.hbg.lib.network.hbg.grid.bean.GridSymbolsConfig r2 = i()
            goto L_0x002d
        L_0x002c:
            r2 = r1
        L_0x002d:
            if (r2 != 0) goto L_0x005b
            com.hbg.lib.network.hbg.IHbgApi r2 = v7.b.a()
            d9.a r2 = r2.getGridSymbols()
            rx.Observable r2 = r2.b()
            d7.x r1 = d7.x.f53540b
            rx.Observable r2 = r2.onErrorReturn(r1)
            d7.w r1 = new d7.w
            r1.<init>(r0)
            rx.Observable r2 = r2.doOnNext(r1)
            rx.Scheduler r0 = rx.schedulers.Schedulers.io()
            rx.Observable r2 = r2.subscribeOn(r0)
            d7.y$a r0 = new d7.y$a
            r0.<init>(r3)
            r2.subscribe(r0)
            goto L_0x0089
        L_0x005b:
            r3.onNext(r2)
            r3.onCompleted()
            v(r2, r0)
            com.hbg.lib.network.hbg.IHbgApi r2 = v7.b.a()
            d9.a r2 = r2.getGridSymbols()
            rx.Observable r2 = r2.b()
            d7.v r3 = new d7.v
            r3.<init>(r0)
            rx.Observable r2 = r2.doOnNext(r3)
            rx.Observable$Transformer r3 = com.hbg.lib.network.retrofit.rxjava.RxJavaHelper.g(r1)
            rx.Observable r2 = r2.compose(r3)
            com.hbg.lib.network.retrofit.rxjava.BaseSubscriber r3 = new com.hbg.lib.network.retrofit.rxjava.BaseSubscriber
            r3.<init>()
            r2.subscribe(r3)
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.y.u(boolean, rx.Subscriber):void");
    }

    public static void v(GridSymbolsConfig gridSymbolsConfig, String str) {
        if (gridSymbolsConfig != null) {
            synchronized (f69000a) {
                List<GridSymbolsBean> list = f69001b;
                list.clear();
                list.addAll(gridSymbolsConfig.getSymbols());
                ArrayList arrayList = new ArrayList();
                Map<String, SymbolBean> V = a1.v().V(TradeType.PRO);
                f69003d.clear();
                for (GridSymbolsBean next : gridSymbolsConfig.getSymbols()) {
                    f69003d.put(next.getSymbolCode(), next);
                    SymbolBean symbolBean = V.get(next.getSymbolCode());
                    if (symbolBean != null) {
                        if (symbolBean.isCanTrade()) {
                            arrayList.add(next);
                        }
                    }
                }
                List<GridSymbolsBean> list2 = f69002c;
                list2.clear();
                list2.addAll(arrayList);
            }
            gridSymbolsConfig.setKey(str);
            long currentTimeMillis = System.currentTimeMillis();
            HbgDbHelper.b(gridSymbolsConfig);
            RetrofitLogger.a("GridSymbolConfigUtil-->setSymbolList--> key: " + str + " 耗时:" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }
}
