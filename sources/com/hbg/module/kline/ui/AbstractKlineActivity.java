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
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.hbg.component.kline.constants.KLineConstants;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseActivity;
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
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$color;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.R$style;
import com.hbg.module.kline.bean.IndexDetail;
import com.hbg.module.kline.bean.IndexIngredient;
import com.hbg.module.kline.index.IndexSettingActivity;
import com.hbg.module.kline.presenter.AbstractKlinePresenter;
import com.hbg.module.kline.view.KlineViewWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
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

public abstract class AbstractKlineActivity extends BaseActivity<AbstractKlinePresenter, AbstractKlinePresenter.b> implements AbstractKlinePresenter.b, vd.c {
    public TextView A;
    public String A0;
    public TextView B;
    public String B0;
    public TextView C;
    public String C0;
    public TextView D;
    public String D0;
    public RelativeLayout E;
    public boolean E0;
    public RelativeLayout F;
    public String F0 = null;
    public RelativeLayout G;
    public String G0 = null;
    public RelativeLayout H;
    public boolean H0 = false;
    public RelativeLayout I;
    public KlineInfo I0;
    public RelativeLayout J;
    public KlineViewWrapper J0;
    public RelativeLayout K;
    public int K0;
    public RelativeLayout L;
    public int L0;
    public RelativeLayout M;
    public int M0;
    public RelativeLayout N;
    public boolean N0;
    public RelativeLayout O;
    public String O0 = "";
    public RelativeLayout P;
    public String P0 = "";
    public RelativeLayout Q;
    public boolean Q0;
    public View R;
    public boolean R0;
    public View S;
    public boolean S0;
    public TextView T;
    public boolean T0;
    public ImageView U;
    public int U0;
    public View V;
    public LinkedHashSet<String> V0;
    public TextView W;
    public View X;
    public ImageView Y;
    public TextView Z;

    /* renamed from: a0  reason: collision with root package name */
    public TextView f23717a0;

    /* renamed from: b  reason: collision with root package name */
    public Period[] f23718b;

    /* renamed from: b0  reason: collision with root package name */
    public TextView f23719b0;

    /* renamed from: c  reason: collision with root package name */
    public Period[] f23720c;

    /* renamed from: c0  reason: collision with root package name */
    public TextView f23721c0;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23722d;

    /* renamed from: d0  reason: collision with root package name */
    public TextView f23723d0;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f23724e;

    /* renamed from: e0  reason: collision with root package name */
    public TextView f23725e0;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23726f;

    /* renamed from: f0  reason: collision with root package name */
    public TextView f23727f0;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23728g;

    /* renamed from: g0  reason: collision with root package name */
    public TextView f23729g0;

    /* renamed from: h  reason: collision with root package name */
    public TextView f23730h;

    /* renamed from: h0  reason: collision with root package name */
    public View f23731h0;

    /* renamed from: i  reason: collision with root package name */
    public TextView f23732i;

    /* renamed from: i0  reason: collision with root package name */
    public View f23733i0;

    /* renamed from: j  reason: collision with root package name */
    public TextView f23734j;

    /* renamed from: j0  reason: collision with root package name */
    public View f23735j0;

    /* renamed from: k  reason: collision with root package name */
    public TextView f23736k;

    /* renamed from: k0  reason: collision with root package name */
    public View f23737k0;

    /* renamed from: l  reason: collision with root package name */
    public TextView f23738l;

    /* renamed from: l0  reason: collision with root package name */
    public View f23739l0;

    /* renamed from: m  reason: collision with root package name */
    public TextView f23740m;

    /* renamed from: m0  reason: collision with root package name */
    public int f23741m0 = 0;

    /* renamed from: n  reason: collision with root package name */
    public TextView f23742n;

    /* renamed from: n0  reason: collision with root package name */
    public int f23743n0 = 0;

    /* renamed from: o  reason: collision with root package name */
    public TextView f23744o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f23745p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f23746q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f23747r;

    /* renamed from: s  reason: collision with root package name */
    public View f23748s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f23749t;

    /* renamed from: t0  reason: collision with root package name */
    public double f23750t0 = 0.0d;

    /* renamed from: u  reason: collision with root package name */
    public TextView f23751u;

    /* renamed from: u0  reason: collision with root package name */
    public boolean f23752u0 = false;

    /* renamed from: v  reason: collision with root package name */
    public TextView f23753v;

    /* renamed from: v0  reason: collision with root package name */
    public Period f23754v0;

    /* renamed from: w  reason: collision with root package name */
    public TextView f23755w;

    /* renamed from: w0  reason: collision with root package name */
    public String f23756w0;

    /* renamed from: x  reason: collision with root package name */
    public TextView f23757x;

    /* renamed from: x0  reason: collision with root package name */
    public String f23758x0;

    /* renamed from: y  reason: collision with root package name */
    public TextView f23759y;

    /* renamed from: y0  reason: collision with root package name */
    public String f23760y0;

    /* renamed from: z  reason: collision with root package name */
    public TextView f23761z;

    /* renamed from: z0  reason: collision with root package name */
    public String f23762z0;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f23763b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f23764c;

        public a(View view, Animator.AnimatorListener animatorListener) {
            this.f23763b = view;
            this.f23764c = animatorListener;
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            ViewUtil.m(this.f23763b, false);
            Animator.AnimatorListener animatorListener = this.f23764c;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f23764c;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23766a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f23767b;

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
                f23767b = r0
                r1 = 1
                com.hbg.lib.network.pro.core.util.Period r2 = com.hbg.lib.network.pro.core.util.Period.min1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f23767b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.network.pro.core.util.Period r3 = com.hbg.lib.network.pro.core.util.Period.min5     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f23767b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.network.pro.core.util.Period r4 = com.hbg.lib.network.pro.core.util.Period.min30     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f23767b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.network.pro.core.util.Period r4 = com.hbg.lib.network.pro.core.util.Period.month     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f23767b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.lib.network.pro.core.util.Period r4 = com.hbg.lib.network.pro.core.util.Period.timeline     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                com.hbg.lib.data.symbol.TradeType[] r3 = com.hbg.lib.data.symbol.TradeType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f23766a = r3
                com.hbg.lib.data.symbol.TradeType r4 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x004f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = f23766a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f23766a     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.kline.ui.AbstractKlineActivity.b.<clinit>():void");
        }
    }

    public class c extends BaseSubscriber<Integer> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f23768b;

        public c(boolean z11) {
            this.f23768b = z11;
        }

        /* renamed from: a */
        public void onNext(Integer num) {
            super.onNext(num);
            CoinStringUtil.b(num.intValue());
        }
    }

    public class d implements KLineHelper.a {
        public d() {
        }

        public void a(LinkedHashSet<String> linkedHashSet) {
            LinkedHashSet unused = AbstractKlineActivity.this.V0 = linkedHashSet;
            AbstractKlineActivity abstractKlineActivity = AbstractKlineActivity.this;
            abstractKlineActivity.f23721c0.setSelected(abstractKlineActivity.V0.contains("VOL"));
            AbstractKlineActivity.this.f23723d0.setSelected(AbstractKlineActivity.this.V0.contains("MACD"));
            AbstractKlineActivity.this.f23725e0.setSelected(AbstractKlineActivity.this.V0.contains("KDJ"));
            AbstractKlineActivity.this.f23727f0.setSelected(AbstractKlineActivity.this.V0.contains("RSI"));
            AbstractKlineActivity.this.f23729g0.setSelected(AbstractKlineActivity.this.V0.contains("WR"));
        }

        public void b(int i11) {
            int unused = AbstractKlineActivity.this.U0 = i11;
            boolean z11 = true;
            AbstractKlineActivity.this.Z.setSelected((AbstractKlineActivity.this.U0 & 1) == 1);
            AbstractKlineActivity.this.f23717a0.setSelected((AbstractKlineActivity.this.U0 & 2) == 2);
            TextView Ch = AbstractKlineActivity.this.f23719b0;
            if ((AbstractKlineActivity.this.U0 & 4) != 4) {
                z11 = false;
            }
            Ch.setSelected(z11);
        }
    }

    public class e extends AnimatorListenerAdapter {

        public class a extends AnimatorListenerAdapter {
            public a() {
            }

            public void onAnimationEnd(Animator animator) {
                AbstractKlineActivity.this.Q0 = false;
            }

            public void onAnimationStart(Animator animator) {
                AbstractKlineActivity.this.Q0 = true;
            }
        }

        public e() {
        }

        public void onAnimationEnd(Animator animator) {
            AbstractKlineActivity abstractKlineActivity = AbstractKlineActivity.this;
            abstractKlineActivity.Mh(abstractKlineActivity.R, abstractKlineActivity.f23731h0, AbstractKlineActivity.this.f23733i0, new a());
        }
    }

    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        public void onAnimationEnd(Animator animator) {
            AbstractKlineActivity.this.Q0 = false;
        }

        public void onAnimationStart(Animator animator) {
            AbstractKlineActivity.this.Q0 = true;
        }
    }

    public class g extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f23774b;

        public g(Animator.AnimatorListener animatorListener) {
            this.f23774b = animatorListener;
        }

        public void onAnimationEnd(Animator animator) {
            AbstractKlineActivity abstractKlineActivity = AbstractKlineActivity.this;
            abstractKlineActivity.S0 = false;
            abstractKlineActivity.Q0 = false;
            abstractKlineActivity.U.setSelected(false);
            Animator.AnimatorListener animatorListener = this.f23774b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            AbstractKlineActivity.this.Q0 = true;
        }
    }

    public class h extends AnimatorListenerAdapter {

        public class a extends AnimatorListenerAdapter {
            public a() {
            }

            public void onAnimationEnd(Animator animator) {
                AbstractKlineActivity.this.R0 = false;
            }

            public void onAnimationStart(Animator animator) {
                AbstractKlineActivity.this.R0 = true;
            }
        }

        public h() {
        }

        public void onAnimationEnd(Animator animator) {
            AbstractKlineActivity abstractKlineActivity = AbstractKlineActivity.this;
            abstractKlineActivity.Mh(abstractKlineActivity.V, abstractKlineActivity.f23735j0, abstractKlineActivity.f23737k0, new a());
        }
    }

    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        public void onAnimationEnd(Animator animator) {
            AbstractKlineActivity.this.R0 = false;
        }

        public void onAnimationStart(Animator animator) {
            AbstractKlineActivity.this.R0 = true;
        }
    }

    public class j extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f23779b;

        public j(Animator.AnimatorListener animatorListener) {
            this.f23779b = animatorListener;
        }

        public void onAnimationEnd(Animator animator) {
            AbstractKlineActivity abstractKlineActivity = AbstractKlineActivity.this;
            abstractKlineActivity.T0 = false;
            abstractKlineActivity.R0 = false;
            abstractKlineActivity.Vi();
            AbstractKlineActivity.this.V.setVisibility(8);
            Animator.AnimatorListener animatorListener = this.f23779b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            AbstractKlineActivity.this.R0 = true;
        }
    }

    public class k extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f23781b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f23782c;

        public k(Animator.AnimatorListener animatorListener, View view) {
            this.f23781b = animatorListener;
            this.f23782c = view;
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f23781b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            ViewUtil.m(this.f23782c, true);
            Animator.AnimatorListener animatorListener = this.f23781b;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }
    }

    public AbstractKlineActivity() {
        Period period = Period.timeline;
        Period period2 = Period.min15;
        Period period3 = Period.min60;
        Period period4 = Period.hour4;
        Period period5 = Period.day;
        Period period6 = Period.week;
        this.f23718b = new Period[]{period, period2, period3, period4, period5, period6};
        this.f23720c = new Period[]{period, Period.min1, Period.min5, period2, Period.min30, period3, period4, period5, period6, Period.month};
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ci(View view) {
        int i11 = this.U0;
        if ((i11 & 1) == 1) {
            int i12 = i11 & -2;
            this.U0 = i12;
            ConfigPreferences.k("user_config", "config_target_top_20221026", i12);
            this.J0.setMasterIndex(this.U0);
            this.Z.setSelected(false);
            KLineHelper.g(this.U0);
        } else {
            int i13 = i11 | 1;
            this.U0 = i13;
            ConfigPreferences.k("user_config", "config_target_top_20221026", i13);
            this.J0.setMasterIndex(this.U0);
            this.Z.setSelected(true);
            KLineHelper.g(this.U0);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "MA");
            td.i.a().b().d("4696", hashMap, Rh());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void di(View view) {
        Wi(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ei(View view) {
        Ri(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void fi(View view) {
        Wi(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gi(View view) {
        if (this.V0.remove("MACD")) {
            Ni(this.V0);
            this.f23723d0.setSelected(false);
            KLineHelper.h(this.V0);
        } else {
            this.V0.add("MACD");
            Ni(this.V0);
            this.f23723d0.setSelected(true);
            KLineHelper.h(this.V0);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "MACD");
            td.i.a().b().d("4698", hashMap, Rh());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void hi(View view) {
        if (this.V0.remove("KDJ")) {
            Ni(this.V0);
            this.f23725e0.setSelected(false);
            KLineHelper.h(this.V0);
        } else {
            this.V0.add("KDJ");
            Ni(this.V0);
            this.f23725e0.setSelected(true);
            KLineHelper.h(this.V0);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "KDJ");
            td.i.a().b().d("4698", hashMap, Rh());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ii(View view) {
        if (this.V0.remove("RSI")) {
            Ni(this.V0);
            this.f23727f0.setSelected(false);
            KLineHelper.h(this.V0);
        } else {
            this.V0.add("RSI");
            Ni(this.V0);
            this.f23727f0.setSelected(true);
            KLineHelper.h(this.V0);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "RSI");
            td.i.a().b().d("4698", hashMap, Rh());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ji(View view) {
        if (this.V0.remove("WR")) {
            Ni(this.V0);
            this.f23729g0.setSelected(false);
            KLineHelper.h(this.V0);
        } else {
            this.V0.add("WR");
            Ni(this.V0);
            this.f23729g0.setSelected(true);
            KLineHelper.h(this.V0);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "WR");
            td.i.a().b().d("4698", hashMap, Rh());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ki(View view) {
        Ri(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        startActivity(new Intent(this, IndexSettingActivity.class));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        int i11 = this.U0;
        if ((i11 & 2) == 2) {
            int i12 = i11 & -3;
            this.U0 = i12;
            ConfigPreferences.k("user_config", "config_target_top_20221026", i12);
            this.J0.setMasterIndex(this.U0);
            this.f23717a0.setSelected(false);
            KLineHelper.g(this.U0);
        } else {
            int i13 = i11 | 2;
            this.U0 = i13;
            ConfigPreferences.k("user_config", "config_target_top_20221026", i13);
            this.J0.setMasterIndex(this.U0);
            this.f23717a0.setSelected(true);
            KLineHelper.g(this.U0);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "EMA");
            td.i.a().b().d("4696", hashMap, Rh());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        int i11 = this.U0;
        if ((i11 & 4) == 4) {
            int i12 = i11 & -5;
            this.U0 = i12;
            ConfigPreferences.k("user_config", "config_target_top_20221026", i12);
            this.J0.setMasterIndex(this.U0);
            this.f23719b0.setSelected(false);
            KLineHelper.g(this.U0);
        } else {
            int i13 = i11 | 4;
            this.U0 = i13;
            ConfigPreferences.k("user_config", "config_target_top_20221026", i13);
            this.J0.setMasterIndex(this.U0);
            this.f23719b0.setSelected(true);
            KLineHelper.g(this.U0);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "BOLL");
            td.i.a().b().d("4698", hashMap, Rh());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        if (this.V0.remove("VOL")) {
            Ni(this.V0);
            this.f23721c0.setSelected(false);
            KLineHelper.h(this.V0);
        } else {
            this.V0.add("VOL");
            Ni(this.V0);
            this.f23721c0.setSelected(true);
            KLineHelper.h(this.V0);
            HashMap hashMap = new HashMap();
            hashMap.put("type", "VOL");
            td.i.a().b().d("4698", hashMap, Rh());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void li(View view, int[] iArr) {
        view.getLocationInWindow(iArr);
        this.f23748s.setTranslationX((float) iArr[0]);
        ViewGroup.LayoutParams layoutParams = this.f23748s.getLayoutParams();
        if (this.W == view) {
            layoutParams.width = view.getWidth();
        } else {
            layoutParams.width = view.getWidth();
        }
        this.f23748s.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void mi(ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.f23748s.getLayoutParams();
        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f23748s.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ni(View view, View view2) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (!this.N0) {
            this.N0 = true;
            view.post(new g(this, view, iArr));
            return;
        }
        this.f23748s.animate().translationX((float) iArr[0]);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f23748s.getWidth(), view.getWidth()});
        ofInt.addUpdateListener(new a(this));
        ofInt.start();
    }

    public final void Ai() {
        boolean z11 = false;
        boolean z12 = TradeType.isContract(this.D0) && a7.e.E(TradeType.CONTRACT);
        boolean z13 = TradeType.isSwap(this.D0) && a7.e.E(TradeType.SWAP);
        boolean z14 = TradeType.isLinearSwap(this.D0) && a7.e.F(TradeType.valueOf(this.D0));
        boolean z15 = TradeType.isOption(this.D0) && a7.e.E(TradeType.valueOf(this.D0));
        if (z12 || z13 || z14) {
            z11 = true;
        }
        if (z11 && m.a0(this.F0) && m.a0(this.G0)) {
            this.f23747r.setText(Xh(this.F0));
            this.f23747r.append(((AbstractKlinePresenter) getPresenter()).T());
        } else if (z15 && m.a0(this.F0) && m.a0(this.G0)) {
            if (this.H0) {
                this.f23747r.setText(m.T(this.F0, FuturePrecisionUtil.s(this.B0, this.f23762z0, this.C0)));
            } else {
                this.f23747r.setText(m.o(this.F0, FuturePrecisionUtil.s(this.B0, this.f23762z0, this.C0), true));
            }
            this.f23747r.append(((AbstractKlinePresenter) getPresenter()).T());
        }
    }

    public final void Bi(String str) {
        if (this.H0) {
            this.f23747r.setText(getString(R$string.contract_hold_num_value, new Object[]{m.T(str, 0)}));
            return;
        }
        this.f23747r.setText(getString(R$string.contract_hold_num_value, new Object[]{m.o(str, 0, true)}));
    }

    public void Ci(boolean z11) {
    }

    public final void Di() {
        List<be.i> a11 = be.j.c().a();
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
            this.J0.H(a11.get(22).a(), a11.get(23).a(), a11.get(24).a(), a11.get(25).a(), a11.get(26).a(), a11.get(27).a(), a11.get(28).a(), a11.get(29).a());
            this.J0.J(a12, a13, a14, a15, a16, a17, a25, a26, c11, c12, c13, c14, c15, c16, c17, c18, a18, a19, a21, a22, a23, a24);
        }
    }

    public void Ei(boolean z11) {
    }

    public void Fi(double d11) {
        String str;
        if (d11 == 0.0d || m.h0(m.i(d11, this.K0)) == 0.0d) {
            str = "--";
        } else {
            str = ((TradeType.isContract(this.D0) || TradeType.isSwap(this.D0) || TradeType.isContractIndex(this.D0)) ? "$" : "") + m.k(d11, this.K0, true);
        }
        this.f23726f.setText(str);
    }

    public void G3(KlineInfo klineInfo) {
        this.I0 = klineInfo;
    }

    public final void Gi(double d11) {
        this.G0 = String.valueOf(d11);
        if (TradeType.isContract(this.D0) || TradeType.isSwap(this.D0) || TradeType.isLinearSwap(this.D0)) {
            Ai();
        }
        Fi(d11);
        yi(String.valueOf(d11));
    }

    public void Hi(TextView textView, String str, double d11) {
        if (Double.compare(d11, 0.0d) > 0) {
            textView.setTextColor(getResources().getColor(R$color.color_rise));
        } else if (Double.compare(d11, 0.0d) < 0) {
            textView.setTextColor(getResources().getColor(R$color.color_down));
        } else {
            textView.setTextColor(getResources().getColor(R$color.color_flat));
        }
        textView.setText(m.c(str, "--"));
    }

    public void Ii(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void Ji(TextView textView, boolean z11, int i11, int i12) {
        if (textView == null) {
            return;
        }
        if (z11) {
            textView.setTextColor(i11);
        } else {
            textView.setTextColor(i12);
        }
    }

    public void K(List<?> list, int i11) {
    }

    /* renamed from: Kh */
    public AbstractKlinePresenter createPresenter() {
        return new AbstractKlinePresenter();
    }

    public void Ki() {
        oi();
    }

    public void Lh(View view, View view2, View view3, Animator.AnimatorListener animatorListener) {
        if (view != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(240);
            animatorSet.setInterpolator(new FastOutLinearInInterpolator());
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(this.Y, "rotation", new float[]{180.0f, 0.0f}), ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{0.0f, (float) (-this.M0)})});
            animatorSet.addListener(new a(view, animatorListener));
            animatorSet.start();
        }
    }

    public void Li(int i11) {
        if (this.f23741m0 != i11 && i11 >= 0) {
            this.f23741m0 = i11;
            if (i11 == R$id.time_sharing_radio_layout) {
                Period period = Period.timeline;
                ConfigPreferences.m("user_config", "config_period", period.key);
                this.f23754v0 = period;
            } else if (i11 == R$id.float_time_radio_layout || i11 == R$id.float_time_radio_layout_etp) {
                Period period2 = Period.timeline;
                ConfigPreferences.m("user_config", "config_period", period2.key);
                this.f23754v0 = period2;
            } else if (i11 == R$id.one_min_radio_layout || i11 == R$id.one_min_radio_layout_etp) {
                Period period3 = Period.min1;
                ConfigPreferences.m("user_config", "config_period", period3.key);
                this.f23754v0 = period3;
            } else if (i11 == R$id.five_min_radio_layout || i11 == R$id.five_min_radio_layout_etp) {
                Period period4 = Period.min5;
                ConfigPreferences.m("user_config", "config_period", period4.key);
                this.f23754v0 = period4;
            } else if (i11 == R$id.fifteen_min_radio_layout) {
                Period period5 = Period.min15;
                ConfigPreferences.m("user_config", "config_period", period5.key);
                this.f23754v0 = period5;
            } else if (i11 == R$id.thirty_min_radio_layout || i11 == R$id.thirty_min_radio_layout_etp) {
                Period period6 = Period.min30;
                ConfigPreferences.m("user_config", "config_period", period6.key);
                this.f23754v0 = period6;
            } else if (i11 == R$id.sixty_min_radio_layout) {
                Period period7 = Period.min60;
                ConfigPreferences.m("user_config", "config_period", period7.key);
                this.f23754v0 = period7;
            } else if (i11 == R$id.four_hour_radio_layout) {
                Period period8 = Period.hour4;
                ConfigPreferences.m("user_config", "config_period", period8.key);
                this.f23754v0 = period8;
            } else if (i11 == R$id.one_day_radio_layout) {
                Period period9 = Period.day;
                ConfigPreferences.m("user_config", "config_period", period9.key);
                this.f23754v0 = period9;
            } else if (i11 == R$id.one_week_radio_layout || i11 == R$id.one_week_radio_layout_etp) {
                Period period10 = Period.week;
                ConfigPreferences.m("user_config", "config_period", period10.key);
                this.f23754v0 = period10;
            } else if (i11 == R$id.one_month_radio_layout || i11 == R$id.one_month_radio_layout_etp) {
                Period period11 = Period.month;
                ConfigPreferences.m("user_config", "config_period", period11.key);
                this.f23754v0 = period11;
            }
            this.J0.K(this.f23754v0, false);
            this.f23743n0 = i11;
            ((AbstractKlinePresenter) getPresenter()).c0(this.f23754v0);
            if (i11 == R$id.market_info_more_layout) {
                BaseModuleConfig.a().w("App_markets_kline_timescm_click", (HashMap) null);
            } else {
                BaseModuleConfig.a().w("App_markets_kline_timesc_click", (HashMap) null);
            }
            if (!this.H0) {
                boolean z11 = false;
                for (Period period12 : this.f23718b) {
                    if (period12 == this.f23754v0) {
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
                    this.W.setTextColor(Qh());
                    this.W.setText(R$string.market_info_more);
                    BaseModuleConfig.a().w("App_markets_kline_depthmap_click", (HashMap) null);
                    return;
                }
                this.W.setTextColor(Th());
                Period period13 = this.f23754v0;
                if (period13 == Period.timeline) {
                    this.W.setText(R$string.n_kline_timeline);
                } else if (period13 == Period.min1) {
                    this.W.setText(R$string.n_kline_1min);
                } else if (period13 == Period.min5) {
                    this.W.setText(R$string.n_kline_5min);
                } else if (period13 == Period.min30) {
                    this.W.setText(R$string.n_kline_30min);
                } else if (period13 == Period.week) {
                    this.W.setText(R$string.n_kline_1week);
                } else if (period13 == Period.month) {
                    this.W.setText(R$string.n_kline_1month);
                } else {
                    this.W.setText(R$string.market_info_more);
                }
            }
        }
    }

    public void M(KlineInfo klineInfo) {
        if (Oi()) {
            this.f23730h.setText(m.T(String.valueOf(klineInfo.getAmount()), PrecisionUtil.t(this.f23756w0)));
        } else {
            this.f23730h.setText(m.k(klineInfo.getAmount(), PrecisionUtil.t(this.f23756w0), true));
        }
        if (this.f23736k != null) {
            this.f23736k.setText(m.T(String.valueOf(klineInfo.getVol()), this.L0));
        }
        if (TradeType.isPro(this.D0)) {
            this.f23738l.setText(m.k(klineInfo.getHigh(), this.K0, true));
            this.f23732i.setText(m.k(klineInfo.getLow(), this.K0, true));
        }
    }

    public void Mh(View view, View view2, View view3, Animator.AnimatorListener animatorListener) {
        if (view != null) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = Vh();
            view.setLayoutParams(layoutParams);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(270);
            animatorSet.setInterpolator(new LinearOutSlowInInterpolator());
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(this.Y, "rotation", new float[]{0.0f, 180.0f}), ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{(float) (-this.M0), 0.0f})});
            animatorSet.addListener(new k(animatorListener, view));
            animatorSet.start();
        }
    }

    public final void Mi(View view, boolean z11) {
        if (view != null) {
            view.setSelected(z11);
        }
    }

    public final void Nh(View view) {
        ViewUtil.b(view, new f(this, view));
    }

    public void Ni(LinkedHashSet<String> linkedHashSet) {
        LinkedHashSet<String> linkedHashSet2;
        this.V0 = linkedHashSet;
        ConfigPreferences.m("user_config", "config_target_under_20221026", CandleStickRender.SlaveChartIndex.c(linkedHashSet));
        String str = "";
        if (!ae() ? !(TradeType.isIndex(this.D0) || TradeType.isContractIndex(this.D0) || TradeType.isLinearSwapIndex(this.D0)) : KLineHelper.d(this.f23756w0, true)) {
            str = "VOL";
        }
        this.J0.setSlaveIndex1(str);
        this.J0.setSlaveIndex2(this.V0);
        int i11 = 0;
        this.f23721c0.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        if ("VOL".equals(str) && ((linkedHashSet2 = this.V0) == null || linkedHashSet2.contains("VOL"))) {
            i11 = 1;
        }
        LinkedHashSet<String> linkedHashSet3 = this.V0;
        if (linkedHashSet3 != null) {
            i11 += linkedHashSet3.contains("VOL") ? this.V0.size() - 1 : this.V0.size();
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.J0.M((((point.y - PixelUtils.a(44.0f)) - PixelUtils.a(5.0f)) - PixelUtils.a(35.0f)) + (i11 * KLineConstants.f67188f));
    }

    public int Oh(int i11) {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.data;
    }

    public boolean Oi() {
        return !TradeType.isOption(this.D0) && !TradeType.isIndex(this.D0) && !TradeType.isContractIndex(this.D0) && !TradeType.isLinearSwapIndex(this.D0);
    }

    @SuppressLint({"SetTextI18n"})
    public void P(String str) {
        if (this.f23747r != null) {
            boolean z11 = true;
            if (!TradeType.isLinearSwap(this.D0)) {
                boolean z12 = TradeType.isContract(this.D0) && a7.e.E(TradeType.CONTRACT);
                if (!TradeType.isSwap(this.D0) || !a7.e.E(TradeType.SWAP)) {
                    z11 = false;
                }
                if (z12 || z11) {
                    this.F0 = str;
                    Ai();
                    return;
                }
                Bi(str);
            } else if (!a7.e.F(TradeType.valueOf(this.D0))) {
                Bi(str);
            } else if (getPresenter() != null && ((AbstractKlinePresenter) getPresenter()).T() != null) {
                if (this.H0) {
                    this.f23747r.setText(m.T(m.L(FutureUnitUtil.c(str, this.G0, ((AbstractKlinePresenter) getPresenter()).V().getContractFace(), TradeType.valueOf(this.D0), a7.e.F(TradeType.valueOf(this.D0))), 1), 1) + ((AbstractKlinePresenter) getPresenter()).T());
                    return;
                }
                this.f23747r.setText(m.c(m.L(FutureUnitUtil.c(str, this.G0, ((AbstractKlinePresenter) getPresenter()).V().getContractFace(), TradeType.valueOf(this.D0), a7.e.F(TradeType.valueOf(this.D0))), 1), "--") + ((AbstractKlinePresenter) getPresenter()).T());
            }
        }
    }

    public int Ph() {
        return this.K0;
    }

    public void Pi(View view) {
        TextView textView;
        this.f23749t.setTextColor(Qh());
        this.f23753v.setTextColor(Qh());
        this.f23755w.setTextColor(Qh());
        this.f23757x.setTextColor(Qh());
        this.f23759y.setTextColor(Qh());
        this.f23761z.setTextColor(Qh());
        this.A.setTextColor(Qh());
        this.B.setTextColor(Qh());
        this.C.setTextColor(Qh());
        this.D.setTextColor(Qh());
        Ei(true);
        Ci(false);
        if (ae() && (textView = this.T) != null) {
            textView.setTextColor(Th());
        }
        if (TradeType.isIndex(this.D0)) {
            ViewUtil.m(this.F, true);
            ViewUtil.m(this.G, false);
        } else if (TradeType.isContractIndex(this.D0) || TradeType.isLinearSwapIndex(this.D0)) {
            ViewUtil.m(this.F, true);
            ViewUtil.m(this.G, false);
        } else {
            if (this.H0) {
                ViewUtil.m(this.F, true);
            } else {
                ViewUtil.m(this.F, false);
            }
            ViewUtil.m(this.G, true);
        }
        int id2 = view.getId();
        if (id2 == R$id.time_sharing_radio_layout) {
            this.f23749t.setTextColor(Th());
            Wi(false);
            if (this.H0 || TradeType.isIndex(this.D0) || TradeType.isContractIndex(this.D0) || TradeType.isLinearSwapIndex(this.D0)) {
                Nh(this.f23749t);
            } else {
                Nh(this.X);
            }
        } else if (id2 == R$id.one_min_radio_layout || id2 == R$id.one_min_radio_layout_etp) {
            if (this.H0) {
                this.f23753v.setTextColor(Th());
                Nh(this.f23753v);
            } else {
                Ii(this.W, getResources().getString(R$string.n_kline_1min));
                Wi(false);
                Nh(this.X);
            }
        } else if (id2 == R$id.float_time_radio_layout || id2 == R$id.float_time_radio_layout_etp) {
            if (this.H0) {
                this.f23751u.setTextColor(Th());
                Nh(this.f23751u);
            } else {
                Ii(this.W, getResources().getString(R$string.n_kline_timeline));
                Wi(false);
                Nh(this.X);
            }
        } else if (id2 == R$id.five_min_radio_layout || id2 == R$id.five_min_radio_layout_etp) {
            if (this.H0) {
                this.f23755w.setTextColor(Th());
                Nh(this.f23755w);
            } else {
                Ii(this.W, getResources().getString(R$string.n_kline_5min));
                Wi(false);
                Nh(this.X);
            }
        } else if (id2 == R$id.fifteen_min_radio_layout) {
            this.f23757x.setTextColor(Th());
            Wi(false);
            Nh(this.f23757x);
        } else if (id2 == R$id.thirty_min_radio_layout || id2 == R$id.thirty_min_radio_layout_etp) {
            if (this.H0) {
                this.f23759y.setTextColor(Th());
                Nh(this.f23759y);
            } else {
                Ii(this.W, getResources().getString(R$string.n_kline_30min));
                Wi(false);
                Nh(this.X);
            }
        } else if (id2 == R$id.sixty_min_radio_layout) {
            this.f23761z.setTextColor(Th());
            Wi(false);
            Nh(this.f23761z);
        } else if (id2 == R$id.four_hour_radio_layout) {
            this.A.setTextColor(Th());
            Wi(false);
            Nh(this.A);
        } else if (id2 == R$id.one_day_radio_layout) {
            this.B.setTextColor(Th());
            Wi(false);
            Nh(this.B);
        } else if (id2 == R$id.one_week_radio_layout || id2 == R$id.one_week_radio_layout_etp) {
            this.C.setTextColor(Th());
            Wi(false);
            if (this.H0 || !ae()) {
                Nh(this.C);
            } else {
                Nh(this.X);
            }
        } else if (id2 == R$id.one_month_radio_layout || id2 == R$id.one_month_radio_layout_etp) {
            if (this.H0) {
                this.D.setTextColor(Th());
                Wi(false);
                Nh(this.D);
            } else {
                Ii(this.W, getResources().getString(R$string.n_kline_1month));
                Wi(false);
                Nh(this.X);
            }
        }
        if (view.getId() != R$id.market_info_more_layout && view.getId() != R$id.target_checkbox_layout) {
            Li(view.getId());
            Qi();
            BaseModuleConfig.a().w("App_markets_kline_indexset_click", (HashMap) null);
        }
    }

    public int Qh() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R$attr.kline_three_level_text_color, typedValue, true);
        return typedValue.data;
    }

    public final void Qi() {
        int c11 = KLineHelper.c(this, R$attr.kline_index_setting_text_color);
        int c12 = KLineHelper.c(this, R$attr.kline_three_level_text_color);
        boolean z11 = true;
        Mi(this.G, !bi() && this.f23754v0 == Period.timeline);
        Ji(this.f23751u, !bi() && this.f23754v0 == Period.timeline, c11, c12);
        Mi(this.H, !bi() && this.f23754v0 == Period.min1);
        Ji(this.f23753v, !bi() && this.f23754v0 == Period.min1, c11, c12);
        Mi(this.I, !bi() && this.f23754v0 == Period.min5);
        Ji(this.f23755w, !bi() && this.f23754v0 == Period.min5, c11, c12);
        Mi(this.K, !bi() && this.f23754v0 == Period.min30);
        Ji(this.f23759y, !bi() && this.f23754v0 == Period.min30, c11, c12);
        Mi(this.P, !bi() && this.f23754v0 == Period.month);
        TextView textView = this.D;
        if (bi() || this.f23754v0 != Period.month) {
            z11 = false;
        }
        Ji(textView, z11, c11, c12);
    }

    public String Rh() {
        return ai() ? "1005015" : "1005005";
    }

    public void Ri(boolean z11) {
        Si(z11, (Animator.AnimatorListener) null);
    }

    public String Sh(double d11, double d12) {
        if (Double.compare(d11, 0.0d) == 1) {
            double d13 = d12 - d11;
            String str = Double.compare(d13, 0.0d) > 0 ? "+" : "";
            return str + m.i((d13 / d11) * 100.0d, PrecisionUtil.v(this.f23756w0)) + "%";
        }
        return m.i(0.0d, PrecisionUtil.v(this.f23756w0)) + "%";
    }

    public void Si(boolean z11, Animator.AnimatorListener animatorListener) {
        if (this.H0 || this.Q0) {
            return;
        }
        if (z11) {
            if (!this.S0) {
                this.S0 = true;
                this.U.setSelected(true);
                if (this.T0) {
                    Xi(false, new e());
                } else {
                    Mh(this.R, this.f23731h0, this.f23733i0, new f());
                }
            }
        } else if (this.S0) {
            Lh(this.R, this.f23731h0, this.f23733i0, new g(animatorListener));
        }
    }

    public int Th() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R$attr.kline_index_setting_text_color, typedValue, true);
        return typedValue.data;
    }

    public void Ti(List<IndexIngredient> list) {
    }

    public String Uh(Intent intent) {
        if (TradeType.isContract(this.D0) || TradeType.isSwap(this.D0)) {
            return intent.getStringExtra("contractName");
        }
        if (TradeType.isContractIndex(this.D0)) {
            IndexCurrencyInfo indexCurrencyInfo = (IndexCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
            String str = indexCurrencyInfo.getSymbol() + indexCurrencyInfo.getQuoteCurrency();
            return String.format(Locale.US, getString(R$string.market_info_tab_contract_index_intro), new Object[]{str});
        } else if (TradeType.isOption(this.D0)) {
            return ((FutureContractInfo) intent.getSerializableExtra("contract_currency_info")).getSymbol();
        } else {
            if (TradeType.isLinearSwap(this.D0)) {
                String stringExtra = intent.getStringExtra("contractName");
                FutureContractInfo futureContractInfo = (FutureContractInfo) intent.getSerializableExtra("contract_currency_info");
                if (futureContractInfo != null) {
                    this.f23762z0 = futureContractInfo.getContractShortType();
                }
                return stringExtra;
            } else if (!TradeType.isLinearSwapIndex(this.D0)) {
                return a1.v().X(this.f23756w0, TradeType.valueOf(this.D0));
            } else {
                IndexCurrencyInfo indexCurrencyInfo2 = (IndexCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
                String p11 = a7.e.p(getActivity(), indexCurrencyInfo2.getSymbol(), indexCurrencyInfo2.getQuoteCurrency());
                return String.format(Locale.US, getString(R$string.market_info_tab_contract_index_intro), new Object[]{p11});
            }
        }
    }

    public void Ui() {
    }

    public final int Vh() {
        int[] iArr = new int[2];
        this.f23739l0.getLocationInWindow(iArr);
        return (iArr[1] + this.f23739l0.getHeight()) - ViewUtil.g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        if (r4.f23754v0 == com.hbg.lib.network.pro.core.util.Period.week) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Vi() {
        /*
            r4 = this;
            com.hbg.lib.network.pro.core.util.Period r0 = r4.f23754v0
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
            android.widget.RelativeLayout r1 = r4.F
            if (r1 == 0) goto L_0x0037
            int r1 = r1.getVisibility()
            if (r1 == 0) goto L_0x0037
            com.hbg.lib.network.pro.core.util.Period r1 = r4.f23754v0
            com.hbg.lib.network.pro.core.util.Period r3 = com.hbg.lib.network.pro.core.util.Period.timeline
            if (r1 != r3) goto L_0x002a
            r0 = r2
        L_0x002a:
            boolean r1 = r4.ae()
            if (r1 == 0) goto L_0x0037
            com.hbg.lib.network.pro.core.util.Period r1 = r4.f23754v0
            com.hbg.lib.network.pro.core.util.Period r3 = com.hbg.lib.network.pro.core.util.Period.week
            if (r1 != r3) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r2 = r0
        L_0x0038:
            if (r2 == 0) goto L_0x004a
            boolean r0 = r4.bi()
            if (r0 != 0) goto L_0x004a
            android.widget.TextView r0 = r4.W
            int r1 = r4.Th()
            r0.setTextColor(r1)
            goto L_0x0053
        L_0x004a:
            android.widget.TextView r0 = r4.W
            int r1 = r4.Qh()
            r0.setTextColor(r1)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.kline.ui.AbstractKlineActivity.Vi():void");
    }

    /* renamed from: Wh */
    public AbstractKlinePresenter.b getUI() {
        return this;
    }

    public void Wi(boolean z11) {
        Xi(z11, (Animator.AnimatorListener) null);
    }

    public final String Xh(String str) {
        if (m.a(str).compareTo(BigDecimal.ZERO) == 0 || m.a(this.G0).compareTo(BigDecimal.ZERO) == 0) {
            return str;
        }
        BigDecimal bigDecimal = new BigDecimal(((AbstractKlinePresenter) getPresenter()).S());
        BigDecimal bigDecimal2 = new BigDecimal(str);
        if (this.H0) {
            return m.T(m.L(bigDecimal2.multiply(bigDecimal).divide(m.a(this.G0), 32, RoundingMode.DOWN).toString(), 1), 1);
        }
        return m.c(m.L(bigDecimal2.multiply(bigDecimal).divide(m.a(this.G0), 32, RoundingMode.DOWN).toString(), 1), "--");
    }

    public void Xi(boolean z11, Animator.AnimatorListener animatorListener) {
        if (this.H0 || this.R0) {
            return;
        }
        if (z11) {
            if (!this.T0) {
                this.T0 = true;
                Qi();
                if (this.S0) {
                    Si(false, new h());
                } else {
                    Mh(this.V, this.f23735j0, this.f23737k0, new i());
                }
            }
        } else if (this.T0) {
            Lh(this.V, this.f23735j0, this.f23737k0, new j(animatorListener));
        }
    }

    public void Yh() {
        int i11;
        this.f23748s = findViewById(R$id.kline_tab_indicator);
        this.f23739l0 = findViewById(R$id.trade_time_group_layout);
        this.Z = (TextView) findViewById(R$id.trade_main_target_MA);
        this.f23717a0 = (TextView) findViewById(R$id.trade_main_target_EMA);
        this.f23719b0 = (TextView) findViewById(R$id.trade_main_target_BOLL);
        this.f23721c0 = (TextView) findViewById(R$id.trade_under_target_VOL);
        this.f23723d0 = (TextView) findViewById(R$id.trade_under_target_MACD);
        this.f23725e0 = (TextView) findViewById(R$id.trade_under_target_KDJ);
        this.f23727f0 = (TextView) findViewById(R$id.trade_under_target_RSI);
        this.f23729g0 = (TextView) findViewById(R$id.trade_under_target_WR);
        this.f23722d = (TextView) findViewById(R$id.market_info_symbol);
        this.f23724e = (ImageView) findViewById(R$id.image_view_kline_title_icon);
        this.f23731h0 = findViewById(R$id.id_kline_index_setting_view);
        this.f23733i0 = findViewById(R$id.id_kline_index_setting_bg_view);
        this.f23735j0 = findViewById(R$id.id_kline_period_more_view);
        this.f23737k0 = findViewById(R$id.id_kline_period_more_bg_view);
        this.S = this.viewFinder.b(R$id.index_setting);
        this.f23749t = (TextView) this.viewFinder.b(R$id.time_sharing_radio);
        this.f23753v = (TextView) this.viewFinder.b(R$id.one_min_radio);
        this.f23751u = (TextView) this.viewFinder.b(R$id.float_time_radio);
        this.f23755w = (TextView) this.viewFinder.b(R$id.five_min_radio);
        this.f23757x = (TextView) this.viewFinder.b(R$id.fifteen_min_radio);
        this.f23759y = (TextView) this.viewFinder.b(R$id.thirty_min_radio);
        this.f23761z = (TextView) this.viewFinder.b(R$id.sixty_min_radio);
        this.A = (TextView) this.viewFinder.b(R$id.four_hour_radio);
        this.B = (TextView) this.viewFinder.b(R$id.one_day_radio);
        this.C = (TextView) this.viewFinder.b(R$id.one_week_radio);
        this.D = (TextView) this.viewFinder.b(R$id.one_month_radio);
        this.E = (RelativeLayout) this.viewFinder.b(R$id.target_checkbox_layout);
        this.F = (RelativeLayout) this.viewFinder.b(R$id.time_sharing_radio_layout);
        this.H = (RelativeLayout) this.viewFinder.b(R$id.one_min_radio_layout);
        this.G = (RelativeLayout) this.viewFinder.b(R$id.float_time_radio_layout);
        this.I = (RelativeLayout) this.viewFinder.b(R$id.five_min_radio_layout);
        this.J = (RelativeLayout) this.viewFinder.b(R$id.fifteen_min_radio_layout);
        this.K = (RelativeLayout) this.viewFinder.b(R$id.thirty_min_radio_layout);
        this.L = (RelativeLayout) this.viewFinder.b(R$id.sixty_min_radio_layout);
        this.M = (RelativeLayout) this.viewFinder.b(R$id.four_hour_radio_layout);
        this.N = (RelativeLayout) this.viewFinder.b(R$id.one_day_radio_layout);
        this.O = (RelativeLayout) this.viewFinder.b(R$id.one_week_radio_layout);
        this.P = (RelativeLayout) this.viewFinder.b(R$id.one_month_radio_layout);
        this.Q = (RelativeLayout) this.viewFinder.b(R$id.market_info_more_layout);
        this.W = (TextView) this.viewFinder.b(R$id.market_info_more);
        this.X = this.viewFinder.b(R$id.ll_market_info_more);
        this.Y = (ImageView) this.viewFinder.b(R$id.market_info_more_indicator_top);
        this.U = (ImageView) this.viewFinder.b(R$id.index_setting_image);
        this.f23726f = (TextView) findViewById(R$id.trade_price_text);
        ViewUtil.m(findViewById(R$id.linear_layout_kline_info_box), !Oi());
        ViewUtil.m(findViewById(R$id.linear_layout_kline_info_box2), Oi());
        if (this.H0 || !Oi()) {
            this.f23738l = (TextView) findViewById(R$id.high_price_text);
            this.f23732i = (TextView) findViewById(R$id.low_price_text);
            this.f23728g = (TextView) findViewById(R$id.volume_sum_label);
            this.f23730h = (TextView) findViewById(R$id.volume_sum_text);
            this.f23740m = (TextView) findViewById(R$id.high_price_label);
            this.f23742n = (TextView) findViewById(R$id.low_price_label);
        } else {
            this.f23738l = (TextView) findViewById(R$id.high_price_text2);
            this.f23732i = (TextView) findViewById(R$id.low_price_text2);
            this.f23728g = (TextView) findViewById(R$id.volume_sum_label2);
            this.f23730h = (TextView) findViewById(R$id.volume_sum_text2);
            this.f23734j = (TextView) findViewById(R$id.volume_sum_amount_label2);
            this.f23736k = (TextView) findViewById(R$id.volume_sum_amount_text2);
            this.f23740m = (TextView) findViewById(R$id.high_price_label2);
            this.f23742n = (TextView) findViewById(R$id.low_price_label2);
        }
        this.f23744o = (TextView) findViewById(R$id.the_rise_and_fall_text);
        this.f23745p = (TextView) findViewById(R$id.market_info_cny);
        if (TradeType.isOption(this.D0)) {
            FutureContractInfo futureContractInfo = (FutureContractInfo) getIntent().getSerializableExtra("contract_currency_info");
            TypedValue typedValue = new TypedValue();
            getTheme().resolveAttribute(R$attr.kline_primary_text_color, typedValue, true);
            this.f23722d.setText(a7.e.z(futureContractInfo.getSymbol(), futureContractInfo.getOptionCode(), this, typedValue.data));
        } else {
            this.f23722d.setText(this.f23758x0);
        }
        if (TradeType.isIndex(this.D0)) {
            this.f23728g.setText(R$string.market_info_rise_pct);
            ViewUtil.m(this.f23724e, false);
        } else if (TradeType.isContractIndex(this.D0) || TradeType.isLinearSwapIndex(this.D0)) {
            ViewUtil.m(this.f23724e, false);
            ViewUtil.m(this.f23728g, false);
        } else {
            ViewUtil.m(this.f23724e, true);
        }
        TextView textView = this.f23746q;
        if (textView != null) {
            textView.append(" ");
        }
        if (Oi()) {
            int i12 = b.f23766a[TradeType.parse(this.D0).ordinal()];
            if (i12 == 1) {
                ContractCurrencyInfo contractCurrencyInfo = (ContractCurrencyInfo) getIntent().getSerializableExtra("contract_currency_info");
                this.P0 = "USD";
                if (!(contractCurrencyInfo == null || contractCurrencyInfo.getSymbol() == null)) {
                    this.O0 = contractCurrencyInfo.getSymbol().toUpperCase();
                }
            } else if (i12 == 2) {
                SwapCurrencyInfo swapCurrencyInfo = (SwapCurrencyInfo) getIntent().getSerializableExtra("contract_currency_info");
                this.P0 = "USD";
                if (!(swapCurrencyInfo == null || swapCurrencyInfo.getSymbol() == null)) {
                    this.O0 = swapCurrencyInfo.getSymbol().toUpperCase();
                }
            } else if (i12 != 3) {
                this.O0 = StringUtils.i(a1.v().p(this.f23756w0));
                this.P0 = StringUtils.i(a1.v().F(this.f23756w0));
            } else {
                FutureContractInfo futureContractInfo2 = (FutureContractInfo) getIntent().getSerializableExtra("contract_currency_info");
                if (futureContractInfo2 != null) {
                    this.P0 = futureContractInfo2.getQuoteCurrency().toUpperCase();
                    this.O0 = futureContractInfo2.getSymbol().toUpperCase();
                } else if (!TextUtils.isEmpty(this.f23756w0) && this.f23756w0.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    String[] split = this.f23756w0.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    if (split == null) {
                        i11 = 0;
                    } else {
                        i11 = split.length;
                    }
                    if (i11 >= 1) {
                        this.O0 = split[0];
                    }
                    if (i11 >= 2) {
                        this.P0 = split[1];
                    }
                }
            }
            if (this.f23728g != null) {
                if (!TradeType.isContract(this.D0) && !TradeType.isLinearSwap(this.D0) && !TradeType.isSwap(this.D0)) {
                    this.f23728g.setText(String.format(getString(R$string.n_kline_24H_amount), new Object[]{this.O0}));
                } else if (a7.e.F(TradeType.valueOf(this.D0)) || a7.e.G(TradeType.valueOf(this.D0))) {
                    this.f23728g.setText(String.format(getString(R$string.n_kline_24H_amount), new Object[]{this.O0}));
                } else {
                    this.f23728g.setText(String.format(getString(R$string.n_kline_24H_amount), new Object[]{getString(R$string.contract_trade_unit_sheet)}));
                }
            }
            if (this.f23734j != null) {
                this.f23734j.setText(String.format(getString(R$string.n_kline_24H_volume), new Object[]{this.P0}));
            }
            TextView textView2 = this.f23740m;
            if (textView2 != null) {
                textView2.setText(getString(R$string.n_kline_24H_highest));
            }
            TextView textView3 = this.f23742n;
            if (textView3 != null) {
                textView3.setText(getString(R$string.n_kline_24H_lowest));
            }
        }
    }

    public void Zh(KlineViewWrapper klineViewWrapper, boolean z11) {
        this.J0 = klineViewWrapper;
        klineViewWrapper.setTradeType(this.D0);
        this.J0.setSymbolId(this.f23756w0);
        this.J0.setPricePrecision(this.K0);
        this.J0.setVolPrecision(this.L0);
        Di();
        this.J0.E();
        this.H0 = z11;
    }

    public void addEvent() {
        RelativeLayout relativeLayout = this.Q;
        if (relativeLayout != null) {
            relativeLayout.setClickable(true);
        }
        this.F.setClickable(true);
        this.H.setClickable(true);
        RelativeLayout relativeLayout2 = this.G;
        if (relativeLayout2 != null) {
            relativeLayout2.setClickable(true);
        }
        this.I.setClickable(true);
        this.J.setClickable(true);
        this.K.setClickable(true);
        this.L.setClickable(true);
        this.M.setClickable(true);
        this.N.setClickable(true);
        this.O.setClickable(true);
        this.P.setClickable(true);
        this.S.setOnClickListener(new e(this));
        P("--");
        TextView textView = this.Z;
        if (textView != null) {
            textView.setOnClickListener(new n(this));
        }
        TextView textView2 = this.f23717a0;
        if (textView2 != null) {
            textView2.setOnClickListener(new p(this));
        }
        TextView textView3 = this.f23719b0;
        if (textView3 != null) {
            textView3.setOnClickListener(new k(this));
        }
        this.f23721c0.setOnClickListener(new i(this));
        this.f23723d0.setOnClickListener(new h(this));
        this.f23725e0.setOnClickListener(new d(this));
        this.f23727f0.setOnClickListener(new l(this));
        this.f23729g0.setOnClickListener(new j(this));
        View view = this.f23733i0;
        if (view != null) {
            view.setOnClickListener(new b(this));
        }
        View view2 = this.f23737k0;
        if (view2 != null) {
            view2.setOnClickListener(new m(this));
        }
        KLineHelper.a(new d());
        View view3 = this.f23733i0;
        if (view3 != null) {
            view3.setOnClickListener(new o(this));
        }
        View view4 = this.f23737k0;
        if (view4 != null) {
            view4.setOnClickListener(new c(this));
        }
    }

    public boolean ae() {
        return a1.v().p0(this.f23756w0);
    }

    public void afterInit() {
        super.afterInit();
        if (td.i.a().b().n()) {
            TradeType valueOf = TradeType.valueOf(this.D0);
            boolean F2 = a7.e.F(valueOf);
            int i11 = b.f23766a[valueOf.ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3) {
                a7.e.K(valueOf).compose(RxJavaHelper.t(getUI())).subscribe(new c(F2));
            }
        }
    }

    public boolean ai() {
        return TradeType.isContract(this.D0) || TradeType.isSwap(this.D0) || TradeType.isOption(this.D0) || TradeType.isLinearSwap(this.D0);
    }

    public boolean bi() {
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e0(double d11) {
    }

    public void eb(IndexDetail indexDetail) {
        if (indexDetail != null) {
            this.f23738l.setText(m.k(indexDetail.getMaxVal(), this.K0, true));
            this.f23732i.setText(m.k(indexDetail.getMinVal(), this.K0, true));
            KlineInfo klineInfo = new KlineInfo();
            klineInfo.setOpen(indexDetail.getOpenVal());
            klineInfo.setClose(indexDetail.getValue());
            klineInfo.setHigh(indexDetail.getMaxVal());
            klineInfo.setLow(indexDetail.getMinVal());
            s3(this.f23756w0, Period.day.value, klineInfo);
            ViewUtil.m(this.f23744o, false);
            Hi(this.f23730h, Sh(klineInfo.getOpen(), klineInfo.getClose()), klineInfo.getClose() - klineInfo.getOpen());
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
            this.f23745p.setText(getString(R$string.market_info_index_ingredients_rise_or_fall_num, new Object[]{String.valueOf(i11), String.valueOf(i12)}));
            this.G0 = String.valueOf(indexDetail.getValue());
            Ai();
            Fi(indexDetail.getValue());
            Ti(indexDetail.getSymbols());
            return;
        }
        Ui();
    }

    public Activity getActivity() {
        return this;
    }

    public void initView() {
        this.M0 = getResources().getDimensionPixelOffset(R$dimen.dimen_272);
        Intent intent = getIntent();
        this.D0 = wi(intent);
        this.f23756w0 = vi(intent);
        this.f23760y0 = ri(intent);
        this.B0 = qi(intent);
        this.C0 = ui(intent);
        this.f23758x0 = Uh(intent);
        this.E0 = si(intent);
        this.K0 = ti();
        this.L0 = xi();
        if (ae()) {
            this.A0 = this.f23756w0 + "nav";
        }
        if (!ae()) {
            q5.a.g().q(this.f23756w0);
        }
        boolean isEmpty = TextUtils.isEmpty(this.D0);
        String str = HiAnalyticsConstant.HaKey.BI_KEY_TRANSTYPE;
        if (!isEmpty) {
            i6.d.e("tab", "tradeType == " + this.D0);
            TradeType tradeType = TradeType.CONTRACT;
            if (tradeType.toString().equalsIgnoreCase(this.D0)) {
                str = tradeType.toString().toLowerCase();
            } else if (TradeType.SWAP.toString().equalsIgnoreCase(this.D0)) {
                str = tradeType.toString().toLowerCase();
            } else if (TradeType.LINEAR_SWAP.toString().equalsIgnoreCase(this.D0)) {
                str = tradeType.toString().toLowerCase();
            } else if (!TradeType.MARGIN.toString().equalsIgnoreCase(this.D0) && !TradeType.SUPERMARGIN.toString().equalsIgnoreCase(this.D0)) {
                if (this.E0) {
                    str = TradeType.GRID.toString();
                } else if (ae()) {
                    str = "etp";
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("TransPair_current_id", this.f23756w0);
            hashMap.put("markets_kline_class", str);
            BaseModuleConfig.a().w("App_markets_kline_view", hashMap);
        }
        str = RankScreenBean.SCREEN_VALUE_SPOT;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("TransPair_current_id", this.f23756w0);
        hashMap2.put("markets_kline_class", str);
        BaseModuleConfig.a().w("App_markets_kline_view", hashMap2);
    }

    public void k8(String str, String str2, KlineInfo klineInfo) {
    }

    public void mg() {
        ((AbstractKlinePresenter) getPresenter()).a0(true);
    }

    public final void oi() {
        boolean z11 = true;
        int g11 = ConfigPreferences.g("user_config", "config_target_top_20221026", 1);
        this.U0 = g11;
        this.Z.setSelected((g11 & 1) == 1);
        this.f23717a0.setSelected((this.U0 & 2) == 2);
        TextView textView = this.f23719b0;
        if ((this.U0 & 4) != 4) {
            z11 = false;
        }
        textView.setSelected(z11);
        this.J0.setMasterIndex(this.U0);
        LinkedHashSet<String> b11 = CandleStickRender.SlaveChartIndex.b(ConfigPreferences.e("user_config", "config_target_under_20221026", "VOL"));
        this.V0 = b11;
        this.f23721c0.setSelected(b11.contains("VOL"));
        this.f23723d0.setSelected(this.V0.contains("MACD"));
        this.f23725e0.setSelected(this.V0.contains("KDJ"));
        this.f23727f0.setSelected(this.V0.contains("RSI"));
        this.f23729g0.setSelected(this.V0.contains("WR"));
        Ni(this.V0);
    }

    public void onCreate(Bundle bundle) {
        if (KLineHelper.f()) {
            setTheme(R$style.ActivityKlineLight);
        } else {
            setTheme(R$style.ActivityKlineNight);
        }
        super.onCreate(bundle);
    }

    public void onPause() {
        super.onPause();
        this.J0.C();
        this.f23752u0 = false;
    }

    public void onResume() {
        this.f23752u0 = true;
        this.J0.D();
        Di();
        this.f23741m0 = -1;
        pi();
        oi();
        super.onResume();
    }

    public void p3(String str) {
    }

    public final void pi() {
        RelativeLayout relativeLayout;
        Period period = Period.min15;
        Period parsePeriod = Period.parsePeriod(ConfigPreferences.e("user_config", "config_period", period.value));
        if (!bi() || parsePeriod != this.f23754v0) {
            if (parsePeriod == Period.timeline) {
                if (TradeType.isLinearSwapIndex(this.D0) || TradeType.isContractIndex(this.D0)) {
                    relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.time_sharing_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.time_sharing_radio_layout);
                }
            } else if (parsePeriod == Period.min1) {
                if (!ae() || this.H0) {
                    relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.one_min_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.one_min_radio_layout_etp);
                }
            } else if (parsePeriod == Period.min5) {
                if (!ae() || this.H0) {
                    relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.five_min_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.five_min_radio_layout_etp);
                }
            } else if (parsePeriod == period) {
                relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.fifteen_min_radio_layout);
            } else if (parsePeriod == Period.min30) {
                if (!ae() || this.H0) {
                    relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.thirty_min_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.thirty_min_radio_layout_etp);
                }
            } else if (parsePeriod == Period.min60) {
                relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.sixty_min_radio_layout);
            } else if (parsePeriod == Period.hour4) {
                relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.four_hour_radio_layout);
            } else if (parsePeriod == Period.day) {
                relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.one_day_radio_layout);
            } else if (parsePeriod == Period.week) {
                if (!ae() || this.H0) {
                    relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.one_week_radio_layout);
                } else {
                    relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.one_week_radio_layout_etp);
                }
            } else if (parsePeriod != Period.month) {
                relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.fifteen_min_radio_layout);
            } else if (!ae() || this.H0) {
                relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.one_month_radio_layout);
            } else {
                relativeLayout = (RelativeLayout) this.viewFinder.b(R$id.one_month_radio_layout_etp);
            }
            relativeLayout.setClickable(true);
            relativeLayout.performClick();
        }
    }

    public String qi(Intent intent) {
        return intent.getStringExtra("contractCode");
    }

    public String ri(Intent intent) {
        return intent.getStringExtra("contract_currency_symble");
    }

    public void s3(String str, String str2, KlineInfo klineInfo) {
        if (!isFinishing() && Period.day.value.equals(str2) && this.f23756w0.equals(str)) {
            double close = klineInfo.getClose() - klineInfo.getOpen();
            if (Double.compare(close, 0.0d) > 0) {
                this.f23744o.setTextColor(getResources().getColor(w.h()));
                this.f23726f.setTextColor(getResources().getColor(w.h()));
            } else if (Double.compare(close, 0.0d) < 0) {
                this.f23744o.setTextColor(getResources().getColor(w.d()));
                this.f23726f.setTextColor(getResources().getColor(w.d()));
            } else {
                TextView textView = this.f23744o;
                Resources resources = getResources();
                int i11 = R$color.color_flat;
                textView.setTextColor(resources.getColor(i11));
                this.f23726f.setTextColor(getResources().getColor(i11));
            }
            this.f23744o.setText(Sh(klineInfo.getOpen(), klineInfo.getClose()));
            if (!TradeType.isPro(this.D0)) {
                this.f23738l.setText(m.k(klineInfo.getHigh(), this.K0, true));
                this.f23732i.setText(m.k(klineInfo.getLow(), this.K0, true));
            }
            double close2 = klineInfo.getClose();
            Gi(klineInfo.getClose());
            this.f23750t0 = close2;
        }
    }

    public boolean si(Intent intent) {
        return intent.getBooleanExtra("market_grid", false);
    }

    public final int ti() {
        if (TradeType.isContract(this.D0)) {
            return td.i.a().b().z(this.B0);
        }
        if (TradeType.isSwap(this.D0)) {
            return td.i.a().b().B(this.f23760y0);
        }
        if (TradeType.isContractIndex(this.D0)) {
            return ContractIndexPrecisionUtil.a(this.B0);
        }
        if (TradeType.isOption(this.D0)) {
            return FuturePrecisionUtil.y(this.B0, this.f23762z0, this.C0);
        }
        if (TradeType.isLinearSwap(this.D0)) {
            return FuturePrecisionUtil.y(this.B0, this.f23762z0, this.C0);
        }
        if (TradeType.isLinearSwapIndex(this.D0)) {
            return FuturePrecisionUtil.b(((IndexCurrencyInfo) getIntent().getSerializableExtra("contract_currency_info")).getContractCode());
        }
        return PrecisionUtil.w(this.f23756w0, TradeType.valueOf(this.D0));
    }

    public void u(KlineInfo klineInfo) {
        double close = klineInfo.getClose();
        double d11 = this.f23750t0;
        if (d11 == 0.0d) {
            Gi(close);
        } else if (Double.compare(close, d11) > 0) {
            Gi(close);
        } else if (close < this.f23750t0) {
            Gi(close);
        }
        this.f23750t0 = close;
        if (TradeType.isOption(this.D0)) {
            if (a7.e.E(TradeType.valueOf(this.D0))) {
                this.f23730h.setText(m.c(m.L(String.valueOf(klineInfo.getAmount()), PrecisionUtil.u(this.f23756w0)), "--"));
                this.f23730h.append(((AbstractKlinePresenter) getPresenter()).T());
                return;
            }
            this.f23730h.setText(getString(R$string.contract_24h_num_value, new Object[]{m.k(klineInfo.getVol(), PrecisionUtil.t(this.f23756w0), true)}));
        } else if (TradeType.isLinearSwap(this.D0)) {
            if (a7.e.F(TradeType.valueOf(this.D0))) {
                this.f23730h.setText(m.T(String.valueOf(klineInfo.getAmount()), PrecisionUtil.u(this.f23756w0)));
            } else {
                this.f23730h.setText(m.T(String.valueOf(klineInfo.getVol()), PrecisionUtil.t(this.f23756w0)));
            }
            zi(klineInfo);
        } else if (TradeType.isContract(this.D0)) {
            if (a7.e.E(TradeType.CONTRACT)) {
                this.f23730h.setText(m.T(String.valueOf(klineInfo.getAmount()), PrecisionUtil.u(this.f23756w0)));
            } else {
                this.f23730h.setText(m.T(String.valueOf(klineInfo.getVol()), PrecisionUtil.t(this.f23756w0)));
            }
            zi(klineInfo);
        } else if (TradeType.isSwap(this.D0)) {
            if (a7.e.E(TradeType.SWAP)) {
                this.f23730h.setText(m.T(String.valueOf(klineInfo.getAmount()), PrecisionUtil.u(this.f23756w0)));
            } else {
                this.f23730h.setText(m.T(String.valueOf(klineInfo.getVol()), PrecisionUtil.t(this.f23756w0)));
            }
            zi(klineInfo);
        }
    }

    public String ui(Intent intent) {
        return intent.getStringExtra("optionCode");
    }

    public void v9(OptionMarketIndexInfo optionMarketIndexInfo) {
    }

    public String vi(Intent intent) {
        return intent.getStringExtra("symbolId");
    }

    public String wi(Intent intent) {
        String stringExtra = intent.getStringExtra("market_trade_type");
        return TextUtils.isEmpty(stringExtra) ? TradeType.PRO.toString() : stringExtra;
    }

    public final int xi() {
        if (TradeType.isContract(this.D0)) {
            if (a7.e.E(TradeType.CONTRACT)) {
                return td.i.a().b().t(this.B0);
            }
            return td.i.a().b().D(this.B0);
        } else if (TradeType.isSwap(this.D0)) {
            if (a7.e.E(TradeType.SWAP)) {
                return td.i.a().b().m(this.f23760y0);
            }
            return td.i.a().b().j(this.f23760y0);
        } else if (TradeType.isContractIndex(this.D0)) {
            return 0;
        } else {
            if (TradeType.isOption(this.D0)) {
                if (a7.e.E(TradeType.valueOf(this.D0))) {
                    return FuturePrecisionUtil.s(this.B0, this.f23762z0, this.C0);
                }
                return FuturePrecisionUtil.B();
            } else if (TradeType.isLinearSwap(this.D0)) {
                if (a7.e.F(TradeType.valueOf(this.D0))) {
                    return FuturePrecisionUtil.s(this.B0, this.f23762z0, this.C0);
                }
                return FuturePrecisionUtil.B();
            } else if (TradeType.isLinearSwapIndex(this.D0)) {
                return 0;
            } else {
                return PrecisionUtil.z(this.f23756w0);
            }
        }
    }

    public final void yi(String str) {
        String str2 = "--";
        if (!TextUtils.isEmpty(str)) {
            String str3 = null;
            if (TradeType.isContract(this.D0) || TradeType.isSwap(this.D0) || TradeType.isContractIndex(this.D0) || TradeType.isOption(this.D0) || TradeType.isLinearSwap(this.D0) || TradeType.isLinearSwapIndex(this.D0)) {
                str3 = td.i.a().b().v(str);
            } else if (this.D0 != null) {
                if (TextUtils.isEmpty(this.f23756w0) || !a1.v().D(this.f23756w0).equalsIgnoreCase("usdt")) {
                    str3 = td.i.a().b().l(str, this.f23756w0, TradeType.PRO);
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
        this.f23745p.setText(str2);
    }

    public final void zi(KlineInfo klineInfo) {
        if (this.f23736k != null) {
            this.f23736k.setText(m.T(BigDecimal.valueOf(klineInfo.getClose()).multiply(BigDecimal.valueOf(klineInfo.getAmount())).toPlainString(), this.L0));
        }
    }
}
