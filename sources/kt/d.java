package kt;

import android.content.Context;
import com.huobi.trade.ui.coupon.CouponLayout;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CouponLayout f57991b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f57992c;

    public /* synthetic */ d(CouponLayout couponLayout, Context context) {
        this.f57991b = couponLayout;
        this.f57992c = context;
    }

    public final void call(Object obj) {
        this.f57991b.f(this.f57992c, (Void) obj);
    }
}
