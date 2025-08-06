package com.huobi.index.presenter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.viewpager.widget.ViewPager;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ThreadUtils;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.controller.FutureProductInfoController;
import com.hbg.lib.data.symbol.SuperMarginSymbolConfigUtil;
import com.hbg.lib.data.symbol.SymbolsDataProvider;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.Favorite;
import com.hbg.lib.network.hbg.core.bean.HbgSymbolPrice;
import com.hbg.lib.network.hbg.core.bean.HomeCommonData;
import com.hbg.lib.network.hbg.core.bean.HomePageBizData;
import com.hbg.lib.network.hbg.core.bean.HomePageData;
import com.hbg.lib.network.hbg.core.bean.HomePageEarnData;
import com.hbg.lib.network.hbg.core.bean.HomePageInvestData;
import com.hbg.lib.network.hbg.core.bean.HomePageJumpData;
import com.hbg.lib.network.hbg.core.bean.HomePageNewUserGiftBagData;
import com.hbg.lib.network.hbg.core.bean.HomePageNoticeData;
import com.hbg.lib.network.hbg.core.bean.LiveAppointmentData;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.lib.network.hbg.core.bean.RankList;
import com.hbg.lib.network.hbg.core.bean.RankListItemBean;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.hbg.core.bean.UnreadCountData;
import com.hbg.lib.network.hbg.core.bean.UserOtcCoupon;
import com.hbg.lib.network.hbg.core.bean.UserRegistryTransferGuide;
import com.hbg.lib.network.hbg.core.bean.VipInfoResult;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.hbg.retrofit.service.HbgService;
import com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.network.uc.retrofit.bean.MessageNoReadNum;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.IndexTextListIndicator;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.livesquare.utils.LiveTrackUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.account.entity.HomeActivityEntityResponse;
import com.huobi.apm.TimeMonitorManager;
import com.huobi.app.H5CacheServiceHelper;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.entity.HomeActivityEntity;
import com.huobi.finance.model.AssetDataCacheManager;
import com.huobi.index.api.IndexService;
import com.huobi.index.bean.DropRankType;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.HotSymbol;
import com.huobi.index.bean.IndexBizData;
import com.huobi.index.bean.IndexFeature;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.index.bean.IndexLiveItem;
import com.huobi.index.bean.NewSymbol;
import com.huobi.index.bean.RankDynamicItem;
import com.huobi.index.bean.RealTimePrice;
import com.huobi.index.bean.RiseRankType;
import com.huobi.index.bean.TurnoverItem;
import com.huobi.index.bean.TurnoverRateItem;
import com.huobi.index.helper.data.BannerModule;
import com.huobi.index.helper.data.BizModule;
import com.huobi.index.helper.data.CapsuleModule;
import com.huobi.index.helper.data.EarnModule;
import com.huobi.index.helper.data.HomeCommonDataModule;
import com.huobi.index.helper.data.HomeTransferAmountModule;
import com.huobi.index.helper.data.InvestModule;
import com.huobi.index.helper.data.LiveModule;
import com.huobi.index.helper.data.NewUserGiftBagModule;
import com.huobi.index.helper.data.NoticeModule;
import com.huobi.index.helper.data.QuickModule;
import com.huobi.index.helper.data.RecommendRegionModule;
import com.huobi.index.presenter.g;
import com.huobi.index.trace.IndexLifeCycleStep;
import com.huobi.index.trace.IndexLifeCycleTracer;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.remote.UserCenterRemoteDataSource;
import com.huobi.store.AppConfigManager;
import com.huobi.utils.GsonHelper;
import com.huobi.view.rollviewpager.RollPagerView;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.android.tpush.common.Constants;
import com.twitter.sdk.android.core.identity.AuthHandler;
import d7.a1;
import ef.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pro.huobi.R;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import yl.t;

public class IndexPresenter extends BaseFragmentPresenter<s0> {
    public static int X;
    public List<TurnoverRateItem> A = new ArrayList(10);
    public Subscription B;
    public Subscription C;
    public final Handler D = new i6.t(new o(this));
    public Map<Integer, IndexFeature> E = new HashMap();
    public BannerModule F = new BannerModule();
    public CapsuleModule G = new CapsuleModule();
    public NewUserGiftBagModule H = new NewUserGiftBagModule();
    public HomeCommonDataModule I = new HomeCommonDataModule();
    public HomeTransferAmountModule J = new HomeTransferAmountModule();
    public RecommendRegionModule K = new RecommendRegionModule();
    public NoticeModule L = new NoticeModule();
    public QuickModule M = new QuickModule();
    public BizModule N = new BizModule();
    public EarnModule O = new EarnModule();
    public InvestModule P = new InvestModule();
    public LiveModule Q = new LiveModule();
    public boolean R = false;
    public boolean S = false;
    public int T = -1;
    public HomeFeedInfoItem.b U = new w();
    public t0 V;
    public boolean W = false;

    /* renamed from: c  reason: collision with root package name */
    public final String f73338c = "IndexTAGPresenter";

    /* renamed from: d  reason: collision with root package name */
    public int f73339d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f73340e;

    /* renamed from: f  reason: collision with root package name */
    public Subscription f73341f;

    /* renamed from: g  reason: collision with root package name */
    public Subscription f73342g;

    /* renamed from: h  reason: collision with root package name */
    public RiseRankType f73343h = RiseRankType.RANK_RISE_TYPE_USDT;

    /* renamed from: i  reason: collision with root package name */
    public DropRankType f73344i = DropRankType.RANK_RISE_TYPE_USDT;

    /* renamed from: j  reason: collision with root package name */
    public FutureRankPresenter f73345j = new FutureRankPresenter();

    /* renamed from: k  reason: collision with root package name */
    public List<RankList> f73346k;

    /* renamed from: l  reason: collision with root package name */
    public final List<List<String>> f73347l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public Subscriber<List<LiveDetailBean>> f73348m;

    /* renamed from: n  reason: collision with root package name */
    public long f73349n = 0;

    /* renamed from: o  reason: collision with root package name */
    public boolean f73350o = false;

    /* renamed from: p  reason: collision with root package name */
    public Handler f73351p;

    /* renamed from: q  reason: collision with root package name */
    public yg.a f73352q;

    /* renamed from: r  reason: collision with root package name */
    public Map<String, RealTimePrice> f73353r = new LinkedHashMap();

    /* renamed from: s  reason: collision with root package name */
    public Subscriber<Boolean> f73354s;

    /* renamed from: t  reason: collision with root package name */
    public List<? extends s9.a> f73355t = new ArrayList(10);

    /* renamed from: u  reason: collision with root package name */
    public List<wl.b> f73356u = new ArrayList(10);

    /* renamed from: v  reason: collision with root package name */
    public List<? extends s9.a> f73357v = new ArrayList(10);

    /* renamed from: w  reason: collision with root package name */
    public List<wl.a> f73358w = new ArrayList(10);

    /* renamed from: x  reason: collision with root package name */
    public List<TurnoverItem> f73359x = new ArrayList(10);

    /* renamed from: y  reason: collision with root package name */
    public List<NewSymbol> f73360y = new ArrayList(10);

    /* renamed from: z  reason: collision with root package name */
    public List<HotSymbol> f73361z = new ArrayList(10);

    public class a extends BaseSubscriber<List<SymbolBean>> {
        public a() {
        }

        public void onAfter() {
            super.onAfter();
            i6.d.c("ray21", "loopHbgSymbolsPrice 3 onAfter");
            ((s0) IndexPresenter.this.getUI()).dismissProgressDialog();
            int e11 = SP.e("sp_key_index_home_flow_config_porcelain", 0);
            Log.d("IndexTAGPresenter", "porcelain:" + e11);
            if (e11 != 0 || yl.o.G(IndexPresenter.this.T)) {
                ((s0) IndexPresenter.this.getUI()).af(false);
            } else {
                IndexPresenter.this.O2();
            }
            ((s0) IndexPresenter.this.getUI()).F7(1);
        }

        public void onError(Throwable th2) {
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            IndexPresenter.this.D.removeMessages(0);
            i6.d.c("ray21", "loopHbgSymbolsPrice 2");
        }
    }

    public class a0 implements H5CacheServiceHelper.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HashSet f73363a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f73364b;

        public a0(HashSet hashSet, Map map) {
            this.f73363a = hashSet;
            this.f73364b = map;
        }

        public void call() {
            H5CacheServiceHelper.startPreloadService(IndexPresenter.this.getActivity(), this.f73363a, this.f73364b, false);
        }
    }

    public class b extends BaseSubscriber<List<String>> {
        public b() {
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < list.size(); i11++) {
                Favorite favorite = new Favorite();
                favorite.setFavSymbol(list.get(i11));
                favorite.setFavType(sn.t.v(list.get(i11)));
                arrayList.add(favorite);
            }
            IndexPresenter.this.N2(arrayList);
        }
    }

    public class b0 extends BaseSubscriber<HomeActivityEntityResponse> {
        public b0() {
        }

        /* renamed from: a */
        public void onNext(HomeActivityEntityResponse homeActivityEntityResponse) {
            super.onNext(homeActivityEntityResponse);
            IndexPresenter.this.F.j(homeActivityEntityResponse);
            int i11 = yl.o.f76853a;
            yl.o.f76853a = i11 + 1;
            yl.o.v(i11);
        }

        public void onAfter() {
            super.onAfter();
            IndexPresenter.this.b3();
        }
    }

    public class c extends BaseSubscriber<List<RankList>> {
        public c() {
        }

        public void onAfter() {
            super.onAfter();
            ((s0) IndexPresenter.this.getUI()).dismissProgressDialog();
            ((s0) IndexPresenter.this.getUI()).F7(1);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (IndexPresenter.this.f73346k == null) {
                IndexPresenter.this.H2();
            }
            i6.k.g("#RankList#", "loopHbgAllRankSubscribe - onError -- ", th2);
            th2.printStackTrace();
            ((s0) IndexPresenter.this.getUI()).dismissProgressDialog();
            i6.u.f68196a.a("index_rank_consume", 0);
        }

        public void onNext(List<RankList> list) {
            super.onNext(list);
            i6.d.j("#RankList#", "loadRankList success. ");
            TimeMonitorManager.a().b("index_rank_consume").a("index_rank_consume", OptionsBridge.NETWORK_KEY, true);
            i6.u.f68196a.a("index_rank_consume", 0);
            List unused = IndexPresenter.this.f73346k = list;
            IndexPresenter.this.K1();
            if (list != null) {
                ((s0) IndexPresenter.this.getUI()).Bc(list);
            }
            int i11 = yl.o.f76853a;
            yl.o.f76853a = i11 + 1;
            yl.o.v(i11);
        }
    }

    public class c0 extends BaseSubscriber<HomeActivityEntityResponse> {
        public c0() {
        }

        /* renamed from: a */
        public void onNext(HomeActivityEntityResponse homeActivityEntityResponse) {
            super.onNext(homeActivityEntityResponse);
            IndexPresenter.this.G.j(homeActivityEntityResponse);
        }

        public void onAfter() {
            super.onAfter();
            IndexPresenter.this.T2(3);
            IndexPresenter.this.k3(2);
            int i11 = yl.o.f76853a;
            yl.o.f76853a = i11 + 1;
            yl.o.v(i11);
        }
    }

    public class d implements Func1<Observable<? extends Void>, Observable<?>> {

        public class a implements Func1<Void, Observable<?>> {
            public a() {
            }

            /* renamed from: a */
            public Observable<?> call(Void voidR) {
                return Observable.just(0).delay(3, TimeUnit.SECONDS);
            }
        }

        public d() {
        }

        /* renamed from: a */
        public Observable<?> call(Observable<? extends Void> observable) {
            return observable.flatMap(new a());
        }
    }

    public class d0 extends BaseSubscriber<HomePageNoticeData> {
        public d0() {
        }

        /* renamed from: a */
        public void onNext(HomePageNoticeData homePageNoticeData) {
            super.onNext(homePageNoticeData);
            i6.d.j("IndexTAGPresenter", "requestHomePageNotice onNext");
            IndexPresenter.this.L.j(homePageNoticeData);
            int i11 = yl.o.f76853a;
            yl.o.f76853a = i11 + 1;
            yl.o.v(i11);
        }

        public void onAfter() {
            super.onAfter();
            i6.d.j("IndexTAGPresenter", "requestHomePageNotice onAfter:");
            IndexPresenter.this.h3();
        }
    }

    public class e extends BaseSubscriber<Map<String, RealTimePrice>> {
        public e() {
        }

        /* renamed from: a */
        public void onNext(Map<String, RealTimePrice> map) {
            super.onNext(map);
            if (map != null && map.size() > 0) {
                IndexPresenter.this.f73353r.clear();
                IndexPresenter.this.f73353r.putAll(map);
            }
            ((s0) IndexPresenter.this.getUI()).Ic(IndexPresenter.this.f73353r);
            TimeMonitorManager.a().b("index_fixed_symbols_consume").a("index_fixed_symbols_consume", OptionsBridge.NETWORK_KEY, true);
            i6.u.f68196a.a("index_fixed_symbols_consume", 0);
        }

        public void onAfter() {
            super.onAfter();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            th2.printStackTrace();
            i6.k.g("INDEX", "startLoopMidArea - onError -- ", th2);
            ((s0) IndexPresenter.this.getUI()).Ic(IndexPresenter.this.f73353r);
            i6.u.f68196a.a("index_fixed_symbols_consume", 0);
        }
    }

    public class e0 extends BaseSubscriber<IndexFeature> {
        public e0() {
        }

        /* renamed from: a */
        public void onNext(IndexFeature indexFeature) {
            List<IndexFeatureItem> list;
            QuickModule T0 = IndexPresenter.this.M;
            if (indexFeature == null) {
                list = null;
            } else {
                list = indexFeature.getIndexFeatureItems();
            }
            T0.j(list);
        }

        public void onAfter() {
            super.onAfter();
            IndexPresenter.this.T2(3);
            IndexPresenter.this.i3();
            ((s0) IndexPresenter.this.getUI()).Xb();
            int i11 = yl.o.f76853a;
            yl.o.f76853a = i11 + 1;
            yl.o.v(i11);
        }
    }

    public class f implements Func1<Observable<? extends Void>, Observable<?>> {

        public class a implements Func1<Void, Observable<?>> {
            public a() {
            }

            /* renamed from: a */
            public Observable<?> call(Void voidR) {
                return Observable.just(0).delay(3, TimeUnit.SECONDS);
            }
        }

        public f() {
        }

        /* renamed from: a */
        public Observable<?> call(Observable<? extends Void> observable) {
            return observable.flatMap(new a());
        }
    }

    public class f0 extends TypeToken<HomeActivityEntityResponse> {
        public f0() {
        }
    }

    public class g implements Func1<Throwable, Map<String, RealTimePrice>> {
        public g() {
        }

        /* renamed from: a */
        public Map<String, RealTimePrice> call(Throwable th2) {
            th2.printStackTrace();
            i6.k.g("INDEX", "startLoopMidArea has error", th2);
            return new HashMap();
        }
    }

    public class g0 extends BaseSubscriber<HomePageData> {
        public g0() {
        }

        /* renamed from: a */
        public void onNext(HomePageData homePageData) {
            super.onNext(homePageData);
            i6.d.j("IndexTAGPresenter", "requestHomePageBizs");
            if (homePageData != null) {
                IndexPresenter.this.N.u(homePageData);
                SP.y("key_index_biz_use_assets_cache", false);
            }
        }

        public void onAfter() {
            super.onAfter();
            i6.d.j("IndexTAGPresenter", "requestHomePageBizs onAfter");
            IndexPresenter.this.T2(3);
            IndexPresenter.this.c3();
            IndexPresenter.this.W2();
            IndexPresenter.this.X2();
            int i11 = yl.o.f76853a;
            yl.o.f76853a = i11 + 1;
            yl.o.v(i11);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            i6.d.j("IndexTAGPresenter", "requestHomePageBizs onError e = " + th2);
        }
    }

    public class h implements Func1<List<HbgSymbolPrice>, Observable<? extends Map<String, RealTimePrice>>> {
        public h() {
        }

        /* renamed from: a */
        public Observable<? extends Map<String, RealTimePrice>> call(List<HbgSymbolPrice> list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (HbgSymbolPrice next : list) {
                RealTimePrice c11 = yl.p.c(next);
                if (c11 != null) {
                    linkedHashMap.put(next.getSymbol(), c11);
                }
            }
            return Observable.just(linkedHashMap);
        }
    }

    public class h0 extends BaseSubscriber<HomePageEarnData> {
        public h0() {
        }

        /* renamed from: a */
        public void onNext(HomePageEarnData homePageEarnData) {
            super.onNext(homePageEarnData);
            if (homePageEarnData != null) {
                IndexPresenter.this.O.j(homePageEarnData);
                SP.l("key_index_earn_use_assets_cache", false);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("requestHomePageEarn --- onNext--data:");
            Object obj = homePageEarnData;
            if (homePageEarnData == null) {
                obj = OptionsBridge.NULL_VALUE;
            }
            sb2.append(obj);
            Log.d("IndexTAGPresenter", sb2.toString());
        }

        public void onAfter() {
            super.onAfter();
            Log.d("IndexTAGPresenter", "requestHomePageEarn --- onAfter");
            IndexPresenter.this.T2(3);
            IndexPresenter.this.f3();
            int i11 = yl.o.f76853a;
            yl.o.f76853a = i11 + 1;
            yl.o.v(i11);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            Log.d("IndexTAGPresenter", "requestHomePageEarn --- onError - e:" + th2);
        }
    }

    public class i extends EasySubscriber<List<SymbolBean>> {
        public i() {
        }

        public void onError2(Throwable th2) {
            i6.k.k(th2);
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            if (tg.r.x().F0()) {
                IndexPresenter.this.s1();
            }
            int unused = IndexPresenter.this.f73340e = 2;
        }
    }

    public class i0 extends BaseSubscriber<HomePageInvestData> {
        public i0() {
        }

        /* renamed from: a */
        public void onNext(HomePageInvestData homePageInvestData) {
            super.onNext(homePageInvestData);
            if (homePageInvestData != null) {
                IndexPresenter.this.P.j(homePageInvestData);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("requestHomePageInvest --- onNext--data:");
            Object obj = homePageInvestData;
            if (homePageInvestData == null) {
                obj = OptionsBridge.NULL_VALUE;
            }
            sb2.append(obj);
            Log.d("IndexTAGPresenter", sb2.toString());
        }

        public void onAfter() {
            super.onAfter();
            IndexPresenter.this.T2(3);
            IndexPresenter.this.g3();
            int i11 = yl.o.f76853a;
            yl.o.f76853a = i11 + 1;
            yl.o.v(i11);
            Log.d("IndexTAGPresenter", "requestHomePageInvest --- onAfter");
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            Log.d("IndexTAGPresenter", "requestHomePageInvest --- onError - e:" + th2.getMessage());
        }
    }

    public class j implements ViewPager.OnPageChangeListener {
        public j() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            int size = IndexPresenter.this.f73352q.e().size();
            HashMap<Integer, String> f12 = IndexPresenter.this.f73352q.f();
            if (f12 != null && f12.size() > 0) {
                int i13 = i11 % size;
                int i14 = (i11 + 1) % size;
                String str = f12.get(Integer.valueOf(i13));
                String str2 = f12.get(Integer.valueOf(i14));
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    Message obtainMessage = IndexPresenter.this.f73351p.obtainMessage();
                    obtainMessage.what = 0;
                    obtainMessage.arg1 = Color.parseColor(str);
                    obtainMessage.arg2 = Color.parseColor(str2);
                    obtainMessage.obj = Integer.valueOf(i12);
                    IndexPresenter.this.f73351p.sendMessage(obtainMessage);
                }
            }
        }

        public void onPageSelected(int i11) {
            HashMap hashMap = new HashMap();
            List<HomeActivityEntity> e11 = IndexPresenter.this.f73352q.e();
            int size = i11 % e11.size();
            HomeActivityEntity homeActivityEntity = e11.get(size);
            hashMap.put("name", homeActivityEntity.adName);
            hashMap.put("banner_site", Integer.valueOf(size));
            hashMap.put("banner_id", homeActivityEntity.f44607id);
            hashMap.put("testKey", "A");
            gs.g.i("banner_show", hashMap);
            ((s0) IndexPresenter.this.getUI()).I2(size + 1, IndexPresenter.this.f73352q.e().size());
        }
    }

    public class j0 extends BaseSubscriber<HomePageNewUserGiftBagData> {
        public j0() {
        }

        /* renamed from: a */
        public void onNext(HomePageNewUserGiftBagData homePageNewUserGiftBagData) {
            super.onNext(homePageNewUserGiftBagData);
            IndexPresenter.this.H.j(homePageNewUserGiftBagData);
        }

        public void onAfter() {
            super.onAfter();
            IndexPresenter.this.k3(3);
            int i11 = yl.o.f76853a;
            yl.o.f76853a = i11 + 1;
            yl.o.v(i11);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            Log.d("IndexTAGPresenter", "迎新礼包数据异常 = " + th2.getMessage());
        }
    }

    public class k extends BaseSubscriber<UnifyKycInfo> {
        public k() {
        }

        /* renamed from: a */
        public void onNext(UnifyKycInfo unifyKycInfo) {
            super.onNext(unifyKycInfo);
            if (unifyKycInfo == null || !(unifyKycInfo.getFinalAuthState() == 1 || unifyKycInfo.getFinalAuthState() == 2)) {
                ((s0) IndexPresenter.this.getUI()).y6(false);
            } else {
                ((s0) IndexPresenter.this.getUI()).y6(true);
            }
        }
    }

    public class k0 extends BaseSubscriber<HomeCommonData> {
        public k0() {
        }

        /* renamed from: a */
        public void onNext(HomeCommonData homeCommonData) {
            super.onNext(homeCommonData);
            IndexPresenter.this.I.j(homeCommonData);
        }

        public void onAfter() {
            super.onAfter();
            IndexPresenter.this.a3();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            Log.d("IndexTAGPresenter", "迎新礼包数据异常 = " + th2.getMessage());
        }
    }

    public class l extends BaseSubscriber<UnreadCountData> {
        public l() {
        }

        /* renamed from: a */
        public void onNext(UnreadCountData unreadCountData) {
            super.onNext(unreadCountData);
            ((s0) IndexPresenter.this.getUI()).e4(unreadCountData);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            th2.printStackTrace();
        }
    }

    public class l0 extends BaseSubscriber<Object> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Runnable f73389b;

        public l0(Runnable runnable) {
            this.f73389b = runnable;
        }

        public void onError(Throwable th2) {
            i6.d.j("IndexTAGPresenter", "preRequest onError:" + th2.getMessage());
            this.f73389b.run();
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            i6.d.j("IndexTAGPresenter", "homepagePreRequest onNext");
            this.f73389b.run();
        }
    }

    public class m implements Func1<Throwable, UnreadCountData> {
        public m() {
        }

        /* renamed from: a */
        public UnreadCountData call(Throwable th2) {
            return null;
        }
    }

    public class m0 extends TypeToken<HomePageNoticeData> {
        public m0() {
        }
    }

    public class n implements Func1<Long, Observable<UnreadCountData>> {
        public n() {
        }

        public static /* synthetic */ UnreadCountData c(MessageNoReadNum messageNoReadNum) {
            UnreadCountData unreadCountData = new UnreadCountData();
            unreadCountData.setActivityCount(messageNoReadNum.c().intValue());
            unreadCountData.setSystemCount(messageNoReadNum.d());
            return unreadCountData;
        }

        /* renamed from: b */
        public Observable<UnreadCountData> call(Long l11) {
            return o9.a.a().b().b().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(y.f73476b);
        }
    }

    public class n0 extends TypeToken<IndexFeature> {
        public n0() {
        }
    }

    public class o extends RequestCallback1<VipInfoResult> {
        public o() {
        }

        /* renamed from: a */
        public void onRequestSuccess(VipInfoResult vipInfoResult) {
            IndexPresenter.this.l3();
        }

        public void onRequestFailure(Throwable th2) {
        }
    }

    public class o0 extends TypeToken<HomePageData> {
        public o0() {
        }
    }

    public class p extends EasySubscriber<Boolean> {
        public p() {
        }

        public static /* synthetic */ void b(Integer num) {
            if (num != null) {
                yl.n.e(num.intValue());
            }
        }

        /* renamed from: c */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            yl.n.c(z.f73477b);
        }
    }

    public class p0 extends TypeToken<HomePageEarnData> {
        public p0() {
        }
    }

    public class q extends BaseSubscriber<IndexFeature> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f73399b;

        public q(int i11) {
            this.f73399b = i11;
        }

        /* renamed from: a */
        public void onNext(IndexFeature indexFeature) {
            IndexPresenter.this.E.put(Integer.valueOf(this.f73399b), indexFeature);
            String json = indexFeature != null ? new Gson().toJson((Object) indexFeature) : null;
            if (!TextUtils.isEmpty(json)) {
                SP.s(NightHelper.e().g() + "_" + AppLanguageHelper.getInstance().getCurLanguageHeader() + "_" + "SP_KEY_INDEX_FEATURE" + "_" + this.f73399b, json);
            }
            IndexPresenter.this.Y2(this.f73399b, indexFeature);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            th2.printStackTrace();
        }
    }

    public class q0 extends TypeToken<HomePageInvestData> {
        public q0() {
        }
    }

    public class r extends BaseSubscriber<Object> {
        public r() {
        }

        public void onAfter() {
            Log.d("IndexTAGPresenter", "loadCacheFromAsserts--onAfter:" + ThreadUtils.a());
            IndexPresenter.this.t2(false);
        }
    }

    public class r0 extends TypeToken<List<LiveDetailBean>> {
        public r0() {
        }
    }

    public class s extends BaseSubscriber<Object> {
        public s() {
        }

        public void onAfter() {
            IndexPresenter.this.e3();
            IndexPresenter.this.T2(3);
        }
    }

    public interface s0 extends u6.g {
        void A9(boolean z11, boolean z12, boolean z13, HomePageNewUserGiftBagData homePageNewUserGiftBagData, long j11, int i11);

        void Bc(List<RankList> list);

        void Bd(boolean z11);

        void Ca();

        void F7(int i11);

        void Hc(int i11);

        void I2(int i11, int i12);

        void Ic(Map<String, RealTimePrice> map);

        void K9();

        void O5();

        void Oe(HomePageInvestData homePageInvestData);

        void Q6();

        void Q7(int i11);

        void R7(boolean z11);

        RankList Tb();

        void U9();

        void Xb();

        RollPagerView a2();

        void af(boolean z11);

        void c7(UserRegistryTransferGuide userRegistryTransferGuide, int i11);

        void d5(boolean z11, List<IndexBizData> list);

        void e4(UnreadCountData unreadCountData);

        void e5(boolean z11, List<s9.a> list);

        void g7(boolean z11, List<IndexFeatureItem> list);

        void h7(boolean z11, List<HomeActivityEntity> list);

        void lb(boolean z11, HomePageEarnData homePageEarnData);

        void mf(boolean z11);

        void n7();

        void nd(HomeCommonData homeCommonData);

        void o5(List<RankDynamicItem> list, int i11);

        void rg(IndexFeature indexFeature);

        void sa(String str);

        void t6(boolean z11);

        void x(LiveAppointmentData liveAppointmentData, boolean z11, int i11);

        void y0(boolean z11);

        void y4(boolean z11, List<HomePageNoticeData.Notice> list);

        void y6(boolean z11);
    }

    public class t extends BaseSubscriber<UserRegistryTransferGuide> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f73405b;

        public t(boolean z11) {
            this.f73405b = z11;
        }

        /* renamed from: a */
        public void onNext(UserRegistryTransferGuide userRegistryTransferGuide) {
            super.onNext(userRegistryTransferGuide);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("data:");
            sb2.append(userRegistryTransferGuide != null ? userRegistryTransferGuide.toString() : " is null");
            Log.d("IndexTAGPresenter", sb2.toString());
            if (userRegistryTransferGuide != null) {
                int unused = IndexPresenter.this.T = userRegistryTransferGuide.getTaskProgress();
                SP.q("sp_key_index_home_flow_config_task_progress", IndexPresenter.this.T);
                ((s0) IndexPresenter.this.getUI()).c7(userRegistryTransferGuide, IndexPresenter.this.T);
            }
        }

        public void onAfter() {
            super.onAfter();
            Log.d("IndexTAGPresenter", "onAfter -- taskProgress:" + IndexPresenter.this.T);
            Log.d("IndexTAGPresenter", "getUserRegistryTransferGuide--isMainThread:" + ThreadUtils.a());
            if (this.f73405b) {
                IndexPresenter.this.F2();
            } else {
                IndexPresenter.this.t2(true);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            int unused = IndexPresenter.this.T = -1;
            ((s0) IndexPresenter.this.getUI()).c7((UserRegistryTransferGuide) null, IndexPresenter.this.T);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error:");
            sb2.append(th2 != null ? th2.getMessage() : "");
            Log.e("IndexTAGPresenter", sb2.toString());
        }
    }

    public class t0 implements b.a {
        public t0() {
        }

        public void a(LiveSquareBaseData liveSquareBaseData, int i11, int i12) {
            if (liveSquareBaseData != null) {
                i6.d.i("IndexTAGPresenterdata:" + liveSquareBaseData);
                switch (i11) {
                    case 100:
                        if (liveSquareBaseData instanceof LiveDetailBean) {
                            LiveDetailBean liveDetailBean = (LiveDetailBean) liveSquareBaseData;
                            IndexPresenter.this.T1(liveDetailBean.status, liveDetailBean.f70249id);
                            return;
                        }
                        return;
                    case 101:
                        if (liveSquareBaseData instanceof LiveDetailBean) {
                            LiveDetailBean liveDetailBean2 = (LiveDetailBean) liveSquareBaseData;
                            IndexPresenter.this.T1(liveDetailBean2.status, liveDetailBean2.f70249id);
                            return;
                        }
                        return;
                    case 102:
                        if (liveSquareBaseData instanceof LiveDetailBean) {
                            LiveDetailBean liveDetailBean3 = (LiveDetailBean) liveSquareBaseData;
                            IndexPresenter.this.T1(liveDetailBean3.status, liveDetailBean3.f70249id);
                            return;
                        }
                        return;
                    case 103:
                        if (liveSquareBaseData instanceof LiveDetailBean) {
                            IndexPresenter.this.B2(Integer.parseInt(((LiveDetailBean) liveSquareBaseData).f70249id), true, i12);
                            return;
                        }
                        return;
                    case 104:
                        if (liveSquareBaseData instanceof LiveDetailBean) {
                            IndexPresenter.this.B2(Integer.parseInt(((LiveDetailBean) liveSquareBaseData).f70249id), false, i12);
                            return;
                        }
                        return;
                    case 105:
                        IndexPresenter indexPresenter = IndexPresenter.this;
                        if (indexPresenter.p1(indexPresenter.getActivity()) && (liveSquareBaseData instanceof LiveSpeaker)) {
                            LiveSpeaker liveSpeaker = (LiveSpeaker) liveSquareBaseData;
                            if (!TextUtils.isEmpty(liveSpeaker.groupId)) {
                                dd.b.f22740a.j(IndexPresenter.this.getActivity(), liveSpeaker.groupId, liveSpeaker.title, (String) null);
                                LiveTrackUtils.c("APP_LIVE_group_getinto", (Object) null, liveSpeaker.showId, liveSpeaker.title, liveSpeaker.groupId, 2);
                                return;
                            }
                            return;
                        }
                        return;
                    case 106:
                        if (liveSquareBaseData.getModuleType() == 3) {
                            dd.b.f22740a.g(IndexPresenter.this.getActivity());
                            return;
                        } else if (liveSquareBaseData.getModuleType() == 4) {
                            IndexPresenter.this.V1(1);
                            return;
                        } else if (liveSquareBaseData.getModuleType() == 5) {
                            IndexPresenter.this.V1(3);
                            return;
                        } else if (liveSquareBaseData.getModuleType() == 2) {
                            IndexPresenter.this.V1(2);
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            } else {
                i6.d.i("IndexTAGPresenterdata: is null");
            }
        }
    }

    public class u extends BaseSubscriber<Object> {
        public u() {
        }

        public void onAfter() {
            IndexPresenter.this.f73345j.r((s0) IndexPresenter.this.getUI(), IndexPresenter.this);
        }
    }

    public class v extends BaseSubscriber<List<LiveDetailBean>> {
        public v() {
        }

        public void onNext(List<LiveDetailBean> list) {
            super.onNext(list);
            IndexPresenter.this.j3();
            int i11 = yl.o.f76853a;
            yl.o.f76853a = i11 + 1;
            yl.o.v(i11);
        }
    }

    public class w implements HomeFeedInfoItem.b {
        public w() {
        }
    }

    public class x extends BaseSubscriber<LiveAppointmentData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f73411b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f73412c;

        public x(boolean z11, int i11) {
            this.f73411b = z11;
            this.f73412c = i11;
        }

        /* renamed from: a */
        public void onNext(LiveAppointmentData liveAppointmentData) {
            super.onNext(liveAppointmentData);
            if (IndexPresenter.this.getActivity() != null && !IndexPresenter.this.getActivity().isFinishing() && IndexPresenter.this.getUI() != null && !IndexPresenter.this.Q().isDetached()) {
                ((s0) IndexPresenter.this.getUI()).x(liveAppointmentData, this.f73411b, this.f73412c);
                HuobiToastUtil.s(R.string.n_live_make_appointment_success);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public class y extends BaseSubscriber<LiveAppointmentData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f73414b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f73415c;

        public y(boolean z11, int i11) {
            this.f73414b = z11;
            this.f73415c = i11;
        }

        /* renamed from: a */
        public void onNext(LiveAppointmentData liveAppointmentData) {
            super.onNext(liveAppointmentData);
            if (IndexPresenter.this.getActivity() != null && !IndexPresenter.this.getActivity().isFinishing() && IndexPresenter.this.getUI() != null && !IndexPresenter.this.Q().isDetached()) {
                ((s0) IndexPresenter.this.getUI()).x(liveAppointmentData, this.f73414b, this.f73415c);
                HuobiToastUtil.s(R.string.n_live_cancel_success);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            HuobiToastUtil.g(R.string.n_live_cancel_failure);
        }
    }

    public class z implements Runnable {
        public z() {
        }

        public void run() {
            if (!IndexPresenter.this.W) {
                try {
                    BaseCoreActivity J0 = IndexPresenter.this.getActivity();
                    if (J0 != null && !J0.isFinishing()) {
                        IndexPresenter.this.l2();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static /* synthetic */ Boolean W1(UserOtcCoupon userOtcCoupon, Boolean bool) {
        return bool;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X1(List list) {
        if (list != null) {
            this.Q.p(list);
            T2(3);
        }
    }

    public static /* synthetic */ List Y1(Throwable th2) {
        return new ArrayList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z1(Message message) {
        i6.k.d("IndexPresenterLoading", "3.handleMessage() " + message);
        int i11 = message.what;
        if (i11 == 0) {
            i6.k.d("IndexPresenterLoading", "3.dismissProgressDialog()");
            H2();
        } else if (i11 == 11) {
            i6.k.o("IndexTAGPresenter", "MESSAGE_TYPE_LIVE_UPDATE 自动更新直播列表");
            A2();
        }
    }

    public static /* synthetic */ Object a2(List list, List list2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable b2(UserKycInfoNew userKycInfoNew) {
        return w1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c2(Subscriber subscriber) {
        h2();
        subscriber.onCompleted();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e2(Subscriber subscriber) {
        T2(1);
        if (yl.i.a().b()) {
            Log.d("IndexTAGPresenter", "loadCacheFromAsserts--isMainThread:" + ThreadUtils.a());
            g2();
            SP.y("key_index_biz_use_assets_cache", true);
            SP.y("key_index_earn_use_assets_cache", true);
        }
        subscriber.onCompleted();
    }

    public final Observable<HomePageNewUserGiftBagData> A1() {
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-language", AppLanguageHelper.getInstance().getCurLanguageHeader());
        int g11 = yl.g.h().g();
        if (g11 == -1) {
            try {
                String a11 = sn.a.c().a();
                if (!com.hbg.module.libkt.base.ext.b.x(a11)) {
                    g11 = Integer.parseInt(a11);
                }
            } catch (NumberFormatException e11) {
                e11.printStackTrace();
            }
        }
        hashMap.put("HB-COUNTRY-ID", Integer.valueOf(g11));
        hashMap.put("HB-CTX-ID", ConfigPreferences.e("user_config", "config_current_uid", ""));
        return ((IndexService) tq.p.C(IndexService.class)).requestNewUserGiftBag(hashMap, new HashMap()).compose(tq.p.E()).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public final void A2() {
        Subscriber<List<LiveDetailBean>> subscriber = this.f73348m;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        this.f73348m = q1();
        F1().subscribe(this.f73348m);
    }

    public final Observable<HomePageNoticeData> B1() {
        return v7.b.a().getNotice(yl.g.h().g()).b().compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public void B2(int i11, boolean z11, int i12) {
        if (getUI() != null) {
            if (!z11) {
                v7.b.a().K0(String.valueOf(i11)).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new y(z11, i12));
            } else if (p1(getActivity())) {
                v7.b.a().v0(String.valueOf(i11)).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new x(z11, i12));
            }
        }
    }

    public final Observable<IndexFeature> C1() {
        long j11;
        if (!this.M.g()) {
            return Observable.just(null);
        }
        int i11 = 0;
        String J2 = tg.r.x().J();
        if (!TextUtils.isEmpty(J2)) {
            i11 = Integer.parseInt(J2);
            j11 = System.currentTimeMillis();
        } else {
            j11 = 0;
        }
        String d11 = ConfigPreferences.d("user_config", "com.huobi.appFeatures.module.timeStamp");
        if (!TextUtils.isEmpty(d11) && Long.parseLong(d11) > 0) {
            j11 = Long.parseLong(d11);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("platform", 1);
        hashMap.put("version", String.valueOf(105400));
        hashMap.put("nightMode", Integer.valueOf(NightHelper.e().g() ? 1 : 0));
        hashMap.put("uid", Integer.valueOf(i11));
        hashMap.put("moduleSize", 20);
        if (j11 > 0) {
            hashMap.put(AuthHandler.EXTRA_TOKEN_SECRET, Long.valueOf(j11));
        }
        int g11 = yl.g.h().g();
        if (g11 == -1) {
            try {
                String a11 = sn.a.c().a();
                if (!com.hbg.module.libkt.base.ext.b.x(a11)) {
                    g11 = Integer.parseInt(a11);
                }
            } catch (NumberFormatException e11) {
                e11.printStackTrace();
            }
        }
        return ((IndexService) tq.p.V(IndexService.class)).getAppFeatures(String.valueOf(8), g11, hashMap).compose(tq.p.E()).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public void C2() {
        A1().subscribe(new j0());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: com.huobi.index.bean.IndexFeature} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D1(int r9) {
        /*
            r8 = this;
            r0 = 6
            if (r9 == r0) goto L_0x0061
            r0 = 4
            if (r9 == r0) goto L_0x0061
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.hbg.lib.core.util.NightHelper r1 = com.hbg.lib.core.util.NightHelper.e()
            boolean r1 = r1.g()
            r0.append(r1)
            java.lang.String r1 = "_"
            r0.append(r1)
            com.hbg.lib.core.util.AppLanguageHelper r2 = com.hbg.lib.core.util.AppLanguageHelper.getInstance()
            java.lang.String r2 = r2.getCurLanguageHeader()
            r0.append(r2)
            r0.append(r1)
            java.lang.String r2 = "SP_KEY_INDEX_FEATURE"
            r0.append(r2)
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = ""
            java.lang.String r0 = com.hbg.lib.common.utils.SP.i(r0, r1)
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0053
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.Class<com.huobi.index.bean.IndexFeature> r2 = com.huobi.index.bean.IndexFeature.class
            java.lang.Object r0 = r1.fromJson((java.lang.String) r0, r2)
            r1 = r0
            com.huobi.index.bean.IndexFeature r1 = (com.huobi.index.bean.IndexFeature) r1
        L_0x0053:
            if (r1 == 0) goto L_0x0061
            java.util.Map<java.lang.Integer, com.huobi.index.bean.IndexFeature> r0 = r8.E
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            r0.put(r2, r1)
            r8.Y2(r9, r1)
        L_0x0061:
            r0 = 0
            tg.r r1 = tg.r.x()
            java.lang.String r1 = r1.J()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 8
            r4 = 0
            if (r2 != 0) goto L_0x008b
            java.lang.String r2 = java.lang.String.valueOf(r9)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x008b
            int r0 = java.lang.Integer.parseInt(r1)
            long r1 = java.lang.System.currentTimeMillis()
            goto L_0x008c
        L_0x008b:
            r1 = r4
        L_0x008c:
            if (r9 != r3) goto L_0x00a8
            java.lang.String r3 = "user_config"
            java.lang.String r6 = "com.huobi.appFeatures.module.timeStamp"
            java.lang.String r3 = com.hbg.lib.core.util.ConfigPreferences.d(r3, r6)
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            if (r6 != 0) goto L_0x00a8
            long r6 = java.lang.Long.parseLong(r3)
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x00a8
            long r1 = java.lang.Long.parseLong(r3)
        L_0x00a8:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r6 = 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = "platform"
            r3.put(r7, r6)
            r6 = 105400(0x19bb8, float:1.47697E-40)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r7 = "version"
            r3.put(r7, r6)
            com.hbg.lib.core.util.NightHelper r6 = com.hbg.lib.core.util.NightHelper.e()
            boolean r6 = r6.g()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = "nightMode"
            r3.put(r7, r6)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r6 = "uid"
            r3.put(r6, r0)
            r0 = 20
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r6 = "moduleSize"
            r3.put(r6, r0)
            int r0 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f5
            java.lang.Long r0 = java.lang.Long.valueOf(r1)
            java.lang.String r1 = "ts"
            r3.put(r1, r0)
        L_0x00f5:
            yl.g r0 = yl.g.h()
            int r0 = r0.g()
            r1 = -1
            if (r0 != r1) goto L_0x0117
            sn.a r1 = sn.a.c()     // Catch:{ NumberFormatException -> 0x0113 }
            java.lang.String r1 = r1.a()     // Catch:{ NumberFormatException -> 0x0113 }
            boolean r2 = com.hbg.module.libkt.base.ext.b.x(r1)     // Catch:{ NumberFormatException -> 0x0113 }
            if (r2 != 0) goto L_0x0117
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0113 }
            goto L_0x0117
        L_0x0113:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0117:
            java.lang.Class<com.huobi.index.api.IndexService> r1 = com.huobi.index.api.IndexService.class
            java.lang.Object r1 = tq.p.V(r1)
            com.huobi.index.api.IndexService r1 = (com.huobi.index.api.IndexService) r1
            java.lang.String r2 = java.lang.String.valueOf(r9)
            rx.Observable r0 = r1.getAppFeatures(r2, r0, r3)
            rx.Observable$Transformer r1 = tq.p.E()
            rx.Observable r0 = r0.compose(r1)
            h6.a r1 = r8.getUI()
            u6.g r1 = (u6.g) r1
            rx.Observable$Transformer r1 = com.hbg.lib.core.util.RxJavaHelper.t(r1)
            rx.Observable r0 = r0.compose(r1)
            com.huobi.index.presenter.IndexPresenter$q r1 = new com.huobi.index.presenter.IndexPresenter$q
            r1.<init>(r9)
            r0.subscribe(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.index.presenter.IndexPresenter.D1(int):void");
    }

    public void D2(boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("HB-CTX-ID", ConfigPreferences.e("user_config", "config_current_uid", ""));
        v7.b.a().getUserRegistryTransferGuide(hashMap).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new t(z11));
    }

    public final void E1() {
        a1.v().z0(true).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new i());
    }

    public final void E2() {
        os.c.o(new o());
    }

    public final Observable<List<LiveDetailBean>> F1() {
        if (!AppConfigManager.h(MgtConfigNumber.ALL_SWITCH.number, "huobiLive", false) || !this.Q.g()) {
            return Observable.just(null);
        }
        return v7.b.a().getLiveList().b().doOnNext(new t(this)).onErrorReturn(v.f73473b).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public void F2() {
        if (!NetworkStatus.c(getActivity())) {
            ((s0) getUI()).y0(true);
            return;
        }
        o2();
        ((s0) getUI()).Q7(0);
        ContractCurrencyUtils.g(true).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        SwapCurrencyInfoController.k().f(true).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        D1(6);
        this.f73345j.p();
    }

    public int G1() {
        return SP.e("key_new_hand_gift_bag_close_date", -1);
    }

    public void G2(Handler handler) {
        this.f73351p = handler;
    }

    public int H1() {
        return SP.e("key_new_user_gift_bag_first_show_date", -1);
    }

    public final void H2() {
        i6.d.j("IndexTAGPresenter", "showBottomError");
        ((s0) getUI()).Ca();
        ((s0) getUI()).dismissProgressDialog();
    }

    public final void I1() {
        LegalCurrencyConfigUtil.X(true).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }

    public final void I2() {
        i6.d.j("IndexTAGPresenter", "showBottomLoading");
        ((s0) getUI()).n7();
    }

    public final boolean J1() {
        String t11 = PhoneUtils.t();
        Log.d("IndexTAGPresenter", "deviceId:" + t11);
        boolean z11 = false;
        if (!TextUtils.isEmpty(t11)) {
            int parseInt = Integer.parseInt(t11.substring(t11.length() - 2), 16);
            int i11 = (int) (((double) AppConfigManager.i(MgtConfigNumber.NEW_USER_GIFT_BAG.number, "showNextday")) * 2.56d);
            Log.d("IndexTAGPresenter", "读取MGT后台配置的 percentage = " + i11 + " 本地value:" + parseInt);
            if (parseInt < i11) {
                z11 = true;
            }
            Log.d("IndexTAGPresenter", "isOpen:" + z11);
        }
        return z11;
    }

    public final void J2() {
        i6.d.j("IndexTAGPresenter", "showWholeError");
        ((s0) getUI()).O5();
        b3();
    }

    public final void K1() {
        long j11;
        List<RankList> list = this.f73346k;
        if (list != null) {
            for (RankList next : list) {
                if (next != null && next.getType() == 4) {
                    next.setScreen(false);
                    Map<String, List<RankListItemBean>> multipleMap = next.getMultipleMap();
                    if (multipleMap != null) {
                        List<RankListItemBean> list2 = multipleMap.get("untradeable");
                        if (list2 != null) {
                            j11 = 0;
                            for (RankListItemBean rankListItemBean : list2) {
                                if (rankListItemBean != null) {
                                    j11 = Math.max(j11, rankListItemBean.getBeginTradeDate());
                                }
                            }
                        } else {
                            j11 = 0;
                        }
                        List<RankListItemBean> list3 = multipleMap.get("tradeable");
                        if (list3 != null) {
                            for (RankListItemBean rankListItemBean2 : list3) {
                                if (rankListItemBean2 != null) {
                                    j11 = Math.max(j11, rankListItemBean2.getBeginTradeDate());
                                }
                            }
                        }
                        if (j11 > 0) {
                            long g11 = SP.g("key_rank_new_symbol_red_dot_time", 0);
                            if (g11 == 0) {
                                SP.r("key_rank_new_symbol_red_dot_time", j11);
                            } else if (j11 > g11) {
                                EventBus.d().k(new IndexTextListIndicator.e(j11));
                            }
                        } else {
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    public final void K2() {
        i6.d.j("IndexTAGPresenter", "showWholeLoading");
        ((s0) getUI()).U9();
        b3();
    }

    public final boolean L1() {
        return !this.f73357v.isEmpty();
    }

    public final void L2() {
        i6.d.j("IndexTAGPresenter", "showWholeSucc");
        ((s0) getUI()).K9();
    }

    public final boolean M1() {
        return !this.f73355t.isEmpty();
    }

    public void M2() {
        sn.t.u(false, getActivity()).compose(RxJavaHelper.t((u6.g) null)).subscribe(new b());
    }

    public final void N1(Runnable runnable) {
        i6.d.j("IndexTAGPresenter", "homepagePreRequest");
        UserCenterRemoteDataSource.A().u().compose(tq.p.c0()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new l0(runnable));
    }

    public void N2(List<Favorite> list) {
        Subscription subscription = this.C;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.C.unsubscribe();
        }
        i6.d.j("#RankList#", "startLoadAllRankList loop.");
        HashMap hashMap = new HashMap();
        hashMap.put("favorites", list);
        this.C = v7.b.a().getRankInfoV3(hashMap).b().compose(RxJavaHelper.t((u6.g) getUI())).repeatWhen(new d()).subscribe(new c());
    }

    public final Observable<Map<String, RealTimePrice>> O1() {
        return ((HbgService) HbgRetrofit.request(HbgService.class)).getTopContractSymbols().compose(HbgRetrofit.e()).compose(RxJavaHelper.t((u6.g) getUI())).concatMap(new h());
    }

    public final void O2() {
        Subscription subscription = this.B;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.B.unsubscribe();
        }
        this.B = O1().compose(RxJavaHelper.t((u6.g) getUI())).onErrorReturn(new g()).repeatWhen(new f()).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e());
    }

    public final void P1() {
        RiseRankType riseRankType = RiseRankType.RANK_RISE_TYPE_USDT;
        int e11 = SP.e("sp_key_risk_rank_type_210806", riseRankType.ordinal());
        DropRankType dropRankType = DropRankType.RANK_RISE_TYPE_USDT;
        int e12 = SP.e("sp_key_risk_rank_type_210807", dropRankType.ordinal());
        RiseRankType riseRankType2 = RiseRankType.values()[e11];
        DropRankType dropRankType2 = DropRankType.values()[e12];
        boolean E2 = gj.d.n().E();
        if (riseRankType2 != RiseRankType.RANK_RISE_TYPE_FUTURE || E2) {
            this.f73343h = riseRankType2;
            this.f73344i = dropRankType2;
            return;
        }
        this.f73343h = riseRankType;
        this.f73344i = dropRankType;
    }

    public final void P2() {
        Subscription subscription = this.B;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.B.unsubscribe();
        }
        Subscription subscription2 = this.C;
        if (subscription2 != null && !subscription2.isUnsubscribed()) {
            this.C.unsubscribe();
        }
    }

    public final boolean Q1(List<HomeActivityEntity> list) {
        List<HomeActivityEntity> e11 = this.f73352q.e();
        if (list.size() <= 0 || list.size() == e11.size()) {
            int i11 = 0;
            while (i11 < list.size()) {
                if (list.get(i11).img.equals(e11.get(i11).img)) {
                    i11++;
                }
            }
            return false;
        }
        return true;
    }

    public final void Q2() {
        Subscription subscription = this.f73342g;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final boolean R1(long j11) {
        String e11 = ConfigPreferences.e("user_config", "config_current_uid", "");
        long j12 = j11 / Period.DAY_MILLS;
        long parseLong = Long.parseLong(j12 + "");
        int G1 = G1();
        if (G1 != -1) {
            Log.d("IndexTAGPresenter", "closeDay:" + G1 + " curDay:" + parseLong);
            if (((long) G1) == parseLong || !J1()) {
                return false;
            }
        } else if (H1() != -1 && TextUtils.isEmpty(e11) && parseLong >= ((long) (H1() + 7))) {
            return false;
        }
        return true;
    }

    public void R2(boolean z11) {
        if (z11) {
            sl.f0.g().i();
            return;
        }
        sl.f0.g().j("pro_information_coin_tag");
        sl.f0.g().m();
    }

    public final boolean S1() {
        RankScreenBean h11;
        RankList Tb = ((s0) getUI()).Tb();
        if (Tb == null) {
            return false;
        }
        if ((Tb.getType() == 1 || Tb.getType() == 6) && (h11 = yl.t.h()) != null && RankScreenBean.SCREEN_VALUE_FUTURE.equals(h11.getScreenValue())) {
            return true;
        }
        return false;
    }

    public final void S2() {
        i6.d.j("FutureRank", "subscribeFutureMarketWebSocket");
        o6.b.g().i();
        m9.r.g().i();
        i8.k.g().i();
    }

    public final void T1(int i11, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("liveStatus", i11);
        bundle.putString("liveId", str);
        HbgRouter.i(getActivity(), "/live/room", bundle);
    }

    public final void T2(int i11) {
        if (i11 == 1) {
            K2();
        } else if (i11 == 2) {
            J2();
        } else if (i11 == 3) {
            L2();
        }
    }

    public void U(Bundle bundle) {
        super.U(bundle);
        gs.d.a().c("INDEX_STEP_1");
        P1();
    }

    public void U1(int i11) {
        getActivity().startActivity(com.huobi.utils.k0.m(getActivity(), 40));
    }

    public final void U2() {
        Subscriber<Boolean> subscriber = this.f73354s;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void V() {
        super.V();
        U2();
    }

    public final void V1(int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt("view_type_key", i11);
        HbgRouter.i(getActivity(), "/live/sub", bundle);
    }

    public final void V2() {
        i6.d.j("FutureRank", "unsubscribeFutureMarketWebSocket");
        o6.b.g().m();
        m9.r.g().m();
    }

    public void W2() {
        ((s0) getUI()).t6(!TextUtils.isEmpty(this.N.n()) && System.currentTimeMillis() - SP.g("sp_key_last_time_extra_tag", 0) > Period.DAY_MILLS);
    }

    public final void X2() {
        ((s0) getUI()).sa(this.N.o());
    }

    public final void Y2(int i11, IndexFeature indexFeature) {
        if (i11 == 6) {
            ((s0) getUI()).rg(indexFeature);
        }
    }

    public void Z(boolean z11) {
        super.Z(z11);
        Log.d("IndexTAGPresenter", "presenter--onVisibleChangedFinal -- visible:" + z11);
        this.f73345j.q(z11);
        if (z11) {
            if (!EventBus.d().i(this)) {
                EventBus.d().p(this);
            }
            gs.d.a().d("INDEX_STEP_2");
            i6.d.j("FutureRank", "onVisibleChange true");
            if (tg.r.x().F0()) {
                E2();
            } else {
                l3();
            }
            cl.c.c().h("index");
            D1(6);
        } else {
            this.D.removeMessages(0);
            ((s0) getUI()).dismissProgressDialog();
            if (EventBus.d().i(this)) {
                EventBus.d().r(this);
            }
            n1();
            U2();
            i6.d.j("FutureRank", "onVisibleChange false");
            AssetDataCacheManager.k0().B1();
            P2();
        }
        if (z11) {
            j2();
            gj.b.j().w();
            return;
        }
        Q2();
    }

    public void Z2(List<g.b> list, int i11) {
        i6.d.j("FutureRank", "updateFutureRankItemList rankFragmentTYpe=" + i11 + " rankItemList.size=" + list.size());
        ((s0) getUI()).o5(yl.t.a(getActivity(), list), i11);
    }

    public final void a3() {
        ((s0) getUI()).nd((HomeCommonData) this.I.d());
    }

    public final void b3() {
        List<HomeActivityEntity> list = this.F.m().adList;
        boolean Q1 = Q1(list);
        if (!yl.o.G(this.T)) {
            ((s0) getUI()).mf(true);
            if (Q1) {
                this.f73352q.k(list);
                ((s0) getUI()).I2(1, list.size());
                ((s0) getUI()).a2().setPlayDelay(5000);
                ((s0) getUI()).a2().setAdapter(this.f73352q);
                ((s0) getUI()).a2().pagerToStartMove();
                this.f73352q.notifyDataSetChanged();
                this.f73352q.i(0);
                TimeMonitorManager.a().b("index_banner_consume").a("index_banner_consume", this.R ? "cache" : OptionsBridge.NETWORK_KEY, true);
                i6.u.f68196a.a("index_banner_consume", 0);
                return;
            }
            return;
        }
        ((s0) getUI()).mf(false);
        ((s0) getUI()).Hc(getResources().getColor(R.color.baseColorDeepestBackground));
    }

    public final void c3() {
        List list = (List) this.N.d();
        boolean q11 = this.N.q();
        boolean z11 = false;
        if (q11 && (list == null || list.isEmpty())) {
            q11 = false;
        }
        if (SP.l("key_index_biz_use_assets_cache", false) && list != null && !list.isEmpty()) {
            q11 = true;
        }
        if (!yl.o.G(this.T)) {
            z11 = q11;
        }
        ((s0) getUI()).d5(z11, list);
        if (this.R) {
            TimeMonitorManager.a().b("index_biz_consume").a("index_biz_consume", "cache", true);
            i6.u.f68196a.a("index_biz_consume", 0);
            return;
        }
        TimeMonitorManager.a().b("index_biz_consume").a("index_biz_consume", OptionsBridge.NETWORK_KEY, true);
        i6.u.f68196a.a("index_biz_consume", 0);
    }

    public void d3() {
        List<HomeActivityEntity> list = this.G.m().adList;
        ((s0) getUI()).h7(list != null && !list.isEmpty(), list);
    }

    public final void e3() {
        b3();
        h3();
        k3(1);
        i3();
        c3();
        f3();
        g3();
        W2();
        X2();
        j3();
        if (NetworkStatus.c(getActivity())) {
            m2();
        }
    }

    public final void f3() {
        HomePageEarnData homePageEarnData = (HomePageEarnData) this.O.d();
        boolean n11 = this.O.n();
        if (SP.l("key_index_earn_use_assets_cache", false)) {
            n11 = true;
        }
        ((s0) getUI()).lb(n11, homePageEarnData);
        TimeMonitorManager.a().b("index_earn_consume").a("index_earn_consume", this.R ? "cache" : OptionsBridge.NETWORK_KEY, true);
        i6.u.f68196a.a("index_earn_consume", 0);
    }

    public final void g2() {
        String A2 = yl.o.A("index_banner_cache.json");
        String A3 = yl.o.A("index_notice_cache.json");
        String A4 = yl.o.A("index_quick_cache.json");
        String A5 = yl.o.A("index_biz_cache.json");
        String A6 = yl.o.A("index_earn_cache.json");
        String A7 = yl.o.A("index_invest_cache.json");
        String A8 = yl.o.A("index_live_cache.json");
        try {
            JSONObject jSONObject = new JSONObject(A2).getJSONObject("data");
            this.F.j((HomeActivityEntityResponse) GsonHelper.a().fromJson(jSONObject.toString(), new f0().getType()));
            JSONObject jSONObject2 = new JSONObject(A3).getJSONObject("data");
            this.L.j((HomePageNoticeData) GsonHelper.a().fromJson(jSONObject2.toString(), new m0().getType()));
            this.M.j(((IndexFeature) GsonHelper.a().fromJson(new JSONObject(A4).getJSONObject("data").toString(), new n0().getType())).getIndexFeatureItems());
            JSONObject jSONObject3 = new JSONObject(A5).getJSONObject("data");
            this.N.u((HomePageData) GsonHelper.a().fromJson(jSONObject3.toString(), new o0().getType()));
            JSONObject jSONObject4 = new JSONObject(A6).getJSONObject("data");
            this.O.j((HomePageEarnData) GsonHelper.a().fromJson(jSONObject4.toString(), new p0().getType()));
            JSONObject jSONObject5 = new JSONObject(A7).getJSONObject("data");
            this.P.j((HomePageInvestData) GsonHelper.a().fromJson(jSONObject5.toString(), new q0().getType()));
            JSONArray jSONArray = new JSONObject(A8).getJSONArray("data");
            this.Q.p((List) GsonHelper.a().fromJson(jSONArray.toString(), new r0().getType()));
            Log.d("IndexTAGPresenter", "loadCacheFromAsserts");
        } catch (JSONException e11) {
            e11.printStackTrace();
            Log.e("IndexTAGPresenter", "loadCacheFromAsserts -- e:" + e11.getMessage());
        }
    }

    public final void g3() {
        ((s0) getUI()).Oe((HomePageInvestData) this.P.d());
    }

    public final void h2() {
        i6.d.c("ray12", "loadHomePageCache " + Thread.currentThread().getName());
        this.F.h();
        this.L.h();
        this.M.h();
        this.N.h();
        this.O.h();
        this.P.h();
        this.Q.h();
    }

    public final void h3() {
        List<HomePageNoticeData.Notice> m11 = this.L.m();
        ((s0) getUI()).y4(m11 != null && !m11.isEmpty(), m11);
        if (this.R) {
            TimeMonitorManager.a().b("index_announcement_consume").a("index_announcement_consume", "cache", true);
            i6.u.f68196a.a("index_announcement_consume", 0);
            return;
        }
        TimeMonitorManager.a().b("index_announcement_consume").a("index_announcement_consume", OptionsBridge.NETWORK_KEY, true);
        i6.u.f68196a.a("index_announcement_consume", 0);
    }

    public final void i2() {
        if (NetworkStatus.c(getActivity())) {
            this.D.removeMessages(0);
            this.D.sendEmptyMessageDelayed(0, 15000);
            i6.d.c("ray21", "loopHbgSymbolsPrice 1" + SymbolsDataProvider.l() + SuperMarginSymbolConfigUtil.j());
            M2();
            a1.v().z0(true).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new a());
        }
    }

    public final void i3() {
        List list = (List) this.M.d();
        boolean m11 = this.M.m();
        if (m11 && (list == null || list.isEmpty())) {
            m11 = false;
        }
        ((s0) getUI()).g7(m11, list);
        System.currentTimeMillis();
        IndexLifeCycleTracer.c().f(IndexLifeCycleStep.AppHomePageDone);
        if (this.R) {
            TimeMonitorManager.a().b("index_operation_consume").a("index_operation_consume", "cache", true);
            i6.u.f68196a.a("index_operation_consume", 0);
            return;
        }
        TimeMonitorManager.a().b("index_operation_consume").a("index_operation_consume", OptionsBridge.NETWORK_KEY, true);
        i6.u.f68196a.a("index_operation_consume", 0);
    }

    public final void j2() {
        if (tg.r.x().F0()) {
            this.f73342g = Observable.interval(0, 1, TimeUnit.MINUTES).flatMap(new n()).onErrorReturn(new m()).subscribe(new l());
        }
    }

    public final void j3() {
        List<LiveDetailBean> m11 = this.Q.m();
        this.S = this.Q.n();
        ArrayList arrayList = new ArrayList();
        this.V = new t0();
        boolean z11 = false;
        if (m11 != null) {
            int min = Math.min(m11.size(), 3);
            r1(m11, min);
            for (int i11 = 0; i11 < min; i11++) {
                IndexLiveItem indexLiveItem = new IndexLiveItem();
                indexLiveItem.f(m11.get(i11));
                if (min == 1) {
                    indexLiveItem.d().setViewType(3);
                } else if (min == 2) {
                    indexLiveItem.d().setViewType(4);
                } else if (i11 == 0) {
                    indexLiveItem.d().setViewType(3);
                } else {
                    indexLiveItem.d().setViewType(4);
                }
                indexLiveItem.g(this.V);
                arrayList.add(indexLiveItem);
            }
        }
        this.Q.q(arrayList);
        if (this.S && !arrayList.isEmpty()) {
            z11 = true;
        }
        this.S = z11;
        ((s0) getUI()).e5(this.S, arrayList);
    }

    /* renamed from: k2 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, s0 s0Var) {
        super.onUIReady(baseCoreActivity, s0Var);
        Log.d("IndexTAGPresenter", "onUIReady");
        yg.a aVar = new yg.a(((s0) getUI()).a2());
        this.f73352q = aVar;
        aVar.setPosDelta(-1);
        this.f73352q.l(1003);
        this.f73352q.j(this.f73351p);
        ((s0) getUI()).a2().setAdapter(this.f73352q);
        this.f73352q.m(true);
        try {
            ((s0) getUI()).a2().getViewPager().addOnPageChangeListener(new j());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        u2();
        I2();
        this.D.sendEmptyMessageDelayed(0, 15000);
        if (!ConfigPreferences.c("user_config", "CONFIG_APP_DELETE_SUPER_MARGIN", false)) {
            i6.k.d(ShareConstants.ACTION, "全仓交易对清除本地数据");
            SuperMarginSymbolConfigUtil.e();
            ConfigPreferences.n("user_config", "CONFIG_APP_DELETE_SUPER_MARGIN", true);
        }
        I1();
        i6.d.c("DataDiffTools", "APP START");
        d7.m.c();
        d7.y.h(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        d7.s.q();
        LegalCurrencyConfigUtil.e().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        IndexCurrencyInfoController.k().g(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        Observable.zip(ContractCurrencyUtils.g(false), SwapCurrencyInfoController.k().f(false), x.f73475b).compose(RxJavaHelper.s()).subscribe(new u());
        FutureContractInfoController.n().s(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        FutureProductInfoController.d().h(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        FutureContractInfoController.n().q(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        FutureProductInfoController.d().i(TradeType.LINEAR_SWAP, false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        zq.e.e().f(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
    }

    public final void k3(int i11) {
        long j11;
        Log.d("IndexTAGPresenter", "fromSourceType:" + i11);
        HomePageNewUserGiftBagData homePageNewUserGiftBagData = (HomePageNewUserGiftBagData) this.H.d();
        boolean m11 = this.H.m();
        if (homePageNewUserGiftBagData == null || homePageNewUserGiftBagData.getCurDate() == 0) {
            j11 = System.currentTimeMillis();
        } else {
            j11 = homePageNewUserGiftBagData.getCurDate();
        }
        long j12 = j11;
        boolean R1 = R1(j12);
        ((s0) getUI()).A9(R1, m11, SP.e("sp_key_index_home_flow_config_user_guide", 0) == 1, homePageNewUserGiftBagData, j12, i11);
        if (R1 && m11 && homePageNewUserGiftBagData != null) {
            T2(3);
        }
    }

    public final void l2() {
        HomePageJumpData url;
        String jumpUrl;
        if (!com.huobi.webcache.c.j().m()) {
            this.W = true;
            List<HomeActivityEntity> list = this.F.m().adList;
            List<IndexFeatureItem> list2 = (List) this.M.d();
            List<IndexBizData> list3 = (List) this.N.d();
            List<String> arrayList = new ArrayList<>();
            if (list != null && list.size() > 0) {
                for (HomeActivityEntity homeActivityEntity : list) {
                    String str = homeActivityEntity.url;
                    if (str != null && str.length() > 0 && !arrayList.contains(str) && HbgRouter.e(str) && H5CacheServiceHelper.getConfigBean().cacheBannerUrl) {
                        arrayList.add(str);
                    }
                }
            }
            if (list2 != null && list2.size() > 0) {
                for (IndexFeatureItem jumpUrl2 : list2) {
                    String jumpUrl3 = jumpUrl2.getJumpUrl();
                    if (jumpUrl3 != null && jumpUrl3.length() > 0 && !arrayList.contains(jumpUrl3) && HbgRouter.e(jumpUrl3) && H5CacheServiceHelper.getConfigBean().cacheFunctionUrl) {
                        arrayList.add(m1(jumpUrl3));
                    }
                }
            }
            if (list3 != null && list3.size() > 0) {
                for (IndexBizData data : list3) {
                    HomePageBizData data2 = data.getData();
                    if (data2 != null && (url = data2.getUrl()) != null && (jumpUrl = url.getJumpUrl()) != null && jumpUrl.length() > 0 && !arrayList.contains(jumpUrl) && HbgRouter.e(jumpUrl) && H5CacheServiceHelper.getConfigBean().cacheBizUrl) {
                        arrayList.add(m1(jumpUrl));
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add("topic/primelist");
            arrayList2.add("topic/activity");
            arrayList2.add("topic/mining");
            arrayList2.add("welcome-bonus");
            arrayList2.add("topic/trading-activity-tmpl");
            arrayList2.add("topic/christmas");
            if (arrayList.size() > 20) {
                arrayList = arrayList.subList(0, 20);
            }
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            arrayList4.addAll(arrayList);
            for (String str2 : arrayList) {
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (str2.contains((String) it2.next())) {
                            arrayList4.remove(str2);
                            arrayList3.add(str2);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Accept-Language", AppLanguageHelper.getInstance().getCurLanguageHeader());
            ArrayList<String> arrayList5 = new ArrayList<>();
            arrayList5.addAll(arrayList3);
            arrayList5.addAll(arrayList4);
            HashSet hashSet = new HashSet();
            for (String next : H5CacheServiceHelper.getConfigBean().preloadUrlList) {
                if (!TextUtils.isEmpty(next)) {
                    if (next.startsWith("/")) {
                        hashSet.add(com.huobi.utils.a0.j() + next);
                    } else if (next.startsWith("http")) {
                        hashSet.add(next);
                    } else if (next.startsWith("$host") || next.contains("$language") || next.contains("$version")) {
                        hashSet.add(next.replace("$host", com.huobi.utils.a0.j()).replace("$language", m6.a.f().toLowerCase()).replace("$version", "10.54.0"));
                    }
                }
            }
            for (String str3 : arrayList5) {
                if (!str3.contains("/p/page") && !str3.startsWith("holigeit")) {
                    hashSet.add(str3);
                }
            }
            if (H5CacheServiceHelper.isIsInit()) {
                H5CacheServiceHelper.startPreloadService(getActivity(), hashSet, hashMap, false);
            } else {
                H5CacheServiceHelper.init(new a0(hashSet, hashMap));
            }
        }
    }

    public final void l3() {
        yl.g.h().j().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new k());
    }

    public String m1(String str) {
        String format = String.format("userAgent=%s&version=%s&deviceId=%s&locale=%s&appversion=%s&isnight=%s", new Object[]{StringUtils.b("M:huobiapp:phone:android"), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(PhoneUtils.e()), StringUtils.b(com.hbg.lib.core.util.p.b()), StringUtils.b(String.valueOf(GlobalAppConfig.c())), StringUtils.b(String.valueOf(NightHelper.e().g() ? 1 : 0))});
        if (str.contains("?")) {
            return str + ContainerUtils.FIELD_DELIMITER + format;
        }
        return str + "?" + format;
    }

    public final void m2() {
        if (!this.W) {
            new Handler(Looper.getMainLooper()).postDelayed(new z(), H5CacheServiceHelper.getConfigBean().delaySecond);
        }
    }

    public final void n1() {
        Subscription subscription = this.f73341f;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.f73341f.unsubscribe();
            this.f73341f = null;
        }
    }

    /* renamed from: n2 */
    public void f2(boolean z11) {
        Log.d("IndexTAGPresenter", "realRequestHomePageData -- firstRequest:" + z11);
        if (z11) {
            this.F.a();
            this.L.a();
            this.G.a();
            this.M.a();
            this.N.a();
            this.L.a();
            this.Q.a();
            this.H.a();
            this.I.a();
        }
        i2();
        i6.d.j("IndexTAGPresenter", "requestHomePageData 是否是首次接口请求 -- firstRequest" + z11);
        if (!yl.o.G(this.T)) {
            q2();
            y2();
            if (SP.e("sp_key_index_home_flow_config_user_guide", 0) == 0) {
                C2();
            } else {
                ((s0) getUI()).R7(false);
            }
        }
        z2();
        s2();
        r2();
        w2();
        x2();
        A2();
        ((s0) getUI()).Q7(0);
        p2();
    }

    public void o1() {
        boolean isCanBeSeen = ((s0) getUI()).isCanBeSeen();
        boolean S1 = S1();
        i6.d.j("FutureRank", "checkFutureSub canBeSeen=" + isCanBeSeen + " showingFutureRank=" + S1);
        if (!isCanBeSeen || !S1) {
            V2();
        } else {
            S2();
        }
    }

    public void o2() {
        i6.d.c("IndexPresenterLoading", "1.reloadData() called");
        i6.d.j("IndexTAGPresenter", "reloadData 有网络:" + NetworkStatus.c(getActivity()) + " 有排行榜数据:" + M1());
        if (NetworkStatus.c(getActivity()) || M1() || L1()) {
            i6.d.c("IndexPresenterLoading", "2.hasData() " + M1());
            i6.d.j("FutureRank", "Reload data.");
            o1();
            gs.d.a().d("INDEX_STEP_1");
        } else {
            I2();
            this.D.removeMessages(0);
        }
        E1();
        i2();
        if (this.f73350o) {
            this.f73350o = false;
        } else {
            v2();
        }
        ad.o.e().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        ((s0) getUI()).y0(true);
        if (tg.r.x().F0()) {
            d7.k0.d(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
            d7.g0.e(false).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new BaseSubscriber());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.D.removeCallbacksAndMessages((Object) null);
        i6.k.d("IndexPresenterLoading", "onDestroy() called");
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onRankFilterChanged(t.b bVar) {
        i6.d.j("FutureRank", "onRankFilterChanged event=" + bVar.toString());
        o1();
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getUI() != null && ((s0) getUI()).isCanBeSeen()) {
            rn.c.i().m(getActivity(), (kn.a) null);
        }
    }

    public boolean p1(Activity activity) {
        if (tg.r.x().F0()) {
            return true;
        }
        rn.c.i().d(activity, new JumpTarget((Intent) null, (Intent) null));
        return false;
    }

    public final void p2() {
        u1().subscribe(new k0());
    }

    public final Subscriber<List<LiveDetailBean>> q1() {
        return new v();
    }

    public final void q2() {
        v1().subscribe(new b0());
    }

    public final void r1(List<LiveDetailBean> list, int i11) {
        this.D.removeMessages(11);
        long j11 = Long.MAX_VALUE;
        for (int i12 = 0; i12 < i11; i12++) {
            LiveDetailBean liveDetailBean = list.get(i12);
            if (liveDetailBean.status == 1) {
                long j12 = liveDetailBean.finishTime - liveDetailBean.currentTime;
                if (j11 > 0) {
                    j11 = Math.min(j11, j12);
                }
            }
        }
        if (j11 != Long.MAX_VALUE && j11 < TimeUnit.HOURS.toMillis(1)) {
            this.D.sendEmptyMessageDelayed(11, j11);
        }
    }

    public final void r2() {
        yl.g.h().q().flatMap(new u(this)).compose(RxJavaHelper.t((u6.g) null)).subscribe(new g0());
        yl.g.h().p();
    }

    public final void s1() {
        Observable<R> observable;
        n1();
        if (gj.a.b().d()) {
            observable = Observable.zip(v7.b.a().getCouponUserOtc().b().compose(RxJavaHelper.t((u6.g) getUI())).onErrorResumeNext(Observable.just(null)), AssetDataCacheManager.k0().z0().compose(RxJavaHelper.t((u6.g) getUI())).onErrorResumeNext(Observable.just(Boolean.FALSE)), w.f73474b);
        } else {
            observable = AssetDataCacheManager.k0().z0().compose(RxJavaHelper.t((u6.g) getUI())).onErrorResumeNext(Observable.just(Boolean.FALSE));
        }
        this.f73341f = observable.subscribe((Subscriber<? super R>) new p());
    }

    public final void s2() {
        x1().subscribe(new c0());
    }

    public String t1() {
        return this.N.n();
    }

    public void t2(boolean z11) {
        boolean b11 = yl.i.a().b();
        if (b11) {
            this.R = false;
            T2(1);
        } else {
            this.R = true;
            Observable.create(new r(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new s());
        }
        if (z11) {
            N1(new p(this, b11));
        }
    }

    public final Observable<HomeCommonData> u1() {
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-language", AppLanguageHelper.getInstance().getCurLanguageHeader());
        int g11 = yl.g.h().g();
        if (g11 == -1) {
            try {
                String a11 = sn.a.c().a();
                if (!com.hbg.module.libkt.base.ext.b.x(a11)) {
                    g11 = Integer.parseInt(a11);
                }
            } catch (NumberFormatException e11) {
                e11.printStackTrace();
            }
        }
        hashMap.put("HB-COUNTRY-ID", Integer.valueOf(g11));
        return ((IndexService) tq.p.C(IndexService.class)).requestHomeCommonData(hashMap).compose(tq.p.E()).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public final void u2() {
        Observable.create(new s(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new r());
    }

    public final Observable<HomeActivityEntityResponse> v1() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "52");
        hashMap.put("userAgent", "M:huobiapp:phone:android");
        hashMap.put("channel_name", "huobi");
        hashMap.put("version", 105400);
        hashMap.put(Constants.FLAG_DEVICE_ID, PhoneUtils.e());
        hashMap.put("lang", AppLanguageHelper.getInstance().getCurLanguageHeader());
        if (!TextUtils.isEmpty(tg.r.x().J())) {
            hashMap.put("uId", tg.r.x().J());
        }
        int g11 = yl.g.h().g();
        if (g11 == -1) {
            try {
                String a11 = sn.a.c().a();
                if (!com.hbg.module.libkt.base.ext.b.x(a11)) {
                    g11 = Integer.parseInt(a11);
                }
            } catch (NumberFormatException e11) {
                e11.printStackTrace();
            }
        }
        String b11 = com.huobi.utils.x.b();
        if (TextUtils.isEmpty(b11)) {
            b11 = "1";
        }
        HashMap hashMap2 = new HashMap();
        if (g11 > 0) {
            hashMap2.put("clientCountryId", Integer.valueOf(g11));
        }
        hashMap2.put("countryType", b11);
        return ((IndexService) tq.p.C(IndexService.class)).requestAdvertisements(hashMap, hashMap2).compose(tq.p.E()).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public final void v2() {
        boolean b11 = yl.i.a().b();
        if (b11) {
            this.R = false;
            T2(1);
        } else {
            this.R = true;
            h2();
            e3();
            T2(3);
        }
        N1(new q(this, b11));
    }

    public final Observable<HomePageData> w1() {
        if (!this.N.g()) {
            return Observable.just(null);
        }
        int g11 = yl.g.h().g();
        boolean g12 = NightHelper.e().g();
        String upperCase = LegalCurrencyConfigUtil.d().toUpperCase();
        HashMap hashMap = new HashMap();
        hashMap.put("countryType", com.huobi.utils.x.b());
        hashMap.put("HB-CTX-ID", ConfigPreferences.e("user_config", "config_current_uid", ""));
        return v7.b.a().O0(upperCase, g11, g12 ? 1 : 0, hashMap).b().compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public final void w2() {
        y1().subscribe(new h0());
    }

    public final Observable<HomeActivityEntityResponse> x1() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "100");
        hashMap.put("userAgent", "M:huobiapp:phone:android");
        hashMap.put("channel_name", "huobi");
        hashMap.put("version", 105400);
        hashMap.put(Constants.FLAG_DEVICE_ID, PhoneUtils.e());
        hashMap.put("lang", AppLanguageHelper.getInstance().getCurLanguageHeader());
        if (!TextUtils.isEmpty(tg.r.x().J())) {
            hashMap.put("uId", tg.r.x().J());
        }
        int g11 = yl.g.h().g();
        if (g11 == -1) {
            try {
                String a11 = sn.a.c().a();
                if (!com.hbg.module.libkt.base.ext.b.x(a11)) {
                    g11 = Integer.parseInt(a11);
                }
            } catch (NumberFormatException e11) {
                e11.printStackTrace();
            }
        }
        String b11 = com.huobi.utils.x.b();
        if (TextUtils.isEmpty(b11)) {
            b11 = "1";
        }
        HashMap hashMap2 = new HashMap();
        if (g11 > 0) {
            hashMap2.put("clientCountryId", Integer.valueOf(g11));
        }
        hashMap2.put("countryType", b11);
        return ((IndexService) tq.p.C(IndexService.class)).requestAdvertisements(hashMap, hashMap2).compose(tq.p.E()).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public final void x2() {
        z1().subscribe(new i0());
    }

    public final Observable<HomePageEarnData> y1() {
        if (!this.O.g()) {
            return Observable.just(null);
        }
        return v7.b.a().getEarnArea().b().compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public final void y2() {
        B1().subscribe(new d0());
    }

    public final Observable<HomePageInvestData> z1() {
        if (!this.P.g()) {
            return Observable.just(null);
        }
        return v7.b.a().getInvestArea(yl.g.h().g()).b().compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public final void z2() {
        C1().subscribe(new e0());
    }
}
