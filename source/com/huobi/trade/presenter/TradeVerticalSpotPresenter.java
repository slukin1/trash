package com.huobi.trade.presenter;

import al.p;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.core.bean.AssertsTradeData;
import com.hbg.lib.network.hbg.core.bean.PrimeKycLimit;
import com.hbg.lib.network.hbg.core.bean.RemainingAmountBean;
import com.hbg.lib.network.hbg.core.bean.SpotContractEntryBean;
import com.hbg.lib.network.pro.core.bean.CallAuction;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.account.entity.AccountType;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.trade.bean.TradeHoldBean;
import com.huobi.trade.bean.TradeRefreshEvent;
import com.huobi.trade.helper.x;
import com.huobi.trade.ui.ZoneReminderActivity;
import com.huobi.trade.ui.s;
import com.huobi.trade.ui.z4;
import com.huobi.trade.utils.TradeTimeMonitorUtils;
import com.huobi.utils.SymbolUtil;
import com.huobi.utils.k0;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import dt.a5;
import dt.h2;
import et.a0;
import et.b0;
import et.c0;
import et.d0;
import et.e0;
import et.f0;
import et.t;
import et.u;
import et.v;
import et.w;
import et.y;
import et.z;
import ht.o;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import tg.r;

public class TradeVerticalSpotPresenter extends TradeVerticalBasePresenter<z4> {
    public Subscription K;
    public Subscription L;
    public Subscriber<Long> M;
    public Subscriber<CallAuction> N;
    public boolean O;
    public boolean P;
    public boolean Q;

    public class a extends BaseSubscriber<CallAuction> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(CallAuction callAuction) {
            ((z4) TradeVerticalSpotPresenter.this.getUI()).r(callAuction, TradeVerticalSpotPresenter.this.f82094e);
            TradeVerticalSpotPresenter.this.B3();
            if (callAuction.isContinuity()) {
                TradeVerticalSpotPresenter.this.u3();
                TradeVerticalSpotPresenter.this.w3();
            }
        }
    }

    public class b extends BaseSubscriber<CallAuction> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(CallAuction callAuction) {
            super.onNext(callAuction);
            TradeVerticalSpotPresenter.this.u0();
            TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
            tradeVerticalSpotPresenter.x0(tradeVerticalSpotPresenter.f82103n, false);
        }
    }

    public class c extends BaseSubscriber<List<SymbolBean>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82148b;

        public c(boolean z11) {
            this.f82148b = z11;
        }

        public void onAfter() {
            super.onAfter();
            ((z4) TradeVerticalSpotPresenter.this.getUI()).y0(true);
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            if (a1.v().H(TradeVerticalSpotPresenter.this.f82105p).contains(TradeVerticalSpotPresenter.this.f82094e)) {
                if (((z4) TradeVerticalSpotPresenter.this.getUI()).isCanBeSeen()) {
                    a1 v11 = a1.v();
                    TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
                    ((z4) TradeVerticalSpotPresenter.this.getUI()).t(v11.J(tradeVerticalSpotPresenter.f82094e, tradeVerticalSpotPresenter.f82105p));
                    ((z4) TradeVerticalSpotPresenter.this.getUI()).z1();
                    TradeVerticalSpotPresenter.this.q3();
                }
                TradeVerticalSpotPresenter.this.r1();
                TradeVerticalSpotPresenter.this.R1();
            } else {
                if (!a1.v().H(TradeVerticalSpotPresenter.this.f82105p).isEmpty()) {
                    TradeVerticalSpotPresenter.this.f82094e = a1.v().H(TradeVerticalSpotPresenter.this.f82105p).get(0);
                }
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter2 = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter2.C0(tradeVerticalSpotPresenter2.f82094e);
            }
            if (a1.v().L(TradeVerticalSpotPresenter.this.f82094e)) {
                if (r.x().F0()) {
                    o B = o.B();
                    TradeVerticalSpotPresenter tradeVerticalSpotPresenter3 = TradeVerticalSpotPresenter.this;
                    B.E(tradeVerticalSpotPresenter3.f82094e, (u6.g) tradeVerticalSpotPresenter3.getUI(), ((z4) TradeVerticalSpotPresenter.this.getUI()).r1());
                    TradeVerticalSpotPresenter tradeVerticalSpotPresenter4 = TradeVerticalSpotPresenter.this;
                    tradeVerticalSpotPresenter4.Y0(false, tradeVerticalSpotPresenter4.f82094e, true);
                } else {
                    o B2 = o.B();
                    TradeVerticalSpotPresenter tradeVerticalSpotPresenter5 = TradeVerticalSpotPresenter.this;
                    B2.p0(tradeVerticalSpotPresenter5.f82094e, (u6.g) tradeVerticalSpotPresenter5.getUI(), ((z4) TradeVerticalSpotPresenter.this.getUI()).r1());
                }
            }
            if (this.f82148b) {
                TradeVerticalSpotPresenter.this.r3();
            }
        }
    }

    public class d extends BaseSubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SymbolBean f82150b;

        public d(SymbolBean symbolBean) {
            this.f82150b = symbolBean;
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            i6.d.b("open:" + this.f82150b.getTradeOpenAt() + "===current:" + System.currentTimeMillis() + "====diff:" + (this.f82150b.getTradeOpenAt() - System.currentTimeMillis()));
            if (this.f82150b.getTradeOpenAt() - System.currentTimeMillis() <= -1000) {
                TradeVerticalSpotPresenter.this.Z2(false);
                TradeVerticalSpotPresenter.this.x3();
            }
        }
    }

    public class e extends BaseSubscriber<PrimeKycLimit> {
        public e() {
        }

        /* renamed from: a */
        public void onNext(PrimeKycLimit primeKycLimit) {
            super.onNext(primeKycLimit);
            if (primeKycLimit.getBlackKycType() == 2 || primeKycLimit.getBlackKycType() == 1) {
                ((z4) TradeVerticalSpotPresenter.this.getUI()).u1();
            } else {
                ((z4) TradeVerticalSpotPresenter.this.getUI()).p1(primeKycLimit);
            }
        }
    }

    public class f extends EasySubscriber<SpotContractEntryBean> {
        public f() {
        }

        /* renamed from: a */
        public void onNext(SpotContractEntryBean spotContractEntryBean) {
            String str;
            super.onNext(spotContractEntryBean);
            if (1 == spotContractEntryBean.getShowType()) {
                str = spotContractEntryBean.getContractMaxLevel() + "X";
            } else if (2 != spotContractEntryBean.getShowType() || x.b()) {
                str = "";
            } else {
                str = spotContractEntryBean.getLeverMaxLevel() + "X";
            }
            ((z4) TradeVerticalSpotPresenter.this.getUI()).wb(spotContractEntryBean, str);
        }
    }

    public class g extends BaseSubscriber<List<SymbolBean>> {
        public g() {
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
            tradeVerticalSpotPresenter.C0(tradeVerticalSpotPresenter.f82094e);
        }
    }

    public class h implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82155b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Observable f82156c;

        public class a extends BaseSubscriber<String> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(String str) {
                super.onNext(str);
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter.f82109t = true;
                tradeVerticalSpotPresenter.C3(str);
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter2 = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter2.f82099j.y1(tradeVerticalSpotPresenter2.f82094e, tradeVerticalSpotPresenter2.D, tradeVerticalSpotPresenter2.f82105p);
                TradeTimeMonitorUtils.c(2);
            }

            public void onError(Throwable th2) {
                super.onError(th2);
                TradeTimeMonitorUtils.a();
            }
        }

        public h(boolean z11, Observable observable) {
            this.f82155b = z11;
            this.f82156c = observable;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(BalanceDataTotal balanceDataTotal) {
            TradeVerticalSpotPresenter.this.y3(balanceDataTotal);
        }

        public static /* synthetic */ String e(BalanceDataTotal balanceDataTotal, String str, List list) {
            return str;
        }

        /* renamed from: c */
        public void call(Long l11) {
            Observable.zip(h2.t1().K1(this.f82155b).doOnNext(new a0(this)).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())), o.B().G().compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())), this.f82156c, b0.f54424b).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    public class i implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82159b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Observable f82160c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f82161d;

        public class a extends BaseSubscriber<RemainingAmountBean> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(RemainingAmountBean remainingAmountBean) {
                super.onNext(remainingAmountBean);
                i6.k.o("TRADE_SPOT", "观察区资产获取成功");
                TradeVerticalSpotPresenter.this.z3(remainingAmountBean);
                i iVar = i.this;
                String str = iVar.f82161d;
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
                ((z4) TradeVerticalSpotPresenter.this.getUI()).R2(str, tradeVerticalSpotPresenter.f82100k.E(tradeVerticalSpotPresenter.f82105p, str, tradeVerticalSpotPresenter.a1()));
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter2 = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter2.f82099j.y1(tradeVerticalSpotPresenter2.f82094e, tradeVerticalSpotPresenter2.D, tradeVerticalSpotPresenter2.f82105p);
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter3 = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter3.f82109t = true;
                tradeVerticalSpotPresenter3.Z1();
                TradeTimeMonitorUtils.c(2);
            }

            public void onAfter() {
                super.onAfter();
            }

            public void onError(Throwable th2) {
                super.onError(th2);
                TradeVerticalSpotPresenter.this.z3((RemainingAmountBean) null);
                ((z4) TradeVerticalSpotPresenter.this.getUI()).b3();
                TradeTimeMonitorUtils.a();
            }
        }

        public i(boolean z11, Observable observable, String str) {
            this.f82159b = z11;
            this.f82160c = observable;
            this.f82161d = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(BalanceDataTotal balanceDataTotal) {
            TradeVerticalSpotPresenter.this.y3(balanceDataTotal);
        }

        public static /* synthetic */ RemainingAmountBean e(BalanceDataTotal balanceDataTotal, RemainingAmountBean remainingAmountBean, List list) {
            return remainingAmountBean;
        }

        /* renamed from: c */
        public void call(Long l11) {
            Observable.zip(h2.t1().K1(this.f82159b).doOnNext(new c0(this)).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())), v7.b.a().getRemainingAmount(a1.v().n(TradeVerticalSpotPresenter.this.f82094e)).b(), this.f82160c, d0.f54428b).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    public class j implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82164b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Observable f82165c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f82166d;

        public class a extends BaseSubscriber<BalanceDataTotal> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(BalanceDataTotal balanceDataTotal) {
                super.onNext(balanceDataTotal);
                j jVar = j.this;
                String str = jVar.f82166d;
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
                ((z4) TradeVerticalSpotPresenter.this.getUI()).R2(str, tradeVerticalSpotPresenter.f82100k.E(tradeVerticalSpotPresenter.f82105p, str, tradeVerticalSpotPresenter.a1()));
                LogAndWoodRecorder.a("现货", "BalanceSubscription 3 onSuccess");
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter2 = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter2.f82099j.v1(tradeVerticalSpotPresenter2.f82094e, tradeVerticalSpotPresenter2.D, tradeVerticalSpotPresenter2.f82105p, (s) tradeVerticalSpotPresenter2.getUI());
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter3 = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter3.f82109t = true;
                tradeVerticalSpotPresenter3.Z1();
                TradeTimeMonitorUtils.c(2);
            }

            public void onError(Throwable th2) {
                super.onError(th2);
                LogAndWoodRecorder.a("现货", "BalanceSubscription 3 onError:" + th2.getMessage());
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
                a5 a5Var = tradeVerticalSpotPresenter.f82099j;
                String str = tradeVerticalSpotPresenter.f82094e;
                ArrayList arrayList = new ArrayList();
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter2 = TradeVerticalSpotPresenter.this;
                a5Var.v1(str, arrayList, tradeVerticalSpotPresenter2.f82105p, (s) tradeVerticalSpotPresenter2.getUI());
                TradeTimeMonitorUtils.a();
            }
        }

        public j(boolean z11, Observable observable, String str) {
            this.f82164b = z11;
            this.f82165c = observable;
            this.f82166d = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(BalanceDataTotal balanceDataTotal) {
            TradeVerticalSpotPresenter.this.y3(balanceDataTotal);
        }

        public static /* synthetic */ BalanceDataTotal e(BalanceDataTotal balanceDataTotal, List list) {
            return balanceDataTotal;
        }

        /* renamed from: c */
        public void call(Long l11) {
            Observable.zip(h2.t1().K1(this.f82164b).doOnNext(new e0(this)).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())), this.f82165c, f0.f54432b).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    public class k extends BaseSubscriber<Long> {
        public k() {
        }

        public void onNext(Long l11) {
            SymbolBean J = a1.v().J(TradeVerticalSpotPresenter.this.f82094e, TradeType.PRO);
            i6.d.b("CallAuction:" + System.currentTimeMillis() + "=====Ca1OpenAt:" + J.getCa1OpenAt() + "======isCallAuctionOne:" + J.isCallAuctionOne() + "====Ca2OpenAt:" + J.getCa2OpenAt() + "====CallAuctionTwo:" + J.isCallAuctionTwo());
            if (J.isCallAuctionOne()) {
                TradeVerticalSpotPresenter.this.m3();
            }
            if (J.isCallAuctionTwo()) {
                TradeVerticalSpotPresenter.this.o3();
            }
            TradeVerticalSpotPresenter.this.B3();
            TradeVerticalSpotPresenter.this.n3();
            if (System.currentTimeMillis() > J.getCa2CloseAt()) {
                TradeVerticalSpotPresenter.this.w3();
                ((z4) TradeVerticalSpotPresenter.this.getUI()).z1();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean a3(List list) {
        String A = a1.v().A(this.f82094e);
        return Boolean.valueOf("innovation".equals(A) || "bifurcation".equals(A) || SymbolBean.POTENTIALS.equals(A) || "profession".equals(A));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable b3(List list) {
        String A = a1.v().A(this.f82094e);
        this.f82110u = "NEW_ZONE";
        A.hashCode();
        char c11 = 65535;
        switch (A.hashCode()) {
            case -1210261252:
                if (A.equals("profession")) {
                    c11 = 0;
                    break;
                }
                break;
            case -587971563:
                if (A.equals(SymbolBean.POTENTIALS)) {
                    c11 = 1;
                    break;
                }
                break;
            case -69405874:
                if (A.equals("bifurcation")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1225074021:
                if (A.equals("innovation")) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.f82110u = "PRO_ZONE";
                break;
            case 1:
                this.f82110u = "POTENTIALS";
                break;
            case 2:
                this.f82110u = "FORK_ZONE";
                break;
            case 3:
                this.f82110u = "NEW_ZONE";
                break;
        }
        return UserCenterRemoteDataSource.A().requestLicenseState(this.f82110u, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c3(TradeRiskReminder tradeRiskReminder) {
        if (d1()) {
            com.huobi.trade.helper.b.a().c(tradeRiskReminder.getState());
        } else if ("0".equals(tradeRiskReminder.getState())) {
            getActivity().startActivity(new Intent(getActivity(), ZoneReminderActivity.class).putExtra("zone_reminder_type", this.f82110u));
        }
    }

    public static /* synthetic */ Observable d3(String str, String str2, Long l11) {
        IHbgApi a11 = v7.b.a();
        long longValue = l11.longValue();
        return a11.getAssetsTrade(longValue, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2).b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e3(List list) {
        if ((!uh.i.d().g() || !b1()) && list != null && list.size() > 0) {
            this.f82100k.f0(this.f82105p, h2.t1().U0(list));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable f3(Long l11) {
        return ys.a.c(this.f82094e);
    }

    public final void A3() {
        if (a1.v().k0(this.f82094e)) {
            this.f82098i.a0(String.format(Locale.US, getString(R.string.trade_hb_value), new Object[]{"--"}));
        } else {
            this.f82098i.a0("");
        }
        ((z4) getUI()).q3(a1.v().k0(this.f82094e));
    }

    public final void B3() {
        SymbolBean J = a1.v().J(this.f82094e, TradeType.PRO);
        if (J == null) {
            return;
        }
        if (J.isCallAuction()) {
            ((z4) getUI()).o(true);
        } else {
            ((z4) getUI()).o(false);
        }
    }

    public void C3(String str) {
        String str2;
        BigDecimal x11 = this.f82100k.x(this.f82105p, this.f82094e, a1());
        if (a1()) {
            if (x11.compareTo(m.a(str)) > 0) {
                str2 = str;
            } else {
                str2 = x11.toPlainString();
            }
            ((z4) getUI()).R2(this.f82094e, str2);
        } else {
            ((z4) getUI()).R2(this.f82094e, x11.toPlainString());
        }
        Z1();
        ((z4) getUI()).x3(str);
    }

    public void S1() {
        super.S1();
        if (a1.v().S(this.f82094e)) {
            ((z4) getUI()).W1(8);
        } else if (r.x().F0()) {
            ((z4) getUI()).D1(0);
            ((z4) getUI()).W1(0);
        } else {
            ((z4) getUI()).D1(8);
            ((z4) getUI()).W1(8);
        }
    }

    public void V() {
        EventBus.d().r(this);
        super.V();
    }

    public final Subscriber<CallAuction> V2() {
        return new a();
    }

    public final Subscriber<Long> W2() {
        return new k();
    }

    public void X1() {
        super.X1();
        boolean F0 = r.x().F0();
        if (a1.v().S(this.f82094e)) {
            if (o.B().P()) {
                ((z4) getUI()).D1(8);
            } else if (F0) {
                ((z4) getUI()).D1(0);
            } else {
                ((z4) getUI()).D1(8);
            }
        } else if (!F0) {
            ((z4) getUI()).D1(8);
        } else if (g() == 0) {
            ((z4) getUI()).D1(8);
        } else {
            ((z4) getUI()).D1(0);
        }
    }

    public final void X2() {
        if (r.x().F0()) {
            v7.b.a().getKycLimit().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e());
        }
    }

    public void Y0(boolean z11, String str, boolean z12) {
        Subscription subscription = this.K;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        if (!r.x().F0()) {
            z3((RemainingAmountBean) null);
            return;
        }
        if (z12) {
            ((z4) getUI()).b3();
        }
        Observable<List<AssertsTradeData>> j32 = j3(str);
        if (a1.v().S(str)) {
            this.K = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new h(z11, j32)).subscribe(new BaseSubscriber());
        } else if (d1()) {
            this.K = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new i(z11, j32, str)).subscribe(new BaseSubscriber());
        } else {
            this.K = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new j(z11, j32, str)).subscribe(new BaseSubscriber());
        }
    }

    public void Y1() {
        if (!a1.v().L(this.f82094e)) {
            return;
        }
        if (r.x().F0()) {
            o.B().E(this.f82094e, (u6.g) getUI(), ((z4) getUI()).r1());
        } else {
            o.B().p0(this.f82094e, (u6.g) getUI(), ((z4) getUI()).r1());
        }
    }

    public final void Y2() {
        if (!r.x().X()) {
            a1.v().Y(true, false).filter(new w(this)).flatMap(new et.x(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new t(this)));
        }
    }

    public void Z2(boolean z11) {
        a1.v().Y(false, true).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c(z11));
    }

    @k20.h
    @Keep
    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        if (((z4) getUI()).isCanBeSeen()) {
            if (symbolChangeEvent.f() || !symbolChangeEvent.b().equals(this.f82094e)) {
                super.afterSymbolIdChanged(symbolChangeEvent);
                A3();
                Y1();
                boolean F0 = r.x().F0();
                if (a1.v().S(this.f82094e)) {
                    X2();
                } else {
                    ((z4) getUI()).w1();
                    ((z4) getUI()).o1();
                }
                S1();
                X1();
                B3();
                ((z4) getUI()).z1();
                q3();
                n3();
                if (F0) {
                    Y2();
                } else {
                    o.B().s0((String) null);
                }
                l3();
                k3();
                r3();
            }
        }
    }

    /* renamed from: h3 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, z4 z4Var) {
        super.onUIReady(baseCoreActivity, z4Var);
        EventBus.d().p(this);
    }

    public final void i3() {
        SymbolBean J = a1.v().J(this.f82094e, this.f82105p);
        if (J != null && J.getCa1OpenAt() != 0) {
            ys.a.c(this.f82094e).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new b());
        }
    }

    public final Observable<List<AssertsTradeData>> j3(String str) {
        if (a1()) {
            SymbolUtil.a(str);
        } else {
            SymbolUtil.b(str);
        }
        return h2.t1().b1(this.f82105p, AccountType.spot.toString()).flatMap(new y(SymbolUtil.a(str), SymbolUtil.b(str))).compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new u(this));
    }

    public void k3() {
        v7.b.a().getSpotContractEntry(D0(), o0()).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new f());
    }

    public void l3() {
        if (x.b()) {
            SymbolBean J = a1.v().J(this.f82094e, TradeType.PRO);
            int i11 = 8;
            String str = "";
            if (J != null && gj.d.n().G()) {
                TradeType k11 = k0.k();
                String leverageRatio = J.getLeverageRatio();
                String superMarginLeverageRatio = J.getSuperMarginLeverageRatio();
                if (k11 != null) {
                    TradeType tradeType = TradeType.MARGIN;
                    if (k11 == tradeType) {
                        if (!TextUtils.isEmpty(leverageRatio)) {
                            str = leverageRatio + "X";
                        } else if (!TextUtils.isEmpty(superMarginLeverageRatio)) {
                            str = superMarginLeverageRatio + "X";
                            k0.F(TradeType.SUPERMARGIN);
                        }
                    } else if (k11 == TradeType.SUPERMARGIN) {
                        if (!TextUtils.isEmpty(superMarginLeverageRatio)) {
                            str = superMarginLeverageRatio + "X";
                        } else if (!TextUtils.isEmpty(leverageRatio)) {
                            str = leverageRatio + "X";
                            k0.F(tradeType);
                        }
                    }
                } else if (!TextUtils.isEmpty(leverageRatio) || !TextUtils.isEmpty(superMarginLeverageRatio)) {
                    if (m.a(leverageRatio).compareTo(m.a(superMarginLeverageRatio)) > 0) {
                        k0.F(TradeType.MARGIN);
                        str = leverageRatio + "X";
                    } else {
                        k0.F(TradeType.SUPERMARGIN);
                        str = superMarginLeverageRatio + "X";
                    }
                }
                i11 = 0;
            }
            ((z4) getUI()).p(i11, str);
        }
    }

    public void m0() {
        super.m0();
        o.B().t();
        Subscription subscription = this.K;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        w3();
        u3();
        t3();
        v3();
        x3();
    }

    public void m3() {
        SymbolBean J = a1.v().J(this.f82094e, TradeType.PRO);
        if (!this.O) {
            this.O = true;
            ((z4) getUI()).z1();
            ((z4) getUI()).E(1, J.getCa1CloseAt() - System.currentTimeMillis());
        }
    }

    public void n0() {
        super.n0();
        boolean F0 = r.x().F0();
        Z2(true);
        if (a1.v().S(this.f82094e)) {
            X2();
            if (o.B().P()) {
                ((z4) getUI()).D1(8);
            } else if (F0) {
                ((z4) getUI()).D1(0);
            } else {
                ((z4) getUI()).D1(8);
            }
        } else {
            ((z4) getUI()).o1();
            ((z4) getUI()).w1();
            if (F0) {
                ((z4) getUI()).D1(0);
            } else {
                ((z4) getUI()).D1(8);
            }
        }
        S1();
        X1();
        i3();
        B3();
        ((z4) getUI()).z1();
        q3();
        n3();
        if (F0) {
            Y2();
        } else {
            o.B().s0((String) null);
        }
        d7.k.C().U(true, (RequestCallback1<List<CurrencyBean>>) null);
        A3();
        l3();
        k3();
        Y0(false, this.f82094e, true);
        com.huobi.trade.helper.w.f82084a = false;
    }

    public final void n3() {
        SymbolBean J = a1.v().J(this.f82094e, this.f82105p);
        if (J != null && J.isCallAuction() && !this.Q) {
            this.Q = true;
            this.N = V2();
            Observable.interval(0, 5, TimeUnit.SECONDS).flatMap(new v(this)).retryWhen(z.f54457b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.N);
        }
    }

    public void o3() {
        SymbolBean J = a1.v().J(this.f82094e, TradeType.PRO);
        if (!this.P) {
            t3();
            this.P = true;
            long ca2CloseAt = J.getCa2CloseAt() - System.currentTimeMillis();
            W1();
            ((z4) getUI()).z1();
            ((z4) getUI()).E(2, ca2CloseAt);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onChangeMarginEvent(at.a aVar) {
        super.onChangeMarginEvent(aVar);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onErrorCodeEvent(mo.a aVar) {
        super.onErrorCodeEvent(aVar);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTradeRefresh(TradeRefreshEvent tradeRefreshEvent) {
        a1.v().Y(false, true).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g());
    }

    public void p1() {
        super.p1();
        Z2(true);
    }

    public final void q3() {
        SymbolBean J = a1.v().J(this.f82094e, this.f82105p);
        w3();
        if (J != null && !(J.getCa1OpenAt() == 0 && J.getCa2OpenAt() == 0) && System.currentTimeMillis() < J.getCa2CloseAt()) {
            this.M = W2();
            Observable.interval(0, 1000, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.M);
        }
    }

    public final void r3() {
        x3();
        SymbolBean J = a1.v().J(this.f82094e, this.f82105p);
        if (J != null && SymbolBean.PRE_ONLINE.equals(J.getState())) {
            if (J.getTradeOpenAt() - System.currentTimeMillis() > 0) {
                this.L = Observable.interval(0, 1, TimeUnit.SECONDS).subscribe(new d(J));
            } else {
                Z2(false);
            }
        }
    }

    public void t3() {
        com.huobi.trade.helper.i.k().u();
        this.O = false;
    }

    public final void u3() {
        Subscriber<CallAuction> subscriber = this.N;
        if (subscriber != null) {
            this.Q = false;
            subscriber.unsubscribe();
        }
    }

    public void v3() {
        this.P = false;
        com.huobi.trade.helper.i.k().u();
    }

    public final void w3() {
        Subscriber<Long> subscriber = this.M;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public final void x3() {
        Subscription subscription = this.L;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void y3(BalanceDataTotal balanceDataTotal) {
        List<? extends BaseAssetInfo> detailInfos;
        Map<String, BalanceDetailInfo> detailInfoMap = balanceDataTotal.getDetailInfoMap();
        SymbolBean J = a1.v().J(this.f82094e, this.f82105p);
        ArrayList arrayList = new ArrayList();
        if (detailInfoMap != null && J != null) {
            BalanceDetailInfo balanceDetailInfo = detailInfoMap.get(J.getBaseCurrency());
            TradeHoldBean tradeHoldBean = new TradeHoldBean();
            if (balanceDetailInfo != null) {
                tradeHoldBean.setAvailable(p.j(balanceDetailInfo.getAvaialAble(), J.getBaseCurrency()));
                tradeHoldBean.setNetAsset(p.j(balanceDetailInfo.getNetBalance(), J.getBaseCurrency()));
                tradeHoldBean.setEstimateTotal(balanceDetailInfo.getEstimateAmount());
                if (m.a(balanceDataTotal.getNetAsset()).compareTo(BigDecimal.ZERO) == 0) {
                    tradeHoldBean.setPercent("0.00%");
                } else {
                    tradeHoldBean.setPercent(m.Q(m.a(balanceDetailInfo.getEstimateAmount()).divide(m.a(balanceDataTotal.getNetAsset()), 32, 1).toPlainString(), 2, 1));
                }
            } else {
                tradeHoldBean.setAvailable("0.00");
                tradeHoldBean.setNetAsset("0.00");
                tradeHoldBean.setEstimateTotal("0.00");
                tradeHoldBean.setPercent("0.00%");
            }
            tradeHoldBean.setHead(getString(R.string.n_spot_current_symbol_asset));
            tradeHoldBean.setDisplayName(J.getBaseCurrencyDisplayName());
            tradeHoldBean.setFullDisplayName(d7.k.C().B(J.getBaseCurrency()));
            tradeHoldBean.setCurrencyInfo(balanceDetailInfo);
            arrayList.add(tradeHoldBean);
            BalanceDetailInfo balanceDetailInfo2 = detailInfoMap.get(J.getQuoteCurrency());
            TradeHoldBean tradeHoldBean2 = new TradeHoldBean();
            if (balanceDetailInfo2 != null) {
                tradeHoldBean2.setAvailable(p.j(balanceDetailInfo2.getAvaialAble(), J.getQuoteCurrency()));
                tradeHoldBean2.setNetAsset(p.j(balanceDetailInfo2.getNetBalance(), J.getQuoteCurrency()));
                tradeHoldBean2.setEstimateTotal(balanceDetailInfo2.getEstimateAmount());
                if (m.a(balanceDataTotal.getNetAsset()).compareTo(BigDecimal.ZERO) == 0) {
                    tradeHoldBean2.setPercent("0.00%");
                } else {
                    tradeHoldBean2.setPercent(m.Q(m.a(balanceDetailInfo2.getEstimateAmount()).divide(m.a(balanceDataTotal.getNetAsset()), 32, 1).toPlainString(), 2, 1));
                }
            } else {
                tradeHoldBean2.setAvailable("0.00");
                tradeHoldBean2.setNetAsset("0.00");
                tradeHoldBean2.setEstimateTotal("0.00");
                tradeHoldBean2.setPercent("0.00%");
            }
            tradeHoldBean2.setDisplayName(J.getQuoteCurrencyDisplayName());
            tradeHoldBean2.setFullDisplayName(d7.k.C().B(J.getQuoteCurrency()));
            tradeHoldBean2.setCurrencyInfo(balanceDetailInfo2);
            arrayList.add(tradeHoldBean2);
            if (!qt.y.a() && (detailInfos = balanceDataTotal.getDetailInfos()) != null) {
                Iterator<? extends BaseAssetInfo> it2 = detailInfos.iterator();
                while (it2.hasNext()) {
                    BalanceDetailInfo balanceDetailInfo3 = (BalanceDetailInfo) it2.next();
                    if (balanceDetailInfo3 != null && !J.getBaseCurrency().equalsIgnoreCase(balanceDetailInfo3.getCurrency()) && !J.getQuoteCurrency().equalsIgnoreCase(balanceDetailInfo3.getCurrency()) && !BaseAssetInfo.isMinAmountAsset(balanceDetailInfo3.getEstimateAmountToBtc())) {
                        TradeHoldBean tradeHoldBean3 = new TradeHoldBean();
                        tradeHoldBean3.setAvailable(p.j(balanceDetailInfo3.getAvaialAble(), J.getQuoteCurrency()));
                        tradeHoldBean3.setNetAsset(p.j(balanceDetailInfo3.getNetBalance(), J.getQuoteCurrency()));
                        tradeHoldBean3.setEstimateTotal(balanceDetailInfo3.getEstimateAmount());
                        if (m.a(balanceDataTotal.getNetAsset()).compareTo(BigDecimal.ZERO) == 0) {
                            tradeHoldBean3.setPercent("0.00%");
                        } else {
                            tradeHoldBean3.setPercent(m.Q(m.a(balanceDetailInfo3.getEstimateAmount()).divide(m.a(balanceDataTotal.getNetAsset()), 32, 1).toPlainString(), 2, 1));
                        }
                        tradeHoldBean3.setDisplayName(balanceDetailInfo3.getDisplayName());
                        tradeHoldBean3.setFullDisplayName(d7.k.C().B(balanceDetailInfo3.getCurrency()));
                        tradeHoldBean3.setCurrencyInfo(balanceDetailInfo3);
                        arrayList.add(tradeHoldBean3);
                    }
                }
                if (arrayList.size() >= 3) {
                    ((TradeHoldBean) arrayList.get(2)).setHead(getString(R.string.n_spot_other_symbol_more_than_zero_asset));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                TradeHoldBean tradeHoldBean4 = (TradeHoldBean) arrayList.get(i11);
                Log.d("现货", "资产 " + i11 + " =  " + tradeHoldBean4.getFullDisplayName() + Constants.ACCEPT_TIME_SEPARATOR_SP + tradeHoldBean4.getAvailable() + " " + com.hbg.module.libkt.base.ext.f.f(tradeHoldBean4));
                try {
                    if (new BigDecimal(tradeHoldBean4.getAvailable()).compareTo(BigDecimal.ZERO) > 0) {
                        Log.d("现货", "资产 " + i11 + " =  " + tradeHoldBean4.getFullDisplayName() + " > 0");
                        arrayList2.add(tradeHoldBean4);
                    }
                } catch (Exception e11) {
                    LogAndWoodRecorder.a("现货", "过滤0资产 " + tradeHoldBean4.getAvailable() + "转换异常:" + e11.getMessage());
                }
            }
            synchronized (this.D) {
                this.D.clear();
                this.D.addAll(arrayList2);
            }
        }
    }

    public final void z3(RemainingAmountBean remainingAmountBean) {
        this.A = remainingAmountBean;
        ((z4) getUI()).H2(remainingAmountBean);
    }
}
