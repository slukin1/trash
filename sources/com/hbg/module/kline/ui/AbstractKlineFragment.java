package com.hbg.module.kline.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.CoinStringUtil;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.index.core.util.ContractIndexPrecisionUtil;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$color;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.bean.IndexDetail;
import com.hbg.module.kline.bean.IndexIngredient;
import com.hbg.module.kline.index.IndexSettingActivity;
import com.hbg.module.kline.presenter.AbstractKlinePresenter;
import com.hbg.module.kline.view.KlineViewWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.view.seekbar.MultiColorSeekBar;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import i6.m;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;

public abstract class AbstractKlineFragment extends BaseFragment<com.hbg.module.kline.presenter.a, AbstractKlinePresenter.b> implements AbstractKlinePresenter.b, vd.c {
    public TextView A;
    public View A0;
    public TextView B;
    public View B0;
    public View C;
    public View C0;
    public TextView D;
    public View D0;
    public TextView E;
    public View E0;
    public TextView F;
    public View F0;
    public TextView G;
    public int G0 = 0;
    public TextView H;
    public int H0 = 0;
    public TextView I;
    public double I0 = 0.0d;
    public TextView J;
    public boolean J0 = false;
    public TextView K;
    public Period K0;
    public TextView L;
    public String L0;
    public TextView M;
    public String M0;
    public TextView N;
    public String N0;
    public RelativeLayout O;
    public String O0;
    public RelativeLayout P;
    public String P0;
    public RelativeLayout Q;
    public String Q0;
    public RelativeLayout R;
    public String R0;
    public RelativeLayout S;
    public String S0;
    public RelativeLayout T;
    public boolean T0;
    public RelativeLayout U;
    public String U0 = null;
    public RelativeLayout V;
    public String V0 = null;
    public RelativeLayout W;
    public boolean W0 = false;
    public RelativeLayout X;
    public KlineInfo X0;
    public RelativeLayout Y;
    public KlineViewWrapper Y0;
    public RelativeLayout Z;
    public int Z0;

    /* renamed from: a0  reason: collision with root package name */
    public RelativeLayout f23784a0;

    /* renamed from: a1  reason: collision with root package name */
    public int f23785a1;

    /* renamed from: b0  reason: collision with root package name */
    public View f23786b0;

    /* renamed from: b1  reason: collision with root package name */
    public int f23787b1;

    /* renamed from: c0  reason: collision with root package name */
    public View f23788c0;

    /* renamed from: c1  reason: collision with root package name */
    public boolean f23789c1;

    /* renamed from: d0  reason: collision with root package name */
    public TextView f23790d0;

    /* renamed from: d1  reason: collision with root package name */
    public View f23791d1;

    /* renamed from: e0  reason: collision with root package name */
    public ImageView f23792e0;

    /* renamed from: e1  reason: collision with root package name */
    public View f23793e1;

    /* renamed from: f0  reason: collision with root package name */
    public View f23794f0;

    /* renamed from: f1  reason: collision with root package name */
    public View f23795f1;

    /* renamed from: g0  reason: collision with root package name */
    public TextView f23796g0;

    /* renamed from: g1  reason: collision with root package name */
    public String f23797g1 = "";

    /* renamed from: h0  reason: collision with root package name */
    public View f23798h0;

    /* renamed from: h1  reason: collision with root package name */
    public String f23799h1 = "";

    /* renamed from: i0  reason: collision with root package name */
    public ImageView f23800i0;

    /* renamed from: i1  reason: collision with root package name */
    public int f23801i1;

    /* renamed from: j0  reason: collision with root package name */
    public ImageView f23802j0;

    /* renamed from: j1  reason: collision with root package name */
    public int f23803j1;

    /* renamed from: k0  reason: collision with root package name */
    public AppBarLayout f23804k0;

    /* renamed from: k1  reason: collision with root package name */
    public Runnable f23805k1 = new u(this);

    /* renamed from: l  reason: collision with root package name */
    public Period[] f23806l;

    /* renamed from: l0  reason: collision with root package name */
    public TextView f23807l0;

    /* renamed from: l1  reason: collision with root package name */
    public boolean f23808l1;

    /* renamed from: m  reason: collision with root package name */
    public Period[] f23809m;

    /* renamed from: m0  reason: collision with root package name */
    public TextView f23810m0;

    /* renamed from: m1  reason: collision with root package name */
    public boolean f23811m1;

    /* renamed from: n  reason: collision with root package name */
    public ImageView f23812n;

    /* renamed from: n0  reason: collision with root package name */
    public TextView f23813n0;

    /* renamed from: n1  reason: collision with root package name */
    public boolean f23814n1;

    /* renamed from: o  reason: collision with root package name */
    public TextView f23815o;

    /* renamed from: o1  reason: collision with root package name */
    public boolean f23816o1;

    /* renamed from: p  reason: collision with root package name */
    public TextView f23817p;

    /* renamed from: p1  reason: collision with root package name */
    public boolean f23818p1;

    /* renamed from: q  reason: collision with root package name */
    public TextView f23819q;

    /* renamed from: q1  reason: collision with root package name */
    public boolean f23820q1;

    /* renamed from: r  reason: collision with root package name */
    public TextView f23821r;

    /* renamed from: r1  reason: collision with root package name */
    public int f23822r1;

    /* renamed from: s  reason: collision with root package name */
    public TextView f23823s;

    /* renamed from: s1  reason: collision with root package name */
    public LinkedHashSet<String> f23824s1;

    /* renamed from: t  reason: collision with root package name */
    public TextView f23825t;

    /* renamed from: t0  reason: collision with root package name */
    public TextView f23826t0;

    /* renamed from: u  reason: collision with root package name */
    public TextView f23827u;

    /* renamed from: u0  reason: collision with root package name */
    public View f23828u0;

    /* renamed from: v  reason: collision with root package name */
    public TextView f23829v;

    /* renamed from: v0  reason: collision with root package name */
    public TextView f23830v0;

    /* renamed from: w  reason: collision with root package name */
    public TextView f23831w;

    /* renamed from: w0  reason: collision with root package name */
    public TextView f23832w0;

    /* renamed from: x  reason: collision with root package name */
    public TextView f23833x;

    /* renamed from: x0  reason: collision with root package name */
    public TextView f23834x0;

    /* renamed from: y  reason: collision with root package name */
    public TextView f23835y;

    /* renamed from: y0  reason: collision with root package name */
    public TextView f23836y0;

    /* renamed from: z  reason: collision with root package name */
    public TextView f23837z;

    /* renamed from: z0  reason: collision with root package name */
    public MultiColorSeekBar f23838z0;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f23839b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f23840c;

        public a(Animator.AnimatorListener animatorListener, View view) {
            this.f23839b = animatorListener;
            this.f23840c = view;
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f23839b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            ViewUtil.m(this.f23840c, true);
            Animator.AnimatorListener animatorListener = this.f23839b;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f23842b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f23843c;

        public b(View view, Animator.AnimatorListener animatorListener) {
            this.f23842b = view;
            this.f23843c = animatorListener;
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            ViewUtil.m(this.f23842b, false);
            Animator.AnimatorListener animatorListener = this.f23843c;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f23843c;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23845a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f23846b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0059 */
        static {
            /*
                com.hbg.lib.network.pro.core.util.Period[] r0 = com.hbg.lib.network.pro.core.util.Period.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23846b = r0
                r1 = 1
                com.hbg.lib.network.pro.core.util.Period r2 = com.hbg.lib.network.pro.core.util.Period.min1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f23846b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.network.pro.core.util.Period r3 = com.hbg.lib.network.pro.core.util.Period.min5     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f23846b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.network.pro.core.util.Period r4 = com.hbg.lib.network.pro.core.util.Period.min30     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f23846b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.network.pro.core.util.Period r4 = com.hbg.lib.network.pro.core.util.Period.month     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f23846b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.lib.network.pro.core.util.Period r4 = com.hbg.lib.network.pro.core.util.Period.timeline     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                com.hbg.lib.data.symbol.TradeType[] r3 = com.hbg.lib.data.symbol.TradeType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f23845a = r3
                com.hbg.lib.data.symbol.TradeType r4 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x004f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = f23845a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f23845a     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.kline.ui.AbstractKlineFragment.c.<clinit>():void");
        }
    }

    public class d extends BaseSubscriber<Integer> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f23847b;

        public d(boolean z11) {
            this.f23847b = z11;
        }

        /* renamed from: a */
        public void onNext(Integer num) {
            super.onNext(num);
            CoinStringUtil.b(num.intValue());
        }
    }

    public class e implements MultiColorSeekBar.OnProgressChangedListener {
        public e() {
        }

        public void getProgressOnActionUp(MultiColorSeekBar multiColorSeekBar, int i11, float f11) {
            AbstractKlineFragment abstractKlineFragment = AbstractKlineFragment.this;
            abstractKlineFragment.f23801i1 = i11;
            abstractKlineFragment.f23803j1 = 0;
            i6.i.b().h(AbstractKlineFragment.this.f23805k1);
            AbstractKlineFragment.this.C0.setAlpha(1.0f);
            AbstractKlineFragment.this.B0.setAlpha(1.0f);
            AbstractKlineFragment.this.A0.setBackgroundColor(0);
            AbstractKlineFragment.this.gi();
        }

        public void getProgressOnFinally(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
            i6.i.b().h(AbstractKlineFragment.this.f23805k1);
            if (z11) {
                AbstractKlineFragment abstractKlineFragment = AbstractKlineFragment.this;
                if (abstractKlineFragment.f23801i1 != i11) {
                    abstractKlineFragment.f23801i1 = i11;
                    i6.i b11 = i6.i.b();
                    AbstractKlineFragment abstractKlineFragment2 = AbstractKlineFragment.this;
                    Runnable runnable = abstractKlineFragment2.f23805k1;
                    int i12 = abstractKlineFragment2.f23803j1;
                    abstractKlineFragment2.f23803j1 = i12 + 1;
                    b11.g(runnable, i12 == 0 ? 200 : 0);
                }
            }
        }
    }

    public class f implements KLineHelper.a {
        public f() {
        }

        public void a(LinkedHashSet<String> linkedHashSet) {
            LinkedHashSet unused = AbstractKlineFragment.this.f23824s1 = linkedHashSet;
            AbstractKlineFragment abstractKlineFragment = AbstractKlineFragment.this;
            abstractKlineFragment.f23826t0.setSelected(abstractKlineFragment.f23824s1.contains("VOL"));
            AbstractKlineFragment.this.f23830v0.setSelected(AbstractKlineFragment.this.f23824s1.contains("MACD"));
            AbstractKlineFragment.this.f23832w0.setSelected(AbstractKlineFragment.this.f23824s1.contains("KDJ"));
            AbstractKlineFragment.this.f23834x0.setSelected(AbstractKlineFragment.this.f23824s1.contains("RSI"));
            AbstractKlineFragment.this.f23836y0.setSelected(AbstractKlineFragment.this.f23824s1.contains("WR"));
        }

        public void b(int i11) {
            int unused = AbstractKlineFragment.this.f23822r1 = i11;
            boolean z11 = true;
            AbstractKlineFragment.this.f23807l0.setSelected((AbstractKlineFragment.this.f23822r1 & 1) == 1);
            AbstractKlineFragment.this.f23810m0.setSelected((AbstractKlineFragment.this.f23822r1 & 2) == 2);
            TextView bi2 = AbstractKlineFragment.this.f23813n0;
            if ((AbstractKlineFragment.this.f23822r1 & 4) != 4) {
                z11 = false;
            }
            bi2.setSelected(z11);
        }
    }

    public class g extends AnimatorListenerAdapter {

        public class a extends AnimatorListenerAdapter {
            public a() {
            }

            public void onAnimationEnd(Animator animator) {
                AbstractKlineFragment.this.f23808l1 = false;
            }

            public void onAnimationStart(Animator animator) {
                AbstractKlineFragment.this.f23808l1 = true;
            }
        }

        public g() {
        }

        public void onAnimationEnd(Animator animator) {
            AbstractKlineFragment abstractKlineFragment = AbstractKlineFragment.this;
            abstractKlineFragment.ji(abstractKlineFragment.f23786b0, abstractKlineFragment.B0, AbstractKlineFragment.this.C0, new a());
        }
    }

    public class h extends AnimatorListenerAdapter {
        public h() {
        }

        public void onAnimationEnd(Animator animator) {
            AbstractKlineFragment.this.f23808l1 = false;
        }

        public void onAnimationStart(Animator animator) {
            AbstractKlineFragment.this.f23808l1 = true;
        }
    }

    public class i extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f23854b;

        public i(Animator.AnimatorListener animatorListener) {
            this.f23854b = animatorListener;
        }

        public void onAnimationEnd(Animator animator) {
            AbstractKlineFragment abstractKlineFragment = AbstractKlineFragment.this;
            abstractKlineFragment.f23816o1 = false;
            abstractKlineFragment.f23808l1 = false;
            FragmentActivity activity = abstractKlineFragment.getActivity();
            if (activity != null) {
                TypedValue typedValue = new TypedValue();
                activity.getTheme().resolveAttribute(R$attr.kline_index_setting_icon, typedValue, true);
                AbstractKlineFragment.this.f23792e0.setImageResource(typedValue.resourceId);
                Animator.AnimatorListener animatorListener = this.f23854b;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }
        }

        public void onAnimationStart(Animator animator) {
            AbstractKlineFragment.this.f23808l1 = true;
        }
    }

    public class j extends AnimatorListenerAdapter {

        public class a extends AnimatorListenerAdapter {
            public a() {
            }

            public void onAnimationEnd(Animator animator) {
                AbstractKlineFragment.this.f23814n1 = false;
            }

            public void onAnimationStart(Animator animator) {
                AbstractKlineFragment.this.f23814n1 = true;
            }
        }

        public j() {
        }

        public void onAnimationEnd(Animator animator) {
            AbstractKlineFragment abstractKlineFragment = AbstractKlineFragment.this;
            abstractKlineFragment.ji(abstractKlineFragment.f23794f0, abstractKlineFragment.D0, abstractKlineFragment.E0, new a());
        }
    }

    public class k extends AnimatorListenerAdapter {
        public k() {
        }

        public void onAnimationEnd(Animator animator) {
            AbstractKlineFragment.this.f23814n1 = false;
        }

        public void onAnimationStart(Animator animator) {
            AbstractKlineFragment.this.f23814n1 = true;
        }
    }

    public class l extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f23859b;

        public l(Animator.AnimatorListener animatorListener) {
            this.f23859b = animatorListener;
        }

        public void onAnimationEnd(Animator animator) {
            AbstractKlineFragment abstractKlineFragment = AbstractKlineFragment.this;
            abstractKlineFragment.f23818p1 = false;
            abstractKlineFragment.f23814n1 = false;
            abstractKlineFragment.tj();
            AbstractKlineFragment.this.f23794f0.setVisibility(8);
            Animator.AnimatorListener animatorListener = this.f23859b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            AbstractKlineFragment.this.f23814n1 = true;
        }
    }

    public AbstractKlineFragment() {
        Period period = Period.timeline;
        Period period2 = Period.min15;
        Period period3 = Period.min60;
        Period period4 = Period.hour4;
        Period period5 = Period.day;
        Period period6 = Period.week;
        this.f23806l = new Period[]{period, period2, period3, period4, period5, period6};
        this.f23809m = new Period[]{period, Period.min1, Period.min5, period2, Period.min30, period3, period4, period5, period6, Period.month};
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bi(View view) {
        pj(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ci(View view) {
        uj(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Di(View view) {
        if (this.f23824s1.remove("MACD")) {
            lj(this.f23824s1);
            this.f23830v0.setSelected(false);
            KLineHelper.h(this.f23824s1);
        } else {
            this.f23824s1.add("MACD");
            lj(this.f23824s1);
            this.f23830v0.setSelected(true);
            KLineHelper.h(this.f23824s1);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "MACD");
            td.i.a().b().d("4698", hashMap, qi());
        }
        Vi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ei(View view) {
        if (this.f23824s1.remove("KDJ")) {
            lj(this.f23824s1);
            this.f23832w0.setSelected(false);
            KLineHelper.h(this.f23824s1);
        } else {
            this.f23824s1.add("KDJ");
            lj(this.f23824s1);
            this.f23832w0.setSelected(true);
            KLineHelper.h(this.f23824s1);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "KDJ");
            td.i.a().b().d("4698", hashMap, qi());
        }
        Vi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fi(View view) {
        if (this.f23824s1.remove("RSI")) {
            lj(this.f23824s1);
            this.f23834x0.setSelected(false);
            KLineHelper.h(this.f23824s1);
        } else {
            this.f23824s1.add("RSI");
            lj(this.f23824s1);
            this.f23834x0.setSelected(true);
            KLineHelper.h(this.f23824s1);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "RSI");
            td.i.a().b().d("4698", hashMap, qi());
        }
        Vi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Gi(View view) {
        if (this.f23824s1.remove("WR")) {
            lj(this.f23824s1);
            this.f23836y0.setSelected(false);
            KLineHelper.h(this.f23824s1);
        } else {
            this.f23824s1.add("WR");
            lj(this.f23824s1);
            this.f23836y0.setSelected(true);
            KLineHelper.h(this.f23824s1);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "WR");
            td.i.a().b().d("4698", hashMap, qi());
        }
        Vi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hi(View view, int[] iArr) {
        view.getLocationInWindow(iArr);
        this.C.setTranslationX((float) iArr[0]);
        ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        if (this.f23796g0 == view) {
            layoutParams.width = view.getWidth();
        } else {
            layoutParams.width = view.getWidth();
        }
        this.C.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ii(ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.C.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ji(View view, View view2) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (!this.f23789c1) {
            this.f23789c1 = true;
            view.post(new v(this, view, iArr));
            return;
        }
        this.C.animate().translationX((float) iArr[0]);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.C.getWidth(), view.getWidth()});
        ofInt.addUpdateListener(new q(this));
        ofInt.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ki() {
        this.A0.setBackgroundColor(KLineHelper.f() ? 1711276032 : getResources().getColor(R$color.color_13161E));
        this.C0.setAlpha(0.0f);
        this.B0.setAlpha(0.0f);
        gi();
    }

    private void Li() {
        boolean z11 = true;
        int g11 = ConfigPreferences.g("user_config", "config_target_top_20221026", 1);
        this.f23822r1 = g11;
        this.f23807l0.setSelected((g11 & 1) == 1);
        this.f23810m0.setSelected((this.f23822r1 & 2) == 2);
        TextView textView = this.f23813n0;
        if ((this.f23822r1 & 4) != 4) {
            z11 = false;
        }
        textView.setSelected(z11);
        this.Y0.setMasterIndex(this.f23822r1);
        LinkedHashSet<String> b11 = CandleStickRender.SlaveChartIndex.b(ConfigPreferences.e("user_config", "config_target_under_20221026", "VOL"));
        this.f23824s1 = b11;
        this.f23826t0.setSelected(b11.contains("VOL"));
        this.f23830v0.setSelected(this.f23824s1.contains("MACD"));
        this.f23832w0.setSelected(this.f23824s1.contains("KDJ"));
        this.f23834x0.setSelected(this.f23824s1.contains("RSI"));
        this.f23836y0.setSelected(this.f23824s1.contains("WR"));
        lj(this.f23824s1);
        Vi();
    }

    private void Mi() {
        RelativeLayout relativeLayout;
        Period period = Period.min15;
        Period parsePeriod = Period.parsePeriod(ConfigPreferences.e("user_config", "config_period", period.value));
        if (!Ai() || parsePeriod != this.K0) {
            if (parsePeriod == Period.timeline) {
                if (TradeType.isLinearSwapIndex(this.S0) || TradeType.isContractIndex(this.S0) || TradeType.isIndex(this.S0)) {
                    relativeLayout = (RelativeLayout) this.f67460i.b(R$id.time_sharing_radio_layout);
                } else {
                    this.f23796g0.setTextColor(si());
                    this.f23796g0.setText(R$string.n_kline_timeline);
                    if (ae()) {
                        relativeLayout = (RelativeLayout) this.f67460i.b(R$id.float_time_radio_layout_etp);
                    } else {
                        relativeLayout = (RelativeLayout) this.f67460i.b(R$id.float_time_radio_layout);
                    }
                }
            } else if (parsePeriod == Period.min1) {
                if (!ae() || this.W0) {
                    relativeLayout = (RelativeLayout) this.f67460i.b(R$id.one_min_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) this.f67460i.b(R$id.one_min_radio_layout_etp);
                }
            } else if (parsePeriod == Period.min5) {
                if (!ae() || this.W0) {
                    relativeLayout = (RelativeLayout) this.f67460i.b(R$id.five_min_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) this.f67460i.b(R$id.five_min_radio_layout_etp);
                }
            } else if (parsePeriod == period) {
                relativeLayout = (RelativeLayout) this.f67460i.b(R$id.fifteen_min_radio_layout);
            } else if (parsePeriod == Period.min30) {
                if (!ae() || this.W0) {
                    relativeLayout = (RelativeLayout) this.f67460i.b(R$id.thirty_min_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) this.f67460i.b(R$id.thirty_min_radio_layout_etp);
                }
            } else if (parsePeriod == Period.min60) {
                relativeLayout = (RelativeLayout) this.f67460i.b(R$id.sixty_min_radio_layout);
            } else if (parsePeriod == Period.hour4) {
                relativeLayout = (RelativeLayout) this.f67460i.b(R$id.four_hour_radio_layout);
            } else if (parsePeriod == Period.day) {
                relativeLayout = (RelativeLayout) this.f67460i.b(R$id.one_day_radio_layout);
            } else if (parsePeriod == Period.week) {
                if (!ae() || this.W0) {
                    relativeLayout = (RelativeLayout) this.f67460i.b(R$id.one_week_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) this.f67460i.b(R$id.one_week_radio_layout_etp);
                }
            } else if (parsePeriod != Period.month) {
                relativeLayout = (RelativeLayout) this.f67460i.b(R$id.fifteen_min_radio_layout);
            } else if (!ae() || this.W0) {
                relativeLayout = (RelativeLayout) this.f67460i.b(R$id.one_month_radio_layout);
            } else {
                relativeLayout = (RelativeLayout) this.f67460i.b(R$id.one_month_radio_layout_etp);
            }
            relativeLayout.setClickable(true);
            relativeLayout.performClick();
        }
    }

    private int Qi() {
        if (TradeType.isContract(this.S0)) {
            return td.i.a().b().z(this.Q0);
        }
        if (TradeType.isSwap(this.S0)) {
            return td.i.a().b().B(this.N0);
        }
        if (TradeType.isContractIndex(this.S0)) {
            return ContractIndexPrecisionUtil.a(this.Q0);
        }
        if (TradeType.isOption(this.S0)) {
            return FuturePrecisionUtil.y(this.Q0, this.O0, this.R0);
        }
        if (TradeType.isLinearSwap(this.S0)) {
            return FuturePrecisionUtil.y(this.Q0, this.O0, this.R0);
        }
        if (TradeType.isLinearSwapIndex(this.S0)) {
            return FuturePrecisionUtil.b(((IndexCurrencyInfo) getActivity().getIntent().getSerializableExtra("contract_currency_info")).getContractCode());
        }
        return PrecisionUtil.w(this.L0, TradeType.valueOf(this.S0));
    }

    private int Ui() {
        if (TradeType.isContract(this.S0)) {
            if (a7.e.E(TradeType.CONTRACT)) {
                return td.i.a().b().t(this.Q0);
            }
            return td.i.a().b().D(this.Q0);
        } else if (TradeType.isSwap(this.S0)) {
            if (a7.e.E(TradeType.SWAP)) {
                return td.i.a().b().m(this.N0);
            }
            return td.i.a().b().j(this.N0);
        } else if (TradeType.isContractIndex(this.S0)) {
            return 0;
        } else {
            if (TradeType.isOption(this.S0)) {
                if (a7.e.E(TradeType.valueOf(this.S0))) {
                    return FuturePrecisionUtil.s(this.Q0, this.O0, this.R0);
                }
                return FuturePrecisionUtil.B();
            } else if (TradeType.isLinearSwap(this.S0)) {
                if (a7.e.F(TradeType.valueOf(this.S0))) {
                    return FuturePrecisionUtil.s(this.Q0, this.O0, this.R0);
                }
                return FuturePrecisionUtil.B();
            } else if (TradeType.isLinearSwapIndex(this.S0)) {
                return 0;
            } else {
                return PrecisionUtil.z(this.L0);
            }
        }
    }

    private void Wi(String str) {
        String str2 = "--";
        if (!TextUtils.isEmpty(str)) {
            String str3 = null;
            if (TradeType.isContract(this.S0) || TradeType.isSwap(this.S0) || TradeType.isContractIndex(this.S0) || TradeType.isOption(this.S0) || TradeType.isLinearSwap(this.S0) || TradeType.isLinearSwapIndex(this.S0)) {
                str3 = td.i.a().b().v(str);
            } else if (this.S0 != null) {
                if (TextUtils.isEmpty(this.L0) || !a1.v().D(this.L0).equalsIgnoreCase("usdt")) {
                    str3 = td.i.a().b().l(str, this.L0, TradeType.PRO);
                } else {
                    str3 = td.i.a().b().v(str);
                }
            }
            if (m.h0(str3) != 0.0d) {
                String i11 = StringUtils.i(BaseModuleConfig.a().M());
                String string = getResources().getString(R$string.balance_total_cny);
                str2 = String.format(string, new Object[]{m.c(str3, str2) + " " + i11});
            }
        }
        this.f23837z.setText(str2);
    }

    private void Xi(KlineInfo klineInfo) {
        if (this.f23825t != null) {
            this.f23825t.setText(m.T(BigDecimal.valueOf(klineInfo.getClose()).multiply(BigDecimal.valueOf(klineInfo.getAmount())).toPlainString(), this.f23785a1));
        }
    }

    private void Yi() {
        boolean z11 = false;
        boolean z12 = TradeType.isContract(this.S0) && a7.e.E(TradeType.CONTRACT);
        boolean z13 = TradeType.isSwap(this.S0) && a7.e.E(TradeType.SWAP);
        boolean z14 = TradeType.isLinearSwap(this.S0) && a7.e.F(TradeType.valueOf(this.S0));
        boolean z15 = TradeType.isOption(this.S0) && a7.e.E(TradeType.valueOf(this.S0));
        if (z12 || z13 || z14) {
            z11 = true;
        }
        if (z11 && m.a0(this.U0) && m.a0(this.V0)) {
            this.B.setText(vi(this.U0));
            this.B.append(((com.hbg.module.kline.presenter.a) yh()).h0());
        } else if (z15 && m.a0(this.U0) && m.a0(this.V0)) {
            if (this.W0) {
                this.B.setText(m.T(this.U0, FuturePrecisionUtil.s(this.Q0, this.O0, this.R0)));
            } else {
                this.B.setText(m.o(this.U0, FuturePrecisionUtil.s(this.Q0, this.O0, this.R0), true));
            }
            this.B.append(((com.hbg.module.kline.presenter.a) yh()).h0());
        }
    }

    private void Zi(String str) {
        if (this.W0) {
            this.B.setText(getString(R$string.contract_hold_num_value, m.T(str, 0)));
            return;
        }
        this.B.setText(getString(R$string.contract_hold_num_value, m.o(str, 0, true)));
    }

    private void bj() {
        List<be.i> a11 = be.j.c().a();
        if (!UtilCollections.f(a11)) {
            int a12 = a11.get(0).a();
            int a13 = a11.get(1).a();
            int a14 = a11.get(2).a();
            int a15 = a11.get(3).a();
            int a16 = a11.get(4).a();
            int a17 = a11.get(5).a();
            int a18 = a11.get(20).a();
            int a19 = a11.get(21).a();
            int c11 = a11.get(6).c();
            int c12 = a11.get(7).c();
            int c13 = a11.get(8).c();
            int c14 = a11.get(9).c();
            int c15 = a11.get(10).c();
            int c16 = a11.get(11).c();
            int c17 = a11.get(12).c();
            int c18 = a11.get(13).c();
            int a21 = a11.get(14).a();
            int a22 = a11.get(15).a();
            int a23 = a11.get(16).a();
            int a24 = a11.get(17).a();
            int a25 = a11.get(18).a();
            int a26 = a11.get(19).a();
            this.Y0.H(a11.get(22).a(), a11.get(23).a(), a11.get(24).a(), a11.get(25).a(), a11.get(26).a(), a11.get(27).a(), a11.get(28).a(), a11.get(29).a());
            this.Y0.J(a12, a13, a14, a15, a16, a17, a18, a19, c11, c12, c13, c14, c15, c16, c17, c18, a21, a22, a23, a24, a25, a26);
        }
    }

    private void ej(double d11) {
        this.V0 = String.valueOf(d11);
        if (TradeType.isContract(this.S0) || TradeType.isSwap(this.S0) || TradeType.isLinearSwap(this.S0)) {
            Yi();
        }
        dj(d11);
        Wi(String.valueOf(d11));
    }

    private void hj(TextView textView, boolean z11, int i11, int i12) {
        if (textView == null) {
            return;
        }
        if (z11) {
            textView.setTextColor(i11);
        } else {
            textView.setTextColor(i12);
        }
    }

    private void ki(View view) {
        ViewUtil.b(view, new t(this, view));
    }

    private void kj(View view, boolean z11) {
        if (view != null) {
            view.setSelected(z11);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        startActivity(new Intent(getActivity(), IndexSettingActivity.class));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        int i11 = this.f23822r1;
        if ((i11 & 1) == 1) {
            int i12 = i11 & -2;
            this.f23822r1 = i12;
            ConfigPreferences.k("user_config", "config_target_top_20221026", i12);
            this.Y0.setMasterIndex(this.f23822r1);
            this.f23807l0.setSelected(false);
            KLineHelper.g(this.f23822r1);
        } else {
            int i13 = i11 | 1;
            this.f23822r1 = i13;
            ConfigPreferences.k("user_config", "config_target_top_20221026", i13);
            this.Y0.setMasterIndex(this.f23822r1);
            this.f23807l0.setSelected(true);
            KLineHelper.g(this.f23822r1);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "MA");
            td.i.a().b().d("4696", hashMap, qi());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        int i11 = this.f23822r1;
        if ((i11 & 2) == 2) {
            int i12 = i11 & -3;
            this.f23822r1 = i12;
            ConfigPreferences.k("user_config", "config_target_top_20221026", i12);
            this.Y0.setMasterIndex(this.f23822r1);
            this.f23810m0.setSelected(false);
            KLineHelper.g(this.f23822r1);
        } else {
            int i13 = i11 | 2;
            this.f23822r1 = i13;
            ConfigPreferences.k("user_config", "config_target_top_20221026", i13);
            this.Y0.setMasterIndex(this.f23822r1);
            this.f23810m0.setSelected(true);
            KLineHelper.g(this.f23822r1);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "EMA");
            td.i.a().b().d("4696", hashMap, qi());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        int i11 = this.f23822r1;
        if ((i11 & 4) == 4) {
            int i12 = i11 & -5;
            this.f23822r1 = i12;
            ConfigPreferences.k("user_config", "config_target_top_20221026", i12);
            this.Y0.setMasterIndex(this.f23822r1);
            this.f23813n0.setSelected(false);
            KLineHelper.g(this.f23822r1);
        } else {
            int i13 = i11 | 4;
            this.f23822r1 = i13;
            ConfigPreferences.k("user_config", "config_target_top_20221026", i13);
            this.Y0.setMasterIndex(this.f23822r1);
            this.f23813n0.setSelected(true);
            KLineHelper.g(this.f23822r1);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "BOLL");
            td.i.a().b().d("4698", hashMap, qi());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        if (this.f23824s1.remove("VOL")) {
            lj(this.f23824s1);
            this.f23826t0.setSelected(false);
            KLineHelper.h(this.f23824s1);
        } else {
            this.f23824s1.add("VOL");
            lj(this.f23824s1);
            this.f23826t0.setSelected(true);
            KLineHelper.h(this.f23824s1);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "VOL");
            td.i.a().b().d("4698", hashMap, qi());
        }
        Vi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void oj() {
        int c11 = KLineHelper.c(getActivity(), R$attr.kline_index_setting_text_color);
        int c12 = KLineHelper.c(getActivity(), R$attr.kline_three_level_text_color);
        boolean z11 = true;
        kj(this.Q, !Ai() && this.K0 == Period.timeline);
        hj(this.E, !Ai() && this.K0 == Period.timeline, c11, c12);
        kj(this.R, !Ai() && this.K0 == Period.min1);
        hj(this.F, !Ai() && this.K0 == Period.min1, c11, c12);
        kj(this.S, !Ai() && this.K0 == Period.min5);
        hj(this.G, !Ai() && this.K0 == Period.min5, c11, c12);
        kj(this.U, !Ai() && this.K0 == Period.min30);
        hj(this.I, !Ai() && this.K0 == Period.min30, c11, c12);
        kj(this.Z, !Ai() && this.K0 == Period.month);
        TextView textView = this.N;
        if (Ai() || this.K0 != Period.month) {
            z11 = false;
        }
        hj(textView, z11, c11, c12);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        if (r4.K0 == com.hbg.lib.network.pro.core.util.Period.week) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void tj() {
        /*
            r4 = this;
            com.hbg.lib.network.pro.core.util.Period r0 = r4.K0
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
            android.widget.RelativeLayout r1 = r4.P
            if (r1 == 0) goto L_0x0037
            int r1 = r1.getVisibility()
            if (r1 == 0) goto L_0x0037
            com.hbg.lib.network.pro.core.util.Period r1 = r4.K0
            com.hbg.lib.network.pro.core.util.Period r3 = com.hbg.lib.network.pro.core.util.Period.timeline
            if (r1 != r3) goto L_0x002a
            r0 = r2
        L_0x002a:
            boolean r1 = r4.ae()
            if (r1 == 0) goto L_0x0037
            com.hbg.lib.network.pro.core.util.Period r1 = r4.K0
            com.hbg.lib.network.pro.core.util.Period r3 = com.hbg.lib.network.pro.core.util.Period.week
            if (r1 != r3) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r2 = r0
        L_0x0038:
            if (r2 == 0) goto L_0x004a
            boolean r0 = r4.Ai()
            if (r0 != 0) goto L_0x004a
            android.widget.TextView r0 = r4.f23796g0
            int r1 = r4.si()
            r0.setTextColor(r1)
            goto L_0x0053
        L_0x004a:
            android.widget.TextView r0 = r4.f23796g0
            int r1 = r4.oi()
            r0.setTextColor(r1)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.kline.ui.AbstractKlineFragment.tj():void");
    }

    private String vi(String str) {
        if (m.a(str).compareTo(BigDecimal.ZERO) == 0 || m.a(this.V0).compareTo(BigDecimal.ZERO) == 0) {
            return str;
        }
        if (TextUtils.isEmpty(((com.hbg.module.kline.presenter.a) yh()).f0())) {
            return "--";
        }
        BigDecimal bigDecimal = new BigDecimal(((com.hbg.module.kline.presenter.a) yh()).f0());
        BigDecimal bigDecimal2 = new BigDecimal(str);
        if (this.W0) {
            return m.T(m.L(bigDecimal2.multiply(bigDecimal).divide(m.a(this.V0), 32, RoundingMode.DOWN).toString(), 1), 1);
        }
        return m.c(m.L(bigDecimal2.multiply(bigDecimal).divide(m.a(this.V0), 32, RoundingMode.DOWN).toString(), 1), "--");
    }

    public void Ah() {
        RelativeLayout relativeLayout = this.f23784a0;
        if (relativeLayout != null) {
            relativeLayout.setClickable(true);
        }
        this.P.setClickable(true);
        this.R.setClickable(true);
        RelativeLayout relativeLayout2 = this.Q;
        if (relativeLayout2 != null) {
            relativeLayout2.setClickable(true);
        }
        this.S.setClickable(true);
        this.T.setClickable(true);
        this.U.setClickable(true);
        this.V.setClickable(true);
        this.W.setClickable(true);
        this.X.setClickable(true);
        this.Y.setClickable(true);
        this.Z.setClickable(true);
        this.f23788c0.setOnClickListener(new y(this));
        P("--");
        TextView textView = this.f23807l0;
        if (textView != null) {
            textView.setOnClickListener(new x(this));
        }
        TextView textView2 = this.f23810m0;
        if (textView2 != null) {
            textView2.setOnClickListener(new b0(this));
        }
        TextView textView3 = this.f23813n0;
        if (textView3 != null) {
            textView3.setOnClickListener(new s(this));
        }
        this.f23826t0.setOnClickListener(new z(this));
        this.f23830v0.setOnClickListener(new c0(this));
        this.f23832w0.setOnClickListener(new a0(this));
        this.f23834x0.setOnClickListener(new r(this));
        this.f23836y0.setOnClickListener(new d0(this));
        View view = this.C0;
        if (view != null) {
            view.setOnClickListener(new e0(this));
        }
        View view2 = this.E0;
        if (view2 != null) {
            view2.setOnClickListener(new w(this));
        }
        KLineHelper.a(new f());
    }

    public boolean Ai() {
        return false;
    }

    public void G3(KlineInfo klineInfo) {
        this.X0 = klineInfo;
    }

    public void M(KlineInfo klineInfo) {
        if (mj()) {
            this.f23819q.setText(m.T(String.valueOf(klineInfo.getAmount()), PrecisionUtil.t(this.L0)));
        } else {
            this.f23819q.setText(m.k(klineInfo.getAmount(), PrecisionUtil.t(this.L0), true));
        }
        if (this.f23825t != null) {
            this.f23825t.setText(m.T(String.valueOf(klineInfo.getVol()), this.f23785a1));
        }
        if (TradeType.isPro(this.S0)) {
            this.f23827u.setText(m.k(klineInfo.getHigh(), this.Z0, true));
            this.f23821r.setText(m.k(klineInfo.getLow(), this.Z0, true));
        }
    }

    public String Ni(Intent intent) {
        return intent.getStringExtra("contractCode");
    }

    public String Oi(Intent intent) {
        return intent.getStringExtra("contract_currency_symble");
    }

    @SuppressLint({"SetTextI18n"})
    public void P(String str) {
        if (this.B != null) {
            boolean z11 = true;
            if (!TradeType.isLinearSwap(this.S0)) {
                boolean z12 = TradeType.isContract(this.S0) && a7.e.E(TradeType.CONTRACT);
                if (!TradeType.isSwap(this.S0) || !a7.e.E(TradeType.SWAP)) {
                    z11 = false;
                }
                if (z12 || z11) {
                    this.U0 = str;
                    Yi();
                    return;
                }
                Zi(str);
            } else if (yh() != null && ((com.hbg.module.kline.presenter.a) yh()).h0() != null) {
                if (this.W0) {
                    this.B.setText(m.T(m.L(FutureUnitUtil.c(str, this.V0, ((com.hbg.module.kline.presenter.a) yh()).j0().getContractFace(), TradeType.valueOf(this.S0), true), 1), 1) + ((com.hbg.module.kline.presenter.a) yh()).h0());
                    return;
                }
                this.B.setText(m.c(m.L(FutureUnitUtil.c(str, this.V0, ((com.hbg.module.kline.presenter.a) yh()).j0().getContractFace(), TradeType.valueOf(this.S0), true), 1), "--") + ((com.hbg.module.kline.presenter.a) yh()).h0());
            }
        }
    }

    public boolean Pi(Intent intent) {
        return intent.getBooleanExtra("market_grid", false);
    }

    public String Ri(Intent intent) {
        return intent.getStringExtra("optionCode");
    }

    public String Si(Intent intent) {
        return intent.getStringExtra("symbolId");
    }

    public String Ti(Intent intent) {
        String stringExtra = intent.getStringExtra("market_trade_type");
        return TextUtils.isEmpty(stringExtra) ? TradeType.PRO.toString() : stringExtra;
    }

    public void Vi() {
    }

    public boolean ae() {
        return a1.v().p0(this.L0);
    }

    public void afterInit() {
        super.afterInit();
        if (td.i.a().b().n()) {
            TradeType valueOf = TradeType.valueOf(this.S0);
            boolean F2 = a7.e.F(valueOf);
            int i11 = c.f23845a[valueOf.ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3) {
                a7.e.K(valueOf).compose(RxJavaHelper.t(zh())).subscribe(new d(F2));
            }
        }
    }

    public void aj(boolean z11) {
    }

    public void cj(boolean z11) {
    }

    public void dj(double d11) {
        String str;
        if (d11 == 0.0d || m.h0(m.i(d11, this.Z0)) == 0.0d) {
            str = "--";
        } else {
            str = ((TradeType.isContract(this.S0) || TradeType.isSwap(this.S0) || TradeType.isContractIndex(this.S0)) ? "$" : "") + m.k(d11, this.Z0, true);
        }
        this.f23815o.setText(str);
    }

    public void e0(double d11) {
    }

    public void eb(IndexDetail indexDetail) {
        if (indexDetail != null) {
            this.f23827u.setText(m.k(indexDetail.getMaxVal(), this.Z0, true));
            this.f23821r.setText(m.k(indexDetail.getMinVal(), this.Z0, true));
            KlineInfo klineInfo = new KlineInfo();
            klineInfo.setOpen(indexDetail.getOpenVal());
            klineInfo.setClose(indexDetail.getValue());
            klineInfo.setHigh(indexDetail.getMaxVal());
            klineInfo.setLow(indexDetail.getMinVal());
            s3(this.L0, Period.day.value, klineInfo);
            ViewUtil.m(this.f23833x, false);
            fj(this.f23819q, ri(klineInfo.getOpen(), klineInfo.getClose()), klineInfo.getClose() - klineInfo.getOpen());
            int i11 = 0;
            int i12 = 0;
            for (IndexIngredient next : indexDetail.getSymbols()) {
                if (next.getRisePercent() > 0.0d) {
                    i11++;
                }
                if (next.getRisePercent() < 0.0d) {
                    i12++;
                }
            }
            this.f23837z.setText(getString(R$string.market_info_index_ingredients_rise_or_fall_num, String.valueOf(i11), String.valueOf(i12)));
            this.V0 = String.valueOf(indexDetail.getValue());
            Yi();
            dj(indexDetail.getValue());
            rj(indexDetail.getSymbols());
            BaseModuleConfig.a().z("huobiapp_market_datapanel_end", "huobiapp_market_datapanel_end", OptionsBridge.NETWORK_KEY, true);
            return;
        }
        sj();
    }

    public void fj(TextView textView, String str, double d11) {
        if (Double.compare(d11, 0.0d) > 0) {
            textView.setTextColor(getResources().getColor(R$color.color_rise));
        } else if (Double.compare(d11, 0.0d) < 0) {
            textView.setTextColor(getResources().getColor(R$color.color_down));
        } else {
            textView.setTextColor(getResources().getColor(R$color.color_flat));
        }
        textView.setText(m.c(str, "--"));
    }

    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = r4.f23824s1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void gi() {
        /*
            r4 = this;
            com.hbg.module.kline.view.KlineViewWrapper r0 = r4.Y0
            java.lang.String r0 = r0.getSlaveIndex1()
            java.lang.String r1 = "VOL"
            boolean r0 = r1.equals(r0)
            r2 = 1
            if (r0 == 0) goto L_0x001b
            java.util.LinkedHashSet<java.lang.String> r0 = r4.f23824s1
            if (r0 == 0) goto L_0x0019
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x001b
        L_0x0019:
            r0 = r2
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            java.util.LinkedHashSet<java.lang.String> r3 = r4.f23824s1
            if (r3 == 0) goto L_0x0035
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x002e
            java.util.LinkedHashSet<java.lang.String> r1 = r4.f23824s1
            int r1 = r1.size()
            int r1 = r1 - r2
            goto L_0x0034
        L_0x002e:
            java.util.LinkedHashSet<java.lang.String> r1 = r4.f23824s1
            int r1 = r1.size()
        L_0x0034:
            int r0 = r0 + r1
        L_0x0035:
            com.hbg.module.kline.view.KlineViewWrapper r1 = r4.Y0
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            com.huobi.view.seekbar.MultiColorSeekBar r2 = r4.f23838z0
            int r2 = r2.getProgress()
            float r2 = (float) r2
            int r2 = com.hbg.component.kline.utils.DimenUtils.a(r2)
            int r3 = com.hbg.component.kline.constants.KLineConstants.f67186d
            int r2 = r2 + r3
            int r3 = com.hbg.component.kline.constants.KLineConstants.f67187e
            int r0 = r0 * r3
            int r2 = r2 + r0
            r1.height = r2
            com.hbg.module.kline.view.KlineViewWrapper r0 = r4.Y0
            r0.setLayoutParams(r1)
            com.huobi.view.seekbar.MultiColorSeekBar r0 = r4.f23838z0
            int r0 = r0.getProgress()
            java.lang.String r1 = "user_config"
            java.lang.String r2 = "config_kline_height_20221026"
            com.hbg.lib.core.util.ConfigPreferences.k(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.kline.ui.AbstractKlineFragment.gi():void");
    }

    public void gj(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* renamed from: hi */
    public com.hbg.module.kline.presenter.a xh() {
        Bundle arguments = getArguments();
        return new com.hbg.module.kline.presenter.a(arguments.getString("symbleId"), arguments.getString("tradeType"));
    }

    public void ii(View view, View view2, View view3, Animator.AnimatorListener animatorListener) {
        if (view != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(240);
            animatorSet.setInterpolator(new FastOutLinearInInterpolator());
            if (view2 == this.D0) {
                animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(this.f23802j0, "rotation", new float[]{180.0f, 0.0f}), ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{0.0f, (float) (-this.f23787b1)})});
            } else if (view2 == this.B0) {
                animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{0.0f, (float) (-this.f23787b1)}), ObjectAnimator.ofFloat(this.A0, View.TRANSLATION_Y, new float[]{0.0f, (float) (-this.f23787b1)})});
            } else {
                animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{0.0f, (float) (-this.f23787b1)})});
            }
            animatorSet.addListener(new b(view, animatorListener));
            animatorSet.start();
        }
    }

    public void ij() {
        Li();
    }

    public void initViews() {
        this.f23787b1 = getResources().getDimensionPixelOffset(R$dimen.dimen_272);
        Intent intent = getActivity().getIntent();
        this.S0 = Ti(intent);
        this.L0 = Si(intent);
        this.N0 = Oi(intent);
        this.Q0 = Ni(intent);
        this.R0 = Ri(intent);
        this.M0 = ti(intent);
        li(intent);
        this.T0 = Pi(intent);
        this.Z0 = Qi();
        this.f23785a1 = Ui();
        if (ae()) {
            this.P0 = this.L0 + "nav";
        }
        if (!ae()) {
            q5.a.g().q(this.L0);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", this.L0);
        hashMap.put("markets_kline_class", pi());
        BaseModuleConfig.a().w("App_markets_kline_view", hashMap);
    }

    public void ji(View view, View view2, View view3, Animator.AnimatorListener animatorListener) {
        if (view != null) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = this.F0.getMeasuredHeight() + this.f23793e1.getMeasuredHeight() + this.f23804k0.getTop();
            view.setLayoutParams(layoutParams);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(270);
            animatorSet.setInterpolator(new LinearOutSlowInInterpolator());
            if (view2 == this.D0) {
                animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(this.f23802j0, "rotation", new float[]{0.0f, 180.0f}), ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{(float) (-this.f23787b1), 0.0f})});
            } else if (view2 == this.B0) {
                animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{(float) (-this.f23787b1), 0.0f}), ObjectAnimator.ofFloat(this.A0, View.TRANSLATION_Y, new float[]{(float) (-this.f23787b1), 0.0f})});
            } else {
                animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{(float) (-this.f23787b1), 0.0f})});
            }
            animatorSet.addListener(new a(animatorListener, view));
            animatorSet.start();
        }
    }

    public void jj(int i11) {
        if (this.G0 != i11 && i11 >= 0) {
            this.G0 = i11;
            if (i11 == R$id.time_sharing_radio_layout) {
                Period period = Period.timeline;
                ConfigPreferences.m("user_config", "config_period", period.key);
                this.K0 = period;
            } else if (i11 == R$id.float_time_radio_layout || i11 == R$id.float_time_radio_layout_etp) {
                Period period2 = Period.timeline;
                ConfigPreferences.m("user_config", "config_period", period2.key);
                this.K0 = period2;
            } else if (i11 == R$id.one_min_radio_layout || i11 == R$id.one_min_radio_layout_etp) {
                Period period3 = Period.min1;
                ConfigPreferences.m("user_config", "config_period", period3.key);
                this.K0 = period3;
            } else if (i11 == R$id.five_min_radio_layout || i11 == R$id.five_min_radio_layout_etp) {
                Period period4 = Period.min5;
                ConfigPreferences.m("user_config", "config_period", period4.key);
                this.K0 = period4;
            } else if (i11 == R$id.fifteen_min_radio_layout) {
                Period period5 = Period.min15;
                ConfigPreferences.m("user_config", "config_period", period5.key);
                this.K0 = period5;
            } else if (i11 == R$id.thirty_min_radio_layout || i11 == R$id.thirty_min_radio_layout_etp) {
                Period period6 = Period.min30;
                ConfigPreferences.m("user_config", "config_period", period6.key);
                this.K0 = period6;
            } else if (i11 == R$id.sixty_min_radio_layout) {
                Period period7 = Period.min60;
                ConfigPreferences.m("user_config", "config_period", period7.key);
                this.K0 = period7;
            } else if (i11 == R$id.four_hour_radio_layout) {
                Period period8 = Period.hour4;
                ConfigPreferences.m("user_config", "config_period", period8.key);
                this.K0 = period8;
            } else if (i11 == R$id.one_day_radio_layout) {
                Period period9 = Period.day;
                ConfigPreferences.m("user_config", "config_period", period9.key);
                this.K0 = period9;
            } else if (i11 == R$id.one_week_radio_layout || i11 == R$id.one_week_radio_layout_etp) {
                Period period10 = Period.week;
                ConfigPreferences.m("user_config", "config_period", period10.key);
                this.K0 = period10;
            } else if (i11 == R$id.one_month_radio_layout || i11 == R$id.one_month_radio_layout_etp) {
                Period period11 = Period.month;
                ConfigPreferences.m("user_config", "config_period", period11.key);
                this.K0 = period11;
            }
            this.Y0.K(this.K0, false);
            this.H0 = i11;
            ((com.hbg.module.kline.presenter.a) yh()).v0(this.K0);
            if (i11 == R$id.market_info_more_layout) {
                BaseModuleConfig.a().w("App_markets_kline_timescm_click", (HashMap) null);
            } else {
                BaseModuleConfig.a().w("App_markets_kline_timesc_click", (HashMap) null);
            }
            if (!this.W0) {
                boolean z11 = false;
                for (Period period12 : this.f23806l) {
                    if (period12 == this.K0) {
                        z11 = true;
                    }
                    if (i11 == R$id.float_time_radio_layout || i11 == R$id.float_time_radio_layout_etp) {
                        z11 = false;
                    }
                    if (z11) {
                        break;
                    }
                }
                if (z11) {
                    this.f23796g0.setTextColor(oi());
                    this.f23796g0.setText(R$string.market_info_more);
                    BaseModuleConfig.a().w("App_markets_kline_depthmap_click", (HashMap) null);
                    return;
                }
                this.f23796g0.setTextColor(si());
                Period period13 = this.K0;
                if (period13 == Period.timeline) {
                    this.f23796g0.setText(R$string.n_kline_timeline);
                } else if (period13 == Period.min1) {
                    this.f23796g0.setText(R$string.n_kline_1min);
                } else if (period13 == Period.min5) {
                    this.f23796g0.setText(R$string.n_kline_5min);
                } else if (period13 == Period.min30) {
                    this.f23796g0.setText(R$string.n_kline_30min);
                } else if (period13 == Period.week) {
                    this.f23796g0.setText(R$string.n_kline_1week);
                } else if (period13 == Period.month) {
                    this.f23796g0.setText(R$string.n_kline_1month);
                } else {
                    this.f23796g0.setText(R$string.market_info_more);
                }
            }
        }
    }

    public void k8(String str, String str2, KlineInfo klineInfo) {
    }

    public void li(Intent intent) {
        SwapCurrencyInfo c11;
        ContractCurrencyInfo b11;
        if (TradeType.isContract(this.S0)) {
            if (((ContractCurrencyInfo) intent.getSerializableExtra("contract_currency_info")) == null && (b11 = ContractCurrencyUtils.b(this.L0)) != null) {
                intent.putExtra("contract_currency_info", b11);
                if (TextUtils.isEmpty(this.Q0)) {
                    String contractCode = b11.getContractCode();
                    this.Q0 = contractCode;
                    intent.putExtra("contractCode", contractCode);
                }
                if (TextUtils.isEmpty(this.N0)) {
                    String symbol = b11.getSymbol();
                    this.N0 = symbol;
                    intent.putExtra("contract_currency_symble", symbol);
                }
            }
        } else if (TradeType.isSwap(this.S0)) {
            if (((SwapCurrencyInfo) intent.getSerializableExtra("contract_currency_info")) == null && (c11 = SwapCurrencyInfoController.k().c(this.L0)) != null) {
                intent.putExtra("contract_currency_info", c11);
                if (TextUtils.isEmpty(this.Q0)) {
                    String contractCode2 = c11.getContractCode();
                    this.Q0 = contractCode2;
                    intent.putExtra("contractCode", contractCode2);
                }
                if (TextUtils.isEmpty(this.N0)) {
                    String symbol2 = c11.getSymbol();
                    this.N0 = symbol2;
                    intent.putExtra("contract_currency_symble", symbol2);
                }
            }
        } else if (TradeType.isLinearSwap(this.S0)) {
            FutureContractInfo futureContractInfo = (FutureContractInfo) intent.getSerializableExtra("contract_currency_info");
            if (futureContractInfo != null) {
                this.O0 = futureContractInfo.getContractShortType();
                return;
            }
            LinearSwapContractInfo n11 = LinearSwapCurrencyInfoController.l().n(this.L0);
            if (n11 != null) {
                FutureContractInfo futureContractInfo2 = new FutureContractInfo();
                futureContractInfo2.convert(futureContractInfo2, n11);
                intent.putExtra("contract_currency_info", futureContractInfo2);
                this.O0 = futureContractInfo2.getContractShortType();
                if (TextUtils.isEmpty(this.Q0)) {
                    String contractCode3 = futureContractInfo2.getContractCode();
                    this.Q0 = contractCode3;
                    intent.putExtra("contractCode", contractCode3);
                }
                if (TextUtils.isEmpty(this.N0)) {
                    String symbol3 = futureContractInfo2.getSymbol();
                    this.N0 = symbol3;
                    intent.putExtra("contract_currency_symble", symbol3);
                    return;
                }
                return;
            }
            this.O0 = this.L0;
        }
    }

    public void lj(LinkedHashSet<String> linkedHashSet) {
        this.f23824s1 = linkedHashSet;
        ConfigPreferences.m("user_config", "config_target_under_20221026", CandleStickRender.SlaveChartIndex.c(linkedHashSet));
        String str = "VOL";
        if (!ae() ? TradeType.isIndex(this.S0) || TradeType.isContractIndex(this.S0) || TradeType.isLinearSwapIndex(this.S0) : !KLineHelper.d(this.L0, true)) {
            str = "";
        }
        this.Y0.setSlaveIndex1(str);
        this.Y0.setSlaveIndex2(this.f23824s1);
        int i11 = 8;
        this.f23826t0.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        View view = this.f23828u0;
        if (TextUtils.isEmpty(str)) {
            i11 = 0;
        }
        view.setVisibility(i11);
        gi();
    }

    public void mg() {
        ((com.hbg.module.kline.presenter.a) yh()).r0(true);
    }

    public int mi(int i11) {
        if (getActivity() == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.data;
    }

    public boolean mj() {
        return !TradeType.isOption(this.S0) && !TradeType.isIndex(this.S0) && !TradeType.isContractIndex(this.S0) && !TradeType.isLinearSwapIndex(this.S0);
    }

    public int ni(int i11) {
        if (getActivity() == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.resourceId;
    }

    public void nj(View view) {
        TextView textView;
        this.D.setTextColor(oi());
        this.F.setTextColor(oi());
        this.G.setTextColor(oi());
        this.H.setTextColor(oi());
        this.I.setTextColor(oi());
        this.J.setTextColor(oi());
        this.K.setTextColor(oi());
        this.L.setTextColor(oi());
        this.M.setTextColor(oi());
        this.N.setTextColor(oi());
        this.P.setSelected(false);
        this.Q.setSelected(false);
        this.R.setSelected(false);
        this.S.setSelected(false);
        this.T.setSelected(false);
        this.U.setSelected(false);
        this.V.setSelected(false);
        this.W.setSelected(false);
        this.X.setSelected(false);
        this.Y.setSelected(false);
        this.Z.setSelected(false);
        view.setSelected(true);
        cj(true);
        aj(false);
        if (ae() && (textView = this.f23790d0) != null) {
            textView.setTextColor(si());
        }
        if (TradeType.isIndex(this.S0)) {
            ViewUtil.m(this.P, true);
            ViewUtil.m(this.Q, false);
        } else if (TradeType.isContractIndex(this.S0) || TradeType.isLinearSwapIndex(this.S0)) {
            ViewUtil.m(this.P, true);
            ViewUtil.m(this.Q, false);
        } else {
            if (this.W0) {
                ViewUtil.m(this.P, true);
            } else {
                ViewUtil.m(this.P, false);
            }
            ViewUtil.m(this.Q, true);
        }
        int id2 = view.getId();
        if (id2 == R$id.time_sharing_radio_layout) {
            this.D.setTextColor(si());
            uj(false);
            if (this.W0 || TradeType.isIndex(this.S0) || TradeType.isContractIndex(this.S0) || TradeType.isLinearSwapIndex(this.S0)) {
                ki(this.D);
            } else {
                ki(this.f23798h0);
            }
        } else if (id2 == R$id.one_min_radio_layout || id2 == R$id.one_min_radio_layout_etp) {
            if (this.W0) {
                this.F.setTextColor(si());
                ki(this.F);
            } else {
                gj(this.f23796g0, getResources().getString(R$string.n_kline_1min));
                uj(false);
                ki(this.f23798h0);
            }
        } else if (id2 == R$id.float_time_radio_layout || id2 == R$id.float_time_radio_layout_etp) {
            if (this.W0) {
                this.E.setTextColor(si());
                ki(this.E);
            } else {
                gj(this.f23796g0, getResources().getString(R$string.n_kline_timeline));
                uj(false);
                ki(this.f23798h0);
            }
        } else if (id2 == R$id.five_min_radio_layout || id2 == R$id.five_min_radio_layout_etp) {
            if (this.W0) {
                this.G.setTextColor(si());
                ki(this.G);
            } else {
                gj(this.f23796g0, getResources().getString(R$string.n_kline_5min));
                uj(false);
                ki(this.f23798h0);
            }
        } else if (id2 == R$id.fifteen_min_radio_layout) {
            this.H.setTextColor(si());
            uj(false);
            ki(this.H);
        } else if (id2 == R$id.thirty_min_radio_layout || id2 == R$id.thirty_min_radio_layout_etp) {
            if (this.W0) {
                this.I.setTextColor(si());
                ki(this.I);
            } else {
                gj(this.f23796g0, getResources().getString(R$string.n_kline_30min));
                uj(false);
                ki(this.f23798h0);
            }
        } else if (id2 == R$id.sixty_min_radio_layout) {
            this.J.setTextColor(si());
            uj(false);
            ki(this.J);
        } else if (id2 == R$id.four_hour_radio_layout) {
            this.K.setTextColor(si());
            uj(false);
            ki(this.K);
        } else if (id2 == R$id.one_day_radio_layout) {
            this.L.setTextColor(si());
            uj(false);
            ki(this.L);
        } else if (id2 == R$id.one_week_radio_layout || id2 == R$id.one_week_radio_layout_etp) {
            this.M.setTextColor(si());
            uj(false);
            if (this.W0 || !ae()) {
                ki(this.M);
            } else {
                ki(this.f23798h0);
            }
        } else if (id2 == R$id.one_month_radio_layout || id2 == R$id.one_month_radio_layout_etp) {
            if (this.W0) {
                this.N.setTextColor(si());
                uj(false);
                ki(this.N);
            } else {
                gj(this.f23796g0, getResources().getString(R$string.n_kline_1month));
                uj(false);
                ki(this.f23798h0);
            }
        }
        if (view.getId() != R$id.market_info_more_layout && view.getId() != R$id.target_checkbox_layout) {
            jj(view.getId());
            oj();
            BaseModuleConfig.a().w("App_markets_kline_indexset_click", (HashMap) null);
        }
    }

    public int oi() {
        if (getActivity() == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R$attr.kline_three_level_text_color, typedValue, true);
        return typedValue.data;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        this.Y0.C();
        this.J0 = false;
    }

    public void onResume() {
        this.J0 = true;
        this.Y0.D();
        bj();
        this.G0 = -1;
        Mi();
        Li();
        super.onResume();
        Vi();
    }

    public void p3(String str) {
    }

    public String pi() {
        if (!TextUtils.isEmpty(this.S0)) {
            i6.d.e("tab", "tradeType == " + this.S0);
            TradeType tradeType = TradeType.CONTRACT;
            if (tradeType.toString().equalsIgnoreCase(this.S0)) {
                return tradeType.toString().toLowerCase();
            }
            if (TradeType.SWAP.toString().equalsIgnoreCase(this.S0)) {
                return tradeType.toString().toLowerCase();
            }
            if (TradeType.LINEAR_SWAP.toString().equalsIgnoreCase(this.S0)) {
                return tradeType.toString().toLowerCase();
            }
            if (TradeType.MARGIN.toString().equalsIgnoreCase(this.S0) || TradeType.SUPERMARGIN.toString().equalsIgnoreCase(this.S0)) {
                return HiAnalyticsConstant.HaKey.BI_KEY_TRANSTYPE;
            }
            if (this.T0) {
                return TradeType.GRID.toString();
            }
            if (ae()) {
                return "etp";
            }
        }
        return RankScreenBean.SCREEN_VALUE_SPOT;
    }

    public void pj(boolean z11) {
        qj(z11, (Animator.AnimatorListener) null);
    }

    public String qi() {
        return yi() ? "1005015" : "1005005";
    }

    public void qj(boolean z11, Animator.AnimatorListener animatorListener) {
        if (this.W0 || this.f23808l1) {
            return;
        }
        if (z11) {
            if (!this.f23816o1) {
                this.f23816o1 = true;
                this.f23792e0.setImageResource(KLineHelper.f() ? R$drawable.kline_index_setting_icon_select : R$drawable.kline_index_setting_icon_select_night);
                if (this.f23818p1) {
                    vj(false, new g());
                } else {
                    ji(this.f23786b0, this.B0, this.C0, new h());
                }
            }
        } else if (this.f23816o1) {
            ii(this.f23786b0, this.B0, this.C0, new i(animatorListener));
        }
    }

    public String ri(double d11, double d12) {
        if (Double.compare(d11, 0.0d) == 1) {
            double d13 = d12 - d11;
            String str = Double.compare(d13, 0.0d) > 0 ? "+" : "";
            return str + m.i((d13 / d11) * 100.0d, PrecisionUtil.v(this.L0)) + "%";
        }
        return m.i(0.0d, PrecisionUtil.v(this.L0)) + "%";
    }

    public void rj(List<IndexIngredient> list) {
    }

    public void s3(String str, String str2, KlineInfo klineInfo) {
        if (getActivity() != null && !getActivity().isFinishing() && Period.day.value.equals(str2) && this.L0.equals(str)) {
            double close = klineInfo.getClose() - klineInfo.getOpen();
            if (Double.compare(close, 0.0d) > 0) {
                this.f23833x.setTextColor(getResources().getColor(w.h()));
                this.f23815o.setTextColor(getResources().getColor(w.h()));
                this.f23835y.setTextColor(getResources().getColor(w.h()));
            } else if (Double.compare(close, 0.0d) < 0) {
                this.f23833x.setTextColor(getResources().getColor(w.d()));
                this.f23815o.setTextColor(getResources().getColor(w.d()));
                this.f23835y.setTextColor(getResources().getColor(w.d()));
            } else {
                TextView textView = this.f23833x;
                Resources resources = getResources();
                int i11 = R$color.color_flat;
                textView.setTextColor(resources.getColor(i11));
                this.f23815o.setTextColor(getResources().getColor(i11));
                this.f23835y.setTextColor(getResources().getColor(i11));
            }
            this.f23833x.setText(ri(klineInfo.getOpen(), klineInfo.getClose()));
            this.f23835y.setText(ri(klineInfo.getOpen(), klineInfo.getClose()));
            if (!TradeType.isPro(this.S0)) {
                this.f23827u.setText(m.k(klineInfo.getHigh(), this.Z0, true));
                this.f23821r.setText(m.k(klineInfo.getLow(), this.Z0, true));
            }
            double close2 = klineInfo.getClose();
            ej(klineInfo.getClose());
            this.I0 = close2;
            BaseModuleConfig.a().z("huobiapp_market_datapanel_end", "huobiapp_market_datapanel_end", OptionsBridge.NETWORK_KEY, true);
        }
    }

    public int si() {
        if (getActivity() == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R$attr.kline_index_setting_text_color, typedValue, true);
        return typedValue.data;
    }

    public void sj() {
    }

    public String ti(Intent intent) {
        if (TradeType.isContract(this.S0) || TradeType.isSwap(this.S0)) {
            return intent.getStringExtra("contractName");
        }
        if (TradeType.isContractIndex(this.S0)) {
            IndexCurrencyInfo indexCurrencyInfo = (IndexCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
            String str = indexCurrencyInfo.getSymbol() + indexCurrencyInfo.getQuoteCurrency();
            return String.format(Locale.US, getString(R$string.market_info_tab_contract_index_intro), new Object[]{str});
        } else if (TradeType.isOption(this.S0)) {
            return ((FutureContractInfo) intent.getSerializableExtra("contract_currency_info")).getSymbol();
        } else {
            if (TradeType.isLinearSwap(this.S0)) {
                return intent.getStringExtra("contractName");
            }
            if (!TradeType.isLinearSwapIndex(this.S0)) {
                return a1.v().X(this.L0, TradeType.valueOf(this.S0));
            }
            IndexCurrencyInfo indexCurrencyInfo2 = (IndexCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
            String p11 = a7.e.p(getActivity(), indexCurrencyInfo2.getSymbol(), indexCurrencyInfo2.getQuoteCurrency());
            return String.format(Locale.US, getString(R$string.market_info_tab_contract_index_intro), new Object[]{p11});
        }
    }

    public void u(KlineInfo klineInfo) {
        double close = klineInfo.getClose();
        double d11 = this.I0;
        if (d11 == 0.0d) {
            ej(close);
        } else if (Double.compare(close, d11) > 0) {
            ej(close);
        } else if (close < this.I0) {
            ej(close);
        }
        this.I0 = close;
        if (TradeType.isOption(this.S0)) {
            if (a7.e.E(TradeType.valueOf(this.S0))) {
                this.f23819q.setText(m.c(m.L(String.valueOf(klineInfo.getAmount()), PrecisionUtil.u(this.L0)), "--"));
                this.f23819q.append(((com.hbg.module.kline.presenter.a) yh()).h0());
                return;
            }
            this.f23819q.setText(getString(R$string.contract_24h_num_value, m.k(klineInfo.getVol(), PrecisionUtil.t(this.L0), true)));
        } else if (TradeType.isLinearSwap(this.S0)) {
            if (a7.e.F(TradeType.valueOf(this.S0))) {
                this.f23819q.setText(m.T(String.valueOf(klineInfo.getAmount()), PrecisionUtil.u(this.L0)));
            } else {
                this.f23819q.setText(m.T(String.valueOf(klineInfo.getVol()), PrecisionUtil.t(this.L0)));
            }
            Xi(klineInfo);
        } else if (TradeType.isContract(this.S0)) {
            if (a7.e.E(TradeType.CONTRACT)) {
                this.f23819q.setText(m.T(String.valueOf(klineInfo.getAmount()), PrecisionUtil.u(this.L0)));
            } else {
                this.f23819q.setText(m.T(String.valueOf(klineInfo.getVol()), PrecisionUtil.t(this.L0)));
            }
            Xi(klineInfo);
        } else if (TradeType.isSwap(this.S0)) {
            if (a7.e.E(TradeType.SWAP)) {
                this.f23819q.setText(m.T(String.valueOf(klineInfo.getAmount()), PrecisionUtil.u(this.L0)));
            } else {
                this.f23819q.setText(m.T(String.valueOf(klineInfo.getVol()), PrecisionUtil.t(this.L0)));
            }
            Xi(klineInfo);
        }
    }

    /* renamed from: ui */
    public AbstractKlinePresenter.b zh() {
        return this;
    }

    public void uj(boolean z11) {
        vj(z11, (Animator.AnimatorListener) null);
    }

    public void v9(OptionMarketIndexInfo optionMarketIndexInfo) {
    }

    public void vj(boolean z11, Animator.AnimatorListener animatorListener) {
        if (getActivity() == null || this.W0 || this.f23814n1) {
            return;
        }
        if (z11) {
            if (!this.f23818p1) {
                this.f23818p1 = true;
                oj();
                if (this.f23816o1) {
                    qj(false, new j());
                } else {
                    ji(this.f23794f0, this.D0, this.E0, new k());
                }
            }
        } else if (this.f23818p1) {
            ii(this.f23794f0, this.D0, this.E0, new l(animatorListener));
        }
    }

    public void wi() {
        int i11;
        this.C = this.f67460i.b(R$id.kline_tab_indicator);
        this.F0 = this.f67460i.b(R$id.trade_time_group_layout);
        this.f23807l0 = (TextView) this.f67460i.b(R$id.trade_main_target_MA);
        this.f23810m0 = (TextView) this.f67460i.b(R$id.trade_main_target_EMA);
        this.f23813n0 = (TextView) this.f67460i.b(R$id.trade_main_target_BOLL);
        this.f23826t0 = (TextView) this.f67460i.b(R$id.trade_under_target_VOL);
        this.f23828u0 = this.f67460i.b(R$id.trade_under_target_space);
        this.f23830v0 = (TextView) this.f67460i.b(R$id.trade_under_target_MACD);
        this.f23832w0 = (TextView) this.f67460i.b(R$id.trade_under_target_KDJ);
        this.f23834x0 = (TextView) this.f67460i.b(R$id.trade_under_target_RSI);
        this.f23836y0 = (TextView) this.f67460i.b(R$id.trade_under_target_WR);
        this.f23812n = (ImageView) this.f67460i.b(R$id.image_view_kline_title_icon);
        this.A0 = this.f67460i.b(R$id.height_seekbar_ll);
        this.f23838z0 = (MultiColorSeekBar) this.f67460i.b(R$id.height_seekbar);
        this.B0 = this.f67460i.b(R$id.id_kline_index_setting_view);
        this.C0 = this.f67460i.b(R$id.id_kline_index_setting_bg_view);
        this.D0 = this.f67460i.b(R$id.id_kline_period_more_view);
        this.E0 = this.f67460i.b(R$id.id_kline_period_more_bg_view);
        this.f23786b0 = this.f67460i.b(R$id.trade_target_left_layout);
        this.f23788c0 = this.f67460i.b(R$id.index_setting);
        this.f23804k0 = (AppBarLayout) this.f67460i.b(R$id.id_abl_kline_appbar_layout);
        this.D = (TextView) this.f67460i.b(R$id.time_sharing_radio);
        this.F = (TextView) this.f67460i.b(R$id.one_min_radio);
        this.E = (TextView) this.f67460i.b(R$id.float_time_radio);
        this.G = (TextView) this.f67460i.b(R$id.five_min_radio);
        this.H = (TextView) this.f67460i.b(R$id.fifteen_min_radio);
        this.I = (TextView) this.f67460i.b(R$id.thirty_min_radio);
        this.J = (TextView) this.f67460i.b(R$id.sixty_min_radio);
        this.K = (TextView) this.f67460i.b(R$id.four_hour_radio);
        this.L = (TextView) this.f67460i.b(R$id.one_day_radio);
        this.M = (TextView) this.f67460i.b(R$id.one_week_radio);
        this.N = (TextView) this.f67460i.b(R$id.one_month_radio);
        this.O = (RelativeLayout) this.f67460i.b(R$id.target_checkbox_layout);
        this.P = (RelativeLayout) this.f67460i.b(R$id.time_sharing_radio_layout);
        this.R = (RelativeLayout) this.f67460i.b(R$id.one_min_radio_layout);
        this.Q = (RelativeLayout) this.f67460i.b(R$id.float_time_radio_layout);
        this.S = (RelativeLayout) this.f67460i.b(R$id.five_min_radio_layout);
        this.T = (RelativeLayout) this.f67460i.b(R$id.fifteen_min_radio_layout);
        this.U = (RelativeLayout) this.f67460i.b(R$id.thirty_min_radio_layout);
        this.V = (RelativeLayout) this.f67460i.b(R$id.sixty_min_radio_layout);
        this.W = (RelativeLayout) this.f67460i.b(R$id.four_hour_radio_layout);
        this.X = (RelativeLayout) this.f67460i.b(R$id.one_day_radio_layout);
        this.Y = (RelativeLayout) this.f67460i.b(R$id.one_week_radio_layout);
        this.Z = (RelativeLayout) this.f67460i.b(R$id.one_month_radio_layout);
        this.f23784a0 = (RelativeLayout) this.f67460i.b(R$id.market_info_more_layout);
        this.f23796g0 = (TextView) this.f67460i.b(R$id.market_info_more);
        this.f23798h0 = this.f67460i.b(R$id.ll_market_info_more);
        this.f23800i0 = (ImageView) this.f67460i.b(R$id.market_info_more_indicator);
        this.f23802j0 = (ImageView) this.f67460i.b(R$id.market_info_more_indicator_top);
        this.f23794f0 = this.f67460i.b(R$id.market_info_more_detail_layout);
        this.f23792e0 = (ImageView) this.f67460i.b(R$id.index_setting_image);
        this.f23815o = (TextView) this.f67460i.b(R$id.trade_price_text);
        this.f23791d1 = this.f67460i.b(R$id.layout_option_info);
        this.f23793e1 = this.f67460i.b(R$id.market_top);
        ViewUtil.m(this.f67460i.b(R$id.linear_layout_kline_info_box), !mj());
        ViewUtil.m(this.f67460i.b(R$id.linear_layout_kline_info_box2), mj());
        if (this.W0 || !mj()) {
            this.f23827u = (TextView) this.f67460i.b(R$id.high_price_text);
            this.f23821r = (TextView) this.f67460i.b(R$id.low_price_text);
            this.f23817p = (TextView) this.f67460i.b(R$id.volume_sum_label);
            this.f23819q = (TextView) this.f67460i.b(R$id.volume_sum_text);
            this.f23829v = (TextView) this.f67460i.b(R$id.high_price_label);
            this.f23831w = (TextView) this.f67460i.b(R$id.low_price_label);
        } else {
            this.f23827u = (TextView) this.f67460i.b(R$id.high_price_text2);
            this.f23821r = (TextView) this.f67460i.b(R$id.low_price_text2);
            this.f23817p = (TextView) this.f67460i.b(R$id.volume_sum_label2);
            this.f23819q = (TextView) this.f67460i.b(R$id.volume_sum_text2);
            this.f23823s = (TextView) this.f67460i.b(R$id.volume_sum_amount_label2);
            this.f23825t = (TextView) this.f67460i.b(R$id.volume_sum_amount_text2);
            this.f23829v = (TextView) this.f67460i.b(R$id.high_price_label2);
            this.f23831w = (TextView) this.f67460i.b(R$id.low_price_label2);
        }
        this.f23833x = (TextView) this.f67460i.b(R$id.the_rise_and_fall_text);
        this.f23837z = (TextView) this.f67460i.b(R$id.market_info_cny);
        this.f23795f1 = this.f67460i.b(R$id.switch_kline_btn);
        if (TradeType.isOption(this.S0)) {
            FutureContractInfo futureContractInfo = (FutureContractInfo) getActivity().getIntent().getSerializableExtra("contract_currency_info");
            getActivity().getTheme().resolveAttribute(R$attr.kline_primary_text_color, new TypedValue(), true);
        }
        if (TradeType.isIndex(this.S0)) {
            this.f23817p.setText(R$string.market_info_rise_pct);
            ViewUtil.m(this.f23812n, false);
        } else if (TradeType.isContractIndex(this.S0) || TradeType.isLinearSwapIndex(this.S0)) {
            ViewUtil.m(this.f23812n, false);
            ViewUtil.m(this.f23817p, false);
        } else {
            ViewUtil.m(this.f23812n, true);
        }
        TextView textView = this.A;
        if (textView != null) {
            textView.append(" ");
        }
        if (mj()) {
            int i12 = c.f23845a[TradeType.parse(this.S0).ordinal()];
            if (i12 == 1) {
                ContractCurrencyInfo contractCurrencyInfo = (ContractCurrencyInfo) getActivity().getIntent().getSerializableExtra("contract_currency_info");
                this.f23799h1 = "USD";
                if (!(contractCurrencyInfo == null || contractCurrencyInfo.getSymbol() == null)) {
                    this.f23797g1 = contractCurrencyInfo.getSymbol().toUpperCase();
                }
            } else if (i12 == 2) {
                SwapCurrencyInfo swapCurrencyInfo = (SwapCurrencyInfo) getActivity().getIntent().getSerializableExtra("contract_currency_info");
                this.f23799h1 = "USD";
                if (!(swapCurrencyInfo == null || swapCurrencyInfo.getSymbol() == null)) {
                    this.f23797g1 = swapCurrencyInfo.getSymbol().toUpperCase();
                }
            } else if (i12 != 3) {
                this.f23797g1 = StringUtils.i(a1.v().p(this.L0));
                this.f23799h1 = StringUtils.i(a1.v().F(this.L0));
            } else {
                FutureContractInfo futureContractInfo2 = (FutureContractInfo) getActivity().getIntent().getSerializableExtra("contract_currency_info");
                if (futureContractInfo2 != null) {
                    this.f23799h1 = futureContractInfo2.getQuoteCurrency().toUpperCase();
                    this.f23797g1 = futureContractInfo2.getSymbol().toUpperCase();
                } else if (!TextUtils.isEmpty(this.L0) && this.L0.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    String[] split = this.L0.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    if (split == null) {
                        i11 = 0;
                    } else {
                        i11 = split.length;
                    }
                    if (i11 >= 1) {
                        this.f23797g1 = split[0];
                    }
                    if (i11 >= 2) {
                        this.f23799h1 = split[1];
                    }
                }
            }
            if (this.f23817p != null) {
                if (!TradeType.isContract(this.S0) && !TradeType.isLinearSwap(this.S0) && !TradeType.isSwap(this.S0)) {
                    this.f23817p.setText(String.format(getString(R$string.n_kline_24H_amount), new Object[]{this.f23797g1}));
                } else if (a7.e.F(TradeType.valueOf(this.S0)) || a7.e.G(TradeType.valueOf(this.S0))) {
                    this.f23817p.setText(String.format(getString(R$string.n_kline_24H_amount), new Object[]{this.f23797g1}));
                } else {
                    this.f23817p.setText(String.format(getString(R$string.n_kline_24H_amount), new Object[]{getString(R$string.contract_trade_unit_sheet)}));
                }
            }
            if (this.f23823s != null) {
                this.f23823s.setText(String.format(getString(R$string.n_kline_24H_volume), new Object[]{this.f23799h1}));
            }
            TextView textView2 = this.f23829v;
            if (textView2 != null) {
                textView2.setText(getString(R$string.n_kline_24H_highest));
            }
            TextView textView3 = this.f23831w;
            if (textView3 != null) {
                textView3.setText(getString(R$string.n_kline_24H_lowest));
            }
        }
        this.f23838z0.getConfigBuilder().min(150.0f).max(360.0f).setDanger(360.1f).sectionCount(2).colorConfig(getContext(), !KLineHelper.f(), true).outerCircleColor(mi(R$attr.kline_content_background_color)).trackColor(mi(R$attr.base_color_primary_separator)).build();
        int g11 = ConfigPreferences.g("user_config", "config_kline_height_20221026", 255);
        this.f23801i1 = g11;
        this.f23838z0.setProgress((float) g11);
        this.f23838z0.setOnProgressChangedListener(new e());
    }

    public void xi(KlineViewWrapper klineViewWrapper, boolean z11) {
        this.Y0 = klineViewWrapper;
        klineViewWrapper.setTradeType(this.S0);
        this.Y0.setSymbolId(this.L0);
        this.Y0.setPricePrecision(this.Z0);
        this.Y0.setVolPrecision(this.f23785a1);
        bj();
        this.Y0.E();
        this.W0 = z11;
    }

    public boolean yi() {
        return TradeType.isContract(this.S0) || TradeType.isSwap(this.S0) || TradeType.isOption(this.S0) || TradeType.isLinearSwap(this.S0);
    }

    public boolean zi() {
        return TradeType.isContractIndex(this.S0) || TradeType.isLinearSwapIndex(this.S0) || TradeType.isIndex(this.S0);
    }
}
