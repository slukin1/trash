package com.hbg.module.kline.presenter;

import a7.e;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import ce.g;
import ce.h;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.MarketBuySellUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.o;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.util.ContractDepthType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.core.util.DepthType;
import com.hbg.lib.network.pro.socket.bean.TradeBuySellData;
import com.hbg.lib.network.pro.socket.listener.MarketDepthListener;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.util.SwapDepthType;
import com.hbg.module.kline.bean.KlineBuySellItem;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import g9.a;
import i6.m;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import k6.c;
import rx.Subscriber;
import rx.subjects.BehaviorSubject;
import td.i;
import u6.f;

public class MarketInfoOrderPresenter extends BaseFragmentPresenter<d> {

    /* renamed from: c  reason: collision with root package name */
    public List<KlineBuySellItem> f23652c;

    /* renamed from: d  reason: collision with root package name */
    public List<KlineBuySellItem> f23653d;

    /* renamed from: e  reason: collision with root package name */
    public String f23654e;

    /* renamed from: f  reason: collision with root package name */
    public String f23655f;

    /* renamed from: g  reason: collision with root package name */
    public TradeType f23656g;

    /* renamed from: h  reason: collision with root package name */
    public ContractCurrencyInfo f23657h;

    /* renamed from: i  reason: collision with root package name */
    public SwapCurrencyInfo f23658i;

    /* renamed from: j  reason: collision with root package name */
    public FutureContractInfo f23659j;

    /* renamed from: k  reason: collision with root package name */
    public BehaviorSubject<TradeBuySellData> f23660k = BehaviorSubject.create();

    /* renamed from: l  reason: collision with root package name */
    public Subscriber<TradeBuySellData> f23661l;

    /* renamed from: m  reason: collision with root package name */
    public a.d f23662m = new g(this);

    /* renamed from: n  reason: collision with root package name */
    public MarketDepthListener f23663n = new a();

    /* renamed from: o  reason: collision with root package name */
    public Handler f23664o = new Handler(Looper.getMainLooper());

    /* renamed from: p  reason: collision with root package name */
    public long f23665p;

    /* renamed from: q  reason: collision with root package name */
    public Runnable f23666q = new b();

    public class a extends MarketDepthListener {
        public a() {
        }

        /* renamed from: j */
        public void f(MarketDepthResponse marketDepthResponse) {
            if (marketDepthResponse != null && marketDepthResponse.getSymbol().equals(MarketInfoOrderPresenter.this.f23654e)) {
                MarketInfoOrderPresenter.this.f23660k.onNext(marketDepthResponse.getTick());
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            if (MarketInfoOrderPresenter.this.getUI() != null) {
                ((d) MarketInfoOrderPresenter.this.getUI()).I4(MarketInfoOrderPresenter.this.f23652c);
                ((d) MarketInfoOrderPresenter.this.getUI()).g4(MarketInfoOrderPresenter.this.f23653d);
                ((d) MarketInfoOrderPresenter.this.getUI()).I7();
                long unused = MarketInfoOrderPresenter.this.f23665p = DateTimeUtils.v();
            }
        }
    }

    public class c extends BaseSubscriber<TradeBuySellData> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(TradeBuySellData tradeBuySellData) {
            super.onNext(tradeBuySellData);
            if (MarketInfoOrderPresenter.this.getUI() != null) {
                MarketInfoOrderPresenter.this.w0();
                ((d) MarketInfoOrderPresenter.this.getUI()).f6().g();
            }
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onCompleted() {
            super.onCompleted();
        }

        public void onError(Throwable th2) {
        }

        public void onStart() {
            super.onStart();
        }
    }

    public interface d extends f {
        void I4(List<? extends c.a> list);

        void I7();

        void Re(String str);

        void g4(List<? extends c.a> list);
    }

    public static String n0(String str, String str2, String str3, String str4, int i11) {
        BigDecimal a11 = m.a(str);
        BigDecimal a12 = m.a(str2);
        return (a11.compareTo(BigDecimal.ZERO) == 0 || a12.compareTo(BigDecimal.ZERO) == 0) ? str : m.m(a11.multiply(new BigDecimal(str3)).divide(a12, 32, RoundingMode.DOWN).toString(), i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p0() {
        u0(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q0(TradeBuySellData tradeBuySellData) {
        List asks = tradeBuySellData.getAsks();
        List bids = tradeBuySellData.getBids();
        int size = CollectionsUtils.b(asks) ? 0 : asks.size();
        int size2 = CollectionsUtils.b(bids) ? 0 : bids.size();
        if (size != 20) {
            if (asks == null) {
                asks = new ArrayList();
            }
            if (size > 20) {
                for (int i11 = 0; i11 < size - 20; i11++) {
                    asks.remove(asks.size() - 1);
                }
            } else {
                for (int i12 = 0; i12 < 20 - size; i12++) {
                    asks.add(new Double[]{Double.valueOf(0.0d), Double.valueOf(0.0d)});
                }
            }
        }
        List list = asks;
        if (size2 != 20) {
            if (bids == null) {
                bids = new ArrayList();
            }
            if (size2 > 20) {
                for (int i13 = 0; i13 < size2 - 20; i13++) {
                    bids.remove(bids.size() - 1);
                }
            } else {
                for (int i14 = 0; i14 < 20 - size2; i14++) {
                    bids.add(new Double[]{Double.valueOf(0.0d), Double.valueOf(0.0d)});
                }
            }
        }
        List list2 = bids;
        List<Double> a11 = MarketBuySellUtils.a(list2, 20);
        List<Double> a12 = MarketBuySellUtils.a(list, 20);
        MarketBuySellUtils.b(a11, a12);
        if (TradeType.isContract(this.f23656g) || TradeType.isSwap(this.f23656g)) {
            v0(this.f23655f, this.f23652c, list, a12, 1);
            v0(this.f23655f, this.f23653d, list2, a11, 0);
            return;
        }
        v0(this.f23654e, this.f23652c, list, a12, 1);
        v0(this.f23654e, this.f23653d, list2, a11, 0);
    }

    public void V() {
        super.V();
        Subscriber<TradeBuySellData> subscriber = this.f23661l;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void Z(boolean z11) {
        super.Z(z11);
        u0(z11);
        if (z11) {
            r0();
            return;
        }
        if (TradeType.isContract(this.f23656g)) {
            q7.a.a().c(this.f23662m);
        } else if (TradeType.isSwap(this.f23656g)) {
            l9.a.a().c(this.f23662m);
        } else if (TradeType.isOption(this.f23656g)) {
            p8.a.a().c(this.f23662m);
        } else if (TradeType.isLinearSwap(this.f23656g)) {
            h8.a.a().c(this.f23662m);
        } else {
            x8.a.a().c(this.f23662m);
        }
        Subscriber<TradeBuySellData> subscriber = this.f23661l;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public String k0() {
        FutureContractInfo futureContractInfo;
        if (TradeType.isContract(this.f23656g)) {
            ContractCurrencyInfo contractCurrencyInfo = this.f23657h;
            if (contractCurrencyInfo != null) {
                return contractCurrencyInfo.getContractFace();
            }
        } else if (TradeType.isSwap(this.f23656g)) {
            SwapCurrencyInfo swapCurrencyInfo = this.f23658i;
            if (swapCurrencyInfo != null) {
                return swapCurrencyInfo.getContractFace();
            }
        } else if (TradeType.isOption(this.f23656g)) {
            FutureContractInfo futureContractInfo2 = this.f23659j;
            if (futureContractInfo2 != null) {
                return futureContractInfo2.getContractFace();
            }
        } else if (TradeType.isLinearSwap(this.f23656g) && (futureContractInfo = this.f23659j) != null) {
            return futureContractInfo.getContractFace();
        }
        return ContractCurrencyUtils.i(l0());
    }

    public String l0() {
        int i11;
        FutureContractInfo futureContractInfo;
        if (TradeType.isContract(this.f23656g)) {
            ContractCurrencyInfo contractCurrencyInfo = this.f23657h;
            if (contractCurrencyInfo != null) {
                return contractCurrencyInfo.getSymbol();
            }
        } else if (TradeType.isSwap(this.f23656g)) {
            SwapCurrencyInfo swapCurrencyInfo = this.f23658i;
            if (swapCurrencyInfo != null) {
                return swapCurrencyInfo.getSymbol();
            }
        } else if (TradeType.isOption(this.f23656g)) {
            FutureContractInfo futureContractInfo2 = this.f23659j;
            if (futureContractInfo2 != null) {
                return futureContractInfo2.getSymbol();
            }
        } else if (TradeType.isLinearSwap(this.f23656g) && (futureContractInfo = this.f23659j) != null) {
            return futureContractInfo.getSymbol();
        }
        if (TextUtils.isEmpty(this.f23654e) || !this.f23654e.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return null;
        }
        String[] split = this.f23654e.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (split == null) {
            i11 = 0;
        } else {
            i11 = split.length;
        }
        if (i11 >= 1) {
            return split[0];
        }
        return null;
    }

    public String m0() {
        int i11;
        if (!TradeType.isLinearSwap(this.f23656g)) {
            return "";
        }
        FutureContractInfo futureContractInfo = this.f23659j;
        if (futureContractInfo != null) {
            return futureContractInfo.getQuoteCurrency();
        }
        if (TextUtils.isEmpty(this.f23654e) || !this.f23654e.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return "";
        }
        String[] split = this.f23654e.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (split == null) {
            i11 = 0;
        } else {
            i11 = split.length;
        }
        return i11 >= 2 ? split[1] : "";
    }

    public void r0() {
        t0();
        if (TradeType.isContract(this.f23656g)) {
            q7.a.a().d(this.f23662m);
        } else if (TradeType.isSwap(this.f23656g)) {
            l9.a.a().d(this.f23662m);
        } else if (TradeType.isOption(this.f23656g)) {
            p8.a.a().d(this.f23662m);
        } else if (TradeType.isLinearSwap(this.f23656g)) {
            h8.a.a().d(this.f23662m);
        } else {
            x8.a.a().d(this.f23662m);
        }
    }

    /* renamed from: s0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, d dVar) {
        super.onUIReady(baseCoreActivity, dVar);
        this.f23652c = new ArrayList();
        this.f23653d = new ArrayList();
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("market_trade_type");
            if (TextUtils.isEmpty(stringExtra)) {
                this.f23656g = TradeType.PRO;
            } else {
                this.f23656g = TradeType.valueOf(stringExtra);
            }
            if (TradeType.isContract(this.f23656g)) {
                this.f23657h = (ContractCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
            } else if (TradeType.isSwap(this.f23656g)) {
                this.f23658i = (SwapCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
            } else if (TradeType.isOption(this.f23656g)) {
                this.f23659j = (FutureContractInfo) intent.getSerializableExtra("contract_currency_info");
            } else if (TradeType.isLinearSwap(this.f23656g)) {
                this.f23659j = (FutureContractInfo) intent.getSerializableExtra("contract_currency_info");
            }
            this.f23654e = intent.getStringExtra("symbolId");
            this.f23655f = intent.getStringExtra("contract_currency_symble");
            ((d) getUI()).Re(this.f23654e);
        }
        ((d) getUI()).f6().g();
        TradeBuySellData tradeBuySellData = new TradeBuySellData();
        tradeBuySellData.setAsks(new ArrayList());
        tradeBuySellData.setBids(new ArrayList());
        tradeBuySellData.setId(0);
        tradeBuySellData.setTs(0);
        this.f23660k.onNext(tradeBuySellData);
    }

    public final void t0() {
        Subscriber<TradeBuySellData> subscriber = this.f23661l;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f23661l = new c();
        this.f23660k.doOnNext(new h(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f23661l);
    }

    public void u0(boolean z11) {
        SymbolBean J = a1.v().J(this.f23654e, this.f23656g);
        if (J == null || !SymbolBean.PRE_ONLINE.equals(J.getState())) {
            if (TradeType.isContract(this.f23656g)) {
                q7.a.a().h(z11, this.f23654e, ContractDepthType.STEP6.step, o.c(), this.f23663n);
            } else if (TradeType.isSwap(this.f23656g)) {
                l9.a.a().h(z11, this.f23654e, SwapDepthType.STEP6.step, o.c(), this.f23663n);
            } else if (TradeType.isOption(this.f23656g)) {
                p8.a.a().h(z11, this.f23654e, DepthType.STEP0.step, o.c(), this.f23663n);
            } else if (TradeType.isLinearSwap(this.f23656g)) {
                h8.a.a().h(z11, this.f23654e, DepthType.STEP0.step, o.c(), this.f23663n);
            } else {
                x8.a.a().h(z11, this.f23654e, DepthType.STEP0.step, o.c(), this.f23663n);
            }
        } else if (J.isWhiteEnabled()) {
            x8.a.a().h(z11, this.f23654e, DepthType.STEP0.step, o.c(), this.f23663n);
        }
    }

    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v3 */
    public final void v0(String str, List<KlineBuySellItem> list, List<Double[]> list2, List<Double> list3, int i11) {
        KlineBuySellItem klineBuySellItem;
        int i12;
        FutureContractInfo futureContractInfo;
        String str2 = str;
        List<KlineBuySellItem> list4 = list;
        List<Double[]> list5 = list2;
        List<Double> list6 = list3;
        int min = Math.min(20, list2.size());
        char c11 = 0;
        ? r82 = 1;
        boolean z11 = list.size() != min;
        if (z11) {
            list.clear();
        }
        int i13 = 0;
        while (i13 < min) {
            if (z11) {
                klineBuySellItem = new KlineBuySellItem();
                list4.add(klineBuySellItem);
            } else {
                klineBuySellItem = list4.get(i13);
            }
            klineBuySellItem.z(this.f23656g);
            int i14 = i13 + 1;
            klineBuySellItem.C(i14);
            klineBuySellItem.G(2);
            klineBuySellItem.A(r82);
            klineBuySellItem.F(str2);
            if (TradeType.isContract(this.f23656g)) {
                ContractCurrencyInfo contractCurrencyInfo = this.f23657h;
                if (contractCurrencyInfo != null) {
                    klineBuySellItem.x(contractCurrencyInfo.getContractCode());
                }
            } else if (TradeType.isOption(this.f23656g)) {
                FutureContractInfo futureContractInfo2 = this.f23659j;
                if (futureContractInfo2 != null) {
                    klineBuySellItem.x(futureContractInfo2.getContractCode());
                    klineBuySellItem.B(this.f23659j.getOptionCode());
                }
            } else if (TradeType.isLinearSwap(this.f23656g) && (futureContractInfo = this.f23659j) != null) {
                klineBuySellItem.x(futureContractInfo.getContractCode());
                klineBuySellItem.y(this.f23659j.getContractShortType());
            }
            klineBuySellItem.D(list5.get(i13)[c11].doubleValue());
            klineBuySellItem.w(list5.get(i13)[r82].doubleValue());
            double doubleValue = list6.get(i13).doubleValue();
            double doubleValue2 = list6.get(min - 1).doubleValue();
            int i15 = (int) (Double.compare(doubleValue2, 0.0d) == 0 ? 1.0d : (doubleValue * 100.0d) / doubleValue2);
            if (i15 < 1) {
                i15 = 1;
            }
            boolean z12 = TradeType.isContract(this.f23656g) && e.E(TradeType.CONTRACT);
            boolean z13 = TradeType.isSwap(this.f23656g) && e.E(TradeType.SWAP);
            boolean z14 = TradeType.isOption(this.f23656g) && e.E(this.f23656g);
            if (z12 || z13) {
                String valueOf = String.valueOf(klineBuySellItem.e());
                String valueOf2 = String.valueOf(klineBuySellItem.a());
                if (z12) {
                    i12 = i.a().b().t(this.f23657h.getContractCode());
                } else {
                    i12 = i.a().b().G(str2);
                }
                klineBuySellItem.w(m.h0(n0(valueOf, valueOf2, k0(), l0(), i12)));
            } else {
                int i16 = 8;
                if (z14) {
                    FutureContractInfo futureContractInfo3 = this.f23659j;
                    if (futureContractInfo3 != null) {
                        i16 = FuturePrecisionUtil.s(futureContractInfo3.getContractCode(), this.f23659j.getContractShortType(), this.f23659j.getOptionCode());
                    }
                    klineBuySellItem.w(m.h0(m.m(FutureUnitUtil.a(String.valueOf(klineBuySellItem.e()), "", k0(), this.f23656g), i16)));
                } else if (TradeType.isLinearSwap(this.f23656g) && e.F(this.f23656g)) {
                    FutureContractInfo futureContractInfo4 = this.f23659j;
                    if (futureContractInfo4 != null) {
                        i16 = FuturePrecisionUtil.s(futureContractInfo4.getContractCode(), this.f23659j.getContractShortType(), this.f23659j.getOptionCode());
                    }
                    String valueOf3 = String.valueOf(klineBuySellItem.e());
                    String k02 = k0();
                    TradeType tradeType = this.f23656g;
                    klineBuySellItem.w(m.h0(m.m(FutureUnitUtil.c(valueOf3, "", k02, tradeType, e.F(tradeType)), i16)));
                }
            }
            klineBuySellItem.E(i15);
            klineBuySellItem.H(i11);
            i13 = i14;
            c11 = 0;
            r82 = 1;
        }
    }

    public final void w0() {
        boolean z11 = DateTimeUtils.v() - this.f23665p > 400;
        this.f23664o.removeCallbacks(this.f23666q);
        if (z11) {
            this.f23666q.run();
        } else {
            this.f23664o.postDelayed(this.f23666q, 200);
        }
    }
}
