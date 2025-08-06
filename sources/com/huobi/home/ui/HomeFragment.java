package com.huobi.home.ui;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.fastjson.JSONObject;
import com.business.common.red_packet.RedPacketManager;
import com.business.common.red_packet.RedPacketResult;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.crypt.MD5Utils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.TokenBindInfo;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.pro.socket.bean.SymbolPriceV2;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListenerV2;
import com.hbg.lib.network.pro.socket.response.MarketOverviewV2Response;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.ui.fragment.NewsChildFragment;
import com.hbg.module.libkt.custom.indicator.CoIndicator;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.hbg.module.livesquare.ui.LiveSquareHomeFragment;
import com.huobi.account.event.LogOutEvent;
import com.huobi.account.ui.VerificationStartActivity;
import com.huobi.finance.api.RiskService;
import com.huobi.finance.bean.TsvMsg;
import com.huobi.home.data.HomepageConfig;
import com.huobi.home.data.TransferAmountInfo;
import com.huobi.home.engine.HomeBridgeAbility;
import com.huobi.home.engine.HomeEngineCore;
import com.huobi.home.presenter.HomePresenter;
import com.huobi.index.trace.IndexLifeCycleStep;
import com.huobi.index.trace.IndexLifeCycleTracer;
import com.huobi.index.ui.FeedFragment;
import com.huobi.index.ui.ScanLoginSuccessActivity;
import com.huobi.main.bean.RemoteSkinBean;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.utils.t0;
import com.huobi.view.MyNestedScrollView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.tencent.android.tpush.stat.ServiceStat;
import com.twitter.sdk.android.core.identity.AuthHandler;
import d10.l;
import i6.i;
import i8.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import ky.j;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import tq.p;

public final class HomeFragment extends BaseHomeFragment<HomePresenter, HomePresenter.b> implements HomePresenter.b, EasyPermissions.PermissionCallbacks {
    public rj.b A;
    public HomepageConfig B;
    public TransferAmountInfo C;
    public ViewGroup D;
    public boolean E;
    public ViewGroup F;
    public CheckBox G;
    public CheckBox H;
    public CheckBox I;
    public ValueAnimator J;
    public boolean K;
    public boolean L;
    public long M = -1;
    public int N = -1;
    public ArrayList<TabData> O;
    public final Runnable P = new g(this);
    public int Q;
    public int R;
    public int S;

    /* renamed from: l  reason: collision with root package name */
    public final String f72518l = "HomeFragment";

    /* renamed from: m  reason: collision with root package name */
    public FrameLayout f72519m;

    /* renamed from: n  reason: collision with root package name */
    public RelativeLayout f72520n;

    /* renamed from: o  reason: collision with root package name */
    public LinearLayout f72521o;

    /* renamed from: p  reason: collision with root package name */
    public SmartRefreshLayout f72522p;

    /* renamed from: q  reason: collision with root package name */
    public SmartRefreshHeader f72523q;

    /* renamed from: r  reason: collision with root package name */
    public MyNestedScrollView f72524r;

    /* renamed from: s  reason: collision with root package name */
    public CoordinatorLayout f72525s;

    /* renamed from: t  reason: collision with root package name */
    public AppBarLayout f72526t;

    /* renamed from: u  reason: collision with root package name */
    public LinearLayout f72527u;

    /* renamed from: v  reason: collision with root package name */
    public CoIndicator f72528v;

    /* renamed from: w  reason: collision with root package name */
    public ViewPager2 f72529w;

    /* renamed from: x  reason: collision with root package name */
    public LinearLayout f72530x;

    /* renamed from: y  reason: collision with root package name */
    public ArrayList<Fragment> f72531y;

    /* renamed from: z  reason: collision with root package name */
    public MarketOverviewListenerV2 f72532z;

    public static final class AuthTarget implements kn.a, Serializable {
        public static final a Companion = new a((r) null);
        private static final long serialVersionUID = 5620774165925992463L;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(r rVar) {
                this();
            }
        }

        public static final class b extends EasySubscriber<TokenBindInfo> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Context f72533b;

            public b(Context context) {
                this.f72533b = context;
            }

            /* renamed from: a */
            public void onNext(TokenBindInfo tokenBindInfo) {
                super.onNext(tokenBindInfo);
                ScanLoginSuccessActivity.ph(this.f72533b, tokenBindInfo);
            }

            public void onError2(Throwable th2) {
                super.onError2(th2);
            }

            public void onFailed(APIStatusErrorException aPIStatusErrorException) {
                super.onFailed(aPIStatusErrorException);
            }

            public void onStart() {
                super.onStart();
            }
        }

        /* access modifiers changed from: private */
        public static final Observable show$lambda$0(l lVar, Object obj) {
            return (Observable) lVar.invoke(obj);
        }

        public boolean allowTrader() {
            return false;
        }

        public void show(Context context) {
            Log.d("Home", "---------show--------");
            yl.r.b().flatMap(new h(HomeFragment$AuthTarget$show$1.INSTANCE)).compose(RxJavaHelper.t((u6.g) null)).subscribe(new b(context));
        }
    }

    public static final class a implements ne.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomeFragment f72534a;

        public a(HomeFragment homeFragment) {
            this.f72534a = homeFragment;
        }

        public void a(int i11) {
            if (this.f72534a.N != -1 && this.f72534a.N == i11) {
                this.f72534a.Q7(0);
            }
            this.f72534a.N = i11;
        }
    }

    public static final class b implements CoIndicator.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HomeFragment f72535a;

        public b(HomeFragment homeFragment) {
            this.f72535a = homeFragment;
        }

        public void onSelected(int i11) {
            ArrayList<TabData> Zh = this.f72535a.Zh();
            TabData tabData = Zh != null ? Zh.get(i11) : null;
            boolean z11 = true;
            if (tabData != null && tabData.getType() == 0) {
                gs.g.i("app_community_homepage_find_tab", new HashMap());
                return;
            }
            if (tabData != null && 2 == tabData.getType()) {
                gs.g.g("app_community_kxtab_click", new HashMap());
                return;
            }
            if (tabData == null || 3 != tabData.getType()) {
                z11 = false;
            }
            if (z11) {
                gs.g.f("APP_LIVE_quotation_tabshow");
            }
        }
    }

    public static final class c extends SimpleMultiPurposeListener {
    }

    public static final class d extends MarketOverviewListenerV2 {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HomeFragment f72536d;

        public d(HomeFragment homeFragment) {
            this.f72536d = homeFragment;
        }

        /* renamed from: j */
        public void f(MarketOverviewV2Response marketOverviewV2Response) {
            if (marketOverviewV2Response.getData() != null) {
                Log.d("Home", "------------MarketOverviewListenerV2---------------");
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : ((Map) marketOverviewV2Response.getData()).entrySet()) {
                    String str = (String) entry.getKey();
                    SymbolPriceV2 symbolPriceV2 = (SymbolPriceV2) entry.getValue();
                    if (symbolPriceV2 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("decimalcPrice", symbolPriceV2.getClose());
                        jSONObject2.put("decimalDelta", Double.valueOf(symbolPriceV2.getRise().doubleValue() * ((double) 100)));
                        jSONObject2.put("strAmount", symbolPriceV2.getAmount());
                        jSONObject2.put("symbol", symbolPriceV2.getSymbol());
                        jSONObject.put(str, jSONObject2);
                    }
                }
                com.huobi.home.engine.c.f72480a.f(this.f72536d.A, PrimeRounds.ROUND_TRADE_MARKET_TYPE, jSONObject);
            }
        }
    }

    public static final class e extends EasySubscriber<TsvMsg> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomeFragment f72537b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f72538c;

        public e(HomeFragment homeFragment, String str) {
            this.f72537b = homeFragment;
            this.f72538c = str;
        }

        public static final void c(HomeFragment homeFragment, String str, TsvMsg tsvMsg) {
            VerificationStartActivity.fg(homeFragment.getActivity(), str, tsvMsg.tsvMsg);
        }

        /* renamed from: b */
        public void onNext(TsvMsg tsvMsg) {
            super.onNext(tsvMsg);
            i.b().g(new i(this.f72537b, this.f72538c, tsvMsg), 20);
        }

        public void onAfter() {
            super.onAfter();
            HomeFragment.super.dismissProgressDialog();
        }

        public void onStart() {
            super.onStart();
            HomeFragment.super.showProgressDialog();
        }
    }

    public static final class f implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f72539b;

        public f(l lVar) {
            this.f72539b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final kotlin.f<?> getFunctionDelegate() {
            return this.f72539b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f72539b.invoke(obj);
        }
    }

    public static final class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomeFragment f72540b;

        public g(HomeFragment homeFragment) {
            this.f72540b = homeFragment;
        }

        public void run() {
            if (System.currentTimeMillis() - this.f72540b.M > 100) {
                this.f72540b.M = -1;
                this.f72540b.L = false;
                return;
            }
            i.b().g(this, 100);
        }
    }

    public static final class h implements ny.d {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomeFragment f72541b;

        public h(HomeFragment homeFragment) {
            this.f72541b = homeFragment;
        }

        public void P8(j jVar) {
            i6.d.i("home -----加载更多....");
            this.f72541b.Q7(2);
        }

        public void bf(j jVar) {
            this.f72541b.ri();
            if (this.f72541b.zh().isCanBeSeen()) {
                ((HomePresenter) this.f72541b.yh()).s0();
                this.f72541b.Q7(0);
                return;
            }
            this.f72541b.y0(true);
        }
    }

    public static final void ci(HomeFragment homeFragment) {
        MyNestedScrollView myNestedScrollView = homeFragment.f72524r;
        if ((myNestedScrollView != null ? myNestedScrollView.getHeight() : 0) > 0) {
            homeFragment.Q = homeFragment.f72524r.getHeight();
        }
    }

    public static final void di(HomeFragment homeFragment, AppBarLayout appBarLayout, int i11) {
        int abs = Math.abs(i11);
        homeFragment.R = abs;
        if (homeFragment.Q - abs < 10) {
            homeFragment.mi(true);
        } else {
            homeFragment.mi(false);
        }
        if (homeFragment.S == 0) {
            ViewPager2 viewPager2 = homeFragment.f72529w;
            homeFragment.S = viewPager2 != null ? viewPager2.getHeight() : 0;
        }
        if (homeFragment.S == 0) {
            ViewPager2 viewPager22 = homeFragment.f72529w;
            homeFragment.S = viewPager22 != null ? viewPager22.getHeight() : 0;
        }
        if (homeFragment.Q != 0) {
            ArrayList<Fragment> arrayList = homeFragment.f72531y;
            FeedFragment feedFragment = null;
            androidx.activity.result.a aVar = arrayList != null ? (Fragment) CollectionsKt___CollectionsKt.d0(arrayList, 0) : null;
            if (aVar instanceof FeedFragment) {
                feedFragment = (FeedFragment) aVar;
            }
            if (feedFragment == null) {
                return;
            }
            if (homeFragment.Q + i11 == 0) {
                feedFragment.Rh(true);
            } else {
                feedFragment.Rh(false);
            }
        }
    }

    public static final void gi(HomeFragment homeFragment, com.hbg.module.huobi.im.RedPoint.a aVar) {
        com.huobi.home.engine.c.f72480a.i(homeFragment.A, aVar.b());
    }

    public static final void hi(HomeFragment homeFragment) {
        homeFragment.Q7(0);
    }

    public static final boolean ki(HomeFragment homeFragment, View view, MotionEvent motionEvent) {
        if (!homeFragment.L) {
            int i11 = homeFragment.R;
            MyNestedScrollView myNestedScrollView = homeFragment.f72524r;
            if (i11 >= (myNestedScrollView != null ? myNestedScrollView.getHeight() : 1)) {
                homeFragment.ti();
                AppBarLayout appBarLayout = homeFragment.f72526t;
                CoordinatorLayout.Behavior behavior = null;
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) (appBarLayout != null ? appBarLayout.getLayoutParams() : null);
                if (layoutParams != null) {
                    behavior = layoutParams.f();
                }
                AppBarLayout.Behavior behavior2 = (AppBarLayout.Behavior) behavior;
                if (behavior2 != null) {
                    behavior2.setTopAndBottomOffset(0);
                }
                AppBarLayout appBarLayout2 = homeFragment.f72526t;
                if (appBarLayout2 != null) {
                    appBarLayout2.setExpanded(true, true);
                }
                i.b().g(new f(homeFragment), 300);
            }
        }
        return false;
    }

    public static final void li(HomeFragment homeFragment) {
        homeFragment.Q7(0);
    }

    public static final void ni(HomeFragment homeFragment, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        float f11 = 1.0f - floatValue;
        CheckBox checkBox = homeFragment.H;
        if (checkBox != null) {
            checkBox.setAlpha(homeFragment.E ? floatValue : f11);
        }
        CheckBox checkBox2 = homeFragment.G;
        if (checkBox2 != null) {
            checkBox2.setAlpha(homeFragment.E ? f11 : floatValue);
        }
        CheckBox checkBox3 = homeFragment.G;
        if (checkBox3 != null) {
            checkBox3.setScaleX(homeFragment.E ? f11 : floatValue);
        }
        CheckBox checkBox4 = homeFragment.G;
        if (checkBox4 != null) {
            checkBox4.setScaleY(homeFragment.E ? f11 : floatValue);
        }
        CheckBox checkBox5 = homeFragment.I;
        if (checkBox5 != null) {
            checkBox5.setAlpha(homeFragment.E ? floatValue : f11);
        }
        CheckBox checkBox6 = homeFragment.I;
        if (checkBox6 != null) {
            if (homeFragment.E) {
                floatValue = f11;
            }
            checkBox6.setTranslationY(floatValue * ((float) (checkBox6 != null ? checkBox6.getHeight() : 1)));
        }
    }

    public void Ah() {
        pi();
        oi();
        bi();
    }

    public void Ch(int i11) {
        super.Ch(i11);
        ti();
    }

    public void Dh(int i11) {
        super.Dh(i11);
        ti();
    }

    public void Kd() {
        if (getContext() == null) {
            return;
        }
        if (!(getContext() instanceof FragmentActivity) || !((FragmentActivity) getContext()).isFinishing()) {
            HomeEngineCore.f72473a.d(this.A, (FragmentActivity) getContext());
        }
    }

    public void P5() {
        com.huobi.home.engine.c.f72480a.g(this.A);
    }

    public void Q7(int i11) {
        Fragment fragment;
        ArrayList<Fragment> arrayList = this.f72531y;
        if (arrayList != null) {
            ViewPager2 viewPager2 = this.f72529w;
            fragment = arrayList.get(viewPager2 != null ? viewPager2.getCurrentItem() : 0);
        } else {
            fragment = null;
        }
        if (fragment != null) {
            if (fragment instanceof FeedFragment) {
                ((FeedFragment) fragment).ai(i11);
                return;
            } else if (fragment instanceof NewsChildFragment) {
                if (i11 == 0) {
                    ((NewsChildFragment) fragment).bf((j) null);
                }
            } else if ((fragment instanceof LiveSquareHomeFragment) && i11 == 0) {
                ((LiveSquareHomeFragment) fragment).Xh();
            }
        }
        ti();
    }

    public final void Uh() {
    }

    public final void Vh() {
        if (zh().isCanBeSeen()) {
            ui();
        } else {
            wi();
        }
    }

    public final boolean Wh(Uri uri) {
        String queryParameter = uri.getQueryParameter(AuthHandler.EXTRA_TOKEN_SECRET);
        String queryParameter2 = uri.getQueryParameter("sign");
        String b11 = MD5Utils.b((queryParameter + ServiceStat.VERIFY_EVENT_ID).getBytes(kotlin.text.b.f56908b));
        if (queryParameter2 == null || !StringsKt__StringsJVMKt.w(queryParameter2, b11, true)) {
            return false;
        }
        return true;
    }

    /* renamed from: Xh */
    public HomePresenter xh() {
        return new HomePresenter();
    }

    public final int Yh() {
        SP.s("key_home_page_layout_type", "A");
        return R.layout.fragment_home;
    }

    public final ArrayList<TabData> Zh() {
        return this.O;
    }

    public void afterInit() {
    }

    /* renamed from: ai */
    public HomePresenter.b zh() {
        return this;
    }

    public final void bi() {
        ViewTreeObserver viewTreeObserver;
        MyNestedScrollView myNestedScrollView = this.f72524r;
        if (!(myNestedScrollView == null || (viewTreeObserver = myNestedScrollView.getViewTreeObserver()) == null)) {
            viewTreeObserver.addOnGlobalLayoutListener(new c(this));
        }
        AppBarLayout appBarLayout = this.f72526t;
        if (appBarLayout != null) {
            appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new d(this));
        }
    }

    public final void ei() {
        rj.b bVar = new rj.b(getContext(), "home");
        this.A = bVar;
        bVar.t("homeBridge", HomeBridgeAbility.class);
        rj.b bVar2 = this.A;
        if (bVar2 != null) {
            bVar2.H();
        }
        rj.b bVar3 = this.A;
        if (bVar3 != null) {
            bVar3.I("initEngine()");
        }
        ri();
    }

    public final void fi() {
        com.hbg.module.huobi.im.RedPoint.b.a().f(new e(this));
    }

    public final void ii(Activity activity) {
        if (PhoneUtils.w()) {
            String[] strArr = {"android.permission.ACCESS_FINE_LOCATION"};
            if (EasyPermissions.hasPermissions(getContext(), (String[]) Arrays.copyOf(strArr, 1))) {
                PhoneUtils.u(activity);
                PhoneUtils.j(activity);
                PhoneUtils.n(activity);
                return;
            }
            EasyPermissions.requestPermissions(this, 128, (String[]) Arrays.copyOf(strArr, 1));
            return;
        }
        PhoneUtils.u(activity);
        PhoneUtils.j(activity);
        PhoneUtils.n(activity);
    }

    public final void initViewPager() {
        this.f72528v = (CoIndicator) this.f67460i.b(R.id.coIndicator);
        this.f72530x = (LinearLayout) this.f67460i.b(R.id.home_feed_linear_tabLayout);
        this.f72529w = (ViewPager2) this.f67460i.b(R.id.home_viewPager);
        FeedFragment.a aVar = FeedFragment.H;
        this.f72531y = CollectionsKt__CollectionsKt.g(aVar.a(1), aVar.a(4), NewsChildFragment.a.b(NewsChildFragment.H, -100, "7*24", (String) null, 0, 12, (Object) null), LiveSquareHomeFragment.Wh(-100, ""));
        this.O = CollectionsKt__CollectionsKt.g(new TabData(getResources().getString(R.string.n_content_found), 0, 0), new TabData(getResources().getString(R.string.n_content_communityList_attention), 1, 1), new TabData(getResources().getString(R.string.n_content_newsflash), 2, 2), new TabData(getResources().getString(R.string.n_live), 3, 3));
        he.a aVar2 = new he.a((Fragment) this);
        aVar2.a(this.f72531y);
        ViewPager2 viewPager2 = this.f72529w;
        if (viewPager2 != null) {
            viewPager2.setAdapter(aVar2);
        }
        ViewPager2 viewPager22 = this.f72529w;
        if (viewPager22 != null) {
            viewPager22.setOffscreenPageLimit(this.O.size());
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ne.b.h(activity, this.O, this.f72528v, this.f72529w, 14.0f, R.color.baseColorPrimaryText, R.color.baseColorSecondaryTextNew, Float.valueOf(20.0f), (Integer) null, (Integer) null, true, new a(this), 768, (Object) null);
            CoIndicator coIndicator = this.f72528v;
            if (coIndicator != null) {
                coIndicator.setListener(new b(this));
            }
        }
        we.b.l("home_feed_refresh", Integer.TYPE).observe(this, new f(new HomeFragment$initViewPager$2(this)));
        CoIndicator coIndicator2 = this.f72528v;
        if (coIndicator2 != null) {
            coIndicator2.post(new g(this));
        }
        Uh();
    }

    @SuppressLint({"RestrictedApi"})
    public void initViews() {
        RemoteSkinBean.RemoteTabBarBean tabbar;
        RemoteSkinBean.RemoteTabBarBean.TabBarBean tabBarBean;
        this.f72519m = (FrameLayout) this.f67460i.b(R.id.webview_pool_container);
        this.f72520n = (RelativeLayout) this.f67460i.b(R.id.navigation_container);
        this.f72521o = (LinearLayout) this.f67460i.b(R.id.home_navigation_ll);
        View b11 = this.f67460i.b(R.id.home_status_bar);
        ViewGroup.LayoutParams layoutParams = b11.getLayoutParams();
        layoutParams.height = BaseActivity.getStatusBarHeight(b11.getContext());
        b11.setLayoutParams(layoutParams);
        this.f72522p = (SmartRefreshLayout) this.f67460i.b(R.id.fluent_refresh_layout);
        this.f72525s = (CoordinatorLayout) this.f67460i.b(R.id.clLayout);
        this.f72526t = (AppBarLayout) this.f67460i.b(R.id.appBarLayout);
        this.f72524r = (MyNestedScrollView) this.f67460i.b(R.id.fluent_content_nsv);
        this.f72527u = (LinearLayout) this.f67460i.b(R.id.fluent_container);
        this.D = (ViewGroup) this.f67460i.b(R.id.rl_new_hand_area_animation_layer);
        ei();
        initViewPager();
        ii(getActivity());
        si();
        SmartRefreshLayout smartRefreshLayout = this.f72522p;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.c0(new c());
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.main_home_tab);
            this.F = viewGroup;
            if (viewGroup != null) {
                this.G = (CheckBox) viewGroup.findViewById(R.id.main_index_cb);
                this.H = (CheckBox) viewGroup.findViewById(R.id.main_index_cb_bg);
                this.I = (CheckBox) viewGroup.findViewById(R.id.main_index_cb_icon);
                RemoteSkinBean d11 = com.huobi.main.helper.a.c().d(activity);
                boolean g11 = NightHelper.e().g();
                if (!(d11 == null || (tabbar = d11.getTabbar()) == null)) {
                    if (g11) {
                        tabBarBean = tabbar.getNight();
                    } else {
                        tabBarBean = tabbar.getLight();
                    }
                    if (tabBarBean != null) {
                        String icon = tabBarBean.getHome().getIcon();
                        String rocket_icon = tabBarBean.getRocket().getRocket_icon();
                        String rocket_bg = tabBarBean.getRocket().getRocket_bg();
                        CheckBox checkBox = this.H;
                        if (checkBox != null) {
                            checkBox.setButtonDrawable(com.huobi.main.helper.a.c().b(R.drawable.tab_bg_feed_top_bg, rocket_bg, icon));
                        }
                        CheckBox checkBox2 = this.I;
                        if (checkBox2 != null) {
                            checkBox2.setButtonDrawable(com.huobi.main.helper.a.c().b(R.drawable.tab_bg_feed_top_icon, rocket_icon, icon));
                        }
                    }
                }
            }
        }
        ah.a.c().d();
    }

    public final boolean ji() {
        return this.L;
    }

    public final void mi(boolean z11) {
        if (this.E != z11) {
            this.E = z11;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.J = ofFloat;
            if (ofFloat != null) {
                ofFloat.addUpdateListener(new a(this));
            }
            ValueAnimator valueAnimator = this.J;
            if (valueAnimator != null) {
                valueAnimator.setDuration(300);
            }
            ValueAnimator valueAnimator2 = this.J;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
        }
    }

    public void nh(HomepageConfig homepageConfig, TransferAmountInfo transferAmountInfo) {
        if (getContext() == null) {
            return;
        }
        if (!(getContext() instanceof FragmentActivity) || !((FragmentActivity) getContext()).isFinishing()) {
            this.C = transferAmountInfo;
            if (this.B == null) {
                this.B = homepageConfig;
                LinearLayout linearLayout = this.f72527u;
                if (linearLayout != null) {
                    linearLayout.removeAllViews();
                }
                LinearLayout linearLayout2 = this.f72521o;
                if (linearLayout2 != null) {
                    linearLayout2.removeAllViews();
                }
                HomeEngineCore.f72473a.g(this.A, (FragmentActivity) getContext(), this.f72521o, this.f72527u, homepageConfig, transferAmountInfo);
                return;
            }
            this.B = homepageConfig;
            HomeEngineCore.f72473a.e(this.A, (FragmentActivity) getContext(), this.f72521o, this.f72527u, homepageConfig, transferAmountInfo);
            SmartRefreshLayout smartRefreshLayout = this.f72522p;
            if (smartRefreshLayout != null) {
                smartRefreshLayout.finishRefresh();
            }
        }
    }

    public final void oi() {
        Class cls = Integer.TYPE;
        we.b.l("home_feed_refresh", cls).observe(this, new f(new HomeFragment$registLogin$1(this)));
        we.b.l("home_tab_change", cls).observe(this, new f(new HomeFragment$registLogin$2(this)));
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 1001) {
            String stringExtra = intent != null ? intent.getStringExtra("result_string") : null;
            i6.d.i("onActivityResult resultString=" + stringExtra);
            if (t0.c(stringExtra)) {
                rn.c.i().d(getActivity(), new AuthTarget());
            } else if (t0.b(stringExtra)) {
                Uri parse = Uri.parse(stringExtra);
                String queryParameter = parse.getQueryParameter("tsvToken");
                i6.d.j("QR-SCAN", "tsvToken=" + queryParameter);
                if (!Wh(parse)) {
                    i6.d.e("QR-SCAN", "checkSign Failed.");
                    HuobiToastUtil.j(R.string.n_qr_scan_not_available);
                } else if (queryParameter != null) {
                    qi(queryParameter);
                } else {
                    qi("");
                }
            } else if (t0.d(stringExtra)) {
                try {
                    RedPacketResult b11 = RedPacketManager.b(stringExtra);
                    if (b11.isRedPacket()) {
                        String codeWord = b11.getCodeWord();
                        FragmentActivity activity = getActivity();
                        if (activity != null) {
                            BaseModuleConfig.a().v(activity, codeWord);
                            return;
                        }
                        return;
                    }
                    zn.a.d().v(Uri.parse(stringExtra)).a().c();
                } catch (Exception e11) {
                    e11.printStackTrace();
                    HuobiToastUtil.j(R.string.n_qr_scan_not_available);
                }
            } else if (TextUtils.isEmpty(stringExtra) || !StringsKt__StringsJVMKt.M(stringExtra, ImageSource.ASSET_SCHEME, false, 2, (Object) null)) {
                HuobiToastUtil.j(R.string.n_qr_scan_not_available);
            } else {
                HBBaseWebActivity.showWebView(getActivity(), stringExtra, (String) null, (String) null, false);
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        ((HomePresenter) yh()).s0();
        ((HomePresenter) yh()).I0();
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
        rj.b bVar = this.A;
        if (bVar != null) {
            bVar.B();
            this.A = null;
        }
        vi();
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public final void onEvent(LogOutEvent logOutEvent) {
        this.K = false;
        if (getContext() == null) {
            return;
        }
        if (!(getContext() instanceof FragmentActivity) || !((FragmentActivity) getContext()).isFinishing()) {
            com.huobi.home.engine.c.f72480a.b(this.A);
            ((HomePresenter) yh()).w0();
            HomeEngineCore.f72473a.d(this.A, (FragmentActivity) getContext());
        }
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

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public final void onProTokenUpdate(ProTokenUpdate proTokenUpdate) {
        String str = proTokenUpdate.proToken;
        Log.e("Home", "onProTokenUpdate proToken:" + str + " getUI():" + zh());
        if (!TextUtils.isEmpty(str) && zh() != null) {
            ((HomePresenter) yh()).w0();
        }
        com.huobi.home.engine.c cVar = com.huobi.home.engine.c.f72480a;
        cVar.b(this.A);
        cVar.h(this.A);
        this.K = true;
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        EasyPermissions.onRequestPermissionsResult(i11, strArr, iArr, this);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int Yh = Yh();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
        IndexLifeCycleTracer.c().f(IndexLifeCycleStep.AppHomePage);
        return layoutInflater.inflate(Yh, viewGroup, false);
    }

    public final void pi() {
        if (this.f72532z == null) {
            this.f72532z = new d(this);
        }
        x8.a.a().t(true, this.f72532z);
    }

    public final void qi(String str) {
        i6.d.j("QR-SCAN", "requestTsvMsg");
        HashMap hashMap = new HashMap();
        hashMap.put("tsvToken", str);
        hashMap.put("uid", tg.r.x().s());
        hashMap.put("lang", AppLanguageHelper.getInstance().getCurLanguageHeader());
        ((RiskService) p.Y(RiskService.class)).getTsvMsg(hashMap).compose(p.Z()).compose(RxJavaHelper.t(zh())).subscribe(new e(this, str));
    }

    public final void ri() {
        com.huobi.home.engine.c cVar = com.huobi.home.engine.c.f72480a;
        cVar.g(this.A);
        cVar.b(this.A);
        cVar.a(this.A);
        cVar.e(this.A);
    }

    public final void si() {
        SmartRefreshLayout smartRefreshLayout = this.f72522p;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.i(true);
        }
        SmartRefreshLayout smartRefreshLayout2 = this.f72522p;
        if (smartRefreshLayout2 != null) {
            smartRefreshLayout2.g(true);
        }
        SmartRefreshLayout smartRefreshLayout3 = this.f72522p;
        if (smartRefreshLayout3 != null) {
            smartRefreshLayout3.V(false);
        }
        SmartRefreshLayout smartRefreshLayout4 = this.f72522p;
        if (smartRefreshLayout4 != null) {
            smartRefreshLayout4.h0(new SmartRefreshFooter(getActivity()));
        }
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(getActivity());
        this.f72523q = smartRefreshHeader;
        SmartRefreshLayout smartRefreshLayout5 = this.f72522p;
        if (smartRefreshLayout5 != null) {
            smartRefreshLayout5.j0(smartRefreshHeader);
        }
        SmartRefreshLayout smartRefreshLayout6 = this.f72522p;
        if (smartRefreshLayout6 != null) {
            smartRefreshLayout6.e0(new h(this));
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void th(boolean z11) {
        super.th(z11);
        if (z11) {
            com.huobi.home.engine.c cVar = com.huobi.home.engine.c.f72480a;
            cVar.a(this.A);
            cVar.e(this.A);
            cVar.c(this.A);
            ViewGroup viewGroup = this.F;
            if (viewGroup != null) {
                viewGroup.setOnTouchListener(new b(this));
            }
            fi();
            pi();
            return;
        }
        com.huobi.home.engine.c.f72480a.d(this.A);
        ViewGroup viewGroup2 = this.F;
        if (viewGroup2 != null) {
            viewGroup2.setOnTouchListener((View.OnTouchListener) null);
        }
        vi();
    }

    public final void ti() {
        SmartRefreshLayout smartRefreshLayout = this.f72522p;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.w();
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        Vh();
    }

    public final void ui() {
        i6.d.j("FutureRank", "subscribeFutureMarketWebSocket");
        o6.b.g().i();
        m9.r.g().i();
        k.g().i();
    }

    public final void vi() {
        if (this.f72532z != null) {
            x8.a.a().t(false, this.f72532z);
        }
    }

    public final void wi() {
        i6.d.j("FutureRank", "unsubscribeFutureMarketWebSocket");
        o6.b.g().m();
        m9.r.g().m();
        k.g().m();
    }

    public final void y0(boolean z11) {
        this.f72523q.b(DateTimeUtils.h(DateTimeUtils.v(), "MM-dd HH:mm:ss"));
        if (z11) {
            SmartRefreshLayout smartRefreshLayout = this.f72522p;
            if (smartRefreshLayout != null) {
                smartRefreshLayout.finishRefresh();
            }
            SmartRefreshLayout smartRefreshLayout2 = this.f72522p;
            if (smartRefreshLayout2 != null) {
                smartRefreshLayout2.setNoMoreData(false);
                return;
            }
            return;
        }
        SmartRefreshLayout smartRefreshLayout3 = this.f72522p;
        if (smartRefreshLayout3 != null) {
            smartRefreshLayout3.w();
        }
    }
}
