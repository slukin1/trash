package com.huobi.swap.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import bh.j;
import bj.o0;
import bj.z2;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.ability.CurrencyNoticeAbility;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UnifyKycItemState;
import com.hbg.lib.network.newkyc.bean.UnifyKycStepState;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.PriceLimitInfo;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapUserInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.network.swap.core.controller.SwapHiddenInstrumentsController;
import com.hbg.lib.network.swap.core.controller.SwapOpenCloseController;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.TopScrollView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.activity.FutureTradeContainerActivity;
import com.huobi.contract.countdown.ContractTopTipsLayout;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.contract.entity.FuturesActivityInfo;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.contract.ui.ContractConfigActivity;
import com.huobi.contract.ui.ContractTradePopDialogFragment;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.ui.FutureTradeFragment;
import com.huobi.feature.util.ContractCalmPeriodHelper;
import com.huobi.feature.util.KycAndHasTradeDialogUtils;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.kyc.util.KycProxy;
import com.huobi.linearswap.ui.ContractCloseAllDialog;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.helper.l;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.swap.bean.SwapCurrencyInfoDrawerItem;
import com.huobi.swap.presenter.SwapTradeBasePresenter;
import com.huobi.trade.ui.TradeHeadView;
import com.huobi.utils.ReviewManger;
import com.huobi.utils.k0;
import com.huobi.utils.m0;
import com.huobi.view.CommonCenterImageSpan;
import com.huobi.view.TradeBuySellView;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.huobi.view.seekbar.MultiColorSeekBar;
import com.huobi.webview2.ui.ContractWebActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import dj.k4;
import i6.k;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import m9.z;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import pro.huobi.R;
import qk.n0;
import qs.n1;
import sn.t;
import td.i;
import tg.r;
import ts.a1;
import ts.a4;
import ts.b1;
import ts.c1;
import ts.d1;
import ts.e1;
import ts.f1;
import ts.g1;
import ts.h0;
import ts.h1;
import ts.i0;
import ts.i1;
import ts.j0;
import ts.l0;
import ts.p0;
import ts.q0;
import ts.r0;
import ts.s0;
import ts.t0;
import ts.u0;
import ts.v0;
import ts.w0;
import ts.x0;
import ts.y0;
import ts.z0;
import us.h;

public abstract class SwapTradeBaseFragment<P extends SwapTradeBasePresenter<V>, V extends i1> extends BaseFragment<P, V> implements i1, k4, m0<SwapAccountInfo> {

    /* renamed from: c0  reason: collision with root package name */
    public static boolean f81714c0 = true;
    public SmartRefreshLayout A;
    public View B;
    public RecyclerView C;
    public CheckBox D;
    public TextView E;
    public CheckBox F;
    public SwapTopTipsLayout G;
    public CommonTextListIndicator H;
    public List<String> I = new ArrayList();
    public View J;
    public RadioButton K;
    public RadioButton L;
    public RadioButton M;
    public RadioButton N;
    public List<String> O = new ArrayList();
    public ContractTradePopDialogFragment P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public HuobiKeyboardHelper U;
    public int V;
    public int W;
    public n1 X;
    public View Y;
    public FrameLayout Z;

    /* renamed from: a0  reason: collision with root package name */
    public rj.b f81715a0;

    /* renamed from: b0  reason: collision with root package name */
    public View f81716b0;

    /* renamed from: l  reason: collision with root package name */
    public final String f81717l = "coin_contract";

    /* renamed from: m  reason: collision with root package name */
    public final String f81718m = "contract_trade";

    /* renamed from: n  reason: collision with root package name */
    public int f81719n;

    /* renamed from: o  reason: collision with root package name */
    public NestedScrollView f81720o;

    /* renamed from: p  reason: collision with root package name */
    public TradeHeadView f81721p;

    /* renamed from: q  reason: collision with root package name */
    public TopScrollView f81722q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f81723r;

    /* renamed from: s  reason: collision with root package name */
    public CommonCenterImageSpan f81724s;

    /* renamed from: t  reason: collision with root package name */
    public View f81725t;

    /* renamed from: u  reason: collision with root package name */
    public View f81726u;

    /* renamed from: v  reason: collision with root package name */
    public SwapTradeTogetherView f81727v;

    /* renamed from: w  reason: collision with root package name */
    public a4 f81728w;

    /* renamed from: x  reason: collision with root package name */
    public MagicIndicator f81729x;

    /* renamed from: y  reason: collision with root package name */
    public CommonNavigator f81730y;

    /* renamed from: z  reason: collision with root package name */
    public SmartRefreshHeader f81731z;

    public class a implements View.OnClickListener {

        /* renamed from: com.huobi.swap.ui.SwapTradeBaseFragment$a$a  reason: collision with other inner class name */
        public class C0855a extends BaseSubscriber<Object> {
            public C0855a() {
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
            l9.a.a().swapCloseAllPosition().b().compose(RxJavaHelper.t((u6.g) SwapTradeBaseFragment.this.zh())).subscribe(new C0855a());
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            DialogUtils.b0(SwapTradeBaseFragment.this.getActivity(), SwapTradeBaseFragment.this.getString(R.string.n_contract_clear_all_position), SwapTradeBaseFragment.this.getString(R.string.n_contract_clear_all_position_content_swap_tip), "", SwapTradeBaseFragment.this.getString(R.string.n_cancel), SwapTradeBaseFragment.this.getString(R.string.n_confirm), o0.f12469a, new d1(this));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements ContractTopTipsLayout.a {
        public b() {
        }

        public void a(boolean z11) {
        }

        public void b() {
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SwapTradeBaseFragment.this.Ui();
            gs.g.j("contract_trade", "coin_contract", "transfer", (HashMap) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements TradeHeadView.b {

        public class a implements BaseDialogFragment.b {
            public a() {
            }

            public void onDismiss() {
                ContractTradePopDialogFragment unused = SwapTradeBaseFragment.this.P = null;
            }
        }

        public class b extends EasySubscriber<Object> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f81738b;

            public class a extends EasySubscriber<Object> {
                public a() {
                }

                public void onNext(Object obj) {
                    super.onNext(obj);
                    HuobiToastUtil.v(SwapTradeBaseFragment.this.getString(R.string.market_delete_collection_success));
                }
            }

            public b(String str) {
                this.f81738b = str;
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                boolean z11;
                if (aPIStatusErrorException == null || !"11302".equals(aPIStatusErrorException.getErrCode())) {
                    z11 = false;
                } else {
                    z11 = true;
                    t.l(this.f81738b, SwapTradeBaseFragment.this.getContext(), "PRO").compose(RxJavaHelper.t((u6.g) SwapTradeBaseFragment.this.zh())).subscribe(new a());
                }
                if (!z11) {
                    super.onFailed(aPIStatusErrorException);
                }
            }

            public void onNext(Object obj) {
                super.onNext(obj);
                HuobiToastUtil.v(SwapTradeBaseFragment.this.getString(R.string.market_delete_collection_success));
            }
        }

        public d() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(Object obj) {
            HuobiToastUtil.v(SwapTradeBaseFragment.this.getString(R.string.market_add_collection_success));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(aj.b bVar) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            SwapTradeBaseFragment.this.P.dismiss();
            int e11 = bVar.e();
            if (e11 != 0) {
                boolean z11 = false;
                if (e11 == 1) {
                    FragmentActivity activity = SwapTradeBaseFragment.this.getActivity();
                    if (activity != null && (activity instanceof HuobiMainActivity)) {
                        z11 = true;
                    }
                    Intent v11 = k0.v(SwapTradeBaseFragment.this.getActivity(), z11);
                    if (!z11) {
                        v11.addFlags(67108864);
                    }
                    if (!rn.c.i().d(SwapTradeBaseFragment.this.getActivity(), new JumpTarget(v11, v11))) {
                        if (z.f().h() == null || !z.f().k()) {
                            h.c(SwapTradeBaseFragment.this.getActivity());
                        } else if (hh.f.h().l()) {
                            zn.a.d().k(SwapTradeBaseFragment.this.getActivity(), "total_balance_type_contract");
                        } else {
                            Intent c11 = k0.c(SwapTradeBaseFragment.this.getActivity());
                            Bundle bundle = new Bundle();
                            bundle.putString("total_balance_type", "total_balance_type_contract");
                            c11.putExtras(bundle);
                            SwapTradeBaseFragment.this.startActivity(c11);
                        }
                    } else {
                        return;
                    }
                } else if (e11 != 2) {
                    String str6 = "usd";
                    String str7 = "symbol";
                    if (e11 == 3) {
                        String o02 = ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).o0();
                        TradeType tradeType = TradeType.SWAP;
                        if (!a7.e.E(tradeType)) {
                            str7 = "sheet";
                        }
                        if ("cny".equals(LegalCurrencyConfigUtil.y())) {
                            str6 = "cny";
                        }
                        ContractWebActivity.Qh(SwapTradeBaseFragment.this.getActivity(), o02, str7, str6, 2);
                        is.a.j("4675", (Map<String, Object>) null, is.a.f(tradeType));
                        str = "calculator";
                    } else if (e11 == 4) {
                        ContractWebActivity.di(SwapTradeBaseFragment.this.getActivity(), 2);
                        is.a.j("4676", (Map<String, Object>) null, is.a.f(TradeType.SWAP));
                        str = "rate";
                    } else if (e11 == 6) {
                        ContractWebActivity.Oh(SwapTradeBaseFragment.this.getActivity(), 2);
                        is.a.j("4679", (Map<String, Object>) null, is.a.f(TradeType.SWAP));
                        str = "about_contracts";
                    } else if (e11 == 14) {
                        ContractWebActivity.ki(SwapTradeBaseFragment.this.getActivity(), 2);
                        gs.g.i("App_more_menu_pop_new_guide_click", (HashMap) null);
                        str = "help_center";
                    } else if (e11 == 22) {
                        BaseModuleConfig.a().l0("/contract/activityZero", true);
                        HashMap hashMap = new HashMap();
                        hashMap.put("business_category", "usdt_0_yuan_buy");
                        hashMap.put("button_name", "usdt_0_yuan");
                        gs.g.i("appclick_contracts", hashMap);
                    } else if (e11 == 17) {
                        zn.a.d().v(Uri.parse("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/Contract/CopyTrading?index=0")).c();
                    } else if (e11 != 18) {
                        switch (e11) {
                            case 8:
                                String o03 = ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).o0();
                                if (a7.e.E(TradeType.SWAP)) {
                                    str2 = str7;
                                } else {
                                    str2 = "sheet";
                                }
                                if ("cny".equals(LegalCurrencyConfigUtil.y())) {
                                    str3 = "cny";
                                } else {
                                    str3 = str6;
                                }
                                if (((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1() != null) {
                                    ContractWebActivity.Xh(SwapTradeBaseFragment.this.getActivity(), o03, str2, str3, ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1().getContractCode(), 2);
                                    break;
                                }
                                break;
                            case 9:
                                String o04 = ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).o0();
                                TradeType tradeType2 = TradeType.SWAP;
                                if (a7.e.E(tradeType2)) {
                                    str4 = str7;
                                } else {
                                    str4 = "sheet";
                                }
                                if ("cny".equals(LegalCurrencyConfigUtil.y())) {
                                    str5 = "cny";
                                } else {
                                    str5 = str6;
                                }
                                if (((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1() != null) {
                                    ContractWebActivity.Vh(SwapTradeBaseFragment.this.getActivity(), o04, str4, str5, ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1().getContractCode(), ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1().getContractShortType(), 2);
                                }
                                is.a.j("4677", (Map<String, Object>) null, is.a.f(tradeType2));
                                str = "market_information";
                                break;
                            case 10:
                                SwapTradeBaseFragment.this.N0();
                                is.a.j("4678", (Map<String, Object>) null, is.a.f(TradeType.SWAP));
                                str = "trade_limit";
                                break;
                            case 11:
                                if (((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1() != null) {
                                    String contractShortType = ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1().getContractShortType();
                                    HashMap hashMap2 = new HashMap();
                                    if (t.w(contractShortType)) {
                                        t.l(contractShortType, SwapTradeBaseFragment.this.getContext(), "CONTRACT_SWAP").compose(RxJavaHelper.t((u6.g) SwapTradeBaseFragment.this.zh())).subscribe(new b(contractShortType));
                                        hashMap2.put("type", "删除");
                                    } else {
                                        t.i(contractShortType, SwapTradeBaseFragment.this.getContext(), "CONTRACT_SWAP").compose(RxJavaHelper.t((u6.g) SwapTradeBaseFragment.this.zh())).subscribe(EasySubscriber.create(new f1(this)));
                                        hashMap2.put("type", "添加");
                                    }
                                    is.a.j("4680", hashMap2, is.a.f(TradeType.SWAP));
                                }
                                str = "add_optional";
                                break;
                            case 12:
                                ContractWebActivity.gi(SwapTradeBaseFragment.this.getActivity(), 2);
                                str = "sub_account_management";
                                break;
                        }
                    } else {
                        ContractCalmPeriodHelper.e(SwapTradeBaseFragment.this.getActivity());
                    }
                } else {
                    ContractConfigActivity.Qh(SwapTradeBaseFragment.this.getActivity(), false, "pro.huobi.swap", ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).N1().toString());
                    is.a.j("4674", (Map<String, Object>) null, is.a.f(TradeType.SWAP));
                    str = "contracts_set";
                }
                str = "";
            } else {
                SwapTradeBaseFragment.this.Ui();
                is.a.j("4673", (Map<String, Object>) null, is.a.f(TradeType.SWAP));
                str = "guarantee_assets_transfer";
            }
            if (!TextUtils.isEmpty(str)) {
                gs.g.j("contract_trade", "coin_contract", str, (HashMap) null);
            }
        }

        public void D(View view) {
            if (SwapTradeBaseFragment.this.P == null) {
                ContractTradePopDialogFragment unused = SwapTradeBaseFragment.this.P = new ContractTradePopDialogFragment();
                SwapTradeBaseFragment.this.P.xh(22, Boolean.TRUE.equals(((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).P.getValue()));
                SwapTradeBaseFragment.this.P.setTradeType(TradeType.SWAP);
                SwapTradeBaseFragment.this.P.setDialogDismissListener(new a());
                SwapTradeBaseFragment.this.P.uh(new e1(this));
            }
            boolean z11 = false;
            if (((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1() != null) {
                z11 = t.w(((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1().getContractShortType());
            }
            SwapTradeBaseFragment.this.P.zh(SwapTradeBaseFragment.this.getActivity().getSupportFragmentManager(), "popupwindow", z11);
            gs.g.j("contract_trade", "coin_contract", "menu", (HashMap) null);
        }

        public void Q(View view) {
            if (((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1() != null) {
                sn.f.I(SwapTradeBaseFragment.this.getActivity(), ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1().getContractShortType(), ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1().getContractCode(), ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1(), TradeType.SWAP);
            } else {
                HuobiToastUtil.k(j.c(), R.string.string_network_disconnect);
            }
            gs.g.j("contract_trade", "coin_contract", "Kline", (HashMap) null);
        }

        public void R(View view) {
        }

        public void a0(View view) {
        }

        public void e(View view) {
        }

        public void g0(View view, String str) {
            gs.g.j("contract_trade", "coin_contract", "grid_trading", (HashMap) null);
        }

        public void s(View view) {
            SwapCurrencyInfoDrawerItem swapCurrencyInfoDrawerItem = new SwapCurrencyInfoDrawerItem();
            swapCurrencyInfoDrawerItem.h(((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).I1());
            if (SwapTradeBaseFragment.this.getActivity() != null && (SwapTradeBaseFragment.this.getActivity() instanceof HuobiMainActivity)) {
                l.c().g(TradeType.CONTRACT, swapCurrencyInfoDrawerItem);
            } else if (SwapTradeBaseFragment.this.getActivity() != null && (SwapTradeBaseFragment.this.getActivity() instanceof FutureTradeContainerActivity)) {
                ((FutureTradeContainerActivity) SwapTradeBaseFragment.this.getActivity()).fg(TradeType.CONTRACT, swapCurrencyInfoDrawerItem);
            }
            is.a.j("4664", (Map<String, Object>) null, is.a.f(TradeType.SWAP));
            HashMap hashMap = new HashMap();
            hashMap.put("margin_type", gs.g.d());
            gs.g.j("contract_trade", "coin_contract", "switchover_coin_pair", hashMap);
        }
    }

    public class e implements ny.d {
        public e() {
        }

        public void P8(ky.j jVar) {
        }

        public void bf(ky.j jVar) {
            ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).l2();
        }
    }

    public class f extends CommonNavigatorAdapter {
        public f() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (i11 == SwapTradeBaseFragment.this.f81719n) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            SwapTradeBaseFragment swapTradeBaseFragment = SwapTradeBaseFragment.this;
            swapTradeBaseFragment.pi(swapTradeBaseFragment.f81729x, i11);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            if (SwapTradeBaseFragment.this.O == null) {
                return 0;
            }
            return SwapTradeBaseFragment.this.O.size();
        }

        public q10.b getIndicator(Context context) {
            return null;
        }

        public q10.c getTitleView(Context context, int i11) {
            TradeBuySellView tradeBuySellView = new TradeBuySellView(context);
            tradeBuySellView.setTextSize(1, 14.0f);
            tradeBuySellView.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            tradeBuySellView.setText((CharSequence) SwapTradeBaseFragment.this.O.get(i11));
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
            tradeBuySellView.setOnClickListener(new g1(this, i11));
            return tradeBuySellView;
        }
    }

    public class g extends CommonNavigatorAdapter {
        public g() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (i11 == SwapTradeBaseFragment.this.e1()) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            SwapTradeBaseFragment.this.H.c(i11);
            SwapTradeBaseFragment.this.H.b(i11, 0.0f, 0);
            tc.a.d(TradeType.SWAP, i11);
            int unused = SwapTradeBaseFragment.this.V = i11;
            SwapTradeBaseFragment.this.Yi();
            SwapTradeBaseFragment.this.Vi();
            SwapTradeBaseFragment.this.Wi();
            ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).x1();
            ((SwapTradeBasePresenter) SwapTradeBaseFragment.this.yh()).P2();
            HashMap hashMap = new HashMap();
            if (i11 == 0) {
                hashMap.put("module_name", "hold_list");
            } else {
                hashMap.put("module_name", "entrust_list");
            }
            gs.g.a("contract_trade", "coin_contract", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            if (SwapTradeBaseFragment.this.I == null) {
                return 0;
            }
            return SwapTradeBaseFragment.this.I.size();
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
            colorTransitionPagerTitleView.setText((CharSequence) SwapTradeBaseFragment.this.I.get(i11));
            colorTransitionPagerTitleView.setTextSize(1, 14.0f);
            colorTransitionPagerTitleView.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            colorTransitionPagerTitleView.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
            colorTransitionPagerTitleView.setNormalColor(ContextCompat.getColor(context, R.color.baseColorSecondaryTextNew));
            colorTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.baseColorPrimaryText));
            colorTransitionPagerTitleView.setOnClickListener(new h1(this, i11));
            return colorTransitionPagerTitleView;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean Ai(View view, MotionEvent motionEvent) {
        this.U.hideKeyboard();
        return false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bi(CompoundButton compoundButton, boolean z11) {
        this.E.setVisibility(z11 ? 8 : 0);
        qk.o0.c(z11);
        ((SwapTradeBasePresenter) yh()).u3();
        is.a.j("5149", (Map<String, Object>) null, is.a.f(TradeType.SWAP));
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ci(CompoundButton compoundButton, boolean z11) {
        qk.o0.d(z11);
        ((SwapTradeBasePresenter) yh()).P2();
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Di(View view) {
        Pi(1);
        Ti("plan_entrust");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ei(View view) {
        Pi(2);
        Ti("stop_surplus_loss");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fi(View view) {
        Pi(3);
        Ti("tracking_entrust");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gi(HashMap hashMap, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ((SwapTradeBasePresenter) yh()).n2(hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hi(boolean z11) {
        int i11 = 8;
        if (qk.o0.a()) {
            this.E.setVisibility(8);
            return;
        }
        TextView textView = this.E;
        if (z11) {
            i11 = 0;
        }
        textView.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ii(boolean z11) {
        int i11;
        if (a7.e.E(TradeType.SWAP)) {
            i11 = i.a().b().m(((SwapTradeBasePresenter) yh()).o0());
        } else {
            i11 = i.a().b().j(((SwapTradeBasePresenter) yh()).o0());
        }
        ((FutureTradeFragment) getParentFragment()).di(i11);
        ((FutureTradeFragment) getParentFragment()).ci(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mi(String str, HBDialogFragment hBDialogFragment) {
        UnifyTransferActivity.Uh(getActivity(), str, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, false, (String) null, true);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ni(HBDialogFragment hBDialogFragment) {
        this.S = false;
        hBDialogFragment.sh();
        SwapCurrencyInfo j11 = SwapCurrencyInfoController.k().j();
        if (SwapHiddenInstrumentsController.c() || j11 == null) {
            getActivity().startActivity(k0.l(getActivity()));
            return;
        }
        Qi(getActivity(), j11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oi(Object obj) {
        if (obj == null ? false : ((Boolean) obj).booleanValue()) {
            if (this.f81716b0 == null) {
                View E2 = this.f81715a0.E("currency_notice.xml", getActivity(), false, (JSONObject) null);
                this.f81716b0 = E2;
                this.Z.addView(E2);
            }
            this.Z.setVisibility(0);
            return;
        }
        this.Z.setVisibility(8);
    }

    private void Pi(int i11) {
        if (this.W != i11) {
            this.W = i11;
            tc.a.e(TradeType.SWAP, i11);
            Wi();
            ((SwapTradeBasePresenter) yh()).x1();
            ((SwapTradeBasePresenter) yh()).P2();
        }
    }

    public static void Qi(Context context, SwapCurrencyInfo swapCurrencyInfo) {
        Intent v11 = k0.v(context, false);
        if (swapCurrencyInfo != null) {
            ContractUserInfoProvider.i().y(swapCurrencyInfo);
        }
        v11.setClass(context, FutureTradeContainerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("FutureTradeContainerActivity", FutureTradeFragment.class.getName());
        v11.putExtras(bundle);
        n0.b(1);
        context.startActivity(v11);
    }

    public static void Ri(Context context, SwapCurrencyInfo swapCurrencyInfo, int i11, boolean z11) {
        Intent v11 = k0.v(context, false);
        if (swapCurrencyInfo != null) {
            ContractUserInfoProvider.i().y(swapCurrencyInfo);
        }
        a7.a.b(TradeType.SWAP, i11);
        n0.b(1);
        context.startActivity(v11);
    }

    public static void Si(Context context, SwapCurrencyInfo swapCurrencyInfo, Bundle bundle) {
        Intent v11 = k0.v(context, false);
        if (swapCurrencyInfo != null) {
            ContractUserInfoProvider.i().y(swapCurrencyInfo);
        }
        v11.setClass(context, FutureTradeContainerActivity.class);
        Bundle bundle2 = new Bundle();
        bundle2.putString("FutureTradeContainerActivity", FutureTradeFragment.class.getName());
        v11.putExtras(bundle2);
        n0.b(1);
        v11.putExtras(bundle);
        context.startActivity(v11);
    }

    private void Ti(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "entrust_list");
        gs.g.j("contract_trade", "coin_contract", str, hashMap);
    }

    /* access modifiers changed from: private */
    public void Ui() {
        if (!rn.c.i().d(getActivity(), new JumpTarget((Intent) null, (Intent) null))) {
            if (z.f().h() == null) {
                HuobiToastUtil.j(R.string.contract_account_loading);
            } else if (z.f().k()) {
                String o02 = ((SwapTradeBasePresenter) yh()).o0();
                HashMap hashMap = new HashMap(1);
                hashMap.put(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(o02));
                is.a.i("4120", hashMap);
                UnifyTransferActivity.Uh(getActivity(), o02, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, false, (String) null, true);
            } else {
                h.c(getActivity());
            }
        }
    }

    /* access modifiers changed from: private */
    public void Vi() {
        boolean F0 = r.x().F0();
        ViewUtil.m(this.J, F0);
        View view = this.Y;
        boolean z11 = true;
        if (!F0 || e1() != 1) {
            z11 = false;
        }
        ViewUtil.m(view, z11);
    }

    /* access modifiers changed from: private */
    public void Wi() {
        int i11 = this.W;
        if (i11 == 1) {
            this.K.setChecked(false);
            this.L.setChecked(true);
            this.M.setChecked(false);
            this.N.setChecked(false);
        } else if (i11 == 2) {
            this.K.setChecked(false);
            this.L.setChecked(false);
            this.M.setChecked(true);
            this.N.setChecked(false);
        } else if (i11 == 3) {
            this.K.setChecked(false);
            this.L.setChecked(false);
            this.M.setChecked(false);
            this.N.setChecked(true);
        } else {
            this.K.setChecked(true);
            this.L.setChecked(false);
            this.M.setChecked(false);
            this.N.setChecked(false);
        }
    }

    private void Xi() {
        int e12 = e1();
        this.H.c(e12);
        this.H.b(e12, 0.0f, 0);
        if (e12 != this.V) {
            ((SwapTradeBasePresenter) yh()).x1();
        }
        this.V = e12;
    }

    /* access modifiers changed from: private */
    public void Yi() {
        boolean z11 = true;
        ViewUtil.m(this.f81725t, r.x().F0() && e1() == 0);
        View b11 = this.f67460i.b(R.id.order_tab_list_layout);
        if (!r.x().F0() || e1() == 0) {
            z11 = false;
        }
        ViewUtil.m(b11, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        SwapCurrencyInfo I1 = ((SwapTradeBasePresenter) yh()).I1();
        if (!(I1 == null || I1.getContractCode() == null)) {
            SwapOrderActivity.Pi(getActivity(), I1.getContractCode(), tc.a.a(TradeType.SWAP), 0);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "hold_entrust");
        gs.g.j("contract_trade", "coin_contract", TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER, hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        Pi(0);
        Ti("limited_price_entrust");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public void pi(MagicIndicator magicIndicator, int i11) {
        this.U.hideKeyboard();
        boolean z11 = false;
        if (i11 != 2 || r.x().F0()) {
            qi(i11);
            w0(true, false);
            int i12 = this.f81719n;
            if (i12 == 0) {
                this.f81728w.L0();
            } else if (i12 == 1) {
                this.f81728w.U0();
            }
            magicIndicator.c(i11);
            magicIndicator.b(i11, 0.0f, 0);
            return;
        }
        this.Q = true;
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof HuobiMainActivity)) {
            z11 = true;
        }
        Intent v11 = k0.v(getActivity(), z11);
        if (!z11) {
            v11.addFlags(67108864);
        }
        rn.c.i().d(getActivity(), new JumpTarget(v11, v11));
    }

    private void qi(int i11) {
        this.f81719n = i11;
        this.f81728w.O0(i11);
        int i12 = this.f81719n;
        if (i12 == 2) {
            this.f81728w.setViewVisibility(8);
            this.B.setVisibility(8);
            ((i1) zh()).z0(true);
            ((SwapTradeBasePresenter) yh()).u3();
            ((SwapTradeBasePresenter) yh()).F2();
            ((SwapTradeBasePresenter) yh()).b3();
            ((SwapTradeBasePresenter) yh()).k3();
            ((SwapTradeBasePresenter) yh()).h3();
            ((SwapTradeBasePresenter) yh()).j3();
        } else if (i12 == 0) {
            this.f81728w.setViewVisibility(0);
            this.B.setVisibility(0);
            if (!SwapOpenCloseController.b(((SwapTradeBasePresenter) yh()).H1())) {
                ((i1) zh()).z0(false);
            }
            ((SwapTradeBasePresenter) yh()).Z2();
            ((SwapTradeBasePresenter) yh()).c3();
            ((SwapTradeBasePresenter) yh()).P2();
        } else {
            this.f81728w.setViewVisibility(0);
            this.B.setVisibility(0);
            ((i1) zh()).z0(true);
            ((SwapTradeBasePresenter) yh()).Z2();
            ((SwapTradeBasePresenter) yh()).u3();
            ((SwapTradeBasePresenter) yh()).P2();
        }
        this.f81728w.Q0();
    }

    private void ti() {
        this.I.add(getString(R.string.n_contract_trade_position_hold));
        this.I.add(getString(R.string.n_contract_trade_open_orders));
        this.H = (CommonTextListIndicator) this.f67460i.b(R.id.order_type_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        g gVar = new g();
        commonNavigator.setAdapter(gVar);
        this.H.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
        this.H.setNavigator(commonNavigator);
        this.H.o();
        new CommonNavigator(getActivity()).setAdapter(gVar);
        Xi();
    }

    private void ui() {
        if (this.f81726u instanceof SwapTradeTogetherView) {
            MagicIndicator magicIndicator = this.f81727v.getMagicIndicator();
            this.f81729x = magicIndicator;
            magicIndicator.setVisibility(0);
            this.O.add(getString(R.string.n_contract_trade_position_open));
            this.O.add(getString(R.string.n_contract_trade_position_close));
            CommonNavigator commonNavigator = new CommonNavigator(getActivity());
            this.f81730y = commonNavigator;
            commonNavigator.setAdjustMode(true);
            this.f81730y.setAdapter(new f());
            this.f81729x.setNavigator(this.f81730y);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vi(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        MultiColorSeekBar multiColorSeekBar = (MultiColorSeekBar) this.f67460i.b(R.id.contract_seekbar_new);
        if (multiColorSeekBar != null) {
            multiColorSeekBar.correctOffsetWhenContainerOnScrolling();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wi(int i11) {
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
        DialogUtils.b0(getActivity(), getString(R.string.n_all_cancel_title), getString(i12), "", getString(R.string.n_cancel), getString(R.string.n_confirm), o0.f12469a, new ts.m0(this, hashMap));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xi(Void voidR) {
        ContractCloseAllDialog.sh().th(new q0(this)).show(getChildFragmentManager(), "");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "entrust_list");
        gs.g.j("contract_trade", "coin_contract", "all_repeal", hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yi(List list) {
        this.f81721p.setTradeActivity(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zi(Boolean bool) {
        this.f81721p.k("SwapZero", bool.booleanValue());
    }

    public void A0(int i11) {
        this.f81728w.L(8, (SwapCurrencyInfo) null);
        this.f81728w.A0(i11);
    }

    public void Ah() {
        Vi();
        this.f81723r.setOnClickListener(new c());
        this.f81721p.setOnHeadClickListener(new d());
        this.A.e0(new e());
        this.J.setOnClickListener(new x0(this));
        this.f81720o.setOnScrollChangeListener(new b1(this));
        this.f81720o.setOnTouchListener(new y0(this));
        this.D.setOnCheckedChangeListener(new z0(this));
        this.F.setOnCheckedChangeListener(new a1(this));
        this.K.setOnClickListener(new s0(this));
        this.L.setOnClickListener(new v0(this));
        this.M.setOnClickListener(new h0(this));
        this.N.setOnClickListener(new w0(this));
        dw.a.a(this.Y).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new t0(this));
        ((SwapTradeBasePresenter) yh()).N.observe(this, new i0(this));
        ((SwapTradeBasePresenter) yh()).P.observe(this, new c1(this));
    }

    public int B0() {
        return this.W;
    }

    public RecyclerView C1() {
        return this.C;
    }

    public void C2(FuturesActivityInfo futuresActivityInfo, String str) {
        SwapTopTipsLayout swapTopTipsLayout = this.G;
        if (swapTopTipsLayout != null) {
            swapTopTipsLayout.j(futuresActivityInfo, str);
        }
    }

    public void E1(int i11) {
    }

    public void E5(SwapAccountInfo swapAccountInfo) {
        ce(swapAccountInfo);
        if (!r.x().F0() || swapAccountInfo == null) {
            this.f81723r.setText("--");
            return;
        }
        if (TextUtils.isEmpty(swapAccountInfo.getMarginAvailable())) {
            swapAccountInfo.setMarginAvailable("0.0000");
        }
        try {
            this.f81723r.setText(m.q(m.a(swapAccountInfo.getMarginAvailable()), us.i.u(swapAccountInfo.getSymbol())) + swapAccountInfo.getSymbol());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void F1() {
        this.f81728w.Y0(this.f81719n);
        a4 a4Var = this.f81728w;
        a4Var.M0(a4Var.getTradePosition());
    }

    public void F3(PriceLimitInfo priceLimitInfo) {
        this.f81728w.F3(priceLimitInfo);
    }

    public void G1(int i11) {
        if (this.f81726u instanceof SwapTradeTogetherView) {
            pi(this.f81729x, i11);
        }
    }

    public void I1() {
        k.o("ContractKyc", "检查反向永续权限");
        if (z.f().h() == null || r.x().X() || !isCanBeSeen() || !ej.j.c() || !z2.c().e("OPEN_NAME") || !f81714c0) {
            return;
        }
        if (z.f().k()) {
            UserKycInfoNew o11 = KycProxy.l().o();
            if (o11 != null && o11.getAuth_info() != null && o11.getAuth_info().isNeedAgreeV2()) {
                SwapUserInfo.UserBean h11 = z.f().h();
                if (h11 == null || h11.getIsAgreeV2() != 1) {
                    HBBaseWebActivity.showWebView(getActivity(), ContractWebActivity.yh(2, ((SwapTradeBasePresenter) yh()).I1().getContractCode()), "", "", false);
                    f81714c0 = false;
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
        h.c(getActivity());
        f81714c0 = false;
    }

    public void L(int i11, SwapCurrencyInfo swapCurrencyInfo) {
        this.f81728w.L(i11, swapCurrencyInfo);
    }

    public void N0() {
        String str;
        String o02 = ((SwapTradeBasePresenter) yh()).o0();
        String str2 = a7.e.E(TradeType.SWAP) ? "symbol" : "sheet";
        if ("cny".equals(LegalCurrencyConfigUtil.y())) {
            str = "cny";
        } else {
            str = "usd";
        }
        if (((SwapTradeBasePresenter) yh()).I1() != null) {
            ContractWebActivity.hi(getActivity(), o02, str2, str, ((SwapTradeBasePresenter) yh()).I1().getContractCode(), ((SwapTradeBasePresenter) yh()).I1().getContractShortType(), 2);
        }
    }

    public void O0(String str, int i11, int i12) {
        this.f81721p.v(str, i11, i12);
    }

    public void S0() {
        SwapTopTipsLayout swapTopTipsLayout = this.G;
        if (swapTopTipsLayout != null) {
            swapTopTipsLayout.e();
        }
    }

    public int T0() {
        return tc.a.c(TradeType.SWAP);
    }

    public void U0(String str) {
        if (!ReviewManger.a()) {
            if (this.f81715a0 == null) {
                rj.b bVar = new rj.b(getContext(), FirebaseAnalytics.Param.CURRENCY);
                this.f81715a0 = bVar;
                bVar.t("openNoticeUrl", CurrencyNoticeAbility.class);
                this.f81715a0.H();
                this.f81715a0.v("visibility", new u0(this));
                if (!NightHelper.e().g()) {
                    this.f81715a0.I("setDarkMode(0)");
                } else {
                    this.f81715a0.I("setDarkMode(1)");
                }
            }
            this.f81715a0.I("currencyNoticeMessage('" + str + "','1')");
        }
    }

    public void V0(boolean z11) {
        this.S = z11;
    }

    public a4 Ye() {
        return this.f81728w;
    }

    public i6.r Z0() {
        return this.f67460i;
    }

    public void Z5(SwapCurrencyInfo swapCurrencyInfo) {
        int i11;
        String l11 = us.j.l(getActivity(), swapCurrencyInfo.getSymbol());
        this.f81721p.x(l11);
        if (getParentFragment() instanceof FutureTradeFragment) {
            int B2 = i.a().b().B(swapCurrencyInfo.getSymbol());
            TradeType tradeType = TradeType.SWAP;
            if (a7.e.E(tradeType)) {
                i11 = i.a().b().m(swapCurrencyInfo.getSymbol());
            } else {
                i11 = i.a().b().j(swapCurrencyInfo.getSymbol());
            }
            ((FutureTradeFragment) getParentFragment()).ei(l11, tradeType.toString(), swapCurrencyInfo.getContractShortType(), B2, i11);
        }
    }

    public void Zi(boolean z11) {
        if (!z11) {
            E5((SwapAccountInfo) null);
            if (this.f81719n == 2 && (this.f81726u instanceof SwapTradeTogetherView)) {
                pi(this.f81729x, 0);
            }
        } else if (this.Q && (this.f81726u instanceof SwapTradeTogetherView)) {
            pi(this.f81729x, 2);
            this.Q = false;
        }
        this.f81728w.d(z11);
    }

    public bm.a a1() {
        return new j0(this);
    }

    public void b1() {
        KycAndHasTradeDialogUtils.m(getContext());
    }

    public void c(int i11) {
        this.f81728w.c(i11);
    }

    public void c1(boolean z11) {
        this.f81728w.R0(z11);
    }

    public void d1(ContractOpenCountInfo contractOpenCountInfo) {
        List<String> list = this.I;
        if (list != null && list.size() >= 2) {
            String str = this.I.get(0);
            String str2 = this.I.get(1);
            int totalPositions = contractOpenCountInfo.getTotalPositions();
            if (totalPositions <= 0) {
                this.I.set(0, getString(R.string.n_contract_trade_position_hold));
            } else {
                List<String> list2 = this.I;
                list2.set(0, getString(R.string.n_contract_trade_position_hold) + "(" + totalPositions + ")");
            }
            int totalOrders = contractOpenCountInfo.getTotalOrders();
            if (totalOrders <= 0) {
                this.I.set(1, getString(R.string.n_contract_trade_open_orders));
            } else {
                List<String> list3 = this.I;
                list3.set(1, getString(R.string.n_contract_trade_open_orders) + "(" + totalOrders + ")");
            }
            if (!TextUtils.equals(str, this.I.get(0)) || !TextUtils.equals(str2, this.I.get(1))) {
                this.H.getNavigator().notifyDataSetChanged();
            }
        }
    }

    public int e1() {
        return tc.a.b(TradeType.SWAP);
    }

    public void f(int i11) {
        RadioButton radioButton = this.M;
        radioButton.setText(getResources().getString(R.string.n_contract_trade_trend_stop) + "(" + i11 + ")");
    }

    public void g(int i11) {
        RadioButton radioButton = this.L;
        radioButton.setText(getResources().getString(R.string.n_contract_order_type_trigger) + "(" + i11 + ")");
    }

    public void g1(int i11) {
        this.f81728w.T0(i11);
    }

    public int getPositionType() {
        return this.f81719n;
    }

    public void h(int i11) {
        RadioButton radioButton = this.K;
        radioButton.setText(getResources().getString(R.string.n_contract_order_type_limit) + "(" + i11 + ")");
    }

    public void i(int i11) {
        RadioButton radioButton = this.N;
        radioButton.setText(getResources().getString(R.string.n_contract_track_order) + "(" + i11 + ")");
    }

    public void initViews() {
        super.initViews();
        TradeType tradeType = TradeType.SWAP;
        this.V = tc.a.b(tradeType);
        this.W = tc.a.c(tradeType);
        this.f81720o = (NestedScrollView) this.f67460i.b(R.id.trade_scrollview);
        TradeHeadView tradeHeadView = (TradeHeadView) this.f67460i.b(R.id.trade_head_view);
        this.f81721p = tradeHeadView;
        tradeHeadView.setCalculatorVisibility(0);
        TopScrollView topScrollView = (TopScrollView) this.f67460i.b(R.id.funding_rate_layout);
        this.f81722q = topScrollView;
        topScrollView.setTextSize(11);
        this.K = (RadioButton) this.f67460i.b(R.id.order_tab_list_type_limit_tv);
        this.L = (RadioButton) this.f67460i.b(R.id.order_tab_list_type_trigger_tv);
        this.M = (RadioButton) this.f67460i.b(R.id.order_tab_list_type_stop_tv);
        this.N = (RadioButton) this.f67460i.b(R.id.order_tab_list_type_track_tv);
        ((RadioButton) this.f67460i.b(R.id.order_tab_list_type_time_tv)).setVisibility(8);
        this.f81723r = (TextView) this.f67460i.b(R.id.account_available_value_tv);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(getString(R.string.n_contract_trade_prediction_of_strong_parity) + "  ");
        CommonCenterImageSpan commonCenterImageSpan = new CommonCenterImageSpan((Context) getActivity(), (int) R.drawable.risk_rate_instruction);
        this.f81724s = commonCenterImageSpan;
        spannableStringBuilder.setSpan(commonCenterImageSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
        this.f81725t = this.f67460i.b(R.id.position_top_container_parent);
        this.J = this.f67460i.b(R.id.order_current_iv);
        this.Y = this.f67460i.b(R.id.order_cancel_all);
        this.A = (SmartRefreshLayout) this.f67460i.b(R.id.contract_trade_srl);
        this.f81731z = new SmartRefreshHeader(getActivity());
        this.A.i(true);
        this.A.g(false);
        this.A.V(false);
        this.A.W(false);
        this.A.j0(this.f81731z);
        this.B = this.f67460i.b(R.id.current_order_ll);
        this.C = (RecyclerView) this.f67460i.b(R.id.contract_trade_current_order_rv);
        this.D = (CheckBox) this.f67460i.b(R.id.position_show_symbol_iv);
        this.E = (TextView) this.f67460i.b(R.id.tvCloseAll);
        if (qk.o0.a()) {
            this.D.setChecked(true);
            this.E.setVisibility(8);
        } else {
            this.D.setChecked(false);
            this.E.setVisibility(0);
        }
        this.E.setOnClickListener(new a());
        CheckBox checkBox = (CheckBox) this.f67460i.b(R.id.entrust_show_symbol_iv);
        this.F = checkBox;
        checkBox.setChecked(qk.o0.b());
        SwapTopTipsLayout swapTopTipsLayout = (SwapTopTipsLayout) this.f67460i.b(R.id.id_contract_count_down_layout);
        this.G = swapTopTipsLayout;
        if (swapTopTipsLayout != null) {
            swapTopTipsLayout.setCallback(new b());
        }
        this.C.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(getActivity(), R.color.baseColorPrimarySeparator), PixelUtils.a(0.5f), false, false));
        View b11 = this.f67460i.b(R.id.trade_layout);
        this.f81726u = b11;
        if (b11 instanceof SwapTradeTogetherView) {
            this.f81727v = (SwapTradeTogetherView) b11;
            ui();
        }
        ti();
        Wi();
        E5((SwapAccountInfo) null);
        F1();
        this.U = new HuobiKeyboardHelper().attach(getActivity());
        uc.g.a(this.f67460i.b(R.id.future_trade_empty_view), getActivity());
        this.Z = (FrameLayout) this.f67460i.b(R.id.currency_notice_container);
    }

    public void j1() {
    }

    public void j2(int i11) {
        E1(i11);
        if (i11 != ((SwapTradeBasePresenter) yh()).M1()) {
            ((SwapTradeBasePresenter) yh()).s2(i11);
            if (5 != i11) {
                boolean E2 = a7.e.E(((SwapTradeBasePresenter) yh()).N1());
                boolean G2 = a7.e.G(((SwapTradeBasePresenter) yh()).N1());
                if (E2 || G2) {
                    this.X.l(0);
                    HuobiKeyboardHelper huobiKeyboardHelper = this.U;
                    if (huobiKeyboardHelper != null) {
                        huobiKeyboardHelper.hideKeyboard();
                    }
                }
            } else if (!a7.e.E(((SwapTradeBasePresenter) yh()).N1())) {
                this.X.l(1);
                HuobiKeyboardHelper huobiKeyboardHelper2 = this.U;
                if (huobiKeyboardHelper2 != null) {
                    huobiKeyboardHelper2.hideKeyboard();
                }
            }
        } else if (5 != i11) {
            boolean E3 = a7.e.E(((SwapTradeBasePresenter) yh()).N1());
            boolean G3 = a7.e.G(((SwapTradeBasePresenter) yh()).N1());
            if (E3 || G3) {
                this.X.l(0);
                HuobiKeyboardHelper huobiKeyboardHelper3 = this.U;
                if (huobiKeyboardHelper3 != null) {
                    huobiKeyboardHelper3.hideKeyboard();
                }
            }
        } else if (!a7.e.E(((SwapTradeBasePresenter) yh()).N1())) {
            this.X.l(1);
            HuobiKeyboardHelper huobiKeyboardHelper4 = this.U;
            if (huobiKeyboardHelper4 != null) {
                huobiKeyboardHelper4.hideKeyboard();
            }
        }
    }

    public void m(int i11, boolean z11) {
        ((SwapTradeBasePresenter) yh()).x3(i11);
        s1(((SwapTradeBasePresenter) yh()).o0());
        ((SwapTradeBasePresenter) yh()).v2();
        this.f81728w.J0();
        if (getParentFragment() instanceof FutureTradeFragment) {
            i6.i.b().g(new r0(this, z11), 500);
        }
    }

    public void m1() {
        if (!this.S) {
            this.S = true;
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_login_tip)).C0(getString(R.string.n_futures_not_support_hint)).P0(getString(R.string.n_known)).q0(false).Q0(new ts.k0(this)).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void n0() {
        this.f81728w.n0();
        if (this.f81726u instanceof SwapTradeTogetherView) {
            this.f81729x.getNavigator().notifyDataSetChanged();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        ContractTradePopDialogFragment contractTradePopDialogFragment = this.P;
        if (contractTradePopDialogFragment != null) {
            contractTradePopDialogFragment.dismiss();
        }
        rj.b bVar = this.f81715a0;
        if (bVar != null) {
            bVar.B();
        }
    }

    public void onFocusChange(View view, boolean z11) {
        if (z11) {
            int[] iArr = new int[2];
            if (this.f81726u instanceof SwapTradeTogetherView) {
                this.f81729x.getLocationOnScreen(iArr);
            }
            if (iArr[1] - ViewUtil.g() > this.f81721p.getHeight()) {
                this.f81720o.scrollTo(0, ((ViewUtil.g() + this.f81721p.getHeight()) + ViewUtil.g()) - 1);
                Fragment parentFragment = getParentFragment();
                if (parentFragment instanceof FutureTradeFragment) {
                    ((FutureTradeFragment) parentFragment).z8(false, true);
                }
            }
        }
    }

    public void p0(String str, String str2) {
        this.f81728w.p0(str, str2);
    }

    public void pg() {
        n1 n1Var = this.X;
        if (n1Var != null) {
            n1Var.I();
        }
    }

    public void q(String str) {
        KycAndHasTradeDialogUtils.l(getContext(), str, p0.f60410a);
    }

    public void q0() {
        si();
        this.f81728w.q0();
    }

    public void r0() {
        this.f81728w.r0();
    }

    public void ri(boolean z11) {
    }

    public void s0() {
        this.f81728w.s0();
    }

    public void s1(String str) {
        this.f81728w.Q0();
    }

    public void s2(List<TopScrollData> list, boolean z11, boolean z12) {
        this.f81722q.j(list, z11, z12);
    }

    public void setContractTradeViewController(n1 n1Var) {
        this.f81728w.setContractTradeViewController(n1Var);
        this.X = n1Var;
    }

    public void setInputPriceUpdate(boolean z11) {
        this.f81728w.setInputPriceUpdate(z11);
    }

    public void setLeverList(List<String> list) {
        this.f81728w.setLeverList(list);
    }

    public void si() {
        this.f81728w.K0();
    }

    public void t0() {
        this.f81728w.t0();
    }

    public void t1(String str) {
        KycAndHasTradeDialogUtils.n(getContext(), str, ts.n0.f60396a);
    }

    public void t3(String str) {
        if (!this.R && !this.T) {
            DialogUtils.b0(getActivity(), getString(R.string.contract_trade_no_right_dialog_title), String.format(getString(R.string.contract_trade_no_right_dialog_message), new Object[]{str.toUpperCase(Locale.US)}), "", getString(R.string.string_cancel), getString(R.string.contract_trade_no_right_dialog_positive_btn), ts.o0.f60403a, new l0(this, str));
            ConfigPreferences.n("user_config", "config_show_no_right" + str + r.x().s(), true);
        }
    }

    public void u0(boolean z11, boolean z12) {
        this.f81728w.u0(z11, z12);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            this.f81722q.g();
            Zi(r.x().F0());
            F1();
            Vi();
            this.D.setChecked(qk.o0.a());
            this.F.setChecked(qk.o0.b());
            if (this.f81719n == 2) {
                ((SwapTradeBasePresenter) yh()).F2();
            }
            if (r.x().F0()) {
                I1();
            }
            Yi();
            Xi();
            HashMap hashMap = new HashMap();
            if (this.V == 0) {
                hashMap.put("module_name", "hold_list");
            } else {
                hashMap.put("module_name", "entrust_list");
            }
            gs.g.a("contract_trade", "coin_contract", hashMap);
            ((SwapTradeBasePresenter) yh()).p2();
            ((SwapTradeBasePresenter) yh()).o2();
            return;
        }
        this.f81722q.h();
        if (getParentFragment() instanceof FutureTradeFragment) {
            ((FutureTradeFragment) getParentFragment()).w3();
        }
    }

    public void v0() {
        this.f81728w.v0();
    }

    public int v1() {
        return this.V;
    }

    public void w0(boolean z11, boolean z12) {
        this.f81728w.w0(z11, z12);
    }

    public void x0(String str) {
        this.f81728w.x0(str);
    }

    public void y0(boolean z11) {
        if (z11) {
            this.A.finishRefresh();
            this.A.setNoMoreData(false);
        }
    }

    public void y1() {
        this.f81720o.scrollTo(0, 0);
    }

    public void z0(boolean z11) {
        this.f81728w.z0(z11);
    }
}
