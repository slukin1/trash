package com.huobi.linearswap.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import bj.o0;
import bj.p0;
import bj.z2;
import cn.a1;
import cn.a2;
import cn.b1;
import cn.b2;
import cn.c1;
import cn.c2;
import cn.d1;
import cn.d2;
import cn.e1;
import cn.e2;
import cn.f1;
import cn.f2;
import cn.g1;
import cn.g2;
import cn.h1;
import cn.h2;
import cn.i1;
import cn.i2;
import cn.j1;
import cn.j2;
import cn.k1;
import cn.k2;
import cn.l1;
import cn.m1;
import cn.n1;
import cn.o1;
import cn.p1;
import cn.q1;
import cn.r0;
import cn.r1;
import cn.s0;
import cn.s1;
import cn.t0;
import cn.t1;
import cn.u0;
import cn.u1;
import cn.v0;
import cn.v1;
import cn.w0;
import cn.w1;
import cn.x0;
import cn.x1;
import cn.y0;
import cn.y1;
import cn.z0;
import cn.z1;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.ability.CurrencyNoticeAbility;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.constants.ConfigConstant;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.n;
import com.hbg.lib.core.util.w;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.bean.FuturePriceLimitInfo;
import com.hbg.lib.data.future.bean.FutureUserInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.linear.swap.controller.LinearSwapHiddenInstrumentsController;
import com.hbg.lib.network.linear.swap.controller.LinearSwapOpenCloseController;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCrossAccountInfo;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UnifyKycItemState;
import com.hbg.lib.network.newkyc.bean.UnifyKycStepState;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.pro.core.bean.AssetModeBean;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.TopScrollView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.huobi.activity.FutureTradeContainerActivity;
import com.huobi.contract.countdown.ContractTopTipsLayout;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.contract.ui.ContractConfigActivity;
import com.huobi.contract.ui.ContractTradePopDialogFragment;
import com.huobi.coupon.bean.CouponNoticeInfo;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.coupon.handler.CouponExperienceRequestHelper;
import com.huobi.coupon.service.CouponService;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.presenter.FutureTradePresenter;
import com.huobi.feature.ui.ContractSideModeSwitchActivity;
import com.huobi.feature.ui.ContractUpPositionLimitActivity;
import com.huobi.feature.ui.FutureTradeFragment;
import com.huobi.feature.ui.FutureTradeTogetherView;
import com.huobi.feature.ui.dialog.AssetChooseDialog;
import com.huobi.feature.util.ContractCalmPeriodHelper;
import com.huobi.feature.util.KycAndHasTradeDialogUtils;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.kyc.util.KycProxy;
import com.huobi.linearswap.bean.LinearSwapCurrencyInfoDrawerItem;
import com.huobi.linearswap.ordertutorial.ui.OrderTutorialActivity;
import com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.swap.ui.SwapTopTipsLayout;
import com.huobi.trade.ui.TradeHeadView;
import com.huobi.trade.utils.a;
import com.huobi.utils.ReviewManger;
import com.huobi.utils.k0;
import com.huobi.utils.m0;
import com.huobi.view.MyNestedScrollView;
import com.huobi.view.SelectorDialogFragment;
import com.huobi.view.TradeBuySellView;
import com.huobi.view.UnderLineTextView;
import com.huobi.view.bean.SelectorBean;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.huobi.view.seekbar.MultiColorSeekBar;
import com.huobi.webview2.ui.ContractWebActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import dj.k4;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import qk.m;
import qk.n0;
import sn.t;
import tg.r;
import z6.l;

public abstract class LinearSwapTradeBaseFragment<P extends LinearSwapTradeBasePresenter<V>, V extends k2> extends BaseFragment<P, V> implements k2, k4, m0<LinearSwapAccountInfo> {

    /* renamed from: n0  reason: collision with root package name */
    public static boolean f75304n0 = true;
    public RadioButton A;
    public RadioButton B;
    public MagicIndicator C;
    public CommonNavigator D;
    public SmartRefreshHeader E;
    public SmartRefreshLayout F;
    public View G;
    public RecyclerView H;
    public CheckBox I;
    public TextView J;
    public CheckBox K;
    public SwapTopTipsLayout L;
    public View M;
    public ImageView N;
    public TextView O;
    public CommonTextListIndicator P;
    public List<String> Q = new ArrayList();
    public View R;
    public TextView S;
    public View T;
    public FutureTradeTogetherView U;
    public List<String> V = new ArrayList();
    public ContractTradePopDialogFragment W;
    public boolean X;
    public boolean Y = false;
    public boolean Z = false;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f75305a0;

    /* renamed from: b0  reason: collision with root package name */
    public HuobiKeyboardHelper f75306b0;

    /* renamed from: c0  reason: collision with root package name */
    public int f75307c0;

    /* renamed from: d0  reason: collision with root package name */
    public int f75308d0;

    /* renamed from: e0  reason: collision with root package name */
    public nk.e f75309e0;

    /* renamed from: f0  reason: collision with root package name */
    public View f75310f0;

    /* renamed from: g0  reason: collision with root package name */
    public com.cpiz.android.bubbleview.b f75311g0;

    /* renamed from: h0  reason: collision with root package name */
    public boolean f75312h0 = false;

    /* renamed from: i0  reason: collision with root package name */
    public SelectorDialogFragment.OnSelectedListener f75313i0 = new h();

    /* renamed from: j0  reason: collision with root package name */
    public List<CouponReturn> f75314j0;

    /* renamed from: k0  reason: collision with root package name */
    public FrameLayout f75315k0;

    /* renamed from: l  reason: collision with root package name */
    public final String f75316l = "usdt_contract";

    /* renamed from: l0  reason: collision with root package name */
    public rj.b f75317l0;

    /* renamed from: m  reason: collision with root package name */
    public final String f75318m = "contract_trade";

    /* renamed from: m0  reason: collision with root package name */
    public View f75319m0;

    /* renamed from: n  reason: collision with root package name */
    public int f75320n;

    /* renamed from: o  reason: collision with root package name */
    public MyNestedScrollView f75321o;

    /* renamed from: p  reason: collision with root package name */
    public TradeHeadView f75322p;

    /* renamed from: q  reason: collision with root package name */
    public TopScrollView f75323q;

    /* renamed from: r  reason: collision with root package name */
    public UnderLineTextView f75324r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f75325s;

    /* renamed from: t  reason: collision with root package name */
    public View f75326t;

    /* renamed from: u  reason: collision with root package name */
    public View f75327u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f75328v;

    /* renamed from: w  reason: collision with root package name */
    public com.huobi.feature.ui.a f75329w;

    /* renamed from: x  reason: collision with root package name */
    public RadioButton f75330x;

    /* renamed from: y  reason: collision with root package name */
    public RadioButton f75331y;

    /* renamed from: z  reason: collision with root package name */
    public RadioButton f75332z;

    public class a implements View.OnClickListener {

        /* renamed from: com.huobi.linearswap.ui.LinearSwapTradeBaseFragment$a$a  reason: collision with other inner class name */
        public class C0803a extends BaseSubscriber<Object> {
            public C0803a() {
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

            public void onNext(Object obj) {
                super.onNext(obj);
            }
        }

        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            h8.a.a().linearCloseAllPosition().b().compose(RxJavaHelper.t((u6.g) LinearSwapTradeBaseFragment.this.zh())).subscribe(new C0803a());
            HashMap hashMap = new HashMap();
            hashMap.put("margin_type", gs.g.d());
            hashMap.put("module_name", "hold_list");
            gs.g.j("key_close_all", "usdt_contract", "confirm", hashMap);
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            DialogUtils.b0(LinearSwapTradeBaseFragment.this.getActivity(), LinearSwapTradeBaseFragment.this.getString(R.string.n_contract_clear_all_position), LinearSwapTradeBaseFragment.this.getString(R.string.n_contract_clear_all_position_content_linear_swap_tip), "", LinearSwapTradeBaseFragment.this.getString(R.string.n_cancel), LinearSwapTradeBaseFragment.this.getString(R.string.n_confirm), o0.f12469a, new d2(this));
            HashMap hashMap = new HashMap();
            hashMap.put("margin_type", gs.g.d());
            hashMap.put("module_name", "hold_list");
            gs.g.j("contract_trade", "usdt_contract", "key_close_all", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b extends ClickableSpan {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ContractWebActivity.ji(LinearSwapTradeBaseFragment.this.getActivity(), "/strategy/grid_exchange/");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(LinearSwapTradeBaseFragment.this.getResources().getColor(R.color.baseColorMajorTheme100));
        }
    }

    public class c implements a.c {
        public c() {
        }

        public void a() {
            ConfigPreferences.n("user_config", "CONTRACT_NEW_GUIDE", true);
            ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).s4();
            if (LinearSwapTradeBaseFragment.this.getParentFragment() instanceof FutureTradeFragment) {
                ((FutureTradePresenter) ((FutureTradeFragment) LinearSwapTradeBaseFragment.this.getParentFragment()).yh()).p0();
            }
        }

        public boolean b() {
            return LinearSwapTradeBaseFragment.this.Ni();
        }

        public void onFinish() {
            ConfigPreferences.n("user_config", "CONTRACT_NEW_GUIDE", true);
            ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).s4();
            if (LinearSwapTradeBaseFragment.this.getParentFragment() instanceof FutureTradeFragment) {
                ((FutureTradePresenter) ((FutureTradeFragment) LinearSwapTradeBaseFragment.this.getParentFragment()).yh()).p0();
            }
        }

        public void onShow() {
            LinearSwapTradeBaseFragment.this.f75321o.scrollTo(0, 0);
        }
    }

    public class d implements ContractTopTipsLayout.a {
        public d() {
        }

        public void a(boolean z11) {
        }

        public void b() {
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            LinearSwapTradeBaseFragment.this.Qj();
            gs.g.j("contract_trade", "usdt_contract", "transfer", (HashMap) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class f implements TradeHeadView.b {

        public class a implements BaseDialogFragment.b {
            public a() {
            }

            public void onDismiss() {
                ContractTradePopDialogFragment unused = LinearSwapTradeBaseFragment.this.W = null;
            }
        }

        public class b extends EasySubscriber<Object> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f75341b;

            public class a extends EasySubscriber<Object> {
                public a() {
                }

                public void onNext(Object obj) {
                    super.onNext(obj);
                    HuobiToastUtil.v(LinearSwapTradeBaseFragment.this.getString(R.string.market_delete_collection_success));
                }
            }

            public b(String str) {
                this.f75341b = str;
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                boolean z11;
                if (aPIStatusErrorException == null || !"11302".equals(aPIStatusErrorException.getErrCode())) {
                    z11 = false;
                } else {
                    z11 = true;
                    t.l(this.f75341b, LinearSwapTradeBaseFragment.this.getContext(), "PRO").compose(RxJavaHelper.t((u6.g) LinearSwapTradeBaseFragment.this.zh())).subscribe(new a());
                }
                if (!z11) {
                    super.onFailed(aPIStatusErrorException);
                }
            }

            public void onNext(Object obj) {
                super.onNext(obj);
                HuobiToastUtil.v(LinearSwapTradeBaseFragment.this.getString(R.string.market_delete_collection_success));
            }
        }

        public f() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(Object obj) {
            HuobiToastUtil.v(LinearSwapTradeBaseFragment.this.getString(R.string.market_add_collection_success));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(boolean z11) {
            ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).b5(z11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(aj.b bVar) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            if (LinearSwapTradeBaseFragment.this.W != null) {
                LinearSwapTradeBaseFragment.this.W.dismiss();
            }
            String str7 = "usd";
            String str8 = "usdt";
            boolean z11 = false;
            switch (bVar.e()) {
                case 0:
                    LinearSwapTradeBaseFragment.this.Qj();
                    is.a.j("4673", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
                    str = "guarantee_assets_transfer";
                    break;
                case 1:
                    FragmentActivity activity = LinearSwapTradeBaseFragment.this.getActivity();
                    if (activity != null && (activity instanceof HuobiMainActivity)) {
                        z11 = true;
                    }
                    Intent i11 = k0.i(LinearSwapTradeBaseFragment.this.getActivity(), z11);
                    if (!z11) {
                        i11.addFlags(67108864);
                    }
                    if (!rn.c.i().d(LinearSwapTradeBaseFragment.this.getActivity(), new JumpTarget(i11, i11))) {
                        l c11 = l.c();
                        TradeType tradeType = TradeType.LINEAR_SWAP;
                        if (c11.i(tradeType)) {
                            if (!hh.f.h().l()) {
                                Intent i12 = k0.i(LinearSwapTradeBaseFragment.this.getActivity(), z11);
                                Bundle bundle = new Bundle();
                                bundle.putString("total_balance_type", "total_balance_type_contract");
                                i12.putExtras(bundle);
                                LinearSwapTradeBaseFragment.this.startActivity(i12);
                                break;
                            } else {
                                zn.a.d().k(LinearSwapTradeBaseFragment.this.getActivity(), "total_balance_type_contract");
                                break;
                            }
                        } else {
                            m.c(LinearSwapTradeBaseFragment.this.getActivity(), tradeType);
                            break;
                        }
                    } else {
                        return;
                    }
                case 2:
                    ContractConfigActivity.Qh(LinearSwapTradeBaseFragment.this.getActivity(), false, "pro.huobi.linearswap", ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H2().toString());
                    is.a.j("4674", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
                    str = "contracts_set";
                    break;
                case 3:
                    String o02 = ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).o0();
                    if (a7.e.E(((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H2())) {
                        str8 = "symbol";
                    } else if (!a7.e.G(((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H2())) {
                        str8 = "sheet";
                    }
                    if ("cny".equals(LegalCurrencyConfigUtil.y())) {
                        str7 = "cny";
                    }
                    ContractWebActivity.Qh(LinearSwapTradeBaseFragment.this.getActivity(), o02, str8, str7, 4);
                    is.a.j("4675", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
                    str = "calculator";
                    break;
                case 4:
                    ContractWebActivity.di(LinearSwapTradeBaseFragment.this.getActivity(), 4);
                    is.a.j("4676", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
                    str = "rate";
                    break;
                case 6:
                    ContractWebActivity.Oh(LinearSwapTradeBaseFragment.this.getActivity(), 4);
                    is.a.j("4679", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
                    str = "about_contracts";
                    break;
                case 8:
                    String o03 = ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).o0();
                    if (a7.e.E(((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H2())) {
                        str2 = "symbol";
                    } else {
                        str2 = a7.e.G(((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H2()) ? str8 : "sheet";
                    }
                    if ("cny".equals(LegalCurrencyConfigUtil.y())) {
                        str3 = "cny";
                    } else {
                        str3 = str7;
                    }
                    if (((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H() != null) {
                        ContractWebActivity.Xh(LinearSwapTradeBaseFragment.this.getActivity(), o03, str2, str3, ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H().getContractCode(), 4);
                        break;
                    }
                    break;
                case 9:
                    String o04 = ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).o0();
                    if (a7.e.E(((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H2())) {
                        str4 = "symbol";
                    } else {
                        str4 = a7.e.G(((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H2()) ? str8 : "sheet";
                    }
                    if ("cny".equals(LegalCurrencyConfigUtil.y())) {
                        str5 = "cny";
                    } else {
                        str5 = str7;
                    }
                    if (((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H() != null) {
                        ContractWebActivity.Vh(LinearSwapTradeBaseFragment.this.getActivity(), o04, str4, str5, ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H().getContractCode(), ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H().getContractShortType(), 4);
                    }
                    str = "market_information";
                    break;
                case 10:
                    LinearSwapTradeBaseFragment.this.N0();
                    is.a.j("4677", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
                    str = "trade_limit";
                    break;
                case 11:
                    if (((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H() != null) {
                        String contractShortType = ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H().getContractShortType();
                        HashMap hashMap = new HashMap();
                        if (t.w(contractShortType)) {
                            t.l(contractShortType, LinearSwapTradeBaseFragment.this.getContext(), "LINEAR_SWAP").compose(RxJavaHelper.t((u6.g) LinearSwapTradeBaseFragment.this.zh())).subscribe(new b(contractShortType));
                            hashMap.put("type", "删除");
                        } else {
                            t.i(contractShortType, LinearSwapTradeBaseFragment.this.getContext(), "LINEAR_SWAP").compose(RxJavaHelper.t((u6.g) LinearSwapTradeBaseFragment.this.zh())).subscribe(EasySubscriber.create(new g2(this)));
                            hashMap.put("type", "添加");
                        }
                        is.a.j("4680", hashMap, is.a.f(TradeType.LINEAR_SWAP));
                    }
                    str = "add_optional";
                    break;
                case 12:
                    ContractWebActivity.gi(LinearSwapTradeBaseFragment.this.getActivity(), 4);
                    str = "sub_account_management";
                    break;
                case 14:
                    ContractWebActivity.ki(LinearSwapTradeBaseFragment.this.getActivity(), 4);
                    str = "help_center";
                    break;
                case 15:
                    rn.c.i().d(LinearSwapTradeBaseFragment.this.getActivity(), new JumpTarget(new Intent(LinearSwapTradeBaseFragment.this.getActivity(), OrderTutorialActivity.class), (Intent) null));
                    str = "order_navigation";
                    break;
                case 16:
                    LinearSwapTradeBaseFragment.this.Nb(true);
                    gs.g.i("App_more_menu_pop_new_guide_click", (HashMap) null);
                    str = "new_guide";
                    break;
                case 17:
                    zn.a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/Contract/CopyTrading?index=0")).c();
                    break;
                case 18:
                    ContractCalmPeriodHelper.e(LinearSwapTradeBaseFragment.this.getActivity());
                    break;
                case 19:
                    if (((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).D2() == 1) {
                        z11 = true;
                    }
                    FragmentActivity activity2 = LinearSwapTradeBaseFragment.this.getActivity();
                    if (z11) {
                        str6 = "USDT";
                    } else {
                        str6 = ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).v2();
                    }
                    ContractSideModeSwitchActivity.fg(activity2, z11, str6);
                    gs.g.j("usdt_contract", (String) null, "single_double", (HashMap) null);
                    break;
                case 20:
                    rn.c.i().d(LinearSwapTradeBaseFragment.this.getActivity(), new JumpTarget(new Intent(LinearSwapTradeBaseFragment.this.getActivity(), ContractUpPositionLimitActivity.class), (Intent) null));
                    break;
                case 21:
                    ConfigPreferences.n("user_config", "KEY_DEPOSIT_DOT", false);
                    AssetChooseDialog assetChooseDialog = new AssetChooseDialog();
                    assetChooseDialog.uh(new f2(this));
                    assetChooseDialog.show(LinearSwapTradeBaseFragment.this.getChildFragmentManager(), "AssetChooseDialog");
                    break;
                case 22:
                    BaseModuleConfig.a().l0("/contract/activityZero", true);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("business_category", "usdt_0_yuan_buy");
                    hashMap2.put("button_name", "usdt_0_yuan");
                    gs.g.i("appclick_contracts", hashMap2);
                    break;
            }
            str = "";
            if (!TextUtils.isEmpty(str)) {
                gs.g.j("contract_trade", "usdt_contract", str, (HashMap) null);
            }
        }

        public void D(View view) {
            boolean z11 = false;
            if (LinearSwapTradeBaseFragment.this.W == null) {
                ContractTradePopDialogFragment unused = LinearSwapTradeBaseFragment.this.W = new ContractTradePopDialogFragment();
                LinearSwapTradeBaseFragment.this.W.xh(22, Boolean.TRUE.equals(((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).f75050d0.getValue()));
                LinearSwapTradeBaseFragment.this.W.setTradeType(TradeType.LINEAR_SWAP);
                LinearSwapTradeBaseFragment.this.W.yh(SP.l("union_permission_status", false));
                if (((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H() != null) {
                    LinearSwapTradeBaseFragment.this.W.vh(((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H().getContractCode());
                }
                LinearSwapTradeBaseFragment.this.W.wh(((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).D2());
                LinearSwapTradeBaseFragment.this.W.setDialogDismissListener(new a());
                LinearSwapTradeBaseFragment.this.W.uh(new e2(this));
            }
            if (((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H() != null) {
                z11 = t.w(((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H().getContractShortType());
            }
            ConfigPreferences.n("user_config", "BUBBLE_ASSET_FEATURE_KEY", true);
            LinearSwapTradeBaseFragment.this.f75322p.setRightPopDotVisibility(8);
            if (LinearSwapTradeBaseFragment.this.f75311g0 != null) {
                LinearSwapTradeBaseFragment.this.f75311g0.dismiss();
            }
            LinearSwapTradeBaseFragment.this.W.zh(LinearSwapTradeBaseFragment.this.getActivity().getSupportFragmentManager(), "popupwindow", z11);
            gs.g.j("contract_trade", "usdt_contract", "menu", (HashMap) null);
        }

        public void Q(View view) {
            if (((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H() != null) {
                sn.f.G(LinearSwapTradeBaseFragment.this.getContext(), ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H());
            } else {
                HuobiToastUtil.k(bh.j.c(), R.string.string_network_disconnect);
            }
            gs.g.j("contract_trade", "usdt_contract", "Kline", (HashMap) null);
        }

        public void R(View view) {
        }

        public void a0(View view) {
        }

        public void e(View view) {
        }

        public void g0(View view, String str) {
            ContractWebActivity.ji(LinearSwapTradeBaseFragment.this.getActivity(), "/strategy/grid_exchange/");
            gs.g.j("contract_trade", "usdt_contract", "grid_trading", (HashMap) null);
        }

        public void s(View view) {
            LinearSwapCurrencyInfoDrawerItem linearSwapCurrencyInfoDrawerItem = new LinearSwapCurrencyInfoDrawerItem();
            linearSwapCurrencyInfoDrawerItem.l(((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).H());
            if (LinearSwapTradeBaseFragment.this.getActivity() != null && (LinearSwapTradeBaseFragment.this.getActivity() instanceof HuobiMainActivity)) {
                HuobiMainActivity huobiMainActivity = (HuobiMainActivity) LinearSwapTradeBaseFragment.this.getActivity();
                com.huobi.main.helper.l.c().g(TradeType.LINEAR_SWAP, linearSwapCurrencyInfoDrawerItem);
            } else if (LinearSwapTradeBaseFragment.this.getActivity() != null && (LinearSwapTradeBaseFragment.this.getActivity() instanceof FutureTradeContainerActivity)) {
                ((FutureTradeContainerActivity) LinearSwapTradeBaseFragment.this.getActivity()).fg(TradeType.LINEAR_SWAP, linearSwapCurrencyInfoDrawerItem);
            }
            is.a.j("4664", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
            HashMap hashMap = new HashMap();
            hashMap.put("margin_type", gs.g.d());
            gs.g.j("contract_trade", "usdt_contract", "switchover_coin_pair", hashMap);
        }
    }

    public class g implements ny.d {
        public g() {
        }

        public void P8(ky.j jVar) {
        }

        public void bf(ky.j jVar) {
            ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).J3();
        }
    }

    public class h implements SelectorDialogFragment.OnSelectedListener {
        public h() {
        }

        public void onDismiss() {
        }

        public void onSelected(SelectorBean selectorBean) {
            if (selectorBean.getObj() instanceof Integer) {
                LinearSwapTradeBaseFragment.this.hc(((Integer) selectorBean.getObj()).intValue());
            }
        }
    }

    public class i extends CommonNavigatorAdapter {
        public i() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (i11 == LinearSwapTradeBaseFragment.this.f75320n) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            LinearSwapTradeBaseFragment linearSwapTradeBaseFragment = LinearSwapTradeBaseFragment.this;
            linearSwapTradeBaseFragment.Ki(linearSwapTradeBaseFragment.C, i11);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            if (LinearSwapTradeBaseFragment.this.V == null) {
                return 0;
            }
            return LinearSwapTradeBaseFragment.this.V.size();
        }

        public q10.b getIndicator(Context context) {
            return null;
        }

        public q10.c getTitleView(Context context, int i11) {
            TradeBuySellView tradeBuySellView = new TradeBuySellView(context);
            tradeBuySellView.setTextSize(1, 14.0f);
            tradeBuySellView.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            tradeBuySellView.setText((CharSequence) LinearSwapTradeBaseFragment.this.V.get(i11));
            tradeBuySellView.setNormalColor(ContextCompat.getColor(context, R.color.global_secondary_text_color));
            tradeBuySellView.setSelectedColor(ContextCompat.getColor(context, R.color.baseTextColor));
            if (i11 == 0) {
                if (w.l()) {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg);
                    tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_green_bg);
                } else {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg);
                    tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_red_bg);
                }
            } else if (w.l()) {
                tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg_right);
                tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_red_bg_right);
            } else {
                tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg_right);
                tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_green_bg_right);
            }
            tradeBuySellView.setOnClickListener(new h2(this, i11));
            return tradeBuySellView;
        }
    }

    public class j extends CommonNavigatorAdapter {
        public j() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (i11 == LinearSwapTradeBaseFragment.this.e1()) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } else if (i11 == 2) {
                zn.a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/trade/contractGrid?source=app_bots_futures_order")).c();
                gs.g.i("tradingbot_click_futures_order", (HashMap) null);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } else {
                LinearSwapTradeBaseFragment.this.P.c(i11);
                LinearSwapTradeBaseFragment.this.P.b(i11, 0.0f, 0);
                tc.a.d(TradeType.LINEAR_SWAP, i11);
                int unused = LinearSwapTradeBaseFragment.this.f75307c0 = i11;
                LinearSwapTradeBaseFragment.this.Wj();
                LinearSwapTradeBaseFragment.this.Tj();
                LinearSwapTradeBaseFragment.this.Uj();
                ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).f2();
                ((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).x4();
                HashMap hashMap = new HashMap();
                if (i11 == 0) {
                    hashMap.put("module_name", "hold_list");
                } else {
                    hashMap.put("module_name", "entrust_list");
                }
                hashMap.put("margin_type", gs.g.d());
                gs.g.a("contract_trade", "usdt_contract", hashMap);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public int getCount() {
            if (LinearSwapTradeBaseFragment.this.Q == null) {
                return 0;
            }
            return LinearSwapTradeBaseFragment.this.Q.size();
        }

        public q10.b getIndicator(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setColors(Integer.valueOf(ContextCompat.getColor(context, R.color.baseColorMajorTheme100)));
            linePagerIndicator.setMode(2);
            linePagerIndicator.setRoundRadius((float) PixelUtils.a(1.0f));
            linePagerIndicator.setLineWidth((float) PixelUtils.a(20.0f));
            linePagerIndicator.setLineHeight((float) PixelUtils.a(2.0f));
            return linePagerIndicator;
        }

        public q10.c getTitleView(Context context, int i11) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setText((CharSequence) LinearSwapTradeBaseFragment.this.Q.get(i11));
            colorTransitionPagerTitleView.setTextSize(1, 14.0f);
            colorTransitionPagerTitleView.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            colorTransitionPagerTitleView.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
            colorTransitionPagerTitleView.setNormalColor(ContextCompat.getColor(context, R.color.baseColorSecondaryTextNew));
            colorTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.baseColorPrimaryText));
            colorTransitionPagerTitleView.setOnClickListener(new i2(this, i11));
            return colorTransitionPagerTitleView;
        }
    }

    public class k extends EasySubscriber<CouponNoticeInfo> {
        public k() {
        }

        public static /* synthetic */ void b(HBDialogFragment hBDialogFragment) {
            HashMap hashMap = new HashMap();
            hashMap.put("business_category", "contract_trade");
            hashMap.put("button_name", "get_now_dialog");
            gs.g.i("appclick_contracts", hashMap);
            hBDialogFragment.dismiss();
        }

        /* renamed from: c */
        public void onNext(CouponNoticeInfo couponNoticeInfo) {
            if (couponNoticeInfo.isGridFund()) {
                LinearSwapTradeBaseFragment.this.Mi(couponNoticeInfo.getValidDate());
            } else if (((LinearSwapTradeBasePresenter) LinearSwapTradeBaseFragment.this.yh()).D2() == 1) {
                if (couponNoticeInfo.isCoupon()) {
                    LinearSwapTradeBaseFragment.this.Li(couponNoticeInfo.getValidDate());
                } else if (couponNoticeInfo.isTrailFund()) {
                    DialogUtils.b0(LinearSwapTradeBaseFragment.this.getActivity(), LinearSwapTradeBaseFragment.this.getResources().getString(R.string.n_otc_use_tip), LinearSwapTradeBaseFragment.this.getResources().getString(R.string.n_contract_unused_experience_balance), (String) null, LinearSwapTradeBaseFragment.this.getResources().getString(R.string.n_cancel), LinearSwapTradeBaseFragment.this.getResources().getString(R.string.n_index_immediate_transaction), o0.f12469a, j2.f13159a);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bj(HBDialogFragment hBDialogFragment) {
        Pi();
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Cj(HBDialogFragment hBDialogFragment) {
        this.f75305a0 = false;
        hBDialogFragment.sh();
        FutureContractInfo l11 = FutureContractInfoController.n().l(((LinearSwapTradeBasePresenter) yh()).H2());
        if (LinearSwapHiddenInstrumentsController.c() || l11 == null) {
            getActivity().startActivity(k0.l(getActivity()));
            return;
        }
        Kj(getActivity(), l11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Dj() {
        Nb(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ej(Object obj) {
        if (obj == null ? false : ((Boolean) obj).booleanValue()) {
            if (this.f75319m0 == null) {
                View E2 = this.f75317l0.E("currency_notice.xml", getActivity(), false, (JSONObject) null);
                this.f75319m0 = E2;
                this.f75315k0.addView(E2);
            }
            this.f75315k0.setVisibility(0);
            return;
        }
        this.f75315k0.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void Ki(MagicIndicator magicIndicator, int i11) {
        this.f75306b0.hideKeyboard();
        boolean z11 = false;
        if (i11 != 2 || r.x().F0()) {
            Oi(i11);
            w0(true, false);
            int i12 = this.f75320n;
            if (i12 == 0) {
                this.f75329w.L0();
            } else if (i12 == 1) {
                this.f75329w.U0();
            }
            magicIndicator.c(i11);
            magicIndicator.b(i11, 0.0f, 0);
            return;
        }
        this.X = true;
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof HuobiMainActivity)) {
            z11 = true;
        }
        Intent i13 = k0.i(getActivity(), z11);
        if (!z11) {
            i13.addFlags(67108864);
        }
        rn.c.i().d(getActivity(), new JumpTarget(i13, i13));
    }

    public static void Kj(Context context, FutureContractInfo futureContractInfo) {
        Lj(context, futureContractInfo, -1);
    }

    public static void Lj(Context context, FutureContractInfo futureContractInfo, int i11) {
        Intent i12 = k0.i(context, false);
        if (!(i11 == -1 || futureContractInfo == null || futureContractInfo.isOnlySupportCross())) {
            dn.d.f().r(i11, futureContractInfo.getSymbol());
        }
        if (futureContractInfo != null) {
            qk.k.j(futureContractInfo);
        }
        n0.b(0);
        context.startActivity(i12);
    }

    public static void Mj(Context context, FutureContractInfo futureContractInfo, int i11, int i12) {
        Intent i13 = k0.i(context, false);
        a7.a.b(TradeType.LINEAR_SWAP, i11);
        if (!(i12 == -1 || futureContractInfo == null)) {
            dn.d.f().r(i12, futureContractInfo.getSymbol());
        }
        if (futureContractInfo != null) {
            qk.k.j(futureContractInfo);
        }
        n0.b(0);
        context.startActivity(i13);
    }

    public static void Nj(Context context, FutureContractInfo futureContractInfo, int i11, Bundle bundle) {
        Intent i12 = k0.i(context, false);
        if (!(i11 == -1 || futureContractInfo == null || futureContractInfo.isOnlySupportCross())) {
            dn.d.f().r(i11, futureContractInfo.getSymbol());
        }
        if (futureContractInfo != null) {
            qk.k.j(futureContractInfo);
        }
        n0.b(0);
        i12.putExtras(bundle);
        context.startActivity(i12);
    }

    private void Oi(int i11) {
        this.f75320n = i11;
        this.f75329w.O0(i11);
        int i12 = this.f75320n;
        if (i12 == 2) {
            this.f75329w.setViewVisibility(8);
            this.G.setVisibility(8);
            ((k2) zh()).z0(true);
            ((LinearSwapTradeBasePresenter) yh()).l5();
            ((LinearSwapTradeBasePresenter) yh()).l4();
            ((LinearSwapTradeBasePresenter) yh()).O4();
            ((LinearSwapTradeBasePresenter) yh()).Z4();
            ((LinearSwapTradeBasePresenter) yh()).V4();
            ((LinearSwapTradeBasePresenter) yh()).Y4();
            ((LinearSwapTradeBasePresenter) yh()).X4();
        } else if (i12 == 0) {
            this.f75329w.setViewVisibility(0);
            this.G.setVisibility(0);
            if (!LinearSwapOpenCloseController.b(((LinearSwapTradeBasePresenter) yh()).v2())) {
                ((k2) zh()).z0(false);
            }
            ((LinearSwapTradeBasePresenter) yh()).M4();
            ((LinearSwapTradeBasePresenter) yh()).P4();
            ((LinearSwapTradeBasePresenter) yh()).x4();
        } else {
            this.f75329w.setViewVisibility(0);
            this.G.setVisibility(0);
            ((k2) zh()).z0(true);
            ((LinearSwapTradeBasePresenter) yh()).M4();
            ((LinearSwapTradeBasePresenter) yh()).l5();
            ((LinearSwapTradeBasePresenter) yh()).x4();
        }
        this.f75329w.Q0();
    }

    public static void Oj(Context context, FutureContractInfo futureContractInfo, int i11, boolean z11) {
        Mj(context, futureContractInfo, i11, -1);
    }

    private void Pi() {
        if (((LinearSwapTradeBasePresenter) yh()).D2() != 2 || dn.d.f().m()) {
            if (((LinearSwapTradeBasePresenter) yh()).H().getQuoteCurrency().equalsIgnoreCase("husd")) {
                UnifyTransferActivity.Th(getActivity(), "husd", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP);
            } else {
                UnifyTransferActivity.Th(getActivity(), "usdt", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP);
            }
        } else if (((LinearSwapTradeBasePresenter) yh()).H().getQuoteCurrency().equalsIgnoreCase("husd")) {
            UnifyTransferActivity.Wh(getActivity(), ((LinearSwapTradeBasePresenter) yh()).o0(), BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP, false, (String) null, false, -1, "husd");
        } else {
            UnifyTransferActivity.Wh(getActivity(), ((LinearSwapTradeBasePresenter) yh()).o0(), BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP, false, (String) null, false, -1, "usdt");
        }
    }

    private void Pj(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "entrust_list");
        gs.g.j("contract_trade", "usdt_contract", str, hashMap);
    }

    /* access modifiers changed from: private */
    public void Qj() {
        if (!rn.c.i().d(getActivity(), new JumpTarget((Intent) null, (Intent) null))) {
            l c11 = l.c();
            TradeType tradeType = TradeType.LINEAR_SWAP;
            if (c11.g(tradeType) == null) {
                HuobiToastUtil.j(R.string.contract_account_loading);
            } else if (l.c().i(tradeType)) {
                Pi();
            } else {
                m.c(getActivity(), tradeType);
            }
        }
    }

    private void Si() {
        this.Q.add(getString(R.string.n_contract_trade_position_hold));
        this.Q.add(getString(R.string.n_contract_trade_open_orders));
        this.Q.add(getString(R.string.n_trade_bot_contract_grid));
        this.P = (CommonTextListIndicator) this.f67460i.b(R.id.order_type_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        j jVar = new j();
        commonNavigator.setAdapter(jVar);
        this.P.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
        this.P.setNavigator(commonNavigator);
        this.P.o();
        new CommonNavigator(getActivity()).setAdapter(jVar);
        Vj();
    }

    private void Ti() {
        if (this.T instanceof FutureTradeTogetherView) {
            MagicIndicator magicIndicator = this.U.getMagicIndicator();
            this.C = magicIndicator;
            magicIndicator.setVisibility(0);
            this.V.add(getString(R.string.n_contract_trade_position_open));
            this.V.add(getString(R.string.n_contract_trade_position_close));
            CommonNavigator commonNavigator = new CommonNavigator(getActivity());
            this.D = commonNavigator;
            commonNavigator.setAdjustMode(true);
            this.D.setAdapter(new i());
            this.C.setNavigator(this.D);
        }
    }

    /* access modifiers changed from: private */
    public void Tj() {
        boolean F0 = r.x().F0();
        ViewUtil.m(this.R, F0);
        View view = this.f75310f0;
        boolean z11 = true;
        if (!F0 || e1() != 1) {
            z11 = false;
        }
        ViewUtil.m(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ui(View view) {
        Fj(1);
        Pj("plan_entrust");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public void Uj() {
        int i11 = this.f75308d0;
        if (i11 == 1) {
            this.f75330x.setChecked(false);
            this.f75331y.setChecked(true);
            this.f75332z.setChecked(false);
            this.A.setChecked(false);
        } else if (i11 == 2) {
            this.f75330x.setChecked(false);
            this.f75331y.setChecked(false);
            this.f75332z.setChecked(true);
            this.A.setChecked(false);
        } else if (i11 == 3) {
            this.f75330x.setChecked(false);
            this.f75331y.setChecked(false);
            this.f75332z.setChecked(false);
            this.A.setChecked(true);
        } else if (i11 == 4) {
            this.f75330x.setChecked(false);
            this.f75331y.setChecked(false);
            this.f75332z.setChecked(false);
            this.A.setChecked(false);
            this.B.setChecked(true);
        } else {
            this.f75330x.setChecked(true);
            this.f75331y.setChecked(false);
            this.f75332z.setChecked(false);
            this.A.setChecked(false);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Vi(View view) {
        Fj(2);
        Pj("stop_surplus_loss");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void Vj() {
        int e12 = e1();
        this.P.c(e12);
        this.P.b(e12, 0.0f, 0);
        if (e12 != this.f75307c0) {
            ((LinearSwapTradeBasePresenter) yh()).f2();
        }
        this.f75307c0 = e12;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Wi(View view) {
        Fj(3);
        Pj("tracking_entrust");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public void Wj() {
        boolean z11 = true;
        ViewUtil.m(this.f75326t, r.x().F0() && e1() == 0);
        View b11 = this.f67460i.b(R.id.order_tab_list_layout);
        if (!r.x().F0() || e1() == 0) {
            z11 = false;
        }
        ViewUtil.m(b11, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Xi(View view) {
        Fj(4);
        Pj("period_entrust");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yi(HashMap hashMap, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ((LinearSwapTradeBasePresenter) yh()).M3(hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Zi(int i11) {
        int i12;
        HashMap hashMap = new HashMap();
        if (i11 == 0) {
            i12 = R.string.n_contract_revoke_order_comfirm_all_content;
        } else if (i11 == 1) {
            i12 = R.string.n_contract_revoke_order_comfirm_limit_content;
            hashMap.put("cancel_kind", 1);
        } else if (i11 != 2) {
            i12 = 0;
        } else {
            i12 = R.string.n_contract_revoke_order_comfirm_tpsl_content;
            hashMap.put("cancel_kind", 2);
        }
        DialogUtils.b0(getActivity(), getString(R.string.n_all_cancel_title), getString(i12), "", getString(R.string.n_cancel), getString(R.string.n_confirm), o0.f12469a, new e1(this, hashMap));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aj(Void voidR) {
        ContractCloseAllDialog.sh().th(new l1(this)).show(getChildFragmentManager(), "");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "entrust_list");
        gs.g.j("contract_trade", "usdt_contract", "all_repeal", hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bj(List list) {
        this.f75322p.setTradeActivity(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void cj(Boolean bool) {
        this.f75322p.k("SwapZero", bool.booleanValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void dj(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        MultiColorSeekBar multiColorSeekBar = (MultiColorSeekBar) this.f67460i.b(R.id.contract_seekbar_new);
        if (multiColorSeekBar != null) {
            multiColorSeekBar.correctOffsetWhenContainerOnScrolling();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean ej(View view, MotionEvent motionEvent) {
        this.f75306b0.hideKeyboard();
        return false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void fj(CompoundButton compoundButton, boolean z11) {
        this.J.setVisibility(z11 ? 8 : 0);
        qk.o0.c(z11);
        ((LinearSwapTradeBasePresenter) yh()).l5();
        is.a.j("5149", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gj(CompoundButton compoundButton, boolean z11) {
        qk.o0.d(z11);
        ((LinearSwapTradeBasePresenter) yh()).x4();
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hj(Void voidR) {
        if (SPUtil.j()) {
            HuobiToastUtil.j(R.string.n_union_cross_support_only);
        } else if (!Ij().booleanValue()) {
            if (((LinearSwapTradeBasePresenter) yh()).O2()) {
                HuobiToastUtil.j(R.string.n_linear_swap_not_support_isolate_mode);
            } else if (!((LinearSwapTradeBasePresenter) yh()).P2()) {
                HuobiToastUtil.j(R.string.n_linear_swap_not_support_cross_mode);
            } else if (!this.F.M()) {
                new LinearSwapMarginModeDialogFragment().show(getChildFragmentManager(), "LinearSwapMarginModeDialogFragment");
                gs.g.j("usdt_contract", (String) null, "onebyone_all", (HashMap) null);
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ij(View view) {
        Fj(0);
        Pj("limited_price_entrust");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void jj(HBDialogFragment hBDialogFragment) {
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "contract_trade");
        hashMap.put("button_name", "trade_now_dialog");
        gs.g.i("appclick_contracts", hashMap);
        Gj();
        hBDialogFragment.dismiss();
    }

    public static /* synthetic */ void kj(HBDialogFragment hBDialogFragment) {
        zn.a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/trade/contractGrid?source=app_contract_dialog&tabIndex=1")).a().c();
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        FutureContractInfo H2 = ((LinearSwapTradeBasePresenter) yh()).H();
        if (!(H2 == null || H2.getContractCode() == null)) {
            FragmentActivity activity = getActivity();
            String symbol = H2.getSymbol();
            int a11 = tc.a.a(TradeType.LINEAR_SWAP);
            int i11 = 1;
            if (((LinearSwapTradeBasePresenter) yh()).D2() != 1) {
                i11 = 0;
            }
            LinearSwapOrderActivity.Si(activity, symbol, a11, i11, H2.getContractCode(), H2.getContractShortType(), 0);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "hold_entrust");
        gs.g.j("contract_trade", "usdt_contract", TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER, hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lj(View view) {
        Gj();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void mj(boolean z11) {
        int i11 = 8;
        if (qk.o0.a()) {
            this.J.setVisibility(8);
            return;
        }
        TextView textView = this.J;
        if (z11) {
            i11 = 0;
        }
        textView.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void nj(View view) {
        this.f75322p.getTradeRightPopIv().performClick();
        ConfigPreferences.n("user_config", "BUBBLE_ASSET_FEATURE_KEY", true);
        this.f75311g0.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oj(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        com.cpiz.android.bubbleview.b bVar = this.f75311g0;
        if (bVar != null) {
            bVar.dismiss();
            this.f75321o.setOnScrollChangedListener((MyNestedScrollView.OnScrollChangedListener) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void pj() {
        com.cpiz.android.bubbleview.b K2 = n.o().K(this.f75322p.getTradeRightPopIv());
        this.f75311g0 = K2;
        K2.getContentView().setOnClickListener(new r0(this));
        this.f75321o.setOnScrollChangedListener(new m1(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void qj(boolean z11) {
        if (((LinearSwapTradeBasePresenter) yh()).H() != null) {
            ((FutureTradeFragment) getParentFragment()).di(FuturePrecisionUtil.s(((LinearSwapTradeBasePresenter) yh()).H().getContractCode(), ((LinearSwapTradeBasePresenter) yh()).H().getContractShortType(), ""));
        }
        ((FutureTradeFragment) getParentFragment()).ci(z11);
    }

    public static /* synthetic */ Unit rj(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        try {
            String trailFund = ((LinearSwapCrossAccountInfo) list.get(0)).getTrailFund();
            String str = Calendar.getInstance().get(1) + "" + Calendar.getInstance().get(6);
            boolean l11 = SP.l("contractUnused" + str + r.x().J(), true);
            if (com.hbg.module.libkt.base.ext.b.x(trailFund) || Double.parseDouble(trailFund) <= 0.0d || !l11) {
                return null;
            }
            SP.y("contractUnused" + str + r.x().J(), false);
            SP.y("contractCouponExpire" + str + r.x().J(), false);
            HashMap hashMap = new HashMap();
            hashMap.put("business_category", "experience_gold_pop_up");
            hashMap.put("type", "usdt_contract");
            gs.g.i("appexposure_contracts", hashMap);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ Unit sj(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void tj(List list) {
        ((LinearSwapTradeBasePresenter) yh()).g2(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void uj(HBDialogFragment hBDialogFragment) {
        ((LinearSwapTradeBasePresenter) yh()).T3();
        hBDialogFragment.dismiss();
        this.Z = false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void yj(String str, String str2, View view) {
        DialogUtils.X(getActivity(), getResources().getString(R.string.n_exchange_balance_notice_title), String.format(getResources().getString(R.string.n_contract_canuse_alert_explain_tips_new), new Object[]{str, str2}), "", getResources().getString(R.string.n_known), h1.f13147a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void A0(int i11) {
        this.f75329w.v2(8, -1);
        this.f75329w.A0(i11);
        if (!((LinearSwapTradeBasePresenter) yh()).Q2()) {
            if (i11 == 0) {
                this.S.setText("");
                this.S.setVisibility(4);
                return;
            }
            this.S.setVisibility(0);
        }
    }

    public void A2(List<TopScrollData> list, boolean z11, boolean z12) {
        if (!((LinearSwapTradeBasePresenter) yh()).Q2()) {
            if (list == null) {
                this.f75323q.setVisibility(8);
                this.S.setVisibility(0);
                this.f75323q.h();
                return;
            }
            TopScrollView topScrollView = this.f75323q;
            topScrollView.j(list, z11, topScrollView.getVisibility() == 8);
            this.f75323q.setVisibility(0);
            this.S.setVisibility(8);
        }
    }

    public void Ah() {
        Tj();
        this.f75325s.setOnClickListener(new e());
        this.f75322p.setOnHeadClickListener(new f());
        this.F.e0(new g());
        this.R.setOnClickListener(new x1(this));
        this.f75321o.setOnScrollChangeListener(new v0(this));
        this.f75321o.setOnTouchListener(new s0(this));
        this.I.setOnCheckedChangeListener(new u0(this));
        this.K.setOnCheckedChangeListener(new t0(this));
        dw.a.a(this.M).throttleFirst(1, TimeUnit.SECONDS).subscribe(new t1(this));
        this.f75330x.setOnClickListener(new w1(this));
        this.f75331y.setOnClickListener(new a2(this));
        this.f75332z.setOnClickListener(new c1(this));
        this.A.setOnClickListener(new z1(this));
        this.B.setOnClickListener(new y1(this));
        dw.a.a(this.f75310f0).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new u1(this));
        ((LinearSwapTradeBasePresenter) yh()).f75046b0.observe(this, new x0(this));
        ((LinearSwapTradeBasePresenter) yh()).f75050d0.observe(this, new w0(this));
    }

    public int B0() {
        return this.f75308d0;
    }

    public RecyclerView C1() {
        return this.H;
    }

    public void E1(int i11) {
    }

    public void Eg(String str, String str2) {
        DialogUtils.b0(getActivity(), getString(R.string.contract_trade_no_right_dialog_title), String.format(getString(R.string.contract_trade_no_right_dialog_message), new Object[]{a7.e.l(getActivity(), str, str2)}), "", getString(R.string.string_cancel), getString(R.string.contract_trade_no_right_dialog_positive_btn), j1.f13158a, new d1(this));
    }

    public void F1() {
        this.f75329w.Y0(this.f75320n);
        com.huobi.feature.ui.a aVar = this.f75329w;
        aVar.M0(aVar.getTradePosition());
    }

    public void Fj(int i11) {
        if (this.f75308d0 != i11) {
            this.f75308d0 = i11;
            tc.a.e(TradeType.LINEAR_SWAP, i11);
            Uj();
            ((LinearSwapTradeBasePresenter) yh()).f2();
            ((LinearSwapTradeBasePresenter) yh()).x4();
        }
    }

    public void G1(int i11) {
        if (this.T instanceof FutureTradeTogetherView) {
            Ki(this.C, i11);
        }
    }

    public final void Gj() {
        if (this.f75314j0 != null) {
            com.huobi.experience.a.a(getChildFragmentManager(), new ArrayList(this.f75314j0), "", new k1(this));
            String couponIds = CouponExperienceRequestHelper.getInstance().getCouponIds(this.f75314j0);
            ConfigPreferences.m("user_config", "config_linear_swap_coupon_red_ids" + r.x().J(), couponIds);
            ConfigPreferences.m("user_config", "config_linear_swap_coupon_bubble_ids" + r.x().J(), couponIds);
            this.f75329w.A2(this.f75314j0, false);
            CouponExperienceRequestHelper.getInstance().onContractTabRedChange(false);
            gs.g.j("contract_trade", (String) null, "available_experience", (HashMap) null);
        }
    }

    public final void Hj() {
        ((CouponService) HbgRetrofit.request(CouponService.class)).couponNotice("10,15").compose(HbgRetrofit.e()).compose(RxJavaHelper.t((u6.g) null)).subscribe(new k());
    }

    public void I1() {
        i6.k.o("ContractKyc", "检查正向永续权限");
        l c11 = l.c();
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (c11.g(tradeType) == null || r.x().X() || !isCanBeSeen() || !ej.j.c() || !z2.c().e("OPEN_NAME") || !f75304n0) {
            return;
        }
        if (l.c().i(tradeType)) {
            UserKycInfoNew o11 = KycProxy.l().o();
            if (o11 != null && o11.getAuth_info() != null && o11.getAuth_info().isNeedAgreeV2()) {
                FutureUserInfo g11 = l.c().g(tradeType);
                if (g11 == null || g11.getIsAgreeV2() != 1) {
                    HBBaseWebActivity.showWebView(getActivity(), ContractWebActivity.yh(4, ((LinearSwapTradeBasePresenter) yh()).H().getContractCode()), "", "", false);
                    f75304n0 = false;
                    return;
                }
                UnifyKycInfo m11 = KycProxy.l().m();
                if (m11 != null && m11.getStepStates() != null && !m11.getStepStates().isEmpty()) {
                    for (UnifyKycStepState next : m11.getStepStates()) {
                        if ("C1".equals(next.getAuthStep()) || "C2".equals(next.getAuthStep())) {
                            if (next.getItemStates() != null && !next.getItemStates().isEmpty()) {
                                for (UnifyKycItemState authState : next.getItemStates()) {
                                    authState.getAuthState();
                                }
                            }
                        } else if ("INFO_EXTRA_FORM".equals(next.getAuthStep())) {
                            if (next.getItemStates() != null && !next.getItemStates().isEmpty()) {
                                for (UnifyKycItemState next2 : next.getItemStates()) {
                                    if ("INFO_EXTRA_FORM".equals(next2.getAuthItem())) {
                                        next2.getAuthState();
                                    }
                                }
                            }
                        } else if ("EDD_FORM".equals(next.getAuthStep()) && next.getItemStates() != null && !next.getItemStates().isEmpty()) {
                            for (UnifyKycItemState next3 : next.getItemStates()) {
                                if ("EDD_RISK_FORM".equals(next3.getAuthItem())) {
                                    next3.getAuthState();
                                }
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        m.c(getActivity(), tradeType);
        f75304n0 = false;
    }

    public void Ib(boolean z11, String str) {
        this.Y = z11;
        int i11 = 0;
        if (z11) {
            String format = String.format(getResources().getString(R.string.n_grid_market_visible_hint_text), new Object[]{str});
            String string = getResources().getString(R.string.n_grid_view_policy_details);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(format);
            spannableStringBuilder.append(string);
            spannableStringBuilder.setSpan(new b(), format.length(), spannableStringBuilder.length(), 34);
            this.f75328v.setText(spannableStringBuilder);
            this.f75328v.setMovementMethod(LinkMovementMethod.getInstance());
            Ij();
        }
        View view = this.f75327u;
        if (!z11) {
            i11 = 8;
        }
        view.setVisibility(i11);
    }

    public final Boolean Ij() {
        if (!this.Y || ((LinearSwapTradeBasePresenter) yh()).z2().booleanValue() || !((LinearSwapTradeBasePresenter) yh()).y2().booleanValue()) {
            return Boolean.FALSE;
        }
        if (this.Z) {
            return Boolean.TRUE;
        }
        DialogUtils.X(getActivity(), getString(R.string.lite_market_info_price_notice_title), String.format(getString(R.string.n_grid_market_visible_hint_text), new Object[]{((LinearSwapTradeBasePresenter) yh()).C2()}), (String) null, getString(R.string.lite_trade_i_know), new b1(this));
        this.Z = true;
        return Boolean.TRUE;
    }

    public void J1(long j11) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (!((LinearSwapTradeBasePresenter) yh()).Q2()) {
            long j12 = ConfigConstant.f68414b;
            if (j11 >= j12) {
                if (j11 % j12 != 0) {
                    str5 = String.valueOf((j11 / j12) + 1);
                } else {
                    str5 = String.valueOf(j11 / j12);
                }
                this.S.setText(String.format(getString(R.string.n_contract_distance_delivery), new Object[]{str5, getString(R.string.contract_distance_delivery_day)}));
            } else if (j11 < j12 && j11 > Period.MIN60_MILLS) {
                long j13 = j11 / Period.MIN60_MILLS;
                if (j13 != 0) {
                    str4 = String.valueOf(j13 + 1);
                } else {
                    str4 = String.valueOf(j13);
                }
                this.S.setText(String.format(getString(R.string.n_contract_distance_delivery), new Object[]{str4, getString(R.string.contract_distance_delivery_hour)}));
            } else if (j11 <= 0 || j11 > Period.MIN60_MILLS) {
                this.S.setText(String.format(getString(R.string.n_contract_distance_delivery), new Object[]{"0", getString(R.string.contract_distance_delivery_hour)}));
            } else {
                long j14 = j11 / Period.MIN60_MILLS;
                if (j14 < 10) {
                    str = "0" + String.valueOf(j14);
                } else {
                    str = String.valueOf(j14);
                }
                long j15 = j11 % Period.MIN60_MILLS;
                long j16 = j15 / ConfigConstant.f68415c;
                if (j16 < 10) {
                    str2 = "0" + String.valueOf(j16);
                } else {
                    str2 = String.valueOf(j16);
                }
                long j17 = (j15 % ConfigConstant.f68415c) / 1000;
                if (j17 < 10) {
                    str3 = "0" + String.valueOf(j17);
                } else {
                    str3 = String.valueOf(j17);
                }
                this.S.setText(String.format(getString(R.string.contract_distance_delivery_hour_minute_seconde), new Object[]{str + ":" + str2 + ":" + str3}));
            }
            this.S.setVisibility(0);
            this.f75323q.setVisibility(8);
        }
    }

    public void Jj(String str, String str2, String str3) {
        if (i6.m.a(str).compareTo(BigDecimal.ZERO) > 0) {
            this.f75324r.setDash(true);
            this.f75324r.setOnClickListener(new b2(this, i6.m.a(str2).setScale(FuturePrecisionUtil.g(str3), 1).toPlainString(), i6.m.a(str).setScale(FuturePrecisionUtil.g(str3), 1).toPlainString()));
            return;
        }
        this.f75324r.setDash(false);
        this.f75324r.setOnClickListener(c2.f13126b);
    }

    public void La(boolean z11) {
        if (((k2) zh()).isCanBeSeen()) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof FutureTradeFragment) {
                FutureTradeFragment futureTradeFragment = (FutureTradeFragment) parentFragment;
                if (((((FutureTradePresenter) futureTradeFragment.yh()).i0() instanceof LinearSwapTradeSplitFragment) && !z11) || ((((FutureTradePresenter) futureTradeFragment.yh()).i0() instanceof LinearSwapTradeTogetherFragment) && z11)) {
                    boolean z12 = true;
                    p0.k(z11 ^ true ? 1 : 0);
                    FragmentActivity activity = getActivity();
                    if (getActivity() == null || !(getActivity() instanceof HuobiMainActivity)) {
                        z12 = false;
                    }
                    startActivity(k0.i(activity, z12));
                }
            }
        }
    }

    public final void Li(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "experience_gold_pop_up_coupons");
        hashMap.put("type", "usdt_contract");
        gs.g.i("appexposure_contracts", hashMap);
        DialogUtils.b0(getActivity(), getResources().getString(R.string.n_otc_use_tip), String.format(getResources().getString(R.string.n_contract_unused_experience_vouchers), new Object[]{str}), (String) null, getResources().getString(R.string.n_cancel), getResources().getString(R.string.n_coupon_draw_btn_title), o0.f12469a, new z0(this));
    }

    public final void Mi(String str) {
        DialogUtils.b0(getActivity(), getResources().getString(R.string.n_bot_detail_coupon_contract_title), String.format(getResources().getString(R.string.n_contract_grid_coupon_dialog_content), new Object[]{str}), (String) null, getResources().getString(R.string.n_cancel), getResources().getString(R.string.n_coupon_state_wait_use_button), o0.f12469a, f1.f13139a);
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "grid_experience_gold_pop_up_coupons");
        hashMap.put("type", "usdt_contract");
        gs.g.i("appexposure_contracts", hashMap);
    }

    public void N0() {
        String str;
        String str2;
        String o02 = ((LinearSwapTradeBasePresenter) yh()).o0();
        if (a7.e.E(((LinearSwapTradeBasePresenter) yh()).H2())) {
            str = "symbol";
        } else {
            str = a7.e.G(((LinearSwapTradeBasePresenter) yh()).H2()) ? "usdt" : "sheet";
        }
        String str3 = str;
        if ("cny".equals(LegalCurrencyConfigUtil.y())) {
            str2 = "cny";
        } else {
            str2 = "usd";
        }
        if (((LinearSwapTradeBasePresenter) yh()).H() != null) {
            ContractWebActivity.ii(getActivity(), o02, str3, str2, ((LinearSwapTradeBasePresenter) yh()).H().getContractCode(), ((LinearSwapTradeBasePresenter) yh()).H().getContractShortType(), ((LinearSwapTradeBasePresenter) yh()).D2() == 2 ? FutureContractInfo.MARGIN_ISOLATED : FutureContractInfo.MARGIN_CROSS, 4);
        }
    }

    public void N5() {
        FutureTradeTogetherView futureTradeTogetherView = this.U;
        if (futureTradeTogetherView != null) {
            futureTradeTogetherView.N2();
        }
    }

    public void Nb(boolean z11) {
        boolean z12 = z11;
        if (z12 || Ni()) {
            int a11 = PixelUtils.a(4.0f);
            int a12 = PixelUtils.a(6.0f);
            int a13 = PixelUtils.a(10.0f);
            int i11 = -a11;
            a.e j11 = new a.e(this.f67460i.b(R.id.trade_drawer_iv_wapper), "", getString(R.string.n_contract_user_guide_1)).j(a12, i11, a11, i11);
            int i12 = i11 / 2;
            a.e j12 = new a.e(this.f67460i.b(R.id.trade_right_pop_iv), "", getString(R.string.n_unit_deposit_guide_tip)).j(0, i11, i12, i11);
            a.e j13 = new a.e(this.f67460i.b(R.id.contract_available_content), "", getString(R.string.n_contract_user_guide_2)).j(a12, a12, a12, a12);
            a.e l11 = new a.e(this.f67460i.b(R.id.contract_trade_lever_ll), "", getString(R.string.n_contract_user_guide_3)).j(0, 0, 0, 0).l(17);
            a.e j14 = new a.e(this.f67460i.b(R.id.contract_trade_amount_view), "", getString(R.string.n_contract_user_guide_4)).j(a12, a11, a12, a11);
            a.e k11 = new a.e(this.f67460i.b(R.id.contract_kzkd_layout), "", getString(R.string.n_contract_user_guide_5)).j(a12, 0, a12, a12).k(false);
            int i13 = -a13;
            a.e k12 = new a.e(this.f67460i.b(R.id.order_type_indicator), "", getString(R.string.n_contract_user_guide_6)).j(i13, 0, i13, a11).k(false);
            a.e j15 = new a.e(this.f67460i.b(R.id.trade_right_pop_iv), "", getString(R.string.n_contract_user_guide_7)).j(0, i11, i12, i11);
            com.huobi.trade.utils.a.j().r(getActivity(), SP.l("union_permission_status", false) ? new a.e[]{j11, j12, j13, l11, j14, k11, k12, j15} : new a.e[]{j11, j13, l11, j14, k11, k12, j15}, z12, new c());
        }
    }

    public final boolean Ni() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append(" isVisibleToUser:");
        sb2.append(this.f67463e);
        sb2.append(" value:");
        sb2.append(!ConfigPreferences.c("user_config", "CONTRACT_NEW_GUIDE", false));
        i6.d.d(sb2.toString());
        if (!this.f67463e || ConfigPreferences.c("user_config", "CONTRACT_NEW_GUIDE", false)) {
            return false;
        }
        return true;
    }

    public void O0(String str, int i11, int i12) {
        this.f75322p.v(str, i11, i12);
    }

    public void P6(int i11) {
    }

    public void Q5() {
        if (((LinearSwapTradeBasePresenter) yh()).O2()) {
            this.N.setVisibility(8);
        } else if (((LinearSwapTradeBasePresenter) yh()).P2()) {
            this.N.setVisibility(0);
        } else {
            this.N.setVisibility(8);
        }
    }

    public void Q8(LinearSwapAccountInfo linearSwapAccountInfo) {
        ce(linearSwapAccountInfo);
        if (!r.x().F0() || linearSwapAccountInfo == null) {
            this.f75325s.setText("--");
            return;
        }
        String marginAvailable = linearSwapAccountInfo.getMarginAvailable();
        if (TextUtils.isEmpty(marginAvailable)) {
            marginAvailable = "0.0000";
        }
        try {
            this.f75325s.setText(i6.m.u0(marginAvailable, 12, FuturePrecisionUtil.w(((LinearSwapTradeBasePresenter) yh()).H().getContractCode(), ((LinearSwapTradeBasePresenter) yh()).H().getContractShortType(), ((LinearSwapTradeBasePresenter) yh()).H().getOptionCode())) + "USDT");
            Jj(linearSwapAccountInfo.getTrailFund(), linearSwapAccountInfo.getMarginAvailable(), linearSwapAccountInfo.getSymbol());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void Qi(boolean z11) {
    }

    public void Ri() {
        this.f75329w.K0();
    }

    public abstract void Rj(AccountBalanceInfoV5 accountBalanceInfoV5);

    public void S0() {
        SwapTopTipsLayout swapTopTipsLayout = this.L;
        if (swapTopTipsLayout != null) {
            swapTopTipsLayout.e();
        }
    }

    public void Sa(boolean z11) {
        this.f75322p.setGridEntranceVisible(z11);
    }

    public void Sj(int i11) {
        if (SPUtil.j()) {
            this.O.setText(R.string.n_contract_super_margin);
            this.O.setTextColor(getResources().getColor(R.color.baseColorSecondaryText));
            return;
        }
        this.O.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
        if (TextUtils.isEmpty(((LinearSwapTradeBasePresenter) yh()).o0())) {
            return;
        }
        if (i11 == 1) {
            this.O.setText(R.string.n_contract_super_margin);
        } else {
            this.O.setText(R.string.n_contract_trade_margin);
        }
    }

    public int T0() {
        return tc.a.c(TradeType.LINEAR_SWAP);
    }

    public void T8(List<CouponReturn> list) {
        this.f75314j0 = list;
        this.f75329w.A2(list, CouponExperienceRequestHelper.getInstance().mContractTabRedVisible);
        if (CollectionsUtils.b(list)) {
            this.f75329w.setOnCouponClickListener((View.OnClickListener) null);
        } else {
            this.f75329w.setOnCouponClickListener(new n1(this));
        }
    }

    public void U0(String str) {
        if (!ReviewManger.a()) {
            if (this.f75317l0 == null) {
                rj.b bVar = new rj.b(getContext(), FirebaseAnalytics.Param.CURRENCY);
                this.f75317l0 = bVar;
                bVar.t("openNoticeUrl", CurrencyNoticeAbility.class);
                this.f75317l0.H();
                this.f75317l0.v("visibility", new v1(this));
                if (!NightHelper.e().g()) {
                    this.f75317l0.I("setDarkMode(0)");
                } else {
                    this.f75317l0.I("setDarkMode(1)");
                }
            }
            this.f75317l0.I("currencyNoticeMessage('" + str + "','1')");
        }
    }

    public void V0(boolean z11) {
        this.f75305a0 = z11;
    }

    public com.huobi.feature.ui.a X2() {
        return this.f75329w;
    }

    public void Xj(boolean z11) {
        if (!z11) {
            Q8((LinearSwapAccountInfo) null);
            if (this.f75320n == 2 && (this.T instanceof FutureTradeTogetherView)) {
                Ki(this.C, 0);
            }
        } else if (this.X && (this.T instanceof FutureTradeTogetherView)) {
            Ki(this.C, 2);
            this.X = false;
        }
        this.f75329w.d(z11);
    }

    public i6.r Z0() {
        return this.f67460i;
    }

    public bm.a a1() {
        return new y0(this);
    }

    public void b1() {
        KycAndHasTradeDialogUtils.m(getContext());
    }

    public void bg(FutureContractInfo futureContractInfo) {
        String v11 = a7.e.v(getActivity(), futureContractInfo.getSymbol(), futureContractInfo.getQuoteCurrency(), futureContractInfo.getContractCode(), futureContractInfo.getContractType());
        this.f75322p.x(v11);
        if (((LinearSwapTradeBasePresenter) yh()).Q2()) {
            this.f75323q.setVisibility(0);
            this.S.setVisibility(8);
        }
        FutureTradeTogetherView futureTradeTogetherView = this.U;
        if (futureTradeTogetherView != null) {
            futureTradeTogetherView.N2();
        }
        if (getParentFragment() instanceof FutureTradeFragment) {
            int s11 = FuturePrecisionUtil.s(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), "");
            ((FutureTradeFragment) getParentFragment()).ei(v11, TradeType.LINEAR_SWAP.toString(), futureContractInfo.getContractShortType(), FuturePrecisionUtil.y(futureContractInfo.getContractCode(), futureContractInfo.getContractShortType(), (String) null), s11);
        }
        if (Ni()) {
            this.f75322p.post(new q1(this));
        }
    }

    public void c(int i11) {
        this.f75329w.c(i11);
    }

    public void c1(boolean z11) {
        this.f75329w.R0(z11);
    }

    @k20.h
    @Keep
    public void changeAssetMode(AssetModeBean assetModeBean) {
        if (assetModeBean.isSuccess.booleanValue()) {
            if (assetModeBean.isUnion.booleanValue()) {
                ((LinearSwapTradeBasePresenter) yh()).U3(1);
                this.O.setText(R.string.n_contract_super_margin);
                this.O.setTextColor(getResources().getColor(R.color.baseColorSecondaryText));
            } else {
                this.O.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
            }
            ((LinearSwapTradeBasePresenter) yh()).J3();
        }
    }

    public void d1(ContractOpenCountInfo contractOpenCountInfo) {
        List<String> list = this.Q;
        if (list != null && list.size() >= 2) {
            String str = this.Q.get(0);
            String str2 = this.Q.get(1);
            int totalPositions = contractOpenCountInfo.getTotalPositions();
            if (totalPositions <= 0) {
                this.Q.set(0, getString(R.string.n_contract_trade_position_hold));
            } else {
                List<String> list2 = this.Q;
                list2.set(0, getString(R.string.n_contract_trade_position_hold) + "(" + totalPositions + ")");
            }
            int totalOrders = contractOpenCountInfo.getTotalOrders();
            if (totalOrders <= 0) {
                this.Q.set(1, getString(R.string.n_contract_trade_open_orders));
            } else {
                List<String> list3 = this.Q;
                list3.set(1, getString(R.string.n_contract_trade_open_orders) + "(" + totalOrders + ")");
            }
            if (!TextUtils.equals(str, this.Q.get(0)) || !TextUtils.equals(str2, this.Q.get(1))) {
                this.P.getNavigator().notifyDataSetChanged();
            }
        }
    }

    public int e1() {
        return tc.a.b(TradeType.LINEAR_SWAP);
    }

    public void f(int i11) {
        RadioButton radioButton = this.f75332z;
        radioButton.setText(getResources().getString(R.string.n_contract_trade_trend_stop) + "(" + i11 + ")");
    }

    public void g(int i11) {
        RadioButton radioButton = this.f75331y;
        radioButton.setText(getResources().getString(R.string.n_contract_order_type_trigger) + "(" + i11 + ")");
    }

    public void g1(int i11) {
        this.f75329w.T0(i11);
    }

    public int getPositionType() {
        return this.f75320n;
    }

    public void h(int i11) {
        if (SPUtil.j()) {
            RadioButton radioButton = this.f75330x;
            radioButton.setText(getResources().getString(R.string.n_exchange_limit_or_market) + "(" + i11 + ")");
            return;
        }
        RadioButton radioButton2 = this.f75330x;
        radioButton2.setText(getResources().getString(R.string.n_contract_order_type_limit) + "(" + i11 + ")");
    }

    public void hc(int i11) {
        Sj(i11);
        if (i11 != ((LinearSwapTradeBasePresenter) yh()).D2()) {
            this.f75325s.setText("--");
            ((LinearSwapTradeBasePresenter) yh()).P3();
            v0();
            ((LinearSwapTradeBasePresenter) yh()).U3(i11);
            ((LinearSwapTradeBasePresenter) yh()).Y3();
            this.f75329w.z2();
        }
    }

    public void i(int i11) {
        RadioButton radioButton = this.A;
        radioButton.setText(getResources().getString(R.string.n_contract_track_order) + "(" + i11 + ")");
    }

    public void initViews() {
        super.initViews();
        EventBus.d().p(this);
        TradeType tradeType = TradeType.LINEAR_SWAP;
        this.f75307c0 = tc.a.b(tradeType);
        this.f75308d0 = tc.a.c(tradeType);
        this.f75321o = (MyNestedScrollView) this.f67460i.b(R.id.trade_scrollview);
        this.f75322p = (TradeHeadView) this.f67460i.b(R.id.trade_head_view);
        boolean l11 = SP.l("union_permission_status", false);
        this.f75312h0 = l11;
        if (l11) {
            if (ConfigPreferences.c("user_config", "BUBBLE_ASSET_FEATURE_KEY", false)) {
                this.f75322p.setRightPopDotVisibility(8);
            } else {
                this.f75322p.setRightPopDotVisibility(0);
                this.f75322p.getTradeRightPopIv().post(new r1(this));
            }
        }
        this.f75322p.setCalculatorVisibility(0);
        this.f75323q = (TopScrollView) this.f67460i.b(R.id.funding_rate_layout);
        this.S = (TextView) this.f67460i.b(R.id.delivery_date_tv);
        this.f75330x = (RadioButton) this.f67460i.b(R.id.order_tab_list_type_limit_tv);
        if (SPUtil.j()) {
            this.f75330x.setText(R.string.n_exchange_limit_or_market);
        } else {
            this.f75330x.setText(R.string.n_contract_order_type_limit);
        }
        this.f75331y = (RadioButton) this.f67460i.b(R.id.order_tab_list_type_trigger_tv);
        this.f75332z = (RadioButton) this.f67460i.b(R.id.order_tab_list_type_stop_tv);
        this.A = (RadioButton) this.f67460i.b(R.id.order_tab_list_type_track_tv);
        this.B = (RadioButton) this.f67460i.b(R.id.order_tab_list_type_time_tv);
        this.f75324r = (UnderLineTextView) this.f67460i.b(R.id.account_available_label_tv);
        this.f75325s = (TextView) this.f67460i.b(R.id.account_available_value_tv);
        this.f75327u = this.f67460i.b(R.id.grid_market_hint);
        this.f75328v = (TextView) this.f67460i.b(R.id.grid_market_hint_text);
        this.f75326t = this.f67460i.b(R.id.position_top_container_parent);
        this.R = this.f67460i.b(R.id.order_current_iv);
        this.f75310f0 = this.f67460i.b(R.id.order_cancel_all);
        this.F = (SmartRefreshLayout) this.f67460i.b(R.id.contract_trade_srl);
        this.E = new SmartRefreshHeader(getActivity());
        this.F.i(true);
        this.F.g(false);
        this.F.V(false);
        this.F.W(false);
        this.F.j0(this.E);
        this.G = this.f67460i.b(R.id.current_order_ll);
        this.H = (RecyclerView) this.f67460i.b(R.id.contract_trade_current_order_rv);
        this.I = (CheckBox) this.f67460i.b(R.id.position_show_symbol_iv);
        this.J = (TextView) this.f67460i.b(R.id.tvCloseAll);
        if (qk.o0.a()) {
            this.I.setChecked(true);
            this.J.setVisibility(8);
        } else {
            this.I.setChecked(false);
            this.J.setVisibility(0);
        }
        this.J.setOnClickListener(new a());
        CheckBox checkBox = (CheckBox) this.f67460i.b(R.id.entrust_show_symbol_iv);
        this.K = checkBox;
        checkBox.setChecked(qk.o0.b());
        this.L = (SwapTopTipsLayout) this.f67460i.b(R.id.id_contract_count_down_layout);
        this.M = this.f67460i.b(R.id.margin_mode_container);
        this.N = (ImageView) this.f67460i.b(R.id.margin_mode_iv);
        this.O = (TextView) this.f67460i.b(R.id.margin_mode_tv);
        SwapTopTipsLayout swapTopTipsLayout = this.L;
        if (swapTopTipsLayout != null) {
            swapTopTipsLayout.setCallback(new d());
        }
        this.H.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(getActivity(), R.color.baseColorPrimarySeparator), PixelUtils.a(0.5f), false, false));
        View b11 = this.f67460i.b(R.id.trade_layout);
        this.T = b11;
        if (b11 instanceof FutureTradeTogetherView) {
            this.U = (FutureTradeTogetherView) b11;
            Ti();
        }
        Si();
        Uj();
        Q8((LinearSwapAccountInfo) null);
        F1();
        this.f75306b0 = new HuobiKeyboardHelper().attach(getActivity());
        uc.g.a(this.f67460i.b(R.id.future_trade_empty_view), getActivity());
        this.f75323q.setTextSize(11);
        this.f75315k0 = (FrameLayout) this.f67460i.b(R.id.currency_notice_container);
    }

    public void j1() {
        if (!((LinearSwapTradeBasePresenter) yh()).Q2()) {
            this.S.setText("--");
            this.S.setVisibility(0);
            this.f75323q.setVisibility(8);
        }
    }

    public void k2(String str) {
        this.f75329w.k2(str);
    }

    public void m(int i11, boolean z11) {
        s1(((LinearSwapTradeBasePresenter) yh()).o0());
        ((LinearSwapTradeBasePresenter) yh()).Y3();
        this.f75329w.J0();
        if (getParentFragment() instanceof FutureTradeFragment) {
            i6.i.b().g(new s1(this, z11), 500);
        }
    }

    public void m1() {
        if (!this.f75305a0) {
            this.f75305a0 = true;
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_login_tip)).C0(getString(R.string.n_futures_not_support_hint)).P0(getString(R.string.n_known)).q0(false).Q0(new a1(this)).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void n0() {
        this.f75329w.n0();
        if (this.T instanceof FutureTradeTogetherView) {
            this.C.getNavigator().notifyDataSetChanged();
        }
    }

    public void n2(FuturePriceLimitInfo futurePriceLimitInfo) {
        this.f75329w.n2(futurePriceLimitInfo);
    }

    public void onDestroyView() {
        super.onDestroyView();
        EventBus.d().r(this);
        ContractTradePopDialogFragment contractTradePopDialogFragment = this.W;
        if (contractTradePopDialogFragment != null) {
            contractTradePopDialogFragment.dismiss();
        }
        rj.b bVar = this.f75317l0;
        if (bVar != null) {
            bVar.B();
        }
    }

    public void onFocusChange(View view, boolean z11) {
        if (z11) {
            int[] iArr = new int[2];
            if (this.T instanceof FutureTradeTogetherView) {
                this.C.getLocationOnScreen(iArr);
            }
            if (iArr[1] - ViewUtil.g() > this.f75322p.getHeight()) {
                this.f75321o.scrollTo(0, ((ViewUtil.g() + this.f75322p.getHeight()) + ViewUtil.g()) - 1);
                Fragment parentFragment = getParentFragment();
                if (parentFragment instanceof FutureTradeFragment) {
                    ((FutureTradeFragment) parentFragment).z8(false, true);
                }
            }
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void p0(String str, String str2) {
        this.f75329w.p0(str, str2);
    }

    public void q(String str) {
        KycAndHasTradeDialogUtils.l(getContext(), str, g1.f13143a);
    }

    public void q0() {
        Ri();
        this.f75329w.q0();
    }

    public void r0() {
        this.f75329w.r0();
    }

    public void s0() {
        this.f75329w.s0();
    }

    public void s1(String str) {
        this.f75329w.Q0();
    }

    public void s2(List<TopScrollData> list, boolean z11, boolean z12) {
        this.f75323q.j(list, z11, z12);
    }

    public void setContractTradeViewController(nk.e eVar) {
        this.f75329w.setContractTradeViewController(eVar);
        this.f75309e0 = eVar;
    }

    public void setInputPriceUpdate(boolean z11) {
        this.f75329w.setInputPriceUpdate(z11);
    }

    public void setLeverList(List<String> list) {
        this.f75329w.setLeverList(list);
    }

    public void t0() {
        this.f75329w.t0();
    }

    public void t1(String str) {
        KycAndHasTradeDialogUtils.n(getContext(), str, i1.f13153a);
    }

    public void u0(boolean z11, boolean z12) {
        this.f75329w.u0(z11, z12);
    }

    public void u2(int i11) {
        RadioButton radioButton = this.B;
        radioButton.setText(getResources().getString(R.string.n_exchange_timing_deal) + "(" + i11 + ")");
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            this.f75323q.g();
            Xj(r.x().F0());
            F1();
            Tj();
            this.I.setChecked(qk.o0.a());
            this.K.setChecked(qk.o0.b());
            if (this.f75320n == 2) {
                ((LinearSwapTradeBasePresenter) yh()).l4();
            }
            if (r.x().F0()) {
                I1();
            }
            Wj();
            Vj();
            HashMap hashMap = new HashMap();
            if (this.f75307c0 == 0) {
                hashMap.put("module_name", "hold_list");
            } else {
                hashMap.put("module_name", "entrust_list");
            }
            gs.g.a("contract_trade", "usdt_contract", hashMap);
            if (r.x().F0()) {
                Hj();
                if (l.c().i(TradeType.LINEAR_SWAP)) {
                    RequestExtKt.c(h8.a.a().J("USDT", TtmlNode.COMBINE_ALL), o1.f13177b, p1.f13182b, (MutableLiveData) null);
                }
            }
            ((LinearSwapTradeBasePresenter) yh()).O3();
            ((LinearSwapTradeBasePresenter) yh()).N3();
            return;
        }
        this.f75323q.h();
        if (getParentFragment() instanceof FutureTradeFragment) {
            ((FutureTradeFragment) getParentFragment()).w3();
        }
        com.cpiz.android.bubbleview.b bVar = this.f75311g0;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public void v0() {
        this.f75329w.v0();
    }

    public int v1() {
        return this.f75307c0;
    }

    public void v2(int i11, int i12) {
        this.f75329w.v2(i11, i12);
        if (((LinearSwapTradeBasePresenter) yh()).Q2() || i11 != 0) {
            return;
        }
        if (i12 == 5 || i12 == 7) {
            this.S.setText(R.string.n_contract_trade_settling);
        } else if (i12 == 6 || i12 == 8) {
            this.S.setText(R.string.n_contract_trade_delivering);
        } else if (i12 == 3) {
            this.S.setText("");
        } else if (i12 == 9) {
            this.S.setText(R.string.trade_suspend);
        }
    }

    public void v5(AccountBalanceInfoV5 accountBalanceInfoV5) {
        Rj(accountBalanceInfoV5);
        if (!r.x().F0() || accountBalanceInfoV5 == null) {
            this.f75325s.setText("--");
            return;
        }
        String availableMargin = accountBalanceInfoV5.getAvailableMargin();
        if (TextUtils.isEmpty(availableMargin)) {
            availableMargin = "0.0000";
        }
        try {
            this.f75325s.setText(i6.m.u0(availableMargin, 12, FuturePrecisionUtil.w(((LinearSwapTradeBasePresenter) yh()).H().getContractCode(), ((LinearSwapTradeBasePresenter) yh()).H().getContractShortType(), ((LinearSwapTradeBasePresenter) yh()).H().getOptionCode())) + "USDT");
            Jj(accountBalanceInfoV5.getVoucher(), accountBalanceInfoV5.getAvailableMargin(), ((LinearSwapTradeBasePresenter) yh()).o0());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void w0(boolean z11, boolean z12) {
        this.f75329w.w0(z11, z12);
    }

    public void x0(String str) {
        this.f75329w.x0(str);
    }

    public void y0(boolean z11) {
        if (z11) {
            this.F.finishRefresh();
            this.F.setNoMoreData(false);
        }
    }

    public void y1() {
        this.f75321o.scrollTo(0, 0);
    }

    public void z0(boolean z11) {
        this.f75329w.z0(z11);
    }
}
