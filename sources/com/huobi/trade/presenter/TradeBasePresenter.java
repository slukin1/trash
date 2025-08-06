package com.huobi.trade.presenter;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import cn.sharesdk.framework.InnerShareParams;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.BaseApplication;
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
import com.hbg.lib.network.hbg.core.bean.PioneerActivityLimit;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.hbg.core.bean.RemainingAmountBean;
import com.hbg.lib.network.hbg.record.BizRecordProvider;
import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.hbg.lib.network.pro.core.bean.CancelOpenOrdersResult;
import com.hbg.lib.network.pro.core.bean.PlanCancelOpenOrdersResult;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.pro.core.bean.SpotTimeSharingGlobalConfig;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.uc.core.utils.LicenseType;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.AccountType;
import com.huobi.account.event.LogOutEvent;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.index.bean.IndexFeature;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.supermargin.bean.MarginLoanAsset;
import com.huobi.trade.bean.AssetAndOrderUpdateEvent;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.trade.bean.TradeHoldBean;
import com.huobi.trade.helper.TradeLimitHelper;
import com.huobi.trade.helper.c0;
import com.huobi.trade.helper.z;
import com.huobi.trade.prime.bean.AliToken;
import com.huobi.trade.prime.bean.TradeOrderNum;
import com.huobi.trade.ui.h1;
import com.huobi.trade.ui.y3;
import d7.a1;
import dt.a5;
import dt.d3;
import dt.e3;
import dt.h2;
import dt.i2;
import dt.r2;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k6.c;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import qk.v0;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import tg.r;
import tq.p;

public abstract class TradeBasePresenter<V extends h1> extends BaseFragmentPresenter<V> implements a5.l, a5.m {
    public RemainingAmountBean A;
    public boolean B = true;
    public int C = -1;
    public final List<TradeHoldBean> D = new ArrayList();
    public boolean E;
    public TradeOrderNum F = new TradeOrderNum();

    /* renamed from: c  reason: collision with root package name */
    public Subscription f82092c;

    /* renamed from: d  reason: collision with root package name */
    public String f82093d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f82094e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f82095f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f82096g = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f82097h;

    /* renamed from: i  reason: collision with root package name */
    public r2 f82098i;

    /* renamed from: j  reason: collision with root package name */
    public a5 f82099j;

    /* renamed from: k  reason: collision with root package name */
    public d3 f82100k;

    /* renamed from: l  reason: collision with root package name */
    public e3 f82101l;

    /* renamed from: m  reason: collision with root package name */
    public HBDialogFragment f82102m;

    /* renamed from: n  reason: collision with root package name */
    public int f82103n = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f82104o = Integer.MIN_VALUE;

    /* renamed from: p  reason: collision with root package name */
    public TradeType f82105p = TradeType.PRO;

    /* renamed from: q  reason: collision with root package name */
    public boolean f82106q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f82107r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f82108s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f82109t;

    /* renamed from: u  reason: collision with root package name */
    public String f82110u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f82111v;

    /* renamed from: w  reason: collision with root package name */
    public int f82112w = 0;

    /* renamed from: x  reason: collision with root package name */
    public int f82113x = 0;

    /* renamed from: y  reason: collision with root package name */
    public int f82114y;

    /* renamed from: z  reason: collision with root package name */
    public Subscription f82115z;

    public class a implements TradeLimitHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrderPlaceBean f82116a;

        public a(OrderPlaceBean orderPlaceBean) {
            this.f82116a = orderPlaceBean;
        }

        public void a(boolean z11) {
            if (z11) {
                TradeBasePresenter tradeBasePresenter = TradeBasePresenter.this;
                tradeBasePresenter.f82100k.b0(tradeBasePresenter.f82105p, this.f82116a, tradeBasePresenter.getActivity());
            }
        }
    }

    public class b implements TradeLimitHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OrderPlaceBean f82118a;

        public b(OrderPlaceBean orderPlaceBean) {
            this.f82118a = orderPlaceBean;
        }

        public void a(boolean z11) {
            if (z11) {
                TradeBasePresenter tradeBasePresenter = TradeBasePresenter.this;
                tradeBasePresenter.f82100k.t0(tradeBasePresenter.f82105p, this.f82118a, tradeBasePresenter.getActivity());
            }
        }
    }

    public class c extends EasySubscriber<PlanCancelOpenOrdersResult> {
        public c() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            TradeBasePresenter.this.updateAssetAndOrder(new AssetAndOrderUpdateEvent());
        }

        /* renamed from: c */
        public void onNext(PlanCancelOpenOrdersResult planCancelOpenOrdersResult) {
            super.onNext(planCancelOpenOrdersResult);
            if (planCancelOpenOrdersResult.getNextId() < 0) {
                HuobiToastUtil.s(R.string.n_order_cancel_success_toast);
            } else if (planCancelOpenOrdersResult.getFailed() == 0 && planCancelOpenOrdersResult.getNextId() > 0) {
                HuobiToastUtil.j(R.string.n_order_cancel_more_toast);
            } else if (planCancelOpenOrdersResult.getFailed() > 0) {
                String valueOf = String.valueOf(planCancelOpenOrdersResult.getFailed());
                HuobiToastUtil.m(String.format(Locale.US, TradeBasePresenter.this.getString(R.string.n_order_cancel_part_failed_toast), new Object[]{valueOf}));
            }
        }

        public void onAfter() {
            super.onAfter();
            ((h1) TradeBasePresenter.this.getUI()).dismissProgressDialog();
            i6.i.b().g(new et.k(this), 500);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                HuobiToastUtil.l(BaseApplication.b(), aPIStatusErrorException.getErrMsg());
            } else {
                HuobiToastUtil.j(R.string.n_order_cancel_failed_toast);
            }
        }

        public void onStart() {
            super.onStart();
            ((h1) TradeBasePresenter.this.getUI()).showProgressDialog();
        }
    }

    public class d extends EasySubscriber<CancelOpenOrdersResult> {
        public d() {
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
            ((h1) TradeBasePresenter.this.getUI()).dismissProgressDialog();
            i6.i.b().g(new et.l(this), 500);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            HuobiToastUtil.j(R.string.n_order_cancel_failed_toast);
        }

        public void onStart() {
            super.onStart();
            ((h1) TradeBasePresenter.this.getUI()).showProgressDialog();
        }
    }

    public class e extends EasySubscriber<SpotTimeSharingGlobalConfig> {
        public e() {
        }

        /* renamed from: a */
        public void onNext(SpotTimeSharingGlobalConfig spotTimeSharingGlobalConfig) {
            super.onNext(spotTimeSharingGlobalConfig);
            v0.b().d(spotTimeSharingGlobalConfig);
            v0.b().e(true);
            ((h1) TradeBasePresenter.this.getUI()).id();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
    }

    public class f extends BaseSubscriber<Object> {
        public f() {
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            if (x7.f.d(a1.v().n(TradeBasePresenter.this.f82094e)) || x7.f.d(a1.v().D(TradeBasePresenter.this.f82094e))) {
                ((h1) TradeBasePresenter.this.getUI()).x2(false, false, "");
            }
        }
    }

    public class g extends BaseSubscriber<IndexFeature> {
        public g() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(IndexFeature indexFeature) {
            ((h1) TradeBasePresenter.this.getUI()).L1(indexFeature);
        }

        /* renamed from: c */
        public void onNext(IndexFeature indexFeature) {
            super.onNext(indexFeature);
            i6.i.b().g(new et.j(this, indexFeature), 300);
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ((h1) TradeBasePresenter.this.getUI()).L1(c0.d().c());
        }

        public void onStart() {
            super.onStart();
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            if (((h1) TradeBasePresenter.this.getUI()).isCanBeSeen()) {
                TradeBasePresenter tradeBasePresenter = TradeBasePresenter.this;
                tradeBasePresenter.Y0(false, tradeBasePresenter.o0(), true);
                TradeBasePresenter.this.t1();
            }
        }
    }

    public class i implements Observer<TradeOrderNum> {
        public i() {
        }

        /* renamed from: a */
        public void onNext(TradeOrderNum tradeOrderNum) {
            if (tradeOrderNum != null) {
                ((h1) TradeBasePresenter.this.getUI()).Ab(tradeOrderNum);
            }
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
        }
    }

    public class j extends BaseSubscriber<BizTipRecord> {
        public j() {
        }

        /* renamed from: a */
        public void onNext(BizTipRecord bizTipRecord) {
            super.onNext(bizTipRecord);
            if (!BizRecordProvider.e()) {
                ((h1) TradeBasePresenter.this.getUI()).F2();
            }
        }
    }

    public class k extends BaseSubscriber<ClearDialogConfig> {
        public k() {
        }

        /* renamed from: a */
        public void onNext(ClearDialogConfig clearDialogConfig) {
            super.onNext(clearDialogConfig);
            if (ClearDialogConfigController.h(TradeBasePresenter.this.C)) {
                ((h1) TradeBasePresenter.this.getUI()).K2(clearDialogConfig.getRulesUrl(), clearDialogConfig.getTips(), TradeBasePresenter.this.C);
            }
        }
    }

    public class l extends BaseSubscriber<List<LegalRateBean>> {
        public l() {
        }

        public void onNext(List<LegalRateBean> list) {
            if (((h1) TradeBasePresenter.this.getUI()).isCanBeSeen()) {
                MarketCurrentPriceItem v11 = TradeBasePresenter.this.f82098i.v();
                if (v11 != null) {
                    v11.p(TradeBasePresenter.this.f82098i.B());
                    ((h1) TradeBasePresenter.this.getUI()).H0(v11);
                    ((h1) TradeBasePresenter.this.getUI()).h2();
                }
                ((h1) TradeBasePresenter.this.getUI()).l2(String.valueOf(TradeBasePresenter.this.I0().B()));
                if (com.hbg.lib.core.util.b.c().f()) {
                    ((h1) TradeBasePresenter.this.getUI()).n1(false);
                    return;
                }
                ((h1) TradeBasePresenter.this.getUI()).n1(true);
                ((h1) TradeBasePresenter.this.getUI()).n1(false);
            }
        }
    }

    public class m extends BaseSubscriber<List<PioneerActivityLimit>> {
        public m() {
        }

        public void onNext(List<PioneerActivityLimit> list) {
            super.onNext(list);
            if (x7.f.c(a1.v().n(TradeBasePresenter.this.f82094e)) || x7.f.c(a1.v().D(TradeBasePresenter.this.f82094e))) {
                ((h1) TradeBasePresenter.this.getUI()).k3();
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
            if (x7.f.c(a1.v().n(TradeBasePresenter.this.f82094e)) || x7.f.c(a1.v().D(TradeBasePresenter.this.f82094e))) {
                ((h1) TradeBasePresenter.this.getUI()).k3();
            } else if ("0".equals(tradeRiskReminder.getState())) {
                ((h1) TradeBasePresenter.this.getUI()).N1();
            } else if (x7.f.d(a1.v().n(TradeBasePresenter.this.f82094e)) || x7.f.d(a1.v().D(TradeBasePresenter.this.f82094e))) {
                ((h1) TradeBasePresenter.this.getUI()).x2(true, false, "");
            }
        }
    }

    public class o extends EasySubscriber<AliToken> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OrderPlaceBean f82132b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f82133c;

        public o(OrderPlaceBean orderPlaceBean, boolean z11) {
            this.f82132b = orderPlaceBean;
            this.f82133c = z11;
        }

        /* renamed from: a */
        public void onNext(AliToken aliToken) {
            super.onNext(aliToken);
            ((h1) TradeBasePresenter.this.getUI()).j3(this.f82132b, aliToken);
        }

        public void onAfter() {
            super.onAfter();
            ((h1) TradeBasePresenter.this.getUI()).dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((h1) TradeBasePresenter.this.getUI()).R1(true, this.f82133c);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            if ("10008".equals(aPIStatusErrorException.getErrCode())) {
                ht.o.B().q0(aPIStatusErrorException.getErrCode());
            }
            if ("12000".equals(aPIStatusErrorException.getErrCode())) {
                this.f82132b.setVerifyAliToken(false);
                TradeBasePresenter tradeBasePresenter = TradeBasePresenter.this;
                tradeBasePresenter.f82100k.b0(tradeBasePresenter.f82105p, this.f82132b, tradeBasePresenter.getActivity());
            } else {
                super.onFailed(aPIStatusErrorException);
            }
            ((h1) TradeBasePresenter.this.getUI()).R1(true, this.f82133c);
        }

        public void onStart() {
            super.onStart();
            ((h1) TradeBasePresenter.this.getUI()).showProgressDialog();
            this.f82132b.setVerifyAliToken(true);
            ((h1) TradeBasePresenter.this.getUI()).R1(false, this.f82133c);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable e1(String str, Long l11) {
        int i11 = this.f82112w;
        return x8.a.a().B(l11, str, i11 == 1 ? "buy-stop-limit,buy-stop-limit-fok,sell-stop-limit,sell-stop-limit-fok" : i11 == 0 ? "buy-market,buy-limit,buy-ioc,buy-limit-maker,buy-limit-fok,sell-market,sell-limit,sell-ioc,sell-limit-maker,sell-limit-fok" : "", (String) null, -1).b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g1(List list) {
        List<String> H = a1.v().H(this.f82105p);
        if (!H.isEmpty() && !H.contains(this.f82094e)) {
            this.f82094e = H.get(0);
        }
        ((h1) getUI()).finishRefresh();
        if (!a1.v().L(this.f82094e)) {
            C0(this.f82094e);
        } else if (!a1.v().S(this.f82094e)) {
            C0(this.f82094e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h1(APIStatusErrorException aPIStatusErrorException) {
        ((h1) getUI()).finishRefresh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i1(Throwable th2) {
        ((h1) getUI()).finishRefresh();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j1(BalanceProfitLossData balanceProfitLossData) {
        ((h1) getUI()).f3(i6.m.a(balanceProfitLossData.getTotalBalance()).compareTo(BigDecimal.ZERO) <= 0);
    }

    public abstract void A0();

    public void A1(int i11) {
        this.f82104o = i11;
    }

    public String B0(String str, String str2, String str3) {
        return LegalCurrencyConfigUtil.o(str, str2, str3, V0());
    }

    public void B1(int i11) {
        this.f82113x = i11;
    }

    public void C0(String str) {
        SymbolChangeEvent symbolChangeEvent = new SymbolChangeEvent();
        symbolChangeEvent.g(str);
        symbolChangeEvent.i(str);
        symbolChangeEvent.j(this.f82105p);
        symbolChangeEvent.h(true);
        afterSymbolIdChanged(symbolChangeEvent);
    }

    public void C1() {
        ((h1) getUI()).X1(d1());
    }

    public String D0() {
        return this.f82095f;
    }

    public void D1() {
        m1();
        sn.f.f(this.f82105p, getActivity());
    }

    public String E0() {
        return this.f82096g;
    }

    public void E1() {
        this.f82099j.D1(this.f82105p, this.f82094e, this.f82113x, this.f82112w);
    }

    public String F0() {
        return (this.f82098i.C() == null || this.f82098i.C().isEmpty() || !this.f82094e.equals(this.f82098i.C().get(0).o0())) ? "" : String.valueOf(this.f82098i.C().get(0).a());
    }

    public void F1() {
        this.f82099j.E1(this.f82105p, this.f82094e, this.f82113x, this.f82112w);
    }

    public BigDecimal G0() {
        return this.f82100k.v();
    }

    public void G1() {
        this.f82099j.G1(this.f82105p, this.f82094e, this.f82113x, this.f82112w);
    }

    public final void H0() {
        SymbolBean J;
        this.C = -1;
        if (r.x().F0() && (J = a1.v().J(this.f82094e, this.f82105p)) != null) {
            if (J.isEtpTag()) {
                this.C = 2;
            }
            if (!TextUtils.isEmpty(J.getSuperMarginLeverageRatio()) && this.f82105p == TradeType.SUPERMARGIN) {
                this.C = 3;
            }
            if (!TextUtils.isEmpty(J.getSuperMarginLeverageRatio()) && this.f82105p == TradeType.MARGIN) {
                this.C = 5;
            }
            int i11 = this.C;
            if (i11 != -1) {
                ClearDialogConfigController.c(i11, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new k());
            }
        }
    }

    public void H1() {
        this.f82099j.I1(this.f82105p, this.f82094e, this.f82113x, this.f82112w);
    }

    public r2 I0() {
        return this.f82098i;
    }

    public final void I1() {
        x8.a.a().getTimeSharingGlobalConfigInfo().b().retry(3).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e());
    }

    public String J0(String str) {
        if (TextUtils.isEmpty(str) || InstructionFileId.DOT.equals(str)) {
            return "";
        }
        if (TextUtils.isEmpty(this.f82094e) || !a1.v().D(this.f82094e).equalsIgnoreCase("usdt")) {
            return LegalCurrencyConfigUtil.A(str, this.f82094e, this.f82105p);
        }
        return LegalCurrencyConfigUtil.B(str);
    }

    public void J1() {
        this.f82099j.J1();
    }

    public int K0() {
        return this.f82104o;
    }

    public void K1() {
        this.f82099j.K1();
    }

    public final void L0() {
        if (r.x().F0() && a1.v().r0(this.f82094e)) {
            if (r.x().X()) {
                x7.f.b(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new m());
            } else {
                Observable.zip(UserCenterRemoteDataSource.A().requestLicenseState(LicenseType.PIONEER.toString(), true).subscribeOn(Schedulers.io()), x7.f.b(false).subscribeOn(Schedulers.io()), et.i.f54438b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new n());
            }
        }
    }

    public void L1() {
        this.f82099j.L1();
    }

    public BigDecimal M0(boolean z11, String str) {
        if (!a1.v().S(str) || !z11) {
            if (!d1() || !z11) {
                return this.f82100k.x(this.f82105p, str, z11);
            }
            if (this.A == null) {
                return BigDecimal.ZERO;
            }
            BigDecimal x11 = this.f82100k.x(this.f82105p, str, z11);
            BigDecimal a11 = i6.m.a(B0(this.A.getCurrency(), this.A.getRemainingAmount(), a1.v().D(str)));
            if (x11.compareTo(a11) == 1) {
                return a11;
            }
            return x11;
        } else if (ht.o.B().K() == null) {
            return BigDecimal.ZERO;
        } else {
            if (i6.m.a(ht.o.B().K()).compareTo(this.f82100k.x(this.f82105p, str, z11)) < 0) {
                return i6.m.a(ht.o.B().K());
            }
            return this.f82100k.x(this.f82105p, str, z11);
        }
    }

    public void M1() {
        this.f82099j.M1();
    }

    public String N0() {
        return a1.v().D(this.f82094e);
    }

    public void N1() {
        this.f82099j.N1();
    }

    public String O0() {
        return (this.f82098i.D() == null || this.f82098i.D().isEmpty() || !this.f82094e.equals(this.f82098i.D().get(0).o0())) ? "" : String.valueOf(this.f82098i.D().get(0).a());
    }

    public void O1() {
        this.f82099j.N1();
    }

    public BigDecimal P0() {
        return this.f82100k.D();
    }

    public void P1() {
        this.f82099j.O1();
    }

    public final void Q0() {
        y8.c.c().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }

    public void Q1(String str, String str2, String str3, boolean z11, String str4, CouponReturn couponReturn, double d11, List<? extends c.a> list) {
        int i11;
        String str5;
        double d12;
        double d13;
        String str6;
        boolean z12 = z11;
        if (!a1.v().p0(this.f82094e) || !ClearDialogConfigController.i(2)) {
            SymbolBean J = a1.v().J(this.f82094e, this.f82105p);
            if (!TextUtils.isEmpty(J.getSuperMarginLeverageRatio()) && this.f82105p == TradeType.SUPERMARGIN && ClearDialogConfigController.i(3)) {
                ClearDialogConfig d14 = ClearDialogConfigController.d(3);
                ((h1) getUI()).K2(d14.getRulesUrl(), d14.getTips(), 3);
            } else if (TextUtils.isEmpty(J.getLeverageRatio()) || this.f82105p != TradeType.MARGIN || !ClearDialogConfigController.i(5)) {
                if (a1.v().S(this.f82094e)) {
                    if (ht.o.B().F() != null && ht.o.B().F().getStatus() == 1) {
                        HuobiToastUtil.j(R.string.prime_trade_not_ready);
                        return;
                    } else if (ht.o.B().D() == null) {
                        HuobiToastUtil.j(R.string.network_busy);
                        return;
                    }
                }
                if (!R1()) {
                    BigDecimal valueOf = BigDecimal.valueOf(this.f82098i.B());
                    h1 h1Var = (h1) getUI();
                    int uiPlanTradeBuyMode = z12 ? h1Var.getUiPlanTradeBuyMode() : h1Var.getUiPlanTradeSellMode();
                    if (z12) {
                        i11 = ((h1) getUI()).S1();
                    } else {
                        i11 = ((h1) getUI()).c2();
                    }
                    if (this.f82103n == 1) {
                        if (z12) {
                            str6 = O0();
                        } else {
                            str6 = F0();
                        }
                        str5 = str6;
                    } else {
                        str5 = str;
                    }
                    String str7 = str3;
                    boolean z13 = z11;
                    boolean W = this.f82100k.W(this.f82105p, o0(), this.f82103n, str5, str7, z13, valueOf, this.f82109t, str4, ht.o.B().K(), i11, uiPlanTradeBuyMode);
                    if (!this.f82100k.J(this.f82105p, o0(), this.f82103n, str5, str7, z13, this.f82109t, ht.o.B().K(), i11, uiPlanTradeBuyMode) && !W) {
                        v7.b.a().getBalanceProfitLoss().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new et.c(this)));
                    }
                    if (W && d1() && !com.huobi.trade.helper.b.a().b()) {
                        ((h1) getUI()).L2();
                    } else if (W) {
                        String str8 = null;
                        OrderPlaceBean selectedMarketAmount = this.f82100k.X(this.f82105p, this.f82094e, this.f82103n, str5, str3, z11, str4, valueOf, i11, (!ij.j.g().j() || this.E) ? couponReturn : null).setSelectedMarketAmount(((h1) getUI()).U7());
                        String str9 = str2;
                        OrderPlaceBean marketAmountText = selectedMarketAmount.setMarketAmountText(str9);
                        if (((h1) getUI()).z6()) {
                            str8 = ((h1) getUI()).Wf();
                        }
                        OrderPlaceBean iceAmount = marketAmountText.setIceAmount(str8);
                        int i12 = this.f82103n;
                        if (i12 == 0) {
                            iceAmount.setOrderLimitType(this.f82104o);
                        } else if (i12 == 3) {
                            iceAmount.setPlanTradeMarketMode(this.f82114y);
                        }
                        if (a1.v().S(this.f82094e)) {
                            if ("10008".equals(ht.o.B().A()) && z12 && this.f82103n == 1) {
                                HuobiToastUtil.j(R.string.prime_trade_rounds_over);
                            } else if (z12) {
                                ht.o.B().y().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new o(iceAmount, z12));
                            } else {
                                this.f82100k.b0(this.f82105p, iceAmount, getActivity());
                            }
                        } else if (!a1.v().p0(this.f82094e) || BizRecordProvider.e()) {
                            iceAmount.getTradeViewType();
                            TradeType tradeType = this.f82105p;
                            if (tradeType == TradeType.MARGIN || tradeType == TradeType.SUPERMARGIN) {
                                if (this.f82103n == 1) {
                                    BaseCoreActivity activity = getActivity();
                                    TradeType tradeType2 = this.f82105p;
                                    String str10 = this.f82094e;
                                    if (z11) {
                                        d12 = J.getMarketBuyPriceHigherThanCurrent();
                                    } else {
                                        d12 = J.getMarketSellPriceLowerThanCurrent();
                                    }
                                    this.f82102m = TradeLimitHelper.e(activity, tradeType2, str10, z11, valueOf, str5, R0(d12, z11 ? str9 : str3, d11, list), new a(iceAmount));
                                    return;
                                }
                                this.f82100k.b0(tradeType, iceAmount, getActivity());
                            } else if (this.f82103n == 1) {
                                BaseCoreActivity activity2 = getActivity();
                                TradeType tradeType3 = this.f82105p;
                                String str11 = this.f82094e;
                                if (z12) {
                                    d13 = J.getMarketBuyPriceHigherThanCurrent();
                                } else {
                                    d13 = J.getMarketSellPriceLowerThanCurrent();
                                }
                                this.f82102m = TradeLimitHelper.e(activity2, tradeType3, str11, z11, valueOf, str5, R0(d13, z12 ? str9 : str3, d11, list), new b(iceAmount));
                            } else {
                                this.f82100k.t0(tradeType, iceAmount, getActivity());
                            }
                        } else {
                            ((h1) getUI()).F2();
                        }
                    }
                }
            } else {
                ClearDialogConfig d15 = ClearDialogConfigController.d(5);
                ((h1) getUI()).K2(d15.getRulesUrl(), d15.getTips(), 5);
            }
        } else {
            ClearDialogConfig d16 = ClearDialogConfigController.d(2);
            ((h1) getUI()).K2(d16.getRulesUrl(), d16.getTips(), 2);
        }
    }

    public final String R0(double d11, String str, double d12, List<? extends c.a> list) {
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
            d13 -= aVar.e();
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

    public boolean R1() {
        SymbolBean J = a1.v().J(this.f82094e, TradeType.PRO);
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
        ((h1) getUI()).x2(true, true, String.format(getString(R.string.n_exchange_main_partition_limit_hint), new Object[]{String.valueOf(i11)}));
        return true;
    }

    public final void S0() {
        if (r.x().F0() && a1.v().p0(this.f82094e)) {
            BizRecordProvider.d(4).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new j());
        }
    }

    public void S1() {
    }

    public d3 T0() {
        return this.f82100k;
    }

    public void T1(BigDecimal bigDecimal, BigDecimal bigDecimal2, boolean z11) {
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        BigDecimal bigDecimal5;
        BigDecimal bigDecimal6;
        TradeType tradeType = this.f82105p;
        BigDecimal bigDecimal7 = null;
        if (tradeType == TradeType.SUPERMARGIN) {
            if (z11) {
                if (((h1) getUI()).S1() == 1 || ((h1) getUI()).S1() == 3) {
                    if (bigDecimal != null) {
                        BigDecimal subtract = bigDecimal.subtract(this.f82100k.G(this.f82105p, this.f82094e, z11, 0));
                        if (subtract.compareTo(BigDecimal.ZERO) < 0) {
                            subtract = BigDecimal.ZERO;
                        }
                        bigDecimal6 = subtract.setScale(PrecisionUtil.k(), 0);
                    } else {
                        bigDecimal6 = null;
                    }
                    this.f82100k.g0(bigDecimal6);
                } else {
                    bigDecimal6 = null;
                }
                if (((h1) getUI()).S1() == 2 || ((h1) getUI()).S1() == 3) {
                    MarginLoanAsset A2 = this.f82100k.A(a1.v().n(this.f82094e));
                    if (bigDecimal2 != null) {
                        BigDecimal bigDecimal8 = BigDecimal.ZERO;
                        if (A2 != null) {
                            bigDecimal8 = A2.getLoanAndInterest();
                        }
                        bigDecimal7 = new BigDecimal(String.valueOf(Math.min(bigDecimal2.doubleValue(), bigDecimal8.doubleValue()))).setScale(PrecisionUtil.r(), 1);
                        this.f82100k.h0(bigDecimal8.setScale(PrecisionUtil.r(), 1));
                    }
                    this.f82100k.i0(bigDecimal7);
                }
                if (bigDecimal6 == null) {
                    ((h1) getUI()).Ya("--", z11);
                } else {
                    ((h1) getUI()).Ya(bigDecimal6.toPlainString(), z11);
                }
                if (bigDecimal7 == null) {
                    ((h1) getUI()).u9("--", z11);
                } else {
                    ((h1) getUI()).u9(bigDecimal7.toPlainString(), z11);
                }
            } else {
                if (((h1) getUI()).c2() == 1 || ((h1) getUI()).S1() == 3) {
                    if (bigDecimal2 != null) {
                        BigDecimal subtract2 = bigDecimal2.subtract(this.f82100k.G(this.f82105p, this.f82094e, z11, 0));
                        if (subtract2.compareTo(BigDecimal.ZERO) < 0) {
                            subtract2 = BigDecimal.ZERO;
                        }
                        bigDecimal5 = subtract2.setScale(PrecisionUtil.k(), 0);
                    } else {
                        bigDecimal5 = null;
                    }
                    this.f82100k.m0(bigDecimal5);
                } else {
                    bigDecimal5 = null;
                }
                if (((h1) getUI()).c2() == 2 || ((h1) getUI()).S1() == 3) {
                    MarginLoanAsset A3 = this.f82100k.A(a1.v().D(this.f82094e));
                    if (bigDecimal != null) {
                        BigDecimal bigDecimal9 = BigDecimal.ZERO;
                        if (A3 != null) {
                            bigDecimal9 = A3.getLoanAndInterest();
                        }
                        bigDecimal7 = new BigDecimal(String.valueOf(Math.min(bigDecimal.doubleValue(), bigDecimal9.doubleValue()))).setScale(PrecisionUtil.r(), 1);
                        this.f82100k.n0(bigDecimal9.setScale(PrecisionUtil.r(), 1));
                    }
                    this.f82100k.o0(bigDecimal7);
                }
                if (bigDecimal5 == null) {
                    ((h1) getUI()).Ya("--", z11);
                } else {
                    ((h1) getUI()).Ya(bigDecimal5.toPlainString(), z11);
                }
                if (bigDecimal7 == null) {
                    ((h1) getUI()).u9("--", z11);
                } else {
                    ((h1) getUI()).u9(bigDecimal7.toPlainString(), z11);
                }
            }
        } else if (tradeType != TradeType.MARGIN) {
        } else {
            if (z11) {
                if (((h1) getUI()).S1() == 1 || ((h1) getUI()).S1() == 3) {
                    if (bigDecimal != null) {
                        BigDecimal subtract3 = bigDecimal.subtract(this.f82100k.z(this.f82094e, z11, 0));
                        if (subtract3.compareTo(BigDecimal.ZERO) < 0) {
                            subtract3 = BigDecimal.ZERO;
                        }
                        bigDecimal4 = subtract3.setScale(PrecisionUtil.k(), 0);
                    } else {
                        bigDecimal4 = null;
                    }
                    this.f82100k.g0(bigDecimal4);
                } else {
                    bigDecimal4 = null;
                }
                if (((h1) getUI()).S1() == 2 || ((h1) getUI()).S1() == 3) {
                    String n11 = a1.v().n(this.f82094e);
                    MarginBalanceQueryData y12 = h2.t1().y1(this.f82094e);
                    if (bigDecimal2 != null) {
                        BigDecimal bigDecimal10 = BigDecimal.ZERO;
                        if (y12 != null) {
                            bigDecimal10 = y12.getLoanAndInterest(n11);
                        }
                        BigDecimal scale = new BigDecimal(String.valueOf(Math.min(bigDecimal2.doubleValue(), bigDecimal10.doubleValue()))).setScale(PrecisionUtil.r(), 1);
                        this.f82100k.h0(bigDecimal10.setScale(PrecisionUtil.r(), 1));
                        bigDecimal7 = scale;
                    }
                    this.f82100k.i0(bigDecimal7);
                }
                if (bigDecimal4 == null) {
                    ((h1) getUI()).Ya("--", z11);
                } else {
                    ((h1) getUI()).Ya(bigDecimal4.toPlainString(), z11);
                }
                if (bigDecimal7 == null) {
                    ((h1) getUI()).u9("--", z11);
                } else {
                    ((h1) getUI()).u9(bigDecimal7.toPlainString(), z11);
                }
            } else {
                if (((h1) getUI()).c2() == 1 || ((h1) getUI()).S1() == 3) {
                    if (bigDecimal2 != null) {
                        BigDecimal subtract4 = bigDecimal2.subtract(this.f82100k.z(this.f82094e, z11, 0));
                        if (subtract4.compareTo(BigDecimal.ZERO) < 0) {
                            subtract4 = BigDecimal.ZERO;
                        }
                        bigDecimal3 = subtract4.setScale(PrecisionUtil.k(), 0);
                    } else {
                        bigDecimal3 = null;
                    }
                    this.f82100k.m0(bigDecimal3);
                } else {
                    bigDecimal3 = null;
                }
                if (((h1) getUI()).c2() == 2 || ((h1) getUI()).S1() == 3) {
                    String D2 = a1.v().D(this.f82094e);
                    MarginBalanceQueryData y13 = h2.t1().y1(this.f82094e);
                    if (bigDecimal != null) {
                        BigDecimal bigDecimal11 = BigDecimal.ZERO;
                        if (y13 != null) {
                            bigDecimal11 = y13.getLoanAndInterest(D2);
                        }
                        BigDecimal scale2 = new BigDecimal(String.valueOf(Math.min(bigDecimal.doubleValue(), bigDecimal11.doubleValue()))).setScale(PrecisionUtil.r(), 1);
                        this.f82100k.n0(bigDecimal11.setScale(PrecisionUtil.r(), 1));
                        bigDecimal7 = scale2;
                    }
                    this.f82100k.o0(bigDecimal7);
                }
                if (bigDecimal3 == null) {
                    ((h1) getUI()).Ya("--", z11);
                } else {
                    ((h1) getUI()).Ya(bigDecimal3.toPlainString(), z11);
                }
                if (bigDecimal7 == null) {
                    ((h1) getUI()).u9("--", z11);
                } else {
                    ((h1) getUI()).u9(bigDecimal7.toPlainString(), z11);
                }
            }
        }
    }

    public void U0() {
        c0.d().e().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g());
    }

    public void U1() {
    }

    public TradeType V0() {
        return this.f82105p;
    }

    public void V1() {
    }

    public int W0() {
        return this.f82103n;
    }

    public void W1() {
        if (r.x().F0()) {
            this.f82099j.F1(true, this.f82105p, this.f82094e, this.f82113x, this.f82112w);
            int i11 = this.f82113x;
            if (i11 == 2) {
                F1();
            } else if (i11 == 3) {
                E1();
            } else if (i11 == 4) {
                G1();
            } else if (i11 == 9) {
                H1();
            }
        } else {
            this.f82099j.C1(this.f82094e, this.f82113x, this.f82114y);
            ((h1) getUI()).d3(8);
            this.f82100k.r();
        }
    }

    public final void X0() {
        LegalCurrencyConfigUtil.e().flatMap(et.h.f54436b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new l());
    }

    public void X1() {
    }

    public abstract void Y0(boolean z11, String str, boolean z12);

    public abstract void Y1();

    public void Z(boolean z11) {
        super.Z(z11);
        if (this.f82097h != z11) {
            b2(z11);
        }
        if (r.x().F0()) {
            I1();
        }
    }

    public final void Z0() {
        String d11 = i2.a().d(this.f82105p);
        if (!TextUtils.isEmpty(d11)) {
            this.f82094e = d11;
            SymbolBean J = a1.v().J(this.f82094e, this.f82105p);
            this.f82093d = J.getSymbolName();
            this.f82095f = J.getBaseCurrency();
            this.f82096g = J.getBaseCurrencyDisplayName();
            C1();
        } else {
            List<SymbolBean> Z = a1.v().Z(this.f82105p);
            if (Z != null && !Z.isEmpty()) {
                SymbolBean symbolBean = Z.get(0);
                this.f82094e = symbolBean.getSymbol();
                this.f82093d = symbolBean.getSymbolName();
                this.f82095f = symbolBean.getBaseCurrency();
                this.f82096g = symbolBean.getBaseCurrencyDisplayName();
                C1();
                i2.a().h(this.f82105p, this.f82094e);
            }
        }
        ht.o.B().t0(this.f82094e);
        ((h1) getUI()).K8(N0(), D0());
    }

    public abstract void Z1();

    public void a() {
        if (this.f82113x != 1) {
            return;
        }
        if (this.f82099j.t0()) {
            ((h1) getUI()).d3(8);
        } else {
            ((h1) getUI()).d3(0);
        }
    }

    public boolean a1() {
        return this.B;
    }

    public void a2() {
        if (d1()) {
            ((h1) getUI()).o3(0, 5);
        } else if (a1.v().r0(this.f82094e)) {
            ((h1) getUI()).o3(0, 6);
        } else if (a1.v().p0(this.f82094e)) {
            ((h1) getUI()).o3(0, 4);
        } else if (a1.v().M(this.f82094e)) {
            ((h1) getUI()).o3(0, 0);
        } else if (a1.v().T(this.f82094e)) {
            ((h1) getUI()).o3(0, 1);
        } else if (a1.v().O(this.f82094e)) {
            ((h1) getUI()).o3(8, 7);
        } else if (a1.v().N(this.f82094e)) {
            ((h1) getUI()).o3(0, 2);
        } else {
            ((h1) getUI()).o3(8, 3);
        }
    }

    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        if (((h1) getUI()).isCanBeSeen()) {
            this.f82098i.X(this.f82094e, false);
            ((h1) getUI()).F(this.f82103n, true);
            this.f82105p = symbolChangeEvent.e();
            Z0();
            if (a1.v().s0(this.f82094e)) {
                this.f82112w = 0;
                ((h1) getUI()).B2(R.id.open_order_rb);
            }
            ((h1) getUI()).l1();
            ((h1) getUI()).O2(0, 0);
            x0(0, true);
            ((h1) getUI()).E3(a1.v().S(this.f82094e));
            ((h1) getUI()).d2(PrecisionUtil.e(this.f82094e));
            Y0(false, this.f82094e, true);
            W1();
            this.f82099j.N1();
            a2();
            ((h1) getUI()).O1(this.f82094e, this.f82105p);
            ((h1) getUI()).E2();
            if (this.f82097h) {
                this.f82098i.O(this.f82094e, this.f82105p);
                this.f82101l.d(this.f82094e);
                X0();
                this.f82106q = false;
                this.f82107r = false;
                this.f82108s = false;
            }
            if (!TextUtils.isEmpty(this.f82094e)) {
                s1(true);
            }
            L0();
            H0();
            R1();
        }
    }

    public boolean b1() {
        return a1.v().p0(this.f82094e);
    }

    public void b2(boolean z11) {
        if (Q().getActivity() != null) {
            this.f82097h = z11;
            if (z11) {
                this.f82105p = TradeType.valueOf(Q().getArguments().getString("key_trade_type", TradeType.PRO.name()));
                i6.d.b(this.f82105p + "======" + com.huobi.trade.helper.d.b(this.f82105p));
                Q().getArguments();
                if (com.huobi.trade.helper.d.b(this.f82105p)) {
                    i6.d.b(this.f82105p + "======" + com.huobi.trade.helper.d.a(this.f82105p));
                    this.B = com.huobi.trade.helper.d.a(this.f82105p);
                    com.huobi.trade.helper.d.c(this.f82105p);
                    ((h1) getUI()).B(com.huobi.trade.helper.d.a(this.f82105p) ^ true ? 1 : 0);
                }
                Z0();
                if (this.f82111v) {
                    String d11 = i2.a().d(this.f82105p);
                    if (d1() && this.f82103n == 3) {
                        this.f82103n = 0;
                    }
                    u0();
                    if (!a1.v().S(d11)) {
                        x0(this.f82103n, false);
                    }
                }
                n0();
                return;
            }
            m0();
        }
    }

    public boolean c1() {
        return this.f82106q;
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void canUseIceBerg(com.huobi.trade.helper.m mVar) {
        x0(this.f82103n, false);
    }

    public /* bridge */ /* synthetic */ u6.g d() {
        return (u6.g) super.getUI();
    }

    public boolean d1() {
        return a1.v().q0(this.f82094e, this.f82105p);
    }

    public int e() {
        return this.f82112w;
    }

    public int g() {
        return this.f82113x;
    }

    public void k1() {
        a5 a5Var = this.f82099j;
        if (a5Var != null) {
            a5Var.p1();
        }
    }

    public void l1() {
        t1();
        ht.o.B().q0("");
        W1();
        if (r.x().F0()) {
            Y0(false, o0(), true);
        }
        X0();
        p1();
        ((h1) getUI()).y0(true);
        if (!TextUtils.isEmpty(this.f82094e)) {
            s1(false);
        }
        Q0();
        if (r.x().F0()) {
            I1();
        }
    }

    public void m0() {
        this.f82109t = false;
        this.f82098i.X(this.f82094e, false);
        this.f82101l.g(this.f82094e);
        this.f82099j.L1();
        this.f82099j.N1();
        this.f82099j.K1();
        this.f82099j.J1();
        this.f82099j.M1();
        ((h1) getUI()).D2();
        ((h1) getUI()).w3();
        ht.o.B().w0();
        ((h1) getUI()).R1(true, a1());
        Subscription subscription = this.f82115z;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f82115z = null;
        }
    }

    public void m1() {
        is.a.j("4247", (Map<String, Object>) null, "1000048");
    }

    public void n0() {
        this.f82106q = false;
        this.f82107r = false;
        this.f82108s = false;
        boolean F0 = r.x().F0();
        ((h1) getUI()).F(this.f82103n, true);
        ((h1) getUI()).d(F0);
        if (a1.v().s0(this.f82094e)) {
            this.f82112w = 0;
            ((h1) getUI()).B2(R.id.open_order_rb);
        }
        ((h1) getUI()).l1();
        ((h1) getUI()).E3(a1.v().S(this.f82094e));
        ((h1) getUI()).d2(PrecisionUtil.e(this.f82094e));
        w0(F0, a1());
        W1();
        S0();
        H0();
        X0();
        this.f82098i.O(this.f82094e, this.f82105p);
        this.f82101l.d(this.f82094e);
        a2();
        ((h1) getUI()).O1(this.f82094e, this.f82105p);
        ((h1) getUI()).U2();
        U0();
        ht.o.B().w();
        r.x().B0(false, (u6.g) null);
        this.f82111v = true;
        ((h1) getUI()).O2(0, 0);
        ad.o.e().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseEasySubscriber());
        if (!TextUtils.isEmpty(this.f82094e)) {
            s1(true);
        }
        L0();
        ((h1) getUI()).l1();
        Q0();
        t1();
    }

    /* renamed from: n1 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, V v11) {
        super.onUIReady(baseCoreActivity, v11);
        a5 a5Var = new a5(this);
        this.f82099j = a5Var;
        a5Var.t1(this);
        this.f82105p = TradeType.valueOf(Q().getArguments().getString("key_trade_type", TradeType.PRO.name()));
        ((h1) getUI()).b(this.f82099j.o0());
        this.f82100k = new d3((h1) getUI());
        this.f82098i = new r2((r2.d) getUI(), this.f82099j, this.f82105p, getActivity());
        this.f82101l = new e3(this.f82105p, (e3.c) getUI(), getActivity());
        ((h1) getUI()).y2();
        x0(0, false);
        if (getUI() instanceof y3) {
            A1(0);
            ((y3) getUI()).Of();
        }
    }

    public String o0() {
        return this.f82094e;
    }

    public void o1(Map<String, String> map, OrderPlaceBean orderPlaceBean) {
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
        this.f82100k.b0(this.f82105p, orderPlaceBean, getActivity());
    }

    public void onChangeMarginEvent(at.a aVar) {
        h1 h1Var = (h1) getUI();
        throw null;
    }

    public void onErrorCodeEvent(mo.a aVar) {
        if (((h1) getUI()).isCanBeSeen()) {
            ((h1) getUI()).F(this.f82103n, true);
            this.f82100k.t();
            ((h1) getUI()).d(false);
            this.f82099j.C1(this.f82094e, this.f82113x, this.f82112w);
            ((h1) getUI()).d3(8);
            D1();
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onLogout(LogOutEvent logOutEvent) {
        ((h1) getUI()).t4();
    }

    public void onPause() {
        super.onPause();
        this.f82099j.L1();
        this.f82099j.N1();
        this.f82099j.K1();
        this.f82099j.J1();
        this.f82099j.M1();
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onProTokenUpdate(ProTokenUpdate proTokenUpdate) {
        this.f82099j.q1(proTokenUpdate);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        rn.c.i().m(getActivity(), (kn.a) null);
        HBDialogFragment hBDialogFragment = this.f82102m;
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    public void p0() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", LicenseType.PIONEER.type);
        UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap).compose(p.c0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new f());
    }

    public abstract void p1();

    public void q0() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "POTENTIALS");
        UserCenterRemoteDataSource.A().requestLicenseAgree(hashMap).compose(p.c0()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new SilentSubscriber());
    }

    public void q1() {
        a1.v().Y(false, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create((Action0) null, new et.f(this), new et.d(this), new et.e(this), (Action0) null));
    }

    public void r0() {
        this.f82099j.f0(this.f82105p, this.f82094e);
        E1();
    }

    public void r1() {
        this.f82098i.R(this.f82094e);
        this.f82101l.d(this.f82094e);
    }

    public void s0() {
        String str;
        Observable<Long> observable;
        String str2 = z.a() ? this.f82094e : "";
        TradeType tradeType = TradeType.PRO;
        TradeType tradeType2 = this.f82105p;
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
        TradeType tradeType4 = this.f82105p;
        if (tradeType3 == tradeType4 || TradeType.MARGIN == tradeType4) {
            observable = h2.t1().D1(str, str2);
        } else {
            observable = h2.t1().b1(this.f82105p, str);
        }
        observable.flatMap(new et.g(this, str2)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
    }

    public final void s1(boolean z11) {
        ExchangeSettingsController.d().c(z11, this.f82094e).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }

    public void t0() {
        String str;
        if (z.a()) {
            str = this.f82094e;
        } else {
            str = "";
        }
        Subscription subscription = this.f82092c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f82092c = x8.a.a().p(str, "", 2).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c());
    }

    public void t1() {
        String str;
        if (r.x().F0()) {
            TradeType tradeType = this.f82105p;
            if (tradeType == TradeType.SUPERMARGIN) {
                str = "super-margin";
            } else {
                str = tradeType == TradeType.MARGIN ? "margin" : RankScreenBean.SCREEN_VALUE_SPOT;
            }
            ut.o.C().Q((u6.g) getUI(), str).subscribe(new i());
            return;
        }
        ((h1) getUI()).Ab(this.F);
    }

    public void u0() {
        SymbolBean J = a1.v().J(this.f82094e, this.f82105p);
        if (J != null && J.isCallAuction()) {
            this.f82103n = 0;
        }
    }

    public void u1() {
        a1.v().Y(false, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void updateAssetAndOrder(AssetAndOrderUpdateEvent assetAndOrderUpdateEvent) {
        if (((h1) getUI()).isCanBeSeen()) {
            Y1();
            this.f82099j.H1(true, this.f82105p, this.f82094e, this.f82113x, this.f82112w);
            int i11 = this.f82113x;
            if (i11 == 2) {
                this.f82099j.E1(this.f82105p, this.f82094e, i11, this.f82114y);
            }
            i6.i.b().g(new h(), 500);
            A0();
        }
    }

    public void v0(String str) {
        i2.a().h(this.f82105p, str);
        SymbolChangeEvent symbolChangeEvent = new SymbolChangeEvent();
        symbolChangeEvent.g(str);
        symbolChangeEvent.i(this.f82094e);
        symbolChangeEvent.j(this.f82105p);
        EventBus.d().k(symbolChangeEvent);
    }

    public void v1(boolean z11) {
        this.B = z11;
    }

    public abstract void w0(boolean z11, boolean z12);

    public void w1(int i11) {
        i6.d.e("PLAN_TRADE", "setCurOrderListTradeType - " + i11);
        com.huobi.trade.helper.c.b().l(Integer.valueOf(i11));
        com.huobi.trade.helper.c.b().h();
        this.f82112w = i11;
    }

    public void x0(int i11, boolean z11) {
        this.f82106q = false;
        this.f82107r = false;
        this.f82108s = false;
        int i12 = this.f82103n;
        this.f82103n = i11;
        ((h1) getUI()).v(i12, this.f82103n, a1(), o0());
        Z1();
    }

    public void x1(int i11) {
        this.f82114y = i11;
    }

    public void y0(BigDecimal bigDecimal, BigDecimal bigDecimal2, boolean z11, int i11) {
    }

    public void y1() {
        ((h1) getUI()).u3(i6.m.i(this.f82098i.B(), PrecisionUtil.A(o0())));
    }

    public void z0() {
        this.f82099j.C1(this.f82094e, this.f82113x, this.f82112w);
        ((h1) getUI()).d3(8);
    }

    public void z1(boolean z11) {
        this.f82106q = z11;
    }
}
