package sl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import c8.e;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.module.market.MarketModuleConfig;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.homemarket.bean.MarketContractBean;
import com.huobi.homemarket.bean.MarketIndexPriceItem;
import com.huobi.homemarket.bean.MarketLinearSwapPriceItem;
import com.iproov.sdk.bridge.OptionsBridge;
import i6.d;
import i6.m;
import i8.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import ll.j;
import ml.b;
import ol.b;
import rx.Observable;
import u6.g;

public class c0 {

    /* renamed from: a  reason: collision with root package name */
    public Activity f76478a;

    /* renamed from: b  reason: collision with root package name */
    public g f76479b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f76480c = Arrays.asList(new String[]{"-9527"});

    /* renamed from: d  reason: collision with root package name */
    public List<b> f76481d;

    /* renamed from: e  reason: collision with root package name */
    public List<s9.a> f76482e;

    /* renamed from: f  reason: collision with root package name */
    public List<s9.a> f76483f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f76484g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f76485h;

    /* renamed from: i  reason: collision with root package name */
    public MarketContractBean f76486i = new MarketContractBean();

    /* renamed from: j  reason: collision with root package name */
    public ol.b f76487j;

    /* renamed from: k  reason: collision with root package name */
    public MarketLinearSwapPriceItem.a f76488k = new x(this);

    /* renamed from: l  reason: collision with root package name */
    public MarketIndexPriceItem.a f76489l = new w(this);

    public class a implements b.d {
        public a() {
        }

        public void a() {
            e.g().k("index_overview_listener_tag");
            k.g().k("usdt_contract_overview_listener_tag");
        }

        public void b(s9.a aVar) {
        }

        public void c() {
            e.g().k("index_overview_listener_tag");
            k.g().k("usdt_contract_overview_listener_tag");
        }
    }

    public c0(Activity activity, g gVar) {
        this.f76478a = activity;
        this.f76479b = gVar;
        this.f76481d = Collections.synchronizedList(new ArrayList());
        this.f76482e = Collections.synchronizedList(new ArrayList());
        this.f76483f = new ArrayList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p() {
        if (NetworkStatus.c(BaseApplication.b())) {
            this.f76484g = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q() {
        if (NetworkStatus.c(BaseApplication.b())) {
            this.f76485h = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(List list) {
        List<FutureContractInfo> f11 = FutureContractInfoController.n().f();
        if (f11.size() > 0) {
            this.f76486i.setLinearSwapCurrencyInfoList(f11);
            y(this.f76486i);
        }
        List<IndexCurrencyInfo> f12 = IndexCurrencyInfoController.k().f("usdt_husd");
        if (f12.size() > 0) {
            this.f76486i.setIndexCurrencyInfoList(f12);
            y(this.f76486i);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(View view, MarketLinearSwapPriceItem marketLinearSwapPriceItem) {
        FutureContractInfo i11;
        if (marketLinearSwapPriceItem != null && (i11 = marketLinearSwapPriceItem.i()) != null) {
            A(view, i11.getContractShortType(), MarketModuleConfig.a().z(), true, true, marketLinearSwapPriceItem, TradeType.LINEAR_SWAP);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(View view, MarketIndexPriceItem marketIndexPriceItem) {
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
            A(view2, contractShortType, MarketModuleConfig.a().N(), false, true, marketIndexPriceItem, tradeType);
        }
    }

    public static /* synthetic */ int u(ml.b bVar, ml.b bVar2) {
        return bVar.b() - bVar2.b();
    }

    public final void A(View view, String str, String str2, boolean z11, boolean z12, s9.a aVar, TradeType tradeType) {
        String str3 = str;
        boolean k11 = MarketModuleConfig.a().k(str);
        if (this.f76487j == null) {
            this.f76487j = new ol.b(this.f76478a, this.f76479b, new a());
        }
        this.f76487j.w(view, str2, str, !k11, k11, false, z11, z12, aVar, tradeType);
    }

    public void B(String str, String str2) {
        if ("type_name".equals(str)) {
            List<ml.b> C = j.n().C(this.f76481d, str2);
            this.f76481d.clear();
            this.f76481d.addAll(C);
        } else if ("type_price".equals(str)) {
            List<ml.b> E = j.n().E(this.f76481d, str, str2);
            this.f76481d.clear();
            this.f76481d.addAll(E);
        } else if ("type_heigh_low".equals(str)) {
            List<ml.b> E2 = j.n().E(this.f76481d, str, str2);
            this.f76481d.clear();
            this.f76481d.addAll(E2);
        } else if ("type_amount".equals(str)) {
            List<ml.b> B = j.n().B(this.f76481d, str, str2);
            this.f76481d.clear();
            this.f76481d.addAll(B);
        } else {
            ArrayList arrayList = new ArrayList(this.f76481d);
            Collections.sort(arrayList, y.f69061b);
            this.f76481d.clear();
            this.f76481d.addAll(arrayList);
        }
    }

    public List<s9.a> g() {
        return this.f76482e;
    }

    public Observable h() {
        return Observable.merge(FutureContractInfoController.n().q(true).onErrorResumeNext(Observable.just(null)).doOnCompleted(new z(this)).compose(RxJavaHelper.t(this.f76479b)), IndexCurrencyInfoController.k().g(true).onErrorResumeNext(Observable.just(null)).doOnCompleted(new a0(this)).compose(RxJavaHelper.t(this.f76479b))).doOnNext(new b0(this));
    }

    public List<s9.a> i() {
        return this.f76483f;
    }

    public final void j(List<ml.b> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        if (list2 != null) {
            for (ml.b next : list) {
                if (next instanceof MarketLinearSwapPriceItem) {
                    MarketLinearSwapPriceItem marketLinearSwapPriceItem = (MarketLinearSwapPriceItem) next;
                    if (list2.contains(marketLinearSwapPriceItem.i().getSymbol())) {
                        arrayList.add(marketLinearSwapPriceItem);
                    }
                } else if (next instanceof MarketIndexPriceItem) {
                    MarketIndexPriceItem marketIndexPriceItem = (MarketIndexPriceItem) next;
                    if (list2.contains(marketIndexPriceItem.i())) {
                        arrayList.add(marketIndexPriceItem);
                    }
                }
            }
        }
        this.f76481d.clear();
        this.f76481d.addAll(arrayList);
    }

    public synchronized void k(List<SymbolPrice> list) {
        if (list != null) {
            for (s9.a next : this.f76481d) {
                if (next instanceof MarketLinearSwapPriceItem) {
                    m((MarketLinearSwapPriceItem) next);
                } else if (next instanceof MarketIndexPriceItem) {
                    l((MarketIndexPriceItem) next);
                }
            }
            B(j.n().m(), j.n().l());
        }
    }

    public final void l(MarketIndexPriceItem marketIndexPriceItem) {
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

    public final void m(MarketLinearSwapPriceItem marketLinearSwapPriceItem) {
        FutureContractInfo i11 = marketLinearSwapPriceItem.i();
        SymbolPrice symbolPrice = k.g().h().get(i11.getContractShortType());
        if (symbolPrice != null) {
            marketLinearSwapPriceItem.t(symbolPrice);
            Double close = symbolPrice.getClose();
            if (close != null) {
                int y11 = FuturePrecisionUtil.y(i11.getContractCode(), i11.getContractShortType(), (String) null);
                d.b("marketUSDPrecision = " + y11);
                marketLinearSwapPriceItem.m(m.m(String.valueOf(close), y11));
            }
            Double vol = symbolPrice.getVol();
            if (vol != null) {
                marketLinearSwapPriceItem.p(m.m(String.valueOf(vol.doubleValue() * Double.parseDouble(marketLinearSwapPriceItem.i().getContractFace()) * Double.parseDouble(MarketModuleConfig.a().I(symbolPrice))), 0));
            }
            String I = MarketModuleConfig.a().I(symbolPrice);
            String c11 = m.c(I, I);
            marketLinearSwapPriceItem.n(LegalCurrencyConfigUtil.w() + c11);
        }
    }

    public boolean n() {
        return this.f76484g && this.f76485h;
    }

    public final boolean o() {
        List<String> list = this.f76480c;
        return list != null && list.contains("-9527");
    }

    public void v(v9.a aVar) {
        this.f76483f.clear();
        if (!("sort_normal".equals(j.n().l()) || TextUtils.isEmpty(j.n().l())) || !o()) {
            this.f76483f.addAll(this.f76481d);
        } else {
            this.f76483f.addAll(this.f76482e);
        }
        aVar.notifyDataSetChanged();
        BaseModuleConfig.a().z("huobiapp_market_market_futures_end", "huobiapp_market_market_futures_end", OptionsBridge.NETWORK_KEY, true);
    }

    public void w(boolean z11) {
        ol.b bVar;
        if (!z11 && (bVar = this.f76487j) != null && bVar.isShowing()) {
            this.f76487j.p();
        }
    }

    public void x() {
        this.f76484g = false;
        this.f76485h = false;
    }

    public final void y(MarketContractBean marketContractBean) {
        List<FutureContractInfo> linearSwapCurrencyInfoList;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        ff.a a11 = MarketModuleConfig.a();
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (!a11.Q(tradeType) && (linearSwapCurrencyInfoList = marketContractBean.getLinearSwapCurrencyInfoList()) != null && !linearSwapCurrencyInfoList.isEmpty()) {
            linkedHashSet.addAll(FutureContractInfoController.n().t(tradeType));
        }
        List<IndexCurrencyInfo> indexCurrencyInfoList = marketContractBean.getIndexCurrencyInfoList();
        if (indexCurrencyInfoList != null && !indexCurrencyInfoList.isEmpty()) {
            linkedHashSet.addAll(IndexCurrencyInfoController.k().j("usdt"));
        }
        for (String str : linkedHashSet) {
            aj.a aVar = new aj.a(str);
            arrayList2.add(aVar);
            List<FutureContractInfo> linearSwapCurrencyInfoList2 = marketContractBean.getLinearSwapCurrencyInfoList();
            if (!MarketModuleConfig.a().Q(TradeType.LINEAR_SWAP) && linearSwapCurrencyInfoList2 != null) {
                for (FutureContractInfo next : linearSwapCurrencyInfoList2) {
                    if (next.getSymbol().equals(str)) {
                        MarketLinearSwapPriceItem marketLinearSwapPriceItem = new MarketLinearSwapPriceItem();
                        marketLinearSwapPriceItem.s(next);
                        String p11 = a7.e.p(BaseApplication.b(), next.getSymbol(), next.getQuoteCurrency());
                        String r11 = a7.e.r(BaseApplication.b(), next.getContractCode(), next.getContractType());
                        marketLinearSwapPriceItem.q(p11);
                        marketLinearSwapPriceItem.r(r11);
                        marketLinearSwapPriceItem.k(next.getSymbol());
                        marketLinearSwapPriceItem.v(rl.a.a(next.getContractShortType()));
                        marketLinearSwapPriceItem.l(this.f76488k);
                        arrayList.add(marketLinearSwapPriceItem);
                        arrayList2.add(marketLinearSwapPriceItem);
                        if (TextUtils.isEmpty(aVar.c())) {
                            aVar.i(next.getActivityId());
                            aVar.j(next.getActivityTitle());
                            aVar.k(next.getActivityUrl());
                            aVar.l(MarketModuleConfig.a().n());
                        }
                    }
                }
            }
            List<IndexCurrencyInfo> indexCurrencyInfoList2 = marketContractBean.getIndexCurrencyInfoList();
            if (indexCurrencyInfoList2 != null) {
                for (IndexCurrencyInfo next2 : indexCurrencyInfoList2) {
                    if (next2.getSymbol().equals(str)) {
                        MarketIndexPriceItem marketIndexPriceItem = new MarketIndexPriceItem();
                        marketIndexPriceItem.q(next2);
                        marketIndexPriceItem.s(us.j.c(BaseApplication.b(), str, next2.getQuoteCurrency()));
                        marketIndexPriceItem.t(us.j.d(BaseApplication.b()));
                        marketIndexPriceItem.w(10000);
                        marketIndexPriceItem.l(next2.getSymbol());
                        marketIndexPriceItem.m(this.f76489l);
                        marketIndexPriceItem.r(false);
                        marketIndexPriceItem.u(str);
                        arrayList.add(marketIndexPriceItem);
                        arrayList2.add(marketIndexPriceItem);
                    }
                }
            }
        }
        List<String> list = this.f76480c;
        if (list == null || !list.contains("-9527")) {
            j(arrayList, this.f76480c);
            return;
        }
        this.f76481d.clear();
        this.f76481d.addAll(arrayList);
        this.f76482e.clear();
        this.f76482e.addAll(arrayList2);
    }

    public void z(List<String> list) {
        this.f76480c = list;
    }
}
