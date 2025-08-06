package com.huobi.coupon.handler;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroPositionNoticeBean;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.libkt.utils.f;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.coupon.bean.CouponReturnContainer;
import com.huobi.coupon.service.CouponService;
import com.huobi.main.ui.HuobiMainActivity;
import com.xiaomi.mipush.sdk.Constants;
import i6.i;
import ij.e;
import ij.h;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import rx.Observable;
import rx.Subscription;
import tg.r;
import u6.g;

public final class CouponExperienceRequestHelper implements Serializable {
    private static CouponExperienceRequestHelper mInstance = new CouponExperienceRequestHelper();
    private boolean isCheckContractTabGuide = false;
    public boolean mContractTabRedVisible;
    /* access modifiers changed from: private */
    public Set<String> mCurrentCouponSets;
    private Subscription mIntervalSubscription;
    private Map<String, Object> postParams;
    /* access modifiers changed from: private */
    public long recentExpirationDate = -1;
    private boolean swapZeroHasCheck = false;

    public class a extends EasySubscriber<CouponReturnContainer> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f43745b;

        public a(d dVar) {
            this.f43745b = dVar;
        }

        /* renamed from: a */
        public void onNext(CouponReturnContainer couponReturnContainer) {
            super.onNext(couponReturnContainer);
            List<CouponReturn> coupons = couponReturnContainer.getCoupons();
            if (coupons != null && !coupons.isEmpty()) {
                long unused = CouponExperienceRequestHelper.this.recentExpirationDate = coupons.get(coupons.size() - 1).getValidAt();
            }
            Set unused2 = CouponExperienceRequestHelper.this.mCurrentCouponSets = CouponExperienceRequestHelper.getInstance().getCouponSets(coupons);
            String d11 = ConfigPreferences.d("user_config", "config_linear_swap_coupon_red_ids" + r.x().J());
            CouponExperienceRequestHelper couponExperienceRequestHelper = CouponExperienceRequestHelper.this;
            couponExperienceRequestHelper.onContractTabRedChange(couponExperienceRequestHelper.hasNewCouponId(d11));
            CouponExperienceRequestHelper.this.checkContractTabGuide();
            d dVar = this.f43745b;
            if (dVar != null) {
                dVar.onResult(coupons);
            }
        }

        public void onError2(Throwable th2) {
            i6.d.g(th2);
        }
    }

    public class b extends BaseSubscriber<ActivityZeroPositionNoticeBean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f43747b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f43748c;

        public b(Activity activity, c cVar) {
            this.f43747b = activity;
            this.f43748c = cVar;
        }

        public static /* synthetic */ Unit b(c cVar, int i11) {
            cVar.onComplete();
            v7.b.a().activityZeroNoticeSure(i11).b().compose(RxJavaHelper.t((g) null)).subscribe(new BaseSubscriber());
            return null;
        }

        /* renamed from: c */
        public void onNext(ActivityZeroPositionNoticeBean activityZeroPositionNoticeBean) {
            super.onNext(activityZeroPositionNoticeBean);
            int intValue = (activityZeroPositionNoticeBean == null || activityZeroPositionNoticeBean.getNoticeType() == null) ? 0 : activityZeroPositionNoticeBean.getNoticeType().intValue();
            View findViewById = this.f43747b.findViewById(R.id.main_contract_cb);
            if (findViewById == null || !(1 == intValue || 2 == intValue)) {
                this.f43748c.onComplete();
            } else {
                f.d(this.f43747b, 1 == intValue ? R.string.n_zero_swap_position_be_claimed_tips : R.string.n_zero_swap_position_upper_limit_tips, findViewById, Integer.valueOf(R.drawable.icon_swap_zero_gift), new h(this.f43748c, intValue));
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            this.f43748c.onComplete();
        }
    }

    public interface c {
        void onComplete();
    }

    public interface d {
        void onResult(List<CouponReturn> list);
    }

    private CouponExperienceRequestHelper() {
        HashMap hashMap = new HashMap(2);
        this.postParams = hashMap;
        hashMap.put("state", 0);
        this.postParams.put("types", CouponReturn.TYPE_EXPERIENCE);
    }

    private void checkCoupon(c cVar) {
        if (hasNewCouponId(ConfigPreferences.d("user_config", "config_linear_swap_coupon_bubble_ids" + r.x().J()))) {
            i.b().g(new ij.f(this, cVar), 300);
        } else {
            cVar.onComplete();
        }
    }

    private void checkSwapZero(Activity activity, c cVar) {
        v7.b.a().activityZeroPositionNotice().b().compose(RxJavaHelper.t((g) null)).subscribe(new b(activity, cVar));
    }

    public static CouponExperienceRequestHelper getInstance() {
        return mInstance;
    }

    /* access modifiers changed from: private */
    public boolean hasNewCouponId(String str) {
        if (CollectionsUtils.b(this.mCurrentCouponSets)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        HashSet hashSet = new HashSet(this.mCurrentCouponSets);
        hashSet.removeAll(Arrays.asList(str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
        if (hashSet.size() > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$checkContractTabGuide$1() {
        this.isCheckContractTabGuide = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$checkContractTabGuide$2() {
        this.isCheckContractTabGuide = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$checkContractTabGuide$3() {
        this.swapZeroHasCheck = true;
        checkCoupon(new ij.c(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$checkContractTabGuide$4(Activity activity) {
        if (this.swapZeroHasCheck) {
            checkCoupon(new ij.b(this));
        } else {
            checkSwapZero(activity, new ij.a(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$checkCoupon$5(c cVar) {
        ConfigPreferences.m("user_config", "config_linear_swap_coupon_bubble_ids" + r.x().J(), getCouponIds(this.mCurrentCouponSets));
        cVar.onComplete();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$checkCoupon$6(c cVar) {
        Activity b11 = oa.a.g().b();
        if (b11 == null || b11.isDestroyed() || !(oa.a.g().b() instanceof HuobiMainActivity) || !r.x().F0()) {
            cVar.onComplete();
            return;
        }
        View findViewById = b11.findViewById(R.id.main_contract_cb);
        if (findViewById != null) {
            f.d(b11, R.string.n_contract_tab_cross_coupon_guide, findViewById, Integer.valueOf(R.drawable.icon_swap_zero_gift), new ij.d(this, cVar));
        } else {
            cVar.onComplete();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$requestCouponExperience$0(Long l11) {
        getUserCoupons((d) null);
    }

    public void checkContractTabGuide() {
        Activity b11 = oa.a.g().b();
        if (b11 != null && !b11.isDestroyed() && (oa.a.g().b() instanceof HuobiMainActivity) && r.x().F0() && !this.isCheckContractTabGuide) {
            this.isCheckContractTabGuide = true;
            b11.getWindow().getDecorView().postDelayed(new e(this, b11), 1000);
        }
    }

    public String getCouponIds(List<CouponReturn> list) {
        return !CollectionsUtils.b(list) ? getCouponIds(getCouponSets(list)) : "";
    }

    public Set<String> getCouponSets(List<CouponReturn> list) {
        if (CollectionsUtils.b(list)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (CouponReturn next : list) {
            if (next != null) {
                hashSet.add(String.valueOf(next.getId()));
            }
        }
        return hashSet;
    }

    public void getUserCoupons(d dVar) {
        ((CouponService) HbgRetrofit.request(CouponService.class)).getReturnCoupon(this.postParams).compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) null)).subscribe(new a(dVar));
    }

    public String getValidData() {
        long currentTimeMillis = this.recentExpirationDate - System.currentTimeMillis();
        if (currentTimeMillis > 0) {
            return String.valueOf((((currentTimeMillis / 1000) / 60) / 60) / 24);
        }
        return null;
    }

    public void onContractTabRedChange(boolean z11) {
        this.mContractTabRedVisible = z11;
        EventBus.d().k(getInstance());
    }

    public void onProTokenUpdate(String str) {
        this.mCurrentCouponSets = null;
        this.mContractTabRedVisible = false;
        requestCouponExperience();
    }

    public void requestCouponExperience() {
        stopCouponExperienceLoop();
        if (!r.x().F0()) {
            this.mCurrentCouponSets = null;
            onContractTabRedChange(false);
            return;
        }
        this.mIntervalSubscription = Observable.interval(0, 15, TimeUnit.MINUTES).doOnNext(new ij.g(this)).subscribe(new BaseSubscriber());
    }

    public void stopCouponExperienceLoop() {
        Subscription subscription = this.mIntervalSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mIntervalSubscription.unsubscribe();
        }
        this.mIntervalSubscription = null;
    }

    public Observable<Object> trailVoucher(List<String> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("ids", list);
        return ((CouponService) HbgRetrofit.request(CouponService.class)).trailVoucher(hashMap).compose(HbgRetrofit.e()).compose(RxJavaHelper.t((g) null));
    }

    public String getCouponIds(Set<String> set) {
        if (CollectionsUtils.b(set)) {
            return "";
        }
        Iterator<String> it2 = set.iterator();
        if (!it2.hasNext()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            sb2.append(it2.next());
            if (!it2.hasNext()) {
                return sb2.toString();
            }
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
