package com.huobi.trade.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.module.kline.view.KlineViewWrapper;
import com.huobi.activity.TradeContainerActivity;
import com.huobi.homemarket.helper.AppBarStateChangeListener;
import com.huobi.trade.presenter.TradePresenter;
import com.huobi.trade.utils.TradeFragmentTitleHelper;
import com.huobi.tradenew.ui.kline.KlineView;
import com.huobi.utils.HBHTtoHTXManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import java.util.HashMap;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import sn.f;
import yl.x;

public class TradeFragment extends BaseFragment<TradePresenter, TradePresenter.a> implements TradePresenter.a {
    public final TradeFragmentTitleHelper A = new TradeFragmentTitleHelper();

    /* renamed from: l  reason: collision with root package name */
    public View f82377l;

    /* renamed from: m  reason: collision with root package name */
    public AppBarLayout f82378m;

    /* renamed from: n  reason: collision with root package name */
    public FrameLayout f82379n;

    /* renamed from: o  reason: collision with root package name */
    public ViewGroup f82380o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f82381p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f82382q;

    /* renamed from: r  reason: collision with root package name */
    public View f82383r;

    /* renamed from: s  reason: collision with root package name */
    public View f82384s;

    /* renamed from: t  reason: collision with root package name */
    public KlineViewWrapper f82385t;

    /* renamed from: u  reason: collision with root package name */
    public View f82386u;

    /* renamed from: v  reason: collision with root package name */
    public int f82387v = 220;

    /* renamed from: w  reason: collision with root package name */
    public int f82388w = -1;

    /* renamed from: x  reason: collision with root package name */
    public Map<String, View.OnClickListener> f82389x = new HashMap();

    /* renamed from: y  reason: collision with root package name */
    public ImageView f82390y;

    /* renamed from: z  reason: collision with root package name */
    public KlineView f82391z;

    public class a implements TradeFragmentTitleHelper.c {
        public a() {
        }

        public void a() {
            TradeFragment.this.w3();
        }

        public TradePresenter f2() {
            return (TradePresenter) TradeFragment.this.yh();
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            TradeFragment.this.w3();
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ((TradePresenter) TradeFragment.this.yh()).h0(true);
            TradeFragment.this.f82391z.i(false, ((TradePresenter) TradeFragment.this.yh()).c0().toString(), ((TradePresenter) TradeFragment.this.yh()).o0(), PrecisionUtil.e(((TradePresenter) TradeFragment.this.yh()).o0()), PrecisionUtil.w(((TradePresenter) TradeFragment.this.yh()).o0(), ((TradePresenter) TradeFragment.this.yh()).c0()));
            TradeFragment.this.f82391z.C();
            TradeFragment.this.f82391z.r();
            TradeFragment.this.f82383r.setVisibility(0);
        }
    }

    public class d extends AppBarStateChangeListener {
        public d() {
        }

        public void a(AppBarLayout appBarLayout, AppBarStateChangeListener.State state) {
            if (state == AppBarStateChangeListener.State.COLLAPSED || state == AppBarStateChangeListener.State.EXPANDED) {
                EventBus.d().k(new at.b(state));
            }
        }
    }

    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f82396a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f82396a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.C2C     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f82396a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f82396a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.MARGIN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.trade.ui.TradeFragment.e.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph() {
        this.f82384s.setTranslationY((float) this.f82391z.getLayoutParams().height);
        this.f82391z.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Qh(Object obj) {
        Oh();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (((TradePresenter) yh()).f0()) {
            this.f82382q.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_arrow_up, 0);
            ViewPropertyAnimator duration = this.f82384s.animate().translationY((float) this.f82391z.getHeight()).setInterpolator(new DecelerateInterpolator()).setDuration((long) this.f82387v);
            duration.setListener(new b());
            duration.start();
        } else {
            this.f82382q.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_down_button, 0);
            ViewPropertyAnimator duration2 = this.f82384s.animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).setDuration((long) this.f82387v);
            duration2.setListener(new c());
            duration2.start();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        w3();
        ConfigPreferences.m("user_config", "config_period", Period.timeline.key);
        f.C(getContext(), ((TradePresenter) yh()).o0(), false, ((TradePresenter) yh()).c0());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof TradeContainerActivity)) {
            activity.finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        this.f82380o.setOnClickListener(new w1(this));
        this.f82385t.setOnClickListener(new x1(this));
        this.f82378m.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new d());
        this.f82390y.setOnClickListener(new v1(this));
    }

    public void B3(int i11) {
        this.A.q(i11);
    }

    public void D2() {
        this.f82385t.C();
    }

    public void Jh(TradeType tradeType) {
        if (e.f82396a[tradeType.ordinal()] != 3) {
            ((TradePresenter) yh()).r0(((TradePresenter) yh()).o0());
        } else {
            ((TradePresenter) yh()).m0(((TradePresenter) yh()).o0());
        }
    }

    /* renamed from: Kh */
    public TradePresenter xh() {
        return new TradePresenter();
    }

    /* renamed from: Lh */
    public TradePresenter.a zh() {
        return this;
    }

    public final void Mh() {
        this.f82380o = (ViewGroup) this.f67460i.b(R.id.trade_vertical_kline_show_rl);
        this.f82381p = (TextView) this.f67460i.b(R.id.trade_vertical_kline_symbol_tv);
        this.f82382q = (TextView) this.f67460i.b(R.id.trade_vertical_kline_show_tv);
        this.f82385t = (KlineViewWrapper) this.f67460i.b(R.id.klineViewWrapper);
        this.f82386u = this.f67460i.b(R.id.kline_wrapper_container);
        this.f82391z = (KlineView) this.f67460i.b(R.id.klineViewWrapper_rl);
        this.f82383r = this.f67460i.b(R.id.klineViewWrapper_bottom_divider);
        View view = (View) this.f82391z.getParent();
        this.f82384s = view;
        view.post(new z1(this));
    }

    public final void Nh() {
        int statusBarHeight = BaseActivity.getStatusBarHeight(getContext());
        View b11 = this.f67460i.b(R.id.trade_page_status_bar);
        ViewGroup.LayoutParams layoutParams = b11.getLayoutParams();
        layoutParams.height = statusBarHeight;
        b11.setLayoutParams(layoutParams);
        View b12 = this.f67460i.b(R.id.appbar_layout);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) b12.getLayoutParams();
        marginLayoutParams.topMargin = statusBarHeight;
        b12.setLayoutParams(marginLayoutParams);
    }

    public final void Oh() {
        this.A.o(getActivity(), this.f67460i, new a());
    }

    public void Rh(TradeType tradeType, View.OnClickListener onClickListener) {
        Map<String, View.OnClickListener> map = this.f82389x;
        map.put(tradeType.toString() + com.hbg.lib.core.util.b.c().f(), onClickListener);
        S8(tradeType);
    }

    public void S8(TradeType tradeType) {
        int i11 = e.f82396a[tradeType.ordinal()];
    }

    public void Sh() {
        Th(((TradePresenter) yh()).o0());
        this.f82391z.i(false, ((TradePresenter) yh()).c0().toString(), ((TradePresenter) yh()).o0(), PrecisionUtil.e(((TradePresenter) yh()).o0()), PrecisionUtil.w(((TradePresenter) yh()).o0(), ((TradePresenter) yh()).c0()));
        if (((TradePresenter) yh()).f0()) {
            this.f82391z.r();
        }
    }

    public void Th(String str) {
        TextView textView = this.f82381p;
        textView.setText(a1.v().W(str) + " " + getString(R.string.contract_kline_chart));
        if (!TextUtils.equals(str, this.f82391z.M)) {
            w3();
            this.f82385t.G();
            this.f82391z.M = str;
        }
        com.huobi.trade.helper.c.b().i(str);
        this.f82386u.setVisibility(HBHTtoHTXManager.f83692a.f(str) ? 8 : 0);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void changeMarginTradeType(TradeType tradeType) {
        if (e.f82396a[tradeType.ordinal()] != 3) {
            ((TradePresenter) yh()).q0();
        } else {
            ((TradePresenter) yh()).l0();
        }
    }

    public void initViews() {
        super.initViews();
        Nh();
        Mh();
        this.f82378m = (AppBarLayout) this.f67460i.b(R.id.appbar_layout);
        this.f82377l = this.f67460i.b(R.id.title_divider_container);
        this.f82379n = (FrameLayout) this.f67460i.b(R.id.future_tab_content);
        Oh();
        we.b.l("tradeCouponPoint", Object.class).observe(this, new y1(this));
        this.f82377l.setVisibility(0);
        this.f82390y = (ImageView) this.f67460i.b(R.id.trade_home_up);
        if (getActivity() instanceof TradeContainerActivity) {
            this.f82390y.setVisibility(0);
        } else {
            this.f82390y.setVisibility(8);
        }
    }

    public void j0(int i11) {
        this.A.r(getString(i11));
    }

    public void onDestroyView() {
        super.onDestroyView();
        EventBus.d().r(this);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        EventBus.d().p(this);
        return layoutInflater.inflate(R.layout.fragment_trade, viewGroup, false);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11 && !x.n().r()) {
            x.n().t(getActivity());
        }
    }

    public void w3() {
        this.f82382q.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_arrow_up, 0);
        if (((TradePresenter) yh()).f0()) {
            this.f82384s.setTranslationY((float) this.f82391z.getHeight());
            D2();
        }
        ((TradePresenter) yh()).h0(false);
        this.f82383r.setVisibility(8);
    }

    public void z8(boolean z11, boolean z12) {
        this.f82378m.setExpanded(z11, z12);
    }
}
