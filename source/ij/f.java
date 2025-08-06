package ij;

import com.huobi.coupon.handler.CouponExperienceRequestHelper;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CouponExperienceRequestHelper f55099b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CouponExperienceRequestHelper.c f55100c;

    public /* synthetic */ f(CouponExperienceRequestHelper couponExperienceRequestHelper, CouponExperienceRequestHelper.c cVar) {
        this.f55099b = couponExperienceRequestHelper;
        this.f55100c = cVar;
    }

    public final void run() {
        this.f55099b.lambda$checkCoupon$6(this.f55100c);
    }
}
