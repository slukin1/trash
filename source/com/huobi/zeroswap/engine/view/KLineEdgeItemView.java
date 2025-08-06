package com.huobi.zeroswap.engine.view;

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

public class KLineEdgeItemView extends FrameLayout implements View.OnClickListener {
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
    public RelativeLayout f21179b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f21180c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f21181d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f21182e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f21183f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f21184g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f21185h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f21186i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f21187j;

    /* renamed from: k  reason: collision with root package name */
    public RelativeLayout f21188k;

    /* renamed from: l  reason: collision with root package name */
    public RelativeLayout f21189l;

    /* renamed from: m  reason: collision with root package name */
    public RelativeLayout f21190m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f21191n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f21192o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f21193p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f21194q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f21195r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f21196s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f21197t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f21198u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f21199v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f21200w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f21201x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f21202y;

    /* renamed from: z  reason: collision with root package name */
    public View f21203z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            KLineEdgeItemView.this.Q = false;
        }

        public void onAnimationStart(Animator animator) {
            KLineEdgeItemView.this.Q = true;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f21205b;

        public b(Animator.AnimatorListener animatorListener) {
            this.f21205b = animatorListener;
        }

        public void onAnimationEnd(Animator animator) {
            KLineEdgeItemView kLineEdgeItemView = KLineEdgeItemView.this;
            kLineEdgeItemView.R = false;
            kLineEdgeItemView.Q = false;
            kLineEdgeItemView.A();
            KLineEdgeItemView.this.f21203z.setVisibility(8);
            Animator.AnimatorListener animatorListener = this.f21205b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            KLineEdgeItemView.this.Q = true;
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f21207b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f21208c;

        public c(Animator.AnimatorListener animatorListener, View view) {
            this.f21207b = animatorListener;
            this.f21208c = view;
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f21207b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            ViewUtil.m(this.f21208c, true);
            Animator.AnimatorListener animatorListener = this.f21207b;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f21210b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f21211c;

        public d(View view, Animator.AnimatorListener animatorListener) {
            this.f21210b = view;
            this.f21211c = animatorListener;
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            ViewUtil.m(this.f21210b, false);
            Animator.AnimatorListener animatorListener = this.f21211c;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f21211c;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }
    }

    public KLineEdgeItemView(Context context) {
        super(context);
        j(context);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(View view) {
        B(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o(View view) {
        if (this.P || this.Q) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        B(!this.R);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        if (r4.L == com.hbg.lib.network.pro.core.util.Period.week) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A() {
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
            android.widget.RelativeLayout r1 = r4.f21179b
            if (r1 == 0) goto L_0x0037
            int r1 = r1.getVisibility()
            if (r1 == 0) goto L_0x0037
            com.hbg.lib.network.pro.core.util.Period r1 = r4.L
            com.hbg.lib.network.pro.core.util.Period r3 = com.hbg.lib.network.pro.core.util.Period.timeline
            if (r1 != r3) goto L_0x002a
            r0 = r2
        L_0x002a:
            boolean r1 = r4.l()
            if (r1 == 0) goto L_0x0037
            com.hbg.lib.network.pro.core.util.Period r1 = r4.L
            com.hbg.lib.network.pro.core.util.Period r3 = com.hbg.lib.network.pro.core.util.Period.week
            if (r1 != r3) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r2 = r0
        L_0x0038:
            if (r2 == 0) goto L_0x004a
            boolean r0 = r4.m()
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
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.zeroswap.engine.view.KLineEdgeItemView.A():void");
    }

    public void B(boolean z11) {
        C(z11, (Animator.AnimatorListener) null);
    }

    public void C(boolean z11, Animator.AnimatorListener animatorListener) {
        if (getContext() != null) {
            if (z11) {
                if (!this.R) {
                    this.R = true;
                    z();
                    f(this.f21203z, this.D, new a());
                }
            } else if (this.R) {
                e(this.f21203z, this.D, new b(animatorListener));
            }
        }
    }

    public void d() {
        RelativeLayout relativeLayout = this.f21190m;
        if (relativeLayout != null) {
            relativeLayout.setClickable(true);
        }
        this.f21179b.setClickable(true);
        this.f21181d.setClickable(true);
        RelativeLayout relativeLayout2 = this.f21180c;
        if (relativeLayout2 != null) {
            relativeLayout2.setClickable(true);
        }
        this.f21182e.setClickable(true);
        this.f21183f.setClickable(true);
        this.f21184g.setClickable(true);
        this.f21185h.setClickable(true);
        this.f21186i.setClickable(true);
        this.f21187j.setClickable(true);
        this.f21188k.setClickable(true);
        this.f21189l.setClickable(true);
        View view = this.E;
        if (view != null) {
            view.setOnClickListener(new nv.a(this));
        }
        this.f21190m.setOnClickListener(new nv.b(this));
        this.f21179b.setOnClickListener(this);
        this.f21181d.setOnClickListener(this);
        this.f21180c.setOnClickListener(this);
        this.f21182e.setOnClickListener(this);
        this.f21183f.setOnClickListener(this);
        this.f21184g.setOnClickListener(this);
        this.f21185h.setOnClickListener(this);
        this.f21186i.setOnClickListener(this);
        this.f21187j.setOnClickListener(this);
        this.f21188k.setOnClickListener(this);
        this.f21189l.setOnClickListener(this);
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
        LayoutInflater.from(context).inflate(R.layout.kline_edge_item_view, this, true);
        this.f21202y = (TextView) findViewById(R.id.text_view_etp_kline_type);
        this.f21191n = (TextView) findViewById(R.id.time_sharing_radio);
        this.f21193p = (TextView) findViewById(R.id.one_min_radio);
        this.f21192o = (TextView) findViewById(R.id.float_time_radio);
        this.f21194q = (TextView) findViewById(R.id.five_min_radio);
        this.f21195r = (TextView) findViewById(R.id.fifteen_min_radio);
        this.f21196s = (TextView) findViewById(R.id.thirty_min_radio);
        this.f21197t = (TextView) findViewById(R.id.sixty_min_radio);
        this.f21198u = (TextView) findViewById(R.id.four_hour_radio);
        this.f21199v = (TextView) findViewById(R.id.one_day_radio);
        this.f21200w = (TextView) findViewById(R.id.one_week_radio);
        this.f21201x = (TextView) findViewById(R.id.one_month_radio);
        this.f21179b = (RelativeLayout) findViewById(R.id.time_sharing_radio_layout);
        this.f21181d = (RelativeLayout) findViewById(R.id.one_min_radio_layout);
        this.f21180c = (RelativeLayout) findViewById(R.id.float_time_radio_layout);
        this.f21182e = (RelativeLayout) findViewById(R.id.five_min_radio_layout);
        this.f21183f = (RelativeLayout) findViewById(R.id.fifteen_min_radio_layout);
        this.f21184g = (RelativeLayout) findViewById(R.id.thirty_min_radio_layout);
        this.f21185h = (RelativeLayout) findViewById(R.id.sixty_min_radio_layout);
        this.f21186i = (RelativeLayout) findViewById(R.id.four_hour_radio_layout);
        this.f21187j = (RelativeLayout) findViewById(R.id.one_day_radio_layout);
        this.f21188k = (RelativeLayout) findViewById(R.id.one_week_radio_layout);
        this.f21189l = (RelativeLayout) findViewById(R.id.one_month_radio_layout);
        this.f21190m = (RelativeLayout) findViewById(R.id.market_info_more_layout);
        this.A = (TextView) findViewById(R.id.market_info_more);
        this.B = findViewById(R.id.ll_market_info_more);
        this.C = (ImageView) findViewById(R.id.market_info_more_indicator_top);
        this.f21203z = findViewById(R.id.market_info_more_detail_layout);
        this.D = findViewById(R.id.id_kline_period_more_view);
        View findViewById = findViewById(R.id.id_kline_period_more_bg_view);
        this.E = findViewById;
        findViewById.setBackgroundResource(R.color.transparent);
        this.F = (KlineViewWrapper) findViewById(R.id.klineViewWrapper);
        d();
    }

    public boolean k() {
        return this.I;
    }

    public boolean l() {
        return a1.v().p0(this.M);
    }

    public boolean m() {
        return false;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.market_info_more_layout || id2 == R.id.time_sharing_radio_layout || id2 == R.id.one_min_radio_layout || id2 == R.id.one_min_radio_layout_etp || id2 == R.id.float_time_radio_layout || id2 == R.id.float_time_radio_layout_etp || id2 == R.id.five_min_radio_layout || id2 == R.id.five_min_radio_layout_etp || id2 == R.id.fifteen_min_radio_layout || id2 == R.id.thirty_min_radio_layout || id2 == R.id.thirty_min_radio_layout_etp || id2 == R.id.sixty_min_radio_layout || id2 == R.id.four_hour_radio_layout || id2 == R.id.one_day_radio_layout || id2 == R.id.one_week_radio_layout || id2 == R.id.one_week_radio_layout_etp || id2 == R.id.one_month_radio_layout || id2 == R.id.one_month_radio_layout_etp) {
            y(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void p() {
        int g11 = ConfigPreferences.g("user_config", "config_target_top_20221026", 1);
        this.J = g11;
        this.F.setMasterIndex(g11);
        x();
    }

    public final void q() {
        RelativeLayout relativeLayout;
        Period period = Period.min15;
        Period parsePeriod = Period.parsePeriod(ConfigPreferences.e("user_config", "config_period", period.value));
        if (!m() || parsePeriod != this.L) {
            if (parsePeriod == Period.timeline) {
                if (TradeType.isLinearSwapIndex(this.O) || TradeType.isContractIndex(this.O) || TradeType.isIndex(this.O)) {
                    relativeLayout = (RelativeLayout) findViewById(R.id.time_sharing_radio_layout);
                } else {
                    this.A.setTextColor(getSelectedColor());
                    this.A.setText(R.string.n_kline_timeline);
                    if (l()) {
                        relativeLayout = (RelativeLayout) findViewById(R.id.float_time_radio_layout_etp);
                    } else {
                        relativeLayout = (RelativeLayout) findViewById(R.id.float_time_radio_layout);
                    }
                }
            } else if (parsePeriod == Period.min1) {
                if (!l() || this.S) {
                    relativeLayout = (RelativeLayout) findViewById(R.id.one_min_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) findViewById(R.id.one_min_radio_layout_etp);
                }
            } else if (parsePeriod == Period.min5) {
                if (!l() || this.S) {
                    relativeLayout = (RelativeLayout) findViewById(R.id.five_min_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) findViewById(R.id.five_min_radio_layout_etp);
                }
            } else if (parsePeriod == period) {
                relativeLayout = (RelativeLayout) findViewById(R.id.fifteen_min_radio_layout);
            } else if (parsePeriod == Period.min30) {
                if (!l() || this.S) {
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
                if (!l() || this.S) {
                    relativeLayout = (RelativeLayout) findViewById(R.id.one_week_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) findViewById(R.id.one_week_radio_layout_etp);
                }
            } else if (parsePeriod != Period.month) {
                relativeLayout = (RelativeLayout) findViewById(R.id.fifteen_min_radio_layout);
            } else if (!l() || this.S) {
                relativeLayout = (RelativeLayout) findViewById(R.id.one_month_radio_layout);
            } else {
                relativeLayout = (RelativeLayout) findViewById(R.id.one_month_radio_layout_etp);
            }
            relativeLayout.setClickable(true);
            relativeLayout.performClick();
        }
    }

    public void r() {
        this.F.C();
        this.I = false;
    }

    public void s() {
        this.I = true;
        this.F.setTradeType(this.O);
        this.F.setSymbolId(this.M);
        this.F.setPricePrecision(this.T);
        this.F.setVolPrecision(this.U);
        t();
        this.G = -1;
        q();
        p();
        this.F.D();
    }

    public void setIsCoin(boolean z11) {
        this.F.setIsCoin(z11);
        this.F.G();
    }

    public void setKLineDepthViewVisible(boolean z11) {
        if (z11 && l()) {
            this.f21202y.setTextColor(getNormalColor());
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

    public final void t() {
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

    public void u(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void v(TextView textView, boolean z11, int i11, int i12) {
        if (textView == null) {
            return;
        }
        if (z11) {
            textView.setTextColor(i11);
        } else {
            textView.setTextColor(i12);
        }
    }

    public final void w(View view, boolean z11) {
        if (view != null) {
            view.setSelected(z11);
        }
    }

    public void x() {
        this.F.setSlaveIndex1("");
        this.F.setSlaveIndex2((LinkedHashSet<String>) null);
    }

    public void y(View view) {
        this.f21191n.setTextColor(getNormalColor());
        this.f21193p.setTextColor(getNormalColor());
        this.f21194q.setTextColor(getNormalColor());
        this.f21195r.setTextColor(getNormalColor());
        this.f21196s.setTextColor(getNormalColor());
        this.f21197t.setTextColor(getNormalColor());
        this.f21198u.setTextColor(getNormalColor());
        this.f21199v.setTextColor(getNormalColor());
        this.f21200w.setTextColor(getNormalColor());
        this.f21201x.setTextColor(getNormalColor());
        this.f21180c.setSelected(false);
        this.f21181d.setSelected(false);
        this.f21182e.setSelected(false);
        this.f21183f.setSelected(false);
        this.f21184g.setSelected(false);
        this.f21185h.setSelected(false);
        this.f21186i.setSelected(false);
        this.f21187j.setSelected(false);
        this.f21188k.setSelected(false);
        this.f21189l.setSelected(false);
        view.setSelected(true);
        setKLineViewVisible(true);
        setKLineDepthViewVisible(false);
        if (TradeType.isIndex(this.O)) {
            ViewUtil.m(this.f21179b, true);
            ViewUtil.m(this.f21180c, false);
        } else if (TradeType.isContractIndex(this.O) || TradeType.isLinearSwapIndex(this.O)) {
            ViewUtil.m(this.f21179b, true);
            ViewUtil.m(this.f21180c, false);
        } else {
            if (this.S) {
                ViewUtil.m(this.f21179b, true);
            } else {
                ViewUtil.m(this.f21179b, false);
            }
            ViewUtil.m(this.f21180c, true);
        }
        int id2 = view.getId();
        if (id2 == R.id.time_sharing_radio_layout) {
            this.f21191n.setTextColor(getSelectedColor());
            B(false);
            if (this.S || TradeType.isIndex(this.O) || TradeType.isContractIndex(this.O) || TradeType.isLinearSwapIndex(this.O)) {
                g(this.f21191n);
            } else {
                g(this.B);
            }
        } else if (id2 == R.id.one_min_radio_layout || id2 == R.id.one_min_radio_layout_etp) {
            if (this.S) {
                this.f21193p.setTextColor(getSelectedColor());
                g(this.f21193p);
            } else {
                u(this.A, getResources().getString(R.string.n_kline_1min));
                B(false);
                g(this.B);
            }
        } else if (id2 == R.id.float_time_radio_layout || id2 == R.id.float_time_radio_layout_etp) {
            if (this.S) {
                this.f21192o.setTextColor(getSelectedColor());
                g(this.f21192o);
            } else {
                u(this.A, getResources().getString(R.string.n_kline_timeline));
                B(false);
                g(this.B);
            }
        } else if (id2 == R.id.five_min_radio_layout || id2 == R.id.five_min_radio_layout_etp) {
            if (this.S) {
                this.f21194q.setTextColor(getSelectedColor());
                g(this.f21194q);
            } else {
                u(this.A, getResources().getString(R.string.n_kline_5min));
                B(false);
                g(this.B);
            }
        } else if (id2 == R.id.fifteen_min_radio_layout) {
            this.f21195r.setTextColor(getSelectedColor());
            B(false);
            g(this.f21195r);
        } else if (id2 == R.id.thirty_min_radio_layout || id2 == R.id.thirty_min_radio_layout_etp) {
            if (this.S) {
                this.f21196s.setTextColor(getSelectedColor());
                g(this.f21196s);
            } else {
                u(this.A, getResources().getString(R.string.n_kline_30min));
                B(false);
                g(this.B);
            }
        } else if (id2 == R.id.sixty_min_radio_layout) {
            this.f21197t.setTextColor(getSelectedColor());
            B(false);
            g(this.f21197t);
        } else if (id2 == R.id.four_hour_radio_layout) {
            this.f21198u.setTextColor(getSelectedColor());
            B(false);
            g(this.f21198u);
        } else if (id2 == R.id.one_day_radio_layout) {
            this.f21199v.setTextColor(getSelectedColor());
            B(false);
            g(this.f21199v);
        } else if (id2 == R.id.one_week_radio_layout || id2 == R.id.one_week_radio_layout_etp) {
            this.f21200w.setTextColor(getSelectedColor());
            B(false);
            if (this.S || !l()) {
                g(this.f21200w);
            } else {
                g(this.B);
            }
        } else if (id2 == R.id.one_month_radio_layout || id2 == R.id.one_month_radio_layout_etp) {
            if (this.S) {
                this.f21201x.setTextColor(getSelectedColor());
                B(false);
                g(this.f21201x);
            } else {
                u(this.A, getResources().getString(R.string.n_kline_1month));
                B(false);
                g(this.B);
            }
        }
        if (view.getId() != R.id.market_info_more_layout && view.getId() != R.id.target_checkbox_layout) {
            setUpPeriodView(view.getId());
            z();
            BaseModuleConfig.a().w("App_markets_kline_indexset_click", (HashMap) null);
        }
    }

    public final void z() {
        int c11 = KLineHelper.c(getContext(), R.attr.kline_index_setting_text_color);
        int c12 = KLineHelper.c(getContext(), R.attr.kline_three_level_text_color);
        boolean z11 = true;
        w(this.f21180c, !m() && this.L == Period.timeline);
        v(this.f21192o, !m() && this.L == Period.timeline, c11, c12);
        w(this.f21181d, !m() && this.L == Period.min1);
        v(this.f21193p, !m() && this.L == Period.min1, c11, c12);
        w(this.f21182e, !m() && this.L == Period.min5);
        v(this.f21194q, !m() && this.L == Period.min5, c11, c12);
        w(this.f21184g, !m() && this.L == Period.min30);
        v(this.f21196s, !m() && this.L == Period.min30, c11, c12);
        w(this.f21189l, !m() && this.L == Period.month);
        TextView textView = this.f21201x;
        if (m() || this.L != Period.month) {
            z11 = false;
        }
        v(textView, z11, c11, c12);
    }

    public KLineEdgeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j(context);
    }

    public KLineEdgeItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        j(context);
    }
}
