package vp;

import com.huobi.otc.widget.CouponReturnItem;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CouponReturnItem f61152b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61153c;

    public /* synthetic */ k(CouponReturnItem couponReturnItem, String str) {
        this.f61152b = couponReturnItem;
        this.f61153c = str;
    }

    public final void run() {
        this.f61152b.k(this.f61153c);
    }
}
