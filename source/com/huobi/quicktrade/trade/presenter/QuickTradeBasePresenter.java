package com.huobi.quicktrade.trade.presenter;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import cn.sharesdk.framework.InnerShareParams;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.clear.controller.ClearDialogConfigController;
import com.hbg.lib.data.symbol.ExchangeSettingsController;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.ClearDialogConfig;
import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.index.bean.IndexFeature;
import com.huobi.login.bean.JumpTarget;
import com.huobi.trade.bean.AssetAndOrderUpdateEvent;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.trade.helper.TradeLimitHelper;
import com.huobi.trade.helper.c0;
import com.huobi.trade.ui.h1;
import d7.a1;
import dt.a5;
import dt.d3;
import dt.e3;
import dt.i2;
import dt.r2;
import ht.o;
import i6.i;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k20.h;
import k6.c;
import org.greenrobot.eventbus.ThreadMode;
import tg.r;
import u6.g;

public abstract class QuickTradeBasePresenter<V extends h1> extends BaseFragmentPresenter<V> implements a5.l, a5.m {

    /* renamed from: c  reason: collision with root package name */
    public String f80572c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f80573d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f80574e = "";

    /* renamed from: f  reason: collision with root package name */
    public boolean f80575f;

    /* renamed from: g  reason: collision with root package name */
    public r2 f80576g;

    /* renamed from: h  reason: collision with root package name */
    public d3 f80577h;

    /* renamed from: i  reason: collision with root package name */
    public e3 f80578i;

    /* renamed from: j  reason: collision with root package name */
    public int f80579j = 0;

    /* renamed from: k  reason: collision with root package name */
    public TradeType f80580k = TradeType.PRO;

    /* renamed from: l  reason: collision with root package name */
    public boolean f80581l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f80582m;

    /* renamed from: n  reason: collision with root package name */
    public String f80583n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f80584o;

    /* renamed from: p  reason: collision with root package name */
    public int f80585p = 0;

    /* renamed from: q  reason: collision with root package name */
    public int f80586q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f80587r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f80588s = true;

    /* renamed from: t  reason: collision with root package name */
    public int f80589t = -1;

    public class a extends BaseSubscriber<IndexFeature> {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(IndexFeature indexFeature) {
            ((h1) QuickTradeBasePresenter.this.getUI()).L1(indexFeature);
        }

        /* renamed from: c */
        public void onNext(IndexFeature indexFeature) {
            super.onNext(indexFeature);
            i.b().g(new rq.c(this, indexFeature), 300);
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ((h1) QuickTradeBasePresenter.this.getUI()).L1(c0.d().c());
        }

        public void onStart() {
            super.onStart();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            if (((h1) QuickTradeBasePresenter.this.getUI()).isCanBeSeen()) {
                QuickTradeBasePresenter quickTradeBasePresenter = QuickTradeBasePresenter.this;
                quickTradeBasePresenter.x0(false, quickTradeBasePresenter.o0(), true);
            }
        }
    }

    public class c extends BaseSubscriber<ClearDialogConfig> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(ClearDialogConfig clearDialogConfig) {
            super.onNext(clearDialogConfig);
            if (ClearDialogConfigController.h(QuickTradeBasePresenter.this.f80589t)) {
                ((h1) QuickTradeBasePresenter.this.getUI()).K2(clearDialogConfig.getRulesUrl(), clearDialogConfig.getTips(), QuickTradeBasePresenter.this.f80589t);
            }
        }
    }

    public class d extends BaseSubscriber<List<LegalRateBean>> {
        public d() {
        }

        public void onNext(List<LegalRateBean> list) {
            if (((h1) QuickTradeBasePresenter.this.getUI()).isCanBeSeen()) {
                MarketCurrentPriceItem v11 = QuickTradeBasePresenter.this.f80576g.v();
                if (v11 != null) {
                    v11.p(QuickTradeBasePresenter.this.f80576g.B());
                    ((h1) QuickTradeBasePresenter.this.getUI()).H0(v11);
                    ((h1) QuickTradeBasePresenter.this.getUI()).h2();
                }
                ((h1) QuickTradeBasePresenter.this.getUI()).l2(String.valueOf(QuickTradeBasePresenter.this.p0().B()));
                if (com.hbg.lib.core.util.b.c().f()) {
                    ((h1) QuickTradeBasePresenter.this.getUI()).n1(false);
                    return;
                }
                ((h1) QuickTradeBasePresenter.this.getUI()).n1(true);
                ((h1) QuickTradeBasePresenter.this.getUI()).n1(false);
            }
        }
    }

    public class e implements TradeLimitHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrderPlaceBean f80594a;

        public e(OrderPlaceBean orderPlaceBean) {
            this.f80594a = orderPlaceBean;
        }

        public void a(boolean z11) {
            if (z11) {
                QuickTradeBasePresenter quickTradeBasePresenter = QuickTradeBasePresenter.this;
                quickTradeBasePresenter.f80577h.b0(quickTradeBasePresenter.f80580k, this.f80594a, quickTradeBasePresenter.getActivity());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D0(BalanceProfitLossData balanceProfitLossData) {
        ((h1) getUI()).f3(m.a(balanceProfitLossData.getTotalBalance()).compareTo(BigDecimal.ZERO) <= 0);
    }

    public boolean A0() {
        return this.f80581l;
    }

    public boolean B0() {
        return a1.v().q0(this.f80573d, this.f80580k);
    }

    public void E0() {
        is.a.j("4247", (Map<String, Object>) null, "1000048");
    }

    /* renamed from: F0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, V v11) {
        super.onUIReady(baseCoreActivity, v11);
        this.f80580k = TradeType.valueOf(Q().getArguments().getString("key_trade_type", TradeType.PRO.name()));
        this.f80577h = new d3((h1) getUI());
        this.f80576g = new r2((r2.d) getUI(), (a5) null, this.f80580k, getActivity());
        this.f80578i = new e3(this.f80580k, (e3.c) getUI(), getActivity());
        ((h1) getUI()).y2();
        j0(nq.a.c(), false);
    }

    public void G0(Map<String, String> map, OrderPlaceBean orderPlaceBean) {
        HashMap hashMap = new HashMap();
        if (map.containsKey("platform")) {
            hashMap.put("platform", map.get("platform"));
        } else {
            hashMap.put("platform", "1");
        }
        if (map.containsKey("sessionID")) {
            hashMap.put(SettingsJsonConstants.SESSION_KEY, map.get("sessionID"));
        }
        if (map.containsKey("sig")) {
            hashMap.put("sig", map.get("sig"));
        }
        hashMap.put("token", orderPlaceBean.getAliToken().getSliderToken());
        if (map.containsKey(InnerShareParams.SCENCE)) {
            hashMap.put(InnerShareParams.SCENCE, map.get(InnerShareParams.SCENCE));
        } else {
            hashMap.put(InnerShareParams.SCENCE, map.get("activity"));
        }
        orderPlaceBean.setVerify(hashMap);
        this.f80577h.b0(this.f80580k, orderPlaceBean, getActivity());
    }

    public void H0() {
        this.f80576g.R(this.f80573d);
        this.f80578i.d(this.f80573d);
    }

    public final void I0(boolean z11) {
        ExchangeSettingsController.d().c(z11, this.f80573d).compose(RxJavaHelper.t((g) getUI())).subscribe(new BaseSubscriber());
    }

    public void J0(boolean z11) {
        this.f80588s = z11;
    }

    public void K0(int i11) {
        this.f80587r = i11;
    }

    public void L0() {
        ((h1) getUI()).u3(m.i(this.f80576g.B(), PrecisionUtil.A(o0())));
    }

    public void M0(boolean z11) {
        this.f80581l = z11;
    }

    public void N0() {
        E0();
        rn.c.i().d(getActivity(), new JumpTarget((Intent) null, (Intent) null));
    }

    public void O0(String str, String str2, boolean z11, String str3) {
        int i11;
        String str4;
        double d11;
        List<MarketBuySellItem> list;
        String str5;
        BigDecimal valueOf = BigDecimal.valueOf(this.f80576g.B());
        h1 h1Var = (h1) getUI();
        int uiPlanTradeBuyMode = z11 ? h1Var.getUiPlanTradeBuyMode() : h1Var.getUiPlanTradeSellMode();
        if (z11) {
            i11 = ((h1) getUI()).S1();
        } else {
            i11 = ((h1) getUI()).c2();
        }
        if (this.f80579j == 1) {
            if (z11) {
                str5 = r0();
            } else {
                str5 = m0();
            }
            str4 = str5;
        } else {
            str4 = str;
        }
        String str6 = str4;
        String str7 = str2;
        boolean z12 = z11;
        boolean W = this.f80577h.W(this.f80580k, o0(), this.f80579j, str6, str7, z12, valueOf, this.f80582m, str3, o.B().K(), i11, uiPlanTradeBuyMode);
        if (!this.f80577h.J(this.f80580k, o0(), this.f80579j, str6, str7, z12, this.f80582m, o.B().K(), i11, uiPlanTradeBuyMode) && !W) {
            v7.b.a().getBalanceProfitLoss().b().compose(RxJavaHelper.t((g) getUI())).subscribe(EasySubscriber.create(new rq.a(this)));
        }
        if (W) {
            OrderPlaceBean selectedMarketAmount = this.f80577h.X(this.f80580k, this.f80573d, this.f80579j, str4, str2, z11, str3, valueOf, i11, (CouponReturn) null).setSelectedMarketAmount(((h1) getUI()).U7());
            if (this.f80579j == 3) {
                selectedMarketAmount.setPlanTradeMarketMode(this.f80587r);
            }
            boolean z13 = false;
            if (3 == selectedMarketAmount.getTradeViewType()) {
                z13 = true;
            }
            if (z13) {
                this.f80577h.b0(this.f80580k, selectedMarketAmount, getActivity());
            } else if (B0()) {
                this.f80577h.Y(this.f80580k, selectedMarketAmount);
            } else if (this.f80579j == 1) {
                SymbolBean J = a1.v().J(this.f80573d, this.f80580k);
                BaseCoreActivity activity = getActivity();
                TradeType tradeType = this.f80580k;
                String str8 = this.f80573d;
                if (z11) {
                    d11 = J.getMarketBuyPriceHigherThanCurrent();
                } else {
                    d11 = J.getMarketSellPriceLowerThanCurrent();
                }
                double d12 = d11;
                double a11 = this.f80576g.v().a();
                if (z11) {
                    list = this.f80576g.D();
                } else {
                    list = this.f80576g.C();
                }
                TradeLimitHelper.e(activity, tradeType, str8, z11, valueOf, str4, s0(d12, str2, a11, list), new e(selectedMarketAmount));
            } else {
                this.f80577h.b0(this.f80580k, selectedMarketAmount, getActivity());
            }
        }
    }

    public void P0() {
        if (!r.x().F0()) {
            this.f80577h.r();
        }
    }

    public void Q0() {
        if (B0()) {
            ((h1) getUI()).o3(0, 5);
        } else if (a1.v().r0(this.f80573d)) {
            ((h1) getUI()).o3(0, 6);
        } else if (a1.v().p0(this.f80573d)) {
            ((h1) getUI()).o3(0, 4);
        } else if (a1.v().M(this.f80573d)) {
            ((h1) getUI()).o3(0, 0);
        } else if (a1.v().T(this.f80573d)) {
            ((h1) getUI()).o3(0, 1);
        } else if (a1.v().O(this.f80573d)) {
            ((h1) getUI()).o3(8, 7);
        } else if (a1.v().N(this.f80573d)) {
            ((h1) getUI()).o3(0, 2);
        } else {
            ((h1) getUI()).o3(8, 3);
        }
    }

    public void R0(boolean z11) {
        if (Q().getActivity() != null) {
            this.f80575f = z11;
            if (z11) {
                this.f80580k = TradeType.valueOf(Q().getArguments().getString("key_trade_type", TradeType.PRO.name()));
                i6.d.b(this.f80580k + "======" + com.huobi.trade.helper.d.b(this.f80580k));
                Q().getArguments();
                if (com.huobi.trade.helper.d.b(this.f80580k)) {
                    i6.d.b(this.f80580k + "======" + com.huobi.trade.helper.d.a(this.f80580k));
                    this.f80588s = com.huobi.trade.helper.d.a(this.f80580k);
                    com.huobi.trade.helper.d.c(this.f80580k);
                    ((h1) getUI()).B(com.huobi.trade.helper.d.a(this.f80580k) ^ true ? 1 : 0);
                }
                y0();
                if (this.f80584o) {
                    String string = Q().getArguments().getString("tradingview_symbol", "btcusdt");
                    if (B0() && this.f80579j == 3) {
                        this.f80579j = 0;
                    }
                    if (!a1.v().S(string)) {
                        j0(this.f80579j, false);
                    }
                }
                h0();
                return;
            }
            g0();
        }
    }

    public void Z(boolean z11) {
        super.Z(z11);
        R0(z11);
    }

    public void a() {
    }

    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        if (((h1) getUI()).isCanBeSeen()) {
            this.f80576g.X(this.f80573d, false);
            ((h1) getUI()).F(this.f80579j, true);
            this.f80580k = symbolChangeEvent.e();
            y0();
            j0(0, true);
            ((h1) getUI()).d2(PrecisionUtil.e(this.f80573d));
            x0(false, this.f80573d, true);
            P0();
            Q0();
            ((h1) getUI()).O1(this.f80573d, this.f80580k);
            ((h1) getUI()).E2();
            if (this.f80575f) {
                this.f80576g.O(this.f80573d, this.f80580k);
                this.f80578i.d(this.f80573d);
                w0();
                this.f80581l = false;
            }
            if (!TextUtils.isEmpty(this.f80573d)) {
                I0(true);
            }
            n0();
        }
    }

    public /* bridge */ /* synthetic */ g d() {
        return (g) super.getUI();
    }

    public int e() {
        return this.f80585p;
    }

    public int g() {
        return this.f80586q;
    }

    public void g0() {
        this.f80582m = false;
        this.f80576g.X(this.f80573d, false);
        this.f80578i.g(this.f80573d);
        ((h1) getUI()).R1(true, z0());
    }

    public void h0() {
        this.f80581l = false;
        boolean F0 = r.x().F0();
        ((h1) getUI()).F(this.f80579j, true);
        ((h1) getUI()).d(F0);
        ((h1) getUI()).d2(PrecisionUtil.e(this.f80573d));
        i0(F0, z0());
        P0();
        n0();
        w0();
        this.f80576g.O(this.f80573d, this.f80580k);
        this.f80578i.d(this.f80573d);
        Q0();
        ((h1) getUI()).O1(this.f80573d, this.f80580k);
        t0();
        r.x().B0(false, (g) null);
        this.f80584o = true;
        ad.o.e().compose(RxJavaHelper.t((g) getUI())).subscribe(new BaseEasySubscriber());
        if (!TextUtils.isEmpty(this.f80573d)) {
            I0(true);
        }
    }

    public abstract void i0(boolean z11, boolean z12);

    public void j0(int i11, boolean z11) {
        this.f80581l = false;
        int i12 = this.f80579j;
        this.f80579j = i11;
        ((h1) getUI()).v(i12, this.f80579j, z0(), o0());
        nq.a.f(i11);
    }

    public void k0(String str) {
        SymbolChangeEvent symbolChangeEvent = new SymbolChangeEvent();
        symbolChangeEvent.g(str);
        symbolChangeEvent.i(str);
        symbolChangeEvent.j(this.f80580k);
        symbolChangeEvent.h(true);
        afterSymbolIdChanged(symbolChangeEvent);
    }

    public String l0() {
        return this.f80574e;
    }

    public String m0() {
        return (this.f80576g.C() == null || this.f80576g.C().isEmpty() || !this.f80573d.equals(this.f80576g.C().get(0).o0())) ? "" : String.valueOf(this.f80576g.C().get(0).a());
    }

    public final void n0() {
        int i11;
        this.f80589t = -1;
        if (r.x().F0() && a1.v().J(this.f80573d, this.f80580k) != null && (i11 = this.f80589t) != -1) {
            ClearDialogConfigController.c(i11, false).compose(RxJavaHelper.t((g) getUI())).subscribe(new c());
        }
    }

    public String o0() {
        return this.f80573d;
    }

    public void onErrorCodeEvent(mo.a aVar) {
        if (((h1) getUI()).isCanBeSeen()) {
            ((h1) getUI()).F(this.f80579j, true);
            this.f80577h.t();
            ((h1) getUI()).d(false);
            N0();
        }
    }

    public r2 p0() {
        return this.f80576g;
    }

    public BigDecimal q0(boolean z11, String str) {
        return this.f80577h.x(this.f80580k, str, z11);
    }

    public String r0() {
        return (this.f80576g.D() == null || this.f80576g.D().isEmpty() || !this.f80573d.equals(this.f80576g.D().get(0).o0())) ? "" : String.valueOf(this.f80576g.D().get(0).a());
    }

    public final String s0(double d11, String str, double d12, List<? extends c.a> list) {
        double d13;
        double d14 = d11;
        try {
            d13 = Double.parseDouble(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
            d13 = 0.0d;
        }
        if (d14 == 0.0d || d13 == 0.0d) {
            return "";
        }
        for (c.a aVar : list) {
            d13 -= aVar.a() * aVar.e();
            if (d13 >= 0.0d) {
                int i11 = (d13 > 0.0d ? 1 : (d13 == 0.0d ? 0 : -1));
                if (i11 >= 0) {
                    if (Math.abs(d12 - aVar.a()) >= (d12 * d14) / 100.0d) {
                        return d14 + "%";
                    } else if (i11 == 0) {
                        break;
                    }
                }
            } else if (Math.abs(d12 - aVar.a()) < (d12 * d14) / 100.0d) {
                return null;
            } else {
                return d14 + "%";
            }
        }
        return null;
    }

    public void t0() {
        c0.d().e().compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }

    public TradeType u0() {
        return this.f80580k;
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void updateAssetAndOrder(AssetAndOrderUpdateEvent assetAndOrderUpdateEvent) {
        if (((h1) getUI()).isCanBeSeen()) {
            i.b().g(new b(), 500);
        }
    }

    public int v0() {
        return this.f80579j;
    }

    public final void w0() {
        LegalCurrencyConfigUtil.e().flatMap(rq.b.f25782b).compose(RxJavaHelper.t((g) getUI())).subscribe(new d());
    }

    public abstract void x0(boolean z11, String str, boolean z12);

    public final void y0() {
        String string = Q().getArguments().getString("tradingview_symbol", "btcusdt");
        if (!TextUtils.isEmpty(string)) {
            this.f80573d = string;
            SymbolBean J = a1.v().J(this.f80573d, this.f80580k);
            if (J != null) {
                this.f80572c = J.getSymbolName();
                this.f80574e = J.getBaseCurrency();
                return;
            }
            return;
        }
        List<SymbolBean> Z = a1.v().Z(this.f80580k);
        if (Z != null && !Z.isEmpty()) {
            SymbolBean symbolBean = Z.get(0);
            this.f80573d = symbolBean.getSymbol();
            this.f80572c = symbolBean.getSymbolName();
            this.f80574e = symbolBean.getBaseCurrency();
            i2.a().h(this.f80580k, this.f80573d);
        }
    }

    public boolean z0() {
        return this.f80588s;
    }
}
