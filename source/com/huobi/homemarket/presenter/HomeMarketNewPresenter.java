package com.huobi.homemarket.presenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import c8.e;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.controller.FutureProductInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.hbg.core.bean.ContentNavigationInfo;
import com.hbg.lib.network.hbg.core.bean.MarketRedData;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.hbg.core.bean.RemindFlashBean;
import com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController;
import com.hbg.lib.network.option.controller.OptionMarketIndexInfoController;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseEasySubscriber;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.module.community.ui.CommunityFragment;
import com.hbg.module.content.ui.fragment.H5Fragment;
import com.hbg.module.content.ui.fragment.NewsHomeFragment;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.hbg.module.livesquare.ui.LiveSquareFragment;
import com.hbg.module.market.MarketModuleConfig;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.homemarket.model.MarketOptionDataController;
import com.huobi.homemarket.model.MarketRemindFlashItem;
import com.huobi.homemarket.ui.MarketCoinFragment;
import com.huobi.homemarket.ui.MarketSortLayout;
import com.huobi.lifecycle.OnBackgroundStatusChangedEvent;
import com.iproov.sdk.bridge.OptionsBridge;
import com.jumio.sdk.reject.JumioRejectReason;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import i6.t;
import i8.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import m9.r;
import o6.b;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import q8.d;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import sl.f0;
import sl.m;

public class HomeMarketNewPresenter extends BaseFragmentPresenter<g0> {
    public List<String> A = new ArrayList();
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public String I = "";
    public String J = "";
    public String K = "";
    public String L = "";
    public String M = "";
    public String N = "";
    public boolean O = false;
    public boolean P = false;
    public boolean Q;
    public boolean R = true;
    public Map<String, String> S = new ArrayMap();
    public Handler T = new i6.t(new d0());
    public f0.b U = new o();
    public b.C0747b V = new p();
    public k.b W = new q();
    public d.b X = new r();
    public r.b Y = new s();
    public e.b Z = new t();

    /* renamed from: c  reason: collision with root package name */
    public sl.m f72758c;

    /* renamed from: d  reason: collision with root package name */
    public sl.v f72759d;

    /* renamed from: e  reason: collision with root package name */
    public sl.c0 f72760e;

    /* renamed from: f  reason: collision with root package name */
    public MarketOptionDataController f72761f;

    /* renamed from: g  reason: collision with root package name */
    public List<s9.a> f72762g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public v9.a<ml.b> f72763h;

    /* renamed from: i  reason: collision with root package name */
    public v9.a<ml.b> f72764i;

    /* renamed from: j  reason: collision with root package name */
    public v9.a<s9.a> f72765j;

    /* renamed from: k  reason: collision with root package name */
    public v9.a<s9.a> f72766k;

    /* renamed from: l  reason: collision with root package name */
    public v9.a<s9.a> f72767l;

    /* renamed from: m  reason: collision with root package name */
    public Subscription f72768m;

    /* renamed from: n  reason: collision with root package name */
    public Subscription f72769n;

    /* renamed from: o  reason: collision with root package name */
    public Subscription f72770o;

    /* renamed from: p  reason: collision with root package name */
    public Subscription f72771p;

    /* renamed from: q  reason: collision with root package name */
    public Subscription f72772q;

    /* renamed from: r  reason: collision with root package name */
    public Subscription f72773r;

    /* renamed from: s  reason: collision with root package name */
    public Subscription f72774s;

    /* renamed from: t  reason: collision with root package name */
    public Subscription f72775t;

    /* renamed from: u  reason: collision with root package name */
    public Subscription f72776u;

    /* renamed from: v  reason: collision with root package name */
    public Subscription f72777v;

    /* renamed from: w  reason: collision with root package name */
    public Subscription f72778w;

    /* renamed from: x  reason: collision with root package name */
    public Subscription f72779x;

    /* renamed from: y  reason: collision with root package name */
    public zg.b f72780y;

    /* renamed from: z  reason: collision with root package name */
    public List<Fragment> f72781z = new ArrayList();

    public class a extends BaseSubscriber<ContractHeartBeat> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f72782b;

        public a(boolean z11) {
            this.f72782b = z11;
        }

        /* renamed from: a */
        public void onNext(ContractHeartBeat contractHeartBeat) {
            super.onNext(contractHeartBeat);
            if (contractHeartBeat != null) {
                if (!HomeMarketNewPresenter.this.L.equals(contractHeartBeat.getOptionHeartbeat())) {
                    if (MarketModuleConfig.a().E(MarketModuleConfig.a().o())) {
                        ((g0) HomeMarketNewPresenter.this.getUI()).u7(true);
                        ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
                    } else {
                        HomeMarketNewPresenter.this.m2(this.f72782b);
                    }
                }
                String unused = HomeMarketNewPresenter.this.L = contractHeartBeat.getOptionHeartbeat();
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public class a0 extends BaseSubscriber<List<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f72784b;

        public a0(boolean z11) {
            this.f72784b = z11;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            i6.k.e("getRemindFlashListgetCollectionSymbols " + th2);
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            if (list != null) {
                StringBuilder sb2 = new StringBuilder();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    sb2.append(list.get(i11) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                long j11 = 0;
                if (!this.f72784b && HomeMarketNewPresenter.this.f72762g.size() > 0) {
                    j11 = ((MarketRemindFlashItem) HomeMarketNewPresenter.this.f72762g.get(HomeMarketNewPresenter.this.f72762g.size() - 1)).g();
                }
                HomeMarketNewPresenter.this.Z1(sb2.toString(), j11);
            }
        }
    }

    public class b extends BaseSubscriber<ContractHeartBeat> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(ContractHeartBeat contractHeartBeat) {
            super.onNext(contractHeartBeat);
            if (contractHeartBeat != null) {
                if (!HomeMarketNewPresenter.this.I.equals(contractHeartBeat.getHeartbeat()) || !HomeMarketNewPresenter.this.J.equals(contractHeartBeat.getSwapHeartbeat())) {
                    HomeMarketNewPresenter.this.f72759d.D();
                    HomeMarketNewPresenter.this.l2();
                }
                String unused = HomeMarketNewPresenter.this.I = contractHeartBeat.getHeartbeat();
                String unused2 = HomeMarketNewPresenter.this.J = contractHeartBeat.getSwapHeartbeat();
                ((g0) HomeMarketNewPresenter.this.getUI()).l5();
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public class b0 extends BaseSubscriber<List<MarketRemindFlashItem>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f72787b;

        public b0(long j11) {
            this.f72787b = j11;
        }

        public void onAfter() {
            super.onAfter();
            if (HomeMarketNewPresenter.this.f72762g.size() == 0) {
                ((g0) HomeMarketNewPresenter.this.getUI()).c3();
            } else {
                ((g0) HomeMarketNewPresenter.this.getUI()).F0();
            }
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
            ((g0) HomeMarketNewPresenter.this.getUI()).Be();
            i6.k.e("getRemindFlashListloadFlashData finish ");
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            i6.k.e("getRemindFlashList   loadFlashData error " + th2);
        }

        @SuppressLint({"NotifyDataSetChanged"})
        public void onNext(List<MarketRemindFlashItem> list) {
            HomeMarketNewPresenter.this.t2(list, this.f72787b);
        }
    }

    public class c extends BaseSubscriber<ContractHeartBeat> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(ContractHeartBeat contractHeartBeat) {
            super.onNext(contractHeartBeat);
            if (contractHeartBeat != null) {
                if (!HomeMarketNewPresenter.this.K.equals(contractHeartBeat.getLinearSwapHeartbeat())) {
                    HomeMarketNewPresenter.this.f72760e.x();
                    HomeMarketNewPresenter.this.o2();
                }
                String unused = HomeMarketNewPresenter.this.K = contractHeartBeat.getLinearSwapHeartbeat();
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public class c0 extends EasySubscriber<Pair<List<SymbolBean>, List<CurrencyBean>>> {
        public c0() {
        }

        /* renamed from: a */
        public void onNext(Pair<List<SymbolBean>, List<CurrencyBean>> pair) {
            super.onNext(pair);
            boolean unused = HomeMarketNewPresenter.this.B = true;
            if (!HomeMarketNewPresenter.this.D) {
                ((g0) HomeMarketNewPresenter.this.getUI()).s9(true);
                HomeMarketNewPresenter.this.T.removeMessages(0);
                HomeMarketNewPresenter.this.T.sendEmptyMessageDelayed(0, 8000);
            }
            HomeMarketNewPresenter.this.L1();
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }

        public void onError2(Throwable th2) {
            printLog(th2);
            ((g0) HomeMarketNewPresenter.this.getUI()).pf(false);
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((g0) HomeMarketNewPresenter.this.getUI()).pf(false);
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }

        public void onStart() {
            super.onStart();
            a1 v11 = a1.v();
            TradeType tradeType = TradeType.PRO;
            if ((v11.Z(tradeType) != null && !a1.v().Z(tradeType).isEmpty()) && (d7.k.C().w() != null && !d7.k.C().w().isEmpty())) {
                HomeMarketNewPresenter.this.L1();
                if (!HomeMarketNewPresenter.this.D) {
                    ((g0) HomeMarketNewPresenter.this.getUI()).s9(true);
                    HomeMarketNewPresenter.this.T.removeMessages(0);
                    HomeMarketNewPresenter.this.T.sendEmptyMessageDelayed(0, 8000);
                    return;
                }
                return;
            }
            ((g0) HomeMarketNewPresenter.this.getUI()).showLoading();
        }
    }

    public class d extends BaseSubscriber<Pair<List<SymbolBean>, List<CurrencyBean>>> {
        public d() {
        }

        public void onAfter() {
            super.onAfter();
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }
    }

    public class d0 implements t.a {
        public d0() {
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 0) {
                if ("TAB_ALL".equals(((g0) HomeMarketNewPresenter.this.getUI()).r6()) || "TAB_MAIN".equals(((g0) HomeMarketNewPresenter.this.getUI()).r6()) || "TAB_HADAX".equals(((g0) HomeMarketNewPresenter.this.getUI()).r6())) {
                    ((g0) HomeMarketNewPresenter.this.getUI()).s9(false);
                    ((g0) HomeMarketNewPresenter.this.getUI()).pf(false);
                    ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
                }
            } else if (i11 == 1) {
                if ("TAB_CONTRACT".equals(((g0) HomeMarketNewPresenter.this.getUI()).r6())) {
                    ((g0) HomeMarketNewPresenter.this.getUI()).s9(false);
                    ((g0) HomeMarketNewPresenter.this.getUI()).u7(false);
                    ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
                }
            } else if (i11 == 2 && "TAB_USDT_CONTRACT".equals(((g0) HomeMarketNewPresenter.this.getUI()).r6())) {
                ((g0) HomeMarketNewPresenter.this.getUI()).s9(false);
                ((g0) HomeMarketNewPresenter.this.getUI()).u7(false);
                ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
            }
        }
    }

    public class e extends BaseSubscriber<List<ContractCurrencyInfo>> {
        public e() {
        }

        public void onAfter() {
            super.onAfter();
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }
    }

    public class e0 extends BaseSubscriber<ContractHeartBeat> {
        public e0() {
        }

        /* renamed from: a */
        public void onNext(ContractHeartBeat contractHeartBeat) {
            super.onNext(contractHeartBeat);
            if (contractHeartBeat != null) {
                if (!HomeMarketNewPresenter.this.M.equals(contractHeartBeat.getHeartbeat()) || !HomeMarketNewPresenter.this.N.equals(contractHeartBeat.getSwapHeartbeat())) {
                    HomeMarketNewPresenter.this.f2();
                }
                String unused = HomeMarketNewPresenter.this.M = contractHeartBeat.getHeartbeat();
                String unused2 = HomeMarketNewPresenter.this.N = contractHeartBeat.getSwapHeartbeat();
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            th2.printStackTrace();
        }
    }

    public class f extends BaseSubscriber<List<ContractCurrencyInfo>> {
        public f() {
        }

        public void onAfter() {
            super.onAfter();
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }
    }

    public class f0 extends EasySubscriber<List<ml.b>> {
        public f0() {
        }

        public void onError2(Throwable th2) {
            printLog(th2);
            if (!HomeMarketNewPresenter.this.f72758c.L()) {
                ((g0) HomeMarketNewPresenter.this.getUI()).pf(false);
            }
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            i6.d.b(aPIStatusErrorException.toString());
            if (!HomeMarketNewPresenter.this.f72758c.L()) {
                ((g0) HomeMarketNewPresenter.this.getUI()).pf(false);
            }
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }

        public void onStart() {
            super.onStart();
            if (!HomeMarketNewPresenter.this.f72758c.L()) {
                ((g0) HomeMarketNewPresenter.this.getUI()).Zb();
            } else if (!"TAB_COLLECTION".equals(((g0) HomeMarketNewPresenter.this.getUI()).r6())) {
            } else {
                if ("100".equals(((g0) HomeMarketNewPresenter.this.getUI()).bh())) {
                    if (HomeMarketNewPresenter.this.f72758c.A().isEmpty()) {
                        ((g0) HomeMarketNewPresenter.this.getUI()).c3();
                        ((g0) HomeMarketNewPresenter.this.getUI()).V4(false);
                        return;
                    }
                    ((g0) HomeMarketNewPresenter.this.getUI()).F0();
                    ((g0) HomeMarketNewPresenter.this.getUI()).V4(true);
                } else if (!JumioRejectReason.DIGITAL_COPY.equals(((g0) HomeMarketNewPresenter.this.getUI()).bh())) {
                } else {
                    if (HomeMarketNewPresenter.this.f72758c.z().isEmpty()) {
                        ((g0) HomeMarketNewPresenter.this.getUI()).c3();
                        ((g0) HomeMarketNewPresenter.this.getUI()).V4(false);
                        return;
                    }
                    ((g0) HomeMarketNewPresenter.this.getUI()).F0();
                    ((g0) HomeMarketNewPresenter.this.getUI()).V4(true);
                }
            }
        }

        public void onNext(List<ml.b> list) {
            super.onNext(list);
            HomeMarketNewPresenter.this.f2();
            if ("TAB_COLLECTION".equals(((g0) HomeMarketNewPresenter.this.getUI()).r6())) {
                if ("100".equals(((g0) HomeMarketNewPresenter.this.getUI()).bh())) {
                    if (HomeMarketNewPresenter.this.f72758c.A().isEmpty()) {
                        HomeMarketNewPresenter.this.a2();
                    } else {
                        HomeMarketNewPresenter.this.b2();
                    }
                } else if (JumioRejectReason.DIGITAL_COPY.equals(((g0) HomeMarketNewPresenter.this.getUI()).bh())) {
                    if (HomeMarketNewPresenter.this.f72758c.z().isEmpty()) {
                        ((g0) HomeMarketNewPresenter.this.getUI()).c3();
                        ((g0) HomeMarketNewPresenter.this.getUI()).V4(false);
                    } else {
                        ((g0) HomeMarketNewPresenter.this.getUI()).F0();
                        ((g0) HomeMarketNewPresenter.this.getUI()).V4(true);
                    }
                }
            }
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }
    }

    public class g extends BaseSubscriber<List<FutureContractInfo>> {
        public g() {
        }

        public void onAfter() {
            super.onAfter();
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }
    }

    public interface g0 extends u6.g {
        void Be();

        void Bg(v9.a<s9.a> aVar);

        void Cg(v9.a<ml.b> aVar);

        void F0();

        void Gd();

        void Ia();

        void Kb(List<OptionMarketIndexInfo> list);

        void L7();

        void N7();

        void P9(v9.a<s9.a> aVar);

        void Qe(boolean z11);

        void T5(String str, String str2);

        void T7();

        void Ub();

        void Uf(zg.b bVar);

        void V4(boolean z11);

        String V9();

        void Vb(List<TabData> list, List<Fragment> list2);

        void X3(List<FutureContractInfo> list);

        void Xg();

        void Zb();

        String bh();

        void c3();

        void ec(boolean z11);

        void ee(String str, String str2);

        void finishRefresh();

        void finishSkeleton();

        void g9(boolean z11);

        void i9(boolean z11);

        void jh();

        void l5();

        void l8();

        void p5(v9.a<ml.b> aVar);

        void pf(boolean z11);

        String r6();

        void s7(List<String> list);

        void s9(boolean z11);

        void showLoading();

        MarketSortLayout td();

        void u7(boolean z11);

        void vd(MarketRedData marketRedData);

        void xb(v9.a<s9.a> aVar);
    }

    public class h extends BaseSubscriber<List<FutureContractInfo>> {
        public h() {
        }

        public void onAfter() {
            super.onAfter();
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }
    }

    public class i extends EasySubscriber<List<FutureContractInfo>> {
        public i() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            ((g0) HomeMarketNewPresenter.this.getUI()).s9(false);
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            ((g0) HomeMarketNewPresenter.this.getUI()).s9(false);
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }

        public void onNext(List<FutureContractInfo> list) {
            super.onNext(list);
            if (MarketModuleConfig.a().E(MarketModuleConfig.a().o())) {
                ((g0) HomeMarketNewPresenter.this.getUI()).u7(true);
                ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
                return;
            }
            HomeMarketNewPresenter.this.f72761f.d(list);
            ((g0) HomeMarketNewPresenter.this.getUI()).X3(list);
            if (HomeMarketNewPresenter.this.f72761f.f()) {
                ((g0) HomeMarketNewPresenter.this.getUI()).F0();
            } else {
                ((g0) HomeMarketNewPresenter.this.getUI()).c3();
            }
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
            ((g0) HomeMarketNewPresenter.this.getUI()).s9(false);
        }
    }

    public class j extends EasySubscriber<Integer> {
        public j() {
        }

        /* renamed from: a */
        public void onNext(Integer num) {
            super.onNext(num);
            ((g0) HomeMarketNewPresenter.this.getUI()).g9(true);
        }
    }

    public class k implements m.e {
        public k() {
        }

        public void a() {
            HomeMarketNewPresenter.this.u1();
        }

        public void notifyDataSetChanged() {
            HomeMarketNewPresenter.this.f72763h.notifyDataSetChanged();
            HomeMarketNewPresenter.this.f72764i.notifyDataSetChanged();
            if (!"TAB_COLLECTION".equals(((g0) HomeMarketNewPresenter.this.getUI()).r6())) {
                return;
            }
            if ("100".equals(((g0) HomeMarketNewPresenter.this.getUI()).bh())) {
                if (HomeMarketNewPresenter.this.f72758c.A().isEmpty()) {
                    HomeMarketNewPresenter.this.a2();
                } else {
                    HomeMarketNewPresenter.this.b2();
                }
            } else if (!JumioRejectReason.DIGITAL_COPY.equals(((g0) HomeMarketNewPresenter.this.getUI()).bh())) {
            } else {
                if (HomeMarketNewPresenter.this.f72758c.z().isEmpty()) {
                    ((g0) HomeMarketNewPresenter.this.getUI()).c3();
                    ((g0) HomeMarketNewPresenter.this.getUI()).V4(false);
                    return;
                }
                ((g0) HomeMarketNewPresenter.this.getUI()).F0();
                ((g0) HomeMarketNewPresenter.this.getUI()).V4(true);
            }
        }
    }

    public class l implements Action1<Long> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f72802b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f72803c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Subscription f72804d;

        public class a extends EasySubscriber<List<OptionMarketIndexInfo>> {
            public a() {
            }

            public void onError2(Throwable th2) {
                th2.printStackTrace();
                Subscription subscription = l.this.f72804d;
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                ((g0) HomeMarketNewPresenter.this.getUI()).g9(false);
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                aPIStatusErrorException.printStackTrace();
                Subscription subscription = l.this.f72804d;
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                ((g0) HomeMarketNewPresenter.this.getUI()).g9(false);
            }

            public void onNext(List<OptionMarketIndexInfo> list) {
                super.onNext(list);
                Subscription subscription = l.this.f72804d;
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                if (MarketModuleConfig.a().E(MarketModuleConfig.a().o())) {
                    ((g0) HomeMarketNewPresenter.this.getUI()).u7(true);
                    ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
                    return;
                }
                ((g0) HomeMarketNewPresenter.this.getUI()).Kb(list);
                ((g0) HomeMarketNewPresenter.this.getUI()).g9(false);
            }
        }

        public l(String str, String str2, Subscription subscription) {
            this.f72802b = str;
            this.f72803c = str2;
            this.f72804d = subscription;
        }

        /* renamed from: a */
        public void call(Long l11) {
            OptionMarketIndexInfoController.d(false, this.f72802b, this.f72803c).compose(RxJavaHelper.t((u6.g) null)).subscribe(new a());
        }
    }

    public class m extends EasySubscriber<Object> {
        public m() {
        }

        public void onError2(Throwable th2) {
            i6.d.b("requestContract onError2() called with: e = [" + th2 + "]");
            ((g0) HomeMarketNewPresenter.this.getUI()).u7(MarketModuleConfig.a().C());
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            i6.d.b("requestContract onFailed() called with: e = [" + aPIStatusErrorException + "]");
            ((g0) HomeMarketNewPresenter.this.getUI()).u7(MarketModuleConfig.a().C());
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            i6.d.c("HomeMarketNewPresenter", "requestContract onNext() called with: object = [" + obj + "]");
            if (MarketModuleConfig.a().C()) {
                ((g0) HomeMarketNewPresenter.this.getUI()).s9(false);
                ((g0) HomeMarketNewPresenter.this.getUI()).u7(true);
                ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
                return;
            }
            if (HomeMarketNewPresenter.this.f72759d.q()) {
                if (HomeMarketNewPresenter.this.f72759d.i().size() == 0) {
                    ((g0) HomeMarketNewPresenter.this.getUI()).s9(false);
                    if ("TAB_CONTRACT".equals(((g0) HomeMarketNewPresenter.this.getUI()).r6())) {
                        ((g0) HomeMarketNewPresenter.this.getUI()).c3();
                    }
                } else {
                    HomeMarketNewPresenter.this.p1();
                    ((g0) HomeMarketNewPresenter.this.getUI()).F0();
                    if (!HomeMarketNewPresenter.this.E) {
                        ((g0) HomeMarketNewPresenter.this.getUI()).s9(true);
                        HomeMarketNewPresenter.this.T.removeMessages(1);
                        HomeMarketNewPresenter.this.T.sendEmptyMessageDelayed(1, 8000);
                    }
                }
            }
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }

        public void onStart() {
            super.onStart();
            i6.d.b("requestContract onStart() called");
        }
    }

    public class n extends EasySubscriber<Object> {
        public n() {
        }

        public void onError2(Throwable th2) {
            i6.d.b("requestUsdtContract onError2() called with: e = [" + th2 + "]");
            ((g0) HomeMarketNewPresenter.this.getUI()).u7(MarketModuleConfig.a().Q(TradeType.LINEAR_SWAP));
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            i6.d.b("requestUsdtContract onFailed() called with: e = [" + aPIStatusErrorException + "]");
            ((g0) HomeMarketNewPresenter.this.getUI()).u7(MarketModuleConfig.a().Q(TradeType.LINEAR_SWAP));
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            i6.d.c("HomeMarketNewPresenter", "requestUsdtContract onNext() called with: object = [" + obj + "]");
            if (MarketModuleConfig.a().Q(TradeType.LINEAR_SWAP)) {
                ((g0) HomeMarketNewPresenter.this.getUI()).s9(false);
                ((g0) HomeMarketNewPresenter.this.getUI()).u7(true);
                ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
                return;
            }
            if (HomeMarketNewPresenter.this.f72760e.n()) {
                if (HomeMarketNewPresenter.this.f72760e.g().size() == 0) {
                    ((g0) HomeMarketNewPresenter.this.getUI()).s9(false);
                    if ("TAB_USDT_CONTRACT".equals(((g0) HomeMarketNewPresenter.this.getUI()).r6())) {
                        ((g0) HomeMarketNewPresenter.this.getUI()).c3();
                    }
                } else {
                    HomeMarketNewPresenter.this.K2();
                    ((g0) HomeMarketNewPresenter.this.getUI()).F0();
                    if (!HomeMarketNewPresenter.this.F) {
                        ((g0) HomeMarketNewPresenter.this.getUI()).s9(true);
                        HomeMarketNewPresenter.this.T.removeMessages(2);
                        HomeMarketNewPresenter.this.T.sendEmptyMessageDelayed(2, 8000);
                    }
                }
            }
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }

        public void onStart() {
            super.onStart();
            i6.d.b("requestUsdtContract onStart() called");
        }
    }

    public class o implements f0.b {
        public o() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            HomeMarketNewPresenter.this.d2();
            if (((g0) HomeMarketNewPresenter.this.getUI()).r6() == null || "TAB_COLLECTION".equals(((g0) HomeMarketNewPresenter.this.getUI()).r6())) {
                if (HomeMarketNewPresenter.this.f72768m != null) {
                    HomeMarketNewPresenter.this.f72768m.unsubscribe();
                }
                HomeMarketNewPresenter homeMarketNewPresenter = HomeMarketNewPresenter.this;
                Subscription unused = homeMarketNewPresenter.f72768m = homeMarketNewPresenter.v1(list, true);
                ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
            }
        }
    }

    public class p implements b.C0747b {
        public p() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            HomeMarketNewPresenter.this.I1(1, list);
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }
    }

    public class q implements k.b {
        public q() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            HomeMarketNewPresenter.this.I1(4, list);
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }
    }

    public class r implements d.b {
        public r() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            HomeMarketNewPresenter.this.J1(list);
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }
    }

    public class s implements r.b {
        public s() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            HomeMarketNewPresenter.this.I1(2, list);
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }
    }

    public class t implements e.b {
        public t() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            HomeMarketNewPresenter.this.I1(3, list);
            ((g0) HomeMarketNewPresenter.this.getUI()).finishRefresh();
        }
    }

    public class u extends EasySubscriber<List<ml.b>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f72815b;

        public u(boolean z11) {
            this.f72815b = z11;
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError2(Throwable th2) {
            printLog(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            i6.d.b(aPIStatusErrorException.toString());
        }

        public void onNext(List<ml.b> list) {
            super.onNext(list);
            if (this.f72815b) {
                HomeMarketNewPresenter.this.f72763h.notifyDataSetChanged();
            } else {
                HomeMarketNewPresenter.this.f72764i.notifyDataSetChanged();
            }
        }
    }

    public class v extends EasySubscriber<List<ml.b>> {
        public v() {
        }

        public void onError2(Throwable th2) {
            ((g0) HomeMarketNewPresenter.this.getUI()).pf(false);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((g0) HomeMarketNewPresenter.this.getUI()).pf(false);
        }

        public void onStart() {
            super.onStart();
        }

        public void onNext(List<ml.b> list) {
            super.onNext(list);
            if (((g0) HomeMarketNewPresenter.this.getUI()).r6() != null) {
                return;
            }
            if (list.size() > 0) {
                i6.d.e("tab", "selectCollection --- 2");
                ((g0) HomeMarketNewPresenter.this.getUI()).Ia();
                ((g0) HomeMarketNewPresenter.this.getUI()).V4(true);
                HomeMarketNewPresenter.this.f2();
                ((g0) HomeMarketNewPresenter.this.getUI()).F0();
                return;
            }
            ((g0) HomeMarketNewPresenter.this.getUI()).T7();
        }
    }

    public class w extends EasySubscriber<List<s9.a>> {
        public w() {
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError2(Throwable th2) {
            printLog(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            i6.d.b(aPIStatusErrorException.toString());
        }

        public void onNext(List<s9.a> list) {
            super.onNext(list);
            if (list != null && list.size() > 0) {
                HomeMarketNewPresenter.this.o1();
            }
            HomeMarketNewPresenter.this.f72759d.B(HomeMarketNewPresenter.this.f72766k);
            ((g0) HomeMarketNewPresenter.this.getUI()).ec(HomeMarketNewPresenter.this.f72766k.c() == null || HomeMarketNewPresenter.this.f72766k.c().isEmpty());
        }
    }

    public class x extends EasySubscriber<List<s9.a>> {
        public x() {
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError2(Throwable th2) {
            printLog(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            i6.d.b(aPIStatusErrorException.toString());
        }

        public void onNext(List<s9.a> list) {
            super.onNext(list);
            if (list != null && list.size() > 0) {
                HomeMarketNewPresenter.this.J2();
            }
            HomeMarketNewPresenter.this.f72760e.v(HomeMarketNewPresenter.this.f72767l);
            ((g0) HomeMarketNewPresenter.this.getUI()).Qe(HomeMarketNewPresenter.this.f72767l.c() == null || HomeMarketNewPresenter.this.f72767l.c().isEmpty());
        }
    }

    public class y extends RequestCallback1<List<ContentNavigationInfo>> {
        public y() {
        }

        /* renamed from: a */
        public void onRequestSuccess(List<ContentNavigationInfo> list) {
            HomeMarketNewPresenter.this.q1(list);
        }

        public void onRequestFailure(Throwable th2) {
            super.onRequestFailure(th2);
            if (HomeMarketNewPresenter.this.getUI() != null) {
                ((g0) HomeMarketNewPresenter.this.getUI()).Xg();
            }
        }

        public void onRequestStart() {
            super.onRequestStart();
        }
    }

    public class z extends BaseEasySubscriber<ContractHeartBeat> {
        public z() {
        }

        /* renamed from: k */
        public void onNext(ContractHeartBeat contractHeartBeat) {
            super.onNext(contractHeartBeat);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List O1(boolean z11, List list) {
        this.f72758c.D(list, z11);
        this.f72758c.g0();
        return z11 ? this.f72758c.A() : this.f72758c.z();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List P1(List list) {
        this.f72759d.n(list);
        return this.f72759d.i();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ HashMap Q1(List list) {
        this.f72761f.e(list);
        return this.f72761f.a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List R1(List list) {
        this.f72760e.k(list);
        return this.f72760e.g();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List S1(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                MarketRemindFlashItem marketRemindFlashItem = null;
                if (i11 > 0) {
                    int i12 = i11 - 1;
                    if (i12 < arrayList.size()) {
                        marketRemindFlashItem = (MarketRemindFlashItem) arrayList.get(i12);
                    } else {
                        marketRemindFlashItem = (MarketRemindFlashItem) arrayList.get(arrayList.size() - 1);
                    }
                }
                MarketRemindFlashItem B2 = B2(list, marketRemindFlashItem, i11);
                if (B2 != null) {
                    arrayList.add(B2);
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List T1(List list, List list2) {
        return list;
    }

    public static /* synthetic */ List U1(List list, List list2, List list3) {
        return list;
    }

    public static /* synthetic */ List V1(List list, List list2) {
        return list;
    }

    public static /* synthetic */ Pair W1(List list, List list2) {
        return null;
    }

    public static /* synthetic */ List X1(List list, List list2) {
        return list;
    }

    public static /* synthetic */ int Y1(Map map, String str, String str2) {
        Integer num;
        int i11 = 0;
        try {
            num = map.get(str2) != null ? Integer.valueOf(i6.m.k0(((CurrencyBean) map.get(str2)).getWeight())) : 0;
            try {
                if (map.get(str) != null) {
                    i11 = Integer.valueOf(i6.m.k0(((CurrencyBean) map.get(str)).getWeight()));
                }
            } catch (NumberFormatException e11) {
                e = e11;
                e.printStackTrace();
                return num.compareTo(i11);
            }
        } catch (NumberFormatException e12) {
            e = e12;
            num = 0;
            e.printStackTrace();
            return num.compareTo(i11);
        }
        return num.compareTo(i11);
    }

    public void A1() {
        i6.d.b("getLinearSwapData() called");
        ((g0) getUI()).s9(false);
        if (!NetworkStatus.c(getActivity())) {
            i6.d.b("1.getLinearSwapData() called no network");
            if (this.f72760e.g().isEmpty()) {
                ((g0) getUI()).u7(false);
            } else {
                i6.d.b("1.getLinearSwapData() called has data");
                K2();
                ((g0) getUI()).F0();
            }
            ((g0) getUI()).finishRefresh();
            return;
        }
        MarketModuleConfig.a().a().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c());
        if (MarketModuleConfig.a().Q(TradeType.LINEAR_SWAP)) {
            ((g0) getUI()).u7(true);
            ((g0) getUI()).finishRefresh();
            return;
        }
        if (NetworkStatus.c(getActivity()) && !this.F) {
            ((g0) getUI()).s9(true);
            this.T.removeMessages(2);
            this.T.sendEmptyMessageDelayed(2, 8000);
        }
        if (!this.f72760e.n()) {
            ((g0) getUI()).s9(true);
        }
        o2();
    }

    public void A2() {
        Subscription subscription = this.f72778w;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public MarketOptionDataController B1() {
        return this.f72761f;
    }

    public final MarketRemindFlashItem B2(List<RemindFlashBean> list, MarketRemindFlashItem marketRemindFlashItem, int i11) {
        MarketRemindFlashItem marketRemindFlashItem2 = new MarketRemindFlashItem();
        RemindFlashBean remindFlashBean = list.get(i11);
        if (remindFlashBean == null || remindFlashBean.getSymbol() == null) {
            return null;
        }
        marketRemindFlashItem2.s(remindFlashBean.getId());
        marketRemindFlashItem2.z(remindFlashBean.getTs());
        marketRemindFlashItem2.t(remindFlashBean.getPairId());
        marketRemindFlashItem2.w(remindFlashBean.getSymbol());
        marketRemindFlashItem2.r(remindFlashBean.getDirection());
        marketRemindFlashItem2.v(remindFlashBean.getStrategyName());
        marketRemindFlashItem2.y(remindFlashBean.getTitle());
        marketRemindFlashItem2.p(remindFlashBean.getContent());
        marketRemindFlashItem2.o(remindFlashBean.getCoin());
        marketRemindFlashItem2.q(DateTimeUtils.i(marketRemindFlashItem2.m(), "EEEE MM-dd", AppLanguageHelper.getInstance().getCurAppLocale()));
        marketRemindFlashItem2.x(DateTimeUtils.A(remindFlashBean.getTs()));
        if (i11 == 0) {
            marketRemindFlashItem2.u(false);
        } else {
            marketRemindFlashItem2.u(marketRemindFlashItem.e().equals(marketRemindFlashItem2.e()));
        }
        return marketRemindFlashItem2;
    }

    public void C1(boolean z11) {
        A2();
        ((g0) getUI()).s9(false);
        if (!NetworkStatus.c(getActivity())) {
            if (!this.f72761f.f()) {
                ((g0) getUI()).u7(false);
            } else {
                ((g0) getUI()).F0();
            }
            ((g0) getUI()).finishRefresh();
            return;
        }
        MarketModuleConfig.a().a().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new a(z11));
        if (MarketModuleConfig.a().E(MarketModuleConfig.a().o())) {
            ((g0) getUI()).u7(true);
            ((g0) getUI()).finishRefresh();
            return;
        }
        if (!this.f72761f.f()) {
            ((g0) getUI()).s9(true);
        }
        m2(z11);
    }

    public void C2() {
        Subscription subscription = this.f72774s;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final Subscription D1(List<SymbolPrice> list) {
        return Observable.just(list).subscribeOn(Schedulers.io()).map(new tl.k(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new EasySubscriber());
    }

    public void D2() {
        Subscription subscription = this.f72775t;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void E1(boolean z11) {
        if (z11 && this.f72762g.size() == 0) {
            ((g0) getUI()).Zb();
        }
        if (!BaseModuleConfig.a().a()) {
            i6.k.e("getRemindFlashListvIsLogin :  false refresh : " + z11);
            MarketModuleConfig.a().o0(false, getActivity()).compose(RxJavaHelper.t((u6.g) null)).subscribe(new a0(z11));
            return;
        }
        i6.k.e("getRemindFlashListvIsLogin :  true  refresh : " + z11);
        long j11 = 0;
        if (!z11 && this.f72762g.size() > 0) {
            List<s9.a> list = this.f72762g;
            j11 = ((MarketRemindFlashItem) list.get(list.size() - 1)).g();
        }
        Z1((String) null, j11);
    }

    public void E2() {
        Subscription subscription = this.f72769n;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.f72770o;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        Subscription subscription3 = this.f72771p;
        if (subscription3 != null) {
            subscription3.unsubscribe();
        }
        Subscription subscription4 = this.f72772q;
        if (subscription4 != null) {
            subscription4.unsubscribe();
        }
        Subscription subscription5 = this.f72773r;
        if (subscription5 != null) {
            subscription5.unsubscribe();
        }
    }

    public MarketSortLayout F1() {
        return ((g0) getUI()).td();
    }

    public void F2() {
        Subscription subscription = this.f72777v;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final Subscription G1(List<SymbolPrice> list) {
        return Observable.just(list).subscribeOn(Schedulers.io()).map(new tl.l(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new x());
    }

    public void G2() {
        Subscription subscription = this.f72779x;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public List<Fragment> H1() {
        return this.f72781z;
    }

    public void H2() {
        Subscription subscription = this.f72768m;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void I1(int i11, List<SymbolPrice> list) {
        if ("TAB_CONTRACT".equals(((g0) getUI()).r6())) {
            if (i11 == 1) {
                Subscription subscription = this.f72769n;
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                this.f72769n = y1(list);
            } else if (i11 == 2) {
                Subscription subscription2 = this.f72770o;
                if (subscription2 != null) {
                    subscription2.unsubscribe();
                }
                this.f72770o = y1(list);
            } else if (i11 == 3) {
                Subscription subscription3 = this.f72773r;
                if (subscription3 != null) {
                    subscription3.unsubscribe();
                }
                this.f72773r = y1(list);
            }
        } else if ("TAB_USDT_CONTRACT".equals(((g0) getUI()).r6())) {
            if (i11 == 4) {
                Subscription subscription4 = this.f72771p;
                if (subscription4 != null) {
                    subscription4.unsubscribe();
                }
                this.f72771p = G1(list);
            } else if (i11 == 3) {
                Subscription subscription5 = this.f72773r;
                if (subscription5 != null) {
                    subscription5.unsubscribe();
                }
                this.f72773r = G1(list);
            }
        } else if (!"TAB_COLLECTION".equals(((g0) getUI()).r6())) {
        } else {
            if (i11 == 1) {
                Subscription subscription6 = this.f72769n;
                if (subscription6 != null) {
                    subscription6.unsubscribe();
                }
                this.f72769n = v1(list, false);
            } else if (i11 == 2) {
                Subscription subscription7 = this.f72770o;
                if (subscription7 != null) {
                    subscription7.unsubscribe();
                }
                this.f72770o = v1(list, false);
            } else if (i11 == 4) {
                Subscription subscription8 = this.f72771p;
                if (subscription8 != null) {
                    subscription8.unsubscribe();
                }
                this.f72771p = v1(list, false);
            } else if (i11 == 3) {
                Subscription subscription9 = this.f72773r;
                if (subscription9 != null) {
                    subscription9.unsubscribe();
                }
                this.f72773r = v1(list, false);
            }
        }
    }

    public void I2() {
        Subscription subscription = this.f72776u;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void J1(List<SymbolPrice> list) {
        Subscription subscription = this.f72772q;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f72772q = D1(list);
    }

    public final void J2() {
        ((g0) getUI()).s9(false);
        this.F = true;
        this.T.removeMessages(2);
    }

    public final void K1() {
        if (this.f72780y == null || this.A.isEmpty()) {
            FragmentManager childFragmentManager = Q().getChildFragmentManager();
            List<String> w11 = a1.v().w();
            y2(w11);
            this.A.addAll(w11);
            for (String next : this.A) {
                Bundle bundle = new Bundle();
                bundle.putString("extra_tab", "TAB_ALL");
                bundle.putString("extra_quote_currency", next);
                Fragment m02 = childFragmentManager.m0("TAB_ALL" + next);
                if (m02 == null) {
                    m02 = Fragment.instantiate(getActivity(), MarketCoinFragment.class.getName(), bundle);
                } else {
                    m02.setArguments(bundle);
                }
                this.f72781z.add(m02);
            }
            this.f72780y = new zg.b(Q(), this.f72781z, this.A, "TAB_ALL");
        }
        List<String> M1 = M1(this.A);
        q2(M1);
        ((g0) getUI()).s7(M1);
        ((g0) getUI()).Uf(this.f72780y);
        this.f72780y.notifyDataSetChanged();
    }

    public final void K2() {
        sl.f0.g().m();
        m9.r.g().m();
        o6.b.g().m();
        q8.d.f().j();
        i8.k.g().i();
        i8.k.g().k("usdt_contract_overview_listener_tag");
        c8.e.g().i();
        c8.e.g().k("index_overview_listener_tag");
    }

    public final void L1() {
        if ("TAB_ALL".equals(((g0) getUI()).r6())) {
            K1();
        }
        ((g0) getUI()).Ub();
        ((g0) getUI()).F0();
    }

    public final List<String> M1(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (SymbolBean.ALTS.equalsIgnoreCase(next) || SymbolBean.FIAT.equalsIgnoreCase(next) || SymbolBean.CRYPTO.equalsIgnoreCase(next)) {
                arrayList.add(next);
            } else {
                arrayList.add(d7.k.C().z(next));
            }
        }
        return arrayList;
    }

    public boolean N1() {
        return this.Q;
    }

    public void Z(boolean z11) {
        super.Z(z11);
        if (z11) {
            j1();
            MarketModuleConfig.a().i();
        } else {
            if (EventBus.d().i(this)) {
                EventBus.d().r(this);
            }
            j2();
            sl.f0.g().j("pro_overview_listener_tag");
            sl.f0.g().n();
            o6.b.g().j("contract_overview_listener_tag");
            o6.b.g().n();
            i8.k.g().j("usdt_contract_overview_listener_tag");
            i8.k.g().n();
            m9.r.g().j("swap_overview_listener_tag");
            m9.r.g().n();
            q8.d.f().h("option_overview_listener_tag");
            q8.d.f().k();
            c8.e.g().j("index_overview_listener_tag");
            c8.e.g().n();
            this.D = false;
            this.E = false;
            this.F = false;
            this.G = false;
            this.H = false;
            H2();
            E2();
            C2();
            D2();
            I2();
            G2();
            F2();
            A2();
        }
        sl.m mVar = this.f72758c;
        if (mVar != null) {
            mVar.b0(z11);
        }
        sl.v vVar = this.f72759d;
        if (vVar != null) {
            vVar.C(z11);
        }
        sl.c0 c0Var = this.f72760e;
        if (c0Var != null) {
            c0Var.w(z11);
        }
        this.C = true;
        if (!z11 && this.R) {
            rl.l.c();
        }
    }

    public final void Z1(String str, long j11) {
        i6.k.e("getRemindFlashListcollections " + str + "  id  : " + j11);
        v7.b.a().e0(j11, str, BaseModuleConfig.a().M()).b().compose(RxJavaHelper.t((u6.g) null)).map(new tl.j(this)).subscribe(new b0(j11));
    }

    public final void a2() {
        i6.d.c("OneKeyCollectView", "onCollectionEmpty");
        ((g0) getUI()).c3();
        ((g0) getUI()).V4(false);
        this.Q = false;
        e2();
    }

    public final void b2() {
        ((g0) getUI()).F0();
        ((g0) getUI()).V4(true);
        this.Q = true;
        ((g0) getUI()).i9(true);
    }

    /* renamed from: c2 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, g0 g0Var) {
        super.onUIReady(baseCoreActivity, g0Var);
        this.O = Q().getArguments().getBoolean("MARKET_GO_POTENTIALS", false);
        this.P = Q().getArguments().getBoolean("MARKET_GO_PIONEER", false);
        this.f72761f = new MarketOptionDataController();
        this.f72759d = new sl.v(getActivity(), g0Var);
        this.f72760e = new sl.c0(getActivity(), g0Var);
        sl.m mVar = new sl.m(getActivity(), g0Var);
        this.f72758c = mVar;
        this.f72763h = new v9.a<>(mVar.A());
        this.f72764i = new v9.a<>(this.f72758c.z());
        this.f72766k = new v9.a<>(this.f72759d.k());
        this.f72767l = new v9.a<>(this.f72760e.i());
        this.f72765j = new v9.a<>(this.f72762g);
        ((g0) getUI()).p5(this.f72763h);
        ((g0) getUI()).Cg(this.f72764i);
        ((g0) getUI()).Bg(this.f72765j);
        ((g0) getUI()).xb(this.f72766k);
        ((g0) getUI()).P9(this.f72767l);
        this.f72758c.f0(new k());
        this.f72774s = this.f72758c.y(baseCoreActivity).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new v());
        MarketModuleConfig.a().a().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new z());
        this.f72775t = this.f72759d.j().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        this.f72776u = this.f72760e.h().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        ((g0) getUI()).ee(ll.j.n().m(), ll.j.n().l());
        ((g0) getUI()).T5(ll.j.n().m(), ll.j.n().l());
        if (this.f72759d.i() != null && this.f72759d.i().size() > 0) {
            ((g0) getUI()).F0();
        }
        Bundle arguments = Q().getArguments();
        if (arguments == null || (!arguments.getBoolean("isFromJump") && com.hbg.module.libkt.base.ext.b.x(arguments.getString("type")) && arguments.getInt("child_action", -1) == -1 && !arguments.containsKey("primaryTitle"))) {
            ((g0) getUI()).Ia();
            ((g0) getUI()).V4(true);
            f2();
        }
    }

    public final void d2() {
        ((g0) getUI()).s9(false);
        this.D = true;
        this.T.removeMessages(0);
    }

    public final void e2() {
        if (!this.Q) {
            ((g0) getUI()).L7();
        }
    }

    public final void f2() {
        this.f72758c.D(sl.f0.g().f(), true);
        this.f72758c.D(o6.b.g().f(), false);
        this.f72758c.D(m9.r.g().f(), false);
        this.f72758c.D(i8.k.g().f(), false);
        this.f72758c.D(c8.e.g().f(), false);
        this.f72758c.g0();
        this.f72763h.notifyDataSetChanged();
        this.f72764i.notifyDataSetChanged();
        BaseModuleConfig.a().z("huobiapp_market_market_favorite_currency_end", "huobiapp_market_market_favorite_currency_end", OptionsBridge.NETWORK_KEY, true);
        ((g0) getUI()).Gd();
    }

    public void g2(boolean z11) {
        if (this.f72759d.q()) {
            com.huobi.utils.w.d().f();
            Observable<R> compose = ContractCurrencyUtils.g(false).compose(RxJavaHelper.t((u6.g) getUI()));
            Observable<R> compose2 = SwapCurrencyInfoController.k().f(false).compose(RxJavaHelper.t((u6.g) getUI()));
            if (z11) {
                Observable.zip(compose, compose2, tl.n.f29358b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e());
            } else {
                Observable.zip(compose, compose2, IndexCurrencyInfoController.k().g(false).compose(RxJavaHelper.t((u6.g) getUI())), tl.h.f29351b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new f());
            }
        }
    }

    public void h2(boolean z11) {
        if (this.f72760e.n()) {
            com.huobi.utils.w.d().f();
            Observable<List<FutureContractInfo>> q11 = FutureContractInfoController.n().q(false);
            if (z11) {
                q11.compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g());
            } else {
                Observable.zip(q11, IndexCurrencyInfoController.k().g(false).compose(RxJavaHelper.t((u6.g) getUI())), tl.p.f29360b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new h());
            }
        }
    }

    public void i1() {
        MarketCoinPresenter marketCoinPresenter;
        zg.b bVar = this.f72780y;
        if (bVar != null) {
            int count = bVar.getCount();
            for (int i11 = 0; i11 < count; i11++) {
                Fragment item = this.f72780y.getItem(i11);
                if ((item instanceof MarketCoinFragment) && (marketCoinPresenter = (MarketCoinPresenter) ((MarketCoinFragment) item).yh()) != null) {
                    marketCoinPresenter.u0();
                }
            }
        }
    }

    public void i2(boolean z11) {
        if (z11) {
            m9.r.g().m();
            o6.b.g().m();
            i8.k.g().m();
            c8.e.g().m();
            q8.d.f().j();
            sl.f0.g().i();
        }
        Observable.zip(a1.v().Y(false, true).compose(RxJavaHelper.t((u6.g) getUI())), d7.k.C().E(false).compose(RxJavaHelper.t((u6.g) getUI())), tl.o.f29359b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
    }

    public final void j1() {
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
        if (this.C) {
            i1();
        }
        if (((g0) getUI()).r6() == null || "TAB_COLLECTION".equals(((g0) getUI()).r6())) {
            if (this.C) {
                u1();
            }
            if ("101".equals(((g0) getUI()).bh())) {
                E1(true);
                BaseModuleConfig.a().w("MT_ST_Page_PV", (HashMap) null);
            }
            MarketModuleConfig.a().q0(getActivity());
        } else if ("TAB_CONTRACT".equals(((g0) getUI()).r6())) {
            if (this.C) {
                x1();
            }
            MarketModuleConfig.a().q0(getActivity());
        } else {
            if (this.C) {
                p2();
            }
            MarketModuleConfig.a().q0(getActivity());
        }
        sl.f0.g().e("pro_overview_listener_tag", this.U);
        o6.b.g().e("contract_overview_listener_tag", this.V);
        i8.k.g().e("usdt_contract_overview_listener_tag", this.W);
        m9.r.g().e("swap_overview_listener_tag", this.Y);
        q8.d.f().e("option_overview_listener_tag", this.X);
        c8.e.g().e("index_overview_listener_tag", this.Z);
        this.O = Q().getArguments().getBoolean("MARKET_GO_POTENTIALS", false);
        this.P = Q().getArguments().getBoolean("MARKET_GO_PIONEER", false);
        Q().getArguments().remove("MARKET_GO_POTENTIALS");
        Q().getArguments().remove("MARKET_GO_PIONEER");
        if (this.O) {
            ((g0) getUI()).jh();
        }
        if (this.P) {
            ((g0) getUI()).N7();
        }
        if ("TAB_COLLECTION".equals(((g0) getUI()).r6())) {
            i2(false);
            g2(true);
        } else if ("TAB_ALL".equals(((g0) getUI()).r6())) {
            i2(true);
        } else if ("TAB_MAIN".equals(((g0) getUI()).r6())) {
            i2(true);
        } else if ("TAB_HADAX".equals(((g0) getUI()).r6())) {
            i2(true);
        } else if ("TAB_CONTRACT".equals(((g0) getUI()).r6())) {
            g2(false);
        } else if ("TAB_USDT_CONTRACT".equals(((g0) getUI()).r6())) {
            if (this.C) {
                A1();
            } else {
                h2(false);
            }
        } else if ("TAB_OPTION".equals(((g0) getUI()).r6())) {
            C1(false);
        } else {
            i2(true);
        }
        t1();
        if (this.Q) {
            ((g0) getUI()).i9(true);
        }
        ((g0) getUI()).vd(rl.p.e().f());
    }

    public void j2() {
        MarketCoinPresenter marketCoinPresenter;
        zg.b bVar = this.f72780y;
        if (bVar != null) {
            int count = bVar.getCount();
            for (int i11 = 0; i11 < count; i11++) {
                Fragment item = this.f72780y.getItem(i11);
                if ((item instanceof MarketCoinFragment) && (marketCoinPresenter = (MarketCoinPresenter) ((MarketCoinFragment) item).yh()) != null) {
                    marketCoinPresenter.I0();
                }
            }
        }
    }

    public void k1() {
        ((g0) getUI()).l8();
    }

    public void k2() {
        v7.b.a().getContentNavigation().d(new y());
    }

    public void l1() {
        if (this.B) {
            L1();
            if (NetworkStatus.c(getActivity()) && !this.D) {
                ((g0) getUI()).s9(true);
                this.T.removeMessages(0);
                this.T.sendEmptyMessageDelayed(0, 8000);
            }
        } else if (NetworkStatus.c(getActivity())) {
            n2();
        } else {
            ((g0) getUI()).pf(false);
            ((g0) getUI()).finishRefresh();
        }
    }

    public final void l2() {
        this.f72775t = this.f72759d.j().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new m());
    }

    public void m1(int i11) {
        Fragment item = this.f72780y.getItem(i11);
        if (item instanceof MarketCoinFragment) {
            ((MarketCoinFragment) item).Rh();
        }
    }

    public final void m2(boolean z11) {
        sl.f0.g().m();
        m9.r.g().m();
        o6.b.g().m();
        i8.k.g().m();
        c8.e.g().m();
        this.f72777v = Observable.zip(FutureContractInfoController.n().s(z11), FutureProductInfoController.d().h(z11), tl.q.f29361b).compose(RxJavaHelper.t((u6.g) null)).subscribe(new i());
    }

    public void n1() {
        this.S.clear();
    }

    public final void n2() {
        Subscription subscription = this.f72779x;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f72779x = Observable.zip(a1.v().Y(true, true).compose(RxJavaHelper.t((u6.g) getUI())), d7.k.C().E(true).compose(RxJavaHelper.t((u6.g) getUI())), tl.g.f29349b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c0());
    }

    public final void o1() {
        ((g0) getUI()).s9(false);
        this.E = true;
        this.T.removeMessages(1);
    }

    public final void o2() {
        this.f72776u = this.f72760e.h().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new n());
    }

    @k20.h
    @Keep
    public void onEvent(OnBackgroundStatusChangedEvent onBackgroundStatusChangedEvent) {
        this.R = onBackgroundStatusChangedEvent.a() == OnBackgroundStatusChangedEvent.STATUS.FOREGROUND;
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onMarketRedUpdate(MarketRedData marketRedData) {
        ((g0) getUI()).vd(marketRedData);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (((g0) getUI()).isCanBeSeen()) {
            MarketModuleConfig.a().p0(getActivity());
        }
    }

    public final void p1() {
        sl.f0.g().m();
        i8.k.g().m();
        q8.d.f().j();
        o6.b.g().i();
        o6.b.g().k("contract_overview_listener_tag");
        m9.r.g().i();
        m9.r.g().k("swap_overview_listener_tag");
        c8.e.g().i();
        c8.e.g().k("index_overview_listener_tag");
    }

    public final void p2() {
        MarketCoinPresenter marketCoinPresenter;
        zg.b bVar = this.f72780y;
        if (bVar != null) {
            int count = bVar.getCount();
            for (int i11 = 0; i11 < count; i11++) {
                Fragment item = this.f72780y.getItem(i11);
                if ((item instanceof MarketCoinFragment) && (marketCoinPresenter = (MarketCoinPresenter) ((MarketCoinFragment) item).yh()) != null) {
                    marketCoinPresenter.C0();
                }
            }
        }
    }

    public final void q1(List<ContentNavigationInfo> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ContentNavigationInfo next : list) {
            String title = next.getTitle();
            int type = next.getType();
            String url = next.getUrl();
            if (!TextUtils.isEmpty(url) && url.startsWith("/")) {
                url = url.replaceFirst("/", "");
            }
            Object obj = null;
            switch (type) {
                case 0:
                    obj = H5Fragment.Xh(BaseModuleConfig.a().o(url), false);
                    break;
                case 1:
                case 3:
                    obj = NewsHomeFragment.ci(type);
                    break;
                case 2:
                    obj = LiveSquareFragment.Rh(type, "");
                    break;
                case 4:
                    obj = H5Fragment.Xh(BaseModuleConfig.a().k(url), false);
                    break;
                case 5:
                    obj = CommunityFragment.E.a(type, 1, "");
                    break;
                case 6:
                    obj = H5Fragment.Xh(BaseModuleConfig.a().k(url), false);
                    break;
                case 8:
                    obj = NewsHomeFragment.ci(1);
                    break;
            }
            if (obj != null) {
                arrayList2.add(new TabData(title, type, type));
                arrayList.add(obj);
            }
        }
        ((g0) getUI()).Vb(arrayList2, arrayList);
    }

    public void q2(List<String> list) {
        if (list != null) {
            for (String str : list) {
                ConfigPreferences.m("user_config", "config_market_third_tab_memory_content" + str, "0");
            }
        }
        ConfigPreferences.m("user_config", "config_market_top_tab_memory_content", RankScreenBean.SCREEN_VALUE_SPOT);
        ConfigPreferences.m("user_config", "config_market_sec_tab_memory_content", "USDT");
    }

    public void r1(List<String> list) {
        this.f72760e.z(list);
        A1();
    }

    public void r2() {
        rl.l.c();
    }

    public void s1(List<String> list) {
        this.f72759d.F(list);
        x1();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0124, code lost:
        if (r11.equals("1") == false) goto L_0x010c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s2(android.os.Bundle r11) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0142
            java.lang.String r0 = "primaryTitle"
            boolean r1 = r11.containsKey(r0)
            if (r1 != 0) goto L_0x000c
            goto L_0x0142
        L_0x000c:
            java.util.Map<java.lang.String, java.lang.String> r1 = r10.S
            r2 = 0
            int r3 = r11.getInt(r0, r2)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r1.put(r0, r3)
            r11.remove(r0)
            java.util.Map<java.lang.String, java.lang.String> r1 = r10.S
            java.lang.String r3 = "secondaryTitle"
            java.lang.String r4 = ""
            java.lang.String r4 = r11.getString(r3, r4)
            r1.put(r3, r4)
            r11.remove(r3)
            java.util.Map<java.lang.String, java.lang.String> r1 = r10.S
            java.lang.String r3 = "filter"
            int r4 = r11.getInt(r3, r2)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r1.put(r3, r4)
            r11.remove(r3)
            java.util.Map<java.lang.String, java.lang.String> r1 = r10.S
            java.lang.String r4 = "sortType"
            int r5 = r11.getInt(r4, r2)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r1.put(r4, r5)
            r11.remove(r4)
            java.util.Map<java.lang.String, java.lang.String> r1 = r10.S
            java.lang.String r5 = "sort"
            int r6 = r11.getInt(r5, r2)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r1.put(r5, r6)
            r11.remove(r5)
            java.lang.String r11 = r10.z1(r0)
            java.lang.String r0 = "3"
            boolean r11 = r11.equals(r0)
            r1 = 1
            if (r11 == 0) goto L_0x008c
            java.lang.String r11 = r10.z1(r3)
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x008c
            java.util.Map<java.lang.String, java.lang.String> r11 = r10.S
            java.lang.String r6 = r10.z1(r3)
            int r6 = i6.m.l0(r6, r2)
            int r6 = r6 - r1
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r11.put(r3, r6)
        L_0x008c:
            java.lang.String r11 = r10.z1(r4)
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0142
            java.lang.String r11 = r10.z1(r5)
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0142
            java.lang.String r11 = r10.z1(r4)
            r11.hashCode()
            int r3 = r11.hashCode()
            r6 = 2
            java.lang.String r7 = "2"
            java.lang.String r8 = "1"
            r9 = -1
            switch(r3) {
                case 49: goto L_0x00d3;
                case 50: goto L_0x00ca;
                case 51: goto L_0x00c1;
                case 52: goto L_0x00b6;
                default: goto L_0x00b4;
            }
        L_0x00b4:
            r11 = r9
            goto L_0x00db
        L_0x00b6:
            java.lang.String r3 = "4"
            boolean r11 = r11.equals(r3)
            if (r11 != 0) goto L_0x00bf
            goto L_0x00b4
        L_0x00bf:
            r11 = 3
            goto L_0x00db
        L_0x00c1:
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L_0x00c8
            goto L_0x00b4
        L_0x00c8:
            r11 = r6
            goto L_0x00db
        L_0x00ca:
            boolean r11 = r11.equals(r7)
            if (r11 != 0) goto L_0x00d1
            goto L_0x00b4
        L_0x00d1:
            r11 = r1
            goto L_0x00db
        L_0x00d3:
            boolean r11 = r11.equals(r8)
            if (r11 != 0) goto L_0x00da
            goto L_0x00b4
        L_0x00da:
            r11 = r2
        L_0x00db:
            switch(r11) {
                case 0: goto L_0x00f7;
                case 1: goto L_0x00ef;
                case 2: goto L_0x00e7;
                case 3: goto L_0x00df;
                default: goto L_0x00de;
            }
        L_0x00de:
            goto L_0x00fe
        L_0x00df:
            java.util.Map<java.lang.String, java.lang.String> r11 = r10.S
            java.lang.String r3 = "type_amount"
            r11.put(r4, r3)
            goto L_0x00fe
        L_0x00e7:
            java.util.Map<java.lang.String, java.lang.String> r11 = r10.S
            java.lang.String r3 = "type_heigh_low"
            r11.put(r4, r3)
            goto L_0x00fe
        L_0x00ef:
            java.util.Map<java.lang.String, java.lang.String> r11 = r10.S
            java.lang.String r3 = "type_price"
            r11.put(r4, r3)
            goto L_0x00fe
        L_0x00f7:
            java.util.Map<java.lang.String, java.lang.String> r11 = r10.S
            java.lang.String r3 = "type_name"
            r11.put(r4, r3)
        L_0x00fe:
            java.lang.String r11 = r10.z1(r5)
            r11.hashCode()
            int r3 = r11.hashCode()
            switch(r3) {
                case 49: goto L_0x0120;
                case 50: goto L_0x0117;
                case 51: goto L_0x010e;
                default: goto L_0x010c;
            }
        L_0x010c:
            r2 = r9
            goto L_0x0127
        L_0x010e:
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L_0x0115
            goto L_0x010c
        L_0x0115:
            r2 = r6
            goto L_0x0127
        L_0x0117:
            boolean r11 = r11.equals(r7)
            if (r11 != 0) goto L_0x011e
            goto L_0x010c
        L_0x011e:
            r2 = r1
            goto L_0x0127
        L_0x0120:
            boolean r11 = r11.equals(r8)
            if (r11 != 0) goto L_0x0127
            goto L_0x010c
        L_0x0127:
            switch(r2) {
                case 0: goto L_0x013b;
                case 1: goto L_0x0133;
                case 2: goto L_0x012b;
                default: goto L_0x012a;
            }
        L_0x012a:
            goto L_0x0142
        L_0x012b:
            java.util.Map<java.lang.String, java.lang.String> r11 = r10.S
            java.lang.String r0 = "sort_desc"
            r11.put(r5, r0)
            goto L_0x0142
        L_0x0133:
            java.util.Map<java.lang.String, java.lang.String> r11 = r10.S
            java.lang.String r0 = "sort_asc"
            r11.put(r5, r0)
            goto L_0x0142
        L_0x013b:
            java.util.Map<java.lang.String, java.lang.String> r11 = r10.S
            java.lang.String r0 = "sort_normal"
            r11.put(r5, r0)
        L_0x0142:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.homemarket.presenter.HomeMarketNewPresenter.s2(android.os.Bundle):void");
    }

    public void t1() {
        qk.h.g().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }

    public final void t2(List<MarketRemindFlashItem> list, long j11) {
        i6.k.e("getRemindFlashListloadFlashData success");
        int size = this.f72762g.size();
        if (j11 == 0 || size == 0) {
            this.f72762g.clear();
            this.f72762g.addAll(list);
            this.f72765j.notifyDataSetChanged();
            i6.k.e("getRemindFlashListloadFlashData notifyDataSetChanged");
        } else {
            int i11 = size - 1;
            if (j11 == ((MarketRemindFlashItem) this.f72762g.get(i11)).g()) {
                this.f72762g.addAll(list);
                this.f72765j.notifyItemRangeChanged(i11, list.size() - 1);
                i6.k.e("getRemindFlashList  loadFlashData notifyItemRangeChanged");
            }
        }
        BaseModuleConfig.a().z("huobiapp_market_market_favorite_ai_end", "huobiapp_market_market_favorite_ai_end", OptionsBridge.NETWORK_KEY, true);
    }

    public void u1() {
        MarketModuleConfig.a().a().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e0());
        ((g0) getUI()).s9(false);
        this.f72775t = this.f72759d.j().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        this.f72774s = this.f72758c.y(getActivity()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new f0());
    }

    public void u2(String str, String str2) {
        MarketCoinPresenter marketCoinPresenter;
        zg.b bVar = this.f72780y;
        if (bVar != null) {
            int count = bVar.getCount();
            for (int i11 = 0; i11 < count; i11++) {
                Fragment item = this.f72780y.getItem(i11);
                if ((item instanceof MarketCoinFragment) && (marketCoinPresenter = (MarketCoinPresenter) ((MarketCoinFragment) item).yh()) != null) {
                    marketCoinPresenter.M0(str, str2);
                }
            }
        }
    }

    public final Subscription v1(List<SymbolPrice> list, boolean z11) {
        return Observable.just(list).subscribeOn(Schedulers.io()).map(new tl.m(this, z11)).observeOn(AndroidSchedulers.mainThread()).subscribe(new u(z11));
    }

    public void v2(String str, String str2) {
        this.f72758c.i0(str, str2);
        this.f72758c.g0();
        this.f72763h.notifyDataSetChanged();
        this.f72764i.notifyDataSetChanged();
    }

    public int w1(List<TabData> list, int i11) {
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (list.get(i12).getTabId() == i11) {
                return i12;
            }
        }
        return 0;
    }

    public void w2(String str, String str2) {
        this.f72759d.H(str, str2);
        this.f72759d.B(this.f72766k);
    }

    public void x1() {
        ((g0) getUI()).s9(false);
        if (!NetworkStatus.c(getActivity())) {
            i6.d.b("1.getContractData() called no network");
            if (this.f72759d.i().isEmpty()) {
                ((g0) getUI()).u7(false);
            } else {
                i6.d.b("1.getContractData() called has data");
                p1();
                ((g0) getUI()).F0();
            }
            ((g0) getUI()).finishRefresh();
            return;
        }
        MarketModuleConfig.a().a().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new b());
        if (MarketModuleConfig.a().C()) {
            ((g0) getUI()).u7(true);
            ((g0) getUI()).finishRefresh();
            return;
        }
        if (NetworkStatus.c(getActivity()) && !this.E) {
            ((g0) getUI()).s9(true);
            this.T.removeMessages(1);
            this.T.sendEmptyMessageDelayed(1, 8000);
        }
        if (!this.f72759d.r()) {
            ((g0) getUI()).s9(true);
        }
        l2();
    }

    public void x2(String str, String str2) {
        this.f72760e.B(str, str2);
        this.f72760e.v(this.f72767l);
    }

    public final Subscription y1(List<SymbolPrice> list) {
        return Observable.just(list).subscribeOn(Schedulers.io()).map(new tl.i(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new w());
    }

    public final void y2(List<String> list) {
        Map<String, CurrencyBean> u11 = d7.k.C().u();
        if (u11 != null && list != null) {
            Collections.sort(list, new tl.f(u11));
        }
    }

    public String z1(String str) {
        String str2 = this.S.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    public void z2(String str, String str2, boolean z11) {
        Subscription subscription = this.f72778w;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        if (!NetworkStatus.c(getActivity())) {
            ((g0) getUI()).u7(false);
            ((g0) getUI()).finishRefresh();
            return;
        }
        Subscription subscription2 = null;
        if (z11) {
            subscription2 = Observable.just(1).delay(500, TimeUnit.MILLISECONDS).compose(RxJavaHelper.t((u6.g) null)).subscribe(new j());
        }
        this.f72778w = Observable.interval(0, 2, TimeUnit.SECONDS).doOnNext(new l(str, str2, subscription2)).subscribe(new BaseSubscriber());
    }
}
