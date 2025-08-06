package d7;

import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.R$string;
import com.hbg.lib.data.symbol.SuperMarginSymbolConfigUtil;
import com.hbg.lib.data.symbol.SymbolsDataProvider;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.Partitions;
import com.hbg.lib.network.pro.core.bean.SuperMarginSymbol;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.xiaomi.mipush.sdk.Constants;
import i6.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import rx.Observable;
import rx.schedulers.Schedulers;

public class a1 {

    /* renamed from: u  reason: collision with root package name */
    public static volatile a1 f68962u;

    /* renamed from: a  reason: collision with root package name */
    public final List<SymbolBean> f68963a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<SymbolBean> f68964b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final List<SymbolBean> f68965c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, SymbolBean> f68966d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, SymbolBean> f68967e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final List<SymbolBean> f68968f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, SymbolBean> f68969g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, SymbolBean> f68970h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, SymbolBean> f68971i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public final List<SymbolBean> f68972j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, List<String>> f68973k = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, List<SymbolBean>> f68974l = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    public final Map<String, List<SymbolBean>> f68975m = new HashMap();

    /* renamed from: n  reason: collision with root package name */
    public final Map<String, List<SymbolBean>> f68976n = new HashMap();

    /* renamed from: o  reason: collision with root package name */
    public final Map<String, List<String>> f68977o = new HashMap();

    /* renamed from: p  reason: collision with root package name */
    public final Map<String, List<String>> f68978p = new HashMap();

    /* renamed from: q  reason: collision with root package name */
    public final Map<String, List<String>> f68979q = new HashMap();

    /* renamed from: r  reason: collision with root package name */
    public final Map<String, Map<Long, List<SymbolBean>>> f68980r = new HashMap();

    /* renamed from: s  reason: collision with root package name */
    public final Map<String, List<Partitions>> f68981s = new HashMap();

    /* renamed from: t  reason: collision with root package name */
    public final Map<String, List<SymbolBean>> f68982t = new HashMap();

    public class a implements Comparator<Partitions> {
        public a() {
        }

        /* renamed from: a */
        public int compare(Partitions partitions, Partitions partitions2) {
            return Integer.valueOf(partitions2.getWeight()).intValue() - Integer.valueOf(partitions.getWeight()).intValue();
        }
    }

    public a1() {
        l0();
    }

    public static /* synthetic */ List u0(List list, List list2) {
        return list2;
    }

    public static a1 v() {
        if (f68962u == null) {
            synchronized (a1.class) {
                f68962u = new a1();
            }
        }
        return f68962u;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List v0(List list) {
        x0(list);
        RetrofitLogger.a("SymbolConfigImpl-->getSymbols-->return");
        return list;
    }

    public static /* synthetic */ List w0(List list, List list2) {
        return list;
    }

    public String A(String str) {
        SymbolBean J = J(str, TradeType.PRO);
        return J != null ? J.getSymbolPartition() : "";
    }

    public List<SymbolBean> B(String str, long j11) {
        List list;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        String g11 = StringUtils.g(str);
        synchronized (this.f68980r) {
            Map map = this.f68980r.get(g11);
            if (!(map == null || (list = (List) map.get(Long.valueOf(j11))) == null)) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    public List<Partitions> C(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        String g11 = StringUtils.g(str);
        synchronized (this.f68981s) {
            List list = this.f68981s.get(g11);
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    public String D(String str) {
        SymbolBean J;
        if (!TextUtils.isEmpty(str) && (J = J(str, TradeType.PRO)) != null) {
            return J.getQuoteCurrency();
        }
        return "";
    }

    public String E(String str, TradeType tradeType) {
        SymbolBean J;
        if (!TextUtils.isEmpty(str) && (J = J(str, TradeType.PRO)) != null) {
            return J.getQuoteCurrency();
        }
        return "";
    }

    public String F(String str) {
        SymbolBean J;
        if (!TextUtils.isEmpty(str) && (J = J(str, TradeType.PRO)) != null) {
            return J.getQuoteCurrencyDisplayName();
        }
        return "";
    }

    public final Map<String, List<String>> G(TradeType tradeType) {
        HashMap hashMap = new HashMap();
        if (TradeType.PRO == tradeType) {
            synchronized (this.f68973k) {
                hashMap.putAll(this.f68973k);
            }
        } else if (TradeType.MARGIN == tradeType) {
            synchronized (this.f68977o) {
                hashMap.putAll(this.f68977o);
            }
        } else if (TradeType.SUPERMARGIN == tradeType) {
            synchronized (this.f68978p) {
                hashMap.putAll(this.f68978p);
            }
        } else if (TradeType.isC2C(tradeType)) {
            synchronized (this.f68979q) {
                hashMap.putAll(this.f68979q);
            }
        }
        return hashMap;
    }

    public List<String> H(TradeType tradeType) {
        ArrayList arrayList = new ArrayList();
        if (TradeType.PRO == tradeType) {
            synchronized (this.f68963a) {
                if (this.f68963a.size() > 0) {
                    for (SymbolBean next : this.f68963a) {
                        if (next.isCanTrade()) {
                            arrayList.add(next.getSymbol());
                        }
                    }
                }
            }
        } else if (TradeType.MARGIN == tradeType) {
            synchronized (this.f68965c) {
                if (this.f68965c.size() > 0) {
                    for (SymbolBean next2 : this.f68965c) {
                        if (next2.isCanTrade()) {
                            arrayList.add(next2.getSymbol());
                        }
                    }
                }
            }
        } else if (TradeType.SUPERMARGIN == tradeType) {
            synchronized (this.f68972j) {
                if (this.f68972j.size() > 0) {
                    for (SymbolBean next3 : this.f68972j) {
                        if (next3.isCanTrade()) {
                            arrayList.add(next3.getSymbol());
                        }
                    }
                }
            }
        } else if (TradeType.isC2C(tradeType)) {
            synchronized (this.f68968f) {
                for (SymbolBean next4 : this.f68968f) {
                    if (next4.isCanTrade()) {
                        arrayList.add(next4.getSymbol());
                    }
                }
            }
        } else if (TradeType.INDEX == tradeType) {
            synchronized (this.f68964b) {
                if (this.f68964b.size() > 0) {
                    for (SymbolBean symbol : this.f68964b) {
                        arrayList.add(symbol.getSymbol());
                    }
                }
            }
        }
        return arrayList;
    }

    public String I(String str, TradeType tradeType) {
        List<SymbolBean> Z;
        if (!TextUtils.isEmpty(str) && (Z = Z(TradeType.PRO)) != null) {
            for (SymbolBean next : Z) {
                if (str.equals(next.getSymbolName())) {
                    return next.getSymbol();
                }
            }
        }
        return "";
    }

    public SymbolBean J(String str, TradeType tradeType) {
        SymbolBean symbolBean;
        SymbolBean symbolBean2;
        SymbolBean symbolBean3;
        SymbolBean symbolBean4;
        SymbolBean symbolBean5;
        if (TradeType.PRO == tradeType) {
            synchronized (this.f68970h) {
                symbolBean5 = this.f68970h.get(str);
            }
            return symbolBean5;
        } else if (TradeType.MARGIN == tradeType) {
            synchronized (this.f68967e) {
                symbolBean4 = this.f68967e.get(str);
            }
            return symbolBean4;
        } else if (TradeType.SUPERMARGIN == tradeType) {
            synchronized (this.f68971i) {
                symbolBean3 = this.f68971i.get(str);
            }
            return symbolBean3;
        } else if (TradeType.isC2C(tradeType)) {
            synchronized (this.f68969g) {
                symbolBean2 = this.f68969g.get(str);
            }
            return symbolBean2;
        } else if (!TradeType.isIndex(tradeType)) {
            return null;
        } else {
            synchronized (this.f68966d) {
                symbolBean = this.f68966d.get(str);
            }
            return symbolBean;
        }
    }

    public String K(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a1 v11 = v();
        StringBuilder sb2 = new StringBuilder();
        Locale locale = Locale.US;
        sb2.append(str.toLowerCase(locale));
        sb2.append("usdt");
        String sb3 = sb2.toString();
        TradeType tradeType = TradeType.PRO;
        SymbolBean J = v11.J(sb3, tradeType);
        if (J != null) {
            return J.getSymbol();
        }
        a1 v12 = v();
        SymbolBean J2 = v12.J(str.toLowerCase(locale) + "btc", tradeType);
        if (J2 != null) {
            return J2.getSymbol();
        }
        a1 v13 = v();
        SymbolBean J3 = v13.J(str.toLowerCase(locale) + "eth", tradeType);
        if (J3 != null) {
            return J3.getSymbol();
        }
        a1 v14 = v();
        SymbolBean J4 = v14.J(str.toLowerCase(locale) + "husd", tradeType);
        if (J4 != null) {
            return J4.getSymbol();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean L(java.lang.String r3) {
        /*
            r2 = this;
            java.util.Map<java.lang.String, com.hbg.lib.network.pro.core.bean.SymbolBean> r0 = r2.f68970h
            monitor-enter(r0)
            java.util.Map<java.lang.String, com.hbg.lib.network.pro.core.bean.SymbolBean> r1 = r2.f68970h     // Catch:{ all -> 0x0019 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0019 }
            com.hbg.lib.network.pro.core.bean.SymbolBean r3 = (com.hbg.lib.network.pro.core.bean.SymbolBean) r3     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0016
            boolean r3 = r3.isPrimeTag()     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0016
            r3 = 1
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r3
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            r3 = 0
            return r3
        L_0x0019:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.a1.L(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean M(java.lang.String r3) {
        /*
            r2 = this;
            java.util.Map<java.lang.String, com.hbg.lib.network.pro.core.bean.SymbolBean> r0 = r2.f68970h
            monitor-enter(r0)
            java.util.Map<java.lang.String, com.hbg.lib.network.pro.core.bean.SymbolBean> r1 = r2.f68970h     // Catch:{ all -> 0x0019 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0019 }
            com.hbg.lib.network.pro.core.bean.SymbolBean r3 = (com.hbg.lib.network.pro.core.bean.SymbolBean) r3     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0016
            boolean r3 = r3.isHadSt()     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0016
            r3 = 1
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r3
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            r3 = 0
            return r3
        L_0x0019:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.a1.M(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean N(java.lang.String r3) {
        /*
            r2 = this;
            java.util.Map<java.lang.String, com.hbg.lib.network.pro.core.bean.SymbolBean> r0 = r2.f68970h
            monitor-enter(r0)
            java.util.Map<java.lang.String, com.hbg.lib.network.pro.core.bean.SymbolBean> r1 = r2.f68970h     // Catch:{ all -> 0x0019 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0019 }
            com.hbg.lib.network.pro.core.bean.SymbolBean r3 = (com.hbg.lib.network.pro.core.bean.SymbolBean) r3     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0016
            boolean r3 = r3.isHadaxTag()     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0016
            r3 = 1
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r3
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            r3 = 0
            return r3
        L_0x0019:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.a1.N(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean O(java.lang.String r3) {
        /*
            r2 = this;
            java.util.Map<java.lang.String, com.hbg.lib.network.pro.core.bean.SymbolBean> r0 = r2.f68970h
            monitor-enter(r0)
            java.util.Map<java.lang.String, com.hbg.lib.network.pro.core.bean.SymbolBean> r1 = r2.f68970h     // Catch:{ all -> 0x0019 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0019 }
            com.hbg.lib.network.pro.core.bean.SymbolBean r3 = (com.hbg.lib.network.pro.core.bean.SymbolBean) r3     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0016
            boolean r3 = r3.isInnovateTag()     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0016
            r3 = 1
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r3
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            r3 = 0
            return r3
        L_0x0019:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.a1.O(java.lang.String):boolean");
    }

    public boolean P(String str) {
        return b1.a().b().c(str);
    }

    public boolean Q(String str) {
        return b1.a().b().f(str);
    }

    public boolean R(String str) {
        return b1.a().b().d(str);
    }

    public boolean S(String str) {
        return Q(str) || R(str) || P(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean T(java.lang.String r3) {
        /*
            r2 = this;
            java.util.Map<java.lang.String, com.hbg.lib.network.pro.core.bean.SymbolBean> r0 = r2.f68970h
            monitor-enter(r0)
            java.util.Map<java.lang.String, com.hbg.lib.network.pro.core.bean.SymbolBean> r1 = r2.f68970h     // Catch:{ all -> 0x0019 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0019 }
            com.hbg.lib.network.pro.core.bean.SymbolBean r3 = (com.hbg.lib.network.pro.core.bean.SymbolBean) r3     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0016
            boolean r3 = r3.isStTag()     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0016
            r3 = 1
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r3
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            r3 = 0
            return r3
        L_0x0019:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.a1.T(java.lang.String):boolean");
    }

    public final String U() {
        try {
            return b1.a().b().b();
        } catch (Exception unused) {
            return "";
        }
    }

    public Map<String, SymbolBean> V(TradeType tradeType) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        if (TradeType.PRO == tradeType) {
            synchronized (this.f68970h) {
                hashMap4 = new HashMap(this.f68970h);
            }
            return hashMap4;
        } else if (TradeType.MARGIN == tradeType) {
            synchronized (this.f68967e) {
                hashMap3 = new HashMap(this.f68967e);
            }
            return hashMap3;
        } else if (TradeType.SUPERMARGIN == tradeType) {
            synchronized (this.f68971i) {
                hashMap2 = new HashMap(this.f68971i);
            }
            return hashMap2;
        } else if (!TradeType.isC2C(tradeType)) {
            return this.f68970h;
        } else {
            synchronized (this.f68969g) {
                hashMap = new HashMap(this.f68969g);
            }
            return hashMap;
        }
    }

    public String W(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        synchronized (this.f68970h) {
            SymbolBean symbolBean = this.f68970h.get(str);
            if (symbolBean != null) {
                str2 = symbolBean.getSymbolName();
            }
        }
        return str2;
    }

    public String X(String str, TradeType tradeType) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        SymbolBean J = J(str, tradeType);
        if (J != null) {
            str2 = J.getSymbolName();
        }
        if (!TradeType.isIndex(tradeType)) {
            return str2;
        }
        l0();
        return this.f68966d.get(str) != null ? this.f68966d.get(str).getSymbolName() : str2;
    }

    public Observable<List<SymbolBean>> Y(boolean z11, boolean z12) {
        return Observable.zip(SuperMarginSymbolConfigUtil.g(z11).subscribeOn(Schedulers.io()), SymbolsDataProvider.h(z11, U()).subscribeOn(Schedulers.io()).onErrorResumeNext(Observable.just(null)), y0.f53542b).map(new x0(this));
    }

    public List<SymbolBean> Z(TradeType tradeType) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        if (TradeType.PRO == tradeType) {
            synchronized (this.f68963a) {
                arrayList6 = new ArrayList(this.f68963a);
            }
            return arrayList6;
        } else if (TradeType.MARGIN == tradeType) {
            synchronized (this.f68965c) {
                arrayList5 = new ArrayList(this.f68965c);
            }
            return arrayList5;
        } else if (TradeType.SUPERMARGIN == tradeType) {
            synchronized (this.f68972j) {
                arrayList4 = new ArrayList(this.f68972j);
            }
            return arrayList4;
        } else if (TradeType.isC2C(tradeType)) {
            synchronized (this.f68968f) {
                arrayList3 = new ArrayList(this.f68968f);
            }
            return arrayList3;
        } else if (TradeType.INDEX == tradeType) {
            synchronized (this.f68964b) {
                arrayList2 = new ArrayList(this.f68964b);
            }
            return arrayList2;
        } else {
            synchronized (this.f68963a) {
                arrayList = new ArrayList(this.f68963a);
            }
            return arrayList;
        }
    }

    public String a0(TradeType tradeType, String str) {
        List<SymbolBean> Z = Z(tradeType);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (SymbolBean next : Z) {
            if (str.equalsIgnoreCase(next.getBaseCurrency()) && next.isCanTrade()) {
                arrayList.add(next);
            }
            if (str.equalsIgnoreCase(next.getQuoteCurrency()) && next.isCanTrade()) {
                arrayList2.add(next);
            }
            if (next.isCanTrade()) {
                arrayList3.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            return ((SymbolBean) arrayList.get(0)).getSymbol();
        }
        if (!arrayList2.isEmpty()) {
            return ((SymbolBean) arrayList2.get(0)).getSymbol();
        }
        return !arrayList3.isEmpty() ? ((SymbolBean) arrayList3.get(0)).getSymbol() : "";
    }

    public int b0(String str, TradeType tradeType) {
        SymbolBean J = J(str, tradeType);
        if (J != null) {
            return J.getTradeAmountPrecision();
        }
        return 8;
    }

    public List<String> c0() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (SymbolBean symbolBean : new ArrayList(this.f68968f)) {
            if (symbolBean.isCanTrade()) {
                if (symbolBean.isFiatTag()) {
                    List list = (List) hashMap.get(SymbolBean.FIAT);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    if (!arrayList.contains(SymbolBean.FIAT)) {
                        arrayList.add(SymbolBean.FIAT);
                    }
                    if (!list.contains(symbolBean.getSymbol())) {
                        list.add(symbolBean.getSymbol());
                        hashMap.put(SymbolBean.FIAT, list);
                    }
                } else if (symbolBean.isAltsTag()) {
                    List list2 = (List) hashMap.get(SymbolBean.ALTS);
                    if (list2 == null) {
                        list2 = new ArrayList();
                    }
                    if (!arrayList.contains(SymbolBean.ALTS)) {
                        arrayList.add(SymbolBean.ALTS);
                    }
                    if (!list2.contains(symbolBean.getSymbol())) {
                        list2.add(symbolBean.getSymbol());
                        hashMap.put(SymbolBean.ALTS, list2);
                    }
                } else if (symbolBean.isCryptoTag()) {
                    List list3 = (List) hashMap.get(SymbolBean.CRYPTO);
                    if (list3 == null) {
                        list3 = new ArrayList();
                    }
                    if (!arrayList.contains(SymbolBean.CRYPTO)) {
                        arrayList.add(SymbolBean.CRYPTO);
                    }
                    if (!list3.contains(symbolBean.getSymbol())) {
                        list3.add(symbolBean.getSymbol());
                        hashMap.put(SymbolBean.CRYPTO, list3);
                    }
                } else {
                    List list4 = (List) hashMap.get(symbolBean.getQuoteCurrency());
                    if (list4 == null) {
                        list4 = new ArrayList();
                    }
                    if (!arrayList.contains(symbolBean.getQuoteCurrency())) {
                        arrayList.add(symbolBean.getQuoteCurrency());
                    }
                    if (!list4.contains(symbolBean.getSymbol())) {
                        list4.add(symbolBean.getSymbol());
                        hashMap.put(symbolBean.getQuoteCurrency(), list4);
                    }
                }
            }
        }
        synchronized (this.f68979q) {
            this.f68979q.clear();
            this.f68979q.putAll(hashMap);
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r3 = G(r4).get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> d0(java.lang.String r3, com.hbg.lib.data.symbol.TradeType r4) {
        /*
            r2 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L_0x000c
            return r0
        L_0x000c:
            java.util.Map r4 = r2.G(r4)
            java.lang.Object r3 = r4.get(r3)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x0019
            r0 = r3
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.a1.d0(java.lang.String, com.hbg.lib.data.symbol.TradeType):java.util.List");
    }

    public List<SymbolBean> e0(TradeType tradeType) {
        ArrayList arrayList = new ArrayList();
        if (TradeType.PRO == tradeType) {
            synchronized (this.f68963a) {
                if (this.f68963a.size() > 0) {
                    for (SymbolBean next : this.f68963a) {
                        if (next.isCanTrade()) {
                            arrayList.add(next);
                        }
                    }
                }
            }
        } else if (TradeType.MARGIN == tradeType) {
            synchronized (this.f68965c) {
                if (this.f68965c.size() > 0) {
                    for (SymbolBean next2 : this.f68965c) {
                        if (next2.isCanTrade()) {
                            arrayList.add(next2);
                        }
                    }
                }
            }
        } else if (TradeType.SUPERMARGIN == tradeType) {
            synchronized (this.f68972j) {
                if (this.f68972j.size() > 0) {
                    for (SymbolBean next3 : this.f68972j) {
                        if (next3.isCanTrade()) {
                            arrayList.add(next3);
                        }
                    }
                }
            }
        } else if (TradeType.isC2C(tradeType)) {
            synchronized (this.f68968f) {
                for (SymbolBean next4 : this.f68968f) {
                    if (next4.isCanTrade()) {
                        arrayList.add(next4);
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean f(String str) {
        return Q(str) || R(str);
    }

    public List<String> f0() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        ArrayList<SymbolBean> arrayList2 = new ArrayList<>(this.f68965c);
        if (!arrayList2.isEmpty()) {
            for (SymbolBean symbolBean : arrayList2) {
                if (symbolBean.isCanTrade()) {
                    if (symbolBean.isFiatTag()) {
                        List list = (List) hashMap.get(SymbolBean.FIAT);
                        if (list == null) {
                            list = new ArrayList();
                        }
                        if (!arrayList.contains(SymbolBean.FIAT)) {
                            arrayList.add(SymbolBean.FIAT);
                        }
                        if (!list.contains(symbolBean.getSymbol())) {
                            list.add(symbolBean.getSymbol());
                            hashMap.put(SymbolBean.FIAT, list);
                        }
                    } else if (symbolBean.isAltsTag()) {
                        List list2 = (List) hashMap.get(SymbolBean.ALTS);
                        if (list2 == null) {
                            list2 = new ArrayList();
                        }
                        if (!arrayList.contains(SymbolBean.ALTS)) {
                            arrayList.add(SymbolBean.ALTS);
                        }
                        if (!list2.contains(symbolBean.getSymbol())) {
                            list2.add(symbolBean.getSymbol());
                            hashMap.put(SymbolBean.ALTS, list2);
                        }
                    } else if (symbolBean.isCryptoTag()) {
                        List list3 = (List) hashMap.get(SymbolBean.CRYPTO);
                        if (list3 == null) {
                            list3 = new ArrayList();
                        }
                        if (!arrayList.contains(SymbolBean.CRYPTO)) {
                            arrayList.add(SymbolBean.CRYPTO);
                        }
                        if (!list3.contains(symbolBean.getSymbol())) {
                            list3.add(symbolBean.getSymbol());
                            hashMap.put(SymbolBean.CRYPTO, list3);
                        }
                    } else {
                        List list4 = (List) hashMap.get(symbolBean.getQuoteCurrency());
                        if (list4 == null) {
                            list4 = new ArrayList();
                        }
                        if (!arrayList.contains(symbolBean.getQuoteCurrency())) {
                            arrayList.add(symbolBean.getQuoteCurrency());
                        }
                        if (!list4.contains(symbolBean.getSymbol())) {
                            list4.add(symbolBean.getSymbol());
                            hashMap.put(symbolBean.getQuoteCurrency(), list4);
                        }
                    }
                }
            }
        }
        synchronized (this.f68977o) {
            this.f68977o.clear();
            this.f68977o.putAll(hashMap);
        }
        return arrayList;
    }

    public void g() {
        synchronized (this.f68963a) {
            this.f68963a.clear();
        }
        synchronized (this.f68965c) {
            this.f68965c.clear();
        }
        synchronized (this.f68970h) {
            this.f68970h.clear();
        }
        synchronized (this.f68967e) {
            this.f68967e.clear();
        }
        synchronized (this.f68971i) {
            this.f68971i.clear();
        }
        synchronized (this.f68978p) {
            this.f68978p.clear();
        }
        synchronized (this.f68973k) {
            this.f68973k.clear();
        }
        synchronized (this.f68974l) {
            this.f68974l.clear();
        }
        synchronized (this.f68975m) {
            this.f68975m.clear();
        }
        synchronized (this.f68976n) {
            this.f68976n.clear();
        }
        synchronized (this.f68977o) {
            this.f68977o.clear();
        }
        synchronized (this.f68972j) {
            this.f68972j.clear();
        }
        synchronized (this.f68968f) {
            this.f68968f.clear();
        }
        synchronized (this.f68969g) {
            this.f68969g.clear();
        }
        SymbolsDataProvider.g();
    }

    public String g0() {
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        synchronized (this.f68965c) {
            if (this.f68965c.size() > 0) {
                for (SymbolBean symbol : this.f68965c) {
                    arrayList.add(symbol.getSymbol());
                }
            }
        }
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (i11 == size - 1) {
                sb2.append((String) arrayList.get(i11));
            } else {
                sb2.append((String) arrayList.get(i11));
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        return sb2.toString();
    }

    public final void h(List<SymbolBean> list) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        Map<String, SuperMarginSymbol> f11 = SuperMarginSymbolConfigUtil.f();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        HashMap hashMap5 = new HashMap();
        if (list != null) {
            for (SymbolBean next : list) {
                hashMap.put(next.getSymbol(), next);
                if (f11.get(next.getSymbol()) != null) {
                    next.setSuperMarginLeverageRatio(f11.get(next.getSymbol()).getLoanMultiple());
                    hashMap3.put(next.getSymbol(), next);
                    arrayList3.add(next);
                }
                if (!TextUtils.isEmpty(next.getLeverageRatio())) {
                    hashMap2.put(next.getSymbol(), next);
                    arrayList2.add(next);
                }
                if (!TextUtils.isEmpty(next.getFundingLeverageRatio())) {
                    hashMap4.put(next.getSymbol(), next);
                    arrayList.add(next);
                }
                if (next.isEtpTag()) {
                    String z11 = z(next.getBaseCurrency(), next.getEtpLeverageRatio());
                    if (!TextUtils.isEmpty(z11)) {
                        List list2 = (List) hashMap5.get(z11);
                        if (list2 == null) {
                            list2 = new ArrayList();
                        }
                        list2.add(next);
                        hashMap5.put(z11, list2);
                    }
                }
            }
        }
        synchronized (this.f68970h) {
            this.f68970h.clear();
            this.f68970h.putAll(hashMap);
        }
        synchronized (this.f68965c) {
            this.f68965c.clear();
            this.f68965c.addAll(arrayList2);
        }
        synchronized (this.f68967e) {
            this.f68967e.clear();
            this.f68967e.putAll(hashMap2);
        }
        synchronized (this.f68969g) {
            this.f68969g.clear();
            this.f68969g.putAll(hashMap4);
        }
        synchronized (this.f68968f) {
            this.f68968f.clear();
            this.f68968f.addAll(arrayList);
        }
        synchronized (this.f68971i) {
            this.f68971i.clear();
            this.f68971i.putAll(hashMap3);
        }
        synchronized (this.f68972j) {
            this.f68972j.clear();
            this.f68972j.addAll(arrayList3);
        }
        synchronized (this.f68982t) {
            this.f68982t.clear();
            this.f68982t.putAll(hashMap5);
        }
    }

    public int h0(String str, TradeType tradeType) {
        SymbolBean J = J(str, tradeType);
        int tradePricePrecision = J != null ? J.getTradePricePrecision() : 8;
        if (TradeType.INDEX == tradeType) {
            return 2;
        }
        return tradePricePrecision;
    }

    public List<String> i() {
        return l(TradeType.PRO);
    }

    public List<String> i0() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        ArrayList<SymbolBean> arrayList2 = new ArrayList<>(this.f68972j);
        if (!arrayList2.isEmpty()) {
            for (SymbolBean symbolBean : arrayList2) {
                if (symbolBean.isCanTrade()) {
                    if (symbolBean.isFiatTag()) {
                        List list = (List) hashMap.get(SymbolBean.FIAT);
                        if (list == null) {
                            list = new ArrayList();
                        }
                        if (!arrayList.contains(SymbolBean.FIAT)) {
                            arrayList.add(SymbolBean.FIAT);
                        }
                        if (!list.contains(symbolBean.getSymbol())) {
                            list.add(symbolBean.getSymbol());
                            hashMap.put(SymbolBean.FIAT, list);
                        }
                    } else if (symbolBean.isAltsTag()) {
                        List list2 = (List) hashMap.get(SymbolBean.ALTS);
                        if (list2 == null) {
                            list2 = new ArrayList();
                        }
                        if (!arrayList.contains(SymbolBean.ALTS)) {
                            arrayList.add(SymbolBean.ALTS);
                        }
                        if (!list2.contains(symbolBean.getSymbol())) {
                            list2.add(symbolBean.getSymbol());
                            hashMap.put(SymbolBean.ALTS, list2);
                        }
                    } else if (symbolBean.isCryptoTag()) {
                        List list3 = (List) hashMap.get(SymbolBean.CRYPTO);
                        if (list3 == null) {
                            list3 = new ArrayList();
                        }
                        if (!arrayList.contains(SymbolBean.CRYPTO)) {
                            arrayList.add(SymbolBean.CRYPTO);
                        }
                        if (!list3.contains(symbolBean.getSymbol())) {
                            list3.add(symbolBean.getSymbol());
                            hashMap.put(SymbolBean.CRYPTO, list3);
                        }
                    } else {
                        List list4 = (List) hashMap.get(symbolBean.getQuoteCurrency());
                        if (list4 == null) {
                            list4 = new ArrayList();
                        }
                        if (!arrayList.contains(symbolBean.getQuoteCurrency())) {
                            arrayList.add(symbolBean.getQuoteCurrency());
                        }
                        if (!list4.contains(symbolBean.getSymbol())) {
                            list4.add(symbolBean.getSymbol());
                            hashMap.put(symbolBean.getQuoteCurrency(), list4);
                        }
                    }
                }
            }
        }
        synchronized (this.f68978p) {
            this.f68978p.clear();
            this.f68978p.putAll(hashMap);
        }
        return arrayList;
    }

    public List<String> j() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f68963a) {
            if (this.f68963a.size() > 0) {
                for (SymbolBean next : this.f68963a) {
                    if (!arrayList.contains(next.getQuoteCurrency())) {
                        arrayList.add(next.getQuoteCurrency());
                    }
                }
            }
        }
        return arrayList;
    }

    public int j0(String str, TradeType tradeType) {
        SymbolBean J = J(str, tradeType);
        if (J != null) {
            return J.getTradeTotalPrecision();
        }
        return 8;
    }

    public Map<String, List<SymbolBean>> k() {
        return this.f68974l;
    }

    public boolean k0(String str) {
        return p0(str) || str.contains("hb10");
    }

    public List<String> l(TradeType tradeType) {
        ArrayList arrayList = new ArrayList();
        if (TradeType.PRO == tradeType) {
            synchronized (this.f68963a) {
                if (this.f68963a.size() > 0) {
                    for (SymbolBean symbol : this.f68963a) {
                        arrayList.add(symbol.getSymbol());
                    }
                }
            }
        } else if (TradeType.MARGIN == tradeType) {
            synchronized (this.f68965c) {
                if (this.f68965c.size() > 0) {
                    for (SymbolBean symbol2 : this.f68965c) {
                        arrayList.add(symbol2.getSymbol());
                    }
                }
            }
        } else if (TradeType.SUPERMARGIN == tradeType) {
            synchronized (this.f68972j) {
                if (!this.f68972j.isEmpty()) {
                    for (SymbolBean symbol3 : this.f68972j) {
                        arrayList.add(symbol3.getSymbol());
                    }
                }
            }
        } else if (TradeType.isC2C(tradeType)) {
            synchronized (this.f68968f) {
                for (SymbolBean symbol4 : this.f68968f) {
                    arrayList.add(symbol4.getSymbol());
                }
            }
        } else if (TradeType.INDEX == tradeType) {
            synchronized (this.f68964b) {
                if (this.f68964b.size() > 0) {
                    for (SymbolBean symbol5 : this.f68964b) {
                        arrayList.add(symbol5.getSymbol());
                    }
                }
            }
        }
        return arrayList;
    }

    public final void l0() {
        SymbolBean symbolBean = new SymbolBean();
        symbolBean.setSymbol("huobi10");
        symbolBean.setSymbolName(BaseApplication.b().getResources().getString(R$string.symbol_name_huobi_index));
        synchronized (this.f68964b) {
            this.f68964b.clear();
            this.f68964b.add(symbolBean);
        }
        synchronized (this.f68966d) {
            this.f68966d.clear();
            this.f68966d.put(symbolBean.getSymbol(), symbolBean);
        }
    }

    public List<String> m() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        synchronized (this.f68963a) {
            for (SymbolBean next : this.f68963a) {
                if (next.isCanTrade()) {
                    if (next.isFiatTag()) {
                        List list = (List) hashMap.get(SymbolBean.FIAT);
                        if (list == null) {
                            list = new ArrayList();
                        }
                        if (!arrayList.contains(SymbolBean.FIAT)) {
                            arrayList.add(SymbolBean.FIAT);
                        }
                        if (!list.contains(next.getSymbol())) {
                            list.add(next.getSymbol());
                            hashMap.put(SymbolBean.FIAT, list);
                        }
                    } else if (next.isAltsTag()) {
                        List list2 = (List) hashMap.get(SymbolBean.ALTS);
                        if (list2 == null) {
                            list2 = new ArrayList();
                        }
                        if (!arrayList.contains(SymbolBean.ALTS)) {
                            arrayList.add(SymbolBean.ALTS);
                        }
                        if (!list2.contains(next.getSymbol())) {
                            list2.add(next.getSymbol());
                            hashMap.put(SymbolBean.ALTS, list2);
                        }
                    } else if (next.isCryptoTag()) {
                        List list3 = (List) hashMap.get(SymbolBean.CRYPTO);
                        if (list3 == null) {
                            list3 = new ArrayList();
                        }
                        if (!arrayList.contains(SymbolBean.CRYPTO)) {
                            arrayList.add(SymbolBean.CRYPTO);
                        }
                        if (!list3.contains(next.getSymbol())) {
                            list3.add(next.getSymbol());
                            hashMap.put(SymbolBean.CRYPTO, list3);
                        }
                    } else {
                        List list4 = (List) hashMap.get(next.getQuoteCurrency());
                        if (list4 == null) {
                            list4 = new ArrayList();
                        }
                        if (!arrayList.contains(next.getQuoteCurrency())) {
                            arrayList.add(next.getQuoteCurrency());
                        }
                        if (!list4.contains(next.getSymbol())) {
                            list4.add(next.getSymbol());
                            hashMap.put(next.getQuoteCurrency(), list4);
                        }
                    }
                }
            }
        }
        if (arrayList.remove(SymbolBean.ALTS)) {
            arrayList.add(SymbolBean.ALTS);
        }
        if (arrayList.remove(SymbolBean.FIAT)) {
            arrayList.add(SymbolBean.FIAT);
        }
        if (arrayList.remove(SymbolBean.CRYPTO)) {
            arrayList.add(SymbolBean.CRYPTO);
        }
        synchronized (this.f68973k) {
            this.f68973k.clear();
            this.f68973k.putAll(hashMap);
        }
        return arrayList;
    }

    public final void m0() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (this.f68963a) {
            if (this.f68963a.size() > 0) {
                for (SymbolBean next : this.f68963a) {
                    if (next.isCanTrade()) {
                        String quoteCurrency = next.getQuoteCurrency();
                        Map map = (Map) hashMap.get(quoteCurrency);
                        if (map == null) {
                            map = new HashMap();
                        }
                        List list = (List) hashMap2.get(quoteCurrency);
                        if (list == null) {
                            list = new ArrayList();
                        }
                        List<Partitions> partitions = next.getPartitions();
                        if (partitions != null) {
                            for (Partitions next2 : partitions) {
                                List list2 = (List) map.get(next2.getId());
                                if (list2 == null) {
                                    list2 = new ArrayList();
                                }
                                list2.add(next);
                                map.put(next2.getId(), list2);
                                if (!list.contains(next2)) {
                                    list.add(next2);
                                }
                            }
                        }
                        hashMap.put(quoteCurrency, map);
                        try {
                            Collections.sort(list, new a());
                        } catch (Exception e11) {
                            d.b(e11.toString());
                        }
                        hashMap2.put(quoteCurrency, list);
                    }
                }
            }
        }
        synchronized (this.f68980r) {
            this.f68980r.clear();
            this.f68980r.putAll(hashMap);
        }
        synchronized (this.f68981s) {
            this.f68981s.clear();
            this.f68981s.putAll(hashMap2);
        }
    }

    public String n(String str) {
        SymbolBean J;
        if (!TextUtils.isEmpty(str) && (J = J(str, TradeType.PRO)) != null) {
            return J.getBaseCurrency();
        }
        return "";
    }

    public final void n0() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        HashMap hashMap6 = new HashMap();
        synchronized (this.f68963a) {
            if (this.f68963a.size() > 0) {
                for (SymbolBean next : this.f68963a) {
                    if (next.isCanTrade()) {
                        if (next.isCryptoTag()) {
                            List list = (List) hashMap.get(SymbolBean.CRYPTO);
                            List list2 = (List) hashMap4.get(SymbolBean.CRYPTO);
                            if (list == null) {
                                list = new ArrayList();
                            }
                            if (list2 == null) {
                                list2 = new ArrayList();
                            }
                            if (!list2.contains(next.getSymbol())) {
                                list.add(next);
                                list2.add(next.getSymbol());
                                hashMap4.put(SymbolBean.CRYPTO, list2);
                                hashMap.put(SymbolBean.CRYPTO, list);
                            }
                            if (next.isHadaxTag()) {
                                List list3 = (List) hashMap3.get(SymbolBean.CRYPTO);
                                List list4 = (List) hashMap6.get(SymbolBean.CRYPTO);
                                if (list3 == null) {
                                    list3 = new ArrayList();
                                }
                                if (list4 == null) {
                                    list4 = new ArrayList();
                                }
                                if (!list4.contains(next.getSymbol())) {
                                    list3.add(next);
                                    list4.add(next.getSymbol());
                                    hashMap6.put(SymbolBean.CRYPTO, list4);
                                    hashMap3.put(SymbolBean.CRYPTO, list3);
                                }
                            } else {
                                List list5 = (List) hashMap2.get(SymbolBean.CRYPTO);
                                List list6 = (List) hashMap5.get(SymbolBean.CRYPTO);
                                if (list5 == null) {
                                    list5 = new ArrayList();
                                }
                                if (list6 == null) {
                                    list6 = new ArrayList();
                                }
                                if (!list6.contains(next.getSymbol())) {
                                    list5.add(next);
                                    list6.add(next.getSymbol());
                                    hashMap5.put(SymbolBean.CRYPTO, list6);
                                    hashMap2.put(SymbolBean.CRYPTO, list5);
                                }
                            }
                        } else if (next.isFiatTag()) {
                            List list7 = (List) hashMap.get(SymbolBean.FIAT);
                            List list8 = (List) hashMap4.get(SymbolBean.FIAT);
                            if (list7 == null) {
                                list7 = new ArrayList();
                            }
                            if (list8 == null) {
                                list8 = new ArrayList();
                            }
                            if (!list8.contains(next.getSymbol())) {
                                list7.add(next);
                                list8.add(next.getSymbol());
                                hashMap4.put(SymbolBean.FIAT, list8);
                                hashMap.put(SymbolBean.FIAT, list7);
                            }
                            if (next.isHadaxTag()) {
                                List list9 = (List) hashMap3.get(SymbolBean.FIAT);
                                List list10 = (List) hashMap6.get(SymbolBean.FIAT);
                                if (list9 == null) {
                                    list9 = new ArrayList();
                                }
                                if (list10 == null) {
                                    list10 = new ArrayList();
                                }
                                if (!list10.contains(next.getSymbol())) {
                                    list9.add(next);
                                    list10.add(next.getSymbol());
                                    hashMap6.put(SymbolBean.FIAT, list10);
                                    hashMap3.put(SymbolBean.FIAT, list9);
                                }
                            } else {
                                List list11 = (List) hashMap2.get(SymbolBean.FIAT);
                                List list12 = (List) hashMap5.get(SymbolBean.FIAT);
                                if (list11 == null) {
                                    list11 = new ArrayList();
                                }
                                if (list12 == null) {
                                    list12 = new ArrayList();
                                }
                                if (!list12.contains(next.getSymbol())) {
                                    list11.add(next);
                                    list12.add(next.getSymbol());
                                    hashMap5.put(SymbolBean.FIAT, list12);
                                    hashMap2.put(SymbolBean.FIAT, list11);
                                }
                            }
                        } else if (next.isAltsTag()) {
                            List list13 = (List) hashMap.get(SymbolBean.ALTS);
                            List list14 = (List) hashMap4.get(SymbolBean.ALTS);
                            if (list13 == null) {
                                list13 = new ArrayList();
                            }
                            if (list14 == null) {
                                list14 = new ArrayList();
                            }
                            if (!list14.contains(next.getSymbol())) {
                                list13.add(next);
                                list14.add(next.getSymbol());
                                hashMap4.put(SymbolBean.ALTS, list14);
                                hashMap.put(SymbolBean.ALTS, list13);
                            }
                            if (next.isHadaxTag()) {
                                List list15 = (List) hashMap3.get(SymbolBean.ALTS);
                                List list16 = (List) hashMap6.get(SymbolBean.ALTS);
                                if (list15 == null) {
                                    list15 = new ArrayList();
                                }
                                if (list16 == null) {
                                    list16 = new ArrayList();
                                }
                                if (!list16.contains(next.getSymbol())) {
                                    list15.add(next);
                                    list16.add(next.getSymbol());
                                    hashMap6.put(SymbolBean.ALTS, list16);
                                    hashMap3.put(SymbolBean.ALTS, list15);
                                }
                            } else {
                                List list17 = (List) hashMap2.get(SymbolBean.ALTS);
                                List list18 = (List) hashMap5.get(SymbolBean.ALTS);
                                if (list17 == null) {
                                    list17 = new ArrayList();
                                }
                                if (list18 == null) {
                                    list18 = new ArrayList();
                                }
                                if (!list18.contains(next.getSymbol())) {
                                    list17.add(next);
                                    list18.add(next.getSymbol());
                                    hashMap5.put(SymbolBean.ALTS, list18);
                                    hashMap2.put(SymbolBean.ALTS, list17);
                                }
                            }
                        } else {
                            List list19 = (List) hashMap.get(next.getQuoteCurrency());
                            List list20 = (List) hashMap4.get(next.getQuoteCurrency());
                            if (list19 == null) {
                                list19 = new ArrayList();
                            }
                            if (list20 == null) {
                                list20 = new ArrayList();
                            }
                            if (!list20.contains(next.getSymbol())) {
                                list19.add(next);
                                list20.add(next.getSymbol());
                                hashMap4.put(next.getQuoteCurrency(), list20);
                                hashMap.put(next.getQuoteCurrency(), list19);
                            }
                            if (next.isHadaxTag()) {
                                List list21 = (List) hashMap3.get(next.getQuoteCurrency());
                                List list22 = (List) hashMap6.get(next.getQuoteCurrency());
                                if (list21 == null) {
                                    list21 = new ArrayList();
                                }
                                if (list22 == null) {
                                    list22 = new ArrayList();
                                }
                                if (!list22.contains(next.getSymbol())) {
                                    list21.add(next);
                                    list22.add(next.getSymbol());
                                    hashMap6.put(next.getQuoteCurrency(), list22);
                                    hashMap3.put(next.getQuoteCurrency(), list21);
                                }
                            } else {
                                List list23 = (List) hashMap2.get(next.getQuoteCurrency());
                                List list24 = (List) hashMap5.get(next.getQuoteCurrency());
                                if (list23 == null) {
                                    list23 = new ArrayList();
                                }
                                if (list24 == null) {
                                    list24 = new ArrayList();
                                }
                                if (!list24.contains(next.getSymbol())) {
                                    list23.add(next);
                                    list24.add(next.getSymbol());
                                    hashMap5.put(next.getQuoteCurrency(), list24);
                                    hashMap2.put(next.getQuoteCurrency(), list23);
                                }
                            }
                        }
                    }
                }
            }
        }
        synchronized (this.f68974l) {
            this.f68974l.clear();
            this.f68974l.putAll(hashMap);
        }
        synchronized (this.f68975m) {
            this.f68975m.clear();
            this.f68975m.putAll(hashMap2);
        }
        synchronized (this.f68976n) {
            this.f68976n.clear();
            this.f68976n.putAll(hashMap3);
        }
    }

    public String o(String str, TradeType tradeType) {
        SymbolBean J;
        if (!TextUtils.isEmpty(str) && (J = J(str, TradeType.PRO)) != null) {
            return J.getBaseCurrency();
        }
        return "";
    }

    public boolean o0(String str, TradeType tradeType) {
        SymbolBean J = J(str, tradeType);
        return J != null && J.isCallAuctionTwo();
    }

    public String p(String str) {
        SymbolBean J;
        if (!TextUtils.isEmpty(str) && (J = J(str, TradeType.PRO)) != null) {
            return J.getBaseCurrencyDisplayName();
        }
        return "";
    }

    public boolean p0(String str) {
        SymbolBean J = J(str, TradeType.PRO);
        if (J != null) {
            return J.isEtpTag();
        }
        return false;
    }

    public List<SymbolBean> q(String str) {
        List<SymbolBean> list;
        synchronized (this.f68982t) {
            list = this.f68982t.get(str);
        }
        return list;
    }

    public boolean q0(String str, TradeType tradeType) {
        SymbolBean J;
        TradeType tradeType2 = TradeType.PRO;
        if (tradeType == tradeType2 && (J = J(str, tradeType2)) != null) {
            return J.isInWatchingPartition();
        }
        return false;
    }

    public int r(String str, TradeType tradeType) {
        SymbolBean J = J(str, tradeType);
        if (J != null) {
            return J.getFeePrecision();
        }
        return 8;
    }

    public boolean r0(String str) {
        SymbolBean J = J(str, TradeType.PRO);
        if (J != null) {
            return J.isPioneer();
        }
        return false;
    }

    public String s(String str) {
        List<String> j11 = j();
        List<String> i11 = i();
        StringBuilder sb2 = new StringBuilder();
        int size = j11.size();
        CurrencyBean v11 = k.C().v(str);
        for (int i12 = 0; i12 < size; i12++) {
            if (v11 != null) {
                String str2 = v11.getName() + j11.get(i12);
                if (i11.contains(str2)) {
                    sb2.append(str2);
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
        }
        if (sb2.toString().endsWith(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            sb2.replace(sb2.length() - 1, sb2.length(), "");
        }
        return sb2.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean s0(java.lang.String r3) {
        /*
            r2 = this;
            java.util.Map<java.lang.String, com.hbg.lib.network.pro.core.bean.SymbolBean> r0 = r2.f68970h
            monitor-enter(r0)
            java.util.Map<java.lang.String, com.hbg.lib.network.pro.core.bean.SymbolBean> r1 = r2.f68970h     // Catch:{ all -> 0x0019 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0019 }
            com.hbg.lib.network.pro.core.bean.SymbolBean r3 = (com.hbg.lib.network.pro.core.bean.SymbolBean) r3     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0016
            boolean r3 = r3.isPrimeTag()     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0016
            r3 = 1
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r3
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            r3 = 0
            return r3
        L_0x0019:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.a1.s0(java.lang.String):boolean");
    }

    public String t(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f68963a) {
            if (this.f68963a.isEmpty()) {
                return null;
            }
            ArrayList<SymbolBean> arrayList = new ArrayList<>(this.f68963a);
            Collections.sort(arrayList, v0.f53537b);
            for (SymbolBean symbolBean : arrayList) {
                if (symbolBean.isCanTrade()) {
                    if (str.equalsIgnoreCase(symbolBean.getBaseCurrency())) {
                        String symbol = symbolBean.getSymbol();
                        return symbol;
                    } else if (str.equalsIgnoreCase(symbolBean.getQuoteCurrency()) && str2 == null) {
                        str2 = symbolBean.getSymbol();
                    }
                }
            }
            return str2;
        }
    }

    public String u(String str, boolean z11) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f68963a) {
            if (!this.f68963a.isEmpty()) {
                Iterator<SymbolBean> it2 = this.f68963a.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    SymbolBean next = it2.next();
                    if (next.isCanTrade()) {
                        if (z11) {
                            if (str.equalsIgnoreCase(next.getQuoteCurrency())) {
                                str2 = next.getSymbol();
                                break;
                            }
                        } else if (str.equalsIgnoreCase(next.getBaseCurrency())) {
                            str2 = next.getSymbol();
                            break;
                        }
                    }
                }
            }
        }
        return str2;
    }

    public List<String> w() {
        HashMap hashMap = new HashMap(this.f68974l);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hashMap.keySet());
        if (arrayList.remove(SymbolBean.ALTS)) {
            arrayList.add(SymbolBean.ALTS);
        }
        if (arrayList.remove(SymbolBean.FIAT)) {
            arrayList.add(SymbolBean.FIAT);
        }
        if (arrayList.remove(SymbolBean.CRYPTO)) {
            arrayList.add(SymbolBean.CRYPTO);
        }
        return arrayList;
    }

    public int x(String str, TradeType tradeType) {
        Map<String, SymbolBean> V;
        SymbolBean symbolBean;
        if (TextUtils.isEmpty(str) || (V = V(tradeType)) == null || (symbolBean = V.get(str)) == null) {
            return 0;
        }
        return symbolBean.getWeight();
    }

    public int y(String str, Map<String, SymbolBean> map) {
        SymbolBean symbolBean;
        if (TextUtils.isEmpty(str) || map == null || (symbolBean = map.get(str)) == null) {
            return 0;
        }
        return symbolBean.getWeight();
    }

    /* renamed from: y0 */
    public final void x0(List<SymbolBean> list) {
        ArrayList arrayList = new ArrayList();
        for (SymbolBean next : list) {
            b1.a().b().e(next);
            if (gj.d.n().G() || !next.isEtpTag()) {
                arrayList.add(next);
            }
        }
        h(arrayList);
        synchronized (this.f68963a) {
            this.f68963a.clear();
            this.f68963a.addAll(arrayList);
        }
        n0();
        m0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r3 = r2.indexOf(i6.m.a(r3).abs().toPlainString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String z(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x0024
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x0024
            java.math.BigDecimal r3 = i6.m.a(r3)
            java.math.BigDecimal r3 = r3.abs()
            java.lang.String r3 = r3.toPlainString()
            int r3 = r2.indexOf(r3)
            if (r3 <= 0) goto L_0x0024
            r0 = 0
            java.lang.String r2 = r2.substring(r0, r3)
            goto L_0x0026
        L_0x0024:
            java.lang.String r2 = ""
        L_0x0026:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.a1.z(java.lang.String, java.lang.String):java.lang.String");
    }

    public Observable<List<SymbolBean>> z0(boolean z11) {
        return Observable.zip(SymbolsDataProvider.r(z11, U()).subscribeOn(Schedulers.io()), SuperMarginSymbolConfigUtil.g(z11).subscribeOn(Schedulers.io()).onErrorResumeNext(Observable.just(null)), z0.f53544b).doOnNext(new w0(this));
    }
}
