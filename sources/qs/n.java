package qs;

import a7.e;
import android.text.TextUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.MarketBuySellUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrentOrderInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.network.swap.core.util.SwapDepthType;
import com.huobi.contract.entity.ContractDepth;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.swap.bean.SwapCurrentOrderItem;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import ct.c;
import g9.a;
import i6.i;
import i6.k;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import qk.t;
import qs.h1;
import rx.Observable;
import rx.functions.Action0;
import ts.a4;
import u6.g;

public class n implements h1.j {

    /* renamed from: b  reason: collision with root package name */
    public List<ContractDepth> f84644b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<ContractDepth> f84645c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<MarketBuySellItem> f84646d;

    /* renamed from: e  reason: collision with root package name */
    public List<MarketBuySellItem> f84647e;

    /* renamed from: f  reason: collision with root package name */
    public double f84648f;

    /* renamed from: g  reason: collision with root package name */
    public double f84649g;

    /* renamed from: h  reason: collision with root package name */
    public double f84650h;

    /* renamed from: i  reason: collision with root package name */
    public List<MarketBuySellItem> f84651i;

    /* renamed from: j  reason: collision with root package name */
    public MarketCurrentPriceItem f84652j;

    /* renamed from: k  reason: collision with root package name */
    public List<MarketBuySellItem> f84653k;

    /* renamed from: l  reason: collision with root package name */
    public h1 f84654l;

    /* renamed from: m  reason: collision with root package name */
    public BigDecimal f84655m = BigDecimal.ZERO;

    /* renamed from: n  reason: collision with root package name */
    public Map<Integer, Set<String>> f84656n = new HashMap();

    /* renamed from: o  reason: collision with root package name */
    public Map<String, List<ContractDepth>> f84657o;

    /* renamed from: p  reason: collision with root package name */
    public String f84658p = SwapDepthType.STEP6.step;

    /* renamed from: q  reason: collision with root package name */
    public TradeType f84659q;

    /* renamed from: r  reason: collision with root package name */
    public String f84660r = "";

    /* renamed from: s  reason: collision with root package name */
    public String f84661s = "";

    /* renamed from: t  reason: collision with root package name */
    public a4 f84662t;

    /* renamed from: u  reason: collision with root package name */
    public SwapCurrencyInfo f84663u;

    /* renamed from: v  reason: collision with root package name */
    public int f84664v = 0;

    /* renamed from: w  reason: collision with root package name */
    public boolean f84665w = true;

    /* renamed from: x  reason: collision with root package name */
    public c f84666x = new d(this);

    /* renamed from: y  reason: collision with root package name */
    public a.d f84667y = new e(this);

    /* renamed from: z  reason: collision with root package name */
    public MarketDepthListener f84668z = new a();

    public class a extends MarketDepthListener {
        public a() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            int i11;
            double d11;
            double d12;
            MarketDepthResponse marketDepthResponse2 = marketDepthResponse;
            if (marketDepthResponse2 != null && marketDepthResponse.getSymbol().equals(n.this.f84661s)) {
                t.c(10);
                if (n.this.f84665w) {
                    k.n(marketDepthResponse2 + "====");
                    boolean unused = n.this.f84665w = false;
                }
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                List<Double> a11 = MarketBuySellUtils.a(bids, 20);
                List<Double> a12 = MarketBuySellUtils.a(asks, 20);
                MarketBuySellUtils.b(a11, a12);
                if (n.this.f84664v == 0) {
                    i11 = Math.min(5, a11.size());
                } else if (n.this.f84664v == 1) {
                    i11 = Math.min(20, a11.size());
                } else {
                    i11 = n.this.f84664v == 2 ? Math.min(0, a11.size()) : 0;
                }
                if (i11 < 1) {
                    d11 = 0.0d;
                } else {
                    d11 = a11.get(i11 - 1).doubleValue();
                }
                if (n.this.f84664v == 0) {
                    i11 = Math.min(5, a12.size());
                } else if (n.this.f84664v == 1) {
                    i11 = Math.min(0, a12.size());
                } else if (n.this.f84664v == 2) {
                    i11 = Math.min(20, a12.size());
                }
                if (i11 < 1) {
                    d12 = 0.0d;
                } else {
                    d12 = a12.get(i11 - 1).doubleValue();
                }
                double max = Math.max(d11, d12);
                n nVar = n.this;
                nVar.W(nVar.f84660r, n.this.f84651i, asks, a12, 1, max);
                n nVar2 = n.this;
                nVar2.W(nVar2.f84660r, n.this.f84653k, bids, a11, 0, max);
                n.this.Y(true);
            }
        }
    }

    public n(a4 a4Var, h1 h1Var, TradeType tradeType) {
        this.f84662t = a4Var;
        this.f84654l = h1Var;
        this.f84659q = tradeType;
        h1Var.C0(this);
        this.f84646d = new ArrayList();
        this.f84647e = new ArrayList();
        this.f84651i = new ArrayList();
        this.f84653k = new ArrayList();
        C();
        D();
        MarketCurrentPriceItem marketCurrentPriceItem = new MarketCurrentPriceItem();
        this.f84652j = marketCurrentPriceItem;
        marketCurrentPriceItem.r(4);
        this.f84657o = new HashMap();
        Y(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List G(SwapCurrencyInfo swapCurrencyInfo) {
        if (m.a(swapCurrencyInfo.getPriceTick()).compareTo(m.a("0.000001")) < 0) {
            return s(swapCurrencyInfo.getPriceTick(), this.f84645c);
        }
        return s(swapCurrencyInfo.getPriceTick(), this.f84644b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(SwapCurrencyInfo swapCurrencyInfo) {
        if (this.f84657o.get(swapCurrencyInfo.getContractShortType()) != null) {
            this.f84657o.get(swapCurrencyInfo.getContractShortType()).clear();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(SwapCurrencyInfo swapCurrencyInfo, String str, int i11, List list) {
        this.f84657o.put(swapCurrencyInfo.getContractShortType(), list);
        u(swapCurrencyInfo.getContractShortType(), str, this.f84657o.get(swapCurrencyInfo.getContractShortType()), i11);
    }

    public static /* synthetic */ void J(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void K(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L() {
        T(this.f84661s, this.f84660r, this.f84658p, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.f84662t.H0(this.f84652j);
    }

    public double A() {
        return this.f84650h;
    }

    public int B() {
        return this.f84664v;
    }

    public final void C() {
        int i11 = 0;
        while (i11 < 20) {
            MarketBuySellItem marketBuySellItem = new MarketBuySellItem(1, 4);
            i11++;
            marketBuySellItem.G(i11);
            this.f84651i.add(marketBuySellItem);
            MarketBuySellItem marketBuySellItem2 = new MarketBuySellItem(0, 4);
            marketBuySellItem2.G(i11);
            this.f84653k.add(marketBuySellItem2);
        }
    }

    public final void D() {
        this.f84644b.add(new ContractDepth("step7", "0.00001"));
        this.f84644b.add(new ContractDepth("step8", "0.0001"));
        this.f84644b.add(new ContractDepth("step9", "0.001"));
        this.f84644b.add(new ContractDepth("step10", "0.01"));
        this.f84644b.add(new ContractDepth("step11", "0.1"));
        this.f84644b.add(new ContractDepth("step12", "1"));
        this.f84644b.add(new ContractDepth("step13", CouponReturn.TYPE_EXPERIENCE));
        List<ContractDepth> list = this.f84645c;
        String str = CouponReturn.TYPE_EXPERIENCE;
        list.add(new ContractDepth("step18", "0.0000001"));
        this.f84645c.add(new ContractDepth("step19", "0.000001"));
        this.f84645c.add(new ContractDepth("step7", "0.00001"));
        this.f84645c.add(new ContractDepth("step8", "0.0001"));
        this.f84645c.add(new ContractDepth("step9", "0.001"));
        this.f84645c.add(new ContractDepth("step10", "0.01"));
        this.f84645c.add(new ContractDepth("step11", "0.1"));
        this.f84645c.add(new ContractDepth("step12", "1"));
        this.f84645c.add(new ContractDepth("step13", str));
    }

    public void N(String str, SwapCurrencyInfo swapCurrencyInfo, TradeType tradeType) {
        this.f84659q = tradeType;
        this.f84663u = swapCurrencyInfo;
        int e11 = SP.e("sp_symbol_depth" + this.f84659q.toString() + swapCurrencyInfo.getContractShortType(), -1);
        if (this.f84657o.get(swapCurrencyInfo.getContractShortType()) != null) {
            u(swapCurrencyInfo.getContractShortType(), str, this.f84657o.get(swapCurrencyInfo.getContractShortType()), e11);
        } else {
            y(str).map(new l(this)).compose(RxJavaHelper.t((g) null)).subscribe(EasySubscriber.create(new g(this, swapCurrencyInfo), new h(this, swapCurrencyInfo, str, e11), i.f70403b, j.f70406b, (Action0) null));
        }
    }

    public void O(String str, double d11) {
        if (TextUtils.equals(str, this.f84661s)) {
            int compare = Double.compare(d11, this.f84648f);
            this.f84648f = d11;
            this.f84652j.q(this.f84660r);
            this.f84652j.p(d11);
            if (compare != 0) {
                this.f84652j.n(compare > 0);
            }
            if (d11 == 0.0d || "usd".equals(LegalCurrencyConfigUtil.y())) {
                this.f84652j.o("");
            } else {
                this.f84652j.o(LegalCurrencyConfigUtil.B(String.valueOf(d11)));
            }
            i.b().d(new f(this));
        }
    }

    public final void P() {
        this.f84656n.clear();
        for (s9.a next : this.f84654l.Q()) {
            if (next instanceof SwapCurrentOrderItem) {
                SwapCurrentOrderInfo d11 = ((SwapCurrentOrderItem) next).d();
                BigDecimal bigDecimal = new BigDecimal(d11.getPrice());
                if ("buy".equals(d11.getDirection())) {
                    if (BigDecimal.ZERO.compareTo(this.f84655m) != 0) {
                        String plainString = bigDecimal.divide(this.f84655m, 32, 3).setScale(0, 3).multiply(this.f84655m).toPlainString();
                        if (this.f84656n.get(0) == null) {
                            HashSet hashSet = new HashSet();
                            hashSet.add(plainString);
                            this.f84656n.put(0, hashSet);
                        } else {
                            this.f84656n.get(0).add(plainString);
                        }
                    } else if (this.f84656n.get(0) == null) {
                        HashSet hashSet2 = new HashSet();
                        hashSet2.add(m.t0(bigDecimal, us.i.f(this.f84660r)));
                        this.f84656n.put(0, hashSet2);
                    } else {
                        this.f84656n.get(0).add(m.t0(bigDecimal, us.i.f(this.f84660r)));
                    }
                } else if ("sell".equals(d11.getDirection())) {
                    if (BigDecimal.ZERO.compareTo(this.f84655m) != 0) {
                        String plainString2 = bigDecimal.divide(this.f84655m, 32, 2).setScale(0, 2).multiply(this.f84655m).toPlainString();
                        if (this.f84656n.get(1) == null) {
                            HashSet hashSet3 = new HashSet();
                            hashSet3.add(plainString2);
                            this.f84656n.put(1, hashSet3);
                        } else {
                            this.f84656n.get(1).add(plainString2);
                        }
                    } else if (this.f84656n.get(1) == null) {
                        HashSet hashSet4 = new HashSet();
                        hashSet4.add(m.r0(bigDecimal, us.i.f(this.f84660r)));
                        this.f84656n.put(1, hashSet4);
                    } else {
                        this.f84656n.get(1).add(m.r0(bigDecimal, us.i.f(this.f84660r)));
                    }
                }
            }
        }
    }

    public final void Q(String str, String str2, String str3, boolean z11) {
        if (!this.f84658p.equals(str3) || TextUtils.isEmpty(str) || !str.equals(this.f84661s)) {
            U(this.f84661s, this.f84660r, this.f84658p, !z11);
            T(str, str2, str3, z11);
        }
    }

    public void R() {
        this.f84653k.clear();
        this.f84651i.clear();
        C();
        this.f84652j.j();
        this.f84648f = 0.0d;
        this.f84649g = 0.0d;
        this.f84650h = 0.0d;
        Y(false);
    }

    public void S(int i11) {
        this.f84664v = i11;
    }

    public void T(String str, String str2, String str3, boolean z11) {
        if (str2 != null && str != null) {
            R();
            l9.a.a().l(z11, str, str3, this.f84668z);
            l9.a.a().d(this.f84667y);
            this.f84665w = true;
            k.n(str + "==" + str2 + "==" + str3);
            this.f84660r = str2;
            this.f84658p = str3;
            this.f84661s = str;
        }
    }

    public final void U(String str, String str2, String str3, boolean z11) {
        if (str2 != null && !TextUtils.isEmpty(this.f84661s) && !TextUtils.isEmpty(this.f84658p)) {
            l9.a.a().l(z11, str, str3, this.f84668z);
            l9.a.a().c(this.f84667y);
            R();
            this.f84660r = "";
            this.f84661s = "";
            this.f84658p = "";
        }
    }

    public void V(String str, String str2, boolean z11) {
        U(str, str2, this.f84658p, z11);
    }

    public final void W(String str, List<MarketBuySellItem> list, List<Double[]> list2, List<Double> list3, int i11, double d11) {
        String str2;
        List<Double[]> list4 = list2;
        int i12 = i11;
        double d12 = d11;
        double d13 = 0.0d;
        if (list4 == null) {
            for (MarketBuySellItem next : list) {
                next.H(0.0d);
                next.w(0.0d);
                next.I(0);
            }
            return;
        }
        int min = Math.min(20, list2.size());
        int i13 = 0;
        while (i13 < list.size()) {
            MarketBuySellItem marketBuySellItem = list.get(i13);
            marketBuySellItem.D(false);
            if (i13 >= min) {
                String str3 = str;
                List<Double> list5 = list3;
            } else {
                marketBuySellItem.D(true);
                marketBuySellItem.z(false);
                marketBuySellItem.J(str);
                marketBuySellItem.H(list4.get(i13)[0].doubleValue());
                marketBuySellItem.F(list4.get(i13)[1].doubleValue());
                if (!e.E(TradeType.SWAP)) {
                    marketBuySellItem.w(list4.get(i13)[1].doubleValue());
                } else if (list4.get(i13)[0].doubleValue() != d13) {
                    marketBuySellItem.w((list4.get(i13)[1].doubleValue() * Double.valueOf(this.f84663u.getContractFace()).doubleValue()) / list4.get(i13)[0].doubleValue());
                } else {
                    marketBuySellItem.w(d13);
                }
                int doubleValue = (int) (Double.compare(d12, d13) == 0 ? 1.0d : (list3.get(i13).doubleValue() * 100.0d) / d12);
                if (doubleValue < 1) {
                    doubleValue = 1;
                }
                marketBuySellItem.I(doubleValue);
                marketBuySellItem.B(this.f84666x);
                marketBuySellItem.K(i12);
                if (i12 == 0) {
                    if (i13 == 0) {
                        this.f84649g = list4.get(i13)[0].doubleValue();
                    }
                    if (BigDecimal.ZERO.compareTo(this.f84655m) != 0) {
                        str2 = new BigDecimal(String.valueOf(list4.get(i13)[0])).divide(this.f84655m, 32, 3).setScale(0, 3).multiply(this.f84655m).toPlainString();
                    } else {
                        str2 = m.s0(String.valueOf(list4.get(i13)[0]), us.i.f(this.f84660r));
                    }
                } else {
                    if (i13 == 0) {
                        this.f84650h = list4.get(i13)[0].doubleValue();
                    }
                    if (BigDecimal.ZERO.compareTo(this.f84655m) != 0) {
                        str2 = new BigDecimal(String.valueOf(list4.get(i13)[0])).divide(this.f84655m, 32, 2).setScale(0, 2).multiply(this.f84655m).toPlainString();
                    } else {
                        str2 = m.q0(String.valueOf(list4.get(i13)[0]), us.i.f(this.f84660r));
                    }
                }
                if (this.f84656n.get(Integer.valueOf(i11)) == null || !this.f84656n.get(Integer.valueOf(i11)).contains(str2)) {
                    marketBuySellItem.E(false);
                } else {
                    marketBuySellItem.E(true);
                }
            }
            i13++;
            d13 = 0.0d;
        }
    }

    public void X(String str) {
        this.f84652j.m(str);
        Y(false);
    }

    public void Y(boolean z11) {
        this.f84646d.clear();
        this.f84647e.clear();
        this.f84646d.addAll(this.f84651i);
        this.f84647e.addAll(this.f84653k);
        this.f84662t.E0(this.f84646d, z11);
        this.f84662t.C0(this.f84647e, z11);
        this.f84662t.H0(this.f84652j);
        this.f84662t.I0();
        this.f84662t.notifyDataSetChanged();
    }

    public void a() {
        P();
    }

    public final List<ContractDepth> s(String str, List<ContractDepth> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i11 = 0;
        if (m.a(str).compareTo(m.a(list.get(0).getPriceTick())) < 0) {
            ContractDepth contractDepth = new ContractDepth("step6", str);
            contractDepth.setDepth(String.valueOf(1));
            arrayList.add(contractDepth);
            while (i11 < size) {
                ContractDepth contractDepth2 = list.get(i11);
                ContractDepth contractDepth3 = new ContractDepth(contractDepth2.getStep(), contractDepth2.getPriceTick());
                contractDepth3.setDepth(String.valueOf(arrayList.size() + 1));
                arrayList.add(contractDepth3);
                i11++;
            }
        } else {
            boolean z11 = false;
            while (i11 < size) {
                ContractDepth contractDepth4 = list.get(i11);
                ContractDepth contractDepth5 = new ContractDepth(contractDepth4.getStep(), contractDepth4.getPriceTick());
                if (m.a(contractDepth5.getPriceTick()).compareTo(m.a(str)) == 0) {
                    z11 = true;
                }
                if (z11) {
                    contractDepth5.setDepth(String.valueOf(arrayList.size() + 1));
                    arrayList.add(contractDepth5);
                }
                i11++;
            }
        }
        return arrayList;
    }

    public void t(int i11) {
        String str = this.f84661s;
        u(str, this.f84660r, this.f84657o.get(str), i11);
    }

    public final void u(String str, String str2, List<ContractDepth> list, int i11) {
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
            this.f84662t.V0(list, i12);
            SP.q("sp_symbol_depth" + this.f84659q.toString() + str, i12);
            Q(str, str2, list.get(i12).getStep(), true);
            if (list.size() - 1 >= i12) {
                this.f84655m = m.a(list.get(i12).getPriceTick());
                a();
                this.f84662t.N0(list.get(i12), i12 + 1);
            }
        }
    }

    public double v() {
        return this.f84649g;
    }

    public MarketCurrentPriceItem w() {
        return this.f84652j;
    }

    public List<ContractDepth> x() {
        if (this.f84657o.get(this.f84661s) == null) {
            return new ArrayList();
        }
        return this.f84657o.get(this.f84661s);
    }

    public Observable<SwapCurrencyInfo> y(String str) {
        return SwapCurrencyInfoController.k().f(true).flatMap(m.f70416b).filter(new k(str));
    }

    public double z() {
        return this.f84648f;
    }
}
