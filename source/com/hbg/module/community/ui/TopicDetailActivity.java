package com.hbg.module.community.ui;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.GridLayoutManager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.CommunityUserPermissions;
import com.hbg.lib.network.hbg.core.bean.TopicDetailInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.module.community.adapter.TopicNewsItemBinder;
import com.hbg.module.community.adapter.u;
import com.hbg.module.community.adapter.v;
import com.hbg.module.community.multiadapter.MultiTypeAdapter;
import com.hbg.module.community.multiadapter.g;
import com.hbg.module.community.viewmodel.CommunityViewModel;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.huobi.utils.StatusBarUtils;
import com.huochat.community.base.CommunityConstants;
import com.huochat.community.util.NBStatusBarUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.l;
import lc.y;
import rd.s;
import sl.f0;

@Route(path = "/content/topicDetail")
public final class TopicDetailActivity extends BaseActivity<y> implements AppBarLayout.OnOffsetChangedListener, TabLayout.OnTabSelectedListener, f0.b {

    /* renamed from: z  reason: collision with root package name */
    public static final a f17508z = new a((r) null);

    /* renamed from: i  reason: collision with root package name */
    public int f17509i = R$color.personal_center_header_bg;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<Fragment> f17510j;

    /* renamed from: k  reason: collision with root package name */
    public AppCompatImageView f17511k;

    /* renamed from: l  reason: collision with root package name */
    public AppCompatImageView f17512l;

    /* renamed from: m  reason: collision with root package name */
    public AppCompatTextView f17513m;

    /* renamed from: n  reason: collision with root package name */
    public ActionBar f17514n;

    /* renamed from: o  reason: collision with root package name */
    public TopicDetailInfo f17515o = new TopicDetailInfo();

    /* renamed from: p  reason: collision with root package name */
    public int f17516p = -1;

    /* renamed from: q  reason: collision with root package name */
    public boolean f17517q = true;

    /* renamed from: r  reason: collision with root package name */
    public int f17518r;

    /* renamed from: s  reason: collision with root package name */
    public final MultiTypeAdapter f17519s = new MultiTypeAdapter((List) null, 0, (g) null, 7, (r) null);

    /* renamed from: t  reason: collision with root package name */
    public final u f17520t = new u(new ArrayList());

    /* renamed from: u  reason: collision with root package name */
    public CommunityViewModel f17521u;

    /* renamed from: v  reason: collision with root package name */
    public GridLayoutManager f17522v;

    /* renamed from: w  reason: collision with root package name */
    public me.a f17523w;

    /* renamed from: x  reason: collision with root package name */
    public Boolean f17524x = Boolean.FALSE;

    /* renamed from: y  reason: collision with root package name */
    public boolean f17525y = true;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b implements TabLayout.OnTabSelectedListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TopicDetailActivity f17526b;

        public b(TopicDetailActivity topicDetailActivity) {
            this.f17526b = topicDetailActivity;
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        @SensorsDataInstrumented
        public void onTabSelected(TabLayout.Tab tab) {
            try {
                View customView = tab.getCustomView();
                if (customView != null) {
                    TopicDetailActivity topicDetailActivity = this.f17526b;
                    TextView textView = (TextView) customView.findViewById(R$id.tvTabTitle);
                    textView.setTextColor(topicDetailActivity.getResources().getColor(R$color.baseColorPrimaryText));
                    textView.setTextSize(2, 20.0f);
                }
                CollapsingToolbarLayout collapsingToolbarLayout = TopicDetailActivity.yh(this.f17526b).f19328b0;
                TopicDetailActivity topicDetailActivity2 = this.f17526b;
                collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(topicDetailActivity2, topicDetailActivity2.f17509i));
                this.f17526b.f17518r = tab.getPosition();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            try {
                View customView = tab.getCustomView();
                if (customView != null) {
                    TopicDetailActivity topicDetailActivity = this.f17526b;
                    TextView textView = (TextView) customView.findViewById(R$id.tvTabTitle);
                    textView.setTextColor(topicDetailActivity.getResources().getColor(R$color.baseColorSecondaryTextNew));
                    textView.setTextSize(2, 14.0f);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17527b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17528c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TopicDetailActivity f17529d;

        public c(View view, long j11, TopicDetailActivity topicDetailActivity) {
            this.f17527b = view;
            this.f17528c = j11;
            this.f17529d = topicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17527b) > this.f17528c || (this.f17527b instanceof Checkable)) {
                sVar.e(this.f17527b, currentTimeMillis);
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f17527b;
                this.f17529d.finish();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17530b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17531c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TopicDetailActivity f17532d;

        public d(View view, long j11, TopicDetailActivity topicDetailActivity) {
            this.f17530b = view;
            this.f17531c = j11;
            this.f17532d = topicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17530b) > this.f17531c || (this.f17530b instanceof Checkable)) {
                sVar.e(this.f17530b, currentTimeMillis);
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.f17530b;
                TopicDetailActivity topicDetailActivity = this.f17532d;
                topicDetailActivity.ei(topicDetailActivity.f17516p);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17533b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17534c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TopicDetailActivity f17535d;

        public e(View view, long j11, TopicDetailActivity topicDetailActivity) {
            this.f17533b = view;
            this.f17534c = j11;
            this.f17535d = topicDetailActivity;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17533b) > this.f17534c || (this.f17533b instanceof Checkable)) {
                sVar.e(this.f17533b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f17533b;
                if (this.f17535d.fg() != null) {
                    HbgBaseProvider fg2 = this.f17535d.fg();
                    if (!(fg2 != null && !fg2.j(this.f17535d))) {
                        if (x.b(this.f17535d.f17524x, Boolean.TRUE)) {
                            gc.b.d(gc.b.f19131a, String.valueOf(this.f17535d.f17516p), this.f17535d.f17515o.getInfo(), (String) null, (String) null, 12, (Object) null);
                            nc.c.a("app_community_fbdj", MapsKt__MapsKt.j(l.a("pagename", "comunitytopic")));
                        } else {
                            gc.b.f();
                        }
                    }
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements z, kotlin.jvm.internal.u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d10.l f17536b;

        public f(d10.l lVar) {
            this.f17536b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof kotlin.jvm.internal.u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((kotlin.jvm.internal.u) obj).getFunctionDelegate());
        }

        public final kotlin.f<?> getFunctionDelegate() {
            return this.f17536b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f17536b.invoke(obj);
        }
    }

    public static final /* synthetic */ y yh(TopicDetailActivity topicDetailActivity) {
        return (y) topicDetailActivity.Yf();
    }

    public final void Mh() {
        sh();
        RequestExtKt.d(v7.b.a().getTopicDetailInfo(this.f17516p), new TopicDetailActivity$getTopicDetailInfo$1(this), new TopicDetailActivity$getTopicDetailInfo$2(this), (MutableLiveData) null, 4, (Object) null);
    }

    /* renamed from: Nh */
    public y Og() {
        return y.K(getLayoutInflater());
    }

    public final void Oh() {
        String str;
        if (this.f17510j == null) {
            this.f17510j = new ArrayList<>();
        }
        ArrayList<Fragment> arrayList = this.f17510j;
        if (arrayList != null && arrayList.size() == 0) {
            ArrayList<Fragment> arrayList2 = this.f17510j;
            if (arrayList2 != null) {
                arrayList2.add(TopicDetailChildFragment.f17537x.a(1, this.f17516p));
            }
            ArrayList<Fragment> arrayList3 = this.f17510j;
            if (arrayList3 != null) {
                arrayList3.add(TopicDetailChildFragment.f17537x.a(2, this.f17516p));
            }
            ((y) Yf()).f19327a0.setOffscreenPageLimit(2);
            ((y) Yf()).f19327a0.setAdapter(new v(getSupportFragmentManager(), this.f17510j));
            ((y) Yf()).X.setupWithViewPager(((y) Yf()).f19327a0);
            TabLayout tabLayout = ((y) Yf()).X;
            tabLayout.setSelectedTabIndicator(0);
            int tabCount = tabLayout.getTabCount();
            for (int i11 = 0; i11 < tabCount; i11++) {
                View inflate = LayoutInflater.from(tabLayout.getContext()).inflate(R$layout.home_new_content_tab, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R$id.tvTabTitle);
                textView.setTextColor(tabLayout.getResources().getColor(R$color.baseColorSecondaryTextNew));
                textView.setTextSize(2, 14.0f);
                if (i11 == 0) {
                    str = tabLayout.getResources().getString(R$string.n_newest);
                } else {
                    str = tabLayout.getResources().getString(R$string.n_hottest);
                }
                textView.setText(str);
                if (i11 == 0) {
                    textView.setTextColor(tabLayout.getResources().getColor(R$color.baseColorPrimaryText));
                    textView.setTextSize(2, 20.0f);
                }
                TabLayout.Tab tabAt = tabLayout.getTabAt(i11);
                if (tabAt != null) {
                    tabAt.setCustomView(inflate);
                }
            }
            ((y) Yf()).X.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b(this));
        }
    }

    public final void Ph() {
        ((y) Yf()).E.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) this);
        AppCompatImageView appCompatImageView = this.f17511k;
        if (appCompatImageView != null) {
            s sVar = s.f23381a;
            appCompatImageView.setOnClickListener(new c(appCompatImageView, 800, this));
        }
        AppCompatImageView appCompatImageView2 = this.f17512l;
        if (appCompatImageView2 != null) {
            s sVar2 = s.f23381a;
            appCompatImageView2.setOnClickListener(new d(appCompatImageView2, 800, this));
        }
        nc.c.a("app_community_fb", MapsKt__MapsKt.j(l.a("pagename", "comunitytopic")));
        s sVar3 = s.f23381a;
        ImageView imageView = ((y) Yf()).N;
        imageView.setOnClickListener(new e(imageView, 800, this));
    }

    public final void Qh() {
        MutableLiveData<CommunityUserPermissions> k02;
        CommunityViewModel communityViewModel = (CommunityViewModel) gc.e.f19132a.a(this, CommunityViewModel.class);
        this.f17521u = communityViewModel;
        if (!(communityViewModel == null || (k02 = communityViewModel.k0()) == null)) {
            k02.observe(this, new f(new TopicDetailActivity$initObserves$1(this)));
        }
        we.b.m("communityRefreshPage", (Class) null, 2, (Object) null).observe(this, new f(new TopicDetailActivity$initObserves$2(this)));
    }

    @SuppressLint({"InflateParams"})
    public final void Rh() {
        setSupportActionBar(((y) Yf()).Y);
        this.f17514n = getSupportActionBar();
        ViewGroup.LayoutParams layoutParams = null;
        View inflate = LayoutInflater.from(this).inflate(R$layout.titlebar_topic_detail, (ViewGroup) null, false);
        ai();
        ActionBar actionBar = this.f17514n;
        if (actionBar != null) {
            actionBar.setDisplayOptions(16);
        }
        ActionBar actionBar2 = this.f17514n;
        if (actionBar2 != null) {
            actionBar2.setCustomView(inflate, new ActionBar.LayoutParams(-1, -1));
        }
        ActionBar actionBar3 = this.f17514n;
        if (actionBar3 != null) {
            actionBar3.setDisplayHomeAsUpEnabled(false);
        }
        ActionBar actionBar4 = this.f17514n;
        View customView = actionBar4 != null ? actionBar4.getCustomView() : null;
        this.f17511k = customView != null ? (AppCompatImageView) customView.findViewById(R$id.iv_topic_detail_back) : null;
        this.f17512l = customView != null ? (AppCompatImageView) customView.findViewById(R$id.iv_topic_share) : null;
        this.f17513m = customView != null ? (AppCompatTextView) customView.findViewById(R$id.tv_topic_title) : null;
        AppCompatImageView appCompatImageView = this.f17511k;
        if (appCompatImageView != null) {
            layoutParams = appCompatImageView.getLayoutParams();
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(com.hbg.module.libkt.base.ext.c.a(15.0f));
    }

    public final void Sh(String str) {
        HbgBaseProvider fg2 = fg();
        if (fg2 != null) {
            fg2.g(str);
        }
    }

    public final void Th() {
        TypedValue typedValue = new TypedValue();
        ((y) Yf()).U.setPadding(0, StatusBarUtils.a(this) + (getTheme().resolveAttribute(16843499, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics()) : 0), 0, 0);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void Uh() {
        if (this.f17515o.getCoinList() == null || this.f17515o.getCoinList().size() <= 0) {
            Yh(8);
            return;
        }
        if (this.f17522v == null) {
            this.f17522v = com.hbg.module.libkt.base.ext.b.k(this, this.f17515o.getCoinList().size());
            ((y) Yf()).V.setLayoutManager(this.f17522v);
        }
        this.f17522v.s(this.f17515o.getCoinList().size());
        me.a aVar = this.f17523w;
        if (aVar != null) {
            ((y) Yf()).V.removeItemDecoration(aVar);
        }
        this.f17523w = com.hbg.module.libkt.base.ext.b.l(this.f17515o.getCoinList().size(), 8.0f);
        ((y) Yf()).V.addItemDecoration(this.f17523w);
        this.f17520t.setData(this.f17515o.getCoinList());
        this.f17520t.notifyDataSetChanged();
        Yh(0);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void Vh() {
        if (this.f17515o.getNewsList() == null || this.f17515o.getNewsList().size() <= 0) {
            Zh(8);
            return;
        }
        this.f17519s.setItems(this.f17515o.getNewsList());
        this.f17519s.notifyDataSetChanged();
        Zh(0);
    }

    public final void Wh(boolean z11) {
        if (z11) {
            if (NightHelper.e().g()) {
                AppCompatImageView appCompatImageView = this.f17511k;
                if (appCompatImageView != null) {
                    appCompatImageView.setBackgroundResource(R$drawable.ic_personal_back_white);
                }
                AppCompatImageView appCompatImageView2 = this.f17512l;
                if (appCompatImageView2 != null) {
                    appCompatImageView2.setBackgroundResource(R$drawable.ic_personal_share_white);
                }
                NBStatusBarUtils.setStatusBarDarkMode(this);
            } else {
                AppCompatImageView appCompatImageView3 = this.f17511k;
                if (appCompatImageView3 != null) {
                    appCompatImageView3.setBackgroundResource(R$drawable.ic_personal_back_black);
                }
                AppCompatImageView appCompatImageView4 = this.f17512l;
                if (appCompatImageView4 != null) {
                    appCompatImageView4.setBackgroundResource(R$drawable.ic_personal_share_black);
                }
                NBStatusBarUtils.setStatusBarLightMode(this);
            }
            AppCompatTextView appCompatTextView = this.f17513m;
            if (appCompatTextView != null) {
                appCompatTextView.setVisibility(8);
                return;
            }
            return;
        }
        if (!NightHelper.e().g()) {
            AppCompatImageView appCompatImageView5 = this.f17511k;
            if (appCompatImageView5 != null) {
                appCompatImageView5.setBackgroundResource(R$drawable.ic_personal_back_black);
            }
            AppCompatImageView appCompatImageView6 = this.f17512l;
            if (appCompatImageView6 != null) {
                appCompatImageView6.setBackgroundResource(R$drawable.ic_personal_share_black);
            }
            NBStatusBarUtils.setStatusBarLightMode(this);
        }
        AppCompatTextView appCompatTextView2 = this.f17513m;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setVisibility(0);
        }
    }

    public final void Xh() {
        if (((y) Yf()).F.getVisibility() == 8 && ((y) Yf()).H.getVisibility() == 8) {
            ((y) Yf()).M.setVisibility(8);
        } else {
            ((y) Yf()).M.setVisibility(0);
        }
    }

    public final void Yh(int i11) {
        ((y) Yf()).H.setVisibility(i11);
        ((y) Yf()).V.setVisibility(i11);
    }

    public final void Zh(int i11) {
        ((y) Yf()).F.setVisibility(i11);
        ((y) Yf()).W.setVisibility(i11);
    }

    public final void ai() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 19) {
            if (i11 >= 21) {
                getWindow().setStatusBarColor(0);
                getWindow().getDecorView().setSystemUiVisibility(1280);
            } else if (i11 >= 19) {
                getWindow().setFlags(67108864, 67108864);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((y) Yf()).Y.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + StatusBarUtils.a(this), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    public final void bi() {
        ((y) Yf()).V.setAdapter(this.f17520t);
    }

    public final void ci() {
        TopicNewsItemBinder topicNewsItemBinder = new TopicNewsItemBinder();
        topicNewsItemBinder.t(new TopicDetailActivity$setupNewsModule$1(this));
        this.f17519s.h(TopicDetailInfo.NewsInfo.class, topicNewsItemBinder);
        ((y) Yf()).W.setLayoutManager(com.hbg.module.libkt.base.ext.b.t(this));
        ((y) Yf()).W.setAdapter(this.f17519s);
    }

    public final void di() {
    }

    public void e(List<SymbolPrice> list) {
    }

    public final void ei(int i11) {
        HbgBaseShareProvider gg2 = gg();
        if (gg2 != null) {
            View decorView = getWindow().getDecorView();
            BaseModuleConfig.a a11 = BaseModuleConfig.a();
            String k11 = a11.k("live/community/dynamic/h5?uidUnique=" + i11);
            TopicDetailInfo.HeaderInfo info = this.f17515o.getInfo();
            String str = null;
            String title = info != null ? info.getTitle() : null;
            if (title == null) {
                title = "";
            }
            TopicDetailInfo.HeaderInfo info2 = this.f17515o.getInfo();
            if (info2 != null) {
                str = info2.getDesc();
            }
            gg2.f(this, decorView, k11, title, str == null ? "" : str);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void fi() {
        Oh();
        Uh();
        Vh();
        Xh();
        AppCompatTextView appCompatTextView = this.f17513m;
        Integer num = null;
        if (appCompatTextView != null) {
            TopicDetailInfo.HeaderInfo info = this.f17515o.getInfo();
            appCompatTextView.setText(info != null ? info.getTitle() : null);
        }
        di();
        AppCompatTextView appCompatTextView2 = ((y) Yf()).L;
        TopicDetailInfo.HeaderInfo info2 = this.f17515o.getInfo();
        he.b.l(appCompatTextView2, String.valueOf(info2 != null ? Integer.valueOf(info2.getVisitNums()) : null));
        AppCompatTextView appCompatTextView3 = ((y) Yf()).G;
        TopicDetailInfo.HeaderInfo info3 = this.f17515o.getInfo();
        he.b.l(appCompatTextView3, String.valueOf(info3 != null ? Integer.valueOf(info3.getArticleNums()) : null));
        AppCompatTextView appCompatTextView4 = ((y) Yf()).J;
        TopicDetailInfo.HeaderInfo info4 = this.f17515o.getInfo();
        if (info4 != null) {
            num = Integer.valueOf(info4.getJoinNums());
        }
        he.b.l(appCompatTextView4, String.valueOf(num));
    }

    @SuppressLint({"SetTextI18n"})
    public void initView() {
        super.initView();
        Th();
        Rh();
        ci();
        bi();
        Ph();
        Qh();
        Wh(true);
    }

    public void oh() {
        super.oh();
        String stringExtra = getIntent().getStringExtra(CommunityConstants.TOPIC_ID);
        if (stringExtra != null) {
            this.f17516p = Integer.parseInt(stringExtra);
        }
    }

    public void onDestroy() {
        ((y) Yf()).E.removeOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) this);
        ((y) Yf()).X.removeOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        super.onDestroy();
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
        boolean z11 = Math.abs(i11) < (appBarLayout.getTotalScrollRange() * 7) / 10;
        if (this.f17517q != z11) {
            this.f17517q = z11;
            Wh(z11);
        }
    }

    public void onPause() {
        super.onPause();
        f0.g().j("TopicDetailActivity");
        f0.g().n();
    }

    public void onResume() {
        CommunityViewModel communityViewModel;
        super.onResume();
        if (fg() != null) {
            HbgBaseProvider fg2 = fg();
            boolean z11 = true;
            if (fg2 == null || !fg2.n()) {
                z11 = false;
            }
            if (z11 && (communityViewModel = this.f17521u) != null) {
                communityViewModel.s0();
            }
        }
        Mh();
        f0.g().e("TopicDetailActivity", this);
        f0.g().i();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void onSuccess(List<SymbolPrice> list) {
        if (com.hbg.module.libkt.base.ext.b.e(this)) {
            this.f17520t.notifyDataSetChanged();
        }
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }

    @SensorsDataInstrumented
    public void onTabSelected(TabLayout.Tab tab) {
        ((y) Yf()).f19328b0.setContentScrimColor(ContextCompat.getColor(this, this.f17509i));
        this.f17518r = tab != null ? tab.getPosition() : 0;
        SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
    }

    public void onTabUnselected(TabLayout.Tab tab) {
    }
}
