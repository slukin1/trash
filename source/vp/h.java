package vp;

import com.huobi.otc.widget.CouponItem;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CouponItem f61145b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61146c;

    public /* synthetic */ h(CouponItem couponItem, String str) {
        this.f61145b = couponItem;
        this.f61146c = str;
    }

    public final void run() {
        this.f61145b.q(this.f61146c);
    }
}
