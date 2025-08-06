package sl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$string;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.homemarket.bean.CollectionMultiple;
import com.huobi.homemarket.bean.MarketContractSymbolPriceItem;
import com.huobi.homemarket.bean.MarketIndexPriceItem;
import com.huobi.homemarket.bean.MarketLinearSwapPriceItem;
import com.huobi.homemarket.bean.MarketSwapPriceItem;
import com.huobi.homemarket.bean.MarketSymbolPriceItem;
import com.huobi.homemarket.presenter.HomeMarketNewPresenter;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import ej.f;
import ej.g;
import i8.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import ll.j;
import m9.r;
import ol.b;
import rx.Observable;
import us.i;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public Activity f76504a;

    /* renamed from: b  reason: collision with root package name */
    public HomeMarketNewPresenter.g0 f76505b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Integer> f76506c;

    /* renamed from: d  reason: collision with root package name */
    public List<ml.b> f76507d = Collections.synchronizedList(new ArrayList());

    /* renamed from: e  reason: collision with root package name */
    public List<ml.b> f76508e = Collections.synchronizedList(new ArrayList());

    /* renamed from: f  reason: collision with root package name */
    public List<ml.b> f76509f = Collections.synchronizedList(new ArrayList());

    /* renamed from: g  reason: collision with root package name */
    public List<ml.b> f76510g = Collections.synchronizedList(new ArrayList());

    /* renamed from: h  reason: collision with root package name */
    public boolean f76511h;

    /* renamed from: i  reason: collision with root package name */
    public e f76512i;

    /* renamed from: j  reason: collision with root package name */
    public ol.b f76513j;

    /* renamed from: k  reason: collision with root package name */
    public b.d<ml.b> f76514k = new a();

    /* renamed from: l  reason: collision with root package name */
    public MarketSymbolPriceItem.a f76515l = new d();

    /* renamed from: m  reason: collision with root package name */
    public MarketContractSymbolPriceItem.a f76516m = new a(this);

    /* renamed from: n  reason: collision with root package name */
    public MarketSwapPriceItem.a f76517n = new e(this);

    /* renamed from: o  reason: collision with root package name */
    public MarketLinearSwapPriceItem.a f76518o = new d(this);

    /* renamed from: p  reason: collision with root package name */
    public MarketIndexPriceItem.a f76519p = new c(this);

    public class a implements b.d<ml.b> {
        public a() {
        }

        public static /* synthetic */ int e(ml.b bVar, ml.b bVar2) {
            return bVar.b() - bVar2.b();
        }

        public void a() {
            if (m.this.f76512i != null) {
                m.this.f76512i.a();
            }
        }

        public void c() {
            if (m.this.f76512i != null) {
                m.this.f76512i.a();
            }
        }

        /* renamed from: f */
        public void b(ml.b bVar) {
            try {
                ArrayList arrayList = new ArrayList(m.this.f76509f);
                arrayList.addAll(new ArrayList(m.this.f76510g));
                Collections.sort(arrayList, l.f69050b);
                arrayList.remove(bVar);
                arrayList.add(0, bVar);
                m.this.x(arrayList, bVar);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class b extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f76521b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ml.b f76522c;

        public b(List list, ml.b bVar) {
            this.f76521b = list;
            this.f76522c = bVar;
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            MarketModuleConfig.a().f0(this.f76521b);
            m.this.e0(this.f76521b);
            m.this.c0(this.f76522c);
        }
    }

    public class c extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f76524b;

        public c(List list) {
            this.f76524b = list;
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            MarketModuleConfig.a().f0(this.f76524b);
            m.this.e0(this.f76524b);
            if (m.this.f76505b != null && m.this.f76505b.isCanBeSeen() && m.this.J()) {
                HuobiToastUtil.s(R$string.n_market_top_cancel_sort_visible);
            }
        }
    }

    public class d implements MarketSymbolPriceItem.a {
        public d() {
        }

        public void a(View view, MarketSymbolPriceItem marketSymbolPriceItem) {
            if (marketSymbolPriceItem != null) {
                String j11 = marketSymbolPriceItem.j();
                m.this.K();
                m.this.f76513j.x(view, MarketModuleConfig.a().l(), j11, false, true, true, true, true, true, marketSymbolPriceItem, TradeType.PRO);
            }
        }
    }

    public interface e {
        void a();

        void notifyDataSetChanged();
    }

    public m(Activity activity, HomeMarketNewPresenter.g0 g0Var) {
        this.f76504a = activity;
        this.f76505b = g0Var;
    }

    public static /* synthetic */ List M(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List N(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List O(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List P(List list, List list2, List list3, List list4) {
        return list4;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable Q(List list) {
        return Observable.just(this.f76509f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R(View view, MarketContractSymbolPriceItem marketContractSymbolPriceItem) {
        ContractCurrencyInfo f11;
        if (marketContractSymbolPriceItem != null && (f11 = marketContractSymbolPriceItem.f()) != null) {
            String contractShortType = f11.getContractShortType();
            K();
            this.f76513j.x(view, MarketModuleConfig.a().x(), contractShortType, false, true, true, true, true, true, marketContractSymbolPriceItem, TradeType.CONTRACT);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S(View view, MarketSwapPriceItem marketSwapPriceItem) {
        SwapCurrencyInfo i11;
        if (marketSwapPriceItem != null && (i11 = marketSwapPriceItem.i()) != null) {
            String contractShortType = i11.getContractShortType();
            K();
            this.f76513j.x(view, MarketModuleConfig.a().v(), contractShortType, false, true, true, true, true, true, marketSwapPriceItem, TradeType.SWAP);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T(View view, MarketLinearSwapPriceItem marketLinearSwapPriceItem) {
        FutureContractInfo i11;
        if (marketLinearSwapPriceItem != null && (i11 = marketLinearSwapPriceItem.i()) != null) {
            String contractShortType = i11.getContractShortType();
            K();
            this.f76513j.x(view, MarketModuleConfig.a().z(), contractShortType, false, true, true, true, true, true, marketLinearSwapPriceItem, TradeType.LINEAR_SWAP);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(View view, MarketIndexPriceItem marketIndexPriceItem) {
        IndexCurrencyInfo f11;
        TradeType tradeType;
        if (marketIndexPriceItem != null && (f11 = marketIndexPriceItem.f()) != null) {
            String contractShortType = f11.getContractShortType();
            K();
            if ("usdt".equalsIgnoreCase(f11.getQuoteCurrency())) {
                tradeType = TradeType.LINEAR_SWAP_INDEX;
            } else {
                tradeType = TradeType.CONTRACT_INDEX;
            }
            View view2 = view;
            this.f76513j.x(view2, MarketModuleConfig.a().N(), contractShortType, false, true, true, false, true, true, marketIndexPriceItem, tradeType);
        }
    }

    public static /* synthetic */ int V(ml.b bVar, ml.b bVar2) {
        return bVar.b() - bVar2.b();
    }

    public List<ml.b> A() {
        return this.f76507d;
    }

    public int B(String str) {
        return rl.a.a(str);
    }

    public final void C(MarketContractSymbolPriceItem marketContractSymbolPriceItem, SymbolPrice symbolPrice) {
        ContractCurrencyInfo f11 = marketContractSymbolPriceItem.f();
        if (f11 != null && symbolPrice.getSymbol().equals(f11.getContractShortType())) {
            f11.setSymbolPrice(symbolPrice);
            marketContractSymbolPriceItem.w(symbolPrice);
            Double close = symbolPrice.getClose();
            if (close != null) {
                marketContractSymbolPriceItem.o(i6.m.m(String.valueOf(close), f.p(f11.getContractCode())));
            }
            Double vol = symbolPrice.getVol();
            if (vol != null) {
                marketContractSymbolPriceItem.t(i6.m.m(LegalCurrencyConfigUtil.B(String.valueOf(vol.doubleValue() * Double.parseDouble(marketContractSymbolPriceItem.f().getContractFace()))), 0));
            }
            String I = MarketModuleConfig.a().I(symbolPrice);
            String c11 = i6.m.c(I, I);
            marketContractSymbolPriceItem.p(LegalCurrencyConfigUtil.w() + c11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ad, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void D(java.util.List<com.hbg.lib.network.pro.socket.bean.SymbolPrice> r7, boolean r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 != 0) goto L_0x0005
            monitor-exit(r6)
            return
        L_0x0005:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00ae }
            r0.<init>(r7)     // Catch:{ all -> 0x00ae }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00ae }
            if (r8 == 0) goto L_0x0011
            java.util.List<ml.b> r1 = r6.f76509f     // Catch:{ all -> 0x00ae }
            goto L_0x0013
        L_0x0011:
            java.util.List<ml.b> r1 = r6.f76510g     // Catch:{ all -> 0x00ae }
        L_0x0013:
            r7.<init>(r1)     // Catch:{ all -> 0x00ae }
            java.util.Iterator r1 = r7.iterator()     // Catch:{ all -> 0x00ae }
        L_0x001a:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00ae }
            if (r2 == 0) goto L_0x006b
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00ae }
            ml.b r2 = (ml.b) r2     // Catch:{ all -> 0x00ae }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ all -> 0x00ae }
        L_0x002a:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00ae }
            if (r4 == 0) goto L_0x001a
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00ae }
            com.hbg.lib.network.pro.socket.bean.SymbolPrice r4 = (com.hbg.lib.network.pro.socket.bean.SymbolPrice) r4     // Catch:{ all -> 0x00ae }
            boolean r5 = r2 instanceof com.huobi.homemarket.bean.MarketSymbolPriceItem     // Catch:{ all -> 0x00ae }
            if (r5 == 0) goto L_0x0041
            r5 = r2
            com.huobi.homemarket.bean.MarketSymbolPriceItem r5 = (com.huobi.homemarket.bean.MarketSymbolPriceItem) r5     // Catch:{ all -> 0x00ae }
            r6.I(r5, r4)     // Catch:{ all -> 0x00ae }
            goto L_0x002a
        L_0x0041:
            boolean r5 = r2 instanceof com.huobi.homemarket.bean.MarketContractSymbolPriceItem     // Catch:{ all -> 0x00ae }
            if (r5 == 0) goto L_0x004c
            r5 = r2
            com.huobi.homemarket.bean.MarketContractSymbolPriceItem r5 = (com.huobi.homemarket.bean.MarketContractSymbolPriceItem) r5     // Catch:{ all -> 0x00ae }
            r6.C(r5, r4)     // Catch:{ all -> 0x00ae }
            goto L_0x002a
        L_0x004c:
            boolean r5 = r2 instanceof com.huobi.homemarket.bean.MarketSwapPriceItem     // Catch:{ all -> 0x00ae }
            if (r5 == 0) goto L_0x0056
            r5 = r2
            com.huobi.homemarket.bean.MarketSwapPriceItem r5 = (com.huobi.homemarket.bean.MarketSwapPriceItem) r5     // Catch:{ all -> 0x00ae }
            r6.H(r5, r4)     // Catch:{ all -> 0x00ae }
        L_0x0056:
            boolean r5 = r2 instanceof com.huobi.homemarket.bean.MarketLinearSwapPriceItem     // Catch:{ all -> 0x00ae }
            if (r5 == 0) goto L_0x0060
            r5 = r2
            com.huobi.homemarket.bean.MarketLinearSwapPriceItem r5 = (com.huobi.homemarket.bean.MarketLinearSwapPriceItem) r5     // Catch:{ all -> 0x00ae }
            r6.F(r5, r4)     // Catch:{ all -> 0x00ae }
        L_0x0060:
            boolean r5 = r2 instanceof com.huobi.homemarket.bean.MarketIndexPriceItem     // Catch:{ all -> 0x00ae }
            if (r5 == 0) goto L_0x002a
            r5 = r2
            com.huobi.homemarket.bean.MarketIndexPriceItem r5 = (com.huobi.homemarket.bean.MarketIndexPriceItem) r5     // Catch:{ all -> 0x00ae }
            r6.E(r5, r4)     // Catch:{ all -> 0x00ae }
            goto L_0x002a
        L_0x006b:
            if (r8 == 0) goto L_0x008d
            java.util.List<ml.b> r8 = r6.f76509f     // Catch:{ all -> 0x00ae }
            r8.clear()     // Catch:{ all -> 0x00ae }
            java.util.List<ml.b> r8 = r6.f76509f     // Catch:{ all -> 0x00ae }
            r8.addAll(r7)     // Catch:{ all -> 0x00ae }
            ll.j r7 = ll.j.n()     // Catch:{ all -> 0x00ae }
            java.lang.String r7 = r7.m()     // Catch:{ all -> 0x00ae }
            ll.j r8 = ll.j.n()     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = r8.l()     // Catch:{ all -> 0x00ae }
            java.util.List<ml.b> r0 = r6.f76509f     // Catch:{ all -> 0x00ae }
            r6.j0(r7, r8, r0)     // Catch:{ all -> 0x00ae }
            goto L_0x00ac
        L_0x008d:
            java.util.List<ml.b> r8 = r6.f76510g     // Catch:{ all -> 0x00ae }
            r8.clear()     // Catch:{ all -> 0x00ae }
            java.util.List<ml.b> r8 = r6.f76510g     // Catch:{ all -> 0x00ae }
            r8.addAll(r7)     // Catch:{ all -> 0x00ae }
            ll.j r7 = ll.j.n()     // Catch:{ all -> 0x00ae }
            java.lang.String r7 = r7.m()     // Catch:{ all -> 0x00ae }
            ll.j r8 = ll.j.n()     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = r8.l()     // Catch:{ all -> 0x00ae }
            java.util.List<ml.b> r0 = r6.f76510g     // Catch:{ all -> 0x00ae }
            r6.j0(r7, r8, r0)     // Catch:{ all -> 0x00ae }
        L_0x00ac:
            monitor-exit(r6)
            return
        L_0x00ae:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sl.m.D(java.util.List, boolean):void");
    }

    public final void E(MarketIndexPriceItem marketIndexPriceItem, SymbolPrice symbolPrice) {
        IndexCurrencyInfo f11 = marketIndexPriceItem.f();
        if (symbolPrice.getSymbol().equals(f11.getContractShortType())) {
            marketIndexPriceItem.v(symbolPrice);
            Double close = symbolPrice.getClose();
            if (close != null) {
                marketIndexPriceItem.n(i6.m.m(String.valueOf(close), IndexCurrencyInfoController.k().l(f11.getContractCode(), 2)));
            }
            String I = MarketModuleConfig.a().I(symbolPrice);
            String c11 = i6.m.c(I, I);
            marketIndexPriceItem.o(LegalCurrencyConfigUtil.w() + c11);
            marketIndexPriceItem.r(true);
            symbolPrice.setVol((Double) null);
            symbolPrice.setAmount((Double) null);
        }
    }

    public final void F(MarketLinearSwapPriceItem marketLinearSwapPriceItem, SymbolPrice symbolPrice) {
        FutureContractInfo i11 = marketLinearSwapPriceItem.i();
        if (i11 != null && symbolPrice.getSymbol().equals(i11.getContractShortType())) {
            marketLinearSwapPriceItem.t(symbolPrice);
            Double close = symbolPrice.getClose();
            if (close != null) {
                marketLinearSwapPriceItem.m(i6.m.m(String.valueOf(close), FuturePrecisionUtil.y(i11.getContractCode(), i11.getContractShortType(), (String) null)));
            }
            Double vol = symbolPrice.getVol();
            if (vol != null) {
                marketLinearSwapPriceItem.p(i6.m.m(String.valueOf(vol.doubleValue() * Double.parseDouble(marketLinearSwapPriceItem.i().getContractFace()) * Double.parseDouble(MarketModuleConfig.a().I(symbolPrice))), 0));
            }
            String I = MarketModuleConfig.a().I(symbolPrice);
            String c11 = i6.m.c(I, I);
            marketLinearSwapPriceItem.n(LegalCurrencyConfigUtil.w() + c11);
        }
    }

    public final synchronized void G(List<String> list) {
        HashSet hashSet = null;
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    h0(list);
                    hashSet = new HashSet(list);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (hashSet != null) {
            v(hashSet);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (hashSet != null && !hashSet.isEmpty()) {
            arrayList.addAll(a0(hashSet, a1.v().e0(TradeType.PRO)));
            if (gj.d.n().E()) {
                List<ContractCurrencyInfo> m11 = ContractCurrencyUtils.m();
                List<SwapCurrencyInfo> e11 = SwapCurrencyInfoController.k().e();
                List<FutureContractInfo> f11 = FutureContractInfoController.n().f();
                List<IndexCurrencyInfo> d11 = IndexCurrencyInfoController.k().d();
                arrayList2.addAll(Y(hashSet, f11));
                arrayList2.addAll(W(hashSet, m11));
                arrayList2.addAll(Z(hashSet, e11));
                arrayList2.addAll(X(hashSet, d11));
            }
        }
        if (!this.f76511h) {
            this.f76511h = true;
        }
        this.f76509f.clear();
        this.f76509f.addAll(arrayList);
        this.f76510g.clear();
        this.f76510g.addAll(arrayList2);
        i0(j.n().m(), j.n().l());
    }

    public final void H(MarketSwapPriceItem marketSwapPriceItem, SymbolPrice symbolPrice) {
        SwapCurrencyInfo i11 = marketSwapPriceItem.i();
        if (i11 != null && symbolPrice.getSymbol().equals(i11.getContractShortType())) {
            marketSwapPriceItem.t(symbolPrice);
            Double close = symbolPrice.getClose();
            if (close != null) {
                marketSwapPriceItem.m(i6.m.m(String.valueOf(close), i.o(i11.getSymbol())));
            }
            Double vol = symbolPrice.getVol();
            if (vol != null) {
                marketSwapPriceItem.p(i6.m.m(LegalCurrencyConfigUtil.B(String.valueOf(vol.doubleValue() * Double.parseDouble(marketSwapPriceItem.i().getContractFace()))), 0));
            }
            String I = MarketModuleConfig.a().I(symbolPrice);
            String c11 = i6.m.c(I, I);
            marketSwapPriceItem.n(LegalCurrencyConfigUtil.w() + c11);
        }
    }

    public final void I(MarketSymbolPriceItem marketSymbolPriceItem, SymbolPrice symbolPrice) {
        if (!TextUtils.isEmpty(marketSymbolPriceItem.j()) && marketSymbolPriceItem.j().equals(symbolPrice.getSymbol())) {
            marketSymbolPriceItem.J(symbolPrice);
            Double close = symbolPrice.getClose();
            if (close != null) {
                marketSymbolPriceItem.w(i6.m.m(String.valueOf(close), PrecisionUtil.x(marketSymbolPriceItem.k().getSymbol())));
            }
            Double vol = symbolPrice.getVol();
            if (vol != null) {
                marketSymbolPriceItem.z(i6.m.m(LegalCurrencyConfigUtil.G(String.valueOf(vol), marketSymbolPriceItem.getQuoteCurrency(), TradeType.PRO), 0));
            }
            String n11 = LegalCurrencyConfigUtil.n(marketSymbolPriceItem.j(), TradeType.PRO);
            String c11 = i6.m.c(n11, n11);
            marketSymbolPriceItem.x(LegalCurrencyConfigUtil.w() + c11);
        }
    }

    public final boolean J() {
        String m11 = j.n().m();
        return "type_name".equals(m11) || "type_price".equals(m11) || "type_heigh_low".equals(m11);
    }

    public final void K() {
        if (this.f76513j == null) {
            this.f76513j = new ol.b(this.f76504a, this.f76505b, this.f76514k);
        }
    }

    public boolean L() {
        return this.f76511h;
    }

    public final List<ml.b> W(Set<String> set, List<ContractCurrencyInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            for (String next : set) {
                if (MarketModuleConfig.a().x().equals(MarketModuleConfig.a().e0(next))) {
                    MarketContractSymbolPriceItem w11 = w(next);
                    String[] split = next.split("_");
                    w11.u(g.i(BaseApplication.b(), split.length > 0 ? split[0] : ""));
                    w11.v(g.c(next));
                    w11.m(g.f(next));
                    arrayList.add(w11);
                }
            }
        } else {
            for (ContractCurrencyInfo next2 : list) {
                String contractShortType = next2.getContractShortType();
                if (set.contains(contractShortType)) {
                    MarketContractSymbolPriceItem w12 = w(contractShortType);
                    w12.r(next2);
                    w12.m(next2.getSymbol());
                    w12.u(g.i(BaseApplication.b(), next2.getSymbol()));
                    w12.v(g.k(BaseApplication.b(), next2.getContractCode(), next2.getContractType()));
                    arrayList.add(w12);
                }
            }
        }
        return arrayList;
    }

    public final List<ml.b> X(Set<String> set, List<IndexCurrencyInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            for (String next : set) {
                if (MarketModuleConfig.a().N().equals(MarketModuleConfig.a().e0(next))) {
                    String[] split = next.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    String str = split.length > 0 ? split[0] : "";
                    MarketIndexPriceItem marketIndexPriceItem = new MarketIndexPriceItem();
                    marketIndexPriceItem.s(us.j.a(str, BaseApplication.b()));
                    marketIndexPriceItem.l(str);
                    marketIndexPriceItem.w(10000);
                    if (this.f76506c.get(next) != null) {
                        marketIndexPriceItem.p(this.f76506c.get(next).intValue());
                    } else {
                        marketIndexPriceItem.p(0);
                    }
                    marketIndexPriceItem.m(this.f76519p);
                    arrayList.add(marketIndexPriceItem);
                }
            }
        } else {
            for (IndexCurrencyInfo next2 : list) {
                String contractShortType = next2.getContractShortType();
                if (set.contains(contractShortType)) {
                    MarketIndexPriceItem marketIndexPriceItem2 = new MarketIndexPriceItem();
                    marketIndexPriceItem2.q(next2);
                    marketIndexPriceItem2.s(us.j.c(BaseApplication.b(), next2.getSymbol(), next2.getQuoteCurrency()));
                    marketIndexPriceItem2.t(us.j.d(BaseApplication.b()));
                    marketIndexPriceItem2.l(next2.getSymbol());
                    marketIndexPriceItem2.w(10000);
                    if (this.f76506c.get(contractShortType) != null) {
                        marketIndexPriceItem2.p(this.f76506c.get(contractShortType).intValue());
                    } else {
                        marketIndexPriceItem2.p(0);
                    }
                    marketIndexPriceItem2.m(this.f76519p);
                    arrayList.add(marketIndexPriceItem2);
                }
            }
        }
        return arrayList;
    }

    public final List<ml.b> Y(Set<String> set, List<FutureContractInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            for (String next : set) {
                if (MarketModuleConfig.a().z().equals(MarketModuleConfig.a().e0(next))) {
                    MarketLinearSwapPriceItem marketLinearSwapPriceItem = new MarketLinearSwapPriceItem();
                    marketLinearSwapPriceItem.u(2);
                    marketLinearSwapPriceItem.l(this.f76518o);
                    if (this.f76506c.get(next) != null) {
                        marketLinearSwapPriceItem.o(this.f76506c.get(next).intValue());
                    } else {
                        marketLinearSwapPriceItem.o(0);
                    }
                    marketLinearSwapPriceItem.v(B(next));
                    String[] split = next.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    String str = "";
                    String str2 = split.length > 0 ? split[0] : str;
                    String str3 = split.length > 1 ? split[1] : str;
                    if (split.length > 2) {
                        str = split[2];
                    }
                    marketLinearSwapPriceItem.k(str2);
                    marketLinearSwapPriceItem.q(a7.e.p(BaseApplication.b(), str2, str3));
                    marketLinearSwapPriceItem.r(a7.e.g(str));
                    arrayList.add(marketLinearSwapPriceItem);
                }
            }
        } else {
            for (FutureContractInfo next2 : list) {
                String contractShortType = next2.getContractShortType();
                if (set.contains(contractShortType)) {
                    MarketLinearSwapPriceItem marketLinearSwapPriceItem2 = new MarketLinearSwapPriceItem();
                    marketLinearSwapPriceItem2.u(2);
                    marketLinearSwapPriceItem2.l(this.f76518o);
                    if (this.f76506c.get(contractShortType) != null) {
                        marketLinearSwapPriceItem2.o(this.f76506c.get(contractShortType).intValue());
                    } else {
                        marketLinearSwapPriceItem2.o(0);
                    }
                    marketLinearSwapPriceItem2.v(B(contractShortType));
                    marketLinearSwapPriceItem2.s(next2);
                    marketLinearSwapPriceItem2.k(next2.getSymbol());
                    marketLinearSwapPriceItem2.q(a7.e.p(BaseApplication.b(), next2.getSymbol(), next2.getQuoteCurrency()));
                    marketLinearSwapPriceItem2.r(a7.e.r(BaseApplication.b(), next2.getContractCode(), next2.getContractType()));
                    arrayList.add(marketLinearSwapPriceItem2);
                }
            }
        }
        return arrayList;
    }

    public final List<ml.b> Z(Set<String> set, List<SwapCurrencyInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            for (String next : set) {
                if (MarketModuleConfig.a().v().equals(MarketModuleConfig.a().e0(next))) {
                    MarketSwapPriceItem marketSwapPriceItem = new MarketSwapPriceItem();
                    marketSwapPriceItem.u(2);
                    marketSwapPriceItem.l(this.f76517n);
                    if (this.f76506c.get(next) != null) {
                        marketSwapPriceItem.o(this.f76506c.get(next).intValue());
                    } else {
                        marketSwapPriceItem.o(0);
                    }
                    marketSwapPriceItem.v(B(next));
                    String[] split = next.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    String str = split.length > 0 ? split[0] : "";
                    marketSwapPriceItem.k(str);
                    marketSwapPriceItem.q(us.j.i(str));
                    marketSwapPriceItem.r(us.j.k(BaseApplication.b()));
                    arrayList.add(marketSwapPriceItem);
                }
            }
        } else {
            for (SwapCurrencyInfo next2 : list) {
                String contractShortType = next2.getContractShortType();
                if (set.contains(contractShortType)) {
                    MarketSwapPriceItem marketSwapPriceItem2 = new MarketSwapPriceItem();
                    marketSwapPriceItem2.u(2);
                    marketSwapPriceItem2.l(this.f76517n);
                    if (this.f76506c.get(contractShortType) != null) {
                        marketSwapPriceItem2.o(this.f76506c.get(contractShortType).intValue());
                    } else {
                        marketSwapPriceItem2.o(0);
                    }
                    marketSwapPriceItem2.v(B(contractShortType));
                    marketSwapPriceItem2.s(next2);
                    marketSwapPriceItem2.k(next2.getSymbol());
                    marketSwapPriceItem2.q(us.j.i(next2.getSymbol()));
                    marketSwapPriceItem2.r(us.j.k(BaseApplication.b()));
                    arrayList.add(marketSwapPriceItem2);
                }
            }
        }
        return arrayList;
    }

    public final List<ml.b> a0(Set<String> set, List<SymbolBean> list) {
        ArrayList arrayList = new ArrayList();
        for (SymbolBean next : list) {
            if (set.contains(next.getSymbol())) {
                String symbol = next.getSymbol();
                if (!symbol.contains("bt1") && !symbol.contains("bt2")) {
                    MarketSymbolPriceItem marketSymbolPriceItem = new MarketSymbolPriceItem();
                    marketSymbolPriceItem.M(1);
                    marketSymbolPriceItem.K(next.getTradeOpenAt());
                    String baseCurrency = next.getBaseCurrency();
                    marketSymbolPriceItem.I(next);
                    if (this.f76506c.get(symbol) != null) {
                        marketSymbolPriceItem.y(this.f76506c.get(symbol).intValue());
                    } else {
                        marketSymbolPriceItem.y(0);
                    }
                    marketSymbolPriceItem.H(symbol);
                    marketSymbolPriceItem.G(next.getState());
                    marketSymbolPriceItem.L(TradeType.PRO);
                    marketSymbolPriceItem.B(a1.v().S(symbol));
                    marketSymbolPriceItem.t(baseCurrency);
                    marketSymbolPriceItem.u(next.getBaseCurrencyDisplayName());
                    marketSymbolPriceItem.C(next.getQuoteCurrency());
                    marketSymbolPriceItem.D(next.getQuoteCurrencyDisplayName());
                    marketSymbolPriceItem.A(next.isHadaxTag());
                    marketSymbolPriceItem.F(next.isStTag());
                    marketSymbolPriceItem.v(this.f76515l);
                    arrayList.add(marketSymbolPriceItem);
                }
            }
        }
        return arrayList;
    }

    public void b0(boolean z11) {
        ol.b bVar;
        if (!z11 && (bVar = this.f76513j) != null && bVar.isShowing()) {
            this.f76513j.p();
        }
    }

    public final void c0(ml.b bVar) {
        if (this.f76509f.remove(bVar)) {
            this.f76509f.add(0, bVar);
        } else if (this.f76510g.remove(bVar)) {
            this.f76510g.add(0, bVar);
        }
        i0(j.n().m(), j.n().l());
        g0();
        e eVar = this.f76512i;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    public final void d0(ArrayList<ml.b> arrayList, List<CollectionMultiple> list, List<String> list2) {
        String str;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            ml.b bVar = arrayList.get(i11);
            String str2 = null;
            if (bVar instanceof MarketContractSymbolPriceItem) {
                MarketContractSymbolPriceItem marketContractSymbolPriceItem = (MarketContractSymbolPriceItem) bVar;
                str = MarketModuleConfig.a().x();
                ContractCurrencyInfo f11 = marketContractSymbolPriceItem.f();
                if (f11 != null) {
                    str2 = f11.getContractShortType();
                }
                marketContractSymbolPriceItem.q(i11);
            } else if (bVar instanceof MarketSwapPriceItem) {
                MarketSwapPriceItem marketSwapPriceItem = (MarketSwapPriceItem) bVar;
                str = MarketModuleConfig.a().v();
                SwapCurrencyInfo i12 = marketSwapPriceItem.i();
                if (i12 != null) {
                    str2 = i12.getContractShortType();
                }
                marketSwapPriceItem.o(i11);
            } else if (bVar instanceof MarketLinearSwapPriceItem) {
                MarketLinearSwapPriceItem marketLinearSwapPriceItem = (MarketLinearSwapPriceItem) bVar;
                str = MarketModuleConfig.a().z();
                FutureContractInfo i13 = marketLinearSwapPriceItem.i();
                if (i13 != null) {
                    str2 = i13.getContractShortType();
                }
                marketLinearSwapPriceItem.o(i11);
            } else if (bVar instanceof MarketIndexPriceItem) {
                MarketIndexPriceItem marketIndexPriceItem = (MarketIndexPriceItem) bVar;
                str = MarketModuleConfig.a().N();
                IndexCurrencyInfo f12 = marketIndexPriceItem.f();
                if (f12 != null) {
                    str2 = f12.getContractShortType();
                }
                marketIndexPriceItem.p(i11);
            } else {
                MarketSymbolPriceItem marketSymbolPriceItem = (MarketSymbolPriceItem) bVar;
                str2 = marketSymbolPriceItem.j();
                str = MarketModuleConfig.a().l();
                marketSymbolPriceItem.y(i11);
            }
            if (str2 != null) {
                list2.add(str2);
                list.add(new CollectionMultiple(str, str2));
            }
        }
    }

    public final void e0(List<String> list) {
        Map<String, Integer> map = this.f76506c;
        if (map != null) {
            map.clear();
            for (int i11 = 0; i11 < list.size(); i11++) {
                this.f76506c.put(list.get(i11), Integer.valueOf(i11));
            }
        }
    }

    public void f0(e eVar) {
        this.f76512i = eVar;
    }

    public void g0() {
        this.f76507d.clear();
        this.f76507d.addAll(this.f76509f);
        this.f76508e.clear();
        this.f76508e.addAll(this.f76510g);
    }

    public final void h0(List<String> list) {
        Map<String, Integer> map = this.f76506c;
        if (map == null) {
            this.f76506c = new HashMap();
        } else {
            map.clear();
        }
        int i11 = 0;
        for (String put : list) {
            this.f76506c.put(put, Integer.valueOf(i11));
            i11++;
        }
    }

    public void i0(String str, String str2) {
        j0(str, str2, this.f76509f);
        j0(str, str2, this.f76510g);
    }

    public final void j0(String str, String str2, List<ml.b> list) {
        if ("type_name".equals(str)) {
            List<ml.b> C = j.n().C(list, str2);
            list.clear();
            list.addAll(C);
        } else if ("type_price".equals(str)) {
            List<ml.b> D = j.n().D(list, str, str2);
            list.clear();
            list.addAll(D);
        } else if ("type_heigh_low".equals(str)) {
            List<ml.b> D2 = j.n().D(list, str, str2);
            list.clear();
            list.addAll(D2);
        } else if ("type_amount".equals(str)) {
            List<ml.b> B = j.n().B(list, str, str2);
            list.clear();
            list.addAll(B);
        } else {
            ArrayList arrayList = new ArrayList(list);
            Collections.sort(arrayList, f.f69044b);
            list.clear();
            list.addAll(arrayList);
        }
    }

    public final void v(Set<String> set) {
        int i11;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        for (String next : set) {
            if (next.toLowerCase().endsWith("-index")) {
                z15 = true;
            } else if (next.contains("_")) {
                z12 = true;
            } else if (next.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                String[] split = next.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (split == null) {
                    i11 = 0;
                } else {
                    i11 = split.length;
                }
                if (i11 == 2 && "USD".equals(split[1])) {
                    z13 = true;
                } else if (i11 == 2 || i11 == 3) {
                    z14 = true;
                }
            } else {
                z11 = true;
            }
        }
        if (z11) {
            f0.g().i();
        } else {
            f0.g().n();
        }
        if (z12) {
            o6.b.g().i();
        } else {
            o6.b.g().n();
        }
        if (z13) {
            r.g().i();
        } else {
            r.g().n();
        }
        if (z14) {
            k.g().i();
        } else {
            k.g().n();
        }
        if (z15) {
            c8.e.g().i();
        } else {
            c8.e.g().n();
        }
    }

    public final MarketContractSymbolPriceItem w(String str) {
        MarketContractSymbolPriceItem marketContractSymbolPriceItem = new MarketContractSymbolPriceItem();
        marketContractSymbolPriceItem.x(2);
        if (this.f76506c.get(str) != null) {
            marketContractSymbolPriceItem.q(this.f76506c.get(str).intValue());
        } else {
            marketContractSymbolPriceItem.q(0);
        }
        marketContractSymbolPriceItem.y(B(str));
        marketContractSymbolPriceItem.s(str);
        marketContractSymbolPriceItem.n(this.f76516m);
        return marketContractSymbolPriceItem;
    }

    public final void x(ArrayList<ml.b> arrayList, ml.b bVar) {
        if (!BaseModuleConfig.a().a()) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            d0(arrayList, arrayList2, arrayList3);
            MarketModuleConfig.a().f0(arrayList3);
            e0(arrayList3);
            MarketModuleConfig.a().c0(arrayList2, this.f76504a).compose(RxJavaHelper.t(this.f76505b)).subscribe(new EasySubscriber());
            if (!J()) {
                c0(bVar);
            } else {
                HuobiToastUtil.s(R$string.n_market_top_cancel_sort_visible);
            }
        } else if (!J()) {
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            d0(arrayList, arrayList4, arrayList5);
            MarketModuleConfig.a().c0(arrayList4, this.f76504a).compose(RxJavaHelper.t(this.f76505b)).subscribe(new b(arrayList5, bVar));
        } else {
            ArrayList arrayList6 = new ArrayList();
            ArrayList arrayList7 = new ArrayList();
            d0(arrayList, arrayList6, arrayList7);
            MarketModuleConfig.a().c0(arrayList6, this.f76504a).compose(RxJavaHelper.t(this.f76505b)).subscribe(new c(arrayList7));
        }
    }

    public Observable<List<ml.b>> y(Context context) {
        Observable<List<SymbolBean>> Y = a1.v().Y(true, true);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return Observable.zip(Y.timeout(3000, timeUnit).compose(RxJavaHelper.t(this.f76505b)).onErrorReturn(k.f69049b), d7.k.C().E(true).timeout(3000, timeUnit).compose(RxJavaHelper.t(this.f76505b)).onErrorReturn(i.f69047b), IndexCurrencyInfoController.k().g(true).timeout(3000, timeUnit).compose(RxJavaHelper.t(this.f76505b)).onErrorReturn(j.f69048b), MarketModuleConfig.a().o0(false, context).compose(RxJavaHelper.t(this.f76505b)), b.f69038b).doOnNext(new g(this)).flatMap(new h(this));
    }

    public List<ml.b> z() {
        return this.f76508e;
    }
}
