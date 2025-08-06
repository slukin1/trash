package d7;

import android.text.TextUtils;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.data.main.ChainDataDiffTools;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.db.ChainDbHelper;
import com.hbg.lib.network.pro.db.ProDbHelper;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import i6.d;
import i6.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import rx.Observable;
import rx.schedulers.Schedulers;
import x8.a;

public class k {

    /* renamed from: b  reason: collision with root package name */
    public static volatile k f68990b;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, List<ChainInfo>> f68991a = new HashMap();

    public k() {
        long currentTimeMillis = System.currentTimeMillis();
        List<ChainInfo> i11 = ChainDbHelper.i();
        d.b("CurrencyConfigImpl-->chain-->init-->本地读取到 " + i11.size() + " 个，耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        if (!i11.isEmpty()) {
            k(Observable.from(i11)).subscribe(new BaseEasySubscriber());
        }
    }

    public static k C() {
        if (f68990b == null) {
            synchronized (k.class) {
                f68990b = new k();
            }
        }
        return f68990b;
    }

    public static /* synthetic */ Observable M(String str, List list) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ChainInfo chainInfo = (ChainInfo) it2.next();
            if (chainInfo != null) {
                chainInfo.reloadAllDesc(ChainDbHelper.j(chainInfo.getChain()));
            }
        }
        if (TextUtils.isEmpty(str)) {
            ChainDbHelper.g();
            d.b("CurrencyConfigImpl-->chain-->全部删除");
        } else {
            ChainDbHelper.h(str);
        }
        long currentTimeMillis = System.currentTimeMillis();
        ProDbHelper.d(list);
        d.b("CurrencyConfigImpl-->chain-->插入" + list.size() + "个，耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        return Observable.from(list);
    }

    public static /* synthetic */ Boolean N(ChainInfo chainInfo) {
        return Boolean.valueOf(chainInfo != null && !chainInfo.isIgnoreChainType());
    }

    public static /* synthetic */ void O(Map map, ChainInfo chainInfo) {
        if (chainInfo != null) {
            if (!map.containsKey(chainInfo.getCurrency())) {
                map.put(chainInfo.getCurrency(), new ArrayList());
            }
            ((List) map.get(chainInfo.getCurrency())).add(chainInfo);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P(Map map) {
        for (Map.Entry value : map.entrySet()) {
            List list = (List) value.getValue();
            if (list != null) {
                Collections.sort(list);
            }
        }
        synchronized (this.f68991a) {
            this.f68991a.clear();
            this.f68991a.putAll(map);
        }
    }

    public static /* synthetic */ Boolean Q(Map map) {
        return Boolean.valueOf(map != null);
    }

    public static /* synthetic */ List R(List list, Map map) {
        if (map != null && !map.isEmpty() && list != null && !list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                CurrencyBean currencyBean = (CurrencyBean) it2.next();
                if (!(currencyBean == null || currencyBean.getName() == null)) {
                    currencyBean.setChainInfos((List) map.get(currencyBean.getName()));
                }
            }
        }
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S(String str, List list) {
        if (list != null && this.f68991a != null) {
            Collections.sort(list);
            this.f68991a.put(str, list);
        }
    }

    public static /* synthetic */ Boolean T(List list) {
        return Boolean.valueOf(list != null);
    }

    public String A(String str, String str2) {
        CurrencyBean s11 = s(str);
        return s11 != null ? s11.getDisplayName() : str2;
    }

    public String B(String str) {
        CurrencyBean s11 = s(str);
        return (s11 == null || TextUtils.isEmpty(s11.getFullName())) ? "" : s11.getFullName();
    }

    public final String D() {
        return AppLanguageHelper.getInstance().getCurLanguageHeader();
    }

    public Observable<List<CurrencyBean>> E(boolean z11) {
        return q0.f(z11, D());
    }

    public ChainInfo F(String str, String str2) {
        Map<String, List<ChainInfo>> map;
        List<ChainInfo> list;
        if (!(str == null || str2 == null || (map = this.f68991a) == null || (list = map.get(str.toLowerCase(Locale.US))) == null || list.isEmpty())) {
            for (ChainInfo chainInfo : list) {
                if (chainInfo != null && str2.equalsIgnoreCase(chainInfo.getChain())) {
                    return chainInfo;
                }
            }
        }
        return null;
    }

    public List<String> G(TradeType tradeType) {
        ArrayList arrayList = new ArrayList();
        if (q0.j()) {
            for (CurrencyBean next : w()) {
                if (next != null && next.isVisible()) {
                    String name = next.getName();
                    if (!TextUtils.isEmpty(name)) {
                        arrayList.add(name);
                    }
                }
            }
        }
        return arrayList;
    }

    public String H(String str) {
        CurrencyBean currencyBean = q0.h().get(str.toLowerCase(Locale.US));
        return currencyBean != null ? currencyBean.getWeight() : "";
    }

    public String I(String str, TradeType tradeType) {
        return H(str);
    }

    public boolean J(String str) {
        CurrencyBean currencyBean = q0.h().get(str.toLowerCase(Locale.US));
        return currencyBean != null && currencyBean.getName().equalsIgnoreCase(str);
    }

    public boolean K(String str, String str2) {
        ChainInfo F = F(str, str2);
        if (F == null) {
            return false;
        }
        return F.getAddrWithTag();
    }

    public boolean L(String str) {
        CurrencyBean s11 = s(str);
        if (s11 != null) {
            return s11.isFiatTag();
        }
        return false;
    }

    public void U(boolean z11, RequestCallback1<List<CurrencyBean>> requestCallback1) {
        q0.p(z11, D(), requestCallback1);
    }

    public void i() {
        q0.e();
        synchronized (this.f68991a) {
            this.f68991a.clear();
        }
        ChainDbHelper.g();
    }

    public final Observable<ChainInfo> j(String str, String str2, String str3) {
        Observable<R> observable;
        if (TextUtils.isEmpty(str2)) {
            observable = ChainDataDiffTools.r().t(str3).j();
        } else {
            observable = a.a().y("0", str, str2, str3).b().map(g.f53505b);
        }
        return observable.flatMap(new e(str2)).filter(f.f53502b);
    }

    public final Observable<Map<String, List<ChainInfo>>> k(Observable<ChainInfo> observable) {
        return observable.collect(d.f53495b, c.f53494b).doOnNext(new a(this));
    }

    public Map<String, List<ChainInfo>> l() {
        return new HashMap(this.f68991a);
    }

    public Observable<Map<String, List<ChainInfo>>> m(boolean z11, String str, String str2) {
        Observable<Map<String, List<ChainInfo>>> k11 = k(j(str, (String) null, str2));
        return z11 ? Observable.concat(Observable.just(this.f68991a), k11).takeFirst(i.f53510b) : k11;
    }

    public Observable<List<CurrencyBean>> n(boolean z11, String str, String str2) {
        return Observable.zip(E(z11).subscribeOn(Schedulers.io()), m(z11, str, str2).subscribeOn(Schedulers.io()).onErrorResumeNext(Observable.just(null)), j.f53513b);
    }

    public List<String> o(TradeType tradeType) {
        ArrayList arrayList = new ArrayList();
        if (q0.j()) {
            for (CurrencyBean next : q0.g()) {
                if (next != null) {
                    String name = next.getName();
                    if (!TextUtils.isEmpty(name)) {
                        arrayList.add(name);
                    }
                }
            }
        }
        return arrayList;
    }

    public int p(String str) {
        return q(str, TradeType.PRO);
    }

    public int q(String str, TradeType tradeType) {
        if (str == null) {
            return 0;
        }
        CurrencyBean currencyBean = q0.h().get(str.toLowerCase(Locale.US));
        return m.k0(currencyBean != null ? currencyBean.getPrecision() : "8");
    }

    public Observable<List<ChainInfo>> r(String str, boolean z11, String str2, String str3) {
        Observable<List<ChainInfo>> doOnNext = j(str2, str, str3).toList().doOnNext(new b(this, str));
        if (!z11) {
            return doOnNext;
        }
        Map<String, List<ChainInfo>> map = this.f68991a;
        return Observable.concat(Observable.just(map == null ? null : map.get(str)), doOnNext).takeFirst(h.f53507b);
    }

    public CurrencyBean s(String str) {
        if (!TextUtils.isEmpty(str)) {
            return q0.h().get(str.toLowerCase(Locale.US));
        }
        return null;
    }

    public CurrencyBean t(String str, Map<String, CurrencyBean> map) {
        if (!TextUtils.isEmpty(str)) {
            return map.get(str.toLowerCase(Locale.US));
        }
        return null;
    }

    public Map<String, CurrencyBean> u() {
        return q0.h();
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.hbg.lib.network.pro.core.bean.CurrencyBean v(java.lang.String r4) {
        /*
            r3 = this;
            java.util.List r0 = d7.q0.g()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0029
            java.lang.Object r1 = r0.next()
            com.hbg.lib.network.pro.core.bean.CurrencyBean r1 = (com.hbg.lib.network.pro.core.bean.CurrencyBean) r1
            java.lang.String r2 = r1.getDisplayName()
            boolean r2 = r2.equalsIgnoreCase(r4)
            if (r2 != 0) goto L_0x002a
            java.lang.String r2 = r1.getName()
            boolean r2 = r2.equalsIgnoreCase(r4)
            if (r2 == 0) goto L_0x0008
            goto L_0x002a
        L_0x0029:
            r1 = 0
        L_0x002a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.k.v(java.lang.String):com.hbg.lib.network.pro.core.bean.CurrencyBean");
    }

    public List<CurrencyBean> w() {
        return q0.g();
    }

    public String x(String str, String str2) {
        ChainInfo F = F(str, str2);
        if (F == null) {
            return "";
        }
        return F.getDepositMinAmount();
    }

    public String y(CurrencyBean currencyBean) {
        return currencyBean != null ? currencyBean.getDisplayName() : "";
    }

    public String z(String str) {
        CurrencyBean s11 = s(str);
        return s11 != null ? s11.getDisplayName() : str;
    }
}
