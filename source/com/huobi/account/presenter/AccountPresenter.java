package com.huobi.account.presenter;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.AccountChallengeTask;
import com.hbg.lib.network.hbg.core.bean.AccountNewComerTask;
import com.hbg.lib.network.hbg.core.bean.AccountTaskResp;
import com.hbg.lib.network.hbg.core.bean.CommunityData;
import com.hbg.lib.network.hbg.core.bean.CustomerData;
import com.hbg.lib.network.hbg.core.bean.MedalUserInfo;
import com.hbg.lib.network.hbg.core.bean.MyPrimeInfo;
import com.hbg.lib.network.hbg.core.bean.PersonalcenterActivityInfoBean;
import com.hbg.lib.network.hbg.core.bean.RewardInfo;
import com.hbg.lib.network.hbg.core.bean.SubscribeBox;
import com.hbg.lib.network.newkyc.bean.UnifyKycInfo;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.TopScrollView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.notice.TopScrollNoticeView2;
import com.hbg.module.huobi.im.IMConversationHelper;
import com.hbg.module.huobi.im.RedPoint.a;
import com.huobi.account.api.AccountService;
import com.huobi.account.bean.AccountKycInfo;
import com.huobi.account.bean.BoxToolRespBean;
import com.huobi.account.bean.KnapsackItem;
import com.huobi.account.entity.AccountBoxItem;
import com.huobi.account.entity.HomeActivityEntityResponse;
import com.huobi.account.entity.InviteConfigBean;
import com.huobi.account.widget.BoxNewcomerView;
import com.huobi.account.widget.CountDownLayout;
import com.huobi.apm.TimeMonitorManager;
import com.huobi.entity.HomeActivityEntity;
import com.huobi.entity.UpdateResponse;
import com.huobi.entity.UserTransInfo;
import com.huobi.index.api.IndexService;
import com.huobi.index.bean.IndexFeature;
import com.huobi.index.bean.IndexFeatureItem;
import com.huobi.index.helper.data.AccountBannerModule;
import com.huobi.index.helper.data.AccountQuickModule;
import com.huobi.index.ui.widget.HBIndicatorView;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.main.helper.NewAccountTabRedDotHelper;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.utils.UpgradeUtil;
import com.huobi.utils.UserInfoUtil;
import com.huobi.utils.x;
import com.huobi.view.LightBubblePopup;
import com.huobi.view.rollviewpager.RollPagerView;
import com.huobi.view.roundview.RoundTextView;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.android.tpush.common.Constants;
import d7.a1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import sl.f0;
import tg.r;

public class AccountPresenter extends BaseFragmentPresenter<q> {

    /* renamed from: c  reason: collision with root package name */
    public String f40994c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40995d = true;

    /* renamed from: e  reason: collision with root package name */
    public final AccountQuickModule f40996e = new AccountQuickModule();

    /* renamed from: f  reason: collision with root package name */
    public final AccountBannerModule f40997f = new AccountBannerModule();

    /* renamed from: g  reason: collision with root package name */
    public yg.a f40998g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayMap<Integer, AccountBoxItem> f40999h = new ArrayMap<>();

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f41000i = null;

    /* renamed from: j  reason: collision with root package name */
    public TextView f41001j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f41002k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f41003l = true;

    /* renamed from: m  reason: collision with root package name */
    public int f41004m;

    /* renamed from: n  reason: collision with root package name */
    public int f41005n = 0;

    /* renamed from: o  reason: collision with root package name */
    public CustomerData f41006o;

    public class a extends BaseSubscriber<Object> {
        public a() {
        }

        public void onError(Throwable th2) {
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public class b implements TopScrollView.b {
        public b() {
        }

        public void a(TopScrollData topScrollData) {
        }

        public void b() {
        }

        public void c(TopScrollData topScrollData) {
            if (topScrollData != null && !TextUtils.isEmpty(topScrollData.j())) {
                BaseModuleConfig.a().k0(topScrollData.j());
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
            if (((q) AccountPresenter.this.getUI()).F6() != null) {
                ((q) AccountPresenter.this.getUI()).F6().dismiss();
            }
            int unused = AccountPresenter.this.f41004m = i11;
        }
    }

    public class d extends BaseSubscriber<CommunityData> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(CommunityData communityData) {
            super.onNext(communityData);
            ((q) AccountPresenter.this.getUI()).p4(communityData);
        }
    }

    public class e extends BaseSubscriber<Object> {
        public e() {
        }

        public void onError(Throwable th2) {
            th2.printStackTrace();
            AccountPresenter.this.f40999h.clear();
            AccountPresenter.this.s1();
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            AccountPresenter.this.s1();
        }
    }

    public class f extends BaseSubscriber<MyPrimeInfo> {
        public f() {
        }

        /* renamed from: a */
        public void onNext(MyPrimeInfo myPrimeInfo) {
            super.onNext(myPrimeInfo);
            ((q) AccountPresenter.this.getUI()).ke(myPrimeInfo);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ((q) AccountPresenter.this.getUI()).ke((MyPrimeInfo) null);
        }
    }

    public class g extends BaseSubscriber<MedalUserInfo> {
        public g() {
        }

        /* renamed from: a */
        public void onNext(MedalUserInfo medalUserInfo) {
            super.onNext(medalUserInfo);
            ((q) AccountPresenter.this.getUI()).Sb(medalUserInfo);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            ((q) AccountPresenter.this.getUI()).Sb((MedalUserInfo) null);
        }
    }

    public class h implements a.C0138a {
        public h() {
        }

        public void a(com.hbg.module.huobi.im.RedPoint.a aVar) {
            if (AccountPresenter.this.f41001j != null) {
                int b11 = aVar.b();
                if (b11 > 0) {
                    AccountPresenter.this.f41001j.setVisibility(0);
                    TextView t02 = AccountPresenter.this.f41001j;
                    t02.setText(b11 + "");
                } else {
                    AccountPresenter.this.f41001j.setVisibility(8);
                }
                int unused = AccountPresenter.this.f41005n = b11;
            }
        }
    }

    public class i implements IMConversationHelper.g {
        public i() {
        }

        public void a(String str) {
            if (AccountPresenter.this.f41006o != null) {
                AccountPresenter.this.f41006o.setFeedback(str);
            }
            if (AccountPresenter.this.f41002k != null) {
                AccountPresenter.this.f41002k.setText(str);
            }
        }
    }

    public class j implements ViewPager.OnPageChangeListener {
        public j() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            List<HomeActivityEntity> e11 = AccountPresenter.this.f40998g.e();
            int size = i11 % e11.size();
            ((q) AccountPresenter.this.getUI()).I2(size + 1, AccountPresenter.this.f40998g.e().size());
            if (e11.size() > size) {
                HashMap hashMap = new HashMap();
                hashMap.put("name", e11.get(size).adName);
                gs.g.i("Banner_Me_show", hashMap);
            }
        }
    }

    public class k extends BaseSubscriber<InviteConfigBean> {
        public k() {
        }

        /* renamed from: a */
        public void onNext(InviteConfigBean inviteConfigBean) {
            super.onNext(inviteConfigBean);
            boolean unused = AccountPresenter.this.f40995d = inviteConfigBean.isNewCommission();
        }
    }

    public class l extends BaseSubscriber<UpdateResponse> {
        public l() {
        }

        /* renamed from: a */
        public void onNext(UpdateResponse updateResponse) {
            super.onNext(updateResponse);
            String downloadurl = updateResponse.getDownloadurl();
            if (updateResponse.getVersion_code() <= 105400) {
                UpgradeUtil.d((String) null);
                return;
            }
            UpgradeUtil.d(downloadurl);
            ((q) AccountPresenter.this.getUI()).c9(UpgradeUtil.c());
            AccountPresenter.this.g1();
            if (updateResponse.getMd5() != null && updateResponse.getDirect_downloadurl() != null) {
                eh.h.q().k(updateResponse);
            }
        }
    }

    public class m extends BaseSubscriber<IndexFeature> {
        public m() {
        }

        /* renamed from: a */
        public void onNext(IndexFeature indexFeature) {
            List<IndexFeatureItem> list;
            AccountQuickModule D0 = AccountPresenter.this.f40996e;
            if (indexFeature == null) {
                list = null;
            } else {
                list = indexFeature.getIndexFeatureItems();
            }
            D0.j(list);
        }

        public void onAfter() {
            super.onAfter();
            AccountPresenter.this.q1();
        }
    }

    public class n extends BaseSubscriber<IndexFeature> {
        public n() {
        }

        /* renamed from: a */
        public void onNext(IndexFeature indexFeature) {
            ((q) AccountPresenter.this.getUI()).C6(indexFeature.getIndexFeatureItems());
        }

        public void onError(Throwable th2) {
            ((q) AccountPresenter.this.getUI()).C6((List<IndexFeatureItem>) null);
        }
    }

    public class o extends BaseSubscriber<HomeActivityEntityResponse> {
        public o() {
        }

        /* renamed from: a */
        public void onNext(HomeActivityEntityResponse homeActivityEntityResponse) {
            super.onNext(homeActivityEntityResponse);
            AccountPresenter.this.f40997f.j(homeActivityEntityResponse);
        }

        public void onAfter() {
            super.onAfter();
            AccountPresenter.this.p1();
        }
    }

    public class p implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CountDownLayout f41022b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SubscribeBox.ListBean f41023c;

        public p(CountDownLayout countDownLayout, SubscribeBox.ListBean listBean) {
            this.f41022b = countDownLayout;
            this.f41023c = listBean;
        }

        public void run() {
            this.f41022b.setTime(this.f41023c.getCountDown());
            SubscribeBox.ListBean listBean = this.f41023c;
            listBean.setCountDown(listBean.getCountDown() - 1000);
            this.f41022b.postDelayed(this, 1000);
        }
    }

    public interface q extends u6.g {
        void C6(List<IndexFeatureItem> list);

        LightBubblePopup F6();

        void I2(int i11, int i12);

        LinearLayout I8();

        void Pb();

        void Sb(MedalUserInfo medalUserInfo);

        void W9(AccountKycInfo accountKycInfo);

        void Z3(UnifyKycInfo unifyKycInfo);

        RollPagerView a2();

        void ab();

        void c9(boolean z11);

        void fa(boolean z11, List<IndexFeatureItem> list);

        void ke(MyPrimeInfo myPrimeInfo);

        void p4(CommunityData communityData);
    }

    public AccountPresenter() {
        IMConversationHelper.o().C(new h());
        IMConversationHelper.o().D(new i());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I0(UserTransInfo userTransInfo, UnifyKycInfo unifyKycInfo) {
        if (userTransInfo != null && getUI() != null && ((q) getUI()).isAlive()) {
            AccountKycInfo accountKycInfo = new AccountKycInfo();
            accountKycInfo.s(userTransInfo.getTitle());
            accountKycInfo.l(userTransInfo.getAvatarUrl());
            accountKycInfo.u("UID " + r.x().J());
            accountKycInfo.t(userTransInfo.isShowKycText());
            accountKycInfo.p(userTransInfo.getKycStateLabel());
            accountKycInfo.r(userTransInfo.getKycStep());
            accountKycInfo.q(userTransInfo.getKycStateWithNoStep());
            accountKycInfo.n(userTransInfo.isInst());
            accountKycInfo.o(userTransInfo.getInstState());
            accountKycInfo.m(unifyKycInfo.isShowOldEntrance());
            ((q) getUI()).W9(accountKycInfo);
            ((q) getUI()).Z3(unifyKycInfo);
        }
    }

    public static /* synthetic */ AccountTaskResp J0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List K0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ RewardInfo L0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ CustomerData M0(Throwable th2) {
        return null;
    }

    public static /* synthetic */ SubscribeBox N0(Throwable th2) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object O0(AccountTaskResp accountTaskResp, List list, RewardInfo rewardInfo, CustomerData customerData, SubscribeBox subscribeBox) {
        this.f40999h.clear();
        if (accountTaskResp != null) {
            this.f40999h.put(0, new AccountBoxItem().g(accountTaskResp));
            i6.d.b("accountTaskBox != null");
        }
        if (list != null && !list.isEmpty()) {
            this.f40999h.put(1, new AccountBoxItem().h(list));
            i6.d.b("userActivityList != null");
        }
        if (rewardInfo != null) {
            this.f40999h.put(5, new AccountBoxItem().j(rewardInfo));
            i6.d.b("rewardInfo != null");
        }
        if (customerData != null) {
            this.f40999h.put(2, new AccountBoxItem().i(customerData));
            i6.d.b("customer != null");
            IMConversationHelper.o().B(customerData.getId());
        }
        if (!(subscribeBox == null || subscribeBox.getMySubscribe() == null || subscribeBox.getMySubscribe().getList() == null || subscribeBox.getMySubscribe().getList().isEmpty())) {
            this.f40999h.put(4, new AccountBoxItem().k(subscribeBox.getMySubscribe()));
            i6.d.b("subscribeBox != null");
        }
        if (this.f40999h.size() % 2 == 0 || subscribeBox == null || subscribeBox.getMyToolResp() == null || subscribeBox.getMyToolResp().getList() == null || subscribeBox.getMyToolResp().getList().isEmpty()) {
            return null;
        }
        this.f40999h.put(999, new AccountBoxItem().l(subscribeBox.getMyToolResp()));
        i6.d.b("subscribeBox ToolResp != null");
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable P0(Throwable th2) {
        InviteConfigBean inviteConfigBean = new InviteConfigBean();
        inviteConfigBean.setCommission(true);
        inviteConfigBean.setNewCommission(true);
        this.f40995d = true;
        return Observable.just(inviteConfigBean);
    }

    public static /* synthetic */ void Q0(AccountChallengeTask accountChallengeTask, Void voidR) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "挑战任务");
        hashMap.put("business_category", "Rewards");
        gs.g.i("box_Me_click", hashMap);
        String url = accountChallengeTask.getCheckInResp().getUrl();
        if (!TextUtils.isEmpty(url)) {
            BaseModuleConfig.a().k0(url);
        }
    }

    public static /* synthetic */ void R0(AccountTaskResp accountTaskResp, Void voidR) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "新手任务");
        hashMap.put("business_category", "Rewards");
        gs.g.i("box_Me_click", hashMap);
        String url = accountTaskResp.getNewTask().getUrl();
        if (!TextUtils.isEmpty(url)) {
            BaseModuleConfig.a().k0(url);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S0(String str, CustomerData customerData, Void voidR) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "专属服务经理");
        hashMap.put("business_category", "");
        hashMap.put("type", "more");
        gs.g.i("box_Me_click", hashMap);
        String n11 = IMConversationHelper.o().n();
        if (!TextUtils.isEmpty(n11)) {
            dd.b.f22740a.h(getActivity(), n11, getResources().getString(R.string.n_im_investment_adviser));
        } else if (!TextUtils.isEmpty(str)) {
            BaseModuleConfig.a().k0(customerData.getUrl());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T0(CustomerData customerData, String str, Void voidR) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "专属服务经理");
        hashMap.put("business_category", customerData.getBusinessCategory());
        hashMap.put("type", "normal");
        gs.g.i("box_Me_click", hashMap);
        String n11 = IMConversationHelper.o().n();
        if (!TextUtils.isEmpty(n11)) {
            dd.b.f22740a.h(getActivity(), n11, getResources().getString(R.string.n_im_investment_adviser));
        } else if (!TextUtils.isEmpty(str)) {
            BaseModuleConfig.a().k0(customerData.getUrl());
        }
    }

    public static /* synthetic */ void U0(KnapsackItem knapsackItem, Void voidR) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "我的背包");
        hashMap.put("business_category", "");
        hashMap.put("type", "more");
        gs.g.i("box_Me_click", hashMap);
        BaseModuleConfig.a().k0(knapsackItem.d());
    }

    public static /* synthetic */ void V0(SubscribeBox.MySubscribeBean mySubscribeBean, Void voidR) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "我的预约");
        hashMap.put("business_category", "");
        hashMap.put("type", "more");
        gs.g.i("box_Me_click", hashMap);
        Uri parse = Uri.parse(mySubscribeBean.getRedirect());
        if (parse != null) {
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.appendQueryParameter("title", mySubscribeBean.getTitle());
            BaseModuleConfig.a().k0(buildUpon.build().toString());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W0(SubscribeBox.MySubscribeBean mySubscribeBean, SubscribeBox.ListBean listBean, View view, Void voidR) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "我的预约");
        hashMap.put("business_category", mySubscribeBean.getBusinessCategory());
        hashMap.put("type", "normal");
        gs.g.i("box_Me_click", hashMap);
        Intent intent = new Intent();
        intent.putExtra("url", listBean.getUrl());
        intent.setClass(getActivity(), HBBaseWebActivity.class);
        getActivity().startActivity(intent);
        view.setVisibility(8);
        if (listBean.getInfoSum() == -1 && !TextUtils.isEmpty(listBean.getRedDot())) {
            v7.b.a().addRedDot(listBean.getRedDot()).b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new a());
        }
    }

    public final Observable<HomeActivityEntityResponse> G0() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", 101);
        hashMap.put("userAgent", "M:huobiapp:phone:android");
        hashMap.put("channel_name", "huobi");
        hashMap.put("version", 105400);
        hashMap.put(Constants.FLAG_DEVICE_ID, PhoneUtils.e());
        hashMap.put("lang", AppLanguageHelper.getInstance().getCurLanguageHeader());
        if (!TextUtils.isEmpty(r.x().J())) {
            hashMap.put("uId", r.x().J());
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
        String b11 = x.b();
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

    public final Observable<IndexFeature> H0(String str) {
        if (!this.f40996e.g()) {
            return Observable.just(null);
        }
        int i11 = 0;
        String J = r.x().J();
        if (!TextUtils.isEmpty(J)) {
            i11 = Integer.parseInt(J);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("platform", 1);
        hashMap.put("version", String.valueOf(105400));
        hashMap.put("nightMode", Integer.valueOf(NightHelper.e().g() ? 1 : 0));
        hashMap.put("uid", Integer.valueOf(i11));
        hashMap.put("moduleSize", 20);
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
        return ((IndexService) tq.p.V(IndexService.class)).getAppFeatures(str, g11, hashMap).compose(tq.p.E()).compose(RxJavaHelper.t((u6.g) getUI()));
    }

    public void X0() {
        UserInfoUtil.g(getActivity(), new ug.h(this));
    }

    public final void Y0() {
        Observable.zip(v7.b.a().getUserTaskInfo().b().compose(RxJavaHelper.t((u6.g) getUI())).onErrorReturn(ug.b.f60575b), v7.b.a().getUserActivityList().b().compose(RxJavaHelper.t((u6.g) getUI())).onErrorReturn(ug.d.f60584b), v7.b.a().getRewardInfo().b().compose(RxJavaHelper.t((u6.g) getUI())).onErrorReturn(ug.c.f60579b), v7.b.a().getMyCustomer().b().compose(RxJavaHelper.t((u6.g) getUI())).onErrorReturn(ug.f.f60592b), v7.b.a().getSubscribeBox().b().compose(RxJavaHelper.t((u6.g) getUI())).onErrorReturn(ug.e.f60588b), new ug.g(this)).compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new e());
    }

    public void Z(boolean z11) {
        if (z11) {
            a1();
        }
    }

    public final void Z0() {
        UserInfoData M = r.x().M();
        int i11 = 0;
        if (!(M == null || M.d() == null || M.d().isEmpty())) {
            i11 = M.d().get(0).intValue();
        }
        ((AccountService) tq.p.C(AccountService.class)).backCommissionConfig(i11, r.x().H()).compose(RxJavaHelper.t((u6.g) getUI())).compose(tq.p.c0()).onErrorResumeNext(new ug.p(this)).subscribe(new k());
    }

    public final void a1() {
        k1();
        Y0();
        a1.v().z0(false).subscribe(new BaseSubscriber());
        f0.g().i();
        f1();
        if (!r.x().F0()) {
            ((q) getUI()).ab();
            ((q) getUI()).W9((AccountKycInfo) null);
            ((q) getUI()).Z3((UnifyKycInfo) null);
            ((q) getUI()).p4((CommunityData) null);
            ((q) getUI()).ke((MyPrimeInfo) null);
            ((q) getUI()).Sb((MedalUserInfo) null);
            return;
        }
        if (!r.x().s().equals(this.f40994c)) {
            this.f40994c = r.x().s();
        }
        X0();
        Z0();
        d1();
        e1();
        if (r.x().X()) {
            ((q) getUI()).ke((MyPrimeInfo) null);
        } else {
            b1();
        }
        c1();
    }

    public final void b1() {
        v7.b.a().g0().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new f());
    }

    public final void c1() {
        v7.b.a().getMedalUserInfo().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new g());
    }

    public final void d1() {
        v7.b.a().getMyCommunityData().b().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new d());
    }

    public void e1() {
        ((q) getUI()).ab();
        NewAccountTabRedDotHelper.f().i();
    }

    public final void f1() {
        eh.h.B().compose(RxJavaHelper.t((u6.g) getUI())).subscribe(new l());
    }

    public final void g1() {
        boolean l11 = SP.l("ACCOUNT_NEW_VERSION_DOT_KEY105400", false);
        if (UpgradeUtil.c() && !l11) {
            SP.y("ACCOUNT_NEW_VERSION_DOT_KEY105400", true);
        }
        if (getActivity() instanceof HuobiMainActivity) {
            ((HuobiMainActivity) getActivity()).Jc();
        }
    }

    /* renamed from: h1 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, q qVar) {
        super.onUIReady(baseCoreActivity, qVar);
        TimeMonitorManager.a().b("huobiapp_me_end").c();
        yg.a aVar = new yg.a(((q) getUI()).a2());
        this.f40998g = aVar;
        aVar.setPosDelta(-1);
        this.f40998g.j(new Handler());
        this.f40998g.l(1001);
        ((q) getUI()).a2().setAdapter(this.f40998g);
        try {
            ((q) getUI()).a2().getViewPager().addOnPageChangeListener(new j());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        j1();
    }

    public void i1() {
        a1();
        ((q) getUI()).Pb();
    }

    public final void j1() {
        G0().subscribe(new o());
    }

    public final void k1() {
        if (r.x().F0()) {
            os.c.p(new ug.a(this));
        } else {
            l1();
        }
    }

    public final void l1() {
        H0(IndexFeature.ACCOUNT_NEW_QUICK_STR).subscribe(new m());
        H0(IndexFeature.ACCOUNT_FIXED_QUICK).subscribe(new n());
    }

    public final void m1(ViewGroup viewGroup, List<? extends s9.a> list) {
        int i11;
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.part_home_account_box_knapsack, viewGroup, false);
        viewGroup.addView(inflate);
        ArrayList arrayList = new ArrayList();
        ViewPager2 viewPager2 = (ViewPager2) inflate.findViewById(R.id.view_pager);
        og.g gVar = new og.g(arrayList);
        viewPager2.setAdapter(gVar);
        HBIndicatorView hBIndicatorView = (HBIndicatorView) inflate.findViewById(R.id.view_pager_indicator);
        hBIndicatorView.n(getResources().getDimension(R.dimen.dp_5), getResources().getDimension(R.dimen.dp_10));
        hBIndicatorView.m(getResources().getDimension(R.dimen.dp_3));
        hBIndicatorView.l(getResources().getDimension(R.dimen.dp_2));
        hBIndicatorView.j(3);
        hBIndicatorView.i(4);
        hBIndicatorView.setOrientation(0);
        int size = list.size();
        int i12 = 1;
        if (size > 4) {
            i12 = size % 4 == 0 ? size / 4 : (size / 4) + 1;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            EasyRecyclerView easyRecyclerView = new EasyRecyclerView(getActivity());
            easyRecyclerView.setNestedScrollingEnabled(false);
            easyRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            arrayList.add(easyRecyclerView);
        }
        int i14 = 0;
        while (i14 < i12) {
            ArrayList arrayList2 = new ArrayList();
            EasyRecyclerView easyRecyclerView2 = (EasyRecyclerView) arrayList.get(i14);
            int i15 = i14 * 4;
            while (true) {
                i11 = i14 + 1;
                if (i15 >= i11 * 4 || i15 >= size) {
                    easyRecyclerView2.setData(arrayList2);
                    i14 = i11;
                } else {
                    arrayList2.add((s9.a) list.get(i15));
                    i15++;
                }
            }
            easyRecyclerView2.setData(arrayList2);
            i14 = i11;
        }
        gVar.d(arrayList);
        viewPager2.invalidate();
        viewPager2.setCurrentItem(0);
        hBIndicatorView.setupWithViewPager(viewPager2);
    }

    public final void n1(AccountTaskResp accountTaskResp, View view, LinearLayout linearLayout) {
        AccountChallengeTask challengeTask = accountTaskResp.getChallengeTask();
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.part_home_account_box_challenge_task, linearLayout, true);
        ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.vpChallengeTask);
        og.c cVar = new og.c(getActivity(), challengeTask);
        viewPager.setAdapter(cVar);
        viewPager.addOnPageChangeListener(new c());
        if (this.f41004m < cVar.getCount()) {
            viewPager.setCurrentItem(this.f41004m);
        }
        HBIndicatorView hBIndicatorView = (HBIndicatorView) inflate.findViewById(R.id.vpChallengeTaskIndicator);
        hBIndicatorView.n(getResources().getDimension(R.dimen.dp_5), getResources().getDimension(R.dimen.dp_10));
        hBIndicatorView.m(getResources().getDimension(R.dimen.dp_3));
        hBIndicatorView.l(getResources().getDimension(R.dimen.dp_2));
        hBIndicatorView.j(3);
        hBIndicatorView.i(4);
        hBIndicatorView.setOrientation(0);
        hBIndicatorView.setupWithViewPager(viewPager);
        dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new ug.i(challengeTask));
    }

    public final void o1(AccountTaskResp accountTaskResp, View view, LinearLayout linearLayout) {
        AccountNewComerTask newTask = accountTaskResp.getNewTask();
        BoxNewcomerView boxNewcomerView = new BoxNewcomerView(getActivity());
        boxNewcomerView.setData(newTask);
        linearLayout.addView(boxNewcomerView);
        dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new ug.j(accountTaskResp));
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final void p1() {
        List list;
        if (this.f40997f.m() == null) {
            list = null;
        } else {
            list = this.f40997f.m().adList;
        }
        if (list == null) {
            list = new ArrayList();
        }
        this.f40998g.k(list);
        ((q) getUI()).I2(1, list.size());
        ((q) getUI()).a2().setPlayDelay(list.size() <= 1 ? Integer.MAX_VALUE : 3000);
        ((q) getUI()).a2().setAdapter(this.f40998g);
        ((q) getUI()).a2().pagerToStartMove();
        this.f40998g.notifyDataSetChanged();
    }

    public final void q1() {
        List list = (List) this.f40996e.d();
        boolean m11 = this.f40996e.m();
        if (m11) {
            if (list == null || list.isEmpty()) {
                m11 = false;
            } else {
                boolean X = r.x().X();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    IndexFeatureItem indexFeatureItem = (IndexFeatureItem) it2.next();
                    if ("费率设置".equalsIgnoreCase(indexFeatureItem.getGroupCode())) {
                        if (X) {
                            it2.remove();
                        }
                    } else if ("了解vip".equalsIgnoreCase(indexFeatureItem.getGroupCode()) && (X || os.c.l())) {
                        it2.remove();
                    }
                }
            }
        }
        ((q) getUI()).fa(m11, list);
    }

    public final void r1(List<PersonalcenterActivityInfoBean> list) {
        i6.d.b("updateActivityCenterView-start");
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.part_home_account_box1_new, this.f41000i, true);
        ((TextView) inflate.findViewById(R.id.title)).setText(R.string.n_user_center_activity);
        View inflate2 = LayoutInflater.from(getActivity()).inflate(R.layout.part_home_account_box_activity_center, (LinearLayout) inflate.findViewById(R.id.content), true);
        ViewPager viewPager = (ViewPager) inflate2.findViewById(R.id.view_pager);
        viewPager.setAdapter(new og.b(getActivity(), 2, list));
        HBIndicatorView hBIndicatorView = (HBIndicatorView) inflate2.findViewById(R.id.view_pager_indicator);
        hBIndicatorView.n(getResources().getDimension(R.dimen.dp_5), getResources().getDimension(R.dimen.dp_10));
        hBIndicatorView.m(getResources().getDimension(R.dimen.dp_3));
        hBIndicatorView.l(getResources().getDimension(R.dimen.dp_2));
        hBIndicatorView.j(3);
        hBIndicatorView.i(4);
        hBIndicatorView.setOrientation(0);
        hBIndicatorView.setupWithViewPager(viewPager);
        i6.d.b("updateActivityCenterView-end");
    }

    public void s1() {
        ((q) getUI()).I8().removeAllViews();
        this.f41000i = null;
        HashMap hashMap = new HashMap();
        for (Integer next : this.f40999h.keySet()) {
            LinearLayout linearLayout = this.f41000i;
            if (linearLayout == null || linearLayout.getChildCount() >= 3) {
                LinearLayout linearLayout2 = new LinearLayout(getActivity());
                this.f41000i = linearLayout2;
                linearLayout2.setWeightSum(2.0f);
                this.f41000i.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                ((q) getUI()).I8().addView(this.f41000i);
                i6.d.b("BoxView add linearLayout");
            }
            AccountBoxItem accountBoxItem = this.f40999h.get(next);
            hashMap.clear();
            if (next.intValue() == 0 && accountBoxItem.a() != null) {
                hashMap.put("name", "任务盒子");
                gs.g.i("box_Me_show", hashMap);
                w1(accountBoxItem.a());
            } else if (next.intValue() == 1 && accountBoxItem.b() != null && !accountBoxItem.b().isEmpty()) {
                hashMap.put("name", "活动中心");
                gs.g.i("box_Me_show", hashMap);
                r1(accountBoxItem.b());
            } else if (next.intValue() == 2 && accountBoxItem.d() != null) {
                hashMap.put("name", "专属服务经理");
                gs.g.i("box_Me_show", hashMap);
                t1(accountBoxItem.d());
            } else if (next.intValue() == 999 && accountBoxItem.c() != null) {
                hashMap.put("name", "我的工具");
                gs.g.i("box_Me_show", hashMap);
                x1(accountBoxItem.c());
            } else if (next.intValue() == 5 && accountBoxItem.e() != null) {
                hashMap.put("name", "我的背包");
                gs.g.i("box_Me_show", hashMap);
                u1(accountBoxItem.e());
            } else if (next.intValue() == 4 && accountBoxItem.f() != null) {
                hashMap.put("name", "我的预约");
                gs.g.i("box_Me_show", hashMap);
                v1(accountBoxItem.f());
            }
            if (this.f41000i.getChildCount() == 1) {
                this.f41000i.addView(new View(getActivity()), getResources().getDimensionPixelOffset(R.dimen.dimen_8), 0);
            }
        }
        if (this.f41003l) {
            TimeMonitorManager.a().b("huobiapp_me_end").a("huobiapp_me_end", OptionsBridge.NETWORK_KEY, true);
            this.f41003l = false;
        }
    }

    public final void t1(CustomerData customerData) {
        i6.d.b("updateCustomerView-start");
        this.f41006o = customerData;
        int i11 = 0;
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.part_home_account_box1_new, this.f41000i, false);
        this.f41000i.addView(inflate);
        ((TextView) inflate.findViewById(R.id.title)).setText(customerData.getTitle());
        inflate.findViewById(R.id.more).setVisibility(0);
        String url = customerData.getUrl();
        Observable<Void> a11 = dw.a.a(inflate.findViewById(R.id.titleBar));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new ug.o(this, url, customerData));
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.content);
        View inflate2 = LayoutInflater.from(getActivity()).inflate(R.layout.part_home_account_customer, linearLayout, false);
        TextView textView = (TextView) inflate2.findViewById(R.id.tv_message_count);
        this.f41001j = textView;
        textView.setText(this.f41005n + "");
        TextView textView2 = this.f41001j;
        if (this.f41005n <= 0) {
            i11 = 8;
        }
        textView2.setVisibility(i11);
        linearLayout.addView(inflate2);
        g6.b.c().j((ImageView) inflate2.findViewById(R.id.iv_content_img), customerData.getImgUrl(), R.drawable.account_customer_default_icon, g6.b.c().e(R.drawable.account_customer_default_icon), (tx.a) null);
        dw.a.a(inflate2).throttleFirst(1, timeUnit).subscribe(new ug.m(this, customerData, url));
        ((TextView) inflate2.findViewById(R.id.tv_content_name)).setText(customerData.getNameDesc());
        TextView textView3 = (TextView) inflate2.findViewById(R.id.feedback);
        this.f41002k = textView3;
        textView3.setText(customerData.getFeedback());
        TopScrollNoticeView2 topScrollNoticeView2 = (TopScrollNoticeView2) inflate2.findViewById(R.id.question_list);
        ArrayList arrayList = new ArrayList();
        for (CustomerData.ListBean next : customerData.getList()) {
            TopScrollData topScrollData = new TopScrollData();
            topScrollData.f71623a = next.getName();
            topScrollData.f71625c = next.getUrl();
            arrayList.add(topScrollData);
        }
        topScrollNoticeView2.c();
        topScrollNoticeView2.setEllipsize(TextUtils.TruncateAt.END);
        topScrollNoticeView2.setDatas(arrayList);
        if (arrayList.size() > 1) {
            topScrollNoticeView2.h();
        } else {
            topScrollNoticeView2.i();
        }
        topScrollNoticeView2.setCallback(new b());
        i6.d.b("updateCustomerView-end");
    }

    public final void u1(KnapsackItem knapsackItem) {
        i6.d.b("updateKnapsackView-start");
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.part_home_account_box1_new, this.f41000i, false);
        this.f41000i.addView(inflate);
        ((TextView) inflate.findViewById(R.id.title)).setText(knapsackItem.c());
        inflate.findViewById(R.id.more).setVisibility(0);
        ViewUtil.m(inflate.findViewById(R.id.redDot), knapsackItem.b());
        if (!TextUtils.isEmpty(knapsackItem.d())) {
            dw.a.a(inflate.findViewById(R.id.titleBar)).throttleFirst(1, TimeUnit.SECONDS).subscribe(new ug.l(knapsackItem));
        }
        m1((LinearLayout) inflate.findViewById(R.id.content), knapsackItem.a());
        i6.d.b("updateKnapsackView-end");
    }

    public final void v1(SubscribeBox.MySubscribeBean mySubscribeBean) {
        i6.d.b("updateSubscribeBoxView-start");
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.part_home_account_box1_new, this.f41000i, false);
        this.f41000i.addView(inflate);
        ((TextView) inflate.findViewById(R.id.title)).setText(mySubscribeBean.getTitle());
        inflate.findViewById(R.id.more).setVisibility(0);
        if (!TextUtils.isEmpty(mySubscribeBean.getRedirect())) {
            dw.a.a(inflate.findViewById(R.id.titleBar)).throttleFirst(1, TimeUnit.SECONDS).subscribe(new ug.k(mySubscribeBean));
        }
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.content);
        linearLayout.setOrientation(1);
        linearLayout.setWeightSum(2.0f);
        for (int i11 = 0; i11 < Math.min(2, mySubscribeBean.getList().size()); i11++) {
            SubscribeBox.ListBean listBean = mySubscribeBean.getList().get(i11);
            View inflate2 = LayoutInflater.from(getActivity()).inflate(R.layout.part_home_account_box_subscribe, (ViewGroup) null, false);
            linearLayout.addView(inflate2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
            CountDownLayout countDownLayout = (CountDownLayout) inflate2.findViewById(R.id.item_time_view);
            countDownLayout.post(new p(countDownLayout, listBean));
            ((TextView) inflate2.findViewById(R.id.title)).setText(listBean.getTitle());
            ((TextView) inflate2.findViewById(R.id.name)).setText(listBean.getName());
            View findViewById = inflate2.findViewById(R.id.redDot);
            if (listBean.getInfoSum() == -1) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            RoundTextView roundTextView = (RoundTextView) inflate2.findViewById(R.id.about_to_begin);
            if (TextUtils.isEmpty(listBean.getAboutToBegin())) {
                roundTextView.setVisibility(8);
            } else {
                roundTextView.setVisibility(0);
                roundTextView.setText(listBean.getAboutToBegin());
            }
            if (i11 >= 1) {
                inflate2.findViewById(R.id.line).setVisibility(8);
            }
            if (!TextUtils.isEmpty(listBean.getUrl())) {
                dw.a.a(inflate2).throttleFirst(1, TimeUnit.SECONDS).subscribe(new ug.n(this, mySubscribeBean, listBean, findViewById));
            }
        }
        i6.d.b("updateSubscribeBoxView-end");
    }

    public final void w1(AccountTaskResp accountTaskResp) {
        i6.d.b("updateTaskBoxView-start");
        if (accountTaskResp.getNewTask() != null || accountTaskResp.getChallengeTask() != null) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.part_account_task_box_top, this.f41000i, true);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.taskBoxContent);
            ((TextView) inflate.findViewById(R.id.taskBoxTitle)).setText(accountTaskResp.getTitleName());
            if (accountTaskResp.getNewTask() != null) {
                i6.d.b("showNewcomerTaskView()");
                o1(accountTaskResp, inflate, linearLayout);
            } else if (accountTaskResp.getChallengeTask() != null) {
                i6.d.b("showChallengeTaskView()");
                n1(accountTaskResp, inflate, linearLayout);
            }
            i6.d.b("updateTaskBoxView-end");
        }
    }

    public final void x1(BoxToolRespBean boxToolRespBean) {
        i6.d.b("updateToolsView-start");
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.part_home_account_box1_new, this.f41000i, false);
        this.f41000i.addView(inflate);
        ((TextView) inflate.findViewById(R.id.title)).setText(boxToolRespBean.b());
        m1((LinearLayout) inflate.findViewById(R.id.content), boxToolRespBean.a());
        i6.d.b("updateToolsView-end");
    }
}
