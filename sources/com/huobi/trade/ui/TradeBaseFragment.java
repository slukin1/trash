package com.huobi.trade.ui;

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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bj.o0;
import com.alibaba.fastjson.JSON;
import com.alibaba.verificationsdk.ui.IActivityCallback;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.alibaba.verificationsdk.ui.VerifyType;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.ui.TradeTrendView;
import com.hbg.lib.core.ui.TradeTrendViewNew;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.clear.controller.ClearDialogConfigController;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.PrimeInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import com.hbg.lib.network.hbg.core.bean.MarginCourseMgtBean;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.hbg.core.bean.RemainingAmountBean;
import com.hbg.lib.network.hbg.core.bean.SpotContractEntryBean;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.hbg.prime.PrimeResult;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.ClosePathFloatView;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.exchange.grid.ui.GridTradeActivity;
import com.huobi.account.ui.TradingSettingActivity;
import com.huobi.activity.TradeContainerActivity;
import com.huobi.c2c.ui.C2CBorrowActivity;
import com.huobi.coupon.bean.Coupon;
import com.huobi.finance.ui.CurrencySearchActivity;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.index.bean.IndexFeature;
import com.huobi.kyc.util.KycProxy;
import com.huobi.linearswap.ui.LinearSwapTradeBaseFragment;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.helper.MarginUtil;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.order.ui.TradeOrderActivity;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.store.AppConfigManager;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.trade.event.ShowMarginGuideEvent;
import com.huobi.trade.event.UpdateSpotMarginUiEvent;
import com.huobi.trade.helper.EtpRiskHintUtil;
import com.huobi.trade.helper.c0;
import com.huobi.trade.helper.z;
import com.huobi.trade.presenter.TradeBasePresenter;
import com.huobi.trade.presenter.TradePresenter;
import com.huobi.trade.prime.bean.AliToken;
import com.huobi.trade.prime.bean.PrimeAveragePosition;
import com.huobi.trade.prime.ui.ListingTransferLayout;
import com.huobi.trade.prime.ui.PrimeLayout;
import com.huobi.trade.prime.ui.PrimeLiteLayout;
import com.huobi.trade.ui.TradeFiatGuideTwoDialogFragment;
import com.huobi.trade.ui.TradeHeadView;
import com.huobi.trade.ui.h1;
import com.huobi.utils.HBHTtoHTXManager;
import com.huobi.utils.ReviewManger;
import com.huobi.utils.UserInfoUtil;
import com.huobi.utils.a0;
import com.huobi.utils.c1;
import com.huobi.utils.d1;
import com.huobi.utils.k0;
import com.huobi.utils.v0;
import com.huobi.view.HTUpdradeMarkView;
import com.huobi.view.keyboard.CustomBoardView;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import d7.y;
import dt.i2;
import ht.o;
import i6.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k6.b;
import k6.c;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import sn.t;
import tg.r;

public abstract class TradeBaseFragment<P extends TradeBasePresenter<V>, V extends h1> extends BaseFragment<P, V> implements h1, j, TradeHeadView.b {
    public HBDialogFragment A;
    public HBDialogFragment B;
    public View C;
    public TextView D;
    public ImageView E;
    public PrimeLayout F;
    public ViewGroup G;
    public RadioButton H;
    public l I;
    public CommonTextListIndicator J;
    public View K;
    public TextView L;
    public CommonCheckBox M;
    public TextView N;
    public HorizontalScrollView O;
    public ScrollView P;
    public RadioGroup Q;
    public RadioButton R;
    public RadioButton S;
    public RadioButton T;
    public LinearLayout U;
    public RelativeLayout V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public List<String> Z = new ArrayList();

    /* renamed from: a0  reason: collision with root package name */
    public Map<Integer, Integer> f82307a0 = new HashMap();

    /* renamed from: b0  reason: collision with root package name */
    public List<TextView> f82308b0 = new ArrayList(2);

    /* renamed from: c0  reason: collision with root package name */
    public TradeFiatGuideDialogFragment f82309c0;

    /* renamed from: d0  reason: collision with root package name */
    public TradeFiatGuideTwoDialogFragment f82310d0;

    /* renamed from: e0  reason: collision with root package name */
    public int f82311e0 = 1;

    /* renamed from: f0  reason: collision with root package name */
    public int f82312f0 = 1;

    /* renamed from: g0  reason: collision with root package name */
    public View f82313g0;

    /* renamed from: h0  reason: collision with root package name */
    public TextView f82314h0;

    /* renamed from: i0  reason: collision with root package name */
    public View f82315i0;

    /* renamed from: j0  reason: collision with root package name */
    public TextView f82316j0;

    /* renamed from: k0  reason: collision with root package name */
    public RemainingAmountBean f82317k0;

    /* renamed from: l  reason: collision with root package name */
    public int f82318l = 0;

    /* renamed from: l0  reason: collision with root package name */
    public int f82319l0 = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f82320m = 0;

    /* renamed from: m0  reason: collision with root package name */
    public String f82321m0;

    /* renamed from: n  reason: collision with root package name */
    public int f82322n = 0;

    /* renamed from: n0  reason: collision with root package name */
    public String f82323n0;

    /* renamed from: o  reason: collision with root package name */
    public RecyclerView f82324o;

    /* renamed from: p  reason: collision with root package name */
    public SmartRefreshLayout f82325p;

    /* renamed from: q  reason: collision with root package name */
    public NestedScrollView f82326q;

    /* renamed from: r  reason: collision with root package name */
    public View f82327r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f82328s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f82329t;

    /* renamed from: t0  reason: collision with root package name */
    public rj.b f82330t0;

    /* renamed from: u  reason: collision with root package name */
    public TradeTrendViewNew f82331u;

    /* renamed from: u0  reason: collision with root package name */
    public View f82332u0;

    /* renamed from: v  reason: collision with root package name */
    public View f82333v;

    /* renamed from: v0  reason: collision with root package name */
    public mt.a f82334v0;

    /* renamed from: w  reason: collision with root package name */
    public CustomBoardView f82335w;

    /* renamed from: w0  reason: collision with root package name */
    public PrimeLayout.a f82336w0 = new d();

    /* renamed from: x  reason: collision with root package name */
    public SmartRefreshHeader f82337x;

    /* renamed from: x0  reason: collision with root package name */
    public it.a f82338x0 = new e();

    /* renamed from: y  reason: collision with root package name */
    public TradeHeadView f82339y;

    /* renamed from: y0  reason: collision with root package name */
    public int f82340y0 = 1;

    /* renamed from: z  reason: collision with root package name */
    public TradeSymbolChangeDialogFragment f82341z;

    /* renamed from: z0  reason: collision with root package name */
    public int f82342z0 = 1;

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            TradeBaseFragment.this.yj(i11, TradeBaseFragment.this.f82307a0.get(Integer.valueOf(i11)));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            List<String> list = TradeBaseFragment.this.Z;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public q10.b getIndicator(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setColors(Integer.valueOf(ContextCompat.getColor(context, R.color.baseColorMajorTheme100)));
            linePagerIndicator.setMode(2);
            linePagerIndicator.setRoundRadius((float) PixelUtils.a(1.0f));
            linePagerIndicator.setLineWidth(context.getResources().getDimension(R.dimen.dimen_20));
            linePagerIndicator.setLineHeight(context.getResources().getDimension(R.dimen.global_indicator_height));
            return linePagerIndicator;
        }

        public q10.c getTitleView(Context context, int i11) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setText(TradeBaseFragment.this.Z.get(i11));
            colorTransitionPagerTitleView.setTextSize(1, 14.0f);
            colorTransitionPagerTitleView.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            colorTransitionPagerTitleView.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
            colorTransitionPagerTitleView.setNormalColor(ContextCompat.getColor(context, R.color.baseColorSecondaryTextNew));
            colorTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.baseColorPrimaryText));
            colorTransitionPagerTitleView.setOnClickListener(new c1(this, i11));
            if (i11 == 0) {
                TradeBaseFragment.this.f82308b0.clear();
            }
            TradeBaseFragment.this.f82308b0.add(colorTransitionPagerTitleView);
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

    public class c implements TradeFiatGuideTwoDialogFragment.a {
        public c() {
        }

        public void a() {
            TradeBaseFragment.this.vi();
        }

        public TradeType b() {
            return ((TradeBasePresenter) TradeBaseFragment.this.yh()).V0();
        }

        public void c() {
            TradePresenter tradePresenter = (TradePresenter) ((TradeFragment) TradeBaseFragment.this.getParentFragment()).yh();
            if (tradePresenter != null) {
                tradePresenter.n0();
            }
        }
    }

    public class d implements PrimeLayout.a {
        public d() {
        }

        public void a() {
            if (o.B().F() != null) {
                HBBaseWebActivity.showWebView(TradeBaseFragment.this.getActivity(), o.B().F().getSummary(), "", "", false);
            }
        }

        public void b() {
            if (o.B().F() != null) {
                HBBaseWebActivity.showWebView(TradeBaseFragment.this.getActivity(), o.B().F().getRules(), "", "", false);
            }
        }

        public void c() {
            sn.f.a0(TradeBaseFragment.this.getActivity());
        }

        public void d() {
            ((TradeBasePresenter) TradeBaseFragment.this.yh()).W1();
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
            ((TradeBasePresenter) TradeBaseFragment.this.yh()).q1();
        }

        public void onCloseClick() {
            o.B().r0(true);
            if (o.B().F() != null) {
                int status = o.B().F().getStatus();
                if (status == 1 || status == 2) {
                    TradeBaseFragment.this.w1();
                    return;
                }
                return;
            }
            TradeBaseFragment.this.w1();
        }
    }

    public class e implements it.a {
        public e() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d() {
            ((TradeBasePresenter) TradeBaseFragment.this.yh()).k1();
            ((TradeBasePresenter) TradeBaseFragment.this.yh()).W1();
            o.B().N();
        }

        public void b(int i11, long j11, long[] jArr) {
        }

        public void c(int i11) {
            if (o.B().F() != null && o.B().F().getStatus() == 2) {
                TradeBaseFragment.this.w1();
            }
            if (r.x().F0()) {
                o.B().n0();
            }
            i6.i.b().f(new d1(this));
        }
    }

    public class f implements ny.d {
        public f() {
        }

        public void P8(ky.j jVar) {
        }

        public void bf(ky.j jVar) {
            if (((h1) TradeBaseFragment.this.zh()).isCanBeSeen()) {
                ((TradeBasePresenter) TradeBaseFragment.this.yh()).l1();
            } else {
                TradeBaseFragment.this.y0(true);
            }
        }
    }

    public class g implements TradeTrendView.b {
        public g() {
        }

        public void a(c.a aVar) {
            if (aVar != null) {
                ((h1) TradeBaseFragment.this.zh()).u3(m.i(aVar.a(), PrecisionUtil.A(aVar.o0())));
                TradeBaseFragment tradeBaseFragment = TradeBaseFragment.this;
                tradeBaseFragment.I3(((TradeBasePresenter) tradeBaseFragment.yh()).a1());
            }
        }

        public void b(b.a aVar) {
            if (!a1.v().p0(((TradeBasePresenter) TradeBaseFragment.this.yh()).o0())) {
                return;
            }
            if (aVar.e()) {
                EtpRebalInfo b11 = x7.d.b(((TradeBasePresenter) TradeBaseFragment.this.yh()).D0());
                if (b11 != null && !TextUtils.isEmpty(b11.getEquityDeviationRate())) {
                    String Q = m.Q(b11.getEquityDeviationRate(), 2, 1);
                    new DialogUtils.b.d(TradeBaseFragment.this.getActivity()).c1(TradeBaseFragment.this.getActivity().getString(R.string.n_trade_etp_nav)).C0(String.format(Locale.ENGLISH, TradeBaseFragment.this.getActivity().getString(R.string.n_trade_etp_deviation_hint), new Object[]{a1.v().p(((TradeBasePresenter) TradeBaseFragment.this.yh()).o0()), Q})).q0(false).P0(TradeBaseFragment.this.getActivity().getString(R.string.n_known)).Q0(f1.f82628a).k0().show(TradeBaseFragment.this.getActivity().getSupportFragmentManager(), "");
                    return;
                }
                return;
            }
            new DialogUtils.b.d(TradeBaseFragment.this.getActivity()).c1(TradeBaseFragment.this.getActivity().getString(R.string.n_trade_etp_nav)).C0(String.format(Locale.ENGLISH, TradeBaseFragment.this.getActivity().getString(R.string.n_trade_etp_nav_instructions_new), new Object[]{a1.v().p(((TradeBasePresenter) TradeBaseFragment.this.yh()).o0())})).q0(false).P0(TradeBaseFragment.this.getActivity().getString(R.string.n_known)).Q0(e1.f82621a).k0().show(TradeBaseFragment.this.getActivity().getSupportFragmentManager(), "");
        }

        public void c(b.a aVar) {
            ((TradeBasePresenter) TradeBaseFragment.this.yh()).y1();
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            sn.f.A(TradeBaseFragment.this.getActivity(), ((TradeBasePresenter) TradeBaseFragment.this.yh()).o0(), false, false, ((TradeBasePresenter) TradeBaseFragment.this.yh()).V0(), true);
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
        public WeakReference<TradeBaseFragment> f82354a;

        /* renamed from: b  reason: collision with root package name */
        public OrderPlaceBean f82355b;

        public l(TradeBaseFragment tradeBaseFragment) {
            this.f82354a = new WeakReference<>(tradeBaseFragment);
        }

        public OrderPlaceBean a() {
            return this.f82355b;
        }

        public void b(OrderPlaceBean orderPlaceBean) {
            this.f82355b = orderPlaceBean;
        }

        public void onNotifyBackPressed() {
            TradeBaseFragment tradeBaseFragment = (TradeBaseFragment) this.f82354a.get();
            if (tradeBaseFragment != null) {
                tradeBaseFragment.lj();
            }
        }

        public void onResult(int i11, Map<String, String> map) {
            TradeBaseFragment tradeBaseFragment = (TradeBaseFragment) this.f82354a.get();
            if (tradeBaseFragment != null) {
                tradeBaseFragment.mj(i11, map);
            }
        }
    }

    private void Di() {
        this.C = this.f67460i.b(R.id.trade_risk_reminder_ll);
        this.D = (TextView) this.f67460i.b(R.id.trade_reminder_detail_tv);
        this.E = (ImageView) this.f67460i.b(R.id.trade_risk_reminder_tv);
    }

    private void Ei() {
        this.f82328s = (TextView) this.f67460i.b(R.id.tv_trade_trend_price_title);
        this.f82329t = (TextView) this.f67460i.b(R.id.tv_trade_trend_amount_title);
        this.f82331u = (TradeTrendViewNew) this.f67460i.b(R.id.market_list_root_ll);
        this.f82327r = this.f67460i.b(R.id.order_current_iv);
        this.f82333v = this.f67460i.b(R.id.trend_view_diff);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Fi(EditText editText) {
        int[] iArr = new int[2];
        editText.getLocationInWindow(iArr);
        if (((float) iArr[1]) > this.f82335w.getY()) {
            this.f82326q.scrollTo(0, (int) (((float) iArr[1]) - this.f82335w.getY()));
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Gi(View view) {
        HashMap hashMap = new HashMap();
        if (((TradeBasePresenter) yh()).V0() == TradeType.PRO) {
            hashMap.put("trade_mode", RankScreenBean.SCREEN_VALUE_SPOT);
        } else if (((TradeBasePresenter) yh()).V0() == TradeType.MARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_ISOLATED);
        } else if (((TradeBasePresenter) yh()).V0() == TradeType.SUPERMARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_CROSS);
        }
        hashMap.put("type", "transfer");
        gs.g.i("app_trade_open_orders_transfer_click", hashMap);
        vi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Hi(View view) {
        HashMap hashMap = new HashMap();
        if (((TradeBasePresenter) yh()).V0() == TradeType.PRO) {
            hashMap.put("trade_mode", RankScreenBean.SCREEN_VALUE_SPOT);
        } else if (((TradeBasePresenter) yh()).V0() == TradeType.MARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_ISOLATED);
        } else if (((TradeBasePresenter) yh()).V0() == TradeType.SUPERMARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_CROSS);
        }
        hashMap.put("type", "transfer");
        gs.g.i("app_trade_open_orders_transfer_click", hashMap);
        vi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ii(int i11, EditText editText) {
        if (i11 == 1) {
            i6.i.b().g(new r0(this, editText), 50);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ji(HBDialogFragment hBDialogFragment) {
        if (((TradeBasePresenter) yh()).e() == 3) {
            ((TradeBasePresenter) yh()).t0();
        } else {
            ((TradeBasePresenter) yh()).s0();
        }
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ki(View view) {
        CommonCheckBox commonCheckBox = this.M;
        commonCheckBox.setChecked(!commonCheckBox.isChecked());
        z.b(this.M.isChecked());
        ((TradeBasePresenter) yh()).O1();
        if (((TradeBasePresenter) yh()).g() == 0) {
            ((TradeBasePresenter) yh()).Y0(true, ((TradeBasePresenter) yh()).o0(), false);
        } else if (((TradeBasePresenter) yh()).g() == 1) {
            ((TradeBasePresenter) yh()).W1();
        } else if (((TradeBasePresenter) yh()).g() == 2) {
            ((TradeBasePresenter) yh()).F1();
        } else if (((TradeBasePresenter) yh()).g() == 3) {
            ((TradeBasePresenter) yh()).r0();
        } else if (((TradeBasePresenter) yh()).g() == 4) {
            ((TradeBasePresenter) yh()).G1();
        } else if (((TradeBasePresenter) yh()).g() == 9) {
            ((TradeBasePresenter) yh()).H1();
        }
        HashMap hashMap = new HashMap(2);
        if (this.M.isChecked()) {
            hashMap.put("button_type", "open");
        } else {
            hashMap.put("button_type", "close");
        }
        if (((TradeBasePresenter) yh()).V0() == TradeType.MARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_ISOLATED);
        } else if (((TradeBasePresenter) yh()).V0() == TradeType.SUPERMARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_CROSS);
        } else {
            hashMap.put("trade_mode", RankScreenBean.SCREEN_VALUE_SPOT);
        }
        gs.g.i("app_trade_captial_currentSymbol_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Li(View view) {
        this.M.performClick();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Mi(RadioGroup radioGroup, int i11) {
        if (i11 == R.id.plan_order_rb) {
            ((TradeBasePresenter) yh()).w1(2);
        } else if (i11 == R.id.time_order_rb) {
            ((TradeBasePresenter) yh()).w1(3);
        } else if (i11 != R.id.tp_sl_order_rb) {
            ((TradeBasePresenter) yh()).w1(0);
        } else {
            ((TradeBasePresenter) yh()).w1(1);
        }
        ((TradeBasePresenter) yh()).N1();
        ((TradeBasePresenter) yh()).L1();
        ((TradeBasePresenter) yh()).z0();
        ((TradeBasePresenter) yh()).W1();
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ni(View view) {
        HashMap hashMap = new HashMap();
        if (((TradeBasePresenter) yh()).V0() == TradeType.PRO) {
            hashMap.put("trade_mode", RankScreenBean.SCREEN_VALUE_SPOT);
        } else if (((TradeBasePresenter) yh()).V0() == TradeType.MARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_ISOLATED);
        } else if (((TradeBasePresenter) yh()).V0() == TradeType.SUPERMARGIN) {
            hashMap.put("trade_mode", FutureContractInfo.MARGIN_CROSS);
        }
        hashMap.put("type", "desposit");
        gs.g.i("app_trade_open_orders_transfer_click", hashMap);
        if (r.x().F0()) {
            CurrencySearchActivity.lj(getActivity(), "1", false);
        } else {
            Intent intent = new Intent(getActivity(), CurrencySearchActivity.class);
            intent.putExtra("extra_type", "1");
            rn.c.i().d(getActivity(), new JumpTarget(intent, (Intent) null));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qi(View view) {
        if (this.f82317k0 != null) {
            String N0 = ((TradeBasePresenter) yh()).N0();
            String D0 = ((TradeBasePresenter) yh()).D0();
            DialogUtils.b.d c12 = new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_trade_observation_limit_tips_title));
            c12.C0(getString(R.string.n_trade_observation_limit_hint, d7.k.C().z(D0), ((TradeBasePresenter) yh()).B0(this.f82317k0.getCurrency(), this.f82317k0.getTotalAmount(), N0) + " " + d7.k.C().z(N0))).P0(getString(R.string.n_known)).Q0(j0.f82651a).k0().show(getActivity().getSupportFragmentManager(), "");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ri(View view) {
        this.f82315i0.performClick();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Si(Object obj) {
        HuobiToastUtil.v(getString(R.string.market_delete_collection_success));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ti(Object obj) {
        HuobiToastUtil.v(getString(R.string.market_add_collection_success));
    }

    public static /* synthetic */ void Ui(int i11, HBDialogFragment hBDialogFragment) {
        ClearDialogConfigController.g(i11);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vi(String str, int i11, HBDialogFragment hBDialogFragment) {
        HBBaseWebActivity.showWebView(getActivity(), a0.f(str), "", "", false);
        ClearDialogConfigController.g(i11);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wi(HBDialogFragment hBDialogFragment) {
        HBBaseWebActivity.showWebView(getActivity(), d1.f(), "", "", false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yi(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        sn.f.Q(getActivity(), ((TradeBasePresenter) yh()).o0());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Zi() {
        this.f82309c0 = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aj() {
        this.f82310d0 = null;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void bj(View view) {
        startActivity(sn.f.p(getActivity(), Coupon.SPOT));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void cj(HBDialogFragment hBDialogFragment) {
        startActivity(sn.f.p(getActivity(), Coupon.SPOT));
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void dj(boolean z11, boolean z12, String str, String str2, Boolean bool, List list, Integer num) {
        if (KycProxy.l().p() != 2) {
            if (!z11) {
                startActivity(sn.f.p(getActivity(), Coupon.SPOT));
            } else if (z12) {
                oi(new p0(this), str);
            } else {
                pi(new g0(this));
            }
        } else if (!TextUtils.isEmpty(str)) {
            HuobiToastUtil.m(str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ej(HBDialogFragment hBDialogFragment) {
        ((TradeBasePresenter) yh()).p0();
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hj(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        com.huobi.trade.helper.b.a().c("1");
        ((TradeBasePresenter) yh()).q0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ij(Object obj) {
        Object obj2 = ((Map) obj).get("itemType");
        if (obj2 instanceof Integer) {
            pj(Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void jj(View view) {
        HBBaseWebActivity.showWebView(getActivity(), d1.f(), "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void kj(View view) {
        DialogUtils.X(getActivity(), getString(R.string.n_option_delivery_tip), getString(R.string.n_trade_innovate_risk_tips), "", getContext().getString(R.string.n_copy_trading_i_got_it), ad.b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        int i11 = 0;
        int i12 = ((TradeBasePresenter) yh()).g() == 2 ? 1 : 0;
        if (((TradeBasePresenter) yh()).e() == 2) {
            i11 = 2;
        } else if (((TradeBasePresenter) yh()).e() == 1) {
            i11 = 1;
        } else if (((TradeBasePresenter) yh()).e() == 3) {
            i11 = 3;
        }
        TradeOrderActivity.Hi(getActivity(), ((TradeBasePresenter) yh()).V0(), (String) null, i11, i12);
        com.huobi.trade.helper.c.b().f();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        String str;
        if (z.a()) {
            String W2 = a1.v().W(((TradeBasePresenter) yh()).o0());
            int e11 = ((TradeBasePresenter) yh()).e();
            if (e11 == 1) {
                str = String.format(Locale.US, getString(R.string.n_spot_order_cancel_symbol_tpsl_order), new Object[]{W2});
            } else if (e11 != 3) {
                str = String.format(Locale.US, getString(R.string.n_spot_order_cancel_symbol_limit_order), new Object[]{W2});
            } else {
                str = String.format(Locale.US, getString(R.string.n_spot_order_cancel_symbol_timing_deal_order), new Object[]{W2});
            }
        } else {
            int e12 = ((TradeBasePresenter) yh()).e();
            if (e12 == 1) {
                str = getString(R.string.n_spot_order_cancel_all_tpsl_order);
            } else if (e12 != 3) {
                str = getString(R.string.n_spot_order_cancel_all_limit_order);
            } else {
                str = getString(R.string.n_spot_order_cancel_all_timing_deal_order);
            }
        }
        new DialogUtils.b.d(getActivity()).C0(str).P0(getString(R.string.n_confirm)).c1(getString(R.string.n_login_tip)).Q0(new f0(this)).s0(getString(R.string.n_cancel)).N0(o0.f12469a).k0().show(getActivity().getSupportFragmentManager(), "");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void zi() {
        this.J = (CommonTextListIndicator) this.f67460i.b(R.id.order_type_indicator);
        yi();
        this.f82308b0.clear();
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdapter(new a());
        this.J.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
        this.J.setNavigator(commonNavigator);
        Ai();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Ab(com.huobi.trade.prime.bean.TradeOrderNum r11) {
        /*
            r10 = this;
            java.util.Map<java.lang.Integer, java.lang.Integer> r0 = r10.f82307a0
            boolean r0 = r0.isEmpty()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0037
            java.util.Map<java.lang.Integer, java.lang.Integer> r0 = r10.f82307a0
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0014:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0037
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getValue()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r1 != r4) goto L_0x0014
            java.lang.Object r0 = r3.getKey()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x0038
        L_0x0037:
            r0 = r2
        L_0x0038:
            java.lang.String r3 = r11.getCount()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 2132025163(0x7f141f4b, float:1.9688823E38)
            java.lang.String r6 = ")"
            java.lang.String r7 = "("
            java.lang.String r8 = "0"
            if (r4 != 0) goto L_0x0071
            boolean r4 = r8.equals(r3)
            if (r4 == 0) goto L_0x0052
            goto L_0x0071
        L_0x0052:
            java.util.List<java.lang.String> r4 = r10.Z
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r5 = r10.getString(r5)
            r9.append(r5)
            r9.append(r7)
            r9.append(r3)
            r9.append(r6)
            java.lang.String r3 = r9.toString()
            r4.set(r0, r3)
            goto L_0x007a
        L_0x0071:
            java.util.List<java.lang.String> r3 = r10.Z
            java.lang.String r4 = r10.getString(r5)
            r3.set(r0, r4)
        L_0x007a:
            com.hbg.lib.common.mvp.BaseFragmentPresenter r3 = r10.yh()
            com.huobi.trade.presenter.TradeBasePresenter r3 = (com.huobi.trade.presenter.TradeBasePresenter) r3
            int r3 = r3.g()
            if (r3 != r1) goto L_0x00c6
            boolean r1 = r11.isShowTransfer()
            r3 = 8
            if (r1 == 0) goto L_0x00bc
            android.widget.ScrollView r1 = r10.P
            r1.setVisibility(r2)
            android.widget.LinearLayout r1 = r10.U
            r1.setVisibility(r3)
            com.hbg.lib.common.mvp.BaseFragmentPresenter r1 = r10.yh()
            com.huobi.trade.presenter.TradeBasePresenter r1 = (com.huobi.trade.presenter.TradeBasePresenter) r1
            com.hbg.lib.data.symbol.TradeType r1 = r1.V0()
            com.hbg.lib.data.symbol.TradeType r4 = com.hbg.lib.data.symbol.TradeType.PRO
            if (r1 != r4) goto L_0x00b1
            android.widget.RelativeLayout r1 = r10.V
            r1.setVisibility(r2)
            android.widget.TextView r1 = r10.Y
            r1.setVisibility(r3)
            goto L_0x00c6
        L_0x00b1:
            android.widget.RelativeLayout r1 = r10.V
            r1.setVisibility(r3)
            android.widget.TextView r1 = r10.Y
            r1.setVisibility(r2)
            goto L_0x00c6
        L_0x00bc:
            android.widget.ScrollView r1 = r10.P
            r1.setVisibility(r3)
            android.widget.LinearLayout r1 = r10.U
            r1.setVisibility(r2)
        L_0x00c6:
            java.util.List<android.widget.TextView> r1 = r10.f82308b0
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x00e3
            java.util.List<android.widget.TextView> r1 = r10.f82308b0
            java.lang.Object r1 = r1.get(r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x00e3
            java.util.List<java.lang.String> r2 = r10.Z
            java.lang.Object r0 = r2.get(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
        L_0x00e3:
            java.lang.String r0 = r11.getNormalCount()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 2132021901(0x7f14128d, float:1.9682206E38)
            if (r1 != 0) goto L_0x0116
            boolean r1 = r8.equals(r0)
            if (r1 == 0) goto L_0x00f7
            goto L_0x0116
        L_0x00f7:
            android.widget.RadioButton r1 = r10.R
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r2 = r10.getString(r2)
            r3.append(r2)
            r3.append(r7)
            r3.append(r0)
            r3.append(r6)
            java.lang.String r0 = r3.toString()
            r1.setText(r0)
            goto L_0x011f
        L_0x0116:
            android.widget.RadioButton r0 = r10.R
            java.lang.String r1 = r10.getString(r2)
            r0.setText(r1)
        L_0x011f:
            java.lang.String r0 = r11.getStopLossCount()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 2132023427(0x7f141883, float:1.9685302E38)
            if (r1 != 0) goto L_0x0152
            boolean r1 = r8.equals(r0)
            if (r1 == 0) goto L_0x0133
            goto L_0x0152
        L_0x0133:
            android.widget.RadioButton r1 = r10.S
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r2 = r10.getString(r2)
            r3.append(r2)
            r3.append(r7)
            r3.append(r0)
            r3.append(r6)
            java.lang.String r0 = r3.toString()
            r1.setText(r0)
            goto L_0x015b
        L_0x0152:
            android.widget.RadioButton r0 = r10.S
            java.lang.String r1 = r10.getString(r2)
            r0.setText(r1)
        L_0x015b:
            java.lang.String r0 = r11.getAlgoCount()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 2132021979(0x7f1412db, float:1.9682365E38)
            if (r1 != 0) goto L_0x018e
            boolean r1 = r8.equals(r0)
            if (r1 == 0) goto L_0x016f
            goto L_0x018e
        L_0x016f:
            android.widget.RadioButton r1 = r10.T
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r2 = r10.getString(r2)
            r3.append(r2)
            r3.append(r7)
            r3.append(r0)
            r3.append(r6)
            java.lang.String r0 = r3.toString()
            r1.setText(r0)
            goto L_0x0197
        L_0x018e:
            android.widget.RadioButton r0 = r10.T
            java.lang.String r1 = r10.getString(r2)
            r0.setText(r1)
        L_0x0197:
            java.lang.String r11 = r11.getPeriodCount()
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = 2132022011(0x7f1412fb, float:1.968243E38)
            if (r0 != 0) goto L_0x01ca
            boolean r0 = r8.equals(r11)
            if (r0 == 0) goto L_0x01ab
            goto L_0x01ca
        L_0x01ab:
            android.widget.RadioButton r0 = r10.H
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = r10.getString(r1)
            r2.append(r1)
            r2.append(r7)
            r2.append(r11)
            r2.append(r6)
            java.lang.String r11 = r2.toString()
            r0.setText(r11)
            goto L_0x01d3
        L_0x01ca:
            android.widget.RadioButton r11 = r10.H
            java.lang.String r0 = r10.getString(r1)
            r11.setText(r0)
        L_0x01d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.trade.ui.TradeBaseFragment.Ab(com.huobi.trade.prime.bean.TradeOrderNum):void");
    }

    public void Ah() {
        super.Ah();
        this.f82339y.setOnHeadClickListener(this);
        this.f82325p.e0(new f());
        this.f82335w.setKeyBoardStateChangeListener(new q0(this));
        this.f82331u.setCallback(new g());
        this.f82327r.setOnClickListener(new y0(this));
        if (getActivity() instanceof HuobiMainActivity) {
            ((HuobiMainActivity) getActivity()).ji(this);
        }
        this.L.setOnClickListener(new x0(this));
        this.M.setOnClickListener(new t(this));
        this.N.setOnClickListener(new v(this));
        this.Q.setOnCheckedChangeListener(new w(this));
        this.W.setOnClickListener(new a1(this));
        this.Y.setOnClickListener(new u(this));
        this.X.setOnClickListener(new b1(this));
    }

    public final void Ai() {
        int qi2 = qi();
        if (qi2 != -1) {
            for (Integer next : this.f82307a0.keySet()) {
                if (this.f82307a0.get(next).intValue() == qi2) {
                    ((TradeBasePresenter) yh()).B1(qi2);
                    i2.a().f(ri(), qi2);
                    if (!(next.intValue() == -1 || next.intValue() == 0)) {
                        this.J.c(next.intValue());
                        return;
                    }
                }
            }
        }
    }

    public void Aj(String str) {
        try {
            a1 v11 = a1.v();
            TradeType tradeType = TradeType.SUPERMARGIN;
            List<String> H2 = v11.H(tradeType);
            a1 v12 = a1.v();
            TradeType tradeType2 = TradeType.MARGIN;
            List<String> H3 = v12.H(tradeType2);
            boolean z11 = !H2.isEmpty() && H2.contains(str);
            if ((!H3.isEmpty() && H3.contains(str)) && z11) {
                this.f82319l0 = 0;
            } else if (z11) {
                this.f82319l0 = 1;
            } else {
                this.f82319l0 = 2;
            }
            if (((TradeBasePresenter) yh()).V0() != tradeType2) {
                if (((TradeBasePresenter) yh()).V0() != tradeType) {
                    this.f82321m0 = "";
                    this.f82323n0 = "";
                    return;
                }
            }
            this.f82321m0 = a1.v().J(str, tradeType2).getLeverageRatio();
            this.f82323n0 = a1.v().J(str, tradeType).getSuperMarginLeverageRatio();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void B2(int i11) {
        this.Q.check(i11);
    }

    public final void Bi() {
        this.f82313g0 = this.f67460i.b(R.id.holding_limit_layout);
        this.f82314h0 = (TextView) this.f67460i.b(R.id.trade_spot_limit_label);
        this.f82315i0 = this.f67460i.b(R.id.trade_holding_limit_ask_icon);
        this.f82316j0 = (TextView) this.f67460i.b(R.id.trade_spot_limit_value);
        this.f82314h0.setOnClickListener(new e0(this));
    }

    public final void Ci(Context context) {
        if (context != null) {
            if (o.B().b0()) {
                this.F = new PrimeLiteLayout(context);
            } else if (o.B().R()) {
                this.F = new ListingTransferLayout(context);
            } else {
                this.F = new PrimeLayout(context);
            }
            this.F.setCallback(this.f82336w0);
            ht.e.k().t(this.f82338x0);
        }
    }

    public void D(View view) {
        vj();
    }

    public void D1(int i11) {
        this.f82327r.setVisibility(i11);
    }

    public void E2() {
        HBDialogFragment hBDialogFragment = this.A;
        if (hBDialogFragment != null && hBDialogFragment.th()) {
            this.A.dismiss();
        }
        HBDialogFragment hBDialogFragment2 = this.B;
        if (hBDialogFragment2 != null && hBDialogFragment2.th()) {
            this.B.dismiss();
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
        if (this.A == null) {
            this.A = new DialogUtils.b.d(getActivity()).c1(getString(R.string.allow_access_dialog_title)).C0(getString(R.string.n_trade_etp_evaluation_content)).Y0(getString(R.string.n_trade_etp_evaluation_introduce)).a1(new d0(this)).s0(getString(R.string.global_string_cancel)).P0(getString(R.string.n_trade_etp_evaluation_start)).N0(m0.f82668a).Q0(new c0(this)).k0();
        }
        if (!this.A.th()) {
            this.A.show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void H0(MarketCurrentPriceItem marketCurrentPriceItem) {
        if (getActivity() != null) {
            this.f82331u.setNewestPrice(marketCurrentPriceItem);
            ((TradeBasePresenter) yh()).a2();
        }
    }

    public void H2(RemainingAmountBean remainingAmountBean) {
        this.f82317k0 = remainingAmountBean;
        if (remainingAmountBean != null) {
            ViewUtil.m(this.f82315i0, true);
            String N0 = ((TradeBasePresenter) yh()).N0();
            TextView textView = this.f82316j0;
            textView.setText(((TradeBasePresenter) yh()).B0(this.f82317k0.getCurrency(), this.f82317k0.getRemainingAmount(), N0) + " " + d7.k.C().z(N0));
            return;
        }
        ViewUtil.m(this.f82315i0, false);
        oj();
    }

    public void K2(String str, String str2, int i11) {
        HBDialogFragment hBDialogFragment = this.B;
        if (hBDialogFragment == null || !hBDialogFragment.isAdded()) {
            DialogUtils.b.d Q0 = new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_trade_etp_clear_dialog_title)).C0(str2).P0(getString(R.string.n_known)).Q0(new a0(i11));
            if (!TextUtils.isEmpty(str)) {
                Q0.s0(getString(R.string.n_exchange_filled_orders_tip_view_detail)).N0(new i0(this, str, i11));
            }
            HBDialogFragment k02 = Q0.k0();
            this.B = k02;
            k02.show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void K8(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f82328s.setText(AppUtil.b("(", str.toUpperCase(), ")"));
        } else {
            this.f82328s.setText("");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f82329t.setText(AppUtil.b("(", str2.toUpperCase(), ")"));
            return;
        }
        this.f82329t.setText("");
    }

    public void L1(IndexFeature indexFeature) {
        c0.d().f(indexFeature);
    }

    public void L2() {
        String string = getString(R.string.n_trade_observation_license_hint);
        String string2 = getString(R.string.n_trade_observation_license_title);
        int indexOf = string.indexOf(string2);
        if (indexOf != -1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new b(), indexOf, string2.length() + indexOf, 17);
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_trade_observation_license_explain)).C0(getString(R.string.n_trade_observation_license_content)).w0(spannableStringBuilder).t0(true).s0(getString(R.string.n_cancel)).P0(getString(R.string.n_confirm)).N0(k0.f82657a).Q0(new b0(this)).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void N1() {
        if (isCanBeSeen()) {
            new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_trade_pioneer_price_fluctuation_hint)).P0(getString(R.string.n_known)).c1(getString(R.string.n_trade_observation_license_explain)).Q0(new h0(this)).q0(false).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void O0(String str, int i11, int i12) {
        this.f82339y.v(str, i11, R.color.baseColorContentBackground);
    }

    public void O1(String str, TradeType tradeType) {
        this.f82339y.x(a1.v().X(str, tradeType));
        if (getParentFragment() instanceof TradeFragment) {
            ((TradeFragment) getParentFragment()).Sh();
        }
        Aj(str);
        ni(str);
        zj();
        ViewGroup viewGroup = (ViewGroup) this.f67460i.b(R.id.llAdEdgeEngine);
        if (viewGroup != null) {
            this.f82334v0.u0(viewGroup);
            this.f82334v0.s0(str, tradeType);
        }
    }

    public void O2(int i11, int i12) {
        this.f82326q.scrollTo(i11, i12);
    }

    public void Q(View view) {
        if (((TradeBasePresenter) yh()).V0() == TradeType.MARGIN) {
            is.a.j("5975", (Map<String, Object>) null, "1000101");
        } else if (((TradeBasePresenter) yh()).V0() == TradeType.SUPERMARGIN) {
            is.a.j("5975", (Map<String, Object>) null, "1000100");
        } else if (((TradeBasePresenter) yh()).V0() == TradeType.PRO) {
            EventBus.d().k(new UpdateSpotMarginUiEvent());
        }
        nj();
    }

    public void R(View view) {
        if (this.f82341z == null) {
            this.f82341z = new TradeSymbolChangeDialogFragment();
        }
        this.f82341z.setTradeType(((TradeBasePresenter) yh()).V0());
        this.f82341z.bc(((TradeBasePresenter) yh()).o0());
        this.f82341z.wh(((TradeBasePresenter) yh()).D0());
        this.f82341z.showAsDropDown(getFragmentManager(), view, 0, 0, 53);
    }

    public int S1() {
        return this.f82320m;
    }

    public void V2() {
        this.X.performClick();
    }

    public void W1(int i11) {
        this.K.setVisibility(i11);
    }

    public /* synthetic */ String Wf() {
        return g1.a(this);
    }

    public boolean X5() {
        CustomBoardView customBoardView = this.f82335w;
        if (customBoardView == null || !customBoardView.keyboardVisible()) {
            return false;
        }
        this.f82335w.hideKeyboardLayout();
        return true;
    }

    public void a0(View view) {
    }

    public void b(v9.a aVar) {
        this.f82324o.setAdapter(aVar);
    }

    public int c2() {
        return this.f82322n;
    }

    public void d(boolean z11) {
        if (z11) {
            this.f82327r.setVisibility(0);
        } else {
            this.f82327r.setVisibility(8);
        }
    }

    public void d3(int i11) {
        if (((TradeBasePresenter) yh()).e() == 2) {
            this.L.setVisibility(8);
        } else {
            this.L.setVisibility(i11);
        }
    }

    public void e(View view) {
        SpotContractEntryBean spotContractEntryBean = (SpotContractEntryBean) this.f82339y.getTag();
        if (spotContractEntryBean != null && spotContractEntryBean.getShowType() != 0) {
            boolean z11 = false;
            if (spotContractEntryBean.getShowType() == 1) {
                HashMap hashMap = new HashMap();
                hashMap.put("TransPair_current", ((TradeBasePresenter) yh()).o0());
                gs.g.i("App_futures_click", hashMap);
                LinearSwapTradeBaseFragment.Oj(getContext(), FutureContractInfoController.n().o(spotContractEntryBean.getContractCode()), 0, false);
            } else if (a1.v().p0(((TradeBasePresenter) yh()).o0())) {
                ((TradeBasePresenter) yh()).v0(a1.v().K(EtpRiskHintUtil.c(((TradeBasePresenter) yh()).D0())));
            } else {
                String o02 = ((TradeBasePresenter) yh()).o0();
                FragmentActivity activity = getActivity();
                if (spotContractEntryBean.getPositionType() == 0) {
                    z11 = true;
                }
                k0.N(o02, true, activity, z11);
            }
        }
    }

    public void e3() {
        this.W.performClick();
    }

    public void f3(boolean z11) {
        if (z11) {
            TradeFiatGuideDialogFragment tradeFiatGuideDialogFragment = this.f82309c0;
            if (tradeFiatGuideDialogFragment == null || !tradeFiatGuideDialogFragment.isVisible()) {
                TradeFiatGuideDialogFragment tradeFiatGuideDialogFragment2 = new TradeFiatGuideDialogFragment();
                this.f82309c0 = tradeFiatGuideDialogFragment2;
                tradeFiatGuideDialogFragment2.Dh(new o0(this));
                this.f82309c0.setDialogDismissListener(new z(this));
                this.f82309c0.show(getActivity().getSupportFragmentManager(), "fiatGuideDialogFragment");
                gs.g.i("APP_Trade_fiat_expose", (HashMap) null);
                return;
            }
            return;
        }
        TradeFiatGuideTwoDialogFragment tradeFiatGuideTwoDialogFragment = this.f82310d0;
        if (tradeFiatGuideTwoDialogFragment == null || !tradeFiatGuideTwoDialogFragment.isVisible()) {
            TradeFiatGuideTwoDialogFragment tradeFiatGuideTwoDialogFragment2 = new TradeFiatGuideTwoDialogFragment();
            this.f82310d0 = tradeFiatGuideTwoDialogFragment2;
            tradeFiatGuideTwoDialogFragment2.Dh(new c());
            this.f82310d0.setDialogDismissListener(new y(this));
            this.f82310d0.show(getActivity().getSupportFragmentManager(), "fiatGuideTwoDialogFragment");
        }
    }

    public void finishRefresh() {
        PrimeLayout primeLayout = this.F;
        if (primeLayout != null) {
            primeLayout.D();
        }
    }

    public void g0(View view, String str) {
        ti(str);
    }

    public int getUiPlanTradeBuyMode() {
        return this.f82311e0;
    }

    public int getUiPlanTradeSellMode() {
        return this.f82312f0;
    }

    public void id() {
        if (qk.v0.b().c(((TradeBasePresenter) yh()).V0() == TradeType.PRO)) {
            this.H.setVisibility(0);
        } else {
            this.H.setVisibility(8);
        }
    }

    public void initViews() {
        super.initViews();
        this.f82326q = (NestedScrollView) this.f67460i.b(R.id.trade_scrollview);
        this.f82325p = (SmartRefreshLayout) this.f67460i.b(R.id.tradePtrFrame);
        TradeHeadView tradeHeadView = (TradeHeadView) this.f67460i.b(R.id.trade_head_view);
        this.f82339y = tradeHeadView;
        tradeHeadView.setCalculatorVisibility(8);
        this.H = (RadioButton) this.f67460i.b(R.id.time_order_rb);
        RecyclerView recyclerView = (RecyclerView) this.f67460i.b(R.id.spotRv);
        this.f82324o = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f82324o.addItemDecoration(new VerticalDividerItemDecoration(ContextCompat.getDrawable(getActivity(), R.color.baseColorPrimarySeparator), PixelUtils.a(0.5f), false, PixelUtils.a(15.0f), PixelUtils.a(15.0f)));
        this.f82332u0 = this.f67460i.b(R.id.trade_right_pop_iv);
        FrameLayout frameLayout = (FrameLayout) getActivity().findViewById(16908290);
        int childCount = frameLayout.getChildCount();
        if (childCount > 0) {
            View childAt = frameLayout.getChildAt(childCount - 1);
            if (childAt == null || !(childAt instanceof CustomBoardView)) {
                CustomBoardView customBoardView = new CustomBoardView(getActivity());
                this.f82335w = customBoardView;
                customBoardView.setGravity(80);
                this.f82335w.setVisibility(8);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                frameLayout.addView(this.f82335w, layoutParams);
            } else {
                this.f82335w = (CustomBoardView) childAt;
            }
        }
        Ei();
        Di();
        Bi();
        sj();
        zi();
        L1(c0.d().c());
        this.K = this.f67460i.b(R.id.trade_cancel_all_container);
        this.L = (TextView) this.f67460i.b(R.id.trade_cancel_all_tv);
        CommonCheckBox commonCheckBox = (CommonCheckBox) this.f67460i.b(R.id.trade_show_current_iv);
        this.M = commonCheckBox;
        commonCheckBox.setChecked(z.a());
        this.N = (TextView) this.f67460i.b(R.id.trade_show_current_tv);
        this.O = (HorizontalScrollView) this.f67460i.b(R.id.order_tab_sv);
        this.Q = (RadioGroup) this.f67460i.b(R.id.order_tab_rg);
        this.R = (RadioButton) this.f67460i.b(R.id.open_order_rb);
        this.S = (RadioButton) this.f67460i.b(R.id.tp_sl_order_rb);
        this.P = (ScrollView) this.f67460i.b(R.id.current_order_guide_sv);
        this.U = (LinearLayout) this.f67460i.b(R.id.current_order_content_layout);
        this.V = (RelativeLayout) this.f67460i.b(R.id.current_order_guide_action);
        this.W = (TextView) this.f67460i.b(R.id.current_order_guide_deposit);
        this.X = (TextView) this.f67460i.b(R.id.current_order_guide_transfer);
        this.Y = (TextView) this.f67460i.b(R.id.current_order_guide_margin_transfer);
        this.T = (RadioButton) this.f67460i.b(R.id.plan_order_rb);
    }

    public void j3(OrderPlaceBean orderPlaceBean, AliToken aliToken) {
        if (this.I == null) {
            this.I = new l(this);
        }
        orderPlaceBean.setAliToken(aliToken);
        this.I.b(orderPlaceBean);
        VerifyActivity.startSimpleVerifyUI(getActivity(), VerifyType.NOCAPTCHA, "0335", (String) null, this.I);
    }

    public void k3() {
        if (isCanBeSeen()) {
            new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_trade_pioneer_black_country_hint)).P0(getString(R.string.n_known)).c1(getString(R.string.n_option_delivery_tip)).Q0(n0.f82674a).q0(false).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void l1() {
        if (!r.x().F0()) {
            this.O.setVisibility(8);
        } else if (((TradeBasePresenter) yh()).g() != 1 || a1.v().s0(((TradeBasePresenter) yh()).o0())) {
            this.O.setVisibility(8);
        } else {
            this.O.setVisibility(0);
        }
    }

    public void l2(String str) {
    }

    public void lj() {
    }

    public void m5(PrimeResult primeResult) {
        PrimeLayout primeLayout = this.F;
        if (primeLayout != null) {
            primeLayout.T((ViewGroup) this.f67460i.b(R.id.trade_spot_content_parent), primeResult);
        }
        if (primeResult != null && primeResult.isFinished()) {
            ((TradeBasePresenter) yh()).W1();
        }
    }

    public void mj(int i11, Map<String, String> map) {
        if (i11 == 1) {
            ((TradeBasePresenter) yh()).o1(map, this.I.a());
        }
    }

    public final void ni(String str) {
        ConstraintLayout constraintLayout = (ConstraintLayout) this.f67460i.b(R.id.trade_scrollview_content);
        if (constraintLayout != null) {
            View b11 = this.f67460i.b(R.id.margin_risk_rate_container);
            HTUpdradeMarkView hTUpdradeMarkView = (HTUpdradeMarkView) constraintLayout.findViewById(R.id.ht_upgrade_mark_view);
            if (HBHTtoHTXManager.f83692a.f(str)) {
                if (hTUpdradeMarkView == null) {
                    ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
                    layoutParams.f7942h = 0;
                    layoutParams.f7964s = 0;
                    layoutParams.f7968u = 0;
                    layoutParams.f7948k = 0;
                    constraintLayout.addView(new HTUpdradeMarkView(getActivity()), layoutParams);
                } else {
                    hTUpdradeMarkView.refreshView();
                }
                this.f82339y.setTradePriceChangeTvVisible(false);
                this.f82339y.f82414q.setVisibility(8);
                if (b11 != null) {
                    b11.setVisibility(8);
                    return;
                }
                return;
            }
            this.f82339y.f82414q.setVisibility(0);
            this.f82339y.setTradePriceChangeTvVisible(true);
            if (b11 != null) {
                b11.setVisibility(0);
            }
            if (hTUpdradeMarkView != null) {
                constraintLayout.removeView(hTUpdradeMarkView);
            }
        }
    }

    public void nj() {
        sn.f.C(getContext(), ((TradeBasePresenter) yh()).o0(), false, ((TradeBasePresenter) yh()).V0());
    }

    public void o3(int i11, int i12) {
        String str;
        int i13 = i11;
        int i14 = i12;
        SymbolBean J2 = a1.v().J(((TradeBasePresenter) yh()).o0(), ((TradeBasePresenter) yh()).V0());
        if (J2 != null) {
            str = i14 == 0 ? J2.getSymbolName() : J2.getBaseCurrencyDisplayName();
        } else {
            str = "";
        }
        if (i14 == 0) {
            this.E.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_normal);
            this.D.setText(String.format(getString(R.string.trade_reminder_had_details), new Object[]{StringUtils.i(str)}));
            this.D.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
            this.f82339y.setReminderTvVisible(false);
            this.C.setBackgroundResource(R.drawable.shape_trade_risk_reminder_blue_bg);
        } else if (i14 == 1) {
            this.E.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_risk);
            this.D.setText(String.format(getString(R.string.n_trade_reminder_st_details), new Object[]{StringUtils.i(str)}));
            this.D.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorShadeButtonRedStart));
            ContextCompat.getColor(getActivity(), R.color.baseColorShadeButtonRedEnd);
            this.f82339y.setReminderBg(R.drawable.market_st);
            this.f82339y.setReminderTvVisible(true);
            this.f82339y.setReminderTvOnClickListener((View.OnClickListener) null);
            this.C.setBackgroundResource(R.drawable.shape_trade_risk_reminder_red_bg);
        } else if (i14 == 2) {
            this.E.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_normal);
            this.D.setText(String.format(getString(R.string.trade_reminder_detail_text), new Object[]{StringUtils.i(str)}));
            this.D.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
            this.f82339y.setReminderTvVisible(false);
            this.C.setBackgroundResource(R.drawable.shape_trade_risk_reminder_blue_bg);
        } else if (i14 == 4) {
            if (J2 != null) {
                SpannableStringBuilder f11 = EtpRiskHintUtil.f(x7.d.b(J2.getBaseCurrency()), getContext(), J2.getBaseCurrencyDisplayName(), StringUtils.i(EtpRiskHintUtil.c(J2.getBaseCurrency())), StringUtils.i(J2.getQuoteCurrency()), ((TradeBasePresenter) yh()).I0().y(), ((TradeBasePresenter) yh()).I0().B(), PrecisionUtil.e(J2.getSymbol()), new w0(this), new h(), J2.getEtpLeverageRatio(), true, false);
                this.E.setBackgroundResource(EtpRiskHintUtil.g());
                this.D.setText(f11);
                this.D.setMovementMethod(LinkMovementMethod.getInstance());
                this.D.setHighlightColor(ContextCompat.getColor(getActivity(), 17170445));
                this.C.setBackgroundResource(EtpRiskHintUtil.e());
            }
            this.f82339y.setReminderTvVisible(false);
        } else if (i14 == 5) {
            this.E.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_normal);
            String string = getString(R.string.n_trade_observation_warning_hint);
            String string2 = getString(R.string.n_trade_observation_warning_more);
            int indexOf = string.toLowerCase().indexOf(string2.toLowerCase());
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            if (indexOf != -1) {
                spannableStringBuilder.setSpan(new i(), indexOf, string2.length() + indexOf, 17);
                spannableStringBuilder.setSpan(new UnderlineSpan(), indexOf, string2.length() + indexOf, 17);
            }
            this.D.setMovementMethod(LinkMovementMethod.getInstance());
            this.D.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
            this.D.setText(spannableStringBuilder);
            this.C.setBackgroundResource(R.drawable.shape_trade_risk_reminder_blue_bg);
            this.f82339y.setReminderTvVisible(false);
        } else if (i14 == 6) {
            this.E.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_normal);
            String string3 = getString(R.string.n_trade_pioneer_warning_hint);
            String string4 = getString(R.string.n_trade_observation_warning_more);
            int indexOf2 = string3.toLowerCase().indexOf(string4.toLowerCase());
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string3);
            if (indexOf2 != -1) {
                spannableStringBuilder2.setSpan(new j(), indexOf2, string4.length() + indexOf2, 17);
                spannableStringBuilder2.setSpan(new UnderlineSpan(), indexOf2, string4.length() + indexOf2, 17);
            }
            this.D.setMovementMethod(LinkMovementMethod.getInstance());
            this.D.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
            this.D.setText(spannableStringBuilder2);
            this.C.setBackgroundResource(R.drawable.shape_trade_risk_reminder_blue_bg);
            this.f82339y.setReminderTvVisible(false);
        } else if (i14 != 7) {
            this.f82339y.setReminderTvVisible(false);
        } else {
            this.f82339y.setReminderBg(R.drawable.market_innovate);
            this.f82339y.setReminderTvVisible(true);
            this.f82339y.setReminderTvOnClickListener(new v0(this));
        }
        if (J2 != null && J2.getSymbol() != null) {
            if (ReviewManger.a()) {
                this.C.setVisibility(8);
                wj(J2.getSymbol(), false);
                return;
            }
            this.C.setVisibility(i13);
            if (i13 == 8) {
                wj(J2.getSymbol(), true);
            } else {
                wj(J2.getSymbol(), false);
            }
        }
    }

    public final void oi(View.OnClickListener onClickListener, String str) {
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

    public void oj() {
        TextView textView = this.f82316j0;
        textView.setText("-- " + d7.k.C().z(((TradeBasePresenter) yh()).N0()));
        ((TradeBasePresenter) yh()).Z1();
    }

    public void onCreate(Bundle bundle) {
        if (this.f82334v0 == null) {
            this.f82334v0 = new mt.a(requireActivity().getApplication());
        }
        this.f82334v0.v0(requireActivity());
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        rj.b bVar = this.f82330t0;
        if (bVar != null) {
            bVar.B();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public final void pi(DialogUtils.b.f fVar) {
        if (isCanBeSeen()) {
            new DialogUtils.b.d(getActivity()).i1(1).M0(Integer.valueOf(R.drawable.pioneer_kyc_bg)).C0(getString(R.string.n_trade_pioneer_kyc_hint)).P0(getString(R.string.n_kyc_confirm)).s0(getString(R.string.n_cancel)).Q0(fVar).N0(l0.f82663a).k0().show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public final void pj(Integer num) {
        switch (num.intValue()) {
            case 0:
                if (r.x().F0()) {
                    CurrencySearchActivity.lj(getActivity(), "1", false);
                    return;
                }
                Intent intent = new Intent(getActivity(), CurrencySearchActivity.class);
                intent.putExtra("extra_type", "1");
                rn.c.i().d(getActivity(), new JumpTarget(intent, (Intent) null));
                return;
            case 1:
                vi();
                return;
            case 2:
                ui();
                return;
            case 3:
                EventBus.d().k(new ShowMarginGuideEvent());
                return;
            case 4:
                MarginCourseMgtBean marginCourseMgtBean = (MarginCourseMgtBean) AppConfigManager.c(MgtConfigNumber.MARGIN_COURSE_STATUS.number, MarginCourseMgtBean.class);
                if (marginCourseMgtBean != null) {
                    HBBaseWebActivity.showWebView(getActivity(), AppUtil.b(a0.j(), m6.a.h(), marginCourseMgtBean.getJumpUrl()), "", "", false);
                    return;
                }
                return;
            case 5:
                if (((TradeBasePresenter) yh()).V0() == TradeType.SUPERMARGIN) {
                    HBBaseWebActivity.showWebView(getActivity(), d1.n(), "", "", false);
                    return;
                } else if (((TradeBasePresenter) yh()).V0() == TradeType.MARGIN) {
                    HBBaseWebActivity.showWebView(getActivity(), d1.j(), "", "", false);
                    return;
                } else if (((TradeBasePresenter) yh()).V0() == TradeType.C2C) {
                    HBBaseWebActivity.showWebView(getActivity(), d1.e(), "", "", false);
                    return;
                } else {
                    return;
                }
            case 6:
                String o02 = ((TradeBasePresenter) yh()).o0();
                if (t.w(o02)) {
                    t.k(o02, getContext()).compose(RxJavaHelper.t((u6.g) zh())).subscribe(EasySubscriber.create(new s0(this)));
                    return;
                } else {
                    t.h(o02, getContext()).compose(RxJavaHelper.t((u6.g) zh())).subscribe(EasySubscriber.create(new t0(this)));
                    return;
                }
            case 7:
                HBHTtoHTXManager.f83692a.h();
                return;
            case 8:
                HBBaseWebActivity.showWebView(getActivity(), a0.r(), "", "", false);
                return;
            case 10:
                if (((TradeBasePresenter) yh()).V0() == TradeType.MARGIN) {
                    String o03 = ((TradeBasePresenter) yh()).o0();
                    if (o03 != null) {
                        MarginUtil.c(o03);
                        return;
                    }
                    return;
                } else if (((TradeBasePresenter) yh()).V0() == TradeType.C2C) {
                    C2CBorrowActivity.Ii(getActivity(), ((TradeBasePresenter) yh()).o0());
                    return;
                } else {
                    MarginUtil.a(((TradeBasePresenter) yh()).D0());
                    return;
                }
            default:
                return;
        }
    }

    public int qi() {
        return -1;
    }

    public void qj(int i11) {
        this.f82342z0 = i11;
    }

    public TradeType ri() {
        return TradeType.PRO;
    }

    public void rj(int i11) {
        this.f82340y0 = i11;
    }

    public void s(View view) {
        xj();
        if (!TextUtils.isEmpty(((TradeBasePresenter) yh()).o0())) {
            HashMap hashMap = new HashMap();
            hashMap.put("symbol", ((TradeBasePresenter) yh()).o0());
            if (((TradeBasePresenter) yh()).V0() == TradeType.MARGIN) {
                is.a.j("5978", hashMap, "1000101");
            } else if (((TradeBasePresenter) yh()).V0() == TradeType.SUPERMARGIN) {
                is.a.j("5978", hashMap, "1000100");
            }
        }
    }

    public final PrimeLayout si() {
        if (this.F == null) {
            Ci(getActivity());
        }
        return this.F;
    }

    public void sj() {
        this.f82325p.i(true);
        this.f82325p.g(false);
        this.f82325p.V(false);
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(getActivity());
        this.f82337x = smartRefreshHeader;
        this.f82325p.j0(smartRefreshHeader);
    }

    public void t4() {
    }

    public void th(boolean z11) {
        super.th(z11);
        if (z11) {
            this.f82334v0.s0(((TradeBasePresenter) yh()).o0(), ri());
        } else {
            this.f82334v0.t0();
        }
    }

    public void ti(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (!y.e(str) || !ad.o.c()) {
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
        MarginModeDialogFragment marginModeDialogFragment = new MarginModeDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_SUPPORT_MARGIN_MODE", this.f82319l0);
        bundle.putString("KEY_SUPPORT_MARGIN_RATIO", this.f82321m0);
        bundle.putString("KEY_SUPPORT_SUPER_MARGIN_RATIO", this.f82323n0);
        marginModeDialogFragment.setArguments(bundle);
        marginModeDialogFragment.show(getChildFragmentManager(), "MarginModeDialogFragment");
    }

    public void uh(boolean z11) {
        Map<Integer, Integer> map;
        super.uh(z11);
        if (getActivity() != null) {
            if (z11) {
                TradeType tradeType = TradeType.PRO;
                ClosePathFloatView.g(tradeType.toString(), getActivity(), true);
                if (k0.f83756f && yh() != null && ((TradeBasePresenter) yh()).V0() == tradeType && (map = this.f82307a0) != null) {
                    for (Integer next : map.keySet()) {
                        Integer num = this.f82307a0.get(next);
                        if (num != null && num.intValue() == 1) {
                            yj(next.intValue(), 1);
                        }
                    }
                    k0.f83756f = false;
                }
                CommonCheckBox commonCheckBox = this.M;
                if (commonCheckBox != null) {
                    commonCheckBox.setChecked(z.a());
                    return;
                }
                return;
            }
            TradeHeadView tradeHeadView = this.f82339y;
            if (tradeHeadView != null) {
                tradeHeadView.w();
            }
        }
    }

    public void ui() {
        if (getActivity() != null) {
            if (r.x().F0()) {
                TradingSettingActivity.Xh(getActivity());
            } else {
                rn.c.i().d(getActivity(), new JumpTarget(new Intent(getActivity(), TradingSettingActivity.class), (Intent) null));
            }
        }
    }

    public void uj(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, PrimeInfo primeInfo) {
        CustomBoardView customBoardView = this.f82335w;
        if (customBoardView != null) {
            customBoardView.hideKeyboardLayout();
        }
        if (viewGroup != null) {
            this.G = viewGroup;
        }
        PrimeLayout primeLayout = this.F;
        if (primeLayout != null && primeInfo != null && !TextUtils.isEmpty(primeLayout.getPrimeType()) && !this.F.getPrimeType().equalsIgnoreCase(primeInfo.getPrimeType())) {
            w1();
            this.F = null;
        }
        PrimeLayout si2 = si();
        if (si2 != null) {
            si2.setLayoutParams(layoutParams);
            if (si2.G(viewGroup, primeInfo, ((TradeBasePresenter) yh()).o0(), a1.v().n(((TradeBasePresenter) yh()).o0()), a1.v().D(((TradeBasePresenter) yh()).o0()), true) && getActivity() != null && (getActivity() instanceof HuobiMainActivity)) {
                ((HuobiMainActivity) getActivity()).ki(true);
            }
        }
    }

    public void vi() {
        String str;
        String str2;
        String str3;
        String o02 = ((TradeBasePresenter) yh()).o0();
        if (((TradeBasePresenter) yh()).V0() == TradeType.PRO) {
            if (((TradeBasePresenter) yh()).a1()) {
                str3 = a1.v().E(o02, ((TradeBasePresenter) yh()).V0());
            } else {
                str3 = a1.v().o(o02, ((TradeBasePresenter) yh()).V0());
            }
            String str4 = str3;
            HashMap hashMap = new HashMap(1);
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(str4));
            is.a.i("4109", hashMap);
            UnifyTransferActivity.Vh(getActivity(), str4, "1", true, (String) null, false, 1);
        } else if (((TradeBasePresenter) yh()).V0() == TradeType.MARGIN) {
            if (o02 != null) {
                if (((TradeBasePresenter) yh()).a1()) {
                    str2 = a1.v().E(o02, ((TradeBasePresenter) yh()).V0());
                } else {
                    str2 = a1.v().o(o02, ((TradeBasePresenter) yh()).V0());
                }
                String str5 = str2;
                HashMap hashMap2 = new HashMap(1);
                hashMap2.put("symbol", StringUtils.g(o02));
                is.a.i("4110", hashMap2);
                UnifyTransferActivity.Uh(getActivity(), str5, "3", false, o02, false);
            }
        } else if (((TradeBasePresenter) yh()).V0() == TradeType.C2C) {
            if (o02 != null) {
                HashMap hashMap3 = new HashMap(1);
                hashMap3.put("symbol", StringUtils.g(o02));
                is.a.i("4119", hashMap3);
                UnifyTransferActivity.Uh(getActivity(), (String) null, "8", false, o02, false);
            }
        } else if (o02 != null) {
            if (((TradeBasePresenter) yh()).a1()) {
                str = a1.v().E(o02, ((TradeBasePresenter) yh()).V0());
            } else {
                str = a1.v().o(o02, ((TradeBasePresenter) yh()).V0());
            }
            HashMap hashMap4 = new HashMap(1);
            hashMap4.put(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(str));
            is.a.i("4118", hashMap4);
            UnifyTransferActivity.Th(getActivity(), str, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL);
        }
    }

    public final void vj() {
        String str;
        MarginCourseMgtBean marginCourseMgtBean;
        TradeType V0 = ((TradeBasePresenter) yh()).V0();
        TradeType tradeType = TradeType.MARGIN;
        if (V0 == tradeType) {
            is.a.j("4302", (Map<String, Object>) null, "1000101");
            str = "margin";
        } else if (((TradeBasePresenter) yh()).V0() == TradeType.SUPERMARGIN) {
            is.a.j("4295", (Map<String, Object>) null, "1000100");
            str = "superMargin";
        } else {
            str = "";
        }
        if (getActivity() instanceof FragmentActivity) {
            String o02 = ((TradeBasePresenter) yh()).o0();
            boolean z11 = false;
            if ((((TradeBasePresenter) yh()).V0() == tradeType || ((TradeBasePresenter) yh()).V0() == TradeType.SUPERMARGIN) && (marginCourseMgtBean = (MarginCourseMgtBean) AppConfigManager.c(MgtConfigNumber.MARGIN_COURSE_STATUS.number, MarginCourseMgtBean.class)) != null && !marginCourseMgtBean.getJumpUrl().isEmpty()) {
                z11 = true;
            }
            String str2 = "true";
            String str3 = r.x().F0() ? str2 : com.sumsub.sns.internal.core.analytics.d.f31895b;
            String str4 = t.w(o02) ? str2 : com.sumsub.sns.internal.core.analytics.d.f31895b;
            if (!z11) {
                str2 = com.sumsub.sns.internal.core.analytics.d.f31895b;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("showGuide", str2);
            hashMap.put("isFavorite", str4);
            hashMap.put("isLogin", str3);
            hashMap.put("transactionType", str);
            rj.b bVar = this.f82330t0;
            bVar.I("sendMoreFunctionsPopData(" + JSON.toJSONString(hashMap) + ")");
            this.f82330t0.I("showMoreView()");
        }
    }

    public void w1() {
        PrimeLayout primeLayout;
        ViewGroup viewGroup = this.G;
        if (!(viewGroup == null || (primeLayout = this.F) == null)) {
            try {
                primeLayout.p(viewGroup);
            } catch (Exception unused) {
            }
        }
        if (getActivity() != null && (getActivity() instanceof HuobiMainActivity) && com.hbg.lib.core.util.b.c().f()) {
            ((HuobiMainActivity) getActivity()).ki(true);
        }
    }

    public void wb(SpotContractEntryBean spotContractEntryBean, String str) {
        this.f82339y.setTag(spotContractEntryBean);
        this.f82339y.setMarginLeverText(str);
    }

    public void wi() {
        this.f82335w.hideKeyboardLayout();
    }

    public final void wj(String str, boolean z11) {
        ViewGroup viewGroup = (ViewGroup) this.f67460i.b(R.id.llAdEdgeEngine);
        if (viewGroup == null) {
            return;
        }
        if (z11) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
    }

    public void x2(boolean z11, boolean z12, String str) {
        UserInfoUtil.h((u6.g) zh(), new x(this, z11, z12, str));
    }

    public void x3(String str) {
        PrimeLayout si2 = si();
        if (si2 != null) {
            si2.K(str);
        }
    }

    public void xi() {
        this.f82315i0.setOnClickListener(new z0(this));
    }

    public final void xj() {
        if (getActivity() instanceof HuobiMainActivity) {
            HuobiMainActivity huobiMainActivity = (HuobiMainActivity) getActivity();
            com.huobi.main.helper.l.c().h(((TradeBasePresenter) yh()).V0(), ((TradeBasePresenter) yh()).o0(), ((TradeBasePresenter) yh()).N0());
        } else if (getActivity() instanceof TradeContainerActivity) {
            ((TradeContainerActivity) getActivity()).fg(((TradeBasePresenter) yh()).V0(), ((TradeBasePresenter) yh()).o0(), ((TradeBasePresenter) yh()).N0());
        }
    }

    public void y0(boolean z11) {
        this.f82337x.b(DateTimeUtils.h(DateTimeUtils.v(), "MM-dd HH:mm:ss"));
        if (z11) {
            this.f82325p.finishRefresh();
            this.f82325p.setNoMoreData(false);
            return;
        }
        this.f82325p.w();
    }

    public abstract void yi();

    public final void yj(int i11, Integer num) {
        if (num != null && num.intValue() != ((TradeBasePresenter) yh()).g()) {
            this.J.c(i11);
            this.J.b(i11, 0.0f, 0);
            ((TradeBasePresenter) yh()).B1(num.intValue());
            i2.a().f(ri(), num.intValue());
            if (num.intValue() != 1) {
                this.P.setVisibility(8);
                this.U.setVisibility(0);
            } else {
                ((TradeBasePresenter) yh()).t1();
            }
            int intValue = num.intValue();
            if (intValue == 1) {
                ((TradeBasePresenter) yh()).K1();
                ((TradeBasePresenter) yh()).J1();
                ((TradeBasePresenter) yh()).M1();
                ((TradeBasePresenter) yh()).P1();
                ((TradeBasePresenter) yh()).W1();
            } else if (intValue != 2) {
                String str = "vertical";
                if (intValue == 3) {
                    ((TradeBasePresenter) yh()).K1();
                    ((TradeBasePresenter) yh()).M1();
                    ((TradeBasePresenter) yh()).P1();
                    ((TradeBasePresenter) yh()).E1();
                    HashMap hashMap = new HashMap();
                    hashMap.put("trade_mode", FutureContractInfo.MARGIN_CROSS);
                    if (this.f82340y0 != 1) {
                        str = MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL;
                    }
                    hashMap.put("version_type", str);
                    gs.g.i("app_trade_assets_tab_click", hashMap);
                } else if (intValue == 4) {
                    ((TradeBasePresenter) yh()).K1();
                    ((TradeBasePresenter) yh()).J1();
                    ((TradeBasePresenter) yh()).P1();
                    ((TradeBasePresenter) yh()).G1();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("trade_mode", FutureContractInfo.MARGIN_CROSS);
                    if (this.f82340y0 != 1) {
                        str = MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL;
                    }
                    hashMap2.put("version_type", str);
                    gs.g.i("app_trade_outstanding_tab_click", hashMap2);
                } else if (intValue != 9) {
                    ((TradeBasePresenter) yh()).K1();
                    ((TradeBasePresenter) yh()).J1();
                    ((TradeBasePresenter) yh()).M1();
                    ((TradeBasePresenter) yh()).P1();
                    ((TradeBasePresenter) yh()).Y0(false, ((TradeBasePresenter) yh()).o0(), false);
                } else {
                    ((TradeBasePresenter) yh()).K1();
                    ((TradeBasePresenter) yh()).J1();
                    ((TradeBasePresenter) yh()).M1();
                    ((TradeBasePresenter) yh()).H1();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("trade_mode", FutureContractInfo.MARGIN_ISOLATED);
                    if (this.f82342z0 != 1) {
                        str = MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL;
                    }
                    hashMap3.put("version_type", str);
                    gs.g.i("app_trade_positions_tab_click", hashMap3);
                }
            } else {
                this.L.setVisibility(8);
                ((TradeBasePresenter) yh()).J1();
                ((TradeBasePresenter) yh()).M1();
                ((TradeBasePresenter) yh()).P1();
                ((TradeBasePresenter) yh()).F1();
            }
            com.huobi.trade.helper.c.b().j(num);
            com.huobi.trade.helper.c.b().g();
            l1();
            ((TradeBasePresenter) yh()).S1();
            ((TradeBasePresenter) yh()).X1();
            ((TradeBasePresenter) yh()).z0();
        }
    }

    public /* synthetic */ boolean z6() {
        return g1.b(this);
    }

    public void z8(boolean z11, boolean z12) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof TradeFragment) {
            ((TradeFragment) parentFragment).z8(false, true);
        }
    }

    public void zj() {
        if (this.f82330t0 == null) {
            rj.b bVar = new rj.b(getActivity(), "exchange");
            this.f82330t0 = bVar;
            bVar.H();
            this.f82339y.addView(this.f82330t0.D("mainBody.xml", getActivity()));
            this.f82339y.addView(this.f82330t0.D("brrowBody.xml", getActivity()));
            this.f82330t0.u("exchange.clickedItem", new u0(this));
        }
    }
}
