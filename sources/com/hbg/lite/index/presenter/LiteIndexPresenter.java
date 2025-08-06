package com.hbg.lite.index.presenter;

import ab.h;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.TeachConfigItem;
import com.hbg.lib.network.otc.core.bean.MarketMergedInfo;
import com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo;
import com.hbg.lib.network.otc.core.bean.UserAssetLimitBean;
import com.hbg.lib.network.php.core.bean.ZendeskTopNotice;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lite.R$string;
import com.hbg.lite.index.bean.LiteHomeActivityEntity;
import com.hbg.lite.index.bean.LiteIndexBannerTopNoticeModel;
import com.hbg.lite.index.bean.LiteIndexChatTutorialModel;
import com.hbg.lite.index.bean.LiteIndexMarketItem;
import com.hbg.lite.index.bean.ReminderData;
import com.hbg.lite.network.LiteRequestCallback1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import rx.Observable;
import rx.Subscription;

public class LiteIndexPresenter extends BaseFragmentPresenter<g> {

    /* renamed from: c  reason: collision with root package name */
    public final List<s9.a> f77083c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public LiteIndexBannerTopNoticeModel f77084d;

    /* renamed from: e  reason: collision with root package name */
    public LiteIndexChatTutorialModel f77085e;

    /* renamed from: f  reason: collision with root package name */
    public final List<LiteIndexMarketItem> f77086f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final List<LiteIndexMarketItem> f77087g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List<MarketMergedInfo> f77088h;

    /* renamed from: i  reason: collision with root package name */
    public MarketMergedInfo f77089i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f77090j;

    /* renamed from: k  reason: collision with root package name */
    public final Set<Integer> f77091k = new HashSet();

    /* renamed from: l  reason: collision with root package name */
    public c6.b f77092l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f77093m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f77094n = true;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: o  reason: collision with root package name */
    public final Handler f77095o = new a();

    /* renamed from: p  reason: collision with root package name */
    public final Map<String, List<String>> f77096p = new HashMap();

    /* renamed from: q  reason: collision with root package name */
    public Subscription f77097q;

    /* renamed from: r  reason: collision with root package name */
    public za.a f77098r = new b();

    /* renamed from: s  reason: collision with root package name */
    public c6.b<Boolean> f77099s = new ab.a(this);

    /* renamed from: t  reason: collision with root package name */
    public LiteIndexMarketItem.a f77100t = new e();

    public class a extends Handler {
        public a() {
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                LiteIndexPresenter.this.N0();
            }
        }
    }

    public class b implements za.a {
        public b() {
        }

        public void a(TopScrollData topScrollData) {
            if (topScrollData != null) {
                ra.c.a().a(LiteIndexPresenter.this.getActivity(), topScrollData.j(), LiteIndexPresenter.this.getResources().getString(R$string.announcement), LiteIndexPresenter.this.getResources().getString(R$string.head_return), false);
            }
        }

        public void b() {
            ra.c.b().h(LiteIndexPresenter.this.getActivity());
        }

        public void c(TeachConfigItem teachConfigItem) {
            ra.c.c().l("182", (Map<String, Object>) null);
            ra.c.b().c(LiteIndexPresenter.this.getActivity(), teachConfigItem.getVideoUrl(), LiteIndexPresenter.this.getResources().getString(R$string.lite_index_video_tutorial));
        }
    }

    public class c extends LiteRequestCallback1<ZendeskTopNotice> {
        public c() {
        }

        /* renamed from: b */
        public void onRequestSuccess(ZendeskTopNotice zendeskTopNotice) {
            LiteIndexPresenter.this.f77084d.g(zendeskTopNotice);
            ((g) LiteIndexPresenter.this.getUI()).xf(LiteIndexPresenter.this.f77084d);
        }

        public void onRequestFailure(Throwable th2) {
        }

        public void onRequestStart() {
        }
    }

    public class d extends LiteRequestCallback1<List<MarketMergedInfo>> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f77104a;

        public d() {
        }

        public final void b() {
            if (((g) LiteIndexPresenter.this.getUI()).isAlive()) {
                LiteIndexPresenter.this.f77095o.removeMessages(1);
                LiteIndexPresenter.this.f77095o.sendEmptyMessageDelayed(1, 5000);
            }
        }

        /* renamed from: c */
        public void onRequestSuccess(List<MarketMergedInfo> list) {
            if (this.f77104a) {
                i6.d.e("showContent", "onRequestSuccess");
                LiteIndexPresenter.this.U0();
            }
            b();
        }

        /* renamed from: d */
        public List<MarketMergedInfo> onRequestSuccessAsync(List<MarketMergedInfo> list) {
            i6.d.b("requestMarketMergedList-->" + list.size());
            if (!CollectionsUtils.b(list)) {
                int i11 = 0;
                while (true) {
                    if (i11 < list.size()) {
                        if (list.get(i11) != null && list.get(i11).getCoinId() == 1) {
                            MarketMergedInfo unused = LiteIndexPresenter.this.f77089i = list.get(i11);
                            list.remove(i11);
                            break;
                        }
                        i11++;
                    } else {
                        break;
                    }
                }
            }
            List unused2 = LiteIndexPresenter.this.f77088h = list;
            this.f77104a = LiteIndexPresenter.this.w0();
            return list;
        }

        public void onRequestFailure(Throwable th2) {
            b();
            if (CollectionsUtils.b(LiteIndexPresenter.this.f77086f)) {
                LiteIndexPresenter.this.R0();
            }
        }
    }

    public class e implements LiteIndexMarketItem.a {
        public e() {
        }

        public void a(LiteIndexMarketItem liteIndexMarketItem) {
            if (!ViewUtil.c(300)) {
                nb.c.f(LiteIndexPresenter.this.getActivity(), String.valueOf(liteIndexMarketItem.getMarketMergedInfo().getCurrencyId()), String.valueOf(liteIndexMarketItem.getMarketMergedInfo().getCoinId()), true);
                try {
                    HashMap hashMap = new HashMap(1);
                    hashMap.put(FirebaseAnalytics.Param.CURRENCY, liteIndexMarketItem.getShortName().toLowerCase(Locale.US));
                    hashMap.put("marketcard", Integer.valueOf(LiteIndexPresenter.this.f77086f.indexOf(liteIndexMarketItem) + 1));
                    ra.c.c().l("179", hashMap);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public class f extends BaseSubscriber<UserAssetLimitBean> {
        public f() {
        }

        /* renamed from: a */
        public void onNext(UserAssetLimitBean userAssetLimitBean) {
            super.onNext(userAssetLimitBean);
            ((g) LiteIndexPresenter.this.getUI()).ng(userAssetLimitBean);
        }

        public void onError(Throwable th2) {
            ((g) LiteIndexPresenter.this.getUI()).ng((UserAssetLimitBean) null);
        }
    }

    public interface g extends u6.g {
        void F8(boolean z11);

        void Fa();

        void Fb(LiteIndexChatTutorialModel liteIndexChatTutorialModel);

        void J0();

        void Le(MarketMergedInfo marketMergedInfo);

        void Pd();

        void Rf();

        void X6();

        void Z1(boolean z11);

        void ih();

        void je();

        void lh(za.a aVar);

        void mb();

        void ng(UserAssetLimitBean userAssetLimitBean);

        void tc(List<s9.a> list);

        void v7(ReminderData reminderData);

        void xf(LiteIndexBannerTopNoticeModel liteIndexBannerTopNoticeModel);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable C0(Boolean bool) {
        if (bool.booleanValue()) {
            if (TextUtils.isEmpty(ra.c.c().c())) {
                return ra.c.c().x().compose(RxJavaHelper.t((u6.g) getUI())).onErrorResumeNext(ab.g.f3514b).doOnNext(ab.d.f3510b);
            }
            Observable.just("");
        }
        return Observable.just("");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable D0(int i11, String str) {
        return s8.a.a().o(va.b.d(i11), va.b.l(sa.a.c()), "buy", "fast").b().compose(RxJavaHelper.t((u6.g) getUI()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E0(Boolean bool) {
        ((g) getUI()).F8(bool.booleanValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F0(ReminderData reminderData) {
        i6.d.i("#LiteIndex#OtcReminderData=" + reminderData);
        ((g) getUI()).v7(reminderData);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G0(Object obj) {
        Q0();
        this.f77092l = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H0(List list) {
        this.f77093m = !CollectionsUtils.b(list);
        this.f77084d.f(list);
        ((g) getUI()).xf(this.f77084d);
        ((g) getUI()).Rf();
    }

    public final void I0() {
    }

    /* renamed from: J0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, g gVar) {
        super.onUIReady(baseCoreActivity, gVar);
        z0(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LiteHomeActivityEntity());
        LiteIndexBannerTopNoticeModel liteIndexBannerTopNoticeModel = new LiteIndexBannerTopNoticeModel();
        this.f77084d = liteIndexBannerTopNoticeModel;
        liteIndexBannerTopNoticeModel.f(arrayList);
        ((g) getUI()).xf(this.f77084d);
        LiteIndexChatTutorialModel liteIndexChatTutorialModel = new LiteIndexChatTutorialModel();
        this.f77085e = liteIndexChatTutorialModel;
        liteIndexChatTutorialModel.d(true);
        ((g) getUI()).tc(this.f77083c);
        U0();
        ((g) getUI()).lh(this.f77098r);
        ra.c.c().r(new h(this));
        ra.c.c().B(this.f77099s);
    }

    public void K0(boolean z11) {
        if (L0(z11)) {
            U0();
        }
        if (z11) {
            ((g) getUI()).Z1(true);
        }
    }

    public final boolean L0(boolean z11) {
        this.f77095o.removeMessages(1);
        if (!NetworkStatus.c(getActivity())) {
            HuobiToastUtil.j(R$string.server_error);
            U0();
            return false;
        }
        M0();
        P0();
        y0(1);
        if (z11) {
            ra.c.c().F();
        }
        if (ra.c.c().m(1) == null) {
            if (this.f77092l == null) {
                this.f77092l = new ab.c(this);
            }
            ra.c.c().i(this.f77092l);
        } else {
            Q0();
        }
        ((g) getUI()).v7(ra.c.c().A());
        return true;
    }

    public final void M0() {
        ra.c.a().d(getActivity(), (u6.g) getUI(), new ab.b(this));
    }

    public void N0() {
        if (((g) getUI()).isAlive()) {
            if (!NetworkStatus.c(getActivity())) {
                this.f77095o.removeMessages(1);
                this.f77095o.sendEmptyMessageDelayed(1, 5000);
                return;
            }
            String l11 = va.b.l(sa.a.c());
            s8.b a11 = s8.a.a();
            if (TextUtils.isEmpty(l11)) {
                l11 = "cny";
            }
            a11.getMarketMergedList(l11, "0", "").d(new d());
        }
    }

    public void O0() {
    }

    public final void P0() {
        ra.c.a().b(new c());
    }

    public final void Q0() {
        TeachConfigItem m11 = ra.c.c().m(1);
        if (m11 != null && !TextUtils.isEmpty(m11.getVideoUrl())) {
            this.f77085e.e(m11);
        }
        ((g) getUI()).Fb(this.f77085e);
    }

    public final void R0() {
        if (!this.f77093m) {
            ((g) getUI()).Fa();
        }
        ((g) getUI()).je();
    }

    public final void S0() {
        Subscription subscription = this.f77097q;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    public final void T0() {
        if (this.f77089i != null) {
            ((g) getUI()).Le(this.f77089i);
        }
    }

    public void U0() {
        this.f77083c.clear();
        if (!this.f77086f.isEmpty()) {
            ((g) getUI()).Pd();
            this.f77083c.addAll(this.f77086f);
            ((g) getUI()).X6();
        } else if (!NetworkStatus.c(getActivity())) {
            R0();
        } else {
            ((g) getUI()).Pd();
            ((g) getUI()).ih();
            ((g) getUI()).mb();
        }
        T0();
        ((g) getUI()).J0();
    }

    public void V() {
        super.V();
        ra.c.c().r((ya.a) null);
    }

    public void Z(boolean z11) {
        super.Z(z11);
        this.f77084d.e(z11);
        if (z11) {
            L0(false);
            ((g) getUI()).F8(ra.c.c().o());
            if (!this.f77094n) {
                ra.c.c().G();
            } else {
                this.f77094n = false;
            }
        } else {
            this.f77095o.removeCallbacksAndMessages((Object) null);
        }
        if (z11) {
            I0();
        } else {
            S0();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ra.c.c().t(this.f77099s);
    }

    public final boolean w0() {
        if (this.f77088h == null || !this.f77090j) {
            return false;
        }
        boolean isChineseLanguage = AppLanguageHelper.getInstance().isChineseLanguage();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 < this.f77088h.size()) {
                MarketMergedInfo marketMergedInfo = this.f77088h.get(i11);
                LiteIndexMarketItem liteIndexMarketItem = new LiteIndexMarketItem();
                liteIndexMarketItem.setMarketMergedInfo(marketMergedInfo);
                List list = this.f77096p.get(String.valueOf(marketMergedInfo.getCoinId()));
                if (list == null) {
                    list = new ArrayList();
                    this.f77096p.put(String.valueOf(marketMergedInfo.getCoinId()), list);
                }
                List<String> merged = marketMergedInfo.getMerged();
                if (merged != null && !merged.isEmpty()) {
                    list.clear();
                    list.addAll(merged);
                }
                OtcMarketCoinInfo.CoinInfo s11 = va.b.s(marketMergedInfo.getCoinId());
                if (s11 != null) {
                    liteIndexMarketItem.setName(s11.getFullName());
                    liteIndexMarketItem.setShortName(s11.getShortName());
                    liteIndexMarketItem.setDetailList(new ArrayList(list));
                    liteIndexMarketItem.setCallback(this.f77100t);
                    liteIndexMarketItem.setChinese(isChineseLanguage);
                    liteIndexMarketItem.setFast(i11 == 0);
                    if (i11 == this.f77088h.size() - 1) {
                        z11 = false;
                    }
                    liteIndexMarketItem.setShowDivider(z11);
                    arrayList.add(liteIndexMarketItem);
                }
                i11++;
            } else {
                this.f77086f.clear();
                this.f77086f.addAll(arrayList);
                return true;
            }
        }
    }

    public List<String> x0() {
        ArrayList arrayList = new ArrayList();
        if (va.b.o().r() != null) {
            CollectionsUtils.b(va.b.o().r().getCurrencyBeans());
        }
        return arrayList;
    }

    public void y0(int i11) {
        Observable.just(Boolean.valueOf(ra.c.c().p())).concatMap(new ab.e(this)).concatMap(new ab.f(this, i11)).subscribe(new f());
    }

    public void z0(boolean z11) {
    }
}
