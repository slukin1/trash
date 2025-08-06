package com.huobi.homemarket.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.facebook.appevents.UserDataStore;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.data.HbgDataModuleConfig;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.pro.core.bean.Partitions;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.homemarket.bean.MarketSymbolPriceItem;
import com.huobi.homemarket.presenter.HomeMarketNewPresenter;
import com.huobi.homemarket.ui.HomeMarketNewFragment;
import com.huobi.homemarket.ui.MarketCoinFragment;
import com.huobi.store.AppConfigManager;
import com.iproov.sdk.bridge.OptionsBridge;
import d7.a1;
import i6.d;
import i6.i;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ll.j;
import ol.b;
import rl.l;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sl.f0;
import tl.r;
import tl.s;
import tl.t;
import tl.u;
import u6.g;

public class MarketCoinPresenter extends BaseFragmentPresenter<c> {

    /* renamed from: c  reason: collision with root package name */
    public long f72822c = -1;

    /* renamed from: d  reason: collision with root package name */
    public List<MarketSymbolPriceItem> f72823d;

    /* renamed from: e  reason: collision with root package name */
    public List<s9.a> f72824e;

    /* renamed from: f  reason: collision with root package name */
    public List<s9.a> f72825f;

    /* renamed from: g  reason: collision with root package name */
    public v9.a<s9.a> f72826g;

    /* renamed from: h  reason: collision with root package name */
    public String f72827h;

    /* renamed from: i  reason: collision with root package name */
    public Subscription f72828i;

    /* renamed from: j  reason: collision with root package name */
    public List<SymbolBean> f72829j;

    /* renamed from: k  reason: collision with root package name */
    public String f72830k;

    /* renamed from: l  reason: collision with root package name */
    public String f72831l;

    /* renamed from: m  reason: collision with root package name */
    public String f72832m;

    /* renamed from: n  reason: collision with root package name */
    public ol.b f72833n;

    /* renamed from: o  reason: collision with root package name */
    public Map<String, BigDecimal> f72834o;

    /* renamed from: p  reason: collision with root package name */
    public Map<String, SymbolPrice> f72835p;

    /* renamed from: q  reason: collision with root package name */
    public int f72836q = -1;

    /* renamed from: r  reason: collision with root package name */
    public MarketSymbolPriceItem.a f72837r = new a();

    /* renamed from: s  reason: collision with root package name */
    public long f72838s;

    /* renamed from: t  reason: collision with root package name */
    public f0.b f72839t = new b();

    public class a implements MarketSymbolPriceItem.a {

        /* renamed from: com.huobi.homemarket.presenter.MarketCoinPresenter$a$a  reason: collision with other inner class name */
        public class C0795a implements b.d {
            public C0795a() {
            }

            public void a() {
                f0.g().k(MarketCoinPresenter.this.f72827h);
            }

            public void b(s9.a aVar) {
            }

            public void c() {
                f0.g().k(MarketCoinPresenter.this.f72827h);
            }
        }

        public a() {
        }

        public void a(View view, MarketSymbolPriceItem marketSymbolPriceItem) {
            String j11 = marketSymbolPriceItem.j();
            boolean k11 = MarketModuleConfig.a().k(j11);
            if (MarketCoinPresenter.this.f72833n == null) {
                ol.b unused = MarketCoinPresenter.this.f72833n = new ol.b(MarketCoinPresenter.this.getActivity(), (g) MarketCoinPresenter.this.getUI(), new C0795a());
            }
            MarketCoinPresenter.this.f72833n.v(view, MarketModuleConfig.a().l(), j11, !k11, k11, false, true, marketSymbolPriceItem, TradeType.PRO);
        }
    }

    public class b implements f0.b {

        public class a extends EasySubscriber<List<s9.a>> {
            public a() {
            }

            public void onAfter() {
                super.onAfter();
                ((c) MarketCoinPresenter.this.getUI()).s6(a1.v().C(MarketCoinPresenter.this.f72827h));
            }

            public void onError2(Throwable th2) {
                printLog(th2);
                th2.printStackTrace();
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                d.b(aPIStatusErrorException.toString());
                aPIStatusErrorException.printStackTrace();
            }

            public void onNext(List<s9.a> list) {
                super.onNext(list);
                MarketCoinPresenter.this.G0();
                if (list != null && list.size() > 0) {
                    ((HomeMarketNewPresenter.g0) MarketCoinPresenter.this.A0().getUI()).finishSkeleton();
                    MarketCoinPresenter.this.K0();
                }
            }
        }

        public b() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ List b(List list) {
            long currentTimeMillis = System.currentTimeMillis();
            MarketCoinPresenter marketCoinPresenter = MarketCoinPresenter.this;
            if (currentTimeMillis - marketCoinPresenter.f72838s > 300000) {
                marketCoinPresenter.f72838s = currentTimeMillis;
                Map unused = marketCoinPresenter.f72835p = null;
                Map unused2 = MarketCoinPresenter.this.f72834o = null;
            }
            if (MarketCoinPresenter.this.f72835p == null || MarketCoinPresenter.this.f72835p.size() == 0) {
                Map unused3 = MarketCoinPresenter.this.f72835p = LegalCurrencyConfigUtil.P(TradeType.PRO);
            }
            if (MarketCoinPresenter.this.f72834o == null || MarketCoinPresenter.this.f72834o.size() == 0) {
                Map unused4 = MarketCoinPresenter.this.f72834o = HbgDataModuleConfig.a().a("usdt", MarketCoinPresenter.this.f72835p);
            }
            MarketCoinPresenter.this.B0(new ArrayList(list));
            return MarketCoinPresenter.this.f72825f;
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            if (MarketCoinPresenter.this.f72828i != null) {
                MarketCoinPresenter.this.f72828i.unsubscribe();
            }
            Subscription unused = MarketCoinPresenter.this.f72828i = Observable.just(list).subscribeOn(Schedulers.io()).map(new u(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
        }
    }

    public interface c extends g {
        View a4();

        void b(v9.a<s9.a> aVar);

        void s6(List<Partitions> list);

        void w5();

        void xc();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D0() {
        HomeMarketNewPresenter.g0 g0Var;
        View a42;
        if (getUI() != null && A0() != null && (g0Var = (HomeMarketNewPresenter.g0) A0().getUI()) != null && g0Var.isCanBeSeen() && "TAB_ALL".equalsIgnoreCase(g0Var.r6()) && this.f72827h.equalsIgnoreCase(g0Var.V9()) && (a42 = ((c) getUI()).a4()) != null && a42.findViewById(R$id.fl_quick_trade_entry) != null && !AppConfigManager.g(MgtConfigNumber.QUICK_TRADE.number, "isOpen")) {
            l.f(a42);
        }
    }

    public static /* synthetic */ int E0(MarketSymbolPriceItem marketSymbolPriceItem, MarketSymbolPriceItem marketSymbolPriceItem2) {
        return marketSymbolPriceItem2.k().getWeight() - marketSymbolPriceItem.k().getWeight();
    }

    public static /* synthetic */ int F0(MarketSymbolPriceItem marketSymbolPriceItem, MarketSymbolPriceItem marketSymbolPriceItem2) {
        return marketSymbolPriceItem2.k().getWeight() - marketSymbolPriceItem.k().getWeight();
    }

    public HomeMarketNewPresenter A0() {
        HomeMarketNewFragment homeMarketNewFragment = getUI() instanceof MarketCoinFragment ? (HomeMarketNewFragment) ((MarketCoinFragment) getUI()).getParentFragment() : null;
        if (homeMarketNewFragment == null) {
            return null;
        }
        return (HomeMarketNewPresenter) homeMarketNewFragment.yh();
    }

    public final synchronized void B0(List<SymbolPrice> list) {
        if (this.f72822c == -1) {
            J0(list);
        } else {
            this.f72823d.clear();
            List<SymbolBean> B = a1.v().B(this.f72827h, this.f72822c);
            if (list != null && list.size() > 0 && B != null && B.size() > 0) {
                for (SymbolBean next : B) {
                    if (!next.isHadSt()) {
                        String symbol = next.getSymbol();
                        MarketSymbolPriceItem w02 = w0(next, symbol, (SymbolPrice) null);
                        Iterator<SymbolPrice> it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            SymbolPrice next2 = it2.next();
                            if (!symbol.contains("bt1") && !symbol.contains("bt2") && symbol.equals(next2.getSymbol())) {
                                w02 = w0(next, symbol, next2);
                                break;
                            }
                        }
                        w02.E(true);
                        this.f72823d.add(w02);
                    }
                }
            }
            L0(j.n().m(), j.n().l());
        }
    }

    public void C0() {
        ((c) getUI()).w5();
        this.f72829j = a1.v().k().get(this.f72827h);
    }

    public final void G0() {
        this.f72825f.clear();
        if ("sort_normal".equals(j.n().l()) || TextUtils.isEmpty(j.n().l())) {
            long j11 = this.f72822c;
            if (j11 == 0 || j11 == -1) {
                this.f72825f.addAll(this.f72824e);
                ((c) getUI()).xc();
                this.f72826g.notifyDataSetChanged();
                BaseModuleConfig.a().z("huobiapp_market_market_spot_end", "huobiapp_market_market_spot_end", OptionsBridge.NETWORK_KEY, true);
            }
        }
        this.f72825f.addAll(this.f72823d);
        ((c) getUI()).xc();
        this.f72826g.notifyDataSetChanged();
        BaseModuleConfig.a().z("huobiapp_market_market_spot_end", "huobiapp_market_market_spot_end", OptionsBridge.NETWORK_KEY, true);
    }

    /* renamed from: H0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        Bundle arguments = Q().getArguments();
        if (arguments != null) {
            this.f72827h = arguments.getString("extra_quote_currency");
        }
        if (!TextUtils.isEmpty(this.f72827h)) {
            ((c) getUI()).xc();
            this.f72823d = Collections.synchronizedList(new ArrayList());
            this.f72824e = new ArrayList();
            ArrayList arrayList = new ArrayList();
            this.f72825f = arrayList;
            this.f72826g = new v9.a<>(arrayList);
            ((c) getUI()).b(this.f72826g);
            C0();
            this.f72830k = getActivity().getResources().getString(R$string.n_trade_main_partition);
            this.f72831l = getActivity().getResources().getString(R$string.n_trade_innovate_partition);
            this.f72832m = getActivity().getResources().getString(R$string.n_trade_st_partition);
            f0.g().e(z0(), this.f72839t);
            f0.g().k(z0());
        }
    }

    public void I0() {
        f0.g().j(this.f72827h);
    }

    public final void J0(List<SymbolPrice> list) {
        Iterator<SymbolBean> it2;
        ArrayList arrayList = new ArrayList();
        ArrayList<MarketSymbolPriceItem> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator<SymbolBean> it3 = this.f72829j.iterator();
        while (it3.hasNext()) {
            SymbolBean next = it3.next();
            if (!next.isHadSt()) {
                String symbol = next.getSymbol();
                for (SymbolPrice next2 : list) {
                    if (symbol.contains("bt1") || symbol.contains("bt2")) {
                        it2 = it3;
                    } else {
                        it2 = it3;
                        if (symbol.equals(next2.getSymbol())) {
                            MarketSymbolPriceItem w02 = w0(next, symbol, next2);
                            w02.E(false);
                            arrayList2.add(w02);
                            hashSet.add(symbol);
                        }
                    }
                    it3 = it2;
                }
            }
        }
        for (SymbolBean next3 : this.f72829j) {
            if (!next3.isHadSt()) {
                String symbol2 = next3.getSymbol();
                if (!hashSet.contains(symbol2) && !symbol2.contains("bt1") && !symbol2.contains("bt2")) {
                    MarketSymbolPriceItem w03 = w0(next3, symbol2, (SymbolPrice) null);
                    w03.E(false);
                    arrayList2.add(w03);
                }
            }
        }
        for (MarketSymbolPriceItem marketSymbolPriceItem : arrayList2) {
            if (SymbolBean.FIAT.equals(this.f72827h)) {
                arrayList4.add(marketSymbolPriceItem);
            } else if (SymbolBean.ALTS.equals(this.f72827h)) {
                arrayList3.add(marketSymbolPriceItem);
            } else if (SymbolBean.CRYPTO.equals(this.f72827h)) {
                arrayList5.add(marketSymbolPriceItem);
            } else {
                SymbolBean k11 = marketSymbolPriceItem.k();
                if (UserDataStore.STATE.equals(k11.getSymbolPartition()) || k11.isStTag()) {
                    arrayList8.add(marketSymbolPriceItem);
                } else if (k11.isInnovateTag()) {
                    arrayList7.add(marketSymbolPriceItem);
                } else {
                    arrayList6.add(marketSymbolPriceItem);
                }
            }
        }
        if (SymbolBean.FIAT.equals(this.f72827h)) {
            arrayList.addAll(arrayList4);
        } else if (SymbolBean.CRYPTO.equals(this.f72827h)) {
            arrayList.addAll(arrayList5);
        } else if (SymbolBean.ALTS.equals(this.f72827h)) {
            arrayList.addAll(arrayList3);
        } else {
            N0(arrayList6);
            N0(arrayList7);
            N0(arrayList8);
            if (arrayList6.size() > 0) {
                arrayList.add(new ml.c(this.f72830k, false));
                arrayList.addAll(arrayList6);
            }
            this.f72836q = arrayList.size();
            v0(arrayList, arrayList7, this.f72831l);
            v0(arrayList, arrayList8, this.f72832m);
        }
        this.f72823d.clear();
        this.f72823d.addAll(arrayList2);
        this.f72824e.clear();
        this.f72824e.addAll(arrayList);
        L0(j.n().m(), j.n().l());
    }

    public final void K0() {
        i.b().g(new r(this), 500);
    }

    public final void L0(String str, String str2) {
        if ("type_name".equals(str)) {
            List<MarketSymbolPriceItem> z11 = j.n().z(this.f72823d, str2);
            this.f72823d.clear();
            this.f72823d.addAll(z11);
        } else if ("type_price".equals(str)) {
            List<MarketSymbolPriceItem> A = j.n().A(this.f72823d, str, str2);
            this.f72823d.clear();
            this.f72823d.addAll(A);
        } else if ("type_heigh_low".equals(str)) {
            List<MarketSymbolPriceItem> A2 = j.n().A(this.f72823d, str, str2);
            this.f72823d.clear();
            this.f72823d.addAll(A2);
        } else if ("type_amount".equals(str)) {
            List<MarketSymbolPriceItem> y11 = j.n().y(this.f72823d, str, str2);
            this.f72823d.clear();
            this.f72823d.addAll(y11);
        } else {
            ArrayList arrayList = new ArrayList(this.f72823d);
            Collections.sort(arrayList, s.f29363b);
            this.f72823d.clear();
            this.f72823d.addAll(arrayList);
        }
    }

    public void M0(String str, String str2) {
        if ("sort_normal".equals(j.n().l()) || TextUtils.isEmpty(j.n().l())) {
            long j11 = this.f72822c;
            if (j11 == 0 || j11 == -1) {
                this.f72825f.clear();
                this.f72825f.addAll(this.f72824e);
                ((c) getUI()).xc();
                this.f72826g.notifyDataSetChanged();
                BaseModuleConfig.a().z("huobiapp_market_market_spot_end", "huobiapp_market_market_spot_end", OptionsBridge.NETWORK_KEY, true);
            }
        }
        L0(str, str2);
        this.f72825f.clear();
        this.f72825f.addAll(this.f72823d);
        ((c) getUI()).xc();
        this.f72826g.notifyDataSetChanged();
        BaseModuleConfig.a().z("huobiapp_market_market_spot_end", "huobiapp_market_market_spot_end", OptionsBridge.NETWORK_KEY, true);
    }

    public final void N0(List<MarketSymbolPriceItem> list) {
        Collections.sort(list, t.f29364b);
    }

    public void onPause() {
        super.onPause();
        ol.b bVar = this.f72833n;
        if (bVar != null && bVar.isShowing()) {
            this.f72833n.p();
        }
    }

    public void u0() {
        f0.g().e(this.f72827h, this.f72839t);
    }

    public final void v0(List<s9.a> list, List<MarketSymbolPriceItem> list2, String str) {
        if (list2.size() > 0) {
            if (list.size() == 0) {
                list.add(new ml.c(str, false));
            } else {
                list.add(new ml.c(str, true));
            }
            list.addAll(list2);
        }
    }

    public final MarketSymbolPriceItem w0(SymbolBean symbolBean, String str, SymbolPrice symbolPrice) {
        MarketSymbolPriceItem marketSymbolPriceItem = new MarketSymbolPriceItem();
        String baseCurrency = symbolBean.getBaseCurrency();
        marketSymbolPriceItem.I(symbolBean);
        marketSymbolPriceItem.N(symbolBean.getWeight());
        marketSymbolPriceItem.H(str);
        marketSymbolPriceItem.G(symbolBean.getState());
        TradeType tradeType = TradeType.PRO;
        marketSymbolPriceItem.L(tradeType);
        marketSymbolPriceItem.B(a1.v().S(str));
        marketSymbolPriceItem.t(baseCurrency);
        marketSymbolPriceItem.u(symbolBean.getBaseCurrencyDisplayName());
        marketSymbolPriceItem.C(symbolBean.getQuoteCurrency());
        marketSymbolPriceItem.D(symbolBean.getQuoteCurrencyDisplayName());
        marketSymbolPriceItem.A(symbolBean.isHadaxTag());
        marketSymbolPriceItem.F(symbolBean.isStTag());
        marketSymbolPriceItem.v(this.f72837r);
        if (symbolPrice != null) {
            marketSymbolPriceItem.J(symbolPrice);
            Double close = symbolPrice.getClose();
            if (close != null) {
                marketSymbolPriceItem.w(m.m(String.valueOf(close), PrecisionUtil.x(symbolBean.getSymbol())));
            }
            String n11 = LegalCurrencyConfigUtil.n(marketSymbolPriceItem.j(), tradeType);
            String c11 = m.c(n11, n11);
            Double vol = symbolPrice.getVol();
            if (vol != null) {
                try {
                    marketSymbolPriceItem.z(m.m(LegalCurrencyConfigUtil.E(marketSymbolPriceItem.getQuoteCurrency(), String.valueOf(vol)), 0));
                } catch (NumberFormatException e11) {
                    e11.printStackTrace();
                }
            }
            marketSymbolPriceItem.x(LegalCurrencyConfigUtil.w() + c11);
        }
        return marketSymbolPriceItem;
    }

    public void x0(Long l11) {
        this.f72822c = l11.longValue();
        G0();
        f0.g().k(this.f72827h);
    }

    public int y0() {
        return this.f72836q;
    }

    public String z0() {
        return this.f72827h;
    }
}
