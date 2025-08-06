package nb;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.FileUtil;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lite.enums.OtcTradeMode;
import com.hbg.lite.enums.TradeSide;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;
import rx.Observable;

public final class g {

    /* renamed from: g  reason: collision with root package name */
    public static volatile g f84452g = new g();

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, List<OtcTradeConfigListBean.QuoteAsset>> f84453a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap<String, List<OtcTradeConfigListBean.CryptoAsset>> f84454b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap<String, List<OtcTradeConfigListBean>> f84455c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public long f84456d;

    /* renamed from: e  reason: collision with root package name */
    public String f84457e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f84458f;

    public class a extends RequestCallback1<Map<String, List<OtcTradeConfigListBean>>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f84459a;

        public a(c cVar) {
            this.f84459a = cVar;
        }

        /* renamed from: a */
        public void onRequestSuccess(Map<String, List<OtcTradeConfigListBean>> map) {
            c cVar = this.f84459a;
            if (cVar != null) {
                cVar.a();
            }
            if (ra.c.c().p()) {
                boolean unused = g.this.f84458f = true;
            }
        }

        /* renamed from: b */
        public Map<String, List<OtcTradeConfigListBean>> onRequestSuccessAsync(Map<String, List<OtcTradeConfigListBean>> map) {
            g.this.e(map);
            return (Map) super.onRequestSuccessAsync(map);
        }

        public void onRequestFailure(Throwable th2) {
            c cVar = this.f84459a;
            if (cVar != null) {
                cVar.c(th2);
            }
            if (ra.c.c().p()) {
                boolean unused = g.this.f84458f = false;
            }
            HashMap hashMap = new HashMap();
            if (th2 instanceof APIStatusErrorException) {
                hashMap.put("otc_step", "otc_config_failed");
                hashMap.put("api_code", ((APIStatusErrorException) th2).getErrCode());
                hashMap.put("api_path", "/fiat/fast/base/config");
                ra.c.c().track("base_config_failed", hashMap);
            } else if ((th2 instanceof IOException) || (th2 instanceof TimeoutException)) {
                hashMap.put("otc_step", "api_config_timeout");
                hashMap.put("api_path", "/fiat/fast/base/config");
                ra.c.c().track("base_config_failed", hashMap);
            }
        }

        public void onRequestStart() {
            c cVar = this.f84459a;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public class b extends TypeToken<Map<String, OtcTradeConfigListBean[]>> {
        public b() {
        }
    }

    public interface c {
        void a();

        void b();

        void c(Throwable th2);
    }

    public g() {
        k();
    }

    public static g j() {
        if (f84452g == null) {
            synchronized (g.class) {
                if (f84452g == null) {
                    f84452g = new g();
                }
            }
        }
        return f84452g;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List p(OtcTradeMode otcTradeMode, TradeSide tradeSide, List list) {
        if (list != null) {
            v(f(otcTradeMode, tradeSide), list);
            u();
        }
        return list;
    }

    public static /* synthetic */ List q(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Map r(List list, List list2, List list3, List list4) {
        HashMap hashMap = new HashMap();
        if (!CollectionsUtils.b(list)) {
            hashMap.put(f(OtcTradeMode.C2C_SIMPLE, TradeSide.buy), list);
        }
        if (!CollectionsUtils.b(list2)) {
            hashMap.put(f(OtcTradeMode.C2C_SIMPLE, TradeSide.sell), list2);
        }
        if (!CollectionsUtils.b(list3)) {
            hashMap.put(f(OtcTradeMode.C2C_BRAND, TradeSide.buy), list);
        }
        if (!CollectionsUtils.b(list4)) {
            hashMap.put(f(OtcTradeMode.C2C_BRAND, TradeSide.sell), list2);
        }
        return hashMap;
    }

    public synchronized void e(Map<String, List<OtcTradeConfigListBean>> map) {
        try {
            if (!CollectionsUtils.c(map)) {
                this.f84455c.clear();
                this.f84454b.clear();
                for (String next : map.keySet()) {
                    v(next, map.get(next));
                }
                if (TextUtils.isEmpty(this.f84457e)) {
                    this.f84456d = System.currentTimeMillis();
                    u();
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return;
    }

    public final String f(OtcTradeMode otcTradeMode, TradeSide tradeSide) {
        return otcTradeMode.getValue() + "##" + tradeSide.name();
    }

    public Observable<List<OtcTradeConfigListBean>> g(OtcTradeMode otcTradeMode, TradeSide tradeSide, boolean z11) {
        if (!z11 || m(otcTradeMode, tradeSide)) {
            return s8.a.a().fastTradeConfigList(tradeSide.name(), otcTradeMode.getValue()).b().map(new d(this, otcTradeMode, tradeSide)).onErrorReturn(e.f58319b);
        }
        return i(otcTradeMode, tradeSide);
    }

    public synchronized List<OtcTradeConfigListBean.CryptoAsset> h(OtcTradeMode otcTradeMode, TradeSide tradeSide, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List list = this.f84455c.get(f(otcTradeMode, tradeSide));
        if (CollectionsUtils.b(list)) {
            return arrayList;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            OtcTradeConfigListBean otcTradeConfigListBean = (OtcTradeConfigListBean) list.get(i11);
            if (otcTradeConfigListBean != null) {
                List<OtcTradeConfigListBean.QuoteAsset> quoteAsset = otcTradeConfigListBean.getQuoteAsset();
                if (!CollectionsUtils.b(quoteAsset)) {
                    int i12 = 0;
                    while (true) {
                        if (i12 < quoteAsset.size()) {
                            OtcTradeConfigListBean.QuoteAsset quoteAsset2 = quoteAsset.get(i12);
                            if (quoteAsset2 != null && str.equalsIgnoreCase(quoteAsset2.getName()) && otcTradeConfigListBean.getCryptoAsset() != null && va.b.e(otcTradeConfigListBean.getCryptoAsset().getName()) != 0) {
                                arrayList.add(otcTradeConfigListBean.getCryptoAsset());
                                break;
                            }
                            i12++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public Observable<List<OtcTradeConfigListBean>> i(OtcTradeMode otcTradeMode, TradeSide tradeSide) {
        return Observable.just(this.f84455c.get(f(otcTradeMode, tradeSide)));
    }

    public final void k() {
        try {
            String d11 = ConfigPreferences.d("otc_config", "FAST_TRADE_CONFIG");
            Map<String, OtcTradeConfigListBean[]> map = null;
            if (!TextUtils.isEmpty(d11)) {
                map = l(d11);
            }
            if ((map == null || map.isEmpty()) && !CollectionsUtils.c(l(FileUtil.k(BaseApplication.b().getResources().getAssets().open("otc_fast_trade_config.json"))))) {
                u();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public final Map<String, OtcTradeConfigListBean[]> l(String str) {
        Map<String, OtcTradeConfigListBean[]> map = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, OtcTradeConfigListBean[]> map2 = (Map) new GsonBuilder().create().fromJson(str, new b().getType());
            try {
                if (CollectionsUtils.c(map2)) {
                    return map2;
                }
                this.f84455c.clear();
                this.f84454b.clear();
                for (String next : map2.keySet()) {
                    OtcTradeConfigListBean[] otcTradeConfigListBeanArr = map2.get(next);
                    if (!(otcTradeConfigListBeanArr == null || otcTradeConfigListBeanArr.length == 0)) {
                        v(next, Arrays.asList(otcTradeConfigListBeanArr));
                    }
                }
                return map2;
            } catch (Exception e11) {
                e = e11;
                map = map2;
                e.printStackTrace();
                return map;
            }
        } catch (Exception e12) {
            e = e12;
            e.printStackTrace();
            return map;
        }
    }

    public final boolean m(OtcTradeMode otcTradeMode, TradeSide tradeSide) {
        return CollectionsUtils.c(this.f84455c) || CollectionsUtils.b(this.f84455c.get(f(otcTradeMode, tradeSide)));
    }

    public boolean n() {
        return (System.currentTimeMillis() - this.f84456d) / 1000 > 86400;
    }

    public boolean o() {
        return this.f84458f;
    }

    public void s() {
        try {
            if (!TextUtils.isEmpty(this.f84457e)) {
                this.f84457e = "";
                x(true, (c) null);
                this.f84458f = false;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void t(String str, c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (!TextUtils.equals(str, this.f84457e)) {
                this.f84457e = str;
                x(true, cVar);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void u() {
        synchronized (g.class) {
            ConfigPreferences.m("otc_config", "FAST_TRADE_CONFIG", new Gson().toJson((Object) this.f84455c));
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final synchronized void v(java.lang.String r9, java.util.List<com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean> r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = com.hbg.lib.core.util.CollectionsUtils.b(r10)     // Catch:{ all -> 0x00e2 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r8)
            return
        L_0x0009:
            java.lang.Class<nb.g> r0 = nb.g.class
            monitor-enter(r0)     // Catch:{ Exception -> 0x00d2 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean>> r1 = r8.f84455c     // Catch:{ all -> 0x00cf }
            r1.put(r9, r10)     // Catch:{ all -> 0x00cf }
            r1 = 0
        L_0x0012:
            int r2 = r10.size()     // Catch:{ all -> 0x00cf }
            if (r1 >= r2) goto L_0x00cd
            java.lang.Object r2 = r10.get(r1)     // Catch:{ all -> 0x00cf }
            if (r2 == 0) goto L_0x00c9
            java.lang.Object r2 = r10.get(r1)     // Catch:{ all -> 0x00cf }
            com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean r2 = (com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean) r2     // Catch:{ all -> 0x00cf }
            com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean$CryptoAsset r2 = r2.getCryptoAsset()     // Catch:{ all -> 0x00cf }
            java.lang.Object r3 = r10.get(r1)     // Catch:{ all -> 0x00cf }
            com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean r3 = (com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean) r3     // Catch:{ all -> 0x00cf }
            java.util.List r3 = r3.getQuoteAsset()     // Catch:{ all -> 0x00cf }
            if (r2 != 0) goto L_0x0036
            goto L_0x00c9
        L_0x0036:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean$QuoteAsset>> r4 = r8.f84453a     // Catch:{ all -> 0x00cf }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r5.<init>()     // Catch:{ all -> 0x00cf }
            r5.append(r9)     // Catch:{ all -> 0x00cf }
            java.lang.String r6 = "-"
            r5.append(r6)     // Catch:{ all -> 0x00cf }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x00cf }
            java.lang.String r2 = r2.toUpperCase()     // Catch:{ all -> 0x00cf }
            r5.append(r2)     // Catch:{ all -> 0x00cf }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x00cf }
            r4.put(r2, r3)     // Catch:{ all -> 0x00cf }
            boolean r2 = com.hbg.lib.core.util.CollectionsUtils.b(r3)     // Catch:{ all -> 0x00cf }
            if (r2 != 0) goto L_0x00c9
            java.util.Iterator r2 = r3.iterator()     // Catch:{ all -> 0x00cf }
        L_0x0061:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00cf }
            if (r3 == 0) goto L_0x00c9
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00cf }
            com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean$QuoteAsset r3 = (com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean.QuoteAsset) r3     // Catch:{ all -> 0x00cf }
            if (r3 == 0) goto L_0x0061
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean$CryptoAsset>> r4 = r8.f84454b     // Catch:{ all -> 0x00cf }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r5.<init>()     // Catch:{ all -> 0x00cf }
            r5.append(r9)     // Catch:{ all -> 0x00cf }
            java.lang.String r6 = "-"
            r5.append(r6)     // Catch:{ all -> 0x00cf }
            java.lang.String r6 = r3.getName()     // Catch:{ all -> 0x00cf }
            java.lang.String r6 = r6.toUpperCase()     // Catch:{ all -> 0x00cf }
            r5.append(r6)     // Catch:{ all -> 0x00cf }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00cf }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00cf }
            java.util.List r4 = (java.util.List) r4     // Catch:{ all -> 0x00cf }
            if (r4 != 0) goto L_0x00bb
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00cf }
            r4.<init>()     // Catch:{ all -> 0x00cf }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean$CryptoAsset>> r5 = r8.f84454b     // Catch:{ all -> 0x00cf }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r6.<init>()     // Catch:{ all -> 0x00cf }
            r6.append(r9)     // Catch:{ all -> 0x00cf }
            java.lang.String r7 = "-"
            r6.append(r7)     // Catch:{ all -> 0x00cf }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x00cf }
            java.lang.String r3 = r3.toUpperCase()     // Catch:{ all -> 0x00cf }
            r6.append(r3)     // Catch:{ all -> 0x00cf }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x00cf }
            r5.put(r3, r4)     // Catch:{ all -> 0x00cf }
        L_0x00bb:
            java.lang.Object r3 = r10.get(r1)     // Catch:{ all -> 0x00cf }
            com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean r3 = (com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean) r3     // Catch:{ all -> 0x00cf }
            com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean$CryptoAsset r3 = r3.getCryptoAsset()     // Catch:{ all -> 0x00cf }
            r4.add(r3)     // Catch:{ all -> 0x00cf }
            goto L_0x0061
        L_0x00c9:
            int r1 = r1 + 1
            goto L_0x0012
        L_0x00cd:
            monitor-exit(r0)     // Catch:{ all -> 0x00cf }
            goto L_0x00e0
        L_0x00cf:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00cf }
            throw r9     // Catch:{ Exception -> 0x00d2 }
        L_0x00d2:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x00e2 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean>> r9 = r8.f84455c     // Catch:{ all -> 0x00e2 }
            r9.clear()     // Catch:{ all -> 0x00e2 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<com.hbg.lib.network.otc.core.bean.OtcTradeConfigListBean$CryptoAsset>> r9 = r8.f84454b     // Catch:{ all -> 0x00e2 }
            r9.clear()     // Catch:{ all -> 0x00e2 }
        L_0x00e0:
            monitor-exit(r8)
            return
        L_0x00e2:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.g.v(java.lang.String, java.util.List):void");
    }

    public void w(String str) {
        this.f84457e = str;
    }

    public void x(boolean z11, c cVar) {
        if (z11 || n()) {
            s8.b a11 = s8.a.a();
            TradeSide tradeSide = TradeSide.buy;
            String name = tradeSide.name();
            OtcTradeMode otcTradeMode = OtcTradeMode.C2C_SIMPLE;
            Observable<List<OtcTradeConfigListBean>> b11 = a11.fastTradeConfigList(name, otcTradeMode.getValue()).b();
            s8.b a12 = s8.a.a();
            TradeSide tradeSide2 = TradeSide.sell;
            Observable<List<OtcTradeConfigListBean>> b12 = a12.fastTradeConfigList(tradeSide2.name(), otcTradeMode.getValue()).b();
            s8.b a13 = s8.a.a();
            String name2 = tradeSide.name();
            OtcTradeMode otcTradeMode2 = OtcTradeMode.C2C_BRAND;
            new d9.a(Observable.zip(b11, b12, a13.fastTradeConfigList(name2, otcTradeMode2.getValue()).b(), s8.a.a().fastTradeConfigList(tradeSide2.name(), otcTradeMode2.getValue()).b(), new f(this))).d(new a(cVar));
        }
    }
}
