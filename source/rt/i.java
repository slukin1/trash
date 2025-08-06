package rt;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.MarketBuySellUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.DepthsInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.core.util.DepthType;
import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.listener.MarketDetailListener;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.pro.socket.response.MarketDetailResponse;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.LoanOrderItem;
import com.huobi.order.bean.ExchangeOpenOrderItem;
import com.huobi.order.bean.OrderBean;
import com.huobi.trade.bean.DepthItem;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import d7.a1;
import d7.s;
import g9.a;
import i6.b;
import i6.m;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rt.d1;
import rx.Observable;
import u6.g;

public class i implements d1.g, b.a {
    public a.d A = new b(this);

    /* renamed from: b  reason: collision with root package name */
    public Map<String, DepthsInfo> f84796b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public SymbolBean f84797c;

    /* renamed from: d  reason: collision with root package name */
    public double f84798d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<d> f84799e;

    /* renamed from: f  reason: collision with root package name */
    public List<MarketBuySellItem> f84800f;

    /* renamed from: g  reason: collision with root package name */
    public List<MarketBuySellItem> f84801g;

    /* renamed from: h  reason: collision with root package name */
    public double f84802h;

    /* renamed from: i  reason: collision with root package name */
    public String f84803i;

    /* renamed from: j  reason: collision with root package name */
    public List<MarketBuySellItem> f84804j;

    /* renamed from: k  reason: collision with root package name */
    public MarketCurrentPriceItem f84805k;

    /* renamed from: l  reason: collision with root package name */
    public List<MarketBuySellItem> f84806l;

    /* renamed from: m  reason: collision with root package name */
    public int f84807m = -1;

    /* renamed from: n  reason: collision with root package name */
    public d1 f84808n;

    /* renamed from: o  reason: collision with root package name */
    public BigDecimal f84809o = BigDecimal.ZERO;

    /* renamed from: p  reason: collision with root package name */
    public Map<Integer, Set<String>> f84810p = new HashMap();

    /* renamed from: q  reason: collision with root package name */
    public Map<String, List<DepthItem>> f84811q;

    /* renamed from: r  reason: collision with root package name */
    public TradeType f84812r;

    /* renamed from: s  reason: collision with root package name */
    public String f84813s = DepthType.STEP0.step;

    /* renamed from: t  reason: collision with root package name */
    public String f84814t = "";

    /* renamed from: u  reason: collision with root package name */
    public int f84815u = 0;

    /* renamed from: v  reason: collision with root package name */
    public i6.b f84816v;

    /* renamed from: w  reason: collision with root package name */
    public Context f84817w;

    /* renamed from: x  reason: collision with root package name */
    public ct.c f84818x = new a(this);

    /* renamed from: y  reason: collision with root package name */
    public MarketDepthListener f84819y = new a();

    /* renamed from: z  reason: collision with root package name */
    public MarketDetailListener f84820z = new b();

    public class a extends MarketDepthListener {
        public a() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            int i11;
            double d11;
            double d12;
            if (marketDepthResponse != null && marketDepthResponse.getSymbol().equals(i.this.f84814t)) {
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                if (asks != null && bids != null) {
                    List<Double> a11 = MarketBuySellUtils.a(bids, 150);
                    List<Double> a12 = MarketBuySellUtils.a(asks, 150);
                    MarketBuySellUtils.b(a11, a12);
                    if (i.this.f84815u == 0) {
                        i11 = Math.min(5, a11.size());
                    } else if (i.this.f84815u == 1) {
                        i11 = Math.min(150, a11.size());
                    } else {
                        i11 = i.this.f84815u == 2 ? Math.min(0, a11.size()) : 0;
                    }
                    if (i11 < 1) {
                        d11 = 0.0d;
                    } else {
                        d11 = a11.get(i11 - 1).doubleValue();
                    }
                    if (i.this.f84815u == 0) {
                        i11 = Math.min(5, a12.size());
                    } else if (i.this.f84815u == 1) {
                        i11 = Math.min(0, a12.size());
                    } else if (i.this.f84815u == 2) {
                        i11 = Math.min(150, a12.size());
                    }
                    if (i11 < 1) {
                        d12 = 0.0d;
                    } else {
                        d12 = a12.get(i11 - 1).doubleValue();
                    }
                    double max = Math.max(d11, d12);
                    i iVar = i.this;
                    iVar.W(iVar.f84814t, i.this.f84804j, asks, a12, 1, max);
                    i iVar2 = i.this;
                    iVar2.W(iVar2.f84814t, i.this.f84806l, bids, a11, 0, max);
                    i.this.X(true);
                }
            }
        }
    }

    public class b extends MarketDetailListener {
        public b() {
        }

        /* renamed from: j */
        public void f(MarketDetailResponse marketDetailResponse) {
            if (marketDetailResponse != null && marketDetailResponse.getSymbol().equals(i.this.f84814t)) {
                double close = marketDetailResponse.getTick().getClose();
                int compare = Double.compare(close, i.this.f84802h);
                double unused = i.this.f84802h = close;
                i.this.f84805k.q(i.this.f84814t);
                i.this.f84805k.p(close);
                if (compare != 0) {
                    i.this.f84805k.n(compare > 0);
                }
                i.this.f84816v.sendEmptyMessage(1);
            }
        }
    }

    public class c extends BaseSubscriber<List<DepthItem>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f84823b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f84824c;

        public c(String str, int i11) {
            this.f84823b = str;
            this.f84824c = i11;
        }

        public void onStart() {
            super.onStart();
            if (i.this.f84811q.get(this.f84823b) != null) {
                ((List) i.this.f84811q.get(this.f84823b)).clear();
            }
            i.this.D().Y2(new DepthItem(), "--");
        }

        public void onNext(List<DepthItem> list) {
            super.onNext(list);
            i.this.f84811q.put(this.f84823b, list);
            i.this.s(this.f84823b, this.f84824c);
        }
    }

    public interface d extends g {
        void C0(List<MarketBuySellItem> list, boolean z11);

        void E0(List<MarketBuySellItem> list, boolean z11);

        void H0(MarketCurrentPriceItem marketCurrentPriceItem);

        void Mg(double d11, int i11, int i12);

        void Y2(DepthItem depthItem, String str);

        void h2();

        void m2(List<DepthItem> list, int i11);

        void u3(String str);
    }

    public i(d dVar, d1 d1Var, TradeType tradeType, Context context) {
        this.f84808n = d1Var;
        this.f84817w = context;
        this.f84816v = new i6.b("MarketDepthController", this);
        this.f84812r = tradeType;
        if (d1Var != null) {
            d1Var.s0(this);
        }
        this.f84799e = new WeakReference<>(dVar);
        this.f84800f = new ArrayList();
        this.f84801g = new ArrayList();
        this.f84804j = new ArrayList();
        this.f84806l = new ArrayList();
        E();
        this.f84805k = new MarketCurrentPriceItem();
        if (com.hbg.lib.core.util.b.c().f()) {
            this.f84805k.r(1);
        } else {
            this.f84805k.r(0);
        }
        this.f84811q = new HashMap();
        X(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(Map map) {
        this.f84796b.putAll(map);
    }

    public static /* synthetic */ DepthsInfo G(String str, Map map) {
        return (DepthsInfo) map.get(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H() {
        X(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String[] J(String[] strArr) {
        if (this.f84807m < m.U(strArr[0])) {
            this.f84807m = m.U(strArr[0]);
        }
        return strArr;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DepthItem K(String str, String[] strArr) {
        int i11 = this.f84807m;
        if (i11 > -1) {
            return new DepthItem(str, m.m(strArr[0], i11), strArr[0]);
        }
        return new DepthItem(str, strArr[0], strArr[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L() {
        T(this.f84814t, this.f84813s, true);
    }

    public List<MarketBuySellItem> A() {
        return this.f84801g;
    }

    public List<MarketBuySellItem> B() {
        return this.f84800f;
    }

    public int C() {
        return this.f84815u;
    }

    public d D() {
        return (d) this.f84799e.get();
    }

    public final void E() {
        boolean f11 = com.hbg.lib.core.util.b.c().f();
        for (int i11 = 0; i11 < 150; i11++) {
            if (f11) {
                MarketBuySellItem marketBuySellItem = new MarketBuySellItem(1, 1);
                int i12 = i11 + 1;
                marketBuySellItem.G(i12);
                this.f84804j.add(marketBuySellItem);
                MarketBuySellItem marketBuySellItem2 = new MarketBuySellItem(0, 1);
                marketBuySellItem2.G(i12);
                this.f84806l.add(marketBuySellItem2);
            } else {
                MarketBuySellItem marketBuySellItem3 = new MarketBuySellItem(1, 0);
                int i13 = i11 + 1;
                marketBuySellItem3.G(i13);
                this.f84804j.add(marketBuySellItem3);
                MarketBuySellItem marketBuySellItem4 = new MarketBuySellItem(0, 0);
                marketBuySellItem4.G(i13);
                this.f84806l.add(marketBuySellItem4);
            }
        }
    }

    public void M(String str, TradeType tradeType) {
        this.f84812r = tradeType;
        y(str, this.f84812r).flatMap(h.f25837b).map(new f(this)).map(new g(this, str)).toSortedList().compose(RxJavaHelper.t(D())).subscribe(new c(str, SP.e("sp_symbol_depth" + str, -1)));
    }

    public final void N() {
        List<s9.a> list;
        BigDecimal bigDecimal;
        boolean z11;
        this.f84810p.clear();
        d1 d1Var = this.f84808n;
        if (d1Var != null) {
            list = d1Var.L();
        } else {
            list = new ArrayList<>();
        }
        for (s9.a aVar : list) {
            boolean z12 = aVar instanceof OrderBean;
            if (z12 || (aVar instanceof ExchangeOpenOrderItem)) {
                if (z12) {
                    OrderBean orderBean = (OrderBean) aVar;
                    if (!LoanOrderItem.CREATED.equals(orderBean.getState())) {
                        bigDecimal = new BigDecimal(orderBean.getPrice());
                        z11 = orderBean.isBuy();
                    }
                } else {
                    ExchangeOpenOrderItem exchangeOpenOrderItem = (ExchangeOpenOrderItem) aVar;
                    if (!LoanOrderItem.CREATED.equals(exchangeOpenOrderItem.d().getState())) {
                        bigDecimal = new BigDecimal(exchangeOpenOrderItem.d().getPrice());
                        z11 = exchangeOpenOrderItem.f();
                    }
                }
                if (z11) {
                    if (BigDecimal.ZERO.compareTo(this.f84809o) != 0) {
                        String plainString = bigDecimal.divide(this.f84809o, 32, 3).setScale(0, 3).multiply(this.f84809o).toPlainString();
                        if (this.f84810p.get(0) == null) {
                            HashSet hashSet = new HashSet();
                            hashSet.add(plainString);
                            this.f84810p.put(0, hashSet);
                        } else {
                            this.f84810p.get(0).add(plainString);
                        }
                    } else if (this.f84810p.get(0) == null) {
                        HashSet hashSet2 = new HashSet();
                        hashSet2.add(m.t0(bigDecimal, PrecisionUtil.e(this.f84814t)));
                        this.f84810p.put(0, hashSet2);
                    } else {
                        this.f84810p.get(0).add(m.t0(bigDecimal, PrecisionUtil.e(this.f84814t)));
                    }
                } else if (BigDecimal.ZERO.compareTo(this.f84809o) != 0) {
                    String plainString2 = bigDecimal.divide(this.f84809o, 32, 2).setScale(0, 2).multiply(this.f84809o).toPlainString();
                    if (this.f84810p.get(1) == null) {
                        HashSet hashSet3 = new HashSet();
                        hashSet3.add(plainString2);
                        this.f84810p.put(1, hashSet3);
                    } else {
                        this.f84810p.get(1).add(plainString2);
                    }
                } else if (this.f84810p.get(1) == null) {
                    HashSet hashSet4 = new HashSet();
                    hashSet4.add(m.r0(bigDecimal, PrecisionUtil.e(this.f84814t)));
                    this.f84810p.put(1, hashSet4);
                } else {
                    this.f84810p.get(1).add(m.r0(bigDecimal, PrecisionUtil.e(this.f84814t)));
                }
            }
        }
    }

    public final void O(String str, String str2, boolean z11) {
        SymbolBean J = a1.v().J(str, this.f84812r);
        if (TextUtils.isEmpty(str) || !str.equals(this.f84814t) || !this.f84813s.equals(str2) || this.f84797c == null || J == null || J.getState() == null || !J.getState().equals(this.f84797c.getState()) || this.f84797c.isWhiteEnabled() != J.isWhiteEnabled()) {
            U(this.f84814t, this.f84813s, !z11);
            T(str, str2, z11);
        }
    }

    public void P(String str) {
        s(str, SP.e("sp_symbol_depth" + str, -1));
    }

    public void Q() {
        this.f84806l.clear();
        this.f84804j.clear();
        E();
        this.f84805k.j();
        this.f84802h = 0.0d;
        this.f84803i = "";
        X(false);
    }

    public final void R(String str, String str2, boolean z11, SymbolBean symbolBean) {
        Q();
        x8.a.a().l(z11, str, str2, this.f84819y);
        x8.a.a().j(z11, str, this.f84820z);
        this.f84814t = str;
        this.f84813s = str2;
        this.f84797c = symbolBean;
    }

    public void S(int i11) {
        this.f84815u = i11;
    }

    public void T(String str, String str2, boolean z11) {
        if (str != null) {
            SymbolBean J = a1.v().J(str, this.f84812r);
            if (J == null || !SymbolBean.PRE_ONLINE.equals(J.getState())) {
                R(str, str2, z11, J);
            } else if (J.isWhiteEnabled()) {
                R(str, str2, z11, J);
            }
            x8.a.a().d(this.A);
        }
    }

    public void U(String str, String str2, boolean z11) {
        if (str != null && !TextUtils.isEmpty(this.f84814t) && !TextUtils.isEmpty(this.f84813s)) {
            x8.a.a().l(z11, str, str2, this.f84819y);
            x8.a.a().j(z11, str, this.f84820z);
            x8.a.a().c(this.A);
            Q();
            this.f84814t = "";
            this.f84797c = null;
            this.f84813s = "";
        }
    }

    public void V(String str, boolean z11) {
        U(str, this.f84813s, z11);
    }

    public final void W(String str, List<MarketBuySellItem> list, List<Double[]> list2, List<Double> list3, int i11, double d11) {
        String str2;
        String str3 = str;
        List<Double[]> list4 = list2;
        int i12 = i11;
        double d12 = d11;
        int min = Math.min(150, list2.size());
        for (int i13 = 0; i13 < list.size(); i13++) {
            MarketBuySellItem marketBuySellItem = list.get(i13);
            marketBuySellItem.D(false);
            if (i13 >= min) {
                marketBuySellItem.w(0.0d);
                List<Double> list5 = list3;
            } else {
                marketBuySellItem.D(true);
                marketBuySellItem.z(false);
                marketBuySellItem.J(str3);
                marketBuySellItem.H(list4.get(i13)[0].doubleValue());
                marketBuySellItem.w(list4.get(i13)[1].doubleValue());
                int doubleValue = (int) (Double.compare(d12, 0.0d) == 0 ? 1.0d : (list3.get(i13).doubleValue() * 100.0d) / d12);
                if (doubleValue < 1) {
                    doubleValue = 1;
                }
                marketBuySellItem.I(doubleValue);
                marketBuySellItem.B(this.f84818x);
                marketBuySellItem.K(i12);
                if (i12 == 0) {
                    if (BigDecimal.ZERO.compareTo(this.f84809o) != 0) {
                        str2 = new BigDecimal(String.valueOf(list4.get(i13)[0])).divide(this.f84809o, 32, 3).setScale(0, 3).multiply(this.f84809o).toPlainString();
                    } else {
                        str2 = m.s0(String.valueOf(list4.get(i13)[0]), PrecisionUtil.e(str));
                    }
                } else if (BigDecimal.ZERO.compareTo(this.f84809o) != 0) {
                    str2 = new BigDecimal(String.valueOf(list4.get(i13)[0])).divide(this.f84809o, 32, 2).setScale(0, 2).multiply(this.f84809o).toPlainString();
                } else {
                    str2 = m.q0(String.valueOf(list4.get(i13)[0]), PrecisionUtil.e(str));
                }
                if (a1.v().S(str3)) {
                    marketBuySellItem.E(false);
                } else if (this.f84810p.get(Integer.valueOf(i11)) == null || !this.f84810p.get(Integer.valueOf(i11)).contains(str2)) {
                    marketBuySellItem.E(false);
                } else {
                    marketBuySellItem.E(true);
                }
            }
        }
    }

    public void X(boolean z11) {
        this.f84800f.clear();
        this.f84801g.clear();
        this.f84800f.addAll(this.f84804j);
        this.f84801g.addAll(this.f84806l);
        if (D() != null) {
            D().E0(this.f84800f, z11);
            D().C0(this.f84801g, z11);
            D().H0(this.f84805k);
            D().h2();
            int parseInt = Integer.parseInt(m.i(t(this.f84800f, this.f84801g), 0));
            D().Mg(this.f84798d, 100 - parseInt, parseInt);
        }
    }

    public void Y(String str) {
        this.f84805k.m(str);
        X(false);
    }

    public void a() {
        N();
    }

    public void handleMessage(Message message) {
        String str;
        if (TextUtils.isEmpty(this.f84814t) || !a1.v().D(this.f84814t).equalsIgnoreCase("usdt")) {
            str = LegalCurrencyConfigUtil.A(String.valueOf(this.f84805k.a()), this.f84814t, TradeType.PRO);
        } else {
            str = LegalCurrencyConfigUtil.B(String.valueOf(this.f84805k.a()));
        }
        this.f84805k.o(str);
        i6.i.b().f(new c(this));
    }

    public void s(String str, int i11) {
        List list = this.f84811q.get(str);
        if (list != null) {
            int i12 = 0;
            if (i11 != -1) {
                if (list.size() <= i11) {
                    i11 = 0;
                }
                i12 = i11;
            }
            D().m2(list, i12);
            O(str, "step" + i12, true);
            SP.q("sp_symbol_depth" + str, i12);
            if (list.size() - 1 >= i12) {
                this.f84809o = new BigDecimal(((DepthItem) list.get(i12)).e());
                a();
                D().Y2((DepthItem) list.get(i12), String.valueOf(i12 + 1));
            }
        }
    }

    public final double t(List<MarketBuySellItem> list, List<MarketBuySellItem> list2) {
        this.f84798d = 0.0d;
        int min = Math.min(list.size(), list2.size());
        if (min > 5) {
            min = 5;
        }
        double d11 = 0.0d;
        for (int i11 = 0; i11 < min; i11++) {
            d11 += list.get(i11).e();
        }
        double d12 = 0.0d;
        for (int i12 = 0; i12 < min; i12++) {
            d12 += list2.get(i12).e();
        }
        double d13 = d11 + d12;
        this.f84798d = d13;
        if (d13 == 0.0d) {
            return 0.0d;
        }
        return (d12 * 100.0d) / d13;
    }

    public MarketCurrentPriceItem u() {
        return this.f84805k;
    }

    public String v(String str, int i11) {
        List list = this.f84811q.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i12 = 0;
        if (i11 != -1) {
            if (list.size() <= i11) {
                i11 = 0;
            }
            i12 = i11;
        }
        String f11 = ((DepthItem) list.get(i12)).f();
        if (!TextUtils.isEmpty(f11)) {
            return m.a(f11).stripTrailingZeros().toPlainString();
        }
        return null;
    }

    public List<DepthItem> w() {
        if (this.f84811q.get(this.f84814t) == null) {
            return new ArrayList();
        }
        return this.f84811q.get(this.f84814t);
    }

    public String x() {
        return this.f84803i;
    }

    public Observable<DepthsInfo> y(String str, TradeType tradeType) {
        DepthsInfo depthsInfo = this.f84796b.get(str);
        if (depthsInfo != null) {
            return Observable.just(depthsInfo);
        }
        return s.g(false).doOnNext(new d(this)).map(new e(str));
    }

    public double z() {
        return this.f84802h;
    }
}
