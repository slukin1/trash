package com.huobi.tradenew.presenter;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import cn.sharesdk.framework.InnerShareParams;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.network.rx.SilentSubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.clear.controller.ClearDialogConfigController;
import com.hbg.lib.data.symbol.ExchangeSettingsController;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.BizTipRecord;
import com.hbg.lib.network.hbg.core.bean.ClearDialogConfig;
import com.hbg.lib.network.hbg.core.bean.EtpAvailableBean;
import com.hbg.lib.network.hbg.core.bean.PioneerActivityLimit;
import com.hbg.lib.network.hbg.core.bean.RemainingAmountBean;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.network.hbg.record.BizRecordProvider;
import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.hbg.lib.network.pro.core.bean.CancelOpenOrdersResult;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.uc.core.utils.LicenseType;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.AccountType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.finance.bean.MarginBalanceDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.index.bean.IndexFeature;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.supermargin.bean.MarginLoanAsset;
import com.huobi.supermargin.bean.MarginOverview;
import com.huobi.supermargin.service.SuperMarginService;
import com.huobi.trade.bean.AssetAndOrderUpdateEvent;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.trade.bean.OrderConfirmBean;
import com.huobi.trade.bean.OrderMarginParams;
import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.trade.bean.TradeHoldBean;
import com.huobi.trade.prime.bean.AliToken;
import com.huobi.trade.prime.bean.TradeOrderNum;
import com.huobi.tradenew.helper.AutoLoanSelectDialog;
import com.huobi.tradenew.prime.helper.TradeMarginHelper;
import com.huobi.tradenew.ui.TradeOrderConfirmFragment;
import com.huobi.tradenew.ui.z0;
import d7.a1;
import dt.h2;
import dt.i2;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import qt.v;
import qt.y;
import rt.b0;
import rt.d1;
import rt.i;
import rt.z;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import tg.r;

public abstract class TradeBasePresenter<V extends z0> extends BaseFragmentPresenter<V> implements d1.f, d1.g {
    public RemainingAmountBean A;
    public EtpAvailableBean B;
    public boolean C = true;
    public int D = -1;
    public boolean E;
    public final List<TradeHoldBean> F = new ArrayList();
    public final st.a<Boolean> G = new st.a<>(Boolean.valueOf(this.C));
    public final st.a<Integer> H = new st.a<>(Integer.valueOf(this.f82879m));
    public AutoLoanSelectDialog.a I = new st.b(this);

    /* renamed from: c  reason: collision with root package name */
    public Subscription f82869c;

    /* renamed from: d  reason: collision with root package name */
    public String f82870d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f82871e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f82872f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f82873g = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f82874h;

    /* renamed from: i  reason: collision with root package name */
    public rt.i f82875i;

    /* renamed from: j  reason: collision with root package name */
    public d1 f82876j;

    /* renamed from: k  reason: collision with root package name */
    public z f82877k;

    /* renamed from: l  reason: collision with root package name */
    public b0 f82878l;

    /* renamed from: m  reason: collision with root package name */
    public int f82879m = 0;

    /* renamed from: n  reason: collision with root package name */
    public TradeType f82880n = TradeType.PRO;

    /* renamed from: o  reason: collision with root package name */
    public boolean f82881o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f82882p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f82883q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f82884r;

    /* renamed from: s  reason: collision with root package name */
    public String f82885s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f82886t;

    /* renamed from: u  reason: collision with root package name */
    public int f82887u = 0;

    /* renamed from: v  reason: collision with root package name */
    public int f82888v = -1;

    /* renamed from: w  reason: collision with root package name */
    public int f82889w;

    /* renamed from: x  reason: collision with root package name */
    public AutoLoanSelectDialog f82890x;

    /* renamed from: y  reason: collision with root package name */
    public Subscription f82891y;

    /* renamed from: z  reason: collision with root package name */
    public long f82892z;

    public class a extends BaseSubscriber<TradeRiskReminder> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(TradeRiskReminder tradeRiskReminder) {
            qt.g.a().g(tradeRiskReminder.getState());
        }
    }

    public class b implements TradeOrderConfirmFragment.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrderPlaceBean f82894a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82895b;

        public b(OrderPlaceBean orderPlaceBean, boolean z11) {
            this.f82894a = orderPlaceBean;
            this.f82895b = z11;
        }

        public void cancel() {
        }

        public void confirm() {
            ut.o.C().x0(this.f82894a);
            TradeBasePresenter.this.H0(this.f82895b, this.f82894a);
        }
    }

    public class c extends EasySubscriber<AliToken> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OrderPlaceBean f82897b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f82898c;

        public c(OrderPlaceBean orderPlaceBean, boolean z11) {
            this.f82897b = orderPlaceBean;
            this.f82898c = z11;
        }

        /* renamed from: a */
        public void onNext(AliToken aliToken) {
            super.onNext(aliToken);
            ((z0) TradeBasePresenter.this.getUI()).j3(this.f82897b, aliToken);
        }

        public void onAfter() {
            super.onAfter();
            ((z0) TradeBasePresenter.this.getUI()).dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((z0) TradeBasePresenter.this.getUI()).R1(true, this.f82898c);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if ("10008".equals(aPIStatusErrorException.getErrCode())) {
                ut.o.C().v0(aPIStatusErrorException.getErrCode());
            }
            if ("12000".equals(aPIStatusErrorException.getErrCode())) {
                this.f82897b.setVerifyAliToken(false);
                TradeBasePresenter tradeBasePresenter = TradeBasePresenter.this;
                tradeBasePresenter.f82877k.e0(tradeBasePresenter.f82880n, this.f82897b);
            } else {
                super.onFailed(aPIStatusErrorException);
            }
            ((z0) TradeBasePresenter.this.getUI()).R1(true, this.f82898c);
        }

        public void onStart() {
            super.onStart();
            ((z0) TradeBasePresenter.this.getUI()).showProgressDialog();
            this.f82897b.setVerifyAliToken(true);
            ((z0) TradeBasePresenter.this.getUI()).R1(false, this.f82898c);
        }
    }

    public class d extends BaseSubscriber<Pair<MarginBalanceDataTotal, MarginOverview>> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(Pair<MarginBalanceDataTotal, MarginOverview> pair) {
            super.onNext(pair);
            MarginBalanceDataTotal marginBalanceDataTotal = (MarginBalanceDataTotal) pair.first;
            MarginOverview marginOverview = (MarginOverview) pair.second;
            if (marginBalanceDataTotal != null && ((z0) TradeBasePresenter.this.getUI()).isCanBeSeen()) {
                boolean z11 = false;
                boolean z12 = marginOverview == null || i6.m.a(marginOverview.getTotalAmount()).compareTo(BigDecimal.ZERO) == 0;
                if (i6.m.a(marginBalanceDataTotal.getNetAssetToBtc()).compareTo(BigDecimal.ZERO) != 0 || !z12) {
                    if (ks.g.k()) {
                        return;
                    }
                    if (TradeBasePresenter.this.f82890x == null || !TradeBasePresenter.this.f82890x.isVisible()) {
                        AutoLoanSelectDialog unused = TradeBasePresenter.this.f82890x = new AutoLoanSelectDialog();
                        TradeBasePresenter.this.f82890x.show(TradeBasePresenter.this.getActivity().getSupportFragmentManager(), "AutoLoanSelectDialog");
                        TradeBasePresenter.this.f82890x.wh(TradeBasePresenter.this.I);
                    }
                } else if (ks.g.l()) {
                    ks.g.q(1);
                    if (System.currentTimeMillis() - TradeBasePresenter.this.f82892z > 1000) {
                        z11 = true;
                    }
                    ((z0) TradeBasePresenter.this.getUI()).U1(1, z11);
                }
            }
        }
    }

    public class e extends EasySubscriber<CancelOpenOrdersResult> {
        public e() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            TradeBasePresenter.this.updateAssetAndOrder(new AssetAndOrderUpdateEvent());
        }

        /* renamed from: c */
        public void onNext(CancelOpenOrdersResult cancelOpenOrdersResult) {
            super.onNext(cancelOpenOrdersResult);
            if (cancelOpenOrdersResult.getNextId() == -1) {
                HuobiToastUtil.s(R.string.n_order_cancel_success_toast);
            } else if (cancelOpenOrdersResult.getFailedCount() == 0 && cancelOpenOrdersResult.getNextId() > 0) {
                HuobiToastUtil.j(R.string.n_order_cancel_more_toast);
            } else if (cancelOpenOrdersResult.getFailedCount() > 0) {
                String valueOf = String.valueOf(cancelOpenOrdersResult.getFailedCount());
                HuobiToastUtil.m(String.format(Locale.US, TradeBasePresenter.this.getString(R.string.n_order_cancel_part_failed_toast), new Object[]{valueOf}));
            }
        }

        public void onAfter() {
            super.onAfter();
            ((z0) TradeBasePresenter.this.getUI()).dismissProgressDialog();
            i6.i.b().g(new st.l(this), 500);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            HuobiToastUtil.j(R.string.n_order_cancel_failed_toast);
        }

        public void onStart() {
            super.onStart();
            ((z0) TradeBasePresenter.this.getUI()).showProgressDialog();
        }
    }

    public class f implements Observer<TradeOrderNum> {
        public f() {
        }

        /* renamed from: a */
        public void onNext(TradeOrderNum tradeOrderNum) {
            if (tradeOrderNum != null) {
                ((z0) TradeBasePresenter.this.getUI()).z5(tradeOrderNum.getCount());
            }
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
        }
    }

    public class g extends BaseSubscriber<Object> {
        public g() {
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            if (x7.f.d(a1.v().n(TradeBasePresenter.this.f82871e)) || x7.f.d(a1.v().D(TradeBasePresenter.this.f82871e))) {
                ((z0) TradeBasePresenter.this.getUI()).x2(false, false, "");
            }
        }
    }

    public class h extends BaseSubscriber<IndexFeature> {
        public h() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(IndexFeature indexFeature) {
            ((z0) TradeBasePresenter.this.getUI()).L1(indexFeature);
        }

        /* renamed from: c */
        public void onNext(IndexFeature indexFeature) {
            super.onNext(indexFeature);
            i6.i.b().g(new st.k(this, indexFeature), 300);
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ((z0) TradeBasePresenter.this.getUI()).L1(qt.b0.d().c());
        }

        public void onStart() {
            super.onStart();
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            if (((z0) TradeBasePresenter.this.getUI()).isCanBeSeen()) {
                TradeBasePresenter tradeBasePresenter = TradeBasePresenter.this;
                tradeBasePresenter.c1(false, tradeBasePresenter.o0(), true);
                TradeBasePresenter.this.A1();
            }
        }
    }

    public class j extends BaseSubscriber<BizTipRecord> {
        public j() {
        }

        /* renamed from: a */
        public void onNext(BizTipRecord bizTipRecord) {
            super.onNext(bizTipRecord);
            if (!BizRecordProvider.e()) {
                ((z0) TradeBasePresenter.this.getUI()).F2();
            }
        }
    }

    public class k extends BaseSubscriber<ClearDialogConfig> {
        public k() {
        }

        /* renamed from: a */
        public void onNext(ClearDialogConfig clearDialogConfig) {
            super.onNext(clearDialogConfig);
            if (ClearDialogConfigController.h(TradeBasePresenter.this.D)) {
                ((z0) TradeBasePresenter.this.getUI()).K2(clearDialogConfig.getRulesUrl(), clearDialogConfig.getTips(), TradeBasePresenter.this.D);
            }
        }
    }

    public class l extends BaseSubscriber<List<LegalRateBean>> {
        public l() {
        }

        public void onNext(List<LegalRateBean> list) {
            if (((z0) TradeBasePresenter.this.getUI()).isCanBeSeen()) {
                MarketCurrentPriceItem u11 = TradeBasePresenter.this.f82875i.u();
                if (u11 != null) {
                    u11.p(TradeBasePresenter.this.f82875i.z());
                    ((z0) TradeBasePresenter.this.getUI()).H0(u11);
                    ((z0) TradeBasePresenter.this.getUI()).h2();
                }
                ((z0) TradeBasePresenter.this.getUI()).l2(String.valueOf(TradeBasePresenter.this.M0().z()));
                if (com.hbg.lib.core.util.b.c().f()) {
                    ((z0) TradeBasePresenter.this.getUI()).n1(false);
                    return;
                }
                ((z0) TradeBasePresenter.this.getUI()).n1(true);
                ((z0) TradeBasePresenter.this.getUI()).n1(false);
            }
        }
    }

    public class m extends BaseSubscriber<List<PioneerActivityLimit>> {
        public m() {
        }

        public void onNext(List<PioneerActivityLimit> list) {
            super.onNext(list);
            if (x7.f.c(a1.v().n(TradeBasePresenter.this.f82871e)) || x7.f.c(a1.v().D(TradeBasePresenter.this.f82871e))) {
                ((z0) TradeBasePresenter.this.getUI()).k3();
            }
        }
    }

    public class n extends BaseSubscriber<Pair<TradeRiskReminder, List<PioneerActivityLimit>>> {
        public n() {
        }

        /* renamed from: a */
        public void onNext(Pair<TradeRiskReminder, List<PioneerActivityLimit>> pair) {
            super.onNext(pair);
            TradeRiskReminder tradeRiskReminder = (TradeRiskReminder) pair.first;
            if (x7.f.c(a1.v().n(TradeBasePresenter.this.f82871e)) || x7.f.c(a1.v().D(TradeBasePresenter.this.f82871e))) {
                ((z0) TradeBasePresenter.this.getUI()).k3();
            } else if ("0".equals(tradeRiskReminder.getState())) {
                ((z0) TradeBasePresenter.this.getUI()).N1();
            } else if (x7.f.d(a1.v().n(TradeBasePresenter.this.f82871e)) || x7.f.d(a1.v().D(TradeBasePresenter.this.f82871e))) {
                ((z0) TradeBasePresenter.this.getUI()).x2(true, false, "");
            }
        }
    }

    public class o implements DialogUtils.b.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f82911a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f82912b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f82913c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f82914d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f82915e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f82916f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ OrderMarginParams f82917g;

        public class a extends BaseSubscriber<Object> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ HBDialogFragment f82919b;

            public a(HBDialogFragment hBDialogFragment) {
                this.f82919b = hBDialogFragment;
            }

            public void onNext(Object obj) {
                qt.g.a().e(false);
                this.f82919b.dismiss();
                qt.g.a().g("1");
                o oVar = o.this;
                TradeBasePresenter.this.u0(oVar.f82911a, oVar.f82912b, oVar.f82913c, oVar.f82914d, oVar.f82915e, oVar.f82916f, oVar.f82917g);
            }
        }

        public o(String str, String str2, boolean z11, String str3, boolean z12, String str4, OrderMarginParams orderMarginParams) {
            this.f82911a = str;
            this.f82912b = str2;
            this.f82913c = z11;
            this.f82914d = str3;
            this.f82915e = z12;
            this.f82916f = str4;
            this.f82917g = orderMarginParams;
        }

        public void a(HBDialogFragment hBDialogFragment) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("type", "SPOT_CROSS_MARGIN");
            UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap).compose(tq.p.c0()).compose(RxJavaHelper.t((u6.g) TradeBasePresenter.this.getUI())).subscribe(new a(hBDialogFragment));
        }
    }

    public class p implements DialogUtils.b.f {
        public p() {
        }

        public void a(HBDialogFragment hBDialogFragment) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j1(BalanceProfitLossData balanceProfitLossData) {
        ((z0) getUI()).f3(i6.m.a(balanceProfitLossData.getTotalBalance()).compareTo(BigDecimal.ZERO) <= 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable k1(String str, Long l11) {
        int i11 = this.f82887u;
        return x8.a.a().B(l11, str, i11 == 1 ? "buy-stop-limit,buy-stop-limit-fok,sell-stop-limit,sell-stop-limit-fok" : i11 == 0 ? "buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok,sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok" : "", (String) null, -1).b();
    }

    public static /* synthetic */ Observable l1(Long l11) {
        if (l11 == null) {
            return Observable.just(null);
        }
        return ((SuperMarginService) tq.p.W(SuperMarginService.class)).getMarginOverview(l11.longValue()).compose(tq.p.a0()).subscribeOn(Schedulers.io());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n1(int i11) {
        ((z0) getUI()).U1(i11, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o1(List list) {
        List<String> H2 = a1.v().H(this.f82880n);
        if (!H2.isEmpty() && !H2.contains(this.f82871e)) {
            this.f82871e = H2.get(0);
        }
        ((z0) getUI()).finishRefresh();
        if (!a1.v().L(this.f82871e)) {
            G0(this.f82871e);
        } else if (!a1.v().S(this.f82871e)) {
            G0(this.f82871e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p1(APIStatusErrorException aPIStatusErrorException) {
        ((z0) getUI()).finishRefresh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q1(Throwable th2) {
        ((z0) getUI()).finishRefresh();
    }

    public void A0(String str) {
        i2.a().h(this.f82880n, str);
        SymbolChangeEvent symbolChangeEvent = new SymbolChangeEvent();
        symbolChangeEvent.g(str);
        symbolChangeEvent.i(this.f82871e);
        symbolChangeEvent.j(this.f82880n);
        EventBus.d().k(symbolChangeEvent);
    }

    public void A1() {
        ut.o.C().P((u6.g) getUI()).subscribe(new f());
    }

    public abstract void B0(boolean z11, boolean z12);

    public void B1() {
        a1.v().Y(false, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }

    public void C0(int i11, boolean z11) {
        r.x().F0();
        this.f82881o = false;
        this.f82882p = false;
        this.f82883q = false;
        int i12 = this.f82879m;
        this.f82879m = i11;
        ((z0) getUI()).v(i12, this.f82879m, e1(), o0());
        a2();
        this.H.b(Integer.valueOf(this.f82879m));
        try {
            HashMap hashMap = new HashMap(1);
            int i13 = this.f82879m;
            hashMap.put("OrderType_id", i13 != 0 ? i13 != 1 ? i13 != 2 ? "triggerorder" : "stoplimit" : PrimeRounds.ROUND_TRADE_MARKET_TYPE : "limit");
            gs.g.i("App_trade_orderType_click", hashMap);
        } catch (Exception e11) {
            i6.k.j("SensorsData", e11);
        }
    }

    public void C1(boolean z11) {
        this.C = z11;
        this.G.b(Boolean.valueOf(z11));
    }

    public void D0(BigDecimal bigDecimal, BigDecimal bigDecimal2, boolean z11, int i11) {
        BigDecimal bigDecimal3;
        if (bigDecimal != null && bigDecimal2 != null && bigDecimal.compareTo(BigDecimal.ZERO) > 0 && bigDecimal2.compareTo(BigDecimal.ZERO) > 0) {
            String o02 = o0();
            TradeType tradeType = TradeType.PRO;
            TradeType tradeType2 = this.f82880n;
            if (tradeType == tradeType2) {
                bigDecimal3 = R0(z11, o02);
            } else if (TradeType.MARGIN == tradeType2) {
                bigDecimal3 = this.f82877k.z(o02, z11, i11);
            } else if (TradeType.C2C == tradeType2) {
                bigDecimal3 = this.f82877k.v(o02, z11);
            } else {
                bigDecimal3 = this.f82877k.F(tradeType2, o02, z11, i11);
            }
            if (z11) {
                int i12 = this.f82879m;
                if ((i12 == 0 || i12 == 2) && !a1.v().S(this.f82871e)) {
                    bigDecimal.multiply(bigDecimal2).subtract(bigDecimal3).compareTo(BigDecimal.ZERO);
                } else {
                    bigDecimal2.subtract(bigDecimal3).compareTo(BigDecimal.ZERO);
                }
            } else {
                bigDecimal2.subtract(bigDecimal3).compareTo(BigDecimal.ZERO);
            }
        }
    }

    public void D1(int i11) {
        i6.d.e("PLAN_TRADE", "setCurOrderListTradeType - " + i11);
        qt.h.b().g(Integer.valueOf(i11));
        qt.h.b().f();
        this.f82887u = i11;
    }

    public void E0() {
        this.f82876j.x0(this.f82871e, this.f82888v, this.f82887u);
        ((z0) getUI()).d3(8);
    }

    public void E1(int i11) {
        this.f82889w = i11;
    }

    public String F0(String str, String str2, String str3) {
        return LegalCurrencyConfigUtil.o(str, str2, str3, Z0());
    }

    public void F1() {
        ((z0) getUI()).u3(i6.m.i(this.f82875i.z(), PrecisionUtil.A(o0())));
    }

    public void G0(String str) {
        SymbolChangeEvent symbolChangeEvent = new SymbolChangeEvent();
        symbolChangeEvent.g(str);
        symbolChangeEvent.i(str);
        symbolChangeEvent.j(this.f82880n);
        symbolChangeEvent.h(true);
        afterSymbolIdChanged(symbolChangeEvent);
    }

    public void G1(boolean z11) {
        this.f82881o = z11;
    }

    public final void H0(boolean z11, OrderPlaceBean orderPlaceBean) {
        if (this.f82879m == 3) {
            orderPlaceBean.setPlanTradeMarketMode(this.f82889w);
        }
        if (a1.v().S(this.f82871e)) {
            if ("10008".equals(ut.o.C().B()) && z11 && this.f82879m == 1) {
                HuobiToastUtil.j(R.string.prime_trade_rounds_over);
            } else if (z11) {
                ut.o.C().z().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c(orderPlaceBean, z11));
            } else {
                this.f82877k.e0(this.f82880n, orderPlaceBean);
            }
        } else if (!a1.v().p0(this.f82871e) || BizRecordProvider.e()) {
            TradeType tradeType = this.f82880n;
            if (tradeType != TradeType.MARGIN && tradeType != TradeType.SUPERMARGIN) {
                this.f82877k.s0(tradeType, orderPlaceBean, getActivity());
            } else if (ks.g.j()) {
                this.f82877k.b0(this.f82880n, orderPlaceBean, getActivity());
            } else {
                this.f82877k.e0(this.f82880n, orderPlaceBean);
            }
        } else {
            ((z0) getUI()).F2();
        }
    }

    public void H1(boolean z11) {
        this.E = z11;
    }

    public String I0() {
        return this.f82872f;
    }

    public void I1(int i11) {
        this.f82888v = i11;
    }

    public String J0() {
        return this.f82873g;
    }

    public void J1() {
        ((z0) getUI()).X1(h1());
        ((z0) getUI()).C8(e1() && f1());
    }

    public String K0() {
        return (this.f82875i.A() == null || this.f82875i.A().isEmpty() || !this.f82871e.equals(this.f82875i.A().get(0).o0())) ? "" : String.valueOf(this.f82875i.A().get(0).a());
    }

    public void K1() {
        t1();
        sn.f.f(this.f82880n, getActivity());
    }

    public final void L0() {
        SymbolBean J;
        this.D = -1;
        if (r.x().F0() && (J = a1.v().J(this.f82871e, this.f82880n)) != null) {
            if (J.isEtpTag()) {
                this.D = 2;
            }
            if (!TextUtils.isEmpty(J.getSuperMarginLeverageRatio()) && this.f82880n == TradeType.SUPERMARGIN) {
                this.D = 3;
            }
            if (!TextUtils.isEmpty(J.getSuperMarginLeverageRatio()) && this.f82880n == TradeType.MARGIN) {
                this.D = 5;
            }
            int i11 = this.D;
            if (i11 != -1) {
                ClearDialogConfigController.c(i11, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new k());
            }
        }
    }

    public void L1() {
        this.f82876j.y0(this.f82880n, this.f82871e, this.f82888v, this.f82887u);
    }

    public rt.i M0() {
        return this.f82875i;
    }

    public void M1() {
        this.f82876j.B0();
    }

    public String N0() {
        return null;
    }

    public void N1() {
        this.f82876j.C0();
    }

    public String O0(String str) {
        if (TextUtils.isEmpty(str) || InstructionFileId.DOT.equals(str)) {
            return "";
        }
        if (TextUtils.isEmpty(this.f82871e) || !a1.v().D(this.f82871e).equalsIgnoreCase("usdt")) {
            return LegalCurrencyConfigUtil.A(str, this.f82871e, this.f82880n);
        }
        return LegalCurrencyConfigUtil.B(str);
    }

    public void O1() {
        this.f82876j.D0();
    }

    public void P0() {
        this.f82892z = System.currentTimeMillis();
        if (r.x().F0()) {
            String g02 = a1.v().g0();
            Subscription subscription = this.f82869c;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.f82869c = Observable.zip(AssetDataCacheManager.k0().D0(false, g02).subscribeOn(Schedulers.io()), h2.t1().b1(this.f82880n, AccountType.supermargin.toString()).defaultIfEmpty(null).flatMap(st.h.f29215b), st.j.f29219b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
        }
    }

    public void P1() {
        this.f82876j.D0();
    }

    public final void Q0() {
        if (r.x().F0() && a1.v().r0(this.f82871e)) {
            if (r.x().X()) {
                x7.f.b(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new m());
            } else {
                Observable.zip(UserCenterRemoteDataSource.A().requestLicenseState(LicenseType.PIONEER.toString(), true).subscribeOn(Schedulers.io()), x7.f.b(false).subscribeOn(Schedulers.io()), et.i.f54438b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new n());
            }
        }
    }

    public void Q1(String str, String str2, boolean z11, String str3) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        z0 z0Var = (z0) getUI();
        BigDecimal H2 = this.f82877k.H(this.f82871e, this.f82879m, z11, z11 ? z0Var.getUiPlanTradeBuyMode() : z0Var.getUiPlanTradeSellMode(), i6.m.a(str), i6.m.a(str2));
        boolean z12 = false;
        if (i1()) {
            z12 = i6.m.f0(H2, i6.m.a(TradeMarginHelper.b().a()));
        }
        boolean z13 = z12;
        TradeMarginHelper.b().f(z13);
        OrderMarginParams orderMarginParams = new OrderMarginParams();
        orderMarginParams.f81959a = "";
        orderMarginParams.f81960b = "";
        if (!i1() || !z13) {
            u0(str, str2, z11, str3, z13, "", orderMarginParams);
            return;
        }
        String plainString = H2.subtract(i6.m.a(TradeMarginHelper.b().a())).toPlainString();
        orderMarginParams.f81960b = plainString;
        orderMarginParams.f81959a = plainString;
        if (v.d()) {
            v.k(getActivity(), new o(str, str2, z11, str3, z13, plainString, orderMarginParams), new p());
        } else {
            u0(str, str2, z11, str3, z13, plainString, orderMarginParams);
        }
    }

    public BigDecimal R0(boolean z11, String str) {
        BigDecimal bigDecimal;
        if (!a1.v().S(str) || !z11) {
            if (!h1() || !z11) {
                if (!f1() || !z11) {
                    return this.f82877k.w(this.f82880n, str, z11);
                }
                if (this.B == null) {
                    return BigDecimal.ZERO;
                }
                if (1 == a1() || (3 == a1() && ((z0) getUI()).getUiPlanTradeBuyMode() == 2)) {
                    bigDecimal = i6.m.a(this.B.getRemainingAmount()).multiply(i6.m.a(this.B.getCoefficient())).multiply(i6.m.a(N0()));
                } else {
                    bigDecimal = i6.m.a(this.B.getRemainingAmount()).multiply(i6.m.a(N0()));
                }
                if (i6.m.a(bigDecimal.toPlainString()).compareTo(this.f82877k.w(this.f82880n, str, z11)) < 0) {
                    return bigDecimal;
                }
                return this.f82877k.w(this.f82880n, str, z11);
            } else if (this.A == null) {
                return BigDecimal.ZERO;
            } else {
                BigDecimal w11 = this.f82877k.w(this.f82880n, str, z11);
                BigDecimal a11 = i6.m.a(F0(this.A.getCurrency(), this.A.getRemainingAmount(), a1.v().D(str)));
                if (w11.compareTo(a11) == 1) {
                    return a11;
                }
                return w11;
            }
        } else if (ut.o.C().L() == null) {
            return BigDecimal.ZERO;
        } else {
            if (i6.m.a(ut.o.C().L()).compareTo(this.f82877k.w(this.f82880n, str, z11)) < 0) {
                return i6.m.a(ut.o.C().L());
            }
            return this.f82877k.w(this.f82880n, str, z11);
        }
    }

    public boolean R1() {
        SymbolBean J = a1.v().J(this.f82871e, TradeType.PRO);
        if (r.x().X() || !r.x().F0() || !J.getKycRestrictedCountry()) {
            return false;
        }
        long b11 = y8.c.b();
        Long kycRestrictedTimeRange = J.getKycRestrictedTimeRange();
        if (kycRestrictedTimeRange == null) {
            return false;
        }
        long longValue = (kycRestrictedTimeRange.longValue() + J.getTradeOpenAt()) - b11;
        if (longValue <= 0) {
            return false;
        }
        int i11 = (int) (longValue % 60000);
        if (i11 > 0) {
            i11 = ((int) (longValue / 60000)) + 1;
        }
        ((z0) getUI()).x2(true, true, String.format(getString(R.string.n_exchange_main_partition_limit_hint), new Object[]{String.valueOf(i11)}));
        return true;
    }

    public String S0() {
        return a1.v().D(this.f82871e);
    }

    public final OrderConfirmBean S1(OrderPlaceBean orderPlaceBean) {
        String str;
        OrderConfirmBean orderConfirmBean = new OrderConfirmBean();
        if (orderPlaceBean != null) {
            if (e1()) {
                str = a1.v().E(this.f82871e, Z0());
            } else {
                str = a1.v().o(this.f82871e, Z0());
            }
            String i11 = al.p.i(orderPlaceBean.getMarginAmount(), PrecisionUtil.a(Z0(), str));
            orderConfirmBean.setMarginAmount(i11);
            orderConfirmBean.setDisplaySymbol(a1.v().W(orderPlaceBean.getSymbol()));
            orderConfirmBean.setDisplayAmount(orderPlaceBean.getDisplayAmount());
            orderConfirmBean.setDisplayOrderType(orderPlaceBean.getDisplayOrderType(getActivity().getApplication()));
            orderConfirmBean.setDisplayPrice(orderPlaceBean.getDisplayPrice());
            orderConfirmBean.setDisplayVolume(orderPlaceBean.getVolume());
            orderConfirmBean.setDiaplayTriggerValue(orderPlaceBean.getDisplayStopPrice());
            orderConfirmBean.setDiaplayLoan(i11);
            orderConfirmBean.setAccountId(h2.t1().G1(this.f82880n, AccountType.spot.toString()) + "");
            orderConfirmBean.setBuy(orderPlaceBean.isBuy());
            orderConfirmBean.setAmount(orderPlaceBean.getAmount());
            orderConfirmBean.setLoan(TradeMarginHelper.b().d());
            orderConfirmBean.setMarginAmount(orderPlaceBean.getMarginAmount());
            orderConfirmBean.setSymbol(orderPlaceBean.getSymbol());
            orderConfirmBean.setTradeViewType(orderPlaceBean.getTradeViewType());
            if (orderPlaceBean.getTradeViewType() == 1) {
                orderConfirmBean.setPrice(orderPlaceBean.getNewPrice());
                orderConfirmBean.setOrderType(PrimeRounds.ROUND_TRADE_MARKET_TYPE);
            } else if (orderPlaceBean.getTradeViewType() != 3) {
                orderConfirmBean.setOrderType("limit");
                orderConfirmBean.setPrice(orderPlaceBean.getPrice());
            } else if (this.f82889w == 2) {
                orderConfirmBean.setOrderType(PrimeRounds.ROUND_TRADE_MARKET_TYPE);
                orderConfirmBean.setPrice(orderPlaceBean.getNewPrice());
            } else {
                orderConfirmBean.setOrderType("limit");
                orderConfirmBean.setPrice(orderPlaceBean.getPrice());
            }
        }
        return orderConfirmBean;
    }

    public String T0() {
        return (this.f82875i.B() == null || this.f82875i.B().isEmpty() || !this.f82871e.equals(this.f82875i.B().get(0).o0())) ? "" : String.valueOf(this.f82875i.B().get(0).a());
    }

    public void T1() {
    }

    public final void U0() {
        y8.c.c().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }

    public void U1(BigDecimal bigDecimal, BigDecimal bigDecimal2, boolean z11) {
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        BigDecimal bigDecimal5;
        BigDecimal bigDecimal6;
        TradeType tradeType = this.f82880n;
        BigDecimal bigDecimal7 = null;
        if (tradeType == TradeType.SUPERMARGIN) {
            if (z11) {
                if (((z0) getUI()).S1() == 1) {
                    if (bigDecimal != null) {
                        BigDecimal subtract = bigDecimal.subtract(this.f82877k.F(this.f82880n, this.f82871e, z11, 0));
                        if (subtract.compareTo(BigDecimal.ZERO) < 0) {
                            subtract = BigDecimal.ZERO;
                        }
                        bigDecimal7 = subtract.setScale(PrecisionUtil.k(), 0);
                    }
                    this.f82877k.h0(bigDecimal7);
                } else if (((z0) getUI()).S1() == 2) {
                    MarginLoanAsset A2 = this.f82877k.A(a1.v().n(this.f82871e));
                    if (bigDecimal2 != null) {
                        BigDecimal bigDecimal8 = BigDecimal.ZERO;
                        if (A2 != null) {
                            bigDecimal8 = A2.getLoanAndInterest();
                        }
                        bigDecimal6 = new BigDecimal(String.valueOf(Math.min(bigDecimal2.doubleValue(), bigDecimal8.doubleValue()))).setScale(PrecisionUtil.r(), 1);
                        this.f82877k.i0(bigDecimal8.setScale(PrecisionUtil.r(), 1));
                    } else {
                        bigDecimal6 = null;
                    }
                    this.f82877k.j0(bigDecimal6);
                }
                if (bigDecimal7 == null) {
                    ((z0) getUI()).o6("--", z11);
                } else {
                    ((z0) getUI()).o6(bigDecimal7.toPlainString(), z11);
                }
            } else {
                if (((z0) getUI()).c2() == 1) {
                    if (bigDecimal2 != null) {
                        BigDecimal subtract2 = bigDecimal2.subtract(this.f82877k.F(this.f82880n, this.f82871e, z11, 0));
                        if (subtract2.compareTo(BigDecimal.ZERO) < 0) {
                            subtract2 = BigDecimal.ZERO;
                        }
                        bigDecimal7 = subtract2.setScale(PrecisionUtil.k(), 0);
                    }
                    this.f82877k.n0(bigDecimal7);
                } else if (((z0) getUI()).c2() == 2) {
                    MarginLoanAsset A3 = this.f82877k.A(a1.v().D(this.f82871e));
                    if (bigDecimal != null) {
                        BigDecimal bigDecimal9 = BigDecimal.ZERO;
                        if (A3 != null) {
                            bigDecimal9 = A3.getLoanAndInterest();
                        }
                        bigDecimal5 = new BigDecimal(String.valueOf(Math.min(bigDecimal.doubleValue(), bigDecimal9.doubleValue()))).setScale(PrecisionUtil.r(), 1);
                        this.f82877k.o0(bigDecimal9.setScale(PrecisionUtil.r(), 1));
                    } else {
                        bigDecimal5 = null;
                    }
                    this.f82877k.p0(bigDecimal5);
                }
                if (bigDecimal7 == null) {
                    ((z0) getUI()).o6("--", z11);
                } else {
                    ((z0) getUI()).o6(bigDecimal7.toPlainString(), z11);
                }
            }
        } else if (tradeType != TradeType.MARGIN) {
        } else {
            if (z11) {
                if (((z0) getUI()).S1() == 1) {
                    if (bigDecimal != null) {
                        BigDecimal subtract3 = bigDecimal.subtract(this.f82877k.z(this.f82871e, z11, 0));
                        if (subtract3.compareTo(BigDecimal.ZERO) < 0) {
                            subtract3 = BigDecimal.ZERO;
                        }
                        bigDecimal7 = subtract3.setScale(PrecisionUtil.k(), 0);
                    }
                    this.f82877k.h0(bigDecimal7);
                } else if (((z0) getUI()).S1() == 2) {
                    String n11 = a1.v().n(this.f82871e);
                    MarginBalanceQueryData y12 = h2.t1().y1(this.f82871e);
                    if (bigDecimal2 != null) {
                        BigDecimal bigDecimal10 = BigDecimal.ZERO;
                        if (y12 != null) {
                            bigDecimal10 = y12.getLoanAndInterest(n11);
                        }
                        bigDecimal4 = new BigDecimal(String.valueOf(Math.min(bigDecimal2.doubleValue(), bigDecimal10.doubleValue()))).setScale(PrecisionUtil.r(), 1);
                        this.f82877k.i0(bigDecimal10.setScale(PrecisionUtil.r(), 1));
                    } else {
                        bigDecimal4 = null;
                    }
                    this.f82877k.j0(bigDecimal4);
                }
                if (bigDecimal7 == null) {
                    ((z0) getUI()).o6("--", z11);
                } else {
                    ((z0) getUI()).o6(bigDecimal7.toPlainString(), z11);
                }
            } else {
                if (((z0) getUI()).c2() == 1) {
                    if (bigDecimal2 != null) {
                        BigDecimal subtract4 = bigDecimal2.subtract(this.f82877k.z(this.f82871e, z11, 0));
                        if (subtract4.compareTo(BigDecimal.ZERO) < 0) {
                            subtract4 = BigDecimal.ZERO;
                        }
                        bigDecimal7 = subtract4.setScale(PrecisionUtil.k(), 0);
                    }
                    this.f82877k.n0(bigDecimal7);
                } else if (((z0) getUI()).c2() == 2) {
                    String D2 = a1.v().D(this.f82871e);
                    MarginBalanceQueryData y13 = h2.t1().y1(this.f82871e);
                    if (bigDecimal != null) {
                        BigDecimal bigDecimal11 = BigDecimal.ZERO;
                        if (y13 != null) {
                            bigDecimal11 = y13.getLoanAndInterest(D2);
                        }
                        bigDecimal3 = new BigDecimal(String.valueOf(Math.min(bigDecimal.doubleValue(), bigDecimal11.doubleValue()))).setScale(PrecisionUtil.r(), 1);
                        this.f82877k.o0(bigDecimal11.setScale(PrecisionUtil.r(), 1));
                    } else {
                        bigDecimal3 = null;
                    }
                    this.f82877k.p0(bigDecimal3);
                }
                if (bigDecimal7 == null) {
                    ((z0) getUI()).o6("--", z11);
                } else {
                    ((z0) getUI()).o6(bigDecimal7.toPlainString(), z11);
                }
            }
        }
    }

    public void V0() {
        UserCenterRemoteDataSource.A().requestLicenseState("SPOT_CROSS_MARGIN", false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new a());
    }

    public void V1() {
    }

    public final void W0() {
        if (r.x().F0() && a1.v().p0(this.f82871e)) {
            BizRecordProvider.d(4).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new j());
        }
    }

    public void W1() {
    }

    public z X0() {
        return this.f82877k;
    }

    public void X1() {
        if (r.x().F0()) {
            this.f82876j.z0(true, this.f82880n, this.f82871e, this.f82888v, this.f82887u);
            if (this.f82888v == 2) {
                L1();
                return;
            }
            return;
        }
        this.f82876j.x0(this.f82871e, this.f82888v, this.f82889w);
        ((z0) getUI()).d3(8);
        this.f82877k.r();
    }

    public void Y0() {
        qt.b0.d().e().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new h());
    }

    public void Y1() {
    }

    public void Z(boolean z11) {
        super.Z(z11);
        c2(z11);
    }

    public TradeType Z0() {
        return this.f82880n;
    }

    public abstract void Z1();

    public void a() {
        if (this.f82888v != 1) {
            return;
        }
        if (this.f82876j.P()) {
            ((z0) getUI()).d3(8);
        } else {
            ((z0) getUI()).d3(0);
        }
    }

    public int a1() {
        return this.f82879m;
    }

    public abstract void a2();

    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        if (((z0) getUI()).isCanBeSeen()) {
            this.f82875i.V(this.f82871e, false);
            ((z0) getUI()).w3();
            ((z0) getUI()).F(this.f82879m, true);
            this.f82880n = symbolChangeEvent.e();
            d1();
            if (a1.v().s0(this.f82871e)) {
                ((z0) getUI()).me(8);
                this.f82887u = 0;
                ((z0) getUI()).B2(R.id.open_order_rb);
            } else {
                ((z0) getUI()).me(0);
            }
            ((z0) getUI()).l1();
            ((z0) getUI()).O2(0, 0);
            C0(0, true);
            ((z0) getUI()).E3(a1.v().S(this.f82871e));
            ((z0) getUI()).d2(PrecisionUtil.e(this.f82871e));
            ((z0) getUI()).ca(PrecisionUtil.C(this.f82871e));
            c1(false, this.f82871e, true);
            X1();
            this.f82876j.D0();
            b2();
            ((z0) getUI()).O1(this.f82871e, this.f82880n);
            ((z0) getUI()).E2();
            if (this.f82874h) {
                this.f82875i.M(this.f82871e, this.f82880n);
                this.f82878l.e(this.f82871e);
                b1();
                this.f82881o = false;
                this.f82882p = false;
                this.f82883q = false;
            }
            if (!TextUtils.isEmpty(this.f82871e)) {
                z1(true);
            }
            Q0();
            L0();
            R1();
            ((z0) getUI()).db(true);
        }
    }

    public final void b1() {
        LegalCurrencyConfigUtil.e().flatMap(st.i.f29217b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new l());
    }

    public void b2() {
        if (h1()) {
            ((z0) getUI()).o3(0, 5);
        } else if (a1.v().r0(this.f82871e)) {
            ((z0) getUI()).o3(0, 6);
        } else if (a1.v().p0(this.f82871e)) {
            ((z0) getUI()).o3(0, 4);
        } else if (a1.v().M(this.f82871e)) {
            ((z0) getUI()).o3(0, 0);
        } else if (a1.v().T(this.f82871e)) {
            ((z0) getUI()).o3(0, 1);
        } else if (a1.v().N(this.f82871e)) {
            ((z0) getUI()).o3(0, 2);
        } else {
            ((z0) getUI()).o3(8, 3);
        }
    }

    public abstract void c1(boolean z11, String str, boolean z12);

    public void c2(boolean z11) {
        if (Q().getActivity() != null) {
            this.f82874h = z11;
            if (z11) {
                this.f82880n = TradeType.valueOf(Q().getArguments().getString("key_trade_type", TradeType.PRO.name()));
                i6.d.b(this.f82880n + "======" + qt.i.b(this.f82880n));
                Q().getArguments();
                if (qt.i.b(this.f82880n)) {
                    i6.d.b(this.f82880n + "======" + qt.i.a(this.f82880n));
                    boolean a11 = qt.i.a(this.f82880n);
                    this.C = a11;
                    this.G.b(Boolean.valueOf(a11));
                    qt.i.c(this.f82880n);
                    ((z0) getUI()).B(qt.i.a(this.f82880n) ^ true ? 1 : 0);
                }
                d1();
                if (this.f82886t) {
                    String d11 = i2.a().d(this.f82880n);
                    if (h1() && this.f82879m == 3) {
                        this.f82879m = 0;
                    }
                    z0();
                    if (!a1.v().S(d11)) {
                        C0(this.f82879m, false);
                    }
                }
                v0();
                return;
            }
            t0();
        }
    }

    public /* bridge */ /* synthetic */ u6.g d() {
        return (u6.g) super.getUI();
    }

    public final void d1() {
        String d11 = i2.a().d(this.f82880n);
        if (!TextUtils.isEmpty(d11)) {
            this.f82871e = d11;
            SymbolBean J = a1.v().J(this.f82871e, this.f82880n);
            this.f82870d = J.getSymbolName();
            this.f82872f = J.getBaseCurrency();
            this.f82873g = J.getBaseCurrencyDisplayName();
            J1();
        } else {
            List<SymbolBean> Z = a1.v().Z(this.f82880n);
            if (Z != null && !Z.isEmpty()) {
                SymbolBean symbolBean = Z.get(0);
                this.f82871e = symbolBean.getSymbol();
                this.f82870d = symbolBean.getSymbolName();
                this.f82872f = symbolBean.getBaseCurrency();
                this.f82873g = symbolBean.getBaseCurrencyDisplayName();
                J1();
                i2.a().h(this.f82880n, this.f82871e);
            }
        }
        ut.o.C().z0(this.f82871e);
    }

    public int e() {
        return this.f82887u;
    }

    public boolean e1() {
        return this.C;
    }

    public boolean f1() {
        return a1.v().p0(this.f82871e);
    }

    public int g() {
        return this.f82888v;
    }

    public boolean g1() {
        return this.f82881o;
    }

    public boolean h1() {
        return a1.v().q0(this.f82871e, this.f82880n);
    }

    public boolean i1() {
        return this.E;
    }

    public String o0() {
        return this.f82871e;
    }

    public void onChangeMarginEvent(nt.a aVar) {
        z0 z0Var = (z0) getUI();
        throw null;
    }

    public void onDestroy() {
        super.onDestroy();
        this.G.a();
        this.H.a();
    }

    public void onErrorCodeEvent(mo.a aVar) {
        if (((z0) getUI()).isCanBeSeen()) {
            ((z0) getUI()).F(this.f82879m, true);
            this.f82877k.t();
            ((z0) getUI()).d(false);
            this.f82876j.x0(this.f82871e, this.f82888v, this.f82887u);
            ((z0) getUI()).d3(8);
            AutoLoanSelectDialog autoLoanSelectDialog = this.f82890x;
            if (autoLoanSelectDialog != null) {
                autoLoanSelectDialog.dismiss();
            }
            K1();
        }
    }

    public void onPause() {
        super.onPause();
        this.f82876j.C0();
        this.f82876j.D0();
        this.f82876j.B0();
    }

    public boolean r() {
        return this.C;
    }

    public void r1() {
        d1 d1Var = this.f82876j;
        if (d1Var != null) {
            d1Var.r0();
        }
    }

    public void s1() {
        A1();
        ut.o.C().v0("");
        X1();
        if (r.x().F0()) {
            c1(false, o0(), true);
        }
        b1();
        w1();
        ((z0) getUI()).y0(true);
        if (!TextUtils.isEmpty(this.f82871e)) {
            z1(false);
        }
        U0();
    }

    public void t0() {
        this.f82884r = false;
        this.f82875i.V(this.f82871e, false);
        this.f82878l.h(this.f82871e);
        this.f82876j.C0();
        this.f82876j.D0();
        this.f82876j.B0();
        ((z0) getUI()).D2();
        ((z0) getUI()).w3();
        ut.o.C().C0();
        ((z0) getUI()).R1(true, e1());
        Subscription subscription = this.f82869c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.f82891y;
        if (subscription2 != null) {
            subscription2.unsubscribe();
            this.f82891y = null;
        }
    }

    public void t1() {
        is.a.j("4247", (Map<String, Object>) null, "1000048");
    }

    public final void u0(String str, String str2, boolean z11, String str3, boolean z12, String str4, OrderMarginParams orderMarginParams) {
        int i11;
        boolean z13;
        boolean z14 = z11;
        if (!a1.v().p0(this.f82871e) || !ClearDialogConfigController.i(2)) {
            SymbolBean J = a1.v().J(this.f82871e, this.f82880n);
            if (!TextUtils.isEmpty(J.getSuperMarginLeverageRatio()) && this.f82880n == TradeType.SUPERMARGIN && ClearDialogConfigController.i(3)) {
                ClearDialogConfig d11 = ClearDialogConfigController.d(3);
                ((z0) getUI()).K2(d11.getRulesUrl(), d11.getTips(), 3);
            } else if (TextUtils.isEmpty(J.getLeverageRatio()) || this.f82880n != TradeType.MARGIN || !ClearDialogConfigController.i(5)) {
                if (a1.v().S(this.f82871e)) {
                    if (ut.o.C().G() != null && ut.o.C().G().getStatus() == 1) {
                        HuobiToastUtil.j(R.string.prime_trade_not_ready);
                        return;
                    } else if (ut.o.C().E() == null) {
                        HuobiToastUtil.j(R.string.network_busy);
                        return;
                    }
                }
                if (!R1()) {
                    BigDecimal valueOf = BigDecimal.valueOf(this.f82875i.z());
                    z0 z0Var = (z0) getUI();
                    int uiPlanTradeBuyMode = z14 ? z0Var.getUiPlanTradeBuyMode() : z0Var.getUiPlanTradeSellMode();
                    if (z14) {
                        i11 = ((z0) getUI()).S1();
                    } else {
                        i11 = ((z0) getUI()).c2();
                    }
                    int i12 = i11;
                    String str5 = str2;
                    boolean z15 = z11;
                    boolean Z = this.f82877k.Z(this.f82880n, o0(), this.f82879m, str, str5, z15, valueOf, this.f82884r, str3, ut.o.C().L(), i12, uiPlanTradeBuyMode, z12);
                    if (!this.f82877k.J(this.f82880n, o0(), this.f82879m, str, str5, z15, this.f82884r, ut.o.C().L(), i12, uiPlanTradeBuyMode, z12) && !Z) {
                        v7.b.a().getBalanceProfitLoss().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new st.c(this)));
                    }
                    if (Z && h1() && !qt.g.a().d()) {
                        ((z0) getUI()).L2();
                    } else if (Z) {
                        OrderPlaceBean a02 = this.f82877k.a0(this.f82880n, this.f82871e, this.f82879m, str, str2, z11, str3, valueOf, i12, str4, orderMarginParams);
                        SymbolBean J2 = a1.v().J(a02.getSymbol(), this.f82880n);
                        if (TradeMarginHelper.b().d()) {
                            z13 = v.i();
                        } else {
                            z13 = v.h();
                        }
                        if (J2 == null || !z13) {
                            ut.o.C().x0(a02);
                            H0(z11, a02);
                            return;
                        }
                        OrderConfirmBean S1 = S1(a02);
                        if (J2.isCallAuctionOne()) {
                            S1.setCallActionPhase(1);
                        } else if (J2.isCallAuctionTwo()) {
                            S1.setCallActionPhase(2);
                        }
                        v.j(Q().getParentFragmentManager(), S1, new b(a02, z11));
                    }
                }
            } else {
                ClearDialogConfig d12 = ClearDialogConfigController.d(5);
                ((z0) getUI()).K2(d12.getRulesUrl(), d12.getTips(), 5);
            }
        } else {
            ClearDialogConfig d13 = ClearDialogConfigController.d(2);
            ((z0) getUI()).K2(d13.getRulesUrl(), d13.getTips(), 2);
        }
    }

    /* renamed from: u1 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, V v11) {
        super.onUIReady(baseCoreActivity, v11);
        d1 d1Var = new d1(this, false, true);
        this.f82876j = d1Var;
        d1Var.s0(this);
        this.f82880n = TradeType.valueOf(Q().getArguments().getString("key_trade_type", TradeType.PRO.name()));
        ((z0) getUI()).b(this.f82876j.M());
        this.f82877k = new z((z0) getUI());
        this.f82875i = new rt.i((i.d) getUI(), this.f82876j, this.f82880n, getActivity());
        this.f82878l = new b0(this.f82880n, (b0.c) getUI(), getActivity());
        ((z0) getUI()).y2();
        C0(0, false);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void updateAssetAndOrder(AssetAndOrderUpdateEvent assetAndOrderUpdateEvent) {
        if (((z0) getUI()).isCanBeSeen()) {
            Z1();
            this.f82876j.A0(true, this.f82880n, this.f82871e, this.f82888v, this.f82887u);
            int i11 = this.f82888v;
            if (i11 == 2) {
                this.f82876j.y0(this.f82880n, this.f82871e, i11, this.f82889w);
            }
            i6.i.b().g(new i(), 500);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void updateColorSeekBarPosition(at.b bVar) {
        ((z0) getUI()).Nd(bVar.a());
    }

    public void v0() {
        this.f82881o = false;
        this.f82882p = false;
        this.f82883q = false;
        boolean F0 = r.x().F0();
        ((z0) getUI()).F(this.f82879m, true);
        ((z0) getUI()).d(F0);
        if (a1.v().s0(this.f82871e)) {
            ((z0) getUI()).me(8);
            this.f82887u = 0;
            ((z0) getUI()).B2(R.id.open_order_rb);
        } else {
            ((z0) getUI()).me(0);
        }
        ((z0) getUI()).l1();
        ((z0) getUI()).E3(a1.v().S(this.f82871e));
        ((z0) getUI()).d2(PrecisionUtil.e(this.f82871e));
        ((z0) getUI()).ca(PrecisionUtil.C(this.f82871e));
        B0(F0, e1());
        X1();
        W0();
        L0();
        b1();
        this.f82875i.M(this.f82871e, this.f82880n);
        this.f82878l.e(this.f82871e);
        ((z0) getUI()).O1(this.f82871e, this.f82880n);
        b2();
        ((z0) getUI()).U2();
        ((z0) getUI()).t5();
        Y0();
        ut.o.C().y();
        r.x().B0(false, (u6.g) null);
        this.f82886t = true;
        ((z0) getUI()).O2(0, 0);
        ad.o.e().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseEasySubscriber());
        if (!TextUtils.isEmpty(this.f82871e)) {
            z1(true);
        }
        Q0();
        ((z0) getUI()).l1();
        ((z0) getUI()).J2();
        U0();
    }

    public void v1(Map<String, String> map, OrderPlaceBean orderPlaceBean) {
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
        this.f82877k.e0(this.f82880n, orderPlaceBean);
    }

    public void w0() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", LicenseType.PIONEER.type);
        UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap).compose(tq.p.c0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g());
    }

    public abstract void w1();

    public void x0() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "POTENTIALS");
        UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap).compose(tq.p.c0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new SilentSubscriber());
    }

    public void x1() {
        a1.v().Y(false, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create((Action0) null, new st.f(this), new st.d(this), new st.e(this), (Action0) null));
    }

    public void y0() {
        String str;
        Observable<Long> observable;
        String str2 = y.b() ? this.f82871e : "";
        TradeType tradeType = TradeType.PRO;
        TradeType tradeType2 = this.f82880n;
        if (tradeType == tradeType2) {
            str = AccountType.spot.toString();
        } else if (TradeType.MARGIN == tradeType2) {
            str = AccountType.margin.toString();
        } else if (TradeType.C2C == tradeType2) {
            str = AccountType.borrow.toString();
        } else {
            str = AccountType.supermargin.toString();
        }
        TradeType tradeType3 = TradeType.C2C;
        TradeType tradeType4 = this.f82880n;
        if (tradeType3 == tradeType4 || TradeType.MARGIN == tradeType4) {
            observable = h2.t1().D1(str, str2);
        } else {
            observable = h2.t1().b1(this.f82880n, str);
        }
        observable.flatMap(new st.g(this, str2)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e());
    }

    public void y1() {
        this.f82875i.P(this.f82871e);
        this.f82878l.e(this.f82871e);
    }

    public void z0() {
        SymbolBean J = a1.v().J(this.f82871e, this.f82880n);
        if (J != null && J.isCallAuction()) {
            this.f82879m = 0;
        }
    }

    public final void z1(boolean z11) {
        ExchangeSettingsController.d().c(z11, this.f82871e).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }
}
