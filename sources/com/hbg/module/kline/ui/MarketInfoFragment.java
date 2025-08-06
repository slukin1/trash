package com.hbg.module.kline.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.component.kline.render.CandleStickRender;
import com.hbg.component.kline.shape.BSTShape;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.component.kline.utils.NumberKlineUtil;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.page.SmartRefreshHeader;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.ui.KlineCallbackUtil;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.hbg.core.bean.BSTInfo;
import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import com.hbg.lib.network.hbg.core.bean.KLineSymbolHistoryBean;
import com.hbg.lib.network.hbg.core.bean.KlineBottomBean;
import com.hbg.lib.network.hbg.core.bean.KlineContractBottomBean;
import com.hbg.lib.network.hbg.core.bean.KlineLabel;
import com.hbg.lib.network.hbg.core.bean.MarginTogetherMgtBean;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.lib.widgets.CommonTabLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.R$anim;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$color;
import com.hbg.module.kline.R$dimen;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.bean.IndexDetail;
import com.hbg.module.kline.bean.IndexIngredient;
import com.hbg.module.kline.enums.CommentSwitchEnum;
import com.hbg.module.kline.enums.CommunitySwitchEnum;
import com.hbg.module.kline.enums.SymbolTypeEnum;
import com.hbg.module.kline.presenter.AbstractKlinePresenter;
import com.hbg.module.kline.presenter.MarketInfoCapitalFlowPresenter;
import com.hbg.module.kline.presenter.MarketInfoCurrencyDetailPresenter;
import com.hbg.module.kline.presenter.MarketInfoDepthPresenter;
import com.hbg.module.kline.presenter.MarketInfoEtpDetailPresenter;
import com.hbg.module.kline.presenter.MarketInfoOrderPresenter;
import com.hbg.module.kline.presenter.MarketInfoTradesPresenter;
import com.hbg.module.kline.view.KLineIndexSelectorView;
import com.hbg.module.kline.view.KlineLabelView;
import com.hbg.module.kline.view.KlineTopBSTView;
import com.hbg.module.kline.view.KlineViewWrapper;
import com.hbg.module.kline.view.ViewHeightWrapper;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.huobi.store.AppConfigManager;
import com.huobi.trade.helper.EtpRiskHintUtil;
import com.huobi.view.AutoTextSizeLayout;
import com.huobi.view.drawable.BgColorDrawable;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityModuleConfig;
import com.huochat.community.base.CommunitySensorsEvent;
import com.huochat.community.enums.SymbolParamType;
import com.huochat.community.fragment.FragmentCommunityList;
import com.huochat.community.widget.CommunityDisclaimerBottomView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.youth.banner.config.BannerConfig;
import d7.a1;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

public class MarketInfoFragment extends AbstractKlineFragment implements View.OnClickListener {
    public Button A1;
    public TextView A2;
    public boolean A3;
    public Button B1;
    public LinearLayout B2;
    public c6.b<Intent> B3 = new w2(this);
    public Bundle C1;
    public LinearLayout C2;
    public CommonTabLayout.d C3 = new e();
    public LinearLayout D1;
    public ImageView D2;
    public String D3;
    public View E1;
    public TextView E2;
    public CommonSwitchButton F1;
    public ConstraintLayout F2;
    public View G1;
    public RelativeLayout G2;
    public KlineViewWrapper H1;
    public View H2;
    public DialogFragment I1;
    public View I2;
    public SmartRefreshLayout J1;
    public View J2;
    public SmartRefreshHeader K1;
    public RelativeLayout K2;
    public MarketInfoIndexIngredientsFragment L1;
    public RelativeLayout L2;
    public Fragment M1;
    public LinearLayout M2;
    public ImageView N1;
    public TextView N2;
    public LinearLayout O1;
    public TextView O2;
    public LinearLayout P1;
    public AppBarLayout P2;
    public LinearLayout Q1;
    public LinearLayout Q2;
    public LinearLayout R1;
    public boolean R2;
    public LinearLayout S1;
    public View S2;
    public LinearLayout T1;
    public NewSymbolCountDownLayout T2;
    public TextView U1;
    public Subscription U2;
    public TextView V1;
    public Set<BSTInfo.BSTInfoBean> V2 = new LinkedHashSet();
    public TextView W1;
    public CommonSwitchButton W2;
    public TextView X1;
    public CommonSwitchButton X2;
    public TextView Y1;
    public CommonSwitchButton Y2;
    public TextView Z1;
    public CommonSwitchButton Z2;

    /* renamed from: a2  reason: collision with root package name */
    public TextView f24015a2;

    /* renamed from: a3  reason: collision with root package name */
    public CommonSwitchButton f24016a3;

    /* renamed from: b2  reason: collision with root package name */
    public TextView f24017b2;

    /* renamed from: b3  reason: collision with root package name */
    public CommonSwitchButton f24018b3;

    /* renamed from: c2  reason: collision with root package name */
    public View f24019c2;

    /* renamed from: c3  reason: collision with root package name */
    public View f24020c3;

    /* renamed from: d2  reason: collision with root package name */
    public TextView f24021d2;

    /* renamed from: d3  reason: collision with root package name */
    public View f24022d3;

    /* renamed from: e2  reason: collision with root package name */
    public TextView f24023e2;

    /* renamed from: e3  reason: collision with root package name */
    public KlineTopBSTView f24024e3;

    /* renamed from: f2  reason: collision with root package name */
    public TextView f24025f2;

    /* renamed from: f3  reason: collision with root package name */
    public long f24026f3 = -1;

    /* renamed from: g2  reason: collision with root package name */
    public TextView f24027g2;

    /* renamed from: g3  reason: collision with root package name */
    public CandleStickRender.ReqDataStatus f24028g3 = CandleStickRender.ReqDataStatus.IDLE;

    /* renamed from: h2  reason: collision with root package name */
    public TextView f24029h2;

    /* renamed from: h3  reason: collision with root package name */
    public KlineInfo f24030h3;

    /* renamed from: i2  reason: collision with root package name */
    public TextView f24031i2;

    /* renamed from: i3  reason: collision with root package name */
    public View f24032i3;

    /* renamed from: j2  reason: collision with root package name */
    public TextView f24033j2;

    /* renamed from: j3  reason: collision with root package name */
    public View f24034j3;

    /* renamed from: k2  reason: collision with root package name */
    public TextView f24035k2;

    /* renamed from: k3  reason: collision with root package name */
    public View f24036k3;

    /* renamed from: l2  reason: collision with root package name */
    public LinearLayout f24037l2;

    /* renamed from: l3  reason: collision with root package name */
    public View f24038l3;

    /* renamed from: m2  reason: collision with root package name */
    public LinearLayout f24039m2;

    /* renamed from: m3  reason: collision with root package name */
    public LinearLayout f24040m3;

    /* renamed from: n2  reason: collision with root package name */
    public LinearLayout f24041n2;

    /* renamed from: n3  reason: collision with root package name */
    public TextView f24042n3;

    /* renamed from: o2  reason: collision with root package name */
    public int f24043o2;

    /* renamed from: o3  reason: collision with root package name */
    public TextView f24044o3;

    /* renamed from: p2  reason: collision with root package name */
    public SymbolParamType f24045p2 = SymbolParamType.SYMBOL;

    /* renamed from: p3  reason: collision with root package name */
    public TextView f24046p3;

    /* renamed from: q2  reason: collision with root package name */
    public CommentSwitchEnum f24047q2 = CommentSwitchEnum.HIDE;

    /* renamed from: q3  reason: collision with root package name */
    public TextView f24048q3;

    /* renamed from: r2  reason: collision with root package name */
    public CommunitySwitchEnum f24049r2 = CommunitySwitchEnum.HIDE;

    /* renamed from: r3  reason: collision with root package name */
    public TextView f24050r3;

    /* renamed from: s2  reason: collision with root package name */
    public CommunityDisclaimerBottomView f24051s2;

    /* renamed from: s3  reason: collision with root package name */
    public TextView f24052s3;

    /* renamed from: t1  reason: collision with root package name */
    public boolean f24053t1;

    /* renamed from: t2  reason: collision with root package name */
    public boolean f24054t2 = false;

    /* renamed from: t3  reason: collision with root package name */
    public TextView f24055t3;

    /* renamed from: u1  reason: collision with root package name */
    public KLineIndexSelectorView f24056u1;

    /* renamed from: u2  reason: collision with root package name */
    public boolean f24057u2 = false;

    /* renamed from: u3  reason: collision with root package name */
    public TextView f24058u3;

    /* renamed from: v1  reason: collision with root package name */
    public KlineLabelView f24059v1;

    /* renamed from: v2  reason: collision with root package name */
    public int f24060v2 = 0;

    /* renamed from: v3  reason: collision with root package name */
    public TextView f24061v3;

    /* renamed from: w1  reason: collision with root package name */
    public AutoTextSizeLayout f24062w1;

    /* renamed from: w2  reason: collision with root package name */
    public boolean f24063w2 = false;

    /* renamed from: w3  reason: collision with root package name */
    public TextView f24064w3;

    /* renamed from: x1  reason: collision with root package name */
    public CommonTabLayout f24065x1;

    /* renamed from: x2  reason: collision with root package name */
    public boolean f24066x2 = false;

    /* renamed from: x3  reason: collision with root package name */
    public TextView f24067x3;

    /* renamed from: y1  reason: collision with root package name */
    public CoordinatorLayout f24068y1;

    /* renamed from: y2  reason: collision with root package name */
    public FragmentCommunityList f24069y2;

    /* renamed from: y3  reason: collision with root package name */
    public Runnable f24070y3;

    /* renamed from: z1  reason: collision with root package name */
    public FrameLayout f24071z1;

    /* renamed from: z2  reason: collision with root package name */
    public ImageView f24072z2;

    /* renamed from: z3  reason: collision with root package name */
    public int f24073z3;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            MarketInfoFragment marketInfoFragment = MarketInfoFragment.this;
            marketInfoFragment.f23811m1 = false;
            marketInfoFragment.f23820q1 = true;
        }

        public void onAnimationStart(Animator animator) {
            MarketInfoFragment.this.f23811m1 = true;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            i6.i.b().g(this, 10000);
            MarketInfoFragment.this.il();
        }
    }

    public class c implements Func1<Observable<? extends Void>, Observable<?>> {

        public class a implements Func1<Void, Observable<?>> {
            public a() {
            }

            /* renamed from: a */
            public Observable<?> call(Void voidR) {
                return Observable.just(0).delay(30, TimeUnit.SECONDS);
            }
        }

        public c() {
        }

        /* renamed from: a */
        public Observable<?> call(Observable<? extends Void> observable) {
            return observable.flatMap(new a());
        }
    }

    public class d extends BaseSubscriber<BSTInfo> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(BSTInfo bSTInfo) {
            super.onNext(bSTInfo);
            if (bSTInfo != null) {
                long unused = MarketInfoFragment.this.f24026f3 = bSTInfo.getStartKline();
                if (bSTInfo.getKlineType() == MarketInfoFragment.this.K0.getPeriodIntType() && bSTInfo.getKlines() != null) {
                    MarketInfoFragment.this.showBST(bSTInfo.getKlines());
                }
            }
            CandleStickRender.ReqDataStatus unused2 = MarketInfoFragment.this.f24028g3 = CandleStickRender.ReqDataStatus.IDLE;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            CandleStickRender.ReqDataStatus unused = MarketInfoFragment.this.f24028g3 = CandleStickRender.ReqDataStatus.IDLE;
        }
    }

    public class e implements CommonTabLayout.d {
        public e() {
        }

        public void a(int i11, CommonTabLayout commonTabLayout) {
            MarketInfoFragment marketInfoFragment = MarketInfoFragment.this;
            marketInfoFragment.lm(marketInfoFragment.f24065x1, i11, MarketInfoFragment.this.f24065x1.getId() == commonTabLayout.getId());
            MarketInfoFragment.this.wm(i11, true);
            MarketInfoFragment.this.Im(i11);
        }
    }

    public class f implements FragmentCommunityList.RequestCallback {

        /* renamed from: a  reason: collision with root package name */
        public long f24080a = 0;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f24081b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animation f24082c;

        public f(long j11, Animation animation) {
            this.f24081b = j11;
            this.f24082c = animation;
        }

        public static /* synthetic */ void b(Animation animation) {
            if (animation != null) {
                animation.cancel();
            }
        }

        public void complate() {
            this.f24080a = 600 - ((System.currentTimeMillis() - this.f24081b) % 600);
            i6.i.b().g(new z3(this.f24082c), (int) this.f24080a);
        }

        public void pre() {
            this.f24080a = 0;
        }
    }

    public class g extends BaseSubscriber<EtpRebalInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SymbolBean f24084b;

        public g(SymbolBean symbolBean) {
            this.f24084b = symbolBean;
        }

        /* renamed from: a */
        public void onNext(EtpRebalInfo etpRebalInfo) {
            super.onNext(etpRebalInfo);
            MarketInfoFragment.this.ym(this.f24084b);
        }
    }

    public static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24086a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hbg.lib.network.pro.core.util.Period[] r0 = com.hbg.lib.network.pro.core.util.Period.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24086a = r0
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.timeline     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24086a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.min1     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24086a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.min5     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f24086a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.min15     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f24086a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.min30     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f24086a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.min60     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f24086a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.hour4     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f24086a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.day     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f24086a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.week     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f24086a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.hbg.lib.network.pro.core.util.Period r1 = com.hbg.lib.network.pro.core.util.Period.month     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.kline.ui.MarketInfoFragment.h.<clinit>():void");
        }
    }

    public class i extends AppBarLayout.Behavior.DragCallback {
        public i() {
        }

        public boolean canDrag(AppBarLayout appBarLayout) {
            return true;
        }
    }

    public class j implements vd.a {
        public j() {
        }

        public void b(int i11, long j11, long[] jArr) {
            if (jArr.length <= 0) {
                return;
            }
            if (jArr[0] <= 0) {
                MarketInfoFragment.this.T2.setDayVisible(false);
            } else {
                MarketInfoFragment.this.T2.setDayVisible(true);
            }
        }

        public void c(int i11) {
            MarketInfoFragment.this.T2.g();
            ViewUtil.m(MarketInfoFragment.this.T2, false);
            MarketInfoFragment.this.tm();
        }
    }

    public class k extends EasySubscriber<KlineContractBottomBean> {
        public k() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void c(KlineContractBottomBean klineContractBottomBean, View view) {
            BaseModuleConfig.a().k0(klineContractBottomBean.earnJumpUrl);
            HashMap hashMap = new HashMap();
            hashMap.put("pair", ((com.hbg.module.kline.presenter.a) MarketInfoFragment.this.yh()).l0());
            BaseModuleConfig.a().w("App_markets_kline_earn_click", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void d(View view) {
            BaseModuleConfig.a a11 = BaseModuleConfig.a();
            if (a11 != null) {
                a11.k0("holigeit://open/v1?login=1&url=ihuobiglobal://m.hbg.com/Contract/CopyTrading?index=0");
            }
            HashMap hashMap = new HashMap();
            hashMap.put("pair", ((com.hbg.module.kline.presenter.a) MarketInfoFragment.this.yh()).l0());
            BaseModuleConfig.a().w("App_markets_kline_follow_click", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* renamed from: e */
        public void onNext(KlineContractBottomBean klineContractBottomBean) {
            super.onNext(klineContractBottomBean);
            if (klineContractBottomBean != null) {
                ((ImageView) MarketInfoFragment.this.f67460i.b(R$id.image_view_market_bottom_trading_bot)).setImageResource(MarketInfoFragment.this.ni(R$attr.kline_contract_follow_button));
                ((TextView) MarketInfoFragment.this.f67460i.b(R$id.text_view_market_bottom_trading_bot)).setText(R$string.n_asset_contract_to_copy_trading);
                View b11 = MarketInfoFragment.this.f67460i.b(R$id.linear_layout_market_bottom_trading_bot);
                int i11 = 0;
                b11.setVisibility(klineContractBottomBean.followOrderIsShow ? 0 : 8);
                View b12 = MarketInfoFragment.this.f67460i.b(R$id.linear_layout_market_bottom_huobi_earn);
                if (!klineContractBottomBean.eranIsShow) {
                    i11 = 8;
                }
                b12.setVisibility(i11);
                if (klineContractBottomBean.eranIsShow && !TextUtils.isEmpty(klineContractBottomBean.earnJumpUrl)) {
                    b12.setOnClickListener(new b4(this, klineContractBottomBean));
                }
                if (klineContractBottomBean.followOrderIsShow && !TextUtils.isEmpty(klineContractBottomBean.followOrderJumpUrl)) {
                    b11.setOnClickListener(new a4(this));
                }
            }
        }
    }

    public class l implements Action1<HbgIntCodeResponse<Object>> {
        public l() {
        }

        /* renamed from: a */
        public void call(HbgIntCodeResponse<Object> hbgIntCodeResponse) {
        }
    }

    public class m extends EasySubscriber<KlineBottomBean> {
        public m() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void d(KlineBottomBean klineBottomBean, View view) {
            BaseModuleConfig.a().k0(klineBottomBean.earnJumpUrl);
            HashMap hashMap = new HashMap();
            hashMap.put("pair", ((com.hbg.module.kline.presenter.a) MarketInfoFragment.this.yh()).l0());
            BaseModuleConfig.a().w("App_markets_kline_earn_click", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void e(KlineBottomBean klineBottomBean, View view) {
            HBBaseWebActivity.showWebView(MarketInfoFragment.this.getActivity(), klineBottomBean.tradingBotJumpUrl, "", "", false);
            HashMap hashMap = new HashMap();
            hashMap.put("pair", ((com.hbg.module.kline.presenter.a) MarketInfoFragment.this.yh()).l0());
            BaseModuleConfig.a().w("App_markets_kline_tb_click", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void f(KlineBottomBean klineBottomBean, View view) {
            HBBaseWebActivity.showWebView(MarketInfoFragment.this.getActivity(), klineBottomBean.contracJumpUrl, "", "", false);
            HashMap hashMap = new HashMap();
            hashMap.put("pair", ((com.hbg.module.kline.presenter.a) MarketInfoFragment.this.yh()).l0());
            BaseModuleConfig.a().w("App_markets_kline_contract_click", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* renamed from: g */
        public void onNext(KlineBottomBean klineBottomBean) {
            super.onNext(klineBottomBean);
            if (klineBottomBean != null) {
                View b11 = MarketInfoFragment.this.f67460i.b(R$id.linear_layout_market_bottom_trading_bot);
                int i11 = 0;
                b11.setVisibility(klineBottomBean.tradingBotIsShow ? 0 : 8);
                View b12 = MarketInfoFragment.this.f67460i.b(R$id.linear_layout_market_bottom_huobi_earn);
                b12.setVisibility(klineBottomBean.eranIsShow ? 0 : 8);
                View b13 = MarketInfoFragment.this.f67460i.b(R$id.linear_layout_market_bottom_contract);
                if (!klineBottomBean.contracIsShow) {
                    i11 = 8;
                }
                b13.setVisibility(i11);
                if (klineBottomBean.eranIsShow && !TextUtils.isEmpty(klineBottomBean.earnJumpUrl)) {
                    b12.setOnClickListener(new e4(this, klineBottomBean));
                }
                if (klineBottomBean.tradingBotIsShow && !TextUtils.isEmpty(klineBottomBean.tradingBotJumpUrl)) {
                    b11.setOnClickListener(new c4(this, klineBottomBean));
                }
                if (klineBottomBean.contracIsShow && !TextUtils.isEmpty(klineBottomBean.contracJumpUrl)) {
                    b13.setOnClickListener(new d4(this, klineBottomBean));
                }
            }
        }
    }

    public class n implements KLineIndexSelectorView.a {
        public n() {
        }

        public void a(int i11) {
            if (MarketInfoFragment.this.H1 != null) {
                MarketInfoFragment.this.H1.setMasterIndex(i11);
                ConfigPreferences.k("user_config", "config_target_top_20221026", i11);
                KLineHelper.g(i11);
            }
        }

        public void b(LinkedHashSet<String> linkedHashSet) {
            MarketInfoFragment.this.lj(linkedHashSet);
            KLineHelper.h(linkedHashSet);
        }
    }

    public class o implements KLineHelper.a {
        public o() {
        }

        public void a(LinkedHashSet<String> linkedHashSet) {
            if (MarketInfoFragment.this.f24056u1 != null) {
                MarketInfoFragment.this.f24056u1.setCurrentSlaveChartIndex(linkedHashSet);
            }
        }

        public void b(int i11) {
            if (MarketInfoFragment.this.f24056u1 != null) {
                MarketInfoFragment.this.f24056u1.setCurrentMasterChartIndex(i11);
            }
        }
    }

    public class p extends AnimatorListenerAdapter {
        public p() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            boolean unused = MarketInfoFragment.this.A3 = false;
            if (MarketInfoFragment.this.N1.isSelected()) {
                MarketInfoFragment marketInfoFragment = MarketInfoFragment.this;
                marketInfoFragment.qm(marketInfoFragment.f24037l2, MarketInfoFragment.this.f24039m2, MarketInfoFragment.this.f24041n2);
                MarketInfoFragment marketInfoFragment2 = MarketInfoFragment.this;
                marketInfoFragment2.qm(marketInfoFragment2.P1, MarketInfoFragment.this.Q1, MarketInfoFragment.this.R1);
                MarketInfoFragment.this.vm();
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            boolean unused = MarketInfoFragment.this.A3 = true;
            if (8 == MarketInfoFragment.this.O1.getVisibility()) {
                MarketInfoFragment.this.O1.setVisibility(0);
            }
        }
    }

    public class q extends AnimatorListenerAdapter {
        public q() {
        }

        public void onAnimationEnd(Animator animator) {
            MarketInfoFragment marketInfoFragment = MarketInfoFragment.this;
            marketInfoFragment.f23811m1 = false;
            marketInfoFragment.f23820q1 = false;
        }

        public void onAnimationStart(Animator animator) {
            MarketInfoFragment.this.f23811m1 = true;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Al(View view) {
        if (this.f23808l1 || this.f23814n1) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (this.f23816o1) {
            pj(false);
        } else if (this.f23818p1) {
            uj(false);
        } else if (!this.A3) {
            if (this.N1.isSelected()) {
                Zk(150, 180.0f, 0.0f, this.f24073z3, 0, new LinearOutSlowInInterpolator());
            } else {
                Zk(170, 0.0f, 180.0f, 0, this.f24073z3, new FastOutLinearInInterpolator());
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bl(View view) {
        if (this.A2.getMaxLines() == 1) {
            this.A2.setSingleLine(false);
            this.f24072z2.setSelected(true);
        } else {
            this.A2.setSingleLine(true);
            this.f24072z2.setSelected(false);
        }
        this.Q2.requestLayout();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Cl(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_SYMBOL", this.L0);
        HbgRouter.i(getActivity(), "/trade/grid", bundle);
        getActivity().finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Dl(View view) {
        Intent intent = new Intent(getActivity(), MarketInfoLandscapeActivity.class);
        intent.putExtras(getActivity().getIntent().getExtras());
        startActivity(intent);
        td.i.a().b().d("4649", (Map<String, Object>) null, qi());
        BaseModuleConfig.a().w("App_markets_kline_fullscn_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void El(boolean z11, View view) {
        int i11 = 1;
        if (!z11) {
            BaseModuleConfig.a().J(getActivity(), 1);
        } else {
            List<BSTInfo.Trade> trades = ((BSTInfo.BSTInfoBean) this.f24030h3.extraInfoBean).getTrades();
            int i12 = 0;
            BSTInfo.Trade trade = (trades == null || trades.size() == 0) ? null : trades.get(0);
            if (TradeType.isContract(this.S0)) {
                BaseModuleConfig.a a11 = BaseModuleConfig.a();
                Context context = view.getContext();
                String str = this.f23797g1;
                if (trade != null) {
                    i12 = trade.getOrderType();
                }
                a11.A(context, str, i12, this.O0, 1);
            } else if (TradeType.isSwap(this.S0)) {
                BaseModuleConfig.a a12 = BaseModuleConfig.a();
                Activity activity = (Activity) view.getContext();
                String str2 = this.L0;
                if (trade != null) {
                    i12 = trade.getOrderType();
                }
                a12.E(activity, str2, i12, 1);
            } else if (TradeType.isLinearSwap(this.S0)) {
                BaseModuleConfig.a a13 = BaseModuleConfig.a();
                Activity activity2 = (Activity) view.getContext();
                String str3 = this.f23797g1;
                if (trade != null) {
                    i12 = trade.getOrderType();
                }
                int i13 = i12;
                if (trade != null) {
                    i11 = trade.getOrderModel();
                }
                a13.g0(activity2, str3, i13, i11, this.Q0, this.O0, 1);
            } else {
                BaseModuleConfig.a().r((Activity) view.getContext(), this.f23797g1, 0);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit Fl(KLineSymbolHistoryBean kLineSymbolHistoryBean) {
        String str;
        if (kLineSymbolHistoryBean == null || getActivity() == null || getActivity().isFinishing()) {
            return null;
        }
        this.f24038l3.setVisibility(0);
        this.f24040m3.setVisibility(0);
        this.f24056u1.setBackgroundColor(com.hbg.module.libkt.base.ext.b.o(getActivity(), R$attr.kline_content_background_color));
        TextView textView = this.f24042n3;
        if (com.hbg.lib.core.util.p.i(getActivity())) {
            str = "24時";
        } else {
            str = com.hbg.lib.core.util.p.h(getActivity()) ? "24时" : "24H";
        }
        textView.setText(str);
        this.f24044o3.setText(com.hbg.lib.core.util.p.h(getActivity()) ? "7天" : "7D");
        jl(this.f24046p3, kLineSymbolHistoryBean.rate7day);
        this.f24048q3.setText(com.hbg.lib.core.util.p.h(getActivity()) ? "14天" : "14D");
        jl(this.f24050r3, kLineSymbolHistoryBean.rate14day);
        this.f24052s3.setText(com.hbg.lib.core.util.p.h(getActivity()) ? "30天" : "30D");
        jl(this.f24055t3, kLineSymbolHistoryBean.rate30day);
        this.f24058u3.setText(com.hbg.lib.core.util.p.h(getActivity()) ? "60天" : "60D");
        jl(this.f24061v3, kLineSymbolHistoryBean.rate60day);
        this.f24064w3.setText(com.hbg.lib.core.util.p.h(getActivity()) ? "1年" : "1Y");
        jl(this.f24067x3, kLineSymbolHistoryBean.rate1year);
        return null;
    }

    public static /* synthetic */ Unit Gl(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        return null;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Hl(View view) {
        if ((getActivity() instanceof MarketInfoActivity) && !getActivity().isFinishing()) {
            ((MarketInfoActivity) getActivity()).Sh();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Il(int i11, int i12, List list) {
        if (this.f24028g3 == CandleStickRender.ReqDataStatus.IDLE && list != null && list.size() > 100) {
            if ((this.f24026f3 <= 0 && i11 > (list.size() - 100) + 10) || this.f24026f3 + (Period.getInterval(this.K0) * 10) > ((KlineInfo) list.get(i11)).getTimeMs()) {
                Xk();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jl() {
        if (getActivity().getIntent().getBooleanExtra("kline_show_info", false)) {
            um(false);
            this.f24065x1.q(4, true);
            zm(MarketInfoDepthFragment.class, this.C1);
        }
        Dm();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Kl() {
        ((AppBarLayout.Behavior) ((CoordinatorLayout.LayoutParams) this.P2.getLayoutParams()).f()).setDragCallback(new i());
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ll(View view) {
        String str = "btcusdt";
        try {
            if (TradeType.isContract(this.S0)) {
                str = (((ContractCurrencyInfo) getActivity().getIntent().getSerializableExtra("contract_currency_info")).getSymbol() + "USDT").toLowerCase(Locale.US);
            } else if (TradeType.isSwap(this.S0)) {
                str = (((SwapCurrencyInfo) getActivity().getIntent().getSerializableExtra("contract_currency_info")).getSymbol() + "USDT").toLowerCase(Locale.US);
            } else if (TradeType.isLinearSwap(this.S0)) {
                str = (((FutureContractInfo) getActivity().getIntent().getSerializableExtra("contract_currency_info")).getSymbol() + "USDT").toLowerCase(Locale.US);
            }
        } catch (Throwable unused) {
        }
        td.i.a().b().p(this, (ContractCurrencyInfo) null, (SwapCurrencyInfo) null, (FutureContractInfo) null, TradeType.PRO.toString(), str, true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ml(DialogFragment dialogFragment, View view) {
        dialogFragment.dismiss();
        um(false);
        this.f24065x1.q(4, true);
        zm(MarketInfoEtpChangeFragment.class, this.C1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void Nl(View view) {
        int f11 = (i6.n.f(BaseApplication.b()) * 1) / 2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (view.getHeight() > f11) {
            layoutParams.height = f11;
        }
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ol(View view) {
        View inflate = LayoutInflater.from(BaseApplication.b()).inflate(R$layout.dialog_etp_explain, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.explain_tv);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        SymbolBean J = a1.v().J(this.L0, TradeType.PRO);
        boolean z11 = false;
        HBDialogFragment j02 = new DialogUtils.b.d(getActivity()).i1(4).c1(getString(R$string.n_trade_etp_up_down_explain)).P0(getString(R$string.n_known)).Q0(ad.b.f3517a).q0(false).I0(inflate).j0();
        if (i6.m.a(J.getEtpLeverageRatio()).compareTo(BigDecimal.ZERO) < 0) {
            z11 = true;
        }
        textView.setText(EtpRiskHintUtil.b(BaseApplication.b(), z11, i6.m.a(J.getEtpLeverageRatio()).abs().toPlainString(), StringUtils.i(EtpRiskHintUtil.c(J.getBaseCurrency())), new q2(this, j02)));
        j02.show(getActivity().getSupportFragmentManager(), "");
        inflate.post(new b3(inflate));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Pl(SymbolBean symbolBean, View view) {
        td.i.a().b().p(this, (ContractCurrencyInfo) null, (SwapCurrencyInfo) null, (FutureContractInfo) null, TradeType.PRO.toString(), symbolBean.getSymbol(), true);
        BaseModuleConfig.a().w("App_markets_kline_level_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ql(SymbolBean symbolBean, View view) {
        td.i.a().b().i(zh(), symbolBean.getSymbol(), true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Rl(View view) {
        td.i.a().b().f(getActivity(), this.L0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Sl() {
        qm(this.f24037l2, this.f24039m2, this.f24041n2);
        qm(this.P1, this.Q1, this.R1);
        String d11 = ConfigPreferences.d("user_config", "OPTION_INFO_SP");
        if (TextUtils.isEmpty(this.R0) || !d11.equals(this.R0)) {
            vm();
            this.O1.setVisibility(8);
        } else {
            ViewGroup.LayoutParams layoutParams = this.O1.getLayoutParams();
            layoutParams.height = -2;
            this.O1.setLayoutParams(layoutParams);
            this.N1.setSelected(true);
            this.N1.setRotation(180.0f);
            this.O1.setVisibility(0);
            vm();
        }
        ConfigPreferences.m("user_config", "OPTION_INFO_SP", "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Tl(Intent intent) {
        if (getActivity() != null) {
            Intent intent2 = new Intent(getActivity(), MarketInfoRestartActivity.class);
            intent2.putExtra("extra_intent", intent);
            startActivity(intent2);
            getActivity().overridePendingTransition(R$anim.fade_in, R$anim.fade_out);
            getActivity().finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ul() {
        this.f24056u1.d(getActivity(), !TextUtils.isEmpty(this.H1.getSlaveIndex1()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vl(ViewGroup viewGroup, ViewGroup viewGroup2, ViewGroup viewGroup3) {
        viewGroup.measure(0, 0);
        viewGroup2.measure(0, 0);
        viewGroup3.measure(0, 0);
        int measuredWidth = viewGroup.getMeasuredWidth();
        int measuredWidth2 = viewGroup2.getMeasuredWidth();
        int measuredWidth3 = viewGroup3.getMeasuredWidth();
        if (measuredWidth != measuredWidth2 || measuredWidth != measuredWidth3) {
            int max = Math.max(Math.max(measuredWidth, measuredWidth2), measuredWidth3);
            if (this.f24043o2 == 0) {
                if (getActivity() != null) {
                    this.f24043o2 = (getActivity().getWindowManager().getDefaultDisplay().getWidth() - DimenUtils.a(80.0f)) / 2;
                } else {
                    return;
                }
            }
            int i11 = this.f24043o2;
            if (max > i11) {
                max = i11;
            }
            int i12 = max + 1;
            sm(viewGroup, i12);
            sm(viewGroup2, i12);
            sm(viewGroup3, i12);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wl(TextView textView, TextView textView2) {
        this.S1.requestLayout();
        this.T1.requestLayout();
        if (textView.getHeight() != textView2.getHeight()) {
            textView2.setHeight(textView.getHeight());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xl() {
        if (getActivity() != null) {
            getActivity().finish();
            Intent intent = new Intent(getActivity(), MarketInfoActivity.class);
            intent.putExtras(getActivity().getIntent().getExtras());
            startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yl() {
        this.O1.measure(0, 0);
        this.f24073z3 = this.O1.getMeasuredHeight();
        Yk();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void am(View view) {
        HBBaseWebActivity.showWebView(getActivity(), td.i.a().b().r(), "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void bm(View view) {
        um(false);
        this.f24065x1.q(4, true);
        zm(MarketInfoEtpChangeFragment.class, this.C1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void cm() {
        if (this.A2.getLineCount() > 1) {
            this.f24072z2.setVisibility(0);
            this.A2.setSingleLine(true);
            this.Q2.requestLayout();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void dm(KlineLabel klineLabel) {
        if (this.f24059v1 != null) {
            List<KlineLabel.LabelBean> labelList = klineLabel.getLabelList();
            if (labelList == null || labelList.size() <= 0) {
                ((RelativeLayout.LayoutParams) this.f24062w1.getLayoutParams()).topMargin = (int) getResources().getDimension(R$dimen.dimen_2);
                this.f24062w1.requestLayout();
                this.f24059v1.setVisibility(8);
                return;
            }
            this.f24059v1.setData(labelList);
            ((RelativeLayout.LayoutParams) this.f24062w1.getLayoutParams()).topMargin = (int) getResources().getDimension(R$dimen.dimen_0);
            this.f24062w1.requestLayout();
        }
    }

    public static /* synthetic */ void em(APIStatusErrorException aPIStatusErrorException) {
    }

    public static /* synthetic */ void fm(Throwable th2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gm(boolean z11, boolean z12) {
        this.f24066x2 = z12;
        boolean z13 = true;
        if (!this.f24054t2 || !this.f24063w2) {
            this.f24057u2 = false;
            this.f24051s2.setAnimVisibility(false);
            return;
        }
        if (!z11 || !z12) {
            z13 = false;
        }
        this.f24057u2 = z13;
        this.f24051s2.setAnimVisibility(z13);
    }

    public static MarketInfoFragment hm(String str, String str2, boolean z11) {
        MarketInfoFragment marketInfoFragment = new MarketInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("symbleId", str);
        bundle.putString("tradeType", str2);
        bundle.putBoolean("isShowPK", z11);
        marketInfoFragment.setArguments(bundle);
        return marketInfoFragment;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ml(ky.j jVar) {
        MarketInfoCurrencyDetailPresenter marketInfoCurrencyDetailPresenter;
        if (!TradeType.isIndex(this.S0)) {
            cl();
            bl();
            td.i.a().b().k(this.S0);
        }
        ((com.hbg.module.kline.presenter.a) yh()).onResume();
        Fragment fragment = this.M1;
        if (fragment instanceof MarketInfoOrderFragment) {
            MarketInfoOrderPresenter marketInfoOrderPresenter = (MarketInfoOrderPresenter) ((MarketInfoOrderFragment) fragment).yh();
            if (marketInfoOrderPresenter != null) {
                marketInfoOrderPresenter.r0();
            }
        } else if (fragment instanceof MarketInfoDepthFragment) {
            MarketInfoDepthPresenter marketInfoDepthPresenter = (MarketInfoDepthPresenter) ((MarketInfoDepthFragment) fragment).yh();
            if (marketInfoDepthPresenter != null) {
                marketInfoDepthPresenter.k0();
            }
        } else if (fragment instanceof MarketInfoTradesFragment) {
            MarketInfoTradesPresenter marketInfoTradesPresenter = (MarketInfoTradesPresenter) ((MarketInfoTradesFragment) fragment).yh();
            if (marketInfoTradesPresenter != null) {
                marketInfoTradesPresenter.z0();
            }
        } else if (fragment instanceof MarketInfoEtpDetailFragment) {
            MarketInfoEtpDetailPresenter marketInfoEtpDetailPresenter = (MarketInfoEtpDetailPresenter) ((MarketInfoEtpDetailFragment) fragment).yh();
            if (marketInfoEtpDetailPresenter != null) {
                marketInfoEtpDetailPresenter.d0();
            }
        } else if ((fragment instanceof MarketInfoCurrencyDetailFragment) && (marketInfoCurrencyDetailPresenter = (MarketInfoCurrencyDetailPresenter) ((MarketInfoCurrencyDetailFragment) fragment).yh()) != null) {
            marketInfoCurrencyDetailPresenter.m0();
        }
        this.J1.finishRefresh();
        pj(false);
        uj(false);
        el();
        if (ae() && this.B2 != null) {
            Am();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void nl(View view) {
        if (this.f23808l1 || this.f23814n1) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        uj(!this.f23818p1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ol(View view) {
        if (this.f23808l1 || this.f23814n1 || this.f23811m1) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        pj(!this.f23816o1);
        td.i.a().b().b("4231", (Map<String, Object>) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean pl(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.f23816o1) {
                pj(false);
                return true;
            } else if (this.f23818p1) {
                uj(false);
                return true;
            } else if (this.f23820q1) {
                el();
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ql(View view, int i11, int i12, int i13, int i14) {
        if (this.f23816o1) {
            pj(false);
        }
        if (this.f23818p1) {
            uj(false);
        }
        if (this.f23820q1) {
            el();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void rl(View view) {
        boolean z11 = !ConfigPreferences.c("user_config", "KLINE_CONFIG_COUNTDOWN_SWITCH", false);
        this.f24018b3.setChecked(z11);
        ConfigPreferences.n("user_config", "KLINE_CONFIG_COUNTDOWN_SWITCH", z11);
        this.H1.p(z11);
        if (this.f24020c3.getVisibility() == 0) {
            this.f24020c3.setVisibility(8);
            this.f24022d3.setVisibility(8);
            ConfigPreferences.n("user_config", "SP_KEY_SHOW_RED_POINT", false);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "KlineCountdown");
        hashMap.put("status", z11 ? "Open" : "Close");
        BaseModuleConfig.a().w("appClick_Kline", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @Keep
    public void showBST(List<BSTInfo.BSTInfoBean> list) {
        this.V2.removeAll(list);
        this.V2.addAll(list);
        xm(this.V2);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sl(View view) {
        boolean z11 = !ConfigPreferences.c("user_config", "KLINE_CONFIG_CANG_SWITCH", true);
        this.Y2.setChecked(z11);
        ConfigPreferences.n("user_config", "KLINE_CONFIG_CANG_SWITCH", z11);
        ((com.hbg.module.kline.presenter.a) yh()).t0(z11, ConfigPreferences.c("user_config", "KLINE_CONFIG_LIQUIDATION_SWITCH", true));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void tl(View view) {
        boolean z11 = !ConfigPreferences.c("user_config", "KLINE_CONFIG_LIQUIDATION_SWITCH", true);
        this.Z2.setChecked(z11);
        ConfigPreferences.n("user_config", "KLINE_CONFIG_LIQUIDATION_SWITCH", z11);
        ((com.hbg.module.kline.presenter.a) yh()).t0(ConfigPreferences.c("user_config", "KLINE_CONFIG_CANG_SWITCH", true), z11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ul(View view) {
        boolean c11 = true ^ ConfigPreferences.c("user_config", "KLINE_CONFIG_OPENORDERS_SWITCH", true);
        this.f24016a3.setChecked(c11);
        ConfigPreferences.n("user_config", "KLINE_CONFIG_OPENORDERS_SWITCH", c11);
        ((com.hbg.module.kline.presenter.a) yh()).s0(c11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void vl(View view) {
        boolean c11 = true ^ ConfigPreferences.c("user_config", "KLINE_CONFIG_FIXY_SWITCH", true);
        this.X2.setChecked(c11);
        ConfigPreferences.n("user_config", "KLINE_CONFIG_FIXY_SWITCH", c11);
        this.H1.z(c11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void wl(View view) {
        boolean z11 = !ConfigPreferences.c("user_config", "KLINE_CONFIG_BST_SWITCH", true);
        this.W2.setChecked(z11);
        ConfigPreferences.n("user_config", "KLINE_CONFIG_BST_SWITCH", z11);
        if (z11) {
            if (this.V2.size() > 0) {
                xm(this.V2);
            } else {
                Xk();
            }
            Zl(this.f24030h3, true);
        } else {
            Subscription subscription = this.U2;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.H1.l((List<BSTShape>) null, (List<BSTShape>) null, (List<BSTShape>) null);
            KlineTopBSTView klineTopBSTView = this.f24024e3;
            if (klineTopBSTView != null) {
                klineTopBSTView.setData((List<BSTInfo.Trade>) null);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("kline_switch_orderhistory", z11 ? "on" : "off");
        BaseModuleConfig.a().w("App_markets_kline_orderhistory_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xl(View view) {
        Object obj;
        dl(true);
        HashMap hashMap = new HashMap();
        Bundle extras = getActivity().getIntent().getExtras();
        if (!(extras == null || (obj = extras.get("from")) == null)) {
            hashMap.put("from", obj);
        }
        td.i.a().b().d("3363", (Map<String, Object>) null, qi());
        hashMap.put("TransPair_current_id", this.L0);
        hashMap.put("markets_kline_class", pi());
        BaseModuleConfig.a().w("App_markets_kline_targe_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void yl(View view) {
        td.i.a().b().b("4233", (Map<String, Object>) null);
        Intent intent = new Intent(getActivity(), MarketInfoLandscapeActivity.class);
        intent.putExtras(getActivity().getIntent().getExtras());
        intent.putExtra("kline_draw_bundle_key", true);
        startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void zl(View view) {
        CommonSwitchButton commonSwitchButton = this.F1;
        commonSwitchButton.b(!commonSwitchButton.isChecked(), true);
        pj(false);
        i6.i.b().g(new c3(this), 240);
        HashMap hashMap = new HashMap(1);
        hashMap.put("select", Integer.valueOf(this.F1.isChecked() ? 1 : 0));
        td.i.a().b().b("4232", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void Ah() {
        super.Ah();
        this.J1.d0(new n3(this));
        this.f23784a0.setOnClickListener(new y3(this));
        this.O.setOnClickListener(new e2(this));
        this.D1.setOnTouchListener(new v2(this));
        if (Build.VERSION.SDK_INT >= 23) {
            this.f24068y1.setOnScrollChangeListener(new u2(this));
        }
        this.P.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.X.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.F2.setOnClickListener(this);
        this.f24018b3.setOnClickListener(new u3(this));
        this.Y2.setOnClickListener(new x3(this));
        this.Z2.setOnClickListener(new j2(this));
        this.f24016a3.setOnClickListener(new k2(this));
        this.X2.setOnClickListener(new p2(this));
        this.W2.setOnClickListener(new m2(this));
        this.K2.setOnClickListener(this);
        this.L2.setOnClickListener(this);
        this.I2.setOnClickListener(this);
        if (ae()) {
            this.J2.setOnClickListener(this);
        }
        ImageView imageView = this.f23812n;
        if (imageView != null) {
            imageView.setClickable(true);
            this.f23812n.setOnClickListener(this);
        }
        this.A1.setOnClickListener(new h2(this));
        if (!TradeType.isContractIndex(this.S0) && !TradeType.isLinearSwapIndex(this.S0)) {
            this.f24065x1.setCallback(this.C3);
            if (ae()) {
                wm(1, false);
            } else {
                wm(0, false);
            }
        }
        this.E1.setOnClickListener(new k3(this));
        this.F1.b(KLineHelper.f(), false);
        this.F1.setOnClickListener(new f2(this));
        this.N1.setOnClickListener(new d2(this));
        ImageView imageView2 = this.f24072z2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new z2(this));
        }
        this.B1.setOnClickListener(new i2(this));
        this.f23795f1.setOnClickListener(new l2(this));
        this.f24056u1.setOnKLineSelectorChangeListener(new n());
        mm();
    }

    public boolean Ai() {
        return false;
    }

    public final void Am() {
        SymbolBean J = a1.v().J(this.L0, TradeType.PRO);
        if (J != null) {
            ym(J);
            this.B2.post(new e3(this));
            x7.d.c(J.getBaseCurrency(), false).compose(RxJavaHelper.t(zh())).subscribe(new g(J));
        }
    }

    public void Bm(String str) {
        v7.b.a().getKlineLabel(str).b().compose(RxJavaHelper.t(zh())).subscribe(q6.d.d(zh(), new o3(this), p3.f24252b, q3.f24259b));
    }

    public final void Cm() {
        int i11 = 0;
        if (Ai()) {
            aj(false);
            cj(true);
            Fm();
        }
        this.f23790d0.setTextColor(si());
        q5.a.g().q(this.P0);
        ((com.hbg.module.kline.presenter.a) yh()).r0(false);
        this.H1.setSymbolId(this.P0);
        KLineHelper.j(this.L0, false);
        this.R2 = false;
        this.f23790d0.setText(R$string.n_kline_net_worth);
        ((com.hbg.module.kline.presenter.a) yh()).r0(true);
        this.H1.setSlaveIndex1("");
        this.f24056u1.d(getActivity(), true ^ TextUtils.isEmpty(this.H1.getSlaveIndex1()));
        this.f23826t0.setVisibility(TextUtils.isEmpty(this.H1.getSlaveIndex1()) ? 8 : 0);
        View view = this.f23828u0;
        if (!TextUtils.isEmpty(this.H1.getSlaveIndex1())) {
            i11 = 8;
        }
        view.setVisibility(i11);
    }

    public final void Dm() {
        int i11 = 0;
        if (Ai()) {
            aj(false);
            cj(true);
            Fm();
        }
        this.f23790d0.setTextColor(si());
        q5.a.g().q(this.L0);
        ((com.hbg.module.kline.presenter.a) yh()).r0(false);
        this.H1.setSymbolId(this.L0);
        KLineHelper.j(this.L0, true);
        this.R2 = true;
        this.f23790d0.setText(R$string.n_kline_exch);
        ((com.hbg.module.kline.presenter.a) yh()).r0(true);
        this.H1.setSlaveIndex1("VOL");
        this.f24056u1.d(getActivity(), true ^ TextUtils.isEmpty(this.H1.getSlaveIndex1()));
        this.f23826t0.setVisibility(TextUtils.isEmpty(this.H1.getSlaveIndex1()) ? 8 : 0);
        View view = this.f23828u0;
        if (!TextUtils.isEmpty(this.H1.getSlaveIndex1())) {
            i11 = 8;
        }
        view.setVisibility(i11);
    }

    public final void Em() {
        if (!this.f23820q1) {
            vj(false, (Animator.AnimatorListener) null);
            qj(false, (Animator.AnimatorListener) null);
            ji(this.H2, this.I2, this.J2, new a());
        }
    }

    public final void Fm() {
        switch (h.f24086a[this.K0.ordinal()]) {
            case 2:
                this.F.setTextColor(si());
                nj(this.R);
                return;
            case 3:
                this.G.setTextColor(si());
                nj(this.S);
                return;
            case 4:
                this.H.setTextColor(si());
                nj(this.T);
                return;
            case 5:
                this.I.setTextColor(si());
                nj(this.U);
                return;
            case 6:
                this.J.setTextColor(si());
                nj(this.V);
                return;
            case 7:
                this.K.setTextColor(si());
                nj(this.W);
                return;
            case 8:
                this.L.setTextColor(si());
                nj(this.X);
                return;
            case 9:
                this.M.setTextColor(si());
                nj(this.Y);
                return;
            case 10:
                this.N.setTextColor(si());
                nj(this.Z);
                return;
            default:
                this.D.setTextColor(si());
                nj(this.Q);
                return;
        }
    }

    public final void Gm() {
        if (!this.f23811m1) {
            if (!this.f23820q1) {
                this.K2.setSelected(this.R2);
                this.L2.setSelected(!this.R2);
                Em();
                return;
            }
            el();
        }
    }

    public final void Hm(String str) {
        this.A1.setEnabled(true);
        this.A1.setText(getString(R$string.n_otc_card_trade));
        this.A1.setBackground(new BgColorDrawable(getResources().getColor(R$color.baseColorMajorTheme100), getResources().getDimension(R$dimen.dimen_4)));
    }

    public final void Im(int i11) {
        if (TradeType.isIndex(this.S0)) {
            if (i11 == 0) {
                zm(MarketInfoIndexIngredientsFragment.class, this.C1);
            } else if (i11 == 1) {
                zm(MarketInfoIndexIntroFragment.class, this.C1);
            }
        } else if (!td.f.b(this.L0, this.S0) || this.f24049r2 != CommunitySwitchEnum.SHOW) {
            if (i11 == 0) {
                zm(MarketInfoOrderFragment.class, this.C1);
            } else if (i11 == 1) {
                zm(MarketInfoDepthFragment.class, this.C1);
                td.i.a().b().d("4653", (Map<String, Object>) null, qi());
            } else if (i11 == 2) {
                zm(MarketInfoTradesFragment.class, this.C1);
                td.i.a().b().d("4654", (Map<String, Object>) null, qi());
            } else if (i11 == 3) {
                zm(MarketInfoCapitalFlowFragment.class, this.C1);
                HashMap hashMap = new HashMap();
                hashMap.put("TransPair_current_id", ((com.hbg.module.kline.presenter.a) yh()).l0());
                BaseModuleConfig.a().w("App_markets_capital_click", hashMap);
            } else if (i11 == 4) {
                zm(MarketInfoEtpChangeFragment.class, this.C1);
            }
        } else if (i11 == 0) {
            zm(FragmentCommunityList.class, this.C1);
            td.i.a().b().d("5244", (Map<String, Object>) null, "1005005");
            BaseModuleConfig.a().w("App_markets_kline_tab_community_click", (HashMap) null);
        } else if (i11 == 1) {
            zm(MarketInfoDepthFragment.class, this.C1);
            td.i.a().b().d("4653", (Map<String, Object>) null, qi());
            BaseModuleConfig.a().w("App_markets_kline_tab_unsetet_click", (HashMap) null);
        } else if (i11 == 2) {
            zm(MarketInfoTradesFragment.class, this.C1);
            td.i.a().b().d("4654", (Map<String, Object>) null, qi());
            BaseModuleConfig.a().w("App_markets_kline_tab_compsetet_click", (HashMap) null);
        } else if (i11 == 3) {
            zm(MarketInfoCapitalFlowFragment.class, this.C1);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("TransPair_current_id", ((com.hbg.module.kline.presenter.a) yh()).l0());
            BaseModuleConfig.a().w("App_markets_capital_click", hashMap2);
        } else if (i11 != 4) {
            if (i11 == 5) {
                zm(MarketInfoEtpChangeFragment.class, this.C1);
            }
        } else if (ae()) {
            zm(MarketInfoEtpDetailFragment.class, this.C1);
        } else {
            zm(MarketInfoCurrencyDetailFragment.class, this.C1);
            BaseModuleConfig.a().w("App_markets_kline_tab_info_click", (HashMap) null);
        }
    }

    public void K(List<?> list, int i11) {
        KlineViewWrapper klineViewWrapper = this.H1;
        if (klineViewWrapper != null) {
            klineViewWrapper.B(list, i11);
        }
    }

    public void M(KlineInfo klineInfo) {
        super.M(klineInfo);
        if (this.f24019c2.getVisibility() == 0) {
            qm(this.f24037l2, this.f24039m2, this.f24041n2);
            qm(this.P1, this.Q1, this.R1);
            vm();
        }
    }

    public void Wk() {
        this.I1 = null;
        if (getActivity() != null) {
            if (getActivity() instanceof MarketInfoActivity) {
                ((MarketInfoActivity) getActivity()).Qh();
            }
            KLineHelper.n(!KLineHelper.f());
            Intent intent = getActivity().getIntent();
            intent.addFlags(65536);
            getActivity().finish();
            getActivity().overridePendingTransition(0, 0);
            startActivity(intent);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: d9.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Xk() {
        /*
            r11 = this;
            rx.Subscription r0 = r11.U2
            if (r0 == 0) goto L_0x0007
            r0.unsubscribe()
        L_0x0007:
            java.lang.String r0 = "user_config"
            java.lang.String r1 = "KLINE_CONFIG_BST_SWITCH"
            r2 = 1
            boolean r0 = com.hbg.lib.core.util.ConfigPreferences.c(r0, r1, r2)
            td.i r1 = td.i.a()
            td.h r1 = r1.b()
            boolean r1 = r1.n()
            if (r1 == 0) goto L_0x00ed
            if (r0 != 0) goto L_0x0022
            goto L_0x00ed
        L_0x0022:
            java.lang.String r0 = r11.S0
            boolean r0 = com.hbg.lib.data.symbol.TradeType.isPro((java.lang.String) r0)
            r3 = 0
            r1 = 0
            if (r0 != 0) goto L_0x00a4
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.MARGIN
            java.lang.String r5 = r11.S0
            com.hbg.lib.data.symbol.TradeType r5 = com.hbg.lib.data.symbol.TradeType.valueOf(r5)
            if (r0 == r5) goto L_0x00a4
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN
            java.lang.String r5 = r11.S0
            com.hbg.lib.data.symbol.TradeType r5 = com.hbg.lib.data.symbol.TradeType.valueOf(r5)
            if (r0 != r5) goto L_0x0042
            goto L_0x00a4
        L_0x0042:
            java.lang.String r0 = r11.S0
            boolean r0 = com.hbg.lib.data.symbol.TradeType.isContract((java.lang.String) r0)
            if (r0 != 0) goto L_0x0062
            java.lang.String r0 = r11.S0
            boolean r0 = com.hbg.lib.data.symbol.TradeType.isSwap((java.lang.String) r0)
            if (r0 != 0) goto L_0x0062
            java.lang.String r0 = r11.S0
            boolean r0 = com.hbg.lib.data.symbol.TradeType.isOption((java.lang.String) r0)
            if (r0 != 0) goto L_0x0062
            java.lang.String r0 = r11.S0
            boolean r0 = com.hbg.lib.data.symbol.TradeType.isLinearSwap((java.lang.String) r0)
            if (r0 == 0) goto L_0x00c1
        L_0x0062:
            java.lang.String r0 = r11.Q0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00c1
            java.lang.String r0 = r11.S0
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.valueOf(r0)
            boolean r0 = a7.e.F(r0)
            if (r0 != 0) goto L_0x0084
            java.lang.String r0 = r11.S0
            com.hbg.lib.data.symbol.TradeType r0 = com.hbg.lib.data.symbol.TradeType.valueOf(r0)
            boolean r0 = a7.e.G(r0)
            if (r0 == 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r2 = 0
        L_0x0084:
            r8 = r2
            com.hbg.lib.network.hbg.IHbgApi r5 = v7.b.a()
            java.lang.String r6 = r11.Q0
            com.hbg.lib.network.pro.core.util.Period r0 = r11.K0
            int r7 = r0.getPeriodIntType()
            long r9 = r11.f24026f3
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x0098
            goto L_0x009c
        L_0x0098:
            java.lang.String r1 = java.lang.String.valueOf(r9)
        L_0x009c:
            r9 = r1
            r10 = 100
            d9.a r1 = r5.getContractBSTInfo(r6, r7, r8, r9, r10)
            goto L_0x00c1
        L_0x00a4:
            com.hbg.lib.network.hbg.IHbgApi r0 = v7.b.a()
            java.lang.String r2 = r11.L0
            com.hbg.lib.network.pro.core.util.Period r5 = r11.K0
            int r5 = r5.getPeriodIntType()
            long r6 = r11.f24026f3
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 > 0) goto L_0x00b7
            goto L_0x00bb
        L_0x00b7:
            java.lang.String r1 = java.lang.String.valueOf(r6)
        L_0x00bb:
            r6 = 100
            d9.a r1 = r0.getBSTInfo(r2, r5, r1, r6)
        L_0x00c1:
            if (r1 == 0) goto L_0x00ed
            com.hbg.component.kline.render.CandleStickRender$ReqDataStatus r0 = com.hbg.component.kline.render.CandleStickRender.ReqDataStatus.LOADING
            r11.f24028g3 = r0
            rx.Observable r0 = r1.b()
            rx.Scheduler r1 = rx.schedulers.Schedulers.io()
            rx.Observable r0 = r0.subscribeOn(r1)
            long r1 = r11.f24026f3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x00e2
            com.hbg.module.kline.ui.MarketInfoFragment$c r1 = new com.hbg.module.kline.ui.MarketInfoFragment$c
            r1.<init>()
            rx.Observable r0 = r0.repeatWhen(r1)
        L_0x00e2:
            com.hbg.module.kline.ui.MarketInfoFragment$d r1 = new com.hbg.module.kline.ui.MarketInfoFragment$d
            r1.<init>()
            rx.Subscription r0 = r0.subscribe(r1)
            r11.U2 = r0
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.kline.ui.MarketInfoFragment.Xk():void");
    }

    public final void Yk() {
        if (!mj()) {
            rm(this.f23817p, this.f23819q);
            rm(this.f23829v, this.f23827u);
            rm(this.f23831w, this.f23821r);
        }
        rm(this.f24021d2, this.U1);
        rm(this.f24023e2, this.V1);
        rm(this.f24025f2, this.W1);
        rm(this.f24027g2, this.X1);
        rm(this.f24029h2, this.Y1);
        rm(this.f24031i2, this.Z1);
        rm(this.f24033j2, this.f24015a2);
        rm(this.f24035k2, this.f24017b2);
    }

    public final void Zk(long j11, float f11, float f12, int i11, int i12, Interpolator interpolator) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j11);
        animatorSet.setInterpolator(interpolator);
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.N1, View.ROTATION, new float[]{f11, f12}), ObjectAnimator.ofInt(new ViewHeightWrapper(this.O1), "height", new int[]{i11, i12})});
        animatorSet.addListener(new p());
        ImageView imageView = this.N1;
        imageView.setSelected(!imageView.isSelected());
        animatorSet.start();
    }

    public void aj(boolean z11) {
    }

    public final void al(Drawable drawable, Drawable drawable2, BSTInfo.BSTInfoBean bSTInfoBean, List<BSTShape> list, List<BSTShape> list2, List<BSTShape> list3) {
        if (bSTInfoBean.getBst() != null) {
            String upperCase = bSTInfoBean.getBst().toUpperCase();
            upperCase.hashCode();
            char c11 = 65535;
            switch (upperCase.hashCode()) {
                case 66:
                    if (upperCase.equals("B")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 83:
                    if (upperCase.equals("S")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 84:
                    if (upperCase.equals("T")) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    BSTShape bSTShape = new BSTShape(upperCase, bSTInfoBean);
                    list.add(bSTShape);
                    bSTShape.setBuySellDrawable(drawable, drawable2);
                    return;
                case 1:
                    BSTShape bSTShape2 = new BSTShape(upperCase, bSTInfoBean);
                    list2.add(bSTShape2);
                    bSTShape2.setBuySellDrawable(drawable, drawable2);
                    return;
                case 2:
                    BSTShape bSTShape3 = new BSTShape(upperCase, bSTInfoBean);
                    list3.add(bSTShape3);
                    bSTShape3.setBuySellDrawable(drawable, drawable2);
                    return;
                default:
                    return;
            }
        }
    }

    public final void bl() {
        if (TradeType.CONTRACT.toString().equals(this.S0)) {
            ((com.hbg.module.kline.presenter.a) yh()).g0();
        } else if (TradeType.SWAP.toString().equals(this.S0)) {
            ((com.hbg.module.kline.presenter.a) yh()).g0();
        } else if (TradeType.OPTION.toString().equals(this.S0)) {
            ((com.hbg.module.kline.presenter.a) yh()).g0();
        } else if (TradeType.CONTRACT_INDEX.toString().equals(this.S0)) {
            ((com.hbg.module.kline.presenter.a) yh()).g0();
        } else if (TradeType.LINEAR_SWAP_INDEX.toString().equals(this.S0)) {
            ((com.hbg.module.kline.presenter.a) yh()).g0();
        }
    }

    public void cj(boolean z11) {
        ViewUtil.m(this.H1, z11);
    }

    public final void cl() {
        td.i.a().b().E(this);
    }

    public void d6(CommunitySwitchEnum communitySwitchEnum, CommentSwitchEnum commentSwitchEnum, SymbolTypeEnum symbolTypeEnum) {
        String str;
        this.f24049r2 = communitySwitchEnum;
        this.f24047q2 = commentSwitchEnum;
        if (symbolTypeEnum == SymbolTypeEnum.CURRENCY) {
            this.f24045p2 = SymbolParamType.BASE_CURRENCY;
        } else {
            this.f24045p2 = SymbolParamType.SYMBOL;
        }
        boolean z11 = commentSwitchEnum == CommentSwitchEnum.SHOW;
        CommunityManager.Companion.getInstance().setCommentListShow(z11);
        if (communitySwitchEnum == CommunitySwitchEnum.SHOW) {
            if (this.f24045p2 == SymbolParamType.SYMBOL) {
                str = this.L0;
            } else {
                str = a1.v().o(this.L0, TradeType.parse(this.S0));
            }
            int type = this.f24045p2.getType();
            this.C1.putString(FragmentCommunityList.COMMUNITY_SYMBOL, str);
            this.C1.putString(FragmentCommunityList.COMMUNITY_SYMBOL_ID, this.L0);
            this.C1.putInt(FragmentCommunityList.SYMBOL_PARAM_TYPE, type);
            this.C1.putBoolean(FragmentCommunityList.COMMUNITY_COMMENT_SWITCH, z11);
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(R$drawable.ic_data_refresh_icon));
            gl(arrayList, getString(R$string.community_tab_title), getString(R$string.market_info_tab_depth_map), getString(R$string.market_info_tab_trades), getString(R$string.kline_data_analyze));
            zm(FragmentCommunityList.class, this.C1);
            wm(0, false);
            if (yi()) {
                this.f24051s2.setSymbol(this.L0, CommunitySensorsEvent.Companion.getContractPageName());
            } else {
                this.f24051s2.setSymbol(this.L0, CommunitySensorsEvent.Companion.getKLinePageName());
            }
            FragmentCommunityList fragmentCommunityList = this.f24069y2;
            if (fragmentCommunityList != null) {
                fragmentCommunityList.setOnDisclaimerVisibleChangedListener(new x2(this));
            }
        }
    }

    public void dj(double d11) {
        super.dj(d11);
    }

    public final void dl(boolean z11) {
        if (this.f24053t1) {
            td.i.a().b().c(getActivity(), this.L0, z11);
            return;
        }
        td.i.a().b().p(this, ((com.hbg.module.kline.presenter.a) yh()).d0(), ((com.hbg.module.kline.presenter.a) yh()).k0(), ((com.hbg.module.kline.presenter.a) yh()).j0(), this.S0, this.L0, z11);
    }

    public void e0(double d11) {
        this.V1.setText(NumberKlineUtil.a(d11, FuturePrecisionUtil.y(this.Q0, "", this.R0), true));
        qm(this.f24037l2, this.f24039m2, this.f24041n2);
        qm(this.P1, this.Q1, this.R1);
        vm();
    }

    public void eb(IndexDetail indexDetail) {
        super.eb(indexDetail);
        qm(this.f24037l2, this.f24039m2, this.f24041n2);
        qm(this.P1, this.Q1, this.R1);
        vm();
    }

    public final void el() {
        if (!this.f23811m1 && this.f23820q1) {
            ii(this.H2, this.I2, this.J2, new q());
        }
    }

    /* renamed from: fl */
    public final void Zl(KlineInfo klineInfo, boolean z11) {
        this.f24030h3 = klineInfo;
        if (z11 && klineInfo != null && (klineInfo.extraInfoBean instanceof BSTInfo.BSTInfoBean)) {
            boolean z12 = true;
            if (ConfigPreferences.c("user_config", "KLINE_CONFIG_BST_SWITCH", true)) {
                if (!TradeType.isContract(this.S0) && !TradeType.isSwap(this.S0) && !TradeType.isOption(this.S0) && !TradeType.isLinearSwap(this.S0)) {
                    z12 = false;
                }
                if (this.f24024e3 == null) {
                    KlineTopBSTView klineTopBSTView = new KlineTopBSTView(getActivity());
                    this.f24024e3 = klineTopBSTView;
                    klineTopBSTView.setOnClickListener(new t2(this, z12));
                    this.H1.addView(this.f24024e3, new FrameLayout.LayoutParams(-1, DimenUtils.a(30.0f)));
                }
                this.f24024e3.setContract(z12);
                this.f24024e3.setPricePrecision(this.Z0);
                this.f24024e3.setNumPrecision(this.f23785a1);
                this.f24024e3.setData(((BSTInfo.BSTInfoBean) klineInfo.extraInfoBean).getTrades());
                return;
            }
        }
        KlineTopBSTView klineTopBSTView2 = this.f24024e3;
        if (klineTopBSTView2 != null) {
            klineTopBSTView2.setData((List<BSTInfo.Trade>) null);
        }
    }

    public final void gl(List<Integer> list, String... strArr) {
        this.f24065x1.k(list, strArr);
    }

    public final void hl(String... strArr) {
        this.f24065x1.l(strArr);
    }

    public final void il() {
        RequestExtKt.c(v7.b.a().getSymbolHistoryRate(this.L0), new y2(this), a3.f24150b, (MutableLiveData) null);
    }

    public final void im(Fragment fragment, Fragment fragment2) {
        if (fragment != null && fragment2 != null && fragment.getClass() != fragment2.getClass()) {
            MarketInfoCapitalFlowPresenter marketInfoCapitalFlowPresenter = (MarketInfoCapitalFlowPresenter) ((MarketInfoCapitalFlowFragment) fragment2).yh();
        }
    }

    public void initViews() {
        int i11;
        super.initViews();
        this.P2 = (AppBarLayout) this.f67460i.b(R$id.id_abl_kline_appbar_layout);
        this.J1 = (SmartRefreshLayout) this.f67460i.b(R$id.market_info_refresh);
        this.K1 = new SmartRefreshHeader(getActivity());
        boolean z11 = true;
        this.J1.i(true);
        this.J1.g(false);
        this.J1.V(false);
        this.J1.j0(this.K1);
        this.f24051s2 = (CommunityDisclaimerBottomView) this.f67460i.b(R$id.cdbv_community_disclaimer_float_view);
        this.f24071z1 = (FrameLayout) this.f67460i.b(R$id.market_info_container);
        this.E1 = this.f67460i.b(R$id.id_kline_index_setting_draw_layout);
        this.F1 = (CommonSwitchButton) this.f67460i.b(R$id.id_kline_index_setting_theme_btn);
        this.B = (TextView) this.f67460i.b(R$id.contract_hold_num_tv);
        this.A = (TextView) this.f67460i.b(R$id.contract_hold_num_label);
        this.Q2 = (LinearLayout) this.f67460i.b(R$id.linear_layout_market_chart_box);
        this.H1 = (KlineViewWrapper) this.f67460i.b(R$id.klineViewWrapper);
        this.N1 = (ImageView) this.f67460i.b(R$id.image_view_kline_option_info_switch);
        this.O1 = (LinearLayout) this.f67460i.b(R$id.linear_layout_kline_option_info);
        this.f24019c2 = this.f67460i.b(R$id.layout_option_info);
        this.f24037l2 = (LinearLayout) this.f67460i.b(R$id.linear_layout_kline_info_box_left);
        this.f24039m2 = (LinearLayout) this.f67460i.b(R$id.linear_layout_kline_info_box_right);
        this.f24041n2 = (LinearLayout) this.f67460i.b(R$id.linear_layout_kline_info_box);
        this.W2 = (CommonSwitchButton) this.f67460i.b(R$id.id_kline_index_bst_switch);
        this.X2 = (CommonSwitchButton) this.f67460i.b(R$id.id_kline_index_setting_fixy_btn);
        this.Y2 = (CommonSwitchButton) this.f67460i.b(R$id.id_kline_index_setting_cang_btn);
        this.Z2 = (CommonSwitchButton) this.f67460i.b(R$id.id_kline_index_setting_liquidation_btn);
        this.f24016a3 = (CommonSwitchButton) this.f67460i.b(R$id.id_kline_index_setting_open_orders_btn);
        this.f24018b3 = (CommonSwitchButton) this.f67460i.b(R$id.csb_count_down_tile);
        this.f24020c3 = this.f67460i.b(R$id.view_count_down_red);
        this.f24022d3 = this.f67460i.b(R$id.view_setting_red);
        this.f24032i3 = this.f67460i.b(R$id.id_kline_index_setting_cang_layout);
        this.f24034j3 = this.f67460i.b(R$id.id_kline_trade_compare_layout);
        this.f24036k3 = this.f67460i.b(R$id.id_kline_index_setting_contract_layout);
        this.f24034j3.setOnClickListener(new g2(this));
        this.P1 = (LinearLayout) this.f67460i.b(R$id.linear_layout_kline_info_value);
        this.Q1 = (LinearLayout) this.f67460i.b(R$id.linear_layout_kline_option_info_left_value);
        this.R1 = (LinearLayout) this.f67460i.b(R$id.linear_layout_kline_option_info_right_value);
        this.S1 = (LinearLayout) this.f67460i.b(R$id.linear_layout_kline_option_info_left_label);
        this.T1 = (LinearLayout) this.f67460i.b(R$id.linear_layout_kline_option_info_right_label);
        this.f24021d2 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_mark_price_label);
        this.f24023e2 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_index_price_label);
        this.f24025f2 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_delta_label);
        this.f24027g2 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_gammta_label);
        this.f24029h2 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_volatility_label);
        this.f24031i2 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_exercise_label);
        this.f24033j2 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_theta_label);
        this.f24035k2 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_vega_label);
        this.U1 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_mark_price);
        this.V1 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_index_price);
        this.W1 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_delta);
        this.X1 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_gammta);
        this.Y1 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_volatility);
        this.Z1 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_exercise);
        this.f24015a2 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_theta);
        this.f24017b2 = (TextView) this.f67460i.b(R$id.text_view_kline_option_info_vega);
        this.C2 = (LinearLayout) this.f67460i.b(R$id.linear_layout_market_bottom_trade);
        this.G1 = this.f67460i.b(R$id.market_info_order_container);
        this.D2 = (ImageView) this.f67460i.b(R$id.image_view_market_bottom_trade);
        this.E2 = (TextView) this.f67460i.b(R$id.text_view_market_bottom_trade);
        this.f24072z2 = (ImageView) this.f67460i.b(R$id.image_view_kline_intro_etp_close);
        this.A2 = (TextView) this.f67460i.b(R$id.text_view_kline_intro_etp);
        this.B2 = (LinearLayout) this.f67460i.b(R$id.linear_layout_kline_etp_intro);
        this.S2 = this.f67460i.b(R$id.view_kline_splite);
        this.H2 = this.f67460i.b(R$id.market_info_kline_type_layout);
        this.I2 = this.f67460i.b(R$id.market_info_kline_type);
        this.J2 = this.f67460i.b(R$id.market_info_kline_type_bg);
        this.K2 = (RelativeLayout) this.f67460i.b(R$id.kline_etp_type_trade);
        this.L2 = (RelativeLayout) this.f67460i.b(R$id.kline_etp_type_etp);
        this.F2 = (ConstraintLayout) this.f67460i.b(R$id.constraint_layout_etp_kline_type);
        this.f23790d0 = (TextView) this.f67460i.b(R$id.text_view_etp_kline_type);
        this.G2 = (RelativeLayout) this.f67460i.b(R$id.one_week_radio_layout);
        this.W2.setChecked(ConfigPreferences.c("user_config", "KLINE_CONFIG_BST_SWITCH", true));
        this.X2.setChecked(ConfigPreferences.c("user_config", "KLINE_CONFIG_FIXY_SWITCH", true));
        this.Y2.setChecked(ConfigPreferences.c("user_config", "KLINE_CONFIG_CANG_SWITCH", true));
        this.Z2.setChecked(ConfigPreferences.c("user_config", "KLINE_CONFIG_LIQUIDATION_SWITCH", true));
        this.f24016a3.setChecked(ConfigPreferences.c("user_config", "KLINE_CONFIG_OPENORDERS_SWITCH", true));
        this.f24018b3.setChecked(ConfigPreferences.c("user_config", "KLINE_CONFIG_COUNTDOWN_SWITCH", false));
        boolean c11 = ConfigPreferences.c("user_config", "SP_KEY_SHOW_RED_POINT", true);
        this.f24020c3.setVisibility(c11 ? 0 : 8);
        this.f24022d3.setVisibility(c11 ? 0 : 8);
        this.H1.setDrawLineLayerEnable(true);
        xi(this.H1, false);
        this.H1.setKlineDragLeftOrRightListerner(new s3(this));
        this.A1 = (Button) this.f67460i.b(R$id.market_buy);
        this.f24056u1 = (KLineIndexSelectorView) this.f67460i.b(R$id.klineIndexSelectorView);
        this.f24062w1 = (AutoTextSizeLayout) this.f67460i.b(R$id.auto_size_layout);
        this.B1 = (Button) this.f67460i.b(R$id.create_strategy_btn);
        if (this.T0) {
            this.B1.setVisibility(0);
            this.A1.setVisibility(8);
        } else {
            this.B1.setVisibility(8);
            this.A1.setVisibility(0);
        }
        this.f24038l3 = this.f67460i.b(R$id.kline_history_rate_divider);
        this.f24040m3 = (LinearLayout) this.f67460i.b(R$id.llHistoryRate);
        this.f24042n3 = (TextView) this.f67460i.b(R$id.tv24hHistoryTitle);
        this.f23835y = (TextView) this.f67460i.b(R$id.tv24hHistoryValue);
        this.f24044o3 = (TextView) this.f67460i.b(R$id.tv7dHistoryTitle);
        this.f24046p3 = (TextView) this.f67460i.b(R$id.tv7dHistoryValue);
        this.f24048q3 = (TextView) this.f67460i.b(R$id.tv14dHistoryTitle);
        this.f24050r3 = (TextView) this.f67460i.b(R$id.tv14dHistoryValue);
        this.f24052s3 = (TextView) this.f67460i.b(R$id.tv30dHistoryTitle);
        this.f24055t3 = (TextView) this.f67460i.b(R$id.tv30dHistoryValue);
        this.f24058u3 = (TextView) this.f67460i.b(R$id.tv60dHistoryTitle);
        this.f24061v3 = (TextView) this.f67460i.b(R$id.tv60dHistoryValue);
        this.f24064w3 = (TextView) this.f67460i.b(R$id.tv1yHistoryTitle);
        this.f24067x3 = (TextView) this.f67460i.b(R$id.tv1yHistoryValue);
        Hm(this.L0);
        wi();
        ij();
        this.f24059v1 = (KlineLabelView) this.f67460i.b(R$id.klineLabelView);
        this.f24068y1 = (CoordinatorLayout) this.f67460i.b(R$id.id_cl_kline_coordinator);
        CommonTabLayout commonTabLayout = (CommonTabLayout) this.f67460i.b(R$id.market_tab);
        this.f24065x1 = commonTabLayout;
        commonTabLayout.setWeightSum(-1);
        om(TradeType.isPro(this.S0) && td.i.a().b().n());
        if (TradeType.isIndex(this.S0)) {
            ViewUtil.m(this.f67460i.b(R$id.market_info_bottom_container), false);
            this.J1.setPadding(0, 0, 0, 0);
            hl(getString(R$string.market_info_tab_index_ingredients), getString(R$string.n_kline_intro_tab));
        } else if (TradeType.isContractIndex(this.S0) || TradeType.isLinearSwapIndex(this.S0)) {
            ViewUtil.m(this.f67460i.b(R$id.market_info_bottom_container), false);
            this.J1.setPadding(0, 0, 0, 0);
            ViewUtil.m(this.f24065x1, false);
        } else if (yi()) {
            ViewUtil.m(this.f24065x1, true);
            hl(getString(R$string.n_exchange_consignment_order), getString(R$string.market_info_tab_depth_map), getString(R$string.market_info_tab_trades));
            ViewUtil.m(this.C2, true);
            this.D2.setImageResource(ni(R$attr.kline_spot_button));
            this.E2.setText(R$string.n_spot);
            this.C2.setOnClickListener(new t3(this));
        } else if (ae()) {
            this.f23806l = new Period[]{Period.timeline, Period.min15, Period.min60, Period.hour4, Period.day};
            this.f23794f0 = this.f67460i.b(R$id.market_info_more_detail_layout_etp);
            this.D0 = this.f67460i.b(R$id.kline_type_view);
            this.E0 = this.f67460i.b(R$id.id_kline_period_more_bg_view_etp);
            this.Q = (RelativeLayout) this.f67460i.b(R$id.float_time_radio_layout_etp);
            this.R = (RelativeLayout) this.f67460i.b(R$id.one_min_radio_layout_etp);
            this.S = (RelativeLayout) this.f67460i.b(R$id.five_min_radio_layout_etp);
            this.U = (RelativeLayout) this.f67460i.b(R$id.thirty_min_radio_layout_etp);
            this.Y = (RelativeLayout) this.f67460i.b(R$id.one_week_radio_layout_etp);
            this.Z = (RelativeLayout) this.f67460i.b(R$id.one_month_radio_layout_etp);
            this.M2 = (LinearLayout) this.f67460i.b(R$id.etp_auto_size_layout);
            this.N2 = (TextView) this.f67460i.b(R$id.etp_market_info_price);
            this.O2 = (TextView) this.f67460i.b(R$id.etp_rise_and_fall_text);
            ViewUtil.m(this.M2, true);
            ViewUtil.m(this.f24065x1, true);
            hl(getString(R$string.n_exchange_consignment_order), getString(R$string.market_info_tab_depth_map), getString(R$string.market_info_tab_trades), getString(R$string.kline_data_analyze), getString(R$string.n_kline_etp_hold_tab));
            this.f24065x1.i(3);
            ViewUtil.m(this.F2, true);
            ViewUtil.m(this.S2, true);
            ViewUtil.m(this.G2, false);
            this.O2.setOnClickListener(new v3(this));
        } else {
            ViewUtil.m(this.f24065x1, true);
            ViewUtil.m(this.F2, false);
            ViewUtil.m(this.S2, false);
            ViewUtil.m(this.G2, true);
            hl(getString(R$string.n_exchange_consignment_order), getString(R$string.market_info_tab_depth_map), getString(R$string.market_info_tab_trades), getString(R$string.kline_data_analyze));
            SymbolBean J = a1.v().J(this.L0, TradeType.valueOf(this.S0));
            if (J != null && td.i.a().b().e()) {
                String leverageRatio = J.getLeverageRatio();
                if (TradeType.MARGIN == TradeType.valueOf(this.S0) || TradeType.SUPERMARGIN == TradeType.valueOf(this.S0)) {
                    ViewUtil.m(this.C2, true);
                    this.D2.setImageResource(ni(R$attr.kline_spot_button));
                    this.E2.setText(R$string.n_spot);
                    this.C2.setOnClickListener(new r2(this, J));
                } else if (TradeType.PRO == TradeType.valueOf(this.S0) && !TextUtils.isEmpty(leverageRatio)) {
                    ViewUtil.m(this.C2, true);
                    this.D2.setImageResource(ni(R$attr.kline_laver_button));
                    this.E2.setText(R$string.n_kline_loan);
                    this.C2.setOnClickListener(new s2(this, J));
                }
            }
            this.G1.setOnClickListener(new n2(this));
            if (!(TradeType.MARGIN == TradeType.valueOf(this.S0) || TradeType.SUPERMARGIN == TradeType.valueOf(this.S0))) {
                try {
                    MarginTogetherMgtBean marginTogetherMgtBean = (MarginTogetherMgtBean) AppConfigManager.c(MgtConfigNumber.KLINE_QUICK_TRADE.number, MarginTogetherMgtBean.class);
                    String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
                    if (TextUtils.isEmpty(e11)) {
                        this.f24053t1 = marginTogetherMgtBean.getExvalue() == 1;
                    } else {
                        if (e11.length() > 2) {
                            i11 = i6.m.k0(e11.substring(e11.length() - 2));
                        } else {
                            i11 = i6.m.k0(e11);
                        }
                        if (i11 >= marginTogetherMgtBean.getUserIdFirNum() && i11 <= marginTogetherMgtBean.getUserIdSecNum()) {
                            this.f24053t1 = true;
                        }
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
            ViewUtil.m(this.G1, this.f24053t1);
        }
        kl();
        Bundle bundle = new Bundle();
        this.C1 = bundle;
        bundle.putString("symbolId", this.L0);
        this.C1.putString("market_tradetype", this.S0);
        if (ae()) {
            zm(MarketInfoOrderFragment.class, this.C1);
        } else if (TradeType.isIndex(this.S0)) {
            zm(MarketInfoIndexIngredientsFragment.class, this.C1);
        } else if (TradeType.isContractIndex(this.S0)) {
            zm(KlineCurrencyIntroductionFragment.class, this.C1);
        } else if (TradeType.isLinearSwapIndex(this.S0)) {
            zm(KlineCurrencyIntroductionFragment.class, this.C1);
        } else {
            zm(MarketInfoOrderFragment.class, this.C1);
        }
        this.D1 = (LinearLayout) this.f67460i.b(R$id.market_top);
        ll();
        if (TradeType.isContractIndex(this.S0) || TradeType.isLinearSwapIndex(this.S0)) {
            ViewUtil.m(this.f23817p, false);
            ViewUtil.m(this.f23819q, false);
        }
        if (TradeType.isOption(this.S0)) {
            this.f24019c2.post(new g3(this));
        } else {
            this.f24019c2.setVisibility(8);
        }
        if (ae()) {
            KLineHelper.j(this.L0, true);
            this.R2 = true;
            this.B2.post(new d3(this));
            Am();
        }
        this.P2.post(new j3(this));
        ViewUtil.n(this.f67460i.b(R$id.linear_layout_market_sbt_switch_box), TradeType.isPro(this.S0) || TradeType.MARGIN == TradeType.valueOf(this.S0) || TradeType.SUPERMARGIN == TradeType.valueOf(this.S0) || TradeType.isContract(this.S0) || TradeType.isSwap(this.S0) || TradeType.isOption(this.S0) || TradeType.isLinearSwap(this.S0));
        if (!TradeType.isContract(this.S0) && !TradeType.isSwap(this.S0) && !TradeType.isLinearSwap(this.S0)) {
            z11 = false;
        }
        ViewUtil.m(this.f24032i3, z11);
        ViewUtil.m(this.f24036k3, z11);
        Bundle arguments = getArguments();
        if (arguments.getBoolean("isShowPK", false) && !z11) {
            this.f24034j3.setVisibility(0);
        } else if (!z11 && !arguments.getBoolean("isShowPK", false)) {
            this.f24034j3.setVisibility(4);
        }
    }

    public void jj(int i11) {
        super.jj(i11);
        this.V2.clear();
        this.f24026f3 = -1;
        this.f24028g3 = CandleStickRender.ReqDataStatus.IDLE;
        this.H1.l((List<BSTShape>) null, (List<BSTShape>) null, (List<BSTShape>) null);
        Xk();
    }

    public final void jl(TextView textView, String str) {
        int i11;
        BigDecimal scale = new BigDecimal(str).multiply(i6.m.f68179a).setScale(2, RoundingMode.HALF_UP);
        Resources resources = getActivity().getResources();
        if (scale.doubleValue() > 0.0d) {
            i11 = w.h();
        } else if (scale.doubleValue() == 0.0d) {
            i11 = w.e();
        } else {
            i11 = w.d();
        }
        textView.setTextColor(resources.getColor(i11, getActivity().getTheme()));
        textView.setText(scale.toPlainString() + "%");
    }

    public final void jm(boolean z11) {
        this.f24063w2 = z11;
        boolean z12 = false;
        boolean z13 = this.f24054t2 && z11;
        CommunityDisclaimerBottomView communityDisclaimerBottomView = this.f24051s2;
        if (z13 && this.f24057u2) {
            z12 = true;
        }
        communityDisclaimerBottomView.setAnimVisibility(z12);
        ViewUtil.m(this.f67460i.b(R$id.market_info_bottom_shadow_iv), !z11);
    }

    public void k8(String str, String str2, KlineInfo klineInfo) {
        if (klineInfo != null && this.O2 != null && this.N2 != null) {
            double close = klineInfo.getClose();
            double open = klineInfo.getOpen();
            double d11 = close - open;
            if (Double.compare(d11, 0.0d) > 0) {
                this.O2.setTextColor(getResources().getColor(w.h()));
            } else if (Double.compare(d11, 0.0d) < 0) {
                this.O2.setTextColor(getResources().getColor(w.d()));
            } else {
                this.O2.setTextColor(getResources().getColor(R$color.color_flat));
            }
            String k11 = i6.m.k(close, this.Z0, true);
            this.D3 = k11;
            this.N2.setText(k11);
            this.O2.setText(ri(open, close));
            Fragment fragment = this.M1;
            if (fragment instanceof f0) {
                ((f0) fragment).B7(this.D3);
            }
        }
    }

    public final void kl() {
        SymbolBean J = a1.v().J(this.L0, TradeType.PRO);
        if (J == null || J.getTradeOpenAt() <= 0 || !J.getState().equalsIgnoreCase(SymbolBean.PRE_ONLINE) || J.getTradeOpenAt() <= DateTimeUtils.v()) {
            ViewUtil.m(this.T2, false);
        } else {
            NewSymbolCountDownLayout newSymbolCountDownLayout = (NewSymbolCountDownLayout) this.f67460i.b(R$id.new_symbol_count_down_layout);
            this.T2 = newSymbolCountDownLayout;
            newSymbolCountDownLayout.setSymbolName(J.getSymbolName());
            this.T2.setNightMode(!KLineHelper.f());
            this.T2.e(0, J.getTradeOpenAt());
            ViewUtil.m(this.T2, true);
            this.T2.setCountDownCallback(new j());
        }
        Bm(this.L0);
    }

    public final void km(Fragment fragment, Fragment fragment2) {
        MarketInfoCurrencyDetailPresenter marketInfoCurrencyDetailPresenter;
        if (fragment != null && fragment2 != null && fragment.getClass() != fragment2.getClass() && (marketInfoCurrencyDetailPresenter = (MarketInfoCurrencyDetailPresenter) ((MarketInfoCurrencyDetailFragment) fragment2).yh()) != null) {
            marketInfoCurrencyDetailPresenter.m0();
        }
    }

    public final void ll() {
        if (TradeType.isContract(this.S0) || TradeType.isLinearSwap(this.S0) || TradeType.isSwap(this.S0) || TradeType.isOption(this.S0)) {
            ViewUtil.m(this.B, true);
            ViewUtil.m(this.A, true);
            v7.b.a().getKlineContractBottomBean(this.L0).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new k());
            return;
        }
        try {
            v7.b.a().addSymbolViewCollect(this.L0).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(EasySubscriber.create(new l()));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        v7.b.a().getKlineBottomBean(this.L0).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new m());
    }

    public final void lm(CommonTabLayout commonTabLayout, int i11, boolean z11) {
        if (this.f24049r2 == CommunitySwitchEnum.SHOW) {
            CommunityModuleConfig.Companion companion = CommunityModuleConfig.Companion;
            if (companion.getModuleCallback() != null && i11 == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("symbol", this.L0);
                if (yi()) {
                    hashMap.put("Page_name", CommunitySensorsEvent.Companion.getContractPageName());
                } else {
                    hashMap.put("Page_name", CommunitySensorsEvent.Companion.getKLinePageName());
                }
                companion.getModuleCallback().track(CommunitySensorsEvent.Companion.getCommunittTab(), hashMap);
            }
            ImageView h11 = commonTabLayout.h(0);
            if (h11 != null) {
                if (i11 == 0 && this.f24060v2 != 0) {
                    h11.setImageResource(R$drawable.ic_data_refresh_icon);
                    commonTabLayout.r(h11);
                } else if (this.f24060v2 == 0 && i11 == 0 && z11 && this.f24069y2 != null) {
                    RotateAnimation s11 = this.f24065x1.s(h11, BannerConfig.SCROLL_TIME, 25);
                    this.f24069y2.refreshData(false, new f(System.currentTimeMillis(), s11));
                }
                if (i11 != 0) {
                    commonTabLayout.j(h11);
                }
            }
        }
    }

    public final void mm() {
        this.H1.post(new f3(this));
        KLineHelper.a(new o());
    }

    public final void nm() {
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", this.L0);
        if (this.T0) {
            hashMap.put("markets_kline_class", "grid");
        } else if (yi()) {
            hashMap.put("markets_kline_class", "contract");
        } else if (zi()) {
            hashMap.put("markets_kline_class", "index");
        } else if (ae()) {
            hashMap.put("markets_kline_class", "etp");
        } else {
            hashMap.put("markets_kline_class", RankScreenBean.SCREEN_VALUE_SPOT);
        }
        BaseModuleConfig.a().w("App_markets_kline_view", hashMap);
    }

    public final void om(boolean z11) {
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.market_info_more_layout || id2 == R$id.time_sharing_radio_layout || id2 == R$id.one_min_radio_layout || id2 == R$id.one_min_radio_layout_etp || id2 == R$id.float_time_radio_layout || id2 == R$id.float_time_radio_layout_etp || id2 == R$id.five_min_radio_layout || id2 == R$id.five_min_radio_layout_etp || id2 == R$id.fifteen_min_radio_layout || id2 == R$id.thirty_min_radio_layout || id2 == R$id.thirty_min_radio_layout_etp || id2 == R$id.sixty_min_radio_layout || id2 == R$id.four_hour_radio_layout || id2 == R$id.one_day_radio_layout || id2 == R$id.one_week_radio_layout || id2 == R$id.one_week_radio_layout_etp || id2 == R$id.one_month_radio_layout || id2 == R$id.one_month_radio_layout_etp) {
            nj(view);
            el();
            pm(id2, view);
        } else if (id2 == R$id.constraint_layout_etp_kline_type) {
            Gm();
        } else if (id2 == R$id.kline_etp_type_etp) {
            Cm();
            el();
        } else if (id2 == R$id.kline_etp_type_trade) {
            Dm();
            el();
        } else if (id2 == R$id.market_info_kline_type_bg) {
            el();
        } else if (id2 == R$id.market_info_kline_type) {
            el();
        }
        if ((id2 == R$id.time_sharing_radio_layout || id2 == R$id.fifteen_min_radio_layout || id2 == R$id.sixty_min_radio_layout || id2 == R$id.four_hour_radio_layout || id2 == R$id.one_day_radio_layout || id2 == R$id.one_week_radio_layout) && this.f23816o1 && !this.f23818p1) {
            pj(false);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KlineCallbackUtil.f68552a = this.B3;
        if (BaseModuleConfig.a() != null) {
            BaseModuleConfig.a().o0("huobiapp_market_datapanel_end");
            BaseModuleConfig.a().o0("huobiapp_market_kline_end");
            BaseModuleConfig.a().o0("huobiapp_market_deep_end");
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (KlineCallbackUtil.f68552a == this.B3) {
            KlineCallbackUtil.f68552a = null;
        }
    }

    public void onPause() {
        super.onPause();
        DialogFragment dialogFragment = this.I1;
        if (dialogFragment != null && dialogFragment.isVisible()) {
            this.I1.dismiss();
        }
        pj(false);
        uj(false);
        Subscription subscription = this.U2;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public void onResume() {
        super.onResume();
        if (!TradeType.isIndex(this.S0)) {
            cl();
            bl();
        }
        td.i.a().b().k(this.S0);
        CommunityManager.Companion.getInstance().setNightMode(!KLineHelper.f());
        boolean d11 = KLineHelper.d(this.L0, true);
        if (ae() && !this.R2) {
            this.H1.setSlaveIndex1("");
        }
        if (ae() && this.R2 != d11) {
            this.R2 = d11;
            if (d11) {
                Dm();
            } else {
                Cm();
            }
        }
        nm();
    }

    public void p3(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Z1.setText(i6.m.o(str, FuturePrecisionUtil.y(this.Q0, "", this.R0), true));
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_market_info, viewGroup, false);
    }

    public void pj(boolean z11) {
        qj(z11, (Animator.AnimatorListener) null);
        el();
    }

    public final void pm(int i11, View view) {
        try {
            View childAt = ((ViewGroup) view).getChildAt(0);
            if (childAt instanceof TextView) {
                HashMap hashMap = new HashMap();
                hashMap.put("content", ((TextView) childAt).getText().toString());
                td.i.a().b().d("4651", hashMap, qi());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void qm(ViewGroup viewGroup, ViewGroup viewGroup2, ViewGroup viewGroup3) {
        if (TradeType.isOption(this.S0)) {
            viewGroup.post(new l3(this, viewGroup, viewGroup2, viewGroup3));
        }
    }

    public void rj(List<IndexIngredient> list) {
        super.rj(list);
        MarketInfoIndexIngredientsFragment marketInfoIndexIngredientsFragment = this.L1;
        if (marketInfoIndexIngredientsFragment != null) {
            marketInfoIndexIngredientsFragment.Fh(list);
        }
    }

    public final void rm(TextView textView, TextView textView2) {
        textView.post(new m3(this, textView, textView2));
    }

    public void sj() {
        super.sj();
        MarketInfoIndexIngredientsFragment marketInfoIndexIngredientsFragment = this.L1;
        if (marketInfoIndexIngredientsFragment != null) {
            marketInfoIndexIngredientsFragment.Gh();
        }
    }

    public final void sm(ViewGroup viewGroup, int i11) {
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        layoutParams.width = i11;
        layoutParams.height = -2;
        viewGroup.setLayoutParams(layoutParams);
    }

    public final void tm() {
        i6.i.b().d(new i3(this));
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (!TradeType.isPro(this.S0)) {
            return;
        }
        if (z11) {
            if (this.f24070y3 == null) {
                this.f24070y3 = new b();
            }
            i6.i.b().g(this.f24070y3, 10000);
            il();
        } else if (this.f24070y3 != null) {
            i6.i.b().h(this.f24070y3);
        }
    }

    /* renamed from: ui */
    public AbstractKlinePresenter.b zh() {
        return super.zh();
    }

    public void uj(boolean z11) {
        vj(z11, (Animator.AnimatorListener) null);
        el();
    }

    public void um(boolean z11) {
        CoordinatorLayout.Behavior f11 = ((CoordinatorLayout.LayoutParams) this.P2.getLayoutParams()).f();
        if (f11 instanceof AppBarLayout.Behavior) {
            AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) f11;
            if (z11) {
                behavior.setTopAndBottomOffset(0);
            } else {
                behavior.setTopAndBottomOffset(-this.P2.getHeight());
            }
        }
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void v9(OptionMarketIndexInfo optionMarketIndexInfo) {
        if (a7.e.F(TradeType.valueOf(this.S0))) {
            String h02 = ((com.hbg.module.kline.presenter.a) yh()).h0();
            TextView textView = this.B;
            textView.setText(i6.m.o(FutureUnitUtil.c(optionMarketIndexInfo.getVolume(), this.V0, ((com.hbg.module.kline.presenter.a) yh()).j0().getContractFace(), TradeType.valueOf(this.S0), a7.e.F(TradeType.valueOf(this.S0))), FuturePrecisionUtil.s(this.Q0, "", this.R0), true) + h02);
        } else {
            this.B.setText(getString(R$string.contract_hold_num_value, i6.m.o(optionMarketIndexInfo.getVolume(), FuturePrecisionUtil.B(), true)));
        }
        String markPrice = optionMarketIndexInfo.getMarkPrice();
        if (!TextUtils.isEmpty(markPrice)) {
            this.U1.setText(NumberKlineUtil.a(Double.parseDouble(markPrice), FuturePrecisionUtil.y(this.Q0, "", this.R0), true));
        }
        String valueOf = String.valueOf(optionMarketIndexInfo.getIvMarkPrice());
        if (!TextUtils.isEmpty(valueOf)) {
            TextView textView2 = this.Y1;
            textView2.setText(i6.m.i(Double.parseDouble(valueOf) * 100.0d, 2) + "%");
        }
        String delta = optionMarketIndexInfo.getDelta();
        if (!TextUtils.isEmpty(delta)) {
            this.W1.setText(i6.m.v(delta, 4, true));
        }
        String gamma = optionMarketIndexInfo.getGamma();
        if (!TextUtils.isEmpty(gamma)) {
            this.X1.setText(i6.m.v(gamma, 4, true));
        }
        String theta = optionMarketIndexInfo.getTheta();
        if (!TextUtils.isEmpty(theta)) {
            this.f24015a2.setText(i6.m.v(theta, 4, true));
        }
        String vega = optionMarketIndexInfo.getVega();
        if (!TextUtils.isEmpty(vega)) {
            this.f24017b2.setText(i6.m.v(vega, 4, true));
        }
        qm(this.f24037l2, this.f24039m2, this.f24041n2);
        qm(this.P1, this.Q1, this.R1);
        vm();
    }

    public final void vm() {
        this.O1.post(new h3(this));
    }

    public final void wm(int i11, boolean z11) {
        this.f24060v2 = i11;
        this.f24065x1.q(i11, z11);
    }

    public final void xm(Set<BSTInfo.BSTInfoBean> set) {
        Drawable drawable;
        Drawable drawable2;
        if (w.l()) {
            drawable2 = getResources().getDrawable(R$drawable.kline_bst_redrise_buy);
            drawable = getResources().getDrawable(R$drawable.kline_bst_redrise_sell);
        } else {
            drawable2 = getResources().getDrawable(R$drawable.kline_bst_greenrise_buy);
            drawable = getResources().getDrawable(R$drawable.kline_bst_greenrise_sell);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (BSTInfo.BSTInfoBean al2 : set) {
            al(drawable2, drawable, al2, arrayList, arrayList2, arrayList3);
        }
        this.H1.l(arrayList, arrayList2, arrayList3);
        this.H1.setHighLightVisiableChangeListerner(new r3(this));
    }

    public final void ym(SymbolBean symbolBean) {
        this.A2.setText(EtpRiskHintUtil.f(x7.d.b(symbolBean.getBaseCurrency()), getActivity(), symbolBean.getBaseCurrencyDisplayName(), StringUtils.i(EtpRiskHintUtil.c(symbolBean.getBaseCurrency())), StringUtils.i(symbolBean.getQuoteCurrency()), "0", 0.0d, PrecisionUtil.e(symbolBean.getSymbol()), new w3(this), new o2(this), symbolBean.getEtpLeverageRatio(), false, true));
        this.A2.setMovementMethod(LinkMovementMethod.getInstance());
        this.A2.setHighlightColor(ContextCompat.getColor(getActivity(), 17170445));
    }

    public final void zm(Class cls, Bundle bundle) {
        if (getActivity() != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            FragmentTransaction q11 = childFragmentManager.q();
            if (childFragmentManager.B0() != null) {
                for (Fragment next : childFragmentManager.B0()) {
                    if (next != null) {
                        q11.q(next);
                    }
                }
            }
            String name = cls.getName();
            Fragment instanceFragment = ((BaseActivity) getActivity()).instanceFragment(cls.getName(), bundle, cls.getName());
            if (cls == MarketInfoIndexIngredientsFragment.class) {
                this.L1 = (MarketInfoIndexIngredientsFragment) instanceFragment;
            }
            boolean z11 = instanceFragment instanceof FragmentCommunityList;
            if (z11) {
                this.f24069y2 = (FragmentCommunityList) instanceFragment;
            }
            jm(z11);
            if (instanceFragment instanceof MarketInfoCurrencyDetailFragment) {
                km(this.M1, instanceFragment);
            }
            if (instanceFragment instanceof MarketInfoCapitalFlowFragment) {
                im(this.M1, instanceFragment);
            }
            if (!instanceFragment.isAdded()) {
                q11.c(R$id.market_info_container, instanceFragment, name);
            }
            this.M1 = instanceFragment;
            q11.A(instanceFragment).k();
        }
    }
}
