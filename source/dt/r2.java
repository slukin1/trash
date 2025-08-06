package dt;

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
import dt.a5;
import g9.a;
import i6.b;
import i6.i;
import i6.m;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.Observable;
import u6.g;

public class r2 implements a5.m, b.a {
    public a.d A = new k2(this);

    /* renamed from: b  reason: collision with root package name */
    public Map<String, DepthsInfo> f84090b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public SymbolBean f84091c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<d> f84092d;

    /* renamed from: e  reason: collision with root package name */
    public List<MarketBuySellItem> f84093e;

    /* renamed from: f  reason: collision with root package name */
    public List<MarketBuySellItem> f84094f;

    /* renamed from: g  reason: collision with root package name */
    public double f84095g;

    /* renamed from: h  reason: collision with root package name */
    public String f84096h;

    /* renamed from: i  reason: collision with root package name */
    public List<MarketBuySellItem> f84097i;

    /* renamed from: j  reason: collision with root package name */
    public MarketCurrentPriceItem f84098j;

    /* renamed from: k  reason: collision with root package name */
    public List<MarketBuySellItem> f84099k;

    /* renamed from: l  reason: collision with root package name */
    public int f84100l = -1;

    /* renamed from: m  reason: collision with root package name */
    public a5 f84101m;

    /* renamed from: n  reason: collision with root package name */
    public BigDecimal f84102n = BigDecimal.ZERO;

    /* renamed from: o  reason: collision with root package name */
    public Map<Integer, Set<String>> f84103o = new HashMap();

    /* renamed from: p  reason: collision with root package name */
    public Map<String, List<DepthItem>> f84104p;

    /* renamed from: q  reason: collision with root package name */
    public TradeType f84105q;

    /* renamed from: r  reason: collision with root package name */
    public String f84106r = DepthType.STEP0.step;

    /* renamed from: s  reason: collision with root package name */
    public String f84107s = "";

    /* renamed from: t  reason: collision with root package name */
    public int f84108t = 0;

    /* renamed from: u  reason: collision with root package name */
    public i6.b f84109u;

    /* renamed from: v  reason: collision with root package name */
    public Context f84110v;

    /* renamed from: w  reason: collision with root package name */
    public ct.c f84111w = new j2(this);

    /* renamed from: x  reason: collision with root package name */
    public MarketDepthListener f84112x = new a();

    /* renamed from: y  reason: collision with root package name */
    public boolean f84113y;

    /* renamed from: z  reason: collision with root package name */
    public MarketDetailListener f84114z = new b();

    public class a extends MarketDepthListener {
        public a() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            int i11;
            double d11;
            double d12;
            if (marketDepthResponse != null && marketDepthResponse.getSymbol().equals(r2.this.f84107s)) {
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                if (asks != null && bids != null) {
                    List<Double> a11 = MarketBuySellUtils.a(bids, 150);
                    List<Double> a12 = MarketBuySellUtils.a(asks, 150);
                    MarketBuySellUtils.b(a11, a12);
                    if (r2.this.f84108t == 0) {
                        i11 = Math.min(5, a11.size());
                    } else if (r2.this.f84108t == 1) {
                        i11 = Math.min(150, a11.size());
                    } else {
                        i11 = r2.this.f84108t == 2 ? Math.min(0, a11.size()) : 0;
                    }
                    if (i11 < 1) {
                        d11 = 0.0d;
                    } else {
                        d11 = a11.get(i11 - 1).doubleValue();
                    }
                    if (r2.this.f84108t == 0) {
                        i11 = Math.min(5, a12.size());
                    } else if (r2.this.f84108t == 1) {
                        i11 = Math.min(0, a12.size());
                    } else if (r2.this.f84108t == 2) {
                        i11 = Math.min(150, a12.size());
                    }
                    if (i11 < 1) {
                        d12 = 0.0d;
                    } else {
                        d12 = a12.get(i11 - 1).doubleValue();
                    }
                    double max = Math.max(d11, d12);
                    r2 r2Var = r2.this;
                    r2Var.Y(r2Var.f84107s, r2.this.f84097i, asks, a12, 1, max);
                    r2 r2Var2 = r2.this;
                    r2Var2.Y(r2Var2.f84107s, r2.this.f84099k, bids, a11, 0, max);
                    r2.this.Z(true);
                }
            }
        }
    }

    public class b extends MarketDetailListener {
        public b() {
        }

        /* renamed from: j */
        public void f(MarketDetailResponse marketDetailResponse) {
            if (marketDetailResponse != null && marketDetailResponse.getSymbol().equals(r2.this.f84107s)) {
                double close = marketDetailResponse.getTick().getClose();
                int compare = Double.compare(close, r2.this.f84095g);
                double unused = r2.this.f84095g = close;
                r2.this.f84098j.q(r2.this.f84107s);
                r2.this.f84098j.p(close);
                if (compare != 0) {
                    boolean unused2 = r2.this.f84113y = compare > 0;
                    r2.this.f84098j.n(r2.this.f84113y);
                }
                r2.this.f84109u.sendEmptyMessage(1);
            }
        }
    }

    public class c extends BaseSubscriber<List<DepthItem>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f84117b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f84118c;

        public c(String str, int i11) {
            this.f84117b = str;
            this.f84118c = i11;
        }

        public void onStart() {
            super.onStart();
            if (r2.this.f84104p.get(this.f84117b) != null) {
                ((List) r2.this.f84104p.get(this.f84117b)).clear();
            }
            r2.this.F().Y2(new DepthItem(), "--");
        }

        public void onNext(List<DepthItem> list) {
            super.onNext(list);
            r2.this.f84104p.put(this.f84117b, list);
            r2.this.u(this.f84117b, this.f84118c);
        }
    }

    public interface d extends g {
        void C0(List<MarketBuySellItem> list, boolean z11);

        void E0(List<MarketBuySellItem> list, boolean z11);

        void H0(MarketCurrentPriceItem marketCurrentPriceItem);

        void Qb(List<DepthItem> list, int i11);

        void Y2(DepthItem depthItem, String str);

        void h2();

        void m2(List<DepthItem> list, int i11);

        void u3(String str);
    }

    public r2(d dVar, a5 a5Var, TradeType tradeType, Context context) {
        this.f84101m = a5Var;
        this.f84110v = context;
        this.f84109u = new i6.b("MarketDepthController", this);
        this.f84105q = tradeType;
        if (a5Var != null) {
            a5Var.t1(this);
        }
        this.f84092d = new WeakReference<>(dVar);
        this.f84093e = new ArrayList();
        this.f84094f = new ArrayList();
        this.f84097i = new ArrayList();
        this.f84099k = new ArrayList();
        G();
        this.f84098j = new MarketCurrentPriceItem();
        if (com.hbg.lib.core.util.b.c().f()) {
            this.f84098j.r(1);
        } else {
            this.f84098j.r(0);
        }
        this.f84104p = new HashMap();
        Z(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(Map map) {
        this.f84090b.putAll(map);
    }

    public static /* synthetic */ DepthsInfo I(String str, Map map) {
        return (DepthsInfo) map.get(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J() {
        Z(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String[] L(String[] strArr) {
        if (this.f84100l < m.U(strArr[0])) {
            this.f84100l = m.U(strArr[0]);
        }
        return strArr;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DepthItem M(String str, String[] strArr) {
        int i11 = this.f84100l;
        if (i11 > -1) {
            return new DepthItem(str, m.m(strArr[0], i11), strArr[0]);
        }
        return new DepthItem(str, strArr[0], strArr[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N() {
        V(this.f84107s, this.f84106r, true);
    }

    public boolean A() {
        return this.f84113y;
    }

    public double B() {
        return this.f84095g;
    }

    public List<MarketBuySellItem> C() {
        return this.f84094f;
    }

    public List<MarketBuySellItem> D() {
        return this.f84093e;
    }

    public int E() {
        return this.f84108t;
    }

    public d F() {
        return (d) this.f84092d.get();
    }

    public final void G() {
        boolean f11 = com.hbg.lib.core.util.b.c().f();
        for (int i11 = 0; i11 < 150; i11++) {
            if (f11) {
                MarketBuySellItem marketBuySellItem = new MarketBuySellItem(1, 1);
                int i12 = i11 + 1;
                marketBuySellItem.G(i12);
                this.f84097i.add(marketBuySellItem);
                MarketBuySellItem marketBuySellItem2 = new MarketBuySellItem(0, 1);
                marketBuySellItem2.G(i12);
                this.f84099k.add(marketBuySellItem2);
            } else {
                MarketBuySellItem marketBuySellItem3 = new MarketBuySellItem(1, 0);
                int i13 = i11 + 1;
                marketBuySellItem3.G(i13);
                this.f84097i.add(marketBuySellItem3);
                MarketBuySellItem marketBuySellItem4 = new MarketBuySellItem(0, 0);
                marketBuySellItem4.G(i13);
                this.f84099k.add(marketBuySellItem4);
            }
        }
    }

    public void O(String str, TradeType tradeType) {
        this.f84105q = tradeType;
        z(str, this.f84105q).flatMap(q2.f54133b).map(new n2(this)).map(new o2(this, str)).toSortedList().compose(RxJavaHelper.t(F())).subscribe(new c(str, SP.e("sp_symbol_depth" + str, -1)));
    }

    public final void P() {
        List<s9.a> list;
        BigDecimal bigDecimal;
        boolean z11;
        this.f84103o.clear();
        a5 a5Var = this.f84101m;
        if (a5Var != null) {
            list = a5Var.n0();
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
                    if (BigDecimal.ZERO.compareTo(this.f84102n) != 0) {
                        String plainString = bigDecimal.divide(this.f84102n, 32, 3).setScale(0, 3).multiply(this.f84102n).toPlainString();
                        if (this.f84103o.get(0) == null) {
                            HashSet hashSet = new HashSet();
                            hashSet.add(plainString);
                            this.f84103o.put(0, hashSet);
                        } else {
                            this.f84103o.get(0).add(plainString);
                        }
                    } else if (this.f84103o.get(0) == null) {
                        HashSet hashSet2 = new HashSet();
                        hashSet2.add(m.t0(bigDecimal, PrecisionUtil.e(this.f84107s)));
                        this.f84103o.put(0, hashSet2);
                    } else {
                        this.f84103o.get(0).add(m.t0(bigDecimal, PrecisionUtil.e(this.f84107s)));
                    }
                } else if (BigDecimal.ZERO.compareTo(this.f84102n) != 0) {
                    String plainString2 = bigDecimal.divide(this.f84102n, 32, 2).setScale(0, 2).multiply(this.f84102n).toPlainString();
                    if (this.f84103o.get(1) == null) {
                        HashSet hashSet3 = new HashSet();
                        hashSet3.add(plainString2);
                        this.f84103o.put(1, hashSet3);
                    } else {
                        this.f84103o.get(1).add(plainString2);
                    }
                } else if (this.f84103o.get(1) == null) {
                    HashSet hashSet4 = new HashSet();
                    hashSet4.add(m.r0(bigDecimal, PrecisionUtil.e(this.f84107s)));
                    this.f84103o.put(1, hashSet4);
                } else {
                    this.f84103o.get(1).add(m.r0(bigDecimal, PrecisionUtil.e(this.f84107s)));
                }
            }
        }
    }

    public final void Q(String str, String str2, boolean z11) {
        SymbolBean J = a1.v().J(str, this.f84105q);
        if (TextUtils.isEmpty(str) || !str.equals(this.f84107s) || !this.f84106r.equals(str2) || this.f84091c == null || J == null || J.getState() == null || !J.getState().equals(this.f84091c.getState()) || this.f84091c.isWhiteEnabled() != J.isWhiteEnabled()) {
            W(this.f84107s, this.f84106r, !z11);
            V(str, str2, z11);
        }
    }

    public void R(String str) {
        u(str, SP.e("sp_symbol_depth" + str, -1));
    }

    public void S() {
        this.f84099k.clear();
        this.f84097i.clear();
        G();
        this.f84098j.j();
        this.f84095g = 0.0d;
        this.f84096h = "";
        Z(false);
    }

    public final void T(String str, String str2, boolean z11, SymbolBean symbolBean) {
        S();
        x8.a.a().l(z11, str, str2, this.f84112x);
        x8.a.a().j(z11, str, this.f84114z);
        this.f84107s = str;
        this.f84106r = str2;
        this.f84091c = symbolBean;
    }

    public void U(int i11) {
        this.f84108t = i11;
    }

    public void V(String str, String str2, boolean z11) {
        if (str != null) {
            SymbolBean J = a1.v().J(str, this.f84105q);
            if (J == null || !SymbolBean.PRE_ONLINE.equals(J.getState())) {
                T(str, str2, z11, J);
            } else if (J.isWhiteEnabled()) {
                T(str, str2, z11, J);
            }
            x8.a.a().d(this.A);
        }
    }

    public void W(String str, String str2, boolean z11) {
        if (str != null && !TextUtils.isEmpty(this.f84107s) && !TextUtils.isEmpty(this.f84106r)) {
            x8.a.a().l(z11, str, str2, this.f84112x);
            x8.a.a().j(z11, str, this.f84114z);
            x8.a.a().c(this.A);
            S();
            this.f84107s = "";
            this.f84091c = null;
            this.f84106r = "";
        }
    }

    public void X(String str, boolean z11) {
        W(str, this.f84106r, z11);
    }

    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r7v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r7v40 */
    public final void Y(String str, List<MarketBuySellItem> list, List<Double[]> list2, List<Double> list3, int i11, double d11) {
        int i12;
        boolean z11;
        boolean z12;
        String str2;
        String str3 = str;
        List<Double[]> list4 = list2;
        int i13 = i11;
        double d12 = d11;
        int min = Math.min(150, list2.size());
        ? r72 = 0;
        int i14 = 0;
        while (i14 < list.size()) {
            MarketBuySellItem marketBuySellItem = list.get(i14);
            marketBuySellItem.D(r72);
            if (i14 >= min) {
                List<Double> list5 = list3;
                i12 = i14;
                z11 = r72;
            } else {
                marketBuySellItem.D(true);
                marketBuySellItem.z(r72);
                marketBuySellItem.J(str3);
                marketBuySellItem.H(list4.get(i14)[r72].doubleValue());
                marketBuySellItem.w(list4.get(i14)[1].doubleValue());
                int i15 = i14;
                int doubleValue = (int) (Double.compare(d12, 0.0d) == 0 ? 1.0d : (list3.get(i14).doubleValue() * 100.0d) / d12);
                if (doubleValue < 1) {
                    doubleValue = 1;
                }
                marketBuySellItem.I(doubleValue);
                marketBuySellItem.B(this.f84111w);
                marketBuySellItem.K(i13);
                if (i13 != 0) {
                    i12 = i15;
                    if (BigDecimal.ZERO.compareTo(this.f84102n) != 0) {
                        z12 = false;
                        str2 = new BigDecimal(String.valueOf(list4.get(i12)[0])).divide(this.f84102n, 32, 2).setScale(0, 2).multiply(this.f84102n).toPlainString();
                    } else {
                        z12 = false;
                        str2 = m.q0(String.valueOf(list4.get(i12)[0]), PrecisionUtil.e(str));
                    }
                } else if (BigDecimal.ZERO.compareTo(this.f84102n) != 0) {
                    i12 = i15;
                    str2 = new BigDecimal(String.valueOf(list4.get(i12)[0])).divide(this.f84102n, 32, 3).setScale(0, 3).multiply(this.f84102n).toPlainString();
                    z12 = false;
                } else {
                    i12 = i15;
                    str2 = m.s0(String.valueOf(list4.get(i12)[0]), PrecisionUtil.e(str));
                    z12 = false;
                }
                if (a1.v().S(str3)) {
                    marketBuySellItem.E(z12);
                    z11 = z12;
                } else if (this.f84103o.get(Integer.valueOf(i11)) == null || !this.f84103o.get(Integer.valueOf(i11)).contains(str2)) {
                    z11 = false;
                    marketBuySellItem.E(false);
                } else {
                    marketBuySellItem.E(true);
                    z11 = false;
                }
            }
            i14 = i12 + 1;
            r72 = z11;
        }
    }

    public void Z(boolean z11) {
        this.f84093e.clear();
        this.f84094f.clear();
        this.f84093e.addAll(this.f84097i);
        this.f84094f.addAll(this.f84099k);
        if (F() != null) {
            F().E0(this.f84093e, z11);
            F().C0(this.f84094f, z11);
            F().H0(this.f84098j);
            F().h2();
        }
    }

    public void a() {
        P();
    }

    public void a0(String str) {
        this.f84098j.m(str);
        Z(false);
    }

    public void handleMessage(Message message) {
        String str;
        if (TextUtils.isEmpty(this.f84107s) || !a1.v().D(this.f84107s).equalsIgnoreCase("usdt")) {
            str = LegalCurrencyConfigUtil.A(String.valueOf(this.f84098j.a()), this.f84107s, TradeType.PRO);
        } else {
            str = LegalCurrencyConfigUtil.B(String.valueOf(this.f84098j.a()));
        }
        this.f84098j.o(str);
        i.b().f(new l2(this));
    }

    public void u(String str, int i11) {
        List list = this.f84104p.get(str);
        if (list != null) {
            int i12 = 0;
            if (i11 != -1) {
                if (list.size() <= i11) {
                    i11 = 0;
                }
                i12 = i11;
            }
            if (com.hbg.lib.core.util.b.c().f()) {
                F().m2(list, i12);
            } else {
                F().Qb(list, i12);
            }
            Q(str, "step" + i12, true);
            SP.q("sp_symbol_depth" + str, i12);
            if (list.size() - 1 >= i12) {
                this.f84102n = new BigDecimal(((DepthItem) list.get(i12)).e());
                a();
                F().Y2((DepthItem) list.get(i12), String.valueOf(i12 + 1));
            }
        }
    }

    public MarketCurrentPriceItem v() {
        return this.f84098j;
    }

    public String w(String str, int i11) {
        List list = this.f84104p.get(str);
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

    public List<DepthItem> x() {
        if (this.f84104p.get(this.f84107s) == null) {
            return new ArrayList();
        }
        return this.f84104p.get(this.f84107s);
    }

    public String y() {
        return this.f84096h;
    }

    public Observable<DepthsInfo> z(String str, TradeType tradeType) {
        DepthsInfo depthsInfo = this.f84090b.get(str);
        if (depthsInfo != null) {
            return Observable.just(depthsInfo);
        }
        return s.g(false).doOnNext(new m2(this)).map(new p2(str));
    }
}
