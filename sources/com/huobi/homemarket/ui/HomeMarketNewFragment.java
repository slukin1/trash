package com.huobi.homemarket.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.page.SmartRefreshFooter;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.contract.core.bean.ContractTagInfo;
import com.hbg.lib.network.hbg.core.bean.MarketRedData;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import com.hbg.lib.network.pro.core.bean.Partitions;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.ClosePathFloatView;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.module.content.ui.fragment.H5Fragment;
import com.hbg.module.content.ui.fragment.NewsHomeFragment;
import com.hbg.module.libkt.custom.indicator.CoIndicator;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.hbg.module.livesquare.utils.LiveTrackUtils;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$dimen;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.hbg.module.market.R$style;
import com.huobi.account.event.ContractTagEvent;
import com.huobi.contract.viewhandler.ContractHeaderViewHandler;
import com.huobi.homemarket.bean.MarketCoinThirdTabClick;
import com.huobi.homemarket.dialog.NoticeSettingDialog;
import com.huobi.homemarket.helper.MarketBuriedHelper;
import com.huobi.homemarket.helper.MarketContentGuideHelper;
import com.huobi.homemarket.model.MgtSquareBean;
import com.huobi.homemarket.presenter.HomeMarketNewPresenter;
import com.huobi.homemarket.presenter.MarketCoinPresenter;
import com.huobi.homemarket.ui.MarketSortLayout;
import com.huobi.homemarket.ui.a;
import com.huobi.homemarket.view.MarketCollectionIndicator;
import com.huobi.homemarket.view.MarketContractIndicator;
import com.huobi.homemarket.view.MarketOptionTopView;
import com.huobi.homemarket.view.OneKeyCollectView;
import com.huobi.page.SmartRefreshHeader;
import com.huobi.statistics.hbg.bean.AnalyticsExposureItem;
import com.huobi.store.AppConfigManager;
import com.huobi.view.MarketSkeletonView;
import com.huobi.view.MarketTitleLayout;
import com.huobi.view.TitleLayout;
import com.jumio.sdk.reject.JumioRejectReason;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import d7.a1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import ky.j;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rl.p;
import rl.q;
import rx.Observable;
import rx.schedulers.Schedulers;
import ul.a0;
import ul.b0;
import ul.c0;
import ul.d0;
import ul.e0;
import ul.f0;
import ul.g0;
import ul.h0;
import ul.i;
import ul.i0;
import ul.j0;
import ul.k;
import ul.k0;
import ul.l;
import ul.l0;
import ul.m;
import ul.m0;
import ul.n;
import ul.n0;
import ul.o;
import ul.r;
import ul.s;
import ul.t;
import ul.u;
import ul.v;
import ul.w;
import ul.x;
import ul.y;
import ul.z;

public class HomeMarketNewFragment extends BaseFragment<HomeMarketNewPresenter, HomeMarketNewPresenter.g0> implements HomeMarketNewPresenter.g0, MarketSortLayout.a {
    public MarketSortLayout A;
    public ConstraintLayout A0;
    public View B;
    public ConstraintLayout B0;
    public View C;
    public RadioGroup C0;
    public View D;
    public RadioGroup D0;
    public CoIndicator E;
    public ImageView E0;
    public ViewPager2 F;
    public ImageView F0;
    public ImageView G;
    public HorizontalScrollView G0;
    public ImageView H;
    public HorizontalScrollView H0;
    public NewsHomeFragment I;
    public HorizontalScrollView I0;
    public ViewGroup J;
    public FrameLayout J0;
    public MarketContractIndicator K;
    public LoadingLayout K0;
    public MarketCollectionIndicator L;
    public OneKeyCollectView L0;
    public View M;
    public List<TabData> M0;
    public View N;
    public boolean N0;
    public MarketOptionTopView O;
    public String O0;
    public View P;
    public String P0;
    public vl.b Q;
    public String Q0;
    public a R;
    public String R0;
    public a S;
    public String S0;
    public ImageView T;
    public String T0;
    public ImageView U;
    public Fragment U0;
    public AppCompatImageView V;
    public String V0;
    public DecelerateInterpolator W = new DecelerateInterpolator();
    public final q.b W0 = new f0(this);
    public LoadingLayout X;
    public List<String> X0 = new ArrayList();
    public LoadingLayout Y;
    public boolean Y0 = true;
    public View Z;
    public boolean Z0 = true;

    /* renamed from: a0  reason: collision with root package name */
    public String f72871a0 = null;

    /* renamed from: b0  reason: collision with root package name */
    public String f72872b0 = "";

    /* renamed from: c0  reason: collision with root package name */
    public String f72873c0 = "";

    /* renamed from: d0  reason: collision with root package name */
    public String f72874d0 = "";

    /* renamed from: e0  reason: collision with root package name */
    public String f72875e0 = "";

    /* renamed from: f0  reason: collision with root package name */
    public boolean f72876f0 = true;

    /* renamed from: g0  reason: collision with root package name */
    public boolean f72877g0 = true;

    /* renamed from: h0  reason: collision with root package name */
    public boolean f72878h0 = false;

    /* renamed from: i0  reason: collision with root package name */
    public View f72879i0;

    /* renamed from: j0  reason: collision with root package name */
    public View f72880j0;

    /* renamed from: k0  reason: collision with root package name */
    public View f72881k0;

    /* renamed from: l  reason: collision with root package name */
    public LoadingLayout f72882l;

    /* renamed from: l0  reason: collision with root package name */
    public View f72883l0;

    /* renamed from: m  reason: collision with root package name */
    public View f72884m;

    /* renamed from: m0  reason: collision with root package name */
    public StableLinearLayoutManager f72885m0;

    /* renamed from: n  reason: collision with root package name */
    public View f72886n;

    /* renamed from: n0  reason: collision with root package name */
    public StableLinearLayoutManager f72887n0;

    /* renamed from: o  reason: collision with root package name */
    public CommonTextListIndicator f72888o;

    /* renamed from: p  reason: collision with root package name */
    public View f72889p;

    /* renamed from: q  reason: collision with root package name */
    public RecyclerView f72890q;

    /* renamed from: r  reason: collision with root package name */
    public RecyclerView f72891r;

    /* renamed from: s  reason: collision with root package name */
    public RecyclerView f72892s;

    /* renamed from: t  reason: collision with root package name */
    public View f72893t;

    /* renamed from: t0  reason: collision with root package name */
    public SmartRefreshHeader f72894t0;

    /* renamed from: u  reason: collision with root package name */
    public TextView f72895u;

    /* renamed from: u0  reason: collision with root package name */
    public SmartRefreshFooter f72896u0;

    /* renamed from: v  reason: collision with root package name */
    public RecyclerView f72897v;

    /* renamed from: v0  reason: collision with root package name */
    public SmartRefreshLayout f72898v0;

    /* renamed from: w  reason: collision with root package name */
    public RecyclerView f72899w;

    /* renamed from: w0  reason: collision with root package name */
    public MarketSkeletonView f72900w0;

    /* renamed from: x  reason: collision with root package name */
    public ViewPager f72901x;

    /* renamed from: x0  reason: collision with root package name */
    public MarketSkeletonView f72902x0;

    /* renamed from: y  reason: collision with root package name */
    public ImageView f72903y;

    /* renamed from: y0  reason: collision with root package name */
    public MarketTitleLayout f72904y0;

    /* renamed from: z  reason: collision with root package name */
    public MarketSortLayout f72905z;

    /* renamed from: z0  reason: collision with root package name */
    public ConstraintLayout f72906z0;

    public class a implements TitleLayout.OnTitleListener {
        public a() {
        }

        public void onTitleChange(int i11) {
            int scrollX = HomeMarketNewFragment.this.I0.getScrollX();
            View childAt = HomeMarketNewFragment.this.f72904y0.getChildAt(i11);
            int left = childAt.getLeft();
            if (left < scrollX) {
                HomeMarketNewFragment.this.I0.smoothScrollBy(left - scrollX, 0);
            }
            int right = childAt.getRight();
            int measuredWidth = HomeMarketNewFragment.this.B0.getMeasuredWidth();
            if (measuredWidth + scrollX < right) {
                HomeMarketNewFragment.this.I0.smoothScrollBy((right - scrollX) - measuredWidth, 0);
            }
            boolean unused = HomeMarketNewFragment.this.f72876f0 = true;
            HomeMarketNewFragment.this.f72898v0.finishRefresh();
            if (HomeMarketNewFragment.this.I != null) {
                HomeMarketNewFragment.this.I.ji(false);
            }
            String charSequence = HomeMarketNewFragment.this.f72904y0.getIndexTextView(i11).getText().toString();
            if (!HomeMarketNewFragment.this.T0.equals(charSequence)) {
                String unused2 = HomeMarketNewFragment.this.V0 = charSequence;
            }
            if (HomeMarketNewFragment.this.O0.equals(charSequence)) {
                if (!SPUtil.g("hot_coin_guide_showed", false)) {
                    HomeMarketNewFragment.this.f72904y0.showHidePoint(false, HomeMarketNewFragment.this.O0);
                }
                HomeMarketNewFragment.this.pk();
                MarketBuriedHelper.a().f(MarketBuriedHelper.MarketBuried.SQUARE);
            } else if (HomeMarketNewFragment.this.Q0.equals(charSequence)) {
                BaseModuleConfig.a().o0("huobiapp_market_market_spot_end");
                HomeMarketNewFragment.this.T7();
                MarketBuriedHelper.a().f(MarketBuriedHelper.MarketBuried.SPOT);
            } else if (HomeMarketNewFragment.this.R0.equals(charSequence)) {
                if (gj.d.n().E()) {
                    if (HomeMarketNewFragment.this.f72872b0 == RankScreenBean.SCREEN_VALUE_SPOT) {
                        HomeMarketNewFragment.this.lk();
                    }
                    BaseModuleConfig.a().o0("huobiapp_market_market_futures_end");
                    HomeMarketNewFragment.this.jk();
                    MarketBuriedHelper.a().f(MarketBuriedHelper.MarketBuried.CONTRACT);
                }
            } else if (HomeMarketNewFragment.this.S0.equals(charSequence)) {
                p.e().d();
                p.e().f().contentTableCount = 0;
                EventBus.d().k(p.e().f());
                if (HomeMarketNewFragment.this.f72872b0 == RankScreenBean.SCREEN_VALUE_SPOT) {
                    HomeMarketNewFragment.this.lk();
                }
                if (HomeMarketNewFragment.this.I != null) {
                    HomeMarketNewFragment.this.I.ji(true);
                }
                HomeMarketNewFragment.this.ik(childAt);
                MarketBuriedHelper.a().f(MarketBuriedHelper.MarketBuried.CONTENT);
            } else if (HomeMarketNewFragment.this.T0.equals(charSequence)) {
                HomeMarketNewFragment.this.f72904y0.setIndex(HomeMarketNewFragment.this.V0);
                b2.a.d().a("/webView/index").withString("url", "holigeit://open/v1?url=ihuobiglobal://m.hbg.com/Contract/CopyTrading").navigation();
                MarketBuriedHelper.a().f(MarketBuriedHelper.MarketBuried.COPY_TRADING);
            } else {
                if (HomeMarketNewFragment.this.f72872b0 == RankScreenBean.SCREEN_VALUE_SPOT) {
                    HomeMarketNewFragment.this.lk();
                }
                i6.d.e("tab", "selectCollection --- 3");
                HomeMarketNewFragment.this.Ia();
                MarketBuriedHelper.a().f(MarketBuriedHelper.MarketBuried.OPTIONAL);
            }
            if (!HomeMarketNewFragment.this.S0.equals(charSequence)) {
                BaseModuleConfig.a().H();
            }
            HomeMarketNewFragment.this.fk(0);
            q.b().f((String) null, -1);
            i6.d.e("tab", "onTitleChange -- " + i11);
        }

        public void onTitleStatueChange(int i11, boolean z11) {
        }
    }

    public class b implements CommonTextListIndicator.b {
        public b() {
        }

        public void a(int i11, View view) {
        }

        public void onItemClick(int i11) {
            HomeMarketNewFragment.this.f72901x.setCurrentItem(i11);
            if (HomeMarketNewFragment.this.f72888o != null && HomeMarketNewFragment.this.f72888o.getList() != null && i11 < HomeMarketNewFragment.this.f72888o.getList().size()) {
                HashMap hashMap = new HashMap();
                hashMap.put(FirebaseAnalytics.Param.CURRENCY, HomeMarketNewFragment.this.f72888o.getList().get(i11));
                BaseModuleConfig.a().d("4743", hashMap, "1000047");
            }
        }
    }

    public class c implements ViewPager.OnPageChangeListener {
        public c() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            boolean unused = HomeMarketNewFragment.this.f72877g0 = true;
            if ("TAB_ALL".equals(HomeMarketNewFragment.this.f72871a0)) {
                ConfigPreferences.k("user_config", "config_home_market_index", i11);
            } else if ("TAB_MAIN".equals(HomeMarketNewFragment.this.f72871a0)) {
                ConfigPreferences.k("user_config", "config_home_market_main_index", i11);
            } else if ("TAB_HADAX".equals(HomeMarketNewFragment.this.f72871a0)) {
                ConfigPreferences.k("user_config", "config_home_market_hadax_index", i11);
            }
            HomeMarketNewFragment homeMarketNewFragment = HomeMarketNewFragment.this;
            String unused2 = homeMarketNewFragment.f72873c0 = homeMarketNewFragment.V9();
            ConfigPreferences.m("user_config", "config_market_sec_tab_memory_content", HomeMarketNewFragment.this.f72873c0);
            HomeMarketNewFragment homeMarketNewFragment2 = HomeMarketNewFragment.this;
            String unused3 = homeMarketNewFragment2.f72874d0 = ConfigPreferences.e("user_config", "config_market_third_tab_memory_content" + HomeMarketNewFragment.this.f72873c0, "0");
            HomeMarketNewFragment homeMarketNewFragment3 = HomeMarketNewFragment.this;
            String unused4 = homeMarketNewFragment3.f72875e0 = ConfigPreferences.e("user_config", "config_market_third_tab_memory_content" + HomeMarketNewFragment.this.f72873c0, "0");
            if (!TextUtils.isEmpty(HomeMarketNewFragment.this.f72872b0)) {
                HomeMarketNewFragment.this.fk(1);
            }
            q.b().f((String) null, -1);
        }
    }

    public class d implements CommonTextListIndicator.b {
        public d() {
        }

        public void a(int i11, View view) {
        }

        public void onItemClick(int i11) {
            HomeMarketNewFragment.this.f72882l.setVisibility(8);
            HomeMarketNewFragment.this.f72898v0.g(false);
            boolean unused = HomeMarketNewFragment.this.f72877g0 = true;
            if (i11 == 1) {
                HomeMarketNewFragment.this.bk();
                HomeMarketNewFragment.this.fk(1);
            } else if (i11 == 0) {
                HomeMarketNewFragment.this.dk();
                HomeMarketNewFragment.this.fk(1);
            } else {
                HomeMarketNewFragment.this.ck();
            }
            HomeMarketNewFragment.this.K.y(i11);
        }
    }

    public class e implements CommonTextListIndicator.b {
        public e() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(j jVar) {
            ((HomeMarketNewPresenter) HomeMarketNewFragment.this.yh()).E1(false);
        }

        public void a(int i11, View view) {
            if (i11 == 0) {
                View unused = HomeMarketNewFragment.this.f72884m = view;
            } else if (i11 == 1) {
                View unused2 = HomeMarketNewFragment.this.f72886n = view;
            }
        }

        public void onItemClick(int i11) {
            boolean unused = HomeMarketNewFragment.this.f72877g0 = true;
            String y11 = HomeMarketNewFragment.this.L.y(i11);
            if (HomeMarketNewFragment.this.getContext().getString(R$string.n_title_spot).equals(y11)) {
                BaseModuleConfig.a().o0("huobiapp_market_market_favorite_currency_end");
                String unused2 = HomeMarketNewFragment.this.f72873c0 = "100";
                HomeMarketNewFragment.this.fj("100");
                HomeMarketNewFragment.this.f72898v0.g(false);
            } else if (HomeMarketNewFragment.this.getContext().getString(R$string.n_tab_contract).equals(y11)) {
                String unused3 = HomeMarketNewFragment.this.f72873c0 = JumioRejectReason.DIGITAL_COPY;
                HomeMarketNewFragment.this.fj(JumioRejectReason.DIGITAL_COPY);
                HomeMarketNewFragment.this.f72898v0.g(false);
            } else if (HomeMarketNewFragment.this.getContext().getString(R$string.n_market_intelligent_stare).equals(y11)) {
                BaseModuleConfig.a().o0("huobiapp_market_market_favorite_ai_end");
                BaseModuleConfig.a().w("MT_ST_number_of_clicks_on_the_smart_navigation_button", (HashMap) null);
                BaseModuleConfig.a().w("MT_ST_Page_PV", (HashMap) null);
                String unused4 = HomeMarketNewFragment.this.f72873c0 = "101";
                HomeMarketNewFragment.this.fj("101");
                HomeMarketNewFragment.this.f72898v0.g(true);
                HomeMarketNewFragment.this.f72898v0.b0(new n0(this));
                ((HomeMarketNewPresenter) HomeMarketNewFragment.this.yh()).E1(true);
            }
            HomeMarketNewFragment.this.fk(1);
            HomeMarketNewFragment.this.L.z(i11);
        }
    }

    public class f implements CoIndicator.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f72912a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f72913b;

        public f(List list, List list2) {
            this.f72912a = list;
            this.f72913b = list2;
        }

        public void onSelected(int i11) {
            int tabId = ((TabData) this.f72912a.get(i11)).getTabId();
            if (tabId == 0) {
                nc.c.a("MT_TCP_SAT_clik", (HashMap<?, ?>) null);
            } else if (tabId == 1) {
                HashMap hashMap = new HashMap();
                hashMap.put("news_state", "app_news_news");
                nc.c.a("app_newsTab_click", hashMap);
            } else if (tabId == 2) {
                LiveTrackUtils.f("APP_LIVE_quotation_tabshow");
            } else if (tabId == 3) {
                if (this.f72913b.get(i11) instanceof NewsHomeFragment) {
                    NewsHomeFragment unused = HomeMarketNewFragment.this.I = (NewsHomeFragment) this.f72913b.get(i11);
                }
                nc.c.a("app_founder_sdtab", (HashMap<?, ?>) null);
            } else if (tabId == 4) {
                nc.c.a("app_founder_xytab", (HashMap<?, ?>) null);
            } else if (tabId == 5) {
                nc.c.a("app_community_dd", (HashMap<?, ?>) null);
            } else if (tabId != 7) {
                nc.c.a("MT_TCP_LAT_clik", (HashMap<?, ?>) null);
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (HomeMarketNewFragment.this.yh() != null) {
                ((HomeMarketNewPresenter) HomeMarketNewFragment.this.yh()).k2();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class h extends EasySubscriber<Long> {
        public h() {
        }

        public void onNext(Long l11) {
            super.onNext(l11);
            HomeMarketNewFragment.this.fk(0);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Aj(View view) {
        BaseModuleConfig.a().k0("holigeit://open/v1?url=ihuobiglobal://m.hbg.com/reminder/all");
        BaseModuleConfig.a().w("favorite_ticker_management_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bj(String str, String str2) {
        rk(str, str2);
        this.f72905z.m();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Cj(RadioGroup radioGroup, int i11) {
        RadioButton radioButton = (RadioButton) this.f67460i.b(i11);
        if (radioButton != null) {
            int scrollX = this.G0.getScrollX();
            int left = radioButton.getLeft();
            if (left < scrollX) {
                this.G0.smoothScrollBy(left - scrollX, 0);
            }
            int right = radioButton.getRight();
            int measuredWidth = this.A0.getMeasuredWidth();
            if (measuredWidth + scrollX < right) {
                this.G0.smoothScrollBy((right - scrollX) - measuredWidth, 0);
            }
            if (radioButton.isChecked()) {
                HashMap hashMap = new HashMap();
                hashMap.put("type", radioButton.getText());
                BaseModuleConfig.a().d("4749", hashMap, "1000047");
            }
        }
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Dj(RadioGroup radioGroup, int i11) {
        RadioButton radioButton = (RadioButton) this.f67460i.b(i11);
        if (radioButton != null) {
            int scrollX = this.H0.getScrollX();
            int left = radioButton.getLeft();
            if (left < scrollX) {
                this.H0.smoothScrollBy(left - scrollX, 0);
            }
            int right = radioButton.getRight();
            int measuredWidth = this.f72906z0.getMeasuredWidth();
            if (measuredWidth + scrollX < right) {
                this.H0.smoothScrollBy((right - scrollX) - measuredWidth, 0);
            }
            radioButton.isChecked();
        }
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ej(j jVar) {
        ek(true);
        if ("TAB_COLLECTION".equals(this.f72871a0)) {
            if ("101".equals(this.f72873c0)) {
                ((HomeMarketNewPresenter) yh()).E1(true);
                Vi();
                return;
            }
            ((HomeMarketNewPresenter) yh()).i2(false);
            ((HomeMarketNewPresenter) yh()).g2(true);
        } else if ("TAB_ALL".equals(this.f72871a0)) {
            ((HomeMarketNewPresenter) yh()).i2(true);
        } else if ("TAB_MAIN".equals(this.f72871a0)) {
            ((HomeMarketNewPresenter) yh()).i2(true);
        } else if ("TAB_HADAX".equals(this.f72871a0)) {
            ((HomeMarketNewPresenter) yh()).i2(true);
        } else if ("TAB_CONTRACT".equals(this.f72871a0)) {
            ((HomeMarketNewPresenter) yh()).g2(false);
        } else if ("TAB_USDT_CONTRACT".equals(this.f72871a0)) {
            ((HomeMarketNewPresenter) yh()).h2(false);
        } else if (!"TAB_OPTION".equals(this.f72871a0)) {
            if ("TAB_CONTENT".equals(this.f72871a0)) {
                ((HomeMarketNewPresenter) yh()).k2();
            } else {
                ((HomeMarketNewPresenter) yh()).i2(true);
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fj(View view) {
        HorizontalScrollView horizontalScrollView = this.G0;
        if (horizontalScrollView != null) {
            horizontalScrollView.smoothScrollTo(Integer.MAX_VALUE, 0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gj(View view, int i11, int i12, int i13, int i14) {
        if (((view.getScrollX() + view.getWidth()) - view.getPaddingLeft()) - view.getPaddingRight() == this.G0.getChildAt(0).getWidth()) {
            Yi();
        } else {
            Xi();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hj(View view, int i11, int i12, int i13, int i14) {
        if (((view.getScrollX() + view.getWidth()) - view.getPaddingLeft()) - view.getPaddingRight() == this.H0.getChildAt(0).getWidth()) {
            Yi();
        } else {
            Xi();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ij(View view) {
        HorizontalScrollView horizontalScrollView = this.I0;
        if (horizontalScrollView != null) {
            horizontalScrollView.smoothScrollTo(Integer.MAX_VALUE, 0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jj(View view, int i11, int i12, int i13, int i14) {
        if (((view.getScrollX() + view.getWidth()) - view.getPaddingLeft()) - view.getPaddingRight() == this.I0.getChildAt(0).getWidth()) {
            aj();
        } else {
            Zi();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Kj(View view) {
        Rect rect = new Rect();
        this.E.getGlobalVisibleRect(rect);
        NoticeSettingDialog noticeSettingDialog = new NoticeSettingDialog();
        noticeSettingDialog.uh(rect);
        noticeSettingDialog.show(getActivity().getSupportFragmentManager(), "");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Lj(View view) {
        FragmentActivity activity = getActivity();
        if (activity instanceof MarketContainerActivity) {
            activity.finish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mj(View view, int i11, int i12) {
        hk(this.f72890q, this.f72885m0, view, i11, i12);
        hk(this.f72891r, this.f72887n0, view, i11, i12);
    }

    public static /* synthetic */ void Nj(StableLinearLayoutManager stableLinearLayoutManager, int i11, RecyclerView recyclerView) {
        int findLastCompletelyVisibleItemPosition = stableLinearLayoutManager.findLastCompletelyVisibleItemPosition();
        if (i11 == findLastCompletelyVisibleItemPosition) {
            recyclerView.smoothScrollBy(0, DimenUtils.a(40.0f));
        } else if (i11 > findLastCompletelyVisibleItemPosition) {
            recyclerView.smoothScrollBy(0, DimenUtils.a(40.0f));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oj() {
        this.f72902x0.dismissOneTwo();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Pj() {
        this.f72902x0.dismissOne();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Qj() {
        this.f72902x0.dismissOne();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Rj(j jVar) {
        ((HomeMarketNewPresenter) yh()).E1(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Sj(List list, int i11) {
        TabData tabData = (TabData) list.get(i11);
        this.G.setVisibility(8);
        this.H.setVisibility(8);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Tj(CompoundButton compoundButton, boolean z11) {
        if (z11) {
            gj(MarketModuleConfig.a().C(), this.Y, 0);
            bj(compoundButton, Arrays.asList(new String[]{"-9527"}));
            this.f72874d0 = "1";
            ConfigPreferences.m("user_config", "config_market_third_tab_contract_memory_content", "1");
            if (compoundButton != null && compoundButton.isPressed()) {
                fk(2);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Uj(ContractTagInfo.TagsGroupInfo.TagInfo tagInfo, CompoundButton compoundButton, boolean z11) {
        if (z11) {
            gj(MarketModuleConfig.a().C(), this.Y, 1);
            bj(compoundButton, tagInfo.e());
            String valueOf = String.valueOf(tagInfo.b());
            this.f72875e0 = valueOf;
            ConfigPreferences.m("user_config", "config_market_third_tab_contract_memory_content", valueOf);
            if (compoundButton != null && compoundButton.isPressed()) {
                fk(2);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Vj(View view) {
        i9(true);
        ((HomeMarketNewPresenter) yh()).u1();
        this.L0 = null;
        i6.d.e("tab", "selectCollection --- 4");
        Ia();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Wj(View view) {
        MarketModuleConfig.a().h(getActivity());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xj() {
        this.f72902x0.dismissOneTwo();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yj() {
        this.f72902x0.dismissOne();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Zj(CompoundButton compoundButton, boolean z11) {
        if (z11) {
            gj(MarketModuleConfig.a().C(), this.Y, 0);
            cj(compoundButton, Arrays.asList(new String[]{"-9527"}));
            this.f72875e0 = "1";
            ConfigPreferences.m("user_config", "config_market_third_tab_usdt_contract_memory_content", "1");
            if (compoundButton != null && compoundButton.isPressed()) {
                fk(2);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ak(ContractTagInfo.TagsGroupInfo.TagInfo tagInfo, CompoundButton compoundButton, boolean z11) {
        if (z11) {
            gj(MarketModuleConfig.a().C(), this.Y, 1);
            cj(compoundButton, tagInfo.e());
            String b11 = tagInfo.b();
            this.f72875e0 = b11;
            ConfigPreferences.m("user_config", "config_market_third_tab_usdt_contract_memory_content", b11);
            if (compoundButton != null && compoundButton.isPressed()) {
                fk(2);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void tj(View view) {
        String str = this.f72871a0;
        if (str == null || !str.equals("TAB_CONTENT")) {
            BaseModuleConfig.a().w("App_markets_list_search_click", (HashMap) null);
            BaseModuleConfig.a().b("3115", (Map<String, Object>) null);
            MarketModuleConfig.a().h(getActivity());
            BaseModuleConfig.a().w("App_markets_lists_search_click", (HashMap) null);
        } else {
            MarketModuleConfig.a().h(getActivity());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void uj(View view) {
        MarketModuleConfig.a().h(getActivity());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void vj(View view) {
        MarketModuleConfig.a().h(getActivity());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void wj(View view) {
        ek(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void xj(View view) {
        ek(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void yj(View view) {
        ek(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void zj(View view) {
        Intent intent = new Intent(getActivity(), EditCollectionActivity.class);
        intent.putExtra("isSpot", "100".equals(this.f72873c0));
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(0, 0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SuppressLint({"WrongConstant"})
    public void Ah() {
        super.Ah();
        this.f72898v0.d0(new e0(this));
        this.f72905z.setSrotTypeListener(this);
        this.f72903y.setOnClickListener(new i(this));
        this.B.setOnClickListener(new l0(this));
        this.C.setOnClickListener(new m0(this));
        this.f72882l.setOnRetryClickListener(new ul.q(this));
        this.X.setOnRetryClickListener(new j0(this));
        this.Y.setOnRetryClickListener(new i0(this));
        this.f72888o.setCallback(new b());
        this.f72901x.addOnPageChangeListener(new c());
        this.T.setOnClickListener(new k0(this));
        this.U.setOnClickListener(ul.j.f60785b);
        this.K.setCallback(new d());
        this.L.setCallback(new e());
        this.L.q(getActivity());
        this.A.setSrotTypeListener(new u(this));
        this.D0.setOnCheckedChangeListener(new s(this));
        this.C0.setOnCheckedChangeListener(new t(this));
        refreshContractTag((ContractTagEvent) null);
    }

    public void Be() {
        if (this.f72898v0.K()) {
            this.f72898v0.w();
        }
    }

    public void Bg(v9.a<s9.a> aVar) {
        this.f72892s.setAdapter(aVar);
    }

    public void Cg(v9.a<ml.b> aVar) {
        this.f72891r.setAdapter(aVar);
    }

    public void F0() {
        if (this.f72882l.getVisibility() != 8) {
            this.f72882l.setVisibility(8);
            this.f72878h0 = false;
        }
        if (this.X.getVisibility() != 8) {
            this.X.setVisibility(8);
            this.f72878h0 = false;
        }
        if ("TAB_CONTRACT".equals(r6())) {
            this.f72906z0.setVisibility(8);
            this.A0.setVisibility(0);
            this.A.setVisibility(0);
        } else {
            this.A0.setVisibility(8);
        }
        if ("TAB_USDT_CONTRACT".equals(r6())) {
            this.f72906z0.setVisibility(0);
            this.A0.setVisibility(4);
            this.A.setVisibility(0);
            return;
        }
        this.f72906z0.setVisibility(8);
    }

    public void Gd() {
    }

    public void Ia() {
        this.f72873c0 = ConfigPreferences.e("user_config", "config_collection_market_sec_tab_memory_content", "100");
        this.f72898v0.setVisibility(0);
        fj(this.f72873c0);
        if ("101".equals(this.f72873c0)) {
            ((HomeMarketNewPresenter) yh()).E1(true);
        }
    }

    public void Kb(List<OptionMarketIndexInfo> list) {
        if ("TAB_OPTION".equals(r6())) {
            this.Q.m(list);
            hj(list.size());
            if (this.O.getVisibility() == 8) {
                this.O.setVisibility(0);
            }
            MarketSkeletonView marketSkeletonView = this.f72902x0;
            if (marketSkeletonView != null && marketSkeletonView.showing()) {
                this.f72902x0.dismissSkeleton();
                this.f72902x0.setHasLoadData(true);
            }
        }
    }

    public void L7() {
        gk();
        OneKeyCollectView oneKeyCollectView = this.L0;
        if (oneKeyCollectView == null) {
            i6.d.j("OneKeyCollectView", "showOneKeyCollectView new View.");
            OneKeyCollectView oneKeyCollectView2 = new OneKeyCollectView(getActivity());
            this.L0 = oneKeyCollectView2;
            oneKeyCollectView2.j(new g0(this), new ul.h(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = PixelUtils.a(56.0f);
            this.J0.addView(this.L0, layoutParams);
            return;
        }
        oneKeyCollectView.i();
    }

    public void N7() {
        zh().T7();
        int kk2 = kk();
        if (kk2 > -1) {
            ((HomeMarketNewPresenter) yh()).m1(kk2);
        }
    }

    public void P9(v9.a<s9.a> aVar) {
        this.f72899w.setAdapter(aVar);
    }

    public void Qe(boolean z11) {
        if (z11) {
            this.f72893t.setVisibility(0);
            this.f72895u.setText(getString(R$string.n_market_contract_no_data_title));
            return;
        }
        this.f72893t.setVisibility(8);
    }

    public void T5(String str, String str2) {
        this.A.k(str, str2);
    }

    public void T7() {
        lj();
        this.f72898v0.setVisibility(0);
        this.f72898v0.g(false);
        BaseModuleConfig.a().d("4742", (Map<String, Object>) null, "1000047");
        this.O.setVisibility(8);
        this.A.setVisibility(8);
        this.Y.setVisibility(8);
        this.f72871a0 = "TAB_ALL";
        ((HomeMarketNewPresenter) yh()).l1();
        this.f72888o.setVisibility(0);
        this.f72890q.setVisibility(8);
        this.f72891r.setVisibility(8);
        this.f72892s.setVisibility(8);
        this.J.setVisibility(8);
        this.f72901x.setVisibility(0);
        this.f72889p.setVisibility(0);
        this.f72905z.setVisibility(8);
        jj(this.U);
        jj(this.T);
        this.K.setVisibility(8);
        this.L.setVisibility(8);
        this.M.setVisibility(8);
        this.D.setVisibility(8);
        this.f72903y.setVisibility(0);
        this.N.setVisibility(8);
        kj();
        ol.b.u(TtmlNode.COMBINE_ALL);
        ((HomeMarketNewPresenter) yh()).A2();
        this.f72904y0.setIndex(this.Q0);
        i9(true);
        ((HomeMarketNewPresenter) yh()).i2(true);
        this.f72872b0 = RankScreenBean.SCREEN_VALUE_SPOT;
        this.f72873c0 = ConfigPreferences.e("user_config", "config_market_sec_tab_memory_content", "USDT");
        this.f72874d0 = ConfigPreferences.e("user_config", "config_market_third_tab_memory_content" + this.f72873c0, "0");
        ConfigPreferences.m("user_config", "config_market_top_tab_memory_content", RankScreenBean.SCREEN_VALUE_SPOT);
        i6.d.e("tab", "selectSpot ---");
    }

    public final void Ti() {
        int i11 = 0;
        int g11 = ConfigPreferences.g("user_config", "config_home_market_contractindex", 0);
        if (!ij() && g11 >= 0 && g11 < this.D0.getChildCount()) {
            i11 = g11;
        }
        this.D0.clearCheck();
        View childAt = this.D0.getChildAt(i11);
        if (childAt instanceof RadioButton) {
            ((RadioButton) childAt).setChecked(true);
        }
    }

    public void Ub() {
        if ("TAB_ALL".equals(this.f72871a0) && this.f72888o.getList() != null) {
            String z12 = ((HomeMarketNewPresenter) yh()).z1("secondaryTitle");
            if (!TextUtils.isEmpty(z12)) {
                int i11 = 0;
                while (true) {
                    if (i11 >= this.f72888o.getList().size()) {
                        break;
                    } else if (z12.equalsIgnoreCase(this.f72888o.getList().get(i11))) {
                        ConfigPreferences.k("user_config", "config_home_market_index", i11);
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            int g11 = ConfigPreferences.g("user_config", "config_home_market_index", -1);
            if (g11 == -1) {
                int i12 = 0;
                while (true) {
                    if (i12 >= this.f72888o.getList().size()) {
                        break;
                    } else if ("usdt".equalsIgnoreCase(this.f72888o.getList().get(i12))) {
                        g11 = i12;
                        break;
                    } else {
                        i12++;
                    }
                }
            }
            if (g11 < 0 || g11 >= this.f72888o.getList().size()) {
                g11 = 0;
            }
            this.f72901x.setCurrentItem(g11);
            this.f72888o.c(g11);
            this.f72888o.b(g11, 0.0f, 0);
        }
    }

    public void Uf(zg.b bVar) {
        this.f72901x.setAdapter(bVar);
    }

    public final void Ui() {
        int i11 = 0;
        int g11 = ConfigPreferences.g("user_config", "config_home_market_contract_usdt_index", 0);
        if (!ij() && g11 >= 0 && g11 < this.C0.getChildCount()) {
            i11 = g11;
        }
        this.C0.clearCheck();
        View childAt = this.C0.getChildAt(i11);
        if (childAt instanceof RadioButton) {
            ((RadioButton) childAt).setChecked(true);
        }
    }

    public void V4(boolean z11) {
        if ("TAB_COLLECTION".equals(this.f72871a0)) {
            int i11 = 8;
            if ("100".equals(this.f72873c0) || JumioRejectReason.DIGITAL_COPY.equals(this.f72873c0)) {
                MarketSortLayout marketSortLayout = this.f72905z;
                if (z11) {
                    i11 = 0;
                }
                marketSortLayout.setVisibility(i11);
            } else if ("101".equals(this.f72873c0)) {
                this.f72905z.setVisibility(8);
            }
        }
    }

    public String V9() {
        int currentItem = this.f72901x.getCurrentItem();
        List<String> list = this.f72888o.getList();
        if (list == null || list.isEmpty() || currentItem < 0 || currentItem >= list.size()) {
            return null;
        }
        return list.get(currentItem);
    }

    public void Vb(List<TabData> list, List<Fragment> list2) {
        this.M0 = list;
        LoadingLayout loadingLayout = this.K0;
        if (loadingLayout != null) {
            loadingLayout.g();
            this.K0.setVisibility(8);
        }
        he.a aVar = new he.a((Fragment) this);
        aVar.a((ArrayList) list2);
        this.F.setAdapter(aVar);
        ne.b.l(getActivity(), list, this.E, this.F, new c0(this, list));
        this.E.setOnPageSelectListener(new f(list, list2));
        this.F.setOffscreenPageLimit(list2.size());
        this.F.setCurrentItem(0, false);
        sj();
        this.N0 = SP.l("SP_KEY_MARKET_WIDGET_TIPS_SHOW", true);
    }

    public final void Vi() {
        p.e().f().moniterCount = 0;
        this.L.A(false, getContext().getString(R$string.n_market_intelligent_stare));
        this.f72904y0.showHidePoint(p.e().f().displayCollectionRed(), this.P0);
        this.f72904y0.showHidePoint(p.e().f().displayContentTabRed(), this.S0);
        EventBus.d().k(p.e().f());
    }

    /* renamed from: Wi */
    public HomeMarketNewPresenter xh() {
        return new HomeMarketNewPresenter();
    }

    public void X3(List<FutureContractInfo> list) {
        if ("TAB_OPTION".equals(r6())) {
            this.O.h(list);
            int i11 = 0;
            if (this.O.getSelectedDelivery() != null) {
                ((HomeMarketNewPresenter) yh()).z2(this.O.getSelectedSymbol(), this.O.getSelectedDelivery().getContractType(), false);
            }
            if (list != null) {
                i11 = list.size();
            }
            hj(i11);
        }
    }

    public void Xg() {
        this.K0.setVisibility(0);
        this.K0.k();
        this.K0.setOnRetryClickListener(new g());
    }

    public final void Xi() {
        if (!this.Y0) {
            this.Y0 = true;
            this.E0.animate().setInterpolator(this.W).setDuration(300).translationX(0.0f).alpha(1.0f);
        }
    }

    public final void Yi() {
        if (this.Y0) {
            this.Y0 = false;
            this.E0.animate().setInterpolator(this.W).setDuration(300).translationX((float) this.E0.getWidth()).alpha(0.0f);
        }
    }

    public void Zb() {
        if ("TAB_COLLECTION".equals(this.f72871a0)) {
            this.f72882l.setVisibility(0);
            this.f72882l.p();
        }
    }

    public final void Zi() {
        if (!this.Z0) {
            this.Z0 = true;
            this.F0.animate().setInterpolator(this.W).setDuration(300).translationX(0.0f).alpha(1.0f);
        }
    }

    public final void aj() {
        if (this.Z0) {
            this.Z0 = false;
            this.F0.animate().setInterpolator(this.W).setDuration(300).translationX((float) this.F0.getWidth()).alpha(0.0f);
        }
    }

    public String bh() {
        return this.f72873c0;
    }

    public final void bj(View view, List<String> list) {
        if ("TAB_CONTRACT".equals(this.f72871a0)) {
            ConfigPreferences.k("user_config", "config_home_market_contractindex", this.D0.indexOfChild(view));
            q.b().f((String) null, -1);
            ((HomeMarketNewPresenter) yh()).s1(list);
        }
    }

    public final void bk() {
        i6.d.e("tab", "onUSDTContractTabSelected ----- 选中币本位合约tab");
        ConfigPreferences.m("user_config", "config_market_sec_tab_contract_memory_content", "1");
        this.f72873c0 = "1";
        this.f72874d0 = ConfigPreferences.e("user_config", "config_market_third_tab_contract_memory_content", "");
        this.f72875e0 = "";
        this.Y.setVisibility(8);
        this.f72871a0 = "TAB_CONTRACT";
        this.f72893t.setVisibility(8);
        this.f72897v.setVisibility(0);
        this.A0.setVisibility(0);
        this.A.setVisibility(0);
        this.f72899w.setVisibility(8);
        this.P.setVisibility(8);
        this.O.setVisibility(8);
        ((HomeMarketNewPresenter) yh()).x1();
        ((HomeMarketNewPresenter) yh()).A2();
        Ti();
    }

    public void c3() {
        this.f72878h0 = true;
        if ("TAB_OPTION".equals(r6()) || "TAB_CONTRACT".equals(r6()) || "TAB_USDT_CONTRACT".equals(r6())) {
            this.X.i();
            this.X.setVisibility(0);
        } else if ("TAB_COLLECTION".equals(this.f72871a0)) {
            if (TextUtils.isEmpty(this.f72873c0)) {
                this.f72882l.setEmptyView(this.f72879i0);
            } else if (this.f72873c0.equals("101")) {
                this.f72882l.setEmptyView(this.f72881k0);
            } else {
                this.f72882l.setEmptyView(this.f72879i0);
            }
            this.f72882l.i();
            this.f72882l.setVisibility(0);
        }
    }

    public final void cj(View view, List<String> list) {
        if ("TAB_USDT_CONTRACT".equals(this.f72871a0)) {
            ConfigPreferences.k("user_config", "config_home_market_contract_usdt_index", this.C0.indexOfChild(view));
            ((HomeMarketNewPresenter) yh()).r1(list);
        }
    }

    public final void ck() {
        i6.d.e("tab", "onUSDTContractTabSelected ----- 选中期权tab");
        this.f72898v0.g(false);
        this.Y.setVisibility(8);
        this.f72871a0 = "TAB_OPTION";
        this.f72893t.setVisibility(8);
        this.f72897v.setVisibility(8);
        this.f72899w.setVisibility(8);
        this.A0.setVisibility(8);
        this.A.setVisibility(8);
        this.Q.w((HomeMarketNewPresenter) yh());
        this.O.setPresenter((HomeMarketNewPresenter) yh());
        this.P.setVisibility(0);
        this.O.setVisibility(0);
        ((HomeMarketNewPresenter) yh()).C1(false);
    }

    public final String dj() {
        return getString(R$string.n_market_contract_no_data_title);
    }

    public final void dk() {
        ConfigPreferences.m("user_config", "config_market_sec_tab_contract_memory_content", "0");
        this.f72873c0 = "0";
        this.f72874d0 = "";
        this.f72875e0 = ConfigPreferences.e("user_config", "config_market_third_tab_usdt_contract_memory_content", "");
        this.Y.setVisibility(8);
        this.f72871a0 = "TAB_USDT_CONTRACT";
        this.f72899w.setVisibility(0);
        this.A.setVisibility(0);
        this.f72893t.setVisibility(8);
        this.f72897v.setVisibility(8);
        this.P.setVisibility(8);
        this.O.setVisibility(8);
        ((HomeMarketNewPresenter) yh()).A1();
        ((HomeMarketNewPresenter) yh()).A2();
        Ui();
    }

    public void ec(boolean z11) {
        if (z11) {
            this.f72893t.setVisibility(0);
            this.f72895u.setText(dj());
            return;
        }
        this.f72893t.setVisibility(8);
    }

    public void ee(String str, String str2) {
        this.f72905z.k(str, str2);
    }

    /* renamed from: ej */
    public HomeMarketNewPresenter.g0 zh() {
        return this;
    }

    public final void ek(boolean z11) {
        showSkeleton();
        if ("TAB_COLLECTION".equals(this.f72871a0)) {
            ((HomeMarketNewPresenter) yh()).u1();
        } else if ("TAB_ALL".equals(this.f72871a0)) {
            ((HomeMarketNewPresenter) yh()).l1();
        } else if ("TAB_MAIN".equals(this.f72871a0)) {
            ((HomeMarketNewPresenter) yh()).l1();
        } else if ("TAB_HADAX".equals(this.f72871a0)) {
            ((HomeMarketNewPresenter) yh()).l1();
        } else if ("TAB_CONTRACT".equals(this.f72871a0)) {
            ((HomeMarketNewPresenter) yh()).x1();
        } else if ("TAB_USDT_CONTRACT".equals(this.f72871a0)) {
            ((HomeMarketNewPresenter) yh()).A1();
        } else if ("TAB_OPTION".equals(this.f72871a0)) {
            ((HomeMarketNewPresenter) yh()).C1(!z11);
        } else if ("TAB_CONTENT".equals(this.f72871a0)) {
            ((HomeMarketNewPresenter) yh()).k2();
        } else {
            ((HomeMarketNewPresenter) yh()).u1();
        }
    }

    public void finishRefresh() {
        if (this.f72898v0.M()) {
            this.f72898v0.finishRefresh();
        }
    }

    public void finishSkeleton() {
        MarketSkeletonView marketSkeletonView = this.f72900w0;
        if (marketSkeletonView != null) {
            marketSkeletonView.dismissSkeleton();
            this.f72900w0.setHasLoadData(true);
        }
    }

    public final void fj(String str) {
        lj();
        this.f72898v0.g(false);
        this.f72871a0 = "TAB_COLLECTION";
        if (str.equals("100") || str.equals(JumioRejectReason.DIGITAL_COPY)) {
            mk(this.U);
            mk(this.T);
            ((ViewGroup.MarginLayoutParams) this.L.getLayoutParams()).rightMargin = PixelUtils.a(70.0f);
        } else {
            jj(this.U);
            jj(this.T);
            ((ViewGroup.MarginLayoutParams) this.L.getLayoutParams()).rightMargin = 0;
        }
        if ("101".equals(str)) {
            Vi();
        }
        BaseModuleConfig.a().d("4741", (Map<String, Object>) null, "1000047");
        this.O.setVisibility(8);
        this.A0.setVisibility(8);
        this.A.setVisibility(8);
        this.Y.setVisibility(8);
        this.f72882l.setEmptyView(this.f72879i0);
        if (!TextUtils.isEmpty(this.f72873c0)) {
            nk(this.f72873c0);
        }
        this.J.setVisibility(8);
        this.f72901x.setVisibility(8);
        this.f72888o.setVisibility(8);
        this.f72889p.setVisibility(8);
        this.K.setVisibility(8);
        this.L.setVisibility(0);
        this.M.setVisibility(8);
        this.D.setVisibility(8);
        this.N.setVisibility(0);
        ((HomeMarketNewPresenter) yh()).r2();
        ol.b.u("fav");
        ((HomeMarketNewPresenter) yh()).u1();
        ((HomeMarketNewPresenter) yh()).A2();
        this.f72904y0.setIndex(this.P0);
        this.f72872b0 = "optional";
        this.f72874d0 = "";
        this.f72875e0 = "";
        ConfigPreferences.m("user_config", "config_collection_market_sec_tab_memory_content", this.f72873c0);
        ConfigPreferences.m("user_config", "config_market_top_tab_memory_content", "optional");
        finishSkeleton();
    }

    public final void fk(int i11) {
        List<Partitions> C2;
        i6.d.e("tab", "reportMarketTabShow == " + i11);
        if (i11 == 2) {
            if (this.f72877g0 || this.f72876f0) {
                return;
            }
        } else if (i11 == 1 && this.f72876f0) {
            return;
        }
        if (this.f72877g0 || this.f72876f0) {
            this.f72877g0 = false;
            this.f72876f0 = false;
        }
        String str = this.f72872b0;
        if (str != null && str.equals(RankScreenBean.SCREEN_VALUE_SPOT) && ((C2 = a1.v().C(this.f72873c0)) == null || C2.size() <= 0)) {
            this.f72874d0 = "";
            this.f72875e0 = "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("markets_list_tab_name", this.f72872b0);
        hashMap.put("markets_list_tab_flc", this.f72873c0);
        hashMap.put("markets_list_tab_slc", this.f72874d0);
        BaseModuleConfig.a().w("App_markets_list_view", hashMap);
        MarketBuriedHelper.a().e(this.f72873c0, this.f72874d0);
        if (i11 == 0) {
            MarketBuriedHelper.a().b();
        } else if (i11 == 1) {
            MarketBuriedHelper.a().d();
        } else if (i11 == 2) {
            MarketBuriedHelper.a().c();
        }
    }

    public void g9(boolean z11) {
        if (z11) {
            this.X.p();
            this.X.setVisibility(0);
            return;
        }
        this.X.setVisibility(8);
    }

    public final void gj(boolean z11, LoadingLayout loadingLayout, int i11) {
        ImageView imageView = (ImageView) loadingLayout.findViewById(R$id.error_img);
        TextView textView = (TextView) loadingLayout.findViewById(R$id.error_tip);
        TextView textView2 = (TextView) loadingLayout.findViewById(R$id.error_title);
        TextView textView3 = (TextView) loadingLayout.findViewById(R$id.error_tip2);
        View findViewById = loadingLayout.findViewById(R$id.viewErrorRetry);
        if (!z11 || !"TAB_CONTRACT".equals(r6())) {
            findViewById.setVisibility(0);
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            imageView.setImageResource(R$drawable.common_no_network_icon);
            textView.setText(R$string.common_no_internet_access);
            loadingLayout.setVisibility(8);
            return;
        }
        textView2.setVisibility(0);
        findViewById.setVisibility(8);
        imageView.setImageResource(R$drawable.trade_liquidating);
        textView2.setText(R$string.contract_trade_safeguard);
        long Y2 = MarketModuleConfig.a().Y();
        long T2 = MarketModuleConfig.a().T();
        if (i11 == 0) {
            textView3.setVisibility(0);
            textView.setText(String.format(getString(R$string.n_delivery_contract_maintenance_tips), new Object[]{DateTimeUtils.h(Y2, "yyyy/MM/dd HH:mm")}));
            textView3.setText(String.format(getString(R$string.n_swap_contract_maintenance_tips), new Object[]{DateTimeUtils.h(T2, "yyyy/MM/dd HH:mm")}));
        } else if (i11 == 1) {
            textView.setText(String.format(getString(R$string.n_swap_contract_maintenance_tips), new Object[]{DateTimeUtils.h(T2, "yyyy/MM/dd HH:mm")}));
            textView3.setVisibility(8);
        } else if (i11 == 2) {
            textView.setText(String.format(getString(R$string.n_delivery_contract_maintenance_tips), new Object[]{DateTimeUtils.h(Y2, "yyyy/MM/dd HH:mm")}));
            textView3.setVisibility(8);
        }
        loadingLayout.setVisibility(0);
        loadingLayout.k();
    }

    public final void gk() {
        AnalyticsExposureItem analyticsExposureItem = new AnalyticsExposureItem();
        analyticsExposureItem.setPageId("1005260");
        analyticsExposureItem.setName("一键添加主流币种页面");
        BaseModuleConfig.a().q0(analyticsExposureItem);
    }

    public final void hj(int i11) {
        if (!MarketModuleConfig.a().E(MarketModuleConfig.a().o()) && "TAB_OPTION".equals(r6())) {
            if (i11 > 0) {
                this.X.setVisibility(8);
                return;
            }
            this.X.i();
            this.X.setVisibility(0);
        }
    }

    public final void hk(RecyclerView recyclerView, StableLinearLayoutManager stableLinearLayoutManager, View view, int i11, int i12) {
        if (recyclerView.indexOfChild(view) != -1) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (!(adapter == null || i12 == -1)) {
                adapter.notifyItemChanged(i12);
            }
            recyclerView.postDelayed(new v(stableLinearLayoutManager, i11, recyclerView), 200);
        }
    }

    public void i9(boolean z11) {
        OneKeyCollectView oneKeyCollectView = this.L0;
        if (oneKeyCollectView != null) {
            ViewUtil.m(oneKeyCollectView, !z11);
        }
    }

    public final boolean ij() {
        int f11 = ConfigPreferences.f("user_config", "config_home_market_contract_version");
        if (f11 > 0 && f11 == 2) {
            return false;
        }
        ConfigPreferences.k("user_config", "config_home_market_contract_version", 2);
        return true;
    }

    public void ik(View view) {
        nc.c.a("MT_TCP_Content_navigation", (HashMap<?, ?>) null);
        lj();
        this.f72898v0.setVisibility(8);
        this.D.setVisibility(0);
        this.f72898v0.g(true);
        this.f72871a0 = "TAB_CONTENT";
        this.O.setVisibility(8);
        this.A0.setVisibility(8);
        this.A.setVisibility(8);
        this.Y.setVisibility(8);
        this.N.setVisibility(8);
        this.J.setVisibility(8);
        this.f72901x.setVisibility(8);
        this.f72888o.setVisibility(8);
        this.f72889p.setVisibility(8);
        this.K.setVisibility(8);
        this.M.setVisibility(8);
        this.f72905z.setVisibility(8);
        this.f72903y.setVisibility(0);
        ((HomeMarketNewPresenter) yh()).r2();
        ((HomeMarketNewPresenter) yh()).A2();
        jj(this.U);
        jj(this.T);
        this.f72882l.setVisibility(8);
        ol.b.u("content");
        this.f72904y0.setIndex(this.S0);
        i9(true);
        this.f72872b0 = "content";
        ConfigPreferences.c("user_config", MarketContentGuideHelper.BUBBLE_MARKET_CONTENT_GUIDE, false);
    }

    public void initViews() {
        super.initViews();
        qj();
        this.J0 = (FrameLayout) this.f67460i.b(R$id.fl_body);
        this.f72898v0 = (SmartRefreshLayout) this.f67460i.b(R$id.home_market_refresh);
        this.f72904y0 = (MarketTitleLayout) this.f67460i.b(R$id.title_layout_market);
        this.F0 = (ImageView) this.f67460i.b(R$id.image_view_market_title_arrow_right);
        this.B0 = (ConstraintLayout) this.f67460i.b(R$id.constrain_layout_title_box);
        this.I0 = (HorizontalScrollView) this.f67460i.b(R$id.horizontal_scroll_market_title);
        this.Z = this.f67460i.b(R$id.market_square_view);
        this.O0 = getResources().getString(R$string.n_market_chance_title);
        this.P0 = getResources().getString(R$string.market_markets_collection);
        this.Q0 = getResources().getString(R$string.n_title_spot);
        this.R0 = getResources().getString(R$string.n_tab_contract);
        this.S0 = getResources().getString(R$string.n_market_square_title);
        this.T0 = getResources().getString(R$string.n_asset_contract_to_copy_trading);
        this.V0 = this.P0;
        pj();
        oj();
        this.f72894t0 = new SmartRefreshHeader(getActivity());
        this.f72896u0 = new SmartRefreshFooter(getActivity());
        this.f72898v0.i(true);
        this.f72898v0.V(false);
        this.f72898v0.j0(this.f72894t0);
        this.f72898v0.h0(this.f72896u0);
        this.f72882l = (LoadingLayout) this.f67460i.b(R$id.market_loading_layout);
        this.f72879i0 = LayoutInflater.from(getActivity()).inflate(R$layout.market_add_collection_empty_view, (ViewGroup) null);
        this.f72880j0 = LayoutInflater.from(getActivity()).inflate(R$layout.market_quick_news_add_collection_empty_view, (ViewGroup) null);
        LayoutInflater from = LayoutInflater.from(getActivity());
        int i11 = R$layout.common_empty_view;
        this.f72881k0 = from.inflate(i11, (ViewGroup) null);
        this.f72883l0 = LayoutInflater.from(getActivity()).inflate(i11, (ViewGroup) null);
        View view = this.f72879i0;
        int i12 = R$id.market_add_collection_ll;
        this.B = view.findViewById(i12);
        this.C = this.f72880j0.findViewById(i12);
        this.f72882l.setEmptyView(this.f72879i0);
        this.f72888o = (CommonTextListIndicator) this.f67460i.b(R$id.market_tab);
        this.f72889p = this.f67460i.b(R$id.market_header_divider);
        RecyclerView recyclerView = (RecyclerView) this.f67460i.b(R$id.market_collection_cointypes_rv);
        this.f72890q = recyclerView;
        recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        RecyclerView recyclerView2 = (RecyclerView) this.f67460i.b(R$id.market_collection_contract_rv);
        this.f72891r = recyclerView2;
        recyclerView2.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f72892s = (RecyclerView) this.f67460i.b(R$id.market_collection_watching_rv);
        View b11 = this.f67460i.b(R$id.market_contract_empty);
        this.f72893t = b11;
        this.f72895u = (TextView) b11.findViewById(R$id.tv_empty);
        this.f72897v = (RecyclerView) this.f67460i.b(R$id.market_contract_rv);
        this.f72899w = (RecyclerView) this.f67460i.b(R$id.market_usdt_contract_rv);
        this.J = (ViewGroup) this.f67460i.b(R$id.market_contract_layout);
        this.P = this.f67460i.b(R$id.market_option_rv);
        this.O = (MarketOptionTopView) this.f67460i.b(R$id.marketOptionTopView);
        this.M = this.f67460i.b(R$id.marketOptionTopLayout);
        this.N = this.f67460i.b(R$id.marketCollectionTopLayout);
        this.K = (MarketContractIndicator) this.f67460i.b(R$id.contractIndicator);
        this.L = (MarketCollectionIndicator) this.f67460i.b(R$id.collectionIndicator);
        this.f72906z0 = (ConstraintLayout) this.f67460i.b(R$id.constrain_layout_layout_market_contract_indicator_box_usdt);
        this.A0 = (ConstraintLayout) this.f67460i.b(R$id.constrain_layout_layout_market_contract_indicator_box);
        this.D0 = (RadioGroup) this.f67460i.b(R$id.radio_group_market_option_filter);
        this.C0 = (RadioGroup) this.f67460i.b(R$id.radio_group_market_option_filter_usdt);
        this.E0 = (ImageView) this.f67460i.b(R$id.image_view_market_contract_indicator_arrow_right);
        this.G0 = (HorizontalScrollView) this.f67460i.b(R$id.horizontal_scroll_view_market_filter);
        this.H0 = (HorizontalScrollView) this.f67460i.b(R$id.horizontal_scroll_view_market_filter_usdt);
        mj();
        vl.b bVar = new vl.b(getContext(), this.P);
        this.Q = bVar;
        bVar.v(this.O);
        this.O.setOptionOverviewLayout(this.Q);
        this.f72903y = this.f67460i.c(R$id.market_markets_search);
        this.f72902x0 = (MarketSkeletonView) this.f67460i.b(R$id.market_skeleton_view_contract);
        this.T = (ImageView) this.f67460i.b(R$id.market_edit_iv);
        this.U = (ImageView) this.f67460i.b(R$id.market_stare_iv);
        this.f72905z = (MarketSortLayout) this.f67460i.b(R$id.market_sort);
        this.A = (MarketSortLayout) this.f67460i.b(R$id.market_contract_sort);
        this.X = (LoadingLayout) this.f67460i.b(R$id.market_safeguard_layout);
        this.Y = (LoadingLayout) this.f67460i.b(R$id.market_filter_safeguard_layout);
        nj();
        a.f fVar = new a.f(ContractHeaderViewHandler.class.hashCode());
        int i13 = R$drawable.market_divider;
        this.R = fVar.i(i13).h(false).g();
        this.S = new a.f(ContractHeaderViewHandler.class.hashCode()).i(i13).h(false).g();
        this.f72885m0 = new StableLinearLayoutManager(getActivity(), 1, false);
        this.f72887n0 = new StableLinearLayoutManager(getActivity(), 1, false);
        this.f72890q.setLayoutManager(this.f72885m0);
        this.f72891r.setLayoutManager(this.f72887n0);
        this.f72892s.setLayoutManager(new StableLinearLayoutManager(getActivity(), 1, false));
        this.f72897v.setLayoutManager(new StableLinearLayoutManager(getActivity(), 1, false));
        this.f72897v.addItemDecoration(this.R);
        this.f72899w.setLayoutManager(new StableLinearLayoutManager(getActivity(), 1, false));
        this.f72899w.addItemDecoration(this.S);
        ViewPager viewPager = (ViewPager) this.f67460i.b(R$id.market_vp);
        this.f72901x = viewPager;
        viewPager.setOffscreenPageLimit(6);
        ViewPagerHelper.a(this.f72888o, this.f72901x);
        MarketSkeletonView marketSkeletonView = (MarketSkeletonView) this.f67460i.b(R$id.market_skeleton_view_index_market);
        this.f72900w0 = marketSkeletonView;
        marketSkeletonView.showSkeleton();
        this.D = this.f67460i.b(R$id.layContent);
        this.E = (CoIndicator) this.f67460i.b(R$id.coIndicator);
        this.G = (ImageView) this.f67460i.b(R$id.iv_notive_setting);
        this.H = (ImageView) this.f67460i.b(R$id.iv_notice_mask);
        this.K0 = (LoadingLayout) this.f67460i.b(R$id.contentLoadingView);
        this.G.setOnClickListener(new ul.f(this));
        this.F = (ViewPager2) this.f67460i.b(R$id.vpContent);
        if (com.hbg.module.libkt.base.ext.b.e(getActivity())) {
            ((HomeMarketNewPresenter) yh()).k2();
        }
        this.V = (AppCompatImageView) this.f67460i.b(R$id.aiv_back);
        if (getActivity() instanceof MarketContainerActivity) {
            this.V.setVisibility(0);
        } else {
            this.V.setVisibility(8);
        }
        this.V.setOnClickListener(new h0(this));
    }

    public void jh() {
    }

    public final void jj(View view) {
        view.animate().setDuration(100).alpha(0.0f);
        view.setClickable(false);
        view.setVisibility(8);
    }

    public void jk() {
        i6.d.e("tab", "selectContract ---");
        lj();
        this.f72898v0.setVisibility(0);
        this.f72898v0.g(false);
        this.A.setVisibility(0);
        this.Y.setVisibility(8);
        this.f72890q.setVisibility(8);
        this.f72891r.setVisibility(8);
        this.f72892s.setVisibility(8);
        this.J.setVisibility(0);
        this.f72901x.setVisibility(8);
        this.f72888o.setVisibility(8);
        this.f72889p.setVisibility(8);
        this.f72905z.setVisibility(8);
        this.K.setVisibility(0);
        this.L.setVisibility(8);
        this.M.setVisibility(0);
        this.D.setVisibility(8);
        this.f72903y.setVisibility(0);
        this.N.setVisibility(8);
        jj(this.U);
        jj(this.T);
        this.f72882l.setEmptyView(this.f72883l0);
        ((HomeMarketNewPresenter) yh()).r2();
        ol.b.u("contract");
        if (this.K.getCurrentFutureTab() == 2) {
            ck();
            MarketSkeletonView marketSkeletonView = this.f72902x0;
            if (marketSkeletonView != null && marketSkeletonView.showing()) {
                this.f72902x0.post(new w(this));
            }
        } else if (this.K.getCurrentFutureTab() == 0) {
            dk();
            MarketSkeletonView marketSkeletonView2 = this.f72902x0;
            if (marketSkeletonView2 != null && marketSkeletonView2.showing()) {
                this.f72902x0.post(new y(this));
            }
        } else {
            bk();
            MarketSkeletonView marketSkeletonView3 = this.f72902x0;
            if (marketSkeletonView3 != null && marketSkeletonView3.showing()) {
                this.f72902x0.post(new x(this));
            }
        }
        i9(true);
        this.f72904y0.setIndex(this.R0);
        i9(true);
        this.f72872b0 = "contract";
        String e11 = ConfigPreferences.e("user_config", "config_market_sec_tab_contract_memory_content", "0");
        this.f72873c0 = e11;
        if (e11.equals("1")) {
            this.f72874d0 = ConfigPreferences.e("user_config", "config_market_third_tab_contract_memory_content", "");
        } else {
            this.f72874d0 = "";
        }
        if (this.f72873c0.equals("0")) {
            this.f72875e0 = ConfigPreferences.e("user_config", "config_market_third_tab_usdt_contract_memory_content", "");
        } else {
            this.f72875e0 = "";
        }
        ConfigPreferences.m("user_config", "config_market_top_tab_memory_content", "contract");
    }

    public final void kj() {
        if (this.f72878h0) {
            this.f72882l.setVisibility(8);
        }
    }

    public int kk() {
        int i11 = -1;
        if ("TAB_ALL".equals(this.f72871a0)) {
            if (this.f72888o.getList() == null) {
                return -1;
            }
            i11 = 0;
            while (true) {
                if (i11 >= this.f72888o.getList().size()) {
                    i11 = 0;
                    break;
                } else if ("usdt".equalsIgnoreCase(this.f72888o.getList().get(i11))) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 < 0 || i11 >= this.f72888o.getList().size()) {
                i11 = 0;
            }
            this.f72901x.setCurrentItem(i11);
            this.f72888o.c(i11);
            this.f72888o.b(i11, 0.0f, 0);
        }
        return i11;
    }

    public void l5() {
        if (this.D0 != null && r6().equals("TAB_CONTRACT")) {
            gj(MarketModuleConfig.a().C(), this.Y, 0);
        }
    }

    public void l8() {
        this.f72905z.m();
        this.A.m();
    }

    public final void lj() {
        if (this.U0 != null) {
            getChildFragmentManager().q().q(this.U0).k();
            this.Z.setVisibility(8);
        }
    }

    public final void lk() {
        if (yh() != null && ((HomeMarketNewPresenter) yh()).H1() != null) {
            for (Fragment next : ((HomeMarketNewPresenter) yh()).H1()) {
                if (next != null && (next instanceof MarketCoinFragment)) {
                    MarketCoinFragment marketCoinFragment = (MarketCoinFragment) next;
                    if (marketCoinFragment.Sh()) {
                        marketCoinFragment.uh(false);
                    }
                }
            }
        }
    }

    public final void mj() {
        this.E0.setOnClickListener(new ul.g(this));
        HorizontalScrollView horizontalScrollView = this.G0;
        if (horizontalScrollView != null && Build.VERSION.SDK_INT >= 23) {
            horizontalScrollView.setOnScrollChangeListener(new k(this));
        }
        HorizontalScrollView horizontalScrollView2 = this.H0;
        if (horizontalScrollView2 != null && Build.VERSION.SDK_INT >= 23) {
            horizontalScrollView2.setOnScrollChangeListener(new m(this));
        }
    }

    public final void mk(View view) {
        view.setVisibility(0);
        view.animate().setDuration(100).alpha(1.0f);
        view.setClickable(true);
    }

    public final void nj() {
        ((ImageView) this.Y.findViewById(R$id.error_img)).setImageResource(R$drawable.trade_liquidating);
        ((TextView) this.Y.findViewById(R$id.error_tip)).setText(R$string.contract_trade_safeguard);
    }

    public final void nk(String str) {
        i6.d.e("tab", "showCollectionTab == " + str);
        if ("100".equals(str)) {
            MarketContentGuideHelper.getInstance().showMarketStareGuide(this, this.U, (DialogInterface.OnDismissListener) null);
        }
        this.f72898v0.W(true);
        this.f72898v0.a(true);
        this.f72898v0.g(true);
        this.f72898v0.i(true);
        if (str.equals("100")) {
            this.f72890q.setVisibility(0);
            this.f72891r.setVisibility(8);
            this.f72892s.setVisibility(8);
            if (!((HomeMarketNewPresenter) yh()).N1()) {
                i9(false);
            }
        } else if (str.equals(JumioRejectReason.DIGITAL_COPY)) {
            this.f72890q.setVisibility(8);
            this.f72891r.setVisibility(0);
            this.f72892s.setVisibility(8);
            i9(true);
        } else if (str.equals("101")) {
            this.f72890q.setVisibility(8);
            this.f72891r.setVisibility(8);
            this.f72892s.setVisibility(0);
            this.f72898v0.g(true);
            this.f72898v0.b0(new d0(this));
            this.f72905z.setVisibility(8);
            i9(true);
        } else if (str.equals(JumioRejectReason.BLACK_WHITE_COPY)) {
            this.f72890q.setVisibility(0);
            this.f72891r.setVisibility(8);
            this.f72892s.setVisibility(8);
            this.f72905z.setVisibility(8);
            i9(true);
        }
    }

    public final void oj() {
        this.X0.clear();
        this.X0.add(this.P0);
        this.X0.add(this.Q0);
        if (gj.d.n().E()) {
            this.X0.add(this.R0);
        }
        if (rj()) {
            this.X0.add(this.O0);
        }
        this.X0.add(this.S0);
        this.X0.add(this.T0);
        MarketTitleLayout marketTitleLayout = this.f72904y0;
        Resources resources = getResources();
        int i11 = R$dimen.dimen_8;
        marketTitleLayout.setItemPaddingLeft(resources.getDimensionPixelOffset(i11));
        this.f72904y0.setItemPaddingRight(getResources().getDimensionPixelOffset(i11));
        MarketTitleLayout marketTitleLayout2 = this.f72904y0;
        Resources resources2 = getResources();
        int i12 = R$dimen.dimen_18;
        marketTitleLayout2.setNormalTextSize((float) resources2.getDimensionPixelSize(i12));
        this.f72904y0.setSelectedTextSize((float) getResources().getDimensionPixelSize(i12));
        this.f72904y0.setNormalColor(getResources().getColor(R$color.baseColorSecondaryText));
        this.f72904y0.setSelectedColor(getResources().getColor(R$color.baseColorPrimaryText));
        this.f72904y0.setTitles((List<?>) this.X0, -1, 16);
        if (!SPUtil.g("hot_coin_guide_showed", false)) {
            this.f72904y0.showHidePoint(true, this.O0);
        }
        MarketBuriedHelper.a().f(MarketBuriedHelper.MarketBuried.OPTIONAL);
        this.f72904y0.setTitleListener(new a());
    }

    public void ok(List<ContractTagInfo.TagsGroupInfo.TagInfo> list) {
        this.D0.removeAllViews();
        RadioButton radioButton = (RadioButton) LayoutInflater.from(getActivity()).inflate(R$layout.layout_market_filter_item, (ViewGroup) null);
        if (Build.VERSION.SDK_INT >= 23) {
            radioButton.setTextAppearance(R$style.marketFilter);
        }
        radioButton.setText(getResources().getString(R$string.market_title_table_all));
        radioButton.setTag("-1");
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-2, -2);
        Resources resources = getResources();
        int i11 = R$dimen.dimen_10;
        layoutParams.topMargin = resources.getDimensionPixelSize(i11);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(i11);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R$dimen.dimen_16);
        this.D0.addView(radioButton, layoutParams);
        radioButton.setOnCheckedChangeListener(new n(this));
        int size = list != null ? list.size() : 0;
        boolean isChineseLanguage = AppLanguageHelper.getInstance().isChineseLanguage();
        for (int i12 = 0; i12 < size; i12++) {
            ContractTagInfo.TagsGroupInfo.TagInfo tagInfo = list.get(i12);
            RadioButton radioButton2 = (RadioButton) LayoutInflater.from(getActivity()).inflate(R$layout.layout_market_filter_item, (ViewGroup) null);
            if (Build.VERSION.SDK_INT >= 23) {
                radioButton2.setTextAppearance(R$style.marketFilter);
            }
            if (isChineseLanguage) {
                radioButton2.setText(tagInfo.h());
            } else {
                radioButton2.setText(tagInfo.i());
            }
            radioButton2.setTag(tagInfo.b());
            RadioGroup.LayoutParams layoutParams2 = new RadioGroup.LayoutParams(-2, -2);
            Resources resources2 = getResources();
            int i13 = R$dimen.dimen_10;
            layoutParams2.topMargin = resources2.getDimensionPixelSize(i13);
            layoutParams2.bottomMargin = getResources().getDimensionPixelSize(i13);
            Resources resources3 = getResources();
            int i14 = R$dimen.dimen_16;
            layoutParams2.leftMargin = resources3.getDimensionPixelSize(i14);
            if (i12 == size - 1) {
                layoutParams2.rightMargin = getResources().getDimensionPixelOffset(i14);
            }
            this.D0.addView(radioButton2, layoutParams2);
            radioButton2.setOnCheckedChangeListener(new ul.p(this, tagInfo));
        }
        Ti();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (BaseModuleConfig.a() != null) {
            BaseModuleConfig.a().o0("huobiapp_market_market_favorite_currency_end");
            BaseModuleConfig.a().o0("huobiapp_market_market_favorite_ai_end");
            BaseModuleConfig.a().o0("huobiapp_market_market_favorite_news_end");
            BaseModuleConfig.a().o0("huobiapp_market_market_spot_end");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        q.b().a(this.W0);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
        MarketModuleConfig.a().U(getActivity());
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        q.b().e(this.W0);
    }

    @k20.h
    public void onEvent(MarketCoinThirdTabClick marketCoinThirdTabClick) {
        i6.d.e("tab", "onEvent ----- " + marketCoinThirdTabClick.getId() + " " + marketCoinThirdTabClick.getMCurrentQuoteTab());
        try {
            this.f72874d0 = String.valueOf(marketCoinThirdTabClick.getId());
            String upperCase = marketCoinThirdTabClick.getMCurrentQuoteTab().toUpperCase();
            ConfigPreferences.l("user_config", "config_market_third_tab_memory_content" + upperCase, marketCoinThirdTabClick.getId().longValue());
            MarketBuriedHelper.a().g(this.f72874d0);
            MarketBuriedHelper.a().c();
        } catch (Exception e11) {
            i6.d.g(e11);
        }
        fk(2);
    }

    public void p5(v9.a<ml.b> aVar) {
        this.f72890q.setAdapter(aVar);
    }

    public void pf(boolean z11) {
        ImageView imageView = (ImageView) this.f72882l.findViewById(R$id.error_img);
        TextView textView = (TextView) this.f72882l.findViewById(R$id.error_tip);
        if (z11) {
            imageView.setImageResource(R$drawable.trade_liquidating);
            textView.setText(R$string.contract_trade_safeguard);
        } else {
            imageView.setImageResource(R$drawable.common_no_network_icon);
            textView.setText(R$string.common_no_internet_access);
        }
        this.f72905z.setVisibility(8);
        this.f72882l.k();
        this.f72900w0.dismissSkeleton();
        this.f72882l.setVisibility(0);
        this.f72878h0 = false;
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
        if (yh() != null) {
            ((HomeMarketNewPresenter) yh()).q2((List<String>) null);
        }
        return layoutInflater.inflate(R$layout.fragment_home_market_new, viewGroup, false);
    }

    public final void pj() {
        this.F0.setOnClickListener(new b0(this));
        HorizontalScrollView horizontalScrollView = this.I0;
        if (horizontalScrollView != null && Build.VERSION.SDK_INT >= 23) {
            horizontalScrollView.setOnScrollChangeListener(new l(this));
        }
    }

    public final void pk() {
        this.f72871a0 = "TAB_SQUARE";
        this.Z.setVisibility(0);
        try {
            FragmentTransaction q11 = getChildFragmentManager().q();
            if (this.U0 == null) {
                this.U0 = new MarketSquareFlutterFragment();
            }
            if (!this.U0.isAdded()) {
                q11.c(R$id.market_square_view, this.U0, MarketSquareFlutterFragment.class.getName());
            }
            if (this.U0.isHidden()) {
                q11.A(this.U0);
            }
            q11.k();
        } catch (Throwable th2) {
            i6.d.g(th2);
        }
    }

    public final void qj() {
        View b11 = this.f67460i.b(R$id.market_page_status_bar);
        ViewGroup.LayoutParams layoutParams = b11.getLayoutParams();
        if (getActivity() instanceof MarketContainerActivity) {
            layoutParams.height = 0;
        } else {
            layoutParams.height = BaseActivity.getStatusBarHeight(b11.getContext());
        }
        b11.setLayoutParams(layoutParams);
    }

    public void qk(List<ContractTagInfo.TagsGroupInfo.TagInfo> list) {
        this.C0.removeAllViews();
        RadioButton radioButton = (RadioButton) LayoutInflater.from(getActivity()).inflate(R$layout.layout_market_filter_item, (ViewGroup) null);
        if (Build.VERSION.SDK_INT >= 23) {
            radioButton.setTextAppearance(R$style.marketFilter);
        }
        radioButton.setText(getResources().getString(R$string.market_title_table_all));
        radioButton.setTag("-1");
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-2, -2);
        Resources resources = getResources();
        int i11 = R$dimen.dimen_10;
        layoutParams.topMargin = resources.getDimensionPixelSize(i11);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(i11);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R$dimen.dimen_16);
        this.C0.addView(radioButton, layoutParams);
        radioButton.setOnCheckedChangeListener(new o(this));
        boolean isChineseLanguage = AppLanguageHelper.getInstance().isChineseLanguage();
        int size = list != null ? list.size() : 0;
        for (int i12 = 0; i12 < size; i12++) {
            ContractTagInfo.TagsGroupInfo.TagInfo tagInfo = list.get(i12);
            RadioButton radioButton2 = (RadioButton) LayoutInflater.from(getActivity()).inflate(R$layout.layout_market_filter_item, (ViewGroup) null);
            if (Build.VERSION.SDK_INT >= 23) {
                radioButton2.setTextAppearance(R$style.marketFilter);
            }
            if (isChineseLanguage) {
                radioButton2.setText(tagInfo.h());
            } else {
                radioButton2.setText(tagInfo.i());
            }
            radioButton2.setTag(tagInfo.b());
            RadioGroup.LayoutParams layoutParams2 = new RadioGroup.LayoutParams(-2, -2);
            Resources resources2 = getResources();
            int i13 = R$dimen.dimen_10;
            layoutParams2.topMargin = resources2.getDimensionPixelSize(i13);
            layoutParams2.bottomMargin = getResources().getDimensionPixelSize(i13);
            Resources resources3 = getResources();
            int i14 = R$dimen.dimen_16;
            layoutParams2.leftMargin = resources3.getDimensionPixelSize(i14);
            if (i12 == size - 1) {
                layoutParams2.rightMargin = getResources().getDimensionPixelOffset(i14);
            }
            this.C0.addView(radioButton2, layoutParams2);
            radioButton2.setOnCheckedChangeListener(new r(this, tagInfo));
        }
        Ui();
    }

    public String r6() {
        return this.f72871a0;
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void refreshContractTag(ContractTagEvent contractTagEvent) {
        qk(com.huobi.utils.w.d().e(true));
        ok(com.huobi.utils.w.d().e(false));
    }

    public final boolean rj() {
        try {
            return ((MgtSquareBean) AppConfigManager.c(MgtConfigNumber.MARKET_SQUARE_PERCENT.number, MgtSquareBean.class)).isHuidu();
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void rk(String str, String str2) {
        ((HomeMarketNewPresenter) yh()).v2(str, str2);
        ((HomeMarketNewPresenter) yh()).u2(str, str2);
        ((HomeMarketNewPresenter) yh()).w2(str, str2);
        ((HomeMarketNewPresenter) yh()).x2(str, str2);
    }

    public void s7(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.f72888o.setVisibility(8);
            return;
        }
        this.f72888o.setDataList(list);
        this.f72888o.setVisibility(0);
    }

    public void s9(boolean z11) {
        MarketSkeletonView marketSkeletonView;
        MarketSkeletonView marketSkeletonView2;
        if (!z11) {
            if (this.f72900w0.showing()) {
                if ((!"TAB_ALL".equals(this.f72871a0) && !"TAB_HADAX".equals(this.f72871a0) && !"TAB_MAIN".equals(this.f72871a0)) || (marketSkeletonView = this.f72900w0) == null) {
                    this.f72900w0.dismissSkeleton();
                } else if (marketSkeletonView.getHasLoadData()) {
                    this.f72900w0.dismissSkeleton();
                }
            }
            if (this.f72902x0.showing()) {
                this.f72902x0.dismissSkeleton();
                if ("TAB_OPTION".equals(r6()) && ((HomeMarketNewPresenter) yh()).B1().f() && this.O.getVisibility() == 8) {
                    this.O.setVisibility(0);
                }
            }
            if (!"TAB_COLLECTION".equals(this.f72871a0)) {
                return;
            }
            if ("100".equals(bh()) && (this.f72890q.getAdapter() == null || this.f72890q.getAdapter().getItemCount() == 0)) {
                c3();
            } else if (!JumioRejectReason.DIGITAL_COPY.equals(bh())) {
            } else {
                if (this.f72891r.getAdapter() == null || this.f72891r.getAdapter().getItemCount() == 0) {
                    c3();
                }
            }
        } else if ("TAB_ALL".equals(this.f72871a0) && (marketSkeletonView2 = this.f72900w0) != null && !marketSkeletonView2.getHasLoadData()) {
            this.f72900w0.showSkeleton();
        } else if ("TAB_OPTION".equals(r6()) || "TAB_CONTRACT".equals(r6()) || "TAB_USDT_CONTRACT".equals(r6()) || "TAB_CONTENT".equals(r6())) {
            this.f72902x0.showSkeleton();
            if ("TAB_OPTION".equals(r6())) {
                this.O.setVisibility(8);
                this.f72902x0.post(new a0(this));
                return;
            }
            this.f72902x0.post(new z(this));
        }
    }

    public void showLoading() {
        MarketSkeletonView marketSkeletonView = this.f72900w0;
        if (marketSkeletonView != null && !marketSkeletonView.getHasLoadData()) {
            this.f72900w0.showSkeleton();
        }
        this.f72878h0 = false;
    }

    public final void showSkeleton() {
        if (!this.f72900w0.getHasLoadData()) {
            this.f72900w0.showSkeleton();
        }
    }

    public final void sj() {
        NewsHomeFragment newsHomeFragment;
        ArrayList<Fragment> c11;
        Class<xe.f> cls = xe.f.class;
        try {
            Bundle arguments = getArguments();
            if (arguments.getBoolean("isFromJump")) {
                int intValue = Integer.valueOf(arguments.getString("typeView")).intValue();
                String string = arguments.getString("category");
                List<TabData> list = this.M0;
                if (list != null && list.size() > 0) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= this.M0.size()) {
                            i11 = 0;
                            break;
                        } else if (this.M0.get(i11).getTabId() == intValue) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (RankScreenBean.SCREEN_VALUE_SPOT.equals(this.f72872b0)) {
                        lk();
                    }
                    arguments.remove("isFromJump");
                    arguments.remove("typeView");
                    arguments.remove("category");
                    if (this.f72904y0.getChildCount() > 0) {
                        ik(this.f72904y0.getChildAt(this.X0.size() - 1));
                    } else {
                        ik((View) null);
                    }
                    this.F.setCurrentItem(i11, false);
                    if (this.F.getAdapter() != null && this.F.getAdapter().getItemCount() > 0) {
                        if (intValue == 0) {
                            if (!(this.F.getAdapter() == null || (c11 = ((he.a) this.F.getAdapter()).c()) == null || c11.size() <= i11)) {
                                Fragment fragment = c11.get(i11);
                                if (fragment instanceof H5Fragment) {
                                    ((H5Fragment) fragment).gi(BaseModuleConfig.a().o(string));
                                }
                            }
                        } else if (intValue == 1) {
                            we.b.l("pageJump", cls).g(new xe.f("newsPage", Integer.parseInt(string)));
                        } else if (intValue == 3) {
                            we.b.l("pageJump", cls).g(new xe.f("deepNewsPage", Integer.parseInt(string)));
                        }
                    }
                    MarketBuriedHelper.a().f(MarketBuriedHelper.MarketBuried.CONTENT);
                }
            } else {
                String string2 = arguments.getString("type");
                int i12 = arguments.getInt("child_action", -1);
                if (!com.hbg.module.libkt.base.ext.b.x(string2) && "news".equals(string2)) {
                    if (RankScreenBean.SCREEN_VALUE_SPOT.equals(this.f72872b0)) {
                        lk();
                    }
                    arguments.remove("type");
                    if (this.f72904y0.getChildCount() > 0) {
                        ik(this.f72904y0.getChildAt(this.X0.size() - 1));
                    } else {
                        ik((View) null);
                    }
                    if (this.F.getAdapter() != null && this.F.getAdapter().getItemCount() > 0) {
                        this.F.setCurrentItem(((HomeMarketNewPresenter) yh()).w1(this.M0, 1), false);
                    }
                    MarketBuriedHelper.a().f(MarketBuriedHelper.MarketBuried.CONTENT);
                } else if (!com.hbg.module.libkt.base.ext.b.x(string2) && TUIConstants.TUIChat.NOTICE.equals(string2)) {
                    if (RankScreenBean.SCREEN_VALUE_SPOT.equals(this.f72872b0)) {
                        lk();
                    }
                    arguments.remove("type");
                    if (this.f72904y0.getChildCount() > 0) {
                        ik(this.f72904y0.getChildAt(this.X0.size() - 1));
                    } else {
                        ik((View) null);
                    }
                    if (this.F.getAdapter() != null && this.F.getAdapter().getItemCount() > 0) {
                        this.F.setCurrentItem(((HomeMarketNewPresenter) yh()).w1(this.M0, 0), false);
                    }
                    MarketBuriedHelper.a().f(MarketBuriedHelper.MarketBuried.CONTENT);
                } else if (i12 != -1) {
                    arguments.remove("child_action");
                    if (i12 == 40) {
                        if (this.f72904y0.getChildCount() > 0) {
                            ik(this.f72904y0.getChildAt(this.X0.size() - 1));
                        } else {
                            ik((View) null);
                        }
                        if (this.F.getAdapter() != null && this.F.getAdapter().getItemCount() > 1) {
                            this.F.setCurrentItem(((HomeMarketNewPresenter) yh()).w1(this.M0, 2), false);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (RankScreenBean.SCREEN_VALUE_SPOT.equals(this.f72872b0) && (newsHomeFragment = this.I) != null) {
            newsHomeFragment.ji(true);
        }
    }

    public MarketSortLayout td() {
        return this.A;
    }

    public void u7(boolean z11) {
        ImageView imageView = (ImageView) this.X.findViewById(R$id.error_img);
        TextView textView = (TextView) this.X.findViewById(R$id.error_tip);
        TextView textView2 = (TextView) this.X.findViewById(R$id.error_title);
        TextView textView3 = (TextView) this.X.findViewById(R$id.error_tip2);
        View findViewById = this.X.findViewById(R$id.viewErrorRetry);
        if (z11) {
            textView2.setVisibility(0);
            findViewById.setVisibility(8);
            imageView.setImageResource(R$drawable.trade_liquidating);
            textView2.setText(R$string.contract_trade_safeguard);
            if ("TAB_CONTRACT".equals(r6())) {
                textView3.setVisibility(0);
                long Y2 = MarketModuleConfig.a().Y();
                long T2 = MarketModuleConfig.a().T();
                textView.setText(String.format(getString(R$string.n_delivery_contract_maintenance_tips), new Object[]{DateTimeUtils.h(Y2, "yyyy/MM/dd HH:mm")}));
                textView3.setText(String.format(getString(R$string.n_swap_contract_maintenance_tips), new Object[]{DateTimeUtils.h(T2, "yyyy/MM/dd HH:mm")}));
            } else if ("TAB_USDT_CONTRACT".equals(r6())) {
                textView3.setVisibility(8);
                textView.setText(String.format(getString(R$string.n_contract_maintenance_tips), new Object[]{DateTimeUtils.h(MarketModuleConfig.a().p(), "yyyy/MM/dd HH:mm")}));
            } else if ("TAB_OPTION".equals(r6())) {
                textView3.setVisibility(8);
                textView.setText(String.format(getString(R$string.n_contract_maintenance_tips), new Object[]{DateTimeUtils.h(MarketModuleConfig.a().W(), "yyyy/MM/dd HH:mm")}));
            }
        } else {
            findViewById.setVisibility(0);
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            imageView.setImageResource(R$drawable.common_no_network_icon);
            textView.setText(R$string.common_no_internet_access);
        }
        this.O.setVisibility(8);
        this.f72882l.setVisibility(8);
        this.X.k();
        this.A.setVisibility(8);
        this.f72902x0.dismissSkeleton();
        this.X.setVisibility(0);
        this.f72878h0 = false;
    }

    public void uh(boolean z11) {
        MarketCoinFragment marketCoinFragment;
        super.uh(z11);
        i6.d.e("tab", "HomeMarketNewFragmentHomeMarketNewFragment onVisibleChangedFinal == " + z11 + " mTab:" + this.f72871a0 + " isVisibleToUser:" + this.f67463e + " isCanBeSeen:" + isCanBeSeen() + " realHidden:" + vh() + " isVisible:" + isVisible() + " isResumed:" + isResumed());
        int i11 = 0;
        if (!z11) {
            this.f72898v0.finishRefresh();
            if ("TAB_OPTION".equals(r6()) || "TAB_CONTRACT".equals(r6()) || "TAB_USDT_CONTRACT".equals(r6())) {
                MarketSkeletonView marketSkeletonView = this.f72902x0;
                if (marketSkeletonView != null && marketSkeletonView.showing()) {
                    this.f72902x0.cancelAnim();
                }
            } else {
                MarketSkeletonView marketSkeletonView2 = this.f72900w0;
                if (marketSkeletonView2 != null && marketSkeletonView2.showing()) {
                    this.f72900w0.cancelAnim();
                }
            }
            NewsHomeFragment newsHomeFragment = this.I;
            if (newsHomeFragment != null) {
                newsHomeFragment.ji(false);
            }
            if (!this.f67463e) {
                Activity b11 = oa.a.g().b();
                if (b11 != null && b11.getClass().getName().contains("HuobiMainActivity")) {
                    try {
                        if (!getClass().getName().equals(MarketModuleConfig.a().h0().getClass().getName())) {
                            q.b().f((String) null, -1);
                        }
                    } catch (Throwable th2) {
                        i6.d.g(th2);
                    }
                } else if (b11 == null || !b11.getClass().getName().contains("StartFlashActivity")) {
                    q.b().f((String) null, -1);
                }
            }
        } else {
            ClosePathFloatView.g((String) null, getActivity(), false);
            if ("TAB_OPTION".equals(r6()) || "TAB_CONTRACT".equals(r6()) || "TAB_USDT_CONTRACT".equals(r6())) {
                MarketSkeletonView marketSkeletonView3 = this.f72902x0;
                if (marketSkeletonView3 != null && marketSkeletonView3.getVisibility() == 0 && !this.f72902x0.getHasLoadData()) {
                    this.f72902x0.showSkeleton();
                }
            } else {
                MarketSkeletonView marketSkeletonView4 = this.f72900w0;
                if (marketSkeletonView4 != null && marketSkeletonView4.getVisibility() == 0 && !this.f72900w0.getHasLoadData()) {
                    this.f72900w0.showSkeleton();
                }
            }
            Observable.timer(1200, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new h());
            MarketModuleConfig.a().U(getActivity());
            ((HomeMarketNewPresenter) yh()).s2(getArguments());
            if (!TextUtils.isEmpty(((HomeMarketNewPresenter) yh()).z1("primaryTitle"))) {
                String z12 = ((HomeMarketNewPresenter) yh()).z1("primaryTitle");
                String z13 = ((HomeMarketNewPresenter) yh()).z1("secondaryTitle");
                String z14 = ((HomeMarketNewPresenter) yh()).z1("filter");
                String z15 = ((HomeMarketNewPresenter) yh()).z1("sortType");
                String z16 = ((HomeMarketNewPresenter) yh()).z1("sort");
                if ("1".equalsIgnoreCase(z12)) {
                    if (!TextUtils.isEmpty(z15) && !TextUtils.isEmpty(z16)) {
                        this.f72905z.k(z15, z16);
                        l8();
                    }
                    i6.d.e("tab", "selectCollection --- 1");
                    if (TextUtils.equals(StringUtils.g(z13), "usdt")) {
                        ConfigPreferences.m("user_config", "config_collection_market_sec_tab_memory_content", "100");
                        this.L.z(0);
                    } else if (TextUtils.equals(StringUtils.g(z13), "usdt_future")) {
                        ConfigPreferences.m("user_config", "config_collection_market_sec_tab_memory_content", JumioRejectReason.DIGITAL_COPY);
                        this.L.z(gj.d.n().E() ? 1 : 0);
                    }
                    Ia();
                    ((HomeMarketNewPresenter) yh()).n1();
                } else if ("2".equalsIgnoreCase(z12)) {
                    T7();
                    if (!TextUtils.isEmpty(z13) && this.f72888o.getList() != null && !this.f72888o.getList().isEmpty()) {
                        int i12 = 0;
                        while (true) {
                            if (i12 >= this.f72888o.getList().size()) {
                                break;
                            } else if (z13.equalsIgnoreCase(this.f72888o.getList().get(i12))) {
                                this.f72901x.setCurrentItem(i12);
                                this.f72888o.c(i12);
                                this.f72888o.b(i12, 0.0f, 0);
                                break;
                            } else {
                                i12++;
                            }
                        }
                    }
                    ViewPager viewPager = this.f72901x;
                    if (viewPager != null && (viewPager.getAdapter() instanceof zg.b)) {
                        zg.b bVar = (zg.b) this.f72901x.getAdapter();
                        while (true) {
                            if (i11 < bVar.getCount()) {
                                if ((bVar.getItem(i11) instanceof MarketCoinFragment) && (marketCoinFragment = (MarketCoinFragment) bVar.getItem(i11)) != null && marketCoinFragment.yh() != null && z13.equalsIgnoreCase(((MarketCoinPresenter) marketCoinFragment.yh()).z0())) {
                                    marketCoinFragment.Lh();
                                    break;
                                }
                                i11++;
                            } else {
                                break;
                            }
                        }
                    }
                } else if ("3".equalsIgnoreCase(z12)) {
                    if ("usdt_future".equalsIgnoreCase(z13)) {
                        this.K.y(0);
                    } else if ("contract_future".equalsIgnoreCase(z13)) {
                        this.K.y(1);
                        int l02 = i6.m.l0(z14, -1);
                        if (l02 >= 0) {
                            ConfigPreferences.k("user_config", "config_home_market_contractindex", l02);
                        }
                    }
                    if (!TextUtils.isEmpty(z15) && !TextUtils.isEmpty(z16)) {
                        this.A.k(z15, z16);
                        l8();
                    }
                    jk();
                    ((HomeMarketNewPresenter) yh()).n1();
                }
            }
            List<TabData> list = this.M0;
            if (list != null && list.size() > 0) {
                sj();
            }
        }
        if (this.L0 != null && "TAB_COLLECTION".equals(this.f72871a0)) {
            this.L0.e(z11);
        }
    }

    public void vd(MarketRedData marketRedData) {
        this.L.A(marketRedData.moniterCount > 0, getContext().getString(R$string.n_market_intelligent_stare));
        this.f72904y0.showHidePoint(p.e().f().displayCollectionRed(), this.P0);
        this.f72904y0.showHidePoint(p.e().f().displayContentTabRed(), this.S0);
    }

    public void w8(String str, String str2) {
        q.b().f((String) null, -1);
        rk(str, str2);
        this.A.m();
    }

    public void xb(v9.a<s9.a> aVar) {
        this.f72897v.setAdapter(aVar);
    }
}
