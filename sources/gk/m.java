package gk;

import a7.e;
import android.os.Message;
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
import com.hbg.lib.network.linear.swap.core.util.LinearSwapDepthType;
import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.listener.MarketDetailListener;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.pro.socket.response.MarketDetailResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.contract.entity.ContractDepth;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.edgeengine.widget.view.OrderBookView;
import com.huobi.feature.controller.FutureMarketDepthController;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.xiaomi.mipush.sdk.Constants;
import ct.c;
import g9.a;
import i6.b;
import i6.i;
import i6.k;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import qk.t;
import rx.Observable;
import rx.functions.Action0;
import u6.g;

public class m extends FutureMarketDepthController implements ok.a, b.a {
    public MarketDepthListener A = new a();
    public MarketDetailListener B = new b();

    /* renamed from: b  reason: collision with root package name */
    public List<MarketBuySellItem> f47565b;

    /* renamed from: c  reason: collision with root package name */
    public List<MarketBuySellItem> f47566c;

    /* renamed from: d  reason: collision with root package name */
    public double f47567d;

    /* renamed from: e  reason: collision with root package name */
    public double f47568e;

    /* renamed from: f  reason: collision with root package name */
    public double f47569f;

    /* renamed from: g  reason: collision with root package name */
    public List<MarketBuySellItem> f47570g;

    /* renamed from: h  reason: collision with root package name */
    public MarketCurrentPriceItem f47571h;

    /* renamed from: i  reason: collision with root package name */
    public List<MarketBuySellItem> f47572i;

    /* renamed from: j  reason: collision with root package name */
    public nk.b f47573j;

    /* renamed from: k  reason: collision with root package name */
    public BigDecimal f47574k = BigDecimal.ZERO;

    /* renamed from: l  reason: collision with root package name */
    public Map<Integer, Set<String>> f47575l = new HashMap();

    /* renamed from: m  reason: collision with root package name */
    public Map<String, List<ContractDepth>> f47576m;

    /* renamed from: n  reason: collision with root package name */
    public String f47577n = LinearSwapDepthType.STEP6.step;

    /* renamed from: o  reason: collision with root package name */
    public TradeType f47578o;

    /* renamed from: p  reason: collision with root package name */
    public String f47579p = "";

    /* renamed from: q  reason: collision with root package name */
    public String f47580q = "";

    /* renamed from: r  reason: collision with root package name */
    public String f47581r = "";

    /* renamed from: s  reason: collision with root package name */
    public String f47582s = "";

    /* renamed from: t  reason: collision with root package name */
    public com.huobi.feature.ui.a f47583t;

    /* renamed from: u  reason: collision with root package name */
    public int f47584u = 0;

    /* renamed from: v  reason: collision with root package name */
    public i6.b f47585v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f47586w = true;

    /* renamed from: x  reason: collision with root package name */
    public boolean f47587x = true;

    /* renamed from: y  reason: collision with root package name */
    public c f47588y = new c(this);

    /* renamed from: z  reason: collision with root package name */
    public a.d f47589z = new d(this);

    public class a extends MarketDepthListener {
        public a() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            int i11;
            double d11;
            double d12;
            MarketDepthResponse marketDepthResponse2 = marketDepthResponse;
            if (marketDepthResponse2 != null && marketDepthResponse.getSymbol().equals(m.this.f47580q)) {
                t.e(10);
                if (m.this.f47586w) {
                    k.n(marketDepthResponse2 + "====");
                    boolean unused = m.this.f47586w = false;
                }
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                List<Double> a11 = MarketBuySellUtils.a(bids, 20);
                List<Double> a12 = MarketBuySellUtils.a(asks, 20);
                MarketBuySellUtils.b(a11, a12);
                if (m.this.f47584u == 0) {
                    i11 = Math.min(5, a11.size());
                } else if (m.this.f47584u == 1) {
                    i11 = Math.min(20, a11.size());
                } else {
                    i11 = m.this.f47584u == 2 ? Math.min(0, a11.size()) : 0;
                }
                if (i11 < 1) {
                    d11 = 0.0d;
                } else {
                    d11 = a11.get(i11 - 1).doubleValue();
                }
                if (m.this.f47584u == 0) {
                    i11 = Math.min(5, a12.size());
                } else if (m.this.f47584u == 1) {
                    i11 = Math.min(0, a12.size());
                } else if (m.this.f47584u == 2) {
                    i11 = Math.min(20, a12.size());
                }
                if (i11 < 1) {
                    d12 = 0.0d;
                } else {
                    d12 = a12.get(i11 - 1).doubleValue();
                }
                double max = Math.max(d11, d12);
                m mVar = m.this;
                mVar.d0(mVar.f47579p, m.this.f47570g, asks, a12, 1, max);
                m mVar2 = m.this;
                mVar2.d0(mVar2.f47579p, m.this.f47572i, bids, a11, 0, max);
                m.this.l(true);
            }
        }
    }

    public class b extends MarketDetailListener {
        public b() {
        }

        /* renamed from: j */
        public void f(MarketDetailResponse marketDetailResponse) {
            if (marketDetailResponse != null && marketDetailResponse.getSymbol().equals(m.this.f47580q)) {
                boolean z11 = false;
                if (m.this.f47587x) {
                    k.n(marketDetailResponse + "===");
                    boolean unused = m.this.f47587x = false;
                }
                double close = marketDetailResponse.getTick().getClose();
                int compare = Double.compare(close, m.this.f47567d);
                double unused2 = m.this.f47567d = close;
                m.this.f47571h.q(m.this.f47579p);
                m.this.f47571h.k(m.this.f47581r);
                m.this.f47571h.l(m.this.f47580q);
                m.this.f47571h.p(close);
                if (compare != 0) {
                    MarketCurrentPriceItem J = m.this.f47571h;
                    if (compare > 0) {
                        z11 = true;
                    }
                    J.n(z11);
                }
                m.this.f47585v.sendEmptyMessage(2);
            }
        }
    }

    public m(com.huobi.feature.ui.a aVar, nk.b bVar, TradeType tradeType) {
        this.f47583t = aVar;
        this.f47573j = bVar;
        this.f47585v = new i6.b("ContractMarketDepthController", this);
        this.f47578o = tradeType;
        this.f47565b = new ArrayList();
        this.f47566c = new ArrayList();
        this.f47570g = new ArrayList();
        this.f47572i = new ArrayList();
        N();
        MarketCurrentPriceItem marketCurrentPriceItem = new MarketCurrentPriceItem();
        this.f47571h = marketCurrentPriceItem;
        marketCurrentPriceItem.r(6);
        this.f47576m = new HashMap();
        l(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q() {
        l(false);
    }

    public static /* synthetic */ List R(FutureContractInfo futureContractInfo) {
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
    public /* synthetic */ void S(String str) {
        if (this.f47576m.get(str) != null) {
            this.f47576m.get(str).clear();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T(String str, String str2, int i11, List list) {
        this.f47576m.put(str, list);
        K(str, str2, this.f47576m.get(str), i11);
    }

    public static /* synthetic */ void U(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void V(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W() {
        a0(this.f47580q, this.f47579p, this.f47577n, true);
    }

    public void K(String str, String str2, List<ContractDepth> list, int i11) {
        if (list != null && !list.isEmpty()) {
            int i12 = 0;
            if (i11 == -1 && TextUtils.equals(str2, "BTC")) {
                int i13 = 0;
                while (true) {
                    if (i13 >= list.size()) {
                        break;
                    } else if (i6.m.a(list.get(i13).getPriceTick()).compareTo(BigDecimal.ONE) == 0) {
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
            this.f47583t.V0(list, i12);
            SP.q("sp_symbol_depth" + this.f47578o.toString() + str, i12);
            Y(str, str2, list.get(i12).getStep(), true);
            if (list.size() - 1 >= i12) {
                this.f47574k = i6.m.a(list.get(i12).getPriceTick());
                a();
                this.f47583t.N0(list.get(i12), i12 + 1);
            }
        }
    }

    public List<ContractDepth> L() {
        if (this.f47576m.get(this.f47580q) == null) {
            return new ArrayList();
        }
        return this.f47576m.get(this.f47580q);
    }

    public Observable<FutureContractInfo> M(String str) {
        return FutureContractInfoController.n().h(TradeType.LINEAR_SWAP, true).flatMap(l.f54840b).filter(new j(str));
    }

    public final void N() {
        int i11 = 0;
        while (i11 < 20) {
            MarketBuySellItem marketBuySellItem = new MarketBuySellItem(1, 6);
            i11++;
            marketBuySellItem.G(i11);
            TradeType tradeType = TradeType.LINEAR_SWAP;
            marketBuySellItem.C(tradeType);
            this.f47570g.add(marketBuySellItem);
            MarketBuySellItem marketBuySellItem2 = new MarketBuySellItem(0, 6);
            marketBuySellItem2.G(i11);
            marketBuySellItem2.C(tradeType);
            this.f47572i.add(marketBuySellItem2);
        }
    }

    public void X(String str, String str2, String str3, TradeType tradeType) {
        String str4;
        this.f47578o = tradeType;
        this.f47582s = str3;
        this.f47581r = str;
        try {
            str4 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0];
        } catch (Throwable unused) {
            str4 = "";
        }
        int e11 = SP.e("sp_symbol_depth" + this.f47578o.toString() + str2, -1);
        if (this.f47576m.get(str2) != null) {
            K(str2, str4, this.f47576m.get(str2), e11);
        } else {
            M(this.f47581r).map(k.f54839b).compose(RxJavaHelper.t((g) null)).subscribe(EasySubscriber.create(new f(this, str2), new g(this, str2, str4, e11), h.f54836b, i.f54837b, (Action0) null));
        }
    }

    public void Y(String str, String str2, String str3, boolean z11) {
        if (!this.f47577n.equals(str3) || TextUtils.isEmpty(str) || !str.equals(this.f47580q)) {
            c0(this.f47580q, this.f47579p, this.f47577n, !z11);
            a0(str, str2, str3, z11);
        }
    }

    public void Z() {
        this.f47572i.clear();
        this.f47570g.clear();
        N();
        this.f47571h.j();
        this.f47567d = 0.0d;
        this.f47568e = 0.0d;
        this.f47569f = 0.0d;
        l(false);
    }

    public void a() {
    }

    public void a0(String str, String str2, String str3, boolean z11) {
        if (str2 != null && str != null) {
            Z();
            h8.a.a().l(z11, str, str3, this.A);
            h8.a.a().j(z11, str, this.B);
            h8.a.a().d(this.f47589z);
            this.f47586w = true;
            this.f47587x = true;
            k.n(str + "==" + str2 + "==" + str3);
            this.f47579p = str2;
            this.f47577n = str3;
            this.f47580q = str;
        }
    }

    public void b(int i11) {
        String str = this.f47580q;
        K(str, this.f47579p, this.f47576m.get(str), i11);
    }

    public void b0() {
        k(this.f47580q, this.f47579p, false);
    }

    public double c() {
        return this.f47568e;
    }

    public void c0(String str, String str2, String str3, boolean z11) {
        if (str2 != null && !TextUtils.isEmpty(this.f47580q) && !TextUtils.isEmpty(this.f47577n)) {
            h8.a.a().l(z11, str, str3, this.A);
            h8.a.a().j(z11, str, this.B);
            h8.a.a().c(this.f47589z);
            Z();
            this.f47579p = "";
            this.f47580q = "";
            this.f47577n = "";
        }
    }

    public MarketCurrentPriceItem d() {
        return this.f47571h;
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r7v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r7v3 */
    public final void d0(String str, List<MarketBuySellItem> list, List<Double[]> list2, List<Double> list3, int i11, double d11) {
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
                marketBuySellItem.x(this.f47581r);
                marketBuySellItem.y(this.f47580q);
                marketBuySellItem.H(list4.get(i13)[r82].doubleValue());
                marketBuySellItem.F(list4.get(i13)[r72].doubleValue());
                if (e.E(this.f47578o)) {
                    String a11 = FutureUnitUtil.a(String.valueOf(list4.get(i13)[r72]), String.valueOf(list4.get(i13)[r82]), this.f47582s, this.f47578o);
                    if (TextUtils.isEmpty(a11)) {
                        marketBuySellItem.w(d13);
                    } else {
                        marketBuySellItem.w(Double.valueOf(a11).doubleValue());
                    }
                } else if (e.G(this.f47578o)) {
                    String b11 = FutureUnitUtil.b(String.valueOf(list4.get(i13)[1]), String.valueOf(list4.get(i13)[0]), this.f47582s, this.f47578o, FuturePrecisionUtil.g(this.f47579p));
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
                marketBuySellItem.B(this.f47588y);
                marketBuySellItem.K(i12);
                if (i12 == 0) {
                    if (i13 == 0) {
                        this.f47568e = list4.get(i13)[0].doubleValue();
                    }
                    if (BigDecimal.ZERO.compareTo(this.f47574k) != 0) {
                        str2 = new BigDecimal(String.valueOf(list4.get(i13)[0])).divide(this.f47574k, 32, 3).setScale(0, 3).multiply(this.f47574k).toPlainString();
                    } else {
                        str2 = i6.m.s0(String.valueOf(list4.get(i13)[0]), FuturePrecisionUtil.y(this.f47581r, this.f47580q, ""));
                    }
                } else {
                    if (i13 == 0) {
                        this.f47569f = list4.get(i13)[0].doubleValue();
                    }
                    if (BigDecimal.ZERO.compareTo(this.f47574k) != 0) {
                        str2 = new BigDecimal(String.valueOf(list4.get(i13)[0])).divide(this.f47574k, 32, 2).setScale(0, 2).multiply(this.f47574k).toPlainString();
                    } else {
                        str2 = i6.m.q0(String.valueOf(list4.get(i13)[0]), FuturePrecisionUtil.y(this.f47581r, this.f47580q, ""));
                    }
                }
                if (this.f47575l.get(Integer.valueOf(i11)) == null || !this.f47575l.get(Integer.valueOf(i11)).contains(str2)) {
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

    public double e() {
        return this.f47567d;
    }

    public void e0(String str) {
        this.f47571h.m(str);
        l(false);
    }

    public double f() {
        return this.f47569f;
    }

    public int g() {
        return this.f47584u;
    }

    public boolean h() {
        if (this.f47576m.get(this.f47580q) == null) {
            return true;
        }
        return this.f47576m.get(this.f47580q).isEmpty();
    }

    public void handleMessage(Message message) {
        double a11 = this.f47571h.a();
        if (a11 == 0.0d || "usd".equals(LegalCurrencyConfigUtil.y())) {
            this.f47571h.o("");
        } else {
            this.f47571h.o(LegalCurrencyConfigUtil.B(String.valueOf(a11)));
        }
        i.b().f(new e(this));
    }

    public void i(String str, FutureContractInfo futureContractInfo, TradeType tradeType) {
    }

    public void j(int i11) {
        this.f47584u = i11;
    }

    public void k(String str, String str2, boolean z11) {
        c0(str, str2, this.f47577n, z11);
    }

    public void l(boolean z11) {
        this.f47565b.clear();
        this.f47566c.clear();
        this.f47565b.addAll(this.f47570g);
        this.f47566c.addAll(this.f47572i);
        if ((this.f47583t instanceof OrderBookView) && this.f47572i.size() > 0 && this.f47570g.size() > 0) {
            ((OrderBookView) this.f47583t).y(this.f47572i.get(0), this.f47570g.get(0));
        }
        this.f47583t.E0(this.f47565b, z11);
        this.f47583t.C0(this.f47566c, z11);
        this.f47583t.H0(this.f47571h);
        this.f47583t.I0();
        this.f47583t.notifyDataSetChanged();
    }
}
