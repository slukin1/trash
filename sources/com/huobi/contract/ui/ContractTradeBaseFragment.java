package com.huobi.contract.ui;

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
import bj.q2;
import bj.z2;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.ability.CurrencyNoticeAbility;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.constants.ConfigConstant;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.bean.PriceLimitInfo;
import com.hbg.lib.network.contract.core.controller.ContractHiddenInstrumentsController;
import com.hbg.lib.network.contract.core.controller.ContractOpenCloseController;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UnifyKycItemState;
import com.hbg.lib.network.newkyc.bean.UnifyKycStepState;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.TopScrollView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.activity.FutureTradeContainerActivity;
import com.huobi.contract.countdown.ContractTopTipsLayout;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractCurrencyInfoDrawerItem;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.entity.FuturesActivityInfo;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.contract.presenter.ContractTradeBasePresenter;
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
import dj.a1;
import dj.b1;
import dj.c1;
import dj.d1;
import dj.e1;
import dj.f1;
import dj.g1;
import dj.h1;
import dj.i1;
import dj.j1;
import dj.j4;
import dj.k1;
import dj.k4;
import dj.l1;
import dj.m1;
import dj.n1;
import dj.o1;
import dj.p0;
import dj.p1;
import dj.q0;
import dj.r0;
import dj.s0;
import dj.t0;
import dj.u0;
import dj.v0;
import dj.w0;
import dj.x0;
import dj.y0;
import dj.z0;
import i6.k;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import pro.huobi.R;
import qk.n0;
import sn.t;
import td.i;
import tg.r;

public abstract class ContractTradeBaseFragment<P extends ContractTradeBasePresenter<V>, V extends p1> extends BaseFragment<P, V> implements p1, k4, m0<ContractAccountInfo> {

    /* renamed from: d0  reason: collision with root package name */
    public static boolean f43355d0 = true;
    public View A;
    public RecyclerView B;
    public CheckBox C;
    public TextView D;
    public CheckBox E;
    public ContractTopTipsLayout F;
    public CommonTextListIndicator G;
    public List<String> H = new ArrayList();
    public View I;
    public View J;
    public ContractTradeTogetherView K;
    public RadioButton L;
    public RadioButton M;
    public RadioButton N;
    public RadioButton O;
    public List<String> P = new ArrayList();
    public q2 Q;
    public ContractTradePopDialogFragment R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public int W;
    public int X;
    public HuobiKeyboardHelper Y;
    public View Z;

    /* renamed from: a0  reason: collision with root package name */
    public FrameLayout f43356a0;

    /* renamed from: b0  reason: collision with root package name */
    public rj.b f43357b0;

    /* renamed from: c0  reason: collision with root package name */
    public View f43358c0;

    /* renamed from: l  reason: collision with root package name */
    public final String f43359l = "coin_contract";

    /* renamed from: m  reason: collision with root package name */
    public final String f43360m = "contract_trade";

    /* renamed from: n  reason: collision with root package name */
    public int f43361n;

    /* renamed from: o  reason: collision with root package name */
    public NestedScrollView f43362o;

    /* renamed from: p  reason: collision with root package name */
    public TradeHeadView f43363p;

    /* renamed from: q  reason: collision with root package name */
    public TopScrollView f43364q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f43365r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f43366s;

    /* renamed from: t  reason: collision with root package name */
    public CommonCenterImageSpan f43367t;

    /* renamed from: u  reason: collision with root package name */
    public View f43368u;

    /* renamed from: v  reason: collision with root package name */
    public j4 f43369v;

    /* renamed from: w  reason: collision with root package name */
    public MagicIndicator f43370w;

    /* renamed from: x  reason: collision with root package name */
    public CommonNavigator f43371x;

    /* renamed from: y  reason: collision with root package name */
    public SmartRefreshHeader f43372y;

    /* renamed from: z  reason: collision with root package name */
    public SmartRefreshLayout f43373z;

    public class a implements View.OnClickListener {

        /* renamed from: com.huobi.contract.ui.ContractTradeBaseFragment$a$a  reason: collision with other inner class name */
        public class C0564a extends BaseSubscriber<Object> {
            public C0564a() {
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
            q7.a.a().contractCloseAllPosition().b().compose(RxJavaHelper.t((u6.g) ContractTradeBaseFragment.this.zh())).subscribe(new C0564a());
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            DialogUtils.b0(ContractTradeBaseFragment.this.getActivity(), ContractTradeBaseFragment.this.getString(R.string.n_contract_clear_all_position), ContractTradeBaseFragment.this.getString(R.string.n_contract_clear_all_position_content_contract_tip), "", ContractTradeBaseFragment.this.getString(R.string.n_cancel), ContractTradeBaseFragment.this.getString(R.string.n_confirm), o0.f12469a, new k1(this));
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
            ContractTradeBaseFragment.this.Wi();
            gs.g.j("contract_trade", "coin_contract", "transfer", (HashMap) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements TradeHeadView.b {

        public class a implements BaseDialogFragment.b {
            public a() {
            }

            public void onDismiss() {
                ContractTradePopDialogFragment unused = ContractTradeBaseFragment.this.R = null;
            }
        }

        public class b extends EasySubscriber<Object> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f43380b;

            public class a extends EasySubscriber<Object> {
                public a() {
                }

                public void onNext(Object obj) {
                    super.onNext(obj);
                    HuobiToastUtil.v(ContractTradeBaseFragment.this.getString(R.string.market_delete_collection_success));
                }
            }

            public b(String str) {
                this.f43380b = str;
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                boolean z11;
                if (aPIStatusErrorException == null || !"11302".equals(aPIStatusErrorException.getErrCode())) {
                    z11 = false;
                } else {
                    z11 = true;
                    t.l(this.f43380b, ContractTradeBaseFragment.this.getContext(), "PRO").compose(RxJavaHelper.t((u6.g) ContractTradeBaseFragment.this.zh())).subscribe(new a());
                }
                if (!z11) {
                    super.onFailed(aPIStatusErrorException);
                }
            }

            public void onNext(Object obj) {
                super.onNext(obj);
                HuobiToastUtil.v(ContractTradeBaseFragment.this.getString(R.string.market_delete_collection_success));
            }
        }

        public d() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(Object obj) {
            HuobiToastUtil.v(ContractTradeBaseFragment.this.getString(R.string.market_add_collection_success));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(aj.b bVar) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            ContractTradeBaseFragment.this.R.dismiss();
            int e11 = bVar.e();
            if (e11 != 0) {
                if (e11 == 1) {
                    boolean z11 = ContractTradeBaseFragment.this.getActivity() instanceof HuobiMainActivity;
                    Intent d11 = k0.d(ContractTradeBaseFragment.this.getActivity(), z11);
                    if (!z11) {
                        d11.addFlags(67108864);
                    }
                    if (!rn.c.i().d(ContractTradeBaseFragment.this.getActivity(), new JumpTarget(d11, d11))) {
                        if (ContractUserInfoProvider.i().o() == null || ContractUserInfoProvider.i().o().getActiveState() != 1) {
                            ej.c.c(ContractTradeBaseFragment.this.getActivity());
                        } else if (hh.f.h().l()) {
                            zn.a.d().k(ContractTradeBaseFragment.this.getActivity(), "total_balance_type_contract");
                        } else {
                            Intent c11 = k0.c(ContractTradeBaseFragment.this.getActivity());
                            Bundle bundle = new Bundle();
                            bundle.putString("total_balance_type", "total_balance_type_contract");
                            c11.putExtras(bundle);
                            ContractTradeBaseFragment.this.startActivity(c11);
                        }
                    } else {
                        return;
                    }
                } else if (e11 != 2) {
                    String str6 = "usd";
                    String str7 = "symbol";
                    if (e11 == 3) {
                        String o02 = ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).o0();
                        TradeType tradeType = TradeType.CONTRACT;
                        if (!a7.e.E(tradeType)) {
                            str7 = "sheet";
                        }
                        if ("cny".equals(LegalCurrencyConfigUtil.y())) {
                            str6 = "cny";
                        }
                        ContractWebActivity.Ph(ContractTradeBaseFragment.this.getActivity(), o02, str7, str6);
                        is.a.j("4675", (Map<String, Object>) null, is.a.f(tradeType));
                        str = "calculator";
                    } else if (e11 == 4) {
                        ContractWebActivity.ci(ContractTradeBaseFragment.this.getActivity());
                        is.a.j("4676", (Map<String, Object>) null, is.a.f(TradeType.CONTRACT));
                        str = "rate";
                    } else if (e11 == 14) {
                        ContractWebActivity.ki(ContractTradeBaseFragment.this.getActivity(), 1);
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
                            case 6:
                                ContractWebActivity.Nh(ContractTradeBaseFragment.this.getActivity());
                                is.a.j("4679", (Map<String, Object>) null, is.a.f(TradeType.CONTRACT));
                                str = "about_contracts";
                                break;
                            case 7:
                                String o03 = ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).o0();
                                if (a7.e.E(TradeType.CONTRACT)) {
                                    str2 = str7;
                                } else {
                                    str2 = "sheet";
                                }
                                if ("cny".equals(LegalCurrencyConfigUtil.y())) {
                                    str3 = "cny";
                                } else {
                                    str3 = str6;
                                }
                                if (((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1() != null) {
                                    ContractWebActivity.Yh(ContractTradeBaseFragment.this.getActivity(), o03, str2, str3, ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1().getContractCode(), ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1().getContractShortType());
                                    break;
                                }
                                break;
                            case 8:
                                String o04 = ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).o0();
                                if (!a7.e.E(TradeType.CONTRACT)) {
                                    str7 = "sheet";
                                }
                                if ("cny".equals(LegalCurrencyConfigUtil.y())) {
                                    str6 = "cny";
                                }
                                if (((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1() != null) {
                                    ContractWebActivity.Wh(ContractTradeBaseFragment.this.getActivity(), o04, str7, str6, ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1().getContractCode());
                                    break;
                                }
                                break;
                            case 9:
                                String o05 = ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).o0();
                                TradeType tradeType2 = TradeType.CONTRACT;
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
                                if (((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1() != null) {
                                    ContractWebActivity.Vh(ContractTradeBaseFragment.this.getActivity(), o05, str4, str5, ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1().getContractCode(), ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1().getContractShortType(), 1);
                                }
                                is.a.j("4677", (Map<String, Object>) null, is.a.f(tradeType2));
                                str = "market_information";
                                break;
                            case 10:
                                ContractTradeBaseFragment.this.N0();
                                is.a.j("4678", (Map<String, Object>) null, is.a.f(TradeType.CONTRACT));
                                str = "trade_limit";
                                break;
                            case 11:
                                if (((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1() != null) {
                                    String contractShortType = ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1().getContractShortType();
                                    HashMap hashMap2 = new HashMap();
                                    if (t.w(contractShortType)) {
                                        t.l(contractShortType, ContractTradeBaseFragment.this.getContext(), "CONTRACT").compose(RxJavaHelper.t((u6.g) ContractTradeBaseFragment.this.zh())).subscribe(new b(contractShortType));
                                        hashMap2.put("type", "删除");
                                    } else {
                                        t.i(contractShortType, ContractTradeBaseFragment.this.getContext(), "CONTRACT").compose(RxJavaHelper.t((u6.g) ContractTradeBaseFragment.this.zh())).subscribe(EasySubscriber.create(new m1(this)));
                                        hashMap2.put("type", "添加");
                                    }
                                    is.a.j("4680", hashMap2, is.a.f(TradeType.CONTRACT));
                                }
                                str = "add_optional";
                                break;
                            case 12:
                                ContractWebActivity.gi(ContractTradeBaseFragment.this.getActivity(), 1);
                                str = "sub_account_management";
                                break;
                        }
                    } else {
                        ContractCalmPeriodHelper.e(ContractTradeBaseFragment.this.getActivity());
                    }
                } else {
                    FragmentActivity activity = ContractTradeBaseFragment.this.getActivity();
                    TradeType tradeType3 = TradeType.CONTRACT;
                    ContractConfigActivity.Qh(activity, false, "pro.huobi.contract", tradeType3.toString());
                    is.a.j("4674", (Map<String, Object>) null, is.a.f(tradeType3));
                    str = "contracts_set";
                }
                str = "";
            } else {
                ContractTradeBaseFragment.this.Wi();
                is.a.j("4673", (Map<String, Object>) null, is.a.f(TradeType.CONTRACT));
                str = "guarantee_assets_transfer";
            }
            if (!TextUtils.isEmpty(str)) {
                gs.g.j("contract_trade", "coin_contract", str, (HashMap) null);
            }
        }

        public void D(View view) {
            if (ContractTradeBaseFragment.this.R == null) {
                ContractTradePopDialogFragment unused = ContractTradeBaseFragment.this.R = new ContractTradePopDialogFragment();
                ContractTradeBaseFragment.this.R.xh(22, Boolean.TRUE.equals(((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).N.getValue()));
                ContractTradeBaseFragment.this.R.setDialogDismissListener(new a());
                ContractTradeBaseFragment.this.R.uh(new l1(this));
            }
            boolean z11 = false;
            if (((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1() != null) {
                z11 = t.w(((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1().getContractShortType());
            }
            ContractTradeBaseFragment.this.R.zh(ContractTradeBaseFragment.this.getActivity().getSupportFragmentManager(), "popupwindow", z11);
            gs.g.j("contract_trade", "coin_contract", "menu", (HashMap) null);
        }

        public void Q(View view) {
            if (((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1() != null) {
                sn.f.z(ContractTradeBaseFragment.this.getActivity(), ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1().getContractShortType(), ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1().getContractCode(), ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1(), TradeType.CONTRACT);
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
            ContractCurrencyInfoDrawerItem contractCurrencyInfoDrawerItem = new ContractCurrencyInfoDrawerItem();
            contractCurrencyInfoDrawerItem.g(((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).F1());
            if (ContractTradeBaseFragment.this.getActivity() != null && (ContractTradeBaseFragment.this.getActivity() instanceof HuobiMainActivity)) {
                HuobiMainActivity huobiMainActivity = (HuobiMainActivity) ContractTradeBaseFragment.this.getActivity();
                l.c().g(TradeType.CONTRACT, contractCurrencyInfoDrawerItem);
            } else if (ContractTradeBaseFragment.this.getActivity() != null && (ContractTradeBaseFragment.this.getActivity() instanceof FutureTradeContainerActivity)) {
                ((FutureTradeContainerActivity) ContractTradeBaseFragment.this.getActivity()).fg(TradeType.CONTRACT, contractCurrencyInfoDrawerItem);
            }
            is.a.j("4664", (Map<String, Object>) null, is.a.f(TradeType.CONTRACT));
            gs.g.j("contract_trade", "coin_contract", "switchover_coin_pair", (HashMap) null);
        }
    }

    public class e implements ny.d {
        public e() {
        }

        public void P8(ky.j jVar) {
        }

        public void bf(ky.j jVar) {
            ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).h2();
        }
    }

    public class f extends CommonNavigatorAdapter {
        public f() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (i11 == ContractTradeBaseFragment.this.f43361n) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            ContractTradeBaseFragment contractTradeBaseFragment = ContractTradeBaseFragment.this;
            contractTradeBaseFragment.pi(contractTradeBaseFragment.f43370w, i11);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            if (ContractTradeBaseFragment.this.P == null) {
                return 0;
            }
            return ContractTradeBaseFragment.this.P.size();
        }

        public q10.b getIndicator(Context context) {
            return null;
        }

        public q10.c getTitleView(Context context, int i11) {
            TradeBuySellView tradeBuySellView = new TradeBuySellView(context);
            tradeBuySellView.setTextSize(1, 14.0f);
            tradeBuySellView.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            tradeBuySellView.setText((CharSequence) ContractTradeBaseFragment.this.P.get(i11));
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
            tradeBuySellView.setOnClickListener(new n1(this, i11));
            return tradeBuySellView;
        }
    }

    public class g extends CommonNavigatorAdapter {
        public g() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (i11 == ContractTradeBaseFragment.this.e1()) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            ContractTradeBaseFragment.this.G.c(i11);
            ContractTradeBaseFragment.this.G.b(i11, 0.0f, 0);
            tc.a.d(TradeType.CONTRACT, i11);
            int unused = ContractTradeBaseFragment.this.W = i11;
            ContractTradeBaseFragment.this.aj();
            ContractTradeBaseFragment.this.Xi();
            ContractTradeBaseFragment.this.Yi();
            ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).v1();
            ((ContractTradeBasePresenter) ContractTradeBaseFragment.this.yh()).K2();
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
            if (ContractTradeBaseFragment.this.H == null) {
                return 0;
            }
            return ContractTradeBaseFragment.this.H.size();
        }

        public q10.b getIndicator(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setColors(Integer.valueOf(ContextCompat.getColor(context, R.color.baseColorMajorTheme100)));
            linePagerIndicator.setMode(2);
            linePagerIndicator.setRoundRadius((float) PixelUtils.a(1.0f));
            linePagerIndicator.setLineWidth((float) PixelUtils.a(20.0f));
            linePagerIndicator.setLineHeight(context.getResources().getDimension(R.dimen.global_indicator_height));
            return linePagerIndicator;
        }

        public q10.c getTitleView(Context context, int i11) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setText((CharSequence) ContractTradeBaseFragment.this.H.get(i11));
            colorTransitionPagerTitleView.setTextSize(1, 14.0f);
            colorTransitionPagerTitleView.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            colorTransitionPagerTitleView.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
            colorTransitionPagerTitleView.setNormalColor(ContextCompat.getColor(context, R.color.baseColorSecondaryTextNew));
            colorTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.baseColorPrimaryText));
            colorTransitionPagerTitleView.setOnClickListener(new o1(this, i11));
            return colorTransitionPagerTitleView;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ai(CompoundButton compoundButton, boolean z11) {
        this.D.setVisibility(z11 ? 8 : 0);
        qk.o0.c(z11);
        ((ContractTradeBasePresenter) yh()).n3();
        is.a.j("5149", (Map<String, Object>) null, is.a.f(TradeType.CONTRACT));
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bi(CompoundButton compoundButton, boolean z11) {
        qk.o0.d(z11);
        ((ContractTradeBasePresenter) yh()).K2();
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean Ci(View view, MotionEvent motionEvent) {
        this.Y.hideKeyboard();
        return false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Di(View view) {
        Qi(1);
        Vi("plan_entrust");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ei(View view) {
        Qi(2);
        Vi("stop_surplus_loss");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fi(View view) {
        Qi(3);
        Vi("tracking_entrust");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gi(HashMap hashMap, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        ((ContractTradeBasePresenter) yh()).j2(hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hi(boolean z11) {
        int i11 = 8;
        if (qk.o0.a()) {
            this.D.setVisibility(8);
            return;
        }
        TextView textView = this.D;
        if (z11) {
            i11 = 0;
        }
        textView.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ii(boolean z11) {
        int i11;
        if (((ContractTradeBasePresenter) yh()).F1() != null) {
            if (a7.e.E(TradeType.CONTRACT)) {
                i11 = i.a().b().t(((ContractTradeBasePresenter) yh()).F1().getContractCode());
            } else {
                i11 = i.a().b().D(((ContractTradeBasePresenter) yh()).F1().getContractCode());
            }
            ((FutureTradeFragment) getParentFragment()).di(i11);
        }
        ((FutureTradeFragment) getParentFragment()).ci(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ji(HBDialogFragment hBDialogFragment) {
        this.Q.G("CONTRACT_OPEN_ACCOUNT_ORDER");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ki(HBDialogFragment hBDialogFragment) {
        this.Q.G("CONTRACT_OPEN_ACCOUNT_ORDER");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mi(String str, HBDialogFragment hBDialogFragment) {
        UnifyTransferActivity.Th(getActivity(), str, "4");
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ni(HBDialogFragment hBDialogFragment) {
        this.U = false;
        hBDialogFragment.sh();
        ContractCurrencyInfo p11 = ContractCurrencyUtils.p();
        if (ContractHiddenInstrumentsController.c() || p11 == null) {
            getActivity().startActivity(k0.l(getActivity()));
            return;
        }
        Ri(getActivity(), p11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oi(Object obj) {
        if (obj == null ? false : ((Boolean) obj).booleanValue()) {
            if (this.f43358c0 == null) {
                View E2 = this.f43357b0.E("currency_notice.xml", getActivity(), false, (JSONObject) null);
                this.f43358c0 = E2;
                this.f43356a0.addView(E2);
            }
            this.f43356a0.setVisibility(0);
            return;
        }
        this.f43356a0.setVisibility(8);
    }

    private void Qi(int i11) {
        if (this.X != i11) {
            this.X = i11;
            tc.a.e(TradeType.CONTRACT, i11);
            Yi();
            ((ContractTradeBasePresenter) yh()).v1();
            ((ContractTradeBasePresenter) yh()).K2();
        }
    }

    public static void Ri(Context context, ContractCurrencyInfo contractCurrencyInfo) {
        Ui(context, contractCurrencyInfo, false);
    }

    public static void Si(Context context, ContractCurrencyInfo contractCurrencyInfo, int i11, boolean z11) {
        Intent d11 = k0.d(context, false);
        a7.a.b(TradeType.CONTRACT, i11);
        if (contractCurrencyInfo != null) {
            ContractUserInfoProvider.i().x(contractCurrencyInfo);
        }
        n0.b(1);
        context.startActivity(d11);
    }

    public static void Ti(Context context, ContractCurrencyInfo contractCurrencyInfo, Bundle bundle) {
        Intent d11 = k0.d(context, false);
        if (contractCurrencyInfo != null) {
            ContractUserInfoProvider.i().x(contractCurrencyInfo);
        }
        d11.putExtras(bundle);
        n0.b(1);
        context.startActivity(d11);
    }

    public static void Ui(Context context, ContractCurrencyInfo contractCurrencyInfo, boolean z11) {
        Intent d11 = k0.d(context, z11);
        if (contractCurrencyInfo != null) {
            ContractUserInfoProvider.i().x(contractCurrencyInfo);
        }
        n0.b(1);
        context.startActivity(d11);
    }

    /* access modifiers changed from: private */
    public void Wi() {
        if (!rn.c.i().d(getActivity(), new JumpTarget((Intent) null, (Intent) null))) {
            if (ContractUserInfoProvider.i().o() == null) {
                HuobiToastUtil.j(R.string.contract_account_loading);
            } else if (ContractUserInfoProvider.i().o().getActiveState() == 1) {
                String o02 = ((ContractTradeBasePresenter) yh()).o0();
                HashMap hashMap = new HashMap(1);
                hashMap.put(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(o02));
                is.a.i("4111", hashMap);
                UnifyTransferActivity.Uh(getActivity(), o02, "4", false, (String) null, true);
            } else {
                ej.c.c(getActivity());
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        if (((ContractTradeBasePresenter) yh()).F1() != null) {
            ContractOrderActivity.Pi(getActivity(), ((ContractTradeBasePresenter) yh()).o0(), tc.a.a(TradeType.CONTRACT), ((ContractTradeBasePresenter) yh()).F1().getContractShortType(), 0);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "hold_entrust");
        gs.g.j("contract_trade", "coin_contract", TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER, hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        Qi(0);
        Vi("limited_price_entrust");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void qi(int i11) {
        this.f43361n = i11;
        this.f43369v.O0(i11);
        int i12 = this.f43361n;
        if (i12 == 2) {
            this.f43369v.setViewVisibility(8);
            this.A.setVisibility(8);
            ((p1) zh()).z0(true);
            ((ContractTradeBasePresenter) yh()).A2();
            ((ContractTradeBasePresenter) yh()).n3();
            ((ContractTradeBasePresenter) yh()).V2();
            ((ContractTradeBasePresenter) yh()).e3();
            ((ContractTradeBasePresenter) yh()).b3();
            ((ContractTradeBasePresenter) yh()).d3();
        } else if (i12 == 0) {
            this.f43369v.setViewVisibility(0);
            this.A.setVisibility(0);
            if (!ContractOpenCloseController.b(((ContractTradeBasePresenter) yh()).o0())) {
                ((p1) zh()).z0(false);
            }
            ((ContractTradeBasePresenter) yh()).T2();
            ((ContractTradeBasePresenter) yh()).W2();
            ((ContractTradeBasePresenter) yh()).K2();
        } else {
            this.f43369v.setViewVisibility(0);
            this.A.setVisibility(0);
            ((p1) zh()).z0(true);
            ((ContractTradeBasePresenter) yh()).T2();
            ((ContractTradeBasePresenter) yh()).n3();
            ((ContractTradeBasePresenter) yh()).K2();
        }
        this.f43369v.Q0();
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
        DialogUtils.b0(getActivity(), getString(R.string.n_all_cancel_title), getString(i12), "", getString(R.string.n_cancel), getString(R.string.n_confirm), o0.f12469a, new v0(this, hashMap));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xi(Void voidR) {
        ContractCloseAllDialog.sh().th(new x0(this)).show(getChildFragmentManager(), "");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "entrust_list");
        gs.g.j("contract_trade", "coin_contract", "all_repeal", hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yi(List list) {
        this.f43363p.setTradeActivity(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zi(Boolean bool) {
        this.f43363p.k("SwapZero", bool.booleanValue());
    }

    public void A0(int i11) {
        this.f43369v.Q1(8, (ContractCurrencyInfo) null);
        this.f43369v.A0(i11);
        if (i11 == 0) {
            this.f43365r.setText("");
            this.f43365r.setVisibility(4);
            return;
        }
        this.f43365r.setVisibility(0);
    }

    public void A2(List<TopScrollData> list, boolean z11, boolean z12) {
        if (list == null) {
            this.f43364q.setVisibility(8);
            this.f43365r.setVisibility(0);
            this.f43364q.h();
            return;
        }
        TopScrollView topScrollView = this.f43364q;
        topScrollView.j(list, z11, topScrollView.getVisibility() == 8);
        this.f43364q.setVisibility(0);
        this.f43365r.setVisibility(8);
    }

    public void Ag(ContractAccountInfo contractAccountInfo) {
        ce(contractAccountInfo);
        if (!r.x().F0() || contractAccountInfo == null) {
            this.f43366s.setText("--");
            return;
        }
        if (TextUtils.isEmpty(contractAccountInfo.getMarginAvailable())) {
            contractAccountInfo.setMarginAvailable("0.0000");
        }
        try {
            this.f43366s.setText(m.q(m.a(contractAccountInfo.getMarginAvailable()), ej.f.n(((ContractTradeBasePresenter) yh()).F1().getContractCode())) + contractAccountInfo.getSymbol());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void Ah() {
        Xi();
        this.f43366s.setOnClickListener(new c());
        this.f43363p.setOnHeadClickListener(new d());
        this.f43373z.e0(new e());
        this.I.setOnClickListener(new dj.o0(this));
        this.f43362o.setOnScrollChangeListener(new i1(this));
        this.C.setOnCheckedChangeListener(new h1(this));
        this.E.setOnCheckedChangeListener(new g1(this));
        this.f43362o.setOnTouchListener(new f1(this));
        this.L.setOnClickListener(new e1(this));
        this.M.setOnClickListener(new z0(this));
        this.N.setOnClickListener(new d1(this));
        this.O.setOnClickListener(new c1(this));
        dw.a.a(this.Z).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(new a1(this));
        ((ContractTradeBasePresenter) yh()).L.observe(this, new p0(this));
        ((ContractTradeBasePresenter) yh()).N.observe(this, new j1(this));
    }

    public int B0() {
        return this.X;
    }

    public RecyclerView C1() {
        return this.B;
    }

    public void C2(FuturesActivityInfo futuresActivityInfo, String str) {
        ContractTopTipsLayout contractTopTipsLayout = this.F;
        if (contractTopTipsLayout != null) {
            contractTopTipsLayout.j(futuresActivityInfo, str);
        }
    }

    public void E1(int i11) {
    }

    public void F1() {
        this.f43369v.Y0(this.f43361n);
        j4 j4Var = this.f43369v;
        j4Var.M0(j4Var.getTradePosition());
    }

    public void G1(int i11) {
        if (this.J instanceof ContractTradeTogetherView) {
            pi(this.f43370w, i11);
        }
    }

    public void I1() {
        k.o("ContractKyc", "检查合约权限");
        if (ContractUserInfoProvider.i().o() == null || r.x().X() || !isCanBeSeen() || !ej.j.c() || !z2.c().e("OPEN_NAME") || !f43355d0) {
            return;
        }
        if (ContractUserInfoProvider.i().r()) {
            UserKycInfoNew o11 = KycProxy.l().o();
            if (o11 != null && o11.getAuth_info() != null && o11.getAuth_info().isNeedAgreeV2()) {
                ContractUserInfo.UserBean o12 = ContractUserInfoProvider.i().o();
                if (o12 == null || o12.getIsAgreeV2() != 1) {
                    HBBaseWebActivity.showWebView(getActivity(), ContractWebActivity.yh(1, ((ContractTradeBasePresenter) yh()).F1().getContractCode()), "", "", false);
                    f43355d0 = false;
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
        ej.c.c(getActivity());
        f43355d0 = false;
    }

    public void J1(long j11) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        long j12 = ConfigConstant.f68414b;
        if (j11 >= j12) {
            if (j11 % j12 != 0) {
                str5 = String.valueOf((j11 / j12) + 1);
            } else {
                str5 = String.valueOf(j11 / j12);
            }
            this.f43365r.setText(String.format(getString(R.string.n_contract_distance_delivery), new Object[]{str5, getString(R.string.contract_distance_delivery_day)}));
        } else if (j11 < j12 && j11 > Period.MIN60_MILLS) {
            long j13 = j11 / Period.MIN60_MILLS;
            if (j13 != 0) {
                str4 = String.valueOf(j13 + 1);
            } else {
                str4 = String.valueOf(j13);
            }
            this.f43365r.setText(String.format(getString(R.string.n_contract_distance_delivery), new Object[]{str4, getString(R.string.contract_distance_delivery_hour)}));
        } else if (j11 <= 0 || j11 > Period.MIN60_MILLS) {
            this.f43365r.setText(String.format(getString(R.string.n_contract_distance_delivery), new Object[]{"0", getString(R.string.contract_distance_delivery_hour)}));
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
            this.f43365r.setText(String.format(getString(R.string.contract_distance_delivery_hour_minute_seconde), new Object[]{str + ":" + str2 + ":" + str3}));
        }
        this.f43365r.setVisibility(0);
        this.f43364q.setVisibility(8);
    }

    public void K5(PriceLimitInfo priceLimitInfo) {
    }

    public void N0() {
        String str;
        String o02 = ((ContractTradeBasePresenter) yh()).o0();
        String str2 = a7.e.E(TradeType.CONTRACT) ? "symbol" : "sheet";
        if ("cny".equals(LegalCurrencyConfigUtil.y())) {
            str = "cny";
        } else {
            str = "usd";
        }
        if (((ContractTradeBasePresenter) yh()).F1() != null) {
            ContractWebActivity.hi(getActivity(), o02, str2, str, ((ContractTradeBasePresenter) yh()).F1().getContractCode(), ((ContractTradeBasePresenter) yh()).F1().getContractShortType(), 1);
        }
    }

    public void O0(String str, int i11, int i12) {
        this.f43363p.v(str, i11, i12);
    }

    public final void Pi() {
        int[] iArr = new int[2];
        if (this.J instanceof ContractTradeTogetherView) {
            this.f43370w.getLocationOnScreen(iArr);
        }
        if (iArr[1] - ViewUtil.g() > this.f43363p.getHeight()) {
            this.f43362o.scrollTo(0, ((ViewUtil.g() + this.f43363p.getHeight()) + ViewUtil.g()) - 1);
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof FutureTradeFragment) {
                ((FutureTradeFragment) parentFragment).z8(false, true);
            }
        }
    }

    public void Q1(int i11, ContractCurrencyInfo contractCurrencyInfo) {
        this.f43369v.Q1(i11, contractCurrencyInfo);
        if (i11 != 0) {
            return;
        }
        if (contractCurrencyInfo.getContractStatus() == 5 || contractCurrencyInfo.getContractStatus() == 7) {
            this.f43365r.setText(R.string.n_contract_trade_settling);
        } else if (contractCurrencyInfo.getContractStatus() == 6 || contractCurrencyInfo.getContractStatus() == 8) {
            this.f43365r.setText(R.string.n_contract_trade_delivering);
        } else if (contractCurrencyInfo.getContractStatus() == 3) {
            this.f43365r.setText("");
        } else if (contractCurrencyInfo.getContractStatus() == 9) {
            this.f43365r.setText(R.string.trade_suspend);
        }
    }

    public void S0() {
        ContractTopTipsLayout contractTopTipsLayout = this.F;
        if (contractTopTipsLayout != null) {
            contractTopTipsLayout.e();
        }
    }

    public void Sd(ContractCurrencyInfo contractCurrencyInfo) {
        int i11;
        String l11 = ej.g.l(getActivity(), contractCurrencyInfo.getSymbol(), contractCurrencyInfo.getContractCode(), contractCurrencyInfo.getContractType());
        this.f43363p.x(l11);
        if (getParentFragment() instanceof FutureTradeFragment) {
            TradeType tradeType = TradeType.CONTRACT;
            if (a7.e.E(tradeType)) {
                i11 = i.a().b().t(contractCurrencyInfo.getContractCode());
            } else {
                i11 = i.a().b().D(contractCurrencyInfo.getContractCode());
            }
            int z11 = i.a().b().z(contractCurrencyInfo.getContractCode());
            ((FutureTradeFragment) getParentFragment()).ei(l11, tradeType.toString(), contractCurrencyInfo.getContractShortType(), z11, i11);
        }
    }

    public int T0() {
        return tc.a.c(TradeType.CONTRACT);
    }

    public void U0(String str) {
        if (!ReviewManger.a()) {
            if (this.f43357b0 == null) {
                rj.b bVar = new rj.b(getContext(), FirebaseAnalytics.Param.CURRENCY);
                this.f43357b0 = bVar;
                bVar.t("openNoticeUrl", CurrencyNoticeAbility.class);
                this.f43357b0.H();
                this.f43357b0.v("visibility", new b1(this));
                if (!NightHelper.e().g()) {
                    this.f43357b0.I("setDarkMode(0)");
                } else {
                    this.f43357b0.I("setDarkMode(1)");
                }
            }
            this.f43357b0.I("currencyNoticeMessage('" + str + "','1')");
        }
    }

    public void V0(boolean z11) {
        this.U = z11;
    }

    public final void Vi(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "entrust_list");
        gs.g.j("contract_trade", "coin_contract", str, hashMap);
    }

    public j4 X2() {
        return this.f43369v;
    }

    public final void Xi() {
        boolean F0 = r.x().F0();
        ViewUtil.m(this.I, F0);
        View view = this.Z;
        boolean z11 = true;
        if (!F0 || e1() != 1) {
            z11 = false;
        }
        ViewUtil.m(view, z11);
    }

    public final void Yi() {
        int i11 = this.X;
        if (i11 == 1) {
            this.L.setChecked(false);
            this.M.setChecked(true);
            this.N.setChecked(false);
            this.O.setChecked(false);
        } else if (i11 == 2) {
            this.L.setChecked(false);
            this.M.setChecked(false);
            this.N.setChecked(true);
            this.O.setChecked(false);
        } else if (i11 == 3) {
            this.L.setChecked(false);
            this.M.setChecked(false);
            this.N.setChecked(false);
            this.O.setChecked(true);
        } else {
            this.L.setChecked(true);
            this.M.setChecked(false);
            this.N.setChecked(false);
            this.O.setChecked(false);
        }
    }

    public i6.r Z0() {
        return this.f67460i;
    }

    public final void Zi() {
        int e12 = e1();
        this.G.c(e12);
        this.G.b(e12, 0.0f, 0);
        if (e12 != this.W) {
            ((ContractTradeBasePresenter) yh()).v1();
        }
        this.W = e12;
    }

    public bm.a a1() {
        return new q0(this);
    }

    public final void aj() {
        boolean z11 = true;
        ViewUtil.m(this.f43368u, r.x().F0() && e1() == 0);
        View b11 = this.f67460i.b(R.id.order_tab_list_layout);
        if (!r.x().F0() || e1() == 0) {
            z11 = false;
        }
        ViewUtil.m(b11, z11);
    }

    public void b1() {
        KycAndHasTradeDialogUtils.m(getContext());
    }

    public void bj(boolean z11) {
        if (!z11) {
            Ag((ContractAccountInfo) null);
            if (this.f43361n == 2 && (this.J instanceof ContractTradeTogetherView)) {
                pi(this.f43370w, 0);
            }
        } else if (this.S && (this.J instanceof ContractTradeTogetherView)) {
            pi(this.f43370w, 2);
            this.S = false;
        }
        this.f43369v.d(z11);
    }

    public void c(int i11) {
        this.f43369v.c(i11);
    }

    public void c1(boolean z11) {
        this.f43369v.R0(z11);
    }

    public void d1(ContractOpenCountInfo contractOpenCountInfo) {
        List<String> list = this.H;
        if (list != null && list.size() >= 2) {
            String str = this.H.get(0);
            String str2 = this.H.get(1);
            int totalPositions = contractOpenCountInfo.getTotalPositions();
            if (totalPositions <= 0) {
                this.H.set(0, getString(R.string.n_contract_trade_position_hold));
            } else {
                List<String> list2 = this.H;
                list2.set(0, getString(R.string.n_contract_trade_position_hold) + "(" + totalPositions + ")");
            }
            int totalOrders = contractOpenCountInfo.getTotalOrders();
            if (totalOrders <= 0) {
                this.H.set(1, getString(R.string.n_contract_trade_open_orders));
            } else {
                List<String> list3 = this.H;
                list3.set(1, getString(R.string.n_contract_trade_open_orders) + "(" + totalOrders + ")");
            }
            if (!TextUtils.equals(str, this.H.get(0)) || !TextUtils.equals(str2, this.H.get(1))) {
                this.G.getNavigator().notifyDataSetChanged();
            }
        }
    }

    public int e1() {
        return tc.a.b(TradeType.CONTRACT);
    }

    public void f(int i11) {
        RadioButton radioButton = this.N;
        radioButton.setText(getResources().getString(R.string.n_contract_trade_trend_stop) + "(" + i11 + ")");
    }

    public void g(int i11) {
        RadioButton radioButton = this.M;
        radioButton.setText(getResources().getString(R.string.n_contract_order_type_trigger) + "(" + i11 + ")");
    }

    public void g1(int i11) {
        this.f43369v.T0(i11);
    }

    public int getPositionType() {
        return this.f43361n;
    }

    public void h(int i11) {
        RadioButton radioButton = this.L;
        radioButton.setText(getResources().getString(R.string.n_contract_order_type_limit) + "(" + i11 + ")");
    }

    public void i(int i11) {
        RadioButton radioButton = this.O;
        radioButton.setText(getResources().getString(R.string.n_contract_track_order) + "(" + i11 + ")");
    }

    public void initViews() {
        super.initViews();
        TradeType tradeType = TradeType.CONTRACT;
        this.W = tc.a.b(tradeType);
        this.X = tc.a.c(tradeType);
        this.f43362o = (NestedScrollView) this.f67460i.b(R.id.trade_scrollview);
        TradeHeadView tradeHeadView = (TradeHeadView) this.f67460i.b(R.id.trade_head_view);
        this.f43363p = tradeHeadView;
        tradeHeadView.setCalculatorVisibility(0);
        this.f43364q = (TopScrollView) this.f67460i.b(R.id.delivery_price_top_view);
        this.f43365r = (TextView) this.f67460i.b(R.id.delivery_date_tv);
        this.f43364q.setTextSize(11);
        this.f43366s = (TextView) this.f67460i.b(R.id.account_available_value_tv);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(getString(R.string.n_contract_trade_prediction_of_strong_parity) + "  ");
        CommonCenterImageSpan commonCenterImageSpan = new CommonCenterImageSpan((Context) getActivity(), (int) R.drawable.risk_rate_instruction);
        this.f43367t = commonCenterImageSpan;
        spannableStringBuilder.setSpan(commonCenterImageSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
        this.f43368u = this.f67460i.b(R.id.position_top_container_parent);
        this.I = this.f67460i.b(R.id.order_current_iv);
        this.Z = this.f67460i.b(R.id.order_cancel_all);
        this.f43373z = (SmartRefreshLayout) this.f67460i.b(R.id.contract_trade_srl);
        this.f43372y = new SmartRefreshHeader(getActivity());
        this.f43373z.i(true);
        this.f43373z.g(false);
        this.f43373z.V(false);
        this.f43373z.W(false);
        this.f43373z.j0(this.f43372y);
        this.A = this.f67460i.b(R.id.current_order_ll);
        this.B = (RecyclerView) this.f67460i.b(R.id.contract_trade_current_order_rv);
        this.C = (CheckBox) this.f67460i.b(R.id.position_show_symbol_iv);
        this.D = (TextView) this.f67460i.b(R.id.tvCloseAll);
        if (qk.o0.a()) {
            this.C.setChecked(true);
            this.D.setVisibility(8);
        } else {
            this.C.setChecked(false);
            this.D.setVisibility(0);
        }
        this.D.setOnClickListener(new a());
        CheckBox checkBox = (CheckBox) this.f67460i.b(R.id.entrust_show_symbol_iv);
        this.E = checkBox;
        checkBox.setChecked(qk.o0.b());
        this.L = (RadioButton) this.f67460i.b(R.id.order_tab_list_type_limit_tv);
        this.M = (RadioButton) this.f67460i.b(R.id.order_tab_list_type_trigger_tv);
        this.N = (RadioButton) this.f67460i.b(R.id.order_tab_list_type_stop_tv);
        this.O = (RadioButton) this.f67460i.b(R.id.order_tab_list_type_track_tv);
        ((RadioButton) this.f67460i.b(R.id.order_tab_list_type_time_tv)).setVisibility(8);
        ContractTopTipsLayout contractTopTipsLayout = (ContractTopTipsLayout) this.f67460i.b(R.id.id_contract_count_down_layout);
        this.F = contractTopTipsLayout;
        if (contractTopTipsLayout != null) {
            contractTopTipsLayout.setCallback(new b());
        }
        this.B.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(getActivity(), R.color.baseColorPrimarySeparator), PixelUtils.a(0.5f), false, false));
        View b11 = this.f67460i.b(R.id.trade_layout);
        this.J = b11;
        if (b11 instanceof ContractTradeTogetherView) {
            this.K = (ContractTradeTogetherView) b11;
            ui();
        }
        ti();
        Yi();
        Ag((ContractAccountInfo) null);
        F1();
        uc.g.a(this.f67460i.b(R.id.future_trade_empty_view), getActivity());
        this.Y = new HuobiKeyboardHelper().attach(getActivity());
        this.f43356a0 = (FrameLayout) this.f67460i.b(R.id.currency_notice_container);
    }

    public void j1() {
        this.f43365r.setText("--");
        this.f43365r.setVisibility(0);
        this.f43364q.setVisibility(8);
    }

    public void j2(int i11) {
        E1(i11);
        if (i11 != ((ContractTradeBasePresenter) yh()).J1()) {
            ((ContractTradeBasePresenter) yh()).o2(i11);
            if (5 != i11) {
                boolean E2 = a7.e.E(((ContractTradeBasePresenter) yh()).K1());
                boolean G2 = a7.e.G(((ContractTradeBasePresenter) yh()).K1());
                if (E2 || G2) {
                    this.Q.i(0);
                    HuobiKeyboardHelper huobiKeyboardHelper = this.Y;
                    if (huobiKeyboardHelper != null) {
                        huobiKeyboardHelper.hideKeyboard();
                    }
                }
            } else if (!a7.e.E(((ContractTradeBasePresenter) yh()).K1())) {
                this.Q.i(1);
                HuobiKeyboardHelper huobiKeyboardHelper2 = this.Y;
                if (huobiKeyboardHelper2 != null) {
                    huobiKeyboardHelper2.hideKeyboard();
                }
            }
        } else if (5 != i11) {
            boolean E3 = a7.e.E(((ContractTradeBasePresenter) yh()).K1());
            boolean G3 = a7.e.G(((ContractTradeBasePresenter) yh()).K1());
            if (E3 || G3) {
                this.Q.i(0);
                HuobiKeyboardHelper huobiKeyboardHelper3 = this.Y;
                if (huobiKeyboardHelper3 != null) {
                    huobiKeyboardHelper3.hideKeyboard();
                }
            }
        } else if (!a7.e.E(((ContractTradeBasePresenter) yh()).K1())) {
            this.Q.i(1);
            HuobiKeyboardHelper huobiKeyboardHelper4 = this.Y;
            if (huobiKeyboardHelper4 != null) {
                huobiKeyboardHelper4.hideKeyboard();
            }
        }
    }

    public void m(int i11, boolean z11) {
        ((ContractTradeBasePresenter) yh()).q3(i11);
        s1(((ContractTradeBasePresenter) yh()).o0());
        ((ContractTradeBasePresenter) yh()).r2();
        this.f43369v.J0();
        if (getParentFragment() instanceof FutureTradeFragment) {
            i6.i.b().g(new y0(this, z11), 500);
        }
    }

    public void m1() {
        if (!this.U) {
            this.U = true;
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_login_tip)).C0(getString(R.string.n_futures_not_support_hint)).P0(getString(R.string.n_known)).q0(false).Q0(new r0(this)).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void n0() {
        this.f43369v.n0();
        if (this.J instanceof ContractTradeTogetherView) {
            this.f43370w.getNavigator().notifyDataSetChanged();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        ContractTradePopDialogFragment contractTradePopDialogFragment = this.R;
        if (contractTradePopDialogFragment != null) {
            contractTradePopDialogFragment.dismiss();
        }
        rj.b bVar = this.f43357b0;
        if (bVar != null) {
            bVar.B();
        }
    }

    public void onFocusChange(View view, boolean z11) {
        if (z11) {
            Pi();
        }
    }

    public void p0(String str, String str2) {
        this.f43369v.p0(str, str2);
    }

    public final void pi(MagicIndicator magicIndicator, int i11) {
        boolean z11 = false;
        if (i11 != 2 || r.x().F0()) {
            qi(i11);
            w0(true, false);
            int i12 = this.f43361n;
            if (i12 == 0) {
                this.f43369v.L0();
            } else if (i12 == 1) {
                this.f43369v.U0();
            }
            magicIndicator.c(i11);
            magicIndicator.b(i11, 0.0f, 0);
            return;
        }
        this.S = true;
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof HuobiMainActivity)) {
            z11 = true;
        }
        Intent d11 = k0.d(getActivity(), z11);
        if (!z11) {
            d11.addFlags(67108864);
        }
        rn.c.i().d(getActivity(), new JumpTarget(d11, d11));
    }

    public void q(String str) {
        KycAndHasTradeDialogUtils.l(getContext(), str, new t0(this));
    }

    public void q0() {
        si();
        this.f43369v.q0();
    }

    public void r0() {
        this.f43369v.r0();
    }

    public void ri(boolean z11) {
    }

    public void s0() {
        this.f43369v.s0();
    }

    public void s1(String str) {
        this.f43369v.Q0();
    }

    public void setContractTradeViewController(q2 q2Var) {
        this.f43369v.setContractTradeViewController(q2Var);
        this.Q = q2Var;
    }

    public void setInputPriceUpdate(boolean z11) {
        this.f43369v.setInputPriceUpdate(z11);
    }

    public void setLeverList(List<String> list) {
        this.f43369v.setLeverList(list);
    }

    public void si() {
        this.f43369v.K0();
    }

    public void t0() {
        this.f43369v.t0();
    }

    public void t1(String str) {
        KycAndHasTradeDialogUtils.n(getContext(), str, new s0(this));
    }

    public void t3(String str) {
        if (!this.T && !this.V) {
            DialogUtils.b0(getActivity(), getString(R.string.contract_trade_no_right_dialog_title), String.format(getString(R.string.contract_trade_no_right_dialog_message), new Object[]{str.toUpperCase(Locale.US)}), "", getString(R.string.string_cancel), getString(R.string.contract_trade_no_right_dialog_positive_btn), w0.f53773a, new u0(this, str));
            ConfigPreferences.n("user_config", "config_show_no_right" + str + r.x().s(), true);
        }
    }

    public final void ti() {
        this.H.add(getString(R.string.n_contract_trade_position_hold));
        this.H.add(getString(R.string.n_contract_trade_open_orders));
        this.G = (CommonTextListIndicator) this.f67460i.b(R.id.order_type_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        g gVar = new g();
        commonNavigator.setAdapter(gVar);
        this.G.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
        this.G.setNavigator(commonNavigator);
        this.G.o();
        new CommonNavigator(getActivity()).setAdapter(gVar);
        Zi();
    }

    public void u0(boolean z11, boolean z12) {
        this.f43369v.u0(z11, z12);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            if (this.f43364q.getVisibility() == 0) {
                this.f43364q.g();
            }
            bj(r.x().F0());
            F1();
            Xi();
            this.C.setChecked(qk.o0.a());
            this.E.setChecked(qk.o0.b());
            if (this.f43361n == 2) {
                ((ContractTradeBasePresenter) yh()).A2();
            }
            aj();
            Zi();
            HashMap hashMap = new HashMap();
            if (this.W == 0) {
                hashMap.put("module_name", "hold_list");
            } else {
                hashMap.put("module_name", "entrust_list");
            }
            gs.g.a("contract_trade", "coin_contract", hashMap);
            ((ContractTradeBasePresenter) yh()).l2();
            ((ContractTradeBasePresenter) yh()).k2();
            return;
        }
        this.f43364q.h();
        if (getParentFragment() instanceof FutureTradeFragment) {
            ((FutureTradeFragment) getParentFragment()).w3();
        }
    }

    public final void ui() {
        if (this.J instanceof ContractTradeTogetherView) {
            MagicIndicator magicIndicator = this.K.getMagicIndicator();
            this.f43370w = magicIndicator;
            magicIndicator.setVisibility(0);
            this.P.add(getString(R.string.n_contract_trade_position_open));
            this.P.add(getString(R.string.n_contract_trade_position_close));
            CommonNavigator commonNavigator = new CommonNavigator(getActivity());
            this.f43371x = commonNavigator;
            commonNavigator.setAdjustMode(true);
            this.f43371x.setAdapter(new f());
            this.f43370w.setNavigator(this.f43371x);
        }
    }

    public void v0() {
        this.f43369v.v0();
    }

    public int v1() {
        return this.W;
    }

    public void w0(boolean z11, boolean z12) {
        this.f43369v.w0(z11, z12);
    }

    public void x0(String str) {
        this.f43369v.x0(str);
    }

    public void y0(boolean z11) {
        if (z11) {
            this.f43373z.finishRefresh();
            this.f43373z.setNoMoreData(false);
        }
    }

    public void y1() {
        this.f43362o.scrollTo(0, 0);
    }

    public void z0(boolean z11) {
        this.f43369v.z0(z11);
    }
}
