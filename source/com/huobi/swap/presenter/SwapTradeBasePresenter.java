package com.huobi.swap.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import bj.l0;
import bj.p0;
import bj.z2;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
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
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.contract.core.bean.ReversalEstimatedLiquidationPrice;
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
import com.hbg.lib.network.swap.core.bean.OrderInsertRspInfo;
import com.hbg.lib.network.swap.core.bean.PriceLimitInfo;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapActivityInfo;
import com.hbg.lib.network.swap.core.bean.SwapAllowLevel;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapFundingRate;
import com.hbg.lib.network.swap.core.bean.SwapOpenRight;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.lib.network.swap.core.bean.SwapSettlementPriceInfo;
import com.hbg.lib.network.swap.core.bean.SwapUserInfo;
import com.hbg.lib.network.swap.core.bean.SwapUserOrderLimit;
import com.hbg.lib.network.swap.core.controller.SwapAllowLevelController;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.network.swap.core.controller.SwapHiddenInstrumentsController;
import com.hbg.lib.network.swap.core.controller.SwapOpenCloseController;
import com.hbg.lib.network.swap.core.controller.SwapSettlementController;
import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.swap.bean.SwapPositionItem;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractCalmPeriodInfo;
import com.huobi.contract.entity.ContractCancelOrderResult;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.helper.ContractPriceProtectionHelper;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.contract.ui.ContractTradeBaseFragment;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.kyc.util.KycProxy;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.share.helper.CaptureShareHelper;
import com.huobi.swap.bean.ClearInputEvent;
import com.huobi.swap.bean.SwapChangeEvent;
import com.huobi.swap.ui.SwapHoldStopDialogFragment;
import com.huobi.swap.ui.SwapMarketClosingDialog;
import com.huobi.swap.ui.SwapPositionTradeDialogFragment;
import com.huobi.swap.ui.SwapTradeBaseFragment;
import com.huobi.swap.utils.SwapUtil;
import com.huobi.utils.ContractGlobalStatus;
import com.huobi.utils.k0;
import com.huobi.webview2.ui.ContractWebActivity;
import com.tencent.android.tpush.common.Constants;
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
import qs.d0;
import qs.h1;
import qs.n1;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import ts.i1;

public class SwapTradeBasePresenter<V extends i1> extends BaseFragmentPresenter<V> implements h1.j, h1.k, n1.d {
    public boolean A;
    public boolean B;
    public long C;
    public long D;
    public l0.i E;
    public int F = 5;
    public BigDecimal G;
    public View H;
    public ej.e I;
    public a.d J = new n();
    public LastKlineListener K = new o();
    public SwapPositionItem.a L = new p();
    public final MutableLiveData<List<NewBannerBean.BannerAdv>> M;
    public LiveData<List<NewBannerBean.BannerAdv>> N;
    public final MutableLiveData<Boolean> O;
    public LiveData<Boolean> P;

    /* renamed from: c  reason: collision with root package name */
    public boolean f81513c;

    /* renamed from: d  reason: collision with root package name */
    public Subscriber<List<SwapAccountInfo>> f81514d;

    /* renamed from: e  reason: collision with root package name */
    public Subscriber<String> f81515e;

    /* renamed from: f  reason: collision with root package name */
    public Subscriber<List<SwapCurrencyInfo>> f81516f;

    /* renamed from: g  reason: collision with root package name */
    public Subscriber<ContractHeartBeat> f81517g;

    /* renamed from: h  reason: collision with root package name */
    public Subscriber f81518h;

    /* renamed from: i  reason: collision with root package name */
    public Subscription f81519i;

    /* renamed from: j  reason: collision with root package name */
    public Subscription f81520j;

    /* renamed from: k  reason: collision with root package name */
    public Subscriber<List<PriceLimitInfo>> f81521k;

    /* renamed from: l  reason: collision with root package name */
    public Subscriber<Long> f81522l;

    /* renamed from: m  reason: collision with root package name */
    public Subscriber<Long> f81523m;

    /* renamed from: n  reason: collision with root package name */
    public Subscriber<List<SwapSettlementPriceInfo>> f81524n;

    /* renamed from: o  reason: collision with root package name */
    public SwapCurrencyInfo f81525o;

    /* renamed from: p  reason: collision with root package name */
    public String f81526p;

    /* renamed from: q  reason: collision with root package name */
    public String f81527q;

    /* renamed from: r  reason: collision with root package name */
    public d0 f81528r;

    /* renamed from: s  reason: collision with root package name */
    public h1 f81529s;

    /* renamed from: t  reason: collision with root package name */
    public n1 f81530t;

    /* renamed from: u  reason: collision with root package name */
    public TradeType f81531u = TradeType.SWAP;

    /* renamed from: v  reason: collision with root package name */
    public boolean f81532v;

    /* renamed from: w  reason: collision with root package name */
    public SwapFundingRate f81533w;

    /* renamed from: x  reason: collision with root package name */
    public BaseDialogFragment f81534x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f81535y = bj.d.x();

    /* renamed from: z  reason: collision with root package name */
    public int f81536z = -1;

    public class a extends BaseSubscriber<List<SwapUserOrderLimit>> {
        public a() {
        }

        public void onNext(List<SwapUserOrderLimit> list) {
            super.onNext(list);
        }
    }

    public class a0 extends EasySubscriber<Object> {
        public a0() {
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

        public /* synthetic */ a0(SwapTradeBasePresenter swapTradeBasePresenter, k kVar) {
            this();
        }
    }

    public class b extends BaseSubscriber<List<SwapAccountInfo>> {
        public b() {
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onCompleted() {
            super.onCompleted();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            qk.t.a();
        }

        public void onStart() {
            super.onStart();
        }

        public void onNext(List<SwapAccountInfo> list) {
            l0.y().T(list);
            if (list != null) {
                qk.t.c(11);
                if (!SwapTradeBasePresenter.this.f81513c) {
                    boolean unused = SwapTradeBasePresenter.this.f81513c = true;
                }
                for (SwapAccountInfo next : list) {
                    if (next.getSymbol().equalsIgnoreCase(SwapTradeBasePresenter.this.f81526p)) {
                        if (SwapTradeBasePresenter.this.f81513c && m9.z.f().k() && m9.z.f().i()) {
                            SwapUserInfo.UserBean h11 = m9.z.f().h();
                            int isAgree = h11.getIsAgree();
                            int isAgreeV2 = h11.getIsAgreeV2();
                            UserKycInfoNew o11 = KycProxy.l().o();
                            boolean isNeedAgreeV2 = (o11 == null || o11.getAuth_info() == null) ? false : o11.getAuth_info().isNeedAgreeV2();
                            if ((isNeedAgreeV2 && isAgreeV2 == 1) || (!isNeedAgreeV2 && isAgree == 1)) {
                                if (!ConfigPreferences.c("user_config", "config_show_no_right" + SwapTradeBasePresenter.this.f81526p + tg.r.x().s(), false) && i6.m.a(next.getMarginBalance()).compareTo(BigDecimal.ZERO) == 0) {
                                    ((i1) SwapTradeBasePresenter.this.getUI()).t3(SwapTradeBasePresenter.this.f81526p);
                                }
                            }
                        }
                        SwapTradeBasePresenter.this.f81528r.V(SwapTradeBasePresenter.this.f81526p, next);
                        if (!TextUtils.isEmpty(next.getLeverRate()) && i6.m.a(next.getLeverRate()).compareTo(BigDecimal.ZERO) != 0) {
                            String leverRate = next.getLeverRate();
                            ((i1) SwapTradeBasePresenter.this.getUI()).x0(leverRate);
                            SwapTradeBasePresenter.this.f81530t.F(leverRate);
                        }
                        ((i1) SwapTradeBasePresenter.this.getUI()).E5(next);
                        SwapTradeBasePresenter.this.f81530t.i(false);
                        return;
                    }
                }
            }
        }
    }

    public class c extends BaseSubscriber<List<PriceLimitInfo>> {
        public c() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ((i1) SwapTradeBasePresenter.this.getUI()).F3((PriceLimitInfo) null);
        }

        public void onNext(List<PriceLimitInfo> list) {
            if (list == null || list.size() <= 0) {
                ((i1) SwapTradeBasePresenter.this.getUI()).F3((PriceLimitInfo) null);
            } else {
                ((i1) SwapTradeBasePresenter.this.getUI()).F3(list.get(0));
            }
        }
    }

    public class d extends BaseSubscriber<String> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(String str) {
            SwapTradeBasePresenter swapTradeBasePresenter = SwapTradeBasePresenter.this;
            swapTradeBasePresenter.t3(i6.m.m(str, us.i.j(swapTradeBasePresenter.f81530t.t())));
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onCompleted() {
            super.onCompleted();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }

        public void onStart() {
            super.onStart();
        }
    }

    public class e extends BaseSubscriber<ContractHeartBeat> {
        public e() {
        }

        /* renamed from: a */
        public void onNext(ContractHeartBeat contractHeartBeat) {
            super.onNext(contractHeartBeat);
            boolean z11 = contractHeartBeat != null && contractHeartBeat.isSwapSafeguard();
            if (z11) {
                SwapTradeBasePresenter.this.M2();
            } else if (SwapTradeBasePresenter.this.f81535y != z11) {
                SwapTradeBasePresenter.this.e3();
            } else {
                return;
            }
            boolean unused = SwapTradeBasePresenter.this.f81535y = z11;
        }
    }

    public class f extends BaseSubscriber<List<SwapCurrencyInfo>> {
        public f() {
        }

        public void onNext(List<SwapCurrencyInfo> list) {
            Iterator<SwapCurrencyInfo> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                SwapCurrencyInfo next = it2.next();
                if (next.getContractCode().equals(SwapTradeBasePresenter.this.f81525o.getContractCode())) {
                    SwapTradeBasePresenter.this.q2(next);
                    if (next.isShowCover()) {
                        SwapTradeBasePresenter.this.A2(next);
                    } else {
                        ((i1) SwapTradeBasePresenter.this.getUI()).L(8, next);
                        SwapTradeBasePresenter.this.B2();
                    }
                }
            }
            if (!list.contains(SwapTradeBasePresenter.this.f81525o)) {
                SwapCurrencyInfo unused = SwapTradeBasePresenter.this.f81525o = list.get(0);
                SwapTradeBasePresenter swapTradeBasePresenter = SwapTradeBasePresenter.this;
                swapTradeBasePresenter.q2(swapTradeBasePresenter.f81525o);
                SwapTradeBasePresenter swapTradeBasePresenter2 = SwapTradeBasePresenter.this;
                String unused2 = swapTradeBasePresenter2.f81526p = swapTradeBasePresenter2.f81525o.getSymbol();
                SwapTradeBasePresenter swapTradeBasePresenter3 = SwapTradeBasePresenter.this;
                String unused3 = swapTradeBasePresenter3.f81527q = swapTradeBasePresenter3.f81525o.getContractCode();
                SwapTradeBasePresenter.this.f81530t.H(SwapTradeBasePresenter.this.f81526p);
                SwapTradeBasePresenter.this.f81530t.E(SwapTradeBasePresenter.this.f81525o);
                ((i1) SwapTradeBasePresenter.this.getUI()).Z5(SwapTradeBasePresenter.this.f81525o);
                ((i1) SwapTradeBasePresenter.this.getUI()).L(8, SwapTradeBasePresenter.this.f81525o);
                SwapTradeBasePresenter.this.v2();
                SwapTradeBasePresenter.this.f81530t.D();
            }
            if (SwapTradeBasePresenter.this.f81525o.isNotSupportTrade()) {
                ((i1) SwapTradeBasePresenter.this.getUI()).m1();
            }
        }
    }

    public class g extends BaseSubscriber<Long> {
        public g() {
        }

        public void onNext(Long l11) {
            if (Math.abs(SwapTradeBasePresenter.this.f81525o.getSettlementTime().longValue() - l11.longValue()) > 5000) {
                SwapTradeBasePresenter.this.X2();
                SwapTradeBasePresenter.this.C2();
            }
            long unused = SwapTradeBasePresenter.this.C = l11.longValue();
            if (l11.longValue() <= Period.MIN60_MILLS) {
                int unused2 = SwapTradeBasePresenter.this.f81536z = 1;
            } else {
                int unused3 = SwapTradeBasePresenter.this.f81536z = -1;
            }
            SwapTradeBasePresenter.this.w3();
        }
    }

    public class h extends BaseSubscriber<Long> {
        public h() {
        }

        public void onNext(Long l11) {
            if (Math.abs(SwapTradeBasePresenter.this.f81525o.getDeliveryTime() - l11.longValue()) > 5000) {
                SwapTradeBasePresenter.this.g3();
                SwapTradeBasePresenter.this.O2();
            }
            long unused = SwapTradeBasePresenter.this.D = l11.longValue();
            if (l11.longValue() <= 600000) {
                int unused2 = SwapTradeBasePresenter.this.f81536z = 2;
            } else {
                int unused3 = SwapTradeBasePresenter.this.f81536z = -1;
            }
            SwapTradeBasePresenter.this.w3();
        }
    }

    public class i extends BaseSubscriber<List<SwapSettlementPriceInfo>> {
        public i() {
        }

        public void onNext(List<SwapSettlementPriceInfo> list) {
            super.onNext(list);
            SwapTradeBasePresenter.this.w3();
        }
    }

    public class j extends BaseSubscriber<List<SwapCurrencyInfo>> {
        public j() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            List<ContractCurrencyInfo> m11 = ContractCurrencyUtils.m();
            if (m11 != null && !m11.isEmpty()) {
                ContractTradeBaseFragment.Ui(SwapTradeBasePresenter.this.getActivity(), m11.get(0), SwapTradeBasePresenter.this.getActivity() instanceof HuobiMainActivity);
            }
        }

        public void onNext(List<SwapCurrencyInfo> list) {
            super.onNext(list);
            SwapTradeBasePresenter.this.q2(ContractUserInfoProvider.i().n(list));
            SwapTradeBasePresenter.this.w1();
        }
    }

    public class k implements h1.i {
        public k() {
        }

        public int B0() {
            return ((i1) SwapTradeBasePresenter.this.getUI()).B0();
        }

        public void a(ps.a aVar, Context context) {
            SwapHoldStopDialogFragment swapHoldStopDialogFragment = new SwapHoldStopDialogFragment();
            swapHoldStopDialogFragment.gi(SwapTradeBasePresenter.this.G1(aVar, new SwapPosition()), SwapCurrencyInfoController.k().q(aVar.e().getContractCode()));
            swapHoldStopDialogFragment.hi(TextUtils.equals(aVar.e().getTpslOrderType(), "sl") ? 3 : 2);
            BaseDialogFragment unused = SwapTradeBasePresenter.this.f81534x = swapHoldStopDialogFragment;
            SwapTradeBasePresenter.this.f81534x.show(((FragmentActivity) context).getSupportFragmentManager(), "SwapHoldStopDialogFragment");
            i6.d.c("ACTION-SWAP", "委托item中按钮点击止盈止损");
        }

        public void b(ps.a aVar) {
            if (SwapTradeBasePresenter.this.f81534x != null && (SwapTradeBasePresenter.this.f81534x instanceof SwapHoldStopDialogFragment) && ((SwapHoldStopDialogFragment) SwapTradeBasePresenter.this.f81534x).Yh() && SwapTradeBasePresenter.this.f81534x.isVisible() && TextUtils.equals(((SwapHoldStopDialogFragment) SwapTradeBasePresenter.this.f81534x).R0(), aVar.e().getOrderId()) && ((SwapHoldStopDialogFragment) SwapTradeBasePresenter.this.f81534x).Xh() != null && !TextUtils.isEmpty(aVar.e().getLastPrice()) && !aVar.e().getLastPrice().equals(((SwapHoldStopDialogFragment) SwapTradeBasePresenter.this.f81534x).Xh().getLastPrice())) {
                SwapHoldStopDialogFragment swapHoldStopDialogFragment = (SwapHoldStopDialogFragment) SwapTradeBasePresenter.this.f81534x;
                String str = "buy";
                if (str.equalsIgnoreCase(swapHoldStopDialogFragment.Vh())) {
                    str = "sell";
                }
                if (aVar.e().getContractCode().equals(swapHoldStopDialogFragment.Uh()) && str.equals(swapHoldStopDialogFragment.Vh())) {
                    SwapPosition unused = SwapTradeBasePresenter.this.G1(aVar, swapHoldStopDialogFragment.Xh());
                    swapHoldStopDialogFragment.mi();
                }
            }
        }

        public void f(int i11) {
            ((i1) SwapTradeBasePresenter.this.getUI()).f(i11);
        }

        public void g(int i11) {
            ((i1) SwapTradeBasePresenter.this.getUI()).g(i11);
        }

        public void h(int i11) {
            ((i1) SwapTradeBasePresenter.this.getUI()).h(i11);
        }

        public void i(int i11) {
            ((i1) SwapTradeBasePresenter.this.getUI()).i(i11);
        }
    }

    public class l extends BaseSubscriber<Long> {

        public class a extends BaseSubscriber<SwapActivityInfo> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(SwapActivityInfo swapActivityInfo) {
                super.onNext(swapActivityInfo);
                if (swapActivityInfo == null || swapActivityInfo.getProductId() == null || SwapTradeBasePresenter.this.f81525o == null || !swapActivityInfo.getProductId().contains(SwapTradeBasePresenter.this.f81525o.getSymbol())) {
                    swapActivityInfo = null;
                }
                ((i1) SwapTradeBasePresenter.this.getUI()).C2(us.f.a(swapActivityInfo), SwapTradeBasePresenter.this.f81526p);
            }
        }

        public l() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            if (TextUtils.isEmpty(SwapTradeBasePresenter.this.f81525o.getActivityId())) {
                ((i1) SwapTradeBasePresenter.this.getUI()).S0();
                SwapTradeBasePresenter.this.V2();
                return;
            }
            l9.a.a().activityInfo(SwapTradeBasePresenter.this.f81525o.getActivityId()).b().compose(RxJavaHelper.t((u6.g) SwapTradeBasePresenter.this.getUI())).subscribe(new a());
        }
    }

    public class m extends BaseSubscriber<Integer> {
        public m() {
        }

        /* renamed from: a */
        public void onNext(Integer num) {
            super.onNext(num);
            ((i1) SwapTradeBasePresenter.this.getUI()).s1(SwapTradeBasePresenter.this.f81526p);
            if (num != null) {
                if (num.intValue() == 1) {
                    SwapTradeBasePresenter.this.s2(4);
                } else if (num.intValue() == 2) {
                    SwapTradeBasePresenter.this.s2(5);
                }
            }
            ((i1) SwapTradeBasePresenter.this.getUI()).E1(SwapTradeBasePresenter.this.F);
        }
    }

    public class n implements a.d {
        public n() {
        }

        public void a() {
            SwapTradeBasePresenter.this.l3(true);
        }
    }

    public class o extends LastKlineListener {
        public o() {
        }

        /* renamed from: j */
        public void f(LastKlineResponse lastKlineResponse) {
            SwapTradeBasePresenter.this.v3(lastKlineResponse);
        }

        public void onFailed(Throwable th2) {
            super.onFailed(th2);
            th2.printStackTrace();
            i6.k.g(this.f70671a, "lastKlineListener has error ", th2);
        }
    }

    public class p implements SwapPositionItem.a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f81554a = false;

        /* renamed from: b  reason: collision with root package name */
        public ReversalEstimatedLiquidationPrice f81555b;

        public class a extends q6.d<OrderInsertRspInfo> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HBDialogFragment f81557e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(u6.g gVar, HBDialogFragment hBDialogFragment) {
                super(gVar);
                this.f81557e = hBDialogFragment;
            }

            public void onAfter() {
                super.onAfter();
                HBDialogFragment hBDialogFragment = this.f81557e;
                if (hBDialogFragment != null) {
                    hBDialogFragment.dismiss();
                }
            }
        }

        public class b extends EasySubscriber<ReversalEstimatedLiquidationPrice> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ HBDialogFragment f81559b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SwapPosition f81560c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ DialogUtils.b f81561d;

            public b(HBDialogFragment hBDialogFragment, SwapPosition swapPosition, DialogUtils.b bVar) {
                this.f81559b = hBDialogFragment;
                this.f81560c = swapPosition;
                this.f81561d = bVar;
            }

            /* renamed from: a */
            public void onNext(ReversalEstimatedLiquidationPrice reversalEstimatedLiquidationPrice) {
                super.onNext(reversalEstimatedLiquidationPrice);
                if (!this.f81559b.isDetached()) {
                    p pVar = p.this;
                    pVar.f81555b = reversalEstimatedLiquidationPrice;
                    pVar.o(this.f81560c, this.f81561d);
                }
            }
        }

        public class c implements LeverSelectDialogFragment.h {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwapPosition f81563a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ SwapPositionItem f81564b;

            public c(SwapPosition swapPosition, SwapPositionItem swapPositionItem) {
                this.f81563a = swapPosition;
                this.f81564b = swapPositionItem;
            }

            public void N0() {
                String str;
                if (this.f81563a != null) {
                    String str2 = a7.e.E(TradeType.SWAP) ? "symbol" : "sheet";
                    if ("cny".equals(LegalCurrencyConfigUtil.y())) {
                        str = "cny";
                    } else {
                        str = "usd";
                    }
                    ContractWebActivity.hi(SwapTradeBasePresenter.this.getActivity(), this.f81563a.getSymbol(), str2, str, this.f81563a.getContractCode(), this.f81564b.e() != null ? this.f81564b.e().getContractShortType() : "", 2);
                }
            }

            public Observable<List<LevelAvailableMarginInfo>> O0(TradeType tradeType, String str, int i11) {
                return uc.b.d(tradeType, str, i11);
            }

            public void P0(String str) {
                if (TextUtils.equals(SwapTradeBasePresenter.this.f81527q, this.f81563a.getContractCode())) {
                    ((i1) SwapTradeBasePresenter.this.getUI()).x0(str);
                    SwapTradeBasePresenter.this.f81530t.F(str);
                    SwapTradeBasePresenter.this.f81530t.C();
                    return;
                }
                SwapTradeBasePresenter.this.u3();
            }

            public String[] Q0(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
                return new String[2];
            }

            public boolean R0(LeverSelectDialogFragment leverSelectDialogFragment, String str) {
                return false;
            }
        }

        public p() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(SwapPosition swapPosition, HBDialogFragment hBDialogFragment) {
            SwapTradeBasePresenter.this.n3();
            p0.n(!this.f81554a);
            l(swapPosition, hBDialogFragment);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(boolean z11) {
            this.f81554a = z11;
        }

        public String a() {
            return ContractWebActivity.Eh(2);
        }

        public void b(SwapPositionItem swapPositionItem) {
            ContractPosition a11 = SwapUtil.a(swapPositionItem.d());
            a11.setQuoteCurrency("usd");
            CaptureShareHelper.g(SwapTradeBasePresenter.this.getActivity(), a11, CaptureShareHelper.ContractType.Swap);
            is.a.j("4690", (Map<String, Object>) null, is.a.f(TradeType.SWAP));
            SwapTradeBasePresenter.this.m3("hold_share");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0055, code lost:
            if (com.hbg.lib.core.util.w.l() != false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0043, code lost:
            if (com.hbg.lib.core.util.w.l() != false) goto L_0x0058;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(com.hbg.module.swap.bean.SwapPositionItem r13) {
            /*
                r12 = this;
                java.lang.String r0 = "ACTION-SWAP"
                java.lang.String r1 = "持仓item中按钮点击一键反手"
                i6.k.o(r0, r1)
                com.huobi.swap.presenter.SwapTradeBasePresenter r0 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                java.lang.String r1 = "key_backhand"
                r0.m3(r1)
                com.hbg.lib.network.swap.core.bean.SwapPosition r0 = r13.d()
                boolean r1 = bj.p0.f()
                r2 = 0
                if (r1 != 0) goto L_0x001d
                r12.l(r0, r2)
                return
            L_0x001d:
                r1 = 0
                r12.f81554a = r1
                r12.f81555b = r2
                java.lang.String r2 = r0.getDirection()
                com.hbg.lib.network.option.core.util.OptionDirection r3 = com.hbg.lib.network.option.core.util.OptionDirection.BUY
                java.lang.String r3 = r3.direction
                boolean r2 = r3.equalsIgnoreCase(r2)
                r3 = 2131100799(0x7f06047f, float:1.781399E38)
                r4 = 2131100818(0x7f060492, float:1.7814028E38)
                if (r2 == 0) goto L_0x0048
                com.huobi.swap.presenter.SwapTradeBasePresenter r2 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                r5 = 2132020977(0x7f140ef1, float:1.9680332E38)
                java.lang.String r2 = r2.getString(r5)
                boolean r5 = com.hbg.lib.core.util.w.l()
                if (r5 == 0) goto L_0x0046
                goto L_0x0058
            L_0x0046:
                r3 = r4
                goto L_0x0058
            L_0x0048:
                com.huobi.swap.presenter.SwapTradeBasePresenter r2 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                r5 = 2132020996(0x7f140f04, float:1.968037E38)
                java.lang.String r2 = r2.getString(r5)
                boolean r5 = com.hbg.lib.core.util.w.l()
                if (r5 == 0) goto L_0x0058
                goto L_0x0046
            L_0x0058:
                com.huobi.swap.presenter.SwapTradeBasePresenter r5 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                r6 = 2132020961(0x7f140ee1, float:1.96803E38)
                java.lang.String r5 = r5.getString(r6)
                com.huobi.swap.presenter.SwapTradeBasePresenter r6 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                r7 = 2132020964(0x7f140ee4, float:1.9680306E38)
                java.lang.String r6 = r6.getString(r7)
                r7 = 2
                java.lang.Object[] r7 = new java.lang.Object[r7]
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = r0.getSymbol()
                r8.append(r9)
                java.lang.String r9 = "usd"
                java.lang.String r9 = com.hbg.lib.common.utils.StringUtils.i(r9)
                r8.append(r9)
                r8.append(r2)
                java.lang.String r9 = r0.getLeverRate()
                r8.append(r9)
                java.lang.String r9 = "X"
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                r7[r1] = r8
                r8 = 1
                r7[r8] = r5
                java.lang.String r6 = java.lang.String.format(r6, r7)
                int r7 = r6.indexOf(r2)
                android.text.SpannableStringBuilder r9 = new android.text.SpannableStringBuilder
                r9.<init>(r6)
                android.text.style.ForegroundColorSpan r10 = new android.text.style.ForegroundColorSpan
                com.huobi.swap.presenter.SwapTradeBasePresenter r11 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                com.hbg.lib.common.ui.BaseCoreActivity r11 = r11.getActivity()
                int r3 = androidx.core.content.ContextCompat.getColor(r11, r3)
                r10.<init>(r3)
                int r2 = r2.length()
                int r2 = r2 + r7
                r3 = 33
                r9.setSpan(r10, r7, r2, r3)
                int r2 = r6.indexOf(r5)
                android.text.style.ForegroundColorSpan r6 = new android.text.style.ForegroundColorSpan
                com.huobi.swap.presenter.SwapTradeBasePresenter r7 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                com.hbg.lib.common.ui.BaseCoreActivity r7 = r7.getActivity()
                int r4 = androidx.core.content.ContextCompat.getColor(r7, r4)
                r6.<init>(r4)
                int r4 = r5.length()
                int r4 = r4 + r2
                r9.setSpan(r6, r2, r4, r3)
                com.huobi.swap.presenter.SwapTradeBasePresenter r2 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                r3 = 2132020963(0x7f140ee3, float:1.9680304E38)
                java.lang.String r2 = r2.getString(r3)
                com.hbg.lib.network.swap.core.bean.SwapPosition r3 = r13.d()
                java.lang.String r3 = r3.getMarketClosingSlippage()
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto L_0x013b
                com.hbg.lib.network.swap.core.bean.SwapPosition r3 = r13.d()
                java.lang.String r3 = r3.getMarketClosingSlippage()
                com.hbg.lib.network.swap.core.bean.SwapPosition r13 = r13.d()
                java.lang.String r13 = r13.getSymbol()
                int r13 = us.i.m(r13)
                java.lang.String r13 = i6.m.m(r3, r13)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                com.huobi.swap.presenter.SwapTradeBasePresenter r2 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                r4 = 2132020908(0x7f140eac, float:1.9680192E38)
                java.lang.String r2 = r2.getString(r4)
                java.lang.Object[] r4 = new java.lang.Object[r8]
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r13)
                java.lang.String r13 = " USD"
                r5.append(r13)
                java.lang.String r13 = r5.toString()
                r4[r1] = r13
                java.lang.String r13 = java.lang.String.format(r2, r4)
                r3.append(r13)
                java.lang.String r2 = r3.toString()
            L_0x013b:
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = new com.hbg.lib.widgets.dialog.DialogUtils$b$d
                com.huobi.swap.presenter.SwapTradeBasePresenter r1 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                com.hbg.lib.common.ui.BaseCoreActivity r1 = r1.getActivity()
                r13.<init>(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.n0(r8)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.T0(r8)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.X0(r8)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.q0(r8)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.x0(r8)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.c1(r9)
                r1 = 1098907648(0x41800000, float:16.0)
                float r1 = com.hbg.lib.common.utils.PixelUtils.b(r1)
                java.lang.Float r1 = java.lang.Float.valueOf(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.h1(r1)
                com.huobi.swap.presenter.SwapTradeBasePresenter r1 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                android.content.res.Resources r1 = r1.getResources()
                r3 = 2131099897(0x7f0600f9, float:1.781216E38)
                int r1 = r1.getColor(r3)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.D0(r1)
                r1 = 1096810496(0x41600000, float:14.0)
                float r3 = com.hbg.lib.common.utils.PixelUtils.b(r1)
                java.lang.Float r3 = java.lang.Float.valueOf(r3)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.H0(r3)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.R0(r2)
                com.huobi.swap.presenter.SwapTradeBasePresenter r2 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                android.content.res.Resources r2 = r2.getResources()
                r3 = 2131099907(0x7f060103, float:1.781218E38)
                int r2 = r2.getColor(r3)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.S0(r2)
                float r1 = com.hbg.lib.common.utils.PixelUtils.b(r1)
                java.lang.Float r1 = java.lang.Float.valueOf(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.W0(r1)
                com.huobi.swap.presenter.SwapTradeBasePresenter r1 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                r2 = 2132020548(0x7f140d44, float:1.9679462E38)
                java.lang.String r1 = r1.getString(r2)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.P0(r1)
                ss.q r1 = new ss.q
                r1.<init>(r12, r0)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.Q0(r1)
                com.huobi.swap.presenter.SwapTradeBasePresenter r1 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                r2 = 2132020382(0x7f140c9e, float:1.9679126E38)
                java.lang.String r1 = r1.getString(r2)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.s0(r1)
                bj.o0 r1 = bj.o0.f12469a
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.N0(r1)
                com.huobi.swap.presenter.SwapTradeBasePresenter r1 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                r2 = 2132020768(0x7f140e20, float:1.9679908E38)
                java.lang.String r1 = r1.getString(r2)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.y0(r1)
                com.huobi.swap.presenter.SwapTradeBasePresenter r1 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                android.content.res.Resources r1 = r1.getResources()
                r2 = 2131099918(0x7f06010e, float:1.7812203E38)
                int r1 = r1.getColor(r2)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.z0(r1)
                r1 = 1094713344(0x41400000, float:12.0)
                float r1 = com.hbg.lib.common.utils.PixelUtils.b(r1)
                java.lang.Float r1 = java.lang.Float.valueOf(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.A0(r1)
                ss.p r1 = new ss.p
                r1.<init>(r12)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r13 = r13.v0(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b r13 = r13.m0()
                ss.r r1 = new ss.r
                r1.<init>(r12, r0, r13)
                com.hbg.lib.widgets.dialog.HBDialogFragment r1 = r13.y0(r1)
                com.huobi.swap.presenter.SwapTradeBasePresenter r2 = com.huobi.swap.presenter.SwapTradeBasePresenter.this
                com.hbg.lib.common.ui.BaseCoreActivity r2 = r2.getActivity()
                androidx.fragment.app.FragmentManager r2 = r2.getSupportFragmentManager()
                java.lang.String r3 = "reverseDialogFragment"
                r1.show(r2, r3)
                r12.q(r0, r13, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.swap.presenter.SwapTradeBasePresenter.p.c(com.hbg.module.swap.bean.SwapPositionItem):void");
        }

        public void d(SwapPositionItem swapPositionItem) {
            SwapHoldStopDialogFragment swapHoldStopDialogFragment = new SwapHoldStopDialogFragment();
            swapHoldStopDialogFragment.f43197g = 1;
            swapHoldStopDialogFragment.gi(swapPositionItem.d(), swapPositionItem.e());
            swapHoldStopDialogFragment.hi(2);
            BaseDialogFragment unused = SwapTradeBasePresenter.this.f81534x = swapHoldStopDialogFragment;
            SwapTradeBasePresenter.this.f81534x.show(SwapTradeBasePresenter.this.getActivity().getSupportFragmentManager(), "ContractPositionTradeDialogFragment");
            i6.k.o("ACTION-SWAP", "币本位永续持仓item中按钮点击仓位止盈止损");
        }

        public void e(int i11, SwapPositionItem swapPositionItem, int i12, Context context) {
            if (SwapTradeBasePresenter.this.f81534x != null && SwapTradeBasePresenter.this.f81534x.isVisible()) {
                SwapTradeBasePresenter.this.f81534x.doDismiss();
            }
            if (i11 == 0) {
                i6.k.o("ACTION-SWAP", "持仓item中按钮点击平仓");
                if (i6.m.a(swapPositionItem.d().getAvailable()).compareTo(BigDecimal.ZERO) <= 0) {
                    HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                    return;
                }
                SwapPositionTradeDialogFragment swapPositionTradeDialogFragment = new SwapPositionTradeDialogFragment();
                swapPositionTradeDialogFragment.xi(swapPositionItem);
                BaseDialogFragment unused = SwapTradeBasePresenter.this.f81534x = swapPositionTradeDialogFragment;
                SwapTradeBasePresenter.this.f81534x.show(SwapTradeBasePresenter.this.getActivity().getSupportFragmentManager(), "ContractPositionTradeDialogFragment");
                SwapTradeBasePresenter.this.m3("flat");
            } else if (i11 == 1) {
                i6.k.o("ACTION-SWAP", "持仓item中按钮点击市价全平");
                if (p0.a()) {
                    if (i6.m.a(swapPositionItem.d().getAvailable()).compareTo(BigDecimal.ZERO) <= 0) {
                        swapPositionItem.d().setAvailable(swapPositionItem.d().getVolume());
                    }
                    SwapMarketClosingDialog swapMarketClosingDialog = new SwapMarketClosingDialog();
                    swapMarketClosingDialog.Ch(swapPositionItem);
                    BaseDialogFragment unused2 = SwapTradeBasePresenter.this.f81534x = swapMarketClosingDialog;
                    SwapTradeBasePresenter.this.f81534x.show(SwapTradeBasePresenter.this.getActivity().getSupportFragmentManager(), "ContractPositionTradeDialogFragment");
                } else if (i6.m.a(swapPositionItem.d().getAvailable()).compareTo(BigDecimal.ZERO) <= 0) {
                    HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                    return;
                } else {
                    SwapPosition d11 = swapPositionItem.d();
                    if (d11 != null) {
                        d0 z02 = SwapTradeBasePresenter.this.f81528r;
                        z02.W(d11.getContractCode() + d11.getDirection(), d11);
                        SwapTradeBasePresenter.this.j2(swapPositionItem, d11);
                    }
                }
                SwapTradeBasePresenter.this.m3("market_price_flat");
            } else {
                SwapHoldStopDialogFragment swapHoldStopDialogFragment = new SwapHoldStopDialogFragment();
                swapHoldStopDialogFragment.gi(swapPositionItem.d(), swapPositionItem.e());
                swapHoldStopDialogFragment.hi(i11);
                BaseDialogFragment unused3 = SwapTradeBasePresenter.this.f81534x = swapHoldStopDialogFragment;
                SwapTradeBasePresenter.this.f81534x.show(SwapTradeBasePresenter.this.getActivity().getSupportFragmentManager(), "ContractPositionTradeDialogFragment");
                i6.k.o("ACTION-SWAP", "持仓item中按钮点击止盈止损");
                SwapTradeBasePresenter.this.m3("stop_surplus_loss");
            }
            String str = i11 == 0 ? "4687" : i11 == 1 ? "4689" : i11 == 2 ? "5140" : i11 == 3 ? "4688" : null;
            if (!TextUtils.isEmpty(str)) {
                is.a.j(str, (Map<String, Object>) null, is.a.f(TradeType.SWAP));
            }
        }

        public void f(SwapPositionItem swapPositionItem) {
            SwapTradeBaseFragment.Ri(SwapTradeBasePresenter.this.getActivity(), swapPositionItem.e(), 0, false);
        }

        public LeverSelectDialogFragment.h g(SwapPositionItem swapPositionItem, SwapPosition swapPosition) {
            return new c(swapPosition, swapPositionItem);
        }

        public final void l(SwapPosition swapPosition, HBDialogFragment hBDialogFragment) {
            l9.a.a().x(swapPosition.getContractCode(), swapPosition.getDirection()).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new a((u6.g) SwapTradeBasePresenter.this.getUI(), hBDialogFragment));
        }

        /* renamed from: p */
        public final void o(SwapPosition swapPosition, DialogUtils.b bVar) {
            ReversalEstimatedLiquidationPrice reversalEstimatedLiquidationPrice;
            if (bVar != null && bVar.B0() != null && (reversalEstimatedLiquidationPrice = this.f81555b) != null && !TextUtils.isEmpty(reversalEstimatedLiquidationPrice.getLiquidationPrice())) {
                String q11 = i6.m.q(i6.m.a(this.f81555b.getLiquidationPrice()), us.i.m(swapPosition.getSymbol()));
                bVar.B0().setText(SwapTradeBasePresenter.this.getString(R.string.n_contract_reversal_estimated_liquidation_price) + q11 + this.f81555b.getUnit());
                bVar.B0().setVisibility(0);
            }
        }

        public final void q(SwapPosition swapPosition, DialogUtils.b bVar, HBDialogFragment hBDialogFragment) {
            l9.a.a().u(swapPosition.getContractCode(), swapPosition.getDirection()).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new b(hBDialogFragment, swapPosition, bVar));
        }
    }

    public class q extends BaseSubscriber<NewBannerBean> {
        public q() {
        }

        /* renamed from: a */
        public void onNext(NewBannerBean newBannerBean) {
            super.onNext(newBannerBean);
            ArrayList arrayList = new ArrayList();
            if (!(newBannerBean == null || newBannerBean.getBannerAdvList() == null)) {
                arrayList.addAll(newBannerBean.getBannerAdvList());
            }
            SwapTradeBasePresenter.this.M.postValue(arrayList);
        }
    }

    public class r extends BaseSubscriber<ActivityZeroAvailablePositionBean> {
        public r() {
        }

        /* renamed from: a */
        public void onNext(ActivityZeroAvailablePositionBean activityZeroAvailablePositionBean) {
            super.onNext(activityZeroAvailablePositionBean);
            if (activityZeroAvailablePositionBean != null) {
                boolean z11 = false;
                int intValue = activityZeroAvailablePositionBean.getAvailable() == null ? 0 : activityZeroAvailablePositionBean.getAvailable().intValue();
                MutableLiveData q12 = SwapTradeBasePresenter.this.O;
                if (1 == intValue) {
                    z11 = true;
                }
                q12.postValue(Boolean.valueOf(z11));
            }
        }
    }

    public class s implements l0.i {
        public s() {
        }

        public void a() {
            SwapTradeBasePresenter.this.u3();
        }

        public void b() {
            SwapTradeBasePresenter.this.f81529s.O0();
        }

        public void c(List<? extends s9.a> list) {
            SwapTradeBasePresenter.this.f81529s.I0(list);
        }

        public void d() {
            SwapTradeBasePresenter.this.L2();
        }

        public void e(List<LinearSwapPosition> list, boolean z11) {
        }
    }

    public class t extends EasySubscriber<SwapUserInfo.UserBean> {
        public t() {
        }

        /* renamed from: a */
        public void onNext(SwapUserInfo.UserBean userBean) {
            super.onNext(userBean);
            ((i1) SwapTradeBasePresenter.this.getUI()).F1();
            ((i1) SwapTradeBasePresenter.this.getUI()).I1();
        }

        public void onError2(Throwable th2) {
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public class u extends BaseSubscriber<Long> {

        public class a extends BaseSubscriber<SwapFundingRate> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(SwapFundingRate swapFundingRate) {
                super.onNext(swapFundingRate);
                SwapFundingRate unused = SwapTradeBasePresenter.this.f81533w = swapFundingRate;
                SwapTradeBasePresenter.this.w3();
                if (swapFundingRate != null) {
                    boolean unused2 = SwapTradeBasePresenter.this.f81532v = true;
                }
            }

            public void onError(Throwable th2) {
                super.onError(th2);
                SwapTradeBasePresenter.this.S1(false);
            }
        }

        public u() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            l9.a.a().getFunddingRate(SwapTradeBasePresenter.this.f81527q).b().compose(RxJavaHelper.t((u6.g) SwapTradeBasePresenter.this.getUI())).subscribe(new a());
        }
    }

    public class v extends BaseSubscriber<SwapAllowLevel> {
        public v() {
        }

        /* renamed from: a */
        public void onNext(SwapAllowLevel swapAllowLevel) {
            super.onNext(swapAllowLevel);
        }
    }

    public class w extends BaseSubscriber<ContractClearDialogConfig> {
        public w() {
        }

        /* renamed from: a */
        public void onNext(ContractClearDialogConfig contractClearDialogConfig) {
            super.onNext(contractClearDialogConfig);
            if (FutureClearDialogConfigController.g(20)) {
                z2.c().b("CLEAR_NAME", 1);
                ((i1) SwapTradeBasePresenter.this.getUI()).p0(contractClearDialogConfig.getRulesUrl(), contractClearDialogConfig.getTips());
                return;
            }
            z2.c().b("CLEAR_NAME", 3);
            SwapTradeBasePresenter.this.t2();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            z2.c().b("CLEAR_NAME", 3);
            SwapTradeBasePresenter.this.t2();
        }
    }

    public class x extends BaseSubscriber<ContractCancelOrderResult> {
        public x() {
        }

        /* renamed from: a */
        public void onNext(ContractCancelOrderResult contractCancelOrderResult) {
            super.onNext(contractCancelOrderResult);
            SwapTradeBasePresenter.this.P2();
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

    public class y extends BaseSubscriber<SwapOpenRight> {
        public y() {
        }

        /* renamed from: a */
        public void onNext(SwapOpenRight swapOpenRight) {
            super.onNext(swapOpenRight);
            if (swapOpenRight.getRight() == 0) {
                z2.c().b("CLEAR_AFTER_NAME", 1);
                if (((i1) SwapTradeBasePresenter.this.getUI()).getPositionType() == 0) {
                    ((i1) SwapTradeBasePresenter.this.getUI()).z0(false);
                } else {
                    ((i1) SwapTradeBasePresenter.this.getUI()).z0(true);
                }
            } else {
                ((i1) SwapTradeBasePresenter.this.getUI()).z0(true);
                z2.c().b("CLEAR_AFTER_NAME", 3);
                SwapTradeBasePresenter.this.t2();
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            z2.c().b("CLEAR_AFTER_NAME", 3);
            SwapTradeBasePresenter.this.t2();
        }
    }

    public class z extends BaseSubscriber<List<String>> {
        public z() {
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            ((i1) SwapTradeBasePresenter.this.getUI()).setLeverList(list);
        }
    }

    public SwapTradeBasePresenter() {
        MutableLiveData<List<NewBannerBean.BannerAdv>> mutableLiveData = new MutableLiveData<>();
        this.M = mutableLiveData;
        this.N = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(Boolean.FALSE);
        this.O = mutableLiveData2;
        this.P = mutableLiveData2;
    }

    public static /* synthetic */ SwapUserInfo.UserBean U1(SwapUserInfo.UserBean userBean, UserKycInfoNew userKycInfoNew, UnifyKycInfo unifyKycInfo) {
        return userBean;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable Z1(Long l11) {
        return m9.t.b().d(this.f81527q);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable a2(Long l11) {
        return l9.a.a().getPriceLimitLevel(this.f81527q).b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable e2(Long l11) {
        return SwapSettlementController.c(false, this.f81527q);
    }

    public final Subscriber<String> A1() {
        return new d();
    }

    public final void A2(SwapCurrencyInfo swapCurrencyInfo) {
        ((i1) getUI()).L(0, swapCurrencyInfo);
        X2();
        g3();
        f3();
        this.f81536z = -1;
    }

    public final Subscriber<List<PriceLimitInfo>> B1() {
        return new c();
    }

    public final void B2() {
        if (this.f81525o.getSettlementTime() == null || this.f81525o.getSettlementTime().longValue() == -1) {
            O2();
            X2();
        } else if (this.f81525o.getDeliveryTime() < this.f81525o.getSettlementTime().longValue()) {
            O2();
            X2();
        } else {
            C2();
            g3();
        }
    }

    public final Subscriber<List<SwapAccountInfo>> C1() {
        return new b();
    }

    public final void C2() {
        if (this.f81525o.getSettlementTime() != null && this.f81525o.getSettlementTime().longValue() != -1 && !this.A) {
            this.A = true;
            this.f81522l = z1();
            Observable.interval(0, 1000, TimeUnit.MILLISECONDS).map(new ss.g(this.f81525o.getSettlementTime().longValue())).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f81522l);
        }
    }

    public final Subscriber<List<SwapSettlementPriceInfo>> D1() {
        return new i();
    }

    public final void D2() {
        if (!TextUtils.isEmpty(this.f81527q)) {
            Subscription subscription = this.f81519i;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.f81533w = null;
            this.f81532v = false;
            this.f81519i = Observable.interval(0, 5000, TimeUnit.MILLISECONDS).subscribe(new u());
        }
    }

    public final Subscriber<Long> E1() {
        return new h();
    }

    public final void E2() {
        SwapHiddenInstrumentsController.b(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }

    public final Subscriber<ContractHeartBeat> F1() {
        return new e();
    }

    public void F2() {
        Z2();
        this.f81518h = new BaseSubscriber();
        m9.o.c().d(this.f81527q).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f81518h);
    }

    public final SwapPosition G1(ps.a aVar, SwapPosition swapPosition) {
        swapPosition.setContractCode(aVar.e().getContractCode());
        if ("buy".equalsIgnoreCase(aVar.e().getDirection())) {
            swapPosition.setDirection("sell");
        } else {
            swapPosition.setDirection("buy");
        }
        swapPosition.setLastPrice(aVar.e().getLastPrice());
        swapPosition.setAvailable(aVar.e().getAbailablePosition());
        swapPosition.setLeverRate(String.valueOf(aVar.e().getLeverRate()));
        swapPosition.setCostOpen(aVar.e().getAvgOpen());
        swapPosition.setSymbol(aVar.e().getSymbol());
        swapPosition.setTpslOrderType(aVar.e().getTpslOrderType());
        swapPosition.setTriggerType(aVar.e().getTriggerType());
        swapPosition.setTriggerPrice(aVar.e().getTriggerPrice());
        swapPosition.setOrderPrice(aVar.e().getOrderPrice());
        swapPosition.setOrderPriceType(aVar.e().getOrderPriceType());
        swapPosition.setOrderId(aVar.e().getOrderId());
        return swapPosition;
    }

    public final void G2() {
        if (tg.r.x().F0()) {
            SwapOpenCloseController.c(false, this.f81527q).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new y());
        } else {
            t2();
        }
    }

    public String H1() {
        return this.f81527q;
    }

    public void H2() {
        this.f81529s.P0(this.f81527q, 0, 0, 10, ((i1) getUI()).getPositionType(), ((i1) getUI()).e1(), ((i1) getUI()).T0());
    }

    public SwapCurrencyInfo I1() {
        return this.f81525o;
    }

    public void I2(String str) {
        if ((((i1) getUI()).e1() != 0 && ((i1) getUI()).getPositionType() != 1) || TextUtils.isEmpty(str) || this.f81525o == null) {
            return;
        }
        if (o0.a()) {
            this.f81529s.Q0(this.f81525o.getContractCode(), ((i1) getUI()).getPositionType(), ((i1) getUI()).e1());
        } else {
            this.f81529s.Q0("", ((i1) getUI()).getPositionType(), ((i1) getUI()).e1());
        }
    }

    public final String J1(SwapPosition swapPosition) {
        String lastPrice = swapPosition == null ? null : swapPosition.getLastPrice();
        if (lastPrice == null) {
            lastPrice = m9.t.b().c(swapPosition.getContractCode());
        }
        return i6.m.a(lastPrice).toPlainString();
    }

    public final void J2() {
        Subscriber<String> subscriber = this.f81515e;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f81515e = A1();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new ss.i(this)).retryWhen(ss.b.f26151b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f81515e);
    }

    public final Observable<Object> K1(ContractOrderPlace contractOrderPlace, SwapPositionItem swapPositionItem) {
        return this.f81528r.R(contractOrderPlace, swapPositionItem.e()).compose(RxJavaHelper.t((u6.g) null));
    }

    public final void K2() {
        Subscriber<List<PriceLimitInfo>> subscriber = this.f81521k;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (tg.r.x().F0()) {
            this.f81521k = B1();
            Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new ss.h(this)).retryWhen(ss.d.f26153b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f81521k);
        }
    }

    public final BigDecimal L1(String str) {
        return i6.m.a(str);
    }

    public final void L2() {
        Subscriber<List<SwapAccountInfo>> subscriber = this.f81514d;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (tg.r.x().F0()) {
            this.f81514d = C1();
            Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(ss.k.f26160b).retryWhen(ss.o.f26164b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f81514d);
        }
    }

    public int M1() {
        return this.F;
    }

    public final void M2() {
        i6.d.b("contract startSafeguard");
        ((i1) getUI()).A0(0);
        ((i1) getUI()).E5((SwapAccountInfo) null);
        t3("--");
        S1(true);
        W2();
        this.f81530t.L();
    }

    public TradeType N1() {
        return this.f81531u;
    }

    public void N2() {
        f3();
        this.f81524n = D1();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new ss.j(this)).retryWhen(ss.n.f26163b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f81524n);
    }

    public void O1() {
        if (tg.r.x().F0()) {
            i6.k.o("ContractKyc", "反向永续刷新用户数据");
            Observable.zip(m9.z.f().g(false).subscribeOn(Schedulers.io()), KycProxy.l().i(false).subscribeOn(Schedulers.io()), KycProxy.l().n(false).subscribeOn(Schedulers.io()), ss.f.f26155b).retry(3).onErrorResumeNext(Observable.just(null)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new t());
        }
    }

    public final void O2() {
        if (this.f81525o.getDeliveryTime() >= 0 && !this.B) {
            this.B = true;
            this.f81523m = E1();
            Observable.interval(0, 1000, TimeUnit.MILLISECONDS).map(new ss.a(this.f81525o.getDeliveryTime())).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f81523m);
        }
    }

    public final void P1() {
        BaseDialogFragment baseDialogFragment = this.f81534x;
        if (baseDialogFragment != null && baseDialogFragment.isVisible()) {
            this.f81534x.doDismiss();
        }
        d0 d0Var = this.f81528r;
        if (d0Var != null) {
            d0Var.D();
        }
        ((i1) getUI()).q0();
    }

    public void P2() {
        if (((i1) getUI()).e1() == 0) {
            F2();
            u3();
            b3();
            k3();
            h3();
            j3();
        } else {
            if (((i1) getUI()).getPositionType() == 0) {
                c3();
            }
            T2();
            Q2();
            H2();
            S2();
        }
        this.f81529s.O0();
    }

    public final void Q1() {
        SwapCurrencyInfo n11 = ContractUserInfoProvider.i().n(SwapCurrencyInfoController.k().e());
        if (n11 == null) {
            SwapCurrencyInfoController.k().f(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new j());
            return;
        }
        q2(n11);
        ((i1) getUI()).Z5(this.f81525o);
        w1();
    }

    public void Q2() {
        this.f81529s.R0(this.f81527q, 0, 10, ((i1) getUI()).e1(), ((i1) getUI()).T0());
    }

    public final void R1() {
        ((i1) getUI()).O0("--", ContextCompat.getColor(getActivity(), R.color.baseColorSecondaryText), R.drawable.shape_trade_price_change_default);
    }

    public final void R2() {
        Subscriber<ContractHeartBeat> subscriber = this.f81517g;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f81517g = F1();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(ss.l.f26161b).retryWhen(ss.e.f26154b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f81517g);
    }

    public final void S1(boolean z11) {
        ArrayList arrayList = new ArrayList();
        TopScrollData topScrollData = new TopScrollData();
        topScrollData.l(getActivity().getString(R.string.n_contract_swap_fee_rate));
        topScrollData.m("--");
        arrayList.add(topScrollData);
        ((i1) getUI()).s2(arrayList, true, z11);
    }

    public void S2() {
        this.f81529s.S0(this.f81527q, 5, 0, 10, ((i1) getUI()).getPositionType(), ((i1) getUI()).e1(), ((i1) getUI()).T0());
    }

    public final boolean T1(SwapPosition swapPosition) {
        return swapPosition == null || !"buy".equalsIgnoreCase(swapPosition.getDirection());
    }

    public void T2() {
        this.f81529s.T0(this.f81527q, 1, 0, 10, ((i1) getUI()).getPositionType(), ((i1) getUI()).e1(), ((i1) getUI()).T0());
    }

    public final void U2() {
        if (tg.r.x().F0()) {
            us.l.b(false, this.f81527q).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new a());
        }
    }

    public void V() {
        super.V();
        EventBus.d().r(this);
        this.I.b();
        this.f81529s.A0((SwapPositionItem.a) null);
    }

    public void V2() {
        Subscription subscription = this.f81520j;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void W2() {
        Subscriber<List<SwapCurrencyInfo>> subscriber = this.f81516f;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        Subscriber<List<SwapAccountInfo>> subscriber2 = this.f81514d;
        if (subscriber2 != null) {
            subscriber2.unsubscribe();
        }
        Subscriber<String> subscriber3 = this.f81515e;
        if (subscriber3 != null) {
            subscriber3.unsubscribe();
        }
        a3();
        Y2();
        b3();
        k3();
        h3();
        j3();
        Z2();
        X2();
        g3();
        f3();
        c3();
        V2();
        d3();
        l3(false);
        l9.a.a().c(this.J);
        this.f81536z = -1;
    }

    public final void X2() {
        Subscriber<Long> subscriber = this.f81522l;
        if (subscriber != null) {
            this.A = false;
            subscriber.unsubscribe();
        }
    }

    public final void Y2() {
        Subscription subscription = this.f81519i;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void Z(boolean z11) {
        super.Z(z11);
        if (z11) {
            fl.a.b(this.f81531u);
            if (!(Q().getArguments() == null || a7.a.a(this.f81531u) == null)) {
                int intValue = a7.a.a(this.f81531u).intValue();
                a7.a.c(this.f81531u);
                ((i1) getUI()).G1(intValue);
            }
            if (!tg.r.x().F0()) {
                this.f81528r.p();
                this.f81529s.L();
                P1();
            }
            Q1();
            R2();
            ((i1) getUI()).s1(this.f81526p);
            int e11 = SP.e("SwapTradeTogetherViewOrderType", 0);
            if (ContractGlobalStatus.f83682a && (e11 == 3 || e11 == 4)) {
                e11 = 0;
            }
            ContractGlobalStatus.f83682a = false;
            ((i1) getUI()).g1(e11);
        } else {
            i3();
            W2();
            ((i1) getUI()).r0();
            this.f81530t.L();
        }
        if (z11) {
            if (!EventBus.d().i(this)) {
                EventBus.d().p(this);
            }
        } else if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        this.I.c(z11);
    }

    public void Z2() {
        Subscriber subscriber = this.f81518h;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void a() {
    }

    public void a3() {
        this.f81529s.U0();
    }

    public void b() {
        L2();
        u3();
    }

    public void b3() {
        this.f81529s.V0();
    }

    public void c() {
        this.f81528r.q();
        if (!this.f81529s.R().isEmpty()) {
            for (s9.a next : this.f81529s.R()) {
                if (next instanceof SwapPositionItem) {
                    SwapPositionItem swapPositionItem = (SwapPositionItem) next;
                    SwapPosition d11 = swapPositionItem.d();
                    if (d11.getContractCode().equals(this.f81525o.getContractCode())) {
                        d0 d0Var = this.f81528r;
                        d0Var.W(d11.getContractCode() + d11.getDirection(), d11);
                    }
                    BaseDialogFragment baseDialogFragment = this.f81534x;
                    if (baseDialogFragment != null && (baseDialogFragment instanceof SwapPositionTradeDialogFragment) && baseDialogFragment.isVisible()) {
                        SwapPositionTradeDialogFragment swapPositionTradeDialogFragment = (SwapPositionTradeDialogFragment) this.f81534x;
                        if (d11.getContractCode().equals(swapPositionTradeDialogFragment.ii()) && d11.getDirection().equals(swapPositionTradeDialogFragment.ji())) {
                            swapPositionTradeDialogFragment.Gi(swapPositionItem);
                        }
                    }
                    BaseDialogFragment baseDialogFragment2 = this.f81534x;
                    if (baseDialogFragment2 != null && (baseDialogFragment2 instanceof SwapHoldStopDialogFragment) && baseDialogFragment2.isVisible()) {
                        SwapHoldStopDialogFragment swapHoldStopDialogFragment = (SwapHoldStopDialogFragment) this.f81534x;
                        if (d11.getContractCode().equals(swapHoldStopDialogFragment.Uh()) && d11.getDirection().equals(swapHoldStopDialogFragment.Vh())) {
                            swapHoldStopDialogFragment.ni(d11, swapPositionItem.e());
                        }
                    }
                }
            }
        }
        this.f81530t.i(false);
    }

    public void c3() {
        this.f81529s.W0();
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    public void clearInputEvent(ClearInputEvent clearInputEvent) {
        ((i1) getUI()).c1(true);
        ((i1) getUI()).u0(true, false);
    }

    public final void d3() {
        Subscriber<List<PriceLimitInfo>> subscriber = this.f81521k;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public final void e3() {
        i6.d.b("contract stopSafeguard");
        ((i1) getUI()).A0(8);
        if (this.f81525o != null) {
            this.f81530t.D();
            v2();
            return;
        }
        Q1();
    }

    public final void f3() {
        Subscriber<List<SwapSettlementPriceInfo>> subscriber = this.f81524n;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public final void g3() {
        Subscriber<Long> subscriber = this.f81523m;
        if (subscriber != null) {
            this.B = false;
            subscriber.unsubscribe();
        }
    }

    public void h3() {
        this.f81529s.X0();
    }

    public final void i3() {
        Subscriber<ContractHeartBeat> subscriber = this.f81517g;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public final void j2(SwapPositionItem swapPositionItem, SwapPosition swapPosition) {
        String str;
        String str2;
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        String m11 = i6.m.m(J1(swapPosition), us.i.m(swapPosition.getSymbol()));
        BigDecimal L1 = L1(m11);
        BigDecimal r32 = r3(swapPosition);
        this.G = r32;
        if (!(r32 == null || r32.compareTo(BigDecimal.ZERO) == 0)) {
            TradeType tradeType = TradeType.SWAP;
            if (a7.e.E(tradeType)) {
                BigDecimal divide = this.G.multiply(i6.m.a(String.valueOf(100))).divide(i6.m.f68179a, 32, 1);
                if (divide.compareTo(BigDecimal.ONE) >= 0 || divide.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal2 = divide.setScale(us.i.b(this.f81526p), 1);
                } else {
                    bigDecimal2 = BigDecimal.ONE;
                }
                str2 = i6.m.a(FutureUnitUtil.d(bigDecimal2.toPlainString(), L1.toPlainString(), this.f81525o.getContractFace(), tradeType)).setScale(us.i.c(this.f81526p), 1).toPlainString();
            } else {
                BigDecimal divide2 = this.G.multiply(i6.m.a(String.valueOf(100))).divide(i6.m.f68179a, 32, 1);
                if (divide2.compareTo(BigDecimal.ONE) >= 0 || divide2.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal = divide2.setScale(us.i.b(this.f81526p), 1);
                } else {
                    bigDecimal = BigDecimal.ONE;
                }
                str2 = bigDecimal.toPlainString();
            }
            if (!TextUtils.isEmpty(str2) && i6.m.a(str2).compareTo(BigDecimal.ZERO) != 0) {
                str = "100%(≈ " + str2 + ")";
                o3(swapPositionItem, swapPosition, m11, str, 2, 6);
            }
        }
        str = "100%";
        o3(swapPositionItem, swapPosition, m11, str, 2, 6);
    }

    public void j3() {
        this.f81529s.Y0();
    }

    public void k2(SwapCurrencyInfo swapCurrencyInfo) {
        this.f81526p = this.f81525o.getSymbol();
        if (!TextUtils.isEmpty(this.f81527q) && !this.f81527q.equals(this.f81525o.getContractCode())) {
            S1(true);
            ((i1) getUI()).c1(true);
            ((i1) getUI()).u0(true, false);
        }
        this.f81527q = this.f81525o.getContractCode();
        this.f81530t.H(this.f81526p);
        this.f81530t.E(this.f81525o);
        this.f81530t.F("");
        ((i1) getUI()).j2(this.F);
        ((i1) getUI()).s1(this.f81526p);
        ((i1) getUI()).c(this.f81530t.n().B());
        ((i1) getUI()).setInputPriceUpdate(false);
        ((i1) getUI()).L(8, swapCurrencyInfo);
        ((i1) getUI()).Z5(this.f81525o);
        ((i1) getUI()).j1();
        ((i1) getUI()).E5((SwapAccountInfo) null);
        ((i1) getUI()).w0(true, true);
        ((i1) getUI()).z0(true);
        ((i1) getUI()).v0();
        t3("--");
        R1();
        ((i1) getUI()).y1();
        ((i1) getUI()).n0();
        this.f81529s.H0();
        g3();
        X2();
        this.f81536z = -1;
        this.f81530t.D();
        v2();
    }

    public void k3() {
        this.f81529s.Z0();
    }

    public void l2() {
        O1();
        v2();
        ((i1) getUI()).y0(true);
        this.f81513c = false;
    }

    public final void l3(boolean z11) {
        if (this.f81525o != null) {
            l9.a.a().g(z11, this.f81525o.getContractShortType(), Period.day, this.K);
        }
    }

    /* renamed from: m2 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, V v11) {
        super.onUIReady(baseCoreActivity, v11);
        this.I = new ej.e(getActivity(), ((i1) getUI()).Z0());
        n1 n1Var = new n1(this.f81531u, getActivity(), this.f81525o, (i1) getUI(), ((i1) getUI()).Ye());
        this.f81530t = n1Var;
        n1Var.G(this);
        ((i1) getUI()).setContractTradeViewController(this.f81530t);
        this.f81530t.y();
        this.f81528r = this.f81530t.u();
        h1 v12 = this.f81530t.v();
        this.f81529s = v12;
        v12.A0(this.L);
        this.f81529s.x0(new k());
        ((i1) getUI()).C1().setAdapter(this.f81529s.S());
        this.f81529s.B0(((i1) getUI()).a1());
        this.f81529s.C0(this);
        this.f81529s.D0(this);
        this.f81529s.N0(v11.e1(), ((i1) getUI()).T0());
        S1(false);
        t3("--");
        s2(dn.d.f().e(this.f81526p));
        ((i1) getUI()).j2(this.F);
        rj.b a11 = this.I.a();
        View D2 = a11.D("rechargeEntry.xml", getActivity());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contractType", "swap");
            a11.I("sendContractInfo(" + jSONObject + ")");
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        r2(D2);
        EventBus.d().p(this);
        this.E = new s();
    }

    public final void m3(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "hold_list");
        gs.g.j("contract_trade", "coin_contract", str, hashMap);
    }

    public void n2(HashMap<String, Object> hashMap) {
        l9.a.a().p(hashMap).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new x());
    }

    public final void n3() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "hold_list");
        gs.g.j("key_backhand", "coin_contract", "confirm", hashMap);
    }

    public String o0() {
        return this.f81526p;
    }

    public void o2() {
        v7.b.a().activityZeroAvailablePosition().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new r());
    }

    public void o3(SwapPositionItem swapPositionItem, SwapPosition swapPosition, String str, String str2, int i11, int i12) {
        if (i12 != 1) {
            str = J1(swapPosition);
        }
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.N0(swapPosition.getSymbol());
        contractOrderPlace.B0(str);
        contractOrderPlace.d0(str2);
        contractOrderPlace.h0(T1(swapPosition));
        contractOrderPlace.A0(i11);
        contractOrderPlace.X0(i12);
        contractOrderPlace.g0(4);
        contractOrderPlace.E0(100);
        if (T1(swapPosition)) {
            contractOrderPlace.W0(getString(R.string.contract_trade_buy_flat_empty));
        } else {
            contractOrderPlace.W0(getString(R.string.contract_trade_sell_flat_more));
        }
        contractOrderPlace.s0(swapPosition.getLeverRate());
        contractOrderPlace.x0(getString(R.string.contract_trade_position_close_quick));
        if (swapPositionItem != null) {
            q3(this.f81528r.v(getActivity(), contractOrderPlace, swapPositionItem.e()), swapPositionItem);
        }
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
        if (aVar.b() == TradeType.SWAP) {
            int a11 = aVar.a();
            i1 i1Var = (i1) getUI();
            boolean z11 = true;
            if (a11 != 1) {
                z11 = false;
            }
            i1Var.m(a11, z11);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onContractCalmPeriodInfoChange(ContractCalmPeriodInfo contractCalmPeriodInfo) {
        if (getUI() != null) {
            ((i1) getUI()).F1();
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onContractCurrencyChange(SwapChangeEvent swapChangeEvent) {
        if (!swapChangeEvent.getInfo().getContractCode().equals(this.f81525o.getContractCode())) {
            W2();
            int e11 = SP.e("SwapTradeTogetherViewOrderType", 0);
            if (ContractGlobalStatus.f83682a && (e11 == 3 || e11 == 4)) {
                e11 = 0;
            }
            ContractGlobalStatus.f83682a = false;
            this.f81513c = false;
            ((i1) getUI()).s0();
            ((i1) getUI()).V0(false);
            ((i1) getUI()).G1(0);
            ((i1) getUI()).g1(e11);
            ((i1) getUI()).S0();
            this.f81530t.L();
            q2(swapChangeEvent.getInfo());
            k2(swapChangeEvent.getInfo());
            ((i1) getUI()).c1(true);
            ((i1) getUI()).u0(true, false);
        }
    }

    public void onPause() {
        super.onPause();
        W2();
        this.f81530t.L();
        l0.y().Q((l0.i) null);
    }

    public void onResume() {
        super.onResume();
        l0.y().Q(this.E);
    }

    public void p2() {
        v7.b.a().requestNewBanner(66, 9, (String) null).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new q());
    }

    public final void q2(SwapCurrencyInfo swapCurrencyInfo) {
        this.f81525o = swapCurrencyInfo;
        ContractUserInfoProvider.i().y(this.f81525o);
        u2();
    }

    public final void q3(ContractOrderPlace contractOrderPlace, SwapPositionItem swapPositionItem) {
        K1(contractOrderPlace, swapPositionItem).subscribe(new a0(this, (k) null));
    }

    public void r2(View view) {
        this.H = view;
        h1 h1Var = this.f81529s;
        if (h1Var != null) {
            h1Var.z0(view);
        }
    }

    public final BigDecimal r3(SwapPosition swapPosition) {
        BigDecimal bigDecimal;
        if (swapPosition == null) {
            bigDecimal = BigDecimal.ZERO;
        } else {
            bigDecimal = i6.m.a(swapPosition.getAvailable());
        }
        this.G = bigDecimal;
        return bigDecimal;
    }

    public void s2(int i11) {
        this.F = i11;
        dn.d.f().p(i11, this.f81526p);
    }

    public final void t2() {
    }

    public void t3(String str) {
        qs.n n11 = this.f81530t.n();
        n11.X(getString(R.string.n_contract_mark_price) + " " + str);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        if (!(getUI() == null || getActivity() == null || !((i1) getUI()).isCanBeSeen())) {
            boolean z11 = false;
            if (((i1) getUI()).getPositionType() == 2) {
                ((i1) getUI()).G1(0);
            }
            this.f81528r.p();
            P1();
            BaseCoreActivity activity = getActivity();
            if (activity != null && (activity instanceof HuobiMainActivity)) {
                z11 = true;
            }
            Intent v11 = k0.v(getActivity(), z11);
            if (!z11) {
                v11.addFlags(67108864);
            }
            rn.c.i().d(getActivity(), new JumpTarget(v11, v11));
        }
        if (getUI() != null) {
            ((i1) getUI()).c1(true);
            ((i1) getUI()).u0(true, true);
        }
    }

    public void u2() {
        Subscription subscription = this.f81520j;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        if (TextUtils.isEmpty(this.f81525o.getActivityId())) {
            ((i1) getUI()).S0();
        } else {
            this.f81520j = Observable.interval(0, 5000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new l());
        }
    }

    public void u3() {
        I2(this.f81526p);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void updateAssetAndOrder(ContractAssetAndOrderUpdateEvent contractAssetAndOrderUpdateEvent) {
        L2();
        P2();
        u3();
    }

    public void v2() {
        com.huobi.utils.w.d().f();
        if (this.f81525o != null) {
            w2();
            U2();
            z2();
            L2();
            J2();
            B2();
            N2();
            G2();
            E2();
            P2();
            u3();
            D2();
            x2();
            K2();
            y2();
            l3(true);
            l9.a.a().d(this.J);
            ((i1) getUI()).U0(this.f81525o.getSymbol());
            ContractPriceProtectionHelper.g(TradeType.SWAP, this.f81525o.getContractCode());
        }
        if (tg.r.x().F0()) {
            a7.e.K(TradeType.SWAP).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new m());
        }
        this.I.d();
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
    public final void v3(com.hbg.lib.network.pro.socket.response.LastKlineResponse r9) {
        /*
            r8 = this;
            com.hbg.lib.network.pro.socket.bean.KlineInfo r0 = r9.getTick()
            if (r0 == 0) goto L_0x00df
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r1 = r8.f81525o
            java.lang.String r1 = r1.getContractShortType()
            java.lang.String r2 = r9.getSymbol()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0018
            goto L_0x00df
        L_0x0018:
            qs.n1 r1 = r8.f81530t
            qs.n r1 = r1.n()
            java.lang.String r2 = r9.getSymbol()
            double r3 = r0.getClose()
            r1.O(r2, r3)
            h6.a r1 = r8.getUI()
            ts.i1 r1 = (ts.i1) r1
            int r1 = r1.v1()
            if (r1 != 0) goto L_0x0037
            r1 = 1
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            bj.l0 r2 = bj.l0.y()
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
            ts.i1 r1 = (ts.i1) r1
            r1.O0(r0, r9, r5)
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.swap.presenter.SwapTradeBasePresenter.v3(com.hbg.lib.network.pro.socket.response.LastKlineResponse):void");
    }

    public final void w1() {
        k2(this.f81525o);
        O1();
        this.f81530t.x();
    }

    public final void w2() {
        if (tg.r.x().F0()) {
            SwapAllowLevelController.b(false, this.f81526p).compose(RxJavaHelper.t((u6.g) getUI())).retry(3).subscribe(new z());
        }
    }

    public final void w3() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (this.f81533w != null) {
            ArrayList arrayList = new ArrayList();
            TopScrollData topScrollData = new TopScrollData();
            topScrollData.l(DateTimeUtils.A(this.f81533w.getFundingTime()) + " " + getActivity().getString(R.string.n_contract_swap_fee_rate));
            topScrollData.m(i6.m.R(this.f81533w.getFinalFundingRate(), us.i.i(), 1, getActivity().getString(R.string.text_default_string)));
            int i11 = this.f81536z;
            if (i11 == 2) {
                arrayList.add(topScrollData);
                TopScrollData topScrollData2 = new TopScrollData();
                long j11 = this.D;
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
                    arrayList.add(topScrollData2);
                } else if (i12 <= 0) {
                    topScrollData2.l(getString(R.string.n_contract_distance_settlement_time_label) + " 00:00:00");
                    arrayList.add(topScrollData2);
                }
                SwapSettlementPriceInfo b11 = SwapSettlementController.b(this.f81525o.getContractCode());
                TopScrollData topScrollData3 = new TopScrollData();
                topScrollData3.l(getString(R.string.n_contract_current_predict_settlement_price));
                if (b11 == null || TextUtils.isEmpty(b11.getEstimatedSettlementPrice())) {
                    topScrollData3.m("--");
                } else {
                    topScrollData3.m(String.format(getString(R.string.contract_delivery_price), new Object[]{i6.m.m(b11.getEstimatedSettlementPrice(), us.i.m(this.f81526p))}));
                }
                arrayList.add(topScrollData3);
            } else if (i11 == 1) {
                TopScrollData topScrollData4 = new TopScrollData();
                long j14 = this.C;
                int i13 = (j14 > 0 ? 1 : (j14 == 0 ? 0 : -1));
                if (i13 > 0 && j14 <= Period.MIN60_MILLS) {
                    long j15 = j14 / Period.MIN60_MILLS;
                    if (j15 < 10) {
                        str = "0" + j15;
                    } else {
                        str = String.valueOf(j15);
                    }
                    long j16 = j14 % Period.MIN60_MILLS;
                    long j17 = j16 / ConfigConstant.f68415c;
                    if (j17 < 10) {
                        str2 = "0" + j17;
                    } else {
                        str2 = String.valueOf(j17);
                    }
                    long j18 = (j16 % ConfigConstant.f68415c) / 1000;
                    if (j18 < 10) {
                        str3 = "0" + j18;
                    } else {
                        str3 = String.valueOf(j18);
                    }
                    topScrollData4.l(getString(R.string.n_contract_distance_delivery_time_label) + " " + (str + ":" + str2 + ":" + str3));
                    arrayList.add(topScrollData4);
                } else if (i13 <= 0) {
                    topScrollData4.l(getString(R.string.n_contract_distance_delivery_time_label) + " 00:00:00");
                    arrayList.add(topScrollData4);
                } else {
                    arrayList.add(topScrollData);
                }
                SwapSettlementPriceInfo b12 = SwapSettlementController.b(this.f81525o.getContractCode());
                TopScrollData topScrollData5 = new TopScrollData();
                topScrollData5.l(getString(R.string.contract_predict_delivery_price));
                if (b12 == null || TextUtils.isEmpty(b12.getEstimatedSettlementPrice())) {
                    topScrollData5.m("--");
                } else {
                    topScrollData5.m(String.format(getString(R.string.contract_delivery_price), new Object[]{i6.m.m(b12.getEstimatedSettlementPrice(), us.i.m(this.f81526p))}));
                }
                arrayList.add(topScrollData5);
            } else {
                arrayList.add(topScrollData);
            }
            i6.d.b(arrayList.toString());
            ((i1) getUI()).s2(arrayList, !this.f81532v, false);
        }
    }

    public void x1() {
        this.f81529s.N0(((i1) getUI()).e1(), ((i1) getUI()).T0());
    }

    public final void x2() {
        if (tg.r.x().F0()) {
            m9.i.d().c(false, this.f81526p).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new v());
        }
    }

    public void x3(int i11) {
        this.F = i11 == 0 ? 4 : 5;
        dn.d.f().p(this.F, this.f81526p);
    }

    public final Subscriber<List<SwapCurrencyInfo>> y1() {
        return new f();
    }

    public final void y2() {
        if (tg.r.x().F0()) {
            FutureClearDialogConfigController.c(20, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new w());
        } else {
            t2();
        }
    }

    public final Subscriber<Long> z1() {
        return new g();
    }

    public final void z2() {
        Subscriber<List<SwapCurrencyInfo>> subscriber = this.f81516f;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f81516f = y1();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(ss.m.f26162b).retryWhen(ss.c.f26152b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f81516f);
    }
}
