package com.huobi.index.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.donkingliang.consecutivescroller.ConsecutiveScrollerLayout;
import com.donkingliang.consecutivescroller.ConsecutiveViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.zxing.client.android.CaptureActivity;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.BitmapUtils;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ThreadUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.permissions.AfterPermissionGranted;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.HomeCommonData;
import com.hbg.lib.network.hbg.core.bean.HomeFlowConfig;
import com.hbg.lib.network.hbg.core.bean.HomePageEarnData;
import com.hbg.lib.network.hbg.core.bean.HomePageInvestData;
import com.hbg.lib.network.hbg.core.bean.HomePageNewUserGiftBagData;
import com.hbg.lib.network.hbg.core.bean.HomePageNoticeData;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.RankJumpInfo;
import com.hbg.lib.network.hbg.core.bean.RankList;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.hbg.core.bean.TokenBindInfo;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.lib.network.hbg.core.bean.UnreadCountData;
import com.hbg.lib.network.hbg.core.bean.UserRegistryTransferGuide;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.CommonHorizontalIndicator;
import com.hbg.lib.widgets.IndexTextListIndicator;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.LoadingRelativeLayout;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.TopScrollNoticeView;
import com.hbg.lib.widgets.TopScrollView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.bean.HomeCommonPopListItem;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lib.widgets.utils.PermissionUtils;
import com.hbg.module.content.custom.decoration.PagingScrollHelper;
import com.hbg.module.libkt.custom.decoration.WrapContentGridLayoutManager;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.livesquare.utils.LiveTrackUtils;
import com.huobi.R$drawable;
import com.huobi.account.ui.VerificationStartActivity;
import com.huobi.apm.TimeMonitorManager;
import com.huobi.app.util.StartAppUtil;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.entity.HomeActivityEntity;
import com.huobi.finance.api.RiskService;
import com.huobi.finance.bean.TsvMsg;
import com.huobi.home.ui.BaseHomeFragment;
import com.huobi.index.bean.IndexBizData;
import com.huobi.index.bean.IndexFeature;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.index.bean.IndexLiveItem;
import com.huobi.index.bean.RankDynamicItem;
import com.huobi.index.bean.RealTimePrice;
import com.huobi.index.helper.IndexRankingTrackHelper;
import com.huobi.index.helper.IndexSPHelper;
import com.huobi.index.presenter.IndexPresenter;
import com.huobi.index.trace.IndexLifeCycleStep;
import com.huobi.index.trace.IndexLifeCycleTracer;
import com.huobi.index.ui.HuoBiEarnContainer;
import com.huobi.index.ui.widget.HBIndicatorView;
import com.huobi.index.ui.widget.HomeSearchCarouseView;
import com.huobi.index.ui.widget.IndexHomePopListDialogFragment;
import com.huobi.index.ui.widget.IndexUserGuideView;
import com.huobi.index.ui.widget.IndexViewPager;
import com.huobi.index.ui.widget.IndicatorView;
import com.huobi.index.viewhandler.MarketVerticalListItemHandler;
import com.huobi.lifecycle.OnBackgroundStatusChangedEvent;
import com.huobi.main.bean.RemoteSkinBean;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.otc.widget.OtcOrderReminder;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.search.bean.HotSearchInfo;
import com.huobi.search.ui.SearchFlutterActivity;
import com.huobi.utils.ColorUtils;
import com.huobi.utils.HomeHelper;
import com.huobi.utils.HomeSensorsHelper;
import com.huobi.utils.t0;
import com.huobi.view.MyNestedScrollView;
import com.huobi.view.RectangleScaleToCircleView;
import com.huobi.view.rollviewpager.RollPagerView;
import com.huobi.view.rollviewpager.hintview.AnimHintView;
import com.huobi.view.rv.GridDividerItemDecoration;
import com.huobi.webview2.ui.IndexWebActivity;
import com.huochat.community.util.ImageLoadedrManager;
import com.iproov.sdk.bridge.OptionsBridge;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.twitter.sdk.android.core.identity.AuthHandler;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import wk.p0;
import yl.t;

public class IndexFragment extends BaseHomeFragment<IndexPresenter, IndexPresenter.s0> implements IndexPresenter.s0, EasyPermissions.PermissionCallbacks, t.a {
    public static int P2 = 120;
    public static boolean Q2 = true;
    public static long R2;
    public static HomePageInvestData S2;
    public static long T2;
    public static long U2;
    public TopScrollNoticeView A;
    public yl.l A0;
    public boolean A1 = false;
    public RelativeLayout A2;
    public TextView B;
    public View B0;
    public boolean B1 = true;
    public TextView B2;
    public HomeSearchCarouseView C;
    public IndexTextListIndicator C0;
    public Runnable C1 = new k();
    public TextView C2;
    public SafeLottieView D;
    public IndexViewPager D0;
    public WrapContentGridLayoutManager D1;
    public TextView D2;
    public MyNestedScrollView E;
    public LinearLayout E0;
    public ConstraintLayout E1;
    public TextView E2;
    public LoadingRelativeLayout F;
    public LinearLayout F0;
    public RankList F1;
    public TextView F2;
    public TextView G;
    public View G0;
    public int G1;
    public LottieAnimationView G2;
    public TextView H;
    public TextView H0;
    public boolean H1 = true;
    public TextView H2;
    public SmartRefreshLayout I;
    public am.a I0;
    public int I1;
    public Subscriber<Long> I2;
    public SmartRefreshHeader J;
    public yg.c J0;
    public int J1;
    public Subscriber<Long> J2;
    public RelativeLayout K;
    public EasyRecyclerView<wl.c> K0;
    public int K1;
    public int K2 = 0;
    public ConstraintLayout L;
    public EasyRecyclerView<wl.c> L0;
    public int L1 = 0;
    public final int L2 = Color.parseColor("#F0F1F4");
    public final int M = Color.parseColor("#0B1622");
    public EasyRecyclerView<wl.c> M0;
    public int M1;
    public final int M2 = Color.parseColor("#000000");
    public final int N = Color.parseColor("#F3F3F3");
    public final List<EasyRecyclerView<wl.c>> N0 = new ArrayList();
    public boolean N1;
    public boolean[] N2 = new boolean[3];
    public final boolean O = NightHelper.e().g();
    public EasyRecyclerView<s9.a> O0;
    public boolean O1;
    public int O2 = 0;
    public View P;
    public TextView P0;
    @SuppressLint({"HandlerLeak"})
    public final Handler P1 = new v();
    public View Q;
    public LinearLayout Q0;
    public yg.d Q1;
    public FrameLayout R;
    public View R0;
    public Runnable R1 = new i0();
    public LinearLayout S;
    public WrapContentGridLayoutManager S0 = new WrapContentGridLayoutManager(getContext(), 2);
    public final List<Integer> S1 = new ArrayList();
    public View T;
    public ConsecutiveScrollerLayout T0;
    public TextView T1;
    public ViewPager2 U;
    public LinearLayout U0;
    public TextView U1;
    public LottieAnimationView V;
    public View V0;
    public int V1;
    public final List<EasyRecyclerView<IndexFeatureItem>> W = new ArrayList();
    public PagingScrollHelper W0 = new PagingScrollHelper();
    public HashMap<Integer, Integer> W1;
    public HBIndicatorView X;
    public List<y9.b> X0 = new ArrayList();
    public String X1 = "";
    public int Y;
    public List<IndexRankingFragmentDecorator> Y0 = new ArrayList();
    public String Y1 = "";
    public int Z;
    public boolean Z0 = true;
    public int Z1;

    /* renamed from: a0  reason: collision with root package name */
    public HuobiMainActivity f73562a0;

    /* renamed from: a1  reason: collision with root package name */
    public IndicatorView f73563a1;

    /* renamed from: a2  reason: collision with root package name */
    public int f73564a2;

    /* renamed from: b0  reason: collision with root package name */
    public View f73565b0;

    /* renamed from: b1  reason: collision with root package name */
    public TextView f73566b1;

    /* renamed from: b2  reason: collision with root package name */
    public long f73567b2 = 0;

    /* renamed from: c0  reason: collision with root package name */
    public EasyRecyclerView<IndexBizData> f73568c0;

    /* renamed from: c1  reason: collision with root package name */
    public View f73569c1;

    /* renamed from: c2  reason: collision with root package name */
    public LinearLayout f73570c2;

    /* renamed from: d0  reason: collision with root package name */
    public RelativeLayout f73571d0;

    /* renamed from: d1  reason: collision with root package name */
    public View f73572d1;

    /* renamed from: d2  reason: collision with root package name */
    public List<RankList> f73573d2;

    /* renamed from: e0  reason: collision with root package name */
    public RelativeLayout f73574e0;

    /* renamed from: e1  reason: collision with root package name */
    public RelativeLayout f73575e1;

    /* renamed from: e2  reason: collision with root package name */
    public String f73576e2 = "";

    /* renamed from: f0  reason: collision with root package name */
    public RelativeLayout f73577f0;

    /* renamed from: f1  reason: collision with root package name */
    public RelativeLayout f73578f1;

    /* renamed from: f2  reason: collision with root package name */
    public String f73579f2;

    /* renamed from: g0  reason: collision with root package name */
    public RelativeLayout f73580g0;

    /* renamed from: g1  reason: collision with root package name */
    public ImageView f73581g1;

    /* renamed from: g2  reason: collision with root package name */
    public String f73582g2;

    /* renamed from: h0  reason: collision with root package name */
    public TextView f73583h0;

    /* renamed from: h1  reason: collision with root package name */
    public ImageView f73584h1;

    /* renamed from: h2  reason: collision with root package name */
    public String f73585h2;

    /* renamed from: i0  reason: collision with root package name */
    public Subscriber<Long> f73586i0;

    /* renamed from: i1  reason: collision with root package name */
    public volatile List<RankDynamicItem> f73587i1;

    /* renamed from: i2  reason: collision with root package name */
    public String f73588i2;

    /* renamed from: j0  reason: collision with root package name */
    public HomePageNewUserGiftBagData f73589j0;

    /* renamed from: j1  reason: collision with root package name */
    public volatile List<RankDynamicItem> f73590j1;
    @SuppressLint({"CutPasteId"})

    /* renamed from: j2  reason: collision with root package name */
    public LinearLayout f73591j2;

    /* renamed from: k0  reason: collision with root package name */
    public LinearLayout f73592k0;

    /* renamed from: k1  reason: collision with root package name */
    public IndexUserGuideView f73593k1;

    /* renamed from: k2  reason: collision with root package name */
    public View f73594k2;

    /* renamed from: l  reason: collision with root package name */
    public final String f73595l = "IndexTAGFragment";

    /* renamed from: l0  reason: collision with root package name */
    public ViewGroup f73596l0;

    /* renamed from: l1  reason: collision with root package name */
    public long f73597l1 = -1;

    /* renamed from: l2  reason: collision with root package name */
    public LottieAnimationView f73598l2;

    /* renamed from: m  reason: collision with root package name */
    public RollPagerView f73599m;

    /* renamed from: m0  reason: collision with root package name */
    public RectangleScaleToCircleView f73600m0;

    /* renamed from: m1  reason: collision with root package name */
    public int f73601m1 = -1;

    /* renamed from: m2  reason: collision with root package name */
    public View f73602m2;

    /* renamed from: n  reason: collision with root package name */
    public AnimHintView f73603n;

    /* renamed from: n0  reason: collision with root package name */
    public View f73604n0;

    /* renamed from: n1  reason: collision with root package name */
    public IndexHomeRedDialogFragment f73605n1 = new IndexHomeRedDialogFragment();

    /* renamed from: n2  reason: collision with root package name */
    public LottieAnimationView f73606n2;

    /* renamed from: o  reason: collision with root package name */
    public LoadingLayout f73607o;

    /* renamed from: o1  reason: collision with root package name */
    public IndexHomeGiftDialogFragment f73608o1 = new IndexHomeGiftDialogFragment();

    /* renamed from: o2  reason: collision with root package name */
    public View f73609o2;

    /* renamed from: p  reason: collision with root package name */
    public ViewPager2 f73610p;

    /* renamed from: p1  reason: collision with root package name */
    public boolean f73611p1 = false;

    /* renamed from: p2  reason: collision with root package name */
    public LottieAnimationView f73612p2;

    /* renamed from: q  reason: collision with root package name */
    public CommonHorizontalIndicator f73613q;

    /* renamed from: q1  reason: collision with root package name */
    public ViewGroup f73614q1;

    /* renamed from: q2  reason: collision with root package name */
    public View f73615q2;

    /* renamed from: r  reason: collision with root package name */
    public LottieAnimationView f73616r;

    /* renamed from: r1  reason: collision with root package name */
    public CheckBox f73617r1;

    /* renamed from: r2  reason: collision with root package name */
    public LinearLayout f73618r2;

    /* renamed from: s  reason: collision with root package name */
    public boolean f73619s = false;

    /* renamed from: s1  reason: collision with root package name */
    public CheckBox f73620s1;

    /* renamed from: s2  reason: collision with root package name */
    public TextView f73621s2;

    /* renamed from: t  reason: collision with root package name */
    public ValueAnimator f73622t;

    /* renamed from: t0  reason: collision with root package name */
    public final int f73623t0 = 20;

    /* renamed from: t1  reason: collision with root package name */
    public CheckBox f73624t1;

    /* renamed from: t2  reason: collision with root package name */
    public ImageView f73625t2;

    /* renamed from: u  reason: collision with root package name */
    public ValueAnimator f73626u;

    /* renamed from: u0  reason: collision with root package name */
    public HuoBiEarnContainer f73627u0 = new HuoBiEarnContainer();

    /* renamed from: u1  reason: collision with root package name */
    public ValueAnimator f73628u1;

    /* renamed from: u2  reason: collision with root package name */
    public LinearLayout f73629u2;

    /* renamed from: v  reason: collision with root package name */
    public ValueAnimator f73630v;

    /* renamed from: v0  reason: collision with root package name */
    public RelativeLayout f73631v0;

    /* renamed from: v1  reason: collision with root package name */
    public boolean f73632v1 = false;

    /* renamed from: v2  reason: collision with root package name */
    public TextView f73633v2;

    /* renamed from: w  reason: collision with root package name */
    public ValueAnimator f73634w;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f73635w0 = false;

    /* renamed from: w1  reason: collision with root package name */
    public TabLayout f73636w1;

    /* renamed from: w2  reason: collision with root package name */
    public ImageView f73637w2;

    /* renamed from: x  reason: collision with root package name */
    public View f73638x;

    /* renamed from: x0  reason: collision with root package name */
    public boolean f73639x0 = false;

    /* renamed from: x1  reason: collision with root package name */
    public ConsecutiveViewPager f73640x1;

    /* renamed from: x2  reason: collision with root package name */
    public LinearLayout f73641x2;

    /* renamed from: y  reason: collision with root package name */
    public View f73642y;

    /* renamed from: y0  reason: collision with root package name */
    public HomePageEarnData f73643y0;

    /* renamed from: y1  reason: collision with root package name */
    public List<Fragment> f73644y1;

    /* renamed from: y2  reason: collision with root package name */
    public TextView f73645y2;

    /* renamed from: z  reason: collision with root package name */
    public int f73646z;

    /* renamed from: z0  reason: collision with root package name */
    public View f73647z0;

    /* renamed from: z1  reason: collision with root package name */
    public boolean f73648z1 = true;

    /* renamed from: z2  reason: collision with root package name */
    public ImageView f73649z2;

    public class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f73650a;

        public a(boolean z11) {
            this.f73650a = z11;
        }

        public void onAnimationEnd(Animation animation) {
            TabLayout.Tab tabAt;
            IndexFragment.this.V0.setVisibility(this.f73650a ? 0 : 8);
            if (this.f73650a && (tabAt = IndexFragment.this.f73636w1.getTabAt(IndexFragment.this.f73636w1.getSelectedTabPosition())) != null) {
                tabAt.select();
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class a0 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int[] f73652b;

        public a0(int[] iArr) {
            this.f73652b = iArr;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Log.d("IndexTAGFragment", "value:" + floatValue);
            int[] iArr = this.f73652b;
            iArr[0] = iArr[0] + 1;
            IndexFragment.this.f73610p.scrollBy(3, 0);
        }
    }

    public class b implements ny.d {
        public b() {
        }

        public void P8(ky.j jVar) {
            i6.d.i("home -----加载更多....");
            IndexFragment.this.Q7(2);
            gs.g.i("app_news_rechome_nrkpsl", HomeSensorsHelper.b(HomeHelper.d(IndexFragment.this.f73640x1, IndexFragment.this.f73644y1)));
        }

        public void bf(ky.j jVar) {
            if (IndexFragment.this.zh().isCanBeSeen()) {
                boolean unused = IndexFragment.this.B1 = true;
                IndexFragment.this.Fl(true);
            } else {
                IndexFragment.this.y0(true);
            }
            gs.g.i("app_news_rechome_nrkpxl", HomeSensorsHelper.b(HomeHelper.d(IndexFragment.this.f73640x1, IndexFragment.this.f73644y1)));
        }
    }

    public class b0 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int[] f73655b;

        public b0(int[] iArr) {
            this.f73655b = iArr;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Log.d("IndexTAGFragment", "value:" + floatValue);
            int[] iArr = this.f73655b;
            iArr[1] = iArr[1] + 1;
            IndexFragment.this.f73610p.scrollBy(-5, 0);
        }
    }

    public class c implements View.OnTouchListener {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                IndexFragment.this.Q7(0);
            }
        }

        public c() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!IndexFragment.this.f73632v1 && IndexFragment.this.T0.getScrollY() >= IndexFragment.this.E.getHeight()) {
                IndexFragment.this.Nl();
                IndexFragment.this.T0.scrollTo(0, -IndexFragment.this.G1);
                i6.i.b().g(new a(), 300);
                gs.g.i("app_news_rechome_nrkpdh", HomeSensorsHelper.b(HomeHelper.d(IndexFragment.this.f73640x1, IndexFragment.this.f73644y1)));
            }
            return false;
        }
    }

    public class c0 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int[] f73659b;

        public c0(int[] iArr) {
            this.f73659b = iArr;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Log.d("IndexTAGFragment", "value:" + floatValue);
            int[] iArr = this.f73659b;
            iArr[2] = iArr[2] + 1;
            IndexFragment.this.f73610p.scrollBy(1, 0);
        }
    }

    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f73661b;

        public d(int i11) {
            this.f73661b = i11;
        }

        public void run() {
            IndexFragment.this.f73564a2 = PixelUtils.a(150.0f) / 2;
            if (this.f73661b <= 10) {
                IndexFragment.this.Z1 = PixelUtils.a(150.0f);
                IndexFragment.this.X.setVisibility(8);
            } else {
                IndexFragment.this.Z1 = PixelUtils.a(168.0f);
                IndexFragment.this.X.setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = IndexFragment.this.f73570c2.getLayoutParams();
            layoutParams.height = this.f73661b <= 5 ? IndexFragment.this.f73564a2 : IndexFragment.this.Z1;
            IndexFragment.this.f73570c2.setLayoutParams(layoutParams);
        }
    }

    public class d0 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int[] f73663b;

        public d0(int[] iArr) {
            this.f73663b = iArr;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Log.d("IndexTAGFragment", "value:" + floatValue);
            int[] iArr = this.f73663b;
            iArr[3] = iArr[3] + 1;
            IndexFragment.this.f73610p.scrollBy(-1, 0);
        }
    }

    public class e implements ConsecutiveScrollerLayout.e {
        public e() {
        }

        public void a(View view, int i11, int i12, int i13) {
            boolean unused = IndexFragment.this.f73632v1 = true;
            int unused2 = IndexFragment.this.G1 = i11;
            IndexFragment.this.gm();
            IndexFragment indexFragment = IndexFragment.this;
            indexFragment.Kl(indexFragment.G1);
            if (IndexFragment.this.f73597l1 == -1) {
                OtcOrderReminder.e().k(IndexFragment.this.T0, true);
                i6.i.b().g(IndexFragment.this.C1, 100);
            }
            long unused3 = IndexFragment.this.f73597l1 = System.currentTimeMillis();
            IndexFragment.this.Hl(i11, i12);
            if (!(IndexFragment.this.f73617r1 == null || IndexFragment.this.f73620s1 == null || IndexFragment.this.f73624t1 == null)) {
                if (IndexFragment.this.T0.getScrollY() >= IndexFragment.this.E.getHeight()) {
                    IndexFragment.this.wl(true);
                    gs.g.i("app_recome_show", HomeSensorsHelper.b(HomeHelper.d(IndexFragment.this.f73640x1, IndexFragment.this.f73644y1)));
                } else {
                    IndexFragment.this.wl(false);
                }
            }
            i6.d.c("initInformationView", " scrollY : " + i11 + "oldScrollY : " + i12);
        }
    }

    public class e0 extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int[] f73666b;

        public e0(int[] iArr) {
            this.f73666b = iArr;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            int[] iArr = this.f73666b;
            int i11 = (iArr[0] * 3) + (iArr[1] * -5) + (iArr[2] * 1) + (iArr[3] * -1);
            if (i11 != 0) {
                Log.d("IndexTAGFragment", "endDistance:" + i11);
                if (i11 > 0) {
                    IndexFragment.this.f73610p.scrollBy(-i11, 0);
                } else {
                    IndexFragment.this.f73610p.scrollBy(Math.abs(i11), 0);
                }
            }
        }
    }

    public class f implements TopScrollView.b {
        public f() {
        }

        public void a(TopScrollData topScrollData) {
            if (topScrollData != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("notice_tag", topScrollData.h());
                hashMap.put("notice_is_top", 0);
                hashMap.put("notice_id", String.valueOf(topScrollData.g()));
                hashMap.put("testKey", "A");
                gs.g.i("notice_show", hashMap);
            }
        }

        public void b() {
            yl.o.D(IndexFragment.this.getActivity(), BaseModuleConfig.a().o(""), "", false);
            HashMap hashMap = new HashMap();
            hashMap.put("testKey", "A");
            hashMap.put("module_name", TUIConstants.TUIChat.NOTICE);
            hashMap.put("button_name", "more");
            gs.g.i("appclick_home", hashMap);
        }

        public void c(TopScrollData topScrollData) {
            if (topScrollData != null && !TextUtils.isEmpty(topScrollData.j())) {
                IndexWebActivity.xh(IndexFragment.this.getActivity(), topScrollData.j(), IndexFragment.this.getResources().getString(R.string.announcement), IndexFragment.this.getResources().getString(R.string.head_return), false);
                HashMap hashMap = new HashMap();
                hashMap.put("notice_tag", topScrollData.h());
                hashMap.put("notice_is_top", 0);
                hashMap.put("notice_id", String.valueOf(topScrollData.g()));
                hashMap.put("testKey", "A");
                gs.g.i("notice_click", hashMap);
            }
        }
    }

    public class f0 implements IndexTextListIndicator.d {
        public f0() {
        }

        public void a(int i11, View view) {
        }

        public void onItemClick(int i11) {
            String str = "140";
            if (i11 != 0) {
                if (i11 == 1) {
                    str = "141";
                } else if (i11 == 2) {
                    str = "142";
                }
            }
            is.a.i(str, (Map<String, Object>) null);
            IndexFragment.this.D0.setCurrentItem(i11);
        }
    }

    public class g implements BaseDialogFragment.c {
        public g() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            IndexFragment.this.D.playAnimation();
        }

        public void onDialogFragmentResume() {
        }
    }

    public static /* synthetic */ class g0 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f73671a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent[] r0 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f73671a = r0
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent r1 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.EVENT_WIFI_CONNECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f73671a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent r1 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.EVENT_MOBILE_CONNECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f73671a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent r1 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.EVENT_NET_VPN_CONNECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f73671a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.common.network.NetworkStatus$ConnectEvent r1 = com.hbg.lib.common.network.NetworkStatus.ConnectEvent.EVENT_NET_DISCONNECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.index.ui.IndexFragment.g0.<clinit>():void");
        }
    }

    public class h implements BaseDialogFragment.c {
        public h() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            IndexFragment.this.D.playAnimation();
        }

        public void onDialogFragmentResume() {
        }
    }

    public class h0 extends RecyclerView.ItemDecoration {
        public h0() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            rect.set((childAdapterPosition == 0 || childAdapterPosition == 3 || childAdapterPosition == 6) ? 0 : IndexFragment.this.K1, 0, 0, 0);
        }
    }

    public class i implements Animator.AnimatorListener {
        public i() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            IndexFragment.this.D.setProgress(0.01f);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public class i0 implements Runnable {
        public i0() {
        }

        public void run() {
            try {
                i6.i.b().h(this);
                if (IndexFragment.this.f73648z1) {
                    i6.i.b().g(IndexFragment.this.R1, 50);
                } else if (SP.e("sp_key_index_home_flow_config_user_guide", 0) == 1) {
                    ((IndexPresenter) IndexFragment.this.yh()).D2(IndexFragment.this.A1);
                } else if (IndexFragment.this.A1) {
                    ((IndexPresenter) IndexFragment.this.yh()).F2();
                } else {
                    ((IndexPresenter) IndexFragment.this.yh()).t2(true);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class j extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a  reason: collision with root package name */
        public boolean f73676a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f73677b = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f73678c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f73679d = 0;

        public j() {
        }

        public void onPageScrollStateChanged(int i11) {
            super.onPageScrollStateChanged(i11);
            i6.d.c("caoxianjin", "ball_icon_show, state:" + i11 + ", prevState:" + this.f73679d);
            if (i11 == 0 && this.f73679d == 2) {
                HashMap hashMap = new HashMap();
                if (IndexFragment.this.U.getCurrentItem() == 0) {
                    hashMap.put("type_list", IndexFragment.this.X1);
                } else {
                    hashMap.put("type_list", IndexFragment.this.Y1);
                }
                hashMap.put("testKey", "A");
                gs.g.i("ball_icon_show", hashMap);
            }
            this.f73679d = i11;
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            IndexFragment indexFragment = IndexFragment.this;
            if (indexFragment.Z1 == 0) {
                indexFragment.Z1 = indexFragment.f73570c2.getHeight();
                IndexFragment indexFragment2 = IndexFragment.this;
                indexFragment2.f73564a2 = (indexFragment2.Z1 / 2) + 30;
            }
            boolean z11 = false;
            if (IndexFragment.this.W.size() == 1) {
                ViewGroup.LayoutParams layoutParams = IndexFragment.this.f73570c2.getLayoutParams();
                if (IndexFragment.this.W1 == null || IndexFragment.this.W1.get(0) == null || ((Integer) IndexFragment.this.W1.get(0)).intValue() > 5) {
                    layoutParams.height = IndexFragment.this.Z1;
                } else {
                    layoutParams.height = IndexFragment.this.f73564a2;
                }
                IndexFragment.this.f73570c2.setLayoutParams(layoutParams);
            }
            if (IndexFragment.this.W.size() > 1) {
                if (i12 != 0) {
                    if (this.f73677b < i12) {
                        z11 = true;
                    }
                    this.f73676a = z11;
                    this.f73677b = i12;
                }
                if (this.f73676a) {
                    IndexFragment indexFragment3 = IndexFragment.this;
                    this.f73678c = indexFragment3.Z1;
                    int i13 = i11 + 1;
                    if (indexFragment3.W1.containsKey(Integer.valueOf(i13))) {
                        if (((Integer) IndexFragment.this.W1.get(Integer.valueOf(i13))).intValue() <= 5) {
                            float Qi = (((float) i12) * 1.0f) / ((float) IndexFragment.this.f73646z);
                            IndexFragment indexFragment4 = IndexFragment.this;
                            int i14 = (int) (((float) indexFragment4.Z1) * (1.0f - Qi));
                            this.f73678c = i14;
                            int i15 = indexFragment4.f73564a2;
                            if (i14 <= i15) {
                                this.f73678c = i15;
                            }
                        }
                    } else if (((Integer) IndexFragment.this.W1.get(Integer.valueOf(i11))).intValue() <= 5) {
                        this.f73678c = IndexFragment.this.f73564a2;
                    } else {
                        this.f73678c = IndexFragment.this.Z1;
                    }
                } else if (i12 != 0) {
                    int Qi2 = (int) (((float) this.f73678c) * ((1.0f - ((((float) i12) * 1.0f) / ((float) IndexFragment.this.f73646z))) + 1.0f));
                    this.f73678c = Qi2;
                    int i16 = IndexFragment.this.Z1;
                    if (Qi2 >= i16) {
                        this.f73678c = i16;
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = IndexFragment.this.f73570c2.getLayoutParams();
                layoutParams2.height = this.f73678c;
                IndexFragment.this.f73570c2.setLayoutParams(layoutParams2);
            }
            super.onPageScrolled(i11, f11, i12);
        }

        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
        }
    }

    public class j0 extends BaseSubscriber<HomeFlowConfig> {
        public j0() {
        }

        /* renamed from: a */
        public void onNext(HomeFlowConfig homeFlowConfig) {
            int i11;
            int i12;
            super.onNext(homeFlowConfig);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("data:");
            sb2.append(homeFlowConfig != null ? homeFlowConfig.toString() : " is null");
            Log.d("IndexTAGFragment", sb2.toString());
            int i13 = 1;
            int i14 = 0;
            if (homeFlowConfig != null) {
                i14 = homeFlowConfig.getUserGuide();
                int porcelain = homeFlowConfig.getPorcelain();
                i12 = homeFlowConfig.getOperPosition();
                int i15 = porcelain;
                i13 = homeFlowConfig.getNewHome();
                i11 = i15;
            } else {
                i11 = 0;
                i12 = 0;
            }
            SP.q("sp_key_index_home_flow_config_user_guide", i14);
            SP.q("sp_key_index_home_flow_config_porcelain", i11);
            SP.q("sp_key_index_home_flow_config_operposition", i12);
            SP.q("sp_key_index_home_flow_config_newhome", i13);
        }

        public void onAfter() {
            super.onAfter();
            boolean unused = IndexFragment.this.f73648z1 = false;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error:");
            sb2.append(th2 != null ? th2.getMessage() : "");
            Log.e("IndexTAGFragment", sb2.toString());
            SP.q("sp_key_index_home_flow_config_user_guide", 0);
            SP.q("sp_key_index_home_flow_config_porcelain", 0);
            SP.q("sp_key_index_home_flow_config_operposition", 0);
            SP.q("sp_key_index_home_flow_config_newhome", 1);
        }
    }

    public class k implements Runnable {
        public k() {
        }

        public void run() {
            if (System.currentTimeMillis() - IndexFragment.this.f73597l1 > 100) {
                long unused = IndexFragment.this.f73597l1 = -1;
                boolean unused2 = IndexFragment.this.f73632v1 = false;
                IndexFragment.this.pl();
                return;
            }
            i6.i.b().g(this, 100);
        }
    }

    public class k0 extends ViewPager2.OnPageChangeCallback {
        public k0() {
        }

        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            IndexPresenter.X = i11;
            IndexFragment.this.f73613q.setPosition(i11);
        }
    }

    public class l implements ViewPager.OnPageChangeListener {
        public l() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            IndexFragment.this.H0.setText(str);
        }

        public void onPageScrollStateChanged(int i11) {
            if (i11 == 0) {
                boolean unused = IndexFragment.this.Z0 = true;
            } else {
                boolean unused2 = IndexFragment.this.Z0 = false;
            }
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            int i12;
            if (IndexFragment.this.f73573d2 != null) {
                IndexFragment indexFragment = IndexFragment.this;
                RankList unused = indexFragment.F1 = (RankList) indexFragment.f73573d2.get(i11);
            }
            if (IndexFragment.this.D0.getOffscreenPageLimit() != IndexFragment.this.Y0.size()) {
                i6.d.c("ray21", "setOffscreenPageLimit " + IndexFragment.this.D0.getOffscreenPageLimit());
                IndexFragment.this.D0.setOffscreenPageLimit(IndexFragment.this.Y0.size());
            }
            i6.d.j("FutureRank", "onPageSelected pos=" + i11);
            IndexRankingFragmentDecorator indexRankingFragmentDecorator = (IndexRankingFragmentDecorator) IndexFragment.this.Y0.get(i11);
            if (indexRankingFragmentDecorator != null) {
                indexRankingFragmentDecorator.Bh();
            }
            String str = null;
            boolean z11 = false;
            if (IndexFragment.this.F1 != null) {
                i12 = IndexFragment.this.F1.getType();
                if (IndexFragment.this.F1.isScreen()) {
                    RankScreenBean h11 = yl.t.h();
                    if (h11 != null) {
                        str = h11.getScreenValue();
                    }
                    if (indexRankingFragmentDecorator != null) {
                        indexRankingFragmentDecorator.Eh(true);
                    }
                } else if (indexRankingFragmentDecorator != null) {
                    indexRankingFragmentDecorator.Eh(false);
                }
                yl.t.p(IndexFragment.this.F1.isScreen());
                IndexRankingTrackHelper.a(IndexFragment.this.F1.getType(), str);
            } else {
                i12 = 1;
            }
            IndexFragment.this.D0.resetHeight(i11);
            b7.b.j(new q0(this));
            b7.b.h(str, i12);
            IndexSPHelper.f("index_rank_sp", "rank_user_select_position_" + tg.r.x().s(), ((RankList) IndexFragment.this.f73573d2.get(i11)).getType());
            IndexViewPager Li = IndexFragment.this.D0;
            if (IndexFragment.this.F1.getType() != 9) {
                z11 = true;
            }
            Li.setCanScroll(z11);
            if (indexRankingFragmentDecorator != null) {
                indexRankingFragmentDecorator.Gh();
            }
        }
    }

    public class l0 implements TabLayout.OnTabSelectedListener {
        public l0() {
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        @SensorsDataInstrumented
        public void onTabSelected(TabLayout.Tab tab) {
            try {
                if (tab.getPosition() == 5 && tab.getCustomView() != null) {
                    ((TextView) tab.getCustomView().findViewById(R.id.tvTabTitle)).setTextColor(IndexFragment.this.getResources().getColor(R.color.color_12B298));
                    gs.g.i("app_recome_tab_click", HomeSensorsHelper.b(5));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            try {
                if (tab.getPosition() == 5 && tab.getCustomView() != null) {
                    ((TextView) tab.getCustomView().findViewById(R.id.tvTabTitle)).setTextColor(IndexFragment.this.getResources().getColor(R.color.baseColorSecondaryIconButton));
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class m implements tx.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IndexFeatureItem f73686a;

        public m(IndexFeatureItem indexFeatureItem) {
            this.f73686a = indexFeatureItem;
        }

        public void a(String str, View view) {
        }

        public void b(String str, View view, FailReason failReason) {
        }

        public void c(String str, View view, Bitmap bitmap) {
            if (bitmap != null && i6.m.a(String.valueOf(0.7375f)).compareTo(i6.m.a(String.valueOf((((float) bitmap.getWidth()) * 1.0f) / ((float) bitmap.getHeight())))) == 0) {
                PromoteFeatureDialog.xh(this.f73686a);
                if (yl.s.a()) {
                    IndexFragment.this.Yl();
                }
            }
        }

        public void d(String str, View view) {
        }
    }

    public class m0 implements Runnable {
        public m0() {
        }

        public void run() {
            IndexFragment.this.Q7(0);
        }
    }

    public class n implements PermissionUtils.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f73689a;

        public n(String[] strArr) {
            this.f73689a = strArr;
        }

        public void onResult(int i11) {
            if (i11 == 0) {
                i6.d.i("HasPermissions, start CaptureActivity.");
                Intent intent = new Intent(IndexFragment.this.getActivity(), CaptureActivity.class);
                intent.putExtra(CaptureActivity.PARAM_HINT_TEXT, IndexFragment.this.getString(R.string.n_scan_automation_tips));
                IndexFragment.this.startActivityForResult(intent, 1001);
            } else if (i11 == 2) {
                i6.d.i("Has not Permissions, start request permissions.");
                EasyPermissions.requestPermissions(IndexFragment.this.getActivity(), 123, this.f73689a);
            }
        }
    }

    public class o extends EasySubscriber<TokenBindInfo> {
        public o() {
        }

        /* renamed from: a */
        public void onNext(TokenBindInfo tokenBindInfo) {
            super.onNext(tokenBindInfo);
            IndexFragment.super.dismissProgressDialog();
            ScanLoginSuccessActivity.ph(IndexFragment.this.getActivity(), tokenBindInfo);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            IndexFragment.super.dismissProgressDialog();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            IndexFragment.super.dismissProgressDialog();
        }

        public void onStart() {
            super.onStart();
            IndexFragment.super.showProgressDialog();
        }
    }

    public class p extends EasySubscriber<TsvMsg> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f73692b;

        public p(String str) {
            this.f73692b = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(String str, TsvMsg tsvMsg) {
            VerificationStartActivity.fg(IndexFragment.this.getActivity(), str, tsvMsg.getTsvMsg());
        }

        /* renamed from: c */
        public void onNext(TsvMsg tsvMsg) {
            super.onNext(tsvMsg);
            i6.i.b().g(new r0(this, this.f73692b, tsvMsg), 20);
        }

        public void onAfter() {
            super.onAfter();
            IndexFragment.super.dismissProgressDialog();
        }

        public void onStart() {
            super.onStart();
            IndexFragment.super.showProgressDialog();
        }
    }

    public class q implements RectangleScaleToCircleView.IAnimationPlayState {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f73694a;

        public q(ImageView imageView) {
            this.f73694a = imageView;
        }

        public void onPlayEnd() {
            IndexFragment indexFragment = IndexFragment.this;
            indexFragment.tl(indexFragment.f73577f0, IndexFragment.this.f73581g1, this.f73694a);
            IndexFragment.this.lk();
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            BaseModuleConfig.a().k0(IndexFragment.S2.tradingToEarn.url);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "invest");
            hashMap.put("button_name", "tradingToEarn");
            gs.g.i("appclick_home", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class s implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageInvestData.InvestDrawerSpotAndMartingaleData f73697b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f73698c;

        public s(HomePageInvestData.InvestDrawerSpotAndMartingaleData investDrawerSpotAndMartingaleData, int i11) {
            this.f73697b = investDrawerSpotAndMartingaleData;
            this.f73698c = i11;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            BaseModuleConfig.a().k0(this.f73697b.url);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "invest");
            hashMap.put("button_name", this.f73698c == 0 ? "spotGrid" : "martingale");
            gs.g.i("appclick_home", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class t implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageInvestData.InvestDrawerDualData f73700b;

        public t(HomePageInvestData.InvestDrawerDualData investDrawerDualData) {
            this.f73700b = investDrawerDualData;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            BaseModuleConfig.a().k0(this.f73700b.url);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "invest");
            hashMap.put("button_name", "dual");
            gs.g.i("appclick_home", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class u extends BaseSubscriber<Long> {
        public u() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            Message message = new Message();
            message.obj = l11;
            message.what = 21;
            IndexFragment.this.P1.sendMessage(message);
        }
    }

    public class v extends Handler {
        public v() {
        }

        public void handleMessage(Message message) {
            int i11;
            int i12;
            int i13 = message.what;
            int i14 = 0;
            if (i13 == 0) {
                int i15 = message.arg1;
                int i16 = message.arg2;
                Object obj = message.obj;
                if (obj != null) {
                    i14 = ((Integer) obj).intValue();
                }
                if (i14 != 0) {
                    int a11 = ColorUtils.a(i15, i16, (((float) i14) * 1.0f) / ((float) IndexFragment.this.f73646z));
                    IndexFragment indexFragment = IndexFragment.this;
                    indexFragment.L1 = a11;
                    indexFragment.Hc(a11);
                }
            } else if (i13 == 1) {
                int i17 = message.arg1;
                IndexFragment indexFragment2 = IndexFragment.this;
                indexFragment2.L1 = i17;
                if (indexFragment2.L.getVisibility() == 0) {
                    IndexFragment.this.Hc(i17);
                }
            } else if (i13 == 2) {
                if (IndexFragment.this.O) {
                    i12 = Color.parseColor("#081724");
                } else {
                    i12 = Color.parseColor("#2D3D52");
                }
                IndexFragment indexFragment3 = IndexFragment.this;
                indexFragment3.L1 = i12;
                indexFragment3.Hc(i12);
            } else {
                int i18 = R.drawable.closepath_function_special_black;
                if (i13 == 3) {
                    int i19 = message.arg1;
                    int i21 = message.arg2;
                    int intValue = ((Integer) message.obj).intValue();
                    if (intValue < IndexFragment.P2) {
                        i11 = ColorUtils.a(i19, i21, (((float) intValue) * 1.0f) / ((float) IndexFragment.P2));
                    } else {
                        i11 = IndexFragment.this.O ? IndexFragment.this.M : IndexFragment.this.N;
                    }
                    if (IndexFragment.this.L.getVisibility() != 0) {
                        i11 = IndexFragment.this.getResources().getColor(R.color.baseColorDeepestBackground);
                    }
                    boolean unused = IndexFragment.this.O1 = false;
                    if (!IndexFragment.this.N1 && IndexFragment.this.G1 >= PixelUtils.a(80.0f)) {
                        boolean unused2 = IndexFragment.this.N1 = true;
                        String wi2 = IndexFragment.this.O ? IndexFragment.this.f73585h2 : IndexFragment.this.f73582g2;
                        f6.c.a().e(IndexFragment.this.f73581g1, wi2);
                        IndexFragment.this.Jl(wi2);
                    }
                    if (IndexFragment.this.G1 >= PixelUtils.a(80.0f)) {
                        ImageView Ai = IndexFragment.this.f73584h1;
                        if (IndexFragment.this.O) {
                            i18 = R.drawable.closepath_function_special;
                        }
                        Ai.setBackgroundResource(i18);
                    }
                    IndexFragment.this.P.setVisibility(0);
                    IndexFragment.this.Q.setVisibility(0);
                    IndexFragment.this.P.setBackgroundColor(i11);
                    IndexFragment.this.Q.setBackgroundColor(i11);
                    if (IndexFragment.this.G1 < PixelUtils.a(100.0f)) {
                        IndexFragment.this.P.setAlpha(0.4f);
                        IndexFragment.this.Q.setAlpha(0.4f);
                    } else {
                        IndexFragment.this.P.setAlpha(1.0f);
                        IndexFragment.this.Q.setAlpha(1.0f);
                    }
                } else if (i13 == 4) {
                    boolean unused3 = IndexFragment.this.N1 = false;
                    if (!IndexFragment.this.O1 && IndexFragment.this.G1 < PixelUtils.a(80.0f)) {
                        boolean unused4 = IndexFragment.this.O1 = true;
                        if (IndexFragment.this.f73593k1 == null || IndexFragment.this.f73593k1.getVisibility() != 0) {
                            f6.c.a().e(IndexFragment.this.f73581g1, IndexFragment.this.f73579f2);
                            IndexFragment indexFragment4 = IndexFragment.this;
                            indexFragment4.Jl(indexFragment4.f73579f2);
                        } else {
                            f6.c.a().e(IndexFragment.this.f73581g1, IndexFragment.this.O ? IndexFragment.this.f73585h2 : IndexFragment.this.f73582g2);
                        }
                    }
                    if (IndexFragment.this.G1 < PixelUtils.a(80.0f)) {
                        if (IndexFragment.this.L.getVisibility() == 0) {
                            IndexFragment.this.f73584h1.setBackgroundResource(R.drawable.closepath_function_special);
                        } else {
                            ImageView Ai2 = IndexFragment.this.f73584h1;
                            if (IndexFragment.this.O) {
                                i18 = R.drawable.closepath_function_special;
                            }
                            Ai2.setBackgroundResource(i18);
                        }
                    }
                    IndexFragment.this.S.setBackgroundResource(R.drawable.search_bar_shape);
                    IndexFragment.this.P.setVisibility(4);
                    IndexFragment.this.Q.setVisibility(4);
                } else if (i13 == 21) {
                    IndexFragment.this.xl();
                } else if (i13 == 22) {
                    IndexFragment.this.Al();
                } else if (i13 == 23) {
                    IndexFragment.this.yl();
                } else if (i13 == 5) {
                    ViewGroup.LayoutParams layoutParams = IndexFragment.this.f73574e0.getLayoutParams();
                    layoutParams.height = message.arg1;
                    IndexFragment.this.f73574e0.setLayoutParams(layoutParams);
                    if (layoutParams.height == 0) {
                        IndexFragment.this.f73574e0.setVisibility(8);
                    }
                    if (layoutParams.height > 0) {
                        Message obtainMessage = obtainMessage();
                        obtainMessage.what = 5;
                        int i22 = layoutParams.height - 20;
                        layoutParams.height = i22;
                        if (i22 < 0) {
                            layoutParams.height = 0;
                        }
                        obtainMessage.arg1 = layoutParams.height;
                        sendMessageDelayed(obtainMessage, 5);
                    }
                }
            }
            super.handleMessage(message);
        }
    }

    public class w extends BaseSubscriber<Long> {
        public w() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            Message message = new Message();
            message.obj = l11;
            message.what = 23;
            IndexFragment.this.P1.sendMessage(message);
        }
    }

    public class x extends GridLayoutManager.SpanSizeLookup {
        public x() {
        }

        public int getSpanSize(int i11) {
            Log.d("IndexTAGFragment", "getSpanSize: position = " + i11);
            return i11 == 0 ? 2 : 1;
        }
    }

    public class y extends RecyclerView.OnScrollListener {
        public y() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            super.onScrollStateChanged(recyclerView, i11);
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            if (!IndexFragment.this.Wj()) {
                IndexFragment.this.km();
            }
        }
    }

    public class z implements Runnable {
        public z() {
        }

        public void run() {
            IndexFragment.this.f73616r.playAnimation();
            IndexFragment.this.em();
            boolean unused = IndexFragment.this.f73619s = true;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fk(View view) {
        is.a.i("3558", (Map<String, Object>) null);
        HashMap hashMap = new HashMap();
        hashMap.put("testKey", "A");
        gs.g.i("home_topReward_click", hashMap);
        BaseModuleConfig.a().k0(this.f73588i2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gk(IndexHomePopListDialogFragment indexHomePopListDialogFragment, HomeCommonPopListItem homeCommonPopListItem) {
        int g11 = homeCommonPopListItem.g();
        if (g11 == 0) {
            jp.k0.k(getActivity());
            gs.g.i("more_deposit_click", (HashMap) null);
        } else if (g11 == 1) {
            fm();
            gs.g.i("more_scan_click", (HashMap) null);
        } else if (g11 == 2) {
            ra.c.b().p(getActivity());
            gs.g.i("more_chat_click", (HashMap) null);
        }
        indexHomePopListDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Hk(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f73567b2 <= 2000) {
            Log.d("IndexTAGFragment", "moreAction addEvent() called");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f73567b2 = currentTimeMillis;
        IndexHomePopListDialogFragment indexHomePopListDialogFragment = new IndexHomePopListDialogFragment();
        String t12 = ((IndexPresenter) yh()).t1();
        if (!TextUtils.isEmpty(t12)) {
            indexHomePopListDialogFragment.th(t12);
        }
        int[] iArr = new int[2];
        this.f73578f1.getLocationOnScreen(iArr);
        boolean z11 = true;
        indexHomePopListDialogFragment.setLocationRight(PixelUtils.a(10.0f));
        indexHomePopListDialogFragment.setLocationTop(iArr[1] + PixelUtils.a(12.0f));
        indexHomePopListDialogFragment.sh(new y(this, indexHomePopListDialogFragment));
        indexHomePopListDialogFragment.show(getChildFragmentManager(), "mHomeMorePopDialog");
        SP.r("sp_key_last_time_extra_tag", System.currentTimeMillis());
        View view2 = this.f73569c1;
        if (view2 != null) {
            if (view2.getVisibility() != 0) {
                z11 = false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("is_point", Boolean.valueOf(z11));
            hashMap.put("testKey", "A");
            gs.g.i("more_click", hashMap);
        }
        ViewUtil.m(this.f73569c1, false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ik(View view) {
        is.a.i("3565", (Map<String, Object>) null);
        SearchFlutterActivity.Fi(getActivity());
        if (this.B != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("pre_text", this.B.getText());
            hashMap.put("testKey", "A");
            gs.g.i("ll_search", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Jk(View view) {
        ((IndexPresenter) yh()).U1(2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Kk(Void voidR) {
        String str;
        String str2;
        IndexRankingFragmentDecorator indexRankingFragmentDecorator = this.Y0.get(this.D0.getCurrentItem());
        RankScreenBean h11 = yl.t.h();
        RankJumpInfo g11 = b7.b.g();
        if (g11 != null) {
            if (getActivity() != null) {
                if (g11.getTarget().intValue() == 1 && (g11.getRankType().intValue() == 1 || g11.getRankType().intValue() == 2 || g11.getRankType().intValue() == 4 || g11.getRankType().intValue() == 5 || g11.getRankType().intValue() == 6)) {
                    RankingActivity.uh(getActivity(), g11.getRankType().intValue());
                } else if (g11.getType() == null || g11.getType().intValue() != 1 || TextUtils.isEmpty(g11.getH5Url())) {
                    Intent l11 = com.huobi.utils.k0.l(getActivity());
                    Bundle bundle = new Bundle();
                    if (g11.getPrimaryTitle() == null) {
                        int ph2 = indexRankingFragmentDecorator.ph();
                        if (h11 != null) {
                            str = h11.getScreenValue();
                        } else {
                            str = "";
                        }
                        if (yl.t.m(ph2, str)) {
                            b7.b.k(3);
                            b7.b.l("usdt_future");
                        } else {
                            int ph3 = indexRankingFragmentDecorator.ph();
                            if (h11 != null) {
                                str2 = h11.getScreenValue();
                            } else {
                                str2 = "";
                            }
                            if (yl.t.l(ph3, str2)) {
                                b7.b.k(3);
                                b7.b.l("contract_future");
                            } else {
                                b7.b.k(2);
                                b7.b.l("USDT");
                            }
                        }
                        b7.b.i();
                        g11 = b7.b.g();
                    }
                    bundle.putInt("primaryTitle", g11.getPrimaryTitle().intValue());
                    bundle.putString("secondaryTitle", g11.getSecondaryTitle());
                    bundle.putInt("filter", g11.getFilter());
                    if (g11.getTitle() != null) {
                        bundle.putInt("sortType", g11.getTitle().getSortType());
                        bundle.putInt("sort", g11.getTitle().getSort());
                    }
                    l11.putExtras(bundle);
                    startActivity(l11);
                } else {
                    HBBaseWebActivity.showWebView(getActivity(), g11.getH5Url(), "", "", false);
                }
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("list_type", Integer.valueOf(indexRankingFragmentDecorator.ph()));
                RankList yh2 = indexRankingFragmentDecorator.yh();
                if (yh2 != null) {
                    if (yh2.isScreen()) {
                        if (h11 == null || h11.getScreenValue() == null) {
                            hashMap.put("select_type", "");
                        } else {
                            hashMap.put("select_type", h11.getScreenValue());
                        }
                        hashMap.put("testKey", "A");
                        gs.g.i("toplist_more_click", hashMap);
                    }
                }
                hashMap.put("select_type", "");
                hashMap.put("testKey", "A");
                gs.g.i("toplist_more_click", hashMap);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Lk(View view) {
        ((IndexPresenter) yh()).F2();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mk(View view, View view2) {
        if (view2 == null || view2.getId() != this.U0.getId()) {
            this.f73636w1.setBackgroundResource(R.color.baseColorContentBackground);
            this.U0.setBackgroundResource(R.color.baseColorContentBackground);
            bm(false);
            return;
        }
        this.f73636w1.setBackgroundResource(R.color.baseColorContentBackground);
        this.U0.setBackgroundResource(R.color.baseColorContentBackground);
        bm(true);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nk(View view) {
        Object navigation = b2.a.d().a("/provider/content").navigation();
        HbgBaseProvider hbgBaseProvider = navigation instanceof HbgBaseProvider ? (HbgBaseProvider) navigation : null;
        if (hbgBaseProvider == null || !hbgBaseProvider.j(getContext())) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (wf.a.f40622a.e()) {
            gc.b.f19131a.b((String) null, (TopicDetailInfo.HeaderInfo) null, (String) null, (String) null);
            HashMap hashMap = new HashMap();
            hashMap.put("pagename", "communityplaza");
            gs.g.i("app_community_fbdj", hashMap);
        } else {
            gc.b.f();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ok() {
        LoadingRelativeLayout loadingRelativeLayout = this.F;
        if (loadingRelativeLayout != null) {
            loadingRelativeLayout.a();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Pk(View view) {
        ((IndexPresenter) yh()).F2();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Qk(Integer num) {
        Q7(0);
    }

    public static /* synthetic */ void Rk(View view, Object obj) {
        try {
            view.findViewById(R.id.lavHomeLive).setVisibility(0);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Tk(HotSearchInfo hotSearchInfo, String str) {
        Bundle bundle = new Bundle();
        HotSearchInfo.HotWordContext.HotWord hotWord = (HotSearchInfo.HotWordContext.HotWord) new Gson().fromJson(str, HotSearchInfo.HotWordContext.HotWord.class);
        bundle.putString("hotWord", str);
        SearchFlutterActivity.Gi(getActivity(), bundle);
        El(hotSearchInfo, str, true, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Uk(HotSearchInfo hotSearchInfo, String str) {
        if (Q2) {
            El(hotSearchInfo, str, false, 1);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vk(HotSearchInfo hotSearchInfo) {
        HotSearchInfo.HotWordContext hotWordContext;
        List<HotSearchInfo.HotWordContext.HotWord> list;
        if (hotSearchInfo == null || (hotWordContext = hotSearchInfo.hotWordContext) == null || (list = hotWordContext.hotWords) == null || list.size() <= 0) {
            i6.d.c("hotWord", "request:隐藏");
            this.C.setVisibility(8);
            this.B.setVisibility(0);
            return;
        }
        i6.d.c("hotWord", "request:" + hotSearchInfo.hotWordContext.hotWords);
        this.C.setVisibility(0);
        View itemViewFront = this.C.getItemViewFront();
        View itemViewBehind = this.C.getItemViewBehind();
        if ((itemViewFront instanceof TextView) && (itemViewBehind instanceof TextView)) {
            Log.d("IndexTAGFragment", "changeHotWordTextColor");
            String str = "#808799";
            ((TextView) itemViewFront).setTextColor(Color.parseColor(this.O ? str : "#000000"));
            TextView textView = (TextView) itemViewBehind;
            if (!this.O) {
                str = "#000000";
            }
            textView.setTextColor(Color.parseColor(str));
        }
        this.B.setVisibility(8);
        int size = hotSearchInfo.hotWordContext.hotWords.size();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(new Gson().toJson((Object) hotSearchInfo.hotWordContext.hotWords.get(i11)));
        }
        this.C.setDatas(arrayList);
        this.C.setOnItemClickListener(new z(this, hotSearchInfo));
        this.C.setOnItemExposeListener(new a0(this, hotSearchInfo));
        El(hotSearchInfo, (String) arrayList.get(0), false, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wk(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f11 = 1.0f - floatValue;
        this.f73620s1.setAlpha(this.f73611p1 ? floatValue : f11);
        this.f73617r1.setAlpha(this.f73611p1 ? f11 : floatValue);
        this.f73617r1.setScaleX(this.f73611p1 ? f11 : floatValue);
        this.f73617r1.setScaleY(this.f73611p1 ? f11 : floatValue);
        this.f73624t1.setAlpha(this.f73611p1 ? floatValue : f11);
        CheckBox checkBox = this.f73624t1;
        if (this.f73611p1) {
            floatValue = f11;
        }
        checkBox.setTranslationY(floatValue * ((float) checkBox.getHeight()));
    }

    public static /* synthetic */ int Xk(IndexFeatureItem indexFeatureItem, IndexFeatureItem indexFeatureItem2) {
        return indexFeatureItem2.getWeight() - indexFeatureItem.getWeight();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Yk(HomePageEarnData homePageEarnData, View view) {
        IndexFeatureItem E3 = yl.o.E(homePageEarnData.more);
        if (E3 != null) {
            yl.o.p(getActivity(), E3);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("earn_index", 0);
        gs.g.i("earn_click", hashMap);
        hashMap.put("testKey", "A");
        gs.g.i("homeEarn_more_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Zk(List list, View view) {
        com.huobi.utils.v.a(getActivity(), ((HomeActivityEntity) list.get(0)).url, ((HomeActivityEntity) list.get(0)).title);
        HashMap hashMap = new HashMap();
        hashMap.put("name", ((HomeActivityEntity) list.get(0)).adName);
        gs.g.i("homeBanner_core_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void al(View view) {
        BaseModuleConfig.a().k0(S2.url);
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "invest");
        hashMap.put("button_name", "more");
        gs.g.i("appclick_home", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void bl(int i11, View view) {
        HBBaseWebActivity.showWebView(view.getContext(), this.f73589j0.getTakeAwardUrl(), "", "", false);
        yl.o.s("home_newMan", i11, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void cl(int i11, View view) {
        sl();
        Ll();
        yl.o.s("home_newMan", i11, "0");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void dl(int i11, View view) {
        HBBaseWebActivity.showWebView(view.getContext(), this.f73589j0.getTakeAwardUrl(), "", "", false);
        yl.o.s("home_newMan", i11, "1");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void el(int i11, View view) {
        if (i11 == 0) {
            if (getContext() != null) {
                SP.y("key_home_source_from_user_gift_bag_enter", true);
                rn.c.i().d(getContext(), (kn.a) null);
            }
        } else if (i11 == 1) {
            if (getActivity() != null) {
                jp.k0.k(getActivity());
            }
        } else if (i11 == 2) {
            sn.f.C(view.getContext(), "btcusdt", false, TradeType.PRO);
        } else if (i11 == 3) {
            HBBaseWebActivity.showWebView(view.getContext(), this.f73589j0.getTakeAwardUrl(), "", "", false);
        }
        yl.o.s("home_newMan", i11, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void fl(int i11, int i12, View view) {
        Bl(i11, i12, view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void gl(int i11, int i12, View view) {
        Bl(i11, i12, view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void hl(int i11, int i12, View view) {
        Vj(i11, i12, view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void il(int i11, int i12, View view) {
        Vj(i11, i12, view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void jl(int i11, int i12, View view) {
        ek(i11, i12, view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void kl(int i11, int i12, View view) {
        ek(i11, i12, view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ll(int i11, View view) {
        HBBaseWebActivity.showWebView(view.getContext(), this.f73589j0.getTakeAwardUrl(), "", "", false);
        yl.o.s("home_newMan", i11, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ml(HomePageEarnData.IndexAreaContentItemVo indexAreaContentItemVo, int i11, View view) {
        IndexFeatureItem E3 = yl.o.E(indexAreaContentItemVo.url);
        if (E3 != null) {
            yl.o.p(getActivity(), E3);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("earn_id", Integer.valueOf(indexAreaContentItemVo.projectId));
        hashMap.put("type", Integer.valueOf(indexAreaContentItemVo.shelfType));
        if (indexAreaContentItemVo.coupon != null) {
            hashMap.put(FirebaseAnalytics.Param.COUPON, (indexAreaContentItemVo.coupon.addRate * 100.0d) + "%");
        }
        hashMap.put("earn_site", Integer.valueOf(i11 + 2));
        hashMap.put("status", Integer.valueOf(indexAreaContentItemVo.projectStatus));
        if (indexAreaContentItemVo.shelfType == 4) {
            hashMap.put("name", "余币宝");
        } else {
            hashMap.put("name", indexAreaContentItemVo.currency);
        }
        hashMap.put("testKey", "A");
        gs.g.i("homeEarn_item_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void nl(HomePageEarnData.IndexAreaContentJumpVo indexAreaContentJumpVo, HomePageEarnData.IndexAreaContentItemVo indexAreaContentItemVo, View view) {
        IndexFeatureItem E3 = yl.o.E(indexAreaContentJumpVo);
        if (E3 != null) {
            yl.o.p(getActivity(), E3);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("earn_id", Integer.valueOf(indexAreaContentItemVo.projectId));
        hashMap.put("type", Integer.valueOf(indexAreaContentItemVo.shelfType));
        if (indexAreaContentItemVo.coupon != null) {
            hashMap.put(FirebaseAnalytics.Param.COUPON, (indexAreaContentItemVo.coupon.addRate * 100.0d) + "%");
        }
        hashMap.put("earn_site", 1);
        hashMap.put("status", Integer.valueOf(indexAreaContentItemVo.projectStatus));
        hashMap.put("name", indexAreaContentItemVo.currency);
        hashMap.put("testKey", "A");
        gs.g.i("homeEarn_item_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ol() {
        LoadingRelativeLayout loadingRelativeLayout;
        if (!this.A0.f() && (loadingRelativeLayout = this.F) != null) {
            loadingRelativeLayout.b();
        }
    }

    public void A9(boolean z11, boolean z12, boolean z13, HomePageNewUserGiftBagData homePageNewUserGiftBagData, long j11, int i11) {
        this.f73589j0 = homePageNewUserGiftBagData;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isLocalAllowed:");
        sb2.append(z11);
        sb2.append(" isServerAllowed:");
        sb2.append(z12);
        sb2.append(" userGuideHitted:");
        sb2.append(z13);
        sb2.append(" data:");
        sb2.append(homePageNewUserGiftBagData != null ? homePageNewUserGiftBagData.toString() : OptionsBridge.NULL_VALUE);
        Log.d("IndexTAGFragment", sb2.toString());
        if (!z11 || !z12 || z13 || homePageNewUserGiftBagData == null) {
            this.f73574e0.setVisibility(8);
            ((IndexPresenter) yh()).d3();
            return;
        }
        RelativeLayout relativeLayout = this.f73571d0;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        LinearLayout linearLayout = this.f73592k0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        Ul(i11);
        if (((IndexPresenter) yh()).H1() == -1) {
            Ml(j11);
        }
    }

    public void Ah() {
        dw.a.a(this.F0).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new h0(this));
        this.T0.setOnVerticalScrollChangeListener(new e());
        this.f73607o.setOnRetryClickListener(new l0(this));
        this.A.setCallback(new f());
        this.f73575e1.setOnClickListener(new b0(this));
        this.f73578f1.setOnClickListener(new j0(this));
        this.S.setOnClickListener(new m0(this));
        this.f73605n1.setDialogFragmentListener(new g());
        this.f73608o1.setDialogFragmentListener(new h());
        this.D.addAnimatorListener(new i());
        this.Q0.setOnClickListener(new n0(this));
        this.U.registerOnPageChangeCallback(new j());
    }

    public final void Ak() {
        this.B0 = this.f67460i.b(R.id.home_succeed_layout);
        this.A0 = new yl.l((ViewGroup) this.f67460i.b(R.id.home_loading_layout), (LottieAnimationView) this.f67460i.b(R.id.home_rank_skeleton_view_content));
        View b11 = this.f67460i.b(R.id.home_error_layout);
        this.f73647z0 = b11;
        b11.findViewById(R.id.viewErrorRetry).setOnClickListener(new q(this));
    }

    public final void Al() {
        long j11 = U2 - 1;
        U2 = j11;
        if (j11 < 0) {
            jm();
            this.f73580g0.setVisibility(8);
        } else if (isAdded()) {
            this.f73583h0.setText(DateTimeUtils.H(U2));
        }
    }

    public void Bc(List<RankList> list) {
        i6.d.j("FutureRank", "##updateRankView##");
        if (list != null && list.size() != 0 && this.Z0) {
            boolean z11 = true;
            if (Dk(list)) {
                this.f73573d2 = list;
                this.Y0.clear();
                this.X0.clear();
                int b11 = IndexSPHelper.b("index_rank_sp", "rank_user_select_position_" + tg.r.x().s(), Integer.MIN_VALUE);
                int i11 = 0;
                int i12 = -1;
                for (int i13 = 0; i13 < list.size(); i13++) {
                    IndexRankingFragmentDecorator indexRankingFragmentDecorator = new IndexRankingFragmentDecorator();
                    indexRankingFragmentDecorator.Ch(this);
                    indexRankingFragmentDecorator.Dh(list.get(i13));
                    indexRankingFragmentDecorator.Fh(this.D0, i13);
                    this.Y0.add(indexRankingFragmentDecorator);
                    this.X0.add(new y9.b(list.get(i13).getTypeTitle(), list.get(i13).getTagUrl(), list.get(i13).getType() == 4));
                    if (list.get(i13) != null) {
                        if (list.get(i13).getType() == 5) {
                            i11 = i13;
                        }
                        if (list.get(i13).getType() == b11) {
                            i12 = i13;
                        }
                    }
                }
                String ik2 = ik(list, i11, i12);
                this.C0.n(this.X0, false);
                this.I0.b(this.Y0);
                this.D0.setAdapter(this.I0);
                this.I0.notifyDataSetChanged();
                this.C0.c(0);
                IndexViewPager indexViewPager = this.D0;
                if (i12 != -1) {
                    i11 = i12;
                }
                indexViewPager.setCurrentItem(i11);
                yl.t.p(this.F1.isScreen());
                RankList rankList = this.F1;
                IndexRankingTrackHelper.a(rankList != null ? rankList.getType() : 1, ik2);
            } else {
                int currentItem = this.D0.getCurrentItem();
                for (int i14 = 0; i14 < this.Y0.size(); i14++) {
                    this.Y0.get(i14).Dh(list.get(i14));
                }
                if (this.Y0.size() > currentItem && list.size() > currentItem) {
                    this.Y0.get(currentItem).Bh();
                }
            }
            IndexViewPager indexViewPager2 = this.D0;
            if (this.F1.getType() == 9) {
                z11 = false;
            }
            indexViewPager2.setCanScroll(z11);
            List<IndexRankingFragmentDecorator> list2 = this.Y0;
            if (!(list2 == null || this.D0 == null || list2.size() <= this.D0.getCurrentItem() || this.Y0.get(this.D0.getCurrentItem()) == null)) {
                this.Y0.get(this.D0.getCurrentItem()).Gh();
            }
            this.f73573d2 = list;
            am();
        }
    }

    public void Bd(boolean z11) {
        int i11 = 0;
        this.F0.setVisibility(z11 ? 0 : 8);
        View view = this.G0;
        if (z11) {
            i11 = 8;
        }
        view.setVisibility(i11);
    }

    public void Bk(Activity activity) {
        if (PhoneUtils.w()) {
            String[] strArr = {"android.permission.ACCESS_FINE_LOCATION"};
            if (EasyPermissions.hasPermissions(getContext(), strArr)) {
                PhoneUtils.u(activity);
                PhoneUtils.j(activity);
                PhoneUtils.n(activity);
                return;
            }
            EasyPermissions.requestPermissions(this, 128, strArr);
            return;
        }
        PhoneUtils.u(activity);
        PhoneUtils.j(activity);
        PhoneUtils.n(activity);
    }

    public final void Bl(int i11, int i12, View view) {
        if (i11 == 1) {
            if (getActivity() != null) {
                SP.y("key_home_source_from_user_gift_bag_enter", true);
                rn.c.i().d(getContext(), (kn.a) null);
            }
        } else if (i11 == 2) {
            HBBaseWebActivity.showWebView(view.getContext(), this.f73589j0.getTakeAwardUrl(), "", "", false);
        } else if (i11 == 3) {
            HBBaseWebActivity.showWebView(view.getContext(), this.f73589j0.getMyPackageUrl(), "", "", false);
        }
        if (i11 != 0) {
            yl.o.t("home_newMan", i12, "2", i11 + "");
        }
    }

    public void Ca() {
        this.A0.d();
        f6().k();
    }

    public void Ch(int i11) {
        Nl();
    }

    public final boolean Ck() {
        SmartRefreshLayout smartRefreshLayout = this.I;
        return smartRefreshLayout != null && smartRefreshLayout.getState() == RefreshState.Loading;
    }

    public String Cl(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        char[] charArray = str.toCharArray();
        boolean z11 = true;
        for (int length = charArray.length - 1; length >= 0; length--) {
            if (z11) {
                if (charArray[length] != '0') {
                    sb2.append(charArray[length]);
                }
                if (sb2.length() > 0) {
                    z11 = false;
                }
            } else {
                sb2.append(charArray[length]);
            }
        }
        String sb3 = sb2.reverse().toString();
        return sb3.endsWith(InstructionFileId.DOT) ? sb3.substring(0, sb3.length() - 1) : sb3;
    }

    public void Dh(int i11) {
        FeedFragment c11 = HomeHelper.c(this.f73640x1, this.f73644y1);
        if (c11 != null) {
            c11.fi(i11);
            return;
        }
        gs.g.i("app_recome_show", HomeSensorsHelper.b(HomeHelper.d(this.f73640x1, this.f73644y1)));
        Nl();
    }

    public final boolean Dk(List<RankList> list) {
        List<RankList> list2 = this.f73573d2;
        if (list2 == null || list2.size() != list.size()) {
            return true;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            RankList rankList = this.f73573d2.get(i11);
            RankList rankList2 = list.get(i11);
            if (rankList != null && !rankList.isSameTab(rankList2)) {
                return true;
            }
        }
        return false;
    }

    public final void Dl() {
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "invest");
        hashMap.put("activity_is_show", Boolean.valueOf(S2.tradingToEarn != null));
        gs.g.i("appexposure_home", hashMap);
    }

    public boolean Ek() {
        return this.f73632v1;
    }

    public final void El(HotSearchInfo hotSearchInfo, String str, boolean z11, int i11) {
        HotSearchInfo.HotWordContext.HotWord hotWord = (HotSearchInfo.HotWordContext.HotWord) new Gson().fromJson(str, HotSearchInfo.HotWordContext.HotWord.class);
        HashMap hashMap = new HashMap();
        if (!z11) {
            hashMap.put("expose_type", Integer.valueOf(i11));
        }
        hashMap.put("pre_text", str);
        String str2 = hotWord.type;
        if (str2 != null) {
            if (str2.equals("search_word")) {
                hashMap.put("query_type", 1);
            } else if (hotWord.type.equals("feature_word")) {
                hashMap.put("query_type", 2);
            }
        }
        hashMap.put(MessageKey.MSG_TRACE_ID, hotSearchInfo.hotWordContext.traceId);
        hashMap.put("strategy", hotWord.strategy);
        List<String> list = hotSearchInfo.hotWordContext.extra;
        if (list != null) {
            hashMap.put("extra", list);
        }
        if (z11) {
            hashMap.put("testKey", "A");
            gs.g.i("ll_search", hashMap);
            return;
        }
        gs.g.i("ll_search_Expose", hashMap);
    }

    public void F7(int i11) {
        if (this.f73638x.getVisibility() != 0 && i11 == 1) {
            this.f73642y.setVisibility(0);
        }
    }

    public final void Fl(boolean z11) {
        Log.d("IndexTAGFragment", "requestHomeFlowConfig -- isPullToRefresh:" + z11);
        this.f73648z1 = true;
        this.A1 = z11;
        i6.i.b().g(this.R1, 2000);
        HashMap hashMap = new HashMap();
        hashMap.put("HB-CTX-ID", ConfigPreferences.e("user_config", "config_current_uid", ""));
        v7.b.a().getHomeFlowConfig(hashMap).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new j0());
    }

    public void Gl(String str) {
        i6.d.j("QR-SCAN", "requestTsvMsg");
        HashMap hashMap = new HashMap();
        hashMap.put("tsvToken", str);
        hashMap.put("uid", tg.r.x().s());
        hashMap.put("lang", AppLanguageHelper.getInstance().getCurLanguageHeader());
        ((RiskService) tq.p.Y(RiskService.class)).getTsvMsg(hashMap).compose(tq.p.Z()).compose(RxJavaHelper.t(zh())).subscribe(new p(str));
    }

    public void Hc(int i11) {
        this.K.setBackgroundColor(i11);
        this.L.setBackgroundColor(i11);
    }

    public final void Hl(int i11, int i12) {
        int i13 = P2;
        int i14 = R.drawable.search_bar_shape_special_day;
        if (i11 > i13) {
            if (this.O) {
                i14 = R.drawable.search_bar_shape_special_night;
            }
            this.S.setBackgroundResource(i14);
            if (this.O) {
                this.B.setTextColor(Color.parseColor("#808799"));
            }
        } else if (i11 != i12) {
            boolean z11 = i11 > i12;
            Message obtainMessage = this.P1.obtainMessage();
            if (z11) {
                this.O2 = 0;
                obtainMessage.what = 3;
                obtainMessage.arg1 = this.L1;
                obtainMessage.arg2 = this.O ? this.M : this.N;
                obtainMessage.obj = Integer.valueOf(i11);
            } else {
                if (i11 == 0) {
                    this.S.setBackgroundResource(R.drawable.search_bar_shape_special_day);
                    this.B.setTextColor(Color.parseColor("#000000"));
                }
                if (this.O2 == 0) {
                    this.O2 = i12;
                }
                if (i11 == 0) {
                    obtainMessage.what = 4;
                } else {
                    int abs = Math.abs(i11 - this.O2);
                    if (abs < P2) {
                        obtainMessage.what = 3;
                        obtainMessage.arg1 = this.O ? this.M : this.N;
                        obtainMessage.arg2 = this.L1;
                        obtainMessage.obj = Integer.valueOf(abs);
                    } else {
                        obtainMessage.what = 4;
                    }
                }
            }
            this.P1.sendMessage(obtainMessage);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void I2(int i11, int i12) {
        int i13 = 0;
        this.f73603n.setVisibility(i12 > 1 ? 0 : 8);
        this.T.setVisibility(i12 > 0 ? 8 : 0);
        this.G.setText("" + i11);
        this.H.setText("/" + i12);
        this.G.setVisibility(i12 > 1 ? 0 : 8);
        TextView textView = this.H;
        if (i12 <= 1) {
            i13 = 8;
        }
        textView.setVisibility(i13);
    }

    public void Ic(Map<String, RealTimePrice> map) {
        int i11;
        wl.c cVar;
        String str;
        if (this.H1 && isAdded()) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : map.entrySet()) {
                if (!(next.getKey() == null || next.getValue() == null)) {
                    RealTimePrice realTimePrice = (RealTimePrice) next.getValue();
                    realTimePrice.F((String) next.getKey());
                    arrayList.add(realTimePrice);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (this.T1 == null) {
                View inflate = View.inflate(getActivity(), R.layout.index_market_vertical_list_item, (ViewGroup) null);
                this.T1 = (TextView) inflate.findViewById(R.id.id_index_market_vertical_list_item_symbol);
                this.U1 = (TextView) inflate.findViewById(R.id.id_index_market_vertical_list_item_percent);
            }
            this.S1.clear();
            this.V1 = 0;
            this.V1 = this.I1 + 0;
            int min = Math.min(arrayList.size(), 9);
            for (int i12 = 0; i12 < min; i12++) {
                RealTimePrice realTimePrice2 = (RealTimePrice) arrayList.get(i12);
                if (!TextUtils.isEmpty(realTimePrice2.o())) {
                    SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(realTimePrice2.o());
                    ContractCurrencyInfo b11 = ContractCurrencyUtils.b(realTimePrice2.o());
                    SymbolBean J3 = a1.v().J(realTimePrice2.o(), TradeType.PRO);
                    if (!TextUtils.isEmpty(realTimePrice2.q()) && "2".equals(realTimePrice2.q()) && b11 != null) {
                        cVar = new wl.c(realTimePrice2);
                        cVar.f(b11);
                    } else if (!TextUtils.isEmpty(realTimePrice2.q()) && "3".equals(realTimePrice2.q()) && c11 != null) {
                        cVar = new wl.c(realTimePrice2);
                        cVar.g(c11);
                    } else if ((TextUtils.isEmpty(realTimePrice2.q()) || "1".equals(realTimePrice2.q())) && (J3 != null || realTimePrice2.p() == 1)) {
                        cVar = new wl.c(realTimePrice2);
                    } else {
                        cVar = null;
                    }
                    try {
                        if (realTimePrice2.p() == 0) {
                            str = MarketVerticalListItemHandler.f(getContext(), cVar, realTimePrice2);
                        } else {
                            str = realTimePrice2.o();
                        }
                        if (!TextUtils.isEmpty(str)) {
                            arrayList2.add(cVar);
                            float measureText = this.T1.getPaint().measureText(str);
                            float measureText2 = this.U1.getPaint().measureText(MarketVerticalListItemHandler.c(realTimePrice2));
                            this.S1.add(Integer.valueOf(this.V1));
                            int i13 = this.V1 + this.K1;
                            this.V1 = i13;
                            this.V1 = i13 + ((int) (measureText + ((float) ((int) getResources().getDimension(R.dimen.dimen_3))) + measureText2));
                        }
                    } catch (Exception e11) {
                        i6.k.j("IndexFragment-->setMiddleListViewData-->", e11);
                    }
                }
            }
            if (arrayList2.size() > 3) {
                i11 = 2;
                if (arrayList2.size() <= 6) {
                    this.f73613q.setPages(2);
                } else {
                    this.f73613q.setPages(3);
                    i11 = 3;
                }
                this.f73613q.setVisibility(0);
            } else {
                this.f73613q.setVisibility(4);
                i11 = 1;
            }
            if (this.N0.size() > 0) {
                this.N0.clear();
            }
            for (int i14 = 0; i14 < i11; i14++) {
                if (i14 == 0) {
                    if (this.K0 == null) {
                        this.K0 = bk();
                    }
                    this.K0.setData(arrayList2.subList(0, Math.min(arrayList2.size(), 3)));
                    this.N0.add(this.K0);
                } else if (i14 == 1) {
                    if (this.L0 == null) {
                        this.L0 = bk();
                    }
                    this.L0.setData(arrayList2.subList(3, Math.min(arrayList2.size(), 6)));
                    this.N0.add(this.L0);
                } else {
                    if (this.M0 == null) {
                        this.M0 = bk();
                    }
                    this.M0.setData(arrayList2.subList(6, Math.min(arrayList2.size(), 9)));
                    this.N0.add(this.M0);
                }
            }
            yg.c cVar2 = this.J0;
            if (cVar2 != null) {
                cVar2.d(this.N0);
            }
            if (arrayList2.size() >= 1) {
                this.f73638x.setVisibility(0);
                this.f73642y.setVisibility(0);
                if (!this.f73619s) {
                    rl();
                    return;
                }
                return;
            }
            this.f73638x.setVisibility(8);
            this.f73642y.setVisibility(8);
        }
    }

    public final void Il(int i11) {
        if (i11 >= this.f73599m.getHeight() - (this.A.getHeight() / 2)) {
            gm();
            return;
        }
        if (!this.f73599m.isPlaying()) {
            i6.d.c("ray25", "setBannnerStatus setPlayDelay");
            this.f73599m.setPlayDelay(5000);
        }
        if (!this.A.e()) {
            this.A.g();
        }
    }

    public final void Jl(String str) {
        this.f73576e2 = str;
    }

    public void K9() {
        this.A0.k(false);
        this.f73647z0.setVisibility(8);
        this.B0.setVisibility(0);
    }

    public final void Kl(int i11) {
        if (((double) i11) >= ((double) this.L.getHeight()) + (((double) this.f73638x.getHeight()) * 0.7d)) {
            if (this.H1) {
                this.H1 = false;
                i6.d.c("ray25", "setMiddleListStatus mIsRefreshMarketList " + this.H1);
            }
        } else if (!this.H1) {
            this.H1 = true;
            i6.d.c("ray25", "setMiddleListStatus mIsRefreshMarketList " + this.H1);
        }
    }

    public void Ll() {
        long currentTimeMillis = System.currentTimeMillis() / Period.DAY_MILLS;
        SP.r("key_new_hand_gift_bag_close_date", Long.parseLong(currentTimeMillis + ""));
    }

    public void Ml(long j11) {
        long j12 = j11 / Period.DAY_MILLS;
        SP.r("key_new_user_gift_bag_first_show_date", Long.parseLong(j12 + ""));
    }

    public void Nl() {
        SmartRefreshLayout smartRefreshLayout = this.I;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.w();
            i6.d.i("home -----finishLoadMore....");
        }
    }

    public void O5() {
        this.A0.k(false);
        this.f73647z0.setVisibility(0);
        this.B0.setVisibility(8);
    }

    public void Oe(HomePageInvestData homePageInvestData) {
        Ql(homePageInvestData);
    }

    public void Ol() {
        this.I.i(true);
        this.I.g(true);
        this.I.V(false);
        this.I.h0(new SmartRefreshFooter(getActivity()));
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(getActivity());
        this.J = smartRefreshHeader;
        this.I.j0(smartRefreshHeader);
        this.I.e0(new b());
    }

    public final void Pl(HomePageEarnData homePageEarnData) {
        this.f73627u0.f73527a.setVisibility(0);
        this.f73627u0.f73528b.setTextColor(this.O ? this.L2 : this.M2);
        this.f73627u0.f73528b.setText(homePageEarnData.title);
        this.f73627u0.f73530d.setOnClickListener(new s(this, homePageEarnData));
    }

    public void Q6() {
        ((IndexPresenter) yh()).M2();
    }

    public void Q7(int i11) {
        if (this.B1) {
            this.B1 = false;
            FeedFragment c11 = HomeHelper.c(this.f73640x1, this.f73644y1);
            if (c11 != null) {
                c11.ai(i11);
            } else {
                Nl();
            }
        }
    }

    public final void Ql(HomePageInvestData homePageInvestData) {
        String str;
        HomePageInvestData.InvestDrawerSpotAndMartingaleData investDrawerSpotAndMartingaleData;
        HomePageInvestData.InvestDrawerDualData investDrawerDualData;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("showInvestDrawer -- mInvestData:");
        if (S2 != null) {
            str = "has data && mInvestData.show" + S2.show;
        } else {
            str = "is null";
        }
        sb2.append(str);
        Log.d("IndexTAGFragment", sb2.toString());
        S2 = homePageInvestData;
        if (homePageInvestData == null || !homePageInvestData.show) {
            this.f73631v0.setVisibility(8);
            return;
        }
        this.f73631v0.setVisibility(0);
        Sl();
        Tl();
        HomePageInvestData homePageInvestData2 = S2;
        HomePageInvestData.InvestDrawerSpotAndMartingaleData investDrawerSpotAndMartingaleData2 = homePageInvestData2.spot;
        if (investDrawerSpotAndMartingaleData2 == null || (investDrawerSpotAndMartingaleData = homePageInvestData2.martingale) == null || (investDrawerDualData = homePageInvestData2.dual) == null || !investDrawerSpotAndMartingaleData2.show || !investDrawerSpotAndMartingaleData.show || !investDrawerDualData.show) {
            kk();
        } else {
            Rl();
        }
        Dl();
    }

    public void R7(boolean z11) {
        RelativeLayout relativeLayout = this.f73574e0;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z11 ? 0 : 8);
        }
    }

    public final void Rl() {
        String str;
        String str2;
        int i11;
        HomePageInvestData.InvestDrawerSpotAndMartingaleData investDrawerSpotAndMartingaleData;
        String str3;
        View view;
        this.f73631v0.findViewById(R.id.ll_normal_invest).setVisibility(0);
        int i12 = 0;
        while (true) {
            str = "#F0F1F4";
            if (i12 >= 2) {
                break;
            }
            if (i12 == 0) {
                i11 = R.id.ll_normal_invest_type_1;
                investDrawerSpotAndMartingaleData = S2.spot;
            } else {
                i11 = R.id.ll_normal_invest_type_2;
                investDrawerSpotAndMartingaleData = S2.martingale;
            }
            LinearLayout linearLayout = (LinearLayout) this.f73631v0.findViewById(i11);
            linearLayout.setOnClickListener(new s(investDrawerSpotAndMartingaleData, i12));
            TextView textView = (TextView) linearLayout.findViewById(R.id.tv_normal_invest_type_name);
            textView.setText(investDrawerSpotAndMartingaleData.showTitleText);
            if (this.O) {
                str3 = str;
            } else {
                str3 = "#000000";
            }
            textView.setTextColor(Color.parseColor(str3));
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.iv_normal_invest_user_icon);
            int i13 = this.O ? R$drawable.ic_invest_currency_default_night : R$drawable.ic_invest_currency_default_day;
            try {
                ImageLoadedrManager.getInstance().display(getContext(), investDrawerSpotAndMartingaleData.img, imageView, i13, (com.bumptech.glide.request.e) null);
            } catch (Exception unused) {
                imageView.setImageResource(i13);
            }
            TextView textView2 = (TextView) linearLayout.findViewById(R.id.tv_normal_earn_user_nick_name);
            textView2.setText(investDrawerSpotAndMartingaleData.nick);
            if (!this.O) {
                str = "#000000";
            }
            textView2.setTextColor(Color.parseColor(str));
            TextView textView3 = (TextView) linearLayout.findViewById(R.id.tv_normal_invest_total_profit_amount);
            String str4 = investDrawerSpotAndMartingaleData.totalProfitAmount;
            String substring = str4.substring(0, 1);
            String substring2 = str4.substring(1);
            textView3.setText(substring + p0.d(Double.parseDouble(substring2), 2));
            textView3.setTextColor(getResources().getColor(com.hbg.lib.core.util.w.h()));
            ((TextView) linearLayout.findViewById(R.id.tv_normal_content_text)).setText(investDrawerSpotAndMartingaleData.showContentText);
            if (i12 == 0) {
                view = this.f73631v0.findViewById(R.id.normal_invest_separate_line_1);
            } else {
                view = this.f73631v0.findViewById(R.id.normal_invest_separate_line_2);
            }
            view.setBackgroundColor(getResources().getColor(R.color.baseColorPrimarySeparator));
            ((ImageView) linearLayout.findViewById(R.id.iv_normal_invest_user_icon2)).setVisibility(8);
            i12++;
        }
        HomePageInvestData.InvestDrawerDualData investDrawerDualData = S2.dual;
        LinearLayout linearLayout2 = (LinearLayout) this.f73631v0.findViewById(R.id.ll_normal_invest_type_3);
        TextView textView4 = (TextView) linearLayout2.findViewById(R.id.tv_normal_invest_type_name);
        textView4.setText(investDrawerDualData.showTitleText);
        if (this.O) {
            str2 = str;
        } else {
            str2 = "#000000";
        }
        textView4.setTextColor(Color.parseColor(str2));
        TextView textView5 = (TextView) linearLayout2.findViewById(R.id.tv_normal_earn_user_nick_name);
        textView5.setText(investDrawerDualData.productName.toUpperCase(Locale.ROOT));
        if (!this.O) {
            str = "#000000";
        }
        textView5.setTextColor(Color.parseColor(str));
        String l11 = al.p.l(investDrawerDualData.currency);
        ImageView imageView2 = (ImageView) linearLayout2.findViewById(R.id.iv_normal_invest_user_icon);
        imageView2.setVisibility(0);
        int i14 = this.O ? R$drawable.ic_invest_currency_default_night : R$drawable.ic_invest_currency_default_day;
        try {
            ImageLoadedrManager.getInstance().display(getContext(), l11, imageView2, i14, (com.bumptech.glide.request.e) null);
        } catch (Exception unused2) {
            imageView2.setImageResource(i14);
        }
        String str5 = investDrawerDualData.productName;
        String l12 = al.p.l(str5.substring(str5.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER) + 1));
        ImageView imageView3 = (ImageView) linearLayout2.findViewById(R.id.iv_normal_invest_user_icon2);
        imageView3.setVisibility(0);
        try {
            ImageLoadedrManager.getInstance().display(getContext(), l12, imageView3, i14, (com.bumptech.glide.request.e) null);
        } catch (Exception unused3) {
            imageView3.setImageResource(i14);
        }
        TextView textView6 = (TextView) linearLayout2.findViewById(R.id.tv_normal_invest_total_profit_amount);
        textView6.setText(p0.d(Double.parseDouble(investDrawerDualData.apy) * 100.0d, 2) + "%");
        textView6.setTextColor(getResources().getColor(com.hbg.lib.core.util.w.h()));
        TextView textView7 = (TextView) linearLayout2.findViewById(R.id.tv_normal_content_text);
        textView7.setText("APY");
        textView7.setTextColor(Color.parseColor(this.O ? "#808799" : "#909090"));
        linearLayout2.setOnClickListener(new t(investDrawerDualData));
    }

    public final void Sl() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f73631v0.findViewById(R.id.rl_huo_bi_invest_title);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_huo_bi_invest_title);
        textView.setText(S2.showTitleText);
        textView.setTextColor(Color.parseColor(this.O ? "#F0F1F4" : "#000000"));
        relativeLayout.setOnClickListener(u.f73986b);
    }

    public RankList Tb() {
        return this.F1;
    }

    public final void Tj() {
        this.T0.setOnStickyChangeListener(new x(this));
        this.V0.setOnClickListener(new k0(this));
    }

    public final void Tl() {
        String str;
        String str2;
        String str3;
        String str4;
        RelativeLayout relativeLayout = (RelativeLayout) this.f73631v0.findViewById(R.id.rl_prime_invest);
        HomePageInvestData.InvestDrawerTradingToEarnData investDrawerTradingToEarnData = S2.tradingToEarn;
        if (investDrawerTradingToEarnData == null || !investDrawerTradingToEarnData.show) {
            relativeLayout.setVisibility(8);
            return;
        }
        relativeLayout.setOnClickListener(new r());
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.iv_invest_coin_image);
        String l11 = al.p.l(S2.tradingToEarn.prizeCurrency);
        int i11 = this.O ? R$drawable.ic_invest_currency_default_night : R$drawable.ic_invest_currency_default_day;
        try {
            ImageLoadedrManager.getInstance().display(getContext(), l11, imageView, i11, (com.bumptech.glide.request.e) null);
        } catch (Exception unused) {
            imageView.setImageResource(i11);
        }
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_invest_coin_name);
        HomePageInvestData.InvestDrawerTradingToEarnData investDrawerTradingToEarnData2 = S2.tradingToEarn;
        if (investDrawerTradingToEarnData2.symbol.indexOf(investDrawerTradingToEarnData2.prizeCurrency) == 0) {
            HomePageInvestData.InvestDrawerTradingToEarnData investDrawerTradingToEarnData3 = S2.tradingToEarn;
            String str5 = investDrawerTradingToEarnData3.symbol;
            String str6 = investDrawerTradingToEarnData3.prizeCurrency;
            str = str5.replace(str6, S2.tradingToEarn.prizeCurrency + "/");
        } else {
            HomePageInvestData.InvestDrawerTradingToEarnData investDrawerTradingToEarnData4 = S2.tradingToEarn;
            String str7 = investDrawerTradingToEarnData4.symbol;
            String str8 = investDrawerTradingToEarnData4.prizeCurrency;
            str = str7.replace(str8, "/" + S2.tradingToEarn.prizeCurrency);
        }
        textView.setText(str.toUpperCase(Locale.ROOT));
        textView.setTextColor(Color.parseColor(this.O ? "#F0F1F4" : "#000000"));
        ((TextView) relativeLayout.findViewById(R.id.tv_invest_apy)).setText(p0.d(Double.parseDouble(S2.tradingToEarn.apyPercent) * 100.0d, 2) + "%");
        String str9 = "#808799";
        ((TextView) relativeLayout.findViewById(R.id.tv_invest_apy_text)).setTextColor(Color.parseColor(this.O ? str9 : "#909090"));
        TextView textView2 = (TextView) this.f73631v0.findViewById(R.id.tv_invest_total_amount);
        TextView textView3 = (TextView) this.f73631v0.findViewById(R.id.tv_invest_countdown);
        int screenWidth = (ScreenUtil.getScreenWidth(getContext()) * 140) / 375;
        TextView textView4 = (TextView) relativeLayout.findViewById(R.id.tv_invest_deadline);
        TextView textView5 = (TextView) relativeLayout.findViewById(R.id.tv_invest_deadline_desc);
        textView4.setPadding(screenWidth, 0, 0, 0);
        textView5.setPadding(screenWidth, 0, 0, 0);
        TextView textView6 = (TextView) this.f73631v0.findViewById(R.id.tv_invest_total_position);
        TextView textView7 = (TextView) this.f73631v0.findViewById(R.id.tv_invest_sold_position);
        textView7.setTextColor(Color.parseColor(this.O ? "#F0F1F4" : "#000000"));
        HomePageInvestData.InvestDrawerTradingToEarnData investDrawerTradingToEarnData5 = S2.tradingToEarn;
        TextView textView8 = textView3;
        long j11 = investDrawerTradingToEarnData5.systemTime;
        long j12 = investDrawerTradingToEarnData5.startTime;
        String str10 = "#F0F1F4";
        if (j11 >= j12 || investDrawerTradingToEarnData5.activityStatus != 0) {
            TextView textView9 = textView8;
            String str11 = "#000000";
            String str12 = str9;
            long j13 = investDrawerTradingToEarnData5.endTime;
            String str13 = "#909090";
            if (j11 < j13) {
                str2 = str12;
                if (investDrawerTradingToEarnData5.activityStatus == 1) {
                    T2 = (j13 - j11) / 1000;
                    dm();
                    textView9.setVisibility(0);
                    textView4.setText(String.valueOf(S2.tradingToEarn.personNum));
                    textView4.setTextColor(Color.parseColor(this.O ? str10 : str11));
                    textView5.setText(S2.tradingToEarn.showParticipantsText);
                    textView5.setTextColor(Color.parseColor(this.O ? str2 : str13));
                    textView2.setVisibility(8);
                    double d11 = 0.0d;
                    try {
                        d11 = (Double.parseDouble(S2.tradingToEarn.allocatedScore.replace(Constants.ACCEPT_TIME_SEPARATOR_SP, "")) * 100.0d) / Double.parseDouble(S2.tradingToEarn.prizeAmount.replace(Constants.ACCEPT_TIME_SEPARATOR_SP, ""));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    ProgressBar progressBar = (ProgressBar) this.f73631v0.findViewById(R.id.pb_invest_progress_bar);
                    progressBar.setVisibility(0);
                    progressBar.setProgress((int) d11);
                    textView6.setText("/" + S2.tradingToEarn.prizeAmount);
                    textView7.setText(S2.tradingToEarn.allocatedScore);
                    return;
                }
            } else {
                str2 = str12;
            }
            im();
            textView9.setVisibility(8);
            textView4.setText(String.valueOf(S2.tradingToEarn.personNum));
            textView4.setTextColor(Color.parseColor(this.O ? str10 : str11));
            textView5.setText(S2.tradingToEarn.showParticipantsText);
            textView5.setTextColor(Color.parseColor(this.O ? str2 : str13));
            long parseInt = (long) Integer.parseInt(S2.tradingToEarn.prizeAmount.replace(Constants.ACCEPT_TIME_SEPARATOR_SP, ""));
            ProgressBar progressBar2 = (ProgressBar) this.f73631v0.findViewById(R.id.pb_invest_progress_bar);
            progressBar2.setVisibility(0);
            progressBar2.setProgress((int) ((((long) Integer.parseInt(S2.tradingToEarn.allocatedScore.replace(Constants.ACCEPT_TIME_SEPARATOR_SP, ""))) * 100) / parseInt));
            textView2.setVisibility(8);
            textView6.setText("/" + S2.tradingToEarn.prizeAmount);
            textView7.setText(S2.tradingToEarn.allocatedScore);
            return;
        }
        T2 = (j12 - j11) / 1000;
        dm();
        TextView textView10 = textView8;
        textView10.setVisibility(0);
        textView10.setPadding(PixelUtils.a(4.0f), 0, PixelUtils.a(4.0f), 0);
        textView4.setText(S2.tradingToEarn.durationOfActivity);
        if (this.O) {
            str3 = str10;
        } else {
            str3 = "#000000";
        }
        textView4.setTextColor(Color.parseColor(str3));
        textView5.setText(S2.tradingToEarn.showActivityTimeText);
        if (!this.O) {
            str9 = "#909090";
        }
        textView5.setTextColor(Color.parseColor(str9));
        ((ProgressBar) this.f73631v0.findViewById(R.id.pb_invest_progress_bar)).setVisibility(8);
        textView2.setVisibility(0);
        textView2.setText(S2.tradingToEarn.prizeAmount);
        if (this.O) {
            str4 = str10;
        } else {
            str4 = "#000000";
        }
        textView2.setTextColor(Color.parseColor(str4));
        textView6.setText(S2.tradingToEarn.showBonusText);
        textView7.setVisibility(8);
    }

    public void U9() {
        this.A0.k(true);
        this.f73647z0.setVisibility(8);
        this.B0.setVisibility(8);
    }

    public final void Uj() {
        View view = null;
        try {
            view = LayoutInflater.from(getActivity()).inflate(R.layout.part_home_index_new_user_gift_bag, (ViewGroup) null, false);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (view != null) {
            view.setLayoutParams(this.f73574e0.getLayoutParams());
            this.f73574e0.addView(view);
        }
    }

    public final void Ul(int i11) {
        RelativeLayout relativeLayout;
        boolean z11;
        int i12 = i11;
        if (this.f73589j0 != null && (relativeLayout = this.f73574e0) != null && this.f73577f0 != null) {
            relativeLayout.setVisibility(0);
            int taskProgress = this.f73589j0.getTaskProgress();
            int registryStatus = this.f73589j0.getRegistryStatus();
            int transferTakeStatus = this.f73589j0.getTransferTakeStatus();
            int tradeTakeStatus = this.f73589j0.getTradeTakeStatus();
            this.f73577f0.setOnClickListener(new g(this, taskProgress));
            int e11 = SP.e("sp_key_index_new_user_gift_bag_task_progress", 0);
            Log.d("IndexTAGFragment", "localTaskProgress:" + e11 + " taskProgress:" + taskProgress + " fromSourceType:" + i12);
            if (e11 == taskProgress || i12 != 3) {
                z11 = false;
            } else {
                SP.q("sp_key_index_new_user_gift_bag_task_progress", taskProgress);
                z11 = true;
            }
            this.f73604n0.setOnClickListener(new p0(this, taskProgress));
            this.f73591j2.setOnClickListener(new o0(this, taskProgress));
            if (taskProgress == 0) {
                this.f73602m2.setBackgroundColor(getResources().getColor(R.color.home_new_user_gift_bag_progress_bar_default_color));
                this.f73609o2.setBackgroundColor(getResources().getColor(R.color.home_new_user_gift_bag_progress_bar_default_color));
                this.f73615q2.setBackgroundResource(R.drawable.index_new_gift_card_progress_right_round_unchecked_corner_bg);
                this.F2.setText(R.string.n_home_register);
                this.A2.setBackgroundResource(R.drawable.home_new_user_gift_bag_bottom_layout_register_bg);
                if (i12 == 3) {
                    this.f73598l2.setProgress(0.0f);
                    this.f73606n2.setProgress(0.0f);
                    this.f73612p2.setProgress(0.0f);
                }
            } else if (taskProgress == 1) {
                this.f73602m2.setBackgroundColor(getResources().getColor(R.color.home_new_user_gift_bag_progress_bar_color));
                this.f73609o2.setBackgroundColor(getResources().getColor(R.color.home_new_user_gift_bag_progress_bar_default_color));
                this.f73615q2.setBackgroundResource(R.drawable.index_new_gift_card_progress_right_round_unchecked_corner_bg);
                if (i12 == 3) {
                    if (z11) {
                        ql(this.f73598l2);
                    } else {
                        this.f73598l2.setProgress(1.0f);
                    }
                    this.f73606n2.setProgress(0.0f);
                    this.f73612p2.setProgress(0.0f);
                }
                this.F2.setText(R.string.n_index_amount_immediately);
                this.A2.setBackgroundResource(R.drawable.home_new_user_gift_bag_bottom_layout_amount_bg);
            } else if (taskProgress == 2) {
                this.f73602m2.setBackgroundColor(getResources().getColor(R.color.home_new_user_gift_bag_progress_bar_color));
                this.f73609o2.setBackgroundColor(getResources().getColor(R.color.home_new_user_gift_bag_progress_bar_color));
                this.f73615q2.setBackgroundResource(R.drawable.index_new_gift_card_progress_right_round_unchecked_corner_bg);
                if (i12 == 3) {
                    this.f73598l2.setProgress(1.0f);
                    if (z11) {
                        ql(this.f73606n2);
                    } else {
                        this.f73606n2.setProgress(1.0f);
                    }
                    this.f73612p2.setProgress(0.0f);
                }
                this.F2.setText(R.string.n_index_immediate_transaction);
                this.A2.setBackgroundResource(R.drawable.home_new_user_gift_bag_bottom_layout_deal_bg);
            } else if (taskProgress == 3) {
                this.f73602m2.setBackgroundColor(getResources().getColor(R.color.home_new_user_gift_bag_progress_bar_color));
                this.f73609o2.setBackgroundColor(getResources().getColor(R.color.home_new_user_gift_bag_progress_bar_color));
                this.f73615q2.setBackgroundResource(R.drawable.index_new_gift_card_progress_right_round_unchecked_corner_bg);
                if (i12 == 3) {
                    this.f73598l2.setProgress(1.0f);
                    this.f73606n2.setProgress(1.0f);
                    if (z11) {
                        ql(this.f73612p2);
                    } else {
                        this.f73612p2.setProgress(1.0f);
                    }
                }
                if (tradeTakeStatus == 3) {
                    this.f73615q2.setBackgroundResource(R.drawable.index_new_gift_card_progress_right_round_corner_bg);
                }
                this.F2.setText(R.string.n_otc_know_more);
                this.A2.setBackgroundResource(R.drawable.home_new_user_gift_bag_bottom_layout_deal_bg);
            }
            this.F2.setOnClickListener(new h(this, taskProgress));
            this.G2.playAnimation();
            if (registryStatus == 0 || registryStatus == 1) {
                this.f73621s2.setText(R.string.login_sign_up);
                this.f73621s2.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
                this.f73625t2.setVisibility(0);
            } else if (registryStatus == 2) {
                this.f73621s2.setText(R.string.n_index_receive_rewards);
                this.f73621s2.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
                this.f73625t2.setVisibility(0);
            } else if (registryStatus == 3) {
                this.f73621s2.setText(R.string.n_index_view_rewards);
                this.f73621s2.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
                this.f73625t2.setVisibility(0);
            }
            this.f73598l2.setOnClickListener(new m(this, registryStatus, taskProgress));
            this.f73618r2.setOnClickListener(new j(this, registryStatus, taskProgress));
            if (transferTakeStatus == 0) {
                this.f73633v2.setText(R.string.n_home_golden);
                this.f73633v2.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
                this.f73637w2.setVisibility(4);
            } else if (transferTakeStatus == 1) {
                this.f73633v2.setText(R.string.n_home_golden);
                this.f73633v2.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
                this.f73637w2.setVisibility(0);
            } else if (transferTakeStatus == 2) {
                this.f73633v2.setText(R.string.n_index_receive_rewards);
                this.f73633v2.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
                this.f73637w2.setVisibility(0);
            } else if (transferTakeStatus == 3) {
                this.f73633v2.setText(R.string.n_index_view_rewards);
                this.f73633v2.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
                this.f73637w2.setVisibility(0);
            }
            this.f73606n2.setOnClickListener(new n(this, transferTakeStatus, taskProgress));
            this.f73629u2.setOnClickListener(new o(this, transferTakeStatus, taskProgress));
            if (tradeTakeStatus == 0) {
                this.f73645y2.setText(R.string.n_otc_card_trade);
                this.f73645y2.setTextColor(getResources().getColor(R.color.baseColorPrimaryText));
                this.f73649z2.setVisibility(4);
            } else if (tradeTakeStatus == 1) {
                this.f73645y2.setText(R.string.n_otc_card_trade);
                this.f73645y2.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
                this.f73649z2.setVisibility(0);
            } else if (tradeTakeStatus == 2) {
                this.f73645y2.setText(R.string.n_index_receive_rewards);
                this.f73645y2.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
                this.f73649z2.setVisibility(0);
            } else if (tradeTakeStatus == 3) {
                this.f73645y2.setText(R.string.n_index_view_rewards);
                this.f73645y2.setTextColor(getResources().getColor(R.color.baseColorMajorTheme100));
                this.f73649z2.setVisibility(0);
            }
            this.f73612p2.setOnClickListener(new l(this, tradeTakeStatus, taskProgress));
            this.f73641x2.setOnClickListener(new k(this, tradeTakeStatus, taskProgress));
            String str = "";
            if (getContext() == null || TextUtils.isEmpty(this.f73589j0.getTitle()) || !this.f73589j0.getTitle().contains("{") || !this.f73589j0.getTitle().contains("}")) {
                this.B2.setText(TextUtils.isEmpty(this.f73589j0.getTitle()) ? str : this.f73589j0.getTitle());
            } else {
                this.B2.setText(yl.o.a(getContext(), this.f73589j0.getTitle(), R.color.home_new_user_gift_bag_bottom_layout_title_color, R.color.color_FE8731, false));
            }
            TextView textView = this.C2;
            if (!TextUtils.isEmpty(this.f73589j0.getSubTitle())) {
                str = this.f73589j0.getSubTitle();
            }
            textView.setText(str);
            if (getContext() == null || TextUtils.isEmpty(this.f73589j0.getTotalAward()) || !this.f73589j0.getTotalAward().contains("{") || !this.f73589j0.getTotalAward().contains("}")) {
                this.D2.setText(this.f73589j0.getTotalAward());
                this.E2.setText(this.f73589j0.getTotalAward());
            } else {
                this.D2.setText(yl.o.a(getContext(), this.f73589j0.getTotalAward(), R.color.color_F0F1F4, R.color.color_F0F1F4, true));
                this.E2.setText(yl.o.a(getContext(), this.f73589j0.getTotalAward(), R.color.color_FE8731, R.color.color_FE8731, true));
            }
            this.H2.setOnClickListener(new i(this, taskProgress));
            yl.o.u("home_newMan", taskProgress);
        }
    }

    public final void Vj(int i11, int i12, View view) {
        if (i11 == 1) {
            if (getActivity() != null) {
                jp.k0.k(getActivity());
            }
        } else if (i11 == 2) {
            HBBaseWebActivity.showWebView(view.getContext(), this.f73589j0.getTakeAwardUrl(), "", "", false);
        } else if (i11 == 3) {
            HBBaseWebActivity.showWebView(view.getContext(), this.f73589j0.getMyPackageUrl(), "", "", false);
        }
        if (i11 != 0) {
            yl.o.t("home_newMan", i12, "3", i11 + "");
        }
    }

    public final void Vl(HomePageEarnData homePageEarnData) {
        List<HomePageEarnData.IndexAreaContentItemVo> fk2 = fk(homePageEarnData);
        if (fk2 != null) {
            ArrayList arrayList = new ArrayList(3);
            HuoBiEarnContainer.NormalEarnContainer normalEarnContainer = this.f73627u0.f73532f;
            HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem normalEarnItem = normalEarnContainer.f73533a;
            HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem normalEarnItem2 = normalEarnContainer.f73534b;
            HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem normalEarnItem3 = normalEarnContainer.f73535c;
            arrayList.add(normalEarnItem);
            arrayList.add(normalEarnItem2);
            arrayList.add(normalEarnItem3);
            for (int i11 = 0; i11 < fk2.size(); i11++) {
                HomePageEarnData.IndexAreaContentItemVo indexAreaContentItemVo = fk2.get(i11);
                HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem normalEarnItem4 = (HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem) arrayList.get(i11);
                normalEarnItem4.f73536a.setOnClickListener(new p(this, indexAreaContentItemVo, i11));
                normalEarnItem4.f73540e.setText(indexAreaContentItemVo.projectName);
                normalEarnItem4.f73540e.setTextColor(this.O ? this.L2 : this.M2);
                if (TextUtils.isEmpty(indexAreaContentItemVo.iconUrl) || indexAreaContentItemVo.iconUrl.equals(OptionsBridge.NULL_VALUE)) {
                    normalEarnItem4.f73541f.setImageResource(this.O ? 2131231168 : 2131231167);
                } else {
                    f6.c.a().e(normalEarnItem4.f73541f, indexAreaContentItemVo.iconUrl);
                }
                normalEarnItem4.f73541f.setVisibility(0);
                normalEarnItem4.f73542g.setText(indexAreaContentItemVo.currency);
                normalEarnItem4.f73542g.setTextColor(this.O ? this.L2 : this.M2);
                if (indexAreaContentItemVo.shelfType != 4) {
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    normalEarnItem4.f73543h.setText(decimalFormat.format(indexAreaContentItemVo.rate * 100.0d) + "%");
                    if (indexAreaContentItemVo.coupon != null) {
                        DecimalFormat decimalFormat2 = new DecimalFormat("0.00");
                        normalEarnItem4.f73544i.setText(Cl("+" + decimalFormat2.format(indexAreaContentItemVo.coupon.addRate * 100.0d)) + "%");
                        normalEarnItem4.f73539d.setVisibility(0);
                    } else {
                        normalEarnItem4.f73539d.setVisibility(8);
                    }
                    normalEarnItem4.f73545j.setText("APY");
                    normalEarnItem4.f73546k.setVisibility(8);
                } else {
                    normalEarnItem4.f73543h.setVisibility(8);
                    normalEarnItem4.f73539d.setVisibility(8);
                    normalEarnItem4.f73546k.setVisibility(0);
                    normalEarnItem4.f73546k.setText(indexAreaContentItemVo.projectDesc);
                    normalEarnItem4.f73538c.setVisibility(8);
                    normalEarnItem4.f73545j.setVisibility(8);
                }
                if (i11 < fk2.size() - 1) {
                    normalEarnItem4.f73537b.setBackgroundColor(getResources().getColor(R.color.baseColorPrimarySeparator));
                }
            }
        }
    }

    public final boolean Wj() {
        EasyRecyclerView<s9.a> easyRecyclerView = this.O0;
        if (easyRecyclerView == null) {
            return true;
        }
        int min = Math.min(easyRecyclerView.getAdapter().c().size(), this.N2.length);
        for (int i11 = 0; i11 < min; i11++) {
            if (!this.N2[i11]) {
                return false;
            }
        }
        return true;
    }

    public void Wl() {
        List<Fragment> list;
        if (this.f73636w1 != null && this.f73640x1 != null && (list = this.f73644y1) != null && list.size() > 0) {
            int i11 = 0;
            boolean z11 = false;
            for (int i12 = 0; i12 < this.f73644y1.size(); i12++) {
                if (this.f73644y1.get(i12) instanceof FeedFragment ? HomeHelper.i(((FeedFragment) this.f73644y1.get(i12)).Ph()) : true) {
                    z11 = true;
                }
            }
            this.f73636w1.setVisibility(z11 ? 0 : 8);
            ConsecutiveViewPager consecutiveViewPager = this.f73640x1;
            if (!z11) {
                i11 = 8;
            }
            consecutiveViewPager.setVisibility(i11);
        }
    }

    public void Xb() {
        int size = this.W.size();
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(size));
        hashMap.put("testKey", "A");
        gs.g.i("homepage_view", hashMap);
    }

    public final boolean Xj(Uri uri) {
        String queryParameter = uri.getQueryParameter(AuthHandler.EXTRA_TOKEN_SECRET);
        String queryParameter2 = uri.getQueryParameter("sign");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(queryParameter);
        sb2.append(ServiceStat.VERIFY_EVENT_ID);
        return queryParameter2 != null && queryParameter2.equalsIgnoreCase(MD5Utils.b(sb2.toString().getBytes()));
    }

    public final void Xl(HomePageEarnData homePageEarnData) {
        HomePageEarnData homePageEarnData2 = homePageEarnData;
        HomePageEarnData.IndexAreaContentItemVo indexAreaContentItemVo = null;
        for (int i11 = 0; i11 < homePageEarnData2.contents.size(); i11++) {
            indexAreaContentItemVo = homePageEarnData2.contents.get(i11);
            if (indexAreaContentItemVo.shelfType == 1) {
                break;
            }
        }
        if (indexAreaContentItemVo != null) {
            if (indexAreaContentItemVo.isShow == 0) {
                this.f73627u0.f73531e.f73547a.setVisibility(8);
                return;
            }
            HuoBiEarnContainer.PrimeEarnContainer primeEarnContainer = this.f73627u0.f73531e;
            primeEarnContainer.f73547a.setOnClickListener(new r(this, indexAreaContentItemVo.url, indexAreaContentItemVo));
            primeEarnContainer.f73550d.setText(indexAreaContentItemVo.currency);
            primeEarnContainer.f73550d.setTextColor(this.O ? this.L2 : this.M2);
            if (TextUtils.isEmpty(indexAreaContentItemVo.iconUrl) || indexAreaContentItemVo.iconUrl.equals(OptionsBridge.NULL_VALUE)) {
                primeEarnContainer.f73549c.setImageResource(this.O ? 2131231168 : 2131231167);
            } else {
                FragmentActivity activity = getActivity();
                if (activity != null && !activity.isFinishing()) {
                    f6.c.a().e(primeEarnContainer.f73549c, indexAreaContentItemVo.iconUrl);
                }
            }
            primeEarnContainer.f73561o.setTextColor(this.O ? this.L2 : this.M2);
            TextView textView = (TextView) this.f67460i.b(R.id.tv_earn_total_amount);
            long j11 = indexAreaContentItemVo.currentTime;
            long j12 = indexAreaContentItemVo.startTime;
            if (j11 >= j12 || indexAreaContentItemVo.projectStatus != 0) {
                long j13 = 0;
                if (j11 >= indexAreaContentItemVo.endTime || indexAreaContentItemVo.projectStatus != 1) {
                    hm();
                    textView.setVisibility(8);
                    primeEarnContainer.f73551e.setVisibility(8);
                    if (!TextUtils.isEmpty(indexAreaContentItemVo.totalAmount) && Long.parseLong(indexAreaContentItemVo.totalAmount) != 0) {
                        j13 = (Long.parseLong(indexAreaContentItemVo.finishAmount) * 100) / Long.parseLong(indexAreaContentItemVo.totalAmount);
                    }
                    primeEarnContainer.f73559m.setProgress((int) j13);
                    primeEarnContainer.f73558l.setVisibility(0);
                    BigDecimal bigDecimal = new BigDecimal(Long.parseLong(indexAreaContentItemVo.finishAmount));
                    DecimalFormat decimalFormat = new DecimalFormat(",###,##0");
                    String format = decimalFormat.format(bigDecimal);
                    String format2 = decimalFormat.format(new BigDecimal(indexAreaContentItemVo.totalAmount));
                    primeEarnContainer.f73561o.setText(format);
                    primeEarnContainer.f73560n.setText("/" + format2);
                } else {
                    textView.setVisibility(8);
                    TextView textView2 = textView;
                    R2 = (indexAreaContentItemVo.endTime - indexAreaContentItemVo.currentTime) / 1000;
                    this.K2 = 1;
                    cm();
                    if (R2 == -1) {
                        primeEarnContainer.f73551e.setVisibility(8);
                    } else {
                        primeEarnContainer.f73551e.setVisibility(0);
                    }
                    primeEarnContainer.f73551e.setPadding(PixelUtils.a(4.0f), 0, PixelUtils.a(4.0f), 0);
                    if (!TextUtils.isEmpty(indexAreaContentItemVo.finishAmount) && indexAreaContentItemVo.finishAmount.contains(InstructionFileId.DOT)) {
                        String str = indexAreaContentItemVo.finishAmount;
                        indexAreaContentItemVo.finishAmount = str.substring(0, str.indexOf(InstructionFileId.DOT));
                    }
                    if (!TextUtils.isEmpty(indexAreaContentItemVo.totalAmount) && indexAreaContentItemVo.totalAmount.contains(InstructionFileId.DOT)) {
                        String str2 = indexAreaContentItemVo.totalAmount;
                        indexAreaContentItemVo.totalAmount = str2.substring(0, str2.indexOf(InstructionFileId.DOT));
                    }
                    BigDecimal bigDecimal2 = new BigDecimal(Long.parseLong(indexAreaContentItemVo.finishAmount));
                    DecimalFormat decimalFormat2 = new DecimalFormat(",###,##0");
                    String format3 = decimalFormat2.format(bigDecimal2);
                    String format4 = decimalFormat2.format(new BigDecimal(indexAreaContentItemVo.totalAmount));
                    primeEarnContainer.f73561o.setText(format3);
                    primeEarnContainer.f73560n.setText("/" + format4);
                    if (!TextUtils.isEmpty(indexAreaContentItemVo.totalAmount) && Long.parseLong(indexAreaContentItemVo.totalAmount) != 0) {
                        j13 = (Long.parseLong(indexAreaContentItemVo.finishAmount) * 100) / Long.parseLong(indexAreaContentItemVo.totalAmount);
                    }
                    primeEarnContainer.f73559m.setProgress((int) j13);
                    textView2.setVisibility(8);
                    primeEarnContainer.f73558l.setVisibility(0);
                    primeEarnContainer.f73559m.setVisibility(0);
                }
            } else {
                R2 = (j12 - j11) / 1000;
                this.K2 = 0;
                cm();
                String format5 = new DecimalFormat(",###,##0").format(new BigDecimal(indexAreaContentItemVo.totalAmount));
                textView.setVisibility(0);
                textView.setText(format5);
                textView.setTextColor(Color.parseColor(this.O ? "#F0F1F4" : "#000000"));
                primeEarnContainer.f73561o.setVisibility(8);
                primeEarnContainer.f73560n.setText(R.string.n_home_index_earn_total_position);
                primeEarnContainer.f73560n.setVisibility(0);
                if (R2 == -1) {
                    primeEarnContainer.f73551e.setVisibility(8);
                } else {
                    primeEarnContainer.f73551e.setVisibility(0);
                }
                primeEarnContainer.f73551e.setPadding(PixelUtils.a(4.0f), 0, PixelUtils.a(4.0f), 0);
                primeEarnContainer.f73558l.setVisibility(8);
            }
            primeEarnContainer.f73548b.setBackgroundColor(getResources().getColor(R.color.baseColorPrimarySeparator));
            DecimalFormat decimalFormat3 = new DecimalFormat("0.00");
            primeEarnContainer.f73552f.setText(decimalFormat3.format(indexAreaContentItemVo.rate * 100.0d) + "%");
            primeEarnContainer.f73555i.setText("APY");
            if (indexAreaContentItemVo.coupon != null) {
                DecimalFormat decimalFormat4 = new DecimalFormat("0.00");
                primeEarnContainer.f73554h.setText(Cl("+" + decimalFormat4.format(indexAreaContentItemVo.coupon.addRate * 100.0d)) + "%");
                primeEarnContainer.f73553g.setVisibility(0);
            } else {
                primeEarnContainer.f73553g.setVisibility(8);
            }
            if (indexAreaContentItemVo.term > 0) {
                primeEarnContainer.f73556j.setText(indexAreaContentItemVo.term + getString(R.string.n_day));
                primeEarnContainer.f73556j.setTextColor(this.O ? this.L2 : this.M2);
                primeEarnContainer.f73557k.setText(R.string.n_home_index_earn_time_limit);
                int screenWidth = (ScreenUtil.getScreenWidth(getContext()) * 140) / 375;
                primeEarnContainer.f73556j.setPadding(screenWidth, 0, 0, 0);
                primeEarnContainer.f73557k.setPadding(screenWidth, 0, 0, 0);
            }
        }
    }

    public final void Yj() {
        int i11 = 0;
        while (true) {
            boolean[] zArr = this.N2;
            if (i11 < zArr.length) {
                zArr[i11] = false;
                i11++;
            } else {
                return;
            }
        }
    }

    public void Yl() {
        if (getActivity() != null && getActivity().getSupportFragmentManager() != null) {
            is.a.r("", "1000046", (String) null, (Map<String, Object>) null);
            PromoteFeatureDialog.wh(PromoteFeatureDialog.uh()).show(getActivity().getSupportFragmentManager(), PromoteFeatureDialog.class.getName());
            String n11 = DateTimeUtils.n(System.currentTimeMillis());
            ConfigPreferences.n("user_config", "promote_feature" + n11, true);
        }
    }

    public final Subscriber<Long> Zj() {
        return new u();
    }

    public final void Zl() {
        this.X.setupWithViewPager(this.U);
    }

    public RollPagerView a2() {
        return this.f73599m;
    }

    public void af(boolean z11) {
        View view = this.f73638x;
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public final Subscriber<Long> ak() {
        return new w();
    }

    public final void am() {
        f6().g();
        this.A0.d();
    }

    public final EasyRecyclerView<wl.c> bk() {
        Context context = getContext();
        if (context == null) {
            context = this.f73562a0;
        }
        EasyRecyclerView<wl.c> easyRecyclerView = new EasyRecyclerView<>(context);
        easyRecyclerView.setNestedScrollingEnabled(false);
        easyRecyclerView.setLayoutManager(new WrapContentGridLayoutManager(context, 3));
        easyRecyclerView.addItemDecoration(new h0());
        easyRecyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        return easyRecyclerView;
    }

    public final void bm(boolean z11) {
        TranslateAnimation translateAnimation;
        AlphaAnimation alphaAnimation;
        this.V0.clearAnimation();
        ViewUtil.m(this.V0, !z11);
        AnimationSet animationSet = new AnimationSet(true);
        if (z11) {
            translateAnimation = new TranslateAnimation(0.0f, 0.0f, PixelUtils.b(36.0f), 0.0f);
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        } else {
            translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, PixelUtils.b(36.0f));
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        }
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(200);
        animationSet.setAnimationListener(new a(z11));
        animationSet.setInterpolator(new LinearOutSlowInInterpolator());
        this.V0.startAnimation(animationSet);
    }

    public void c7(UserRegistryTransferGuide userRegistryTransferGuide, int i11) {
        int i12 = R.drawable.closepath_function_special;
        if (userRegistryTransferGuide == null || !(i11 == 0 || i11 == 1)) {
            this.f73593k1.setVisibility(8);
            this.L.setVisibility(0);
            this.f73584h1.setBackgroundResource(R.drawable.closepath_function_special);
            ViewUtil.m(this.E1, true);
            this.f73570c2.setVisibility(0);
            this.U.setVisibility(0);
        } else {
            this.f73593k1.setData(userRegistryTransferGuide);
            this.f73593k1.setVisibility(0);
            this.L.setVisibility(8);
            ImageView imageView = this.f73584h1;
            if (!this.O) {
                i12 = R.drawable.closepath_function_special_black;
            }
            imageView.setBackgroundResource(i12);
            this.f73638x.setVisibility(8);
            ViewUtil.m(this.E1, false);
            this.f73570c2.setVisibility(0);
            this.U.setVisibility(0);
        }
        this.f73574e0.setVisibility(8);
    }

    /* renamed from: ck */
    public IndexPresenter xh() {
        return new IndexPresenter();
    }

    public void cm() {
        if (this.I2 == null) {
            this.I2 = Zj();
            Observable.interval(0, 1000, TimeUnit.MILLISECONDS).subscribe(this.I2);
        }
    }

    public void d5(boolean z11, List<IndexBizData> list) {
        i6.d.j("IndexTAGFragment", "showHomePageBiz:" + z11);
        ViewUtil.m(this.f73565b0, z11);
        if (z11) {
            this.f73568c0.setData(list);
        }
        if (Q2 && z11 && list.size() > 0) {
            int size = list.size();
            String str = "";
            String str2 = str;
            String str3 = str2;
            String str4 = str3;
            for (int i11 = 0; i11 < size; i11++) {
                str = str + list.get(i11).getData().getName();
                str2 = str2 + list.get(i11).getData().getMaterialId();
                str3 = str3 + list.get(i11).getData().getExtension();
                str4 = str4 + list.get(i11).getData().getExtensionText();
                if (i11 != size - 1) {
                    str2 = str2 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                    str3 = str3 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                    str4 = str4 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                    str = str + Constants.ACCEPT_TIME_SEPARATOR_SP;
                }
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("type_list", str);
                hashMap.put("material_list", str2);
                hashMap.put("reserve_byte1", str3);
                hashMap.put("reserve_byte2", str4);
                hashMap.put("testKey", "A");
                gs.g.i("tofu_show", hashMap);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void dismissProgressDialog() {
        i6.i.b().d(new e0(this));
    }

    public final EasyRecyclerView<IndexFeatureItem> dk(int i11) {
        GridLayoutManager gridLayoutManager;
        Context context = getContext();
        if (context == null) {
            context = this.f73562a0;
        }
        EasyRecyclerView<IndexFeatureItem> easyRecyclerView = new EasyRecyclerView<>(context);
        easyRecyclerView.setNestedScrollingEnabled(false);
        int i12 = 5;
        if (yl.o.B()) {
            Context context2 = getContext();
            if (i11 != 5) {
                i12 = 4;
            }
            gridLayoutManager = new GridLayoutManager(context2, i12);
        } else {
            gridLayoutManager = new GridLayoutManager(getContext(), 5);
        }
        easyRecyclerView.setLayoutManager(gridLayoutManager);
        return easyRecyclerView;
    }

    public void dm() {
        if (this.J2 == null) {
            this.J2 = ak();
            Observable.interval(0, 1000, TimeUnit.MILLISECONDS).subscribe(this.J2);
        }
    }

    public void e4(UnreadCountData unreadCountData) {
        if (!tg.r.x().F0() || unreadCountData == null) {
            this.f73566b1.setVisibility(8);
            this.f73572d1.setVisibility(8);
            return;
        }
        this.f73566b1.setTag(Integer.valueOf(unreadCountData.getActivityCount()));
        if (unreadCountData.getActivityCount() > 99) {
            this.f73566b1.setVisibility(0);
            this.f73566b1.setText("99+");
            this.f73572d1.setVisibility(8);
        } else if (unreadCountData.getActivityCount() > 0) {
            this.f73566b1.setVisibility(0);
            this.f73566b1.setText(String.valueOf(unreadCountData.getActivityCount()));
            this.f73572d1.setVisibility(8);
        } else if (unreadCountData.getSystemCount() > 0) {
            this.f73566b1.setVisibility(8);
            this.f73572d1.setVisibility(0);
        } else {
            this.f73566b1.setVisibility(8);
            this.f73572d1.setVisibility(8);
        }
        this.f73572d1.setVisibility(8);
        this.f73566b1.setVisibility(8);
    }

    public void e5(boolean z11, List<s9.a> list) {
        this.R0.setVisibility(z11 ? 0 : 8);
        this.O0.setData(list);
        int size = list.size();
        if (size == 1) {
            this.S0 = new WrapContentGridLayoutManager(getContext(), 1);
        } else if (size == 2) {
            this.S0 = new WrapContentGridLayoutManager(getContext(), 2);
            if (this.O0.getItemDecorationCount() == 0) {
                this.O0.addItemDecoration(new am.b(PixelUtils.a(9.0f), 2));
            }
        } else {
            if (this.O0.getItemDecorationCount() == 0) {
                this.O0.addItemDecoration(new am.b(PixelUtils.a(9.0f), 3));
            }
            this.S0.t(new x());
        }
        this.O0.setLayoutManager(this.S0);
        this.O0.addOnScrollListener(new y());
    }

    public final void ek(int i11, int i12, View view) {
        if (i11 == 1) {
            sn.f.C(view.getContext(), "btcusdt", false, TradeType.PRO);
        } else if (i11 == 2) {
            HBBaseWebActivity.showWebView(view.getContext(), this.f73589j0.getTakeAwardUrl(), "", "", false);
        } else if (i11 == 3) {
            HBBaseWebActivity.showWebView(view.getContext(), this.f73589j0.getMyPackageUrl(), "", "", false);
        }
        if (i11 != 0) {
            yl.o.t("home_newMan", i12, "4", i11 + "");
        }
    }

    public final void em() {
        int[] iArr = {0, 0, 0, 0};
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f73622t = ofFloat;
        ofFloat.addUpdateListener(new a0(iArr));
        this.f73622t.setDuration(860);
        this.f73622t.setInterpolator(new LinearInterpolator());
        this.f73622t.setStartDelay(360);
        this.f73622t.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f73626u = ofFloat2;
        ofFloat2.addUpdateListener(new b0(iArr));
        this.f73626u.setDuration(510);
        this.f73626u.setInterpolator(new LinearInterpolator());
        this.f73626u.setStartDelay(1270);
        this.f73626u.start();
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f73630v = ofFloat3;
        ofFloat3.addUpdateListener(new c0(iArr));
        this.f73630v.setDuration(200);
        this.f73630v.setInterpolator(new LinearInterpolator());
        this.f73630v.setStartDelay(1780);
        this.f73630v.start();
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f73634w = ofFloat4;
        ofFloat4.addUpdateListener(new d0(iArr));
        this.f73634w.setDuration(200);
        this.f73634w.setInterpolator(new LinearInterpolator());
        this.f73634w.setStartDelay(1980);
        this.f73634w.addListener(new e0(iArr));
        this.f73634w.start();
    }

    public LoadingLayout f6() {
        return this.f73607o;
    }

    public final List<HomePageEarnData.IndexAreaContentItemVo> fk(HomePageEarnData homePageEarnData) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < homePageEarnData.contents.size(); i11++) {
            HomePageEarnData.IndexAreaContentItemVo indexAreaContentItemVo = homePageEarnData.contents.get(i11);
            if (indexAreaContentItemVo.shelfType != 1) {
                arrayList.add(indexAreaContentItemVo);
            }
        }
        if (arrayList.size() != 3) {
            return null;
        }
        return arrayList;
    }

    @AfterPermissionGranted(123)
    public void fm() {
        String[] strArr;
        i6.d.i("startQrScan");
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.READ_MEDIA_IMAGES};
        } else {
            strArr = new String[]{"android.permission.CAMERA", PermissionConfig.WRITE_EXTERNAL_STORAGE};
        }
        PermissionUtils.g(getActivity(), new n(strArr));
    }

    public void g7(boolean z11, List<IndexFeatureItem> list) {
        int i11;
        int i12;
        if (list == null || list.isEmpty()) {
            this.f73570c2.setVisibility(8);
            this.U.setVisibility(8);
            return;
        }
        if (z11) {
            this.f73570c2.setVisibility(0);
        } else {
            this.f73570c2.setVisibility(8);
        }
        ul();
        ArrayList<EasyRecyclerView> arrayList = new ArrayList<>();
        int size = list.size();
        if (size <= 10) {
            i11 = 1;
        } else {
            i11 = size % 10 == 0 ? size / 10 : (size / 10) + 1;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>(i11);
        this.W1 = hashMap;
        if (i11 == 1) {
            hashMap.put(0, Integer.valueOf(size));
            this.f73570c2.post(new d(size));
        } else {
            int i13 = 0;
            while (i13 < i11) {
                this.W1.put(Integer.valueOf(i13), Integer.valueOf(i13 == i11 + -1 ? size - (i13 * 10) : 10));
                i13++;
            }
            this.Z1 = PixelUtils.a(168.0f);
            this.X.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.f73570c2.getLayoutParams();
            layoutParams.height = this.Z1;
            this.f73570c2.setLayoutParams(layoutParams);
        }
        for (int i14 = 0; i14 < i11; i14++) {
            arrayList.add(dk(size));
        }
        if (!z11) {
            for (EasyRecyclerView visibility : arrayList) {
                visibility.setVisibility(8);
            }
            this.U.setVisibility(8);
            return;
        }
        for (EasyRecyclerView visibility2 : arrayList) {
            visibility2.setVisibility(0);
        }
        this.U.setVisibility(0);
        this.X1 = "";
        this.Y1 = "";
        int i15 = 0;
        while (i15 < i11) {
            ArrayList arrayList2 = new ArrayList();
            EasyRecyclerView easyRecyclerView = (EasyRecyclerView) arrayList.get(i15);
            int i16 = i15 * 10;
            while (true) {
                i12 = i15 + 1;
                if (i16 >= i12 * 10 || i16 >= size) {
                    easyRecyclerView.setData(arrayList2);
                    i15 = i12;
                } else {
                    IndexFeatureItem indexFeatureItem = list.get(i16);
                    indexFeatureItem.index = i16;
                    indexFeatureItem.type = 8;
                    if (i15 == 0) {
                        if (indexFeatureItem.groupCode != null) {
                            this.X1 += indexFeatureItem.groupCode;
                        }
                        this.X1 += Constants.ACCEPT_TIME_SEPARATOR_SP;
                    } else {
                        if (indexFeatureItem.groupCode != null) {
                            this.Y1 += indexFeatureItem.groupCode;
                        }
                        this.Y1 += Constants.ACCEPT_TIME_SEPARATOR_SP;
                    }
                    arrayList2.add(indexFeatureItem);
                    i16++;
                }
            }
            easyRecyclerView.setData(arrayList2);
            i15 = i12;
        }
        if (!TextUtils.isEmpty(this.X1)) {
            this.X1 = this.X1.substring(0, this.X1.length() - 1);
        }
        if (!TextUtils.isEmpty(this.Y1)) {
            this.Y1 = this.Y1.substring(0, this.Y1.length() - 1);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("type_list", this.X1);
        if (Q2) {
            hashMap2.put("testKey", "A");
            gs.g.i("ball_icon_show", hashMap2);
        }
        this.W.clear();
        this.W.addAll(arrayList);
        this.Q1.d(arrayList);
        this.U.invalidate();
        Zl();
        this.U.setCurrentItem(0);
    }

    public final ImageView gk(View view) {
        ImageView imageView = (ImageView) getLayoutInflater().inflate(R.layout.part_home_new_hand_area_snapshot_image_view, (ViewGroup) null);
        Bitmap a11 = BitmapUtils.a(view);
        if (a11 != null) {
            imageView.setImageBitmap(BitmapUtils.b(a11, ((float) a11.getWidth()) / 2.0f, ((float) a11.getHeight()) / 2.0f, ((float) a11.getHeight()) / 2.0f));
        }
        return imageView;
    }

    public final void gm() {
        if (this.f73599m.isPlaying()) {
            i6.d.c("ray25", "setBannnerStatus rpvActBanner.pause()");
            this.f73599m.pause();
        }
        if (this.A.e()) {
            this.A.h();
        }
    }

    public void h7(boolean z11, List<HomeActivityEntity> list) {
        ViewUtil.m(this.f73571d0, z11);
        if (z11) {
            ImageView imageView = (ImageView) this.f73571d0.findViewById(R.id.iv_capsule);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            f6.c.a().e(imageView, list.get(0).img);
            imageView.setOnClickListener(new t(this, list));
        }
    }

    public final int hk() {
        SP.s("key_home_page_layout_type", "A");
        return R.layout.fragment_home_type_a;
    }

    public void hm() {
        Subscriber<Long> subscriber = this.I2;
        if (subscriber != null) {
            subscriber.unsubscribe();
            this.I2 = null;
        }
    }

    public final String ik(List<RankList> list, int i11, int i12) {
        String str = null;
        if (!list.isEmpty()) {
            if (list.size() > (i12 != -1 ? i12 : i11)) {
                if (i12 != -1) {
                    i11 = i12;
                }
                RankList rankList = list.get(i11);
                this.F1 = rankList;
                int type = rankList != null ? rankList.getType() : 1;
                RankList rankList2 = this.F1;
                if (!(rankList2 == null || rankList2.getType() == 4)) {
                    List<RankScreenBean> screenListObject = this.F1.getScreenListObject();
                    RankList rankList3 = this.F1;
                    if (rankList3 != null && rankList3.isScreen() && screenListObject != null && !screenListObject.isEmpty()) {
                        RankScreenBean rankScreenBean = screenListObject.get(0);
                        str = rankScreenBean != null ? rankScreenBean.getScreenValue() : "";
                    }
                }
                b7.b.h(str, type);
            }
        }
        return str;
    }

    public void im() {
        Subscriber<Long> subscriber = this.J2;
        if (subscriber != null) {
            subscriber.unsubscribe();
            this.J2 = null;
        }
    }

    public final void initViewPager() {
        we.b.l("home_feed_refresh", Integer.class).observe(this, new w(this));
        this.f73636w1 = (TabLayout) this.f67460i.b(R.id.home_tabLayout);
        this.U0 = (LinearLayout) this.f67460i.b(R.id.home_feed_linear_tabLayout);
        this.V0 = this.f67460i.b(R.id.home_release_btn);
        this.f73640x1 = (ConsecutiveViewPager) this.f67460i.b(R.id.home_viewPager);
        this.f73644y1 = HomeHelper.h(getActivity(), this.f73640x1, this.f73636w1, getChildFragmentManager());
        try {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_home_live, (ViewGroup) null);
            this.f73636w1.getTabAt(5).setCustomView(inflate);
            this.f73636w1.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new l0());
            we.b.l("hasLiving", Object.class).observe(this, new v(inflate));
        } catch (IndexOutOfBoundsException e11) {
            e11.printStackTrace();
        }
        HomeHelper.a(this, this.T0, this.I, this.f73640x1, this.f73636w1);
        this.f73636w1.post(new m0());
        Tj();
    }

    public void initViews() {
        RemoteSkinBean.RemoteTabBarBean tabbar;
        RemoteSkinBean.RemoteTabBarBean.TabBarBean tabBarBean;
        P2 = ScreenUtil.dip2px(120.0f);
        this.I1 = (int) getResources().getDimension(R.dimen.dimen_0);
        this.J1 = (int) getResources().getDimension(R.dimen.dimen_10);
        this.K1 = (int) getResources().getDimension(R.dimen.dimen_8);
        this.f73646z = getResources().getDisplayMetrics().widthPixels;
        this.K = (RelativeLayout) this.f67460i.b(R.id.status_bar_and_search_bar_container);
        this.L = (ConstraintLayout) this.f67460i.b(R.id.banner_and_notice_bar_container);
        Hc(this.O ? this.M : this.N);
        this.R = (FrameLayout) this.f67460i.b(R.id.webview_pool_container);
        View b11 = this.f67460i.b(R.id.index_page_status_bar_shadow);
        this.P = b11;
        b11.setVisibility(4);
        View b12 = this.f67460i.b(R.id.index_page_search_bar_shadow);
        this.Q = b12;
        b12.setVisibility(4);
        this.E = (MyNestedScrollView) this.f67460i.b(R.id.ns_content_index);
        this.T0 = (ConsecutiveScrollerLayout) this.f67460i.b(R.id.scrollerLayout);
        this.f73599m = (RollPagerView) this.f67460i.b(R.id.roll_view_pager);
        this.F = (LoadingRelativeLayout) this.f67460i.b(R.id.main_content);
        AnimHintView animHintView = new AnimHintView(getActivity());
        this.f73603n = animHintView;
        animHintView.setNormalResId(0);
        this.f73603n.setBgResId(R.drawable.hint_indicator_bg);
        this.f73603n.setFocusResId(R.drawable.hint_indicator_focus);
        this.f73607o = (LoadingLayout) this.f67460i.b(R.id.index_loading_layout);
        this.T = this.f67460i.b(R.id.bannerPlaceHolder);
        this.G = (TextView) this.f67460i.b(R.id.banner_indicator_index);
        this.H = (TextView) this.f67460i.b(R.id.banner_indicator_total);
        this.f73570c2 = (LinearLayout) this.f67460i.b(R.id.quick_view_pager_group);
        ((IndexPresenter) yh()).G2(this.P1);
        this.f73599m.setHintView(this.f73603n);
        this.f73599m.getViewPager().setClipToPadding(false);
        this.f73599m.getViewPager().setPageMargin(0);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f73599m.getViewPager().setNestedScrollingEnabled(false);
        }
        androidx.core.view.h0.N0(this.f73599m.getViewPager(), false);
        this.f73638x = this.f67460i.b(R.id.index_market_list_parent);
        this.f73642y = this.f67460i.b(R.id.index_market_list_parent_bottom);
        this.f73610p = (ViewPager2) this.f67460i.b(R.id.market_view_pager2);
        this.f73613q = (CommonHorizontalIndicator) this.f67460i.b(R.id.index_market_list_scroll_bar);
        this.f73616r = (LottieAnimationView) this.f67460i.b(R.id.market_slide_guide);
        this.A = (TopScrollNoticeView) this.f67460i.b(R.id.index_notice_layout);
        this.E1 = (ConstraintLayout) this.f67460i.b(R.id.notice_bar);
        SafeLottieView safeLottieView = (SafeLottieView) this.f67460i.b(R.id.lottie_red_package);
        this.D = safeLottieView;
        safeLottieView.setImageAssetsFolder("images/");
        this.C0 = (IndexTextListIndicator) this.f67460i.b(R.id.market_tab);
        this.D0 = (IndexViewPager) this.f67460i.b(R.id.ranking_viewpager);
        this.E0 = (LinearLayout) this.f67460i.b(R.id.ll_main_ranking_more);
        this.F0 = (LinearLayout) this.f67460i.b(R.id.ranking_view_more);
        this.G0 = this.f67460i.b(R.id.botton_margin_View);
        this.H0 = (TextView) this.f67460i.b(R.id.tv_view_more);
        this.f73593k1 = (IndexUserGuideView) this.f67460i.b(R.id.index_user_guide_view);
        this.C0.setCallback(new f0());
        ViewPagerHelper.a(this.C0, this.D0);
        this.f73563a1 = (IndicatorView) this.f67460i.b(R.id.indicator);
        this.f73566b1 = (TextView) this.f67460i.b(R.id.tv_message_count);
        this.f73569c1 = this.f67460i.b(R.id.tv_more_count);
        this.f73572d1 = this.f67460i.b(R.id.v_message_count_dot);
        this.f73575e1 = (RelativeLayout) this.f67460i.b(R.id.rl_message);
        this.f73578f1 = (RelativeLayout) this.f67460i.b(R.id.rl_more);
        this.f73581g1 = (ImageView) this.f67460i.b(R.id.id_index_message_img);
        ImageView imageView = (ImageView) this.f67460i.b(R.id.id_index_more);
        this.f73584h1 = imageView;
        imageView.setBackgroundResource(R.drawable.closepath_function_special);
        this.S = (LinearLayout) this.f67460i.b(R.id.ll_search);
        this.B = (TextView) this.f67460i.b(R.id.search_symbol_input);
        this.B.setText(getString(R.string.n_market_collecation_tab_name) + " | " + getString(R.string.n_asset_ybb_stop_financial) + " | " + getString(R.string.n_global_search_home_flash));
        this.C = (HomeSearchCarouseView) this.f67460i.b(R.id.search_symbol_carouse);
        this.I = (SmartRefreshLayout) this.f67460i.b(R.id.refresh_index_layout);
        Ak();
        Ol();
        zk();
        Bk(getActivity());
        xk();
        nk();
        sk();
        mk();
        pk();
        tk();
        qk();
        rk();
        initViewPager();
        View b13 = this.f67460i.b(R.id.index_page_status_bar);
        ViewGroup.LayoutParams layoutParams = b13.getLayoutParams();
        layoutParams.height = BaseActivity.getStatusBarHeight(b13.getContext());
        b13.setLayoutParams(layoutParams);
        View b14 = this.f67460i.b(R.id.index_page_status_bar_shadow);
        ViewGroup.LayoutParams layoutParams2 = b14.getLayoutParams();
        layoutParams2.height = BaseActivity.getStatusBarHeight(b14.getContext());
        b14.setLayoutParams(layoutParams2);
        View b15 = this.f73607o.b(1);
        if (b15 != null) {
            b15.setBackgroundResource(R.drawable.shape_fill_dialog_radius_10);
        }
        View b16 = this.f73607o.b(4);
        if (b16 != null) {
            b16.setBackgroundResource(R.drawable.shape_fill_dialog_radius_10);
        }
        View b17 = this.f73607o.b(0);
        if (b17 != null) {
            b17.setBackgroundResource(R.drawable.shape_fill_dialog_radius_10);
        }
        if (getActivity() != null) {
            ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(R.id.main_home_tab);
            this.f73614q1 = viewGroup;
            if (viewGroup != null) {
                this.f73617r1 = (CheckBox) viewGroup.findViewById(R.id.main_index_cb);
                this.f73620s1 = (CheckBox) this.f73614q1.findViewById(R.id.main_index_cb_bg);
                this.f73624t1 = (CheckBox) this.f73614q1.findViewById(R.id.main_index_cb_icon);
                RemoteSkinBean d11 = com.huobi.main.helper.a.c().d(getContext());
                boolean g11 = NightHelper.e().g();
                if (d11 != null && (tabbar = d11.getTabbar()) != null) {
                    if (g11) {
                        tabBarBean = tabbar.getNight();
                    } else {
                        tabBarBean = tabbar.getLight();
                    }
                    if (tabBarBean != null) {
                        RemoteSkinBean.RemoteTabBarBean.TabBarBean.TabBarItem home = tabBarBean.getHome();
                        RemoteSkinBean.RemoteTabBarBean.TabBarBean.TabRocketItem rocket = tabBarBean.getRocket();
                        String icon = home.getIcon();
                        String rocket_icon = rocket.getRocket_icon();
                        this.f73620s1.setButtonDrawable(com.huobi.main.helper.a.c().b(R.drawable.tab_bg_feed_top_bg, rocket.getRocket_bg(), icon));
                        this.f73624t1.setButtonDrawable(com.huobi.main.helper.a.c().b(R.drawable.tab_bg_feed_top_icon, rocket_icon, icon));
                    }
                }
            }
        }
    }

    /* renamed from: jk */
    public IndexPresenter.s0 zh() {
        return this;
    }

    public void jm() {
        Subscriber<Long> subscriber = this.f73586i0;
        if (subscriber != null) {
            subscriber.unsubscribe();
            this.f73586i0 = null;
        }
    }

    public final void kk() {
        this.f73631v0.findViewById(R.id.ll_normal_invest).setVisibility(8);
    }

    public final void km() {
        EasyRecyclerView<s9.a> easyRecyclerView = this.O0;
        if (easyRecyclerView != null && easyRecyclerView.getLayoutManager() != null) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) easyRecyclerView.getLayoutManager();
            v9.a aVar = (v9.a) easyRecyclerView.getAdapter();
            int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition >= 0) {
                int findLastCompletelyVisibleItemPosition = gridLayoutManager.findLastCompletelyVisibleItemPosition();
                while (findFirstVisibleItemPosition <= findLastCompletelyVisibleItemPosition) {
                    if (!(aVar == null || aVar.c() == null)) {
                        List c11 = aVar.c();
                        if (findFirstVisibleItemPosition < c11.size()) {
                            LiveDetailBean d11 = ((IndexLiveItem) c11.get(findFirstVisibleItemPosition)).d();
                            int i11 = d11.status;
                            int i12 = 2;
                            if (i11 != 2) {
                                i12 = i11 != 4 ? i11 != 5 ? -1 : 3 : 1;
                            } else if (d11.appointed == 1) {
                                i12 = 0;
                            }
                            if (!this.N2[findFirstVisibleItemPosition] && i12 != -1) {
                                LiveTrackUtils.a("homelive_show", Integer.valueOf(i12), d11.f70249id, Integer.valueOf(findFirstVisibleItemPosition + 1), Integer.valueOf(findLastCompletelyVisibleItemPosition + 1));
                                this.N2[findFirstVisibleItemPosition] = true;
                            }
                        }
                    }
                    findFirstVisibleItemPosition++;
                }
            }
        }
    }

    public void lb(boolean z11, HomePageEarnData homePageEarnData) {
        List<HomePageEarnData.IndexAreaContentItemVo> list;
        Log.d("IndexTAGFragment", "showEarn -- display:" + z11);
        if (!z11 || homePageEarnData == null || homePageEarnData.show == 0 || (list = homePageEarnData.contents) == null || list.size() == 0) {
            RelativeLayout relativeLayout = this.f73627u0.f73527a;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                return;
            }
            return;
        }
        List<HomePageEarnData.IndexAreaContentItemVo> list2 = homePageEarnData.contents;
        int size = list2 != null ? list2.size() : 0;
        String str = "";
        for (int i11 = 0; i11 < size; i11++) {
            str = str + homePageEarnData.contents.get(i11).projectId;
            if (i11 != size - 1) {
                str = str + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type_list", str);
        hashMap.put("testKey", "A");
        gs.g.i("homeEarn_show", hashMap);
        this.f73643y0 = homePageEarnData;
        try {
            Pl(homePageEarnData);
            Xl(homePageEarnData);
            Vl(homePageEarnData);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void lk() {
        RelativeLayout relativeLayout = this.f73574e0;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            ViewGroup.LayoutParams layoutParams = this.f73574e0.getLayoutParams();
            Message obtainMessage = this.P1.obtainMessage();
            obtainMessage.what = 5;
            int i11 = layoutParams.height - 20;
            layoutParams.height = i11;
            obtainMessage.arg1 = i11;
            this.P1.sendMessage(obtainMessage);
        }
    }

    public final void lm(boolean z11) {
        if (z11) {
            boolean y11 = gj.d.n().y();
            String format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Calendar.getInstance().getTime());
            boolean z12 = !y11 && i6.m.k0(format) > 20211229 && i6.m.k0(format) < 20220105 && AppLanguageHelper.getInstance().isEnglishLanguage();
            ViewUtil.m(this.f67460i.b(R.id.index_page_nav_bar_layout_christmas), z12);
            this.S.setBackgroundResource(z12 ? R.color.color_home_search_bg_only_daytime : R.drawable.search_bar_shape);
        }
    }

    public void mf(boolean z11) {
        ConstraintLayout constraintLayout = this.L;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(z11 ? 0 : 8);
            if (z11) {
                this.f73593k1.setVisibility(8);
            } else {
                this.f73593k1.setVisibility(0);
            }
        }
    }

    public final void mk() {
        this.f73568c0 = (EasyRecyclerView) this.f67460i.b(R.id.rv_index_recommended);
        this.f73565b0 = this.f67460i.b(R.id.frame_layout_idnex_recommended);
        WrapContentGridLayoutManager wrapContentGridLayoutManager = new WrapContentGridLayoutManager(getContext(), 2);
        this.D1 = wrapContentGridLayoutManager;
        this.f73568c0.setLayoutManager(wrapContentGridLayoutManager);
        GridDividerItemDecoration gridDividerItemDecoration = new GridDividerItemDecoration(ContextCompat.getDrawable(getContext(), R.color.baseColorPrimarySeparator), 1);
        gridDividerItemDecoration.setMainPagesBiz(true);
        this.f73568c0.addItemDecoration(gridDividerItemDecoration);
    }

    public final void mm(boolean z11) {
        boolean y11 = gj.d.n().y();
        if (z11) {
            ViewUtil.m(this.f67460i.b(R.id.index_page_nav_bar_layout), y11);
        }
    }

    public void n7() {
        f6().g();
        this.A0.j();
    }

    public void nd(HomeCommonData homeCommonData) {
        if (homeCommonData == null) {
            Log.e("IndexTAGFragment", "home common data is null");
            return;
        }
        this.f73579f2 = homeCommonData.getNavigationDefaultImgUrl();
        this.f73582g2 = homeCommonData.getNavigationDayImgUrl();
        this.f73585h2 = homeCommonData.getNavigationNightImgUrl();
        this.f73588i2 = homeCommonData.getNavigationJumpUrl();
        zl();
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void netWorkChangeEvent(NetworkStatus.ConnectEvent connectEvent) {
        boolean c11 = NetworkStatus.c(getContext());
        Log.d("IndexTAGFragment", "netWorkChangeEvent--isConnected:" + c11);
        if (c11) {
            Log.d("IndexTAGFragment", "netWorkChangeEvent--connectEvent:" + connectEvent);
            Log.d("IndexTAGFragment", "netWorkChangeEvent--isMainThread:" + ThreadUtils.a());
            int i11 = g0.f73671a[connectEvent.ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3) {
                Fl(true);
            }
        }
    }

    public final void nk() {
        this.f73571d0 = (RelativeLayout) this.f67460i.b(R.id.rl_capsule);
    }

    public void o5(List<RankDynamicItem> list, int i11) {
        i6.d.j("FutureRank", "updateFutureRankView rankFragmentTYpe=" + i11 + " rankItemList.size=" + list.size());
        if (i11 == 1) {
            this.f73587i1 = list;
        } else if (i11 == 6) {
            this.f73590j1 = list;
        }
    }

    public final void ok() {
        this.f73627u0.f73527a = (RelativeLayout) this.f67460i.b(R.id.index_earn_container);
        this.f73627u0.f73528b = (TextView) this.f67460i.b(R.id.rv_huo_bi_earn_title);
        this.f73627u0.f73529c = (ImageView) this.f67460i.b(R.id.iv_huo_bi_earn_more);
        this.f73627u0.f73530d = (RelativeLayout) this.f67460i.b(R.id.rl_huo_bi_earn);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 1001) {
            String stringExtra = intent.getStringExtra("result_string");
            i6.d.i("onActivityResult resultString=" + stringExtra);
            if (t0.c(stringExtra)) {
                yl.r.b().flatMap(i0.f73903b).compose(RxJavaHelper.t(zh())).subscribe(new o());
            } else if (t0.b(stringExtra)) {
                Uri parse = Uri.parse(stringExtra);
                String queryParameter = parse.getQueryParameter("tsvToken");
                i6.d.j("QR-SCAN", "tsvToken=" + queryParameter);
                if (Xj(parse)) {
                    Gl(queryParameter);
                    return;
                }
                i6.d.e("QR-SCAN", "checkSign Failed.");
                HuobiToastUtil.j(R.string.n_qr_scan_not_available);
            } else if (t0.d(stringExtra)) {
                try {
                    zn.a.d().v(Uri.parse(stringExtra)).a().c();
                } catch (Exception e11) {
                    e11.printStackTrace();
                    HuobiToastUtil.j(R.string.n_qr_scan_not_available);
                }
            } else if (TextUtils.isEmpty(stringExtra) || !stringExtra.startsWith(ImageSource.ASSET_SCHEME)) {
                HuobiToastUtil.j(R.string.n_qr_scan_not_available);
            } else {
                HBBaseWebActivity.showWebView(getActivity(), stringExtra, (String) null, (String) null, false);
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f73562a0 = (HuobiMainActivity) context;
        yl.o.f76854b = false;
        yl.o.f76853a = 0;
        TimeMonitorManager.a().b("huobiapp_home_start").c();
        Log.d("TimeMonitor", "TimeMonitor -- start:" + System.currentTimeMillis());
        Fl(false);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onBackgroundStatusChanged(OnBackgroundStatusChangedEvent onBackgroundStatusChangedEvent) {
        if (onBackgroundStatusChangedEvent.a() == OnBackgroundStatusChangedEvent.STATUS.FOREGROUND) {
            i6.d.b("后台切前台");
            IndexLifeCycleTracer.c().f73495c++;
            IndexLifeCycleTracer.c().f(IndexLifeCycleStep.AppEnterForgeground);
        } else if (onBackgroundStatusChangedEvent.a() == OnBackgroundStatusChangedEvent.STATUS.BACKGROUND) {
            i6.d.b("切后台");
            IndexLifeCycleTracer.c().f(IndexLifeCycleStep.AppEnterBackground);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.d().p(this);
    }

    public void onDestroy() {
        super.onDestroy();
        HomeSearchCarouseView homeSearchCarouseView = this.C;
        if (homeSearchCarouseView != null) {
            homeSearchCarouseView.k();
        }
        EventBus.d().r(this);
    }

    public void onDetach() {
        hm();
        jm();
        i6.i.b().h(this.R1);
        super.onDetach();
    }

    public void onPause() {
        super.onPause();
        Yj();
    }

    public void onPermissionsDenied(int i11, List<String> list) {
        i6.d.i("onPermissionsGranted requestCode=" + i11 + " perms=" + list);
    }

    public void onPermissionsGranted(int i11, List<String> list) {
        if (128 == i11) {
            PhoneUtils.u(getActivity());
            PhoneUtils.j(getActivity());
            PhoneUtils.n(getActivity());
        }
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        EasyPermissions.onRequestPermissionsResult(i11, strArr, iArr, this);
    }

    public void onResume() {
        super.onResume();
        i6.d.e("ray92", (System.currentTimeMillis() - StartAppUtil.f42183a) + " IndexFragment onResume end                      ");
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int hk2 = hk();
        this.M1 = getResources().getColor(R.color.baseColorMajorTheme100);
        IndexLifeCycleTracer.c().f(IndexLifeCycleStep.AppHomePage);
        return layoutInflater.inflate(hk2, viewGroup, false);
    }

    public final void pk() {
        ok();
        wk();
        vk();
    }

    public final void pl() {
        OtcOrderReminder.e().k(this.E, false);
        Il(this.G1);
        if (Ck() && this.G1 < 100) {
            Nl();
        }
    }

    public final void qk() {
        this.f73631v0 = (RelativeLayout) this.f67460i.b(R.id.index_invest_container);
    }

    public final void ql(LottieAnimationView lottieAnimationView) {
        Handler handler = new Handler(Looper.getMainLooper());
        Objects.requireNonNull(lottieAnimationView);
        handler.postDelayed(new d0(lottieAnimationView), 1000);
    }

    public void rg(IndexFeature indexFeature) {
        if (indexFeature != null && indexFeature.getIndexFeatureItems() != null && !indexFeature.getIndexFeatureItems().isEmpty()) {
            Collections.sort(indexFeature.getIndexFeatureItems(), g0.f73895b);
            IndexFeatureItem indexFeatureItem = indexFeature.getIndexFeatureItems().get(0);
            if (indexFeatureItem != null && this.f67463e) {
                g6.b.c().m(indexFeatureItem.getImgUrl(), new m(indexFeatureItem));
            }
        }
    }

    public final void rk() {
        this.O0 = (EasyRecyclerView) this.f67460i.b(R.id.index_live_rv);
        this.P0 = (TextView) this.f67460i.b(R.id.live_more_tv);
        this.Q0 = (LinearLayout) this.f67460i.b(R.id.rl_huobi_live);
        this.R0 = this.f67460i.b(R.id.index_live_container);
        this.O0.setLayoutManager(this.S0);
    }

    public void rl() {
        boolean l11 = SP.l("market_slide_guide_played", false);
        this.f73619s = l11;
        if (!l11) {
            SP.y("market_slide_guide_played", true);
            i6.i.b().g(new z(), 3000);
            return;
        }
        if (this.f73622t != null) {
            this.f73622t = null;
        }
        if (this.f73626u != null) {
            this.f73626u = null;
        }
        if (this.f73630v != null) {
            this.f73630v = null;
        }
        if (this.f73634w != null) {
            this.f73634w = null;
        }
    }

    public void sa(String str) {
        i6.d.j("IndexTAGFragment", "showHomePageHot:" + str);
        if (!TextUtils.isEmpty(str)) {
            this.B.setText(str);
        }
    }

    public void showProgressDialog() {
        i6.i.b().d(new f0(this));
    }

    public final void sk() {
        yg.c cVar = new yg.c(this.N0);
        this.J0 = cVar;
        this.f73610p.setAdapter(cVar);
        this.f73610p.registerOnPageChangeCallback(new k0());
    }

    public final void sl() {
        vl(new q(gk(this.f73577f0)));
    }

    public void t6(boolean z11) {
        i6.d.j("IndexTAGFragment", "showHomePageExtraTag:" + z11);
        ViewUtil.m(this.f73569c1, z11);
    }

    public final void tk() {
        this.f73574e0 = (RelativeLayout) this.f67460i.b(R.id.rl_new_user_gift_bag_container);
        this.f73596l0 = (ViewGroup) this.f67460i.b(R.id.rl_new_hand_area_animation_layer);
        Uj();
        uk();
        this.f73574e0.setVisibility(8);
    }

    public final void tl(View view, View view2, ImageView imageView) {
        View view3 = view2;
        ImageView imageView2 = imageView;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i11 = iArr[1];
        Point point = new Point();
        point.x = iArr[0] + (view.getWidth() / 2);
        point.y = i11;
        int[] iArr2 = new int[2];
        view3.getLocationOnScreen(iArr2);
        Point point2 = new Point();
        point2.x = iArr2[0] + (view2.getWidth() / 2);
        point2.y = iArr2[1] - (view2.getHeight() * 2);
        this.f73596l0.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = i11;
        imageView2.setLayoutParams(layoutParams);
        this.f73596l0.removeAllViews();
        this.f73596l0.addView(imageView2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView2, "translationX", new float[]{(float) (point2.x - point.x)});
        ofFloat.setDuration(500);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, "translationY", new float[]{(float) (point2.y - point.y)});
        ofFloat2.setDuration(500);
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        FastOutSlowInInterpolator fastOutSlowInInterpolator = new FastOutSlowInInterpolator();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView2, "scaleX", new float[]{0.2f});
        ofFloat3.setDuration(500);
        ofFloat3.setInterpolator(fastOutSlowInInterpolator);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView2, "scaleX", new float[]{0.4f});
        ofFloat4.setDuration(500);
        ofFloat4.setInterpolator(fastOutSlowInInterpolator);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(imageView2, "alpha", new float[]{1.0f, 0.0f, 0.0f});
        ofFloat5.setDuration(500);
        ofFloat5.setInterpolator(fastOutSlowInInterpolator);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(imageView2, "scaleY", new float[]{0.2f});
        ofFloat6.setDuration(500);
        ofFloat6.setInterpolator(fastOutSlowInInterpolator);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(imageView2, "scaleY", new float[]{0.4f});
        ofFloat7.setDuration(500);
        ofFloat7.setInterpolator(fastOutSlowInInterpolator);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(view3, "scaleX", new float[]{1.0f, 1.2f, 0.9f, 1.05f, 1.0f});
        ofFloat8.setDuration(664);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view3, "scaleY", new float[]{1.0f, 1.2f, 0.9f, 1.05f, 1.0f});
        ofFloat9.setDuration(664);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.play(ofFloat3).with(ofFloat6);
        animatorSet.play(ofFloat4).after(ofFloat3);
        animatorSet.play(ofFloat7).after(ofFloat6);
        animatorSet.play(ofFloat5).after(ofFloat3);
        animatorSet.play(ofFloat8).with(ofFloat9).after(ofFloat3);
        animatorSet.start();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0041 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uh(boolean r6) {
        /*
            r5 = this;
            super.uh(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "fragment--onVisibleChangedFinal--visible:"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "IndexTAGFragment"
            android.util.Log.d(r1, r0)
            r5.mm(r6)
            r5.lm(r6)
            com.hbg.lib.common.mvp.BaseFragmentPresenter r0 = r5.yh()
            com.huobi.index.presenter.IndexPresenter r0 = (com.huobi.index.presenter.IndexPresenter) r0
            r0.o1()
            Q2 = r6
            r0 = 0
            r1 = 0
            if (r6 != 0) goto L_0x005d
            com.hbg.lib.common.mvp.BaseFragmentPresenter r6 = r5.yh()
            com.huobi.index.presenter.IndexPresenter r6 = (com.huobi.index.presenter.IndexPresenter) r6
            r6.R2(r1)
            yl.l r6 = r5.A0
            r6.c()
            com.huobi.index.ui.IndexHomeRedDialogFragment r6 = r5.f73605n1     // Catch:{ Exception -> 0x0041 }
            r6.dismiss()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            com.huobi.index.ui.IndexHomeGiftDialogFragment r6 = r5.f73608o1     // Catch:{ Exception -> 0x0046 }
            r6.dismiss()     // Catch:{ Exception -> 0x0046 }
        L_0x0046:
            com.huobi.view.rollviewpager.RollPagerView r6 = r5.f73599m
            if (r6 == 0) goto L_0x004d
            r6.pause()
        L_0x004d:
            com.hbg.lib.widgets.TopScrollNoticeView r6 = r5.A
            if (r6 == 0) goto L_0x0054
            r6.h()
        L_0x0054:
            android.view.ViewGroup r6 = r5.f73614q1
            if (r6 == 0) goto L_0x0104
            r6.setOnTouchListener(r0)
            goto L_0x0104
        L_0x005d:
            com.hbg.lib.common.mvp.BaseFragmentPresenter r6 = r5.yh()
            com.huobi.index.presenter.IndexPresenter r6 = (com.huobi.index.presenter.IndexPresenter) r6
            r2 = 1
            r6.R2(r2)
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r3 = "testKey"
            java.lang.String r4 = "A"
            r6.put(r3, r4)
            java.lang.String r6 = "homepage_view"
            gs.g.i(r6, r0)
            tg.r r6 = tg.r.x()
            r6.F0()
            com.huobi.view.rollviewpager.RollPagerView r6 = r5.f73599m
            if (r6 == 0) goto L_0x00b0
            androidx.viewpager.widget.ViewPager r6 = r6.getViewPager()
            if (r6 == 0) goto L_0x00b0
            com.huobi.view.rollviewpager.RollPagerView r6 = r5.f73599m
            androidx.viewpager.widget.ViewPager r6 = r6.getViewPager()
            androidx.viewpager.widget.PagerAdapter r6 = r6.getAdapter()
            if (r6 == 0) goto L_0x00b0
            com.huobi.view.rollviewpager.RollPagerView r6 = r5.f73599m
            androidx.viewpager.widget.ViewPager r6 = r6.getViewPager()
            androidx.viewpager.widget.PagerAdapter r6 = r6.getAdapter()
            boolean r3 = r6 instanceof yg.a
            if (r3 == 0) goto L_0x00b0
            yg.a r6 = (yg.a) r6
            boolean r6 = r6.g()
            if (r6 != 0) goto L_0x00b0
            com.huobi.view.rollviewpager.RollPagerView r6 = r5.f73599m
            r6.resume()
        L_0x00b0:
            com.hbg.lib.widgets.TopScrollNoticeView r6 = r5.A
            if (r6 == 0) goto L_0x00b7
            r6.g()
        L_0x00b7:
            androidx.fragment.app.FragmentActivity r6 = r5.getActivity()
            com.hbg.lib.widgets.ClosePathFloatView.g(r0, r6, r1)
            tg.r r6 = tg.r.x()
            boolean r6 = r6.F0()
            if (r6 != 0) goto L_0x00d2
            android.widget.TextView r6 = r5.f73566b1
            com.hbg.lib.common.utils.ViewUtil.m(r6, r1)
            android.view.View r6 = r5.f73572d1
            com.hbg.lib.common.utils.ViewUtil.m(r6, r1)
        L_0x00d2:
            com.huobi.index.ui.c0 r6 = new com.huobi.index.ui.c0
            r6.<init>(r5)
            fr.a.g(r6)
            java.lang.String r6 = "Index_TOP"
            java.lang.String r0 = "onVisibleChangedFinal"
            android.util.Log.d(r6, r0)
            boolean r6 = yl.s.a()
            if (r6 == 0) goto L_0x00ea
            r5.Yl()
        L_0x00ea:
            yl.x r6 = yl.x.n()
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            r6.t(r0)
            android.view.ViewGroup r6 = r5.f73614q1
            if (r6 == 0) goto L_0x0101
            com.huobi.index.ui.IndexFragment$c r0 = new com.huobi.index.ui.IndexFragment$c
            r0.<init>()
            r6.setOnTouchListener(r0)
        L_0x0101:
            r5.Fl(r2)
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.index.ui.IndexFragment.uh(boolean):void");
    }

    public final void uk() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f73574e0.findViewById(R.id.rl_new_user_gift_bag_root_layout);
        this.f73577f0 = relativeLayout;
        this.f73600m0 = (RectangleScaleToCircleView) relativeLayout.findViewById(R.id.rectangle_scale_to_circle_view);
        this.f73604n0 = this.f73577f0.findViewById(R.id.view_new_hand_area_close);
        this.f73591j2 = (LinearLayout) this.f73577f0.findViewById(R.id.title_layout);
        this.f73594k2 = this.f73577f0.findViewById(R.id.progress_layout_view_one);
        this.f73598l2 = (LottieAnimationView) this.f73577f0.findViewById(R.id.progress_register_icon);
        this.f73602m2 = this.f73577f0.findViewById(R.id.progress_layout_view_two);
        this.f73606n2 = (LottieAnimationView) this.f73577f0.findViewById(R.id.progress_amount_icon);
        this.f73609o2 = this.f73577f0.findViewById(R.id.progress_layout_view_three);
        this.f73612p2 = (LottieAnimationView) this.f73577f0.findViewById(R.id.progress_deal_icon);
        this.f73615q2 = this.f73577f0.findViewById(R.id.progress_layout_view_four);
        if (this.O) {
            this.f73598l2.setAnimation("home_guide_receive_rewards_night.json");
            this.f73606n2.setAnimation("home_guide_receive_rewards_night.json");
            this.f73612p2.setAnimation("home_guide_receive_rewards_night.json");
        } else {
            this.f73598l2.setAnimation("home_guide_receive_rewards.json");
            this.f73606n2.setAnimation("home_guide_receive_rewards.json");
            this.f73612p2.setAnimation("home_guide_receive_rewards.json");
        }
        this.f73618r2 = (LinearLayout) this.f73577f0.findViewById(R.id.progress_register_bottom_layout);
        this.f73621s2 = (TextView) this.f73577f0.findViewById(R.id.progress_register_text);
        this.f73625t2 = (ImageView) this.f73577f0.findViewById(R.id.progress_register_arrow);
        this.f73629u2 = (LinearLayout) this.f73577f0.findViewById(R.id.progress_amount_bottom_layout);
        this.f73633v2 = (TextView) this.f73577f0.findViewById(R.id.progress_amount_text);
        this.f73637w2 = (ImageView) this.f73577f0.findViewById(R.id.progress_amount_arrow);
        this.f73641x2 = (LinearLayout) this.f73577f0.findViewById(R.id.progress_deal_bottom_layout);
        this.f73645y2 = (TextView) this.f73577f0.findViewById(R.id.progress_deal_text);
        this.f73649z2 = (ImageView) this.f73577f0.findViewById(R.id.progress_deal_arrow);
        this.A2 = (RelativeLayout) this.f73577f0.findViewById(R.id.bottom_layout);
        this.B2 = (TextView) this.f73577f0.findViewById(R.id.bottom_title);
        this.C2 = (TextView) this.f73577f0.findViewById(R.id.bottom_desc);
        this.D2 = (TextView) this.f73577f0.findViewById(R.id.tv_total_award_shadow);
        this.E2 = (TextView) this.f73577f0.findViewById(R.id.tv_total_award);
        this.F2 = (TextView) this.f73577f0.findViewById(R.id.bottom_jump_btn);
        this.G2 = (LottieAnimationView) this.f73577f0.findViewById(R.id.bottom_jump_btn_layer);
        this.H2 = (TextView) this.f73577f0.findViewById(R.id.more_new_user_gift);
    }

    public void ul() {
    }

    public final void vk() {
        this.f73627u0.f73532f = new HuoBiEarnContainer.NormalEarnContainer();
        HuoBiEarnContainer.NormalEarnContainer normalEarnContainer = this.f73627u0.f73532f;
        HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem normalEarnItem = new HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem();
        normalEarnContainer.f73533a = normalEarnItem;
        normalEarnItem.f73536a = (LinearLayout) this.f67460i.b(R.id.ll_normal_earn_type_1);
        HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem normalEarnItem2 = normalEarnContainer.f73533a;
        LinearLayout linearLayout = normalEarnItem2.f73536a;
        normalEarnItem2.f73537b = this.f67460i.b(R.id.normal_earn_separate_line_1);
        normalEarnContainer.f73533a.f73540e = (TextView) linearLayout.findViewById(R.id.tv_normal_earn_type_name);
        normalEarnContainer.f73533a.f73541f = (ImageView) linearLayout.findViewById(R.id.iv_normal_earn_coin_icon);
        normalEarnContainer.f73533a.f73542g = (TextView) linearLayout.findViewById(R.id.tv_normal_earn_coin_name);
        normalEarnContainer.f73533a.f73543h = (TextView) linearLayout.findViewById(R.id.tv_normal_earn_apy_value);
        normalEarnContainer.f73533a.f73543h.setTextColor(getResources().getColor(com.hbg.lib.core.util.w.h()));
        normalEarnContainer.f73533a.f73544i = (TextView) linearLayout.findViewById(R.id.tv_normal_earn_rate);
        normalEarnContainer.f73533a.f73538c = (RelativeLayout) linearLayout.findViewById(R.id.rl_apy_and_coupon);
        normalEarnContainer.f73533a.f73539d = (RelativeLayout) linearLayout.findViewById(R.id.rl_normal_earn_coupon);
        normalEarnContainer.f73533a.f73545j = (TextView) linearLayout.findViewById(R.id.tv_normal_earn_apy);
        normalEarnContainer.f73533a.f73546k = (TextView) linearLayout.findViewById(R.id.tv_normal_earn_ad_tip);
        HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem normalEarnItem3 = new HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem();
        normalEarnContainer.f73534b = normalEarnItem3;
        normalEarnItem3.f73536a = (LinearLayout) this.f67460i.b(R.id.ll_normal_earn_type_2);
        HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem normalEarnItem4 = normalEarnContainer.f73534b;
        LinearLayout linearLayout2 = normalEarnItem4.f73536a;
        normalEarnItem4.f73537b = this.f67460i.b(R.id.normal_earn_separate_line_2);
        normalEarnContainer.f73534b.f73540e = (TextView) linearLayout2.findViewById(R.id.tv_normal_earn_type_name);
        normalEarnContainer.f73534b.f73541f = (ImageView) linearLayout2.findViewById(R.id.iv_normal_earn_coin_icon);
        normalEarnContainer.f73534b.f73542g = (TextView) linearLayout2.findViewById(R.id.tv_normal_earn_coin_name);
        normalEarnContainer.f73534b.f73543h = (TextView) linearLayout2.findViewById(R.id.tv_normal_earn_apy_value);
        normalEarnContainer.f73534b.f73543h.setTextColor(getResources().getColor(com.hbg.lib.core.util.w.h()));
        normalEarnContainer.f73534b.f73544i = (TextView) linearLayout2.findViewById(R.id.tv_normal_earn_rate);
        normalEarnContainer.f73534b.f73538c = (RelativeLayout) linearLayout2.findViewById(R.id.rl_apy_and_coupon);
        normalEarnContainer.f73534b.f73539d = (RelativeLayout) linearLayout2.findViewById(R.id.rl_normal_earn_coupon);
        normalEarnContainer.f73534b.f73545j = (TextView) linearLayout2.findViewById(R.id.tv_normal_earn_apy);
        normalEarnContainer.f73534b.f73546k = (TextView) linearLayout2.findViewById(R.id.tv_normal_earn_ad_tip);
        HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem normalEarnItem5 = new HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem();
        normalEarnContainer.f73535c = normalEarnItem5;
        normalEarnItem5.f73536a = (LinearLayout) this.f67460i.b(R.id.ll_normal_earn_type_3);
        HuoBiEarnContainer.NormalEarnContainer.NormalEarnItem normalEarnItem6 = normalEarnContainer.f73535c;
        LinearLayout linearLayout3 = normalEarnItem6.f73536a;
        normalEarnItem6.f73540e = (TextView) linearLayout3.findViewById(R.id.tv_normal_earn_type_name);
        normalEarnContainer.f73535c.f73541f = (ImageView) linearLayout3.findViewById(R.id.iv_normal_earn_coin_icon);
        normalEarnContainer.f73535c.f73542g = (TextView) linearLayout3.findViewById(R.id.tv_normal_earn_coin_name);
        normalEarnContainer.f73535c.f73543h = (TextView) linearLayout3.findViewById(R.id.tv_normal_earn_apy_value);
        normalEarnContainer.f73535c.f73543h.setTextColor(getResources().getColor(com.hbg.lib.core.util.w.h()));
        normalEarnContainer.f73535c.f73544i = (TextView) linearLayout3.findViewById(R.id.tv_normal_earn_rate);
        normalEarnContainer.f73535c.f73538c = (RelativeLayout) linearLayout3.findViewById(R.id.rl_apy_and_coupon);
        normalEarnContainer.f73535c.f73539d = (RelativeLayout) linearLayout3.findViewById(R.id.rl_normal_earn_coupon);
        normalEarnContainer.f73535c.f73545j = (TextView) linearLayout3.findViewById(R.id.tv_normal_earn_apy);
        normalEarnContainer.f73535c.f73546k = (TextView) linearLayout3.findViewById(R.id.tv_normal_earn_ad_tip);
    }

    public final void vl(RectangleScaleToCircleView.IAnimationPlayState iAnimationPlayState) {
        this.f73600m0.setVisibility(0);
        this.f73600m0.setCircleCenterPoint(new Point(this.f73600m0.getWidth() / 2, this.f73600m0.getHeight() / 2));
        this.f73600m0.setCircleRadiusStepValue(this.f73600m0.getWidth() / 30);
        RectangleScaleToCircleView rectangleScaleToCircleView = this.f73600m0;
        rectangleScaleToCircleView.setCircleMinRadius(((float) rectangleScaleToCircleView.getHeight()) / 2.0f);
        this.f73600m0.setMaskColor(Color.parseColor(this.O ? "#0C101A" : "#F3F3F3"));
        this.f73600m0.startAnimation(iAnimationPlayState);
    }

    public final void wk() {
        this.f73627u0.f73531e = new HuoBiEarnContainer.PrimeEarnContainer();
        HuoBiEarnContainer.PrimeEarnContainer primeEarnContainer = this.f73627u0.f73531e;
        primeEarnContainer.f73547a = (RelativeLayout) this.f67460i.b(R.id.rl_prime_earn);
        primeEarnContainer.f73548b = this.f67460i.b(R.id.prime_earn_separate_line);
        primeEarnContainer.f73549c = (ImageView) this.f67460i.b(R.id.iv_prime_earn_coin_image);
        primeEarnContainer.f73550d = (TextView) this.f67460i.b(R.id.tv_prime_earn_coin_name);
        primeEarnContainer.f73551e = (TextView) this.f67460i.b(R.id.tv_prime_earn_countdown);
        TextView textView = (TextView) this.f67460i.b(R.id.tv_prime_earn_apy);
        primeEarnContainer.f73552f = textView;
        textView.setTextColor(getResources().getColor(com.hbg.lib.core.util.w.h()));
        primeEarnContainer.f73553g = (RelativeLayout) this.f67460i.b(R.id.rl_prime_earn_coupon);
        primeEarnContainer.f73554h = (TextView) this.f67460i.b(R.id.tv_prime_earn_rate);
        primeEarnContainer.f73555i = (TextView) this.f67460i.b(R.id.tv_prime_earn_apy_text);
        primeEarnContainer.f73556j = (TextView) this.f67460i.b(R.id.tv_prime_earn_deadline);
        primeEarnContainer.f73557k = (TextView) this.f67460i.b(R.id.tv_prime_earn_deadline_desc);
        primeEarnContainer.f73558l = (RelativeLayout) this.f67460i.b(R.id.rl_prime_earn_progress_bar);
        primeEarnContainer.f73559m = (ProgressBar) this.f67460i.b(R.id.pb_prime_earn_progress_bar);
        primeEarnContainer.f73560n = (TextView) this.f67460i.b(R.id.tv_prime_earn_total_position_desc);
        primeEarnContainer.f73561o = (TextView) this.f67460i.b(R.id.tv_prime_earn_sold_position);
    }

    public final void wl(boolean z11) {
        if (this.f73611p1 != z11) {
            this.f73611p1 = z11;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f73628u1 = ofFloat;
            ofFloat.addUpdateListener(new f(this));
            this.f73628u1.setDuration(300);
            this.f73628u1.start();
        }
    }

    public void x(LiveAppointmentData liveAppointmentData, boolean z11, int i11) {
        v9.a adapter = this.O0.getAdapter();
        if (liveAppointmentData != null && adapter != null && adapter.c() != null) {
            if (z11) {
                if (i11 < adapter.c().size()) {
                    LiveDetailBean d11 = ((IndexLiveItem) adapter.c().get(i11)).d();
                    if ((d11 instanceof LiveDetailBean) && d11.appointed == 0) {
                        d11.appointed = 1;
                        adapter.notifyItemChanged(i11);
                    }
                }
                if (liveAppointmentData.getLiveGroup() != null) {
                    LiveTrackUtils.e("APP_LIVE_notice_success", 1, Long.valueOf(liveAppointmentData.getLiveGroup().getId()), liveAppointmentData.getLiveGroup().getTitle(), liveAppointmentData.getLiveGroup().getGroupId(), 1);
                }
            } else if (i11 < adapter.c().size()) {
                LiveDetailBean d12 = ((IndexLiveItem) adapter.c().get(i11)).d();
                if ((d12 instanceof LiveDetailBean) && d12.appointed == 1) {
                    d12.appointed = 0;
                    adapter.notifyItemChanged(i11);
                }
            }
        }
    }

    public final void xk() {
        this.V = (LottieAnimationView) this.f67460i.b(R.id.lottie_quick_slide_guide);
        this.U = (ViewPager2) this.f67460i.b(R.id.view_pager_quick);
        yg.d dVar = new yg.d(this.W);
        this.Q1 = dVar;
        this.U.setAdapter(dVar);
        yk();
    }

    public final void xl() {
        String str;
        long j11 = R2 - 1;
        R2 = j11;
        if (j11 < 0) {
            hm();
            this.f73627u0.f73531e.f73551e.setVisibility(8);
        } else if (isAdded()) {
            String H3 = DateTimeUtils.H(R2);
            if (this.K2 == 0) {
                str = com.blankj.utilcode.util.x.c(R.string.n_home_index_earn_will_start, H3);
            } else {
                str = com.blankj.utilcode.util.x.b(R.string.n_exchange_call_auction_end_of_distance) + " " + H3;
            }
            this.f73627u0.f73531e.f73551e.setText(str);
        }
    }

    public void y0(boolean z11) {
        this.J.b(DateTimeUtils.h(DateTimeUtils.v(), "MM-dd HH:mm:ss"));
        if (z11) {
            this.I.finishRefresh();
            this.I.setNoMoreData(false);
            return;
        }
        this.I.w();
    }

    public void y4(boolean z11, List<HomePageNoticeData.Notice> list) {
        if (isAdded()) {
            if (!z11 || list == null || list.isEmpty()) {
                ViewUtil.m(this.E1, false);
                return;
            }
            ViewUtil.m(this.E1, true);
            ArrayList arrayList = new ArrayList();
            for (HomePageNoticeData.Notice next : list) {
                TopScrollData topScrollData = new TopScrollData();
                topScrollData.f71623a = next.getTitle();
                topScrollData.f71625c = next.getAbsolute_url();
                topScrollData.f71627e = next.getTag();
                topScrollData.f71628f = next.getProcla_id();
                arrayList.add(topScrollData);
            }
            this.A.setEllipsize(TextUtils.TruncateAt.END);
            this.A.setDatas(arrayList);
            this.A.b();
        }
    }

    public void y6(boolean z11) {
    }

    public final void yk() {
        this.Y = getResources().getColor(R.color.baseColorPrimarySeparator);
        this.Z = getResources().getColor(R.color.baseColorThreeLevelText);
        HBIndicatorView hBIndicatorView = (HBIndicatorView) this.f67460i.b(R.id.view_pager_indicator);
        this.X = hBIndicatorView;
        hBIndicatorView.k(this.Y, this.Z);
        this.X.n(getResources().getDimension(R.dimen.dp_5), getResources().getDimension(R.dimen.dp_10));
        this.X.m(getResources().getDimension(R.dimen.dp_3));
        this.X.l(getResources().getDimension(R.dimen.dp_2));
        this.X.j(3);
        this.X.i(2);
        this.X.setOrientation(0);
    }

    public final void yl() {
        long j11 = T2 - 1;
        T2 = j11;
        if (j11 < 0) {
            im();
            this.f73631v0.findViewById(R.id.tv_invest_countdown).setVisibility(8);
        } else if (isAdded()) {
            String H3 = DateTimeUtils.H(T2);
            ((TextView) this.f73631v0.findViewById(R.id.tv_invest_countdown)).setText(S2.tradingToEarn.showScheduleText + " " + H3);
        }
    }

    public final void zk() {
        this.I0 = new am.a(getChildFragmentManager());
        this.D0.addOnPageChangeListener(new l());
        this.D0.resetHeight(0);
        Bd(false);
    }

    public final void zl() {
        if (TextUtils.isEmpty(this.f73576e2)) {
            f6.c.a().e(this.f73581g1, this.f73579f2);
        } else {
            f6.c.a().e(this.f73581g1, this.f73576e2);
        }
        IndexUserGuideView indexUserGuideView = this.f73593k1;
        if (indexUserGuideView == null || indexUserGuideView.getVisibility() != 0) {
            int i11 = this.G1;
            int a11 = PixelUtils.a(80.0f);
            int i12 = R.drawable.closepath_function_special;
            if (i11 >= a11 || this.L.getVisibility() != 0) {
                ImageView imageView = this.f73584h1;
                if (!this.O) {
                    i12 = R.drawable.closepath_function_special_black;
                }
                imageView.setBackgroundResource(i12);
            } else {
                this.f73584h1.setBackgroundResource(R.drawable.closepath_function_special);
            }
        } else {
            f6.c.a().e(this.f73581g1, this.O ? this.f73585h2 : this.f73582g2);
        }
        this.N1 = false;
        this.O1 = false;
    }
}
