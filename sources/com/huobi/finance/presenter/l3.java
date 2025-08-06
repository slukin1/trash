package com.huobi.finance.presenter;

import ad.i;
import android.app.Activity;
import android.view.View;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.SuperMarginSymbolConfigUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.hbg.core.bean.MaxRateMiningProject;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.ui.ContractTradeBaseFragment;
import com.huobi.finance.bean.CurrencyIntroBean;
import com.huobi.finance.presenter.CurrencyDetailPresenter;
import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;
import com.huobi.utils.k0;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import ej.f;
import i6.d;
import i8.k;
import java.util.ArrayList;
import java.util.List;
import o6.b;
import pro.huobi.R;
import rx.Observable;
import sl.f0;
import zq.e;

public class l3 {

    /* renamed from: l  reason: collision with root package name */
    public static final String[] f45967l = {"usdt", "husd", "btc", "eth", "ht"};

    /* renamed from: a  reason: collision with root package name */
    public final Activity f45968a;

    /* renamed from: b  reason: collision with root package name */
    public final CurrencyDetailPresenter.d f45969b;

    /* renamed from: c  reason: collision with root package name */
    public final String f45970c;

    /* renamed from: d  reason: collision with root package name */
    public final CurrencyIntroBean f45971d;

    /* renamed from: e  reason: collision with root package name */
    public CurrencyIntroBean.TradeItem f45972e;

    /* renamed from: f  reason: collision with root package name */
    public CurrencyIntroBean.TradeItem f45973f;

    /* renamed from: g  reason: collision with root package name */
    public CurrencyIntroBean.TradeItem f45974g;

    /* renamed from: h  reason: collision with root package name */
    public CurrencyIntroBean.TradeItem f45975h;

    /* renamed from: i  reason: collision with root package name */
    public FutureContractInfo f45976i;

    /* renamed from: j  reason: collision with root package name */
    public ContractCurrencyInfo f45977j;

    /* renamed from: k  reason: collision with root package name */
    public final List<CurrencyIntroBean.TradeItem> f45978k;

    public class a implements f0.b {
        public a() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            if (list != null) {
                l3.this.f45972e.q(f0.g().h(l3.this.f45972e.h()));
                if (l3.this.f45973f != null) {
                    l3.this.f45973f.q(f0.g().h(l3.this.f45973f.h()));
                }
                d.c("CurrencyDetailTradeIntroHelper", "Pro Price Update.");
                l3.this.a0();
            }
        }
    }

    public class b implements b.C0747b {
        public b() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            l3.this.f45974g.q(o6.b.g().h().get(l3.this.f45977j.getContractShortType()));
            d.c("CurrencyDetailTradeIntroHelper", "Contract Price Update.");
            l3.this.a0();
        }
    }

    public class c implements k.b {
        public c() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            if (l3.this.f45976i != null) {
                l3.this.f45975h.q(k.g().h().get(l3.this.f45976i.getContractShortType()));
                d.c("CurrencyDetailTradeIntroHelper", "LinearSwap Price Update.");
                l3.this.a0();
            }
        }
    }

    public l3(Activity activity, CurrencyDetailPresenter.d dVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f45978k = arrayList;
        d.c("CurrencyDetailTradeIntroHelper", "INIT");
        this.f45968a = activity;
        this.f45969b = dVar;
        this.f45970c = str;
        CurrencyIntroBean currencyIntroBean = new CurrencyIntroBean();
        this.f45971d = currencyIntroBean;
        currencyIntroBean.g(str);
        currencyIntroBean.i(arrayList);
        D();
        CurrencyIntroBean.TradeItem tradeItem = this.f45972e;
        if (tradeItem != null) {
            arrayList.add(tradeItem);
        }
        E();
        CurrencyIntroBean.TradeItem tradeItem2 = this.f45973f;
        if (tradeItem2 != null) {
            arrayList.add(tradeItem2);
        }
        Z();
        a0();
        x().compose(RxJavaHelper.t(dVar)).subscribe(EasySubscriber.create(new h3(this)));
        z().compose(RxJavaHelper.t(dVar)).subscribe(EasySubscriber.create(new g3(this)));
        y().compose(RxJavaHelper.t(dVar)).subscribe(EasySubscriber.create(new f3(this)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CurrencyIntroBean.TradeItem F(ContractCurrencyInfo contractCurrencyInfo) {
        if (contractCurrencyInfo == null) {
            return null;
        }
        this.f45977j = contractCurrencyInfo;
        CurrencyIntroBean.TradeItem tradeItem = new CurrencyIntroBean.TradeItem();
        this.f45974g = tradeItem;
        tradeItem.j(B(R.string.n_contract_trade_coin_m_title));
        CurrencyIntroBean.TradeItem tradeItem2 = this.f45974g;
        tradeItem2.r(d7.k.C().z(this.f45970c) + " " + B(R.string.n_market_contract_symbol_quarter));
        this.f45974g.o((String) null);
        this.f45974g.n("usd");
        this.f45974g.m(f.p(contractCurrencyInfo.getContractCode()));
        this.f45974g.q(o6.b.g().h().get(contractCurrencyInfo.getContractShortType()));
        this.f45974g.l(new d3(this, contractCurrencyInfo));
        return this.f45974g;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean H(ContractCurrencyInfo contractCurrencyInfo) {
        return Boolean.valueOf(this.f45970c.equalsIgnoreCase(contractCurrencyInfo.getSymbol()) && !contractCurrencyInfo.isNotSupportTrade() && "quarter".equals(contractCurrencyInfo.getContractType()));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void I(ContractCurrencyInfo contractCurrencyInfo, View view) {
        ContractTradeBaseFragment.Ri(this.f45968a, contractCurrencyInfo);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void J(MaxRateMiningProject maxRateMiningProject) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Load MaxRateMiningProject success. maxRateMiningProject=");
        if (maxRateMiningProject == null) {
            str = OptionsBridge.NULL_VALUE;
        } else {
            str = maxRateMiningProject.toString();
        }
        sb2.append(str);
        d.c("CurrencyDetailTradeIntroHelper", sb2.toString());
    }

    public static /* synthetic */ MaxRateMiningProject K(Boolean bool, MaxRateMiningProject maxRateMiningProject) {
        if (bool.booleanValue()) {
            return maxRateMiningProject;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean M(FutureContractInfo futureContractInfo) {
        return Boolean.valueOf(this.f45970c.equalsIgnoreCase(futureContractInfo.getSymbol()) && !futureContractInfo.isNotSupportTrade() && futureContractInfo.isSupportCross());
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void N(FutureContractInfo futureContractInfo, View view) {
        LinearSwapTradeBaseFragment.Lj(this.f45968a, futureContractInfo, 1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CurrencyIntroBean.TradeItem O(FutureContractInfo futureContractInfo) {
        if (futureContractInfo == null) {
            return null;
        }
        this.f45976i = futureContractInfo;
        CurrencyIntroBean.TradeItem tradeItem = new CurrencyIntroBean.TradeItem();
        this.f45975h = tradeItem;
        tradeItem.j(B(R.string.n_contract_trade_usdt_m_title));
        CurrencyIntroBean.TradeItem tradeItem2 = this.f45975h;
        tradeItem2.r(d7.k.C().z(this.f45970c) + " " + B(R.string.n_market_contract_swap_trade_name));
        this.f45975h.o("/USDT");
        this.f45975h.m(FuturePrecisionUtil.y(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), (String) null));
        this.f45975h.q(k.g().h().get(futureContractInfo.getContractShortType()));
        this.f45975h.l(new c3(this, futureContractInfo));
        return this.f45975h;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Q(SymbolBean symbolBean, View view) {
        k0.O(view.getContext(), symbolBean.getSymbol(), true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void R(String str, View view) {
        k0.R(str, "0", true, this.f45968a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S(CurrencyIntroBean.TradeItem tradeItem) {
        CurrencyIntroBean.TradeItem tradeItem2 = this.f45974g;
        if (tradeItem2 != null) {
            this.f45978k.add(tradeItem2);
            X();
            a0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T(CurrencyIntroBean.TradeItem tradeItem) {
        CurrencyIntroBean.TradeItem tradeItem2 = this.f45975h;
        if (tradeItem2 != null) {
            this.f45978k.add(tradeItem2);
            Y();
            a0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(MaxRateMiningProject maxRateMiningProject) {
        this.f45971d.h(maxRateMiningProject);
        a0();
    }

    public CurrencyIntroBean.TradeItem A() {
        return this.f45972e;
    }

    public final String B(int i11) {
        return this.f45968a.getResources().getString(i11);
    }

    public final SymbolBean C(TradeType tradeType) {
        for (String str : f45967l) {
            SymbolBean J = a1.v().J(StringUtils.g(this.f45970c + str), tradeType);
            if (J != null) {
                return J;
            }
        }
        for (SymbolBean next : a1.v().Z(tradeType)) {
            if (next.isAltsTag() && this.f45970c.equalsIgnoreCase(next.getBaseCurrency())) {
                return next;
            }
            if (next.isFiatTag() && this.f45970c.equalsIgnoreCase(next.getBaseCurrency())) {
                return next;
            }
        }
        return null;
    }

    public final void D() {
        SymbolBean C = C(TradeType.PRO);
        if (C != null) {
            CurrencyIntroBean.TradeItem tradeItem = new CurrencyIntroBean.TradeItem();
            this.f45972e = tradeItem;
            tradeItem.p(C.getSymbol());
            this.f45972e.j(B(R.string.n_spot));
            this.f45972e.r(C.getBaseCurrencyDisplayName());
            CurrencyIntroBean.TradeItem tradeItem2 = this.f45972e;
            tradeItem2.o("/" + C.getQuoteCurrencyDisplayName());
            this.f45972e.l(new v2(C));
            this.f45972e.q(f0.g().h(C.getSymbol()));
        }
    }

    public final void E() {
        SymbolBean C = C(TradeType.SUPERMARGIN);
        if (C != null) {
            String symbol = C.getSymbol();
            CurrencyIntroBean.TradeItem tradeItem = new CurrencyIntroBean.TradeItem();
            this.f45973f = tradeItem;
            tradeItem.p(symbol);
            this.f45973f.j(B(R.string.n_kline_loan));
            this.f45973f.r(C.getBaseCurrencyDisplayName());
            CurrencyIntroBean.TradeItem tradeItem2 = this.f45973f;
            tradeItem2.o("/" + C.getQuoteCurrencyDisplayName());
            this.f45973f.q(f0.g().h(symbol));
            this.f45973f.k(SuperMarginSymbolConfigUtil.f().get(symbol).getLoanMultiple());
            this.f45973f.l(new e3(this, symbol));
        }
    }

    public void V() {
        Z();
        X();
        Y();
    }

    public void W() {
        f0.g().j("DETAIL_MARKET");
        o6.b.g().j("DETAIL_MARKET");
        k.g().j("DETAIL_MARKET");
        f0.g().n();
        o6.b.g().n();
        k.g().n();
    }

    public final void X() {
        if (this.f45974g != null) {
            o6.b.g().e("DETAIL_MARKET", new b());
            o6.b.g().i();
            d.c("CurrencyDetailTradeIntroHelper", "Contract subOverview");
        }
    }

    public final void Y() {
        if (this.f45975h != null) {
            k.g().e("DETAIL_MARKET", new c());
            k.g().i();
            d.c("CurrencyDetailTradeIntroHelper", "LinearSwap subOverview");
        }
    }

    public final void Z() {
        if (this.f45972e != null) {
            f0.g().e("DETAIL_MARKET", new a());
            f0.g().i();
            d.c("CurrencyDetailTradeIntroHelper", "Pro subOverview");
        }
    }

    public final void a0() {
        d.c("CurrencyDetailTradeIntroHelper", "updateUi currencyIntroBean=" + this.f45971d.toString());
        this.f45969b.Y6(this.f45971d);
    }

    public final Observable<CurrencyIntroBean.TradeItem> x() {
        return ContractCurrencyUtils.g(true).flatMap(i.f3526b).takeFirst(new w2(this)).defaultIfEmpty(null).map(new x2(this)).onErrorReturn(y2.f46187b);
    }

    public final Observable<MaxRateMiningProject> y() {
        return Observable.zip(e.e().f(true).compose(RxJavaHelper.t(this.f45969b)), v7.b.a().getMiningMaxRateProject(this.f45970c).b().compose(RxJavaHelper.t(this.f45969b)).doOnNext(i3.f45919b), b3.f45814b).onErrorReturn(z2.f46200b);
    }

    public final Observable<CurrencyIntroBean.TradeItem> z() {
        return FutureContractInfoController.n().h(TradeType.LINEAR_SWAP, true).flatMap(i.f3526b).takeFirst(new j3(this)).defaultIfEmpty(null).map(new k3(this)).onErrorReturn(a3.f45799b);
    }
}
