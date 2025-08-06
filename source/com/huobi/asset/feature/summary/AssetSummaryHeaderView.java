package com.huobi.asset.feature.summary;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.SilentSubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.lib.widgets.LittlePieChartAnimView;
import com.hbg.lib.widgets.NumberAnimView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.feature.summary.AssetSummaryUserGuideView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.ui.r7;
import com.huobi.otc.utils.EaseOutElastic;
import com.huobi.view.FontIconTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import qh.a0;
import qh.b0;
import qh.c0;
import qh.d0;
import qh.e0;
import qh.i0;
import qh.n;
import qh.o;
import qh.p;
import qh.p0;
import qh.r;
import qh.s;
import qh.t;
import qh.u;
import qh.v;
import qh.w;
import qh.x;
import qh.y;
import qh.z;
import rh.q;

public class AssetSummaryHeaderView extends FrameLayout {
    public TextView A;
    public View B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public r7 I;
    public BalanceProfitLossData J;
    public boolean K;
    public h L;

    /* renamed from: b  reason: collision with root package name */
    public View f42366b;

    /* renamed from: c  reason: collision with root package name */
    public AssetSummaryUserGuideView f42367c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f42368d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f42369e;

    /* renamed from: f  reason: collision with root package name */
    public NumberAnimView f42370f;

    /* renamed from: g  reason: collision with root package name */
    public NumberAnimView f42371g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f42372h;

    /* renamed from: i  reason: collision with root package name */
    public View f42373i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42374j;

    /* renamed from: k  reason: collision with root package name */
    public NumberAnimView f42375k;

    /* renamed from: l  reason: collision with root package name */
    public NumberAnimView f42376l;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f42377m;

    /* renamed from: n  reason: collision with root package name */
    public FontIconTextView f42378n;

    /* renamed from: o  reason: collision with root package name */
    public View f42379o;

    /* renamed from: p  reason: collision with root package name */
    public ImageView f42380p;

    /* renamed from: q  reason: collision with root package name */
    public LittlePieChartAnimView f42381q;

    /* renamed from: r  reason: collision with root package name */
    public LinearLayout f42382r;

    /* renamed from: s  reason: collision with root package name */
    public View f42383s;

    /* renamed from: t  reason: collision with root package name */
    public View f42384t;

    /* renamed from: u  reason: collision with root package name */
    public View f42385u;

    /* renamed from: v  reason: collision with root package name */
    public View f42386v;

    /* renamed from: w  reason: collision with root package name */
    public int f42387w;

    /* renamed from: x  reason: collision with root package name */
    public int f42388x;

    /* renamed from: y  reason: collision with root package name */
    public CommonSwitchButton f42389y;

    /* renamed from: z  reason: collision with root package name */
    public View f42390z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            BaseModuleConfig.a().b("3128", (Map<String, Object>) null);
            AssetModuleConfig.a().N(AssetSummaryHeaderView.this.getContext());
            HashMap hashMap = new HashMap(1);
            hashMap.put("Page_name", "app_assets_overview_view");
            BaseModuleConfig.a().w("app_assets_balances_daily_click", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements AssetSummaryUserGuideView.d {
        public b() {
        }

        public void a() {
            q.M();
            AssetSummaryHeaderView.this.g0();
            BaseModuleConfig.a().w("app_assets_overview_digital_now_pop_shut_click", (HashMap) null);
        }

        public void b() {
            AssetModuleConfig.a().C((Activity) AssetSummaryHeaderView.this.getContext());
            BaseModuleConfig.a().w("app_assets_overview_digital_now_pop_fast_click", (HashMap) null);
        }

        public void c() {
            BaseModuleConfig.a().b("3523", (Map<String, Object>) null);
            AssetModuleConfig.a().v0((Activity) AssetSummaryHeaderView.this.getContext(), "1");
            BaseModuleConfig.a().w("app_assets_overview_digital_now_pop_deposit_click", (HashMap) null);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            AssetSummaryHeaderView.this.f42367c.setVisibility(8);
            AssetSummaryHeaderView assetSummaryHeaderView = AssetSummaryHeaderView.this;
            assetSummaryHeaderView.w(assetSummaryHeaderView.J);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            AssetModuleConfig.a().P0(AssetSummaryHeaderView.this.getContext(), "btcusdt", false);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("Page_name", "app_assets_overview_view");
            BaseModuleConfig.a().w("app_assets_deposit_click", hashMap);
            if (AssetModuleConfig.a().c()) {
                HuobiToastUtil.j(R$string.n_balance_subaccount_deposit_nosupport);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            BaseModuleConfig.a().b("3523", (Map<String, Object>) null);
            AssetModuleConfig.a().v0(AssetSummaryHeaderView.this.getActivity(), "1");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("Page_name", "app_assets_overview_view");
            BaseModuleConfig.a().w("app_assets_withdraw_click", hashMap);
            if (AssetModuleConfig.a().c()) {
                HuobiToastUtil.j(R$string.n_balance_subaccount_withdraw_nosupport);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            BaseModuleConfig.a().b("3524", (Map<String, Object>) null);
            AssetModuleConfig.a().v0(AssetSummaryHeaderView.this.getActivity(), "2");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("Page_name", "app_assets_overview_view");
            BaseModuleConfig.a().w("app_assets_transfer_click", hashMap);
            BaseModuleConfig.a().b("3525", (Map<String, Object>) null);
            AssetModuleConfig.a().q(AssetSummaryHeaderView.this.getActivity());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface h {
        void Dc(boolean z11);

        void Eb();

        void H7();

        void o7();
    }

    public static class i implements NumberAnimView.b {
        public i() {
        }

        public String a(String str) {
            if (!m.a0(str)) {
                return str;
            }
            String str2 = m.a(str).compareTo(BigDecimal.ZERO) > 0 ? "+" : "";
            String str3 = "%";
            if (m.a(str).compareTo(m.a("10000")) > 0) {
                str3 = "⁺" + str3;
                str = "10000";
            }
            if (m.a(str).compareTo(m.a("-100")) < 0) {
                str = "-100";
            }
            return str2 + str + str3;
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    public AssetSummaryHeaderView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void I(View view) {
        a0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void J(View view) {
        BaseModuleConfig.a().w("app_assets_Cloud_Wallet_click", (HashMap) null);
        h hVar = this.L;
        if (hVar != null) {
            hVar.H7();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void K(View view) {
        BaseModuleConfig.a().w("app_assets_Huobi_Earn_click", (HashMap) null);
        A();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void L(View view) {
        uh.b.a(view, String.format(getResources().getString(R$string.n_balance_hide_balance_summary_tip), new Object[]{"0.0001"}));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void M(View view) {
        h0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void N(View view) {
        DialogUtils.X((FragmentActivity) oa.a.g().b(), getContext().getString(R$string.n_option_delivery_tip), this.H, (String) null, getContext().getString(R$string.n_known), ad.b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void O(View view) {
        h hVar = this.L;
        if (hVar != null) {
            hVar.o7();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void P(View view) {
        CommonSwitchButton commonSwitchButton = this.f42389y;
        commonSwitchButton.b(!commonSwitchButton.isChecked(), true);
        h hVar = this.L;
        if (hVar != null) {
            hVar.Dc(this.f42389y.isChecked());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Q(View view) {
        BaseModuleConfig.a().R(getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ String R(String str) {
        if (!m.a0(str)) {
            return str;
        }
        return "≈" + str + " " + LegalCurrencyConfigUtil.y().toUpperCase(Locale.US);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void S(View view) {
        DialogUtils.X((FragmentActivity) oa.a.g().b(), getContext().getString(R$string.n_option_delivery_tip), this.H, (String) null, getContext().getString(R$string.n_known), ad.b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ String T(String str) {
        if (!m.a0(str)) {
            return str;
        }
        String str2 = m.a(str).compareTo(BigDecimal.ZERO) > 0 ? "+" : "";
        return str2 + str;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void U(View view) {
        DialogUtils.X((FragmentActivity) oa.a.g().b(), getResources().getString(R$string.setting_quickly_withdraw_dialog_title), getResources().getString(R$string.income_today_tips), "", getContext().getString(R$string.otc_ppace_order_dialog_btn_know), ad.b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(boolean z11) {
        this.K = z11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(HBDialogFragment hBDialogFragment) {
        ConfigPreferences.n("user_config", "config_safety_hint", this.K);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(Boolean bool) {
        ViewUtil.m(this.f42386v, bool.booleanValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(ValueAnimator valueAnimator) {
        h hVar = this.L;
        if (hVar != null) {
            hVar.Eb();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(ValueAnimator valueAnimator) {
        this.f42366b.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        h hVar = this.L;
        if (hVar != null) {
            hVar.Eb();
        }
    }

    /* access modifiers changed from: private */
    public Activity getActivity() {
        return (Activity) getContext();
    }

    public final void A() {
        BaseModuleConfig.a().b("5171", (Map<String, Object>) null);
        AssetModuleConfig.a().m1(getContext());
    }

    public final void B() {
        this.A.setOnClickListener(new o(this));
        this.f42368d.setOnClickListener(new z(this));
        this.f42372h.setOnClickListener(new c0(this));
        this.f42373i.setOnClickListener(new a());
        this.f42367c.setCallback(new b());
        this.f42379o.setOnClickListener(new qh.q(this));
        this.f42389y.setOnClickListener(new a0(this));
        this.B.setOnClickListener(new e0(this));
        this.f42385u.setOnClickListener(new y(this));
        this.f42386v.setOnClickListener(new x(this));
    }

    public final void C() {
        ArrayList arrayList = new ArrayList();
        if (AssetModuleConfig.a().j0()) {
            arrayList.add(new vk.c(getContext().getResources().getString(R$string.n_balance_asset_disposal), new d()));
        } else if (!AssetModuleConfig.a().w()) {
            arrayList.add(new vk.c(getContext().getResources().getString(R$string.balance_detail_deposit), new e()));
        }
        arrayList.add(new vk.c(getContext().getResources().getString(R$string.balance_detail_withdraw), new f()));
        arrayList.add(new vk.c(getContext().getResources().getString(R$string.balance_margin_transfer), new g()));
        arrayList.add(new vk.c(getContext().getResources().getString(R$string.n_asset_record), new d0(this)));
        this.f42382r.removeAllViews();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            LinearLayout linearLayout = this.f42382r;
            linearLayout.addView(x(linearLayout, i11, (vk.c) arrayList.get(i11)));
        }
    }

    public final void D() {
        NumberAnimView numberAnimView = this.f42370f;
        Resources resources = getResources();
        int i11 = R$color.balance_main_text_color;
        numberAnimView.setTextColor(resources.getColor(i11));
        this.f42370f.setTextSize(getResources().getDimensionPixelOffset(R$dimen.global_text_size_28));
        this.f42371g.setTextColor(getResources().getColor(i11));
        this.f42371g.setTextSize(getResources().getDimensionPixelOffset(R$dimen.global_text_size_12));
        this.f42371g.setCallback(s.f53371a);
    }

    public final void E() {
        this.C = getResources().getString(R$string.balance_hide_star);
        this.f42372h.setOnClickListener(new p(this));
        D();
        F();
        C();
    }

    public final void F() {
        this.f42375k.setText("--");
        this.f42376l.setText("--");
        NumberAnimView numberAnimView = this.f42375k;
        Resources resources = getResources();
        int i11 = R$dimen.global_text_size_14;
        numberAnimView.setTextSize(resources.getDimensionPixelOffset(i11));
        NumberAnimView numberAnimView2 = this.f42375k;
        Context context = getContext();
        int i12 = R$color.balance_main_text_color;
        numberAnimView2.setTextColor(ContextCompat.getColor(context, i12));
        this.f42376l.setTextSize(getResources().getDimensionPixelOffset(i11));
        this.f42376l.setTextColor(ContextCompat.getColor(getContext(), i12));
        this.f42375k.setCallback(r.f53370a);
        this.f42376l.setCallback(new i((a) null));
        this.f42377m.setVisibility(0);
        this.f42377m.setOnClickListener(new b0(this));
    }

    public final void G() {
        LayoutInflater.from(getContext()).inflate(R$layout.item_asset_summary_header, this);
        this.f42366b = findViewById(R$id.layout_asset_header);
        this.f42367c = (AssetSummaryUserGuideView) findViewById(R$id.layout_asset_user_guide);
        if (q.t()) {
            this.f42366b.setVisibility(0);
            this.f42367c.setVisibility(8);
        } else {
            this.f42366b.setVisibility(8);
            this.f42367c.setVisibility(0);
        }
        this.f42368d = (ImageView) findViewById(R$id.header_iv_asset_show);
        this.f42369e = (TextView) findViewById(R$id.header_tv_asset_total_title);
        this.f42370f = (NumberAnimView) findViewById(R$id.total_balance_header_balance);
        this.f42371g = (NumberAnimView) findViewById(R$id.total_balance_header_cny);
        this.f42372h = (ImageView) findViewById(R$id.header_iv_asset_warning);
        this.f42373i = findViewById(R$id.header_asset_analysis);
        this.f42374j = (TextView) findViewById(R$id.tv_profit_title);
        this.f42375k = (NumberAnimView) findViewById(R$id.profit_amount);
        this.f42376l = (NumberAnimView) findViewById(R$id.profit_amount_ratio);
        this.f42377m = (ImageView) findViewById(R$id.profit_tips);
        FontIconTextView fontIconTextView = (FontIconTextView) findViewById(R$id.header_asset_profit_arrow);
        this.f42378n = fontIconTextView;
        fontIconTextView.setVisibility(0);
        this.f42379o = findViewById(R$id.asset_header_open_analysis_panel);
        this.f42380p = (ImageView) findViewById(R$id.asset_header_iv_analysis_chart);
        this.f42381q = (LittlePieChartAnimView) findViewById(R$id.asset_header_chart_anim);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.asset_header_actions_container);
        this.f42382r = linearLayout;
        linearLayout.setVisibility(0);
        this.f42383s = findViewById(R$id.layout_asset_summary_fast_entrance);
        this.f42384t = findViewById(R$id.fast_entrance_item_space);
        this.f42385u = findViewById(R$id.cloud_wallet_entrance);
        View findViewById = findViewById(R$id.huobi_earn_entrance);
        this.f42386v = findViewById;
        findViewById.setVisibility(8);
        this.f42389y = (CommonSwitchButton) findViewById(R$id.list_toolbar_switcher);
        TextView textView = (TextView) findViewById(R$id.tv_hide_small_balance);
        this.A = textView;
        textView.setText(R$string.n_balance_hidden_small_account);
        this.f42390z = findViewById(R$id.search_panel);
        this.B = findViewById(R$id.security_tips_panel);
        this.f42390z.setVisibility(8);
        e0();
        d0();
    }

    public final boolean H(BalanceProfitLossData balanceProfitLossData) {
        return m.f0(m.a(balanceProfitLossData.getTotalBalance()), BigDecimal.ZERO);
    }

    public final void a0() {
        FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
        new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R$string.balance_safety_hint)).i1(1).M0(Integer.valueOf(R$drawable.popups_safety_img)).P0(getContext().getString(R$string.contract_trade_i_know)).x0(false).y0(getContext().getString(R$string.contract_trigger_order_change_not_show)).v0(new t(this)).q0(false).Q0(new u(this)).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }

    public final void b0() {
        boolean h11 = i0.d().h();
        ViewUtil.m(this.f42379o, !h11);
        ViewUtil.m(this.f42373i, h11);
        if (h11) {
            this.f42366b.getLayoutParams().height = getResources().getDimensionPixelSize(R$dimen.dimen_168);
            return;
        }
        this.f42366b.getLayoutParams().height = getResources().getDimensionPixelSize(R$dimen.dimen_146);
    }

    public void c0(boolean z11) {
        if (!al.p.u()) {
            this.f42375k.setText(this.C);
            this.f42376l.setText(this.C);
            this.f42370f.setText(this.C);
            this.f42371g.setText(this.C);
            this.f42368d.setImageResource(R$drawable.balances_hide);
            return;
        }
        uh.a.d(this.f42375k, this.D, z11);
        uh.a.d(this.f42376l, this.E, z11);
        uh.a.d(this.f42370f, this.F, z11);
        uh.a.d(this.f42371g, this.G, z11);
        this.f42368d.setImageResource(R$drawable.balances_show);
    }

    public final void d0() {
        zq.e.e().f(true).compose(RxJavaHelper.t((u6.g) null)).subscribe(SilentSubscriber.a(new v(this)));
    }

    public final void e0() {
        if (!ConfigPreferences.c("user_config", "config_safety_hint", false)) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
        }
    }

    public final void f0() {
        String upperCase = LegalCurrencyConfigUtil.y().toUpperCase(Locale.US);
        this.f42374j.setText(getResources().getString(R$string.n_balance_today_profit, new Object[]{StringUtils.i(upperCase)}));
    }

    public final void g0() {
        View findViewById = findViewById(R$id.asset_header_bottom_panel);
        this.f42388x = this.f42367c.getHeight();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new EaseOutElastic());
        animatorSet.addListener(new c());
        long j11 = (long) 300;
        animatorSet.setDuration(j11);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f42367c, "alpha", new float[]{1.0f, 0.0f}).setDuration(j11);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.f42366b, "alpha", new float[]{0.0f, 1.0f}).setDuration(j11);
        ObjectAnimator duration3 = ObjectAnimator.ofInt(findViewById, "translationY", new int[]{this.f42388x - this.f42387w, 0}).setDuration(j11);
        duration3.addUpdateListener(new n(this));
        int i11 = this.f42387w;
        int i12 = this.f42388x;
        if (i11 > i12) {
            ViewGroup.LayoutParams layoutParams = this.f42366b.getLayoutParams();
            int i13 = this.f42388x;
            layoutParams.height = i13;
            ValueAnimator duration4 = ValueAnimator.ofInt(new int[]{i13, this.f42387w}).setDuration(j11);
            duration4.addUpdateListener(new w(this));
            animatorSet.playTogether(new Animator[]{duration, duration2, duration4, duration3});
            animatorSet.start();
        } else if (i11 < i12) {
            animatorSet.playTogether(new Animator[]{duration, duration2, duration3});
            animatorSet.start();
        }
        this.f42366b.setVisibility(0);
    }

    public final void h0() {
        al.p.v();
        EventBus.d().k(new gh.b(al.p.u()));
        c0(false);
    }

    public void setCallback(h hVar) {
        this.L = hVar;
    }

    public void w(BalanceProfitLossData balanceProfitLossData) {
        if (balanceProfitLossData != null) {
            this.J = balanceProfitLossData;
            if (!i0.d().h()) {
                this.f42366b.getLayoutParams().height = getResources().getDimensionPixelSize(R$dimen.dimen_146);
            } else {
                this.f42366b.getLayoutParams().height = getResources().getDimensionPixelSize(R$dimen.dimen_168);
            }
            b0();
            f0();
            y(balanceProfitLossData);
            z(balanceProfitLossData);
            boolean z11 = true;
            c0(true);
            this.f42389y.setChecked(uh.f.a().b());
            p0.n().C(balanceProfitLossData.getTotalBalance());
            findViewById(R$id.asset_toolbar_switcher_layout).setVisibility(p0.n().p() ? 8 : 0);
            boolean z12 = ti.a.a() || al.a.n();
            if (!ti.a.a() || !al.a.n()) {
                z11 = false;
            }
            this.f42383s.setVisibility(z12 ? 0 : 8);
            this.f42384t.setVisibility(z11 ? 0 : 8);
            this.f42385u.setVisibility(ti.a.a() ? 0 : 8);
            this.f42386v.setVisibility(al.a.n() ? 0 : 8);
            if (H(balanceProfitLossData) || AssetModuleConfig.a().c()) {
                this.f42367c.setVisibility(8);
                this.f42366b.setVisibility(0);
            } else if (this.f42367c.getVisibility() == 0) {
                BaseModuleConfig.a().w("app_assets_overview_digital_now_pop_expose", (HashMap) null);
            }
        }
    }

    public final View x(LinearLayout linearLayout, int i11, vk.c cVar) {
        TextView textView = (TextView) LayoutInflater.from(linearLayout.getContext()).inflate(R$layout.layout_asset_header_action, linearLayout, false);
        if (i11 > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.leftMargin = linearLayout.getResources().getDimensionPixelSize(R$dimen.dimen_8);
            layoutParams.gravity = 16;
        }
        textView.setText(cVar.b());
        if (cVar.c() != null) {
            textView.setOnClickListener(cVar.c());
        }
        return textView;
    }

    public final void y(BalanceProfitLossData balanceProfitLossData) {
        String totalBalance = balanceProfitLossData.getTotalBalance();
        this.F = totalBalance;
        String j11 = al.p.j(totalBalance, "btc");
        this.F = j11;
        this.G = LegalCurrencyConfigUtil.D(j11, "btcusdt", TradeType.PRO);
        uh.a.c(this.f42370f, this.F);
        uh.a.c(this.f42371g, this.G);
        if (this.I == null) {
            this.I = new r7(getContext());
        }
        String a11 = this.I.a(balanceProfitLossData.getProfitAccountBalanceList());
        this.H = a11;
        ViewUtil.m(this.f42372h, !TextUtils.isEmpty(a11));
    }

    public final void z(BalanceProfitLossData balanceProfitLossData) {
        this.D = LegalCurrencyConfigUtil.D(balanceProfitLossData.getTodayProfit(), "btcusdt", TradeType.PRO);
        String todayProfitRate = balanceProfitLossData.getTodayProfitRate();
        if (TextUtils.isEmpty(todayProfitRate)) {
            this.E = "";
        } else {
            this.E = m.Q(todayProfitRate, 2, 1).replace("%", "");
        }
        uh.a.c(this.f42375k, this.D);
        uh.a.c(this.f42376l, this.E);
    }

    public AssetSummaryHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AssetSummaryHeaderView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public AssetSummaryHeaderView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.D = "";
        this.E = "";
        G();
        E();
        B();
    }
}
