package bj;

import a7.e;
import android.text.TextUtils;
import bj.h2;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.MarketBuySellUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.util.ContractDepthType;
import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.contract.ContractModuleConfig;
import com.huobi.contract.entity.ContractCurrentOrderInfo;
import com.huobi.contract.entity.ContractCurrentOrderItem;
import com.huobi.contract.entity.ContractDepth;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import ct.c;
import dj.j4;
import ej.f;
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
import rx.Observable;
import rx.functions.Action0;
import u6.g;

public class b0 implements h2.j {

    /* renamed from: b  reason: collision with root package name */
    public List<ContractDepth> f40757b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<ContractDepth> f40758c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<MarketBuySellItem> f40759d;

    /* renamed from: e  reason: collision with root package name */
    public List<MarketBuySellItem> f40760e;

    /* renamed from: f  reason: collision with root package name */
    public double f40761f;

    /* renamed from: g  reason: collision with root package name */
    public double f40762g;

    /* renamed from: h  reason: collision with root package name */
    public double f40763h;

    /* renamed from: i  reason: collision with root package name */
    public List<MarketBuySellItem> f40764i;

    /* renamed from: j  reason: collision with root package name */
    public MarketCurrentPriceItem f40765j;

    /* renamed from: k  reason: collision with root package name */
    public List<MarketBuySellItem> f40766k;

    /* renamed from: l  reason: collision with root package name */
    public h2 f40767l;

    /* renamed from: m  reason: collision with root package name */
    public BigDecimal f40768m = BigDecimal.ZERO;

    /* renamed from: n  reason: collision with root package name */
    public Map<Integer, Set<String>> f40769n = new HashMap();

    /* renamed from: o  reason: collision with root package name */
    public Map<String, List<ContractDepth>> f40770o;

    /* renamed from: p  reason: collision with root package name */
    public String f40771p = ContractDepthType.STEP6.step;

    /* renamed from: q  reason: collision with root package name */
    public TradeType f40772q;

    /* renamed from: r  reason: collision with root package name */
    public String f40773r = "";

    /* renamed from: s  reason: collision with root package name */
    public String f40774s = "";

    /* renamed from: t  reason: collision with root package name */
    public j4 f40775t;

    /* renamed from: u  reason: collision with root package name */
    public ContractCurrencyInfo f40776u;

    /* renamed from: v  reason: collision with root package name */
    public int f40777v = 0;

    /* renamed from: w  reason: collision with root package name */
    public boolean f40778w = true;

    /* renamed from: x  reason: collision with root package name */
    public c f40779x = new r(this);

    /* renamed from: y  reason: collision with root package name */
    public a.d f40780y = new s(this);

    /* renamed from: z  reason: collision with root package name */
    public MarketDepthListener f40781z = new a();

    public class a extends MarketDepthListener {
        public a() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            int i11;
            double d11;
            double d12;
            MarketDepthResponse marketDepthResponse2 = marketDepthResponse;
            if (marketDepthResponse2 != null && marketDepthResponse.getSymbol().equals(b0.this.f40774s)) {
                ContractModuleConfig.a().k();
                if (b0.this.f40778w) {
                    k.n(marketDepthResponse2 + "====");
                    boolean unused = b0.this.f40778w = false;
                }
                TradeBuySellData tick = marketDepthResponse.getTick();
                List<Double[]> asks = tick.getAsks();
                List<Double[]> bids = tick.getBids();
                List<Double> a11 = MarketBuySellUtils.a(bids, 20);
                List<Double> a12 = MarketBuySellUtils.a(asks, 20);
                MarketBuySellUtils.b(a11, a12);
                if (b0.this.f40777v == 0) {
                    i11 = Math.min(5, a11.size());
                } else if (b0.this.f40777v == 1) {
                    i11 = Math.min(20, a11.size());
                } else {
                    i11 = b0.this.f40777v == 2 ? Math.min(0, a11.size()) : 0;
                }
                if (i11 < 1) {
                    d11 = 0.0d;
                } else {
                    d11 = a11.get(i11 - 1).doubleValue();
                }
                if (b0.this.f40777v == 0) {
                    i11 = Math.min(5, a12.size());
                } else if (b0.this.f40777v == 1) {
                    i11 = Math.min(0, a12.size());
                } else if (b0.this.f40777v == 2) {
                    i11 = Math.min(20, a12.size());
                }
                if (i11 < 1) {
                    d12 = 0.0d;
                } else {
                    d12 = a12.get(i11 - 1).doubleValue();
                }
                double max = Math.max(d11, d12);
                b0 b0Var = b0.this;
                b0Var.W(b0Var.f40773r, b0.this.f40764i, asks, a12, 1, max);
                b0 b0Var2 = b0.this;
                b0Var2.W(b0Var2.f40773r, b0.this.f40766k, bids, a11, 0, max);
                b0.this.Y(true);
            }
        }
    }

    public b0(j4 j4Var, h2 h2Var, TradeType tradeType) {
        this.f40775t = j4Var;
        this.f40767l = h2Var;
        this.f40772q = tradeType;
        h2Var.D0(this);
        this.f40759d = new ArrayList();
        this.f40760e = new ArrayList();
        this.f40764i = new ArrayList();
        this.f40766k = new ArrayList();
        C();
        D();
        MarketCurrentPriceItem marketCurrentPriceItem = new MarketCurrentPriceItem();
        this.f40765j = marketCurrentPriceItem;
        marketCurrentPriceItem.r(3);
        this.f40770o = new HashMap();
        Y(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List G(ContractCurrencyInfo contractCurrencyInfo) {
        if (m.a(contractCurrencyInfo.getPriceTick()).compareTo(m.a("0.000001")) < 0) {
            return s(contractCurrencyInfo.getPriceTick(), this.f40758c);
        }
        return s(contractCurrencyInfo.getPriceTick(), this.f40757b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(ContractCurrencyInfo contractCurrencyInfo) {
        if (this.f40770o.get(contractCurrencyInfo.getContractShortType()) != null) {
            this.f40770o.get(contractCurrencyInfo.getContractShortType()).clear();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(ContractCurrencyInfo contractCurrencyInfo, String str, int i11, List list) {
        this.f40770o.put(contractCurrencyInfo.getContractShortType(), list);
        u(contractCurrencyInfo.getContractShortType(), str, this.f40770o.get(contractCurrencyInfo.getContractShortType()), i11);
    }

    public static /* synthetic */ void J(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void K(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L() {
        T(this.f40774s, this.f40773r, this.f40771p, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.f40775t.H0(this.f40765j);
    }

    public double A() {
        return this.f40763h;
    }

    public int B() {
        return this.f40777v;
    }

    public final void C() {
        int i11 = 0;
        while (i11 < 20) {
            MarketBuySellItem marketBuySellItem = new MarketBuySellItem(1, 3);
            i11++;
            marketBuySellItem.G(i11);
            this.f40764i.add(marketBuySellItem);
            MarketBuySellItem marketBuySellItem2 = new MarketBuySellItem(0, 3);
            marketBuySellItem2.G(i11);
            this.f40766k.add(marketBuySellItem2);
        }
    }

    public final void D() {
        this.f40757b.add(new ContractDepth("step7", "0.00001"));
        this.f40757b.add(new ContractDepth("step8", "0.0001"));
        this.f40757b.add(new ContractDepth("step9", "0.001"));
        this.f40757b.add(new ContractDepth("step10", "0.01"));
        this.f40757b.add(new ContractDepth("step11", "0.1"));
        this.f40757b.add(new ContractDepth("step12", "1"));
        this.f40757b.add(new ContractDepth("step13", CouponReturn.TYPE_EXPERIENCE));
        List<ContractDepth> list = this.f40758c;
        String str = CouponReturn.TYPE_EXPERIENCE;
        list.add(new ContractDepth("step18", "0.0000001"));
        this.f40758c.add(new ContractDepth("step19", "0.000001"));
        this.f40758c.add(new ContractDepth("step7", "0.00001"));
        this.f40758c.add(new ContractDepth("step8", "0.0001"));
        this.f40758c.add(new ContractDepth("step9", "0.001"));
        this.f40758c.add(new ContractDepth("step10", "0.01"));
        this.f40758c.add(new ContractDepth("step11", "0.1"));
        this.f40758c.add(new ContractDepth("step12", "1"));
        this.f40758c.add(new ContractDepth("step13", str));
    }

    public void N(String str, ContractCurrencyInfo contractCurrencyInfo, TradeType tradeType) {
        this.f40772q = tradeType;
        this.f40776u = contractCurrencyInfo;
        int e11 = SP.e("sp_symbol_depth" + this.f40772q.toString() + contractCurrencyInfo.getContractShortType(), -1);
        if (this.f40770o.get(contractCurrencyInfo.getContractShortType()) != null) {
            u(contractCurrencyInfo.getContractShortType(), str, this.f40770o.get(contractCurrencyInfo.getContractShortType()), e11);
        } else {
            y(contractCurrencyInfo.getContractShortType()).map(new y(this)).compose(RxJavaHelper.t((g) null)).subscribe(EasySubscriber.create(new u(this, contractCurrencyInfo), new v(this, contractCurrencyInfo, str, e11), w.f12515b, x.f12521b, (Action0) null));
        }
    }

    public void O(String str, double d11) {
        if (TextUtils.equals(str, this.f40774s)) {
            int compare = Double.compare(d11, this.f40761f);
            this.f40761f = d11;
            this.f40765j.q(this.f40773r);
            this.f40765j.k(this.f40776u.getContractCode());
            this.f40765j.p(d11);
            if (compare != 0) {
                this.f40765j.n(compare > 0);
            }
            if (d11 == 0.0d || "usd".equals(LegalCurrencyConfigUtil.y())) {
                this.f40765j.o("");
            } else {
                this.f40765j.o(LegalCurrencyConfigUtil.B(String.valueOf(d11)));
            }
            i.b().d(new t(this));
        }
    }

    public final void P() {
        this.f40769n.clear();
        for (s9.a next : this.f40767l.R()) {
            if (next instanceof ContractCurrentOrderItem) {
                ContractCurrentOrderInfo d11 = ((ContractCurrentOrderItem) next).d();
                BigDecimal bigDecimal = new BigDecimal(d11.getPrice());
                if ("buy".equals(d11.getDirection())) {
                    if (BigDecimal.ZERO.compareTo(this.f40768m) != 0) {
                        String plainString = bigDecimal.divide(this.f40768m, 32, 3).setScale(0, 3).multiply(this.f40768m).toPlainString();
                        if (this.f40769n.get(0) == null) {
                            HashSet hashSet = new HashSet();
                            hashSet.add(plainString);
                            this.f40769n.put(0, hashSet);
                        } else {
                            this.f40769n.get(0).add(plainString);
                        }
                    } else if (this.f40769n.get(0) == null) {
                        HashSet hashSet2 = new HashSet();
                        hashSet2.add(m.t0(bigDecimal, f.p(this.f40776u.getContractCode())));
                        this.f40769n.put(0, hashSet2);
                    } else {
                        this.f40769n.get(0).add(m.t0(bigDecimal, f.p(this.f40776u.getContractCode())));
                    }
                } else if ("sell".equals(d11.getDirection())) {
                    if (BigDecimal.ZERO.compareTo(this.f40768m) != 0) {
                        String plainString2 = bigDecimal.divide(this.f40768m, 32, 2).setScale(0, 2).multiply(this.f40768m).toPlainString();
                        if (this.f40769n.get(1) == null) {
                            HashSet hashSet3 = new HashSet();
                            hashSet3.add(plainString2);
                            this.f40769n.put(1, hashSet3);
                        } else {
                            this.f40769n.get(1).add(plainString2);
                        }
                    } else if (this.f40769n.get(1) == null) {
                        HashSet hashSet4 = new HashSet();
                        hashSet4.add(m.r0(bigDecimal, f.p(this.f40776u.getContractCode())));
                        this.f40769n.put(1, hashSet4);
                    } else {
                        this.f40769n.get(1).add(m.r0(bigDecimal, f.p(this.f40776u.getContractCode())));
                    }
                }
            }
        }
    }

    public final void Q(String str, String str2, String str3, boolean z11) {
        if (!this.f40771p.equals(str3) || TextUtils.isEmpty(str) || !str.equals(this.f40774s)) {
            U(this.f40774s, this.f40773r, this.f40771p, !z11);
            T(str, str2, str3, z11);
        }
    }

    public void R() {
        this.f40766k.clear();
        this.f40764i.clear();
        C();
        this.f40765j.j();
        this.f40761f = 0.0d;
        this.f40762g = 0.0d;
        this.f40763h = 0.0d;
        Y(false);
    }

    public void S(int i11) {
        this.f40777v = i11;
    }

    public void T(String str, String str2, String str3, boolean z11) {
        if (str2 != null && str != null) {
            R();
            q7.a.a().l(z11, str, str3, this.f40781z);
            q7.a.a().d(this.f40780y);
            this.f40778w = true;
            k.n(str + "==" + str2 + "==" + str3);
            this.f40773r = str2;
            this.f40771p = str3;
            this.f40774s = str;
        }
    }

    public final void U(String str, String str2, String str3, boolean z11) {
        if (str2 != null && !TextUtils.isEmpty(this.f40774s) && !TextUtils.isEmpty(this.f40771p)) {
            q7.a.a().l(z11, str, str3, this.f40781z);
            q7.a.a().c(this.f40780y);
            R();
            this.f40773r = "";
            this.f40774s = "";
            this.f40771p = "";
        }
    }

    public void V(String str, String str2, boolean z11) {
        U(str, str2, this.f40771p, z11);
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
                marketBuySellItem.x(this.f40776u.getContractCode());
                marketBuySellItem.H(list4.get(i13)[0].doubleValue());
                marketBuySellItem.F(list4.get(i13)[1].doubleValue());
                if (!e.E(TradeType.CONTRACT)) {
                    marketBuySellItem.w(list4.get(i13)[1].doubleValue());
                } else if (list4.get(i13)[0].doubleValue() != d13) {
                    marketBuySellItem.w((list4.get(i13)[1].doubleValue() * Double.valueOf(this.f40776u.getContractFace()).doubleValue()) / list4.get(i13)[0].doubleValue());
                } else {
                    marketBuySellItem.w(d13);
                }
                int doubleValue = (int) (Double.compare(d12, d13) == 0 ? 1.0d : (list3.get(i13).doubleValue() * 100.0d) / d12);
                if (doubleValue < 1) {
                    doubleValue = 1;
                }
                marketBuySellItem.I(doubleValue);
                marketBuySellItem.B(this.f40779x);
                marketBuySellItem.K(i12);
                if (i12 == 0) {
                    if (i13 == 0) {
                        this.f40762g = list4.get(i13)[0].doubleValue();
                    }
                    if (BigDecimal.ZERO.compareTo(this.f40768m) != 0) {
                        str2 = new BigDecimal(String.valueOf(list4.get(i13)[0])).divide(this.f40768m, 32, 3).setScale(0, 3).multiply(this.f40768m).toPlainString();
                    } else {
                        str2 = m.s0(String.valueOf(list4.get(i13)[0]), f.p(this.f40776u.getContractCode()));
                    }
                } else {
                    if (i13 == 0) {
                        this.f40763h = list4.get(i13)[0].doubleValue();
                    }
                    if (BigDecimal.ZERO.compareTo(this.f40768m) != 0) {
                        str2 = new BigDecimal(String.valueOf(list4.get(i13)[0])).divide(this.f40768m, 32, 2).setScale(0, 2).multiply(this.f40768m).toPlainString();
                    } else {
                        str2 = m.q0(String.valueOf(list4.get(i13)[0]), f.p(this.f40776u.getContractCode()));
                    }
                }
                if (this.f40769n.get(Integer.valueOf(i11)) == null || !this.f40769n.get(Integer.valueOf(i11)).contains(str2)) {
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
        this.f40765j.m(str);
        Y(false);
    }

    public void Y(boolean z11) {
        this.f40759d.clear();
        this.f40760e.clear();
        this.f40759d.addAll(this.f40764i);
        this.f40760e.addAll(this.f40766k);
        this.f40775t.E0(this.f40759d, z11);
        this.f40775t.C0(this.f40760e, z11);
        this.f40775t.H0(this.f40765j);
        this.f40775t.I0();
        this.f40775t.notifyDataSetChanged();
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
        String str = this.f40774s;
        u(str, this.f40773r, this.f40770o.get(str), i11);
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
            this.f40775t.V0(list, i12);
            SP.q("sp_symbol_depth" + this.f40772q.toString() + str, i12);
            Q(str, str2, list.get(i12).getStep(), true);
            if (list.size() - 1 >= i12) {
                this.f40768m = m.a(list.get(i12).getPriceTick());
                a();
                this.f40775t.N0(list.get(i12), i12 + 1);
            }
        }
    }

    public double v() {
        return this.f40762g;
    }

    public MarketCurrentPriceItem w() {
        return this.f40765j;
    }

    public List<ContractDepth> x() {
        if (this.f40770o.get(this.f40774s) == null) {
            return new ArrayList();
        }
        return this.f40770o.get(this.f40774s);
    }

    public Observable<ContractCurrencyInfo> y(String str) {
        return ContractCurrencyUtils.g(true).flatMap(a0.f12400b).filter(new z(str));
    }

    public double z() {
        return this.f40761f;
    }
}
