package com.huobi.linearswap.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import bj.l0;
import bj.o0;
import bj.p0;
import bj.z2;
import bn.q0;
import cn.k2;
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
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.bean.FuturePriceLimitInfo;
import com.hbg.lib.data.future.bean.FutureUserInfo;
import com.hbg.lib.data.future.controller.FutureClearDialogConfigController;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.controller.FuturePriceLimitController;
import com.hbg.lib.data.future.controller.FutureProductInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractClearDialogConfig;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.contract.core.bean.ReversalEstimatedLiquidationPrice;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroAvailablePositionBean;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.NewBannerBean;
import com.hbg.lib.network.linear.swap.controller.LinearSwapAllowLevelController;
import com.hbg.lib.network.linear.swap.controller.LinearSwapHiddenInstrumentsController;
import com.hbg.lib.network.linear.swap.controller.LinearSwapOpenCloseController;
import com.hbg.lib.network.linear.swap.controller.LinearSwapSettlementController;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.LinearOrderInsertRspInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContactConfigInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCrossAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapFundingRate;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapLeverRate;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOpenRight;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPositionModeSwitchRespInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapSettlementPriceInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTimeSharingGlobalConfig;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.pro.core.bean.AssetModeBean;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.response.LastKlineResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.huobi.bond.ContractBondAdjustDialogFragment;
import com.huobi.contract.entity.ContractAssetAndOrderUpdateEvent;
import com.huobi.contract.entity.ContractCalmPeriodInfo;
import com.huobi.contract.entity.ContractCancelOrderResult;
import com.huobi.contract.entity.ContractHeartBeat;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.contract.entity.PositionSlippageInfo;
import com.huobi.contract.helper.ContractPriceProtectionHelper;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.coupon.handler.CouponExperienceRequestHelper;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.bean.FutureChangeEvent;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.future.bean.FutureUserOrderLimit;
import com.huobi.kyc.util.KycProxy;
import com.huobi.linearswap.bean.ContractPositionEvent;
import com.huobi.linearswap.ui.LinearSwapHoldStopDialogFragment;
import com.huobi.linearswap.ui.LinearSwapMarketClosingDialog;
import com.huobi.linearswap.ui.LinearSwapPositionTradeDialogFragment;
import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.share.helper.CaptureShareHelper;
import com.huobi.swap.bean.ClearInputEvent;
import com.huobi.utils.ContractGlobalStatus;
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
import nk.e;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
import pk.e;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import ym.f1;

public class LinearSwapTradeBasePresenter<V extends k2> extends BaseFragmentPresenter<V> implements ok.a, ok.b, e.d {

    /* renamed from: e0  reason: collision with root package name */
    public static boolean f75044e0 = true;
    public TradeType A = TradeType.LINEAR_SWAP;
    public boolean B;
    public LinearSwapFundingRate C;
    public BaseDialogFragment D;
    public boolean E;
    public Subscriber<List<LinearSwapContactConfigInfo>> F;
    public int G = 1;
    public int H = 3;
    public int I = -1;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public long N;
    public long O;
    public BigDecimal P;
    public BigDecimal Q;
    public View R;
    public Subscription S;
    public LinearSwapTimeSharingGlobalConfig T;
    public ej.e U;
    public l0.i V;
    public a.d W = new b0();
    public LastKlineListener X = new c0();
    public LinearSwapPositionOrderItem.a Y = new d0();
    public boolean Z;

    /* renamed from: a0  reason: collision with root package name */
    public final MutableLiveData<List<NewBannerBean.BannerAdv>> f75045a0;

    /* renamed from: b0  reason: collision with root package name */
    public LiveData<List<NewBannerBean.BannerAdv>> f75046b0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f75047c;

    /* renamed from: c0  reason: collision with root package name */
    public final MutableLiveData<Boolean> f75048c0;

    /* renamed from: d  reason: collision with root package name */
    public Subscriber<List<LinearSwapAccountInfo>> f75049d;

    /* renamed from: d0  reason: collision with root package name */
    public LiveData<Boolean> f75050d0;

    /* renamed from: e  reason: collision with root package name */
    public Subscriber<List<LinearSwapCrossAccountInfo>> f75051e;

    /* renamed from: f  reason: collision with root package name */
    public Subscription f75052f;

    /* renamed from: g  reason: collision with root package name */
    public Subscriber<String> f75053g;

    /* renamed from: h  reason: collision with root package name */
    public Subscriber<List<FutureContractInfo>> f75054h;

    /* renamed from: i  reason: collision with root package name */
    public Subscriber<ContractHeartBeat> f75055i;

    /* renamed from: j  reason: collision with root package name */
    public Subscriber f75056j;

    /* renamed from: k  reason: collision with root package name */
    public Subscription f75057k;

    /* renamed from: l  reason: collision with root package name */
    public Subscription f75058l;

    /* renamed from: m  reason: collision with root package name */
    public Subscriber<List<FuturePriceLimitInfo>> f75059m;

    /* renamed from: n  reason: collision with root package name */
    public Subscriber<Long> f75060n;

    /* renamed from: o  reason: collision with root package name */
    public Subscriber<Long> f75061o;

    /* renamed from: p  reason: collision with root package name */
    public Subscriber<Long> f75062p;

    /* renamed from: q  reason: collision with root package name */
    public Subscriber<Long> f75063q;

    /* renamed from: r  reason: collision with root package name */
    public Subscriber<List<LinearSwapSettlementPriceInfo>> f75064r;

    /* renamed from: s  reason: collision with root package name */
    public Subscriber<Boolean> f75065s;

    /* renamed from: t  reason: collision with root package name */
    public FutureContractInfo f75066t;

    /* renamed from: u  reason: collision with root package name */
    public String f75067u;

    /* renamed from: v  reason: collision with root package name */
    public String f75068v;

    /* renamed from: w  reason: collision with root package name */
    public ym.z f75069w;

    /* renamed from: x  reason: collision with root package name */
    public f1 f75070x;

    /* renamed from: y  reason: collision with root package name */
    public ym.k f75071y;

    /* renamed from: z  reason: collision with root package name */
    public nk.e f75072z;

    public class a extends EasySubscriber<AccountBalanceInfoV5> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(AccountBalanceInfoV5 accountBalanceInfoV5) {
            if (accountBalanceInfoV5 != null && z6.l.c().i(LinearSwapTradeBasePresenter.this.A)) {
                if (!ConfigPreferences.c("user_config", "config_cross_show_no_right" + tg.r.x().s(), false) && i6.m.a(accountBalanceInfoV5.getAvailableMargin()).compareTo(BigDecimal.ZERO) == 0 && !dn.d.f().l()) {
                    ((k2) LinearSwapTradeBasePresenter.this.getUI()).Eg(LinearSwapTradeBasePresenter.this.f75067u, LinearSwapTradeBasePresenter.this.f75066t.getQuoteCurrency());
                    ConfigPreferences.n("user_config", "config_cross_show_no_right" + tg.r.x().s(), true);
                }
                dn.a.d().b();
                ((k2) LinearSwapTradeBasePresenter.this.getUI()).v5(accountBalanceInfoV5);
                LinearSwapTradeBasePresenter.this.f75072z.I(accountBalanceInfoV5);
                LinearSwapTradeBasePresenter.this.f75069w.t0(accountBalanceInfoV5);
                LinearSwapTradeBasePresenter.this.f75072z.j(false);
                dn.a.d().g(accountBalanceInfoV5.getVoucher());
            }
        }
    }

    public class a0 extends BaseSubscriber<List<LinearSwapContactConfigInfo>> {
        public a0() {
        }

        public void onNext(List<LinearSwapContactConfigInfo> list) {
            super.onNext(list);
            LinearSwapTradeBasePresenter.this.i5();
        }
    }

    public class b extends EasySubscriber<LinearSwapPositionModeSwitchRespInfo> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(LinearSwapPositionModeSwitchRespInfo linearSwapPositionModeSwitchRespInfo) {
            pk.e.a().e(linearSwapPositionModeSwitchRespInfo.isSideSingleMode());
        }
    }

    public class b0 implements a.d {
        public b0() {
        }

        public void a() {
            LinearSwapTradeBasePresenter.this.a5(true);
        }
    }

    public class c extends EasySubscriber<LinearSwapLeverRate> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(LinearSwapLeverRate linearSwapLeverRate) {
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).x0(linearSwapLeverRate.getLeverRate());
            LinearSwapTradeBasePresenter.this.f75072z.K(linearSwapLeverRate.getLeverRate());
        }
    }

    public class c0 extends LastKlineListener {
        public c0() {
        }

        /* renamed from: j */
        public void f(LastKlineResponse lastKlineResponse) {
            LinearSwapTradeBasePresenter.this.n5(lastKlineResponse);
        }

        public void onFailed(Throwable th2) {
            super.onFailed(th2);
            th2.printStackTrace();
            i6.k.g(this.f70671a, "lastKlineListener has error ", th2);
        }
    }

    public class d extends BaseSubscriber<ContractCancelOrderResult> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(ContractCancelOrderResult contractCancelOrderResult) {
            super.onNext(contractCancelOrderResult);
            LinearSwapTradeBasePresenter.this.x4();
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

    public class d0 implements LinearSwapPositionOrderItem.a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f75080a = false;

        /* renamed from: b  reason: collision with root package name */
        public ReversalEstimatedLiquidationPrice f75081b;

        public class a extends q6.d<LinearOrderInsertRspInfo> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HBDialogFragment f75083e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(u6.g gVar, HBDialogFragment hBDialogFragment) {
                super(gVar);
                this.f75083e = hBDialogFragment;
            }

            public void onAfter() {
                super.onAfter();
                HBDialogFragment hBDialogFragment = this.f75083e;
                if (hBDialogFragment != null) {
                    hBDialogFragment.dismiss();
                }
            }
        }

        public class b extends q6.d<LinearOrderInsertRspInfo> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HBDialogFragment f75085e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(u6.g gVar, HBDialogFragment hBDialogFragment) {
                super(gVar);
                this.f75085e = hBDialogFragment;
            }

            public void onAfter() {
                super.onAfter();
                HBDialogFragment hBDialogFragment = this.f75085e;
                if (hBDialogFragment != null) {
                    hBDialogFragment.dismiss();
                }
            }
        }

        public class c extends EasySubscriber<PositionSlippageInfo> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f75087b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ FutureContractInfo f75088c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ DialogUtils.b f75089d;

            public c(boolean z11, FutureContractInfo futureContractInfo, DialogUtils.b bVar) {
                this.f75087b = z11;
                this.f75088c = futureContractInfo;
                this.f75089d = bVar;
            }

            /* renamed from: a */
            public void onNext(PositionSlippageInfo positionSlippageInfo) {
                if (positionSlippageInfo.getClosingSlippage() != null && !positionSlippageInfo.getClosingSlippage().isEmpty()) {
                    if (this.f75087b) {
                        d0.this.v(positionSlippageInfo.getClosingSlippage(), this.f75088c, this.f75089d);
                    } else if (LinearSwapTradeBasePresenter.this.D instanceof LinearSwapMarketClosingDialog) {
                        ((LinearSwapMarketClosingDialog) LinearSwapTradeBasePresenter.this.D).Rh(positionSlippageInfo.getClosingSlippage());
                    }
                }
            }
        }

        public class d extends EasySubscriber<ReversalEstimatedLiquidationPrice> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ HBDialogFragment f75091b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ LinearSwapPositionOrderItem f75092c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ DialogUtils.b f75093d;

            public d(HBDialogFragment hBDialogFragment, LinearSwapPositionOrderItem linearSwapPositionOrderItem, DialogUtils.b bVar) {
                this.f75091b = hBDialogFragment;
                this.f75092c = linearSwapPositionOrderItem;
                this.f75093d = bVar;
            }

            /* renamed from: a */
            public void onNext(ReversalEstimatedLiquidationPrice reversalEstimatedLiquidationPrice) {
                super.onNext(reversalEstimatedLiquidationPrice);
                if (!this.f75091b.isDetached()) {
                    d0 d0Var = d0.this;
                    d0Var.f75081b = reversalEstimatedLiquidationPrice;
                    d0Var.t(this.f75092c, this.f75093d);
                }
            }
        }

        public class e extends EasySubscriber<ReversalEstimatedLiquidationPrice> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ HBDialogFragment f75095b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ LinearSwapPositionOrderItem f75096c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ DialogUtils.b f75097d;

            public e(HBDialogFragment hBDialogFragment, LinearSwapPositionOrderItem linearSwapPositionOrderItem, DialogUtils.b bVar) {
                this.f75095b = hBDialogFragment;
                this.f75096c = linearSwapPositionOrderItem;
                this.f75097d = bVar;
            }

            /* renamed from: a */
            public void onNext(ReversalEstimatedLiquidationPrice reversalEstimatedLiquidationPrice) {
                super.onNext(reversalEstimatedLiquidationPrice);
                if (!this.f75095b.isDetached()) {
                    d0 d0Var = d0.this;
                    d0Var.f75081b = reversalEstimatedLiquidationPrice;
                    d0Var.t(this.f75096c, this.f75097d);
                }
            }
        }

        public class f implements LeverSelectDialogFragment.h {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ FutureContractInfo f75099a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f75100b;

            public f(FutureContractInfo futureContractInfo, int i11) {
                this.f75099a = futureContractInfo;
                this.f75100b = i11;
            }

            public void N0() {
                String str;
                String str2;
                TradeType tradeType = TradeType.LINEAR_SWAP;
                if (a7.e.E(tradeType)) {
                    str = "symbol";
                } else {
                    str = a7.e.G(tradeType) ? "usdt" : "sheet";
                }
                String str3 = str;
                if ("cny".equals(LegalCurrencyConfigUtil.y())) {
                    str2 = "cny";
                } else {
                    str2 = "usd";
                }
                ContractWebActivity.ii(LinearSwapTradeBasePresenter.this.getActivity(), this.f75099a.getSymbol(), str3, str2, this.f75099a.getContractCode(), this.f75099a.getContractShortType(), this.f75100b == 2 ? FutureContractInfo.MARGIN_ISOLATED : FutureContractInfo.MARGIN_CROSS, 4);
            }

            public Observable<List<LevelAvailableMarginInfo>> O0(TradeType tradeType, String str, int i11) {
                return uc.b.d(tradeType, str, i11);
            }

            public void P0(String str) {
                if (!TextUtils.equals(LinearSwapTradeBasePresenter.this.f75068v, this.f75099a.contractCode) || LinearSwapTradeBasePresenter.this.G != this.f75100b) {
                    LinearSwapTradeBasePresenter.this.l5();
                    return;
                }
                ((k2) LinearSwapTradeBasePresenter.this.getUI()).x0(str);
                LinearSwapTradeBasePresenter.this.f75072z.K(str);
                LinearSwapTradeBasePresenter.this.f75072z.F();
            }

            public String[] Q0(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
                return new String[2];
            }

            public boolean R0(LeverSelectDialogFragment leverSelectDialogFragment, String str) {
                if (LinearSwapTradeBasePresenter.this.f75072z == null) {
                    return true;
                }
                LinearSwapTradeBasePresenter.this.f75072z.G(leverSelectDialogFragment, str, this.f75099a.contractCode, this.f75100b);
                return true;
            }
        }

        public d0() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void q(LinearSwapPositionOrderItem linearSwapPositionOrderItem, HBDialogFragment hBDialogFragment) {
            LinearSwapTradeBasePresenter.this.d5();
            p0.n(!this.f75080a);
            o(linearSwapPositionOrderItem, hBDialogFragment);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void r(boolean z11) {
            this.f75080a = z11;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void s(LinearSwapPositionOrderItem linearSwapPositionOrderItem, DialogUtils.b bVar) {
            p(linearSwapPositionOrderItem.f26409b, linearSwapPositionOrderItem.d(), true, bVar);
            t(linearSwapPositionOrderItem, bVar);
        }

        public String a() {
            return ContractWebActivity.Eh(4);
        }

        public void b(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
            ContractPosition a11 = dn.i.a(linearSwapPositionOrderItem.f26409b);
            a11.contractShortType = LinearSwapTradeBasePresenter.this.f75066t.contractShortType;
            a11.quoteCurrency = LinearSwapTradeBasePresenter.this.f75066t.quoteCurrency;
            CaptureShareHelper.g(LinearSwapTradeBasePresenter.this.getActivity(), a11, CaptureShareHelper.ContractType.LinearSwap);
            i6.k.o("ACTION-LINEAR-SWAP", "持仓item中按钮点击分享");
            is.a.j("4690", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
            LinearSwapTradeBasePresenter.this.c5("hold_share");
        }

        public void c(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
            boolean k11 = dn.d.f().k();
            ContractBondAdjustDialogFragment contractBondAdjustDialogFragment = new ContractBondAdjustDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("enableReduce", k11);
            contractBondAdjustDialogFragment.setArguments(bundle);
            contractBondAdjustDialogFragment.Kh(linearSwapPositionOrderItem);
            contractBondAdjustDialogFragment.show(LinearSwapTradeBasePresenter.this.getActivity().getSupportFragmentManager(), "ContractBondAdjustDialogFragment");
        }

        public void d(LinearSwapPositionOrderItem linearSwapPositionOrderItem, int i11) {
            LinearSwapHoldStopDialogFragment linearSwapHoldStopDialogFragment = new LinearSwapHoldStopDialogFragment();
            linearSwapHoldStopDialogFragment.f43197g = i11;
            linearSwapHoldStopDialogFragment.ii(linearSwapPositionOrderItem.e(), linearSwapPositionOrderItem.d());
            linearSwapHoldStopDialogFragment.ji(FutureContractInfo.MARGIN_CROSS.endsWith(linearSwapPositionOrderItem.e().getMarginMode()) ? 1 : 2);
            BaseDialogFragment unused = LinearSwapTradeBasePresenter.this.D = linearSwapHoldStopDialogFragment;
            LinearSwapTradeBasePresenter.this.D.show(LinearSwapTradeBasePresenter.this.getActivity().getSupportFragmentManager(), "LinearSwap onCloseStopProfitClick");
            i6.k.o("ACTION-LINEAR-SWAP", "持仓item中按钮点击止盈止损");
            is.a.j("5140", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
            LinearSwapTradeBasePresenter.this.c5("stop_surplus_loss");
        }

        public void e(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
            if (LinearSwapTradeBasePresenter.this.D != null && LinearSwapTradeBasePresenter.this.D.isVisible()) {
                LinearSwapTradeBasePresenter.this.D.doDismiss();
            }
            if (i6.m.a(linearSwapPositionOrderItem.f26409b.available).compareTo(BigDecimal.ZERO) <= 0) {
                HuobiToastUtil.j(R.string.contract_trade_close_available_not_enough);
                return;
            }
            i6.k.o("ACTION-LINEAR-SWAP", "持仓item中按钮点击平仓");
            LinearSwapPositionTradeDialogFragment linearSwapPositionTradeDialogFragment = new LinearSwapPositionTradeDialogFragment();
            linearSwapPositionTradeDialogFragment.Ci(linearSwapPositionOrderItem);
            linearSwapPositionTradeDialogFragment.Di(FutureContractInfo.MARGIN_CROSS.endsWith(linearSwapPositionOrderItem.e().getMarginMode()) ? 1 : 2);
            BaseDialogFragment unused = LinearSwapTradeBasePresenter.this.D = linearSwapPositionTradeDialogFragment;
            LinearSwapTradeBasePresenter.this.D.show(LinearSwapTradeBasePresenter.this.getActivity().getSupportFragmentManager(), "LinearSwap onCloseClick");
            is.a.j("4687", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
            LinearSwapTradeBasePresenter.this.c5("flat");
        }

        public void f(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
            LinearSwapTradeBaseFragment.Mj(LinearSwapTradeBasePresenter.this.getActivity(), linearSwapPositionOrderItem.d(), 0, FutureContractInfo.MARGIN_CROSS.equalsIgnoreCase(linearSwapPositionOrderItem.e().getMarginMode()) ? 1 : 2);
        }

        public LeverSelectDialogFragment.h g(FutureContractInfo futureContractInfo, int i11) {
            return new f(futureContractInfo, i11);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0053, code lost:
            if (com.hbg.lib.core.util.w.l() != false) goto L_0x0044;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0041, code lost:
            if (com.hbg.lib.core.util.w.l() != false) goto L_0x0056;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void h(com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem r12) {
            /*
                r11 = this;
                java.lang.String r0 = "ACTION-LINEAR-SWAP"
                java.lang.String r1 = "持仓item中按钮点击一键反手"
                i6.k.o(r0, r1)
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r0 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                java.lang.String r1 = "key_backhand"
                r0.c5(r1)
                boolean r0 = bj.p0.f()
                r1 = 0
                if (r0 != 0) goto L_0x0019
                r11.o(r12, r1)
                return
            L_0x0019:
                r0 = 0
                r11.f75080a = r0
                r11.f75081b = r1
                com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r1 = r12.f26409b
                java.lang.String r1 = r1.getDirection()
                com.hbg.lib.network.option.core.util.OptionDirection r2 = com.hbg.lib.network.option.core.util.OptionDirection.BUY
                java.lang.String r2 = r2.direction
                boolean r1 = r2.equalsIgnoreCase(r1)
                r2 = 2131100799(0x7f06047f, float:1.781399E38)
                r3 = 2131100818(0x7f060492, float:1.7814028E38)
                if (r1 == 0) goto L_0x0046
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r1 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                r4 = 2132020977(0x7f140ef1, float:1.9680332E38)
                java.lang.String r1 = r1.getString(r4)
                boolean r4 = com.hbg.lib.core.util.w.l()
                if (r4 == 0) goto L_0x0044
                goto L_0x0056
            L_0x0044:
                r2 = r3
                goto L_0x0056
            L_0x0046:
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r1 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                r4 = 2132020996(0x7f140f04, float:1.968037E38)
                java.lang.String r1 = r1.getString(r4)
                boolean r4 = com.hbg.lib.core.util.w.l()
                if (r4 == 0) goto L_0x0056
                goto L_0x0044
            L_0x0056:
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r4 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                r5 = 2132020961(0x7f140ee1, float:1.96803E38)
                java.lang.String r4 = r4.getString(r5)
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r5 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                r6 = 2132020964(0x7f140ee4, float:1.9680306E38)
                java.lang.String r5 = r5.getString(r6)
                r6 = 2
                java.lang.Object[] r6 = new java.lang.Object[r6]
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r8 = r12.f26409b
                java.lang.String r8 = r8.getSymbol()
                r7.append(r8)
                com.hbg.lib.data.future.bean.FutureContractInfo r8 = r12.f26410c
                java.lang.String r8 = r8.getQuoteCurrency()
                r7.append(r8)
                r7.append(r1)
                com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r8 = r12.f26409b
                java.lang.String r8 = r8.getLeverRate()
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
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r10 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                com.hbg.lib.common.ui.BaseCoreActivity r10 = r10.getActivity()
                int r2 = androidx.core.content.ContextCompat.getColor(r10, r2)
                r9.<init>(r2)
                int r1 = r1.length()
                int r1 = r1 + r6
                r2 = 33
                r8.setSpan(r9, r6, r1, r2)
                int r1 = r5.indexOf(r4)
                android.text.style.ForegroundColorSpan r5 = new android.text.style.ForegroundColorSpan
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r6 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                com.hbg.lib.common.ui.BaseCoreActivity r6 = r6.getActivity()
                int r3 = androidx.core.content.ContextCompat.getColor(r6, r3)
                r5.<init>(r3)
                int r3 = r4.length()
                int r3 = r3 + r1
                r8.setSpan(r5, r1, r3, r2)
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r1 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                r2 = 2132020963(0x7f140ee3, float:1.9680304E38)
                java.lang.String r1 = r1.getString(r2)
                com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r2 = r12.e()
                java.lang.String r2 = r2.getMarketClosingSlippage()
                boolean r2 = android.text.TextUtils.isEmpty(r2)
                if (r2 != 0) goto L_0x0158
                com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r2 = r12.e()
                java.lang.String r2 = r2.getMarketClosingSlippage()
                com.hbg.lib.data.future.bean.FutureContractInfo r3 = r12.d()
                java.lang.String r3 = r3.getContractCode()
                com.hbg.lib.data.future.bean.FutureContractInfo r4 = r12.d()
                java.lang.String r4 = r4.getContractShortType()
                com.hbg.lib.data.future.bean.FutureContractInfo r5 = r12.d()
                java.lang.String r5 = r5.getOptionCode()
                int r3 = com.hbg.lib.data.future.util.FuturePrecisionUtil.y(r3, r4, r5)
                java.lang.String r2 = i6.m.m(r2, r3)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r1)
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r1 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                r4 = 2132020908(0x7f140eac, float:1.9680192E38)
                java.lang.String r1 = r1.getString(r4)
                java.lang.Object[] r4 = new java.lang.Object[r7]
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r2)
                java.lang.String r2 = " "
                r5.append(r2)
                com.hbg.lib.data.future.bean.FutureContractInfo r2 = r12.d()
                java.lang.String r2 = r2.getQuoteCurrency()
                r5.append(r2)
                java.lang.String r2 = r5.toString()
                r4[r0] = r2
                java.lang.String r0 = java.lang.String.format(r1, r4)
                r3.append(r0)
                java.lang.String r1 = r3.toString()
            L_0x0158:
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = new com.hbg.lib.widgets.dialog.DialogUtils$b$d
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r2 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
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
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r2 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
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
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r1 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                android.content.res.Resources r1 = r1.getResources()
                r3 = 2131099907(0x7f060103, float:1.781218E38)
                int r1 = r1.getColor(r3)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.S0(r1)
                float r1 = com.hbg.lib.common.utils.PixelUtils.b(r2)
                java.lang.Float r1 = java.lang.Float.valueOf(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.W0(r1)
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r1 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                r2 = 2132020548(0x7f140d44, float:1.9679462E38)
                java.lang.String r1 = r1.getString(r2)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.P0(r1)
                bn.o0 r1 = new bn.o0
                r1.<init>(r11, r12)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.Q0(r1)
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r1 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                r2 = 2132020382(0x7f140c9e, float:1.9679126E38)
                java.lang.String r1 = r1.getString(r2)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.s0(r1)
                bj.o0 r1 = bj.o0.f12469a
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.N0(r1)
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r1 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                r2 = 2132020768(0x7f140e20, float:1.9679908E38)
                java.lang.String r1 = r1.getString(r2)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.y0(r1)
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r1 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                android.content.res.Resources r1 = r1.getResources()
                r2 = 2131099918(0x7f06010e, float:1.7812203E38)
                int r1 = r1.getColor(r2)
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.z0(r1)
                r1 = 1094713344(0x41400000, float:12.0)
                float r1 = com.hbg.lib.common.utils.PixelUtils.b(r1)
                java.lang.Float r1 = java.lang.Float.valueOf(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.A0(r1)
                bn.n0 r1 = new bn.n0
                r1.<init>(r11)
                com.hbg.lib.widgets.dialog.DialogUtils$b$d r0 = r0.v0(r1)
                com.hbg.lib.widgets.dialog.DialogUtils$b r0 = r0.m0()
                bn.p0 r1 = new bn.p0
                r1.<init>(r11, r12, r0)
                com.hbg.lib.widgets.dialog.HBDialogFragment r1 = r0.y0(r1)
                com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter r2 = com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.this
                com.hbg.lib.common.ui.BaseCoreActivity r2 = r2.getActivity()
                androidx.fragment.app.FragmentManager r2 = r2.getSupportFragmentManager()
                java.lang.String r3 = "reverseDialogFragment"
                r1.show(r2, r3)
                r11.u(r12, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.d0.h(com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem):void");
        }

        public void i(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
            if (LinearSwapTradeBasePresenter.this.D != null && LinearSwapTradeBasePresenter.this.D.isVisible()) {
                LinearSwapTradeBasePresenter.this.D.doDismiss();
            }
            i6.k.o("ACTION-LINEAR-SWAP", "持仓item中按钮点击市价全平");
            if (!p0.a()) {
                LinearSwapPosition e11 = linearSwapPositionOrderItem.e();
                ym.z Y0 = LinearSwapTradeBasePresenter.this.f75069w;
                Y0.u0(e11.getContractCode() + "_" + e11.getMarginMode() + e11.getDirection(), e11);
                LinearSwapTradeBasePresenter.this.H3(linearSwapPositionOrderItem, e11);
            } else {
                if (i6.m.a(linearSwapPositionOrderItem.e().getAvailable()).compareTo(BigDecimal.ZERO) <= 0) {
                    linearSwapPositionOrderItem.e().setAvailable(linearSwapPositionOrderItem.e().getVolume());
                }
                LinearSwapMarketClosingDialog linearSwapMarketClosingDialog = new LinearSwapMarketClosingDialog();
                linearSwapMarketClosingDialog.Kh(linearSwapPositionOrderItem);
                linearSwapMarketClosingDialog.Lh(FutureContractInfo.MARGIN_CROSS.endsWith(linearSwapPositionOrderItem.e().getMarginMode()) ? 1 : 2);
                BaseDialogFragment unused = LinearSwapTradeBasePresenter.this.D = linearSwapMarketClosingDialog;
                LinearSwapTradeBasePresenter.this.D.show(LinearSwapTradeBasePresenter.this.getActivity().getSupportFragmentManager(), "LinearSwap onLightningCloseClick");
                p(linearSwapPositionOrderItem.e(), linearSwapPositionOrderItem.d(), false, (DialogUtils.b) null);
            }
            is.a.j("4689", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
            LinearSwapTradeBasePresenter.this.c5("market_price_flat");
        }

        public final void o(LinearSwapPositionOrderItem linearSwapPositionOrderItem, HBDialogFragment hBDialogFragment) {
            if (TextUtils.equals(FutureContractInfo.MARGIN_CROSS, linearSwapPositionOrderItem.e().getMarginMode())) {
                h8.b a11 = h8.a.a();
                LinearSwapPosition linearSwapPosition = linearSwapPositionOrderItem.f26409b;
                a11.u0(linearSwapPosition.contractCode, linearSwapPosition.direction, linearSwapPosition.getPositionSide()).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new a((u6.g) LinearSwapTradeBasePresenter.this.getUI(), hBDialogFragment));
                return;
            }
            h8.b a12 = h8.a.a();
            LinearSwapPosition linearSwapPosition2 = linearSwapPositionOrderItem.f26409b;
            a12.a0(linearSwapPosition2.contractCode, linearSwapPosition2.direction, linearSwapPosition2.getPositionSide()).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new b((u6.g) LinearSwapTradeBasePresenter.this.getUI(), hBDialogFragment));
        }

        public final void p(LinearSwapPosition linearSwapPosition, FutureContractInfo futureContractInfo, boolean z11, DialogUtils.b bVar) {
            if (SPUtil.j()) {
                h8.a.a().j0(linearSwapPosition.direction, linearSwapPosition.volume, linearSwapPosition.contractCode).b().compose(RxJavaHelper.t((u6.g) LinearSwapTradeBasePresenter.this.getUI())).subscribe(new c(z11, futureContractInfo, bVar));
            }
        }

        public final void t(LinearSwapPositionOrderItem linearSwapPositionOrderItem, DialogUtils.b bVar) {
            ReversalEstimatedLiquidationPrice reversalEstimatedLiquidationPrice;
            if (bVar != null && bVar.B0() != null && (reversalEstimatedLiquidationPrice = this.f75081b) != null && !TextUtils.isEmpty(reversalEstimatedLiquidationPrice.getLiquidationPrice())) {
                String q11 = i6.m.q(i6.m.a(this.f75081b.getLiquidationPrice()), FuturePrecisionUtil.y(linearSwapPositionOrderItem.d().getContractCode(), linearSwapPositionOrderItem.d().getContractShortType(), (String) null));
                bVar.B0().setText(LinearSwapTradeBasePresenter.this.getString(R.string.n_contract_reversal_estimated_liquidation_price) + q11 + this.f75081b.getUnit());
                bVar.B0().setVisibility(0);
            }
        }

        public final void u(LinearSwapPositionOrderItem linearSwapPositionOrderItem, DialogUtils.b bVar, HBDialogFragment hBDialogFragment) {
            if (TextUtils.equals(FutureContractInfo.MARGIN_CROSS, linearSwapPositionOrderItem.e().getMarginMode())) {
                h8.b a11 = h8.a.a();
                LinearSwapPosition linearSwapPosition = linearSwapPositionOrderItem.f26409b;
                a11.C(linearSwapPosition.contractCode, linearSwapPosition.direction, linearSwapPosition.getPositionSide()).b().compose(RxJavaHelper.t((u6.g) LinearSwapTradeBasePresenter.this.getUI())).subscribe(new d(hBDialogFragment, linearSwapPositionOrderItem, bVar));
                return;
            }
            h8.b a12 = h8.a.a();
            LinearSwapPosition linearSwapPosition2 = linearSwapPositionOrderItem.f26409b;
            a12.N(linearSwapPosition2.contractCode, linearSwapPosition2.direction, linearSwapPosition2.getPositionSide()).b().compose(RxJavaHelper.t((u6.g) LinearSwapTradeBasePresenter.this.getUI())).subscribe(new e(hBDialogFragment, linearSwapPositionOrderItem, bVar));
        }

        public final void v(String str, FutureContractInfo futureContractInfo, DialogUtils.b bVar) {
            TextView textView;
            String string = LinearSwapTradeBasePresenter.this.getString(R.string.n_contract_order_reverse_dialog_content_new);
            if (!TextUtils.isEmpty(str)) {
                String m11 = i6.m.m(str, FuturePrecisionUtil.y(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), futureContractInfo.getOptionCode()));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                String string2 = LinearSwapTradeBasePresenter.this.getString(R.string.n_contract_market_closing_slippage_new);
                sb2.append(String.format(string2, new Object[]{m11 + " " + futureContractInfo.getQuoteCurrency()}));
                string = sb2.toString();
            }
            if (bVar.C0() != null && (textView = (TextView) bVar.C0().findViewById(R.id.dialog_third_title)) != null) {
                textView.setText(string);
                textView.setVisibility(0);
            }
        }
    }

    public class e extends BaseSubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f75102b;

        public e(boolean z11) {
            this.f75102b = z11;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).dismissProgressDialog();
            EventBus.d().k(new AssetModeBean(Boolean.valueOf(this.f75102b), Boolean.FALSE));
            if (th2 instanceof APIStatusErrorException) {
                APIStatusErrorException aPIStatusErrorException = (APIStatusErrorException) th2;
                if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                    HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
                }
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).dismissProgressDialog();
            SPUtil.s(this.f75102b);
            EventBus.d().k(new AssetModeBean(Boolean.valueOf(this.f75102b), Boolean.TRUE));
            gs.g.h(this.f75102b);
            HuobiToastUtil.s(R.string.n_copy_trading_order_success);
        }
    }

    public class e0 extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f75104b;

        public e0(String str) {
            this.f75104b = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            UnifyTransferActivity.Th(LinearSwapTradeBasePresenter.this.getActivity(), "usdt", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            th2.printStackTrace();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (aPIStatusErrorException.getErrCode().equals("70037")) {
                DialogUtils.c0(LinearSwapTradeBasePresenter.this.getActivity(), LinearSwapTradeBasePresenter.this.getString(R.string.n_attention), String.format(LinearSwapTradeBasePresenter.this.getString(R.string.n_contract_coupon_convert_limit_desc), new Object[]{this.f75104b}), LinearSwapTradeBasePresenter.this.getString(R.string.global_string_cancel), LinearSwapTradeBasePresenter.this.getString(R.string.go_to_transfer), o0.f12469a, new q0(this));
            }
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            LinearSwapTradeBasePresenter.this.Y3();
        }
    }

    public class f extends BaseSubscriber<LinearSwapOpenRight> {
        public f() {
        }

        /* renamed from: a */
        public void onNext(LinearSwapOpenRight linearSwapOpenRight) {
            super.onNext(linearSwapOpenRight);
            if (linearSwapOpenRight.getRight() == 0) {
                z2.c().b("CLEAR_AFTER_NAME", 1);
                if (((k2) LinearSwapTradeBasePresenter.this.getUI()).getPositionType() == 0) {
                    ((k2) LinearSwapTradeBasePresenter.this.getUI()).z0(false);
                } else {
                    ((k2) LinearSwapTradeBasePresenter.this.getUI()).z0(true);
                }
            } else {
                ((k2) LinearSwapTradeBasePresenter.this.getUI()).z0(true);
                z2.c().b("CLEAR_AFTER_NAME", 3);
                LinearSwapTradeBasePresenter.this.X3();
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            z2.c().b("CLEAR_AFTER_NAME", 3);
            LinearSwapTradeBasePresenter.this.X3();
        }
    }

    public class f0 extends BaseSubscriber<NewBannerBean> {
        public f0() {
        }

        /* renamed from: a */
        public void onNext(NewBannerBean newBannerBean) {
            super.onNext(newBannerBean);
            ArrayList arrayList = new ArrayList();
            if (!(newBannerBean == null || newBannerBean.getBannerAdvList() == null)) {
                arrayList.addAll(newBannerBean.getBannerAdvList());
            }
            LinearSwapTradeBasePresenter.this.f75045a0.postValue(arrayList);
        }
    }

    public class g extends EasySubscriber<LinearSwapTimeSharingGlobalConfig> {
        public g() {
        }

        /* renamed from: a */
        public void onNext(LinearSwapTimeSharingGlobalConfig linearSwapTimeSharingGlobalConfig) {
            super.onNext(linearSwapTimeSharingGlobalConfig);
            LinearSwapTimeSharingGlobalConfig unused = LinearSwapTradeBasePresenter.this.T = linearSwapTimeSharingGlobalConfig;
            qk.a.b().h(linearSwapTimeSharingGlobalConfig);
            qk.a.b().i(LinearSwapTradeBasePresenter.this.Q2());
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).N5();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
        }
    }

    public class g0 extends BaseSubscriber<FutureUserInfo> {
        public g0() {
        }

        /* renamed from: a */
        public void onNext(FutureUserInfo futureUserInfo) {
            super.onNext(futureUserInfo);
            LinearSwapTradeBasePresenter.this.s4();
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).F1();
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).I1();
        }
    }

    public class h extends BaseSubscriber<List<String>> {
        public h() {
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).setLeverList(list);
        }
    }

    public class h0 extends BaseSubscriber<Long> {

        public class a extends BaseSubscriber<LinearSwapFundingRate> {
            public a() {
            }

            /* renamed from: a */
            public void onNext(LinearSwapFundingRate linearSwapFundingRate) {
                super.onNext(linearSwapFundingRate);
                LinearSwapFundingRate unused = LinearSwapTradeBasePresenter.this.C = linearSwapFundingRate;
                LinearSwapTradeBasePresenter.this.o5();
                if (linearSwapFundingRate != null) {
                    boolean unused2 = LinearSwapTradeBasePresenter.this.B = true;
                }
            }

            public void onError(Throwable th2) {
                super.onError(th2);
                LinearSwapTradeBasePresenter.this.M2(false);
            }
        }

        public h0() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            h8.a.a().getFundingRate(LinearSwapTradeBasePresenter.this.f75068v, TtmlNode.COMBINE_ALL).b().compose(RxJavaHelper.t((u6.g) LinearSwapTradeBasePresenter.this.getUI())).subscribe(new a());
        }
    }

    public class i extends BaseSubscriber<List<FutureUserOrderLimit>> {
        public i() {
        }

        public void onNext(List<FutureUserOrderLimit> list) {
            super.onNext(list);
        }
    }

    public class i0 extends BaseSubscriber<ActivityZeroAvailablePositionBean> {
        public i0() {
        }

        /* renamed from: a */
        public void onNext(ActivityZeroAvailablePositionBean activityZeroAvailablePositionBean) {
            super.onNext(activityZeroAvailablePositionBean);
            if (activityZeroAvailablePositionBean != null) {
                boolean z11 = false;
                int intValue = activityZeroAvailablePositionBean.getAvailable() == null ? 0 : activityZeroAvailablePositionBean.getAvailable().intValue();
                MutableLiveData Z1 = LinearSwapTradeBasePresenter.this.f75048c0;
                if (1 == intValue) {
                    z11 = true;
                }
                Z1.postValue(Boolean.valueOf(z11));
            }
        }
    }

    public class j extends BaseSubscriber<Boolean> {
        public j() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).Ib(bool.booleanValue(), LinearSwapTradeBasePresenter.this.w2());
        }
    }

    public class j0 extends BaseSubscriber<ContractClearDialogConfig> {
        public j0() {
        }

        /* renamed from: a */
        public void onNext(ContractClearDialogConfig contractClearDialogConfig) {
            super.onNext(contractClearDialogConfig);
            if (FutureClearDialogConfigController.g(20)) {
                z2.c().b("CLEAR_NAME", 1);
                ((k2) LinearSwapTradeBasePresenter.this.getUI()).p0(contractClearDialogConfig.getRulesUrl(), contractClearDialogConfig.getTips());
                return;
            }
            z2.c().b("CLEAR_NAME", 3);
            LinearSwapTradeBasePresenter.this.X3();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            z2.c().b("CLEAR_NAME", 3);
            LinearSwapTradeBasePresenter.this.X3();
        }
    }

    public class k implements f1.m {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseCoreActivity f75117a;

        public k(BaseCoreActivity baseCoreActivity) {
            this.f75117a = baseCoreActivity;
        }

        public int B0() {
            return ((k2) LinearSwapTradeBasePresenter.this.getUI()).B0();
        }

        public void a(ye.d dVar) {
            if (LinearSwapTradeBasePresenter.this.D != null && (LinearSwapTradeBasePresenter.this.D instanceof LinearSwapHoldStopDialogFragment) && LinearSwapTradeBasePresenter.this.D.isVisible() && ((LinearSwapHoldStopDialogFragment) LinearSwapTradeBasePresenter.this.D).Yh() && TextUtils.equals(((LinearSwapHoldStopDialogFragment) LinearSwapTradeBasePresenter.this.D).R0(), dVar.g().getOrderId()) && ((LinearSwapHoldStopDialogFragment) LinearSwapTradeBasePresenter.this.D).Wh() != null && !TextUtils.isEmpty(dVar.g().getLastPrice()) && !dVar.g().getLastPrice().equals(((LinearSwapHoldStopDialogFragment) LinearSwapTradeBasePresenter.this.D).Wh().getLastPrice())) {
                LinearSwapHoldStopDialogFragment linearSwapHoldStopDialogFragment = (LinearSwapHoldStopDialogFragment) LinearSwapTradeBasePresenter.this.D;
                String str = "buy";
                if (str.equalsIgnoreCase(linearSwapHoldStopDialogFragment.Vh())) {
                    str = "sell";
                }
                if (dVar.g().getContractCode().equals(linearSwapHoldStopDialogFragment.Uh()) && dVar.g().getDirection().equals(str) && dn.i.b(linearSwapHoldStopDialogFragment.Xh()).equals(dVar.g().getMarginMode())) {
                    LinearSwapPosition unused = LinearSwapTradeBasePresenter.this.u2(dVar, linearSwapHoldStopDialogFragment.Wh());
                    linearSwapHoldStopDialogFragment.oi();
                }
            }
        }

        public void b(ye.d dVar) {
            LinearSwapHoldStopDialogFragment linearSwapHoldStopDialogFragment = new LinearSwapHoldStopDialogFragment();
            linearSwapHoldStopDialogFragment.ii(LinearSwapTradeBasePresenter.this.u2(dVar, new LinearSwapPosition()), FutureContractInfoController.n().o(dVar.g().getContractCode()));
            int i11 = 2;
            if (2 != dVar.f()) {
                i11 = 1;
            }
            linearSwapHoldStopDialogFragment.ji(i11);
            BaseDialogFragment unused = LinearSwapTradeBasePresenter.this.D = linearSwapHoldStopDialogFragment;
            LinearSwapTradeBasePresenter.this.D.show(this.f75117a.getSupportFragmentManager(), "LinearSwapOrder onCloseStopProfitClick");
            i6.d.c("ACTION-LINEAR-SWAP", "委托item中按钮点击止盈止损");
        }

        public void f(int i11) {
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).f(i11);
        }

        public void g(int i11) {
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).g(i11);
        }

        public void h(int i11) {
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).h(i11);
        }

        public void i(int i11) {
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).i(i11);
        }

        public void u2(int i11) {
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).u2(i11);
        }
    }

    public class k0 extends BaseSubscriber<List<LinearSwapAccountInfo>> {
        public k0() {
        }

        public void onNext(List<LinearSwapAccountInfo> list) {
            bj.l0.v().R(list);
        }
    }

    public class l extends BaseSubscriber<List<LinearSwapAccountInfo>> {
        public l() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            qk.t.b();
        }

        public void onNext(List<LinearSwapAccountInfo> list) {
            qk.t.e(11);
            bj.l0.v().R(list);
            if (list != null) {
                if (!LinearSwapTradeBasePresenter.this.f75047c) {
                    boolean unused = LinearSwapTradeBasePresenter.this.f75047c = true;
                }
                for (LinearSwapAccountInfo next : list) {
                    if (next.getSymbol().equalsIgnoreCase(LinearSwapTradeBasePresenter.this.f75067u)) {
                        if (LinearSwapTradeBasePresenter.this.f75047c && z6.l.c().i(LinearSwapTradeBasePresenter.this.A)) {
                            boolean c11 = ConfigPreferences.c("user_config", "config_isolated_show_no_right" + LinearSwapTradeBasePresenter.this.f75067u + tg.r.x().s(), false);
                            boolean c12 = ConfigPreferences.c("user_config", "CONTRACT_NEW_GUIDE", false);
                            if (!c11 && i6.m.a(next.getMarginBalance()).compareTo(BigDecimal.ZERO) == 0 && c12 && !dn.d.f().l()) {
                                ((k2) LinearSwapTradeBasePresenter.this.getUI()).Eg(LinearSwapTradeBasePresenter.this.f75067u, LinearSwapTradeBasePresenter.this.f75066t.getQuoteCurrency());
                                ConfigPreferences.n("user_config", "config_isolated_show_no_right" + LinearSwapTradeBasePresenter.this.f75067u + tg.r.x().s(), true);
                            }
                        }
                        LinearSwapTradeBasePresenter.this.f75069w.s0(LinearSwapTradeBasePresenter.this.f75067u, next);
                        if (!TextUtils.isEmpty(next.getLeverRate()) && i6.m.a(next.getLeverRate()).compareTo(BigDecimal.ZERO) != 0) {
                            String leverRate = next.getLeverRate();
                            ((k2) LinearSwapTradeBasePresenter.this.getUI()).x0(leverRate);
                            LinearSwapTradeBasePresenter.this.f75072z.K(leverRate);
                        }
                        ((k2) LinearSwapTradeBasePresenter.this.getUI()).Q8(next);
                        LinearSwapTradeBasePresenter.this.f75069w.t0((AccountBalanceInfoV5) null);
                        LinearSwapTradeBasePresenter.this.f75072z.j(false);
                        pk.e.a().d(false, next.getContractCode(), TextUtils.equals(next.getPositionMode(), "single_side"));
                        return;
                    }
                }
            }
        }
    }

    public class l0 extends BaseSubscriber<List<LinearSwapAccountInfo>> {
        public l0() {
        }

        public void onNext(List<LinearSwapAccountInfo> list) {
            bj.l0.v().R(list);
        }
    }

    public class m extends BaseSubscriber<List<LinearSwapCrossAccountInfo>> {
        public m() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            qk.t.b();
        }

        public void onNext(List<LinearSwapCrossAccountInfo> list) {
            qk.t.e(11);
            bj.l0.v().S(list);
            if (list != null && list.size() > 0) {
                if (!LinearSwapTradeBasePresenter.this.f75047c) {
                    boolean unused = LinearSwapTradeBasePresenter.this.f75047c = true;
                }
                LinearSwapCrossAccountInfo linearSwapCrossAccountInfo = null;
                for (LinearSwapCrossAccountInfo next : list) {
                    String marginAccount = next.getMarginAccount();
                    if (LinearSwapTradeBasePresenter.this.f75066t.getQuoteCurrency().equalsIgnoreCase(marginAccount)) {
                        linearSwapCrossAccountInfo = next;
                    }
                    boolean equals = TextUtils.equals(next.getPositionMode(), "single_side");
                    if (LinearSwapTradeBasePresenter.this.D2() == 1) {
                        pk.e.a().d(true, marginAccount, equals);
                    } else {
                        pk.e.a().d(false, LinearSwapTradeBasePresenter.this.f75066t.getContractCode(), equals);
                    }
                    dn.a.d().g(next.getTrailFund());
                }
                if (linearSwapCrossAccountInfo != null) {
                    if (z6.l.c().i(LinearSwapTradeBasePresenter.this.A)) {
                        boolean c11 = ConfigPreferences.c("user_config", "config_cross_show_no_right" + tg.r.x().s(), false);
                        boolean c12 = ConfigPreferences.c("user_config", "CONTRACT_NEW_GUIDE", false);
                        if (!c11 && i6.m.a(linearSwapCrossAccountInfo.getMarginBalance()).compareTo(BigDecimal.ZERO) == 0 && c12 && !dn.d.f().l()) {
                            ((k2) LinearSwapTradeBasePresenter.this.getUI()).Eg(LinearSwapTradeBasePresenter.this.f75067u, LinearSwapTradeBasePresenter.this.f75066t.getQuoteCurrency());
                            ConfigPreferences.n("user_config", "config_cross_show_no_right" + tg.r.x().s(), true);
                        }
                    }
                    List<LinearSwapAccountInfo> arrayList = new ArrayList<>();
                    if ("swap".equals(LinearSwapTradeBasePresenter.this.f75066t.getBusinessType())) {
                        if (linearSwapCrossAccountInfo.getContractDetail() != null) {
                            arrayList = linearSwapCrossAccountInfo.getContractDetail();
                        }
                    } else if ("futures".equals(LinearSwapTradeBasePresenter.this.f75066t.getBusinessType()) && linearSwapCrossAccountInfo.getFuturesContractDetail() != null) {
                        arrayList = linearSwapCrossAccountInfo.getFuturesContractDetail();
                    }
                    for (LinearSwapAccountInfo linearSwapAccountInfo : arrayList) {
                        if (linearSwapAccountInfo.getContractCode().equals(LinearSwapTradeBasePresenter.this.f75068v)) {
                            linearSwapAccountInfo.setMarginBalance(linearSwapCrossAccountInfo.getMarginBalance());
                            linearSwapAccountInfo.setRiskRate(linearSwapCrossAccountInfo.getRiskRate());
                            linearSwapAccountInfo.setTrailFund(linearSwapCrossAccountInfo.getTrailFund());
                            linearSwapAccountInfo.setMarginStatic(linearSwapCrossAccountInfo.getMarginStatic());
                            linearSwapAccountInfo.setMoneyIn(linearSwapCrossAccountInfo.getMoneyIn());
                            linearSwapAccountInfo.setMoneyOut(linearSwapCrossAccountInfo.getMoneyOut());
                            LinearSwapTradeBasePresenter.this.f75069w.s0(LinearSwapTradeBasePresenter.this.f75067u, linearSwapAccountInfo);
                            ((k2) LinearSwapTradeBasePresenter.this.getUI()).Q8(linearSwapAccountInfo);
                            if (!TextUtils.isEmpty(linearSwapAccountInfo.getLeverRate()) && i6.m.a(linearSwapAccountInfo.getLeverRate()).compareTo(BigDecimal.ZERO) != 0) {
                                String leverRate = linearSwapAccountInfo.getLeverRate();
                                ((k2) LinearSwapTradeBasePresenter.this.getUI()).x0(leverRate);
                                LinearSwapTradeBasePresenter.this.f75072z.K(leverRate);
                            }
                            LinearSwapTradeBasePresenter.this.f75069w.t0((AccountBalanceInfoV5) null);
                            LinearSwapTradeBasePresenter.this.f75072z.j(false);
                            return;
                        }
                    }
                }
            }
        }
    }

    public class m0 extends BaseSubscriber<List<LinearSwapCrossAccountInfo>> {
        public m0() {
        }

        public void onNext(List<LinearSwapCrossAccountInfo> list) {
            bj.l0.v().S(list);
        }
    }

    public class n extends BaseSubscriber<List<FuturePriceLimitInfo>> {
        public n() {
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).n2((FuturePriceLimitInfo) null);
        }

        public void onNext(List<FuturePriceLimitInfo> list) {
            if (list == null || list.size() <= 0) {
                ((k2) LinearSwapTradeBasePresenter.this.getUI()).n2((FuturePriceLimitInfo) null);
            } else {
                ((k2) LinearSwapTradeBasePresenter.this.getUI()).n2(list.get(0));
            }
        }
    }

    public class n0 extends EasySubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public boolean f75125b;

        public n0(boolean z11) {
            this.f75125b = z11;
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
            String errCode = aPIStatusErrorException.getErrCode();
            errCode.hashCode();
            if (!errCode.equals("1096")) {
                if (errCode.equals("1501")) {
                    return;
                }
            } else if (this.f75125b) {
                HuobiToastUtil.k(BaseApplication.b(), R.string.n_trail_fund_above_60_toast);
                return;
            }
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
    }

    public class o extends BaseSubscriber<String> {
        public o() {
        }

        /* renamed from: a */
        public void onNext(String str) {
            LinearSwapTradeBasePresenter linearSwapTradeBasePresenter = LinearSwapTradeBasePresenter.this;
            linearSwapTradeBasePresenter.k5(i6.m.m(str, FuturePrecisionUtil.y(linearSwapTradeBasePresenter.f75066t.getContractCode(), LinearSwapTradeBasePresenter.this.f75066t.getContractShortType(), "")));
        }

        public void onAfter() {
            super.onAfter();
        }
    }

    public class p extends BaseSubscriber<ContractHeartBeat> {
        public p() {
        }

        /* renamed from: a */
        public void onNext(ContractHeartBeat contractHeartBeat) {
            super.onNext(contractHeartBeat);
            boolean z11 = contractHeartBeat != null && contractHeartBeat.isLinearSwapSafeguard();
            if (z11) {
                LinearSwapTradeBasePresenter.this.t4();
            } else if (LinearSwapTradeBasePresenter.this.E != z11) {
                LinearSwapTradeBasePresenter.this.R4();
            } else {
                return;
            }
            boolean unused = LinearSwapTradeBasePresenter.this.E = z11;
        }
    }

    public class q extends BaseSubscriber<List<FutureContractInfo>> {
        public q() {
        }

        public void onNext(List<FutureContractInfo> list) {
            Iterator<FutureContractInfo> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                FutureContractInfo next = it2.next();
                if (next.getContractCode().equals(LinearSwapTradeBasePresenter.this.f75066t.getContractCode())) {
                    LinearSwapTradeBasePresenter.this.R3(next);
                    if (next.isShowCover()) {
                        LinearSwapTradeBasePresenter.this.d4(next);
                    } else {
                        ((k2) LinearSwapTradeBasePresenter.this.getUI()).v2(8, next.getContractStatus());
                        if (LinearSwapTradeBasePresenter.this.Q2()) {
                            LinearSwapTradeBasePresenter.this.e4();
                            LinearSwapTradeBasePresenter.this.J4();
                            LinearSwapTradeBasePresenter.this.U4();
                        } else {
                            LinearSwapTradeBasePresenter.this.f4();
                            LinearSwapTradeBasePresenter.this.I4();
                            LinearSwapTradeBasePresenter.this.T4();
                            LinearSwapTradeBasePresenter.this.K4();
                        }
                    }
                }
            }
            if (!list.contains(LinearSwapTradeBasePresenter.this.f75066t)) {
                FutureContractInfo unused = LinearSwapTradeBasePresenter.this.f75066t = list.get(0);
                LinearSwapTradeBasePresenter linearSwapTradeBasePresenter = LinearSwapTradeBasePresenter.this;
                linearSwapTradeBasePresenter.R3(linearSwapTradeBasePresenter.f75066t);
                LinearSwapTradeBasePresenter linearSwapTradeBasePresenter2 = LinearSwapTradeBasePresenter.this;
                String unused2 = linearSwapTradeBasePresenter2.f75067u = linearSwapTradeBasePresenter2.f75066t.getSymbol();
                LinearSwapTradeBasePresenter linearSwapTradeBasePresenter3 = LinearSwapTradeBasePresenter.this;
                String unused3 = linearSwapTradeBasePresenter3.f75068v = linearSwapTradeBasePresenter3.f75066t.getContractCode();
                LinearSwapTradeBasePresenter.this.f75072z.N(LinearSwapTradeBasePresenter.this.f75067u);
                LinearSwapTradeBasePresenter.this.f75072z.J(LinearSwapTradeBasePresenter.this.f75066t);
                ((k2) LinearSwapTradeBasePresenter.this.getUI()).bg(LinearSwapTradeBasePresenter.this.f75066t);
                ((k2) LinearSwapTradeBasePresenter.this.getUI()).v2(8, LinearSwapTradeBasePresenter.this.f75066t.getContractStatus());
                LinearSwapTradeBasePresenter.this.Y3();
                LinearSwapTradeBasePresenter.this.f75072z.H();
            }
            if (LinearSwapTradeBasePresenter.this.f75066t.isNotSupportTrade()) {
                ((k2) LinearSwapTradeBasePresenter.this.getUI()).m1();
            }
        }
    }

    public class r extends BaseSubscriber<Long> {
        public r() {
        }

        public void onNext(Long l11) {
            if (Math.abs(LinearSwapTradeBasePresenter.this.f75066t.getSettlementTime().longValue() - l11.longValue()) > 5000) {
                LinearSwapTradeBasePresenter.this.I4();
                LinearSwapTradeBasePresenter.this.g4();
            }
            long unused = LinearSwapTradeBasePresenter.this.N = l11.longValue();
            if (l11.longValue() <= Period.MIN60_MILLS) {
                int unused2 = LinearSwapTradeBasePresenter.this.I = 1;
            } else {
                int unused3 = LinearSwapTradeBasePresenter.this.I = -1;
            }
            LinearSwapTradeBasePresenter.this.o5();
        }
    }

    public class s extends BaseSubscriber<Long> {
        public s() {
        }

        public void onNext(Long l11) {
            if (Math.abs(LinearSwapTradeBasePresenter.this.f75066t.getFDeliveryTime().longValue() - l11.longValue()) > 5000) {
                LinearSwapTradeBasePresenter.this.J4();
                LinearSwapTradeBasePresenter.this.h4();
            }
            long unused = LinearSwapTradeBasePresenter.this.N = l11.longValue();
            if (l11.longValue() <= Period.MIN60_MILLS) {
                int unused2 = LinearSwapTradeBasePresenter.this.I = 1;
            } else {
                int unused3 = LinearSwapTradeBasePresenter.this.I = -1;
                ((k2) LinearSwapTradeBasePresenter.this.getUI()).J1(l11.longValue());
            }
            LinearSwapTradeBasePresenter.this.h5();
        }
    }

    public class t extends BaseSubscriber<Long> {
        public t() {
        }

        public void onNext(Long l11) {
            if (Math.abs(LinearSwapTradeBasePresenter.this.f75066t.getDeliveryTime() - l11.longValue()) > 5000) {
                LinearSwapTradeBasePresenter.this.T4();
                LinearSwapTradeBasePresenter.this.v4();
            }
            long unused = LinearSwapTradeBasePresenter.this.O = l11.longValue();
            if (l11.longValue() <= 600000) {
                int unused2 = LinearSwapTradeBasePresenter.this.I = 2;
            } else {
                int unused3 = LinearSwapTradeBasePresenter.this.I = -1;
            }
            LinearSwapTradeBasePresenter.this.o5();
        }
    }

    public class u extends BaseSubscriber<Long> {
        public u() {
        }

        public void onNext(Long l11) {
            if (Math.abs(LinearSwapTradeBasePresenter.this.f75066t.getFSettlementTime() - l11.longValue()) > 5000) {
                LinearSwapTradeBasePresenter.this.U4();
                LinearSwapTradeBasePresenter.this.w4();
            }
            long unused = LinearSwapTradeBasePresenter.this.O = l11.longValue();
            if (l11.longValue() <= 600000) {
                int unused2 = LinearSwapTradeBasePresenter.this.I = 2;
                LinearSwapTradeBasePresenter.this.J4();
            } else {
                int unused3 = LinearSwapTradeBasePresenter.this.I = -1;
            }
            LinearSwapTradeBasePresenter.this.h5();
        }
    }

    public class v implements l0.i {
        public v() {
        }

        public void a() {
            LinearSwapTradeBasePresenter.this.l5();
        }

        public void b() {
            LinearSwapTradeBasePresenter.this.f75070x.U0();
        }

        public void c(List<? extends s9.a> list) {
            LinearSwapTradeBasePresenter.this.f75070x.N0(list);
        }

        public void d() {
            LinearSwapTradeBasePresenter.this.s4();
        }

        public void e(List<LinearSwapPosition> list, boolean z11) {
            LinearSwapTradeBasePresenter.this.m5(list, z11);
        }
    }

    public class w extends BaseSubscriber<List<LinearSwapSettlementPriceInfo>> {
        public w() {
        }

        public void onNext(List<LinearSwapSettlementPriceInfo> list) {
            super.onNext(list);
            if (LinearSwapTradeBasePresenter.this.Q2()) {
                LinearSwapTradeBasePresenter.this.o5();
            } else {
                LinearSwapTradeBasePresenter.this.h5();
            }
        }
    }

    public class x extends BaseSubscriber<Boolean> {
        public x() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).Ib(bool.booleanValue(), LinearSwapTradeBasePresenter.this.w2());
        }
    }

    public class y extends BaseSubscriber<List<FutureContractInfo>> {
        public y() {
        }

        public void onNext(List<FutureContractInfo> list) {
            super.onNext(list);
            LinearSwapTradeBasePresenter.this.R3(qk.k.f(list));
            LinearSwapTradeBasePresenter.this.e2();
        }
    }

    public class z extends BaseSubscriber<Integer> {
        public z() {
        }

        /* renamed from: a */
        public void onNext(Integer num) {
            super.onNext(num);
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).s1(LinearSwapTradeBasePresenter.this.f75067u);
            if (num != null) {
                if (num.intValue() == 1) {
                    LinearSwapTradeBasePresenter.this.W3(4);
                } else if (num.intValue() == 2) {
                    LinearSwapTradeBasePresenter.this.W3(5);
                } else if (num.intValue() == 3) {
                    LinearSwapTradeBasePresenter.this.W3(3);
                }
            }
            ((k2) LinearSwapTradeBasePresenter.this.getUI()).E1(LinearSwapTradeBasePresenter.this.H);
        }
    }

    public LinearSwapTradeBasePresenter() {
        MutableLiveData<List<NewBannerBean.BannerAdv>> mutableLiveData = new MutableLiveData<>();
        this.f75045a0 = mutableLiveData;
        this.f75046b0 = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(Boolean.FALSE);
        this.f75048c0 = mutableLiveData2;
        this.f75050d0 = mutableLiveData2;
    }

    public static /* synthetic */ Boolean F3(String str) {
        if (!i6.m.a0(str)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(i6.m.a(str).intValue() > 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R2(List list) {
        ((k2) getUI()).T8(list);
    }

    public static /* synthetic */ FutureUserInfo S2(FutureUserInfo futureUserInfo, UserKycInfoNew userKycInfoNew, UnifyKycInfo unifyKycInfo) {
        return futureUserInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable T2(Long l11) {
        h8.a.a().queryPositionModeWhenUnitDeposit().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new b());
        h8.a.a().D(this.f75068v, FutureContractInfo.MARGIN_CROSS).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new c());
        return h8.a.a().queryAccountBalance().b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable Y2(Long l11) {
        return FutureContractInfoController.n().i(this.A, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean c3(Long l11) {
        if (i8.d.e().c(this.f75066t.getContractCode()) == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean d3(String str) {
        if (!i6.m.a0(str)) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(i6.m.a(str).intValue() > 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable e3(Long l11) {
        return h8.a.a().P(G2(), this.f75066t.getContractCode(), A2(), this.f75066t.getContractType(), "", "").b().map(bn.n.f12838b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable i3(Long l11) {
        return FuturePriceLimitController.g(false, this.f75068v, TtmlNode.COMBINE_ALL, TtmlNode.COMBINE_ALL, this.A);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable o3(Long l11) {
        return h8.a.a().J(this.f75066t.getQuoteCurrency(), TtmlNode.COMBINE_ALL).b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable r3(Long l11) {
        return h8.a.a().J(this.f75066t.getQuoteCurrency(), TtmlNode.COMBINE_ALL).b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List w3(List list, List list2) {
        String str;
        Iterator it2 = list2.iterator();
        LinearSwapCrossAccountInfo linearSwapCrossAccountInfo = null;
        String str2 = null;
        Boolean bool = null;
        while (it2.hasNext()) {
            LinearSwapAccountInfo linearSwapAccountInfo = (LinearSwapAccountInfo) it2.next();
            if (linearSwapAccountInfo.getSymbol().equalsIgnoreCase(this.f75067u) && !TextUtils.isEmpty(linearSwapAccountInfo.getLeverRate()) && i6.m.a(linearSwapAccountInfo.getLeverRate()).compareTo(BigDecimal.ZERO) != 0) {
                str2 = linearSwapAccountInfo.getLeverRate();
            }
            bool = Boolean.valueOf(TextUtils.equals(linearSwapAccountInfo.getPositionMode(), "single_side"));
        }
        if (list != null && list.size() > 0) {
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                LinearSwapCrossAccountInfo linearSwapCrossAccountInfo2 = (LinearSwapCrossAccountInfo) it3.next();
                if (this.f75066t.getQuoteCurrency().equalsIgnoreCase(linearSwapCrossAccountInfo2.getMarginAccount())) {
                    linearSwapCrossAccountInfo = linearSwapCrossAccountInfo2;
                }
                if (bool != null) {
                    if (bool.booleanValue()) {
                        str = "single_side";
                    } else {
                        str = "dual_side";
                    }
                    linearSwapCrossAccountInfo2.setPositionMode(str);
                }
            }
            if (linearSwapCrossAccountInfo != null && str2 != null) {
                List arrayList = new ArrayList();
                if ("swap".equals(this.f75066t.getBusinessType())) {
                    if (linearSwapCrossAccountInfo.getContractDetail() != null) {
                        arrayList = linearSwapCrossAccountInfo.getContractDetail();
                    }
                } else if ("futures".equals(this.f75066t.getBusinessType()) && linearSwapCrossAccountInfo.getFuturesContractDetail() != null) {
                    arrayList = linearSwapCrossAccountInfo.getFuturesContractDetail();
                }
                Iterator it4 = arrayList.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    LinearSwapAccountInfo linearSwapAccountInfo2 = (LinearSwapAccountInfo) it4.next();
                    if (linearSwapAccountInfo2.getContractCode().equals(this.f75068v)) {
                        linearSwapAccountInfo2.setLeverRate(str2);
                        break;
                    }
                }
            }
        }
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable x3(String str, Long l11) {
        return Observable.zip(h8.a.a().J(str, TtmlNode.COMBINE_ALL).b(), h8.a.a().z(this.f75068v, TtmlNode.COMBINE_ALL).b(), new bn.e0(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable z3(Long l11) {
        return LinearSwapSettlementController.c(false, this.f75068v, TtmlNode.COMBINE_ALL, TtmlNode.COMBINE_ALL);
    }

    public int A2() {
        return this.G == 2 ? 1 : 2;
    }

    public final void A4() {
        h8.a.a().getTimeSharingGlobalConfigInfo().b().retry(3).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g());
    }

    public LinearSwapContactConfigInfo B2() {
        return i8.d.e().c(this.f75066t.getContractCode());
    }

    public void B4() {
        this.f75070x.Y0(this.f75068v, this.f75067u, 0, 10, ((k2) getUI()).getPositionType(), ((k2) getUI()).e1(), this.G);
    }

    public String C2() {
        return a7.e.l(getActivity(), this.f75066t.getSymbol(), this.f75066t.getQuoteCurrency());
    }

    public void C4() {
        this.f75070x.Z0(this.f75068v, this.f75067u, 0, 10, ((k2) getUI()).getPositionType(), ((k2) getUI()).e1(), ((k2) getUI()).T0(), this.G);
    }

    public int D2() {
        return this.G;
    }

    public void D4() {
        this.f75070x.a1(this.f75068v, this.f75067u, 1, 0, 10, ((k2) getUI()).getPositionType(), ((k2) getUI()).e1(), ((k2) getUI()).T0(), this.G);
    }

    public final String E2(LinearSwapPosition linearSwapPosition) {
        String lastPrice = linearSwapPosition == null ? null : linearSwapPosition.getLastPrice();
        if (lastPrice == null) {
            return i8.m.b().c(linearSwapPosition.getContractCode());
        }
        return i6.m.a(lastPrice).toPlainString();
    }

    public final void E4() {
        if (tg.r.x().F0()) {
            gl.d.b(false, this.A, this.f75068v).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new i());
        }
    }

    public final Observable<Object> F2(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        return this.f75069w.o0(contractOrderPlace, futureContractInfo).compose(RxJavaHelper.t((u6.g) null));
    }

    public void F4() {
        Subscription subscription = this.f75058l;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public String G2() {
        LinearSwapContactConfigInfo B2 = B2();
        if (B2 != null) {
            return B2.getProductId();
        }
        return this.f75066t.getContractCode();
    }

    public final void G4() {
        Subscriber<List<FutureContractInfo>> subscriber = this.f75054h;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        Subscriber<List<LinearSwapAccountInfo>> subscriber2 = this.f75049d;
        if (subscriber2 != null) {
            subscriber2.unsubscribe();
        }
        Subscriber<List<LinearSwapCrossAccountInfo>> subscriber3 = this.f75051e;
        if (subscriber3 != null) {
            subscriber3.unsubscribe();
        }
        Subscription subscription = this.f75052f;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscriber<String> subscriber4 = this.f75053g;
        if (subscriber4 != null) {
            subscriber4.unsubscribe();
        }
        Subscription subscription2 = this.S;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        N4();
        J4();
        U4();
        H4();
        K4();
        O4();
        Z4();
        V4();
        Y4();
        X4();
        M4();
        I4();
        T4();
        S4();
        P4();
        F4();
        Q4();
        a5(false);
        L4();
        h8.a.a().c(this.W);
        this.I = -1;
    }

    public FutureContractInfo H() {
        return this.f75066t;
    }

    public TradeType H2() {
        return this.A;
    }

    public final void H3(LinearSwapPositionOrderItem linearSwapPositionOrderItem, LinearSwapPosition linearSwapPosition) {
        BigDecimal bigDecimal;
        String str;
        String str2;
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        String m11 = i6.m.m(E2(linearSwapPosition), FuturePrecisionUtil.y(linearSwapPositionOrderItem.d().getContractCode(), linearSwapPositionOrderItem.d().getContractShortType(), linearSwapPositionOrderItem.d().getOptionCode()));
        if (this.f75069w.i() == null) {
            this.P = BigDecimal.ZERO;
        } else {
            this.P = this.f75069w.i();
        }
        if (this.f75069w.j() == null) {
            this.Q = BigDecimal.ZERO;
        } else {
            this.Q = this.f75069w.j();
        }
        if (N2(linearSwapPosition)) {
            bigDecimal = this.P;
        } else {
            bigDecimal = this.Q;
        }
        if (!(bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) == 0)) {
            TradeType tradeType = TradeType.LINEAR_SWAP;
            if (a7.e.E(tradeType)) {
                BigDecimal divide = bigDecimal.multiply(i6.m.a(String.valueOf(100))).divide(i6.m.f68179a, 32, 1);
                if (divide.compareTo(BigDecimal.ONE) >= 0 || divide.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal4 = divide.setScale(FuturePrecisionUtil.B(), 1);
                } else {
                    bigDecimal4 = BigDecimal.ONE;
                }
                str2 = i6.m.m(FutureUnitUtil.d(bigDecimal4.toPlainString(), m11, this.f75066t.getContractFace(), tradeType), FuturePrecisionUtil.s(this.f75066t.getContractCode(), this.f75066t.getContractShortType(), this.f75066t.getOptionCode()));
            } else if (a7.e.G(tradeType)) {
                BigDecimal divide2 = bigDecimal.multiply(i6.m.a(String.valueOf(100))).divide(i6.m.f68179a, 32, 1);
                if (divide2.compareTo(BigDecimal.ONE) >= 0 || divide2.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal3 = divide2.setScale(FuturePrecisionUtil.B(), 1);
                } else {
                    bigDecimal3 = BigDecimal.ONE;
                }
                str2 = i6.m.m(FutureUnitUtil.d(bigDecimal3.toPlainString(), m11, this.f75066t.getContractFace(), tradeType), FuturePrecisionUtil.g(this.f75067u));
            } else {
                BigDecimal divide3 = bigDecimal.multiply(i6.m.a(String.valueOf(100))).divide(i6.m.f68179a, 32, 1);
                if (divide3.compareTo(BigDecimal.ONE) >= 0 || divide3.compareTo(BigDecimal.ZERO) <= 0) {
                    bigDecimal2 = divide3.setScale(FuturePrecisionUtil.B(), 1);
                } else {
                    bigDecimal2 = BigDecimal.ONE;
                }
                str2 = bigDecimal2.toPlainString();
            }
            if (!TextUtils.isEmpty(str2) && i6.m.a(str2).compareTo(BigDecimal.ZERO) != 0) {
                str = "100%(≈ " + str2 + ")";
                e5(linearSwapPositionOrderItem, linearSwapPosition, m11, str, 2, 6);
            }
        }
        str = "100%";
        e5(linearSwapPositionOrderItem, linearSwapPosition, m11, str, 2, 6);
    }

    public final void H4() {
        Subscriber<List<LinearSwapContactConfigInfo>> subscriber = this.F;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void I2() {
        if (tg.r.x().F0()) {
            i6.k.o("ContractKyc", "正向永续刷新用户数据");
            Observable.zip(z6.l.c().d(this.A, false).subscribeOn(Schedulers.io()), KycProxy.l().i(false).subscribeOn(Schedulers.io()), KycProxy.l().n(false).subscribeOn(Schedulers.io()), bn.f0.f12823b).retry(3).onErrorResumeNext(Observable.just(null)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g0());
        }
    }

    public void I3(FutureContractInfo futureContractInfo) {
        this.f75067u = this.f75066t.getSymbol();
        if (!TextUtils.isEmpty(this.f75068v) && !this.f75068v.equals(this.f75066t.getContractCode())) {
            M2(true);
            ((k2) getUI()).v2(8, futureContractInfo.getContractStatus());
            ((k2) getUI()).c1(true);
            ((k2) getUI()).u0(true, false);
        }
        this.f75068v = this.f75066t.getContractCode();
        this.f75072z.N(this.f75067u);
        this.f75072z.J(this.f75066t);
        this.f75072z.K("");
        ((k2) getUI()).s1(this.f75067u);
        ((k2) getUI()).k2(this.f75066t.getQuoteCurrency());
        ((k2) getUI()).c(this.f75072z.p().g());
        ((k2) getUI()).setInputPriceUpdate(false);
        ((k2) getUI()).bg(this.f75066t);
        ((k2) getUI()).j1();
        ((k2) getUI()).Q8((LinearSwapAccountInfo) null);
        ((k2) getUI()).w0(true, true);
        ((k2) getUI()).z0(true);
        ((k2) getUI()).v0();
        FutureContractInfo futureContractInfo2 = this.f75066t;
        if ((futureContractInfo2 != null && futureContractInfo2.isOnlySupportCross()) || SPUtil.j()) {
            U3(1);
            ((k2) getUI()).hc(1);
        } else if (this.G != dn.d.f().h(this.f75067u)) {
            U3(dn.d.f().h(this.f75067u));
            if (this.f75066t.isSupportCross() || this.G != 1) {
                ((k2) getUI()).hc(this.G);
            } else {
                ((k2) getUI()).hc(2);
            }
        } else if (this.f75066t.isSupportCross() || this.G != 1) {
            ((k2) getUI()).hc(this.G);
        } else {
            ((k2) getUI()).hc(2);
        }
        ((k2) getUI()).Q5();
        if (this.G != 2) {
            ((k2) getUI()).P6(this.G);
        } else if (this.f75066t.isSupportCross()) {
            ((k2) getUI()).P6(this.G);
        }
        k5("--");
        L2();
        ((k2) getUI()).y1();
        ((k2) getUI()).n0();
        this.f75070x.M0();
        T4();
        I4();
        this.I = -1;
        ((k2) getUI()).E1(dn.d.f().i(this.f75067u));
        this.f75072z.H();
        Y3();
    }

    public final void I4() {
        Subscriber<Long> subscriber = this.f75060n;
        if (subscriber != null) {
            this.J = false;
            subscriber.unsubscribe();
        }
    }

    public final void J2() {
        BaseDialogFragment baseDialogFragment = this.D;
        if (baseDialogFragment != null && baseDialogFragment.isVisible()) {
            this.D.doDismiss();
        }
        ym.z zVar = this.f75069w;
        if (zVar != null) {
            zVar.a0();
        }
        ((k2) getUI()).q0();
    }

    public void J3() {
        I2();
        Y3();
        ((k2) getUI()).y0(true);
        this.f75047c = false;
        A4();
    }

    public final void J4() {
        Subscriber<Long> subscriber = this.f75061o;
        if (subscriber != null) {
            this.K = false;
            subscriber.unsubscribe();
        }
    }

    public final void K2() {
        FutureContractInfo f11 = qk.k.f(FutureContractInfoController.n().e(this.A));
        if (f11 == null) {
            FutureContractInfoController.n().h(this.A, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new y());
            return;
        }
        R3(f11);
        ((k2) getUI()).bg(this.f75066t);
        e2();
    }

    /* renamed from: K3 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, V v11) {
        super.onUIReady(baseCoreActivity, v11);
        this.U = new ej.e(getActivity(), ((k2) getUI()).Z0());
        this.E = bj.d.w(this.A);
        nk.e eVar = new nk.e(this.A, getActivity(), this.f75066t, (pk.o) getUI(), ((k2) getUI()).X2());
        this.f75072z = eVar;
        eVar.M(this);
        ((k2) getUI()).setContractTradeViewController(this.f75072z);
        this.f75072z.A();
        this.f75069w = (ym.z) this.f75072z.w();
        this.f75070x = (f1) this.f75072z.x();
        this.f75071y = (ym.k) this.f75072z.p();
        k5("--");
        this.f75070x.G0(this.Y);
        this.f75070x.E0(new k(baseCoreActivity));
        ((k2) getUI()).C1().setAdapter(this.f75070x.Y());
        this.f75070x.H0(((k2) getUI()).a1());
        this.f75070x.b(this);
        this.f75070x.I0(this);
        this.f75070x.T0(v11.e1(), ((k2) getUI()).T0());
        M2(false);
        EventBus.d().p(this);
        FutureContractInfo futureContractInfo = this.f75066t;
        if ((futureContractInfo == null || !futureContractInfo.isOnlySupportCross()) && !SPUtil.j()) {
            U3(dn.d.f().h(this.f75067u));
        } else {
            U3(1);
        }
        ((k2) getUI()).hc(this.G);
        if (!TextUtils.isEmpty(this.f75067u)) {
            V3(dn.d.f().i(this.f75067u));
        }
        ((k2) getUI()).E1(this.H);
        rj.b a11 = this.U.a();
        View D2 = a11.D("rechargeEntry.xml", getActivity());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contractType", "linearSwap");
            a11.I("sendContractInfo(" + jSONObject + ")");
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        S3(D2);
        this.V = new v();
    }

    public final void K4() {
        Subscription subscription = this.f75057k;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void L2() {
        ((k2) getUI()).O0("--", ContextCompat.getColor(getActivity(), R.color.baseColorSecondaryText), R.drawable.shape_trade_price_change_default);
    }

    public final void L3() {
        this.S = Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new bn.c(this)).retryWhen(bn.s.f12850b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new a());
    }

    public final void L4() {
        Subscriber<Boolean> subscriber = this.f75065s;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public final void M2(boolean z11) {
        ArrayList arrayList = new ArrayList();
        TopScrollData topScrollData = new TopScrollData();
        topScrollData.l(getActivity().getString(R.string.n_contract_swap_fee_rate));
        topScrollData.m("--");
        arrayList.add(topScrollData);
        ((k2) getUI()).s2(arrayList, true, z11);
    }

    public void M3(HashMap<String, Object> hashMap) {
        h8.a.a().p(hashMap).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
    }

    public void M4() {
        Subscriber subscriber = this.f75056j;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public final boolean N2(LinearSwapPosition linearSwapPosition) {
        return linearSwapPosition == null || !"buy".equalsIgnoreCase(linearSwapPosition.getDirection());
    }

    public void N3() {
        v7.b.a().activityZeroAvailablePosition().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new i0());
    }

    public void N4() {
        this.f75070x.b1();
    }

    public boolean O2() {
        FutureContractInfo futureContractInfo = this.f75066t;
        return futureContractInfo != null && futureContractInfo.isOnlySupportCross();
    }

    public void O3() {
        v7.b.a().requestNewBanner(66, 9, (String) null).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new f0());
    }

    public void O4() {
        this.f75070x.c1();
    }

    public boolean P2() {
        FutureContractInfo futureContractInfo = this.f75066t;
        return futureContractInfo != null && futureContractInfo.isSupportCross();
    }

    public void P3() {
        this.f75072z.K("");
    }

    public void P4() {
        this.f75070x.d1();
    }

    public boolean Q2() {
        FutureContractInfo futureContractInfo = this.f75066t;
        return futureContractInfo == null || futureContractInfo.isLinearSwapSwap();
    }

    public final void Q3() {
        int e11 = SP.e("FutureTradeTogetherViewOrderType", 0);
        if (ContractGlobalStatus.f83684c && (e11 == 3 || e11 == 4)) {
            e11 = 0;
        }
        ContractGlobalStatus.f83684c = false;
        ((k2) getUI()).g1(e11);
    }

    public final void Q4() {
        Subscriber<List<FuturePriceLimitInfo>> subscriber = this.f75059m;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public final void R3(FutureContractInfo futureContractInfo) {
        this.f75066t = futureContractInfo;
        qk.k.j(futureContractInfo);
    }

    public final void R4() {
        i6.d.b("contract stopSafeguard");
        ((k2) getUI()).A0(8);
        if (this.f75066t != null) {
            this.f75072z.H();
            Y3();
            return;
        }
        K2();
    }

    public void S3(View view) {
        this.R = view;
        f1 f1Var = this.f75070x;
        if (f1Var != null) {
            f1Var.F0(view);
        }
    }

    public final void S4() {
        Subscriber<List<LinearSwapSettlementPriceInfo>> subscriber = this.f75064r;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void T3() {
        SP.y("grid_order_key_" + this.f75066t.getContractCode(), true);
    }

    public final void T4() {
        Subscriber<Long> subscriber = this.f75062p;
        if (subscriber != null) {
            this.L = false;
            subscriber.unsubscribe();
        }
    }

    public void U3(int i11) {
        FutureContractInfo futureContractInfo = this.f75066t;
        boolean z11 = true;
        if (futureContractInfo == null || !futureContractInfo.isOnlySupportCross()) {
            this.G = i11;
            this.f75072z.L(i11);
            dn.d.f().r(i11, this.f75067u);
        } else {
            this.G = 1;
            this.f75072z.L(1);
        }
        if (this.G != 1) {
            z11 = false;
        }
        f75044e0 = z11;
    }

    public final void U4() {
        Subscriber<Long> subscriber = this.f75063q;
        if (subscriber != null) {
            this.M = false;
            subscriber.unsubscribe();
        }
    }

    public void V() {
        super.V();
        EventBus.d().r(this);
        this.U.b();
    }

    public void V3(int i11) {
        this.H = i11;
    }

    public void V4() {
        this.f75070x.e1();
    }

    public void W3(int i11) {
        this.H = i11;
        dn.d.f().s(i11, this.f75067u);
    }

    public final void W4() {
        Subscriber<ContractHeartBeat> subscriber = this.f75055i;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public final void X3() {
    }

    public void X4() {
        this.f75070x.f1();
    }

    public void Y3() {
        com.huobi.utils.w.d().f();
        dn.d.f().o(false);
        if (this.f75066t != null) {
            r4();
            Z3();
            E4();
            c4();
            if (Q2()) {
                e4();
                J4();
                U4();
                i4();
            } else {
                f4();
                I4();
                T4();
                K4();
            }
            u4();
            j4();
            s4();
            p4();
            b4();
            m4();
            k4();
            x4();
            l5();
            q4();
            a4();
            j5();
            i5();
            a5(true);
            h8.a.a().d(this.W);
            x2();
            ((k2) getUI()).U0(this.f75066t.getSymbol());
            ContractPriceProtectionHelper.g(TradeType.LINEAR_SWAP, this.f75066t.contractCode);
        }
        if (tg.r.x().F0()) {
            a7.e.K(TradeType.LINEAR_SWAP).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new z());
        }
        this.U.d();
    }

    public void Y4() {
        this.f75070x.g1();
    }

    public void Z(boolean z11) {
        super.Z(z11);
        if (z11) {
            fl.a.b(this.A);
            if (!(Q().getArguments() == null || a7.a.a(this.A) == null)) {
                int intValue = a7.a.a(this.A).intValue();
                a7.a.c(this.A);
                ((k2) getUI()).G1(intValue);
            }
            if (!tg.r.x().F0()) {
                ym.z zVar = this.f75069w;
                if (zVar != null) {
                    zVar.N();
                }
                f1 f1Var = this.f75070x;
                if (f1Var != null) {
                    f1Var.S();
                }
                J2();
            }
            K2();
            z4();
            A4();
            ((k2) getUI()).s1(this.f75067u);
            j5();
            Q3();
        } else {
            W4();
            G4();
            ((k2) getUI()).r0();
            this.f75072z.R();
        }
        if (z11) {
            if (!EventBus.d().i(this)) {
                EventBus.d().p(this);
            }
        } else if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        this.U.c(z11);
    }

    public final void Z3() {
        if (tg.r.x().F0()) {
            LinearSwapAllowLevelController.c(false, this.f75068v, this.G).compose(RxJavaHelper.t((u6.g) getUI())).retry(3).subscribe(new h());
        }
    }

    public void Z4() {
        this.f75070x.h1();
    }

    public void a() {
    }

    public final void a4() {
        if (tg.r.x().F0()) {
            FutureClearDialogConfigController.c(20, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new j0());
        } else {
            X3();
        }
    }

    public final void a5(boolean z11) {
        if (this.f75066t != null) {
            h8.a.a().g(z11, this.f75066t.getContractShortType(), Period.day, this.X);
        }
    }

    public void b() {
        s4();
        l5();
    }

    public final void b4() {
        if (tg.r.x().F0()) {
            H4();
            this.F = h2();
            Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(bn.j.f12830b).retryWhen(bn.d0.f12818b).compose(RxJavaHelper.t((u6.g) getUI())).onErrorReturn(bn.o.f12840b).subscribe(this.F);
        }
    }

    public void b5(boolean z11) {
        ((k2) getUI()).showProgressDialog();
        h8.a.a().Q(z11).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e(z11));
    }

    public void c() {
        this.f75069w.O();
        if (!this.f75070x.X().isEmpty()) {
            for (s9.a next : this.f75070x.X()) {
                if (next instanceof LinearSwapPositionOrderItem) {
                    LinearSwapPositionOrderItem linearSwapPositionOrderItem = (LinearSwapPositionOrderItem) next;
                    LinearSwapPosition e11 = linearSwapPositionOrderItem.e();
                    if (e11.getContractCode().equals(this.f75066t.getContractCode()) && dn.i.b(this.G).equals(e11.getMarginMode())) {
                        ym.z zVar = this.f75069w;
                        zVar.u0(e11.getContractCode() + "_" + e11.getMarginMode() + e11.getDirection(), e11);
                        EventBus.d().k(new ContractPositionEvent(e11));
                    }
                    BaseDialogFragment baseDialogFragment = this.D;
                    if (baseDialogFragment != null && (baseDialogFragment instanceof LinearSwapPositionTradeDialogFragment) && baseDialogFragment.isVisible()) {
                        LinearSwapPositionTradeDialogFragment linearSwapPositionTradeDialogFragment = (LinearSwapPositionTradeDialogFragment) this.D;
                        if (e11.getContractCode().equals(linearSwapPositionTradeDialogFragment.li()) && e11.getDirection().equals(linearSwapPositionTradeDialogFragment.mi()) && dn.i.b(linearSwapPositionTradeDialogFragment.ni()).equals(e11.getMarginMode())) {
                            linearSwapPositionTradeDialogFragment.Li(linearSwapPositionOrderItem);
                        }
                    }
                    BaseDialogFragment baseDialogFragment2 = this.D;
                    if (baseDialogFragment2 != null && (baseDialogFragment2 instanceof LinearSwapHoldStopDialogFragment) && baseDialogFragment2.isVisible()) {
                        LinearSwapHoldStopDialogFragment linearSwapHoldStopDialogFragment = (LinearSwapHoldStopDialogFragment) this.D;
                        if (e11.getContractCode().equals(linearSwapHoldStopDialogFragment.Uh()) && e11.getDirection().equals(linearSwapHoldStopDialogFragment.Vh()) && dn.i.b(linearSwapHoldStopDialogFragment.Xh()).equals(e11.getMarginMode())) {
                            linearSwapHoldStopDialogFragment.pi(e11, linearSwapPositionOrderItem.d());
                        }
                    }
                }
            }
        }
        this.f75072z.j(false);
    }

    public final void c4() {
        Subscriber<List<FutureContractInfo>> subscriber = this.f75054h;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f75054h = j2();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new bn.k0(this)).retryWhen(bn.p.f12843b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75054h);
    }

    public final void c5(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "hold_list");
        gs.g.j("contract_trade", "usdt_contract", str, hashMap);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    public void clearInputEvent(ClearInputEvent clearInputEvent) {
        ((k2) getUI()).c1(true);
        ((k2) getUI()).u0(true, false);
    }

    public final void d4(FutureContractInfo futureContractInfo) {
        ((k2) getUI()).v2(0, futureContractInfo.getContractStatus());
        ((k2) getUI()).A2((List<TopScrollData>) null, false, false);
        I4();
        T4();
        S4();
        this.I = -1;
    }

    public final void d5() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "hold_list");
        hashMap.put("margin_type", gs.g.d());
        gs.g.j("key_backhand", "usdt_contract", "confirm", hashMap);
    }

    public final void e2() {
        I3(this.f75066t);
        I2();
        this.f75072z.z();
    }

    public final void e4() {
        if (this.f75066t.getSettlementTime() == null || this.f75066t.getSettlementTime().longValue() == -1) {
            v4();
            I4();
        } else if (this.f75066t.getDeliveryTime() < this.f75066t.getSettlementTime().longValue()) {
            v4();
            I4();
        } else {
            g4();
            T4();
        }
    }

    public void e5(LinearSwapPositionOrderItem linearSwapPositionOrderItem, LinearSwapPosition linearSwapPosition, String str, String str2, int i11, int i12) {
        int i13 = 1;
        if (i12 != 1) {
            str = E2(linearSwapPosition);
        }
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.N0(linearSwapPosition.getSymbol());
        contractOrderPlace.B0(str);
        contractOrderPlace.d0(str2);
        contractOrderPlace.h0(N2(linearSwapPosition));
        contractOrderPlace.A0(i11);
        contractOrderPlace.X0(i12);
        contractOrderPlace.r0(i6.m.a(linearSwapPosition.getLastPrice()).doubleValue());
        contractOrderPlace.i0(0.0d);
        contractOrderPlace.G0(0.0d);
        contractOrderPlace.g0(4);
        if (!FutureContractInfo.MARGIN_CROSS.endsWith(linearSwapPositionOrderItem.e().getMarginMode())) {
            i13 = 2;
        }
        contractOrderPlace.v0(i13);
        contractOrderPlace.E0(100);
        contractOrderPlace.s0(linearSwapPosition.getLeverRate());
        if (N2(linearSwapPosition)) {
            contractOrderPlace.W0(getString(R.string.contract_trade_buy_flat_empty));
        } else {
            contractOrderPlace.W0(getString(R.string.contract_trade_sell_flat_more));
        }
        contractOrderPlace.x0(getString(R.string.contract_trade_position_close_quick));
        g5(contractOrderPlace, linearSwapPositionOrderItem.d());
        ContractOrderPlace e11 = this.f75069w.e(getActivity(), contractOrderPlace, linearSwapPositionOrderItem.d());
        if (linearSwapPositionOrderItem.d() != null) {
            e11.z0(linearSwapPositionOrderItem.e().getPositionSide());
            f5(e11, linearSwapPositionOrderItem.d());
        }
    }

    public void f2() {
        this.f75070x.T0(((k2) getUI()).e1(), ((k2) getUI()).T0());
    }

    public final void f4() {
        if (this.f75066t.getFDeliveryTime() == null) {
            w4();
            J4();
        } else if (this.f75066t.getFSettlementTime() >= this.f75066t.getFDeliveryTime().longValue()) {
            h4();
            U4();
        } else if (this.f75066t.getFSettlementTime() <= 600000) {
            w4();
            J4();
        } else {
            h4();
            U4();
        }
    }

    public final void f5(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        contractOrderPlace.b1(qk.a.b().j(true, Q2()));
        F2(contractOrderPlace, futureContractInfo).subscribe(new n0(false));
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void findSideModeChange(e.a aVar) {
        ((k2) getUI()).La(aVar.f47724c);
    }

    public void g2(List<CouponReturn> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            for (CouponReturn next : list) {
                arrayList.add(String.valueOf(next.getId()));
                try {
                    int intValue = Integer.valueOf(next.getMeetCondition()).intValue();
                    if (intValue > i11) {
                        i11 = intValue;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            CouponExperienceRequestHelper.getInstance().trailVoucher(arrayList).subscribe(new e0(String.valueOf(i11)));
        }
    }

    public final void g4() {
        if (this.f75066t.getSettlementTime() != null && this.f75066t.getSettlementTime().longValue() != -1 && !this.J) {
            this.J = true;
            this.f75060n = k2();
            Observable.interval(0, 1000, TimeUnit.MILLISECONDS).map(new bn.w(this.f75066t.getSettlementTime().longValue())).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75060n);
        }
    }

    public final void g5(ContractOrderPlace contractOrderPlace, FutureContractInfo futureContractInfo) {
        int v11 = contractOrderPlace.v();
        if (tg.r.x().F0()) {
            TradeType tradeType = TradeType.LINEAR_SWAP;
            if (a7.e.E(tradeType)) {
                if (v11 == 0) {
                    this.f75069w.d(contractOrderPlace, futureContractInfo);
                    this.f75069w.b(contractOrderPlace, futureContractInfo);
                } else {
                    this.f75069w.c(contractOrderPlace, futureContractInfo);
                    this.f75069w.a(contractOrderPlace, futureContractInfo);
                }
            } else if (a7.e.G(tradeType)) {
                if (v11 == 0) {
                    this.f75069w.d(contractOrderPlace, futureContractInfo);
                    this.f75069w.b(contractOrderPlace, futureContractInfo);
                } else {
                    this.f75069w.c(contractOrderPlace, futureContractInfo);
                    this.f75069w.a(contractOrderPlace, futureContractInfo);
                }
            } else if (v11 == 0) {
                this.f75069w.d(contractOrderPlace, futureContractInfo);
            } else {
                this.f75069w.c(contractOrderPlace, futureContractInfo);
            }
        }
        if (this.f75069w.i() == null) {
            this.P = BigDecimal.ZERO;
        } else {
            this.P = this.f75069w.i();
        }
        if (this.f75069w.j() == null) {
            this.Q = BigDecimal.ZERO;
        } else {
            this.Q = this.f75069w.j();
        }
    }

    public final Subscriber<List<LinearSwapContactConfigInfo>> h2() {
        return new a0();
    }

    public final void h4() {
        if (!this.K) {
            this.K = true;
            this.f75061o = l2();
            Observable.interval(0, 1000, TimeUnit.MILLISECONDS).map(new bn.g0(this.f75066t.getFDeliveryTime().longValue())).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75061o);
        }
    }

    public final void h5() {
        String str;
        String str2;
        String str3;
        TopScrollData topScrollData;
        String str4;
        String str5;
        if (this.I == -1) {
            ((k2) getUI()).A2((List<TopScrollData>) null, false, false);
            this.Z = false;
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i11 = this.I;
        if (i11 == 2) {
            TopScrollData topScrollData2 = new TopScrollData();
            long j11 = this.O;
            int i12 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i12 <= 0 || j11 > 600000) {
                topScrollData = topScrollData2;
                if (i12 <= 0) {
                    topScrollData.l(getString(R.string.n_contract_distance_settlement_time_label) + " 00:00:00");
                }
            } else {
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
                topScrollData = topScrollData2;
                topScrollData.l(getString(R.string.n_contract_distance_settlement_time_label) + " " + ("00" + ":" + str4 + ":" + str5));
            }
            arrayList.add(topScrollData);
            LinearSwapSettlementPriceInfo b11 = LinearSwapSettlementController.b(this.f75066t.getContractCode());
            TopScrollData topScrollData3 = new TopScrollData();
            topScrollData3.l(getString(R.string.n_contract_current_predict_settlement_price));
            if (b11 == null || TextUtils.isEmpty(b11.getEstimatedSettlementPrice())) {
                topScrollData3.m("--");
            } else {
                topScrollData3.m(i6.m.m(b11.getEstimatedSettlementPrice(), FuturePrecisionUtil.y(this.f75066t.getContractCode(), this.f75066t.getContractShortType(), this.f75066t.getOptionCode())));
            }
            arrayList.add(topScrollData3);
        } else if (i11 == 1) {
            TopScrollData topScrollData4 = new TopScrollData();
            long j14 = this.N;
            int i13 = (j14 > 0 ? 1 : (j14 == 0 ? 0 : -1));
            if (i13 > 0 && j14 <= Period.MIN60_MILLS) {
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
                topScrollData4.l(getString(R.string.n_contract_distance_delivery_time_label) + " " + (str + ":" + str2 + ":" + str3));
            } else if (i13 <= 0) {
                topScrollData4.l(getString(R.string.n_contract_distance_delivery_time_label) + " 00:00:00");
            }
            arrayList.add(topScrollData4);
            LinearSwapSettlementPriceInfo b12 = LinearSwapSettlementController.b(this.f75066t.getContractCode());
            TopScrollData topScrollData5 = new TopScrollData();
            topScrollData5.l(getString(R.string.contract_predict_delivery_price));
            if (b12 == null || TextUtils.isEmpty(b12.getEstimatedSettlementPrice())) {
                topScrollData5.m("--");
            } else {
                topScrollData5.m(i6.m.m(b12.getEstimatedSettlementPrice(), FuturePrecisionUtil.y(this.f75066t.getContractCode(), this.f75066t.getContractShortType(), this.f75066t.getOptionCode())));
            }
            arrayList.add(topScrollData5);
        }
        ((k2) getUI()).A2(arrayList, !this.Z, false);
        this.Z = true;
    }

    public final Subscriber<List<LinearSwapCrossAccountInfo>> i2() {
        return new m();
    }

    public final void i4() {
        if (!TextUtils.isEmpty(this.f75068v)) {
            Subscription subscription = this.f75057k;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.B = false;
            this.C = null;
            this.f75057k = Observable.interval(0, 5000, TimeUnit.MILLISECONDS).subscribe(new h0());
        }
    }

    public final void i5() {
        if (!tg.r.x().F0() || !i8.d.e().b(this.f75068v, this.G)) {
            ((k2) getUI()).Sa(false);
        } else {
            ((k2) getUI()).Sa(true);
        }
    }

    public final Subscriber<List<FutureContractInfo>> j2() {
        return new q();
    }

    public void j4() {
        L4();
        if (!tg.r.x().F0()) {
            ((k2) getUI()).Ib(false, w2());
            return;
        }
        this.f75065s = m2();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).filter(new bn.l0(this)).flatMap(new bn.b(this)).retryWhen(bn.y.f12856b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75065s);
    }

    public final void j5() {
        if (this.f75066t != null) {
            if (!tg.r.x().F0()) {
                ((k2) getUI()).Ib(false, w2());
                return;
            }
            LinearSwapContactConfigInfo B2 = B2();
            if (B2 != null) {
                h8.a.a().P(B2.getProductId(), this.f75066t.getContractCode(), A2(), this.f75066t.getContractType(), "", "").b().map(bn.m.f12836b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new j());
            }
        }
    }

    public final Subscriber<Long> k2() {
        return new r();
    }

    public final void k4() {
        LinearSwapHiddenInstrumentsController.b(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }

    public void k5(String str) {
        ym.k kVar = this.f75071y;
        kVar.W(getString(R.string.n_contract_mark_price) + " " + str);
    }

    public final Subscriber<Long> l2() {
        return new s();
    }

    public void l4() {
        M4();
        this.f75056j = new BaseSubscriber();
        i8.h.c().d(this.f75068v).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75056j);
    }

    public void l5() {
        o4();
    }

    public final Subscriber<Boolean> m2() {
        return new x();
    }

    public final void m4() {
        if (tg.r.x().F0()) {
            LinearSwapOpenCloseController.c(false, this.f75068v).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new f());
        } else {
            X3();
        }
    }

    public void m5(List<LinearSwapPosition> list, boolean z11) {
        this.f75070x.j1(list, z11);
    }

    public final Subscriber<String> n2() {
        return new o();
    }

    public void n4() {
        this.f75070x.V0(this.f75068v, this.f75067u, 0, 0, 10, ((k2) getUI()).getPositionType(), ((k2) getUI()).e1(), ((k2) getUI()).T0(), this.G);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0090, code lost:
        if (com.hbg.lib.core.util.w.l() != false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00ab, code lost:
        if (com.hbg.lib.core.util.w.l() != false) goto L_0x0093;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n5(com.hbg.lib.network.pro.socket.response.LastKlineResponse r9) {
        /*
            r8 = this;
            com.hbg.lib.network.pro.socket.bean.KlineInfo r0 = r9.getTick()
            if (r0 == 0) goto L_0x0101
            com.hbg.lib.data.future.bean.FutureContractInfo r1 = r8.f75066t
            java.lang.String r1 = r1.getContractShortType()
            java.lang.String r2 = r9.getSymbol()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0018
            goto L_0x0101
        L_0x0018:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "LinearSwapOverviewController market.symbol.kline.1day onSuccess  :"
            r1.append(r2)
            java.lang.String r2 = r9.getSymbol()
            r1.append(r2)
            java.lang.String r2 = " price："
            r1.append(r2)
            double r2 = r0.getClose()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "LinearSwapOverviewController"
            i6.d.e(r2, r1)
            ym.k r1 = r8.f75071y
            java.lang.String r2 = r9.getSymbol()
            double r3 = r0.getClose()
            r1.P(r2, r3)
            h6.a r1 = r8.getUI()
            cn.k2 r1 = (cn.k2) r1
            int r1 = r1.v1()
            if (r1 != 0) goto L_0x0059
            r1 = 1
            goto L_0x005a
        L_0x0059:
            r1 = 0
        L_0x005a:
            bj.l0 r2 = bj.l0.v()
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
            if (r9 <= 0) goto L_0x0095
            com.hbg.lib.common.ui.BaseCoreActivity r9 = r8.getActivity()
            int r1 = com.hbg.lib.core.util.w.h()
            int r9 = androidx.core.content.ContextCompat.getColor(r9, r1)
            boolean r1 = com.hbg.lib.core.util.w.l()
            if (r1 == 0) goto L_0x0093
            goto L_0x00bc
        L_0x0093:
            r5 = r6
            goto L_0x00bc
        L_0x0095:
            int r9 = java.lang.Double.compare(r1, r3)
            if (r9 >= 0) goto L_0x00ae
            com.hbg.lib.common.ui.BaseCoreActivity r9 = r8.getActivity()
            int r1 = com.hbg.lib.core.util.w.d()
            int r9 = androidx.core.content.ContextCompat.getColor(r9, r1)
            boolean r1 = com.hbg.lib.core.util.w.l()
            if (r1 == 0) goto L_0x00bc
            goto L_0x0093
        L_0x00ae:
            com.hbg.lib.common.ui.BaseCoreActivity r9 = r8.getActivity()
            r1 = 2131099916(0x7f06010c, float:1.7812199E38)
            int r9 = androidx.core.content.ContextCompat.getColor(r9, r1)
            r5 = 2131235296(0x7f0811e0, float:1.8086782E38)
        L_0x00bc:
            double r1 = r0.getOpen()
            int r1 = java.lang.Double.compare(r1, r3)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x00e2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = com.hbg.lib.data.symbol.PrecisionUtil.v(r2)
            java.lang.String r1 = i6.m.i(r3, r1)
            r0.append(r1)
            java.lang.String r1 = "%"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x00f8
        L_0x00e2:
            double r3 = r0.getClose()
            double r6 = r0.getOpen()
            double r3 = r3 - r6
            double r0 = r0.getOpen()
            double r3 = r3 / r0
            int r0 = com.hbg.lib.data.symbol.PrecisionUtil.v(r2)
            java.lang.String r0 = i6.m.S(r3, r0)
        L_0x00f8:
            h6.a r1 = r8.getUI()
            cn.k2 r1 = (cn.k2) r1
            r1.O0(r0, r9, r5)
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter.n5(com.hbg.lib.network.pro.socket.response.LastKlineResponse):void");
    }

    public String o0() {
        return this.f75067u;
    }

    public final Subscriber<List<FuturePriceLimitInfo>> o2() {
        return new n();
    }

    public void o4() {
        if (((k2) getUI()).e1() != 0 && ((k2) getUI()).getPositionType() != 1) {
            return;
        }
        if (qk.o0.a()) {
            FutureContractInfo futureContractInfo = this.f75066t;
            if (futureContractInfo != null) {
                this.f75070x.W0(futureContractInfo.getContractCode(), ((k2) getUI()).getPositionType(), ((k2) getUI()).e1());
                return;
            }
            return;
        }
        this.f75070x.W0("", ((k2) getUI()).getPositionType(), ((k2) getUI()).e1());
    }

    public final void o5() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (this.C != null) {
            ArrayList arrayList = new ArrayList();
            TopScrollData topScrollData = new TopScrollData();
            topScrollData.l(DateTimeUtils.A(this.C.getFundingTime()) + " " + getActivity().getString(R.string.n_contract_swap_fee_rate));
            topScrollData.m(i6.m.R(this.C.getFinalFundingRate(), FuturePrecisionUtil.a(), 1, getActivity().getString(R.string.text_default_string)));
            int i11 = this.I;
            if (i11 == 2) {
                arrayList.add(topScrollData);
                TopScrollData topScrollData2 = new TopScrollData();
                long j11 = this.O;
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
                LinearSwapSettlementPriceInfo b11 = LinearSwapSettlementController.b(this.f75066t.getContractCode());
                TopScrollData topScrollData3 = new TopScrollData();
                topScrollData3.l(getString(R.string.n_contract_current_predict_settlement_price));
                if (b11 == null || TextUtils.isEmpty(b11.getEstimatedSettlementPrice())) {
                    topScrollData3.m("--");
                } else {
                    topScrollData3.m(i6.m.m(b11.getEstimatedSettlementPrice(), us.i.m(this.f75067u)));
                }
                arrayList.add(topScrollData3);
            } else if (i11 == 1) {
                TopScrollData topScrollData4 = new TopScrollData();
                long j14 = this.N;
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
                LinearSwapSettlementPriceInfo b12 = LinearSwapSettlementController.b(this.f75066t.getContractCode());
                TopScrollData topScrollData5 = new TopScrollData();
                topScrollData5.l(getString(R.string.contract_predict_delivery_price));
                if (b12 == null || TextUtils.isEmpty(b12.getEstimatedSettlementPrice())) {
                    topScrollData5.m("--");
                } else {
                    topScrollData5.m(i6.m.m(b12.getEstimatedSettlementPrice(), us.i.m(this.f75067u)));
                }
                arrayList.add(topScrollData5);
            } else {
                arrayList.add(topScrollData);
            }
            ((k2) getUI()).s2(arrayList, !this.B, false);
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
        if (aVar.b() == TradeType.LINEAR_SWAP) {
            int a11 = aVar.a();
            k2 k2Var = (k2) getUI();
            boolean z11 = true;
            if (a11 != 1) {
                z11 = false;
            }
            k2Var.m(a11, z11);
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onContractCalmPeriodInfoChange(ContractCalmPeriodInfo contractCalmPeriodInfo) {
        if (getUI() != null) {
            ((k2) getUI()).F1();
        }
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onContractCurrencyChange(FutureChangeEvent futureChangeEvent) {
        if (!futureChangeEvent.getInfo().getContractCode().equals(this.f75066t.getContractCode())) {
            G4();
            this.f75047c = false;
            ((k2) getUI()).V0(false);
            ((k2) getUI()).s0();
            ((k2) getUI()).G1(0);
            Q3();
            ((k2) getUI()).S0();
            this.f75072z.R();
            R3(futureChangeEvent.getInfo());
            I3(futureChangeEvent.getInfo());
            ((k2) getUI()).c1(true);
            ((k2) getUI()).u0(true, false);
        }
    }

    public void onPause() {
        super.onPause();
        G4();
        this.f75072z.R();
        bj.l0.v().Q((l0.i) null);
    }

    public void onResume() {
        super.onResume();
        FutureContractInfo futureContractInfo = this.f75066t;
        if ((futureContractInfo == null || !futureContractInfo.isOnlySupportCross()) && !SPUtil.j()) {
            U3(dn.d.f().h(this.f75067u));
        } else {
            U3(1);
        }
        ((k2) getUI()).hc(this.G);
        if (!TextUtils.isEmpty(this.f75067u)) {
            V3(dn.d.f().i(this.f75067u));
        }
        ((k2) getUI()).E1(this.H);
        bj.l0.v().Q(this.V);
    }

    public final Subscriber<List<LinearSwapAccountInfo>> p2() {
        return new l();
    }

    public final void p4() {
        Subscriber<String> subscriber = this.f75053g;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f75053g = n2();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new bn.f(this.f75066t.getContractCode())).retryWhen(bn.c0.f12816b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75053g);
    }

    public final Subscriber<List<LinearSwapSettlementPriceInfo>> q2() {
        return new w();
    }

    public final void q4() {
        Subscriber<List<FuturePriceLimitInfo>> subscriber = this.f75059m;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (tg.r.x().F0()) {
            this.f75059m = o2();
            Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new bn.m0(this)).retryWhen(bn.x.f12855b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75059m);
        }
    }

    public final Subscriber<Long> r2() {
        return new t();
    }

    public final void r4() {
        FutureProductInfoController.d().i(this.A, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }

    public final Subscriber<Long> s2() {
        return new u();
    }

    public void s4() {
        Subscriber<List<LinearSwapAccountInfo>> subscriber = this.f75049d;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        Subscriber<List<LinearSwapCrossAccountInfo>> subscriber2 = this.f75051e;
        if (subscriber2 != null) {
            subscriber2.unsubscribe();
        }
        Subscription subscription = this.f75052f;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        if (z6.l.c().g(this.A) != null) {
            Subscription subscription2 = this.S;
            if (subscription2 != null) {
                subscription2.unsubscribe();
            }
            if (!tg.r.x().F0() || !z6.l.c().i(this.A)) {
                qk.t.b();
            } else if (SPUtil.j()) {
                L3();
            } else if (this.G == 1) {
                this.f75051e = i2();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                Observable.interval(0, 5000, timeUnit).flatMap(new bn.j0(this)).retryWhen(bn.b0.f12814b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75051e);
                this.f75052f = Observable.interval(0, 5000, timeUnit).flatMap(bn.k.f12832b).retryWhen(bn.v.f12853b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new k0());
            } else if (dn.d.f().m()) {
                String quoteCurrency = this.f75066t.getQuoteCurrency();
                this.f75051e = i2();
                TimeUnit timeUnit2 = TimeUnit.MILLISECONDS;
                Observable.interval(0, 5000, timeUnit2).flatMap(new bn.e(this, quoteCurrency)).retryWhen(bn.a0.f12812b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75051e);
                this.f75052f = Observable.interval(0, 5000, timeUnit2).flatMap(bn.i.f12828b).retryWhen(bn.r.f12849b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new l0());
            } else {
                this.f75049d = p2();
                TimeUnit timeUnit3 = TimeUnit.MILLISECONDS;
                Observable.interval(0, 5000, timeUnit3).flatMap(bn.h.f12826b).retryWhen(bn.t.f12851b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75049d);
                this.f75052f = Observable.interval(0, 5000, timeUnit3).flatMap(new bn.i0(this)).retryWhen(bn.u.f12852b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new m0());
            }
        }
    }

    public final Subscriber<ContractHeartBeat> t2() {
        return new p();
    }

    public final void t4() {
        i6.d.b("contract startSafeguard");
        ((k2) getUI()).A0(0);
        ((k2) getUI()).A2((List<TopScrollData>) null, false, false);
        ((k2) getUI()).Q8((LinearSwapAccountInfo) null);
        k5("--");
        M2(true);
        G4();
        this.f75072z.R();
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        if (!(getUI() == null || getActivity() == null || !((k2) getUI()).isCanBeSeen())) {
            boolean z11 = false;
            if (((k2) getUI()).getPositionType() == 2) {
                ((k2) getUI()).G1(0);
            }
            this.f75069w.N();
            J2();
            BaseCoreActivity activity = getActivity();
            if (activity != null && (activity instanceof HuobiMainActivity)) {
                z11 = true;
            }
            Intent i11 = com.huobi.utils.k0.i(getActivity(), z11);
            if (!z11) {
                i11.addFlags(67108864);
            }
            rn.c.i().d(getActivity(), new JumpTarget(i11, i11));
        }
        if (getUI() != null) {
            ((k2) getUI()).c1(true);
            ((k2) getUI()).u0(true, true);
        }
    }

    public final LinearSwapPosition u2(ye.d dVar, LinearSwapPosition linearSwapPosition) {
        String str;
        linearSwapPosition.setContractCode(dVar.g().getContractCode());
        if ("buy".equalsIgnoreCase(dVar.g().getDirection())) {
            linearSwapPosition.setDirection("sell");
        } else {
            linearSwapPosition.setDirection("buy");
        }
        linearSwapPosition.setMarginMode(dVar.g().getMarginMode());
        boolean z11 = true;
        if (1 != dVar.f()) {
            z11 = false;
        }
        pk.e a11 = pk.e.a();
        if (z11) {
            str = "USDT";
        } else {
            str = dVar.g().getContractCode();
        }
        linearSwapPosition.setPositionMode(a11.b(z11, str) ? "single_side" : "");
        linearSwapPosition.setLastPrice(dVar.g().getLastPrice());
        linearSwapPosition.setAvailable(dVar.g().getAbailablePosition());
        linearSwapPosition.setSymbol(dVar.g().getSymbol());
        linearSwapPosition.setSymbol(dVar.g().getSymbol());
        linearSwapPosition.setLeverRate(String.valueOf(dVar.g().getLeverRate()));
        linearSwapPosition.setCostOpen(dVar.g().getAvgOpen());
        linearSwapPosition.setTpslOrderType(dVar.g().getTpslOrderType());
        linearSwapPosition.setTriggerType(dVar.g().getTriggerType());
        linearSwapPosition.setTriggerPrice(dVar.g().getTriggerPrice());
        linearSwapPosition.setOrderPrice(dVar.g().getOrderPrice());
        linearSwapPosition.setOrderPriceType(dVar.g().getOrderPriceType());
        linearSwapPosition.setContractShortType(dVar.d());
        linearSwapPosition.setOrderId(dVar.g().getOrderId());
        return linearSwapPosition;
    }

    public void u4() {
        S4();
        this.f75064r = q2();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new bn.d(this)).retryWhen(bn.q.f12847b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75064r);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void updateAssetAndOrder(ContractAssetAndOrderUpdateEvent contractAssetAndOrderUpdateEvent) {
        s4();
        x4();
        l5();
    }

    public String v2() {
        return this.f75068v;
    }

    public final void v4() {
        if (this.f75066t.getDeliveryTime() >= 0 && !this.L) {
            this.L = true;
            this.f75062p = r2();
            Observable.interval(0, 1000, TimeUnit.MILLISECONDS).map(new bn.h0(this.f75066t.getDeliveryTime())).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75062p);
        }
    }

    public String w2() {
        return a7.e.d(getActivity(), this.f75066t.getSymbol(), this.f75066t.getQuoteCurrency(), this.G);
    }

    public final void w4() {
        if (!this.M) {
            this.M = true;
            this.f75063q = s2();
            if (this.f75066t.getFSettlementTime() >= 0) {
                Observable.interval(0, 1000, TimeUnit.MILLISECONDS).map(new bn.l(this.f75066t.getFSettlementTime())).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75063q);
            }
        }
    }

    public void x2() {
        if (!tg.r.x().F0() || D2() != 1 || !"USDT".equalsIgnoreCase(this.f75066t.getQuoteCurrency())) {
            ((k2) getUI()).T8((List<CouponReturn>) null);
        } else {
            CouponExperienceRequestHelper.getInstance().getUserCoupons(new bn.a(this));
        }
    }

    public void x4() {
        if (((k2) getUI()).e1() == 0) {
            l4();
            l5();
            O4();
            Z4();
            V4();
            Y4();
            X4();
        } else {
            if (((k2) getUI()).getPositionType() == 0) {
                P4();
            }
            D4();
            y4();
            n4();
            C4();
            B4();
        }
        bj.l0.v().F();
        bj.l0.v().U(false);
        this.f75070x.U0();
    }

    public Boolean y2() {
        return Boolean.valueOf(i8.d.e().b(this.f75068v, this.G));
    }

    public void y4() {
        this.f75070x.X0(this.f75068v, this.f75067u, 0, 10, ((k2) getUI()).getPositionType(), ((k2) getUI()).e1(), ((k2) getUI()).T0(), this.G);
    }

    public Boolean z2() {
        return Boolean.valueOf(SP.l("grid_order_key_" + this.f75066t.getContractCode(), false));
    }

    public final void z4() {
        Subscriber<ContractHeartBeat> subscriber = this.f75055i;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f75055i = t2();
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(bn.g.f12824b).retryWhen(bn.z.f12857b).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(this.f75055i);
    }
}
