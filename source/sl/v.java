package sl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import c8.e;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.module.market.MarketModuleConfig;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.homemarket.bean.MarketContractBean;
import com.huobi.homemarket.bean.MarketContractSymbolPriceItem;
import com.huobi.homemarket.bean.MarketIndexPriceItem;
import com.huobi.homemarket.bean.MarketSwapPriceItem;
import com.iproov.sdk.bridge.OptionsBridge;
import ej.f;
import i6.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import ll.j;
import m9.r;
import ml.b;
import ol.b;
import rx.Observable;
import u6.g;
import us.i;

public class v {

    /* renamed from: a  reason: collision with root package name */
    public List<String> f76527a = Arrays.asList(new String[]{"-9527"});

    /* renamed from: b  reason: collision with root package name */
    public Activity f76528b;

    /* renamed from: c  reason: collision with root package name */
    public g f76529c;

    /* renamed from: d  reason: collision with root package name */
    public List<b> f76530d;

    /* renamed from: e  reason: collision with root package name */
    public List<s9.a> f76531e;

    /* renamed from: f  reason: collision with root package name */
    public List<s9.a> f76532f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f76533g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f76534h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f76535i;

    /* renamed from: j  reason: collision with root package name */
    public MarketContractBean f76536j = new MarketContractBean();

    /* renamed from: k  reason: collision with root package name */
    public ol.b f76537k;

    /* renamed from: l  reason: collision with root package name */
    public MarketContractSymbolPriceItem.a f76538l = new n(this);

    /* renamed from: m  reason: collision with root package name */
    public MarketSwapPriceItem.a f76539m = new p(this);

    /* renamed from: n  reason: collision with root package name */
    public MarketIndexPriceItem.a f76540n = new o(this);

    public class a implements b.d {
        public a() {
        }

        public void a() {
            o6.b.g().k("contract_overview_listener_tag");
            e.g().k("index_overview_listener_tag");
            r.g().k("swap_overview_listener_tag");
        }

        public void b(s9.a aVar) {
        }

        public void c() {
            o6.b.g().k("contract_overview_listener_tag");
            e.g().k("index_overview_listener_tag");
            r.g().k("swap_overview_listener_tag");
        }
    }

    public v(Activity activity, g gVar) {
        this.f76528b = activity;
        this.f76529c = gVar;
        this.f76530d = Collections.synchronizedList(new ArrayList());
        this.f76531e = Collections.synchronizedList(new ArrayList());
        this.f76532f = new ArrayList();
    }

    public static /* synthetic */ int A(ml.b bVar, ml.b bVar2) {
        return bVar.b() - bVar2.b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t() {
        if (NetworkStatus.c(BaseApplication.b())) {
            this.f76533g = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u() {
        if (NetworkStatus.c(BaseApplication.b())) {
            this.f76534h = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v() {
        if (NetworkStatus.c(BaseApplication.b())) {
            this.f76535i = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(List list) {
        List<ContractCurrencyInfo> m11 = ContractCurrencyUtils.m();
        if (m11.size() > 0) {
            this.f76536j.setContractCurrencyInfoList(m11);
            E(this.f76536j);
        }
        List<SwapCurrencyInfo> e11 = SwapCurrencyInfoController.k().e();
        if (e11.size() > 0) {
            this.f76536j.setSwapCurrencyInfoList(e11);
            E(this.f76536j);
        }
        List<IndexCurrencyInfo> e12 = IndexCurrencyInfoController.k().e();
        if (e12.size() > 0) {
            this.f76536j.setIndexCurrencyInfoList(e12);
            E(this.f76536j);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(View view, MarketContractSymbolPriceItem marketContractSymbolPriceItem) {
        ContractCurrencyInfo f11;
        if (marketContractSymbolPriceItem != null && (f11 = marketContractSymbolPriceItem.f()) != null) {
            G(view, f11.getContractShortType(), MarketModuleConfig.a().x(), true, true, marketContractSymbolPriceItem, TradeType.CONTRACT);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(View view, MarketSwapPriceItem marketSwapPriceItem) {
        SwapCurrencyInfo i11;
        if (marketSwapPriceItem != null && (i11 = marketSwapPriceItem.i()) != null) {
            G(view, i11.getContractShortType(), MarketModuleConfig.a().v(), true, true, marketSwapPriceItem, TradeType.SWAP);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(View view, MarketIndexPriceItem marketIndexPriceItem) {
        IndexCurrencyInfo f11;
        TradeType tradeType;
        if (marketIndexPriceItem != null && (f11 = marketIndexPriceItem.f()) != null) {
            String contractShortType = f11.getContractShortType();
            if ("usdt".equalsIgnoreCase(f11.getQuoteCurrency())) {
                tradeType = TradeType.LINEAR_SWAP_INDEX;
            } else {
                tradeType = TradeType.CONTRACT_INDEX;
            }
            View view2 = view;
            G(view2, contractShortType, MarketModuleConfig.a().N(), false, true, marketIndexPriceItem, tradeType);
        }
    }

    public void B(v9.a aVar) {
        this.f76532f.clear();
        if (!("sort_normal".equals(j.n().l()) || TextUtils.isEmpty(j.n().l())) || !s()) {
            this.f76532f.addAll(this.f76530d);
        } else {
            this.f76532f.addAll(this.f76531e);
        }
        aVar.notifyDataSetChanged();
        BaseModuleConfig.a().z("huobiapp_market_market_futures_end", "huobiapp_market_market_futures_end", OptionsBridge.NETWORK_KEY, true);
    }

    public void C(boolean z11) {
        ol.b bVar;
        if (!z11 && (bVar = this.f76537k) != null && bVar.isShowing()) {
            this.f76537k.p();
        }
    }

    public void D() {
        this.f76533g = false;
        this.f76534h = false;
        this.f76535i = false;
    }

    public final void E(MarketContractBean marketContractBean) {
        List<SwapCurrencyInfo> swapCurrencyInfoList;
        List<ContractCurrencyInfo> contractCurrencyInfoList;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        if (!MarketModuleConfig.a().d() && (contractCurrencyInfoList = marketContractBean.getContractCurrencyInfoList()) != null && !contractCurrencyInfoList.isEmpty()) {
            linkedHashSet.addAll(ContractCurrencyUtils.l());
        }
        if (!MarketModuleConfig.a().D() && (swapCurrencyInfoList = marketContractBean.getSwapCurrencyInfoList()) != null && !swapCurrencyInfoList.isEmpty()) {
            linkedHashSet.addAll(SwapCurrencyInfoController.k().r());
        }
        List<IndexCurrencyInfo> indexCurrencyInfoList = marketContractBean.getIndexCurrencyInfoList();
        if (indexCurrencyInfoList != null && !indexCurrencyInfoList.isEmpty()) {
            linkedHashSet.addAll(IndexCurrencyInfoController.k().i());
        }
        for (String str : linkedHashSet) {
            aj.a aVar = new aj.a(str);
            arrayList.add(aVar);
            List<ContractCurrencyInfo> contractCurrencyInfoList2 = marketContractBean.getContractCurrencyInfoList();
            if (!MarketModuleConfig.a().d() && contractCurrencyInfoList2 != null) {
                for (ContractCurrencyInfo next : contractCurrencyInfoList2) {
                    if (next.getSymbol().equals(str)) {
                        MarketContractSymbolPriceItem marketContractSymbolPriceItem = new MarketContractSymbolPriceItem();
                        marketContractSymbolPriceItem.r(next);
                        marketContractSymbolPriceItem.u(ej.g.i(BaseApplication.b(), next.getSymbol()));
                        marketContractSymbolPriceItem.v(ej.g.k(BaseApplication.b(), next.getContractCode(), next.getContractType()));
                        marketContractSymbolPriceItem.m(next.getSymbol());
                        marketContractSymbolPriceItem.y(rl.a.a(next.getContractShortType()));
                        marketContractSymbolPriceItem.n(this.f76538l);
                        arrayList2.add(marketContractSymbolPriceItem);
                        arrayList.add(marketContractSymbolPriceItem);
                        if (TextUtils.isEmpty(aVar.c())) {
                            aVar.i(next.getActivityId());
                            aVar.j(next.getActivityTitle());
                            aVar.k(next.getActivityUrl());
                            aVar.l(MarketModuleConfig.a().S());
                        }
                    }
                }
            }
            List<SwapCurrencyInfo> swapCurrencyInfoList2 = marketContractBean.getSwapCurrencyInfoList();
            if (!MarketModuleConfig.a().D() && swapCurrencyInfoList2 != null) {
                for (SwapCurrencyInfo next2 : swapCurrencyInfoList2) {
                    if (next2.getSymbol().equals(str)) {
                        MarketSwapPriceItem marketSwapPriceItem = new MarketSwapPriceItem();
                        marketSwapPriceItem.s(next2);
                        marketSwapPriceItem.q(us.j.i(next2.getSymbol()));
                        marketSwapPriceItem.r(us.j.k(BaseApplication.b()));
                        marketSwapPriceItem.k(next2.getSymbol());
                        marketSwapPriceItem.v(rl.a.a(next2.getContractShortType()));
                        marketSwapPriceItem.l(this.f76539m);
                        arrayList2.add(marketSwapPriceItem);
                        arrayList.add(marketSwapPriceItem);
                        if (TextUtils.isEmpty(aVar.c())) {
                            aVar.i(next2.getActivityId());
                            aVar.j(next2.getActivityTitle());
                            aVar.k(next2.getActivityUrl());
                            aVar.l(MarketModuleConfig.a().n());
                        }
                    }
                }
            }
            List<IndexCurrencyInfo> indexCurrencyInfoList2 = marketContractBean.getIndexCurrencyInfoList();
            if (indexCurrencyInfoList2 != null) {
                for (IndexCurrencyInfo next3 : indexCurrencyInfoList2) {
                    if (next3.getSymbol().equals(str)) {
                        MarketIndexPriceItem marketIndexPriceItem = new MarketIndexPriceItem();
                        marketIndexPriceItem.q(next3);
                        marketIndexPriceItem.s(us.j.c(BaseApplication.b(), str, next3.getQuoteCurrency()));
                        marketIndexPriceItem.t(us.j.d(BaseApplication.b()));
                        marketIndexPriceItem.l(next3.getSymbol());
                        marketIndexPriceItem.w(10000);
                        marketIndexPriceItem.m(this.f76540n);
                        marketIndexPriceItem.r(false);
                        marketIndexPriceItem.u(str);
                        arrayList2.add(marketIndexPriceItem);
                        arrayList.add(marketIndexPriceItem);
                    }
                }
            }
        }
        List<String> list = this.f76527a;
        if (list == null || !list.contains("-9527")) {
            l(arrayList2, this.f76527a);
            return;
        }
        this.f76530d.clear();
        this.f76530d.addAll(arrayList2);
        this.f76531e.clear();
        this.f76531e.addAll(arrayList);
    }

    public void F(List<String> list) {
        this.f76527a = list;
    }

    public final void G(View view, String str, String str2, boolean z11, boolean z12, s9.a aVar, TradeType tradeType) {
        String str3 = str;
        boolean k11 = MarketModuleConfig.a().k(str);
        if (this.f76537k == null) {
            this.f76537k = new ol.b(this.f76528b, this.f76529c, new a());
        }
        this.f76537k.w(view, str2, str, !k11, k11, false, z11, z12, aVar, tradeType);
    }

    public void H(String str, String str2) {
        if ("type_name".equals(str)) {
            List<ml.b> C = j.n().C(this.f76530d, str2);
            this.f76530d.clear();
            this.f76530d.addAll(C);
        } else if ("type_price".equals(str)) {
            List<ml.b> E = j.n().E(this.f76530d, str, str2);
            this.f76530d.clear();
            this.f76530d.addAll(E);
        } else if ("type_heigh_low".equals(str)) {
            List<ml.b> E2 = j.n().E(this.f76530d, str, str2);
            this.f76530d.clear();
            this.f76530d.addAll(E2);
        } else if ("type_amount".equals(str)) {
            List<ml.b> B = j.n().B(this.f76530d, str, str2);
            this.f76530d.clear();
            this.f76530d.addAll(B);
        } else {
            ArrayList arrayList = new ArrayList(this.f76530d);
            Collections.sort(arrayList, q.f69054b);
            this.f76530d.clear();
            this.f76530d.addAll(arrayList);
        }
    }

    public List<s9.a> i() {
        return this.f76531e;
    }

    public Observable j() {
        return Observable.merge(ContractCurrencyUtils.g(true).onErrorResumeNext(Observable.just(null)).doOnCompleted(new r(this)).compose(RxJavaHelper.t(this.f76529c)), SwapCurrencyInfoController.k().f(true).onErrorResumeNext(Observable.just(null)).doOnCompleted(new s(this)).compose(RxJavaHelper.t(this.f76529c)), IndexCurrencyInfoController.k().g(true).onErrorResumeNext(Observable.just(null)).doOnCompleted(new t(this)).compose(RxJavaHelper.t(this.f76529c))).doOnNext(new u(this));
    }

    public List<s9.a> k() {
        return this.f76532f;
    }

    public final void l(List<ml.b> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        if (list2 != null) {
            for (ml.b next : list) {
                if (next instanceof MarketContractSymbolPriceItem) {
                    if (list2.contains(((MarketContractSymbolPriceItem) next).f().getSymbol())) {
                        arrayList.add(next);
                    }
                } else if (next instanceof MarketIndexPriceItem) {
                    MarketIndexPriceItem marketIndexPriceItem = (MarketIndexPriceItem) next;
                    if (list2.contains(marketIndexPriceItem.i())) {
                        arrayList.add(marketIndexPriceItem);
                    }
                } else if (next instanceof MarketSwapPriceItem) {
                    MarketSwapPriceItem marketSwapPriceItem = (MarketSwapPriceItem) next;
                    if (list2.contains(marketSwapPriceItem.i().getSymbol())) {
                        arrayList.add(marketSwapPriceItem);
                    }
                }
            }
        }
        this.f76530d.clear();
        this.f76530d.addAll(arrayList);
    }

    public final void m(MarketContractSymbolPriceItem marketContractSymbolPriceItem) {
        ContractCurrencyInfo f11 = marketContractSymbolPriceItem.f();
        SymbolPrice symbolPrice = o6.b.g().h().get(f11.getContractShortType());
        if (symbolPrice != null) {
            f11.setSymbolPrice(symbolPrice);
            marketContractSymbolPriceItem.w(symbolPrice);
            Double close = symbolPrice.getClose();
            if (close != null) {
                marketContractSymbolPriceItem.o(m.m(String.valueOf(close), f.p(f11.getContractCode())));
            }
            Double vol = symbolPrice.getVol();
            if (vol != null) {
                marketContractSymbolPriceItem.t(m.m(LegalCurrencyConfigUtil.B(String.valueOf(vol.doubleValue() * Double.parseDouble(marketContractSymbolPriceItem.f().getContractFace()))), 0));
            }
            String I = MarketModuleConfig.a().I(symbolPrice);
            String c11 = m.c(I, I);
            marketContractSymbolPriceItem.p(LegalCurrencyConfigUtil.w() + c11);
        }
    }

    public synchronized void n(List<SymbolPrice> list) {
        if (list != null) {
            for (s9.a next : this.f76530d) {
                if (next instanceof MarketContractSymbolPriceItem) {
                    m((MarketContractSymbolPriceItem) next);
                } else if (next instanceof MarketSwapPriceItem) {
                    p((MarketSwapPriceItem) next);
                } else if (next instanceof MarketIndexPriceItem) {
                    o((MarketIndexPriceItem) next);
                }
            }
            H(j.n().m(), j.n().l());
        }
    }

    public final void o(MarketIndexPriceItem marketIndexPriceItem) {
        IndexCurrencyInfo f11 = marketIndexPriceItem.f();
        SymbolPrice symbolPrice = e.g().h().get(f11.getContractShortType());
        if (symbolPrice != null) {
            marketIndexPriceItem.v(symbolPrice);
            Double close = symbolPrice.getClose();
            if (close != null) {
                marketIndexPriceItem.n(m.m(String.valueOf(close), IndexCurrencyInfoController.k().l(f11.getContractCode(), 2)));
            }
            String I = MarketModuleConfig.a().I(symbolPrice);
            String c11 = m.c(I, I);
            marketIndexPriceItem.o(LegalCurrencyConfigUtil.w() + c11);
            symbolPrice.setVol((Double) null);
            symbolPrice.setAmount((Double) null);
        }
    }

    public final void p(MarketSwapPriceItem marketSwapPriceItem) {
        SwapCurrencyInfo i11 = marketSwapPriceItem.i();
        SymbolPrice symbolPrice = r.g().h().get(i11.getContractShortType());
        if (symbolPrice != null) {
            marketSwapPriceItem.t(symbolPrice);
            Double close = symbolPrice.getClose();
            if (close != null) {
                marketSwapPriceItem.m(m.m(String.valueOf(close), i.o(i11.getSymbol())));
            }
            Double vol = symbolPrice.getVol();
            if (vol != null) {
                marketSwapPriceItem.p(m.m(LegalCurrencyConfigUtil.B(String.valueOf(vol.doubleValue() * Double.parseDouble(marketSwapPriceItem.i().getContractFace()))), 0));
            }
            String I = MarketModuleConfig.a().I(symbolPrice);
            String c11 = m.c(I, I);
            marketSwapPriceItem.n(LegalCurrencyConfigUtil.w() + c11);
        }
    }

    public boolean q() {
        return this.f76533g && this.f76534h && this.f76535i;
    }

    public boolean r() {
        return this.f76533g || this.f76534h || this.f76535i;
    }

    public final boolean s() {
        List<String> list = this.f76527a;
        return list != null && list.contains("-9527");
    }
}
