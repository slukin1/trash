package com.huobi.tradenew.presenter;

import al.p;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.core.bean.AssertsTradeData;
import com.hbg.lib.network.hbg.core.bean.BotRank;
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
import com.huobi.event.SymbolChangeEvent;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.trade.bean.TradeHoldBean;
import com.huobi.trade.bean.TradeRefreshEvent;
import com.huobi.trade.ui.ZoneReminderActivity;
import com.huobi.tradenew.ui.y1;
import com.huobi.utils.SymbolUtil;
import com.huobi.utils.k0;
import com.tencent.ugc.videoprocessor.watermark.data.AnimatedPasterJsonConfig;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import dt.h2;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rt.a0;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import st.b0;
import st.c0;
import st.d0;
import st.e0;
import st.f0;
import st.g0;
import st.q;
import st.s;
import st.t;
import st.u;
import st.v;
import st.w;
import st.x;
import st.y;
import st.z;
import tg.r;
import ut.o;

public class TradeHorizontalSpotPresenter extends TradeHorizontalBasePresenter<y1> {
    public Subscriber<List<SymbolPrice>> J;
    public Subscription K;
    public Subscription L;
    public Subscription M;
    public Subscription N;
    public boolean O;
    public SymbolBean P;
    public SymbolBean Q;
    public a0 R;
    public Subscriber<Long> S;
    public Subscriber<CallAuction> T;
    public boolean U;
    public boolean V;
    public boolean W;

    public class a implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82925b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Observable f82926c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f82927d;

        /* renamed from: com.huobi.tradenew.presenter.TradeHorizontalSpotPresenter$a$a  reason: collision with other inner class name */
        public class C0858a extends BaseSubscriber<BalanceDataTotal> {
            public C0858a() {
            }

            /* renamed from: a */
            public void onNext(BalanceDataTotal balanceDataTotal) {
                super.onNext(balanceDataTotal);
                a aVar = a.this;
                String str = aVar.f82927d;
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter = TradeHorizontalSpotPresenter.this;
                ((y1) TradeHorizontalSpotPresenter.this.getUI()).t8(str, tradeHorizontalSpotPresenter.f82877k.D(tradeHorizontalSpotPresenter.f82880n, str, true));
                a aVar2 = a.this;
                String str2 = aVar2.f82927d;
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter2 = TradeHorizontalSpotPresenter.this;
                ((y1) TradeHorizontalSpotPresenter.this.getUI()).xg(str2, tradeHorizontalSpotPresenter2.f82877k.D(tradeHorizontalSpotPresenter2.f82880n, str2, false));
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter3 = TradeHorizontalSpotPresenter.this;
                tradeHorizontalSpotPresenter3.f82876j.v0(tradeHorizontalSpotPresenter3.f82871e, tradeHorizontalSpotPresenter3.F, tradeHorizontalSpotPresenter3.f82880n);
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter4 = TradeHorizontalSpotPresenter.this;
                tradeHorizontalSpotPresenter4.f82884r = true;
                tradeHorizontalSpotPresenter4.a2();
            }
        }

        public a(boolean z11, Observable observable, String str) {
            this.f82925b = z11;
            this.f82926c = observable;
            this.f82927d = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(BalanceDataTotal balanceDataTotal) {
            TradeHorizontalSpotPresenter.this.o3(balanceDataTotal);
        }

        public static /* synthetic */ BalanceDataTotal e(BalanceDataTotal balanceDataTotal, List list) {
            return balanceDataTotal;
        }

        /* renamed from: c */
        public void call(Long l11) {
            Observable.zip(h2.t1().K1(this.f82925b).doOnNext(new z(this)).compose(RxJavaHelper.t((u6.g) TradeHorizontalSpotPresenter.this.getUI())), this.f82926c, st.a0.f29198b).compose(RxJavaHelper.t((u6.g) TradeHorizontalSpotPresenter.this.getUI())).subscribe(new C0858a());
        }
    }

    public class b extends BaseSubscriber<Long> {
        public b() {
        }

        public void onNext(Long l11) {
            SymbolBean J = a1.v().J(TradeHorizontalSpotPresenter.this.f82871e, TradeType.PRO);
            i6.d.b("isStartFirstTime:" + System.currentTimeMillis() + "=====" + J.getCa1OpenAt() + "======" + J.isCallAuctionOne());
            if (J.isCallAuctionOne()) {
                TradeHorizontalSpotPresenter.this.Z2();
            }
            if (J.isCallAuctionTwo()) {
                TradeHorizontalSpotPresenter.this.b3();
            }
            TradeHorizontalSpotPresenter.this.w3();
            TradeHorizontalSpotPresenter.this.a3();
            if (System.currentTimeMillis() > J.getCa2CloseAt()) {
                TradeHorizontalSpotPresenter.this.k3();
                ((y1) TradeHorizontalSpotPresenter.this.getUI()).z1();
            }
        }
    }

    public class c extends BaseSubscriber<CallAuction> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(CallAuction callAuction) {
            ((y1) TradeHorizontalSpotPresenter.this.getUI()).r(callAuction, TradeHorizontalSpotPresenter.this.f82871e);
            TradeHorizontalSpotPresenter.this.w3();
            if (callAuction.isContinuity()) {
                TradeHorizontalSpotPresenter.this.i3();
                TradeHorizontalSpotPresenter.this.k3();
            }
        }
    }

    public class d extends BaseSubscriber<CallAuction> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(CallAuction callAuction) {
            super.onNext(callAuction);
            TradeHorizontalSpotPresenter.this.z0();
            TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter = TradeHorizontalSpotPresenter.this;
            tradeHorizontalSpotPresenter.C0(tradeHorizontalSpotPresenter.f82879m, false);
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
                    ((y1) TradeHorizontalSpotPresenter.this.getUI()).k0(i6.m.Q(botRank.getYieldRate(), 2, 1));
                }
            }
        }

        public e() {
        }

        /* renamed from: a */
        public void call(Long l11) {
            v7.b.a().I0().b().compose(RxJavaHelper.t((u6.g) TradeHorizontalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    public class f extends BaseSubscriber<List<SymbolBean>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82935b;

        public f(boolean z11) {
            this.f82935b = z11;
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            if (a1.v().H(TradeHorizontalSpotPresenter.this.f82880n).contains(TradeHorizontalSpotPresenter.this.f82871e)) {
                if (((y1) TradeHorizontalSpotPresenter.this.getUI()).isCanBeSeen()) {
                    a1 v11 = a1.v();
                    TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter = TradeHorizontalSpotPresenter.this;
                    ((y1) TradeHorizontalSpotPresenter.this.getUI()).t(v11.J(tradeHorizontalSpotPresenter.f82871e, tradeHorizontalSpotPresenter.f82880n));
                    ((y1) TradeHorizontalSpotPresenter.this.getUI()).z1();
                    TradeHorizontalSpotPresenter.this.c3();
                }
                TradeHorizontalSpotPresenter.this.y1();
                TradeHorizontalSpotPresenter.this.R1();
            } else {
                if (!a1.v().H(TradeHorizontalSpotPresenter.this.f82880n).isEmpty()) {
                    TradeHorizontalSpotPresenter.this.f82871e = a1.v().H(TradeHorizontalSpotPresenter.this.f82880n).get(0);
                }
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter2 = TradeHorizontalSpotPresenter.this;
                tradeHorizontalSpotPresenter2.G0(tradeHorizontalSpotPresenter2.f82871e);
            }
            if (a1.v().L(TradeHorizontalSpotPresenter.this.f82871e)) {
                if (r.x().F0()) {
                    o C = o.C();
                    TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter3 = TradeHorizontalSpotPresenter.this;
                    C.F(tradeHorizontalSpotPresenter3.f82871e, (u6.g) tradeHorizontalSpotPresenter3.getUI(), ((y1) TradeHorizontalSpotPresenter.this.getUI()).r1());
                    TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter4 = TradeHorizontalSpotPresenter.this;
                    tradeHorizontalSpotPresenter4.c1(false, tradeHorizontalSpotPresenter4.f82871e, true);
                } else {
                    o C2 = o.C();
                    TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter5 = TradeHorizontalSpotPresenter.this;
                    C2.u0(tradeHorizontalSpotPresenter5.f82871e, (u6.g) tradeHorizontalSpotPresenter5.getUI(), ((y1) TradeHorizontalSpotPresenter.this.getUI()).r1());
                }
            }
            if (this.f82935b) {
                TradeHorizontalSpotPresenter.this.g3();
            }
        }
    }

    public class g extends BaseSubscriber<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SymbolBean f82937b;

        public g(SymbolBean symbolBean) {
            this.f82937b = symbolBean;
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            i6.d.b((this.f82937b.getTradeOpenAt() - System.currentTimeMillis()) + "=====");
            if (this.f82937b.getTradeOpenAt() - System.currentTimeMillis() <= -1000) {
                TradeHorizontalSpotPresenter.this.J2(false);
                TradeHorizontalSpotPresenter.this.m3();
            }
        }
    }

    public class h extends BaseSubscriber<Long> {

        public class a extends BaseSubscriber<EtpRebalInfo> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(EtpRebalInfo etpRebalInfo) {
                super.onNext(etpRebalInfo);
                TradeHorizontalSpotPresenter.this.b2();
                ArrayList arrayList = new ArrayList();
                TopScrollData topScrollData = new TopScrollData();
                topScrollData.l(TradeHorizontalSpotPresenter.this.getActivity().getString(R.string.n_trade_etp_carousel_time));
                topScrollData.m(DateTimeUtils.x(etpRebalInfo.getRebalTime().longValue()));
                topScrollData.k(0);
                arrayList.add(topScrollData);
                if (etpRebalInfo.getOptionState() == EtpRebalInfo.OPTION_STATE_NORMAL) {
                    TopScrollData topScrollData2 = new TopScrollData();
                    topScrollData2.l(TradeHorizontalSpotPresenter.this.getActivity().getString(R.string.n_trade_etp_carousel_nav));
                    topScrollData2.m(i6.m.m(String.valueOf(etpRebalInfo.getRebalNav()), PrecisionUtil.e(TradeHorizontalSpotPresenter.this.f82871e)) + " " + StringUtils.i(TradeHorizontalSpotPresenter.this.S0()));
                    topScrollData2.k(1);
                    arrayList.add(topScrollData2);
                }
                TopScrollData topScrollData3 = new TopScrollData();
                topScrollData3.l(String.format(Locale.ENGLISH, TradeHorizontalSpotPresenter.this.getActivity().getString(R.string.n_trade_etp_carousel_chargeFee), new Object[]{DateTimeUtils.A(etpRebalInfo.getChargeFeeTime())}));
                topScrollData3.m(i6.m.a(etpRebalInfo.getChargeFee()).setScale(4, 1).stripTrailingZeros().toPlainString() + "%");
                topScrollData3.k(2);
                arrayList.add(topScrollData3);
                ((y1) TradeHorizontalSpotPresenter.this.getUI()).V(arrayList, TradeHorizontalSpotPresenter.this.O ^ true, false, 0);
                boolean unused = TradeHorizontalSpotPresenter.this.O = true;
            }
        }

        public h() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            x7.d.c(TradeHorizontalSpotPresenter.this.I0(), false).compose(RxJavaHelper.t((u6.g) TradeHorizontalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    public class i extends BaseSubscriber<PrimeKycLimit> {
        public i() {
        }

        /* renamed from: a */
        public void onNext(PrimeKycLimit primeKycLimit) {
            super.onNext(primeKycLimit);
            if (primeKycLimit.getBlackKycType() == 2 || primeKycLimit.getBlackKycType() == 1) {
                ((y1) TradeHorizontalSpotPresenter.this.getUI()).u1();
            } else {
                ((y1) TradeHorizontalSpotPresenter.this.getUI()).p1(primeKycLimit);
            }
        }
    }

    public class j extends BaseSubscriber<List<SymbolPrice>> {
        public j() {
        }

        public void onNext(List<SymbolPrice> list) {
            super.onNext(list);
            if (!list.isEmpty() && list.size() > 0) {
                TradeHorizontalSpotPresenter.this.t3(list.get(0));
            }
        }
    }

    public class k extends BaseSubscriber<List<SymbolBean>> {
        public k() {
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter = TradeHorizontalSpotPresenter.this;
            tradeHorizontalSpotPresenter.G0(tradeHorizontalSpotPresenter.f82871e);
        }
    }

    public class l implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82944b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Observable f82945c;

        public class a extends BaseSubscriber<String> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(String str) {
                super.onNext(str);
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter = TradeHorizontalSpotPresenter.this;
                tradeHorizontalSpotPresenter.f82884r = true;
                tradeHorizontalSpotPresenter.x3(str);
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter2 = TradeHorizontalSpotPresenter.this;
                tradeHorizontalSpotPresenter2.f82876j.v0(tradeHorizontalSpotPresenter2.f82871e, tradeHorizontalSpotPresenter2.F, tradeHorizontalSpotPresenter2.f82880n);
            }
        }

        public l(boolean z11, Observable observable) {
            this.f82944b = z11;
            this.f82945c = observable;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(BalanceDataTotal balanceDataTotal) {
            TradeHorizontalSpotPresenter.this.o3(balanceDataTotal);
        }

        public static /* synthetic */ String e(BalanceDataTotal balanceDataTotal, String str, List list) {
            return str;
        }

        /* renamed from: c */
        public void call(Long l11) {
            Observable.zip(h2.t1().K1(this.f82944b).doOnNext(new b0(this)).compose(RxJavaHelper.t((u6.g) TradeHorizontalSpotPresenter.this.getUI())), o.C().H().compose(RxJavaHelper.t((u6.g) TradeHorizontalSpotPresenter.this.getUI())), this.f82945c, c0.f29204b).compose(RxJavaHelper.t((u6.g) TradeHorizontalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    public class m implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82948b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Observable f82949c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f82950d;

        public class a extends BaseSubscriber<RemainingAmountBean> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(RemainingAmountBean remainingAmountBean) {
                super.onNext(remainingAmountBean);
                i6.k.o("TRADE_SPOT", "观察区资产获取成功");
                TradeHorizontalSpotPresenter.this.u3(remainingAmountBean);
                m mVar = m.this;
                String str = mVar.f82950d;
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter = TradeHorizontalSpotPresenter.this;
                ((y1) TradeHorizontalSpotPresenter.this.getUI()).t8(str, tradeHorizontalSpotPresenter.f82877k.D(tradeHorizontalSpotPresenter.f82880n, str, true));
                m mVar2 = m.this;
                String str2 = mVar2.f82950d;
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter2 = TradeHorizontalSpotPresenter.this;
                ((y1) TradeHorizontalSpotPresenter.this.getUI()).xg(str2, tradeHorizontalSpotPresenter2.f82877k.D(tradeHorizontalSpotPresenter2.f82880n, str2, false));
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter3 = TradeHorizontalSpotPresenter.this;
                tradeHorizontalSpotPresenter3.f82876j.v0(tradeHorizontalSpotPresenter3.f82871e, tradeHorizontalSpotPresenter3.F, tradeHorizontalSpotPresenter3.f82880n);
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter4 = TradeHorizontalSpotPresenter.this;
                tradeHorizontalSpotPresenter4.f82884r = true;
                tradeHorizontalSpotPresenter4.a2();
            }

            public void onError(Throwable th2) {
                super.onError(th2);
                TradeHorizontalSpotPresenter.this.u3((RemainingAmountBean) null);
                ((y1) TradeHorizontalSpotPresenter.this.getUI()).b3();
            }
        }

        public m(boolean z11, Observable observable, String str) {
            this.f82948b = z11;
            this.f82949c = observable;
            this.f82950d = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(BalanceDataTotal balanceDataTotal) {
            TradeHorizontalSpotPresenter.this.o3(balanceDataTotal);
        }

        public static /* synthetic */ RemainingAmountBean e(BalanceDataTotal balanceDataTotal, RemainingAmountBean remainingAmountBean, List list) {
            return remainingAmountBean;
        }

        /* renamed from: c */
        public void call(Long l11) {
            Observable.zip(h2.t1().K1(this.f82948b).doOnNext(new d0(this)).compose(RxJavaHelper.t((u6.g) TradeHorizontalSpotPresenter.this.getUI())), v7.b.a().getRemainingAmount(a1.v().n(TradeHorizontalSpotPresenter.this.f82871e)).b(), this.f82949c, e0.f29209b).compose(RxJavaHelper.t((u6.g) TradeHorizontalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    public class n implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f82953b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Observable f82954c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f82955d;

        public class a extends BaseSubscriber<EtpAvailableBean> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(EtpAvailableBean etpAvailableBean) {
                super.onNext(etpAvailableBean);
                TradeHorizontalSpotPresenter.this.q3(etpAvailableBean);
                n nVar = n.this;
                String str = nVar.f82955d;
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter = TradeHorizontalSpotPresenter.this;
                ((y1) TradeHorizontalSpotPresenter.this.getUI()).t8(str, tradeHorizontalSpotPresenter.f82877k.D(tradeHorizontalSpotPresenter.f82880n, str, true));
                n nVar2 = n.this;
                String str2 = nVar2.f82955d;
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter2 = TradeHorizontalSpotPresenter.this;
                ((y1) TradeHorizontalSpotPresenter.this.getUI()).xg(str2, tradeHorizontalSpotPresenter2.f82877k.D(tradeHorizontalSpotPresenter2.f82880n, str2, false));
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter3 = TradeHorizontalSpotPresenter.this;
                tradeHorizontalSpotPresenter3.f82876j.v0(tradeHorizontalSpotPresenter3.f82871e, tradeHorizontalSpotPresenter3.F, tradeHorizontalSpotPresenter3.f82880n);
                TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter4 = TradeHorizontalSpotPresenter.this;
                tradeHorizontalSpotPresenter4.f82884r = true;
                tradeHorizontalSpotPresenter4.a2();
            }

            public void onError(Throwable th2) {
                super.onError(th2);
                TradeHorizontalSpotPresenter.this.q3((EtpAvailableBean) null);
                ((y1) TradeHorizontalSpotPresenter.this.getUI()).b3();
            }
        }

        public n(boolean z11, Observable observable, String str) {
            this.f82953b = z11;
            this.f82954c = observable;
            this.f82955d = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(BalanceDataTotal balanceDataTotal) {
            TradeHorizontalSpotPresenter.this.o3(balanceDataTotal);
        }

        public static /* synthetic */ EtpAvailableBean e(BalanceDataTotal balanceDataTotal, EtpAvailableBean etpAvailableBean, List list) {
            return etpAvailableBean;
        }

        /* renamed from: c */
        public void call(Long l11) {
            Observable.zip(h2.t1().K1(this.f82953b).doOnNext(new f0(this)).compose(RxJavaHelper.t((u6.g) TradeHorizontalSpotPresenter.this.getUI())), v7.b.a().getEtpAvailableAmount(a1.v().n(TradeHorizontalSpotPresenter.this.f82871e)).b(), this.f82954c, g0.f29214b).compose(RxJavaHelper.t((u6.g) TradeHorizontalSpotPresenter.this.getUI())).subscribe(new a());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean L2(List list) {
        String A = a1.v().A(this.f82871e);
        return Boolean.valueOf("innovation".equals(A) || "bifurcation".equals(A) || SymbolBean.POTENTIALS.equals(A) || "profession".equals(A));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable M2(List list) {
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
    public /* synthetic */ void N2(TradeRiskReminder tradeRiskReminder) {
        if (h1()) {
            qt.g.a().f(tradeRiskReminder.getState());
        } else if ("0".equals(tradeRiskReminder.getState())) {
            getActivity().startActivity(new Intent(getActivity(), ZoneReminderActivity.class).putExtra("zone_reminder_type", this.f82885s));
        }
    }

    public static /* synthetic */ Observable O2(String str, String str2, Long l11) {
        IHbgApi a11 = v7.b.a();
        long longValue = l11.longValue();
        return a11.getAssetsTrade(longValue, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2).b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P2(List list) {
        if (list != null && list.size() > 0) {
            this.f82877k.g0(this.f82880n, h2.t1().U0(list));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable Q2(Long l11) {
        return ys.a.c(this.f82871e);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable S2(Map map, Long l11) {
        return this.f82877k.x(map);
    }

    public static /* synthetic */ Boolean T2(List list) {
        return Boolean.valueOf(list != null);
    }

    public static /* synthetic */ int U2(SymbolBean symbolBean, SymbolBean symbolBean2) {
        return i6.m.a(symbolBean2.getEtpLeverageRatio()).abs().intValue() - i6.m.a(symbolBean.getEtpLeverageRatio()).abs().intValue();
    }

    public final Subscriber<CallAuction> E2() {
        return new c();
    }

    public final Subscriber<Long> F2() {
        return new b();
    }

    public Subscriber<List<SymbolPrice>> G2() {
        return new j();
    }

    public final void H2() {
        if (r.x().F0()) {
            v7.b.a().getKycLimit().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new i());
        }
    }

    public final void I2() {
        if (!r.x().X()) {
            a1.v().Y(true, false).filter(new u(this)).flatMap(new t(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(EasySubscriber.create(new q(this)));
        }
    }

    public void J2(boolean z11) {
        a1.v().Y(false, true).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new f(z11));
    }

    public final void K2(boolean z11) {
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
        arrayList.add(topScrollData);
        arrayList.add(topScrollData2);
        arrayList.add(topScrollData3);
        if (!a1.v().p0(this.f82871e)) {
            i11 = 8;
        }
        ((y1) getUI()).V(arrayList, true, z11, i11);
    }

    public void T1() {
        super.T1();
        if (a1.v().S(this.f82871e)) {
            ((y1) getUI()).W1(8);
        } else if (r.x().F0()) {
            ((y1) getUI()).D1(0);
            if (this.f82888v == 0) {
                ((y1) getUI()).W1(8);
            } else {
                ((y1) getUI()).W1(0);
            }
        } else {
            ((y1) getUI()).D1(8);
            ((y1) getUI()).W1(8);
        }
    }

    public void V() {
        EventBus.d().r(this);
        super.V();
    }

    /* renamed from: V2 */
    public void u1(BaseCoreActivity baseCoreActivity, y1 y1Var) {
        super.onUIReady(baseCoreActivity, y1Var);
        this.f82888v = 0;
        this.R = new a0((a0.e) getUI(), baseCoreActivity);
        EventBus.d().p(this);
    }

    public final void W2() {
        SymbolBean J2 = a1.v().J(this.f82871e, this.f82880n);
        if (J2 != null && J2.getCa1OpenAt() != 0) {
            ys.a.c(this.f82871e).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
        }
    }

    public final Observable<List<AssertsTradeData>> X2(String str) {
        if (e1()) {
            SymbolUtil.a(str);
        } else {
            SymbolUtil.b(str);
        }
        return h2.t1().b1(this.f82880n, AccountType.spot.toString()).flatMap(new w(SymbolUtil.a(str), SymbolUtil.b(str))).compose(RxJavaHelper.t((u6.g) getUI())).doOnNext(new st.r(this));
    }

    public void Y1() {
        super.Y1();
        boolean F0 = r.x().F0();
        if (a1.v().S(this.f82871e)) {
            if (o.C().T()) {
                ((y1) getUI()).D1(8);
            } else if (F0) {
                ((y1) getUI()).D1(0);
            } else {
                ((y1) getUI()).D1(8);
            }
        } else if (!F0) {
            ((y1) getUI()).D1(8);
        } else if (this.f82888v == 0) {
            ((y1) getUI()).D1(8);
        } else {
            ((y1) getUI()).D1(0);
        }
    }

    public final void Y2() {
        String str = "";
        if (qt.r.b()) {
            SymbolBean J2 = a1.v().J(this.f82871e, TradeType.PRO);
            int i11 = 8;
            if (J2 != null && gj.d.n().G()) {
                TradeType k11 = k0.k();
                String leverageRatio = J2.getLeverageRatio();
                String superMarginLeverageRatio = J2.getSuperMarginLeverageRatio();
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
                    if (i6.m.a(leverageRatio).compareTo(i6.m.a(superMarginLeverageRatio)) > 0) {
                        k0.F(TradeType.MARGIN);
                        str = leverageRatio + "X";
                    } else {
                        k0.F(TradeType.SUPERMARGIN);
                        str = superMarginLeverageRatio + "X";
                    }
                }
                i11 = 0;
            }
            ((y1) getUI()).p(i11, str);
            return;
        }
        SymbolBean J3 = a1.v().J(this.f82871e, this.f82880n);
        if (J3 == null) {
            ((y1) getUI()).qc(str);
        } else if (TextUtils.isEmpty(J3.getLeverageRatio())) {
            ((y1) getUI()).qc(str);
        } else {
            ((y1) getUI()).qc(J3.getLeverageRatio() + "X");
        }
    }

    public void Z1() {
        if (!a1.v().L(this.f82871e)) {
            return;
        }
        if (r.x().F0()) {
            o.C().F(this.f82871e, (u6.g) getUI(), ((y1) getUI()).r1());
        } else {
            o.C().u0(this.f82871e, (u6.g) getUI(), ((y1) getUI()).r1());
        }
    }

    public void Z2() {
        SymbolBean J2 = a1.v().J(this.f82871e, TradeType.PRO);
        if (!this.U) {
            this.U = true;
            ((y1) getUI()).z1();
            ((y1) getUI()).E(1, J2.getCa1CloseAt() - System.currentTimeMillis());
        }
    }

    public final void a3() {
        SymbolBean J2 = a1.v().J(this.f82871e, this.f82880n);
        if (J2 != null && J2.isCallAuction() && !this.W) {
            this.W = true;
            this.T = E2();
            Observable.interval(0, 5, TimeUnit.SECONDS).flatMap(new s(this)).retryWhen(y.f29253b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.T);
        }
    }

    @k20.h
    @Keep
    public void afterSymbolIdChanged(SymbolChangeEvent symbolChangeEvent) {
        if (((y1) getUI()).isCanBeSeen()) {
            if (symbolChangeEvent.f() || !symbolChangeEvent.b().equals(this.f82871e)) {
                super.afterSymbolIdChanged(symbolChangeEvent);
                v3();
                if (!this.f82871e.contains("hb10")) {
                    ((y1) getUI()).I(8);
                    Subscriber<List<SymbolPrice>> subscriber = this.J;
                    if (subscriber != null) {
                        subscriber.unsubscribe();
                    }
                } else {
                    f3();
                    ((y1) getUI()).I(0);
                }
                boolean F0 = r.x().F0();
                Z1();
                if (a1.v().S(this.f82871e)) {
                    H2();
                } else {
                    ((y1) getUI()).w1();
                    ((y1) getUI()).o1();
                }
                T1();
                Y1();
                w3();
                ((y1) getUI()).z1();
                c3();
                a3();
                if (F0) {
                    I2();
                } else {
                    o.C().y0((String) null);
                }
                Y2();
                g3();
                K2(true);
                d3();
                n3();
                r3();
            }
        }
    }

    public void b3() {
        SymbolBean J2 = a1.v().J(this.f82871e, TradeType.PRO);
        if (!this.V) {
            h3();
            this.V = true;
            long ca2CloseAt = J2.getCa2CloseAt() - System.currentTimeMillis();
            X1();
            ((y1) getUI()).z1();
            ((y1) getUI()).E(2, ca2CloseAt);
        }
    }

    public void c1(boolean z11, String str, boolean z12) {
        if (!r.x().F0()) {
            u3((RemainingAmountBean) null);
            q3((EtpAvailableBean) null);
            return;
        }
        if (z12) {
            ((y1) getUI()).b3();
        }
        Subscription subscription = this.L;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<List<AssertsTradeData>> X2 = X2(str);
        if (a1.v().S(str)) {
            this.L = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new l(z11, X2)).subscribe(new BaseSubscriber());
        } else if (h1()) {
            this.L = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new m(z11, X2, str)).subscribe(new BaseSubscriber());
        } else if (f1()) {
            this.L = Observable.interval(0, 5, TimeUnit.SECONDS).doOnNext(new n(z11, X2, str)).subscribe(new BaseSubscriber());
        } else {
            this.L = Observable.interval(0, 15, TimeUnit.SECONDS).doOnNext(new a(z11, X2, str)).subscribe(new BaseSubscriber());
        }
    }

    public final void c3() {
        SymbolBean J2 = a1.v().J(this.f82871e, this.f82880n);
        k3();
        if (J2 != null && !(J2.getCa1OpenAt() == 0 && J2.getCa2OpenAt() == 0) && System.currentTimeMillis() < J2.getCa2CloseAt()) {
            this.S = F2();
            Observable.interval(0, 1000, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.S);
        }
    }

    public final void d3() {
        Subscription subscription = this.N;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        if (a1.v().p0(this.f82871e)) {
            this.O = false;
            this.N = Observable.interval(0, 5000, TimeUnit.MILLISECONDS).subscribe(new h());
        }
    }

    public void e3() {
        l3();
        this.K = Observable.interval(0, 5, TimeUnit.MINUTES).doOnNext(new e()).subscribe(new BaseSubscriber());
    }

    public final void f3() {
        Subscriber<List<SymbolPrice>> subscriber = this.J;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.J = G2();
        Observable.interval(0, 15, TimeUnit.SECONDS).flatMap(new v(this, MapParamsBuilder.c().a("symbol", "hb10").a(AnimatedPasterJsonConfig.CONFIG_PERIOD, "15min").a("limit", "1").b())).filter(x.f29251b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.J);
    }

    public final void g3() {
        m3();
        SymbolBean J2 = a1.v().J(this.f82871e, this.f82880n);
        if (J2 != null && SymbolBean.PRE_ONLINE.equals(J2.getState())) {
            if (J2.getTradeOpenAt() - System.currentTimeMillis() > 0) {
                this.M = Observable.interval(0, 1, TimeUnit.SECONDS).subscribe(new g(J2));
            } else {
                J2(false);
            }
        }
    }

    public void h3() {
        qt.l.h().o();
        this.U = false;
    }

    public final void i3() {
        Subscriber<CallAuction> subscriber = this.T;
        if (subscriber != null) {
            this.W = false;
            subscriber.unsubscribe();
        }
    }

    public void j3() {
        this.V = false;
        qt.l.h().o();
    }

    public final void k3() {
        Subscriber<Long> subscriber = this.S;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public final void l3() {
        Subscription subscription = this.K;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void m3() {
        Subscription subscription = this.M;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void n3() {
        this.R.m(this.P);
        this.R.n(this.Q);
    }

    public final void o3(BalanceDataTotal balanceDataTotal) {
        TradeHoldBean tradeHoldBean;
        TradeHoldBean tradeHoldBean2;
        Map<String, BalanceDetailInfo> detailInfoMap = balanceDataTotal.getDetailInfoMap();
        SymbolBean J2 = a1.v().J(this.f82871e, this.f82880n);
        ArrayList arrayList = new ArrayList();
        if (detailInfoMap != null && J2 != null) {
            BalanceDetailInfo balanceDetailInfo = detailInfoMap.get(J2.getBaseCurrency());
            if (balanceDetailInfo != null) {
                tradeHoldBean = new TradeHoldBean();
                tradeHoldBean.setAvailable(p.j(balanceDetailInfo.getAvaialAble(), J2.getBaseCurrency()));
                tradeHoldBean.setNetAsset(p.j(balanceDetailInfo.getNetBalance(), J2.getBaseCurrency()));
                tradeHoldBean.setEstimateTotal(balanceDetailInfo.getEstimateAmount());
                if (i6.m.a(balanceDataTotal.getNetAsset()).compareTo(BigDecimal.ZERO) == 0) {
                    tradeHoldBean.setPercent("0.00%");
                } else {
                    tradeHoldBean.setPercent(i6.m.Q(i6.m.a(balanceDetailInfo.getEstimateAmount()).divide(i6.m.a(balanceDataTotal.getNetAsset()), 32, 1).toPlainString(), 2, 1));
                }
            } else {
                tradeHoldBean = new TradeHoldBean();
                tradeHoldBean.setAvailable("0.00");
                tradeHoldBean.setNetAsset("0.00");
                tradeHoldBean.setEstimateTotal("0.00");
                tradeHoldBean.setPercent("0.00%");
            }
            tradeHoldBean.setDisplayName(J2.getBaseCurrencyDisplayName());
            tradeHoldBean.setFullDisplayName(d7.k.C().B(J2.getBaseCurrency()));
            tradeHoldBean.setCurrencyInfo(balanceDetailInfo);
            arrayList.add(tradeHoldBean);
            BalanceDetailInfo balanceDetailInfo2 = detailInfoMap.get(J2.getQuoteCurrency());
            if (balanceDetailInfo2 != null) {
                tradeHoldBean2 = new TradeHoldBean();
                tradeHoldBean2.setAvailable(p.j(balanceDetailInfo2.getAvaialAble(), J2.getQuoteCurrency()));
                tradeHoldBean2.setNetAsset(p.j(balanceDetailInfo2.getNetBalance(), J2.getQuoteCurrency()));
                tradeHoldBean2.setEstimateTotal(balanceDetailInfo2.getEstimateAmount());
                if (i6.m.a(balanceDataTotal.getNetAsset()).compareTo(BigDecimal.ZERO) == 0) {
                    tradeHoldBean2.setPercent("0.00%");
                } else {
                    tradeHoldBean2.setPercent(i6.m.Q(i6.m.a(balanceDetailInfo2.getEstimateAmount()).divide(i6.m.a(balanceDataTotal.getNetAsset()), 32, 1).toPlainString(), 2, 1));
                }
            } else {
                tradeHoldBean2 = new TradeHoldBean();
                tradeHoldBean2.setAvailable("0.00");
                tradeHoldBean2.setNetAsset("0.00");
                tradeHoldBean2.setEstimateTotal("0.00");
                tradeHoldBean2.setPercent("0.00%");
            }
            tradeHoldBean2.setDisplayName(J2.getQuoteCurrencyDisplayName());
            tradeHoldBean2.setFullDisplayName(d7.k.C().B(J2.getQuoteCurrency()));
            tradeHoldBean2.setCurrencyInfo(balanceDetailInfo2);
            arrayList.add(tradeHoldBean2);
            synchronized (this.F) {
                this.F.clear();
                this.F.addAll(arrayList);
            }
        }
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
        a1.v().Y(false, true).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new k());
    }

    public final void q3(EtpAvailableBean etpAvailableBean) {
        this.B = etpAvailableBean;
        ((y1) getUI()).og(etpAvailableBean);
    }

    public final void r3() {
        this.P = null;
        this.Q = null;
        if (a1.v().p0(this.f82871e)) {
            ((y1) getUI()).O("", "", "", "", "", "", 8);
            return;
        }
        List<SymbolBean> q11 = a1.v().q(I0());
        if (q11 == null || q11.isEmpty()) {
            ((y1) getUI()).O("", "", "", "", "", "", 8);
            return;
        }
        Collections.sort(q11, st.p.f29232b);
        SymbolBean symbolBean = q11.get(0);
        if (i6.m.a(symbolBean.getEtpLeverageRatio()).abs().intValue() == 1) {
            ((y1) getUI()).O("", "", "", "", "", "", 8);
        } else if (q11.size() > 1) {
            SymbolBean symbolBean2 = q11.get(1);
            if (i6.m.a(symbolBean.getEtpLeverageRatio()).abs().intValue() != i6.m.a(symbolBean2.getEtpLeverageRatio()).abs().intValue() || symbolBean.getDirection().equals(symbolBean2.getDirection())) {
                y3(symbolBean);
                return;
            }
            if ("1".equals(symbolBean.getDirection())) {
                this.P = symbolBean;
                this.Q = symbolBean2;
            } else {
                this.P = symbolBean2;
                this.Q = symbolBean;
            }
            ((y1) getUI()).O(this.P.getDirection(), this.Q.getDirection(), this.P.getBaseCurrencyDisplayName(), this.Q.getBaseCurrencyDisplayName(), com.huobi.trade.helper.f0.d(getActivity(), this.P.getDirection(), this.P.getEtpLeverageRatio()), com.huobi.trade.helper.f0.d(getActivity(), this.Q.getDirection(), this.Q.getEtpLeverageRatio()), 0);
            this.R.g(this.P);
            this.R.h(this.Q);
        } else {
            y3(symbolBean);
        }
    }

    public void t0() {
        super.t0();
        o.C().v();
        Subscriber<List<SymbolPrice>> subscriber = this.J;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        Subscription subscription = this.L;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.N;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        k3();
        i3();
        h3();
        j3();
        m3();
        n3();
        l3();
    }

    public void t3(SymbolPrice symbolPrice) {
        String str;
        if (symbolPrice == null) {
            str = String.format(Locale.US, getString(R.string.trade_hb_value), new Object[]{"--"});
        } else {
            String m11 = i6.m.m(String.valueOf(symbolPrice.getClose()), PrecisionUtil.e(this.f82871e));
            str = String.format(Locale.US, getString(R.string.trade_hb_value), new Object[]{m11});
        }
        this.f82875i.Y(str);
    }

    public final void u3(RemainingAmountBean remainingAmountBean) {
        this.A = remainingAmountBean;
        ((y1) getUI()).H2(remainingAmountBean);
    }

    public void v0() {
        super.v0();
        boolean F0 = r.x().F0();
        J2(true);
        if (a1.v().S(this.f82871e)) {
            H2();
        } else {
            ((y1) getUI()).o1();
            ((y1) getUI()).w1();
        }
        T1();
        Y1();
        W2();
        w3();
        ((y1) getUI()).z1();
        c3();
        a3();
        if (F0) {
            I2();
        } else {
            o.C().y0((String) null);
        }
        d7.k.C().U(true, (RequestCallback1<List<CurrencyBean>>) null);
        v3();
        K2(false);
        if (this.f82871e.contains("hb10")) {
            f3();
            ((y1) getUI()).I(0);
        } else {
            ((y1) getUI()).I(8);
        }
        Y2();
        d3();
        c1(false, this.f82871e, true);
        r3();
        if (!AppLanguageHelper.getInstance().isChineseLanguage()) {
            e3();
        }
    }

    public final void v3() {
        if (a1.v().k0(this.f82871e)) {
            this.f82875i.Y(String.format(Locale.US, getString(R.string.trade_hb_value), new Object[]{"--"}));
            return;
        }
        this.f82875i.Y("");
    }

    public void w1() {
        J2(true);
    }

    public final void w3() {
        SymbolBean J2 = a1.v().J(this.f82871e, TradeType.PRO);
        if (J2 == null) {
            return;
        }
        if (J2.isCallAuction()) {
            ((y1) getUI()).o(true);
        } else {
            ((y1) getUI()).o(false);
        }
    }

    public void x3(String str) {
        BigDecimal w11 = this.f82877k.w(this.f82880n, this.f82871e, e1());
        if (w11.compareTo(i6.m.a(str)) <= 0) {
            str = w11.toPlainString();
        }
        ((y1) getUI()).t8(this.f82871e, str);
        String str2 = this.f82871e;
        ((y1) getUI()).xg(str2, this.f82877k.w(this.f82880n, str2, !e1()).toPlainString());
        a2();
    }

    public final void y3(SymbolBean symbolBean) {
        this.P = symbolBean;
        ((y1) getUI()).O(this.P.getDirection(), "", this.P.getBaseCurrencyDisplayName(), "", com.huobi.trade.helper.f0.d(getActivity(), this.P.getDirection(), this.P.getEtpLeverageRatio()), "", 0);
        this.R.g(this.P);
    }
}
