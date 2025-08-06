package ij;

import android.app.Activity;
import com.huobi.coupon.handler.CouponExperienceRequestHelper;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CouponExperienceRequestHelper f55097b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f55098c;

    public /* synthetic */ e(CouponExperienceRequestHelper couponExperienceRequestHelper, Activity activity) {
        this.f55097b = couponExperienceRequestHelper;
        this.f55098c = activity;
    }

    public final void run() {
        this.f55097b.lambda$checkContractTabGuide$4(this.f55098c);
    }
}
