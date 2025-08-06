package ym;

import a7.e;
import android.text.TextUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.MarketBuySellUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCurrentOrderInfo;
import com.hbg.lib.network.linear.swap.core.util.LinearSwapDepthType;
import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.contract.entity.ContractDepth;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.controller.FutureMarketDepthController;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import ct.c;
import g9.a;
import i6.i;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nk.b;
import qk.t;
import rx.Observable;
import rx.functions.Action0;
import u6.g;

public class k extends FutureMarketDepthController implements ok.a {

    /* renamed from: b  reason: collision with root package name */
    public List<MarketBuySellItem> f76935b;

    /* renamed from: c  reason: collision with root package name */
    public List<MarketBuySellItem> f76936c;

    /* renamed from: d  reason: collision with root package name */
    public double f76937d;

    /* renamed from: e  reason: collision with root package name */
    public double f76938e;

    /* renamed from: f  reason: collision with root package name */
    public double f76939f;

    /* renamed from: g  reason: collision with root package name */
    public List<MarketBuySellItem> f76940g;

    /* renamed from: h  reason: collision with root package name */
    public MarketCurrentPriceItem f76941h;

    /* renamed from: i  reason: collision with root package name */
    public List<MarketBuySellItem> f76942i;

    /* renamed from: j  reason: collision with root package name */
    public b f76943j;

    /* renamed from: k  reason: collision with root package name */
    public BigDecimal f76944k = BigDecimal.ZERO;

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, Set<String>> f76945l = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    public Map<String, List<ContractDepth>> f76946m;

    /* renamed from: n  reason: collision with root package name */
    public String f76947n = LinearSwapDepthType.STEP6.step;

    /* renamed from: o  reason: collision with root package name */
    public TradeType f76948o;

    /* renamed from: p  reason: collision with root package name */
    public String f76949p = "";

    /* renamed from: q  reason: collision with root package name */
    public String f76950q = "";

    /* renamed from: r  reason: collision with root package name */
    public String f76951r = "";

    /* renamed from: s  reason: collision with root package name */
    public com.huobi.feature.ui.a f76952s;

    /* renamed from: t  reason: collision with root package name */
    public FutureContractInfo f76953t;

    /* renamed from: u  reason: collision with root package name */
    public int f76954u = 0;

    /* renamed from: v  reason: collision with root package name */
    public boolean f76955v = true;

    /* renamed from: w  reason: collision with root package name */
    public c f76956w = new a(this);

    /* renamed from: x  reason: collision with root package name */
    public a.d f76957x = new b(this);

    /* renamed from: y  reason: collision with root package name */
    public MarketDepthListener f76958y = new a();

    public class a extends MarketDepthListener {
        public a() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            int i11;
            double d11;
            double d12;
            MarketDepthResponse marketDepthResponse2 = marketDepthResponse;
            if (marketDepthResponse2 != null && marketDepthResponse.getSymbol().equals(k.this.f76950q)) {
                t.e(10);
                if (k.this.f76955v) {
                    i6.k.n(marketDepthResponse2 + "====");
                    boolean unused = k.this.f76955v = false;
                }
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                List<Double> a11 = MarketBuySellUtils.a(bids, 20);
                List<Double> a12 = MarketBuySellUtils.a(asks, 20);
                MarketBuySellUtils.b(a11, a12);
                if (k.this.f76954u == 0) {
                    i11 = Math.min(5, a11.size());
                } else if (k.this.f76954u == 1) {
                    i11 = Math.min(20, a11.size());
                } else {
                    i11 = k.this.f76954u == 2 ? Math.min(0, a11.size()) : 0;
                }
                if (i11 < 1) {
                    d11 = 0.0d;
                } else {
                    d11 = a11.get(i11 - 1).doubleValue();
                }
                if (k.this.f76954u == 0) {
                    i11 = Math.min(5, a12.size());
                } else if (k.this.f76954u == 1) {
                    i11 = Math.min(0, a12.size());
                } else if (k.this.f76954u == 2) {
                    i11 = Math.min(20, a12.size());
                }
                if (i11 < 1) {
                    d12 = 0.0d;
                } else {
                    d12 = a12.get(i11 - 1).doubleValue();
                }
                double max = Math.max(d11, d12);
                k kVar = k.this;
                kVar.V(kVar.f76949p, k.this.f76940g, asks, a12, 1, max);
                k kVar2 = k.this;
                kVar2.V(kVar2.f76949p, k.this.f76942i, bids, a11, 0, max);
                k.this.l(true);
            }
        }
    }

    public k(com.huobi.feature.ui.a aVar, b bVar, TradeType tradeType) {
        this.f76952s = aVar;
        this.f76943j = bVar;
        this.f76948o = tradeType;
        bVar.b(this);
        this.f76935b = new ArrayList();
        this.f76936c = new ArrayList();
        this.f76940g = new ArrayList();
        this.f76942i = new ArrayList();
        F();
        MarketCurrentPriceItem marketCurrentPriceItem = new MarketCurrentPriceItem();
        this.f76941h = marketCurrentPriceItem;
        marketCurrentPriceItem.r(6);
        this.f76946m = new HashMap();
        l(false);
    }

    public static /* synthetic */ List I(FutureContractInfo futureContractInfo) {
        String str;
        List<Map<String, String>> list = futureContractInfo.precisionList;
        ArrayList arrayList = new ArrayList();
        int i11 = 20;
        for (Map next : list) {
            if (!next.isEmpty()) {
                Iterator it2 = next.keySet().iterator();
                if (it2.hasNext()) {
                    try {
                        str = new BigDecimal((String) next.get((String) it2.next())).multiply(new BigDecimal(futureContractInfo.priceTick)).toPlainString();
                    } catch (Throwable unused) {
                        str = "";
                    }
                    arrayList.add(new ContractDepth("step" + i11, str));
                    i11++;
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(FutureContractInfo futureContractInfo) {
        if (this.f76946m.get(futureContractInfo.getContractShortType()) != null) {
            this.f76946m.get(futureContractInfo.getContractShortType()).clear();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(FutureContractInfo futureContractInfo, String str, int i11, List list) {
        this.f76946m.put(futureContractInfo.getContractShortType(), list);
        D(futureContractInfo.getContractShortType(), str, this.f76946m.get(futureContractInfo.getContractShortType()), i11);
    }

    public static /* synthetic */ void L(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void M(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N() {
        T(this.f76950q, this.f76949p, this.f76947n, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O() {
        this.f76952s.H0(this.f76941h);
    }

    public void D(String str, String str2, List<ContractDepth> list, int i11) {
        if (list != null && !list.isEmpty()) {
            int i12 = 0;
            if (i11 == -1 && TextUtils.equals(str2, "BTC")) {
                int i13 = 0;
                while (true) {
                    if (i13 >= list.size()) {
                        break;
                    } else if (m.a(list.get(i13).getPriceTick()).compareTo(BigDecimal.ONE) == 0) {
                        i11 = i13;
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            if (i11 != -1 && list.size() > i11) {
                i12 = i11;
            }
            this.f76952s.V0(list, i12);
            SP.q("sp_symbol_depth" + this.f76948o.toString() + str, i12);
            R(str, str2, list.get(i12).getStep(), true);
            if (list.size() - 1 >= i12) {
                this.f76944k = m.a(list.get(i12).getPriceTick());
                a();
                this.f76952s.N0(list.get(i12), i12 + 1);
            }
        }
    }

    public Observable<FutureContractInfo> E(String str) {
        return FutureContractInfoController.n().h(TradeType.LINEAR_SWAP, true).flatMap(j.f61842b).filter(new h(str));
    }

    public final void F() {
        int i11 = 0;
        while (i11 < 20) {
            MarketBuySellItem marketBuySellItem = new MarketBuySellItem(1, 6);
            i11++;
            marketBuySellItem.G(i11);
            TradeType tradeType = TradeType.LINEAR_SWAP;
            marketBuySellItem.C(tradeType);
            this.f76940g.add(marketBuySellItem);
            MarketBuySellItem marketBuySellItem2 = new MarketBuySellItem(0, 6);
            marketBuySellItem2.G(i11);
            marketBuySellItem2.C(tradeType);
            this.f76942i.add(marketBuySellItem2);
        }
    }

    public void P(String str, double d11) {
        if (TextUtils.equals(str, this.f76950q)) {
            int compare = Double.compare(d11, this.f76937d);
            this.f76937d = d11;
            this.f76941h.q(this.f76949p);
            this.f76941h.k(this.f76951r);
            this.f76941h.l(this.f76950q);
            this.f76941h.p(d11);
            if (compare != 0) {
                this.f76941h.n(compare > 0);
            }
            if (d11 == 0.0d || "usd".equals(LegalCurrencyConfigUtil.y())) {
                this.f76941h.o("");
            } else {
                this.f76941h.o(LegalCurrencyConfigUtil.B(String.valueOf(d11)));
            }
            i.b().d(new c(this));
        }
    }

    public final void Q() {
        this.f76945l.clear();
        for (s9.a next : this.f76943j.a()) {
            if (next instanceof ye.a) {
                LinearSwapCurrentOrderInfo g11 = ((ye.a) next).g();
                BigDecimal bigDecimal = new BigDecimal(g11.getPrice());
                if ("buy".equals(g11.getDirection())) {
                    if (BigDecimal.ZERO.compareTo(this.f76944k) != 0) {
                        String plainString = bigDecimal.divide(this.f76944k, 32, 3).setScale(0, 3).multiply(this.f76944k).toPlainString();
                        if (this.f76945l.get(0) == null) {
                            HashSet hashSet = new HashSet();
                            hashSet.add(plainString);
                            this.f76945l.put(0, hashSet);
                        } else {
                            this.f76945l.get(0).add(plainString);
                        }
                    } else if (this.f76945l.get(0) == null) {
                        HashSet hashSet2 = new HashSet();
                        hashSet2.add(m.t0(bigDecimal, FuturePrecisionUtil.y(this.f76951r, this.f76950q, "")));
                        this.f76945l.put(0, hashSet2);
                    } else {
                        this.f76945l.get(0).add(m.t0(bigDecimal, FuturePrecisionUtil.y(this.f76951r, this.f76950q, "")));
                    }
                } else if ("sell".equals(g11.getDirection())) {
                    if (BigDecimal.ZERO.compareTo(this.f76944k) != 0) {
                        String plainString2 = bigDecimal.divide(this.f76944k, 32, 2).setScale(0, 2).multiply(this.f76944k).toPlainString();
                        if (this.f76945l.get(1) == null) {
                            HashSet hashSet3 = new HashSet();
                            hashSet3.add(plainString2);
                            this.f76945l.put(1, hashSet3);
                        } else {
                            this.f76945l.get(1).add(plainString2);
                        }
                    } else if (this.f76945l.get(1) == null) {
                        HashSet hashSet4 = new HashSet();
                        hashSet4.add(m.r0(bigDecimal, FuturePrecisionUtil.y(this.f76951r, this.f76950q, "")));
                        this.f76945l.put(1, hashSet4);
                    } else {
                        this.f76945l.get(1).add(m.r0(bigDecimal, FuturePrecisionUtil.y(this.f76951r, this.f76950q, "")));
                    }
                }
            }
        }
    }

    public void R(String str, String str2, String str3, boolean z11) {
        if (!this.f76947n.equals(str3) || TextUtils.isEmpty(str) || !str.equals(this.f76950q)) {
            U(this.f76950q, this.f76949p, this.f76947n, !z11);
            T(str, str2, str3, z11);
        }
    }

    public void S() {
        this.f76942i.clear();
        this.f76940g.clear();
        F();
        this.f76941h.j();
        this.f76937d = 0.0d;
        this.f76938e = 0.0d;
        this.f76939f = 0.0d;
        l(false);
    }

    public void T(String str, String str2, String str3, boolean z11) {
        if (str2 != null && str != null) {
            S();
            h8.a.a().l(z11, str, str3, this.f76958y);
            h8.a.a().d(this.f76957x);
            this.f76955v = true;
            i6.k.n(str + "==" + str2 + "==" + str3);
            this.f76949p = str2;
            this.f76947n = str3;
            this.f76950q = str;
        }
    }

    public void U(String str, String str2, String str3, boolean z11) {
        if (str2 != null && !TextUtils.isEmpty(this.f76950q) && !TextUtils.isEmpty(this.f76947n)) {
            h8.a.a().l(z11, str, str3, this.f76958y);
            h8.a.a().c(this.f76957x);
            S();
            this.f76949p = "";
            this.f76950q = "";
            this.f76947n = "";
        }
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r7v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r7v3 */
    public final void V(String str, List<MarketBuySellItem> list, List<Double[]> list2, List<Double> list3, int i11, double d11) {
        boolean z11;
        boolean z12;
        String str2;
        List<Double[]> list4 = list2;
        int i12 = i11;
        double d12 = d11;
        double d13 = 0.0d;
        ? r72 = 1;
        ? r82 = 0;
        if (list4 == null) {
            for (MarketBuySellItem next : list) {
                next.H(0.0d);
                next.w(0.0d);
                next.I(0);
                next.z(true);
            }
            return;
        }
        int min = Math.min(20, list2.size());
        int i13 = 0;
        while (i13 < list.size()) {
            MarketBuySellItem marketBuySellItem = list.get(i13);
            marketBuySellItem.D(r82);
            if (i13 >= min) {
                String str3 = str;
                List<Double> list5 = list3;
                z12 = r72;
                z11 = r82;
            } else {
                marketBuySellItem.D(r72);
                marketBuySellItem.z(r82);
                marketBuySellItem.J(str);
                marketBuySellItem.x(this.f76951r);
                marketBuySellItem.y(this.f76950q);
                marketBuySellItem.H(list4.get(i13)[r82].doubleValue());
                marketBuySellItem.F(list4.get(i13)[r72].doubleValue());
                if (e.E(this.f76948o)) {
                    String a11 = FutureUnitUtil.a(String.valueOf(list4.get(i13)[r72]), String.valueOf(list4.get(i13)[r82]), this.f76953t.getContractFace(), this.f76948o);
                    if (TextUtils.isEmpty(a11)) {
                        marketBuySellItem.w(d13);
                    } else {
                        marketBuySellItem.w(Double.valueOf(a11).doubleValue());
                    }
                } else if (e.G(this.f76948o)) {
                    String b11 = FutureUnitUtil.b(String.valueOf(list4.get(i13)[1]), String.valueOf(list4.get(i13)[0]), this.f76953t.getContractFace(), this.f76948o, FuturePrecisionUtil.g(this.f76949p));
                    if (TextUtils.isEmpty(b11)) {
                        marketBuySellItem.w(0.0d);
                    } else {
                        marketBuySellItem.w(Double.valueOf(b11).doubleValue());
                    }
                } else {
                    marketBuySellItem.w(list4.get(i13)[1].doubleValue());
                }
                int doubleValue = (int) (Double.compare(d12, 0.0d) == 0 ? 1.0d : (list3.get(i13).doubleValue() * 100.0d) / d12);
                if (doubleValue < 1) {
                    doubleValue = 1;
                }
                marketBuySellItem.I(doubleValue);
                marketBuySellItem.B(this.f76956w);
                marketBuySellItem.K(i12);
                if (i12 == 0) {
                    if (i13 == 0) {
                        this.f76938e = list4.get(i13)[0].doubleValue();
                    }
                    if (BigDecimal.ZERO.compareTo(this.f76944k) != 0) {
                        str2 = new BigDecimal(String.valueOf(list4.get(i13)[0])).divide(this.f76944k, 32, 3).setScale(0, 3).multiply(this.f76944k).toPlainString();
                    } else {
                        str2 = m.s0(String.valueOf(list4.get(i13)[0]), FuturePrecisionUtil.y(this.f76951r, this.f76950q, ""));
                    }
                } else {
                    if (i13 == 0) {
                        this.f76939f = list4.get(i13)[0].doubleValue();
                    }
                    if (BigDecimal.ZERO.compareTo(this.f76944k) != 0) {
                        str2 = new BigDecimal(String.valueOf(list4.get(i13)[0])).divide(this.f76944k, 32, 2).setScale(0, 2).multiply(this.f76944k).toPlainString();
                    } else {
                        str2 = m.q0(String.valueOf(list4.get(i13)[0]), FuturePrecisionUtil.y(this.f76951r, this.f76950q, ""));
                    }
                }
                if (this.f76945l.get(Integer.valueOf(i11)) == null || !this.f76945l.get(Integer.valueOf(i11)).contains(str2)) {
                    z12 = true;
                    z11 = false;
                    marketBuySellItem.E(false);
                } else {
                    z12 = true;
                    marketBuySellItem.E(true);
                    z11 = false;
                }
            }
            i13++;
            r82 = z11;
            r72 = z12;
            d13 = 0.0d;
        }
    }

    public void W(String str) {
        this.f76941h.m(str);
        l(false);
    }

    public void a() {
        Q();
    }

    public void b(int i11) {
        String str = this.f76950q;
        D(str, this.f76949p, this.f76946m.get(str), i11);
    }

    public double c() {
        return this.f76938e;
    }

    public MarketCurrentPriceItem d() {
        return this.f76941h;
    }

    public double e() {
        return this.f76937d;
    }

    public double f() {
        return this.f76939f;
    }

    public int g() {
        return this.f76954u;
    }

    public boolean h() {
        if (this.f76946m.get(this.f76950q) == null) {
            return true;
        }
        return this.f76946m.get(this.f76950q).isEmpty();
    }

    public void i(String str, FutureContractInfo futureContractInfo, TradeType tradeType) {
        this.f76948o = tradeType;
        this.f76953t = futureContractInfo;
        if (futureContractInfo != null) {
            this.f76951r = futureContractInfo.getContractCode();
        }
        int e11 = SP.e("sp_symbol_depth" + this.f76948o.toString() + futureContractInfo.getContractShortType(), -1);
        if (this.f76946m.get(futureContractInfo.getContractShortType()) != null) {
            D(futureContractInfo.getContractShortType(), str, this.f76946m.get(futureContractInfo.getContractShortType()), e11);
        } else {
            E(this.f76951r).map(i.f61836b).compose(RxJavaHelper.t((g) null)).subscribe(EasySubscriber.create(new d(this, futureContractInfo), new e(this, futureContractInfo, str, e11), f.f61825b, g.f61827b, (Action0) null));
        }
    }

    public void j(int i11) {
        this.f76954u = i11;
    }

    public void k(String str, String str2, boolean z11) {
        U(str, str2, this.f76947n, z11);
    }

    public void l(boolean z11) {
        this.f76935b.clear();
        this.f76936c.clear();
        this.f76935b.addAll(this.f76940g);
        this.f76936c.addAll(this.f76942i);
        this.f76952s.E0(this.f76935b, z11);
        this.f76952s.C0(this.f76936c, z11);
        this.f76952s.H0(this.f76941h);
        this.f76952s.I0();
        this.f76952s.notifyDataSetChanged();
    }
}
