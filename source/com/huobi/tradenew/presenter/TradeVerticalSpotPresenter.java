package com.huobi.tradenew.presenter;

import al.p;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.AccountRiskInfo;
import com.hbg.lib.network.hbg.core.bean.AssertsTradeData;
import com.hbg.lib.network.hbg.core.bean.BotRank;
import com.hbg.lib.network.hbg.core.bean.CurrencyAsset;
import com.hbg.lib.network.hbg.core.bean.EtpAvailableBean;
import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import com.hbg.lib.network.hbg.core.bean.PrimeKycLimit;
import com.hbg.lib.network.hbg.core.bean.RemainingAmountBean;
import com.hbg.lib.network.pro.core.bean.CallAuction;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.widgets.TopScrollData;
import com.huobi.account.entity.AccountType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.event.SymbolChangeEvent;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.trade.bean.TradeHoldBeanNew;
import com.huobi.trade.bean.TradeRefreshEvent;
import com.huobi.trade.helper.f0;
import com.huobi.trade.ui.ZoneReminderActivity;
import com.huobi.tradenew.prime.helper.TradeMarginHelper;
import com.huobi.tradenew.ui.a5;
import com.huobi.utils.SymbolUtil;
import com.tencent.ugc.videoprocessor.watermark.data.AnimatedPasterJsonConfig;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import dt.h2;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import qt.y;
import rt.a0;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import st.k0;
import st.l0;
import st.m0;
import st.o0;
import st.p0;
import st.q0;
import st.r0;
import st.s0;
import st.t0;
import st.w0;
import st.x0;
import st.y0;
import st.z0;
import tg.r;

public class TradeVerticalSpotPresenter extends TradeVerticalBasePresenter<a5> {
    public Subscriber<List<SymbolPrice>> M;
    public Subscription N;
    public Subscription O;
    public Subscription P;
    public Subscription Q;
    public Subscription R;
    public boolean S;
    public SymbolBean T;
    public SymbolBean U;
    public a0 V;
    public Subscriber<Long> W;
    public Subscriber<CallAuction> X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f82966a0;

    public class a implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82967b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Observable f82968c;

        /* renamed from: com.huobi.tradenew.presenter.TradeVerticalSpotPresenter$a$a  reason: collision with other inner class name */
        public class C0859a extends BaseSubscriber<BalanceDataTotal> {
            public C0859a() {
            }

            /* renamed from: a */
            public void onNext(BalanceDataTotal balanceDataTotal) {
                super.onNext(balanceDataTotal);
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter.f82876j.v0(tradeVerticalSpotPresenter.f82871e, tradeVerticalSpotPresenter.F, tradeVerticalSpotPresenter.f82880n);
                ((a5) TradeVerticalSpotPresenter.this.getUI()).W3();
                TradeVerticalSpotPresenter.this.A1();
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter2 = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter2.f82884r = true;
                tradeVerticalSpotPresenter2.a2();
            }

            public void onError(Throwable th2) {
                super.onError(th2);
                ((a5) TradeVerticalSpotPresenter.this.getUI()).W3();
            }
        }

        public a(boolean z11, Observable observable) {
            this.f82967b = z11;
            this.f82968c = observable;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ BalanceDataTotal c(BalanceDataTotal balanceDataTotal, List list) {
            TradeVerticalSpotPresenter.this.Q3(balanceDataTotal, list);
            return balanceDataTotal;
        }

        /* renamed from: b */
        public void call(Long l11) {
            Observable.zip(h2.t1().K1(this.f82967b).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())), this.f82968c, new x0(this)).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())).subscribe(new C0859a());
        }
    }

    public class b extends BaseSubscriber<Long> {
        public b() {
        }

        public void onNext(Long l11) {
            SymbolBean J = a1.v().J(TradeVerticalSpotPresenter.this.f82871e, TradeType.PRO);
            i6.d.b("CallAuction:" + System.currentTimeMillis() + "=====Ca1OpenAt:" + J.getCa1OpenAt() + "======isCallAuctionOne:" + J.isCallAuctionOne() + "====Ca2OpenAt:" + J.getCa2OpenAt() + "====CallAuctionTwo:" + J.isCallAuctionTwo());
            if (J.isCallAuctionOne()) {
                TradeVerticalSpotPresenter.this.y3();
            }
            if (J.isCallAuctionTwo()) {
                TradeVerticalSpotPresenter.this.A3();
            }
            TradeVerticalSpotPresenter.this.W3();
            TradeVerticalSpotPresenter.this.z3();
            if (System.currentTimeMillis() > J.getCa2CloseAt()) {
                TradeVerticalSpotPresenter.this.L3();
                ((a5) TradeVerticalSpotPresenter.this.getUI()).z1();
            }
        }
    }

    public class c extends BaseSubscriber<CallAuction> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(CallAuction callAuction) {
            ((a5) TradeVerticalSpotPresenter.this.getUI()).r(callAuction, TradeVerticalSpotPresenter.this.f82871e);
            TradeVerticalSpotPresenter.this.W3();
            if (callAuction.isContinuity()) {
                TradeVerticalSpotPresenter.this.J3();
                TradeVerticalSpotPresenter.this.L3();
            }
        }
    }

    public class d extends BaseSubscriber<CallAuction> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(CallAuction callAuction) {
            super.onNext(callAuction);
            TradeVerticalSpotPresenter.this.z0();
            TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
            tradeVerticalSpotPresenter.C0(tradeVerticalSpotPresenter.f82879m, false);
        }
    }

    public class e implements Action1<Long> {

        public class a extends BaseSubscriber<BotRank> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(BotRank botRank) {
                super.onNext(botRank);
                if (!TextUtils.isEmpty(botRank.getYieldRate())) {
                    ((a5) TradeVerticalSpotPresenter.this.getUI()).k0(i6.m.Q(botRank.getYieldRate(), 2, 1));
                }
            }
        }

        public e() {
        }

        /* renamed from: a */
        public void call(Long l11) {
            v7.b.a().I0().b().compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    public class f implements Action1<Long> {

        public class a extends BaseSubscriber<CurrencyAsset> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(CurrencyAsset currencyAsset) {
                Pair<String, String> O;
                Pair<String, String> O2;
                ut.o.C().r(currencyAsset);
                String a11 = SymbolUtil.a(TradeVerticalSpotPresenter.this.f82871e);
                HashMap hashMap = new HashMap(2);
                if (!TextUtils.isEmpty(a11) && (O2 = ut.o.C().O(a11)) != null && !TextUtils.isEmpty((CharSequence) O2.first)) {
                    hashMap.put(a11, (String) O2.first);
                }
                String b11 = SymbolUtil.b(TradeVerticalSpotPresenter.this.f82871e);
                if (!TextUtils.isEmpty(b11) && (O = ut.o.C().O(b11)) != null && !TextUtils.isEmpty((CharSequence) O.first)) {
                    hashMap.put(b11, (String) O.first);
                }
                if (TradeVerticalSpotPresenter.this.f82877k != null && !hashMap.isEmpty()) {
                    TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
                    tradeVerticalSpotPresenter.f82877k.g0(tradeVerticalSpotPresenter.f82880n, hashMap);
                }
                ((a5) TradeVerticalSpotPresenter.this.getUI()).f0(currencyAsset);
            }
        }

        public f() {
        }

        /* renamed from: a */
        public void call(Long l11) {
            v7.b.a().A0(TradeVerticalSpotPresenter.this.o0()).b().compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    public class g extends BaseSubscriber<List<SymbolBean>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82978b;

        public g(boolean z11) {
            this.f82978b = z11;
        }

        public void onAfter() {
            super.onAfter();
            ((a5) TradeVerticalSpotPresenter.this.getUI()).y0(true);
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            if (a1.v().H(TradeVerticalSpotPresenter.this.f82880n).contains(TradeVerticalSpotPresenter.this.f82871e)) {
                if (((a5) TradeVerticalSpotPresenter.this.getUI()).isCanBeSeen()) {
                    a1 v11 = a1.v();
                    TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
                    ((a5) TradeVerticalSpotPresenter.this.getUI()).t(v11.J(tradeVerticalSpotPresenter.f82871e, tradeVerticalSpotPresenter.f82880n));
                    ((a5) TradeVerticalSpotPresenter.this.getUI()).z1();
                    TradeVerticalSpotPresenter.this.B3();
                }
                TradeVerticalSpotPresenter.this.y1();
                TradeVerticalSpotPresenter.this.R1();
            } else {
                if (!a1.v().H(TradeVerticalSpotPresenter.this.f82880n).isEmpty()) {
                    TradeVerticalSpotPresenter.this.f82871e = a1.v().H(TradeVerticalSpotPresenter.this.f82880n).get(0);
                }
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter2 = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter2.G0(tradeVerticalSpotPresenter2.f82871e);
            }
            if (a1.v().L(TradeVerticalSpotPresenter.this.f82871e)) {
                if (r.x().F0()) {
                    ut.o C = ut.o.C();
                    TradeVerticalSpotPresenter tradeVerticalSpotPresenter3 = TradeVerticalSpotPresenter.this;
                    C.F(tradeVerticalSpotPresenter3.f82871e, (u6.g) tradeVerticalSpotPresenter3.getUI(), ((a5) TradeVerticalSpotPresenter.this.getUI()).r1());
                    TradeVerticalSpotPresenter tradeVerticalSpotPresenter4 = TradeVerticalSpotPresenter.this;
                    tradeVerticalSpotPresenter4.c1(false, tradeVerticalSpotPresenter4.f82871e, true);
                } else {
                    ut.o C2 = ut.o.C();
                    TradeVerticalSpotPresenter tradeVerticalSpotPresenter5 = TradeVerticalSpotPresenter.this;
                    C2.u0(tradeVerticalSpotPresenter5.f82871e, (u6.g) tradeVerticalSpotPresenter5.getUI(), ((a5) TradeVerticalSpotPresenter.this.getUI()).r1());
                }
            }
            if (this.f82978b) {
                TradeVerticalSpotPresenter.this.H3();
            }
        }
    }

    public class h extends BaseSubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SymbolBean f82980b;

        public h(SymbolBean symbolBean) {
            this.f82980b = symbolBean;
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            i6.d.b("open:" + this.f82980b.getTradeOpenAt() + "===current:" + System.currentTimeMillis() + "====diff:" + (this.f82980b.getTradeOpenAt() - System.currentTimeMillis()));
            if (this.f82980b.getTradeOpenAt() - System.currentTimeMillis() <= -1000) {
                TradeVerticalSpotPresenter.this.d3(false);
                TradeVerticalSpotPresenter.this.O3();
            }
        }
    }

    public class i extends BaseSubscriber<PrimeKycLimit> {
        public i() {
        }

        /* renamed from: a */
        public void onNext(PrimeKycLimit primeKycLimit) {
            super.onNext(primeKycLimit);
            if (primeKycLimit.getBlackKycType() == 2 || primeKycLimit.getBlackKycType() == 1) {
                ((a5) TradeVerticalSpotPresenter.this.getUI()).u1();
            } else {
                ((a5) TradeVerticalSpotPresenter.this.getUI()).p1(primeKycLimit);
            }
        }
    }

    public class j extends BaseSubscriber<Long> {

        public class a extends BaseSubscriber<EtpRebalInfo> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(EtpRebalInfo etpRebalInfo) {
                super.onNext(etpRebalInfo);
                TradeVerticalSpotPresenter.this.b2();
                ArrayList arrayList = new ArrayList();
                TopScrollData topScrollData = new TopScrollData();
                topScrollData.l(TradeVerticalSpotPresenter.this.getActivity().getString(R.string.n_trade_etp_carousel_time));
                topScrollData.m(DateTimeUtils.x(etpRebalInfo.getRebalTime().longValue()));
                topScrollData.k(0);
                arrayList.add(topScrollData);
                if (etpRebalInfo.getOptionState() == EtpRebalInfo.OPTION_STATE_NORMAL) {
                    TopScrollData topScrollData2 = new TopScrollData();
                    topScrollData2.l(TradeVerticalSpotPresenter.this.getActivity().getString(R.string.n_trade_etp_carousel_nav));
                    topScrollData2.m(i6.m.m(String.valueOf(etpRebalInfo.getRebalNav()), PrecisionUtil.e(TradeVerticalSpotPresenter.this.f82871e)) + " " + StringUtils.i(TradeVerticalSpotPresenter.this.S0()));
                    topScrollData2.k(1);
                    arrayList.add(topScrollData2);
                }
                TopScrollData topScrollData3 = new TopScrollData();
                topScrollData3.l(String.format(Locale.ENGLISH, TradeVerticalSpotPresenter.this.getActivity().getString(R.string.n_trade_etp_carousel_chargeFee), new Object[]{DateTimeUtils.A(etpRebalInfo.getChargeFeeTime())}));
                topScrollData3.m(i6.m.a(etpRebalInfo.getChargeFee()).setScale(4, 1).stripTrailingZeros().toPlainString() + "%");
                topScrollData3.k(2);
                arrayList.add(topScrollData3);
                ((a5) TradeVerticalSpotPresenter.this.getUI()).V(arrayList, TradeVerticalSpotPresenter.this.S ^ true, false, 0);
                boolean unused = TradeVerticalSpotPresenter.this.S = true;
            }
        }

        public j() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            x7.d.c(TradeVerticalSpotPresenter.this.I0(), false).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    public class k extends BaseSubscriber<List<SymbolPrice>> {
        public k() {
        }

        public void onNext(List<SymbolPrice> list) {
            super.onNext(list);
            if (list != null && !list.isEmpty()) {
                TradeVerticalSpotPresenter.this.T3(list.get(0));
            }
        }
    }

    public class l extends BaseSubscriber<List<SymbolBean>> {
        public l() {
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
            tradeVerticalSpotPresenter.G0(tradeVerticalSpotPresenter.f82871e);
        }
    }

    public class m implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82987b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Observable f82988c;

        public class a extends BaseSubscriber<String> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(String str) {
                super.onNext(str);
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter.f82884r = true;
                tradeVerticalSpotPresenter.X3(str);
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter2 = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter2.f82876j.v0(tradeVerticalSpotPresenter2.f82871e, tradeVerticalSpotPresenter2.F, tradeVerticalSpotPresenter2.f82880n);
                ((a5) TradeVerticalSpotPresenter.this.getUI()).W3();
                TradeVerticalSpotPresenter.this.A1();
            }
        }

        public m(boolean z11, Observable observable) {
            this.f82987b = z11;
            this.f82988c = observable;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ String c(BalanceDataTotal balanceDataTotal, String str, List list) {
            TradeVerticalSpotPresenter.this.Q3(balanceDataTotal, list);
            return str;
        }

        /* renamed from: b */
        public void call(Long l11) {
            Observable.zip(h2.t1().K1(this.f82987b).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())), ut.o.C().H().compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())), this.f82988c, new y0(this)).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    public class n implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82991b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Observable f82992c;

        public class a extends BaseSubscriber<RemainingAmountBean> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(RemainingAmountBean remainingAmountBean) {
                super.onNext(remainingAmountBean);
                i6.k.o("TRADE_SPOT", "观察区资产获取成功");
                TradeVerticalSpotPresenter.this.U3(remainingAmountBean);
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter.f82876j.v0(tradeVerticalSpotPresenter.f82871e, tradeVerticalSpotPresenter.F, tradeVerticalSpotPresenter.f82880n);
                ((a5) TradeVerticalSpotPresenter.this.getUI()).W3();
                TradeVerticalSpotPresenter.this.A1();
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter2 = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter2.f82884r = true;
                tradeVerticalSpotPresenter2.a2();
            }

            public void onAfter() {
                super.onAfter();
            }

            public void onError(Throwable th2) {
                super.onError(th2);
                TradeVerticalSpotPresenter.this.U3((RemainingAmountBean) null);
                ((a5) TradeVerticalSpotPresenter.this.getUI()).b3();
            }
        }

        public n(boolean z11, Observable observable) {
            this.f82991b = z11;
            this.f82992c = observable;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ RemainingAmountBean c(BalanceDataTotal balanceDataTotal, RemainingAmountBean remainingAmountBean, List list) {
            TradeVerticalSpotPresenter.this.Q3(balanceDataTotal, list);
            return remainingAmountBean;
        }

        /* renamed from: b */
        public void call(Long l11) {
            Observable.zip(h2.t1().K1(this.f82991b).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())), v7.b.a().getRemainingAmount(a1.v().n(TradeVerticalSpotPresenter.this.f82871e)).b(), this.f82992c, new z0(this)).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    public class o implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82995b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Observable f82996c;

        public class a extends BaseSubscriber<EtpAvailableBean> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(EtpAvailableBean etpAvailableBean) {
                super.onNext(etpAvailableBean);
                TradeVerticalSpotPresenter.this.R3(etpAvailableBean);
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter.f82876j.v0(tradeVerticalSpotPresenter.f82871e, tradeVerticalSpotPresenter.F, tradeVerticalSpotPresenter.f82880n);
                ((a5) TradeVerticalSpotPresenter.this.getUI()).W3();
                TradeVerticalSpotPresenter.this.A1();
                TradeVerticalSpotPresenter tradeVerticalSpotPresenter2 = TradeVerticalSpotPresenter.this;
                tradeVerticalSpotPresenter2.f82884r = true;
                tradeVerticalSpotPresenter2.a2();
            }

            public void onAfter() {
                super.onAfter();
            }

            public void onError(Throwable th2) {
                super.onError(th2);
                TradeVerticalSpotPresenter.this.R3((EtpAvailableBean) null);
                ((a5) TradeVerticalSpotPresenter.this.getUI()).b3();
            }
        }

        public o(boolean z11, Observable observable) {
            this.f82995b = z11;
            this.f82996c = observable;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ EtpAvailableBean c(BalanceDataTotal balanceDataTotal, EtpAvailableBean etpAvailableBean, List list) {
            TradeVerticalSpotPresenter.this.Q3(balanceDataTotal, list);
            return etpAvailableBean;
        }

        /* renamed from: b */
        public void call(Long l11) {
            Observable.zip(h2.t1().K1(this.f82995b).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())), v7.b.a().getEtpAvailableAmount(a1.v().n(TradeVerticalSpotPresenter.this.f82871e)).b(), this.f82996c, new st.a1(this)).compose(RxJavaHelper.t((u6.g) TradeVerticalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean f3(List list) {
        String A = a1.v().A(this.f82871e);
        return Boolean.valueOf("innovation".equals(A) || "bifurcation".equals(A) || SymbolBean.POTENTIALS.equals(A) || "profession".equals(A));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable g3(List list) {
        String A = a1.v().A(this.f82871e);
        this.f82885s = "NEW_ZONE";
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
                this.f82885s = "PRO_ZONE";
                break;
            case 1:
                this.f82885s = "POTENTIALS";
                break;
            case 2:
                this.f82885s = "FORK_ZONE";
                break;
            case 3:
                this.f82885s = "NEW_ZONE";
                break;
        }
        return UserCenterRemoteDataSource.A().requestLicenseState(this.f82885s, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h3(TradeRiskReminder tradeRiskReminder) {
        if (h1()) {
            qt.g.a().f(tradeRiskReminder.getState());
        } else if ("0".equals(tradeRiskReminder.getState())) {
            getActivity().startActivity(new Intent(getActivity(), ZoneReminderActivity.class).putExtra("zone_reminder_type", this.f82885s));
        }
    }

    public static /* synthetic */ AccountRiskInfo i3(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List j3(List list, AccountRiskInfo accountRiskInfo) {
        if (accountRiskInfo != null) {
            h2.t1().J3(accountRiskInfo);
        }
        return list;
    }

    public static /* synthetic */ List l3(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable m3(Long l11) {
        return ys.a.c(this.f82871e);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable o3(Map map, Long l11) {
        return this.f82877k.x(map);
    }

    public static /* synthetic */ Boolean q3(List list) {
        return Boolean.valueOf(list != null);
    }

    public static /* synthetic */ int t3(SymbolBean symbolBean, SymbolBean symbolBean2) {
        return i6.m.a(symbolBean2.getEtpLeverageRatio()).abs().intValue() - i6.m.a(symbolBean.getEtpLeverageRatio()).abs().intValue();
    }

    public void A3() {
        SymbolBean J = a1.v().J(this.f82871e, TradeType.PRO);
        if (!this.Z) {
            I3();
            this.Z = true;
            long ca2CloseAt = J.getCa2CloseAt() - System.currentTimeMillis();
            X1();
            ((a5) getUI()).z1();
            ((a5) getUI()).E(2, ca2CloseAt);
        }
    }

    public final void B3() {
        SymbolBean J = a1.v().J(this.f82871e, this.f82880n);
        L3();
        if (J != null && !(J.getCa1OpenAt() == 0 && J.getCa2OpenAt() == 0) && System.currentTimeMillis() < J.getCa2CloseAt()) {
            this.W = Y2();
            Observable.interval(0, 1000, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.W);
        }
    }

    public final void C3() {
        Subscription subscription = this.Q;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        if (a1.v().p0(this.f82871e)) {
            this.S = false;
            if (a1.v().p0(this.f82871e)) {
                this.Q = Observable.interval(0, 5000, TimeUnit.MILLISECONDS).subscribe(new j());
            }
        }
    }

    public void D3() {
        M3();
        this.R = Observable.interval(0, 5000, TimeUnit.MILLISECONDS).doOnNext(new f()).subscribe(new BaseSubscriber());
    }

    public void E3() {
        N3();
        this.N = Observable.interval(0, 5, TimeUnit.MINUTES).doOnNext(new e()).subscribe(new BaseSubscriber());
    }

    public final void F3() {
        Subscriber<List<SymbolPrice>> subscriber = this.M;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.M = Z2();
        Observable.interval(0, 15, TimeUnit.SECONDS).flatMap(new s0(this, MapParamsBuilder.c().a("symbol", "hb10").a(AnimatedPasterJsonConfig.CONFIG_PERIOD, "15min").a("limit", "1").b())).filter(w0.f29250b).compose(RxJavaHelper.t((u6.g) getUI())).retryWhen(m0.f29227b).subscribe(this.M);
    }

    public final void H3() {
        O3();
        SymbolBean J = a1.v().J(this.f82871e, this.f82880n);
        if (J != null && SymbolBean.PRE_ONLINE.equals(J.getState())) {
            if (J.getTradeOpenAt() - System.currentTimeMillis() > 0) {
                this.P = Observable.interval(0, 1, TimeUnit.SECONDS).subscribe(new h(J));
            } else {
                d3(false);
            }
        }
    }

    public void I3() {
        qt.l.h().o();
        this.Y = false;
    }

    public final void J3() {
        Subscriber<CallAuction> subscriber = this.X;
        if (subscriber != null) {
            this.f82966a0 = false;
            subscriber.unsubscribe();
        }
    }

    public void K3() {
        this.Z = false;
        qt.l.h().o();
    }

    public final void L3() {
        Subscriber<Long> subscriber = this.W;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void M3() {
        Subscription subscription = this.R;
        if (subscription != null) {
            if (!subscription.isUnsubscribed()) {
                this.R.unsubscribe();
            }
            this.R = null;
        }
    }

    public final void N3() {
        Subscription subscription = this.N;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void O3() {
        Subscription subscription = this.P;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void P3() {
        this.V.m(this.T);
        this.V.n(this.U);
    }

    public final void Q3(BalanceDataTotal balanceDataTotal, List<AssertsTradeData> list) {
        String str;
        BalanceDetailInfo balanceDetailInfo;
        if (list == null || list.isEmpty()) {
            synchronized (this.F) {
                this.F.clear();
            }
            return;
        }
        Map<String, BalanceDetailInfo> detailInfoMap = balanceDataTotal.getDetailInfoMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String str2 = null;
        if (!TextUtils.isEmpty(this.f82871e)) {
            str2 = SymbolUtil.a(this.f82871e);
            str = SymbolUtil.b(this.f82871e);
        } else {
            str = null;
        }
        for (AssertsTradeData next : list) {
            if (!(detailInfoMap == null || (balanceDetailInfo = detailInfoMap.get(next.getCurrency())) == null)) {
                TradeHoldBeanNew tradeHoldBeanNew = new TradeHoldBeanNew();
                tradeHoldBeanNew.setCurrency(next.getCurrency());
                tradeHoldBeanNew.setDisplayName(balanceDetailInfo.getDisplayName());
                tradeHoldBeanNew.setFullDisplayName(d7.k.C().B(balanceDetailInfo.getCurrency()));
                int p11 = d7.k.C().p(next.getCurrency());
                String i11 = p.i(next.getHoldBalance(), p11);
                tradeHoldBeanNew.setHold(i11);
                tradeHoldBeanNew.setDebts(p.i(next.getDebts(), p11));
                tradeHoldBeanNew.setSpotBalance(p.i(next.getSpotBalance(), p11));
                if (TextUtils.isEmpty(next.getMarketBuy())) {
                    tradeHoldBeanNew.setPrice("0.00");
                } else if (i6.m.a0(next.getMarketBuy())) {
                    tradeHoldBeanNew.setPrice(LegalCurrencyConfigUtil.C(next.getMarketBuy(), LegalCurrencyConfigUtil.y()));
                } else {
                    tradeHoldBeanNew.setPrice("0.00");
                }
                if (TextUtils.isEmpty(next.getCost())) {
                    tradeHoldBeanNew.setCost("0.00");
                } else if (i6.m.a0(next.getCost())) {
                    tradeHoldBeanNew.setCost(LegalCurrencyConfigUtil.C(next.getCost(), LegalCurrencyConfigUtil.y()));
                } else {
                    tradeHoldBeanNew.setCost("0.00");
                }
                if (TextUtils.isEmpty(next.getProfit())) {
                    tradeHoldBeanNew.setProfit("0.00");
                } else if (i6.m.a0(next.getProfit())) {
                    tradeHoldBeanNew.setProfit(LegalCurrencyConfigUtil.E("usdt", next.getProfit()));
                } else {
                    tradeHoldBeanNew.setProfit("0.00");
                }
                tradeHoldBeanNew.setProfitRatio(next.getProfitRate());
                if (TextUtils.isEmpty(next.getConvertBalance())) {
                    tradeHoldBeanNew.setEstimateTotal("0.00");
                } else {
                    tradeHoldBeanNew.setEstimateTotal(LegalCurrencyConfigUtil.E(tradeHoldBeanNew.getCurrency(), i11));
                }
                if (next.getProportion() == 0.0d) {
                    tradeHoldBeanNew.setPercent("0.00%");
                } else {
                    tradeHoldBeanNew.setPercent(BigDecimal.valueOf(next.getProportion()).setScale(2, 1).toPlainString() + "%");
                }
                tradeHoldBeanNew.setCurrencyInfo(balanceDetailInfo);
                if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(tradeHoldBeanNew.getCurrency())) {
                    if (arrayList2.isEmpty()) {
                        tradeHoldBeanNew.setShowTitle(1);
                    } else {
                        tradeHoldBeanNew.setShowTitle(0);
                    }
                    arrayList2.add(tradeHoldBeanNew);
                } else if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase(tradeHoldBeanNew.getCurrency())) {
                    if (arrayList.isEmpty()) {
                        tradeHoldBeanNew.setShowTitle(2);
                    } else {
                        tradeHoldBeanNew.setShowTitle(0);
                    }
                    arrayList.add(tradeHoldBeanNew);
                } else {
                    if (arrayList2.isEmpty()) {
                        tradeHoldBeanNew.setShowTitle(1);
                    } else {
                        tradeHoldBeanNew.setShowTitle(0);
                    }
                    arrayList2.add(tradeHoldBeanNew);
                }
            }
        }
        synchronized (this.F) {
            this.F.clear();
            if (!arrayList2.isEmpty()) {
                this.F.addAll(arrayList2);
            }
            this.F.addAll(arrayList);
        }
    }

    public final void R3(EtpAvailableBean etpAvailableBean) {
        this.B = etpAvailableBean;
        ((a5) getUI()).og(etpAvailableBean);
    }

    public final void S3() {
        this.T = null;
        this.U = null;
        if (a1.v().p0(this.f82871e)) {
            ((a5) getUI()).O("", "", "", "", "", "", 8);
            return;
        }
        List<SymbolBean> q11 = a1.v().q(I0());
        if (q11 == null || q11.isEmpty()) {
            ((a5) getUI()).O("", "", "", "", "", "", 8);
            return;
        }
        Collections.sort(q11, k0.f29223b);
        SymbolBean symbolBean = q11.get(0);
        if (i6.m.a(symbolBean.getEtpLeverageRatio()).abs().intValue() == 1) {
            ((a5) getUI()).O("", "", "", "", "", "", 8);
        } else if (q11.size() > 1) {
            SymbolBean symbolBean2 = q11.get(1);
            if (i6.m.a(symbolBean.getEtpLeverageRatio()).abs().intValue() != i6.m.a(symbolBean2.getEtpLeverageRatio()).abs().intValue() || symbolBean.getDirection().equals(symbolBean2.getDirection())) {
                Y3(symbolBean);
                return;
            }
            if ("1".equals(symbolBean.getDirection())) {
                this.T = symbolBean;
                this.U = symbolBean2;
            } else {
                this.T = symbolBean2;
                this.U = symbolBean;
            }
            ((a5) getUI()).O(this.T.getDirection(), this.U.getDirection(), this.T.getBaseCurrencyDisplayName(), this.U.getBaseCurrencyDisplayName(), f0.d(getActivity(), this.T.getDirection(), this.T.getEtpLeverageRatio()), f0.d(getActivity(), this.U.getDirection(), this.U.getEtpLeverageRatio()), 0);
            this.V.g(this.T);
            this.V.h(this.U);
        } else {
            Y3(symbolBean);
        }
    }

    public void T1() {
        super.T1();
        if (a1.v().S(this.f82871e)) {
            ((a5) getUI()).W1(8);
        } else if (r.x().F0()) {
            ((a5) getUI()).D1(0);
            if (this.f82888v == -1) {
                ((a5) getUI()).W1(8);
            } else {
                ((a5) getUI()).W1(0);
            }
        } else {
            ((a5) getUI()).D1(8);
            ((a5) getUI()).W1(8);
        }
    }

    public void T3(SymbolPrice symbolPrice) {
        String str;
        if (symbolPrice == null) {
            str = String.format(Locale.US, getString(R.string.trade_hb_value), new Object[]{"--"});
        } else {
            String m11 = i6.m.m(String.valueOf(symbolPrice.getClose()), PrecisionUtil.e(this.f82871e));
            str = String.format(Locale.US, getString(R.string.trade_hb_value), new Object[]{m11});
        }
        this.f82875i.Y(str);
    }

    public final void U3(RemainingAmountBean remainingAmountBean) {
        this.A = remainingAmountBean;
        ((a5) getUI()).H2(remainingAmountBean);
    }

    public void V() {
        EventBus.d().r(this);
        super.V();
    }

    public void V2() {
        SymbolBean symbolBean = this.T;
        if (symbolBean != null) {
            A0(symbolBean.getSymbol());
        }
    }

    public final void V3() {
        if (a1.v().k0(this.f82871e)) {
            this.f82875i.Y(String.format(Locale.US, getString(R.string.trade_hb_value), new Object[]{"--"}));
        } else {
            this.f82875i.Y("");
        }
        ((a5) getUI()).q3(a1.v().k0(this.f82871e));
    }

    public void W2() {
        SymbolBean symbolBean = this.U;
        if (symbolBean != null) {
            A0(symbolBean.getSymbol());
        }
    }

    public final void W3() {
        SymbolBean J = a1.v().J(this.f82871e, TradeType.PRO);
        if (J == null) {
            return;
        }
        if (J.isCallAuction()) {
            ((a5) getUI()).o(true);
        } else {
            ((a5) getUI()).o(false);
        }
    }

    public final Subscriber<CallAuction> X2() {
        return new c();
    }

    public void X3(String str) {
        this.f82877k.w(this.f82880n, this.f82871e, e1());
        a2();
        ((a5) getUI()).x3(str);
    }

    public void Y1() {
        super.Y1();
        boolean F0 = r.x().F0();
        if (a1.v().S(this.f82871e)) {
            if (ut.o.C().T()) {
                ((a5) getUI()).D1(8);
            } else if (F0) {
                ((a5) getUI()).D1(0);
            } else {
                ((a5) getUI()).D1(8);
            }
        } else if (F0) {
            int i11 = this.f82888v;
            if (i11 == -1 || i11 == 0) {
                ((a5) getUI()).D1(8);
            } else {
                ((a5) getUI()).D1(0);
            }
        } else {
            ((a5) getUI()).D1(8);
        }
    }

    public final Subscriber<Long> Y2() {
        return new b();
    }

    public final void Y3(SymbolBean symbolBean) {
        this.T = symbolBean;
        ((a5) getUI()).O(this.T.getDirection(), "", this.T.getBaseCurrencyDisplayName(), "", f0.d(getActivity(), this.T.getDirection(), this.T.getEtpLeverageRatio()), "", 0);
        this.V.g(this.T);
    }

    public void Z1() {
        if (!a1.v().L(this.f82871e)) {
            return;
        }
        if (r.x().F0()) {
            ut.o.C().F(this.f82871e, (u6.g) getUI(), ((a5) getUI()).r1());
        } else {
            ut.o.C().u0(this.f82871e, (u6.g) getUI(), ((a5) getUI()).r1());
        }
    }

    public Subscriber<List<SymbolPrice>> Z2() {
        return new k();
    }

    public String a3(String str) {
        Pair<String, String> O2 = ut.o.C().O(str);
        if (O2 == null || TextUtils.isEmpty((CharSequence) O2.second)) {
            return "--";
        }
        return i6.m.m((String) O2.second, PrecisionUtil.a(Z0(), str));
    }

    @k20.h
    @Keep
    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        if (((a5) getUI()).isCanBeSeen()) {
            if (symbolChangeEvent.f() || !symbolChangeEvent.b().equals(this.f82871e)) {
                super.afterSymbolIdChanged(symbolChangeEvent);
                V3();
                if (!this.f82871e.contains("hb10")) {
                    ((a5) getUI()).I(8);
                    Subscriber<List<SymbolPrice>> subscriber = this.M;
                    if (subscriber != null) {
                        subscriber.unsubscribe();
                    }
                } else {
                    F3();
                    ((a5) getUI()).I(0);
                }
                Z1();
                boolean F0 = r.x().F0();
                if (a1.v().S(this.f82871e)) {
                    b3();
                } else {
                    ((a5) getUI()).w1();
                    ((a5) getUI()).o1();
                }
                T1();
                Y1();
                W3();
                ((a5) getUI()).z1();
                B3();
                z3();
                if (F0) {
                    c3();
                } else {
                    ut.o.C().y0((String) null);
                }
                x3();
                H3();
                e3(true);
                C3();
                P3();
                S3();
            }
        }
    }

    public final void b3() {
        if (r.x().F0()) {
            v7.b.a().getKycLimit().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new i());
        }
    }

    public void c1(boolean z11, String str, boolean z12) {
        if (!r.x().F0()) {
            U3((RemainingAmountBean) null);
            R3((EtpAvailableBean) null);
            return;
        }
        if (z12) {
            TradeMarginHelper.b().e("--");
            TradeMarginHelper.b().g("--");
            ((a5) getUI()).b3();
        }
        D3();
        Subscription subscription = this.O;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<List<AssertsTradeData>> w32 = w3(str);
        if (a1.v().S(str)) {
            this.O = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new m(z11, w32)).subscribe(new BaseSubscriber());
        } else if (h1()) {
            this.O = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new n(z11, w32)).subscribe(new BaseSubscriber());
        } else if (f1()) {
            this.O = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new o(z11, w32)).subscribe(new BaseSubscriber());
        } else {
            this.O = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new a(z11, w32)).subscribe(new BaseSubscriber());
        }
    }

    public final void c3() {
        if (!r.x().X()) {
            a1.v().Y(true, false).filter(new q0(this)).flatMap(new r0(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new o0(this)));
        }
    }

    public void d3(boolean z11) {
        a1.v().Y(false, true).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g(z11));
    }

    public final void e3(boolean z11) {
        ArrayList arrayList = new ArrayList();
        TopScrollData topScrollData = new TopScrollData();
        topScrollData.l(getActivity().getString(R.string.n_trade_etp_carousel_time));
        topScrollData.m("--");
        int i11 = 0;
        topScrollData.k(0);
        TopScrollData topScrollData2 = new TopScrollData();
        topScrollData2.l(getActivity().getString(R.string.n_trade_etp_carousel_nav));
        topScrollData2.m("--");
        topScrollData2.k(1);
        TopScrollData topScrollData3 = new TopScrollData();
        topScrollData3.l(String.format(Locale.ENGLISH, getActivity().getString(R.string.n_trade_etp_carousel_chargeFee), new Object[]{"--"}));
        topScrollData3.m("--");
        topScrollData3.k(2);
        arrayList.add(topScrollData3);
        arrayList.add(topScrollData);
        arrayList.add(topScrollData2);
        if (!a1.v().p0(this.f82871e)) {
            i11 = 8;
        }
        ((a5) getUI()).V(arrayList, true, z11, i11);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onChangeMarginEvent(nt.a aVar) {
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
        a1.v().Y(false, true).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new l());
    }

    public void t0() {
        super.t0();
        ut.o.C().v();
        Subscriber<List<SymbolPrice>> subscriber = this.M;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        Subscription subscription = this.O;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.Q;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        L3();
        J3();
        I3();
        K3();
        O3();
        P3();
        N3();
        M3();
    }

    /* renamed from: u3 */
    public void u1(BaseCoreActivity baseCoreActivity, a5 a5Var) {
        super.onUIReady(baseCoreActivity, a5Var);
        this.f82888v = -1;
        this.V = new a0((a0.e) getUI(), baseCoreActivity);
        EventBus.d().p(this);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void updateTradeOrderTabLayout(ws.h hVar) {
        ((a5) getUI()).ld(hVar);
    }

    public void v0() {
        super.v0();
        boolean F0 = r.x().F0();
        d3(true);
        if (a1.v().S(this.f82871e)) {
            b3();
            if (ut.o.C().T()) {
                ((a5) getUI()).D1(8);
            } else if (F0) {
                ((a5) getUI()).D1(0);
            } else {
                ((a5) getUI()).D1(8);
            }
        } else {
            ((a5) getUI()).o1();
            ((a5) getUI()).w1();
            if (F0) {
                ((a5) getUI()).D1(0);
            } else {
                ((a5) getUI()).D1(8);
            }
        }
        T1();
        Y1();
        v3();
        W3();
        ((a5) getUI()).z1();
        B3();
        z3();
        if (F0) {
            c3();
            V0();
        } else {
            ut.o.C().y0((String) null);
            qt.g.a().g((String) null);
        }
        d7.k.C().U(true, (RequestCallback1<List<CurrencyBean>>) null);
        V3();
        e3(false);
        if (this.f82871e.contains("hb10")) {
            F3();
            ((a5) getUI()).I(0);
        } else {
            ((a5) getUI()).I(8);
        }
        x3();
        C3();
        c1(false, this.f82871e, true);
        S3();
        if (!AppLanguageHelper.getInstance().isChineseLanguage()) {
            E3();
        }
    }

    public final void v3() {
        SymbolBean J = a1.v().J(this.f82871e, this.f82880n);
        if (J != null && J.getCa1OpenAt() != 0) {
            ys.a.c(this.f82871e).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
        }
    }

    public void w1() {
        d3(true);
    }

    public final Observable<List<AssertsTradeData>> w3(String str) {
        String str2;
        String a11 = SymbolUtil.a(str);
        String b11 = SymbolUtil.b(str);
        if (this.f82880n != TradeType.PRO) {
            str2 = a11 + Constants.ACCEPT_TIME_SEPARATOR_SP + b11;
        } else if (y.b()) {
            str2 = a11 + Constants.ACCEPT_TIME_SEPARATOR_SP + b11;
        } else {
            str2 = null;
        }
        return h2.t1().b1(this.f82880n, AccountType.spot.toString()).flatMap(new t0(str2)).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public final void x3() {
        String str = "";
        if (qt.r.b()) {
            SymbolBean J = a1.v().J(this.f82871e, TradeType.PRO);
            int i11 = 8;
            if (J != null && gj.d.n().G()) {
                TradeType k11 = com.huobi.utils.k0.k();
                String leverageRatio = J.getLeverageRatio();
                String superMarginLeverageRatio = J.getSuperMarginLeverageRatio();
                if (k11 != null) {
                    TradeType tradeType = TradeType.MARGIN;
                    if (k11 == tradeType) {
                        if (!TextUtils.isEmpty(leverageRatio)) {
                            str = leverageRatio + "X";
                        } else if (!TextUtils.isEmpty(superMarginLeverageRatio)) {
                            str = superMarginLeverageRatio + "X";
                            com.huobi.utils.k0.F(TradeType.SUPERMARGIN);
                        }
                    } else if (k11 == TradeType.SUPERMARGIN) {
                        if (!TextUtils.isEmpty(superMarginLeverageRatio)) {
                            str = superMarginLeverageRatio + "X";
                        } else if (!TextUtils.isEmpty(leverageRatio)) {
                            str = leverageRatio + "X";
                            com.huobi.utils.k0.F(tradeType);
                        }
                    }
                } else if (!TextUtils.isEmpty(leverageRatio) || !TextUtils.isEmpty(superMarginLeverageRatio)) {
                    if (i6.m.a(leverageRatio).compareTo(i6.m.a(superMarginLeverageRatio)) > 0) {
                        com.huobi.utils.k0.F(TradeType.MARGIN);
                        str = leverageRatio + "X";
                    } else {
                        com.huobi.utils.k0.F(TradeType.SUPERMARGIN);
                        str = superMarginLeverageRatio + "X";
                    }
                }
                i11 = 0;
            }
            ((a5) getUI()).p(i11, str);
            return;
        }
        SymbolBean J2 = a1.v().J(this.f82871e, this.f82880n);
        if (J2 == null) {
            ((a5) getUI()).qc(str);
        } else if (TextUtils.isEmpty(J2.getLeverageRatio())) {
            ((a5) getUI()).qc(str);
        } else {
            ((a5) getUI()).qc(J2.getLeverageRatio() + "X");
        }
    }

    public void y3() {
        SymbolBean J = a1.v().J(this.f82871e, TradeType.PRO);
        if (!this.Y) {
            this.Y = true;
            ((a5) getUI()).z1();
            ((a5) getUI()).E(1, J.getCa1CloseAt() - System.currentTimeMillis());
        }
    }

    public final void z3() {
        SymbolBean J = a1.v().J(this.f82871e, this.f82880n);
        if (J != null && J.isCallAuction() && !this.f82966a0) {
            this.f82966a0 = true;
            this.X = X2();
            Observable.interval(0, 5, TimeUnit.SECONDS).flatMap(new p0(this)).retryWhen(l0.f29225b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.X);
        }
    }
}
