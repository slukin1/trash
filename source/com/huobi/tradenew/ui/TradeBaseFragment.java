package com.huobi.tradenew.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bj.o0;
import com.alibaba.verificationsdk.ui.IActivityCallback;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.alibaba.verificationsdk.ui.VerifyType;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.ui.TradeTrendView;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.clear.controller.ClearDialogConfigController;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.PrimeInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.AccountRiskInfo;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.EtpAvailableBean;
import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import com.hbg.lib.network.hbg.core.bean.RemainingAmountBean;
import com.hbg.lib.network.hbg.prime.PrimeResult;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.ClosePathFloatView;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.exchange.grid.ui.GridTradeActivity;
import com.huobi.activity.TradeContainerActivity;
import com.huobi.coupon.bean.Coupon;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.ui.CurrencySearchActivity;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.homemarket.helper.AppBarStateChangeListener;
import com.huobi.index.bean.IndexFeature;
import com.huobi.kyc.util.KycProxy;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.order.ui.TradeOrderActivity;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.trade.event.UpdateSpotMarginUiEvent;
import com.huobi.trade.helper.EtpRiskHintUtil;
import com.huobi.trade.helper.z;
import com.huobi.trade.prime.bean.AliToken;
import com.huobi.trade.prime.bean.PrimeAveragePosition;
import com.huobi.trade.ui.SpotAssetsDialogFragment;
import com.huobi.trade.ui.TradeFragment;
import com.huobi.tradenew.presenter.TradeBasePresenter;
import com.huobi.tradenew.prime.ui.ListingTransferLayout;
import com.huobi.tradenew.prime.ui.PrimeLayout;
import com.huobi.tradenew.prime.ui.PrimeLiteLayout;
import com.huobi.tradenew.ui.TradeHeadView;
import com.huobi.tradenew.ui.z0;
import com.huobi.utils.UserInfoUtil;
import com.huobi.utils.a0;
import com.huobi.utils.c1;
import com.huobi.utils.d1;
import com.huobi.utils.k0;
import com.huobi.utils.v0;
import com.huobi.view.MyNestedScrollView;
import com.huobi.view.keyboard.CustomBoardView;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.huobi.view.seekbar.MultiColorSeekBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import dt.h2;
import i6.m;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k6.b;
import k6.c;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import qt.b0;
import qt.w;
import qt.y;
import sn.t;
import tg.r;
import ut.o;

public abstract class TradeBaseFragment<P extends TradeBasePresenter<V>, V extends z0> extends BaseFragment<P, V> implements z0, com.huobi.trade.ui.j, TradeHeadView.a {
    public View A;
    public TextView B;
    public ImageView C;
    public PrimeLayout D;
    public ViewGroup E;
    public TradeTrendViewNew F;
    public l G;
    public MagicIndicator H;
    public View I;
    public ViewGroup J;
    public TextView K;
    public ImageView L;
    public TextView M;
    public CommonCheckBox N;
    public TextView O;
    public HorizontalScrollView P;
    public RadioGroup Q;
    public View R;
    public View S;
    public TextView T;
    public List<String> U = new ArrayList();
    public Map<Integer, Integer> V = new HashMap();
    public List<TextView> W = new ArrayList(3);
    public TradeFiatGuideDialogFragment X = new TradeFiatGuideDialogFragment();
    public TradeFiatGuideTwoDialogFragment Y = new TradeFiatGuideTwoDialogFragment();
    public int Z = 1;

    /* renamed from: a0  reason: collision with root package name */
    public int f83084a0 = 1;

    /* renamed from: b0  reason: collision with root package name */
    public View f83085b0;

    /* renamed from: c0  reason: collision with root package name */
    public TextView f83086c0;

    /* renamed from: d0  reason: collision with root package name */
    public View f83087d0;

    /* renamed from: e0  reason: collision with root package name */
    public TextView f83088e0;

    /* renamed from: f0  reason: collision with root package name */
    public RemainingAmountBean f83089f0;

    /* renamed from: g0  reason: collision with root package name */
    public View f83090g0;

    /* renamed from: h0  reason: collision with root package name */
    public TextView f83091h0;

    /* renamed from: i0  reason: collision with root package name */
    public TextView f83092i0;

    /* renamed from: j0  reason: collision with root package name */
    public ImageView f83093j0;

    /* renamed from: k0  reason: collision with root package name */
    public EtpAvailableBean f83094k0;

    /* renamed from: l  reason: collision with root package name */
    public int f83095l = 0;

    /* renamed from: l0  reason: collision with root package name */
    public String f83096l0 = "";

    /* renamed from: m  reason: collision with root package name */
    public int f83097m = 0;

    /* renamed from: m0  reason: collision with root package name */
    public SpotAssetsDialogFragment f83098m0;

    /* renamed from: n  reason: collision with root package name */
    public int f83099n = 0;

    /* renamed from: n0  reason: collision with root package name */
    public boolean f83100n0;

    /* renamed from: o  reason: collision with root package name */
    public RecyclerView f83101o;

    /* renamed from: p  reason: collision with root package name */
    public SmartRefreshLayout f83102p;

    /* renamed from: q  reason: collision with root package name */
    public MultiColorSeekBar f83103q;

    /* renamed from: r  reason: collision with root package name */
    public MyNestedScrollView f83104r;

    /* renamed from: s  reason: collision with root package name */
    public View f83105s;

    /* renamed from: t  reason: collision with root package name */
    public TradeTrendView f83106t;

    /* renamed from: t0  reason: collision with root package name */
    public PrimeLayout.a f83107t0 = new c();

    /* renamed from: u  reason: collision with root package name */
    public CustomBoardView f83108u;

    /* renamed from: u0  reason: collision with root package name */
    public it.a f83109u0 = new d();

    /* renamed from: v  reason: collision with root package name */
    public SmartRefreshHeader f83110v;

    /* renamed from: w  reason: collision with root package name */
    public TradeHeadView f83111w;

    /* renamed from: x  reason: collision with root package name */
    public TradeSymbolChangeDialogFragment f83112x;

    /* renamed from: y  reason: collision with root package name */
    public HBDialogFragment f83113y;

    /* renamed from: z  reason: collision with root package name */
    public HBDialogFragment f83114z;

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            Integer num = TradeBaseFragment.this.V.get(Integer.valueOf(i11));
            TradeBaseFragment.this.rj(i11, num);
            TradeBaseFragment.this.Aj(i11, num, true);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            List<String> list = TradeBaseFragment.this.U;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public q10.b getIndicator(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setColors(Integer.valueOf(ContextCompat.getColor(context, R.color.baseColorMajorTheme100)));
            linePagerIndicator.setMode(2);
            linePagerIndicator.setLineWidth((float) PixelUtils.a(20.0f));
            linePagerIndicator.setLineHeight((float) PixelUtils.a(2.0f));
            return linePagerIndicator;
        }

        public q10.c getTitleView(Context context, int i11) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setText(TradeBaseFragment.this.U.get(i11));
            colorTransitionPagerTitleView.setTextSize(1, 14.0f);
            colorTransitionPagerTitleView.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            colorTransitionPagerTitleView.setPadding(PixelUtils.a(15.0f), 0, PixelUtils.a(15.0f), 0);
            colorTransitionPagerTitleView.setNormalColor(ContextCompat.getColor(context, R.color.baseColorSecondaryText));
            colorTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.baseColorMajorTheme100));
            colorTransitionPagerTitleView.setOnClickListener(new v0(this, i11));
            if (i11 == 0) {
                TradeBaseFragment.this.W.clear();
            }
            TradeBaseFragment.this.W.add(colorTransitionPagerTitleView);
            return colorTransitionPagerTitleView;
        }
    }

    public class b extends ClickableSpan {
        public b() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                HBBaseWebActivity.showWebView(TradeBaseFragment.this.getContext(), c1.h(), "", "", false);
            } else {
                HBBaseWebActivity.showWebView(TradeBaseFragment.this.getContext(), c1.g(), "", "", false);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(bh.j.b(R.color.global_small_area_bg_color));
        }
    }

    public class c implements PrimeLayout.a {
        public c() {
        }

        public void a() {
            if (o.C().G() != null) {
                HBBaseWebActivity.showWebView(TradeBaseFragment.this.getActivity(), o.C().G().getSummary(), "", "", false);
            }
        }

        public void b() {
            if (o.C().G() != null) {
                HBBaseWebActivity.showWebView(TradeBaseFragment.this.getActivity(), o.C().G().getRules(), "", "", false);
            }
        }

        public void c() {
            sn.f.a0(TradeBaseFragment.this.getActivity());
        }

        public void d() {
            ((TradeBasePresenter) TradeBaseFragment.this.yh()).X1();
        }

        public FragmentManager e() {
            if (TradeBaseFragment.this.getActivity() != null) {
                return TradeBaseFragment.this.getActivity().getSupportFragmentManager();
            }
            return null;
        }

        public void f() {
            FragmentActivity activity = TradeBaseFragment.this.getActivity();
            rn.c.i().d(TradeBaseFragment.this.getActivity(), new JumpTarget(k0.t(TradeBaseFragment.this.getActivity(), activity != null && (activity instanceof HuobiMainActivity)), (Intent) null));
        }

        public void g() {
            ((TradeBasePresenter) TradeBaseFragment.this.yh()).x1();
        }

        public void onCloseClick() {
            o.C().w0(true);
            if (o.C().G() != null) {
                int status = o.C().G().getStatus();
                if (status == 1 || status == 2) {
                    TradeBaseFragment.this.w1();
                    return;
                }
                return;
            }
            TradeBaseFragment.this.w1();
        }
    }

    public class d implements it.a {
        public d() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d() {
            ((TradeBasePresenter) TradeBaseFragment.this.yh()).r1();
            ((TradeBasePresenter) TradeBaseFragment.this.yh()).X1();
            o.C().R();
        }

        public void b(int i11, long j11, long[] jArr) {
        }

        public void c(int i11) {
            if (o.C().G() != null && o.C().G().getStatus() == 2) {
                TradeBaseFragment.this.w1();
            }
            if (r.x().F0()) {
                o.C().s0();
            }
            i6.i.b().f(new w0(this));
        }
    }

    public class e implements ny.d {
        public e() {
        }

        public void P8(ky.j jVar) {
        }

        public void bf(ky.j jVar) {
            if (((z0) TradeBaseFragment.this.zh()).isCanBeSeen()) {
                ((TradeBasePresenter) TradeBaseFragment.this.yh()).s1();
            } else {
                TradeBaseFragment.this.y0(true);
            }
        }
    }

    public class f implements TradeTrendView.b {
        public f() {
        }

        public void a(c.a aVar) {
            if (aVar != null) {
                ((z0) TradeBaseFragment.this.zh()).u3(m.i(aVar.a(), PrecisionUtil.A(aVar.o0())));
                TradeBaseFragment tradeBaseFragment = TradeBaseFragment.this;
                tradeBaseFragment.I3(((TradeBasePresenter) tradeBaseFragment.yh()).e1());
            }
        }

        public void b(b.a aVar) {
            if (!a1.v().p0(((TradeBasePresenter) TradeBaseFragment.this.yh()).o0())) {
                return;
            }
            if (aVar.e()) {
                EtpRebalInfo b11 = x7.d.b(((TradeBasePresenter) TradeBaseFragment.this.yh()).I0());
                if (b11 != null && !TextUtils.isEmpty(b11.getEquityDeviationRate())) {
                    String Q = m.Q(b11.getEquityDeviationRate(), 2, 1);
                    new DialogUtils.b.d(TradeBaseFragment.this.getActivity()).c1(TradeBaseFragment.this.getActivity().getString(R.string.n_trade_etp_nav)).C0(String.format(Locale.ENGLISH, TradeBaseFragment.this.getActivity().getString(R.string.n_trade_etp_deviation_hint), new Object[]{a1.v().p(((TradeBasePresenter) TradeBaseFragment.this.yh()).o0()), Q})).q0(false).P0(TradeBaseFragment.this.getActivity().getString(R.string.n_known)).Q0(x0.f83554a).k0().show(TradeBaseFragment.this.getActivity().getSupportFragmentManager(), "");
                    return;
                }
                return;
            }
            new DialogUtils.b.d(TradeBaseFragment.this.getActivity()).c1(TradeBaseFragment.this.getActivity().getString(R.string.n_trade_etp_nav)).C0(String.format(Locale.ENGLISH, TradeBaseFragment.this.getActivity().getString(R.string.n_trade_etp_nav_instructions_new), new Object[]{a1.v().p(((TradeBasePresenter) TradeBaseFragment.this.yh()).o0())})).q0(false).P0(TradeBaseFragment.this.getActivity().getString(R.string.n_known)).Q0(y0.f83559a).k0().show(TradeBaseFragment.this.getActivity().getSupportFragmentManager(), "");
        }

        public void c(b.a aVar) {
            ((TradeBasePresenter) TradeBaseFragment.this.yh()).F1();
        }
    }

    public class g extends SimpleMultiPurposeListener {
        public g() {
        }

        public void onStateChanged(ky.j jVar, RefreshState refreshState, RefreshState refreshState2) {
            i6.d.j("MultiColorSeekBar", "old:" + refreshState + " new:" + refreshState2);
            if (RefreshState.None.equals(refreshState2) && TradeBaseFragment.this.f83103q != null) {
                TradeBaseFragment.this.f83103q.correctOffsetWhenContainerOnScrolling();
            }
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            sn.f.A(TradeBaseFragment.this.getActivity(), ((TradeBasePresenter) TradeBaseFragment.this.yh()).o0(), false, false, ((TradeBasePresenter) TradeBaseFragment.this.yh()).Z0(), true);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class i extends ClickableSpan {
        public i() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            HBBaseWebActivity.showWebView(TradeBaseFragment.this.getContext(), a0.p(), "", "", false);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
        }
    }

    public class j extends ClickableSpan {
        public j() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            v0.e(TradeBaseFragment.this.getActivity(), "94881242131745");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
        }
    }

    public class k implements TextWatcher {
        public k() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public static class l implements IActivityCallback {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<TradeBaseFragment> f83126a;

        /* renamed from: b  reason: collision with root package name */
        public OrderPlaceBean f83127b;

        public l(TradeBaseFragment tradeBaseFragment) {
            this.f83126a = new WeakReference<>(tradeBaseFragment);
        }

        public OrderPlaceBean a() {
            return this.f83127b;
        }

        public void b(OrderPlaceBean orderPlaceBean) {
            this.f83127b = orderPlaceBean;
        }

        public void onNotifyBackPressed() {
            TradeBaseFragment tradeBaseFragment = (TradeBaseFragment) this.f83126a.get();
            if (tradeBaseFragment != null) {
                tradeBaseFragment.nj();
            }
        }

        public void onResult(int i11, Map<String, String> map) {
            TradeBaseFragment tradeBaseFragment = (TradeBaseFragment) this.f83126a.get();
            if (tradeBaseFragment != null) {
                tradeBaseFragment.oj(i11, map);
            }
        }
    }

    private void Ai() {
        this.f83085b0 = this.f67460i.b(R.id.holding_limit_layout);
        this.f83086c0 = (TextView) this.f67460i.b(R.id.trade_spot_limit_label);
        this.f83087d0 = this.f67460i.b(R.id.trade_holding_limit_ask_icon);
        this.f83088e0 = (TextView) this.f67460i.b(R.id.trade_spot_limit_value);
        this.f83086c0.setOnClickListener(new u0(this));
    }

    private void Bi(Context context) {
        if (context != null) {
            if (o.C().f0()) {
                this.D = new PrimeLiteLayout(context);
            } else if (o.C().V()) {
                this.D = new ListingTransferLayout(context);
            } else {
                this.D = new PrimeLayout(context);
            }
            this.D.setCallback(this.f83107t0);
            ut.d.i().q(this.f83109u0);
        }
    }

    private void Ci() {
        this.A = this.f67460i.b(R.id.trade_risk_reminder_ll);
        this.B = (TextView) this.f67460i.b(R.id.trade_reminder_detail_tv);
        this.C = (ImageView) this.f67460i.b(R.id.trade_risk_reminder_tv);
    }

    private void Di() {
        this.f83106t = (TradeTrendView) this.f67460i.b(R.id.market_list_root_ll);
        this.f83105s = this.f67460i.b(R.id.order_current_iv);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ei(View view) {
        CommonCheckBox commonCheckBox = this.N;
        commonCheckBox.setChecked(!commonCheckBox.isChecked());
        y.c(this.N.isChecked());
        ((TradeBasePresenter) yh()).P1();
        if (((TradeBasePresenter) yh()).g() == 1) {
            ((TradeBasePresenter) yh()).X1();
        } else if (((TradeBasePresenter) yh()).g() == 2) {
            ((TradeBasePresenter) yh()).L1();
        } else if (((TradeBasePresenter) yh()).g() == 0) {
            ((TradeBasePresenter) yh()).c1(false, ((TradeBasePresenter) yh()).o0(), false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fi(View view) {
        this.N.performClick();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Gi(RadioGroup radioGroup, int i11) {
        if (i11 == R.id.plan_order_rb) {
            ((TradeBasePresenter) yh()).D1(2);
        } else if (i11 != R.id.tp_sl_order_rb) {
            ((TradeBasePresenter) yh()).D1(0);
        } else {
            ((TradeBasePresenter) yh()).D1(1);
        }
        ((TradeBasePresenter) yh()).O1();
        ((TradeBasePresenter) yh()).N1();
        ((TradeBasePresenter) yh()).E0();
        ((TradeBasePresenter) yh()).X1();
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hi(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        MultiColorSeekBar multiColorSeekBar = this.f83103q;
        if (multiColorSeekBar != null) {
            multiColorSeekBar.correctOffsetWhenContainerOnScrolling();
        }
        pj(nestedScrollView, i11, i12, i13, i14);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ii(Object obj) {
        ((TradeBasePresenter) yh()).r1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ji() {
        this.f83098m0 = null;
        this.f83100n0 = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ki(Void voidR) {
        AccountRiskInfo c12;
        String str;
        String str2;
        String str3;
        if (this.f83098m0 == null && this.L.getVisibility() == 0 && (c12 = h2.t1().c1()) != null) {
            String str4 = "--";
            if (m.a0(c12.getEffectiveDeposit())) {
                str = new BigDecimal(c12.getEffectiveDeposit()).setScale(2, 1).toPlainString() + " USDT";
            } else {
                str = str4;
            }
            if (m.a0(c12.getUsedDeposit())) {
                str2 = new BigDecimal(c12.getUsedDeposit()).setScale(2, 1).toPlainString() + " USDT";
            } else {
                str2 = str4;
            }
            if (m.a0(c12.getAvailableDeposit())) {
                str3 = new BigDecimal(c12.getAvailableDeposit()).setScale(2, 1).toPlainString() + " USDT";
            } else {
                str3 = str4;
            }
            if (m.a0(c12.getRiskRate())) {
                if (new BigDecimal(c12.getRiskRate()).compareTo(BigDecimal.valueOf(2)) > 0) {
                    str4 = ">200%";
                } else {
                    str4 = new BigDecimal(c12.getRiskRate()).multiply(BigDecimal.valueOf(100)).setScale(2, 5).toPlainString() + "%";
                }
            }
            SpotAssetsDialogFragment Hh = SpotAssetsDialogFragment.Hh(str4, c12.getRiskLevel(), str, str2, str3);
            this.f83098m0 = Hh;
            Hh.setDialogDismissListener(new o(this));
            this.f83098m0.show(getActivity().getSupportFragmentManager(), this.f83098m0.getClass().getName());
            this.f83100n0 = true;
            gs.g.i("App_trade_riskstatus_click", (HashMap) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mi(EditText editText) {
        int[] iArr = new int[2];
        editText.getLocationInWindow(iArr);
        if (((float) iArr[1]) > this.f83108u.getY()) {
            this.f83104r.scrollTo(0, (int) (((float) iArr[1]) - this.f83108u.getY()));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ni(int i11, EditText editText) {
        if (i11 == 1) {
            i6.i.b().g(new k0(this, editText), 50);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oi(View view) {
        int i11 = 0;
        int i12 = ((TradeBasePresenter) yh()).g() == 2 ? 1 : 0;
        if (((TradeBasePresenter) yh()).e() == 2) {
            i11 = 2;
        } else if (((TradeBasePresenter) yh()).e() == 1) {
            i11 = 1;
        }
        TradeOrderActivity.Hi(getActivity(), ((TradeBasePresenter) yh()).Z0(), (String) null, i11, i12);
        qt.h.b().e();
        rj(4, 4);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Pi(HBDialogFragment hBDialogFragment) {
        ((TradeBasePresenter) yh()).y0();
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qi(View view) {
        String str;
        if (y.b()) {
            String W2 = a1.v().W(((TradeBasePresenter) yh()).o0());
            if (((TradeBasePresenter) yh()).e() != 1) {
                str = String.format(Locale.US, getString(R.string.n_exchange_order_cancel_symbol_tip), new Object[]{W2, getString(R.string.n_order_cancel_normal_space)});
            } else {
                str = String.format(Locale.US, getString(R.string.n_exchange_order_cancel_symbol_tip), new Object[]{W2, getString(R.string.n_order_cancel_stop_space)});
            }
        } else if (((TradeBasePresenter) yh()).e() != 1) {
            str = String.format(Locale.US, getString(R.string.n_exchange_order_cancel_all_tips), new Object[]{getString(R.string.n_order_cancel_normal_space)});
        } else {
            str = String.format(Locale.US, getString(R.string.n_exchange_order_cancel_all_tips), new Object[]{getString(R.string.n_order_cancel_stop_space)});
        }
        new DialogUtils.b.d(getActivity()).C0(str).P0(getString(R.string.n_confirm)).c1(getString(R.string.n_login_tip)).Q0(new s(this)).s0(getString(R.string.n_cancel)).N0(o0.f12469a).k0().show(getActivity().getSupportFragmentManager(), "");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ti(View view) {
        String z11 = d7.k.C().z(((TradeBasePresenter) yh()).I0());
        DialogUtils.b.d c12 = new DialogUtils.b.d(getActivity()).c1(getActivity().getString(R.string.n_trade_observation_limit));
        String string = getActivity().getString(R.string.n_trade_observation_limit_hint);
        c12.C0(String.format(string, new Object[]{z11, m.m(this.f83094k0.getTotalAmount(), PrecisionUtil.z(((TradeBasePresenter) yh()).o0())) + z11})).q0(false).P0(getActivity().getString(R.string.n_known)).Q0(a0.f83362a).k0().show(getActivity().getSupportFragmentManager(), "");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Vi(View view) {
        if (this.f83089f0 != null) {
            String S0 = ((TradeBasePresenter) yh()).S0();
            String I0 = ((TradeBasePresenter) yh()).I0();
            DialogUtils.b.d c12 = new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_trade_observation_limit_tips_title));
            c12.C0(getString(R.string.n_trade_observation_limit_hint, d7.k.C().z(I0), ((TradeBasePresenter) yh()).F0(this.f83089f0.getCurrency(), this.f83089f0.getTotalAmount(), S0) + " " + d7.k.C().z(S0))).P0(getString(R.string.n_known)).Q0(y.f83558a).k0().show(getActivity().getSupportFragmentManager(), "");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Wi(View view) {
        this.f83087d0.performClick();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void Xi(int i11, HBDialogFragment hBDialogFragment) {
        ClearDialogConfigController.g(i11);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yi(String str, int i11, HBDialogFragment hBDialogFragment) {
        HBBaseWebActivity.showWebView(getActivity(), a0.f(str), "", "", false);
        ClearDialogConfigController.g(i11);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Zi(HBDialogFragment hBDialogFragment) {
        HBBaseWebActivity.showWebView(getActivity(), d1.f(), "", "", false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bj(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        sn.f.Q(getActivity(), ((TradeBasePresenter) yh()).o0());
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void cj(View view) {
        startActivity(sn.f.p(getActivity(), Coupon.SPOT));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void dj(HBDialogFragment hBDialogFragment) {
        startActivity(sn.f.p(getActivity(), Coupon.SPOT));
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ej(boolean z11, boolean z12, String str, String str2, Boolean bool, List list, Integer num) {
        if (KycProxy.l().p() != 2) {
            if (!z11) {
                startActivity(sn.f.p(getActivity(), Coupon.SPOT));
            } else if (z12) {
                qi(new t0(this), str);
            } else {
                ri(new w(this));
            }
        } else if (!TextUtils.isEmpty(str)) {
            HuobiToastUtil.m(str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fj(HBDialogFragment hBDialogFragment) {
        ((TradeBasePresenter) yh()).w0();
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ij(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        qt.g.a().f("1");
        ((TradeBasePresenter) yh()).x0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void jj(Object obj) {
        HuobiToastUtil.v(getString(R.string.market_delete_collection_success));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void kj(Object obj) {
        HuobiToastUtil.v(getString(R.string.market_add_collection_success));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        DialogUtils.X((FragmentActivity) oa.a.g().b(), "", String.format(getString(R.string.n_trade_reminder_st_details), new Object[]{StringUtils.i(this.f83096l0)}), (String) null, getString(R.string.liquidation_instruction_dialog_ok), z.f83563a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lj(int i11) {
        switch (i11) {
            case 0:
                ui();
                return;
            case 1:
                if (r.x().F0()) {
                    CurrencySearchActivity.lj(getActivity(), "1", false);
                    return;
                }
                Intent intent = new Intent(getActivity(), CurrencySearchActivity.class);
                intent.putExtra("extra_type", "1");
                rn.c.i().d(getActivity(), new JumpTarget(intent, (Intent) null));
                return;
            case 2:
                startActivity(new Intent(getActivity(), SpotMarginConfigActivity.class));
                w.e();
                w.i();
                return;
            case 3:
                String o02 = ((TradeBasePresenter) yh()).o0();
                if (t.w(o02)) {
                    t.k(o02, getContext()).compose(RxJavaHelper.t((u6.g) zh())).subscribe(EasySubscriber.create(new n0(this)));
                } else {
                    t.h(o02, getContext()).compose(RxJavaHelper.t((u6.g) zh())).subscribe(EasySubscriber.create(new m0(this)));
                }
                w.d();
                return;
            case 4:
                HBBaseWebActivity.showWebView(getActivity(), a0.r(), "", "", false);
                return;
            case 5:
                zj();
                w.c();
                return;
            case 6:
                HBBaseWebActivity.showWebView(getActivity(), a0.l("900000741690"), (String) null, (String) null, false);
                w.a();
                return;
            case 7:
                HBBaseWebActivity.showWebView(getActivity(), a0.q(getContext()), (String) null, (String) null, false);
                w.f();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void mj(View view) {
        HBBaseWebActivity.showWebView(getActivity(), d1.f(), "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void qi(View.OnClickListener onClickListener, String str) {
        if (isCanBeSeen()) {
            TradeKycCountDownDialogFragment tradeKycCountDownDialogFragment = new TradeKycCountDownDialogFragment();
            SymbolBean J2 = a1.v().J(((TradeBasePresenter) yh()).o0(), TradeType.PRO);
            long longValue = (J2.getKycRestrictedTimeRange().longValue() + J2.getTradeOpenAt()) - y8.c.b();
            if (longValue > 0) {
                tradeKycCountDownDialogFragment.yh(longValue);
            }
            tradeKycCountDownDialogFragment.setTitle(getString(R.string.n_trade_pioneer_kyc_title));
            tradeKycCountDownDialogFragment.zh(getString(R.string.n_trade_pioneer_kyc_count_down_hint));
            tradeKycCountDownDialogFragment.xh(onClickListener);
            tradeKycCountDownDialogFragment.show(getActivity().getSupportFragmentManager(), "TradeKycCountDownDialogFragment");
        }
    }

    private void ri(DialogUtils.b.f fVar) {
        if (isCanBeSeen()) {
            new DialogUtils.b.d(getActivity()).i1(1).M0(Integer.valueOf(R.drawable.pioneer_kyc_bg)).C0(getString(R.string.n_trade_pioneer_kyc_hint)).P0(getString(R.string.n_kyc_confirm)).s0(getString(R.string.n_cancel)).Q0(fVar).N0(b0.f83368a).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    private void xj() {
        if (((TradeBasePresenter) yh()).Z0() == TradeType.MARGIN) {
            is.a.j("4302", (Map<String, Object>) null, "1000101");
        } else if (((TradeBasePresenter) yh()).Z0() == TradeType.SUPERMARGIN) {
            is.a.j("4295", (Map<String, Object>) null, "1000100");
        }
        if (getActivity() instanceof FragmentActivity) {
            SpotMarginFuncDialogFragment spotMarginFuncDialogFragment = new SpotMarginFuncDialogFragment();
            spotMarginFuncDialogFragment.zh(new f0(this));
            spotMarginFuncDialogFragment.Bh(getActivity().getSupportFragmentManager(), SpotMarginFuncDialogFragment.class.getName(), t.w(((TradeBasePresenter) yh()).o0()));
        }
    }

    private void yj() {
        if (getActivity() != null && (getActivity() instanceof HuobiMainActivity)) {
            HuobiMainActivity huobiMainActivity = (HuobiMainActivity) getActivity();
            com.huobi.main.helper.l.c().h(((TradeBasePresenter) yh()).Z0(), ((TradeBasePresenter) yh()).o0(), ((TradeBasePresenter) yh()).S0());
        } else if (getActivity() != null && (getActivity() instanceof TradeContainerActivity)) {
            ((TradeContainerActivity) getActivity()).fg(((TradeBasePresenter) yh()).Z0(), ((TradeBasePresenter) yh()).o0(), ((TradeBasePresenter) yh()).S0());
        }
    }

    private void zi() {
        this.H = (MagicIndicator) this.f67460i.b(R.id.order_type_indicator);
        yi();
        this.W.clear();
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdapter(new a());
        this.H.setNavigator(commonNavigator);
    }

    public void Ah() {
        super.Ah();
        this.f83111w.setOnHeadClickListener(this);
        this.f83111w.setOnStClickListener(new q0(this));
        this.f83102p.e0(new e());
        this.f83108u.setKeyBoardStateChangeListener(new j0(this));
        this.f83106t.setCallback(new f());
        this.f83105s.setOnClickListener(new r0(this));
        if (getActivity() instanceof HuobiMainActivity) {
            ((HuobiMainActivity) getActivity()).ji(this);
        }
        this.M.setOnClickListener(new s0(this));
        this.N.setOnClickListener(new k(this));
        this.O.setOnClickListener(new o0(this));
        this.X.Dh(new h0(this));
        this.Y.Bh(new h0(this));
        this.Q.setOnCheckedChangeListener(new l(this));
        this.f83104r.setOnScrollChangedListener(new i0(this));
        this.f83102p.c0(new g());
        we.b.l("riseFallChange", Object.class).observe(this, new m(this));
        dw.a.a(this.J).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new l0(this));
    }

    public void Aj(int i11, Integer num, boolean z11) {
        if (num != null) {
            if (!z11 || num.intValue() != ((TradeBasePresenter) yh()).g()) {
                this.H.c(i11);
                this.H.b(i11, 0.0f, 0);
                ((TradeBasePresenter) yh()).I1(num.intValue());
                int intValue = num.intValue();
                if (intValue == 0) {
                    this.F.setVisibility(8);
                    this.f83101o.setVisibility(0);
                    this.I.setVisibility(0);
                    this.J.setVisibility(0);
                    this.O.setText(getString(R.string.n_spot_margin_only_show_current_symbol));
                    ((TradeBasePresenter) yh()).M1();
                    ((TradeBasePresenter) yh()).c1(false, ((TradeBasePresenter) yh()).o0(), false);
                } else if (intValue == 1) {
                    this.F.setVisibility(8);
                    this.f83101o.setVisibility(0);
                    this.I.setVisibility(0);
                    this.J.setVisibility(8);
                    this.O.setText(getString(R.string.n_margin_show_current_symbol));
                    ((TradeBasePresenter) yh()).M1();
                    ((TradeBasePresenter) yh()).X1();
                } else if (intValue != 2) {
                    this.F.setVisibility(0);
                    this.f83101o.setVisibility(8);
                    this.I.setVisibility(8);
                    this.J.setVisibility(8);
                    ((TradeBasePresenter) yh()).M1();
                } else {
                    this.F.setVisibility(8);
                    this.f83101o.setVisibility(0);
                    this.I.setVisibility(0);
                    this.J.setVisibility(8);
                    this.O.setText(getString(R.string.n_margin_show_current_symbol));
                    this.M.setVisibility(8);
                    ((TradeBasePresenter) yh()).L1();
                }
                l1();
                J2();
                ((TradeBasePresenter) yh()).T1();
                ((TradeBasePresenter) yh()).Y1();
                ((TradeBasePresenter) yh()).E0();
            }
        }
    }

    public void B2(int i11) {
        this.Q.check(i11);
    }

    public void D(View view) {
        xj();
    }

    public void D1(int i11) {
        this.f83105s.setVisibility(i11);
    }

    public void E2() {
        HBDialogFragment hBDialogFragment = this.f83113y;
        if (hBDialogFragment != null && hBDialogFragment.th()) {
            this.f83113y.dismiss();
        }
        HBDialogFragment hBDialogFragment2 = this.f83114z;
        if (hBDialogFragment2 != null && hBDialogFragment2.th()) {
            this.f83114z.dismiss();
        }
    }

    public void E8(String str, PrimeAveragePosition primeAveragePosition) {
        PrimeLayout si2 = si();
        if (si2 != null) {
            si2.I(str, primeAveragePosition, a1.v().n(((TradeBasePresenter) yh()).o0()), a1.v().D(((TradeBasePresenter) yh()).o0()));
        }
        E3(a1.v().S(((TradeBasePresenter) yh()).o0()));
    }

    public void F2() {
        if (this.f83113y == null) {
            this.f83113y = new DialogUtils.b.d(getActivity()).c1(getString(R.string.allow_access_dialog_title)).C0(getString(R.string.n_trade_etp_evaluation_content)).Y0(getString(R.string.n_trade_etp_evaluation_introduce)).a1(new t(this)).s0(getString(R.string.global_string_cancel)).P0(getString(R.string.n_trade_etp_evaluation_start)).N0(c0.f83375a).Q0(new r(this)).k0();
        }
        if (!this.f83113y.th()) {
            this.f83113y.show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void H0(MarketCurrentPriceItem marketCurrentPriceItem) {
        if (getActivity() != null) {
            if (((TradeBasePresenter) yh()).f1()) {
                ((TradeBasePresenter) yh()).a2();
            }
            this.f83106t.setNewestPrice(marketCurrentPriceItem);
            ((TradeBasePresenter) yh()).b2();
        }
    }

    public void H2(RemainingAmountBean remainingAmountBean) {
        this.f83089f0 = remainingAmountBean;
        if (remainingAmountBean != null) {
            ViewUtil.m(this.f83087d0, true);
            String S0 = ((TradeBasePresenter) yh()).S0();
            TextView textView = this.f83088e0;
            textView.setText(((TradeBasePresenter) yh()).F0(this.f83089f0.getCurrency(), this.f83089f0.getRemainingAmount(), S0) + " " + d7.k.C().z(S0));
            return;
        }
        ViewUtil.m(this.f83087d0, false);
        tj();
    }

    public void J2() {
        this.S.setVisibility(8);
    }

    public void K2(String str, String str2, int i11) {
        HBDialogFragment hBDialogFragment = this.f83114z;
        if (hBDialogFragment == null || !hBDialogFragment.isAdded()) {
            DialogUtils.b.d Q0 = new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_trade_etp_clear_dialog_title)).C0(str2).P0(getString(R.string.n_known)).Q0(new p(i11));
            if (!TextUtils.isEmpty(str)) {
                Q0.s0(getString(R.string.n_exchange_filled_orders_tip_view_detail)).N0(new x(this, str, i11));
            }
            HBDialogFragment k02 = Q0.k0();
            this.f83114z = k02;
            k02.show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void L1(IndexFeature indexFeature) {
        b0.d().f(indexFeature);
    }

    public void L2() {
        String string = getString(R.string.n_trade_observation_license_hint);
        String string2 = getString(R.string.n_trade_observation_license_title);
        int indexOf = string.indexOf(string2);
        if (indexOf != -1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new b(), indexOf, string2.length() + indexOf, 17);
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_trade_observation_license_explain)).C0(getString(R.string.n_trade_observation_license_content)).w0(spannableStringBuilder).t0(true).s0(getString(R.string.n_cancel)).P0(getString(R.string.n_confirm)).N0(e0.f83388a).Q0(new u(this)).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void N1() {
        if (isCanBeSeen()) {
            new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_trade_pioneer_price_fluctuation_hint)).P0(getString(R.string.n_known)).c1(getString(R.string.n_trade_observation_license_explain)).Q0(new q(this)).q0(false).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void Nd(AppBarStateChangeListener.State state) {
        i6.d.j("MultiColorSeekBar", "AppBar滑动状态更新");
        MultiColorSeekBar multiColorSeekBar = this.f83103q;
        if (multiColorSeekBar != null) {
            multiColorSeekBar.correctOffsetWhenContainerOnScrolling();
        }
    }

    public void O1(String str, TradeType tradeType) {
        this.f83111w.w(a1.v().X(str, tradeType));
    }

    public void O2(int i11, int i12) {
        this.f83104r.scrollTo(i11, i12);
    }

    public void Q(View view) {
        if (((TradeBasePresenter) yh()).Z0() == TradeType.MARGIN) {
            is.a.j("5975", (Map<String, Object>) null, "1000101");
        } else if (((TradeBasePresenter) yh()).Z0() == TradeType.SUPERMARGIN) {
            is.a.j("5975", (Map<String, Object>) null, "1000100");
        } else if (((TradeBasePresenter) yh()).Z0() == TradeType.PRO) {
            EventBus.d().k(new UpdateSpotMarginUiEvent());
        }
        qj();
    }

    public void R(View view) {
        if (this.f83112x == null) {
            this.f83112x = new TradeSymbolChangeDialogFragment();
        }
        this.f83112x.setTradeType(((TradeBasePresenter) yh()).Z0());
        this.f83112x.bc(((TradeBasePresenter) yh()).o0());
        this.f83112x.wh(((TradeBasePresenter) yh()).I0());
        this.f83112x.showAsDropDown(getFragmentManager(), view, 0, 0, 53);
    }

    public int S1() {
        return this.f83097m;
    }

    public void W1(int i11) {
        this.I.setVisibility(i11);
    }

    public boolean X5() {
        CustomBoardView customBoardView = this.f83108u;
        if (customBoardView == null || !customBoardView.keyboardVisible()) {
            return false;
        }
        this.f83108u.hideKeyboardLayout();
        return true;
    }

    public void a0(View view) {
    }

    public void b(v9.a aVar) {
        this.f83101o.setAdapter(aVar);
    }

    public int c2() {
        return this.f83099n;
    }

    public void d(boolean z11) {
        if (z11) {
            this.f83105s.setVisibility(0);
        } else {
            this.f83105s.setVisibility(8);
        }
    }

    public void d3(int i11) {
        if (((TradeBasePresenter) yh()).e() == 2) {
            this.M.setVisibility(8);
        } else {
            this.M.setVisibility(i11);
        }
    }

    public void e(View view) {
        if (a1.v().p0(((TradeBasePresenter) yh()).o0())) {
            ((TradeBasePresenter) yh()).A0(a1.v().K(EtpRiskHintUtil.c(((TradeBasePresenter) yh()).I0())));
            return;
        }
        k0.M(((TradeBasePresenter) yh()).o0(), "0", true, getActivity());
    }

    public void f3(boolean z11) {
        if (z11) {
            if (!this.X.isVisible()) {
                this.X.show(getActivity().getSupportFragmentManager(), "fiatGuideDialogFragment");
                gs.g.i("APP_Trade_fiat_expose", (HashMap) null);
            }
        } else if (!this.Y.isVisible()) {
            this.Y.show(getActivity().getSupportFragmentManager(), "fiatGuideTwoDialogFragment");
        }
    }

    public void finishRefresh() {
        PrimeLayout primeLayout = this.D;
        if (primeLayout != null) {
            primeLayout.D();
        }
    }

    public void g0(View view, String str) {
        ti(str);
    }

    public int getUiPlanTradeBuyMode() {
        return this.Z;
    }

    public int getUiPlanTradeSellMode() {
        return this.f83084a0;
    }

    public void initViews() {
        super.initViews();
        this.f83103q = (MultiColorSeekBar) this.f67460i.b(R.id.trade_new_seek_bar);
        this.f83104r = (MyNestedScrollView) this.f67460i.b(R.id.trade_scrollview);
        this.f83102p = (SmartRefreshLayout) this.f67460i.b(R.id.tradePtrFrame);
        this.f83111w = (TradeHeadView) this.f67460i.b(R.id.trade_head_view);
        RecyclerView recyclerView = (RecyclerView) this.f67460i.b(R.id.spotRv);
        this.f83101o = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f83101o.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(getActivity(), R.color.baseColorPrimarySeparator), PixelUtils.a(0.5f), false, PixelUtils.a(15.0f), PixelUtils.a(15.0f)));
        FrameLayout frameLayout = (FrameLayout) getActivity().findViewById(16908290);
        int childCount = frameLayout.getChildCount();
        if (childCount > 0) {
            View childAt = frameLayout.getChildAt(childCount - 1);
            if (childAt == null || !(childAt instanceof CustomBoardView)) {
                CustomBoardView customBoardView = new CustomBoardView(getActivity());
                this.f83108u = customBoardView;
                customBoardView.setGravity(80);
                this.f83108u.setVisibility(8);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                frameLayout.addView(this.f83108u, layoutParams);
            } else {
                this.f83108u = (CustomBoardView) childAt;
            }
        }
        Di();
        Ci();
        Ai();
        vj();
        zi();
        wi();
        L1(b0.d().c());
        this.I = this.f67460i.b(R.id.trade_cancel_all_container);
        this.J = (ViewGroup) this.f67460i.b(R.id.clyt_spot_account_risk_info);
        this.K = (TextView) this.f67460i.b(R.id.tv_spot_account_risk_status);
        this.L = (ImageView) this.f67460i.b(R.id.iv_spot_account_risk_arrow);
        this.M = (TextView) this.f67460i.b(R.id.trade_cancel_all_tv);
        CommonCheckBox commonCheckBox = (CommonCheckBox) this.f67460i.b(R.id.trade_show_current_iv);
        this.N = commonCheckBox;
        commonCheckBox.setChecked(y.b());
        this.O = (TextView) this.f67460i.b(R.id.trade_show_current_tv);
        this.P = (HorizontalScrollView) this.f67460i.b(R.id.order_tab_sv);
        this.Q = (RadioGroup) this.f67460i.b(R.id.order_tab_rg);
        this.R = this.f67460i.b(R.id.order_tab_divider);
        this.S = this.f67460i.b(R.id.trade_hold_label_container);
        TextView textView = (TextView) this.f67460i.b(R.id.trade_hold_volume_label_tv);
        this.T = textView;
        textView.setText(String.format(Locale.ENGLISH, getString(R.string.n_trade_total_accounted2), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
    }

    public void j3(OrderPlaceBean orderPlaceBean, AliToken aliToken) {
        if (this.G == null) {
            this.G = new l(this);
        }
        orderPlaceBean.setAliToken(aliToken);
        this.G.b(orderPlaceBean);
        VerifyActivity.startSimpleVerifyUI(getActivity(), VerifyType.NOCAPTCHA, "0335", (String) null, this.G);
    }

    public void k3() {
        if (isCanBeSeen()) {
            new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_trade_pioneer_black_country_hint)).P0(getString(R.string.n_known)).c1(getString(R.string.n_option_delivery_tip)).Q0(d0.f83382a).q0(false).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void l1() {
        if (!r.x().F0()) {
            this.P.setVisibility(8);
            this.R.setVisibility(8);
        } else if (((TradeBasePresenter) yh()).g() != 1 || a1.v().s0(((TradeBasePresenter) yh()).o0())) {
            this.P.setVisibility(8);
            this.R.setVisibility(8);
        } else {
            this.P.setVisibility(0);
            this.R.setVisibility(0);
        }
    }

    public void l2(String str) {
    }

    public void m5(PrimeResult primeResult) {
        PrimeLayout primeLayout = this.D;
        if (primeLayout != null) {
            primeLayout.T((ViewGroup) this.f67460i.b(R.id.trade_spot_content_parent), primeResult);
        }
        if (primeResult != null && primeResult.isFinished()) {
            ((TradeBasePresenter) yh()).X1();
        }
    }

    public void nj() {
    }

    public void o3(int i11, int i12) {
        int i13 = i12;
        SymbolBean J2 = a1.v().J(((TradeBasePresenter) yh()).o0(), ((TradeBasePresenter) yh()).Z0());
        this.f83096l0 = "";
        if (J2 != null) {
            this.f83096l0 = J2.getBaseCurrencyDisplayName();
        }
        if (i13 == 0) {
            this.C.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_normal);
            this.B.setText(String.format(getString(R.string.trade_reminder_had_details), new Object[]{StringUtils.i(this.f83096l0)}));
            this.B.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
            this.f83111w.setReminderTvVisible(false);
            this.A.setBackgroundResource(R.drawable.shape_trade_risk_reminder_blue_bg);
        } else if (i13 == 1) {
            this.C.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_risk);
            this.B.setText(String.format(getString(R.string.n_trade_reminder_st_details), new Object[]{StringUtils.i(this.f83096l0)}));
            this.B.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorShadeButtonRedStart));
            ContextCompat.getColor(getActivity(), R.color.baseColorShadeButtonRedEnd);
            this.f83111w.setReminderBg(R.drawable.market_st);
            this.f83111w.setReminderTvVisible(true);
            this.A.setBackgroundResource(R.drawable.shape_trade_risk_reminder_red_bg);
        } else if (i13 == 2) {
            this.C.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_normal);
            this.B.setText(String.format(getString(R.string.trade_reminder_detail_text), new Object[]{StringUtils.i(this.f83096l0)}));
            this.B.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
            this.f83111w.setReminderTvVisible(false);
            this.A.setBackgroundResource(R.drawable.shape_trade_risk_reminder_blue_bg);
        } else if (i13 == 4) {
            if (J2 != null) {
                EtpRebalInfo b11 = x7.d.b(J2.getBaseCurrency());
                Context context = getContext();
                String baseCurrencyDisplayName = J2.getBaseCurrencyDisplayName();
                String i14 = StringUtils.i(EtpRiskHintUtil.c(J2.getBaseCurrency()));
                String i15 = StringUtils.i(J2.getQuoteCurrency());
                String x11 = ((TradeBasePresenter) yh()).M0().x();
                double z11 = ((TradeBasePresenter) yh()).M0().z();
                int e11 = PrecisionUtil.e(J2.getSymbol());
                g0 g0Var = new g0(this);
                SpannableStringBuilder f11 = EtpRiskHintUtil.f(b11, context, baseCurrencyDisplayName, i14, i15, x11, z11, e11, g0Var, new h(), J2.getEtpLeverageRatio(), true, false);
                this.C.setBackgroundResource(EtpRiskHintUtil.g());
                this.B.setText(f11);
                this.B.setMovementMethod(LinkMovementMethod.getInstance());
                this.B.setHighlightColor(ContextCompat.getColor(getActivity(), 17170445));
                this.A.setBackgroundResource(EtpRiskHintUtil.e());
            }
            this.f83111w.setReminderTvVisible(false);
        } else if (i13 == 5) {
            this.C.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_normal);
            String string = getString(R.string.n_trade_observation_warning_hint);
            String string2 = getString(R.string.n_trade_observation_warning_more);
            int indexOf = string.toLowerCase().indexOf(string2.toLowerCase());
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            if (indexOf != -1) {
                spannableStringBuilder.setSpan(new i(), indexOf, string2.length() + indexOf, 17);
                spannableStringBuilder.setSpan(new UnderlineSpan(), indexOf, string2.length() + indexOf, 17);
            }
            this.B.setMovementMethod(LinkMovementMethod.getInstance());
            this.B.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
            this.B.setText(spannableStringBuilder);
            this.A.setBackgroundResource(R.drawable.shape_trade_risk_reminder_blue_bg);
            this.f83111w.setReminderTvVisible(false);
        } else if (i13 != 6) {
            this.f83111w.setReminderTvVisible(false);
        } else {
            this.C.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_normal);
            String string3 = getString(R.string.n_trade_pioneer_warning_hint);
            String string4 = getString(R.string.n_trade_observation_warning_more);
            int indexOf2 = string3.toLowerCase().indexOf(string4.toLowerCase());
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string3);
            if (indexOf2 != -1) {
                spannableStringBuilder2.setSpan(new j(), indexOf2, string4.length() + indexOf2, 17);
                spannableStringBuilder2.setSpan(new UnderlineSpan(), indexOf2, string4.length() + indexOf2, 17);
            }
            this.B.setMovementMethod(LinkMovementMethod.getInstance());
            this.B.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
            this.B.setText(spannableStringBuilder2);
            this.A.setBackgroundResource(R.drawable.shape_trade_risk_reminder_blue_bg);
            this.f83111w.setReminderTvVisible(false);
        }
    }

    public void og(EtpAvailableBean etpAvailableBean) {
        if (this.f83092i0 == null) {
            return;
        }
        if (etpAvailableBean != null) {
            this.f83094k0 = etpAvailableBean;
            ViewUtil.m(this.f83093j0, true);
            String o02 = ((TradeBasePresenter) yh()).o0();
            String str = "--";
            if (1 == ((TradeBasePresenter) yh()).a1() || (3 == ((TradeBasePresenter) yh()).a1() && this.Z == 2)) {
                double z11 = ((TradeBasePresenter) yh()).M0().z();
                if (Double.compare(z11, 0.0d) != 0) {
                    str = m.u0(m.a(etpAvailableBean.getRemainingAmount()).multiply(m.a(etpAvailableBean.getCoefficient())).multiply(m.a(String.valueOf(z11))).toPlainString(), 12, PrecisionUtil.y(o02));
                }
                this.f83092i0.setText(str + " " + d7.k.C().z(((TradeBasePresenter) yh()).S0()));
                return;
            }
            String u02 = m.u0(etpAvailableBean.getRemainingAmount(), 12, PrecisionUtil.z(o02));
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(u02)) {
                str = u02;
            }
            sb2.append(str);
            sb2.append(" ");
            sb2.append(d7.k.C().z(((TradeBasePresenter) yh()).I0()).toUpperCase());
            this.f83092i0.setText(sb2.toString());
            return;
        }
        ViewUtil.m(this.f83093j0, false);
        tj();
    }

    public void oj(int i11, Map<String, String> map) {
        if (i11 == 1) {
            ((TradeBasePresenter) yh()).v1(map, this.G.a());
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void pj(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
    }

    public void qc(String str) {
    }

    public void qj() {
        sn.f.C(getContext(), ((TradeBasePresenter) yh()).o0(), false, ((TradeBasePresenter) yh()).Z0());
    }

    public final void rj(int i11, Integer num) {
        if (num != null && num.intValue() != ((TradeBasePresenter) yh()).g()) {
            HashMap hashMap = new HashMap(1);
            int intValue = num.intValue();
            if (intValue == -1) {
                gs.g.i("App_trade_bidask_click", (HashMap) null);
            } else if (intValue == 0) {
                hashMap.put("Tab_id", "balances");
                gs.g.i("App_trade_info_tab_click", hashMap);
            } else if (intValue == 1) {
                hashMap.put("Tab_id", "openorders");
                gs.g.i("App_trade_info_tab_click", hashMap);
            } else if (intValue != 2) {
                hashMap.put("Tab_id", "allrecord");
                gs.g.i("App_trade_info_tab_click", hashMap);
            } else {
                hashMap.put("Tab_id", "ordershistory");
                gs.g.i("App_trade_info_tab_click", hashMap);
            }
        }
    }

    public void s(View view) {
        yj();
        if (!TextUtils.isEmpty(((TradeBasePresenter) yh()).o0())) {
            HashMap hashMap = new HashMap();
            hashMap.put("symbol", ((TradeBasePresenter) yh()).o0());
            if (((TradeBasePresenter) yh()).Z0() == TradeType.MARGIN) {
                is.a.j("5978", hashMap, "1000101");
            } else if (((TradeBasePresenter) yh()).Z0() == TradeType.SUPERMARGIN) {
                is.a.j("5978", hashMap, "1000100");
            }
        }
    }

    public final PrimeLayout si() {
        if (this.D == null) {
            Bi(getActivity());
        }
        return this.D;
    }

    public void sj() {
        if (1 == ((TradeBasePresenter) yh()).a1() || (3 == ((TradeBasePresenter) yh()).a1() && this.Z == 2)) {
            TextView textView = this.f83092i0;
            textView.setText("-- " + d7.k.C().z(((TradeBasePresenter) yh()).S0()));
            return;
        }
        TextView textView2 = this.f83092i0;
        textView2.setText("-- " + d7.k.C().z(((TradeBasePresenter) yh()).I0()));
    }

    public void ti(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (!d7.y.e(str) || !ad.o.c()) {
                HuobiToastUtil.j(R.string.n_grid_trade_not_open);
                return;
            }
            Intent intent = new Intent(activity, GridTradeActivity.class);
            intent.putExtra("EXTRA_SYMBOL", str);
            rn.c.i().d(activity, new JumpTarget(intent, (Intent) null));
            vc.b.a().d("5996", (Map<String, Object>) null, "1000048");
        }
    }

    public void tj() {
        TextView textView = this.f83088e0;
        textView.setText("-- " + d7.k.C().z(((TradeBasePresenter) yh()).S0()));
        ((TradeBasePresenter) yh()).a2();
    }

    public void uh(boolean z11) {
        Map<Integer, Integer> map;
        super.uh(z11);
        if (z11) {
            this.T.setText(String.format(Locale.ENGLISH, getString(R.string.n_trade_total_accounted2), new Object[]{LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)}));
            TradeType tradeType = TradeType.PRO;
            ClosePathFloatView.g(tradeType.toString(), getActivity(), true);
            if (k0.f83756f && yh() != null && ((TradeBasePresenter) yh()).Z0() == tradeType && (map = this.V) != null) {
                for (Integer next : map.keySet()) {
                    Integer num = this.V.get(next);
                    if (num != null && num.intValue() == 1) {
                        Aj(next.intValue(), 1, true);
                    }
                }
                k0.f83756f = false;
            }
            if (((TradeBasePresenter) yh()).g() == -1 && this.f83101o.getVisibility() == 0) {
                int g11 = ((TradeBasePresenter) yh()).g();
                Map<Integer, Integer> map2 = this.V;
                if (map2 != null && !map2.isEmpty()) {
                    Iterator<Map.Entry<Integer, Integer>> it2 = this.V.entrySet().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Map.Entry next2 = it2.next();
                        if (((Integer) next2.getValue()).intValue() == g11) {
                            Aj(((Integer) next2.getKey()).intValue(), (Integer) next2.getValue(), false);
                            break;
                        }
                    }
                }
            } else if (((TradeBasePresenter) yh()).g() != -1 && this.F.getVisibility() == 0) {
                int g12 = ((TradeBasePresenter) yh()).g();
                Map<Integer, Integer> map3 = this.V;
                if (map3 != null && !map3.isEmpty()) {
                    Iterator<Map.Entry<Integer, Integer>> it3 = this.V.entrySet().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        Map.Entry next3 = it3.next();
                        if (((Integer) next3.getValue()).intValue() == g12) {
                            Aj(((Integer) next3.getKey()).intValue(), (Integer) next3.getValue(), false);
                            break;
                        }
                    }
                }
            }
            CommonCheckBox commonCheckBox = this.N;
            if (commonCheckBox != null) {
                commonCheckBox.setChecked(z.a());
                return;
            }
            return;
        }
        TradeHeadView tradeHeadView = this.f83111w;
        if (tradeHeadView != null) {
            tradeHeadView.v();
        }
    }

    public void ui() {
        String str;
        String o02 = ((TradeBasePresenter) yh()).o0();
        if (((TradeBasePresenter) yh()).Z0() == TradeType.PRO) {
            if (((TradeBasePresenter) yh()).e1()) {
                str = a1.v().E(o02, ((TradeBasePresenter) yh()).Z0());
            } else {
                str = a1.v().o(o02, ((TradeBasePresenter) yh()).Z0());
            }
            String str2 = str;
            HashMap hashMap = new HashMap(1);
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(str2));
            is.a.i("4109", hashMap);
            UnifyTransferActivity.Vh(getActivity(), str2, "1", true, (String) null, false, 1);
        } else if (((TradeBasePresenter) yh()).Z0() == TradeType.MARGIN) {
            if (o02 != null) {
                HashMap hashMap2 = new HashMap(1);
                hashMap2.put("symbol", StringUtils.g(o02));
                is.a.i("4110", hashMap2);
                UnifyTransferActivity.Uh(getActivity(), (String) null, "3", false, o02, false);
            }
        } else if (((TradeBasePresenter) yh()).Z0() == TradeType.C2C) {
            if (o02 != null) {
                HashMap hashMap3 = new HashMap(1);
                hashMap3.put("symbol", StringUtils.g(o02));
                is.a.i("4119", hashMap3);
                UnifyTransferActivity.Uh(getActivity(), (String) null, "8", false, o02, false);
            }
        } else if (o02 != null) {
            String I0 = ((TradeBasePresenter) yh()).I0();
            HashMap hashMap4 = new HashMap(1);
            hashMap4.put(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(I0));
            is.a.i("4118", hashMap4);
            UnifyTransferActivity.Th(getActivity(), I0, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL);
        }
    }

    public void uj(TradeType tradeType) {
    }

    public void vi() {
        this.f83108u.hideKeyboardLayout();
    }

    public void vj() {
        this.f83102p.i(true);
        this.f83102p.g(false);
        this.f83102p.V(false);
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(getActivity());
        this.f83110v = smartRefreshHeader;
        this.f83102p.j0(smartRefreshHeader);
    }

    public void w1() {
        PrimeLayout primeLayout;
        ViewGroup viewGroup = this.E;
        if (!(viewGroup == null || (primeLayout = this.D) == null)) {
            try {
                primeLayout.p(viewGroup);
            } catch (Exception unused) {
            }
        }
        if (getActivity() != null && (getActivity() instanceof HuobiMainActivity) && com.hbg.lib.core.util.b.c().f()) {
            ((HuobiMainActivity) getActivity()).ki(true);
        }
    }

    public final void wi() {
        this.f83090g0 = this.f67460i.b(R.id.layout_trade_etp_available_amount);
        this.f83091h0 = (TextView) this.f67460i.b(R.id.text_view_trade_etp_available_amount_label);
        this.f83093j0 = (ImageView) this.f67460i.b(R.id.image_view_trade_etp_available_amount_label);
        this.f83092i0 = (TextView) this.f67460i.b(R.id.text_view_trade_etp_available_amount_value);
        this.f83093j0.setOnClickListener(new v(this));
    }

    public void wj(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, PrimeInfo primeInfo) {
        CustomBoardView customBoardView = this.f83108u;
        if (customBoardView != null) {
            customBoardView.hideKeyboardLayout();
        }
        if (viewGroup != null) {
            this.E = viewGroup;
        }
        PrimeLayout primeLayout = this.D;
        if (primeLayout != null && primeInfo != null && !TextUtils.isEmpty(primeLayout.getPrimeType()) && !this.D.getPrimeType().equalsIgnoreCase(primeInfo.getPrimeType())) {
            w1();
            this.D = null;
        }
        PrimeLayout si2 = si();
        if (si2 != null) {
            si2.setLayoutParams(layoutParams);
            if (si2.G(viewGroup, primeInfo, ((TradeBasePresenter) yh()).o0(), a1.v().n(((TradeBasePresenter) yh()).o0()), a1.v().D(((TradeBasePresenter) yh()).o0()), true) && getActivity() != null && (getActivity() instanceof HuobiMainActivity)) {
                ((HuobiMainActivity) getActivity()).ki(true);
            }
        }
    }

    public void x2(boolean z11, boolean z12, String str) {
        UserInfoUtil.h((u6.g) zh(), new n(this, z11, z12, str));
    }

    public void x3(String str) {
        PrimeLayout si2 = si();
        if (si2 != null) {
            si2.K(str);
        }
    }

    public void xi() {
        this.f83087d0.setOnClickListener(new p0(this));
    }

    public void y0(boolean z11) {
        this.f83110v.b(DateTimeUtils.h(DateTimeUtils.v(), "MM-dd HH:mm:ss"));
        if (z11) {
            this.f83102p.finishRefresh();
            this.f83102p.setNoMoreData(false);
            return;
        }
        this.f83102p.w();
    }

    public abstract void yi();

    public /* synthetic */ void z5(String str) {
        i.a(this, str);
    }

    public void z8(boolean z11, boolean z12) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof TradeFragment) {
            ((TradeFragment) parentFragment).z8(false, true);
        }
    }

    public abstract void zj();
}
