package vp;

import android.view.View;
import com.huobi.coupon.bean.Coupon;
import com.huobi.otc.widget.CouponItem;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CouponItem f61136b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Coupon f61137c;

    public /* synthetic */ d(CouponItem couponItem, Coupon coupon) {
        this.f61136b = couponItem;
        this.f61137c = coupon;
    }

    public final void onClick(View view) {
        this.f61136b.t(this.f61137c, view);
    }
}
