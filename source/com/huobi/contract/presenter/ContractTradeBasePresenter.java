package com.huobi.contract.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import bj.b0;
import bj.d1;
import bj.h2;
import bj.l0;
import bj.n0;
import bj.p0;
import bj.q2;
import bj.x2;
import bj.z2;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.constants.ConfigConstant;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.controller.FutureClearDialogConfigController;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractClearDialogConfig;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.bean.ContractOpenRight;
import com.hbg.lib.network.contract.core.bean.ContractOrderInsertRspInfo;
import com.hbg.lib.network.contract.core.bean.ContractSettlementPrice;
import com.hbg.lib.network.contract.core.bean.ContractSettlementPriceInfo;
import com.hbg.lib.network.contract.core.bean.ContractUserOrderLimit;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.contract.core.bean.PriceLimitInfo;
import com.hbg.lib.network.contract.core.bean.ReversalEstimatedLiquidationPrice;
import com.hbg.lib.network.contract.core.controller.ContractAllowLevelController;
import com.hbg.lib.network.contract.core.controller.ContractAllowMaxLevelController;
import com.hbg.lib.network.contract.core.controller.ContractHiddenInstrumentsController;
import com.hbg.lib.network.contract.core.controller.ContractOpenCloseController;
import com.hbg.lib.network.contract.core.controller.ContractSettlementController;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroAvailablePositionBean;
import com.hbg.lib.network.hbg.core.bean.NewBannerBean;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.response.LastKlineResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.contract.service.ContractService;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractActivityInfo;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractCalmPeriodInfo;
import com.huobi.contract.entity.ContractCancelOrderResult;
import com.huobi.contract.entity.ContractChangeEvent;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.entity.FuturesActivityInfo;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.helper.ContractPriceProtectionHelper;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.contract.ui.ContractHoldStopDialogFragment;
import com.huobi.contract.ui.ContractMarketClosingDialog;
import com.huobi.contract.ui.ContractPositionTradeDialogFragment;
import com.huobi.contract.ui.ContractTradeBaseFragment;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.kyc.util.KycProxy;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.share.helper.CaptureShareHelper;
import com.huobi.swap.bean.ClearInputEvent;
import com.huobi.swap.ui.SwapTradeBaseFragment;
import com.huobi.utils.ContractGlobalStatus;
import com.huobi.utils.k0;
import com.huobi.webview2.ui.ContractWebActivity;
import com.tencent.android.tpush.common.Constants;
import dj.p1;
import g9.a;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
import pro.huobi.R;
import qk.o0;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ContractTradeBasePresenter<V extends p1> extends BaseFragmentPresenter<V> implements h2.j, h2.k, q2.e {
    public boolean A;
    public long B;
    public long C;
    public int D = 5;
    public BigDecimal E;
    public View F;
    public ej.e G;
    public a.d H = new j();
    public LastKlineListener I = new l();
    public ContractPosition.a J = new o();
    public final MutableLiveData<List<NewBannerBean.BannerAdv>> K;
    public LiveData<List<NewBannerBean.BannerAdv>> L;
    public final MutableLiveData<Boolean> M;
    public LiveData<Boolean> N;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43126c;

    /* renamed from: d  reason: collision with root package name */
    public Subscriber<List<ContractAccountInfo>> f43127d;

    /* renamed from: e  reason: collision with root package name */
    public Subscriber<String> f43128e;

    /* renamed from: f  reason: collision with root package name */
    public Subscriber<Long> f43129f;

    /* renamed from: g  reason: collision with root package name */
    public Subscriber<Long> f43130g;

    /* renamed from: h  reason: collision with root package name */
    public Subscriber<List<ContractCurrencyInfo>> f43131h;

    /* renamed from: i  reason: collision with root package name */
    public Subscriber<ContractHeartBeat> f43132i;

    /* renamed from: j  reason: collision with root package name */
    public Subscriber f43133j;

    /* renamed from: k  reason: collision with root package name */
    public Subscription f43134k;

    /* renamed from: l  reason: collision with root package name */
    public Subscriber<List<PriceLimitInfo>> f43135l;

    /* renamed from: m  reason: collision with root package name */
    public Subscriber<List<ContractSettlementPrice>> f43136m;

    /* renamed from: n  reason: collision with root package name */
    public ContractCurrencyInfo f43137n;

    /* renamed from: o  reason: collision with root package name */
    public String f43138o;

    /* renamed from: p  reason: collision with root package name */
    public d1 f43139p;

    /* renamed from: q  reason: collision with root package name */
    public h2 f43140q;

    /* renamed from: r  reason: collision with root package name */
    public q2 f43141r;

    /* renamed from: s  reason: collision with root package name */
    public TradeType f43142s = TradeType.CONTRACT;

    /* renamed from: t  reason: collision with root package name */
    public boolean f43143t;

    /* renamed from: u  reason: collision with root package name */
    public BaseDialogFragment f43144u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f43145v = bj.d.s();

    /* renamed from: w  reason: collision with root package name */
    public l0.i f43146w;

    /* renamed from: x  reason: collision with root package name */
    public int f43147x = -1;

    /* renamed from: y  reason: collision with root package name */
    public boolean f43148y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f43149z;

    public class a extends BaseSubscriber<ContractHeartBeat> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(ContractHeartBeat contractHeartBeat) {
            super.onNext(contractHeartBeat);
            boolean z11 = contractHeartBeat != null && contractHeartBeat.isSysSafeguard();
            if (z11) {
                ContractTradeBasePresenter.this.H2();
            } else if (ContractTradeBasePresenter.this.f43145v != z11) {
                ContractTradeBasePresenter.this.Y2();
            } else {
                return;
            }
            boolean unused = ContractTradeBasePresenter.this.f43145v = z11;
        }
    }

    public class b extends BaseSubscriber<List<ContractCurrencyInfo>> {
        public b() {
        }

        public void onNext(List<ContractCurrencyInfo> list) {
            Iterator<ContractCurrencyInfo> it2 = list.iterator();
            ContractCurrencyInfo contractCurrencyInfo = null;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ContractCurrencyInfo next = it2.next();
                if (next.getContractCode().equals(ContractTradeBasePresenter.this.f43137n.getContractCode())) {
                    if (!ContractTradeBasePresenter.this.f43143t) {
                        ContractTradeBasePresenter.this.m2(next);
                        boolean unused = ContractTradeBasePresenter.this.f43143t = true;
                        if (!next.isShowCover()) {
                            ContractTradeBasePresenter.this.x2();
                        }
                    } else {
                        ContractTradeBasePresenter.this.f43137n.setDelivTime(next.getDelivTime());
                        ContractTradeBasePresenter.this.f43137n.setSettlementTime(next.getSettlementTime());
                        ContractTradeBasePresenter.this.f43137n.setNotSupportTrade(next.isNotSupportTrade());
                        ContractTradeBasePresenter.this.x2();
                    }
                    boolean z11 = (TextUtils.isEmpty(next.getActivityId()) && !TextUtils.isEmpty(ContractTradeBasePresenter.this.f43137n.getActivityId())) || (!TextUtils.isEmpty(next.getActivityId()) && !next.getActivityId().equals(ContractTradeBasePresenter.this.f43137n.getActivityId()));
                    if (next.getContractStatus() != ContractTradeBasePresenter.this.f43137n.getContractStatus() || z11) {
                        if (!next.getContractType().equals(ContractTradeBasePresenter.this.f43137n.getContractType())) {
                            ContractTradeBasePresenter.this.m2(next);
                            ContractTradeBasePresenter contractTradeBasePresenter = ContractTradeBasePresenter.this;
                            String unused2 = contractTradeBasePresenter.f43138o = contractTradeBasePresenter.f43137n.getSymbol();
                            ContractTradeBasePresenter.this.f43141r.H(ContractTradeBasePresenter.this.f43138o);
                            ContractTradeBasePresenter.this.f43141r.D(ContractTradeBasePresenter.this.f43137n);
                            ((p1) ContractTradeBasePresenter.this.getUI()).Sd(ContractTradeBasePresenter.this.f43137n);
                            ((p1) ContractTradeBasePresenter.this.getUI()).Q1(8, ContractTradeBasePresenter.this.f43137n);
                            ContractTradeBasePresenter.this.f43141r.C();
                        } else {
                            ContractTradeBasePresenter.this.m2(next);
                        }
                        if (next.isShowCover()) {
                            ContractTradeBasePresenter.this.w2(next);
                        } else {
                            ((p1) ContractTradeBasePresenter.this.getUI()).Q1(8, next);
                            ContractTradeBasePresenter.this.x2();
                        }
                    } else if (next.isShowCover()) {
                        ContractTradeBasePresenter.this.w2(next);
                    }
                } else if ("quarter".equals(next.getContractType()) && ContractTradeBasePresenter.this.f43138o.equals(next.getSymbol())) {
                    contractCurrencyInfo = next;
                }
            }
            if (!list.contains(ContractTradeBasePresenter.this.f43137n) && contractCurrencyInfo != null) {
                boolean unused3 = ContractTradeBasePresenter.this.f43143t = true;
                ContractCurrencyInfo unused4 = ContractTradeBasePresenter.this.f43137n = contractCurrencyInfo;
                ContractTradeBasePresenter.this.m2(contractCurrencyInfo);
                ContractTradeBasePresenter contractTradeBasePresenter2 = ContractTradeBasePresenter.this;
                String unused5 = contractTradeBasePresenter2.f43138o = contractTradeBasePresenter2.f43137n.getSymbol();
                ContractTradeBasePresenter.this.f43141r.H(ContractTradeBasePresenter.this.f43138o);
                ContractTradeBasePresenter.this.f43141r.D(ContractTradeBasePresenter.this.f43137n);
                ((p1) ContractTradeBasePresenter.this.getUI()).Sd(ContractTradeBasePresenter.this.f43137n);
                ((p1) ContractTradeBasePresenter.this.getUI()).Q1(8, ContractTradeBasePresenter.this.f43137n);
                ContractTradeBasePresenter.this.r2();
                ContractTradeBasePresenter.this.f43141r.C();
            }
            if (ContractTradeBasePresenter.this.f43137n.isNotSupportTrade()) {
                ((p1) ContractTradeBasePresenter.this.getUI()).m1();
            }
        }
    }

    public class c extends BaseSubscriber<List<ContractCurrencyInfo>> {
        public c() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            List<SwapCurrencyInfo> e11 = SwapCurrencyInfoController.k().e();
            if (e11 != null && !e11.isEmpty()) {
                SwapTradeBaseFragment.Qi(ContractTradeBasePresenter.this.getActivity(), e11.get(0));
            }
        }

        public void onNext(List<ContractCurrencyInfo> list) {
            super.onNext(list);
            ContractTradeBasePresenter.this.m2(ContractUserInfoProvider.i().l(ContractCurrencyUtils.m()));
            ContractTradeBasePresenter.this.u1();
        }
    }

    public class d extends BaseSubscriber<Long> {

        public class a extends BaseSubscriber<ContractActivityInfo> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(ContractActivityInfo contractActivityInfo) {
                super.onNext(contractActivityInfo);
                if (contractActivityInfo == null || contractActivityInfo.getProductId() == null || ContractTradeBasePresenter.this.f43137n == null || !contractActivityInfo.getProductId().contains(ContractTradeBasePresenter.this.f43137n.getSymbol())) {
                    contractActivityInfo = null;
                }
                ((p1) ContractTradeBasePresenter.this.getUI()).C2(FuturesActivityInfo.contractToFutures(contractActivityInfo), ContractTradeBasePresenter.this.f43138o);
            }
        }

        public d() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            if (TextUtils.isEmpty(ContractTradeBasePresenter.this.f43137n.getActivityId())) {
                ((p1) ContractTradeBasePresenter.this.getUI()).S0();
                ContractTradeBasePresenter.this.Q2();
                return;
            }
            ((ContractService) ContractRetrofit.request(ContractService.class)).activityInfo(ContractTradeBasePresenter.this.f43137n.getActivityId()).compose(ContractRetrofit.h()).compose(RxJavaHelper.t((u6.g) ContractTradeBasePresenter.this.getUI())).subscribe(new a());
        }
    }

    public class e extends BaseSubscriber<Integer> {
        public e() {
        }

        /* renamed from: a */
        public void onNext(Integer num) {
            super.onNext(num);
            ((p1) ContractTradeBasePresenter.this.getUI()).s1(ContractTradeBasePresenter.this.f43138o);
            if (num != null) {
                if (num.intValue() == 1) {
                    ContractTradeBasePresenter.this.o2(4);
                } else if (num.intValue() == 2) {
                    ContractTradeBasePresenter.this.o2(5);
                }
            }
            ((p1) ContractTradeBasePresenter.this.getUI()).E1(ContractTradeBasePresenter.this.D);
        }
    }

    public class f extends BaseSubscriber<List<String>> {
        public f() {
        }

        public void onNext(List<String> list) {
            super.onNext(list);
        }
    }

    public class g extends BaseSubscriber<ContractOpenRight> {
        public g() {
        }

        /* renamed from: a */
        public void onNext(ContractOpenRight contractOpenRight) {
            super.onNext(contractOpenRight);
            if (contractOpenRight.getRight() == 0) {
                z2.c().b("CLEAR_AFTER_NAME", 1);
                if (((p1) ContractTradeBasePresenter.this.getUI()).getPositionType() == 0) {
                    ((p1) ContractTradeBasePresenter.this.getUI()).z0(false);
                } else {
                    ((p1) ContractTradeBasePresenter.this.getUI()).z0(true);
                }
            } else {
                ((p1) ContractTradeBasePresenter.this.getUI()).z0(true);
                z2.c().b("CLEAR_AFTER_NAME", 3);
                ContractTradeBasePresenter.this.p2();
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            z2.c().b("CLEAR_AFTER_NAME", 3);
            ContractTradeBasePresenter.this.p2();
        }
    }

    public class h extends BaseSubscriber<ContractClearDialogConfig> {
        public h() {
        }

        /* renamed from: a */
        public void onNext(ContractClearDialogConfig contractClearDialogConfig) {
            super.onNext(contractClearDialogConfig);
            if (FutureClearDialogConfigController.g(20)) {
                z2.c().b("CLEAR_NAME", 1);
                ((p1) ContractTradeBasePresenter.this.getUI()).p0(contractClearDialogConfig.getRulesUrl(), contractClearDialogConfig.getTips());
                return;
            }
            z2.c().b("CLEAR_NAME", 3);
            ContractTradeBasePresenter.this.p2();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            z2.c().b("CLEAR_NAME", 3);
            ContractTradeBasePresenter.this.p2();
        }
    }

    public class i extends BaseSubscriber<List<PriceLimitInfo>> {
        public i() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ((p1) ContractTradeBasePresenter.this.getUI()).K5((PriceLimitInfo) null);
        }

        public void onNext(List<PriceLimitInfo> list) {
            if (list == null || list.size() <= 0) {
                ((p1) ContractTradeBasePresenter.this.getUI()).K5((PriceLimitInfo) null);
            } else {
                ((p1) ContractTradeBasePresenter.this.getUI()).K5(list.get(0));
            }
        }
    }

    public class j implements a.d {
        public j() {
        }

        public void a() {
            ContractTradeBasePresenter.this.f3(true);
        }
    }

    public class k implements h2.i {
        public k() {
        }

        public int B0() {
            return ((p1) ContractTradeBasePresenter.this.getUI()).B0();
        }

        public void C0(aj.c cVar) {
            if (ContractTradeBasePresenter.this.f43144u != null && (ContractTradeBasePresenter.this.f43144u instanceof ContractHoldStopDialogFragment) && ContractTradeBasePresenter.this.f43144u.isVisible() && !TextUtils.isEmpty(cVar.e().getTpslOrderType()) && ((ContractHoldStopDialogFragment) ContractTradeBasePresenter.this.f43144u).Xh() && TextUtils.equals(((ContractHoldStopDialogFragment) ContractTradeBasePresenter.this.f43144u).R0(), cVar.e().getOrderId()) && ((ContractHoldStopDialogFragment) ContractTradeBasePresenter.this.f43144u).Vh() != null && !TextUtils.isEmpty(cVar.e().getLastPrice()) && cVar.e().getLastPrice().equals(((ContractHoldStopDialogFragment) ContractTradeBasePresenter.this.f43144u).Vh().getLastPrice())) {
                ContractHoldStopDialogFragment contractHoldStopDialogFragment = (ContractHoldStopDialogFragment) ContractTradeBasePresenter.this.f43144u;
                String str = "buy";
                if (str.equalsIgnoreCase(contractHoldStopDialogFragment.Uh())) {
                    str = "sell";
                }
                if (cVar.e().getContractCode().equals(contractHoldStopDialogFragment.Th()) && str.equals(contractHoldStopDialogFragment.Uh())) {
                    ContractPosition unused = ContractTradeBasePresenter.this.E1(cVar, contractHoldStopDialogFragment.Vh());
                    contractHoldStopDialogFragment.li();
                }
            }
        }

        public void f(int i11) {
            ((p1) ContractTradeBasePresenter.this.getUI()).f(i11);
        }

        public void g(int i11) {
            ((p1) ContractTradeBasePresenter.this.getUI()).g(i11);
        }

        public void h(int i11) {
            ((p1) ContractTradeBasePresenter.this.getUI()).h(i11);
        }

        public void i(int i11) {
            ((p1) ContractTradeBasePresenter.this.getUI()).i(i11);
        }
    }

    public class l extends LastKlineListener {
        public l() {
        }

        /* renamed from: j */
        public void f(LastKlineResponse lastKlineResponse) {
            ContractTradeBasePresenter.this.o3(lastKlineResponse);
        }

        public void onFailed(Throwable th2) {
            super.onFailed(th2);
            th2.printStackTrace();
            i6.k.g(this.f70671a, "lastKlineListener has error ", th2);
        }
    }

    public class m extends BaseSubscriber<List<String>> {
        public m() {
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            ((p1) ContractTradeBasePresenter.this.getUI()).setLeverList(list);
        }
    }

    public class n extends BaseSubscriber<List<ContractUserOrderLimit>> {
        public n() {
        }

        public void onNext(List<ContractUserOrderLimit> list) {
            super.onNext(list);
        }
    }

    public class o implements ContractPosition.a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f43165a = false;

        /* renamed from: b  reason: collision with root package name */
        public ReversalEstimatedLiquidationPrice f43166b;

        public class a extends EasySubscriber<ReversalEstimatedLiquidationPrice> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ HBDialogFragment f43168b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ ContractPosition f43169c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ DialogUtils.b f43170d;

            public a(HBDialogFragment hBDialogFragment, ContractPosition contractPosition, DialogUtils.b bVar) {
                this.f43168b = hBDialogFragment;
                this.f43169c = contractPosition;
                this.f43170d = bVar;
            }

            /* renamed from: a */
            public void onNext(ReversalEstimatedLiquidationPrice reversalEstimatedLiquidationPrice) {
                super.onNext(reversalEstimatedLiquidationPrice);
                if (!this.f43168b.isDetached()) {
                    o oVar = o.this;
                    oVar.f43166b = reversalEstimatedLiquidationPrice;
                    oVar.p(this.f43169c, this.f43170d);
                }
            }
        }

        public class b extends q6.d<ContractOrderInsertRspInfo> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HBDialogFragment f43172e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(u6.g gVar, HBDialogFragment hBDialogFragment) {
                super(gVar);
                this.f43172e = hBDialogFragment;
            }

            public void onAfter() {
                super.onAfter();
                HBDialogFragment hBDialogFragment = this.f43172e;
                if (hBDialogFragment != null) {
                    hBDialogFragment.dismiss();
                }
            }
        }

        public class c implements LeverSelectDialogFragment.h {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ContractPosition f43174a;

            public c(ContractPosition contractPosition) {
                this.f43174a = contractPosition;
            }

            public void N0() {
                String str;
                String str2 = a7.e.E(TradeType.CONTRACT) ? "symbol" : "sheet";
                if ("cny".equals(LegalCurrencyConfigUtil.y())) {
                    str = "cny";
                } else {
                    str = "usd";
                }
                ContractWebActivity.hi(ContractTradeBasePresenter.this.getActivity(), this.f43174a.getSymbol(), str2, str, this.f43174a.getContractCode(), this.f43174a.getContractCurrencyInfo() != null ? this.f43174a.getContractCurrencyInfo().getContractShortType() : "", 1);
            }

            public Observable<List<LevelAvailableMarginInfo>> O0(TradeType tradeType, String str, int i11) {
                return uc.b.d(tradeType, str, i11);
            }

            public void P0(String str) {
                if (TextUtils.equals(ContractTradeBasePresenter.this.f43138o, this.f43174a.getSymbol())) {
                    ((p1) ContractTradeBasePresenter.this.getUI()).x0(str);
                    ContractTradeBasePresenter.this.f43141r.E(str);
                    ContractTradeBasePresenter.this.f43141r.B();
                    return;
                }
                ContractTradeBasePresenter.this.n3();
            }

            public String[] Q0(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
                return new String[2];
            }

            public boolean R0(LeverSelectDialogFragment leverSelectDialogFragment, String str) {
                if (ContractTradeBasePresenter.this.f43141r == null) {
                    return true;
                }
                ContractTradeBasePresenter.this.f43141r.A(leverSelectDialogFragment, str, this.f43174a.getSymbol());
                return true;
            }
        }

        public o() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(ContractPosition contractPosition, HBDialogFragment hBDialogFragment) {
            ContractTradeBasePresenter.this.h3();
            p0.n(!this.f43165a);
            m(contractPosition, hBDialogFragment);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void o(boolean z11) {
            this.f43165a = z11;
        }

        public String a() {
            return ContractWebActivity.Eh(1);
        }

        public void b(aj.c cVar, Context context) {
            ContractHoldStopDialogFragment contractHoldStopDialogFragment = new ContractHoldStopDialogFragment();
            contractHoldStopDialogFragment.fi(ContractTradeBasePresenter.this.E1(cVar, new ContractPosition()));
            contractHoldStopDialogFragment.gi(TextUtils.equals(cVar.e().getTpslOrderType(), "sl") ? 3 : 2);
            BaseDialogFragment unused = ContractTradeBasePresenter.this.f43144u = contractHoldStopDialogFragment;
            ContractTradeBasePresenter.this.f43144u.show(ContractTradeBasePresenter.this.getActivity().getSupportFragmentManager(), "ContractPositionTradeDialogFragment");
            ContractTradeBasePresenter.this.g3("stop_surplus_loss");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0051, code lost:
            if (com.hbg.lib.core.util.w.l() != false) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x003f, code lost:
            if (com.hbg.lib.core.util.w.l() != false) goto L_0x0054;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(com.huobi.contract.entity.ContractPosition r12) {
            /*
                r11 = this;
                java.lang.String r0 = "ACTION-SWAP"
                java.lang.String r1 = "持仓item中按钮点击一键反手"
                i6.k.o(r0, r1)
                com.huobi.contract.presenter.ContractTradeBasePresenter r0 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                java.lang.String r1 = "key_backhand"
                r0.g3(r1)
                boolean r0 = bj.p0.f()
                r1 = 0
                if (r0 != 0) goto L_0x0019
                r11.m(r12, r1)
                return
            L_0x0019:
                r0 = 0
                r11.f43165a = r0
                r11.f43166b = r1
                java.lang.String r1 = r12.getDirection()
                com.hbg.lib.network.option.core.util.OptionDirection r2 = com.hbg.lib.network.option.core.util.OptionDirection.BUY
                java.lang.String r2 = r2.direction
                boolean r1 = r2.equalsIgnoreCase(r1)
                r2 = 2131100799(0x7f06047f, float:1.781399E38)
                r3 = 2131100818(0x7f060492, float:1.7814028E38)
                if (r1 == 0) goto L_0x0044
                com.huobi.contract.presenter.ContractTradeBasePresenter r1 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                r4 = 2132020977(0x7f140ef1, float:1.9680332E38)
                java.lang.String r1 = r1.getString(r4)
                boolean r4 = com.hbg.lib.core.util.w.l()
                if (r4 == 0) goto L_0x0042
                goto L_0x0054
            L_0x0042:
                r2 = r3
                goto L_0x0054
            L_0x0044:
                com.huobi.contract.presenter.ContractTradeBasePresenter r1 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                r4 = 2132020996(0x7f140f04, float:1.968037E38)
                java.lang.String r1 = r1.getString(r4)
                boolean r4 = com.hbg.lib.core.util.w.l()
                if (r4 == 0) goto L_0x0054
                goto L_0x0042
            L_0x0054:
                com.huobi.contract.presenter.ContractTradeBasePresenter r4 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                r5 = 2132020961(0x7f140ee1, float:1.96803E38)
                java.lang.String r4 = r4.getString(r5)
                com.huobi.contract.presenter.ContractTradeBasePresenter r5 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                r6 = 2132020964(0x7f140ee4, float:1.9680306E38)
                java.lang.String r5 = r5.getString(r6)
                r6 = 2
                java.lang.Object[] r6 = new java.lang.Object[r6]
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = r12.getSymbol()
                r7.append(r8)
                java.lang.String r8 = "usd"
                java.lang.String r8 = com.hbg.lib.common.utils.StringUtils.i(r8)
                r7.append(r8)
                r7.append(r1)
                java.lang.String r8 = r12.getLeverRate()
                r7.append(r8)
                java.lang.String r8 = "X"
                r7.append(r8)
                java.lang.String r7 = r7.toString()
                r6[r0] = r7
                r7 = 1
                r6[r7] = r4
                java.lang.String r5 = java.lang.String.format(r5, r6)
                int r6 = r5.indexOf(r1)
                android.text.SpannableStringBuilder r8 = new android.text.SpannableStringBuilder
                r8.<init>(r5)
                android.text.style.ForegroundColorSpan r9 = new android.text.style.ForegroundColorSpan
                com.huobi.contract.presenter.ContractTradeBasePresenter r10 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                com.hbg.lib.common.ui.BaseCoreActivity r10 = r10.getActivity()
                int r2 = androidx.core.content.ContextCompat.getColor(r10, r2)
                r9.<init>(r2)
                int r1 = r1.length()
                int r1 = r1 + r6
                r2 = 33
                r8.setSpan(r9, r6, r1, r2)
                int r1 = r5.indexOf(r4)
                android.text.style.ForegroundColorSpan r5 = new android.text.style.ForegroundColorSpan
                com.huobi.contract.presenter.ContractTradeBasePresenter r6 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                com.hbg.lib.common.ui.BaseCoreActivity r6 = r6.getActivity()
                int r3 = androidx.core.content.ContextCompat.getColor(r6, r3)
                r5.<init>(r3)
                int r3 = r4.length()
                int r3 = r3 + r1
                r8.setSpan(r5, r1, r3, r2)
                com.huobi.contract.presenter.ContractTradeBasePresenter r1 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                r2 = 2132020963(0x7f140ee3, float:1.9680304E38)
                java.lang.String r1 = r1.getString(r2)
                java.lang.String r2 = r12.getMarketClosingSlippage()
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x012b
                java.lang.String r2 = r12.getMarketClosingSlippage()
                java.lang.String r3 = r12.getContractCode()
                int r3 = ej.f.p(r3)
                java.lang.String r2 = i6.m.m(r2, r3)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r1)
                com.huobi.contract.presenter.ContractTradeBasePresenter r1 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                r4 = 2132020908(0x7f140eac, float:1.9680192E38)
                java.lang.String r1 = r1.getString(r4)
                java.lang.Object[] r4 = new java.lang.Object[r7]
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r2)
                java.lang.String r2 = " USD"
                r5.append(r2)
                java.lang.String r2 = r5.toString()
                r4[r0] = r2
                java.lang.String r0 = java.lang.String.format(r1, r4)
                r3.append(r0)
                java.lang.String r1 = r3.toString()
            L_0x012b:
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = new com.hbg.lib.widgets.dialog.DialogUtils$b$d
                com.huobi.contract.presenter.ContractTradeBasePresenter r2 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                com.hbg.lib.common.ui.BaseCoreActivity r2 = r2.getActivity()
                r0.<init>(r2)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.n0(r7)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.T0(r7)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.X0(r7)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.q0(r7)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.x0(r7)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.c1(r8)
                r2 = 1098907648(0x41800000, float:16.0)
                float r2 = com.hbg.lib.common.utils.PixelUtils.b(r2)
                java.lang.Float r2 = java.lang.Float.valueOf(r2)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.h1(r2)
                com.huobi.contract.presenter.ContractTradeBasePresenter r2 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099897(0x7f0600f9, float:1.781216E38)
                int r2 = r2.getColor(r3)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.D0(r2)
                r2 = 1096810496(0x41600000, float:14.0)
                float r3 = com.hbg.lib.common.utils.PixelUtils.b(r2)
                java.lang.Float r3 = java.lang.Float.valueOf(r3)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.H0(r3)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.R0(r1)
                com.huobi.contract.presenter.ContractTradeBasePresenter r1 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                android.content.res.Resources r1 = r1.getResources()
                r3 = 2131099907(0x7f060103, float:1.781218E38)
                int r1 = r1.getColor(r3)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.S0(r1)
                float r1 = com.hbg.lib.common.utils.PixelUtils.b(r2)
                java.lang.Float r1 = java.lang.Float.valueOf(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.W0(r1)
                com.huobi.contract.presenter.ContractTradeBasePresenter r1 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                r2 = 2132020548(0x7f140d44, float:1.9679462E38)
                java.lang.String r1 = r1.getString(r2)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.P0(r1)
                cj.q r1 = new cj.q
                r1.<init>(r11, r12)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.Q0(r1)
                com.huobi.contract.presenter.ContractTradeBasePresenter r1 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                r2 = 2132020382(0x7f140c9e, float:1.9679126E38)
                java.lang.String r1 = r1.getString(r2)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.s0(r1)
                bj.o0 r1 = bj.o0.f12469a
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.N0(r1)
                com.huobi.contract.presenter.ContractTradeBasePresenter r1 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                r2 = 2132020768(0x7f140e20, float:1.9679908E38)
                java.lang.String r1 = r1.getString(r2)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.y0(r1)
                com.huobi.contract.presenter.ContractTradeBasePresenter r1 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                android.content.res.Resources r1 = r1.getResources()
                r2 = 2131099918(0x7f06010e, float:1.7812203E38)
                int r1 = r1.getColor(r2)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.z0(r1)
                r1 = 1094713344(0x41400000, float:12.0)
                float r1 = com.hbg.lib.common.utils.PixelUtils.b(r1)
                java.lang.Float r1 = java.lang.Float.valueOf(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.A0(r1)
                cj.p r1 = new cj.p
                r1.<init>(r11)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.v0(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b r0 = r0.m0()
                cj.r r1 = new cj.r
                r1.<init>(r11, r12, r0)
                com.hbg.lib.widgets.dialog.HBDialogFragment r1 = r0.y0(r1)
                com.huobi.contract.presenter.ContractTradeBasePresenter r2 = com.huobi.contract.presenter.ContractTradeBasePresenter.this
                com.hbg.lib.common.ui.BaseCoreActivity r2 = r2.getActivity()
                androidx.fragment.app.FragmentManager r2 = r2.getSupportFragmentManager()
                java.lang.String r3 = "reverseDialogFragment"
                r1.show(r2, r3)
                r11.r(r12, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.contract.presenter.ContractTradeBasePresenter.o.c(com.huobi.contract.entity.ContractPosition):void");
        }

        public void d(ContractPosition contractPosition) {
            i6.k.o("ACTION-CONTRACT", "币本位交割持仓item中按钮点击仓位止盈止损");
            ContractHoldStopDialogFragment contractHoldStopDialogFragment = new ContractHoldStopDialogFragment();
            contractHoldStopDialogFragment.f43197g = 1;
            contractHoldStopDialogFragment.fi(contractPosition);
            contractHoldStopDialogFragment.gi(2);
            BaseDialogFragment unused = ContractTradeBasePresenter.this.f43144u = contractHoldStopDialogFragment;
            ContractTradeBasePresenter.this.f43144u.show(ContractTradeBasePresenter.this.getActivity().getSupportFragmentManager(), "ContractPositionTradeDialogFragment");
        }

        public LeverSelectDialogFragment.h e(ContractPosition contractPosition) {
            return new c(contractPosition);
        }

        public void f(ContractPosition contractPosition) {
            CaptureShareHelper.g(ContractTradeBasePresenter.this.getActivity(), contractPosition, CaptureShareHelper.ContractType.Contract);
            is.a.j("4690", (Map<String, Object>) null, is.a.f(TradeType.CONTRACT));
            ContractTradeBasePresenter.this.g3("hold_share");
        }

        public void g(ContractPosition contractPosition) {
            ContractTradeBaseFragment.Si(ContractTradeBasePresenter.this.getActivity(), contractPosition.getContractCurrencyInfo(), 0, false);
        }

        public void h(int i11, ContractPosition contractPosition, int i12, Context context) {
            if (ContractTradeBasePresenter.this.f43144u != null && ContractTradeBasePresenter.this.f43144u.isVisible()) {
                ContractTradeBasePresenter.this.f43144u.doDismiss();
            }
            if (i11 == 0) {
                i6.k.o("ACTION-CONTRACT", "持仓item中按钮点击平仓");
                if (i6.m.a(contractPosition.getAvailable()).compareTo(BigDecimal.ZERO) <= 0) {
                    HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                    return;
                }
                ContractPositionTradeDialogFragment contractPositionTradeDialogFragment = new ContractPositionTradeDialogFragment();
                contractPositionTradeDialogFragment.xi(contractPosition);
                BaseDialogFragment unused = ContractTradeBasePresenter.this.f43144u = contractPositionTradeDialogFragment;
                ContractTradeBasePresenter.this.f43144u.show(ContractTradeBasePresenter.this.getActivity().getSupportFragmentManager(), "ContractPositionTradeDialogFragment");
                ContractTradeBasePresenter.this.g3("flat");
            } else if (i11 == 1) {
                i6.k.o("ACTION-CONTRACT", "持仓item中按钮点击市价全平");
                if (p0.a()) {
                    if (i6.m.a(contractPosition.getAvailable()).compareTo(BigDecimal.ZERO) <= 0) {
                        contractPosition.setAvailable(contractPosition.getVolume());
                    }
                    ContractMarketClosingDialog contractMarketClosingDialog = new ContractMarketClosingDialog();
                    contractMarketClosingDialog.Ch(contractPosition);
                    BaseDialogFragment unused2 = ContractTradeBasePresenter.this.f43144u = contractMarketClosingDialog;
                    ContractTradeBasePresenter.this.f43144u.show(ContractTradeBasePresenter.this.getActivity().getSupportFragmentManager(), "ContractPositionTradeDialogFragment");
                } else if (i6.m.a(contractPosition.getAvailable()).compareTo(BigDecimal.ZERO) <= 0) {
                    HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                    return;
                } else {
                    d1 p12 = ContractTradeBasePresenter.this.f43139p;
                    p12.T(contractPosition.getContractCode() + contractPosition.getDirection(), contractPosition);
                    ContractTradeBasePresenter.this.f2(contractPosition);
                }
                ContractTradeBasePresenter.this.g3("market_price_flat");
            } else {
                i6.k.o("ACTION-CONTRACT", "持仓item中按钮点击止盈止损");
                ContractHoldStopDialogFragment contractHoldStopDialogFragment = new ContractHoldStopDialogFragment();
                contractHoldStopDialogFragment.fi(contractPosition);
                contractHoldStopDialogFragment.gi(i11);
                BaseDialogFragment unused3 = ContractTradeBasePresenter.this.f43144u = contractHoldStopDialogFragment;
                ContractTradeBasePresenter.this.f43144u.show(ContractTradeBasePresenter.this.getActivity().getSupportFragmentManager(), "ContractPositionTradeDialogFragment");
                ContractTradeBasePresenter.this.g3("stop_surplus_loss");
            }
            String str = i11 == 0 ? "4687" : i11 == 1 ? "4689" : i11 == 2 ? "5140" : i11 == 3 ? "4688" : null;
            if (!TextUtils.isEmpty(str)) {
                is.a.j(str, (Map<String, Object>) null, is.a.f(TradeType.CONTRACT));
            }
        }

        public final void m(ContractPosition contractPosition, HBDialogFragment hBDialogFragment) {
            q7.a.a().x(contractPosition.getContractCode(), contractPosition.getDirection()).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new b((u6.g) ContractTradeBasePresenter.this.getUI(), hBDialogFragment));
        }

        /* renamed from: q */
        public final void p(ContractPosition contractPosition, DialogUtils.b bVar) {
            ReversalEstimatedLiquidationPrice reversalEstimatedLiquidationPrice;
            if (bVar != null && bVar.B0() != null && (reversalEstimatedLiquidationPrice = this.f43166b) != null && !TextUtils.isEmpty(reversalEstimatedLiquidationPrice.getLiquidationPrice())) {
                String q11 = i6.m.q(i6.m.a(this.f43166b.getLiquidationPrice()), ej.f.p(contractPosition.getContractCode()));
                bVar.B0().setText(ContractTradeBasePresenter.this.getString(R.string.n_contract_reversal_estimated_liquidation_price) + q11 + this.f43166b.getUnit());
                bVar.B0().setVisibility(0);
            }
        }

        public final void r(ContractPosition contractPosition, DialogUtils.b bVar, HBDialogFragment hBDialogFragment) {
            q7.a.a().u(contractPosition.getContractCode(), contractPosition.getDirection()).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new a(hBDialogFragment, contractPosition, bVar));
        }
    }

    public class p extends BaseSubscriber<NewBannerBean> {
        public p() {
        }

        /* renamed from: a */
        public void onNext(NewBannerBean newBannerBean) {
            super.onNext(newBannerBean);
            ArrayList arrayList = new ArrayList();
            if (!(newBannerBean == null || newBannerBean.getBannerAdvList() == null)) {
                arrayList.addAll(newBannerBean.getBannerAdvList());
            }
            ContractTradeBasePresenter.this.K.postValue(arrayList);
        }
    }

    public class q extends BaseSubscriber<ActivityZeroAvailablePositionBean> {
        public q() {
        }

        /* renamed from: a */
        public void onNext(ActivityZeroAvailablePositionBean activityZeroAvailablePositionBean) {
            super.onNext(activityZeroAvailablePositionBean);
            if (activityZeroAvailablePositionBean != null) {
                boolean z11 = false;
                int intValue = activityZeroAvailablePositionBean.getAvailable() == null ? 0 : activityZeroAvailablePositionBean.getAvailable().intValue();
                MutableLiveData m12 = ContractTradeBasePresenter.this.M;
                if (1 == intValue) {
                    z11 = true;
                }
                m12.postValue(Boolean.valueOf(z11));
            }
        }
    }

    public class r implements l0.i {
        public r() {
        }

        public void a() {
            ContractTradeBasePresenter.this.n3();
        }

        public void b() {
            ContractTradeBasePresenter.this.f43140q.P0();
        }

        public void c(List<? extends s9.a> list) {
            ContractTradeBasePresenter.this.f43140q.J0(list);
        }

        public void d() {
            ContractTradeBasePresenter.this.G2();
        }

        public void e(List<LinearSwapPosition> list, boolean z11) {
        }
    }

    public class s extends EasySubscriber<ContractUserInfo.UserBean> {
        public s() {
        }

        /* renamed from: a */
        public void onNext(ContractUserInfo.UserBean userBean) {
            super.onNext(userBean);
            ((p1) ContractTradeBasePresenter.this.getUI()).F1();
            ((p1) ContractTradeBasePresenter.this.getUI()).I1();
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public class t extends BaseSubscriber<ContractCancelOrderResult> {
        public t() {
        }

        /* renamed from: a */
        public void onNext(ContractCancelOrderResult contractCancelOrderResult) {
            super.onNext(contractCancelOrderResult);
            ContractTradeBasePresenter.this.K2();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                APIStatusErrorException aPIStatusErrorException = (APIStatusErrorException) th2;
                if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                    HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
                }
            }
        }
    }

    public class u extends BaseSubscriber<List<ContractAccountInfo>> {
        public u() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            qk.t.a();
        }

        public void onNext(List<ContractAccountInfo> list) {
            ContractUserInfo.UserBean o11;
            l0.t().O(list);
            if (list != null) {
                qk.t.c(11);
                if (!ContractTradeBasePresenter.this.f43126c) {
                    boolean unused = ContractTradeBasePresenter.this.f43126c = true;
                }
                for (ContractAccountInfo next : list) {
                    if (next.getSymbol().equalsIgnoreCase(ContractTradeBasePresenter.this.f43138o)) {
                        if (ContractTradeBasePresenter.this.f43126c && (o11 = ContractUserInfoProvider.i().o()) != null && o11.getActiveState() == 1) {
                            int isAgree = o11.getIsAgree();
                            int isAgreeV2 = o11.getIsAgreeV2();
                            UserKycInfoNew o12 = KycProxy.l().o();
                            boolean isNeedAgreeV2 = (o12 == null || o12.getAuth_info() == null) ? false : o12.getAuth_info().isNeedAgreeV2();
                            if ((isNeedAgreeV2 && isAgreeV2 == 1) || (!isNeedAgreeV2 && isAgree == 1)) {
                                if (!ConfigPreferences.c("user_config", "config_show_no_right" + ContractTradeBasePresenter.this.f43138o + tg.r.x().s(), false) && i6.m.a(next.getMarginBalance()).compareTo(BigDecimal.ZERO) == 0) {
                                    ((p1) ContractTradeBasePresenter.this.getUI()).t3(ContractTradeBasePresenter.this.f43138o);
                                }
                            }
                        }
                        ContractTradeBasePresenter.this.f43139p.S(ContractTradeBasePresenter.this.f43138o, next);
                        if (!TextUtils.isEmpty(next.getLeverRate()) && i6.m.a(next.getLeverRate()).compareTo(BigDecimal.ZERO) != 0) {
                            String leverRate = next.getLeverRate();
                            ((p1) ContractTradeBasePresenter.this.getUI()).x0(leverRate);
                            ContractTradeBasePresenter.this.f43141r.E(leverRate);
                        }
                        ((p1) ContractTradeBasePresenter.this.getUI()).Ag(next);
                        ContractTradeBasePresenter.this.f43141r.f(false);
                        return;
                    }
                }
            }
        }
    }

    public class v extends BaseSubscriber<String> {
        public v() {
        }

        /* renamed from: a */
        public void onNext(String str) {
            ContractTradeBasePresenter contractTradeBasePresenter = ContractTradeBasePresenter.this;
            contractTradeBasePresenter.m3(i6.m.m(str, ej.f.p(contractTradeBasePresenter.f43141r.j().getContractCode())));
        }
    }

    public class w extends BaseSubscriber<List<ContractSettlementPrice>> {
        public w() {
        }

        public void onNext(List<ContractSettlementPrice> list) {
            super.onNext(list);
            ContractTradeBasePresenter.this.l3();
        }
    }

    public class x extends BaseSubscriber<Long> {
        public x() {
        }

        public void onNext(Long l11) {
            if (Math.abs(ContractTradeBasePresenter.this.f43137n.getDelivTime() - l11.longValue()) > 5000) {
                ContractTradeBasePresenter.this.S2();
                ContractTradeBasePresenter.this.y2();
            }
            long unused = ContractTradeBasePresenter.this.B = l11.longValue();
            if (l11.longValue() <= Period.MIN60_MILLS) {
                int unused2 = ContractTradeBasePresenter.this.f43147x = 1;
            } else {
                int unused3 = ContractTradeBasePresenter.this.f43147x = -1;
                ((p1) ContractTradeBasePresenter.this.getUI()).J1(l11.longValue());
            }
            ContractTradeBasePresenter.this.l3();
        }
    }

    public class y extends BaseSubscriber<Long> {
        public y() {
        }

        public void onNext(Long l11) {
            if (Math.abs(ContractTradeBasePresenter.this.f43137n.getSettlementTime() - l11.longValue()) > 5000) {
                ContractTradeBasePresenter.this.a3();
                ContractTradeBasePresenter.this.J2();
            }
            long unused = ContractTradeBasePresenter.this.C = l11.longValue();
            if (l11.longValue() <= 600000) {
                int unused2 = ContractTradeBasePresenter.this.f43147x = 2;
                ContractTradeBasePresenter.this.S2();
            } else {
                int unused3 = ContractTradeBasePresenter.this.f43147x = -1;
            }
            ContractTradeBasePresenter.this.l3();
        }
    }

    public class z extends EasySubscriber<Object> {
        public z() {
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError2(Throwable th2) {
            if (!NetworkStatus.c(BaseApplication.b())) {
                HuobiToastUtil.j(R.string.n_no_network);
            } else {
                HuobiToastUtil.k(BaseApplication.b(), R.string.string_order_op_fail);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            aPIStatusErrorException.getErrCode().hashCode();
            if (TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                HuobiToastUtil.k(bh.j.c(), R.string.string_order_op_fail);
            } else {
                HuobiToastUtil.l(bh.j.c(), aPIStatusErrorException.getErrMsg());
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            HuobiToastUtil.t(bh.j.c(), R.string.n_contract_market_closing_submit);
            s6.a.b(bh.j.c()).c(R.raw.order_success);
            EventBus.d().k(new ContractAssetAndOrderUpdateEvent());
        }

        public void onStart() {
            super.onStart();
        }

        public /* synthetic */ z(ContractTradeBasePresenter contractTradeBasePresenter, k kVar) {
            this();
        }
    }

    public ContractTradeBasePresenter() {
        MutableLiveData<List<NewBannerBean.BannerAdv>> mutableLiveData = new MutableLiveData<>();
        this.K = mutableLiveData;
        this.L = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(Boolean.FALSE);
        this.M = mutableLiveData2;
        this.N = mutableLiveData2;
    }

    public static /* synthetic */ ContractUserInfo.UserBean Q1(ContractUserInfo.UserBean userBean, UserKycInfoNew userKycInfoNew, UnifyKycInfo unifyKycInfo) {
        return userBean;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable W1(Long l11) {
        return q7.a.a().getPriceLimitLevel(this.f43137n.getContractCode()).b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable a2(Long l11) {
        return ContractSettlementController.c(false, this.f43138o);
    }

    public final Subscriber<List<ContractAccountInfo>> A1() {
        return new u();
    }

    public void A2() {
        T2();
        this.f43133j = new BaseSubscriber();
        ContractCurrencyUtils.q(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f43133j);
    }

    public final Subscriber<List<ContractSettlementPrice>> B1() {
        return new w();
    }

    public final void B2() {
        if (tg.r.x().F0()) {
            ContractOpenCloseController.c(false, this.f43138o).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g());
        } else {
            p2();
        }
    }

    public final Subscriber<Long> C1() {
        return new y();
    }

    public void C2() {
        this.f43140q.Q0(this.f43138o, 0, 0, 10, ((p1) getUI()).getPositionType(), ((p1) getUI()).e1(), ((p1) getUI()).T0());
    }

    public final Subscriber<ContractHeartBeat> D1() {
        return new a();
    }

    public final void D2(String str) {
        if ((((p1) getUI()).e1() != 0 && ((p1) getUI()).getPositionType() != 1) || TextUtils.isEmpty(str) || this.f43137n == null) {
            return;
        }
        if (o0.a()) {
            this.f43140q.R0(str, "", ((p1) getUI()).getPositionType(), ((p1) getUI()).e1());
        } else {
            this.f43140q.R0("", "", ((p1) getUI()).getPositionType(), ((p1) getUI()).e1());
        }
    }

    public final ContractPosition E1(aj.c cVar, ContractPosition contractPosition) {
        contractPosition.setContractCode(cVar.e().getContractCode());
        if ("buy".equalsIgnoreCase(cVar.e().getDirection())) {
            contractPosition.setDirection("sell");
        } else {
            contractPosition.setDirection("buy");
        }
        contractPosition.setLastPrice(cVar.e().getLastPrice());
        contractPosition.setAvailable(cVar.e().getAbailablePosition());
        contractPosition.setLeverRate(String.valueOf(cVar.e().getLeverRate()));
        contractPosition.setCostOpen(cVar.e().getAvgOpen());
        contractPosition.setSymbol(cVar.e().getSymbol());
        contractPosition.setContractCurrencyInfo(ContractCurrencyUtils.h(cVar.e().getContractCode()));
        contractPosition.setTpslOrderType(cVar.e().getTpslOrderType());
        contractPosition.setTriggerType(cVar.e().getTriggerType());
        contractPosition.setTriggerPrice(cVar.e().getTriggerPrice());
        contractPosition.setOrderPrice(cVar.e().getOrderPrice());
        contractPosition.setOrderPriceType(cVar.e().getOrderPriceType());
        contractPosition.setOrderId(cVar.e().getOrderId());
        return contractPosition;
    }

    public final void E2() {
        Subscriber<String> subscriber = this.f43128e;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f43128e = y1();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new cj.j(this.f43137n.getContractCode())).retryWhen(cj.e.f13091b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f43128e);
    }

    public ContractCurrencyInfo F1() {
        return this.f43137n;
    }

    public final void F2() {
        Subscriber<List<PriceLimitInfo>> subscriber = this.f43135l;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (tg.r.x().F0()) {
            this.f43135l = z1();
            Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new cj.i(this)).retryWhen(cj.d.f13090b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f43135l);
        }
    }

    public final String G1(ContractPosition contractPosition) {
        String lastPrice = contractPosition == null ? null : contractPosition.getLastPrice();
        if (lastPrice == null) {
            lastPrice = n0.b().c(contractPosition.getSymbol());
        }
        return i6.m.a(lastPrice).toPlainString();
    }

    public final void G2() {
        Subscriber<List<ContractAccountInfo>> subscriber = this.f43127d;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (tg.r.x().F0()) {
            this.f43127d = A1();
            Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new cj.k(MapParamsBuilder.c().b())).retryWhen(cj.n.f13100b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f43127d);
        }
    }

    public final Observable<Object> H1(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        return this.f43139p.M(contractOrderPlace, contractCurrencyInfo).compose(RxJavaHelper.t((u6.g) null));
    }

    public final void H2() {
        i6.d.b("contract startSafeguard");
        ((p1) getUI()).A0(0);
        ((p1) getUI()).A2((List<TopScrollData>) null, false, false);
        ((p1) getUI()).Ag((ContractAccountInfo) null);
        m3("--");
        R2();
        this.f43143t = false;
        this.f43141r.L();
    }

    public final BigDecimal I1(String str) {
        return i6.m.a(str);
    }

    public void I2() {
        Z2();
        this.f43136m = B1();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new cj.h(this)).retryWhen(cj.o.f13101b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f43136m);
    }

    public int J1() {
        return this.D;
    }

    public final void J2() {
        if (!this.f43149z) {
            this.f43149z = true;
            this.f43130g = C1();
            if (this.f43137n.getSettlementTime() >= 0) {
                Observable.interval(0, 1000, TimeUnit.MILLISECONDS).map(new cj.g(this.f43137n.getSettlementTime())).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f43130g);
            }
        }
    }

    public TradeType K1() {
        return this.f43142s;
    }

    public void K2() {
        if (((p1) getUI()).e1() == 0) {
            A2();
            n3();
            V2();
            e3();
            b3();
            d3();
        } else {
            if (((p1) getUI()).getPositionType() == 0) {
                W2();
            }
            O2();
            L2();
            N2();
            C2();
        }
        this.f43140q.P0();
    }

    public void L1() {
        if (tg.r.x().F0()) {
            i6.k.o("ContractKyc", "合约刷新用户数据");
            Observable.zip(ContractUserInfoProvider.i().p(false).subscribeOn(Schedulers.io()), KycProxy.l().i(false).subscribeOn(Schedulers.io()), KycProxy.l().n(false).subscribeOn(Schedulers.io()), cj.f.f13092b).retry(3).onErrorResumeNext(Observable.just(null)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new s());
        }
    }

    public void L2() {
        this.f43140q.S0(this.f43138o, 0, 10, ((p1) getUI()).e1(), ((p1) getUI()).T0());
    }

    public final void M1() {
        BaseDialogFragment baseDialogFragment = this.f43144u;
        if (baseDialogFragment != null && baseDialogFragment.isVisible()) {
            this.f43144u.doDismiss();
        }
        d1 d1Var = this.f43139p;
        if (d1Var != null) {
            d1Var.z();
        }
        ((p1) getUI()).q0();
    }

    public final void M2() {
        Subscriber<ContractHeartBeat> subscriber = this.f43132i;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f43132i = D1();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(cj.l.f13098b).retryWhen(cj.c.f13089b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f43132i);
    }

    public final void N1() {
        ContractCurrencyInfo l11 = ContractUserInfoProvider.i().l(ContractCurrencyUtils.m());
        if (l11 == null) {
            ContractCurrencyUtils.g(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c());
            return;
        }
        m2(l11);
        ((p1) getUI()).Sd(this.f43137n);
        u1();
    }

    public void N2() {
        this.f43140q.T0(this.f43138o, 5, 0, 10, ((p1) getUI()).getPositionType(), ((p1) getUI()).e1(), ((p1) getUI()).T0());
    }

    public final void O1() {
        ((p1) getUI()).O0("--", ContextCompat.getColor(getActivity(), R.color.baseColorSecondaryText), R.drawable.shape_trade_price_change_default);
    }

    public void O2() {
        this.f43140q.U0(this.f43138o, 1, 0, 10, ((p1) getUI()).getPositionType(), ((p1) getUI()).e1(), ((p1) getUI()).T0());
    }

    public final boolean P1(ContractPosition contractPosition) {
        return contractPosition == null || !"buy".equalsIgnoreCase(contractPosition.getDirection());
    }

    public final void P2() {
        if (tg.r.x().F0()) {
            x2.b(false, this.f43138o).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new n());
        }
    }

    public final void Q2() {
        Subscription subscription = this.f43134k;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void R2() {
        Subscriber<List<ContractCurrencyInfo>> subscriber = this.f43131h;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        Subscriber<List<ContractAccountInfo>> subscriber2 = this.f43127d;
        if (subscriber2 != null) {
            subscriber2.unsubscribe();
        }
        Z2();
        Subscriber<String> subscriber3 = this.f43128e;
        if (subscriber3 != null) {
            subscriber3.unsubscribe();
        }
        U2();
        S2();
        a3();
        V2();
        e3();
        b3();
        d3();
        T2();
        W2();
        Q2();
        X2();
        f3(false);
        q7.a.a().c(this.H);
        this.f43147x = -1;
    }

    public final void S2() {
        Subscriber<Long> subscriber = this.f43129f;
        if (subscriber != null) {
            this.f43148y = false;
            subscriber.unsubscribe();
        }
    }

    public void T2() {
        Subscriber subscriber = this.f43133j;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void U2() {
        this.f43140q.V0();
    }

    public void V() {
        super.V();
        EventBus.d().r(this);
        this.G.b();
    }

    public void V2() {
        this.f43140q.W0();
    }

    public void W2() {
        this.f43140q.X0();
    }

    public final void X2() {
        Subscriber<List<PriceLimitInfo>> subscriber = this.f43135l;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public final void Y2() {
        i6.d.b("contract stopSafeguard");
        ((p1) getUI()).A0(8);
        if (this.f43137n != null) {
            this.f43141r.C();
            r2();
            return;
        }
        N1();
    }

    public void Z(boolean z11) {
        super.Z(z11);
        if (z11) {
            fl.a.b(this.f43142s);
            if (!(Q().getArguments() == null || a7.a.a(this.f43142s) == null)) {
                int intValue = a7.a.a(this.f43142s).intValue();
                a7.a.c(this.f43142s);
                ((p1) getUI()).G1(intValue);
            }
            if (!tg.r.x().F0()) {
                this.f43139p.o();
                this.f43140q.M();
                M1();
            }
            N1();
            M2();
            ((p1) getUI()).s1(this.f43138o);
            int e11 = SP.e("ContractTradeTogetherViewOrderType", 0);
            if (ContractGlobalStatus.f83683b && (e11 == 3 || e11 == 4)) {
                e11 = 0;
            }
            ContractGlobalStatus.f83683b = false;
            ((p1) getUI()).g1(e11);
        } else {
            c3();
            R2();
            this.f43143t = false;
            this.f43141r.L();
            ((p1) getUI()).r0();
        }
        if (z11) {
            if (!EventBus.d().i(this)) {
                EventBus.d().p(this);
            }
        } else if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        this.G.c(z11);
    }

    public final void Z2() {
        Subscriber<List<ContractSettlementPrice>> subscriber = this.f43136m;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void a() {
    }

    public final void a3() {
        Subscriber<Long> subscriber = this.f43130g;
        if (subscriber != null) {
            this.f43149z = false;
            subscriber.unsubscribe();
        }
    }

    public void b() {
        G2();
        n3();
    }

    public void b3() {
        this.f43140q.Y0();
    }

    public void c() {
        this.f43139p.p();
        if (!this.f43140q.S().isEmpty()) {
            for (s9.a next : this.f43140q.S()) {
                if (next instanceof ContractPosition) {
                    ContractPosition contractPosition = (ContractPosition) next;
                    if (contractPosition.getContractCode().equals(this.f43137n.getContractCode())) {
                        d1 d1Var = this.f43139p;
                        d1Var.T(contractPosition.getContractCode() + contractPosition.getDirection(), contractPosition);
                    }
                    BaseDialogFragment baseDialogFragment = this.f43144u;
                    if (baseDialogFragment != null && (baseDialogFragment instanceof ContractHoldStopDialogFragment) && baseDialogFragment.isVisible()) {
                        ContractHoldStopDialogFragment contractHoldStopDialogFragment = (ContractHoldStopDialogFragment) this.f43144u;
                        if (contractPosition.getContractCode().equals(contractHoldStopDialogFragment.Th()) && contractPosition.getDirection().equals(contractHoldStopDialogFragment.Uh())) {
                            contractHoldStopDialogFragment.mi(contractPosition);
                        }
                    }
                    BaseDialogFragment baseDialogFragment2 = this.f43144u;
                    if (baseDialogFragment2 != null && (baseDialogFragment2 instanceof ContractPositionTradeDialogFragment) && baseDialogFragment2.isVisible()) {
                        ContractPositionTradeDialogFragment contractPositionTradeDialogFragment = (ContractPositionTradeDialogFragment) this.f43144u;
                        if (contractPosition.getContractCode().equals(contractPositionTradeDialogFragment.ii()) && contractPosition.getDirection().equals(contractPositionTradeDialogFragment.ji())) {
                            contractPositionTradeDialogFragment.Gi(contractPosition);
                        }
                    }
                }
            }
            this.f43141r.f(false);
        }
    }

    public final void c3() {
        Subscriber<ContractHeartBeat> subscriber = this.f43132i;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    public void clearInputEvent(ClearInputEvent clearInputEvent) {
        ((p1) getUI()).c1(true);
        ((p1) getUI()).u0(true, false);
    }

    public void d3() {
        this.f43140q.Z0();
    }

    public void e3() {
        this.f43140q.a1();
    }

    public final void f2(ContractPosition contractPosition) {
        String str;
        String str2;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        String m11 = i6.m.m(G1(contractPosition), ej.f.p(contractPosition.getContractCode()));
        BigDecimal I1 = I1(m11);
        BigDecimal k32 = k3(contractPosition);
        this.E = k32;
        if (!(k32 == null || k32.compareTo(BigDecimal.ZERO) == 0)) {
            TradeType tradeType = TradeType.CONTRACT;
            if (a7.e.E(tradeType)) {
                BigDecimal divide = this.E.multiply(i6.m.a(String.valueOf(100))).divide(i6.m.f68179a, 32, 1);
                if (divide.compareTo(BigDecimal.ONE) >= 0 || divide.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal2 = divide.setScale(ej.f.t(this.f43138o), 1);
                } else {
                    bigDecimal2 = BigDecimal.ONE;
                }
                str2 = i6.m.a(FutureUnitUtil.d(bigDecimal2.toPlainString(), I1.toPlainString(), this.f43137n.getContractFace(), tradeType)).setScale(ej.f.n(this.f43137n.getContractCode()), 1).toPlainString();
            } else {
                BigDecimal divide2 = this.E.multiply(i6.m.a(String.valueOf(100))).divide(i6.m.f68179a, 32, 1);
                if (divide2.compareTo(BigDecimal.ONE) >= 0 || divide2.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal = divide2.setScale(ej.f.t(this.f43138o), 1);
                } else {
                    bigDecimal = BigDecimal.ONE;
                }
                str2 = bigDecimal.toPlainString();
            }
            if (!TextUtils.isEmpty(str2) && i6.m.a(str2).compareTo(BigDecimal.ZERO) != 0) {
                str = "100%(≈ " + str2 + ")";
                j3(contractPosition, m11, str, 2, 6);
            }
        }
        str = "100%";
        j3(contractPosition, m11, str, 2, 6);
    }

    public final void f3(boolean z11) {
        if (this.f43137n != null) {
            q7.a.a().g(z11, this.f43137n.getContractShortType(), Period.day, this.I);
        }
    }

    public void g2(ContractCurrencyInfo contractCurrencyInfo) {
        String str;
        this.f43138o = this.f43137n.getSymbol();
        if (this.f43141r.j() == null) {
            str = null;
        } else {
            str = this.f43141r.j().getContractCode();
        }
        if (!TextUtils.isEmpty(str) && !str.equals(this.f43137n.getContractCode())) {
            ((p1) getUI()).c1(true);
            ((p1) getUI()).u0(true, false);
        }
        this.f43141r.H(this.f43138o);
        this.f43141r.D(this.f43137n);
        ((p1) getUI()).j2(this.D);
        ((p1) getUI()).s1(this.f43138o);
        ((p1) getUI()).c(this.f43141r.l().B());
        ((p1) getUI()).setInputPriceUpdate(false);
        ((p1) getUI()).Q1(8, contractCurrencyInfo);
        ((p1) getUI()).Sd(this.f43137n);
        ((p1) getUI()).j1();
        ((p1) getUI()).Ag((ContractAccountInfo) null);
        ((p1) getUI()).w0(true, true);
        ((p1) getUI()).z0(true);
        ((p1) getUI()).v0();
        m3("--");
        O1();
        ((p1) getUI()).y1();
        ((p1) getUI()).n0();
        this.f43140q.I0();
        this.f43141r.C();
        this.f43143t = false;
        this.f43147x = -1;
        S2();
        a3();
        r2();
    }

    public final void g3(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "hold_list");
        gs.g.j("contract_trade", "coin_contract", str, hashMap);
    }

    public void h2() {
        L1();
        r2();
        ((p1) getUI()).y0(true);
        this.f43126c = false;
    }

    public final void h3() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "hold_list");
        gs.g.j("key_backhand", "coin_contract", "confirm", hashMap);
    }

    /* renamed from: i2 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, V v11) {
        super.onUIReady(baseCoreActivity, v11);
        this.G = new ej.e(getActivity(), ((p1) getUI()).Z0());
        q2 q2Var = new q2(this.f43142s, getActivity(), this.f43137n, (p1) getUI(), ((p1) getUI()).X2());
        this.f43141r = q2Var;
        q2Var.F(this);
        ((p1) getUI()).setContractTradeViewController(this.f43141r);
        this.f43141r.w();
        this.f43139p = this.f43141r.s();
        h2 t11 = this.f43141r.t();
        this.f43140q = t11;
        t11.B0(this.J);
        this.f43140q.y0(new k());
        ((p1) getUI()).C1().setAdapter(this.f43140q.T());
        this.f43140q.C0(((p1) getUI()).a1());
        this.f43140q.D0(this);
        this.f43140q.E0(this);
        this.f43140q.O0(v11.e1(), ((p1) getUI()).T0());
        this.f43140q.K0();
        m3("--");
        o2(dn.d.f().g(this.f43138o));
        ((p1) getUI()).j2(this.D);
        rj.b a11 = this.G.a();
        View D2 = a11.D("rechargeEntry.xml", getActivity());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contractType", ContractSettlementPriceInfo.SETTLEMENT_TYPE_DELIVERY);
            a11.I("sendContractInfo(" + jSONObject + ")");
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        n2(D2);
        EventBus.d().p(this);
        this.f43146w = new r();
    }

    public final void i3(ContractOrderPlace contractOrderPlace, ContractCurrencyInfo contractCurrencyInfo) {
        if (contractOrderPlace.Y()) {
            H1(contractOrderPlace, contractCurrencyInfo).subscribe(new z(this, (k) null));
        }
    }

    public void j2(HashMap<String, Object> hashMap) {
        q7.a.a().p(hashMap).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new t());
    }

    public void j3(ContractPosition contractPosition, String str, String str2, int i11, int i12) {
        if (i12 != 1) {
            str = G1(contractPosition);
        }
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.N0(contractPosition.getSymbol());
        contractOrderPlace.B0(str);
        contractOrderPlace.d0(str2);
        contractOrderPlace.h0(P1(contractPosition));
        contractOrderPlace.A0(i11);
        contractOrderPlace.X0(i12);
        contractOrderPlace.g0(4);
        contractOrderPlace.E0(100);
        if (P1(contractPosition)) {
            contractOrderPlace.W0(getString(R.string.contract_trade_buy_flat_empty));
        } else {
            contractOrderPlace.W0(getString(R.string.contract_trade_sell_flat_more));
        }
        contractOrderPlace.s0(contractPosition.getLeverRate());
        contractOrderPlace.x0(getString(R.string.contract_trade_position_close_quick));
        i3(this.f43139p.P(getActivity(), contractOrderPlace, contractPosition.contractCurrencyInfo), contractPosition.contractCurrencyInfo);
    }

    public void k2() {
        v7.b.a().activityZeroAvailablePosition().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new q());
    }

    public final BigDecimal k3(ContractPosition contractPosition) {
        BigDecimal bigDecimal;
        if (contractPosition == null) {
            bigDecimal = BigDecimal.ZERO;
        } else {
            bigDecimal = i6.m.a(contractPosition.getAvailable());
        }
        this.E = bigDecimal;
        return bigDecimal;
    }

    public void l2() {
        v7.b.a().requestNewBanner(66, 9, (String) null).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new p());
    }

    public final void l3() {
        TopScrollData topScrollData;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (this.f43147x == -1) {
            ((p1) getUI()).A2((List<TopScrollData>) null, false, false);
            this.A = false;
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i11 = this.f43147x;
        if (i11 == 2) {
            TopScrollData topScrollData2 = new TopScrollData();
            String str6 = "--";
            long j11 = this.C;
            int i12 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i12 > 0 && j11 <= 600000) {
                long j12 = j11 / ConfigConstant.f68415c;
                if (j12 < 10) {
                    str4 = "0" + String.valueOf(j12);
                } else {
                    str4 = String.valueOf(j12);
                }
                long j13 = (j11 % ConfigConstant.f68415c) / 1000;
                if (j13 < 10) {
                    str5 = "0" + String.valueOf(j13);
                } else {
                    str5 = String.valueOf(j13);
                }
                topScrollData2.l(getString(R.string.n_contract_distance_settlement_time_label) + " " + ("00" + ":" + str4 + ":" + str5));
            } else if (i12 <= 0) {
                topScrollData2.l(getString(R.string.n_contract_distance_settlement_time_label) + " 00:00:00");
            }
            arrayList.add(topScrollData2);
            ContractSettlementPriceInfo b11 = ContractSettlementController.b(this.f43137n.getContractType());
            TopScrollData topScrollData3 = new TopScrollData();
            topScrollData3.l(getString(R.string.n_contract_current_predict_settlement_price));
            if (b11 == null || TextUtils.isEmpty(b11.getEstimatedSettlementPrice())) {
                topScrollData3.m(str6);
            } else {
                topScrollData3.m(String.format(getString(R.string.contract_delivery_price), new Object[]{i6.m.m(b11.getEstimatedSettlementPrice(), ej.f.p(this.f43137n.getContractCode()))}));
            }
            arrayList.add(topScrollData3);
        } else {
            String str7 = "--";
            if (i11 == 1) {
                TopScrollData topScrollData4 = new TopScrollData();
                long j14 = this.B;
                int i13 = (j14 > 0 ? 1 : (j14 == 0 ? 0 : -1));
                if (i13 <= 0 || j14 > Period.MIN60_MILLS) {
                    topScrollData = topScrollData4;
                    if (i13 <= 0) {
                        topScrollData.l(getString(R.string.n_contract_distance_delivery_time_label) + " 00:00:00");
                    }
                } else {
                    long j15 = j14 / Period.MIN60_MILLS;
                    if (j15 < 10) {
                        str = "0" + String.valueOf(j15);
                    } else {
                        str = String.valueOf(j15);
                    }
                    long j16 = j14 % Period.MIN60_MILLS;
                    long j17 = j16 / ConfigConstant.f68415c;
                    if (j17 < 10) {
                        str2 = "0" + String.valueOf(j17);
                    } else {
                        str2 = String.valueOf(j17);
                    }
                    long j18 = (j16 % ConfigConstant.f68415c) / 1000;
                    if (j18 < 10) {
                        str3 = "0" + String.valueOf(j18);
                    } else {
                        str3 = String.valueOf(j18);
                    }
                    topScrollData = topScrollData4;
                    topScrollData.l(getString(R.string.n_contract_distance_delivery_time_label) + " " + (str + ":" + str2 + ":" + str3));
                }
                arrayList.add(topScrollData);
                ContractSettlementPriceInfo b12 = ContractSettlementController.b(this.f43137n.getContractType());
                TopScrollData topScrollData5 = new TopScrollData();
                topScrollData5.l(getString(R.string.contract_predict_delivery_price));
                if (b12 == null || TextUtils.isEmpty(b12.getEstimatedSettlementPrice())) {
                    topScrollData5.m(str7);
                } else {
                    topScrollData5.m(String.format(getString(R.string.contract_delivery_price), new Object[]{i6.m.m(b12.getEstimatedSettlementPrice(), ej.f.p(this.f43137n.getContractCode()))}));
                }
                arrayList.add(topScrollData5);
            }
        }
        ((p1) getUI()).A2(arrayList, !this.A, false);
        this.A = true;
    }

    public final void m2(ContractCurrencyInfo contractCurrencyInfo) {
        this.f43137n = contractCurrencyInfo;
        ContractUserInfoProvider.i().x(this.f43137n);
        q2();
    }

    public void m3(String str) {
        b0 l11 = this.f43141r.l();
        l11.X(getString(R.string.n_contract_mark_price) + " " + str);
    }

    public void n2(View view) {
        this.F = view;
        h2 h2Var = this.f43140q;
        if (h2Var != null) {
            h2Var.A0(view);
        }
    }

    public void n3() {
        D2(this.f43138o);
    }

    public String o0() {
        return this.f43138o;
    }

    public void o2(int i11) {
        this.D = i11;
        dn.d.f().q(i11, this.f43138o);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006e, code lost:
        if (com.hbg.lib.core.util.w.l() != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0089, code lost:
        if (com.hbg.lib.core.util.w.l() != false) goto L_0x0071;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o3(com.hbg.lib.network.pro.socket.response.LastKlineResponse r9) {
        /*
            r8 = this;
            com.hbg.lib.network.pro.socket.bean.KlineInfo r0 = r9.getTick()
            if (r0 == 0) goto L_0x00df
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r1 = r8.f43137n
            java.lang.String r1 = r1.getContractShortType()
            java.lang.String r2 = r9.getSymbol()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0018
            goto L_0x00df
        L_0x0018:
            bj.q2 r1 = r8.f43141r
            bj.b0 r1 = r1.l()
            java.lang.String r2 = r9.getSymbol()
            double r3 = r0.getClose()
            r1.O(r2, r3)
            h6.a r1 = r8.getUI()
            dj.p1 r1 = (dj.p1) r1
            int r1 = r1.v1()
            if (r1 != 0) goto L_0x0037
            r1 = 1
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            bj.l0 r2 = bj.l0.t()
            java.lang.String r9 = r9.getSymbol()
            double r3 = r0.getClose()
            r2.J(r9, r3, r1)
            double r1 = r0.getClose()
            double r3 = r0.getOpen()
            double r1 = r1 - r3
            r3 = 0
            int r9 = java.lang.Double.compare(r1, r3)
            r5 = 2131235297(0x7f0811e1, float:1.8086784E38)
            r6 = 2131235298(0x7f0811e2, float:1.8086786E38)
            if (r9 <= 0) goto L_0x0073
            com.hbg.lib.common.ui.BaseCoreActivity r9 = r8.getActivity()
            int r1 = com.hbg.lib.core.util.w.h()
            int r9 = androidx.core.content.ContextCompat.getColor(r9, r1)
            boolean r1 = com.hbg.lib.core.util.w.l()
            if (r1 == 0) goto L_0x0071
            goto L_0x009a
        L_0x0071:
            r5 = r6
            goto L_0x009a
        L_0x0073:
            int r9 = java.lang.Double.compare(r1, r3)
            if (r9 >= 0) goto L_0x008c
            com.hbg.lib.common.ui.BaseCoreActivity r9 = r8.getActivity()
            int r1 = com.hbg.lib.core.util.w.d()
            int r9 = androidx.core.content.ContextCompat.getColor(r9, r1)
            boolean r1 = com.hbg.lib.core.util.w.l()
            if (r1 == 0) goto L_0x009a
            goto L_0x0071
        L_0x008c:
            com.hbg.lib.common.ui.BaseCoreActivity r9 = r8.getActivity()
            r1 = 2131099916(0x7f06010c, float:1.7812199E38)
            int r9 = androidx.core.content.ContextCompat.getColor(r9, r1)
            r5 = 2131235296(0x7f0811e0, float:1.8086782E38)
        L_0x009a:
            double r1 = r0.getOpen()
            int r1 = java.lang.Double.compare(r1, r3)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x00c0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.v(r2)
            java.lang.String r1 = i6.m.i(r3, r1)
            r0.append(r1)
            java.lang.String r1 = "%"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x00d6
        L_0x00c0:
            double r3 = r0.getClose()
            double r6 = r0.getOpen()
            double r3 = r3 - r6
            double r0 = r0.getOpen()
            double r3 = r3 / r0
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.v(r2)
            java.lang.String r0 = i6.m.S(r3, r0)
        L_0x00d6:
            h6.a r1 = r8.getUI()
            dj.p1 r1 = (dj.p1) r1
            r1.O0(r0, r9, r5)
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.contract.presenter.ContractTradeBasePresenter.o3(com.hbg.lib.network.pro.socket.response.LastKlineResponse):void");
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 100 && i12 == 200 && getActivity() != null) {
            Intent intent2 = new Intent(getActivity(), UnifyTransferActivity.class);
            if (o0() != null) {
                intent2.putExtra("coin", o0().toLowerCase(Locale.US));
            }
            intent2.putExtra(Constants.FLAG_ACCOUNT, "4");
            intent2.putExtra("JUMP_SHOWTIP", true);
            getActivity().startActivity(intent2);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onChangeUnitEvent(mk.a aVar) {
        if (aVar.b() == TradeType.CONTRACT) {
            int a11 = aVar.a();
            p1 p1Var = (p1) getUI();
            boolean z11 = true;
            if (a11 != 1) {
                z11 = false;
            }
            p1Var.m(a11, z11);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onContractCalmPeriodInfoChange(ContractCalmPeriodInfo contractCalmPeriodInfo) {
        if (getUI() != null) {
            ((p1) getUI()).F1();
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onContractCurrencyChange(ContractChangeEvent contractChangeEvent) {
        if (!contractChangeEvent.getInfo().getContractCode().equals(this.f43137n.getContractCode())) {
            R2();
            this.f43126c = false;
            int e11 = SP.e("ContractTradeTogetherViewOrderType", 0);
            if (ContractGlobalStatus.f83683b && (e11 == 3 || e11 == 4)) {
                e11 = 0;
            }
            ContractGlobalStatus.f83683b = false;
            ((p1) getUI()).V0(false);
            ((p1) getUI()).s0();
            ((p1) getUI()).G1(0);
            ((p1) getUI()).g1(e11);
            ((p1) getUI()).S0();
            this.f43141r.L();
            m2(contractChangeEvent.getInfo());
            g2(contractChangeEvent.getInfo());
            ((p1) getUI()).c1(true);
            ((p1) getUI()).u0(true, false);
        }
    }

    public void onPause() {
        super.onPause();
        R2();
        this.f43143t = false;
        this.f43141r.L();
        l0.t().Q((l0.i) null);
    }

    public void onResume() {
        super.onResume();
        l0.t().Q(this.f43146w);
    }

    public final void p2() {
    }

    public void q2() {
        Subscription subscription = this.f43134k;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        if (TextUtils.isEmpty(this.f43137n.getActivityId())) {
            ((p1) getUI()).S0();
        } else {
            this.f43134k = Observable.interval(0, 5000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d());
        }
    }

    public void q3(int i11) {
        this.D = i11 == 0 ? 4 : 5;
        dn.d.f().q(this.D, this.f43138o);
    }

    public void r2() {
        com.huobi.utils.w.d().f();
        if (this.f43137n != null) {
            s2();
            P2();
            v2();
            G2();
            I2();
            E2();
            x2();
            B2();
            K2();
            z2();
            n3();
            t2();
            F2();
            u2();
            f3(true);
            q7.a.a().d(this.H);
            ((p1) getUI()).U0(this.f43137n.getSymbol());
            ContractPriceProtectionHelper.g(TradeType.CONTRACT, this.f43137n.getContractCode());
        }
        if (tg.r.x().F0()) {
            a7.e.K(TradeType.CONTRACT).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e());
        }
        this.G.d();
    }

    public final void s2() {
        if (tg.r.x().F0()) {
            ContractAllowLevelController.b(false, this.f43138o).retry(3).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new m());
        }
    }

    public final void t2() {
        if (tg.r.x().F0()) {
            ContractAllowMaxLevelController.b(false, this.f43138o).compose(RxJavaHelper.t((u6.g) getUI())).retry(3).subscribe(new f());
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        if (!(getUI() == null || getActivity() == null || !((p1) getUI()).isCanBeSeen())) {
            boolean z11 = false;
            if (((p1) getUI()).getPositionType() == 2) {
                ((p1) getUI()).G1(0);
            }
            this.f43139p.o();
            M1();
            BaseCoreActivity activity = getActivity();
            if (activity != null && (activity instanceof HuobiMainActivity)) {
                z11 = true;
            }
            Intent d11 = k0.d(getActivity(), z11);
            if (!z11) {
                d11.addFlags(67108864);
            }
            rn.c.i().d(getActivity(), new JumpTarget(d11, d11));
        }
        if (getUI() != null) {
            ((p1) getUI()).c1(true);
            ((p1) getUI()).u0(true, true);
        }
    }

    public final void u1() {
        g2(this.f43137n);
        L1();
        this.f43141r.v();
    }

    public final void u2() {
        if (tg.r.x().F0()) {
            FutureClearDialogConfigController.c(20, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new h());
        } else {
            p2();
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void updateAssetAndOrder(ContractAssetAndOrderUpdateEvent contractAssetAndOrderUpdateEvent) {
        G2();
        K2();
        n3();
    }

    public void v1() {
        this.f43140q.O0(((p1) getUI()).e1(), ((p1) getUI()).T0());
    }

    public final void v2() {
        Subscriber<List<ContractCurrencyInfo>> subscriber = this.f43131h;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f43131h = w1();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(cj.m.f13099b).retryWhen(cj.b.f13088b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f43131h);
    }

    public final Subscriber<List<ContractCurrencyInfo>> w1() {
        return new b();
    }

    public final void w2(ContractCurrencyInfo contractCurrencyInfo) {
        ((p1) getUI()).Q1(0, contractCurrencyInfo);
        ((p1) getUI()).A2((List<TopScrollData>) null, false, false);
        Z2();
        S2();
        a3();
        this.f43147x = -1;
    }

    public final Subscriber<Long> x1() {
        return new x();
    }

    public final void x2() {
        if (this.f43137n.getSettlementTime() >= this.f43137n.getDelivTime()) {
            y2();
            a3();
        } else if (this.f43137n.getSettlementTime() <= 600000) {
            J2();
            S2();
        } else {
            y2();
            a3();
        }
    }

    public final Subscriber<String> y1() {
        return new v();
    }

    public final void y2() {
        if (!this.f43148y) {
            this.f43148y = true;
            this.f43129f = x1();
            Observable.interval(0, 1000, TimeUnit.MILLISECONDS).map(new cj.a(this.f43137n.getDelivTime())).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f43129f);
        }
    }

    public final Subscriber<List<PriceLimitInfo>> z1() {
        return new i();
    }

    public final void z2() {
        ContractHiddenInstrumentsController.b(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }
}
