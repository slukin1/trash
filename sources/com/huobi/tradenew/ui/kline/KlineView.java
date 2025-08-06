package com.huobi.tradenew.ui.kline;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import be.i;
import be.j;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.view.KlineViewWrapper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import pro.huobi.R;

public class KlineView extends FrameLayout implements View.OnClickListener {
    public TextView A;
    public View B;
    public ImageView C;
    public View D;
    public View E;
    public KlineViewWrapper F;
    public int G = 0;
    public double H = 0.0d;
    public boolean I = false;
    public int J;
    public Period[] K = {Period.timeline, Period.min15, Period.min60, Period.hour4, Period.day, Period.week};
    public Period L;
    public String M;
    public String N;
    public String O = TradeType.PRO.name();
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S = false;
    public int T;
    public int U;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f83438b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f83439c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f83440d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f83441e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f83442f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f83443g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f83444h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f83445i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f83446j;

    /* renamed from: k  reason: collision with root package name */
    public RelativeLayout f83447k;

    /* renamed from: l  reason: collision with root package name */
    public RelativeLayout f83448l;

    /* renamed from: m  reason: collision with root package name */
    public RelativeLayout f83449m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f83450n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f83451o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f83452p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f83453q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f83454r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f83455s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f83456t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f83457u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f83458v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f83459w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f83460x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f83461y;

    /* renamed from: z  reason: collision with root package name */
    public View f83462z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            KlineView.this.Q = false;
        }

        public void onAnimationStart(Animator animator) {
            KlineView.this.Q = true;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f83464b;

        public b(Animator.AnimatorListener animatorListener) {
            this.f83464b = animatorListener;
        }

        public void onAnimationEnd(Animator animator) {
            KlineView klineView = KlineView.this;
            klineView.R = false;
            klineView.Q = false;
            klineView.z();
            KlineView.this.f83462z.setVisibility(8);
            Animator.AnimatorListener animatorListener = this.f83464b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            KlineView.this.Q = true;
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f83466b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f83467c;

        public c(Animator.AnimatorListener animatorListener, View view) {
            this.f83466b = animatorListener;
            this.f83467c = view;
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f83466b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            ViewUtil.m(this.f83467c, true);
            Animator.AnimatorListener animatorListener = this.f83466b;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f83469b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f83470c;

        public d(View view, Animator.AnimatorListener animatorListener) {
            this.f83469b = view;
            this.f83470c = animatorListener;
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            ViewUtil.m(this.f83469b, false);
            Animator.AnimatorListener animatorListener = this.f83470c;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f83470c;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }
    }

    public KlineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j(context);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m(View view) {
        A(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(View view) {
        if (this.P || this.Q) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        A(!this.R);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void A(boolean z11) {
        B(z11, (Animator.AnimatorListener) null);
    }

    public void B(boolean z11, Animator.AnimatorListener animatorListener) {
        if (getContext() != null) {
            if (z11) {
                if (!this.R) {
                    this.R = true;
                    y();
                    f(this.f83462z, this.D, new a());
                }
            } else if (this.R) {
                e(this.f83462z, this.D, new b(animatorListener));
            }
        }
    }

    public void C() {
        setKLineViewVisible(true);
        setKLineDepthViewVisible(false);
    }

    public void d() {
        RelativeLayout relativeLayout = this.f83449m;
        if (relativeLayout != null) {
            relativeLayout.setClickable(true);
        }
        this.f83438b.setClickable(true);
        this.f83440d.setClickable(true);
        RelativeLayout relativeLayout2 = this.f83439c;
        if (relativeLayout2 != null) {
            relativeLayout2.setClickable(true);
        }
        this.f83441e.setClickable(true);
        this.f83442f.setClickable(true);
        this.f83443g.setClickable(true);
        this.f83444h.setClickable(true);
        this.f83445i.setClickable(true);
        this.f83446j.setClickable(true);
        this.f83447k.setClickable(true);
        this.f83448l.setClickable(true);
        View view = this.E;
        if (view != null) {
            view.setOnClickListener(new xt.a(this));
        }
        this.f83449m.setOnClickListener(new xt.b(this));
        this.f83438b.setOnClickListener(this);
        this.f83440d.setOnClickListener(this);
        this.f83439c.setOnClickListener(this);
        this.f83441e.setOnClickListener(this);
        this.f83442f.setOnClickListener(this);
        this.f83443g.setOnClickListener(this);
        this.f83444h.setOnClickListener(this);
        this.f83445i.setOnClickListener(this);
        this.f83446j.setOnClickListener(this);
        this.f83447k.setOnClickListener(this);
        this.f83448l.setOnClickListener(this);
    }

    public void e(View view, View view2, Animator.AnimatorListener animatorListener) {
        if (view != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(240);
            animatorSet.setInterpolator(new FastOutLinearInInterpolator());
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{0.0f, (float) (-view2.getMeasuredHeight())}), ObjectAnimator.ofFloat(this.C, "rotation", new float[]{180.0f, 0.0f})});
            animatorSet.addListener(new d(view, animatorListener));
            animatorSet.start();
        }
    }

    public void f(View view, View view2, Animator.AnimatorListener animatorListener) {
        if (view != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(270);
            animatorSet.setInterpolator(new LinearOutSlowInInterpolator());
            Animator[] animatorArr = new Animator[2];
            Property property = View.TRANSLATION_Y;
            float[] fArr = new float[2];
            fArr[0] = (float) (-(view2.getMeasuredHeight() == 0 ? DimenUtils.a(62.0f) : view2.getMeasuredHeight()));
            fArr[1] = 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(view2, property, fArr);
            animatorArr[1] = ObjectAnimator.ofFloat(this.C, "rotation", new float[]{0.0f, 180.0f});
            animatorSet.playTogether(animatorArr);
            animatorSet.addListener(new c(animatorListener, view));
            animatorSet.start();
        }
    }

    public final void g(View view) {
    }

    public int getNormalColor() {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.kline_three_level_text_color, typedValue, true);
        return typedValue.data;
    }

    public int getSelectedColor() {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.kline_index_setting_text_color, typedValue, true);
        return typedValue.data;
    }

    public final void h() {
        a1 v11 = a1.v();
        String str = this.M;
        TradeType tradeType = TradeType.PRO;
        String str2 = v11.E(str, tradeType) + "usdt";
        if (a1.v().H(tradeType).contains(str2)) {
            this.N = str2;
        }
    }

    public void i(boolean z11, String str, String str2, int i11, int i12) {
        this.O = str;
        this.M = str2;
        this.T = i11;
        this.U = i12;
        this.S = z11;
        h();
    }

    public final void j(Context context) {
        LayoutInflater.from(context).inflate(R.layout.kline_view, this, true);
        this.f83461y = (TextView) findViewById(R.id.text_view_etp_kline_type);
        this.f83450n = (TextView) findViewById(R.id.time_sharing_radio);
        this.f83452p = (TextView) findViewById(R.id.one_min_radio);
        this.f83451o = (TextView) findViewById(R.id.float_time_radio);
        this.f83453q = (TextView) findViewById(R.id.five_min_radio);
        this.f83454r = (TextView) findViewById(R.id.fifteen_min_radio);
        this.f83455s = (TextView) findViewById(R.id.thirty_min_radio);
        this.f83456t = (TextView) findViewById(R.id.sixty_min_radio);
        this.f83457u = (TextView) findViewById(R.id.four_hour_radio);
        this.f83458v = (TextView) findViewById(R.id.one_day_radio);
        this.f83459w = (TextView) findViewById(R.id.one_week_radio);
        this.f83460x = (TextView) findViewById(R.id.one_month_radio);
        this.f83438b = (RelativeLayout) findViewById(R.id.time_sharing_radio_layout);
        this.f83440d = (RelativeLayout) findViewById(R.id.one_min_radio_layout);
        this.f83439c = (RelativeLayout) findViewById(R.id.float_time_radio_layout);
        this.f83441e = (RelativeLayout) findViewById(R.id.five_min_radio_layout);
        this.f83442f = (RelativeLayout) findViewById(R.id.fifteen_min_radio_layout);
        this.f83443g = (RelativeLayout) findViewById(R.id.thirty_min_radio_layout);
        this.f83444h = (RelativeLayout) findViewById(R.id.sixty_min_radio_layout);
        this.f83445i = (RelativeLayout) findViewById(R.id.four_hour_radio_layout);
        this.f83446j = (RelativeLayout) findViewById(R.id.one_day_radio_layout);
        this.f83447k = (RelativeLayout) findViewById(R.id.one_week_radio_layout);
        this.f83448l = (RelativeLayout) findViewById(R.id.one_month_radio_layout);
        this.f83449m = (RelativeLayout) findViewById(R.id.market_info_more_layout);
        this.A = (TextView) findViewById(R.id.market_info_more);
        this.B = findViewById(R.id.ll_market_info_more);
        this.C = (ImageView) findViewById(R.id.market_info_more_indicator_top);
        this.f83462z = findViewById(R.id.market_info_more_detail_layout);
        this.D = findViewById(R.id.id_kline_period_more_view);
        View findViewById = findViewById(R.id.id_kline_period_more_bg_view);
        this.E = findViewById;
        findViewById.setBackgroundResource(R.color.transparent);
        this.F = (KlineViewWrapper) findViewById(R.id.klineViewWrapper);
        d();
    }

    public boolean k() {
        return a1.v().p0(this.M);
    }

    public boolean l() {
        return false;
    }

    public final void o() {
        int g11 = ConfigPreferences.g("user_config", "config_target_top_20221026", 1);
        this.J = g11;
        this.F.setMasterIndex(g11);
        w();
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.market_info_more_layout || id2 == R.id.time_sharing_radio_layout || id2 == R.id.one_min_radio_layout || id2 == R.id.one_min_radio_layout_etp || id2 == R.id.float_time_radio_layout || id2 == R.id.float_time_radio_layout_etp || id2 == R.id.five_min_radio_layout || id2 == R.id.five_min_radio_layout_etp || id2 == R.id.fifteen_min_radio_layout || id2 == R.id.thirty_min_radio_layout || id2 == R.id.thirty_min_radio_layout_etp || id2 == R.id.sixty_min_radio_layout || id2 == R.id.four_hour_radio_layout || id2 == R.id.one_day_radio_layout || id2 == R.id.one_week_radio_layout || id2 == R.id.one_week_radio_layout_etp || id2 == R.id.one_month_radio_layout || id2 == R.id.one_month_radio_layout_etp) {
            x(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void p() {
        RelativeLayout relativeLayout;
        Period period = Period.min15;
        Period parsePeriod = Period.parsePeriod(ConfigPreferences.e("user_config", "config_period", period.value));
        if (!l() || parsePeriod != this.L) {
            if (parsePeriod == Period.timeline) {
                if (TradeType.isLinearSwapIndex(this.O) || TradeType.isContractIndex(this.O) || TradeType.isIndex(this.O)) {
                    relativeLayout = (RelativeLayout) findViewById(R.id.time_sharing_radio_layout);
                } else {
                    this.A.setTextColor(getSelectedColor());
                    this.A.setText(R.string.n_kline_timeline);
                    if (k()) {
                        relativeLayout = (RelativeLayout) findViewById(R.id.float_time_radio_layout_etp);
                    } else {
                        relativeLayout = (RelativeLayout) findViewById(R.id.float_time_radio_layout);
                    }
                }
            } else if (parsePeriod == Period.min1) {
                if (!k() || this.S) {
                    relativeLayout = (RelativeLayout) findViewById(R.id.one_min_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) findViewById(R.id.one_min_radio_layout_etp);
                }
            } else if (parsePeriod == Period.min5) {
                if (!k() || this.S) {
                    relativeLayout = (RelativeLayout) findViewById(R.id.five_min_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) findViewById(R.id.five_min_radio_layout_etp);
                }
            } else if (parsePeriod == period) {
                relativeLayout = (RelativeLayout) findViewById(R.id.fifteen_min_radio_layout);
            } else if (parsePeriod == Period.min30) {
                if (!k() || this.S) {
                    relativeLayout = (RelativeLayout) findViewById(R.id.thirty_min_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) findViewById(R.id.thirty_min_radio_layout_etp);
                }
            } else if (parsePeriod == Period.min60) {
                relativeLayout = (RelativeLayout) findViewById(R.id.sixty_min_radio_layout);
            } else if (parsePeriod == Period.hour4) {
                relativeLayout = (RelativeLayout) findViewById(R.id.four_hour_radio_layout);
            } else if (parsePeriod == Period.day) {
                relativeLayout = (RelativeLayout) findViewById(R.id.one_day_radio_layout);
            } else if (parsePeriod == Period.week) {
                if (!k() || this.S) {
                    relativeLayout = (RelativeLayout) findViewById(R.id.one_week_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) findViewById(R.id.one_week_radio_layout_etp);
                }
            } else if (parsePeriod != Period.month) {
                relativeLayout = (RelativeLayout) findViewById(R.id.fifteen_min_radio_layout);
            } else if (!k() || this.S) {
                relativeLayout = (RelativeLayout) findViewById(R.id.one_month_radio_layout);
            } else {
                relativeLayout = (RelativeLayout) findViewById(R.id.one_month_radio_layout_etp);
            }
            relativeLayout.setClickable(true);
            relativeLayout.performClick();
        }
    }

    public void q() {
        this.F.C();
        this.I = false;
    }

    public void r() {
        this.I = true;
        this.F.setTradeType(this.O);
        this.F.setSymbolId(this.M);
        this.F.setPricePrecision(this.T);
        this.F.setVolPrecision(this.U);
        s();
        this.G = -1;
        p();
        o();
        this.F.D();
    }

    public final void s() {
        List<i> a11 = j.c().a();
        if (!UtilCollections.f(a11)) {
            int a12 = a11.get(0).a();
            int a13 = a11.get(1).a();
            int a14 = a11.get(2).a();
            int a15 = a11.get(3).a();
            int a16 = a11.get(4).a();
            int a17 = a11.get(5).a();
            int c11 = a11.get(6).c();
            int c12 = a11.get(7).c();
            int c13 = a11.get(8).c();
            int c14 = a11.get(9).c();
            int c15 = a11.get(10).c();
            int c16 = a11.get(11).c();
            int c17 = a11.get(12).c();
            int c18 = a11.get(13).c();
            int a18 = a11.get(14).a();
            int a19 = a11.get(15).a();
            int a21 = a11.get(16).a();
            int a22 = a11.get(17).a();
            int a23 = a11.get(18).a();
            int a24 = a11.get(19).a();
            int a25 = a11.get(20).a();
            int a26 = a11.get(21).a();
            this.F.H(a11.get(22).a(), a11.get(23).a(), a11.get(24).a(), a11.get(25).a(), a11.get(26).a(), a11.get(27).a(), a11.get(28).a(), a11.get(29).a());
            this.F.J(a12, a13, a14, a15, a16, a17, a25, a26, c11, c12, c13, c14, c15, c16, c17, c18, a18, a19, a21, a22, a23, a24);
        }
    }

    public void setIsCoin(boolean z11) {
        this.F.setIsCoin(z11);
        this.F.G();
    }

    public void setKLineDepthViewVisible(boolean z11) {
        if (z11 && k()) {
            this.f83461y.setTextColor(getNormalColor());
        }
    }

    public void setKLineViewVisible(boolean z11) {
        ViewUtil.m(this.F, z11);
    }

    public void setUpPeriodView(int i11) {
        if (this.G != i11 && i11 >= 0) {
            this.G = i11;
            if (i11 == R.id.time_sharing_radio_layout) {
                Period period = Period.timeline;
                ConfigPreferences.m("user_config", "config_period", period.key);
                this.L = period;
            } else if (i11 == R.id.float_time_radio_layout || i11 == R.id.float_time_radio_layout_etp) {
                Period period2 = Period.timeline;
                ConfigPreferences.m("user_config", "config_period", period2.key);
                this.L = period2;
            } else if (i11 == R.id.one_min_radio_layout || i11 == R.id.one_min_radio_layout_etp) {
                Period period3 = Period.min1;
                ConfigPreferences.m("user_config", "config_period", period3.key);
                this.L = period3;
            } else if (i11 == R.id.five_min_radio_layout || i11 == R.id.five_min_radio_layout_etp) {
                Period period4 = Period.min5;
                ConfigPreferences.m("user_config", "config_period", period4.key);
                this.L = period4;
            } else if (i11 == R.id.fifteen_min_radio_layout) {
                Period period5 = Period.min15;
                ConfigPreferences.m("user_config", "config_period", period5.key);
                this.L = period5;
            } else if (i11 == R.id.thirty_min_radio_layout || i11 == R.id.thirty_min_radio_layout_etp) {
                Period period6 = Period.min30;
                ConfigPreferences.m("user_config", "config_period", period6.key);
                this.L = period6;
            } else if (i11 == R.id.sixty_min_radio_layout) {
                Period period7 = Period.min60;
                ConfigPreferences.m("user_config", "config_period", period7.key);
                this.L = period7;
            } else if (i11 == R.id.four_hour_radio_layout) {
                Period period8 = Period.hour4;
                ConfigPreferences.m("user_config", "config_period", period8.key);
                this.L = period8;
            } else if (i11 == R.id.one_day_radio_layout) {
                Period period9 = Period.day;
                ConfigPreferences.m("user_config", "config_period", period9.key);
                this.L = period9;
            } else if (i11 == R.id.one_week_radio_layout || i11 == R.id.one_week_radio_layout_etp) {
                Period period10 = Period.week;
                ConfigPreferences.m("user_config", "config_period", period10.key);
                this.L = period10;
            } else if (i11 == R.id.one_month_radio_layout || i11 == R.id.one_month_radio_layout_etp) {
                Period period11 = Period.month;
                ConfigPreferences.m("user_config", "config_period", period11.key);
                this.L = period11;
            }
            this.F.K(this.L, false);
            if (i11 == R.id.market_info_more_layout) {
                BaseModuleConfig.a().w("App_markets_kline_timescm_click", (HashMap) null);
            } else {
                BaseModuleConfig.a().w("App_markets_kline_timesc_click", (HashMap) null);
            }
            if (!this.S) {
                boolean z11 = false;
                for (Period period12 : this.K) {
                    if (period12 == this.L) {
                        z11 = true;
                    }
                    if (i11 == R.id.float_time_radio_layout || i11 == R.id.float_time_radio_layout_etp) {
                        z11 = false;
                    }
                    if (z11) {
                        break;
                    }
                }
                if (z11) {
                    this.A.setTextColor(getNormalColor());
                    this.A.setText(R.string.n_kline_more);
                    BaseModuleConfig.a().w("App_markets_kline_depthmap_click", (HashMap) null);
                    return;
                }
                this.A.setTextColor(getSelectedColor());
                Period period13 = this.L;
                if (period13 == Period.timeline) {
                    this.A.setText(R.string.n_kline_timeline);
                } else if (period13 == Period.min1) {
                    this.A.setText(R.string.n_kline_1min);
                } else if (period13 == Period.min5) {
                    this.A.setText(R.string.n_kline_5min);
                } else if (period13 == Period.min30) {
                    this.A.setText(R.string.n_kline_30min);
                } else if (period13 == Period.week) {
                    this.A.setText(R.string.n_kline_1week);
                } else if (period13 == Period.month) {
                    this.A.setText(R.string.n_kline_1month);
                } else {
                    this.A.setText(R.string.n_kline_more);
                }
            }
        }
    }

    public void setVolPrecision(int i11) {
        this.U = i11;
        this.F.setVolPrecision(i11);
    }

    public void t(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void u(TextView textView, boolean z11, int i11, int i12) {
        if (textView == null) {
            return;
        }
        if (z11) {
            textView.setTextColor(i11);
        } else {
            textView.setTextColor(i12);
        }
    }

    public final void v(View view, boolean z11) {
        if (view != null) {
            view.setSelected(z11);
        }
    }

    public void w() {
        String str = "VOL";
        if (k()) {
            KlineViewWrapper klineViewWrapper = this.F;
            if (!KLineHelper.d(this.M, true)) {
                str = "";
            }
            klineViewWrapper.setSlaveIndex1(str);
        } else {
            KlineViewWrapper klineViewWrapper2 = this.F;
            if (TradeType.isIndex(this.O) || TradeType.isContractIndex(this.O) || TradeType.isLinearSwapIndex(this.O)) {
                str = "";
            }
            klineViewWrapper2.setSlaveIndex1(str);
        }
        this.F.setSlaveIndex2((LinkedHashSet<String>) null);
    }

    public void x(View view) {
        this.f83450n.setTextColor(getNormalColor());
        this.f83452p.setTextColor(getNormalColor());
        this.f83453q.setTextColor(getNormalColor());
        this.f83454r.setTextColor(getNormalColor());
        this.f83455s.setTextColor(getNormalColor());
        this.f83456t.setTextColor(getNormalColor());
        this.f83457u.setTextColor(getNormalColor());
        this.f83458v.setTextColor(getNormalColor());
        this.f83459w.setTextColor(getNormalColor());
        this.f83460x.setTextColor(getNormalColor());
        this.f83439c.setSelected(false);
        this.f83440d.setSelected(false);
        this.f83441e.setSelected(false);
        this.f83442f.setSelected(false);
        this.f83443g.setSelected(false);
        this.f83444h.setSelected(false);
        this.f83445i.setSelected(false);
        this.f83446j.setSelected(false);
        this.f83447k.setSelected(false);
        this.f83448l.setSelected(false);
        view.setSelected(true);
        setKLineViewVisible(true);
        setKLineDepthViewVisible(false);
        if (TradeType.isIndex(this.O)) {
            ViewUtil.m(this.f83438b, true);
            ViewUtil.m(this.f83439c, false);
        } else if (TradeType.isContractIndex(this.O) || TradeType.isLinearSwapIndex(this.O)) {
            ViewUtil.m(this.f83438b, true);
            ViewUtil.m(this.f83439c, false);
        } else {
            if (this.S) {
                ViewUtil.m(this.f83438b, true);
            } else {
                ViewUtil.m(this.f83438b, false);
            }
            ViewUtil.m(this.f83439c, true);
        }
        int id2 = view.getId();
        if (id2 == R.id.time_sharing_radio_layout) {
            this.f83450n.setTextColor(getSelectedColor());
            A(false);
            if (this.S || TradeType.isIndex(this.O) || TradeType.isContractIndex(this.O) || TradeType.isLinearSwapIndex(this.O)) {
                g(this.f83450n);
            } else {
                g(this.B);
            }
        } else if (id2 == R.id.one_min_radio_layout || id2 == R.id.one_min_radio_layout_etp) {
            if (this.S) {
                this.f83452p.setTextColor(getSelectedColor());
                g(this.f83452p);
            } else {
                t(this.A, getResources().getString(R.string.n_kline_1min));
                A(false);
                g(this.B);
            }
        } else if (id2 == R.id.float_time_radio_layout || id2 == R.id.float_time_radio_layout_etp) {
            if (this.S) {
                this.f83451o.setTextColor(getSelectedColor());
                g(this.f83451o);
            } else {
                t(this.A, getResources().getString(R.string.n_kline_timeline));
                A(false);
                g(this.B);
            }
        } else if (id2 == R.id.five_min_radio_layout || id2 == R.id.five_min_radio_layout_etp) {
            if (this.S) {
                this.f83453q.setTextColor(getSelectedColor());
                g(this.f83453q);
            } else {
                t(this.A, getResources().getString(R.string.n_kline_5min));
                A(false);
                g(this.B);
            }
        } else if (id2 == R.id.fifteen_min_radio_layout) {
            this.f83454r.setTextColor(getSelectedColor());
            A(false);
            g(this.f83454r);
        } else if (id2 == R.id.thirty_min_radio_layout || id2 == R.id.thirty_min_radio_layout_etp) {
            if (this.S) {
                this.f83455s.setTextColor(getSelectedColor());
                g(this.f83455s);
            } else {
                t(this.A, getResources().getString(R.string.n_kline_30min));
                A(false);
                g(this.B);
            }
        } else if (id2 == R.id.sixty_min_radio_layout) {
            this.f83456t.setTextColor(getSelectedColor());
            A(false);
            g(this.f83456t);
        } else if (id2 == R.id.four_hour_radio_layout) {
            this.f83457u.setTextColor(getSelectedColor());
            A(false);
            g(this.f83457u);
        } else if (id2 == R.id.one_day_radio_layout) {
            this.f83458v.setTextColor(getSelectedColor());
            A(false);
            g(this.f83458v);
        } else if (id2 == R.id.one_week_radio_layout || id2 == R.id.one_week_radio_layout_etp) {
            this.f83459w.setTextColor(getSelectedColor());
            A(false);
            if (this.S || !k()) {
                g(this.f83459w);
            } else {
                g(this.B);
            }
        } else if (id2 == R.id.one_month_radio_layout || id2 == R.id.one_month_radio_layout_etp) {
            if (this.S) {
                this.f83460x.setTextColor(getSelectedColor());
                A(false);
                g(this.f83460x);
            } else {
                t(this.A, getResources().getString(R.string.n_kline_1month));
                A(false);
                g(this.B);
            }
        }
        if (view.getId() != R.id.market_info_more_layout && view.getId() != R.id.target_checkbox_layout) {
            setUpPeriodView(view.getId());
            y();
            BaseModuleConfig.a().w("App_markets_kline_indexset_click", (HashMap) null);
        }
    }

    public final void y() {
        int c11 = KLineHelper.c(getContext(), R.attr.kline_index_setting_text_color);
        int c12 = KLineHelper.c(getContext(), R.attr.kline_three_level_text_color);
        boolean z11 = true;
        v(this.f83439c, !l() && this.L == Period.timeline);
        u(this.f83451o, !l() && this.L == Period.timeline, c11, c12);
        v(this.f83440d, !l() && this.L == Period.min1);
        u(this.f83452p, !l() && this.L == Period.min1, c11, c12);
        v(this.f83441e, !l() && this.L == Period.min5);
        u(this.f83453q, !l() && this.L == Period.min5, c11, c12);
        v(this.f83443g, !l() && this.L == Period.min30);
        u(this.f83455s, !l() && this.L == Period.min30, c11, c12);
        v(this.f83448l, !l() && this.L == Period.month);
        TextView textView = this.f83460x;
        if (l() || this.L != Period.month) {
            z11 = false;
        }
        u(textView, z11, c11, c12);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        if (r4.L == com.hbg.lib.network.pro.core.util.Period.week) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z() {
        /*
            r4 = this;
            com.hbg.lib.network.pro.core.util.Period r0 = r4.L
            com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.min1
            r2 = 1
            if (r0 == r1) goto L_0x0016
            com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.min5
            if (r0 == r1) goto L_0x0016
            com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.min30
            if (r0 == r1) goto L_0x0016
            com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.month
            if (r0 != r1) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r0 = 0
            goto L_0x0017
        L_0x0016:
            r0 = r2
        L_0x0017:
            if (r0 != 0) goto L_0x0037
            android.widget.RelativeLayout r1 = r4.f83438b
            if (r1 == 0) goto L_0x0037
            int r1 = r1.getVisibility()
            if (r1 == 0) goto L_0x0037
            com.hbg.lib.network.pro.core.util.Period r1 = r4.L
            com.hbg.lib.network.pro.core.util.Period r3 = com.hbg.lib.network.pro.core.util.Period.timeline
            if (r1 != r3) goto L_0x002a
            r0 = r2
        L_0x002a:
            boolean r1 = r4.k()
            if (r1 == 0) goto L_0x0037
            com.hbg.lib.network.pro.core.util.Period r1 = r4.L
            com.hbg.lib.network.pro.core.util.Period r3 = com.hbg.lib.network.pro.core.util.Period.week
            if (r1 != r3) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r2 = r0
        L_0x0038:
            if (r2 == 0) goto L_0x004a
            boolean r0 = r4.l()
            if (r0 != 0) goto L_0x004a
            android.widget.TextView r0 = r4.A
            int r1 = r4.getSelectedColor()
            r0.setTextColor(r1)
            goto L_0x0053
        L_0x004a:
            android.widget.TextView r0 = r4.A
            int r1 = r4.getNormalColor()
            r0.setTextColor(r1)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.tradenew.ui.kline.KlineView.z():void");
    }

    public KlineView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        j(context);
    }
}
